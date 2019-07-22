package com.wrial.art5_view.config;
/*
 * @Author  Wrial
 * @Date Created in 16:40 2019/7/20
 * @Description 代替xml的配置类
 * 并且可以通过WebMvcConfig配置一些组件
 * （在SpringBoot2.x淘汰了WebMvcConfigAdapter因为WebMvcConfig接口可以有默认方法,可以根据需要选择组件）
 */

/*
        @Configuration
        @ConditionalOnWebApplication(type = Type.SERVLET)
        @ConditionalOnClass({ Servlet.class, DispatcherServlet.class, WebMvcConfigurer.class })
        @ConditionalOnMissingBean(WebMvcConfigurationSupport.class)
        @AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE + 10)
        @AutoConfigureAfter({ DispatcherServletAutoConfiguration.class, TaskExecutionAutoConfiguration.class,
                ValidationAutoConfiguration.class })
        public class WebMvcAutoConfiguration


        EnableWebMvc会让自动配置失效，它需要对SpringWebMvc完全配置
        因为它会Import一个DelegatingWebMvcConfiguration.class是WebMvcConfigurationSupport的一个子类
        所以就不满足自动装配的条件了

 */

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

@Configuration
//@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

//
//    <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
//        <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
//        <property name="prefix" value="/WEB-INF/jsp/"/>
//        <property name="suffix" value=".jsp"/>
//    </bean>

    /*
    可以完全替代xml配置方式,在SpringBoot中可以使用外部化配置来更好的提高弹性，这是JSP的Resolver
     */

    /*
      在ThymeleafAutoConfiguration中的ThymeleafViewResolver这个Bean里对Order有设置，因此如果要设置jsp优先的话，需要根据Order来调整
      @Bean
			@ConditionalOnMissingBean(name = "thymeleafViewResolver")
			    xxxxx
				resolver.setOrder(Ordered.LOWEST_PRECEDENCE - 5);
			    xxxx
			}

	 jsp的Resolver默认是最低
     */
    @Bean
    public ViewResolver myViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        resolver.setOrder(Ordered.LOWEST_PRECEDENCE - 10);
        resolver.setContentType("text/html;charset=UTF-8");
        return resolver;
    }


    //使用favorxx会在构建的时候加入策略，比如favorParameter会默认去读一个format的参数
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorParameter(true)
                .favorPathExtension(true);
    }


    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> customizer() {
        return (factory) -> {
            factory.addContextCustomizers((context) -> {

                        String relativePath = "art5_view\\src\\main\\webapp";
                        // 相对于 user.dir = E:\IDEA\springboot2\
                        File docBaseFile = new File(relativePath);
                        if(docBaseFile.exists()) { // 路径是否存在
                            // 解决 Maven 多模块 JSP 无法读取的问题
                            context.setDocBase(docBaseFile.getAbsolutePath());
                        }
                    }
            );
        };
    }

    /*
    比如可以实现自定义的拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                System.out.println("使用WebMvcConfiger自定义Interceptor");
                return true;
            }
        });

    }


}

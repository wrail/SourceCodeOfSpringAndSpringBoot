package com.wrial.web.config;
/*
 * @Author  Wrial
 * @Date Created in 16:40 2019/7/20
 * @Description 代替xml的配置类
 * 并且可以通过WebMvcConfig配置一些组件
 * （在SpringBoot2.x淘汰了WebMvcConfigAdapter因为WebMvcConfig接口可以有默认方法,可以根据需要选择组件）
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

//
//    <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
//        <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
//        <property name="prefix" value="/WEB-INF/jsp/"/>
//        <property name="suffix" value=".jsp"/>
//    </bean>

    /*
    可以完全替代xml配置方式
     */
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
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

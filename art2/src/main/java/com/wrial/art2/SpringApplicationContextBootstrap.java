package com.wrial.art2;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Spring 应用上下文 引导类
 *
 * @author Wrial
 */
@SpringBootApplication
public class SpringApplicationContextBootstrap {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new SpringApplicationBuilder(SpringApplicationContextBootstrap.class)
//                .web(WebApplicationType.NONE)
                .run(args);

        System.out.println("ConfigurableApplicationContext 类型：" + context.getClass().getName());
        System.out.println("Environment 类型：" + context.getEnvironment().getClass().getName());

        // 关闭上下文
        context.close();
    }
}

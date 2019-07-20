package com.wrail.art1.bootStrap;

/*
 * @Author  Wrial
 * @Date Created in 13:37 2019/7/18
 * @Description 自定义Condition的启动类
 */

import com.wrail.art1.condition.ConditionalOnSystemProperty;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

public class ConditionOnSystemPropertyBootstrap {


    @Bean
    @ConditionalOnSystemProperty(name = "name", value = "Wrial")
    public String helloWorld() {
        return "hello Wrial！";
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(ConditionOnSystemPropertyBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        String helloWorld = applicationContext.getBean("helloWorld", String.class);
        System.out.println(helloWorld);

        applicationContext.close();
    }
}

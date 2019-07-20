package com.wrail.art1.bootStrap;
/*
 * @Author  Wrial
 * @Date Created in 16:24 2019/7/18
 * @Description EnableAutoConfiguration的引导类
 */

import com.wrail.art1.condition.ConditionalOnSystemProperty;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@EnableAutoConfiguration
public class EnableAutoConfigurationBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableAutoConfigurationBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        String helloWorld = context.getBean("helloWorld",String.class);
        System.out.println(helloWorld);

        context.close();
    }

}

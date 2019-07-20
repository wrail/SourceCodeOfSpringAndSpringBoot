package com.wrail.art1;

import com.wrail.art1.annotation.EnableHelloWorld;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;

//EnableHelloWorld自定义注解通过Import导入自定义的Bean
@EnableHelloWorld

@SpringBootApplication
public class Art1Application {

    public static void main(String[] args) {

        /*
         * 下面这些就称之为Fluent API
         * */
//      等价于SpringApplication.run(Art1Application.class,args);
        new SpringApplicationBuilder(Art1Application.class)
                //可以选择Web类型，可以为none，servlet，reactive等等
                .web(WebApplicationType.NONE)

                .run(args);

    }

}

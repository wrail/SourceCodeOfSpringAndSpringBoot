package com.wrail.art1.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class HelloWorldConfiguration {


    @Bean
    public String helloWorld() {
//        System.out.println("hello world!");
        return "自定义的HelloWorld Bean已经被装配";
    }


}

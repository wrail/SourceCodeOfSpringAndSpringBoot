package com.wrial.bootWebMvc.bootstrap;
/*
 * @Author  Wrial
 * @Date Created in 14:02 2019/7/21
 * @Description SpringBootWebMvc引导类
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.wrial.bootWebMvc")
public class SpringBootWebMvcBootstrap {

    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(SpringBootWebMvcBootstrap.class);
        springApplication.run(args);
    }

}

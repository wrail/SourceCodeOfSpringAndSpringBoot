package com.wrial.art6_rest.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * @Author  Wrial
 * @Date Created in 22:11 2019/7/22
 * @Description
 */
@SpringBootApplication(scanBasePackages= "com.wrial.art6_rest")
public class SpringBootRestBootStrap {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestBootStrap.class, args);
    }

}

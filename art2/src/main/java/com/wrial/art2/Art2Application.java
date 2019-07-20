package com.wrial.art2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

public class Art2Application {

    public static void main(String[] args) {
//        SpringApplication.run(Art2Application.class, args);

        Set<String> sources = new HashSet<>();
        sources.add(SpringApplicationBootStrap.class.getName());
        SpringApplication springApplication = new SpringApplication();
        springApplication.setSources(sources);
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);

    }

    /*
        必须要加static
     */
    @SpringBootApplication
    public static class SpringApplicationBootStrap{

    }

}

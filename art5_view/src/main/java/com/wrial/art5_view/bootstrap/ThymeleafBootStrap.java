package com.wrial.art5_view.bootstrap;
/*
 * @Author  Wrial
 * @Date Created in 0:46 2019/7/22
 * @Description Thymeleaf启动类
 */

import org.springframework.boot.SpringApplication;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

public class ThymeleafBootStrap {

    public static void main(String[] args) {

        //构建引擎
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();

        //渲染上下文
        Context context = new Context();
        context.setVariable("message", "Hello Wrial!");

        //模板内容
        String content = "<p th:text =\"${message}\">****</p>";

        //使用模板引擎进行处理
        String result = springTemplateEngine.process(content, context);
        System.out.println(result);

    }

}

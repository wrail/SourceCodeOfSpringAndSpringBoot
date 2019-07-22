package com.wrial.art5_view.bootstrap;
/*
 * @Author  Wrial
 * @Date Created in 0:46 2019/7/22
 * @Description Thymeleaf从classpath下读取资源
 */

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ThymeleafBootStrapOfResource {

    public static void main(String[] args) throws IOException {

        //构建引擎
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();

        //向上下文中添加变量
        Context context = new Context();
        context.setVariable("message", "Hello Wrial!");

        //使用默认的资源加载器，加载自定义的文件
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:/templates/HelloWorld.html");
        File file = resource.getFile();
        FileInputStream inputStream = new FileInputStream(file);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        IOUtils.copy(inputStream,outputStream);
        //渲染上下文
        inputStream.close();
        String content = outputStream.toString();
        outputStream.close();

        //使用模板引擎进行处理

        String result = springTemplateEngine.process(content, context);
        System.out.println(result);

    }

}

package com.wrial.web.servlet.support;
/*
 * @Author  Wrial
 * @Date Created in 14:17 2019/7/21
 * @Description    注解配置核心控制器
 */

import com.wrial.web.config.DispatcherServletConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DefaultAnnotationConfigDispatcherServletInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {//web.xml
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {//DispatcherServlet 也就是把Controller都要扫描进去
        return new Class[]{DispatcherServletConfiguration.class};
    }


    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

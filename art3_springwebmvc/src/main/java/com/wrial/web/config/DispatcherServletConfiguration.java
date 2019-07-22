package com.wrial.web.config;
/*
 * @Author  Wrial
 * @Date Created in 14:14 2019/7/21
 * @Description 配置包扫描 ，DispacherServlet，需要在DefaultAnnotationConfigDispatcherServletInitializer中进行引入
 */

import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.wrial.web")
public class DispatcherServletConfiguration {


}

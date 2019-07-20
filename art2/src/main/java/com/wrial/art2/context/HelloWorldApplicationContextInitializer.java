package com.wrial.art2.context;
/*
 * @Author  Wrial
 * @Date Created in 23:35 2019/7/19
 * @Description 把HelloWorld加入到SpringApplicationContext中
 * 必须要加上优先级，注意的是配置文件的优先级必须高于Run的优先级
 */

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Order(Ordered.HIGHEST_PRECEDENCE)
public class HelloWorldApplicationContextInitializer implements ApplicationContextInitializer{

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("Hello Wrial -> HelloWorldApplicationInitializer  "+applicationContext.getId());
    }
}

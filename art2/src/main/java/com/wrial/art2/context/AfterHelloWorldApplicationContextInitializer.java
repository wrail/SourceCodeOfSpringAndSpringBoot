package com.wrial.art2.context;
/*
 * @Author  Wrial
 * @Date Created in 23:35 2019/7/19
 * @Description 把HelloWorld加入到SpringApplicationContext中
 * 必须要加上优先级，注意的是配置文件的优先级必须高于Run的优先级
 * 比如要打日志的时候，必须在Logging事件监听器之后再打，这就需要设置一下优先级
 */


import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Order(Ordered.LOWEST_PRECEDENCE)
public class AfterHelloWorldApplicationContextInitializer implements ApplicationContextInitializer{

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("Hello Wrial -> AfterHelloWorldApplicationInitializer"+"  "+applicationContext.getId());
    }
}

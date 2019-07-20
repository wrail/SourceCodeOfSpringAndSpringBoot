package com.wrial.art2.listener;
/*
 * @Author  Wrial
 * @Date Created in 0:16 2019/7/20
 * @Description ApplicationListener事件监听器
 */

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;

/*
不添加泛型就给每个事件都添加了监听器
 */
public class HelloWorldApplicationListener implements ApplicationListener, Ordered {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("给每个事件都监听 Hello World ->" + event.getTimestamp());
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}

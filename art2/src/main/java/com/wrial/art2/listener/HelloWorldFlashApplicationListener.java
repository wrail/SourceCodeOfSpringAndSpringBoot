package com.wrial.art2.listener;
/*
 * @Author  Wrial
 * @Date Created in 0:16 2019/7/20
 * @Description ApplicationListener事件监听器
 */

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;

/*
给
 */
public class HelloWorldFlashApplicationListener implements ApplicationListener<ContextRefreshedEvent>, Ordered {


    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("Hello -> ContextRefreshEvent");
    }
}

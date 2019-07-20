package com.wrial.art2.run;
/*
 * @Author  Wrial
 * @Date Created in 0:43 2019/7/20
 * @Description
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class HelloWorldRunListener implements SpringApplicationRunListener {

    /*
    private SpringApplicationRunListeners getRunListeners(String[] args) {
		Class<?>[] types = new Class<?>[] { SpringApplication.class, String[].class };
		return new SpringApplicationRunListeners(logger,
				getSpringFactoriesInstances(SpringApplicationRunListener.class, types, this, args));
	}
     */
    //必须要这个构造方法，因为在构建的时候，会有方法传入参数，代码如上
    public HelloWorldRunListener(SpringApplication application, String[] args) {

    }
    @Override
    public void starting() {
        System.out.println("Running ---------");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {

    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {

    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {

    }

    @Override
    public void started(ConfigurableApplicationContext context) {

    }

    @Override
    public void running(ConfigurableApplicationContext context) {

    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {

    }
}

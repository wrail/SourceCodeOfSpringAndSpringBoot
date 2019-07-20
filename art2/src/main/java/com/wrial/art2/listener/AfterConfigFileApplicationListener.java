package com.wrial.art2.listener;
/*
 * @Author  Wrial
 * @Date Created in 1:06 2019/7/20
 * @Description
 */

import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

/*
仿照ConfigFileApplicationListener
public class ConfigFileApplicationListener implements EnvironmentPostProcessor, SmartApplicationListener, Ordered {

 yml properties 都是在这个类中读取的
 Additional files will also be loaded based on active profiles. For example if a 'web'
 * profile is active 'application-web.properties' and 'application-web.yml' will be
 * considered.

这个是进行加载配置文件的优先级
public static final int DEFAULT_ORDER = Ordered.HIGHEST_PRECEDENCE + 10;

 */
public class AfterConfigFileApplicationListener implements SmartApplicationListener, Ordered {
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return ApplicationEnvironmentPreparedEvent.class.isAssignableFrom(eventType)
                || ApplicationPreparedEvent.class.isAssignableFrom(eventType);
    }

    @Override
    public boolean supportsSourceType(Class<?> aClass) {
        return true;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationEnvironmentPreparedEvent) {
            ApplicationEnvironmentPreparedEvent preparedEvent = (ApplicationEnvironmentPreparedEvent) event;
            ConfigurableEnvironment environment = preparedEvent.getEnvironment();
            String name = environment.getProperty("name");
            System.out.println("AfterConfigFile(在ConfigFileApplicationListener之后)-->name="+name);
        }
        if (event instanceof ApplicationPreparedEvent) {

        }
    }

    @Override
    public int getOrder() {
        return ConfigFileApplicationListener.DEFAULT_ORDER +1;
    }
}

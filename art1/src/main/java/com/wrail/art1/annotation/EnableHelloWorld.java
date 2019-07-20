package com.wrail.art1.annotation;


import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
//直接导入
//@Import(HelloWorldConfiguration.class)
//通过Selector间接导入
@Import(HelloWorldSelector.class)
public @interface EnableHelloWorld {
}

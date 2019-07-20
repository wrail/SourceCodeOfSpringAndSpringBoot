package com.wrail.art1.condition;


/*
 * @Author  Wrial
 * @Date Created in 13:19 2019/7/18
 * @Description
 */

import com.wrail.art1.condition.OnSystemPropertyCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
@Documented
//在OnSystemPropertyCondition的matches满足的条件下
@Conditional(OnSystemPropertyCondition.class)
public @interface ConditionalOnSystemProperty {


    String name();

    String value();
}

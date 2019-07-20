package com.wrail.art1.condition;


/*
 * @Author  Wrial
 * @Date Created in 13:21 2019/7/18
 * @Description OnSystemPropertyCondition
 */

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;


public class OnSystemPropertyCondition implements Condition {

    /**
     * @param context
     * @param metadata
     * @return boolean
     * 条件匹配
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        Map<String, Object> attributes = metadata.getAnnotationAttributes(ConditionalOnSystemProperty.class.getName());
        String name = String.valueOf(attributes.get("name"));
        String value = String.valueOf(attributes.get("value"));
        //匹配条件
        String relValue = "Wrial";
        System.out.println("OnSystemPropertyCondition正在条件匹配中....");
        return relValue.equals(value);
    }
}

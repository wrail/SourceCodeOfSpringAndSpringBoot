package com.wrail.art1.configuration;
/*
 * @Author  Wrial
 * @Date Created in 16:31 2019/7/18
 * @Description
 */

import com.wrail.art1.annotation.EnableHelloWorld;
import com.wrail.art1.condition.ConditionalOnSystemProperty;


//@Configuration//模式注解（单个模块）
@EnableHelloWorld//模块装配（一组操作）
@ConditionalOnSystemProperty(name = "name",value = "Wrial")//条件装配
public class HelloWorldAutoConfiguration {


}

package com.wrail.art1.annotation;


import com.wrail.art1.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/*
 * 不仅可以直接的通过Import直接的导入某个Bean
 * 也可以通过ImportSelector间接的导入，并且可以加入自己的配置
 *
 * */
public class HelloWorldSelector implements ImportSelector {


    /**
     * Select and return the names of which class(es) should be imported based on
     * the {@link AnnotationMetadata} of the importing @{@link Configuration} class.
     * 返回要被导入的所有类名类名
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("自定义Selector装配HelloWorld Bean");
        return new String[]{HelloWorldConfiguration.class.getName()};
    }
}

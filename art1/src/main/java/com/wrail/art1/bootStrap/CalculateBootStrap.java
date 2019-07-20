package com.wrail.art1.bootStrap;

import com.wrail.art1.service.CalculateService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

//启动类只自动扫描同级目录包下的，因此需要手动扫描
@SpringBootApplication(scanBasePackages = "com.wrail.art1.service")
public class CalculateBootStrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(CalculateBootStrap.class)
                .profiles("Java7")
                .web(WebApplicationType.NONE)
                .run(args);

        //得到CalculateService这个Bean
        CalculateService bean = applicationContext.getBean(CalculateService.class);

        bean.calculateNum(1,2,3,4);



    }


}

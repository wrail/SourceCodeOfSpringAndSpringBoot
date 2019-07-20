package com.wrail.art1.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("Java7")
public class Java7CalculateService implements CalculateService {


    @Override
    public void calculateNum(Integer... integers) {

        int sum = 0;
        for (int i = 0; i < integers.length; i++) {
            sum+=integers[i];
        }
        System.out.println("Java7->"+sum);

    }

    public static void main(String[] args) {
        new Java7CalculateService().calculateNum(1,2,3,4);
    }
}

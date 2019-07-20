package com.wrail.art1.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
@Profile("Java8")
public class Java8CalculateService implements CalculateService {


    @Override
    public void calculateNum(Integer... integers) {

        Integer sum = Stream.of(integers).reduce(0, Integer::sum);
        System.out.println("Java8->"+sum);

    }

    public static void main(String[] args) {
        new Java8CalculateService().calculateNum(1,2,3,4);
    }
}

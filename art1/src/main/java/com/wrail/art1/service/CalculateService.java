package com.wrail.art1.service;



/*
* Profile多环境计算
* Profile在Spring4.0后是根据Conditional进行实现的
* */
public interface CalculateService {

    public void calculateNum(Integer... integers);

}

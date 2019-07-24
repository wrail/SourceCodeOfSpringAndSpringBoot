package com.wrial.art6_rest.controller;
/*
 * @Author  Wrial
 * @Date Created in 11:28 2019/7/23
 * @Description
 */

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

    @CrossOrigin("*")
    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello";
    }



}

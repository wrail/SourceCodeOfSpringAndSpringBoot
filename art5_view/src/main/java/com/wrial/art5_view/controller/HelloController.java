package com.wrial.art5_view.controller;
/*
 * @Author  Wrial
 * @Date Created in 1:42 2019/7/22
 * @Description
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

@RequestMapping("/hello")
    public String hello(){
    return "HelloWorld";

}
@RequestMapping("/index")
public String index(){
    return "index";
}

@ModelAttribute("message")
    public String message(){
    return "hello message!";
}

}

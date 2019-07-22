package com.wrial.bootWebMvc.controller;
/*
 * @Author  Wrial
 * @Date Created in 18:49 2019/7/20
 * @Description 对HelloController的通知
 */

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/*

ControllerAdvice是一种很好的方式在某个Controller初始化一些资源，也很有利于维护

 */
@ControllerAdvice(assignableTypes = HelloController.class)
public class HelloControllerAdvice {


    @ModelAttribute("acceptLanguage")
    public String acceptLanguage(@RequestHeader("Accept-Language") String acceptLanguage) {
        return acceptLanguage;

    }

    @ModelAttribute("jsessionId")
    public String jSessionId(@CookieValue(value = "JSESSIONID",required = false) String jsessionId) {
        return jsessionId;

    }

    @ModelAttribute("message")
    public String message() {
        return "Hello World";
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> resException(Exception e) {
        return ResponseEntity.ok(e.getMessage());
    }

}

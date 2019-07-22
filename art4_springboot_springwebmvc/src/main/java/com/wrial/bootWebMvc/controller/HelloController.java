package com.wrial.bootWebMvc.controller;
/*
 * @Author  Wrial
 * @Date Created in 13:43 2019/7/20
 * @Description HelloController
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    //此Value没有实际意义，仅仅是为了制造异常让HelloController中的ExceptionHandler进行处理
    @RequestMapping("/index")
    public String index(@RequestParam int value) {
//        model.addAttribute("acceptLanguage",acceptLanguage);
//        model.addAttribute("jsessionId",jsessionId);
//        model.addAttribute("message",message());
        return "index";
    }

    /*
    * 先执行Model后执行index（也就是RequestMapping）---->先执行Model，再执行Handle
    *
    * */

    //下面将这些内容迁移到HelloControllerAdvice中，在执行HelloController的时候先执行下面这些内容

    /*

    @ModelAttribute("acceptLanguage")
    public String acceptLanguage(@RequestHeader("Accept-Language") String acceptLanguage){
        return acceptLanguage;

    }

    @ModelAttribute("jsessionId")
    public String jsessionId(@CookieValue("JSESSIONID") String jsessionId){
        return jsessionId;

    }

    @ModelAttribute("message")
    public String message(){
        return "Hello World";
    }


     */
}

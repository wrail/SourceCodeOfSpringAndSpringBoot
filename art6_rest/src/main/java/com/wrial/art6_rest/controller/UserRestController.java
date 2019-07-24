package com.wrial.art6_rest.controller;
/*
 * @Author  Wrial
 * @Date Created in 14:01 2019/7/23
 * @Description
 */

import com.wrial.art6_rest.domain.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRestController {

    @PostMapping(value = "/echo/user",produces = "application/json;charset=UTF-8")
    public User user(@RequestBody User user){
        return user;
    }
}

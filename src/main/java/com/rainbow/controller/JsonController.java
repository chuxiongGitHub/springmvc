package com.rainbow.controller;

import com.google.gson.Gson;
import com.rainbow.common.Result;
import com.rainbow.entity.User;
import com.rainbow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by rainbow on 2016/8/1.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */

/**
 * 以下是springmvc中json的测试
 */
@Controller
@RequestMapping(value = "/json")
public class JsonController {
    @Autowired
    private UserService userService;

    //此种方法是最简洁的返回json数据的方法
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public
    @ResponseBody
    User getUserById(Integer userId) {
        User user = userService.getUserById(userId);
        return user;
    }

    //此种方法是另一种返回json数据的方法
    @RequestMapping(value = "/user2/{userId}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserJson(@PathVariable("userId") Integer userId) {
        User user = userService.getUserById(userId);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}

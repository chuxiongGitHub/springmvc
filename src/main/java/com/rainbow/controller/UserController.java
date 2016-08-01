package com.rainbow.controller;

import com.rainbow.entity.User;
import com.rainbow.service.UserService;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Map;

/**
 * Created by rainbow on 2016/8/1.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    //注入service
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    //实现xxxx/user/userList?userId=?风格的URL地址
    public String userList(@RequestParam("userId") Integer userId, Model model) {
        User user = userService.getUserById(userId);
        model.addAttribute(user);
        return "userList";
    }

    //实现restful样式的URL地址,使用@PathVariable()注解标注参数
    //user/userList2/{userId}
    @RequestMapping(value = "/userList2/{userId}", method = RequestMethod.GET)
    public String userList2(@PathVariable("userId") Integer userId, Map<String, Object> map) {
        User user = userService.getUserById(userId);
        map.put("user", user);
        return "userList";
    }

    //传统的controller方式的书写，使用HttpServletRequest方式
    //URL风格为：user/userList3?userId=?
    @RequestMapping(value = "/userList3", method = RequestMethod.GET)
    public String userList3(HttpServletRequest request) {
        Integer userId = Integer.valueOf(request.getParameter("id"));
        User user = userService.getUserById(userId);
        request.setAttribute("user", user);
        return "userList";
    }

    //展示文件上传页面
    @RequestMapping(value = "/showLoad", method = RequestMethod.GET)
    public String showLoad() {
        return "file";
    }

    //文件上传
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file) throws Exception {

        if (!file.isEmpty()){
            String fileName=file.getOriginalFilename();
            String contentType=file.getContentType();
            System.out.println("文件类型是："+contentType);
            FileUtils.copyInputStreamToFile(file.getInputStream(),new File("c:/temp",System.currentTimeMillis()+fileName));
        }
        return "userList";
    }

}

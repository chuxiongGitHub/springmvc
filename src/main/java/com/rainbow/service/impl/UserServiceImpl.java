package com.rainbow.service.impl;

import com.rainbow.entity.User;
import com.rainbow.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by rainbow on 2016/8/1.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
public class UserServiceImpl implements UserService {
    public User getUserById( Integer userId) {
        User user = new User();
        user.setId(123);
        user.setUsername("陈彩虹sdfafasdf");
        user.setPassword("dafda");
        return user;
    }
}

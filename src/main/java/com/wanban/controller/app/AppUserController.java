package com.wanban.controller.app;

import com.wanban.pojo.Massage;
import com.wanban.pojo.User;
import com.wanban.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by CHLaih on 2018/1/20.
 */
@Controller
public class AppUserController
{

    @Autowired
    private UserService userService;

    @RequestMapping("/getAllUser")
    @ResponseBody
    public Massage getAllUser(){
        List<User> list = userService.getAllUser();
        return Massage.success().add("userList",list);
    }
}

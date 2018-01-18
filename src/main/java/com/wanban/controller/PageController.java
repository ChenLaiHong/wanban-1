package com.wanban.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 赖红 on 2018/1/17.
 */
@Controller
public class PageController {
    @RequestMapping({"/adminLogin"})
    public String adminLogin(){
        return "admin/adminLogin";
    }
    @RequestMapping({"/toAdminUser"})
    public String adminUser(){
        return "admin/adminUser";
    }
}

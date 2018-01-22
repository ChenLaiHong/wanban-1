package com.wanban.controller;

import com.wanban.service.impl.InitComponent;
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

    @RequestMapping({"/toFirstLevel"})
    public String firstLevel(){
        return "admin/adminFirstLevel";
    }

    @RequestMapping({"/toSecondLevel"})
    public String secondLevel(){
        return "admin/adminSecondLevel";}

    @RequestMapping({"/toCheckStatus"})
    public String checkStatus(){
        return "admin/adminStatus";
    }
}

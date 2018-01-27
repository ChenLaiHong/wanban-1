package com.wanban.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * Created by 赖红 on 2018/1/16.
 */
@Controller
@RequestMapping({"/admin"})
public class AdminController {


    @RequestMapping(value={"/login"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
    public String login(@RequestParam("adminName") String adminName,@RequestParam("adminPass") String adminPass,
                        HttpSession session, RedirectAttributes redirectAttributes){



        return "admin/adminMain";

    }


}

package com.wanban.controller;

import com.wanban.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by 赖红 on 2018/1/16.
 */
@Controller
@RequestMapping({"/admin"})
public class AdminController {


    @RequestMapping(value={"/login"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
    public String login(HttpServletRequest request, HttpSession session, RedirectAttributes redirectAttributes){
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        if(!userName.equals("admin") || !password.equals("admin")){
            redirectAttributes.addFlashAttribute("result",new AjaxResult(false,"用户名或密码错误！"));
            return "redirect:/adminLogin";
        }else {
            session.setAttribute("admin", userName);
            return "admin/adminMain";
        }
    }


}

package com.wanban.controller.admin;

import com.wanban.pojo.Admin;
import com.wanban.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
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
     @Autowired
    private AdminService adminService;

    @RequestMapping(value={"/login"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
    public String login(Admin admin, HttpServletRequest request){
           Admin a = this.adminService.login(admin);
           System.out.print("用户名---"+admin.getAdminName());
           if(admin.getAdminName() == null || admin.getAdminName() == ""){
               request.setAttribute("errorInfo", "用户名不能为空！");
               return "admin/adminLogin";
           }if(admin.getAdminPass() == null || admin.getAdminPass() == ""){
            request.setAttribute("errorInfo", "密码不能为空！");
            return "admin/adminLogin";
        }if (a != null){
               request.getSession().setAttribute("adminUser",a);
            return "admin/adminMain";
        }else {
            request.setAttribute("errorInfo", "用户不存在！");
            return "admin/adminLogin";
        }

    }
    @RequestMapping({"/loginOut"})
    public String loginOut(HttpSession session){
        session.removeAttribute("adminUser");
        return "admin/adminLogin";

    }

    @RequestMapping("/modifyPassword")
    public String modifyPassword(){

        return null;
    }


}

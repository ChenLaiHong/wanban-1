package com.wanban.controller.admin;

import com.wanban.pojo.Admin;
import com.wanban.service.AdminService;
import com.wanban.utils.MdUtil;
import com.wanban.utils.ResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public String modifyPassword(@RequestParam(value ="adminId") int adminId, @RequestParam(value = "newPassword") String newPassword, HttpServletResponse response) throws Exception {
        Admin admin = adminService.find(adminId);
        admin.setAdminPass(MdUtil.md5(newPassword));
       int result = adminService.update(admin);
        JSONObject result1=new JSONObject();
        if(result>0){
            result1.put("success", true);
        }else{
            result1.put("false", false);
        }
        ResponseUtil.write(response, result1);
        return null;
    }


}

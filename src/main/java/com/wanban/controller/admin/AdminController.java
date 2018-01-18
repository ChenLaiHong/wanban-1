package com.wanban.controller.admin;

import com.wanban.pojo.FirstLevel;
import com.wanban.pojo.PageBean;
import com.wanban.pojo.User;
import com.wanban.service.FirstLevelService;
import com.wanban.service.UserService;
import com.wanban.utils.AjaxResult;
import com.wanban.utils.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 赖红 on 2018/1/16.
 */
@Controller
@RequestMapping({"/admin"})
public class AdminController {
    @Autowired
    private UserService userService;

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

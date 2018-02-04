package com.wanban.controller.app;

import com.wanban.pojo.Admire;
import com.wanban.pojo.User;
import com.wanban.service.AdmireService;
import com.wanban.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by CHLaih on 2018/2/4.
 */
@Controller
public class AppAdmireController {
    @Autowired
    private UserService userService;

    @Autowired
    private AdmireService admireService;

    @RequestMapping(value = "/addAdmire", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    //admired_user_id:被点赞人的id
    //admire_user_id:点赞人的id
    public String admire(Admire admire){
       int result = admireService.addAdmire(admire);
        if(result > 0){
           User user = userService.getUser(admire.getAdmiredUserId());
           int admireCount = user.getAdmireCount();
           user.setAdmireCount(admireCount+1);
           userService.updateUser(user);
        }
        return result>0 ? "1":"0";
    }

    //判断是否已经点赞
    @RequestMapping(value = "/admireOrNot", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String admireOrNot(@RequestParam("admired_user_id") int admired_user_id,
                              @RequestParam("admire_user_id") int admire_user_id){
        int result = admireService.check(admired_user_id,admire_user_id);
        return result==1 ? "1":"0";
    }
}

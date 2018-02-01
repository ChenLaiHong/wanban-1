package com.wanban.controller.app;

import com.wanban.pojo.User;
import com.wanban.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

import static com.wanban.utils.JsonUtils.objectToJson;

/**
 * Created by CHLaih on 2018/1/20.
 */
@Controller
public class AppUserController
{

    @Autowired
    private UserService userService;
//查询所有用户
    @RequestMapping(value = "/getAllUser",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getAllUser(){
        List<User> list = userService.getAllUser();

        return list !=null?objectToJson(list): "0";
    }

   //查询个人信息
    @RequestMapping(value = "/findUser", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String findUser(@RequestParam(value = "userId", required = true) int userId) {
        User user = userService.getUser(userId);
       return user !=null?objectToJson(user): "0";
    }

    //修改个人信息  根据主键修改用户资料(不包括密码)
    //user : 传入所需要修改的值,不需要修改的值不用传
    //成功修改个人资料返回1，失败返回0
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public int updateUser(@RequestParam("imageFile") MultipartFile imageFile,User user, HttpServletRequest request)throws Exception{

            String filePath = request.getServletContext().getRealPath("/");
            String imageName = com.wanban.utils.DateUtil.getCurrentDateStr() + "."
                    + imageFile.getOriginalFilename().split("\\.")[1];
            imageFile.transferTo(new File(filePath + "static/levelImages/"
                    + imageName));
        if (!imageFile.isEmpty()) {
            File oldFile = new File(filePath+ "static/levelImages/"+user.getImageName());
            oldFile.delete();
        }
        user.setImageName(imageName );
        return userService.updateUser(user)>0 ? 1:0;
    }





}

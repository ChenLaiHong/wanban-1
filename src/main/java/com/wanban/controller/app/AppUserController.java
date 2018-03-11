package com.wanban.controller.app;

import com.wanban.pojo.User;
import com.wanban.service.UserService;
import com.wanban.utils.IMRegisterUtil;
import com.wanban.utils.MdUtil;
import com.wanban.utils.SendSmsUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.wanban.utils.JsonUtils.objectToJson;

/**
 * Created by CHLaih on 2018/1/20.
 */
@Controller
@RequestMapping({"/user"})
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

    @RequestMapping(value = "/regist",method = RequestMethod.GET)
    @ResponseBody
    public void register(HttpServletRequest request,HttpServletResponse response,@RequestParam("username")String username,@RequestParam("password")String password,@RequestParam("email")String email,@RequestParam("phone")String phone) throws IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");


        password = MdUtil.md5(password);
        User User = new User();
        User.setUserName(username);
        User.setPassword(password);
        User.setEmail(email);
        User.setPhone(phone);

        PrintWriter out = null;
        JSONObject json = new JSONObject();

        try {
            out = response.getWriter();
            if (username == null || !userService.checkRegisterUsername(User.getUserName())) {
                System.out.print("用户名重复或空");
            }
            if (email == null || !userService.checkRegisterEmail(User.getEmail())) {
                System.out.print("邮箱重复或空");
            }
            if (phone == null || !userService.checkRegisterPhone(User.getPhone())) {
                System.out.print("手机号重复或空");
            } else {
                userService.addUser(User);
                IMRegisterUtil.createUser(User);
                json.put("status",1);
                out.write(json.toString());
                System.out.print("注册成功");
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            json.put("status",0);
            out.write(json.toString());
        }finally {
            out.flush();
            out.close();
        }

    }

    /**
     * 存放“用户名：token”键值对
     */
    public static Map<String,String> tokenMap=new HashMap<String,String>();
    /**
     * 存放“token:User”键值对
     */
    public static Map<String,User> loginUserMap=new HashMap<String,User>();

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ResponseBody
    public String login(HttpServletRequest request, HttpServletResponse response, @RequestParam("username")String username, @RequestParam("password")String password, ModelAndView mv, HttpSession session) throws Exception {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        System.out.print(username + "------" + password);

        String token = tokenMap.get(username);
        password = MdUtil.md5(password);
        User User = userService.checkLogin(username,password);
        JSONObject json = new JSONObject();
        if(token == null)
        {
            User.setUserName(username);
            User.setPassword(password);
            System.out.print("首次登录");
        }
        if(!User.getPassword().equals(password))
        {
            User = loginUserMap.get(token);
            loginUserMap.remove(token);
        }
        token = MdUtil.md5(username + password + new Date().getTime());
        loginUserMap.put(token,User);
        tokenMap.put(username,token);
        if(User != null)
        {
            session.setAttribute("User", User);
            json.put("User",User);
        }else
        {
            System.out.print("登录失败，账号或密码错误！");
        }

        return token;
    }

    @RequestMapping(value = "/loginout",method = RequestMethod.DELETE)
    public void loginout(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.removeAttribute("username");
    }

    @WebServlet("/sendSms")
    @ResponseBody
    public class SendSms extends HttpServlet {
        @Override
        public void doPost(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {
            String phone=req.getParameter("phone");
            //根据获取到的手机号发送验证码
            String code= SendSmsUtil.getCode(phone);
            System.out.println(code);
            resp.getWriter().print(code);
        }
    }
}

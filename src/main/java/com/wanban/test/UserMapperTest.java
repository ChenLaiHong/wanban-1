package com.wanban.test;


import com.wanban.dao.UserMapper;
import com.wanban.pojo.User;
import com.wanban.service.UserService;
import com.wanban.utils.SendSmsUtil;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class UserMapperTest
{
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectUser() throws Exception {
        Integer id = 1;
        User User = userMapper.selectUser(id);
        System.out.println(User.getUserName());
        JSONObject json = new JSONObject();
        json.put("User",User);
        System.out.println(json.toString());
    }
    @Test
    public void testAddUser() throws Exception{
        String name = "赵五";
        String password = "123456";
        User user =new User();
        user.setUserName(name);
        user.setPassword(password);
        userMapper.addUser(user);
    }
    @Test
    public void testFindUserByName() throws Exception{
        String name = "赵五";
        User user = userMapper.findUserByName(name);
        System.out.print(user.toString());
    }
    @Autowired
    private UserService userService;
    @Test
    public void testcheckLogin() throws Exception{
        String name = "5151";
        String password = "123456";
        userService.checkLogin(name,password);


    }
    @Test
    public void testcheckRegisterUsername() throws Exception
    {
        String name = "赵四";
        if(!userService.checkRegisterUsername(name)) {
            System.out.print("用户名重复");

        }
    }
    @Test
    public void testcheckRegistereUserEmail() throws Exception
    {
        String email = "771507192@qq.com";
        if(!userService.checkRegisterEmail(email)) {
            System.out.print("邮箱重复");
        }
    }

    @Test
    public void testcheckRegistereUserPhone() throws Exception
    {
        String phone = "17765602722";
        if(!userService.checkRegisterPhone(phone)) {
            System.out.print("手机号重复");
        }
    }
    @Test
    public void testSendSmsUser() throws Exception
    {
        String phone = "17765602722";
        SendSmsUtil.getCode(phone);
    }

    @Test
    public void testRegister() throws Exception
    {
        User user = new User();
        user.setUserName("ALex");
        user.setPassword("123456");
        user.setPhone("13821636469");
        user.setEmail("787878@qq.com");
        if (!userService.checkRegisterUsername(user.getUserName()))
        {
            System.out.print("用户名重复");
        }

        if(!userService.checkRegisterEmail(user.getEmail()))
        {
            System.out.print("邮件重复");
        }

        if(!userService.checkRegisterPhone(user.getEmail()))
        {
            System.out.print("电话重复");
        }

    }
}

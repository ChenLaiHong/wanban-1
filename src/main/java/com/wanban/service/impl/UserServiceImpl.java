package com.wanban.service.impl;

import com.wanban.dao.UserMapper;
import com.wanban.pojo.User;
import com.wanban.service.UserService;
import com.wanban.utils.MdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 赖红 on 2018/1/16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> list(Map<String, Object> map) {

        return userMapper.list(map);
    }

    @Override
    public Long getTotal(Map<String, Object> map) {
        return userMapper.getTotal(map);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.selectByExample(null);
    }

    @Override
    public User getUser(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void updateAdmireCount(Integer admiredUserId) {
       userMapper.updateByPrimaryKeySelective(getUser(admiredUserId)) ;
    }

    @Override
    public User findUserByName(String username) {
        return userMapper.findUserByName(username);
    }

    public static Map<String,User> loginUserMap=new HashMap<String,User>();

    @Override
    public User checkLogin(String username, String password) {
        User User = userMapper.findUserByName(username);

        return User;
    }

    @Override
    public boolean checkRegisterUsername(String username) {
        User User = userMapper.findUserByName(username);
        if(User != null)
        {
            return false;
        }
        return true;
    }

    @Override
    public void loginout() {

    }


    @Override
    public boolean checkRegisterEmail(String email) {
        User User = userMapper.findUserByEmail(email);
        if(User != null)
        {
            return false;
        }
        return true;
    }

    @Override
    public boolean checkRegisterPhone(String phone) {
        User User = userMapper.findUserByPhone(phone);
        if(User != null)
        {
            return false;
        }
        return true;

    }

    public User selectUser(Integer userId) {
        return this.userMapper.selectUser(userId);
    }

    @Override
    public void addUser(User User) {
        userMapper.addUser(User);
    }

}

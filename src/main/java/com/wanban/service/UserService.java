package com.wanban.service;

import com.wanban.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * Created by 赖红 on 2018/1/16.
 */
public interface UserService {

    List<User> list(Map<String, Object> map);

    Long getTotal(Map<String, Object> map);

    List<User> getAllUser();

    User getUser(int userId);

    int updateUser(User user);

    void updateAdmireCount(Integer admiredUserId);

    void addUser(User User);

    User findUserByName(String username);

    User checkLogin(String username, String password);

    boolean checkRegisterUsername(String username);

    void loginout();

    boolean checkRegisterEmail(String email);

    boolean checkRegisterPhone(String phone);

}

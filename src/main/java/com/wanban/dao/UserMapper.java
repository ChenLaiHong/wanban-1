package com.wanban.dao;

import com.wanban.pojo.User;
import com.wanban.pojo.UserExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> list(Map<String, Object> map);

    Long getTotal(Map<String, Object> map);

    User findUserByEmail(String email);

    User findUserByPhone(String phone);

    User selectUser(Integer userId);

    void addUser(User User);

    User findUserByName(String username);

    User checkLogin(String username, String password);

    boolean checkRegisterUsername(String username);

    void loginout();

    boolean checkRegisterEmail(String email);

    boolean checkRegisterPhone(String phone);
}
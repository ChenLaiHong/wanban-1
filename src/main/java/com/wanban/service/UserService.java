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
}

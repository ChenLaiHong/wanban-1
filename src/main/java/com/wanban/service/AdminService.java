package com.wanban.service;

/**
 * Created by CHLaih on 2018/1/27.
 */
public interface AdminService {
    com.wanban.pojo.Admin login(com.wanban.pojo.Admin admin);
    com.wanban.pojo.Admin find(int adminId);
    int update (com.wanban.pojo.Admin admin);
}

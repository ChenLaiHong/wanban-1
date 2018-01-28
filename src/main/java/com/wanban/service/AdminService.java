package com.wanban.service;

import com.wanban.pojo.Admin;

/**
 * Created by CHLaih on 2018/1/27.
 */
public interface AdminService {
    Admin login(Admin admin);
    Admin find(int adminId);
    int update (Admin admin);
}

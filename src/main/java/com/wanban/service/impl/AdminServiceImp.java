package com.wanban.service.impl;

import com.wanban.dao.AdminMapper;
import com.wanban.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by CHLaih on 2018/1/27.
 */
@Service
public class AdminServiceImp implements AdminService {
//MdUtil.md5(admin.getAdminPass())
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public com.wanban.pojo.Admin login(com.wanban.pojo.Admin admin) {
        com.wanban.pojo.AdminExample adminExample = new com.wanban.pojo.AdminExample();
        adminExample.createCriteria().andAdminNameEqualTo(admin.getAdminName()).andAdminPassEqualTo(com.wanban.utils.MdUtil.md5(admin.getAdminPass()));
        List<com.wanban.pojo.Admin> admins = adminMapper.selectByExample(adminExample);
        if(!admins.isEmpty()){
            return admins.get(0);
        }
        return null;
    }

    @Override
    public com.wanban.pojo.Admin find(int adminId){
        return adminMapper.selectByPrimaryKey(adminId);
    }

    @Override
    public int update(com.wanban.pojo.Admin admin){
        return adminMapper.updateByPrimaryKeySelective(admin);
    }
}

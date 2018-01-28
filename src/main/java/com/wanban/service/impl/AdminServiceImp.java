package com.wanban.service.impl;

import com.wanban.dao.AdminMapper;
import com.wanban.pojo.Admin;
import com.wanban.pojo.AdminExample;
import com.wanban.service.AdminService;
import com.wanban.utils.MdUtil;
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
    public Admin login(Admin admin) {
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andAdminNameEqualTo(admin.getAdminName()).andAdminPassEqualTo(MdUtil.md5(admin.getAdminPass()));
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        if(!admins.isEmpty()){
            return admins.get(0);
        }
        return null;
    }

    @Override
    public Admin find(int adminId){
        return adminMapper.selectByPrimaryKey(adminId);
    }

    @Override
    public int update(Admin admin){
        return adminMapper.updateByPrimaryKeySelective(admin);
    }
}

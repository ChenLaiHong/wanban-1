package com.wanban.service.impl;

import com.wanban.dao.AdmireMapper;
import com.wanban.pojo.Admire;
import com.wanban.pojo.AdmireExample;
import com.wanban.service.AdmireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by CHLaih on 2018/2/4.
 */
@Service
public class AdmireServiceImp implements AdmireService{

    @Autowired
    private AdmireMapper admireMapper;


    @Override
    public int addAdmire(Admire admire) {
        return admireMapper.insertSelective(admire);
    }

    @Override
    public int check(int admired_user_id, int admire_user_id) {
        AdmireExample admireExample = new AdmireExample();
        admireExample.createCriteria().andAdmiredUserIdEqualTo(admired_user_id).andAdmireUserIdEqualTo(admire_user_id);
        List<Admire> admireList = admireMapper.selectByExample(admireExample);
        if (!admireList.isEmpty()){
            return 1;
        }
        return 0;
    }
}

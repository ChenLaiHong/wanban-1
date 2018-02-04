package com.wanban.service;

import com.wanban.pojo.Admire;

/**
 * Created by CHLaih on 2018/2/4.
 */
public interface AdmireService {
    int addAdmire(Admire admire);

    int check(int admired_user_id, int admire_user_id);
}

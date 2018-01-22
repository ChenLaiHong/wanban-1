package com.wanban.service;

import com.wanban.pojo.FeedBack;

import java.util.List;
import java.util.Map;

/**
 * Created by CHLaih on 2018/1/22.
 */
public interface FeedBackService {
    List<FeedBack> list(Map<String, Object> map);

    Long getTotal(Map<String, Object> map);
}

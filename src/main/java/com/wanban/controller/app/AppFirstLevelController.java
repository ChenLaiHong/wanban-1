package com.wanban.controller.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by CHLaih on 2018/1/21.
 */
@Controller
public class AppFirstLevelController {
    @Autowired
    private com.wanban.service.FirstLevelService firstLevelService;

    @RequestMapping("/getAllFirstLevel")
    @ResponseBody
    public com.wanban.pojo.Massage getAllFirstLevel(){
        List<com.wanban.pojo.FirstLevel> list = firstLevelService.getAllFirstLevel();
        return com.wanban.pojo.Massage.success().add("firstLevelList",list);
    }
}

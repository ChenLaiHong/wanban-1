package com.wanban.controller.app;

import com.wanban.pojo.FirstLevel;
import com.wanban.pojo.Massage;
import com.wanban.service.FirstLevelService;
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
    private FirstLevelService firstLevelService;

    @RequestMapping("/getAllFirstLevel")
    @ResponseBody
    public Massage getAllFirstLevel(){
        List<FirstLevel> list = firstLevelService.getAllFirstLevel();
        return Massage.success().add("firstLevelList",list);
    }
}

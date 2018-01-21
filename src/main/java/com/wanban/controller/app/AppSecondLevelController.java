package com.wanban.controller.app;

import com.wanban.pojo.Massage;
import com.wanban.pojo.SecondLevel;
import com.wanban.service.SecondLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by CHLaih on 2018/1/21.
 */
@Controller
public class AppSecondLevelController {
    @Autowired
    private SecondLevelService secondLevelService;

    @RequestMapping("/getAllSecondlevel")
    @ResponseBody
    public Massage getAllSecond(){
        List<SecondLevel> list = secondLevelService.getAllSecond();
        return Massage.success().add("secondLevel",list);
    }
}

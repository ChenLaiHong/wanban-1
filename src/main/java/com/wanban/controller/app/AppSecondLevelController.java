package com.wanban.controller.app;

import com.wanban.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by CHLaih on 2018/1/21.
 */
@Controller
public class AppSecondLevelController {
    @Autowired
    private com.wanban.service.SecondLevelService secondLevelService;

    @RequestMapping(value ="/getAllSecondlevel", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getAllSecond(@RequestParam(value = "firstId", required = true) int firstId){
        List<com.wanban.pojo.SecondLevel> list = secondLevelService.getAllSecond(firstId);
        return list != null ? JsonUtils.objectToJson(list) : "0";
    }
}

package com.wanban.controller.app;

import com.wanban.pojo.Releases;
import com.wanban.pojo.User;
import com.wanban.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by CHLaih on 2018/1/24.
 */
@Controller
public class AppReleaseController {
    @Autowired
    private com.wanban.service.ReleasesService releasesService;
    @Autowired
    private com.wanban.service.FirstLevelService firstLevelService;
    @Autowired
    private com.wanban.service.SecondLevelService secondLevelService;
    @Autowired
    private com.wanban.service.UserService userService;

    @RequestMapping(value = "/addRelease", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addRelease(@RequestParam(value = "firstId",required = false) Integer firstId,
                             @RequestParam(value = "secondId",required = false) Integer secondId,
                             @RequestParam(value = "userId",required = true) int userId, Releases releases
                             ){
        if(firstId != null){
          String name = firstLevelService.getFirstLevelId(firstId).getFirstName();
          releases.setTypes(name);
        }if(secondId != null){
            String name = secondLevelService.getSecondById(secondId).getSecondName();
            releases.setTypes(name);
        }
        releasesService.add(releases);
        User user = userService.getUser(userId);
        return user != null ? JsonUtils.objectToJson(user) : "0";
    }

}

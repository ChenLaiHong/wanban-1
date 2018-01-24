package com.wanban.controller.app;

import com.wanban.pojo.FirstLevel;
import com.wanban.pojo.Releases;
import com.wanban.service.FirstLevelService;
import com.wanban.service.ReleasesService;
import com.wanban.service.SecondLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by CHLaih on 2018/1/24.
 */
@Controller
public class AppReleasesController {
    @Autowired
    private ReleasesService releasesService;
    @Autowired
    private FirstLevelService firstLevelService;
    @Autowired
    private SecondLevelService secondLevelService;

    @RequestMapping(value = "/releaseMassage",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String releaseMassage(@RequestParam(value = "firstId", required = false) int firstId,
                                 @RequestParam(value = "secondId",required = false) int secondId, Releases releases, HttpServletResponse response){
                       if(firstId !=0){
                           String name = firstLevelService.getFirstLevelId(firstId).getFirstName();
                           releases.setType(name);
                       }else{
                           String name = secondLevelService.getSecondById(secondId).getSecondName();
                           releases.setType(name);
                       }
                    int result = releasesService.add(releases);
        return  result>0 ? "1":"0";
    }
}

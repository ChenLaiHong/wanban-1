package com.wanban.controller.app;

import com.wanban.pojo.FeedBack;
import com.wanban.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by CHLaih on 2018/1/25.
 */
@Controller
public class AppFeedBackController {
    @Autowired
    private FeedBackService feedBackService;

    @RequestMapping(value = "/addFeedBack", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addFeedBack(FeedBack feedBack){
       int result = feedBackService.add(feedBack);
        return result>0 ? "1":"0";
    }
}

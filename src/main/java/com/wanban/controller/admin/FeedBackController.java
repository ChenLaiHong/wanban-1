package com.wanban.controller.admin;

import com.wanban.pojo.FeedBack;
import com.wanban.pojo.PageBean;
import com.wanban.service.FeedBackService;
import com.wanban.utils.DateJsonValueProcessor;
import com.wanban.utils.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by CHLaih on 2018/1/22.
 */
@Controller
@RequestMapping({"/admin"})
public class FeedBackController {
    @Autowired
    private FeedBackService feedBackService;

    @RequestMapping("/status/list")
    public String list(
            @RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String rows,
            @RequestParam(value = "questionStatus", required = false) String questionStatus,
            HttpServletResponse response) throws Exception {
        PageBean pageBean = new PageBean(Integer.parseInt(page),
                Integer.parseInt(rows));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        map.put("state", questionStatus); // 评论状态
        List<FeedBack> feedBackList = feedBackService.list(map);
        Long total = feedBackService.getTotal(map);
        JSONObject result = new JSONObject();
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class,
                new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
        JSONArray jsonArray = JSONArray.fromObject(feedBackList, jsonConfig);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response, result);
        return null;
    }
}

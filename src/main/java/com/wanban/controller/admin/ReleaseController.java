package com.wanban.controller.admin;

import com.wanban.pojo.PageBean;
import com.wanban.pojo.Releases;
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
 * Created by CHLaih on 2018/1/24.
 */
@Controller
@RequestMapping({"/admin"})
public class ReleaseController {
    @Autowired
    private com.wanban.service.ReleasesService releasesService;

    @RequestMapping("/release/list")
    public String releaseList(@RequestParam(value = "page", required = false) String page,
                              @RequestParam(value = "rows", required = false) String rows,
                              @RequestParam(value = "status",required = false) String status,
                              Releases a_releases, HttpServletResponse response)throws Exception{
        PageBean pageBean = new PageBean(Integer.parseInt(page),
                Integer.parseInt(rows));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("types", com.wanban.utils.StringUtil.formatLike(a_releases.getTypes()));
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        map.put("status", status); // 审核状态
        List<Releases> releasesList = releasesService.list(map);
        Long total = releasesService.getTotal(map);
        JSONObject result = new JSONObject();
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(releasesList, jsonConfig);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response, result);

        return null;
    }

    @RequestMapping("/release/status")
    public String checkStatus(@RequestParam(value = "ids") String ids,
                              @RequestParam(value = "status") Integer status,
                              HttpServletResponse response) throws Exception {
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            Releases releases = new Releases();
            releases.setStatus(status);
            releases.setReleaseId(Integer.valueOf(idsStr[i]));
            releasesService.update(releases);
        }
        JSONObject result = new JSONObject();
        result.put("success", true);
        ResponseUtil.write(response, result);
        return  null;
    }
}

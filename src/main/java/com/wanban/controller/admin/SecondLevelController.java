package com.wanban.controller.admin;

import com.wanban.pojo.PageBean;
import com.wanban.pojo.SecondLevel;
import com.wanban.service.SecondLevelService;
import com.wanban.utils.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by CHLaih on 2018/1/18.
 */
@Controller
@RequestMapping({"/admin"})
public class SecondLevelController {

    @Autowired
    private SecondLevelService secondLevelService;
//formatter="formatFirstLevel"
    @RequestMapping("/secondLevel/list")
    public String list(@RequestParam(value = "page", required = false) String page,
                       @RequestParam(value = "rows", required = false) String rows,
                       HttpServletResponse response) throws Exception {
        PageBean pageBean = new PageBean(Integer.parseInt(page),
                Integer.parseInt(rows));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<SecondLevel> secondList = secondLevelService.list(map);
        Long total = secondLevelService.getTotal(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(secondList);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response, result);
        return null;
    }

    @RequestMapping("/secondLevel/save")
    public String save(SecondLevel secondLevel, HttpServletResponse response)throws Exception{
        int resultTotal=0; // 操作的记录条数
        if(secondLevel.getSecondId()==null){
            resultTotal=secondLevelService.addSecond(secondLevel);
        }else{
            resultTotal=secondLevelService.updateSecond(secondLevel);
        }
        JSONObject result=new JSONObject();
        if(resultTotal>0){
            result.put("success", true);
        }else{
            result.put("success", false);
        }
        ResponseUtil.write(response, result);
        return null;
    }

    @RequestMapping("/secondLevel/delete")
    public String delete(@RequestParam(value="ids")String ids,HttpServletResponse response)throws Exception{
        String []idsStr=ids.split(",");
        for(int i=0;i<idsStr.length;i++){
            secondLevelService.deleteSecond(Integer.parseInt(idsStr[i]));
        }
        JSONObject result=new JSONObject();
        result.put("success", true);
        ResponseUtil.write(response, result);
        return null;
    }
}

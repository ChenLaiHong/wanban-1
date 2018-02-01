package com.wanban.controller.admin;

import com.wanban.pojo.PageBean;
import com.wanban.pojo.Place;
import com.wanban.service.PlaceService;
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
 * Created by CHLaih on 2018/2/1.
 */
@Controller
@RequestMapping({"/admin/place"})
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    @RequestMapping("/list")
    public String list(@RequestParam(value = "page", required = false) String page,
                       @RequestParam(value = "rows", required = false) String rows,
                       HttpServletResponse response) throws Exception {
        PageBean pageBean = new PageBean(Integer.parseInt(page),
                Integer.parseInt(rows));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<Place> placeList = placeService.list(map);
        Long total = placeService.getTotal(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(placeList);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response, result);
        return null;
    }

    @RequestMapping("/save")
    public String save(Place place,HttpServletResponse response) throws Exception {
        int resultTotal=0; // 操作的记录条数
        if(place.getPlaceId()==null) {
            resultTotal = placeService.addPlace(place);
        }else {
            resultTotal = placeService.updatePlace(place);
        }
        JSONObject result=new JSONObject();
        if(resultTotal>0){
            result.put("success", true);
        }else{
            result.put("false", false);
        }
        ResponseUtil.write(response, result);
        return null;
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("ids") String ids, HttpServletResponse response) throws Exception {
        String idsStr[] = ids.split(",");
        JSONObject result = new JSONObject();
        for (int i = 0; i < idsStr.length; i++) {
            placeService.delete(Integer.parseInt(idsStr[i]));
        }
        result.put("success", true);
        ResponseUtil.write(response, result);
        return null;


    }

}
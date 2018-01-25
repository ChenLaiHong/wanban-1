package com.wanban.controller.admin;

import com.wanban.pojo.Massage;
import com.wanban.pojo.PageBean;
import com.wanban.pojo.SecondLevel;
import com.wanban.service.FirstLevelService;
import com.wanban.service.SecondLevelService;
import com.wanban.utils.DateUtil;
import com.wanban.utils.ResponseUtil;
import com.wanban.utils.StringUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
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

    @RequestMapping("/secondLevel/list")
    public String list(@RequestParam(value = "page", required = false) String page,
                       @RequestParam(value = "rows", required = false) String rows,SecondLevel a_secondLevel,
                       HttpServletResponse response) throws Exception {
        PageBean pageBean = new PageBean(Integer.parseInt(page),
                Integer.parseInt(rows));

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("secondName", StringUtil.formatLike(a_secondLevel.getSecondName()));
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
    public String save(@RequestParam("imageFile") MultipartFile imageFile, SecondLevel secondLevel, HttpServletRequest request, HttpServletResponse response)throws Exception{
        int resultTotal=0; // 操作的记录条数
        if(secondLevel.getSecondId()==null){
                String filePath = request.getServletContext().getRealPath("/");
                String imageName = DateUtil.getCurrentDateStr() + "."
                        + imageFile.getOriginalFilename().split("\\.")[1];
                imageFile.transferTo(new File(filePath + "static/levelImages/"
                        + imageName));
                if (!imageFile.isEmpty()) {
                    File oldFile = new File(filePath+ "static/levelImages/"+secondLevel.getSecondImageName());
                    oldFile.delete();
            }
            secondLevel.setSecondImageName(imageName );
            resultTotal=secondLevelService.addSecond(secondLevel);
        }else{
            if (!imageFile.isEmpty()) {
                String filePath = request.getServletContext().getRealPath("/");
                String imageName = DateUtil.getCurrentDateStr() + "."
                        + imageFile.getOriginalFilename().split("\\.")[1];
                imageFile.transferTo(new File(filePath + "static/levelImages/"
                        + imageName));
                secondLevel.setSecondImageName(imageName );
            }
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
    public String delete(@RequestParam(value="ids")String ids,HttpServletRequest request,HttpServletResponse response)throws Exception{
        String []idsStr=ids.split(",");
        for(int i=0;i<idsStr.length;i++){
            String filePath = request.getServletContext().getRealPath("/");
           File oldFile = new File(filePath+ "static/levelImages/"+secondLevelService.getImageName(Integer.parseInt(idsStr[i])));
            oldFile.delete();
            secondLevelService.deleteSecond(Integer.parseInt(idsStr[i]));
        }
        JSONObject result=new JSONObject();
        result.put("success", true);
        ResponseUtil.write(response, result);
        return null;
    }

    @RequestMapping("/secondLevel/Image")
    @ResponseBody
    public Massage getImageName(@RequestParam(value="secondId")int secondId){
        String imageName = secondLevelService.getImageName(secondId);
        return Massage.success().add("imageName",imageName);
    }
}

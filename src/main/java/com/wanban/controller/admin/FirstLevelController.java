package com.wanban.controller.admin;

import com.wanban.pojo.FirstLevel;
import com.wanban.pojo.Massage;
import com.wanban.pojo.PageBean;
import com.wanban.service.FirstLevelService;
import com.wanban.service.SecondLevelService;
import com.wanban.utils.DateUtil;
import com.wanban.utils.ResponseUtil;
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
 * Created by 赖红 on 2018/1/18.
 */
@Controller
@RequestMapping({"/admin"})
public class FirstLevelController {
    @Autowired
    private FirstLevelService firstLevelService;

    @Autowired
    private SecondLevelService secondLevelService;

    @RequestMapping("/firstLevel/list")
    public String firstList(@RequestParam(value = "page", required = false) String page,
                            @RequestParam(value = "rows", required = false) String rows,
                            HttpServletResponse response) throws Exception {
        PageBean pageBean = new PageBean(Integer.parseInt(page),
                Integer.parseInt(rows));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<FirstLevel> firstList = firstLevelService.list(map);
        Long total = firstLevelService.getTotal(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(firstList);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response, result);
        return null;
    }

    // 保存和更新方法
    @RequestMapping("/firstLevel/save")
    public String save(@RequestParam("imageFile") MultipartFile imageFile,
                       FirstLevel firstLevel, HttpServletRequest request,
                       HttpServletResponse response) throws Exception {
        System.out.print("进来执行添加操作");
        int resultTotal = 0; // 操作的记录条数
        if (firstLevel.getFirstId() != null) {

                String filePath = request.getServletContext().getRealPath("/");
                String imageName = DateUtil.getCurrentDateStr() + "."
                        + imageFile.getOriginalFilename().split("\\.")[1];
                imageFile.transferTo(new File(filePath + "static/levelImages/"
                        + imageName));
            if (!imageFile.isEmpty()) {
                File oldFile = new File(filePath+ "static/levelImages/"+firstLevel.getFirstImageName());
                oldFile.delete();
            }
            firstLevel.setFirstImageName(imageName );
            resultTotal = firstLevelService.add(firstLevel);
        } else {
            if (!imageFile.isEmpty()) {
                String filePath = request.getServletContext().getRealPath("/");
                String imageName = DateUtil.getCurrentDateStr() + "."
                        + imageFile.getOriginalFilename().split("\\.")[1];
                imageFile.transferTo(new File(filePath + "static/levelImages/"
                        + imageName));
                firstLevel.setFirstImageName(imageName );
            }
            resultTotal = firstLevelService.update(firstLevel);
        }
        JSONObject result = new JSONObject();
        if (resultTotal != 0) {
            result.put("success", true);
        } else {
            result.put("success", false);
        }
        ResponseUtil.write(response, result);
        return null;
    }

    @RequestMapping("/firstLevel/delete")
    public String delete(@RequestParam("ids") String ids,HttpServletRequest request,
                         HttpServletResponse response) throws Exception {
        String idsStr[] = ids.split(",");
        JSONObject result = new JSONObject();
        for (int i = 0; i < idsStr.length; i++) {
            if (secondLevelService.getFirstLevelById(Integer.parseInt(idsStr[i])) > 0) {
                result.put("exist", "此级别下有二级，不能删除！");
            } else {
                String filePath = request.getServletContext().getRealPath("/");
                File oldFile = new File(filePath+ "static/levelImages/"+firstLevelService.getImageName(Integer.parseInt(idsStr[i])));
                oldFile.delete();
                firstLevelService.delete(Integer.parseInt(idsStr[i]));
            }
        }
        result.put("success", true);
        ResponseUtil.write(response, result);

        return null;
    }
    @RequestMapping("/firstLevel/Image")
    @ResponseBody
    public Massage getImageName(@RequestParam(value="firstId")int firstId){
        String imageName = firstLevelService.getImageName(firstId);
        return Massage.success().add("imageName",imageName);
    }
}

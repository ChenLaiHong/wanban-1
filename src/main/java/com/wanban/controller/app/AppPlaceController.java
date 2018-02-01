package com.wanban.controller.app;

import com.wanban.pojo.Place;
import com.wanban.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by CHLaih on 2018/2/1.
 */
@Controller
public class AppPlaceController {
    @Autowired
    private PlaceService placeService;

    @RequestMapping(value = "/getPlace", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getPlace(@RequestParam(value = "longitude", required = true) double longitude,
                           @RequestParam(value = "latitude",required = true) double latitude){
        Place place = placeService.getPlace(longitude,latitude);
        return null;
    }
}

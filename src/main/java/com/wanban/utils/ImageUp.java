package com.wanban.utils;

import com.wanban.pojo.FirstLevel;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by 赖红 on 2018/1/18.
 */
public class ImageUp {
    public static void JudeImage(MultipartFile imageFile, FirstLevel firstLevel,HttpServletRequest request) throws Exception {
        if (!imageFile.isEmpty()) {
            String filePath = request.getServletContext().getRealPath("/");
            String imageName = DateUtil.getCurrentDateStr() + "."
                    + imageFile.getOriginalFilename().split("\\.")[1];
            imageFile.transferTo(new File(filePath + "static/images/"
                    + imageName));
            firstLevel.setFirstImageName(imageName);
        }
    }
}

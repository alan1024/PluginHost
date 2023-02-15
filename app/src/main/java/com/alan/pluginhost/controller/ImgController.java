package com.alan.pluginhost.controller;


import com.alan.pluginhost.pojo.ImageBean;
import com.alan.pluginhost.pojo.ImageLayBean;
import com.alan.pluginhost.service.ImageService;

import java.io.File;

public class ImgController {

    ImageService imageService;


    public String upfileByUser(File file, String userId) throws Exception {
        ImageLayBean baseResult = new ImageLayBean();
        if (file == null) {
            System.out.println("上传文件为空");
            return "";
        }
        ImageBean imageBean = imageService.upfileByUser(file, userId);
        baseResult.setCode(0);
        baseResult.setMsg("success");
        ImageLayBean.Data data = new ImageLayBean.Data(imageBean.getImgUrl(), "图片");
        baseResult.setData(data);


        return "";

    }
}

package com.alan.pluginhost.service.impl;

import com.alan.pluginhost.config.Config;
import com.alan.pluginhost.pojo.ImageBean;
import com.alan.pluginhost.service.ImageService;
import com.alan.pluginhost.utils.IDUtils;

import java.io.File;
import java.util.Date;


public class ImageServiceImpl implements ImageService {

    @Override
    public ImageBean upfileByUser(File file, String userId) throws Exception {
        ImageBean imageBean = null;

        String filename = file.getName(); // 获得原始的文件名
        String newName = IDUtils.RandomId() + filename.substring(filename.lastIndexOf("."));
//
//        InputStream input = file.getInputStream();
//        FtpClientUtils a = new FtpClientUtils();
//        FTPClient ftp = a.getConnectionFTP(Config.FTP_IP, 21, "ftpuser", "@@22xiao");
//        boolean success = a.uploadFile(ftp, Config.FTP_IMAGE_PATH, newName, input);

        if (true) {
            String imgUrl = Config.FTP_HOST_PATH + newName;
            imageBean = new ImageBean();
            imageBean.setImgId(IDUtils.RandomId());
            imageBean.setImgUrl(imgUrl);
            imageBean.setUserId(userId);
            imageBean.setPageViews("0");
            imageBean.setUpTime(new Date());

            System.out.println(imgUrl);
        }


        return imageBean;
    }
}

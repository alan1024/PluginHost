package com.alan.pluginhost.controller;

import static com.alan.pluginhost.config.Config.SUCCESS_CODE;

import com.alan.pluginhost.config.Config;
import com.alan.pluginhost.pojo.ApkBean;
import com.alan.pluginhost.pojo.Base.BaseResult;
import com.alan.pluginhost.service.ApkService;

import java.util.ArrayList;
import java.util.List;

public class ApkController {

    ApkService apkService;


    public BaseResult getLastApk() {
        BaseResult baseResult = new BaseResult();
        try {
            ApkBean apkBean = apkService.getLastApk();
            List<ApkBean> list = new ArrayList<>();
            list.add(apkBean);
            baseResult.setData(list);
            baseResult.setCode(SUCCESS_CODE);
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setCode(Config.ERROR_CODE);
            return baseResult;
        }

        return baseResult;
    }
}

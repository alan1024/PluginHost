package com.alan.pluginhost.service.impl;

import com.alan.pluginhost.mapper.ApkMapper;
import com.alan.pluginhost.pojo.ApkBean;
import com.alan.pluginhost.service.ApkService;


public class ApkServiceImpl implements ApkService {

    ApkMapper apkMapper;

    @Override
    public ApkBean getLastApk() {
        return apkMapper.getLastApk();
    }
}

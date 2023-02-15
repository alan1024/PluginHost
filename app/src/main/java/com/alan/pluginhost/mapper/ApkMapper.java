package com.alan.pluginhost.mapper;

import com.alan.pluginhost.pojo.ApkBean;


public interface ApkMapper {
    ApkBean getLastApk();

    void addLastApk(ApkBean bean);
}

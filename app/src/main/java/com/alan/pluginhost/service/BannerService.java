package com.alan.pluginhost.service;

import com.alan.pluginhost.pojo.BannerBean;
import com.alan.pluginhost.pojo.Base.BaseResult;

public interface BannerService {
    BaseResult getBannerData();

    BannerBean addBanner(BannerBean bean) throws Exception;

    void deleteBannerById(String articelId) throws Exception;
}

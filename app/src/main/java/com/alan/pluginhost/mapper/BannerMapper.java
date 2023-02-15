package com.alan.pluginhost.mapper;

import com.alan.pluginhost.pojo.BannerBean;

import java.util.List;

public interface BannerMapper {
    List<BannerBean> getBannerData();

    void addBanner(BannerBean bean);

    void deleteBannerById(String articelId);
}

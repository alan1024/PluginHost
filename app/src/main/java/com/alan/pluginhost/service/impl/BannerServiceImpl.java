package com.alan.pluginhost.service.impl;

import com.alan.pluginhost.mapper.BannerMapper;
import com.alan.pluginhost.pojo.BannerBean;
import com.alan.pluginhost.pojo.Base.BaseResult;
import com.alan.pluginhost.service.BannerService;

import java.util.List;

public class BannerServiceImpl implements BannerService {

    BannerMapper bannerMapper;

    @Override
    public BaseResult getBannerData() {
        BaseResult result = new BaseResult();
        List<BannerBean> list = bannerMapper.getBannerData();
        result.setData(list);
        return result;
    }

    @Override
    public BannerBean addBanner(BannerBean bean) throws Exception {
        bannerMapper.addBanner(bean);
        return bean;
    }

    @Override
    public void deleteBannerById(String articelId) throws Exception {
        bannerMapper.deleteBannerById(articelId);
    }
}

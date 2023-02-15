package com.alan.pluginhost.controller;

import com.alan.pluginhost.config.Config;
import com.alan.pluginhost.pojo.BannerBean;
import com.alan.pluginhost.pojo.Base.BaseResult;
import com.alan.pluginhost.pojo.UserBean;
import com.alan.pluginhost.service.BannerService;
import com.alan.pluginhost.service.UserService;
import com.alan.pluginhost.utils.IDUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class BannerController {
    BannerService bannerService;
    UserService userService;

    public BaseResult getBannerData() {
        BaseResult baseResult = new BaseResult();
        try {
            BaseResult temp = bannerService.getBannerData();
            if (temp != null) {
                temp.setCode(Config.SUCCESS_CODE);
                return temp;
            }
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setCode(Config.ERROR_CODE);
            return baseResult;
        }
        baseResult.setCode(Config.ERROR_CODE);
        return baseResult;
    }

    public BaseResult addBanner(Map<String, String> map) {
        BaseResult baseResult = new BaseResult();
        try {
            String userId = map.get("userId");
            String title = map.get("title");
            String imgUrl = map.get("imgUrl");
            String articleUrl = map.get("articleUrl");
            UserBean userBean = userService.getUserById(userId);
            if (userBean == null) {
                baseResult.setCode(Config.ERROR_CODE);
                return baseResult;
            }
            BannerBean temp = new BannerBean();
            temp.setTitle(title);
            temp.setUserId(userId);
            temp.setImgUrl(imgUrl);
            temp.setArticleUrl(articleUrl);
            temp.setArticelId(IDUtils.RandomId());
            temp.setUpTime(new Date());
            BannerBean bannerBean = bannerService.addBanner(temp);
            List<BannerBean> list = new ArrayList<>();
            list.add(bannerBean);
            baseResult.setData(list);
            baseResult.setCode(Config.SUCCESS_CODE);
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setCode(Config.ERROR_CODE);
            return baseResult;
        }

        return baseResult;
    }

    public BaseResult deleteBannerById(Map<String, String> map) {
        BaseResult baseResult = new BaseResult();
        try {
            String articelId = map.get("articelId");
            String adminId = map.get("adminId");
            if (!Config.ADMIN_ID.equals(adminId)) {
                baseResult.setCode(Config.ERROR_CODE);
                baseResult.setMsg("没有权限");
                return baseResult;
            }
            bannerService.deleteBannerById(articelId);
            baseResult.setCode(Config.SUCCESS_CODE);
            baseResult.setMsg("删除成功");
            return baseResult;
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setCode(Config.ERROR_CODE);
            baseResult.setMsg("删除失败");
        }
        return baseResult;
    }
}

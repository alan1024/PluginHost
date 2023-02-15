package com.alan.pluginhost.controller;

import static com.alan.pluginhost.config.Config.SUCCESS_CODE;

import com.alan.pluginhost.config.Config;
import com.alan.pluginhost.pojo.Base.BaseListResult;
import com.alan.pluginhost.pojo.Base.BaseResult;
import com.alan.pluginhost.pojo.PlankTalkBean;
import com.alan.pluginhost.pojo.TalkBean;
import com.alan.pluginhost.pojo.UserBean;
import com.alan.pluginhost.service.PlankService;
import com.alan.pluginhost.service.UserService;
import com.alan.pluginhost.utils.ResultHelper;

import java.util.ArrayList;
import java.util.List;

public class PlankController {

    PlankService plankService;

    UserService userService;


    public BaseResult addTalk(String userId, String talk) {
        BaseResult baseResult = new BaseResult();
        try {
            UserBean user = userService.getUserById(userId);
            if (user == null) {
                return ResultHelper.getResult(Config.ERROR_CODE);
            }
            if (user.getBanned() == 1) {
                return ResultHelper.getResult(Config.ERROR_BANNED_CODE);
            }
            TalkBean talkBean = plankService.addTalk(userId, talk);
            List<TalkBean> list = new ArrayList<>();
            list.add(talkBean);
            baseResult.setData(list);
            baseResult.setCode(SUCCESS_CODE);
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setCode(Config.ERROR_CODE);
            return baseResult;
        }

        return baseResult;
    }


    public BaseListResult getTalkList(Integer size) {
        BaseListResult baseResult = new BaseListResult();
        try {
            BaseListResult result = plankService.getTalkList(size);
            if (result != null) {
                result.setCode(SUCCESS_CODE);
                result.setMsg(Config.MES_REQUEST_SUCCESS);
                return result;
            }
            baseResult.setCode(Config.ERROR_CODE);
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setCode(Config.ERROR_CODE);
            baseResult.setMsg(Config.MES_SERVER_ERROR);
        }
        return baseResult;
    }


    public BaseListResult getPlankList(Integer page, Integer row) {
        BaseListResult baseResult = new BaseListResult();
        try {
            BaseListResult result = plankService.getPlankList(page, row);
            if (result != null) {
                result.setCode(SUCCESS_CODE);
                result.setMsg(Config.MES_REQUEST_SUCCESS);
                return result;
            }
            baseResult.setCode(Config.ERROR_CODE);
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setCode(Config.ERROR_CODE);
            baseResult.setMsg(Config.MES_SERVER_ERROR);
        }
        return baseResult;
    }


    public BaseResult getLastPlank() {
        BaseResult baseResult = new BaseResult();
        try {
            PlankTalkBean plankTalkBean = plankService.getLastPlank();
            List<PlankTalkBean> list = new ArrayList<>();
            list.add(plankTalkBean);
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

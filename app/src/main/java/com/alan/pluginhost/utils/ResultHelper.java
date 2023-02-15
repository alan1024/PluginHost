package com.alan.pluginhost.utils;

import com.alan.pluginhost.config.Config;
import com.alan.pluginhost.pojo.Base.BaseResult;

public class ResultHelper {
    public static BaseResult getResult(int code) {
        BaseResult baseResult = new BaseResult();
        switch (code) {
            case Config.ERROR_CODE:
                baseResult.setCode(Config.ERROR_CODE);
                baseResult.setMsg(Config.MES_SERVER_ERROR);
                break;
            case Config.ERROR_BANNED_CODE:
                baseResult.setCode(Config.ERROR_BANNED_CODE);
                baseResult.setMsg(Config.MES_REQUEST_BANNED);
                break;
            default:
                break;
        }
        return baseResult;
    }
}

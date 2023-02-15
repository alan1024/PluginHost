package com.alan.pluginhost.controller;

import com.alan.pluginhost.config.Config;
import com.alan.pluginhost.pojo.Base.BaseResult;
import com.alan.pluginhost.pojo.FlowBean;
import com.alan.pluginhost.service.AdminService;
import com.alan.pluginhost.service.FlowService;

import java.util.ArrayList;
import java.util.List;

public class FlowController {
    FlowService flowService;
    AdminService adminService;

    public BaseResult getFlowData(String adminId) {
        BaseResult baseResult = new BaseResult();
        List<FlowBean> list = new ArrayList<>();
        try {
            FlowBean result = flowService.getFlowData(adminId);
            list.add(result);
            baseResult.setData(list);
            if (result != null) {
                baseResult.setCode(Config.SUCCESS_CODE);
                baseResult.setMsg(Config.MES_REQUEST_SUCCESS);
                return baseResult;
            }
            baseResult.setCode(Config.ERROR_CODE);
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setCode(Config.ERROR_CODE);
            baseResult.setMsg(Config.MES_SERVER_ERROR);
        }
        return baseResult;
    }

}

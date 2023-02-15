package com.alan.pluginhost.service.impl;

import com.alan.pluginhost.mapper.AdminMapper;
import com.alan.pluginhost.mapper.FlowMapper;
import com.alan.pluginhost.pojo.FlowBean;
import com.alan.pluginhost.service.FlowService;

import java.util.Date;


public class FlowServiceIml implements FlowService {

    FlowMapper flowMapper;

    AdminMapper adminMapper;

    @Override
    public FlowBean getFlowData(String adminId) throws Exception {
        FlowBean flowBean = flowMapper.getFlowData();
        if (flowBean == null) {
            flowBean = new FlowBean();
            flowBean.setPostTime(new Date());
            addFlow(flowBean);
        }
        FlowBean temp = getAllCount();
        flowBean.setAllAdminCount(temp.getAllAdminCount());
        flowBean.setAllUserCount(temp.getAllUserCount());
        flowBean.setAllJokeCount(temp.getAllJokeCount());
        flowBean.setAllCommentCount(temp.getAllCommentCount());
        flowBean.setAllThumbCount(temp.getAllThumbCount());

        return flowBean;
    }

    @Override
    public void upDateFlow(FlowBean flowBean) throws Exception {
        flowMapper.upDateFlow(flowBean);
    }

    @Override
    public void addFlow(FlowBean flowBean) throws Exception {
        flowMapper.addFlow(flowBean);
    }

    @Override
    public FlowBean getAllCount() throws Exception {
        FlowBean flowBean = new FlowBean();
        flowBean.setAllAdminCount(adminMapper.getAdminCount());
        flowBean.setAllUserCount(adminMapper.getUserCount());
        flowBean.setAllJokeCount(adminMapper.getJokeCount());
        flowBean.setAllCommentCount(adminMapper.getCommentCount());
        flowBean.setAllThumbCount(adminMapper.getThumbCount());
        return flowBean;
    }
}

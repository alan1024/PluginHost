package com.alan.pluginhost.mapper;

import com.alan.pluginhost.pojo.FlowBean;


public interface FlowMapper {
    void addFlow(FlowBean flowBean);

    FlowBean getFlowData();

    void upDateFlow(FlowBean flowBean);
}

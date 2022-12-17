package com.alan.pluginhost.pojo;

import com.alan.pluginhost.vo.NewsVo;

public class NewsPo extends NewsVo {

    private String cateStr;
    private String sourceStr;

    public String getCateStr() {
        return cateStr;
    }

    public void setCateStr(String cateStr) {
        this.cateStr = cateStr;
    }

    public String getSourceStr() {
        return sourceStr;
    }

    public void setSourceStr(String sourceStr) {
        this.sourceStr = sourceStr;
    }

    @Override
    public String toString() {
        return super.toString() + "NewsPo{" +
                "cateStr=" + cateStr +
                ", sourceStr=" + sourceStr +
                '}';
    }
}

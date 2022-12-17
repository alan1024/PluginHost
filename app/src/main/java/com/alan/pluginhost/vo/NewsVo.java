package com.alan.pluginhost.vo;

import com.alan.pluginhost.base.News;

public class NewsVo extends News {

    private Integer cid;
    private Integer sid;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

package com.alan.pluginhost.pojo;

import com.alan.pluginhost.vo.NewsVo;

public class NewsCustom extends NewsVo {

    private Integer cnum;//评论总数

    private String ccont;//分类信息

    private Integer znum;//点赞总数

    private String scont;

    public Integer getCnum() {
        return cnum;
    }

    public void setCnum(Integer cnum) {
        this.cnum = cnum;
    }

    public String getCcont() {
        return ccont;
    }

    public void setCcont(String ccont) {
        this.ccont = ccont;
    }

    public Integer getZnum() {
        return znum;
    }

    public void setZnum(Integer znum) {
        this.znum = znum;
    }

    public String getScont() {
        return scont;
    }

    public void setScont(String scont) {
        this.scont = scont;
    }
}

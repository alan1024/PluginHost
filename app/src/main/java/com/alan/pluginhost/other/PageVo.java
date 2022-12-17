package com.alan.pluginhost.other;

import java.util.List;

public class PageVo {

    private Integer start; //开始
    private Integer num; //数量
    private Integer p; //分页
    private Integer type; //操作类型
    private String title; //title
    private Integer nType; //新闻类型，normal,cata,source
    private List<Integer> nids; //新闻id

    public List<Integer> getNids() {
        return nids;
    }

    public void setNids(List<Integer> nids) {
        this.nids = nids;
    }

    public Integer getnType() {
        return nType;
    }

    public void setnType(Integer nType) {
        this.nType = nType;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getP() {
        return p;
    }

    public void setP(Integer p) {
        if (p < 0) {
            p = 1; //添加判断
        }
        this.p = p;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

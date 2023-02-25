package com.alan.pluginhost;

import java.util.List;


public class Alert2MainEvent {
    public List<MyCommentBean.Comments> alertCommList;

    public Alert2MainEvent(List<MyCommentBean.Comments> alertCommList) {
        this.alertCommList = alertCommList;
    }
}

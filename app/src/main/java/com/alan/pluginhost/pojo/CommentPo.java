package com.alan.pluginhost.pojo;

import com.alan.pluginhost.vo.CommentVo;
import com.alan.pluginhost.vo.NewsVo;
import com.alan.pluginhost.vo.UserVo;

public class CommentPo extends CommentVo {

    private UserVo userVo;
    private NewsVo newsVo;

    public UserVo getUserVo() {
        return userVo;
    }

    public void setUserVo(UserVo userVo) {
        this.userVo = userVo;
    }

    public NewsVo getNewsVo() {
        return newsVo;
    }

    public void setNewsVo(NewsVo newsVo) {
        this.newsVo = newsVo;
    }

    @Override
    public String toString() {
        return super.toString() + "CommentPo{" +
                "userVo=" + userVo +
                ", newsVo=" + newsVo +
                '}';
    }
}

package com.alan.pluginhost.pojo;

import com.alan.pluginhost.vo.LikedVo;
import com.alan.pluginhost.vo.NewsVo;
import com.alan.pluginhost.vo.UserVo;

public class LikedPo extends LikedVo {
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
        return super.toString() + "LikedPo{" +
                "userVo=" + userVo +
                ", newsVo=" + newsVo +
                '}';
    }
}

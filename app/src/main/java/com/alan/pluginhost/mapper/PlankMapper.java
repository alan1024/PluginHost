package com.alan.pluginhost.mapper;

import com.alan.pluginhost.pojo.PlankTalkBean;
import com.alan.pluginhost.pojo.TalkBean;

import java.util.List;


public interface PlankMapper {
    void addTalk(TalkBean talkBean);

    void addPlankTalk(PlankTalkBean plankTalkBean);

    List<TalkBean> getTalkList();

    List<PlankTalkBean> getPlankList();

    PlankTalkBean getLastPlank();

    void deletePlankById(String id);

    void deleteTalkById(String id);

}

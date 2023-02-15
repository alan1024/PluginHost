package com.alan.pluginhost.service;

import com.alan.pluginhost.pojo.Base.BaseListResult;
import com.alan.pluginhost.pojo.PlankTalkBean;
import com.alan.pluginhost.pojo.TalkBean;

public interface PlankService {

    TalkBean addTalk(String userId, String talkStr) throws Exception;

    PlankTalkBean addPlankTalk(String content) throws Exception;

    BaseListResult getTalkList(Integer size) throws Exception;

    BaseListResult getPlankList(Integer page, Integer row) throws Exception;

    PlankTalkBean getLastPlank() throws Exception;

    void deletePlankById(String id) throws Exception;

    void deleteTalkById(String id) throws Exception;

}

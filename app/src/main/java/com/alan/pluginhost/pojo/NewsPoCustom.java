package com.alan.pluginhost.pojo;

import com.alan.pluginhost.vo.CateVo;
import com.alan.pluginhost.vo.SourceVo;

import java.util.List;

public class NewsPoCustom {

    private NewsPo newsPo;
    private List<CateVo> cates;
    private List<SourceVo> sourceVos;

    public NewsPo getNewsPo() {
        return newsPo;
    }

    public void setNewsPo(NewsPo newsPo) {
        this.newsPo = newsPo;
    }

    public List<CateVo> getCates() {
        return cates;
    }

    public void setCates(List<CateVo> cates) {
        this.cates = cates;
    }

    public List<SourceVo> getSourceVos() {
        return sourceVos;
    }

    public void setSourceVos(List<SourceVo> sourceVos) {
        this.sourceVos = sourceVos;
    }
}

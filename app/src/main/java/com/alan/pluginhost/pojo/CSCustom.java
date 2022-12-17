package com.alan.pluginhost.pojo;

import com.alan.pluginhost.vo.CateVo;
import com.alan.pluginhost.vo.SourceVo;

import java.util.List;

public class CSCustom {

    private List<CateVo> cateVos;
    private List<SourceVo> sourceVos;

    public List<CateVo> getCateVos() {
        return cateVos;
    }

    public void setCateVos(List<CateVo> cateVos) {
        this.cateVos = cateVos;
    }

    public List<SourceVo> getSourceVos() {
        return sourceVos;
    }

    public void setSourceVos(List<SourceVo> sourceVos) {
        this.sourceVos = sourceVos;
    }
}

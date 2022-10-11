package com.alan.pluginhost.mvp.view;

import com.alan.pluginhost.base.BaseView;
import com.alan.pluginhost.model.bean.local.BPay;
import com.alan.pluginhost.model.bean.local.BSort;
import com.alan.pluginhost.model.bean.local.NoteBean;

public interface NoteView extends BaseView<NoteBean>{

    /**
     * 请求数据成功
     * @param tData
     */
    void loadDataSuccess(BSort tData);
    void loadDataSuccess(BPay tData);
}

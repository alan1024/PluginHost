package com.alan.pluginhost.mvp.view;

import com.alan.pluginhost.base.BaseView;
import com.alan.pluginhost.model.bean.BaseBean;
import com.alan.pluginhost.model.bean.local.NoteBean;

public interface BillView extends BaseView<BaseBean>{

    void loadDataSuccess(NoteBean tData);
}

package com.alan.pluginhost.mvp.presenter;

import com.alan.pluginhost.base.BasePresenter;
import com.alan.pluginhost.model.bean.local.BPay;
import com.alan.pluginhost.model.bean.local.BSort;

public abstract  class NotePresenter extends BasePresenter {

    /**
     * 获取信息
     */
    public abstract void getNote();

    /**
     * 添加账单分类
     */
    public abstract void addSort(BSort bSort);

    /**
     *添加账单支付方式
     */
    public abstract void addPay(BPay bPay);


    /**
     * 删除账单分类
     */
    public abstract void deleteSort(Long id);

    /**
     * 删除账单支出方式
     */
    public abstract void deletePay(Long id);
}

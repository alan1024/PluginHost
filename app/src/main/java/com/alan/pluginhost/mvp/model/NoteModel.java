package com.alan.pluginhost.mvp.model;

import com.alan.pluginhost.model.bean.local.BPay;
import com.alan.pluginhost.model.bean.local.BSort;

public interface NoteModel {

    void getNote();

    void addSort(BSort bSort);

    void addPay(BPay bPay);

    void deleteSort(Long id);

    void deletePay(Long id);

    void onUnsubscribe();
}

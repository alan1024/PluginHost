package com.alan.pluginhost.magicrecyclerView;


import static com.alan.pluginhost.magicrecyclerView.BaseRecyclerAdapter.RecyclerItemType.TYPE_NORMAL;

import java.io.Serializable;


public class BaseItem<T> implements Serializable {

    //数据类型
    private BaseRecyclerAdapter.RecyclerItemType mItemType;
    //实际使用的数据
    private T data;

    public BaseRecyclerAdapter.RecyclerItemType getItemType() {
        return mItemType == null ? TYPE_NORMAL : mItemType;
    }

    public void setItemType(BaseRecyclerAdapter.RecyclerItemType itemType) {
        mItemType = itemType;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}

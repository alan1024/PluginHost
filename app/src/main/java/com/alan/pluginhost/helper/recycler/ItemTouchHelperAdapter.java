package com.alan.pluginhost.helper.recycler;


public interface ItemTouchHelperAdapter {

    boolean onItemMove(int fromPosition, int toPosition);


    void onItemDismiss(int position);
}

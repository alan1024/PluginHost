package com.alan.pluginhost.loopbander;

public interface IndicatorParentImbl {

    void setIndicatorListener(IndicatorListener indicatorListener);

    int getIndicatorCount();

    void startAutoScroll();

    void stopAutoScroll();

    void onReDraw(int index);
}

package com.alan.pluginhost.util;


public class UtilServiceImpl implements UtilService {


    public UtilServiceImpl() {

    }

    public void init() {

    }


    @Override
    public double getSimilarity(long itemID1, long itemID2) {
        String url = "http://127.0.0.1:5000?newsId1=" + itemID1 + "&newsId2=" + itemID2;

        return 0;
    }
}

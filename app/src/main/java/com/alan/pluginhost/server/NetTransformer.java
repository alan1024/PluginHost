package com.alan.pluginhost.server;


import com.alan.pluginhost.model.entity.OpenApiResponse;


public class NetTransformer<T extends OpenApiResponse<E>, E> {


    //是否需要重试
    private boolean mIsNeedRetry = true;


}
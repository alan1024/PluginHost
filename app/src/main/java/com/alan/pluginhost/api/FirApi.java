package com.alan.pluginhost.api;

import android.database.Observable;

import com.alan.pluginhost.model.Version;

import retrofit.http.GET;
import retrofit.http.Query;

public interface FirApi {

    @GET(ApiConst.FIR_VERSION + "/" + ApiConst.FIR_ME_ID)
    Observable<Version> latest(@Query("api_token") String token);


}

package com.alan.pluginhost.net.services;

import com.alan.pluginhost.bean.jandan.JokeBean;
import com.alan.pluginhost.net.Constant;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface JokeApi {
    /**
     * 段子接口
     * http://i.jandan.net/?oxwlxojflwblxbsapi=jandan.get_duan_comments&page=1
     */
    //获取段子
    @GET(Constant.JOKE_BASE_URL)
    Observable<JokeBean> getDetailData(@Query("oxwlxojflwblxbsapi") String oxwlxojflwblxbsapi,
                                       @Query("page") int page
    );
}

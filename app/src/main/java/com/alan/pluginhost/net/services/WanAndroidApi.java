package com.alan.pluginhost.net.services;

import com.alan.pluginhost.bean.wanandroid.DataResponse;
import com.alan.pluginhost.bean.wanandroid.User;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface WanAndroidApi {
    /**
     * 登录接口
     * http://www.wanandroid.com/user/login
     *
     * @param username 用户名
     * @param password 密码
     */
    @POST("/user/login")
    @FormUrlEncoded
    Observable<DataResponse<User>> login(@Field("username") String username, @Field("password") String password);

    /**
     * 注册用户的方法
     * http://www.wanandroid.com/user/register
     *
     * @param username   用户名
     * @param password   密码
     * @param repassword 确认密码
     */
    @POST("/user/register")
    @FormUrlEncoded
    Observable<DataResponse> register(@Field("username") String username, @Field("password") String password, @Field("repassword") String repassword);
}

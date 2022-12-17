package com.alan.pluginhost.status;


public interface LoginStatus {

    //密码错误
    Integer PASS_ERROR = -1;

    //账号不存在
    Integer UNUM_NOT_HAVE = -2;

    //登陆失败
    Integer Login_ERROR = -3;
}

package com.alan.pluginhost.modules.video;

public class MovieResponse<T> {

    /**
     * msg : 成功
     * ret : {}
     * code : 200
     */
    private String msg;
    private T data;
    private String code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setRet(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}

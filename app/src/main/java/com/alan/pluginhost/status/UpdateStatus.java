package com.alan.pluginhost.status;

public interface UpdateStatus {

    Integer UPDATE_SUCCESS = 1; //修改成功

    Integer UPDATE_FAIL = -1; //修改失败

    Integer UPDATE_ID_ZORE = -2; //id小于等于0

}

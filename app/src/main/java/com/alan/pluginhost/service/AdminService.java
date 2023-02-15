package com.alan.pluginhost.service;

import com.alan.pluginhost.pojo.AdminBean;
import com.alan.pluginhost.pojo.Base.BaseListResult;
import com.alan.pluginhost.pojo.UserBean;

import java.util.List;

public interface AdminService {
    AdminBean getAdminByName(String name) throws Exception;

    void updateAdmin(AdminBean userBean) throws Exception;

    void deleteUserById(String userId) throws Exception;

    void deleteUserByList(List<String> userIds) throws Exception;

    BaseListResult getAllUser(Integer page, Integer row) throws Exception;

    BaseListResult searchUserList(Integer page, Integer row, UserBean userBean) throws Exception;

    void updateUserByBean(UserBean userBean) throws Exception;

}

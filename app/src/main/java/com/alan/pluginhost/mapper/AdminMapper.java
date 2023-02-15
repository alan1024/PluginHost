package com.alan.pluginhost.mapper;

import com.alan.pluginhost.pojo.AdminBean;
import com.alan.pluginhost.pojo.UserBean;

import java.util.List;

public interface AdminMapper {
    void addAdmin(AdminBean user);

    AdminBean getAdminByName(String name);

    void updateAdmin(AdminBean userBean);

    void deleteUserById(String userId);

    void deleteUserByList(List<String> userIds);

    List<UserBean> getUserList();

    List<UserBean> searchUserList(UserBean userBean);

    void updateUserByBean(UserBean userBean);

    int getAdminCount();

    int getUserCount();

    int getJokeCount();

    int getCommentCount();

    int getThumbCount();

}

package com.alan.pluginhost.service.impl;

import com.alan.pluginhost.mapper.UserMapper;
import com.alan.pluginhost.pojo.Base.BaseListResult;
import com.alan.pluginhost.pojo.UserBean;
import com.alan.pluginhost.service.UserService;

import java.util.List;


public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Override
    public UserBean addUser(UserBean userBean) {
        userMapper.addUser(userBean);
        return userBean;
    }

    @Override
    public UserBean getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    @Override
    public UserBean getUserById(String userId) throws Exception {
        return userMapper.getUserById(userId);
    }

    @Override
    public UserBean getUserByNick(String userId) throws Exception {
        return userMapper.getUserByNick(userId);
    }

    @Override
    public void updateUser(UserBean userBean) throws Exception {
        userMapper.updateUser(userBean);
    }

    @Override
    public void deleteUserById(String userId) throws Exception {
        userMapper.deleteUserById(userId);
    }

    @Override
    public void deleteUserByList(List<String> userIds) throws Exception {
        userMapper.deleteUserByList(userIds);
    }


    @Override
    public BaseListResult getAllUser(Integer page, Integer row) {
        BaseListResult base = new BaseListResult();
//        PageHelper.startPage(page, row);
//        List<UserBean> list = userMapper.getUserList();
//        int total = (int) new PageInfo<>(list).getTotal();
//        base.setData(list);
//        base.setTotal(total);
        return base;
    }
}

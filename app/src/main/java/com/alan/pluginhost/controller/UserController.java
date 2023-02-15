package com.alan.pluginhost.controller;

import static com.alan.pluginhost.config.Config.SUCCESS_CODE;

import com.alan.pluginhost.config.Config;
import com.alan.pluginhost.pojo.Base.BaseListResult;
import com.alan.pluginhost.pojo.Base.BaseResult;
import com.alan.pluginhost.pojo.UserBean;
import com.alan.pluginhost.service.JokeService;
import com.alan.pluginhost.service.UserService;
import com.alan.pluginhost.utils.IDUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserController {

    private UserService userService;

    JokeService jokeService;


    public BaseResult regist(String name, String psw, String nickname) {
        BaseResult baseResult = new BaseResult();
        List<UserBean> list = new ArrayList<>();
        try {
            UserBean user = new UserBean();
            user.setName(name);
            user.setPassword(psw);
            user.setNickname(nickname);
            user.setUserId(IDUtils.RandomId());
            user.setRegistTime(new Date());

            UserBean tempBean1 = userService.getUserByName(name);
            if (tempBean1 != null) {
                baseResult.setCode(Config.ERROR_CODE);
                baseResult.setMsg("该用户名已注册");
                return baseResult;
            }

            UserBean tempBean2 = userService.getUserByNick(nickname);
            if (tempBean2 != null) {
                baseResult.setCode(Config.ERROR_CODE);
                baseResult.setMsg("该昵称已存在");
                return baseResult;
            }

            userService.addUser(user);
            list.add(user);
            baseResult.setData(list);
            baseResult.setCode(Config.SUCCESS_CODE);
            baseResult.setMsg("注册成功");
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setCode(Config.ERROR_CODE);
            baseResult.setMsg(Config.MES_SERVER_ERROR);
        }
        return baseResult;
    }


    public BaseResult login(String name, String psw) {
        BaseResult baseResult = new BaseResult();
        List<UserBean> list = new ArrayList<>();
        UserBean userBean;
        try {
            userBean = userService.getUserByName(name);
            if (userBean == null) {
                baseResult.setMsg("不存在该用户");
                baseResult.setCode(Config.ERROR_CODE);
                return baseResult;
            } else if (!userBean.getPassword().equals(psw)) {
                baseResult.setMsg("密码错误");
                baseResult.setCode(Config.ERROR_CODE);
                return baseResult;
            } else {
                list.add(userBean);
                baseResult.setData(list);
                baseResult.setCode(Config.SUCCESS_CODE);
                baseResult.setMsg("登录成功");

                userBean.setLastLoginTime(new Date());
                userService.updateUser(userBean);
            }
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setMsg(Config.MES_SERVER_ERROR);
            baseResult.setCode(Config.ERROR_CODE);
        }
        return baseResult;
    }


    public BaseListResult getSelfJokes(Integer page, Integer row, String userId) {
        BaseListResult baseResult = new BaseListResult();
        try {
            BaseListResult result = jokeService.getUserSelfJokes(page, row, userId);
            if (result != null) {
                result.setCode(SUCCESS_CODE);
                result.setMsg(Config.MES_REQUEST_SUCCESS);
                return result;
            }
            baseResult.setCode(Config.ERROR_CODE);
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setCode(Config.ERROR_CODE);
            baseResult.setMsg(Config.MES_SERVER_ERROR);
        }
        return baseResult;

    }


    public BaseListResult getSelfLikeJokesById(Integer page, Integer row, String userId) {
        BaseListResult baseResult = new BaseListResult();
        try {
            BaseListResult result = jokeService.getJokeLikeByUserId(page, row, userId);
            if (result != null) {
                result.setCode(SUCCESS_CODE);
                result.setMsg(Config.MES_REQUEST_SUCCESS);
                return result;
            }
            baseResult.setCode(Config.ERROR_CODE);
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setCode(Config.ERROR_CODE);
            baseResult.setMsg(Config.MES_SERVER_ERROR);
        }
        return baseResult;

    }


    public BaseResult getUserInfo(String userId) {
        BaseResult baseResult = new BaseResult();
        List<UserBean> list = new ArrayList<>();
        try {
            UserBean userBean = userService.getUserById(userId);
            list.add(userBean);
            baseResult.setData(list);
            baseResult.setCode(SUCCESS_CODE);
            baseResult.setMsg(Config.MES_REQUEST_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setCode(Config.ERROR_CODE);
            baseResult.setMsg(Config.MES_SERVER_ERROR);
        }
        return baseResult;
    }


    public BaseResult modifyUserInfo(String userId, String talk, String address) {
        BaseResult baseResult = new BaseResult();
        List<UserBean> list = new ArrayList<>();
        try {
            UserBean userBean = userService.getUserById(userId);
            userBean.setTalk(talk);
            userBean.setAddress(address);
            userService.updateUser(userBean);
            list.add(userBean);
            baseResult.setData(list);
            baseResult.setCode(SUCCESS_CODE);
            baseResult.setMsg(Config.MES_REQUEST_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setCode(Config.ERROR_CODE);
            baseResult.setMsg(Config.MES_SERVER_ERROR);
        }
        return baseResult;
    }

}

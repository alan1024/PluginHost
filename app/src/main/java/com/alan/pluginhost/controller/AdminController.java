package com.alan.pluginhost.controller;


import static com.alan.pluginhost.config.Config.SUCCESS_CODE;

import com.alan.pluginhost.config.Config;
import com.alan.pluginhost.pojo.AdminBean;
import com.alan.pluginhost.pojo.Base.BaseListResult;
import com.alan.pluginhost.pojo.Base.BaseResult;
import com.alan.pluginhost.pojo.PlankTalkBean;
import com.alan.pluginhost.pojo.UserBean;
import com.alan.pluginhost.service.AdminService;
import com.alan.pluginhost.service.JokeService;
import com.alan.pluginhost.service.PlankService;
import com.alan.pluginhost.utils.SimpleUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class AdminController {
    private AdminService adminService;
    JokeService jokeService;
    PlankService plankService;

    public BaseResult login(Map<String, String> map) {
        BaseResult baseResult = new BaseResult();
        List<AdminBean> list = new ArrayList<>();
        AdminBean adminBean = null;
        String name = map.get("name");
        String psw = map.get("psw");
        try {
            adminBean = adminService.getAdminByName(name);
            if (adminBean == null) {
                baseResult.setMsg("不存在该用户");
                baseResult.setCode(Config.ERROR_CODE);
                return baseResult;
            } else if (!adminBean.getPassword().equals(psw)) {
                baseResult.setMsg("密码错误");
                baseResult.setCode(Config.ERROR_CODE);
                return baseResult;
            } else {
                list.add(adminBean);
                baseResult.setData(list);
                baseResult.setCode(SUCCESS_CODE);
                baseResult.setMsg("登录成功");

                adminBean.setLastLoginTime(new Date());
                adminService.updateAdmin(adminBean);
            }
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setMsg(Config.MES_SERVER_ERROR);
            baseResult.setCode(Config.ERROR_CODE);
        }
        return baseResult;
    }


    public BaseListResult getAllUser(Integer page, Integer row) {
        BaseListResult baseResult = new BaseListResult();
        try {
            BaseListResult result = adminService.getAllUser(page, row);
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

    public BaseListResult searchJokeList(Integer page,
                                         Integer row,
                                         String userId,
                                         String name,
                                         String nickname) {
        BaseListResult baseResult = new BaseListResult();
        try {
            UserBean userBean = new UserBean(userId, name, nickname);
            BaseListResult result = adminService.searchUserList(page, row, userBean);
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

    public BaseResult deleteUserById(Map<String, String> map) {
        BaseListResult baseResult = new BaseListResult();
        try {
            String userId = map.get("userId");
            String adminId = map.get("adminId");
            if (!Config.ADMIN_ID.equals(adminId)) {
                baseResult.setCode(Config.ERROR_CODE);
                baseResult.setMsg("没有删除权限");
                return baseResult;
            }
            adminService.deleteUserById(userId);
            baseResult.setCode(SUCCESS_CODE);
            baseResult.setMsg("删除成功");
            return baseResult;
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setCode(Config.ERROR_CODE);
            baseResult.setMsg("删除失败");
        }
        return baseResult;
    }


    public BaseResult deleteUserByList(String userIds) {
        BaseListResult baseResult = new BaseListResult();
        System.out.println("user:" + userIds);
        try {
            adminService.deleteUserByList(SimpleUtils.toList(userIds));
            baseResult.setCode(SUCCESS_CODE);
            baseResult.setMsg("删除成功");
            return baseResult;
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setCode(Config.ERROR_CODE);
            baseResult.setMsg("删除失败");
        }
        return baseResult;
    }


    public BaseResult deleteJokeById(Map<String, String> map) {
        BaseListResult baseResult = new BaseListResult();
        try {
            String jokeId = map.get("jokeId");
            String adminId = map.get("adminId");
            jokeService.deleteJokeById(jokeId);
            jokeService.deleteCommentByJokeId(jokeId);
            baseResult.setCode(SUCCESS_CODE);
            baseResult.setMsg("删除成功");
            return baseResult;
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setCode(Config.ERROR_CODE);
            baseResult.setMsg("删除失败");
        }
        return baseResult;
    }


    public BaseResult deleteJokeById(String jokeIds) {
        BaseListResult baseResult = new BaseListResult();
        System.out.println("joke:" + jokeIds);
        try {
            jokeService.deleteJokeByList(SimpleUtils.toList(jokeIds));
            baseResult.setCode(SUCCESS_CODE);
            baseResult.setMsg("删除成功");
            return baseResult;
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setCode(Config.ERROR_CODE);
            baseResult.setMsg("删除失败");
        }
        return baseResult;
    }


    public BaseResult deleteCommentList(String userIds) {
        BaseListResult baseResult = new BaseListResult();
        try {
            jokeService.deleteCommentList(SimpleUtils.toList(userIds));
            baseResult.setCode(SUCCESS_CODE);
            baseResult.setMsg("删除成功");
            return baseResult;
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setCode(Config.ERROR_CODE);
            baseResult.setMsg("删除失败");
        }
        return baseResult;
    }


    public BaseResult deleteCommentByJokeId(String jokeId,
                                            String adminId) {
        BaseListResult baseResult = new BaseListResult();
        try {
            jokeService.deleteCommentByJokeId(jokeId);
            baseResult.setCode(SUCCESS_CODE);
            baseResult.setMsg("删除成功");
            return baseResult;
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setCode(Config.ERROR_CODE);
            baseResult.setMsg("删除失败");
        }
        return baseResult;
    }


    public BaseResult deletePlankById(String id, String adminId) {
        BaseListResult baseResult = new BaseListResult();
        try {
            plankService.deletePlankById(id);
            baseResult.setCode(SUCCESS_CODE);
            baseResult.setMsg("删除成功");
            return baseResult;
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setCode(Config.ERROR_CODE);
            baseResult.setMsg("删除失败");
        }
        return baseResult;
    }


    public BaseResult deleteTalkById(String id, String adminId) {
        BaseListResult baseResult = new BaseListResult();
        try {
            plankService.deleteTalkById(id);
            baseResult.setCode(SUCCESS_CODE);
            baseResult.setMsg("删除成功");
            return baseResult;
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setCode(Config.ERROR_CODE);
            baseResult.setMsg("删除失败");
        }
        return baseResult;
    }


    public BaseResult addPlankTalk(String adminId, String content) {
        BaseResult baseResult = new BaseResult();
        try {
            PlankTalkBean plankTalkBean = plankService.addPlankTalk(content);
            List<PlankTalkBean> list = new ArrayList<>();
            list.add(plankTalkBean);
            baseResult.setData(list);
            baseResult.setCode(SUCCESS_CODE);
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setCode(Config.ERROR_CODE);
            return baseResult;
        }

        return baseResult;
    }


    public BaseResult deleteUserById(String adminId, String jsonUser) {
        BaseListResult baseResult = new BaseListResult();
        try {
            UserBean userBean = SimpleUtils.json2Pojo(jsonUser, UserBean.class);
            if (!Config.ADMIN_ID.equals(adminId)) {
                baseResult.setCode(Config.ERROR_CODE);
                baseResult.setMsg("没有修改权限");
                return baseResult;
            }
            adminService.updateUserByBean(userBean);
            baseResult.setCode(SUCCESS_CODE);
            baseResult.setMsg("更新成功");
            return baseResult;
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setCode(Config.ERROR_CODE);
            baseResult.setMsg("更新失败");
        }
        return baseResult;
    }

}

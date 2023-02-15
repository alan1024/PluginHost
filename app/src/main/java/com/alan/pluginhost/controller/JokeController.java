package com.alan.pluginhost.controller;

import static com.alan.pluginhost.config.Config.SUCCESS_CODE;

import android.text.TextUtils;

import com.alan.pluginhost.config.Config;
import com.alan.pluginhost.pojo.Base.BaseListResult;
import com.alan.pluginhost.pojo.Base.BaseResult;
import com.alan.pluginhost.pojo.CommentBean;
import com.alan.pluginhost.pojo.FlowBean;
import com.alan.pluginhost.pojo.JokeBean;
import com.alan.pluginhost.pojo.JokeLikeBean;
import com.alan.pluginhost.pojo.UserBean;
import com.alan.pluginhost.service.FlowService;
import com.alan.pluginhost.service.JokeService;
import com.alan.pluginhost.service.UserService;
import com.alan.pluginhost.utils.IDUtils;
import com.alan.pluginhost.utils.ResultHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JokeController {

    JokeService jokeService;

    UserService userService;

    FlowService flowService;


    public BaseResult addJoke(Map<String, String> map) {
        BaseResult baseResult = new BaseResult();
        try {
            UserBean user = userService.getUserById(map.get("jokeUserId"));
            if (user == null) {
                return ResultHelper.getResult(Config.ERROR_CODE);
            }
            if (user.getBanned() == 1) {
                return ResultHelper.getResult(Config.ERROR_BANNED_CODE);
            }
            JokeBean jokeBean = jokeService.addJoke(map);
            List<JokeBean> list = new ArrayList<>();
            list.add(jokeBean);
            baseResult.setData(list);
            baseResult.setCode(SUCCESS_CODE);

            FlowBean flowBean = flowService.getFlowData(map.get(Config.ADMIN_ID));
            if (flowBean == null) {
                flowBean = new FlowBean();
                flowBean.setPostTime(new Date());
                flowService.addFlow(flowBean);
            }
            String tags = map.get("tags");
            if (TextUtils.isEmpty(tags)) {
                flowBean.setClassicCount(flowBean.getClassicCount() + 1);
            } else {
                if (tags.contains("0")) {
                    flowBean.setClassicCount(flowBean.getClassicCount() + 1);
                }
                if (tags.contains("1")) {
                    flowBean.setYellowCount(flowBean.getYellowCount() + 1);
                }
                if (tags.contains("2")) {
                    flowBean.setMindCount(flowBean.getMindCount() + 1);
                }
                if (tags.contains("3")) {
                    flowBean.setShiteCount(flowBean.getShiteCount() + 1);
                }
                if (tags.contains("4")) {
                    flowBean.setColdCount(flowBean.getColdCount() + 1);
                }
            }
            flowService.upDateFlow(flowBean);
        } catch (
                Exception e) {
            e.printStackTrace();
            baseResult.setCode(Config.ERROR_CODE);
            return baseResult;
        }

        return baseResult;
    }


    public BaseListResult getAllJoke(Integer page,
                                     Integer row,
                                     String tag) {
        BaseListResult baseResult = new BaseListResult();
        try {
            BaseListResult result = jokeService.getAllJoke(page, row, tag);
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


    public BaseResult addComment(String jokeId,
                                 String userId,
                                 String details) {
        BaseResult baseResult = new BaseResult();
        try {
            UserBean user = userService.getUserById(userId);
            if (user == null) {
                return ResultHelper.getResult(Config.ERROR_CODE);
            }
            if (user.getBanned() == 1) {
                return ResultHelper.getResult(Config.ERROR_BANNED_CODE);
            }
            List<CommentBean> dataList = new ArrayList<>();

            if (TextUtils.isEmpty(userId)) {
                baseResult.setCode(Config.ERROR_CODE);
                return baseResult;
            }
            CommentBean commentBean = new CommentBean();
            commentBean.setCommentId(IDUtils.RandomId());
            commentBean.setJokeId(jokeId);
            commentBean.setCommentUserId(userId);
            commentBean.setCommentDetails(details);
            commentBean.setCommentDate(new Date());

            commentBean.setCommentNick(user.getNickname());
            commentBean.setCommentIcon(user.getUserIcon());
            jokeService.addComment(commentBean);
            baseResult.setCode(SUCCESS_CODE);
            dataList.add(commentBean);
            baseResult.setData(dataList);
            return baseResult;
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setCode(Config.ERROR_CODE);
            return baseResult;
        }
    }


    public BaseListResult getAllJokeCommentById(Integer page, Integer row, String jokeId) throws Exception {
        BaseListResult baseResult = new BaseListResult();
        try {
            BaseListResult result = jokeService.getAllJokeCommentById(page, row, jokeId);
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


    public BaseResult thumbsJoke(String jokeId, String jokeUserId) throws Exception {
        BaseResult baseResult = new BaseResult();
        boolean isThumbs = false;
        List<JokeLikeBean> likeBeans = jokeService.selectJokeLikeById(jokeId);
        for (int i = 0; i < likeBeans.size(); i++) {
            if (jokeUserId.equals(likeBeans.get(i).getJoke_user_id())) {
                // 已点赞
                isThumbs = true;
                break;
            }
        }
        if (isThumbs) {
            // 已点赞
            baseResult.setCode(Config.ERROR_CODE);
            baseResult.setMsg("你已经点过赞了");
        } else {
            Map<String, Object> map = new HashMap<>();
            map.put("joke_id", jokeId);
            map.put("article_like_count", 1);
            jokeService.changeJokeLikeCount(map);
            jokeService.thumbsJoke(jokeId, jokeUserId);
            baseResult.setCode(SUCCESS_CODE);
        }

        return baseResult;
    }


    public BaseResult deleteJokeByList(String jokeId) {
        BaseResult baseResult = new BaseResult();
        try {
            JokeBean jokeBean = jokeService.getJokeById(jokeId);
            List<JokeBean> list = new ArrayList<>();
            list.add(jokeBean);
            baseResult.setData(list);
            baseResult.setCode(Config.SUCCESS_CODE);
            baseResult.setMsg("获取数据成功");
            return baseResult;
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setCode(Config.ERROR_CODE);
            baseResult.setMsg("获取数据异常");
        }
        return baseResult;
    }


    public BaseListResult getJokeListFog(Integer page, Integer row,
                                         String key) {
        BaseListResult baseResult = new BaseListResult();
        try {
            BaseListResult result = jokeService.getJokeListFog(page, row, key);
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


    public BaseResult getThumbsJoke(String jokeId, String jokeUserId) throws Exception {
        BaseResult baseResult = new BaseResult();
        boolean isThumbs = false;

        JokeBean jokeBean = jokeService.getJokeById(jokeId);
        List<JokeBean> data = new ArrayList<>();
        data.add(jokeBean);

        List<JokeLikeBean> likeBeans = jokeService.selectJokeLikeById(jokeId);
        for (int i = 0; i < likeBeans.size(); i++) {
            if (jokeUserId.equals(likeBeans.get(i).getJoke_user_id())) {
                // 已点赞
                isThumbs = true;
                break;
            }
        }
        if (isThumbs) {
            // 已点赞
            baseResult.setCode(Config.ERROR_CODE);
        } else {
            baseResult.setCode(SUCCESS_CODE);
        }
        baseResult.setData(data);
        return baseResult;
    }


    public BaseListResult searchJokeList(Integer page, Integer row,
                                         String key,
                                         String jokeId,
                                         String jokeUserId,
                                         String category,
                                         String tags) {
        BaseListResult baseResult = new BaseListResult();
        try {
            JokeBean jokeBean = new JokeBean(key, jokeId, jokeUserId, category, tags);
            BaseListResult result = jokeService.searchJokeList(page, row, jokeBean);
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

}

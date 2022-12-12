package com.alan.pluginhost.bean;

import java.util.List;

/**
 * ClassName: NeteastNewsSummary<p>
 * Author:oubowu<p>
 * Fuction: 网易新闻详情<p>
 * CreateDate:2016/2/13 20:09<p>
 * UpdateUser:<p>
 * UpdateDate:<p>
 */
public class NeteastNewsSummary {
    public String postid;
    public boolean hasCover;
    public int hasHead;
    public int replyCount;
    public int hasImg;
    public String digest;
    public boolean hasIcon;
    public String docid;
    public String title;
    public int order;
    public int priority;
    public String lmodify;
    public String boardid;
    public String photosetID;
    public String template;
    public int votecount;
    public String skipID;
    public String alias;
    public String skipType;
    public String cid;
    public int hasAD;
    public String imgsrc;
    public String tname;
    public String ename;
    public String ptime;
    /**
     * title : 哈萨克斯坦中亚在建第1高楼爆炸起火
     * tag : photoset
     * imgsrc : http://img5.cache.netease.com/3g/2016/2/13/2016021318005710210.jpg
     * subtitle :
     * url : 00AN0001|110630
     */

    public List<AdsEntity> ads;
    /**
     * imgsrc : http://img5.cache.netease.com/3g/2016/2/13/201602131446132dc50.jpg
     */

    public List<ImgextraEntity> imgextra;

    public static class AdsEntity {
        public String title;
        public String tag;
        public String imgsrc;
        public String subtitle;
        public String url;
    }

    public static class ImgextraEntity {
        public String imgsrc;
    }
}

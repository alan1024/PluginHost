package com.alan.pluginhost.bean;

import java.util.List;

public class SinaPhotoList {

    public int status;

    public DataEntity data;

    public static class DataEntity {
        public String isIntro;

        public List<PhotoListEntity> list;

        public static class PhotoListEntity {

            /**
             * 自己加的记录测出来的宽高
             */
            public int picWidth = -1;
            public int picHeight = -1;

            public String id;
            public String title;
            public String longTitle;
            public String source;
            public String link;
            public String pic;
            public String kpic;
            public String bpic;
            public String intro;
            public int pubDate;
            public int articlePubDate;
            public String comments;

            public PicsEntity pics;
            public String feedShowStyle;
            public String category;
            public int comment;
            /**
             * qreply : 28
             * total : 64
             * show : 5
             * comment_status : 0
             * praise : 20
             * dispraise : 5
             */

            public CommentCountInfoEntity commentCountInfo;

            public static class PicsEntity {
                public int total;
                public int picTemplate;
                /**
                 * pic : http://r3.sinaimg.cn/10230/2016/0212/27/7/77567220/auto.jpg
                 * alt : 米兰达可儿
                 * kpic : http://l.sinaimg.cn/www/dy/slidenews/4_img/2016_06/704_1849131_634459.jpg/original.jpg
                 */

                public List<ListEntity> list;

                public static class ListEntity {
                    public String pic;
                    public String alt;
                    public String kpic;
                }
            }

            public static class CommentCountInfoEntity {
                public int qreply;
                public int total;
                public int show;
                public int commentStatus;
                public int praise;
                public int dispraise;
            }
        }
    }
}

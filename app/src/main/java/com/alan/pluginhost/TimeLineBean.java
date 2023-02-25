package com.alan.pluginhost;

import java.io.Serializable;
import java.util.List;

public class TimeLineBean {
    public int status;
    public List<TimelineInfo> timeline;

    public class TimelineInfo implements Serializable {
        public int timelineId;
        public String username;
        public String content;
        public String date;
        public String nickname;
        public String sex;
        public String city;
        public String headUrl;
        public int cmCount;
    }
}

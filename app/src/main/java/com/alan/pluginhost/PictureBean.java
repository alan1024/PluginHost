package com.alan.pluginhost;

import java.util.List;


public class PictureBean {
    public int status;
    public Picture pictures;

    public class Picture {
        public List<Pic> data;
    }

    public class Pic {
        public String first_pic;
        public String[] pics;
        public String title;
    }
}

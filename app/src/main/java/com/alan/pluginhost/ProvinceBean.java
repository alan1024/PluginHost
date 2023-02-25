package com.alan.pluginhost;

import java.util.List;


public class ProvinceBean {

    public List<Province> data;

    public class Province {
        public String areaName;
        public List<Cities> cities;
    }

    public class Cities {
        public String areaName;
    }
}

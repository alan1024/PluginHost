package com.alan.pluginhost.bean;

import java.util.List;

public class WeatherInfo {


    public String desc;
    public int status;

    public DataEntity data;

    public static class DataEntity {

        @Override
        public String toString() {
            return "DataEntity{" +
                    "wendu='" + wendu + '\'' +
                    ", ganmao='" + ganmao + '\'' +
                    ", yesterday=" + yesterday +
                    ", aqi='" + aqi + '\'' +
                    ", city='" + city + '\'' +
                    ", forecast=" + forecast +
                    '}';
        }

        public String wendu;
        public String ganmao;

        public YesterdayEntity yesterday;
        public String aqi;
        public String city;

        public List<ForecastEntity> forecast;

        public static class YesterdayEntity {

            @Override
            public String toString() {
                return "YesterdayEntity{" +
                        "fl='" + fl + '\'' +
                        ", fx='" + fx + '\'' +
                        ", high='" + high + '\'' +
                        ", type='" + type + '\'' +
                        ", low='" + low + '\'' +
                        ", date='" + date + '\'' +
                        '}';
            }

            public String fl;
            public String fx;
            public String high;
            public String type;
            public String low;
            public String date;
        }

        public static class ForecastEntity {

            @Override
            public String toString() {
                return "ForecastEntity{" +
                        "fengxiang='" + fengxiang + '\'' +
                        ", fengli='" + fengli + '\'' +
                        ", high='" + high + '\'' +
                        ", type='" + type + '\'' +
                        ", low='" + low + '\'' +
                        ", date='" + date + '\'' +
                        '}';
            }

            public String fengxiang;
            public String fengli;
            public String high;
            public String type;
            public String low;
            public String date;
        }
    }
}

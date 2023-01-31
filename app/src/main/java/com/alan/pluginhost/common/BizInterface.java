package com.alan.pluginhost.common;

public interface BizInterface {
    /**
     * 百度API接口
     */
    String API = "http://apis.baidu.com";
    /**
     * 百度API接口
     */
    String OPEN_API = "https://api.apiopen.top";
    /**
     * 易源API接口（官方）
     */
    String SHOW_API = "https://route.showapi.com";
    /**
     * 百度开发者API密钥
     */
    String API_KEY = "4720bdbcfb3aa457eefd38d2f8fa580f";
    /**
     * 易源api密钥
     */
    String SHOW_API_KEY = "ae06b1ecff2847dba442b9433032f489";
    /**
     * 易源appid
     */
    String SHOW_API_APPID = "31108";

    /**
     * 新闻接口
     * 服务商： 易源接口
     */
    String NEWS_URL = "/109-35";
    /**
     * 天气预报 (根据地名)
     * 服务商： 易源接口
     */
    String WEATHER_URL = "/showapi_open_bus/weather_showapi/address";

    /**
     * 美图大全 (根据类型) 已经弃用
     * "list": [
     * {
     * "id": 4001, //此id很重要，在【图片查询】接口里将使用此id进行分类查询
     * "name": "清纯"
     * },
     * {
     * "id": 4002,
     * "name": "气质"
     * },
     * {
     * "id": 4003,
     * "name": "萌女"
     * },
     * {
     * "id": 4004,
     * "name": "校花"
     * },
     * {
     * "id": 4005,
     * "name": "婚纱"
     * },
     * {
     * "id": 4006,
     * "name": "街拍"
     * },
     * {
     * "id": 4007,
     * "name": "非主流"
     * },
     * {
     * "id": 4008,
     * "name": "美腿"
     * },
     * {
     * "id": 4009,
     * "name": "性感"
     * },
     * {
     * "id": 4010,
     * "name": "车模"
     * },
     * {
     * "id": 4011,
     * "name": "男色图片"
     * },
     * {
     * "id": 4012,
     * "name": "模特美女"
     * },
     * {
     * "id": 4013,
     * "name": "美女魅惑"
     * },
     * {
     * "id": 4014,
     * "name": "日韩美女"
     * }
     * ],
     * 服务商： 易源接口
     */
    String PICTURES_URL = "/852-2";

    String OPEN_API_PICTURES_URL = "/getImages";

    String OPEN_API_WEATHER_URL = "/weatherApi";

    /**
     * 用于baseurl切换
     */
    String DOMAIN = "Domain-Name: ";

    //易源地址标签
    String DOMAIN_SHOW_API = "domain_show_api";
    //openapi标签
    String DOMAIN_OPEN_API = "domain_open_api";

}

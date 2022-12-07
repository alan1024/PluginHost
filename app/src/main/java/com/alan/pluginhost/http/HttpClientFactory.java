package com.alan.pluginhost.http;


public class HttpClientFactory {
    /**
     * http请求最大并发连接数
     */
    private static final int MAX_CONNECTIONS = 10;
    /**
     * 超时时间
     */
    private static final int TIMEOUT = 10 * 1000;
    /**
     * 缓存大小
     */
    private static final int SOCKET_BUFFER_SIZE = 8 * 1024; // 8KB


}

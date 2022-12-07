package com.alan.pluginhost.http;

public class HttpRequestCode {

    public static String ReturnCode(int code) {
        String result = null;
        switch (code) {
            case 100:
                result = "requestCode: 100 -- Continue";
                break;
            case 101:
                result = "requestCode: 101 -- Switching Protocols";
                break;
//            case 200:
//                result = "OK";
//                break;
            case 201:
                result = "requestCode: 201 -- Created";
                break;
            case 202:
                result = "requestCode: 202 -- Accepted";
                break;
            case 203:
                result = "requestCode: 203 -- Non-Authoritative Information";
                break;
            case 204:
                result = "requestCode: 204 -- No Content";
                break;
            case 205:
                result = "requestCode: 205 -- Reset Content";
                break;
            case 206:
                result = "requestCode: 206 -- Partial Content";
                break;
            case 300:
                result = "requestCode: 300 -- Multiple Choices";
                break;
            case 301:
                result = "requestCode: 301 -- Moved Permanently";
                break;
            case 302:
                result = "requestCode: 302 -- Found";
                break;
            case 303:
                result = "requestCode: 303 -- See Other";
                break;
            case 304:
                result = "requestCode: 304 -- Not Modified";
                break;
            case 305:
                result = "requestCode: 305 -- Use Proxy";
                break;
            case 307:
                result = "requestCode: 307 -- Temporary Redirect";
                break;
            case 400:
                result = "requestCode: 400 -- Bad Request";
                break;
            case 401:
                result = "requestCode: 401 -- Unauthorized";
                break;
            case 403:
                result = "requestCode: 403 -- Forbidden";
                break;
            case 404:
                result = "requestCode: 404 -- Not Found";
                break;
            case 405:
                result = "requestCode: 405 -- Method Not Allowed";
                break;
            case 406:
                result = "requestCode: 406 -- Not Acceptable";
                break;
            case 407:
                result = "requestCode: 407 -- Proxy Authentication Required";
                break;
            case 408:
                result = "requestCode: 408 -- Request Timeout";
                break;
            case 409:
                result = "requestCode: 409 -- Conflict";
                break;
            case 410:
                result = "requestCode: 410 -- Gone";
                break;
            case 411:
                result = "requestCode: 411 -- Length Required";
                break;
            case 412:
                result = "requestCode: 412 -- Precondition Failed";
                break;
            case 413:
                result = "requestCode: 413 -- Request Entity Too Large";
                break;
            case 414:
                result = "requestCode: 414 -- Request URI Too Long";
                break;
            case 416:
                result = "requestCode: 416 -- Requested Range Not Satisfiable";
                break;
            case 500:
                result = "requestCode: 500 -- Internal Server Error";
                break;
            case 501:
                result = "requestCode: 501 -- Not Implemented";
                break;
            case 502:
                result = "requestCode: 502 -- Bad Gateway";
                break;
            case 503:
                result = "requestCode: 503 -- Service Unavailable";
                break;
            case 504:
                result = "requestCode: 504 -- Gateway Timeout";
                break;
            case 505:
                result = "requestCode: 505 -- HTTP Version Not Supported";
                break;
            default:
                break;
        }
        return result;
    }
}

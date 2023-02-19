package com.alan.pluginhost.extractor;

import java.util.logging.Logger;

public class HTMLDownloader {
	private static Logger logger = Logger.getLogger(HTMLDownloader.class.getName());

	public static String down(URL u) {
		String s = null;
//		HttpClient hc = new HttpClient();
//		GetMethod get;
//		try {
//			hc.setConnectionTimeout(3000);
//			get = new GetMethod(u.url);
//			hc.executeMethod(get);
//			s = get.getResponseBodyAsString();
//			get.releaseConnection();
//		} catch (ConnectTimeoutException e) {
//			logger.warn(u.level+"连接超时");
//		} catch (HttpException e) {
//			logger.warn(u.url+"Http错误");
//		} catch (IOException e) {
//			logger.error("IO错误");
//		}
//		if(s == null || s.equals("")){
//			return s;
//		}
		return s;
	}
}

package com.alan.pluginhost;

import android.text.TextUtils;


public class NewsItem {

	public static final int LIMIT_SIZE = 20;
	public static final String LIMIT = "0,20";

	private static final String TITLE_SPITE = " - ";
	private static final String IMAGE_TAG_LIND = "url=";
	private static final String IMAGE_TAG_START = "\"><img src=\"//";
	private static final String IMAGE_TAG_END = "\" alt=\"\"";
	private static final String HTTP = "http://";
	private static final String DES_TAG = "</b></font><br /><font size=\"-1\">";

	private static final String REPLACE_TAG_1 = "<b>...";
	private static final String REPLACE_TAG_2 = "</b>";
	private static final String REPLACE_TAG_3 = "<b>";
	private static final String REPLACE_TAG_4 = "&nbsp;";

	public long _id;

	public String title;
	public String link;
	public String guid;
	public String category;
	public String pubDate;
	public String description;

	public String imageDownloadUrl;//下载图片地址
	public String imageLink;//点击图片的链接
	public String imagePath;//本地存放路径
	public String source;//新闻来源
	public int channelId;//新闻类型
	public int readStatus;//0 未读，1 已读
	public long pubDateTime;
	public long createDate;

	public String formatDate;

	@Override
	public String toString() {
		return "NewsItem [title=" + title + ", link=" + link + ", guid=" + guid
				+ ", category=" + category + ", pubDate=" + pubDate
				+ ", description=" + description + ", imageDownloadUrl=" + imageDownloadUrl
				+ ", imageLink=" + imageLink
				+ ", source=" + source + ", channelId=" + channelId
				+ ", readStatus=" + readStatus + ", pubDateTime=" + pubDateTime
				+ ", createDate=" + createDate + "]";
	}

	public void spiteTitle(String title) {
		if (!TextUtils.isEmpty(title)) {
			int lastIndex = title.lastIndexOf(TITLE_SPITE);
			if (lastIndex > -1) {
				this.title = title.substring(0, lastIndex);
				source = title.substring(lastIndex + TITLE_SPITE.length());
			} else {
				this.title = title;
			}
		}
	}

	public void fixOthers() {
		int imgLinkIndex = description.indexOf(IMAGE_TAG_LIND);
		int imgStartIndex = description.indexOf(IMAGE_TAG_START);
		if (imgStartIndex > -1) {//图片超链接,下载地址
			imageLink = description.substring(imgLinkIndex + IMAGE_TAG_LIND.length(), imgStartIndex);
			imageDownloadUrl = description.substring(imgStartIndex + IMAGE_TAG_START.length(), description.indexOf(IMAGE_TAG_END));
			if (!TextUtils.isEmpty(imageDownloadUrl) && !imageDownloadUrl.startsWith(HTTP)) {
				imageDownloadUrl = HTTP + imageDownloadUrl;
			}
		}

		int dexIndex = description.indexOf(DES_TAG);
		if (dexIndex > -1) {
			description = description.substring(dexIndex + DES_TAG.length());
			dexIndex = description.indexOf(DES_TAG);
			if (dexIndex > -1) {
				description = description.substring(0, dexIndex);
			}
		}
		description = description.replaceAll(REPLACE_TAG_1, "");
		description = description.replaceAll(REPLACE_TAG_2, "");
		description = description.replaceAll(REPLACE_TAG_3, "");
		description = description.replaceAll(REPLACE_TAG_4, "");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		return prime + ((source == null) ? 0 : source.hashCode()) + ((title == null) ? 0 : title.hashCode());
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		} else if (o instanceof NewsItem) {
			NewsItem item = (NewsItem) o;
			if (item.channelId == this.channelId
					&& (item.title.equals(this.title) || item.link.equals(this.link))) {
				return true;
			}
		}
		return false;
	}

}

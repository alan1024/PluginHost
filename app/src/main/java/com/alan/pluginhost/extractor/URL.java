/**
 *
 */
package com.alan.pluginhost.extractor;

/**
 * @author GaoShen
 * @packageName com.alan.pluginhost.MyCrawler
 */
public class URL {
    public String url;
    public int level;

    /**
     *
     */
    public URL(String url, int level) {
        this.level = level;
        this.url = url;
    }
}

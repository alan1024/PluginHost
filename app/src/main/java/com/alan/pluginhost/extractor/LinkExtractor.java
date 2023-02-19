/**
 * GS
 */
package com.alan.pluginhost.extractor;

import java.util.LinkedList;

/**
 * @author GaoShen
 * @packageName com.alan.pluginhost.extractor
 */
public interface LinkExtractor {
    public LinkedList<URL> extractFromHtml(String html, final int level);
}
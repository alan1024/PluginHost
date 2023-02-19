/**
 * GS
 */
package com.alan.pluginhost.extractor;


/**
 * Extract the main text of an url
 *
 * @author GaoShen
 * @packageName com.alan.pluginhost.extractor
 */
public interface ContentExtractor {
    public String extractFromHtml(String html);

}
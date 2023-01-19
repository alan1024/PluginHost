/*
 * Copyright 2008 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alan.pluginhost.client;

import com.alan.pluginhost.OAuth;
import com.alan.pluginhost.OAuthMessage;
import com.alan.pluginhost.OAuthProblemException;
import com.alan.pluginhost.http.HttpMessage;
import com.alan.pluginhost.http.HttpResponseMessage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * An HTTP response, encapsulated as an OAuthMessage.
 *
 * @author John Kristian
 */
final class OAuthResponseMessage extends OAuthMessage {
    OAuthResponseMessage(HttpResponseMessage http) throws IOException {
        super(http.method, http.url.toExternalForm(), null);
        this.http = http;
        getHeaders().addAll(http.headers);
        for (Map.Entry<String, String> header : http.headers) {
            if ("WWW-Authenticate".equalsIgnoreCase(header.getKey())) {
                for (OAuth.Parameter parameter : decodeAuthorization(header.getValue())) {
                    if (!"realm".equalsIgnoreCase(parameter.getKey())) {
                        addParameter(parameter);
                    }
                }
            }
        }
    }

    private final HttpMessage http;

    @Override
    public InputStream getBodyAsStream() throws IOException {
        return http.getBody();
    }

    @Override
    public String getBodyEncoding() {
        return http.getContentCharset();
    }

    @Override
    protected void completeParameters() throws IOException {
        super.completeParameters();
        String body = readBodyAsString();
        if (body != null) {
            addParameters(OAuth.decodeForm(body.trim()));
        }
    }

    @Override
    protected void dump(Map<String, Object> into) throws IOException {
        super.dump(into);
        http.dump(into);
    }

    @Override
    public void requireParameters(String... names) throws OAuthProblemException, IOException {
        try {
            super.requireParameters(names);
        } catch (OAuthProblemException problem) {
            problem.getParameters().putAll(getDump());
            throw problem;
        }
    }

}
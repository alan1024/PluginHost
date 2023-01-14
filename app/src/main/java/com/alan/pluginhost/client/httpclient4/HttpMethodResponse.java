/*
 * Copyright 2008 Sean Sullivan
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

package com.alan.pluginhost.client.httpclient4;

import com.alan.pluginhost.http.HttpResponseMessage;

import java.io.IOException;
import java.net.URL;

/**
 * An HttpResponse, encapsulated as an OAuthMessage.
 * <p>
 * This class relies on <a href="http://hc.apache.org">Apache HttpClient</a>
 * version 4.
 *
 * @author Sean Sullivan
 */
public class HttpMethodResponse extends HttpResponseMessage {


    protected HttpMethodResponse(String method, URL url) {
        super(method, url);
    }

    @Override
    public int getStatusCode() throws IOException {
        return 0;
    }
}

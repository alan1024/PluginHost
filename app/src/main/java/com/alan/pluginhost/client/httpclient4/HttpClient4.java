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

import com.alan.pluginhost.http.HttpClient;
import com.alan.pluginhost.http.HttpMessage;
import com.alan.pluginhost.http.HttpResponseMessage;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


public class HttpClient4 implements HttpClient {

    public HttpClient4() {
        this(SHARED_CLIENT);
    }

    public HttpClient4(HttpClientPool clientPool) {
        this.clientPool = clientPool;
    }

    private final HttpClientPool clientPool;

    public HttpResponseMessage execute(HttpMessage request) throws IOException {
        final String method = request.method;
        final String url = request.url.toExternalForm();
        final InputStream body = request.getBody();
        final boolean isDelete = DELETE.equalsIgnoreCase(method);
        final boolean isPost = POST.equalsIgnoreCase(method);
        final boolean isPut = PUT.equalsIgnoreCase(method);
        byte[] excerpt = null;
        return null;
    }

    private static final HttpClientPool SHARED_CLIENT = new SingleClient();

    /**
     * A pool that simply shares a single HttpClient. An HttpClient owns a pool
     * of TCP connections. So, callers that share an HttpClient will share
     * connections. Sharing improves performance (by avoiding the overhead of
     * creating connections) and uses fewer resources in the client and its
     * servers.
     */
    private static class SingleClient implements HttpClientPool {
        SingleClient() {

        }


        public HttpClient getHttpClient(URL server) {
            return null;
        }
    }

}

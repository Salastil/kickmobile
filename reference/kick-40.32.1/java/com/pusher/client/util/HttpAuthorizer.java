package com.pusher.client.util;

import com.pusher.client.Authorizer;

/* JADX INFO: loaded from: classes8.dex */
@Deprecated
public class HttpAuthorizer extends HttpChannelAuthorizer implements Authorizer {
    public HttpAuthorizer(String str) {
        super(str);
    }

    public HttpAuthorizer(String str, ConnectionFactory connectionFactory) {
        super(str, connectionFactory);
    }
}

package com.pusher.client.util;

import com.pusher.client.AuthorizationFailureException;
import com.pusher.client.ChannelAuthorizer;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class HttpChannelAuthorizer extends BaseHttpAuthClient implements ChannelAuthorizer {
    @Override // com.pusher.client.util.BaseHttpAuthClient
    public /* bridge */ /* synthetic */ Boolean isSSL() {
        return super.isSSL();
    }

    @Override // com.pusher.client.util.BaseHttpAuthClient
    public /* bridge */ /* synthetic */ void setHeaders(Map map) {
        super.setHeaders(map);
    }

    public HttpChannelAuthorizer(String str) {
        super(str);
    }

    public HttpChannelAuthorizer(String str, ConnectionFactory connectionFactory) {
        super(str, connectionFactory);
    }

    @Override // com.pusher.client.ChannelAuthorizer
    public String authorize(String str, String str2) throws AuthorizationFailureException {
        this.mConnectionFactory.setChannelName(str);
        this.mConnectionFactory.setSocketId(str2);
        return performAuthRequest();
    }

    @Override // com.pusher.client.util.BaseHttpAuthClient
    protected RuntimeException authFailureException(String str) {
        return new AuthorizationFailureException(str);
    }

    @Override // com.pusher.client.util.BaseHttpAuthClient
    protected RuntimeException authFailureException(IOException iOException) {
        return new AuthorizationFailureException(iOException);
    }
}

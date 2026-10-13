package com.pusher.client.util;

import com.pusher.client.AuthenticationFailureException;
import com.pusher.client.UserAuthenticator;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class HttpUserAuthenticator extends BaseHttpAuthClient implements UserAuthenticator {
    @Override // com.pusher.client.util.BaseHttpAuthClient
    public /* bridge */ /* synthetic */ Boolean isSSL() {
        return super.isSSL();
    }

    @Override // com.pusher.client.util.BaseHttpAuthClient
    public /* bridge */ /* synthetic */ void setHeaders(Map map) {
        super.setHeaders(map);
    }

    public HttpUserAuthenticator(String str) {
        super(str);
    }

    public HttpUserAuthenticator(String str, ConnectionFactory connectionFactory) {
        super(str, connectionFactory);
    }

    @Override // com.pusher.client.UserAuthenticator
    public String authenticate(String str) throws AuthenticationFailureException {
        this.mConnectionFactory.setSocketId(str);
        return performAuthRequest();
    }

    @Override // com.pusher.client.util.BaseHttpAuthClient
    protected RuntimeException authFailureException(String str) {
        return new AuthenticationFailureException(str);
    }

    @Override // com.pusher.client.util.BaseHttpAuthClient
    protected RuntimeException authFailureException(IOException iOException) {
        return new AuthenticationFailureException(iOException);
    }
}

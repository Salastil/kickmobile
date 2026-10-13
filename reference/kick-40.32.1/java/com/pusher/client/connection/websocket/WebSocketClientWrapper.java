package com.pusher.client.connection.websocket;

import java.net.Proxy;
import java.net.URI;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLParameters;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

/* JADX INFO: loaded from: classes11.dex */
public class WebSocketClientWrapper extends WebSocketClient {
    private static final String WSS_SCHEME = "wss";
    private WebSocketListener webSocketListener;

    public WebSocketClientWrapper(URI uri, Proxy proxy, WebSocketListener webSocketListener) throws SSLException {
        super(uri);
        if (uri.getScheme().equals(WSS_SCHEME)) {
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, null, null);
                setSocketFactory(sSLContext.getSocketFactory());
            } catch (KeyManagementException e) {
                throw new SSLException(e);
            } catch (NoSuchAlgorithmException e2) {
                throw new SSLException(e2);
            }
        }
        this.webSocketListener = webSocketListener;
        setProxy(proxy);
    }

    @Override // org.java_websocket.client.WebSocketClient
    public void onOpen(ServerHandshake serverHandshake) {
        WebSocketListener webSocketListener = this.webSocketListener;
        if (webSocketListener != null) {
            webSocketListener.onOpen(serverHandshake);
        }
    }

    @Override // org.java_websocket.client.WebSocketClient
    public void onMessage(String str) {
        WebSocketListener webSocketListener = this.webSocketListener;
        if (webSocketListener != null) {
            webSocketListener.onMessage(str);
        }
    }

    @Override // org.java_websocket.client.WebSocketClient
    public void onClose(int i, String str, boolean z) {
        WebSocketListener webSocketListener = this.webSocketListener;
        if (webSocketListener != null) {
            webSocketListener.onClose(i, str, z);
        }
    }

    @Override // org.java_websocket.client.WebSocketClient
    public void onError(Exception exc) {
        WebSocketListener webSocketListener = this.webSocketListener;
        if (webSocketListener != null) {
            webSocketListener.onError(exc);
        }
    }

    public void removeWebSocketListener() {
        this.webSocketListener = null;
    }

    @Override // org.java_websocket.client.WebSocketClient
    protected void onSetSSLParameters(SSLParameters sSLParameters) {
        try {
            super.onSetSSLParameters(sSLParameters);
        } catch (NoSuchMethodError unused) {
        }
    }
}

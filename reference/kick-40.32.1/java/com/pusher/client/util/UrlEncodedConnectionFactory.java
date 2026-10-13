package com.pusher.client.util;

import androidx.browser.trusted.sharing.ShareTarget;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class UrlEncodedConnectionFactory extends ConnectionFactory {
    private Map<String, String> mQueryStringParameters;

    public UrlEncodedConnectionFactory() {
        this.mQueryStringParameters = new HashMap();
    }

    public UrlEncodedConnectionFactory(Map<String, String> map) {
        new HashMap();
        this.mQueryStringParameters = map;
    }

    @Override // com.pusher.client.util.ConnectionFactory
    public String getCharset() {
        return "UTF-8";
    }

    @Override // com.pusher.client.util.ConnectionFactory
    public String getContentType() {
        return ShareTarget.ENCODING_TYPE_URL_ENCODED;
    }

    @Override // com.pusher.client.util.ConnectionFactory
    public String getBody() {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("socket_id=");
            sb.append(URLEncoder.encode(getSocketId(), getCharset()));
            if (getChannelName() != null) {
                sb.append("&channel_name=");
                sb.append(URLEncoder.encode(getChannelName(), getCharset()));
            }
            for (String str : this.mQueryStringParameters.keySet()) {
                sb.append("&");
                sb.append(str);
                sb.append("=");
                sb.append(URLEncoder.encode(this.mQueryStringParameters.get(str), getCharset()));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}

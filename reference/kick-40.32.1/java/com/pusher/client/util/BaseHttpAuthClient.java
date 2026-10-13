package com.pusher.client.util;

import io.ktor.http.auth.HttpAuthHeader;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes8.dex */
abstract class BaseHttpAuthClient {
    private final URL endPoint;
    protected ConnectionFactory mConnectionFactory;
    private Map<String, String> mHeaders = new HashMap();

    protected abstract RuntimeException authFailureException(IOException iOException);

    protected abstract RuntimeException authFailureException(String str);

    public BaseHttpAuthClient(String str) {
        try {
            this.endPoint = new URL(str);
            this.mConnectionFactory = new UrlEncodedConnectionFactory();
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Could not parse channel authorization end point into a valid URL", e);
        }
    }

    public BaseHttpAuthClient(String str, ConnectionFactory connectionFactory) {
        try {
            this.endPoint = new URL(str);
            this.mConnectionFactory = connectionFactory;
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Could not parse channel authorization end point into a valid URL", e);
        }
    }

    public void setHeaders(Map<String, String> map) {
        this.mHeaders = map;
    }

    public Boolean isSSL() {
        return Boolean.valueOf(this.endPoint.getProtocol().equals("https"));
    }

    protected String performAuthRequest() {
        HttpURLConnection httpURLConnection;
        try {
            String body = this.mConnectionFactory.getBody();
            HashMap map = new HashMap();
            map.put("Content-Type", this.mConnectionFactory.getContentType());
            map.put(HttpAuthHeader.Parameters.Charset, this.mConnectionFactory.getCharset());
            boolean zBooleanValue = isSSL().booleanValue();
            URL url = this.endPoint;
            if (zBooleanValue) {
                httpURLConnection = (HttpsURLConnection) url.openConnection();
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestMethod("POST");
            map.putAll(this.mHeaders);
            map.put("Content-Length", "" + body.getBytes().length);
            for (String str : map.keySet()) {
                httpURLConnection.setRequestProperty(str, (String) map.get(str));
            }
            httpURLConnection.setUseCaches(false);
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.writeBytes(body);
            dataOutputStream.flush();
            dataOutputStream.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
            }
            bufferedReader.close();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200 && responseCode != 201) {
                throw authFailureException(sb.toString());
            }
            return sb.toString();
        } catch (IOException e) {
            throw authFailureException(e);
        }
    }
}

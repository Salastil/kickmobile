package io.github.centrifugal.centrifuge;

import androidx.compose.ui.autofill.AutofillUtils_androidKt;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.net.Proxy;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes9.dex */
public class Options {
    private byte[] data;
    private Dns dns;
    private Map<String, String> headers;
    private OkHttpClient okHttpClient;
    private Proxy proxy;
    private String proxyLogin;
    private String proxyPassword;
    private SSLSocketFactory sslSocketFactory;
    private ConnectionTokenGetter tokenGetter;
    private X509TrustManager trustManager;
    private String token = "";
    private String name = "java";
    private String version = "";
    private int timeout = AutofillUtils_androidKt.MAX_AUTOFILL_TEXT_LENGTH;
    private int minReconnectDelay = 500;
    private int maxReconnectDelay = AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH;
    private int maxServerPingDelay = 10000;

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public ConnectionTokenGetter getTokenGetter() {
        return this.tokenGetter;
    }

    public void setTokenGetter(ConnectionTokenGetter connectionTokenGetter) {
        this.tokenGetter = connectionTokenGetter;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public void setHeaders(Map<String, String> map) {
        this.headers = map;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public void setTimeout(int i) {
        this.timeout = i;
    }

    public int getMinReconnectDelay() {
        return this.minReconnectDelay;
    }

    public void setMinReconnectDelay(int i) {
        this.minReconnectDelay = i;
    }

    public int getMaxReconnectDelay() {
        return this.maxReconnectDelay;
    }

    public void setMaxReconnectDelay(int i) {
        this.maxReconnectDelay = i;
    }

    public int getMaxServerPingDelay() {
        return this.maxServerPingDelay;
    }

    public void setMaxServerPingDelay(int i) {
        this.maxServerPingDelay = i;
    }

    public OkHttpClient getOkHttpClient() {
        return this.okHttpClient;
    }

    public void setOkHttpClient(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    public void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void setProxyCredentials(String str, String str2) {
        this.proxyLogin = str;
        this.proxyPassword = str2;
    }

    public String getProxyLogin() {
        return this.proxyLogin;
    }

    public String getProxyPassword() {
        return this.proxyPassword;
    }

    public Dns getDns() {
        return this.dns;
    }

    public void setDns(Dns dns) {
        this.dns = dns;
    }

    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.sslSocketFactory = sSLSocketFactory;
    }

    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
        this.sslSocketFactory = sSLSocketFactory;
        this.trustManager = x509TrustManager;
    }

    public SSLSocketFactory getSSLSocketFactory() {
        return this.sslSocketFactory;
    }

    public X509TrustManager getTrustManager() {
        return this.trustManager;
    }
}

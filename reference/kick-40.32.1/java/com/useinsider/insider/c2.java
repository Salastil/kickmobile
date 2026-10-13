package com.useinsider.insider;

import com.google.common.net.HttpHeaders;
import io.datazoom.sdk.domain.usecases.GetDeviceInfoUseCaseKt;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
class c2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f319a;
    private URL b;
    private String c;
    private final Map d;
    private String e;

    c2(String str) {
        this.f319a = str;
        this.b = a(e.f325a.isEmpty() ? "https://mobile.useinsider.com" : e.f325a);
        this.c = "POST";
        this.d = new HashMap();
    }

    c2 a(String str, String str2) {
        if (str != null && !str.isEmpty() && str2 != null && !str2.isEmpty()) {
            this.d.put(str, str2);
        }
        return this;
    }

    c2 b(String str) {
        if (str != null && !str.isEmpty()) {
            this.e = str;
        }
        return this;
    }

    c2 c(String str) {
        if (str != null && !str.isEmpty()) {
            this.c = str;
        }
        return this;
    }

    m2 a() {
        URL url;
        try {
            String str = this.e;
            if (str != null && !str.isEmpty()) {
                url = new URL(this.b, this.e);
            } else {
                url = this.b;
            }
            HashMap map = new HashMap(this.d);
            map.put(HttpHeaders.X_REQUESTED_WITH, this.f319a);
            map.put("X-Partner", this.f319a);
            map.put("X-SDK-Version", w4.i());
            map.put("X-Platform", GetDeviceInfoUseCaseKt.PLATFORM);
            return new m2(url, this.c, map, null);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid URL", e);
        }
    }

    private URL a(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid base URL", e);
        }
    }
}

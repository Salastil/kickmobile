package com.useinsider.insider;

import com.datadog.android.rum.internal.domain.battery.DefaultBatteryInfoProvider;
import com.datadog.trace.bootstrap.instrumentation.api.InstrumentationTags;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
class m2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final URL f391a;
    private final String b;
    private final Map c;
    private JSONObject d;
    private int e = DefaultBatteryInfoProvider.BATTERY_POLL_INTERVAL_MS;

    m2(URL url, String str, Map map, JSONObject jSONObject) {
        this.f391a = url;
        this.b = str;
        this.c = new HashMap(map);
        this.d = jSONObject;
    }

    void a(String str, String str2) {
        this.c.put(str, str2);
    }

    Map b() {
        return new HashMap(this.c);
    }

    String c() {
        return this.b;
    }

    int d() {
        return this.e;
    }

    URL e() {
        return this.f391a;
    }

    JSONObject f() {
        try {
            return new JSONObject().put(ImagesContract.URL, this.f391a).put(ExpoNotificationBuilder.EXTRAS_BODY_KEY, this.d).put(InstrumentationTags.TIMEOUT, this.e).put(FirebaseAnalytics.Param.METHOD, this.b).put("headers", w4.g(this.c));
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return null;
        }
    }

    JSONObject a() {
        return this.d;
    }

    void a(JSONObject jSONObject) {
        this.d = jSONObject;
    }
}

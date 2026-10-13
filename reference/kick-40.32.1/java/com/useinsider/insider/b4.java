package com.useinsider.insider;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
class b4 implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList f316a;
    private int b = 0;
    private ConcurrentHashMap c = new ConcurrentHashMap();

    b4(ArrayList arrayList) {
        this.f316a = new ArrayList();
        this.f316a = arrayList;
    }

    void a(int i) {
        this.b = i;
    }

    int b() {
        return this.b;
    }

    ArrayList c() {
        return this.f316a;
    }

    void a(ArrayList arrayList) {
        this.f316a = arrayList;
    }

    void a(JSONObject jSONObject) {
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                this.c.put(next, jSONObject.getString(next));
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    ConcurrentHashMap a() {
        return this.c;
    }
}

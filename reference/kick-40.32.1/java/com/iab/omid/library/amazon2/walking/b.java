package com.iab.omid.library.amazon2.walking;

import com.iab.omid.library.amazon2.walking.async.d;
import com.iab.omid.library.amazon2.walking.async.e;
import com.iab.omid.library.amazon2.walking.async.f;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class b implements com.iab.omid.library.amazon2.walking.async.b.InterfaceC0150b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f221a;
    private final com.iab.omid.library.amazon2.walking.async.c b;

    public b(com.iab.omid.library.amazon2.walking.async.c cVar) {
        this.b = cVar;
    }

    @Override // com.iab.omid.library.amazon2.walking.async.b.InterfaceC0150b
    public JSONObject a() {
        return this.f221a;
    }

    @Override // com.iab.omid.library.amazon2.walking.async.b.InterfaceC0150b
    public void a(JSONObject jSONObject) {
        this.f221a = jSONObject;
    }

    public void a(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.b.b(new e(this, hashSet, jSONObject, j));
    }

    public void b() {
        this.b.b(new d(this));
    }

    public void b(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.b.b(new f(this, hashSet, jSONObject, j));
    }
}

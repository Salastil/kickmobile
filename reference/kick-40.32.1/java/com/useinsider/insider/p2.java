package com.useinsider.insider;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class p2 extends d4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f412a;
    private final int b;
    private final List c;

    p2(String str, int i, List list) {
        this.f412a = str;
        this.b = i;
        this.c = list;
    }

    String a() {
        return this.f412a;
    }

    List b() {
        return this.c;
    }

    int c() {
        return this.b;
    }

    z1 d() {
        return new z1(a(), c(), new f1((List) ((List) Optional.ofNullable(b()).orElse(Collections.EMPTY_LIST)).stream().map(new Function() { // from class: com.useinsider.insider.p2$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((s2) obj).e();
            }
        }).filter(new Predicate() { // from class: com.useinsider.insider.p2$$ExternalSyntheticLambda1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Objects.nonNull((g1) obj);
            }
        }).collect(Collectors.toList())));
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", this.f412a);
        jSONObject.put("repeats", this.b);
        if (this.c != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = b().iterator();
            while (it.hasNext()) {
                jSONArray.put(((s2) it.next()).toJSONObject());
            }
            jSONObject.put("parameters", jSONArray);
        }
        return jSONObject;
    }
}

package com.useinsider.insider;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class e4 implements e5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e5 f328a;

    e4(e5 e5Var) {
        this.f328a = e5Var;
    }

    @Override // com.useinsider.insider.e5
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public List a() {
        return null;
    }

    @Override // com.useinsider.insider.e5
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public List a(Boolean bool) {
        return null;
    }

    @Override // com.useinsider.insider.e5
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public List a(Number number) {
        return null;
    }

    @Override // com.useinsider.insider.e5
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public List a(String str) {
        return null;
    }

    @Override // com.useinsider.insider.e5
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public List a(Object obj) {
        if (obj == null) {
            return a();
        }
        int i = 0;
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            ArrayList arrayList = new ArrayList(jSONArray.length());
            while (i < jSONArray.length()) {
                arrayList.add(this.f328a.b(jSONArray.opt(i)));
                i++;
            }
            return arrayList;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            ArrayList arrayList2 = new ArrayList(list.size());
            while (i < list.size()) {
                arrayList2.add(this.f328a.b(list.get(i)));
                i++;
            }
            return arrayList2;
        }
        if (!obj.getClass().isArray()) {
            return null;
        }
        int length = Array.getLength(obj);
        ArrayList arrayList3 = new ArrayList(length);
        while (i < length) {
            arrayList3.add(this.f328a.b(Array.get(obj, i)));
            i++;
        }
        return arrayList3;
    }
}

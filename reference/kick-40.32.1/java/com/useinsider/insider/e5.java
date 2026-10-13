package com.useinsider.insider;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
interface e5 {
    Object a();

    Object a(Boolean bool);

    Object a(Number number);

    Object a(Object obj);

    Object a(String str);

    default Object b(Object obj) {
        if (obj == null) {
            return a();
        }
        if (obj instanceof String) {
            return a((String) obj);
        }
        if (obj instanceof Number) {
            return a((Number) obj);
        }
        return obj instanceof Boolean ? a((Boolean) obj) : a(obj);
    }
}

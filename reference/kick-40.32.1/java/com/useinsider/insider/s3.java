package com.useinsider.insider;

import android.content.SharedPreferences;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
class s3 implements SharedPreferences.Editor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences.Editor f425a;
    private final i b;
    private final String c;

    s3(String str, SharedPreferences.Editor editor, i iVar) {
        this.c = str;
        this.f425a = editor;
        this.b = iVar;
    }

    private void a(String str, String str2, l lVar) {
        String strA;
        String strB = this.b.b(a(str), a(this.c));
        if (strB == null || strB.equals("") || w4.g(str) || (strA = this.b.a(a(str2), lVar)) == null || strA.equals("")) {
            return;
        }
        this.f425a.putString(strB, strA);
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        this.f425a.apply();
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        return this.f425a.clear();
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        return this.f425a.commit();
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        a(str, Boolean.toString(z), l.BOOLEAN);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f) {
        a(str, Float.toString(f), l.FLOAT);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i) {
        a(str, Integer.toString(i), l.INT);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j) {
        a(str, Long.toString(j), l.LONG);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        a(str, str2, l.STRING);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, Set set) {
        if (set != null) {
            a(str, a(set));
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        this.f425a.remove(this.b.b(a(str), a(this.c)));
        return this;
    }

    private void a(String str, Set set) {
        this.f425a.putStringSet(this.b.b(a(str), a(this.c)), set);
    }

    private Set a(Set set) {
        HashSet hashSet = new HashSet();
        try {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                hashSet.add(this.b.a(a((String) it.next()), l.STRING));
            }
            return hashSet;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return hashSet;
        }
    }

    private byte[] a(Object obj) {
        return String.valueOf(obj).getBytes();
    }
}

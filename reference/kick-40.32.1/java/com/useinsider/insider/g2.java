package com.useinsider.insider;

import java.util.Iterator;
import java.util.Set;
import kotlin.UByte$$ExternalSyntheticBackport0;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
class g2 implements f2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set f333a = UByte$$ExternalSyntheticBackport0.m12760m(new Object[]{"application/json"});
    private final String b = "UTF-8";
    private a c;

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    public interface a {
        Object a(n2 n2Var, String str);
    }

    g2() {
    }

    static boolean a(int i) {
        return i >= 200 && i <= 299;
    }

    void a(a aVar) {
        this.c = aVar;
    }

    @Override // com.useinsider.insider.f2
    public Object a(n2 n2Var, String str) throws i2 {
        int iB = n2Var.b();
        if (a(iB)) {
            String strA = n2Var.a();
            if (strA != null && !a(strA)) {
                throw new i2(String.format("Response content type %s is not acceptable", strA), n2Var, str);
            }
            a aVar = this.c;
            if (aVar != null) {
                return aVar.a(n2Var, str);
            }
            if (str == null) {
                return null;
            }
            try {
                String strTrim = str.trim();
                if (strTrim.startsWith("{")) {
                    return new JSONObject(str);
                }
                if (strTrim.startsWith("[")) {
                    return new JSONArray(str);
                }
                return null;
            } catch (Exception e) {
                throw new i2("Failed to deserialize JSON response", n2Var, str, e);
            }
        }
        throw new i2(String.format("Response status code %d is not acceptable", Integer.valueOf(iB)), n2Var, str);
    }

    private boolean a(String str) {
        Iterator it = this.f333a.iterator();
        while (it.hasNext()) {
            if (str.contains((String) it.next())) {
                return true;
            }
        }
        return false;
    }
}

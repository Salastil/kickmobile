package com.iab.omid.library.amazon2.walking.async;

import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class e extends a {
    public e(b.InterfaceC0150b interfaceC0150b, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(interfaceC0150b, hashSet, jSONObject, j);
    }

    private void b(String str) {
        com.iab.omid.library.amazon2.internal.c cVarC = com.iab.omid.library.amazon2.internal.c.c();
        if (cVarC != null) {
            for (com.iab.omid.library.amazon2.adsession.a aVar : cVarC.b()) {
                if (this.c.contains(aVar.c())) {
                    aVar.d().a(str, this.e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(Object... objArr) {
        return this.d.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.iab.omid.library.amazon2.walking.async.b, android.os.AsyncTask
    /* JADX INFO: renamed from: a */
    public void onPostExecute(String str) {
        b(str);
        super.onPostExecute(str);
    }
}

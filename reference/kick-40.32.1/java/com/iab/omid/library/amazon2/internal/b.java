package com.iab.omid.library.amazon2.internal;

import android.view.View;
import java.util.Iterator;

/* JADX INFO: loaded from: classes8.dex */
public class b extends d {
    private static b d = new b();

    private b() {
    }

    public static b g() {
        return d;
    }

    @Override // com.iab.omid.library.amazon2.internal.d
    public void b(boolean z) {
        Iterator<com.iab.omid.library.amazon2.adsession.a> it = c.c().b().iterator();
        while (it.hasNext()) {
            it.next().d().a(z);
        }
    }

    @Override // com.iab.omid.library.amazon2.internal.d
    public boolean d() {
        Iterator<com.iab.omid.library.amazon2.adsession.a> it = c.c().a().iterator();
        while (it.hasNext()) {
            View viewE = it.next().e();
            if (viewE != null && viewE.hasWindowFocus()) {
                return true;
            }
        }
        return false;
    }
}

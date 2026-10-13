package com.useinsider.insider;

import android.content.Intent;
import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class l3 extends k3 {
    private final z b;

    public l3(z zVar) {
        this.b = zVar;
    }

    void a(final Map map) {
        z zVar = this.b;
        if (zVar == null || zVar.a()) {
            return;
        }
        a(new Consumer() { // from class: com.useinsider.insider.l3$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((m3) obj).a(map);
            }
        });
    }

    void a(Intent intent) {
        HashMap map = new HashMap();
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        for (String str : extras.keySet()) {
            Object obj = extras.get(str);
            if (obj != null) {
                map.put(str, String.valueOf(obj));
            }
        }
        a((Map) map);
    }
}

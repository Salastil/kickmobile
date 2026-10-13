package com.google.android.play.core.integrity;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.3.0 */
/* JADX INFO: loaded from: classes5.dex */
final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static s f156a;

    static synchronized s a(Context context) {
        if (f156a == null) {
            q qVar = new q(null);
            qVar.a(com.google.android.play.integrity.internal.ag.a(context));
            f156a = qVar.b();
        }
        return f156a;
    }
}

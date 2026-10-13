package com.google.android.gms.internal.cast;

import android.view.MotionEvent;
import android.view.View;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzdk implements View.OnTouchListener {
    zzdk(zzdl zzdlVar) {
        Objects.requireNonNull(zzdlVar);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return true;
    }
}

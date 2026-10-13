package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.view.GestureDetector;
import android.view.MotionEvent;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zza extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ zzh zza;

    zza(zzh zzhVar) {
        Objects.requireNonNull(zzhVar);
        this.zza = zzhVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        zzh zzhVar = this.zza;
        zzg zzgVarZzm = zzhVar.zzm();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (zzgVarZzm == null) {
            return true;
        }
        if (zzhVar.zzj(x, y) && zzhVar.zzl().zzf(x, y)) {
            return true;
        }
        zzhVar.zzm().zzb();
        return true;
    }
}

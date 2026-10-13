package com.google.android.gms.internal.pal;

import android.app.AppOpsManager$OnOpActiveChangedListener;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzfj implements AppOpsManager$OnOpActiveChangedListener {
    final /* synthetic */ zzfk zza;

    zzfj(zzfk zzfkVar) {
        Objects.requireNonNull(zzfkVar);
        this.zza = zzfkVar;
    }

    public final void onOpActiveChanged(String str, int i, String str2, boolean z) {
        zzfk zzfkVar = this.zza;
        if (z) {
            zzfkVar.zze(System.currentTimeMillis());
            zzfkVar.zzh(true);
            return;
        }
        long jZzf = zzfkVar.zzf();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jZzf > 0 && jCurrentTimeMillis >= zzfkVar.zzf()) {
            zzfkVar.zzg(jCurrentTimeMillis - zzfkVar.zzf());
        }
        zzfkVar.zzh(false);
    }
}

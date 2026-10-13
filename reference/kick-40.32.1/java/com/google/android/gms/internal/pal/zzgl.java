package com.google.android.gms.internal.pal;

import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzgl extends zzgo {
    private final View zzh;

    public zzgl(zzfb zzfbVar, String str, String str2, zzad zzadVar, int i, int i2, View view) {
        super(zzfbVar, "K/Oo81d3D7QQWAvkxOkmH49qSlOsGQFHscMya6S21HBqr+GdnpBDhLtEJWB1CCZB", "Ge8je/arysmNa4UdtKuRe+4JSpIyhDOrTZ5OtsYb5ag=", zzadVar, i, 57);
        this.zzh = view;
    }

    @Override // com.google.android.gms.internal.pal.zzgo
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        View view = this.zzh;
        if (view != null) {
            Boolean bool = (Boolean) zzhi.zzc().zzc(zzia.zzu);
            Boolean bool2 = (Boolean) zzhi.zzc().zzc(zzia.zzw);
            zzff zzffVar = new zzff((String) this.zze.invoke(null, view, this.zza.zzb().getResources().getDisplayMetrics(), bool, bool2));
            zzbb zzbbVarZza = zzbc.zza();
            zzbbVarZza.zzb(zzffVar.zza.longValue());
            zzbbVarZza.zzc(zzffVar.zzb.longValue());
            zzbbVarZza.zzd(zzffVar.zzc.longValue());
            if (bool2.booleanValue()) {
                zzbbVarZza.zza(zzffVar.zze.longValue());
            }
            if (bool.booleanValue()) {
                zzbbVarZza.zze(zzffVar.zzd.longValue());
            }
            this.zzd.zzL((zzbc) zzbbVarZza.zzal());
        }
    }
}

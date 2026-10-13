package com.google.android.gms.internal.pal;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzgc extends zzgo {
    public zzgc(zzfb zzfbVar, String str, String str2, zzad zzadVar, int i, int i2) {
        super(zzfbVar, "IIcYtgV+jKyhXEWTRGryYoN4Hb3AaxkKFvJa61B8IsfExxFOrLfbygLFTq7UIHav", "0Td4x6cMqS7UG7AA2zcqm+bK2AW+gIwIgEtwqP1CguA=", zzadVar, i, 3);
    }

    @Override // com.google.android.gms.internal.pal.zzgo
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        Boolean bool = (Boolean) zzhi.zzc().zzc(zzia.zzr);
        bool.booleanValue();
        zzeh zzehVar = new zzeh((String) this.zze.invoke(null, this.zza.zzb(), bool));
        zzad zzadVar = this.zzd;
        synchronized (zzadVar) {
            zzadVar.zzc(zzehVar.zza);
            zzadVar.zzN(zzehVar.zzb);
        }
    }
}

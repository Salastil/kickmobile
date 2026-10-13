package com.google.android.gms.internal.pal;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzgk extends zzgo {
    public zzgk(zzfb zzfbVar, String str, String str2, zzad zzadVar, int i, int i2) {
        super(zzfbVar, "GkIdfnRezKvEfAeB5157D8Ci3lpp/e7Oge9xr/GzO3KjC7JXvYHgpg7VRCtGuOw4", "kXUmyuEurXcq5mqFokC5oFFCqidwlGAMD9JpJXYa0Mk=", zzadVar, i, 48);
    }

    @Override // com.google.android.gms.internal.pal.zzgo
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        zzad zzadVar = this.zzd;
        zzadVar.zzZ(3);
        boolean zBooleanValue = ((Boolean) this.zze.invoke(null, this.zza.zzb())).booleanValue();
        synchronized (zzadVar) {
            try {
                if (zBooleanValue) {
                    zzadVar.zzZ(2);
                } else {
                    zzadVar.zzZ(1);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

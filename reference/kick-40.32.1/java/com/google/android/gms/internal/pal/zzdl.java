package com.google.android.gms.internal.pal;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzdl implements Runnable {
    final /* synthetic */ zzdm zza;

    zzdl(zzdm zzdmVar) {
        Objects.requireNonNull(zzdmVar);
        this.zza = zzdmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdm zzdmVar = this.zza;
        synchronized (zzdmVar.zzq()) {
            if (zzdmVar.zzr()) {
                return;
            }
            zzdmVar.zzs(true);
            try {
                zzdmVar.zzo();
            } catch (Exception e) {
                this.zza.zzp().zzc(2023, -1L, e);
            }
            zzdm zzdmVar2 = this.zza;
            synchronized (zzdmVar2.zzq()) {
                zzdmVar2.zzs(false);
            }
        }
    }
}

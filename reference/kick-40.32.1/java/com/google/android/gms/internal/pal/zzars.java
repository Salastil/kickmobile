package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzars {
    private final zzarq zza;

    private zzars(zzarq zzarqVar) {
        this.zza = zzarqVar;
    }

    public static zzars zza(byte[] bArr, zzwm zzwmVar) {
        return new zzars(zzarq.zza(bArr));
    }

    public final byte[] zzb(zzwm zzwmVar) {
        return this.zza.zzb();
    }

    public final int zzc() {
        return this.zza.zzc();
    }
}

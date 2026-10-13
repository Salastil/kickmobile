package com.google.android.gms.internal.pal;

import java.math.BigInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzarr {
    private final BigInteger zza;

    private zzarr(BigInteger bigInteger) {
        this.zza = bigInteger;
    }

    public static zzarr zza(BigInteger bigInteger, zzwm zzwmVar) {
        return new zzarr(bigInteger);
    }

    public final BigInteger zzb(zzwm zzwmVar) {
        return this.zza;
    }
}

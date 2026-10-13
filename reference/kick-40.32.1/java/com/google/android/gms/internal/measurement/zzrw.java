package com.google.android.gms.internal.measurement;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzrw {
    private final Context zza;
    private final zzsh zzb = new zzsh();

    /* synthetic */ zzrw(Context context, byte[] bArr) {
        zzsq.zza(context != null, "Context cannot be null", new Object[0]);
        this.zza = context.getApplicationContext();
    }

    public final zzrx zza() {
        return new zzrx(this, null);
    }

    final /* synthetic */ Context zzb() {
        return this.zza;
    }

    final /* synthetic */ zzsh zzc() {
        return this.zzb;
    }
}

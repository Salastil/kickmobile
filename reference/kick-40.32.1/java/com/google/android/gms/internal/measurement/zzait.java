package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzait implements zzais {

    @Deprecated
    public static final zzom zza = zzagr.zzc().zza("measurement.session_stitching_token_enabled", false);

    @Override // com.google.android.gms.internal.measurement.zzais
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzais
    public final boolean zzb() {
        return ((Boolean) zza.get()).booleanValue();
    }
}

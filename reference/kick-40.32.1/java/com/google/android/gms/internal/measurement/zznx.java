package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zznx extends zzny {
    private final boolean zza;

    zznx(String str, String str2, zzph zzphVar, boolean z) {
        super("com.google.android.gms.measurement", str2, zzphVar);
        this.zza = z;
    }

    @Override // com.google.android.gms.internal.measurement.zznp
    public final /* synthetic */ Object zza() {
        return Boolean.valueOf(this.zza);
    }
}

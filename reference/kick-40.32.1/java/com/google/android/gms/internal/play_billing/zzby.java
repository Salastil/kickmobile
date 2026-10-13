package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzby extends zzbs {
    private final zzca zza;

    zzby(zzca zzcaVar, int i) {
        super(zzcaVar.size(), i);
        this.zza = zzcaVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbs
    final Object zza(int i) {
        return this.zza.get(i);
    }
}

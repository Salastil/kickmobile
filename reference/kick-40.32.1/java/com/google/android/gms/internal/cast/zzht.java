package com.google.android.gms.internal.cast;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzht extends zzhl {
    private final zzhv zza;

    zzht(zzhv zzhvVar, int i) {
        super(zzhvVar.size(), i);
        this.zza = zzhvVar;
    }

    @Override // com.google.android.gms.internal.cast.zzhl
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}

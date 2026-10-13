package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zznj extends zzmh {
    private final zznm zza;

    zznj(zznm zznmVar, int i) {
        super(zznmVar.size(), i);
        this.zza = zznmVar;
    }

    @Override // com.google.android.gms.internal.pal.zzmh
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}

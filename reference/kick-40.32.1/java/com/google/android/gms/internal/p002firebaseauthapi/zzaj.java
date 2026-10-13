package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzaj<E> extends zzab<E> {
    private final zzah<E> zza;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzab
    final E zza(int i) {
        return this.zza.get(i);
    }

    zzaj(zzah<E> zzahVar, int i) {
        super(zzahVar.size(), i);
        this.zza = zzahVar;
    }
}

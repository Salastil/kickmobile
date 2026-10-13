package com.google.firebase.auth.internal;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzo extends zzk {
    private String zza;
    private String zzb;
    private String zzc;

    @Override // com.google.firebase.auth.internal.zzk
    public final zzk zza(String str) {
        this.zzb = str;
        return this;
    }

    @Override // com.google.firebase.auth.internal.zzk
    public final zzk zzb(String str) {
        this.zzc = str;
        return this;
    }

    @Override // com.google.firebase.auth.internal.zzk
    public final zzk zzc(String str) {
        this.zza = str;
        return this;
    }

    @Override // com.google.firebase.auth.internal.zzk
    public final zzh zza() {
        return new zzl(this.zza, this.zzb, this.zzc);
    }

    zzo() {
    }
}

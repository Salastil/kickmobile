package com.google.android.gms.internal.mlkit_vision_document_scanner;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
/* JADX INFO: loaded from: classes7.dex */
public final class zznu {
    private Long zza;
    private zzmk zzb;
    private zzlq zzc;
    private Integer zzd;

    public final zznu zzc(Long l) {
        this.zza = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zznu zzd(zzmk zzmkVar) {
        this.zzb = zzmkVar;
        return this;
    }

    public final zznu zze(zzlq zzlqVar) {
        this.zzc = zzlqVar;
        return this;
    }

    public final zznu zzf(Integer num) {
        this.zzd = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final zznw zzg() {
        return new zznw(this, null);
    }
}

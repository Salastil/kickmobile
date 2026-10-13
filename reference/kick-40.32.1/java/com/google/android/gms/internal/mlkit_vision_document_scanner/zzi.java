package com.google.android.gms.internal.mlkit_vision_document_scanner;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzi {
    private final zzaa zza = new zzaa();
    private Boolean zzb;

    private zzi() {
    }

    public final zzi zza(zzq zzqVar) {
        zzt.zzc(this.zzb, "Must call internal() or external() before appending rules.");
        this.zza.zza(zzqVar);
        return this;
    }

    public final zzi zzb() {
        zzt.zzf(this.zzb == null, "A SourcePolicy can only set internal() or external() once.");
        this.zzb = false;
        return this;
    }

    public final zzi zzc() {
        zzt.zzf(this.zzb == null, "A SourcePolicy can only set internal() or external() once.");
        this.zzb = true;
        return this;
    }

    public final zzk zzd() {
        zzt.zzc(this.zzb, "Must call internal() or external() when building a SourcePolicy.");
        return new zzk(this.zzb.booleanValue(), false, this.zza.zzb(), null);
    }

    /* synthetic */ zzi(zzh zzhVar) {
    }
}

package com.google.android.gms.internal.mlkit_vision_document_scanner;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzrn implements zzrc {
    private final zzmm zza;
    private zzqc zzb = new zzqc();

    private zzrn(zzmm zzmmVar, int i) {
        this.zza = zzmmVar;
        zzrw.zza();
    }

    public static zzrc zze(zzmm zzmmVar) {
        return new zzrn(zzmmVar, 0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_document_scanner.zzrc
    public final zzrc zza(zzml zzmlVar) {
        this.zza.zzb(zzmlVar);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_document_scanner.zzrc
    public final zzrc zzb(zzqc zzqcVar) {
        this.zzb = zzqcVar;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_document_scanner.zzrc
    public final String zzc() {
        String strZzk;
        zzqe zzqeVarZze = this.zza.zzg().zze();
        return (zzqeVarZze == null || (strZzk = zzqeVarZze.zzk()) == null || strZzk.isEmpty()) ? "NA" : (String) Preconditions.checkNotNull(zzqeVarZze.zzk());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_document_scanner.zzrc
    public final byte[] zzd(int i, boolean z) {
        this.zzb.zzf(Boolean.valueOf(1 == (i ^ 1)));
        this.zzb.zze(false);
        this.zza.zzf(this.zzb.zzm());
        try {
            zzrw.zza();
            zzmm zzmmVar = this.zza;
            if (i == 0) {
                return new JsonDataEncoderBuilder().configureWith(zzkk.zza).ignoreNullValues(true).build().encode(zzmmVar.zzg()).getBytes("utf-8");
            }
            zzmo zzmoVarZzg = zzmmVar.zzg();
            zzaz zzazVar = new zzaz();
            zzkk.zza.configure(zzazVar);
            return zzazVar.zza().zza(zzmoVarZzg);
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }
}

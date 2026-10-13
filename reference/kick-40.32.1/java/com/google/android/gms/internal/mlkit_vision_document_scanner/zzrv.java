package com.google.android.gms.internal.mlkit_vision_document_scanner;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzrv {
    private static zzru zza;

    public static synchronized zzrk zza(zzrf zzrfVar) {
        if (zza == null) {
            zza = new zzru(null);
        }
        return (zzrk) zza.get(zzrfVar);
    }

    public static synchronized zzrk zzb(String str) {
        return zza(zzrf.zzd("play-services-mlkit-document-scanner").zzd());
    }
}

package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzyp implements zzvr {
    public static final /* synthetic */ int zza = 0;
    private static final Set zzb;

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("type.googleapis.com/google.crypto.tink.AesGcmKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        hashSet.add("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzb = Collections.unmodifiableSet(hashSet);
    }

    @Deprecated
    zzyp(zzaot zzaotVar, zzvr zzvrVar) throws GeneralSecurityException {
        if (zzb.contains(zzaotVar.zza())) {
            zzaotVar.zza();
            zzaos zzaosVarZzf = zzaot.zzf(zzaotVar);
            zzaosVarZzf.zzc(zzapm.RAW);
            zzwn.zzb(((zzaot) zzaosVarZzf.zzal()).zzaq());
            return;
        }
        String strZza = zzaotVar.zza();
        StringBuilder sb = new StringBuilder(String.valueOf(strZza).length() + 67);
        sb.append("Unsupported DEK key type: ");
        sb.append(strZza);
        sb.append(". Only Tink AEAD key types are supported.");
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // com.google.android.gms.internal.pal.zzvr
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }
}

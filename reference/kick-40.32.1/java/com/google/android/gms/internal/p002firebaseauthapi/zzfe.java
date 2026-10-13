package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzfe implements zzbm {
    private static final byte[] zza = new byte[0];
    private static final Set<String> zzb;
    private final String zzc;
    private final zzcs zzd;
    private final zzbm zze;

    public static zzbm zza(zzdo zzdoVar, zzbm zzbmVar) throws GeneralSecurityException {
        try {
            return new zzfe(zzxk.zza(zzdg.zza(zzdoVar), zzalf.zza()), zzbmVar);
        } catch (zzamd e) {
            throw new GeneralSecurityException(e);
        }
    }

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
    private zzfe(zzxk zzxkVar, zzbm zzbmVar) throws GeneralSecurityException {
        if (!zzb.contains(zzxkVar.zzf())) {
            throw new IllegalArgumentException("Unsupported DEK key type: " + zzxkVar.zzf() + ". Only Tink AEAD key types are supported.");
        }
        this.zzc = zzxkVar.zzf();
        this.zzd = zzdg.zza(((zzxk) ((zzalt) zzxk.zza(zzxkVar).zza(zzyi.RAW).zze())).zzk());
        this.zze = zzbmVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            int i = byteBufferWrap.getInt();
            if (i <= 0 || i > 4096 || i > bArr.length - 4) {
                throw new GeneralSecurityException("length of encrypted DEK too large");
            }
            byte[] bArr3 = new byte[i];
            byteBufferWrap.get(bArr3, 0, i);
            byte[] bArr4 = new byte[byteBufferWrap.remaining()];
            byteBufferWrap.get(bArr4, 0, byteBufferWrap.remaining());
            return ((zzbm) zzpg.zza().zza(zzpf.zza().zza(zzct.zza(this.zzc, zzakb.zza(this.zze.zza(bArr3, zza)), zzcw.zzb, zzcv.zzd, null), zzbu.zza()), zzbm.class)).zza(bArr4, bArr2);
        } catch (IndexOutOfBoundsException | NegativeArraySizeException | BufferUnderflowException e) {
            throw new GeneralSecurityException("invalid ciphertext", e);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        zzbt zzbtVarZza = zzoy.zza().zza(this.zzd, (Integer) null);
        byte[] bArrZzb = this.zze.zzb(zzpf.zza().zza(zzbtVarZza, zzbu.zza()).zzc().zzc(), zza);
        if (bArrZzb.length > 4096) {
            throw new GeneralSecurityException("length of encrypted DEK too large");
        }
        byte[] bArrZzb2 = ((zzbm) zzpg.zza().zza(zzbtVarZza, zzbm.class)).zzb(bArr, bArr2);
        return ByteBuffer.allocate(bArrZzb.length + 4 + bArrZzb2.length).putInt(bArrZzb.length).put(bArrZzb).put(bArrZzb2).array();
    }
}

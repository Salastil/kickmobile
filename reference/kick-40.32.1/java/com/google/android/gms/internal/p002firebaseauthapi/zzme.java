package com.google.android.gms.internal.p002firebaseauthapi;

import java.math.BigInteger;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzme {
    private static final byte[] zza = new byte[0];
    private final zzmf zzb;
    private final BigInteger zzc;
    private final byte[] zzd;
    private final byte[] zze;
    private final byte[] zzf;
    private BigInteger zzg = BigInteger.ZERO;

    private static zzme zza(byte[] bArr, byte[] bArr2, byte[] bArr3, zzmi zzmiVar, zzmj zzmjVar, zzmf zzmfVar, byte[] bArr4) throws GeneralSecurityException {
        byte[] bArrZza = zzms.zza(zzmiVar.zza(), zzmjVar.zzb(), zzmfVar.zzc());
        byte[] bArr5 = zzms.zzl;
        byte[] bArr6 = zza;
        byte[] bArrZza2 = zzzi.zza(bArr, zzmjVar.zza(bArr5, bArr6, "psk_id_hash", bArrZza), zzmjVar.zza(zzms.zzl, bArr4, "info_hash", bArrZza));
        byte[] bArrZza3 = zzmjVar.zza(bArr3, bArr6, "secret", bArrZza);
        byte[] bArrZza4 = zzmjVar.zza(bArrZza3, bArrZza2, "key", bArrZza, zzmfVar.zza());
        byte[] bArrZza5 = zzmjVar.zza(bArrZza3, bArrZza2, "base_nonce", bArrZza, zzmfVar.zzb());
        zzmfVar.zzb();
        return new zzme(bArr2, bArrZza4, bArrZza5, BigInteger.ONE.shiftLeft(96).subtract(BigInteger.ONE), zzmfVar);
    }

    public static zzme zza(byte[] bArr, zzmk zzmkVar, zzmi zzmiVar, zzmj zzmjVar, zzmf zzmfVar, byte[] bArr2) throws GeneralSecurityException {
        return zza(zzms.zza, bArr, zzmiVar.zza(bArr, zzmkVar), zzmiVar, zzmjVar, zzmfVar, bArr2);
    }

    static zzme zza(byte[] bArr, zzmi zzmiVar, zzmj zzmjVar, zzmf zzmfVar, byte[] bArr2) throws GeneralSecurityException {
        zzml zzmlVarZza = zzmiVar.zza(bArr);
        return zza(zzms.zza, zzmlVarZza.zza(), zzmlVarZza.zzb(), zzmiVar, zzmjVar, zzmfVar, bArr2);
    }

    private zzme(byte[] bArr, byte[] bArr2, byte[] bArr3, BigInteger bigInteger, zzmf zzmfVar) {
        this.zzf = bArr;
        this.zzd = bArr2;
        this.zze = bArr3;
        this.zzc = bigInteger;
        this.zzb = zzmfVar;
    }

    private final synchronized byte[] zzb() throws GeneralSecurityException {
        byte[] bArrZza;
        bArrZza = zzzi.zza(this.zze, zznu.zza(this.zzg, this.zzb.zzb()));
        if (this.zzg.compareTo(this.zzc) >= 0) {
            throw new GeneralSecurityException("message limit reached");
        }
        this.zzg = this.zzg.add(BigInteger.ONE);
        return bArrZza;
    }

    public final byte[] zza() {
        return this.zzf;
    }

    final byte[] zza(byte[] bArr, int i, byte[] bArr2) throws GeneralSecurityException {
        return this.zzb.zza(this.zzd, zzb(), bArr, i, bArr2);
    }

    final byte[] zzb(byte[] bArr, int i, byte[] bArr2) throws GeneralSecurityException {
        return this.zzb.zzb(this.zzd, zzb(), bArr, i, bArr2);
    }
}

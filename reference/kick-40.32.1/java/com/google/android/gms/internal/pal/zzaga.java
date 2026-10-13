package com.google.android.gms.internal.pal;

import java.math.BigInteger;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaga {
    private static final byte[] zza = new byte[0];
    private final zzafz zzb;
    private final BigInteger zzc;
    private final byte[] zzd;
    private final byte[] zze;
    private final byte[] zzf;
    private BigInteger zzg = BigInteger.ZERO;

    private zzaga(byte[] bArr, byte[] bArr2, byte[] bArr3, BigInteger bigInteger, zzafz zzafzVar) {
        this.zzf = bArr;
        this.zzd = bArr2;
        this.zze = bArr3;
        this.zzc = bigInteger;
        this.zzb = zzafzVar;
    }

    static zzaga zza(byte[] bArr, byte[] bArr2, byte[] bArr3, zzage zzageVar, zzagd zzagdVar, zzafz zzafzVar, byte[] bArr4) throws GeneralSecurityException {
        byte[] bArrZzc = zzagm.zzc(zzageVar.zzb(), zzagdVar.zzd(), zzafzVar.zzb());
        byte[] bArr5 = zzagm.zzl;
        byte[] bArr6 = zza;
        byte[] bArrZza = zzaqj.zza(bArr, zzagdVar.zza(bArr5, bArr6, "psk_id_hash", bArrZzc), zzagdVar.zza(bArr5, bArr4, "info_hash", bArrZzc));
        byte[] bArrZza2 = zzagdVar.zza(bArr3, bArr6, "secret", bArrZzc);
        return new zzaga(bArr2, zzagdVar.zzb(bArrZza2, bArrZza, "key", bArrZzc, zzafzVar.zzc()), zzagdVar.zzb(bArrZza2, bArrZza, "base_nonce", bArrZzc, 12), BigInteger.ONE.shiftLeft(96).subtract(BigInteger.ONE), zzafzVar);
    }

    private final synchronized byte[] zzd() throws GeneralSecurityException {
        byte[] bArrZzd;
        bArrZzd = zzaqj.zzd(this.zze, zzagv.zzb(this.zzg, 12));
        if (this.zzg.compareTo(this.zzc) >= 0) {
            throw new GeneralSecurityException("message limit reached");
        }
        this.zzg = this.zzg.add(BigInteger.ONE);
        return bArrZzd;
    }

    public final byte[] zzb() {
        return this.zzf;
    }

    final byte[] zzc(byte[] bArr, int i, byte[] bArr2) throws GeneralSecurityException {
        return this.zzb.zza(this.zzd, zzd(), bArr, i, bArr2);
    }
}

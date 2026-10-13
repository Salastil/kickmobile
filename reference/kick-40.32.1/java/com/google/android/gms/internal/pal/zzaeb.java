package com.google.android.gms.internal.pal;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaeb extends zzafi {
    private final zzaec zza;

    @Nullable
    private final zzarr zzb;

    @Nullable
    private final zzars zzc;

    private zzaeb(zzaec zzaecVar, @Nullable zzarr zzarrVar, @Nullable zzars zzarsVar) {
        this.zza = zzaecVar;
        this.zzb = zzarrVar;
        this.zzc = zzarsVar;
    }

    public static zzaeb zzc(zzaec zzaecVar, zzars zzarsVar) throws GeneralSecurityException {
        if (zzaecVar.zzf() == null) {
            throw new GeneralSecurityException("ECIES private key for X25519 curve cannot be constructed with NIST-curve public key");
        }
        byte[] bArrZzb = zzarsVar.zzb(zzvx.zza());
        byte[] bArrZzb2 = zzaecVar.zzf().zzb();
        if (bArrZzb.length != 32) {
            throw new GeneralSecurityException("Private key bytes length for X25519 curve must be 32");
        }
        if (Arrays.equals(zzaro.zzb(bArrZzb), bArrZzb2)) {
            return new zzaeb(zzaecVar, null, zzarsVar);
        }
        throw new GeneralSecurityException("Invalid private key for public key.");
    }

    public static zzaeb zzd(zzaec zzaecVar, zzarr zzarrVar) throws GeneralSecurityException {
        if (zzaecVar.zze() == null) {
            throw new GeneralSecurityException("ECIES private key for NIST curve cannot be constructed with X25519-curve public key");
        }
        BigInteger bigIntegerZzb = zzarrVar.zzb(zzvx.zza());
        ECPoint eCPointZze = zzaecVar.zze();
        zzadv zzadvVarZzc = zzaecVar.zzh().zzc();
        BigInteger order = zzj(zzadvVarZzc).getOrder();
        if (bigIntegerZzb.signum() <= 0 || bigIntegerZzb.compareTo(order) >= 0) {
            throw new GeneralSecurityException("Invalid private value");
        }
        if (zzagz.zzd(bigIntegerZzb, zzj(zzadvVarZzc)).equals(eCPointZze)) {
            return new zzaeb(zzaecVar, zzarrVar, null);
        }
        throw new GeneralSecurityException("Invalid private value");
    }

    private static ECParameterSpec zzj(zzadv zzadvVar) {
        if (zzadvVar == zzadv.zza) {
            return zzagz.zza;
        }
        if (zzadvVar == zzadv.zzb) {
            return zzagz.zzb;
        }
        if (zzadvVar == zzadv.zzc) {
            return zzagz.zzc;
        }
        String strValueOf = String.valueOf(zzadvVar);
        String.valueOf(strValueOf);
        throw new IllegalArgumentException("Unable to determine NIST curve type for ".concat(String.valueOf(strValueOf)));
    }

    @Override // com.google.android.gms.internal.pal.zzafi, com.google.android.gms.internal.pal.zzvz
    public final /* synthetic */ zzwk zza() {
        return this.zza.zzh();
    }

    @Nullable
    public final zzars zze() {
        return this.zzc;
    }

    @Nullable
    public final zzarr zzf() {
        return this.zzb;
    }

    public final zzaea zzg() {
        return this.zza.zzh();
    }

    public final zzaec zzh() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.pal.zzafi
    public final /* synthetic */ zzafj zzi() {
        return this.zza;
    }
}

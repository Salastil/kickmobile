package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzagc implements zzvw {
    private static final byte[] zza = new byte[0];
    private final byte[] zzb;
    private final zzage zzc;
    private final zzagd zzd;
    private final zzafz zze;
    private final byte[] zzf;

    private zzagc(zzarq zzarqVar, zzage zzageVar, zzagd zzagdVar, zzafz zzafzVar, zzarq zzarqVar2) {
        this.zzb = zzarqVar.zzb();
        this.zzc = zzageVar;
        this.zzd = zzagdVar;
        this.zze = zzafzVar;
        this.zzf = zzarqVar2.zzb();
    }

    public static zzvw zzb(zzaes zzaesVar) throws GeneralSecurityException {
        zzaej zzaejVarZze = zzaesVar.zze();
        return new zzagc(zzaesVar.zzd(), zzagh.zza(zzaejVarZze.zzc()), zzagh.zzb(zzaejVarZze.zzd()), zzagh.zzc(zzaejVarZze.zze()), zzaesVar.zzg());
    }

    @Override // com.google.android.gms.internal.pal.zzvw
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        zzage zzageVar = this.zzc;
        zzagf zzagfVarZza = zzageVar.zza(this.zzb);
        zzaga zzagaVarZza = zzaga.zza(zzagm.zza, zzagfVarZza.zzb(), zzagfVarZza.zza(), zzageVar, this.zzd, this.zze, bArr2);
        byte[] bArrZzb = zzagaVarZza.zzb();
        int length = bArrZzb.length;
        byte[] bArr3 = this.zzf;
        int length2 = bArr3.length;
        byte[] bArrZzc = zzagaVarZza.zzc(bArr, length2 + length, zza);
        System.arraycopy(bArr3, 0, bArrZzc, 0, length2);
        System.arraycopy(bArrZzb, 0, bArrZzc, length2, length);
        return bArrZzc;
    }
}

package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzmg implements zzbr {
    private static final byte[] zza = new byte[0];
    private final byte[] zzb;
    private final zzmi zzc;
    private final zzmj zzd;
    private final zzmf zze;
    private final byte[] zzf;

    public static zzbr zza(zzla zzlaVar) throws GeneralSecurityException {
        zzkq zzkqVar = (zzkq) ((zzln) zzlaVar.zza());
        return zzkqVar.zze() == zzkq.zzf.zze ? zznj.zza(zzlaVar) : new zzmg(zzlaVar.zze(), zzmn.zza(zzkqVar.zze()), zzmn.zza(zzkqVar.zzd()), zzmn.zza(zzkqVar.zzb()), zzlaVar.zzd());
    }

    private zzmg(zzaau zzaauVar, zzmi zzmiVar, zzmj zzmjVar, zzmf zzmfVar, zzaau zzaauVar2) {
        this.zzb = zzaauVar.zzb();
        this.zzc = zzmiVar;
        this.zzd = zzmjVar;
        this.zze = zzmfVar;
        this.zzf = zzaauVar2.zzb();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbr
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        zzme zzmeVarZza = zzme.zza(this.zzb, this.zzc, this.zzd, this.zze, bArr2);
        byte[] bArrZza = zzmeVarZza.zza();
        byte[] bArrZzb = zzmeVarZza.zzb(bArr, this.zzf.length + bArrZza.length, zza);
        byte[] bArr3 = this.zzf;
        System.arraycopy(bArr3, 0, bArrZzb, 0, bArr3.length);
        System.arraycopy(bArrZza, 0, bArrZzb, this.zzf.length, bArrZza.length);
        return bArrZzb;
    }
}

package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzmh implements zzbs {
    private static final byte[] zza = new byte[0];
    private final zzmk zzb;
    private final zzmi zzc;
    private final zzmj zzd;
    private final zzmf zze;
    private final int zzf;
    private final byte[] zzg;

    public static zzbs zza(zzks zzksVar) throws GeneralSecurityException {
        int i;
        zzkq zzkqVar = (zzkq) ((zzln) zzksVar.zza());
        if (zzkqVar.zze() == zzkq.zzf.zze) {
            return zznh.zza(zzksVar);
        }
        zzmi zzmiVarZza = zzmn.zza(zzkqVar.zze());
        zzmj zzmjVarZza = zzmn.zza(zzkqVar.zzd());
        zzmf zzmfVarZza = zzmn.zza(zzkqVar.zzb());
        zzkq.zzf zzfVarZze = zzkqVar.zze();
        if (zzfVarZze.equals(zzkq.zzf.zzd)) {
            i = 32;
        } else if (zzfVarZze.equals(zzkq.zzf.zza)) {
            i = 65;
        } else if (zzfVarZze.equals(zzkq.zzf.zzb)) {
            i = 97;
        } else {
            if (!zzfVarZze.equals(zzkq.zzf.zzc)) {
                throw new GeneralSecurityException("Unrecognized or not NIST HPKE KEM identifier");
            }
            i = 133;
        }
        int i2 = i;
        zzkq.zzf zzfVarZze2 = ((zzkq) ((zzln) zzksVar.zza())).zze();
        if (zzfVarZze2.equals(zzkq.zzf.zzd) || zzfVarZze2.equals(zzkq.zzf.zza) || zzfVarZze2.equals(zzkq.zzf.zzb) || zzfVarZze2.equals(zzkq.zzf.zzc)) {
            return new zzmh(new zzmk(zzaau.zza(zzksVar.zzf().zza(zzbu.zza())), ((zzla) ((zzlp) zzksVar.zzc())).zze()), zzmiVarZza, zzmjVarZza, zzmfVarZza, i2, zzksVar.zzh());
        }
        throw new GeneralSecurityException("Unrecognized or not NIST HPKE KEM identifier");
    }

    private zzmh(zzmk zzmkVar, zzmi zzmiVar, zzmj zzmjVar, zzmf zzmfVar, int i, zzaau zzaauVar) {
        this.zzb = zzmkVar;
        this.zzc = zzmiVar;
        this.zzd = zzmjVar;
        this.zze = zzmfVar;
        this.zzf = i;
        this.zzg = zzaauVar.zzb();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbs
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzg;
        int length = bArr3.length + this.zzf;
        if (bArr.length < length) {
            throw new GeneralSecurityException("Ciphertext is too short.");
        }
        if (!zzqu.zza(bArr3, bArr)) {
            throw new GeneralSecurityException("Invalid ciphertext (output prefix mismatch)");
        }
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        return zzme.zza(Arrays.copyOfRange(bArr, this.zzg.length, length), this.zzb, this.zzc, this.zzd, this.zze, bArr2).zza(bArr, length, zza);
    }
}

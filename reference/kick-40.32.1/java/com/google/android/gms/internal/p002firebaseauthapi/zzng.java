package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzng implements zzmi {
    private final zzmc zza;
    private final zznb zzb;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmi
    public final zzml zza(byte[] bArr) throws GeneralSecurityException {
        zzne zzneVarZza = this.zzb.zza();
        byte[] bArr2 = zzneVarZza.zza;
        byte[] bArr3 = zzneVarZza.zzb;
        return new zzml(zza(this.zzb.zza(bArr2, bArr), bArr3, bArr), bArr3);
    }

    zzng(zzmc zzmcVar) {
        zznb zznfVar;
        this.zza = zzmcVar;
        try {
            zznfVar = zznd.zzb();
        } catch (GeneralSecurityException unused) {
            zznfVar = new zznf();
        }
        this.zzb = zznfVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmi
    public final byte[] zza(byte[] bArr, zzmk zzmkVar) throws GeneralSecurityException {
        return zza(this.zzb.zza(zzmkVar.zza().zzb(), bArr), bArr, zzmkVar.zzb().zzb());
    }

    private final byte[] zza(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        byte[] bArrZza = zzzi.zza(bArr2, bArr3);
        byte[] bArrZza2 = zzms.zza(zzms.zzb);
        zzmc zzmcVar = this.zza;
        return zzmcVar.zza(null, bArr, "eae_prk", bArrZza, "shared_secret", bArrZza2, zzmcVar.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmi
    public final byte[] zza() throws GeneralSecurityException {
        if (Arrays.equals(this.zza.zzb(), zzms.zzf)) {
            return zzms.zzb;
        }
        throw new GeneralSecurityException("Could not determine HPKE KEM ID");
    }
}

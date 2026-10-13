package com.google.android.gms.internal.pal;

import java.security.InvalidAlgorithmParameterException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final /* synthetic */ class zzacv implements zzaiw {
    static final /* synthetic */ zzacv zza = new zzacv();

    private /* synthetic */ zzacv() {
    }

    @Override // com.google.android.gms.internal.pal.zzaiw
    public final /* synthetic */ Object zza(zzvz zzvzVar) throws InvalidAlgorithmParameterException {
        zzacs zzacsVar = (zzacs) zzvzVar;
        int i = zzacw.zza;
        zzacz zzaczVarZzf = zzacsVar.zzf();
        if (zzaczVarZzf.zzc() == 64) {
            return zzaqf.zzb(zzacsVar);
        }
        int iZzc = zzaczVarZzf.zzc();
        StringBuilder sb = new StringBuilder(String.valueOf(iZzc).length() + 50);
        sb.append("invalid key size: ");
        sb.append(iZzc);
        sb.append(". Valid keys must have 64 bytes.");
        throw new InvalidAlgorithmParameterException(sb.toString());
    }
}

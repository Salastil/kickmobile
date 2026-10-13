package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final /* synthetic */ class zzyq implements zzaiw {
    static final /* synthetic */ zzyq zza = new zzyq();

    private /* synthetic */ zzyq() {
    }

    @Override // com.google.android.gms.internal.pal.zzaiw
    public final /* synthetic */ Object zza(zzvz zzvzVar) throws GeneralSecurityException {
        zzzb zzzbVar = (zzzb) zzvzVar;
        int i = zzys.zza;
        String strZzb = zzzbVar.zze().zzb();
        zzwr zzwrVarZzd = zzzbVar.zze().zzd();
        zzvr zzvrVarZzb = zzwi.zza(strZzb).zzb();
        int i2 = zzyp.zza;
        try {
            return zzabu.zzc(new zzyp(zzaot.zzd(zzwn.zza(zzwrVarZzd), zzaty.zza()), zzvrVarZzb), zzzbVar.zzc());
        } catch (zzavb e) {
            throw new GeneralSecurityException(e);
        }
    }
}

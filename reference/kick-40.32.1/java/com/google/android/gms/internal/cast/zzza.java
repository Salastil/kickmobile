package com.google.android.gms.internal.cast;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzza implements zzzt {
    private static final zzzg zzb = new zzyy();
    private final zzzg zza;

    public zzza() {
        zzzg zzzgVar = zzb;
        int i = zzxb.zza;
        zzyz zzyzVar = new zzyz(zzxz.zza(), zzzgVar);
        byte[] bArr = zzym.zzb;
        this.zza = zzyzVar;
    }

    @Override // com.google.android.gms.internal.cast.zzzt
    public final zzzs zza(Class cls) {
        int i = zzzu.zza;
        if (!zzyd.class.isAssignableFrom(cls)) {
            int i2 = zzxb.zza;
        }
        zzzf zzzfVarZzc = this.zza.zzc(cls);
        if (zzzfVarZzc.zza()) {
            int i3 = zzxb.zza;
            return zzzm.zzi(zzzu.zzB(), zzxu.zza(), zzzfVarZzc.zzb());
        }
        int i4 = zzxb.zza;
        return zzzl.zzi(cls, zzzfVarZzc, zzzo.zza(), zzyw.zza(), zzzu.zzB(), zzzfVarZzc.zzc() + (-1) != 1 ? zzxu.zza() : null, zzze.zza());
    }
}

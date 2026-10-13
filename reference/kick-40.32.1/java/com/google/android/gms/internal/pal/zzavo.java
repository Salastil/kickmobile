package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzavo implements zzawo {
    private static final zzavu zzb = new zzavm();
    private final zzavu zza;

    public zzavo() {
        zzavu zzavuVar = zzb;
        int i = zzata.zza;
        zzavn zzavnVar = new zzavn(zzauh.zza(), zzavuVar);
        byte[] bArr = zzauz.zzb;
        this.zza = zzavnVar;
    }

    @Override // com.google.android.gms.internal.pal.zzawo
    public final zzawn zza(Class cls) {
        int i = zzawp.zza;
        if (!zzaun.class.isAssignableFrom(cls)) {
            int i2 = zzata.zza;
        }
        zzavt zzavtVarZzc = this.zza.zzc(cls);
        if (zzavtVarZzc.zza()) {
            int i3 = zzata.zza;
            return zzawa.zzh(zzawp.zzB(), zzaub.zza(), zzavtVarZzc.zzb());
        }
        int i4 = zzata.zza;
        return zzavz.zzm(cls, zzavtVarZzc, zzawc.zza(), zzavk.zza(), zzawp.zzB(), zzavtVarZzc.zzc() + (-1) != 1 ? zzaub.zza() : null, zzavs.zza());
    }
}

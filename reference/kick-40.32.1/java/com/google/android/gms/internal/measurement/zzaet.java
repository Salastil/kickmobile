package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzaet {
    private static final zzafa zzb = new zzaer();
    private final zzafa zza;

    public zzaet() {
        zzafa zzafaVar = zzb;
        int i = zzacf.zza;
        this.zza = new zzaes(zzado.zza(), zzafaVar);
    }

    public final zzafp zza(Class cls) {
        int i = zzafq.zza;
        if (!zzadu.class.isAssignableFrom(cls)) {
            int i2 = zzacf.zza;
        }
        zzaez zzaezVarZzc = this.zza.zzc(cls);
        if (zzaezVarZzc.zza()) {
            int i3 = zzacf.zza;
            return zzafg.zzh(zzafq.zzB(), zzadi.zza(), zzaezVarZzc.zzb());
        }
        int i4 = zzacf.zza;
        return zzaff.zzm(cls, zzaezVarZzc, zzafi.zza(), zzaep.zza(), zzafq.zzB(), zzaezVarZzc.zzc() + (-1) != 1 ? zzadi.zza() : null, zzaey.zza());
    }
}

package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzqe {
    public static final zzqe zzc = new zzqa();
    public static final zzqe zzd = new zzqa();

    protected zzqe() {
    }

    static zzqe zzc(zzqe zzqeVar, zzqe zzqeVar2) {
        zzqe zzqeVar3;
        zzqe zzqeVar4;
        if (zzqeVar != null) {
            if (zzqeVar2 == null || zzqeVar == (zzqeVar3 = zzc) || zzqeVar2 == (zzqeVar4 = zzd)) {
                return zzqeVar;
            }
            if (zzqeVar2 != zzqeVar3 && zzqeVar != zzqeVar4) {
                return new zzqb(zzqeVar, zzqeVar2);
            }
        }
        return zzqeVar2;
    }

    protected abstract void zzb();
}

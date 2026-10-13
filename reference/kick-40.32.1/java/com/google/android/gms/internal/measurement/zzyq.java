package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzyq {
    public static final zzyq zzc = new zzym();
    public static final zzyq zzd = new zzym();

    protected zzyq() {
    }

    static zzyq zzc(zzyq zzyqVar, zzyq zzyqVar2) {
        zzyq zzyqVar3;
        zzyq zzyqVar4;
        if (zzyqVar != null) {
            if (zzyqVar2 == null || zzyqVar == (zzyqVar3 = zzc) || zzyqVar2 == (zzyqVar4 = zzd)) {
                return zzyqVar;
            }
            if (zzyqVar2 != zzyqVar3 && zzyqVar != zzyqVar4) {
                return new zzyn(zzyqVar, zzyqVar2);
            }
        }
        return zzyqVar2;
    }

    protected abstract void zzb();
}

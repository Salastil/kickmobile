package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzavn implements zzavu {
    private final zzavu[] zza;

    zzavn(zzavu... zzavuVarArr) {
        this.zza = zzavuVarArr;
    }

    @Override // com.google.android.gms.internal.pal.zzavu
    public final boolean zzb(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (this.zza[i].zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.pal.zzavu
    public final zzavt zzc(Class cls) {
        for (int i = 0; i < 2; i++) {
            zzavu zzavuVar = this.zza[i];
            if (zzavuVar.zzb(cls)) {
                return zzavuVar.zzc(cls);
            }
        }
        String name = cls.getName();
        String.valueOf(name);
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(String.valueOf(name)));
    }
}

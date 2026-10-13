package com.google.android.gms.internal.pal;

import java.util.function.BinaryOperator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final /* synthetic */ class zzmj implements BinaryOperator {
    static final /* synthetic */ zzmj zza = new zzmj();

    private /* synthetic */ zzmj() {
    }

    @Override // java.util.function.BiFunction
    public final /* synthetic */ Object apply(Object obj, Object obj2) {
        zzni zzniVar = (zzni) obj2;
        zzni zzniVar2 = (zzni) obj;
        zzniVar2.zzb(zzniVar.zza, zzniVar.zzb);
        return zzniVar2;
    }
}

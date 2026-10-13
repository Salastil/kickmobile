package com.google.android.gms.internal.measurement;

import androidx.collection.SimpleArrayMap;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzwk extends zzwl {
    static final zzwl zza;
    static final zzwl zzb;

    static {
        zzwl zzwlVarZzb = new zzwk(null, new SimpleArrayMap(0)).zzb();
        zza = zzwlVarZzb;
        zzwk zzwkVar = new zzwk(zzwlVarZzb, new SimpleArrayMap(), null);
        Preconditions.checkState(!zzwkVar.zzh(), "Can't mutate after handing to trace");
        Preconditions.checkNotNull(true);
        zzwj zzwjVar = zzwl.zza;
        Preconditions.checkState(true ^ zzwkVar.zzd(zzwjVar), "Key already present");
        zzwkVar.zzg().put(zzwjVar, true);
        zzb = zzwkVar.zzb();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private zzwk(zzwl zzwlVar, SimpleArrayMap simpleArrayMap) {
        super(null, simpleArrayMap, 0 == true ? 1 : 0);
    }

    /* synthetic */ zzwk(zzwl zzwlVar, SimpleArrayMap simpleArrayMap, byte[] bArr) {
        super(zzwlVar, simpleArrayMap, null);
    }
}

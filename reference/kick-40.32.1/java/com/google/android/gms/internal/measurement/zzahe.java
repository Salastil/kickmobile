package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzahe implements Supplier {
    private static final zzahe zza = new zzahe();
    private final Supplier zzb = Suppliers.ofInstance(new zzahg());

    @SideEffectFree
    public static String zza() {
        return zza.get().zza();
    }

    @SideEffectFree
    public static String zzb() {
        return zza.get().zzb();
    }

    @SideEffectFree
    public static String zzc() {
        return zza.get().zzc();
    }

    @Override // com.google.common.base.Supplier
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final zzahf get() {
        return (zzahf) this.zzb.get();
    }
}

package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzahg implements zzahf {

    @Deprecated
    public static final zzom zza;

    @Deprecated
    public static final zzom zzb;

    @Deprecated
    public static final zzom zzc;

    static {
        zzog zzogVarZzc = zzagr.zzc();
        zza = zzogVarZzc.zzd("45761323", "");
        zzb = zzogVarZzc.zzd("45762029", "");
        zzc = zzogVarZzc.zzd("45762030", "");
    }

    @Override // com.google.android.gms.internal.measurement.zzahf
    public final String zza() {
        return (String) zza.get();
    }

    @Override // com.google.android.gms.internal.measurement.zzahf
    public final String zzb() {
        return (String) zzb.get();
    }

    @Override // com.google.android.gms.internal.measurement.zzahf
    public final String zzc() {
        return (String) zzc.get();
    }
}

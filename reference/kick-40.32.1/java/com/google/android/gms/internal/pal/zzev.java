package com.google.android.gms.internal.pal;

import android.view.View;
import com.datadog.android.rum.internal.instrumentation.gestures.GesturesListener;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzev implements zzkm {
    private final zzje zza;
    private final zzjq zzb;
    private final zzfi zzc;
    private final zzeu zzd;
    private final zzee zze;
    private final zzfk zzf;
    private final zzfc zzg;
    private final zzet zzh;

    zzev(zzje zzjeVar, zzjq zzjqVar, zzfi zzfiVar, zzeu zzeuVar, zzee zzeeVar, zzfk zzfkVar, zzfc zzfcVar, zzet zzetVar) {
        this.zza = zzjeVar;
        this.zzb = zzjqVar;
        this.zzc = zzfiVar;
        this.zzd = zzeuVar;
        this.zze = zzeeVar;
        this.zzf = zzfkVar;
        this.zzg = zzfcVar;
        this.zzh = zzetVar;
    }

    private final Map zze() {
        HashMap map = new HashMap();
        zzje zzjeVar = this.zza;
        zzbd zzbdVarZzb = this.zzb.zzb();
        map.put("v", zzjeVar.zza());
        map.put("gms", Boolean.valueOf(zzjeVar.zzc()));
        map.put("gv", Long.valueOf(zzbdVarZzb.zzc()));
        map.put("int", zzbdVarZzb.zzb());
        map.put("attts", Long.valueOf(zzbdVarZzb.zze().zzb()));
        map.put("att", zzbdVarZzb.zze().zzd());
        map.put("attkid", zzbdVarZzb.zze().zzc());
        map.put(GesturesListener.SCROLL_DIRECTION_UP, Boolean.valueOf(this.zzd.zza()));
        map.put("t", new Throwable());
        zzfc zzfcVar = this.zzg;
        map.put("tcq", Long.valueOf(zzfcVar.zze()));
        map.put("tpq", Long.valueOf(zzfcVar.zzd()));
        map.put("tcv", Long.valueOf(zzfcVar.zzf()));
        map.put("tpv", Long.valueOf(zzfcVar.zzg()));
        map.put("tchv", Long.valueOf(zzfcVar.zzi()));
        map.put("tphv", Long.valueOf(zzfcVar.zzh()));
        map.put("tcc", Long.valueOf(zzfcVar.zzj()));
        map.put("tpc", Long.valueOf(zzfcVar.zzk()));
        zzee zzeeVar = this.zze;
        if (zzeeVar != null) {
            map.put("nt", Long.valueOf(zzeeVar.zzc()));
        }
        zzfk zzfkVar = this.zzf;
        map.put("vs", Long.valueOf(zzfkVar.zzc()));
        map.put("vf", Long.valueOf(zzfkVar.zzd()));
        return map;
    }

    final void zza(View view) {
        this.zzc.zza(view);
    }

    @Override // com.google.android.gms.internal.pal.zzkm
    public final Map zzb() {
        return zze();
    }

    @Override // com.google.android.gms.internal.pal.zzkm
    public final Map zzc() {
        Map mapZze = zze();
        mapZze.put("vst", this.zzh.zza());
        return mapZze;
    }

    @Override // com.google.android.gms.internal.pal.zzkm
    public final Map zzd() {
        zzfi zzfiVar = this.zzc;
        Map mapZze = zze();
        mapZze.put("lts", Long.valueOf(zzfiVar.zzc()));
        return mapZze;
    }
}

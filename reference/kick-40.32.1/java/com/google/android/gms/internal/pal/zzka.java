package com.google.android.gms.internal.pal;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzka implements zzjf {
    private final Object zza;
    private final zzkb zzb;
    private final zzkm zzc;
    private final zzjc zzd;

    zzka(Object obj, zzkb zzkbVar, zzkm zzkmVar, zzjc zzjcVar, boolean z) {
        this.zza = obj;
        this.zzb = zzkbVar;
        this.zzc = zzkmVar;
        this.zzd = zzjcVar;
    }

    private static String zzi(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        zzbv zzbvVarZza = zzbw.zza();
        zzbvVarZza.zzd(5);
        zzbvVarZza.zza(zzatl.zzr(bArr, 0, bArr.length));
        return Base64.encodeToString(((zzbw) zzbvVarZza.zzal()).zzaq(), 11);
    }

    private final synchronized byte[] zzj(Map map, Map map2) {
        Object obj;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            obj = this.zza;
        } catch (Exception e) {
            this.zzd.zzc(2007, System.currentTimeMillis() - jCurrentTimeMillis, e);
            return null;
        }
        return (byte[]) obj.getClass().getDeclaredMethod("xss", Map.class, Map.class).invoke(obj, null, map2);
    }

    @Override // com.google.android.gms.internal.pal.zzjf
    public final synchronized String zza(Context context, String str) {
        Map mapZzb;
        mapZzb = this.zzc.zzb();
        mapZzb.put("f", "q");
        mapZzb.put("ctx", context);
        mapZzb.put("aid", null);
        return zzi(zzj(null, mapZzb));
    }

    @Override // com.google.android.gms.internal.pal.zzjf
    public final synchronized String zzb(Context context, String str, View view, Activity activity) {
        Map mapZzc;
        mapZzc = this.zzc.zzc();
        mapZzc.put("f", "v");
        mapZzc.put("ctx", context);
        mapZzc.put("aid", null);
        mapZzc.put("view", view);
        mapZzc.put("act", activity);
        return zzi(zzj(null, mapZzc));
    }

    @Override // com.google.android.gms.internal.pal.zzjf
    public final synchronized String zzc(Context context, String str, String str2, View view, Activity activity) {
        Map mapZzd;
        mapZzd = this.zzc.zzd();
        mapZzd.put("f", "c");
        mapZzd.put("ctx", context);
        mapZzd.put("cs", str2);
        mapZzd.put("aid", null);
        mapZzd.put("view", view);
        mapZzd.put("act", activity);
        return zzi(zzj(null, mapZzd));
    }

    @Override // com.google.android.gms.internal.pal.zzjf
    public final synchronized void zzd(String str, MotionEvent motionEvent) throws zzkk {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            HashMap map = new HashMap();
            map.put("t", new Throwable());
            map.put("aid", null);
            map.put("evt", motionEvent);
            Object obj = this.zza;
            obj.getClass().getDeclaredMethod("he", Map.class).invoke(obj, map);
            this.zzd.zzb(3003, System.currentTimeMillis() - jCurrentTimeMillis);
        } catch (Exception e) {
            throw new zzkk(2005, e);
        }
    }

    final zzkb zze() {
        return this.zzb;
    }

    final synchronized boolean zzf() throws zzkk {
        Object obj;
        try {
            obj = this.zza;
        } catch (Exception e) {
            throw new zzkk(2001, e);
        }
        return ((Boolean) obj.getClass().getDeclaredMethod("init", null).invoke(obj, null)).booleanValue();
    }

    public final synchronized void zzg() throws zzkk {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Object obj = this.zza;
            obj.getClass().getDeclaredMethod("close", null).invoke(obj, null);
            this.zzd.zzb(3001, System.currentTimeMillis() - jCurrentTimeMillis);
        } catch (Exception e) {
            throw new zzkk(2003, e);
        }
    }

    public final synchronized int zzh() throws zzkk {
        Object obj;
        try {
            obj = this.zza;
        } catch (Exception e) {
            throw new zzkk(2006, e);
        }
        return ((Integer) obj.getClass().getDeclaredMethod("lcs", null).invoke(obj, null)).intValue();
    }
}

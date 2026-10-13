package com.google.android.gms.internal.pal;

import android.content.Context;
import android.os.Bundle;
import androidx.media3.common.PlaybackException;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzkl {
    private static final HashMap zza = new HashMap();
    private final Context zzb;
    private final zzkm zzc;
    private final zzjc zzd;
    private final zzix zze;
    private zzka zzf;
    private final Object zzg = new Object();

    public zzkl(Context context, zzkm zzkmVar, zzjc zzjcVar, zzix zzixVar, boolean z) {
        this.zzb = context;
        this.zzc = zzkmVar;
        this.zzd = zzjcVar;
        this.zze = zzixVar;
    }

    private final synchronized Class zzd(zzkb zzkbVar) throws zzkk {
        String strZza = zzkbVar.zza().zza();
        HashMap map = zza;
        Class cls = (Class) map.get(strZza);
        if (cls != null) {
            return cls;
        }
        try {
            if (!this.zze.zza(zzkbVar.zzb())) {
                throw new zzkk(2026, "VM did not pass signature verification");
            }
            try {
                File fileZzc = zzkbVar.zzc();
                if (!fileZzc.exists()) {
                    fileZzc.mkdirs();
                }
                Class clsLoadClass = new DexClassLoader(zzkbVar.zzb().getAbsolutePath(), fileZzc.getAbsolutePath(), null, this.zzb.getClassLoader()).loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
                map.put(strZza, clsLoadClass);
                return clsLoadClass;
            } catch (ClassNotFoundException | IllegalArgumentException | SecurityException e) {
                throw new zzkk(2008, e);
            }
        } catch (GeneralSecurityException e2) {
            throw new zzkk(2026, e2);
        }
    }

    public final boolean zza(zzkb zzkbVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                zzka zzkaVar = new zzka(zzd(zzkbVar).getDeclaredConstructor(Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE).newInstance(this.zzb, "msa-r", zzkbVar.zzd(), null, new Bundle(), 2), zzkbVar, this.zzc, this.zzd, false);
                if (!zzkaVar.zzf()) {
                    throw new zzkk(4000, "init failed");
                }
                int iZzh = zzkaVar.zzh();
                if (iZzh != 0) {
                    StringBuilder sb = new StringBuilder(String.valueOf(iZzh).length() + 4);
                    sb.append("ci: ");
                    sb.append(iZzh);
                    throw new zzkk(PlaybackException.ERROR_CODE_DECODER_INIT_FAILED, sb.toString());
                }
                synchronized (this.zzg) {
                    zzka zzkaVar2 = this.zzf;
                    if (zzkaVar2 != null) {
                        try {
                            zzkaVar2.zzg();
                        } catch (zzkk e) {
                            this.zzd.zzc(e.zza(), -1L, e);
                        }
                        this.zzf = zzkaVar;
                    } else {
                        this.zzf = zzkaVar;
                    }
                    throw th;
                }
                this.zzd.zzb(3000, System.currentTimeMillis() - jCurrentTimeMillis);
                return true;
            } catch (Exception e2) {
                throw new zzkk(2004, e2);
            }
        } catch (zzkk e3) {
            this.zzd.zzc(e3.zza(), System.currentTimeMillis() - jCurrentTimeMillis, e3);
            return false;
        } catch (Exception e4) {
            this.zzd.zzc(4010, System.currentTimeMillis() - jCurrentTimeMillis, e4);
            return false;
        }
    }

    public final zzjf zzb() {
        zzka zzkaVar;
        synchronized (this.zzg) {
            zzkaVar = this.zzf;
        }
        return zzkaVar;
    }

    public final zzkb zzc() {
        synchronized (this.zzg) {
            zzka zzkaVar = this.zzf;
            if (zzkaVar == null) {
                return null;
            }
            return zzkaVar.zze();
        }
    }
}

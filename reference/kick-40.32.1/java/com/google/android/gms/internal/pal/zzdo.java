package com.google.android.gms.internal.pal;

import android.os.ConditionVariable;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzdo {
    protected volatile Boolean zzb;
    private final zzfb zzc;
    private static final ConditionVariable zzd = new ConditionVariable();
    protected static volatile zzko zza = null;
    private static volatile Random zze = null;

    public zzdo(zzfb zzfbVar) {
        this.zzc = zzfbVar;
        zzfbVar.zzd().execute(new zzdn(this));
    }

    public static final int zzd() {
        try {
            return ThreadLocalRandom.current().nextInt();
        } catch (RuntimeException unused) {
            return zze().nextInt();
        }
    }

    private static Random zze() {
        if (zze == null) {
            synchronized (zzdo.class) {
                if (zze == null) {
                    zze = new Random();
                }
            }
        }
        return zze;
    }

    public final void zza(int i, int i2, long j, String str, Exception exc) {
        try {
            zzd.block();
            if (!this.zzb.booleanValue() || zza == null) {
                return;
            }
            zzn zznVarZza = zzr.zza();
            zznVarZza.zza(this.zzc.zza.getPackageName());
            zznVarZza.zzb(j);
            if (str != null) {
                zznVarZza.zze(str);
            }
            if (exc != null) {
                StringWriter stringWriter = new StringWriter();
                exc.printStackTrace(new PrintWriter(stringWriter));
                zznVarZza.zzc(stringWriter.toString());
                zznVarZza.zzd(exc.getClass().getName());
            }
            zzkn zzknVarZza = zza.zza(((zzr) zznVarZza.zzal()).zzaq());
            zzknVarZza.zzc(i);
            if (i2 != -1) {
                zzknVarZza.zzb(i2);
            }
            zzknVarZza.zza();
        } catch (Exception unused) {
        }
    }

    final /* synthetic */ zzfb zzb() {
        return this.zzc;
    }
}

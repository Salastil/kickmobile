package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzyi;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public class zzxi<API extends zzyi<API>> {
    private final zzzf zza;

    protected zzxi(zzzf zzzfVar) {
        this.zza = zzzfVar;
    }

    private static void zzd(String str, zzzd zzzdVar) {
        StringBuilder sb = new StringBuilder();
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        sb.append(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(new Date(zzzdVar.zzf() / 1000000)));
        sb.append(": logging error [");
        zzze.zza(1, zzzdVar.zzg(), sb);
        sb.append("]: ");
        sb.append(str);
        System.err.println(sb);
        System.err.flush();
    }

    protected final String zza() {
        return this.zza.zza();
    }

    protected final boolean zzb(Level level) {
        return this.zza.zzb(level);
    }

    final void zzc(zzzd zzzdVar) {
        try {
            zzabt zzabtVarZzc = zzabt.zzc();
            try {
                if (zzabtVarZzc.zzb() <= 100) {
                    this.zza.zzc(zzzdVar);
                } else {
                    zzd("unbounded recursion in log statement", zzzdVar);
                }
                if (zzabtVarZzc != null) {
                    zzabtVarZzc.close();
                }
            } catch (Throwable th) {
                if (zzabtVarZzc != null) {
                    try {
                        zzabtVarZzc.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (RuntimeException e) {
            try {
                this.zza.zzd(e, zzzdVar);
            } catch (zzzg e2) {
                throw e2;
            } catch (RuntimeException e3) {
                String name = e3.getClass().getName();
                String message = e3.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 2 + String.valueOf(message).length());
                sb.append(name);
                sb.append(": ");
                sb.append(message);
                zzd(sb.toString(), zzzdVar);
                try {
                    e3.printStackTrace(System.err);
                } catch (RuntimeException unused) {
                }
            }
        }
    }
}

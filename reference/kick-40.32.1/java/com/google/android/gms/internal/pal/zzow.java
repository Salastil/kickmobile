package com.google.android.gms.internal.pal;

import com.google.android.gms.internal.pal.zzpw;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzow<API extends zzpw<API>> {
    private final zzqt zza;

    protected zzow(zzqt zzqtVar) {
        this.zza = zzqtVar;
    }

    private static void zzf(String str, zzqr zzqrVar) {
        StringBuilder sb = new StringBuilder();
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        sb.append(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(new Date(zzqrVar.zzf() / 1000000)));
        sb.append(": logging error [");
        zzqs.zza(1, zzqrVar.zzg(), sb);
        sb.append("]: ");
        sb.append(str);
        System.err.println(sb);
        System.err.flush();
    }

    public abstract zzpw zza(Level level);

    public final zzpw zzb() {
        return zza(Level.WARNING);
    }

    protected final String zzc() {
        return this.zza.zza();
    }

    protected final boolean zzd(Level level) {
        return this.zza.zzb(level);
    }

    final void zze(zzqr zzqrVar) {
        try {
            zzth zzthVarZzc = zzth.zzc();
            try {
                if (zzthVarZzc.zzb() <= 100) {
                    this.zza.zzc(zzqrVar);
                } else {
                    zzf("unbounded recursion in log statement", zzqrVar);
                }
                if (zzthVarZzc != null) {
                    zzthVarZzc.close();
                }
            } catch (Throwable th) {
                if (zzthVarZzc != null) {
                    try {
                        zzthVarZzc.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (RuntimeException e) {
            try {
                this.zza.zzd(e, zzqrVar);
            } catch (zzqu e2) {
                throw e2;
            } catch (RuntimeException e3) {
                String name = e3.getClass().getName();
                String message = e3.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 2 + String.valueOf(message).length());
                sb.append(name);
                sb.append(": ");
                sb.append(message);
                zzf(sb.toString(), zzqrVar);
                try {
                    e3.printStackTrace(System.err);
                } catch (RuntimeException unused) {
                }
            }
        }
    }
}

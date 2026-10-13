package com.google.android.gms.internal.measurement;

import android.os.Build;
import android.util.Log;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import kotlin.text.Typography;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzaao extends zzaag {
    static final boolean zza;
    static final boolean zzb;
    static final boolean zzc;
    private static final AtomicReference zzd;
    private static final AtomicLong zzf;
    private static final ConcurrentLinkedQueue zzg;
    private volatile zzzf zze;

    static {
        zza = Build.FINGERPRINT == null || "robolectric".equals(Build.FINGERPRINT);
        zzb = "goldfish".equals(Build.HARDWARE) || "ranchu".equals(Build.HARDWARE);
        zzc = "eng".equals(Build.TYPE) || "userdebug".equals(Build.TYPE);
        zzd = new AtomicReference();
        zzf = new AtomicLong();
        zzg = new ConcurrentLinkedQueue();
    }

    private zzaao(String str) {
        super(str);
        if (zza || zzb) {
            this.zze = new zzaah().zza(zza());
        } else if (zzc) {
            this.zze = zzaas.zze().zzb(false).zza(zza());
        } else {
            this.zze = null;
        }
    }

    public static zzzf zze(String str) {
        char cCharAt;
        AtomicReference atomicReference = zzd;
        if (atomicReference.get() != null) {
            return ((zzaai) atomicReference.get()).zza(str);
        }
        int length = str.length();
        do {
            length--;
            if (length < 0) {
                break;
            }
            cCharAt = str.charAt(length);
            if (cCharAt == '$') {
                str = str.replace(Typography.dollar, FilenameUtils.EXTENSION_SEPARATOR);
                break;
            }
        } while (cCharAt != '.');
        zzaao zzaaoVar = new zzaao(str);
        ConcurrentLinkedQueue concurrentLinkedQueue = zzaam.zza;
        concurrentLinkedQueue.offer(zzaaoVar);
        if (atomicReference.get() != null) {
            while (true) {
                zzaao zzaaoVar2 = (zzaao) concurrentLinkedQueue.poll();
                if (zzaaoVar2 == null) {
                    break;
                }
                zzaaoVar2.zze = ((zzaai) atomicReference.get()).zza(zzaaoVar2.zza());
            }
            zzf();
        }
        return zzaaoVar;
    }

    private static void zzf() {
        while (true) {
            zzaan zzaanVar = (zzaan) zzg.poll();
            if (zzaanVar == null) {
                return;
            }
            zzf.getAndDecrement();
            zzzf zzzfVarZza = zzaanVar.zza();
            zzzd zzzdVarZzb = zzaanVar.zzb();
            if (zzzdVarZzb.zzk() || zzzfVarZza.zzb(zzzdVarZzb.zze())) {
                zzzfVarZza.zzc(zzzdVarZzb);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzzf
    public final boolean zzb(Level level) {
        return this.zze == null || this.zze.zzb(level);
    }

    @Override // com.google.android.gms.internal.measurement.zzzf
    public final void zzc(zzzd zzzdVar) {
        if (this.zze != null) {
            this.zze.zzc(zzzdVar);
            return;
        }
        if (zzf.incrementAndGet() > 20) {
            zzg.poll();
            Log.w("ProxyAndroidLoggerBackend", "Too many Flogger logs received before configuration. Dropping old logs.");
        }
        zzg.offer(new zzaan(this, zzzdVar));
        if (this.zze != null) {
            zzf();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzaag, com.google.android.gms.internal.measurement.zzzf
    public final void zzd(RuntimeException runtimeException, zzzd zzzdVar) {
        if (this.zze != null) {
            this.zze.zzd(runtimeException, zzzdVar);
        } else {
            Log.e("ProxyAndroidLoggerBackend", "Internal logging error before configuration", runtimeException);
        }
    }
}

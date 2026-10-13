package com.google.android.gms.internal.pal;

import android.os.Build;
import android.util.Log;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import kotlin.text.Typography;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzsc extends zzru {
    static final boolean zza;
    static final boolean zzb;
    static final boolean zzc;
    private static final AtomicReference zzd;
    private static final AtomicLong zzf;
    private static final ConcurrentLinkedQueue zzg;
    private volatile zzqt zze;

    static {
        zza = Build.FINGERPRINT == null || "robolectric".equals(Build.FINGERPRINT);
        zzb = "goldfish".equals(Build.HARDWARE) || "ranchu".equals(Build.HARDWARE);
        zzc = "eng".equals(Build.TYPE) || "userdebug".equals(Build.TYPE);
        zzd = new AtomicReference();
        zzf = new AtomicLong();
        zzg = new ConcurrentLinkedQueue();
    }

    private zzsc(String str) {
        super(str);
        if (zza || zzb) {
            this.zze = new zzrv().zza(zza());
        } else if (zzc) {
            this.zze = zzsg.zze().zzb(false).zza(zza());
        } else {
            this.zze = null;
        }
    }

    public static zzqt zze(String str) {
        char cCharAt;
        AtomicReference atomicReference = zzd;
        if (atomicReference.get() != null) {
            return ((zzrw) atomicReference.get()).zza(str);
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
        zzsc zzscVar = new zzsc(str);
        ConcurrentLinkedQueue concurrentLinkedQueue = zzsa.zza;
        concurrentLinkedQueue.offer(zzscVar);
        if (atomicReference.get() != null) {
            while (true) {
                zzsc zzscVar2 = (zzsc) concurrentLinkedQueue.poll();
                if (zzscVar2 == null) {
                    break;
                }
                zzscVar2.zze = ((zzrw) atomicReference.get()).zza(zzscVar2.zza());
            }
            zzf();
        }
        return zzscVar;
    }

    private static void zzf() {
        while (true) {
            zzsb zzsbVar = (zzsb) zzg.poll();
            if (zzsbVar == null) {
                return;
            }
            zzf.getAndDecrement();
            zzqt zzqtVarZza = zzsbVar.zza();
            zzqr zzqrVarZzb = zzsbVar.zzb();
            if (zzqrVarZzb.zzk() || zzqtVarZza.zzb(zzqrVarZzb.zze())) {
                zzqtVarZza.zzc(zzqrVarZzb);
            }
        }
    }

    @Override // com.google.android.gms.internal.pal.zzqt
    public final boolean zzb(Level level) {
        return this.zze == null || this.zze.zzb(level);
    }

    @Override // com.google.android.gms.internal.pal.zzqt
    public final void zzc(zzqr zzqrVar) {
        if (this.zze != null) {
            this.zze.zzc(zzqrVar);
            return;
        }
        if (zzf.incrementAndGet() > 20) {
            zzg.poll();
            Log.w("ProxyAndroidLoggerBackend", "Too many Flogger logs received before configuration. Dropping old logs.");
        }
        zzg.offer(new zzsb(this, zzqrVar));
        if (this.zze != null) {
            zzf();
        }
    }

    @Override // com.google.android.gms.internal.pal.zzru, com.google.android.gms.internal.pal.zzqt
    public final void zzd(RuntimeException runtimeException, zzqr zzqrVar) {
        if (this.zze != null) {
            this.zze.zzd(runtimeException, zzqrVar);
        } else {
            Log.e("ProxyAndroidLoggerBackend", "Internal logging error before configuration", runtimeException);
        }
    }
}

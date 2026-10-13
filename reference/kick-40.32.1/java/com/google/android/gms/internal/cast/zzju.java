package com.google.android.gms.internal.cast;

import android.os.Build;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.text.Typography;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzju extends zzjn {
    static final boolean zza;
    static final boolean zzb;
    static final boolean zzc;
    private static final AtomicReference zzd;
    private static final AtomicLong zzf;
    private static final ConcurrentLinkedQueue zzg;
    private volatile zzix zze;

    static {
        zza = Build.FINGERPRINT == null || "robolectric".equals(Build.FINGERPRINT);
        zzb = "goldfish".equals(Build.HARDWARE) || "ranchu".equals(Build.HARDWARE);
        zzc = "eng".equals(Build.TYPE) || "userdebug".equals(Build.TYPE);
        zzd = new AtomicReference();
        zzf = new AtomicLong();
        zzg = new ConcurrentLinkedQueue();
    }

    private zzju(String str) {
        super(str);
        if (zza || zzb) {
            this.zze = new zzjo().zza(zza());
        } else if (zzc) {
            this.zze = zzjy.zzb().zzb(false).zza(zza());
        } else {
            this.zze = null;
        }
    }

    public static zzix zzb(String str) {
        char cCharAt;
        AtomicReference atomicReference = zzd;
        if (atomicReference.get() != null) {
            return ((zzjp) atomicReference.get()).zza(str);
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
        zzju zzjuVar = new zzju(str);
        ConcurrentLinkedQueue concurrentLinkedQueue = zzjs.zza;
        concurrentLinkedQueue.offer(zzjuVar);
        if (atomicReference.get() != null) {
            while (true) {
                zzju zzjuVar2 = (zzju) concurrentLinkedQueue.poll();
                if (zzjuVar2 == null) {
                    break;
                }
                zzjuVar2.zze = ((zzjp) atomicReference.get()).zza(zzjuVar2.zza());
            }
            if (((zzjt) zzg.poll()) != null) {
                zzf.getAndDecrement();
                throw null;
            }
        }
        return zzjuVar;
    }
}

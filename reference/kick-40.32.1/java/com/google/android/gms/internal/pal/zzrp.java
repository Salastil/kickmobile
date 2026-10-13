package com.google.android.gms.internal.pal;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzrp {
    private static final zzrr zza = zzb(zzrr.zzd);

    private static zzrr zzb(String[] strArr) {
        zzrx zzrxVar;
        try {
            zzrxVar = zzry.zza;
        } catch (NoClassDefFoundError unused) {
            zzrxVar = null;
        }
        if (zzrxVar != null) {
            return zzrxVar;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            try {
                return (zzrr) Class.forName(str).getConstructor(null).newInstance(null);
            } catch (Throwable th) {
                th = th;
                sb.append('\n');
                sb.append(str);
                sb.append(": ");
                if (th instanceof InvocationTargetException) {
                    th = th.getCause();
                }
                sb.append(th);
            }
        }
        throw new IllegalStateException(sb.insert(0, "No logging platforms found:").toString());
    }
}

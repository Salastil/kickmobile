package com.google.android.gms.internal.cast;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzjk {
    private static final zzjm zza = zzb(zzjm.zzd);

    private static zzjm zzb(String[] strArr) {
        zzjq zzjqVar;
        try {
            zzjqVar = zzjr.zza;
        } catch (NoClassDefFoundError unused) {
            zzjqVar = null;
        }
        if (zzjqVar != null) {
            return zzjqVar;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            try {
                return (zzjm) Class.forName(str).getConstructor(null).newInstance(null);
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

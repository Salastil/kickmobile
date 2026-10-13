package com.android.billingclient.api;

import android.content.Context;
import kotlin.time.DurationKt;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes5.dex */
final class zzet {
    static synchronized double zza(final Context context) {
        return ((Double) zze(new zzes(context) { // from class: com.android.billingclient.api.zzer
            @Override // com.android.billingclient.api.zzes
            public final Object zza() {
                return Double.valueOf(2.0d);
            }
        }, Double.valueOf(2.0d))).doubleValue();
    }

    static synchronized long zzb(final Context context) {
        return ((Long) zze(new zzes(context) { // from class: com.android.billingclient.api.zzeq
            @Override // com.android.billingclient.api.zzes
            public final Object zza() {
                return 3L;
            }
        }, 3L)).longValue();
    }

    static synchronized long zzc(final Context context) {
        return ((Long) zze(new zzes(context) { // from class: com.android.billingclient.api.zzeo
            @Override // com.android.billingclient.api.zzes
            public final Object zza() {
                return 100L;
            }
        }, 100L)).longValue();
    }

    static synchronized long zzd(final Context context) {
        return ((Long) zze(new zzes(context) { // from class: com.android.billingclient.api.zzep
            @Override // com.android.billingclient.api.zzes
            public final Object zza() {
                return Long.valueOf(DurationKt.MILLIS_IN_MINUTE);
            }
        }, Long.valueOf(DurationKt.MILLIS_IN_MINUTE))).longValue();
    }

    private static Object zze(zzes zzesVar, Object obj) {
        try {
            return zzesVar.zza();
        } catch (Exception e) {
            com.google.android.gms.internal.play_billing.zzc.zzn("RuntimeFlags", "Fail to get the runtime flags: ".concat(e.toString()));
            return obj;
        }
    }
}

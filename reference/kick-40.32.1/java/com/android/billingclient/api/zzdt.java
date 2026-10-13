package com.android.billingclient.api;

import android.content.Context;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.gms.internal.play_billing.zzkw;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzdt {
    private boolean zza;
    private Transport zzb;

    zzdt(Context context) {
        try {
            TransportRuntime.initialize(context);
            this.zzb = TransportRuntime.getInstance().newFactory(CCTDestination.INSTANCE).getTransport("PLAY_BILLING_LIBRARY", zzkw.class, Encoding.of("proto"), new Transformer() { // from class: com.android.billingclient.api.zzds
                @Override // com.google.android.datatransport.Transformer
                public final Object apply(Object obj) {
                    return ((zzkw) obj).zzQ();
                }
            });
        } catch (Throwable unused) {
            this.zza = true;
        }
    }

    public final void zza(zzkw zzkwVar) {
        if (this.zza) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingLogger", "Skipping logging since initialization failed.");
            return;
        }
        try {
            this.zzb.send(Event.ofData(zzkwVar));
        } catch (Throwable unused) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingLogger", "logging failed.");
        }
    }
}

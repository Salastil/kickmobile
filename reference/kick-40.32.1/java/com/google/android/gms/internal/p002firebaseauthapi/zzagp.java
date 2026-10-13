package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.api.Status;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzagp extends BroadcastReceiver {
    private final String zza;
    private final /* synthetic */ zzagl zzb;

    public zzagp(zzagl zzaglVar, String str) {
        Objects.requireNonNull(zzaglVar);
        this.zzb = zzaglVar;
        this.zza = str;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (SmsRetriever.SMS_RETRIEVED_ACTION.equals(intent.getAction())) {
            Bundle extras = intent.getExtras();
            if (((Status) extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS")).getStatusCode() == 0) {
                String str = (String) extras.get(SmsRetriever.EXTRA_SMS_MESSAGE);
                zzago zzagoVar = (zzago) this.zzb.zze.get(this.zza);
                if (zzagoVar == null) {
                    zzagl.zzb.e("Verification code received with no active retrieval session.", new Object[0]);
                } else {
                    zzagoVar.zze = zzagl.zza(str);
                    if (zzagoVar.zze == null) {
                        zzagl.zzb.e("Unable to extract verification code.", new Object[0]);
                    } else if (!zzac.zzc(zzagoVar.zzd)) {
                        zzagl.zzb(this.zzb, this.zza);
                    }
                }
            }
            context.getApplicationContext().unregisterReceiver(this);
        }
    }
}

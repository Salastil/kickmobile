package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Status;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzagm extends zzaeu {
    private final String zza;
    private final /* synthetic */ zzagl zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzagm(zzagl zzaglVar, zzaeu zzaeuVar, String str) {
        super(zzaeuVar);
        Objects.requireNonNull(zzaglVar);
        this.zzb = zzaglVar;
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeu, com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final void zzb(String str) {
        zzagl.zzb.d("onCodeSent", new Object[0]);
        zzago zzagoVar = (zzago) this.zzb.zze.get(this.zza);
        if (zzagoVar == null) {
            return;
        }
        Iterator<zzaeu> it = zzagoVar.zzb.iterator();
        while (it.hasNext()) {
            it.next().zzb(str);
        }
        zzagoVar.zzg = true;
        zzagoVar.zzd = str;
        if (zzagoVar.zza <= 0) {
            this.zzb.zze(this.zza);
        } else if (!zzagoVar.zzc) {
            this.zzb.zzd(this.zza);
        } else {
            if (zzac.zzc(zzagoVar.zze)) {
                return;
            }
            zzagl.zzb(this.zzb, this.zza);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeu, com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final void zza(Status status) {
        int i = 0;
        zzagl.zzb.e("SMS verification code request failed: " + CommonStatusCodes.getStatusCodeString(status.getStatusCode()) + ServerSentEventKt.SPACE + status.getStatusMessage(), new Object[0]);
        zzago zzagoVar = (zzago) this.zzb.zze.get(this.zza);
        if (zzagoVar == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(zzagoVar.zzb);
        this.zzb.zzb(this.zza);
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((zzaeu) obj).zza(status);
        }
    }
}

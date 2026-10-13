package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.Objects;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcy implements ServiceConnection {
    final /* synthetic */ zzda zza;

    /* synthetic */ zzcy(zzda zzdaVar, zzcz zzczVar) {
        Objects.requireNonNull(zzdaVar);
        this.zza = zzdaVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.google.android.gms.internal.play_billing.zzc.zzm("BillingClientTesting", "Billing Override Service connected.");
        zzda zzdaVar = this.zza;
        zzdaVar.zzc = com.google.android.gms.internal.play_billing.zzaz.zzb(iBinder);
        zzdaVar.zzb = 2;
        zzdaVar.zzaX(26);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClientTesting", "Billing Override Service disconnected.");
        zzda zzdaVar = this.zza;
        zzdaVar.zzc = null;
        zzdaVar.zzb = 0;
    }
}

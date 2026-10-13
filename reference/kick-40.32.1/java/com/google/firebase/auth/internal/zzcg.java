package com.google.firebase.auth.internal;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.internal.p002firebaseauthapi.zzaia;
import com.google.firebase.FirebaseApp;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzcg {
    private volatile int zza;
    private final zzas zzb;
    private volatile boolean zzc;

    public zzcg(FirebaseApp firebaseApp) {
        this(firebaseApp.getApplicationContext(), new zzas(firebaseApp));
    }

    private zzcg(Context context, zzas zzasVar) {
        this.zzc = false;
        this.zza = 0;
        this.zzb = zzasVar;
        BackgroundDetector.initialize((Application) context.getApplicationContext());
        BackgroundDetector.getInstance().addListener(new zzcf(this));
    }

    public final void zza() {
        this.zzb.zzb();
    }

    public final void zza(int i) {
        if (i > 0 && this.zza == 0) {
            this.zza = i;
            if (zzb()) {
                this.zzb.zzc();
            }
        } else if (i == 0 && this.zza != 0) {
            this.zzb.zzb();
        }
        this.zza = i;
    }

    public final void zza(zzaia zzaiaVar) {
        if (zzaiaVar == null) {
            return;
        }
        long jZza = zzaiaVar.zza();
        if (jZza <= 0) {
            jZza = 3600;
        }
        long jZzb = zzaiaVar.zzb() + (jZza * 1000);
        zzas zzasVar = this.zzb;
        zzasVar.zza = jZzb;
        zzasVar.zzb = -1L;
        if (zzb()) {
            this.zzb.zzc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzb() {
        return this.zza > 0 && !this.zzc;
    }
}

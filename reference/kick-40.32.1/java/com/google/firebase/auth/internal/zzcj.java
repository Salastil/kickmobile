package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzcj {
    private static final zzcj zza = new zzcj();
    private final zzbm zzb;
    private final zzav zzc;

    public final Task<AuthResult> zza() {
        return this.zzb.zza();
    }

    public final Task<String> zzb() {
        return this.zzb.zzb();
    }

    public static zzcj zzc() {
        return zza;
    }

    private zzcj() {
        this(zzbm.zzc(), zzav.zza());
    }

    private zzcj(zzbm zzbmVar, zzav zzavVar) {
        this.zzb = zzbmVar;
        this.zzc = zzavVar;
    }

    public final void zza(Context context) {
        this.zzb.zza(context);
    }

    public final void zza(FirebaseAuth firebaseAuth) {
        this.zzb.zza(firebaseAuth);
    }

    public final boolean zza(Activity activity, TaskCompletionSource<AuthResult> taskCompletionSource, FirebaseAuth firebaseAuth) {
        return this.zzc.zza(activity, taskCompletionSource, firebaseAuth);
    }

    public final boolean zza(Activity activity, TaskCompletionSource<AuthResult> taskCompletionSource, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        return this.zzc.zza(activity, taskCompletionSource, firebaseAuth, firebaseUser);
    }
}

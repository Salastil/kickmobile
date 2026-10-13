package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p002firebaseauthapi.zzaew;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzbe extends BroadcastReceiver {
    private final WeakReference<Activity> zza;
    private final TaskCompletionSource<AuthResult> zzb;
    private final FirebaseAuth zzc;
    private final FirebaseUser zzd;
    private final /* synthetic */ zzav zze;

    zzbe(zzav zzavVar, Activity activity, TaskCompletionSource<AuthResult> taskCompletionSource, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        Objects.requireNonNull(zzavVar);
        this.zze = zzavVar;
        this.zza = new WeakReference<>(activity);
        this.zzb = taskCompletionSource;
        this.zzc = firebaseAuth;
        this.zzd = firebaseUser;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.zza.get() == null) {
            Log.e("FederatedAuthReceiver", "Failed to unregister BroadcastReceiver because the Activity that launched this flow has been garbage collected; please do not finish() your Activity while performing a FederatedAuthProvider operation.");
            this.zzb.setException(zzaew.zza(new Status(FirebaseError.ERROR_INTERNAL_ERROR, "Activity that started the web operation is no longer alive; see logcat for details")));
            zzav.zza(context);
            return;
        }
        if (intent.hasExtra("com.google.firebase.auth.internal.OPERATION")) {
            String stringExtra = intent.getStringExtra("com.google.firebase.auth.internal.OPERATION");
            if ("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(stringExtra)) {
                zzav zzavVar = this.zze;
                TaskCompletionSource<AuthResult> taskCompletionSource = this.zzb;
                this.zzc.signInWithCredential(zzav.zza(intent)).addOnSuccessListener(new zzax(zzavVar, taskCompletionSource, context)).addOnFailureListener(new zzay(zzavVar, taskCompletionSource, context));
                return;
            }
            if ("com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(stringExtra)) {
                zzav zzavVar2 = this.zze;
                TaskCompletionSource<AuthResult> taskCompletionSource2 = this.zzb;
                this.zzd.linkWithCredential(zzav.zza(intent)).addOnSuccessListener(new zzaz(zzavVar2, taskCompletionSource2, context)).addOnFailureListener(new zzba(zzavVar2, taskCompletionSource2, context));
                return;
            } else if ("com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(stringExtra)) {
                zzav zzavVar3 = this.zze;
                TaskCompletionSource<AuthResult> taskCompletionSource3 = this.zzb;
                this.zzd.reauthenticateAndRetrieveData(zzav.zza(intent)).addOnSuccessListener(new zzbb(zzavVar3, taskCompletionSource3, context)).addOnFailureListener(new zzbc(zzavVar3, taskCompletionSource3, context));
                return;
            } else {
                this.zzb.setException(zzaew.zza(zzaq.zza("WEB_CONTEXT_CANCELED:Unknown operation received (" + stringExtra + ")")));
                return;
            }
        }
        if (zzck.zzb(intent)) {
            this.zzb.setException(zzaew.zza(zzck.zza(intent)));
            zzav.zza(context);
        } else if (intent.hasExtra("com.google.firebase.auth.internal.EXTRA_CANCELED")) {
            this.zzb.setException(zzaew.zza(zzaq.zza("WEB_CONTEXT_CANCELED")));
            zzav.zza(context);
        }
    }
}

package com.google.firebase.auth.internal;

import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzaew;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzbq<T> {
    public abstract Task<T> zza(String str);

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> Task<T> zza(zzbv zzbvVar, RecaptchaAction recaptchaAction, String str, Continuation<String, Task<T>> continuation) {
        Task<String> taskZza = zzbvVar.zza(str, false, recaptchaAction);
        return taskZza.continueWithTask(continuation).continueWithTask(new zzbr(str, zzbvVar, recaptchaAction, continuation));
    }

    public final Task<T> zza(final FirebaseAuth firebaseAuth, final String str, final RecaptchaAction recaptchaAction, String str2) {
        final Continuation continuation = new Continuation() { // from class: com.google.firebase.auth.internal.zzbs
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                zzbq zzbqVar = this.zza;
                if (task.isSuccessful()) {
                    return zzbqVar.zza((String) task.getResult());
                }
                Log.e("RecaptchaCallWrapper", "Failed to get Recaptcha token, error - " + ((Exception) Preconditions.checkNotNull(task.getException())).getMessage() + "\n\n Failing open with a fake token.");
                return zzbqVar.zza("NO_RECAPTCHA");
            }
        };
        zzbv zzbvVarZzb = firebaseAuth.zzb();
        if (zzbvVarZzb != null && zzbvVarZzb.zzb(str2)) {
            return zza(zzbvVarZzb, recaptchaAction, str, continuation);
        }
        return (Task<T>) zza(null).continueWithTask(new Continuation() { // from class: com.google.firebase.auth.internal.zzbp
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return zzbq.zza(recaptchaAction, firebaseAuth, str, continuation, task);
            }
        });
    }

    static /* synthetic */ Task zza(RecaptchaAction recaptchaAction, FirebaseAuth firebaseAuth, String str, Continuation continuation, Task task) throws Exception {
        if (task.isSuccessful()) {
            return Tasks.forResult(task.getResult());
        }
        Exception exc = (Exception) Preconditions.checkNotNull(task.getException());
        if (zzaew.zzd(exc)) {
            if (Log.isLoggable("RecaptchaCallWrapper", 4)) {
                Log.i("RecaptchaCallWrapper", "Falling back to recaptcha enterprise flow for action " + String.valueOf(recaptchaAction));
            }
            if (firebaseAuth.zzb() == null) {
                firebaseAuth.zza(new zzbv(firebaseAuth.getApp(), firebaseAuth));
            }
            return zza(firebaseAuth.zzb(), recaptchaAction, str, continuation);
        }
        Log.e("RecaptchaCallWrapper", "Initial task failed for action " + String.valueOf(recaptchaAction) + "with exception - " + exc.getMessage());
        return Tasks.forException(exc);
    }
}

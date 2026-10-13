package com.google.firebase.auth.internal;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzaew;
import com.google.android.gms.internal.p002firebaseauthapi.zzage;
import com.google.android.gms.internal.p002firebaseauthapi.zzagq;
import com.google.android.gms.internal.p002firebaseauthapi.zzahw;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.integrity.IntegrityManager;
import com.google.android.play.core.integrity.IntegrityManagerFactory;
import com.google.android.play.core.integrity.IntegrityTokenResponse;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthMissingActivityForRecaptchaException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public class zza {
    private static final String zza = "zza";
    private static final zza zzb = new zza();
    private String zzc;

    public final Task<zzh> zza(final FirebaseAuth firebaseAuth, final String str, final Activity activity, final boolean z, boolean z2, boolean z3, final RecaptchaAction recaptchaAction) {
        zzae zzaeVar = (zzae) firebaseAuth.getFirebaseAuthSettings();
        final zzcj zzcjVarZzc = zzcj.zzc();
        if (zzagq.zza(firebaseAuth.getApp()) || zzaeVar.zze()) {
            return Tasks.forResult(new zzo().zza());
        }
        String str2 = zza;
        Log.i(str2, "ForceRecaptchaV2Flow from phoneAuthOptions = " + z2 + ", ForceRecaptchav2Flow from firebaseSettings = " + zzaeVar.zzc());
        boolean z4 = z2 || zzaeVar.zzc();
        final TaskCompletionSource<zzh> taskCompletionSource = new TaskCompletionSource<>();
        Task<String> taskZzb = zzcjVarZzc.zzb();
        if (taskZzb != null) {
            if (taskZzb.isSuccessful()) {
                return Tasks.forResult(new zzo().zzc(taskZzb.getResult()).zza());
            }
            Log.e(str2, "Error in previous reCAPTCHAV2 flow: " + taskZzb.getException().getMessage());
            Log.e(str2, "Continuing with application verification as normal");
        }
        if (z4 || z3) {
            zza(firebaseAuth, str, activity, z, z4, zzcjVarZzc, taskCompletionSource);
        } else {
            Task<Void> taskInitializeRecaptchaConfig = firebaseAuth.initializeRecaptchaConfig();
            final boolean z5 = false;
            OnCompleteListener<Void> onCompleteListener = new OnCompleteListener() { // from class: com.google.firebase.auth.internal.zzc
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    zza.zza(this.zza, taskCompletionSource, firebaseAuth, recaptchaAction, str, activity, z, z5, zzcjVarZzc, task);
                }
            };
            taskCompletionSource = taskCompletionSource;
            taskInitializeRecaptchaConfig.addOnCompleteListener(onCompleteListener);
        }
        return taskCompletionSource.getTask();
    }

    public static zza zza() {
        return zzb;
    }

    public static /* synthetic */ void zza(zza zzaVar, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, RecaptchaAction recaptchaAction, String str, Activity activity, boolean z, boolean z2, zzcj zzcjVar, Task task) {
        if (!task.isSuccessful()) {
            Log.e(zza, "Failed to initialize reCAPTCHA config: " + task.getException().getMessage());
        }
        if (firebaseAuth.zzb() != null && firebaseAuth.zzb().zzb("PHONE_PROVIDER")) {
            firebaseAuth.zzb().zza(firebaseAuth.getTenantId(), false, recaptchaAction).addOnSuccessListener(new zzd(zzaVar, taskCompletionSource)).addOnFailureListener(new zze(zzaVar, firebaseAuth, str, activity, z, z2, zzcjVar, taskCompletionSource));
        } else {
            zzaVar.zza(firebaseAuth, str, activity, z, z2, zzcjVar, (TaskCompletionSource<zzh>) taskCompletionSource);
        }
    }

    public static /* synthetic */ void zza(zza zzaVar, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, zzcj zzcjVar, Activity activity, Task task) {
        if (task.isSuccessful() && task.getResult() != null && !TextUtils.isEmpty(((IntegrityTokenResponse) task.getResult()).token())) {
            taskCompletionSource.setResult(new zzo().zza(((IntegrityTokenResponse) task.getResult()).token()).zza());
            return;
        }
        String message = task.getException() == null ? "" : task.getException().getMessage();
        Log.e(zza, "Play Integrity Token fetch failed, falling back to Recaptcha" + message);
        zzaVar.zza(firebaseAuth, zzcjVar, activity, taskCompletionSource);
    }

    private zza() {
    }

    private final void zza(FirebaseAuth firebaseAuth, zzcj zzcjVar, Activity activity, TaskCompletionSource<zzh> taskCompletionSource) {
        Task<String> task;
        if (activity == null) {
            taskCompletionSource.setException(new FirebaseAuthMissingActivityForRecaptchaException());
            return;
        }
        zzbm.zza(firebaseAuth.getApp().getApplicationContext(), firebaseAuth);
        Preconditions.checkNotNull(activity);
        TaskCompletionSource<String> taskCompletionSource2 = new TaskCompletionSource<>();
        if (!zzav.zza().zza(activity, taskCompletionSource2)) {
            task = Tasks.forException(zzaew.zza(new Status(17057, "reCAPTCHA flow already in progress")));
        } else {
            new zzage(firebaseAuth, activity).zza();
            task = taskCompletionSource2.getTask();
        }
        task.addOnSuccessListener(new zzi(this, taskCompletionSource)).addOnFailureListener(new zzf(this, taskCompletionSource));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(final FirebaseAuth firebaseAuth, String str, final Activity activity, boolean z, boolean z2, final zzcj zzcjVar, final TaskCompletionSource<zzh> taskCompletionSource) {
        Task<zzahw> taskZza;
        if (z && !z2) {
            IntegrityManager integrityManagerCreate = IntegrityManagerFactory.create(firebaseAuth.getApp().getApplicationContext());
            if (!TextUtils.isEmpty(this.zzc)) {
                taskZza = Tasks.forResult(new zzahw(this.zzc));
            } else {
                taskZza = firebaseAuth.zza();
            }
            taskZza.continueWithTask(firebaseAuth.zzf(), new zzg(this, str, integrityManagerCreate)).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.firebase.auth.internal.zzb
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    zza.zza(this.zza, taskCompletionSource, firebaseAuth, zzcjVar, activity, task);
                }
            });
            return;
        }
        zza(firebaseAuth, zzcjVar, activity, taskCompletionSource);
    }

    public static boolean zza(Exception exc) {
        if (exc instanceof FirebaseAuthMissingActivityForRecaptchaException) {
            return true;
        }
        return (exc instanceof FirebaseAuthException) && ((FirebaseAuthException) exc).getErrorCode().endsWith("UNAUTHORIZED_DOMAIN");
    }
}

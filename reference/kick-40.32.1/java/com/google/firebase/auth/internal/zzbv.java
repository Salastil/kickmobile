package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzaib;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.android.recaptcha.RecaptchaTasksClient;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzbv {
    FirebaseApp zza;
    zzbu zzb;
    private final Object zzc;
    private final Map<String, Task<RecaptchaTasksClient>> zzd;
    private zzaib zze;
    private FirebaseAuth zzf;

    private final Task<RecaptchaTasksClient> zzc(String str) {
        Task<RecaptchaTasksClient> task;
        synchronized (this.zzc) {
            task = this.zzd.get(str);
        }
        return task;
    }

    public final Task<String> zza(String str, Boolean bool, RecaptchaAction recaptchaAction) {
        String strZzd = zzd(str);
        Task<RecaptchaTasksClient> taskZzc = zzc(strZzd);
        if (bool.booleanValue() || taskZzc == null) {
            taskZzc = zza(strZzd, bool);
        }
        return taskZzc.continueWithTask(new zzbx(this, recaptchaAction));
    }

    public final Task<RecaptchaTasksClient> zza(String str, Boolean bool) {
        Task<RecaptchaTasksClient> taskZzc;
        String strZzd = zzd(str);
        return (bool.booleanValue() || (taskZzc = zzc(strZzd)) == null) ? this.zzf.zza("RECAPTCHA_ENTERPRISE").continueWithTask(new zzby(this, strZzd)) : taskZzc;
    }

    private static String zzd(String str) {
        return com.google.android.gms.internal.p002firebaseauthapi.zzac.zzc(str) ? "*" : str;
    }

    static /* synthetic */ void zza(zzbv zzbvVar, zzaib zzaibVar, Task task, String str) {
        synchronized (zzbvVar.zzc) {
            zzbvVar.zze = zzaibVar;
            zzbvVar.zzd.put(str, task);
        }
    }

    public zzbv(FirebaseApp firebaseApp, FirebaseAuth firebaseAuth) {
        this(firebaseApp, firebaseAuth, new zzbt());
    }

    private zzbv(FirebaseApp firebaseApp, FirebaseAuth firebaseAuth, zzbu zzbuVar) {
        this.zzc = new Object();
        this.zzd = new HashMap();
        this.zza = firebaseApp;
        this.zzf = firebaseAuth;
        this.zzb = zzbuVar;
    }

    public final boolean zza(String str) {
        String strZzb;
        Preconditions.checkNotNull(str);
        zzaib zzaibVar = this.zze;
        if (zzaibVar == null || (strZzb = zzaibVar.zzb(str)) == null) {
            return false;
        }
        return strZzb.equals("AUDIT");
    }

    public final boolean zzb(String str) {
        boolean z;
        synchronized (this.zzc) {
            zzaib zzaibVar = this.zze;
            z = zzaibVar != null && zzaibVar.zzc(str);
        }
        return z;
    }
}

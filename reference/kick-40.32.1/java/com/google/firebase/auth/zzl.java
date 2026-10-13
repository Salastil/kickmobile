package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzl implements OnCompleteListener<com.google.firebase.auth.internal.zzh> {
    private final /* synthetic */ PhoneAuthOptions zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ FirebaseAuth zzc;

    zzl(FirebaseAuth firebaseAuth, PhoneAuthOptions phoneAuthOptions, String str) {
        this.zza = phoneAuthOptions;
        this.zzb = str;
        Objects.requireNonNull(firebaseAuth);
        this.zzc = firebaseAuth;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<com.google.firebase.auth.internal.zzh> task) {
        String strZzd;
        String strZzb;
        String strZzc;
        if (!task.isSuccessful()) {
            Exception exception = task.getException();
            String str = "Error while validating application identity: ";
            if (exception != null) {
                str = "Error while validating application identity: " + exception.getMessage();
            }
            Log.e("FirebaseAuth", str);
            if (exception == null || !com.google.firebase.auth.internal.zza.zza(exception)) {
                Log.e("FirebaseAuth", "Proceeding without any application identifier.");
                strZzc = null;
                strZzd = null;
                strZzb = null;
            } else {
                FirebaseAuth.zza((FirebaseException) exception, this.zza, this.zzb);
                return;
            }
        } else {
            strZzd = task.getResult().zzd();
            strZzb = task.getResult().zzb();
            strZzc = task.getResult().zzc();
        }
        long jLongValue = this.zza.zzg().longValue();
        PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacksZza = this.zzc.zza(this.zza.zzh(), this.zza.zze());
        if (TextUtils.isEmpty(strZzd)) {
            onVerificationStateChangedCallbacksZza = this.zzc.zza(this.zza, onVerificationStateChangedCallbacksZza, task.getResult());
        }
        PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks = onVerificationStateChangedCallbacksZza;
        com.google.firebase.auth.internal.zzao zzaoVar = (com.google.firebase.auth.internal.zzao) Preconditions.checkNotNull(this.zza.zzc());
        if (com.google.android.gms.internal.p002firebaseauthapi.zzac.zzc(strZzc) && this.zzc.zzb() != null && this.zzc.zzb().zza("PHONE_PROVIDER")) {
            strZzc = "NO_RECAPTCHA";
        }
        String str2 = strZzc;
        boolean zZzd = zzaoVar.zzd();
        FirebaseAuth firebaseAuth = this.zzc;
        if (zZzd) {
            firebaseAuth.zzd.zza(zzaoVar, (String) Preconditions.checkNotNull(this.zza.zzh()), this.zzc.zzk, jLongValue, this.zza.zzd() != null, this.zza.zzk(), strZzd, strZzb, str2, this.zzc.zzj(), onVerificationStateChangedCallbacks, this.zza.zzi(), this.zza.zza());
        } else {
            firebaseAuth.zzd.zza(zzaoVar, (PhoneMultiFactorInfo) Preconditions.checkNotNull(this.zza.zzf()), this.zzc.zzk, jLongValue, this.zza.zzd() != null, this.zza.zzk(), strZzd, strZzb, str2, this.zzc.zzj(), onVerificationStateChangedCallbacks, this.zza.zzi(), this.zza.zza());
        }
    }
}

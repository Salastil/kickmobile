package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.internal.zzbq;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzp extends zzbq<AuthResult> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ FirebaseAuth zzc;

    @Override // com.google.firebase.auth.internal.zzbq
    public final Task<AuthResult> zza(String str) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        String str2 = this.zza;
        if (zIsEmpty) {
            Log.i("FirebaseAuth", "Creating user with " + str2 + " with empty reCAPTCHA token");
        } else {
            Log.i("FirebaseAuth", "Got reCAPTCHA token for sign up with email " + str2);
        }
        return this.zzc.zzd.zza(this.zzc.zzg, this.zza, this.zzb, this.zzc.zzm, str, new FirebaseAuth.zzb(this.zzc));
    }

    zzp(FirebaseAuth firebaseAuth, String str, String str2) {
        this.zza = str;
        this.zzb = str2;
        Objects.requireNonNull(firebaseAuth);
        this.zzc = firebaseAuth;
    }
}

package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class TotpMultiFactorGenerator {
    public static final String FACTOR_ID = "totp";

    public static Task<TotpSecret> generateSecret(MultiFactorSession multiFactorSession) {
        Preconditions.checkNotNull(multiFactorSession);
        com.google.firebase.auth.internal.zzao zzaoVar = (com.google.firebase.auth.internal.zzao) multiFactorSession;
        return FirebaseAuth.getInstance(zzaoVar.zza().zza()).zza(zzaoVar);
    }

    public static TotpMultiFactorAssertion getAssertionForEnrollment(TotpSecret totpSecret, String str) {
        return new TotpMultiFactorAssertion((String) Preconditions.checkNotNull(str), (TotpSecret) Preconditions.checkNotNull(totpSecret), null);
    }

    public static TotpMultiFactorAssertion getAssertionForSignIn(String str, String str2) {
        return new TotpMultiFactorAssertion((String) Preconditions.checkNotNull(str2), null, (String) Preconditions.checkNotNull(str));
    }

    private TotpMultiFactorGenerator() {
    }
}

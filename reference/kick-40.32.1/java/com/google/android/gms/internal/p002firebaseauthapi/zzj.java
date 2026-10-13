package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzj extends zzk {
    static final zzf zza = new zzj();

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzf
    public final int zza(CharSequence charSequence, int i) {
        zzu.zza(i, charSequence.length(), FirebaseAnalytics.Param.INDEX);
        return -1;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzf
    public final boolean zza(char c) {
        return false;
    }

    private zzj() {
        super("CharMatcher.none()");
    }
}

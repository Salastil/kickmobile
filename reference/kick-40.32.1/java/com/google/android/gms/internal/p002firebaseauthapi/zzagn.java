package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.tasks.OnFailureListener;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzagn implements OnFailureListener {
    zzagn(zzagl zzaglVar) {
        Objects.requireNonNull(zzaglVar);
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        zzagl.zzb.e("SmsRetrieverClient failed to start: " + exc.getMessage(), new Object[0]);
    }
}

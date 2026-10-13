package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzany extends RuntimeException {
    public final zzamd zza() {
        return new zzamd(getMessage());
    }

    public zzany(zzamv zzamvVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }
}

package com.google.firebase.auth;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzw implements Runnable {
    private final /* synthetic */ FirebaseAuth zza;

    zzw(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator<FirebaseAuth.AuthStateListener> it = this.zza.zzb.iterator();
        while (it.hasNext()) {
            it.next().onAuthStateChanged(this.zza);
        }
    }
}

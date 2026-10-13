package com.google.firebase.auth;

import com.google.firebase.auth.internal.IdTokenListener;
import com.google.firebase.internal.InternalTokenResult;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzx implements Runnable {
    private final /* synthetic */ FirebaseAuth zza;
    private final /* synthetic */ InternalTokenResult zzb;

    zzx(FirebaseAuth firebaseAuth, InternalTokenResult internalTokenResult) {
        this.zza = firebaseAuth;
        this.zzb = internalTokenResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator<IdTokenListener> it = this.zza.zzc.iterator();
        while (it.hasNext()) {
            it.next().onIdTokenChanged(this.zzb);
        }
        Iterator<FirebaseAuth.IdTokenListener> it2 = this.zza.zza.iterator();
        while (it2.hasNext()) {
            it2.next().onIdTokenChanged(this.zza);
        }
    }
}

package com.google.firebase.auth;

import android.util.Log;
import com.facebook.hermes.intl.Constants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.internal.IdTokenListener;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.auth.internal.zzca;
import com.google.firebase.heartbeatinfo.HeartBeatController;
import com.google.firebase.inject.Provider;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public class zzad implements InternalAuthProvider {
    private final FirebaseApp zza;
    private final Provider<InteropAppCheckTokenProvider> zzb;
    private final Provider<HeartBeatController> zzc;
    private final Executor zzd;
    private final Executor zze;
    private final Executor zzf;
    private final ScheduledExecutorService zzg;
    private final Executor zzh;
    private final ConcurrentHashMap<String, FirebaseAuth> zzi = new ConcurrentHashMap<>();
    private zzat zzj;

    @Override // com.google.firebase.auth.internal.InternalAuthProvider, com.google.firebase.internal.InternalTokenProvider
    public Task<GetTokenResult> getAccessToken(boolean z) {
        return zze().getAccessToken(z);
    }

    private final FirebaseAuth zze() {
        if (this.zzi.isEmpty()) {
            Log.i("FirebaseAuthComponent", "getAuth() called before any FirebaseAuth instance was initialized.");
            Log.i("FirebaseAuthComponent", "Creating a default instance to use.");
            return zza();
        }
        return this.zzi.values().iterator().next();
    }

    public final synchronized FirebaseAuth zza() {
        if (this.zzi.containsKey(Constants.COLLATION_DEFAULT)) {
            FirebaseAuth firebaseAuth = this.zzi.get(Constants.COLLATION_DEFAULT);
            if (firebaseAuth != null) {
                return firebaseAuth;
            }
            this.zzi.remove(Constants.COLLATION_DEFAULT);
        }
        if (!this.zzi.isEmpty()) {
            throw new IllegalStateException("FirebaseAuth instance has already been instantiated with different configuration.");
        }
        com.google.firebase.auth.internal.zzab zzabVar = new com.google.firebase.auth.internal.zzab(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh);
        this.zzi.put(Constants.COLLATION_DEFAULT, zzabVar);
        return zzabVar;
    }

    public final synchronized FirebaseAuth zza(zzat zzatVar) {
        Preconditions.checkNotNull(zzatVar, "tenantConfig cannot be null");
        if (this.zzi.containsKey("regional")) {
            zzca zzcaVar = (zzca) this.zzi.get("regional");
            if (zzcaVar == null) {
                this.zzi.remove("regional");
            } else if (zzcaVar.zzk().equals(zzatVar)) {
                return zzcaVar;
            }
        }
        if (!this.zzi.isEmpty()) {
            throw new IllegalStateException("FirebaseAuth instance has already been instantiated with different configuration.");
        }
        this.zzj = zzatVar;
        zzca zzcaVar2 = new zzca(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, zzatVar);
        this.zzi.put("regional", zzcaVar2);
        return zzcaVar2;
    }

    public static zzad zza(FirebaseApp firebaseApp) {
        return (zzad) firebaseApp.get(zzad.class);
    }

    public final zzat zzb() {
        return this.zzj;
    }

    public final Provider<InteropAppCheckTokenProvider> zzc() {
        return this.zzb;
    }

    public final Provider<HeartBeatController> zzd() {
        return this.zzc;
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider, com.google.firebase.internal.InternalTokenProvider
    public String getUid() {
        return zze().getUid();
    }

    public zzad(FirebaseApp firebaseApp, Provider<InteropAppCheckTokenProvider> provider, Provider<HeartBeatController> provider2, Executor executor, Executor executor2, Executor executor3, ScheduledExecutorService scheduledExecutorService, Executor executor4) {
        this.zza = firebaseApp;
        this.zzb = provider;
        this.zzc = provider2;
        this.zzd = executor;
        this.zze = executor2;
        this.zzf = executor3;
        this.zzg = scheduledExecutorService;
        this.zzh = executor4;
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    public void addIdTokenListener(IdTokenListener idTokenListener) {
        zze().addIdTokenListener(idTokenListener);
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    public void removeIdTokenListener(IdTokenListener idTokenListener) {
        zze().removeIdTokenListener(idTokenListener);
    }
}

package com.google.firebase.auth.internal;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzaew;
import com.google.android.gms.internal.p002firebaseauthapi.zzaia;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseError;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.ActionCodeResult;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FederatedAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.heartbeatinfo.HeartBeatController;
import com.google.firebase.inject.Provider;
import com.google.firebase.internal.InternalTokenResult;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzca extends FirebaseAuth {
    private final com.google.firebase.auth.zzat zzg;
    private zzaia zzh;

    @Override // com.google.firebase.auth.FirebaseAuth
    public final Task<Void> applyActionCode(String str) {
        throw new UnsupportedOperationException("Regionalized functionality not yet supported for this method.");
    }

    @Override // com.google.firebase.auth.FirebaseAuth
    public final Task<ActionCodeResult> checkActionCode(String str) {
        throw new UnsupportedOperationException("Regionalized functionality not yet supported for this method.");
    }

    @Override // com.google.firebase.auth.FirebaseAuth
    public final Task<Void> confirmPasswordReset(String str, String str2) {
        throw new UnsupportedOperationException("Regionalized functionality not yet supported for this method.");
    }

    @Override // com.google.firebase.auth.FirebaseAuth
    public final Task<AuthResult> createUserWithEmailAndPassword(String str, String str2) {
        throw new UnsupportedOperationException("Regionalized functionality not yet supported for this method.");
    }

    @Override // com.google.firebase.auth.FirebaseAuth, com.google.firebase.auth.internal.InternalAuthProvider, com.google.firebase.internal.InternalTokenProvider
    public final Task<GetTokenResult> getAccessToken(boolean z) {
        zzaia zzaiaVar = this.zzh;
        if (zzaiaVar == null) {
            return Tasks.forException(zzaew.zza(new Status(FirebaseError.ERROR_NO_SIGNED_IN_USER)));
        }
        if (!z && zzaiaVar.zzh()) {
            return Tasks.forResult(zzbg.zza(this.zzh.zzc()));
        }
        return Tasks.forException(zzaew.zza(new Status(FirebaseError.ERROR_USER_TOKEN_EXPIRED)));
    }

    @Override // com.google.firebase.auth.FirebaseAuth
    public final Task<AuthResult> getPendingAuthResult() {
        throw new UnsupportedOperationException("Regionalized functionality not yet supported for this method.");
    }

    @Override // com.google.firebase.auth.FirebaseAuth
    public final Task<Void> initializeRecaptchaConfig() {
        throw new UnsupportedOperationException("Regionalized functionality not yet supported for this method.");
    }

    @Override // com.google.firebase.auth.FirebaseAuth
    public final Task<Void> revokeAccessToken(String str) {
        throw new UnsupportedOperationException("Regionalized functionality not yet supported for this method.");
    }

    @Override // com.google.firebase.auth.FirebaseAuth
    public final Task<Void> sendPasswordResetEmail(String str) {
        throw new UnsupportedOperationException("Regionalized functionality not yet supported for this method.");
    }

    @Override // com.google.firebase.auth.FirebaseAuth
    public final Task<Void> sendPasswordResetEmail(String str, ActionCodeSettings actionCodeSettings) {
        throw new UnsupportedOperationException("Regionalized functionality not yet supported for this method.");
    }

    @Override // com.google.firebase.auth.FirebaseAuth
    public final Task<Void> sendSignInLinkToEmail(String str, ActionCodeSettings actionCodeSettings) {
        throw new UnsupportedOperationException("Regionalized functionality not yet supported for this method.");
    }

    @Override // com.google.firebase.auth.FirebaseAuth
    public final Task<Void> setFirebaseUIVersion(String str) {
        throw new UnsupportedOperationException("Regionalized functionality not yet supported for this method.");
    }

    @Override // com.google.firebase.auth.FirebaseAuth
    public final Task<AuthResult> signInAnonymously() {
        throw new UnsupportedOperationException("Regionalized functionality not yet supported for this method.");
    }

    @Override // com.google.firebase.auth.FirebaseAuth
    public final Task<AuthResult> signInWithCredential(AuthCredential authCredential) {
        throw new UnsupportedOperationException("Regionalized functionality not yet supported for this method.");
    }

    @Override // com.google.firebase.auth.FirebaseAuth
    public final Task<AuthResult> signInWithCustomToken(String str) {
        throw new UnsupportedOperationException("Regionalized functionality not yet supported for this method.");
    }

    @Override // com.google.firebase.auth.FirebaseAuth
    public final Task<AuthResult> signInWithEmailAndPassword(String str, String str2) {
        throw new UnsupportedOperationException("Regionalized functionality not yet supported for this method.");
    }

    @Override // com.google.firebase.auth.FirebaseAuth
    public final Task<AuthResult> signInWithEmailLink(String str, String str2) {
        throw new UnsupportedOperationException("Regionalized functionality not yet supported for this method.");
    }

    @Override // com.google.firebase.auth.FirebaseAuth
    public final Task<AuthResult> startActivityForSignInWithProvider(Activity activity, FederatedAuthProvider federatedAuthProvider) {
        throw new UnsupportedOperationException("Regionalized functionality not yet supported for this method.");
    }

    @Override // com.google.firebase.auth.FirebaseAuth
    public final Task<Void> updateCurrentUser(FirebaseUser firebaseUser) {
        throw new UnsupportedOperationException("Regionalized functionality not yet supported for this method.");
    }

    @Override // com.google.firebase.auth.FirebaseAuth
    public final Task<String> verifyPasswordResetCode(String str) {
        throw new UnsupportedOperationException("Regionalized functionality not yet supported for this method.");
    }

    @Override // com.google.firebase.auth.FirebaseAuth
    public final FirebaseUser getCurrentUser() {
        throw new UnsupportedOperationException("Regionalized functionality not yet supported for this method.");
    }

    public final com.google.firebase.auth.zzat zzk() {
        return this.zzg;
    }

    @Override // com.google.firebase.auth.FirebaseAuth
    public final String getTenantId() {
        return this.zzg.zzb();
    }

    @Override // com.google.firebase.auth.FirebaseAuth, com.google.firebase.auth.internal.InternalAuthProvider, com.google.firebase.internal.InternalTokenProvider
    public final String getUid() {
        throw new UnsupportedOperationException("Regionalized functionality not yet supported for this method.");
    }

    public zzca(FirebaseApp firebaseApp, Provider<InteropAppCheckTokenProvider> provider, Provider<HeartBeatController> provider2, Executor executor, Executor executor2, Executor executor3, ScheduledExecutorService scheduledExecutorService, Executor executor4, com.google.firebase.auth.zzat zzatVar) {
        super(firebaseApp, provider, provider2, executor, executor2, executor3, scheduledExecutorService, executor4);
        this.zzg = (com.google.firebase.auth.zzat) Preconditions.checkNotNull(zzatVar, "tenantConfig cannot be null");
    }

    @Override // com.google.firebase.auth.FirebaseAuth, com.google.firebase.auth.internal.InternalAuthProvider
    public final void addIdTokenListener(IdTokenListener idTokenListener) {
        Preconditions.checkNotNull(idTokenListener);
        this.zzc.add(idTokenListener);
        zzc().zza(this.zzc.size());
    }

    @Override // com.google.firebase.auth.FirebaseAuth
    public final void zzg() {
        Preconditions.checkNotNull(this.zze);
        if (this.zzh != null) {
            this.zze.zzb(this.zzg.zzc());
            this.zzh = null;
        }
        zzc((FirebaseUser) null);
        zzb((FirebaseUser) null);
    }

    static /* synthetic */ void zza(zzca zzcaVar) {
        Iterator<FirebaseAuth.AuthStateListener> it = zzcaVar.zzb.iterator();
        while (it.hasNext()) {
            it.next().onAuthStateChanged(zzcaVar);
        }
    }

    static /* synthetic */ void zza(zzca zzcaVar, InternalTokenResult internalTokenResult) {
        Iterator<IdTokenListener> it = zzcaVar.zzc.iterator();
        while (it.hasNext()) {
            it.next().onIdTokenChanged(internalTokenResult);
        }
        Iterator<FirebaseAuth.IdTokenListener> it2 = zzcaVar.zza.iterator();
        while (it2.hasNext()) {
            it2.next().onIdTokenChanged(zzcaVar);
        }
    }

    @Override // com.google.firebase.auth.FirebaseAuth
    public final void zzb(FirebaseUser firebaseUser) {
        if (this.zzh != null) {
            Log.d("RegionalFirebaseAuth", "Notifying auth state listeners about user authentication.");
        } else {
            Log.d("RegionalFirebaseAuth", "Notifying auth state listeners about a sign-out event.");
        }
        this.zzf.execute(new Runnable() { // from class: com.google.firebase.auth.internal.zzcc
            @Override // java.lang.Runnable
            public final void run() {
                zzca.zza(this.zza);
            }
        });
    }

    @Override // com.google.firebase.auth.FirebaseAuth
    public final void zzc(FirebaseUser firebaseUser) {
        String strZzc;
        if (this.zzh != null) {
            Log.d("RegionalFirebaseAuth", "Notifying id token listeners about user authentication.");
            strZzc = this.zzh.zzc();
        } else {
            Log.d("RegionalFirebaseAuth", "Notifying id token listeners about a sign-out event.");
            strZzc = null;
        }
        final InternalTokenResult internalTokenResult = new InternalTokenResult(strZzc);
        this.zzf.execute(new Runnable() { // from class: com.google.firebase.auth.internal.zzbz
            @Override // java.lang.Runnable
            public final void run() {
                zzca.zza(this.zza, internalTokenResult);
            }
        });
    }

    @Override // com.google.firebase.auth.FirebaseAuth, com.google.firebase.auth.internal.InternalAuthProvider
    public final void removeIdTokenListener(IdTokenListener idTokenListener) {
        Preconditions.checkNotNull(idTokenListener);
        this.zzc.remove(idTokenListener);
        zzc().zza(this.zzc.size());
    }

    @Override // com.google.firebase.auth.FirebaseAuth
    protected final void zzh() {
        if (this.zze == null) {
            return;
        }
        zzaia zzaiaVarZza = this.zze.zza(((com.google.firebase.auth.zzat) Preconditions.checkNotNull(com.google.firebase.auth.zzad.zza(getApp()).zzb())).zzc());
        if (zzaiaVarZza != null) {
            this.zzh = zzaiaVarZza;
        }
    }

    @Override // com.google.firebase.auth.FirebaseAuth
    public final void setTenantId(String str) {
        throw new UnsupportedOperationException("Setting tenantId dynamically is not supported when using regionalized FirebaseAuth. Instead, set tenantId directly in the constructor via TenantConfig.");
    }

    @Override // com.google.firebase.auth.FirebaseAuth
    public final void signOut() {
        zzg();
        zzc().zza();
    }

    @Override // com.google.firebase.auth.FirebaseAuth
    public final boolean zzi() {
        return this.zzh != null;
    }

    @Override // com.google.firebase.auth.FirebaseAuth
    public final boolean isSignInWithEmailLink(String str) {
        throw new UnsupportedOperationException("Regionalized functionality not yet supported for this method.");
    }
}

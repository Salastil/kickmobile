package com.google.firebase.auth;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzacv;
import com.google.android.gms.internal.p002firebaseauthapi.zzaew;
import com.google.android.gms.internal.p002firebaseauthapi.zzaez;
import com.google.android.gms.internal.p002firebaseauthapi.zzafm;
import com.google.android.gms.internal.p002firebaseauthapi.zzagg;
import com.google.android.gms.internal.p002firebaseauthapi.zzagq;
import com.google.android.gms.internal.p002firebaseauthapi.zzahw;
import com.google.android.gms.internal.p002firebaseauthapi.zzaia;
import com.google.android.gms.internal.p002firebaseauthapi.zzaib;
import com.google.android.gms.internal.p002firebaseauthapi.zzaio;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseError;
import com.google.firebase.FirebaseException;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.auth.internal.zzbg;
import com.google.firebase.auth.internal.zzbm;
import com.google.firebase.auth.internal.zzbv;
import com.google.firebase.auth.internal.zzce;
import com.google.firebase.auth.internal.zzcg;
import com.google.firebase.auth.internal.zzch;
import com.google.firebase.auth.internal.zzcj;
import com.google.firebase.heartbeatinfo.HeartBeatController;
import com.google.firebase.inject.Provider;
import com.google.firebase.internal.InternalTokenResult;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public class FirebaseAuth implements InternalAuthProvider {
    protected final List<IdTokenListener> zza;
    private String zzaa;
    protected final List<AuthStateListener> zzb;
    protected final List<com.google.firebase.auth.internal.IdTokenListener> zzc;
    protected final zzacv zzd;
    protected final zzce zze;
    protected final Executor zzf;
    private final FirebaseApp zzg;
    private FirebaseUser zzh;
    private final com.google.firebase.auth.internal.zzae zzi;
    private final Object zzj;
    private String zzk;
    private final Object zzl;
    private String zzm;
    private zzbv zzn;
    private final RecaptchaAction zzo;
    private final RecaptchaAction zzp;
    private final RecaptchaAction zzq;
    private final RecaptchaAction zzr;
    private final RecaptchaAction zzs;
    private final RecaptchaAction zzt;
    private final zzcj zzu;
    private final com.google.firebase.auth.internal.zza zzv;
    private final Provider<InteropAppCheckTokenProvider> zzw;
    private zzcg zzx;
    private final Executor zzy;
    private final Executor zzz;

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public interface AuthStateListener {
        void onAuthStateChanged(FirebaseAuth firebaseAuth);
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public interface IdTokenListener {
        void onIdTokenChanged(FirebaseAuth firebaseAuth);
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    class zza implements com.google.firebase.auth.internal.zzaw, com.google.firebase.auth.internal.zzj {
        private final /* synthetic */ FirebaseAuth zza;

        zza(FirebaseAuth firebaseAuth) {
            Objects.requireNonNull(firebaseAuth);
            this.zza = firebaseAuth;
        }

        @Override // com.google.firebase.auth.internal.zzj
        public final void zza(zzaia zzaiaVar, FirebaseUser firebaseUser) {
            Preconditions.checkNotNull(zzaiaVar);
            Preconditions.checkNotNull(firebaseUser);
            firebaseUser.zza(zzaiaVar);
            this.zza.zza(firebaseUser, zzaiaVar, true, true);
        }

        @Override // com.google.firebase.auth.internal.zzaw
        public final void zza(Status status) {
            if (status.getStatusCode() == 17011 || status.getStatusCode() == 17021 || status.getStatusCode() == 17005 || status.getStatusCode() == 17091) {
                this.zza.signOut();
            }
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    class zzb implements com.google.firebase.auth.internal.zzj {
        private final /* synthetic */ FirebaseAuth zza;

        zzb(FirebaseAuth firebaseAuth) {
            Objects.requireNonNull(firebaseAuth);
            this.zza = firebaseAuth;
        }

        @Override // com.google.firebase.auth.internal.zzj
        public final void zza(zzaia zzaiaVar, FirebaseUser firebaseUser) {
            Preconditions.checkNotNull(zzaiaVar);
            Preconditions.checkNotNull(firebaseUser);
            firebaseUser.zza(zzaiaVar);
            this.zza.zza(firebaseUser, zzaiaVar, true);
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    class zzc extends zzb implements com.google.firebase.auth.internal.zzaw, com.google.firebase.auth.internal.zzj {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        zzc(FirebaseAuth firebaseAuth) {
            super(firebaseAuth);
            Objects.requireNonNull(firebaseAuth);
        }

        @Override // com.google.firebase.auth.internal.zzaw
        public final void zza(Status status) {
        }
    }

    public Task<Void> applyActionCode(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzd.zza(this.zzg, str, this.zzm);
    }

    public Task<ActionCodeResult> checkActionCode(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzd.zzb(this.zzg, str, this.zzm);
    }

    public Task<Void> confirmPasswordReset(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return this.zzd.zza(this.zzg, str, str2, this.zzm);
    }

    public Task<AuthResult> createUserWithEmailAndPassword(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return new zzp(this, str, str2).zza(this, this.zzm, this.zzq, "EMAIL_PASSWORD_PROVIDER");
    }

    public final Task<Void> zza(FirebaseUser firebaseUser, MultiFactorAssertion multiFactorAssertion, String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(multiFactorAssertion);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            return this.zzd.zza(this.zzg, (PhoneMultiFactorAssertion) multiFactorAssertion, firebaseUser, str, new zzb(this));
        }
        if (multiFactorAssertion instanceof TotpMultiFactorAssertion) {
            return this.zzd.zza(this.zzg, (TotpMultiFactorAssertion) multiFactorAssertion, firebaseUser, str, this.zzm, new zzb(this));
        }
        return Tasks.forException(zzaew.zza(new Status(FirebaseError.ERROR_INTERNAL_ERROR)));
    }

    @Deprecated
    public Task<SignInMethodQueryResult> fetchSignInMethodsForEmail(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzd.zzc(this.zzg, str, this.zzm);
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider, com.google.firebase.internal.InternalTokenProvider
    public Task<GetTokenResult> getAccessToken(boolean z) {
        return zza(this.zzh, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.firebase.auth.internal.zzch, com.google.firebase.auth.zzz] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Task<GetTokenResult> zza(FirebaseUser firebaseUser, boolean z) {
        if (firebaseUser == null) {
            return Tasks.forException(zzaew.zza(new Status(FirebaseError.ERROR_NO_SIGNED_IN_USER)));
        }
        zzaia zzaiaVarZzc = firebaseUser.zzc();
        if (zzaiaVarZzc.zzg() && !z) {
            return Tasks.forResult(zzbg.zza(zzaiaVarZzc.zzc()));
        }
        return this.zzd.zza(this.zzg, firebaseUser, zzaiaVarZzc.zzd(), (zzch) new zzz(this));
    }

    public Task<AuthResult> getPendingAuthResult() {
        return this.zzu.zza();
    }

    public final Task<zzahw> zza() {
        return this.zzd.zza();
    }

    public final Task<zzaib> zza(String str) {
        return this.zzd.zza(this.zzm, str);
    }

    public Task<Void> initializeRecaptchaConfig() {
        if (this.zzn == null) {
            this.zzn = new zzbv(this.zzg, this);
        }
        return this.zzn.zza(this.zzm, false).continueWithTask(new zzy(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.firebase.auth.FirebaseAuth$zza, com.google.firebase.auth.internal.zzch] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Task<AuthResult> zza(FirebaseUser firebaseUser, AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        Preconditions.checkNotNull(firebaseUser);
        if (authCredential instanceof EmailAuthCredential) {
            return new zzm(this, firebaseUser, (EmailAuthCredential) authCredential.zza()).zza(this, firebaseUser.getTenantId(), this.zzq, "EMAIL_PASSWORD_PROVIDER");
        }
        return this.zzd.zza(this.zzg, firebaseUser, authCredential.zza(), (String) null, (zzch) new zza(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.firebase.auth.FirebaseAuth$zza, com.google.firebase.auth.internal.zzch] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.google.firebase.auth.FirebaseAuth$zza, com.google.firebase.auth.internal.zzch] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Task<Void> zzb(FirebaseUser firebaseUser, AuthCredential authCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(authCredential);
        AuthCredential authCredentialZza = authCredential.zza();
        if (authCredentialZza instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredentialZza;
            if ("password".equals(emailAuthCredential.getSignInMethod())) {
                return zza(firebaseUser, emailAuthCredential, false);
            }
            if (zzb(Preconditions.checkNotEmpty(emailAuthCredential.zze()))) {
                return Tasks.forException(zzaew.zza(new Status(17072)));
            }
            return zza(firebaseUser, emailAuthCredential, true);
        }
        boolean z = authCredentialZza instanceof PhoneAuthCredential;
        zzacv zzacvVar = this.zzd;
        if (z) {
            return zzacvVar.zza(this.zzg, firebaseUser, (PhoneAuthCredential) authCredentialZza, this.zzm, (zzch) new zza(this));
        }
        return zzacvVar.zzb(this.zzg, firebaseUser, authCredentialZza, firebaseUser.getTenantId(), (zzch) new zza(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.firebase.auth.FirebaseAuth$zza, com.google.firebase.auth.internal.zzch] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.google.firebase.auth.FirebaseAuth$zza, com.google.firebase.auth.internal.zzch] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Task<AuthResult> zzc(FirebaseUser firebaseUser, AuthCredential authCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(authCredential);
        AuthCredential authCredentialZza = authCredential.zza();
        if (authCredentialZza instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredentialZza;
            if ("password".equals(emailAuthCredential.getSignInMethod())) {
                return zza(emailAuthCredential.zzc(), Preconditions.checkNotEmpty(emailAuthCredential.zzd()), firebaseUser.getTenantId(), firebaseUser, true);
            }
            if (zzb(Preconditions.checkNotEmpty(emailAuthCredential.zze()))) {
                return Tasks.forException(zzaew.zza(new Status(17072)));
            }
            return zza(emailAuthCredential, firebaseUser, true);
        }
        boolean z = authCredentialZza instanceof PhoneAuthCredential;
        zzacv zzacvVar = this.zzd;
        if (z) {
            return zzacvVar.zzb(this.zzg, firebaseUser, (PhoneAuthCredential) authCredentialZza, this.zzm, (zzch) new zza(this));
        }
        return zzacvVar.zzc(this.zzg, firebaseUser, authCredentialZza, firebaseUser.getTenantId(), new zza(this));
    }

    private final Task<Void> zza(FirebaseUser firebaseUser, zzch zzchVar) {
        Preconditions.checkNotNull(firebaseUser);
        return this.zzd.zza(this.zzg, firebaseUser, zzchVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.firebase.auth.FirebaseAuth$zza, com.google.firebase.auth.internal.zzch] */
    public final Task<Void> zza(FirebaseUser firebaseUser) {
        return zza(firebaseUser, (zzch) new zza(this));
    }

    public final Task<AuthResult> zza(MultiFactorAssertion multiFactorAssertion, com.google.firebase.auth.internal.zzao zzaoVar, FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(multiFactorAssertion);
        Preconditions.checkNotNull(zzaoVar);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            return this.zzd.zza(this.zzg, firebaseUser, (PhoneMultiFactorAssertion) multiFactorAssertion, Preconditions.checkNotEmpty(zzaoVar.zzc()), new zzb(this));
        }
        if (multiFactorAssertion instanceof TotpMultiFactorAssertion) {
            return this.zzd.zza(this.zzg, firebaseUser, (TotpMultiFactorAssertion) multiFactorAssertion, Preconditions.checkNotEmpty(zzaoVar.zzc()), this.zzm, new zzb(this));
        }
        throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
    }

    public Task<Void> revokeAccessToken(String str) {
        Preconditions.checkNotEmpty(str);
        FirebaseUser currentUser = getCurrentUser();
        Preconditions.checkNotNull(currentUser);
        return currentUser.getIdToken(false).continueWithTask(new zzu(this, str));
    }

    public final Task<Void> zza(ActionCodeSettings actionCodeSettings, String str) {
        Preconditions.checkNotEmpty(str);
        if (this.zzk != null) {
            if (actionCodeSettings == null) {
                actionCodeSettings = ActionCodeSettings.zzb();
            }
            actionCodeSettings.zza(this.zzk);
        }
        return this.zzd.zza(this.zzg, actionCodeSettings, str);
    }

    public Task<Void> sendPasswordResetEmail(String str) {
        Preconditions.checkNotEmpty(str);
        return sendPasswordResetEmail(str, null);
    }

    public Task<Void> sendPasswordResetEmail(String str, ActionCodeSettings actionCodeSettings) {
        Preconditions.checkNotEmpty(str);
        if (actionCodeSettings == null) {
            actionCodeSettings = ActionCodeSettings.zzb();
        }
        String str2 = this.zzk;
        if (str2 != null) {
            actionCodeSettings.zza(str2);
        }
        actionCodeSettings.zza(1);
        return new zzo(this, str, actionCodeSettings).zza(this, this.zzm, this.zzo, "EMAIL_PASSWORD_PROVIDER");
    }

    public Task<Void> sendSignInLinkToEmail(String str, ActionCodeSettings actionCodeSettings) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(actionCodeSettings);
        if (!actionCodeSettings.canHandleCodeInApp()) {
            throw new IllegalArgumentException("You must set canHandleCodeInApp in your ActionCodeSettings to true for Email-Link Sign-in.");
        }
        String str2 = this.zzk;
        if (str2 != null) {
            actionCodeSettings.zza(str2);
        }
        return new zzr(this, str, actionCodeSettings).zza(this, this.zzm, this.zzo, "EMAIL_PASSWORD_PROVIDER");
    }

    public Task<Void> setFirebaseUIVersion(String str) {
        return this.zzd.zza(str);
    }

    public Task<AuthResult> signInAnonymously() {
        FirebaseUser firebaseUser = this.zzh;
        if (firebaseUser != null && firebaseUser.isAnonymous()) {
            com.google.firebase.auth.internal.zzad zzadVar = (com.google.firebase.auth.internal.zzad) this.zzh;
            zzadVar.zza(false);
            return Tasks.forResult(new com.google.firebase.auth.internal.zzx(zzadVar));
        }
        return this.zzd.zza(this.zzg, new zzb(this), this.zzm);
    }

    public Task<AuthResult> signInWithCredential(AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        AuthCredential authCredentialZza = authCredential.zza();
        if (authCredentialZza instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredentialZza;
            if (!emailAuthCredential.zzf()) {
                return zza(emailAuthCredential.zzc(), (String) Preconditions.checkNotNull(emailAuthCredential.zzd()), this.zzm, (FirebaseUser) null, false);
            }
            if (zzb(Preconditions.checkNotEmpty(emailAuthCredential.zze()))) {
                return Tasks.forException(zzaew.zza(new Status(17072)));
            }
            return zza(emailAuthCredential, (FirebaseUser) null, false);
        }
        if (authCredentialZza instanceof PhoneAuthCredential) {
            return this.zzd.zza(this.zzg, (PhoneAuthCredential) authCredentialZza, this.zzm, (com.google.firebase.auth.internal.zzj) new zzb(this));
        }
        return this.zzd.zza(this.zzg, authCredentialZza, this.zzm, new zzb(this));
    }

    public Task<AuthResult> signInWithCustomToken(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzd.zza(this.zzg, str, this.zzm, new zzb(this));
    }

    public Task<AuthResult> signInWithEmailAndPassword(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return zza(str, str2, this.zzm, (FirebaseUser) null, false);
    }

    public Task<AuthResult> signInWithEmailLink(String str, String str2) {
        return signInWithCredential(EmailAuthProvider.getCredentialWithLink(str, str2));
    }

    public final Task<AuthResult> zza(Activity activity, FederatedAuthProvider federatedAuthProvider, FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(federatedAuthProvider);
        Preconditions.checkNotNull(firebaseUser);
        TaskCompletionSource<AuthResult> taskCompletionSource = new TaskCompletionSource<>();
        if (!this.zzu.zza(activity, taskCompletionSource, this, firebaseUser)) {
            return Tasks.forException(zzaew.zza(new Status(17057)));
        }
        zzbm.zza(activity.getApplicationContext(), this, firebaseUser);
        federatedAuthProvider.zza(activity);
        return taskCompletionSource.getTask();
    }

    public final Task<AuthResult> zzb(Activity activity, FederatedAuthProvider federatedAuthProvider, FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(federatedAuthProvider);
        Preconditions.checkNotNull(firebaseUser);
        TaskCompletionSource<AuthResult> taskCompletionSource = new TaskCompletionSource<>();
        if (!this.zzu.zza(activity, taskCompletionSource, this, firebaseUser)) {
            return Tasks.forException(zzaew.zza(new Status(17057)));
        }
        zzbm.zza(activity.getApplicationContext(), this, firebaseUser);
        federatedAuthProvider.zzb(activity);
        return taskCompletionSource.getTask();
    }

    public Task<AuthResult> startActivityForSignInWithProvider(Activity activity, FederatedAuthProvider federatedAuthProvider) {
        Preconditions.checkNotNull(federatedAuthProvider);
        Preconditions.checkNotNull(activity);
        TaskCompletionSource<AuthResult> taskCompletionSource = new TaskCompletionSource<>();
        if (!this.zzu.zza(activity, taskCompletionSource, this)) {
            return Tasks.forException(zzaew.zza(new Status(17057)));
        }
        zzbm.zza(activity.getApplicationContext(), this);
        federatedAuthProvider.zzc(activity);
        return taskCompletionSource.getTask();
    }

    public final Task<TotpSecret> zza(com.google.firebase.auth.internal.zzao zzaoVar) {
        Preconditions.checkNotNull(zzaoVar);
        return this.zzd.zza(zzaoVar, this.zzm).continueWithTask(new zzv(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.firebase.auth.FirebaseAuth$zza, com.google.firebase.auth.internal.zzch] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Task<Void> zza(FirebaseUser firebaseUser, String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotEmpty(str);
        return this.zzd.zza(this.zzg, firebaseUser, str, this.zzm, (zzch) new zza(this)).continueWithTask(new zzq(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.firebase.auth.FirebaseAuth$zza, com.google.firebase.auth.internal.zzch] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Task<AuthResult> zzb(FirebaseUser firebaseUser, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(firebaseUser);
        return this.zzd.zzb(this.zzg, firebaseUser, str, new zza(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.google.firebase.auth.FirebaseAuth$zzc, com.google.firebase.auth.internal.zzch] */
    public Task<Void> updateCurrentUser(FirebaseUser firebaseUser) {
        String str;
        if (firebaseUser == null) {
            throw new IllegalArgumentException("Cannot update current user with null user!");
        }
        String tenantId = firebaseUser.getTenantId();
        if ((tenantId != null && !tenantId.equals(this.zzm)) || ((str = this.zzm) != null && !str.equals(tenantId))) {
            return Tasks.forException(zzaew.zza(new Status(17072)));
        }
        String apiKey = firebaseUser.zza().getOptions().getApiKey();
        String apiKey2 = this.zzg.getOptions().getApiKey();
        if (firebaseUser.zzc().zzg() && apiKey2.equals(apiKey)) {
            zza(com.google.firebase.auth.internal.zzad.zza(this.zzg, firebaseUser), firebaseUser.zzc(), true);
            return Tasks.forResult(null);
        }
        return zza(firebaseUser, (zzch) new zzc(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.firebase.auth.FirebaseAuth$zza, com.google.firebase.auth.internal.zzch] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Task<Void> zzc(FirebaseUser firebaseUser, String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotEmpty(str);
        return this.zzd.zzc(this.zzg, firebaseUser, str, new zza(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.firebase.auth.FirebaseAuth$zza, com.google.firebase.auth.internal.zzch] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Task<Void> zzd(FirebaseUser firebaseUser, String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotEmpty(str);
        return this.zzd.zzd(this.zzg, firebaseUser, str, new zza(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.firebase.auth.FirebaseAuth$zza, com.google.firebase.auth.internal.zzch] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Task<Void> zza(FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(phoneAuthCredential);
        return this.zzd.zza(this.zzg, firebaseUser, (PhoneAuthCredential) phoneAuthCredential.zza(), (zzch) new zza(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.firebase.auth.FirebaseAuth$zza, com.google.firebase.auth.internal.zzch] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Task<Void> zza(FirebaseUser firebaseUser, UserProfileChangeRequest userProfileChangeRequest) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(userProfileChangeRequest);
        return this.zzd.zza(this.zzg, firebaseUser, userProfileChangeRequest, (zzch) new zza(this));
    }

    public final Task<Void> zza(String str, String str2, ActionCodeSettings actionCodeSettings) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        if (actionCodeSettings == null) {
            actionCodeSettings = ActionCodeSettings.zzb();
        }
        String str3 = this.zzk;
        if (str3 != null) {
            actionCodeSettings.zza(str3);
        }
        return this.zzd.zza(str, str2, actionCodeSettings);
    }

    public Task<String> verifyPasswordResetCode(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzd.zzd(this.zzg, str, this.zzm);
    }

    private final Task<Void> zza(FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, boolean z) {
        return new zzac(this, z, firebaseUser, emailAuthCredential).zza(this, this.zzm, z ? this.zzo : this.zzp, "EMAIL_PASSWORD_PROVIDER");
    }

    private final Task<AuthResult> zza(String str, String str2, String str3, FirebaseUser firebaseUser, boolean z) {
        return new zzab(this, str, z, firebaseUser, str2, str3).zza(this, str3, this.zzp, "EMAIL_PASSWORD_PROVIDER");
    }

    private final Task<AuthResult> zza(EmailAuthCredential emailAuthCredential, FirebaseUser firebaseUser, boolean z) {
        return new zzaa(this, z, firebaseUser, emailAuthCredential).zza(this, this.zzm, this.zzo, "EMAIL_PASSWORD_PROVIDER");
    }

    public FirebaseApp getApp() {
        return this.zzg;
    }

    public static FirebaseAuth getInstance() {
        return ((zzad) Preconditions.checkNotNull(zzad.zza(FirebaseApp.getInstance()))).zza();
    }

    public static FirebaseAuth getInstance(FirebaseApp firebaseApp) {
        return ((zzad) Preconditions.checkNotNull(zzad.zza(firebaseApp))).zza();
    }

    public static FirebaseAuth zza(FirebaseApp firebaseApp, zzat zzatVar) {
        Preconditions.checkNotNull(firebaseApp, "firebaseApp cannot be null");
        Preconditions.checkNotNull(zzatVar, "tenantConfig cannot be null");
        return ((zzad) Preconditions.checkNotNull(zzad.zza(firebaseApp))).zza(zzatVar);
    }

    public FirebaseAuthSettings getFirebaseAuthSettings() {
        return this.zzi;
    }

    public FirebaseUser getCurrentUser() {
        return this.zzh;
    }

    final PhoneAuthProvider.OnVerificationStateChangedCallbacks zza(PhoneAuthOptions phoneAuthOptions, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, com.google.firebase.auth.internal.zzh zzhVar) {
        return phoneAuthOptions.zzj() ? onVerificationStateChangedCallbacks : new zzn(this, phoneAuthOptions, zzhVar, onVerificationStateChangedCallbacks);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PhoneAuthProvider.OnVerificationStateChangedCallbacks zza(String str, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks) {
        return (this.zzi.zzd() && str != null && str.equals(this.zzi.zza())) ? new zzk(this, onVerificationStateChangedCallbacks) : onVerificationStateChangedCallbacks;
    }

    public final synchronized zzbv zzb() {
        return this.zzn;
    }

    public final synchronized zzcg zzc() {
        return zzf(this);
    }

    private static zzcg zzf(FirebaseAuth firebaseAuth) {
        if (firebaseAuth.zzx == null) {
            firebaseAuth.zzx = new zzcg((FirebaseApp) Preconditions.checkNotNull(firebaseAuth.zzg));
        }
        return firebaseAuth.zzx;
    }

    public final Provider<InteropAppCheckTokenProvider> zzd() {
        return this.zzw;
    }

    public String getCustomAuthDomain() {
        return this.zzaa;
    }

    public String getLanguageCode() {
        String str;
        synchronized (this.zzj) {
            str = this.zzk;
        }
        return str;
    }

    public String getTenantId() {
        String str;
        synchronized (this.zzl) {
            str = this.zzm;
        }
        return str;
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider, com.google.firebase.internal.InternalTokenProvider
    public String getUid() {
        FirebaseUser firebaseUser = this.zzh;
        if (firebaseUser == null) {
            return null;
        }
        return firebaseUser.getUid();
    }

    public final Executor zze() {
        return this.zzy;
    }

    public final Executor zzf() {
        return this.zzz;
    }

    public FirebaseAuth(FirebaseApp firebaseApp, Provider<InteropAppCheckTokenProvider> provider, Provider<HeartBeatController> provider2, Executor executor, Executor executor2, Executor executor3, ScheduledExecutorService scheduledExecutorService, Executor executor4) {
        this(firebaseApp, new zzacv(firebaseApp, executor2, scheduledExecutorService), new zzce(firebaseApp.getApplicationContext(), firebaseApp.getPersistenceKey()), zzcj.zzc(), com.google.firebase.auth.internal.zza.zza(), provider, provider2, executor, executor2, executor3, executor4);
    }

    private FirebaseAuth(FirebaseApp firebaseApp, zzacv zzacvVar, zzce zzceVar, zzcj zzcjVar, com.google.firebase.auth.internal.zza zzaVar, Provider<InteropAppCheckTokenProvider> provider, Provider<HeartBeatController> provider2, Executor executor, Executor executor2, Executor executor3, Executor executor4) {
        this.zza = new CopyOnWriteArrayList();
        this.zzb = new CopyOnWriteArrayList();
        this.zzc = new CopyOnWriteArrayList();
        this.zzj = new Object();
        this.zzl = new Object();
        this.zzo = RecaptchaAction.custom("getOobCode");
        this.zzp = RecaptchaAction.custom("signInWithPassword");
        this.zzq = RecaptchaAction.custom("signUpPassword");
        this.zzr = RecaptchaAction.custom("sendVerificationCode");
        this.zzs = RecaptchaAction.custom("mfaSmsEnrollment");
        this.zzt = RecaptchaAction.custom("mfaSmsSignIn");
        this.zzg = (FirebaseApp) Preconditions.checkNotNull(firebaseApp);
        this.zzd = (zzacv) Preconditions.checkNotNull(zzacvVar);
        this.zze = (zzce) Preconditions.checkNotNull(zzceVar);
        this.zzi = new com.google.firebase.auth.internal.zzae();
        this.zzu = (zzcj) Preconditions.checkNotNull(zzcjVar);
        this.zzv = (com.google.firebase.auth.internal.zza) Preconditions.checkNotNull(zzaVar);
        this.zzw = provider;
        this.zzy = executor2;
        this.zzz = executor3;
        this.zzf = executor4;
        zzh();
    }

    public void addAuthStateListener(AuthStateListener authStateListener) {
        this.zzb.add(authStateListener);
        this.zzf.execute(new zzs(this, authStateListener));
    }

    public void addIdTokenListener(IdTokenListener idTokenListener) {
        this.zza.add(idTokenListener);
        this.zzf.execute(new zzj(this, idTokenListener));
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    public void addIdTokenListener(com.google.firebase.auth.internal.IdTokenListener idTokenListener) {
        Preconditions.checkNotNull(idTokenListener);
        this.zzc.add(idTokenListener);
        zzc().zza(this.zzc.size());
    }

    public void zzg() {
        Preconditions.checkNotNull(this.zze);
        FirebaseUser firebaseUser = this.zzh;
        if (firebaseUser != null) {
            this.zze.zzb(firebaseUser);
            this.zzh = null;
        }
        this.zze.zzb();
        zzc((FirebaseUser) null);
        zzb((FirebaseUser) null);
    }

    public static void zza(final FirebaseException firebaseException, PhoneAuthOptions phoneAuthOptions, String str) {
        Log.e("FirebaseAuth", "Invoking verification failure callback for phone number/uid - " + str);
        final PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacksZza = zzagg.zza(str, phoneAuthOptions.zze(), null);
        phoneAuthOptions.zzi().execute(new Runnable() { // from class: com.google.firebase.auth.zzh
            @Override // java.lang.Runnable
            public final void run() {
                onVerificationStateChangedCallbacksZza.onVerificationFailed(firebaseException);
            }
        });
    }

    public void zzb(FirebaseUser firebaseUser) {
        zza(this, (FirebaseUser) null);
    }

    public void zzc(FirebaseUser firebaseUser) {
        zzb(this, (FirebaseUser) null);
    }

    public void removeAuthStateListener(AuthStateListener authStateListener) {
        this.zzb.remove(authStateListener);
    }

    public void removeIdTokenListener(IdTokenListener idTokenListener) {
        this.zza.remove(idTokenListener);
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    public void removeIdTokenListener(com.google.firebase.auth.internal.IdTokenListener idTokenListener) {
        Preconditions.checkNotNull(idTokenListener);
        this.zzc.remove(idTokenListener);
        zzc().zza(this.zzc.size());
    }

    protected void zzh() {
        zzaia zzaiaVarZza;
        FirebaseUser firebaseUserZza = this.zze.zza();
        this.zzh = firebaseUserZza;
        if (firebaseUserZza != null && (zzaiaVarZza = this.zze.zza(firebaseUserZza)) != null) {
            zza(this, this.zzh, zzaiaVarZza, false, false);
        }
        this.zzu.zza(this);
    }

    public void setCustomAuthDomain(String str) {
        String str2;
        Preconditions.checkNotEmpty(str);
        if (str.startsWith("chrome-extension://")) {
            this.zzaa = str;
            return;
        }
        if (str.contains("://")) {
            str2 = str;
        } else {
            str2 = "http://" + str;
        }
        try {
            this.zzaa = (String) Preconditions.checkNotNull(new URI(str2).getHost());
        } catch (URISyntaxException e) {
            if (Log.isLoggable("FirebaseAuth", 4)) {
                Log.i("FirebaseAuth", "Error parsing URL: '" + str + "', " + e.getMessage());
            }
            this.zzaa = str;
        }
    }

    public void setLanguageCode(String str) {
        Preconditions.checkNotEmpty(str);
        synchronized (this.zzj) {
            this.zzk = str;
        }
    }

    public final synchronized void zza(zzbv zzbvVar) {
        this.zzn = zzbvVar;
    }

    public void setTenantId(String str) {
        Preconditions.checkNotEmpty(str);
        synchronized (this.zzl) {
            this.zzm = str;
        }
    }

    public final void zza(FirebaseUser firebaseUser, zzaia zzaiaVar, boolean z) {
        zza(firebaseUser, zzaiaVar, true, false);
    }

    final void zza(FirebaseUser firebaseUser, zzaia zzaiaVar, boolean z, boolean z2) {
        zza(this, firebaseUser, zzaiaVar, true, z2);
    }

    public void signOut() {
        zzg();
        zzcg zzcgVar = this.zzx;
        if (zzcgVar != null) {
            zzcgVar.zza();
        }
    }

    private static void zza(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        if (firebaseUser == null) {
            Log.d("FirebaseAuth", "Notifying auth state listeners about a sign-out event.");
        } else {
            Log.d("FirebaseAuth", "Notifying auth state listeners about user ( " + firebaseUser.getUid() + " ).");
        }
        firebaseAuth.zzf.execute(new zzw(firebaseAuth));
    }

    private static void zzb(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        if (firebaseUser == null) {
            Log.d("FirebaseAuth", "Notifying id token listeners about a sign-out event.");
        } else {
            Log.d("FirebaseAuth", "Notifying id token listeners about user ( " + firebaseUser.getUid() + " ).");
        }
        firebaseAuth.zzf.execute(new zzx(firebaseAuth, new InternalTokenResult(firebaseUser != null ? firebaseUser.zzd() : null)));
    }

    private static void zza(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser, zzaia zzaiaVar, boolean z, boolean z2) {
        boolean z3;
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzaiaVar);
        boolean z4 = true;
        boolean z5 = firebaseAuth.zzh != null && firebaseUser.getUid().equals(firebaseAuth.zzh.getUid());
        if (z5 || !z2) {
            FirebaseUser firebaseUser2 = firebaseAuth.zzh;
            if (firebaseUser2 == null) {
                z3 = true;
            } else {
                boolean z6 = (z5 && firebaseUser2.zzc().zzc().equals(zzaiaVar.zzc())) ? false : true;
                z3 = z5 ? false : true;
                z4 = z6;
            }
            Preconditions.checkNotNull(firebaseUser);
            if (firebaseAuth.zzh == null || !firebaseUser.getUid().equals(firebaseAuth.getUid())) {
                firebaseAuth.zzh = firebaseUser;
            } else {
                firebaseAuth.zzh.zza(firebaseUser.getProviderData());
                if (!firebaseUser.isAnonymous()) {
                    firebaseAuth.zzh.zzb();
                }
                List<MultiFactorInfo> enrolledFactors = firebaseUser.getMultiFactor().getEnrolledFactors();
                List<zzao> listZzf = firebaseUser.zzf();
                firebaseAuth.zzh.zzc(enrolledFactors);
                firebaseAuth.zzh.zzb(listZzf);
            }
            if (z) {
                firebaseAuth.zze.zzc(firebaseAuth.zzh);
            }
            if (z4) {
                FirebaseUser firebaseUser3 = firebaseAuth.zzh;
                if (firebaseUser3 != null) {
                    firebaseUser3.zza(zzaiaVar);
                }
                zzb(firebaseAuth, firebaseAuth.zzh);
            }
            if (z3) {
                zza(firebaseAuth, firebaseAuth.zzh);
            }
            if (z) {
                firebaseAuth.zze.zza(firebaseUser, zzaiaVar);
            }
            FirebaseUser firebaseUser4 = firebaseAuth.zzh;
            if (firebaseUser4 != null) {
                zzf(firebaseAuth).zza(firebaseUser4.zzc());
            }
        }
    }

    public void useAppLanguage() {
        synchronized (this.zzj) {
            this.zzk = zzafm.zza();
        }
    }

    public void useEmulator(String str, int i) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkArgument(i >= 0 && i <= 65535, "Port number must be in the range 0-65535");
        zzagq.zza(this.zzg, str, i);
    }

    public static void zza(PhoneAuthOptions phoneAuthOptions) {
        String strCheckNotEmpty;
        String phoneNumber;
        if (phoneAuthOptions.zzm()) {
            FirebaseAuth firebaseAuthZzb = phoneAuthOptions.zzb();
            com.google.firebase.auth.internal.zzao zzaoVar = (com.google.firebase.auth.internal.zzao) Preconditions.checkNotNull(phoneAuthOptions.zzc());
            if (zzaoVar.zzd()) {
                phoneNumber = Preconditions.checkNotEmpty(phoneAuthOptions.zzh());
                strCheckNotEmpty = phoneNumber;
            } else {
                PhoneMultiFactorInfo phoneMultiFactorInfo = (PhoneMultiFactorInfo) Preconditions.checkNotNull(phoneAuthOptions.zzf());
                strCheckNotEmpty = Preconditions.checkNotEmpty(phoneMultiFactorInfo.getUid());
                phoneNumber = phoneMultiFactorInfo.getPhoneNumber();
            }
            if (phoneAuthOptions.zzd() == null || !zzagg.zza(strCheckNotEmpty, phoneAuthOptions.zze(), phoneAuthOptions.zza(), phoneAuthOptions.zzi())) {
                firebaseAuthZzb.zzv.zza(firebaseAuthZzb, phoneNumber, phoneAuthOptions.zza(), firebaseAuthZzb.zzj(), phoneAuthOptions.zzj(), phoneAuthOptions.zzl(), zzaoVar.zzd() ? firebaseAuthZzb.zzs : firebaseAuthZzb.zzt).addOnCompleteListener(new zzl(firebaseAuthZzb, phoneAuthOptions, strCheckNotEmpty));
                return;
            }
            return;
        }
        FirebaseAuth firebaseAuthZzb2 = phoneAuthOptions.zzb();
        String strCheckNotEmpty2 = Preconditions.checkNotEmpty(phoneAuthOptions.zzh());
        if (phoneAuthOptions.zzd() == null && zzagg.zza(strCheckNotEmpty2, phoneAuthOptions.zze(), phoneAuthOptions.zza(), phoneAuthOptions.zzi())) {
            return;
        }
        firebaseAuthZzb2.zzv.zza(firebaseAuthZzb2, strCheckNotEmpty2, phoneAuthOptions.zza(), firebaseAuthZzb2.zzj(), phoneAuthOptions.zzj(), phoneAuthOptions.zzl(), firebaseAuthZzb2.zzr).addOnCompleteListener(new zzi(firebaseAuthZzb2, phoneAuthOptions, strCheckNotEmpty2));
    }

    public final void zza(PhoneAuthOptions phoneAuthOptions, com.google.firebase.auth.internal.zzh zzhVar) {
        PhoneAuthOptions phoneAuthOptions2;
        long jLongValue = phoneAuthOptions.zzg().longValue();
        if (jLongValue < 0 || jLongValue > 120) {
            throw new IllegalArgumentException("We only support 0-120 seconds for sms-auto-retrieval timeout");
        }
        String strCheckNotEmpty = Preconditions.checkNotEmpty(phoneAuthOptions.zzh());
        String strZzc = zzhVar.zzc();
        String strZzb = zzhVar.zzb();
        String strZzd = zzhVar.zzd();
        if (com.google.android.gms.internal.p002firebaseauthapi.zzac.zzc(strZzc) && zzb() != null && zzb().zza("PHONE_PROVIDER")) {
            strZzc = "NO_RECAPTCHA";
        }
        String str = strZzc;
        zzaio zzaioVar = new zzaio(strCheckNotEmpty, jLongValue, phoneAuthOptions.zzd() != null, this.zzk, this.zzm, strZzd, strZzb, str, zzj());
        PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacksZza = zza(strCheckNotEmpty, phoneAuthOptions.zze());
        if (TextUtils.isEmpty(zzhVar.zzd())) {
            phoneAuthOptions2 = phoneAuthOptions;
            onVerificationStateChangedCallbacksZza = zza(phoneAuthOptions2, onVerificationStateChangedCallbacksZza, com.google.firebase.auth.internal.zzh.zza().zzc(strZzd).zzb(str).zza(strZzb).zza());
        } else {
            phoneAuthOptions2 = phoneAuthOptions;
        }
        this.zzd.zza(this.zzg, zzaioVar, onVerificationStateChangedCallbacksZza, phoneAuthOptions2.zza(), phoneAuthOptions2.zzi());
    }

    public boolean zzi() {
        return getCurrentUser() != null;
    }

    final boolean zzj() {
        return zzaez.zza(getApp().getApplicationContext());
    }

    public boolean isSignInWithEmailLink(String str) {
        return EmailAuthCredential.zza(str);
    }

    private final boolean zzb(String str) {
        ActionCodeUrl link = ActionCodeUrl.parseLink(str);
        return (link == null || TextUtils.equals(this.zzm, link.zza())) ? false : true;
    }
}

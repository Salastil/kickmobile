package io.invertase.firebase.auth;

import android.app.Activity;
import android.net.Uri;
import android.os.Parcel;
import android.util.Log;
import androidx.autofill.HintConstants;
import com.datadog.android.rum.internal.domain.scope.RumSessionScope;
import com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.cast.MediaError;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.common.base.Ascii;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseNetworkException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.ActionCodeResult;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthMultiFactorException;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.GithubAuthProvider;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.MultiFactorResolver;
import com.google.firebase.auth.MultiFactorSession;
import com.google.firebase.auth.OAuthProvider;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.PhoneMultiFactorAssertion;
import com.google.firebase.auth.PhoneMultiFactorGenerator;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.auth.TotpMultiFactorAssertion;
import com.google.firebase.auth.TotpMultiFactorGenerator;
import com.google.firebase.auth.TotpSecret;
import com.google.firebase.auth.TwitterAuthProvider;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.auth.UserProfileChangeRequest;
import io.invertase.firebase.app.NativeRNFBTurboApp;
import io.invertase.firebase.common.ReactNativeFirebaseEvent;
import io.invertase.firebase.common.ReactNativeFirebaseEventEmitter;
import io.invertase.firebase.common.ReactNativeFirebaseModule;
import io.invertase.firebase.common.SharedUtils;
import io.invertase.firebase.common.TaskExecutorService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes9.dex */
public class NativeRNFBTurboAuth extends NativeRNFBTurboAuthSpec {
    private static final String TAG = "Auth";
    private final RNFBAuthCacheRegistry<AuthCredential> credentials;
    private final TaskExecutorService executorService;
    private final RNFBAuthCacheRegistry<MultiFactorResolver> mCachedResolvers;
    private PhoneAuthCredential mCredential;
    private PhoneAuthProvider.ForceResendingToken mForceResendingToken;
    private String mLastPhoneNumber;
    private final RNFBAuthCacheRegistry<MultiFactorSession> mMultiFactorSessions;
    private final RNFBAuthCacheRegistry<TotpSecret> mTotpSecrets;
    private String mVerificationId;
    public static final SimpleDateFormat ISO_8601_FORMATTER = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
    private static final RNFBAuthListenerRegistry authStateListeners = new RNFBAuthListenerRegistry();
    private static final RNFBAuthListenerRegistry idTokenListeners = new RNFBAuthListenerRegistry();
    private static HashMap<String, String> emulatorConfigs = new HashMap<>();

    public NativeRNFBTurboAuth(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mCachedResolvers = new RNFBAuthCacheRegistry<>();
        this.mMultiFactorSessions = new RNFBAuthCacheRegistry<>();
        this.mTotpSecrets = new RNFBAuthCacheRegistry<>();
        this.credentials = new RNFBAuthCacheRegistry<>();
        this.executorService = new TaskExecutorService(NativeRNFBTurboAuthSpec.NAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ExecutorService getExecutor() {
        return this.executorService.getExecutor();
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void initialize() {
        super.initialize();
        Log.d(TAG, "instance-initialized");
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        super.invalidate();
        Log.d(TAG, "instance-destroyed");
        authStateListeners.takeAllAndRemove();
        idTokenListeners.takeAllAndRemove();
        this.mCachedResolvers.clear();
        this.mMultiFactorSessions.clear();
        this.mTotpSecrets.clear();
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void configureAuthDomain(String str) {
        Log.d(TAG, "configureAuthDomain");
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        String str2 = NativeRNFBTurboApp.authDomains.get(str);
        Log.d(TAG, "configureAuthDomain - app " + str + " domain? " + str2);
        if (str2 != null) {
            firebaseAuth.setCustomAuthDomain(str2);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void getCustomAuthDomain(String str, Promise promise) {
        Log.d(TAG, "configureAuthDomain");
        promise.resolve(FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).getCustomAuthDomain());
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void addAuthStateListener(final String str) {
        Log.d(TAG, "addAuthStateListener");
        final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        RNFBAuthListenerRegistry rNFBAuthListenerRegistry = authStateListeners;
        if (rNFBAuthListenerRegistry.get(str) != null) {
            return;
        }
        final FirebaseAuth.AuthStateListener authStateListener = new FirebaseAuth.AuthStateListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda43
            @Override // com.google.firebase.auth.FirebaseAuth.AuthStateListener
            public final void onAuthStateChanged(FirebaseAuth firebaseAuth2) {
                this.f$0.lambda$addAuthStateListener$0(str, firebaseAuth2);
            }
        };
        firebaseAuth.addAuthStateListener(authStateListener);
        rNFBAuthListenerRegistry.putOrDiscard(str, new AuthListenerHandle() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda45
            @Override // io.invertase.firebase.auth.AuthListenerHandle
            public final void remove() {
                firebaseAuth.removeAuthStateListener(authStateListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addAuthStateListener$0(String str, FirebaseAuth firebaseAuth) {
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        WritableMap writableMapCreateMap = Arguments.createMap();
        ReactNativeFirebaseEventEmitter sharedInstance = ReactNativeFirebaseEventEmitter.getSharedInstance();
        if (currentUser != null) {
            writableMapCreateMap.putString("appName", str);
            writableMapCreateMap.putMap("user", firebaseUserToMap(currentUser));
        } else {
            writableMapCreateMap.putString("appName", str);
        }
        Log.d(TAG, "addAuthStateListener:eventBody " + writableMapCreateMap.toString());
        sharedInstance.sendEvent(new ReactNativeFirebaseEvent("auth_state_changed", writableMapCreateMap, str));
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void removeAuthStateListener(String str) {
        Log.d(TAG, "removeAuthStateListener");
        authStateListeners.takeAndRemove(str);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void addIdTokenListener(final String str) {
        Log.d(TAG, "addIdTokenListener");
        final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        RNFBAuthListenerRegistry rNFBAuthListenerRegistry = idTokenListeners;
        if (rNFBAuthListenerRegistry.get(str) != null) {
            return;
        }
        final FirebaseAuth.IdTokenListener idTokenListener = new FirebaseAuth.IdTokenListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda10
            @Override // com.google.firebase.auth.FirebaseAuth.IdTokenListener
            public final void onIdTokenChanged(FirebaseAuth firebaseAuth2) {
                this.f$0.lambda$addIdTokenListener$2(str, firebaseAuth2);
            }
        };
        firebaseAuth.addIdTokenListener(idTokenListener);
        rNFBAuthListenerRegistry.putOrDiscard(str, new AuthListenerHandle() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda12
            @Override // io.invertase.firebase.auth.AuthListenerHandle
            public final void remove() {
                firebaseAuth.removeIdTokenListener(idTokenListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addIdTokenListener$2(String str, FirebaseAuth firebaseAuth) {
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        ReactNativeFirebaseEventEmitter sharedInstance = ReactNativeFirebaseEventEmitter.getSharedInstance();
        WritableMap writableMapCreateMap = Arguments.createMap();
        if (currentUser != null) {
            writableMapCreateMap.putBoolean("authenticated", true);
            writableMapCreateMap.putString("appName", str);
            writableMapCreateMap.putMap("user", firebaseUserToMap(currentUser));
        } else {
            writableMapCreateMap.putString("appName", str);
            writableMapCreateMap.putBoolean("authenticated", false);
        }
        sharedInstance.sendEvent(new ReactNativeFirebaseEvent("auth_id_token_changed", writableMapCreateMap, str));
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void removeIdTokenListener(String str) {
        Log.d(TAG, "removeIdTokenListener");
        idTokenListeners.takeAndRemove(str);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void forceRecaptchaFlowForTesting(String str, boolean z, Promise promise) {
        Log.d(TAG, "forceRecaptchaFlowForTesting");
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).getFirebaseAuthSettings().forceRecaptchaFlowForTesting(z);
        promise.resolve(null);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void setAutoRetrievedSmsCodeForPhoneNumber(String str, String str2, String str3, Promise promise) {
        Log.d(TAG, "setAutoRetrievedSmsCodeForPhoneNumber");
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).getFirebaseAuthSettings().setAutoRetrievedSmsCodeForPhoneNumber(str2, str3);
        promise.resolve(null);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void setAppVerificationDisabledForTesting(String str, boolean z, Promise promise) {
        Log.d(TAG, "setAppVerificationDisabledForTesting");
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).getFirebaseAuthSettings().setAppVerificationDisabledForTesting(z);
        promise.resolve(null);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void useUserAccessGroup(String str, String str2, Promise promise) {
        promise.resolve(null);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void signOut(String str, Promise promise) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        Log.d(TAG, "signOut");
        if (firebaseAuth == null || firebaseAuth.getCurrentUser() == null) {
            promiseNoUser(promise, true);
        } else {
            firebaseAuth.signOut();
            promiseNoUser(promise, false);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void signInAnonymously(String str, final Promise promise) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        Log.d(TAG, "signInAnonymously");
        firebaseAuth.signInAnonymously().addOnSuccessListener(new OnSuccessListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda48
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                this.f$0.lambda$signInAnonymously$4(promise, (AuthResult) obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda49
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                this.f$0.lambda$signInAnonymously$5(promise, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$signInAnonymously$4(Promise promise, AuthResult authResult) {
        Log.d(TAG, "signInAnonymously:onComplete:success");
        promiseWithAuthResult(authResult, promise);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$signInAnonymously$5(Promise promise, Exception exc) {
        Log.e(TAG, "signInAnonymously:onComplete:failure", exc);
        promiseRejectAuthException(promise, exc);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void createUserWithEmailAndPassword(String str, String str2, String str3, final Promise promise) {
        Log.d(TAG, "createUserWithEmailAndPassword");
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).createUserWithEmailAndPassword(str2, str3).addOnSuccessListener(new OnSuccessListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda7
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                this.f$0.lambda$createUserWithEmailAndPassword$6(promise, (AuthResult) obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda8
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                this.f$0.lambda$createUserWithEmailAndPassword$7(promise, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createUserWithEmailAndPassword$6(Promise promise, AuthResult authResult) {
        Log.d(TAG, "createUserWithEmailAndPassword:onComplete:success");
        promiseWithAuthResult(authResult, promise);
        Log.d(TAG, "createUserWithEmailAndPassword:onComplete:promiseResolved");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createUserWithEmailAndPassword$7(Promise promise, Exception exc) {
        Log.e(TAG, "createUserWithEmailAndPassword:onComplete:failure", exc);
        promiseRejectAuthException(promise, exc);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public boolean isSignInWithEmailLink(String str, String str2) {
        Log.d(TAG, "isSignInWithEmailLink");
        return FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).isSignInWithEmailLink(str2);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void signInWithEmailAndPassword(String str, String str2, String str3, final Promise promise) {
        Log.d(TAG, "signInWithEmailAndPassword");
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).signInWithEmailAndPassword(str2, str3).addOnSuccessListener(new OnSuccessListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda5
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                this.f$0.lambda$signInWithEmailAndPassword$8(promise, (AuthResult) obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda6
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                this.f$0.lambda$signInWithEmailAndPassword$9(promise, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$signInWithEmailAndPassword$8(Promise promise, AuthResult authResult) {
        Log.d(TAG, "signInWithEmailAndPassword:onComplete:success");
        promiseWithAuthResult(authResult, promise);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$signInWithEmailAndPassword$9(Promise promise, Exception exc) {
        Log.e(TAG, "signInWithEmailAndPassword:onComplete:failure", exc);
        promiseRejectAuthException(promise, exc);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void signInWithEmailLink(String str, String str2, String str3, final Promise promise) {
        Log.d(TAG, "signInWithEmailLink");
        try {
            FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).signInWithEmailLink(str2, str3).addOnSuccessListener(new OnSuccessListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda0
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    this.f$0.lambda$signInWithEmailLink$10(promise, (AuthResult) obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda11
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    this.f$0.lambda$signInWithEmailLink$11(promise, exc);
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "signInWithEmailLink:onComplete:totalfailure", e);
            promiseRejectAuthException(promise, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$signInWithEmailLink$10(Promise promise, AuthResult authResult) {
        Log.d(TAG, "signInWithEmailLink:onComplete:success");
        promiseWithAuthResult(authResult, promise);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$signInWithEmailLink$11(Promise promise, Exception exc) {
        Log.e(TAG, "signInWithEmailLink:onComplete:failure", exc);
        promiseRejectAuthException(promise, exc);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void signInWithCustomToken(String str, String str2, final Promise promise) {
        Log.d(TAG, "signInWithCustomToken");
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).signInWithCustomToken(str2).addOnSuccessListener(new OnSuccessListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                this.f$0.lambda$signInWithCustomToken$12(promise, (AuthResult) obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda3
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                this.f$0.lambda$signInWithCustomToken$13(promise, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$signInWithCustomToken$12(Promise promise, AuthResult authResult) {
        Log.d(TAG, "signInWithCustomToken:onComplete:success");
        promiseWithAuthResult(authResult, promise);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$signInWithCustomToken$13(Promise promise, Exception exc) {
        Log.e(TAG, "signInWithCustomToken:onComplete:failure", exc);
        promiseRejectAuthException(promise, exc);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void revokeToken(String str, String str2, Promise promise) {
        Log.d(TAG, "revokeToken");
        Log.e(TAG, "revokeToken:failure:noCurrentUser");
        promiseNoUser(promise, false);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void sendPasswordResetEmail(String str, String str2, ReadableMap readableMap, final Promise promise) {
        Log.d(TAG, "sendPasswordResetEmail");
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        OnCompleteListener<Void> onCompleteListener = new OnCompleteListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda23
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f$0.lambda$sendPasswordResetEmail$14(promise, task);
            }
        };
        if (readableMap == null) {
            firebaseAuth.sendPasswordResetEmail(str2).addOnCompleteListener(getExecutor(), onCompleteListener);
        } else {
            firebaseAuth.sendPasswordResetEmail(str2, buildActionCodeSettings(readableMap)).addOnCompleteListener(getExecutor(), onCompleteListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendPasswordResetEmail$14(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "sendPasswordResetEmail:onComplete:success");
            promiseNoUser(promise, false);
        } else {
            Exception exception = task.getException();
            Log.e(TAG, "sendPasswordResetEmail:onComplete:failure", exception);
            promiseRejectAuthException(promise, exception);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void sendSignInLinkToEmail(String str, String str2, ReadableMap readableMap, final Promise promise) {
        Log.d(TAG, "sendSignInLinkToEmail");
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        firebaseAuth.sendSignInLinkToEmail(str2, buildActionCodeSettings(readableMap)).addOnCompleteListener(getExecutor(), new OnCompleteListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda53
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f$0.lambda$sendSignInLinkToEmail$15(promise, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendSignInLinkToEmail$15(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "sendSignInLinkToEmail:onComplete:success");
            promiseNoUser(promise, false);
        } else {
            Exception exception = task.getException();
            Log.e(TAG, "sendSignInLinkToEmail:onComplete:failure", exception);
            promiseRejectAuthException(promise, exception);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void deleteUser(String str, final Promise promise) {
        FirebaseUser currentUser = FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).getCurrentUser();
        Log.d(TAG, "delete");
        if (currentUser != null) {
            currentUser.delete().addOnCompleteListener(getExecutor(), new OnCompleteListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda20
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    this.f$0.lambda$deleteUser$16(promise, task);
                }
            });
        } else {
            Log.e(TAG, "delete:failure:noCurrentUser");
            promiseNoUser(promise, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteUser$16(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "delete:onComplete:success");
            promiseNoUser(promise, false);
        } else {
            Exception exception = task.getException();
            Log.e(TAG, "delete:onComplete:failure", exception);
            promiseRejectAuthException(promise, exception);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void reload(String str, final Promise promise) {
        final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        Log.d(TAG, "reload");
        if (currentUser == null) {
            promiseNoUser(promise, false);
            Log.e(TAG, "reload:failure:noCurrentUser");
        } else {
            currentUser.reload().addOnCompleteListener(getExecutor(), new OnCompleteListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda46
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    this.f$0.lambda$reload$17(firebaseAuth, promise, task);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reload$17(FirebaseAuth firebaseAuth, Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "reload:onComplete:success");
            promiseWithUser(firebaseAuth.getCurrentUser(), promise);
        } else {
            Exception exception = task.getException();
            Log.e(TAG, "reload:onComplete:failure", exception);
            promiseRejectAuthException(promise, exception);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void sendEmailVerification(String str, ReadableMap readableMap, final Promise promise) {
        final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        Log.d(TAG, "sendEmailVerification");
        if (currentUser == null) {
            promiseNoUser(promise, false);
            Log.e(TAG, "sendEmailVerification:failure:noCurrentUser");
            return;
        }
        OnCompleteListener<Void> onCompleteListener = new OnCompleteListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda32
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f$0.lambda$sendEmailVerification$18(firebaseAuth, promise, task);
            }
        };
        if (readableMap == null) {
            currentUser.sendEmailVerification().addOnCompleteListener(getExecutor(), onCompleteListener);
        } else {
            currentUser.sendEmailVerification(buildActionCodeSettings(readableMap)).addOnCompleteListener(getExecutor(), onCompleteListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendEmailVerification$18(FirebaseAuth firebaseAuth, Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "sendEmailVerification:onComplete:success");
            promiseWithUser(firebaseAuth.getCurrentUser(), promise);
        } else {
            Exception exception = task.getException();
            Log.e(TAG, "sendEmailVerification:onComplete:failure", exception);
            promiseRejectAuthException(promise, exception);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void verifyBeforeUpdateEmail(String str, String str2, ReadableMap readableMap, final Promise promise) {
        final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        Log.d(TAG, "verifyBeforeUpdateEmail");
        if (currentUser == null) {
            promiseNoUser(promise, false);
            Log.e(TAG, "verifyBeforeUpdateEmail:failure:noCurrentUser");
            return;
        }
        OnCompleteListener<Void> onCompleteListener = new OnCompleteListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f$0.lambda$verifyBeforeUpdateEmail$19(firebaseAuth, promise, task);
            }
        };
        if (readableMap == null) {
            currentUser.verifyBeforeUpdateEmail(str2).addOnCompleteListener(getExecutor(), onCompleteListener);
        } else {
            currentUser.verifyBeforeUpdateEmail(str2, buildActionCodeSettings(readableMap)).addOnCompleteListener(getExecutor(), onCompleteListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$verifyBeforeUpdateEmail$19(FirebaseAuth firebaseAuth, Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "verifyBeforeUpdateEmail:onComplete:success");
            promiseWithUser(firebaseAuth.getCurrentUser(), promise);
        } else {
            Exception exception = task.getException();
            Log.e(TAG, "verifyBeforeUpdateEmail:onComplete:failure", exception);
            promiseRejectAuthException(promise, exception);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void updateEmail(String str, String str2, final Promise promise) {
        final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        Log.d(TAG, "updateEmail");
        if (currentUser == null) {
            promiseNoUser(promise, false);
            Log.e(TAG, "updateEmail:failure:noCurrentUser");
        } else {
            currentUser.updateEmail(str2).addOnCompleteListener(getExecutor(), new OnCompleteListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda31
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    this.f$0.lambda$updateEmail$20(firebaseAuth, promise, task);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateEmail$20(FirebaseAuth firebaseAuth, Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "updateEmail:onComplete:success");
            promiseWithUser(firebaseAuth.getCurrentUser(), promise);
        } else {
            Exception exception = task.getException();
            Log.e(TAG, "updateEmail:onComplete:failure", exception);
            promiseRejectAuthException(promise, exception);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void updatePassword(String str, String str2, final Promise promise) {
        final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        Log.d(TAG, "updatePassword");
        if (currentUser == null) {
            promiseNoUser(promise, false);
            Log.e(TAG, "updatePassword:failure:noCurrentUser");
        } else {
            currentUser.updatePassword(str2).addOnCompleteListener(getExecutor(), new OnCompleteListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda4
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    this.f$0.lambda$updatePassword$21(firebaseAuth, promise, task);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updatePassword$21(FirebaseAuth firebaseAuth, Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "updatePassword:onComplete:success");
            promiseWithUser(firebaseAuth.getCurrentUser(), promise);
        } else {
            Exception exception = task.getException();
            Log.e(TAG, "updatePassword:onComplete:failure", exception);
            promiseRejectAuthException(promise, exception);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void updatePhoneNumber(String str, String str2, String str3, String str4, final Promise promise) {
        final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (!str2.equals("phone")) {
            ReactNativeFirebaseModule.rejectPromiseWithCodeAndMessage(promise, "invalid-credential", "The supplied auth credential does not have a phone provider.");
        }
        PhoneAuthCredential phoneAuthCredential = getPhoneAuthCredential(str3, str4);
        if (phoneAuthCredential == null) {
            ReactNativeFirebaseModule.rejectPromiseWithCodeAndMessage(promise, "invalid-credential", "The supplied auth credential is malformed, has expired or is not currently supported.");
        } else if (currentUser != null) {
            Log.d(TAG, "updatePhoneNumber");
            currentUser.updatePhoneNumber(phoneAuthCredential).addOnCompleteListener(getExecutor(), new OnCompleteListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda19
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    this.f$0.lambda$updatePhoneNumber$22(firebaseAuth, promise, task);
                }
            });
        } else {
            promiseNoUser(promise, false);
            Log.e(TAG, "updatePhoneNumber:failure:noCurrentUser");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updatePhoneNumber$22(FirebaseAuth firebaseAuth, Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "updatePhoneNumber:onComplete:success");
            promiseWithUser(firebaseAuth.getCurrentUser(), promise);
        } else {
            Exception exception = task.getException();
            Log.e(TAG, "updatePhoneNumber:onComplete:failure", exception);
            promiseRejectAuthException(promise, exception);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void updateProfile(String str, ReadableMap readableMap, final Promise promise) {
        final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        Log.d(TAG, "updateProfile");
        if (currentUser == null) {
            promiseNoUser(promise, false);
            Log.e(TAG, "updateProfile:failure:noCurrentUser");
            return;
        }
        UserProfileChangeRequest.Builder builder = new UserProfileChangeRequest.Builder();
        if (readableMap.hasKey("displayName")) {
            builder.setDisplayName(readableMap.getString("displayName"));
        }
        if (readableMap.hasKey("photoURL")) {
            String string = readableMap.getString("photoURL");
            builder.setPhotoUri(string == null ? null : Uri.parse(string));
        }
        currentUser.updateProfile(builder.build()).addOnCompleteListener(getExecutor(), new OnCompleteListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda47
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f$0.lambda$updateProfile$23(firebaseAuth, promise, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateProfile$23(FirebaseAuth firebaseAuth, Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "updateProfile:onComplete:success");
            promiseWithUser(firebaseAuth.getCurrentUser(), promise);
        } else {
            Exception exception = task.getException();
            Log.e(TAG, "updateProfile:onComplete:failure", exception);
            promiseRejectAuthException(promise, exception);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void signInWithCredential(String str, String str2, String str3, String str4, @Nullable ReadableMap readableMap, final Promise promise) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        AuthCredential credentialForProvider = getCredentialForProvider(str2, str3, str4);
        if (credentialForProvider == null) {
            ReactNativeFirebaseModule.rejectPromiseWithCodeAndMessage(promise, "invalid-credential", "The supplied auth credential is malformed, has expired or is not currently supported.");
        } else {
            Log.d(TAG, "signInWithCredential");
            firebaseAuth.signInWithCredential(credentialForProvider).addOnCompleteListener(getExecutor(), new OnCompleteListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda25
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    this.f$0.lambda$signInWithCredential$24(promise, task);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$signInWithCredential$24(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "signInWithCredential:onComplete:success");
            promiseWithAuthResult((AuthResult) task.getResult(), promise);
        } else {
            Exception exception = task.getException();
            Log.e(TAG, "signInWithCredential:onComplete:failure", exception);
            promiseRejectAuthException(promise, exception);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void signInWithProvider(String str, ReadableMap readableMap, final Promise promise) {
        ReadableMap map;
        ReadableArray array;
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        if (readableMap.getString("providerId") == null) {
            ReactNativeFirebaseModule.rejectPromiseWithCodeAndMessage(promise, "invalid-credential", "The supplied auth credential is malformed, has expired or is not currently supported.");
            return;
        }
        OAuthProvider.Builder builderNewBuilder = OAuthProvider.newBuilder(readableMap.getString("providerId"), firebaseAuth);
        if (readableMap.hasKey("scopes") && (array = readableMap.getArray("scopes")) != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < array.size(); i++) {
                arrayList.add(array.getString(i));
            }
            builderNewBuilder.setScopes(arrayList);
        }
        if (readableMap.hasKey("customParameters") && (map = readableMap.getMap("customParameters")) != null) {
            ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = map.keySetIterator();
            while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
                builderNewBuilder.addCustomParameter(strNextKey, map.getString(strNextKey));
            }
        }
        Task<AuthResult> pendingAuthResult = firebaseAuth.getPendingAuthResult();
        if (pendingAuthResult != null) {
            pendingAuthResult.addOnSuccessListener(new OnSuccessListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda38
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    this.f$0.lambda$signInWithProvider$25(promise, (AuthResult) obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda39
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    this.f$0.lambda$signInWithProvider$26(promise, exc);
                }
            });
        } else {
            firebaseAuth.startActivityForSignInWithProvider(getCurrentActivity(), builderNewBuilder.build()).addOnSuccessListener(new OnSuccessListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda40
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    this.f$0.lambda$signInWithProvider$27(promise, (AuthResult) obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda41
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    this.f$0.lambda$signInWithProvider$28(promise, exc);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$signInWithProvider$25(Promise promise, AuthResult authResult) {
        Log.d(TAG, "signInWithProvider:success");
        promiseWithAuthResult(authResult, promise);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$signInWithProvider$26(Promise promise, Exception exc) {
        Log.d(TAG, "signInWithProvider:failure", exc);
        promiseRejectAuthException(promise, exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$signInWithProvider$27(Promise promise, AuthResult authResult) {
        Log.d(TAG, "signInWithProvider:success");
        promiseWithAuthResult(authResult, promise);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$signInWithProvider$28(Promise promise, Exception exc) {
        Log.d(TAG, "signInWithProvider:failure", exc);
        promiseRejectAuthException(promise, exc);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void signInWithPhoneNumber(String str, String str2, boolean z, Promise promise) {
        Log.d(TAG, "signInWithPhoneNumber");
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        Activity currentActivity = getCurrentActivity();
        if (!str2.equals(this.mLastPhoneNumber)) {
            this.mForceResendingToken = null;
            this.mLastPhoneNumber = str2;
        }
        this.mVerificationId = null;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(firebaseAuth, promise);
        if (currentActivity != null) {
            if (z && this.mForceResendingToken != null) {
                PhoneAuthProvider.getInstance(firebaseAuth).verifyPhoneNumber(str2, 60L, TimeUnit.SECONDS, currentActivity, anonymousClass1, this.mForceResendingToken);
            } else {
                PhoneAuthProvider.getInstance(firebaseAuth).verifyPhoneNumber(str2, 60L, TimeUnit.SECONDS, currentActivity, anonymousClass1);
            }
        }
    }

    /* JADX INFO: renamed from: io.invertase.firebase.auth.NativeRNFBTurboAuth$1, reason: invalid class name */
    class AnonymousClass1 extends PhoneAuthProvider.OnVerificationStateChangedCallbacks {
        private boolean promiseResolved = false;
        final /* synthetic */ FirebaseAuth val$firebaseAuth;
        final /* synthetic */ Promise val$promise;

        AnonymousClass1(FirebaseAuth firebaseAuth, Promise promise) {
            this.val$firebaseAuth = firebaseAuth;
            this.val$promise = promise;
        }

        @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
        public void onVerificationCompleted(final PhoneAuthCredential phoneAuthCredential) {
            Task<AuthResult> taskSignInWithCredential = this.val$firebaseAuth.signInWithCredential(phoneAuthCredential);
            ExecutorService executor = NativeRNFBTurboAuth.this.getExecutor();
            final Promise promise = this.val$promise;
            taskSignInWithCredential.addOnCompleteListener(executor, new OnCompleteListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$1$$ExternalSyntheticLambda0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    this.f$0.lambda$onVerificationCompleted$0(phoneAuthCredential, promise, task);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onVerificationCompleted$0(PhoneAuthCredential phoneAuthCredential, Promise promise, Task task) {
            if (task.isSuccessful()) {
                Log.d(NativeRNFBTurboAuth.TAG, "signInWithPhoneNumber:autoVerified:signInWithCredential:onComplete:success");
                if (this.promiseResolved) {
                    return;
                }
                WritableMap writableMapCreateMap = Arguments.createMap();
                Parcel parcelObtain = Parcel.obtain();
                phoneAuthCredential.writeToParcel(parcelObtain, 0);
                parcelObtain.setDataPosition(16);
                String string = parcelObtain.readString();
                NativeRNFBTurboAuth.this.mVerificationId = string;
                parcelObtain.recycle();
                writableMapCreateMap.putString("verificationId", string);
                promise.resolve(writableMapCreateMap);
                return;
            }
            Exception exception = task.getException();
            Log.e(NativeRNFBTurboAuth.TAG, "signInWithPhoneNumber:autoVerified:signInWithCredential:onComplete:failure", exception);
            if (this.promiseResolved) {
                return;
            }
            NativeRNFBTurboAuth.this.promiseRejectAuthException(promise, exception);
        }

        @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
        public void onVerificationFailed(FirebaseException firebaseException) {
            Log.d(NativeRNFBTurboAuth.TAG, "signInWithPhoneNumber:verification:failed");
            NativeRNFBTurboAuth.this.promiseRejectAuthException(this.val$promise, firebaseException);
        }

        @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
        public void onCodeSent(String str, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            NativeRNFBTurboAuth.this.mVerificationId = str;
            NativeRNFBTurboAuth.this.mForceResendingToken = forceResendingToken;
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString("verificationId", str);
            this.val$promise.resolve(writableMapCreateMap);
            this.promiseResolved = true;
        }

        @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
        public void onCodeAutoRetrievalTimeOut(String str) {
            super.onCodeAutoRetrievalTimeOut(str);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void getSession(String str, final Promise promise) {
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).getCurrentUser().getMultiFactor().getSession().addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda18
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f$0.lambda$getSession$29(promise, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getSession$29(Promise promise, Task task) {
        if (!task.isSuccessful()) {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
            return;
        }
        MultiFactorSession multiFactorSession = (MultiFactorSession) task.getResult();
        String string = Integer.toString(multiFactorSession.hashCode());
        this.mMultiFactorSessions.putReplacing(string, multiFactorSession);
        promise.resolve(string);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void unenrollMultiFactor(String str, String str2, final Promise promise) {
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).getCurrentUser().getMultiFactor().unenroll(str2).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda24
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                NativeRNFBTurboAuth.lambda$unenrollMultiFactor$30(promise, task);
            }
        });
    }

    static /* synthetic */ void lambda$unenrollMultiFactor$30(Promise promise, Task task) {
        if (!task.isSuccessful()) {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        } else {
            promise.resolve(null);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void verifyPhoneNumberWithMultiFactorInfo(String str, String str2, final String str3, final Promise promise) {
        MultiFactorInfo next;
        MultiFactorResolver multiFactorResolver = this.mCachedResolvers.get(str3);
        if (multiFactorResolver == null) {
            ReactNativeFirebaseModule.rejectPromiseWithCodeAndMessage(promise, "invalid-multi-factor-session", "No resolver for session found. Is the session id correct?");
            return;
        }
        Iterator<MultiFactorInfo> it = multiFactorResolver.getHints().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!str2.equals(next.getUid()));
        if (next == null) {
            ReactNativeFirebaseModule.rejectPromiseWithCodeAndMessage(promise, "multi-factor-info-not-found", "The user does not have a second factor matching the identifier provided.");
        } else {
            if (!"phone".equals(next.getFactorId())) {
                ReactNativeFirebaseModule.rejectPromiseWithCodeAndMessage(promise, "unknown", "Unsupported second factor. Only phone factors are supported.");
                return;
            }
            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
            PhoneAuthProvider.verifyPhoneNumber(PhoneAuthOptions.newBuilder(firebaseAuth).setActivity(getCurrentActivity()).setMultiFactorHint((PhoneMultiFactorInfo) next).setTimeout(30L, TimeUnit.SECONDS).setMultiFactorSession(multiFactorResolver.getSession()).setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth.2
                @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
                public void onCodeSent(String str4, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                    promise.resolve(str4);
                }

                @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
                public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                    NativeRNFBTurboAuth.this.resolveMultiFactorCredential(phoneAuthCredential, str3, promise);
                }

                @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
                public void onVerificationFailed(FirebaseException firebaseException) {
                    NativeRNFBTurboAuth.this.promiseRejectAuthException(promise, firebaseException);
                }
            }).build());
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void verifyPhoneNumberForMultiFactor(String str, String str2, String str3, final Promise promise) {
        MultiFactorSession multiFactorSession = this.mMultiFactorSessions.get(str3);
        if (multiFactorSession == null) {
            ReactNativeFirebaseModule.rejectPromiseWithCodeAndMessage(promise, "invalid-multi-factor-session", "can't find session for provided key");
        } else {
            PhoneAuthProvider.verifyPhoneNumber(PhoneAuthOptions.newBuilder(FirebaseAuth.getInstance(FirebaseApp.getInstance(str))).setPhoneNumber(str2).setActivity(getCurrentActivity()).setTimeout(30L, TimeUnit.SECONDS).setMultiFactorSession(multiFactorSession).requireSmsValidation(true).setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth.3
                @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
                public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                    ReactNativeFirebaseModule.rejectPromiseWithCodeAndMessage(promise, "not-implemented", "This is currently not supported.");
                }

                @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
                public void onVerificationFailed(FirebaseException firebaseException) {
                    NativeRNFBTurboAuth.this.promiseRejectAuthException(promise, firebaseException);
                }

                @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
                public void onCodeSent(String str4, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                    promise.resolve(str4);
                }
            }).build());
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void finalizeMultiFactorEnrollment(String str, String str2, String str3, @Nullable String str4, final Promise promise) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        firebaseAuth.getCurrentUser().getMultiFactor().enroll(PhoneMultiFactorGenerator.getAssertion(PhoneAuthProvider.getCredential(str2, str3)), str4).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda37
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f$0.lambda$finalizeMultiFactorEnrollment$31(promise, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$finalizeMultiFactorEnrollment$31(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "finalizeMultiFactorEnrollment:onComplete:success");
            promise.resolve(null);
        } else {
            Exception exception = task.getException();
            Log.e(TAG, "finalizeMultiFactorEnrollment:onComplete:failure", exception);
            promiseRejectAuthException(promise, exception);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public String generateQrCodeUrl(String str, String str2, String str3, String str4) {
        TotpSecret totpSecret = this.mTotpSecrets.get(str2);
        if (totpSecret == null) {
            throw new ReactNativeFirebaseAuthSyncException("invalid-multi-factor-secret", "can't find secret for provided key");
        }
        return totpSecret.generateQrCodeUrl(str3, str4);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void openInOtpApp(String str, String str2, String str3) {
        TotpSecret totpSecret = this.mTotpSecrets.get(str2);
        if (totpSecret != null) {
            totpSecret.openInOtpApp(str3);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void finalizeTotpEnrollment(String str, String str2, String str3, @Nullable String str4, final Promise promise) {
        TotpSecret totpSecret = this.mTotpSecrets.get(str2);
        if (totpSecret == null) {
            ReactNativeFirebaseModule.rejectPromiseWithCodeAndMessage(promise, "invalid-multi-factor-secret", "can't find secret for provided key");
        } else {
            FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).getCurrentUser().getMultiFactor().enroll(TotpMultiFactorGenerator.getAssertionForEnrollment(totpSecret, str3), str4).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda36
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    NativeRNFBTurboAuth.lambda$finalizeTotpEnrollment$32(promise, task);
                }
            });
        }
    }

    static /* synthetic */ void lambda$finalizeTotpEnrollment$32(Promise promise, Task task) {
        if (!task.isSuccessful()) {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        } else {
            promise.resolve(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resolveMultiFactorCredential(PhoneAuthCredential phoneAuthCredential, String str, final Promise promise) {
        PhoneMultiFactorAssertion assertion = PhoneMultiFactorGenerator.getAssertion(phoneAuthCredential);
        MultiFactorResolver multiFactorResolver = this.mCachedResolvers.get(str);
        if (multiFactorResolver == null) {
            ReactNativeFirebaseModule.rejectPromiseWithCodeAndMessage(promise, "invalid-multi-factor-session", "No resolver for session found. Is the session id correct?");
        } else {
            multiFactorResolver.resolveSignIn(assertion).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda27
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    this.f$0.lambda$resolveMultiFactorCredential$33(promise, task);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resolveMultiFactorCredential$33(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promiseWithAuthResult((AuthResult) task.getResult(), promise);
        } else {
            promiseRejectAuthException(promise, task.getException());
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void resolveMultiFactorSignIn(String str, String str2, String str3, String str4, Promise promise) {
        resolveMultiFactorCredential(PhoneAuthProvider.getCredential(str3, str4), str2, promise);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void resolveTotpSignIn(String str, String str2, String str3, String str4, final Promise promise) {
        TotpMultiFactorAssertion assertionForSignIn = TotpMultiFactorGenerator.getAssertionForSignIn(str3, str4);
        MultiFactorResolver multiFactorResolver = this.mCachedResolvers.get(str2);
        if (multiFactorResolver == null) {
            ReactNativeFirebaseModule.rejectPromiseWithCodeAndMessage(promise, "invalid-multi-factor-session", "No resolver for session found. Is the session id correct?");
        } else {
            multiFactorResolver.resolveSignIn(assertionForSignIn).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda33
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    this.f$0.lambda$resolveTotpSignIn$34(promise, task);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resolveTotpSignIn$34(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promiseWithAuthResult((AuthResult) task.getResult(), promise);
        } else {
            promiseRejectAuthException(promise, task.getException());
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void generateTotpSecret(String str, String str2, final Promise promise) {
        MultiFactorSession multiFactorSession = this.mMultiFactorSessions.get(str2);
        if (multiFactorSession == null) {
            ReactNativeFirebaseModule.rejectPromiseWithCodeAndMessage(promise, "invalid-multi-factor-session", "No resolver for session found. Is the session id correct?");
        } else {
            TotpMultiFactorGenerator.generateSecret(multiFactorSession).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda30
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    this.f$0.lambda$generateTotpSecret$35(promise, task);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$generateTotpSecret$35(Promise promise, Task task) {
        if (task.isSuccessful()) {
            TotpSecret totpSecret = (TotpSecret) task.getResult();
            String sharedSecretKey = totpSecret.getSharedSecretKey();
            this.mTotpSecrets.putReplacing(sharedSecretKey, totpSecret);
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString("secretKey", sharedSecretKey);
            promise.resolve(writableMapCreateMap);
            return;
        }
        promiseRejectAuthException(promise, task.getException());
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void confirmationResultConfirm(String str, String str2, final Promise promise) {
        try {
            FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).signInWithCredential(PhoneAuthProvider.getCredential(this.mVerificationId, str2)).addOnCompleteListener(getExecutor(), new OnCompleteListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda42
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    this.f$0.lambda$confirmationResultConfirm$36(promise, task);
                }
            });
        } catch (Exception e) {
            Log.d(TAG, "confirmationResultConfirm::getCredential::failure", e);
            promiseRejectAuthException(promise, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$confirmationResultConfirm$36(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "confirmationResultConfirm:signInWithCredential:onComplete:success");
            promiseWithAuthResult((AuthResult) Objects.requireNonNull((AuthResult) task.getResult()), promise);
        } else {
            Exception exception = task.getException();
            Log.e(TAG, "confirmationResultConfirm:signInWithCredential:onComplete:failure", exception);
            promiseRejectAuthException(promise, exception);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void verifyPhoneNumber(final String str, String str2, final String str3, double d, boolean z) {
        Log.d(TAG, "verifyPhoneNumber:" + str2);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        Activity currentActivity = getCurrentActivity();
        if (!str2.equals(this.mLastPhoneNumber)) {
            this.mForceResendingToken = null;
            this.mLastPhoneNumber = str2;
        }
        this.mCredential = null;
        PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth.4
            @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                NativeRNFBTurboAuth.this.mCredential = phoneAuthCredential;
                Log.d(NativeRNFBTurboAuth.TAG, "verifyPhoneNumber:verification:onVerificationCompleted");
                WritableMap writableMapCreateMap = Arguments.createMap();
                Parcel parcelObtain = Parcel.obtain();
                phoneAuthCredential.writeToParcel(parcelObtain, 0);
                parcelObtain.setDataPosition(16);
                String string = parcelObtain.readString();
                parcelObtain.setDataPosition(parcelObtain.dataPosition() + 8);
                writableMapCreateMap.putString("code", parcelObtain.readString());
                writableMapCreateMap.putString("verificationId", string);
                parcelObtain.recycle();
                NativeRNFBTurboAuth.this.sendPhoneStateEvent(str, str3, "onVerificationComplete", writableMapCreateMap);
            }

            @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
            public void onVerificationFailed(FirebaseException firebaseException) {
                Log.d(NativeRNFBTurboAuth.TAG, "verifyPhoneNumber:verification:onVerificationFailed");
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putMap("error", NativeRNFBTurboAuth.this.getJSError(firebaseException));
                NativeRNFBTurboAuth.this.sendPhoneStateEvent(str, str3, "onVerificationFailed", writableMapCreateMap);
            }

            @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
            public void onCodeSent(String str4, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                Log.d(NativeRNFBTurboAuth.TAG, "verifyPhoneNumber:verification:onCodeSent");
                NativeRNFBTurboAuth.this.mForceResendingToken = forceResendingToken;
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putString("verificationId", str4);
                writableMapCreateMap.putString("verificationId", str4);
                NativeRNFBTurboAuth.this.sendPhoneStateEvent(str, str3, "onCodeSent", writableMapCreateMap);
            }

            @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
            public void onCodeAutoRetrievalTimeOut(String str4) {
                super.onCodeAutoRetrievalTimeOut(str4);
                Log.d(NativeRNFBTurboAuth.TAG, "verifyPhoneNumber:verification:onCodeAutoRetrievalTimeOut");
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putString("verificationId", str4);
                NativeRNFBTurboAuth.this.sendPhoneStateEvent(str, str3, "onCodeAutoRetrievalTimeout", writableMapCreateMap);
            }
        };
        if (currentActivity != null) {
            if (z && this.mForceResendingToken != null) {
                PhoneAuthProvider.getInstance(firebaseAuth).verifyPhoneNumber(str2, (long) d, TimeUnit.SECONDS, currentActivity, onVerificationStateChangedCallbacks, this.mForceResendingToken);
            } else {
                PhoneAuthProvider.getInstance(firebaseAuth).verifyPhoneNumber(str2, (long) d, TimeUnit.SECONDS, currentActivity, onVerificationStateChangedCallbacks);
            }
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void confirmPasswordReset(String str, String str2, String str3, final Promise promise) {
        Log.d(TAG, "confirmPasswordReset");
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).confirmPasswordReset(str2, str3).addOnCompleteListener(getExecutor(), new OnCompleteListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda29
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f$0.lambda$confirmPasswordReset$37(promise, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$confirmPasswordReset$37(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "confirmPasswordReset:onComplete:success");
            promiseNoUser(promise, false);
        } else {
            Exception exception = task.getException();
            Log.e(TAG, "confirmPasswordReset:onComplete:failure", exception);
            promiseRejectAuthException(promise, exception);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void applyActionCode(String str, String str2, final Promise promise) {
        Log.d(TAG, "applyActionCode");
        final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        firebaseAuth.applyActionCode(str2).addOnCompleteListener(getExecutor(), new OnCompleteListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda21
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f$0.lambda$applyActionCode$38(firebaseAuth, promise, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$applyActionCode$38(FirebaseAuth firebaseAuth, Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "applyActionCode:onComplete:success");
            promiseWithUser(firebaseAuth.getCurrentUser(), promise);
        } else {
            Exception exception = task.getException();
            Log.e(TAG, "applyActionCode:onComplete:failure", exception);
            promiseRejectAuthException(promise, exception);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void checkActionCode(String str, String str2, final Promise promise) {
        Log.d(TAG, "checkActionCode");
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).checkActionCode(str2).addOnCompleteListener(getExecutor(), new OnCompleteListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda35
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f$0.lambda$checkActionCode$39(promise, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkActionCode$39(Promise promise, Task task) {
        String str;
        if (task.isSuccessful()) {
            Log.d(TAG, "checkActionCode:onComplete:success");
            ActionCodeResult actionCodeResult = (ActionCodeResult) Objects.requireNonNull((ActionCodeResult) task.getResult());
            WritableMap writableMapCreateMap = Arguments.createMap();
            WritableMap writableMapCreateMap2 = Arguments.createMap();
            writableMapCreateMap2.putString("email", actionCodeResult.getData(0));
            writableMapCreateMap2.putString("fromEmail", actionCodeResult.getData(1));
            writableMapCreateMap.putMap("data", writableMapCreateMap2);
            int operation = actionCodeResult.getOperation();
            if (operation == 0) {
                str = "PASSWORD_RESET";
            } else if (operation == 1) {
                str = "VERIFY_EMAIL";
            } else if (operation == 2) {
                str = "RECOVER_EMAIL";
            } else if (operation == 3) {
                str = MediaError.ERROR_TYPE_ERROR;
            } else {
                str = operation != 4 ? "UNKNOWN" : "EMAIL_SIGNIN";
            }
            writableMapCreateMap.putString("operation", str);
            promise.resolve(writableMapCreateMap);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "checkActionCode:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void linkWithCredential(String str, String str2, String str3, String str4, final Promise promise) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        AuthCredential credentialForProvider = getCredentialForProvider(str2, str3, str4);
        if (credentialForProvider == null) {
            ReactNativeFirebaseModule.rejectPromiseWithCodeAndMessage(promise, "invalid-credential", "The supplied auth credential is malformed, has expired or is not currently supported.");
            return;
        }
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        Log.d(TAG, "link");
        if (currentUser != null) {
            currentUser.linkWithCredential(credentialForProvider).addOnCompleteListener(getExecutor(), new OnCompleteListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda28
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    this.f$0.lambda$linkWithCredential$40(promise, task);
                }
            });
        } else {
            promiseNoUser(promise, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$linkWithCredential$40(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "link:onComplete:success");
            promiseWithAuthResult((AuthResult) task.getResult(), promise);
            return;
        }
        Exception exception = task.getException();
        if (exception instanceof FirebaseAuthUserCollisionException) {
            FirebaseAuthUserCollisionException firebaseAuthUserCollisionException = (FirebaseAuthUserCollisionException) exception;
            AuthCredential updatedCredential = firebaseAuthUserCollisionException.getUpdatedCredential();
            Log.d(TAG, "link:onComplete:collisionFailure", firebaseAuthUserCollisionException);
            if (updatedCredential != null) {
                Log.d(TAG, "link:onComplete:collisionFailure had credential", firebaseAuthUserCollisionException);
                promiseRejectLinkAuthException(promise, firebaseAuthUserCollisionException, updatedCredential);
                return;
            }
        }
        Log.e(TAG, "link:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void linkWithProvider(String str, ReadableMap readableMap, final Promise promise) {
        ReadableMap map;
        ReadableArray array;
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        if (readableMap.getString("providerId") == null) {
            ReactNativeFirebaseModule.rejectPromiseWithCodeAndMessage(promise, "invalid-credential", "The supplied auth credential is malformed, has expired or is not currently supported.");
            return;
        }
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        Log.d(TAG, "linkWithProvider");
        if (currentUser == null) {
            promiseNoUser(promise, true);
            return;
        }
        OAuthProvider.Builder builderNewBuilder = OAuthProvider.newBuilder(readableMap.getString("providerId"), firebaseAuth);
        if (readableMap.hasKey("scopes") && (array = readableMap.getArray("scopes")) != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < array.size(); i++) {
                arrayList.add(array.getString(i));
            }
            builderNewBuilder.setScopes(arrayList);
        }
        if (readableMap.hasKey("customParameters") && (map = readableMap.getMap("customParameters")) != null) {
            ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = map.keySetIterator();
            while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
                builderNewBuilder.addCustomParameter(strNextKey, map.getString(strNextKey));
            }
        }
        Task<AuthResult> pendingAuthResult = firebaseAuth.getPendingAuthResult();
        if (pendingAuthResult != null) {
            pendingAuthResult.addOnSuccessListener(new OnSuccessListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda13
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    this.f$0.lambda$linkWithProvider$41(promise, (AuthResult) obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda14
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    this.f$0.lambda$linkWithProvider$42(promise, exc);
                }
            });
        } else {
            currentUser.startActivityForLinkWithProvider(getCurrentActivity(), builderNewBuilder.build()).addOnSuccessListener(new OnSuccessListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda15
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    this.f$0.lambda$linkWithProvider$43(promise, (AuthResult) obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda16
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    this.f$0.lambda$linkWithProvider$44(promise, exc);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$linkWithProvider$41(Promise promise, AuthResult authResult) {
        Log.d(TAG, "linkWithProvider:success");
        promiseWithAuthResult(authResult, promise);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$linkWithProvider$42(Promise promise, Exception exc) {
        Log.d(TAG, "linkWithProvider:failure", exc);
        promiseRejectAuthException(promise, exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$linkWithProvider$43(Promise promise, AuthResult authResult) {
        Log.d(TAG, "linkWithProvider:success");
        promiseWithAuthResult(authResult, promise);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$linkWithProvider$44(Promise promise, Exception exc) {
        Log.d(TAG, "linkWithProvider:failure", exc);
        promiseRejectAuthException(promise, exc);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void unlink(String str, String str2, final Promise promise) {
        FirebaseUser currentUser = FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).getCurrentUser();
        Log.d(TAG, "unlink");
        if (currentUser != null) {
            currentUser.unlink(str2).addOnCompleteListener(getExecutor(), new OnCompleteListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda26
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    this.f$0.lambda$unlink$45(promise, task);
                }
            });
        } else {
            promiseNoUser(promise, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$unlink$45(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "unlink:onComplete:success");
            promiseWithUser(((AuthResult) Objects.requireNonNull((AuthResult) task.getResult())).getUser(), promise);
        } else {
            Exception exception = task.getException();
            Log.e(TAG, "unlink:onComplete:failure", exception);
            promiseRejectAuthException(promise, exception);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void reauthenticateWithCredential(String str, String str2, String str3, String str4, final Promise promise) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        AuthCredential credentialForProvider = getCredentialForProvider(str2, str3, str4);
        if (credentialForProvider == null) {
            ReactNativeFirebaseModule.rejectPromiseWithCodeAndMessage(promise, "invalid-credential", "The supplied auth credential is malformed, has expired or is not currently supported.");
            return;
        }
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        Log.d(TAG, "reauthenticate");
        if (currentUser != null) {
            currentUser.reauthenticateAndRetrieveData(credentialForProvider).addOnCompleteListener(getExecutor(), new OnCompleteListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda17
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    this.f$0.lambda$reauthenticateWithCredential$46(promise, task);
                }
            });
        } else {
            promiseNoUser(promise, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reauthenticateWithCredential$46(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "reauthenticate:onComplete:success");
            promiseWithAuthResult((AuthResult) task.getResult(), promise);
        } else {
            Exception exception = task.getException();
            Log.e(TAG, "reauthenticate:onComplete:failure", exception);
            promiseRejectAuthException(promise, exception);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void reauthenticateWithProvider(String str, ReadableMap readableMap, final Promise promise) {
        ReadableMap map;
        ReadableArray array;
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        if (readableMap.getString("providerId") == null) {
            ReactNativeFirebaseModule.rejectPromiseWithCodeAndMessage(promise, "invalid-credential", "The supplied auth credential is malformed, has expired or is not currently supported.");
            return;
        }
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        Log.d(TAG, "reauthenticateWithProvider");
        if (currentUser == null) {
            promiseNoUser(promise, true);
            return;
        }
        OAuthProvider.Builder builderNewBuilder = OAuthProvider.newBuilder(readableMap.getString("providerId"), firebaseAuth);
        if (readableMap.hasKey("scopes") && (array = readableMap.getArray("scopes")) != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < array.size(); i++) {
                arrayList.add(array.getString(i));
            }
            builderNewBuilder.setScopes(arrayList);
        }
        if (readableMap.hasKey("customParameters") && (map = readableMap.getMap("customParameters")) != null) {
            ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = map.keySetIterator();
            while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
                builderNewBuilder.addCustomParameter(strNextKey, map.getString(strNextKey));
            }
        }
        Task<AuthResult> pendingAuthResult = firebaseAuth.getPendingAuthResult();
        if (pendingAuthResult != null) {
            pendingAuthResult.addOnSuccessListener(new OnSuccessListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda44
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    this.f$0.lambda$reauthenticateWithProvider$47(promise, (AuthResult) obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda50
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    this.f$0.lambda$reauthenticateWithProvider$48(promise, exc);
                }
            });
        } else {
            currentUser.startActivityForReauthenticateWithProvider(getCurrentActivity(), builderNewBuilder.build()).addOnSuccessListener(new OnSuccessListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda51
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    this.f$0.lambda$reauthenticateWithProvider$49(promise, (AuthResult) obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda52
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    this.f$0.lambda$reauthenticateWithProvider$50(promise, exc);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reauthenticateWithProvider$47(Promise promise, AuthResult authResult) {
        Log.d(TAG, "reauthenticateWithProvider:success");
        promiseWithAuthResult(authResult, promise);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reauthenticateWithProvider$48(Promise promise, Exception exc) {
        Log.d(TAG, "reauthenticateWithProvider:failure", exc);
        promiseRejectAuthException(promise, exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reauthenticateWithProvider$49(Promise promise, AuthResult authResult) {
        Log.d(TAG, "reauthenticateWithProvider:success");
        promiseWithAuthResult(authResult, promise);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reauthenticateWithProvider$50(Promise promise, Exception exc) {
        Log.d(TAG, "reauthenticateWithProvider:failure", exc);
        promiseRejectAuthException(promise, exc);
    }

    private AuthCredential getCredentialForProvider(String str, String str2, String str3) {
        if (str.startsWith("oidc.")) {
            return OAuthProvider.newCredentialBuilder(str).setIdToken(str2).build();
        }
        AuthCredential authCredential = this.credentials.get(str2);
        if (authCredential != null) {
            return authCredential;
        }
        str.hashCode();
        switch (str) {
            case "apple.com":
                return OAuthProvider.newCredentialBuilder(str).setIdTokenWithRawNonce(str2, str3).build();
            case "twitter.com":
                return TwitterAuthProvider.getCredential(str2, str3);
            case "google.com":
                if (str2 == null || str2.isEmpty()) {
                    str2 = null;
                }
                if (str3 == null || str3.isEmpty()) {
                    str3 = null;
                }
                return GoogleAuthProvider.getCredential(str2, str3);
            case "facebook.com":
                return FacebookAuthProvider.getCredential(str2);
            case "oauth":
                if (str2 == null || str2.isEmpty()) {
                    return OAuthProvider.newCredentialBuilder(str).setAccessToken(str3).build();
                }
                if (str3 == null || str3.isEmpty()) {
                    return OAuthProvider.newCredentialBuilder(str).setIdToken(str2).build();
                }
                return OAuthProvider.getCredential(str, str2, str3);
            case "phone":
                return getPhoneAuthCredential(str2, str3);
            case "password":
                return EmailAuthProvider.getCredential(str2, str3);
            case "github.com":
                return GithubAuthProvider.getCredential(str2);
            case "emailLink":
                return EmailAuthProvider.getCredentialWithLink(str2, str3);
            default:
                return null;
        }
    }

    private PhoneAuthCredential getPhoneAuthCredential(String str, String str2) {
        PhoneAuthCredential phoneAuthCredential;
        if (str == null && (phoneAuthCredential = this.mCredential) != null) {
            this.mCredential = null;
            return phoneAuthCredential;
        }
        if (str != null) {
            return PhoneAuthProvider.getCredential(str, str2);
        }
        return null;
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void getIdToken(String str, boolean z, final Promise promise) {
        Log.d(TAG, "getIdToken");
        FirebaseUser currentUser = FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).getCurrentUser();
        if (currentUser == null) {
            promiseNoUser(promise, true);
        } else {
            currentUser.getIdToken(z).addOnCompleteListener(getExecutor(), new OnCompleteListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda54
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    this.f$0.lambda$getIdToken$51(promise, task);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getIdToken$51(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "getIdToken:onComplete:success");
            promise.resolve(((GetTokenResult) Objects.requireNonNull((GetTokenResult) task.getResult())).getToken());
        } else {
            Exception exception = task.getException();
            Log.e(TAG, "getIdToken:onComplete:failure", exception);
            promiseRejectAuthException(promise, exception);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void getIdTokenResult(String str, boolean z, final Promise promise) {
        Log.d(TAG, "getIdTokenResult");
        FirebaseUser currentUser = FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).getCurrentUser();
        if (currentUser == null) {
            promiseNoUser(promise, true);
        } else {
            currentUser.getIdToken(z).addOnCompleteListener(getExecutor(), new OnCompleteListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda9
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    this.f$0.lambda$getIdTokenResult$52(promise, task);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getIdTokenResult$52(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "getIdTokenResult:onComplete:success");
            GetTokenResult getTokenResult = (GetTokenResult) task.getResult();
            WritableMap writableMapCreateMap = Arguments.createMap();
            SharedUtils.mapPutValue("authTime", SharedUtils.timestampToUTC(((GetTokenResult) Objects.requireNonNull(getTokenResult)).getAuthTimestamp()), writableMapCreateMap);
            SharedUtils.mapPutValue("expirationTime", SharedUtils.timestampToUTC(getTokenResult.getExpirationTimestamp()), writableMapCreateMap);
            SharedUtils.mapPutValue("issuedAtTime", SharedUtils.timestampToUTC(getTokenResult.getIssuedAtTimestamp()), writableMapCreateMap);
            SharedUtils.mapPutValue("claims", getTokenResult.getClaims(), writableMapCreateMap);
            SharedUtils.mapPutValue("signInProvider", getTokenResult.getSignInProvider(), writableMapCreateMap);
            SharedUtils.mapPutValue("token", getTokenResult.getToken(), writableMapCreateMap);
            promise.resolve(writableMapCreateMap);
            return;
        }
        Exception exception = task.getException();
        Log.e(TAG, "getIdTokenResult:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void fetchSignInMethodsForEmail(String str, String str2, final Promise promise) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        Log.d(TAG, "fetchProvidersForEmail");
        firebaseAuth.fetchSignInMethodsForEmail(str2).addOnCompleteListener(getExecutor(), new OnCompleteListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda34
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f$0.lambda$fetchSignInMethodsForEmail$53(promise, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchSignInMethodsForEmail$53(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "fetchProvidersForEmail:onComplete:success");
            List<String> signInMethods = ((SignInMethodQueryResult) Objects.requireNonNull((SignInMethodQueryResult) task.getResult())).getSignInMethods();
            WritableArray writableArrayCreateArray = Arguments.createArray();
            if (signInMethods != null) {
                Iterator<String> it = signInMethods.iterator();
                while (it.hasNext()) {
                    writableArrayCreateArray.pushString(it.next());
                }
            }
            promise.resolve(writableArrayCreateArray);
            return;
        }
        Exception exception = task.getException();
        Log.d(TAG, "fetchProvidersForEmail:onComplete:failure", exception);
        promiseRejectAuthException(promise, exception);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void setLanguageCode(String str, String str2) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(FirebaseApp.getInstance(str));
        if (str2 == null) {
            firebaseAuth.useAppLanguage();
        } else {
            firebaseAuth.setLanguageCode(str2);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void setTenantId(String str, String str2, Promise promise) {
        try {
            FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).setTenantId(str2);
            promise.resolve(null);
        } catch (Exception e) {
            promiseRejectAuthException(promise, e);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void useDeviceLanguage(String str) {
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).useAppLanguage();
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void verifyPasswordResetCode(String str, String str2, final Promise promise) {
        Log.d(TAG, "verifyPasswordResetCode");
        FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).verifyPasswordResetCode(str2).addOnCompleteListener(getExecutor(), new OnCompleteListener() { // from class: io.invertase.firebase.auth.NativeRNFBTurboAuth$$ExternalSyntheticLambda22
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f$0.lambda$verifyPasswordResetCode$54(promise, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$verifyPasswordResetCode$54(Promise promise, Task task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "verifyPasswordResetCode:onComplete:success");
            promise.resolve(task.getResult());
        } else {
            Exception exception = task.getException();
            Log.e(TAG, "verifyPasswordResetCode:onComplete:failure", exception);
            promiseRejectAuthException(promise, exception);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    public void useEmulator(String str, String str2, double d) {
        if (emulatorConfigs.get(str) == null) {
            emulatorConfigs.put(str, "true");
            FirebaseAuth.getInstance(FirebaseApp.getInstance(str)).useEmulator(str2, (int) d);
        }
    }

    private void promiseNoUser(Promise promise, Boolean bool) {
        if (bool.booleanValue()) {
            ReactNativeFirebaseModule.rejectPromiseWithCodeAndMessage(promise, "no-current-user", "No user currently signed in.");
        } else {
            promise.resolve(null);
        }
    }

    private void promiseWithUser(@Nullable FirebaseUser firebaseUser, Promise promise) {
        if (firebaseUser != null) {
            promise.resolve(firebaseUserToMap(firebaseUser));
        } else {
            promiseNoUser(promise, true);
        }
    }

    private void promiseWithAuthResult(AuthResult authResult, Promise promise) {
        if (authResult != null && authResult.getUser() != null) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            WritableMap writableMapFirebaseUserToMap = firebaseUserToMap(authResult.getUser());
            if (authResult.getAdditionalUserInfo() != null) {
                WritableMap writableMapCreateMap2 = Arguments.createMap();
                writableMapCreateMap2.putBoolean("isNewUser", authResult.getAdditionalUserInfo().isNewUser());
                if (authResult.getAdditionalUserInfo().getProfile() != null) {
                    SharedUtils.mapPutValue(Scopes.PROFILE, authResult.getAdditionalUserInfo().getProfile(), writableMapCreateMap2);
                }
                if (authResult.getAdditionalUserInfo().getProviderId() != null) {
                    writableMapCreateMap2.putString("providerId", authResult.getAdditionalUserInfo().getProviderId());
                }
                if (authResult.getAdditionalUserInfo().getUsername() != null) {
                    writableMapCreateMap2.putString(HintConstants.AUTOFILL_HINT_USERNAME, authResult.getAdditionalUserInfo().getUsername());
                }
                writableMapCreateMap.putMap("additionalUserInfo", writableMapCreateMap2);
            }
            writableMapCreateMap.putMap("user", writableMapFirebaseUserToMap);
            promise.resolve(writableMapCreateMap);
            return;
        }
        promiseNoUser(promise, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void promiseRejectAuthException(Promise promise, Exception exc) {
        WritableMap jSError = getJSError(exc);
        String string = jSError.hasKey(RumSessionScope.RUM_SESSION_ID_BUS_MESSAGE_KEY) ? jSError.getString(RumSessionScope.RUM_SESSION_ID_BUS_MESSAGE_KEY) : null;
        MultiFactorResolver multiFactorResolver = this.mCachedResolvers.get(string);
        WritableMap writableMapCreateMap = Arguments.createMap();
        if (multiFactorResolver != null) {
            writableMapCreateMap = resolverToMap(string, multiFactorResolver);
        }
        ReactNativeFirebaseModule.rejectPromiseWithCodeAndMessage(promise, jSError.getString("code"), jSError.getString("message"), writableMapCreateMap);
    }

    private void promiseRejectLinkAuthException(Promise promise, Exception exc, AuthCredential authCredential) {
        WritableMap jSError = getJSError(exc);
        String strValueOf = String.valueOf(authCredential.hashCode());
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("providerId", authCredential.getProvider());
        writableMapCreateMap.putString("token", strValueOf);
        writableMapCreateMap.putString("secret", null);
        this.credentials.putReplacing(strValueOf, authCredential);
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        writableMapCreateMap2.putString("code", jSError.getString("code"));
        writableMapCreateMap2.putString("message", jSError.getString("message"));
        writableMapCreateMap2.putMap("authCredential", writableMapCreateMap);
        promise.reject(jSError.getString("code"), jSError.getString("message"), writableMapCreateMap2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:114:0x018b  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public WritableMap getJSError(Exception exc) {
        String strTrim;
        byte b;
        String str = "INVALID_EMAIL";
        WritableMap writableMapCreateMap = Arguments.createMap();
        String message = exc.getMessage();
        String str2 = "The email address is badly formatted.";
        try {
            FirebaseAuthException firebaseAuthException = (FirebaseAuthException) exc;
            strTrim = firebaseAuthException.getErrorCode();
            try {
                writableMapCreateMap.putString("nativeErrorCode", strTrim);
                message = firebaseAuthException.getMessage();
            } catch (Exception unused) {
                Matcher matcher = Pattern.compile("([A-Z]*_[A-Z]*)").matcher(message);
                if (matcher.find()) {
                    strTrim = matcher.group(1).trim();
                    strTrim.hashCode();
                    switch (strTrim.hashCode()) {
                        case -2127468245:
                            b = !strTrim.equals("USER_TOKEN_EXPIRED") ? (byte) -1 : (byte) 0;
                            break;
                        case -1971163201:
                            b = !strTrim.equals("INVALID_CREDENTIAL") ? (byte) -1 : (byte) 1;
                            break;
                        case -1112393964:
                            b = !strTrim.equals("INVALID_EMAIL") ? (byte) -1 : (byte) 2;
                            break;
                        case -1035666916:
                            b = !strTrim.equals("CREDENTIAL_ALREADY_IN_USE") ? (byte) -1 : (byte) 3;
                            break;
                        case -333672188:
                            b = !strTrim.equals("OPERATION_NOT_ALLOWED") ? (byte) -1 : (byte) 4;
                            break;
                        case -324930558:
                            b = !strTrim.equals("CUSTOM_TOKEN_MISMATCH") ? (byte) -1 : (byte) 5;
                            break;
                        case -311841705:
                            b = !strTrim.equals("EMAIL_ALREADY_IN_USE") ? (byte) -1 : (byte) 6;
                            break;
                        case -75433118:
                            b = !strTrim.equals("USER_NOT_FOUND") ? (byte) -1 : (byte) 7;
                            break;
                        case -49749054:
                            b = !strTrim.equals("USER_MISMATCH") ? (byte) -1 : (byte) 8;
                            break;
                        case -40686718:
                            b = !strTrim.equals("WEAK_PASSWORD") ? (byte) -1 : (byte) 9;
                            break;
                        case 583750925:
                            b = !strTrim.equals("WRONG_PASSWORD") ? (byte) -1 : (byte) 10;
                            break;
                        case 748182870:
                            b = !strTrim.equals("REQUIRES_RECENT_LOGIN") ? (byte) -1 : Ascii.VT;
                            break;
                        case 864281573:
                            b = !strTrim.equals("ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL") ? (byte) -1 : Ascii.FF;
                            break;
                        case 1072360691:
                            b = !strTrim.equals("INVALID_CUSTOM_TOKEN") ? (byte) -1 : Ascii.CR;
                            break;
                        case 1388786705:
                            b = !strTrim.equals("INVALID_IDENTIFIER") ? (byte) -1 : Ascii.SO;
                            break;
                        case 1433767024:
                            b = !strTrim.equals("USER_DISABLED") ? (byte) -1 : Ascii.SI;
                            break;
                        case 1563975629:
                            b = !strTrim.equals("INVALID_USER_TOKEN") ? (byte) -1 : Ascii.DLE;
                            break;
                        default:
                            b = -1;
                            break;
                    }
                    switch (b) {
                        case 0:
                        case 16:
                            message = "The user's credential is no longer valid. The user must sign in again.";
                            break;
                        case 1:
                            message = "The supplied auth credential is malformed or has expired.";
                            break;
                        case 2:
                            message = "The email address is badly formatted.";
                            break;
                        case 3:
                            message = "This credential is already associated with a different user account.";
                            break;
                        case 4:
                            message = "This operation is not allowed. You must enable this service in the console.";
                            break;
                        case 5:
                            message = "The custom token corresponds to a different audience.";
                            break;
                        case 6:
                            message = "The email address is already in use by another account.";
                            break;
                        case 7:
                            message = "There is no user record corresponding to this identifier. The user may have been deleted.";
                            break;
                        case 8:
                            message = "The supplied credentials do not correspond to the previously signed in user.";
                            break;
                        case 9:
                            message = "The given password is invalid.";
                            break;
                        case 10:
                            message = "The password is invalid or the user does not have a password.";
                            break;
                        case 11:
                            message = "This operation is sensitive and requires recent authentication. Log in again before retrying this request.";
                            break;
                        case 12:
                            message = "An account already exists with the same email address but different sign-in credentials. Sign in using a provider associated with this email address.";
                            break;
                        case 13:
                            message = "The custom token format is incorrect. Please check the documentation.";
                            break;
                        case 14:
                            strTrim = "INVALID_EMAIL";
                            message = "The email address is badly formatted.";
                            break;
                        case 15:
                            message = "The user account has been disabled by an administrator.";
                            break;
                    }
                }
            }
        } catch (Exception unused2) {
            strTrim = "UNKNOWN";
        }
        if (exc instanceof FirebaseAuthMultiFactorException) {
            MultiFactorResolver resolver = ((FirebaseAuthMultiFactorException) exc).getResolver();
            String string = Integer.toString(resolver.getSession().hashCode());
            this.mCachedResolvers.putReplacing(string, resolver);
            writableMapCreateMap.putString(RumSessionScope.RUM_SESSION_ID_BUS_MESSAGE_KEY, string);
            strTrim = "MULTI_FACTOR_AUTH_REQUIRED";
        }
        if (!strTrim.equals("UNKNOWN")) {
            str2 = message;
            str = strTrim;
        } else if (!(exc instanceof FirebaseAuthInvalidCredentialsException)) {
            if (exc instanceof FirebaseNetworkException) {
                str = "NETWORK_REQUEST_FAILED";
            } else if (exc instanceof FirebaseTooManyRequestsException) {
                str = "TOO_MANY_REQUESTS";
            } else {
                str2 = message;
                str = strTrim;
            }
            str2 = message;
        }
        str.hashCode();
        switch (str) {
            case "ERROR_INVALID_PHONE_NUMBER":
                str2 = "The format of the phone number provided is incorrect. Please enter the phone number in a format that can be parsed into E.164 format. E.164 phone numbers are written in the format [+][country code][subscriber number including area code].";
                break;
            case "ERROR_UNSUPPORTED_FIRST_FACTOR":
                str2 = "Enrolling a second factor or signing in with a multi-factor account requires sign-in with a supported first factor.";
                break;
            case "ERROR_UNVERIFIED_EMAIL":
                str2 = "This operation requires a verified email.";
                break;
        }
        writableMapCreateMap.putString("code", str.toLowerCase(Locale.ROOT).replace("error_", "").replace('_', '-'));
        writableMapCreateMap.putString("message", str2);
        writableMapCreateMap.putString("nativeErrorMessage", exc.getMessage());
        return writableMapCreateMap;
    }

    private WritableArray convertProviderData(List<? extends UserInfo> list, FirebaseUser firebaseUser) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        for (UserInfo userInfo : new ArrayList(list)) {
            if (!FirebaseAuthProvider.PROVIDER_ID.equals(userInfo.getProviderId())) {
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putString("providerId", userInfo.getProviderId());
                writableMapCreateMap.putString("uid", userInfo.getUid());
                writableMapCreateMap.putString("displayName", userInfo.getDisplayName());
                Uri photoUrl = userInfo.getPhotoUrl();
                if (photoUrl != null && !"".equals(photoUrl.toString())) {
                    writableMapCreateMap.putString("photoURL", photoUrl.toString());
                } else {
                    writableMapCreateMap.putNull("photoURL");
                }
                String phoneNumber = userInfo.getPhoneNumber();
                if ("phone".equals(userInfo.getProviderId()) && (userInfo.getPhoneNumber() == null || "".equals(userInfo.getPhoneNumber()))) {
                    writableMapCreateMap.putString(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, firebaseUser.getPhoneNumber());
                } else if (phoneNumber != null && !"".equals(phoneNumber)) {
                    writableMapCreateMap.putString(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, phoneNumber);
                } else {
                    writableMapCreateMap.putNull(HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
                }
                if ("password".equals(userInfo.getProviderId()) && (userInfo.getEmail() == null || "".equals(userInfo.getEmail()))) {
                    writableMapCreateMap.putString("email", userInfo.getUid());
                } else if (userInfo.getEmail() != null && !"".equals(userInfo.getEmail())) {
                    writableMapCreateMap.putString("email", userInfo.getEmail());
                } else {
                    writableMapCreateMap.putNull("email");
                }
                writableArrayCreateArray.pushMap(writableMapCreateMap);
            }
        }
        return writableArrayCreateArray;
    }

    private WritableMap firebaseUserToMap(FirebaseUser firebaseUser) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        String uid = firebaseUser.getUid();
        String email = firebaseUser.getEmail();
        Uri photoUrl = firebaseUser.getPhotoUrl();
        String displayName = firebaseUser.getDisplayName();
        String providerId = firebaseUser.getProviderId();
        boolean zIsEmailVerified = firebaseUser.isEmailVerified();
        String phoneNumber = firebaseUser.getPhoneNumber();
        String tenantId = firebaseUser.getTenantId();
        writableMapCreateMap.putString("uid", uid);
        writableMapCreateMap.putString("providerId", providerId);
        writableMapCreateMap.putBoolean("emailVerified", zIsEmailVerified);
        writableMapCreateMap.putBoolean("isAnonymous", firebaseUser.isAnonymous());
        if (email != null && !"".equals(email)) {
            writableMapCreateMap.putString("email", email);
        } else {
            writableMapCreateMap.putNull("email");
        }
        if (displayName != null && !"".equals(displayName)) {
            writableMapCreateMap.putString("displayName", displayName);
        } else {
            writableMapCreateMap.putNull("displayName");
        }
        if (photoUrl != null && !"".equals(photoUrl.toString())) {
            writableMapCreateMap.putString("photoURL", photoUrl.toString());
        } else {
            writableMapCreateMap.putNull("photoURL");
        }
        if (phoneNumber != null && !"".equals(phoneNumber)) {
            writableMapCreateMap.putString(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, phoneNumber);
        } else {
            writableMapCreateMap.putNull(HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
        }
        if (tenantId != null && !"".equals(tenantId)) {
            writableMapCreateMap.putString("tenantId", tenantId);
        } else {
            writableMapCreateMap.putNull("tenantId");
        }
        writableMapCreateMap.putArray("providerData", convertProviderData(firebaseUser.getProviderData(), firebaseUser));
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        FirebaseUserMetadata metadata = firebaseUser.getMetadata();
        if (metadata != null) {
            writableMapCreateMap2.putDouble("creationTime", metadata.getCreationTimestamp());
            writableMapCreateMap2.putDouble("lastSignInTime", metadata.getLastSignInTimestamp());
        }
        writableMapCreateMap.putMap("metadata", writableMapCreateMap2);
        WritableArray writableArrayCreateArray = Arguments.createArray();
        Iterator<MultiFactorInfo> it = firebaseUser.getMultiFactor().getEnrolledFactors().iterator();
        while (it.hasNext()) {
            writableArrayCreateArray.pushMap(multiFactorInfoToMap(it.next()));
        }
        WritableMap writableMapCreateMap3 = Arguments.createMap();
        writableMapCreateMap3.putArray("enrolledFactors", writableArrayCreateArray);
        writableMapCreateMap.putMap("multiFactor", writableMapCreateMap3);
        return writableMapCreateMap;
    }

    private WritableMap resolverToMap(String str, MultiFactorResolver multiFactorResolver) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        WritableArray writableArrayCreateArray = Arguments.createArray();
        Iterator<MultiFactorInfo> it = multiFactorResolver.getHints().iterator();
        while (it.hasNext()) {
            writableArrayCreateArray.pushMap(multiFactorInfoToMap(it.next()));
        }
        writableMapCreateMap.putArray("hints", writableArrayCreateArray);
        writableMapCreateMap.putString("session", str);
        return writableMapCreateMap;
    }

    private WritableMap multiFactorInfoToMap(MultiFactorInfo multiFactorInfo) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        Date date = new Date(multiFactorInfo.getEnrollmentTimestamp() * 1000);
        writableMapCreateMap.putString("displayName", multiFactorInfo.getDisplayName());
        writableMapCreateMap.putString("enrollmentTime", ISO_8601_FORMATTER.format(date));
        writableMapCreateMap.putString("factorId", multiFactorInfo.getFactorId());
        writableMapCreateMap.putString("uid", multiFactorInfo.getUid());
        if (multiFactorInfo.getFactorId().equals("phone")) {
            writableMapCreateMap.putString(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, ((PhoneMultiFactorInfo) multiFactorInfo).getPhoneNumber());
        }
        return writableMapCreateMap;
    }

    private ActionCodeSettings buildActionCodeSettings(ReadableMap readableMap) {
        ActionCodeSettings.Builder url = ActionCodeSettings.newBuilder().setUrl((String) Objects.requireNonNull(readableMap.getString(ImagesContract.URL)));
        if (readableMap.hasKey("handleCodeInApp")) {
            url = url.setHandleCodeInApp(readableMap.getBoolean("handleCodeInApp"));
        }
        if (readableMap.hasKey("linkDomain")) {
            url = url.setLinkDomain((String) Objects.requireNonNull(readableMap.getString("linkDomain")));
        }
        if (readableMap.hasKey("android")) {
            ReadableMap map = readableMap.getMap("android");
            url = url.setAndroidPackageName((String) Objects.requireNonNull(map.getString("packageName")), ((ReadableMap) Objects.requireNonNull(map)).hasKey("installApp") && map.getBoolean("installApp"), map.hasKey("minimumVersion") ? map.getString("minimumVersion") : null);
        }
        if (readableMap.hasKey("iOS")) {
            url = url.setIOSBundleId((String) Objects.requireNonNull(readableMap.getMap("iOS").getString("bundleId")));
        }
        return url.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendPhoneStateEvent(String str, String str2, String str3, WritableMap writableMap) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        ReactNativeFirebaseEventEmitter sharedInstance = ReactNativeFirebaseEventEmitter.getSharedInstance();
        writableMapCreateMap.putString("appName", str);
        writableMapCreateMap.putString("requestKey", str2);
        writableMapCreateMap.putString("type", str3);
        writableMapCreateMap.putMap("state", writableMap);
        sharedInstance.sendEvent(new ReactNativeFirebaseEvent("phone_auth_state_changed", writableMapCreateMap, str));
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAuthSpec
    protected Map<String, Object> getTypedExportedConstants() {
        HashMap map = new HashMap();
        List<FirebaseApp> apps = FirebaseApp.getApps(getReactApplicationContext());
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        Iterator<FirebaseApp> it = apps.iterator();
        while (it.hasNext()) {
            String name = it.next().getName();
            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(FirebaseApp.getInstance(name));
            FirebaseUser currentUser = firebaseAuth.getCurrentUser();
            map2.put(name, firebaseAuth.getLanguageCode());
            if (currentUser != null) {
                map3.put(name, firebaseUserToMap(currentUser));
            }
        }
        map.put("APP_LANGUAGE", map2);
        map.put("APP_USER", map3);
        return map;
    }
}

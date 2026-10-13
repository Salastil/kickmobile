package expo.modules.securestore;

import android.app.Activity;
import android.content.Context;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.fragment.app.FragmentActivity;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.interfaces.ActivityProvider;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: compiled from: AuthenticationHelper.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0080@¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0013\u001a\u00020\u0014J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lexpo/modules/securestore/AuthenticationHelper;", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "moduleRegistry", "Lexpo/modules/core/ModuleRegistry;", "<init>", "(Landroid/content/Context;Lexpo/modules/core/ModuleRegistry;)V", "isAuthenticating", "", "authenticateCipher", "Ljavax/crypto/Cipher;", "cipher", "options", "Lexpo/modules/securestore/AuthenticationPromptOptions;", "authenticateCipher$expo_secure_store_release", "(Ljavax/crypto/Cipher;Lexpo/modules/securestore/AuthenticationPromptOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openAuthenticationPrompt", "Landroidx/biometric/BiometricPrompt$AuthenticationResult;", "assertBiometricsSupport", "", "getCurrentActivity", "Landroid/app/Activity;", "Companion", "expo-secure-store_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AuthenticationHelper {
    public static final String REQUIRE_AUTHENTICATION_PROPERTY = "requireAuthentication";
    private final Context context;
    private boolean isAuthenticating;
    private final ModuleRegistry moduleRegistry;

    /* JADX INFO: renamed from: expo.modules.securestore.AuthenticationHelper$openAuthenticationPrompt$1, reason: invalid class name */
    /* JADX INFO: compiled from: AuthenticationHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.securestore.AuthenticationHelper", f = "AuthenticationHelper.kt", i = {0, 0, 0, 0}, l = {55}, m = "openAuthenticationPrompt", n = {"cipher", "options", "fragmentActivity", "authenticationPrompt"}, s = {"L$0", "L$1", "L$2", "L$3"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AuthenticationHelper.this.openAuthenticationPrompt(null, null, this);
        }
    }

    public AuthenticationHelper(Context context, ModuleRegistry moduleRegistry) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(moduleRegistry, "moduleRegistry");
        this.context = context;
        this.moduleRegistry = moduleRegistry;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object authenticateCipher$expo_secure_store_release(Cipher cipher, AuthenticationPromptOptions authenticationPromptOptions, Continuation<? super Cipher> continuation) throws AuthenticationException {
        AuthenticationHelper$authenticateCipher$1 authenticationHelper$authenticateCipher$1;
        Cipher cipher2;
        if (continuation instanceof AuthenticationHelper$authenticateCipher$1) {
            authenticationHelper$authenticateCipher$1 = (AuthenticationHelper$authenticateCipher$1) continuation;
            if ((authenticationHelper$authenticateCipher$1.label & Integer.MIN_VALUE) != 0) {
                authenticationHelper$authenticateCipher$1.label -= Integer.MIN_VALUE;
            } else {
                authenticationHelper$authenticateCipher$1 = new AuthenticationHelper$authenticateCipher$1(this, continuation);
            }
        } else {
            authenticationHelper$authenticateCipher$1 = new AuthenticationHelper$authenticateCipher$1(this, continuation);
        }
        Object objOpenAuthenticationPrompt = authenticationHelper$authenticateCipher$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = authenticationHelper$authenticateCipher$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objOpenAuthenticationPrompt);
            if (!authenticationPromptOptions.getRequireAuthentication()) {
                return cipher;
            }
            authenticationHelper$authenticateCipher$1.L$0 = SpillingKt.nullOutSpilledVariable(cipher);
            authenticationHelper$authenticateCipher$1.L$1 = SpillingKt.nullOutSpilledVariable(authenticationPromptOptions);
            authenticationHelper$authenticateCipher$1.label = 1;
            objOpenAuthenticationPrompt = openAuthenticationPrompt(cipher, authenticationPromptOptions, authenticationHelper$authenticateCipher$1);
            if (objOpenAuthenticationPrompt == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objOpenAuthenticationPrompt);
        }
        BiometricPrompt.CryptoObject cryptoObject = ((BiometricPrompt.AuthenticationResult) objOpenAuthenticationPrompt).getCryptoObject();
        if (cryptoObject == null || (cipher2 = cryptoObject.getCipher()) == null) {
            throw new AuthenticationException("Couldn't get cipher from authentication result", null, 2, null);
        }
        return cipher2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object openAuthenticationPrompt(Cipher cipher, AuthenticationPromptOptions authenticationPromptOptions, Continuation<? super BiometricPrompt.AuthenticationResult> continuation) throws AuthenticationException {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objWithContext = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objWithContext);
                if (this.isAuthenticating) {
                    throw new AuthenticationException("Authentication is already in progress", null, 2, null);
                }
                this.isAuthenticating = true;
                assertBiometricsSupport();
                Activity currentActivity = getCurrentActivity();
                FragmentActivity fragmentActivity = currentActivity instanceof FragmentActivity ? (FragmentActivity) currentActivity : null;
                if (fragmentActivity == null) {
                    throw new AuthenticationException("Cannot display biometric prompt when the app is not in the foreground", null, 2, null);
                }
                AuthenticationPrompt authenticationPrompt = new AuthenticationPrompt(fragmentActivity, this.context, authenticationPromptOptions.getAuthenticationPrompt(), authenticationPromptOptions.getRequireConfirmation());
                MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(authenticationPrompt, cipher, null);
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(cipher);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(authenticationPromptOptions);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(fragmentActivity);
                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(authenticationPrompt);
                anonymousClass1.label = 1;
                objWithContext = BuildersKt.withContext(immediate, anonymousClass2, anonymousClass1);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objWithContext);
            }
            this.isAuthenticating = false;
            return objWithContext;
        } catch (Throwable th) {
            this.isAuthenticating = false;
            throw th;
        }
    }

    /* JADX INFO: renamed from: expo.modules.securestore.AuthenticationHelper$openAuthenticationPrompt$2, reason: invalid class name */
    /* JADX INFO: compiled from: AuthenticationHelper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroidx/biometric/BiometricPrompt$AuthenticationResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.securestore.AuthenticationHelper$openAuthenticationPrompt$2", f = "AuthenticationHelper.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BiometricPrompt.AuthenticationResult>, Object> {
        final /* synthetic */ AuthenticationPrompt $authenticationPrompt;
        final /* synthetic */ Cipher $cipher;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(AuthenticationPrompt authenticationPrompt, Cipher cipher, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$authenticationPrompt = authenticationPrompt;
            this.$cipher = cipher;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$authenticationPrompt, this.$cipher, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BiometricPrompt.AuthenticationResult> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws AuthenticationException {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = this.$authenticationPrompt.authenticate(this.$cipher, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            BiometricPrompt.AuthenticationResult authenticationResult = (BiometricPrompt.AuthenticationResult) obj;
            if (authenticationResult != null) {
                return authenticationResult;
            }
            throw new AuthenticationException("Couldn't get the authentication result", null, 2, null);
        }
    }

    public final void assertBiometricsSupport() throws AuthenticationException {
        BiometricManager biometricManagerFrom = BiometricManager.from(this.context);
        Intrinsics.checkNotNullExpressionValue(biometricManagerFrom, "from(...)");
        int iCanAuthenticate = biometricManagerFrom.canAuthenticate(15);
        if (iCanAuthenticate == -2) {
            throw new AuthenticationException("Biometric authentication is unsupported", null, 2, null);
        }
        if (iCanAuthenticate != -1) {
            if (iCanAuthenticate != 1) {
                if (iCanAuthenticate == 15) {
                    throw new AuthenticationException("An update is required before the biometrics can be used", null, 2, null);
                }
                if (iCanAuthenticate == 11) {
                    throw new AuthenticationException("No biometrics are currently enrolled", null, 2, null);
                }
                if (iCanAuthenticate != 12) {
                    return;
                }
            }
            throw new AuthenticationException("No hardware available for biometric authentication. Use expo-local-authentication to check if the device supports it", null, 2, null);
        }
        throw new AuthenticationException("Biometric authentication status is unknown", null, 2, null);
    }

    private final Activity getCurrentActivity() {
        Object module = this.moduleRegistry.getModule(ActivityProvider.class);
        Intrinsics.checkNotNullExpressionValue(module, "getModule(...)");
        return ((ActivityProvider) module).getCurrentActivity();
    }
}

package expo.modules.securestore;

import android.content.Context;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import io.ktor.http.HttpHeaders;
import java.util.concurrent.Executor;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AuthenticationPrompt.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lexpo/modules/securestore/AuthenticationPrompt;", "", "currentActivity", "Landroidx/fragment/app/FragmentActivity;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "title", "", "requireConfirmation", "", "<init>", "(Landroidx/fragment/app/FragmentActivity;Landroid/content/Context;Ljava/lang/String;Z)V", "executor", "Ljava/util/concurrent/Executor;", "promptInfo", "Landroidx/biometric/BiometricPrompt$PromptInfo;", "authenticate", "Landroidx/biometric/BiometricPrompt$AuthenticationResult;", "cipher", "Ljavax/crypto/Cipher;", "(Ljavax/crypto/Cipher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "convertErrorCode", "code", "", "expo-secure-store_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AuthenticationPrompt {
    private final FragmentActivity currentActivity;
    private Executor executor;
    private BiometricPrompt.PromptInfo promptInfo;

    public AuthenticationPrompt(FragmentActivity currentActivity, Context context, String title, boolean z) {
        Intrinsics.checkNotNullParameter(currentActivity, "currentActivity");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        this.currentActivity = currentActivity;
        Executor mainExecutor = ContextCompat.getMainExecutor(context);
        Intrinsics.checkNotNullExpressionValue(mainExecutor, "getMainExecutor(...)");
        this.executor = mainExecutor;
        this.promptInfo = AuthenticationPromptKt.buildAuthenticationPromptInfo(context, title, z);
    }

    public final Object authenticate(Cipher cipher, Continuation<? super BiometricPrompt.AuthenticationResult> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        new BiometricPrompt(this.currentActivity, this.executor, new BiometricPrompt.AuthenticationCallback() { // from class: expo.modules.securestore.AuthenticationPrompt$authenticate$2$1
            @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
            public void onAuthenticationError(int errorCode, CharSequence errString) {
                Intrinsics.checkNotNullParameter(errString, "errString");
                super.onAuthenticationError(errorCode, errString);
                String str = this.this$0.convertErrorCode(errorCode) + ". " + ((Object) errString);
                Continuation<BiometricPrompt.AuthenticationResult> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m12684constructorimpl(ResultKt.createFailure(new AuthenticationException(str, null, 2, null))));
            }

            @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
            public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                super.onAuthenticationSucceeded(result);
                Continuation<BiometricPrompt.AuthenticationResult> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m12684constructorimpl(result));
            }
        }).authenticate(this.promptInfo, new BiometricPrompt.CryptoObject(cipher));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String convertErrorCode(int code) {
        switch (code) {
            case 1:
                return "Hardware unavailable";
            case 2:
                return "Unable to process";
            case 3:
                return HttpHeaders.Timeout;
            case 4:
                return "No space";
            case 5:
            case 6:
            default:
                return "Unknown error (code: " + code + ")";
            case 7:
                return "Lockout";
            case 8:
                return "Vendor error";
            case 9:
                return "Lockout permanent";
            case 10:
                return "User canceled the authentication";
            case 11:
                return "No biometrics enrolled";
            case 12:
                return "Hardware not present";
            case 13:
                return "User canceled the authentication";
            case 14:
                return "No device credential";
        }
    }
}

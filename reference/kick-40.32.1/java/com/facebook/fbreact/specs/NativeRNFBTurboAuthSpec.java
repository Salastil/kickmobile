package com.facebook.fbreact.specs;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes9.dex */
public abstract class NativeRNFBTurboAuthSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "NativeRNFBTurboAuth";

    @ReactMethod
    public abstract void addAuthStateListener(String str);

    @ReactMethod
    public abstract void addIdTokenListener(String str);

    @ReactMethod
    public abstract void applyActionCode(String str, String str2, Promise promise);

    @ReactMethod
    public abstract void checkActionCode(String str, String str2, Promise promise);

    @ReactMethod
    public abstract void configureAuthDomain(String str);

    @ReactMethod
    public abstract void confirmPasswordReset(String str, String str2, String str3, Promise promise);

    @ReactMethod
    public abstract void confirmationResultConfirm(String str, String str2, Promise promise);

    @ReactMethod
    public abstract void createUserWithEmailAndPassword(String str, String str2, String str3, Promise promise);

    @ReactMethod
    public abstract void deleteUser(String str, Promise promise);

    @ReactMethod
    public abstract void fetchSignInMethodsForEmail(String str, String str2, Promise promise);

    @ReactMethod
    public abstract void finalizeMultiFactorEnrollment(String str, String str2, String str3, @Nullable String str4, Promise promise);

    @ReactMethod
    public abstract void finalizeTotpEnrollment(String str, String str2, String str3, @Nullable String str4, Promise promise);

    @ReactMethod
    public abstract void forceRecaptchaFlowForTesting(String str, boolean z, Promise promise);

    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract String generateQrCodeUrl(String str, String str2, String str3, String str4);

    @ReactMethod
    public abstract void generateTotpSecret(String str, String str2, Promise promise);

    @ReactMethod
    public abstract void getCustomAuthDomain(String str, Promise promise);

    @ReactMethod
    public abstract void getIdToken(String str, boolean z, Promise promise);

    @ReactMethod
    public abstract void getIdTokenResult(String str, boolean z, Promise promise);

    @ReactMethod
    public abstract void getSession(String str, Promise promise);

    protected abstract Map<String, Object> getTypedExportedConstants();

    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract boolean isSignInWithEmailLink(String str, String str2);

    @ReactMethod
    public abstract void linkWithCredential(String str, String str2, String str3, String str4, Promise promise);

    @ReactMethod
    public abstract void linkWithProvider(String str, ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void openInOtpApp(String str, String str2, String str3);

    @ReactMethod
    public abstract void reauthenticateWithCredential(String str, String str2, String str3, String str4, Promise promise);

    @ReactMethod
    public abstract void reauthenticateWithProvider(String str, ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void reload(String str, Promise promise);

    @ReactMethod
    public abstract void removeAuthStateListener(String str);

    @ReactMethod
    public abstract void removeIdTokenListener(String str);

    @ReactMethod
    public abstract void resolveMultiFactorSignIn(String str, String str2, String str3, String str4, Promise promise);

    @ReactMethod
    public abstract void resolveTotpSignIn(String str, String str2, String str3, String str4, Promise promise);

    @ReactMethod
    public abstract void revokeToken(String str, String str2, Promise promise);

    @ReactMethod
    public abstract void sendEmailVerification(String str, @Nullable ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void sendPasswordResetEmail(String str, String str2, @Nullable ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void sendSignInLinkToEmail(String str, String str2, ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void setAppVerificationDisabledForTesting(String str, boolean z, Promise promise);

    @ReactMethod
    public abstract void setAutoRetrievedSmsCodeForPhoneNumber(String str, String str2, String str3, Promise promise);

    @ReactMethod
    public abstract void setLanguageCode(String str, @Nullable String str2);

    @ReactMethod
    public abstract void setTenantId(String str, @Nullable String str2, Promise promise);

    @ReactMethod
    public abstract void signInAnonymously(String str, Promise promise);

    @ReactMethod
    public abstract void signInWithCredential(String str, String str2, String str3, String str4, @Nullable ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void signInWithCustomToken(String str, String str2, Promise promise);

    @ReactMethod
    public abstract void signInWithEmailAndPassword(String str, String str2, String str3, Promise promise);

    @ReactMethod
    public abstract void signInWithEmailLink(String str, String str2, String str3, Promise promise);

    @ReactMethod
    public abstract void signInWithPhoneNumber(String str, String str2, boolean z, Promise promise);

    @ReactMethod
    public abstract void signInWithProvider(String str, ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void signOut(String str, Promise promise);

    @ReactMethod
    public abstract void unenrollMultiFactor(String str, String str2, Promise promise);

    @ReactMethod
    public abstract void unlink(String str, String str2, Promise promise);

    @ReactMethod
    public abstract void updateEmail(String str, String str2, Promise promise);

    @ReactMethod
    public abstract void updatePassword(String str, String str2, Promise promise);

    @ReactMethod
    public abstract void updatePhoneNumber(String str, String str2, String str3, String str4, Promise promise);

    @ReactMethod
    public abstract void updateProfile(String str, ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void useDeviceLanguage(String str);

    @ReactMethod
    public abstract void useEmulator(String str, String str2, double d);

    @ReactMethod
    public abstract void useUserAccessGroup(String str, String str2, Promise promise);

    @ReactMethod
    public abstract void verifyBeforeUpdateEmail(String str, String str2, @Nullable ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void verifyPasswordResetCode(String str, String str2, Promise promise);

    @ReactMethod
    public abstract void verifyPhoneNumber(String str, String str2, String str3, double d, boolean z);

    @ReactMethod
    public abstract void verifyPhoneNumberForMultiFactor(String str, String str2, String str3, Promise promise);

    @ReactMethod
    public abstract void verifyPhoneNumberWithMultiFactorInfo(String str, String str2, String str3, Promise promise);

    public NativeRNFBTurboAuthSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    @Nullable
    public final Map<String, Object> getConstants() {
        Map<String, Object> typedExportedConstants = getTypedExportedConstants();
        if (ReactBuildConfig.DEBUG || ReactBuildConfig.IS_INTERNAL_BUILD) {
            HashSet hashSet = new HashSet(Arrays.asList("APP_LANGUAGE", "APP_USER"));
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = new HashSet(typedExportedConstants.keySet());
            hashSet3.removeAll(hashSet);
            hashSet3.removeAll(hashSet2);
            if (!hashSet3.isEmpty()) {
                throw new IllegalStateException(String.format("Native Module Flow doesn't declare constants: %s", hashSet3));
            }
            hashSet.removeAll(typedExportedConstants.keySet());
            if (!hashSet.isEmpty()) {
                throw new IllegalStateException(String.format("Native Module doesn't fill in constants: %s", hashSet));
            }
        }
        return typedExportedConstants;
    }
}

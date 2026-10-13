package expo.modules.securestore.encryptors;

import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import androidx.media3.muxer.WebmConstants;
import com.google.android.gms.stats.CodePackage;
import com.swmansion.gesturehandler.BuildConfig;
import expo.modules.crypto.aes.AesConfig;
import expo.modules.securestore.AuthenticationException;
import expo.modules.securestore.AuthenticationHelper;
import expo.modules.securestore.AuthenticationPromptOptions;
import expo.modules.securestore.DecryptException;
import expo.modules.securestore.SecureStoreModule;
import expo.modules.securestore.SecureStoreOptions;
import expo.modules.securestore.SecureStoreOptionsKt;
import io.ktor.sse.ServerSentEventKt;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyStore;
import java.security.UnrecoverableEntryException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.GCMParameterSpec;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AESEncryptor.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0017J.\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010\u0015J%\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\b\u001bJ6\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010\u001f¨\u0006!"}, d2 = {"Lexpo/modules/securestore/encryptors/AESEncryptor;", "Lexpo/modules/securestore/encryptors/KeyBasedEncryptor;", "Ljava/security/KeyStore$SecretKeyEntry;", "<init>", "()V", "getKeyStoreAlias", "", "options", "Lexpo/modules/securestore/SecureStoreOptions;", "getExtendedKeyStoreAlias", AuthenticationHelper.REQUIRE_AUTHENTICATION_PROPERTY, "", "initializeKeyStoreEntry", "keyStore", "Ljava/security/KeyStore;", "createEncryptedItem", "Lorg/json/JSONObject;", "plaintextValue", "keyStoreEntry", "authenticationHelper", "Lexpo/modules/securestore/AuthenticationHelper;", "(Ljava/lang/String;Ljava/security/KeyStore$SecretKeyEntry;Lexpo/modules/securestore/SecureStoreOptions;Lexpo/modules/securestore/AuthenticationHelper;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createEncryptedItemWithCipher", "cipher", "Ljavax/crypto/Cipher;", "gcmSpec", "Ljavax/crypto/spec/GCMParameterSpec;", "createEncryptedItemWithCipher$expo_secure_store_release", "decryptItem", "key", "encryptedItem", "(Ljava/lang/String;Lorg/json/JSONObject;Ljava/security/KeyStore$SecretKeyEntry;Lexpo/modules/securestore/SecureStoreOptions;Lexpo/modules/securestore/AuthenticationHelper;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "expo-secure-store_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AESEncryptor implements KeyBasedEncryptor<KeyStore.SecretKeyEntry> {
    public static final String AES_CIPHER = "AES/GCM/NoPadding";
    public static final int AES_KEY_SIZE_BITS = 256;
    private static final String CIPHERTEXT_PROPERTY = "ct";
    private static final String GCM_AUTHENTICATION_TAG_LENGTH_PROPERTY = "tlen";
    public static final String IV_PROPERTY = "iv";
    private static final int MIN_GCM_AUTHENTICATION_TAG_LENGTH = 96;
    public static final String NAME = "aes";

    /* JADX INFO: renamed from: expo.modules.securestore.encryptors.AESEncryptor$createEncryptedItem$1, reason: invalid class name */
    /* JADX INFO: compiled from: AESEncryptor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.securestore.encryptors.AESEncryptor", f = "AESEncryptor.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {BuildConfig.REACT_NATIVE_MINOR_VERSION}, m = "createEncryptedItem", n = {"plaintextValue", "keyStoreEntry", "options", "authenticationHelper", "secretKey", "cipher", "gcmSpec"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AESEncryptor.this.createEncryptedItem((String) null, (KeyStore.SecretKeyEntry) null, (SecureStoreOptions) null, (AuthenticationHelper) null, (Continuation<? super JSONObject>) this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.securestore.encryptors.AESEncryptor$decryptItem$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AESEncryptor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.securestore.encryptors.AESEncryptor", f = "AESEncryptor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {WebmConstants.MkvEbmlElement.CODEC_ID}, m = "decryptItem", n = {"key", "encryptedItem", "keyStoreEntry", "options", "authenticationHelper", "ciphertext", "ivString", "ciphertextBytes", "ivBytes", "gcmSpec", "cipher", "authenticationTagLength", "requiresAuthentication"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0", "Z$0"})
    static final class C09261 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C09261(Continuation<? super C09261> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AESEncryptor.this.decryptItem((String) null, (JSONObject) null, (KeyStore.SecretKeyEntry) null, (SecureStoreOptions) null, (AuthenticationHelper) null, (Continuation<? super String>) this);
        }
    }

    @Override // expo.modules.securestore.encryptors.KeyBasedEncryptor
    public /* bridge */ /* synthetic */ Object createEncryptedItem(String str, KeyStore.Entry entry, SecureStoreOptions secureStoreOptions, AuthenticationHelper authenticationHelper, Continuation continuation) {
        return createEncryptedItem(str, (KeyStore.SecretKeyEntry) entry, secureStoreOptions, authenticationHelper, (Continuation<? super JSONObject>) continuation);
    }

    @Override // expo.modules.securestore.encryptors.KeyBasedEncryptor
    public /* bridge */ /* synthetic */ Object decryptItem(String str, JSONObject jSONObject, KeyStore.Entry entry, SecureStoreOptions secureStoreOptions, AuthenticationHelper authenticationHelper, Continuation continuation) {
        return decryptItem(str, jSONObject, (KeyStore.SecretKeyEntry) entry, secureStoreOptions, authenticationHelper, (Continuation<? super String>) continuation);
    }

    @Override // expo.modules.securestore.encryptors.KeyBasedEncryptor
    public String getKeyStoreAlias(SecureStoreOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        return "AES/GCM/NoPadding:" + options.getKeychainService();
    }

    @Override // expo.modules.securestore.encryptors.KeyBasedEncryptor
    public String getExtendedKeyStoreAlias(SecureStoreOptions options, boolean requireAuthentication) {
        String str;
        Intrinsics.checkNotNullParameter(options, "options");
        if (requireAuthentication) {
            str = SecureStoreModule.AUTHENTICATED_KEYSTORE_SUFFIX;
        } else {
            str = SecureStoreModule.UNAUTHENTICATED_KEYSTORE_SUFFIX;
        }
        return getKeyStoreAlias(options) + ServerSentEventKt.COLON + str;
    }

    @Override // expo.modules.securestore.encryptors.KeyBasedEncryptor
    public KeyStore.SecretKeyEntry initializeKeyStoreEntry(KeyStore keyStore, SecureStoreOptions options) throws GeneralSecurityException {
        Intrinsics.checkNotNullParameter(keyStore, "keyStore");
        Intrinsics.checkNotNullParameter(options, "options");
        String extendedKeyStoreAlias = getExtendedKeyStoreAlias(options, options.getRequireAuthentication());
        KeyGenParameterSpec keyGenParameterSpecBuild = new KeyGenParameterSpec.Builder(extendedKeyStoreAlias, 3).setKeySize(256).setBlockModes(CodePackage.GCM).setEncryptionPaddings("NoPadding").setUserAuthenticationRequired(options.getRequireAuthentication()).build();
        Intrinsics.checkNotNullExpressionValue(keyGenParameterSpecBuild, "build(...)");
        KeyGenerator keyGenerator = KeyGenerator.getInstance(AesConfig.CRYPTO_KEY_ALGORITHM, keyStore.getProvider());
        keyGenerator.init(keyGenParameterSpecBuild);
        keyGenerator.generateKey();
        KeyStore.Entry entry = keyStore.getEntry(extendedKeyStoreAlias, null);
        KeyStore.SecretKeyEntry secretKeyEntry = entry instanceof KeyStore.SecretKeyEntry ? (KeyStore.SecretKeyEntry) entry : null;
        if (secretKeyEntry != null) {
            return secretKeyEntry;
        }
        throw new UnrecoverableEntryException("Could not retrieve the newly generated secret key entry");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public Object createEncryptedItem(String str, KeyStore.SecretKeyEntry secretKeyEntry, SecureStoreOptions secureStoreOptions, AuthenticationHelper authenticationHelper, Continuation<? super JSONObject> continuation) throws GeneralSecurityException, AuthenticationException {
        AnonymousClass1 anonymousClass1;
        GCMParameterSpec gCMParameterSpec;
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
        Object objAuthenticateCipher$expo_secure_store_release = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAuthenticateCipher$expo_secure_store_release);
            Key secretKey = secretKeyEntry.getSecretKey();
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, secretKey);
            gCMParameterSpec = (GCMParameterSpec) cipher.getParameters().getParameterSpec(GCMParameterSpec.class);
            Intrinsics.checkNotNull(cipher);
            AuthenticationPromptOptions authenticationPromptOptions$default = SecureStoreOptionsKt.toAuthenticationPromptOptions$default(secureStoreOptions, false, 1, null);
            anonymousClass1.L$0 = str;
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(secretKeyEntry);
            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(secureStoreOptions);
            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(authenticationHelper);
            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(secretKey);
            anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(cipher);
            anonymousClass1.L$6 = gCMParameterSpec;
            anonymousClass1.label = 1;
            objAuthenticateCipher$expo_secure_store_release = authenticationHelper.authenticateCipher$expo_secure_store_release(cipher, authenticationPromptOptions$default, anonymousClass1);
            if (objAuthenticateCipher$expo_secure_store_release == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            GCMParameterSpec gCMParameterSpec2 = (GCMParameterSpec) anonymousClass1.L$6;
            String str2 = (String) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objAuthenticateCipher$expo_secure_store_release);
            gCMParameterSpec = gCMParameterSpec2;
            str = str2;
        }
        Intrinsics.checkNotNull(gCMParameterSpec);
        return createEncryptedItemWithCipher$expo_secure_store_release(str, (Cipher) objAuthenticateCipher$expo_secure_store_release, gCMParameterSpec);
    }

    public final JSONObject createEncryptedItemWithCipher$expo_secure_store_release(String plaintextValue, Cipher cipher, GCMParameterSpec gcmSpec) throws JSONException {
        Intrinsics.checkNotNullParameter(plaintextValue, "plaintextValue");
        Intrinsics.checkNotNullParameter(cipher, "cipher");
        Intrinsics.checkNotNullParameter(gcmSpec, "gcmSpec");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        byte[] bytes = plaintextValue.getBytes(UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        String strEncodeToString = Base64.encodeToString(cipher.doFinal(bytes), 2);
        String strEncodeToString2 = Base64.encodeToString(gcmSpec.getIV(), 2);
        JSONObject jSONObjectPut = new JSONObject().put(CIPHERTEXT_PROPERTY, strEncodeToString).put(IV_PROPERTY, strEncodeToString2).put(GCM_AUTHENTICATION_TAG_LENGTH_PROPERTY, gcmSpec.getTLen());
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "put(...)");
        return jSONObjectPut;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public Object decryptItem(String str, JSONObject jSONObject, KeyStore.SecretKeyEntry secretKeyEntry, SecureStoreOptions secureStoreOptions, AuthenticationHelper authenticationHelper, Continuation<? super String> continuation) throws JSONException, GeneralSecurityException, AuthenticationException, DecryptException {
        C09261 c09261;
        byte[] bArr;
        if (continuation instanceof C09261) {
            c09261 = (C09261) continuation;
            if ((c09261.label & Integer.MIN_VALUE) != 0) {
                c09261.label -= Integer.MIN_VALUE;
            } else {
                c09261 = new C09261(continuation);
            }
        } else {
            c09261 = new C09261(continuation);
        }
        Object objAuthenticateCipher$expo_secure_store_release = c09261.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09261.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAuthenticateCipher$expo_secure_store_release);
            String string = jSONObject.getString(CIPHERTEXT_PROPERTY);
            String string2 = jSONObject.getString(IV_PROPERTY);
            int i2 = jSONObject.getInt(GCM_AUTHENTICATION_TAG_LENGTH_PROPERTY);
            byte[] bArrDecode = Base64.decode(string, 0);
            byte[] bArrDecode2 = Base64.decode(string2, 0);
            AlgorithmParameterSpec gCMParameterSpec = new GCMParameterSpec(i2, bArrDecode2);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            boolean zOptBoolean = jSONObject.optBoolean(AuthenticationHelper.REQUIRE_AUTHENTICATION_PROPERTY);
            if (i2 < 96) {
                throw new DecryptException("Authentication tag length must be at least 96 bits long", str, secureStoreOptions.getKeychainService(), null, 8, null);
            }
            cipher.init(2, secretKeyEntry.getSecretKey(), gCMParameterSpec);
            Intrinsics.checkNotNull(cipher);
            AuthenticationPromptOptions authenticationPromptOptions = SecureStoreOptionsKt.toAuthenticationPromptOptions(secureStoreOptions, zOptBoolean);
            c09261.L$0 = SpillingKt.nullOutSpilledVariable(str);
            c09261.L$1 = SpillingKt.nullOutSpilledVariable(jSONObject);
            c09261.L$2 = SpillingKt.nullOutSpilledVariable(secretKeyEntry);
            c09261.L$3 = SpillingKt.nullOutSpilledVariable(secureStoreOptions);
            c09261.L$4 = SpillingKt.nullOutSpilledVariable(authenticationHelper);
            c09261.L$5 = SpillingKt.nullOutSpilledVariable(string);
            c09261.L$6 = SpillingKt.nullOutSpilledVariable(string2);
            c09261.L$7 = bArrDecode;
            c09261.L$8 = SpillingKt.nullOutSpilledVariable(bArrDecode2);
            c09261.L$9 = SpillingKt.nullOutSpilledVariable(gCMParameterSpec);
            c09261.L$10 = SpillingKt.nullOutSpilledVariable(cipher);
            c09261.I$0 = i2;
            c09261.Z$0 = zOptBoolean;
            c09261.label = 1;
            objAuthenticateCipher$expo_secure_store_release = authenticationHelper.authenticateCipher$expo_secure_store_release(cipher, authenticationPromptOptions, c09261);
            if (objAuthenticateCipher$expo_secure_store_release == coroutine_suspended) {
                return coroutine_suspended;
            }
            bArr = bArrDecode;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            boolean z = c09261.Z$0;
            int i3 = c09261.I$0;
            bArr = (byte[]) c09261.L$7;
            ResultKt.throwOnFailure(objAuthenticateCipher$expo_secure_store_release);
        }
        byte[] bArrDoFinal = ((Cipher) objAuthenticateCipher$expo_secure_store_release).doFinal(bArr);
        Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "doFinal(...)");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        return new String(bArrDoFinal, UTF_8);
    }
}

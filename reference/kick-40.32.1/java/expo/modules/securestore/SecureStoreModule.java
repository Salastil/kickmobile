package expo.modules.securestore;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.security.keystore.KeyPermanentlyInvalidatedException;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import androidx.tracing.Trace;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionBuilder;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.SuspendFunctionComponent;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.functions.UntypedAsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeCache;
import expo.modules.kotlin.types.JSTypeConverter;
import expo.modules.kotlin.types.ReturnType;
import expo.modules.kotlin.types.ReturnTypeKt;
import expo.modules.kotlin.types.ReturnTypeProvider;
import expo.modules.kotlin.types.TypeConverterProvider;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt;
import expo.modules.securestore.encryptors.AESEncryptor;
import expo.modules.securestore.encryptors.HybridAESEncryptor;
import expo.modules.securestore.encryptors.KeyBasedEncryptor;
import io.github.expo.pika.PTypeDescriptorRegistry;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.util.Map;
import javax.crypto.BadPaddingException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SecureStoreModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0016J \u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010\u0017J(\u0010\u0018\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010\u001bJ0\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 H\u0082@¢\u0006\u0002\u0010!J0\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020\u0013H\u0002J\u0018\u0010'\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u0013H\u0002J\u0010\u0010*\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u0013H\u0002J=\u0010+\u001a\u0004\u0018\u0001H,\"\b\b\u0000\u0010,*\u00020-2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H,0/2\f\u00100\u001a\b\u0012\u0004\u0012\u0002H,012\u0006\u0010\u0015\u001a\u00020\u0016H\u0002¢\u0006\u0002\u00102JE\u00103\u001a\u0004\u0018\u0001H,\"\b\b\u0000\u0010,*\u00020-2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H,0/2\f\u00100\u001a\b\u0012\u0004\u0012\u0002H,012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010%\u001a\u00020 H\u0002¢\u0006\u0002\u00104JC\u00105\u001a\u0002H,\"\b\b\u0000\u0010,*\u00020-2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H,0/2\f\u00100\u001a\b\u0012\u0004\u0012\u0002H,012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010%\u001a\u00020 H\u0002¢\u0006\u0002\u00104JM\u00106\u001a\u0004\u0018\u0001H,\"\b\b\u0000\u0010,*\u00020-2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H,0/2\f\u00100\u001a\b\u0012\u0004\u0012\u0002H,012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010%\u001a\u00020 2\u0006\u00107\u001a\u00020 H\u0002¢\u0006\u0002\u00108J\u0006\u00109\u001a\u00020\u001aJ\u0018\u0010:\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lexpo/modules/securestore/SecureStoreModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "mAESEncryptor", "Lexpo/modules/securestore/encryptors/AESEncryptor;", "reactContext", "Landroid/content/Context;", "getReactContext", "()Landroid/content/Context;", "keyStore", "Ljava/security/KeyStore;", "hybridAESEncryptor", "Lexpo/modules/securestore/encryptors/HybridAESEncryptor;", "authenticationHelper", "Lexpo/modules/securestore/AuthenticationHelper;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "getItemImpl", "", "key", "options", "Lexpo/modules/securestore/SecureStoreOptions;", "(Ljava/lang/String;Lexpo/modules/securestore/SecureStoreOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readJSONEncodedItem", "prefs", "Landroid/content/SharedPreferences;", "(Ljava/lang/String;Landroid/content/SharedPreferences;Lexpo/modules/securestore/SecureStoreOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setItemImpl", "", "value", "keyIsInvalidated", "", "(Ljava/lang/String;Ljava/lang/String;Lexpo/modules/securestore/SecureStoreOptions;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveEncryptedItem", "encryptedItem", "Lorg/json/JSONObject;", AuthenticationHelper.REQUIRE_AUTHENTICATION_PROPERTY, "keychainService", "deleteItemImpl", "removeKeyFromKeystore", "keyStoreAlias", "removeAllEntriesUnderKeychainService", "getLegacyKeyEntry", ExifInterface.LONGITUDE_EAST, "Ljava/security/KeyStore$Entry;", "keyStoreEntryClass", "Ljava/lang/Class;", "encryptor", "Lexpo/modules/securestore/encryptors/KeyBasedEncryptor;", "(Ljava/lang/Class;Lexpo/modules/securestore/encryptors/KeyBasedEncryptor;Lexpo/modules/securestore/SecureStoreOptions;)Ljava/security/KeyStore$Entry;", "getKeyEntry", "(Ljava/lang/Class;Lexpo/modules/securestore/encryptors/KeyBasedEncryptor;Lexpo/modules/securestore/SecureStoreOptions;Z)Ljava/security/KeyStore$Entry;", "getOrCreateKeyEntry", "getKeyEntryCompat", SecureStoreModule.USES_KEYSTORE_SUFFIX_PROPERTY, "(Ljava/lang/Class;Lexpo/modules/securestore/encryptors/KeyBasedEncryptor;Lexpo/modules/securestore/SecureStoreOptions;ZZ)Ljava/security/KeyStore$Entry;", "getSharedPreferences", "createKeychainAwareKey", "Companion", "expo-secure-store_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class SecureStoreModule extends Module {
    public static final String AUTHENTICATED_KEYSTORE_SUFFIX = "keystoreAuthenticated";
    public static final String DEFAULT_KEYSTORE_ALIAS = "key_v1";
    private static final String KEYSTORE_ALIAS_PROPERTY = "keystoreAlias";
    private static final String KEYSTORE_PROVIDER = "AndroidKeyStore";
    private static final String SCHEME_PROPERTY = "scheme";
    private static final String SHARED_PREFERENCES_NAME = "SecureStore";
    public static final String TAG = "ExpoSecureStore";
    public static final String UNAUTHENTICATED_KEYSTORE_SUFFIX = "keystoreUnauthenticated";
    public static final String USES_KEYSTORE_SUFFIX_PROPERTY = "usesKeystoreSuffix";
    private AuthenticationHelper authenticationHelper;
    private HybridAESEncryptor hybridAESEncryptor;
    private KeyStore keyStore;
    private final AESEncryptor mAESEncryptor = new AESEncryptor();

    /* JADX INFO: renamed from: expo.modules.securestore.SecureStoreModule$readJSONEncodedItem$1, reason: invalid class name */
    /* JADX INFO: compiled from: SecureStoreModule.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.securestore.SecureStoreModule", f = "SecureStoreModule.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {145, 150}, m = "readJSONEncodedItem", n = {"key", "prefs", "options", "keychainAwareKey", "legacyEncryptedItemString", "currentEncryptedItemString", "encryptedItemString", "legacyReadFailedWarning", "encryptedItem", SecureStoreModule.SCHEME_PROPERTY, "secretKeyEntry", AuthenticationHelper.REQUIRE_AUTHENTICATION_PROPERTY, SecureStoreModule.USES_KEYSTORE_SUFFIX_PROPERTY, "key", "prefs", "options", "keychainAwareKey", "legacyEncryptedItemString", "currentEncryptedItemString", "encryptedItemString", "legacyReadFailedWarning", "encryptedItem", SecureStoreModule.SCHEME_PROPERTY, "privateKeyEntry", AuthenticationHelper.REQUIRE_AUTHENTICATION_PROPERTY, SecureStoreModule.USES_KEYSTORE_SUFFIX_PROPERTY}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "Z$0", "Z$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "Z$0", "Z$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
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
        boolean Z$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SecureStoreModule.this.readJSONEncodedItem(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.securestore.SecureStoreModule$setItemImpl$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SecureStoreModule.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.securestore.SecureStoreModule", f = "SecureStoreModule.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {204, 220}, m = "setItemImpl", n = {"key", "value", "options", "keychainAwareKey", "prefs", "secretKeyEntry", "keyIsInvalidated", "key", "value", "options", "keychainAwareKey", "prefs", "e", "keyIsInvalidated"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0"})
    static final class C09251 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C09251(Continuation<? super C09251> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SecureStoreModule.this.setItemImpl(null, null, null, false, this);
        }
    }

    public Context getReactContext() throws Exceptions.ReactContextLost {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.ReactContextLost();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        Object objM12684constructorimpl;
        Object objM12684constructorimpl2;
        Object objM12684constructorimpl3;
        Object objM12684constructorimpl4;
        Object objM12684constructorimpl5;
        Object objM12684constructorimpl6;
        Object objM12684constructorimpl7;
        Object objM12684constructorimpl8;
        Object objM12684constructorimpl9;
        Object objM12684constructorimpl10;
        Object objM12684constructorimpl11;
        Object objM12684constructorimpl12;
        UntypedAsyncFunctionComponent stringAsyncFunctionComponent;
        SecureStoreModule secureStoreModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (secureStoreModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(secureStoreModule);
            moduleDefinitionBuilder.Name(TAG);
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction = moduleDefinitionBuilder.AsyncFunction("setValueWithKeyAsync");
            String name = asyncFunctionBuilderAsyncFunction.getName();
            TypeConverterProvider converters = asyncFunctionBuilderAsyncFunction.getConverters();
            AnyType[] anyTypeArr = new AnyType[3];
            AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
            if (anyType == null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING_NULLABLE), new Function0<KType>() { // from class: expo.modules.securestore.SecureStoreModule$definition$lambda$7$$inlined$Coroutine$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(String.class);
                        }
                    }));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                    objM12684constructorimpl = null;
                }
                TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
                if (typeDescriptor == null) {
                    typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(String.class));
                }
                anyType = new AnyType(typeDescriptor, converters);
            }
            anyTypeArr[0] = anyType;
            AnyType anyType2 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
            if (anyType2 == null) {
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING_NULLABLE), new Function0<KType>() { // from class: expo.modules.securestore.SecureStoreModule$definition$lambda$7$$inlined$Coroutine$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(String.class);
                        }
                    }));
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.INSTANCE;
                    objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th2));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl2)) {
                    objM12684constructorimpl2 = null;
                }
                TypeDescriptor typeDescriptor2 = (TypeDescriptor) objM12684constructorimpl2;
                if (typeDescriptor2 == null) {
                    typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(String.class));
                }
                anyType2 = new AnyType(typeDescriptor2, converters);
            }
            anyTypeArr[1] = anyType2;
            AnyType anyType3 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(SecureStoreOptions.class), false));
            if (anyType3 == null) {
                try {
                    Result.Companion companion5 = Result.INSTANCE;
                    objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(SecureStoreOptions.class, false, SecureStoreOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.securestore.SecureStoreModule$definition$lambda$7$$inlined$Coroutine$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(SecureStoreOptions.class);
                        }
                    }));
                } catch (Throwable th3) {
                    Result.Companion companion6 = Result.INSTANCE;
                    objM12684constructorimpl3 = Result.m12684constructorimpl(ResultKt.createFailure(th3));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl3)) {
                    objM12684constructorimpl3 = null;
                }
                TypeDescriptor typeDescriptor3 = (TypeDescriptor) objM12684constructorimpl3;
                if (typeDescriptor3 == null) {
                    typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(SecureStoreOptions.class));
                }
                anyType3 = new AnyType(typeDescriptor3, converters);
            }
            anyTypeArr[2] = anyType3;
            asyncFunctionBuilderAsyncFunction.setAsyncFunctionComponent(new SuspendFunctionComponent(name, anyTypeArr, new SecureStoreModule$definition$lambda$7$$inlined$Coroutine$4(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction2 = moduleDefinitionBuilder.AsyncFunction("getValueWithKeyAsync");
            String name2 = asyncFunctionBuilderAsyncFunction2.getName();
            TypeConverterProvider converters2 = asyncFunctionBuilderAsyncFunction2.getConverters();
            AnyType[] anyTypeArr2 = new AnyType[2];
            AnyType anyType4 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType4 == null) {
                try {
                    Result.Companion companion7 = Result.INSTANCE;
                    objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.securestore.SecureStoreModule$definition$lambda$7$$inlined$Coroutine$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th4) {
                    Result.Companion companion8 = Result.INSTANCE;
                    objM12684constructorimpl4 = Result.m12684constructorimpl(ResultKt.createFailure(th4));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl4)) {
                    objM12684constructorimpl4 = null;
                }
                TypeDescriptor typeDescriptor4 = (TypeDescriptor) objM12684constructorimpl4;
                if (typeDescriptor4 == null) {
                    typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType4 = new AnyType(typeDescriptor4, converters2);
            }
            anyTypeArr2[0] = anyType4;
            AnyType anyType5 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(SecureStoreOptions.class), false));
            if (anyType5 == null) {
                try {
                    Result.Companion companion9 = Result.INSTANCE;
                    objM12684constructorimpl5 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(SecureStoreOptions.class, false, SecureStoreOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.securestore.SecureStoreModule$definition$lambda$7$$inlined$Coroutine$6
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(SecureStoreOptions.class);
                        }
                    }));
                } catch (Throwable th5) {
                    Result.Companion companion10 = Result.INSTANCE;
                    objM12684constructorimpl5 = Result.m12684constructorimpl(ResultKt.createFailure(th5));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl5)) {
                    objM12684constructorimpl5 = null;
                }
                TypeDescriptor typeDescriptor5 = (TypeDescriptor) objM12684constructorimpl5;
                if (typeDescriptor5 == null) {
                    typeDescriptor5 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(SecureStoreOptions.class));
                }
                anyType5 = new AnyType(typeDescriptor5, converters2);
            }
            anyTypeArr2[1] = anyType5;
            asyncFunctionBuilderAsyncFunction2.setAsyncFunctionComponent(new SuspendFunctionComponent(name2, anyTypeArr2, new SecureStoreModule$definition$lambda$7$$inlined$Coroutine$7(null, this)));
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            TypeConverterProvider converters3 = moduleDefinitionBuilder2.getConverters();
            AnyType[] anyTypeArr3 = new AnyType[3];
            AnyType anyType6 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
            if (anyType6 == null) {
                try {
                    Result.Companion companion11 = Result.INSTANCE;
                    objM12684constructorimpl6 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING_NULLABLE), new Function0<KType>() { // from class: expo.modules.securestore.SecureStoreModule$definition$lambda$7$$inlined$Function$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(String.class);
                        }
                    }));
                } catch (Throwable th6) {
                    Result.Companion companion12 = Result.INSTANCE;
                    objM12684constructorimpl6 = Result.m12684constructorimpl(ResultKt.createFailure(th6));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl6)) {
                    objM12684constructorimpl6 = null;
                }
                TypeDescriptor typeDescriptor6 = (TypeDescriptor) objM12684constructorimpl6;
                if (typeDescriptor6 == null) {
                    typeDescriptor6 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(String.class));
                }
                anyType6 = new AnyType(typeDescriptor6, converters3);
            }
            anyTypeArr3[0] = anyType6;
            AnyType anyType7 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
            if (anyType7 == null) {
                try {
                    Result.Companion companion13 = Result.INSTANCE;
                    objM12684constructorimpl7 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING_NULLABLE), new Function0<KType>() { // from class: expo.modules.securestore.SecureStoreModule$definition$lambda$7$$inlined$Function$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(String.class);
                        }
                    }));
                } catch (Throwable th7) {
                    Result.Companion companion14 = Result.INSTANCE;
                    objM12684constructorimpl7 = Result.m12684constructorimpl(ResultKt.createFailure(th7));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl7)) {
                    objM12684constructorimpl7 = null;
                }
                TypeDescriptor typeDescriptor7 = (TypeDescriptor) objM12684constructorimpl7;
                if (typeDescriptor7 == null) {
                    typeDescriptor7 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(String.class));
                }
                anyType7 = new AnyType(typeDescriptor7, converters3);
            }
            anyTypeArr3[1] = anyType7;
            AnyType anyType8 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(SecureStoreOptions.class), false));
            if (anyType8 == null) {
                try {
                    Result.Companion companion15 = Result.INSTANCE;
                    objM12684constructorimpl8 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(SecureStoreOptions.class, false, SecureStoreOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.securestore.SecureStoreModule$definition$lambda$7$$inlined$Function$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(SecureStoreOptions.class);
                        }
                    }));
                } catch (Throwable th8) {
                    Result.Companion companion16 = Result.INSTANCE;
                    objM12684constructorimpl8 = Result.m12684constructorimpl(ResultKt.createFailure(th8));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl8)) {
                    objM12684constructorimpl8 = null;
                }
                TypeDescriptor typeDescriptor8 = (TypeDescriptor) objM12684constructorimpl8;
                if (typeDescriptor8 == null) {
                    typeDescriptor8 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(SecureStoreOptions.class));
                }
                anyType8 = new AnyType(typeDescriptor8, converters3);
            }
            anyTypeArr3[2] = anyType8;
            ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
            ReturnType returnType = returnTypeProvider.getTypes().get(Unit.class);
            if (returnType == null) {
                JSTypeConverter<?> directConverter = ReturnTypeKt.getDirectConverter(Unit.class);
                if (directConverter == null) {
                    directConverter = ReturnTypeKt.getIndirectConverter(Unit.class, null);
                }
                ReturnType returnType2 = new ReturnType(directConverter);
                returnTypeProvider.getTypes().put(Unit.class, returnType2);
                returnType = returnType2;
            }
            moduleDefinitionBuilder2.getSyncFunctions().put("setValueWithKeySync", new SyncFunctionComponent("setValueWithKeySync", anyTypeArr3, returnType, new Function1<Object[], Object>() { // from class: expo.modules.securestore.SecureStoreModule$definition$lambda$7$$inlined$Function$4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) throws NullKeyException, InterruptedException {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    Object obj2 = objArr[1];
                    SecureStoreOptions secureStoreOptions = (SecureStoreOptions) objArr[2];
                    String str = (String) obj2;
                    String str2 = (String) obj;
                    if (str != null) {
                        BuildersKt__BuildersKt.runBlocking$default(null, new SecureStoreModule$definition$1$3$1(this.this$0, str, str2, secureStoreOptions, null), 1, null);
                        return Unit.INSTANCE;
                    }
                    throw new NullKeyException();
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            TypeConverterProvider converters4 = moduleDefinitionBuilder3.getConverters();
            AnyType[] anyTypeArr4 = new AnyType[2];
            AnyType anyType9 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType9 == null) {
                try {
                    Result.Companion companion17 = Result.INSTANCE;
                    objM12684constructorimpl9 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.securestore.SecureStoreModule$definition$lambda$7$$inlined$Function$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th9) {
                    Result.Companion companion18 = Result.INSTANCE;
                    objM12684constructorimpl9 = Result.m12684constructorimpl(ResultKt.createFailure(th9));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl9)) {
                    objM12684constructorimpl9 = null;
                }
                TypeDescriptor typeDescriptor9 = (TypeDescriptor) objM12684constructorimpl9;
                if (typeDescriptor9 == null) {
                    typeDescriptor9 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType9 = new AnyType(typeDescriptor9, converters4);
            }
            anyTypeArr4[0] = anyType9;
            AnyType anyType10 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(SecureStoreOptions.class), false));
            if (anyType10 == null) {
                try {
                    Result.Companion companion19 = Result.INSTANCE;
                    objM12684constructorimpl10 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(SecureStoreOptions.class, false, SecureStoreOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.securestore.SecureStoreModule$definition$lambda$7$$inlined$Function$6
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(SecureStoreOptions.class);
                        }
                    }));
                } catch (Throwable th10) {
                    Result.Companion companion20 = Result.INSTANCE;
                    objM12684constructorimpl10 = Result.m12684constructorimpl(ResultKt.createFailure(th10));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl10)) {
                    objM12684constructorimpl10 = null;
                }
                TypeDescriptor typeDescriptor10 = (TypeDescriptor) objM12684constructorimpl10;
                if (typeDescriptor10 == null) {
                    typeDescriptor10 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(SecureStoreOptions.class));
                }
                anyType10 = new AnyType(typeDescriptor10, converters4);
            }
            anyTypeArr4[1] = anyType10;
            ReturnTypeProvider returnTypeProvider2 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType3 = returnTypeProvider2.getTypes().get(String.class);
            if (returnType3 == null) {
                JSTypeConverter<?> directConverter2 = ReturnTypeKt.getDirectConverter(String.class);
                if (directConverter2 == null) {
                    directConverter2 = ReturnTypeKt.getIndirectConverter(String.class, null);
                }
                ReturnType returnType4 = new ReturnType(directConverter2);
                returnTypeProvider2.getTypes().put(String.class, returnType4);
                returnType3 = returnType4;
            }
            moduleDefinitionBuilder3.getSyncFunctions().put("getValueWithKeySync", new SyncFunctionComponent("getValueWithKeySync", anyTypeArr4, returnType3, new Function1<Object[], Object>() { // from class: expo.modules.securestore.SecureStoreModule$definition$lambda$7$$inlined$Function$7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    SecureStoreOptions secureStoreOptions = (SecureStoreOptions) objArr[1];
                    return (String) BuildersKt__BuildersKt.runBlocking$default(null, new SecureStoreModule$definition$1$4$1(this.this$0, (String) obj, secureStoreOptions, null), 1, null);
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            TypeConverterProvider converters5 = moduleDefinitionBuilder4.getConverters();
            AnyType[] anyTypeArr5 = new AnyType[2];
            AnyType anyType11 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType11 == null) {
                try {
                    Result.Companion companion21 = Result.INSTANCE;
                    objM12684constructorimpl11 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.securestore.SecureStoreModule$definition$lambda$7$$inlined$AsyncFunction$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th11) {
                    Result.Companion companion22 = Result.INSTANCE;
                    objM12684constructorimpl11 = Result.m12684constructorimpl(ResultKt.createFailure(th11));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl11)) {
                    objM12684constructorimpl11 = null;
                }
                TypeDescriptor typeDescriptor11 = (TypeDescriptor) objM12684constructorimpl11;
                if (typeDescriptor11 == null) {
                    typeDescriptor11 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType11 = new AnyType(typeDescriptor11, converters5);
            }
            anyTypeArr5[0] = anyType11;
            AnyType anyType12 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(SecureStoreOptions.class), false));
            if (anyType12 == null) {
                try {
                    Result.Companion companion23 = Result.INSTANCE;
                    objM12684constructorimpl12 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(SecureStoreOptions.class, false, SecureStoreOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.securestore.SecureStoreModule$definition$lambda$7$$inlined$AsyncFunction$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(SecureStoreOptions.class);
                        }
                    }));
                } catch (Throwable th12) {
                    Result.Companion companion24 = Result.INSTANCE;
                    objM12684constructorimpl12 = Result.m12684constructorimpl(ResultKt.createFailure(th12));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl12)) {
                    objM12684constructorimpl12 = null;
                }
                TypeDescriptor typeDescriptor12 = (TypeDescriptor) objM12684constructorimpl12;
                if (typeDescriptor12 == null) {
                    typeDescriptor12 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(SecureStoreOptions.class));
                }
                anyType12 = new AnyType(typeDescriptor12, converters5);
            }
            anyTypeArr5[1] = anyType12;
            Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: expo.modules.securestore.SecureStoreModule$definition$lambda$7$$inlined$AsyncFunction$3
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] objArr) throws CodedException {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    SecureStoreOptions secureStoreOptions = (SecureStoreOptions) objArr[1];
                    String str = (String) obj;
                    try {
                        this.this$0.deleteItemImpl(str, secureStoreOptions);
                        return Unit.INSTANCE;
                    } catch (CodedException e) {
                        throw e;
                    } catch (Exception e2) {
                        throw new DeleteException(e2.getMessage(), str, secureStoreOptions.getKeychainService(), e2);
                    }
                }
            };
            if (Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                stringAsyncFunctionComponent = new IntAsyncFunctionComponent("deleteValueWithKeyAsync", anyTypeArr5, function1);
            } else if (Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                stringAsyncFunctionComponent = new BoolAsyncFunctionComponent("deleteValueWithKeyAsync", anyTypeArr5, function1);
            } else if (Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                stringAsyncFunctionComponent = new DoubleAsyncFunctionComponent("deleteValueWithKeyAsync", anyTypeArr5, function1);
            } else if (Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                stringAsyncFunctionComponent = new FloatAsyncFunctionComponent("deleteValueWithKeyAsync", anyTypeArr5, function1);
            } else {
                stringAsyncFunctionComponent = Intrinsics.areEqual(Unit.class, String.class) ? new StringAsyncFunctionComponent("deleteValueWithKeyAsync", anyTypeArr5, function1) : new UntypedAsyncFunctionComponent("deleteValueWithKeyAsync", anyTypeArr5, function1);
            }
            moduleDefinitionBuilder4.getAsyncFunctions().put("deleteValueWithKeyAsync", stringAsyncFunctionComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr6 = new AnyType[0];
            ReturnTypeProvider returnTypeProvider3 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType5 = returnTypeProvider3.getTypes().get(Object.class);
            if (returnType5 == null) {
                JSTypeConverter<?> directConverter3 = ReturnTypeKt.getDirectConverter(Object.class);
                if (directConverter3 == null) {
                    directConverter3 = ReturnTypeKt.getIndirectConverter(Object.class, null);
                }
                ReturnType returnType6 = new ReturnType(directConverter3);
                returnTypeProvider3.getTypes().put(Object.class, returnType6);
                returnType5 = returnType6;
            }
            moduleDefinitionBuilder5.getSyncFunctions().put("canUseBiometricAuthentication", new SyncFunctionComponent("canUseBiometricAuthentication", anyTypeArr6, returnType5, new Function1<Object[], Object>() { // from class: expo.modules.securestore.SecureStoreModule$definition$lambda$7$$inlined$FunctionWithoutArgs$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    boolean z;
                    Intrinsics.checkNotNullParameter(it, "it");
                    try {
                        AuthenticationHelper authenticationHelper = this.this$0.authenticationHelper;
                        if (authenticationHelper == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("authenticationHelper");
                            authenticationHelper = null;
                        }
                        authenticationHelper.assertBiometricsSupport();
                        z = true;
                    } catch (AuthenticationException unused) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new Function0<Unit>() { // from class: expo.modules.securestore.SecureStoreModule$definition$lambda$7$$inlined$OnCreate$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() throws NoSuchAlgorithmException, IOException, java.security.KeyStoreException, CertificateException {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() throws NoSuchAlgorithmException, IOException, java.security.KeyStoreException, CertificateException {
                    this.this$0.authenticationHelper = new AuthenticationHelper(this.this$0.getReactContext(), this.this$0.getAppContext().getLegacyModuleRegistry());
                    this.this$0.hybridAESEncryptor = new HybridAESEncryptor(this.this$0.getReactContext(), this.this$0.mAESEncryptor);
                    KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                    keyStore.load(null);
                    SecureStoreModule secureStoreModule2 = this.this$0;
                    Intrinsics.checkNotNull(keyStore);
                    secureStoreModule2.keyStore = keyStore;
                }
            }));
            ModuleDefinitionData moduleDefinitionDataBuildModule = moduleDefinitionBuilder.buildModule();
            Trace.endSection();
            return moduleDefinitionDataBuildModule;
        } catch (Throwable th13) {
            Trace.endSection();
            throw th13;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getItemImpl(String str, SecureStoreOptions secureStoreOptions, Continuation<? super String> continuation) {
        SharedPreferences sharedPreferences = getSharedPreferences();
        if (sharedPreferences.contains(createKeychainAwareKey(str, secureStoreOptions.getKeychainService()))) {
            return readJSONEncodedItem(str, sharedPreferences, secureStoreOptions, continuation);
        }
        if (sharedPreferences.contains(str)) {
            return readJSONEncodedItem(str, sharedPreferences, secureStoreOptions, continuation);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:101:0x026c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0020  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26, types: [expo.modules.securestore.SecureStoreOptions] */
    /* JADX WARN: Type inference failed for: r3v28, types: [expo.modules.securestore.SecureStoreOptions] */
    /* JADX WARN: Type inference failed for: r3v30, types: [expo.modules.securestore.SecureStoreOptions] */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v37 */
    /* JADX WARN: Type inference failed for: r3v38 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v45 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.content.SharedPreferences, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v27, types: [expo.modules.securestore.SecureStoreModule] */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    public final Object readJSONEncodedItem(String str, SharedPreferences sharedPreferences, SecureStoreOptions secureStoreOptions, Continuation<? super String> continuation) throws CodedException {
        AnonymousClass1 anonymousClass1;
        ?? r3;
        String str2;
        Object obj;
        SecureStoreModule secureStoreModule;
        ?? r4;
        ?? r7;
        SecureStoreModule secureStoreModule2;
        SecureStoreOptions secureStoreOptions2;
        String str3;
        SecureStoreModule secureStoreModule3 = this;
        String str4 = str;
        ?? r8 = sharedPreferences;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = secureStoreModule3.new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = secureStoreModule3.new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object obj2 = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj2);
                String strCreateKeychainAwareKey = secureStoreModule3.createKeychainAwareKey(str4, secureStoreOptions.getKeychainService());
                String string = r8.getString(str4, null);
                String string2 = r8.getString(strCreateKeychainAwareKey, null);
                r3 = string2 == null ? string : string2;
                if (string2 == null) {
                    str2 = ". This exception occurred when trying to read a value saved with an older version of `expo-secure-store`. It usually means that the keychain you provided is incorrect, but it might be raised because the keychain used to decrypt this key has been invalidated and deleted. If you are confident that the keychain you provided is correct and want to avoid this error in the future you should save a new value under this key or use `deleteItemImpl()` and remove the existing one.";
                } else {
                    str2 = "";
                }
                String str5 = str2;
                if (r3 == 0) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject((String) r3);
                    String strOptString = jSONObject.optString(SCHEME_PROPERTY);
                    Intrinsics.checkNotNull(strOptString);
                    if (strOptString.length() <= 0) {
                        strOptString = null;
                    }
                    if (strOptString == null) {
                        throw new DecryptException("Could not find the encryption scheme used for key: " + str4, str4, secureStoreOptions.getKeychainService(), null, 8, null);
                    }
                    obj = null;
                    boolean zOptBoolean = jSONObject.optBoolean(AuthenticationHelper.REQUIRE_AUTHENTICATION_PROPERTY, false);
                    boolean zOptBoolean2 = jSONObject.optBoolean(USES_KEYSTORE_SUFFIX_PROPERTY, false);
                    try {
                        try {
                            try {
                                try {
                                    try {
                                        if (Intrinsics.areEqual(strOptString, AESEncryptor.NAME)) {
                                            try {
                                                String str6 = strOptString;
                                                ?? r12 = r3;
                                                KeyStore.SecretKeyEntry secretKeyEntry = (KeyStore.SecretKeyEntry) secureStoreModule3.getKeyEntryCompat(KeyStore.SecretKeyEntry.class, secureStoreModule3.mAESEncryptor, secureStoreOptions, zOptBoolean, zOptBoolean2);
                                                if (secretKeyEntry == null) {
                                                    Log.w(TAG, "An entry was found for key " + str4 + " under keychain " + secureStoreOptions.getKeychainService() + ", but there is no corresponding KeyStore key. This situation occurs when the app is reinstalled. The value will be removed to avoid future errors. Returning null");
                                                    secureStoreModule3.deleteItemImpl(str4, secureStoreOptions);
                                                    return null;
                                                }
                                                AESEncryptor aESEncryptor = secureStoreModule3.mAESEncryptor;
                                                AuthenticationHelper authenticationHelper = secureStoreModule3.authenticationHelper;
                                                if (authenticationHelper == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("authenticationHelper");
                                                    authenticationHelper = null;
                                                }
                                                anonymousClass2.L$0 = str4;
                                                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(r8);
                                                anonymousClass2.L$2 = secureStoreOptions;
                                                anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(strCreateKeychainAwareKey);
                                                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(string);
                                                anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(string2);
                                                anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(r12);
                                                anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str5);
                                                anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(jSONObject);
                                                anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(str6);
                                                anonymousClass2.L$10 = SpillingKt.nullOutSpilledVariable(secretKeyEntry);
                                                anonymousClass2.Z$0 = zOptBoolean;
                                                anonymousClass2.Z$1 = zOptBoolean2;
                                                anonymousClass2.label = 1;
                                                AuthenticationHelper authenticationHelper2 = authenticationHelper;
                                                secureStoreModule2 = secureStoreModule3;
                                                try {
                                                    Object objDecryptItem = aESEncryptor.decryptItem(str4, jSONObject, secretKeyEntry, secureStoreOptions, authenticationHelper2, (Continuation<? super String>) anonymousClass2);
                                                    if (objDecryptItem == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    return objDecryptItem;
                                                } catch (BadPaddingException unused) {
                                                    str4 = str4;
                                                    r4 = secureStoreOptions;
                                                    r7 = secureStoreModule2;
                                                    Log.w(TAG, "Failed to decrypt the entry for " + str4 + " under keychain " + r4.getKeychainService() + ". The entry in shared preferences is out of sync with the keystore. It will be removed, returning null.");
                                                    r7.deleteItemImpl(str4, r4);
                                                    return obj;
                                                } catch (GeneralSecurityException e) {
                                                    e = e;
                                                    str4 = str4;
                                                    r3 = secureStoreOptions;
                                                    throw new DecryptException(e.getMessage(), str4, r3.getKeychainService(), e);
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    str4 = str4;
                                                    r3 = secureStoreOptions;
                                                    throw new DecryptException(e.getMessage(), str4, r3.getKeychainService(), e);
                                                }
                                            } catch (BadPaddingException unused2) {
                                                r3 = secureStoreOptions;
                                                r7 = secureStoreModule3;
                                                r4 = r3;
                                                Log.w(TAG, "Failed to decrypt the entry for " + str4 + " under keychain " + r4.getKeychainService() + ". The entry in shared preferences is out of sync with the keystore. It will be removed, returning null.");
                                                r7.deleteItemImpl(str4, r4);
                                                return obj;
                                            }
                                        }
                                        secureStoreModule2 = secureStoreModule3;
                                        ?? r13 = r3;
                                        try {
                                            String str7 = strOptString;
                                            try {
                                                if (Intrinsics.areEqual(str7, HybridAESEncryptor.NAME)) {
                                                    HybridAESEncryptor hybridAESEncryptor = secureStoreModule2.hybridAESEncryptor;
                                                    if (hybridAESEncryptor == null) {
                                                        try {
                                                            Intrinsics.throwUninitializedPropertyAccessException("hybridAESEncryptor");
                                                            hybridAESEncryptor = null;
                                                        } catch (BadPaddingException unused3) {
                                                            r4 = secureStoreOptions;
                                                            r7 = secureStoreModule2;
                                                            Log.w(TAG, "Failed to decrypt the entry for " + str4 + " under keychain " + r4.getKeychainService() + ". The entry in shared preferences is out of sync with the keystore. It will be removed, returning null.");
                                                            r7.deleteItemImpl(str4, r4);
                                                            return obj;
                                                        }
                                                    }
                                                    HybridAESEncryptor hybridAESEncryptor2 = hybridAESEncryptor;
                                                    secureStoreModule3 = secureStoreModule2;
                                                    KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) secureStoreModule3.getKeyEntryCompat(KeyStore.PrivateKeyEntry.class, hybridAESEncryptor2, secureStoreOptions, zOptBoolean, zOptBoolean2);
                                                    if (privateKeyEntry == null) {
                                                        return null;
                                                    }
                                                    HybridAESEncryptor hybridAESEncryptor3 = secureStoreModule3.hybridAESEncryptor;
                                                    if (hybridAESEncryptor3 == null) {
                                                        Intrinsics.throwUninitializedPropertyAccessException("hybridAESEncryptor");
                                                        hybridAESEncryptor3 = null;
                                                    }
                                                    AuthenticationHelper authenticationHelper3 = secureStoreModule3.authenticationHelper;
                                                    if (authenticationHelper3 == null) {
                                                        Intrinsics.throwUninitializedPropertyAccessException("authenticationHelper");
                                                        authenticationHelper3 = null;
                                                    }
                                                    anonymousClass2.L$0 = str4;
                                                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(r8);
                                                    anonymousClass2.L$2 = secureStoreOptions;
                                                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(strCreateKeychainAwareKey);
                                                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(string);
                                                    anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(string2);
                                                    anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(r13);
                                                    anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str5);
                                                    anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(jSONObject);
                                                    anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(str7);
                                                    anonymousClass2.L$10 = SpillingKt.nullOutSpilledVariable(privateKeyEntry);
                                                    anonymousClass2.Z$0 = zOptBoolean;
                                                    anonymousClass2.Z$1 = zOptBoolean2;
                                                    anonymousClass2.label = 2;
                                                    Object objDecryptItem2 = hybridAESEncryptor3.decryptItem(str4, jSONObject, privateKeyEntry, secureStoreOptions, authenticationHelper3, (Continuation<? super String>) anonymousClass2);
                                                    if (objDecryptItem2 == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    return objDecryptItem2;
                                                    r4 = secureStoreOptions;
                                                    r7 = secureStoreModule;
                                                } else {
                                                    r8 = secureStoreModule2;
                                                    try {
                                                        throw new DecryptException("The item for key " + str4 + " in SecureStore has an unknown encoding scheme " + str7, str4, secureStoreOptions.getKeychainService(), null, 8, null);
                                                    } catch (BadPaddingException unused4) {
                                                        str7 = str4;
                                                        r4 = secureStoreOptions;
                                                        str4 = str7;
                                                        r7 = r8;
                                                        Log.w(TAG, "Failed to decrypt the entry for " + str4 + " under keychain " + r4.getKeychainService() + ". The entry in shared preferences is out of sync with the keystore. It will be removed, returning null.");
                                                        r7.deleteItemImpl(str4, r4);
                                                        return obj;
                                                    } catch (GeneralSecurityException e3) {
                                                        e = e3;
                                                        str7 = str4;
                                                        r3 = secureStoreOptions;
                                                        str4 = str7;
                                                        throw new DecryptException(e.getMessage(), str4, r3.getKeychainService(), e);
                                                    } catch (Exception e4) {
                                                        e = e4;
                                                        str7 = str4;
                                                        r3 = secureStoreOptions;
                                                        str4 = str7;
                                                        throw new DecryptException(e.getMessage(), str4, r3.getKeychainService(), e);
                                                    }
                                                }
                                            } catch (BadPaddingException unused5) {
                                            } catch (GeneralSecurityException e5) {
                                                e = e5;
                                            } catch (Exception e6) {
                                                e = e6;
                                            }
                                        } catch (BadPaddingException unused6) {
                                            secureStoreModule = secureStoreModule2;
                                            r4 = secureStoreOptions;
                                            r7 = secureStoreModule;
                                        }
                                    } catch (GeneralSecurityException e7) {
                                        e = e7;
                                    } catch (Exception e8) {
                                        e = e8;
                                    }
                                } catch (BadPaddingException unused7) {
                                } catch (GeneralSecurityException e9) {
                                    e = e9;
                                } catch (Exception e10) {
                                    e = e10;
                                }
                            } catch (BadPaddingException unused8) {
                                secureStoreModule = secureStoreModule3;
                            }
                        } catch (KeyPermanentlyInvalidatedException unused9) {
                            Log.w(TAG, "The requested key has been permanently invalidated. Returning null");
                            return obj;
                        }
                    } catch (GeneralSecurityException e11) {
                        e = e11;
                    } catch (Exception e12) {
                        e = e12;
                    }
                    Log.w(TAG, "Failed to decrypt the entry for " + str4 + " under keychain " + r4.getKeychainService() + ". The entry in shared preferences is out of sync with the keystore. It will be removed, returning null.");
                    r7.deleteItemImpl(str4, r4);
                    return obj;
                } catch (JSONException e13) {
                    throw new DecryptException("Could not parse the encrypted JSON item in SecureStore: " + e13.getMessage(), str4, secureStoreOptions.getKeychainService(), e13);
                }
            }
            if (i == 1) {
                boolean z = anonymousClass2.Z$1;
                boolean z2 = anonymousClass2.Z$0;
                secureStoreOptions2 = (SecureStoreOptions) anonymousClass2.L$2;
                str3 = (String) anonymousClass2.L$0;
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                boolean z3 = anonymousClass2.Z$1;
                boolean z4 = anonymousClass2.Z$0;
                secureStoreOptions2 = (SecureStoreOptions) anonymousClass2.L$2;
                str3 = (String) anonymousClass2.L$0;
            }
            try {
                ResultKt.throwOnFailure(obj2);
                return obj2;
            } catch (KeyPermanentlyInvalidatedException unused10) {
                obj = null;
                Log.w(TAG, "The requested key has been permanently invalidated. Returning null");
                return obj;
            } catch (BadPaddingException unused11) {
                r7 = secureStoreModule3;
                str4 = str3;
                obj = null;
                r4 = secureStoreOptions2;
            } catch (GeneralSecurityException e14) {
                e = e14;
                str4 = str3;
                r3 = secureStoreOptions2;
                throw new DecryptException(e.getMessage(), str4, r3.getKeychainService(), e);
            } catch (Exception e15) {
                e = e15;
                str4 = str3;
                r3 = secureStoreOptions2;
                throw new DecryptException(e.getMessage(), str4, r3.getKeychainService(), e);
            }
        } catch (CodedException e16) {
            throw e16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:55:0x0148 A[Catch: Exception -> 0x0156, GeneralSecurityException -> 0x0158, KeyPermanentlyInvalidatedException -> 0x015a, CodedException -> 0x0178, TRY_LEAVE, TryCatch #10 {CodedException -> 0x0178, blocks: (B:16:0x0075, B:53:0x012c, B:55:0x0148, B:34:0x00ca, B:42:0x00e9, B:44:0x0100, B:47:0x0107, B:49:0x011d), top: B:90:0x002e }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001e  */
    /* JADX WARN: Code duplicated, block: B:81:0x0196  */
    /* JADX WARN: Code duplicated, block: B:86:0x01d2  */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01cc, code lost:
    
        if (setItemImpl(r2, r3, r4, true, r7) == r9) goto L83;
     */
    /* JADX WARN: Instruction removed from duplicated block: B:86:0x01d2, please report this as an issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object setItemImpl(java.lang.String r16, java.lang.String r17, expo.modules.securestore.SecureStoreOptions r18, boolean r19, kotlin.coroutines.Continuation<? super kotlin.Unit> r20) throws expo.modules.kotlin.exception.CodedException {
        /*
            Method dump skipped, instruction units count: 497
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.securestore.SecureStoreModule.setItemImpl(java.lang.String, java.lang.String, expo.modules.securestore.SecureStoreOptions, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean saveEncryptedItem(JSONObject encryptedItem, SharedPreferences prefs, String key, boolean requireAuthentication, String keychainService) throws JSONException, WriteException {
        encryptedItem.put(USES_KEYSTORE_SUFFIX_PROPERTY, true);
        encryptedItem.put(KEYSTORE_ALIAS_PROPERTY, keychainService);
        encryptedItem.put(AuthenticationHelper.REQUIRE_AUTHENTICATION_PROPERTY, requireAuthentication);
        String string = encryptedItem.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        if (string.length() == 0) {
            throw new WriteException("Could not JSON-encode the encrypted item for SecureStore - the string " + string + " is null or empty", key, keychainService, null, 8, null);
        }
        return prefs.edit().putString(key, string).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void deleteItemImpl(String key, SecureStoreOptions options) throws DeleteException {
        SharedPreferences sharedPreferences = getSharedPreferences();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getReactContext());
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
        if (!SecureStoreModuleKt.removeItem(sharedPreferences, defaultSharedPreferences, key, createKeychainAwareKey(key, options.getKeychainService()))) {
            throw new DeleteException("Could not delete the item from SecureStore", key, options.getKeychainService(), null, 8, null);
        }
    }

    private final void removeKeyFromKeystore(String keyStoreAlias, String keychainService) throws java.security.KeyStoreException {
        KeyStore keyStore = this.keyStore;
        if (keyStore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keyStore");
            keyStore = null;
        }
        keyStore.deleteEntry(keyStoreAlias);
        removeAllEntriesUnderKeychainService(keychainService);
    }

    private final void removeAllEntriesUnderKeychainService(String keychainService) {
        SharedPreferences sharedPreferences = getSharedPreferences();
        Map<String, ?> all = sharedPreferences.getAll();
        Intrinsics.checkNotNullExpressionValue(all, "getAll(...)");
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            String str = value instanceof String ? (String) value : null;
            if (str != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String strOptString = jSONObject.optString(KEYSTORE_ALIAS_PROPERTY);
                    if (strOptString != null && jSONObject.optBoolean(AuthenticationHelper.REQUIRE_AUTHENTICATION_PROPERTY, false) && Intrinsics.areEqual(keychainService, strOptString)) {
                        sharedPreferences.edit().remove(key).apply();
                        Log.w(TAG, "Removing entry: " + key + " due to the encryption key being deleted");
                    }
                } catch (JSONException unused) {
                }
            }
        }
    }

    private final <E extends KeyStore.Entry> E getLegacyKeyEntry(Class<E> keyStoreEntryClass, KeyBasedEncryptor<E> encryptor, SecureStoreOptions options) throws NoSuchAlgorithmException, java.security.KeyStoreException, UnrecoverableEntryException {
        String keyStoreAlias = encryptor.getKeyStoreAlias(options);
        KeyStore keyStore = this.keyStore;
        if (keyStore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keyStore");
            keyStore = null;
        }
        if (!keyStore.containsAlias(encryptor.getKeyStoreAlias(options))) {
            return null;
        }
        KeyStore keyStore2 = this.keyStore;
        if (keyStore2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keyStore");
            keyStore2 = null;
        }
        KeyStore.Entry entry = keyStore2.getEntry(keyStoreAlias, null);
        if (keyStoreEntryClass.isInstance(entry)) {
            return keyStoreEntryClass.cast(entry);
        }
        return null;
    }

    private final <E extends KeyStore.Entry> E getKeyEntry(Class<E> keyStoreEntryClass, KeyBasedEncryptor<E> encryptor, SecureStoreOptions options, boolean requireAuthentication) throws KeyStoreException, NoSuchAlgorithmException, java.security.KeyStoreException, UnrecoverableEntryException {
        String extendedKeyStoreAlias = encryptor.getExtendedKeyStoreAlias(options, requireAuthentication);
        KeyStore keyStore = this.keyStore;
        if (keyStore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keyStore");
            keyStore = null;
        }
        if (!keyStore.containsAlias(extendedKeyStoreAlias)) {
            return null;
        }
        KeyStore keyStore2 = this.keyStore;
        if (keyStore2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keyStore");
            keyStore2 = null;
        }
        KeyStore.Entry entry = keyStore2.getEntry(extendedKeyStoreAlias, null);
        if (!keyStoreEntryClass.isInstance(entry)) {
            throw new KeyStoreException("The entry for the keystore alias \"" + extendedKeyStoreAlias + "\" is not a " + keyStoreEntryClass.getSimpleName());
        }
        E eCast = keyStoreEntryClass.cast(entry);
        if (eCast != null) {
            return eCast;
        }
        throw new KeyStoreException("The entry for the keystore alias \"" + extendedKeyStoreAlias + "\" couldn't be cast to the correct class");
    }

    private final <E extends KeyStore.Entry> E getOrCreateKeyEntry(Class<E> keyStoreEntryClass, KeyBasedEncryptor<E> encryptor, SecureStoreOptions options, boolean requireAuthentication) throws AuthenticationException {
        E e = (E) getKeyEntry(keyStoreEntryClass, encryptor, options, requireAuthentication);
        if (e != null) {
            return e;
        }
        KeyStore keyStore = null;
        if (requireAuthentication) {
            AuthenticationHelper authenticationHelper = this.authenticationHelper;
            if (authenticationHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("authenticationHelper");
                authenticationHelper = null;
            }
            authenticationHelper.assertBiometricsSupport();
        }
        KeyStore keyStore2 = this.keyStore;
        if (keyStore2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keyStore");
        } else {
            keyStore = keyStore2;
        }
        return (E) encryptor.initializeKeyStoreEntry(keyStore, options);
    }

    private final <E extends KeyStore.Entry> E getKeyEntryCompat(Class<E> keyStoreEntryClass, KeyBasedEncryptor<E> encryptor, SecureStoreOptions options, boolean requireAuthentication, boolean usesKeystoreSuffix) {
        if (usesKeystoreSuffix) {
            return (E) getKeyEntry(keyStoreEntryClass, encryptor, options, requireAuthentication);
        }
        return (E) getLegacyKeyEntry(keyStoreEntryClass, encryptor, options);
    }

    public final SharedPreferences getSharedPreferences() {
        SharedPreferences sharedPreferences = getReactContext().getSharedPreferences(SHARED_PREFERENCES_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        return sharedPreferences;
    }

    private final String createKeychainAwareKey(String key, String keychainService) {
        return keychainService + "-" + key;
    }
}

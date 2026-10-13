package expo.modules.crypto.aes;

import android.util.Base64;
import androidx.tracing.Trace;
import expo.modules.crypto.aes.enums.DataFormat;
import expo.modules.crypto.aes.enums.KeyEncoding;
import expo.modules.crypto.aes.enums.KeySize;
import expo.modules.crypto.aes.extensions.ByteArrayExtensionsKt;
import expo.modules.crypto.aes.extensions.CipherExtensionsKt;
import expo.modules.crypto.aes.objects.EncryptionKey;
import expo.modules.crypto.aes.objects.SealedData;
import expo.modules.crypto.aes.records.CiphertextOptions;
import expo.modules.crypto.aes.records.DecryptOptions;
import expo.modules.crypto.aes.records.EncryptOptions;
import expo.modules.crypto.aes.records.SealedDataConfig;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.classcomponent.ClassComponentBuilder;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.functions.UntypedAsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.objects.PropertyComponentBuilderWithThis;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeCache;
import expo.modules.kotlin.types.Either;
import expo.modules.kotlin.types.JSTypeConverter;
import expo.modules.kotlin.types.ReturnType;
import expo.modules.kotlin.types.ReturnTypeKt;
import expo.modules.kotlin.types.ReturnTypeProvider;
import expo.modules.kotlin.types.TypeConverterProvider;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt;
import expo.modules.securestore.encryptors.AESEncryptor;
import io.github.expo.pika.PTypeDescriptor;
import io.github.expo.pika.PTypeDescriptorRegistry;
import io.ktor.http.ContentDisposition;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.text.HexExtensionsKt;
import kotlin.text.HexFormat;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AesCryptoModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J2\u0010\f\u001a\u00020\r2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u0002`\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\"\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u001aH\u0002JN\u0010\u001b\u001a\u00020\r2\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u0002`\u00122\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u0002`\u00122\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u000fH\u0002J\u001c\u0010 \u001a\u00020\u0010*\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u0002`\u0012H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006!"}, d2 = {"Lexpo/modules/crypto/aes/AesCryptoModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "rng", "Ljava/security/SecureRandom;", "getRng", "()Ljava/security/SecureRandom;", "rng$delegate", "Lkotlin/Lazy;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "encrypt", "Lexpo/modules/crypto/aes/objects/SealedData;", "plaintext", "Lexpo/modules/kotlin/types/Either;", "", "", "Lexpo/modules/crypto/aes/BinaryInput;", "key", "Lexpo/modules/crypto/aes/objects/EncryptionKey;", "options", "Lexpo/modules/crypto/aes/records/EncryptOptions;", "decrypt", "", "sealedData", "Lexpo/modules/crypto/aes/records/DecryptOptions;", "sealedDataFromParts", AESEncryptor.IV_PROPERTY, "ciphertext", "tag", "", "toBytes", "expo-crypto_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AesCryptoModule extends Module {

    /* JADX INFO: renamed from: rng$delegate, reason: from kotlin metadata */
    private final Lazy rng = LazyKt.lazy(new Function0() { // from class: expo.modules.crypto.aes.AesCryptoModule$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AesCryptoModule.rng_delegate$lambda$0();
        }
    });

    /* JADX INFO: compiled from: AesCryptoModule.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KeyEncoding.values().length];
            try {
                iArr[KeyEncoding.BASE64.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KeyEncoding.HEX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final SecureRandom getRng() {
        return (SecureRandom) this.rng.getValue();
    }

    static final SecureRandom rng_delegate$lambda$0() {
        return new SecureRandom();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v28 */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v4 */
    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        int i;
        Object objM12684constructorimpl;
        Object objM12684constructorimpl2;
        Object objM12684constructorimpl3;
        UntypedAsyncFunctionComponent stringAsyncFunctionComponent;
        Object objM12684constructorimpl4;
        Object objM12684constructorimpl5;
        Object objM12684constructorimpl6;
        UntypedAsyncFunctionComponent stringAsyncFunctionComponent2;
        Object objM12684constructorimpl7;
        AnyType anyType;
        boolean z;
        Object objM12684constructorimpl8;
        UntypedAsyncFunctionComponent stringAsyncFunctionComponent3;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        Object objM12684constructorimpl9;
        Object objM12684constructorimpl10;
        UntypedAsyncFunctionComponent stringAsyncFunctionComponent4;
        Object objM12684constructorimpl11;
        UntypedAsyncFunctionComponent stringAsyncFunctionComponent5;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2;
        Object objM12684constructorimpl12;
        Object objM12684constructorimpl13;
        UntypedAsyncFunctionComponent stringAsyncFunctionComponent6;
        Object objM12684constructorimpl14;
        AnyType anyType2;
        Object objM12684constructorimpl15;
        Object objM12684constructorimpl16;
        Object objM12684constructorimpl17;
        Object objM12684constructorimpl18;
        Object objM12684constructorimpl19;
        Object objM12684constructorimpl20;
        Object objM12684constructorimpl21;
        UntypedAsyncFunctionComponent stringAsyncFunctionComponent7;
        Object objM12684constructorimpl22;
        Object objM12684constructorimpl23;
        UntypedAsyncFunctionComponent stringAsyncFunctionComponent8;
        Object objM12684constructorimpl24;
        Object objM12684constructorimpl25;
        UntypedAsyncFunctionComponent stringAsyncFunctionComponent9;
        Object objM12684constructorimpl26;
        Object objM12684constructorimpl27;
        UntypedAsyncFunctionComponent stringAsyncFunctionComponent10;
        AesCryptoModule aesCryptoModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (aesCryptoModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(aesCryptoModule);
            moduleDefinitionBuilder.Name("ExpoCryptoAES");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            TypeConverterProvider converters = moduleDefinitionBuilder2.getConverters();
            AnyType[] anyTypeArr = new AnyType[3];
            AnyType anyType3 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Either.class), false));
            if (anyType3 != null) {
                i = 2;
            } else {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    i = 2;
                    try {
                        objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(Either.class, false, Arrays.asList(PTypeDescriptorRegistry.getOrCreateConcrete(byte[].class, false, null), PTypeDescriptorRegistry.STRING), null)), new Function0<KType>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$$inlined$AsyncFunction$1
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(Either.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(byte[].class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)));
                            }
                        }));
                    } catch (Throwable th) {
                        th = th;
                        Result.Companion companion2 = Result.INSTANCE;
                        objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
                    }
                } catch (Throwable th2) {
                    th = th2;
                    i = 2;
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                    objM12684constructorimpl = null;
                }
                TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
                if (typeDescriptor == null) {
                    typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Either.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(byte[].class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
                }
                anyType3 = new AnyType(typeDescriptor, converters);
            }
            anyTypeArr[0] = anyType3;
            AnyType anyType4 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(EncryptionKey.class), false));
            if (anyType4 == null) {
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(EncryptionKey.class, false, null)), new Function0<KType>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$$inlined$AsyncFunction$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(EncryptionKey.class);
                        }
                    }));
                } catch (Throwable th3) {
                    Result.Companion companion4 = Result.INSTANCE;
                    objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th3));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl2)) {
                    objM12684constructorimpl2 = null;
                }
                TypeDescriptor typeDescriptor2 = (TypeDescriptor) objM12684constructorimpl2;
                if (typeDescriptor2 == null) {
                    typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(EncryptionKey.class));
                }
                anyType4 = new AnyType(typeDescriptor2, converters);
            }
            anyTypeArr[1] = anyType4;
            AnyType anyType5 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(EncryptOptions.class), true));
            if (anyType5 == null) {
                try {
                    Result.Companion companion5 = Result.INSTANCE;
                    objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(EncryptOptions.class, true, EncryptOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$$inlined$AsyncFunction$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(EncryptOptions.class);
                        }
                    }));
                } catch (Throwable th4) {
                    Result.Companion companion6 = Result.INSTANCE;
                    objM12684constructorimpl3 = Result.m12684constructorimpl(ResultKt.createFailure(th4));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl3)) {
                    objM12684constructorimpl3 = null;
                }
                TypeDescriptor typeDescriptor3 = (TypeDescriptor) objM12684constructorimpl3;
                if (typeDescriptor3 == null) {
                    typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(EncryptOptions.class));
                }
                anyType5 = new AnyType(typeDescriptor3, converters);
            }
            anyTypeArr[i] = anyType5;
            Function1<Object[], SealedData> function1 = new Function1<Object[], SealedData>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$$inlined$AsyncFunction$4
                @Override // kotlin.jvm.functions.Function1
                public final SealedData invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    Object obj2 = objArr[1];
                    EncryptOptions encryptOptions = (EncryptOptions) objArr[2];
                    Either either = (Either) obj;
                    return this.$receiver$inlined.encrypt(either, (EncryptionKey) obj2, encryptOptions);
                }
            };
            if (Intrinsics.areEqual(SealedData.class, Integer.TYPE)) {
                stringAsyncFunctionComponent = new IntAsyncFunctionComponent("encryptAsync", anyTypeArr, function1);
            } else if (Intrinsics.areEqual(SealedData.class, Boolean.TYPE)) {
                stringAsyncFunctionComponent = new BoolAsyncFunctionComponent("encryptAsync", anyTypeArr, function1);
            } else if (Intrinsics.areEqual(SealedData.class, Double.TYPE)) {
                stringAsyncFunctionComponent = new DoubleAsyncFunctionComponent("encryptAsync", anyTypeArr, function1);
            } else if (Intrinsics.areEqual(SealedData.class, Float.TYPE)) {
                stringAsyncFunctionComponent = new FloatAsyncFunctionComponent("encryptAsync", anyTypeArr, function1);
            } else {
                stringAsyncFunctionComponent = Intrinsics.areEqual(SealedData.class, String.class) ? new StringAsyncFunctionComponent("encryptAsync", anyTypeArr, function1) : new UntypedAsyncFunctionComponent("encryptAsync", anyTypeArr, function1);
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("encryptAsync", stringAsyncFunctionComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            TypeConverterProvider converters2 = moduleDefinitionBuilder3.getConverters();
            AnyType[] anyTypeArr2 = new AnyType[3];
            AnyType anyType6 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(SealedData.class), false));
            if (anyType6 == null) {
                try {
                    Result.Companion companion7 = Result.INSTANCE;
                    objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(SealedData.class, false, null)), new Function0<KType>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$$inlined$AsyncFunction$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(SealedData.class);
                        }
                    }));
                } catch (Throwable th5) {
                    Result.Companion companion8 = Result.INSTANCE;
                    objM12684constructorimpl4 = Result.m12684constructorimpl(ResultKt.createFailure(th5));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl4)) {
                    objM12684constructorimpl4 = null;
                }
                TypeDescriptor typeDescriptor4 = (TypeDescriptor) objM12684constructorimpl4;
                if (typeDescriptor4 == null) {
                    typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(SealedData.class));
                }
                anyType6 = new AnyType(typeDescriptor4, converters2);
            }
            anyTypeArr2[0] = anyType6;
            AnyType anyType7 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(EncryptionKey.class), false));
            if (anyType7 == null) {
                try {
                    Result.Companion companion9 = Result.INSTANCE;
                    objM12684constructorimpl5 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(EncryptionKey.class, false, null)), new Function0<KType>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$$inlined$AsyncFunction$6
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(EncryptionKey.class);
                        }
                    }));
                } catch (Throwable th6) {
                    Result.Companion companion10 = Result.INSTANCE;
                    objM12684constructorimpl5 = Result.m12684constructorimpl(ResultKt.createFailure(th6));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl5)) {
                    objM12684constructorimpl5 = null;
                }
                TypeDescriptor typeDescriptor5 = (TypeDescriptor) objM12684constructorimpl5;
                if (typeDescriptor5 == null) {
                    typeDescriptor5 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(EncryptionKey.class));
                }
                anyType7 = new AnyType(typeDescriptor5, converters2);
            }
            anyTypeArr2[1] = anyType7;
            AnyType anyType8 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(DecryptOptions.class), true));
            if (anyType8 == null) {
                try {
                    Result.Companion companion11 = Result.INSTANCE;
                    objM12684constructorimpl6 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(DecryptOptions.class, true, DecryptOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$$inlined$AsyncFunction$7
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(DecryptOptions.class);
                        }
                    }));
                } catch (Throwable th7) {
                    Result.Companion companion12 = Result.INSTANCE;
                    objM12684constructorimpl6 = Result.m12684constructorimpl(ResultKt.createFailure(th7));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl6)) {
                    objM12684constructorimpl6 = null;
                }
                TypeDescriptor typeDescriptor6 = (TypeDescriptor) objM12684constructorimpl6;
                if (typeDescriptor6 == null) {
                    typeDescriptor6 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(DecryptOptions.class));
                }
                anyType8 = new AnyType(typeDescriptor6, converters2);
            }
            anyTypeArr2[i] = anyType8;
            Function1<Object[], Object> function2 = new Function1<Object[], Object>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$$inlined$AsyncFunction$8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    Object obj2 = objArr[1];
                    DecryptOptions decryptOptions = (DecryptOptions) objArr[2];
                    SealedData sealedData = (SealedData) obj;
                    return this.$receiver$inlined.decrypt(sealedData, (EncryptionKey) obj2, decryptOptions);
                }
            };
            if (Intrinsics.areEqual(Object.class, Integer.TYPE)) {
                stringAsyncFunctionComponent2 = new IntAsyncFunctionComponent("decryptAsync", anyTypeArr2, function2);
            } else if (Intrinsics.areEqual(Object.class, Boolean.TYPE)) {
                stringAsyncFunctionComponent2 = new BoolAsyncFunctionComponent("decryptAsync", anyTypeArr2, function2);
            } else if (Intrinsics.areEqual(Object.class, Double.TYPE)) {
                stringAsyncFunctionComponent2 = new DoubleAsyncFunctionComponent("decryptAsync", anyTypeArr2, function2);
            } else if (Intrinsics.areEqual(Object.class, Float.TYPE)) {
                stringAsyncFunctionComponent2 = new FloatAsyncFunctionComponent("decryptAsync", anyTypeArr2, function2);
            } else {
                stringAsyncFunctionComponent2 = Intrinsics.areEqual(Object.class, String.class) ? new StringAsyncFunctionComponent("decryptAsync", anyTypeArr2, function2) : new UntypedAsyncFunctionComponent("decryptAsync", anyTypeArr2, function2);
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("decryptAsync", stringAsyncFunctionComponent2);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(EncryptionKey.class);
            Module module = moduleDefinitionBuilder4.getModule();
            if (module == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            AppContext appContext = module.getAppContext();
            AnyType anyType9 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(EncryptionKey.class), false));
            if (anyType9 != null) {
                anyType = anyType9;
            } else {
                try {
                    Result.Companion companion13 = Result.INSTANCE;
                    objM12684constructorimpl7 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(EncryptionKey.class, false, null)), new Function0<KType>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$$inlined$Class$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(EncryptionKey.class);
                        }
                    }));
                } catch (Throwable th8) {
                    Result.Companion companion14 = Result.INSTANCE;
                    objM12684constructorimpl7 = Result.m12684constructorimpl(ResultKt.createFailure(th8));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl7)) {
                    objM12684constructorimpl7 = null;
                }
                TypeDescriptor typeDescriptor7 = (TypeDescriptor) objM12684constructorimpl7;
                if (typeDescriptor7 == null) {
                    typeDescriptor7 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(EncryptionKey.class));
                }
                anyType = new AnyType(typeDescriptor7, null);
            }
            ClassComponentBuilder classComponentBuilder = new ClassComponentBuilder(appContext, "EncryptionKey", orCreateKotlinClass, anyType, moduleDefinitionBuilder4.getConverters());
            AnyType[] anyTypeArr3 = new AnyType[0];
            ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
            ReturnType returnType = returnTypeProvider.getTypes().get(Object.class);
            if (returnType == null) {
                JSTypeConverter<?> directConverter = ReturnTypeKt.getDirectConverter(Object.class);
                if (directConverter == null) {
                    directConverter = ReturnTypeKt.getIndirectConverter(Object.class, null);
                }
                ReturnType returnType2 = new ReturnType(directConverter);
                returnTypeProvider.getTypes().put(Object.class, returnType2);
                returnType = returnType2;
            }
            classComponentBuilder.setConstructor(new SyncFunctionComponent("constructor", anyTypeArr3, returnType, new Function1<Object[], Object>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$lambda$8$$inlined$Constructor$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) throws Exceptions.IllegalArgument {
                    Intrinsics.checkNotNullParameter(it, "it");
                    throw new Exceptions.IllegalArgument("EncryptionKey constructor cannot be used directly", null, 2, null);
                }
            }));
            if (Intrinsics.areEqual(KeySize.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("generate", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$lambda$8$$inlined$StaticAsyncFunction$1
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        new EncryptionKey((KeySize) promise);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
                z = false;
            } else {
                TypeConverterProvider converters3 = classComponentBuilder.getConverters();
                AnyType[] anyTypeArr4 = new AnyType[1];
                z = false;
                AnyType anyType10 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(KeySize.class), true));
                if (anyType10 == null) {
                    try {
                        Result.Companion companion15 = Result.INSTANCE;
                        objM12684constructorimpl8 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(KeySize.class, true, null)), new Function0<KType>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$lambda$8$$inlined$StaticAsyncFunction$2
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.nullableTypeOf(KeySize.class);
                            }
                        }));
                    } catch (Throwable th9) {
                        Result.Companion companion16 = Result.INSTANCE;
                        objM12684constructorimpl8 = Result.m12684constructorimpl(ResultKt.createFailure(th9));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl8)) {
                        objM12684constructorimpl8 = null;
                    }
                    TypeDescriptor typeDescriptor8 = (TypeDescriptor) objM12684constructorimpl8;
                    if (typeDescriptor8 == null) {
                        typeDescriptor8 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(KeySize.class));
                    }
                    anyType10 = new AnyType(typeDescriptor8, converters3);
                }
                anyTypeArr4[0] = anyType10;
                Function1<Object[], EncryptionKey> function3 = new Function1<Object[], EncryptionKey>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$lambda$8$$inlined$StaticAsyncFunction$3
                    @Override // kotlin.jvm.functions.Function1
                    public final EncryptionKey invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        KeySize keySize = (KeySize) objArr[0];
                        if (keySize == null) {
                            keySize = KeySize.AES256;
                        }
                        return new EncryptionKey(keySize);
                    }
                };
                if (Intrinsics.areEqual(EncryptionKey.class, Integer.TYPE)) {
                    stringAsyncFunctionComponent3 = new IntAsyncFunctionComponent("generate", anyTypeArr4, function3);
                } else if (Intrinsics.areEqual(EncryptionKey.class, Boolean.TYPE)) {
                    stringAsyncFunctionComponent3 = new BoolAsyncFunctionComponent("generate", anyTypeArr4, function3);
                } else if (Intrinsics.areEqual(EncryptionKey.class, Double.TYPE)) {
                    stringAsyncFunctionComponent3 = new DoubleAsyncFunctionComponent("generate", anyTypeArr4, function3);
                } else if (Intrinsics.areEqual(EncryptionKey.class, Float.TYPE)) {
                    stringAsyncFunctionComponent3 = new FloatAsyncFunctionComponent("generate", anyTypeArr4, function3);
                } else {
                    stringAsyncFunctionComponent3 = Intrinsics.areEqual(EncryptionKey.class, String.class) ? new StringAsyncFunctionComponent("generate", anyTypeArr4, function3) : new UntypedAsyncFunctionComponent("generate", anyTypeArr4, function3);
                }
                asyncFunctionWithPromiseComponent = stringAsyncFunctionComponent3;
            }
            classComponentBuilder.getStaticAsyncFunctions().put("generate", asyncFunctionWithPromiseComponent);
            TypeConverterProvider converters4 = classComponentBuilder.getConverters();
            AnyType[] anyTypeArr5 = new AnyType[i];
            AnyType anyType11 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Either.class), Boolean.valueOf(z)));
            ?? r18 = z;
            if (anyType11 == null) {
                try {
                    Result.Companion companion17 = Result.INSTANCE;
                    PTypeDescriptor[] pTypeDescriptorArr = new PTypeDescriptor[2];
                    boolean z2 = z ? 1 : 0;
                    pTypeDescriptorArr[z2 ? 1 : 0] = PTypeDescriptorRegistry.getOrCreateConcrete(byte[].class, z2, null);
                    pTypeDescriptorArr[1] = PTypeDescriptorRegistry.STRING;
                    objM12684constructorimpl9 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(Either.class, z2, Arrays.asList(pTypeDescriptorArr), null)), new Function0<KType>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$lambda$8$$inlined$StaticAsyncFunction$4
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Either.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(byte[].class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)));
                        }
                    }));
                } catch (Throwable th10) {
                    Result.Companion companion18 = Result.INSTANCE;
                    objM12684constructorimpl9 = Result.m12684constructorimpl(ResultKt.createFailure(th10));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl9)) {
                    objM12684constructorimpl9 = null;
                }
                TypeDescriptor typeDescriptor9 = (TypeDescriptor) objM12684constructorimpl9;
                if (typeDescriptor9 == null) {
                    typeDescriptor9 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Either.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(byte[].class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
                }
                anyType11 = new AnyType(typeDescriptor9, converters4);
                r18 = 0;
            }
            anyTypeArr5[r18] = anyType11;
            AnyType anyType12 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(KeyEncoding.class), true));
            if (anyType12 == null) {
                try {
                    Result.Companion companion19 = Result.INSTANCE;
                    objM12684constructorimpl10 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(KeyEncoding.class, true, null)), new Function0<KType>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$lambda$8$$inlined$StaticAsyncFunction$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(KeyEncoding.class);
                        }
                    }));
                } catch (Throwable th11) {
                    Result.Companion companion20 = Result.INSTANCE;
                    objM12684constructorimpl10 = Result.m12684constructorimpl(ResultKt.createFailure(th11));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl10)) {
                    objM12684constructorimpl10 = null;
                }
                TypeDescriptor typeDescriptor10 = (TypeDescriptor) objM12684constructorimpl10;
                if (typeDescriptor10 == null) {
                    typeDescriptor10 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(KeyEncoding.class));
                }
                anyType12 = new AnyType(typeDescriptor10, converters4);
            }
            anyTypeArr5[1] = anyType12;
            Function1<Object[], EncryptionKey> function4 = new Function1<Object[], EncryptionKey>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$lambda$8$$inlined$StaticAsyncFunction$6
                @Override // kotlin.jvm.functions.Function1
                public final EncryptionKey invoke(Object[] objArr) throws MissingStringEncodingException {
                    byte[] bArrDecode;
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    KeyEncoding keyEncoding = (KeyEncoding) objArr[1];
                    Either either = (Either) obj;
                    if (either.isFirstType(Reflection.getOrCreateKotlinClass(byte[].class))) {
                        bArrDecode = (byte[]) either.getFirstType(Reflection.getOrCreateKotlinClass(byte[].class));
                    } else {
                        String str = (String) either.getSecondType(Reflection.getOrCreateKotlinClass(String.class));
                        int i2 = keyEncoding == null ? -1 : AesCryptoModule.WhenMappings.$EnumSwitchMapping$0[keyEncoding.ordinal()];
                        if (i2 == -1) {
                            throw new MissingStringEncodingException();
                        }
                        if (i2 == 1) {
                            bArrDecode = Base64.decode(str, 2);
                        } else {
                            if (i2 != 2) {
                                throw new NoWhenBranchMatchedException();
                            }
                            String lowerCase = str.toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                            bArrDecode = HexExtensionsKt.hexToByteArray(StringsKt.substringAfter$default(lowerCase, "0x", (String) null, 2, (Object) null), HexFormat.INSTANCE.getDefault());
                        }
                    }
                    Intrinsics.checkNotNull(bArrDecode);
                    return new EncryptionKey(bArrDecode);
                }
            };
            if (Intrinsics.areEqual(EncryptionKey.class, Integer.TYPE)) {
                stringAsyncFunctionComponent4 = new IntAsyncFunctionComponent("import", anyTypeArr5, function4);
            } else if (Intrinsics.areEqual(EncryptionKey.class, Boolean.TYPE)) {
                stringAsyncFunctionComponent4 = new BoolAsyncFunctionComponent("import", anyTypeArr5, function4);
            } else if (Intrinsics.areEqual(EncryptionKey.class, Double.TYPE)) {
                stringAsyncFunctionComponent4 = new DoubleAsyncFunctionComponent("import", anyTypeArr5, function4);
            } else if (Intrinsics.areEqual(EncryptionKey.class, Float.TYPE)) {
                stringAsyncFunctionComponent4 = new FloatAsyncFunctionComponent("import", anyTypeArr5, function4);
            } else {
                stringAsyncFunctionComponent4 = Intrinsics.areEqual(EncryptionKey.class, String.class) ? new StringAsyncFunctionComponent("import", anyTypeArr5, function4) : new UntypedAsyncFunctionComponent("import", anyTypeArr5, function4);
            }
            classComponentBuilder.getStaticAsyncFunctions().put("import", stringAsyncFunctionComponent4);
            ClassComponentBuilder classComponentBuilder2 = classComponentBuilder;
            if (Intrinsics.areEqual(EncryptionKey.class, Promise.class)) {
                asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("bytes", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$lambda$8$$inlined$AsyncFunction$1
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        ((EncryptionKey) promise).getBytes();
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                TypeConverterProvider converters5 = classComponentBuilder2.getConverters();
                AnyType[] anyTypeArr6 = new AnyType[1];
                AnyType anyType13 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(EncryptionKey.class), false));
                if (anyType13 == null) {
                    try {
                        Result.Companion companion21 = Result.INSTANCE;
                        objM12684constructorimpl11 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(EncryptionKey.class, false, null)), new Function0<KType>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$lambda$8$$inlined$AsyncFunction$2
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(EncryptionKey.class);
                            }
                        }));
                    } catch (Throwable th12) {
                        Result.Companion companion22 = Result.INSTANCE;
                        objM12684constructorimpl11 = Result.m12684constructorimpl(ResultKt.createFailure(th12));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl11)) {
                        objM12684constructorimpl11 = null;
                    }
                    TypeDescriptor typeDescriptor11 = (TypeDescriptor) objM12684constructorimpl11;
                    if (typeDescriptor11 == null) {
                        typeDescriptor11 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(EncryptionKey.class));
                    }
                    anyType13 = new AnyType(typeDescriptor11, converters5);
                }
                anyTypeArr6[0] = anyType13;
                Function1<Object[], byte[]> function5 = new Function1<Object[], byte[]>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$lambda$8$$inlined$AsyncFunction$3
                    @Override // kotlin.jvm.functions.Function1
                    public final byte[] invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        return ((EncryptionKey) objArr[0]).getBytes();
                    }
                };
                if (Intrinsics.areEqual(byte[].class, Integer.TYPE)) {
                    stringAsyncFunctionComponent5 = new IntAsyncFunctionComponent("bytes", anyTypeArr6, function5);
                } else if (Intrinsics.areEqual(byte[].class, Boolean.TYPE)) {
                    stringAsyncFunctionComponent5 = new BoolAsyncFunctionComponent("bytes", anyTypeArr6, function5);
                } else if (Intrinsics.areEqual(byte[].class, Double.TYPE)) {
                    stringAsyncFunctionComponent5 = new DoubleAsyncFunctionComponent("bytes", anyTypeArr6, function5);
                } else if (Intrinsics.areEqual(byte[].class, Float.TYPE)) {
                    stringAsyncFunctionComponent5 = new FloatAsyncFunctionComponent("bytes", anyTypeArr6, function5);
                } else {
                    stringAsyncFunctionComponent5 = Intrinsics.areEqual(byte[].class, String.class) ? new StringAsyncFunctionComponent("bytes", anyTypeArr6, function5) : new UntypedAsyncFunctionComponent("bytes", anyTypeArr6, function5);
                }
                asyncFunctionWithPromiseComponent2 = stringAsyncFunctionComponent5;
            }
            classComponentBuilder2.getAsyncFunctions().put("bytes", asyncFunctionWithPromiseComponent2);
            ClassComponentBuilder classComponentBuilder3 = classComponentBuilder;
            TypeConverterProvider converters6 = classComponentBuilder3.getConverters();
            AnyType[] anyTypeArr7 = new AnyType[2];
            AnyType anyType14 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(EncryptionKey.class), false));
            if (anyType14 == null) {
                try {
                    Result.Companion companion23 = Result.INSTANCE;
                    objM12684constructorimpl12 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(EncryptionKey.class, false, null)), new Function0<KType>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$lambda$8$$inlined$AsyncFunction$4
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(EncryptionKey.class);
                        }
                    }));
                } catch (Throwable th13) {
                    Result.Companion companion24 = Result.INSTANCE;
                    objM12684constructorimpl12 = Result.m12684constructorimpl(ResultKt.createFailure(th13));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl12)) {
                    objM12684constructorimpl12 = null;
                }
                TypeDescriptor typeDescriptor12 = (TypeDescriptor) objM12684constructorimpl12;
                if (typeDescriptor12 == null) {
                    typeDescriptor12 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(EncryptionKey.class));
                }
                anyType14 = new AnyType(typeDescriptor12, converters6);
            }
            anyTypeArr7[0] = anyType14;
            AnyType anyType15 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(KeyEncoding.class), false));
            if (anyType15 == null) {
                try {
                    Result.Companion companion25 = Result.INSTANCE;
                    objM12684constructorimpl13 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(KeyEncoding.class, false, null)), new Function0<KType>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$lambda$8$$inlined$AsyncFunction$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(KeyEncoding.class);
                        }
                    }));
                } catch (Throwable th14) {
                    Result.Companion companion26 = Result.INSTANCE;
                    objM12684constructorimpl13 = Result.m12684constructorimpl(ResultKt.createFailure(th14));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl13)) {
                    objM12684constructorimpl13 = null;
                }
                TypeDescriptor typeDescriptor13 = (TypeDescriptor) objM12684constructorimpl13;
                if (typeDescriptor13 == null) {
                    typeDescriptor13 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(KeyEncoding.class));
                }
                anyType15 = new AnyType(typeDescriptor13, converters6);
            }
            anyTypeArr7[1] = anyType15;
            Function1<Object[], String> function6 = new Function1<Object[], String>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$lambda$8$$inlined$AsyncFunction$6
                @Override // kotlin.jvm.functions.Function1
                public final String invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    return ByteArrayExtensionsKt.encoded(((EncryptionKey) obj).getBytes(), (KeyEncoding) objArr[1]);
                }
            };
            if (Intrinsics.areEqual(String.class, Integer.TYPE)) {
                stringAsyncFunctionComponent6 = new IntAsyncFunctionComponent("encoded", anyTypeArr7, function6);
            } else if (Intrinsics.areEqual(String.class, Boolean.TYPE)) {
                stringAsyncFunctionComponent6 = new BoolAsyncFunctionComponent("encoded", anyTypeArr7, function6);
            } else if (Intrinsics.areEqual(String.class, Double.TYPE)) {
                stringAsyncFunctionComponent6 = new DoubleAsyncFunctionComponent("encoded", anyTypeArr7, function6);
            } else if (Intrinsics.areEqual(String.class, Float.TYPE)) {
                stringAsyncFunctionComponent6 = new FloatAsyncFunctionComponent("encoded", anyTypeArr7, function6);
            } else {
                stringAsyncFunctionComponent6 = Intrinsics.areEqual(String.class, String.class) ? new StringAsyncFunctionComponent("encoded", anyTypeArr7, function6) : new UntypedAsyncFunctionComponent("encoded", anyTypeArr7, function6);
            }
            classComponentBuilder3.getAsyncFunctions().put("encoded", stringAsyncFunctionComponent6);
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis = new PropertyComponentBuilderWithThis(classComponentBuilder.getOwnerType().getTypeDescriptor(), ContentDisposition.Parameters.Size);
            AnyType[] anyTypeArr8 = {new AnyType(propertyComponentBuilderWithThis.getThisType(), null, 2, null)};
            ReturnTypeProvider returnTypeProvider2 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType3 = returnTypeProvider2.getTypes().get(KeySize.class);
            if (returnType3 == null) {
                JSTypeConverter<?> directConverter2 = ReturnTypeKt.getDirectConverter(KeySize.class);
                if (directConverter2 == null) {
                    directConverter2 = ReturnTypeKt.getIndirectConverter(KeySize.class, null);
                }
                ReturnType returnType4 = new ReturnType(directConverter2);
                returnTypeProvider2.getTypes().put(KeySize.class, returnType4);
                returnType3 = returnType4;
            }
            SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("get", anyTypeArr8, returnType3, new Function1<Object[], Object>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$lambda$8$$inlined$Property$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((EncryptionKey) it[0]).getKeySize();
                }
            });
            syncFunctionComponent.setOwnerType(propertyComponentBuilderWithThis.getThisType());
            syncFunctionComponent.setCanTakeOwner(true);
            propertyComponentBuilderWithThis.setGetter(syncFunctionComponent);
            classComponentBuilder.getProperties().put(ContentDisposition.Parameters.Size, propertyComponentBuilderWithThis);
            moduleDefinitionBuilder4.getClassData().add(classComponentBuilder.buildClass());
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(SealedData.class);
            Module module2 = moduleDefinitionBuilder5.getModule();
            if (module2 == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            AppContext appContext2 = module2.getAppContext();
            AnyType anyType16 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(SealedData.class), false));
            if (anyType16 != null) {
                anyType2 = anyType16;
            } else {
                try {
                    Result.Companion companion27 = Result.INSTANCE;
                    objM12684constructorimpl14 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(SealedData.class, false, null)), new Function0<KType>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$$inlined$Class$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(SealedData.class);
                        }
                    }));
                } catch (Throwable th15) {
                    Result.Companion companion28 = Result.INSTANCE;
                    objM12684constructorimpl14 = Result.m12684constructorimpl(ResultKt.createFailure(th15));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl14)) {
                    objM12684constructorimpl14 = null;
                }
                TypeDescriptor typeDescriptor14 = (TypeDescriptor) objM12684constructorimpl14;
                if (typeDescriptor14 == null) {
                    typeDescriptor14 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(SealedData.class));
                }
                anyType2 = new AnyType(typeDescriptor14, null);
            }
            ClassComponentBuilder classComponentBuilder4 = new ClassComponentBuilder(appContext2, "SealedData", orCreateKotlinClass2, anyType2, moduleDefinitionBuilder5.getConverters());
            AnyType[] anyTypeArr9 = new AnyType[0];
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
            classComponentBuilder4.setConstructor(new SyncFunctionComponent("constructor", anyTypeArr9, returnType5, new Function1<Object[], Object>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$lambda$19$$inlined$Constructor$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) throws Exceptions.IllegalArgument {
                    Intrinsics.checkNotNullParameter(it, "it");
                    throw new Exceptions.IllegalArgument("SealedData constructor cannot be used directly", null, 2, null);
                }
            }));
            TypeConverterProvider converters7 = classComponentBuilder4.getConverters();
            AnyType[] anyTypeArr10 = new AnyType[3];
            AnyType anyType17 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Either.class), false));
            if (anyType17 == null) {
                try {
                    Result.Companion companion29 = Result.INSTANCE;
                    objM12684constructorimpl15 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(Either.class, false, Arrays.asList(PTypeDescriptorRegistry.getOrCreateConcrete(byte[].class, false, null), PTypeDescriptorRegistry.STRING), null)), new Function0<KType>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$lambda$19$$inlined$StaticFunction$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Either.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(byte[].class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)));
                        }
                    }));
                } catch (Throwable th16) {
                    Result.Companion companion30 = Result.INSTANCE;
                    objM12684constructorimpl15 = Result.m12684constructorimpl(ResultKt.createFailure(th16));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl15)) {
                    objM12684constructorimpl15 = null;
                }
                TypeDescriptor typeDescriptor15 = (TypeDescriptor) objM12684constructorimpl15;
                if (typeDescriptor15 == null) {
                    typeDescriptor15 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Either.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(byte[].class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
                }
                anyType17 = new AnyType(typeDescriptor15, converters7);
            }
            anyTypeArr10[0] = anyType17;
            AnyType anyType18 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Either.class), false));
            if (anyType18 == null) {
                try {
                    Result.Companion companion31 = Result.INSTANCE;
                    objM12684constructorimpl16 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(Either.class, false, Arrays.asList(PTypeDescriptorRegistry.getOrCreateConcrete(byte[].class, false, null), PTypeDescriptorRegistry.STRING), null)), new Function0<KType>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$lambda$19$$inlined$StaticFunction$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Either.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(byte[].class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)));
                        }
                    }));
                } catch (Throwable th17) {
                    Result.Companion companion32 = Result.INSTANCE;
                    objM12684constructorimpl16 = Result.m12684constructorimpl(ResultKt.createFailure(th17));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl16)) {
                    objM12684constructorimpl16 = null;
                }
                TypeDescriptor typeDescriptor16 = (TypeDescriptor) objM12684constructorimpl16;
                if (typeDescriptor16 == null) {
                    typeDescriptor16 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Either.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(byte[].class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
                }
                anyType18 = new AnyType(typeDescriptor16, converters7);
            }
            anyTypeArr10[1] = anyType18;
            AnyType anyType19 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Either.class), true));
            if (anyType19 == null) {
                try {
                    Result.Companion companion33 = Result.INSTANCE;
                    objM12684constructorimpl17 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(Either.class, true, Arrays.asList(PTypeDescriptorRegistry.getOrCreateConcrete(byte[].class, false, null), PTypeDescriptorRegistry.INT), null)), new Function0<KType>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$lambda$19$$inlined$StaticFunction$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Either.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(byte[].class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Integer.TYPE)));
                        }
                    }));
                } catch (Throwable th18) {
                    Result.Companion companion34 = Result.INSTANCE;
                    objM12684constructorimpl17 = Result.m12684constructorimpl(ResultKt.createFailure(th18));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl17)) {
                    objM12684constructorimpl17 = null;
                }
                TypeDescriptor typeDescriptor17 = (TypeDescriptor) objM12684constructorimpl17;
                if (typeDescriptor17 == null) {
                    typeDescriptor17 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Either.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(byte[].class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Integer.TYPE))));
                }
                anyType19 = new AnyType(typeDescriptor17, converters7);
            }
            anyTypeArr10[2] = anyType19;
            ReturnTypeProvider returnTypeProvider4 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType7 = returnTypeProvider4.getTypes().get(SealedData.class);
            if (returnType7 == null) {
                JSTypeConverter<?> directConverter4 = ReturnTypeKt.getDirectConverter(SealedData.class);
                if (directConverter4 == null) {
                    directConverter4 = ReturnTypeKt.getIndirectConverter(SealedData.class, null);
                }
                ReturnType returnType8 = new ReturnType(directConverter4);
                returnTypeProvider4.getTypes().put(SealedData.class, returnType8);
                returnType7 = returnType8;
            }
            classComponentBuilder4.getStaticSyncFunctions().put("fromParts", new SyncFunctionComponent("fromParts", anyTypeArr10, returnType7, new Function1<Object[], Object>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$lambda$19$$inlined$StaticFunction$4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    Object obj2 = objArr[1];
                    Either either = (Either) objArr[2];
                    Either either2 = (Either) obj;
                    return this.$receiver$inlined.sealedDataFromParts(either2, (Either) obj2, either);
                }
            }));
            TypeConverterProvider converters8 = classComponentBuilder4.getConverters();
            AnyType[] anyTypeArr11 = new AnyType[2];
            AnyType anyType20 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Either.class), false));
            if (anyType20 == null) {
                try {
                    Result.Companion companion35 = Result.INSTANCE;
                    objM12684constructorimpl18 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(Either.class, false, Arrays.asList(PTypeDescriptorRegistry.getOrCreateConcrete(byte[].class, false, null), PTypeDescriptorRegistry.STRING), null)), new Function0<KType>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$lambda$19$$inlined$StaticFunction$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Either.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(byte[].class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)));
                        }
                    }));
                } catch (Throwable th19) {
                    Result.Companion companion36 = Result.INSTANCE;
                    objM12684constructorimpl18 = Result.m12684constructorimpl(ResultKt.createFailure(th19));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl18)) {
                    objM12684constructorimpl18 = null;
                }
                TypeDescriptor typeDescriptor18 = (TypeDescriptor) objM12684constructorimpl18;
                if (typeDescriptor18 == null) {
                    typeDescriptor18 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Either.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(byte[].class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
                }
                anyType20 = new AnyType(typeDescriptor18, converters8);
            }
            anyTypeArr11[0] = anyType20;
            AnyType anyType21 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(SealedDataConfig.class), true));
            if (anyType21 == null) {
                try {
                    Result.Companion companion37 = Result.INSTANCE;
                    objM12684constructorimpl19 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(SealedDataConfig.class, true, SealedDataConfig.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$lambda$19$$inlined$StaticFunction$6
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(SealedDataConfig.class);
                        }
                    }));
                } catch (Throwable th20) {
                    Result.Companion companion38 = Result.INSTANCE;
                    objM12684constructorimpl19 = Result.m12684constructorimpl(ResultKt.createFailure(th20));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl19)) {
                    objM12684constructorimpl19 = null;
                }
                TypeDescriptor typeDescriptor19 = (TypeDescriptor) objM12684constructorimpl19;
                if (typeDescriptor19 == null) {
                    typeDescriptor19 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(SealedDataConfig.class));
                }
                anyType21 = new AnyType(typeDescriptor19, converters8);
            }
            anyTypeArr11[1] = anyType21;
            ReturnTypeProvider returnTypeProvider5 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType9 = returnTypeProvider5.getTypes().get(SealedData.class);
            if (returnType9 == null) {
                JSTypeConverter<?> directConverter5 = ReturnTypeKt.getDirectConverter(SealedData.class);
                if (directConverter5 == null) {
                    directConverter5 = ReturnTypeKt.getIndirectConverter(SealedData.class, null);
                }
                ReturnType returnType10 = new ReturnType(directConverter5);
                returnTypeProvider5.getTypes().put(SealedData.class, returnType10);
                returnType9 = returnType10;
            }
            classComponentBuilder4.getStaticSyncFunctions().put("fromCombined", new SyncFunctionComponent("fromCombined", anyTypeArr11, returnType9, new Function1<Object[], Object>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$lambda$19$$inlined$StaticFunction$7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    SealedDataConfig sealedDataConfig = (SealedDataConfig) objArr[1];
                    Either either = (Either) obj;
                    if (sealedDataConfig == null) {
                        sealedDataConfig = new SealedDataConfig(0, 0, 3, null);
                    }
                    return new SealedData(sealedDataConfig, this.this$0.toBytes(either));
                }
            }));
            ClassComponentBuilder classComponentBuilder5 = classComponentBuilder4;
            TypeConverterProvider converters9 = classComponentBuilder5.getConverters();
            AnyType[] anyTypeArr12 = new AnyType[2];
            AnyType anyType22 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(SealedData.class), false));
            if (anyType22 == null) {
                try {
                    Result.Companion companion39 = Result.INSTANCE;
                    objM12684constructorimpl20 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(SealedData.class, false, null)), new Function0<KType>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$lambda$19$$inlined$AsyncFunction$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(SealedData.class);
                        }
                    }));
                } catch (Throwable th21) {
                    Result.Companion companion40 = Result.INSTANCE;
                    objM12684constructorimpl20 = Result.m12684constructorimpl(ResultKt.createFailure(th21));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl20)) {
                    objM12684constructorimpl20 = null;
                }
                TypeDescriptor typeDescriptor20 = (TypeDescriptor) objM12684constructorimpl20;
                if (typeDescriptor20 == null) {
                    typeDescriptor20 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(SealedData.class));
                }
                anyType22 = new AnyType(typeDescriptor20, converters9);
            }
            anyTypeArr12[0] = anyType22;
            AnyType anyType23 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(DataFormat.class), true));
            if (anyType23 == null) {
                try {
                    Result.Companion companion41 = Result.INSTANCE;
                    objM12684constructorimpl21 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(DataFormat.class, true, null)), new Function0<KType>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$lambda$19$$inlined$AsyncFunction$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(DataFormat.class);
                        }
                    }));
                } catch (Throwable th22) {
                    Result.Companion companion42 = Result.INSTANCE;
                    objM12684constructorimpl21 = Result.m12684constructorimpl(ResultKt.createFailure(th22));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl21)) {
                    objM12684constructorimpl21 = null;
                }
                TypeDescriptor typeDescriptor21 = (TypeDescriptor) objM12684constructorimpl21;
                if (typeDescriptor21 == null) {
                    typeDescriptor21 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(DataFormat.class));
                }
                anyType23 = new AnyType(typeDescriptor21, converters9);
            }
            anyTypeArr12[1] = anyType23;
            Function1<Object[], Object> function7 = new Function1<Object[], Object>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$lambda$19$$inlined$AsyncFunction$3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    return ByteArrayExtensionsKt.formatted(((SealedData) obj).getIvBytes(), (DataFormat) objArr[1]);
                }
            };
            if (Intrinsics.areEqual(Object.class, Integer.TYPE)) {
                stringAsyncFunctionComponent7 = new IntAsyncFunctionComponent(AESEncryptor.IV_PROPERTY, anyTypeArr12, function7);
            } else if (Intrinsics.areEqual(Object.class, Boolean.TYPE)) {
                stringAsyncFunctionComponent7 = new BoolAsyncFunctionComponent(AESEncryptor.IV_PROPERTY, anyTypeArr12, function7);
            } else if (Intrinsics.areEqual(Object.class, Double.TYPE)) {
                stringAsyncFunctionComponent7 = new DoubleAsyncFunctionComponent(AESEncryptor.IV_PROPERTY, anyTypeArr12, function7);
            } else if (Intrinsics.areEqual(Object.class, Float.TYPE)) {
                stringAsyncFunctionComponent7 = new FloatAsyncFunctionComponent(AESEncryptor.IV_PROPERTY, anyTypeArr12, function7);
            } else {
                stringAsyncFunctionComponent7 = Intrinsics.areEqual(Object.class, String.class) ? new StringAsyncFunctionComponent(AESEncryptor.IV_PROPERTY, anyTypeArr12, function7) : new UntypedAsyncFunctionComponent(AESEncryptor.IV_PROPERTY, anyTypeArr12, function7);
            }
            classComponentBuilder5.getAsyncFunctions().put(AESEncryptor.IV_PROPERTY, stringAsyncFunctionComponent7);
            ClassComponentBuilder classComponentBuilder6 = classComponentBuilder4;
            TypeConverterProvider converters10 = classComponentBuilder6.getConverters();
            AnyType[] anyTypeArr13 = new AnyType[2];
            AnyType anyType24 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(SealedData.class), false));
            if (anyType24 == null) {
                try {
                    Result.Companion companion43 = Result.INSTANCE;
                    objM12684constructorimpl22 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(SealedData.class, false, null)), new Function0<KType>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$lambda$19$$inlined$AsyncFunction$4
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(SealedData.class);
                        }
                    }));
                } catch (Throwable th23) {
                    Result.Companion companion44 = Result.INSTANCE;
                    objM12684constructorimpl22 = Result.m12684constructorimpl(ResultKt.createFailure(th23));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl22)) {
                    objM12684constructorimpl22 = null;
                }
                TypeDescriptor typeDescriptor22 = (TypeDescriptor) objM12684constructorimpl22;
                if (typeDescriptor22 == null) {
                    typeDescriptor22 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(SealedData.class));
                }
                anyType24 = new AnyType(typeDescriptor22, converters10);
            }
            anyTypeArr13[0] = anyType24;
            AnyType anyType25 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(DataFormat.class), true));
            if (anyType25 == null) {
                try {
                    Result.Companion companion45 = Result.INSTANCE;
                    objM12684constructorimpl23 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(DataFormat.class, true, null)), new Function0<KType>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$lambda$19$$inlined$AsyncFunction$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(DataFormat.class);
                        }
                    }));
                } catch (Throwable th24) {
                    Result.Companion companion46 = Result.INSTANCE;
                    objM12684constructorimpl23 = Result.m12684constructorimpl(ResultKt.createFailure(th24));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl23)) {
                    objM12684constructorimpl23 = null;
                }
                TypeDescriptor typeDescriptor23 = (TypeDescriptor) objM12684constructorimpl23;
                if (typeDescriptor23 == null) {
                    typeDescriptor23 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(DataFormat.class));
                }
                anyType25 = new AnyType(typeDescriptor23, converters10);
            }
            anyTypeArr13[1] = anyType25;
            Function1<Object[], Object> function8 = new Function1<Object[], Object>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$lambda$19$$inlined$AsyncFunction$6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    return ByteArrayExtensionsKt.formatted(((SealedData) obj).getTagBytes(), (DataFormat) objArr[1]);
                }
            };
            if (Intrinsics.areEqual(Object.class, Integer.TYPE)) {
                stringAsyncFunctionComponent8 = new IntAsyncFunctionComponent("tag", anyTypeArr13, function8);
            } else if (Intrinsics.areEqual(Object.class, Boolean.TYPE)) {
                stringAsyncFunctionComponent8 = new BoolAsyncFunctionComponent("tag", anyTypeArr13, function8);
            } else if (Intrinsics.areEqual(Object.class, Double.TYPE)) {
                stringAsyncFunctionComponent8 = new DoubleAsyncFunctionComponent("tag", anyTypeArr13, function8);
            } else if (Intrinsics.areEqual(Object.class, Float.TYPE)) {
                stringAsyncFunctionComponent8 = new FloatAsyncFunctionComponent("tag", anyTypeArr13, function8);
            } else {
                stringAsyncFunctionComponent8 = Intrinsics.areEqual(Object.class, String.class) ? new StringAsyncFunctionComponent("tag", anyTypeArr13, function8) : new UntypedAsyncFunctionComponent("tag", anyTypeArr13, function8);
            }
            classComponentBuilder6.getAsyncFunctions().put("tag", stringAsyncFunctionComponent8);
            ClassComponentBuilder classComponentBuilder7 = classComponentBuilder4;
            TypeConverterProvider converters11 = classComponentBuilder7.getConverters();
            AnyType[] anyTypeArr14 = new AnyType[2];
            AnyType anyType26 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(SealedData.class), false));
            if (anyType26 == null) {
                try {
                    Result.Companion companion47 = Result.INSTANCE;
                    objM12684constructorimpl24 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(SealedData.class, false, null)), new Function0<KType>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$lambda$19$$inlined$AsyncFunction$7
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(SealedData.class);
                        }
                    }));
                } catch (Throwable th25) {
                    Result.Companion companion48 = Result.INSTANCE;
                    objM12684constructorimpl24 = Result.m12684constructorimpl(ResultKt.createFailure(th25));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl24)) {
                    objM12684constructorimpl24 = null;
                }
                TypeDescriptor typeDescriptor24 = (TypeDescriptor) objM12684constructorimpl24;
                if (typeDescriptor24 == null) {
                    typeDescriptor24 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(SealedData.class));
                }
                anyType26 = new AnyType(typeDescriptor24, converters11);
            }
            anyTypeArr14[0] = anyType26;
            AnyType anyType27 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(DataFormat.class), true));
            if (anyType27 == null) {
                try {
                    Result.Companion companion49 = Result.INSTANCE;
                    objM12684constructorimpl25 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(DataFormat.class, true, null)), new Function0<KType>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$lambda$19$$inlined$AsyncFunction$8
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(DataFormat.class);
                        }
                    }));
                } catch (Throwable th26) {
                    Result.Companion companion50 = Result.INSTANCE;
                    objM12684constructorimpl25 = Result.m12684constructorimpl(ResultKt.createFailure(th26));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl25)) {
                    objM12684constructorimpl25 = null;
                }
                TypeDescriptor typeDescriptor25 = (TypeDescriptor) objM12684constructorimpl25;
                if (typeDescriptor25 == null) {
                    typeDescriptor25 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(DataFormat.class));
                }
                anyType27 = new AnyType(typeDescriptor25, converters11);
            }
            anyTypeArr14[1] = anyType27;
            Function1<Object[], Object> function9 = new Function1<Object[], Object>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$lambda$19$$inlined$AsyncFunction$9
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    return ByteArrayExtensionsKt.formatted(((SealedData) obj).getCombinedArray(), (DataFormat) objArr[1]);
                }
            };
            if (Intrinsics.areEqual(Object.class, Integer.TYPE)) {
                stringAsyncFunctionComponent9 = new IntAsyncFunctionComponent("combined", anyTypeArr14, function9);
            } else if (Intrinsics.areEqual(Object.class, Boolean.TYPE)) {
                stringAsyncFunctionComponent9 = new BoolAsyncFunctionComponent("combined", anyTypeArr14, function9);
            } else if (Intrinsics.areEqual(Object.class, Double.TYPE)) {
                stringAsyncFunctionComponent9 = new DoubleAsyncFunctionComponent("combined", anyTypeArr14, function9);
            } else if (Intrinsics.areEqual(Object.class, Float.TYPE)) {
                stringAsyncFunctionComponent9 = new FloatAsyncFunctionComponent("combined", anyTypeArr14, function9);
            } else {
                stringAsyncFunctionComponent9 = Intrinsics.areEqual(Object.class, String.class) ? new StringAsyncFunctionComponent("combined", anyTypeArr14, function9) : new UntypedAsyncFunctionComponent("combined", anyTypeArr14, function9);
            }
            classComponentBuilder7.getAsyncFunctions().put("combined", stringAsyncFunctionComponent9);
            ClassComponentBuilder classComponentBuilder8 = classComponentBuilder4;
            TypeConverterProvider converters12 = classComponentBuilder8.getConverters();
            AnyType[] anyTypeArr15 = new AnyType[2];
            AnyType anyType28 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(SealedData.class), false));
            if (anyType28 == null) {
                try {
                    Result.Companion companion51 = Result.INSTANCE;
                    objM12684constructorimpl26 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(SealedData.class, false, null)), new Function0<KType>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$lambda$19$$inlined$AsyncFunction$10
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(SealedData.class);
                        }
                    }));
                } catch (Throwable th27) {
                    Result.Companion companion52 = Result.INSTANCE;
                    objM12684constructorimpl26 = Result.m12684constructorimpl(ResultKt.createFailure(th27));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl26)) {
                    objM12684constructorimpl26 = null;
                }
                TypeDescriptor typeDescriptor26 = (TypeDescriptor) objM12684constructorimpl26;
                if (typeDescriptor26 == null) {
                    typeDescriptor26 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(SealedData.class));
                }
                anyType28 = new AnyType(typeDescriptor26, converters12);
            }
            anyTypeArr15[0] = anyType28;
            AnyType anyType29 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(CiphertextOptions.class), true));
            if (anyType29 == null) {
                try {
                    Result.Companion companion53 = Result.INSTANCE;
                    objM12684constructorimpl27 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(CiphertextOptions.class, true, CiphertextOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$lambda$19$$inlined$AsyncFunction$11
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(CiphertextOptions.class);
                        }
                    }));
                } catch (Throwable th28) {
                    Result.Companion companion54 = Result.INSTANCE;
                    objM12684constructorimpl27 = Result.m12684constructorimpl(ResultKt.createFailure(th28));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl27)) {
                    objM12684constructorimpl27 = null;
                }
                TypeDescriptor typeDescriptor27 = (TypeDescriptor) objM12684constructorimpl27;
                if (typeDescriptor27 == null) {
                    typeDescriptor27 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(CiphertextOptions.class));
                }
                anyType29 = new AnyType(typeDescriptor27, converters12);
            }
            anyTypeArr15[1] = anyType29;
            Function1<Object[], Object> function10 = new Function1<Object[], Object>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$lambda$19$$inlined$AsyncFunction$12
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    CiphertextOptions ciphertextOptions = (CiphertextOptions) objArr[1];
                    SealedData sealedData = (SealedData) obj;
                    if (ciphertextOptions == null) {
                        ciphertextOptions = new CiphertextOptions(false, null, 3, null);
                    }
                    boolean includeTag = ciphertextOptions.getIncludeTag();
                    return ByteArrayExtensionsKt.formatted(sealedData.ciphertextBytes(includeTag), ciphertextOptions.getOutputFormat());
                }
            };
            if (Intrinsics.areEqual(Object.class, Integer.TYPE)) {
                stringAsyncFunctionComponent10 = new IntAsyncFunctionComponent("ciphertext", anyTypeArr15, function10);
            } else if (Intrinsics.areEqual(Object.class, Boolean.TYPE)) {
                stringAsyncFunctionComponent10 = new BoolAsyncFunctionComponent("ciphertext", anyTypeArr15, function10);
            } else if (Intrinsics.areEqual(Object.class, Double.TYPE)) {
                stringAsyncFunctionComponent10 = new DoubleAsyncFunctionComponent("ciphertext", anyTypeArr15, function10);
            } else if (Intrinsics.areEqual(Object.class, Float.TYPE)) {
                stringAsyncFunctionComponent10 = new FloatAsyncFunctionComponent("ciphertext", anyTypeArr15, function10);
            } else {
                stringAsyncFunctionComponent10 = Intrinsics.areEqual(Object.class, String.class) ? new StringAsyncFunctionComponent("ciphertext", anyTypeArr15, function10) : new UntypedAsyncFunctionComponent("ciphertext", anyTypeArr15, function10);
            }
            classComponentBuilder8.getAsyncFunctions().put("ciphertext", stringAsyncFunctionComponent10);
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis2 = new PropertyComponentBuilderWithThis(classComponentBuilder4.getOwnerType().getTypeDescriptor(), "combinedSize");
            AnyType[] anyTypeArr16 = {new AnyType(propertyComponentBuilderWithThis2.getThisType(), null, 2, null)};
            ReturnTypeProvider returnTypeProvider6 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType11 = returnTypeProvider6.getTypes().get(Integer.class);
            if (returnType11 == null) {
                JSTypeConverter<?> directConverter6 = ReturnTypeKt.getDirectConverter(Integer.class);
                if (directConverter6 == null) {
                    directConverter6 = ReturnTypeKt.getIndirectConverter(Integer.class, null);
                }
                ReturnType returnType12 = new ReturnType(directConverter6);
                returnTypeProvider6.getTypes().put(Integer.class, returnType12);
                returnType11 = returnType12;
            }
            SyncFunctionComponent syncFunctionComponent2 = new SyncFunctionComponent("get", anyTypeArr16, returnType11, new Function1<Object[], Object>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$lambda$19$$inlined$Property$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Integer.valueOf(((SealedData) it[0]).getCombinedSize());
                }
            });
            syncFunctionComponent2.setOwnerType(propertyComponentBuilderWithThis2.getThisType());
            syncFunctionComponent2.setCanTakeOwner(true);
            propertyComponentBuilderWithThis2.setGetter(syncFunctionComponent2);
            classComponentBuilder4.getProperties().put("combinedSize", propertyComponentBuilderWithThis2);
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis3 = new PropertyComponentBuilderWithThis(classComponentBuilder4.getOwnerType().getTypeDescriptor(), "ivSize");
            AnyType[] anyTypeArr17 = {new AnyType(propertyComponentBuilderWithThis3.getThisType(), null, 2, null)};
            ReturnTypeProvider returnTypeProvider7 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType13 = returnTypeProvider7.getTypes().get(Integer.class);
            if (returnType13 == null) {
                JSTypeConverter<?> directConverter7 = ReturnTypeKt.getDirectConverter(Integer.class);
                if (directConverter7 == null) {
                    directConverter7 = ReturnTypeKt.getIndirectConverter(Integer.class, null);
                }
                ReturnType returnType14 = new ReturnType(directConverter7);
                returnTypeProvider7.getTypes().put(Integer.class, returnType14);
                returnType13 = returnType14;
            }
            SyncFunctionComponent syncFunctionComponent3 = new SyncFunctionComponent("get", anyTypeArr17, returnType13, new Function1<Object[], Object>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$lambda$19$$inlined$Property$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Integer.valueOf(((SealedData) it[0]).getIvSize());
                }
            });
            syncFunctionComponent3.setOwnerType(propertyComponentBuilderWithThis3.getThisType());
            syncFunctionComponent3.setCanTakeOwner(true);
            propertyComponentBuilderWithThis3.setGetter(syncFunctionComponent3);
            classComponentBuilder4.getProperties().put("ivSize", propertyComponentBuilderWithThis3);
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis4 = new PropertyComponentBuilderWithThis(classComponentBuilder4.getOwnerType().getTypeDescriptor(), "tagSize");
            AnyType[] anyTypeArr18 = {new AnyType(propertyComponentBuilderWithThis4.getThisType(), null, 2, null)};
            ReturnTypeProvider returnTypeProvider8 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType15 = returnTypeProvider8.getTypes().get(Integer.class);
            if (returnType15 == null) {
                JSTypeConverter<?> directConverter8 = ReturnTypeKt.getDirectConverter(Integer.class);
                if (directConverter8 == null) {
                    directConverter8 = ReturnTypeKt.getIndirectConverter(Integer.class, null);
                }
                ReturnType returnType16 = new ReturnType(directConverter8);
                returnTypeProvider8.getTypes().put(Integer.class, returnType16);
                returnType15 = returnType16;
            }
            SyncFunctionComponent syncFunctionComponent4 = new SyncFunctionComponent("get", anyTypeArr18, returnType15, new Function1<Object[], Object>() { // from class: expo.modules.crypto.aes.AesCryptoModule$definition$lambda$20$lambda$19$$inlined$Property$3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Integer.valueOf(((SealedData) it[0]).getTagSize());
                }
            });
            syncFunctionComponent4.setOwnerType(propertyComponentBuilderWithThis4.getThisType());
            syncFunctionComponent4.setCanTakeOwner(true);
            propertyComponentBuilderWithThis4.setGetter(syncFunctionComponent4);
            classComponentBuilder4.getProperties().put("tagSize", propertyComponentBuilderWithThis4);
            moduleDefinitionBuilder5.getClassData().add(classComponentBuilder4.buildClass());
            ModuleDefinitionData moduleDefinitionDataBuildModule = moduleDefinitionBuilder.buildModule();
            Trace.endSection();
            return moduleDefinitionDataBuildModule;
        } catch (Throwable th29) {
            Trace.endSection();
            throw th29;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SealedData encrypt(Either<byte[], String> plaintext, EncryptionKey key, EncryptOptions options) throws EncryptionFailed {
        Either<byte[], String> additionalData;
        SecretKey cryptoKey = key.getCryptoKey();
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(toBytes(plaintext));
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, cryptoKey, options != null ? options.gcmParameterSpec$expo_crypto_release(getRng()) : null);
            if (options != null && (additionalData = options.getAdditionalData()) != null) {
                cipher.updateAAD(toBytes(additionalData));
            }
            Intrinsics.checkNotNull(cipher);
            Intrinsics.checkNotNull(byteBufferWrap);
            return CipherExtensionsKt.encrypt(cipher, byteBufferWrap);
        } catch (Throwable th) {
            throw new EncryptionFailed(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object decrypt(SealedData sealedData, EncryptionKey key, DecryptOptions options) throws DecryptionFailed {
        Either<byte[], String> additionalData;
        SecretKey cryptoKey = key.getCryptoKey();
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, cryptoKey, new GCMParameterSpec(sealedData.getTagSize() * 8, sealedData.getIvBytes()));
            if (options != null && (additionalData = options.getAdditionalData()) != null) {
                cipher.updateAAD(toBytes(additionalData));
            }
            Intrinsics.checkNotNull(cipher);
            byte[] bArrArray = CipherExtensionsKt.decrypt(cipher, sealedData).array();
            Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
            return ByteArrayExtensionsKt.formatted(bArrArray, options != null ? options.getOutput() : null);
        } catch (Throwable th) {
            throw new DecryptionFailed(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SealedData sealedDataFromParts(Either<byte[], String> iv, Either<byte[], String> ciphertext, Either<byte[], Integer> tag) {
        byte[] bytes = toBytes(iv);
        byte[] bytes2 = toBytes(ciphertext);
        if (tag != null && tag.isSecondType(Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
            return new SealedData(bytes, bytes2, tag.getSecondType(Reflection.getOrCreateKotlinClass(Integer.TYPE)).intValue());
        }
        if (tag != null && tag.isFirstType(Reflection.getOrCreateKotlinClass(byte[].class))) {
            byte[] firstType = tag.getFirstType(Reflection.getOrCreateKotlinClass(byte[].class));
            return new SealedData(bytes, ArraysKt.plus(bytes2, firstType), firstType.length);
        }
        return new SealedData(bytes, bytes2, 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] toBytes(Either<byte[], String> either) {
        if (either.isFirstType(Reflection.getOrCreateKotlinClass(byte[].class))) {
            return either.getFirstType(Reflection.getOrCreateKotlinClass(byte[].class));
        }
        byte[] bArrDecode = Base64.decode(either.getSecondType(Reflection.getOrCreateKotlinClass(String.class)), 2);
        Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
        return bArrDecode;
    }
}

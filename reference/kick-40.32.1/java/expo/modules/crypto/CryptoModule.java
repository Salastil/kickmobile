package expo.modules.crypto;

import android.util.Base64;
import io.github.expo.modules.v2.Module;
import io.github.expo.modules.v2.TypedArray;
import io.github.expo.modules.v2.args.Bridge;
import io.github.expo.modules.v2.args.Trampoline;
import io.github.expo.modules.v2.args.TrampolineArguments;
import io.github.expo.modules.v2.async.Promise;
import io.github.expo.modules.v2.jsi.JavaScriptObject;
import io.github.expo.modules.v2.modules.ModuleBuilder;
import io.github.expo.modules.v2.types.AnyType;
import io.github.expo.modules.v2.types.CommonDescriptors;
import io.github.expo.modules.v2.types.TypeDescriptor;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: CryptoModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J&\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0087@¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J \u0010\u0017\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u0016H\u0007J\b\u0010\u0019\u001a\u00020\u000bH\u0007R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001a"}, d2 = {"Lexpo/modules/crypto/CryptoModule;", "Lio/github/expo/modules/v2/Module;", "<init>", "()V", "secureRandom", "Ljava/security/SecureRandom;", "getSecureRandom", "()Ljava/security/SecureRandom;", "secureRandom$delegate", "Lkotlin/Lazy;", "digestString", "", "algorithm", "Lexpo/modules/crypto/DigestAlgorithm;", "data", "options", "Lexpo/modules/crypto/DigestOptions;", "digestStringAsync", "(Lexpo/modules/crypto/DigestAlgorithm;Ljava/lang/String;Lexpo/modules/crypto/DigestOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRandomValues", "", "typedArray", "Lio/github/expo/modules/v2/TypedArray;", "digest", "output", "randomUUID", "expo-crypto_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CryptoModule extends Module {
    private static final TypeDescriptor type$0 = new TypeDescriptor.Simple(DigestAlgorithm.class, false);
    private static final TypeDescriptor type$1 = new TypeDescriptor.Simple(DigestOptions.class, false);
    private static final TypeDescriptor type$2 = new TypeDescriptor.Simple(TypedArray.class, false);

    /* JADX INFO: renamed from: secureRandom$delegate, reason: from kotlin metadata */
    private final Lazy secureRandom = LazyKt.lazy(new Function0() { // from class: expo.modules.crypto.CryptoModule$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return CryptoModule.secureRandom_delegate$lambda$0();
        }
    });

    /* JADX INFO: compiled from: CryptoModule.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DigestOptions.Encoding.values().length];
            try {
                iArr[DigestOptions.Encoding.BASE64.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DigestOptions.Encoding.HEX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // io.github.expo.modules.v2.Module
    public final String define$ExpoModulesV2(ModuleBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        ModuleBuilder.function$default(builder, "digestString", new AnyType[]{new AnyType(new TypeDescriptor.Simple(DigestAlgorithm.class, false), true), new AnyType(CommonDescriptors.STRING, true), new AnyType(new TypeDescriptor.Simple(DigestOptions.class, false), true)}, new AnyType(CommonDescriptors.STRING, false), "digestString__trampoline$ExpoModulesV2", false, 16, null);
        builder.function("digestStringAsync", new AnyType[]{new AnyType(new TypeDescriptor.Simple(DigestAlgorithm.class, false), true), new AnyType(CommonDescriptors.STRING, true), new AnyType(new TypeDescriptor.Simple(DigestOptions.class, false), true)}, new AnyType(CommonDescriptors.STRING, false), "digestStringAsync__trampoline$ExpoModulesV2", true);
        ModuleBuilder.function$default(builder, "getRandomValues", new AnyType[]{new AnyType(new TypeDescriptor.Simple(TypedArray.class, false), false)}, new AnyType(new TypeDescriptor.Simple(Unit.class, false), false), "getRandomValues__trampoline$ExpoModulesV2", false, 16, null);
        ModuleBuilder.function$default(builder, "digest", new AnyType[]{new AnyType(new TypeDescriptor.Simple(DigestAlgorithm.class, false), true), new AnyType(new TypeDescriptor.Simple(TypedArray.class, false), false), new AnyType(new TypeDescriptor.Simple(TypedArray.class, false), false)}, new AnyType(new TypeDescriptor.Simple(Unit.class, false), false), "digest__trampoline$ExpoModulesV2", false, 16, null);
        ModuleBuilder.function$default(builder, "randomUUID", new AnyType[0], new AnyType(CommonDescriptors.STRING, false), "randomUUID", false, 16, null);
        return "ExpoCrypto";
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v6, types: [T, java.lang.Object] */
    public final void digestStringAsync__trampoline$ExpoModulesV2(int i, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        TrampolineArguments trampolineArgumentsArguments = Trampoline.arguments(i);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        try {
            objectRef.element = trampolineArgumentsArguments.next(type$0);
            objectRef2.element = trampolineArgumentsArguments.nextString();
            objectRef3.element = trampolineArgumentsArguments.next(type$1);
            trampolineArgumentsArguments.finish();
            promise.launch(CommonDescriptors.STRING, false, new CryptoModule$digestStringAsync__trampoline$ExpoModulesV2$1(this, objectRef, objectRef2, objectRef3, null));
        } catch (Throwable th) {
            trampolineArgumentsArguments.finish();
            throw th;
        }
    }

    public final String digestString__trampoline$ExpoModulesV2(int i) {
        TrampolineArguments trampolineArgumentsArguments = Trampoline.arguments(i);
        try {
            return digestString((DigestAlgorithm) trampolineArgumentsArguments.next(type$0), trampolineArgumentsArguments.nextString(), (DigestOptions) trampolineArgumentsArguments.next(type$1));
        } finally {
            trampolineArgumentsArguments.finish();
        }
    }

    public final void digest__trampoline$ExpoModulesV2(JavaScriptObject javaScriptObject, JavaScriptObject javaScriptObject2, int i) throws NoSuchAlgorithmException {
        TrampolineArguments trampolineArgumentsArguments = Trampoline.arguments(i);
        try {
            DigestAlgorithm digestAlgorithm = (DigestAlgorithm) trampolineArgumentsArguments.next(type$0);
            trampolineArgumentsArguments.finish();
            TypeDescriptor typeDescriptor = type$2;
            Object objFromJni = Bridge.fromJni(javaScriptObject, typeDescriptor);
            Intrinsics.checkNotNull(objFromJni, "null cannot be cast to non-null type io.github.expo.modules.v2.TypedArray");
            Object objFromJni2 = Bridge.fromJni(javaScriptObject2, typeDescriptor);
            Intrinsics.checkNotNull(objFromJni2, "null cannot be cast to non-null type io.github.expo.modules.v2.TypedArray");
            digest(digestAlgorithm, (TypedArray) objFromJni, (TypedArray) objFromJni2);
        } catch (Throwable th) {
            trampolineArgumentsArguments.finish();
            throw th;
        }
    }

    public final void getRandomValues__trampoline$ExpoModulesV2(JavaScriptObject javaScriptObject) {
        Object objFromJni = Bridge.fromJni(javaScriptObject, type$2);
        Intrinsics.checkNotNull(objFromJni, "null cannot be cast to non-null type io.github.expo.modules.v2.TypedArray");
        getRandomValues((TypedArray) objFromJni);
    }

    private final SecureRandom getSecureRandom() {
        return (SecureRandom) this.secureRandom.getValue();
    }

    static final SecureRandom secureRandom_delegate$lambda$0() {
        return new SecureRandom();
    }

    public final String digestString(DigestAlgorithm algorithm, String data, DigestOptions options) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(options, "options");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm.getValue());
        byte[] bytes = data.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        messageDigest.update(bytes);
        byte[] bArrDigest = messageDigest.digest();
        int i = WhenMappings.$EnumSwitchMapping$0[options.getEncoding().ordinal()];
        if (i == 1) {
            String strEncodeToString = Base64.encodeToString(bArrDigest, 2);
            Intrinsics.checkNotNull(strEncodeToString);
            return strEncodeToString;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        Intrinsics.checkNotNull(bArrDigest);
        return ArraysKt.joinToString$default(bArrDigest, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: expo.modules.crypto.CryptoModule$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CryptoModule.digestString$lambda$2(((Byte) obj).byteValue());
            }
        }, 30, (Object) null);
    }

    static final CharSequence digestString$lambda$2(byte b) {
        String string = Integer.toString((b & 255) + 256, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        String strSubstring = string.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    /* JADX INFO: renamed from: expo.modules.crypto.CryptoModule$digestStringAsync$2, reason: invalid class name */
    /* JADX INFO: compiled from: CryptoModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.crypto.CryptoModule$digestStringAsync$2", f = "CryptoModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ DigestAlgorithm $algorithm;
        final /* synthetic */ String $data;
        final /* synthetic */ DigestOptions $options;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(DigestAlgorithm digestAlgorithm, String str, DigestOptions digestOptions, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$algorithm = digestAlgorithm;
            this.$data = str;
            this.$options = digestOptions;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CryptoModule.this.new AnonymousClass2(this.$algorithm, this.$data, this.$options, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return CryptoModule.this.digestString(this.$algorithm, this.$data, this.$options);
        }
    }

    public final Object digestStringAsync(DigestAlgorithm digestAlgorithm, String str, DigestOptions digestOptions, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getDefault(), new AnonymousClass2(digestAlgorithm, str, digestOptions, null), continuation);
    }

    public final void getRandomValues(TypedArray typedArray) {
        Intrinsics.checkNotNullParameter(typedArray, "typedArray");
        byte[] bArr = new byte[typedArray.getByteLength()];
        getSecureRandom().nextBytes(bArr);
        typedArray.write(bArr, 0, typedArray.getByteLength());
    }

    public final void digest(DigestAlgorithm algorithm, TypedArray output, TypedArray data) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(data, "data");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm.getValue());
        messageDigest.update(data.toDirectBuffer());
        byte[] bArrDigest = messageDigest.digest();
        int iMin = Math.min(bArrDigest.length, output.getByteLength());
        Intrinsics.checkNotNull(bArrDigest);
        output.write(bArrDigest, 0, iMin);
    }

    public final String randomUUID() {
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}

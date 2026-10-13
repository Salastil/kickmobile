package expo.modules.crypto.aes.records;

import android.util.Base64;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.types.Either;
import expo.modules.kotlin.types.EitherOfThree;
import expo.modules.kotlin.types.OptimizedRecord;
import io.github.expo.pika.PAnnotation;
import io.github.expo.pika.PFunction;
import io.github.expo.pika.PIntrospectionData;
import io.github.expo.pika.PIntrospectionProvider;
import io.github.expo.pika.PProperty;
import io.github.expo.pika.PPropertyAccessor;
import io.github.expo.pika.PTypeDescriptor;
import io.github.expo.pika.PTypeDescriptorRegistry;
import io.github.expo.pika.PVisibility;
import java.security.SecureRandom;
import javax.crypto.spec.GCMParameterSpec;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: EncryptOptions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0000¢\u0006\u0002\b\u001cJ\f\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001eH\u0016R0\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\fR \u0010\r\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0011\u0012\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0010R0\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0013j\u0004\u0018\u0001`\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lexpo/modules/crypto/aes/records/EncryptOptions;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "<init>", "()V", "nonce", "Lexpo/modules/kotlin/types/EitherOfThree;", "", "", "", "getNonce$annotations", "getNonce", "()Lexpo/modules/kotlin/types/EitherOfThree;", "tagLength", "getTagLength$annotations", "getTagLength", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "additionalData", "Lexpo/modules/kotlin/types/Either;", "Lexpo/modules/crypto/aes/BinaryInput;", "getAdditionalData$annotations", "getAdditionalData", "()Lexpo/modules/kotlin/types/Either;", "gcmParameterSpec", "Ljavax/crypto/spec/GCMParameterSpec;", "random", "Ljava/security/SecureRandom;", "gcmParameterSpec$expo_crypto_release", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "__Pika", "expo-crypto_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EncryptOptions implements Record, PIntrospectionProvider {
    public Either<byte[], String> additionalData;
    public EitherOfThree<String, byte[], Integer> nonce;
    public Integer tagLength;

    /* JADX INFO: compiled from: EncryptOptions.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/crypto/aes/records/EncryptOptions$__Pika;", "", "<init>", "()V", "expo-crypto_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<EncryptOptions> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(EncryptOptions.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("nonce", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateParameterized(EitherOfThree.class, true, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.STRING, PTypeDescriptorRegistry.getOrCreateConcrete(byte[].class, false, null), PTypeDescriptorRegistry.INT}), null), 0, __pika, false, true, false), new PProperty("tagLength", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.INT_NULLABLE, 1, __pika, false, true, false), new PProperty("additionalData", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateParameterized(Either.class, true, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateConcrete(byte[].class, false, null), PTypeDescriptorRegistry.STRING}), null), 2, __pika, false, true, false)}, new PFunction[]{new PFunction("gcmParameterSpec", PVisibility.INTERNAL)}, null);
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.crypto.aes.records.EncryptOptions");
                return ((EncryptOptions) obj).getNonce();
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.crypto.aes.records.EncryptOptions");
                return ((EncryptOptions) obj).getTagLength();
            }
            if (i != 2) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.crypto.aes.records.EncryptOptions");
            return ((EncryptOptions) obj).getAdditionalData();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.crypto.aes.records.EncryptOptions");
                ((EncryptOptions) obj).nonce = (EitherOfThree) obj2;
            } else if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.crypto.aes.records.EncryptOptions");
                ((EncryptOptions) obj).tagLength = (Integer) obj2;
            } else {
                if (i != 2) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.crypto.aes.records.EncryptOptions");
                ((EncryptOptions) obj).additionalData = (Either) obj2;
            }
        }
    }

    @Field
    public static /* synthetic */ void getAdditionalData$annotations() {
    }

    @Field
    public static /* synthetic */ void getNonce$annotations() {
    }

    @Field
    public static /* synthetic */ void getTagLength$annotations() {
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public final EitherOfThree<String, byte[], Integer> getNonce() {
        return this.nonce;
    }

    public final Integer getTagLength() {
        return this.tagLength;
    }

    public final Either<byte[], String> getAdditionalData() {
        return this.additionalData;
    }

    public final GCMParameterSpec gcmParameterSpec$expo_crypto_release(SecureRandom random) {
        byte[] secondType;
        Intrinsics.checkNotNullParameter(random, "random");
        EitherOfThree<String, byte[], Integer> eitherOfThree = this.nonce;
        if (eitherOfThree == null && this.tagLength == null) {
            return null;
        }
        if (eitherOfThree == null) {
            secondType = new byte[12];
            random.nextBytes(secondType);
        } else {
            boolean zIsThirdType = eitherOfThree.isThirdType(Reflection.getOrCreateKotlinClass(Integer.TYPE));
            EitherOfThree<String, byte[], Integer> eitherOfThree2 = this.nonce;
            if (zIsThirdType) {
                secondType = new byte[eitherOfThree2.getThirdType(Reflection.getOrCreateKotlinClass(Integer.TYPE)).intValue()];
                random.nextBytes(secondType);
            } else {
                boolean zIsFirstType = eitherOfThree2.isFirstType(Reflection.getOrCreateKotlinClass(String.class));
                EitherOfThree<String, byte[], Integer> eitherOfThree3 = this.nonce;
                if (zIsFirstType) {
                    secondType = Base64.decode(eitherOfThree3.getFirstType(Reflection.getOrCreateKotlinClass(String.class)), 2);
                } else {
                    secondType = eitherOfThree3.getSecondType(Reflection.getOrCreateKotlinClass(byte[].class));
                }
            }
        }
        Integer num = this.tagLength;
        return new GCMParameterSpec((num != null ? num.intValue() : 16) * 8, secondType);
    }
}

package expo.modules.crypto.aes.records;

import expo.modules.crypto.aes.enums.DataFormat;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.types.Either;
import expo.modules.kotlin.types.OptimizedRecord;
import io.github.expo.pika.PAnnotation;
import io.github.expo.pika.PEmptyArrays;
import io.github.expo.pika.PIntrospectionData;
import io.github.expo.pika.PIntrospectionProvider;
import io.github.expo.pika.PProperty;
import io.github.expo.pika.PPropertyAccessor;
import io.github.expo.pika.PTypeDescriptor;
import io.github.expo.pika.PTypeDescriptorRegistry;
import io.github.expo.pika.PVisibility;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DecryptOptions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0014B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\f\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0016R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\tR0\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bj\u0004\u0018\u0001`\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lexpo/modules/crypto/aes/records/DecryptOptions;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "<init>", "()V", "output", "Lexpo/modules/crypto/aes/enums/DataFormat;", "getOutput$annotations", "getOutput", "()Lexpo/modules/crypto/aes/enums/DataFormat;", "additionalData", "Lexpo/modules/kotlin/types/Either;", "", "", "Lexpo/modules/crypto/aes/BinaryInput;", "getAdditionalData$annotations", "getAdditionalData", "()Lexpo/modules/kotlin/types/Either;", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "__Pika", "expo-crypto_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DecryptOptions implements Record, PIntrospectionProvider {
    public Either<byte[], String> additionalData;
    public DataFormat output = DataFormat.BYTES;

    /* JADX INFO: compiled from: DecryptOptions.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/crypto/aes/records/DecryptOptions$__Pika;", "", "<init>", "()V", "expo-crypto_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<DecryptOptions> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(DecryptOptions.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("output", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(DataFormat.class, false, null), 0, __pika, false, true, false), new PProperty("additionalData", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateParameterized(Either.class, true, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateConcrete(byte[].class, false, null), PTypeDescriptorRegistry.STRING}), null), 1, __pika, false, true, false)}, PEmptyArrays.EMPTY_FUNCTIONS, null);
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.crypto.aes.records.DecryptOptions");
                return ((DecryptOptions) obj).getOutput();
            }
            if (i != 1) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.crypto.aes.records.DecryptOptions");
            return ((DecryptOptions) obj).getAdditionalData();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.crypto.aes.records.DecryptOptions");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.crypto.aes.enums.DataFormat");
                ((DecryptOptions) obj).output = (DataFormat) obj2;
                return;
            }
            if (i != 1) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.crypto.aes.records.DecryptOptions");
            ((DecryptOptions) obj).additionalData = (Either) obj2;
        }
    }

    @Field
    public static /* synthetic */ void getAdditionalData$annotations() {
    }

    @Field
    public static /* synthetic */ void getOutput$annotations() {
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public final DataFormat getOutput() {
        return this.output;
    }

    public final Either<byte[], String> getAdditionalData() {
        return this.additionalData;
    }
}

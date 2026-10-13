package expo.modules.crypto.aes.records;

import expo.modules.crypto.aes.enums.DataFormat;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.types.OptimizedRecord;
import io.github.expo.pika.PAnnotation;
import io.github.expo.pika.PFunction;
import io.github.expo.pika.PIntrospectionData;
import io.github.expo.pika.PIntrospectionProvider;
import io.github.expo.pika.PProperty;
import io.github.expo.pika.PPropertyAccessor;
import io.github.expo.pika.PTypeDescriptorRegistry;
import io.github.expo.pika.PVisibility;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CiphertextOptions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001cB\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\f\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0016J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lexpo/modules/crypto/aes/records/CiphertextOptions;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "includeTag", "", "outputFormat", "Lexpo/modules/crypto/aes/enums/DataFormat;", "<init>", "(ZLexpo/modules/crypto/aes/enums/DataFormat;)V", "getIncludeTag$annotations", "()V", "getIncludeTag", "()Z", "getOutputFormat$annotations", "getOutputFormat", "()Lexpo/modules/crypto/aes/enums/DataFormat;", "component1", "component2", "copy", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "", "__Pika", "expo-crypto_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CiphertextOptions implements Record, PIntrospectionProvider {
    public boolean includeTag;
    public DataFormat outputFormat;

    /* JADX INFO: compiled from: CiphertextOptions.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/crypto/aes/records/CiphertextOptions$__Pika;", "", "<init>", "()V", "expo-crypto_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<CiphertextOptions> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(CiphertextOptions.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("includeTag", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN, 0, __pika, false, true, false), new PProperty("outputFormat", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(DataFormat.class, false, null), 1, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.crypto.aes.records.CiphertextOptions");
                return Boolean.valueOf(((CiphertextOptions) obj).getIncludeTag());
            }
            if (i != 1) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.crypto.aes.records.CiphertextOptions");
            return ((CiphertextOptions) obj).getOutputFormat();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.crypto.aes.records.CiphertextOptions");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                ((CiphertextOptions) obj).includeTag = ((Boolean) obj2).booleanValue();
                return;
            }
            if (i != 1) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.crypto.aes.records.CiphertextOptions");
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.crypto.aes.enums.DataFormat");
            ((CiphertextOptions) obj).outputFormat = (DataFormat) obj2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CiphertextOptions() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CiphertextOptions copy$default(CiphertextOptions ciphertextOptions, boolean z, DataFormat dataFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            z = ciphertextOptions.includeTag;
        }
        if ((i & 2) != 0) {
            dataFormat = ciphertextOptions.outputFormat;
        }
        return ciphertextOptions.copy(z, dataFormat);
    }

    @Field
    public static /* synthetic */ void getIncludeTag$annotations() {
    }

    @Field
    public static /* synthetic */ void getOutputFormat$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIncludeTag() {
        return this.includeTag;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final DataFormat getOutputFormat() {
        return this.outputFormat;
    }

    public final CiphertextOptions copy(boolean includeTag, DataFormat outputFormat) {
        Intrinsics.checkNotNullParameter(outputFormat, "outputFormat");
        return new CiphertextOptions(includeTag, outputFormat);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CiphertextOptions)) {
            return false;
        }
        CiphertextOptions ciphertextOptions = (CiphertextOptions) other;
        return this.includeTag == ciphertextOptions.includeTag && this.outputFormat == ciphertextOptions.outputFormat;
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.includeTag) * 31) + this.outputFormat.hashCode();
    }

    public String toString() {
        return "CiphertextOptions(includeTag=" + this.includeTag + ", outputFormat=" + this.outputFormat + ")";
    }

    public CiphertextOptions(boolean z, DataFormat outputFormat) {
        Intrinsics.checkNotNullParameter(outputFormat, "outputFormat");
        this.includeTag = z;
        this.outputFormat = outputFormat;
    }

    public final boolean getIncludeTag() {
        return this.includeTag;
    }

    public /* synthetic */ CiphertextOptions(boolean z, DataFormat dataFormat, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? DataFormat.BYTES : dataFormat);
    }

    public final DataFormat getOutputFormat() {
        return this.outputFormat;
    }
}

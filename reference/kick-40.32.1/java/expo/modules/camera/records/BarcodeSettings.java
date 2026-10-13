package expo.modules.camera.records;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
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
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CameraRecords.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0018B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J\u0019\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\f\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0016J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u0019"}, d2 = {"Lexpo/modules/camera/records/BarcodeSettings;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "barcodeTypes", "", "Lexpo/modules/camera/records/BarcodeType;", "<init>", "(Ljava/util/List;)V", "getBarcodeTypes$annotations", "()V", "getBarcodeTypes", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "", "__Pika", "expo-camera_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class BarcodeSettings implements Record, PIntrospectionProvider {
    public List<BarcodeType> barcodeTypes;

    /* JADX INFO: compiled from: CameraRecords.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/camera/records/BarcodeSettings$__Pika;", "", "<init>", "()V", "expo-camera_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<BarcodeSettings> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(BarcodeSettings.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("barcodeTypes", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateConcrete(BarcodeType.class, false, null)}), null), 0, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i != 0) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.camera.records.BarcodeSettings");
            return ((BarcodeSettings) obj).getBarcodeTypes();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i != 0) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.camera.records.BarcodeSettings");
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.List<expo.modules.camera.records.BarcodeType>");
            ((BarcodeSettings) obj).barcodeTypes = (List) obj2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BarcodeSettings copy$default(BarcodeSettings barcodeSettings, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = barcodeSettings.barcodeTypes;
        }
        return barcodeSettings.copy(list);
    }

    @Field
    public static /* synthetic */ void getBarcodeTypes$annotations() {
    }

    public final List<BarcodeType> component1() {
        return this.barcodeTypes;
    }

    public final BarcodeSettings copy(List<? extends BarcodeType> barcodeTypes) {
        Intrinsics.checkNotNullParameter(barcodeTypes, "barcodeTypes");
        return new BarcodeSettings(barcodeTypes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof BarcodeSettings) && Intrinsics.areEqual(this.barcodeTypes, ((BarcodeSettings) other).barcodeTypes);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        return this.barcodeTypes.hashCode();
    }

    public String toString() {
        return "BarcodeSettings(barcodeTypes=" + this.barcodeTypes + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BarcodeSettings(List<? extends BarcodeType> barcodeTypes) {
        Intrinsics.checkNotNullParameter(barcodeTypes, "barcodeTypes");
        this.barcodeTypes = barcodeTypes;
    }

    public final List<BarcodeType> getBarcodeTypes() {
        return this.barcodeTypes;
    }
}

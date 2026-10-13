package expo.modules.imagemanipulator;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.types.OptimizedRecord;
import io.github.expo.pika.PAnnotation;
import io.github.expo.pika.PEmptyArrays;
import io.github.expo.pika.PIntrospectionData;
import io.github.expo.pika.PIntrospectionProvider;
import io.github.expo.pika.PProperty;
import io.github.expo.pika.PPropertyAccessor;
import io.github.expo.pika.PTypeDescriptorRegistry;
import io.github.expo.pika.PVisibility;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageManipulatorArguments.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0016B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\f\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0015H\u0016R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lexpo/modules/imagemanipulator/ManipulateOptions;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "<init>", "()V", "base64", "", "getBase64$annotations", "getBase64", "()Z", "compress", "", "getCompress$annotations", "getCompress", "()D", "format", "Lexpo/modules/imagemanipulator/ImageFormat;", "getFormat$annotations", "getFormat", "()Lexpo/modules/imagemanipulator/ImageFormat;", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "__Pika", "expo-image-manipulator_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ManipulateOptions implements Record, PIntrospectionProvider {
    public boolean base64;
    public double compress = 1.0d;
    public ImageFormat format = ImageFormat.JPEG;

    /* JADX INFO: compiled from: ImageManipulatorArguments.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/imagemanipulator/ManipulateOptions$__Pika;", "", "<init>", "()V", "expo-image-manipulator_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<ManipulateOptions> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(ManipulateOptions.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("base64", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN, 0, __pika, false, true, false), new PProperty("compress", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.DOUBLE, 1, __pika, false, true, false), new PProperty("format", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(ImageFormat.class, false, null), 2, __pika, false, true, false)}, PEmptyArrays.EMPTY_FUNCTIONS, null);
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.imagemanipulator.ManipulateOptions");
                return Boolean.valueOf(((ManipulateOptions) obj).getBase64());
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.imagemanipulator.ManipulateOptions");
                return Double.valueOf(((ManipulateOptions) obj).getCompress());
            }
            if (i != 2) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.imagemanipulator.ManipulateOptions");
            return ((ManipulateOptions) obj).getFormat();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.imagemanipulator.ManipulateOptions");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                ((ManipulateOptions) obj).base64 = ((Boolean) obj2).booleanValue();
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.imagemanipulator.ManipulateOptions");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Double");
                ((ManipulateOptions) obj).compress = ((Double) obj2).doubleValue();
                return;
            }
            if (i != 2) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.imagemanipulator.ManipulateOptions");
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.imagemanipulator.ImageFormat");
            ((ManipulateOptions) obj).format = (ImageFormat) obj2;
        }
    }

    @Field
    public static /* synthetic */ void getBase64$annotations() {
    }

    @Field
    public static /* synthetic */ void getCompress$annotations() {
    }

    @Field
    public static /* synthetic */ void getFormat$annotations() {
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public final boolean getBase64() {
        return this.base64;
    }

    public final double getCompress() {
        return this.compress;
    }

    public final ImageFormat getFormat() {
        return this.format;
    }
}

package expo.modules.clipboard;

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
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClipboardOptions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\f\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0016R$\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lexpo/modules/clipboard/GetImageOptions;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "<init>", "()V", "imageFormat", "Lexpo/modules/clipboard/ImageFormat;", "getImageFormat$annotations", "getImageFormat", "()Lexpo/modules/clipboard/ImageFormat;", "setImageFormat", "(Lexpo/modules/clipboard/ImageFormat;)V", "jpegQuality", "", "getJpegQuality$annotations", "getJpegQuality", "()D", "setJpegQuality", "(D)V", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "__Pika", "expo-clipboard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GetImageOptions implements Record, PIntrospectionProvider {
    public ImageFormat imageFormat = ImageFormat.JPG;
    public double jpegQuality = 1.0d;

    /* JADX INFO: compiled from: ClipboardOptions.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/clipboard/GetImageOptions$__Pika;", "", "<init>", "()V", "expo-clipboard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<GetImageOptions> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(GetImageOptions.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("imageFormat", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.mapOf(TuplesKt.to("key", "format")))}, PTypeDescriptorRegistry.getOrCreateConcrete(ImageFormat.class, false, null), 0, __pika, true, true, false), new PProperty("jpegQuality", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.DOUBLE, 1, __pika, true, true, false)}, PEmptyArrays.EMPTY_FUNCTIONS, null);
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.clipboard.GetImageOptions");
                return ((GetImageOptions) obj).getImageFormat();
            }
            if (i != 1) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.clipboard.GetImageOptions");
            return Double.valueOf(((GetImageOptions) obj).getJpegQuality());
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.clipboard.GetImageOptions");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.clipboard.ImageFormat");
                ((GetImageOptions) obj).setImageFormat((ImageFormat) obj2);
            } else {
                if (i != 1) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.clipboard.GetImageOptions");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Double");
                ((GetImageOptions) obj).setJpegQuality(((Double) obj2).doubleValue());
            }
        }
    }

    @Field(key = "format")
    public static /* synthetic */ void getImageFormat$annotations() {
    }

    @Field
    public static /* synthetic */ void getJpegQuality$annotations() {
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public final ImageFormat getImageFormat() {
        return this.imageFormat;
    }

    public final void setImageFormat(ImageFormat imageFormat) {
        Intrinsics.checkNotNullParameter(imageFormat, "<set-?>");
        this.imageFormat = imageFormat;
    }

    public final double getJpegQuality() {
        return this.jpegQuality;
    }

    public final void setJpegQuality(double d) {
        this.jpegQuality = d;
    }
}

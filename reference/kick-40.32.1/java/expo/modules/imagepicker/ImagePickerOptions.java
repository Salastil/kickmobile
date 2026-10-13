package expo.modules.imagepicker;

import expo.modules.imagepicker.contracts.CameraContractOptions;
import expo.modules.imagepicker.contracts.ImageLibraryContractOptions;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.types.OptimizedRecord;
import io.github.expo.pika.PAnnotation;
import io.github.expo.pika.PEmptyArrays;
import io.github.expo.pika.PFunction;
import io.github.expo.pika.PIntrospectionData;
import io.github.expo.pika.PIntrospectionProvider;
import io.github.expo.pika.PProperty;
import io.github.expo.pika.PPropertyAccessor;
import io.github.expo.pika.PTypeDescriptor;
import io.github.expo.pika.PTypeDescriptorRegistry;
import io.github.expo.pika.PVisibility;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImagePickerOptions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001`B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020[J\u0006\u0010\\\u001a\u00020]J\f\u0010^\u001a\u0006\u0012\u0002\b\u00030_H\u0016R$\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR$\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b \u0010\u0005\u001a\u0004\b!\u0010\n\"\u0004\b\"\u0010\fR$\u0010#\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b$\u0010\u0005\u001a\u0004\b%\u0010\n\"\u0004\b&\u0010\fR,\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010/\u0012\u0004\b*\u0010\u0005\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00100\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b1\u0010\u0005\u001a\u0004\b2\u0010\u001c\"\u0004\b3\u0010\u001eR2\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u0001058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b6\u0010\u0005\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010;\u001a\u00020<8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b=\u0010\u0005\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010B\u001a\u00020C8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bD\u0010\u0005\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001c\u0010I\u001a\u00020\u00078\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\bJ\u0010\u0005\u001a\u0004\bK\u0010\nR\u001c\u0010L\u001a\u00020M8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bN\u0010\u0005\u001a\u0004\bO\u0010PR\u001c\u0010Q\u001a\u00020\u00078\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\bR\u0010\u0005\u001a\u0004\bS\u0010\nR\u0011\u0010T\u001a\u00020U8F¢\u0006\u0006\u001a\u0004\bV\u0010W¨\u0006a"}, d2 = {"Lexpo/modules/imagepicker/ImagePickerOptions;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", "Lio/github/expo/pika/PIntrospectionProvider;", "<init>", "()V", "allowsEditing", "", "getAllowsEditing$annotations", "getAllowsEditing", "()Z", "setAllowsEditing", "(Z)V", "allowsMultipleSelection", "getAllowsMultipleSelection$annotations", "getAllowsMultipleSelection", "setAllowsMultipleSelection", "quality", "", "getQuality$annotations", "getQuality", "()D", "setQuality", "(D)V", "selectionLimit", "", "getSelectionLimit$annotations", "getSelectionLimit", "()I", "setSelectionLimit", "(I)V", "base64", "getBase64$annotations", "getBase64", "setBase64", "exif", "getExif$annotations", "getExif", "setExif", "mediaTypes", "", "Lexpo/modules/imagepicker/JSMediaTypes;", "getMediaTypes$annotations", "getMediaTypes", "()[Lexpo/modules/imagepicker/JSMediaTypes;", "setMediaTypes", "([Lexpo/modules/imagepicker/JSMediaTypes;)V", "[Lexpo/modules/imagepicker/JSMediaTypes;", "videoMaxDuration", "getVideoMaxDuration$annotations", "getVideoMaxDuration", "setVideoMaxDuration", "aspect", "Lkotlin/Pair;", "getAspect$annotations", "getAspect", "()Lkotlin/Pair;", "setAspect", "(Lkotlin/Pair;)V", "shape", "Lexpo/modules/imagepicker/CropShape;", "getShape$annotations", "getShape", "()Lexpo/modules/imagepicker/CropShape;", "setShape", "(Lexpo/modules/imagepicker/CropShape;)V", "cameraType", "Lexpo/modules/imagepicker/CameraType;", "getCameraType$annotations", "getCameraType", "()Lexpo/modules/imagepicker/CameraType;", "setCameraType", "(Lexpo/modules/imagepicker/CameraType;)V", "orderedSelection", "getOrderedSelection$annotations", "getOrderedSelection", "defaultTab", "Lexpo/modules/imagepicker/DefaultTab;", "getDefaultTab$annotations", "getDefaultTab", "()Lexpo/modules/imagepicker/DefaultTab;", "legacy", "getLegacy$annotations", "getLegacy", "nativeMediaTypes", "Lexpo/modules/imagepicker/MediaTypes;", "getNativeMediaTypes", "()Lexpo/modules/imagepicker/MediaTypes;", "toCameraContractOptions", "Lexpo/modules/imagepicker/contracts/CameraContractOptions;", "uri", "", "toImageLibraryContractOptions", "Lexpo/modules/imagepicker/contracts/ImageLibraryContractOptions;", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "__Pika", "expo-image-picker_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ImagePickerOptions implements Record, Serializable, PIntrospectionProvider {
    public boolean allowsEditing;
    public boolean allowsMultipleSelection;
    public Pair<Integer, Integer> aspect;
    public boolean base64;
    public boolean exif;
    public boolean legacy;
    public boolean orderedSelection;
    public int selectionLimit;
    public int videoMaxDuration;
    public double quality = 1.0d;
    public JSMediaTypes[] mediaTypes = {JSMediaTypes.IMAGES};
    public CropShape shape = CropShape.RECTANGLE;
    public CameraType cameraType = CameraType.BACK;
    public DefaultTab defaultTab = DefaultTab.PHOTOS;

    /* JADX INFO: compiled from: ImagePickerOptions.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/imagepicker/ImagePickerOptions$__Pika;", "", "<init>", "()V", "expo-image-picker_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<ImagePickerOptions> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(ImagePickerOptions.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("allowsEditing", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN, 0, __pika, true, true, false), new PProperty("allowsMultipleSelection", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN, 1, __pika, true, true, false), new PProperty("quality", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.DOUBLE, 2, __pika, true, true, false), new PProperty("selectionLimit", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.INT, 3, __pika, true, true, false), new PProperty("base64", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN, 4, __pika, true, true, false), new PProperty("exif", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN, 5, __pika, true, true, false), new PProperty("mediaTypes", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateParameterized(Object[].class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateConcrete(JSMediaTypes.class, false, null)}), null), 6, __pika, true, true, false), new PProperty("videoMaxDuration", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.INT, 7, __pika, true, true, false), new PProperty("aspect", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateParameterized(Pair.class, true, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.INT, PTypeDescriptorRegistry.INT}), null), 8, __pika, true, true, false), new PProperty("shape", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(CropShape.class, false, null), 9, __pika, true, true, false), new PProperty("cameraType", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(CameraType.class, false, null), 10, __pika, true, true, false), new PProperty("orderedSelection", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN, 11, __pika, false, true, false), new PProperty("defaultTab", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(DefaultTab.class, false, null), 12, __pika, false, true, false), new PProperty("legacy", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN, 13, __pika, false, true, false), new PProperty("nativeMediaTypes", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(MediaTypes.class, false, null), 14, __pika, false, false, false)}, new PFunction[]{new PFunction("toCameraContractOptions", PVisibility.PUBLIC), new PFunction("toImageLibraryContractOptions", PVisibility.PUBLIC)}, null);
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.imagepicker.ImagePickerOptions");
                    return Boolean.valueOf(((ImagePickerOptions) obj).getAllowsEditing());
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.imagepicker.ImagePickerOptions");
                    return Boolean.valueOf(((ImagePickerOptions) obj).getAllowsMultipleSelection());
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.imagepicker.ImagePickerOptions");
                    return Double.valueOf(((ImagePickerOptions) obj).getQuality());
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.imagepicker.ImagePickerOptions");
                    return Integer.valueOf(((ImagePickerOptions) obj).getSelectionLimit());
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.imagepicker.ImagePickerOptions");
                    return Boolean.valueOf(((ImagePickerOptions) obj).getBase64());
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.imagepicker.ImagePickerOptions");
                    return Boolean.valueOf(((ImagePickerOptions) obj).getExif());
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.imagepicker.ImagePickerOptions");
                    return ((ImagePickerOptions) obj).getMediaTypes();
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.imagepicker.ImagePickerOptions");
                    return Integer.valueOf(((ImagePickerOptions) obj).getVideoMaxDuration());
                case 8:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.imagepicker.ImagePickerOptions");
                    return ((ImagePickerOptions) obj).getAspect();
                case 9:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.imagepicker.ImagePickerOptions");
                    return ((ImagePickerOptions) obj).getShape();
                case 10:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.imagepicker.ImagePickerOptions");
                    return ((ImagePickerOptions) obj).getCameraType();
                case 11:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.imagepicker.ImagePickerOptions");
                    return Boolean.valueOf(((ImagePickerOptions) obj).getOrderedSelection());
                case 12:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.imagepicker.ImagePickerOptions");
                    return ((ImagePickerOptions) obj).getDefaultTab();
                case 13:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.imagepicker.ImagePickerOptions");
                    return Boolean.valueOf(((ImagePickerOptions) obj).getLegacy());
                case 14:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.imagepicker.ImagePickerOptions");
                    return ((ImagePickerOptions) obj).getNativeMediaTypes();
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.imagepicker.ImagePickerOptions");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    ((ImagePickerOptions) obj).setAllowsEditing(((Boolean) obj2).booleanValue());
                    return;
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.imagepicker.ImagePickerOptions");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    ((ImagePickerOptions) obj).setAllowsMultipleSelection(((Boolean) obj2).booleanValue());
                    return;
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.imagepicker.ImagePickerOptions");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Double");
                    ((ImagePickerOptions) obj).setQuality(((Double) obj2).doubleValue());
                    return;
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.imagepicker.ImagePickerOptions");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                    ((ImagePickerOptions) obj).setSelectionLimit(((Integer) obj2).intValue());
                    return;
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.imagepicker.ImagePickerOptions");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    ((ImagePickerOptions) obj).setBase64(((Boolean) obj2).booleanValue());
                    return;
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.imagepicker.ImagePickerOptions");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    ((ImagePickerOptions) obj).setExif(((Boolean) obj2).booleanValue());
                    return;
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.imagepicker.ImagePickerOptions");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Array<expo.modules.imagepicker.JSMediaTypes>");
                    ((ImagePickerOptions) obj).setMediaTypes((JSMediaTypes[]) obj2);
                    return;
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.imagepicker.ImagePickerOptions");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                    ((ImagePickerOptions) obj).setVideoMaxDuration(((Integer) obj2).intValue());
                    return;
                case 8:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.imagepicker.ImagePickerOptions");
                    ((ImagePickerOptions) obj).setAspect((Pair) obj2);
                    return;
                case 9:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.imagepicker.ImagePickerOptions");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.imagepicker.CropShape");
                    ((ImagePickerOptions) obj).setShape((CropShape) obj2);
                    return;
                case 10:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.imagepicker.ImagePickerOptions");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.imagepicker.CameraType");
                    ((ImagePickerOptions) obj).setCameraType((CameraType) obj2);
                    return;
                case 11:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.imagepicker.ImagePickerOptions");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    ((ImagePickerOptions) obj).orderedSelection = ((Boolean) obj2).booleanValue();
                    return;
                case 12:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.imagepicker.ImagePickerOptions");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.imagepicker.DefaultTab");
                    ((ImagePickerOptions) obj).defaultTab = (DefaultTab) obj2;
                    return;
                case 13:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.imagepicker.ImagePickerOptions");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    ((ImagePickerOptions) obj).legacy = ((Boolean) obj2).booleanValue();
                    return;
                case 14:
                    throw new UnsupportedOperationException("Property 'nativeMediaTypes' does not have a backing field and cannot be set.");
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }
    }

    @Field
    public static /* synthetic */ void getAllowsEditing$annotations() {
    }

    @Field
    public static /* synthetic */ void getAllowsMultipleSelection$annotations() {
    }

    @Field
    public static /* synthetic */ void getAspect$annotations() {
    }

    @Field
    public static /* synthetic */ void getBase64$annotations() {
    }

    @Field
    public static /* synthetic */ void getCameraType$annotations() {
    }

    @Field
    public static /* synthetic */ void getDefaultTab$annotations() {
    }

    @Field
    public static /* synthetic */ void getExif$annotations() {
    }

    @Field
    public static /* synthetic */ void getLegacy$annotations() {
    }

    @Field
    public static /* synthetic */ void getMediaTypes$annotations() {
    }

    @Field
    public static /* synthetic */ void getOrderedSelection$annotations() {
    }

    @Field
    public static /* synthetic */ void getQuality$annotations() {
    }

    @Field
    public static /* synthetic */ void getSelectionLimit$annotations() {
    }

    @Field
    public static /* synthetic */ void getShape$annotations() {
    }

    @Field
    public static /* synthetic */ void getVideoMaxDuration$annotations() {
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public final boolean getAllowsEditing() {
        return this.allowsEditing;
    }

    public final void setAllowsEditing(boolean z) {
        this.allowsEditing = z;
    }

    public final boolean getAllowsMultipleSelection() {
        return this.allowsMultipleSelection;
    }

    public final void setAllowsMultipleSelection(boolean z) {
        this.allowsMultipleSelection = z;
    }

    public final double getQuality() {
        return this.quality;
    }

    public final void setQuality(double d) {
        this.quality = d;
    }

    public final int getSelectionLimit() {
        return this.selectionLimit;
    }

    public final void setSelectionLimit(int i) {
        this.selectionLimit = i;
    }

    public final boolean getBase64() {
        return this.base64;
    }

    public final void setBase64(boolean z) {
        this.base64 = z;
    }

    public final boolean getExif() {
        return this.exif;
    }

    public final void setExif(boolean z) {
        this.exif = z;
    }

    public final JSMediaTypes[] getMediaTypes() {
        return this.mediaTypes;
    }

    public final void setMediaTypes(JSMediaTypes[] jSMediaTypesArr) {
        Intrinsics.checkNotNullParameter(jSMediaTypesArr, "<set-?>");
        this.mediaTypes = jSMediaTypesArr;
    }

    public final int getVideoMaxDuration() {
        return this.videoMaxDuration;
    }

    public final void setVideoMaxDuration(int i) {
        this.videoMaxDuration = i;
    }

    public final Pair<Integer, Integer> getAspect() {
        return this.aspect;
    }

    public final void setAspect(Pair<Integer, Integer> pair) {
        this.aspect = pair;
    }

    public final CropShape getShape() {
        return this.shape;
    }

    public final void setShape(CropShape cropShape) {
        Intrinsics.checkNotNullParameter(cropShape, "<set-?>");
        this.shape = cropShape;
    }

    public final CameraType getCameraType() {
        return this.cameraType;
    }

    public final void setCameraType(CameraType cameraType) {
        Intrinsics.checkNotNullParameter(cameraType, "<set-?>");
        this.cameraType = cameraType;
    }

    public final boolean getOrderedSelection() {
        return this.orderedSelection;
    }

    public final DefaultTab getDefaultTab() {
        return this.defaultTab;
    }

    public final boolean getLegacy() {
        return this.legacy;
    }

    public final MediaTypes getNativeMediaTypes() {
        return MediaTypes.INSTANCE.fromJSMediaTypesArray(this.mediaTypes);
    }

    public final CameraContractOptions toCameraContractOptions(String uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return new CameraContractOptions(uri, this);
    }

    public final ImageLibraryContractOptions toImageLibraryContractOptions() {
        return new ImageLibraryContractOptions(this);
    }
}

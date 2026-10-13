package expo.modules.updates.reloadscreen;

import com.facebook.react.uimanager.ViewProps;
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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReloadScreenConfiguration.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u00013BC\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010'\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010(\u001a\u0004\u0018\u00010\rHÆ\u0003JV\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010*J\u0014\u0010+\u001a\u00020\n2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0083\u0004J\f\u0010.\u001a\u0006\u0012\u0002\b\u00030/H\u0016J\n\u00100\u001a\u000201HÖ\u0081\u0004J\n\u00102\u001a\u00020\u0004HÖ\u0081\u0004R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0019R \u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001d\u0012\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u001cR \u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001d\u0012\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001f\u0010\u001cR\u001e\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0011\u001a\u0004\b!\u0010\"¨\u00064"}, d2 = {"Lexpo/modules/updates/reloadscreen/ReloadScreenOptions;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", ViewProps.BACKGROUND_COLOR, "", "image", "Lexpo/modules/updates/reloadscreen/ReloadScreenImageSource;", "imageResizeMode", "Lexpo/modules/updates/reloadscreen/ImageResizeMode;", "imageFullScreen", "", "fade", "spinner", "Lexpo/modules/updates/reloadscreen/SpinnerOptions;", "<init>", "(Ljava/lang/String;Lexpo/modules/updates/reloadscreen/ReloadScreenImageSource;Lexpo/modules/updates/reloadscreen/ImageResizeMode;Ljava/lang/Boolean;Ljava/lang/Boolean;Lexpo/modules/updates/reloadscreen/SpinnerOptions;)V", "getBackgroundColor$annotations", "()V", "getBackgroundColor", "()Ljava/lang/String;", "getImage$annotations", "getImage", "()Lexpo/modules/updates/reloadscreen/ReloadScreenImageSource;", "getImageResizeMode$annotations", "getImageResizeMode", "()Lexpo/modules/updates/reloadscreen/ImageResizeMode;", "getImageFullScreen$annotations", "getImageFullScreen", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFade$annotations", "getFade", "getSpinner$annotations", "getSpinner", "()Lexpo/modules/updates/reloadscreen/SpinnerOptions;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Lexpo/modules/updates/reloadscreen/ReloadScreenImageSource;Lexpo/modules/updates/reloadscreen/ImageResizeMode;Ljava/lang/Boolean;Ljava/lang/Boolean;Lexpo/modules/updates/reloadscreen/SpinnerOptions;)Lexpo/modules/updates/reloadscreen/ReloadScreenOptions;", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "__Pika", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ReloadScreenOptions implements Record, PIntrospectionProvider {
    public String backgroundColor;
    public Boolean fade;
    public ReloadScreenImageSource image;
    public Boolean imageFullScreen;
    public ImageResizeMode imageResizeMode;
    public SpinnerOptions spinner;

    public static /* synthetic */ ReloadScreenOptions copy$default(ReloadScreenOptions reloadScreenOptions, String str, ReloadScreenImageSource reloadScreenImageSource, ImageResizeMode imageResizeMode, Boolean bool, Boolean bool2, SpinnerOptions spinnerOptions, int i, Object obj) {
        if ((i & 1) != 0) {
            str = reloadScreenOptions.backgroundColor;
        }
        if ((i & 2) != 0) {
            reloadScreenImageSource = reloadScreenOptions.image;
        }
        if ((i & 4) != 0) {
            imageResizeMode = reloadScreenOptions.imageResizeMode;
        }
        if ((i & 8) != 0) {
            bool = reloadScreenOptions.imageFullScreen;
        }
        if ((i & 16) != 0) {
            bool2 = reloadScreenOptions.fade;
        }
        if ((i & 32) != 0) {
            spinnerOptions = reloadScreenOptions.spinner;
        }
        Boolean bool3 = bool2;
        SpinnerOptions spinnerOptions2 = spinnerOptions;
        return reloadScreenOptions.copy(str, reloadScreenImageSource, imageResizeMode, bool, bool3, spinnerOptions2);
    }

    @Field
    public static /* synthetic */ void getBackgroundColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getFade$annotations() {
    }

    @Field
    public static /* synthetic */ void getImage$annotations() {
    }

    @Field
    public static /* synthetic */ void getImageFullScreen$annotations() {
    }

    @Field
    public static /* synthetic */ void getImageResizeMode$annotations() {
    }

    @Field
    public static /* synthetic */ void getSpinner$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ReloadScreenImageSource getImage() {
        return this.image;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ImageResizeMode getImageResizeMode() {
        return this.imageResizeMode;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getImageFullScreen() {
        return this.imageFullScreen;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Boolean getFade() {
        return this.fade;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final SpinnerOptions getSpinner() {
        return this.spinner;
    }

    public final ReloadScreenOptions copy(String backgroundColor, ReloadScreenImageSource image, ImageResizeMode imageResizeMode, Boolean imageFullScreen, Boolean fade, SpinnerOptions spinner) {
        return new ReloadScreenOptions(backgroundColor, image, imageResizeMode, imageFullScreen, fade, spinner);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReloadScreenOptions)) {
            return false;
        }
        ReloadScreenOptions reloadScreenOptions = (ReloadScreenOptions) other;
        return Intrinsics.areEqual(this.backgroundColor, reloadScreenOptions.backgroundColor) && Intrinsics.areEqual(this.image, reloadScreenOptions.image) && this.imageResizeMode == reloadScreenOptions.imageResizeMode && Intrinsics.areEqual(this.imageFullScreen, reloadScreenOptions.imageFullScreen) && Intrinsics.areEqual(this.fade, reloadScreenOptions.fade) && Intrinsics.areEqual(this.spinner, reloadScreenOptions.spinner);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        String str = this.backgroundColor;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        ReloadScreenImageSource reloadScreenImageSource = this.image;
        int iHashCode2 = (iHashCode + (reloadScreenImageSource == null ? 0 : reloadScreenImageSource.hashCode())) * 31;
        ImageResizeMode imageResizeMode = this.imageResizeMode;
        int iHashCode3 = (iHashCode2 + (imageResizeMode == null ? 0 : imageResizeMode.hashCode())) * 31;
        Boolean bool = this.imageFullScreen;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.fade;
        int iHashCode5 = (iHashCode4 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        SpinnerOptions spinnerOptions = this.spinner;
        return iHashCode5 + (spinnerOptions != null ? spinnerOptions.hashCode() : 0);
    }

    public String toString() {
        return "ReloadScreenOptions(backgroundColor=" + this.backgroundColor + ", image=" + this.image + ", imageResizeMode=" + this.imageResizeMode + ", imageFullScreen=" + this.imageFullScreen + ", fade=" + this.fade + ", spinner=" + this.spinner + ")";
    }

    /* JADX INFO: compiled from: ReloadScreenConfiguration.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/updates/reloadscreen/ReloadScreenOptions$__Pika;", "", "<init>", "()V", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<ReloadScreenOptions> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(ReloadScreenOptions.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty(ViewProps.BACKGROUND_COLOR, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.STRING_NULLABLE, 0, __pika, false, true, false), new PProperty("image", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(ReloadScreenImageSource.class, true, null), 1, __pika, false, true, false), new PProperty("imageResizeMode", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(ImageResizeMode.class, true, null), 2, __pika, false, true, false), new PProperty("imageFullScreen", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN_NULLABLE, 3, __pika, false, true, false), new PProperty("fade", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN_NULLABLE, 4, __pika, false, true, false), new PProperty("spinner", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(SpinnerOptions.class, true, null), 5, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("component6", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.updates.reloadscreen.ReloadScreenOptions");
                return ((ReloadScreenOptions) obj).getBackgroundColor();
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.updates.reloadscreen.ReloadScreenOptions");
                return ((ReloadScreenOptions) obj).getImage();
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.updates.reloadscreen.ReloadScreenOptions");
                return ((ReloadScreenOptions) obj).getImageResizeMode();
            }
            if (i == 3) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.updates.reloadscreen.ReloadScreenOptions");
                return ((ReloadScreenOptions) obj).getImageFullScreen();
            }
            if (i == 4) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.updates.reloadscreen.ReloadScreenOptions");
                return ((ReloadScreenOptions) obj).getFade();
            }
            if (i != 5) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.updates.reloadscreen.ReloadScreenOptions");
            return ((ReloadScreenOptions) obj).getSpinner();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.updates.reloadscreen.ReloadScreenOptions");
                ((ReloadScreenOptions) obj).backgroundColor = (String) obj2;
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.updates.reloadscreen.ReloadScreenOptions");
                ((ReloadScreenOptions) obj).image = (ReloadScreenImageSource) obj2;
                return;
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.updates.reloadscreen.ReloadScreenOptions");
                ((ReloadScreenOptions) obj).imageResizeMode = (ImageResizeMode) obj2;
                return;
            }
            if (i == 3) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.updates.reloadscreen.ReloadScreenOptions");
                ((ReloadScreenOptions) obj).imageFullScreen = (Boolean) obj2;
            } else if (i == 4) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.updates.reloadscreen.ReloadScreenOptions");
                ((ReloadScreenOptions) obj).fade = (Boolean) obj2;
            } else {
                if (i != 5) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.updates.reloadscreen.ReloadScreenOptions");
                ((ReloadScreenOptions) obj).spinner = (SpinnerOptions) obj2;
            }
        }

        private __Pika() {
        }
    }

    public ReloadScreenOptions(String str, ReloadScreenImageSource reloadScreenImageSource, ImageResizeMode imageResizeMode, Boolean bool, Boolean bool2, SpinnerOptions spinnerOptions) {
        this.backgroundColor = str;
        this.image = reloadScreenImageSource;
        this.imageResizeMode = imageResizeMode;
        this.imageFullScreen = bool;
        this.fade = bool2;
        this.spinner = spinnerOptions;
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final ReloadScreenImageSource getImage() {
        return this.image;
    }

    public final ImageResizeMode getImageResizeMode() {
        return this.imageResizeMode;
    }

    public final Boolean getImageFullScreen() {
        return this.imageFullScreen;
    }

    public final Boolean getFade() {
        return this.fade;
    }

    public final SpinnerOptions getSpinner() {
        return this.spinner;
    }
}

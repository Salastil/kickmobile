package com.facebook.fresco.vito.core.impl.debug;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.core.internal.view.SupportMenu;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.ui.common.VitoUtils;
import com.facebook.fresco.vito.core.FrescoDrawableInterface;
import com.facebook.fresco.vito.core.VitoImageRequest;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ImagesContract;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DebugDataProvider.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u000e\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001\u001a<\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e\u001aF\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e\u001a\u0018\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u001a\u001e\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u001a\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\"\u000e\u0010\u000f\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0011\u0010\u001f\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001e\"\u0011\u0010!\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0011\u0010#\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001e\"\u0011\u0010%\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(\"\u0011\u0010)\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b*\u0010(\"\u0011\u0010+\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b,\u0010(\"\u0011\u0010-\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001e\"\u0011\u0010/\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001e¨\u00061"}, d2 = {"formatDimensions", "", ViewProps.WIDTH, "", ViewProps.HEIGHT, "abbreviateOrigin", "origin", "computeImageFitRatioAndColor", "Lkotlin/Pair;", "imageWidth", "imageHeight", "drawableWidth", "drawableHeight", "config", "Lcom/facebook/fresco/vito/core/impl/debug/ImageFitRatioConfig;", "DEFAULT_BYTES_PER_PIXEL", "computeWastedMemoryAndColor", "bytesPerPixel", "truncateUri", "uri", "maxLength", "getOriginExtras", "", "", "extras", "Lcom/facebook/fresco/ui/common/ControllerListener2$Extras;", "getImageFormat", "imageIDProvider", "Lcom/facebook/fresco/vito/core/impl/debug/StringDebugDataProvider;", "getImageIDProvider", "()Lcom/facebook/fresco/vito/core/impl/debug/StringDebugDataProvider;", "drawableDimensionsProvider", "getDrawableDimensionsProvider", "hdrGainmapProvider", "getHdrGainmapProvider", "drawableDimensionsWithExtrasProvider", "getDrawableDimensionsWithExtrasProvider", "imageOriginWithExtrasProvider", "Lcom/facebook/fresco/vito/core/impl/debug/StringAndColorDebugDataProvider;", "getImageOriginWithExtrasProvider", "()Lcom/facebook/fresco/vito/core/impl/debug/StringAndColorDebugDataProvider;", "abbreviatedOriginWithExtrasProvider", "getAbbreviatedOriginWithExtrasProvider", "imageOriginSubcategoryWithExtrasProvider", "getImageOriginSubcategoryWithExtrasProvider", "imageFormatProvider", "getImageFormatProvider", "imageUriProvider", "getImageUriProvider", "core-common-impl_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DebugDataProviderKt {
    public static final int DEFAULT_BYTES_PER_PIXEL = 4;
    private static final StringDebugDataProvider imageIDProvider = new StringDebugDataProvider("id", "image ID", "The ID of the image", new Function2() { // from class: com.facebook.fresco.vito.core.impl.debug.DebugDataProviderKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return DebugDataProviderKt.imageIDProvider$lambda$3((FrescoDrawableInterface) obj, (ControllerListener2.Extras) obj2);
        }
    });
    private static final StringDebugDataProvider drawableDimensionsProvider = new StringDebugDataProvider("D", "Drawable dimensions", "The visible Drawable dimensions on screen", new Function2() { // from class: com.facebook.fresco.vito.core.impl.debug.DebugDataProviderKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return DebugDataProviderKt.drawableDimensionsProvider$lambda$4((FrescoDrawableInterface) obj, (ControllerListener2.Extras) obj2);
        }
    });
    private static final StringDebugDataProvider hdrGainmapProvider = new StringDebugDataProvider("hdr", "hdrGainmap", "Has Bitmap with HDR Gainmap", new Function2() { // from class: com.facebook.fresco.vito.core.impl.debug.DebugDataProviderKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return DebugDataProviderKt.hdrGainmapProvider$lambda$5((FrescoDrawableInterface) obj, (ControllerListener2.Extras) obj2);
        }
    });
    private static final StringDebugDataProvider drawableDimensionsWithExtrasProvider = new StringDebugDataProvider("D", "Drawable dimensions", "The visible Drawable dimensions on screen", new Function2() { // from class: com.facebook.fresco.vito.core.impl.debug.DebugDataProviderKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return DebugDataProviderKt.drawableDimensionsWithExtrasProvider$lambda$6((FrescoDrawableInterface) obj, (ControllerListener2.Extras) obj2);
        }
    });
    private static final StringAndColorDebugDataProvider imageOriginWithExtrasProvider = new StringAndColorDebugDataProvider("o", "Origin", "The source of the image", new Function2() { // from class: com.facebook.fresco.vito.core.impl.debug.DebugDataProviderKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return DebugDataProviderKt.imageOriginWithExtrasProvider$lambda$8((FrescoDrawableInterface) obj, (ControllerListener2.Extras) obj2);
        }
    });
    private static final StringAndColorDebugDataProvider abbreviatedOriginWithExtrasProvider = new StringAndColorDebugDataProvider("o", "Origin", "The source of the image (abbreviated)", new Function2() { // from class: com.facebook.fresco.vito.core.impl.debug.DebugDataProviderKt$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return DebugDataProviderKt.abbreviatedOriginWithExtrasProvider$lambda$10((FrescoDrawableInterface) obj, (ControllerListener2.Extras) obj2);
        }
    });
    private static final StringAndColorDebugDataProvider imageOriginSubcategoryWithExtrasProvider = new StringAndColorDebugDataProvider("o_s", "Origin Subcategory", "The subcategory of source of the image", new Function2() { // from class: com.facebook.fresco.vito.core.impl.debug.DebugDataProviderKt$$ExternalSyntheticLambda6
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return DebugDataProviderKt.imageOriginSubcategoryWithExtrasProvider$lambda$12((FrescoDrawableInterface) obj, (ControllerListener2.Extras) obj2);
        }
    });
    private static final StringDebugDataProvider imageFormatProvider = new StringDebugDataProvider("fmt", "Image Format", "The format of the image (JPEG, PNG, WEBP, etc.)", new Function2() { // from class: com.facebook.fresco.vito.core.impl.debug.DebugDataProviderKt$$ExternalSyntheticLambda7
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return DebugDataProviderKt.imageFormatProvider$lambda$15((FrescoDrawableInterface) obj, (ControllerListener2.Extras) obj2);
        }
    });
    private static final StringDebugDataProvider imageUriProvider = new StringDebugDataProvider("uri", "Image URI", "The URI of the image (truncated)", new Function2() { // from class: com.facebook.fresco.vito.core.impl.debug.DebugDataProviderKt$$ExternalSyntheticLambda8
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return DebugDataProviderKt.imageUriProvider$lambda$16((FrescoDrawableInterface) obj, (ControllerListener2.Extras) obj2);
        }
    });

    public static final String formatDimensions(int i, int i2) {
        return i + ViewDeviceOrientationData.DEVICE_ORIENTATION_X + i2;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final String abbreviateOrigin(String origin) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        switch (origin.hashCode()) {
            case 3083677:
                if (origin.equals("disk")) {
                    return "DISK";
                }
                break;
            case 103145323:
                if (origin.equals(ImagesContract.LOCAL)) {
                    return "LOCAL";
                }
                break;
            case 616257488:
                if (origin.equals("memory_encoded")) {
                    return "ENC";
                }
                break;
            case 1453899309:
                if (origin.equals("memory_bitmap")) {
                    return "MEM";
                }
                break;
            case 1843485230:
                if (origin.equals("network")) {
                    return "NET";
                }
                break;
        }
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String upperCase = origin.toUpperCase(US);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return StringsKt.take(upperCase, 4);
    }

    public static /* synthetic */ Pair computeImageFitRatioAndColor$default(int i, int i2, int i3, int i4, ImageFitRatioConfig imageFitRatioConfig, int i5, Object obj) {
        if ((i5 & 16) != 0) {
            imageFitRatioConfig = new ImageFitRatioConfig(0.0f, 0.0f, 0.0f, 0L, 15, null);
        }
        return computeImageFitRatioAndColor(i, i2, i3, i4, imageFitRatioConfig);
    }

    public static final Pair<String, Integer> computeImageFitRatioAndColor(int i, int i2, int i3, int i4, ImageFitRatioConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (i <= 0 || i2 <= 0 || i3 <= 0 || i4 <= 0) {
            return TuplesKt.to("", -7829368);
        }
        float fMax = Math.max(i / i3, i2 / i4);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Float.valueOf(fMax)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        float greenMinRatio = config.getGreenMinRatio();
        int i5 = SupportMenu.CATEGORY_MASK;
        if (fMax >= greenMinRatio) {
            if (fMax <= config.getGreenMaxRatio()) {
                i5 = -16711936;
            } else if (fMax <= config.getYellowMaxRatio()) {
                i5 = -256;
            }
        }
        return TuplesKt.to(str, Integer.valueOf(i5));
    }

    public static final Pair<String, Integer> computeWastedMemoryAndColor(int i, int i2, int i3, int i4, int i5, ImageFitRatioConfig config) {
        String str;
        Intrinsics.checkNotNullParameter(config, "config");
        if (i <= 0 || i2 <= 0 || i3 <= 0 || i4 <= 0 || i5 <= 0) {
            return TuplesKt.to("", -7829368);
        }
        long j = ((long) i) * ((long) i2);
        long j2 = i5;
        long jMax = Math.max(0L, (j * j2) - ((((long) i3) * ((long) i4)) * j2));
        if (jMax == 0) {
            return TuplesKt.to("0 B", -16711936);
        }
        if (jMax >= 1048576) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            str = String.format(Locale.US, "%.1f MiB", Arrays.copyOf(new Object[]{Double.valueOf(jMax / 1048576.0d)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        } else if (jMax >= 1024) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            str = String.format(Locale.US, "%.1f KiB", Arrays.copyOf(new Object[]{Double.valueOf(jMax / 1024.0d)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        } else {
            str = jMax + " B";
        }
        return TuplesKt.to(str, Integer.valueOf(jMax > config.getWastedMemoryRedThresholdBytes() ? SupportMenu.CATEGORY_MASK : -16711936));
    }

    public static /* synthetic */ String truncateUri$default(String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 20;
        }
        return truncateUri(str, i);
    }

    public static final String truncateUri(String uri, int i) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) uri, '/', 0, false, 6, (Object) null);
        if (iLastIndexOf$default >= 0 && iLastIndexOf$default < uri.length() - 1) {
            uri = uri.substring(iLastIndexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(uri, "substring(...)");
        }
        if (uri.length() <= i) {
            return uri;
        }
        return "..." + StringsKt.takeLast(uri, i - 3);
    }

    public static final Map<String, Object> getOriginExtras(ControllerListener2.Extras extras) {
        if (extras == null) {
            return null;
        }
        Map<String, ? extends Object> map = extras.datasourceExtras;
        return map == null ? extras.shortcutExtras : map;
    }

    public static final String getImageFormat(ControllerListener2.Extras extras) {
        Object obj;
        String string;
        Object obj2;
        String string2;
        Object obj3;
        String string3;
        if (extras == null) {
            return null;
        }
        Map<String, ? extends Object> map = extras.imageExtras;
        if (map != null && (obj3 = map.get("image_format")) != null && (string3 = obj3.toString()) != null) {
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String upperCase = string3.toUpperCase(US);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            return StringsKt.replace$default(upperCase, "_", "", false, 4, (Object) null);
        }
        Map<String, ? extends Object> map2 = extras.shortcutExtras;
        if (map2 != null && (obj2 = map2.get("image_format")) != null && (string2 = obj2.toString()) != null) {
            Locale US2 = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US2, "US");
            String upperCase2 = string2.toUpperCase(US2);
            Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
            return StringsKt.replace$default(upperCase2, "_", "", false, 4, (Object) null);
        }
        Map<String, ? extends Object> map3 = extras.datasourceExtras;
        if (map3 == null || (obj = map3.get("image_format")) == null || (string = obj.toString()) == null) {
            return null;
        }
        Locale US3 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US3, "US");
        String upperCase3 = string.toUpperCase(US3);
        Intrinsics.checkNotNullExpressionValue(upperCase3, "toUpperCase(...)");
        return StringsKt.replace$default(upperCase3, "_", "", false, 4, (Object) null);
    }

    public static final StringDebugDataProvider getImageIDProvider() {
        return imageIDProvider;
    }

    static final String imageIDProvider$lambda$3(FrescoDrawableInterface drawable, ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        return VitoUtils.getStringId(drawable.getImageId());
    }

    public static final StringDebugDataProvider getDrawableDimensionsProvider() {
        return drawableDimensionsProvider;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static final String drawableDimensionsProvider$lambda$4(FrescoDrawableInterface drawable, ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (drawable instanceof Drawable) {
            Drawable drawable2 = (Drawable) drawable;
            return formatDimensions(drawable2.getBounds().width(), drawable2.getBounds().height());
        }
        return "";
    }

    public static final StringDebugDataProvider getHdrGainmapProvider() {
        return hdrGainmapProvider;
    }

    static final String hdrGainmapProvider$lambda$5(FrescoDrawableInterface drawable, ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        return String.valueOf(drawable.hasBitmapWithGainmap());
    }

    public static final StringDebugDataProvider getDrawableDimensionsWithExtrasProvider() {
        return drawableDimensionsWithExtrasProvider;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static final String drawableDimensionsWithExtrasProvider$lambda$6(FrescoDrawableInterface drawable, ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (drawable instanceof Drawable) {
            Drawable drawable2 = (Drawable) drawable;
            return formatDimensions(drawable2.getBounds().width(), drawable2.getBounds().height());
        }
        return "";
    }

    public static final StringAndColorDebugDataProvider getImageOriginWithExtrasProvider() {
        return imageOriginWithExtrasProvider;
    }

    static final Pair imageOriginWithExtrasProvider$lambda$8(FrescoDrawableInterface drawable, ControllerListener2.Extras extras) {
        String string;
        Object obj;
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Map<String, Object> originExtras = getOriginExtras(extras);
        if (originExtras == null) {
            Object extras2 = drawable.getExtras();
            ControllerListener2.Extras extras3 = extras2 instanceof ControllerListener2.Extras ? (ControllerListener2.Extras) extras2 : null;
            originExtras = extras3 != null ? getOriginExtras(extras3) : null;
        }
        if (originExtras == null || (obj = originExtras.get("origin")) == null || (string = obj.toString()) == null) {
            string = "unknown";
        }
        return TuplesKt.to(string, Integer.valueOf(DebugOverlayImageOriginColor.getImageOriginColor(string)));
    }

    public static final StringAndColorDebugDataProvider getAbbreviatedOriginWithExtrasProvider() {
        return abbreviatedOriginWithExtrasProvider;
    }

    static final Pair abbreviatedOriginWithExtrasProvider$lambda$10(FrescoDrawableInterface drawable, ControllerListener2.Extras extras) {
        String string;
        Object obj;
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Map<String, Object> originExtras = getOriginExtras(extras);
        if (originExtras == null) {
            Object extras2 = drawable.getExtras();
            ControllerListener2.Extras extras3 = extras2 instanceof ControllerListener2.Extras ? (ControllerListener2.Extras) extras2 : null;
            originExtras = extras3 != null ? getOriginExtras(extras3) : null;
        }
        if (originExtras == null || (obj = originExtras.get("origin")) == null || (string = obj.toString()) == null) {
            string = "unknown";
        }
        return TuplesKt.to(abbreviateOrigin(string), Integer.valueOf(DebugOverlayImageOriginColor.getImageOriginColor(string)));
    }

    public static final StringAndColorDebugDataProvider getImageOriginSubcategoryWithExtrasProvider() {
        return imageOriginSubcategoryWithExtrasProvider;
    }

    static final Pair imageOriginSubcategoryWithExtrasProvider$lambda$12(FrescoDrawableInterface drawable, ControllerListener2.Extras extras) {
        String string;
        Object obj;
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Map<String, Object> originExtras = getOriginExtras(extras);
        if (originExtras == null) {
            Object extras2 = drawable.getExtras();
            ControllerListener2.Extras extras3 = extras2 instanceof ControllerListener2.Extras ? (ControllerListener2.Extras) extras2 : null;
            originExtras = extras3 != null ? getOriginExtras(extras3) : null;
        }
        if (originExtras == null || (obj = originExtras.get("origin_sub")) == null || (string = obj.toString()) == null) {
            string = "unknown";
        }
        return TuplesKt.to(string, -7829368);
    }

    public static final StringDebugDataProvider getImageFormatProvider() {
        return imageFormatProvider;
    }

    static final String imageFormatProvider$lambda$15(FrescoDrawableInterface drawable, ControllerListener2.Extras extras) {
        String imageFormat;
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        String imageFormat2 = getImageFormat(extras);
        if (imageFormat2 != null) {
            return imageFormat2;
        }
        Object extras2 = drawable.getExtras();
        ControllerListener2.Extras extras3 = extras2 instanceof ControllerListener2.Extras ? (ControllerListener2.Extras) extras2 : null;
        return (extras3 == null || (imageFormat = getImageFormat(extras3)) == null) ? "" : imageFormat;
    }

    public static final StringDebugDataProvider getImageUriProvider() {
        return imageUriProvider;
    }

    static final String imageUriProvider$lambda$16(FrescoDrawableInterface drawable, ControllerListener2.Extras extras) {
        ImageRequest imageRequest;
        Uri sourceUri;
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        VitoImageRequest imageRequest2 = drawable.getImageRequest();
        String string = (imageRequest2 == null || (imageRequest = imageRequest2.finalImageRequest) == null || (sourceUri = imageRequest.getSourceUri()) == null) ? null : sourceUri.toString();
        if (string != null) {
            return truncateUri$default(string, 0, 2, null);
        }
        return "";
    }
}

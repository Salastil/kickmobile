package com.facebook.fresco.vito.core.impl.debug;

import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.vito.core.FrescoDrawableInterface;
import com.facebook.fresco.vito.core.impl.FrescoDrawable2;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FrescoDrawable2DebugDataProviders.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u001a \u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0003\"\u0011\u0010\b\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0003\"\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0011\u0010\u0014\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0003\"\u0011\u0010\u0016\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0003\"\u0011\u0010\u0018\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0003\"\u0011\u0010\u001a\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013\"\u0011\u0010\u001c\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013¨\u0006\u001e"}, d2 = {"actualImageDimensionsProvider", "Lcom/facebook/fresco/vito/core/impl/debug/StringDebugDataProvider;", "getActualImageDimensionsProvider", "()Lcom/facebook/fresco/vito/core/impl/debug/StringDebugDataProvider;", "actualImageDimensionsWithPrefixProvider", "getActualImageDimensionsWithPrefixProvider", "scaleTypeProvider", "getScaleTypeProvider", "abbreviatedScaleTypeProvider", "getAbbreviatedScaleTypeProvider", "getOriginExtras", "", "", "", "extras", "Lcom/facebook/fresco/ui/common/ControllerListener2$Extras;", "abbreviatedOriginWithExtrasProvider", "Lcom/facebook/fresco/vito/core/impl/debug/StringAndColorDebugDataProvider;", "getAbbreviatedOriginWithExtrasProvider", "()Lcom/facebook/fresco/vito/core/impl/debug/StringAndColorDebugDataProvider;", "drawableDimensionsWithExtrasProvider", "getDrawableDimensionsWithExtrasProvider", "imageFormatProvider", "getImageFormatProvider", "imageUriProvider", "getImageUriProvider", "imageOriginWithExtrasProvider", "getImageOriginWithExtrasProvider", "imageOriginSubcategoryWithExtrasProvider", "getImageOriginSubcategoryWithExtrasProvider", "core-java-impl_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FrescoDrawable2DebugDataProvidersKt {
    private static final StringDebugDataProvider actualImageDimensionsProvider = new StringDebugDataProvider("I", "Image dimensions", "The dimensions of the decoded image", new Function2() { // from class: com.facebook.fresco.vito.core.impl.debug.FrescoDrawable2DebugDataProvidersKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return FrescoDrawable2DebugDataProvidersKt.actualImageDimensionsProvider$lambda$0((FrescoDrawableInterface) obj, (ControllerListener2.Extras) obj2);
        }
    });
    private static final StringDebugDataProvider actualImageDimensionsWithPrefixProvider = new StringDebugDataProvider("img", "Image dimensions", "The dimensions of the decoded image (with prefix)", new Function2() { // from class: com.facebook.fresco.vito.core.impl.debug.FrescoDrawable2DebugDataProvidersKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return FrescoDrawable2DebugDataProvidersKt.actualImageDimensionsWithPrefixProvider$lambda$1((FrescoDrawableInterface) obj, (ControllerListener2.Extras) obj2);
        }
    });
    private static final StringDebugDataProvider scaleTypeProvider = new StringDebugDataProvider("scale", "Scale Type", "The scale type used to display the image", new Function2() { // from class: com.facebook.fresco.vito.core.impl.debug.FrescoDrawable2DebugDataProvidersKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return FrescoDrawable2DebugDataProvidersKt.scaleTypeProvider$lambda$2((FrescoDrawableInterface) obj, (ControllerListener2.Extras) obj2);
        }
    });
    private static final StringDebugDataProvider abbreviatedScaleTypeProvider = new StringDebugDataProvider("scale", "Scale Type", "The scale type used to display the image (abbreviated)", new Function2() { // from class: com.facebook.fresco.vito.core.impl.debug.FrescoDrawable2DebugDataProvidersKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return FrescoDrawable2DebugDataProvidersKt.abbreviatedScaleTypeProvider$lambda$3((FrescoDrawableInterface) obj, (ControllerListener2.Extras) obj2);
        }
    });
    private static final StringAndColorDebugDataProvider abbreviatedOriginWithExtrasProvider = new StringAndColorDebugDataProvider("o", "Origin", "The source of the image (abbreviated)", new Function2() { // from class: com.facebook.fresco.vito.core.impl.debug.FrescoDrawable2DebugDataProvidersKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return FrescoDrawable2DebugDataProvidersKt.abbreviatedOriginWithExtrasProvider$lambda$4((FrescoDrawableInterface) obj, (ControllerListener2.Extras) obj2);
        }
    });
    private static final StringDebugDataProvider drawableDimensionsWithExtrasProvider = DebugDataProviderKt.getDrawableDimensionsProvider();
    private static final StringDebugDataProvider imageFormatProvider = new StringDebugDataProvider("fmt", "Image Format", "The format of the image (JPEG, PNG, WEBP, etc.)", new Function2() { // from class: com.facebook.fresco.vito.core.impl.debug.FrescoDrawable2DebugDataProvidersKt$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return FrescoDrawable2DebugDataProvidersKt.imageFormatProvider$lambda$5((FrescoDrawableInterface) obj, (ControllerListener2.Extras) obj2);
        }
    });
    private static final StringDebugDataProvider imageUriProvider = new StringDebugDataProvider("uri", "Image URI", "The URI of the image (truncated)", new Function2() { // from class: com.facebook.fresco.vito.core.impl.debug.FrescoDrawable2DebugDataProvidersKt$$ExternalSyntheticLambda6
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return FrescoDrawable2DebugDataProvidersKt.imageUriProvider$lambda$6((FrescoDrawableInterface) obj, (ControllerListener2.Extras) obj2);
        }
    });
    private static final StringAndColorDebugDataProvider imageOriginWithExtrasProvider = new StringAndColorDebugDataProvider("origin", "Origin", "The source of the image", new Function2() { // from class: com.facebook.fresco.vito.core.impl.debug.FrescoDrawable2DebugDataProvidersKt$$ExternalSyntheticLambda7
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return FrescoDrawable2DebugDataProvidersKt.imageOriginWithExtrasProvider$lambda$7((FrescoDrawableInterface) obj, (ControllerListener2.Extras) obj2);
        }
    });
    private static final StringAndColorDebugDataProvider imageOriginSubcategoryWithExtrasProvider = new StringAndColorDebugDataProvider("origin_sub", "Origin Subcategory", "The subcategory of source of the image", new Function2() { // from class: com.facebook.fresco.vito.core.impl.debug.FrescoDrawable2DebugDataProvidersKt$$ExternalSyntheticLambda8
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return FrescoDrawable2DebugDataProvidersKt.imageOriginSubcategoryWithExtrasProvider$lambda$8((FrescoDrawableInterface) obj, (ControllerListener2.Extras) obj2);
        }
    });

    public static final StringDebugDataProvider getActualImageDimensionsProvider() {
        return actualImageDimensionsProvider;
    }

    static final String actualImageDimensionsProvider$lambda$0(FrescoDrawableInterface drawable, ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (drawable instanceof FrescoDrawable2) {
            FrescoDrawable2 frescoDrawable2 = (FrescoDrawable2) drawable;
            int actualImageWidthPx = frescoDrawable2.getActualImageWidthPx();
            int actualImageHeightPx = frescoDrawable2.getActualImageHeightPx();
            if (actualImageWidthPx > 0 && actualImageHeightPx > 0) {
                return DebugDataProviderKt.formatDimensions(actualImageWidthPx, actualImageHeightPx);
            }
            return "unset";
        }
        return "";
    }

    public static final StringDebugDataProvider getActualImageDimensionsWithPrefixProvider() {
        return actualImageDimensionsWithPrefixProvider;
    }

    static final String actualImageDimensionsWithPrefixProvider$lambda$1(FrescoDrawableInterface drawable, ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (drawable instanceof FrescoDrawable2) {
            FrescoDrawable2 frescoDrawable2 = (FrescoDrawable2) drawable;
            int actualImageWidthPx = frescoDrawable2.getActualImageWidthPx();
            int actualImageHeightPx = frescoDrawable2.getActualImageHeightPx();
            if (actualImageWidthPx > 0 && actualImageHeightPx > 0) {
                return "img:" + DebugDataProviderKt.formatDimensions(actualImageWidthPx, actualImageHeightPx);
            }
        }
        return "";
    }

    public static final StringDebugDataProvider getScaleTypeProvider() {
        return scaleTypeProvider;
    }

    static final String scaleTypeProvider$lambda$2(FrescoDrawableInterface drawable, ControllerListener2.Extras extras) {
        ScalingUtils.ScaleType actualImageScaleType;
        String string;
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        return (!(drawable instanceof FrescoDrawable2) || (actualImageScaleType = ((FrescoDrawable2) drawable).getActualImageScaleType()) == null || (string = actualImageScaleType.toString()) == null) ? "" : string;
    }

    public static final StringDebugDataProvider getAbbreviatedScaleTypeProvider() {
        return abbreviatedScaleTypeProvider;
    }

    static final String abbreviatedScaleTypeProvider$lambda$3(FrescoDrawableInterface drawable, ControllerListener2.Extras extras) {
        ScalingUtils.ScaleType actualImageScaleType;
        String string;
        String strTake;
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        return (!(drawable instanceof FrescoDrawable2) || (actualImageScaleType = ((FrescoDrawable2) drawable).getActualImageScaleType()) == null || (string = actualImageScaleType.toString()) == null || (strTake = StringsKt.take(string, 6)) == null) ? "" : strTake;
    }

    private static final Map<String, Object> getOriginExtras(ControllerListener2.Extras extras) {
        Map<String, ? extends Object> map;
        if (extras != null && (map = extras.datasourceExtras) != null) {
            return map;
        }
        if (extras != null) {
            return extras.shortcutExtras;
        }
        return null;
    }

    public static final StringAndColorDebugDataProvider getAbbreviatedOriginWithExtrasProvider() {
        return abbreviatedOriginWithExtrasProvider;
    }

    static final Pair abbreviatedOriginWithExtrasProvider$lambda$4(FrescoDrawableInterface frescoDrawableInterface, ControllerListener2.Extras extras) {
        String string;
        Object obj;
        Intrinsics.checkNotNullParameter(frescoDrawableInterface, "<unused var>");
        Map<String, Object> originExtras = getOriginExtras(extras);
        if (originExtras == null || (obj = originExtras.get("origin")) == null || (string = obj.toString()) == null) {
            string = "unknown";
        }
        String upperCase = StringsKt.take(string, 3).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return TuplesKt.to(upperCase, Integer.valueOf(DebugOverlayImageOriginColor.getImageOriginColor(string)));
    }

    public static final StringDebugDataProvider getDrawableDimensionsWithExtrasProvider() {
        return drawableDimensionsWithExtrasProvider;
    }

    public static final StringDebugDataProvider getImageFormatProvider() {
        return imageFormatProvider;
    }

    static final String imageFormatProvider$lambda$5(FrescoDrawableInterface frescoDrawableInterface, ControllerListener2.Extras extras) {
        String string;
        Object obj;
        Object obj2;
        Object obj3;
        Intrinsics.checkNotNullParameter(frescoDrawableInterface, "<unused var>");
        if (extras == null) {
            return "";
        }
        Map<String, ? extends Object> map = extras.imageExtras;
        if (map == null || (obj3 = map.get("image_format")) == null || (string = obj3.toString()) == null) {
            Map<String, ? extends Object> map2 = extras.shortcutExtras;
            if (map2 == null || (obj2 = map2.get("image_format")) == null) {
                Map<String, ? extends Object> map3 = extras.datasourceExtras;
                string = (map3 == null || (obj = map3.get("image_format")) == null) ? null : obj.toString();
            } else {
                string = obj2.toString();
            }
        }
        return string == null ? "" : string;
    }

    public static final StringDebugDataProvider getImageUriProvider() {
        return imageUriProvider;
    }

    static final String imageUriProvider$lambda$6(FrescoDrawableInterface frescoDrawableInterface, ControllerListener2.Extras extras) {
        String string;
        Map<String, ? extends Object> map;
        Object obj;
        Intrinsics.checkNotNullParameter(frescoDrawableInterface, "<unused var>");
        if (extras == null || (map = extras.imageSourceExtras) == null || (obj = map.get("uri")) == null || (string = obj.toString()) == null) {
            string = "";
        }
        if (string.length() <= 30) {
            return string;
        }
        return "..." + StringsKt.takeLast(string, 27);
    }

    public static final StringAndColorDebugDataProvider getImageOriginWithExtrasProvider() {
        return imageOriginWithExtrasProvider;
    }

    static final Pair imageOriginWithExtrasProvider$lambda$7(FrescoDrawableInterface frescoDrawableInterface, ControllerListener2.Extras extras) {
        String string;
        Object obj;
        Intrinsics.checkNotNullParameter(frescoDrawableInterface, "<unused var>");
        Map<String, Object> originExtras = getOriginExtras(extras);
        if (originExtras == null || (obj = originExtras.get("origin")) == null || (string = obj.toString()) == null) {
            string = "unknown";
        }
        return TuplesKt.to(string, Integer.valueOf(DebugOverlayImageOriginColor.getImageOriginColor(string)));
    }

    public static final StringAndColorDebugDataProvider getImageOriginSubcategoryWithExtrasProvider() {
        return imageOriginSubcategoryWithExtrasProvider;
    }

    static final Pair imageOriginSubcategoryWithExtrasProvider$lambda$8(FrescoDrawableInterface frescoDrawableInterface, ControllerListener2.Extras extras) {
        String string;
        Object obj;
        Intrinsics.checkNotNullParameter(frescoDrawableInterface, "<unused var>");
        Map<String, Object> originExtras = getOriginExtras(extras);
        if (originExtras == null || (obj = originExtras.get("origin_sub")) == null || (string = obj.toString()) == null) {
            string = "unknown";
        }
        return TuplesKt.to(string, -7829368);
    }
}

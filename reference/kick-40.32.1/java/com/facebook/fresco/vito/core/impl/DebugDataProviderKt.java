package com.facebook.fresco.vito.core.impl;

import android.graphics.Rect;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.datasource.DataSource;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.vito.core.FrescoDrawableInterface;
import com.facebook.fresco.vito.core.impl.debug.DebugOverlayImageOriginColor;
import com.facebook.fresco.vito.core.impl.debug.ImageFitRatioConfig;
import com.facebook.fresco.vito.core.impl.debug.StringAndColorDebugDataProvider;
import com.facebook.fresco.vito.core.impl.debug.StringDebugDataProvider;
import com.facebook.fresco.vito.renderer.BitmapImageDataModel;
import com.facebook.fresco.vito.renderer.ImageDataModel;
import com.facebook.imageutils.BitmapUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DebugDataProvider.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007*\u00020\nH\u0000\u001a(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002\u001a\u000e\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u000e\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001c\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0011\u0010\u0014\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013\"\u0011\u0010\u0016\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0003\"\u0011\u0010\u0018\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013¨\u0006\u001e"}, d2 = {"scanNumberProvider", "Lcom/facebook/fresco/vito/core/impl/debug/StringDebugDataProvider;", "getScanNumberProvider", "()Lcom/facebook/fresco/vito/core/impl/debug/StringDebugDataProvider;", "imageDimensionsProvider", "getImageDimensionsProvider", "extractOriginExtras", "", "", "", "Lcom/facebook/fresco/vito/core/impl/KFrescoVitoDrawable;", "getOriginExtrasFromDrawable", "drawable", "Lcom/facebook/fresco/vito/core/FrescoDrawableInterface;", "extras", "Lcom/facebook/fresco/ui/common/ControllerListener2$Extras;", "imageOriginProvider", "Lcom/facebook/fresco/vito/core/impl/debug/StringAndColorDebugDataProvider;", "getImageOriginProvider", "()Lcom/facebook/fresco/vito/core/impl/debug/StringAndColorDebugDataProvider;", "imageOriginSubcategoryProvider", "getImageOriginSubcategoryProvider", "imageDimensionsWithExtrasProvider", "getImageDimensionsWithExtrasProvider", "kFrescoImageOriginWithExtrasProvider", "getKFrescoImageOriginWithExtrasProvider", "createImageFitRatioProvider", "config", "Lcom/facebook/fresco/vito/core/impl/debug/ImageFitRatioConfig;", "createWastedMemoryProvider", "core-impl_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DebugDataProviderKt {
    private static final StringDebugDataProvider scanNumberProvider = new StringDebugDataProvider(ExifInterface.LATITUDE_SOUTH, "Scan Number", "The current progressive JPEG scan number", new Function2() { // from class: com.facebook.fresco.vito.core.impl.DebugDataProviderKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return DebugDataProviderKt.scanNumberProvider$lambda$0((FrescoDrawableInterface) obj, (ControllerListener2.Extras) obj2);
        }
    });
    private static final StringDebugDataProvider imageDimensionsProvider = new StringDebugDataProvider("I", "Image dimensions", "The dimensions of the decoded image", new Function2() { // from class: com.facebook.fresco.vito.core.impl.DebugDataProviderKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return DebugDataProviderKt.imageDimensionsProvider$lambda$1((FrescoDrawableInterface) obj, (ControllerListener2.Extras) obj2);
        }
    });
    private static final StringAndColorDebugDataProvider imageOriginProvider = new StringAndColorDebugDataProvider("o", "Origin", "The source of the image", new Function2() { // from class: com.facebook.fresco.vito.core.impl.DebugDataProviderKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return DebugDataProviderKt.imageOriginProvider$lambda$3((FrescoDrawableInterface) obj, (ControllerListener2.Extras) obj2);
        }
    });
    private static final StringAndColorDebugDataProvider imageOriginSubcategoryProvider = new StringAndColorDebugDataProvider("o_s", "Origin Subcategory", "The subcategory of source of the image", new Function2() { // from class: com.facebook.fresco.vito.core.impl.DebugDataProviderKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return DebugDataProviderKt.imageOriginSubcategoryProvider$lambda$4((FrescoDrawableInterface) obj, (ControllerListener2.Extras) obj2);
        }
    });
    private static final StringDebugDataProvider imageDimensionsWithExtrasProvider = new StringDebugDataProvider("I", "Image dimensions", "The dimensions of the decoded image", new Function2() { // from class: com.facebook.fresco.vito.core.impl.DebugDataProviderKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return DebugDataProviderKt.imageDimensionsWithExtrasProvider$lambda$5((FrescoDrawableInterface) obj, (ControllerListener2.Extras) obj2);
        }
    });
    private static final StringAndColorDebugDataProvider kFrescoImageOriginWithExtrasProvider = new StringAndColorDebugDataProvider("o", "Origin", "The source of the image", new Function2() { // from class: com.facebook.fresco.vito.core.impl.DebugDataProviderKt$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return DebugDataProviderKt.kFrescoImageOriginWithExtrasProvider$lambda$6((FrescoDrawableInterface) obj, (ControllerListener2.Extras) obj2);
        }
    });

    public static final StringDebugDataProvider getScanNumberProvider() {
        return scanNumberProvider;
    }

    static final String scanNumberProvider$lambda$0(FrescoDrawableInterface drawable, ControllerListener2.Extras extras) {
        Map<String, Object> extras2;
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (drawable instanceof KFrescoVitoDrawable) {
            KFrescoVitoDrawable kFrescoVitoDrawable = (KFrescoVitoDrawable) drawable;
            DataSource<? extends Object> dataSource = kFrescoVitoDrawable.getDataSource();
            Integer num = null;
            Object obj = (dataSource == null || (extras2 = dataSource.getExtras()) == null) ? null : extras2.get("last_scan_num");
            Integer num2 = obj instanceof Integer ? (Integer) obj : null;
            if (num2 == null) {
                Map<String, ? extends Object> map = ExtrasUtilsKt.obtainExtras$default(kFrescoVitoDrawable, null, null, null, 7, null).imageExtras;
                Object obj2 = map != null ? map.get("last_scan_num") : null;
                if (obj2 instanceof Integer) {
                    num = (Integer) obj2;
                }
            } else {
                num = num2;
            }
            if (num != null && num.intValue() > 0) {
                return "S:" + num;
            }
        }
        return "";
    }

    public static final StringDebugDataProvider getImageDimensionsProvider() {
        return imageDimensionsProvider;
    }

    static final String imageDimensionsProvider$lambda$1(FrescoDrawableInterface drawable, ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (drawable instanceof KFrescoVitoDrawable) {
            ImageDataModel dataModel = ((KFrescoVitoDrawable) drawable).getActualImageLayer().getDataModel();
            if (dataModel == null) {
                return "unset";
            }
            return com.facebook.fresco.vito.core.impl.debug.DebugDataProviderKt.formatDimensions(dataModel.getWidth(), dataModel.getHeight());
        }
        return "";
    }

    public static final Map<String, Object> extractOriginExtras(KFrescoVitoDrawable kFrescoVitoDrawable) {
        Map<String, Object> extras;
        Intrinsics.checkNotNullParameter(kFrescoVitoDrawable, "<this>");
        DataSource<? extends Object> dataSource = kFrescoVitoDrawable.getDataSource();
        return (dataSource == null || (extras = dataSource.getExtras()) == null) ? ExtrasUtilsKt.obtainExtras$default(kFrescoVitoDrawable, null, null, null, 7, null).shortcutExtras : extras;
    }

    private static final Map<String, Object> getOriginExtrasFromDrawable(FrescoDrawableInterface frescoDrawableInterface, ControllerListener2.Extras extras) {
        Map<String, Object> originExtras = com.facebook.fresco.vito.core.impl.debug.DebugDataProviderKt.getOriginExtras(extras);
        if (originExtras != null) {
            return originExtras;
        }
        if (frescoDrawableInterface instanceof KFrescoVitoDrawable) {
            return extractOriginExtras((KFrescoVitoDrawable) frescoDrawableInterface);
        }
        return null;
    }

    public static final StringAndColorDebugDataProvider getImageOriginProvider() {
        return imageOriginProvider;
    }

    static final Pair imageOriginProvider$lambda$3(FrescoDrawableInterface drawable, ControllerListener2.Extras extras) {
        String string;
        Object obj;
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (drawable instanceof KFrescoVitoDrawable) {
            Map<String, Object> mapExtractOriginExtras = extractOriginExtras((KFrescoVitoDrawable) drawable);
            if (mapExtractOriginExtras == null || (obj = mapExtractOriginExtras.get("origin")) == null || (string = obj.toString()) == null) {
                string = "unknown";
            }
            return TuplesKt.to(string, Integer.valueOf(DebugOverlayImageOriginColor.getImageOriginColor(string)));
        }
        return TuplesKt.to("", -1);
    }

    public static final StringAndColorDebugDataProvider getImageOriginSubcategoryProvider() {
        return imageOriginSubcategoryProvider;
    }

    static final Pair imageOriginSubcategoryProvider$lambda$4(FrescoDrawableInterface drawable, ControllerListener2.Extras extras) {
        String string;
        Object obj;
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (drawable instanceof KFrescoVitoDrawable) {
            Map<String, Object> mapExtractOriginExtras = extractOriginExtras((KFrescoVitoDrawable) drawable);
            if (mapExtractOriginExtras == null || (obj = mapExtractOriginExtras.get("origin_sub")) == null || (string = obj.toString()) == null) {
                string = "unknown";
            }
            return TuplesKt.to(string, -7829368);
        }
        return TuplesKt.to("", -1);
    }

    public static final StringDebugDataProvider getImageDimensionsWithExtrasProvider() {
        return imageDimensionsWithExtrasProvider;
    }

    static final String imageDimensionsWithExtrasProvider$lambda$5(FrescoDrawableInterface drawable, ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (drawable instanceof KFrescoVitoDrawable) {
            ImageDataModel dataModel = ((KFrescoVitoDrawable) drawable).getActualImageLayer().getDataModel();
            if (dataModel == null) {
                return "unset";
            }
            return com.facebook.fresco.vito.core.impl.debug.DebugDataProviderKt.formatDimensions(dataModel.getWidth(), dataModel.getHeight());
        }
        return "";
    }

    public static final StringAndColorDebugDataProvider getKFrescoImageOriginWithExtrasProvider() {
        return kFrescoImageOriginWithExtrasProvider;
    }

    static final Pair kFrescoImageOriginWithExtrasProvider$lambda$6(FrescoDrawableInterface drawable, ControllerListener2.Extras extras) {
        String string;
        Object obj;
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Map<String, Object> originExtrasFromDrawable = getOriginExtrasFromDrawable(drawable, extras);
        if (originExtrasFromDrawable == null || (obj = originExtrasFromDrawable.get("origin")) == null || (string = obj.toString()) == null) {
            string = "unknown";
        }
        return TuplesKt.to(string, Integer.valueOf(DebugOverlayImageOriginColor.getImageOriginColor(string)));
    }

    public static final StringAndColorDebugDataProvider createImageFitRatioProvider(final ImageFitRatioConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        return new StringAndColorDebugDataProvider("I:D", "Image fit ratio", "The ratio of image dimensions to target dimensions", new Function2() { // from class: com.facebook.fresco.vito.core.impl.DebugDataProviderKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return DebugDataProviderKt.createImageFitRatioProvider$lambda$7(config, (FrescoDrawableInterface) obj, (ControllerListener2.Extras) obj2);
            }
        });
    }

    static final Pair createImageFitRatioProvider$lambda$7(ImageFitRatioConfig imageFitRatioConfig, FrescoDrawableInterface drawable, ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (drawable instanceof KFrescoVitoDrawable) {
            KFrescoVitoDrawable kFrescoVitoDrawable = (KFrescoVitoDrawable) drawable;
            ImageDataModel dataModel = kFrescoVitoDrawable.getActualImageLayer().getDataModel();
            Rect viewportDimensions = kFrescoVitoDrawable.getViewportDimensions();
            int iWidth = (viewportDimensions == null || viewportDimensions.width() <= 0) ? kFrescoVitoDrawable.getBounds().width() : viewportDimensions.width();
            int iHeight = (viewportDimensions == null || viewportDimensions.height() <= 0) ? kFrescoVitoDrawable.getBounds().height() : viewportDimensions.height();
            if (dataModel != null) {
                return com.facebook.fresco.vito.core.impl.debug.DebugDataProviderKt.computeImageFitRatioAndColor(dataModel.getWidth(), dataModel.getHeight(), iWidth, iHeight, imageFitRatioConfig);
            }
            return TuplesKt.to("", -7829368);
        }
        return TuplesKt.to("", -7829368);
    }

    public static final StringAndColorDebugDataProvider createWastedMemoryProvider(final ImageFitRatioConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        return new StringAndColorDebugDataProvider("waste", "Wasted memory", "Memory wasted by oversized image (image bytes - target bytes)", new Function2() { // from class: com.facebook.fresco.vito.core.impl.DebugDataProviderKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return DebugDataProviderKt.createWastedMemoryProvider$lambda$8(config, (FrescoDrawableInterface) obj, (ControllerListener2.Extras) obj2);
            }
        });
    }

    static final Pair createWastedMemoryProvider$lambda$8(ImageFitRatioConfig imageFitRatioConfig, FrescoDrawableInterface drawable, ControllerListener2.Extras extras) {
        int pixelSizeForBitmapConfig;
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (drawable instanceof KFrescoVitoDrawable) {
            KFrescoVitoDrawable kFrescoVitoDrawable = (KFrescoVitoDrawable) drawable;
            ImageDataModel dataModel = kFrescoVitoDrawable.getActualImageLayer().getDataModel();
            if (dataModel instanceof BitmapImageDataModel) {
                Rect viewportDimensions = kFrescoVitoDrawable.getViewportDimensions();
                int iWidth = (viewportDimensions == null || viewportDimensions.width() <= 0) ? kFrescoVitoDrawable.getBounds().width() : viewportDimensions.width();
                int iHeight = (viewportDimensions == null || viewportDimensions.height() <= 0) ? kFrescoVitoDrawable.getBounds().height() : viewportDimensions.height();
                try {
                    pixelSizeForBitmapConfig = BitmapUtil.getPixelSizeForBitmapConfig(((BitmapImageDataModel) dataModel).getBitmap().getConfig());
                } catch (UnsupportedOperationException unused) {
                    pixelSizeForBitmapConfig = 4;
                }
                BitmapImageDataModel bitmapImageDataModel = (BitmapImageDataModel) dataModel;
                return com.facebook.fresco.vito.core.impl.debug.DebugDataProviderKt.computeWastedMemoryAndColor(bitmapImageDataModel.getWidth(), bitmapImageDataModel.getHeight(), iWidth, iHeight, pixelSizeForBitmapConfig, imageFitRatioConfig);
            }
            return TuplesKt.to("", -7829368);
        }
        return TuplesKt.to("", -7829368);
    }
}

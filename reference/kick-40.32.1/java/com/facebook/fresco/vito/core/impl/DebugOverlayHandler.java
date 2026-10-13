package com.facebook.fresco.vito.core.impl;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.core.view.ViewCompat;
import androidx.media3.common.C;
import com.facebook.common.internal.Supplier;
import com.facebook.fresco.vito.core.VitoImageRequest;
import com.facebook.fresco.vito.core.impl.debug.DebugDataProvider;
import com.facebook.fresco.vito.core.impl.debug.DebugLogcatReporter;
import com.facebook.fresco.vito.core.impl.debug.DebugOverlayDrawable;
import com.facebook.fresco.vito.core.impl.debug.DebugOverlayImageOriginColor;
import com.facebook.fresco.vito.core.impl.debug.ImageFitRatioConfig;
import com.facebook.fresco.vito.core.impl.debug.LightweightDebugOverlayDrawable;
import com.facebook.fresco.vito.core.impl.debug.StringAndColorDebugDataProvider;
import com.facebook.fresco.vito.core.impl.debug.StringDebugDataProvider;
import com.facebook.fresco.vito.renderer.DrawableImageDataModel;
import com.facebook.fresco.vito.renderer.ImageDataModel;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DebugOverlayHandler.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B/\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nB%\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/DebugOverlayHandler;", "", "isEnabled", "Lcom/facebook/common/internal/Supplier;", "", "useLightweight", "debugDataProviders", "", "Lcom/facebook/fresco/vito/core/impl/debug/DebugDataProvider;", "<init>", "(Lcom/facebook/common/internal/Supplier;ZLjava/util/List;)V", "(Lcom/facebook/common/internal/Supplier;Ljava/util/List;)V", "update", "", "drawable", "Lcom/facebook/fresco/vito/core/impl/KFrescoVitoDrawable;", "updateFull", "updateLightweight", "extractDebugOverlayDrawable", "Lcom/facebook/fresco/vito/core/impl/debug/DebugOverlayDrawable;", "extractLightweightOverlayDrawable", "Lcom/facebook/fresco/vito/core/impl/debug/LightweightDebugOverlayDrawable;", "core-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DebugOverlayHandler {
    private final List<DebugDataProvider> debugDataProviders;
    private final Supplier<Boolean> isEnabled;
    private final boolean useLightweight;

    /* JADX WARN: Multi-variable type inference failed */
    public DebugOverlayHandler(Supplier<Boolean> isEnabled, boolean z, List<? extends DebugDataProvider> debugDataProviders) {
        Intrinsics.checkNotNullParameter(isEnabled, "isEnabled");
        Intrinsics.checkNotNullParameter(debugDataProviders, "debugDataProviders");
        this.isEnabled = isEnabled;
        this.useLightweight = z;
        this.debugDataProviders = debugDataProviders;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ DebugOverlayHandler(Supplier supplier, boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        z = (i & 2) != 0 ? false : z;
        if ((i & 4) != 0) {
            List listCreateListBuilder = CollectionsKt.createListBuilder();
            listCreateListBuilder.add(com.facebook.fresco.vito.core.impl.debug.DebugDataProviderKt.getImageIDProvider());
            listCreateListBuilder.add(com.facebook.fresco.vito.core.impl.debug.DebugDataProviderKt.getDrawableDimensionsProvider());
            listCreateListBuilder.add(DebugDataProviderKt.getImageDimensionsProvider());
            listCreateListBuilder.add(DebugDataProviderKt.createImageFitRatioProvider(new ImageFitRatioConfig(0.0f, 0.0f, 0.0f, 0L, 15, null)));
            listCreateListBuilder.add(DebugDataProviderKt.createWastedMemoryProvider(new ImageFitRatioConfig(0.0f, 0.0f, 0.0f, 0L, 15, null)));
            listCreateListBuilder.add(DebugDataProviderKt.getImageOriginProvider());
            listCreateListBuilder.add(DebugDataProviderKt.getImageOriginSubcategoryProvider());
            listCreateListBuilder.add(com.facebook.fresco.vito.core.impl.debug.DebugDataProviderKt.getHdrGainmapProvider());
            list = CollectionsKt.build(listCreateListBuilder);
        }
        this(supplier, z, list);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DebugOverlayHandler(Supplier<Boolean> isEnabled, List<? extends DebugDataProvider> debugDataProviders) {
        this(isEnabled, false, debugDataProviders);
        Intrinsics.checkNotNullParameter(isEnabled, "isEnabled");
        Intrinsics.checkNotNullParameter(debugDataProviders, "debugDataProviders");
    }

    public final void update(KFrescoVitoDrawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (this.isEnabled.get().booleanValue()) {
            if (this.useLightweight) {
                updateLightweight(drawable);
            } else {
                updateFull(drawable);
            }
        }
    }

    private final void updateFull(final KFrescoVitoDrawable drawable) {
        ImageRequest imageRequest;
        Uri sourceUri;
        Object obj;
        DebugOverlayDrawable debugOverlayDrawableExtractDebugOverlayDrawable = extractDebugOverlayDrawable(drawable);
        drawable.setOnBoundsChangedCallback(new Function0() { // from class: com.facebook.fresco.vito.core.impl.DebugOverlayHandler$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DebugOverlayHandler.updateFull$lambda$1(this.f$0, drawable);
            }
        });
        debugOverlayDrawableExtractDebugOverlayDrawable.reset();
        for (DebugDataProvider debugDataProvider : this.debugDataProviders) {
            if (debugDataProvider instanceof StringDebugDataProvider) {
                DebugOverlayDrawable.addDebugData$default(debugOverlayDrawableExtractDebugOverlayDrawable, debugDataProvider.getShortName(), ((StringDebugDataProvider) debugDataProvider).extractData(drawable), 0, 4, null);
            } else {
                if (!(debugDataProvider instanceof StringAndColorDebugDataProvider)) {
                    throw new NoWhenBranchMatchedException();
                }
                Pair<String, Integer> pairExtractDataAndColor = ((StringAndColorDebugDataProvider) debugDataProvider).extractDataAndColor(drawable);
                String strComponent1 = pairExtractDataAndColor.component1();
                int iIntValue = pairExtractDataAndColor.component2().intValue();
                debugOverlayDrawableExtractDebugOverlayDrawable.addDebugData(debugDataProvider.getShortName(), strComponent1, iIntValue);
                if (Intrinsics.areEqual(debugDataProvider.getShortName(), "I:D") && strComponent1.length() > 0) {
                    debugOverlayDrawableExtractDebugOverlayDrawable.setBackgroundColor((iIntValue & ViewCompat.MEASURED_SIZE_MASK) | C.ENCODING_PCM_24BIT_BIG_ENDIAN);
                }
            }
        }
        ImageDataModel dataModel = drawable.getActualImageLayer().getDataModel();
        if (dataModel != null) {
            Rect viewportDimensions = drawable.getViewportDimensions();
            int iWidth = (viewportDimensions == null || viewportDimensions.width() <= 0) ? drawable.getBounds().width() : viewportDimensions.width();
            int iHeight = (viewportDimensions == null || viewportDimensions.height() <= 0) ? drawable.getBounds().height() : viewportDimensions.height();
            Map<String, Object> mapExtractOriginExtras = DebugDataProviderKt.extractOriginExtras(drawable);
            String string = null;
            String string2 = (mapExtractOriginExtras == null || (obj = mapExtractOriginExtras.get("origin")) == null) ? null : obj.toString();
            DebugLogcatReporter debugLogcatReporter = DebugLogcatReporter.INSTANCE;
            long j = drawable.get_imageId();
            VitoImageRequest imageRequest2 = drawable.getImageRequest();
            if (imageRequest2 != null && (imageRequest = imageRequest2.finalImageRequest) != null && (sourceUri = imageRequest.getSourceUri()) != null) {
                string = sourceUri.toString();
            }
            debugLogcatReporter.maybeReport(j, string, dataModel.getWidth(), dataModel.getHeight(), iWidth, iHeight, string2, (128 & 128) != 0 ? new ImageFitRatioConfig(0.0f, 0.0f, 0.0f, 0L, 15, null) : null);
        }
    }

    static final Unit updateFull$lambda$1(DebugOverlayHandler debugOverlayHandler, KFrescoVitoDrawable kFrescoVitoDrawable) {
        debugOverlayHandler.update(kFrescoVitoDrawable);
        return Unit.INSTANCE;
    }

    private final void updateLightweight(KFrescoVitoDrawable drawable) {
        LightweightDebugOverlayDrawable lightweightDebugOverlayDrawableExtractLightweightOverlayDrawable = extractLightweightOverlayDrawable(drawable);
        ArrayList arrayList = new ArrayList();
        int imageOriginColor = DebugOverlayImageOriginColor.getImageOriginColor("unknown");
        boolean z = false;
        for (DebugDataProvider debugDataProvider : this.debugDataProviders) {
            if (debugDataProvider instanceof StringDebugDataProvider) {
                arrayList.add(((StringDebugDataProvider) debugDataProvider).extractData(drawable));
            } else {
                if (!(debugDataProvider instanceof StringAndColorDebugDataProvider)) {
                    throw new NoWhenBranchMatchedException();
                }
                Pair<String, Integer> pairExtractDataAndColor = ((StringAndColorDebugDataProvider) debugDataProvider).extractDataAndColor(drawable);
                String strComponent1 = pairExtractDataAndColor.component1();
                int iIntValue = pairExtractDataAndColor.component2().intValue();
                arrayList.add(strComponent1);
                if (!z) {
                    z = true;
                    imageOriginColor = iIntValue;
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        lightweightDebugOverlayDrawableExtractLightweightOverlayDrawable.setDebugText(CollectionsKt.joinToString$default(arrayList2, " | ", null, null, 0, null, null, 62, null));
        lightweightDebugOverlayDrawableExtractLightweightOverlayDrawable.setOriginColor(imageOriginColor);
    }

    private final DebugOverlayDrawable extractDebugOverlayDrawable(KFrescoVitoDrawable drawable) {
        ImageLayerDataModel debugOverlayImageLayer = drawable.getDebugOverlayImageLayer();
        ImageDataModel dataModel = debugOverlayImageLayer != null ? debugOverlayImageLayer.getDataModel() : null;
        if (dataModel != null && (dataModel instanceof DrawableImageDataModel)) {
            DrawableImageDataModel drawableImageDataModel = (DrawableImageDataModel) dataModel;
            if (drawableImageDataModel.getDrawable() instanceof DebugOverlayDrawable) {
                Drawable drawable2 = drawableImageDataModel.getDrawable();
                Intrinsics.checkNotNull(drawable2, "null cannot be cast to non-null type com.facebook.fresco.vito.core.impl.debug.DebugOverlayDrawable");
                return (DebugOverlayDrawable) drawable2;
            }
        }
        DebugOverlayDrawable debugOverlayDrawable = new DebugOverlayDrawable("K", 0, 2, null);
        ImageLayerDataModel imageLayerDataModelCreateLayer$core_impl_release = drawable.createLayer$core_impl_release();
        ImageLayerDataModel.configure$default(imageLayerDataModelCreateLayer$core_impl_release, new DrawableImageDataModel(debugOverlayDrawable, false, 2, null), null, null, null, null, null, 62, null);
        drawable.setDebugOverlayImageLayer(imageLayerDataModelCreateLayer$core_impl_release);
        return debugOverlayDrawable;
    }

    private final LightweightDebugOverlayDrawable extractLightweightOverlayDrawable(KFrescoVitoDrawable drawable) {
        ImageLayerDataModel debugOverlayImageLayer = drawable.getDebugOverlayImageLayer();
        ImageDataModel dataModel = debugOverlayImageLayer != null ? debugOverlayImageLayer.getDataModel() : null;
        if (dataModel != null && (dataModel instanceof DrawableImageDataModel)) {
            DrawableImageDataModel drawableImageDataModel = (DrawableImageDataModel) dataModel;
            if (drawableImageDataModel.getDrawable() instanceof LightweightDebugOverlayDrawable) {
                Drawable drawable2 = drawableImageDataModel.getDrawable();
                Intrinsics.checkNotNull(drawable2, "null cannot be cast to non-null type com.facebook.fresco.vito.core.impl.debug.LightweightDebugOverlayDrawable");
                return (LightweightDebugOverlayDrawable) drawable2;
            }
        }
        LightweightDebugOverlayDrawable lightweightDebugOverlayDrawable = new LightweightDebugOverlayDrawable();
        ImageLayerDataModel imageLayerDataModelCreateLayer$core_impl_release = drawable.createLayer$core_impl_release();
        ImageLayerDataModel.configure$default(imageLayerDataModelCreateLayer$core_impl_release, new DrawableImageDataModel(lightweightDebugOverlayDrawable, false, 2, null), null, null, null, null, null, 62, null);
        drawable.setDebugOverlayImageLayer(imageLayerDataModelCreateLayer$core_impl_release);
        return lightweightDebugOverlayDrawable;
    }
}

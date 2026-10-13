package com.facebook.fresco.vito.core.impl;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.fresco.middleware.MiddlewareUtils;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.ui.common.ImagePerfDataListener;
import com.facebook.fresco.ui.common.ImagePerfDataNotifier;
import com.facebook.fresco.ui.common.OnFadeListener;
import com.facebook.fresco.ui.common.VitoUtils;
import com.facebook.fresco.urimod.DimensionsKt;
import com.facebook.fresco.vito.core.FrescoController2;
import com.facebook.fresco.vito.core.FrescoDrawableInterface;
import com.facebook.fresco.vito.core.FrescoVitoConfig;
import com.facebook.fresco.vito.core.ImagePerfLoggingListener;
import com.facebook.fresco.vito.core.NopDrawable;
import com.facebook.fresco.vito.core.VitoImagePerfListener;
import com.facebook.fresco.vito.core.VitoImagePipeline;
import com.facebook.fresco.vito.core.VitoImageRequest;
import com.facebook.fresco.vito.core.VitoImageRequestListener;
import com.facebook.fresco.vito.core.impl.debug.DebugOverlayFactory2;
import com.facebook.fresco.vito.listener.ImageListener;
import com.facebook.fresco.vito.source.BitmapImageSource;
import com.facebook.fresco.vito.source.ColorImageSource;
import com.facebook.fresco.vito.source.DrawableImageSource;
import com.facebook.fresco.vito.source.DrawableResImageSource;
import com.facebook.fresco.vito.source.EmptyImageSource;
import com.facebook.fresco.vito.source.ImageSource;
import com.facebook.fresco.vito.source.SmartImageSource;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.image.ImageInfoImpl;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FrescoController2Impl.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0001KBY\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0017\u001a\u0002H\u0018\"\f\b\u0000\u0010\u0018*\u00020\u0019*\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0002\u0010\u001dJ^\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u00010\rH\u0016J\"\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J \u00104\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u0010!\u001a\u00020\"2\u0006\u00105\u001a\u000206H\u0002J\u0010\u00107\u001a\u0002012\u0006\u0010 \u001a\u00020\u001aH\u0016J\u0010\u00108\u001a\u0002012\u0006\u0010 \u001a\u00020\u001aH\u0016J\u0010\u00109\u001a\u0002012\u0006\u0010 \u001a\u00020\u001aH\u0016JP\u0010:\u001a\u0002012\u0006\u0010 \u001a\u0002032\u0006\u0010!\u001a\u00020\"2\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<2\u0006\u0010>\u001a\u00020\u001f2\u0014\u0010?\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0<\u0018\u00010@2\b\b\u0002\u0010A\u001a\u00020\u001fH\u0002J,\u0010B\u001a\u0002012\u0006\u0010 \u001a\u0002032\u0006\u0010!\u001a\u00020\"2\u0012\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0<0@H\u0016J,\u0010C\u001a\u0002012\u0006\u0010 \u001a\u0002032\u0006\u0010!\u001a\u00020\"2\u0012\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0<0@H\u0016J,\u0010D\u001a\u0002012\u0006\u0010 \u001a\u0002032\u0006\u0010!\u001a\u00020\"2\u0012\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0<0@H\u0016J\u0010\u0010E\u001a\u0002012\u0006\u0010 \u001a\u000203H\u0016J\u0018\u0010F\u001a\u00020\u001f2\u0006\u0010 \u001a\u0002032\u0006\u0010!\u001a\u00020\"H\u0002J(\u0010G\u001a\u0002012\u0006\u0010 \u001a\u0002032\u0006\u0010!\u001a\u00020\"2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/FrescoController2Impl;", "Lcom/facebook/fresco/vito/core/impl/DrawableDataSubscriber;", "Lcom/facebook/fresco/vito/core/FrescoController2;", "config", "Lcom/facebook/fresco/vito/core/FrescoVitoConfig;", "hierarcher", "Lcom/facebook/fresco/vito/core/impl/Hierarcher;", "lightweightBackgroundThreadExecutor", "Ljava/util/concurrent/Executor;", "uiThreadExecutor", "imagePipeline", "Lcom/facebook/fresco/vito/core/VitoImagePipeline;", "globalImageListener", "Lcom/facebook/fresco/vito/core/VitoImageRequestListener;", "debugOverlayFactory", "Lcom/facebook/fresco/vito/core/impl/debug/DebugOverlayFactory2;", "imagePerfListenerSupplier", "Lcom/facebook/common/internal/Supplier;", "Lcom/facebook/fresco/vito/core/ImagePerfLoggingListener;", "vitoImagePerfListener", "Lcom/facebook/fresco/vito/core/VitoImagePerfListener;", "<init>", "(Lcom/facebook/fresco/vito/core/FrescoVitoConfig;Lcom/facebook/fresco/vito/core/impl/Hierarcher;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Lcom/facebook/fresco/vito/core/VitoImagePipeline;Lcom/facebook/fresco/vito/core/VitoImageRequestListener;Lcom/facebook/fresco/vito/core/impl/debug/DebugOverlayFactory2;Lcom/facebook/common/internal/Supplier;Lcom/facebook/fresco/vito/core/VitoImagePerfListener;)V", "createDrawable", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/graphics/drawable/Drawable;", "Lcom/facebook/fresco/vito/core/FrescoDrawableInterface;", "uiFramework", "", "(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;", "fetch", "", "drawable", "imageRequest", "Lcom/facebook/fresco/vito/core/VitoImageRequest;", "callerContext", "", "contextChain", "Lcom/facebook/common/callercontext/ContextChain;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/facebook/fresco/vito/listener/ImageListener;", "perfDataListener", "Lcom/facebook/fresco/ui/common/ImagePerfDataListener;", "onFadeListener", "Lcom/facebook/fresco/ui/common/OnFadeListener;", "viewportDimensions", "Landroid/graphics/Rect;", "vitoImageRequestListener", "emptyRequestFastPath", "", "frescoDrawable", "Lcom/facebook/fresco/vito/core/impl/FrescoDrawable2Impl;", "setUpPlaceholder", "imageId", "", "releaseDelayed", "releaseNextFrame", "releaseImmediately", "setActualImage", "image", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "displayImmediately", "dataSource", "Lcom/facebook/datasource/DataSource;", "isIntermediateImage", "onNewResult", "onFailure", "onProgressUpdate", "onRelease", "isAlreadyLoadingImage", "setActualDrawable", "extras", "Lcom/facebook/fresco/ui/common/ControllerListener2$Extras;", "actualImageDrawable", "Companion", "core-java-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class FrescoController2Impl implements DrawableDataSubscriber, FrescoController2 {
    private static final Map<String, Object> COMPONENT_EXTRAS;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long EMPTY_IMAGE_ID = Long.MAX_VALUE;
    private static final Map<String, Object> SHORTCUT_EXTRAS;
    private static final String TAG = "FrescoController2Impl";
    private final FrescoVitoConfig config;
    private final DebugOverlayFactory2 debugOverlayFactory;
    private final VitoImageRequestListener globalImageListener;
    private final Hierarcher hierarcher;
    private final Supplier<ImagePerfLoggingListener> imagePerfListenerSupplier;
    private final VitoImagePipeline imagePipeline;
    private final Executor lightweightBackgroundThreadExecutor;
    private final Executor uiThreadExecutor;
    private final VitoImagePerfListener vitoImagePerfListener;

    static final void fetch$lambda$0(Bitmap bitmap) {
    }

    public FrescoController2Impl(FrescoVitoConfig config, Hierarcher hierarcher, Executor lightweightBackgroundThreadExecutor, Executor uiThreadExecutor, VitoImagePipeline imagePipeline, VitoImageRequestListener vitoImageRequestListener, DebugOverlayFactory2 debugOverlayFactory, Supplier<ImagePerfLoggingListener> supplier, VitoImagePerfListener vitoImagePerfListener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(hierarcher, "hierarcher");
        Intrinsics.checkNotNullParameter(lightweightBackgroundThreadExecutor, "lightweightBackgroundThreadExecutor");
        Intrinsics.checkNotNullParameter(uiThreadExecutor, "uiThreadExecutor");
        Intrinsics.checkNotNullParameter(imagePipeline, "imagePipeline");
        Intrinsics.checkNotNullParameter(debugOverlayFactory, "debugOverlayFactory");
        Intrinsics.checkNotNullParameter(vitoImagePerfListener, "vitoImagePerfListener");
        this.config = config;
        this.hierarcher = hierarcher;
        this.lightweightBackgroundThreadExecutor = lightweightBackgroundThreadExecutor;
        this.uiThreadExecutor = uiThreadExecutor;
        this.imagePipeline = imagePipeline;
        this.globalImageListener = vitoImageRequestListener;
        this.debugOverlayFactory = debugOverlayFactory;
        this.imagePerfListenerSupplier = supplier;
        this.vitoImagePerfListener = vitoImagePerfListener;
    }

    @Override // com.facebook.fresco.vito.core.FrescoController2
    public <T extends Drawable & FrescoDrawableInterface> T createDrawable() {
        return (T) super.createDrawable();
    }

    @Override // com.facebook.fresco.vito.core.FrescoController2
    public <T extends Drawable & FrescoDrawableInterface> T createDrawable(String uiFramework) {
        boolean zUseNewReleaseCallback = this.config.useNewReleaseCallback();
        Supplier<ImagePerfLoggingListener> supplier = this.imagePerfListenerSupplier;
        return new FrescoDrawable2Impl(zUseNewReleaseCallback, supplier != null ? supplier.get() : null, this.vitoImagePerfListener, uiFramework, this.config.experimentalResetVitoImageRequestListener(), this.config.experimentalResetLocalVitoImageRequestListener(), this.config.experimentalResetLocalImagePerfStateListener(), this.config.experimentalResetControllerListener2());
    }

    @Override // com.facebook.fresco.vito.core.FrescoController2
    public boolean fetch(final FrescoDrawableInterface drawable, final VitoImageRequest imageRequest, final Object callerContext, ContextChain contextChain, ImageListener listener, ImagePerfDataListener perfDataListener, OnFadeListener onFadeListener, final Rect viewportDimensions, VitoImageRequestListener vitoImageRequestListener) throws Throwable {
        boolean z;
        CloseableImage closeableImage;
        QualityInfo qualityInfo;
        CloseableReference closeableReference;
        ControllerListener2.Extras tempFinalImageExtras;
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        if (!(drawable instanceof FrescoDrawable2Impl)) {
            FLog.e(TAG, "Drawable not supported " + drawable);
            return false;
        }
        if (this.config.fastPathForEmptyRequests() && (imageRequest.imageSource instanceof EmptyImageSource)) {
            emptyRequestFastPath((FrescoDrawable2Impl) drawable, imageRequest, callerContext);
            return true;
        }
        FrescoDrawable2Impl frescoDrawable2Impl = (FrescoDrawable2Impl) drawable;
        frescoDrawable2Impl.setViewportDimensions(viewportDimensions);
        if (this.config.enableRetriggerListenersIfImageAlreadySet()) {
            frescoDrawable2Impl.setRetriggerListenersIfImageAlreadySet(true);
        }
        boolean forceReloadIfImageAlreadySet = frescoDrawable2Impl.getForceReloadIfImageAlreadySet();
        boolean retriggerListenersIfImageAlreadySet = frescoDrawable2Impl.getRetriggerListenersIfImageAlreadySet();
        if (!forceReloadIfImageAlreadySet && isAlreadyLoadingImage(frescoDrawable2Impl, imageRequest)) {
            frescoDrawable2Impl.cancelReleaseNextFrame();
            frescoDrawable2Impl.cancelReleaseDelayed();
            if (retriggerListenersIfImageAlreadySet) {
                frescoDrawable2Impl.getInternalListener().onSubmit(frescoDrawable2Impl.get_imageId(), imageRequest, callerContext, INSTANCE.obtainExtras(null, null, (FrescoDrawable2) drawable, imageRequest));
                frescoDrawable2Impl.getImagePerfListener().onImageFetch(drawable);
                Drawable actualImageDrawable = frescoDrawable2Impl.getActualImageDrawable();
                if (actualImageDrawable != null && (tempFinalImageExtras = frescoDrawable2Impl.getTempFinalImageExtras()) != null) {
                    HashMap map = tempFinalImageExtras.imageExtras;
                    if (map == null) {
                        map = new HashMap();
                    }
                    frescoDrawable2Impl.getInternalListener().onFinalImageSet(frescoDrawable2Impl.get_imageId(), imageRequest, 7, new ImageInfoImpl(actualImageDrawable.getIntrinsicWidth(), actualImageDrawable.getIntrinsicHeight(), 0, ImmutableQualityInfo.FULL_QUALITY, map), tempFinalImageExtras, actualImageDrawable);
                    frescoDrawable2Impl.getImagePerfListener().onImageSuccess(drawable, true);
                }
            }
            return true;
        }
        if (frescoDrawable2Impl.getFetchSubmitted()) {
            frescoDrawable2Impl.getImagePerfListener().onDrawableReconfigured(drawable);
        }
        frescoDrawable2Impl.close();
        if (forceReloadIfImageAlreadySet) {
            frescoDrawable2Impl.setForceReloadIfImageAlreadySet(true);
        }
        if (retriggerListenersIfImageAlreadySet) {
            frescoDrawable2Impl.setRetriggerListenersIfImageAlreadySet(retriggerListenersIfImageAlreadySet);
        }
        frescoDrawable2Impl.setDrawableDataSubscriber(this);
        frescoDrawable2Impl.setImageRequest(imageRequest);
        frescoDrawable2Impl.setCallerContext(callerContext);
        frescoDrawable2Impl.setImageListener(listener);
        frescoDrawable2Impl.setVitoImageRequestListener(this.globalImageListener);
        frescoDrawable2Impl.setLocalVitoImageRequestListener(vitoImageRequestListener);
        if (perfDataListener != null) {
            frescoDrawable2Impl.getInternalListener().setLocalImagePerfStateListener(new ImagePerfDataNotifier(perfDataListener));
        } else {
            frescoDrawable2Impl.getInternalListener().setLocalImagePerfStateListener(null);
        }
        frescoDrawable2Impl.setOnFadeListener(onFadeListener);
        frescoDrawable2Impl.setOverlayDrawable(this.hierarcher.buildOverlayDrawable(imageRequest.resources, imageRequest.imageOptions));
        final long jGenerateIdentifier = VitoUtils.generateIdentifier();
        frescoDrawable2Impl.setImageId(jGenerateIdentifier);
        FrescoDrawable2 frescoDrawable2 = (FrescoDrawable2) drawable;
        ControllerListener2.Extras extrasObtainExtras = INSTANCE.obtainExtras(null, null, frescoDrawable2, imageRequest);
        frescoDrawable2Impl.getInternalListener().onSubmit(jGenerateIdentifier, imageRequest, callerContext, extrasObtainExtras);
        frescoDrawable2Impl.getImagePerfListener().onImageFetch(drawable);
        if (imageRequest.imageSource instanceof BitmapImageSource) {
            ImageSource imageSource = imageRequest.imageSource;
            Intrinsics.checkNotNull(imageSource, "null cannot be cast to non-null type com.facebook.fresco.vito.source.BitmapImageSource");
            CloseableStaticBitmap closeableStaticBitmapOf = CloseableStaticBitmap.of(((BitmapImageSource) imageSource).getBitmap(), (ResourceReleaser<Bitmap>) new ResourceReleaser() { // from class: com.facebook.fresco.vito.core.impl.FrescoController2Impl$$ExternalSyntheticLambda0
                @Override // com.facebook.common.references.ResourceReleaser
                public final void release(Object obj) {
                    FrescoController2Impl.fetch$lambda$0((Bitmap) obj);
                }
            }, ImmutableQualityInfo.FULL_QUALITY, 0);
            Intrinsics.checkNotNullExpressionValue(closeableStaticBitmapOf, "of(...)");
            CloseableReference closeableReferenceOf = CloseableReference.of(closeableStaticBitmapOf);
            Intrinsics.checkNotNullExpressionValue(closeableReferenceOf, "of(...)");
            try {
                ((FrescoDrawable2Impl) drawable).setImageOrigin(5);
                closeableReference = closeableReferenceOf;
                try {
                    setActualImage$default(this, (FrescoDrawable2Impl) drawable, imageRequest, closeableReference, true, null, false, 32, null);
                    ((FrescoDrawable2Impl) drawable).setFetchSubmitted(true);
                    CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
                    return true;
                } catch (Throwable th) {
                    th = th;
                    CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                closeableReference = closeableReferenceOf;
            }
        } else {
            if (imageRequest.imageSource instanceof ColorImageSource) {
                ImageSource imageSource2 = imageRequest.imageSource;
                Intrinsics.checkNotNull(imageSource2, "null cannot be cast to non-null type com.facebook.fresco.vito.source.ColorImageSource");
                setActualDrawable(frescoDrawable2Impl, imageRequest, extrasObtainExtras, new ColorDrawable(((ColorImageSource) imageSource2).getColor()));
                return true;
            }
            if (imageRequest.imageSource instanceof DrawableImageSource) {
                ImageSource imageSource3 = imageRequest.imageSource;
                Intrinsics.checkNotNull(imageSource3, "null cannot be cast to non-null type com.facebook.fresco.vito.source.DrawableImageSource");
                setActualDrawable(frescoDrawable2Impl, imageRequest, extrasObtainExtras, ((DrawableImageSource) imageSource3).getDrawable());
                return true;
            }
            if (imageRequest.imageSource instanceof DrawableResImageSource) {
                ImageSource imageSource4 = imageRequest.imageSource;
                Intrinsics.checkNotNull(imageSource4, "null cannot be cast to non-null type com.facebook.fresco.vito.source.DrawableResImageSource");
                setActualDrawable(frescoDrawable2Impl, imageRequest, extrasObtainExtras, ((DrawableResImageSource) imageSource4).createDrawable(imageRequest.resources));
                return true;
            }
            CloseableReference<CloseableImage> cachedImage = this.imagePipeline.getCachedImage(imageRequest);
            try {
                if (CloseableReference.isValid(cachedImage)) {
                    ((FrescoDrawable2Impl) drawable).setImageOrigin(6);
                    boolean z2 = this.config.useIntermediateImagesAsPlaceholder() && (cachedImage == null || (closeableImage = cachedImage.get()) == null || (qualityInfo = closeableImage.getQualityInfo()) == null || !qualityInfo.isOfFullQuality());
                    setActualImage((FrescoDrawable2Impl) drawable, imageRequest, cachedImage, true, null, z2);
                    ((FrescoDrawable2Impl) drawable).setFetchSubmitted(true);
                    if (!z2) {
                        CloseableReference.closeSafely(cachedImage);
                        return true;
                    }
                    z = false;
                } else {
                    z = true;
                }
                CloseableReference.closeSafely(cachedImage);
                if (z) {
                    frescoDrawable2Impl.setProgressDrawable(this.hierarcher.buildProgressDrawable(imageRequest.resources, imageRequest.imageOptions));
                    frescoDrawable2Impl.setProgress(0.0f);
                    frescoDrawable2Impl.showProgressImmediately();
                    setUpPlaceholder(frescoDrawable2Impl, imageRequest, jGenerateIdentifier);
                }
                Runnable runnable = new Runnable() { // from class: com.facebook.fresco.vito.core.impl.FrescoController2Impl$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        FrescoController2Impl.fetch$lambda$1(jGenerateIdentifier, drawable, this, imageRequest, callerContext, viewportDimensions);
                    }
                };
                if (this.config.submitFetchOnBgThread()) {
                    this.lightweightBackgroundThreadExecutor.execute(runnable);
                } else {
                    runnable.run();
                }
                frescoDrawable2Impl.setFetchSubmitted(true);
                this.debugOverlayFactory.update(frescoDrawable2, null);
                return false;
            } catch (Throwable th3) {
                CloseableReference.closeSafely(cachedImage);
                throw th3;
            }
        }
    }

    static final void fetch$lambda$1(long j, FrescoDrawableInterface frescoDrawableInterface, FrescoController2Impl frescoController2Impl, VitoImageRequest vitoImageRequest, Object obj, Rect rect) {
        FrescoDrawable2Impl frescoDrawable2Impl = (FrescoDrawable2Impl) frescoDrawableInterface;
        if (j != frescoDrawable2Impl.get_imageId()) {
            return;
        }
        DataSource<CloseableReference<CloseableImage>> dataSourceFetchDecodedImage = frescoController2Impl.imagePipeline.fetchDecodedImage(vitoImageRequest, obj, frescoDrawable2Impl.getImageOriginListener(), j, rect != null ? DimensionsKt.asDimensions(rect) : null);
        frescoDrawable2Impl.setDataSource(j, dataSourceFetchDecodedImage);
        dataSourceFetchDecodedImage.subscribe((DataSubscriber) frescoDrawableInterface, frescoController2Impl.uiThreadExecutor);
    }

    private final void emptyRequestFastPath(FrescoDrawable2Impl frescoDrawable, VitoImageRequest imageRequest, Object callerContext) {
        frescoDrawable.close();
        frescoDrawable.setVitoImageRequestListener(this.globalImageListener);
        frescoDrawable.getInternalListener().onEmptyEvent(callerContext);
        frescoDrawable.setOverlayDrawable(this.hierarcher.buildOverlayDrawable(imageRequest.resources, imageRequest.imageOptions));
        setUpPlaceholder(frescoDrawable, imageRequest, Long.MAX_VALUE);
    }

    private final void setUpPlaceholder(FrescoDrawable2Impl frescoDrawable, VitoImageRequest imageRequest, long imageId) {
        Drawable drawableBuildPlaceholderDrawable = this.hierarcher.buildPlaceholderDrawable(imageRequest.resources, imageRequest.imageOptions);
        frescoDrawable.setPlaceholderDrawable(drawableBuildPlaceholderDrawable);
        frescoDrawable.setImageDrawable(null);
        frescoDrawable.getInternalListener().onPlaceholderSet(imageId, imageRequest, drawableBuildPlaceholderDrawable);
    }

    @Override // com.facebook.fresco.vito.core.FrescoController2
    public void releaseDelayed(FrescoDrawableInterface drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (!(drawable instanceof FrescoDrawable2Impl)) {
            FLog.e(TAG, "Drawable not supported " + drawable);
        } else {
            FrescoDrawable2Impl frescoDrawable2Impl = (FrescoDrawable2Impl) drawable;
            frescoDrawable2Impl.getImagePerfListener().onScheduleReleaseDelayed(drawable);
            frescoDrawable2Impl.scheduleReleaseDelayed(this.config.releaseDelayMs());
        }
    }

    @Override // com.facebook.fresco.vito.core.FrescoController2
    public void releaseNextFrame(FrescoDrawableInterface drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (!(drawable instanceof FrescoDrawable2Impl)) {
            FLog.e(TAG, "Drawable not supported " + drawable);
        } else {
            FrescoDrawable2Impl frescoDrawable2Impl = (FrescoDrawable2Impl) drawable;
            frescoDrawable2Impl.getImagePerfListener().onScheduleReleaseNextFrame(drawable);
            frescoDrawable2Impl.scheduleReleaseNextFrame();
        }
    }

    @Override // com.facebook.fresco.vito.core.FrescoController2
    public void releaseImmediately(FrescoDrawableInterface drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (!(drawable instanceof FrescoDrawable2Impl)) {
            FLog.e(TAG, "Drawable not supported " + drawable);
        } else {
            FrescoDrawable2Impl frescoDrawable2Impl = (FrescoDrawable2Impl) drawable;
            frescoDrawable2Impl.getImagePerfListener().onReleaseImmediately(drawable);
            frescoDrawable2Impl.releaseImmediately();
        }
    }

    static /* synthetic */ void setActualImage$default(FrescoController2Impl frescoController2Impl, FrescoDrawable2Impl frescoDrawable2Impl, VitoImageRequest vitoImageRequest, CloseableReference closeableReference, boolean z, DataSource dataSource, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setActualImage");
        }
        if ((i & 32) != 0) {
            z2 = false;
        }
        frescoController2Impl.setActualImage(frescoDrawable2Impl, vitoImageRequest, closeableReference, z, dataSource, z2);
    }

    private final void setActualImage(FrescoDrawable2Impl drawable, VitoImageRequest imageRequest, CloseableReference<CloseableImage> image, boolean displayImmediately, DataSource<CloseableReference<CloseableImage>> dataSource, boolean isIntermediateImage) {
        Drawable drawableBuildActualImageDrawable;
        CloseableImage closeableImage;
        ScaleTypeDrawable actualImageWrapper = drawable.getActualImageWrapper();
        this.hierarcher.setupActualImageWrapper(actualImageWrapper, imageRequest.imageOptions, drawable.getCallerContext());
        ImageInfo imageInfo = null;
        if (image != null) {
            if (this.config.enablePrepareToDrawOnFetch()) {
                CloseableImage closeableImage2 = image.get();
                Intrinsics.checkNotNullExpressionValue(closeableImage2, "get(...)");
                CloseableImage closeableImage3 = closeableImage2;
                if (closeableImage3 instanceof CloseableBitmap) {
                    Bitmap underlyingBitmap = ((CloseableBitmap) closeableImage3).getUnderlyingBitmap();
                    if (underlyingBitmap != null) {
                        underlyingBitmap.prepareToDraw();
                    } else {
                        FLog.w(TAG, "underlyingBitmap is null during prepareToDraw, image may be closed");
                    }
                }
            }
            drawableBuildActualImageDrawable = this.hierarcher.buildActualImageDrawable(imageRequest.resources, imageRequest.imageOptions, image);
        } else {
            drawableBuildActualImageDrawable = null;
        }
        actualImageWrapper.setCurrent(drawableBuildActualImageDrawable == null ? NopDrawable.INSTANCE : drawableBuildActualImageDrawable);
        drawable.setImage(actualImageWrapper, image);
        if (displayImmediately || imageRequest.imageOptions.getFadeDurationMs() <= 0) {
            drawable.showImageImmediately();
        } else {
            drawable.fadeInImage(imageRequest.imageOptions.getFadeDurationMs());
        }
        if (imageRequest.imageOptions.get_autoPlay() && (drawableBuildActualImageDrawable instanceof Animatable)) {
            ((Animatable) drawableBuildActualImageDrawable).start();
        }
        Companion companion = INSTANCE;
        FrescoDrawable2Impl frescoDrawable2Impl = drawable;
        ControllerListener2.Extras extrasObtainExtras = companion.obtainExtras(dataSource, image, frescoDrawable2Impl, imageRequest);
        if (image != null && (closeableImage = image.get()) != null) {
            imageInfo = closeableImage.getImageInfo();
        }
        ImageInfo imageInfo2 = imageInfo;
        if (image != null) {
            drawable.getInternalListener().onImageSet(image, drawable.getViewportDimensions());
        }
        if (!isIntermediateImage && companion.notifyFinalResult(dataSource)) {
            drawable.getInternalListener().onFinalImageSet(drawable.get_imageId(), imageRequest, drawable.getImageOrigin(), imageInfo2, extrasObtainExtras, drawableBuildActualImageDrawable);
            if (drawable.getRetriggerListenersIfImageAlreadySet()) {
                drawable.setTempFinalImageExtras(extrasObtainExtras);
            }
        } else {
            drawable.getInternalListener().onIntermediateImageSet(drawable.get_imageId(), imageRequest, imageInfo2);
        }
        drawable.getImagePerfListener().onImageSuccess(drawable, displayImmediately);
        drawable.setProgress((dataSource == null || dataSource.isFinished()) ? 1.0f : dataSource.getProgress());
        this.debugOverlayFactory.update(frescoDrawable2Impl, extrasObtainExtras);
    }

    @Override // com.facebook.fresco.vito.core.impl.DrawableDataSubscriber
    public void onNewResult(FrescoDrawable2Impl drawable, VitoImageRequest imageRequest, DataSource<CloseableReference<CloseableImage>> dataSource) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        if (dataSource.hasResult()) {
            CloseableReference<CloseableImage> result = dataSource.getResult();
            try {
                if (!CloseableReference.isValid(result)) {
                    onFailure(drawable, imageRequest, dataSource);
                } else {
                    setActualImage$default(this, drawable, imageRequest, result, false, dataSource, false, 32, null);
                }
            } finally {
                CloseableReference.closeSafely(result);
            }
        }
    }

    @Override // com.facebook.fresco.vito.core.impl.DrawableDataSubscriber
    public void onFailure(FrescoDrawable2Impl drawable, VitoImageRequest imageRequest, DataSource<CloseableReference<CloseableImage>> dataSource) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        Drawable drawableBuildErrorDrawable = this.hierarcher.buildErrorDrawable(imageRequest.resources, imageRequest.imageOptions);
        drawable.setProgress(1.0f);
        drawable.setImageDrawable(drawableBuildErrorDrawable);
        if (!drawable.isDefaultLayerIsOn()) {
            if (imageRequest.imageOptions.getFadeDurationMs() <= 0) {
                drawable.showImageImmediately();
            } else {
                drawable.fadeInImage(imageRequest.imageOptions.getFadeDurationMs());
            }
        } else {
            drawable.setPlaceholderDrawable(null);
            drawable.setProgressDrawable(null);
        }
        Companion companion = INSTANCE;
        FrescoDrawable2Impl frescoDrawable2Impl = drawable;
        ControllerListener2.Extras extrasObtainExtras = companion.obtainExtras(dataSource, dataSource.getResult(), frescoDrawable2Impl, imageRequest);
        if (companion.notifyFinalResult(dataSource)) {
            drawable.getInternalListener().onFailure(drawable.get_imageId(), imageRequest, drawableBuildErrorDrawable, dataSource.getFailureCause(), extrasObtainExtras);
        } else {
            drawable.getInternalListener().onIntermediateImageFailed(drawable.get_imageId(), imageRequest, dataSource.getFailureCause());
        }
        drawable.getImagePerfListener().onImageError(drawable);
        this.debugOverlayFactory.update(frescoDrawable2Impl, extrasObtainExtras);
    }

    @Override // com.facebook.fresco.vito.core.impl.DrawableDataSubscriber
    public void onProgressUpdate(FrescoDrawable2Impl drawable, VitoImageRequest imageRequest, DataSource<CloseableReference<CloseableImage>> dataSource) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        if (dataSource.isFinished()) {
            return;
        }
        drawable.setProgress(dataSource.getProgress());
    }

    @Override // com.facebook.fresco.vito.core.impl.DrawableDataSubscriber
    public void onRelease(FrescoDrawable2Impl drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        VitoImageRequest imageRequest = drawable.getImageRequest();
        if (imageRequest != null) {
            boolean zUseOfferBackOnRelease = this.config.useOfferBackOnRelease();
            boolean zUseOfferBackOnReleaseForNonBitmapImage = this.config.useOfferBackOnReleaseForNonBitmapImage();
            if (zUseOfferBackOnRelease || zUseOfferBackOnReleaseForNonBitmapImage) {
                CloseableReference<CloseableImage> closeableReference = drawable.imageReference;
                CloseableImage closeableImage = closeableReference != null ? closeableReference.get() : null;
                if (closeableReference != null && CloseableReference.isValid(closeableReference) && closeableImage != null) {
                    if (!(closeableImage instanceof CloseableBitmap)) {
                        zUseOfferBackOnRelease = zUseOfferBackOnReleaseForNonBitmapImage;
                    }
                    if (zUseOfferBackOnRelease) {
                        this.imagePipeline.returnImageToCache(imageRequest, closeableReference);
                    }
                }
            }
            drawable.getInternalListener().onRelease(drawable.get_imageId(), imageRequest, INSTANCE.obtainExtras(null, null, drawable, imageRequest));
        }
        drawable.getImagePerfListener().onImageRelease(drawable);
    }

    private final boolean isAlreadyLoadingImage(FrescoDrawable2Impl drawable, VitoImageRequest imageRequest) {
        if (drawable.getDrawableDataSubscriber() != this || !drawable.getFetchSubmitted()) {
            return false;
        }
        if (this.config.useSmartPropertyDiffing()) {
            return imageRequest.equalsIfHasImage(drawable.getImageRequest(), drawable.hasImage());
        }
        return Intrinsics.areEqual(imageRequest, drawable.getImageRequest());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setActualDrawable(FrescoDrawable2Impl drawable, VitoImageRequest imageRequest, ControllerListener2.Extras extras, Drawable actualImageDrawable) {
        ScaleTypeDrawable actualImageWrapper = drawable.getActualImageWrapper();
        this.hierarcher.setupActualImageWrapper(actualImageWrapper, imageRequest.imageOptions, drawable.getCallerContext());
        Drawable drawableApplyRoundingOptions = this.hierarcher.applyRoundingOptions(imageRequest.resources, actualImageDrawable, imageRequest.imageOptions);
        actualImageWrapper.setCurrent(drawableApplyRoundingOptions);
        drawable.setImage(actualImageWrapper, null);
        drawable.showImageImmediately();
        drawable.setImageOrigin(7);
        drawable.setFetchSubmitted(true);
        if (imageRequest.imageOptions.get_autoPlay() && (actualImageDrawable instanceof Animatable)) {
            ((Animatable) actualImageDrawable).start();
        }
        HashMap map = extras.imageExtras;
        if (map == null) {
            map = new HashMap();
        }
        drawable.getInternalListener().onFinalImageSet(drawable.get_imageId(), imageRequest, 7, new ImageInfoImpl(actualImageDrawable.getIntrinsicWidth(), actualImageDrawable.getIntrinsicHeight(), 0, ImmutableQualityInfo.FULL_QUALITY, map), extras, drawableApplyRoundingOptions);
        drawable.getImagePerfListener().onImageSuccess(drawable, true);
        this.debugOverlayFactory.update(drawable, extras);
    }

    /* JADX INFO: compiled from: FrescoController2Impl.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J>\u0010\r\u001a\u00020\u000e2\u0014\u0010\u000f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u00102\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001e\u0010\u0018\u001a\u00020\u00192\u0014\u0010\u000f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u0010H\u0002RL\u0010\u0004\u001a@\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00010\u0001 \u0007*\u001e\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00010\u00010\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000RL\u0010\t\u001a@\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00010\u0001 \u0007*\u001e\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00010\u00010\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/FrescoController2Impl$Companion;", "", "<init>", "()V", "COMPONENT_EXTRAS", "", "", "kotlin.jvm.PlatformType", "", "SHORTCUT_EXTRAS", "TAG", "EMPTY_IMAGE_ID", "", "obtainExtras", "Lcom/facebook/fresco/ui/common/ControllerListener2$Extras;", "dataSource", "Lcom/facebook/datasource/DataSource;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "image", "drawable", "Lcom/facebook/fresco/vito/core/impl/FrescoDrawable2;", "imageRequest", "Lcom/facebook/fresco/vito/core/VitoImageRequest;", "notifyFinalResult", "", "core-java-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ControllerListener2.Extras obtainExtras(DataSource<CloseableReference<CloseableImage>> dataSource, CloseableReference<CloseableImage> image, FrescoDrawable2 drawable, VitoImageRequest imageRequest) {
            boolean z;
            Map map;
            Uri uri;
            Map<String, Object> extras = image != null ? image.get().getExtras() : null;
            VitoImageRequest imageRequest2 = drawable.getImageRequest();
            if (imageRequest2 != null) {
                z = imageRequest2.logWithHighSamplingRate;
                ImageRequest imageRequest3 = imageRequest2.finalImageRequest;
                Uri sourceUri = imageRequest3 != null ? imageRequest3.getSourceUri() : null;
                Object obj = imageRequest2.extras.get("image_source_extras");
                map = obj instanceof Map ? (Map) obj : null;
                uri = sourceUri;
            } else {
                z = false;
                map = null;
                uri = null;
            }
            ControllerListener2.Extras extrasObtainExtras = MiddlewareUtils.obtainExtras(FrescoController2Impl.COMPONENT_EXTRAS, FrescoController2Impl.SHORTCUT_EXTRAS, dataSource != null ? dataSource.getExtras() : null, map, drawable.getViewportDimensions(), drawable.getActualImageScaleType(), drawable.getActualImageFocusPoint(), extras, drawable.getCallerContext(), z, uri);
            extrasObtainExtras.smartUrlFetchStrategy = imageRequest.extras.get("smart_fetch_strategy");
            extrasObtainExtras.smartUrlModificationResult = imageRequest.extras.get("smart_mod_result");
            Object obj2 = imageRequest.extras.get("smart_original_url");
            extrasObtainExtras.smartOriginalUri = obj2 instanceof Uri ? (Uri) obj2 : null;
            extrasObtainExtras.uiFramework = drawable.getUiFramework();
            extrasObtainExtras.imageSource = imageRequest.imageSource;
            ImageSource imageSource = imageRequest.imageSource;
            SmartImageSource smartImageSource = imageSource instanceof SmartImageSource ? (SmartImageSource) imageSource : null;
            extrasObtainExtras.sizingHint = smartImageSource != null ? smartImageSource.getSizingHint() : null;
            return extrasObtainExtras;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean notifyFinalResult(DataSource<CloseableReference<CloseableImage>> dataSource) {
            return dataSource == null || dataSource.isFinished() || dataSource.hasMultipleResults();
        }
    }

    static {
        Map<String, Object> mapOf = ImmutableMap.of("component_tag", "vito2");
        Intrinsics.checkNotNullExpressionValue(mapOf, "of(...)");
        COMPONENT_EXTRAS = mapOf;
        Map<String, Object> mapOf2 = ImmutableMap.of("origin", "memory_bitmap", "origin_sub", "shortcut");
        Intrinsics.checkNotNullExpressionValue(mapOf2, "of(...)");
        SHORTCUT_EXTRAS = mapOf2;
    }
}

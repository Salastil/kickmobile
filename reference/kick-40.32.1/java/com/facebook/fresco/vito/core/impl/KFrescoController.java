package com.facebook.fresco.vito.core.impl;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.ui.common.ImagePerfDataListener;
import com.facebook.fresco.ui.common.ImagePerfDataNotifier;
import com.facebook.fresco.ui.common.ImagePerfNotifier;
import com.facebook.fresco.ui.common.OnFadeListener;
import com.facebook.fresco.ui.common.VitoUtils;
import com.facebook.fresco.vito.core.CombinedImageListener;
import com.facebook.fresco.vito.core.FrescoController2;
import com.facebook.fresco.vito.core.FrescoDrawableInterface;
import com.facebook.fresco.vito.core.FrescoVitoConfig;
import com.facebook.fresco.vito.core.ImagePerfLoggingListener;
import com.facebook.fresco.vito.core.VitoImagePerfListener;
import com.facebook.fresco.vito.core.VitoImagePipeline;
import com.facebook.fresco.vito.core.VitoImageRequest;
import com.facebook.fresco.vito.core.VitoImageRequestListener;
import com.facebook.fresco.vito.listener.ImageListener;
import com.facebook.fresco.vito.options.ImageOptions;
import com.facebook.fresco.vito.options.ImageOptionsDrawableFactory;
import com.facebook.fresco.vito.renderer.AnimatedDrawableImageDataModel;
import com.facebook.fresco.vito.renderer.BitmapImageDataModel;
import com.facebook.fresco.vito.renderer.DrawableImageDataModel;
import com.facebook.fresco.vito.renderer.ImageDataModel;
import com.facebook.fresco.vito.source.BitmapImageSource;
import com.facebook.fresco.vito.source.ColorImageSource;
import com.facebook.fresco.vito.source.DrawableImageSource;
import com.facebook.fresco.vito.source.DrawableResImageSource;
import com.facebook.fresco.vito.source.ImageSource;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.image.ImageInfoImpl;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.io.Closeable;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KFrescoController.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 J2\u00020\u0001:\u0001JB[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010 \u001a\u0002H!\"\f\b\u0000\u0010!*\u00020\"*\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0002\u0010&J^\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u00010\nH\u0016J(\u00109\u001a\u00020:2\u0006\u0010)\u001a\u00020;2\u0006\u0010<\u001a\u00020\"2\u0006\u0010*\u001a\u00020+2\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010?\u001a\u00020:2\u0006\u0010)\u001a\u00020#H\u0016J\u0010\u0010@\u001a\u00020:2\u0006\u0010)\u001a\u00020#H\u0016J\u0010\u0010A\u001a\u00020:2\u0006\u0010)\u001a\u00020#H\u0016J\u000e\u0010B\u001a\u0004\u0018\u00010;*\u00020#H\u0002J.\u0010C\u001a\u00020(*\u00020;2\u0006\u0010*\u001a\u00020+2\u000e\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010E2\b\b\u0002\u0010F\u001a\u00020(H\u0002J\u0018\u0010G\u001a\u00020(2\u0006\u0010*\u001a\u00020+2\u0006\u0010)\u001a\u00020;H\u0002J\u0018\u0010H\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\"2\u0006\u0010I\u001a\u00020\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0014\u001a\u001c\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006K"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/KFrescoController;", "Lcom/facebook/fresco/vito/core/FrescoController2;", "config", "Lcom/facebook/fresco/vito/core/FrescoVitoConfig;", "vitoImagePipeline", "Lcom/facebook/fresco/vito/core/VitoImagePipeline;", "uiThreadExecutor", "Ljava/util/concurrent/Executor;", "lightweightBackgroundThreadExecutor", "globalImageRequestListener", "Lcom/facebook/fresco/vito/core/VitoImageRequestListener;", "imagePerfLoggingListenerSupplier", "Lcom/facebook/common/internal/Supplier;", "Lcom/facebook/fresco/vito/core/ImagePerfLoggingListener;", "imagePerfListener", "Lcom/facebook/fresco/vito/core/VitoImagePerfListener;", "drawableFactory", "Lcom/facebook/fresco/vito/options/ImageOptionsDrawableFactory;", "<init>", "(Lcom/facebook/fresco/vito/core/FrescoVitoConfig;Lcom/facebook/fresco/vito/core/VitoImagePipeline;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Lcom/facebook/fresco/vito/core/VitoImageRequestListener;Lcom/facebook/common/internal/Supplier;Lcom/facebook/fresco/vito/core/VitoImagePerfListener;Lcom/facebook/fresco/vito/options/ImageOptionsDrawableFactory;)V", "imageToDataModelMapper", "Lkotlin/Function3;", "Landroid/content/res/Resources;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "Lcom/facebook/fresco/vito/options/ImageOptions;", "Lcom/facebook/fresco/vito/renderer/ImageDataModel;", "debugOverlayHandler", "Lcom/facebook/fresco/vito/core/impl/DebugOverlayHandler;", "getDebugOverlayHandler", "()Lcom/facebook/fresco/vito/core/impl/DebugOverlayHandler;", "setDebugOverlayHandler", "(Lcom/facebook/fresco/vito/core/impl/DebugOverlayHandler;)V", "createDrawable", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/graphics/drawable/Drawable;", "Lcom/facebook/fresco/vito/core/FrescoDrawableInterface;", "uiFramework", "", "(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;", "fetch", "", "drawable", "imageRequest", "Lcom/facebook/fresco/vito/core/VitoImageRequest;", "callerContext", "", "contextChain", "Lcom/facebook/common/callercontext/ContextChain;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/facebook/fresco/vito/listener/ImageListener;", "perfDataListener", "Lcom/facebook/fresco/ui/common/ImagePerfDataListener;", "onFadeListener", "Lcom/facebook/fresco/ui/common/OnFadeListener;", "viewportDimensions", "Landroid/graphics/Rect;", "vitoImageRequestListener", "setDrawableAsActualImage", "", "Lcom/facebook/fresco/vito/core/impl/KFrescoVitoDrawable;", "actualImageDrawable", "imageId", "", "releaseDelayed", "releaseNextFrame", "releaseImmediately", "asVitoDrawableOrNull", "setActualImage", "imageReference", "Lcom/facebook/common/references/CloseableReference;", "isIntermediateImage", "isAlreadyLoadingImage", "createDrawableModel", "options", "Companion", "core-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KFrescoController implements FrescoController2 {
    private static final String TAG = "KFrescoController";
    private final FrescoVitoConfig config;
    private DebugOverlayHandler debugOverlayHandler;
    private final ImageOptionsDrawableFactory drawableFactory;
    private final VitoImageRequestListener globalImageRequestListener;
    private final VitoImagePerfListener imagePerfListener;
    private final Supplier<ImagePerfLoggingListener> imagePerfLoggingListenerSupplier;
    private final Function3<Resources, CloseableImage, ImageOptions, ImageDataModel> imageToDataModelMapper;
    private final Executor lightweightBackgroundThreadExecutor;
    private final Executor uiThreadExecutor;
    private final VitoImagePipeline vitoImagePipeline;

    static final void fetch$lambda$10$lambda$8(Bitmap bitmap) {
    }

    public KFrescoController(FrescoVitoConfig config, VitoImagePipeline vitoImagePipeline, Executor uiThreadExecutor, Executor lightweightBackgroundThreadExecutor, VitoImageRequestListener vitoImageRequestListener, Supplier<ImagePerfLoggingListener> supplier, VitoImagePerfListener imagePerfListener, ImageOptionsDrawableFactory imageOptionsDrawableFactory) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(vitoImagePipeline, "vitoImagePipeline");
        Intrinsics.checkNotNullParameter(uiThreadExecutor, "uiThreadExecutor");
        Intrinsics.checkNotNullParameter(lightweightBackgroundThreadExecutor, "lightweightBackgroundThreadExecutor");
        Intrinsics.checkNotNullParameter(imagePerfListener, "imagePerfListener");
        this.config = config;
        this.vitoImagePipeline = vitoImagePipeline;
        this.uiThreadExecutor = uiThreadExecutor;
        this.lightweightBackgroundThreadExecutor = lightweightBackgroundThreadExecutor;
        this.globalImageRequestListener = vitoImageRequestListener;
        this.imagePerfLoggingListenerSupplier = supplier;
        this.imagePerfListener = imagePerfListener;
        this.drawableFactory = imageOptionsDrawableFactory;
        this.imageToDataModelMapper = new Function3() { // from class: com.facebook.fresco.vito.core.impl.KFrescoController$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return KFrescoController.imageToDataModelMapper$lambda$4(this.f$0, (Resources) obj, (CloseableImage) obj2, (ImageOptions) obj3);
            }
        };
    }

    @Override // com.facebook.fresco.vito.core.FrescoController2
    public <T extends Drawable & FrescoDrawableInterface> T createDrawable() {
        return (T) super.createDrawable();
    }

    public /* synthetic */ KFrescoController(FrescoVitoConfig frescoVitoConfig, VitoImagePipeline vitoImagePipeline, Executor executor, Executor executor2, VitoImageRequestListener vitoImageRequestListener, Supplier supplier, BaseVitoImagePerfListener baseVitoImagePerfListener, ImageOptionsDrawableFactory imageOptionsDrawableFactory, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(frescoVitoConfig, vitoImagePipeline, executor, executor2, (i & 16) != 0 ? null : vitoImageRequestListener, (i & 32) != 0 ? null : supplier, (i & 64) != 0 ? new BaseVitoImagePerfListener() : baseVitoImagePerfListener, (i & 128) != 0 ? null : imageOptionsDrawableFactory);
    }

    static final ImageDataModel imageToDataModelMapper$lambda$4(KFrescoController kFrescoController, Resources resources, CloseableImage closeableImage, ImageOptions imageOptions) {
        BitmapImageDataModel bitmapImageDataModelCreateDrawableModel;
        Drawable drawableCreateDrawable;
        BitmapImageDataModel bitmapImageDataModel;
        Drawable drawableCreateDrawable2;
        ImageDataModel imageDataModelCreateDrawableModel;
        BitmapImageDataModel bitmapImageDataModelCreateDrawableModel2;
        Drawable drawableCreateDrawable3;
        BitmapImageDataModel bitmapImageDataModel2;
        Drawable drawableCreateDrawable4;
        ImageDataModel imageDataModelCreateDrawableModel2;
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(closeableImage, "closeableImage");
        Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        ImageDataModel imageDataModel = null;
        if (!FrescoSystrace.isTracing()) {
            ImageOptionsDrawableFactory customDrawableFactory = imageOptions.getCustomDrawableFactory();
            if (customDrawableFactory != null && (drawableCreateDrawable4 = customDrawableFactory.createDrawable(resources, closeableImage, imageOptions)) != null && (imageDataModelCreateDrawableModel2 = kFrescoController.createDrawableModel(drawableCreateDrawable4, imageOptions)) != null) {
                return imageDataModelCreateDrawableModel2;
            }
            if (closeableImage instanceof CloseableBitmap) {
                Bitmap underlyingBitmap = ((CloseableBitmap) closeableImage).getUnderlyingBitmap();
                if (underlyingBitmap != null) {
                    if (kFrescoController.config.enablePrepareToDrawOnFetch()) {
                        underlyingBitmap.prepareToDraw();
                    }
                    bitmapImageDataModel2 = new BitmapImageDataModel(underlyingBitmap, Intrinsics.areEqual(closeableImage.getExtras().get("is_rounded"), (Object) true));
                } else {
                    bitmapImageDataModel2 = null;
                }
                bitmapImageDataModelCreateDrawableModel2 = bitmapImageDataModel2;
            } else {
                ImageOptionsDrawableFactory imageOptionsDrawableFactory = kFrescoController.drawableFactory;
                bitmapImageDataModelCreateDrawableModel2 = (imageOptionsDrawableFactory == null || (drawableCreateDrawable3 = imageOptionsDrawableFactory.createDrawable(resources, closeableImage, imageOptions)) == null) ? null : kFrescoController.createDrawableModel(drawableCreateDrawable3, imageOptions);
            }
            if (bitmapImageDataModelCreateDrawableModel2 != null) {
                return bitmapImageDataModelCreateDrawableModel2;
            }
            FLog.e(TAG, "Could not create Drawable for CloseableImage: " + imageOptions);
            return null;
        }
        FrescoSystrace.beginSection("KFrescoController#imageToDataModelMapper");
        try {
            ImageOptionsDrawableFactory customDrawableFactory2 = imageOptions.getCustomDrawableFactory();
            if (customDrawableFactory2 == null || (drawableCreateDrawable2 = customDrawableFactory2.createDrawable(resources, closeableImage, imageOptions)) == null || (imageDataModelCreateDrawableModel = kFrescoController.createDrawableModel(drawableCreateDrawable2, imageOptions)) == null) {
                if (closeableImage instanceof CloseableBitmap) {
                    Bitmap underlyingBitmap2 = ((CloseableBitmap) closeableImage).getUnderlyingBitmap();
                    if (underlyingBitmap2 != null) {
                        if (kFrescoController.config.enablePrepareToDrawOnFetch()) {
                            underlyingBitmap2.prepareToDraw();
                        }
                        bitmapImageDataModel = new BitmapImageDataModel(underlyingBitmap2, Intrinsics.areEqual(closeableImage.getExtras().get("is_rounded"), (Object) true));
                    } else {
                        bitmapImageDataModel = null;
                    }
                    bitmapImageDataModelCreateDrawableModel = bitmapImageDataModel;
                } else {
                    ImageOptionsDrawableFactory imageOptionsDrawableFactory2 = kFrescoController.drawableFactory;
                    bitmapImageDataModelCreateDrawableModel = (imageOptionsDrawableFactory2 == null || (drawableCreateDrawable = imageOptionsDrawableFactory2.createDrawable(resources, closeableImage, imageOptions)) == null) ? null : kFrescoController.createDrawableModel(drawableCreateDrawable, imageOptions);
                }
                if (bitmapImageDataModelCreateDrawableModel == null) {
                    FLog.e(TAG, "Could not create Drawable for CloseableImage: " + imageOptions);
                } else {
                    imageDataModel = bitmapImageDataModelCreateDrawableModel;
                }
            } else {
                imageDataModel = imageDataModelCreateDrawableModel;
            }
            return imageDataModel;
        } finally {
            FrescoSystrace.endSection();
        }
    }

    public final DebugOverlayHandler getDebugOverlayHandler() {
        return this.debugOverlayHandler;
    }

    public final void setDebugOverlayHandler(DebugOverlayHandler debugOverlayHandler) {
        this.debugOverlayHandler = debugOverlayHandler;
    }

    @Override // com.facebook.fresco.vito.core.FrescoController2
    public <T extends Drawable & FrescoDrawableInterface> T createDrawable(String uiFramework) {
        ImagePerfLoggingListener imagePerfLoggingListener;
        ImagePerfLoggingListener imagePerfLoggingListener2;
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            KFrescoVitoDrawable kFrescoVitoDrawable = new KFrescoVitoDrawable(this.imagePerfListener, this.config.experimentalResetVitoImageRequestListener(), this.config.experimentalResetLocalVitoImageRequestListener(), this.config.experimentalResetLocalImagePerfStateListener(), this.config.experimentalResetControllerListener2(), this.config.experimentalOptimizeAlphaHandling());
            kFrescoVitoDrawable.setUiFramework(uiFramework);
            Supplier<ImagePerfLoggingListener> supplier = this.imagePerfLoggingListenerSupplier;
            if (supplier != null && (imagePerfLoggingListener2 = supplier.get()) != null) {
                kFrescoVitoDrawable.getListenerManager().setImagePerfLoggingListener(imagePerfLoggingListener2);
            }
            return kFrescoVitoDrawable;
        }
        FrescoSystrace.beginSection("KFrescoController#createDrawable");
        try {
            KFrescoVitoDrawable kFrescoVitoDrawable2 = new KFrescoVitoDrawable(this.imagePerfListener, this.config.experimentalResetVitoImageRequestListener(), this.config.experimentalResetLocalVitoImageRequestListener(), this.config.experimentalResetLocalImagePerfStateListener(), this.config.experimentalResetControllerListener2(), this.config.experimentalOptimizeAlphaHandling());
            kFrescoVitoDrawable2.setUiFramework(uiFramework);
            Supplier<ImagePerfLoggingListener> supplier2 = this.imagePerfLoggingListenerSupplier;
            if (supplier2 != null && (imagePerfLoggingListener = supplier2.get()) != null) {
                kFrescoVitoDrawable2.getListenerManager().setImagePerfLoggingListener(imagePerfLoggingListener);
            }
            return kFrescoVitoDrawable2;
        } finally {
            FrescoSystrace.endSection();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r24v12, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r24v6, types: [java.util.Map] */
    @Override // com.facebook.fresco.vito.core.FrescoController2
    public boolean fetch(final FrescoDrawableInterface drawable, final VitoImageRequest imageRequest, final Object callerContext, ContextChain contextChain, ImageListener listener, ImagePerfDataListener perfDataListener, OnFadeListener onFadeListener, Rect viewportDimensions, VitoImageRequestListener vitoImageRequestListener) throws Throwable {
        CloseableImage closeableImage;
        QualityInfo qualityInfo;
        CloseableImage closeableImage2;
        QualityInfo qualityInfo2;
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            if (!(drawable instanceof KFrescoVitoDrawable)) {
                FLog.e(TAG, "Drawable not supported " + drawable);
                return false;
            }
            if (this.config.enableRetriggerListenersIfImageAlreadySet()) {
                ((KFrescoVitoDrawable) drawable).setRetriggerListenersIfImageAlreadySet(true);
            }
            KFrescoVitoDrawable kFrescoVitoDrawable = (KFrescoVitoDrawable) drawable;
            boolean forceReloadIfImageAlreadySet = kFrescoVitoDrawable.getForceReloadIfImageAlreadySet();
            boolean retriggerListenersIfImageAlreadySet = kFrescoVitoDrawable.getRetriggerListenersIfImageAlreadySet();
            if (!forceReloadIfImageAlreadySet && isAlreadyLoadingImage(imageRequest, kFrescoVitoDrawable)) {
                ImageReleaseScheduler.INSTANCE.cancelAllReleasing(kFrescoVitoDrawable);
                if (retriggerListenersIfImageAlreadySet && kFrescoVitoDrawable.hasImage()) {
                    Closeable closeable = kFrescoVitoDrawable.getCloseable();
                    CloseableReference closeableReference = closeable instanceof CloseableReference ? (CloseableReference) closeable : null;
                    Object obj = closeableReference != null ? closeableReference.get() : null;
                    CloseableImage closeableImage3 = obj instanceof CloseableImage ? (CloseableImage) obj : null;
                    kFrescoVitoDrawable.getListenerManager().onFinalImageSet(kFrescoVitoDrawable.get_imageId(), imageRequest, 6, closeableImage3 != null ? closeableImage3.getImageInfo() : null, ExtrasUtilsKt.obtainExtras$default(kFrescoVitoDrawable, null, null, closeableImage3 != null ? closeableImage3.getExtras() : null, 3, null), kFrescoVitoDrawable.getActualImageDrawable());
                }
                return true;
            }
            if (kFrescoVitoDrawable.getFetchSubmitted()) {
                kFrescoVitoDrawable.getImagePerfListener().onDrawableReconfigured(drawable);
            }
            final long jGenerateIdentifier = VitoUtils.generateIdentifier();
            kFrescoVitoDrawable.reset();
            kFrescoVitoDrawable.setForceReloadIfImageAlreadySet(forceReloadIfImageAlreadySet);
            kFrescoVitoDrawable.setRetriggerListenersIfImageAlreadySet(retriggerListenersIfImageAlreadySet);
            kFrescoVitoDrawable.setImageRequest(imageRequest);
            kFrescoVitoDrawable.setCallerContext(callerContext);
            kFrescoVitoDrawable.setImageListener(listener);
            kFrescoVitoDrawable.getListenerManager().setVitoImageRequestListener(this.globalImageRequestListener);
            kFrescoVitoDrawable.getListenerManager().setLocalVitoImageRequestListener(vitoImageRequestListener);
            kFrescoVitoDrawable.getListenerManager().setLocalImagePerfStateListener((ImagePerfNotifier) (perfDataListener != null ? new ImagePerfDataNotifier(perfDataListener) : null));
            kFrescoVitoDrawable.set_imageId(jGenerateIdentifier);
            kFrescoVitoDrawable.setViewportDimensions(viewportDimensions);
            final boolean zUseOfferBackOnRelease = this.config.useOfferBackOnRelease();
            final boolean zUseOfferBackOnReleaseForNonBitmapImage = this.config.useOfferBackOnReleaseForNonBitmapImage();
            if (zUseOfferBackOnRelease || zUseOfferBackOnReleaseForNonBitmapImage) {
                kFrescoVitoDrawable.setOfferBackOnRelease(new Function0() { // from class: com.facebook.fresco.vito.core.impl.KFrescoController$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return KFrescoController.fetch$lambda$10$lambda$7(drawable, zUseOfferBackOnRelease, zUseOfferBackOnReleaseForNonBitmapImage, this);
                    }
                });
            }
            ImageOptions imageOptions = imageRequest.imageOptions;
            kFrescoVitoDrawable.getListenerManager().onSubmit(jGenerateIdentifier, imageRequest, callerContext, ExtrasUtilsKt.obtainExtras$default(kFrescoVitoDrawable, null, null, null, 7, null));
            kFrescoVitoDrawable.getImagePerfListener().onImageFetch(drawable);
            ActualImageHandlerKt.setOverlay(kFrescoVitoDrawable.getOverlayImageLayer(), imageRequest.resources, imageOptions);
            BackgroundLayerHandlerKt.setupBackgroundLayer(kFrescoVitoDrawable, imageRequest.resources, imageOptions);
            ImageSource imageSource = imageRequest.imageSource;
            if (imageSource instanceof BitmapImageSource) {
                return setActualImage$default(this, kFrescoVitoDrawable, imageRequest, CloseableReference.of(CloseableStaticBitmap.of(((BitmapImageSource) imageSource).getBitmap(), (ResourceReleaser<Bitmap>) new ResourceReleaser() { // from class: com.facebook.fresco.vito.core.impl.KFrescoController$$ExternalSyntheticLambda1
                    @Override // com.facebook.common.references.ResourceReleaser
                    public final void release(Object obj2) {
                        KFrescoController.fetch$lambda$10$lambda$8((Bitmap) obj2);
                    }
                }, ImmutableQualityInfo.FULL_QUALITY, 0)), false, 4, null);
            }
            if (imageSource instanceof ColorImageSource) {
                setDrawableAsActualImage(kFrescoVitoDrawable, new ColorDrawable(((ColorImageSource) imageSource).getColor()), imageRequest, jGenerateIdentifier);
                return true;
            }
            if (imageSource instanceof DrawableImageSource) {
                setDrawableAsActualImage(kFrescoVitoDrawable, ((DrawableImageSource) imageSource).getDrawable(), imageRequest, jGenerateIdentifier);
                return true;
            }
            if (imageSource instanceof DrawableResImageSource) {
                setDrawableAsActualImage(kFrescoVitoDrawable, ((DrawableResImageSource) imageSource).createDrawable(imageRequest.resources), imageRequest, jGenerateIdentifier);
                return true;
            }
            CloseableReference<CloseableImage> cachedImage = this.vitoImagePipeline.getCachedImage(imageRequest);
            boolean z = this.config.useIntermediateImagesAsPlaceholder() && (cachedImage == null || (closeableImage2 = cachedImage.get()) == null || (qualityInfo2 = closeableImage2.getQualityInfo()) == null || !qualityInfo2.isOfFullQuality());
            boolean actualImage = setActualImage(kFrescoVitoDrawable, imageRequest, cachedImage, z);
            if (actualImage && !z) {
                return true;
            }
            if (!actualImage) {
                ActualImageHandlerKt.setPlaceholder(kFrescoVitoDrawable.getPlaceholderLayer(), imageRequest.resources, imageOptions);
                kFrescoVitoDrawable.getListenerManager().onPlaceholderSet(jGenerateIdentifier, imageRequest, ImageLayerDataModelExtensionsKt.maybeGetDrawable(kFrescoVitoDrawable.getPlaceholderLayer().getDataModel()));
                ProgressLayerHandlerKt.setupProgressLayer(kFrescoVitoDrawable, imageRequest.resources, imageOptions);
            }
            this.lightweightBackgroundThreadExecutor.execute(new Runnable() { // from class: com.facebook.fresco.vito.core.impl.KFrescoController$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    KFrescoController.fetch$lambda$10$lambda$9(jGenerateIdentifier, drawable, this, imageRequest, callerContext);
                }
            });
            kFrescoVitoDrawable.setFetchSubmitted(true);
            kFrescoVitoDrawable.invalidateSelf();
            DebugOverlayHandler debugOverlayHandler = this.debugOverlayHandler;
            if (debugOverlayHandler != null) {
                debugOverlayHandler.update(kFrescoVitoDrawable);
            }
            return false;
        }
        FrescoSystrace.beginSection("KFrescoController#fetch");
        try {
            if (!(drawable instanceof KFrescoVitoDrawable)) {
                FLog.e(TAG, "Drawable not supported " + drawable);
                return false;
            }
            if (this.config.enableRetriggerListenersIfImageAlreadySet()) {
                ((KFrescoVitoDrawable) drawable).setRetriggerListenersIfImageAlreadySet(true);
            }
            boolean forceReloadIfImageAlreadySet2 = ((KFrescoVitoDrawable) drawable).getForceReloadIfImageAlreadySet();
            boolean retriggerListenersIfImageAlreadySet2 = ((KFrescoVitoDrawable) drawable).getRetriggerListenersIfImageAlreadySet();
            if (!forceReloadIfImageAlreadySet2 && isAlreadyLoadingImage(imageRequest, (KFrescoVitoDrawable) drawable)) {
                ImageReleaseScheduler.INSTANCE.cancelAllReleasing((KFrescoVitoDrawable) drawable);
                if (retriggerListenersIfImageAlreadySet2 && ((KFrescoVitoDrawable) drawable).hasImage()) {
                    Closeable closeable2 = ((KFrescoVitoDrawable) drawable).getCloseable();
                    CloseableReference closeableReference2 = closeable2 instanceof CloseableReference ? (CloseableReference) closeable2 : null;
                    Object obj2 = closeableReference2 != null ? closeableReference2.get() : null;
                    CloseableImage closeableImage4 = obj2 instanceof CloseableImage ? (CloseableImage) obj2 : null;
                    ((KFrescoVitoDrawable) drawable).getListenerManager().onFinalImageSet(((KFrescoVitoDrawable) drawable).get_imageId(), imageRequest, 6, closeableImage4 != null ? closeableImage4.getImageInfo() : null, ExtrasUtilsKt.obtainExtras$default((KFrescoVitoDrawable) drawable, null, null, closeableImage4 != null ? closeableImage4.getExtras() : null, 3, null), ((KFrescoVitoDrawable) drawable).getActualImageDrawable());
                }
                return true;
            }
            if (((KFrescoVitoDrawable) drawable).getFetchSubmitted()) {
                ((KFrescoVitoDrawable) drawable).getImagePerfListener().onDrawableReconfigured(drawable);
            }
            final long jGenerateIdentifier2 = VitoUtils.generateIdentifier();
            ((KFrescoVitoDrawable) drawable).reset();
            ((KFrescoVitoDrawable) drawable).setForceReloadIfImageAlreadySet(forceReloadIfImageAlreadySet2);
            ((KFrescoVitoDrawable) drawable).setRetriggerListenersIfImageAlreadySet(retriggerListenersIfImageAlreadySet2);
            ((KFrescoVitoDrawable) drawable).setImageRequest(imageRequest);
            ((KFrescoVitoDrawable) drawable).setCallerContext(callerContext);
            ((KFrescoVitoDrawable) drawable).setImageListener(listener);
            ((KFrescoVitoDrawable) drawable).getListenerManager().setVitoImageRequestListener(this.globalImageRequestListener);
            ((KFrescoVitoDrawable) drawable).getListenerManager().setLocalVitoImageRequestListener(vitoImageRequestListener);
            ((KFrescoVitoDrawable) drawable).getListenerManager().setLocalImagePerfStateListener((ImagePerfNotifier) (perfDataListener != null ? new ImagePerfDataNotifier(perfDataListener) : null));
            ((KFrescoVitoDrawable) drawable).set_imageId(jGenerateIdentifier2);
            ((KFrescoVitoDrawable) drawable).setViewportDimensions(viewportDimensions);
            final boolean zUseOfferBackOnRelease2 = this.config.useOfferBackOnRelease();
            final boolean zUseOfferBackOnReleaseForNonBitmapImage2 = this.config.useOfferBackOnReleaseForNonBitmapImage();
            if (zUseOfferBackOnRelease2 || zUseOfferBackOnReleaseForNonBitmapImage2) {
                ((KFrescoVitoDrawable) drawable).setOfferBackOnRelease(new Function0() { // from class: com.facebook.fresco.vito.core.impl.KFrescoController$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return KFrescoController.fetch$lambda$10$lambda$7(drawable, zUseOfferBackOnRelease2, zUseOfferBackOnReleaseForNonBitmapImage2, this);
                    }
                });
            }
            ImageOptions imageOptions2 = imageRequest.imageOptions;
            ((KFrescoVitoDrawable) drawable).getListenerManager().onSubmit(jGenerateIdentifier2, imageRequest, callerContext, ExtrasUtilsKt.obtainExtras$default((KFrescoVitoDrawable) drawable, null, null, null, 7, null));
            ((KFrescoVitoDrawable) drawable).getImagePerfListener().onImageFetch(drawable);
            ActualImageHandlerKt.setOverlay(((KFrescoVitoDrawable) drawable).getOverlayImageLayer(), imageRequest.resources, imageOptions2);
            BackgroundLayerHandlerKt.setupBackgroundLayer((KFrescoVitoDrawable) drawable, imageRequest.resources, imageOptions2);
            ImageSource imageSource2 = imageRequest.imageSource;
            if (imageSource2 instanceof BitmapImageSource) {
                return setActualImage$default(this, (KFrescoVitoDrawable) drawable, imageRequest, CloseableReference.of(CloseableStaticBitmap.of(((BitmapImageSource) imageSource2).getBitmap(), (ResourceReleaser<Bitmap>) new ResourceReleaser() { // from class: com.facebook.fresco.vito.core.impl.KFrescoController$$ExternalSyntheticLambda1
                    @Override // com.facebook.common.references.ResourceReleaser
                    public final void release(Object obj3) {
                        KFrescoController.fetch$lambda$10$lambda$8((Bitmap) obj3);
                    }
                }, ImmutableQualityInfo.FULL_QUALITY, 0)), false, 4, null);
            }
            if (imageSource2 instanceof ColorImageSource) {
                setDrawableAsActualImage((KFrescoVitoDrawable) drawable, new ColorDrawable(((ColorImageSource) imageSource2).getColor()), imageRequest, jGenerateIdentifier2);
                return true;
            }
            if (imageSource2 instanceof DrawableImageSource) {
                setDrawableAsActualImage((KFrescoVitoDrawable) drawable, ((DrawableImageSource) imageSource2).getDrawable(), imageRequest, jGenerateIdentifier2);
                return true;
            }
            if (imageSource2 instanceof DrawableResImageSource) {
                setDrawableAsActualImage((KFrescoVitoDrawable) drawable, ((DrawableResImageSource) imageSource2).createDrawable(imageRequest.resources), imageRequest, jGenerateIdentifier2);
                return true;
            }
            CloseableReference<CloseableImage> cachedImage2 = this.vitoImagePipeline.getCachedImage(imageRequest);
            boolean z2 = this.config.useIntermediateImagesAsPlaceholder() && (cachedImage2 == null || (closeableImage = cachedImage2.get()) == null || (qualityInfo = closeableImage.getQualityInfo()) == null || !qualityInfo.isOfFullQuality());
            boolean actualImage2 = setActualImage((KFrescoVitoDrawable) drawable, imageRequest, cachedImage2, z2);
            if (actualImage2 && !z2) {
                return true;
            }
            if (!actualImage2) {
                ActualImageHandlerKt.setPlaceholder(((KFrescoVitoDrawable) drawable).getPlaceholderLayer(), imageRequest.resources, imageOptions2);
                ((KFrescoVitoDrawable) drawable).getListenerManager().onPlaceholderSet(jGenerateIdentifier2, imageRequest, ImageLayerDataModelExtensionsKt.maybeGetDrawable(((KFrescoVitoDrawable) drawable).getPlaceholderLayer().getDataModel()));
                ProgressLayerHandlerKt.setupProgressLayer((KFrescoVitoDrawable) drawable, imageRequest.resources, imageOptions2);
            }
            this.lightweightBackgroundThreadExecutor.execute(new Runnable() { // from class: com.facebook.fresco.vito.core.impl.KFrescoController$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    KFrescoController.fetch$lambda$10$lambda$9(jGenerateIdentifier2, drawable, this, imageRequest, callerContext);
                }
            });
            ((KFrescoVitoDrawable) drawable).setFetchSubmitted(true);
            ((KFrescoVitoDrawable) drawable).invalidateSelf();
            DebugOverlayHandler debugOverlayHandler2 = this.debugOverlayHandler;
            if (debugOverlayHandler2 != null) {
                debugOverlayHandler2.update((KFrescoVitoDrawable) drawable);
            }
            return false;
        } finally {
            FrescoSystrace.endSection();
        }
    }

    static final Unit fetch$lambda$10$lambda$7(FrescoDrawableInterface frescoDrawableInterface, boolean z, boolean z2, KFrescoController kFrescoController) {
        KFrescoVitoDrawable kFrescoVitoDrawable = (KFrescoVitoDrawable) frescoDrawableInterface;
        VitoImageRequest imageRequest = kFrescoVitoDrawable.getImageRequest();
        Closeable closeable = kFrescoVitoDrawable.getCloseable();
        CloseableImage closeableImage = null;
        CloseableReference<CloseableImage> closeableReference = closeable instanceof CloseableReference ? (CloseableReference) closeable : null;
        if (closeableReference != null && closeableReference.isValid()) {
            closeableImage = closeableReference.get();
        }
        if (imageRequest != null && (closeableImage instanceof CloseableImage)) {
            if (!(closeableImage instanceof CloseableBitmap)) {
                z = z2;
            }
            if (z) {
                VitoImagePipeline vitoImagePipeline = kFrescoController.vitoImagePipeline;
                Intrinsics.checkNotNull(closeableReference, "null cannot be cast to non-null type com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>");
                vitoImagePipeline.returnImageToCache(imageRequest, closeableReference);
            }
        }
        return Unit.INSTANCE;
    }

    static final void fetch$lambda$10$lambda$9(long j, FrescoDrawableInterface frescoDrawableInterface, KFrescoController kFrescoController, VitoImageRequest vitoImageRequest, Object obj) {
        KFrescoVitoDrawable kFrescoVitoDrawable = (KFrescoVitoDrawable) frescoDrawableInterface;
        if (j != kFrescoVitoDrawable.get_imageId()) {
            return;
        }
        DataSource<? extends Object> dataSourceFetchDecodedImage$default = VitoImagePipeline.fetchDecodedImage$default(kFrescoController.vitoImagePipeline, vitoImageRequest, obj, null, j, null, 16, null);
        dataSourceFetchDecodedImage$default.subscribe(new ImageFetchSubscriber(j, kFrescoVitoDrawable, kFrescoController.imageToDataModelMapper, kFrescoController.debugOverlayHandler, kFrescoController.uiThreadExecutor), kFrescoController.config.handleImageResultInBackground() ? kFrescoController.lightweightBackgroundThreadExecutor : kFrescoController.uiThreadExecutor);
        kFrescoVitoDrawable.setDataSource(dataSourceFetchDecodedImage$default);
    }

    private final void setDrawableAsActualImage(KFrescoVitoDrawable drawable, Drawable actualImageDrawable, VitoImageRequest imageRequest, long imageId) {
        ControllerListener2.Extras extrasObtainExtras$default = ExtrasUtilsKt.obtainExtras$default(drawable, null, null, null, 7, null);
        ActualImageHandlerKt.setActualImageDrawable(drawable.getActualImageLayer(), imageRequest.imageOptions, actualImageDrawable);
        CombinedImageListener listenerManager = drawable.getListenerManager();
        int intrinsicWidth = actualImageDrawable.getIntrinsicWidth();
        int intrinsicHeight = actualImageDrawable.getIntrinsicHeight();
        QualityInfo qualityInfo = ImmutableQualityInfo.FULL_QUALITY;
        Map<String, ? extends Object> mapEmptyMap = extrasObtainExtras$default.imageExtras;
        if (mapEmptyMap == null) {
            mapEmptyMap = MapsKt.emptyMap();
        }
        listenerManager.onFinalImageSet(imageId, imageRequest, 7, new ImageInfoImpl(intrinsicWidth, intrinsicHeight, 0, qualityInfo, mapEmptyMap), extrasObtainExtras$default, drawable.getActualImageDrawable());
        DebugOverlayHandler debugOverlayHandler = this.debugOverlayHandler;
        if (debugOverlayHandler != null) {
            debugOverlayHandler.update(drawable);
        }
    }

    @Override // com.facebook.fresco.vito.core.FrescoController2
    public void releaseDelayed(FrescoDrawableInterface drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            KFrescoVitoDrawable kFrescoVitoDrawableAsVitoDrawableOrNull = asVitoDrawableOrNull(drawable);
            if (kFrescoVitoDrawableAsVitoDrawableOrNull == null) {
                return;
            }
            ImageReleaseScheduler.INSTANCE.releaseDelayed(kFrescoVitoDrawableAsVitoDrawableOrNull, this.config.releaseDelayMs());
            return;
        }
        FrescoSystrace.beginSection("KFrescoController#releaseDelayed");
        try {
            KFrescoVitoDrawable kFrescoVitoDrawableAsVitoDrawableOrNull2 = asVitoDrawableOrNull(drawable);
            if (kFrescoVitoDrawableAsVitoDrawableOrNull2 == null) {
                return;
            }
            ImageReleaseScheduler.INSTANCE.releaseDelayed(kFrescoVitoDrawableAsVitoDrawableOrNull2, this.config.releaseDelayMs());
            Unit unit = Unit.INSTANCE;
        } finally {
            FrescoSystrace.endSection();
        }
    }

    @Override // com.facebook.fresco.vito.core.FrescoController2
    public void releaseNextFrame(FrescoDrawableInterface drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            KFrescoVitoDrawable kFrescoVitoDrawableAsVitoDrawableOrNull = asVitoDrawableOrNull(drawable);
            if (kFrescoVitoDrawableAsVitoDrawableOrNull == null) {
                return;
            }
            ImageReleaseScheduler.INSTANCE.releaseNextFrame(kFrescoVitoDrawableAsVitoDrawableOrNull);
            return;
        }
        FrescoSystrace.beginSection("KFrescoController#release");
        try {
            KFrescoVitoDrawable kFrescoVitoDrawableAsVitoDrawableOrNull2 = asVitoDrawableOrNull(drawable);
            if (kFrescoVitoDrawableAsVitoDrawableOrNull2 == null) {
                return;
            }
            ImageReleaseScheduler.INSTANCE.releaseNextFrame(kFrescoVitoDrawableAsVitoDrawableOrNull2);
            Unit unit = Unit.INSTANCE;
        } finally {
            FrescoSystrace.endSection();
        }
    }

    @Override // com.facebook.fresco.vito.core.FrescoController2
    public void releaseImmediately(FrescoDrawableInterface drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            KFrescoVitoDrawable kFrescoVitoDrawableAsVitoDrawableOrNull = asVitoDrawableOrNull(drawable);
            if (kFrescoVitoDrawableAsVitoDrawableOrNull == null) {
                return;
            }
            ImageReleaseScheduler.INSTANCE.releaseImmediately(kFrescoVitoDrawableAsVitoDrawableOrNull);
            return;
        }
        FrescoSystrace.beginSection("KFrescoController#releaseImmediately");
        try {
            KFrescoVitoDrawable kFrescoVitoDrawableAsVitoDrawableOrNull2 = asVitoDrawableOrNull(drawable);
            if (kFrescoVitoDrawableAsVitoDrawableOrNull2 == null) {
                return;
            }
            ImageReleaseScheduler.INSTANCE.releaseImmediately(kFrescoVitoDrawableAsVitoDrawableOrNull2);
            Unit unit = Unit.INSTANCE;
        } finally {
            FrescoSystrace.endSection();
        }
    }

    private final KFrescoVitoDrawable asVitoDrawableOrNull(FrescoDrawableInterface frescoDrawableInterface) {
        if (!(frescoDrawableInterface instanceof KFrescoVitoDrawable)) {
            FLog.e(TAG, "Drawable not supported " + frescoDrawableInterface);
            return null;
        }
        return (KFrescoVitoDrawable) frescoDrawableInterface;
    }

    static /* synthetic */ boolean setActualImage$default(KFrescoController kFrescoController, KFrescoVitoDrawable kFrescoVitoDrawable, VitoImageRequest vitoImageRequest, CloseableReference closeableReference, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return kFrescoController.setActualImage(kFrescoVitoDrawable, vitoImageRequest, closeableReference, z);
    }

    private final boolean setActualImage(KFrescoVitoDrawable kFrescoVitoDrawable, VitoImageRequest vitoImageRequest, CloseableReference<CloseableImage> closeableReference, boolean z) throws Throwable {
        CloseableReference<CloseableImage> closeableReference2;
        Throwable th;
        CloseableImage closeableImage;
        CloseableImage closeableImage2;
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("KFrescoController#setActualImage");
            try {
                try {
                    if (!CloseableReference.isValid(closeableReference)) {
                        CloseableReference.closeSafely(closeableReference);
                        FrescoSystrace.endSection();
                        return false;
                    }
                    if (closeableReference != null && (closeableImage2 = closeableReference.get()) != null) {
                        kFrescoVitoDrawable.setFetchSubmitted(true);
                        kFrescoVitoDrawable.setCloseable(closeableReference.mo11277clone());
                        ActualImageHandlerKt.setActualImage(kFrescoVitoDrawable.getActualImageLayer(), vitoImageRequest.resources, vitoImageRequest.imageOptions, closeableImage2, this.imageToDataModelMapper);
                        kFrescoVitoDrawable.invalidateSelf();
                        ImageInfo imageInfo = closeableImage2.getImageInfo();
                        kFrescoVitoDrawable.getListenerManager().onImageSet(closeableReference, kFrescoVitoDrawable.getViewportDimensions());
                        if (z) {
                            kFrescoVitoDrawable.getListenerManager().onIntermediateImageSet(kFrescoVitoDrawable.get_imageId(), vitoImageRequest, imageInfo);
                        } else {
                            kFrescoVitoDrawable.getListenerManager().onFinalImageSet(kFrescoVitoDrawable.get_imageId(), vitoImageRequest, 6, imageInfo, ExtrasUtilsKt.obtainExtras$default(kFrescoVitoDrawable, null, closeableReference, null, 5, null), kFrescoVitoDrawable.getActualImageDrawable());
                        }
                        DebugOverlayHandler debugOverlayHandler = this.debugOverlayHandler;
                        if (debugOverlayHandler != null) {
                            debugOverlayHandler.update(kFrescoVitoDrawable);
                        }
                        CloseableReference.closeSafely(closeableReference);
                        FrescoSystrace.endSection();
                        return true;
                    }
                    CloseableReference.closeSafely(closeableReference);
                    FrescoSystrace.endSection();
                    return false;
                } catch (Throwable th2) {
                    CloseableReference.closeSafely(closeableReference);
                    throw th2;
                }
            } catch (Throwable th3) {
                FrescoSystrace.endSection();
                throw th3;
            }
        }
        try {
            if (!CloseableReference.isValid(closeableReference)) {
                CloseableReference.closeSafely(closeableReference);
                return false;
            }
            if (closeableReference != null && (closeableImage = closeableReference.get()) != null) {
                kFrescoVitoDrawable.setFetchSubmitted(true);
                kFrescoVitoDrawable.setCloseable(closeableReference.mo11277clone());
                ActualImageHandlerKt.setActualImage(kFrescoVitoDrawable.getActualImageLayer(), vitoImageRequest.resources, vitoImageRequest.imageOptions, closeableImage, this.imageToDataModelMapper);
                kFrescoVitoDrawable.invalidateSelf();
                ImageInfo imageInfo2 = closeableImage.getImageInfo();
                kFrescoVitoDrawable.getListenerManager().onImageSet(closeableReference, kFrescoVitoDrawable.getViewportDimensions());
                if (z) {
                    try {
                        kFrescoVitoDrawable.getListenerManager().onIntermediateImageSet(kFrescoVitoDrawable.get_imageId(), vitoImageRequest, imageInfo2);
                        closeableReference2 = closeableReference;
                    } catch (Throwable th4) {
                        th = th4;
                        closeableReference2 = closeableReference;
                    }
                } else {
                    closeableReference2 = closeableReference;
                    try {
                        kFrescoVitoDrawable.getListenerManager().onFinalImageSet(kFrescoVitoDrawable.get_imageId(), vitoImageRequest, 6, imageInfo2, ExtrasUtilsKt.obtainExtras$default(kFrescoVitoDrawable, null, closeableReference, null, 5, null), kFrescoVitoDrawable.getActualImageDrawable());
                    } catch (Throwable th5) {
                        th = th5;
                    }
                }
                DebugOverlayHandler debugOverlayHandler2 = this.debugOverlayHandler;
                if (debugOverlayHandler2 != null) {
                    debugOverlayHandler2.update(kFrescoVitoDrawable);
                }
                CloseableReference.closeSafely(closeableReference2);
                return true;
            }
            CloseableReference.closeSafely(closeableReference);
            return false;
        } catch (Throwable th6) {
            th = th6;
            closeableReference2 = closeableReference;
        }
        th = th;
        CloseableReference.closeSafely(closeableReference2);
        throw th;
    }

    private final boolean isAlreadyLoadingImage(VitoImageRequest imageRequest, KFrescoVitoDrawable drawable) {
        boolean zAreEqual;
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            if (this.config.useSmartPropertyDiffing()) {
                return imageRequest.equalsIfHasImage(drawable.getImageRequest(), drawable.hasImage());
            }
            return Intrinsics.areEqual(imageRequest, drawable.getImageRequest());
        }
        FrescoSystrace.beginSection("KFrescoController#isAlreadyLoadingImage");
        try {
            if (this.config.useSmartPropertyDiffing()) {
                zAreEqual = imageRequest.equalsIfHasImage(drawable.getImageRequest(), drawable.hasImage());
            } else {
                zAreEqual = Intrinsics.areEqual(imageRequest, drawable.getImageRequest());
            }
            return zAreEqual;
        } finally {
            FrescoSystrace.endSection();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ImageDataModel createDrawableModel(Drawable drawable, ImageOptions options) {
        if (drawable instanceof Animatable) {
            return new AnimatedDrawableImageDataModel(drawable, (Animatable) drawable, options.get_autoPlay());
        }
        return new DrawableImageDataModel(drawable, Intrinsics.areEqual(options.getActualImageScaleType(), ScalingUtils.ScaleType.DISABLED));
    }
}

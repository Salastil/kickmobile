package com.facebook.fresco.vito.core.impl;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.vito.core.CombinedImageListener;
import com.facebook.fresco.vito.core.ImagePerfLoggingListener;
import com.facebook.fresco.vito.core.NopDrawable;
import com.facebook.fresco.vito.core.VitoImagePerfListener;
import com.facebook.fresco.vito.core.VitoImageRequest;
import com.facebook.fresco.vito.core.VitoImageRequestListener;
import com.facebook.fresco.vito.listener.ImageListener;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheGetProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.DataFetchProducer;
import com.facebook.imagepipeline.producers.DiskCacheReadProducer;
import com.facebook.imagepipeline.producers.EncodedMemoryCacheProducer;
import com.facebook.imagepipeline.producers.LocalAssetFetchProducer;
import com.facebook.imagepipeline.producers.LocalContentUriFetchProducer;
import com.facebook.imagepipeline.producers.LocalContentUriThumbnailFetchProducer;
import com.facebook.imagepipeline.producers.LocalExifThumbnailProducer;
import com.facebook.imagepipeline.producers.LocalFileFetchProducer;
import com.facebook.imagepipeline.producers.LocalResourceFetchProducer;
import com.facebook.imagepipeline.producers.LocalThumbnailBitmapSdk29Producer;
import com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer;
import com.facebook.imagepipeline.producers.NetworkFetchProducer;
import com.facebook.imagepipeline.producers.PartialDiskCacheProducer;
import com.facebook.imagepipeline.producers.PostprocessedBitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.QualifiedResourceFetchProducer;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FrescoDrawable2Impl.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u009a\u00012\u00020\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002:\u0002\u009a\u0001BU\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010f\u001a\u0004\u0018\u00010g2\b\u0010h\u001a\u0004\u0018\u00010gJ\"\u0010i\u001a\u0004\u0018\u00010g2\b\u0010j\u001a\u0004\u0018\u00010g2\u000e\u0010b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003J$\u0010n\u001a\u00020o2\u0006\u0010/\u001a\u0002002\u0014\u00108\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u000109J\u0010\u0010q\u001a\u00020o2\u0006\u0010:\u001a\u00020\u0006H\u0016J\u0010\u0010x\u001a\u00020o2\b\u0010y\u001a\u0004\u0018\u00010zJ\u0010\u0010{\u001a\u00020o2\b\u0010y\u001a\u0004\u0018\u00010zJ\b\u0010|\u001a\u00020oH\u0016J\b\u0010}\u001a\u00020oH\u0016J\b\u0010~\u001a\u00020oH\u0016J\u000f\u0010\u007f\u001a\u00020o2\u0007\u0010\u0080\u0001\u001a\u000200J\t\u0010\u0081\u0001\u001a\u00020oH\u0016J\u0007\u0010\u0082\u0001\u001a\u00020oJ\u0007\u0010\u0083\u0001\u001a\u00020oJ\t\u0010\u0084\u0001\u001a\u00020oH\u0016J\u001e\u0010\u0085\u0001\u001a\u00020o2\u0013\u0010\u0086\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000309H\u0016J\u001e\u0010\u0087\u0001\u001a\u00020o2\u0013\u0010\u0086\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000309H\u0016J\u001e\u0010\u0088\u0001\u001a\u00020o2\u0013\u0010\u0086\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000309H\u0016J\u001e\u0010\u0089\u0001\u001a\u00020o2\u0013\u0010\u0086\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000309H\u0016J\u001b\u0010\u008e\u0001\u001a\u00020o2\u0007\u0010\u008f\u0001\u001a\u00020[2\u0007\u0010\u0090\u0001\u001a\u00020[H\u0016J\t\u0010\u0091\u0001\u001a\u00020[H\u0016J\t\u0010\u0092\u0001\u001a\u00020[H\u0016J\u000b\u0010\u0093\u0001\u001a\u0004\u0018\u00010\bH\u0016J\t\u0010\u0094\u0001\u001a\u00020oH\u0016J\t\u0010\u0095\u0001\u001a\u00020\u0006H\u0016J\u0012\u0010\u0096\u0001\u001a\u00020o2\u0007\u0010\u0097\u0001\u001a\u00020\u0006H\u0016J\f\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u0001H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u000200X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u00105\u001a\u0004\u0018\u00010\u001eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010 \"\u0004\b7\u0010\"R\u001c\u00108\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0011\u0010A\u001a\u00020B¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0014\u0010E\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u001a\u0010H\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001a\u0010M\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010J\"\u0004\bO\u0010LR\u000e\u0010P\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010R\u001a\u00020SX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u0011\u0010V\u001a\u00020W¢\u0006\b\n\u0000\u001a\u0004\bX\u0010YR \u0010Z\u001a\u00020[X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR \u0010b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\bc\u0010]R\u000e\u0010d\u001a\u00020[X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020[X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010k\u001a\u0004\u0018\u00010g8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bl\u0010mR\u0014\u0010p\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bp\u0010JR(\u0010r\u001a\u0004\u0018\u00010s2\b\u0010r\u001a\u0004\u0018\u00010s8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u0016\u0010\u008a\u0001\u001a\u00020[8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u008b\u0001\u0010_R\u0016\u0010\u008c\u0001\u001a\u00020[8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u008d\u0001\u0010_¨\u0006\u009b\u0001"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/FrescoDrawable2Impl;", "Lcom/facebook/fresco/vito/core/impl/FrescoDrawable2;", "Lcom/facebook/datasource/DataSubscriber;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "useNewReleaseCallbacks", "", "imagePerfLoggingListener", "Lcom/facebook/fresco/vito/core/ImagePerfLoggingListener;", "vitoImagePerfListener", "Lcom/facebook/fresco/vito/core/VitoImagePerfListener;", "uiFramework", "", "resetVitoImageRequestListener", "resetLocalVitoImageRequestListener", "resetLocalImagePerfStateListener", "resetControllerListener2", "<init>", "(ZLcom/facebook/fresco/vito/core/ImagePerfLoggingListener;Lcom/facebook/fresco/vito/core/VitoImagePerfListener;Ljava/lang/String;ZZZZ)V", "getUiFramework", "()Ljava/lang/String;", "setUiFramework", "(Ljava/lang/String;)V", "imageRequest", "Lcom/facebook/fresco/vito/core/VitoImageRequest;", "getImageRequest", "()Lcom/facebook/fresco/vito/core/VitoImageRequest;", "setImageRequest", "(Lcom/facebook/fresco/vito/core/VitoImageRequest;)V", "callerContext", "", "getCallerContext", "()Ljava/lang/Object;", "setCallerContext", "(Ljava/lang/Object;)V", "drawableDataSubscriber", "Lcom/facebook/fresco/vito/core/impl/DrawableDataSubscriber;", "getDrawableDataSubscriber", "()Lcom/facebook/fresco/vito/core/impl/DrawableDataSubscriber;", "setDrawableDataSubscriber", "(Lcom/facebook/fresco/vito/core/impl/DrawableDataSubscriber;)V", "tempFinalImageExtras", "Lcom/facebook/fresco/ui/common/ControllerListener2$Extras;", "getTempFinalImageExtras", "()Lcom/facebook/fresco/ui/common/ControllerListener2$Extras;", "setTempFinalImageExtras", "(Lcom/facebook/fresco/ui/common/ControllerListener2$Extras;)V", "imageId", "", "getImageId", "()J", "setImageId", "(J)V", "extras", "getExtras", "setExtras", "dataSource", "Lcom/facebook/datasource/DataSource;", "fetchSubmitted", "refetchRunnable", "Ljava/lang/Runnable;", "getRefetchRunnable", "()Ljava/lang/Runnable;", "setRefetchRunnable", "(Ljava/lang/Runnable;)V", "internalListener", "Lcom/facebook/fresco/vito/core/CombinedImageListener;", "getInternalListener", "()Lcom/facebook/fresco/vito/core/CombinedImageListener;", "imagePerfListener", "getImagePerfListener", "()Lcom/facebook/fresco/vito/core/VitoImagePerfListener;", "forceReloadIfImageAlreadySet", "getForceReloadIfImageAlreadySet", "()Z", "setForceReloadIfImageAlreadySet", "(Z)V", "retriggerListenersIfImageAlreadySet", "getRetriggerListenersIfImageAlreadySet", "setRetriggerListenersIfImageAlreadySet", "releaseRunnable", "delayedReleasePending", "actualImageWrapper", "Lcom/facebook/drawee/drawable/ScaleTypeDrawable;", "getActualImageWrapper", "()Lcom/facebook/drawee/drawable/ScaleTypeDrawable;", "imageOriginListener", "Lcom/facebook/imagepipeline/listener/RequestListener;", "getImageOriginListener", "()Lcom/facebook/imagepipeline/listener/RequestListener;", "imageOrigin", "", "getImageOrigin$annotations", "()V", "getImageOrigin", "()I", "setImageOrigin", "(I)V", "imageReference", "getImageReference$annotations", "_intrinsicWidth", "_intrinsicHeight", "setImageDrawable", "Landroid/graphics/drawable/Drawable;", "newDrawable", "setImage", "imageDrawable", "actualImageDrawable", "getActualImageDrawable", "()Landroid/graphics/drawable/Drawable;", "setDataSource", "", "isFetchSubmitted", "setFetchSubmitted", "imageListener", "Lcom/facebook/fresco/vito/listener/ImageListener;", "getImageListener", "()Lcom/facebook/fresco/vito/listener/ImageListener;", "setImageListener", "(Lcom/facebook/fresco/vito/listener/ImageListener;)V", "setVitoImageRequestListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/facebook/fresco/vito/core/VitoImageRequestListener;", "setLocalVitoImageRequestListener", "release", "reset", "close", "scheduleReleaseDelayed", "releaseDelayMs", "cancelReleaseDelayed", "scheduleReleaseNextFrame", "releaseImmediately", "cancelReleaseNextFrame", "onNewResult", "p0", "onFailure", "onCancellation", "onProgressUpdate", "actualImageWidthPx", "getActualImageWidthPx", "actualImageHeightPx", "getActualImageHeightPx", "setIntrinsicSize", ViewProps.WIDTH, ViewProps.HEIGHT, "getIntrinsicWidth", "getIntrinsicHeight", "getImagePerfLoggingListener", "configureWhenUnderlyingChanged", "hasBitmapWithGainmap", "reportVisible", ViewProps.VISIBLE, "maybeGetActualImageBitmap", "Landroid/graphics/Bitmap;", "Companion", "core-java-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FrescoDrawable2Impl extends FrescoDrawable2 implements DataSubscriber<CloseableReference<CloseableImage>> {
    private static final DeferredReleaser deferredReleaser;
    private int _intrinsicHeight;
    private int _intrinsicWidth;
    private final ScaleTypeDrawable actualImageWrapper;
    private Object callerContext;
    private DataSource<CloseableReference<CloseableImage>> dataSource;
    private boolean delayedReleasePending;
    private DrawableDataSubscriber drawableDataSubscriber;
    private Object extras;
    private boolean fetchSubmitted;
    private boolean forceReloadIfImageAlreadySet;
    private long imageId;
    private int imageOrigin;
    private final RequestListener imageOriginListener;
    private final VitoImagePerfListener imagePerfListener;
    public CloseableReference<CloseableImage> imageReference;
    private VitoImageRequest imageRequest;
    private final CombinedImageListener internalListener;
    private Runnable refetchRunnable;
    private final Runnable releaseRunnable;
    private final boolean resetControllerListener2;
    private final boolean resetLocalImagePerfStateListener;
    private final boolean resetLocalVitoImageRequestListener;
    private final boolean resetVitoImageRequestListener;
    private boolean retriggerListenersIfImageAlreadySet;
    private ControllerListener2.Extras tempFinalImageExtras;
    private String uiFramework;
    private final boolean useNewReleaseCallbacks;
    private static final Handler handler = new Handler(Looper.getMainLooper());

    public static /* synthetic */ void getImageOrigin$annotations() {
    }

    public static /* synthetic */ void getImageReference$annotations() {
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public void configureWhenUnderlyingChanged() {
    }

    @Override // com.facebook.datasource.DataSubscriber
    public void onCancellation(DataSource<CloseableReference<CloseableImage>> p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
    }

    public /* synthetic */ FrescoDrawable2Impl(boolean z, ImagePerfLoggingListener imagePerfLoggingListener, VitoImagePerfListener vitoImagePerfListener, String str, boolean z2, boolean z3, boolean z4, boolean z5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, imagePerfLoggingListener, vitoImagePerfListener, (i & 8) != 0 ? null : str, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? false : z3, (i & 64) != 0 ? false : z4, (i & 128) != 0 ? false : z5);
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public String getUiFramework() {
        return this.uiFramework;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public void setUiFramework(String str) {
        this.uiFramework = str;
    }

    public FrescoDrawable2Impl(boolean z, ImagePerfLoggingListener imagePerfLoggingListener, VitoImagePerfListener vitoImagePerfListener, String str, boolean z2, boolean z3, boolean z4, boolean z5) {
        Intrinsics.checkNotNullParameter(vitoImagePerfListener, "vitoImagePerfListener");
        this.useNewReleaseCallbacks = z;
        this.uiFramework = str;
        this.resetVitoImageRequestListener = z2;
        this.resetLocalVitoImageRequestListener = z3;
        this.resetLocalImagePerfStateListener = z4;
        this.resetControllerListener2 = z5;
        CombinedImageListenerImpl combinedImageListenerImpl = new CombinedImageListenerImpl();
        this.internalListener = combinedImageListenerImpl;
        combinedImageListenerImpl.setImagePerfLoggingListener(imagePerfLoggingListener);
        this.imagePerfListener = vitoImagePerfListener;
        this.releaseRunnable = new Runnable() { // from class: com.facebook.fresco.vito.core.impl.FrescoDrawable2Impl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.scheduleReleaseNextFrame();
            }
        };
        NopDrawable nopDrawable = NopDrawable.INSTANCE;
        ScalingUtils.ScaleType CENTER_CROP = ScalingUtils.ScaleType.CENTER_CROP;
        Intrinsics.checkNotNullExpressionValue(CENTER_CROP, "CENTER_CROP");
        this.actualImageWrapper = new ScaleTypeDrawable(nopDrawable, CENTER_CROP);
        this.imageOriginListener = new BaseRequestListener() { // from class: com.facebook.fresco.vito.core.impl.FrescoDrawable2Impl$imageOriginListener$1
            @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
            public void onUltimateProducerReached(String requestId, String producerName, boolean successful) {
                Intrinsics.checkNotNullParameter(requestId, "requestId");
                Intrinsics.checkNotNullParameter(producerName, "producerName");
                this.this$0.setImageOrigin(mapProducerNameToImageOrigin(producerName));
            }

            private final int mapProducerNameToImageOrigin(String producerName) {
                switch (producerName.hashCode()) {
                    case -1917159454:
                        return !producerName.equals(QualifiedResourceFetchProducer.PRODUCER_NAME) ? 1 : 7;
                    case -1914072202:
                        return producerName.equals(BitmapMemoryCacheGetProducer.PRODUCER_NAME) ? 5 : 1;
                    case -1683996557:
                        return !producerName.equals(LocalResourceFetchProducer.PRODUCER_NAME) ? 1 : 7;
                    case -1579985851:
                        return !producerName.equals(LocalFileFetchProducer.PRODUCER_NAME) ? 1 : 7;
                    case -1307634203:
                        return !producerName.equals(EncodedMemoryCacheProducer.PRODUCER_NAME) ? 1 : 4;
                    case -1224383234:
                        return !producerName.equals(NetworkFetchProducer.PRODUCER_NAME) ? 1 : 2;
                    case -1153560861:
                        return !producerName.equals(LocalExifThumbnailProducer.PRODUCER_NAME) ? 1 : 7;
                    case 3321379:
                        return !producerName.equals(LocalThumbnailBitmapSdk29Producer.PRODUCER_NAME) ? 1 : 7;
                    case 473552259:
                        return !producerName.equals(LocalVideoThumbnailProducer.PRODUCER_NAME) ? 1 : 7;
                    case 656304759:
                        return !producerName.equals(DiskCacheReadProducer.PRODUCER_NAME) ? 1 : 3;
                    case 957714404:
                        return !producerName.equals(BitmapMemoryCacheProducer.PRODUCER_NAME) ? 1 : 5;
                    case 1019542023:
                        return !producerName.equals(LocalAssetFetchProducer.PRODUCER_NAME) ? 1 : 7;
                    case 1023071510:
                        return !producerName.equals(PostprocessedBitmapMemoryCacheProducer.PRODUCER_NAME) ? 1 : 5;
                    case 1721672898:
                        return !producerName.equals(DataFetchProducer.PRODUCER_NAME) ? 1 : 7;
                    case 1793127518:
                        return !producerName.equals(LocalContentUriThumbnailFetchProducer.PRODUCER_NAME) ? 1 : 7;
                    case 2109593398:
                        return !producerName.equals(PartialDiskCacheProducer.PRODUCER_NAME) ? 1 : 3;
                    case 2113652014:
                        return !producerName.equals(LocalContentUriFetchProducer.PRODUCER_NAME) ? 1 : 7;
                    default:
                        return 1;
                }
            }
        };
        this.imageOrigin = 1;
        this._intrinsicWidth = -1;
        this._intrinsicHeight = -1;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public VitoImageRequest getImageRequest() {
        return this.imageRequest;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public void setImageRequest(VitoImageRequest vitoImageRequest) {
        this.imageRequest = vitoImageRequest;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public Object getCallerContext() {
        return this.callerContext;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public void setCallerContext(Object obj) {
        this.callerContext = obj;
    }

    public final DrawableDataSubscriber getDrawableDataSubscriber() {
        return this.drawableDataSubscriber;
    }

    public final void setDrawableDataSubscriber(DrawableDataSubscriber drawableDataSubscriber) {
        this.drawableDataSubscriber = drawableDataSubscriber;
    }

    public final ControllerListener2.Extras getTempFinalImageExtras() {
        return this.tempFinalImageExtras;
    }

    public final void setTempFinalImageExtras(ControllerListener2.Extras extras) {
        this.tempFinalImageExtras = extras;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    /* JADX INFO: renamed from: getImageId */
    public synchronized long get_imageId() {
        return this.imageId;
    }

    public synchronized void setImageId(long j) {
        this.imageId = j;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public Object getExtras() {
        return this.extras;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public void setExtras(Object obj) {
        this.extras = obj;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public Runnable getRefetchRunnable() {
        return this.refetchRunnable;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public void setRefetchRunnable(Runnable runnable) {
        this.refetchRunnable = runnable;
    }

    public final CombinedImageListener getInternalListener() {
        return this.internalListener;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public VitoImagePerfListener getImagePerfListener() {
        return this.imagePerfListener;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public boolean getForceReloadIfImageAlreadySet() {
        return this.forceReloadIfImageAlreadySet;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public void setForceReloadIfImageAlreadySet(boolean z) {
        this.forceReloadIfImageAlreadySet = z;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public boolean getRetriggerListenersIfImageAlreadySet() {
        return this.retriggerListenersIfImageAlreadySet;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public void setRetriggerListenersIfImageAlreadySet(boolean z) {
        this.retriggerListenersIfImageAlreadySet = z;
    }

    @Override // com.facebook.fresco.vito.core.impl.FrescoDrawable2
    public ScaleTypeDrawable getActualImageWrapper() {
        return this.actualImageWrapper;
    }

    public final RequestListener getImageOriginListener() {
        return this.imageOriginListener;
    }

    public final int getImageOrigin() {
        return this.imageOrigin;
    }

    public final void setImageOrigin(int i) {
        this.imageOrigin = i;
    }

    public final Drawable setImageDrawable(Drawable newDrawable) {
        return setImage(newDrawable, null);
    }

    public final Drawable setImage(Drawable imageDrawable, CloseableReference<CloseableImage> imageReference) {
        cancelReleaseNextFrame();
        cancelReleaseDelayed();
        if (imageDrawable != getActualImageWrapper()) {
            getActualImageWrapper().setCurrent(NopDrawable.INSTANCE);
        }
        CloseableReference.closeSafely(this.imageReference);
        this.imageReference = CloseableReference.cloneOrNull(imageReference);
        return setDrawable(1, imageDrawable);
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public Drawable getActualImageDrawable() {
        Drawable drawable = getDrawable(1);
        return drawable == getActualImageWrapper() ? getActualImageWrapper().getDrawable() : drawable;
    }

    public final synchronized void setDataSource(long imageId, DataSource<CloseableReference<CloseableImage>> dataSource) {
        if (imageId != get_imageId()) {
            return;
        }
        DataSource<CloseableReference<CloseableImage>> dataSource2 = this.dataSource;
        if (dataSource2 != null && dataSource2 != dataSource) {
            dataSource2.close();
        }
        this.dataSource = dataSource;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    /* JADX INFO: renamed from: isFetchSubmitted, reason: from getter */
    public boolean getFetchSubmitted() {
        return this.fetchSubmitted;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public void setFetchSubmitted(boolean fetchSubmitted) {
        this.fetchSubmitted = fetchSubmitted;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public ImageListener getImageListener() {
        return this.internalListener.getImageListener();
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public void setImageListener(ImageListener imageListener) {
        this.internalListener.setImageListener(imageListener);
    }

    public final void setVitoImageRequestListener(VitoImageRequestListener listener) {
        this.internalListener.setVitoImageRequestListener(listener);
    }

    public final void setLocalVitoImageRequestListener(VitoImageRequestListener listener) {
        this.internalListener.setLocalVitoImageRequestListener(listener);
    }

    @Override // com.facebook.drawee.components.DeferredReleaser.Releasable
    public void release() {
        close();
    }

    @Override // com.facebook.drawee.drawable.FadeDrawable
    public void reset() {
        this._intrinsicWidth = -1;
        this._intrinsicHeight = -1;
        close();
    }

    @Override // com.facebook.fresco.vito.core.impl.FrescoDrawable2, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        DrawableDataSubscriber drawableDataSubscriber;
        cancelReleaseNextFrame();
        cancelReleaseDelayed();
        if (this.useNewReleaseCallbacks && this.fetchSubmitted && (drawableDataSubscriber = this.drawableDataSubscriber) != null) {
            drawableDataSubscriber.onRelease(this);
        }
        setImageId(0L);
        super.close();
        super.reset();
        getActualImageWrapper().setCurrent(NopDrawable.INSTANCE);
        CloseableReference.closeSafely(this.imageReference);
        this.imageReference = null;
        this.drawableDataSubscriber = null;
        DataSource<CloseableReference<CloseableImage>> dataSource = this.dataSource;
        if (dataSource != null) {
            dataSource.close();
        }
        this.dataSource = null;
        this.fetchSubmitted = false;
        setImageRequest(null);
        this.imageOrigin = 1;
        setExtras(null);
        setForceReloadIfImageAlreadySet(false);
        setRetriggerListenersIfImageAlreadySet(false);
        setOnFadeListener(null);
        this.tempFinalImageExtras = null;
        this.internalListener.onReset(this.resetVitoImageRequestListener, this.resetLocalVitoImageRequestListener, this.resetLocalImagePerfStateListener, this.resetControllerListener2);
    }

    public final void scheduleReleaseDelayed(long releaseDelayMs) {
        if (this.delayedReleasePending) {
            return;
        }
        handler.postDelayed(this.releaseRunnable, releaseDelayMs);
        this.delayedReleasePending = true;
    }

    @Override // com.facebook.fresco.vito.core.impl.FrescoDrawable2
    public void cancelReleaseDelayed() {
        if (this.delayedReleasePending) {
            handler.removeCallbacks(this.releaseRunnable);
            this.delayedReleasePending = false;
        }
    }

    public final void scheduleReleaseNextFrame() {
        DrawableDataSubscriber drawableDataSubscriber;
        cancelReleaseDelayed();
        deferredReleaser.scheduleDeferredRelease(this);
        if (this.useNewReleaseCallbacks || (drawableDataSubscriber = this.drawableDataSubscriber) == null) {
            return;
        }
        drawableDataSubscriber.onRelease(this);
    }

    public final void releaseImmediately() {
        DrawableDataSubscriber drawableDataSubscriber;
        if (!this.useNewReleaseCallbacks && (drawableDataSubscriber = this.drawableDataSubscriber) != null) {
            drawableDataSubscriber.onRelease(this);
        }
        close();
    }

    @Override // com.facebook.fresco.vito.core.impl.FrescoDrawable2
    public void cancelReleaseNextFrame() {
        deferredReleaser.cancelDeferredRelease(this);
    }

    @Override // com.facebook.datasource.DataSubscriber
    public void onNewResult(DataSource<CloseableReference<CloseableImage>> p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        VitoImageRequest imageRequest = getImageRequest();
        DrawableDataSubscriber drawableDataSubscriber = this.drawableDataSubscriber;
        if (p0 != this.dataSource || imageRequest == null || drawableDataSubscriber == null) {
            getImagePerfListener().onIgnoreResult(this);
        } else {
            drawableDataSubscriber.onNewResult(this, imageRequest, p0);
        }
    }

    @Override // com.facebook.datasource.DataSubscriber
    public void onFailure(DataSource<CloseableReference<CloseableImage>> p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        VitoImageRequest imageRequest = getImageRequest();
        DrawableDataSubscriber drawableDataSubscriber = this.drawableDataSubscriber;
        if (p0 != this.dataSource || imageRequest == null || drawableDataSubscriber == null) {
            getImagePerfListener().onIgnoreFailure(this);
        } else {
            drawableDataSubscriber.onFailure(this, imageRequest, p0);
        }
    }

    @Override // com.facebook.datasource.DataSubscriber
    public void onProgressUpdate(DataSource<CloseableReference<CloseableImage>> p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        VitoImageRequest imageRequest = getImageRequest();
        DrawableDataSubscriber drawableDataSubscriber = this.drawableDataSubscriber;
        if (p0 != this.dataSource || imageRequest == null || drawableDataSubscriber == null) {
            return;
        }
        drawableDataSubscriber.onProgressUpdate(this, imageRequest, p0);
    }

    @Override // com.facebook.fresco.vito.core.impl.FrescoDrawable2
    public int getActualImageWidthPx() {
        CloseableImage closeableImage;
        CloseableReference<CloseableImage> closeableReference = this.imageReference;
        if (closeableReference == null) {
            return -1;
        }
        if (!CloseableReference.isValid(closeableReference)) {
            closeableReference = null;
        }
        if (closeableReference == null || (closeableImage = closeableReference.get()) == null) {
            return -1;
        }
        return closeableImage.getWidth();
    }

    @Override // com.facebook.fresco.vito.core.impl.FrescoDrawable2
    public int getActualImageHeightPx() {
        CloseableImage closeableImage;
        CloseableReference<CloseableImage> closeableReference = this.imageReference;
        if (closeableReference == null) {
            return -1;
        }
        if (!CloseableReference.isValid(closeableReference)) {
            closeableReference = null;
        }
        if (closeableReference == null || (closeableImage = closeableReference.get()) == null) {
            return -1;
        }
        return closeableImage.getHeight();
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public void setIntrinsicSize(int width, int height) {
        this._intrinsicWidth = width;
        this._intrinsicHeight = height;
    }

    @Override // com.facebook.drawee.drawable.ArrayDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i = this._intrinsicWidth;
        return i != -1 ? i : super.getIntrinsicWidth();
    }

    @Override // com.facebook.drawee.drawable.ArrayDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        int i = this._intrinsicHeight;
        return i != -1 ? i : super.getIntrinsicHeight();
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public ImagePerfLoggingListener getImagePerfLoggingListener() {
        return this.internalListener.getImagePerfLoggingListener();
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public boolean hasBitmapWithGainmap() {
        Bitmap bitmapMaybeGetActualImageBitmap;
        return Build.VERSION.SDK_INT >= 34 && (bitmapMaybeGetActualImageBitmap = maybeGetActualImageBitmap()) != null && bitmapMaybeGetActualImageBitmap.hasGainmap();
    }

    @Override // com.facebook.fresco.ui.common.VisibilityAware
    public void reportVisible(boolean visible) {
        ImagePerfLoggingListener imagePerfLoggingListener = getImagePerfLoggingListener();
        if (imagePerfLoggingListener != null) {
            imagePerfLoggingListener.reportVisible(visible);
        }
    }

    private final Bitmap maybeGetActualImageBitmap() {
        Drawable actualImageDrawable = getActualImageDrawable();
        if (actualImageDrawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) actualImageDrawable).getBitmap();
        }
        return null;
    }

    static {
        DeferredReleaser deferredReleaser2 = DeferredReleaser.getInstance();
        Intrinsics.checkNotNullExpressionValue(deferredReleaser2, "getInstance(...)");
        deferredReleaser = deferredReleaser2;
    }
}

package com.facebook.fresco.vito.core.impl;

import android.content.res.Resources;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import com.facebook.fresco.vito.core.VitoImageRequest;
import com.facebook.fresco.vito.options.ImageOptions;
import com.facebook.fresco.vito.renderer.ImageDataModel;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageFetchSubscriber.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001BQ\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012 \u0010\b\u001a\u001c\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u001c\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0016H\u0016J\u001c\u0010\u0017\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0016H\u0016J\u001c\u0010\u0018\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0016H\u0016J\u001c\u0010\u0019\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u001e\u0010\u001b\u001a\u00020\u001c2\u0014\u0010\u0015\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u0016H\u0002J\u001c\u0010\u001d\u001a\u00020\u001e2\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\b\u001a\u001c\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/ImageFetchSubscriber;", "Lcom/facebook/datasource/DataSubscriber;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "imageId", "", "drawable", "Lcom/facebook/fresco/vito/core/impl/KFrescoVitoDrawable;", "imageToDataModelMapper", "Lkotlin/Function3;", "Landroid/content/res/Resources;", "Lcom/facebook/fresco/vito/options/ImageOptions;", "Lcom/facebook/fresco/vito/renderer/ImageDataModel;", "debugOverlayHandler", "Lcom/facebook/fresco/vito/core/impl/DebugOverlayHandler;", "invalidationExecutor", "Ljava/util/concurrent/Executor;", "<init>", "(JLcom/facebook/fresco/vito/core/impl/KFrescoVitoDrawable;Lkotlin/jvm/functions/Function3;Lcom/facebook/fresco/vito/core/impl/DebugOverlayHandler;Ljava/util/concurrent/Executor;)V", "onNewResult", "", "dataSource", "Lcom/facebook/datasource/DataSource;", "onFailure", "onCancellation", "onProgressUpdate", "invalidate", "notifyFinalResult", "", "originFromExtras", "", "core-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ImageFetchSubscriber implements DataSubscriber<CloseableReference<CloseableImage>> {
    private final DebugOverlayHandler debugOverlayHandler;
    private final KFrescoVitoDrawable drawable;
    private final long imageId;
    private final Function3<Resources, CloseableImage, ImageOptions, ImageDataModel> imageToDataModelMapper;
    private final Executor invalidationExecutor;

    @Override // com.facebook.datasource.DataSubscriber
    public void onCancellation(DataSource<CloseableReference<CloseableImage>> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImageFetchSubscriber(long j, KFrescoVitoDrawable drawable, Function3<? super Resources, ? super CloseableImage, ? super ImageOptions, ? extends ImageDataModel> imageToDataModelMapper, DebugOverlayHandler debugOverlayHandler, Executor executor) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Intrinsics.checkNotNullParameter(imageToDataModelMapper, "imageToDataModelMapper");
        this.imageId = j;
        this.drawable = drawable;
        this.imageToDataModelMapper = imageToDataModelMapper;
        this.debugOverlayHandler = debugOverlayHandler;
        this.invalidationExecutor = executor;
    }

    public /* synthetic */ ImageFetchSubscriber(long j, KFrescoVitoDrawable kFrescoVitoDrawable, Function3 function3, DebugOverlayHandler debugOverlayHandler, Executor executor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, kFrescoVitoDrawable, function3, (i & 8) != 0 ? null : debugOverlayHandler, (i & 16) != 0 ? null : executor);
    }

    @Override // com.facebook.datasource.DataSubscriber
    public void onNewResult(DataSource<CloseableReference<CloseableImage>> dataSource) {
        final VitoImageRequest imageRequest;
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        if (this.imageId == this.drawable.get_imageId() && (imageRequest = this.drawable.getImageRequest()) != null) {
            CloseableReference<CloseableImage> result = dataSource.getResult();
            if (result == null || !result.isValid()) {
                onFailure(dataSource);
                if (result != null) {
                    result.close();
                    return;
                }
                return;
            }
            this.drawable.setCloseable(result);
            CloseableImage closeableImage = result.get();
            ImageLayerDataModel actualImageLayer = this.drawable.getActualImageLayer();
            Resources resources = imageRequest.resources;
            ImageOptions imageOptions = imageRequest.imageOptions;
            Intrinsics.checkNotNull(closeableImage);
            ActualImageHandlerKt.setActualImage(actualImageLayer, resources, imageOptions, closeableImage, this.imageToDataModelMapper);
            Executor executor = this.invalidationExecutor;
            if (executor != null) {
                executor.execute(new Runnable() { // from class: com.facebook.fresco.vito.core.impl.ImageFetchSubscriber$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImageFetchSubscriber.onNewResult$lambda$0(this.f$0, imageRequest);
                    }
                });
            }
            if (dataSource.isFinished()) {
                ProgressLayerHandlerKt.hideProgressLayer(this.drawable);
            }
            ImageInfo imageInfo = closeableImage.getImageInfo();
            boolean zNotifyFinalResult = notifyFinalResult(dataSource);
            KFrescoVitoDrawable kFrescoVitoDrawable = this.drawable;
            if (zNotifyFinalResult) {
                kFrescoVitoDrawable.getListenerManager().onFinalImageSet(this.imageId, imageRequest, originFromExtras(dataSource), imageInfo, ExtrasUtilsKt.obtainExtras$default(this.drawable, dataSource, result, null, 4, null), this.drawable.getActualImageDrawable());
            } else {
                kFrescoVitoDrawable.getListenerManager().onIntermediateImageSet(this.imageId, imageRequest, imageInfo);
            }
            invalidate(this.drawable);
        }
    }

    static final void onNewResult$lambda$0(ImageFetchSubscriber imageFetchSubscriber, VitoImageRequest vitoImageRequest) {
        imageFetchSubscriber.drawable.getActualImageLayer().fadeIn(vitoImageRequest.imageOptions.getFadeDurationMs());
        imageFetchSubscriber.drawable.getPlaceholderLayer().fadeOut(vitoImageRequest.imageOptions.getFadeDurationMs(), true);
    }

    @Override // com.facebook.datasource.DataSubscriber
    public void onFailure(DataSource<CloseableReference<CloseableImage>> dataSource) {
        VitoImageRequest imageRequest;
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        if (this.imageId == this.drawable.get_imageId() && (imageRequest = this.drawable.getImageRequest()) != null) {
            ActualImageHandlerKt.setError(this.drawable.getActualImageLayer(), imageRequest.resources, imageRequest.imageOptions);
            if (dataSource.isFinished()) {
                ProgressLayerHandlerKt.hideProgressLayer(this.drawable);
            }
            if (notifyFinalResult(dataSource)) {
                CloseableReference<CloseableImage> result = dataSource.getResult();
                try {
                    this.drawable.getListenerManager().onFailure(this.imageId, imageRequest, ImageLayerDataModelExtensionsKt.maybeGetDrawable(this.drawable.getActualImageLayer().getDataModel()), dataSource.getFailureCause(), ExtrasUtilsKt.obtainExtras$default(this.drawable, dataSource, result, null, 4, null));
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(result, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(result, th);
                        throw th2;
                    }
                }
            } else {
                this.drawable.getListenerManager().onIntermediateImageFailed(this.imageId, imageRequest, dataSource.getFailureCause());
            }
            this.drawable.getImagePerfListener().onImageError(this.drawable);
            invalidate(this.drawable);
        }
    }

    @Override // com.facebook.datasource.DataSubscriber
    public void onProgressUpdate(DataSource<CloseableReference<CloseableImage>> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        ProgressLayerHandlerKt.updateProgress(this.drawable, dataSource);
        DebugOverlayHandler debugOverlayHandler = this.debugOverlayHandler;
        if (debugOverlayHandler != null) {
            debugOverlayHandler.update(this.drawable);
        }
    }

    private final void invalidate(final KFrescoVitoDrawable drawable) {
        Executor executor = this.invalidationExecutor;
        if (executor != null) {
            executor.execute(new Runnable() { // from class: com.facebook.fresco.vito.core.impl.ImageFetchSubscriber$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    drawable.invalidateSelf();
                }
            });
        } else {
            drawable.invalidateSelf();
        }
        DebugOverlayHandler debugOverlayHandler = this.debugOverlayHandler;
        if (debugOverlayHandler != null) {
            debugOverlayHandler.update(drawable);
        }
    }

    private final boolean notifyFinalResult(DataSource<CloseableReference<CloseableImage>> dataSource) {
        return dataSource == null || dataSource.isFinished() || dataSource.hasMultipleResults();
    }

    private final int originFromExtras(DataSource<CloseableReference<CloseableImage>> dataSource) {
        Map<String, Object> extras = dataSource.getExtras();
        Object obj = extras != null ? extras.get("origin") : null;
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            return 1;
        }
        switch (str.hashCode()) {
            case 3083677:
                return !str.equals("disk") ? 1 : 3;
            case 103145323:
                return !str.equals(ImagesContract.LOCAL) ? 1 : 7;
            case 616257488:
                return !str.equals("memory_encoded") ? 1 : 4;
            case 1453899309:
                return !str.equals("memory_bitmap") ? 1 : 5;
            case 1843485230:
                return str.equals("network") ? 2 : 1;
            default:
                return 1;
        }
    }
}

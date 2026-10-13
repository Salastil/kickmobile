package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.CancellationSignal;
import android.util.Size;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.media.MediaUtils;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public class LocalThumbnailBitmapSdk29Producer implements Producer<CloseableReference<CloseableImage>> {
    static final String CREATED_THUMBNAIL = "createdThumbnail";
    public static final String PRODUCER_NAME = "LocalThumbnailBitmapSdk29Producer";
    private final ContentResolver mContentResolver;
    private final Executor mExecutor;
    private final Boolean mLoadThumbnailFromContentResolverFirst;
    private final Boolean mLoadThumbnailFromContentResolverForContentUriOnly;

    public LocalThumbnailBitmapSdk29Producer(Executor executor, ContentResolver contentResolver, Boolean bool, Boolean bool2) {
        this.mExecutor = executor;
        this.mContentResolver = contentResolver;
        this.mLoadThumbnailFromContentResolverFirst = bool;
        this.mLoadThumbnailFromContentResolverForContentUriOnly = bool2;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, final ProducerContext producerContext) {
        final ProducerListener2 producerListener = producerContext.getProducerListener();
        final ImageRequest imageRequest = producerContext.getImageRequest();
        producerContext.putOriginExtra(ImagesContract.LOCAL, "thumbnail_bitmap");
        final CancellationSignal cancellationSignal = new CancellationSignal();
        final StatefulProducerRunnable<CloseableReference<CloseableImage>> statefulProducerRunnable = new StatefulProducerRunnable<CloseableReference<CloseableImage>>(consumer, producerListener, producerContext, PRODUCER_NAME) { // from class: com.facebook.imagepipeline.producers.LocalThumbnailBitmapSdk29Producer.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            public void onSuccess(@Nullable CloseableReference<CloseableImage> closeableReference) {
                super.onSuccess(closeableReference);
                producerListener.onUltimateProducerReached(producerContext, LocalThumbnailBitmapSdk29Producer.PRODUCER_NAME, closeableReference != null);
                producerContext.putOriginExtra(ImagesContract.LOCAL, "thumbnail_bitmap");
            }

            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            protected void onFailure(Exception exc) {
                super.onFailure(exc);
                producerListener.onUltimateProducerReached(producerContext, LocalThumbnailBitmapSdk29Producer.PRODUCER_NAME, false);
                producerContext.putOriginExtra(ImagesContract.LOCAL, "thumbnail_bitmap");
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.executors.StatefulRunnable
            @Nullable
            public CloseableReference<CloseableImage> getResult() throws IOException {
                String localFilePath;
                Bitmap bitmapLoadThumbnail;
                String localFilePath2;
                Bitmap bitmapCreateImageThumbnail;
                Size size = new Size(imageRequest.getPreferredWidth(), imageRequest.getPreferredHeight());
                boolean zBooleanValue = LocalThumbnailBitmapSdk29Producer.this.mLoadThumbnailFromContentResolverFirst.booleanValue();
                LocalThumbnailBitmapSdk29Producer localThumbnailBitmapSdk29Producer = LocalThumbnailBitmapSdk29Producer.this;
                if (zBooleanValue) {
                    bitmapLoadThumbnail = (!localThumbnailBitmapSdk29Producer.mLoadThumbnailFromContentResolverForContentUriOnly.booleanValue() || "content".equals(imageRequest.getSourceUri().getScheme())) ? LocalThumbnailBitmapSdk29Producer.this.mContentResolver.loadThumbnail(imageRequest.getSourceUri(), size, cancellationSignal) : null;
                    if (bitmapLoadThumbnail == null) {
                        try {
                            localFilePath2 = LocalThumbnailBitmapSdk29Producer.this.getLocalFilePath(imageRequest);
                        } catch (IllegalArgumentException unused) {
                            localFilePath2 = null;
                        }
                        if (localFilePath2 != null) {
                            if (MediaUtils.isVideo(MediaUtils.extractMime(localFilePath2))) {
                                bitmapCreateImageThumbnail = ThumbnailUtils.createVideoThumbnail(new File(localFilePath2), size, cancellationSignal);
                            } else {
                                bitmapCreateImageThumbnail = ThumbnailUtils.createImageThumbnail(new File(localFilePath2), size, cancellationSignal);
                            }
                            bitmapLoadThumbnail = bitmapCreateImageThumbnail;
                        }
                    }
                } else {
                    try {
                        localFilePath = localThumbnailBitmapSdk29Producer.getLocalFilePath(imageRequest);
                    } catch (IllegalArgumentException unused2) {
                        localFilePath = null;
                    }
                    if (localFilePath == null) {
                        bitmapLoadThumbnail = null;
                    } else if (MediaUtils.isVideo(MediaUtils.extractMime(localFilePath))) {
                        bitmapLoadThumbnail = ThumbnailUtils.createVideoThumbnail(new File(localFilePath), size, cancellationSignal);
                    } else {
                        bitmapLoadThumbnail = ThumbnailUtils.createImageThumbnail(new File(localFilePath), size, cancellationSignal);
                    }
                    if (bitmapLoadThumbnail == null) {
                        bitmapLoadThumbnail = LocalThumbnailBitmapSdk29Producer.this.mContentResolver.loadThumbnail(imageRequest.getSourceUri(), size, cancellationSignal);
                    }
                }
                if (bitmapLoadThumbnail == null) {
                    return null;
                }
                CloseableStaticBitmap closeableStaticBitmapOf = CloseableStaticBitmap.of(bitmapLoadThumbnail, SimpleBitmapReleaser.getInstance(), ImmutableQualityInfo.FULL_QUALITY, 0);
                producerContext.putExtra("image_format", "thumbnail");
                closeableStaticBitmapOf.putExtras(producerContext.getExtras());
                return CloseableReference.of(closeableStaticBitmapOf);
            }

            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            protected void onCancellation() {
                super.onCancellation();
                cancellationSignal.cancel();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable
            public Map<String, String> getExtraMapOnSuccess(@Nullable CloseableReference<CloseableImage> closeableReference) {
                return ImmutableMap.of(LocalThumbnailBitmapSdk29Producer.CREATED_THUMBNAIL, String.valueOf(closeableReference != null));
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            public void disposeResult(@Nullable CloseableReference<CloseableImage> closeableReference) {
                CloseableReference.closeSafely(closeableReference);
            }
        };
        producerContext.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.LocalThumbnailBitmapSdk29Producer.2
            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                statefulProducerRunnable.cancel();
            }
        });
        this.mExecutor.execute(statefulProducerRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public String getLocalFilePath(ImageRequest imageRequest) {
        return UriUtil.getRealPathFromUri(this.mContentResolver, imageRequest.getSourceUri());
    }
}

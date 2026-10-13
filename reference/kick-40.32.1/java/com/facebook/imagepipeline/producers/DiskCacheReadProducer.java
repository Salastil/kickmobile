package com.facebook.imagepipeline.producers;

import bolts.Continuation;
import bolts.Task;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.CacheDecisionReporter;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Supplier;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.core.DiskCachesStore;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public class DiskCacheReadProducer implements Producer<EncodedImage> {
    public static final String ENCODED_IMAGE_SIZE = "encodedImageSize";
    public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
    public static final String PRODUCER_NAME = "DiskCacheProducer";
    private final CacheKeyFactory mCacheKeyFactory;
    private final Supplier<DiskCachesStore> mDiskCachesStoreSupplier;
    private final Producer<EncodedImage> mInputProducer;

    public DiskCacheReadProducer(Supplier<DiskCachesStore> supplier, CacheKeyFactory cacheKeyFactory, Producer<EncodedImage> producer) {
        this.mDiskCachesStoreSupplier = supplier;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        ImageRequest imageRequest = producerContext.getImageRequest();
        if (!producerContext.getImageRequest().isCacheEnabled(16)) {
            maybeStartInputProducer(consumer, producerContext);
            return;
        }
        producerContext.getProducerListener().onProducerStart(producerContext, PRODUCER_NAME);
        CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, producerContext.getCallerContext());
        DiskCachesStore diskCachesStore = this.mDiskCachesStoreSupplier.get();
        BufferedDiskCache bufferedDiskCacheChooseDiskCacheForRequest = DiskCacheDecision.chooseDiskCacheForRequest(imageRequest, diskCachesStore.getSmallImageBufferedDiskCache(), diskCachesStore.getMainBufferedDiskCache(), diskCachesStore.getDynamicBufferedDiskCaches());
        if (bufferedDiskCacheChooseDiskCacheForRequest == null) {
            producerContext.getProducerListener().onProducerFinishWithFailure(producerContext, PRODUCER_NAME, new DiskCacheDecision.DiskCacheDecisionNoDiskCacheChosenException("Got no disk cache for CacheChoice: " + Integer.valueOf(imageRequest.getCacheChoice().ordinal()).toString()), null);
            maybeStartInputProducer(consumer, producerContext);
            return;
        }
        String strResolveDiskCacheId = DiskCacheDecision.resolveDiskCacheId(imageRequest);
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        bufferedDiskCacheChooseDiskCacheForRequest.get(encodedCacheKey, atomicBoolean).continueWith(onFinishDiskReads(consumer, producerContext, encodedCacheKey, diskCachesStore, strResolveDiskCacheId));
        subscribeTaskForRequestCancellation(atomicBoolean, producerContext);
    }

    public static boolean shouldSkipPartialEncodedImage(EncodedImage encodedImage, ImageRequest imageRequest) {
        if (imageRequest.getSkipEncodedPartialImagesInCachesNotInRequestRange()) {
            return !BytesRange.toMax(encodedImage.getSize() - 1).contains(imageRequest.getBytesRange());
        }
        return false;
    }

    private Continuation<EncodedImage, Void> onFinishDiskReads(final Consumer<EncodedImage> consumer, final ProducerContext producerContext, final CacheKey cacheKey, final DiskCachesStore diskCachesStore, @Nullable final String str) {
        final ProducerListener2 producerListener = producerContext.getProducerListener();
        return new Continuation<EncodedImage, Void>() { // from class: com.facebook.imagepipeline.producers.DiskCacheReadProducer.1
            @Override // bolts.Continuation
            @Nullable
            public Void then(Task<EncodedImage> task) throws Exception {
                String strMaybeConsumeReadDecision = DiskCacheReadProducer.maybeConsumeReadDecision(diskCachesStore, str, cacheKey);
                if (strMaybeConsumeReadDecision == null) {
                    strMaybeConsumeReadDecision = str;
                }
                if (strMaybeConsumeReadDecision != null) {
                    producerContext.putExtra("disk_cache_id", strMaybeConsumeReadDecision);
                }
                if (DiskCacheReadProducer.isTaskCancelled(task)) {
                    producerListener.onProducerFinishWithCancellation(producerContext, DiskCacheReadProducer.PRODUCER_NAME, null);
                    consumer.onCancellation();
                } else if (task.isFaulted()) {
                    producerListener.onProducerFinishWithFailure(producerContext, DiskCacheReadProducer.PRODUCER_NAME, task.getError(), null);
                    DiskCacheReadProducer.this.mInputProducer.produceResults(consumer, producerContext);
                } else {
                    EncodedImage result = task.getResult();
                    ImageRequest imageRequest = producerContext.getImageRequest();
                    if (result != null && !DiskCacheReadProducer.shouldSkipPartialEncodedImage(result, imageRequest)) {
                        ProducerListener2 producerListener2 = producerListener;
                        ProducerContext producerContext2 = producerContext;
                        producerListener2.onProducerFinishWithSuccess(producerContext2, DiskCacheReadProducer.PRODUCER_NAME, DiskCacheReadProducer.getExtraMap(producerListener2, producerContext2, true, result.getSize()));
                        producerListener.onUltimateProducerReached(producerContext, DiskCacheReadProducer.PRODUCER_NAME, true);
                        producerContext.putOriginExtra("disk");
                        String str2 = (String) result.getExtra("origin_sub");
                        if (str2 != null) {
                            producerContext.putExtra("origin_sub", str2);
                        }
                        producerContext.putExtra("encoded_size", Integer.valueOf(result.getSize()));
                        producerContext.putExtra("encoded_width", Integer.valueOf(result.getWidth()));
                        producerContext.putExtra("encoded_height", Integer.valueOf(result.getHeight()));
                        producerContext.putExtra("smart_query", result.getExtra("smart_query"));
                        consumer.onProgressUpdate(1.0f);
                        consumer.onNewResult(result, 1);
                        result.close();
                    } else {
                        ProducerListener2 producerListener3 = producerListener;
                        ProducerContext producerContext3 = producerContext;
                        producerListener3.onProducerFinishWithSuccess(producerContext3, DiskCacheReadProducer.PRODUCER_NAME, DiskCacheReadProducer.getExtraMap(producerListener3, producerContext3, false, result == null ? 0 : result.getSize()));
                        DiskCacheReadProducer.this.mInputProducer.produceResults(consumer, producerContext);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static String maybeConsumeReadDecision(DiskCachesStore diskCachesStore, @Nullable String str, CacheKey cacheKey) {
        if (str == null) {
            return null;
        }
        FileCache fileCache = diskCachesStore.getDynamicFileCaches().get(str);
        if (fileCache instanceof CacheDecisionReporter) {
            return ((CacheDecisionReporter) fileCache).consumeReadDecision(cacheKey);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isTaskCancelled(Task<?> task) {
        if (task.isCancelled()) {
            return true;
        }
        return task.isFaulted() && (task.getError() instanceof CancellationException);
    }

    private void maybeStartInputProducer(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        if (producerContext.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            producerContext.putOriginExtra("disk", "nil-result_read");
            consumer.onNewResult(null, 1);
        } else {
            this.mInputProducer.produceResults(consumer, producerContext);
        }
    }

    @Nullable
    static Map<String, String> getExtraMap(ProducerListener2 producerListener2, ProducerContext producerContext, boolean z, int i) {
        if (!producerListener2.requiresExtraMap(producerContext, PRODUCER_NAME)) {
            return null;
        }
        if (!z) {
            return ImmutableMap.of("cached_value_found", String.valueOf(z));
        }
        return ImmutableMap.of("cached_value_found", String.valueOf(z), "encodedImageSize", String.valueOf(i));
    }

    private void subscribeTaskForRequestCancellation(final AtomicBoolean atomicBoolean, ProducerContext producerContext) {
        producerContext.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.DiskCacheReadProducer.2
            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                atomicBoolean.set(true);
            }
        });
    }
}

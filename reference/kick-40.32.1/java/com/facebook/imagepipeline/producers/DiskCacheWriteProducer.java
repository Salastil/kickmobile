package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.core.DiskCachesStore;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DiskCacheWriteProducer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B+\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001e\u0010\u0011\u001a\u00020\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/facebook/imagepipeline/producers/DiskCacheWriteProducer;", "Lcom/facebook/imagepipeline/producers/Producer;", "Lcom/facebook/imagepipeline/image/EncodedImage;", "diskCachesStoreSupplier", "Lcom/facebook/common/internal/Supplier;", "Lcom/facebook/imagepipeline/core/DiskCachesStore;", "cacheKeyFactory", "Lcom/facebook/imagepipeline/cache/CacheKeyFactory;", "inputProducer", "<init>", "(Lcom/facebook/common/internal/Supplier;Lcom/facebook/imagepipeline/cache/CacheKeyFactory;Lcom/facebook/imagepipeline/producers/Producer;)V", "produceResults", "", "consumer", "Lcom/facebook/imagepipeline/producers/Consumer;", "producerContext", "Lcom/facebook/imagepipeline/producers/ProducerContext;", "maybeStartInputProducer", "consumerOfDiskCacheWriteProducer", "DiskCacheWriteConsumer", "Companion", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DiskCacheWriteProducer implements Producer<EncodedImage> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String PRODUCER_NAME = "DiskCacheWriteProducer";
    private final CacheKeyFactory cacheKeyFactory;
    private final Supplier<DiskCachesStore> diskCachesStoreSupplier;
    private final Producer<EncodedImage> inputProducer;

    public DiskCacheWriteProducer(Supplier<DiskCachesStore> diskCachesStoreSupplier, CacheKeyFactory cacheKeyFactory, Producer<EncodedImage> inputProducer) {
        Intrinsics.checkNotNullParameter(diskCachesStoreSupplier, "diskCachesStoreSupplier");
        Intrinsics.checkNotNullParameter(cacheKeyFactory, "cacheKeyFactory");
        Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
        this.diskCachesStoreSupplier = diskCachesStoreSupplier;
        this.cacheKeyFactory = cacheKeyFactory;
        this.inputProducer = inputProducer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        maybeStartInputProducer(consumer, producerContext);
    }

    private final void maybeStartInputProducer(Consumer<EncodedImage> consumerOfDiskCacheWriteProducer, ProducerContext producerContext) {
        if (producerContext.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            producerContext.putOriginExtra("disk", "nil-result_write");
            consumerOfDiskCacheWriteProducer.onNewResult(null, 1);
        } else {
            if (producerContext.getImageRequest().isCacheEnabled(32)) {
                consumerOfDiskCacheWriteProducer = new DiskCacheWriteConsumer(consumerOfDiskCacheWriteProducer, producerContext, this.diskCachesStoreSupplier, this.cacheKeyFactory);
            }
            this.inputProducer.produceResults(consumerOfDiskCacheWriteProducer, producerContext);
        }
    }

    /* JADX INFO: compiled from: DiskCacheWriteProducer.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B3\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/facebook/imagepipeline/producers/DiskCacheWriteProducer$DiskCacheWriteConsumer;", "Lcom/facebook/imagepipeline/producers/DelegatingConsumer;", "Lcom/facebook/imagepipeline/image/EncodedImage;", "consumer", "Lcom/facebook/imagepipeline/producers/Consumer;", "producerContext", "Lcom/facebook/imagepipeline/producers/ProducerContext;", "diskCachesStoreSupplier", "Lcom/facebook/common/internal/Supplier;", "Lcom/facebook/imagepipeline/core/DiskCachesStore;", "cacheKeyFactory", "Lcom/facebook/imagepipeline/cache/CacheKeyFactory;", "<init>", "(Lcom/facebook/imagepipeline/producers/Consumer;Lcom/facebook/imagepipeline/producers/ProducerContext;Lcom/facebook/common/internal/Supplier;Lcom/facebook/imagepipeline/cache/CacheKeyFactory;)V", "onNewResultImpl", "", "newResult", "status", "", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class DiskCacheWriteConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        private final CacheKeyFactory cacheKeyFactory;
        private final Supplier<DiskCachesStore> diskCachesStoreSupplier;
        private final ProducerContext producerContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DiskCacheWriteConsumer(Consumer<EncodedImage> consumer, ProducerContext producerContext, Supplier<DiskCachesStore> diskCachesStoreSupplier, CacheKeyFactory cacheKeyFactory) {
            super(consumer);
            Intrinsics.checkNotNullParameter(consumer, "consumer");
            Intrinsics.checkNotNullParameter(producerContext, "producerContext");
            Intrinsics.checkNotNullParameter(diskCachesStoreSupplier, "diskCachesStoreSupplier");
            Intrinsics.checkNotNullParameter(cacheKeyFactory, "cacheKeyFactory");
            this.producerContext = producerContext;
            this.diskCachesStoreSupplier = diskCachesStoreSupplier;
            this.cacheKeyFactory = cacheKeyFactory;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(EncodedImage newResult, int status) {
            this.producerContext.getProducerListener().onProducerStart(this.producerContext, DiskCacheWriteProducer.PRODUCER_NAME);
            if (BaseConsumer.INSTANCE.isNotLast(status) || newResult == null || BaseConsumer.INSTANCE.statusHasAnyFlag(status, 10) || newResult.getImageFormat() == ImageFormat.UNKNOWN) {
                this.producerContext.getProducerListener().onProducerFinishWithSuccess(this.producerContext, DiskCacheWriteProducer.PRODUCER_NAME, null);
                getConsumer().onNewResult(newResult, status);
                return;
            }
            ImageRequest imageRequest = this.producerContext.getImageRequest();
            CacheKey encodedCacheKey = this.cacheKeyFactory.getEncodedCacheKey(imageRequest, this.producerContext.getCallerContext());
            DiskCachesStore diskCachesStore = this.diskCachesStoreSupplier.get();
            Intrinsics.checkNotNullExpressionValue(diskCachesStore, "get(...)");
            DiskCachesStore diskCachesStore2 = diskCachesStore;
            BufferedDiskCache bufferedDiskCacheChooseDiskCacheForRequest = DiskCacheDecision.chooseDiskCacheForRequest(imageRequest, diskCachesStore2.getSmallImageBufferedDiskCache(), diskCachesStore2.getMainBufferedDiskCache(), diskCachesStore2.getDynamicBufferedDiskCaches());
            if (bufferedDiskCacheChooseDiskCacheForRequest == null) {
                this.producerContext.getProducerListener().onProducerFinishWithFailure(this.producerContext, DiskCacheWriteProducer.PRODUCER_NAME, new DiskCacheDecision.DiskCacheDecisionNoDiskCacheChosenException("Got no disk cache for CacheChoice: " + imageRequest.getCacheChoice().ordinal()), null);
                getConsumer().onNewResult(newResult, status);
                return;
            }
            String strResolveDiskCacheId = DiskCacheDecision.resolveDiskCacheId(imageRequest);
            if (strResolveDiskCacheId != null) {
                this.producerContext.putExtra("disk_cache_id", strResolveDiskCacheId);
            }
            bufferedDiskCacheChooseDiskCacheForRequest.put(encodedCacheKey, newResult);
            this.producerContext.getProducerListener().onProducerFinishWithSuccess(this.producerContext, DiskCacheWriteProducer.PRODUCER_NAME, null);
            getConsumer().onNewResult(newResult, status);
        }
    }

    /* JADX INFO: compiled from: DiskCacheWriteProducer.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/facebook/imagepipeline/producers/DiskCacheWriteProducer$Companion;", "", "<init>", "()V", "PRODUCER_NAME", "", "getPRODUCER_NAME$annotations", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getPRODUCER_NAME$annotations() {
        }

        private Companion() {
        }
    }
}

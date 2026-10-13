package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessorRunner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PostprocessorProducer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0004\u0013\u0014\u0015\u0016B-\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ$\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/facebook/imagepipeline/producers/PostprocessorProducer;", "Lcom/facebook/imagepipeline/producers/Producer;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "inputProducer", "mBitmapFactory", "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "executor", "Ljava/util/concurrent/Executor;", "<init>", "(Lcom/facebook/imagepipeline/producers/Producer;Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;Ljava/util/concurrent/Executor;)V", "mInputProducer", "mExecutor", "produceResults", "", "consumer", "Lcom/facebook/imagepipeline/producers/Consumer;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/facebook/imagepipeline/producers/ProducerContext;", "PostprocessorConsumer", "SingleUsePostprocessorConsumer", "RepeatedPostprocessorConsumer", "Companion", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PostprocessorProducer implements Producer<CloseableReference<CloseableImage>> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String NAME = "PostprocessorProducer";
    public static final String POSTPROCESSOR = "Postprocessor";
    private final PlatformBitmapFactory mBitmapFactory;
    private final Executor mExecutor;
    private final Producer<CloseableReference<CloseableImage>> mInputProducer;

    public PostprocessorProducer(Producer<CloseableReference<CloseableImage>> inputProducer, PlatformBitmapFactory mBitmapFactory, Executor executor) {
        Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
        Intrinsics.checkNotNullParameter(mBitmapFactory, "mBitmapFactory");
        this.mBitmapFactory = mBitmapFactory;
        Object objCheckNotNull = Preconditions.checkNotNull(inputProducer);
        Intrinsics.checkNotNullExpressionValue(objCheckNotNull, "checkNotNull(...)");
        this.mInputProducer = (Producer) objCheckNotNull;
        Object objCheckNotNull2 = Preconditions.checkNotNull(executor);
        Intrinsics.checkNotNullExpressionValue(objCheckNotNull2, "checkNotNull(...)");
        this.mExecutor = (Executor) objCheckNotNull2;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext context) {
        SingleUsePostprocessorConsumer singleUsePostprocessorConsumer;
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        Intrinsics.checkNotNullParameter(context, "context");
        ProducerListener2 producerListener = context.getProducerListener();
        Postprocessor postprocessor = context.getImageRequest().getPostprocessor();
        Preconditions.checkNotNull(postprocessor);
        Intrinsics.checkNotNull(postprocessor);
        PostprocessorConsumer postprocessorConsumer = new PostprocessorConsumer(this, consumer, producerListener, postprocessor, context);
        if (postprocessor instanceof RepeatedPostprocessor) {
            singleUsePostprocessorConsumer = new RepeatedPostprocessorConsumer(this, postprocessorConsumer, (RepeatedPostprocessor) postprocessor, context);
        } else {
            singleUsePostprocessorConsumer = new SingleUsePostprocessorConsumer(this, postprocessorConsumer);
        }
        this.mInputProducer.produceResults(singleUsePostprocessorConsumer, context);
    }

    /* JADX INFO: compiled from: PostprocessorProducer.kt */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0004\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B3\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ \u0010\u0017\u001a\u00020\u00182\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u0014H\u0014J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u0018H\u0014J\u001e\u0010\u001f\u001a\u00020\u00182\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u0014J\u0006\u0010!\u001a\u00020\u0018J\u0006\u0010\"\u001a\u00020\u0018J\u0006\u0010#\u001a\u00020\u000fJ\u001e\u0010$\u001a\u00020\u00182\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u0014J4\u0010%\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010'\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010&2\u0006\u0010(\u001a\u00020\u00072\b\u0010)\u001a\u0004\u0018\u00010\u000b2\b\u0010*\u001a\u0004\u0018\u00010\tJ\u0010\u0010+\u001a\u00020\u000f2\b\u0010,\u001a\u0004\u0018\u00010\u0003J\u0016\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010,\u001a\u00020\u0003J\u001e\u0010.\u001a\u00020\u00182\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u0014J\u0010\u00100\u001a\u00020\u00182\b\u00101\u001a\u0004\u0018\u00010\u001dJ\u0006\u00102\u001a\u00020\u0018J\u0006\u00103\u001a\u00020\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f8\u0006@BX\u0087\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00148\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer;", "Lcom/facebook/imagepipeline/producers/DelegatingConsumer;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "consumer", "Lcom/facebook/imagepipeline/producers/Consumer;", "mListener", "Lcom/facebook/imagepipeline/producers/ProducerListener2;", "mPostprocessor", "Lcom/facebook/imagepipeline/request/Postprocessor;", "mProducerContext", "Lcom/facebook/imagepipeline/producers/ProducerContext;", "<init>", "(Lcom/facebook/imagepipeline/producers/PostprocessorProducer;Lcom/facebook/imagepipeline/producers/Consumer;Lcom/facebook/imagepipeline/producers/ProducerListener2;Lcom/facebook/imagepipeline/request/Postprocessor;Lcom/facebook/imagepipeline/producers/ProducerContext;)V", "value", "", "isClosed", "()Z", "mSourceImageRef", "mStatus", "", "mIsDirty", "mIsPostProcessingRunning", "onNewResultImpl", "", "newResult", "status", "onFailureImpl", "t", "", "onCancellationImpl", "updateSourceImageRef", "sourceImageRef", "submitPostprocessing", "clearRunningAndStartIfDirty", "setRunningIfDirtyAndNotRunning", "doPostprocessing", "getExtraMap", "", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "producerContext", "postprocessor", "shouldPostprocess", "sourceImage", "postprocessInternal", "maybeNotifyOnNewResult", "newRef", "maybeNotifyOnFailure", RumFeature.EVENT_THROWABLE_PROPERTY, "maybeNotifyOnCancellation", "close", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class PostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        private boolean isClosed;
        private boolean mIsDirty;
        private boolean mIsPostProcessingRunning;
        private final ProducerListener2 mListener;
        private final Postprocessor mPostprocessor;
        private final ProducerContext mProducerContext;
        private CloseableReference<CloseableImage> mSourceImageRef;
        private int mStatus;
        final /* synthetic */ PostprocessorProducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PostprocessorConsumer(PostprocessorProducer postprocessorProducer, Consumer<CloseableReference<CloseableImage>> consumer, ProducerListener2 mListener, Postprocessor mPostprocessor, ProducerContext mProducerContext) {
            super(consumer);
            Intrinsics.checkNotNullParameter(consumer, "consumer");
            Intrinsics.checkNotNullParameter(mListener, "mListener");
            Intrinsics.checkNotNullParameter(mPostprocessor, "mPostprocessor");
            Intrinsics.checkNotNullParameter(mProducerContext, "mProducerContext");
            this.this$0 = postprocessorProducer;
            this.mListener = mListener;
            this.mPostprocessor = mPostprocessor;
            this.mProducerContext = mProducerContext;
            mProducerContext.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.PostprocessorProducer.PostprocessorConsumer.1
                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    PostprocessorConsumer.this.maybeNotifyOnCancellation();
                }
            });
        }

        public final synchronized boolean isClosed() {
            return this.isClosed;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(CloseableReference<CloseableImage> newResult, int status) {
            if (!CloseableReference.isValid(newResult)) {
                if (BaseConsumer.INSTANCE.isLast(status)) {
                    maybeNotifyOnNewResult(null, status);
                    return;
                }
                return;
            }
            updateSourceImageRef(newResult, status);
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        protected void onFailureImpl(Throwable t) {
            Intrinsics.checkNotNullParameter(t, "t");
            maybeNotifyOnFailure(t);
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        protected void onCancellationImpl() {
            maybeNotifyOnCancellation();
        }

        public final void updateSourceImageRef(CloseableReference<CloseableImage> sourceImageRef, int status) {
            synchronized (this) {
                if (this.isClosed) {
                    return;
                }
                CloseableReference<CloseableImage> closeableReference = this.mSourceImageRef;
                this.mSourceImageRef = CloseableReference.cloneOrNull(sourceImageRef);
                this.mStatus = status;
                this.mIsDirty = true;
                boolean runningIfDirtyAndNotRunning = setRunningIfDirtyAndNotRunning();
                Unit unit = Unit.INSTANCE;
                CloseableReference.closeSafely(closeableReference);
                if (runningIfDirtyAndNotRunning) {
                    submitPostprocessing();
                }
            }
        }

        public final void submitPostprocessing() {
            this.this$0.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.PostprocessorProducer$PostprocessorConsumer$submitPostprocessing$1
                @Override // java.lang.Runnable
                public void run() {
                    CloseableReference<CloseableImage> closeableReference;
                    int i;
                    PostprocessorProducer.PostprocessorConsumer postprocessorConsumer = this.this$0;
                    synchronized (postprocessorConsumer) {
                        closeableReference = postprocessorConsumer.mSourceImageRef;
                        i = postprocessorConsumer.mStatus;
                        postprocessorConsumer.mSourceImageRef = null;
                        postprocessorConsumer.mIsDirty = false;
                        Unit unit = Unit.INSTANCE;
                    }
                    if (CloseableReference.isValid(closeableReference)) {
                        try {
                            this.this$0.doPostprocessing(closeableReference, i);
                            CloseableReference.closeSafely(closeableReference);
                        } catch (Throwable th) {
                            CloseableReference.closeSafely(closeableReference);
                            throw th;
                        }
                    }
                    this.this$0.clearRunningAndStartIfDirty();
                }
            });
        }

        public final void clearRunningAndStartIfDirty() {
            boolean runningIfDirtyAndNotRunning;
            synchronized (this) {
                this.mIsPostProcessingRunning = false;
                runningIfDirtyAndNotRunning = setRunningIfDirtyAndNotRunning();
                Unit unit = Unit.INSTANCE;
            }
            if (runningIfDirtyAndNotRunning) {
                submitPostprocessing();
            }
        }

        public final synchronized boolean setRunningIfDirtyAndNotRunning() {
            if (this.isClosed || !this.mIsDirty || this.mIsPostProcessingRunning || !CloseableReference.isValid(this.mSourceImageRef)) {
                return false;
            }
            this.mIsPostProcessingRunning = true;
            return true;
        }

        public final void doPostprocessing(CloseableReference<CloseableImage> sourceImageRef, int status) {
            Preconditions.checkArgument(Boolean.valueOf(CloseableReference.isValid(sourceImageRef)));
            Intrinsics.checkNotNull(sourceImageRef);
            if (!shouldPostprocess(sourceImageRef.get())) {
                maybeNotifyOnNewResult(sourceImageRef, status);
                return;
            }
            this.mListener.onProducerStart(this.mProducerContext, PostprocessorProducer.NAME);
            try {
                try {
                    CloseableImage closeableImage = sourceImageRef.get();
                    Intrinsics.checkNotNullExpressionValue(closeableImage, "get(...)");
                    CloseableReference<CloseableImage> closeableReferencePostprocessInternal = postprocessInternal(closeableImage);
                    ProducerListener2 producerListener2 = this.mListener;
                    ProducerContext producerContext = this.mProducerContext;
                    producerListener2.onProducerFinishWithSuccess(producerContext, PostprocessorProducer.NAME, getExtraMap(producerListener2, producerContext, this.mPostprocessor));
                    maybeNotifyOnNewResult(closeableReferencePostprocessInternal, status);
                    CloseableReference.closeSafely(closeableReferencePostprocessInternal);
                } catch (Exception e) {
                    ProducerListener2 producerListener3 = this.mListener;
                    ProducerContext producerContext2 = this.mProducerContext;
                    producerListener3.onProducerFinishWithFailure(producerContext2, PostprocessorProducer.NAME, e, getExtraMap(producerListener3, producerContext2, this.mPostprocessor));
                    maybeNotifyOnFailure(e);
                    CloseableReference.closeSafely((CloseableReference<?>) null);
                }
            } catch (Throwable th) {
                CloseableReference.closeSafely((CloseableReference<?>) null);
                throw th;
            }
        }

        public final Map<String, String> getExtraMap(ProducerListener2 listener, ProducerContext producerContext, Postprocessor postprocessor) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            if (!listener.requiresExtraMap(producerContext, PostprocessorProducer.NAME)) {
                return null;
            }
            Intrinsics.checkNotNull(postprocessor);
            return ImmutableMap.of(PostprocessorProducer.POSTPROCESSOR, postprocessor.getName());
        }

        public final boolean shouldPostprocess(CloseableImage sourceImage) {
            return sourceImage instanceof CloseableStaticBitmap;
        }

        public final CloseableReference<CloseableImage> postprocessInternal(CloseableImage sourceImage) {
            Intrinsics.checkNotNullParameter(sourceImage, "sourceImage");
            CloseableStaticBitmap closeableStaticBitmap = (CloseableStaticBitmap) sourceImage;
            Bitmap underlyingBitmap = closeableStaticBitmap.getUnderlyingBitmap();
            if (underlyingBitmap != null) {
                CloseableReference<Bitmap> closeableReferenceProcess = this.mPostprocessor.process(underlyingBitmap, this.this$0.mBitmapFactory);
                Intrinsics.checkNotNullExpressionValue(closeableReferenceProcess, "process(...)");
                try {
                    CloseableStaticBitmap closeableStaticBitmapOf = CloseableStaticBitmap.of(closeableReferenceProcess, sourceImage.getQualityInfo(), closeableStaticBitmap.getRotationAngle(), closeableStaticBitmap.getExifOrientation());
                    Intrinsics.checkNotNullExpressionValue(closeableStaticBitmapOf, "of(...)");
                    closeableStaticBitmapOf.putExtras(closeableStaticBitmap.getExtras());
                    return CloseableReference.of(closeableStaticBitmapOf);
                } finally {
                    CloseableReference.closeSafely(closeableReferenceProcess);
                }
            }
            throw new IllegalStateException("Underlying bitmap is null (image may be closed)".toString());
        }

        public final void maybeNotifyOnNewResult(CloseableReference<CloseableImage> newRef, int status) {
            boolean zIsLast = BaseConsumer.INSTANCE.isLast(status);
            if ((zIsLast || this.isClosed) && !(zIsLast && close())) {
                return;
            }
            getConsumer().onNewResult(newRef, status);
        }

        public final void maybeNotifyOnFailure(Throwable throwable) {
            if (close()) {
                getConsumer().onFailure(throwable);
            }
        }

        public final void maybeNotifyOnCancellation() {
            if (close()) {
                getConsumer().onCancellation();
            }
        }

        public final boolean close() {
            synchronized (this) {
                if (this.isClosed) {
                    return false;
                }
                CloseableReference<CloseableImage> closeableReference = this.mSourceImageRef;
                this.mSourceImageRef = null;
                this.isClosed = true;
                Unit unit = Unit.INSTANCE;
                CloseableReference.closeSafely(closeableReference);
                return true;
            }
        }
    }

    /* JADX INFO: compiled from: PostprocessorProducer.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0013\u0012\n\u0010\u0004\u001a\u00060\u0005R\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ \u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\rH\u0014¨\u0006\u000e"}, d2 = {"Lcom/facebook/imagepipeline/producers/PostprocessorProducer$SingleUsePostprocessorConsumer;", "Lcom/facebook/imagepipeline/producers/DelegatingConsumer;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "postprocessorConsumer", "Lcom/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer;", "Lcom/facebook/imagepipeline/producers/PostprocessorProducer;", "<init>", "(Lcom/facebook/imagepipeline/producers/PostprocessorProducer;Lcom/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer;)V", "onNewResultImpl", "", "newResult", "status", "", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class SingleUsePostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        final /* synthetic */ PostprocessorProducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SingleUsePostprocessorConsumer(PostprocessorProducer postprocessorProducer, PostprocessorConsumer postprocessorConsumer) {
            super(postprocessorConsumer);
            Intrinsics.checkNotNullParameter(postprocessorConsumer, "postprocessorConsumer");
            this.this$0 = postprocessorProducer;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(CloseableReference<CloseableImage> newResult, int status) {
            if (BaseConsumer.INSTANCE.isNotLast(status)) {
                return;
            }
            getConsumer().onNewResult(newResult, status);
        }
    }

    /* JADX INFO: compiled from: PostprocessorProducer.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u00020\u0004B#\u0012\n\u0010\u0005\u001a\u00060\u0006R\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0012H\u0014J\b\u0010\u001a\u001a\u00020\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0003J\u0018\u0010\u001c\u001a\u00020\u00122\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J\b\u0010\u001e\u001a\u00020\u000fH\u0002R\u0012\u0010\u000e\u001a\u00020\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/facebook/imagepipeline/producers/PostprocessorProducer$RepeatedPostprocessorConsumer;", "Lcom/facebook/imagepipeline/producers/DelegatingConsumer;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "Lcom/facebook/imagepipeline/request/RepeatedPostprocessorRunner;", "postprocessorConsumer", "Lcom/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer;", "Lcom/facebook/imagepipeline/producers/PostprocessorProducer;", "repeatedPostprocessor", "Lcom/facebook/imagepipeline/request/RepeatedPostprocessor;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/facebook/imagepipeline/producers/ProducerContext;", "<init>", "(Lcom/facebook/imagepipeline/producers/PostprocessorProducer;Lcom/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer;Lcom/facebook/imagepipeline/request/RepeatedPostprocessor;Lcom/facebook/imagepipeline/producers/ProducerContext;)V", "mIsClosed", "", "mSourceImageRef", "onNewResultImpl", "", "newResult", "status", "", "onFailureImpl", RumFeature.EVENT_THROWABLE_PROPERTY, "", "onCancellationImpl", "update", "updateInternal", "setSourceImageRef", "sourceImageRef", "close", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class RepeatedPostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> implements RepeatedPostprocessorRunner {
        private boolean mIsClosed;
        private CloseableReference<CloseableImage> mSourceImageRef;
        final /* synthetic */ PostprocessorProducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RepeatedPostprocessorConsumer(PostprocessorProducer postprocessorProducer, PostprocessorConsumer postprocessorConsumer, RepeatedPostprocessor repeatedPostprocessor, ProducerContext context) {
            super(postprocessorConsumer);
            Intrinsics.checkNotNullParameter(postprocessorConsumer, "postprocessorConsumer");
            Intrinsics.checkNotNullParameter(repeatedPostprocessor, "repeatedPostprocessor");
            Intrinsics.checkNotNullParameter(context, "context");
            this.this$0 = postprocessorProducer;
            repeatedPostprocessor.setCallback(this);
            context.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.PostprocessorProducer.RepeatedPostprocessorConsumer.1
                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    if (RepeatedPostprocessorConsumer.this.close()) {
                        RepeatedPostprocessorConsumer.this.getConsumer().onCancellation();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(CloseableReference<CloseableImage> newResult, int status) {
            if (BaseConsumer.INSTANCE.isNotLast(status)) {
                return;
            }
            setSourceImageRef(newResult);
            updateInternal();
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        protected void onFailureImpl(Throwable throwable) {
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            if (close()) {
                getConsumer().onFailure(throwable);
            }
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        protected void onCancellationImpl() {
            if (close()) {
                getConsumer().onCancellation();
            }
        }

        @Override // com.facebook.imagepipeline.request.RepeatedPostprocessorRunner
        public synchronized void update() {
            updateInternal();
        }

        private final void updateInternal() {
            synchronized (this) {
                if (this.mIsClosed) {
                    return;
                }
                CloseableReference<CloseableImage> closeableReferenceCloneOrNull = CloseableReference.cloneOrNull(this.mSourceImageRef);
                Unit unit = Unit.INSTANCE;
                try {
                    getConsumer().onNewResult(closeableReferenceCloneOrNull, 0);
                } finally {
                    CloseableReference.closeSafely(closeableReferenceCloneOrNull);
                }
            }
        }

        private final void setSourceImageRef(CloseableReference<CloseableImage> sourceImageRef) {
            synchronized (this) {
                if (this.mIsClosed) {
                    return;
                }
                CloseableReference<CloseableImage> closeableReference = this.mSourceImageRef;
                this.mSourceImageRef = CloseableReference.cloneOrNull(sourceImageRef);
                Unit unit = Unit.INSTANCE;
                CloseableReference.closeSafely(closeableReference);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean close() {
            synchronized (this) {
                if (this.mIsClosed) {
                    return false;
                }
                CloseableReference<CloseableImage> closeableReference = this.mSourceImageRef;
                this.mSourceImageRef = null;
                this.mIsClosed = true;
                Unit unit = Unit.INSTANCE;
                CloseableReference.closeSafely(closeableReference);
                return true;
            }
        }
    }

    /* JADX INFO: compiled from: PostprocessorProducer.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003¨\u0006\b"}, d2 = {"Lcom/facebook/imagepipeline/producers/PostprocessorProducer$Companion;", "", "<init>", "()V", "NAME", "", "POSTPROCESSOR", "getPOSTPROCESSOR$annotations", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getPOSTPROCESSOR$annotations() {
        }

        private Companion() {
        }
    }
}

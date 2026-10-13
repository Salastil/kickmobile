package com.facebook.imagepipeline.core;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Build;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.media.MediaUtils;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.AddImageTransformMetaDataProducer;
import com.facebook.imagepipeline.producers.BitmapPrepareProducer;
import com.facebook.imagepipeline.producers.CustomProducerSequenceFactory;
import com.facebook.imagepipeline.producers.DiskCacheWriteProducer;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.PostprocessedBitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.RemoveImageTransformMetaDataProducer;
import com.facebook.imagepipeline.producers.ResizeAndRotateProducer;
import com.facebook.imagepipeline.producers.SwallowResultProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.producers.ThumbnailProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProducerSequenceFactory.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u0088\u00012\u00020\u0001:\u0002\u0088\u0001B£\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\t\u0012\u0006\u0010\u001c\u001a\u00020\t\u0012\u0006\u0010\u001d\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050#0\"2\u0006\u00106\u001a\u000207J\u0016\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0\"2\u0006\u00106\u001a\u000207J\u001a\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"2\u0006\u00106\u001a\u000207J\u0016\u0010F\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0\"2\u0006\u00106\u001a\u000207J\u001c\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"2\u0006\u00106\u001a\u000207H\u0002J\u0018\u0010U\u001a\b\u0012\u0004\u0012\u00020L0\"2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007J\"\u0010w\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"2\f\u0010x\u001a\b\u0012\u0004\u0012\u00020L0\"H\u0002J;\u0010w\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"2\f\u0010x\u001a\b\u0012\u0004\u0012\u00020L0\"2\u0012\u0010y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0{0zH\u0002¢\u0006\u0002\u0010|J \u0010}\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"2\f\u0010x\u001a\b\u0012\u0004\u0012\u00020L0\"J\u001c\u0010~\u001a\b\u0012\u0004\u0012\u00020L0\"2\f\u0010x\u001a\b\u0012\u0004\u0012\u00020L0\"H\u0002J\u001c\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020L0\"2\f\u0010x\u001a\b\u0012\u0004\u0012\u00020L0\"H\u0002J)\u0010\u0080\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"2\u0012\u0010x\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"H\u0002J6\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020L0\"2\f\u0010x\u001a\b\u0012\u0004\u0012\u00020L0\"2\u0012\u0010y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0{0zH\u0002¢\u0006\u0002\u0010|J)\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020L0\"2\u0012\u0010y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0{0zH\u0002¢\u0006\u0003\u0010\u0083\u0001J)\u0010\u0084\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"2\u0012\u0010x\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"H\u0002J%\u0010\u0085\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0\"2\u0012\u0010x\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"H\u0002J)\u0010\u0086\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"2\u0012\u0010x\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"H\u0002J)\u0010\u0087\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"2\u0012\u0010x\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000RH\u0010 \u001a&\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"0!8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*RD\u0010+\u001a\"\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010,0\"0!8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b-\u0010&\u001a\u0004\b.\u0010(\"\u0004\b/\u0010*RH\u00100\u001a&\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"0!8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b1\u0010&\u001a\u0004\b2\u0010(\"\u0004\b3\u0010*R'\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050#0\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b9\u0010:R-\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050#0\"8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b@\u0010<\u0012\u0004\b>\u0010&\u001a\u0004\b?\u0010:R'\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050#0\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bC\u0010<\u001a\u0004\bB\u0010:R'\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010<\u001a\u0004\bI\u0010:R!\u0010K\u001a\b\u0012\u0004\u0012\u00020L0\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bN\u0010<\u001a\u0004\bM\u0010:R#\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010<\u001a\u0004\bP\u0010:R!\u0010R\u001a\b\u0012\u0004\u0012\u00020L0\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bT\u0010<\u001a\u0004\bS\u0010:R#\u0010V\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bX\u0010<\u001a\u0004\bW\u0010:R!\u0010Y\u001a\b\u0012\u0004\u0012\u00020L0\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b[\u0010<\u001a\u0004\bZ\u0010:R!\u0010\\\u001a\b\u0012\u0004\u0012\u00020L0\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b^\u0010<\u001a\u0004\b]\u0010:R'\u0010_\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\ba\u0010<\u001a\u0004\b`\u0010:R'\u0010b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bd\u0010<\u001a\u0004\bc\u0010:R'\u0010e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bg\u0010<\u001a\u0004\bf\u0010:R'\u0010h\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"8GX\u0086\u0084\u0002¢\u0006\f\n\u0004\bj\u0010<\u001a\u0004\bi\u0010:R'\u0010k\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bm\u0010<\u001a\u0004\bl\u0010:R'\u0010n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bp\u0010<\u001a\u0004\bo\u0010:R'\u0010q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bs\u0010<\u001a\u0004\br\u0010:R'\u0010t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bv\u0010<\u001a\u0004\bu\u0010:¨\u0006\u0089\u0001"}, d2 = {"Lcom/facebook/imagepipeline/core/ProducerSequenceFactory;", "", "contentResolver", "Landroid/content/ContentResolver;", "producerFactory", "Lcom/facebook/imagepipeline/core/ProducerFactory;", "networkFetcher", "Lcom/facebook/imagepipeline/producers/NetworkFetcher;", "resizeAndRotateEnabledForNetwork", "", "threadHandoffProducerQueue", "Lcom/facebook/imagepipeline/producers/ThreadHandoffProducerQueue;", "downsampleMode", "Lcom/facebook/imagepipeline/core/DownsampleMode;", "useBitmapPrepareToDraw", "partialImageCachingEnabled", "diskCacheEnabled", "imageTranscoderFactory", "Lcom/facebook/imagepipeline/transcoder/ImageTranscoderFactory;", "isEncodedMemoryCacheProbingEnabled", "isDiskCacheProbingEnabled", "allowDelay", "customProducerSequenceFactories", "", "Lcom/facebook/imagepipeline/producers/CustomProducerSequenceFactory;", "localImageThrottlingMaxSimultaneousRequests", "", "loadThumbnailFromContentResolverFirst", "loadThumbnailFromContentResolverForContentUriOnly", "usePostprocessorDuringDecodedPrefetch", "<init>", "(Landroid/content/ContentResolver;Lcom/facebook/imagepipeline/core/ProducerFactory;Lcom/facebook/imagepipeline/producers/NetworkFetcher;ZLcom/facebook/imagepipeline/producers/ThreadHandoffProducerQueue;Lcom/facebook/imagepipeline/core/DownsampleMode;ZZZLcom/facebook/imagepipeline/transcoder/ImageTranscoderFactory;ZZZLjava/util/Set;JZZZ)V", "postprocessorSequences", "", "Lcom/facebook/imagepipeline/producers/Producer;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "getPostprocessorSequences$annotations", "()V", "getPostprocessorSequences", "()Ljava/util/Map;", "setPostprocessorSequences", "(Ljava/util/Map;)V", "closeableImagePrefetchSequences", "Ljava/lang/Void;", "getCloseableImagePrefetchSequences$annotations", "getCloseableImagePrefetchSequences", "setCloseableImagePrefetchSequences", "bitmapPrepareSequences", "getBitmapPrepareSequences$annotations", "getBitmapPrepareSequences", "setBitmapPrepareSequences", "getEncodedImageProducerSequence", "Lcom/facebook/common/memory/PooledByteBuffer;", "imageRequest", "Lcom/facebook/imagepipeline/request/ImageRequest;", "networkFetchEncodedImageProducerSequence", "getNetworkFetchEncodedImageProducerSequence", "()Lcom/facebook/imagepipeline/producers/Producer;", "networkFetchEncodedImageProducerSequence$delegate", "Lkotlin/Lazy;", "localFileFetchEncodedImageProducerSequence", "getLocalFileFetchEncodedImageProducerSequence$annotations", "getLocalFileFetchEncodedImageProducerSequence", "localFileFetchEncodedImageProducerSequence$delegate", "localContentUriFetchEncodedImageProducerSequence", "getLocalContentUriFetchEncodedImageProducerSequence", "localContentUriFetchEncodedImageProducerSequence$delegate", "getEncodedImagePrefetchProducerSequence", "getDecodedImageProducerSequence", "getDecodedImagePrefetchProducerSequence", "getBasicDecodedImageSequence", "networkFetchSequence", "getNetworkFetchSequence", "networkFetchSequence$delegate", "backgroundNetworkFetchToEncodedMemorySequence", "Lcom/facebook/imagepipeline/image/EncodedImage;", "getBackgroundNetworkFetchToEncodedMemorySequence", "backgroundNetworkFetchToEncodedMemorySequence$delegate", "networkFetchToEncodedMemoryPrefetchSequence", "getNetworkFetchToEncodedMemoryPrefetchSequence", "networkFetchToEncodedMemoryPrefetchSequence$delegate", "commonNetworkFetchToEncodedMemorySequence", "getCommonNetworkFetchToEncodedMemorySequence", "commonNetworkFetchToEncodedMemorySequence$delegate", "newCommonNetworkFetchToEncodedMemorySequence", "localFileFetchToEncodedMemoryPrefetchSequence", "getLocalFileFetchToEncodedMemoryPrefetchSequence", "localFileFetchToEncodedMemoryPrefetchSequence$delegate", "backgroundLocalFileFetchToEncodeMemorySequence", "getBackgroundLocalFileFetchToEncodeMemorySequence", "backgroundLocalFileFetchToEncodeMemorySequence$delegate", "backgroundLocalContentUriFetchToEncodeMemorySequence", "getBackgroundLocalContentUriFetchToEncodeMemorySequence", "backgroundLocalContentUriFetchToEncodeMemorySequence$delegate", "localImageFileFetchSequence", "getLocalImageFileFetchSequence", "localImageFileFetchSequence$delegate", "localVideoFileFetchSequence", "getLocalVideoFileFetchSequence", "localVideoFileFetchSequence$delegate", "localContentUriFetchSequence", "getLocalContentUriFetchSequence", "localContentUriFetchSequence$delegate", "localThumbnailBitmapSdk29FetchSequence", "getLocalThumbnailBitmapSdk29FetchSequence", "localThumbnailBitmapSdk29FetchSequence$delegate", "qualifiedResourceFetchSequence", "getQualifiedResourceFetchSequence", "qualifiedResourceFetchSequence$delegate", "localResourceFetchSequence", "getLocalResourceFetchSequence", "localResourceFetchSequence$delegate", "localAssetFetchSequence", "getLocalAssetFetchSequence", "localAssetFetchSequence$delegate", "dataFetchSequence", "getDataFetchSequence", "dataFetchSequence$delegate", "newBitmapCacheGetToLocalTransformSequence", "inputProducer", "thumbnailProducers", "", "Lcom/facebook/imagepipeline/producers/ThumbnailProducer;", "(Lcom/facebook/imagepipeline/producers/Producer;[Lcom/facebook/imagepipeline/producers/ThumbnailProducer;)Lcom/facebook/imagepipeline/producers/Producer;", "newBitmapCacheGetToDecodeSequence", "newEncodedCacheMultiplexToTranscodeSequence", "newDiskCacheSequence", "newBitmapCacheGetToBitmapCacheSequence", "newLocalTransformationsSequence", "newLocalThumbnailProducer", "([Lcom/facebook/imagepipeline/producers/ThumbnailProducer;)Lcom/facebook/imagepipeline/producers/Producer;", "getPostprocessorSequence", "getDecodedImagePrefetchSequence", "getBitmapPrepareSequence", "getDelaySequence", "Companion", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ProducerSequenceFactory {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean allowDelay;

    /* JADX INFO: renamed from: backgroundLocalContentUriFetchToEncodeMemorySequence$delegate, reason: from kotlin metadata */
    private final Lazy backgroundLocalContentUriFetchToEncodeMemorySequence;

    /* JADX INFO: renamed from: backgroundLocalFileFetchToEncodeMemorySequence$delegate, reason: from kotlin metadata */
    private final Lazy backgroundLocalFileFetchToEncodeMemorySequence;

    /* JADX INFO: renamed from: backgroundNetworkFetchToEncodedMemorySequence$delegate, reason: from kotlin metadata */
    private final Lazy backgroundNetworkFetchToEncodedMemorySequence;
    private Map<Producer<CloseableReference<CloseableImage>>, Producer<CloseableReference<CloseableImage>>> bitmapPrepareSequences;
    private Map<Producer<CloseableReference<CloseableImage>>, Producer<Void>> closeableImagePrefetchSequences;

    /* JADX INFO: renamed from: commonNetworkFetchToEncodedMemorySequence$delegate, reason: from kotlin metadata */
    private final Lazy commonNetworkFetchToEncodedMemorySequence;
    private final ContentResolver contentResolver;
    private final Set<CustomProducerSequenceFactory> customProducerSequenceFactories;

    /* JADX INFO: renamed from: dataFetchSequence$delegate, reason: from kotlin metadata */
    private final Lazy dataFetchSequence;
    private final boolean diskCacheEnabled;
    private final DownsampleMode downsampleMode;
    private final ImageTranscoderFactory imageTranscoderFactory;
    private final boolean isDiskCacheProbingEnabled;
    private final boolean isEncodedMemoryCacheProbingEnabled;
    private final boolean loadThumbnailFromContentResolverFirst;
    private final boolean loadThumbnailFromContentResolverForContentUriOnly;

    /* JADX INFO: renamed from: localAssetFetchSequence$delegate, reason: from kotlin metadata */
    private final Lazy localAssetFetchSequence;

    /* JADX INFO: renamed from: localContentUriFetchEncodedImageProducerSequence$delegate, reason: from kotlin metadata */
    private final Lazy localContentUriFetchEncodedImageProducerSequence;

    /* JADX INFO: renamed from: localContentUriFetchSequence$delegate, reason: from kotlin metadata */
    private final Lazy localContentUriFetchSequence;

    /* JADX INFO: renamed from: localFileFetchEncodedImageProducerSequence$delegate, reason: from kotlin metadata */
    private final Lazy localFileFetchEncodedImageProducerSequence;

    /* JADX INFO: renamed from: localFileFetchToEncodedMemoryPrefetchSequence$delegate, reason: from kotlin metadata */
    private final Lazy localFileFetchToEncodedMemoryPrefetchSequence;

    /* JADX INFO: renamed from: localImageFileFetchSequence$delegate, reason: from kotlin metadata */
    private final Lazy localImageFileFetchSequence;
    private final long localImageThrottlingMaxSimultaneousRequests;

    /* JADX INFO: renamed from: localResourceFetchSequence$delegate, reason: from kotlin metadata */
    private final Lazy localResourceFetchSequence;

    /* JADX INFO: renamed from: localThumbnailBitmapSdk29FetchSequence$delegate, reason: from kotlin metadata */
    private final Lazy localThumbnailBitmapSdk29FetchSequence;

    /* JADX INFO: renamed from: localVideoFileFetchSequence$delegate, reason: from kotlin metadata */
    private final Lazy localVideoFileFetchSequence;

    /* JADX INFO: renamed from: networkFetchEncodedImageProducerSequence$delegate, reason: from kotlin metadata */
    private final Lazy networkFetchEncodedImageProducerSequence;

    /* JADX INFO: renamed from: networkFetchSequence$delegate, reason: from kotlin metadata */
    private final Lazy networkFetchSequence;

    /* JADX INFO: renamed from: networkFetchToEncodedMemoryPrefetchSequence$delegate, reason: from kotlin metadata */
    private final Lazy networkFetchToEncodedMemoryPrefetchSequence;
    private final NetworkFetcher<?> networkFetcher;
    private final boolean partialImageCachingEnabled;
    private Map<Producer<CloseableReference<CloseableImage>>, Producer<CloseableReference<CloseableImage>>> postprocessorSequences;
    private final ProducerFactory producerFactory;

    /* JADX INFO: renamed from: qualifiedResourceFetchSequence$delegate, reason: from kotlin metadata */
    private final Lazy qualifiedResourceFetchSequence;
    private final boolean resizeAndRotateEnabledForNetwork;
    private final ThreadHandoffProducerQueue threadHandoffProducerQueue;
    private final boolean useBitmapPrepareToDraw;
    private final boolean usePostprocessorDuringDecodedPrefetch;

    public static /* synthetic */ void getBitmapPrepareSequences$annotations() {
    }

    public static /* synthetic */ void getCloseableImagePrefetchSequences$annotations() {
    }

    public static /* synthetic */ void getLocalFileFetchEncodedImageProducerSequence$annotations() {
    }

    public static /* synthetic */ void getPostprocessorSequences$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProducerSequenceFactory(ContentResolver contentResolver, ProducerFactory producerFactory, NetworkFetcher<?> networkFetcher, boolean z, ThreadHandoffProducerQueue threadHandoffProducerQueue, DownsampleMode downsampleMode, boolean z2, boolean z3, boolean z4, ImageTranscoderFactory imageTranscoderFactory, boolean z5, boolean z6, boolean z7, Set<? extends CustomProducerSequenceFactory> set, long j, boolean z8, boolean z9, boolean z10) {
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics.checkNotNullParameter(producerFactory, "producerFactory");
        Intrinsics.checkNotNullParameter(networkFetcher, "networkFetcher");
        Intrinsics.checkNotNullParameter(threadHandoffProducerQueue, "threadHandoffProducerQueue");
        Intrinsics.checkNotNullParameter(downsampleMode, "downsampleMode");
        Intrinsics.checkNotNullParameter(imageTranscoderFactory, "imageTranscoderFactory");
        this.contentResolver = contentResolver;
        this.producerFactory = producerFactory;
        this.networkFetcher = networkFetcher;
        this.resizeAndRotateEnabledForNetwork = z;
        this.threadHandoffProducerQueue = threadHandoffProducerQueue;
        this.downsampleMode = downsampleMode;
        this.useBitmapPrepareToDraw = z2;
        this.partialImageCachingEnabled = z3;
        this.diskCacheEnabled = z4;
        this.imageTranscoderFactory = imageTranscoderFactory;
        this.isEncodedMemoryCacheProbingEnabled = z5;
        this.isDiskCacheProbingEnabled = z6;
        this.allowDelay = z7;
        this.customProducerSequenceFactories = set;
        this.localImageThrottlingMaxSimultaneousRequests = j;
        this.loadThumbnailFromContentResolverFirst = z8;
        this.loadThumbnailFromContentResolverForContentUriOnly = z9;
        this.usePostprocessorDuringDecodedPrefetch = z10;
        this.postprocessorSequences = new LinkedHashMap();
        this.closeableImagePrefetchSequences = new LinkedHashMap();
        this.bitmapPrepareSequences = new LinkedHashMap();
        this.networkFetchEncodedImageProducerSequence = LazyKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProducerSequenceFactory.networkFetchEncodedImageProducerSequence_delegate$lambda$2(this.f$0);
            }
        });
        this.localFileFetchEncodedImageProducerSequence = LazyKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProducerSequenceFactory.localFileFetchEncodedImageProducerSequence_delegate$lambda$4(this.f$0);
            }
        });
        this.localContentUriFetchEncodedImageProducerSequence = LazyKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProducerSequenceFactory.localContentUriFetchEncodedImageProducerSequence_delegate$lambda$6(this.f$0);
            }
        });
        this.networkFetchSequence = LazyKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProducerSequenceFactory.networkFetchSequence_delegate$lambda$11(this.f$0);
            }
        });
        this.backgroundNetworkFetchToEncodedMemorySequence = LazyKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProducerSequenceFactory.backgroundNetworkFetchToEncodedMemorySequence_delegate$lambda$13(this.f$0);
            }
        });
        this.networkFetchToEncodedMemoryPrefetchSequence = LazyKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProducerSequenceFactory.networkFetchToEncodedMemoryPrefetchSequence_delegate$lambda$15(this.f$0);
            }
        });
        this.commonNetworkFetchToEncodedMemorySequence = LazyKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProducerSequenceFactory.commonNetworkFetchToEncodedMemorySequence_delegate$lambda$17(this.f$0);
            }
        });
        this.localFileFetchToEncodedMemoryPrefetchSequence = LazyKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProducerSequenceFactory.localFileFetchToEncodedMemoryPrefetchSequence_delegate$lambda$20(this.f$0);
            }
        });
        this.backgroundLocalFileFetchToEncodeMemorySequence = LazyKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProducerSequenceFactory.backgroundLocalFileFetchToEncodeMemorySequence_delegate$lambda$22(this.f$0);
            }
        });
        this.backgroundLocalContentUriFetchToEncodeMemorySequence = LazyKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProducerSequenceFactory.backgroundLocalContentUriFetchToEncodeMemorySequence_delegate$lambda$24(this.f$0);
            }
        });
        this.localImageFileFetchSequence = LazyKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ProducerSequenceFactory producerSequenceFactory = this.f$0;
                return producerSequenceFactory.newBitmapCacheGetToLocalTransformSequence(producerSequenceFactory.producerFactory.newLocalFileFetchProducer());
            }
        });
        this.localVideoFileFetchSequence = LazyKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ProducerSequenceFactory producerSequenceFactory = this.f$0;
                return producerSequenceFactory.newBitmapCacheGetToBitmapCacheSequence(producerSequenceFactory.producerFactory.newLocalVideoThumbnailProducer());
            }
        });
        this.localContentUriFetchSequence = LazyKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ProducerSequenceFactory producerSequenceFactory = this.f$0;
                return producerSequenceFactory.newBitmapCacheGetToLocalTransformSequence(producerSequenceFactory.producerFactory.newLocalContentUriFetchProducer(), new ThumbnailProducer[]{producerSequenceFactory.producerFactory.newLocalContentUriThumbnailFetchProducer(), producerSequenceFactory.producerFactory.newLocalExifThumbnailProducer()});
            }
        });
        this.localThumbnailBitmapSdk29FetchSequence = LazyKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProducerSequenceFactory.localThumbnailBitmapSdk29FetchSequence_delegate$lambda$28(this.f$0);
            }
        });
        this.qualifiedResourceFetchSequence = LazyKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ProducerSequenceFactory producerSequenceFactory = this.f$0;
                return producerSequenceFactory.newBitmapCacheGetToLocalTransformSequence(producerSequenceFactory.producerFactory.newQualifiedResourceFetchProducer());
            }
        });
        this.localResourceFetchSequence = LazyKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ProducerSequenceFactory producerSequenceFactory = this.f$0;
                return producerSequenceFactory.newBitmapCacheGetToLocalTransformSequence(producerSequenceFactory.producerFactory.newLocalResourceFetchProducer());
            }
        });
        this.localAssetFetchSequence = LazyKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ProducerSequenceFactory producerSequenceFactory = this.f$0;
                return producerSequenceFactory.newBitmapCacheGetToLocalTransformSequence(producerSequenceFactory.producerFactory.newLocalAssetFetchProducer());
            }
        });
        this.dataFetchSequence = LazyKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ProducerSequenceFactory producerSequenceFactory = this.f$0;
                return producerSequenceFactory.newBitmapCacheGetToDecodeSequence(producerSequenceFactory.producerFactory.newResizeAndRotateProducer(ProducerFactory.INSTANCE.newAddImageTransformMetaDataProducer(producerSequenceFactory.producerFactory.newDataFetchProducer()), true, producerSequenceFactory.imageTranscoderFactory));
            }
        });
    }

    public final Map<Producer<CloseableReference<CloseableImage>>, Producer<CloseableReference<CloseableImage>>> getPostprocessorSequences() {
        return this.postprocessorSequences;
    }

    public final void setPostprocessorSequences(Map<Producer<CloseableReference<CloseableImage>>, Producer<CloseableReference<CloseableImage>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.postprocessorSequences = map;
    }

    public final Map<Producer<CloseableReference<CloseableImage>>, Producer<Void>> getCloseableImagePrefetchSequences() {
        return this.closeableImagePrefetchSequences;
    }

    public final void setCloseableImagePrefetchSequences(Map<Producer<CloseableReference<CloseableImage>>, Producer<Void>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.closeableImagePrefetchSequences = map;
    }

    public final Map<Producer<CloseableReference<CloseableImage>>, Producer<CloseableReference<CloseableImage>>> getBitmapPrepareSequences() {
        return this.bitmapPrepareSequences;
    }

    public final void setBitmapPrepareSequences(Map<Producer<CloseableReference<CloseableImage>>, Producer<CloseableReference<CloseableImage>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.bitmapPrepareSequences = map;
    }

    public final Producer<CloseableReference<PooledByteBuffer>> getEncodedImageProducerSequence(ImageRequest imageRequest) {
        Producer<CloseableReference<PooledByteBuffer>> networkFetchEncodedImageProducerSequence;
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            INSTANCE.validateEncodedImageRequest(imageRequest);
            Uri sourceUri = imageRequest.getSourceUri();
            Intrinsics.checkNotNullExpressionValue(sourceUri, "getSourceUri(...)");
            int sourceUriType = imageRequest.getSourceUriType();
            if (sourceUriType == 0) {
                return getNetworkFetchEncodedImageProducerSequence();
            }
            if (sourceUriType == 2 || sourceUriType == 3) {
                return getLocalFileFetchEncodedImageProducerSequence();
            }
            if (sourceUriType == 4) {
                return getLocalContentUriFetchEncodedImageProducerSequence();
            }
            Set<CustomProducerSequenceFactory> set = this.customProducerSequenceFactories;
            if (set != null) {
                Iterator<CustomProducerSequenceFactory> it = set.iterator();
                while (it.hasNext()) {
                    Producer<CloseableReference<PooledByteBuffer>> customEncodedImageSequence = it.next().getCustomEncodedImageSequence(imageRequest, this, this.producerFactory, this.threadHandoffProducerQueue);
                    if (customEncodedImageSequence != null) {
                        return customEncodedImageSequence;
                    }
                }
            }
            throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + INSTANCE.getShortenedUriString(sourceUri));
        }
        FrescoSystrace.beginSection("ProducerSequenceFactory#getEncodedImageProducerSequence");
        try {
            INSTANCE.validateEncodedImageRequest(imageRequest);
            Uri sourceUri2 = imageRequest.getSourceUri();
            Intrinsics.checkNotNullExpressionValue(sourceUri2, "getSourceUri(...)");
            int sourceUriType2 = imageRequest.getSourceUriType();
            if (sourceUriType2 == 0) {
                networkFetchEncodedImageProducerSequence = getNetworkFetchEncodedImageProducerSequence();
            } else if (sourceUriType2 == 2 || sourceUriType2 == 3) {
                networkFetchEncodedImageProducerSequence = getLocalFileFetchEncodedImageProducerSequence();
            } else {
                if (sourceUriType2 != 4) {
                    Set<CustomProducerSequenceFactory> set2 = this.customProducerSequenceFactories;
                    if (set2 != null) {
                        Iterator<CustomProducerSequenceFactory> it2 = set2.iterator();
                        while (it2.hasNext()) {
                            Producer<CloseableReference<PooledByteBuffer>> customEncodedImageSequence2 = it2.next().getCustomEncodedImageSequence(imageRequest, this, this.producerFactory, this.threadHandoffProducerQueue);
                            if (customEncodedImageSequence2 != null) {
                                FrescoSystrace.endSection();
                                return customEncodedImageSequence2;
                            }
                        }
                    }
                    throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + INSTANCE.getShortenedUriString(sourceUri2));
                }
                networkFetchEncodedImageProducerSequence = getLocalContentUriFetchEncodedImageProducerSequence();
            }
            FrescoSystrace.endSection();
            return networkFetchEncodedImageProducerSequence;
        } catch (Throwable th) {
            FrescoSystrace.endSection();
            throw th;
        }
    }

    public final Producer<CloseableReference<PooledByteBuffer>> getNetworkFetchEncodedImageProducerSequence() {
        return (Producer) this.networkFetchEncodedImageProducerSequence.getValue();
    }

    static final RemoveImageTransformMetaDataProducer networkFetchEncodedImageProducerSequence_delegate$lambda$2(ProducerSequenceFactory producerSequenceFactory) {
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            return new RemoveImageTransformMetaDataProducer(producerSequenceFactory.getBackgroundNetworkFetchToEncodedMemorySequence());
        }
        FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchEncodedImageProducerSequence:init");
        try {
            return new RemoveImageTransformMetaDataProducer(producerSequenceFactory.getBackgroundNetworkFetchToEncodedMemorySequence());
        } finally {
            FrescoSystrace.endSection();
        }
    }

    public final Producer<CloseableReference<PooledByteBuffer>> getLocalFileFetchEncodedImageProducerSequence() {
        return (Producer) this.localFileFetchEncodedImageProducerSequence.getValue();
    }

    static final RemoveImageTransformMetaDataProducer localFileFetchEncodedImageProducerSequence_delegate$lambda$4(ProducerSequenceFactory producerSequenceFactory) {
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            return new RemoveImageTransformMetaDataProducer(producerSequenceFactory.getBackgroundLocalFileFetchToEncodeMemorySequence());
        }
        FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalFileFetchEncodedImageProducerSequence:init");
        try {
            return new RemoveImageTransformMetaDataProducer(producerSequenceFactory.getBackgroundLocalFileFetchToEncodeMemorySequence());
        } finally {
            FrescoSystrace.endSection();
        }
    }

    public final Producer<CloseableReference<PooledByteBuffer>> getLocalContentUriFetchEncodedImageProducerSequence() {
        return (Producer) this.localContentUriFetchEncodedImageProducerSequence.getValue();
    }

    static final RemoveImageTransformMetaDataProducer localContentUriFetchEncodedImageProducerSequence_delegate$lambda$6(ProducerSequenceFactory producerSequenceFactory) {
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            return new RemoveImageTransformMetaDataProducer(producerSequenceFactory.getBackgroundLocalContentUriFetchToEncodeMemorySequence());
        }
        FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalContentUriFetchEncodedImageProducerSequence:init");
        try {
            return new RemoveImageTransformMetaDataProducer(producerSequenceFactory.getBackgroundLocalContentUriFetchToEncodeMemorySequence());
        } finally {
            FrescoSystrace.endSection();
        }
    }

    public final Producer<Void> getEncodedImagePrefetchProducerSequence(ImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        Companion companion = INSTANCE;
        companion.validateEncodedImageRequest(imageRequest);
        int sourceUriType = imageRequest.getSourceUriType();
        if (sourceUriType == 0) {
            return getNetworkFetchToEncodedMemoryPrefetchSequence();
        }
        if (sourceUriType == 2 || sourceUriType == 3) {
            return getLocalFileFetchToEncodedMemoryPrefetchSequence();
        }
        Uri sourceUri = imageRequest.getSourceUri();
        Intrinsics.checkNotNullExpressionValue(sourceUri, "getSourceUri(...)");
        throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + companion.getShortenedUriString(sourceUri));
    }

    public final Producer<CloseableReference<CloseableImage>> getDecodedImageProducerSequence(ImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            Producer<CloseableReference<CloseableImage>> basicDecodedImageSequence = getBasicDecodedImageSequence(imageRequest);
            if (imageRequest.getPostprocessor() != null) {
                basicDecodedImageSequence = getPostprocessorSequence(basicDecodedImageSequence);
            }
            if (this.useBitmapPrepareToDraw) {
                basicDecodedImageSequence = getBitmapPrepareSequence(basicDecodedImageSequence);
            }
            return (!this.allowDelay || imageRequest.getDelayMs() <= 0) ? basicDecodedImageSequence : getDelaySequence(basicDecodedImageSequence);
        }
        FrescoSystrace.beginSection("ProducerSequenceFactory#getDecodedImageProducerSequence");
        try {
            Producer<CloseableReference<CloseableImage>> basicDecodedImageSequence2 = getBasicDecodedImageSequence(imageRequest);
            if (imageRequest.getPostprocessor() != null) {
                basicDecodedImageSequence2 = getPostprocessorSequence(basicDecodedImageSequence2);
            }
            if (this.useBitmapPrepareToDraw) {
                basicDecodedImageSequence2 = getBitmapPrepareSequence(basicDecodedImageSequence2);
            }
            if (this.allowDelay && imageRequest.getDelayMs() > 0) {
                basicDecodedImageSequence2 = getDelaySequence(basicDecodedImageSequence2);
            }
            return basicDecodedImageSequence2;
        } finally {
            FrescoSystrace.endSection();
        }
    }

    public final Producer<Void> getDecodedImagePrefetchProducerSequence(ImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        Producer<CloseableReference<CloseableImage>> basicDecodedImageSequence = getBasicDecodedImageSequence(imageRequest);
        if (imageRequest.getPostprocessor() != null && this.usePostprocessorDuringDecodedPrefetch) {
            basicDecodedImageSequence = getPostprocessorSequence(basicDecodedImageSequence);
        }
        if (this.useBitmapPrepareToDraw) {
            basicDecodedImageSequence = getBitmapPrepareSequence(basicDecodedImageSequence);
        }
        return getDecodedImagePrefetchSequence(basicDecodedImageSequence);
    }

    private final Producer<CloseableReference<CloseableImage>> getBasicDecodedImageSequence(ImageRequest imageRequest) {
        Producer<CloseableReference<CloseableImage>> networkFetchSequence;
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            Uri sourceUri = imageRequest.getSourceUri();
            Intrinsics.checkNotNullExpressionValue(sourceUri, "getSourceUri(...)");
            if (sourceUri == null) {
                throw new IllegalStateException("Uri is null.".toString());
            }
            int sourceUriType = imageRequest.getSourceUriType();
            if (sourceUriType == 0) {
                return getNetworkFetchSequence();
            }
            switch (sourceUriType) {
                case 2:
                    return imageRequest.getLoadThumbnailOnlyForAndroidSdkAboveQ() ? getLocalThumbnailBitmapSdk29FetchSequence() : getLocalVideoFileFetchSequence();
                case 3:
                    return imageRequest.getLoadThumbnailOnlyForAndroidSdkAboveQ() ? getLocalThumbnailBitmapSdk29FetchSequence() : getLocalImageFileFetchSequence();
                case 4:
                    if (imageRequest.getLoadThumbnailOnlyForAndroidSdkAboveQ()) {
                        return getLocalThumbnailBitmapSdk29FetchSequence();
                    }
                    return MediaUtils.isVideo(this.contentResolver.getType(sourceUri)) ? getLocalVideoFileFetchSequence() : getLocalContentUriFetchSequence();
                case 5:
                    return getLocalAssetFetchSequence();
                case 6:
                    return getLocalResourceFetchSequence();
                case 7:
                    return getDataFetchSequence();
                case 8:
                    return getQualifiedResourceFetchSequence();
                default:
                    Set<CustomProducerSequenceFactory> set = this.customProducerSequenceFactories;
                    if (set != null) {
                        Iterator<CustomProducerSequenceFactory> it = set.iterator();
                        while (it.hasNext()) {
                            ProducerSequenceFactory producerSequenceFactory = this;
                            ImageRequest imageRequest2 = imageRequest;
                            Producer<CloseableReference<CloseableImage>> customDecodedImageSequence = it.next().getCustomDecodedImageSequence(imageRequest2, producerSequenceFactory, this.producerFactory, this.threadHandoffProducerQueue, this.isEncodedMemoryCacheProbingEnabled, this.isDiskCacheProbingEnabled);
                            if (customDecodedImageSequence != null) {
                                return customDecodedImageSequence;
                            }
                            imageRequest = imageRequest2;
                            this = producerSequenceFactory;
                        }
                    }
                    String shortenedUriString = INSTANCE.getShortenedUriString(sourceUri);
                    Set<CustomProducerSequenceFactory> set2 = this.customProducerSequenceFactories;
                    throw new IllegalArgumentException("Unsupported uri scheme! Uri is: <" + shortenedUriString + "> " + (set2 != null ? Integer.valueOf(set2.size()) : null) + " custom factories");
            }
        }
        FrescoSystrace.beginSection("ProducerSequenceFactory#getBasicDecodedImageSequence");
        try {
            Uri sourceUri2 = imageRequest.getSourceUri();
            Intrinsics.checkNotNullExpressionValue(sourceUri2, "getSourceUri(...)");
            if (sourceUri2 == null) {
                throw new IllegalStateException("Uri is null.".toString());
            }
            int sourceUriType2 = imageRequest.getSourceUriType();
            if (sourceUriType2 != 0) {
                switch (sourceUriType2) {
                    case 2:
                        if (imageRequest.getLoadThumbnailOnlyForAndroidSdkAboveQ()) {
                            Producer<CloseableReference<CloseableImage>> localThumbnailBitmapSdk29FetchSequence = getLocalThumbnailBitmapSdk29FetchSequence();
                            FrescoSystrace.endSection();
                            return localThumbnailBitmapSdk29FetchSequence;
                        }
                        networkFetchSequence = getLocalVideoFileFetchSequence();
                        break;
                    case 3:
                        if (imageRequest.getLoadThumbnailOnlyForAndroidSdkAboveQ()) {
                            Producer<CloseableReference<CloseableImage>> localThumbnailBitmapSdk29FetchSequence2 = getLocalThumbnailBitmapSdk29FetchSequence();
                            FrescoSystrace.endSection();
                            return localThumbnailBitmapSdk29FetchSequence2;
                        }
                        networkFetchSequence = getLocalImageFileFetchSequence();
                        break;
                    case 4:
                        if (imageRequest.getLoadThumbnailOnlyForAndroidSdkAboveQ()) {
                            Producer<CloseableReference<CloseableImage>> localThumbnailBitmapSdk29FetchSequence3 = getLocalThumbnailBitmapSdk29FetchSequence();
                            FrescoSystrace.endSection();
                            return localThumbnailBitmapSdk29FetchSequence3;
                        }
                        if (MediaUtils.isVideo(this.contentResolver.getType(sourceUri2))) {
                            Producer<CloseableReference<CloseableImage>> localVideoFileFetchSequence = getLocalVideoFileFetchSequence();
                            FrescoSystrace.endSection();
                            return localVideoFileFetchSequence;
                        }
                        networkFetchSequence = getLocalContentUriFetchSequence();
                        break;
                    case 5:
                        networkFetchSequence = getLocalAssetFetchSequence();
                        break;
                    case 6:
                        networkFetchSequence = getLocalResourceFetchSequence();
                        break;
                    case 7:
                        networkFetchSequence = getDataFetchSequence();
                        break;
                    case 8:
                        networkFetchSequence = getQualifiedResourceFetchSequence();
                        break;
                    default:
                        Set<CustomProducerSequenceFactory> set3 = this.customProducerSequenceFactories;
                        if (set3 != null) {
                            Iterator<CustomProducerSequenceFactory> it2 = set3.iterator();
                            while (it2.hasNext()) {
                                Producer<CloseableReference<CloseableImage>> customDecodedImageSequence2 = it2.next().getCustomDecodedImageSequence(imageRequest, this, this.producerFactory, this.threadHandoffProducerQueue, this.isEncodedMemoryCacheProbingEnabled, this.isDiskCacheProbingEnabled);
                                if (customDecodedImageSequence2 != null) {
                                    FrescoSystrace.endSection();
                                    return customDecodedImageSequence2;
                                }
                            }
                        }
                        String shortenedUriString2 = INSTANCE.getShortenedUriString(sourceUri2);
                        Set<CustomProducerSequenceFactory> set4 = this.customProducerSequenceFactories;
                        throw new IllegalArgumentException("Unsupported uri scheme! Uri is: <" + shortenedUriString2 + "> " + (set4 != null ? Integer.valueOf(set4.size()) : null) + " custom factories");
                }
            } else {
                networkFetchSequence = getNetworkFetchSequence();
            }
            FrescoSystrace.endSection();
            return networkFetchSequence;
        } catch (Throwable th) {
            FrescoSystrace.endSection();
            throw th;
        }
    }

    public final Producer<CloseableReference<CloseableImage>> getNetworkFetchSequence() {
        return (Producer) this.networkFetchSequence.getValue();
    }

    static final Producer networkFetchSequence_delegate$lambda$11(ProducerSequenceFactory producerSequenceFactory) {
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            return producerSequenceFactory.newBitmapCacheGetToDecodeSequence(producerSequenceFactory.getCommonNetworkFetchToEncodedMemorySequence());
        }
        FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchSequence:init");
        try {
            return producerSequenceFactory.newBitmapCacheGetToDecodeSequence(producerSequenceFactory.getCommonNetworkFetchToEncodedMemorySequence());
        } finally {
            FrescoSystrace.endSection();
        }
    }

    public final Producer<EncodedImage> getBackgroundNetworkFetchToEncodedMemorySequence() {
        return (Producer) this.backgroundNetworkFetchToEncodedMemorySequence.getValue();
    }

    static final Producer backgroundNetworkFetchToEncodedMemorySequence_delegate$lambda$13(ProducerSequenceFactory producerSequenceFactory) {
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            return producerSequenceFactory.producerFactory.newBackgroundThreadHandoffProducer(producerSequenceFactory.getCommonNetworkFetchToEncodedMemorySequence(), producerSequenceFactory.threadHandoffProducerQueue);
        }
        FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundNetworkFetchToEncodedMemorySequence:init");
        try {
            return producerSequenceFactory.producerFactory.newBackgroundThreadHandoffProducer(producerSequenceFactory.getCommonNetworkFetchToEncodedMemorySequence(), producerSequenceFactory.threadHandoffProducerQueue);
        } finally {
            FrescoSystrace.endSection();
        }
    }

    public final Producer<Void> getNetworkFetchToEncodedMemoryPrefetchSequence() {
        return (Producer) this.networkFetchToEncodedMemoryPrefetchSequence.getValue();
    }

    static final SwallowResultProducer networkFetchToEncodedMemoryPrefetchSequence_delegate$lambda$15(ProducerSequenceFactory producerSequenceFactory) {
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            return producerSequenceFactory.producerFactory.newSwallowResultProducer(producerSequenceFactory.getBackgroundNetworkFetchToEncodedMemorySequence());
        }
        FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchToEncodedMemoryPrefetchSequence");
        try {
            return producerSequenceFactory.producerFactory.newSwallowResultProducer(producerSequenceFactory.getBackgroundNetworkFetchToEncodedMemorySequence());
        } finally {
            FrescoSystrace.endSection();
        }
    }

    public final Producer<EncodedImage> getCommonNetworkFetchToEncodedMemorySequence() {
        return (Producer) this.commonNetworkFetchToEncodedMemorySequence.getValue();
    }

    static final Producer commonNetworkFetchToEncodedMemorySequence_delegate$lambda$17(ProducerSequenceFactory producerSequenceFactory) {
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            return producerSequenceFactory.newCommonNetworkFetchToEncodedMemorySequence(producerSequenceFactory.networkFetcher);
        }
        FrescoSystrace.beginSection("ProducerSequenceFactory#getCommonNetworkFetchToEncodedMemorySequence");
        try {
            return producerSequenceFactory.newCommonNetworkFetchToEncodedMemorySequence(producerSequenceFactory.networkFetcher);
        } finally {
            FrescoSystrace.endSection();
        }
    }

    public final synchronized Producer<EncodedImage> newCommonNetworkFetchToEncodedMemorySequence(NetworkFetcher<?> networkFetcher) {
        Intrinsics.checkNotNullParameter(networkFetcher, "networkFetcher");
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        boolean z = true;
        if (!FrescoSystrace.isTracing()) {
            AddImageTransformMetaDataProducer addImageTransformMetaDataProducerNewAddImageTransformMetaDataProducer = ProducerFactory.INSTANCE.newAddImageTransformMetaDataProducer(newEncodedCacheMultiplexToTranscodeSequence(this.producerFactory.newNetworkFetchProducer(networkFetcher)));
            ProducerFactory producerFactory = this.producerFactory;
            if (!this.resizeAndRotateEnabledForNetwork || this.downsampleMode == DownsampleMode.NEVER) {
                z = false;
            }
            return producerFactory.newResizeAndRotateProducer(addImageTransformMetaDataProducerNewAddImageTransformMetaDataProducer, z, this.imageTranscoderFactory);
        }
        FrescoSystrace.beginSection("ProducerSequenceFactory#createCommonNetworkFetchToEncodedMemorySequence");
        try {
            AddImageTransformMetaDataProducer addImageTransformMetaDataProducerNewAddImageTransformMetaDataProducer2 = ProducerFactory.INSTANCE.newAddImageTransformMetaDataProducer(newEncodedCacheMultiplexToTranscodeSequence(this.producerFactory.newNetworkFetchProducer(networkFetcher)));
            ProducerFactory producerFactory2 = this.producerFactory;
            if (!this.resizeAndRotateEnabledForNetwork || this.downsampleMode == DownsampleMode.NEVER) {
                z = false;
            }
            ResizeAndRotateProducer resizeAndRotateProducerNewResizeAndRotateProducer = producerFactory2.newResizeAndRotateProducer(addImageTransformMetaDataProducerNewAddImageTransformMetaDataProducer2, z, this.imageTranscoderFactory);
            FrescoSystrace.endSection();
            return resizeAndRotateProducerNewResizeAndRotateProducer;
        } catch (Throwable th) {
            FrescoSystrace.endSection();
            throw th;
        }
    }

    public final Producer<Void> getLocalFileFetchToEncodedMemoryPrefetchSequence() {
        return (Producer) this.localFileFetchToEncodedMemoryPrefetchSequence.getValue();
    }

    static final SwallowResultProducer localFileFetchToEncodedMemoryPrefetchSequence_delegate$lambda$20(ProducerSequenceFactory producerSequenceFactory) {
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            return producerSequenceFactory.producerFactory.newSwallowResultProducer(producerSequenceFactory.getBackgroundLocalFileFetchToEncodeMemorySequence());
        }
        FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalFileFetchToEncodedMemoryPrefetchSequence:init");
        try {
            return producerSequenceFactory.producerFactory.newSwallowResultProducer(producerSequenceFactory.getBackgroundLocalFileFetchToEncodeMemorySequence());
        } finally {
            FrescoSystrace.endSection();
        }
    }

    public final Producer<EncodedImage> getBackgroundLocalFileFetchToEncodeMemorySequence() {
        return (Producer) this.backgroundLocalFileFetchToEncodeMemorySequence.getValue();
    }

    static final Producer backgroundLocalFileFetchToEncodeMemorySequence_delegate$lambda$22(ProducerSequenceFactory producerSequenceFactory) {
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            return producerSequenceFactory.producerFactory.newBackgroundThreadHandoffProducer(producerSequenceFactory.newEncodedCacheMultiplexToTranscodeSequence(producerSequenceFactory.producerFactory.newLocalFileFetchProducer()), producerSequenceFactory.threadHandoffProducerQueue);
        }
        FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundLocalFileFetchToEncodeMemorySequence");
        try {
            return producerSequenceFactory.producerFactory.newBackgroundThreadHandoffProducer(producerSequenceFactory.newEncodedCacheMultiplexToTranscodeSequence(producerSequenceFactory.producerFactory.newLocalFileFetchProducer()), producerSequenceFactory.threadHandoffProducerQueue);
        } finally {
            FrescoSystrace.endSection();
        }
    }

    public final Producer<EncodedImage> getBackgroundLocalContentUriFetchToEncodeMemorySequence() {
        return (Producer) this.backgroundLocalContentUriFetchToEncodeMemorySequence.getValue();
    }

    static final Producer backgroundLocalContentUriFetchToEncodeMemorySequence_delegate$lambda$24(ProducerSequenceFactory producerSequenceFactory) {
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            return producerSequenceFactory.producerFactory.newBackgroundThreadHandoffProducer(producerSequenceFactory.newEncodedCacheMultiplexToTranscodeSequence(producerSequenceFactory.producerFactory.newLocalContentUriFetchProducer()), producerSequenceFactory.threadHandoffProducerQueue);
        }
        FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundLocalContentUriFetchToEncodeMemorySequence:init");
        try {
            return producerSequenceFactory.producerFactory.newBackgroundThreadHandoffProducer(producerSequenceFactory.newEncodedCacheMultiplexToTranscodeSequence(producerSequenceFactory.producerFactory.newLocalContentUriFetchProducer()), producerSequenceFactory.threadHandoffProducerQueue);
        } finally {
            FrescoSystrace.endSection();
        }
    }

    public final Producer<CloseableReference<CloseableImage>> getLocalImageFileFetchSequence() {
        return (Producer) this.localImageFileFetchSequence.getValue();
    }

    public final Producer<CloseableReference<CloseableImage>> getLocalVideoFileFetchSequence() {
        return (Producer) this.localVideoFileFetchSequence.getValue();
    }

    public final Producer<CloseableReference<CloseableImage>> getLocalContentUriFetchSequence() {
        return (Producer) this.localContentUriFetchSequence.getValue();
    }

    public final Producer<CloseableReference<CloseableImage>> getLocalThumbnailBitmapSdk29FetchSequence() {
        return (Producer) this.localThumbnailBitmapSdk29FetchSequence.getValue();
    }

    static final Producer localThumbnailBitmapSdk29FetchSequence_delegate$lambda$28(ProducerSequenceFactory producerSequenceFactory) throws Throwable {
        if (Build.VERSION.SDK_INT >= 29) {
            return producerSequenceFactory.newBitmapCacheGetToBitmapCacheSequence(producerSequenceFactory.producerFactory.newLocalThumbnailBitmapSdk29Producer(Boolean.valueOf(producerSequenceFactory.loadThumbnailFromContentResolverFirst), Boolean.valueOf(producerSequenceFactory.loadThumbnailFromContentResolverForContentUriOnly)));
        }
        throw new Throwable("Unreachable exception. Just to make linter happy for the lazy block.");
    }

    public final Producer<CloseableReference<CloseableImage>> getQualifiedResourceFetchSequence() {
        return (Producer) this.qualifiedResourceFetchSequence.getValue();
    }

    public final Producer<CloseableReference<CloseableImage>> getLocalResourceFetchSequence() {
        return (Producer) this.localResourceFetchSequence.getValue();
    }

    public final Producer<CloseableReference<CloseableImage>> getLocalAssetFetchSequence() {
        return (Producer) this.localAssetFetchSequence.getValue();
    }

    public final Producer<CloseableReference<CloseableImage>> getDataFetchSequence() {
        return (Producer) this.dataFetchSequence.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToLocalTransformSequence(Producer<EncodedImage> inputProducer) {
        return newBitmapCacheGetToLocalTransformSequence(inputProducer, new ThumbnailProducer[]{this.producerFactory.newLocalExifThumbnailProducer()});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToLocalTransformSequence(Producer<EncodedImage> inputProducer, ThumbnailProducer<EncodedImage>[] thumbnailProducers) {
        return newBitmapCacheGetToDecodeSequence(newLocalTransformationsSequence(newEncodedCacheMultiplexToTranscodeSequence(inputProducer), thumbnailProducers));
    }

    public final Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToDecodeSequence(Producer<EncodedImage> inputProducer) {
        Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            return newBitmapCacheGetToBitmapCacheSequence(this.producerFactory.newDecodeProducer(inputProducer));
        }
        FrescoSystrace.beginSection("ProducerSequenceFactory#newBitmapCacheGetToDecodeSequence");
        try {
            return newBitmapCacheGetToBitmapCacheSequence(this.producerFactory.newDecodeProducer(inputProducer));
        } finally {
            FrescoSystrace.endSection();
        }
    }

    private final Producer<EncodedImage> newEncodedCacheMultiplexToTranscodeSequence(Producer<EncodedImage> inputProducer) {
        if (this.diskCacheEnabled) {
            inputProducer = newDiskCacheSequence(inputProducer);
        }
        Producer<EncodedImage> producerNewEncodedMemoryCacheProducer = this.producerFactory.newEncodedMemoryCacheProducer(inputProducer);
        boolean z = this.isDiskCacheProbingEnabled;
        ProducerFactory producerFactory = this.producerFactory;
        if (z) {
            return this.producerFactory.newEncodedCacheKeyMultiplexProducer(producerFactory.newEncodedProbeProducer(producerNewEncodedMemoryCacheProducer));
        }
        return producerFactory.newEncodedCacheKeyMultiplexProducer(producerNewEncodedMemoryCacheProducer);
    }

    private final Producer<EncodedImage> newDiskCacheSequence(Producer<EncodedImage> inputProducer) {
        DiskCacheWriteProducer diskCacheWriteProducerNewDiskCacheWriteProducer;
        DiskCacheWriteProducer diskCacheWriteProducerNewDiskCacheWriteProducer2;
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            boolean z = this.partialImageCachingEnabled;
            ProducerFactory producerFactory = this.producerFactory;
            if (z) {
                diskCacheWriteProducerNewDiskCacheWriteProducer2 = this.producerFactory.newDiskCacheWriteProducer(producerFactory.newPartialDiskCacheProducer(inputProducer));
            } else {
                diskCacheWriteProducerNewDiskCacheWriteProducer2 = producerFactory.newDiskCacheWriteProducer(inputProducer);
            }
            return this.producerFactory.newDiskCacheReadProducer(diskCacheWriteProducerNewDiskCacheWriteProducer2);
        }
        FrescoSystrace.beginSection("ProducerSequenceFactory#newDiskCacheSequence");
        try {
            boolean z2 = this.partialImageCachingEnabled;
            ProducerFactory producerFactory2 = this.producerFactory;
            if (z2) {
                diskCacheWriteProducerNewDiskCacheWriteProducer = this.producerFactory.newDiskCacheWriteProducer(producerFactory2.newPartialDiskCacheProducer(inputProducer));
            } else {
                diskCacheWriteProducerNewDiskCacheWriteProducer = producerFactory2.newDiskCacheWriteProducer(inputProducer);
            }
            return this.producerFactory.newDiskCacheReadProducer(diskCacheWriteProducerNewDiskCacheWriteProducer);
        } finally {
            FrescoSystrace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToBitmapCacheSequence(Producer<CloseableReference<CloseableImage>> inputProducer) {
        Producer<CloseableReference<CloseableImage>> producerNewBackgroundThreadHandoffProducer = this.producerFactory.newBackgroundThreadHandoffProducer(this.producerFactory.newBitmapMemoryCacheKeyMultiplexProducer(this.producerFactory.newBitmapMemoryCacheProducer(inputProducer)), this.threadHandoffProducerQueue);
        if (this.isEncodedMemoryCacheProbingEnabled || this.isDiskCacheProbingEnabled) {
            return this.producerFactory.newBitmapProbeProducer(this.producerFactory.newBitmapMemoryCacheGetProducer(producerNewBackgroundThreadHandoffProducer));
        }
        return this.producerFactory.newBitmapMemoryCacheGetProducer(producerNewBackgroundThreadHandoffProducer);
    }

    private final Producer<EncodedImage> newLocalTransformationsSequence(Producer<EncodedImage> inputProducer, ThumbnailProducer<EncodedImage>[] thumbnailProducers) {
        return ProducerFactory.INSTANCE.newBranchOnSeparateImagesProducer(newLocalThumbnailProducer(thumbnailProducers), this.producerFactory.newThrottlingProducer(this.localImageThrottlingMaxSimultaneousRequests, this.producerFactory.newResizeAndRotateProducer(ProducerFactory.INSTANCE.newAddImageTransformMetaDataProducer(inputProducer), true, this.imageTranscoderFactory)));
    }

    private final Producer<EncodedImage> newLocalThumbnailProducer(ThumbnailProducer<EncodedImage>[] thumbnailProducers) {
        return this.producerFactory.newResizeAndRotateProducer(this.producerFactory.newThumbnailBranchProducer(thumbnailProducers), true, this.imageTranscoderFactory);
    }

    private final synchronized Producer<CloseableReference<CloseableImage>> getPostprocessorSequence(Producer<CloseableReference<CloseableImage>> inputProducer) {
        PostprocessedBitmapMemoryCacheProducer postprocessedBitmapMemoryCacheProducerNewPostprocessorBitmapMemoryCacheProducer;
        postprocessedBitmapMemoryCacheProducerNewPostprocessorBitmapMemoryCacheProducer = this.postprocessorSequences.get(inputProducer);
        if (postprocessedBitmapMemoryCacheProducerNewPostprocessorBitmapMemoryCacheProducer == null) {
            postprocessedBitmapMemoryCacheProducerNewPostprocessorBitmapMemoryCacheProducer = this.producerFactory.newPostprocessorBitmapMemoryCacheProducer(this.producerFactory.newPostprocessorProducer(inputProducer));
            this.postprocessorSequences.put(inputProducer, postprocessedBitmapMemoryCacheProducerNewPostprocessorBitmapMemoryCacheProducer);
        }
        return postprocessedBitmapMemoryCacheProducerNewPostprocessorBitmapMemoryCacheProducer;
    }

    private final synchronized Producer<Void> getDecodedImagePrefetchSequence(Producer<CloseableReference<CloseableImage>> inputProducer) {
        SwallowResultProducer swallowResultProducerNewSwallowResultProducer;
        swallowResultProducerNewSwallowResultProducer = this.closeableImagePrefetchSequences.get(inputProducer);
        if (swallowResultProducerNewSwallowResultProducer == null) {
            swallowResultProducerNewSwallowResultProducer = this.producerFactory.newSwallowResultProducer(inputProducer);
            this.closeableImagePrefetchSequences.put(inputProducer, swallowResultProducerNewSwallowResultProducer);
        }
        return swallowResultProducerNewSwallowResultProducer;
    }

    private final synchronized Producer<CloseableReference<CloseableImage>> getBitmapPrepareSequence(Producer<CloseableReference<CloseableImage>> inputProducer) {
        BitmapPrepareProducer bitmapPrepareProducerNewBitmapPrepareProducer;
        bitmapPrepareProducerNewBitmapPrepareProducer = this.bitmapPrepareSequences.get(inputProducer);
        if (bitmapPrepareProducerNewBitmapPrepareProducer == null) {
            bitmapPrepareProducerNewBitmapPrepareProducer = this.producerFactory.newBitmapPrepareProducer(inputProducer);
            this.bitmapPrepareSequences.put(inputProducer, bitmapPrepareProducerNewBitmapPrepareProducer);
        }
        return bitmapPrepareProducerNewBitmapPrepareProducer;
    }

    private final synchronized Producer<CloseableReference<CloseableImage>> getDelaySequence(Producer<CloseableReference<CloseableImage>> inputProducer) {
        return this.producerFactory.newDelayProducer(inputProducer);
    }

    /* JADX INFO: compiled from: ProducerSequenceFactory.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\f"}, d2 = {"Lcom/facebook/imagepipeline/core/ProducerSequenceFactory$Companion;", "", "<init>", "()V", "validateEncodedImageRequest", "", "imageRequest", "Lcom/facebook/imagepipeline/request/ImageRequest;", "getShortenedUriString", "", "uri", "Landroid/net/Uri;", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void validateEncodedImageRequest(ImageRequest imageRequest) {
            Preconditions.checkArgument(Boolean.valueOf(imageRequest.getLowestPermittedRequestLevel().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getShortenedUriString(Uri uri) {
            String string = uri.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            if (string.length() <= 30) {
                return string;
            }
            String strSubstring = string.substring(0, 30);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return strSubstring + "...";
        }
    }
}

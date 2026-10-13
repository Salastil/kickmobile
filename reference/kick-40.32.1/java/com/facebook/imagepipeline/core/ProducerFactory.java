package com.facebook.imagepipeline.core;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BoundedLinkedHashSet;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.AddImageTransformMetaDataProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheGetProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheKeyMultiplexProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.BitmapPrepareProducer;
import com.facebook.imagepipeline.producers.BitmapProbeProducer;
import com.facebook.imagepipeline.producers.BranchOnSeparateImagesProducer;
import com.facebook.imagepipeline.producers.DataFetchProducer;
import com.facebook.imagepipeline.producers.DecodeProducer;
import com.facebook.imagepipeline.producers.DelayProducer;
import com.facebook.imagepipeline.producers.DiskCacheReadProducer;
import com.facebook.imagepipeline.producers.DiskCacheWriteProducer;
import com.facebook.imagepipeline.producers.EncodedCacheKeyMultiplexProducer;
import com.facebook.imagepipeline.producers.EncodedMemoryCacheProducer;
import com.facebook.imagepipeline.producers.EncodedProbeProducer;
import com.facebook.imagepipeline.producers.LocalAssetFetchProducer;
import com.facebook.imagepipeline.producers.LocalContentUriFetchProducer;
import com.facebook.imagepipeline.producers.LocalContentUriThumbnailFetchProducer;
import com.facebook.imagepipeline.producers.LocalExifThumbnailProducer;
import com.facebook.imagepipeline.producers.LocalFileFetchProducer;
import com.facebook.imagepipeline.producers.LocalResourceFetchProducer;
import com.facebook.imagepipeline.producers.LocalThumbnailBitmapSdk29Producer;
import com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer;
import com.facebook.imagepipeline.producers.NetworkFetchProducer;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.PartialDiskCacheProducer;
import com.facebook.imagepipeline.producers.PostprocessedBitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.PostprocessorProducer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.QualifiedResourceFetchProducer;
import com.facebook.imagepipeline.producers.ResizeAndRotateProducer;
import com.facebook.imagepipeline.producers.SwallowResultProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.producers.ThrottlingProducer;
import com.facebook.imagepipeline.producers.ThumbnailBranchProducer;
import com.facebook.imagepipeline.producers.ThumbnailProducer;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import java.util.Arrays;
import java.util.concurrent.Executor;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProducerFactory.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0082\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 ¸\u00012\u00020\u0001:\u0002¸\u0001BÕ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014\u0012\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00180\u0014\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010#\u001a\u00020\r\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010%\u001a\u00020&\u0012\u0006\u0010'\u001a\u00020\r\u0012\u0006\u0010(\u001a\u00020!\u0012\u0006\u0010)\u001a\u00020*¢\u0006\u0004\b+\u0010,Bñ\u0001\b\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010-\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010/\u001a\u0004\u0018\u00010\t\u0012\u0006\u00100\u001a\u00020\r\u0012\u0006\u00101\u001a\u00020\r\u0012\u0006\u00102\u001a\u00020\r\u0012\b\u00103\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0014\u0012\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0014\u0012\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\u0006\u0010 \u001a\u00020!\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010#\u001a\u00020\r\u0012\u0006\u0010$\u001a\u00020!\u0012\b\u0010%\u001a\u0004\u0018\u00010&\u0012\u0006\u0010'\u001a\u00020\r\u0012\u0006\u0010(\u001a\u00020!\u0012\b\u0010)\u001a\u0004\u0018\u00010*¢\u0006\u0004\b+\u00104J\u001a\u0010h\u001a\u00020i2\u0012\u0010j\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160l0kJ\u001a\u0010m\u001a\u00020n2\u0012\u0010j\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160l0kJ\u001a\u0010o\u001a\u00020p2\u0012\u0010j\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160l0kJ\u0006\u0010q\u001a\u00020rJ\u0016\u0010s\u001a\u00020t2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020u0kH\u0016J\u0014\u0010v\u001a\u00020w2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020u0kJ\u0014\u0010x\u001a\u00020y2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020u0kJ\u0014\u0010z\u001a\u00020{2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020u0kJ\u0016\u0010|\u001a\u00020}2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020u0kH\u0016J\u001a\u0010~\u001a\u00020\u007f2\u0012\u0010j\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160l0kJ\u0016\u0010\u0080\u0001\u001a\u00030\u0081\u00012\f\u0010j\u001a\b\u0012\u0004\u0012\u00020u0kJ\u001d\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020u0k2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020u0kH\u0016J\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001J\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001J\b\u0010\u0087\u0001\u001a\u00030\u0088\u0001J\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001J%\u0010\u008b\u0001\u001a\u00030\u008c\u00012\u0015\u0010\u008d\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020u0\u008f\u00010\u008e\u0001¢\u0006\u0003\u0010\u0090\u0001J\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001J\b\u0010\u0093\u0001\u001a\u00030\u0094\u0001J\b\u0010\u0095\u0001\u001a\u00030\u0096\u0001J\b\u0010\u0097\u0001\u001a\u00030\u0098\u0001J\u001d\u0010\u0099\u0001\u001a\b\u0012\u0004\u0012\u00020u0k2\f\u0010\u009a\u0001\u001a\u0007\u0012\u0002\b\u00030\u009b\u0001H\u0016J\u001c\u0010\u009c\u0001\u001a\u00030\u009d\u00012\u0012\u0010j\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160l0kJ\u001c\u0010\u009e\u0001\u001a\u00030\u009f\u00012\u0012\u0010j\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160l0kJ+\u0010 \u0001\u001a\u00030¡\u00012\f\u0010j\u001a\b\u0012\u0004\u0012\u00020u0k2\u0007\u0010¢\u0001\u001a\u00020\r2\n\u0010£\u0001\u001a\u0005\u0018\u00010¤\u0001J'\u0010¥\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u0001H§\u00010¦\u0001\"\u0005\b\u0000\u0010§\u00012\r\u0010j\u001a\t\u0012\u0005\u0012\u0003H§\u00010kJ0\u0010¨\u0001\u001a\t\u0012\u0005\u0012\u0003H§\u00010k\"\u0005\b\u0000\u0010§\u00012\r\u0010j\u001a\t\u0012\u0005\u0012\u0003H§\u00010k2\b\u0010©\u0001\u001a\u00030ª\u0001H\u0016J/\u0010«\u0001\u001a\n\u0012\u0005\u0012\u0003H§\u00010¬\u0001\"\u0005\b\u0000\u0010§\u00012\b\u0010\u00ad\u0001\u001a\u00030®\u00012\r\u0010j\u001a\t\u0012\u0005\u0012\u0003H§\u00010kJ\u001c\u0010¯\u0001\u001a\u00030°\u00012\u0012\u0010j\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160l0kJ\u001c\u0010±\u0001\u001a\u00030²\u00012\u0012\u0010j\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160l0kJ&\u0010³\u0001\u001a\u00030´\u00012\t\u0010µ\u0001\u001a\u0004\u0018\u00010\r2\t\u0010¶\u0001\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0003\u0010·\u0001R\u0010\u0010\u0004\u001a\u00020\u00058\u0004X\u0085\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0004X\u0085\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0004X\u0085\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000b8\u0004X\u0085\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\r8\u0004X\u0085\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\r8\u0004X\u0085\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00108\u0004X\u0085\u0004¢\u0006\u0002\n\u0000R\u001a\u00105\u001a\u000206X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020<X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020BX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0014\u0010G\u001a\u00020\u0012X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u001c\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00180\u00148\u0004X\u0085\u0004¢\u0006\u0002\n\u0000R\u001c\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00148\u0004X\u0085\u0004¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u00020\u001d8\u0004X\u0085\u0004¢\u0006\u0002\n\u0000R\u001c\u0010P\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150QX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u001c\u0010T\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150QX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010SR\u0014\u0010V\u001a\u00020\u001fX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u0014\u0010Y\u001a\u00020!X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u0014\u0010\\\u001a\u00020!X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010[R\u001a\u0010^\u001a\u00020\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u0010\u0010c\u001a\u00020&8\u0004X\u0085\u0004¢\u0006\u0002\n\u0000R\u0010\u0010d\u001a\u00020!8\u0004X\u0085\u0004¢\u0006\u0002\n\u0000R\u0014\u0010e\u001a\u00020\rX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bf\u0010`R\u000e\u0010g\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006¹\u0001"}, d2 = {"Lcom/facebook/imagepipeline/core/ProducerFactory;", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "mByteArrayPool", "Lcom/facebook/common/memory/ByteArrayPool;", "mImageDecoder", "Lcom/facebook/imagepipeline/decoder/ImageDecoder;", "mProgressiveJpegConfig", "Lcom/facebook/imagepipeline/decoder/ProgressiveJpegConfig;", "mDownsampleMode", "Lcom/facebook/imagepipeline/core/DownsampleMode;", "mResizeAndRotateEnabledForNetwork", "", "mDecodeCancellationEnabled", "mExecutorSupplier", "Lcom/facebook/imagepipeline/core/ExecutorSupplier;", "pooledByteBufferFactory", "Lcom/facebook/common/memory/PooledByteBufferFactory;", "bitmapMemoryCache", "Lcom/facebook/imagepipeline/cache/MemoryCache;", "Lcom/facebook/cache/common/CacheKey;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "encodedMemoryCache", "Lcom/facebook/common/memory/PooledByteBuffer;", "diskCachesStoreSupplier", "Lcom/facebook/common/internal/Supplier;", "Lcom/facebook/imagepipeline/core/DiskCachesStore;", "cacheKeyFactory", "Lcom/facebook/imagepipeline/cache/CacheKeyFactory;", "platformBitmapFactory", "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "bitmapPrepareToDrawMinSizeBytes", "", "bitmapPrepareToDrawMaxSizeBytes", "bitmapPrepareToDrawForPrefetch", "maxBitmapSize", "closeableReferenceFactory", "Lcom/facebook/imagepipeline/core/CloseableReferenceFactory;", "keepCancelledFetchAsLowPriority", "trackedKeysSize", "config", "Lcom/facebook/imagepipeline/core/ImagePipelineConfigInterface;", "<init>", "(Landroid/content/Context;Lcom/facebook/common/memory/ByteArrayPool;Lcom/facebook/imagepipeline/decoder/ImageDecoder;Lcom/facebook/imagepipeline/decoder/ProgressiveJpegConfig;Lcom/facebook/imagepipeline/core/DownsampleMode;ZZLcom/facebook/imagepipeline/core/ExecutorSupplier;Lcom/facebook/common/memory/PooledByteBufferFactory;Lcom/facebook/imagepipeline/cache/MemoryCache;Lcom/facebook/imagepipeline/cache/MemoryCache;Lcom/facebook/common/internal/Supplier;Lcom/facebook/imagepipeline/cache/CacheKeyFactory;Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;IIZILcom/facebook/imagepipeline/core/CloseableReferenceFactory;ZILcom/facebook/imagepipeline/core/ImagePipelineConfigInterface;)V", "byteArrayPool", "imageDecoder", "progressiveJpegConfig", "downsampleEnabled", "resizeAndRotateEnabledForNetwork", "decodeCancellationEnabled", "executorSupplier", "(Landroid/content/Context;Lcom/facebook/common/memory/ByteArrayPool;Lcom/facebook/imagepipeline/decoder/ImageDecoder;Lcom/facebook/imagepipeline/decoder/ProgressiveJpegConfig;ZZZLcom/facebook/imagepipeline/core/ExecutorSupplier;Lcom/facebook/common/memory/PooledByteBufferFactory;Lcom/facebook/imagepipeline/cache/MemoryCache;Lcom/facebook/imagepipeline/cache/MemoryCache;Lcom/facebook/common/internal/Supplier;Lcom/facebook/imagepipeline/cache/CacheKeyFactory;Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;IIZILcom/facebook/imagepipeline/core/CloseableReferenceFactory;ZILcom/facebook/imagepipeline/core/ImagePipelineConfigInterface;)V", "mContentResolver", "Landroid/content/ContentResolver;", "getMContentResolver", "()Landroid/content/ContentResolver;", "setMContentResolver", "(Landroid/content/ContentResolver;)V", "mResources", "Landroid/content/res/Resources;", "getMResources", "()Landroid/content/res/Resources;", "setMResources", "(Landroid/content/res/Resources;)V", "mAssetManager", "Landroid/content/res/AssetManager;", "getMAssetManager", "()Landroid/content/res/AssetManager;", "setMAssetManager", "(Landroid/content/res/AssetManager;)V", "mPooledByteBufferFactory", "getMPooledByteBufferFactory", "()Lcom/facebook/common/memory/PooledByteBufferFactory;", "mDiskCachesStoreSupplier", "getMDiskCachesStoreSupplier", "()Lcom/facebook/common/internal/Supplier;", "mEncodedMemoryCache", "mBitmapMemoryCache", "mCacheKeyFactory", "mEncodedMemoryCacheHistory", "Lcom/facebook/imagepipeline/cache/BoundedLinkedHashSet;", "getMEncodedMemoryCacheHistory", "()Lcom/facebook/imagepipeline/cache/BoundedLinkedHashSet;", "mDiskCacheHistory", "getMDiskCacheHistory", "mPlatformBitmapFactory", "getMPlatformBitmapFactory", "()Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "mBitmapPrepareToDrawMinSizeBytes", "getMBitmapPrepareToDrawMinSizeBytes", "()I", "mBitmapPrepareToDrawMaxSizeBytes", "getMBitmapPrepareToDrawMaxSizeBytes", "mBitmapPrepareToDrawForPrefetch", "getMBitmapPrepareToDrawForPrefetch", "()Z", "setMBitmapPrepareToDrawForPrefetch", "(Z)V", "mCloseableReferenceFactory", "mMaxBitmapSize", "mKeepCancelledFetchAsLowPriority", "getMKeepCancelledFetchAsLowPriority", "mConfig", "newBitmapMemoryCacheGetProducer", "Lcom/facebook/imagepipeline/producers/BitmapMemoryCacheGetProducer;", "inputProducer", "Lcom/facebook/imagepipeline/producers/Producer;", "Lcom/facebook/common/references/CloseableReference;", "newBitmapMemoryCacheKeyMultiplexProducer", "Lcom/facebook/imagepipeline/producers/BitmapMemoryCacheKeyMultiplexProducer;", "newBitmapMemoryCacheProducer", "Lcom/facebook/imagepipeline/producers/BitmapMemoryCacheProducer;", "newDataFetchProducer", "Lcom/facebook/imagepipeline/producers/DataFetchProducer;", "newDecodeProducer", "Lcom/facebook/imagepipeline/producers/DecodeProducer;", "Lcom/facebook/imagepipeline/image/EncodedImage;", "newDiskCacheReadProducer", "Lcom/facebook/imagepipeline/producers/DiskCacheReadProducer;", "newDiskCacheWriteProducer", "Lcom/facebook/imagepipeline/producers/DiskCacheWriteProducer;", "newPartialDiskCacheProducer", "Lcom/facebook/imagepipeline/producers/PartialDiskCacheProducer;", "newEncodedCacheKeyMultiplexProducer", "Lcom/facebook/imagepipeline/producers/EncodedCacheKeyMultiplexProducer;", "newBitmapProbeProducer", "Lcom/facebook/imagepipeline/producers/BitmapProbeProducer;", "newEncodedProbeProducer", "Lcom/facebook/imagepipeline/producers/EncodedProbeProducer;", "newEncodedMemoryCacheProducer", "newLocalAssetFetchProducer", "Lcom/facebook/imagepipeline/producers/LocalAssetFetchProducer;", "newLocalContentUriFetchProducer", "Lcom/facebook/imagepipeline/producers/LocalContentUriFetchProducer;", "newLocalContentUriThumbnailFetchProducer", "Lcom/facebook/imagepipeline/producers/LocalContentUriThumbnailFetchProducer;", "newLocalExifThumbnailProducer", "Lcom/facebook/imagepipeline/producers/LocalExifThumbnailProducer;", "newThumbnailBranchProducer", "Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer;", "thumbnailProducers", "", "Lcom/facebook/imagepipeline/producers/ThumbnailProducer;", "([Lcom/facebook/imagepipeline/producers/ThumbnailProducer;)Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer;", "newLocalFileFetchProducer", "Lcom/facebook/imagepipeline/producers/LocalFileFetchProducer;", "newQualifiedResourceFetchProducer", "Lcom/facebook/imagepipeline/producers/QualifiedResourceFetchProducer;", "newLocalResourceFetchProducer", "Lcom/facebook/imagepipeline/producers/LocalResourceFetchProducer;", "newLocalVideoThumbnailProducer", "Lcom/facebook/imagepipeline/producers/LocalVideoThumbnailProducer;", "newNetworkFetchProducer", "networkFetcher", "Lcom/facebook/imagepipeline/producers/NetworkFetcher;", "newPostprocessorBitmapMemoryCacheProducer", "Lcom/facebook/imagepipeline/producers/PostprocessedBitmapMemoryCacheProducer;", "newPostprocessorProducer", "Lcom/facebook/imagepipeline/producers/PostprocessorProducer;", "newResizeAndRotateProducer", "Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;", "isResizingEnabled", "imageTranscoderFactory", "Lcom/facebook/imagepipeline/transcoder/ImageTranscoderFactory;", "newSwallowResultProducer", "Lcom/facebook/imagepipeline/producers/SwallowResultProducer;", ExifInterface.GPS_DIRECTION_TRUE, "newBackgroundThreadHandoffProducer", "inputThreadHandoffProducerQueue", "Lcom/facebook/imagepipeline/producers/ThreadHandoffProducerQueue;", "newThrottlingProducer", "Lcom/facebook/imagepipeline/producers/ThrottlingProducer;", "maxSimultaneousRequests", "", "newBitmapPrepareProducer", "Lcom/facebook/imagepipeline/producers/BitmapPrepareProducer;", "newDelayProducer", "Lcom/facebook/imagepipeline/producers/DelayProducer;", "newLocalThumbnailBitmapSdk29Producer", "Lcom/facebook/imagepipeline/producers/LocalThumbnailBitmapSdk29Producer;", "loadThumbnailFromContentResolverFirst", "loadThumbnailFromContentResolverForContentUriOnly", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/facebook/imagepipeline/producers/LocalThumbnailBitmapSdk29Producer;", "Companion", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class ProducerFactory {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private AssetManager mAssetManager;
    protected final MemoryCache<CacheKey, CloseableImage> mBitmapMemoryCache;
    private boolean mBitmapPrepareToDrawForPrefetch;
    private final int mBitmapPrepareToDrawMaxSizeBytes;
    private final int mBitmapPrepareToDrawMinSizeBytes;
    protected final ByteArrayPool mByteArrayPool;
    protected final CacheKeyFactory mCacheKeyFactory;
    protected final CloseableReferenceFactory mCloseableReferenceFactory;
    private final ImagePipelineConfigInterface mConfig;
    private ContentResolver mContentResolver;
    protected final boolean mDecodeCancellationEnabled;
    private final BoundedLinkedHashSet<CacheKey> mDiskCacheHistory;
    private final Supplier<DiskCachesStore> mDiskCachesStoreSupplier;
    protected final DownsampleMode mDownsampleMode;
    protected final MemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
    private final BoundedLinkedHashSet<CacheKey> mEncodedMemoryCacheHistory;
    protected final ExecutorSupplier mExecutorSupplier;
    protected final ImageDecoder mImageDecoder;
    private final boolean mKeepCancelledFetchAsLowPriority;
    protected final int mMaxBitmapSize;
    private final PlatformBitmapFactory mPlatformBitmapFactory;
    private final PooledByteBufferFactory mPooledByteBufferFactory;
    protected final ProgressiveJpegConfig mProgressiveJpegConfig;
    protected final boolean mResizeAndRotateEnabledForNetwork;
    private Resources mResources;

    public ProducerFactory(Context context, ByteArrayPool mByteArrayPool, ImageDecoder mImageDecoder, ProgressiveJpegConfig mProgressiveJpegConfig, DownsampleMode mDownsampleMode, boolean z, boolean z2, ExecutorSupplier mExecutorSupplier, PooledByteBufferFactory pooledByteBufferFactory, MemoryCache<CacheKey, CloseableImage> bitmapMemoryCache, MemoryCache<CacheKey, PooledByteBuffer> encodedMemoryCache, Supplier<DiskCachesStore> diskCachesStoreSupplier, CacheKeyFactory cacheKeyFactory, PlatformBitmapFactory platformBitmapFactory, int i, int i2, boolean z3, int i3, CloseableReferenceFactory closeableReferenceFactory, boolean z4, int i4, ImagePipelineConfigInterface config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mByteArrayPool, "mByteArrayPool");
        Intrinsics.checkNotNullParameter(mImageDecoder, "mImageDecoder");
        Intrinsics.checkNotNullParameter(mProgressiveJpegConfig, "mProgressiveJpegConfig");
        Intrinsics.checkNotNullParameter(mDownsampleMode, "mDownsampleMode");
        Intrinsics.checkNotNullParameter(mExecutorSupplier, "mExecutorSupplier");
        Intrinsics.checkNotNullParameter(pooledByteBufferFactory, "pooledByteBufferFactory");
        Intrinsics.checkNotNullParameter(bitmapMemoryCache, "bitmapMemoryCache");
        Intrinsics.checkNotNullParameter(encodedMemoryCache, "encodedMemoryCache");
        Intrinsics.checkNotNullParameter(diskCachesStoreSupplier, "diskCachesStoreSupplier");
        Intrinsics.checkNotNullParameter(cacheKeyFactory, "cacheKeyFactory");
        Intrinsics.checkNotNullParameter(platformBitmapFactory, "platformBitmapFactory");
        Intrinsics.checkNotNullParameter(closeableReferenceFactory, "closeableReferenceFactory");
        Intrinsics.checkNotNullParameter(config, "config");
        this.mByteArrayPool = mByteArrayPool;
        this.mImageDecoder = mImageDecoder;
        this.mProgressiveJpegConfig = mProgressiveJpegConfig;
        this.mDownsampleMode = mDownsampleMode;
        this.mResizeAndRotateEnabledForNetwork = z;
        this.mDecodeCancellationEnabled = z2;
        this.mExecutorSupplier = mExecutorSupplier;
        ContentResolver contentResolver = context.getApplicationContext().getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
        this.mContentResolver = contentResolver;
        Resources resources = context.getApplicationContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        this.mResources = resources;
        AssetManager assets = context.getApplicationContext().getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "getAssets(...)");
        this.mAssetManager = assets;
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
        this.mBitmapMemoryCache = bitmapMemoryCache;
        this.mEncodedMemoryCache = encodedMemoryCache;
        this.mDiskCachesStoreSupplier = diskCachesStoreSupplier;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mPlatformBitmapFactory = platformBitmapFactory;
        this.mEncodedMemoryCacheHistory = new BoundedLinkedHashSet<>(i4);
        this.mDiskCacheHistory = new BoundedLinkedHashSet<>(i4);
        this.mBitmapPrepareToDrawMinSizeBytes = i;
        this.mBitmapPrepareToDrawMaxSizeBytes = i2;
        this.mBitmapPrepareToDrawForPrefetch = z3;
        this.mMaxBitmapSize = i3;
        this.mCloseableReferenceFactory = closeableReferenceFactory;
        this.mKeepCancelledFetchAsLowPriority = z4;
        this.mConfig = config;
    }

    protected final ContentResolver getMContentResolver() {
        return this.mContentResolver;
    }

    protected final void setMContentResolver(ContentResolver contentResolver) {
        Intrinsics.checkNotNullParameter(contentResolver, "<set-?>");
        this.mContentResolver = contentResolver;
    }

    protected final Resources getMResources() {
        return this.mResources;
    }

    protected final void setMResources(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "<set-?>");
        this.mResources = resources;
    }

    protected final AssetManager getMAssetManager() {
        return this.mAssetManager;
    }

    protected final void setMAssetManager(AssetManager assetManager) {
        Intrinsics.checkNotNullParameter(assetManager, "<set-?>");
        this.mAssetManager = assetManager;
    }

    protected final PooledByteBufferFactory getMPooledByteBufferFactory() {
        return this.mPooledByteBufferFactory;
    }

    protected final Supplier<DiskCachesStore> getMDiskCachesStoreSupplier() {
        return this.mDiskCachesStoreSupplier;
    }

    protected final BoundedLinkedHashSet<CacheKey> getMEncodedMemoryCacheHistory() {
        return this.mEncodedMemoryCacheHistory;
    }

    protected final BoundedLinkedHashSet<CacheKey> getMDiskCacheHistory() {
        return this.mDiskCacheHistory;
    }

    protected final PlatformBitmapFactory getMPlatformBitmapFactory() {
        return this.mPlatformBitmapFactory;
    }

    protected final int getMBitmapPrepareToDrawMinSizeBytes() {
        return this.mBitmapPrepareToDrawMinSizeBytes;
    }

    protected final int getMBitmapPrepareToDrawMaxSizeBytes() {
        return this.mBitmapPrepareToDrawMaxSizeBytes;
    }

    protected final boolean getMBitmapPrepareToDrawForPrefetch() {
        return this.mBitmapPrepareToDrawForPrefetch;
    }

    protected final void setMBitmapPrepareToDrawForPrefetch(boolean z) {
        this.mBitmapPrepareToDrawForPrefetch = z;
    }

    protected final boolean getMKeepCancelledFetchAsLowPriority() {
        return this.mKeepCancelledFetchAsLowPriority;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @Deprecated(message = "")
    public ProducerFactory(Context context, ByteArrayPool byteArrayPool, ImageDecoder imageDecoder, ProgressiveJpegConfig progressiveJpegConfig, boolean z, boolean z2, boolean z3, ExecutorSupplier executorSupplier, PooledByteBufferFactory pooledByteBufferFactory, MemoryCache<CacheKey, CloseableImage> memoryCache, MemoryCache<CacheKey, PooledByteBuffer> memoryCache2, Supplier<DiskCachesStore> supplier, CacheKeyFactory cacheKeyFactory, PlatformBitmapFactory platformBitmapFactory, int i, int i2, boolean z4, int i3, CloseableReferenceFactory closeableReferenceFactory, boolean z5, int i4, ImagePipelineConfigInterface imagePipelineConfigInterface) {
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNull(byteArrayPool);
        Intrinsics.checkNotNull(imageDecoder);
        Intrinsics.checkNotNull(progressiveJpegConfig);
        DownsampleMode downsampleMode = z ? DownsampleMode.ALWAYS : DownsampleMode.AUTO;
        Intrinsics.checkNotNull(executorSupplier);
        Intrinsics.checkNotNull(pooledByteBufferFactory);
        Intrinsics.checkNotNull(memoryCache);
        Intrinsics.checkNotNull(memoryCache2);
        Intrinsics.checkNotNull(supplier);
        Intrinsics.checkNotNull(cacheKeyFactory);
        Intrinsics.checkNotNull(platformBitmapFactory);
        Intrinsics.checkNotNull(closeableReferenceFactory);
        Intrinsics.checkNotNull(imagePipelineConfigInterface);
        this(context, byteArrayPool, imageDecoder, progressiveJpegConfig, downsampleMode, z2, z3, executorSupplier, pooledByteBufferFactory, memoryCache, memoryCache2, supplier, cacheKeyFactory, platformBitmapFactory, i, i2, z4, i3, closeableReferenceFactory, z5, i4, imagePipelineConfigInterface);
    }

    public final BitmapMemoryCacheGetProducer newBitmapMemoryCacheGetProducer(Producer<CloseableReference<CloseableImage>> inputProducer) {
        Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
        return new BitmapMemoryCacheGetProducer(this.mBitmapMemoryCache, this.mCacheKeyFactory, inputProducer);
    }

    public final BitmapMemoryCacheKeyMultiplexProducer newBitmapMemoryCacheKeyMultiplexProducer(Producer<CloseableReference<CloseableImage>> inputProducer) {
        Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
        return new BitmapMemoryCacheKeyMultiplexProducer(this.mCacheKeyFactory, inputProducer, this.mConfig);
    }

    public final BitmapMemoryCacheProducer newBitmapMemoryCacheProducer(Producer<CloseableReference<CloseableImage>> inputProducer) {
        Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
        return new BitmapMemoryCacheProducer(this.mBitmapMemoryCache, this.mCacheKeyFactory, inputProducer);
    }

    public final DataFetchProducer newDataFetchProducer() {
        return new DataFetchProducer(this.mPooledByteBufferFactory);
    }

    public DecodeProducer newDecodeProducer(Producer<EncodedImage> inputProducer) {
        Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
        ByteArrayPool byteArrayPool = this.mByteArrayPool;
        Executor decodeExecutor = this.mExecutorSupplier.getDecodeExecutor();
        ImageDecoder imageDecoder = this.mImageDecoder;
        ProgressiveJpegConfig progressiveJpegConfig = this.mProgressiveJpegConfig;
        DownsampleMode downsampleMode = this.mDownsampleMode;
        boolean z = this.mResizeAndRotateEnabledForNetwork;
        boolean z2 = this.mDecodeCancellationEnabled;
        int i = this.mMaxBitmapSize;
        CloseableReferenceFactory closeableReferenceFactory = this.mCloseableReferenceFactory;
        Supplier<Boolean> BOOLEAN_FALSE = Suppliers.BOOLEAN_FALSE;
        Intrinsics.checkNotNullExpressionValue(BOOLEAN_FALSE, "BOOLEAN_FALSE");
        return new DecodeProducer(byteArrayPool, decodeExecutor, imageDecoder, progressiveJpegConfig, downsampleMode, z, z2, inputProducer, i, closeableReferenceFactory, null, BOOLEAN_FALSE, null);
    }

    public final DiskCacheReadProducer newDiskCacheReadProducer(Producer<EncodedImage> inputProducer) {
        Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
        return new DiskCacheReadProducer(this.mDiskCachesStoreSupplier, this.mCacheKeyFactory, inputProducer);
    }

    public final DiskCacheWriteProducer newDiskCacheWriteProducer(Producer<EncodedImage> inputProducer) {
        Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
        return new DiskCacheWriteProducer(this.mDiskCachesStoreSupplier, this.mCacheKeyFactory, inputProducer);
    }

    public final PartialDiskCacheProducer newPartialDiskCacheProducer(Producer<EncodedImage> inputProducer) {
        Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
        return new PartialDiskCacheProducer(this.mDiskCachesStoreSupplier, this.mCacheKeyFactory, this.mPooledByteBufferFactory, this.mByteArrayPool, inputProducer);
    }

    public EncodedCacheKeyMultiplexProducer newEncodedCacheKeyMultiplexProducer(Producer<EncodedImage> inputProducer) {
        Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
        return new EncodedCacheKeyMultiplexProducer(this.mCacheKeyFactory, this.mKeepCancelledFetchAsLowPriority, inputProducer, this.mConfig);
    }

    public final BitmapProbeProducer newBitmapProbeProducer(Producer<CloseableReference<CloseableImage>> inputProducer) {
        Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
        return new BitmapProbeProducer(this.mEncodedMemoryCache, this.mDiskCachesStoreSupplier, this.mCacheKeyFactory, this.mEncodedMemoryCacheHistory, this.mDiskCacheHistory, inputProducer);
    }

    public final EncodedProbeProducer newEncodedProbeProducer(Producer<EncodedImage> inputProducer) {
        Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
        return new EncodedProbeProducer(this.mDiskCachesStoreSupplier, this.mCacheKeyFactory, this.mEncodedMemoryCacheHistory, this.mDiskCacheHistory, inputProducer);
    }

    public Producer<EncodedImage> newEncodedMemoryCacheProducer(Producer<EncodedImage> inputProducer) {
        Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
        return new EncodedMemoryCacheProducer(this.mEncodedMemoryCache, this.mCacheKeyFactory, inputProducer);
    }

    public final LocalAssetFetchProducer newLocalAssetFetchProducer() {
        return new LocalAssetFetchProducer(this.mExecutorSupplier.getIoBoundExecutor(), this.mPooledByteBufferFactory, this.mAssetManager);
    }

    public final LocalContentUriFetchProducer newLocalContentUriFetchProducer() {
        return new LocalContentUriFetchProducer(this.mExecutorSupplier.getIoBoundExecutor(), this.mPooledByteBufferFactory, this.mContentResolver);
    }

    public final LocalContentUriThumbnailFetchProducer newLocalContentUriThumbnailFetchProducer() {
        return new LocalContentUriThumbnailFetchProducer(this.mExecutorSupplier.getIoBoundExecutor(), this.mPooledByteBufferFactory, this.mContentResolver);
    }

    public final LocalExifThumbnailProducer newLocalExifThumbnailProducer() {
        return new LocalExifThumbnailProducer(this.mExecutorSupplier.forThumbnailProducer(), this.mPooledByteBufferFactory, this.mContentResolver);
    }

    public final ThumbnailBranchProducer newThumbnailBranchProducer(ThumbnailProducer<EncodedImage>[] thumbnailProducers) {
        Intrinsics.checkNotNullParameter(thumbnailProducers, "thumbnailProducers");
        return new ThumbnailBranchProducer((ThumbnailProducer[]) Arrays.copyOf(thumbnailProducers, thumbnailProducers.length));
    }

    public final LocalFileFetchProducer newLocalFileFetchProducer() {
        return new LocalFileFetchProducer(this.mExecutorSupplier.getIoBoundExecutor(), this.mPooledByteBufferFactory);
    }

    public final QualifiedResourceFetchProducer newQualifiedResourceFetchProducer() {
        return new QualifiedResourceFetchProducer(this.mExecutorSupplier.getIoBoundExecutor(), this.mPooledByteBufferFactory, this.mContentResolver);
    }

    public final LocalResourceFetchProducer newLocalResourceFetchProducer() {
        return new LocalResourceFetchProducer(this.mExecutorSupplier.getIoBoundExecutor(), this.mPooledByteBufferFactory, this.mResources);
    }

    public final LocalVideoThumbnailProducer newLocalVideoThumbnailProducer() {
        return new LocalVideoThumbnailProducer(this.mExecutorSupplier.getIoBoundExecutor(), this.mContentResolver);
    }

    public Producer<EncodedImage> newNetworkFetchProducer(NetworkFetcher<?> networkFetcher) {
        Intrinsics.checkNotNullParameter(networkFetcher, "networkFetcher");
        return new NetworkFetchProducer(this.mPooledByteBufferFactory, this.mByteArrayPool, networkFetcher);
    }

    public final PostprocessedBitmapMemoryCacheProducer newPostprocessorBitmapMemoryCacheProducer(Producer<CloseableReference<CloseableImage>> inputProducer) {
        Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
        return new PostprocessedBitmapMemoryCacheProducer(this.mBitmapMemoryCache, this.mCacheKeyFactory, inputProducer);
    }

    public final PostprocessorProducer newPostprocessorProducer(Producer<CloseableReference<CloseableImage>> inputProducer) {
        Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
        return new PostprocessorProducer(inputProducer, this.mPlatformBitmapFactory, this.mExecutorSupplier.getBackgroundExecutor());
    }

    public final ResizeAndRotateProducer newResizeAndRotateProducer(Producer<EncodedImage> inputProducer, boolean isResizingEnabled, ImageTranscoderFactory imageTranscoderFactory) {
        Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
        Executor backgroundExecutor = this.mExecutorSupplier.getBackgroundExecutor();
        PooledByteBufferFactory pooledByteBufferFactory = this.mPooledByteBufferFactory;
        Intrinsics.checkNotNull(imageTranscoderFactory);
        return new ResizeAndRotateProducer(backgroundExecutor, pooledByteBufferFactory, inputProducer, isResizingEnabled, imageTranscoderFactory);
    }

    public final <T> SwallowResultProducer<T> newSwallowResultProducer(Producer<T> inputProducer) {
        Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
        return new SwallowResultProducer<>(inputProducer);
    }

    public <T> Producer<T> newBackgroundThreadHandoffProducer(Producer<T> inputProducer, ThreadHandoffProducerQueue inputThreadHandoffProducerQueue) {
        Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
        Intrinsics.checkNotNullParameter(inputThreadHandoffProducerQueue, "inputThreadHandoffProducerQueue");
        return new ThreadHandoffProducer(inputProducer, inputThreadHandoffProducerQueue);
    }

    public final <T> ThrottlingProducer<T> newThrottlingProducer(long maxSimultaneousRequests, Producer<T> inputProducer) {
        Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
        return new ThrottlingProducer<>(maxSimultaneousRequests, this.mExecutorSupplier.getLightWeightBackgroundExecutor(), inputProducer);
    }

    public final BitmapPrepareProducer newBitmapPrepareProducer(Producer<CloseableReference<CloseableImage>> inputProducer) {
        Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
        return new BitmapPrepareProducer(inputProducer, this.mBitmapPrepareToDrawMinSizeBytes, this.mBitmapPrepareToDrawMaxSizeBytes, this.mBitmapPrepareToDrawForPrefetch);
    }

    public final DelayProducer newDelayProducer(Producer<CloseableReference<CloseableImage>> inputProducer) {
        Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
        return new DelayProducer(inputProducer, this.mExecutorSupplier.getBackgroundScheduledExecutorService());
    }

    public final LocalThumbnailBitmapSdk29Producer newLocalThumbnailBitmapSdk29Producer(Boolean loadThumbnailFromContentResolverFirst, Boolean loadThumbnailFromContentResolverForContentUriOnly) {
        Executor backgroundExecutor = this.mExecutorSupplier.getBackgroundExecutor();
        ContentResolver contentResolver = this.mContentResolver;
        Intrinsics.checkNotNull(loadThumbnailFromContentResolverFirst);
        Intrinsics.checkNotNull(loadThumbnailFromContentResolverForContentUriOnly);
        return new LocalThumbnailBitmapSdk29Producer(backgroundExecutor, contentResolver, loadThumbnailFromContentResolverFirst, loadThumbnailFromContentResolverForContentUriOnly);
    }

    /* JADX INFO: compiled from: ProducerFactory.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\"\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¨\u0006\r"}, d2 = {"Lcom/facebook/imagepipeline/core/ProducerFactory$Companion;", "", "<init>", "()V", "newAddImageTransformMetaDataProducer", "Lcom/facebook/imagepipeline/producers/AddImageTransformMetaDataProducer;", "inputProducer", "Lcom/facebook/imagepipeline/producers/Producer;", "Lcom/facebook/imagepipeline/image/EncodedImage;", "newBranchOnSeparateImagesProducer", "Lcom/facebook/imagepipeline/producers/BranchOnSeparateImagesProducer;", "inputProducer1", "inputProducer2", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AddImageTransformMetaDataProducer newAddImageTransformMetaDataProducer(Producer<EncodedImage> inputProducer) {
            Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
            return new AddImageTransformMetaDataProducer(inputProducer);
        }

        public final BranchOnSeparateImagesProducer newBranchOnSeparateImagesProducer(Producer<EncodedImage> inputProducer1, Producer<EncodedImage> inputProducer2) {
            Intrinsics.checkNotNullParameter(inputProducer1, "inputProducer1");
            Intrinsics.checkNotNullParameter(inputProducer2, "inputProducer2");
            return new BranchOnSeparateImagesProducer(inputProducer1, inputProducer2);
        }
    }
}

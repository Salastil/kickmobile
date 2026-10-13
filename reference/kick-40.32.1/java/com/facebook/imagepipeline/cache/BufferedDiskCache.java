package com.facebook.imagepipeline.cache;

import bolts.Task;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.instrumentation.FrescoInstrumenter;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import io.ktor.http.ContentDisposition;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BufferedDiskCache.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 82\u00020\u0001:\u000278BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018J\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001a2\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001a2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u000e\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018J\u001f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 H\u0086\u0002J\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u001a2\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010#\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010%\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u001e\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0016\u0010'\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u001eJ\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020\"0\u001a2\u0006\u0010\u0017\u001a\u00020\u0018J\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\"0\u001aJ\u001e\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00100\u001a\u00020\u001eH\u0002J\u0012\u00101\u001a\u0004\u0018\u0001022\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u001a\u00103\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010(\u001a\u0004\u0018\u00010\u001eH\u0002J\u0018\u00104\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00105\u001a\u00020\u001eH\u0002J\u0018\u00106\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00105\u001a\u00020\u001eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010+\u001a\u00020,8F¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u00069"}, d2 = {"Lcom/facebook/imagepipeline/cache/BufferedDiskCache;", "", "fileCache", "Lcom/facebook/cache/disk/FileCache;", "pooledByteBufferFactory", "Lcom/facebook/common/memory/PooledByteBufferFactory;", "pooledByteStreams", "Lcom/facebook/common/memory/PooledByteStreams;", "readExecutor", "Ljava/util/concurrent/Executor;", "writeExecutor", "imageCacheStatsTracker", "Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;", "preserveMetadata", "", "preserveMetadataDuringStartup", "isAppStarting", "Lkotlin/Function0;", "<init>", "(Lcom/facebook/cache/disk/FileCache;Lcom/facebook/common/memory/PooledByteBufferFactory;Lcom/facebook/common/memory/PooledByteStreams;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;ZZLkotlin/jvm/functions/Function0;)V", "stagingArea", "Lcom/facebook/imagepipeline/cache/StagingArea;", "containsSync", "key", "Lcom/facebook/cache/common/CacheKey;", "contains", "Lbolts/Task;", "containsAsync", "diskCheckSync", "get", "Lcom/facebook/imagepipeline/image/EncodedImage;", "isCancelled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "probe", "Ljava/lang/Void;", "addKeyForAsyncProbing", "", "checkInStagingAreaAndFileCache", "getAsync", "put", "encodedImage", "remove", "clearAll", ContentDisposition.Parameters.Size, "", "getSize", "()J", "foundPinnedImage", "pinnedImage", "readFromDiskCache", "Lcom/facebook/imagepipeline/cache/BufferedDiskCache$DiskCacheReadResult;", "writeToDiskCache", "maybeSaveMetadata", "image", "maybeRestoreMetadata", "DiskCacheReadResult", "Companion", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BufferedDiskCache {
    private static final Class<?> TAG = BufferedDiskCache.class;
    private final FileCache fileCache;
    private final ImageCacheStatsTracker imageCacheStatsTracker;
    private final Function0<Boolean> isAppStarting;
    private final PooledByteBufferFactory pooledByteBufferFactory;
    private final PooledByteStreams pooledByteStreams;
    private final boolean preserveMetadata;
    private final boolean preserveMetadataDuringStartup;
    private final Executor readExecutor;
    private final StagingArea stagingArea;
    private final Executor writeExecutor;

    public BufferedDiskCache(FileCache fileCache, PooledByteBufferFactory pooledByteBufferFactory, PooledByteStreams pooledByteStreams, Executor readExecutor, Executor writeExecutor, ImageCacheStatsTracker imageCacheStatsTracker, boolean z, boolean z2, Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(fileCache, "fileCache");
        Intrinsics.checkNotNullParameter(pooledByteBufferFactory, "pooledByteBufferFactory");
        Intrinsics.checkNotNullParameter(pooledByteStreams, "pooledByteStreams");
        Intrinsics.checkNotNullParameter(readExecutor, "readExecutor");
        Intrinsics.checkNotNullParameter(writeExecutor, "writeExecutor");
        Intrinsics.checkNotNullParameter(imageCacheStatsTracker, "imageCacheStatsTracker");
        this.fileCache = fileCache;
        this.pooledByteBufferFactory = pooledByteBufferFactory;
        this.pooledByteStreams = pooledByteStreams;
        this.readExecutor = readExecutor;
        this.writeExecutor = writeExecutor;
        this.imageCacheStatsTracker = imageCacheStatsTracker;
        this.preserveMetadata = z;
        this.preserveMetadataDuringStartup = z2;
        this.isAppStarting = function0;
        StagingArea stagingArea = StagingArea.getInstance();
        Intrinsics.checkNotNullExpressionValue(stagingArea, "getInstance(...)");
        this.stagingArea = stagingArea;
    }

    public final boolean containsSync(CacheKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.stagingArea.containsKey(key) || this.fileCache.hasKeySync(key);
    }

    public final Task<Boolean> contains(CacheKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (containsSync(key)) {
            Task<Boolean> taskForResult = Task.forResult(true);
            Intrinsics.checkNotNull(taskForResult);
            return taskForResult;
        }
        return containsAsync(key);
    }

    private final Task<Boolean> containsAsync(final CacheKey key) {
        try {
            final Object objOnBeforeSubmitWork = FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_containsAsync");
            Task<Boolean> taskCall = Task.call(new Callable() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return BufferedDiskCache.containsAsync$lambda$0(objOnBeforeSubmitWork, this, key);
                }
            }, this.readExecutor);
            Intrinsics.checkNotNull(taskCall);
            return taskCall;
        } catch (Exception e) {
            FLog.w(TAG, e, "Failed to schedule disk-cache read for %s", key.getAnimationUriString());
            Task<Boolean> taskForError = Task.forError(e);
            Intrinsics.checkNotNull(taskForError);
            return taskForError;
        }
    }

    static final Boolean containsAsync$lambda$0(Object obj, BufferedDiskCache bufferedDiskCache, CacheKey cacheKey) {
        Object objOnBeginWork = FrescoInstrumenter.onBeginWork(obj, null);
        try {
            Boolean boolValueOf = Boolean.valueOf(bufferedDiskCache.checkInStagingAreaAndFileCache(cacheKey));
            FrescoInstrumenter.onEndWork(objOnBeginWork);
            return boolValueOf;
        } catch (Throwable th) {
            try {
                FrescoInstrumenter.markFailure(obj, th);
                throw th;
            } catch (Throwable th2) {
                FrescoInstrumenter.onEndWork(objOnBeginWork);
                throw th2;
            }
        }
    }

    public final boolean diskCheckSync(CacheKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (containsSync(key)) {
            return true;
        }
        return checkInStagingAreaAndFileCache(key);
    }

    public final Task<EncodedImage> get(CacheKey key, AtomicBoolean isCancelled) {
        Task<EncodedImage> async;
        Task<EncodedImage> taskFoundPinnedImage;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(isCancelled, "isCancelled");
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            EncodedImage encodedImage = this.stagingArea.get(key);
            return (encodedImage == null || (taskFoundPinnedImage = foundPinnedImage(key, encodedImage)) == null) ? getAsync(key, isCancelled) : taskFoundPinnedImage;
        }
        FrescoSystrace.beginSection("BufferedDiskCache#get");
        try {
            EncodedImage encodedImage2 = this.stagingArea.get(key);
            if (encodedImage2 == null || (async = foundPinnedImage(key, encodedImage2)) == null) {
                async = getAsync(key, isCancelled);
            }
            return async;
        } finally {
            FrescoSystrace.endSection();
        }
    }

    public final Task<Void> probe(final CacheKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            final Object objOnBeforeSubmitWork = FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_probe");
            Task<Void> taskCall = Task.call(new Callable() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache$$ExternalSyntheticLambda5
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return BufferedDiskCache.probe$lambda$3(objOnBeforeSubmitWork, this, key);
                }
            }, this.writeExecutor);
            Intrinsics.checkNotNull(taskCall);
            return taskCall;
        } catch (Exception e) {
            FLog.w(TAG, e, "Failed to schedule disk-cache probe for %s", key.getAnimationUriString());
            Task<Void> taskForError = Task.forError(e);
            Intrinsics.checkNotNull(taskForError);
            return taskForError;
        }
    }

    static final Void probe$lambda$3(Object obj, BufferedDiskCache bufferedDiskCache, CacheKey cacheKey) {
        Object objOnBeginWork = FrescoInstrumenter.onBeginWork(obj, null);
        try {
            bufferedDiskCache.fileCache.probe(cacheKey);
            return null;
        } finally {
            FrescoInstrumenter.onEndWork(objOnBeginWork);
        }
    }

    public final void addKeyForAsyncProbing(CacheKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.fileCache.probe(key);
    }

    private final boolean checkInStagingAreaAndFileCache(CacheKey key) {
        EncodedImage encodedImage = this.stagingArea.get(key);
        if (encodedImage != null) {
            encodedImage.close();
            FLog.v(TAG, "Found image for %s in staging area", key.getAnimationUriString());
            this.imageCacheStatsTracker.onStagingAreaHit(key);
            return true;
        }
        FLog.v(TAG, "Did not find image for %s in staging area", key.getAnimationUriString());
        this.imageCacheStatsTracker.onStagingAreaMiss(key);
        try {
            return this.fileCache.hasKey(key);
        } catch (Exception unused) {
            return false;
        }
    }

    private final Task<EncodedImage> getAsync(final CacheKey key, final AtomicBoolean isCancelled) {
        try {
            final Object objOnBeforeSubmitWork = FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_getAsync");
            Task<EncodedImage> taskCall = Task.call(new Callable() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache$$ExternalSyntheticLambda2
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return BufferedDiskCache.getAsync$lambda$4(objOnBeforeSubmitWork, isCancelled, this, key);
                }
            }, this.readExecutor);
            Intrinsics.checkNotNull(taskCall);
            return taskCall;
        } catch (Exception e) {
            FLog.w(TAG, e, "Failed to schedule disk-cache read for %s", key.getAnimationUriString());
            Task<EncodedImage> taskForError = Task.forError(e);
            Intrinsics.checkNotNull(taskForError);
            return taskForError;
        }
    }

    static final EncodedImage getAsync$lambda$4(Object obj, AtomicBoolean atomicBoolean, BufferedDiskCache bufferedDiskCache, CacheKey cacheKey) {
        Object objOnBeginWork = FrescoInstrumenter.onBeginWork(obj, null);
        try {
            if (atomicBoolean.get()) {
                throw new CancellationException();
            }
            EncodedImage encodedImage = bufferedDiskCache.stagingArea.get(cacheKey);
            if (encodedImage != null) {
                FLog.v(TAG, "Found image for %s in staging area", cacheKey.getAnimationUriString());
                bufferedDiskCache.imageCacheStatsTracker.onStagingAreaHit(cacheKey);
            } else {
                FLog.v(TAG, "Did not find image for %s in staging area", cacheKey.getAnimationUriString());
                bufferedDiskCache.imageCacheStatsTracker.onStagingAreaMiss(cacheKey);
                try {
                    DiskCacheReadResult fromDiskCache = bufferedDiskCache.readFromDiskCache(cacheKey);
                    if (fromDiskCache == null) {
                        FrescoInstrumenter.onEndWork(objOnBeginWork);
                        return null;
                    }
                    CloseableReference closeableReferenceOf = CloseableReference.of(fromDiskCache.getBuffer());
                    Intrinsics.checkNotNullExpressionValue(closeableReferenceOf, "of(...)");
                    try {
                        EncodedImage encodedImage2 = new EncodedImage((CloseableReference<PooledByteBuffer>) closeableReferenceOf);
                        bufferedDiskCache.maybeRestoreMetadata(cacheKey, encodedImage2);
                        if (fromDiskCache.getOriginSubcategory() != null) {
                            encodedImage2.putExtra("origin_sub", fromDiskCache.getOriginSubcategory());
                        }
                        CloseableReference.closeSafely((CloseableReference<?>) closeableReferenceOf);
                        encodedImage = encodedImage2;
                    } catch (Throwable th) {
                        CloseableReference.closeSafely((CloseableReference<?>) closeableReferenceOf);
                        throw th;
                    }
                } catch (Exception unused) {
                    FrescoInstrumenter.onEndWork(objOnBeginWork);
                    return null;
                }
            }
            if (!Thread.interrupted()) {
                FrescoInstrumenter.onEndWork(objOnBeginWork);
                return encodedImage;
            }
            FLog.v(TAG, "Host thread was interrupted, decreasing reference count");
            encodedImage.close();
            throw new InterruptedException();
        } catch (Throwable th2) {
            try {
                FrescoInstrumenter.markFailure(obj, th2);
                throw th2;
            } catch (Throwable th3) {
                FrescoInstrumenter.onEndWork(objOnBeginWork);
                throw th3;
            }
        }
    }

    public final void put(final CacheKey key, EncodedImage encodedImage) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            if (!EncodedImage.isValid(encodedImage)) {
                throw new IllegalStateException("Check failed.");
            }
            this.stagingArea.put(key, encodedImage);
            final EncodedImage encodedImageCloneOrNull = EncodedImage.cloneOrNull(encodedImage);
            try {
                final Object objOnBeforeSubmitWork = FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_putAsync");
                this.writeExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        BufferedDiskCache.put$lambda$6$lambda$5(objOnBeforeSubmitWork, this, key, encodedImageCloneOrNull);
                    }
                });
                return;
            } catch (Exception e) {
                FLog.w(TAG, e, "Failed to schedule disk-cache write for %s", key.getAnimationUriString());
                this.stagingArea.remove(key, encodedImage);
                EncodedImage.closeSafely(encodedImageCloneOrNull);
                return;
            }
        }
        FrescoSystrace.beginSection("BufferedDiskCache#put");
        try {
            if (!EncodedImage.isValid(encodedImage)) {
                throw new IllegalStateException("Check failed.");
            }
            this.stagingArea.put(key, encodedImage);
            final EncodedImage encodedImageCloneOrNull2 = EncodedImage.cloneOrNull(encodedImage);
            try {
                final Object objOnBeforeSubmitWork2 = FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_putAsync");
                this.writeExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        BufferedDiskCache.put$lambda$6$lambda$5(objOnBeforeSubmitWork2, this, key, encodedImageCloneOrNull2);
                    }
                });
            } catch (Exception e2) {
                FLog.w(TAG, e2, "Failed to schedule disk-cache write for %s", key.getAnimationUriString());
                this.stagingArea.remove(key, encodedImage);
                EncodedImage.closeSafely(encodedImageCloneOrNull2);
            }
            Unit unit = Unit.INSTANCE;
            FrescoSystrace.endSection();
        } catch (Throwable th) {
            FrescoSystrace.endSection();
            throw th;
        }
    }

    static final void put$lambda$6$lambda$5(Object obj, BufferedDiskCache bufferedDiskCache, CacheKey cacheKey, EncodedImage encodedImage) {
        Object objOnBeginWork = FrescoInstrumenter.onBeginWork(obj, null);
        try {
            bufferedDiskCache.writeToDiskCache(cacheKey, encodedImage);
            StagingArea stagingArea = bufferedDiskCache.stagingArea;
            Intrinsics.checkNotNull(encodedImage);
            stagingArea.remove(cacheKey, encodedImage);
            EncodedImage.closeSafely(encodedImage);
            FrescoInstrumenter.onEndWork(objOnBeginWork);
        } catch (Throwable th) {
            try {
                FrescoInstrumenter.markFailure(obj, th);
                throw th;
            } catch (Throwable th2) {
                StagingArea stagingArea2 = bufferedDiskCache.stagingArea;
                Intrinsics.checkNotNull(encodedImage);
                stagingArea2.remove(cacheKey, encodedImage);
                EncodedImage.closeSafely(encodedImage);
                FrescoInstrumenter.onEndWork(objOnBeginWork);
                throw th2;
            }
        }
    }

    public final Task<Void> remove(final CacheKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.stagingArea.remove(key);
        try {
            final Object objOnBeforeSubmitWork = FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_remove");
            Task<Void> taskCall = Task.call(new Callable() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache$$ExternalSyntheticLambda3
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return BufferedDiskCache.remove$lambda$7(objOnBeforeSubmitWork, this, key);
                }
            }, this.writeExecutor);
            Intrinsics.checkNotNull(taskCall);
            return taskCall;
        } catch (Exception e) {
            FLog.w(TAG, e, "Failed to schedule disk-cache remove for %s", key.getAnimationUriString());
            Task<Void> taskForError = Task.forError(e);
            Intrinsics.checkNotNull(taskForError);
            return taskForError;
        }
    }

    static final Void remove$lambda$7(Object obj, BufferedDiskCache bufferedDiskCache, CacheKey cacheKey) {
        Object objOnBeginWork = FrescoInstrumenter.onBeginWork(obj, null);
        try {
            bufferedDiskCache.stagingArea.remove(cacheKey);
            bufferedDiskCache.fileCache.remove(cacheKey);
            FrescoInstrumenter.onEndWork(objOnBeginWork);
            return null;
        } catch (Throwable th) {
            try {
                FrescoInstrumenter.markFailure(obj, th);
                throw th;
            } catch (Throwable th2) {
                FrescoInstrumenter.onEndWork(objOnBeginWork);
                throw th2;
            }
        }
    }

    public final Task<Void> clearAll() {
        this.stagingArea.clearAll();
        final Object objOnBeforeSubmitWork = FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_clearAll");
        try {
            Task<Void> taskCall = Task.call(new Callable() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache$$ExternalSyntheticLambda4
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return BufferedDiskCache.clearAll$lambda$8(objOnBeforeSubmitWork, this);
                }
            }, this.writeExecutor);
            Intrinsics.checkNotNull(taskCall);
            return taskCall;
        } catch (Exception e) {
            FLog.w(TAG, e, "Failed to schedule disk-cache clear", new Object[0]);
            Task<Void> taskForError = Task.forError(e);
            Intrinsics.checkNotNull(taskForError);
            return taskForError;
        }
    }

    static final Void clearAll$lambda$8(Object obj, BufferedDiskCache bufferedDiskCache) {
        Object objOnBeginWork = FrescoInstrumenter.onBeginWork(obj, null);
        try {
            bufferedDiskCache.stagingArea.clearAll();
            bufferedDiskCache.fileCache.clearAll();
            FrescoInstrumenter.onEndWork(objOnBeginWork);
            return null;
        } catch (Throwable th) {
            try {
                FrescoInstrumenter.markFailure(obj, th);
                throw th;
            } catch (Throwable th2) {
                FrescoInstrumenter.onEndWork(objOnBeginWork);
                throw th2;
            }
        }
    }

    public final long getSize() {
        return this.fileCache.getSize();
    }

    private final Task<EncodedImage> foundPinnedImage(CacheKey key, EncodedImage pinnedImage) {
        FLog.v(TAG, "Found image for %s in staging area", key.getAnimationUriString());
        this.imageCacheStatsTracker.onStagingAreaHit(key);
        Task<EncodedImage> taskForResult = Task.forResult(pinnedImage);
        Intrinsics.checkNotNullExpressionValue(taskForResult, "forResult(...)");
        return taskForResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: BufferedDiskCache.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/facebook/imagepipeline/cache/BufferedDiskCache$DiskCacheReadResult;", "", "buffer", "Lcom/facebook/common/memory/PooledByteBuffer;", "originSubcategory", "", "<init>", "(Lcom/facebook/common/memory/PooledByteBuffer;Ljava/lang/String;)V", "getBuffer", "()Lcom/facebook/common/memory/PooledByteBuffer;", "getOriginSubcategory", "()Ljava/lang/String;", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    static final class DiskCacheReadResult {
        private final PooledByteBuffer buffer;
        private final String originSubcategory;

        public DiskCacheReadResult(PooledByteBuffer buffer, String str) {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            this.buffer = buffer;
            this.originSubcategory = str;
        }

        public /* synthetic */ DiskCacheReadResult(PooledByteBuffer pooledByteBuffer, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(pooledByteBuffer, (i & 2) != 0 ? null : str);
        }

        public final PooledByteBuffer getBuffer() {
            return this.buffer;
        }

        public final String getOriginSubcategory() {
            return this.originSubcategory;
        }
    }

    private final DiskCacheReadResult readFromDiskCache(CacheKey key) throws IOException {
        try {
            Class<?> cls = TAG;
            FLog.v(cls, "Disk cache read for %s", key.getAnimationUriString());
            BinaryResource resource = this.fileCache.getResource(key);
            if (resource == null) {
                FLog.v(cls, "Disk cache miss for %s", key.getAnimationUriString());
                this.imageCacheStatsTracker.onDiskCacheMiss(key);
                return null;
            }
            FLog.v(cls, "Found entry in disk cache for %s", key.getAnimationUriString());
            this.imageCacheStatsTracker.onDiskCacheHit(key);
            String extra = resource.getExtra("origin_sub");
            InputStream inputStreamOpenStream = resource.openStream();
            try {
                PooledByteBuffer pooledByteBufferNewByteBuffer = this.pooledByteBufferFactory.newByteBuffer(inputStreamOpenStream, (int) resource.size());
                inputStreamOpenStream.close();
                FLog.v(cls, "Successful read from disk cache for %s", key.getAnimationUriString());
                Intrinsics.checkNotNull(pooledByteBufferNewByteBuffer);
                return new DiskCacheReadResult(pooledByteBufferNewByteBuffer, extra);
            } catch (Throwable th) {
                inputStreamOpenStream.close();
                throw th;
            }
        } catch (IOException e) {
            FLog.w(TAG, e, "Exception reading from cache for %s", key.getAnimationUriString());
            this.imageCacheStatsTracker.onDiskCacheGetFail(key);
            throw e;
        }
    }

    private final void writeToDiskCache(final CacheKey key, final EncodedImage encodedImage) {
        Class<?> cls = TAG;
        FLog.v(cls, "About to write to disk-cache for key %s", key.getAnimationUriString());
        try {
            this.fileCache.insert(key, new WriterCallback() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache$$ExternalSyntheticLambda6
                @Override // com.facebook.cache.common.WriterCallback
                public final void write(OutputStream outputStream) throws IOException {
                    BufferedDiskCache.writeToDiskCache$lambda$9(encodedImage, this, key, outputStream);
                }
            });
            this.imageCacheStatsTracker.onDiskCachePut(key);
            FLog.v(cls, "Successful disk-cache write for key %s", key.getAnimationUriString());
        } catch (IOException e) {
            FLog.w(TAG, e, "Failed to write to disk-cache for key %s", key.getAnimationUriString());
        }
    }

    static final void writeToDiskCache$lambda$9(EncodedImage encodedImage, BufferedDiskCache bufferedDiskCache, CacheKey cacheKey, OutputStream os) throws IOException {
        Intrinsics.checkNotNullParameter(os, "os");
        Intrinsics.checkNotNull(encodedImage);
        InputStream inputStream = encodedImage.getInputStream();
        if (inputStream == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        bufferedDiskCache.pooledByteStreams.copy(inputStream, os);
        bufferedDiskCache.maybeSaveMetadata(cacheKey, encodedImage);
    }

    private final void maybeSaveMetadata(CacheKey key, EncodedImage image) {
        String str;
        Function0<Boolean> function0;
        if ((this.preserveMetadataDuringStartup || (function0 = this.isAppStarting) == null || !function0.invoke().booleanValue()) && this.preserveMetadata && (str = (String) image.getExtra("smart_query")) != null) {
            this.fileCache.setMetadata(key, str);
        }
    }

    private final void maybeRestoreMetadata(CacheKey key, EncodedImage image) {
        String metadata;
        Function0<Boolean> function0;
        if ((this.preserveMetadataDuringStartup || (function0 = this.isAppStarting) == null || !function0.invoke().booleanValue()) && this.preserveMetadata && (metadata = this.fileCache.getMetadata(key)) != null) {
            image.putExtra("smart_query", metadata);
        }
    }
}

package com.facebook.imagepipeline.memory;

import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.imagepipeline.core.NativeCodeSetup;
import java.lang.reflect.InvocationTargetException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PoolFactory.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\"\u001a\u00020!2\u0006\u0010%\u001a\u00020\u0017J\u0012\u00105\u001a\u0004\u0018\u00010\r2\u0006\u0010%\u001a\u00020\u0017H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001b\u0010\u000fR\u001d\u0010\u001d\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001e\u0010\u000fR\u0011\u0010 \u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020'8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u000b\u001a\u0004\b(\u0010)R\u001b\u0010+\u001a\u00020,8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u000b\u001a\u0004\b-\u0010.R\u001b\u00100\u001a\u0002018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u000b\u001a\u0004\b2\u00103¨\u00066"}, d2 = {"Lcom/facebook/imagepipeline/memory/PoolFactory;", "", "config", "Lcom/facebook/imagepipeline/memory/PoolConfig;", "<init>", "(Lcom/facebook/imagepipeline/memory/PoolConfig;)V", "bitmapPool", "Lcom/facebook/imagepipeline/memory/BitmapPool;", "getBitmapPool", "()Lcom/facebook/imagepipeline/memory/BitmapPool;", "bitmapPool$delegate", "Lkotlin/Lazy;", "bufferMemoryChunkPool", "Lcom/facebook/imagepipeline/memory/MemoryChunkPool;", "getBufferMemoryChunkPool", "()Lcom/facebook/imagepipeline/memory/MemoryChunkPool;", "bufferMemoryChunkPool$delegate", "flexByteArrayPool", "Lcom/facebook/imagepipeline/memory/FlexByteArrayPool;", "getFlexByteArrayPool", "()Lcom/facebook/imagepipeline/memory/FlexByteArrayPool;", "flexByteArrayPool$delegate", "flexByteArrayPoolMaxNumThreads", "", "getFlexByteArrayPoolMaxNumThreads", "()I", "nativeMemoryChunkPool", "getNativeMemoryChunkPool", "nativeMemoryChunkPool$delegate", "ashmemMemoryChunkPool", "getAshmemMemoryChunkPool", "ashmemMemoryChunkPool$delegate", "pooledByteBufferFactory", "Lcom/facebook/common/memory/PooledByteBufferFactory;", "getPooledByteBufferFactory", "()Lcom/facebook/common/memory/PooledByteBufferFactory;", "_pooledByteBufferFactory", "memoryChunkType", "pooledByteStreams", "Lcom/facebook/common/memory/PooledByteStreams;", "getPooledByteStreams", "()Lcom/facebook/common/memory/PooledByteStreams;", "pooledByteStreams$delegate", "sharedByteArray", "Lcom/facebook/imagepipeline/memory/SharedByteArray;", "getSharedByteArray", "()Lcom/facebook/imagepipeline/memory/SharedByteArray;", "sharedByteArray$delegate", "smallByteArrayPool", "Lcom/facebook/common/memory/ByteArrayPool;", "getSmallByteArrayPool", "()Lcom/facebook/common/memory/ByteArrayPool;", "smallByteArrayPool$delegate", "getMemoryChunkPool", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class PoolFactory {
    private PooledByteBufferFactory _pooledByteBufferFactory;

    /* JADX INFO: renamed from: ashmemMemoryChunkPool$delegate, reason: from kotlin metadata */
    private final Lazy ashmemMemoryChunkPool;

    /* JADX INFO: renamed from: bitmapPool$delegate, reason: from kotlin metadata */
    private final Lazy bitmapPool;

    /* JADX INFO: renamed from: bufferMemoryChunkPool$delegate, reason: from kotlin metadata */
    private final Lazy bufferMemoryChunkPool;
    private final PoolConfig config;

    /* JADX INFO: renamed from: flexByteArrayPool$delegate, reason: from kotlin metadata */
    private final Lazy flexByteArrayPool;

    /* JADX INFO: renamed from: nativeMemoryChunkPool$delegate, reason: from kotlin metadata */
    private final Lazy nativeMemoryChunkPool;

    /* JADX INFO: renamed from: pooledByteStreams$delegate, reason: from kotlin metadata */
    private final Lazy pooledByteStreams;

    /* JADX INFO: renamed from: sharedByteArray$delegate, reason: from kotlin metadata */
    private final Lazy sharedByteArray;

    /* JADX INFO: renamed from: smallByteArrayPool$delegate, reason: from kotlin metadata */
    private final Lazy smallByteArrayPool;

    public PoolFactory(PoolConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        this.bitmapPool = LazyKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.memory.PoolFactory$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PoolFactory.bitmapPool_delegate$lambda$0(this.f$0);
            }
        });
        this.bufferMemoryChunkPool = LazyKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.memory.PoolFactory$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PoolFactory.bufferMemoryChunkPool_delegate$lambda$1(this.f$0);
            }
        });
        this.flexByteArrayPool = LazyKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.memory.PoolFactory$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PoolFactory.flexByteArrayPool_delegate$lambda$2(this.f$0);
            }
        });
        this.nativeMemoryChunkPool = LazyKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.memory.PoolFactory$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PoolFactory.nativeMemoryChunkPool_delegate$lambda$3(this.f$0);
            }
        });
        this.ashmemMemoryChunkPool = LazyKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.memory.PoolFactory$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PoolFactory.ashmemMemoryChunkPool_delegate$lambda$4(this.f$0);
            }
        });
        this.pooledByteStreams = LazyKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.memory.PoolFactory$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PoolFactory.pooledByteStreams_delegate$lambda$7(this.f$0);
            }
        });
        this.sharedByteArray = LazyKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.memory.PoolFactory$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PoolFactory.sharedByteArray_delegate$lambda$8(this.f$0);
            }
        });
        this.smallByteArrayPool = LazyKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.memory.PoolFactory$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PoolFactory.smallByteArrayPool_delegate$lambda$9(this.f$0);
            }
        });
    }

    public BitmapPool getBitmapPool() {
        return (BitmapPool) this.bitmapPool.getValue();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    static final BitmapPool bitmapPool_delegate$lambda$0(PoolFactory poolFactory) {
        String bitmapPoolType = poolFactory.config.getBitmapPoolType();
        switch (bitmapPoolType.hashCode()) {
            case -1868884870:
                if (bitmapPoolType.equals("legacy_default_params")) {
                    return new BucketsBitmapPool(poolFactory.config.getMemoryTrimmableRegistry(), DefaultBitmapPoolParams.get(), poolFactory.config.getBitmapPoolStatsTracker());
                }
                break;
            case -1106578487:
                if (bitmapPoolType.equals("legacy")) {
                    return new BucketsBitmapPool(poolFactory.config.getMemoryTrimmableRegistry(), poolFactory.config.getBitmapPoolParams(), poolFactory.config.getBitmapPoolStatsTracker());
                }
                break;
            case -404562712:
                if (bitmapPoolType.equals("experimental")) {
                    return new LruBitmapPool(poolFactory.config.getBitmapPoolMaxPoolSize(), poolFactory.config.getBitmapPoolMaxBitmapSize(), NoOpPoolStatsTracker.getInstance(), poolFactory.config.getIsRegisterLruBitmapPoolAsMemoryTrimmable() ? poolFactory.config.getMemoryTrimmableRegistry() : null);
                }
                break;
            case -402149703:
                if (bitmapPoolType.equals("dummy_with_tracking")) {
                    return new DummyTrackingInUseBitmapPool();
                }
                break;
            case 95945896:
                if (bitmapPoolType.equals("dummy")) {
                    return new DummyBitmapPool();
                }
                break;
        }
        return new BucketsBitmapPool(poolFactory.config.getMemoryTrimmableRegistry(), poolFactory.config.getBitmapPoolParams(), poolFactory.config.getBitmapPoolStatsTracker());
    }

    public final MemoryChunkPool getBufferMemoryChunkPool() {
        return (MemoryChunkPool) this.bufferMemoryChunkPool.getValue();
    }

    static final MemoryChunkPool bufferMemoryChunkPool_delegate$lambda$1(PoolFactory poolFactory) {
        try {
            Object objNewInstance = Class.forName("com.facebook.imagepipeline.memory.BufferMemoryChunkPool").getConstructor(MemoryTrimmableRegistry.class, PoolParams.class, PoolStatsTracker.class).newInstance(poolFactory.config.getMemoryTrimmableRegistry(), poolFactory.config.getMemoryChunkPoolParams(), poolFactory.config.getMemoryChunkPoolStatsTracker());
            Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type com.facebook.imagepipeline.memory.MemoryChunkPool");
            return (MemoryChunkPool) objNewInstance;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    public final FlexByteArrayPool getFlexByteArrayPool() {
        return (FlexByteArrayPool) this.flexByteArrayPool.getValue();
    }

    static final FlexByteArrayPool flexByteArrayPool_delegate$lambda$2(PoolFactory poolFactory) {
        return new FlexByteArrayPool(poolFactory.config.getMemoryTrimmableRegistry(), poolFactory.config.getFlexByteArrayPoolParams());
    }

    public final int getFlexByteArrayPoolMaxNumThreads() {
        return this.config.getFlexByteArrayPoolParams().maxNumThreads;
    }

    public final MemoryChunkPool getNativeMemoryChunkPool() {
        return (MemoryChunkPool) this.nativeMemoryChunkPool.getValue();
    }

    static final MemoryChunkPool nativeMemoryChunkPool_delegate$lambda$3(PoolFactory poolFactory) {
        try {
            Object objNewInstance = Class.forName("com.facebook.imagepipeline.memory.NativeMemoryChunkPool").getConstructor(MemoryTrimmableRegistry.class, PoolParams.class, PoolStatsTracker.class).newInstance(poolFactory.config.getMemoryTrimmableRegistry(), poolFactory.config.getMemoryChunkPoolParams(), poolFactory.config.getMemoryChunkPoolStatsTracker());
            Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type com.facebook.imagepipeline.memory.MemoryChunkPool");
            return (MemoryChunkPool) objNewInstance;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    private final MemoryChunkPool getAshmemMemoryChunkPool() {
        return (MemoryChunkPool) this.ashmemMemoryChunkPool.getValue();
    }

    static final MemoryChunkPool ashmemMemoryChunkPool_delegate$lambda$4(PoolFactory poolFactory) {
        try {
            Object objNewInstance = Class.forName("com.facebook.imagepipeline.memory.AshmemMemoryChunkPool").getConstructor(MemoryTrimmableRegistry.class, PoolParams.class, PoolStatsTracker.class).newInstance(poolFactory.config.getMemoryTrimmableRegistry(), poolFactory.config.getMemoryChunkPoolParams(), poolFactory.config.getMemoryChunkPoolStatsTracker());
            Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type com.facebook.imagepipeline.memory.MemoryChunkPool");
            return (MemoryChunkPool) objNewInstance;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    public final PooledByteBufferFactory getPooledByteBufferFactory() {
        return getPooledByteBufferFactory(!NativeCodeSetup.getUseNativeCode() ? 1 : 0);
    }

    public final PooledByteBufferFactory getPooledByteBufferFactory(int memoryChunkType) {
        PooledByteBufferFactory pooledByteBufferFactory = this._pooledByteBufferFactory;
        if (pooledByteBufferFactory != null) {
            return pooledByteBufferFactory;
        }
        MemoryChunkPool memoryChunkPool = getMemoryChunkPool(memoryChunkType);
        if (memoryChunkPool == null) {
            throw new IllegalArgumentException(("failed to get pool for chunk type: " + memoryChunkType).toString());
        }
        MemoryPooledByteBufferFactory memoryPooledByteBufferFactory = new MemoryPooledByteBufferFactory(memoryChunkPool, getPooledByteStreams());
        this._pooledByteBufferFactory = memoryPooledByteBufferFactory;
        return memoryPooledByteBufferFactory;
    }

    static final PooledByteStreams pooledByteStreams_delegate$lambda$7(PoolFactory poolFactory) {
        return new PooledByteStreams(poolFactory.getSmallByteArrayPool());
    }

    public final PooledByteStreams getPooledByteStreams() {
        return (PooledByteStreams) this.pooledByteStreams.getValue();
    }

    public final SharedByteArray getSharedByteArray() {
        return (SharedByteArray) this.sharedByteArray.getValue();
    }

    static final SharedByteArray sharedByteArray_delegate$lambda$8(PoolFactory poolFactory) {
        return new SharedByteArray(poolFactory.config.getMemoryTrimmableRegistry(), poolFactory.config.getFlexByteArrayPoolParams());
    }

    public final ByteArrayPool getSmallByteArrayPool() {
        return (ByteArrayPool) this.smallByteArrayPool.getValue();
    }

    static final GenericByteArrayPool smallByteArrayPool_delegate$lambda$9(PoolFactory poolFactory) {
        return new GenericByteArrayPool(poolFactory.config.getMemoryTrimmableRegistry(), poolFactory.config.getSmallByteArrayPoolParams(), poolFactory.config.getSmallByteArrayPoolStatsTracker());
    }

    private final MemoryChunkPool getMemoryChunkPool(int memoryChunkType) {
        if (memoryChunkType == 0) {
            return getNativeMemoryChunkPool();
        }
        if (memoryChunkType == 1) {
            return getBufferMemoryChunkPool();
        }
        if (memoryChunkType == 2) {
            return getAshmemMemoryChunkPool();
        }
        throw new IllegalArgumentException("Invalid MemoryChunkType");
    }
}

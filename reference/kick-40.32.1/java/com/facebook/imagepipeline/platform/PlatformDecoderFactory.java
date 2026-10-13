package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import androidx.core.util.Pools;
import com.facebook.common.memory.DecodeBufferHelper;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imageutils.BitmapUtil;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlatformDecoderFactory.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\u000f"}, d2 = {"Lcom/facebook/imagepipeline/platform/PlatformDecoderFactory;", "", "<init>", "()V", "buildPlatformDecoder", "Lcom/facebook/imagepipeline/platform/PlatformDecoder;", "poolFactory", "Lcom/facebook/imagepipeline/memory/PoolFactory;", "useDecodeBufferHelper", "", "platformDecoderOptions", "Lcom/facebook/imagepipeline/platform/PlatformDecoderOptions;", "createPool", "Landroidx/core/util/Pools$Pool;", "Ljava/nio/ByteBuffer;", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PlatformDecoderFactory {
    public static final PlatformDecoderFactory INSTANCE = new PlatformDecoderFactory();

    @JvmStatic
    public static final PlatformDecoder buildPlatformDecoder(PoolFactory poolFactory, PlatformDecoderOptions platformDecoderOptions) {
        Intrinsics.checkNotNullParameter(poolFactory, "poolFactory");
        Intrinsics.checkNotNullParameter(platformDecoderOptions, "platformDecoderOptions");
        return buildPlatformDecoder$default(poolFactory, false, platformDecoderOptions, 2, null);
    }

    private PlatformDecoderFactory() {
    }

    public static /* synthetic */ PlatformDecoder buildPlatformDecoder$default(PoolFactory poolFactory, boolean z, PlatformDecoderOptions platformDecoderOptions, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return buildPlatformDecoder(poolFactory, z, platformDecoderOptions);
    }

    @JvmStatic
    public static final PlatformDecoder buildPlatformDecoder(PoolFactory poolFactory, boolean useDecodeBufferHelper, PlatformDecoderOptions platformDecoderOptions) {
        Intrinsics.checkNotNullParameter(poolFactory, "poolFactory");
        Intrinsics.checkNotNullParameter(platformDecoderOptions, "platformDecoderOptions");
        if (platformDecoderOptions.getUseEfficientDecoder()) {
            return new EfficientPlatformDecoder(new EfficientRawBitmapDecoder(createPool(poolFactory, useDecodeBufferHelper), platformDecoderOptions), platformDecoderOptions);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            Pools.Pool<ByteBuffer> poolCreatePool = createPool(poolFactory, useDecodeBufferHelper);
            return new OreoDecoder(poolFactory.getBitmapPool(), poolCreatePool, platformDecoderOptions, new DefaultRawBitmapDecoder(poolCreatePool, platformDecoderOptions, poolFactory.getBitmapPool(), new Function3() { // from class: com.facebook.imagepipeline.platform.PlatformDecoderFactory$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return Integer.valueOf(PlatformDecoderFactory.buildPlatformDecoder$lambda$0(((Integer) obj).intValue(), ((Integer) obj2).intValue(), (BitmapFactory.Options) obj3));
                }
            }));
        }
        Pools.Pool<ByteBuffer> poolCreatePool2 = createPool(poolFactory, useDecodeBufferHelper);
        return new ArtDecoder(poolFactory.getBitmapPool(), poolCreatePool2, platformDecoderOptions, new DefaultRawBitmapDecoder(poolCreatePool2, platformDecoderOptions, poolFactory.getBitmapPool(), new Function3() { // from class: com.facebook.imagepipeline.platform.PlatformDecoderFactory$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return Integer.valueOf(PlatformDecoderFactory.buildPlatformDecoder$lambda$1(((Integer) obj).intValue(), ((Integer) obj2).intValue(), (BitmapFactory.Options) obj3));
            }
        }));
    }

    static final int buildPlatformDecoder$lambda$0(int i, int i2, BitmapFactory.Options opts) {
        Intrinsics.checkNotNullParameter(opts, "opts");
        Bitmap.Config config = opts.outConfig;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        return BitmapUtil.getSizeInByteForBitmap(i, i2, config);
    }

    static final int buildPlatformDecoder$lambda$1(int i, int i2, BitmapFactory.Options opts) {
        Intrinsics.checkNotNullParameter(opts, "opts");
        return BitmapUtil.getSizeInByteForBitmap(i, i2, opts.inPreferredConfig);
    }

    @JvmStatic
    public static final Pools.Pool<ByteBuffer> createPool(PoolFactory poolFactory, boolean useDecodeBufferHelper) {
        Intrinsics.checkNotNullParameter(poolFactory, "poolFactory");
        if (useDecodeBufferHelper) {
            DecodeBufferHelper INSTANCE2 = DecodeBufferHelper.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(INSTANCE2, "INSTANCE");
            return INSTANCE2;
        }
        int flexByteArrayPoolMaxNumThreads = poolFactory.getFlexByteArrayPoolMaxNumThreads();
        Pools.SynchronizedPool synchronizedPool = new Pools.SynchronizedPool(flexByteArrayPoolMaxNumThreads);
        for (int i = 0; i < flexByteArrayPoolMaxNumThreads; i++) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(DecodeBufferHelper.getRecommendedDecodeBufferSize());
            Intrinsics.checkNotNullExpressionValue(byteBufferAllocate, "allocate(...)");
            synchronizedPool.release(byteBufferAllocate);
        }
        return synchronizedPool;
    }
}

package com.facebook.imagepipeline.cache;

import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimType;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BitmapMemoryCacheTrimStrategy.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/facebook/imagepipeline/cache/BitmapMemoryCacheTrimStrategy;", "Lcom/facebook/imagepipeline/cache/MemoryCache$CacheTrimStrategy;", "<init>", "()V", "getTrimRatio", "", "trimType", "Lcom/facebook/common/memory/MemoryTrimType;", "Companion", "imagepipeline-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BitmapMemoryCacheTrimStrategy implements MemoryCache.CacheTrimStrategy {
    private static final Set<MemoryTrimType> FULL_TRIM_TYPES;
    public static final Set<MemoryTrimType> SUPPORTED_TRIM_TYPES;
    private static final String TAG = "BitmapMemoryCacheTrimStrategy";

    @Override // com.facebook.imagepipeline.cache.MemoryCache.CacheTrimStrategy
    public double getTrimRatio(MemoryTrimType trimType) {
        Intrinsics.checkNotNullParameter(trimType, "trimType");
        if (trimType == MemoryTrimType.OnCloseToDalvikHeapLimit) {
            return MemoryTrimType.OnCloseToDalvikHeapLimit.getSuggestedTrimRatio();
        }
        if (FULL_TRIM_TYPES.contains(trimType)) {
            return 1.0d;
        }
        FLog.wtf(TAG, "unknown trim type: %s", trimType);
        return 0.0d;
    }

    static {
        Set<MemoryTrimType> of = SetsKt.setOf((Object[]) new MemoryTrimType[]{MemoryTrimType.OnAppBackgrounded, MemoryTrimType.OnSystemMemoryCriticallyLowWhileAppInForeground, MemoryTrimType.OnSystemLowMemoryWhileAppInForeground, MemoryTrimType.OnSystemLowMemoryWhileAppInBackgroundLowSeverity});
        FULL_TRIM_TYPES = of;
        SUPPORTED_TRIM_TYPES = SetsKt.plus(of, MemoryTrimType.OnCloseToDalvikHeapLimit);
    }
}

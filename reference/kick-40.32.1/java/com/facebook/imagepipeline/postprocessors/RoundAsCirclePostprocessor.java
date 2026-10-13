package com.facebook.imagepipeline.postprocessors;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.nativecode.NativeRoundingFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RoundAsCirclePostprocessor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0013\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/imagepipeline/postprocessors/RoundAsCirclePostprocessor;", "Lcom/facebook/imagepipeline/request/BasePostprocessor;", "enableAntiAliasing", "", "<init>", "(Z)V", "cacheKey", "Lcom/facebook/cache/common/CacheKey;", "process", "", "bitmap", "Landroid/graphics/Bitmap;", "getPostprocessorCacheKey", "Companion", "native-filters_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RoundAsCirclePostprocessor extends BasePostprocessor {
    private static final boolean ENABLE_ANTI_ALIASING = true;
    private CacheKey cacheKey;
    private final boolean enableAntiAliasing;

    public RoundAsCirclePostprocessor() {
        this(false, 1, null);
    }

    public /* synthetic */ RoundAsCirclePostprocessor(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }

    public RoundAsCirclePostprocessor(boolean z) {
        this.enableAntiAliasing = z;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public void process(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        NativeRoundingFilter.toCircleFast(bitmap, this.enableAntiAliasing);
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    /* JADX INFO: renamed from: getPostprocessorCacheKey */
    public CacheKey getCacheKey() {
        SimpleCacheKey simpleCacheKey;
        if (this.cacheKey == null) {
            if (this.enableAntiAliasing) {
                simpleCacheKey = new SimpleCacheKey("RoundAsCirclePostprocessor#AntiAliased");
            } else {
                simpleCacheKey = new SimpleCacheKey("RoundAsCirclePostprocessor");
            }
            this.cacheKey = simpleCacheKey;
        }
        return this.cacheKey;
    }
}

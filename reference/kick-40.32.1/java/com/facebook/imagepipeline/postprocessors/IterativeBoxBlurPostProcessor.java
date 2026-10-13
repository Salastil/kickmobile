package com.facebook.imagepipeline.postprocessors;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: IterativeBoxBlurPostProcessor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/imagepipeline/postprocessors/IterativeBoxBlurPostProcessor;", "Lcom/facebook/imagepipeline/request/BasePostprocessor;", "iterations", "", "blurRadius", "<init>", "(II)V", "(I)V", "cacheKey", "Lcom/facebook/cache/common/CacheKey;", "process", "", "bitmap", "Landroid/graphics/Bitmap;", "getPostprocessorCacheKey", "Companion", "native-filters_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IterativeBoxBlurPostProcessor extends BasePostprocessor {
    private static final int DEFAULT_ITERATIONS = 3;
    private final int blurRadius;
    private CacheKey cacheKey;
    private final int iterations;

    public IterativeBoxBlurPostProcessor(int i, int i2) {
        if (i <= 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        this.iterations = i;
        this.blurRadius = i2;
    }

    public IterativeBoxBlurPostProcessor(int i) {
        this(3, i);
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public void process(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        NativeBlurFilter.iterativeBoxBlur(bitmap, this.iterations, this.blurRadius);
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    /* JADX INFO: renamed from: getPostprocessorCacheKey */
    public CacheKey getCacheKey() {
        if (this.cacheKey == null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(null, "i%dr%d", Arrays.copyOf(new Object[]{Integer.valueOf(this.iterations), Integer.valueOf(this.blurRadius)}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            this.cacheKey = new SimpleCacheKey(str);
        }
        return this.cacheKey;
    }
}

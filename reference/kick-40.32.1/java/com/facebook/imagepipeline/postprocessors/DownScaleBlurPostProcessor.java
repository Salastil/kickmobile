package com.facebook.imagepipeline.postprocessors;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.filter.IterativeBoxBlurFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: DownScaleBlurPostProcessor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u0016\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/facebook/imagepipeline/postprocessors/DownScaleBlurPostProcessor;", "Lcom/facebook/imagepipeline/request/BasePostprocessor;", "blurRadius", "", "targetWidth", "targetHeight", "iterations", "scaleFactor", "", "ntscDampeningFactor", "<init>", "(IIIIFF)V", "getBlurRadius", "()I", "getTargetWidth", "getTargetHeight", "getIterations", "getScaleFactor", "()F", "getNtscDampeningFactor", "cacheKey", "Lcom/facebook/cache/common/CacheKey;", "process", "Lcom/facebook/common/references/CloseableReference;", "Landroid/graphics/Bitmap;", "sourceBitmap", "bitmapFactory", "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "", "destBitmap", "getPostprocessorCacheKey", "Companion", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DownScaleBlurPostProcessor extends BasePostprocessor {
    private static final int DEFAULT_ITERATIONS = 3;
    private static final float DEFAULT_SCALE_FACTOR = 0.3f;
    private final int blurRadius;
    private final CacheKey cacheKey;
    private final int iterations;
    private final float ntscDampeningFactor;
    private final float scaleFactor;
    private final int targetHeight;
    private final int targetWidth;

    public /* synthetic */ DownScaleBlurPostProcessor(int i, int i2, int i3, int i4, float f, float f2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, (i5 & 8) != 0 ? 3 : i4, (i5 & 16) != 0 ? DEFAULT_SCALE_FACTOR : f, (i5 & 32) != 0 ? 0.0f : f2);
    }

    public final int getBlurRadius() {
        return this.blurRadius;
    }

    public final int getTargetWidth() {
        return this.targetWidth;
    }

    public final int getTargetHeight() {
        return this.targetHeight;
    }

    public final int getIterations() {
        return this.iterations;
    }

    public final float getScaleFactor() {
        return this.scaleFactor;
    }

    public final float getNtscDampeningFactor() {
        return this.ntscDampeningFactor;
    }

    public DownScaleBlurPostProcessor(int i, int i2, int i3, int i4, float f, float f2) {
        this.blurRadius = i;
        this.targetWidth = i2;
        this.targetHeight = i3;
        this.iterations = i4;
        this.scaleFactor = f;
        this.ntscDampeningFactor = f2;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(null, "DownScaleBlur;r%d;w%d;h%d;i%d;s%.2f;n%.2f", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f), Float.valueOf(f2)}, 6));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        this.cacheKey = new SimpleCacheKey(str);
        Preconditions.checkArgument(i > 0 && i <= 25, "blurRadius must be > 0 and <= 25, but was " + i, new Object[0]);
        Preconditions.checkArgument(i4 > 0, "iterations must be > 0, but was " + i4, new Object[0]);
        Preconditions.checkArgument(f > 0.0f && f <= 1.0f, "scaleFactor must be > 0 and <= 1.0, but was " + f, new Object[0]);
        Preconditions.checkArgument(i2 > 0 && i3 > 0, "targetWidth and targetHeight must be > 0, but were " + i2 + " x " + i3, new Object[0]);
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    public CloseableReference<Bitmap> process(Bitmap sourceBitmap, PlatformBitmapFactory bitmapFactory) {
        Intrinsics.checkNotNullParameter(sourceBitmap, "sourceBitmap");
        Intrinsics.checkNotNullParameter(bitmapFactory, "bitmapFactory");
        int i = this.targetWidth;
        int i2 = this.targetHeight;
        Bitmap.Config config = sourceBitmap.getConfig();
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        CloseableReference<Bitmap> closeableReferenceCreateBitmapInternal = bitmapFactory.createBitmapInternal(i, i2, config);
        Intrinsics.checkNotNullExpressionValue(closeableReferenceCreateBitmapInternal, "createBitmapInternal(...)");
        try {
            Bitmap bitmap = closeableReferenceCreateBitmapInternal.get();
            Intrinsics.checkNotNullExpressionValue(bitmap, "get(...)");
            process(bitmap, sourceBitmap);
            CloseableReference<Bitmap> closeableReferenceCloneOrNull = CloseableReference.cloneOrNull(closeableReferenceCreateBitmapInternal);
            if (closeableReferenceCloneOrNull == null) {
                throw new IllegalStateException("Failed to clone destination bitmap reference");
            }
            CloseableReference.closeSafely(closeableReferenceCreateBitmapInternal);
            return closeableReferenceCloneOrNull;
        } catch (Throwable th) {
            CloseableReference.closeSafely(closeableReferenceCreateBitmapInternal);
            throw th;
        }
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public void process(Bitmap destBitmap, Bitmap sourceBitmap) {
        Intrinsics.checkNotNullParameter(destBitmap, "destBitmap");
        Intrinsics.checkNotNullParameter(sourceBitmap, "sourceBitmap");
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(sourceBitmap, RangesKt.coerceAtLeast((int) (sourceBitmap.getWidth() * this.scaleFactor), 1), RangesKt.coerceAtLeast((int) (sourceBitmap.getHeight() * this.scaleFactor), 1), true);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
        try {
            IterativeBoxBlurFilter.boxBlurBitmapInPlace(bitmapCreateScaledBitmap, this.iterations, this.blurRadius, this.ntscDampeningFactor);
            Canvas canvas = new Canvas(destBitmap);
            Paint paint = new Paint();
            paint.setFilterBitmap(true);
            canvas.drawBitmap(bitmapCreateScaledBitmap, (Rect) null, new Rect(0, 0, destBitmap.getWidth(), destBitmap.getHeight()), paint);
        } finally {
            bitmapCreateScaledBitmap.recycle();
        }
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    /* JADX INFO: renamed from: getPostprocessorCacheKey, reason: from getter */
    public CacheKey getCacheKey() {
        return this.cacheKey;
    }
}

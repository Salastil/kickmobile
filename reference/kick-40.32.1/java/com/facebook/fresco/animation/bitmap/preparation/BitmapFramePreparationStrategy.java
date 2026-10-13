package com.facebook.fresco.animation.bitmap.preparation;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BitmapFramePreparationStrategy.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rH\u0016J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J(\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lcom/facebook/fresco/animation/bitmap/preparation/BitmapFramePreparationStrategy;", "", "prepareFrames", "", "bitmapFramePreparer", "Lcom/facebook/fresco/animation/bitmap/preparation/BitmapFramePreparer;", "bitmapFrameCache", "Lcom/facebook/fresco/animation/bitmap/BitmapFrameCache;", "animationBackend", "Lcom/facebook/fresco/animation/backend/AnimationBackend;", "lastDrawnFrameNumber", "", "onAnimationLoaded", "Lkotlin/Function0;", "canvasWidth", "canvasHeight", "onStop", "clearFrames", "getBitmapFrame", "Lcom/facebook/common/references/CloseableReference;", "Landroid/graphics/Bitmap;", "frameNumber", "animated-drawable_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface BitmapFramePreparationStrategy {
    default void clearFrames() {
    }

    default CloseableReference<Bitmap> getBitmapFrame(int frameNumber, int canvasWidth, int canvasHeight) {
        return null;
    }

    default void onStop() {
    }

    default void prepareFrames(int canvasWidth, int canvasHeight, Function0<Unit> onAnimationLoaded) {
    }

    default void prepareFrames(BitmapFramePreparer bitmapFramePreparer, BitmapFrameCache bitmapFrameCache, AnimationBackend animationBackend, int lastDrawnFrameNumber, Function0<Unit> onAnimationLoaded) {
        Intrinsics.checkNotNullParameter(bitmapFramePreparer, "bitmapFramePreparer");
        Intrinsics.checkNotNullParameter(bitmapFrameCache, "bitmapFrameCache");
        Intrinsics.checkNotNullParameter(animationBackend, "animationBackend");
    }

    /* JADX INFO: compiled from: BitmapFramePreparationStrategy.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void prepareFrames(BitmapFramePreparationStrategy bitmapFramePreparationStrategy, BitmapFramePreparer bitmapFramePreparer, BitmapFrameCache bitmapFrameCache, AnimationBackend animationBackend, int i, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(bitmapFramePreparer, "bitmapFramePreparer");
            Intrinsics.checkNotNullParameter(bitmapFrameCache, "bitmapFrameCache");
            Intrinsics.checkNotNullParameter(animationBackend, "animationBackend");
            BitmapFramePreparationStrategy.super.prepareFrames(bitmapFramePreparer, bitmapFrameCache, animationBackend, i, function0);
        }

        @Deprecated
        public static void prepareFrames(BitmapFramePreparationStrategy bitmapFramePreparationStrategy, int i, int i2, Function0<Unit> function0) {
            BitmapFramePreparationStrategy.super.prepareFrames(i, i2, function0);
        }

        @Deprecated
        public static void onStop(BitmapFramePreparationStrategy bitmapFramePreparationStrategy) {
            BitmapFramePreparationStrategy.super.onStop();
        }

        @Deprecated
        public static void clearFrames(BitmapFramePreparationStrategy bitmapFramePreparationStrategy) {
            BitmapFramePreparationStrategy.super.clearFrames();
        }

        @Deprecated
        public static CloseableReference<Bitmap> getBitmapFrame(BitmapFramePreparationStrategy bitmapFramePreparationStrategy, int i, int i2, int i3) {
            return BitmapFramePreparationStrategy.super.getBitmapFrame(i, i2, i3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void prepareFrames$default(BitmapFramePreparationStrategy bitmapFramePreparationStrategy, BitmapFramePreparer bitmapFramePreparer, BitmapFrameCache bitmapFrameCache, AnimationBackend animationBackend, int i, Function0 function0, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: prepareFrames");
        }
        if ((i2 & 16) != 0) {
            function0 = null;
        }
        bitmapFramePreparationStrategy.prepareFrames(bitmapFramePreparer, bitmapFrameCache, animationBackend, i, function0);
    }
}

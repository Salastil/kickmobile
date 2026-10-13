package androidx.camera.viewfinder.core;

import android.util.SizeF;
import androidx.camera.viewfinder.core.impl.Alignment;
import androidx.camera.viewfinder.core.impl.ContentScale;
import androidx.camera.viewfinder.core.impl.TransformationsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScaleType.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0002\u0001\u0004\u001a\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002\u001a\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002\u001a\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002\u001a\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Fit", "androidx/camera/viewfinder/core/ScaleTypeKt$Fit$1", "Landroidx/camera/viewfinder/core/ScaleTypeKt$Fit$1;", "Fill", "androidx/camera/viewfinder/core/ScaleTypeKt$Fill$1", "Landroidx/camera/viewfinder/core/ScaleTypeKt$Fill$1;", "computeFillMaxDimension", "", "srcSize", "Landroid/util/SizeF;", "dstSize", "computeFillMinDimension", "computeFillWidth", "computeFillHeight", "Start", "Landroidx/camera/viewfinder/core/impl/Alignment;", "Center", "End", "viewfinder-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ScaleTypeKt {
    private static final ScaleTypeKt$Fit$1 Fit = new ContentScale() { // from class: androidx.camera.viewfinder.core.ScaleTypeKt$Fit$1
        @Override // androidx.camera.viewfinder.core.impl.ContentScale
        /* JADX INFO: renamed from: computeScaleFactor-ho9e9VQ */
        public long mo1260computeScaleFactorho9e9VQ(SizeF srcSize, SizeF dstSize) {
            Intrinsics.checkNotNullParameter(srcSize, "srcSize");
            Intrinsics.checkNotNullParameter(dstSize, "dstSize");
            float fComputeFillMinDimension = ScaleTypeKt.computeFillMinDimension(srcSize, dstSize);
            return TransformationsKt.ScaleFactorF(fComputeFillMinDimension, fComputeFillMinDimension);
        }
    };
    private static final ScaleTypeKt$Fill$1 Fill = new ContentScale() { // from class: androidx.camera.viewfinder.core.ScaleTypeKt$Fill$1
        @Override // androidx.camera.viewfinder.core.impl.ContentScale
        /* JADX INFO: renamed from: computeScaleFactor-ho9e9VQ, reason: not valid java name */
        public long mo1260computeScaleFactorho9e9VQ(SizeF srcSize, SizeF dstSize) {
            Intrinsics.checkNotNullParameter(srcSize, "srcSize");
            Intrinsics.checkNotNullParameter(dstSize, "dstSize");
            float fComputeFillMaxDimension = ScaleTypeKt.computeFillMaxDimension(srcSize, dstSize);
            return TransformationsKt.ScaleFactorF(fComputeFillMaxDimension, fComputeFillMaxDimension);
        }
    };
    private static final Alignment Start = new BiasAlignment(-1.0f, -1.0f);
    private static final Alignment Center = new BiasAlignment(0.0f, 0.0f);
    private static final Alignment End = new BiasAlignment(1.0f, 1.0f);

    /* JADX INFO: Access modifiers changed from: private */
    public static final float computeFillMaxDimension(SizeF sizeF, SizeF sizeF2) {
        return Math.max(computeFillWidth(sizeF, sizeF2), computeFillHeight(sizeF, sizeF2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float computeFillMinDimension(SizeF sizeF, SizeF sizeF2) {
        return Math.min(computeFillWidth(sizeF, sizeF2), computeFillHeight(sizeF, sizeF2));
    }

    private static final float computeFillWidth(SizeF sizeF, SizeF sizeF2) {
        return sizeF2.getWidth() / sizeF.getWidth();
    }

    private static final float computeFillHeight(SizeF sizeF, SizeF sizeF2) {
        return sizeF2.getHeight() / sizeF.getHeight();
    }
}

package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.transformation.BitmapTransformation;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlurBitmapTransformation.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/imagepipeline/nativecode/BlurBitmapTransformation;", "Lcom/facebook/imagepipeline/transformation/BitmapTransformation;", "iterations", "", "blurRadius", "<init>", "(II)V", ViewProps.TRANSFORM, "", "bitmap", "Landroid/graphics/Bitmap;", "modifiesTransparency", "", "Companion", "native-filters_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BlurBitmapTransformation implements BitmapTransformation {
    private static final int DEFAULT_BLUR_RADIUS = 25;
    private static final int DEFAULT_ITERATIONS = 3;
    private final int blurRadius;
    private final int iterations;

    /* JADX WARN: Illegal instructions before constructor call */
    public BlurBitmapTransformation() {
        int i = 0;
        this(i, i, 3, null);
    }

    @Override // com.facebook.imagepipeline.transformation.BitmapTransformation
    public boolean modifiesTransparency() {
        return false;
    }

    public BlurBitmapTransformation(int i, int i2) {
        this.iterations = i;
        this.blurRadius = i2;
        if (i <= 0) {
            throw new IllegalArgumentException(("iterations must be > 0, got " + i).toString());
        }
        if (i2 > 0) {
            return;
        }
        throw new IllegalArgumentException(("blurRadius must be > 0, got " + i2).toString());
    }

    public /* synthetic */ BlurBitmapTransformation(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 3 : i, (i3 & 2) != 0 ? 25 : i2);
    }

    @Override // com.facebook.imagepipeline.transformation.BitmapTransformation
    public void transform(Bitmap bitmap, QualityInfo qualityInfo) {
        super.transform(bitmap, qualityInfo);
    }

    @Override // com.facebook.imagepipeline.transformation.BitmapTransformation
    public void transform(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        NativeBlurFilter.iterativeBoxBlur(bitmap, this.iterations, this.blurRadius);
    }
}

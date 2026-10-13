package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NativeBlurFilter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0007J!\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0083 ¨\u0006\f"}, d2 = {"Lcom/facebook/imagepipeline/nativecode/NativeBlurFilter;", "", "<init>", "()V", "iterativeBoxBlur", "", "bitmap", "Landroid/graphics/Bitmap;", "iterations", "", "blurRadius", "nativeIterativeBoxBlur", "native-filters_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NativeBlurFilter {
    public static final NativeBlurFilter INSTANCE = new NativeBlurFilter();

    @JvmStatic
    private static final native void nativeIterativeBoxBlur(Bitmap bitmap, int iterations, int blurRadius);

    private NativeBlurFilter() {
    }

    static {
        NativeFiltersLoader.load();
    }

    @JvmStatic
    public static final void iterativeBoxBlur(Bitmap bitmap, int iterations, int blurRadius) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if (iterations <= 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (blurRadius <= 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        nativeIterativeBoxBlur(bitmap, iterations, blurRadius);
    }
}

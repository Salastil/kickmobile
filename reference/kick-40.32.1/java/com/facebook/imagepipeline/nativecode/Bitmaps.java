package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Bitmaps.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0007J1\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0083 ¨\u0006\u000e"}, d2 = {"Lcom/facebook/imagepipeline/nativecode/Bitmaps;", "", "<init>", "()V", "copyBitmap", "", "dest", "Landroid/graphics/Bitmap;", "src", "nativeCopyBitmap", "destStride", "", "srcStride", "rows", "imagepipeline-native_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Bitmaps {
    public static final Bitmaps INSTANCE = new Bitmaps();

    @JvmStatic
    private static final native void nativeCopyBitmap(Bitmap dest, int destStride, Bitmap src, int srcStride, int rows);

    private Bitmaps() {
    }

    static {
        ImagePipelineNativeLoader.load();
    }

    @JvmStatic
    public static final void copyBitmap(Bitmap dest, Bitmap src) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Intrinsics.checkNotNullParameter(src, "src");
        if (src.getConfig() != dest.getConfig()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!dest.isMutable()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (dest.getWidth() != src.getWidth()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (dest.getHeight() != src.getHeight()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        nativeCopyBitmap(dest, dest.getRowBytes(), src, src.getRowBytes(), dest.getHeight());
    }
}

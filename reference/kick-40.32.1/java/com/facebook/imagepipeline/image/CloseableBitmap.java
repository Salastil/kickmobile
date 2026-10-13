package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public interface CloseableBitmap extends CloseableImage {
    @Nullable
    Bitmap getUnderlyingBitmap();
}

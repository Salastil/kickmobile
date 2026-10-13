package com.facebook.imagepipeline.transformation;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BitmapTransformation.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/facebook/imagepipeline/transformation/BitmapTransformation;", "", ViewProps.TRANSFORM, "", "bitmap", "Landroid/graphics/Bitmap;", "qualityInfo", "Lcom/facebook/imagepipeline/image/QualityInfo;", "modifiesTransparency", "", "imagepipeline-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface BitmapTransformation {
    boolean modifiesTransparency();

    void transform(Bitmap bitmap);

    /* JADX INFO: compiled from: BitmapTransformation.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void transform(BitmapTransformation bitmapTransformation, Bitmap bitmap, QualityInfo qualityInfo) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            Intrinsics.checkNotNullParameter(qualityInfo, "qualityInfo");
            BitmapTransformation.super.transform(bitmap, qualityInfo);
        }
    }

    default void transform(Bitmap bitmap, QualityInfo qualityInfo) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(qualityInfo, "qualityInfo");
        transform(bitmap);
    }
}

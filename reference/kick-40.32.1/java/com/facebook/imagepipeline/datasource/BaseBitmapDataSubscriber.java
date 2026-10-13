package com.facebook.imagepipeline.datasource;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseBitmapDataSubscriber.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\tH\u0016J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH$¨\u0006\f"}, d2 = {"Lcom/facebook/imagepipeline/datasource/BaseBitmapDataSubscriber;", "Lcom/facebook/datasource/BaseDataSubscriber;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "<init>", "()V", "onNewResultImpl", "", "dataSource", "Lcom/facebook/datasource/DataSource;", "bitmap", "Landroid/graphics/Bitmap;", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class BaseBitmapDataSubscriber extends BaseDataSubscriber<CloseableReference<CloseableImage>> {
    protected abstract void onNewResultImpl(Bitmap bitmap);

    @Override // com.facebook.datasource.BaseDataSubscriber
    public void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
        Bitmap underlyingBitmap;
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        if (dataSource.isFinished()) {
            CloseableReference<CloseableImage> result = dataSource.getResult();
            if (result == null || !(result.get() instanceof CloseableBitmap)) {
                underlyingBitmap = null;
            } else {
                CloseableImage closeableImage = result.get();
                Intrinsics.checkNotNull(closeableImage, "null cannot be cast to non-null type com.facebook.imagepipeline.image.CloseableBitmap");
                underlyingBitmap = ((CloseableBitmap) closeableImage).getUnderlyingBitmap();
            }
            try {
                onNewResultImpl(underlyingBitmap);
            } finally {
                CloseableReference.closeSafely(result);
            }
        }
    }
}

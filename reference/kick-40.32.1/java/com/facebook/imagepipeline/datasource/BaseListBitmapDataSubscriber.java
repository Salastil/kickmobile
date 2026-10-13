package com.facebook.imagepipeline.datasource;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseListBitmapDataSubscriber.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u0016\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\u0007\u001a\u00020\b2\u001a\u0010\t\u001a\u0016\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u00020\nH\u0016J\u001a\u0010\u000b\u001a\u00020\b2\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0002H$¨\u0006\u000e"}, d2 = {"Lcom/facebook/imagepipeline/datasource/BaseListBitmapDataSubscriber;", "Lcom/facebook/datasource/BaseDataSubscriber;", "", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "<init>", "()V", "onNewResultImpl", "", "dataSource", "Lcom/facebook/datasource/DataSource;", "onNewResultListImpl", "bitmapList", "Landroid/graphics/Bitmap;", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class BaseListBitmapDataSubscriber extends BaseDataSubscriber<List<? extends CloseableReference<CloseableImage>>> {
    protected abstract void onNewResultListImpl(List<Bitmap> bitmapList);

    @Override // com.facebook.datasource.BaseDataSubscriber
    public void onNewResultImpl(DataSource<List<? extends CloseableReference<CloseableImage>>> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        if (dataSource.isFinished()) {
            List<? extends CloseableReference<CloseableImage>> result = dataSource.getResult();
            if (result == null) {
                onNewResultListImpl(null);
                return;
            }
            try {
                ArrayList arrayList = new ArrayList(result.size());
                for (CloseableReference<CloseableImage> closeableReference : result) {
                    if (closeableReference != null && (closeableReference.get() instanceof CloseableBitmap)) {
                        CloseableImage closeableImage = closeableReference.get();
                        Intrinsics.checkNotNull(closeableImage, "null cannot be cast to non-null type com.facebook.imagepipeline.image.CloseableBitmap");
                        arrayList.add(((CloseableBitmap) closeableImage).getUnderlyingBitmap());
                    } else {
                        arrayList.add(null);
                    }
                }
                onNewResultListImpl(arrayList);
            } finally {
                Iterator<? extends CloseableReference<CloseableImage>> it = result.iterator();
                while (it.hasNext()) {
                    CloseableReference.closeSafely(it.next());
                }
            }
        }
    }
}

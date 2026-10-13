package com.facebook.fresco.vito.core.impl;

import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.fresco.vito.core.VitoImageRequest;
import com.facebook.imagepipeline.image.CloseableImage;
import kotlin.Metadata;

/* JADX INFO: compiled from: DrawableDataSubscriber.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH&J,\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH&J,\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/DrawableDataSubscriber;", "", "onNewResult", "", "drawable", "Lcom/facebook/fresco/vito/core/impl/FrescoDrawable2Impl;", "imageRequest", "Lcom/facebook/fresco/vito/core/VitoImageRequest;", "dataSource", "Lcom/facebook/datasource/DataSource;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "onFailure", "onProgressUpdate", "onRelease", "core-java-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface DrawableDataSubscriber {
    void onFailure(FrescoDrawable2Impl drawable, VitoImageRequest imageRequest, DataSource<CloseableReference<CloseableImage>> dataSource);

    void onNewResult(FrescoDrawable2Impl drawable, VitoImageRequest imageRequest, DataSource<CloseableReference<CloseableImage>> dataSource);

    void onProgressUpdate(FrescoDrawable2Impl drawable, VitoImageRequest imageRequest, DataSource<CloseableReference<CloseableImage>> dataSource);

    void onRelease(FrescoDrawable2Impl drawable);
}

package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: compiled from: CacheKeyConfig.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/facebook/imagepipeline/cache/DimensionExtractor;", "", "extractDimensions", "Lkotlin/Pair;", "", "request", "Lcom/facebook/imagepipeline/request/ImageRequest;", "sourceUri", "Landroid/net/Uri;", "callerContext", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface DimensionExtractor {
    Pair<Integer, Integer> extractDimensions(ImageRequest request, Uri sourceUri, Object callerContext);
}

package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.ImageRequest;
import kotlin.Metadata;

/* JADX INFO: compiled from: CacheKeyFactory.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H&J\u001a\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H&J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H&J\"\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H&¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/facebook/imagepipeline/cache/CacheKeyFactory;", "", "getBitmapCacheKey", "Lcom/facebook/cache/common/CacheKey;", "request", "Lcom/facebook/imagepipeline/request/ImageRequest;", "callerContext", "getPostprocessedBitmapCacheKey", "getEncodedCacheKey", "sourceUri", "Landroid/net/Uri;", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface CacheKeyFactory {
    CacheKey getBitmapCacheKey(ImageRequest request, Object callerContext);

    CacheKey getEncodedCacheKey(ImageRequest request, Uri sourceUri, Object callerContext);

    CacheKey getEncodedCacheKey(ImageRequest request, Object callerContext);

    CacheKey getPostprocessedBitmapCacheKey(ImageRequest request, Object callerContext);
}

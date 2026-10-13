package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import kotlin.Metadata;

/* JADX INFO: compiled from: CacheKeyConfig.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/facebook/imagepipeline/cache/EncodedCacheKeyEnricher;", "", "enrich", "Lcom/facebook/cache/common/CacheKey;", "keyString", "", "callerContext", "sourceUri", "Landroid/net/Uri;", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface EncodedCacheKeyEnricher {
    CacheKey enrich(String keyString, Object callerContext, Uri sourceUri);
}

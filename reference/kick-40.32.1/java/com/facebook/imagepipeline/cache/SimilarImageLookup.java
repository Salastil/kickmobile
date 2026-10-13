package com.facebook.imagepipeline.cache;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* JADX INFO: compiled from: SimilarImageLookup.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H&J\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0001H&J*\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J\u001a\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u0011H&J*\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lcom/facebook/imagepipeline/cache/SimilarImageLookup;", "", "findLargerMemoryCacheKey", "Lcom/facebook/imagepipeline/cache/SimilarImageResult;", "cacheKeyString", "", "groupKey", ViewProps.WIDTH, "", ViewProps.HEIGHT, "callerContext", "findLargerDiskCacheKey", "diskCacheKey", "trackMemoryCacheKey", "", "trackDiskCacheKey", "isFullImage", "", "removeMemoryCacheKey", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SimilarImageLookup {
    SimilarImageResult findLargerDiskCacheKey(String diskCacheKey, Object callerContext);

    SimilarImageResult findLargerMemoryCacheKey(String cacheKeyString, String groupKey, int width, int height, Object callerContext);

    void removeMemoryCacheKey(String cacheKeyString, String groupKey, int width, int height);

    void trackDiskCacheKey(String diskCacheKey, boolean isFullImage);

    void trackMemoryCacheKey(String cacheKeyString, String groupKey, int width, int height);

    /* JADX INFO: compiled from: SimilarImageLookup.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ void trackDiskCacheKey$default(SimilarImageLookup similarImageLookup, String str, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackDiskCacheKey");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        similarImageLookup.trackDiskCacheKey(str, z);
    }
}

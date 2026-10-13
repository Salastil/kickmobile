package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public class DefaultCacheKeyFactory implements CacheKeyFactory {

    @Nullable
    private static DefaultCacheKeyFactory sInstance;

    protected Uri getCacheKeySourceUri(Uri uri) {
        return uri;
    }

    protected DefaultCacheKeyFactory() {
    }

    public static synchronized DefaultCacheKeyFactory getInstance() {
        if (sInstance == null) {
            sInstance = new DefaultCacheKeyFactory();
        }
        return sInstance;
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public CacheKey getBitmapCacheKey(ImageRequest imageRequest, @Nullable Object obj) {
        String customCacheKey = imageRequest.getCustomCacheKey();
        if (customCacheKey == null) {
            customCacheKey = getCacheKeySourceUri(imageRequest.getSourceUri()).toString();
        }
        return new BitmapMemoryCacheKey(customCacheKey, imageRequest.getResizeOptions(), imageRequest.getRotationOptions(), imageRequest.getImageDecodeOptions(), null, null);
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public CacheKey getPostprocessedBitmapCacheKey(ImageRequest imageRequest, @Nullable Object obj) {
        CacheKey cacheKey;
        String name;
        Postprocessor postprocessor = imageRequest.getPostprocessor();
        if (postprocessor != null) {
            CacheKey cacheKey2 = postprocessor.getCacheKey();
            name = postprocessor.getClass().getName();
            cacheKey = cacheKey2;
        } else {
            cacheKey = null;
            name = null;
        }
        String customCacheKey = imageRequest.getCustomCacheKey();
        if (customCacheKey == null) {
            customCacheKey = getCacheKeySourceUri(imageRequest.getSourceUri()).toString();
        }
        return new BitmapMemoryCacheKey(customCacheKey, imageRequest.getResizeOptions(), imageRequest.getRotationOptions(), imageRequest.getImageDecodeOptions(), cacheKey, name);
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public CacheKey getEncodedCacheKey(ImageRequest imageRequest, @Nullable Object obj) {
        return getEncodedCacheKey(imageRequest, imageRequest.getSourceUri(), obj);
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public CacheKey getEncodedCacheKey(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        String customCacheKey = imageRequest.getCustomCacheKey();
        if (customCacheKey != null) {
            return new SimpleCacheKey(customCacheKey);
        }
        return new SimpleCacheKey(getCacheKeySourceUri(uri).toString());
    }
}

package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.common.disk.DiskTrimmable;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileCache.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0011H&J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011H&J\b\u0010\u0015\u001a\u00020\u000fH&J\b\u0010\u0016\u001a\u00020\u0017H&J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0019H\u0016¨\u0006\u001cÀ\u0006\u0003"}, d2 = {"Lcom/facebook/cache/disk/FileCache;", "Lcom/facebook/common/disk/DiskTrimmable;", "isEnabled", "", "getResource", "Lcom/facebook/binaryresource/BinaryResource;", "key", "Lcom/facebook/cache/common/CacheKey;", "hasKeySync", "hasKey", "probe", "insert", "writer", "Lcom/facebook/cache/common/WriterCallback;", "remove", "", "getSize", "", "getCount", "clearOldEntries", "cacheExpirationMs", "clearAll", "getDumpInfo", "Lcom/facebook/cache/disk/DiskStorage$DiskDumpInfo;", "getMetadata", "", "setMetadata", "metadata", "imagepipeline-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface FileCache extends DiskTrimmable {
    void clearAll();

    long clearOldEntries(long cacheExpirationMs);

    long getCount();

    DiskStorage.DiskDumpInfo getDumpInfo() throws IOException;

    default String getMetadata(CacheKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return null;
    }

    BinaryResource getResource(CacheKey key);

    long getSize();

    boolean hasKey(CacheKey key);

    boolean hasKeySync(CacheKey key);

    BinaryResource insert(CacheKey key, WriterCallback writer) throws IOException;

    boolean isEnabled();

    boolean probe(CacheKey key);

    void remove(CacheKey key);

    default void setMetadata(CacheKey key, String metadata) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
    }

    /* JADX INFO: compiled from: FileCache.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static String getMetadata(FileCache fileCache, CacheKey key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return FileCache.super.getMetadata(key);
        }

        @Deprecated
        public static void setMetadata(FileCache fileCache, CacheKey key, String metadata) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(metadata, "metadata");
            FileCache.super.setMetadata(key, metadata);
        }
    }
}

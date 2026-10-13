package com.facebook.cache.disk;

import com.facebook.cache.common.CacheKey;
import kotlin.Metadata;

/* JADX INFO: compiled from: CacheDecisionReporter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/facebook/cache/disk/CacheDecisionReporter;", "", "consumeReadDecision", "", "key", "Lcom/facebook/cache/common/CacheKey;", "writeTargetCacheId", "getWriteTargetCacheId", "()Ljava/lang/String;", "imagepipeline-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface CacheDecisionReporter {
    String consumeReadDecision(CacheKey key);

    String getWriteTargetCacheId();
}

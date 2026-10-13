package com.datadog.trace.core.propagation.ptags;

import com.datadog.trace.api.cache.DDPartialKeyCache;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class TagKey$$ExternalSyntheticLambda0 implements DDPartialKeyCache.Hasher {
    @Override // com.datadog.trace.api.cache.DDPartialKeyCache.Hasher
    public final int apply(Object obj, int i, int i2) {
        return TagKey.hash((String) obj, i, i2);
    }
}

package com.datadog.trace.core.propagation.ptags;

import com.datadog.trace.api.cache.DDPartialKeyCache;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class TagKey$$ExternalSyntheticLambda1 implements DDPartialKeyCache.Comparator {
    @Override // com.datadog.trace.api.cache.DDPartialKeyCache.Comparator
    public final boolean test(Object obj, int i, int i2, Object obj2) {
        return TagKey.compare((String) obj, i, i2, (TagKey) obj2);
    }
}

package com.datadog.trace.core.propagation.ptags;

import com.datadog.trace.api.cache.DDPartialKeyCache;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class TagKey$$ExternalSyntheticLambda2 implements DDPartialKeyCache.Producer {
    @Override // com.datadog.trace.api.cache.DDPartialKeyCache.Producer
    public final Object apply(Object obj, int i, int i2, int i3) {
        return TagKey.produce((String) obj, i, i2, i3);
    }
}

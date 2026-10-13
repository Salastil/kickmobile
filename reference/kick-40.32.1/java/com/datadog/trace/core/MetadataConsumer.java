package com.datadog.trace.core;

import com.datadog.android.trace.internal.compat.function.Consumer;

/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface MetadataConsumer extends Consumer<Metadata> {
    public static final MetadataConsumer NO_OP = new MetadataConsumer() { // from class: com.datadog.trace.core.MetadataConsumer$$ExternalSyntheticLambda0
        @Override // com.datadog.trace.core.MetadataConsumer
        public final void accept(Metadata metadata) {
            MetadataConsumer.lambda$static$0(metadata);
        }
    };

    static /* synthetic */ void lambda$static$0(Metadata metadata) {
    }

    @Override // com.datadog.android.trace.internal.compat.function.Consumer
    void accept(Metadata metadata);
}

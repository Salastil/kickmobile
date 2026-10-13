package com.datadog.android.trace.internal;

import com.datadog.trace.bootstrap.instrumentation.api.AgentPropagation;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: DatadogPropagationAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* synthetic */ class DatadogPropagationAdapter$extract$1$1 extends FunctionReferenceImpl implements Function2<String, String, Boolean> {
    DatadogPropagationAdapter$extract$1$1(Object obj) {
        super(2, obj, AgentPropagation.KeyClassifier.class, "accept", "accept(Ljava/lang/String;Ljava/lang/String;)Z", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Boolean invoke(String str, String str2) {
        return Boolean.valueOf(((AgentPropagation.KeyClassifier) this.receiver).accept(str, str2));
    }
}

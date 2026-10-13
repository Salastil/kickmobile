package com.datadog.android.flags.internal.net;

import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.flags.model.EvaluationContext;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpPrecomputedAssignmentsReader.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/datadog/android/flags/internal/net/NoOpPrecomputedAssignmentsReader;", "Lcom/datadog/android/flags/internal/net/PrecomputedAssignmentsReader;", "()V", "readPrecomputedFlags", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/flags/model/EvaluationContext;", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpPrecomputedAssignmentsReader implements PrecomputedAssignmentsReader {
    @Override // com.datadog.android.flags.internal.net.PrecomputedAssignmentsReader
    public String readPrecomputedFlags(EvaluationContext context, DatadogContext datadogContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        return null;
    }
}

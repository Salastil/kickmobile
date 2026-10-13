package com.datadog.android.flags.internal.net;

import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.flags.model.EvaluationContext;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import kotlin.Metadata;

/* JADX INFO: compiled from: PrecomputedAssignmentsReader.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, d2 = {"Lcom/datadog/android/flags/internal/net/PrecomputedAssignmentsReader;", "", "readPrecomputedFlags", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/flags/model/EvaluationContext;", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PrecomputedAssignmentsReader {
    String readPrecomputedFlags(EvaluationContext context, DatadogContext datadogContext);
}

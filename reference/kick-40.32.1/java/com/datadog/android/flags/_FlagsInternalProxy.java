package com.datadog.android.flags;

import com.datadog.android.flags.internal.DatadogFlagsClient;
import com.datadog.android.flags.model.EvaluationContext;
import com.datadog.android.flags.model.UnparsedFlag;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: _FlagsInternalProxy.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/flags/_FlagsInternalProxy;", "", "client", "Lcom/datadog/android/flags/FlagsClient;", "(Lcom/datadog/android/flags/FlagsClient;)V", "getFlagAssignmentsSnapshot", "", "", "Lcom/datadog/android/flags/model/UnparsedFlag;", "trackFlagSnapshotEvaluation", "", "flagKey", "flag", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/flags/model/EvaluationContext;", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class _FlagsInternalProxy {
    private final FlagsClient client;

    public _FlagsInternalProxy(FlagsClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.client = client;
    }

    public final Map<String, UnparsedFlag> getFlagAssignmentsSnapshot() {
        FlagsClient flagsClient = this.client;
        if (flagsClient instanceof DatadogFlagsClient) {
            return ((DatadogFlagsClient) flagsClient).getFlagAssignmentsSnapshot$dd_sdk_android_flags_release();
        }
        return MapsKt.emptyMap();
    }

    public final void trackFlagSnapshotEvaluation(String flagKey, UnparsedFlag flag, EvaluationContext context) {
        Intrinsics.checkNotNullParameter(flagKey, "flagKey");
        Intrinsics.checkNotNullParameter(flag, "flag");
        Intrinsics.checkNotNullParameter(context, "context");
        FlagsClient flagsClient = this.client;
        if (flagsClient instanceof DatadogFlagsClient) {
            ((DatadogFlagsClient) flagsClient).trackFlagSnapshotEvaluation$dd_sdk_android_flags_release(flagKey, flag, context);
        }
    }
}

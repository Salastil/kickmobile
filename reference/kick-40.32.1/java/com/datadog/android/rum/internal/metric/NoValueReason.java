package com.datadog.android.rum.internal.metric;

import kotlin.Metadata;

/* JADX INFO: compiled from: ViewInitializationMetricsState.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/datadog/android/rum/internal/metric/NoValueReason;", "", "InteractionToNextView", "TimeToNetworkSettle", "Lcom/datadog/android/rum/internal/metric/NoValueReason$InteractionToNextView;", "Lcom/datadog/android/rum/internal/metric/NoValueReason$TimeToNetworkSettle;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface NoValueReason {

    /* JADX INFO: compiled from: ViewInitializationMetricsState.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/datadog/android/rum/internal/metric/NoValueReason$InteractionToNextView;", "", "Lcom/datadog/android/rum/internal/metric/NoValueReason;", "(Ljava/lang/String;I)V", "DISABLED", "NO_ACTION", "NO_ELIGIBLE_ACTION", "NO_PREVIOUS_VIEW", "UNKNOWN", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum InteractionToNextView implements NoValueReason {
        DISABLED,
        NO_ACTION,
        NO_ELIGIBLE_ACTION,
        NO_PREVIOUS_VIEW,
        UNKNOWN
    }

    /* JADX INFO: compiled from: ViewInitializationMetricsState.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/datadog/android/rum/internal/metric/NoValueReason$TimeToNetworkSettle;", "", "Lcom/datadog/android/rum/internal/metric/NoValueReason;", "(Ljava/lang/String;I)V", "NO_RESOURCES", "NO_INITIAL_RESOURCES", "NOT_SETTLED_YET", "UNKNOWN", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum TimeToNetworkSettle implements NoValueReason {
        NO_RESOURCES,
        NO_INITIAL_RESOURCES,
        NOT_SETTLED_YET,
        UNKNOWN
    }
}

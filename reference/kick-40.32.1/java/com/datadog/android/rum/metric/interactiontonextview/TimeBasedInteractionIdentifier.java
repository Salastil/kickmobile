package com.datadog.android.rum.metric.interactiontonextview;

import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimeBasedInteractionIdentifier.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\nJ\u0013\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/datadog/android/rum/metric/interactiontonextview/TimeBasedInteractionIdentifier;", "Lcom/datadog/android/rum/metric/interactiontonextview/LastInteractionIdentifier;", "timeThresholdInMilliseconds", "", "(J)V", "getTimeThresholdInMilliseconds$dd_sdk_android_rum_release", "()J", "timeThresholdInNanoSeconds", "defaultThresholdUsed", "", "defaultThresholdUsed$dd_sdk_android_rum_release", "equals", "other", "", "hashCode", "", "validate", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/rum/metric/interactiontonextview/PreviousViewLastInteractionContext;", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TimeBasedInteractionIdentifier implements LastInteractionIdentifier {
    public static final long DEFAULT_TIME_THRESHOLD_MS = 3000;
    private final long timeThresholdInMilliseconds;
    private final long timeThresholdInNanoSeconds;

    public TimeBasedInteractionIdentifier() {
        this(0L, 1, null);
    }

    public TimeBasedInteractionIdentifier(long j) {
        this.timeThresholdInMilliseconds = j;
        this.timeThresholdInNanoSeconds = TimeUnit.MILLISECONDS.toNanos(j);
    }

    public /* synthetic */ TimeBasedInteractionIdentifier(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 3000L : j);
    }

    /* JADX INFO: renamed from: getTimeThresholdInMilliseconds$dd_sdk_android_rum_release, reason: from getter */
    public final long getTimeThresholdInMilliseconds() {
        return this.timeThresholdInMilliseconds;
    }

    @Override // com.datadog.android.rum.metric.interactiontonextview.LastInteractionIdentifier
    public boolean validate(PreviousViewLastInteractionContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Long currentViewCreationTimestamp = context.getCurrentViewCreationTimestamp();
        return currentViewCreationTimestamp != null && currentViewCreationTimestamp.longValue() - context.getEventCreatedAtNanos() < this.timeThresholdInNanoSeconds;
    }

    public final boolean defaultThresholdUsed$dd_sdk_android_rum_release() {
        return 3000 == this.timeThresholdInMilliseconds;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.datadog.android.rum.metric.interactiontonextview.TimeBasedInteractionIdentifier");
        return this.timeThresholdInNanoSeconds == ((TimeBasedInteractionIdentifier) other).timeThresholdInNanoSeconds;
    }

    public int hashCode() {
        return Long.hashCode(this.timeThresholdInNanoSeconds);
    }
}

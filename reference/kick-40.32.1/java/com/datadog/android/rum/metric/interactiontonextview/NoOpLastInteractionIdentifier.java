package com.datadog.android.rum.metric.interactiontonextview;

import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpLastInteractionIdentifier.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/metric/interactiontonextview/NoOpLastInteractionIdentifier;", "Lcom/datadog/android/rum/metric/interactiontonextview/LastInteractionIdentifier;", "()V", "validate", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/rum/metric/interactiontonextview/PreviousViewLastInteractionContext;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpLastInteractionIdentifier implements LastInteractionIdentifier {
    @Override // com.datadog.android.rum.metric.interactiontonextview.LastInteractionIdentifier
    public boolean validate(PreviousViewLastInteractionContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return false;
    }
}

package com.datadog.android.rum.internal.metric.interactiontonextview;

import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.rum.model.ActionEvent;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActionTypeInteractionValidator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/datadog/android/rum/internal/metric/interactiontonextview/ActionTypeInteractionValidator;", "Lcom/datadog/android/rum/internal/metric/interactiontonextview/InteractionIngestionValidator;", "()V", "validate", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/rum/internal/metric/interactiontonextview/InternalInteractionContext;", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ActionTypeInteractionValidator implements InteractionIngestionValidator {
    private static final Set<ActionEvent.ActionEventActionType> ALLOWED_TYPES = SetsKt.setOf((Object[]) new ActionEvent.ActionEventActionType[]{ActionEvent.ActionEventActionType.TAP, ActionEvent.ActionEventActionType.SWIPE, ActionEvent.ActionEventActionType.CLICK, ActionEvent.ActionEventActionType.BACK});

    @Override // com.datadog.android.rum.internal.metric.interactiontonextview.InteractionIngestionValidator
    public boolean validate(InternalInteractionContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ALLOWED_TYPES.contains(context.getActionType$dd_sdk_android_rum_release());
    }
}

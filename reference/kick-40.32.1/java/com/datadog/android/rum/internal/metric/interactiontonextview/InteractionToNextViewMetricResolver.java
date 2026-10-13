package com.datadog.android.rum.internal.metric.interactiontonextview;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.rum.internal.domain.event.RumEventMeta;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.rum.internal.metric.NoValueReason;
import com.datadog.android.rum.internal.metric.ViewInitializationMetricsConfig;
import com.datadog.android.rum.internal.metric.ViewInitializationMetricsState;
import com.datadog.android.rum.metric.interactiontonextview.LastInteractionIdentifier;
import com.datadog.android.rum.metric.interactiontonextview.PreviousViewLastInteractionContext;
import com.datadog.android.rum.metric.interactiontonextview.TimeBasedInteractionIdentifier;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InteractionToNextViewMetricResolver.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 &2\u00020\u0001:\u0001&B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bJ\u0019\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u0014H\u0001¢\u0006\u0002\b\u0015J\u0019\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f0\u0014H\u0001¢\u0006\u0002\b\u0016J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\fJ\u0016\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000fJ\b\u0010\u001c\u001a\u00020\u0018H\u0002J\u0017\u0010\u001d\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\u001eJ\u001a\u0010\u001f\u001a\u0004\u0018\u00010\f2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000fH\u0002J\u0015\u0010\"\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u000b¢\u0006\u0002\u0010\u001eJ\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J\u0012\u0010%\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f`\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/datadog/android/rum/internal/metric/interactiontonextview/InteractionToNextViewMetricResolver;", "", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "ingestionValidator", "Lcom/datadog/android/rum/internal/metric/interactiontonextview/InteractionIngestionValidator;", "lastInteractionIdentifier", "Lcom/datadog/android/rum/metric/interactiontonextview/LastInteractionIdentifier;", "(Lcom/datadog/android/api/InternalLogger;Lcom/datadog/android/rum/internal/metric/interactiontonextview/InteractionIngestionValidator;Lcom/datadog/android/rum/metric/interactiontonextview/LastInteractionIdentifier;)V", "lastInteractions", "Ljava/util/LinkedHashMap;", "", "Lcom/datadog/android/rum/internal/metric/interactiontonextview/InternalInteractionContext;", "Lkotlin/collections/LinkedHashMap;", "lastViewCreatedTimestamps", "", "getState", "Lcom/datadog/android/rum/internal/metric/ViewInitializationMetricsState;", RumEventMeta.VIEW_ID_KEY, "lasInteractions", "", "lasInteractions$dd_sdk_android_rum_release", "lastViewCreatedTimestamps$dd_sdk_android_rum_release", "onActionSent", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "onViewCreated", "timestamp", "purgeOldEntries", "resolveCurrentViewCreationTimestamp", "(Ljava/lang/String;)Ljava/lang/Long;", "resolveLastInteraction", "previousViewId", "currentViewCreatedTimestamp", "resolveMetric", "resolveNoValueReason", "Lcom/datadog/android/rum/internal/metric/NoValueReason$InteractionToNextView;", "resolvePreviousViewId", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InteractionToNextViewMetricResolver {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int MAX_ENTRIES = 4;
    private final InteractionIngestionValidator ingestionValidator;
    private final InternalLogger internalLogger;
    private final LastInteractionIdentifier lastInteractionIdentifier;
    private final LinkedHashMap<String, InternalInteractionContext> lastInteractions;
    private final LinkedHashMap<String, Long> lastViewCreatedTimestamps;

    public InteractionToNextViewMetricResolver(InternalLogger internalLogger, InteractionIngestionValidator ingestionValidator, LastInteractionIdentifier lastInteractionIdentifier) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(ingestionValidator, "ingestionValidator");
        this.internalLogger = internalLogger;
        this.ingestionValidator = ingestionValidator;
        this.lastInteractionIdentifier = lastInteractionIdentifier;
        this.lastInteractions = new LinkedHashMap<>();
        this.lastViewCreatedTimestamps = new LinkedHashMap<>();
    }

    public /* synthetic */ InteractionToNextViewMetricResolver(InternalLogger internalLogger, ActionTypeInteractionValidator actionTypeInteractionValidator, TimeBasedInteractionIdentifier timeBasedInteractionIdentifier, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(internalLogger, (i & 2) != 0 ? new ActionTypeInteractionValidator() : actionTypeInteractionValidator, (i & 4) != 0 ? new TimeBasedInteractionIdentifier(0L, 1, null) : timeBasedInteractionIdentifier);
    }

    public final void onViewCreated(String viewId, long timestamp) {
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        if (this.lastInteractionIdentifier == null) {
            return;
        }
        this.lastViewCreatedTimestamps.put(viewId, Long.valueOf(timestamp));
        purgeOldEntries();
    }

    public final void onActionSent(InternalInteractionContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.lastInteractionIdentifier == null) {
            return;
        }
        if (this.ingestionValidator.validate(context)) {
            this.lastInteractions.put(context.getViewId$dd_sdk_android_rum_release(), context);
        }
        purgeOldEntries();
    }

    public final Long resolveMetric(final String viewId) {
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        purgeOldEntries();
        Long lResolveCurrentViewCreationTimestamp = resolveCurrentViewCreationTimestamp(viewId);
        if (lResolveCurrentViewCreationTimestamp != null) {
            long jLongValue = lResolveCurrentViewCreationTimestamp.longValue();
            String strResolvePreviousViewId = resolvePreviousViewId(viewId);
            InternalInteractionContext internalInteractionContextResolveLastInteraction = strResolvePreviousViewId != null ? resolveLastInteraction(strResolvePreviousViewId, jLongValue) : null;
            if (internalInteractionContextResolveLastInteraction != null) {
                long eventCreatedAtNanos$dd_sdk_android_rum_release = jLongValue - internalInteractionContextResolveLastInteraction.getEventCreatedAtNanos$dd_sdk_android_rum_release();
                if (eventCreatedAtNanos$dd_sdk_android_rum_release > 0) {
                    return Long.valueOf(eventCreatedAtNanos$dd_sdk_android_rum_release);
                }
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.metric.interactiontonextview.InteractionToNextViewMetricResolver.resolveMetric.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "[ViewNetworkSettledMetric] The difference between the last interaction and the current view is negative for viewId:" + viewId;
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
            }
        }
        return null;
    }

    public final ViewInitializationMetricsState getState(String viewId) {
        ViewInitializationMetricsConfig config;
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        Long lResolveMetric = resolveMetric(viewId);
        LastInteractionIdentifier lastInteractionIdentifier = this.lastInteractionIdentifier;
        if (lastInteractionIdentifier == null || (config = INSTANCE.toConfig(lastInteractionIdentifier)) == null) {
            config = ViewInitializationMetricsConfig.DISABLED;
        }
        return new ViewInitializationMetricsState(lResolveMetric, config, lResolveMetric == null ? resolveNoValueReason(viewId) : null);
    }

    private final NoValueReason.InteractionToNextView resolveNoValueReason(String viewId) {
        if (this.lastInteractionIdentifier == null) {
            return NoValueReason.InteractionToNextView.DISABLED;
        }
        Long lResolveCurrentViewCreationTimestamp = resolveCurrentViewCreationTimestamp(viewId);
        if (lResolveCurrentViewCreationTimestamp == null) {
            return NoValueReason.InteractionToNextView.UNKNOWN;
        }
        long jLongValue = lResolveCurrentViewCreationTimestamp.longValue();
        String strResolvePreviousViewId = resolvePreviousViewId(viewId);
        if (strResolvePreviousViewId == null) {
            return NoValueReason.InteractionToNextView.NO_PREVIOUS_VIEW;
        }
        if (this.lastInteractions.get(strResolvePreviousViewId) == null) {
            return NoValueReason.InteractionToNextView.NO_ACTION;
        }
        if (resolveLastInteraction(strResolvePreviousViewId, jLongValue) == null) {
            return NoValueReason.InteractionToNextView.NO_ELIGIBLE_ACTION;
        }
        return NoValueReason.InteractionToNextView.UNKNOWN;
    }

    private final void purgeOldEntries() {
        while (this.lastInteractions.entrySet().size() > 4) {
            Set<Map.Entry<String, InternalInteractionContext>> setEntrySet = this.lastInteractions.entrySet();
            Set<Map.Entry<String, InternalInteractionContext>> setEntrySet2 = this.lastInteractions.entrySet();
            Intrinsics.checkNotNullExpressionValue(setEntrySet2, "lastInteractions.entries");
            setEntrySet.remove(CollectionsKt.first(setEntrySet2));
        }
        while (this.lastViewCreatedTimestamps.entrySet().size() > 4) {
            LinkedHashMap<String, Long> linkedHashMap = this.lastViewCreatedTimestamps;
            Set<String> setKeySet = linkedHashMap.keySet();
            Intrinsics.checkNotNullExpressionValue(setKeySet, "lastViewCreatedTimestamps.keys");
            linkedHashMap.remove(CollectionsKt.first(setKeySet));
        }
    }

    private final Long resolveCurrentViewCreationTimestamp(final String viewId) {
        Long l = this.lastViewCreatedTimestamps.get(viewId);
        if (l == null) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.metric.interactiontonextview.InteractionToNextViewMetricResolver.resolveCurrentViewCreationTimestamp.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "[ViewNetworkSettledMetric] The view was not yet created for this viewId:" + viewId;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
        return l;
    }

    private final InternalInteractionContext resolveLastInteraction(String previousViewId, long currentViewCreatedTimestamp) {
        InternalInteractionContext it;
        LastInteractionIdentifier lastInteractionIdentifier = this.lastInteractionIdentifier;
        if (lastInteractionIdentifier == null || (it = this.lastInteractions.get(previousViewId)) == null) {
            return null;
        }
        Companion companion = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (lastInteractionIdentifier.validate(companion.toPreviousViewLastInteractionContext(it, currentViewCreatedTimestamp))) {
            return it;
        }
        return null;
    }

    private final String resolvePreviousViewId(String viewId) {
        Set<String> setKeySet = this.lastViewCreatedTimestamps.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "lastViewCreatedTimestamps.keys");
        int iIndexOf = CollectionsKt.indexOf(setKeySet, viewId);
        Set<String> setKeySet2 = this.lastViewCreatedTimestamps.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet2, "lastViewCreatedTimestamps.keys");
        return (String) CollectionsKt.elementAtOrNull(setKeySet2, iIndexOf - 1);
    }

    public final Map<String, InternalInteractionContext> lasInteractions$dd_sdk_android_rum_release() {
        return this.lastInteractions;
    }

    public final Map<String, Long> lastViewCreatedTimestamps$dd_sdk_android_rum_release() {
        return this.lastViewCreatedTimestamps;
    }

    /* JADX INFO: compiled from: InteractionToNextViewMetricResolver.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0002J\u0014\u0010\b\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/datadog/android/rum/internal/metric/interactiontonextview/InteractionToNextViewMetricResolver$Companion;", "", "()V", "MAX_ENTRIES", "", "toConfig", "Lcom/datadog/android/rum/internal/metric/ViewInitializationMetricsConfig;", "Lcom/datadog/android/rum/metric/interactiontonextview/LastInteractionIdentifier;", "toPreviousViewLastInteractionContext", "Lcom/datadog/android/rum/metric/interactiontonextview/PreviousViewLastInteractionContext;", "Lcom/datadog/android/rum/internal/metric/interactiontonextview/InternalInteractionContext;", "currentViewCreatedTimestamp", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ViewInitializationMetricsConfig toConfig(LastInteractionIdentifier lastInteractionIdentifier) {
            if (!(lastInteractionIdentifier instanceof TimeBasedInteractionIdentifier)) {
                return ViewInitializationMetricsConfig.CUSTOM;
            }
            if (((TimeBasedInteractionIdentifier) lastInteractionIdentifier).defaultThresholdUsed$dd_sdk_android_rum_release()) {
                return ViewInitializationMetricsConfig.TIME_BASED_DEFAULT;
            }
            return ViewInitializationMetricsConfig.TIME_BASED_CUSTOM;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final PreviousViewLastInteractionContext toPreviousViewLastInteractionContext(InternalInteractionContext internalInteractionContext, long j) {
            return new PreviousViewLastInteractionContext(internalInteractionContext.getActionType$dd_sdk_android_rum_release(), internalInteractionContext.getEventCreatedAtNanos$dd_sdk_android_rum_release(), Long.valueOf(j));
        }
    }
}

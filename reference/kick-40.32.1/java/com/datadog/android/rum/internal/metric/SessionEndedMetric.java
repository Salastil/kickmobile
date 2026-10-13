package com.datadog.android.rum.internal.metric;

import com.datadog.android.rum.internal.domain.scope.RumRawEvent;
import com.datadog.android.rum.internal.domain.scope.RumSessionScope;
import com.datadog.android.rum.internal.domain.scope.RumViewManagerScope;
import com.datadog.android.rum.model.ViewEvent;
import com.google.android.gms.cast.MediaError;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;

/* JADX INFO: compiled from: SessionEndedMetric.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\f\b\u0000\u0018\u0000 .2\u00020\u0001:\u0003./0B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0017\u001a\u00020\u0007H\u0002J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0012J\u0006\u0010\u001f\u001a\u00020\u001bJ\u0006\u0010 \u001a\u00020\u001bJ\u000e\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020#J\u0014\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0%H\u0002J\u001c\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070%2\u0006\u0010'\u001a\u00020\u0007H\u0002J\u001e\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010%2\u0006\u0010'\u001a\u00020\u0007H\u0002J\u0016\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010%H\u0002J\u0014\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0%H\u0002J\u0016\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010%H\u0002J\u001c\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010%2\u0006\u0010-\u001a\u00020\u0007R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/datadog/android/rum/internal/metric/SessionEndedMetric;", "", RumSessionScope.RUM_SESSION_ID_BUS_MESSAGE_KEY, "", "startReason", "Lcom/datadog/android/rum/internal/domain/scope/RumSessionScope$StartReason;", "ntpOffsetAtStartMs", "", "hasTrackBackgroundEventsEnabled", "", "(Ljava/lang/String;Lcom/datadog/android/rum/internal/domain/scope/RumSessionScope$StartReason;JZ)V", "errorKindFrequencies", "", "", "firstTrackedView", "Lcom/datadog/android/rum/internal/metric/SessionEndedMetric$TrackedView;", "lastTrackedView", "missedEventCountByType", "Lcom/datadog/android/rum/internal/metric/SessionEndedMetric$MissedEventType;", "sessionReplaySkippedFramesCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "trackedViewsById", "wasStopped", "calculateDuration", "escapeNonAlphanumericCharacters", "key", "onErrorTracked", "", "sdkErrorKind", "onMissedEventTracked", "missedEventType", "onSessionReplaySkippedFrameTracked", "onSessionStopped", "onViewTracked", "rumViewEvent", "Lcom/datadog/android/rum/model/ViewEvent;", "resolveNoViewCountsAttributes", "", "resolveNtpOffsetAttributes", "ntpOffsetAtEnd", "resolveRseAttributes", "resolveSDKErrorsCountAttributes", "resolveTop5ErrorsByKind", "resolveViewCountsAttributes", "toMetricAttributes", "ntpOffsetAtEndMs", "Companion", "MissedEventType", "TrackedView", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SessionEndedMetric {
    public static final String DURATION_KEY = "duration";
    public static final String HAS_BACKGROUND_EVENTS_TRACKING_ENABLED_KEY = "has_background_events_tracking_enabled";
    public static final String METRIC_TYPE_KEY = "metric_type";
    public static final String METRIC_TYPE_VALUE = "rum session ended";
    public static final String NO_VIEW_EVENTS_COUNT_ACTIONS_KEY = "actions";
    public static final String NO_VIEW_EVENTS_COUNT_ERRORS_KEY = "errors";
    public static final String NO_VIEW_EVENTS_COUNT_KEY = "no_view_events_count";
    public static final String NO_VIEW_EVENTS_COUNT_LONG_TASKS_KEY = "long_tasks";
    public static final String NO_VIEW_EVENTS_COUNT_RESOURCES_KEY = "resources";
    public static final String NTP_OFFSET_AT_END_KEY = "at_end";
    public static final String NTP_OFFSET_AT_START_KEY = "at_start";
    public static final String NTP_OFFSET_KEY = "ntp_offset";
    public static final String PRECONDITION_KEY = "precondition";
    public static final String PROCESS_TYPE_KEY = "process_type";
    public static final String PROCESS_TYPE_VALUE = "app";
    public static final String RSE_KEY = "rse";
    public static final String RUM_SESSION_ENDED_METRIC_NAME = "[Mobile Metric] RUM Session Ended";
    public static final String SDK_ERRORS_COUNT_BY_KIND_KEY = "by_kind";
    public static final String SDK_ERRORS_COUNT_KEY = "sdk_errors_count";
    public static final String SDK_ERRORS_COUNT_TOTAL_KEY = "total";
    public static final String SDK_ERROR_DEFAULT_KIND = "Empty error kind";
    public static final String SESSION_REPLAY_SKIPPED_FRAMES_COUNT = "sr_skipped_frames_count";
    private static final int TOP_ERROR_LIMIT = 5;
    public static final String VIEW_COUNTS_APP_LAUNCH_KEY = "app_launch";
    public static final String VIEW_COUNTS_BG_KEY = "background";
    public static final String VIEW_COUNTS_KEY = "views_count";
    public static final String VIEW_COUNTS_TOTAL_KEY = "total";
    public static final String VIEW_COUNT_WITH_HAS_REPLAY = "with_has_replay";
    public static final String WAS_STOPPED_KEY = "was_stopped";
    private final Map<String, Integer> errorKindFrequencies;
    private TrackedView firstTrackedView;
    private final boolean hasTrackBackgroundEventsEnabled;
    private TrackedView lastTrackedView;
    private final Map<MissedEventType, Integer> missedEventCountByType;
    private final long ntpOffsetAtStartMs;
    private final String sessionId;
    private final AtomicInteger sessionReplaySkippedFramesCount;
    private final RumSessionScope.StartReason startReason;
    private final Map<String, TrackedView> trackedViewsById;
    private boolean wasStopped;

    public SessionEndedMetric(String sessionId, RumSessionScope.StartReason startReason, long j, boolean z) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(startReason, "startReason");
        this.sessionId = sessionId;
        this.startReason = startReason;
        this.ntpOffsetAtStartMs = j;
        this.hasTrackBackgroundEventsEnabled = z;
        this.trackedViewsById = new LinkedHashMap();
        this.errorKindFrequencies = new LinkedHashMap();
        this.missedEventCountByType = new LinkedHashMap();
        this.sessionReplaySkippedFramesCount = new AtomicInteger(0);
    }

    public final boolean onViewTracked(ViewEvent rumViewEvent) {
        String url;
        Intrinsics.checkNotNullParameter(rumViewEvent, "rumViewEvent");
        if (!Intrinsics.areEqual(rumViewEvent.getSession().getId(), this.sessionId)) {
            return false;
        }
        TrackedView trackedView = this.trackedViewsById.get(rumViewEvent.getView().getId());
        if (trackedView == null || (url = trackedView.getViewUrl()) == null) {
            url = rumViewEvent.getView().getUrl();
        }
        String str = url;
        TrackedView trackedView2 = this.trackedViewsById.get(rumViewEvent.getView().getId());
        long startMs = trackedView2 != null ? trackedView2.getStartMs() : rumViewEvent.getDate();
        long timeSpent = rumViewEvent.getView().getTimeSpent();
        Boolean hasReplay = rumViewEvent.getSession().getHasReplay();
        TrackedView trackedView3 = new TrackedView(str, startMs, timeSpent, hasReplay != null ? hasReplay.booleanValue() : false);
        this.trackedViewsById.put(rumViewEvent.getView().getId(), trackedView3);
        if (this.firstTrackedView == null) {
            this.firstTrackedView = trackedView3;
        }
        this.lastTrackedView = trackedView3;
        return true;
    }

    public final void onErrorTracked(String sdkErrorKind) {
        if (sdkErrorKind == null) {
            sdkErrorKind = SDK_ERROR_DEFAULT_KIND;
        }
        Map<String, Integer> map = this.errorKindFrequencies;
        Integer num = map.get(sdkErrorKind);
        map.put(sdkErrorKind, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
    }

    public final void onSessionStopped() {
        this.wasStopped = true;
    }

    public final void onMissedEventTracked(MissedEventType missedEventType) {
        Intrinsics.checkNotNullParameter(missedEventType, "missedEventType");
        Map<MissedEventType, Integer> map = this.missedEventCountByType;
        Integer num = map.get(missedEventType);
        map.put(missedEventType, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
    }

    public final void onSessionReplaySkippedFrameTracked() {
        this.sessionReplaySkippedFramesCount.incrementAndGet();
    }

    public final Map<String, Object> toMetricAttributes(long ntpOffsetAtEndMs) {
        return MapsKt.mapOf(TuplesKt.to("metric_type", METRIC_TYPE_VALUE), TuplesKt.to(RSE_KEY, resolveRseAttributes(ntpOffsetAtEndMs)));
    }

    private final long calculateDuration() {
        TrackedView trackedView = this.lastTrackedView;
        if (trackedView == null) {
            return 0L;
        }
        TrackedView trackedView2 = this.firstTrackedView;
        Long lValueOf = trackedView2 != null ? Long.valueOf(TimeUnit.MILLISECONDS.toNanos(trackedView.getStartMs() - trackedView2.getStartMs()) + trackedView.getDurationNs()) : null;
        if (lValueOf != null) {
            return lValueOf.longValue();
        }
        return 0L;
    }

    private final Map<String, Object> resolveRseAttributes(long ntpOffsetAtEnd) {
        return MapsKt.mapOf(TuplesKt.to(PROCESS_TYPE_KEY, PROCESS_TYPE_VALUE), TuplesKt.to(PRECONDITION_KEY, this.startReason.getAsString()), TuplesKt.to("duration", Long.valueOf(calculateDuration())), TuplesKt.to(WAS_STOPPED_KEY, Boolean.valueOf(this.wasStopped)), TuplesKt.to(VIEW_COUNTS_KEY, resolveViewCountsAttributes()), TuplesKt.to(SDK_ERRORS_COUNT_KEY, resolveSDKErrorsCountAttributes()), TuplesKt.to(NO_VIEW_EVENTS_COUNT_KEY, resolveNoViewCountsAttributes()), TuplesKt.to(HAS_BACKGROUND_EVENTS_TRACKING_ENABLED_KEY, Boolean.valueOf(this.hasTrackBackgroundEventsEnabled)), TuplesKt.to(NTP_OFFSET_KEY, resolveNtpOffsetAttributes(ntpOffsetAtEnd)), TuplesKt.to(SESSION_REPLAY_SKIPPED_FRAMES_COUNT, Integer.valueOf(this.sessionReplaySkippedFramesCount.get())));
    }

    private final Map<String, Integer> resolveNoViewCountsAttributes() {
        Pair[] pairArr = new Pair[4];
        Integer num = this.missedEventCountByType.get(MissedEventType.ACTION);
        pairArr[0] = TuplesKt.to(NO_VIEW_EVENTS_COUNT_ACTIONS_KEY, Integer.valueOf(num != null ? num.intValue() : 0));
        Integer num2 = this.missedEventCountByType.get(MissedEventType.RESOURCE);
        pairArr[1] = TuplesKt.to(NO_VIEW_EVENTS_COUNT_RESOURCES_KEY, Integer.valueOf(num2 != null ? num2.intValue() : 0));
        Integer num3 = this.missedEventCountByType.get(MissedEventType.ERROR);
        pairArr[2] = TuplesKt.to(NO_VIEW_EVENTS_COUNT_ERRORS_KEY, Integer.valueOf(num3 != null ? num3.intValue() : 0));
        Integer num4 = this.missedEventCountByType.get(MissedEventType.LONG_TASK);
        pairArr[3] = TuplesKt.to(NO_VIEW_EVENTS_COUNT_LONG_TASKS_KEY, Integer.valueOf(num4 != null ? num4.intValue() : 0));
        return MapsKt.mapOf(pairArr);
    }

    private final Map<String, Long> resolveNtpOffsetAttributes(long ntpOffsetAtEnd) {
        return MapsKt.mapOf(TuplesKt.to(NTP_OFFSET_AT_START_KEY, Long.valueOf(this.ntpOffsetAtStartMs)), TuplesKt.to(NTP_OFFSET_AT_END_KEY, Long.valueOf(ntpOffsetAtEnd)));
    }

    private final Map<String, Object> resolveViewCountsAttributes() {
        int i;
        int i2;
        Pair[] pairArr = new Pair[4];
        int i3 = 0;
        pairArr[0] = TuplesKt.to("total", Integer.valueOf(this.trackedViewsById.size()));
        Collection<TrackedView> collectionValues = this.trackedViewsById.values();
        if ((collectionValues instanceof Collection) && collectionValues.isEmpty()) {
            i = 0;
        } else {
            Iterator<T> it = collectionValues.iterator();
            i = 0;
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((TrackedView) it.next()).getViewUrl(), RumViewManagerScope.RUM_BACKGROUND_VIEW_URL) && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        pairArr[1] = TuplesKt.to("background", Integer.valueOf(i));
        Collection<TrackedView> collectionValues2 = this.trackedViewsById.values();
        if ((collectionValues2 instanceof Collection) && collectionValues2.isEmpty()) {
            i2 = 0;
        } else {
            Iterator<T> it2 = collectionValues2.iterator();
            i2 = 0;
            while (it2.hasNext()) {
                if (Intrinsics.areEqual(((TrackedView) it2.next()).getViewUrl(), RumViewManagerScope.RUM_APP_LAUNCH_VIEW_URL) && (i2 = i2 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        pairArr[2] = TuplesKt.to(VIEW_COUNTS_APP_LAUNCH_KEY, Integer.valueOf(i2));
        Collection<TrackedView> collectionValues3 = this.trackedViewsById.values();
        if (!(collectionValues3 instanceof Collection) || !collectionValues3.isEmpty()) {
            Iterator<T> it3 = collectionValues3.iterator();
            while (it3.hasNext()) {
                if (((TrackedView) it3.next()).getHasReplay() && (i3 = i3 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        pairArr[3] = TuplesKt.to(VIEW_COUNT_WITH_HAS_REPLAY, Integer.valueOf(i3));
        return MapsKt.mapOf(pairArr);
    }

    private final Map<String, Object> resolveSDKErrorsCountAttributes() {
        return MapsKt.mapOf(TuplesKt.to("total", Integer.valueOf(CollectionsKt.sumOfInt(this.errorKindFrequencies.values()))), TuplesKt.to(SDK_ERRORS_COUNT_BY_KIND_KEY, resolveTop5ErrorsByKind()));
    }

    private final Map<String, Integer> resolveTop5ErrorsByKind() {
        List<Map.Entry> listSubList = CollectionsKt.sortedWith(this.errorKindFrequencies.entrySet(), new Comparator() { // from class: com.datadog.android.rum.internal.metric.SessionEndedMetric$resolveTop5ErrorsByKind$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues((Integer) ((Map.Entry) t2).getValue(), (Integer) ((Map.Entry) t).getValue());
            }
        }).subList(0, RangesKt.coerceAtMost(5, this.errorKindFrequencies.size()));
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listSubList, 10)), 16));
        for (Map.Entry entry : listSubList) {
            Pair pair = TuplesKt.to(escapeNonAlphanumericCharacters((String) entry.getKey()), entry.getValue());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    private final String escapeNonAlphanumericCharacters(String key) {
        return new Regex("[^\\w']+").replace(key, "_");
    }

    /* JADX INFO: compiled from: SessionEndedMetric.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/datadog/android/rum/internal/metric/SessionEndedMetric$TrackedView;", "", "viewUrl", "", "startMs", "", "durationNs", "hasReplay", "", "(Ljava/lang/String;JJZ)V", "getDurationNs", "()J", "getHasReplay", "()Z", "getStartMs", "getViewUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class TrackedView {
        private final long durationNs;
        private final boolean hasReplay;
        private final long startMs;
        private final String viewUrl;

        public static /* synthetic */ TrackedView copy$default(TrackedView trackedView, String str, long j, long j2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = trackedView.viewUrl;
            }
            if ((i & 2) != 0) {
                j = trackedView.startMs;
            }
            if ((i & 4) != 0) {
                j2 = trackedView.durationNs;
            }
            if ((i & 8) != 0) {
                z = trackedView.hasReplay;
            }
            boolean z2 = z;
            return trackedView.copy(str, j, j2, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getViewUrl() {
            return this.viewUrl;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getStartMs() {
            return this.startMs;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getDurationNs() {
            return this.durationNs;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getHasReplay() {
            return this.hasReplay;
        }

        public final TrackedView copy(String viewUrl, long startMs, long durationNs, boolean hasReplay) {
            Intrinsics.checkNotNullParameter(viewUrl, "viewUrl");
            return new TrackedView(viewUrl, startMs, durationNs, hasReplay);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TrackedView)) {
                return false;
            }
            TrackedView trackedView = (TrackedView) other;
            return Intrinsics.areEqual(this.viewUrl, trackedView.viewUrl) && this.startMs == trackedView.startMs && this.durationNs == trackedView.durationNs && this.hasReplay == trackedView.hasReplay;
        }

        public int hashCode() {
            return (((((this.viewUrl.hashCode() * 31) + Long.hashCode(this.startMs)) * 31) + Long.hashCode(this.durationNs)) * 31) + Boolean.hashCode(this.hasReplay);
        }

        public String toString() {
            return "TrackedView(viewUrl=" + this.viewUrl + ", startMs=" + this.startMs + ", durationNs=" + this.durationNs + ", hasReplay=" + this.hasReplay + ")";
        }

        public TrackedView(String viewUrl, long j, long j2, boolean z) {
            Intrinsics.checkNotNullParameter(viewUrl, "viewUrl");
            this.viewUrl = viewUrl;
            this.startMs = j;
            this.durationNs = j2;
            this.hasReplay = z;
        }

        public final String getViewUrl() {
            return this.viewUrl;
        }

        public final long getStartMs() {
            return this.startMs;
        }

        public final long getDurationNs() {
            return this.durationNs;
        }

        public final boolean getHasReplay() {
            return this.hasReplay;
        }
    }

    /* JADX INFO: compiled from: SessionEndedMetric.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/datadog/android/rum/internal/metric/SessionEndedMetric$MissedEventType;", "", "(Ljava/lang/String;I)V", "ACTION", "RESOURCE", MediaError.ERROR_TYPE_ERROR, "LONG_TASK", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum MissedEventType {
        ACTION,
        RESOURCE,
        ERROR,
        LONG_TASK;


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: compiled from: SessionEndedMetric.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/internal/metric/SessionEndedMetric$MissedEventType$Companion;", "", "()V", "fromRawEvent", "Lcom/datadog/android/rum/internal/metric/SessionEndedMetric$MissedEventType;", "rawEvent", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final MissedEventType fromRawEvent(RumRawEvent rawEvent) {
                Intrinsics.checkNotNullParameter(rawEvent, "rawEvent");
                if (rawEvent instanceof RumRawEvent.AddError ? true : rawEvent instanceof RumRawEvent.StopResourceWithError) {
                    return MissedEventType.ERROR;
                }
                if (rawEvent instanceof RumRawEvent.StartAction) {
                    return MissedEventType.ACTION;
                }
                if (rawEvent instanceof RumRawEvent.StartResource) {
                    return MissedEventType.RESOURCE;
                }
                if (rawEvent instanceof RumRawEvent.AddLongTask) {
                    return MissedEventType.LONG_TASK;
                }
                return null;
            }
        }
    }
}

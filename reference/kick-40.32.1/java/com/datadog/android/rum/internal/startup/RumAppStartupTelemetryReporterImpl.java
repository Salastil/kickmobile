package com.datadog.android.rum.internal.startup;

import com.datadog.android.api.InternalLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RumAppStartupTelemetryReporterImpl.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/datadog/android/rum/internal/startup/RumAppStartupTelemetryReporterImpl;", "Lcom/datadog/android/rum/internal/startup/RumAppStartupTelemetryReporter;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "appStartupTimeNs", "", "contentProviderCreationTimeNs", "processStartImportance", "", "(Lcom/datadog/android/api/InternalLogger;JJI)V", "reportTTID", "", "info", "Lcom/datadog/android/rum/internal/startup/RumTTIDInfo;", "indexInSession", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RumAppStartupTelemetryReporterImpl implements RumAppStartupTelemetryReporter {
    public static final String KEY_APP_LAUNCH_TTID = "app_launch_ttid";
    public static final String KEY_CP_PROCESS_START_DIFF_NS = "cp_process_start_diff_ns";
    public static final String KEY_DURATION_NS = "duration_ns";
    public static final String KEY_GAP_NS = "app_start_activity_on_create_gap_ns";
    public static final String KEY_HAS_SAVED_INSTANCE_STATE = "has_saved_instance_state";
    public static final String KEY_INDEX_IN_SESSION = "index_in_session";
    public static final String KEY_METRIC_TYPE = "metric_type";
    public static final String KEY_PROCESS_START_IMPORTANCE = "process_start_importance";
    public static final String KEY_SCENARIO = "scenario";
    public static final String KEY_WAS_FORWARDED = "was_forwarded";
    public static final String METRIC_NAME = "[Mobile Metric] App Launch TTID";
    public static final String METRIC_TYPE_VALUE = "app launch ttid";
    private static final float SAMPLING_RATE = 15.0f;
    private final long appStartupTimeNs;
    private final long contentProviderCreationTimeNs;
    private final InternalLogger internalLogger;
    private final int processStartImportance;

    public RumAppStartupTelemetryReporterImpl(InternalLogger internalLogger, long j, long j2, int i) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.internalLogger = internalLogger;
        this.appStartupTimeNs = j;
        this.contentProviderCreationTimeNs = j2;
        this.processStartImportance = i;
    }

    @Override // com.datadog.android.rum.internal.startup.RumAppStartupTelemetryReporter
    public void reportTTID(RumTTIDInfo info, int indexInSession) {
        Intrinsics.checkNotNullParameter(info, "info");
        InternalLogger internalLogger = this.internalLogger;
        AnonymousClass1 anonymousClass1 = new Function0<String>() { // from class: com.datadog.android.rum.internal.startup.RumAppStartupTelemetryReporterImpl.reportTTID.1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return RumAppStartupTelemetryReporterImpl.METRIC_NAME;
            }
        };
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("metric_type", METRIC_TYPE_VALUE);
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        mapCreateMapBuilder.put(KEY_SCENARIO, RumStartupScenarioKt.getName(info.getScenario()));
        mapCreateMapBuilder.put(KEY_DURATION_NS, Long.valueOf(info.getDurationNs()));
        mapCreateMapBuilder.put(KEY_INDEX_IN_SESSION, Integer.valueOf(indexInSession));
        mapCreateMapBuilder.put(KEY_CP_PROCESS_START_DIFF_NS, Long.valueOf(this.contentProviderCreationTimeNs - this.appStartupTimeNs));
        mapCreateMapBuilder.put(KEY_PROCESS_START_IMPORTANCE, Integer.valueOf(this.processStartImportance));
        mapCreateMapBuilder.put(KEY_HAS_SAVED_INSTANCE_STATE, Boolean.valueOf(info.getScenario().getHasSavedInstanceStateBundle()));
        mapCreateMapBuilder.put(KEY_WAS_FORWARDED, Boolean.valueOf(info.getWasForwarded()));
        Long appStartActivityOnCreateGapNs = RumStartupScenarioKt.getAppStartActivityOnCreateGapNs(info.getScenario());
        if (appStartActivityOnCreateGapNs != null) {
            mapCreateMapBuilder.put(KEY_GAP_NS, Long.valueOf(appStartActivityOnCreateGapNs.longValue()));
        }
        Unit unit = Unit.INSTANCE;
        pairArr[1] = TuplesKt.to(KEY_APP_LAUNCH_TTID, MapsKt.build(mapCreateMapBuilder));
        InternalLogger.DefaultImpls.logMetric$default(internalLogger, anonymousClass1, MapsKt.mapOf(pairArr), SAMPLING_RATE, null, 8, null);
    }
}

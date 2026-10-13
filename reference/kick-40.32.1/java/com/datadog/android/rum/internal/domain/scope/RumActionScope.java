package com.datadog.android.rum.internal.domain.scope;

import com.datadog.android.api.context.AccountInfo;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.context.NetworkInfo;
import com.datadog.android.api.context.UserInfo;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.core.InternalSdkCore;
import com.datadog.android.core.internal.utils.DdTagsUtils;
import com.datadog.android.internal.heatmaps.HeatmapIdentifierRegistry;
import com.datadog.android.rum.RumActionType;
import com.datadog.android.rum.RumSessionType;
import com.datadog.android.rum.internal.FeaturesContextResolver;
import com.datadog.android.rum.internal.RumSessionTypeExtKt;
import com.datadog.android.rum.internal.domain.RumContext;
import com.datadog.android.rum.internal.domain.Time;
import com.datadog.android.rum.internal.heatmaps.HeatmapActionResolver;
import com.datadog.android.rum.internal.instrumentation.insights.InsightsCollector;
import com.datadog.android.rum.internal.monitor.AdvancedRumMonitor;
import com.datadog.android.rum.internal.monitor.StorageEvent;
import com.datadog.android.rum.internal.utils.RuntimeUtilsKt;
import com.datadog.android.rum.internal.utils.SdkCoreExtKt;
import com.datadog.android.rum.internal.utils.WriteOperation;
import com.datadog.android.rum.model.ActionEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.bouncycastle.pqc.crypto.newhope.NewHope;

/* JADX INFO: compiled from: RumActionScope.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 y2\u00020\u0001:\u0001yB\u009f\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0002\u0010\u001fJ\u0016\u0010X\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0016J\b\u0010Y\u001a\u00020ZH\u0016JL\u0010[\u001a\u0004\u0018\u00010\u00012\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020_2\"\u0010`\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u00020c0a\u0012\u0004\u0012\u00020c0aj\u0002`d2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\u000f0fH\u0017J\b\u0010g\u001a\u00020\u0006H\u0016JR\u0010h\u001a\u00020c2\u0006\u0010\\\u001a\u00020i2\u0006\u0010j\u001a\u00020\u00112\u0006\u0010^\u001a\u00020_2\"\u0010`\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u00020c0a\u0012\u0004\u0012\u00020c0aj\u0002`d2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\u000f0fH\u0003J\u0010\u0010k\u001a\u00020c2\u0006\u0010j\u001a\u00020\u0011H\u0002J\u0018\u0010l\u001a\u00020c2\u0006\u0010m\u001a\u00020\u000f2\u0006\u0010j\u001a\u00020\u0011H\u0002J\u0018\u0010n\u001a\u00020c2\u0006\u0010\\\u001a\u00020o2\u0006\u0010j\u001a\u00020\u0011H\u0002JJ\u0010p\u001a\u00020c2\u0006\u0010j\u001a\u00020\u00112\u0006\u0010^\u001a\u00020_2\"\u0010`\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u00020c0a\u0012\u0004\u0012\u00020c0aj\u0002`d2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\u000f0fH\u0003J\u0018\u0010q\u001a\u00020c2\u0006\u0010\\\u001a\u00020r2\u0006\u0010j\u001a\u00020\u0011H\u0002J\u0018\u0010s\u001a\u00020c2\u0006\u0010\\\u001a\u00020t2\u0006\u0010j\u001a\u00020\u0011H\u0002JJ\u0010u\u001a\u00020c2\u0006\u0010j\u001a\u00020\u00112\u0006\u0010^\u001a\u00020_2\"\u0010`\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u00020c0a\u0012\u0004\u0012\u00020c0aj\u0002`d2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\u000f0fH\u0003JJ\u0010v\u001a\u00020c2\u0006\u0010j\u001a\u00020\u00112\u0006\u0010^\u001a\u00020_2\"\u0010`\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u00020c0a\u0012\u0004\u0012\u00020c0aj\u0002`d2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\u000f0fH\u0003JJ\u0010w\u001a\u00020c2\u0006\u0010x\u001a\u00020\u00112\u0006\u0010^\u001a\u00020_2\"\u0010`\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u00020c0a\u0012\u0004\u0012\u00020c0aj\u0002`d2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\u000f0fH\u0002R\"\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0!X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R\u0014\u0010/\u001a\u00020\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010)R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u000e\u00103\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00105\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010)\"\u0004\b7\u0010+R\u000e\u00108\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00109\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010&\"\u0004\b;\u0010<R\u000e\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0A0@X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u001a\u0010D\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010)\"\u0004\bF\u0010+R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u0018X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010J\u001a\u00020\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010)R\u001a\u0010L\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u000e\u0010Q\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010R\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bW\u0010N¨\u0006z"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumActionScope;", "Lcom/datadog/android/rum/internal/domain/scope/RumScope;", "parentScope", "sdkCore", "Lcom/datadog/android/core/InternalSdkCore;", "waitForStop", "", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "initialType", "Lcom/datadog/android/rum/RumActionType;", "initialName", "", "initialAttributes", "", "", "serverTimeOffsetInMs", "", "inactivityThresholdMs", "maxDurationMs", "featuresContextResolver", "Lcom/datadog/android/rum/internal/FeaturesContextResolver;", "trackFrustrations", "sampleRate", "", "rumSessionTypeOverride", "Lcom/datadog/android/rum/RumSessionType;", "insightsCollector", "Lcom/datadog/android/rum/internal/instrumentation/insights/InsightsCollector;", "heatmapResolver", "Lcom/datadog/android/rum/internal/heatmaps/HeatmapActionResolver;", "(Lcom/datadog/android/rum/internal/domain/scope/RumScope;Lcom/datadog/android/core/InternalSdkCore;ZLcom/datadog/android/rum/internal/domain/Time;Lcom/datadog/android/rum/RumActionType;Ljava/lang/String;Ljava/util/Map;JJJLcom/datadog/android/rum/internal/FeaturesContextResolver;ZFLcom/datadog/android/rum/RumSessionType;Lcom/datadog/android/rum/internal/instrumentation/insights/InsightsCollector;Lcom/datadog/android/rum/internal/heatmaps/HeatmapActionResolver;)V", "actionAttributes", "", "getActionAttributes$dd_sdk_android_rum_release", "()Ljava/util/Map;", "actionId", "getActionId$dd_sdk_android_rum_release", "()Ljava/lang/String;", "crashCount", "getCrashCount$dd_sdk_android_rum_release", "()J", "setCrashCount$dd_sdk_android_rum_release", "(J)V", "errorCount", "getErrorCount$dd_sdk_android_rum_release", "setErrorCount$dd_sdk_android_rum_release", "eventTimestamp", "getEventTimestamp$dd_sdk_android_rum_release", "getHeatmapResolver$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/internal/heatmaps/HeatmapActionResolver;", "inactivityThresholdNs", "lastInteractionNanos", "longTaskCount", "getLongTaskCount$dd_sdk_android_rum_release", "setLongTaskCount$dd_sdk_android_rum_release", "maxDurationNs", "name", "getName$dd_sdk_android_rum_release", "setName$dd_sdk_android_rum_release", "(Ljava/lang/String;)V", "networkInfo", "Lcom/datadog/android/api/context/NetworkInfo;", "ongoingResourceKeys", "", "Ljava/lang/ref/WeakReference;", "getParentScope", "()Lcom/datadog/android/rum/internal/domain/scope/RumScope;", "resourceCount", "getResourceCount$dd_sdk_android_rum_release", "setResourceCount$dd_sdk_android_rum_release", "getSampleRate$dd_sdk_android_rum_release", "()F", "sent", "startedNanos", "getStartedNanos$dd_sdk_android_rum_release", "stopped", "getStopped$dd_sdk_android_rum_release", "()Z", "setStopped$dd_sdk_android_rum_release", "(Z)V", "stoppedNanos", "type", "getType$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/RumActionType;", "setType$dd_sdk_android_rum_release", "(Lcom/datadog/android/rum/RumActionType;)V", "getWaitForStop", "getCustomAttributes", "getRumContext", "Lcom/datadog/android/rum/internal/domain/RumContext;", "handleEvent", "event", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "writeScope", "Lkotlin/Function1;", "Lcom/datadog/android/api/storage/EventBatchWriter;", "", "Lcom/datadog/android/api/feature/EventWriteScope;", "writer", "Lcom/datadog/android/api/storage/DataWriter;", "isActive", "onError", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddError;", "now", "onLongTask", "onResourceError", "eventKey", "onStartResource", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StartResource;", "onStartView", "onStopAction", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopAction;", "onStopResource", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopResource;", "onStopSession", "onStopView", "sendAction", "endNanos", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RumActionScope implements RumScope {
    public static final long ACTION_INACTIVITY_MS = 100;
    public static final long ACTION_MAX_DURATION_MS = 5000;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Map<String, Object> actionAttributes;
    private final String actionId;
    private long crashCount;
    private long errorCount;
    private final long eventTimestamp;
    private final FeaturesContextResolver featuresContextResolver;
    private final HeatmapActionResolver heatmapResolver;
    private final long inactivityThresholdNs;
    private final InsightsCollector insightsCollector;
    private long lastInteractionNanos;
    private long longTaskCount;
    private final long maxDurationNs;
    private String name;
    private final NetworkInfo networkInfo;
    private final List<WeakReference<Object>> ongoingResourceKeys;
    private final RumScope parentScope;
    private long resourceCount;
    private final RumSessionType rumSessionTypeOverride;
    private final float sampleRate;
    private final InternalSdkCore sdkCore;
    private boolean sent;
    private final long startedNanos;
    private boolean stopped;
    private long stoppedNanos;
    private final boolean trackFrustrations;
    private RumActionType type;
    private final boolean waitForStop;

    public RumActionScope(RumScope parentScope, InternalSdkCore sdkCore, boolean z, Time eventTime, RumActionType initialType, String initialName, Map<String, ? extends Object> initialAttributes, long j, long j2, long j3, FeaturesContextResolver featuresContextResolver, boolean z2, float f, RumSessionType rumSessionType, InsightsCollector insightsCollector, HeatmapActionResolver heatmapActionResolver) {
        Intrinsics.checkNotNullParameter(parentScope, "parentScope");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(eventTime, "eventTime");
        Intrinsics.checkNotNullParameter(initialType, "initialType");
        Intrinsics.checkNotNullParameter(initialName, "initialName");
        Intrinsics.checkNotNullParameter(initialAttributes, "initialAttributes");
        Intrinsics.checkNotNullParameter(featuresContextResolver, "featuresContextResolver");
        Intrinsics.checkNotNullParameter(insightsCollector, "insightsCollector");
        this.parentScope = parentScope;
        this.sdkCore = sdkCore;
        this.waitForStop = z;
        this.featuresContextResolver = featuresContextResolver;
        this.trackFrustrations = z2;
        this.sampleRate = f;
        this.rumSessionTypeOverride = rumSessionType;
        this.insightsCollector = insightsCollector;
        this.heatmapResolver = heatmapActionResolver;
        this.inactivityThresholdNs = TimeUnit.MILLISECONDS.toNanos(j2);
        this.maxDurationNs = TimeUnit.MILLISECONDS.toNanos(j3);
        this.eventTimestamp = eventTime.getTimestamp() + j;
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        this.actionId = string;
        this.type = initialType;
        this.name = initialName;
        long nanoTime = eventTime.getNanoTime();
        this.startedNanos = nanoTime;
        this.stoppedNanos = nanoTime;
        this.lastInteractionNanos = nanoTime;
        this.networkInfo = sdkCore.getNetworkInfo();
        this.actionAttributes = MapsKt.toMutableMap(initialAttributes);
        this.ongoingResourceKeys = new ArrayList();
    }

    @Override // com.datadog.android.rum.internal.domain.scope.RumScope
    public RumScope getParentScope() {
        return this.parentScope;
    }

    public final boolean getWaitForStop() {
        return this.waitForStop;
    }

    public /* synthetic */ RumActionScope(RumScope rumScope, InternalSdkCore internalSdkCore, boolean z, Time time, RumActionType rumActionType, String str, Map map, long j, long j2, long j3, FeaturesContextResolver featuresContextResolver, boolean z2, float f, RumSessionType rumSessionType, InsightsCollector insightsCollector, HeatmapActionResolver heatmapActionResolver, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(rumScope, internalSdkCore, z, time, rumActionType, str, map, j, (i & 256) != 0 ? 100L : j2, (i & 512) != 0 ? 5000L : j3, (i & 1024) != 0 ? new FeaturesContextResolver() : featuresContextResolver, z2, f, rumSessionType, insightsCollector, (i & 32768) != 0 ? null : heatmapActionResolver);
    }

    /* JADX INFO: renamed from: getSampleRate$dd_sdk_android_rum_release, reason: from getter */
    public final float getSampleRate() {
        return this.sampleRate;
    }

    /* JADX INFO: renamed from: getHeatmapResolver$dd_sdk_android_rum_release, reason: from getter */
    public final HeatmapActionResolver getHeatmapResolver() {
        return this.heatmapResolver;
    }

    /* JADX INFO: renamed from: getEventTimestamp$dd_sdk_android_rum_release, reason: from getter */
    public final long getEventTimestamp() {
        return this.eventTimestamp;
    }

    /* JADX INFO: renamed from: getActionId$dd_sdk_android_rum_release, reason: from getter */
    public final String getActionId() {
        return this.actionId;
    }

    /* JADX INFO: renamed from: getType$dd_sdk_android_rum_release, reason: from getter */
    public final RumActionType getType() {
        return this.type;
    }

    public final void setType$dd_sdk_android_rum_release(RumActionType rumActionType) {
        Intrinsics.checkNotNullParameter(rumActionType, "<set-?>");
        this.type = rumActionType;
    }

    /* JADX INFO: renamed from: getName$dd_sdk_android_rum_release, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final void setName$dd_sdk_android_rum_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    /* JADX INFO: renamed from: getStartedNanos$dd_sdk_android_rum_release, reason: from getter */
    public final long getStartedNanos() {
        return this.startedNanos;
    }

    public final Map<String, Object> getActionAttributes$dd_sdk_android_rum_release() {
        return this.actionAttributes;
    }

    /* JADX INFO: renamed from: getResourceCount$dd_sdk_android_rum_release, reason: from getter */
    public final long getResourceCount() {
        return this.resourceCount;
    }

    public final void setResourceCount$dd_sdk_android_rum_release(long j) {
        this.resourceCount = j;
    }

    /* JADX INFO: renamed from: getErrorCount$dd_sdk_android_rum_release, reason: from getter */
    public final long getErrorCount() {
        return this.errorCount;
    }

    public final void setErrorCount$dd_sdk_android_rum_release(long j) {
        this.errorCount = j;
    }

    /* JADX INFO: renamed from: getCrashCount$dd_sdk_android_rum_release, reason: from getter */
    public final long getCrashCount() {
        return this.crashCount;
    }

    public final void setCrashCount$dd_sdk_android_rum_release(long j) {
        this.crashCount = j;
    }

    /* JADX INFO: renamed from: getLongTaskCount$dd_sdk_android_rum_release, reason: from getter */
    public final long getLongTaskCount() {
        return this.longTaskCount;
    }

    public final void setLongTaskCount$dd_sdk_android_rum_release(long j) {
        this.longTaskCount = j;
    }

    /* JADX INFO: renamed from: getStopped$dd_sdk_android_rum_release, reason: from getter */
    public final boolean getStopped() {
        return this.stopped;
    }

    public final void setStopped$dd_sdk_android_rum_release(boolean z) {
        this.stopped = z;
    }

    @Override // com.datadog.android.rum.internal.domain.scope.RumScope
    public RumScope handleEvent(RumRawEvent event, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        Intrinsics.checkNotNullParameter(writeScope, "writeScope");
        Intrinsics.checkNotNullParameter(writer, "writer");
        long nanoTime = event.getEventTime().getNanoTime();
        boolean z = nanoTime - this.lastInteractionNanos > this.inactivityThresholdNs;
        boolean z2 = nanoTime - this.startedNanos > this.maxDurationNs;
        CollectionsKt.removeAll((List) this.ongoingResourceKeys, (Function1) new Function1<WeakReference<Object>, Boolean>() { // from class: com.datadog.android.rum.internal.domain.scope.RumActionScope.handleEvent.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(WeakReference<Object> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.get() == null);
            }
        });
        boolean z3 = this.waitForStop && !this.stopped;
        if (z && this.ongoingResourceKeys.isEmpty() && !z3) {
            sendAction(this.lastInteractionNanos, datadogContext, writeScope, writer);
        } else if (z2) {
            sendAction(nanoTime, datadogContext, writeScope, writer);
        } else if (event instanceof RumRawEvent.SendCustomActionNow) {
            sendAction(this.lastInteractionNanos, datadogContext, writeScope, writer);
        } else if (event instanceof RumRawEvent.StartView) {
            onStartView(nanoTime, datadogContext, writeScope, writer);
        } else if (event instanceof RumRawEvent.StopView) {
            onStopView(nanoTime, datadogContext, writeScope, writer);
        } else if (event instanceof RumRawEvent.StopSession) {
            onStopSession(nanoTime, datadogContext, writeScope, writer);
        } else if (event instanceof RumRawEvent.StopAction) {
            onStopAction((RumRawEvent.StopAction) event, nanoTime);
        } else if (event instanceof RumRawEvent.StartResource) {
            onStartResource((RumRawEvent.StartResource) event, nanoTime);
        } else if (event instanceof RumRawEvent.StopResource) {
            onStopResource((RumRawEvent.StopResource) event, nanoTime);
        } else if (event instanceof RumRawEvent.AddError) {
            onError((RumRawEvent.AddError) event, nanoTime, datadogContext, writeScope, writer);
        } else if (event instanceof RumRawEvent.StopResourceWithError) {
            onResourceError(((RumRawEvent.StopResourceWithError) event).getKey(), nanoTime);
        } else if (event instanceof RumRawEvent.StopResourceWithStackTrace) {
            onResourceError(((RumRawEvent.StopResourceWithStackTrace) event).getKey(), nanoTime);
        } else if (event instanceof RumRawEvent.AddLongTask) {
            onLongTask(nanoTime);
        }
        if (this.sent) {
            return null;
        }
        return this;
    }

    @Override // com.datadog.android.rum.internal.domain.scope.RumScope
    public RumContext getRumContext() {
        return getParentScope().getRumContext();
    }

    @Override // com.datadog.android.rum.internal.domain.scope.RumScope
    public Map<String, Object> getCustomAttributes() {
        return MapsKt.plus(getParentScope().getCustomAttributes(), this.actionAttributes);
    }

    @Override // com.datadog.android.rum.internal.domain.scope.RumScope
    /* JADX INFO: renamed from: isActive */
    public boolean getIsActive() {
        return !this.stopped;
    }

    private final void onStartView(long now, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        this.ongoingResourceKeys.clear();
        sendAction(now, datadogContext, writeScope, writer);
    }

    private final void onStopView(long now, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        this.ongoingResourceKeys.clear();
        sendAction(now, datadogContext, writeScope, writer);
    }

    private final void onStopSession(long now, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        this.ongoingResourceKeys.clear();
        sendAction(now, datadogContext, writeScope, writer);
    }

    private final void onStopAction(RumRawEvent.StopAction event, long now) {
        RumActionType type = event.getType();
        if (type != null) {
            this.type = type;
        }
        String name = event.getName();
        if (name != null) {
            this.name = name;
        }
        this.actionAttributes.putAll(event.getAttributes());
        this.stopped = true;
        this.stoppedNanos = now;
        this.lastInteractionNanos = now;
    }

    private final void onStartResource(RumRawEvent.StartResource event, long now) {
        this.lastInteractionNanos = now;
        this.resourceCount++;
        this.ongoingResourceKeys.add(new WeakReference<>(event.getKey()));
    }

    private final void onStopResource(RumRawEvent.StopResource event, long now) {
        Object next;
        Iterator<T> it = this.ongoingResourceKeys.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((WeakReference) next).get(), event.getKey()));
        WeakReference weakReference = (WeakReference) next;
        if (weakReference != null) {
            this.ongoingResourceKeys.remove(weakReference);
            this.lastInteractionNanos = now;
        }
    }

    private final void onError(RumRawEvent.AddError event, long now, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        this.lastInteractionNanos = now;
        this.errorCount++;
        if (event.isFatal()) {
            this.crashCount++;
            sendAction(now, datadogContext, writeScope, writer);
        }
    }

    private final void onResourceError(Object eventKey, long now) {
        Object next;
        Iterator<T> it = this.ongoingResourceKeys.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((WeakReference) next).get(), eventKey));
        WeakReference weakReference = (WeakReference) next;
        if (weakReference != null) {
            this.ongoingResourceKeys.remove(weakReference);
            this.lastInteractionNanos = now;
            this.resourceCount--;
            this.errorCount++;
        }
    }

    private final void onLongTask(long now) {
        this.lastInteractionNanos = now;
        this.longTaskCount++;
    }

    private final void sendAction(long endNanos, final DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        ActionEvent.ActionEventSessionType action;
        String syntheticsResultId;
        if (this.sent) {
            return;
        }
        final RumActionType rumActionType = this.type;
        final RumContext rumContext = getRumContext();
        final String str = this.name;
        final long j = this.errorCount;
        final long j2 = this.crashCount;
        final long j3 = this.longTaskCount;
        final long j4 = this.resourceCount;
        final long jMax = Math.max(endNanos - this.startedNanos, 1L);
        String syntheticsTestId = rumContext.getSyntheticsTestId();
        final ActionEvent.Synthetics synthetics = (syntheticsTestId == null || StringsKt.isBlank(syntheticsTestId) || (syntheticsResultId = rumContext.getSyntheticsResultId()) == null || StringsKt.isBlank(syntheticsResultId)) ? null : new ActionEvent.Synthetics(rumContext.getSyntheticsTestId(), rumContext.getSyntheticsResultId(), null, null, 12, null);
        RumSessionType rumSessionType = this.rumSessionTypeOverride;
        if (rumSessionType != null) {
            action = RumSessionTypeExtKt.toAction(rumSessionType);
        } else if (synthetics == null) {
            action = ActionEvent.ActionEventSessionType.USER;
        } else {
            action = ActionEvent.ActionEventSessionType.SYNTHETICS;
        }
        final ActionEvent.ActionEventSessionType actionEventSessionType = action;
        final ArrayList arrayList = new ArrayList();
        if (this.trackFrustrations && j > 0 && rumActionType == RumActionType.TAP) {
            arrayList.add(ActionEvent.Type.ERROR_TAP);
        }
        WriteOperation writeOperationNewRumEventWriteOperation$default = SdkCoreExtKt.newRumEventWriteOperation$default(this.sdkCore, datadogContext, writeScope, writer, null, new Function0<Object>() { // from class: com.datadog.android.rum.internal.domain.scope.RumActionScope.sendAction.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ActionEvent.DdAction ddActionResolve;
                UserInfo userInfo = datadogContext.getUserInfo();
                FeaturesContextResolver featuresContextResolver = this.featuresContextResolver;
                DatadogContext datadogContext2 = datadogContext;
                String viewId = rumContext.getViewId();
                if (viewId == null) {
                    viewId = "";
                }
                boolean zResolveViewHasReplay = featuresContextResolver.resolveViewHasReplay(datadogContext2, viewId);
                this.insightsCollector.onAction();
                long eventTimestamp = this.getEventTimestamp();
                ActionEvent.ActionEventAction actionEventAction = new ActionEvent.ActionEventAction(RumEventExtKt.toSchemaType(rumActionType), this.getActionId(), Long.valueOf(jMax), new ActionEvent.ActionEventActionTarget(str), !arrayList.isEmpty() ? new ActionEvent.Frustration(arrayList) : null, new ActionEvent.Error(j), new ActionEvent.Crash(j2), new ActionEvent.LongTask(j3), new ActionEvent.Resource(j4));
                String viewId2 = rumContext.getViewId();
                String str2 = viewId2 == null ? "" : viewId2;
                String viewName = rumContext.getViewName();
                String viewUrl = rumContext.getViewUrl();
                ActionEvent.ActionEventView actionEventView = new ActionEvent.ActionEventView(str2, null, viewUrl == null ? "" : viewUrl, viewName, null, 18, null);
                ActionEvent.Application application = new ActionEvent.Application(rumContext.getApplicationId(), datadogContext.getDeviceInfo().getLocaleInfo().getCurrentLocale());
                ActionEvent.ActionEventSession actionEventSession = new ActionEvent.ActionEventSession(rumContext.getSessionId(), actionEventSessionType, Boolean.valueOf(zResolveViewHasReplay));
                ActionEvent.ActionEventSource actionEventSourceTryFromSource = RumEventExtKt.tryFromSource(ActionEvent.ActionEventSource.INSTANCE, datadogContext.getSource(), this.sdkCore.getInternalLogger());
                ActionEvent.Usr usr = RuntimeUtilsKt.hasUserData(userInfo) ? new ActionEvent.Usr(userInfo.getId(), userInfo.getName(), userInfo.getEmail(), userInfo.getAnonymousId(), MapsKt.toMutableMap(userInfo.getAdditionalProperties())) : null;
                AccountInfo accountInfo = datadogContext.getAccountInfo();
                ActionEvent.Account account = accountInfo != null ? new ActionEvent.Account(accountInfo.getId(), accountInfo.getName(), MapsKt.toMutableMap(accountInfo.getExtraInfo())) : null;
                ActionEvent.Os os = new ActionEvent.Os(datadogContext.getDeviceInfo().getOsName(), datadogContext.getDeviceInfo().getOsVersion(), null, datadogContext.getDeviceInfo().getOsMajorVersion(), 4, null);
                ActionEvent.Device device = new ActionEvent.Device(RumEventExtKt.toActionSchemaType(datadogContext.getDeviceInfo().getDeviceType()), datadogContext.getDeviceInfo().getDeviceName(), datadogContext.getDeviceInfo().getDeviceModel(), datadogContext.getDeviceInfo().getDeviceBrand(), datadogContext.getDeviceInfo().getArchitecture(), null, datadogContext.getDeviceInfo().getLocaleInfo().getLocales(), datadogContext.getDeviceInfo().getLocaleInfo().getTimeZone(), null, null, null, Integer.valueOf(datadogContext.getDeviceInfo().getLogicalCpuCount()), datadogContext.getDeviceInfo().getTotalRam(), datadogContext.getDeviceInfo().isLowRam(), NewHope.SENDA_BYTES, null);
                ActionEvent.Context context = new ActionEvent.Context(MapsKt.toMutableMap(this.getCustomAttributes()));
                ActionEvent.DdSession ddSession = new ActionEvent.DdSession(null, RumEventExtKt.toActionSessionPrecondition(rumContext.getSessionStartReason()), 1, null);
                ActionEvent.Configuration configuration = new ActionEvent.Configuration(Float.valueOf(this.getSampleRate()), null, null, null, null, 30, null);
                HeatmapActionResolver heatmapResolver = this.getHeatmapResolver();
                if (heatmapResolver != null) {
                    String viewUrl2 = rumContext.getViewUrl();
                    if (viewUrl2 == null) {
                        viewUrl2 = "";
                    }
                    ddActionResolve = heatmapResolver.resolve(viewUrl2);
                } else {
                    ddActionResolve = null;
                }
                return new ActionEvent(eventTimestamp, application, datadogContext.getService(), datadogContext.getVersion(), String.valueOf(datadogContext.getVersionCode()), datadogContext.getAppBuildId(), DdTagsUtils.INSTANCE.toDdTagsString(datadogContext), actionEventSession, actionEventSourceTryFromSource, actionEventView, usr, account, null, RumEventExtKt.toActionConnectivity(this.networkInfo), null, synthetics, null, os, device, new ActionEvent.Dd(ddSession, configuration, null, null, ddActionResolve, 12, null), context, null, null, actionEventAction, 6377472, null);
            }
        }, 8, null);
        final StorageEvent.Action action2 = new StorageEvent.Action(arrayList.size(), RumEventExtKt.toSchemaType(rumActionType), this.stoppedNanos);
        writeOperationNewRumEventWriteOperation$default.onError(new Function1<AdvancedRumMonitor, Unit>() { // from class: com.datadog.android.rum.internal.domain.scope.RumActionScope$sendAction$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AdvancedRumMonitor advancedRumMonitor) {
                invoke2(advancedRumMonitor);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AdvancedRumMonitor it) {
                Intrinsics.checkNotNullParameter(it, "it");
                String viewId = rumContext.getViewId();
                if (viewId == null) {
                    viewId = "";
                }
                it.eventDropped(viewId, action2);
            }
        });
        writeOperationNewRumEventWriteOperation$default.onSuccess(new Function1<AdvancedRumMonitor, Unit>() { // from class: com.datadog.android.rum.internal.domain.scope.RumActionScope$sendAction$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AdvancedRumMonitor advancedRumMonitor) {
                invoke2(advancedRumMonitor);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AdvancedRumMonitor it) {
                Intrinsics.checkNotNullParameter(it, "it");
                String viewId = rumContext.getViewId();
                if (viewId == null) {
                    viewId = "";
                }
                it.eventSent(viewId, action2);
            }
        });
        writeOperationNewRumEventWriteOperation$default.submit();
        this.sent = true;
    }

    /* JADX INFO: compiled from: RumActionScope.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\\\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumActionScope$Companion;", "", "()V", "ACTION_INACTIVITY_MS", "", "ACTION_MAX_DURATION_MS", "fromEvent", "Lcom/datadog/android/rum/internal/domain/scope/RumScope;", "parentScope", "sdkCore", "Lcom/datadog/android/core/InternalSdkCore;", "event", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StartAction;", "timestampOffset", "featuresContextResolver", "Lcom/datadog/android/rum/internal/FeaturesContextResolver;", "trackFrustrations", "", "sampleRate", "", "rumSessionTypeOverride", "Lcom/datadog/android/rum/RumSessionType;", "insightsCollector", "Lcom/datadog/android/rum/internal/instrumentation/insights/InsightsCollector;", "heatmapIdentifierRegistry", "Lcom/datadog/android/internal/heatmaps/HeatmapIdentifierRegistry;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RumScope fromEvent(RumScope parentScope, InternalSdkCore sdkCore, RumRawEvent.StartAction event, long timestampOffset, FeaturesContextResolver featuresContextResolver, boolean trackFrustrations, float sampleRate, RumSessionType rumSessionTypeOverride, InsightsCollector insightsCollector, HeatmapIdentifierRegistry heatmapIdentifierRegistry) {
            HeatmapActionResolver.Native crossPlatform;
            Intrinsics.checkNotNullParameter(parentScope, "parentScope");
            Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(featuresContextResolver, "featuresContextResolver");
            Intrinsics.checkNotNullParameter(insightsCollector, "insightsCollector");
            boolean waitForStop = event.getWaitForStop();
            Time eventTime = event.getEventTime();
            RumActionType type = event.getType();
            String name = event.getName();
            Map<String, Object> attributes = event.getAttributes();
            if (event.getCrossPlatformHeatmapActionData() != null && event.getAppPackageName() != null) {
                crossPlatform = new HeatmapActionResolver.CrossPlatform(event.getCrossPlatformHeatmapActionData(), event.getAppPackageName(), sdkCore.getInternalLogger());
            } else {
                crossPlatform = event.getNativeHeatmapActionData() != null ? new HeatmapActionResolver.Native(event.getNativeHeatmapActionData(), heatmapIdentifierRegistry) : null;
            }
            return new RumActionScope(parentScope, sdkCore, waitForStop, eventTime, type, name, attributes, timestampOffset, 0L, 0L, featuresContextResolver, trackFrustrations, sampleRate, rumSessionTypeOverride, insightsCollector, crossPlatform, 768, null);
        }
    }
}

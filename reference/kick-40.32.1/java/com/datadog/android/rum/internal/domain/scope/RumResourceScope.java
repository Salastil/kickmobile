package com.datadog.android.rum.internal.domain.scope;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.AccountInfo;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.context.NetworkInfo;
import com.datadog.android.api.context.UserInfo;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.core.InternalSdkCore;
import com.datadog.android.core.internal.net.FirstPartyHostHeaderTypeResolver;
import com.datadog.android.core.internal.utils.DdTagsUtils;
import com.datadog.android.internal.utils.ThrowableExtKt;
import com.datadog.android.rum.RumAttributes;
import com.datadog.android.rum.RumErrorSource;
import com.datadog.android.rum.RumResourceKind;
import com.datadog.android.rum.RumResourceMethod;
import com.datadog.android.rum.RumSessionType;
import com.datadog.android.rum.internal.FeaturesContextResolver;
import com.datadog.android.rum.internal.RumSessionTypeExtKt;
import com.datadog.android.rum.internal.domain.RumContext;
import com.datadog.android.rum.internal.domain.Time;
import com.datadog.android.rum.internal.domain.event.ResourceTiming;
import com.datadog.android.rum.internal.instrumentation.insights.InsightsCollector;
import com.datadog.android.rum.internal.metric.SessionEndedMetric;
import com.datadog.android.rum.internal.metric.networksettled.InternalResourceContext;
import com.datadog.android.rum.internal.metric.networksettled.NetworkSettledMetricResolver;
import com.datadog.android.rum.internal.monitor.AdvancedRumMonitor;
import com.datadog.android.rum.internal.monitor.StorageEvent;
import com.datadog.android.rum.internal.utils.RuntimeUtilsKt;
import com.datadog.android.rum.internal.utils.SdkCoreExtKt;
import com.datadog.android.rum.internal.utils.StringExtKt;
import com.datadog.android.rum.model.ErrorEvent;
import com.datadog.android.rum.model.ResourceEvent;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.ktor.http.ContentDisposition;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.bouncycastle.pqc.crypto.newhope.NewHope;

/* JADX INFO: compiled from: RumResourceScope.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u007f2\u00020\u0001:\u0001\u007fB\u0085\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001c¢\u0006\u0002\u0010\u001dJ\u0016\u0010K\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000eH\u0016J\b\u0010L\u001a\u00020$H\u0016JL\u0010M\u001a\u0004\u0018\u00010\u00012\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020Q2\"\u0010R\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020U0S\u0012\u0004\u0012\u00020U0Sj\u0002`V2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\n0XH\u0017J\b\u0010Y\u001a\u00020=H\u0016JJ\u0010Z\u001a\u00020U2\u0006\u0010N\u001a\u00020[2\u0006\u0010P\u001a\u00020Q2\"\u0010R\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020U0S\u0012\u0004\u0012\u00020U0Sj\u0002`V2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\n0XH\u0003JJ\u0010\\\u001a\u00020U2\u0006\u0010N\u001a\u00020]2\u0006\u0010P\u001a\u00020Q2\"\u0010R\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020U0S\u0012\u0004\u0012\u00020U0Sj\u0002`V2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\n0XH\u0003JJ\u0010^\u001a\u00020U2\u0006\u0010N\u001a\u00020_2\u0006\u0010P\u001a\u00020Q2\"\u0010R\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020U0S\u0012\u0004\u0012\u00020U0Sj\u0002`V2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\n0XH\u0003JJ\u0010`\u001a\u00020U2\u0006\u0010N\u001a\u00020a2\u0006\u0010P\u001a\u00020Q2\"\u0010R\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020U0S\u0012\u0004\u0012\u00020U0Sj\u0002`V2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\n0XH\u0003J\u001a\u0010b\u001a\n\u0012\u0004\u0012\u00020d\u0018\u00010c2\b\u0010e\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\n\u0010g\u001a\u0004\u0018\u00010hH\u0002JB\u0010i\u001a\u0004\u0018\u00010j2\b\u0010k\u001a\u0004\u0018\u00010\u00062\b\u0010l\u001a\u0004\u0018\u00010\u00062\b\u0010m\u001a\u0004\u0018\u00010\u00062\b\u0010n\u001a\u0004\u0018\u00010\u00062\u000e\u0010o\u001a\n\u0012\u0004\u0012\u00020d\u0018\u00010cH\u0002J\u0010\u0010p\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0002J\n\u0010q\u001a\u0004\u0018\u00010rH\u0002J\u0087\u0001\u0010s\u001a\u00020U2\u0006\u0010t\u001a\u00020\u00062\u0006\u0010u\u001a\u00020v2\b\u0010A\u001a\u0004\u0018\u00010\u00102\b\u0010w\u001a\u0004\u0018\u00010\u00062\b\u0010x\u001a\u0004\u0018\u00010\u00062\b\u0010y\u001a\u0004\u0018\u00010z2\u0006\u0010P\u001a\u00020Q2\"\u0010R\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020U0S\u0012\u0004\u0012\u00020U0Sj\u0002`V2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\n0X2\u0006\u0010{\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010|Jk\u0010}\u001a\u00020U2\u0006\u0010)\u001a\u00020*2\b\u0010A\u001a\u0004\u0018\u00010\u00102\b\u0010>\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010P\u001a\u00020Q2\"\u0010R\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020U0S\u0012\u0004\u0012\u00020U0Sj\u0002`V2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\n0XH\u0002¢\u0006\u0002\u0010~R\u0014\u0010\u001e\u001a\u00020\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\u001cX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0014\u0010\t\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\"\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\n02X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0014\u00105\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u0016X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u000e\u0010<\u001a\u00020=X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010>\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010?R\u000e\u0010@\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010A\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010?R\u001a\u0010B\u001a\u00020=X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0010\u0010G\u001a\u0004\u0018\u00010HX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u00107R\u000e\u0010J\u001a\u00020=X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0080\u0001"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumResourceScope;", "Lcom/datadog/android/rum/internal/domain/scope/RumScope;", "parentScope", "sdkCore", "Lcom/datadog/android/core/InternalSdkCore;", ImagesContract.URL, "", FirebaseAnalytics.Param.METHOD, "Lcom/datadog/android/rum/RumResourceMethod;", "key", "", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "initialAttributes", "", "serverTimeOffsetInMs", "", "firstPartyHostHeaderTypeResolver", "Lcom/datadog/android/core/internal/net/FirstPartyHostHeaderTypeResolver;", "featuresContextResolver", "Lcom/datadog/android/rum/internal/FeaturesContextResolver;", "sampleRate", "", "networkSettledMetricResolver", "Lcom/datadog/android/rum/internal/metric/networksettled/NetworkSettledMetricResolver;", "rumSessionTypeOverride", "Lcom/datadog/android/rum/RumSessionType;", "insightsCollector", "Lcom/datadog/android/rum/internal/instrumentation/insights/InsightsCollector;", "(Lcom/datadog/android/rum/internal/domain/scope/RumScope;Lcom/datadog/android/core/InternalSdkCore;Ljava/lang/String;Lcom/datadog/android/rum/RumResourceMethod;Ljava/lang/Object;Lcom/datadog/android/rum/internal/domain/Time;Ljava/util/Map;JLcom/datadog/android/core/internal/net/FirstPartyHostHeaderTypeResolver;Lcom/datadog/android/rum/internal/FeaturesContextResolver;FLcom/datadog/android/rum/internal/metric/networksettled/NetworkSettledMetricResolver;Lcom/datadog/android/rum/RumSessionType;Lcom/datadog/android/rum/internal/instrumentation/insights/InsightsCollector;)V", "eventTimestamp", "getEventTimestamp$dd_sdk_android_rum_release", "()J", "getFirstPartyHostHeaderTypeResolver$dd_sdk_android_rum_release", "()Lcom/datadog/android/core/internal/net/FirstPartyHostHeaderTypeResolver;", "initialContext", "Lcom/datadog/android/rum/internal/domain/RumContext;", "getInsightsCollector$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/internal/instrumentation/insights/InsightsCollector;", "getKey$dd_sdk_android_rum_release", "()Ljava/lang/Object;", "kind", "Lcom/datadog/android/rum/RumResourceKind;", "getMethod$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/RumResourceMethod;", "networkInfo", "Lcom/datadog/android/api/context/NetworkInfo;", "getParentScope", "()Lcom/datadog/android/rum/internal/domain/scope/RumScope;", "resourceAttributes", "", "getResourceAttributes$dd_sdk_android_rum_release", "()Ljava/util/Map;", "resourceId", "getResourceId$dd_sdk_android_rum_release", "()Ljava/lang/String;", "getSampleRate$dd_sdk_android_rum_release", "()F", "getSdkCore$dd_sdk_android_rum_release", "()Lcom/datadog/android/core/InternalSdkCore;", "sent", "", ContentDisposition.Parameters.Size, "Ljava/lang/Long;", "startedNanos", "statusCode", "stopped", "getStopped$dd_sdk_android_rum_release", "()Z", "setStopped$dd_sdk_android_rum_release", "(Z)V", "timing", "Lcom/datadog/android/rum/internal/domain/event/ResourceTiming;", "getUrl$dd_sdk_android_rum_release", "waitForTiming", "getCustomAttributes", "getRumContext", "handleEvent", "event", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "writeScope", "Lkotlin/Function1;", "Lcom/datadog/android/api/storage/EventBatchWriter;", "", "Lcom/datadog/android/api/feature/EventWriteScope;", "writer", "Lcom/datadog/android/api/storage/DataWriter;", "isActive", "onAddResourceTiming", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddResourceTiming;", "onStopResource", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopResource;", "onStopResourceWithError", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopResourceWithError;", "onStopResourceWithStackTrace", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopResourceWithStackTrace;", "parseGraphQLErrors", "", "Lcom/datadog/android/rum/model/ResourceEvent$Error;", "jsonString", "resolveDomain", "resolveErrorProvider", "Lcom/datadog/android/rum/model/ErrorEvent$Provider;", "resolveGraphQLAttributes", "Lcom/datadog/android/rum/model/ResourceEvent$Graphql;", "operationType", "operationName", "variables", "payload", SessionEndedMetric.NO_VIEW_EVENTS_COUNT_ERRORS_KEY, "resolveResourceDuration", "resolveResourceProvider", "Lcom/datadog/android/rum/model/ResourceEvent$Provider;", "sendError", "message", "source", "Lcom/datadog/android/rum/RumErrorSource;", "stackTrace", "errorType", "errorCategory", "Lcom/datadog/android/rum/model/ErrorEvent$Category;", "resourceStopTimestampInNanos", "(Ljava/lang/String;Lcom/datadog/android/rum/RumErrorSource;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lcom/datadog/android/rum/model/ErrorEvent$Category;Lcom/datadog/android/api/context/DatadogContext;Lkotlin/jvm/functions/Function1;Lcom/datadog/android/api/storage/DataWriter;J)V", "sendResource", "(Lcom/datadog/android/rum/RumResourceKind;Ljava/lang/Long;Ljava/lang/Long;Lcom/datadog/android/rum/internal/domain/Time;Lcom/datadog/android/api/context/DatadogContext;Lkotlin/jvm/functions/Function1;Lcom/datadog/android/api/storage/DataWriter;)V", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RumResourceScope implements RumScope {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int MAX_GRAPHQL_PAYLOAD_SIZE_BYTES = 30720;
    public static final String NEGATIVE_DURATION_WARNING_MESSAGE = "The computed duration for your resource: %s was 0 or negative. In order to keep the resource event we forced it to 1ns.";
    private final long eventTimestamp;
    private final FeaturesContextResolver featuresContextResolver;
    private final FirstPartyHostHeaderTypeResolver firstPartyHostHeaderTypeResolver;
    private final RumContext initialContext;
    private final InsightsCollector insightsCollector;
    private final Object key;
    private RumResourceKind kind;
    private final RumResourceMethod method;
    private final NetworkInfo networkInfo;
    private final RumScope parentScope;
    private final Map<String, Object> resourceAttributes;
    private final String resourceId;
    private final RumSessionType rumSessionTypeOverride;
    private final float sampleRate;
    private final InternalSdkCore sdkCore;
    private boolean sent;
    private Long size;
    private final long startedNanos;
    private Long statusCode;
    private boolean stopped;
    private ResourceTiming timing;
    private final String url;
    private boolean waitForTiming;

    public RumResourceScope(RumScope parentScope, InternalSdkCore sdkCore, String url, RumResourceMethod method, Object key, Time eventTime, Map<String, ? extends Object> initialAttributes, long j, FirstPartyHostHeaderTypeResolver firstPartyHostHeaderTypeResolver, FeaturesContextResolver featuresContextResolver, float f, NetworkSettledMetricResolver networkSettledMetricResolver, RumSessionType rumSessionType, InsightsCollector insightsCollector) {
        Intrinsics.checkNotNullParameter(parentScope, "parentScope");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(eventTime, "eventTime");
        Intrinsics.checkNotNullParameter(initialAttributes, "initialAttributes");
        Intrinsics.checkNotNullParameter(firstPartyHostHeaderTypeResolver, "firstPartyHostHeaderTypeResolver");
        Intrinsics.checkNotNullParameter(featuresContextResolver, "featuresContextResolver");
        Intrinsics.checkNotNullParameter(networkSettledMetricResolver, "networkSettledMetricResolver");
        Intrinsics.checkNotNullParameter(insightsCollector, "insightsCollector");
        this.parentScope = parentScope;
        this.sdkCore = sdkCore;
        this.url = url;
        this.method = method;
        this.key = key;
        this.firstPartyHostHeaderTypeResolver = firstPartyHostHeaderTypeResolver;
        this.featuresContextResolver = featuresContextResolver;
        this.sampleRate = f;
        this.rumSessionTypeOverride = rumSessionType;
        this.insightsCollector = insightsCollector;
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        this.resourceId = string;
        this.resourceAttributes = MapsKt.toMutableMap(initialAttributes);
        this.initialContext = getParentScope().getInitialContext();
        this.eventTimestamp = eventTime.getTimestamp() + j;
        this.startedNanos = eventTime.getNanoTime();
        this.networkInfo = sdkCore.getNetworkInfo();
        this.kind = RumResourceKind.UNKNOWN;
        networkSettledMetricResolver.resourceWasStarted(new InternalResourceContext(string, eventTime.getNanoTime()));
    }

    @Override // com.datadog.android.rum.internal.domain.scope.RumScope
    public RumScope getParentScope() {
        return this.parentScope;
    }

    /* JADX INFO: renamed from: getSdkCore$dd_sdk_android_rum_release, reason: from getter */
    public final InternalSdkCore getSdkCore() {
        return this.sdkCore;
    }

    /* JADX INFO: renamed from: getUrl$dd_sdk_android_rum_release, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: getMethod$dd_sdk_android_rum_release, reason: from getter */
    public final RumResourceMethod getMethod() {
        return this.method;
    }

    /* JADX INFO: renamed from: getKey$dd_sdk_android_rum_release, reason: from getter */
    public final Object getKey() {
        return this.key;
    }

    /* JADX INFO: renamed from: getFirstPartyHostHeaderTypeResolver$dd_sdk_android_rum_release, reason: from getter */
    public final FirstPartyHostHeaderTypeResolver getFirstPartyHostHeaderTypeResolver() {
        return this.firstPartyHostHeaderTypeResolver;
    }

    /* JADX INFO: renamed from: getSampleRate$dd_sdk_android_rum_release, reason: from getter */
    public final float getSampleRate() {
        return this.sampleRate;
    }

    /* JADX INFO: renamed from: getInsightsCollector$dd_sdk_android_rum_release, reason: from getter */
    public final InsightsCollector getInsightsCollector() {
        return this.insightsCollector;
    }

    /* JADX INFO: renamed from: getResourceId$dd_sdk_android_rum_release, reason: from getter */
    public final String getResourceId() {
        return this.resourceId;
    }

    public final Map<String, Object> getResourceAttributes$dd_sdk_android_rum_release() {
        return this.resourceAttributes;
    }

    /* JADX INFO: renamed from: getEventTimestamp$dd_sdk_android_rum_release, reason: from getter */
    public final long getEventTimestamp() {
        return this.eventTimestamp;
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
        if (event instanceof RumRawEvent.WaitForResourceTiming) {
            if (Intrinsics.areEqual(this.key, ((RumRawEvent.WaitForResourceTiming) event).getKey())) {
                this.waitForTiming = true;
            }
        } else if (event instanceof RumRawEvent.AddResourceTiming) {
            onAddResourceTiming((RumRawEvent.AddResourceTiming) event, datadogContext, writeScope, writer);
        } else if (event instanceof RumRawEvent.StopResource) {
            onStopResource((RumRawEvent.StopResource) event, datadogContext, writeScope, writer);
        } else if (event instanceof RumRawEvent.StopResourceWithError) {
            onStopResourceWithError((RumRawEvent.StopResourceWithError) event, datadogContext, writeScope, writer);
        } else if (event instanceof RumRawEvent.StopResourceWithStackTrace) {
            onStopResourceWithStackTrace((RumRawEvent.StopResourceWithStackTrace) event, datadogContext, writeScope, writer);
        }
        if (this.sent) {
            return null;
        }
        return this;
    }

    @Override // com.datadog.android.rum.internal.domain.scope.RumScope
    /* JADX INFO: renamed from: getRumContext, reason: from getter */
    public RumContext getInitialContext() {
        return this.initialContext;
    }

    @Override // com.datadog.android.rum.internal.domain.scope.RumScope
    public Map<String, Object> getCustomAttributes() {
        return MapsKt.plus(getParentScope().getCustomAttributes(), this.resourceAttributes);
    }

    @Override // com.datadog.android.rum.internal.domain.scope.RumScope
    /* JADX INFO: renamed from: isActive */
    public boolean getIsActive() {
        return !this.stopped;
    }

    private final void onStopResource(RumRawEvent.StopResource event, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        if (Intrinsics.areEqual(this.key, event.getKey())) {
            this.stopped = true;
            this.resourceAttributes.putAll(event.getAttributes());
            this.kind = event.getKind();
            this.statusCode = event.getStatusCode();
            this.size = event.getSize();
            if (this.waitForTiming && this.timing == null) {
                return;
            }
            sendResource(this.kind, event.getStatusCode(), event.getSize(), event.getEventTime(), datadogContext, writeScope, writer);
        }
    }

    private final void onAddResourceTiming(RumRawEvent.AddResourceTiming event, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        if (Intrinsics.areEqual(this.key, event.getKey())) {
            this.timing = event.getTiming();
            if (!this.stopped || this.sent) {
                return;
            }
            sendResource(this.kind, this.statusCode, this.size, event.getEventTime(), datadogContext, writeScope, writer);
        }
    }

    private final void onStopResourceWithError(RumRawEvent.StopResourceWithError event, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        if (Intrinsics.areEqual(this.key, event.getKey())) {
            this.resourceAttributes.putAll(event.getAttributes());
            sendError(event.getMessage(), event.getSource(), event.getStatusCode(), ThrowableExtKt.loggableStackTrace(event.getThrowable()), event.getThrowable().getClass().getCanonicalName(), ErrorEvent.Category.EXCEPTION, datadogContext, writeScope, writer, event.getEventTime().getNanoTime());
        }
    }

    private final void onStopResourceWithStackTrace(RumRawEvent.StopResourceWithStackTrace event, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        if (Intrinsics.areEqual(this.key, event.getKey())) {
            this.resourceAttributes.putAll(event.getAttributes());
            sendError(event.getMessage(), event.getSource(), event.getStatusCode(), event.getStackTrace(), event.getErrorType(), event.getStackTrace().length() > 0 ? ErrorEvent.Category.EXCEPTION : null, datadogContext, writeScope, writer, event.getEventTime().getNanoTime());
        }
    }

    /* JADX WARN: Code duplicated, block: B:80:0x0153  */
    private final void sendResource(final RumResourceKind kind, final Long statusCode, final Long size, final Time eventTime, final DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        ResourceEvent.ResourceEventSessionType resource;
        final ResourceEvent.Request request;
        Pair<String, Integer> pairTruncateToUtf8ByteSize;
        String syntheticsResultId;
        Object objRemove = this.resourceAttributes.remove(RumAttributes.TRACE_ID);
        ResourceEvent.Response response = null;
        final String string = objRemove != null ? objRemove.toString() : null;
        Object objRemove2 = this.resourceAttributes.remove(RumAttributes.SPAN_ID);
        final String string2 = objRemove2 != null ? objRemove2.toString() : null;
        Object objRemove3 = this.resourceAttributes.remove("_dd.rule_psr");
        final Number number = objRemove3 instanceof Number ? (Number) objRemove3 : null;
        final RumContext initialContext = getInitialContext();
        String syntheticsTestId = initialContext.getSyntheticsTestId();
        final ResourceEvent.Synthetics synthetics = (syntheticsTestId == null || StringsKt.isBlank(syntheticsTestId) || (syntheticsResultId = initialContext.getSyntheticsResultId()) == null || StringsKt.isBlank(syntheticsResultId)) ? null : new ResourceEvent.Synthetics(initialContext.getSyntheticsTestId(), initialContext.getSyntheticsResultId(), null, null, 12, null);
        RumSessionType rumSessionType = this.rumSessionTypeOverride;
        if (rumSessionType != null) {
            resource = RumSessionTypeExtKt.toResource(rumSessionType);
        } else if (synthetics == null) {
            resource = ResourceEvent.ResourceEventSessionType.USER;
        } else {
            resource = ResourceEvent.ResourceEventSessionType.SYNTHETICS;
        }
        final ResourceEvent.ResourceEventSessionType resourceEventSessionType = resource;
        ResourceTiming resourceTimingExtractResourceTiming = this.timing;
        if (resourceTimingExtractResourceTiming == null) {
            Object objRemove4 = this.resourceAttributes.remove(RumAttributes.RESOURCE_TIMINGS);
            resourceTimingExtractResourceTiming = ExternalResourceTimingsKt.extractResourceTiming(objRemove4 instanceof Map ? (Map) objRemove4 : null);
        }
        final ResourceTiming resourceTiming = resourceTimingExtractResourceTiming;
        Object objRemove5 = this.resourceAttributes.remove(RumAttributes.GRAPHQL_OPERATION_NAME);
        String str = objRemove5 instanceof String ? (String) objRemove5 : null;
        Object objRemove6 = this.resourceAttributes.remove(RumAttributes.GRAPHQL_OPERATION_TYPE);
        String str2 = objRemove6 instanceof String ? (String) objRemove6 : null;
        Object objRemove7 = this.resourceAttributes.remove(RumAttributes.GRAPHQL_VARIABLES);
        String str3 = objRemove7 instanceof String ? (String) objRemove7 : null;
        Object objRemove8 = this.resourceAttributes.remove(RumAttributes.GRAPHQL_PAYLOAD);
        String str4 = objRemove8 instanceof String ? (String) objRemove8 : null;
        String first = (str4 == null || (pairTruncateToUtf8ByteSize = StringExtKt.truncateToUtf8ByteSize(str4, MAX_GRAPHQL_PAYLOAD_SIZE_BYTES, this.sdkCore.getInternalLogger())) == null) ? null : pairTruncateToUtf8ByteSize.getFirst();
        Object objRemove9 = this.resourceAttributes.remove(RumAttributes.GRAPHQL_ERRORS);
        final ResourceEvent.Graphql graphqlResolveGraphQLAttributes = resolveGraphQLAttributes(str2, str, str3, first, parseGraphQLErrors(objRemove9 instanceof String ? (String) objRemove9 : null));
        Object objRemove10 = this.resourceAttributes.remove(RumAttributes.REQUEST_HEADERS);
        Map map = objRemove10 instanceof Map ? (Map) objRemove10 : null;
        Object objRemove11 = this.resourceAttributes.remove(RumAttributes.RESPONSE_HEADERS);
        Map map2 = objRemove11 instanceof Map ? (Map) objRemove11 : null;
        if (map == null) {
            request = null;
        } else {
            if (map.isEmpty()) {
                map = null;
            }
            if (map != null) {
                request = new ResourceEvent.Request(null, null, new ResourceEvent.RequestHeaders(MapsKt.toMutableMap(map)), 3, null);
            } else {
                request = null;
            }
        }
        if (map2 != null) {
            if (map2.isEmpty()) {
                map2 = null;
            }
            if (map2 != null) {
                response = new ResourceEvent.Response(new ResourceEvent.RequestHeaders(MapsKt.toMutableMap(map2)));
            }
        }
        final ResourceEvent.Response response2 = response;
        SdkCoreExtKt.newRumEventWriteOperation$default(this.sdkCore, datadogContext, writeScope, writer, null, new Function0<Object>() { // from class: com.datadog.android.rum.internal.domain.scope.RumResourceScope.sendResource.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                UserInfo userInfo = datadogContext.getUserInfo();
                FeaturesContextResolver featuresContextResolver = this.featuresContextResolver;
                DatadogContext datadogContext2 = datadogContext;
                String viewId = initialContext.getViewId();
                if (viewId == null) {
                    viewId = "";
                }
                boolean zResolveViewHasReplay = featuresContextResolver.resolveViewHasReplay(datadogContext2, viewId);
                long jResolveResourceDuration = this.resolveResourceDuration(eventTime);
                this.getInsightsCollector().onNetworkRequest(jResolveResourceDuration);
                long eventTimestamp = this.getEventTimestamp();
                String resourceId = this.getResourceId();
                ResourceEvent.ResourceType schemaType = RumEventExtKt.toSchemaType(kind);
                String url = this.getUrl();
                ResourceEvent.Method resourceMethod = RumEventExtKt.toResourceMethod(this.getMethod());
                ResourceTiming resourceTiming2 = resourceTiming;
                ResourceEvent.Dns dns = resourceTiming2 != null ? RumEventExtKt.dns(resourceTiming2) : null;
                ResourceTiming resourceTiming3 = resourceTiming;
                ResourceEvent.Connect connect = resourceTiming3 != null ? RumEventExtKt.connect(resourceTiming3) : null;
                ResourceTiming resourceTiming4 = resourceTiming;
                ResourceEvent.Ssl ssl = resourceTiming4 != null ? RumEventExtKt.ssl(resourceTiming4) : null;
                ResourceTiming resourceTiming5 = resourceTiming;
                ResourceEvent.FirstByte firstByte = resourceTiming5 != null ? RumEventExtKt.firstByte(resourceTiming5) : null;
                ResourceTiming resourceTiming6 = resourceTiming;
                ResourceEvent.Resource resource2 = new ResourceEvent.Resource(resourceId, schemaType, resourceMethod, url, statusCode, Long.valueOf(jResolveResourceDuration), size, null, null, null, null, null, null, dns, connect, ssl, firstByte, resourceTiming6 != null ? RumEventExtKt.download(resourceTiming6) : null, null, null, this.resolveResourceProvider(), request, response2, graphqlResolveGraphQLAttributes, 794496, null);
                String actionId = initialContext.getActionId();
                ResourceEvent.Action action = actionId != null ? new ResourceEvent.Action(CollectionsKt.listOf(actionId)) : null;
                String viewId2 = initialContext.getViewId();
                String str5 = viewId2 == null ? "" : viewId2;
                String viewName = initialContext.getViewName();
                String viewUrl = initialContext.getViewUrl();
                ResourceEvent.ResourceEventView resourceEventView = new ResourceEvent.ResourceEventView(str5, null, viewUrl == null ? "" : viewUrl, viewName, 2, null);
                ResourceEvent.Usr usr = RuntimeUtilsKt.hasUserData(userInfo) ? new ResourceEvent.Usr(userInfo.getId(), userInfo.getName(), userInfo.getEmail(), userInfo.getAnonymousId(), MapsKt.toMutableMap(userInfo.getAdditionalProperties())) : null;
                AccountInfo accountInfo = datadogContext.getAccountInfo();
                ResourceEvent.Account account = accountInfo != null ? new ResourceEvent.Account(accountInfo.getId(), accountInfo.getName(), MapsKt.toMutableMap(accountInfo.getExtraInfo())) : null;
                ResourceEvent.Connectivity resourceConnectivity = RumEventExtKt.toResourceConnectivity(this.networkInfo);
                return new ResourceEvent(eventTimestamp, new ResourceEvent.Application(initialContext.getApplicationId(), datadogContext.getDeviceInfo().getLocaleInfo().getCurrentLocale()), datadogContext.getService(), datadogContext.getVersion(), String.valueOf(datadogContext.getVersionCode()), datadogContext.getAppBuildId(), DdTagsUtils.INSTANCE.toDdTagsString(datadogContext), new ResourceEvent.ResourceEventSession(initialContext.getSessionId(), resourceEventSessionType, Boolean.valueOf(zResolveViewHasReplay)), RumEventExtKt.tryFromSource(ResourceEvent.ResourceEventSource.INSTANCE, datadogContext.getSource(), this.getSdkCore().getInternalLogger()), resourceEventView, usr, account, null, resourceConnectivity, null, synthetics, null, new ResourceEvent.Os(datadogContext.getDeviceInfo().getOsName(), datadogContext.getDeviceInfo().getOsVersion(), null, datadogContext.getDeviceInfo().getOsMajorVersion(), 4, null), new ResourceEvent.Device(RumEventExtKt.toResourceSchemaType(datadogContext.getDeviceInfo().getDeviceType()), datadogContext.getDeviceInfo().getDeviceName(), datadogContext.getDeviceInfo().getDeviceModel(), datadogContext.getDeviceInfo().getDeviceBrand(), datadogContext.getDeviceInfo().getArchitecture(), null, datadogContext.getDeviceInfo().getLocaleInfo().getLocales(), datadogContext.getDeviceInfo().getLocaleInfo().getTimeZone(), null, null, null, Integer.valueOf(datadogContext.getDeviceInfo().getLogicalCpuCount()), datadogContext.getDeviceInfo().getTotalRam(), datadogContext.getDeviceInfo().isLowRam(), NewHope.SENDA_BYTES, null), new ResourceEvent.Dd(new ResourceEvent.DdSession(null, RumEventExtKt.toResourceSessionPrecondition(initialContext.getSessionStartReason()), 1, null), new ResourceEvent.Configuration(Float.valueOf(this.getSampleRate()), null, null, null, null, 30, null), null, null, string2, null, string, number, null, 300, null), new ResourceEvent.Context(MapsKt.toMutableMap(this.getCustomAttributes())), null, action, null, resource2, 10571776, null);
            }
        }, 8, null).onError(new Function1<AdvancedRumMonitor, Unit>() { // from class: com.datadog.android.rum.internal.domain.scope.RumResourceScope.sendResource.2
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
                String viewId = initialContext.getViewId();
                if (viewId == null) {
                    viewId = "";
                }
                it.eventDropped(viewId, new StorageEvent.Resource(this.getResourceId(), eventTime.getNanoTime()));
            }
        }).onSuccess(new Function1<AdvancedRumMonitor, Unit>() { // from class: com.datadog.android.rum.internal.domain.scope.RumResourceScope.sendResource.3
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
                String viewId = initialContext.getViewId();
                if (viewId == null) {
                    viewId = "";
                }
                it.eventSent(viewId, new StorageEvent.Resource(this.getResourceId(), eventTime.getNanoTime()));
            }
        }).submit();
        this.sent = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long resolveResourceDuration(Time eventTime) {
        long nanoTime = eventTime.getNanoTime() - this.startedNanos;
        if (nanoTime > 0) {
            return nanoTime;
        }
        InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.scope.RumResourceScope.resolveResourceDuration.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str = String.format(Locale.US, RumResourceScope.NEGATIVE_DURATION_WARNING_MESSAGE, Arrays.copyOf(new Object[]{RumResourceScope.this.getUrl()}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return str;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
        return 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ResourceEvent.Provider resolveResourceProvider() {
        if (this.firstPartyHostHeaderTypeResolver.isFirstPartyUrl(this.url)) {
            return new ResourceEvent.Provider(resolveDomain(this.url), null, ResourceEvent.ProviderType.FIRST_PARTY, 2, null);
        }
        return null;
    }

    private final void sendError(final String message, final RumErrorSource source, final Long statusCode, final String stackTrace, final String errorType, final ErrorEvent.Category errorCategory, final DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer, final long resourceStopTimestampInNanos) {
        ErrorEvent.Synthetics synthetics;
        final String str;
        ErrorEvent.ErrorEventSessionType error;
        String syntheticsResultId;
        Object objRemove = this.resourceAttributes.remove("_dd.error.fingerprint");
        if (objRemove instanceof String) {
            str = (String) objRemove;
            synthetics = null;
        } else {
            synthetics = null;
            str = null;
        }
        final RumContext initialContext = getInitialContext();
        String syntheticsTestId = initialContext.getSyntheticsTestId();
        final ErrorEvent.Synthetics synthetics2 = (syntheticsTestId == null || StringsKt.isBlank(syntheticsTestId) || (syntheticsResultId = initialContext.getSyntheticsResultId()) == null || StringsKt.isBlank(syntheticsResultId)) ? synthetics : new ErrorEvent.Synthetics(initialContext.getSyntheticsTestId(), initialContext.getSyntheticsResultId(), null, null, 12, null);
        RumSessionType rumSessionType = this.rumSessionTypeOverride;
        if (rumSessionType != null) {
            error = RumSessionTypeExtKt.toError(rumSessionType);
        } else if (synthetics2 == null) {
            error = ErrorEvent.ErrorEventSessionType.USER;
        } else {
            error = ErrorEvent.ErrorEventSessionType.SYNTHETICS;
        }
        final ErrorEvent.ErrorEventSessionType errorEventSessionType = error;
        SdkCoreExtKt.newRumEventWriteOperation$default(this.sdkCore, datadogContext, writeScope, writer, null, new Function0<Object>() { // from class: com.datadog.android.rum.internal.domain.scope.RumResourceScope.sendError.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                UserInfo userInfo = datadogContext.getUserInfo();
                FeaturesContextResolver featuresContextResolver = this.featuresContextResolver;
                DatadogContext datadogContext2 = datadogContext;
                String viewId = initialContext.getViewId();
                if (viewId == null) {
                    viewId = "";
                }
                boolean zResolveViewHasReplay = featuresContextResolver.resolveViewHasReplay(datadogContext2, viewId);
                String appBuildId = datadogContext.getAppBuildId();
                long eventTimestamp = this.getEventTimestamp();
                String string = UUID.randomUUID().toString();
                ErrorEvent.ErrorSource schemaSource = RumEventExtKt.toSchemaSource(source);
                String url = this.getUrl();
                ErrorEvent.Method errorMethod = RumEventExtKt.toErrorMethod(this.getMethod());
                Long l = statusCode;
                ErrorEvent.Error error2 = new ErrorEvent.Error(string, message, schemaSource, stackTrace, null, false, str, errorType, errorCategory, null, null, ErrorEvent.SourceType.ANDROID, new ErrorEvent.Resource(errorMethod, l != null ? l.longValue() : 0L, url, this.resolveErrorProvider()), null, null, null, null, null, null, 517648, null);
                String actionId = initialContext.getActionId();
                ErrorEvent.Action action = actionId != null ? new ErrorEvent.Action(CollectionsKt.listOf(actionId)) : null;
                String viewId2 = initialContext.getViewId();
                String str2 = viewId2 == null ? "" : viewId2;
                String viewName = initialContext.getViewName();
                String viewUrl = initialContext.getViewUrl();
                ErrorEvent.ErrorEventView errorEventView = new ErrorEvent.ErrorEventView(str2, null, viewUrl == null ? "" : viewUrl, viewName, null, 18, null);
                ErrorEvent.Usr usr = RuntimeUtilsKt.hasUserData(userInfo) ? new ErrorEvent.Usr(userInfo.getId(), userInfo.getName(), userInfo.getEmail(), userInfo.getAnonymousId(), MapsKt.toMutableMap(userInfo.getAdditionalProperties())) : null;
                AccountInfo accountInfo = datadogContext.getAccountInfo();
                ErrorEvent.Account account = accountInfo != null ? new ErrorEvent.Account(accountInfo.getId(), accountInfo.getName(), MapsKt.toMutableMap(accountInfo.getExtraInfo())) : null;
                ErrorEvent.Connectivity errorConnectivity = RumEventExtKt.toErrorConnectivity(this.networkInfo);
                return new ErrorEvent(eventTimestamp, new ErrorEvent.Application(initialContext.getApplicationId(), null, 2, null), datadogContext.getService(), datadogContext.getVersion(), String.valueOf(datadogContext.getVersionCode()), appBuildId, DdTagsUtils.INSTANCE.toDdTagsString(datadogContext), new ErrorEvent.ErrorEventSession(initialContext.getSessionId(), errorEventSessionType, Boolean.valueOf(zResolveViewHasReplay)), RumEventExtKt.tryFromSource(ErrorEvent.ErrorEventSource.INSTANCE, datadogContext.getSource(), this.getSdkCore().getInternalLogger()), errorEventView, usr, account, null, errorConnectivity, null, synthetics2, null, new ErrorEvent.Os(datadogContext.getDeviceInfo().getOsName(), datadogContext.getDeviceInfo().getOsVersion(), null, datadogContext.getDeviceInfo().getOsMajorVersion(), 4, null), new ErrorEvent.Device(RumEventExtKt.toErrorSchemaType(datadogContext.getDeviceInfo().getDeviceType()), datadogContext.getDeviceInfo().getDeviceName(), datadogContext.getDeviceInfo().getDeviceModel(), datadogContext.getDeviceInfo().getDeviceBrand(), datadogContext.getDeviceInfo().getArchitecture(), null, null, null, null, null, null, Integer.valueOf(datadogContext.getDeviceInfo().getLogicalCpuCount()), datadogContext.getDeviceInfo().getTotalRam(), datadogContext.getDeviceInfo().isLowRam(), 2016, null), new ErrorEvent.Dd(new ErrorEvent.DdSession(null, RumEventExtKt.toErrorSessionPrecondition(initialContext.getSessionStartReason()), 1, null), new ErrorEvent.Configuration(Float.valueOf(this.getSampleRate()), null, null, null, null, 30, null), null, null, null, 28, null), new ErrorEvent.Context(MapsKt.toMutableMap(this.getCustomAttributes())), null, action, null, error2, null, null, 111235072, null);
            }
        }, 8, null).onError(new Function1<AdvancedRumMonitor, Unit>() { // from class: com.datadog.android.rum.internal.domain.scope.RumResourceScope.sendError.2
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
                String viewId = initialContext.getViewId();
                if (viewId == null) {
                    viewId = "";
                }
                it.eventDropped(viewId, new StorageEvent.Error(this.getResourceId(), Long.valueOf(resourceStopTimestampInNanos)));
            }
        }).onSuccess(new Function1<AdvancedRumMonitor, Unit>() { // from class: com.datadog.android.rum.internal.domain.scope.RumResourceScope.sendError.3
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
                String viewId = initialContext.getViewId();
                if (viewId == null) {
                    viewId = "";
                }
                it.eventSent(viewId, new StorageEvent.Error(this.getResourceId(), Long.valueOf(resourceStopTimestampInNanos)));
            }
        }).submit();
        this.sent = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ErrorEvent.Provider resolveErrorProvider() {
        if (this.firstPartyHostHeaderTypeResolver.isFirstPartyUrl(this.url)) {
            return new ErrorEvent.Provider(resolveDomain(this.url), null, ErrorEvent.ProviderType.FIRST_PARTY, 2, null);
        }
        return null;
    }

    private final String resolveDomain(String url) {
        try {
            String host = new URL(url).getHost();
            Intrinsics.checkNotNullExpressionValue(host, "{\n            URL(url).host\n        }");
            return host;
        } catch (MalformedURLException unused) {
            return url;
        }
    }

    private final ResourceEvent.Graphql resolveGraphQLAttributes(String operationType, String operationName, String variables, String payload, List<ResourceEvent.Error> errors) {
        ResourceEvent.OperationType operationType2;
        if (operationType == null || (operationType2 = RumEventExtKt.toOperationType(operationType, this.sdkCore.getInternalLogger())) == null) {
            return null;
        }
        return new ResourceEvent.Graphql(operationType2, operationName, payload, variables, errors != null ? Long.valueOf(errors.size()) : null, errors);
    }

    private final List<ResourceEvent.Error> parseGraphQLErrors(String jsonString) {
        String str = jsonString;
        if (str != null && str.length() != 0) {
            try {
                JsonArray jsonArray = JsonParser.parseString(jsonString).getAsJsonArray();
                Intrinsics.checkNotNullExpressionValue(jsonArray, "jsonArray");
                JsonArray jsonArray2 = jsonArray;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonArray2, 10));
                for (JsonElement jsonElement : jsonArray2) {
                    ResourceEvent.Error.Companion companion = ResourceEvent.Error.INSTANCE;
                    JsonObject asJsonObject = jsonElement.getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(asJsonObject, "it.asJsonObject");
                    arrayList.add(companion.fromJsonObject(asJsonObject));
                }
                return arrayList;
            } catch (Exception e) {
                InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.scope.RumResourceScope.parseGraphQLErrors.2
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Failed to parse GraphQL errors from attribute";
                    }
                }, (Throwable) e, false, (Map) null, 48, (Object) null);
            }
        }
        return null;
    }

    /* JADX INFO: compiled from: RumResourceScope.kt */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JX\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumResourceScope$Companion;", "", "()V", "MAX_GRAPHQL_PAYLOAD_SIZE_BYTES", "", "NEGATIVE_DURATION_WARNING_MESSAGE", "", "fromEvent", "Lcom/datadog/android/rum/internal/domain/scope/RumScope;", "parentScope", "sdkCore", "Lcom/datadog/android/core/InternalSdkCore;", "event", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StartResource;", "firstPartyHostHeaderTypeResolver", "Lcom/datadog/android/core/internal/net/FirstPartyHostHeaderTypeResolver;", "timestampOffset", "", "featuresContextResolver", "Lcom/datadog/android/rum/internal/FeaturesContextResolver;", "sampleRate", "", "networkSettledMetricResolver", "Lcom/datadog/android/rum/internal/metric/networksettled/NetworkSettledMetricResolver;", "rumSessionTypeOverride", "Lcom/datadog/android/rum/RumSessionType;", "insightsCollector", "Lcom/datadog/android/rum/internal/instrumentation/insights/InsightsCollector;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RumScope fromEvent(RumScope parentScope, InternalSdkCore sdkCore, RumRawEvent.StartResource event, FirstPartyHostHeaderTypeResolver firstPartyHostHeaderTypeResolver, long timestampOffset, FeaturesContextResolver featuresContextResolver, float sampleRate, NetworkSettledMetricResolver networkSettledMetricResolver, RumSessionType rumSessionTypeOverride, InsightsCollector insightsCollector) {
            Intrinsics.checkNotNullParameter(parentScope, "parentScope");
            Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(firstPartyHostHeaderTypeResolver, "firstPartyHostHeaderTypeResolver");
            Intrinsics.checkNotNullParameter(featuresContextResolver, "featuresContextResolver");
            Intrinsics.checkNotNullParameter(networkSettledMetricResolver, "networkSettledMetricResolver");
            Intrinsics.checkNotNullParameter(insightsCollector, "insightsCollector");
            return new RumResourceScope(parentScope, sdkCore, event.getUrl(), event.getMethod(), event.getKey(), event.getEventTime(), event.getAttributes(), timestampOffset, firstPartyHostHeaderTypeResolver, featuresContextResolver, sampleRate, networkSettledMetricResolver, rumSessionTypeOverride, insightsCollector);
        }
    }
}

package com.datadog.android.rum.internal.monitor;

import android.app.Activity;
import android.os.Handler;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.InternalLoggerKt;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureScopeExtKt;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.core.InternalSdkCore;
import com.datadog.android.core.feature.event.ThreadDump;
import com.datadog.android.core.internal.net.FirstPartyHostHeaderTypeResolver;
import com.datadog.android.core.internal.utils.ConcurrencyExtKt;
import com.datadog.android.core.metrics.MethodCallSamplingRate;
import com.datadog.android.core.sampling.Sampler;
import com.datadog.android.heatmaps.CrossPlatformHeatmapActionData;
import com.datadog.android.internal.heatmaps.HeatmapIdentifierRegistry;
import com.datadog.android.internal.telemetry.InternalTelemetryEvent;
import com.datadog.android.rum.DdRumContentProvider;
import com.datadog.android.rum.RumActionType;
import com.datadog.android.rum.RumAttributes;
import com.datadog.android.rum.RumErrorSource;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.RumPerformanceMetric;
import com.datadog.android.rum.RumResourceKind;
import com.datadog.android.rum.RumResourceMethod;
import com.datadog.android.rum.RumSessionListener;
import com.datadog.android.rum.RumSessionType;
import com.datadog.android.rum._RumInternalProxy;
import com.datadog.android.rum.featureoperations.FailureReason;
import com.datadog.android.rum.internal.CombinedRumSessionListener;
import com.datadog.android.rum.internal.RumErrorSourceType;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.rum.internal.debug.RumDebugListener;
import com.datadog.android.rum.internal.domain.InfoProvider;
import com.datadog.android.rum.internal.domain.RumContext;
import com.datadog.android.rum.internal.domain.Time;
import com.datadog.android.rum.internal.domain.accessibility.AccessibilitySnapshotManager;
import com.datadog.android.rum.internal.domain.battery.BatteryInfo;
import com.datadog.android.rum.internal.domain.display.DisplayInfo;
import com.datadog.android.rum.internal.domain.event.ResourceTiming;
import com.datadog.android.rum.internal.domain.event.RumEventMeta;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.rum.internal.domain.scope.RumApplicationScope;
import com.datadog.android.rum.internal.domain.scope.RumRawEvent;
import com.datadog.android.rum.internal.domain.scope.RumScope;
import com.datadog.android.rum.internal.domain.scope.RumScopeKey;
import com.datadog.android.rum.internal.domain.scope.RumSessionScope;
import com.datadog.android.rum.internal.domain.scope.RumViewManagerScope;
import com.datadog.android.rum.internal.domain.scope.RumViewScope;
import com.datadog.android.rum.internal.heatmaps.NativeHeatmapActionData;
import com.datadog.android.rum.internal.instrumentation.insights.InsightsCollector;
import com.datadog.android.rum.internal.metric.SessionMetricDispatcher;
import com.datadog.android.rum.internal.metric.slowframes.SlowFramesListener;
import com.datadog.android.rum.internal.startup.RumAppStartupTelemetryReporterImpl;
import com.datadog.android.rum.internal.startup.RumSessionScopeStartupManager;
import com.datadog.android.rum.internal.startup.RumStartupScenario;
import com.datadog.android.rum.internal.startup.RumTTIDInfo;
import com.datadog.android.rum.internal.timeseries.TimeseriesCollector;
import com.datadog.android.rum.internal.utils.ViewUtilsKt;
import com.datadog.android.rum.internal.vitals.VitalMonitor;
import com.datadog.android.rum.metric.interactiontonextview.LastInteractionIdentifier;
import com.datadog.android.rum.metric.networksettled.InitialResourceIdentifier;
import com.datadog.android.rum.operations.OperationOptions;
import com.datadog.android.rum.resource.ResourceId;
import com.datadog.android.telemetry.internal.TelemetryEventHandler;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DatadogRumMonitor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Ø\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 ú\u00012\u00020\u00012\u00020\u0002:\u0002ú\u0001B\u0083\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!\u0012\b\u0010\"\u001a\u0004\u0018\u00010#\u0012\b\u0010$\u001a\u0004\u0018\u00010%\u0012\b\u0010&\u001a\u0004\u0018\u00010'\u0012\u0006\u0010(\u001a\u00020)\u0012\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+\u0012\f\u0010-\u001a\b\u0012\u0004\u0012\u00020.0+\u0012\f\u0010/\u001a\b\u0012\u0004\u0012\u00020100\u0012\u0006\u00102\u001a\u000203\u0012\b\u00104\u001a\u0004\u0018\u000105\u0012\u0006\u00106\u001a\u000207¢\u0006\u0002\u00108J\b\u0010^\u001a\u00020PH\u0016J.\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020\u00042\u0014\u0010d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f0eH\u0016J8\u0010f\u001a\u00020`2\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020\u00042\b\u0010g\u001a\u0004\u0018\u00010h2\u0014\u0010d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f0eH\u0016J6\u0010i\u001a\u00020`2\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020\u00042\u0006\u0010j\u001a\u00020k2\u0014\u0010d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f0eH\u0016J\u001a\u0010l\u001a\u00020`2\u0006\u0010m\u001a\u00020\u00042\b\u0010>\u001a\u0004\u0018\u00010\u000fH\u0016J.\u0010n\u001a\u00020`2\u0006\u0010o\u001a\u00020\u00042\u0006\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020s2\f\u0010t\u001a\b\u0012\u0004\u0012\u00020v0uH\u0016J8\u0010w\u001a\u00020`2\u0006\u0010o\u001a\u00020\u00042\u0006\u0010p\u001a\u00020q2\b\u0010r\u001a\u0004\u0018\u00010s2\u0014\u0010d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f0eH\u0016J8\u0010x\u001a\u00020`2\u0006\u0010o\u001a\u00020\u00042\u0006\u0010p\u001a\u00020q2\b\u0010y\u001a\u0004\u0018\u00010\u00042\u0014\u0010d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f0eH\u0016J\u0018\u0010z\u001a\u00020`2\u0006\u0010c\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\u000fH\u0016J\u001c\u0010{\u001a\u00020`2\u0012\u0010|\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0eH\u0016J\u0019\u0010}\u001a\u00020`2\u0006\u0010~\u001a\u00020\u007f2\u0007\u0010\u0080\u0001\u001a\u00020\u0004H\u0016J\u001b\u0010\u0081\u0001\u001a\u00020`2\u0006\u0010m\u001a\u00020\u000f2\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0016J\t\u0010\u0084\u0001\u001a\u00020`H\u0016J\u0011\u0010\u0085\u0001\u001a\u00020`2\u0006\u0010c\u001a\u00020\u0004H\u0016J\u001f\u0010\u0086\u0001\u001a\u00020`2\u0014\u0010d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f0eH\u0016J\u0012\u0010\u0087\u0001\u001a\u00020`2\u0007\u0010\u0088\u0001\u001a\u00020\u000bH\u0017J\t\u0010\u0089\u0001\u001a\u00020`H\u0016J\f\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u0001H\u0002J\u000f\u0010\u008c\u0001\u001a\u00020`H\u0000¢\u0006\u0003\b\u008d\u0001J\u0013\u0010\u008e\u0001\u001a\u00020`2\b\u0010\u008f\u0001\u001a\u00030\u0090\u0001H\u0016J\u001c\u0010\u0091\u0001\u001a\u00020`2\u0007\u0010\u0092\u0001\u001a\u00020\u00042\b\u0010\u0093\u0001\u001a\u00030\u0094\u0001H\u0016J\u001c\u0010\u0095\u0001\u001a\u00020`2\u0007\u0010\u0092\u0001\u001a\u00020\u00042\b\u0010\u0093\u0001\u001a\u00030\u0094\u0001H\u0016J<\u0010\u0096\u0001\u001a\u00020`2\u0006\u0010c\u001a\u00020\u00042\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010\u0098\u0001\u001a\u00030\u0099\u00012\u0014\u0010d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f0eH\u0017J<\u0010\u009a\u0001\u001a\u00020`2\u0006\u0010c\u001a\u00020\u00042\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010\u0098\u0001\u001a\u00030\u009b\u00012\u0014\u0010d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f0eH\u0017J\u0017\u0010\u009c\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f0eH\u0016J!\u0010\u009d\u0001\u001a\u00020`2\u0016\u0010\u009e\u0001\u001a\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020`0\u009f\u0001H\u0016J\u000b\u0010 \u0001\u001a\u0004\u0018\u00010\u0004H\u0016J \u0010¡\u0001\u001a\u00030¢\u00012\u0014\u0010d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f0eH\u0002J!\u0010£\u0001\u001a\u0004\u0018\u00010\u00042\u0014\u0010d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f0eH\u0002J \u0010¤\u0001\u001a\u00030¥\u00012\u0014\u0010d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f0eH\u0002J\u0019\u0010¦\u0001\u001a\u00020`2\b\u0010\u0093\u0001\u001a\u00030§\u0001H\u0000¢\u0006\u0003\b¨\u0001JF\u0010©\u0001\u001a\u00020`2\b\u0010\u0093\u0001\u001a\u00030§\u00012\b\u0010ª\u0001\u001a\u00030«\u00012'\u0010¬\u0001\u001a\"\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030\u00ad\u0001\u0012\u0004\u0012\u00020`0\u009f\u0001\u0012\u0004\u0012\u00020`0\u009f\u0001j\u0003`®\u0001H\u0003J\u000f\u0010¯\u0001\u001a\u00020`H\u0000¢\u0006\u0003\b°\u0001J\t\u0010±\u0001\u001a\u00020`H\u0016J\u0013\u0010²\u0001\u001a\u00020`2\b\u0010³\u0001\u001a\u00030´\u0001H\u0016J\n\u0010µ\u0001\u001a\u00030¥\u0001H\u0002J\u001c\u0010¶\u0001\u001a\u00020\u000b2\u0006\u0010c\u001a\u00020\u00042\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u0004H\u0002J\u0011\u0010·\u0001\u001a\u00020`2\u0006\u0010m\u001a\u00020\u0004H\u0016J\u0018\u0010¸\u0001\u001a\u00020`2\r\u0010d\u001a\t\u0012\u0004\u0012\u00020\u00040¹\u0001H\u0016J\t\u0010º\u0001\u001a\u00020`H\u0017J\u0012\u0010»\u0001\u001a\u00020`2\u0007\u0010a\u001a\u00030¼\u0001H\u0016J\t\u0010½\u0001\u001a\u00020`H\u0016J\u0013\u0010¾\u0001\u001a\u00020`2\b\u0010¿\u0001\u001a\u00030À\u0001H\u0016J\u0013\u0010Á\u0001\u001a\u00020`2\b\u0010Â\u0001\u001a\u00030Ã\u0001H\u0016J\u0013\u0010Ä\u0001\u001a\u00020`2\b\u0010Å\u0001\u001a\u00030Æ\u0001H\u0016J\t\u0010Ç\u0001\u001a\u00020`H\u0016J\u0014\u0010È\u0001\u001a\u00020`2\t\u0010É\u0001\u001a\u0004\u0018\u00010DH\u0016J\u001b\u0010Ê\u0001\u001a\u00020`2\u0006\u0010m\u001a\u00020\u00042\b\u0010>\u001a\u0004\u0018\u00010\u000fH\u0016J\u001b\u0010Ë\u0001\u001a\u00020`2\u0007\u0010Ì\u0001\u001a\u00020\u00042\u0007\u0010Í\u0001\u001a\u00020\u0004H\u0016J\t\u0010Î\u0001\u001a\u00020`H\u0016J/\u0010Ï\u0001\u001a\u00020`2\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020\u00042\u0014\u0010d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f0eH\u0016J2\u0010Ð\u0001\u001a\u00020`2\u0006\u0010c\u001a\u00020\u00042\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u00042\u0014\u0010d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f0eH\u0017J<\u0010Ñ\u0001\u001a\u00020`2\u0006\u0010c\u001a\u00020\u00042\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010Ò\u0001\u001a\u00030Ó\u00012\u0014\u0010d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f0eH\u0017J;\u0010Ô\u0001\u001a\u00020`2\u0007\u0010m\u001a\u00030Õ\u00012\b\u0010Ö\u0001\u001a\u00030×\u00012\u0007\u0010Ø\u0001\u001a\u00020\u00042\u0014\u0010d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f0eH\u0016J:\u0010Ô\u0001\u001a\u00020`2\u0006\u0010m\u001a\u00020\u00042\b\u0010Ö\u0001\u001a\u00030×\u00012\u0007\u0010Ø\u0001\u001a\u00020\u00042\u0014\u0010d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f0eH\u0016J/\u0010Ù\u0001\u001a\u00020`2\u0006\u0010m\u001a\u00020\u000f2\u0006\u0010c\u001a\u00020\u00042\u0014\u0010d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f0eH\u0016J/\u0010Ú\u0001\u001a\u00020`2\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020\u00042\u0014\u0010d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f0eH\u0016JO\u0010Û\u0001\u001a\u00020`2\u0007\u0010m\u001a\u00030Õ\u00012\n\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u00012\t\u0010Þ\u0001\u001a\u0004\u0018\u00010\u007f2\b\u0010ß\u0001\u001a\u00030à\u00012\u0014\u0010d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f0eH\u0016¢\u0006\u0003\u0010á\u0001JN\u0010Û\u0001\u001a\u00020`2\u0006\u0010m\u001a\u00020\u00042\n\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u00012\t\u0010Þ\u0001\u001a\u0004\u0018\u00010\u007f2\b\u0010ß\u0001\u001a\u00030à\u00012\u0014\u0010d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f0eH\u0016¢\u0006\u0003\u0010â\u0001J^\u0010ã\u0001\u001a\u00020`2\u0007\u0010m\u001a\u00030Õ\u00012\n\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u00012\u0006\u0010o\u001a\u00020\u00042\u0006\u0010p\u001a\u00020q2\u0007\u0010ä\u0001\u001a\u00020\u00042\t\u0010å\u0001\u001a\u0004\u0018\u00010\u00042\u0014\u0010d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f0eH\u0016¢\u0006\u0003\u0010æ\u0001JR\u0010ã\u0001\u001a\u00020`2\u0007\u0010m\u001a\u00030Õ\u00012\n\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u00012\u0006\u0010o\u001a\u00020\u00042\u0006\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020s2\u0014\u0010d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f0eH\u0016¢\u0006\u0003\u0010ç\u0001J]\u0010ã\u0001\u001a\u00020`2\u0006\u0010m\u001a\u00020\u00042\n\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u00012\u0006\u0010o\u001a\u00020\u00042\u0006\u0010p\u001a\u00020q2\u0007\u0010ä\u0001\u001a\u00020\u00042\t\u0010å\u0001\u001a\u0004\u0018\u00010\u00042\u0014\u0010d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f0eH\u0016¢\u0006\u0003\u0010è\u0001JQ\u0010ã\u0001\u001a\u00020`2\u0006\u0010m\u001a\u00020\u00042\n\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u00012\u0006\u0010o\u001a\u00020\u00042\u0006\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020s2\u0014\u0010d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f0eH\u0016¢\u0006\u0003\u0010é\u0001J\t\u0010ê\u0001\u001a\u00020`H\u0016J\u000f\u0010ë\u0001\u001a\u00020`H\u0000¢\u0006\u0003\bì\u0001J'\u0010í\u0001\u001a\u00020`2\u0006\u0010m\u001a\u00020\u000f2\u0014\u0010d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f0eH\u0016J2\u0010î\u0001\u001a\u00020`2\u0006\u0010c\u001a\u00020\u00042\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u00042\u0014\u0010d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f0eH\u0017J2\u0010ï\u0001\u001a\u00020`2\u0006\u0010c\u001a\u00020\u00042\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u00042\u0014\u0010d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f0eH\u0017J\u0015\u0010ð\u0001\u001a\u00020`2\n\u0010ñ\u0001\u001a\u0005\u0018\u00010\u008b\u0001H\u0002J\u0013\u0010ò\u0001\u001a\u00020`2\b\u0010ó\u0001\u001a\u00030ô\u0001H\u0016J\u001c\u0010õ\u0001\u001a\u00020`2\b\u0010ö\u0001\u001a\u00030÷\u00012\u0007\u0010>\u001a\u00030ô\u0001H\u0016J\t\u0010ø\u0001\u001a\u00020`H\u0002J\u0011\u0010ù\u0001\u001a\u00020`2\u0006\u0010m\u001a\u00020\u000fH\u0016R\u0014\u0010\u0007\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0014\u0010\n\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0010\u0010=\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010?\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b@\u0010<\"\u0004\bA\u0010BR\u001c\u0010C\u001a\u0004\u0018\u00010DX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0014\u0010\u001e\u001a\u00020\u001fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u001a\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0LX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u000e\u0010O\u001a\u00020PX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020RX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010S\u001a\u00020TX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020100X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR\u0014\u0010\u0012\u001a\u00020\u0013X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\\R\u0014\u0010\f\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010<R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006û\u0001"}, d2 = {"Lcom/datadog/android/rum/internal/monitor/DatadogRumMonitor;", "Lcom/datadog/android/rum/RumMonitor;", "Lcom/datadog/android/rum/internal/monitor/AdvancedRumMonitor;", "applicationId", "", "sdkCore", "Lcom/datadog/android/core/InternalSdkCore;", "appPackageName", "sessionSampler", "Lcom/datadog/android/core/sampling/Sampler;", "backgroundTrackingEnabled", "", "trackFrustrations", "writer", "Lcom/datadog/android/api/storage/DataWriter;", "", "handler", "Landroid/os/Handler;", "telemetryEventHandler", "Lcom/datadog/android/telemetry/internal/TelemetryEventHandler;", "sessionEndedMetricDispatcher", "Lcom/datadog/android/rum/internal/metric/SessionMetricDispatcher;", "firstPartyHostHeaderTypeResolver", "Lcom/datadog/android/core/internal/net/FirstPartyHostHeaderTypeResolver;", "cpuVitalMonitor", "Lcom/datadog/android/rum/internal/vitals/VitalMonitor;", "memoryVitalMonitor", "frameRateVitalMonitor", "sessionListener", "Lcom/datadog/android/rum/RumSessionListener;", "executorService", "Ljava/util/concurrent/ExecutorService;", "initialResourceIdentifier", "Lcom/datadog/android/rum/metric/networksettled/InitialResourceIdentifier;", "lastInteractionIdentifier", "Lcom/datadog/android/rum/metric/interactiontonextview/LastInteractionIdentifier;", "slowFramesListener", "Lcom/datadog/android/rum/internal/metric/slowframes/SlowFramesListener;", "rumSessionTypeOverride", "Lcom/datadog/android/rum/RumSessionType;", "accessibilitySnapshotManager", "Lcom/datadog/android/rum/internal/domain/accessibility/AccessibilitySnapshotManager;", "batteryInfoProvider", "Lcom/datadog/android/rum/internal/domain/InfoProvider;", "Lcom/datadog/android/rum/internal/domain/battery/BatteryInfo;", "displayInfoProvider", "Lcom/datadog/android/rum/internal/domain/display/DisplayInfo;", "rumSessionScopeStartupManagerFactory", "Lkotlin/Function0;", "Lcom/datadog/android/rum/internal/startup/RumSessionScopeStartupManager;", "insightsCollector", "Lcom/datadog/android/rum/internal/instrumentation/insights/InsightsCollector;", "heatmapIdentifierRegistry", "Lcom/datadog/android/internal/heatmaps/HeatmapIdentifierRegistry;", "timeseriesCollectorFactory", "Lcom/datadog/android/rum/internal/timeseries/TimeseriesCollector$Factory;", "(Ljava/lang/String;Lcom/datadog/android/core/InternalSdkCore;Ljava/lang/String;Lcom/datadog/android/core/sampling/Sampler;ZZLcom/datadog/android/api/storage/DataWriter;Landroid/os/Handler;Lcom/datadog/android/telemetry/internal/TelemetryEventHandler;Lcom/datadog/android/rum/internal/metric/SessionMetricDispatcher;Lcom/datadog/android/core/internal/net/FirstPartyHostHeaderTypeResolver;Lcom/datadog/android/rum/internal/vitals/VitalMonitor;Lcom/datadog/android/rum/internal/vitals/VitalMonitor;Lcom/datadog/android/rum/internal/vitals/VitalMonitor;Lcom/datadog/android/rum/RumSessionListener;Ljava/util/concurrent/ExecutorService;Lcom/datadog/android/rum/metric/networksettled/InitialResourceIdentifier;Lcom/datadog/android/rum/metric/interactiontonextview/LastInteractionIdentifier;Lcom/datadog/android/rum/internal/metric/slowframes/SlowFramesListener;Lcom/datadog/android/rum/RumSessionType;Lcom/datadog/android/rum/internal/domain/accessibility/AccessibilitySnapshotManager;Lcom/datadog/android/rum/internal/domain/InfoProvider;Lcom/datadog/android/rum/internal/domain/InfoProvider;Lkotlin/jvm/functions/Function0;Lcom/datadog/android/rum/internal/instrumentation/insights/InsightsCollector;Lcom/datadog/android/internal/heatmaps/HeatmapIdentifierRegistry;Lcom/datadog/android/rum/internal/timeseries/TimeseriesCollector$Factory;)V", "getAppPackageName$dd_sdk_android_rum_release", "()Ljava/lang/String;", "getBackgroundTrackingEnabled$dd_sdk_android_rum_release", "()Z", "cachedViewUrl", "value", "debug", "getDebug", "setDebug", "(Z)V", "debugListener", "Lcom/datadog/android/rum/internal/debug/RumDebugListener;", "getDebugListener$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/internal/debug/RumDebugListener;", "setDebugListener$dd_sdk_android_rum_release", "(Lcom/datadog/android/rum/internal/debug/RumDebugListener;)V", "getExecutorService$dd_sdk_android_rum_release", "()Ljava/util/concurrent/ExecutorService;", "globalAttributes", "", "getHandler$dd_sdk_android_rum_release", "()Landroid/os/Handler;", "internalProxy", "Lcom/datadog/android/rum/_RumInternalProxy;", "isDebugEnabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "rootScope", "Lcom/datadog/android/rum/internal/domain/scope/RumApplicationScope;", "getRootScope$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/internal/domain/scope/RumApplicationScope;", "setRootScope$dd_sdk_android_rum_release", "(Lcom/datadog/android/rum/internal/domain/scope/RumApplicationScope;)V", "getSessionSampler$dd_sdk_android_rum_release", "()Lcom/datadog/android/core/sampling/Sampler;", "getTelemetryEventHandler$dd_sdk_android_rum_release", "()Lcom/datadog/android/telemetry/internal/TelemetryEventHandler;", "getTrackFrustrations$dd_sdk_android_rum_release", "_getInternal", "addAction", "", "type", "Lcom/datadog/android/rum/RumActionType;", "name", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "addActionWithHeatmap", "nativeHeatmapActionData", "Lcom/datadog/android/rum/internal/heatmaps/NativeHeatmapActionData;", "addActionWithHeatmapAttributes", "crossPlatformHeatmapActionData", "Lcom/datadog/android/heatmaps/CrossPlatformHeatmapActionData;", "addAttribute", "key", "addCrash", "message", "source", "Lcom/datadog/android/rum/RumErrorSource;", RumFeature.EVENT_THROWABLE_PROPERTY, "", "threads", "", "Lcom/datadog/android/core/feature/event/ThreadDump;", "addError", "addErrorWithStacktrace", "stacktrace", "addFeatureFlagEvaluation", "addFeatureFlagEvaluations", "featureFlags", "addLongTask", "durationNs", "", TypedValues.Attributes.S_TARGET, "addResourceTiming", "timing", "Lcom/datadog/android/rum/internal/domain/event/ResourceTiming;", "addSessionReplaySkippedFrame", "addTiming", "addViewAttributes", "addViewLoadingTime", "overwrite", "clearAttributes", "currentRumContext", "Lcom/datadog/android/rum/internal/domain/RumContext;", "drainExecutorService", "drainExecutorService$dd_sdk_android_rum_release", "enableJankStatsTracking", "activity", "Landroid/app/Activity;", "eventDropped", RumEventMeta.VIEW_ID_KEY, "event", "Lcom/datadog/android/rum/internal/monitor/StorageEvent;", "eventSent", "failFeatureOperation", "operationKey", "failureReason", "Lcom/datadog/android/rum/featureoperations/FailureReason;", "failOperation", "Lcom/datadog/android/rum/operations/FailureReason;", "getAttributes", "getCurrentSessionId", "callback", "Lkotlin/Function1;", "getCurrentViewUrl", "getErrorSourceType", "Lcom/datadog/android/rum/internal/RumErrorSourceType;", "getErrorType", "getEventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "handleEvent", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "handleEvent$dd_sdk_android_rum_release", "handleEventWithMethodCallPerf", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "writeScope", "Lcom/datadog/android/api/storage/EventBatchWriter;", "Lcom/datadog/android/api/feature/EventWriteScope;", "notifyDebugListenerWithState", "notifyDebugListenerWithState$dd_sdk_android_rum_release", "notifyInterceptorInstantiated", "notifyResourceHeadersTrackingConfigured", "mode", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ResourceHeadersTrackingConfigured$Mode;", "now", "operationArgumentsValid", "removeAttribute", "removeViewAttributes", "", "reportAppFullyDisplayed", "reportNetworkingLibraryType", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage$NetworkInstrumentation$LibraryType;", "resetSession", "sendAppStartEvent", RumAppStartupTelemetryReporterImpl.KEY_SCENARIO, "Lcom/datadog/android/rum/internal/startup/RumStartupScenario;", "sendTTIDEvent", "info", "Lcom/datadog/android/rum/internal/startup/RumTTIDInfo;", "sendTelemetryEvent", "telemetryEvent", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent;", "sendWebViewEvent", "setDebugListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setInternalViewAttribute", "setSyntheticsAttribute", "testId", "resultId", ViewProps.START, "startAction", "startFeatureOperation", "startOperation", "options", "Lcom/datadog/android/rum/operations/OperationOptions;", "startResource", "Lcom/datadog/android/rum/resource/ResourceId;", FirebaseAnalytics.Param.METHOD, "Lcom/datadog/android/rum/RumResourceMethod;", ImagesContract.URL, "startView", "stopAction", "stopResource", "statusCode", "", ContentDisposition.Parameters.Size, "kind", "Lcom/datadog/android/rum/RumResourceKind;", "(Lcom/datadog/android/rum/resource/ResourceId;Ljava/lang/Integer;Ljava/lang/Long;Lcom/datadog/android/rum/RumResourceKind;Ljava/util/Map;)V", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Lcom/datadog/android/rum/RumResourceKind;Ljava/util/Map;)V", "stopResourceWithError", "stackTrace", "errorType", "(Lcom/datadog/android/rum/resource/ResourceId;Ljava/lang/Integer;Ljava/lang/String;Lcom/datadog/android/rum/RumErrorSource;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "(Lcom/datadog/android/rum/resource/ResourceId;Ljava/lang/Integer;Ljava/lang/String;Lcom/datadog/android/rum/RumErrorSource;Ljava/lang/Throwable;Ljava/util/Map;)V", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/datadog/android/rum/RumErrorSource;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/datadog/android/rum/RumErrorSource;Ljava/lang/Throwable;Ljava/util/Map;)V", "stopSession", "stopTimeseries", "stopTimeseries$dd_sdk_android_rum_release", "stopView", "succeedFeatureOperation", "succeedOperation", "updateCachedViewUrl", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "updateExternalRefreshRate", "frameTimeSeconds", "", "updatePerformanceMetric", "metric", "Lcom/datadog/android/rum/RumPerformanceMetric;", "waitForPendingEvents", "waitForResourceTiming", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DatadogRumMonitor implements RumMonitor, AdvancedRumMonitor {
    public static final String CANNOT_WRITE_CRASH_WRITE_CONTEXT_IS_NOT_AVAILABLE = "Cannot write JVM crash, because write context is not available.";
    public static final long DRAIN_WAIT_SECONDS = 10;
    public static final String OPERATION_ERROR_INVALID_NAME = "Operation name cannot be an empty or blank string but was \"%s\". Vital event won't be sent.";
    public static final String OPERATION_ERROR_INVALID_NAME_CHARACTERS = "Operation name \"%s\" does not match the backend-accepted pattern [\\w.@$-]* (letters, digits, _ . @ $ -). The vital event will still be sent and may be rejected by the backend.";
    public static final String OPERATION_ERROR_INVALID_OPERATION_KEY = "Operation key cannot be an empty or blank string but was \"%s\". The vital event will still be sent.";
    public static final String RUM_DEBUG_RUM_NOT_ENABLED_WARNING = "Cannot switch RUM debugging, because RUM feature is not enabled.";
    private final String appPackageName;
    private final boolean backgroundTrackingEnabled;
    private volatile String cachedViewUrl;
    private RumDebugListener debugListener;
    private final ExecutorService executorService;
    private final Map<String, Object> globalAttributes;
    private final Handler handler;
    private final _RumInternalProxy internalProxy;
    private final AtomicBoolean isDebugEnabled;
    private RumApplicationScope rootScope;
    private final Function0<RumSessionScopeStartupManager> rumSessionScopeStartupManagerFactory;
    private final InternalSdkCore sdkCore;
    private final SessionMetricDispatcher sessionEndedMetricDispatcher;
    private final Sampler<String> sessionSampler;
    private final TelemetryEventHandler telemetryEventHandler;
    private final boolean trackFrustrations;
    private final DataWriter<Object> writer;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Regex VALID_OPERATION_NAME_REGEX = new Regex("^[\\w.@$-]*$");

    /* JADX INFO: compiled from: DatadogRumMonitor.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FailureReason.values().length];
            try {
                iArr[FailureReason.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FailureReason.ABANDONED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FailureReason.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DatadogRumMonitor(String applicationId, InternalSdkCore sdkCore, String appPackageName, Sampler<String> sessionSampler, boolean z, boolean z2, DataWriter<Object> writer, Handler handler, TelemetryEventHandler telemetryEventHandler, SessionMetricDispatcher sessionEndedMetricDispatcher, FirstPartyHostHeaderTypeResolver firstPartyHostHeaderTypeResolver, VitalMonitor cpuVitalMonitor, VitalMonitor memoryVitalMonitor, VitalMonitor frameRateVitalMonitor, RumSessionListener sessionListener, ExecutorService executorService, InitialResourceIdentifier initialResourceIdentifier, LastInteractionIdentifier lastInteractionIdentifier, SlowFramesListener slowFramesListener, RumSessionType rumSessionType, AccessibilitySnapshotManager accessibilitySnapshotManager, InfoProvider<BatteryInfo> batteryInfoProvider, InfoProvider<DisplayInfo> displayInfoProvider, Function0<? extends RumSessionScopeStartupManager> rumSessionScopeStartupManagerFactory, InsightsCollector insightsCollector, HeatmapIdentifierRegistry heatmapIdentifierRegistry, TimeseriesCollector.Factory timeseriesCollectorFactory) {
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(appPackageName, "appPackageName");
        Intrinsics.checkNotNullParameter(sessionSampler, "sessionSampler");
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(telemetryEventHandler, "telemetryEventHandler");
        Intrinsics.checkNotNullParameter(sessionEndedMetricDispatcher, "sessionEndedMetricDispatcher");
        Intrinsics.checkNotNullParameter(firstPartyHostHeaderTypeResolver, "firstPartyHostHeaderTypeResolver");
        Intrinsics.checkNotNullParameter(cpuVitalMonitor, "cpuVitalMonitor");
        Intrinsics.checkNotNullParameter(memoryVitalMonitor, "memoryVitalMonitor");
        Intrinsics.checkNotNullParameter(frameRateVitalMonitor, "frameRateVitalMonitor");
        Intrinsics.checkNotNullParameter(sessionListener, "sessionListener");
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        Intrinsics.checkNotNullParameter(initialResourceIdentifier, "initialResourceIdentifier");
        Intrinsics.checkNotNullParameter(accessibilitySnapshotManager, "accessibilitySnapshotManager");
        Intrinsics.checkNotNullParameter(batteryInfoProvider, "batteryInfoProvider");
        Intrinsics.checkNotNullParameter(displayInfoProvider, "displayInfoProvider");
        Intrinsics.checkNotNullParameter(rumSessionScopeStartupManagerFactory, "rumSessionScopeStartupManagerFactory");
        Intrinsics.checkNotNullParameter(insightsCollector, "insightsCollector");
        Intrinsics.checkNotNullParameter(timeseriesCollectorFactory, "timeseriesCollectorFactory");
        this.sdkCore = sdkCore;
        this.appPackageName = appPackageName;
        this.sessionSampler = sessionSampler;
        this.backgroundTrackingEnabled = z;
        this.trackFrustrations = z2;
        this.writer = writer;
        this.handler = handler;
        this.telemetryEventHandler = telemetryEventHandler;
        this.sessionEndedMetricDispatcher = sessionEndedMetricDispatcher;
        this.executorService = executorService;
        this.rumSessionScopeStartupManagerFactory = rumSessionScopeStartupManagerFactory;
        this.rootScope = new RumApplicationScope(applicationId, sdkCore, sessionSampler, z, z2, firstPartyHostHeaderTypeResolver, cpuVitalMonitor, memoryVitalMonitor, frameRateVitalMonitor, sessionEndedMetricDispatcher, new CombinedRumSessionListener(sessionListener, telemetryEventHandler), initialResourceIdentifier, lastInteractionIdentifier, slowFramesListener, rumSessionType, accessibilitySnapshotManager, batteryInfoProvider, displayInfoProvider, rumSessionScopeStartupManagerFactory, insightsCollector, heatmapIdentifierRegistry, timeseriesCollectorFactory);
        this.internalProxy = new _RumInternalProxy(this);
        this.globalAttributes = new ConcurrentHashMap();
        this.isDebugEnabled = new AtomicBoolean(false);
    }

    /* JADX INFO: renamed from: getAppPackageName$dd_sdk_android_rum_release, reason: from getter */
    public final String getAppPackageName() {
        return this.appPackageName;
    }

    public final Sampler<String> getSessionSampler$dd_sdk_android_rum_release() {
        return this.sessionSampler;
    }

    /* JADX INFO: renamed from: getBackgroundTrackingEnabled$dd_sdk_android_rum_release, reason: from getter */
    public final boolean getBackgroundTrackingEnabled() {
        return this.backgroundTrackingEnabled;
    }

    /* JADX INFO: renamed from: getTrackFrustrations$dd_sdk_android_rum_release, reason: from getter */
    public final boolean getTrackFrustrations() {
        return this.trackFrustrations;
    }

    /* JADX INFO: renamed from: getHandler$dd_sdk_android_rum_release, reason: from getter */
    public final Handler getHandler() {
        return this.handler;
    }

    /* JADX INFO: renamed from: getTelemetryEventHandler$dd_sdk_android_rum_release, reason: from getter */
    public final TelemetryEventHandler getTelemetryEventHandler() {
        return this.telemetryEventHandler;
    }

    /* JADX INFO: renamed from: getExecutorService$dd_sdk_android_rum_release, reason: from getter */
    public final ExecutorService getExecutorService() {
        return this.executorService;
    }

    /* JADX INFO: renamed from: getRootScope$dd_sdk_android_rum_release, reason: from getter */
    public final RumApplicationScope getRootScope() {
        return this.rootScope;
    }

    public final void setRootScope$dd_sdk_android_rum_release(RumApplicationScope rumApplicationScope) {
        Intrinsics.checkNotNullParameter(rumApplicationScope, "<set-?>");
        this.rootScope = rumApplicationScope;
    }

    /* JADX INFO: renamed from: getDebugListener$dd_sdk_android_rum_release, reason: from getter */
    public final RumDebugListener getDebugListener() {
        return this.debugListener;
    }

    public final void setDebugListener$dd_sdk_android_rum_release(RumDebugListener rumDebugListener) {
        this.debugListener = rumDebugListener;
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void getCurrentSessionId(final Function1<? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ConcurrencyExtKt.executeSafe(this.executorService, "Get current session ID", this.sdkCore.getInternalLogger(), new Runnable() { // from class: com.datadog.android.rum.internal.monitor.DatadogRumMonitor$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DatadogRumMonitor.getCurrentSessionId$lambda$1(this.f$0, callback);
            }
        });
    }

    static final void getCurrentSessionId$lambda$1(DatadogRumMonitor datadogRumMonitor, Function1 function1) {
        RumContext rumContext;
        RumSessionScope activeSession = datadogRumMonitor.rootScope.getActiveSession();
        String str = null;
        if (activeSession != null && (rumContext = activeSession.getRumContext()) != null) {
            String sessionId = rumContext.getSessionId();
            if (rumContext.getSessionState() != RumSessionScope.State.NOT_TRACKED && !Intrinsics.areEqual(sessionId, "00000000-0000-0000-0000-000000000000")) {
                str = sessionId;
            }
        }
        function1.invoke(str);
    }

    @Override // com.datadog.android.rum.RumMonitor
    public boolean getDebug() {
        return this.isDebugEnabled.get();
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void setDebug(boolean z) {
        if (z == this.isDebugEnabled.get()) {
            return;
        }
        FeatureScope feature = this.sdkCore.getFeature("rum");
        RumFeature rumFeature = feature != null ? (RumFeature) feature.unwrap() : null;
        if (rumFeature == null) {
            InternalLoggerKt.logToUser$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.WARN, false, new Function0<String>() { // from class: com.datadog.android.rum.internal.monitor.DatadogRumMonitor$debug$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return DatadogRumMonitor.RUM_DEBUG_RUM_NOT_ENABLED_WARNING;
                }
            }, 2, null);
            return;
        }
        if (z) {
            rumFeature.enableDebugging$dd_sdk_android_rum_release(this);
        } else {
            rumFeature.disableDebugging$dd_sdk_android_rum_release();
        }
        this.isDebugEnabled.set(z);
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void startView(Object key, String name, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.StartView(RumScopeKey.INSTANCE.from(key, name), MapsKt.toMap(attributes), getEventTime(attributes)));
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void stopView(Object key, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.StopView(RumScopeKey.Companion.from$default(RumScopeKey.INSTANCE, key, null, 2, null), MapsKt.toMap(attributes), getEventTime(attributes)));
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void addAction(RumActionType type, String name, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.StartAction(type, name, false, getEventTime(attributes), null, null, null, MapsKt.toMap(attributes), 112, null));
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void addActionWithHeatmap(RumActionType type, String name, NativeHeatmapActionData nativeHeatmapActionData, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.StartAction(type, name, false, getEventTime(attributes), nativeHeatmapActionData, null, null, MapsKt.toMap(attributes), 96, null));
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void addActionWithHeatmapAttributes(RumActionType type, String name, CrossPlatformHeatmapActionData crossPlatformHeatmapActionData, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(crossPlatformHeatmapActionData, "crossPlatformHeatmapActionData");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.StartAction(type, name, false, getEventTime(attributes), null, crossPlatformHeatmapActionData, this.appPackageName, MapsKt.toMap(attributes), 16, null));
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void startAction(RumActionType type, String name, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.StartAction(type, name, true, getEventTime(attributes), null, null, null, MapsKt.toMap(attributes), 112, null));
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void stopAction(RumActionType type, String name, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.StopAction(type, name, MapsKt.toMap(attributes), getEventTime(attributes)));
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void startResource(String key, RumResourceMethod method, String url, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.StartResource(key, url, method, MapsKt.toMap(attributes), getEventTime(attributes)));
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void stopResource(String key, Integer statusCode, Long size, RumResourceKind kind, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.StopResource(key, statusCode != null ? Long.valueOf(statusCode.intValue()) : null, size, kind, MapsKt.toMap(attributes), getEventTime(attributes)));
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void stopResourceWithError(String key, Integer statusCode, String message, RumErrorSource source, Throwable throwable, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.StopResourceWithError(key, statusCode != null ? Long.valueOf(statusCode.intValue()) : null, message, source, throwable, MapsKt.toMap(attributes), getEventTime(attributes)));
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void stopResourceWithError(String key, Integer statusCode, String message, RumErrorSource source, String stackTrace, String errorType, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(stackTrace, "stackTrace");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.StopResourceWithStackTrace(key, statusCode != null ? Long.valueOf(statusCode.intValue()) : null, message, source, stackTrace, errorType, MapsKt.toMap(attributes), getEventTime(attributes)));
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedNetworkRumMonitor
    public void startResource(ResourceId key, RumResourceMethod method, String url, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.StartResource(key, url, method, MapsKt.toMap(attributes), getEventTime(attributes)));
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedNetworkRumMonitor
    public void stopResource(ResourceId key, Integer statusCode, Long size, RumResourceKind kind, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.StopResource(key, statusCode != null ? Long.valueOf(statusCode.intValue()) : null, size, kind, MapsKt.toMap(attributes), getEventTime(attributes)));
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedNetworkRumMonitor
    public void stopResourceWithError(ResourceId key, Integer statusCode, String message, RumErrorSource source, Throwable throwable, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.StopResourceWithError(key, statusCode != null ? Long.valueOf(statusCode.intValue()) : null, message, source, throwable, MapsKt.toMap(attributes), getEventTime(attributes)));
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedNetworkRumMonitor
    public void stopResourceWithError(ResourceId key, Integer statusCode, String message, RumErrorSource source, String stackTrace, String errorType, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(stackTrace, "stackTrace");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.StopResourceWithStackTrace(key, statusCode != null ? Long.valueOf(statusCode.intValue()) : null, message, source, stackTrace, errorType, MapsKt.toMap(attributes), getEventTime(attributes)));
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void addError(String message, RumErrorSource source, Throwable throwable, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Time eventTime = getEventTime(attributes);
        String errorType = getErrorType(attributes);
        Map mutableMap = MapsKt.toMutableMap(attributes);
        Object objRemove = mutableMap.remove(RumAttributes.INTERNAL_ALL_THREADS);
        List listEmptyList = objRemove instanceof List ? (List) objRemove : null;
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.AddError(message, source, throwable, null, false, mutableMap, listEmptyList, eventTime, errorType, null, null, 1536, null));
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void addErrorWithStacktrace(String message, RumErrorSource source, String stacktrace, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.AddError(message, source, null, stacktrace, false, MapsKt.toMap(attributes), CollectionsKt.emptyList(), getEventTime(attributes), getErrorType(attributes), getErrorSourceType(attributes), null, 1024, null));
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void addFeatureFlagEvaluation(String name, Object value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.AddFeatureFlagEvaluation(name, value, now()));
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void addFeatureFlagEvaluations(Map<String, ? extends Object> featureFlags) {
        Intrinsics.checkNotNullParameter(featureFlags, "featureFlags");
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.AddFeatureFlagEvaluations(featureFlags, now()));
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void stopSession() {
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.StopSession(now()));
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void reportAppFullyDisplayed() {
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.AppStartTTFDEvent(now()));
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void addAttribute(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Map<String, Object> map = this.globalAttributes;
        if (value == null) {
            map.remove(key);
        } else {
            map.put(key, value);
        }
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void removeAttribute(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.globalAttributes.remove(key);
    }

    @Override // com.datadog.android.rum.RumMonitor
    public Map<String, Object> getAttributes() {
        return this.globalAttributes;
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void clearAttributes() {
        this.globalAttributes.clear();
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void sendWebViewEvent() {
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.WebViewEvent(now()));
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void resetSession() {
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.ResetSession(now()));
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void start() {
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.SdkInit(DdRumContentProvider.INSTANCE.getProcessImportance() == 100, now()));
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedNetworkRumMonitor
    public void waitForResourceTiming(Object key) {
        Intrinsics.checkNotNullParameter(key, "key");
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.WaitForResourceTiming(key, now()));
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedNetworkRumMonitor
    public void addResourceTiming(Object key, ResourceTiming timing) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(timing, "timing");
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.AddResourceTiming(key, timing, now()));
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void addCrash(String message, RumErrorSource source, Throwable throwable, List<ThreadDump> threads) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(threads, "threads");
        Time timeNow = now();
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.AddError(message, source, throwable, null, true, MapsKt.emptyMap(), threads, timeNow, null, null, Long.valueOf(timeNow.getNanoTime() - this.sdkCore.getAppStartTimeNs()), 768, null));
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void addTiming(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.AddCustomTiming(name, now()));
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void addViewLoadingTime(boolean overwrite) {
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.AddViewLoadingTime(overwrite, now()));
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void addViewAttributes(Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.AddViewAttributes(attributes, now()));
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void removeViewAttributes(Collection<String> attributes) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.RemoveViewAttributes(attributes, now()));
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void addLongTask(long durationNs, String target) {
        Intrinsics.checkNotNullParameter(target, "target");
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.AddLongTask(durationNs, target, now()));
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void eventSent(String viewId, StorageEvent event) {
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof StorageEvent.Action) {
            StorageEvent.Action action = (StorageEvent.Action) event;
            handleEvent$dd_sdk_android_rum_release(new RumRawEvent.ActionSent(viewId, action.getFrustrationCount(), action.getType(), action.getEventEndTimestampInNanos(), now()));
            return;
        }
        if (event instanceof StorageEvent.Resource) {
            StorageEvent.Resource resource = (StorageEvent.Resource) event;
            handleEvent$dd_sdk_android_rum_release(new RumRawEvent.ResourceSent(viewId, resource.getResourceId(), resource.getResourceStopTimestampInNanos(), now()));
            return;
        }
        if (event instanceof StorageEvent.Error) {
            StorageEvent.Error error = (StorageEvent.Error) event;
            handleEvent$dd_sdk_android_rum_release(new RumRawEvent.ErrorSent(viewId, now(), error.getResourceId(), error.getResourceStopTimestampInNanos()));
        } else if (event instanceof StorageEvent.LongTask) {
            handleEvent$dd_sdk_android_rum_release(new RumRawEvent.LongTaskSent(viewId, now(), false));
        } else if (event instanceof StorageEvent.FrozenFrame) {
            handleEvent$dd_sdk_android_rum_release(new RumRawEvent.LongTaskSent(viewId, now(), true));
        } else {
            boolean z = event instanceof StorageEvent.View;
        }
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void eventDropped(String viewId, StorageEvent event) {
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof StorageEvent.Action) {
            handleEvent$dd_sdk_android_rum_release(new RumRawEvent.ActionDropped(viewId, now()));
            return;
        }
        if (event instanceof StorageEvent.Resource) {
            handleEvent$dd_sdk_android_rum_release(new RumRawEvent.ResourceDropped(viewId, ((StorageEvent.Resource) event).getResourceId(), now()));
            return;
        }
        if (event instanceof StorageEvent.Error) {
            handleEvent$dd_sdk_android_rum_release(new RumRawEvent.ErrorDropped(viewId, now(), ((StorageEvent.Error) event).getResourceId()));
            return;
        }
        if (event instanceof StorageEvent.LongTask) {
            handleEvent$dd_sdk_android_rum_release(new RumRawEvent.LongTaskDropped(viewId, now(), false));
        } else if (event instanceof StorageEvent.FrozenFrame) {
            handleEvent$dd_sdk_android_rum_release(new RumRawEvent.LongTaskDropped(viewId, now(), true));
        } else {
            boolean z = event instanceof StorageEvent.View;
        }
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void setDebugListener(RumDebugListener listener) {
        this.debugListener = listener;
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void addSessionReplaySkippedFrame() {
        getCurrentSessionId(new Function1<String, Unit>() { // from class: com.datadog.android.rum.internal.monitor.DatadogRumMonitor.addSessionReplaySkippedFrame.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                if (str != null) {
                    DatadogRumMonitor.this.sessionEndedMetricDispatcher.onSessionReplaySkippedFrameTracked(str);
                }
            }
        });
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedNetworkRumMonitor
    public void notifyInterceptorInstantiated() {
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.TelemetryEventWrapper(InternalTelemetryEvent.InterceptorInstantiated.INSTANCE, now()));
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedNetworkRumMonitor
    public void reportNetworkingLibraryType(final InternalTelemetryEvent.ApiUsage.NetworkInstrumentation.LibraryType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        InternalLogger.DefaultImpls.logApiUsage$default(this.sdkCore.getInternalLogger(), 0.0f, new Function0<InternalTelemetryEvent.ApiUsage>() { // from class: com.datadog.android.rum.internal.monitor.DatadogRumMonitor.reportNetworkingLibraryType.1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final InternalTelemetryEvent.ApiUsage invoke() {
                return new InternalTelemetryEvent.ApiUsage.NetworkInstrumentation(type, null, 2, null);
            }
        }, 1, null);
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedNetworkRumMonitor
    public void notifyResourceHeadersTrackingConfigured(InternalTelemetryEvent.ResourceHeadersTrackingConfigured.Mode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.TelemetryEventWrapper(new InternalTelemetryEvent.ResourceHeadersTrackingConfigured(mode), now()));
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void updatePerformanceMetric(RumPerformanceMetric metric, double value) {
        Intrinsics.checkNotNullParameter(metric, "metric");
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.UpdatePerformanceMetric(metric, value, now()));
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void updateExternalRefreshRate(double frameTimeSeconds) {
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.UpdateExternalRefreshRate(frameTimeSeconds, now()));
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void setInternalViewAttribute(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.SetInternalViewAttribute(key, value, now()));
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void setSyntheticsAttribute(String testId, String resultId) {
        Intrinsics.checkNotNullParameter(testId, "testId");
        Intrinsics.checkNotNullParameter(resultId, "resultId");
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.SetSyntheticsTestAttribute(testId, resultId, now()));
    }

    @Override // com.datadog.android.rum.RumMonitor
    /* JADX INFO: renamed from: _getInternal, reason: from getter */
    public _RumInternalProxy getInternalProxy() {
        return this.internalProxy;
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void sendTelemetryEvent(InternalTelemetryEvent telemetryEvent) {
        Intrinsics.checkNotNullParameter(telemetryEvent, "telemetryEvent");
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.TelemetryEventWrapper(telemetryEvent, now()));
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void enableJankStatsTracking(Activity activity) {
        RumFeature rumFeature;
        Intrinsics.checkNotNullParameter(activity, "activity");
        FeatureScope feature = this.sdkCore.getFeature("rum");
        if (feature == null || (rumFeature = (RumFeature) feature.unwrap()) == null) {
            return;
        }
        rumFeature.enableJankStatsTracking$dd_sdk_android_rum_release(activity);
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void sendTTIDEvent(RumTTIDInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.AppStartTTIDEvent(info, now()));
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void sendAppStartEvent(RumStartupScenario scenario) {
        Intrinsics.checkNotNullParameter(scenario, "scenario");
        handleEvent$dd_sdk_android_rum_release(new RumRawEvent.AppStartEvent(scenario, now()));
    }

    @Override // com.datadog.android.rum.RumMonitor
    @Deprecated(message = "Use startOperation instead.", replaceWith = @ReplaceWith(expression = "startOperation", imports = {}))
    public void startFeatureOperation(String name, String operationKey, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        startOperation(name, operationKey, OperationOptions.Empty.INSTANCE, attributes);
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void startOperation(final String name, final String operationKey, OperationOptions options, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        if (operationArgumentsValid(name, operationKey)) {
            handleEvent$dd_sdk_android_rum_release(new RumRawEvent.StartOperation(name, operationKey, MapsKt.toMap(attributes), getEventTime(attributes)));
            InternalLoggerKt.logToUser$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.DEBUG, false, new Function0<String>() { // from class: com.datadog.android.rum.internal.monitor.DatadogRumMonitor.startOperation.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Operation `" + name + "` (operationKey `" + operationKey + "`) started.";
                }
            }, 2, null);
            INSTANCE.reportOperationApiUsage(this.sdkCore.getInternalLogger(), InternalTelemetryEvent.ApiUsage.AddOperationStepVital.ActionType.START);
        }
    }

    @Override // com.datadog.android.rum.RumMonitor
    @Deprecated(message = "Use succeedOperation instead.", replaceWith = @ReplaceWith(expression = "succeedOperation", imports = {}))
    public void succeedFeatureOperation(String name, String operationKey, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        succeedOperation(name, operationKey, attributes);
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void succeedOperation(final String name, final String operationKey, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        if (operationArgumentsValid(name, operationKey)) {
            handleEvent$dd_sdk_android_rum_release(new RumRawEvent.StopOperation(name, operationKey, MapsKt.toMap(attributes), getEventTime(attributes), null));
            InternalLoggerKt.logToUser$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.DEBUG, false, new Function0<String>() { // from class: com.datadog.android.rum.internal.monitor.DatadogRumMonitor.succeedOperation.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Operation `" + name + "` (operationKey `" + operationKey + "`) successfully ended.";
                }
            }, 2, null);
            INSTANCE.reportOperationApiUsage(this.sdkCore.getInternalLogger(), InternalTelemetryEvent.ApiUsage.AddOperationStepVital.ActionType.SUCCEED);
        }
    }

    @Override // com.datadog.android.rum.RumMonitor
    @Deprecated(message = "Use failOperation instead.", replaceWith = @ReplaceWith(expression = "failOperation", imports = {}))
    public void failFeatureOperation(String name, String operationKey, FailureReason failureReason, Map<String, ? extends Object> attributes) {
        com.datadog.android.rum.operations.FailureReason failureReason2;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(failureReason, "failureReason");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        int i = WhenMappings.$EnumSwitchMapping$0[failureReason.ordinal()];
        if (i == 1) {
            failureReason2 = com.datadog.android.rum.operations.FailureReason.ERROR;
        } else if (i == 2) {
            failureReason2 = com.datadog.android.rum.operations.FailureReason.ABANDONED;
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            failureReason2 = com.datadog.android.rum.operations.FailureReason.OTHER;
        }
        failOperation(name, operationKey, failureReason2, attributes);
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void failOperation(final String name, final String operationKey, final com.datadog.android.rum.operations.FailureReason failureReason, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(failureReason, "failureReason");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        if (operationArgumentsValid(name, operationKey)) {
            handleEvent$dd_sdk_android_rum_release(new RumRawEvent.StopOperation(name, operationKey, MapsKt.toMap(attributes), getEventTime(attributes), failureReason));
            InternalLoggerKt.logToUser$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.DEBUG, false, new Function0<String>() { // from class: com.datadog.android.rum.internal.monitor.DatadogRumMonitor.failOperation.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Operation `" + name + "` (operationKey `" + operationKey + "`) unsuccessfully ended with the following failure reason: " + failureReason + ".";
                }
            }, 2, null);
            INSTANCE.reportOperationApiUsage(this.sdkCore.getInternalLogger(), InternalTelemetryEvent.ApiUsage.AddOperationStepVital.ActionType.FAIL);
        }
    }

    private final boolean operationArgumentsValid(final String name, final String operationKey) {
        String str = name;
        if (StringsKt.isBlank(str)) {
            InternalLoggerKt.logToUser$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.WARN, false, new Function0<String>() { // from class: com.datadog.android.rum.internal.monitor.DatadogRumMonitor.operationArgumentsValid.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str2 = String.format(Locale.US, DatadogRumMonitor.OPERATION_ERROR_INVALID_NAME, Arrays.copyOf(new Object[]{name}, 1));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    return str2;
                }
            }, 2, null);
            return false;
        }
        if (!VALID_OPERATION_NAME_REGEX.matches(str)) {
            InternalLoggerKt.logToUser$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.WARN, false, new Function0<String>() { // from class: com.datadog.android.rum.internal.monitor.DatadogRumMonitor.operationArgumentsValid.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str2 = String.format(Locale.US, DatadogRumMonitor.OPERATION_ERROR_INVALID_NAME_CHARACTERS, Arrays.copyOf(new Object[]{name}, 1));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    return str2;
                }
            }, 2, null);
        }
        if (operationKey != null && StringsKt.isBlank(operationKey)) {
            InternalLoggerKt.logToUser$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.WARN, false, new Function0<String>() { // from class: com.datadog.android.rum.internal.monitor.DatadogRumMonitor.operationArgumentsValid.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str2 = String.format(Locale.US, DatadogRumMonitor.OPERATION_ERROR_INVALID_OPERATION_KEY, Arrays.copyOf(new Object[]{operationKey}, 1));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    return str2;
                }
            }, 2, null);
        }
        return true;
    }

    public final void drainExecutorService$dd_sdk_android_rum_release() throws UnsupportedOperationException, InterruptedException {
        BlockingQueue<Runnable> queue;
        ArrayList arrayList = new ArrayList();
        ExecutorService executorService = this.executorService;
        ThreadPoolExecutor threadPoolExecutor = executorService instanceof ThreadPoolExecutor ? (ThreadPoolExecutor) executorService : null;
        if (threadPoolExecutor != null && (queue = threadPoolExecutor.getQueue()) != null) {
            queue.drainTo(arrayList);
        }
        this.executorService.shutdown();
        this.executorService.awaitTermination(10L, TimeUnit.SECONDS);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    public final void stopTimeseries$dd_sdk_android_rum_release() {
        synchronized (this.rootScope) {
            RumSessionScope activeSession = this.rootScope.getActiveSession();
            if (activeSession != null) {
                activeSession.stopTimeseries$dd_sdk_android_rum_release();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void handleEvent$dd_sdk_android_rum_release(final RumRawEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if ((event instanceof RumRawEvent.AddError) && ((RumRawEvent.AddError) event).isFatal()) {
            FeatureScope feature = this.sdkCore.getFeature("rum");
            if (Intrinsics.areEqual((Object) (feature != null ? Boolean.valueOf(feature.withWriteContextSync(SetsKt.setOf("session-replay"), new Function2<DatadogContext, Function1<? super Function1<? super EventBatchWriter, ? extends Unit>, ? extends Unit>, Unit>() { // from class: com.datadog.android.rum.internal.monitor.DatadogRumMonitor$handleEvent$handled$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, ? extends Unit>, ? extends Unit> function1) {
                    invoke2(datadogContext, (Function1<? super Function1<? super EventBatchWriter, Unit>, Unit>) function1);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> eventWriteScope) {
                    Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
                    Intrinsics.checkNotNullParameter(eventWriteScope, "eventWriteScope");
                    RumApplicationScope rootScope = this.this$0.getRootScope();
                    DatadogRumMonitor datadogRumMonitor = this.this$0;
                    RumRawEvent rumRawEvent = event;
                    synchronized (rootScope) {
                        datadogRumMonitor.getRootScope().handleEvent(rumRawEvent, datadogContext, eventWriteScope, datadogRumMonitor.writer);
                        final RumContext rumContextCurrentRumContext = datadogRumMonitor.currentRumContext();
                        datadogRumMonitor.sdkCore.updateFeatureContext("rum", false, new Function1<Map<String, Object>, Unit>() { // from class: com.datadog.android.rum.internal.monitor.DatadogRumMonitor$handleEvent$handled$1$1$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Map<String, Object> map) {
                                invoke2(map);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Map<String, Object> it) {
                                Map<String, Object> map;
                                Intrinsics.checkNotNullParameter(it, "it");
                                it.clear();
                                RumContext rumContext = rumContextCurrentRumContext;
                                if (rumContext == null || (map = rumContext.toMap()) == null) {
                                    return;
                                }
                                it.putAll(map);
                            }
                        });
                        Unit unit = Unit.INSTANCE;
                    }
                }
            })) : null), (Object) true)) {
                return;
            }
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.monitor.DatadogRumMonitor$handleEvent$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return DatadogRumMonitor.CANNOT_WRITE_CRASH_WRITE_CONTEXT_IS_NOT_AVAILABLE;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return;
        }
        if (event instanceof RumRawEvent.TelemetryEventWrapper) {
            this.telemetryEventHandler.handleEvent((RumRawEvent.TelemetryEventWrapper) event, this.writer);
            return;
        }
        FeatureScope feature2 = this.sdkCore.getFeature("rum");
        if (feature2 != null) {
            feature2.withWriteContext(SetsKt.setOf((Object[]) new String[]{"session-replay", "profiling", "tracing"}), new DatadogRumMonitor$handleEvent$2(this, event));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleEventWithMethodCallPerf(final RumRawEvent event, final DatadogContext datadogContext, final Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope) {
        InternalLogger internalLogger = this.sdkCore.getInternalLogger();
        Class<?> cls = getClass();
        String simpleName = Reflection.getOrCreateKotlinClass(event.getClass()).getSimpleName();
        if (simpleName == null) {
            simpleName = ViewUtilsKt.UNKNOWN_DESTINATION_URL;
        }
        FeatureScopeExtKt.measureMethodCallPerf(internalLogger, cls, "RUM event - " + simpleName, MethodCallSamplingRate.RARE.getRate(), new Function0<RumScope>() { // from class: com.datadog.android.rum.internal.monitor.DatadogRumMonitor.handleEventWithMethodCallPerf.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RumScope invoke() {
                return DatadogRumMonitor.this.getRootScope().handleEvent(event, datadogContext, writeScope, DatadogRumMonitor.this.writer);
            }
        });
    }

    private final void waitForPendingEvents() {
        if (this.executorService.isShutdown()) {
            return;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        ConcurrencyExtKt.executeSafe(this.executorService, "pending event waiting", this.sdkCore.getInternalLogger(), new Runnable() { // from class: com.datadog.android.rum.internal.monitor.DatadogRumMonitor$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await(1L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.monitor.DatadogRumMonitor.waitForPendingEvents.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Waiting for pending RUM events was interrupted";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    /* JADX INFO: renamed from: getCurrentViewUrl, reason: from getter */
    public String getCachedViewUrl() {
        return this.cachedViewUrl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCachedViewUrl(RumContext context) {
        String viewUrl = context != null ? context.getViewUrl() : null;
        if (Intrinsics.areEqual(this.cachedViewUrl, viewUrl)) {
            return;
        }
        this.cachedViewUrl = viewUrl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RumContext currentRumContext() {
        RumContext rumContext;
        RumSessionScope activeSession = this.rootScope.getActiveSession();
        if (activeSession == null) {
            return null;
        }
        RumViewScope activeView$dd_sdk_android_rum_release = activeSession.getActiveView$dd_sdk_android_rum_release();
        if (activeView$dd_sdk_android_rum_release == null || (rumContext = activeView$dd_sdk_android_rum_release.getRumContext()) == null) {
            rumContext = activeSession.getRumContext();
        }
        if (Intrinsics.areEqual(rumContext.getSessionId(), "00000000-0000-0000-0000-000000000000")) {
            return null;
        }
        return rumContext;
    }

    public final void notifyDebugListenerWithState$dd_sdk_android_rum_release() {
        RumDebugListener rumDebugListener = this.debugListener;
        if (rumDebugListener != null) {
            RumSessionScope activeSession = this.rootScope.getActiveSession();
            RumViewManagerScope childScope = activeSession != null ? activeSession.getChildScope() : null;
            if (childScope != null) {
                List<RumViewScope> childrenScopes$dd_sdk_android_rum_release = childScope.getChildrenScopes$dd_sdk_android_rum_release();
                ArrayList arrayList = new ArrayList();
                for (Object obj : childrenScopes$dd_sdk_android_rum_release) {
                    if (((RumViewScope) obj).getIsActive()) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String viewName = ((RumViewScope) it.next()).getRumContext().getViewName();
                    if (viewName != null) {
                        arrayList2.add(viewName);
                    }
                }
                rumDebugListener.onReceiveRumActiveViews(arrayList2);
            }
        }
    }

    private final Time getEventTime(Map<String, ? extends Object> attributes) {
        Object obj = attributes.get(RumAttributes.INTERNAL_TIMESTAMP);
        Long l = obj instanceof Long ? (Long) obj : null;
        if (l != null) {
            Time timeFromTimestampMillis = Time.INSTANCE.fromTimestampMillis(l.longValue(), this.sdkCore.getTimeProvider());
            if (timeFromTimestampMillis != null) {
                return timeFromTimestampMillis;
            }
        }
        return now();
    }

    private final Time now() {
        return Time.INSTANCE.now(this.sdkCore.getTimeProvider());
    }

    private final String getErrorType(Map<String, ? extends Object> attributes) {
        Object obj = attributes.get(RumAttributes.INTERNAL_ERROR_TYPE);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final RumErrorSourceType getErrorSourceType(Map<String, ? extends Object> attributes) {
        Object obj = attributes.get("_dd.error.source_type");
        String lowerCase = null;
        String str = obj instanceof String ? (String) obj : null;
        if (str != null) {
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            lowerCase = str.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        }
        if (lowerCase != null) {
            switch (lowerCase.hashCode()) {
                case -861391249:
                    if (lowerCase.equals("android")) {
                        return RumErrorSourceType.ANDROID;
                    }
                    break;
                case -760334308:
                    if (lowerCase.equals("flutter")) {
                        return RumErrorSourceType.FLUTTER;
                    }
                    break;
                case -380982102:
                    if (lowerCase.equals("ndk+il2cpp")) {
                        return RumErrorSourceType.NDK_IL2CPP;
                    }
                    break;
                case 108917:
                    if (lowerCase.equals("ndk")) {
                        return RumErrorSourceType.NDK;
                    }
                    break;
                case 150940456:
                    if (lowerCase.equals("browser")) {
                        return RumErrorSourceType.BROWSER;
                    }
                    break;
                case 828638245:
                    if (lowerCase.equals("react-native")) {
                        return RumErrorSourceType.REACT_NATIVE;
                    }
                    break;
            }
        }
        return RumErrorSourceType.ANDROID;
    }

    /* JADX INFO: compiled from: DatadogRumMonitor.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/datadog/android/rum/internal/monitor/DatadogRumMonitor$Companion;", "", "()V", "CANNOT_WRITE_CRASH_WRITE_CONTEXT_IS_NOT_AVAILABLE", "", "DRAIN_WAIT_SECONDS", "", "OPERATION_ERROR_INVALID_NAME", "OPERATION_ERROR_INVALID_NAME_CHARACTERS", "OPERATION_ERROR_INVALID_OPERATION_KEY", "RUM_DEBUG_RUM_NOT_ENABLED_WARNING", "VALID_OPERATION_NAME_REGEX", "Lkotlin/text/Regex;", "getVALID_OPERATION_NAME_REGEX$dd_sdk_android_rum_release", "()Lkotlin/text/Regex;", "reportOperationApiUsage", "", "Lcom/datadog/android/api/InternalLogger;", "actionType", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage$AddOperationStepVital$ActionType;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Regex getVALID_OPERATION_NAME_REGEX$dd_sdk_android_rum_release() {
            return DatadogRumMonitor.VALID_OPERATION_NAME_REGEX;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void reportOperationApiUsage(InternalLogger internalLogger, final InternalTelemetryEvent.ApiUsage.AddOperationStepVital.ActionType actionType) {
            InternalLogger.DefaultImpls.logApiUsage$default(internalLogger, 0.0f, new Function0<InternalTelemetryEvent.ApiUsage>() { // from class: com.datadog.android.rum.internal.monitor.DatadogRumMonitor$Companion$reportOperationApiUsage$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final InternalTelemetryEvent.ApiUsage invoke() {
                    return new InternalTelemetryEvent.ApiUsage.AddOperationStepVital(actionType, null, 2, null);
                }
            }, 1, null);
        }
    }
}

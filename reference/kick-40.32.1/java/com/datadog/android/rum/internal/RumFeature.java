package com.datadog.android.rum.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.ApplicationExitInfo;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import com.canhub.cropper.BitmapUtils$$ExternalSyntheticApiModelOutline0;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.feature.FeatureContextUpdateReceiver;
import com.datadog.android.api.feature.FeatureEventReceiver;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.feature.StorageBackedFeature;
import com.datadog.android.api.net.RequestFactory;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.api.storage.FeatureStorageConfiguration;
import com.datadog.android.api.storage.NoOpDataWriter;
import com.datadog.android.core.InternalSdkCore;
import com.datadog.android.core.feature.event.JvmCrash;
import com.datadog.android.core.feature.event.ThreadDump;
import com.datadog.android.core.internal.utils.ConcurrencyExtKt;
import com.datadog.android.event.EventMapper;
import com.datadog.android.event.MapperSerializer;
import com.datadog.android.event.NoOpEventMapper;
import com.datadog.android.heatmaps.HeatmapIdentifierRegistryProvider;
import com.datadog.android.internal.flags.RumFlagEvaluationMessage;
import com.datadog.android.internal.heatmaps.HeatmapIdentifierRegistry;
import com.datadog.android.internal.profiling.ProfilingAnrDetectedEvent;
import com.datadog.android.internal.profiling.ProfilingThreadDump;
import com.datadog.android.internal.system.BuildSdkVersionProvider;
import com.datadog.android.internal.telemetry.InternalTelemetryEvent;
import com.datadog.android.internal.thread.ThreadUtilsKt;
import com.datadog.android.internal.utils.ThreadExtKt;
import com.datadog.android.internal.utils.ThrowableExtKt;
import com.datadog.android.rum.GlobalRumMonitor;
import com.datadog.android.rum.RumAttributes;
import com.datadog.android.rum.RumErrorSource;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.RumSessionListener;
import com.datadog.android.rum.RumSessionType;
import com.datadog.android.rum.configuration.SlowFramesConfiguration;
import com.datadog.android.rum.configuration.VitalsUpdateFrequency;
import com.datadog.android.rum.internal.anr.ANRDetectorRunnable;
import com.datadog.android.rum.internal.anr.ANRException;
import com.datadog.android.rum.internal.debug.UiRumDebugListener;
import com.datadog.android.rum.internal.domain.InfoProvider;
import com.datadog.android.rum.internal.domain.RumDataWriter;
import com.datadog.android.rum.internal.domain.accessibility.AccessibilityInfo;
import com.datadog.android.rum.internal.domain.accessibility.AccessibilitySnapshotManager;
import com.datadog.android.rum.internal.domain.accessibility.DefaultAccessibilityReader;
import com.datadog.android.rum.internal.domain.accessibility.DefaultAccessibilitySnapshotManager;
import com.datadog.android.rum.internal.domain.accessibility.NoOpAccessibilityReader;
import com.datadog.android.rum.internal.domain.accessibility.NoOpAccessibilitySnapshotManager;
import com.datadog.android.rum.internal.domain.battery.BatteryInfo;
import com.datadog.android.rum.internal.domain.battery.DefaultBatteryInfoProvider;
import com.datadog.android.rum.internal.domain.battery.NoOpBatteryInfoProvider;
import com.datadog.android.rum.internal.domain.display.DefaultDisplayInfoProvider;
import com.datadog.android.rum.internal.domain.display.DisplayInfo;
import com.datadog.android.rum.internal.domain.display.NoOpDisplayInfoProvider;
import com.datadog.android.rum.internal.domain.event.RumEventMapper;
import com.datadog.android.rum.internal.domain.event.RumEventMetaDeserializer;
import com.datadog.android.rum.internal.domain.event.RumEventMetaSerializer;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.rum.internal.domain.event.RumViewEventFilter;
import com.datadog.android.rum.internal.instrumentation.MainLooperLongTaskStrategy;
import com.datadog.android.rum.internal.instrumentation.UserActionTrackingStrategyApi29;
import com.datadog.android.rum.internal.instrumentation.UserActionTrackingStrategyLegacy;
import com.datadog.android.rum.internal.instrumentation.gestures.DatadogGesturesTracker;
import com.datadog.android.rum.internal.instrumentation.insights.InsightsCollector;
import com.datadog.android.rum.internal.instrumentation.insights.NoOpInsightsCollector;
import com.datadog.android.rum.internal.metric.slowframes.DefaultSlowFramesListener;
import com.datadog.android.rum.internal.metric.slowframes.DefaultUISlownessMetricDispatcher;
import com.datadog.android.rum.internal.metric.slowframes.SlowFramesListener;
import com.datadog.android.rum.internal.monitor.AdvancedRumMonitor;
import com.datadog.android.rum.internal.monitor.DatadogRumMonitor;
import com.datadog.android.rum.internal.net.RumRequestFactory;
import com.datadog.android.rum.internal.startup.DefaultAppStartupActivityPredicate;
import com.datadog.android.rum.internal.startup.RumAppStartupDetector;
import com.datadog.android.rum.internal.startup.RumStartupScenario;
import com.datadog.android.rum.internal.startup.RumTTIDInfo;
import com.datadog.android.rum.internal.thread.NoOpScheduledExecutorService;
import com.datadog.android.rum.internal.timeseries.DefaultTimeseriesCollectorFactory;
import com.datadog.android.rum.internal.timeseries.NoOpTimeseriesCollectorFactory;
import com.datadog.android.rum.internal.timeseries.TimeseriesCollector;
import com.datadog.android.rum.internal.tracking.JetpackViewAttributesProvider;
import com.datadog.android.rum.internal.tracking.NoOpInteractionPredicate;
import com.datadog.android.rum.internal.tracking.NoOpUserActionTrackingStrategy;
import com.datadog.android.rum.internal.tracking.UserActionTrackingStrategy;
import com.datadog.android.rum.internal.vitals.AggregatingVitalMonitor;
import com.datadog.android.rum.internal.vitals.CPUVitalReader;
import com.datadog.android.rum.internal.vitals.CpuStatReader;
import com.datadog.android.rum.internal.vitals.FPSVitalListener;
import com.datadog.android.rum.internal.vitals.FrameStateListener;
import com.datadog.android.rum.internal.vitals.FrameStatesAggregator;
import com.datadog.android.rum.internal.vitals.MemoryVitalReader;
import com.datadog.android.rum.internal.vitals.NoOpVitalMonitor;
import com.datadog.android.rum.internal.vitals.VitalMonitor;
import com.datadog.android.rum.internal.vitals.VitalObserver;
import com.datadog.android.rum.internal.vitals.VitalReader;
import com.datadog.android.rum.internal.vitals.VitalReaderRunnable;
import com.datadog.android.rum.metric.interactiontonextview.LastInteractionIdentifier;
import com.datadog.android.rum.metric.interactiontonextview.NoOpLastInteractionIdentifier;
import com.datadog.android.rum.metric.interactiontonextview.TimeBasedInteractionIdentifier;
import com.datadog.android.rum.metric.networksettled.InitialResourceIdentifier;
import com.datadog.android.rum.metric.networksettled.NoOpInitialResourceIdentifier;
import com.datadog.android.rum.metric.networksettled.TimeBasedInitialResourceIdentifier;
import com.datadog.android.rum.model.ActionEvent;
import com.datadog.android.rum.model.ErrorEvent;
import com.datadog.android.rum.model.LongTaskEvent;
import com.datadog.android.rum.model.ResourceEvent;
import com.datadog.android.rum.model.ViewEvent;
import com.datadog.android.rum.model.VitalAppLaunchEvent;
import com.datadog.android.rum.model.VitalOperationStepEvent;
import com.datadog.android.rum.startup.AppStartupActivityPredicate;
import com.datadog.android.rum.timeseries.TimeseriesConfiguration;
import com.datadog.android.rum.tracking.ActionTrackingStrategy;
import com.datadog.android.rum.tracking.ActivityViewTrackingStrategy;
import com.datadog.android.rum.tracking.InteractionPredicate;
import com.datadog.android.rum.tracking.NoOpActionTrackingStrategy;
import com.datadog.android.rum.tracking.NoOpTrackingStrategy;
import com.datadog.android.rum.tracking.NoOpViewTrackingStrategy;
import com.datadog.android.rum.tracking.TrackingStrategy;
import com.datadog.android.rum.tracking.ViewAttributesProvider;
import com.datadog.android.rum.tracking.ViewTrackingStrategy;
import com.datadog.android.telemetry.model.TelemetryConfigurationEvent;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RumFeature.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000²\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u008d\u00022\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u008d\u0002\u008e\u0002BG\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0014\u0010Í\u0001\u001a\u00030Î\u00012\b\u0010Ï\u0001\u001a\u00030Ð\u0001H\u0002J\u001c\u0010Ñ\u0001\u001a\u00030Î\u00012\u0010\u0010Ò\u0001\u001a\u000b\u0012\u0002\b\u0003\u0012\u0002\b\u00030Ó\u0001H\u0002J\u001c\u0010Ô\u0001\u001a\u00030Î\u00012\u0010\u0010Ò\u0001\u001a\u000b\u0012\u0002\b\u0003\u0012\u0002\b\u00030Ó\u0001H\u0002J\n\u0010Õ\u0001\u001a\u00030Î\u0001H\u0002J\n\u0010Ö\u0001\u001a\u00030Î\u0001H\u0002J\u0019\u0010×\u0001\u001a\u00030Î\u00012\u0007\u0010Ø\u0001\u001a\u00020'H\u0001¢\u0006\u0003\bÙ\u0001J\u001f\u0010Ú\u0001\u001a\b\u0012\u0004\u0012\u00020J0I2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\fH\u0002J\u0010\u0010Û\u0001\u001a\u00030Î\u0001H\u0001¢\u0006\u0003\bÜ\u0001J\u001a\u0010Ý\u0001\u001a\u00030Î\u00012\b\u0010Þ\u0001\u001a\u00030ß\u0001H\u0001¢\u0006\u0003\bà\u0001J\u001a\u0010á\u0001\u001a\u00030Î\u00012\b\u0010â\u0001\u001a\u00030ã\u0001H\u0000¢\u0006\u0003\bä\u0001J\u0014\u0010å\u0001\u001a\u00030Î\u00012\b\u0010æ\u0001\u001a\u00030ç\u0001H\u0002J\u001c\u0010è\u0001\u001a\u00030Î\u00012\u0010\u0010æ\u0001\u001a\u000b\u0012\u0002\b\u0003\u0012\u0002\b\u00030Ó\u0001H\u0002J\u0014\u0010é\u0001\u001a\u00030Î\u00012\b\u0010æ\u0001\u001a\u00030ê\u0001H\u0002J\u0014\u0010ë\u0001\u001a\u00030Î\u00012\b\u0010æ\u0001\u001a\u00030ì\u0001H\u0002J\n\u0010í\u0001\u001a\u00030Î\u0001H\u0002J\n\u0010î\u0001\u001a\u00030Î\u0001H\u0002J\u0014\u0010ï\u0001\u001a\u00030Î\u00012\b\u0010ð\u0001\u001a\u00030ñ\u0001H\u0002J\u0016\u0010ò\u0001\u001a\u0005\u0018\u00010ó\u00012\b\u0010ð\u0001\u001a\u00030ñ\u0001H\u0002J\u0014\u0010ô\u0001\u001a\u00030Î\u00012\b\u0010ð\u0001\u001a\u00030ñ\u0001H\u0002J\u0018\u0010õ\u0001\u001a\u0005\u0018\u00010ö\u00012\n\u0010÷\u0001\u001a\u0005\u0018\u00010ø\u0001H\u0002J\n\u0010ù\u0001\u001a\u00030Î\u0001H\u0002J(\u0010ú\u0001\u001a\u00030Î\u00012\b\u0010û\u0001\u001a\u00030ü\u00012\b\u0010ý\u0001\u001a\u00030þ\u00012\b\u0010ÿ\u0001\u001a\u00030\u0080\u0002H\u0002J\u0012\u0010\u0081\u0002\u001a\u00030Î\u00012\u0006\u0010.\u001a\u00020/H\u0016J\u0013\u0010\u0082\u0002\u001a\u00030Î\u00012\u0007\u0010æ\u0001\u001a\u00020JH\u0016J\n\u0010\u0083\u0002\u001a\u00030Î\u0001H\u0016J\u0012\u0010\u0084\u0002\u001a\u00030Î\u00012\u0006\u0010.\u001a\u00020/H\u0002J\u0014\u0010\u0085\u0002\u001a\u00030Î\u00012\b\u0010.\u001a\u0004\u0018\u00010/H\u0002J \u0010\u0086\u0002\u001a\u00030Î\u0001*\u00030\u0087\u00022\u000f\u0010\u0088\u0002\u001a\n\u0012\u0005\u0012\u00030ö\u00010\u0089\u0002H\u0002J\u000f\u0010\u008a\u0002\u001a\u00030\u008b\u0002*\u00030\u008c\u0002H\u0002R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020/X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u001a\u00106\u001a\u000207X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R \u0010<\u001a\b\u0012\u0004\u0012\u00020=0\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0017\"\u0004\b?\u0010\u0019R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u001a\u0010B\u001a\u00020CX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR \u0010H\u001a\b\u0012\u0004\u0012\u00020J0IX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR \u0010O\u001a\b\u0012\u0004\u0012\u00020Q0PX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR \u0010V\u001a\b\u0012\u0004\u0012\u00020W0\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u0017\"\u0004\bY\u0010\u0019R\u001a\u0010Z\u001a\u00020CX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010E\"\u0004\b\\\u0010GR\u001c\u0010]\u001a\u0004\u0018\u00010QX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010b\u001a\u00020cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bd\u0010eR\u001a\u0010f\u001a\u00020gX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u0014\u0010l\u001a\u00020mX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bn\u0010oR\u001a\u0010p\u001a\u00020qX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\u001c\u0010v\u001a\u0004\u0018\u00010wX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R\u001c\u0010|\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\r\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0004\b}\u0010~R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0081\u0001\u001a\u00030\u0082\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001d\u0010\u0087\u0001\u001a\u00020CX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0001\u0010E\"\u0005\b\u0089\u0001\u0010GR\u0016\u0010\u008a\u0001\u001a\u00020\u0007X\u0096D¢\u0006\t\n\u0000\u001a\u0005\b\u008b\u0001\u00105R!\u0010\u008c\u0001\u001a\u00030\u008d\u00018VX\u0096\u0084\u0002¢\u0006\u0010\n\u0006\b\u0090\u0001\u0010\u0080\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R\"\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001f\u0010\u0097\u0001\u001a\n\u0012\u0005\u0012\u00030\u0099\u00010\u0098\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R \u0010\u009c\u0001\u001a\u00030\u009d\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001\"\u0006\b \u0001\u0010¡\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010¢\u0001\u001a\u00030£\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¤\u0001\u0010¥\u0001\"\u0006\b¦\u0001\u0010§\u0001R\"\u0010¨\u0001\u001a\u0005\u0018\u00010©\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bª\u0001\u0010«\u0001\"\u0006\b¬\u0001\u0010\u00ad\u0001R\u0018\u0010®\u0001\u001a\u00030¯\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b°\u0001\u0010±\u0001R \u0010²\u0001\u001a\u00030\u009d\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b³\u0001\u0010\u009f\u0001\"\u0006\b´\u0001\u0010¡\u0001R \u0010µ\u0001\u001a\u00030\u009d\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¶\u0001\u0010\u009f\u0001\"\u0006\b·\u0001\u0010¡\u0001R \u0010¸\u0001\u001a\u00030¹\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bº\u0001\u0010»\u0001\"\u0006\b¼\u0001\u0010½\u0001R\u001d\u0010¾\u0001\u001a\u000207X\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¿\u0001\u00109\"\u0005\bÀ\u0001\u0010;R \u0010Á\u0001\u001a\u00030Â\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÃ\u0001\u0010Ä\u0001\"\u0006\bÅ\u0001\u0010Æ\u0001R \u0010Ç\u0001\u001a\u00030È\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÉ\u0001\u0010Ê\u0001\"\u0006\bË\u0001\u0010Ì\u0001¨\u0006\u008f\u0002"}, d2 = {"Lcom/datadog/android/rum/internal/RumFeature;", "Lcom/datadog/android/api/feature/StorageBackedFeature;", "Lcom/datadog/android/api/feature/FeatureEventReceiver;", "Lcom/datadog/android/heatmaps/HeatmapIdentifierRegistryProvider;", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "applicationId", "", "configuration", "Lcom/datadog/android/rum/internal/RumFeature$Configuration;", "lateCrashReporterFactory", "Lkotlin/Function1;", "Lcom/datadog/android/core/InternalSdkCore;", "Lcom/datadog/android/rum/internal/LateCrashReporter;", "buildSdkVersionProvider", "Lcom/datadog/android/internal/system/BuildSdkVersionProvider;", "handler", "Landroid/os/Handler;", "(Lcom/datadog/android/api/feature/FeatureSdkCore;Ljava/lang/String;Lcom/datadog/android/rum/internal/RumFeature$Configuration;Lkotlin/jvm/functions/Function1;Lcom/datadog/android/internal/system/BuildSdkVersionProvider;Landroid/os/Handler;)V", "accessibilityReader", "Lcom/datadog/android/rum/internal/domain/InfoProvider;", "Lcom/datadog/android/rum/internal/domain/accessibility/AccessibilityInfo;", "getAccessibilityReader$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/internal/domain/InfoProvider;", "setAccessibilityReader$dd_sdk_android_rum_release", "(Lcom/datadog/android/rum/internal/domain/InfoProvider;)V", "accessibilitySnapshotManager", "Lcom/datadog/android/rum/internal/domain/accessibility/AccessibilitySnapshotManager;", "getAccessibilitySnapshotManager$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/internal/domain/accessibility/AccessibilitySnapshotManager;", "setAccessibilitySnapshotManager$dd_sdk_android_rum_release", "(Lcom/datadog/android/rum/internal/domain/accessibility/AccessibilitySnapshotManager;)V", "actionTrackingStrategy", "Lcom/datadog/android/rum/internal/tracking/UserActionTrackingStrategy;", "getActionTrackingStrategy$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/internal/tracking/UserActionTrackingStrategy;", "setActionTrackingStrategy$dd_sdk_android_rum_release", "(Lcom/datadog/android/rum/internal/tracking/UserActionTrackingStrategy;)V", "anrDetectorExecutorService", "Ljava/util/concurrent/ExecutorService;", "anrDetectorRunnable", "Lcom/datadog/android/rum/internal/anr/ANRDetectorRunnable;", "getAnrDetectorRunnable$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/internal/anr/ANRDetectorRunnable;", "setAnrDetectorRunnable$dd_sdk_android_rum_release", "(Lcom/datadog/android/rum/internal/anr/ANRDetectorRunnable;)V", "appContext", "Landroid/content/Context;", "getAppContext$dd_sdk_android_rum_release", "()Landroid/content/Context;", "setAppContext$dd_sdk_android_rum_release", "(Landroid/content/Context;)V", "getApplicationId$dd_sdk_android_rum_release", "()Ljava/lang/String;", "backgroundEventTracking", "", "getBackgroundEventTracking$dd_sdk_android_rum_release", "()Z", "setBackgroundEventTracking$dd_sdk_android_rum_release", "(Z)V", "batteryInfoProvider", "Lcom/datadog/android/rum/internal/domain/battery/BatteryInfo;", "getBatteryInfoProvider$dd_sdk_android_rum_release", "setBatteryInfoProvider$dd_sdk_android_rum_release", "getConfiguration$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/internal/RumFeature$Configuration;", "cpuVitalMonitor", "Lcom/datadog/android/rum/internal/vitals/VitalMonitor;", "getCpuVitalMonitor$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/internal/vitals/VitalMonitor;", "setCpuVitalMonitor$dd_sdk_android_rum_release", "(Lcom/datadog/android/rum/internal/vitals/VitalMonitor;)V", "dataWriter", "Lcom/datadog/android/api/storage/DataWriter;", "", "getDataWriter$dd_sdk_android_rum_release", "()Lcom/datadog/android/api/storage/DataWriter;", "setDataWriter$dd_sdk_android_rum_release", "(Lcom/datadog/android/api/storage/DataWriter;)V", "debugActivityLifecycleListener", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "getDebugActivityLifecycleListener$dd_sdk_android_rum_release", "()Ljava/util/concurrent/atomic/AtomicReference;", "setDebugActivityLifecycleListener$dd_sdk_android_rum_release", "(Ljava/util/concurrent/atomic/AtomicReference;)V", "displayInfoProvider", "Lcom/datadog/android/rum/internal/domain/display/DisplayInfo;", "getDisplayInfoProvider$dd_sdk_android_rum_release", "setDisplayInfoProvider$dd_sdk_android_rum_release", "frameRateVitalMonitor", "getFrameRateVitalMonitor$dd_sdk_android_rum_release", "setFrameRateVitalMonitor$dd_sdk_android_rum_release", "frameStatesAggregator", "getFrameStatesAggregator$dd_sdk_android_rum_release", "()Landroid/app/Application$ActivityLifecycleCallbacks;", "setFrameStatesAggregator$dd_sdk_android_rum_release", "(Landroid/app/Application$ActivityLifecycleCallbacks;)V", "heatmapIdentifierRegistry", "Lcom/datadog/android/internal/heatmaps/HeatmapIdentifierRegistry;", "getHeatmapIdentifierRegistry", "()Lcom/datadog/android/internal/heatmaps/HeatmapIdentifierRegistry;", "initialResourceIdentifier", "Lcom/datadog/android/rum/metric/networksettled/InitialResourceIdentifier;", "getInitialResourceIdentifier$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/metric/networksettled/InitialResourceIdentifier;", "setInitialResourceIdentifier$dd_sdk_android_rum_release", "(Lcom/datadog/android/rum/metric/networksettled/InitialResourceIdentifier;)V", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getInitialized$dd_sdk_android_rum_release", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "insightsCollector", "Lcom/datadog/android/rum/internal/instrumentation/insights/InsightsCollector;", "getInsightsCollector$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/internal/instrumentation/insights/InsightsCollector;", "setInsightsCollector$dd_sdk_android_rum_release", "(Lcom/datadog/android/rum/internal/instrumentation/insights/InsightsCollector;)V", "lastInteractionIdentifier", "Lcom/datadog/android/rum/metric/interactiontonextview/LastInteractionIdentifier;", "getLastInteractionIdentifier$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/metric/interactiontonextview/LastInteractionIdentifier;", "setLastInteractionIdentifier$dd_sdk_android_rum_release", "(Lcom/datadog/android/rum/metric/interactiontonextview/LastInteractionIdentifier;)V", "lateCrashEventHandler", "getLateCrashEventHandler", "()Lcom/datadog/android/rum/internal/LateCrashReporter;", "lateCrashEventHandler$delegate", "Lkotlin/Lazy;", "longTaskTrackingStrategy", "Lcom/datadog/android/rum/tracking/TrackingStrategy;", "getLongTaskTrackingStrategy$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/tracking/TrackingStrategy;", "setLongTaskTrackingStrategy$dd_sdk_android_rum_release", "(Lcom/datadog/android/rum/tracking/TrackingStrategy;)V", "memoryVitalMonitor", "getMemoryVitalMonitor$dd_sdk_android_rum_release", "setMemoryVitalMonitor$dd_sdk_android_rum_release", "name", "getName", "requestFactory", "Lcom/datadog/android/api/net/RequestFactory;", "getRequestFactory", "()Lcom/datadog/android/api/net/RequestFactory;", "requestFactory$delegate", "rumAppStartupDetector", "Lcom/datadog/android/rum/internal/startup/RumAppStartupDetector;", "getRumAppStartupDetector$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/internal/startup/RumAppStartupDetector;", "setRumAppStartupDetector$dd_sdk_android_rum_release", "(Lcom/datadog/android/rum/internal/startup/RumAppStartupDetector;)V", "rumContextUpdateReceivers", "", "Lcom/datadog/android/api/feature/FeatureContextUpdateReceiver;", "getRumContextUpdateReceivers$dd_sdk_android_rum_release", "()Ljava/util/Set;", "sampleRate", "", "getSampleRate$dd_sdk_android_rum_release", "()F", "setSampleRate$dd_sdk_android_rum_release", "(F)V", "sessionListener", "Lcom/datadog/android/rum/RumSessionListener;", "getSessionListener$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/RumSessionListener;", "setSessionListener$dd_sdk_android_rum_release", "(Lcom/datadog/android/rum/RumSessionListener;)V", "slowFramesListener", "Lcom/datadog/android/rum/internal/metric/slowframes/SlowFramesListener;", "getSlowFramesListener$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/internal/metric/slowframes/SlowFramesListener;", "setSlowFramesListener$dd_sdk_android_rum_release", "(Lcom/datadog/android/rum/internal/metric/slowframes/SlowFramesListener;)V", "storageConfiguration", "Lcom/datadog/android/api/storage/FeatureStorageConfiguration;", "getStorageConfiguration", "()Lcom/datadog/android/api/storage/FeatureStorageConfiguration;", "telemetryConfigurationSampleRate", "getTelemetryConfigurationSampleRate$dd_sdk_android_rum_release", "setTelemetryConfigurationSampleRate$dd_sdk_android_rum_release", "telemetrySampleRate", "getTelemetrySampleRate$dd_sdk_android_rum_release", "setTelemetrySampleRate$dd_sdk_android_rum_release", "timeseriesCollectorFactory", "Lcom/datadog/android/rum/internal/timeseries/TimeseriesCollector$Factory;", "getTimeseriesCollectorFactory$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/internal/timeseries/TimeseriesCollector$Factory;", "setTimeseriesCollectorFactory$dd_sdk_android_rum_release", "(Lcom/datadog/android/rum/internal/timeseries/TimeseriesCollector$Factory;)V", "trackFrustrations", "getTrackFrustrations$dd_sdk_android_rum_release", "setTrackFrustrations$dd_sdk_android_rum_release", "viewTrackingStrategy", "Lcom/datadog/android/rum/tracking/ViewTrackingStrategy;", "getViewTrackingStrategy$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/tracking/ViewTrackingStrategy;", "setViewTrackingStrategy$dd_sdk_android_rum_release", "(Lcom/datadog/android/rum/tracking/ViewTrackingStrategy;)V", "vitalExecutorService", "Ljava/util/concurrent/ScheduledExecutorService;", "getVitalExecutorService$dd_sdk_android_rum_release", "()Ljava/util/concurrent/ScheduledExecutorService;", "setVitalExecutorService$dd_sdk_android_rum_release", "(Ljava/util/concurrent/ScheduledExecutorService;)V", "addJvmCrash", "", "crashEvent", "Lcom/datadog/android/core/feature/event/JvmCrash$Rum;", "addLoggerError", "loggerErrorEvent", "", "addLoggerErrorWithStacktrace", "addSessionReplaySkippedFrame", "cleanupInfoProviders", "consumeLastFatalAnr", "rumEventsExecutorService", "consumeLastFatalAnr$dd_sdk_android_rum_release", "createDataWriter", "disableDebugging", "disableDebugging$dd_sdk_android_rum_release", "enableDebugging", "advancedRumMonitor", "Lcom/datadog/android/rum/internal/monitor/AdvancedRumMonitor;", "enableDebugging$dd_sdk_android_rum_release", "enableJankStatsTracking", "activity", "Landroid/app/Activity;", "enableJankStatsTracking$dd_sdk_android_rum_release", "handleFlagEvaluationEvent", "event", "Lcom/datadog/android/internal/flags/RumFlagEvaluationMessage;", "handleMapLikeEvent", "handleProfilingAnrDetectedEvent", "Lcom/datadog/android/internal/profiling/ProfilingAnrDetectedEvent;", "handleTelemetryEvent", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent;", "initRumAppStartupDetector", "initializeANRDetector", "initializeCpuVitalMonitor", "frequency", "Lcom/datadog/android/rum/configuration/VitalsUpdateFrequency;", "initializeFPSVitalMonitor", "Lcom/datadog/android/rum/internal/vitals/FPSVitalListener;", "initializeMemoryVitalMonitor", "initializeSlowFrameListener", "Lcom/datadog/android/rum/internal/vitals/FrameStateListener;", "slowFramesConfiguration", "Lcom/datadog/android/rum/configuration/SlowFramesConfiguration;", "initializeVitalExecutorService", "initializeVitalMonitor", "vitalReader", "Lcom/datadog/android/rum/internal/vitals/VitalReader;", "vitalObserver", "Lcom/datadog/android/rum/internal/vitals/VitalObserver;", "periodInMs", "", "onInitialize", "onReceive", "onStop", "registerTrackingStrategies", "unregisterTrackingStrategies", "initializeFrameStatesAggregator", "Landroid/app/Application;", "listeners", "", "toThreadDump", "Lcom/datadog/android/core/feature/event/ThreadDump;", "Lcom/datadog/android/internal/profiling/ProfilingThreadDump;", "Companion", "Configuration", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RumFeature implements StorageBackedFeature, FeatureEventReceiver, HeatmapIdentifierRegistryProvider {
    public static final float ALL_IN_SAMPLE_RATE = 100.0f;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final String DD_TELEMETRY_CONFIG_SAMPLE_RATE_TAG = "_dd.telemetry.configuration_sample_rate";
    public static final long DEFAULT_LONG_TASK_THRESHOLD_MS = 100;
    private static final Configuration DEFAULT_RUM_CONFIG;
    public static final float DEFAULT_SAMPLE_RATE = 100.0f;
    public static final float DEFAULT_TELEMETRY_CONFIGURATION_SAMPLE_RATE = 20.0f;
    public static final float DEFAULT_TELEMETRY_SAMPLE_RATE = 20.0f;
    public static final String DEVELOPER_MODE_SAMPLE_RATE_CHANGED_MESSAGE = "Developer mode enabled, setting RUM sample rate to 100%.";
    public static final String EVENT_ATTRIBUTES_PROPERTY = "attributes";
    public static final String EVENT_MESSAGE_PROPERTY = "message";
    public static final String EVENT_STACKTRACE_PROPERTY = "stacktrace";
    public static final String EVENT_THROWABLE_PROPERTY = "throwable";
    public static final String FAILED_TO_ENABLE_JANK_STATS_TRACKING_MANUALLY = "Manually enabling JankStats tracking threw an exception.";
    public static final String FAILED_TO_GET_HISTORICAL_EXIT_REASONS = "Couldn't get historical exit reasons";
    public static final String FLUSH_AND_STOP_MONITOR_MESSAGE_TYPE = "flush_and_stop_monitor";
    public static final String LOGGER_ERROR_BUS_MESSAGE_TYPE = "logger_error";
    public static final String LOGGER_ERROR_WITH_STACK_TRACE_MESSAGE_TYPE = "logger_error_with_stacktrace";
    public static final String LOG_ERROR_EVENT_MISSING_MANDATORY_FIELDS = "RUM feature received a log event where mandatory message field is either missing or has a wrong type.";
    public static final String LOG_ERROR_WITH_STACKTRACE_EVENT_MISSING_MANDATORY_FIELDS = "RUM feature received a log event with stacktrace where mandatory message field is either missing or has a wrong type.";
    public static final String NDK_CRASH_BUS_MESSAGE_TYPE = "ndk_crash";
    public static final String NO_LAST_RUM_VIEW_EVENT_AVAILABLE = "No last known RUM view event found, skipping fatal ANR reporting.";
    public static final String RUM_FEATURE_NOT_YET_INITIALIZED = "RUM feature is not initialized yet, you need to register it with a SDK instance by calling SdkCore#registerFeature method.";
    private static final long RUM_TTL_24H;
    public static final String SLOW_FRAMES_MONITORING_DISABLED_MESSAGE = "Slow frames monitoring disabled.";
    public static final String SLOW_FRAMES_MONITORING_ENABLED_MESSAGE = "Slow frames monitoring enabled.";
    public static final String TELEMETRY_SESSION_REPLAY_SKIP_FRAME = "sr_skipped_frame";
    public static final String UNKNOWN_EVENT_TYPE_PROPERTY_VALUE = "RUM feature received an event with unknown value of \"type\" property=%s.";
    public static final String UNSUPPORTED_EVENT_TYPE = "RUM feature receive an event of unsupported type=%s.";
    public static final String WEB_VIEW_INGESTED_NOTIFICATION_MESSAGE_TYPE = "web_view_ingested_notification";
    private InfoProvider<AccessibilityInfo> accessibilityReader;
    private AccessibilitySnapshotManager accessibilitySnapshotManager;
    private UserActionTrackingStrategy actionTrackingStrategy;
    private ExecutorService anrDetectorExecutorService;
    private ANRDetectorRunnable anrDetectorRunnable;
    public Context appContext;
    private final String applicationId;
    private boolean backgroundEventTracking;
    private InfoProvider<BatteryInfo> batteryInfoProvider;
    private final BuildSdkVersionProvider buildSdkVersionProvider;
    private final Configuration configuration;
    private VitalMonitor cpuVitalMonitor;
    private DataWriter<Object> dataWriter;
    private AtomicReference<Application.ActivityLifecycleCallbacks> debugActivityLifecycleListener;
    private InfoProvider<DisplayInfo> displayInfoProvider;
    private VitalMonitor frameRateVitalMonitor;
    private Application.ActivityLifecycleCallbacks frameStatesAggregator;
    private final Handler handler;
    private final HeatmapIdentifierRegistry heatmapIdentifierRegistry;
    private InitialResourceIdentifier initialResourceIdentifier;
    private final AtomicBoolean initialized;
    private InsightsCollector insightsCollector;
    private LastInteractionIdentifier lastInteractionIdentifier;

    /* JADX INFO: renamed from: lateCrashEventHandler$delegate, reason: from kotlin metadata */
    private final Lazy lateCrashEventHandler;
    private final Function1<InternalSdkCore, LateCrashReporter> lateCrashReporterFactory;
    private TrackingStrategy longTaskTrackingStrategy;
    private VitalMonitor memoryVitalMonitor;
    private final String name;

    /* JADX INFO: renamed from: requestFactory$delegate, reason: from kotlin metadata */
    private final Lazy requestFactory;
    private RumAppStartupDetector rumAppStartupDetector;
    private final Set<FeatureContextUpdateReceiver> rumContextUpdateReceivers;
    private float sampleRate;
    private final FeatureSdkCore sdkCore;
    private RumSessionListener sessionListener;
    private SlowFramesListener slowFramesListener;
    private final FeatureStorageConfiguration storageConfiguration;
    private float telemetryConfigurationSampleRate;
    private float telemetrySampleRate;
    private TimeseriesCollector.Factory timeseriesCollectorFactory;
    private boolean trackFrustrations;
    private ViewTrackingStrategy viewTrackingStrategy;
    private ScheduledExecutorService vitalExecutorService;

    /* JADX WARN: Multi-variable type inference failed */
    public RumFeature(FeatureSdkCore sdkCore, String applicationId, Configuration configuration, Function1<? super InternalSdkCore, ? extends LateCrashReporter> lateCrashReporterFactory, BuildSdkVersionProvider buildSdkVersionProvider, Handler handler) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(lateCrashReporterFactory, "lateCrashReporterFactory");
        Intrinsics.checkNotNullParameter(buildSdkVersionProvider, "buildSdkVersionProvider");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.sdkCore = sdkCore;
        this.applicationId = applicationId;
        this.configuration = configuration;
        this.lateCrashReporterFactory = lateCrashReporterFactory;
        this.buildSdkVersionProvider = buildSdkVersionProvider;
        this.handler = handler;
        this.dataWriter = new NoOpDataWriter();
        this.initialized = new AtomicBoolean(false);
        this.viewTrackingStrategy = new NoOpViewTrackingStrategy();
        this.actionTrackingStrategy = new NoOpUserActionTrackingStrategy();
        this.longTaskTrackingStrategy = new NoOpTrackingStrategy();
        this.cpuVitalMonitor = new NoOpVitalMonitor();
        this.memoryVitalMonitor = new NoOpVitalMonitor();
        this.frameRateVitalMonitor = new NoOpVitalMonitor();
        this.debugActivityLifecycleListener = new AtomicReference<>(null);
        this.sessionListener = new NoOpRumSessionListener();
        this.vitalExecutorService = new NoOpScheduledExecutorService();
        this.initialResourceIdentifier = new NoOpInitialResourceIdentifier();
        this.lastInteractionIdentifier = new NoOpLastInteractionIdentifier();
        this.accessibilityReader = new NoOpAccessibilityReader();
        this.accessibilitySnapshotManager = new NoOpAccessibilitySnapshotManager();
        this.batteryInfoProvider = new NoOpBatteryInfoProvider();
        this.displayInfoProvider = new NoOpDisplayInfoProvider();
        this.rumContextUpdateReceivers = new LinkedHashSet();
        this.insightsCollector = new NoOpInsightsCollector();
        this.heatmapIdentifierRegistry = HeatmapIdentifierRegistry.INSTANCE.create();
        this.timeseriesCollectorFactory = new NoOpTimeseriesCollectorFactory();
        this.lateCrashEventHandler = LazyKt.lazy(new Function0<LateCrashReporter>() { // from class: com.datadog.android.rum.internal.RumFeature$lateCrashEventHandler$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LateCrashReporter invoke() {
                Function1 function1 = this.this$0.lateCrashReporterFactory;
                FeatureSdkCore featureSdkCore = this.this$0.sdkCore;
                Intrinsics.checkNotNull(featureSdkCore, "null cannot be cast to non-null type com.datadog.android.core.InternalSdkCore");
                return (LateCrashReporter) function1.invoke((InternalSdkCore) featureSdkCore);
            }
        });
        this.name = "rum";
        this.requestFactory = LazyKt.lazy(new Function0<RumRequestFactory>() { // from class: com.datadog.android.rum.internal.RumFeature$requestFactory$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RumRequestFactory invoke() {
                return new RumRequestFactory(this.this$0.getConfiguration().getCustomEndpointUrl(), new RumViewEventFilter(new RumEventMetaDeserializer(this.this$0.sdkCore.getInternalLogger())), this.this$0.sdkCore.getInternalLogger());
            }
        });
        this.storageConfiguration = FeatureStorageConfiguration.copy$default(FeatureStorageConfiguration.INSTANCE.getDEFAULT(), 0L, 0, 0L, RUM_TTL_24H, 7, null);
    }

    /* JADX INFO: renamed from: getApplicationId$dd_sdk_android_rum_release, reason: from getter */
    public final String getApplicationId() {
        return this.applicationId;
    }

    /* JADX INFO: renamed from: getConfiguration$dd_sdk_android_rum_release, reason: from getter */
    public final Configuration getConfiguration() {
        return this.configuration;
    }

    public /* synthetic */ RumFeature(FeatureSdkCore featureSdkCore, String str, Configuration configuration, AnonymousClass1 anonymousClass1, BuildSdkVersionProvider buildSdkVersionProvider, Handler handler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(featureSdkCore, str, configuration, (i & 8) != 0 ? new Function1<InternalSdkCore, DatadogLateCrashReporter>() { // from class: com.datadog.android.rum.internal.RumFeature.1
            @Override // kotlin.jvm.functions.Function1
            public final DatadogLateCrashReporter invoke(InternalSdkCore it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new DatadogLateCrashReporter(it, null, null, 6, null);
            }
        } : anonymousClass1, (i & 16) != 0 ? BuildSdkVersionProvider.INSTANCE.getDEFAULT() : buildSdkVersionProvider, (i & 32) != 0 ? new Handler(Looper.getMainLooper()) : handler);
    }

    public final DataWriter<Object> getDataWriter$dd_sdk_android_rum_release() {
        return this.dataWriter;
    }

    public final void setDataWriter$dd_sdk_android_rum_release(DataWriter<Object> dataWriter) {
        Intrinsics.checkNotNullParameter(dataWriter, "<set-?>");
        this.dataWriter = dataWriter;
    }

    /* JADX INFO: renamed from: getInitialized$dd_sdk_android_rum_release, reason: from getter */
    public final AtomicBoolean getInitialized() {
        return this.initialized;
    }

    /* JADX INFO: renamed from: getSampleRate$dd_sdk_android_rum_release, reason: from getter */
    public final float getSampleRate() {
        return this.sampleRate;
    }

    public final void setSampleRate$dd_sdk_android_rum_release(float f) {
        this.sampleRate = f;
    }

    /* JADX INFO: renamed from: getTelemetrySampleRate$dd_sdk_android_rum_release, reason: from getter */
    public final float getTelemetrySampleRate() {
        return this.telemetrySampleRate;
    }

    public final void setTelemetrySampleRate$dd_sdk_android_rum_release(float f) {
        this.telemetrySampleRate = f;
    }

    /* JADX INFO: renamed from: getTelemetryConfigurationSampleRate$dd_sdk_android_rum_release, reason: from getter */
    public final float getTelemetryConfigurationSampleRate() {
        return this.telemetryConfigurationSampleRate;
    }

    public final void setTelemetryConfigurationSampleRate$dd_sdk_android_rum_release(float f) {
        this.telemetryConfigurationSampleRate = f;
    }

    /* JADX INFO: renamed from: getBackgroundEventTracking$dd_sdk_android_rum_release, reason: from getter */
    public final boolean getBackgroundEventTracking() {
        return this.backgroundEventTracking;
    }

    public final void setBackgroundEventTracking$dd_sdk_android_rum_release(boolean z) {
        this.backgroundEventTracking = z;
    }

    /* JADX INFO: renamed from: getTrackFrustrations$dd_sdk_android_rum_release, reason: from getter */
    public final boolean getTrackFrustrations() {
        return this.trackFrustrations;
    }

    public final void setTrackFrustrations$dd_sdk_android_rum_release(boolean z) {
        this.trackFrustrations = z;
    }

    /* JADX INFO: renamed from: getViewTrackingStrategy$dd_sdk_android_rum_release, reason: from getter */
    public final ViewTrackingStrategy getViewTrackingStrategy() {
        return this.viewTrackingStrategy;
    }

    public final void setViewTrackingStrategy$dd_sdk_android_rum_release(ViewTrackingStrategy viewTrackingStrategy) {
        Intrinsics.checkNotNullParameter(viewTrackingStrategy, "<set-?>");
        this.viewTrackingStrategy = viewTrackingStrategy;
    }

    /* JADX INFO: renamed from: getActionTrackingStrategy$dd_sdk_android_rum_release, reason: from getter */
    public final UserActionTrackingStrategy getActionTrackingStrategy() {
        return this.actionTrackingStrategy;
    }

    public final void setActionTrackingStrategy$dd_sdk_android_rum_release(UserActionTrackingStrategy userActionTrackingStrategy) {
        Intrinsics.checkNotNullParameter(userActionTrackingStrategy, "<set-?>");
        this.actionTrackingStrategy = userActionTrackingStrategy;
    }

    /* JADX INFO: renamed from: getLongTaskTrackingStrategy$dd_sdk_android_rum_release, reason: from getter */
    public final TrackingStrategy getLongTaskTrackingStrategy() {
        return this.longTaskTrackingStrategy;
    }

    public final void setLongTaskTrackingStrategy$dd_sdk_android_rum_release(TrackingStrategy trackingStrategy) {
        Intrinsics.checkNotNullParameter(trackingStrategy, "<set-?>");
        this.longTaskTrackingStrategy = trackingStrategy;
    }

    /* JADX INFO: renamed from: getCpuVitalMonitor$dd_sdk_android_rum_release, reason: from getter */
    public final VitalMonitor getCpuVitalMonitor() {
        return this.cpuVitalMonitor;
    }

    public final void setCpuVitalMonitor$dd_sdk_android_rum_release(VitalMonitor vitalMonitor) {
        Intrinsics.checkNotNullParameter(vitalMonitor, "<set-?>");
        this.cpuVitalMonitor = vitalMonitor;
    }

    /* JADX INFO: renamed from: getMemoryVitalMonitor$dd_sdk_android_rum_release, reason: from getter */
    public final VitalMonitor getMemoryVitalMonitor() {
        return this.memoryVitalMonitor;
    }

    public final void setMemoryVitalMonitor$dd_sdk_android_rum_release(VitalMonitor vitalMonitor) {
        Intrinsics.checkNotNullParameter(vitalMonitor, "<set-?>");
        this.memoryVitalMonitor = vitalMonitor;
    }

    /* JADX INFO: renamed from: getFrameRateVitalMonitor$dd_sdk_android_rum_release, reason: from getter */
    public final VitalMonitor getFrameRateVitalMonitor() {
        return this.frameRateVitalMonitor;
    }

    public final void setFrameRateVitalMonitor$dd_sdk_android_rum_release(VitalMonitor vitalMonitor) {
        Intrinsics.checkNotNullParameter(vitalMonitor, "<set-?>");
        this.frameRateVitalMonitor = vitalMonitor;
    }

    public final AtomicReference<Application.ActivityLifecycleCallbacks> getDebugActivityLifecycleListener$dd_sdk_android_rum_release() {
        return this.debugActivityLifecycleListener;
    }

    public final void setDebugActivityLifecycleListener$dd_sdk_android_rum_release(AtomicReference<Application.ActivityLifecycleCallbacks> atomicReference) {
        Intrinsics.checkNotNullParameter(atomicReference, "<set-?>");
        this.debugActivityLifecycleListener = atomicReference;
    }

    /* JADX INFO: renamed from: getFrameStatesAggregator$dd_sdk_android_rum_release, reason: from getter */
    public final Application.ActivityLifecycleCallbacks getFrameStatesAggregator() {
        return this.frameStatesAggregator;
    }

    public final void setFrameStatesAggregator$dd_sdk_android_rum_release(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.frameStatesAggregator = activityLifecycleCallbacks;
    }

    /* JADX INFO: renamed from: getSessionListener$dd_sdk_android_rum_release, reason: from getter */
    public final RumSessionListener getSessionListener() {
        return this.sessionListener;
    }

    public final void setSessionListener$dd_sdk_android_rum_release(RumSessionListener rumSessionListener) {
        Intrinsics.checkNotNullParameter(rumSessionListener, "<set-?>");
        this.sessionListener = rumSessionListener;
    }

    /* JADX INFO: renamed from: getVitalExecutorService$dd_sdk_android_rum_release, reason: from getter */
    public final ScheduledExecutorService getVitalExecutorService() {
        return this.vitalExecutorService;
    }

    public final void setVitalExecutorService$dd_sdk_android_rum_release(ScheduledExecutorService scheduledExecutorService) {
        Intrinsics.checkNotNullParameter(scheduledExecutorService, "<set-?>");
        this.vitalExecutorService = scheduledExecutorService;
    }

    /* JADX INFO: renamed from: getAnrDetectorRunnable$dd_sdk_android_rum_release, reason: from getter */
    public final ANRDetectorRunnable getAnrDetectorRunnable() {
        return this.anrDetectorRunnable;
    }

    public final void setAnrDetectorRunnable$dd_sdk_android_rum_release(ANRDetectorRunnable aNRDetectorRunnable) {
        this.anrDetectorRunnable = aNRDetectorRunnable;
    }

    public final Context getAppContext$dd_sdk_android_rum_release() {
        Context context = this.appContext;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("appContext");
        return null;
    }

    public final void setAppContext$dd_sdk_android_rum_release(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.appContext = context;
    }

    /* JADX INFO: renamed from: getInitialResourceIdentifier$dd_sdk_android_rum_release, reason: from getter */
    public final InitialResourceIdentifier getInitialResourceIdentifier() {
        return this.initialResourceIdentifier;
    }

    public final void setInitialResourceIdentifier$dd_sdk_android_rum_release(InitialResourceIdentifier initialResourceIdentifier) {
        Intrinsics.checkNotNullParameter(initialResourceIdentifier, "<set-?>");
        this.initialResourceIdentifier = initialResourceIdentifier;
    }

    /* JADX INFO: renamed from: getLastInteractionIdentifier$dd_sdk_android_rum_release, reason: from getter */
    public final LastInteractionIdentifier getLastInteractionIdentifier() {
        return this.lastInteractionIdentifier;
    }

    public final void setLastInteractionIdentifier$dd_sdk_android_rum_release(LastInteractionIdentifier lastInteractionIdentifier) {
        this.lastInteractionIdentifier = lastInteractionIdentifier;
    }

    /* JADX INFO: renamed from: getSlowFramesListener$dd_sdk_android_rum_release, reason: from getter */
    public final SlowFramesListener getSlowFramesListener() {
        return this.slowFramesListener;
    }

    public final void setSlowFramesListener$dd_sdk_android_rum_release(SlowFramesListener slowFramesListener) {
        this.slowFramesListener = slowFramesListener;
    }

    public final InfoProvider<AccessibilityInfo> getAccessibilityReader$dd_sdk_android_rum_release() {
        return this.accessibilityReader;
    }

    public final void setAccessibilityReader$dd_sdk_android_rum_release(InfoProvider<AccessibilityInfo> infoProvider) {
        Intrinsics.checkNotNullParameter(infoProvider, "<set-?>");
        this.accessibilityReader = infoProvider;
    }

    /* JADX INFO: renamed from: getAccessibilitySnapshotManager$dd_sdk_android_rum_release, reason: from getter */
    public final AccessibilitySnapshotManager getAccessibilitySnapshotManager() {
        return this.accessibilitySnapshotManager;
    }

    public final void setAccessibilitySnapshotManager$dd_sdk_android_rum_release(AccessibilitySnapshotManager accessibilitySnapshotManager) {
        Intrinsics.checkNotNullParameter(accessibilitySnapshotManager, "<set-?>");
        this.accessibilitySnapshotManager = accessibilitySnapshotManager;
    }

    public final InfoProvider<BatteryInfo> getBatteryInfoProvider$dd_sdk_android_rum_release() {
        return this.batteryInfoProvider;
    }

    public final void setBatteryInfoProvider$dd_sdk_android_rum_release(InfoProvider<BatteryInfo> infoProvider) {
        Intrinsics.checkNotNullParameter(infoProvider, "<set-?>");
        this.batteryInfoProvider = infoProvider;
    }

    public final InfoProvider<DisplayInfo> getDisplayInfoProvider$dd_sdk_android_rum_release() {
        return this.displayInfoProvider;
    }

    public final void setDisplayInfoProvider$dd_sdk_android_rum_release(InfoProvider<DisplayInfo> infoProvider) {
        Intrinsics.checkNotNullParameter(infoProvider, "<set-?>");
        this.displayInfoProvider = infoProvider;
    }

    public final Set<FeatureContextUpdateReceiver> getRumContextUpdateReceivers$dd_sdk_android_rum_release() {
        return this.rumContextUpdateReceivers;
    }

    /* JADX INFO: renamed from: getInsightsCollector$dd_sdk_android_rum_release, reason: from getter */
    public final InsightsCollector getInsightsCollector() {
        return this.insightsCollector;
    }

    public final void setInsightsCollector$dd_sdk_android_rum_release(InsightsCollector insightsCollector) {
        Intrinsics.checkNotNullParameter(insightsCollector, "<set-?>");
        this.insightsCollector = insightsCollector;
    }

    @Override // com.datadog.android.heatmaps.HeatmapIdentifierRegistryProvider
    public HeatmapIdentifierRegistry getHeatmapIdentifierRegistry() {
        return this.heatmapIdentifierRegistry;
    }

    /* JADX INFO: renamed from: getTimeseriesCollectorFactory$dd_sdk_android_rum_release, reason: from getter */
    public final TimeseriesCollector.Factory getTimeseriesCollectorFactory() {
        return this.timeseriesCollectorFactory;
    }

    public final void setTimeseriesCollectorFactory$dd_sdk_android_rum_release(TimeseriesCollector.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "<set-?>");
        this.timeseriesCollectorFactory = factory;
    }

    private final LateCrashReporter getLateCrashEventHandler() {
        return (LateCrashReporter) this.lateCrashEventHandler.getValue();
    }

    /* JADX INFO: renamed from: getRumAppStartupDetector$dd_sdk_android_rum_release, reason: from getter */
    public final RumAppStartupDetector getRumAppStartupDetector() {
        return this.rumAppStartupDetector;
    }

    public final void setRumAppStartupDetector$dd_sdk_android_rum_release(RumAppStartupDetector rumAppStartupDetector) {
        this.rumAppStartupDetector = rumAppStartupDetector;
    }

    @Override // com.datadog.android.api.feature.Feature
    public String getName() {
        return this.name;
    }

    @Override // com.datadog.android.api.feature.Feature
    public void onInitialize(Context appContext) {
        float sampleRate;
        NoOpUserActionTrackingStrategy noOpUserActionTrackingStrategy;
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        setAppContext$dd_sdk_android_rum_release(appContext);
        if (this.configuration.getCollectAccessibility()) {
            this.accessibilityReader = new DefaultAccessibilityReader(this.sdkCore.getInternalLogger(), appContext, this.sdkCore.getTimeProvider(), null, null, null, null, null, null, 504, null);
            this.accessibilitySnapshotManager = new DefaultAccessibilitySnapshotManager(this.accessibilityReader);
        }
        this.initialResourceIdentifier = this.configuration.getInitialResourceIdentifier();
        this.lastInteractionIdentifier = this.configuration.getLastInteractionIdentifier();
        InsightsCollector insightsCollector = this.configuration.getInsightsCollector();
        this.insightsCollector = insightsCollector;
        insightsCollector.bindSdkCore(this.sdkCore);
        Configuration configuration = this.configuration;
        FeatureSdkCore featureSdkCore = this.sdkCore;
        Intrinsics.checkNotNull(featureSdkCore, "null cannot be cast to non-null type com.datadog.android.core.InternalSdkCore");
        this.dataWriter = createDataWriter(configuration, (InternalSdkCore) featureSdkCore);
        if (((InternalSdkCore) this.sdkCore).getIsDeveloperModeEnabled()) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.INFO, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.RumFeature.onInitialize.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return RumFeature.DEVELOPER_MODE_SAMPLE_RATE_CHANGED_MESSAGE;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            sampleRate = 100.0f;
        } else {
            sampleRate = this.configuration.getSampleRate();
        }
        this.sampleRate = sampleRate;
        this.telemetrySampleRate = this.configuration.getTelemetrySampleRate();
        this.telemetryConfigurationSampleRate = this.configuration.getTelemetryConfigurationSampleRate();
        this.backgroundEventTracking = this.configuration.getBackgroundEventTracking();
        this.trackFrustrations = this.configuration.getTrackFrustrations();
        this.batteryInfoProvider = new DefaultBatteryInfoProvider(appContext, this.sdkCore.getTimeProvider(), null, null, 0, this.sdkCore.getInternalLogger(), 28, null);
        this.displayInfoProvider = new DefaultDisplayInfoProvider(appContext, this.sdkCore.getInternalLogger(), null, null, null, 28, null);
        ViewTrackingStrategy viewTrackingStrategy = this.configuration.getViewTrackingStrategy();
        if (viewTrackingStrategy != null) {
            this.viewTrackingStrategy = viewTrackingStrategy;
        }
        if (!this.configuration.getUserActionTracking()) {
            noOpUserActionTrackingStrategy = new NoOpUserActionTrackingStrategy();
        } else {
            noOpUserActionTrackingStrategy = INSTANCE.provideUserTrackingStrategy((ViewAttributesProvider[]) this.configuration.getTouchTargetExtraAttributesProviders().toArray(new ViewAttributesProvider[0]), this.configuration.getInteractionPredicate(), this.configuration.getComposeActionTrackingStrategy(), this.buildSdkVersionProvider, this.sdkCore.getInternalLogger());
        }
        this.actionTrackingStrategy = noOpUserActionTrackingStrategy;
        TrackingStrategy longTaskTrackingStrategy = this.configuration.getLongTaskTrackingStrategy();
        if (longTaskTrackingStrategy != null) {
            this.longTaskTrackingStrategy = longTaskTrackingStrategy;
        }
        VitalsUpdateFrequency vitalsMonitorUpdateFrequency = this.configuration.getVitalsMonitorUpdateFrequency();
        boolean z = vitalsMonitorUpdateFrequency != VitalsUpdateFrequency.NEVER;
        if (z || this.configuration.getTimeseriesConfiguration() != null) {
            initializeVitalExecutorService();
        }
        if (z) {
            initializeCpuVitalMonitor(vitalsMonitorUpdateFrequency);
            initializeMemoryVitalMonitor(vitalsMonitorUpdateFrequency);
        }
        FPSVitalListener fPSVitalListenerInitializeFPSVitalMonitor = initializeFPSVitalMonitor(vitalsMonitorUpdateFrequency);
        FrameStateListener frameStateListenerInitializeSlowFrameListener = initializeSlowFrameListener(this.configuration.getSlowFramesConfiguration());
        if (fPSVitalListenerInitializeFPSVitalMonitor != null || frameStateListenerInitializeSlowFrameListener != null) {
            Application application = appContext instanceof Application ? (Application) appContext : null;
            if (application != null) {
                initializeFrameStatesAggregator(application, CollectionsKt.listOfNotNull((Object[]) new FrameStateListener[]{frameStateListenerInitializeSlowFrameListener, fPSVitalListenerInitializeFPSVitalMonitor}));
            }
        }
        if (this.configuration.getTrackNonFatalAnrs()) {
            initializeANRDetector();
        }
        registerTrackingStrategies(appContext);
        this.sessionListener = this.configuration.getSessionListener();
        TimeseriesConfiguration timeseriesConfiguration = this.configuration.getTimeseriesConfiguration();
        if (timeseriesConfiguration != null) {
            FeatureSdkCore featureSdkCore2 = this.sdkCore;
            DataWriter<Object> dataWriter = this.dataWriter;
            InsightsCollector insightsCollector2 = this.insightsCollector;
            ScheduledExecutorService scheduledExecutorService = this.vitalExecutorService;
            Long totalRamBytes$dd_sdk_android_rum_release = INSTANCE.readTotalRamBytes$dd_sdk_android_rum_release(appContext, featureSdkCore2.getInternalLogger());
            this.timeseriesCollectorFactory = new DefaultTimeseriesCollectorFactory(featureSdkCore2, timeseriesConfiguration, scheduledExecutorService, insightsCollector2, totalRamBytes$dd_sdk_android_rum_release != null ? totalRamBytes$dd_sdk_android_rum_release.longValue() : 0L, dataWriter, this.batteryInfoProvider, this.displayInfoProvider);
        }
        initRumAppStartupDetector();
        this.sdkCore.setEventReceiver(getName(), this);
        this.initialized.set(true);
    }

    private final void initializeFrameStatesAggregator(Application application, List<? extends FrameStateListener> list) {
        FrameStatesAggregator frameStatesAggregator = new FrameStatesAggregator(list, this.sdkCore.getInternalLogger(), null, null, 12, null);
        this.frameStatesAggregator = frameStatesAggregator;
        application.registerActivityLifecycleCallbacks(frameStatesAggregator);
    }

    private final FrameStateListener initializeSlowFrameListener(SlowFramesConfiguration slowFramesConfiguration) {
        DefaultSlowFramesListener defaultSlowFramesListener;
        if (slowFramesConfiguration != null && !this.configuration.getDisableJankStats()) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.INFO, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.RumFeature.initializeSlowFrameListener.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return RumFeature.SLOW_FRAMES_MONITORING_ENABLED_MESSAGE;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            defaultSlowFramesListener = new DefaultSlowFramesListener(slowFramesConfiguration, new DefaultUISlownessMetricDispatcher(slowFramesConfiguration, this.sdkCore.getInternalLogger(), 0.0f, 4, null), this.insightsCollector, this.sdkCore.getTimeProvider());
        } else {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.INFO, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.RumFeature.initializeSlowFrameListener.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return RumFeature.SLOW_FRAMES_MONITORING_DISABLED_MESSAGE;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            defaultSlowFramesListener = null;
        }
        this.slowFramesListener = defaultSlowFramesListener;
        return defaultSlowFramesListener;
    }

    @Override // com.datadog.android.api.feature.StorageBackedFeature
    public RequestFactory getRequestFactory() {
        return (RequestFactory) this.requestFactory.getValue();
    }

    @Override // com.datadog.android.api.feature.StorageBackedFeature
    public FeatureStorageConfiguration getStorageConfiguration() {
        return this.storageConfiguration;
    }

    @Override // com.datadog.android.api.feature.Feature
    public void onStop() {
        this.sdkCore.removeEventReceiver(getName());
        Iterator<T> it = this.rumContextUpdateReceivers.iterator();
        while (it.hasNext()) {
            this.sdkCore.removeContextUpdateReceiver((FeatureContextUpdateReceiver) it.next());
        }
        this.rumContextUpdateReceivers.clear();
        this.insightsCollector.unbindSdkCore(this.sdkCore);
        unregisterTrackingStrategies(getAppContext$dd_sdk_android_rum_release());
        this.timeseriesCollectorFactory = new NoOpTimeseriesCollectorFactory();
        RumMonitor rumMonitor = GlobalRumMonitor.get(this.sdkCore);
        DatadogRumMonitor datadogRumMonitor = rumMonitor instanceof DatadogRumMonitor ? (DatadogRumMonitor) rumMonitor : null;
        if (datadogRumMonitor != null) {
            datadogRumMonitor.stopTimeseries$dd_sdk_android_rum_release();
        }
        this.dataWriter = new NoOpDataWriter();
        this.viewTrackingStrategy = new NoOpViewTrackingStrategy();
        this.actionTrackingStrategy = new NoOpUserActionTrackingStrategy();
        this.longTaskTrackingStrategy = new NoOpTrackingStrategy();
        this.cpuVitalMonitor = new NoOpVitalMonitor();
        this.memoryVitalMonitor = new NoOpVitalMonitor();
        this.frameRateVitalMonitor = new NoOpVitalMonitor();
        this.vitalExecutorService.shutdownNow();
        ExecutorService executorService = this.anrDetectorExecutorService;
        if (executorService != null) {
            executorService.shutdownNow();
        }
        ANRDetectorRunnable aNRDetectorRunnable = this.anrDetectorRunnable;
        if (aNRDetectorRunnable != null) {
            aNRDetectorRunnable.stop();
        }
        this.vitalExecutorService = new NoOpScheduledExecutorService();
        this.sessionListener = new NoOpRumSessionListener();
        cleanupInfoProviders();
        final RumAppStartupDetector rumAppStartupDetector = this.rumAppStartupDetector;
        if (!ThreadUtilsKt.isMainThread()) {
            this.handler.post(new Runnable() { // from class: com.datadog.android.rum.internal.RumFeature$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    RumFeature.onStop$lambda$4(rumAppStartupDetector);
                }
            });
        } else if (rumAppStartupDetector != null) {
            rumAppStartupDetector.destroy();
        }
        this.rumAppStartupDetector = null;
        GlobalRumMonitor.INSTANCE.unregister$dd_sdk_android_rum_release(this.sdkCore);
        this.initialized.set(false);
    }

    static final void onStop$lambda$4(RumAppStartupDetector rumAppStartupDetector) {
        if (rumAppStartupDetector != null) {
            rumAppStartupDetector.destroy();
        }
    }

    private final void cleanupInfoProviders() {
        if (this.configuration.getCollectAccessibility()) {
            this.accessibilityReader.cleanup();
            this.accessibilityReader = new NoOpAccessibilityReader();
            this.accessibilitySnapshotManager = new NoOpAccessibilitySnapshotManager();
        }
        this.batteryInfoProvider.cleanup();
        this.batteryInfoProvider = new NoOpBatteryInfoProvider();
        this.displayInfoProvider.cleanup();
        this.displayInfoProvider = new NoOpDisplayInfoProvider();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final DataWriter<Object> createDataWriter(Configuration configuration, InternalSdkCore sdkCore) {
        return new RumDataWriter(new MapperSerializer(new RumEventMapper(configuration.getViewEventMapper(), configuration.getErrorEventMapper(), configuration.getResourceEventMapper(), configuration.getActionEventMapper(), configuration.getLongTaskEventMapper(), configuration.getVitalOperationStepEventMapper(), configuration.getVitalAppLaunchEventMapper(), configuration.getTelemetryConfigurationMapper(), sdkCore.getInternalLogger()), new RumEventSerializer(sdkCore.getInternalLogger(), null, 2, 0 == true ? 1 : 0)), new RumEventMetaSerializer(), sdkCore);
    }

    @Override // com.datadog.android.api.feature.FeatureEventReceiver
    public void onReceive(final Object event) throws InterruptedException {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof Map) {
            handleMapLikeEvent((Map) event);
            return;
        }
        if (event instanceof JvmCrash.Rum) {
            addJvmCrash((JvmCrash.Rum) event);
            return;
        }
        if (event instanceof InternalTelemetryEvent) {
            handleTelemetryEvent((InternalTelemetryEvent) event);
            return;
        }
        if (event instanceof RumFlagEvaluationMessage) {
            handleFlagEvaluationEvent((RumFlagEvaluationMessage) event);
        } else if (event instanceof ProfilingAnrDetectedEvent) {
            handleProfilingAnrDetectedEvent((ProfilingAnrDetectedEvent) event);
        } else {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.RumFeature.onReceive.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, RumFeature.UNSUPPORTED_EVENT_TYPE, Arrays.copyOf(new Object[]{event.getClass().getCanonicalName()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
    }

    private final void handleFlagEvaluationEvent(RumFlagEvaluationMessage event) {
        RumMonitor rumMonitor = GlobalRumMonitor.get(this.sdkCore);
        AdvancedRumMonitor advancedRumMonitor = rumMonitor instanceof AdvancedRumMonitor ? (AdvancedRumMonitor) rumMonitor : null;
        if (advancedRumMonitor != null) {
            advancedRumMonitor.addFeatureFlagEvaluation(event.getFlagKey(), event.getValue());
        }
    }

    private final void handleProfilingAnrDetectedEvent(ProfilingAnrDetectedEvent event) {
        ANRException aNRException = new ANRException((StackTraceElement[]) event.getAnrThreadStack().toArray(new StackTraceElement[0]));
        List listListOf = CollectionsKt.listOf(new ThreadDump(event.getAnrThreadName(), ThreadExtKt.asString(event.getAnrThreadState()), ThrowableExtKt.loggableStackTrace(aNRException), false));
        List<ProfilingThreadDump> allThreads = event.getAllThreads();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(allThreads, 10));
        Iterator<T> it = allThreads.iterator();
        while (it.hasNext()) {
            arrayList.add(toThreadDump((ProfilingThreadDump) it.next()));
        }
        GlobalRumMonitor.get(this.sdkCore).addError(ANRDetectorRunnable.ANR_MESSAGE, RumErrorSource.SOURCE, aNRException, MapsKt.mapOf(TuplesKt.to(RumAttributes.INTERNAL_TIMESTAMP, Long.valueOf(event.getDetectedAtMs())), TuplesKt.to(RumAttributes.INTERNAL_ALL_THREADS, CollectionsKt.plus((Collection) listListOf, (Iterable) arrayList))));
    }

    private final ThreadDump toThreadDump(ProfilingThreadDump profilingThreadDump) {
        return new ThreadDump(profilingThreadDump.getName(), ThreadExtKt.asString(profilingThreadDump.getState()), profilingThreadDump.getStack(), false);
    }

    private final void handleMapLikeEvent(final Map<?, ?> event) throws InterruptedException {
        Object obj = event.get("type");
        if (Intrinsics.areEqual(obj, NDK_CRASH_BUS_MESSAGE_TYPE)) {
            getLateCrashEventHandler().handleNdkCrashEvent(event, this.dataWriter);
            return;
        }
        if (Intrinsics.areEqual(obj, LOGGER_ERROR_BUS_MESSAGE_TYPE)) {
            addLoggerError(event);
            return;
        }
        if (Intrinsics.areEqual(obj, LOGGER_ERROR_WITH_STACK_TRACE_MESSAGE_TYPE)) {
            addLoggerErrorWithStacktrace(event);
            return;
        }
        if (Intrinsics.areEqual(obj, WEB_VIEW_INGESTED_NOTIFICATION_MESSAGE_TYPE)) {
            RumMonitor rumMonitor = GlobalRumMonitor.get(this.sdkCore);
            AdvancedRumMonitor advancedRumMonitor = rumMonitor instanceof AdvancedRumMonitor ? (AdvancedRumMonitor) rumMonitor : null;
            if (advancedRumMonitor != null) {
                advancedRumMonitor.sendWebViewEvent();
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(obj, TELEMETRY_SESSION_REPLAY_SKIP_FRAME)) {
            addSessionReplaySkippedFrame();
            return;
        }
        boolean zAreEqual = Intrinsics.areEqual(obj, FLUSH_AND_STOP_MONITOR_MESSAGE_TYPE);
        FeatureSdkCore featureSdkCore = this.sdkCore;
        if (zAreEqual) {
            RumMonitor rumMonitor2 = GlobalRumMonitor.get(featureSdkCore);
            DatadogRumMonitor datadogRumMonitor = rumMonitor2 instanceof DatadogRumMonitor ? (DatadogRumMonitor) rumMonitor2 : null;
            if (datadogRumMonitor != null) {
                datadogRumMonitor.drainExecutorService$dd_sdk_android_rum_release();
                return;
            }
            return;
        }
        InternalLogger.DefaultImpls.log$default(featureSdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.RumFeature.handleMapLikeEvent.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str = String.format(Locale.US, RumFeature.UNKNOWN_EVENT_TYPE_PROPERTY_VALUE, Arrays.copyOf(new Object[]{event.get("type")}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return str;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
    }

    private final void handleTelemetryEvent(InternalTelemetryEvent event) {
        RumMonitor rumMonitor = GlobalRumMonitor.get(this.sdkCore);
        AdvancedRumMonitor advancedRumMonitor = rumMonitor instanceof AdvancedRumMonitor ? (AdvancedRumMonitor) rumMonitor : null;
        if (advancedRumMonitor == null) {
            return;
        }
        advancedRumMonitor.sendTelemetryEvent(event);
    }

    public final void enableDebugging$dd_sdk_android_rum_release(AdvancedRumMonitor advancedRumMonitor) {
        Intrinsics.checkNotNullParameter(advancedRumMonitor, "advancedRumMonitor");
        if (!this.initialized.get()) {
            InternalLogger.DefaultImpls.log$default(InternalLogger.INSTANCE.getUNBOUND(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.RumFeature$enableDebugging$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "RUM feature is not initialized yet, you need to register it with a SDK instance by calling SdkCore#registerFeature method. Cannot enable RUM debugging.";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return;
        }
        Context appContext$dd_sdk_android_rum_release = getAppContext$dd_sdk_android_rum_release();
        synchronized (this.debugActivityLifecycleListener) {
            if ((appContext$dd_sdk_android_rum_release instanceof Application) && this.debugActivityLifecycleListener.get() == null) {
                UiRumDebugListener uiRumDebugListener = new UiRumDebugListener(this.sdkCore, advancedRumMonitor);
                this.debugActivityLifecycleListener.set(uiRumDebugListener);
                ((Application) appContext$dd_sdk_android_rum_release).registerActivityLifecycleCallbacks(uiRumDebugListener);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void disableDebugging$dd_sdk_android_rum_release() {
        Context appContext$dd_sdk_android_rum_release = getAppContext$dd_sdk_android_rum_release();
        synchronized (this.debugActivityLifecycleListener) {
            if (this.debugActivityLifecycleListener.get() != null && (appContext$dd_sdk_android_rum_release instanceof Application)) {
                ((Application) appContext$dd_sdk_android_rum_release).unregisterActivityLifecycleCallbacks(this.debugActivityLifecycleListener.get());
                this.debugActivityLifecycleListener.set(null);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void consumeLastFatalAnr$dd_sdk_android_rum_release(ExecutorService rumEventsExecutorService) {
        Object next;
        Intrinsics.checkNotNullParameter(rumEventsExecutorService, "rumEventsExecutorService");
        Object systemService = getAppContext$dd_sdk_android_rum_release().getSystemService("activity");
        final ApplicationExitInfo applicationExitInfoM = null;
        if (!(systemService instanceof ActivityManager)) {
            systemService = null;
        }
        ActivityManager activityManager = (ActivityManager) systemService;
        if (activityManager != null) {
            try {
                List historicalProcessExitReasons = activityManager.getHistoricalProcessExitReasons(null, 0, 0);
                if (historicalProcessExitReasons != null) {
                    Iterator it = historicalProcessExitReasons.iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (BitmapUtils$$ExternalSyntheticApiModelOutline0.m(next).getReason() != 6);
                    applicationExitInfoM = BitmapUtils$$ExternalSyntheticApiModelOutline0.m(next);
                }
            } catch (RuntimeException e) {
                InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.RumFeature$consumeLastFatalAnr$lastKnownAnr$2
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return RumFeature.FAILED_TO_GET_HISTORICAL_EXIT_REASONS;
                    }
                }, (Throwable) e, false, (Map) null, 48, (Object) null);
            }
        }
        if (applicationExitInfoM == null) {
            return;
        }
        ConcurrencyExtKt.executeSafe(rumEventsExecutorService, "Send fatal ANR", this.sdkCore.getInternalLogger(), new Runnable() { // from class: com.datadog.android.rum.internal.RumFeature$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                RumFeature.consumeLastFatalAnr$lambda$9(this.f$0, applicationExitInfoM);
            }
        });
    }

    static final void consumeLastFatalAnr$lambda$9(RumFeature rumFeature, ApplicationExitInfo applicationExitInfo) {
        FeatureSdkCore featureSdkCore = rumFeature.sdkCore;
        Intrinsics.checkNotNull(featureSdkCore, "null cannot be cast to non-null type com.datadog.android.core.InternalSdkCore");
        JsonObject lastViewEvent = ((InternalSdkCore) featureSdkCore).getLastViewEvent();
        if (lastViewEvent != null) {
            rumFeature.getLateCrashEventHandler().handleAnrCrash(applicationExitInfo, lastViewEvent, rumFeature.dataWriter);
        } else {
            InternalLogger.DefaultImpls.log$default(rumFeature.sdkCore.getInternalLogger(), InternalLogger.Level.INFO, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.RumFeature$consumeLastFatalAnr$1$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return RumFeature.NO_LAST_RUM_VIEW_EVENT_AVAILABLE;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
    }

    public final void enableJankStatsTracking$dd_sdk_android_rum_release(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.frameStatesAggregator;
            if (activityLifecycleCallbacks != null) {
                activityLifecycleCallbacks.onActivityStarted(activity);
            }
        } catch (Exception e) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.TELEMETRY, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.RumFeature$enableJankStatsTracking$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return RumFeature.FAILED_TO_ENABLE_JANK_STATS_TRACKING_MANUALLY;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
        }
    }

    private final void registerTrackingStrategies(Context appContext) {
        this.actionTrackingStrategy.register(this.sdkCore, appContext);
        this.viewTrackingStrategy.register(this.sdkCore, appContext);
        this.longTaskTrackingStrategy.register(this.sdkCore, appContext);
    }

    private final void unregisterTrackingStrategies(Context appContext) {
        this.actionTrackingStrategy.unregister(appContext);
        this.viewTrackingStrategy.unregister(appContext);
        this.longTaskTrackingStrategy.unregister(appContext);
    }

    private final void initializeVitalExecutorService() {
        this.vitalExecutorService = this.sdkCore.createScheduledExecutorService("rum-vital");
    }

    private final void initializeCpuVitalMonitor(VitalsUpdateFrequency frequency) {
        if (frequency == VitalsUpdateFrequency.NEVER) {
            return;
        }
        this.cpuVitalMonitor = new AggregatingVitalMonitor();
        initializeVitalMonitor(new CPUVitalReader(new CpuStatReader(null, this.sdkCore.getInternalLogger(), 1, null)), this.cpuVitalMonitor, frequency.getPeriodInMs());
    }

    private final void initializeMemoryVitalMonitor(VitalsUpdateFrequency frequency) {
        if (frequency == VitalsUpdateFrequency.NEVER) {
            return;
        }
        this.memoryVitalMonitor = new AggregatingVitalMonitor();
        initializeVitalMonitor(new MemoryVitalReader(null, this.sdkCore.getInternalLogger(), 1, null), this.memoryVitalMonitor, frequency.getPeriodInMs());
    }

    private final FPSVitalListener initializeFPSVitalMonitor(VitalsUpdateFrequency frequency) {
        if (frequency == VitalsUpdateFrequency.NEVER || this.configuration.getDisableJankStats()) {
            return null;
        }
        this.frameRateVitalMonitor = new AggregatingVitalMonitor();
        return new FPSVitalListener(this.frameRateVitalMonitor, null, 0.0d, 6, null);
    }

    private final void initializeVitalMonitor(VitalReader vitalReader, VitalObserver vitalObserver, long periodInMs) {
        VitalReaderRunnable vitalReaderRunnable = new VitalReaderRunnable(this.sdkCore, vitalReader, vitalObserver, this.vitalExecutorService, periodInMs);
        vitalReaderRunnable.getSdkCore().setContextUpdateReceiver(vitalReaderRunnable);
        this.rumContextUpdateReceivers.add(vitalReaderRunnable);
        ConcurrencyExtKt.scheduleSafe(this.vitalExecutorService, "Vitals monitoring", periodInMs, TimeUnit.MILLISECONDS, this.sdkCore.getInternalLogger(), vitalReaderRunnable);
    }

    private final void initializeANRDetector() {
        ANRDetectorRunnable aNRDetectorRunnable = new ANRDetectorRunnable(this.sdkCore, new Handler(Looper.getMainLooper()), 0L, 0L, 12, null);
        ExecutorService executorServiceCreateSingleThreadExecutorService = this.sdkCore.createSingleThreadExecutorService("rum-anr-detection");
        this.anrDetectorExecutorService = executorServiceCreateSingleThreadExecutorService;
        if (executorServiceCreateSingleThreadExecutorService != null) {
            ConcurrencyExtKt.executeSafe(executorServiceCreateSingleThreadExecutorService, "ANR detection", this.sdkCore.getInternalLogger(), aNRDetectorRunnable);
        }
        this.anrDetectorRunnable = aNRDetectorRunnable;
    }

    private final void addJvmCrash(JvmCrash.Rum crashEvent) {
        RumMonitor rumMonitor = GlobalRumMonitor.get(this.sdkCore);
        AdvancedRumMonitor advancedRumMonitor = rumMonitor instanceof AdvancedRumMonitor ? (AdvancedRumMonitor) rumMonitor : null;
        if (advancedRumMonitor != null) {
            advancedRumMonitor.addCrash(crashEvent.getMessage(), RumErrorSource.SOURCE, crashEvent.getThrowable(), crashEvent.getThreads());
        }
    }

    private final void addLoggerError(Map<?, ?> loggerErrorEvent) {
        Object obj = loggerErrorEvent.get(EVENT_THROWABLE_PROPERTY);
        Throwable th = obj instanceof Throwable ? (Throwable) obj : null;
        Object obj2 = loggerErrorEvent.get("message");
        String str = obj2 instanceof String ? (String) obj2 : null;
        Object obj3 = loggerErrorEvent.get(EVENT_ATTRIBUTES_PROPERTY);
        Map<String, ? extends Object> mapEmptyMap = obj3 instanceof Map ? (Map) obj3 : null;
        FeatureSdkCore featureSdkCore = this.sdkCore;
        if (str == null) {
            InternalLogger.DefaultImpls.log$default(featureSdkCore.getInternalLogger(), InternalLogger.Level.WARN, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.RumFeature.addLoggerError.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return RumFeature.LOG_ERROR_EVENT_MISSING_MANDATORY_FIELDS;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return;
        }
        RumMonitor rumMonitor = GlobalRumMonitor.get(featureSdkCore);
        AdvancedRumMonitor advancedRumMonitor = rumMonitor instanceof AdvancedRumMonitor ? (AdvancedRumMonitor) rumMonitor : null;
        if (advancedRumMonitor != null) {
            RumErrorSource rumErrorSource = RumErrorSource.LOGGER;
            if (mapEmptyMap == null) {
                mapEmptyMap = MapsKt.emptyMap();
            }
            advancedRumMonitor.addError(str, rumErrorSource, th, mapEmptyMap);
        }
    }

    private final void addLoggerErrorWithStacktrace(Map<?, ?> loggerErrorEvent) {
        Object obj = loggerErrorEvent.get("stacktrace");
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = loggerErrorEvent.get("message");
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        Object obj3 = loggerErrorEvent.get(EVENT_ATTRIBUTES_PROPERTY);
        Map<String, ? extends Object> mapEmptyMap = obj3 instanceof Map ? (Map) obj3 : null;
        FeatureSdkCore featureSdkCore = this.sdkCore;
        if (str2 == null) {
            InternalLogger.DefaultImpls.log$default(featureSdkCore.getInternalLogger(), InternalLogger.Level.WARN, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.RumFeature.addLoggerErrorWithStacktrace.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return RumFeature.LOG_ERROR_WITH_STACKTRACE_EVENT_MISSING_MANDATORY_FIELDS;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return;
        }
        RumMonitor rumMonitor = GlobalRumMonitor.get(featureSdkCore);
        AdvancedRumMonitor advancedRumMonitor = rumMonitor instanceof AdvancedRumMonitor ? (AdvancedRumMonitor) rumMonitor : null;
        if (advancedRumMonitor != null) {
            RumErrorSource rumErrorSource = RumErrorSource.LOGGER;
            if (mapEmptyMap == null) {
                mapEmptyMap = MapsKt.emptyMap();
            }
            advancedRumMonitor.addErrorWithStacktrace(str2, rumErrorSource, str, mapEmptyMap);
        }
    }

    private final void addSessionReplaySkippedFrame() {
        RumMonitor rumMonitor = GlobalRumMonitor.get(this.sdkCore);
        AdvancedRumMonitor advancedRumMonitor = rumMonitor instanceof AdvancedRumMonitor ? (AdvancedRumMonitor) rumMonitor : null;
        if (advancedRumMonitor != null) {
            advancedRumMonitor.addSessionReplaySkippedFrame();
        }
    }

    private final void initRumAppStartupDetector() {
        RumAppStartupDetector.Companion companion = RumAppStartupDetector.INSTANCE;
        Context applicationContext = getAppContext$dd_sdk_android_rum_release().getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        FeatureSdkCore featureSdkCore = this.sdkCore;
        Intrinsics.checkNotNull(featureSdkCore, "null cannot be cast to non-null type com.datadog.android.core.InternalSdkCore");
        this.rumAppStartupDetector = companion.create((Application) applicationContext, (InternalSdkCore) featureSdkCore, new RumAppStartupDetector.Listener() { // from class: com.datadog.android.rum.internal.RumFeature.initRumAppStartupDetector.1
            @Override // com.datadog.android.rum.internal.startup.RumAppStartupDetector.Listener
            public void onAppStartupDetected(RumStartupScenario scenario) {
                Intrinsics.checkNotNullParameter(scenario, "scenario");
                RumMonitor rumMonitor = GlobalRumMonitor.get(RumFeature.this.sdkCore);
                AdvancedRumMonitor advancedRumMonitor = rumMonitor instanceof AdvancedRumMonitor ? (AdvancedRumMonitor) rumMonitor : null;
                if (advancedRumMonitor == null) {
                    return;
                }
                advancedRumMonitor.sendAppStartEvent(scenario);
            }

            @Override // com.datadog.android.rum.internal.startup.RumAppStartupDetector.Listener
            public void onTTIDComputed(RumStartupScenario scenario, long durationNs, boolean wasForwarded) {
                Intrinsics.checkNotNullParameter(scenario, "scenario");
                RumMonitor rumMonitor = GlobalRumMonitor.get(RumFeature.this.sdkCore);
                AdvancedRumMonitor advancedRumMonitor = rumMonitor instanceof AdvancedRumMonitor ? (AdvancedRumMonitor) rumMonitor : null;
                if (advancedRumMonitor == null) {
                    return;
                }
                advancedRumMonitor.sendTTIDEvent(new RumTTIDInfo(scenario, durationNs, wasForwarded));
            }
        }, this.configuration.getAppStartupActivityPredicate());
    }

    /* JADX INFO: compiled from: RumFeature.kt */
    @Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\\\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001Bå\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0014\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0014\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0014\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0014\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0014\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0014\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0014\u0012\u0006\u0010$\u001a\u00020\t\u0012\u0006\u0010%\u001a\u00020\t\u0012\u0006\u0010&\u001a\u00020\t\u0012\u0006\u0010'\u001a\u00020(\u0012\u0006\u0010)\u001a\u00020*\u0012\u0006\u0010+\u001a\u00020,\u0012\b\u0010-\u001a\u0004\u0018\u00010.\u0012\b\u0010/\u001a\u0004\u0018\u000100\u0012\u0006\u00101\u001a\u000202\u0012\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000104\u0012\u0006\u00105\u001a\u00020\t\u0012\b\u00106\u001a\u0004\u0018\u000107\u0012\u0006\u00108\u001a\u00020\t\u0012\u0006\u00109\u001a\u00020\t\u0012\u0006\u0010:\u001a\u00020;\u0012\u0006\u0010<\u001a\u00020=\u0012\b\u0010>\u001a\u0004\u0018\u00010?¢\u0006\u0002\u0010@J\u000b\u0010v\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010w\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014HÆ\u0003J\u000f\u0010x\u001a\b\u0012\u0004\u0012\u00020\u00170\u0014HÆ\u0003J\u000f\u0010y\u001a\b\u0012\u0004\u0012\u00020\u00190\u0014HÆ\u0003J\u000f\u0010z\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0014HÆ\u0003J\u000f\u0010{\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0014HÆ\u0003J\u000f\u0010|\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0014HÆ\u0003J\u000f\u0010}\u001a\b\u0012\u0004\u0012\u00020!0\u0014HÆ\u0003J\u000f\u0010~\u001a\b\u0012\u0004\u0012\u00020#0\u0014HÆ\u0003J\t\u0010\u007f\u001a\u00020\tHÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0082\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u0083\u0001\u001a\u00020(HÆ\u0003J\n\u0010\u0084\u0001\u001a\u00020*HÆ\u0003J\n\u0010\u0085\u0001\u001a\u00020,HÆ\u0003J\f\u0010\u0086\u0001\u001a\u0004\u0018\u00010.HÆ\u0003J\f\u0010\u0087\u0001\u001a\u0004\u0018\u000100HÆ\u0003J\n\u0010\u0088\u0001\u001a\u000202HÆ\u0003J\u0016\u0010\u0089\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000104HÆ\u0003J\n\u0010\u008a\u0001\u001a\u00020\tHÆ\u0003J\f\u0010\u008b\u0001\u001a\u0004\u0018\u000107HÆ\u0003J\n\u0010\u008c\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u008d\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u008e\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u008f\u0001\u001a\u00020;HÆ\u0003J\n\u0010\u0090\u0001\u001a\u00020=HÆ\u0003J\f\u0010\u0091\u0001\u001a\u0004\u0018\u00010?HÆ\u0003J\n\u0010\u0092\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0093\u0001\u001a\u00020\tHÆ\u0003J\u0010\u0010\u0094\u0001\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\n\u0010\u0095\u0001\u001a\u00020\u000eHÆ\u0003J\f\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\f\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003J®\u0003\u0010\u0098\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00142\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00142\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00142\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00142\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00142\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00142\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00142\b\b\u0002\u0010$\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020\t2\b\b\u0002\u0010&\u001a\u00020\t2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\b\b\u0002\u00101\u001a\u0002022\u0014\b\u0002\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001042\b\b\u0002\u00105\u001a\u00020\t2\n\b\u0002\u00106\u001a\u0004\u0018\u0001072\b\b\u0002\u00108\u001a\u00020\t2\b\b\u0002\u00109\u001a\u00020\t2\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020=2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?HÆ\u0001J\u0015\u0010\u0099\u0001\u001a\u00020\t2\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000b\u0010\u009b\u0001\u001a\u00030\u009c\u0001HÖ\u0001J\n\u0010\u009d\u0001\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0014¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u001d\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000104¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0011\u0010<\u001a\u00020=¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0011\u0010$\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0011\u00108\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bI\u0010HR\u0011\u00101\u001a\u000202¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0011\u00109\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bN\u0010HR\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0014¢\u0006\b\n\u0000\u001a\u0004\bO\u0010BR\u0011\u0010+\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0011\u0010:\u001a\u00020;¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u0013\u0010-\u001a\u0004\u0018\u00010.¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0014¢\u0006\b\n\u0000\u001a\u0004\bX\u0010BR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0014¢\u0006\b\n\u0000\u001a\u0004\b[\u0010BR\u0013\u00106\u001a\u0004\u0018\u000107¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b^\u0010_R\u0011\u0010)\u001a\u00020*¢\u0006\b\n\u0000\u001a\u0004\b`\u0010aR\u0013\u0010/\u001a\u0004\u0018\u000100¢\u0006\b\n\u0000\u001a\u0004\bb\u0010cR\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0014¢\u0006\b\n\u0000\u001a\u0004\bd\u0010BR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\be\u0010_R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bf\u0010_R\u0013\u0010>\u001a\u0004\u0018\u00010?¢\u0006\b\n\u0000\u001a\u0004\bg\u0010hR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\bi\u0010jR\u0011\u00105\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bk\u0010HR\u0011\u0010%\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bl\u0010HR\u0011\u0010&\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bm\u0010HR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bn\u0010HR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\bo\u0010BR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\bp\u0010qR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0014¢\u0006\b\n\u0000\u001a\u0004\br\u0010BR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0014¢\u0006\b\n\u0000\u001a\u0004\bs\u0010BR\u0011\u0010'\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\bt\u0010u¨\u0006\u009e\u0001"}, d2 = {"Lcom/datadog/android/rum/internal/RumFeature$Configuration;", "", "customEndpointUrl", "", "sampleRate", "", "telemetrySampleRate", "telemetryConfigurationSampleRate", "userActionTracking", "", "touchTargetExtraAttributesProviders", "", "Lcom/datadog/android/rum/tracking/ViewAttributesProvider;", "interactionPredicate", "Lcom/datadog/android/rum/tracking/InteractionPredicate;", "viewTrackingStrategy", "Lcom/datadog/android/rum/tracking/ViewTrackingStrategy;", "longTaskTrackingStrategy", "Lcom/datadog/android/rum/tracking/TrackingStrategy;", "viewEventMapper", "Lcom/datadog/android/event/EventMapper;", "Lcom/datadog/android/rum/model/ViewEvent;", "errorEventMapper", "Lcom/datadog/android/rum/model/ErrorEvent;", "resourceEventMapper", "Lcom/datadog/android/rum/model/ResourceEvent;", "actionEventMapper", "Lcom/datadog/android/rum/model/ActionEvent;", "longTaskEventMapper", "Lcom/datadog/android/rum/model/LongTaskEvent;", "vitalOperationStepEventMapper", "Lcom/datadog/android/rum/model/VitalOperationStepEvent;", "vitalAppLaunchEventMapper", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent;", "telemetryConfigurationMapper", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent;", "backgroundEventTracking", "trackFrustrations", "trackNonFatalAnrs", "vitalsMonitorUpdateFrequency", "Lcom/datadog/android/rum/configuration/VitalsUpdateFrequency;", "sessionListener", "Lcom/datadog/android/rum/RumSessionListener;", "initialResourceIdentifier", "Lcom/datadog/android/rum/metric/networksettled/InitialResourceIdentifier;", "lastInteractionIdentifier", "Lcom/datadog/android/rum/metric/interactiontonextview/LastInteractionIdentifier;", "slowFramesConfiguration", "Lcom/datadog/android/rum/configuration/SlowFramesConfiguration;", "composeActionTrackingStrategy", "Lcom/datadog/android/rum/tracking/ActionTrackingStrategy;", "additionalConfig", "", "trackAnonymousUser", "rumSessionTypeOverride", "Lcom/datadog/android/rum/RumSessionType;", "collectAccessibility", "disableJankStats", "insightsCollector", "Lcom/datadog/android/rum/internal/instrumentation/insights/InsightsCollector;", "appStartupActivityPredicate", "Lcom/datadog/android/rum/startup/AppStartupActivityPredicate;", "timeseriesConfiguration", "Lcom/datadog/android/rum/timeseries/TimeseriesConfiguration;", "(Ljava/lang/String;FFFZLjava/util/List;Lcom/datadog/android/rum/tracking/InteractionPredicate;Lcom/datadog/android/rum/tracking/ViewTrackingStrategy;Lcom/datadog/android/rum/tracking/TrackingStrategy;Lcom/datadog/android/event/EventMapper;Lcom/datadog/android/event/EventMapper;Lcom/datadog/android/event/EventMapper;Lcom/datadog/android/event/EventMapper;Lcom/datadog/android/event/EventMapper;Lcom/datadog/android/event/EventMapper;Lcom/datadog/android/event/EventMapper;Lcom/datadog/android/event/EventMapper;ZZZLcom/datadog/android/rum/configuration/VitalsUpdateFrequency;Lcom/datadog/android/rum/RumSessionListener;Lcom/datadog/android/rum/metric/networksettled/InitialResourceIdentifier;Lcom/datadog/android/rum/metric/interactiontonextview/LastInteractionIdentifier;Lcom/datadog/android/rum/configuration/SlowFramesConfiguration;Lcom/datadog/android/rum/tracking/ActionTrackingStrategy;Ljava/util/Map;ZLcom/datadog/android/rum/RumSessionType;ZZLcom/datadog/android/rum/internal/instrumentation/insights/InsightsCollector;Lcom/datadog/android/rum/startup/AppStartupActivityPredicate;Lcom/datadog/android/rum/timeseries/TimeseriesConfiguration;)V", "getActionEventMapper", "()Lcom/datadog/android/event/EventMapper;", "getAdditionalConfig", "()Ljava/util/Map;", "getAppStartupActivityPredicate", "()Lcom/datadog/android/rum/startup/AppStartupActivityPredicate;", "getBackgroundEventTracking", "()Z", "getCollectAccessibility", "getComposeActionTrackingStrategy", "()Lcom/datadog/android/rum/tracking/ActionTrackingStrategy;", "getCustomEndpointUrl", "()Ljava/lang/String;", "getDisableJankStats", "getErrorEventMapper", "getInitialResourceIdentifier", "()Lcom/datadog/android/rum/metric/networksettled/InitialResourceIdentifier;", "getInsightsCollector", "()Lcom/datadog/android/rum/internal/instrumentation/insights/InsightsCollector;", "getInteractionPredicate", "()Lcom/datadog/android/rum/tracking/InteractionPredicate;", "getLastInteractionIdentifier", "()Lcom/datadog/android/rum/metric/interactiontonextview/LastInteractionIdentifier;", "getLongTaskEventMapper", "getLongTaskTrackingStrategy", "()Lcom/datadog/android/rum/tracking/TrackingStrategy;", "getResourceEventMapper", "getRumSessionTypeOverride", "()Lcom/datadog/android/rum/RumSessionType;", "getSampleRate", "()F", "getSessionListener", "()Lcom/datadog/android/rum/RumSessionListener;", "getSlowFramesConfiguration", "()Lcom/datadog/android/rum/configuration/SlowFramesConfiguration;", "getTelemetryConfigurationMapper", "getTelemetryConfigurationSampleRate", "getTelemetrySampleRate", "getTimeseriesConfiguration", "()Lcom/datadog/android/rum/timeseries/TimeseriesConfiguration;", "getTouchTargetExtraAttributesProviders", "()Ljava/util/List;", "getTrackAnonymousUser", "getTrackFrustrations", "getTrackNonFatalAnrs", "getUserActionTracking", "getViewEventMapper", "getViewTrackingStrategy", "()Lcom/datadog/android/rum/tracking/ViewTrackingStrategy;", "getVitalAppLaunchEventMapper", "getVitalOperationStepEventMapper", "getVitalsMonitorUpdateFrequency", "()Lcom/datadog/android/rum/configuration/VitalsUpdateFrequency;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Configuration {
        private final EventMapper<ActionEvent> actionEventMapper;
        private final Map<String, Object> additionalConfig;
        private final AppStartupActivityPredicate appStartupActivityPredicate;
        private final boolean backgroundEventTracking;
        private final boolean collectAccessibility;
        private final ActionTrackingStrategy composeActionTrackingStrategy;
        private final String customEndpointUrl;
        private final boolean disableJankStats;
        private final EventMapper<ErrorEvent> errorEventMapper;
        private final InitialResourceIdentifier initialResourceIdentifier;
        private final InsightsCollector insightsCollector;
        private final InteractionPredicate interactionPredicate;
        private final LastInteractionIdentifier lastInteractionIdentifier;
        private final EventMapper<LongTaskEvent> longTaskEventMapper;
        private final TrackingStrategy longTaskTrackingStrategy;
        private final EventMapper<ResourceEvent> resourceEventMapper;
        private final RumSessionType rumSessionTypeOverride;
        private final float sampleRate;
        private final RumSessionListener sessionListener;
        private final SlowFramesConfiguration slowFramesConfiguration;
        private final EventMapper<TelemetryConfigurationEvent> telemetryConfigurationMapper;
        private final float telemetryConfigurationSampleRate;
        private final float telemetrySampleRate;
        private final TimeseriesConfiguration timeseriesConfiguration;
        private final List<ViewAttributesProvider> touchTargetExtraAttributesProviders;
        private final boolean trackAnonymousUser;
        private final boolean trackFrustrations;
        private final boolean trackNonFatalAnrs;
        private final boolean userActionTracking;
        private final EventMapper<ViewEvent> viewEventMapper;
        private final ViewTrackingStrategy viewTrackingStrategy;
        private final EventMapper<VitalAppLaunchEvent> vitalAppLaunchEventMapper;
        private final EventMapper<VitalOperationStepEvent> vitalOperationStepEventMapper;
        private final VitalsUpdateFrequency vitalsMonitorUpdateFrequency;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Configuration copy$default(Configuration configuration, String str, float f, float f2, float f3, boolean z, List list, InteractionPredicate interactionPredicate, ViewTrackingStrategy viewTrackingStrategy, TrackingStrategy trackingStrategy, EventMapper eventMapper, EventMapper eventMapper2, EventMapper eventMapper3, EventMapper eventMapper4, EventMapper eventMapper5, EventMapper eventMapper6, EventMapper eventMapper7, EventMapper eventMapper8, boolean z2, boolean z3, boolean z4, VitalsUpdateFrequency vitalsUpdateFrequency, RumSessionListener rumSessionListener, InitialResourceIdentifier initialResourceIdentifier, LastInteractionIdentifier lastInteractionIdentifier, SlowFramesConfiguration slowFramesConfiguration, ActionTrackingStrategy actionTrackingStrategy, Map map, boolean z5, RumSessionType rumSessionType, boolean z6, boolean z7, InsightsCollector insightsCollector, AppStartupActivityPredicate appStartupActivityPredicate, TimeseriesConfiguration timeseriesConfiguration, int i, int i2, Object obj) {
            TimeseriesConfiguration timeseriesConfiguration2;
            AppStartupActivityPredicate appStartupActivityPredicate2;
            String str2 = (i & 1) != 0 ? configuration.customEndpointUrl : str;
            float f4 = (i & 2) != 0 ? configuration.sampleRate : f;
            float f5 = (i & 4) != 0 ? configuration.telemetrySampleRate : f2;
            float f6 = (i & 8) != 0 ? configuration.telemetryConfigurationSampleRate : f3;
            boolean z8 = (i & 16) != 0 ? configuration.userActionTracking : z;
            List list2 = (i & 32) != 0 ? configuration.touchTargetExtraAttributesProviders : list;
            InteractionPredicate interactionPredicate2 = (i & 64) != 0 ? configuration.interactionPredicate : interactionPredicate;
            ViewTrackingStrategy viewTrackingStrategy2 = (i & 128) != 0 ? configuration.viewTrackingStrategy : viewTrackingStrategy;
            TrackingStrategy trackingStrategy2 = (i & 256) != 0 ? configuration.longTaskTrackingStrategy : trackingStrategy;
            EventMapper eventMapper9 = (i & 512) != 0 ? configuration.viewEventMapper : eventMapper;
            EventMapper eventMapper10 = (i & 1024) != 0 ? configuration.errorEventMapper : eventMapper2;
            EventMapper eventMapper11 = (i & 2048) != 0 ? configuration.resourceEventMapper : eventMapper3;
            EventMapper eventMapper12 = (i & 4096) != 0 ? configuration.actionEventMapper : eventMapper4;
            EventMapper eventMapper13 = (i & 8192) != 0 ? configuration.longTaskEventMapper : eventMapper5;
            String str3 = str2;
            EventMapper eventMapper14 = (i & 16384) != 0 ? configuration.vitalOperationStepEventMapper : eventMapper6;
            EventMapper eventMapper15 = (i & 32768) != 0 ? configuration.vitalAppLaunchEventMapper : eventMapper7;
            EventMapper eventMapper16 = (i & 65536) != 0 ? configuration.telemetryConfigurationMapper : eventMapper8;
            boolean z9 = (i & 131072) != 0 ? configuration.backgroundEventTracking : z2;
            boolean z10 = (i & 262144) != 0 ? configuration.trackFrustrations : z3;
            boolean z11 = (i & 524288) != 0 ? configuration.trackNonFatalAnrs : z4;
            VitalsUpdateFrequency vitalsUpdateFrequency2 = (i & 1048576) != 0 ? configuration.vitalsMonitorUpdateFrequency : vitalsUpdateFrequency;
            RumSessionListener rumSessionListener2 = (i & 2097152) != 0 ? configuration.sessionListener : rumSessionListener;
            InitialResourceIdentifier initialResourceIdentifier2 = (i & 4194304) != 0 ? configuration.initialResourceIdentifier : initialResourceIdentifier;
            LastInteractionIdentifier lastInteractionIdentifier2 = (i & 8388608) != 0 ? configuration.lastInteractionIdentifier : lastInteractionIdentifier;
            SlowFramesConfiguration slowFramesConfiguration2 = (i & 16777216) != 0 ? configuration.slowFramesConfiguration : slowFramesConfiguration;
            ActionTrackingStrategy actionTrackingStrategy2 = (i & GroupFlagsKt.HasAuxSlotFlag) != 0 ? configuration.composeActionTrackingStrategy : actionTrackingStrategy;
            Map map2 = (i & 67108864) != 0 ? configuration.additionalConfig : map;
            boolean z12 = (i & 134217728) != 0 ? configuration.trackAnonymousUser : z5;
            RumSessionType rumSessionType2 = (i & 268435456) != 0 ? configuration.rumSessionTypeOverride : rumSessionType;
            boolean z13 = (i & 536870912) != 0 ? configuration.collectAccessibility : z6;
            boolean z14 = (i & 1073741824) != 0 ? configuration.disableJankStats : z7;
            InsightsCollector insightsCollector2 = (i & Integer.MIN_VALUE) != 0 ? configuration.insightsCollector : insightsCollector;
            AppStartupActivityPredicate appStartupActivityPredicate3 = (i2 & 1) != 0 ? configuration.appStartupActivityPredicate : appStartupActivityPredicate;
            if ((i2 & 2) != 0) {
                appStartupActivityPredicate2 = appStartupActivityPredicate3;
                timeseriesConfiguration2 = configuration.timeseriesConfiguration;
            } else {
                timeseriesConfiguration2 = timeseriesConfiguration;
                appStartupActivityPredicate2 = appStartupActivityPredicate3;
            }
            return configuration.copy(str3, f4, f5, f6, z8, list2, interactionPredicate2, viewTrackingStrategy2, trackingStrategy2, eventMapper9, eventMapper10, eventMapper11, eventMapper12, eventMapper13, eventMapper14, eventMapper15, eventMapper16, z9, z10, z11, vitalsUpdateFrequency2, rumSessionListener2, initialResourceIdentifier2, lastInteractionIdentifier2, slowFramesConfiguration2, actionTrackingStrategy2, map2, z12, rumSessionType2, z13, z14, insightsCollector2, appStartupActivityPredicate2, timeseriesConfiguration2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getCustomEndpointUrl() {
            return this.customEndpointUrl;
        }

        public final EventMapper<ViewEvent> component10() {
            return this.viewEventMapper;
        }

        public final EventMapper<ErrorEvent> component11() {
            return this.errorEventMapper;
        }

        public final EventMapper<ResourceEvent> component12() {
            return this.resourceEventMapper;
        }

        public final EventMapper<ActionEvent> component13() {
            return this.actionEventMapper;
        }

        public final EventMapper<LongTaskEvent> component14() {
            return this.longTaskEventMapper;
        }

        public final EventMapper<VitalOperationStepEvent> component15() {
            return this.vitalOperationStepEventMapper;
        }

        public final EventMapper<VitalAppLaunchEvent> component16() {
            return this.vitalAppLaunchEventMapper;
        }

        public final EventMapper<TelemetryConfigurationEvent> component17() {
            return this.telemetryConfigurationMapper;
        }

        /* JADX INFO: renamed from: component18, reason: from getter */
        public final boolean getBackgroundEventTracking() {
            return this.backgroundEventTracking;
        }

        /* JADX INFO: renamed from: component19, reason: from getter */
        public final boolean getTrackFrustrations() {
            return this.trackFrustrations;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getSampleRate() {
            return this.sampleRate;
        }

        /* JADX INFO: renamed from: component20, reason: from getter */
        public final boolean getTrackNonFatalAnrs() {
            return this.trackNonFatalAnrs;
        }

        /* JADX INFO: renamed from: component21, reason: from getter */
        public final VitalsUpdateFrequency getVitalsMonitorUpdateFrequency() {
            return this.vitalsMonitorUpdateFrequency;
        }

        /* JADX INFO: renamed from: component22, reason: from getter */
        public final RumSessionListener getSessionListener() {
            return this.sessionListener;
        }

        /* JADX INFO: renamed from: component23, reason: from getter */
        public final InitialResourceIdentifier getInitialResourceIdentifier() {
            return this.initialResourceIdentifier;
        }

        /* JADX INFO: renamed from: component24, reason: from getter */
        public final LastInteractionIdentifier getLastInteractionIdentifier() {
            return this.lastInteractionIdentifier;
        }

        /* JADX INFO: renamed from: component25, reason: from getter */
        public final SlowFramesConfiguration getSlowFramesConfiguration() {
            return this.slowFramesConfiguration;
        }

        /* JADX INFO: renamed from: component26, reason: from getter */
        public final ActionTrackingStrategy getComposeActionTrackingStrategy() {
            return this.composeActionTrackingStrategy;
        }

        public final Map<String, Object> component27() {
            return this.additionalConfig;
        }

        /* JADX INFO: renamed from: component28, reason: from getter */
        public final boolean getTrackAnonymousUser() {
            return this.trackAnonymousUser;
        }

        /* JADX INFO: renamed from: component29, reason: from getter */
        public final RumSessionType getRumSessionTypeOverride() {
            return this.rumSessionTypeOverride;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final float getTelemetrySampleRate() {
            return this.telemetrySampleRate;
        }

        /* JADX INFO: renamed from: component30, reason: from getter */
        public final boolean getCollectAccessibility() {
            return this.collectAccessibility;
        }

        /* JADX INFO: renamed from: component31, reason: from getter */
        public final boolean getDisableJankStats() {
            return this.disableJankStats;
        }

        /* JADX INFO: renamed from: component32, reason: from getter */
        public final InsightsCollector getInsightsCollector() {
            return this.insightsCollector;
        }

        /* JADX INFO: renamed from: component33, reason: from getter */
        public final AppStartupActivityPredicate getAppStartupActivityPredicate() {
            return this.appStartupActivityPredicate;
        }

        /* JADX INFO: renamed from: component34, reason: from getter */
        public final TimeseriesConfiguration getTimeseriesConfiguration() {
            return this.timeseriesConfiguration;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final float getTelemetryConfigurationSampleRate() {
            return this.telemetryConfigurationSampleRate;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getUserActionTracking() {
            return this.userActionTracking;
        }

        public final List<ViewAttributesProvider> component6() {
            return this.touchTargetExtraAttributesProviders;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final InteractionPredicate getInteractionPredicate() {
            return this.interactionPredicate;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final ViewTrackingStrategy getViewTrackingStrategy() {
            return this.viewTrackingStrategy;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final TrackingStrategy getLongTaskTrackingStrategy() {
            return this.longTaskTrackingStrategy;
        }

        public final Configuration copy(String customEndpointUrl, float sampleRate, float telemetrySampleRate, float telemetryConfigurationSampleRate, boolean userActionTracking, List<? extends ViewAttributesProvider> touchTargetExtraAttributesProviders, InteractionPredicate interactionPredicate, ViewTrackingStrategy viewTrackingStrategy, TrackingStrategy longTaskTrackingStrategy, EventMapper<ViewEvent> viewEventMapper, EventMapper<ErrorEvent> errorEventMapper, EventMapper<ResourceEvent> resourceEventMapper, EventMapper<ActionEvent> actionEventMapper, EventMapper<LongTaskEvent> longTaskEventMapper, EventMapper<VitalOperationStepEvent> vitalOperationStepEventMapper, EventMapper<VitalAppLaunchEvent> vitalAppLaunchEventMapper, EventMapper<TelemetryConfigurationEvent> telemetryConfigurationMapper, boolean backgroundEventTracking, boolean trackFrustrations, boolean trackNonFatalAnrs, VitalsUpdateFrequency vitalsMonitorUpdateFrequency, RumSessionListener sessionListener, InitialResourceIdentifier initialResourceIdentifier, LastInteractionIdentifier lastInteractionIdentifier, SlowFramesConfiguration slowFramesConfiguration, ActionTrackingStrategy composeActionTrackingStrategy, Map<String, ? extends Object> additionalConfig, boolean trackAnonymousUser, RumSessionType rumSessionTypeOverride, boolean collectAccessibility, boolean disableJankStats, InsightsCollector insightsCollector, AppStartupActivityPredicate appStartupActivityPredicate, TimeseriesConfiguration timeseriesConfiguration) {
            Intrinsics.checkNotNullParameter(touchTargetExtraAttributesProviders, "touchTargetExtraAttributesProviders");
            Intrinsics.checkNotNullParameter(interactionPredicate, "interactionPredicate");
            Intrinsics.checkNotNullParameter(viewEventMapper, "viewEventMapper");
            Intrinsics.checkNotNullParameter(errorEventMapper, "errorEventMapper");
            Intrinsics.checkNotNullParameter(resourceEventMapper, "resourceEventMapper");
            Intrinsics.checkNotNullParameter(actionEventMapper, "actionEventMapper");
            Intrinsics.checkNotNullParameter(longTaskEventMapper, "longTaskEventMapper");
            Intrinsics.checkNotNullParameter(vitalOperationStepEventMapper, "vitalOperationStepEventMapper");
            Intrinsics.checkNotNullParameter(vitalAppLaunchEventMapper, "vitalAppLaunchEventMapper");
            Intrinsics.checkNotNullParameter(telemetryConfigurationMapper, "telemetryConfigurationMapper");
            Intrinsics.checkNotNullParameter(vitalsMonitorUpdateFrequency, "vitalsMonitorUpdateFrequency");
            Intrinsics.checkNotNullParameter(sessionListener, "sessionListener");
            Intrinsics.checkNotNullParameter(initialResourceIdentifier, "initialResourceIdentifier");
            Intrinsics.checkNotNullParameter(composeActionTrackingStrategy, "composeActionTrackingStrategy");
            Intrinsics.checkNotNullParameter(additionalConfig, "additionalConfig");
            Intrinsics.checkNotNullParameter(insightsCollector, "insightsCollector");
            Intrinsics.checkNotNullParameter(appStartupActivityPredicate, "appStartupActivityPredicate");
            return new Configuration(customEndpointUrl, sampleRate, telemetrySampleRate, telemetryConfigurationSampleRate, userActionTracking, touchTargetExtraAttributesProviders, interactionPredicate, viewTrackingStrategy, longTaskTrackingStrategy, viewEventMapper, errorEventMapper, resourceEventMapper, actionEventMapper, longTaskEventMapper, vitalOperationStepEventMapper, vitalAppLaunchEventMapper, telemetryConfigurationMapper, backgroundEventTracking, trackFrustrations, trackNonFatalAnrs, vitalsMonitorUpdateFrequency, sessionListener, initialResourceIdentifier, lastInteractionIdentifier, slowFramesConfiguration, composeActionTrackingStrategy, additionalConfig, trackAnonymousUser, rumSessionTypeOverride, collectAccessibility, disableJankStats, insightsCollector, appStartupActivityPredicate, timeseriesConfiguration);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Configuration)) {
                return false;
            }
            Configuration configuration = (Configuration) other;
            return Intrinsics.areEqual(this.customEndpointUrl, configuration.customEndpointUrl) && Float.compare(this.sampleRate, configuration.sampleRate) == 0 && Float.compare(this.telemetrySampleRate, configuration.telemetrySampleRate) == 0 && Float.compare(this.telemetryConfigurationSampleRate, configuration.telemetryConfigurationSampleRate) == 0 && this.userActionTracking == configuration.userActionTracking && Intrinsics.areEqual(this.touchTargetExtraAttributesProviders, configuration.touchTargetExtraAttributesProviders) && Intrinsics.areEqual(this.interactionPredicate, configuration.interactionPredicate) && Intrinsics.areEqual(this.viewTrackingStrategy, configuration.viewTrackingStrategy) && Intrinsics.areEqual(this.longTaskTrackingStrategy, configuration.longTaskTrackingStrategy) && Intrinsics.areEqual(this.viewEventMapper, configuration.viewEventMapper) && Intrinsics.areEqual(this.errorEventMapper, configuration.errorEventMapper) && Intrinsics.areEqual(this.resourceEventMapper, configuration.resourceEventMapper) && Intrinsics.areEqual(this.actionEventMapper, configuration.actionEventMapper) && Intrinsics.areEqual(this.longTaskEventMapper, configuration.longTaskEventMapper) && Intrinsics.areEqual(this.vitalOperationStepEventMapper, configuration.vitalOperationStepEventMapper) && Intrinsics.areEqual(this.vitalAppLaunchEventMapper, configuration.vitalAppLaunchEventMapper) && Intrinsics.areEqual(this.telemetryConfigurationMapper, configuration.telemetryConfigurationMapper) && this.backgroundEventTracking == configuration.backgroundEventTracking && this.trackFrustrations == configuration.trackFrustrations && this.trackNonFatalAnrs == configuration.trackNonFatalAnrs && this.vitalsMonitorUpdateFrequency == configuration.vitalsMonitorUpdateFrequency && Intrinsics.areEqual(this.sessionListener, configuration.sessionListener) && Intrinsics.areEqual(this.initialResourceIdentifier, configuration.initialResourceIdentifier) && Intrinsics.areEqual(this.lastInteractionIdentifier, configuration.lastInteractionIdentifier) && Intrinsics.areEqual(this.slowFramesConfiguration, configuration.slowFramesConfiguration) && Intrinsics.areEqual(this.composeActionTrackingStrategy, configuration.composeActionTrackingStrategy) && Intrinsics.areEqual(this.additionalConfig, configuration.additionalConfig) && this.trackAnonymousUser == configuration.trackAnonymousUser && this.rumSessionTypeOverride == configuration.rumSessionTypeOverride && this.collectAccessibility == configuration.collectAccessibility && this.disableJankStats == configuration.disableJankStats && Intrinsics.areEqual(this.insightsCollector, configuration.insightsCollector) && Intrinsics.areEqual(this.appStartupActivityPredicate, configuration.appStartupActivityPredicate) && Intrinsics.areEqual(this.timeseriesConfiguration, configuration.timeseriesConfiguration);
        }

        public int hashCode() {
            String str = this.customEndpointUrl;
            int iHashCode = (((((((((((((str == null ? 0 : str.hashCode()) * 31) + Float.hashCode(this.sampleRate)) * 31) + Float.hashCode(this.telemetrySampleRate)) * 31) + Float.hashCode(this.telemetryConfigurationSampleRate)) * 31) + Boolean.hashCode(this.userActionTracking)) * 31) + this.touchTargetExtraAttributesProviders.hashCode()) * 31) + this.interactionPredicate.hashCode()) * 31;
            ViewTrackingStrategy viewTrackingStrategy = this.viewTrackingStrategy;
            int iHashCode2 = (iHashCode + (viewTrackingStrategy == null ? 0 : viewTrackingStrategy.hashCode())) * 31;
            TrackingStrategy trackingStrategy = this.longTaskTrackingStrategy;
            int iHashCode3 = (((((((((((((((((((((((((((((iHashCode2 + (trackingStrategy == null ? 0 : trackingStrategy.hashCode())) * 31) + this.viewEventMapper.hashCode()) * 31) + this.errorEventMapper.hashCode()) * 31) + this.resourceEventMapper.hashCode()) * 31) + this.actionEventMapper.hashCode()) * 31) + this.longTaskEventMapper.hashCode()) * 31) + this.vitalOperationStepEventMapper.hashCode()) * 31) + this.vitalAppLaunchEventMapper.hashCode()) * 31) + this.telemetryConfigurationMapper.hashCode()) * 31) + Boolean.hashCode(this.backgroundEventTracking)) * 31) + Boolean.hashCode(this.trackFrustrations)) * 31) + Boolean.hashCode(this.trackNonFatalAnrs)) * 31) + this.vitalsMonitorUpdateFrequency.hashCode()) * 31) + this.sessionListener.hashCode()) * 31) + this.initialResourceIdentifier.hashCode()) * 31;
            LastInteractionIdentifier lastInteractionIdentifier = this.lastInteractionIdentifier;
            int iHashCode4 = (iHashCode3 + (lastInteractionIdentifier == null ? 0 : lastInteractionIdentifier.hashCode())) * 31;
            SlowFramesConfiguration slowFramesConfiguration = this.slowFramesConfiguration;
            int iHashCode5 = (((((((iHashCode4 + (slowFramesConfiguration == null ? 0 : slowFramesConfiguration.hashCode())) * 31) + this.composeActionTrackingStrategy.hashCode()) * 31) + this.additionalConfig.hashCode()) * 31) + Boolean.hashCode(this.trackAnonymousUser)) * 31;
            RumSessionType rumSessionType = this.rumSessionTypeOverride;
            int iHashCode6 = (((((((((iHashCode5 + (rumSessionType == null ? 0 : rumSessionType.hashCode())) * 31) + Boolean.hashCode(this.collectAccessibility)) * 31) + Boolean.hashCode(this.disableJankStats)) * 31) + this.insightsCollector.hashCode()) * 31) + this.appStartupActivityPredicate.hashCode()) * 31;
            TimeseriesConfiguration timeseriesConfiguration = this.timeseriesConfiguration;
            return iHashCode6 + (timeseriesConfiguration != null ? timeseriesConfiguration.hashCode() : 0);
        }

        public String toString() {
            return "Configuration(customEndpointUrl=" + this.customEndpointUrl + ", sampleRate=" + this.sampleRate + ", telemetrySampleRate=" + this.telemetrySampleRate + ", telemetryConfigurationSampleRate=" + this.telemetryConfigurationSampleRate + ", userActionTracking=" + this.userActionTracking + ", touchTargetExtraAttributesProviders=" + this.touchTargetExtraAttributesProviders + ", interactionPredicate=" + this.interactionPredicate + ", viewTrackingStrategy=" + this.viewTrackingStrategy + ", longTaskTrackingStrategy=" + this.longTaskTrackingStrategy + ", viewEventMapper=" + this.viewEventMapper + ", errorEventMapper=" + this.errorEventMapper + ", resourceEventMapper=" + this.resourceEventMapper + ", actionEventMapper=" + this.actionEventMapper + ", longTaskEventMapper=" + this.longTaskEventMapper + ", vitalOperationStepEventMapper=" + this.vitalOperationStepEventMapper + ", vitalAppLaunchEventMapper=" + this.vitalAppLaunchEventMapper + ", telemetryConfigurationMapper=" + this.telemetryConfigurationMapper + ", backgroundEventTracking=" + this.backgroundEventTracking + ", trackFrustrations=" + this.trackFrustrations + ", trackNonFatalAnrs=" + this.trackNonFatalAnrs + ", vitalsMonitorUpdateFrequency=" + this.vitalsMonitorUpdateFrequency + ", sessionListener=" + this.sessionListener + ", initialResourceIdentifier=" + this.initialResourceIdentifier + ", lastInteractionIdentifier=" + this.lastInteractionIdentifier + ", slowFramesConfiguration=" + this.slowFramesConfiguration + ", composeActionTrackingStrategy=" + this.composeActionTrackingStrategy + ", additionalConfig=" + this.additionalConfig + ", trackAnonymousUser=" + this.trackAnonymousUser + ", rumSessionTypeOverride=" + this.rumSessionTypeOverride + ", collectAccessibility=" + this.collectAccessibility + ", disableJankStats=" + this.disableJankStats + ", insightsCollector=" + this.insightsCollector + ", appStartupActivityPredicate=" + this.appStartupActivityPredicate + ", timeseriesConfiguration=" + this.timeseriesConfiguration + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Configuration(String str, float f, float f2, float f3, boolean z, List<? extends ViewAttributesProvider> touchTargetExtraAttributesProviders, InteractionPredicate interactionPredicate, ViewTrackingStrategy viewTrackingStrategy, TrackingStrategy trackingStrategy, EventMapper<ViewEvent> viewEventMapper, EventMapper<ErrorEvent> errorEventMapper, EventMapper<ResourceEvent> resourceEventMapper, EventMapper<ActionEvent> actionEventMapper, EventMapper<LongTaskEvent> longTaskEventMapper, EventMapper<VitalOperationStepEvent> vitalOperationStepEventMapper, EventMapper<VitalAppLaunchEvent> vitalAppLaunchEventMapper, EventMapper<TelemetryConfigurationEvent> telemetryConfigurationMapper, boolean z2, boolean z3, boolean z4, VitalsUpdateFrequency vitalsMonitorUpdateFrequency, RumSessionListener sessionListener, InitialResourceIdentifier initialResourceIdentifier, LastInteractionIdentifier lastInteractionIdentifier, SlowFramesConfiguration slowFramesConfiguration, ActionTrackingStrategy composeActionTrackingStrategy, Map<String, ? extends Object> additionalConfig, boolean z5, RumSessionType rumSessionType, boolean z6, boolean z7, InsightsCollector insightsCollector, AppStartupActivityPredicate appStartupActivityPredicate, TimeseriesConfiguration timeseriesConfiguration) {
            Intrinsics.checkNotNullParameter(touchTargetExtraAttributesProviders, "touchTargetExtraAttributesProviders");
            Intrinsics.checkNotNullParameter(interactionPredicate, "interactionPredicate");
            Intrinsics.checkNotNullParameter(viewEventMapper, "viewEventMapper");
            Intrinsics.checkNotNullParameter(errorEventMapper, "errorEventMapper");
            Intrinsics.checkNotNullParameter(resourceEventMapper, "resourceEventMapper");
            Intrinsics.checkNotNullParameter(actionEventMapper, "actionEventMapper");
            Intrinsics.checkNotNullParameter(longTaskEventMapper, "longTaskEventMapper");
            Intrinsics.checkNotNullParameter(vitalOperationStepEventMapper, "vitalOperationStepEventMapper");
            Intrinsics.checkNotNullParameter(vitalAppLaunchEventMapper, "vitalAppLaunchEventMapper");
            Intrinsics.checkNotNullParameter(telemetryConfigurationMapper, "telemetryConfigurationMapper");
            Intrinsics.checkNotNullParameter(vitalsMonitorUpdateFrequency, "vitalsMonitorUpdateFrequency");
            Intrinsics.checkNotNullParameter(sessionListener, "sessionListener");
            Intrinsics.checkNotNullParameter(initialResourceIdentifier, "initialResourceIdentifier");
            Intrinsics.checkNotNullParameter(composeActionTrackingStrategy, "composeActionTrackingStrategy");
            Intrinsics.checkNotNullParameter(additionalConfig, "additionalConfig");
            Intrinsics.checkNotNullParameter(insightsCollector, "insightsCollector");
            Intrinsics.checkNotNullParameter(appStartupActivityPredicate, "appStartupActivityPredicate");
            this.customEndpointUrl = str;
            this.sampleRate = f;
            this.telemetrySampleRate = f2;
            this.telemetryConfigurationSampleRate = f3;
            this.userActionTracking = z;
            this.touchTargetExtraAttributesProviders = touchTargetExtraAttributesProviders;
            this.interactionPredicate = interactionPredicate;
            this.viewTrackingStrategy = viewTrackingStrategy;
            this.longTaskTrackingStrategy = trackingStrategy;
            this.viewEventMapper = viewEventMapper;
            this.errorEventMapper = errorEventMapper;
            this.resourceEventMapper = resourceEventMapper;
            this.actionEventMapper = actionEventMapper;
            this.longTaskEventMapper = longTaskEventMapper;
            this.vitalOperationStepEventMapper = vitalOperationStepEventMapper;
            this.vitalAppLaunchEventMapper = vitalAppLaunchEventMapper;
            this.telemetryConfigurationMapper = telemetryConfigurationMapper;
            this.backgroundEventTracking = z2;
            this.trackFrustrations = z3;
            this.trackNonFatalAnrs = z4;
            this.vitalsMonitorUpdateFrequency = vitalsMonitorUpdateFrequency;
            this.sessionListener = sessionListener;
            this.initialResourceIdentifier = initialResourceIdentifier;
            this.lastInteractionIdentifier = lastInteractionIdentifier;
            this.slowFramesConfiguration = slowFramesConfiguration;
            this.composeActionTrackingStrategy = composeActionTrackingStrategy;
            this.additionalConfig = additionalConfig;
            this.trackAnonymousUser = z5;
            this.rumSessionTypeOverride = rumSessionType;
            this.collectAccessibility = z6;
            this.disableJankStats = z7;
            this.insightsCollector = insightsCollector;
            this.appStartupActivityPredicate = appStartupActivityPredicate;
            this.timeseriesConfiguration = timeseriesConfiguration;
        }

        public final String getCustomEndpointUrl() {
            return this.customEndpointUrl;
        }

        public final float getSampleRate() {
            return this.sampleRate;
        }

        public final float getTelemetrySampleRate() {
            return this.telemetrySampleRate;
        }

        public final float getTelemetryConfigurationSampleRate() {
            return this.telemetryConfigurationSampleRate;
        }

        public final boolean getUserActionTracking() {
            return this.userActionTracking;
        }

        public final List<ViewAttributesProvider> getTouchTargetExtraAttributesProviders() {
            return this.touchTargetExtraAttributesProviders;
        }

        public final InteractionPredicate getInteractionPredicate() {
            return this.interactionPredicate;
        }

        public final ViewTrackingStrategy getViewTrackingStrategy() {
            return this.viewTrackingStrategy;
        }

        public final TrackingStrategy getLongTaskTrackingStrategy() {
            return this.longTaskTrackingStrategy;
        }

        public final EventMapper<ViewEvent> getViewEventMapper() {
            return this.viewEventMapper;
        }

        public final EventMapper<ErrorEvent> getErrorEventMapper() {
            return this.errorEventMapper;
        }

        public final EventMapper<ResourceEvent> getResourceEventMapper() {
            return this.resourceEventMapper;
        }

        public final EventMapper<ActionEvent> getActionEventMapper() {
            return this.actionEventMapper;
        }

        public final EventMapper<LongTaskEvent> getLongTaskEventMapper() {
            return this.longTaskEventMapper;
        }

        public final EventMapper<VitalOperationStepEvent> getVitalOperationStepEventMapper() {
            return this.vitalOperationStepEventMapper;
        }

        public final EventMapper<VitalAppLaunchEvent> getVitalAppLaunchEventMapper() {
            return this.vitalAppLaunchEventMapper;
        }

        public final EventMapper<TelemetryConfigurationEvent> getTelemetryConfigurationMapper() {
            return this.telemetryConfigurationMapper;
        }

        public final boolean getBackgroundEventTracking() {
            return this.backgroundEventTracking;
        }

        public final boolean getTrackFrustrations() {
            return this.trackFrustrations;
        }

        public final boolean getTrackNonFatalAnrs() {
            return this.trackNonFatalAnrs;
        }

        public final VitalsUpdateFrequency getVitalsMonitorUpdateFrequency() {
            return this.vitalsMonitorUpdateFrequency;
        }

        public final RumSessionListener getSessionListener() {
            return this.sessionListener;
        }

        public final InitialResourceIdentifier getInitialResourceIdentifier() {
            return this.initialResourceIdentifier;
        }

        public final LastInteractionIdentifier getLastInteractionIdentifier() {
            return this.lastInteractionIdentifier;
        }

        public final SlowFramesConfiguration getSlowFramesConfiguration() {
            return this.slowFramesConfiguration;
        }

        public final ActionTrackingStrategy getComposeActionTrackingStrategy() {
            return this.composeActionTrackingStrategy;
        }

        public final Map<String, Object> getAdditionalConfig() {
            return this.additionalConfig;
        }

        public final boolean getTrackAnonymousUser() {
            return this.trackAnonymousUser;
        }

        public final RumSessionType getRumSessionTypeOverride() {
            return this.rumSessionTypeOverride;
        }

        public final boolean getCollectAccessibility() {
            return this.collectAccessibility;
        }

        public final boolean getDisableJankStats() {
            return this.disableJankStats;
        }

        public final InsightsCollector getInsightsCollector() {
            return this.insightsCollector;
        }

        public final AppStartupActivityPredicate getAppStartupActivityPredicate() {
            return this.appStartupActivityPredicate;
        }

        public final TimeseriesConfiguration getTimeseriesConfiguration() {
            return this.timeseriesConfiguration;
        }
    }

    /* JADX INFO: compiled from: RumFeature.kt */
    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0000¢\u0006\u0002\b,J3\u0010-\u001a\u00020.2\f\u0010/\u001a\b\u0012\u0004\u0012\u000201002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0002¢\u0006\u0002\u00108J;\u00109\u001a\u00020:2\f\u0010;\u001a\b\u0012\u0004\u0012\u000201002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u0010*\u001a\u00020+2\u0006\u00106\u001a\u000207H\u0002¢\u0006\u0002\u0010<J\u001d\u0010=\u001a\u0004\u0018\u00010\b*\u00020>2\u0006\u00106\u001a\u000207H\u0000¢\u0006\u0004\b?\u0010@R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/datadog/android/rum/internal/RumFeature$Companion;", "", "()V", "ALL_IN_SAMPLE_RATE", "", "DD_TELEMETRY_CONFIG_SAMPLE_RATE_TAG", "", "DEFAULT_LONG_TASK_THRESHOLD_MS", "", "DEFAULT_RUM_CONFIG", "Lcom/datadog/android/rum/internal/RumFeature$Configuration;", "getDEFAULT_RUM_CONFIG$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/internal/RumFeature$Configuration;", "DEFAULT_SAMPLE_RATE", "DEFAULT_TELEMETRY_CONFIGURATION_SAMPLE_RATE", "DEFAULT_TELEMETRY_SAMPLE_RATE", "DEVELOPER_MODE_SAMPLE_RATE_CHANGED_MESSAGE", "EVENT_ATTRIBUTES_PROPERTY", "EVENT_MESSAGE_PROPERTY", "EVENT_STACKTRACE_PROPERTY", "EVENT_THROWABLE_PROPERTY", "FAILED_TO_ENABLE_JANK_STATS_TRACKING_MANUALLY", "FAILED_TO_GET_HISTORICAL_EXIT_REASONS", "FLUSH_AND_STOP_MONITOR_MESSAGE_TYPE", "LOGGER_ERROR_BUS_MESSAGE_TYPE", "LOGGER_ERROR_WITH_STACK_TRACE_MESSAGE_TYPE", "LOG_ERROR_EVENT_MISSING_MANDATORY_FIELDS", "LOG_ERROR_WITH_STACKTRACE_EVENT_MISSING_MANDATORY_FIELDS", "NDK_CRASH_BUS_MESSAGE_TYPE", "NO_LAST_RUM_VIEW_EVENT_AVAILABLE", "RUM_FEATURE_NOT_YET_INITIALIZED", "RUM_TTL_24H", "getRUM_TTL_24H$dd_sdk_android_rum_release", "()J", "SLOW_FRAMES_MONITORING_DISABLED_MESSAGE", "SLOW_FRAMES_MONITORING_ENABLED_MESSAGE", "TELEMETRY_SESSION_REPLAY_SKIP_FRAME", "UNKNOWN_EVENT_TYPE_PROPERTY_VALUE", "UNSUPPORTED_EVENT_TYPE", "WEB_VIEW_INGESTED_NOTIFICATION_MESSAGE_TYPE", "isTrackNonFatalAnrsEnabledByDefault", "", "buildSdkVersionProvider", "Lcom/datadog/android/internal/system/BuildSdkVersionProvider;", "isTrackNonFatalAnrsEnabledByDefault$dd_sdk_android_rum_release", "provideGestureTracker", "Lcom/datadog/android/rum/internal/instrumentation/gestures/DatadogGesturesTracker;", "customProviders", "", "Lcom/datadog/android/rum/tracking/ViewAttributesProvider;", "interactionPredicate", "Lcom/datadog/android/rum/tracking/InteractionPredicate;", "composeActionTrackingStrategy", "Lcom/datadog/android/rum/tracking/ActionTrackingStrategy;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "([Lcom/datadog/android/rum/tracking/ViewAttributesProvider;Lcom/datadog/android/rum/tracking/InteractionPredicate;Lcom/datadog/android/rum/tracking/ActionTrackingStrategy;Lcom/datadog/android/api/InternalLogger;)Lcom/datadog/android/rum/internal/instrumentation/gestures/DatadogGesturesTracker;", "provideUserTrackingStrategy", "Lcom/datadog/android/rum/internal/tracking/UserActionTrackingStrategy;", "touchTargetExtraAttributesProviders", "([Lcom/datadog/android/rum/tracking/ViewAttributesProvider;Lcom/datadog/android/rum/tracking/InteractionPredicate;Lcom/datadog/android/rum/tracking/ActionTrackingStrategy;Lcom/datadog/android/internal/system/BuildSdkVersionProvider;Lcom/datadog/android/api/InternalLogger;)Lcom/datadog/android/rum/internal/tracking/UserActionTrackingStrategy;", "readTotalRamBytes", "Landroid/content/Context;", "readTotalRamBytes$dd_sdk_android_rum_release", "(Landroid/content/Context;Lcom/datadog/android/api/InternalLogger;)Ljava/lang/Long;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long getRUM_TTL_24H$dd_sdk_android_rum_release() {
            return RumFeature.RUM_TTL_24H;
        }

        public final Configuration getDEFAULT_RUM_CONFIG$dd_sdk_android_rum_release() {
            return RumFeature.DEFAULT_RUM_CONFIG;
        }

        public final Long readTotalRamBytes$dd_sdk_android_rum_release(Context context, InternalLogger internalLogger) {
            Intrinsics.checkNotNullParameter(context, "<this>");
            Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
            try {
                Object systemService = context.getSystemService("activity");
                if (!(systemService instanceof ActivityManager)) {
                    systemService = null;
                }
                ActivityManager activityManager = (ActivityManager) systemService;
                if (activityManager == null) {
                    return null;
                }
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                return Long.valueOf(memoryInfo.totalMem);
            } catch (RuntimeException e) {
                InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.RumFeature$Companion$readTotalRamBytes$2
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Failed to read total RAM via ActivityManager";
                    }
                }, (Throwable) e, false, (Map) null, 48, (Object) null);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final UserActionTrackingStrategy provideUserTrackingStrategy(ViewAttributesProvider[] touchTargetExtraAttributesProviders, InteractionPredicate interactionPredicate, ActionTrackingStrategy composeActionTrackingStrategy, BuildSdkVersionProvider buildSdkVersionProvider, InternalLogger internalLogger) {
            DatadogGesturesTracker datadogGesturesTrackerProvideGestureTracker = provideGestureTracker(touchTargetExtraAttributesProviders, interactionPredicate, composeActionTrackingStrategy, internalLogger);
            if (buildSdkVersionProvider.getIsAtLeastQ()) {
                return new UserActionTrackingStrategyApi29(datadogGesturesTrackerProvideGestureTracker);
            }
            return new UserActionTrackingStrategyLegacy(datadogGesturesTrackerProvideGestureTracker);
        }

        private final DatadogGesturesTracker provideGestureTracker(ViewAttributesProvider[] customProviders, InteractionPredicate interactionPredicate, ActionTrackingStrategy composeActionTrackingStrategy, InternalLogger internalLogger) {
            return new DatadogGesturesTracker((ViewAttributesProvider[]) ArraysKt.plus((Object[]) customProviders, (Object[]) new JetpackViewAttributesProvider[]{new JetpackViewAttributesProvider()}), interactionPredicate, composeActionTrackingStrategy, internalLogger);
        }

        public static /* synthetic */ boolean isTrackNonFatalAnrsEnabledByDefault$dd_sdk_android_rum_release$default(Companion companion, BuildSdkVersionProvider buildSdkVersionProvider, int i, Object obj) {
            if ((i & 1) != 0) {
                buildSdkVersionProvider = BuildSdkVersionProvider.INSTANCE.getDEFAULT();
            }
            return companion.isTrackNonFatalAnrsEnabledByDefault$dd_sdk_android_rum_release(buildSdkVersionProvider);
        }

        public final boolean isTrackNonFatalAnrsEnabledByDefault$dd_sdk_android_rum_release(BuildSdkVersionProvider buildSdkVersionProvider) {
            Intrinsics.checkNotNullParameter(buildSdkVersionProvider, "buildSdkVersionProvider");
            return !buildSdkVersionProvider.getIsAtLeastR();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        TimeUnit timeUnit = TimeUnit.HOURS;
        RUM_TTL_24H = 86400000L;
        List listEmptyList = CollectionsKt.emptyList();
        NoOpInteractionPredicate noOpInteractionPredicate = new NoOpInteractionPredicate();
        ActivityViewTrackingStrategy activityViewTrackingStrategy = new ActivityViewTrackingStrategy(false, 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0);
        MainLooperLongTaskStrategy mainLooperLongTaskStrategy = new MainLooperLongTaskStrategy(100L);
        NoOpEventMapper noOpEventMapper = new NoOpEventMapper();
        NoOpEventMapper noOpEventMapper2 = new NoOpEventMapper();
        NoOpEventMapper noOpEventMapper3 = new NoOpEventMapper();
        NoOpEventMapper noOpEventMapper4 = new NoOpEventMapper();
        NoOpEventMapper noOpEventMapper5 = new NoOpEventMapper();
        NoOpEventMapper noOpEventMapper6 = new NoOpEventMapper();
        NoOpEventMapper noOpEventMapper7 = new NoOpEventMapper();
        NoOpEventMapper noOpEventMapper8 = new NoOpEventMapper();
        boolean zIsTrackNonFatalAnrsEnabledByDefault$dd_sdk_android_rum_release$default = Companion.isTrackNonFatalAnrsEnabledByDefault$dd_sdk_android_rum_release$default(companion, null, 1, null);
        VitalsUpdateFrequency vitalsUpdateFrequency = VitalsUpdateFrequency.AVERAGE;
        NoOpRumSessionListener noOpRumSessionListener = new NoOpRumSessionListener();
        TimeBasedInitialResourceIdentifier timeBasedInitialResourceIdentifier = new TimeBasedInitialResourceIdentifier(0L, 1, null);
        TimeBasedInteractionIdentifier timeBasedInteractionIdentifier = new TimeBasedInteractionIdentifier(0L, 1, null);
        NoOpActionTrackingStrategy noOpActionTrackingStrategy = new NoOpActionTrackingStrategy();
        Map mapEmptyMap = MapsKt.emptyMap();
        DEFAULT_RUM_CONFIG = new Configuration(null, 100.0f, 20.0f, 20.0f, true, listEmptyList, noOpInteractionPredicate, activityViewTrackingStrategy, mainLooperLongTaskStrategy, noOpEventMapper, noOpEventMapper2, noOpEventMapper3, noOpEventMapper4, noOpEventMapper5, noOpEventMapper6, noOpEventMapper7, noOpEventMapper8, false, true, zIsTrackNonFatalAnrsEnabledByDefault$dd_sdk_android_rum_release$default, vitalsUpdateFrequency, noOpRumSessionListener, timeBasedInitialResourceIdentifier, timeBasedInteractionIdentifier, SlowFramesConfiguration.INSTANCE.getDEFAULT(), noOpActionTrackingStrategy, mapEmptyMap, true, null, false, false, new NoOpInsightsCollector(), DefaultAppStartupActivityPredicate.INSTANCE, null);
    }
}

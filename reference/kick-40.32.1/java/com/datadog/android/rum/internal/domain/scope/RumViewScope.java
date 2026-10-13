package com.datadog.android.rum.internal.domain.scope;

import android.util.Log;
import androidx.media3.common.C;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.AccountInfo;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.context.UserInfo;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.api.storage.EventType;
import com.datadog.android.core.InternalSdkCore;
import com.datadog.android.core.feature.event.ThreadDump;
import com.datadog.android.core.internal.net.FirstPartyHostHeaderTypeResolver;
import com.datadog.android.core.internal.utils.DdTagsUtils;
import com.datadog.android.internal.attributes.LocalAttribute;
import com.datadog.android.internal.attributes.ViewScopeInstrumentationType;
import com.datadog.android.internal.heatmaps.HeatmapIdentifierRegistry;
import com.datadog.android.internal.profiling.ProfilerEvent;
import com.datadog.android.internal.profiling.ProfilingRumContext;
import com.datadog.android.internal.telemetry.InternalTelemetryEvent;
import com.datadog.android.internal.utils.ThrowableExtKt;
import com.datadog.android.rum.RumActionType;
import com.datadog.android.rum.RumAttributes;
import com.datadog.android.rum.RumPerformanceMetric;
import com.datadog.android.rum.RumSessionType;
import com.datadog.android.rum.internal.FeaturesContextResolver;
import com.datadog.android.rum.internal.RumSessionTypeExtKt;
import com.datadog.android.rum.internal.anr.ANRException;
import com.datadog.android.rum.internal.domain.InfoProvider;
import com.datadog.android.rum.internal.domain.RumContext;
import com.datadog.android.rum.internal.domain.Time;
import com.datadog.android.rum.internal.domain.accessibility.AccessibilityInfo;
import com.datadog.android.rum.internal.domain.accessibility.AccessibilitySnapshotManager;
import com.datadog.android.rum.internal.domain.battery.BatteryInfo;
import com.datadog.android.rum.internal.domain.display.DisplayInfo;
import com.datadog.android.rum.internal.domain.event.RumEventMeta;
import com.datadog.android.rum.internal.domain.state.ViewUIPerformanceReport;
import com.datadog.android.rum.internal.domain.state.ms;
import com.datadog.android.rum.internal.instrumentation.insights.InsightsCollector;
import com.datadog.android.rum.internal.metric.NoValueReason;
import com.datadog.android.rum.internal.metric.SessionMetricDispatcher;
import com.datadog.android.rum.internal.metric.ViewEndedMetricDispatcher;
import com.datadog.android.rum.internal.metric.ViewInitializationMetricsState;
import com.datadog.android.rum.internal.metric.ViewMetricDispatcher;
import com.datadog.android.rum.internal.metric.interactiontonextview.InteractionToNextViewMetricResolver;
import com.datadog.android.rum.internal.metric.interactiontonextview.InternalInteractionContext;
import com.datadog.android.rum.internal.metric.networksettled.InternalResourceContext;
import com.datadog.android.rum.internal.metric.networksettled.NetworkSettledMetricResolver;
import com.datadog.android.rum.internal.metric.slowframes.SlowFramesListener;
import com.datadog.android.rum.internal.monitor.AdvancedRumMonitor;
import com.datadog.android.rum.internal.monitor.StorageEvent;
import com.datadog.android.rum.internal.profiling.ProfilingFeatureContextKt;
import com.datadog.android.rum.internal.utils.RuntimeUtilsKt;
import com.datadog.android.rum.internal.utils.SdkCoreExtKt;
import com.datadog.android.rum.internal.utils.WriteOperation;
import com.datadog.android.rum.internal.vitals.VitalInfo;
import com.datadog.android.rum.internal.vitals.VitalListener;
import com.datadog.android.rum.internal.vitals.VitalMonitor;
import com.datadog.android.rum.metric.networksettled.InitialResourceIdentifier;
import com.datadog.android.rum.model.ErrorEvent;
import com.datadog.android.rum.model.LongTaskEvent;
import com.datadog.android.rum.model.ViewEvent;
import com.datadog.android.rum.model.VitalOperationStepEvent;
import com.datadog.android.rum.operations.FailureReason;
import com.datadog.android.webview.internal.MixedWebViewEventConsumer;
import com.datadog.trace.bootstrap.instrumentation.api.InstrumentationTags;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: RumViewScope.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000ú\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u0000 \u0094\u00022\u00020\u0001:\u0002\u0094\u0002Bó\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u001e\u0012\u0006\u0010\u001f\u001a\u00020 \u0012\u0006\u0010!\u001a\u00020\"\u0012\b\u0010#\u001a\u0004\u0018\u00010$\u0012\u0006\u0010%\u001a\u00020&\u0012\b\u0010'\u001a\u0004\u0018\u00010(\u0012\u0006\u0010)\u001a\u00020*\u0012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,\u0012\f\u0010.\u001a\b\u0012\u0004\u0012\u00020/0,\u0012\u0006\u00100\u001a\u000201\u0012\b\u00102\u001a\u0004\u0018\u000103¢\u0006\u0002\u00104JY\u0010 \u0001\u001a\u00030¡\u00012\b\u0010¢\u0001\u001a\u00030£\u00012\b\u0010¤\u0001\u001a\u00030¥\u00012)\u0010¦\u0001\u001a$\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030¨\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001j\u0003`©\u00012\u000e\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0«\u0001H\u0003JY\u0010¬\u0001\u001a\u00030¡\u00012\b\u0010¢\u0001\u001a\u00030£\u00012\b\u0010¤\u0001\u001a\u00030¥\u00012)\u0010¦\u0001\u001a$\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030¨\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001j\u0003`©\u00012\u000e\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0«\u0001H\u0003JY\u0010\u00ad\u0001\u001a\u00030¡\u00012\b\u0010¢\u0001\u001a\u00030£\u00012\b\u0010¤\u0001\u001a\u00030¥\u00012)\u0010¦\u0001\u001a$\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030¨\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001j\u0003`©\u00012\u000e\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0«\u0001H\u0003J\u0017\u0010®\u0001\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fH\u0016J\n\u0010¯\u0001\u001a\u00030°\u0001H\u0016JZ\u0010±\u0001\u001a\u0004\u0018\u00010\u00012\b\u0010¢\u0001\u001a\u00030£\u00012\b\u0010¤\u0001\u001a\u00030¥\u00012)\u0010¦\u0001\u001a$\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030¨\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001j\u0003`©\u00012\u000e\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0«\u0001H\u0017J\t\u0010²\u0001\u001a\u00020\u001cH\u0016J\t\u0010³\u0001\u001a\u00020\u001cH\u0002J\u001b\u0010´\u0001\u001a\u00030¡\u00012\u0006\u0010\u0007\u001a\u00020\r2\u0007\u0010µ\u0001\u001a\u00020\rH\u0002Jr\u0010¶\u0001\u001a\u00030·\u00012\u0007\u0010¸\u0001\u001a\u00020\r2\b\u0010¢\u0001\u001a\u00030£\u00012\b\u0010¤\u0001\u001a\u00030¥\u00012\u0007\u0010¹\u0001\u001a\u00020\r2\t\u0010º\u0001\u001a\u0004\u0018\u00010\r2\b\u0010»\u0001\u001a\u00030¼\u00012\n\u0010½\u0001\u001a\u0005\u0018\u00010¾\u00012\u0015\u0010¿\u0001\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f2\b\u0010À\u0001\u001a\u00030°\u0001H\u0002J\u0014\u0010Á\u0001\u001a\u00030¡\u00012\b\u0010¢\u0001\u001a\u00030Â\u0001H\u0002JY\u0010Ã\u0001\u001a\u00030¡\u00012\b\u0010¢\u0001\u001a\u00030Ä\u00012\b\u0010¤\u0001\u001a\u00030¥\u00012)\u0010¦\u0001\u001a$\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030¨\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001j\u0003`©\u00012\u000e\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0«\u0001H\u0003JY\u0010Å\u0001\u001a\u00030¡\u00012\b\u0010¢\u0001\u001a\u00030Æ\u00012\b\u0010¤\u0001\u001a\u00030¥\u00012)\u0010¦\u0001\u001a$\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030¨\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001j\u0003`©\u00012\u000e\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0«\u0001H\u0003JY\u0010Ç\u0001\u001a\u00030¡\u00012\b\u0010¢\u0001\u001a\u00030È\u00012\b\u0010¤\u0001\u001a\u00030¥\u00012)\u0010¦\u0001\u001a$\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030¨\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001j\u0003`©\u00012\u000e\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0«\u0001H\u0003JY\u0010É\u0001\u001a\u00030¡\u00012\b\u0010¢\u0001\u001a\u00030Ê\u00012\b\u0010¤\u0001\u001a\u00030¥\u00012)\u0010¦\u0001\u001a$\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030¨\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001j\u0003`©\u00012\u000e\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0«\u0001H\u0002JY\u0010Ë\u0001\u001a\u00030¡\u00012\b\u0010¢\u0001\u001a\u00030Ì\u00012\b\u0010¤\u0001\u001a\u00030¥\u00012)\u0010¦\u0001\u001a$\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030¨\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001j\u0003`©\u00012\u000e\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0«\u0001H\u0002JY\u0010Í\u0001\u001a\u00030¡\u00012\b\u0010¢\u0001\u001a\u00030Î\u00012\b\u0010¤\u0001\u001a\u00030¥\u00012)\u0010¦\u0001\u001a$\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030¨\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001j\u0003`©\u00012\u000e\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0«\u0001H\u0003J\u0014\u0010Ï\u0001\u001a\u00030¡\u00012\b\u0010¢\u0001\u001a\u00030Ð\u0001H\u0003JY\u0010Ñ\u0001\u001a\u00030¡\u00012\b\u0010¢\u0001\u001a\u00030Ò\u00012\b\u0010¤\u0001\u001a\u00030¥\u00012)\u0010¦\u0001\u001a$\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030¨\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001j\u0003`©\u00012\u000e\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0«\u0001H\u0003J\u0014\u0010Ó\u0001\u001a\u00030¡\u00012\b\u0010¢\u0001\u001a\u00030Ô\u0001H\u0002JY\u0010Õ\u0001\u001a\u00030¡\u00012\b\u0010¢\u0001\u001a\u00030Ö\u00012\b\u0010¤\u0001\u001a\u00030¥\u00012)\u0010¦\u0001\u001a$\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030¨\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001j\u0003`©\u00012\u000e\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0«\u0001H\u0003J\u0014\u0010×\u0001\u001a\u00030¡\u00012\b\u0010¢\u0001\u001a\u00030Ø\u0001H\u0002JY\u0010Ù\u0001\u001a\u00030¡\u00012\b\u0010¢\u0001\u001a\u00030Ú\u00012\b\u0010¤\u0001\u001a\u00030¥\u00012)\u0010¦\u0001\u001a$\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030¨\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001j\u0003`©\u00012\u000e\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0«\u0001H\u0003J\u0014\u0010Û\u0001\u001a\u00030¡\u00012\b\u0010¢\u0001\u001a\u00030Ü\u0001H\u0003J\u0014\u0010Ý\u0001\u001a\u00030¡\u00012\b\u0010¢\u0001\u001a\u00030Þ\u0001H\u0002JY\u0010ß\u0001\u001a\u00030¡\u00012\b\u0010¢\u0001\u001a\u00030à\u00012\b\u0010¤\u0001\u001a\u00030¥\u00012)\u0010¦\u0001\u001a$\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030¨\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001j\u0003`©\u00012\u000e\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0«\u0001H\u0003J\u0014\u0010á\u0001\u001a\u00030¡\u00012\b\u0010¢\u0001\u001a\u00030â\u0001H\u0003JY\u0010ã\u0001\u001a\u00030¡\u00012\b\u0010¢\u0001\u001a\u00030ä\u00012\b\u0010¤\u0001\u001a\u00030¥\u00012)\u0010¦\u0001\u001a$\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030¨\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001j\u0003`©\u00012\u000e\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0«\u0001H\u0003JY\u0010å\u0001\u001a\u00030¡\u00012\b\u0010¢\u0001\u001a\u00030æ\u00012\b\u0010¤\u0001\u001a\u00030¥\u00012)\u0010¦\u0001\u001a$\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030¨\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001j\u0003`©\u00012\u000e\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0«\u0001H\u0002JY\u0010ç\u0001\u001a\u00030¡\u00012\b\u0010¢\u0001\u001a\u00030è\u00012\b\u0010¤\u0001\u001a\u00030¥\u00012)\u0010¦\u0001\u001a$\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030¨\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001j\u0003`©\u00012\u000e\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0«\u0001H\u0003JY\u0010é\u0001\u001a\u00030¡\u00012\b\u0010¢\u0001\u001a\u00030ê\u00012\b\u0010¤\u0001\u001a\u00030¥\u00012)\u0010¦\u0001\u001a$\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030¨\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001j\u0003`©\u00012\u000e\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0«\u0001H\u0003JY\u0010ë\u0001\u001a\u00030¡\u00012\b\u0010¢\u0001\u001a\u00030ì\u00012\b\u0010¤\u0001\u001a\u00030¥\u00012)\u0010¦\u0001\u001a$\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030¨\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001j\u0003`©\u00012\u000e\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0«\u0001H\u0002JY\u0010í\u0001\u001a\u00030¡\u00012\b\u0010¢\u0001\u001a\u00030î\u00012\b\u0010¤\u0001\u001a\u00030¥\u00012)\u0010¦\u0001\u001a$\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030¨\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001j\u0003`©\u00012\u000e\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0«\u0001H\u0003JY\u0010ï\u0001\u001a\u00030¡\u00012\b\u0010¢\u0001\u001a\u00030ð\u00012\b\u0010¤\u0001\u001a\u00030¥\u00012)\u0010¦\u0001\u001a$\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030¨\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001j\u0003`©\u00012\u000e\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0«\u0001H\u0003J\u0014\u0010ñ\u0001\u001a\u00030¡\u00012\b\u0010¢\u0001\u001a\u00030ò\u0001H\u0002J\u0014\u0010ó\u0001\u001a\u00030¡\u00012\b\u0010¢\u0001\u001a\u00030ô\u0001H\u0002J\u0018\u0010õ\u0001\u001a\u00020\u00002\u0007\u0010ö\u0001\u001a\u00020\nH\u0000¢\u0006\u0003\b÷\u0001J\f\u0010ø\u0001\u001a\u0005\u0018\u00010ù\u0001H\u0002J\u0016\u0010ú\u0001\u001a\u0005\u0018\u00010û\u00012\b\u0010¤\u0001\u001a\u00030¥\u0001H\u0002J\u0016\u0010ü\u0001\u001a\u0005\u0018\u00010ý\u00012\b\u0010¤\u0001\u001a\u00030¥\u0001H\u0002J\u001c\u0010þ\u0001\u001a\u0004\u0018\u00010\u001c2\t\u0010ÿ\u0001\u001a\u0004\u0018\u00010SH\u0002¢\u0006\u0003\u0010\u0080\u0002J\u0014\u0010\u0081\u0002\u001a\u00030¡\u00012\b\u0010¢\u0001\u001a\u00030£\u0001H\u0002J\u0016\u0010\u0082\u0002\u001a\u0005\u0018\u00010\u0083\u00022\b\u0010¤\u0001\u001a\u00030¥\u0001H\u0002J\u0016\u0010\u0084\u0002\u001a\u0005\u0018\u00010\u0085\u00022\b\u0010¤\u0001\u001a\u00030¥\u0001H\u0002J.\u0010\u0086\u0002\u001a\u00030¡\u00012\b\u0010À\u0001\u001a\u00030°\u00012\u0007\u0010¸\u0001\u001a\u00020\r2\u0007\u0010\u0087\u0002\u001a\u00020\r2\u0006\u0010O\u001a\u000206H\u0002J\n\u0010\u0088\u0002\u001a\u00030¡\u0001H\u0002Jk\u0010\u0089\u0002\u001a\u00030¡\u00012\b\u0010¢\u0001\u001a\u00030£\u00012\b\u0010¤\u0001\u001a\u00030¥\u00012)\u0010¦\u0001\u001a$\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030¨\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001j\u0003`©\u00012\u000e\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0«\u00012\n\b\u0002\u0010\u008a\u0002\u001a\u00030\u008b\u0002H\u0000¢\u0006\u0003\b\u008c\u0002Jl\u0010\u008d\u0002\u001a\u00030¡\u00012\b\u0010¢\u0001\u001a\u00030£\u00012\b\u0010¤\u0001\u001a\u00030¥\u00012)\u0010¦\u0001\u001a$\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030¨\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001j\u0003`©\u00012\u000e\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0«\u00012\u0011\b\u0002\u0010\u008e\u0002\u001a\n\u0012\u0005\u0012\u00030¡\u00010\u008f\u0002H\u0003JY\u0010\u0090\u0002\u001a\u00030¡\u00012\b\u0010¢\u0001\u001a\u00030Ò\u00012\b\u0010¤\u0001\u001a\u00030¥\u00012)\u0010¦\u0001\u001a$\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030¨\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001\u0012\u0005\u0012\u00030¡\u00010§\u0001j\u0003`©\u00012\u000e\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0«\u0001H\u0002J\u001b\u0010\u0091\u0002\u001a\u0005\u0018\u00010\u0092\u0002*\u00030\u0093\u00022\b\u0010¢\u0001\u001a\u00030È\u0001H\u0002R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00107\u001a\u0004\u0018\u00010\u0001X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R \u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010=X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0004\n\u0002\u0010BR\u001a\u0010C\u001a\u00020DX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0014\u0010\u0013\u001a\u00020\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u000e\u0010K\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010L\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002060=X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010?R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020/0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010O\u001a\u000206X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0010\u0010R\u001a\u0004\u0018\u00010SX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010T\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0=X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010?R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u001a\u0010X\u001a\u00020DX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010F\"\u0004\bZ\u0010HR\u0014\u0010\u0016\u001a\u00020\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010JR\u000e\u0010\\\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020^X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010_\u001a\u00020\u001cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010d\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0=X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010fR\u0010\u0010g\u001a\u0004\u0018\u00010SX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010h\u001a\u0004\u0018\u00010SX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010j\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010k\u001a\u00020DX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010F\"\u0004\bm\u0010HR\u0014\u0010\u0015\u001a\u00020\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bn\u0010JR\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bo\u00109R\u001a\u0010p\u001a\u000206X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010Q\"\u0004\br\u0010sR\u001a\u0010t\u001a\u000206X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010Q\"\u0004\bv\u0010sR\u001a\u0010w\u001a\u000206X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010Q\"\u0004\by\u0010sR\u001a\u0010z\u001a\u000206X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010Q\"\u0004\b|\u0010sR\u001a\u0010}\u001a\u000206X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010Q\"\u0004\b\u007f\u0010sR\u001c\u0010\u0080\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u0081\u0001\u0012\u0004\u0012\u00020S0=X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0082\u0001\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\u00020\u001eX\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0085\u0001\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0086\u0001\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0087\u0001\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0088\u0001\u001a\u00020\u001cX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0089\u0001\u0010a\"\u0005\b\u008a\u0001\u0010cR\u001d\u0010\u008b\u0001\u001a\u000206X\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008c\u0001\u0010Q\"\u0005\b\u008d\u0001\u0010sR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\u00020\u001aX\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0017\u0010\u0090\u0001\u001a\u00020\rX\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001d\u0010\u0093\u0001\u001a\u000206X\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0001\u0010Q\"\u0005\b\u0095\u0001\u0010sR$\u0010\u0096\u0001\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0=X\u0080\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0097\u0001\u0010?R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0098\u0001\u001a\u00020\rX\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0099\u0001\u0010\u0092\u0001R$\u0010\u009a\u0001\u001a\u0004\u0018\u000106X\u0080\u000e¢\u0006\u0015\n\u0003\u0010\u009f\u0001\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001\"\u0006\b\u009d\u0001\u0010\u009e\u0001¨\u0006\u0095\u0002"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumViewScope;", "Lcom/datadog/android/rum/internal/domain/scope/RumScope;", "parentScope", "sdkCore", "Lcom/datadog/android/core/InternalSdkCore;", "sessionEndedMetricDispatcher", "Lcom/datadog/android/rum/internal/metric/SessionMetricDispatcher;", "key", "Lcom/datadog/android/rum/internal/domain/scope/RumScopeKey;", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "initialAttributes", "", "", "", "viewChangedListener", "Lcom/datadog/android/rum/internal/domain/scope/RumViewChangedListener;", "firstPartyHostHeaderTypeResolver", "Lcom/datadog/android/core/internal/net/FirstPartyHostHeaderTypeResolver;", "cpuVitalMonitor", "Lcom/datadog/android/rum/internal/vitals/VitalMonitor;", "memoryVitalMonitor", "frameRateVitalMonitor", "featuresContextResolver", "Lcom/datadog/android/rum/internal/FeaturesContextResolver;", "type", "Lcom/datadog/android/rum/internal/domain/scope/RumViewType;", "trackFrustrations", "", "sampleRate", "", "interactionToNextViewMetricResolver", "Lcom/datadog/android/rum/internal/metric/interactiontonextview/InteractionToNextViewMetricResolver;", "networkSettledMetricResolver", "Lcom/datadog/android/rum/internal/metric/networksettled/NetworkSettledMetricResolver;", "slowFramesListener", "Lcom/datadog/android/rum/internal/metric/slowframes/SlowFramesListener;", "viewEndedMetricDispatcher", "Lcom/datadog/android/rum/internal/metric/ViewMetricDispatcher;", "rumSessionTypeOverride", "Lcom/datadog/android/rum/RumSessionType;", "accessibilitySnapshotManager", "Lcom/datadog/android/rum/internal/domain/accessibility/AccessibilitySnapshotManager;", "batteryInfoProvider", "Lcom/datadog/android/rum/internal/domain/InfoProvider;", "Lcom/datadog/android/rum/internal/domain/battery/BatteryInfo;", "displayInfoProvider", "Lcom/datadog/android/rum/internal/domain/display/DisplayInfo;", "insightsCollector", "Lcom/datadog/android/rum/internal/instrumentation/insights/InsightsCollector;", "heatmapIdentifierRegistry", "Lcom/datadog/android/internal/heatmaps/HeatmapIdentifierRegistry;", "(Lcom/datadog/android/rum/internal/domain/scope/RumScope;Lcom/datadog/android/core/InternalSdkCore;Lcom/datadog/android/rum/internal/metric/SessionMetricDispatcher;Lcom/datadog/android/rum/internal/domain/scope/RumScopeKey;Lcom/datadog/android/rum/internal/domain/Time;Ljava/util/Map;Lcom/datadog/android/rum/internal/domain/scope/RumViewChangedListener;Lcom/datadog/android/core/internal/net/FirstPartyHostHeaderTypeResolver;Lcom/datadog/android/rum/internal/vitals/VitalMonitor;Lcom/datadog/android/rum/internal/vitals/VitalMonitor;Lcom/datadog/android/rum/internal/vitals/VitalMonitor;Lcom/datadog/android/rum/internal/FeaturesContextResolver;Lcom/datadog/android/rum/internal/domain/scope/RumViewType;ZFLcom/datadog/android/rum/internal/metric/interactiontonextview/InteractionToNextViewMetricResolver;Lcom/datadog/android/rum/internal/metric/networksettled/NetworkSettledMetricResolver;Lcom/datadog/android/rum/internal/metric/slowframes/SlowFramesListener;Lcom/datadog/android/rum/internal/metric/ViewMetricDispatcher;Lcom/datadog/android/rum/RumSessionType;Lcom/datadog/android/rum/internal/domain/accessibility/AccessibilitySnapshotManager;Lcom/datadog/android/rum/internal/domain/InfoProvider;Lcom/datadog/android/rum/internal/domain/InfoProvider;Lcom/datadog/android/rum/internal/instrumentation/insights/InsightsCollector;Lcom/datadog/android/internal/heatmaps/HeatmapIdentifierRegistry;)V", "actionCount", "", "activeActionScope", "getActiveActionScope$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/internal/domain/scope/RumScope;", "setActiveActionScope$dd_sdk_android_rum_release", "(Lcom/datadog/android/rum/internal/domain/scope/RumScope;)V", "activeResourceScopes", "", "getActiveResourceScopes$dd_sdk_android_rum_release", "()Ljava/util/Map;", "cpuTicks", "", "Ljava/lang/Double;", "cpuVitalListener", "Lcom/datadog/android/rum/internal/vitals/VitalListener;", "getCpuVitalListener$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/internal/vitals/VitalListener;", "setCpuVitalListener$dd_sdk_android_rum_release", "(Lcom/datadog/android/rum/internal/vitals/VitalListener;)V", "getCpuVitalMonitor$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/internal/vitals/VitalMonitor;", "crashCount", "customTimings", "getCustomTimings$dd_sdk_android_rum_release", "errorCount", "eventTimestamp", "getEventTimestamp$dd_sdk_android_rum_release", "()J", "externalRefreshRateInfo", "Lcom/datadog/android/rum/internal/vitals/VitalInfo;", "featureFlags", "getFeatureFlags$dd_sdk_android_rum_release", "getFirstPartyHostHeaderTypeResolver$dd_sdk_android_rum_release", "()Lcom/datadog/android/core/internal/net/FirstPartyHostHeaderTypeResolver;", "frameRateVitalListener", "getFrameRateVitalListener$dd_sdk_android_rum_release", "setFrameRateVitalListener$dd_sdk_android_rum_release", "getFrameRateVitalMonitor$dd_sdk_android_rum_release", "frozenFrameCount", "frustrationCount", "", "hasReplay", "getHasReplay$dd_sdk_android_rum_release", "()Z", "setHasReplay$dd_sdk_android_rum_release", "(Z)V", "internalAttributes", "getKey$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/internal/domain/scope/RumScopeKey;", "lastFrameRateInfo", "lastMemoryInfo", "longTaskCount", "memoizedParentAttributes", "memoryVitalListener", "getMemoryVitalListener$dd_sdk_android_rum_release", "setMemoryVitalListener$dd_sdk_android_rum_release", "getMemoryVitalMonitor$dd_sdk_android_rum_release", "getParentScope", "pendingActionCount", "getPendingActionCount$dd_sdk_android_rum_release", "setPendingActionCount$dd_sdk_android_rum_release", "(J)V", "pendingErrorCount", "getPendingErrorCount$dd_sdk_android_rum_release", "setPendingErrorCount$dd_sdk_android_rum_release", "pendingFrozenFrameCount", "getPendingFrozenFrameCount$dd_sdk_android_rum_release", "setPendingFrozenFrameCount$dd_sdk_android_rum_release", "pendingLongTaskCount", "getPendingLongTaskCount$dd_sdk_android_rum_release", "setPendingLongTaskCount$dd_sdk_android_rum_release", "pendingResourceCount", "getPendingResourceCount$dd_sdk_android_rum_release", "setPendingResourceCount$dd_sdk_android_rum_release", "performanceMetrics", "Lcom/datadog/android/rum/RumPerformanceMetric;", "resourceCount", "getSampleRate$dd_sdk_android_rum_release", "()F", "serverTimeOffsetInMs", RumSessionScope.RUM_SESSION_ID_BUS_MESSAGE_KEY, "startedNanos", "stopped", "getStopped$dd_sdk_android_rum_release", "setStopped$dd_sdk_android_rum_release", "stoppedNanos", "getStoppedNanos$dd_sdk_android_rum_release", "setStoppedNanos$dd_sdk_android_rum_release", "getType$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/internal/domain/scope/RumViewType;", ImagesContract.URL, "getUrl$dd_sdk_android_rum_release", "()Ljava/lang/String;", "version", "getVersion$dd_sdk_android_rum_release", "setVersion$dd_sdk_android_rum_release", "viewAttributes", "getViewAttributes$dd_sdk_android_rum_release", RumEventMeta.VIEW_ID_KEY, "getViewId$dd_sdk_android_rum_release", "viewLoadingTime", "getViewLoadingTime$dd_sdk_android_rum_release", "()Ljava/lang/Long;", "setViewLoadingTime$dd_sdk_android_rum_release", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "delegateEventToAction", "", "event", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "writeScope", "Lkotlin/Function1;", "Lcom/datadog/android/api/storage/EventBatchWriter;", "Lcom/datadog/android/api/feature/EventWriteScope;", "writer", "Lcom/datadog/android/api/storage/DataWriter;", "delegateEventToChildren", "delegateEventToResources", "getCustomAttributes", "getRumContext", "Lcom/datadog/android/rum/internal/domain/RumContext;", "handleEvent", "isActive", "isViewComplete", "logSynthetics", "value", "newVitalEvent", "Lcom/datadog/android/rum/model/VitalOperationStepEvent;", "vitalId", "name", "operationKey", "stepType", "Lcom/datadog/android/rum/model/VitalOperationStepEvent$StepType;", "failureReason", "Lcom/datadog/android/rum/model/VitalOperationStepEvent$FailureReason;", "eventAttributes", "rumContext", "onActionDropped", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ActionDropped;", "onActionSent", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ActionSent;", "onAddCustomTiming", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddCustomTiming;", "onAddError", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddError;", "onAddFeatureFlagEvaluation", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddFeatureFlagEvaluation;", "onAddFeatureFlagEvaluations", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddFeatureFlagEvaluations;", "onAddLongTask", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddLongTask;", "onAddViewAttributes", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddViewAttributes;", "onAddViewLoadingTime", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddViewLoadingTime;", "onErrorDropped", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ErrorDropped;", "onErrorSent", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ErrorSent;", "onLongTaskDropped", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$LongTaskDropped;", "onLongTaskSent", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$LongTaskSent;", "onRemoveViewAttributes", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$RemoveViewAttributes;", "onResourceDropped", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ResourceDropped;", "onResourceSent", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ResourceSent;", "onSetInternalViewAttribute", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$SetInternalViewAttribute;", "onStartAction", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StartAction;", "onStartOperation", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StartOperation;", "onStartResource", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StartResource;", "onStartView", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StartView;", "onStopOperation", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopOperation;", "onStopSession", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopSession;", "onStopView", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopView;", "onUpdateExternalRefreshRate", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$UpdateExternalRefreshRate;", "onUpdatePerformanceMetric", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$UpdatePerformanceMetric;", "renew", "newEventTime", "renew$dd_sdk_android_rum_release", "resolveCustomTimings", "Lcom/datadog/android/rum/model/ViewEvent$CustomTimings;", "resolveErrorProfilingStatus", "Lcom/datadog/android/rum/model/ErrorEvent$Profiling;", "resolveLongTaskProfilingStatus", "Lcom/datadog/android/rum/model/LongTaskEvent$Profiling;", "resolveRefreshRateInfo", "refreshRateInfo", "(Lcom/datadog/android/rum/internal/vitals/VitalInfo;)Ljava/lang/Boolean;", "resolveViewDuration", "resolveViewProfilingStatus", "Lcom/datadog/android/rum/model/ViewEvent$Profiling;", "resolveVitalOperationStepProfilingStatus", "Lcom/datadog/android/rum/model/VitalOperationStepEvent$Profiling;", "sendProfilingRumOperationEvent", "eventName", "sendViewChanged", "sendViewUpdate", MixedWebViewEventConsumer.EVENT_TYPE_KEY, "Lcom/datadog/android/api/storage/EventType;", "sendViewUpdate$dd_sdk_android_rum_release", "stopScope", "sideEffect", "Lkotlin/Function0;", "updateViewLoadingTime", "tryFrom", "Lcom/datadog/android/rum/model/ErrorEvent$Category;", "Lcom/datadog/android/rum/model/ErrorEvent$Category$Companion;", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class RumViewScope implements RumScope {
    public static final String ACTION_DROPPED_WARNING = "RUM Action (%s on %s) was dropped, because another action is still active for the same view";
    public static final String ADDING_VIEW_LOADING_TIME_DEBUG_MESSAGE_FORMAT = "View loading time %dns added to the view %s";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long FROZEN_FRAME_THRESHOLD_NS;
    public static final String NEGATIVE_DURATION_WARNING_MESSAGE = "The computed duration for the view: %s was negative. In order to keep the view we forced it to 1ns.";
    private static final long ONE_SECOND_NS;
    public static final String OVERWRITING_VIEW_LOADING_TIME_WARNING_MESSAGE_FORMAT = "View loading time already exists for the view %s. Replacing the existing %d ns view loading time with the new %d ns loading time.";
    public static final String SESSION_REPLAY_SAMPLE_RATE_KEY = "session_replay_sample_rate";
    public static final int SLOW_RENDERED_THRESHOLD_FPS = 55;
    public static final String TRACE_SAMPLE_RATE = "okhttp_interceptor_sample_rate";
    public static final String ZERO_DURATION_WARNING_MESSAGE = "The computed duration for the view: %s was 0. In order to keep the view we forced it to 1ns.";
    private final AccessibilitySnapshotManager accessibilitySnapshotManager;
    private long actionCount;
    private RumScope activeActionScope;
    private final Map<Object, RumScope> activeResourceScopes;
    private final InfoProvider<BatteryInfo> batteryInfoProvider;
    private Double cpuTicks;
    private VitalListener cpuVitalListener;
    private final VitalMonitor cpuVitalMonitor;
    private long crashCount;
    private final Map<String, Long> customTimings;
    private final InfoProvider<DisplayInfo> displayInfoProvider;
    private long errorCount;
    private final long eventTimestamp;
    private VitalInfo externalRefreshRateInfo;
    private final Map<String, Object> featureFlags;
    private final FeaturesContextResolver featuresContextResolver;
    private final FirstPartyHostHeaderTypeResolver firstPartyHostHeaderTypeResolver;
    private VitalListener frameRateVitalListener;
    private final VitalMonitor frameRateVitalMonitor;
    private long frozenFrameCount;
    private int frustrationCount;
    private boolean hasReplay;
    private final HeatmapIdentifierRegistry heatmapIdentifierRegistry;
    private final Map<String, Object> initialAttributes;
    private final InsightsCollector insightsCollector;
    private final InteractionToNextViewMetricResolver interactionToNextViewMetricResolver;
    private final Map<String, Object> internalAttributes;
    private final RumScopeKey key;
    private VitalInfo lastFrameRateInfo;
    private VitalInfo lastMemoryInfo;
    private long longTaskCount;
    private Map<String, ? extends Object> memoizedParentAttributes;
    private VitalListener memoryVitalListener;
    private final VitalMonitor memoryVitalMonitor;
    private final NetworkSettledMetricResolver networkSettledMetricResolver;
    private final RumScope parentScope;
    private long pendingActionCount;
    private long pendingErrorCount;
    private long pendingFrozenFrameCount;
    private long pendingLongTaskCount;
    private long pendingResourceCount;
    private final Map<RumPerformanceMetric, VitalInfo> performanceMetrics;
    private long resourceCount;
    private final RumSessionType rumSessionTypeOverride;
    private final float sampleRate;
    private final InternalSdkCore sdkCore;
    private final long serverTimeOffsetInMs;
    private final SessionMetricDispatcher sessionEndedMetricDispatcher;
    private final String sessionId;
    private final SlowFramesListener slowFramesListener;
    private final long startedNanos;
    private boolean stopped;
    private long stoppedNanos;
    private final boolean trackFrustrations;
    private final RumViewType type;
    private final String url;
    private long version;
    private final Map<String, Object> viewAttributes;
    private final RumViewChangedListener viewChangedListener;
    private final ViewMetricDispatcher viewEndedMetricDispatcher;
    private final String viewId;
    private Long viewLoadingTime;

    public RumViewScope(RumScope parentScope, InternalSdkCore sdkCore, SessionMetricDispatcher sessionEndedMetricDispatcher, RumScopeKey key, Time eventTime, Map<String, ? extends Object> initialAttributes, RumViewChangedListener rumViewChangedListener, FirstPartyHostHeaderTypeResolver firstPartyHostHeaderTypeResolver, VitalMonitor cpuVitalMonitor, VitalMonitor memoryVitalMonitor, VitalMonitor frameRateVitalMonitor, FeaturesContextResolver featuresContextResolver, RumViewType type, boolean z, float f, InteractionToNextViewMetricResolver interactionToNextViewMetricResolver, NetworkSettledMetricResolver networkSettledMetricResolver, SlowFramesListener slowFramesListener, ViewMetricDispatcher viewEndedMetricDispatcher, RumSessionType rumSessionType, AccessibilitySnapshotManager accessibilitySnapshotManager, InfoProvider<BatteryInfo> batteryInfoProvider, InfoProvider<DisplayInfo> displayInfoProvider, InsightsCollector insightsCollector, HeatmapIdentifierRegistry heatmapIdentifierRegistry) {
        Intrinsics.checkNotNullParameter(parentScope, "parentScope");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(sessionEndedMetricDispatcher, "sessionEndedMetricDispatcher");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(eventTime, "eventTime");
        Intrinsics.checkNotNullParameter(initialAttributes, "initialAttributes");
        Intrinsics.checkNotNullParameter(firstPartyHostHeaderTypeResolver, "firstPartyHostHeaderTypeResolver");
        Intrinsics.checkNotNullParameter(cpuVitalMonitor, "cpuVitalMonitor");
        Intrinsics.checkNotNullParameter(memoryVitalMonitor, "memoryVitalMonitor");
        Intrinsics.checkNotNullParameter(frameRateVitalMonitor, "frameRateVitalMonitor");
        Intrinsics.checkNotNullParameter(featuresContextResolver, "featuresContextResolver");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(interactionToNextViewMetricResolver, "interactionToNextViewMetricResolver");
        Intrinsics.checkNotNullParameter(networkSettledMetricResolver, "networkSettledMetricResolver");
        Intrinsics.checkNotNullParameter(viewEndedMetricDispatcher, "viewEndedMetricDispatcher");
        Intrinsics.checkNotNullParameter(accessibilitySnapshotManager, "accessibilitySnapshotManager");
        Intrinsics.checkNotNullParameter(batteryInfoProvider, "batteryInfoProvider");
        Intrinsics.checkNotNullParameter(displayInfoProvider, "displayInfoProvider");
        Intrinsics.checkNotNullParameter(insightsCollector, "insightsCollector");
        this.parentScope = parentScope;
        this.sdkCore = sdkCore;
        this.sessionEndedMetricDispatcher = sessionEndedMetricDispatcher;
        this.key = key;
        this.initialAttributes = initialAttributes;
        this.viewChangedListener = rumViewChangedListener;
        this.firstPartyHostHeaderTypeResolver = firstPartyHostHeaderTypeResolver;
        this.cpuVitalMonitor = cpuVitalMonitor;
        this.memoryVitalMonitor = memoryVitalMonitor;
        this.frameRateVitalMonitor = frameRateVitalMonitor;
        this.featuresContextResolver = featuresContextResolver;
        this.type = type;
        this.trackFrustrations = z;
        this.sampleRate = f;
        this.interactionToNextViewMetricResolver = interactionToNextViewMetricResolver;
        this.networkSettledMetricResolver = networkSettledMetricResolver;
        this.slowFramesListener = slowFramesListener;
        this.viewEndedMetricDispatcher = viewEndedMetricDispatcher;
        this.rumSessionTypeOverride = rumSessionType;
        this.accessibilitySnapshotManager = accessibilitySnapshotManager;
        this.batteryInfoProvider = batteryInfoProvider;
        this.displayInfoProvider = displayInfoProvider;
        this.insightsCollector = insightsCollector;
        this.heatmapIdentifierRegistry = heatmapIdentifierRegistry;
        this.url = StringsKt.replace$default(key.getUrl(), FilenameUtils.EXTENSION_SEPARATOR, '/', false, 4, (Object) null);
        this.viewAttributes = MapsKt.toMutableMap(initialAttributes);
        this.internalAttributes = new LinkedHashMap();
        this.memoizedParentAttributes = MapsKt.emptyMap();
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        this.viewId = string;
        RumContext rumContext = getParentScope().getInitialContext();
        if (rumContext.getSyntheticsTestId() != null) {
            logSynthetics("_dd.application.id", rumContext.getApplicationId());
            logSynthetics("_dd.session.id", rumContext.getSessionId());
            logSynthetics("_dd.view.id", string);
        }
        this.sessionId = rumContext.getSessionId();
        long nanoTime = eventTime.getNanoTime();
        this.startedNanos = nanoTime;
        this.stoppedNanos = eventTime.getNanoTime();
        long serverTimeOffsetMs = sdkCore.getTime().getServerTimeOffsetMs();
        this.serverTimeOffsetInMs = serverTimeOffsetMs;
        this.eventTimestamp = eventTime.getTimestamp() + serverTimeOffsetMs;
        this.activeResourceScopes = new LinkedHashMap();
        this.version = 1L;
        this.customTimings = new LinkedHashMap();
        this.featureFlags = new LinkedHashMap();
        this.cpuVitalListener = new VitalListener() { // from class: com.datadog.android.rum.internal.domain.scope.RumViewScope$cpuVitalListener$1
            private double initialTickCount = Double.NaN;

            @Override // com.datadog.android.rum.internal.vitals.VitalListener
            public void onVitalUpdate(VitalInfo info) {
                Intrinsics.checkNotNullParameter(info, "info");
                if (Double.isNaN(this.initialTickCount)) {
                    this.initialTickCount = info.getMaxValue();
                    return;
                }
                this.this$0.cpuTicks = Double.valueOf(info.getMaxValue() - this.initialTickCount);
                this.this$0.insightsCollector.onCpuVital(this.this$0.cpuTicks);
            }
        };
        this.memoryVitalListener = new VitalListener() { // from class: com.datadog.android.rum.internal.domain.scope.RumViewScope$memoryVitalListener$1
            @Override // com.datadog.android.rum.internal.vitals.VitalListener
            public void onVitalUpdate(VitalInfo info) {
                Intrinsics.checkNotNullParameter(info, "info");
                this.this$0.lastMemoryInfo = info;
                InsightsCollector insightsCollector2 = this.this$0.insightsCollector;
                VitalInfo vitalInfo = this.this$0.lastMemoryInfo;
                insightsCollector2.onMemoryVital(vitalInfo != null ? Double.valueOf(vitalInfo.getMeanValue()) : null);
            }
        };
        this.frameRateVitalListener = new VitalListener() { // from class: com.datadog.android.rum.internal.domain.scope.RumViewScope$frameRateVitalListener$1
            @Override // com.datadog.android.rum.internal.vitals.VitalListener
            public void onVitalUpdate(VitalInfo info) {
                Intrinsics.checkNotNullParameter(info, "info");
                this.this$0.lastFrameRateInfo = info;
            }
        };
        this.performanceMetrics = new LinkedHashMap();
        cpuVitalMonitor.register(this.cpuVitalListener);
        memoryVitalMonitor.register(this.memoryVitalListener);
        frameRateVitalMonitor.register(this.frameRateVitalListener);
        networkSettledMetricResolver.viewWasCreated(eventTime.getNanoTime());
        interactionToNextViewMetricResolver.onViewCreated(string, eventTime.getNanoTime());
        if (slowFramesListener != null) {
            slowFramesListener.onViewCreated(string, nanoTime);
        }
        insightsCollector.onNewView(key.getUrl());
    }

    @Override // com.datadog.android.rum.internal.domain.scope.RumScope
    public RumScope getParentScope() {
        return this.parentScope;
    }

    /* JADX INFO: renamed from: getKey$dd_sdk_android_rum_release, reason: from getter */
    public final RumScopeKey getKey() {
        return this.key;
    }

    /* JADX INFO: renamed from: getFirstPartyHostHeaderTypeResolver$dd_sdk_android_rum_release, reason: from getter */
    public final FirstPartyHostHeaderTypeResolver getFirstPartyHostHeaderTypeResolver() {
        return this.firstPartyHostHeaderTypeResolver;
    }

    /* JADX INFO: renamed from: getCpuVitalMonitor$dd_sdk_android_rum_release, reason: from getter */
    public final VitalMonitor getCpuVitalMonitor() {
        return this.cpuVitalMonitor;
    }

    /* JADX INFO: renamed from: getMemoryVitalMonitor$dd_sdk_android_rum_release, reason: from getter */
    public final VitalMonitor getMemoryVitalMonitor() {
        return this.memoryVitalMonitor;
    }

    /* JADX INFO: renamed from: getFrameRateVitalMonitor$dd_sdk_android_rum_release, reason: from getter */
    public final VitalMonitor getFrameRateVitalMonitor() {
        return this.frameRateVitalMonitor;
    }

    public /* synthetic */ RumViewScope(RumScope rumScope, InternalSdkCore internalSdkCore, SessionMetricDispatcher sessionMetricDispatcher, RumScopeKey rumScopeKey, Time time, Map map, RumViewChangedListener rumViewChangedListener, FirstPartyHostHeaderTypeResolver firstPartyHostHeaderTypeResolver, VitalMonitor vitalMonitor, VitalMonitor vitalMonitor2, VitalMonitor vitalMonitor3, FeaturesContextResolver featuresContextResolver, RumViewType rumViewType, boolean z, float f, InteractionToNextViewMetricResolver interactionToNextViewMetricResolver, NetworkSettledMetricResolver networkSettledMetricResolver, SlowFramesListener slowFramesListener, ViewMetricDispatcher viewMetricDispatcher, RumSessionType rumSessionType, AccessibilitySnapshotManager accessibilitySnapshotManager, InfoProvider infoProvider, InfoProvider infoProvider2, InsightsCollector insightsCollector, HeatmapIdentifierRegistry heatmapIdentifierRegistry, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(rumScope, internalSdkCore, sessionMetricDispatcher, rumScopeKey, time, map, rumViewChangedListener, firstPartyHostHeaderTypeResolver, vitalMonitor, vitalMonitor2, vitalMonitor3, (i & 2048) != 0 ? new FeaturesContextResolver() : featuresContextResolver, (i & 4096) != 0 ? RumViewType.FOREGROUND : rumViewType, z, f, interactionToNextViewMetricResolver, networkSettledMetricResolver, slowFramesListener, viewMetricDispatcher, rumSessionType, accessibilitySnapshotManager, infoProvider, infoProvider2, insightsCollector, heatmapIdentifierRegistry);
    }

    /* JADX INFO: renamed from: getType$dd_sdk_android_rum_release, reason: from getter */
    public final RumViewType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: getSampleRate$dd_sdk_android_rum_release, reason: from getter */
    public final float getSampleRate() {
        return this.sampleRate;
    }

    /* JADX INFO: renamed from: getUrl$dd_sdk_android_rum_release, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final Map<String, Object> getViewAttributes$dd_sdk_android_rum_release() {
        return this.viewAttributes;
    }

    /* JADX INFO: renamed from: getViewId$dd_sdk_android_rum_release, reason: from getter */
    public final String getViewId() {
        return this.viewId;
    }

    /* JADX INFO: renamed from: getStoppedNanos$dd_sdk_android_rum_release, reason: from getter */
    public final long getStoppedNanos() {
        return this.stoppedNanos;
    }

    public final void setStoppedNanos$dd_sdk_android_rum_release(long j) {
        this.stoppedNanos = j;
    }

    /* JADX INFO: renamed from: getViewLoadingTime$dd_sdk_android_rum_release, reason: from getter */
    public final Long getViewLoadingTime() {
        return this.viewLoadingTime;
    }

    public final void setViewLoadingTime$dd_sdk_android_rum_release(Long l) {
        this.viewLoadingTime = l;
    }

    /* JADX INFO: renamed from: getEventTimestamp$dd_sdk_android_rum_release, reason: from getter */
    public final long getEventTimestamp() {
        return this.eventTimestamp;
    }

    /* JADX INFO: renamed from: getActiveActionScope$dd_sdk_android_rum_release, reason: from getter */
    public final RumScope getActiveActionScope() {
        return this.activeActionScope;
    }

    public final void setActiveActionScope$dd_sdk_android_rum_release(RumScope rumScope) {
        this.activeActionScope = rumScope;
    }

    public final Map<Object, RumScope> getActiveResourceScopes$dd_sdk_android_rum_release() {
        return this.activeResourceScopes;
    }

    /* JADX INFO: renamed from: getPendingResourceCount$dd_sdk_android_rum_release, reason: from getter */
    public final long getPendingResourceCount() {
        return this.pendingResourceCount;
    }

    public final void setPendingResourceCount$dd_sdk_android_rum_release(long j) {
        this.pendingResourceCount = j;
    }

    /* JADX INFO: renamed from: getPendingActionCount$dd_sdk_android_rum_release, reason: from getter */
    public final long getPendingActionCount() {
        return this.pendingActionCount;
    }

    public final void setPendingActionCount$dd_sdk_android_rum_release(long j) {
        this.pendingActionCount = j;
    }

    /* JADX INFO: renamed from: getPendingErrorCount$dd_sdk_android_rum_release, reason: from getter */
    public final long getPendingErrorCount() {
        return this.pendingErrorCount;
    }

    public final void setPendingErrorCount$dd_sdk_android_rum_release(long j) {
        this.pendingErrorCount = j;
    }

    /* JADX INFO: renamed from: getPendingLongTaskCount$dd_sdk_android_rum_release, reason: from getter */
    public final long getPendingLongTaskCount() {
        return this.pendingLongTaskCount;
    }

    public final void setPendingLongTaskCount$dd_sdk_android_rum_release(long j) {
        this.pendingLongTaskCount = j;
    }

    /* JADX INFO: renamed from: getPendingFrozenFrameCount$dd_sdk_android_rum_release, reason: from getter */
    public final long getPendingFrozenFrameCount() {
        return this.pendingFrozenFrameCount;
    }

    public final void setPendingFrozenFrameCount$dd_sdk_android_rum_release(long j) {
        this.pendingFrozenFrameCount = j;
    }

    /* JADX INFO: renamed from: getVersion$dd_sdk_android_rum_release, reason: from getter */
    public final long getVersion() {
        return this.version;
    }

    public final void setVersion$dd_sdk_android_rum_release(long j) {
        this.version = j;
    }

    public final Map<String, Long> getCustomTimings$dd_sdk_android_rum_release() {
        return this.customTimings;
    }

    public final Map<String, Object> getFeatureFlags$dd_sdk_android_rum_release() {
        return this.featureFlags;
    }

    /* JADX INFO: renamed from: getHasReplay$dd_sdk_android_rum_release, reason: from getter */
    public final boolean getHasReplay() {
        return this.hasReplay;
    }

    public final void setHasReplay$dd_sdk_android_rum_release(boolean z) {
        this.hasReplay = z;
    }

    /* JADX INFO: renamed from: getStopped$dd_sdk_android_rum_release, reason: from getter */
    public final boolean getStopped() {
        return this.stopped;
    }

    public final void setStopped$dd_sdk_android_rum_release(boolean z) {
        this.stopped = z;
    }

    /* JADX INFO: renamed from: getCpuVitalListener$dd_sdk_android_rum_release, reason: from getter */
    public final VitalListener getCpuVitalListener() {
        return this.cpuVitalListener;
    }

    public final void setCpuVitalListener$dd_sdk_android_rum_release(VitalListener vitalListener) {
        Intrinsics.checkNotNullParameter(vitalListener, "<set-?>");
        this.cpuVitalListener = vitalListener;
    }

    /* JADX INFO: renamed from: getMemoryVitalListener$dd_sdk_android_rum_release, reason: from getter */
    public final VitalListener getMemoryVitalListener() {
        return this.memoryVitalListener;
    }

    public final void setMemoryVitalListener$dd_sdk_android_rum_release(VitalListener vitalListener) {
        Intrinsics.checkNotNullParameter(vitalListener, "<set-?>");
        this.memoryVitalListener = vitalListener;
    }

    /* JADX INFO: renamed from: getFrameRateVitalListener$dd_sdk_android_rum_release, reason: from getter */
    public final VitalListener getFrameRateVitalListener() {
        return this.frameRateVitalListener;
    }

    public final void setFrameRateVitalListener$dd_sdk_android_rum_release(VitalListener vitalListener) {
        Intrinsics.checkNotNullParameter(vitalListener, "<set-?>");
        this.frameRateVitalListener = vitalListener;
    }

    @Override // com.datadog.android.rum.internal.domain.scope.RumScope
    public RumScope handleEvent(RumRawEvent event, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        Intrinsics.checkNotNullParameter(writeScope, "writeScope");
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (event instanceof RumRawEvent.ResourceSent) {
            onResourceSent((RumRawEvent.ResourceSent) event, datadogContext, writeScope, writer);
        } else if (event instanceof RumRawEvent.ActionSent) {
            onActionSent((RumRawEvent.ActionSent) event, datadogContext, writeScope, writer);
        } else if (event instanceof RumRawEvent.ErrorSent) {
            onErrorSent((RumRawEvent.ErrorSent) event, datadogContext, writeScope, writer);
        } else if (event instanceof RumRawEvent.LongTaskSent) {
            onLongTaskSent((RumRawEvent.LongTaskSent) event, datadogContext, writeScope, writer);
        } else if (event instanceof RumRawEvent.ResourceDropped) {
            onResourceDropped((RumRawEvent.ResourceDropped) event);
        } else if (event instanceof RumRawEvent.ActionDropped) {
            onActionDropped((RumRawEvent.ActionDropped) event);
        } else if (event instanceof RumRawEvent.ErrorDropped) {
            onErrorDropped((RumRawEvent.ErrorDropped) event);
        } else if (event instanceof RumRawEvent.LongTaskDropped) {
            onLongTaskDropped((RumRawEvent.LongTaskDropped) event);
        } else if (event instanceof RumRawEvent.StartView) {
            onStartView((RumRawEvent.StartView) event, datadogContext, writeScope, writer);
        } else if (event instanceof RumRawEvent.StopView) {
            onStopView((RumRawEvent.StopView) event, datadogContext, writeScope, writer);
        } else if (event instanceof RumRawEvent.StartAction) {
            onStartAction((RumRawEvent.StartAction) event, datadogContext, writeScope, writer);
        } else if (event instanceof RumRawEvent.StartResource) {
            onStartResource((RumRawEvent.StartResource) event, datadogContext, writeScope, writer);
        } else if (event instanceof RumRawEvent.AddError) {
            onAddError((RumRawEvent.AddError) event, datadogContext, writeScope, writer);
        } else if (event instanceof RumRawEvent.AddLongTask) {
            onAddLongTask((RumRawEvent.AddLongTask) event, datadogContext, writeScope, writer);
        } else if (event instanceof RumRawEvent.SetInternalViewAttribute) {
            onSetInternalViewAttribute((RumRawEvent.SetInternalViewAttribute) event);
        } else if (event instanceof RumRawEvent.AddFeatureFlagEvaluation) {
            onAddFeatureFlagEvaluation((RumRawEvent.AddFeatureFlagEvaluation) event, datadogContext, writeScope, writer);
        } else if (event instanceof RumRawEvent.AddFeatureFlagEvaluations) {
            onAddFeatureFlagEvaluations((RumRawEvent.AddFeatureFlagEvaluations) event, datadogContext, writeScope, writer);
        } else if (event instanceof RumRawEvent.AddCustomTiming) {
            onAddCustomTiming((RumRawEvent.AddCustomTiming) event, datadogContext, writeScope, writer);
        } else if (event instanceof RumRawEvent.StopSession) {
            onStopSession((RumRawEvent.StopSession) event, datadogContext, writeScope, writer);
        } else if (event instanceof RumRawEvent.UpdatePerformanceMetric) {
            onUpdatePerformanceMetric((RumRawEvent.UpdatePerformanceMetric) event);
        } else if (event instanceof RumRawEvent.UpdateExternalRefreshRate) {
            onUpdateExternalRefreshRate((RumRawEvent.UpdateExternalRefreshRate) event);
        } else if (event instanceof RumRawEvent.AddViewLoadingTime) {
            onAddViewLoadingTime((RumRawEvent.AddViewLoadingTime) event, datadogContext, writeScope, writer);
        } else if (event instanceof RumRawEvent.AddViewAttributes) {
            onAddViewAttributes((RumRawEvent.AddViewAttributes) event);
        } else if (event instanceof RumRawEvent.RemoveViewAttributes) {
            onRemoveViewAttributes((RumRawEvent.RemoveViewAttributes) event);
        } else if (event instanceof RumRawEvent.StartOperation) {
            onStartOperation((RumRawEvent.StartOperation) event, datadogContext, writeScope, writer);
        } else if (event instanceof RumRawEvent.StopOperation) {
            onStopOperation((RumRawEvent.StopOperation) event, datadogContext, writeScope, writer);
        } else {
            delegateEventToChildren(event, datadogContext, writeScope, writer);
        }
        if (isViewComplete()) {
            FeatureSdkCore.DefaultImpls.updateFeatureContext$default(this.sdkCore, "session-replay", false, new Function1<Map<String, Object>, Unit>() { // from class: com.datadog.android.rum.internal.domain.scope.RumViewScope.handleEvent.1
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
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.remove(RumViewScope.this.getViewId());
                }
            }, 2, null);
            return null;
        }
        return this;
    }

    private final void onStartOperation(final RumRawEvent.StartOperation event, final DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        if (this.stopped) {
            return;
        }
        final String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        final RumContext rumContext = getInitialContext();
        SdkCoreExtKt.newRumEventWriteOperation$default(this.sdkCore, datadogContext, writeScope, writer, null, new Function0<Object>() { // from class: com.datadog.android.rum.internal.domain.scope.RumViewScope.onStartOperation.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                RumViewScope rumViewScope = RumViewScope.this;
                String str = string;
                RumRawEvent.StartOperation startOperation = event;
                return rumViewScope.newVitalEvent(str, startOperation, datadogContext, startOperation.getName(), event.getOperationKey(), VitalOperationStepEvent.StepType.START, null, event.getAttributes(), rumContext);
            }
        }, 8, null).onSuccess(new Function1<AdvancedRumMonitor, Unit>() { // from class: com.datadog.android.rum.internal.domain.scope.RumViewScope.onStartOperation.2
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
                RumViewScope.this.sendProfilingRumOperationEvent(rumContext, string, event.getName(), event.getEventTime().getTimestamp());
            }
        }).submit();
        sendViewUpdate$dd_sdk_android_rum_release$default(this, event, datadogContext, writeScope, writer, null, 16, null);
    }

    private final void onStopOperation(final RumRawEvent.StopOperation event, final DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        if (this.stopped) {
            return;
        }
        final String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        final RumContext rumContext = getInitialContext();
        SdkCoreExtKt.newRumEventWriteOperation$default(this.sdkCore, datadogContext, writeScope, writer, null, new Function0<Object>() { // from class: com.datadog.android.rum.internal.domain.scope.RumViewScope.onStopOperation.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                RumViewScope rumViewScope = RumViewScope.this;
                String str = string;
                RumRawEvent.StopOperation stopOperation = event;
                RumRawEvent.StopOperation stopOperation2 = stopOperation;
                DatadogContext datadogContext2 = datadogContext;
                String name = stopOperation.getName();
                String operationKey = event.getOperationKey();
                VitalOperationStepEvent.StepType stepType = VitalOperationStepEvent.StepType.END;
                FailureReason failureReason = event.getFailureReason();
                return rumViewScope.newVitalEvent(str, stopOperation2, datadogContext2, name, operationKey, stepType, failureReason != null ? RumEventExtKt.toSchemaFailureReason(failureReason) : null, event.getAttributes(), rumContext);
            }
        }, 8, null).onSuccess(new Function1<AdvancedRumMonitor, Unit>() { // from class: com.datadog.android.rum.internal.domain.scope.RumViewScope.onStopOperation.2
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
                RumViewScope.this.sendProfilingRumOperationEvent(rumContext, string, event.getName(), event.getEventTime().getTimestamp());
            }
        }).submit();
        sendViewUpdate$dd_sdk_android_rum_release$default(this, event, datadogContext, writeScope, writer, null, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendProfilingRumOperationEvent(RumContext rumContext, String vitalId, String eventName, long eventTimestamp) {
        FeatureScope feature = this.sdkCore.getFeature("profiling");
        if (feature != null) {
            feature.sendEvent(new ProfilerEvent.RumVitalEvent(vitalId, eventName, ProfilerEvent.RumVitalEvent.Type.OPERATION, eventTimestamp + this.serverTimeOffsetInMs, 0L, new ProfilingRumContext(rumContext.getApplicationId(), rumContext.getSessionId(), rumContext.getViewId(), rumContext.getViewName())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final VitalOperationStepEvent newVitalEvent(String vitalId, RumRawEvent event, DatadogContext datadogContext, String name, String operationKey, VitalOperationStepEvent.StepType stepType, VitalOperationStepEvent.FailureReason failureReason, Map<String, ? extends Object> eventAttributes, RumContext rumContext) {
        VitalOperationStepEvent.VitalOperationStepEventSessionType vital;
        String syntheticsResultId;
        String syntheticsTestId = rumContext.getSyntheticsTestId();
        VitalOperationStepEvent.Plan plan = null;
        Object[] objArr = 0;
        VitalOperationStepEvent.Synthetics synthetics = (syntheticsTestId == null || StringsKt.isBlank(syntheticsTestId) || (syntheticsResultId = rumContext.getSyntheticsResultId()) == null || StringsKt.isBlank(syntheticsResultId)) ? null : new VitalOperationStepEvent.Synthetics(rumContext.getSyntheticsTestId(), rumContext.getSyntheticsResultId(), null, null, 12, null);
        FeaturesContextResolver featuresContextResolver = this.featuresContextResolver;
        String viewId = rumContext.getViewId();
        if (viewId == null) {
            viewId = "";
        }
        boolean zResolveViewHasReplay = featuresContextResolver.resolveViewHasReplay(datadogContext, viewId);
        RumSessionType rumSessionType = this.rumSessionTypeOverride;
        if (rumSessionType != null) {
            vital = RumSessionTypeExtKt.toVital(rumSessionType);
        } else if (synthetics == null) {
            vital = VitalOperationStepEvent.VitalOperationStepEventSessionType.USER;
        } else {
            vital = VitalOperationStepEvent.VitalOperationStepEventSessionType.SYNTHETICS;
        }
        BatteryInfo batteryInfo = (BatteryInfo) this.batteryInfoProvider.getCurrentState();
        DisplayInfo displayInfo = (DisplayInfo) this.displayInfoProvider.getCurrentState();
        UserInfo userInfo = datadogContext.getUserInfo();
        long timestamp = event.getEventTime().getTimestamp() + this.serverTimeOffsetInMs;
        Map mutableMap = MapsKt.toMutableMap(getCustomAttributes());
        mutableMap.putAll(eventAttributes);
        VitalOperationStepEvent.Context context = new VitalOperationStepEvent.Context(mutableMap);
        VitalOperationStepEvent.Dd dd = new VitalOperationStepEvent.Dd(new VitalOperationStepEvent.DdSession(plan, RumEventExtKt.toVitalOperationStepSessionPrecondition(rumContext.getSessionStartReason()), 1, objArr == true ? 1 : 0), new VitalOperationStepEvent.Configuration(Float.valueOf(this.sampleRate), null, null, null, null, 30, null), null, null, resolveVitalOperationStepProfilingStatus(datadogContext), 12, null);
        VitalOperationStepEvent.Application application = new VitalOperationStepEvent.Application(rumContext.getApplicationId(), datadogContext.getDeviceInfo().getLocaleInfo().getCurrentLocale());
        VitalOperationStepEvent.VitalOperationStepEventSession vitalOperationStepEventSession = new VitalOperationStepEvent.VitalOperationStepEventSession(rumContext.getSessionId(), vital, Boolean.valueOf(zResolveViewHasReplay));
        String viewId2 = rumContext.getViewId();
        String str = viewId2 == null ? "" : viewId2;
        String viewName = rumContext.getViewName();
        String viewUrl = rumContext.getViewUrl();
        VitalOperationStepEvent.VitalOperationStepEventView vitalOperationStepEventView = new VitalOperationStepEvent.VitalOperationStepEventView(str, null, viewUrl == null ? "" : viewUrl, viewName, 2, null);
        VitalOperationStepEvent.VitalOperationStepEventSource vitalOperationStepEventSourceTryFromSource = RumEventExtKt.tryFromSource(VitalOperationStepEvent.VitalOperationStepEventSource.INSTANCE, datadogContext.getSource(), this.sdkCore.getInternalLogger());
        AccountInfo accountInfo = datadogContext.getAccountInfo();
        VitalOperationStepEvent.Account account = accountInfo != null ? new VitalOperationStepEvent.Account(accountInfo.getId(), accountInfo.getName(), MapsKt.toMutableMap(accountInfo.getExtraInfo())) : null;
        VitalOperationStepEvent.Usr usr = RuntimeUtilsKt.hasUserData(userInfo) ? new VitalOperationStepEvent.Usr(userInfo.getId(), userInfo.getName(), userInfo.getEmail(), userInfo.getAnonymousId(), MapsKt.toMutableMap(userInfo.getAdditionalProperties())) : null;
        VitalOperationStepEvent.Device device = new VitalOperationStepEvent.Device(RumEventExtKt.toVitalOperationStepSchemaType(datadogContext.getDeviceInfo().getDeviceType()), datadogContext.getDeviceInfo().getDeviceName(), datadogContext.getDeviceInfo().getDeviceModel(), datadogContext.getDeviceInfo().getDeviceBrand(), datadogContext.getDeviceInfo().getArchitecture(), null, datadogContext.getDeviceInfo().getLocaleInfo().getLocales(), datadogContext.getDeviceInfo().getLocaleInfo().getTimeZone(), batteryInfo.getBatteryLevel(), batteryInfo.getLowPowerMode(), displayInfo.getScreenBrightness(), Integer.valueOf(datadogContext.getDeviceInfo().getLogicalCpuCount()), datadogContext.getDeviceInfo().getTotalRam(), datadogContext.getDeviceInfo().isLowRam(), 32, null);
        return new VitalOperationStepEvent(timestamp, application, datadogContext.getService(), datadogContext.getVersion(), String.valueOf(datadogContext.getVersionCode()), datadogContext.getAppBuildId(), DdTagsUtils.INSTANCE.toDdTagsString(datadogContext), vitalOperationStepEventSession, vitalOperationStepEventSourceTryFromSource, vitalOperationStepEventView, usr, account, null, RumEventExtKt.toVitalOperationStepConnectivity(datadogContext.getNetworkInfo()), null, synthetics, null, new VitalOperationStepEvent.Os(datadogContext.getDeviceInfo().getOsName(), datadogContext.getDeviceInfo().getOsVersion(), null, datadogContext.getDeviceInfo().getOsMajorVersion(), 4, 0 == true ? 1 : 0), device, dd, context, null, null, new VitalOperationStepEvent.Vital(vitalId, name, null, operationKey, stepType, failureReason, 4, null), 6377472, null);
    }

    @Override // com.datadog.android.rum.internal.domain.scope.RumScope
    /* JADX INFO: renamed from: getRumContext */
    public RumContext getInitialContext() {
        RumContext rumContext = getParentScope().getInitialContext();
        String str = this.viewId;
        String name = this.key.getName();
        String str2 = this.url;
        RumScope rumScope = this.activeActionScope;
        RumActionScope rumActionScope = rumScope instanceof RumActionScope ? (RumActionScope) rumScope : null;
        return rumContext.copy((32377 & 1) != 0 ? rumContext.applicationId : null, (32377 & 2) != 0 ? rumContext.sessionId : null, (32377 & 4) != 0 ? rumContext.isSessionActive : false, (32377 & 8) != 0 ? rumContext.viewId : str, (32377 & 16) != 0 ? rumContext.viewName : name, (32377 & 32) != 0 ? rumContext.viewUrl : str2, (32377 & 64) != 0 ? rumContext.actionId : rumActionScope != null ? rumActionScope.getActionId() : null, (32377 & 128) != 0 ? rumContext.sessionState : null, (32377 & 256) != 0 ? rumContext.sessionStartReason : null, (32377 & 512) != 0 ? rumContext.viewType : this.type, (32377 & 1024) != 0 ? rumContext.syntheticsTestId : null, (32377 & 2048) != 0 ? rumContext.syntheticsResultId : null, (32377 & 4096) != 0 ? rumContext.viewTimestamp : this.eventTimestamp, (32377 & 8192) != 0 ? rumContext.viewTimestampOffset : this.serverTimeOffsetInMs, (32377 & 16384) != 0 ? rumContext.hasReplay : this.hasReplay, (32377 & 32768) != 0 ? rumContext.sessionSampleRate : 0.0f);
    }

    @Override // com.datadog.android.rum.internal.domain.scope.RumScope
    public Map<String, Object> getCustomAttributes() {
        if (!this.stopped) {
            return MapsKt.plus(getParentScope().getCustomAttributes(), this.viewAttributes);
        }
        return MapsKt.plus(this.memoizedParentAttributes, this.viewAttributes);
    }

    @Override // com.datadog.android.rum.internal.domain.scope.RumScope
    /* JADX INFO: renamed from: isActive */
    public boolean getIsActive() {
        return !this.stopped;
    }

    public final RumViewScope renew$dd_sdk_android_rum_release(Time newEventTime) {
        Intrinsics.checkNotNullParameter(newEventTime, "newEventTime");
        return new RumViewScope(this, this.sdkCore, this.sessionEndedMetricDispatcher, this.key, newEventTime, this.initialAttributes, this.viewChangedListener, this.firstPartyHostHeaderTypeResolver, this.cpuVitalMonitor, this.memoryVitalMonitor, this.frameRateVitalMonitor, this.featuresContextResolver, this.type, this.trackFrustrations, this.sampleRate, this.interactionToNextViewMetricResolver, this.networkSettledMetricResolver, this.slowFramesListener, this.viewEndedMetricDispatcher, this.rumSessionTypeOverride, this.accessibilitySnapshotManager, this.batteryInfoProvider, this.displayInfoProvider, this.insightsCollector, this.heatmapIdentifierRegistry);
    }

    private final void onAddViewLoadingTime(RumRawEvent.AddViewLoadingTime event, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        if (this.stopped) {
            return;
        }
        if (this.viewLoadingTime == null || event.getOverwrite()) {
            updateViewLoadingTime(event, datadogContext, writeScope, writer);
        }
    }

    private final void updateViewLoadingTime(RumRawEvent.AddViewLoadingTime event, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        InternalLogger internalLogger = this.sdkCore.getInternalLogger();
        final String name = this.key.getName();
        final Long l = this.viewLoadingTime;
        final long nanoTime = event.getEventTime().getNanoTime() - this.startedNanos;
        if (l == null) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.DEBUG, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.scope.RumViewScope.updateViewLoadingTime.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, RumViewScope.ADDING_VIEW_LOADING_TIME_DEBUG_MESSAGE_FORMAT, Arrays.copyOf(new Object[]{Long.valueOf(nanoTime), name}, 2));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            InternalLogger.DefaultImpls.logApiUsage$default(internalLogger, 0.0f, new Function0<InternalTelemetryEvent.ApiUsage>() { // from class: com.datadog.android.rum.internal.domain.scope.RumViewScope.updateViewLoadingTime.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final InternalTelemetryEvent.ApiUsage invoke() {
                    return new InternalTelemetryEvent.ApiUsage.AddViewLoadingTime(false, false, false, null, 8, null);
                }
            }, 1, null);
        } else if (event.getOverwrite()) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.scope.RumViewScope.updateViewLoadingTime.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, RumViewScope.OVERWRITING_VIEW_LOADING_TIME_WARNING_MESSAGE_FORMAT, Arrays.copyOf(new Object[]{name, l, Long.valueOf(nanoTime)}, 3));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            InternalLogger.DefaultImpls.logApiUsage$default(internalLogger, 0.0f, new Function0<InternalTelemetryEvent.ApiUsage>() { // from class: com.datadog.android.rum.internal.domain.scope.RumViewScope.updateViewLoadingTime.4
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final InternalTelemetryEvent.ApiUsage invoke() {
                    return new InternalTelemetryEvent.ApiUsage.AddViewLoadingTime(true, false, false, null, 8, null);
                }
            }, 1, null);
        }
        this.viewLoadingTime = Long.valueOf(nanoTime);
        this.viewEndedMetricDispatcher.onViewLoadingTimeResolved(nanoTime);
        sendViewUpdate$dd_sdk_android_rum_release$default(this, event, datadogContext, writeScope, writer, null, 16, null);
    }

    private final void onAddViewAttributes(RumRawEvent.AddViewAttributes event) {
        this.viewAttributes.putAll(event.getAttributes());
    }

    private final void onRemoveViewAttributes(RumRawEvent.RemoveViewAttributes event) {
        Iterator<T> it = event.getAttributes().iterator();
        while (it.hasNext()) {
            this.viewAttributes.remove((String) it.next());
        }
    }

    private final void onStartView(RumRawEvent.StartView event, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        stopScope(event, datadogContext, writeScope, writer, new Function0<Unit>() { // from class: com.datadog.android.rum.internal.domain.scope.RumViewScope.onStartView.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                RumViewScope rumViewScope = RumViewScope.this;
                rumViewScope.memoizedParentAttributes = MapsKt.toMap(rumViewScope.getParentScope().getCustomAttributes());
            }
        });
    }

    private final void onStopView(final RumRawEvent.StopView event, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        RumRawEvent.StopView stopView = event;
        delegateEventToChildren(stopView, datadogContext, writeScope, writer);
        if (!Intrinsics.areEqual(event.getKey().getId(), this.key.getId()) || this.stopped) {
            return;
        }
        stopScope(stopView, datadogContext, writeScope, writer, new Function0<Unit>() { // from class: com.datadog.android.rum.internal.domain.scope.RumViewScope.onStopView.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                RumViewScope.this.getViewAttributes$dd_sdk_android_rum_release().putAll(event.getAttributes());
                RumViewScope rumViewScope = RumViewScope.this;
                rumViewScope.memoizedParentAttributes = MapsKt.toMap(rumViewScope.getParentScope().getCustomAttributes());
            }
        });
    }

    private final void onStartAction(final RumRawEvent.StartAction event, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        delegateEventToChildren(event, datadogContext, writeScope, writer);
        if (this.stopped) {
            return;
        }
        if (event.getType() == RumActionType.CUSTOM && !event.getWaitForStop()) {
            RumScope rumScopeFromEvent = RumActionScope.INSTANCE.fromEvent(this, this.sdkCore, event, this.serverTimeOffsetInMs, this.featuresContextResolver, this.trackFrustrations, this.sampleRate, this.rumSessionTypeOverride, this.insightsCollector, this.heatmapIdentifierRegistry);
            this.pendingActionCount++;
            rumScopeFromEvent.handleEvent(new RumRawEvent.SendCustomActionNow(Time.INSTANCE.now(this.sdkCore.getTimeProvider())), datadogContext, writeScope, writer);
        } else if (this.activeActionScope != null) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.scope.RumViewScope.onStartAction.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, RumViewScope.ACTION_DROPPED_WARNING, Arrays.copyOf(new Object[]{event.getType(), event.getName()}, 2));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        } else {
            this.activeActionScope = RumActionScope.INSTANCE.fromEvent(this, this.sdkCore, event, this.serverTimeOffsetInMs, this.featuresContextResolver, this.trackFrustrations, this.sampleRate, this.rumSessionTypeOverride, this.insightsCollector, this.heatmapIdentifierRegistry);
            this.pendingActionCount++;
        }
    }

    private final void onStartResource(RumRawEvent.StartResource event, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        delegateEventToChildren(event, datadogContext, writeScope, writer);
        if (this.stopped) {
            return;
        }
        this.activeResourceScopes.put(event.getKey(), RumResourceScope.INSTANCE.fromEvent(this, this.sdkCore, event, this.firstPartyHostHeaderTypeResolver, this.serverTimeOffsetInMs, this.featuresContextResolver, this.sampleRate, this.networkSettledMetricResolver, this.rumSessionTypeOverride, this.insightsCollector));
        this.pendingResourceCount++;
    }

    /* JADX WARN: Code duplicated, block: B:58:0x00f5  */
    /* JADX WARN: Type inference failed for: r7v7, types: [T, com.datadog.android.rum.model.ErrorEvent$Profiling] */
    private final void onAddError(final RumRawEvent.AddError event, final DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        final String str;
        String message;
        String message2;
        boolean z;
        Class<?> cls;
        RumRawEvent.AddError addError = event;
        delegateEventToChildren(addError, datadogContext, writeScope, writer);
        if (this.stopped) {
            return;
        }
        final RumContext rumContext = getInitialContext();
        final Map mutableMap = MapsKt.toMutableMap(getCustomAttributes());
        mutableMap.putAll(event.getAttributes());
        Object objRemove = mutableMap.remove(RumAttributes.INTERNAL_ERROR_IS_CRASH);
        String canonicalName = null;
        final boolean z2 = Intrinsics.areEqual((Object) (objRemove instanceof Boolean ? (Boolean) objRemove : null), (Object) true) || event.isFatal();
        Object objRemove2 = mutableMap.remove("_dd.error.fingerprint");
        final String str2 = objRemove2 instanceof String ? (String) objRemove2 : null;
        if (this.crashCount <= 0 || !z2) {
            String type = event.getType();
            if (type == null) {
                Throwable throwable = event.getThrowable();
                if (throwable != null && (cls = throwable.getClass()) != null) {
                    canonicalName = cls.getCanonicalName();
                }
                str = canonicalName;
            } else {
                str = type;
            }
            Throwable throwable2 = event.getThrowable();
            if (throwable2 == null || (message = throwable2.getMessage()) == null) {
                message = "";
            }
            if (!StringsKt.isBlank(message) && !Intrinsics.areEqual(event.getMessage(), message)) {
                message2 = event.getMessage() + ": " + message;
            } else {
                message2 = event.getMessage();
            }
            final Map mutableMap2 = MapsKt.toMutableMap(this.featureFlags);
            EventType eventType = z2 ? EventType.CRASH : EventType.DEFAULT;
            final BatteryInfo batteryInfo = (BatteryInfo) this.batteryInfoProvider.getCurrentState();
            final DisplayInfo displayInfo = (DisplayInfo) this.displayInfoProvider.getCurrentState();
            if (this.hasReplay) {
                z = true;
            } else {
                FeaturesContextResolver featuresContextResolver = this.featuresContextResolver;
                String viewId = rumContext.getViewId();
                if (featuresContextResolver.resolveViewHasReplay(datadogContext, viewId != null ? viewId : "")) {
                    z = true;
                } else {
                    z = false;
                }
            }
            this.hasReplay = z;
            final String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            if ((event.getThrowable() instanceof ANRException) && !z2) {
                objectRef.element = resolveErrorProfilingStatus(datadogContext);
            }
            InternalSdkCore internalSdkCore = this.sdkCore;
            final String str3 = message2;
            Function0<Object> function0 = new Function0<Object>() { // from class: com.datadog.android.rum.internal.domain.scope.RumViewScope.onAddError.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    ErrorEvent.ErrorEventSessionType error;
                    String str4;
                    Long lValueOf;
                    String syntheticsResultId;
                    UserInfo userInfo = datadogContext.getUserInfo();
                    String syntheticsTestId = rumContext.getSyntheticsTestId();
                    ErrorEvent.Plan plan = null;
                    Object[] objArr = 0;
                    ErrorEvent.Synthetics synthetics = (syntheticsTestId == null || StringsKt.isBlank(syntheticsTestId) || (syntheticsResultId = rumContext.getSyntheticsResultId()) == null || StringsKt.isBlank(syntheticsResultId)) ? null : new ErrorEvent.Synthetics(rumContext.getSyntheticsTestId(), rumContext.getSyntheticsResultId(), null, null, 12, null);
                    if (this.rumSessionTypeOverride != null) {
                        error = RumSessionTypeExtKt.toError(this.rumSessionTypeOverride);
                    } else if (synthetics == null) {
                        error = ErrorEvent.ErrorEventSessionType.USER;
                    } else {
                        error = ErrorEvent.ErrorEventSessionType.SYNTHETICS;
                    }
                    String appBuildId = datadogContext.getAppBuildId();
                    long timestamp = this.serverTimeOffsetInMs + event.getEventTime().getTimestamp();
                    ErrorEvent.Context context = new ErrorEvent.Context(mutableMap2);
                    ErrorEvent.ErrorSource schemaSource = RumEventExtKt.toSchemaSource(event.getSource());
                    String stacktrace = event.getStacktrace();
                    if (stacktrace != null) {
                        str4 = stacktrace;
                    } else {
                        Throwable throwable3 = event.getThrowable();
                        if (throwable3 != null) {
                            stacktrace = ThrowableExtKt.loggableStackTrace(throwable3);
                            str4 = stacktrace;
                        } else {
                            str4 = null;
                        }
                    }
                    ErrorEvent.SourceType schemaSourceType = RumEventExtKt.toSchemaSourceType(event.getSourceType());
                    ErrorEvent.Category categoryTryFrom = this.tryFrom(ErrorEvent.Category.INSTANCE, event);
                    List<ThreadDump> threads = event.getThreads();
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(threads, 10));
                    for (ThreadDump threadDump : threads) {
                        arrayList.add(new ErrorEvent.Thread(threadDump.getName(), threadDump.getCrashed(), threadDump.getStack(), threadDump.getState()));
                    }
                    ArrayList arrayList2 = arrayList;
                    if (arrayList2.isEmpty()) {
                        arrayList2 = null;
                    }
                    ArrayList arrayList3 = arrayList2;
                    Long timeSinceAppStartNs = event.getTimeSinceAppStartNs();
                    if (timeSinceAppStartNs != null) {
                        long jLongValue = timeSinceAppStartNs.longValue();
                        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                        lValueOf = Long.valueOf(jLongValue / 1000000);
                    } else {
                        lValueOf = null;
                    }
                    ErrorEvent.Error error2 = new ErrorEvent.Error(string, str3, schemaSource, str4, null, Boolean.valueOf(z2), str2, str, categoryTryFrom, null, null, schemaSourceType, null, arrayList3, null, null, null, null, lValueOf, 251408, null);
                    String actionId = rumContext.getActionId();
                    ErrorEvent.Action action = actionId != null ? new ErrorEvent.Action(CollectionsKt.listOf(actionId)) : null;
                    String viewId2 = rumContext.getViewId();
                    String str5 = viewId2 == null ? "" : viewId2;
                    String viewName = rumContext.getViewName();
                    String viewUrl = rumContext.getViewUrl();
                    ErrorEvent.ErrorEventView errorEventView = new ErrorEvent.ErrorEventView(str5, null, viewUrl == null ? "" : viewUrl, viewName, null, 18, null);
                    ErrorEvent.Usr usr = RuntimeUtilsKt.hasUserData(userInfo) ? new ErrorEvent.Usr(userInfo.getId(), userInfo.getName(), userInfo.getEmail(), userInfo.getAnonymousId(), MapsKt.toMutableMap(userInfo.getAdditionalProperties())) : null;
                    AccountInfo accountInfo = datadogContext.getAccountInfo();
                    return new ErrorEvent(timestamp, new ErrorEvent.Application(rumContext.getApplicationId(), datadogContext.getDeviceInfo().getLocaleInfo().getCurrentLocale()), datadogContext.getService(), datadogContext.getVersion(), String.valueOf(datadogContext.getVersionCode()), appBuildId, DdTagsUtils.INSTANCE.toDdTagsString(datadogContext), new ErrorEvent.ErrorEventSession(rumContext.getSessionId(), error, Boolean.valueOf(this.getHasReplay())), RumEventExtKt.tryFromSource(ErrorEvent.ErrorEventSource.INSTANCE, datadogContext.getSource(), this.sdkCore.getInternalLogger()), errorEventView, usr, accountInfo != null ? new ErrorEvent.Account(accountInfo.getId(), accountInfo.getName(), MapsKt.toMutableMap(accountInfo.getExtraInfo())) : null, null, RumEventExtKt.toErrorConnectivity(datadogContext.getNetworkInfo()), null, synthetics, null, new ErrorEvent.Os(datadogContext.getDeviceInfo().getOsName(), datadogContext.getDeviceInfo().getOsVersion(), null, datadogContext.getDeviceInfo().getOsMajorVersion(), 4, null), new ErrorEvent.Device(RumEventExtKt.toErrorSchemaType(datadogContext.getDeviceInfo().getDeviceType()), datadogContext.getDeviceInfo().getDeviceName(), datadogContext.getDeviceInfo().getDeviceModel(), datadogContext.getDeviceInfo().getDeviceBrand(), datadogContext.getDeviceInfo().getArchitecture(), null, datadogContext.getDeviceInfo().getLocaleInfo().getLocales(), datadogContext.getDeviceInfo().getLocaleInfo().getTimeZone(), batteryInfo.getBatteryLevel(), batteryInfo.getLowPowerMode(), displayInfo.getScreenBrightness(), Integer.valueOf(datadogContext.getDeviceInfo().getLogicalCpuCount()), datadogContext.getDeviceInfo().getTotalRam(), datadogContext.getDeviceInfo().isLowRam(), 32, null), new ErrorEvent.Dd(new ErrorEvent.DdSession(plan, RumEventExtKt.toErrorSessionPrecondition(rumContext.getSessionStartReason()), 1, objArr == true ? 1 : 0), new ErrorEvent.Configuration(Float.valueOf(this.getSampleRate()), null, null, 0 == true ? 1 : 0, null, 30, null), 0 == true ? 1 : 0, 0 == true ? 1 : 0, objectRef.element, 12, null), new ErrorEvent.Context(mutableMap), null, action, null, error2, null, context, 44126208, null);
                }
            };
            boolean z3 = z2;
            WriteOperation writeOperationNewRumEventWriteOperation = SdkCoreExtKt.newRumEventWriteOperation(internalSdkCore, datadogContext, writeScope, writer, eventType, function0);
            if (!z3) {
                writeOperationNewRumEventWriteOperation.onError(new Function1<AdvancedRumMonitor, Unit>() { // from class: com.datadog.android.rum.internal.domain.scope.RumViewScope$onAddError$2$1
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
                        String viewId2 = rumContext.getViewId();
                        if (viewId2 == null) {
                            viewId2 = "";
                        }
                        it.eventDropped(viewId2, new StorageEvent.Error(null, null, 3, null));
                    }
                });
                writeOperationNewRumEventWriteOperation.onSuccess(new Function1<AdvancedRumMonitor, Unit>() { // from class: com.datadog.android.rum.internal.domain.scope.RumViewScope$onAddError$2$2
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
                        String viewId2 = rumContext.getViewId();
                        if (viewId2 == null) {
                            viewId2 = "";
                        }
                        it.eventSent(viewId2, new StorageEvent.Error(null, null, 3, null));
                        if (event.getThrowable() instanceof ANRException) {
                            long timestamp = (event.getEventTime().getTimestamp() + this.serverTimeOffsetInMs) - 5000;
                            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                            FeatureScope feature = this.sdkCore.getFeature("profiling");
                            if (feature != null) {
                                feature.sendEvent(new ProfilerEvent.RumAnrEvent(string, timestamp, 5000000000L, new ProfilingRumContext(rumContext.getApplicationId(), rumContext.getSessionId(), rumContext.getViewId(), rumContext.getViewName())));
                            }
                            this.sdkCore.writeLastFatalAnrSent(event.getEventTime().getTimestamp());
                        }
                    }
                });
            }
            writeOperationNewRumEventWriteOperation.submit();
            if (z3) {
                this.errorCount++;
                this.crashCount++;
                sendViewUpdate$dd_sdk_android_rum_release(addError, datadogContext, writeScope, writer, eventType);
                return;
            }
            this.pendingErrorCount++;
        }
    }

    private final void onAddCustomTiming(RumRawEvent.AddCustomTiming event, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        if (this.stopped) {
            return;
        }
        this.customTimings.put(event.getName(), Long.valueOf(Math.max(event.getEventTime().getNanoTime() - this.startedNanos, 1L)));
        sendViewUpdate$dd_sdk_android_rum_release$default(this, event, datadogContext, writeScope, writer, null, 16, null);
    }

    private final void onUpdatePerformanceMetric(RumRawEvent.UpdatePerformanceMetric event) {
        if (this.stopped) {
            return;
        }
        double value = event.getValue();
        VitalInfo empty = this.performanceMetrics.get(event.getMetric());
        if (empty == null) {
            empty = VitalInfo.INSTANCE.getEMPTY();
        }
        int sampleCount = empty.getSampleCount() + 1;
        this.performanceMetrics.put(event.getMetric(), new VitalInfo(sampleCount, Math.min(value, empty.getMinValue()), Math.max(value, empty.getMaxValue()), ((((double) empty.getSampleCount()) * empty.getMeanValue()) + value) / ((double) sampleCount)));
    }

    private final void onUpdateExternalRefreshRate(RumRawEvent.UpdateExternalRefreshRate event) {
        if (!this.stopped && event.getFrameTimeSeconds() > 0.0d) {
            double frameTimeSeconds = 1.0d / event.getFrameTimeSeconds();
            VitalInfo empty = this.externalRefreshRateInfo;
            if (empty == null) {
                empty = VitalInfo.INSTANCE.getEMPTY();
            }
            int sampleCount = empty.getSampleCount() + 1;
            this.externalRefreshRateInfo = new VitalInfo(sampleCount, Math.min(frameTimeSeconds, empty.getMinValue()), Math.max(frameTimeSeconds, empty.getMaxValue()), ((((double) empty.getSampleCount()) * empty.getMeanValue()) + frameTimeSeconds) / ((double) sampleCount));
        }
    }

    private final void onSetInternalViewAttribute(RumRawEvent.SetInternalViewAttribute event) {
        if (this.stopped) {
            return;
        }
        this.internalAttributes.put(event.getKey(), event.getValue());
    }

    private final void onStopSession(RumRawEvent.StopSession event, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        stopScope$default(this, event, datadogContext, writeScope, writer, null, 16, null);
    }

    private final void delegateEventToChildren(RumRawEvent event, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        delegateEventToResources(event, datadogContext, writeScope, writer);
        delegateEventToAction(event, datadogContext, writeScope, writer);
    }

    private final void delegateEventToAction(RumRawEvent event, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        RumScope rumScope = this.activeActionScope;
        if (rumScope == null || rumScope.handleEvent(event, datadogContext, writeScope, writer) != null) {
            return;
        }
        this.activeActionScope = null;
    }

    private final void delegateEventToResources(RumRawEvent event, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        Iterator<Map.Entry<Object, RumScope>> it = this.activeResourceScopes.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().handleEvent(event, datadogContext, writeScope, writer) == null) {
                if ((event instanceof RumRawEvent.StopResourceWithError) || (event instanceof RumRawEvent.StopResourceWithStackTrace)) {
                    this.pendingResourceCount--;
                    this.pendingErrorCount++;
                }
                it.remove();
            }
        }
    }

    private final void onResourceSent(RumRawEvent.ResourceSent event, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        if (Intrinsics.areEqual(event.getViewId(), this.viewId)) {
            this.pendingResourceCount--;
            this.resourceCount++;
            this.networkSettledMetricResolver.resourceWasStopped(new InternalResourceContext(event.getResourceId(), event.getResourceEndTimestampInNanos()));
            sendViewUpdate$dd_sdk_android_rum_release$default(this, event, datadogContext, writeScope, writer, null, 16, null);
        }
    }

    private final void onActionSent(RumRawEvent.ActionSent event, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        if (Intrinsics.areEqual(event.getViewId(), this.viewId)) {
            this.pendingActionCount--;
            this.actionCount++;
            this.frustrationCount += event.getFrustrationCount();
            this.interactionToNextViewMetricResolver.onActionSent(new InternalInteractionContext(event.getViewId(), event.getType(), event.getEventEndTimestampInNanos()));
            sendViewUpdate$dd_sdk_android_rum_release$default(this, event, datadogContext, writeScope, writer, null, 16, null);
        }
    }

    private final void onLongTaskSent(RumRawEvent.LongTaskSent event, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        if (Intrinsics.areEqual(event.getViewId(), this.viewId)) {
            this.pendingLongTaskCount--;
            this.longTaskCount++;
            if (event.isFrozenFrame()) {
                this.pendingFrozenFrameCount--;
                this.frozenFrameCount++;
            }
            sendViewUpdate$dd_sdk_android_rum_release$default(this, event, datadogContext, writeScope, writer, null, 16, null);
        }
    }

    private final void onErrorSent(RumRawEvent.ErrorSent event, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        if (Intrinsics.areEqual(event.getViewId(), this.viewId)) {
            this.pendingErrorCount--;
            this.errorCount++;
            if (event.getResourceId() != null && event.getResourceEndTimestampInNanos() != null) {
                this.networkSettledMetricResolver.resourceWasStopped(new InternalResourceContext(event.getResourceId(), event.getResourceEndTimestampInNanos().longValue()));
            }
            sendViewUpdate$dd_sdk_android_rum_release$default(this, event, datadogContext, writeScope, writer, null, 16, null);
        }
    }

    private final void onResourceDropped(RumRawEvent.ResourceDropped event) {
        if (Intrinsics.areEqual(event.getViewId(), this.viewId)) {
            this.networkSettledMetricResolver.resourceWasDropped(event.getResourceId());
            this.pendingResourceCount--;
        }
    }

    private final void onActionDropped(RumRawEvent.ActionDropped event) {
        if (Intrinsics.areEqual(event.getViewId(), this.viewId)) {
            this.pendingActionCount--;
        }
    }

    private final void onErrorDropped(RumRawEvent.ErrorDropped event) {
        if (Intrinsics.areEqual(event.getViewId(), this.viewId)) {
            this.pendingErrorCount--;
            if (event.getResourceId() != null) {
                this.networkSettledMetricResolver.resourceWasDropped(event.getResourceId());
            }
        }
    }

    private final void onLongTaskDropped(RumRawEvent.LongTaskDropped event) {
        if (Intrinsics.areEqual(event.getViewId(), this.viewId)) {
            this.pendingLongTaskCount--;
            if (event.isFrozenFrame()) {
                this.pendingFrozenFrameCount--;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void stopScope$default(RumViewScope rumViewScope, RumRawEvent rumRawEvent, DatadogContext datadogContext, Function1 function1, DataWriter dataWriter, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stopScope");
        }
        if ((i & 16) != 0) {
            function0 = new Function0<Unit>() { // from class: com.datadog.android.rum.internal.domain.scope.RumViewScope.stopScope.1
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        rumViewScope.stopScope(rumRawEvent, datadogContext, function1, dataWriter, function0);
    }

    private final void stopScope(RumRawEvent event, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer, Function0<Unit> sideEffect) {
        if (this.stopped) {
            return;
        }
        sideEffect.invoke();
        this.stopped = true;
        resolveViewDuration(event);
        sendViewUpdate$dd_sdk_android_rum_release$default(this, event, datadogContext, writeScope, writer, null, 16, null);
        delegateEventToChildren(event, datadogContext, writeScope, writer);
        sendViewChanged();
        this.cpuVitalMonitor.unregister(this.cpuVitalListener);
        this.memoryVitalMonitor.unregister(this.memoryVitalListener);
        this.frameRateVitalMonitor.unregister(this.frameRateVitalListener);
        this.networkSettledMetricResolver.viewWasStopped();
    }

    public static /* synthetic */ void sendViewUpdate$dd_sdk_android_rum_release$default(RumViewScope rumViewScope, RumRawEvent rumRawEvent, DatadogContext datadogContext, Function1 function1, DataWriter dataWriter, EventType eventType, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendViewUpdate");
        }
        if ((i & 16) != 0) {
            eventType = EventType.DEFAULT;
        }
        rumViewScope.sendViewUpdate$dd_sdk_android_rum_release(rumRawEvent, datadogContext, function1, dataWriter, eventType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1, types: [T, java.lang.Long] */
    public final void sendViewUpdate$dd_sdk_android_rum_release(RumRawEvent event, final DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer, EventType eventType) {
        long j;
        ArrayList arrayList;
        List<ms> slowFramesRecords;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        Intrinsics.checkNotNullParameter(writeScope, "writeScope");
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        final boolean zIsViewComplete = isViewComplete();
        final Long lResolveMetric = this.networkSettledMetricResolver.resolveMetric();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = this.interactionToNextViewMetricResolver.resolveMetric(this.viewId);
        ViewInitializationMetricsState state = this.interactionToNextViewMetricResolver.getState(this.viewId);
        if (objectRef.element == 0 && state.getNoValueReason() == NoValueReason.InteractionToNextView.DISABLED) {
            Object obj = this.internalAttributes.get(RumAttributes.CUSTOM_INV_VALUE);
            objectRef.element = obj instanceof Long ? (Long) obj : 0;
        }
        final long j2 = this.version + 1;
        this.version = j2;
        long j3 = this.actionCount;
        final long j4 = this.errorCount;
        final long j5 = this.resourceCount;
        final long j6 = this.crashCount;
        final long j7 = this.longTaskCount;
        final long j8 = this.frozenFrameCount;
        final Double d = this.cpuTicks;
        final int i = this.frustrationCount;
        VitalInfo vitalInfo = this.performanceMetrics.get(RumPerformanceMetric.FLUTTER_BUILD_TIME);
        final ViewEvent.FlutterBuildTime performanceMetric = vitalInfo != null ? INSTANCE.toPerformanceMetric(vitalInfo) : null;
        VitalInfo vitalInfo2 = this.performanceMetrics.get(RumPerformanceMetric.FLUTTER_RASTER_TIME);
        final ViewEvent.FlutterBuildTime performanceMetric2 = vitalInfo2 != null ? INSTANCE.toPerformanceMetric(vitalInfo2) : null;
        VitalInfo vitalInfo3 = this.performanceMetrics.get(RumPerformanceMetric.JS_FRAME_TIME);
        final ViewEvent.FlutterBuildTime inversePerformanceMetric = vitalInfo3 != null ? INSTANCE.toInversePerformanceMetric(vitalInfo3) : null;
        if (!this.stopped) {
            resolveViewDuration(event);
        }
        final long j9 = this.stoppedNanos - this.startedNanos;
        final RumContext rumContext = getInitialContext();
        final ViewEvent.CustomTimings customTimingsResolveCustomTimings = resolveCustomTimings();
        final VitalInfo vitalInfo4 = this.lastMemoryInfo;
        VitalInfo vitalInfo5 = this.externalRefreshRateInfo;
        if (vitalInfo5 == null) {
            vitalInfo5 = this.lastFrameRateInfo;
        }
        Boolean boolResolveRefreshRateInfo = resolveRefreshRateInfo(vitalInfo5);
        final boolean zBooleanValue = boolResolveRefreshRateInfo != null ? boolResolveRefreshRateInfo.booleanValue() : false;
        final VitalInfo vitalInfo6 = vitalInfo5;
        final Map mutableMap = MapsKt.toMutableMap(this.featureFlags);
        final Map mutableMap2 = MapsKt.toMutableMap(getCustomAttributes());
        SlowFramesListener slowFramesListener = this.slowFramesListener;
        ViewUIPerformanceReport.Snapshot snapshotResolveReport = slowFramesListener != null ? slowFramesListener.resolveReport(this.viewId, zIsViewComplete, j9) : null;
        if (snapshotResolveReport == null || (slowFramesRecords = snapshotResolveReport.getSlowFramesRecords()) == null) {
            j = j3;
            arrayList = null;
        } else {
            List<ms> list = slowFramesRecords;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ms msVar = (ms) it.next();
                arrayList2.add(new ViewEvent.SlowFrame(msVar.getStartTimestampNs() - this.startedNanos, msVar.getDurationNs()));
                it = it;
                j3 = j3;
            }
            j = j3;
            arrayList = arrayList2;
        }
        final Double dValueOf = (zIsViewComplete == 0 || snapshotResolveReport == null) ? null : Double.valueOf(snapshotResolveReport.freezeFramesRate(this.stoppedNanos));
        Double dValueOf2 = (zIsViewComplete == 0 || snapshotResolveReport == null) ? null : Double.valueOf(snapshotResolveReport.slowFramesRate(this.stoppedNanos));
        this.insightsCollector.onSlowFrameRate(snapshotResolveReport != null ? Double.valueOf(snapshotResolveReport.slowFramesRate(this.stoppedNanos)) : null);
        if (zIsViewComplete != 0 && rumContext.getSessionState() != RumSessionScope.State.NOT_TRACKED) {
            this.viewEndedMetricDispatcher.sendViewEnded(this.interactionToNextViewMetricResolver.getState(this.viewId), this.networkSettledMetricResolver.getState());
        }
        AccessibilityInfo ifChanged = this.accessibilitySnapshotManager.getIfChanged();
        ViewEvent.Accessibility accessibility = ifChanged != null ? new ViewEvent.Accessibility(ifChanged.getTextSize(), ifChanged.isScreenReaderEnabled(), null, null, null, null, ifChanged.isColorInversionEnabled(), null, null, null, null, ifChanged.isClosedCaptioningEnabled(), null, null, ifChanged.isReducedAnimationsEnabled(), null, null, ifChanged.isScreenPinningEnabled(), null, null, null, ifChanged.isRtlEnabled(), 1947580, null) : null;
        final BatteryInfo batteryInfo = (BatteryInfo) this.batteryInfoProvider.getCurrentState();
        final DisplayInfo displayInfo = (DisplayInfo) this.displayInfoProvider.getCurrentState();
        Object obj2 = this.internalAttributes.get(RumAttributes.FLUTTER_FIRST_BUILD_COMPLETE);
        Number number = obj2 instanceof Number ? (Number) obj2 : null;
        ViewEvent.Performance performance = number != null ? new ViewEvent.Performance(null, null, null, null, null, new ViewEvent.Fbc(number.longValue()), 31, null) : null;
        String viewId = rumContext.getViewId();
        if (viewId == null) {
            viewId = "";
        }
        this.hasReplay = this.hasReplay || this.featuresContextResolver.resolveViewHasReplay(datadogContext, viewId);
        final long jResolveViewRecordsCount = this.featuresContextResolver.resolveViewRecordsCount(datadogContext, viewId);
        final String str = viewId;
        final ArrayList arrayList3 = arrayList;
        final Double d2 = dValueOf2;
        final long j10 = j;
        final ViewEvent.Accessibility accessibility2 = accessibility;
        final ViewEvent.Performance performance2 = performance;
        SdkCoreExtKt.newRumEventWriteOperation(this.sdkCore, datadogContext, writeScope, writer, eventType, new Function0<Object>() { // from class: com.datadog.android.rum.internal.domain.scope.RumViewScope$sendViewUpdate$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ViewEvent.ViewEventSessionType view;
                Double d3;
                String syntheticsResultId;
                UserInfo userInfo = datadogContext.getUserInfo();
                ViewEvent.ReplayStats replayStats = new ViewEvent.ReplayStats(Long.valueOf(jResolveViewRecordsCount), null, null, 6, null);
                String syntheticsTestId = rumContext.getSyntheticsTestId();
                ViewEvent.Synthetics synthetics = (syntheticsTestId == null || StringsKt.isBlank(syntheticsTestId) || (syntheticsResultId = rumContext.getSyntheticsResultId()) == null || StringsKt.isBlank(syntheticsResultId)) ? null : new ViewEvent.Synthetics(rumContext.getSyntheticsTestId(), rumContext.getSyntheticsResultId(), null, null, 12, null);
                if (this.rumSessionTypeOverride != null) {
                    view = RumSessionTypeExtKt.toView(this.rumSessionTypeOverride);
                } else if (synthetics == null) {
                    view = ViewEvent.ViewEventSessionType.USER;
                } else {
                    view = ViewEvent.ViewEventSessionType.SYNTHETICS;
                }
                ViewEvent.ViewEventSessionType viewEventSessionType = view;
                long eventTimestamp = this.getEventTimestamp();
                ViewEvent.Context context = new ViewEvent.Context(mutableMap);
                String viewName = rumContext.getViewName();
                String viewUrl = rumContext.getViewUrl();
                if (viewUrl == null) {
                    viewUrl = "";
                }
                String str2 = viewUrl;
                ViewEvent.Action action = new ViewEvent.Action(j10);
                ViewEvent.Resource resource = new ViewEvent.Resource(j5);
                ViewEvent.Error error = new ViewEvent.Error(j4);
                ViewEvent.Crash crash = new ViewEvent.Crash(j6);
                ViewEvent.LongTask longTask = new ViewEvent.LongTask(j7);
                ViewEvent.FrozenFrame frozenFrame = new ViewEvent.FrozenFrame(j8);
                boolean z = !zIsViewComplete;
                Double dValueOf3 = (j9 < RumViewScope.INSTANCE.getONE_SECOND_NS$dd_sdk_android_rum_release() || (d3 = d) == null) ? null : Double.valueOf((d3.doubleValue() * RumViewScope.INSTANCE.getONE_SECOND_NS$dd_sdk_android_rum_release()) / j9);
                VitalInfo vitalInfo7 = vitalInfo4;
                Double dValueOf4 = vitalInfo7 != null ? Double.valueOf(vitalInfo7.getMeanValue()) : null;
                VitalInfo vitalInfo8 = vitalInfo4;
                Double dValueOf5 = vitalInfo8 != null ? Double.valueOf(vitalInfo8.getMaxValue()) : null;
                VitalInfo vitalInfo9 = vitalInfo6;
                Double dValueOf6 = vitalInfo9 != null ? Double.valueOf(vitalInfo9.getMeanValue()) : null;
                VitalInfo vitalInfo10 = vitalInfo6;
                ViewEvent.ViewEventView viewEventView = new ViewEvent.ViewEventView(str, null, str2, viewName, this.getViewLoadingTime(), lResolveMetric, objectRef.element, null, j9, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, customTimingsResolveCustomTimings, Boolean.valueOf(z), Boolean.valueOf(zBooleanValue), action, error, crash, longTask, frozenFrame, arrayList3, resource, new ViewEvent.Frustration(i), null, dValueOf4, dValueOf5, d, dValueOf3, dValueOf6, vitalInfo10 != null ? Double.valueOf(vitalInfo10.getMinValue()) : null, d2, dValueOf, performanceMetric, performanceMetric2, inversePerformanceMetric, performance2, accessibility2, 67108482, 32, null);
                ViewEvent.Usr usr = RuntimeUtilsKt.hasUserData(userInfo) ? new ViewEvent.Usr(userInfo.getId(), userInfo.getName(), userInfo.getEmail(), userInfo.getAnonymousId(), MapsKt.toMutableMap(userInfo.getAdditionalProperties())) : null;
                AccountInfo accountInfo = datadogContext.getAccountInfo();
                ViewEvent viewEvent = new ViewEvent(eventTimestamp, new ViewEvent.Application(rumContext.getApplicationId(), datadogContext.getDeviceInfo().getLocaleInfo().getCurrentLocale()), datadogContext.getService(), datadogContext.getVersion(), String.valueOf(datadogContext.getVersionCode()), datadogContext.getAppBuildId(), DdTagsUtils.INSTANCE.toDdTagsString(datadogContext), new ViewEvent.ViewEventSession(rumContext.getSessionId(), viewEventSessionType, Boolean.valueOf(this.getHasReplay()), Boolean.valueOf(rumContext.isSessionActive()), null, 16, null), RumEventExtKt.tryFromSource(ViewEvent.ViewEventSource.INSTANCE, datadogContext.getSource(), this.sdkCore.getInternalLogger()), viewEventView, usr, accountInfo != null ? new ViewEvent.Account(accountInfo.getId(), accountInfo.getName(), MapsKt.toMutableMap(accountInfo.getExtraInfo())) : null, null, RumEventExtKt.toViewConnectivity(datadogContext.getNetworkInfo()), null, synthetics, null, new ViewEvent.Os(datadogContext.getDeviceInfo().getOsName(), datadogContext.getDeviceInfo().getOsVersion(), null, datadogContext.getDeviceInfo().getOsMajorVersion(), 4, null), new ViewEvent.Device(RumEventExtKt.toViewSchemaType(datadogContext.getDeviceInfo().getDeviceType()), datadogContext.getDeviceInfo().getDeviceName(), datadogContext.getDeviceInfo().getDeviceModel(), datadogContext.getDeviceInfo().getDeviceBrand(), datadogContext.getDeviceInfo().getArchitecture(), null, datadogContext.getDeviceInfo().getLocaleInfo().getLocales(), datadogContext.getDeviceInfo().getLocaleInfo().getTimeZone(), batteryInfo.getBatteryLevel(), batteryInfo.getLowPowerMode(), displayInfo.getScreenBrightness(), Integer.valueOf(datadogContext.getDeviceInfo().getLogicalCpuCount()), datadogContext.getDeviceInfo().getTotalRam(), datadogContext.getDeviceInfo().isLowRam(), 32, null), new ViewEvent.Dd(new ViewEvent.DdSession(null, RumEventExtKt.toViewSessionPrecondition(rumContext.getSessionStartReason()), 1, null), new ViewEvent.Configuration(Float.valueOf(this.getSampleRate()), RumEventExtKt.resolveSessionReplaySampleRate(datadogContext), null, RumEventExtKt.resolveTraceSampleRate(datadogContext), null, null, 52, null), null, null, j2, null, replayStats, null, this.resolveViewProfilingStatus(datadogContext), 172, null), new ViewEvent.Context(mutableMap2), null, null, context, null, 23154688, null);
                RumViewScope rumViewScope = this;
                rumViewScope.sessionEndedMetricDispatcher.onViewTracked(rumViewScope.sessionId, viewEvent);
                return viewEvent;
            }
        }).submit();
    }

    private final void resolveViewDuration(RumRawEvent event) {
        long nanoTime = event.getEventTime().getNanoTime();
        this.stoppedNanos = nanoTime;
        long j = nanoTime - this.startedNanos;
        this.viewEndedMetricDispatcher.onDurationResolved(j);
        if (j != 0) {
            if (j < 0) {
                this.sdkCore.getInternalLogger().log(InternalLogger.Level.WARN, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.scope.RumViewScope.resolveViewDuration.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        String str = String.format(Locale.US, RumViewScope.NEGATIVE_DURATION_WARNING_MESSAGE, Arrays.copyOf(new Object[]{RumViewScope.this.getKey().getName()}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        return str;
                    }
                }, (Throwable) null, false, MapsKt.mapOf(TuplesKt.to("view.start_ns", Long.valueOf(this.startedNanos)), TuplesKt.to("view.end_ns", Long.valueOf(event.getEventTime().getNanoTime())), TuplesKt.to(InstrumentationTags.VIEW_NAME, this.key.getName())));
                this.stoppedNanos = this.startedNanos + 1;
                return;
            }
            return;
        }
        if ((this.type != RumViewType.BACKGROUND || !(event instanceof RumRawEvent.AddError) || !((RumRawEvent.AddError) event).isFatal()) && !(event instanceof RumRawEvent.StartView)) {
            this.sdkCore.getInternalLogger().log(InternalLogger.Level.WARN, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.scope.RumViewScope.resolveViewDuration.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, RumViewScope.ZERO_DURATION_WARNING_MESSAGE, Arrays.copyOf(new Object[]{RumViewScope.this.getKey().getName()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) null, false, MapsKt.mapOf(TuplesKt.to(InstrumentationTags.VIEW_NAME, this.key.getName())));
        }
        this.stoppedNanos = this.startedNanos + 1;
    }

    private final Boolean resolveRefreshRateInfo(VitalInfo refreshRateInfo) {
        if (refreshRateInfo == null) {
            return null;
        }
        return Boolean.valueOf(refreshRateInfo.getMeanValue() < 55.0d);
    }

    private final ViewEvent.CustomTimings resolveCustomTimings() {
        if (this.customTimings.isEmpty()) {
            return null;
        }
        return new ViewEvent.CustomTimings(new LinkedHashMap(this.customTimings));
    }

    private final void onAddLongTask(final RumRawEvent.AddLongTask event, final DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        delegateEventToChildren(event, datadogContext, writeScope, writer);
        if (this.stopped) {
            return;
        }
        this.insightsCollector.onLongTask(event.getDurationNs());
        final RumContext rumContext = getInitialContext();
        final Map mutableMap = MapsKt.toMutableMap(getCustomAttributes());
        mutableMap.put(RumAttributes.LONG_TASK_TARGET, event.getTarget());
        final long timestamp = event.getEventTime().getTimestamp() + this.serverTimeOffsetInMs;
        boolean z = true;
        final boolean z2 = event.getDurationNs() > FROZEN_FRAME_THRESHOLD_NS;
        SlowFramesListener slowFramesListener = this.slowFramesListener;
        if (slowFramesListener != null) {
            slowFramesListener.onAddLongTask(event.getDurationNs());
        }
        if (!this.hasReplay) {
            FeaturesContextResolver featuresContextResolver = this.featuresContextResolver;
            String viewId = rumContext.getViewId();
            if (viewId == null) {
                viewId = "";
            }
            if (!featuresContextResolver.resolveViewHasReplay(datadogContext, viewId)) {
                z = false;
            }
        }
        this.hasReplay = z;
        final String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        InternalSdkCore internalSdkCore = this.sdkCore;
        Function0<Object> function0 = new Function0<Object>() { // from class: com.datadog.android.rum.internal.domain.scope.RumViewScope.onAddLongTask.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                LongTaskEvent.LongTaskEventSessionType longTask;
                String syntheticsResultId;
                UserInfo userInfo = datadogContext.getUserInfo();
                String syntheticsTestId = rumContext.getSyntheticsTestId();
                String str = null;
                Object[] objArr = 0;
                Object[] objArr2 = 0;
                Object[] objArr3 = 0;
                LongTaskEvent.Synthetics synthetics = (syntheticsTestId == null || StringsKt.isBlank(syntheticsTestId) || (syntheticsResultId = rumContext.getSyntheticsResultId()) == null || StringsKt.isBlank(syntheticsResultId)) ? null : new LongTaskEvent.Synthetics(rumContext.getSyntheticsTestId(), rumContext.getSyntheticsResultId(), null, null, 12, null);
                if (this.rumSessionTypeOverride != null) {
                    longTask = RumSessionTypeExtKt.toLongTask(this.rumSessionTypeOverride);
                } else if (synthetics == null) {
                    longTask = LongTaskEvent.LongTaskEventSessionType.USER;
                } else {
                    longTask = LongTaskEvent.LongTaskEventSessionType.SYNTHETICS;
                }
                long j = timestamp;
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                long durationNs = j - (event.getDurationNs() / 1000000);
                LongTaskEvent.LongTask longTask2 = new LongTaskEvent.LongTask(string, null, null, event.getDurationNs(), null, null, null, null, Boolean.valueOf(z2), null, 758, null);
                String actionId = rumContext.getActionId();
                LongTaskEvent.Action action = actionId != null ? new LongTaskEvent.Action(CollectionsKt.listOf(actionId)) : null;
                String viewId2 = rumContext.getViewId();
                String str2 = viewId2 == null ? "" : viewId2;
                String viewName = rumContext.getViewName();
                String viewUrl = rumContext.getViewUrl();
                LongTaskEvent.LongTaskEventView longTaskEventView = new LongTaskEvent.LongTaskEventView(str2, null, viewUrl == null ? "" : viewUrl, viewName, 2, null);
                LongTaskEvent.Usr usr = RuntimeUtilsKt.hasUserData(userInfo) ? new LongTaskEvent.Usr(userInfo.getId(), userInfo.getName(), userInfo.getEmail(), userInfo.getAnonymousId(), MapsKt.toMutableMap(userInfo.getAdditionalProperties())) : null;
                AccountInfo accountInfo = datadogContext.getAccountInfo();
                LongTaskEvent.Account account = accountInfo != null ? new LongTaskEvent.Account(accountInfo.getId(), accountInfo.getName(), MapsKt.toMutableMap(accountInfo.getExtraInfo())) : null;
                LongTaskEvent.Connectivity longTaskConnectivity = RumEventExtKt.toLongTaskConnectivity(datadogContext.getNetworkInfo());
                LongTaskEvent.Application application = new LongTaskEvent.Application(rumContext.getApplicationId(), str, 2, objArr3 == true ? 1 : 0);
                LongTaskEvent.LongTaskEventSession longTaskEventSession = new LongTaskEvent.LongTaskEventSession(rumContext.getSessionId(), longTask, Boolean.valueOf(this.getHasReplay()));
                LongTaskEvent.LongTaskEventSource longTaskEventSourceTryFromSource = RumEventExtKt.tryFromSource(LongTaskEvent.LongTaskEventSource.INSTANCE, datadogContext.getSource(), this.sdkCore.getInternalLogger());
                LongTaskEvent.Os os = new LongTaskEvent.Os(datadogContext.getDeviceInfo().getOsName(), datadogContext.getDeviceInfo().getOsVersion(), null, datadogContext.getDeviceInfo().getOsMajorVersion(), 4, null);
                List list = null;
                LongTaskEvent.Device device = new LongTaskEvent.Device(RumEventExtKt.toLongTaskSchemaType(datadogContext.getDeviceInfo().getDeviceType()), datadogContext.getDeviceInfo().getDeviceName(), datadogContext.getDeviceInfo().getDeviceModel(), datadogContext.getDeviceInfo().getDeviceBrand(), datadogContext.getDeviceInfo().getArchitecture(), null, list, null, null, null, null, Integer.valueOf(datadogContext.getDeviceInfo().getLogicalCpuCount()), datadogContext.getDeviceInfo().getTotalRam(), datadogContext.getDeviceInfo().isLowRam(), 2016, null);
                LongTaskEvent.Context context = new LongTaskEvent.Context(mutableMap);
                Object[] objArr4 = 0 == true ? 1 : 0;
                return new LongTaskEvent(durationNs, application, datadogContext.getService(), datadogContext.getVersion(), String.valueOf(datadogContext.getVersionCode()), datadogContext.getAppBuildId(), DdTagsUtils.INSTANCE.toDdTagsString(datadogContext), longTaskEventSession, longTaskEventSourceTryFromSource, longTaskEventView, usr, account, null, longTaskConnectivity, null, synthetics, null, os, device, new LongTaskEvent.Dd(new LongTaskEvent.DdSession(objArr2 == true ? 1 : 0, RumEventExtKt.toLongTaskSessionPrecondition(rumContext.getSessionStartReason()), 1, objArr == true ? 1 : 0), new LongTaskEvent.Configuration(Float.valueOf(this.getSampleRate()), null, null, objArr4, list, 30, 0 == true ? 1 : 0), 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, this.resolveLongTaskProfilingStatus(datadogContext), 28, 0 == true ? 1 : 0), context, null, action, null, longTask2, 10571776, null);
            }
        };
        boolean z3 = z2;
        WriteOperation writeOperationNewRumEventWriteOperation$default = SdkCoreExtKt.newRumEventWriteOperation$default(internalSdkCore, datadogContext, writeScope, writer, null, function0, 8, null);
        final StorageEvent storageEvent = z3 ? StorageEvent.FrozenFrame.INSTANCE : StorageEvent.LongTask.INSTANCE;
        writeOperationNewRumEventWriteOperation$default.onError(new Function1<AdvancedRumMonitor, Unit>() { // from class: com.datadog.android.rum.internal.domain.scope.RumViewScope$onAddLongTask$2$1
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
                String viewId2 = rumContext.getViewId();
                if (viewId2 == null) {
                    viewId2 = "";
                }
                it.eventDropped(viewId2, storageEvent);
            }
        });
        writeOperationNewRumEventWriteOperation$default.onSuccess(new Function1<AdvancedRumMonitor, Unit>() { // from class: com.datadog.android.rum.internal.domain.scope.RumViewScope$onAddLongTask$2$2
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
                String viewId2 = rumContext.getViewId();
                if (viewId2 == null) {
                    viewId2 = "";
                }
                it.eventSent(viewId2, storageEvent);
                FeatureScope feature = this.sdkCore.getFeature("profiling");
                if (feature != null) {
                    String str = string;
                    long j = timestamp;
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    feature.sendEvent(new ProfilerEvent.RumLongTaskEvent(str, j - (event.getDurationNs() / 1000000), event.getDurationNs(), new ProfilingRumContext(rumContext.getApplicationId(), rumContext.getSessionId(), rumContext.getViewId(), rumContext.getViewName())));
                }
            }
        });
        writeOperationNewRumEventWriteOperation$default.submit();
        this.pendingLongTaskCount++;
        if (z3) {
            this.pendingFrozenFrameCount++;
        }
    }

    private final void onAddFeatureFlagEvaluation(RumRawEvent.AddFeatureFlagEvaluation event, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        if (this.stopped || Intrinsics.areEqual(event.getValue(), this.featureFlags.get(event.getName()))) {
            return;
        }
        this.featureFlags.put(event.getName(), event.getValue());
        sendViewUpdate$dd_sdk_android_rum_release$default(this, event, datadogContext, writeScope, writer, null, 16, null);
        sendViewChanged();
    }

    private final void onAddFeatureFlagEvaluations(RumRawEvent.AddFeatureFlagEvaluations event, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer) {
        if (this.stopped) {
            return;
        }
        boolean z = false;
        for (Map.Entry<String, Object> entry : event.getFeatureFlags().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (!Intrinsics.areEqual(value, this.featureFlags.get(key))) {
                this.featureFlags.put(key, value);
                z = true;
            }
        }
        if (z) {
            sendViewUpdate$dd_sdk_android_rum_release$default(this, event, datadogContext, writeScope, writer, null, 16, null);
            sendViewChanged();
        }
    }

    private final void sendViewChanged() {
        RumViewChangedListener rumViewChangedListener = this.viewChangedListener;
        if (rumViewChangedListener != null) {
            rumViewChangedListener.onViewChanged(new RumViewInfo(this.key, this.viewAttributes, getIsActive()));
        }
    }

    private final boolean isViewComplete() {
        return this.stopped && this.activeResourceScopes.isEmpty() && ((this.pendingActionCount + this.pendingResourceCount) + this.pendingErrorCount) + this.pendingLongTaskCount <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ErrorEvent.Category tryFrom(ErrorEvent.Category.Companion companion, RumRawEvent.AddError addError) {
        if (addError.getThrowable() != null) {
            return addError.getThrowable() instanceof ANRException ? ErrorEvent.Category.ANR : ErrorEvent.Category.EXCEPTION;
        }
        if (addError.getStacktrace() != null) {
            return ErrorEvent.Category.EXCEPTION;
        }
        return null;
    }

    private final ErrorEvent.Profiling resolveErrorProfilingStatus(DatadogContext datadogContext) {
        boolean zIsProfilerRunning = ProfilingFeatureContextKt.isProfilerRunning(datadogContext);
        String strResolveProfilingQuotaReason = ProfilingFeatureContextKt.resolveProfilingQuotaReason(datadogContext, this.sessionId);
        long serverTimeOffsetMs = datadogContext.getTime().getServerTimeOffsetMs();
        if (zIsProfilerRunning) {
            return new ErrorEvent.Profiling(ErrorEvent.ProfilingStatus.RUNNING, null, null, Long.valueOf(serverTimeOffsetMs), 6, null);
        }
        if (strResolveProfilingQuotaReason == null) {
            return null;
        }
        return new ErrorEvent.Profiling(ErrorEvent.ProfilingStatus.STOPPED, null, strResolveProfilingQuotaReason, null, 10, null);
    }

    private final VitalOperationStepEvent.Profiling resolveVitalOperationStepProfilingStatus(DatadogContext datadogContext) {
        boolean zIsProfilerRunning = ProfilingFeatureContextKt.isProfilerRunning(datadogContext);
        String strResolveProfilingQuotaReason = ProfilingFeatureContextKt.resolveProfilingQuotaReason(datadogContext, this.sessionId);
        long serverTimeOffsetMs = datadogContext.getTime().getServerTimeOffsetMs();
        if (zIsProfilerRunning) {
            return new VitalOperationStepEvent.Profiling(VitalOperationStepEvent.ProfilingStatus.RUNNING, null, null, Long.valueOf(serverTimeOffsetMs), 6, null);
        }
        if (strResolveProfilingQuotaReason == null) {
            return null;
        }
        return new VitalOperationStepEvent.Profiling(VitalOperationStepEvent.ProfilingStatus.STOPPED, null, strResolveProfilingQuotaReason, null, 10, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LongTaskEvent.Profiling resolveLongTaskProfilingStatus(DatadogContext datadogContext) {
        boolean zIsProfilerRunning = ProfilingFeatureContextKt.isProfilerRunning(datadogContext);
        String strResolveProfilingQuotaReason = ProfilingFeatureContextKt.resolveProfilingQuotaReason(datadogContext, this.sessionId);
        long serverTimeOffsetMs = datadogContext.getTime().getServerTimeOffsetMs();
        if (zIsProfilerRunning) {
            return new LongTaskEvent.Profiling(LongTaskEvent.ProfilingStatus.RUNNING, null, null, Long.valueOf(serverTimeOffsetMs), 6, null);
        }
        if (strResolveProfilingQuotaReason == null) {
            return null;
        }
        return new LongTaskEvent.Profiling(LongTaskEvent.ProfilingStatus.STOPPED, null, strResolveProfilingQuotaReason, null, 10, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewEvent.Profiling resolveViewProfilingStatus(DatadogContext datadogContext) {
        boolean zIsProfilerRunning = ProfilingFeatureContextKt.isProfilerRunning(datadogContext);
        String strResolveProfilingQuotaReason = ProfilingFeatureContextKt.resolveProfilingQuotaReason(datadogContext, this.sessionId);
        if (zIsProfilerRunning) {
            return new ViewEvent.Profiling(ViewEvent.ProfilingStatus.RUNNING, null, null, Long.valueOf(datadogContext.getTime().getServerTimeOffsetMs()), 6, null);
        }
        if (strResolveProfilingQuotaReason != null) {
            return new ViewEvent.Profiling(ViewEvent.ProfilingStatus.STOPPED, null, strResolveProfilingQuotaReason, null, 10, null);
        }
        return null;
    }

    private final void logSynthetics(String key, String value) {
        Log.i("DatadogSynthetics", key + "=" + value);
    }

    /* JADX INFO: compiled from: RumViewScope.kt */
    @Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JÁ\u0001\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u0002022\f\u00103\u001a\b\u0012\u0004\u0012\u000205042\f\u00106\u001a\b\u0012\u0004\u0012\u000207042\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;H\u0000¢\u0006\u0002\b<J\u0010\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020>H\u0002J\f\u0010@\u001a\u00020A*\u00020BH\u0002J\f\u0010C\u001a\u00020A*\u00020BH\u0002J\u000e\u0010D\u001a\u0004\u0018\u00010E*\u00020\u001cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u000e\u0010\r\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumViewScope$Companion;", "", "()V", "ACTION_DROPPED_WARNING", "", "ADDING_VIEW_LOADING_TIME_DEBUG_MESSAGE_FORMAT", "FROZEN_FRAME_THRESHOLD_NS", "", "getFROZEN_FRAME_THRESHOLD_NS$dd_sdk_android_rum_release", "()J", "NEGATIVE_DURATION_WARNING_MESSAGE", "ONE_SECOND_NS", "getONE_SECOND_NS$dd_sdk_android_rum_release", "OVERWRITING_VIEW_LOADING_TIME_WARNING_MESSAGE_FORMAT", "SESSION_REPLAY_SAMPLE_RATE_KEY", "SLOW_RENDERED_THRESHOLD_FPS", "", "TRACE_SAMPLE_RATE", "ZERO_DURATION_WARNING_MESSAGE", "fromEvent", "Lcom/datadog/android/rum/internal/domain/scope/RumViewScope;", "parentScope", "Lcom/datadog/android/rum/internal/domain/scope/RumScope;", "sessionEndedMetricDispatcher", "Lcom/datadog/android/rum/internal/metric/SessionMetricDispatcher;", "sdkCore", "Lcom/datadog/android/core/InternalSdkCore;", "event", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StartView;", "viewChangedListener", "Lcom/datadog/android/rum/internal/domain/scope/RumViewChangedListener;", "firstPartyHostHeaderTypeResolver", "Lcom/datadog/android/core/internal/net/FirstPartyHostHeaderTypeResolver;", "cpuVitalMonitor", "Lcom/datadog/android/rum/internal/vitals/VitalMonitor;", "memoryVitalMonitor", "frameRateVitalMonitor", "trackFrustrations", "", "sampleRate", "", "interactionToNextViewMetricResolver", "Lcom/datadog/android/rum/internal/metric/interactiontonextview/InteractionToNextViewMetricResolver;", "networkSettledResourceIdentifier", "Lcom/datadog/android/rum/metric/networksettled/InitialResourceIdentifier;", "slowFramesListener", "Lcom/datadog/android/rum/internal/metric/slowframes/SlowFramesListener;", "rumSessionTypeOverride", "Lcom/datadog/android/rum/RumSessionType;", "accessibilitySnapshotManager", "Lcom/datadog/android/rum/internal/domain/accessibility/AccessibilitySnapshotManager;", "batteryInfoProvider", "Lcom/datadog/android/rum/internal/domain/InfoProvider;", "Lcom/datadog/android/rum/internal/domain/battery/BatteryInfo;", "displayInfoProvider", "Lcom/datadog/android/rum/internal/domain/display/DisplayInfo;", "insightsCollector", "Lcom/datadog/android/rum/internal/instrumentation/insights/InsightsCollector;", "heatmapIdentifierRegistry", "Lcom/datadog/android/internal/heatmaps/HeatmapIdentifierRegistry;", "fromEvent$dd_sdk_android_rum_release", "invertValue", "", "value", "toInversePerformanceMetric", "Lcom/datadog/android/rum/model/ViewEvent$FlutterBuildTime;", "Lcom/datadog/android/rum/internal/vitals/VitalInfo;", "toPerformanceMetric", "tryResolveInstrumentationType", "Lcom/datadog/android/internal/attributes/ViewScopeInstrumentationType;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final double invertValue(double value) {
            if (value == 0.0d) {
                return 0.0d;
            }
            return 1.0d / value;
        }

        private Companion() {
        }

        public final long getONE_SECOND_NS$dd_sdk_android_rum_release() {
            return RumViewScope.ONE_SECOND_NS;
        }

        public final long getFROZEN_FRAME_THRESHOLD_NS$dd_sdk_android_rum_release() {
            return RumViewScope.FROZEN_FRAME_THRESHOLD_NS;
        }

        public final RumViewScope fromEvent$dd_sdk_android_rum_release(RumScope parentScope, SessionMetricDispatcher sessionEndedMetricDispatcher, InternalSdkCore sdkCore, RumRawEvent.StartView event, RumViewChangedListener viewChangedListener, FirstPartyHostHeaderTypeResolver firstPartyHostHeaderTypeResolver, VitalMonitor cpuVitalMonitor, VitalMonitor memoryVitalMonitor, VitalMonitor frameRateVitalMonitor, boolean trackFrustrations, float sampleRate, InteractionToNextViewMetricResolver interactionToNextViewMetricResolver, InitialResourceIdentifier networkSettledResourceIdentifier, SlowFramesListener slowFramesListener, RumSessionType rumSessionTypeOverride, AccessibilitySnapshotManager accessibilitySnapshotManager, InfoProvider<BatteryInfo> batteryInfoProvider, InfoProvider<DisplayInfo> displayInfoProvider, InsightsCollector insightsCollector, HeatmapIdentifierRegistry heatmapIdentifierRegistry) {
            Intrinsics.checkNotNullParameter(parentScope, "parentScope");
            Intrinsics.checkNotNullParameter(sessionEndedMetricDispatcher, "sessionEndedMetricDispatcher");
            Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(firstPartyHostHeaderTypeResolver, "firstPartyHostHeaderTypeResolver");
            Intrinsics.checkNotNullParameter(cpuVitalMonitor, "cpuVitalMonitor");
            Intrinsics.checkNotNullParameter(memoryVitalMonitor, "memoryVitalMonitor");
            Intrinsics.checkNotNullParameter(frameRateVitalMonitor, "frameRateVitalMonitor");
            Intrinsics.checkNotNullParameter(interactionToNextViewMetricResolver, "interactionToNextViewMetricResolver");
            Intrinsics.checkNotNullParameter(networkSettledResourceIdentifier, "networkSettledResourceIdentifier");
            Intrinsics.checkNotNullParameter(accessibilitySnapshotManager, "accessibilitySnapshotManager");
            Intrinsics.checkNotNullParameter(batteryInfoProvider, "batteryInfoProvider");
            Intrinsics.checkNotNullParameter(displayInfoProvider, "displayInfoProvider");
            Intrinsics.checkNotNullParameter(insightsCollector, "insightsCollector");
            NetworkSettledMetricResolver networkSettledMetricResolver = new NetworkSettledMetricResolver(networkSettledResourceIdentifier, sdkCore.getInternalLogger());
            RumViewType rumViewType = RumViewType.FOREGROUND;
            return new RumViewScope(parentScope, sdkCore, sessionEndedMetricDispatcher, event.getKey(), event.getEventTime(), event.getAttributes(), viewChangedListener, firstPartyHostHeaderTypeResolver, cpuVitalMonitor, memoryVitalMonitor, frameRateVitalMonitor, null, rumViewType, trackFrustrations, sampleRate, interactionToNextViewMetricResolver, networkSettledMetricResolver, slowFramesListener, new ViewEndedMetricDispatcher(rumViewType, sdkCore.getInternalLogger(), tryResolveInstrumentationType(event), 0.0f, 8, null), rumSessionTypeOverride, accessibilitySnapshotManager, batteryInfoProvider, displayInfoProvider, insightsCollector, heatmapIdentifierRegistry, 2048, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ViewEvent.FlutterBuildTime toPerformanceMetric(VitalInfo vitalInfo) {
            return new ViewEvent.FlutterBuildTime(Double.valueOf(vitalInfo.getMinValue()), Double.valueOf(vitalInfo.getMaxValue()), Double.valueOf(vitalInfo.getMeanValue()), null, 8, null);
        }

        private final ViewScopeInstrumentationType tryResolveInstrumentationType(RumRawEvent.StartView startView) {
            Object obj = startView.getAttributes().get(RumAttributes.INTERNAL_INSTRUMENTATION_TYPE);
            String str = obj instanceof String ? (String) obj : null;
            String str2 = str;
            if (str2 != null && !StringsKt.isBlank(str2)) {
                return ViewScopeInstrumentationType.Custom.INSTANCE.create(str);
            }
            Object obj2 = startView.getAttributes().get(LocalAttribute.Key.VIEW_SCOPE_INSTRUMENTATION_TYPE.getString());
            if (obj2 instanceof ViewScopeInstrumentationType) {
                return (ViewScopeInstrumentationType) obj2;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ViewEvent.FlutterBuildTime toInversePerformanceMetric(VitalInfo vitalInfo) {
            double dInvertValue = invertValue(vitalInfo.getMaxValue());
            TimeUnit timeUnit = TimeUnit.SECONDS;
            Double dValueOf = Double.valueOf(dInvertValue * 1.0E9d);
            double dInvertValue2 = invertValue(vitalInfo.getMinValue());
            TimeUnit timeUnit2 = TimeUnit.SECONDS;
            Double dValueOf2 = Double.valueOf(dInvertValue2 * 1.0E9d);
            double dInvertValue3 = invertValue(vitalInfo.getMeanValue());
            TimeUnit timeUnit3 = TimeUnit.SECONDS;
            return new ViewEvent.FlutterBuildTime(dValueOf, dValueOf2, Double.valueOf(dInvertValue3 * 1.0E9d), null, 8, null);
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        ONE_SECOND_NS = C.NANOS_PER_SECOND;
        TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
        FROZEN_FRAME_THRESHOLD_NS = 700000000L;
    }
}

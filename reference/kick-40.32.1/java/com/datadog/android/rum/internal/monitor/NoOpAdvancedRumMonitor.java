package com.datadog.android.rum.internal.monitor;

import android.app.Activity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.datadog.android.core.feature.event.ThreadDump;
import com.datadog.android.heatmaps.CrossPlatformHeatmapActionData;
import com.datadog.android.internal.telemetry.InternalTelemetryEvent;
import com.datadog.android.rum.RumActionType;
import com.datadog.android.rum.RumErrorSource;
import com.datadog.android.rum.RumPerformanceMetric;
import com.datadog.android.rum.RumResourceKind;
import com.datadog.android.rum.RumResourceMethod;
import com.datadog.android.rum._RumInternalProxy;
import com.datadog.android.rum.featureoperations.FailureReason;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.rum.internal.debug.RumDebugListener;
import com.datadog.android.rum.internal.domain.event.ResourceTiming;
import com.datadog.android.rum.internal.domain.event.RumEventMeta;
import com.datadog.android.rum.internal.heatmaps.NativeHeatmapActionData;
import com.datadog.android.rum.internal.startup.RumAppStartupTelemetryReporterImpl;
import com.datadog.android.rum.internal.startup.RumStartupScenario;
import com.datadog.android.rum.internal.startup.RumTTIDInfo;
import com.datadog.android.rum.operations.OperationOptions;
import com.datadog.android.rum.resource.ResourceId;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.http.ContentDisposition;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpAdvancedRumMonitor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0082\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J.\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016J8\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016J6\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016J\u001a\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u0013H\u0016J.\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$H\u0016J8\u0010&\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016J8\u0010'\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\b\u0010(\u001a\u0004\u0018\u00010\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016J\u0018\u0010)\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0013H\u0016J\u001c\u0010*\u001a\u00020\f2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\u0018\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0010H\u0016J\u0018\u00100\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u00020\fH\u0016J\u0010\u00104\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001e\u00105\u001a\u00020\f2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016J\u0010\u00106\u001a\u00020\f2\u0006\u00107\u001a\u00020\u0004H\u0016J\b\u00108\u001a\u00020\fH\u0016J\u0010\u00109\u001a\u00020\f2\u0006\u0010:\u001a\u00020;H\u0016J\u0018\u0010<\u001a\u00020\f2\u0006\u0010=\u001a\u00020\u00102\u0006\u0010>\u001a\u00020?H\u0016J\u0018\u0010@\u001a\u00020\f2\u0006\u0010=\u001a\u00020\u00102\u0006\u0010>\u001a\u00020?H\u0016J8\u0010A\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010B\u001a\u0004\u0018\u00010\u00102\u0006\u0010C\u001a\u00020D2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0017J8\u0010E\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010B\u001a\u0004\u0018\u00010\u00102\u0006\u0010C\u001a\u00020F2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016J\u0016\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016J\u001e\u0010H\u001a\u00020\f2\u0014\u0010I\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\f0JH\u0016J\n\u0010K\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010L\u001a\u00020\fH\u0016J\u0010\u0010M\u001a\u00020\f2\u0006\u0010N\u001a\u00020OH\u0016J\u0010\u0010P\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0010H\u0016J\u0016\u0010Q\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100RH\u0016J\b\u0010S\u001a\u00020\fH\u0016J\u0010\u0010T\u001a\u00020\f2\u0006\u0010\r\u001a\u00020UH\u0016J\b\u0010V\u001a\u00020\fH\u0016J\u0010\u0010W\u001a\u00020\f2\u0006\u0010X\u001a\u00020YH\u0016J\u0010\u0010Z\u001a\u00020\f2\u0006\u0010[\u001a\u00020\\H\u0016J\u0010\u0010]\u001a\u00020\f2\u0006\u0010^\u001a\u00020_H\u0016J\b\u0010`\u001a\u00020\fH\u0016J\u0012\u0010a\u001a\u00020\f2\b\u0010b\u001a\u0004\u0018\u00010cH\u0016J\u001a\u0010d\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010e\u001a\u00020\f2\u0006\u0010f\u001a\u00020\u00102\u0006\u0010g\u001a\u00020\u0010H\u0016J\b\u0010h\u001a\u00020\fH\u0016J.\u0010i\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016J0\u0010j\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010B\u001a\u0004\u0018\u00010\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0017J8\u0010k\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010B\u001a\u0004\u0018\u00010\u00102\u0006\u0010l\u001a\u00020m2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016J6\u0010n\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020o2\u0006\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016J6\u0010n\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016J.\u0010s\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016J.\u0010t\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016JG\u0010u\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020o2\b\u0010v\u001a\u0004\u0018\u00010w2\b\u0010x\u001a\u0004\u0018\u00010.2\u0006\u0010y\u001a\u00020z2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016¢\u0006\u0002\u0010{JG\u0010u\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00102\b\u0010v\u001a\u0004\u0018\u00010w2\b\u0010x\u001a\u0004\u0018\u00010.2\u0006\u0010y\u001a\u00020z2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016¢\u0006\u0002\u0010|JX\u0010}\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020o2\b\u0010v\u001a\u0004\u0018\u00010w2\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010~\u001a\u00020\u00102\b\u0010\u007f\u001a\u0004\u0018\u00010\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016¢\u0006\u0003\u0010\u0080\u0001JN\u0010}\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020o2\b\u0010v\u001a\u0004\u0018\u00010w2\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016¢\u0006\u0003\u0010\u0081\u0001JX\u0010}\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00102\b\u0010v\u001a\u0004\u0018\u00010w2\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010~\u001a\u00020\u00102\b\u0010\u007f\u001a\u0004\u0018\u00010\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016¢\u0006\u0003\u0010\u0082\u0001JN\u0010}\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00102\b\u0010v\u001a\u0004\u0018\u00010w2\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016¢\u0006\u0003\u0010\u0083\u0001J\t\u0010\u0084\u0001\u001a\u00020\fH\u0016J'\u0010\u0085\u0001\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00132\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016J1\u0010\u0086\u0001\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010B\u001a\u0004\u0018\u00010\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0017J1\u0010\u0087\u0001\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010B\u001a\u0004\u0018\u00010\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016J\u0013\u0010\u0088\u0001\u001a\u00020\f2\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001H\u0016J\u001c\u0010\u008b\u0001\u001a\u00020\f2\b\u0010\u008c\u0001\u001a\u00030\u008d\u00012\u0007\u0010\u001c\u001a\u00030\u008a\u0001H\u0016J\u0011\u0010\u008e\u0001\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0013H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u008f\u0001"}, d2 = {"Lcom/datadog/android/rum/internal/monitor/NoOpAdvancedRumMonitor;", "Lcom/datadog/android/rum/internal/monitor/AdvancedRumMonitor;", "()V", "debug", "", "getDebug", "()Z", "setDebug", "(Z)V", "_getInternal", "Lcom/datadog/android/rum/_RumInternalProxy;", "addAction", "", "type", "Lcom/datadog/android/rum/RumActionType;", "name", "", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "", "addActionWithHeatmap", "nativeHeatmapActionData", "Lcom/datadog/android/rum/internal/heatmaps/NativeHeatmapActionData;", "addActionWithHeatmapAttributes", "crossPlatformHeatmapActionData", "Lcom/datadog/android/heatmaps/CrossPlatformHeatmapActionData;", "addAttribute", "key", "value", "addCrash", "message", "source", "Lcom/datadog/android/rum/RumErrorSource;", RumFeature.EVENT_THROWABLE_PROPERTY, "", "threads", "", "Lcom/datadog/android/core/feature/event/ThreadDump;", "addError", "addErrorWithStacktrace", "stacktrace", "addFeatureFlagEvaluation", "addFeatureFlagEvaluations", "featureFlags", "addLongTask", "durationNs", "", TypedValues.Attributes.S_TARGET, "addResourceTiming", "timing", "Lcom/datadog/android/rum/internal/domain/event/ResourceTiming;", "addSessionReplaySkippedFrame", "addTiming", "addViewAttributes", "addViewLoadingTime", "overwrite", "clearAttributes", "enableJankStatsTracking", "activity", "Landroid/app/Activity;", "eventDropped", RumEventMeta.VIEW_ID_KEY, "event", "Lcom/datadog/android/rum/internal/monitor/StorageEvent;", "eventSent", "failFeatureOperation", "operationKey", "failureReason", "Lcom/datadog/android/rum/featureoperations/FailureReason;", "failOperation", "Lcom/datadog/android/rum/operations/FailureReason;", "getAttributes", "getCurrentSessionId", "callback", "Lkotlin/Function1;", "getCurrentViewUrl", "notifyInterceptorInstantiated", "notifyResourceHeadersTrackingConfigured", "mode", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ResourceHeadersTrackingConfigured$Mode;", "removeAttribute", "removeViewAttributes", "", "reportAppFullyDisplayed", "reportNetworkingLibraryType", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage$NetworkInstrumentation$LibraryType;", "resetSession", "sendAppStartEvent", RumAppStartupTelemetryReporterImpl.KEY_SCENARIO, "Lcom/datadog/android/rum/internal/startup/RumStartupScenario;", "sendTTIDEvent", "info", "Lcom/datadog/android/rum/internal/startup/RumTTIDInfo;", "sendTelemetryEvent", "telemetryEvent", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent;", "sendWebViewEvent", "setDebugListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/datadog/android/rum/internal/debug/RumDebugListener;", "setInternalViewAttribute", "setSyntheticsAttribute", "testId", "resultId", ViewProps.START, "startAction", "startFeatureOperation", "startOperation", "options", "Lcom/datadog/android/rum/operations/OperationOptions;", "startResource", "Lcom/datadog/android/rum/resource/ResourceId;", FirebaseAnalytics.Param.METHOD, "Lcom/datadog/android/rum/RumResourceMethod;", ImagesContract.URL, "startView", "stopAction", "stopResource", "statusCode", "", ContentDisposition.Parameters.Size, "kind", "Lcom/datadog/android/rum/RumResourceKind;", "(Lcom/datadog/android/rum/resource/ResourceId;Ljava/lang/Integer;Ljava/lang/Long;Lcom/datadog/android/rum/RumResourceKind;Ljava/util/Map;)V", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Lcom/datadog/android/rum/RumResourceKind;Ljava/util/Map;)V", "stopResourceWithError", "stackTrace", "errorType", "(Lcom/datadog/android/rum/resource/ResourceId;Ljava/lang/Integer;Ljava/lang/String;Lcom/datadog/android/rum/RumErrorSource;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "(Lcom/datadog/android/rum/resource/ResourceId;Ljava/lang/Integer;Ljava/lang/String;Lcom/datadog/android/rum/RumErrorSource;Ljava/lang/Throwable;Ljava/util/Map;)V", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/datadog/android/rum/RumErrorSource;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/datadog/android/rum/RumErrorSource;Ljava/lang/Throwable;Ljava/util/Map;)V", "stopSession", "stopView", "succeedFeatureOperation", "succeedOperation", "updateExternalRefreshRate", "frameTimeSeconds", "", "updatePerformanceMetric", "metric", "Lcom/datadog/android/rum/RumPerformanceMetric;", "waitForResourceTiming", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpAdvancedRumMonitor implements AdvancedRumMonitor {
    private boolean debug;

    @Override // com.datadog.android.rum.RumMonitor
    public _RumInternalProxy _getInternal() {
        return null;
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void addAction(RumActionType type, String name, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void addActionWithHeatmap(RumActionType type, String name, NativeHeatmapActionData nativeHeatmapActionData, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void addActionWithHeatmapAttributes(RumActionType type, String name, CrossPlatformHeatmapActionData crossPlatformHeatmapActionData, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(crossPlatformHeatmapActionData, "crossPlatformHeatmapActionData");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void addAttribute(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void addCrash(String message, RumErrorSource source, Throwable throwable, List<ThreadDump> threads) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(threads, "threads");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void addError(String message, RumErrorSource source, Throwable throwable, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void addErrorWithStacktrace(String message, RumErrorSource source, String stacktrace, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void addFeatureFlagEvaluation(String name, Object value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void addFeatureFlagEvaluations(Map<String, ? extends Object> featureFlags) {
        Intrinsics.checkNotNullParameter(featureFlags, "featureFlags");
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void addLongTask(long durationNs, String target) {
        Intrinsics.checkNotNullParameter(target, "target");
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedNetworkRumMonitor
    public void addResourceTiming(Object key, ResourceTiming timing) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(timing, "timing");
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void addSessionReplaySkippedFrame() {
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void addTiming(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void addViewAttributes(Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void addViewLoadingTime(boolean overwrite) {
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void clearAttributes() {
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void enableJankStatsTracking(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void eventDropped(String viewId, StorageEvent event) {
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void eventSent(String viewId, StorageEvent event) {
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // com.datadog.android.rum.RumMonitor
    @Deprecated(message = "Use failOperation instead.")
    public void failFeatureOperation(String name, String operationKey, FailureReason failureReason, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(failureReason, "failureReason");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void failOperation(String name, String operationKey, com.datadog.android.rum.operations.FailureReason failureReason, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(failureReason, "failureReason");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void getCurrentSessionId(Function1<? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public String getCurrentViewUrl() {
        return null;
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedNetworkRumMonitor
    public void notifyInterceptorInstantiated() {
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedNetworkRumMonitor
    public void notifyResourceHeadersTrackingConfigured(InternalTelemetryEvent.ResourceHeadersTrackingConfigured.Mode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void removeAttribute(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void removeViewAttributes(Collection<String> attributes) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void reportAppFullyDisplayed() {
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedNetworkRumMonitor
    public void reportNetworkingLibraryType(InternalTelemetryEvent.ApiUsage.NetworkInstrumentation.LibraryType type) {
        Intrinsics.checkNotNullParameter(type, "type");
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void resetSession() {
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void sendAppStartEvent(RumStartupScenario scenario) {
        Intrinsics.checkNotNullParameter(scenario, "scenario");
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void sendTTIDEvent(RumTTIDInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void sendTelemetryEvent(InternalTelemetryEvent telemetryEvent) {
        Intrinsics.checkNotNullParameter(telemetryEvent, "telemetryEvent");
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void sendWebViewEvent() {
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void setDebugListener(RumDebugListener listener) {
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void setInternalViewAttribute(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void setSyntheticsAttribute(String testId, String resultId) {
        Intrinsics.checkNotNullParameter(testId, "testId");
        Intrinsics.checkNotNullParameter(resultId, "resultId");
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void start() {
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void startAction(RumActionType type, String name, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    @Deprecated(message = "Use startOperation instead.")
    public void startFeatureOperation(String name, String operationKey, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void startOperation(String name, String operationKey, OperationOptions options, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedNetworkRumMonitor
    public void startResource(ResourceId key, RumResourceMethod method, String url, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void startResource(String key, RumResourceMethod method, String url, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void startView(Object key, String name, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void stopAction(RumActionType type, String name, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedNetworkRumMonitor
    public void stopResource(ResourceId key, Integer statusCode, Long size, RumResourceKind kind, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void stopResource(String key, Integer statusCode, Long size, RumResourceKind kind, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedNetworkRumMonitor
    public void stopResourceWithError(ResourceId key, Integer statusCode, String message, RumErrorSource source, String stackTrace, String errorType, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(stackTrace, "stackTrace");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedNetworkRumMonitor
    public void stopResourceWithError(ResourceId key, Integer statusCode, String message, RumErrorSource source, Throwable throwable, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void stopResourceWithError(String key, Integer statusCode, String message, RumErrorSource source, String stackTrace, String errorType, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(stackTrace, "stackTrace");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void stopResourceWithError(String key, Integer statusCode, String message, RumErrorSource source, Throwable throwable, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void stopSession() {
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void stopView(Object key, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    @Deprecated(message = "Use succeedOperation instead.")
    public void succeedFeatureOperation(String name, String operationKey, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void succeedOperation(String name, String operationKey, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void updateExternalRefreshRate(double frameTimeSeconds) {
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void updatePerformanceMetric(RumPerformanceMetric metric, double value) {
        Intrinsics.checkNotNullParameter(metric, "metric");
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedNetworkRumMonitor
    public void waitForResourceTiming(Object key) {
        Intrinsics.checkNotNullParameter(key, "key");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public boolean getDebug() {
        return this.debug;
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void setDebug(boolean z) {
        this.debug = z;
    }

    @Override // com.datadog.android.rum.RumMonitor
    public Map<String, Object> getAttributes() {
        return MapsKt.emptyMap();
    }
}

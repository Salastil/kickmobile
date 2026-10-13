package com.datadog.android.rum.model;

import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import com.datadog.android.core.internal.metrics.BatchMetricsDispatcher;
import com.datadog.android.core.internal.utils.JsonSerializer;
import com.datadog.android.rum.internal.FeaturesContextResolver;
import com.datadog.android.rum.internal.domain.event.RumEventMeta;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.rum.internal.domain.scope.RumSessionScope;
import com.datadog.android.rum.internal.metric.ViewEndedMetricDispatcher;
import com.datadog.android.rum.internal.metric.slowframes.DefaultUISlownessMetricDispatcher;
import com.datadog.android.webview.WebViewTracking;
import com.datadog.android.webview.internal.rum.WebViewRumEventMapper;
import com.datadog.trace.api.config.ProfilingConfig;
import com.facebook.hermes.intl.Constants;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.cast.CredentialsData;
import com.google.android.gms.cast.MediaError;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import com.useinsider.insiderhybrid.constants.InsiderHybridMethods;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;

/* JADX INFO: compiled from: ViewEvent.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bK\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\bA\b\u0086\b\u0018\u0000 \u0087\u00012\u00020\u0001:~\u0081\u0001\u0082\u0001\u0083\u0001\u0084\u0001\u0085\u0001\u0086\u0001\u0087\u0001\u0088\u0001\u0089\u0001\u008a\u0001\u008b\u0001\u008c\u0001\u008d\u0001\u008e\u0001\u008f\u0001\u0090\u0001\u0091\u0001\u0092\u0001\u0093\u0001\u0094\u0001\u0095\u0001\u0096\u0001\u0097\u0001\u0098\u0001\u0099\u0001\u009a\u0001\u009b\u0001\u009c\u0001\u009d\u0001\u009e\u0001\u009f\u0001 \u0001¡\u0001¢\u0001£\u0001¤\u0001¥\u0001¦\u0001§\u0001¨\u0001©\u0001ª\u0001«\u0001¬\u0001\u00ad\u0001®\u0001¯\u0001°\u0001±\u0001²\u0001³\u0001´\u0001µ\u0001¶\u0001·\u0001¸\u0001¹\u0001º\u0001»\u0001¼\u0001½\u0001¾\u0001¿\u0001B\u009d\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#\u0012\u0006\u0010$\u001a\u00020%\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.¢\u0006\u0002\u0010/J\t\u0010_\u001a\u00020\u0003HÆ\u0003J\t\u0010`\u001a\u00020\u0011HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010!HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010#HÆ\u0003J\t\u0010j\u001a\u00020\u0005HÆ\u0003J\t\u0010k\u001a\u00020%HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010'HÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010)HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010+HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010'HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010.HÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010u\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010v\u001a\u00020\rHÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u000fHÆ\u0003J«\u0002\u0010x\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010$\u001a\u00020%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.HÆ\u0001J\u0013\u0010y\u001a\u00020z2\b\u0010{\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010|\u001a\u00020}HÖ\u0001J\u0006\u0010~\u001a\u00020\u007fJ\n\u0010\u0080\u0001\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b6\u00105R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0013\u0010*\u001a\u0004\u0018\u00010+¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0013\u0010&\u001a\u0004\u0018\u00010'¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0011\u0010$\u001a\u00020%¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bC\u00105R\u0013\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0013\u0010,\u001a\u0004\u0018\u00010'¢\u0006\b\n\u0000\u001a\u0004\bH\u0010>R\u0013\u0010 \u001a\u0004\u0018\u00010!¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0013\u0010-\u001a\u0004\u0018\u00010.¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bM\u00105R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0013\u0010(\u001a\u0004\u0018\u00010)¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0014\u0010X\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bY\u00105R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\\\u00105R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^¨\u0006À\u0001"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent;", "", "date", "", "application", "Lcom/datadog/android/rum/model/ViewEvent$Application;", "service", "", "version", "buildVersion", "buildId", "ddtags", "session", "Lcom/datadog/android/rum/model/ViewEvent$ViewEventSession;", "source", "Lcom/datadog/android/rum/model/ViewEvent$ViewEventSource;", "view", "Lcom/datadog/android/rum/model/ViewEvent$ViewEventView;", "usr", "Lcom/datadog/android/rum/model/ViewEvent$Usr;", "account", "Lcom/datadog/android/rum/model/ViewEvent$Account;", "tab", "Lcom/datadog/android/rum/model/ViewEvent$Tab;", "connectivity", "Lcom/datadog/android/rum/model/ViewEvent$Connectivity;", "display", "Lcom/datadog/android/rum/model/ViewEvent$Display;", "synthetics", "Lcom/datadog/android/rum/model/ViewEvent$Synthetics;", "ciTest", "Lcom/datadog/android/rum/model/ViewEvent$CiTest;", "os", "Lcom/datadog/android/rum/model/ViewEvent$Os;", "device", "Lcom/datadog/android/rum/model/ViewEvent$Device;", "dd", "Lcom/datadog/android/rum/model/ViewEvent$Dd;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/rum/model/ViewEvent$Context;", "stream", "Lcom/datadog/android/rum/model/ViewEvent$Stream;", WebViewRumEventMapper.CONTAINER_KEY_NAME, "Lcom/datadog/android/rum/model/ViewEvent$Container;", "featureFlags", "privacy", "Lcom/datadog/android/rum/model/ViewEvent$Privacy;", "(JLcom/datadog/android/rum/model/ViewEvent$Application;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/datadog/android/rum/model/ViewEvent$ViewEventSession;Lcom/datadog/android/rum/model/ViewEvent$ViewEventSource;Lcom/datadog/android/rum/model/ViewEvent$ViewEventView;Lcom/datadog/android/rum/model/ViewEvent$Usr;Lcom/datadog/android/rum/model/ViewEvent$Account;Lcom/datadog/android/rum/model/ViewEvent$Tab;Lcom/datadog/android/rum/model/ViewEvent$Connectivity;Lcom/datadog/android/rum/model/ViewEvent$Display;Lcom/datadog/android/rum/model/ViewEvent$Synthetics;Lcom/datadog/android/rum/model/ViewEvent$CiTest;Lcom/datadog/android/rum/model/ViewEvent$Os;Lcom/datadog/android/rum/model/ViewEvent$Device;Lcom/datadog/android/rum/model/ViewEvent$Dd;Lcom/datadog/android/rum/model/ViewEvent$Context;Lcom/datadog/android/rum/model/ViewEvent$Stream;Lcom/datadog/android/rum/model/ViewEvent$Container;Lcom/datadog/android/rum/model/ViewEvent$Context;Lcom/datadog/android/rum/model/ViewEvent$Privacy;)V", "getAccount", "()Lcom/datadog/android/rum/model/ViewEvent$Account;", "getApplication", "()Lcom/datadog/android/rum/model/ViewEvent$Application;", "getBuildId", "()Ljava/lang/String;", "getBuildVersion", "getCiTest", "()Lcom/datadog/android/rum/model/ViewEvent$CiTest;", "getConnectivity", "()Lcom/datadog/android/rum/model/ViewEvent$Connectivity;", "getContainer", "()Lcom/datadog/android/rum/model/ViewEvent$Container;", "getContext", "()Lcom/datadog/android/rum/model/ViewEvent$Context;", "getDate", "()J", "getDd", "()Lcom/datadog/android/rum/model/ViewEvent$Dd;", "getDdtags", "getDevice", "()Lcom/datadog/android/rum/model/ViewEvent$Device;", "getDisplay", "()Lcom/datadog/android/rum/model/ViewEvent$Display;", "getFeatureFlags", "getOs", "()Lcom/datadog/android/rum/model/ViewEvent$Os;", "getPrivacy", "()Lcom/datadog/android/rum/model/ViewEvent$Privacy;", "getService", "getSession", "()Lcom/datadog/android/rum/model/ViewEvent$ViewEventSession;", "getSource", "()Lcom/datadog/android/rum/model/ViewEvent$ViewEventSource;", "getStream", "()Lcom/datadog/android/rum/model/ViewEvent$Stream;", "getSynthetics", "()Lcom/datadog/android/rum/model/ViewEvent$Synthetics;", "getTab", "()Lcom/datadog/android/rum/model/ViewEvent$Tab;", "type", "getType", "getUsr", "()Lcom/datadog/android/rum/model/ViewEvent$Usr;", "getVersion", "getView", "()Lcom/datadog/android/rum/model/ViewEvent$ViewEventView;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Accessibility", "Account", "Action", "Application", "Cellular", "CiTest", "Companion", "Configuration", "Connectivity", "ConnectivityStatus", TextFieldImplKt.ContainerId, "ContainerView", "Context", "Crash", "CustomTimings", "Dd", "DdCls", "DdSession", "Device", "DeviceType", "Display", "EffectiveType", "Error", "ErrorReason", "Fbc", "Fcp", "Fid", "FlutterBuildTime", "FrozenFrame", "Frustration", "InForegroundPeriod", "Inp", "InpSubParts", "Interface", "Lcp", "LcpSubParts", "LoadingType", "LongTask", "Os", "PageState", "Performance", "PerformanceCls", "Plan", "PreviousRect", "Privacy", "Profiling", "ProfilingStatus", "ReplayLevel", "ReplayStats", "Resource", "Scroll", "SessionPrecondition", "SlowFrame", "State", "Stream", "Synthetics", "Tab", "Usr", "ViewEventSession", "ViewEventSessionType", "ViewEventSource", "ViewEventView", "Viewport", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ViewEvent {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Account account;
    private final Application application;
    private final String buildId;
    private final String buildVersion;
    private final CiTest ciTest;
    private final Connectivity connectivity;
    private final Container container;
    private final Context context;
    private final long date;
    private final Dd dd;
    private final String ddtags;
    private final Device device;
    private final Display display;
    private final Context featureFlags;
    private final Os os;
    private final Privacy privacy;
    private final String service;
    private final ViewEventSession session;
    private final ViewEventSource source;
    private final Stream stream;
    private final Synthetics synthetics;
    private final Tab tab;
    private final String type;
    private final Usr usr;
    private final String version;
    private final ViewEventView view;

    public static /* synthetic */ ViewEvent copy$default(ViewEvent viewEvent, long j, Application application, String str, String str2, String str3, String str4, String str5, ViewEventSession viewEventSession, ViewEventSource viewEventSource, ViewEventView viewEventView, Usr usr, Account account, Tab tab, Connectivity connectivity, Display display, Synthetics synthetics, CiTest ciTest, Os os, Device device, Dd dd, Context context, Stream stream, Container container, Context context2, Privacy privacy, int i, Object obj) {
        Privacy privacy2;
        Context context3;
        long j2 = (i & 1) != 0 ? viewEvent.date : j;
        Application application2 = (i & 2) != 0 ? viewEvent.application : application;
        String str6 = (i & 4) != 0 ? viewEvent.service : str;
        String str7 = (i & 8) != 0 ? viewEvent.version : str2;
        String str8 = (i & 16) != 0 ? viewEvent.buildVersion : str3;
        String str9 = (i & 32) != 0 ? viewEvent.buildId : str4;
        String str10 = (i & 64) != 0 ? viewEvent.ddtags : str5;
        ViewEventSession viewEventSession2 = (i & 128) != 0 ? viewEvent.session : viewEventSession;
        ViewEventSource viewEventSource2 = (i & 256) != 0 ? viewEvent.source : viewEventSource;
        ViewEventView viewEventView2 = (i & 512) != 0 ? viewEvent.view : viewEventView;
        Usr usr2 = (i & 1024) != 0 ? viewEvent.usr : usr;
        Account account2 = (i & 2048) != 0 ? viewEvent.account : account;
        Tab tab2 = (i & 4096) != 0 ? viewEvent.tab : tab;
        long j3 = j2;
        Connectivity connectivity2 = (i & 8192) != 0 ? viewEvent.connectivity : connectivity;
        Display display2 = (i & 16384) != 0 ? viewEvent.display : display;
        Synthetics synthetics2 = (i & 32768) != 0 ? viewEvent.synthetics : synthetics;
        CiTest ciTest2 = (i & 65536) != 0 ? viewEvent.ciTest : ciTest;
        Os os2 = (i & 131072) != 0 ? viewEvent.os : os;
        Device device2 = (i & 262144) != 0 ? viewEvent.device : device;
        Dd dd2 = (i & 524288) != 0 ? viewEvent.dd : dd;
        Context context4 = (i & 1048576) != 0 ? viewEvent.context : context;
        Stream stream2 = (i & 2097152) != 0 ? viewEvent.stream : stream;
        Container container2 = (i & 4194304) != 0 ? viewEvent.container : container;
        Context context5 = (i & 8388608) != 0 ? viewEvent.featureFlags : context2;
        if ((i & 16777216) != 0) {
            context3 = context5;
            privacy2 = viewEvent.privacy;
        } else {
            privacy2 = privacy;
            context3 = context5;
        }
        return viewEvent.copy(j3, application2, str6, str7, str8, str9, str10, viewEventSession2, viewEventSource2, viewEventView2, usr2, account2, tab2, connectivity2, display2, synthetics2, ciTest2, os2, device2, dd2, context4, stream2, container2, context3, privacy2);
    }

    @JvmStatic
    public static final ViewEvent fromJson(String str) throws JsonParseException {
        return INSTANCE.fromJson(str);
    }

    @JvmStatic
    public static final ViewEvent fromJsonObject(JsonObject jsonObject) throws JsonParseException {
        return INSTANCE.fromJsonObject(jsonObject);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final ViewEventView getView() {
        return this.view;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Usr getUsr() {
        return this.usr;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Account getAccount() {
        return this.account;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Tab getTab() {
        return this.tab;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Connectivity getConnectivity() {
        return this.connectivity;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final Display getDisplay() {
        return this.display;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final Synthetics getSynthetics() {
        return this.synthetics;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final CiTest getCiTest() {
        return this.ciTest;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final Os getOs() {
        return this.os;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final Device getDevice() {
        return this.device;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final Dd getDd() {
        return this.dd;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final Stream getStream() {
        return this.stream;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final Container getContainer() {
        return this.container;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final Context getFeatureFlags() {
        return this.featureFlags;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final Privacy getPrivacy() {
        return this.privacy;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getService() {
        return this.service;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getBuildVersion() {
        return this.buildVersion;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getBuildId() {
        return this.buildId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getDdtags() {
        return this.ddtags;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final ViewEventSession getSession() {
        return this.session;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final ViewEventSource getSource() {
        return this.source;
    }

    public final ViewEvent copy(long date, Application application, String service, String version, String buildVersion, String buildId, String ddtags, ViewEventSession session, ViewEventSource source, ViewEventView view, Usr usr, Account account, Tab tab, Connectivity connectivity, Display display, Synthetics synthetics, CiTest ciTest, Os os, Device device, Dd dd, Context context, Stream stream, Container container, Context featureFlags, Privacy privacy) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dd, "dd");
        return new ViewEvent(date, application, service, version, buildVersion, buildId, ddtags, session, source, view, usr, account, tab, connectivity, display, synthetics, ciTest, os, device, dd, context, stream, container, featureFlags, privacy);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ViewEvent)) {
            return false;
        }
        ViewEvent viewEvent = (ViewEvent) other;
        return this.date == viewEvent.date && Intrinsics.areEqual(this.application, viewEvent.application) && Intrinsics.areEqual(this.service, viewEvent.service) && Intrinsics.areEqual(this.version, viewEvent.version) && Intrinsics.areEqual(this.buildVersion, viewEvent.buildVersion) && Intrinsics.areEqual(this.buildId, viewEvent.buildId) && Intrinsics.areEqual(this.ddtags, viewEvent.ddtags) && Intrinsics.areEqual(this.session, viewEvent.session) && this.source == viewEvent.source && Intrinsics.areEqual(this.view, viewEvent.view) && Intrinsics.areEqual(this.usr, viewEvent.usr) && Intrinsics.areEqual(this.account, viewEvent.account) && Intrinsics.areEqual(this.tab, viewEvent.tab) && Intrinsics.areEqual(this.connectivity, viewEvent.connectivity) && Intrinsics.areEqual(this.display, viewEvent.display) && Intrinsics.areEqual(this.synthetics, viewEvent.synthetics) && Intrinsics.areEqual(this.ciTest, viewEvent.ciTest) && Intrinsics.areEqual(this.os, viewEvent.os) && Intrinsics.areEqual(this.device, viewEvent.device) && Intrinsics.areEqual(this.dd, viewEvent.dd) && Intrinsics.areEqual(this.context, viewEvent.context) && Intrinsics.areEqual(this.stream, viewEvent.stream) && Intrinsics.areEqual(this.container, viewEvent.container) && Intrinsics.areEqual(this.featureFlags, viewEvent.featureFlags) && Intrinsics.areEqual(this.privacy, viewEvent.privacy);
    }

    public int hashCode() {
        int iHashCode = ((Long.hashCode(this.date) * 31) + this.application.hashCode()) * 31;
        String str = this.service;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.version;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.buildVersion;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.buildId;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.ddtags;
        int iHashCode6 = (((iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.session.hashCode()) * 31;
        ViewEventSource viewEventSource = this.source;
        int iHashCode7 = (((iHashCode6 + (viewEventSource == null ? 0 : viewEventSource.hashCode())) * 31) + this.view.hashCode()) * 31;
        Usr usr = this.usr;
        int iHashCode8 = (iHashCode7 + (usr == null ? 0 : usr.hashCode())) * 31;
        Account account = this.account;
        int iHashCode9 = (iHashCode8 + (account == null ? 0 : account.hashCode())) * 31;
        Tab tab = this.tab;
        int iHashCode10 = (iHashCode9 + (tab == null ? 0 : tab.hashCode())) * 31;
        Connectivity connectivity = this.connectivity;
        int iHashCode11 = (iHashCode10 + (connectivity == null ? 0 : connectivity.hashCode())) * 31;
        Display display = this.display;
        int iHashCode12 = (iHashCode11 + (display == null ? 0 : display.hashCode())) * 31;
        Synthetics synthetics = this.synthetics;
        int iHashCode13 = (iHashCode12 + (synthetics == null ? 0 : synthetics.hashCode())) * 31;
        CiTest ciTest = this.ciTest;
        int iHashCode14 = (iHashCode13 + (ciTest == null ? 0 : ciTest.hashCode())) * 31;
        Os os = this.os;
        int iHashCode15 = (iHashCode14 + (os == null ? 0 : os.hashCode())) * 31;
        Device device = this.device;
        int iHashCode16 = (((iHashCode15 + (device == null ? 0 : device.hashCode())) * 31) + this.dd.hashCode()) * 31;
        Context context = this.context;
        int iHashCode17 = (iHashCode16 + (context == null ? 0 : context.hashCode())) * 31;
        Stream stream = this.stream;
        int iHashCode18 = (iHashCode17 + (stream == null ? 0 : stream.hashCode())) * 31;
        Container container = this.container;
        int iHashCode19 = (iHashCode18 + (container == null ? 0 : container.hashCode())) * 31;
        Context context2 = this.featureFlags;
        int iHashCode20 = (iHashCode19 + (context2 == null ? 0 : context2.hashCode())) * 31;
        Privacy privacy = this.privacy;
        return iHashCode20 + (privacy != null ? privacy.hashCode() : 0);
    }

    public String toString() {
        return "ViewEvent(date=" + this.date + ", application=" + this.application + ", service=" + this.service + ", version=" + this.version + ", buildVersion=" + this.buildVersion + ", buildId=" + this.buildId + ", ddtags=" + this.ddtags + ", session=" + this.session + ", source=" + this.source + ", view=" + this.view + ", usr=" + this.usr + ", account=" + this.account + ", tab=" + this.tab + ", connectivity=" + this.connectivity + ", display=" + this.display + ", synthetics=" + this.synthetics + ", ciTest=" + this.ciTest + ", os=" + this.os + ", device=" + this.device + ", dd=" + this.dd + ", context=" + this.context + ", stream=" + this.stream + ", container=" + this.container + ", featureFlags=" + this.featureFlags + ", privacy=" + this.privacy + ")";
    }

    public ViewEvent(long j, Application application, String str, String str2, String str3, String str4, String str5, ViewEventSession session, ViewEventSource viewEventSource, ViewEventView view, Usr usr, Account account, Tab tab, Connectivity connectivity, Display display, Synthetics synthetics, CiTest ciTest, Os os, Device device, Dd dd, Context context, Stream stream, Container container, Context context2, Privacy privacy) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dd, "dd");
        this.date = j;
        this.application = application;
        this.service = str;
        this.version = str2;
        this.buildVersion = str3;
        this.buildId = str4;
        this.ddtags = str5;
        this.session = session;
        this.source = viewEventSource;
        this.view = view;
        this.usr = usr;
        this.account = account;
        this.tab = tab;
        this.connectivity = connectivity;
        this.display = display;
        this.synthetics = synthetics;
        this.ciTest = ciTest;
        this.os = os;
        this.device = device;
        this.dd = dd;
        this.context = context;
        this.stream = stream;
        this.container = container;
        this.featureFlags = context2;
        this.privacy = privacy;
        this.type = "view";
    }

    public /* synthetic */ ViewEvent(long j, Application application, String str, String str2, String str3, String str4, String str5, ViewEventSession viewEventSession, ViewEventSource viewEventSource, ViewEventView viewEventView, Usr usr, Account account, Tab tab, Connectivity connectivity, Display display, Synthetics synthetics, CiTest ciTest, Os os, Device device, Dd dd, Context context, Stream stream, Container container, Context context2, Privacy privacy, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, application, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, viewEventSession, (i & 256) != 0 ? null : viewEventSource, viewEventView, (i & 1024) != 0 ? null : usr, (i & 2048) != 0 ? null : account, (i & 4096) != 0 ? null : tab, (i & 8192) != 0 ? null : connectivity, (i & 16384) != 0 ? null : display, (32768 & i) != 0 ? null : synthetics, (65536 & i) != 0 ? null : ciTest, (131072 & i) != 0 ? null : os, (262144 & i) != 0 ? null : device, dd, (1048576 & i) != 0 ? null : context, (2097152 & i) != 0 ? null : stream, (4194304 & i) != 0 ? null : container, (8388608 & i) != 0 ? null : context2, (i & 16777216) != 0 ? null : privacy);
    }

    public final long getDate() {
        return this.date;
    }

    public final Application getApplication() {
        return this.application;
    }

    public final String getService() {
        return this.service;
    }

    public final String getVersion() {
        return this.version;
    }

    public final String getBuildVersion() {
        return this.buildVersion;
    }

    public final String getBuildId() {
        return this.buildId;
    }

    public final String getDdtags() {
        return this.ddtags;
    }

    public final ViewEventSession getSession() {
        return this.session;
    }

    public final ViewEventSource getSource() {
        return this.source;
    }

    public final ViewEventView getView() {
        return this.view;
    }

    public final Usr getUsr() {
        return this.usr;
    }

    public final Account getAccount() {
        return this.account;
    }

    public final Tab getTab() {
        return this.tab;
    }

    public final Connectivity getConnectivity() {
        return this.connectivity;
    }

    public final Display getDisplay() {
        return this.display;
    }

    public final Synthetics getSynthetics() {
        return this.synthetics;
    }

    public final CiTest getCiTest() {
        return this.ciTest;
    }

    public final Os getOs() {
        return this.os;
    }

    public final Device getDevice() {
        return this.device;
    }

    public final Dd getDd() {
        return this.dd;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Stream getStream() {
        return this.stream;
    }

    public final Container getContainer() {
        return this.container;
    }

    public final Context getFeatureFlags() {
        return this.featureFlags;
    }

    public final Privacy getPrivacy() {
        return this.privacy;
    }

    public final String getType() {
        return this.type;
    }

    public final JsonElement toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("date", Long.valueOf(this.date));
        jsonObject.add("application", this.application.toJson());
        String str = this.service;
        if (str != null) {
            jsonObject.addProperty("service", str);
        }
        String str2 = this.version;
        if (str2 != null) {
            jsonObject.addProperty("version", str2);
        }
        String str3 = this.buildVersion;
        if (str3 != null) {
            jsonObject.addProperty("build_version", str3);
        }
        String str4 = this.buildId;
        if (str4 != null) {
            jsonObject.addProperty("build_id", str4);
        }
        String str5 = this.ddtags;
        if (str5 != null) {
            jsonObject.addProperty("ddtags", str5);
        }
        jsonObject.add("session", this.session.toJson());
        ViewEventSource viewEventSource = this.source;
        if (viewEventSource != null) {
            jsonObject.add("source", viewEventSource.toJson());
        }
        jsonObject.add("view", this.view.toJson());
        Usr usr = this.usr;
        if (usr != null) {
            jsonObject.add("usr", usr.toJson());
        }
        Account account = this.account;
        if (account != null) {
            jsonObject.add("account", account.toJson());
        }
        Tab tab = this.tab;
        if (tab != null) {
            jsonObject.add("tab", tab.toJson());
        }
        Connectivity connectivity = this.connectivity;
        if (connectivity != null) {
            jsonObject.add("connectivity", connectivity.toJson());
        }
        Display display = this.display;
        if (display != null) {
            jsonObject.add("display", display.toJson());
        }
        Synthetics synthetics = this.synthetics;
        if (synthetics != null) {
            jsonObject.add("synthetics", synthetics.toJson());
        }
        CiTest ciTest = this.ciTest;
        if (ciTest != null) {
            jsonObject.add("ci_test", ciTest.toJson());
        }
        Os os = this.os;
        if (os != null) {
            jsonObject.add("os", os.toJson());
        }
        Device device = this.device;
        if (device != null) {
            jsonObject.add("device", device.toJson());
        }
        jsonObject.add(WebViewRumEventMapper.DD_KEY_NAME, this.dd.toJson());
        Context context = this.context;
        if (context != null) {
            jsonObject.add(RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, context.toJson());
        }
        Stream stream = this.stream;
        if (stream != null) {
            jsonObject.add("stream", stream.toJson());
        }
        Container container = this.container;
        if (container != null) {
            jsonObject.add(WebViewRumEventMapper.CONTAINER_KEY_NAME, container.toJson());
        }
        Context context2 = this.featureFlags;
        if (context2 != null) {
            jsonObject.add("feature_flags", context2.toJson());
        }
        Privacy privacy = this.privacy;
        if (privacy != null) {
            jsonObject.add("privacy", privacy.toJson());
        }
        jsonObject.addProperty("type", this.type);
        return jsonObject;
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ViewEvent fromJson(String jsonString) throws JsonParseException {
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            try {
                JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                return fromJsonObject(jsonObject);
            } catch (IllegalStateException e) {
                throw new JsonParseException("Unable to parse json into type ViewEvent", e);
            }
        }

        @JvmStatic
        public final ViewEvent fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            JsonObject asJsonObject;
            JsonObject asJsonObject2;
            JsonObject asJsonObject3;
            JsonObject asJsonObject4;
            JsonObject asJsonObject5;
            JsonObject asJsonObject6;
            JsonObject asJsonObject7;
            JsonObject asJsonObject8;
            JsonObject asJsonObject9;
            JsonObject asJsonObject10;
            JsonObject asJsonObject11;
            JsonObject asJsonObject12;
            JsonObject asJsonObject13;
            JsonObject asJsonObject14;
            String asString;
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            try {
                long asLong = jsonObject.get("date").getAsLong();
                JsonObject it = jsonObject.get("application").getAsJsonObject();
                Application.Companion companion = Application.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                Application applicationFromJsonObject = companion.fromJsonObject(it);
                JsonElement jsonElement = jsonObject.get("service");
                String asString2 = jsonElement != null ? jsonElement.getAsString() : null;
                JsonElement jsonElement2 = jsonObject.get("version");
                String asString3 = jsonElement2 != null ? jsonElement2.getAsString() : null;
                JsonElement jsonElement3 = jsonObject.get("build_version");
                String asString4 = jsonElement3 != null ? jsonElement3.getAsString() : null;
                JsonElement jsonElement4 = jsonObject.get("build_id");
                String asString5 = jsonElement4 != null ? jsonElement4.getAsString() : null;
                JsonElement jsonElement5 = jsonObject.get("ddtags");
                String asString6 = jsonElement5 != null ? jsonElement5.getAsString() : null;
                JsonObject it2 = jsonObject.get("session").getAsJsonObject();
                ViewEventSession.Companion companion2 = ViewEventSession.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                ViewEventSession viewEventSessionFromJsonObject = companion2.fromJsonObject(it2);
                JsonElement jsonElement6 = jsonObject.get("source");
                ViewEventSource viewEventSourceFromJson = (jsonElement6 == null || (asString = jsonElement6.getAsString()) == null) ? null : ViewEventSource.INSTANCE.fromJson(asString);
                JsonObject it3 = jsonObject.get("view").getAsJsonObject();
                ViewEventView.Companion companion3 = ViewEventView.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it3, "it");
                ViewEventView viewEventViewFromJsonObject = companion3.fromJsonObject(it3);
                JsonElement jsonElement7 = jsonObject.get("usr");
                Usr usrFromJsonObject = (jsonElement7 == null || (asJsonObject14 = jsonElement7.getAsJsonObject()) == null) ? null : Usr.INSTANCE.fromJsonObject(asJsonObject14);
                JsonElement jsonElement8 = jsonObject.get("account");
                Account accountFromJsonObject = (jsonElement8 == null || (asJsonObject13 = jsonElement8.getAsJsonObject()) == null) ? null : Account.INSTANCE.fromJsonObject(asJsonObject13);
                JsonElement jsonElement9 = jsonObject.get("tab");
                Tab tabFromJsonObject = (jsonElement9 == null || (asJsonObject12 = jsonElement9.getAsJsonObject()) == null) ? null : Tab.INSTANCE.fromJsonObject(asJsonObject12);
                JsonElement jsonElement10 = jsonObject.get("connectivity");
                Connectivity connectivityFromJsonObject = (jsonElement10 == null || (asJsonObject11 = jsonElement10.getAsJsonObject()) == null) ? null : Connectivity.INSTANCE.fromJsonObject(asJsonObject11);
                JsonElement jsonElement11 = jsonObject.get("display");
                Display displayFromJsonObject = (jsonElement11 == null || (asJsonObject10 = jsonElement11.getAsJsonObject()) == null) ? null : Display.INSTANCE.fromJsonObject(asJsonObject10);
                JsonElement jsonElement12 = jsonObject.get("synthetics");
                Synthetics syntheticsFromJsonObject = (jsonElement12 == null || (asJsonObject9 = jsonElement12.getAsJsonObject()) == null) ? null : Synthetics.INSTANCE.fromJsonObject(asJsonObject9);
                JsonElement jsonElement13 = jsonObject.get("ci_test");
                CiTest ciTestFromJsonObject = (jsonElement13 == null || (asJsonObject8 = jsonElement13.getAsJsonObject()) == null) ? null : CiTest.INSTANCE.fromJsonObject(asJsonObject8);
                JsonElement jsonElement14 = jsonObject.get("os");
                Os osFromJsonObject = (jsonElement14 == null || (asJsonObject7 = jsonElement14.getAsJsonObject()) == null) ? null : Os.INSTANCE.fromJsonObject(asJsonObject7);
                JsonElement jsonElement15 = jsonObject.get("device");
                Device deviceFromJsonObject = (jsonElement15 == null || (asJsonObject6 = jsonElement15.getAsJsonObject()) == null) ? null : Device.INSTANCE.fromJsonObject(asJsonObject6);
                JsonObject it4 = jsonObject.get(WebViewRumEventMapper.DD_KEY_NAME).getAsJsonObject();
                Dd.Companion companion4 = Dd.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it4, "it");
                Dd ddFromJsonObject = companion4.fromJsonObject(it4);
                JsonElement jsonElement16 = jsonObject.get(RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX);
                Context contextFromJsonObject = (jsonElement16 == null || (asJsonObject5 = jsonElement16.getAsJsonObject()) == null) ? null : Context.INSTANCE.fromJsonObject(asJsonObject5);
                JsonElement jsonElement17 = jsonObject.get("stream");
                Stream streamFromJsonObject = (jsonElement17 == null || (asJsonObject4 = jsonElement17.getAsJsonObject()) == null) ? null : Stream.INSTANCE.fromJsonObject(asJsonObject4);
                JsonElement jsonElement18 = jsonObject.get(WebViewRumEventMapper.CONTAINER_KEY_NAME);
                Container containerFromJsonObject = (jsonElement18 == null || (asJsonObject3 = jsonElement18.getAsJsonObject()) == null) ? null : Container.INSTANCE.fromJsonObject(asJsonObject3);
                JsonElement jsonElement19 = jsonObject.get("feature_flags");
                Context contextFromJsonObject2 = (jsonElement19 == null || (asJsonObject2 = jsonElement19.getAsJsonObject()) == null) ? null : Context.INSTANCE.fromJsonObject(asJsonObject2);
                JsonElement jsonElement20 = jsonObject.get("privacy");
                Privacy privacyFromJsonObject = (jsonElement20 == null || (asJsonObject = jsonElement20.getAsJsonObject()) == null) ? null : Privacy.INSTANCE.fromJsonObject(asJsonObject);
                if (!Intrinsics.areEqual(jsonObject.get("type").getAsString(), "view")) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                return new ViewEvent(asLong, applicationFromJsonObject, asString2, asString3, asString4, asString5, asString6, viewEventSessionFromJsonObject, viewEventSourceFromJson, viewEventViewFromJsonObject, usrFromJsonObject, accountFromJsonObject, tabFromJsonObject, connectivityFromJsonObject, displayFromJsonObject, syntheticsFromJsonObject, ciTestFromJsonObject, osFromJsonObject, deviceFromJsonObject, ddFromJsonObject, contextFromJsonObject, streamFromJsonObject, containerFromJsonObject, contextFromJsonObject2, privacyFromJsonObject);
            } catch (IllegalStateException e) {
                throw new JsonParseException("Unable to parse json into type ViewEvent", e);
            } catch (NullPointerException e2) {
                throw new JsonParseException("Unable to parse json into type ViewEvent", e2);
            } catch (NumberFormatException e3) {
                throw new JsonParseException("Unable to parse json into type ViewEvent", e3);
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Application;", "", "id", "", "currentLocale", "(Ljava/lang/String;Ljava/lang/String;)V", "getCurrentLocale", "()Ljava/lang/String;", "getId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Application {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String currentLocale;
        private final String id;

        public static /* synthetic */ Application copy$default(Application application, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = application.id;
            }
            if ((i & 2) != 0) {
                str2 = application.currentLocale;
            }
            return application.copy(str, str2);
        }

        @JvmStatic
        public static final Application fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Application fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getCurrentLocale() {
            return this.currentLocale;
        }

        public final Application copy(String id, String currentLocale) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Application(id, currentLocale);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Application)) {
                return false;
            }
            Application application = (Application) other;
            return Intrinsics.areEqual(this.id, application.id) && Intrinsics.areEqual(this.currentLocale, application.currentLocale);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.currentLocale;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Application(id=" + this.id + ", currentLocale=" + this.currentLocale + ")";
        }

        public Application(String id, String str) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
            this.currentLocale = str;
        }

        public /* synthetic */ Application(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2);
        }

        public final String getId() {
            return this.id;
        }

        public final String getCurrentLocale() {
            return this.currentLocale;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id", this.id);
            String str = this.currentLocale;
            if (str != null) {
                jsonObject.addProperty("current_locale", str);
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Application$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$Application;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Application fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Application", e);
                }
            }

            @JvmStatic
            public final Application fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String id = jsonObject.get("id").getAsString();
                    JsonElement jsonElement = jsonObject.get("current_locale");
                    String asString = jsonElement != null ? jsonElement.getAsString() : null;
                    Intrinsics.checkNotNullExpressionValue(id, "id");
                    return new Application(id, asString);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Application", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Application", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Application", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001!B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\fJF\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0006\u0010\u001e\u001a\u00020\u001fJ\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\b\u0010\fR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\""}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$ViewEventSession;", "", "id", "", "type", "Lcom/datadog/android/rum/model/ViewEvent$ViewEventSessionType;", "hasReplay", "", "isActive", "sampledForReplay", "(Ljava/lang/String;Lcom/datadog/android/rum/model/ViewEvent$ViewEventSessionType;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getHasReplay", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getId", "()Ljava/lang/String;", "getSampledForReplay", "getType", "()Lcom/datadog/android/rum/model/ViewEvent$ViewEventSessionType;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Lcom/datadog/android/rum/model/ViewEvent$ViewEventSessionType;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/datadog/android/rum/model/ViewEvent$ViewEventSession;", "equals", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class ViewEventSession {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Boolean hasReplay;
        private final String id;
        private final Boolean isActive;
        private final Boolean sampledForReplay;
        private final ViewEventSessionType type;

        public static /* synthetic */ ViewEventSession copy$default(ViewEventSession viewEventSession, String str, ViewEventSessionType viewEventSessionType, Boolean bool, Boolean bool2, Boolean bool3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = viewEventSession.id;
            }
            if ((i & 2) != 0) {
                viewEventSessionType = viewEventSession.type;
            }
            if ((i & 4) != 0) {
                bool = viewEventSession.hasReplay;
            }
            if ((i & 8) != 0) {
                bool2 = viewEventSession.isActive;
            }
            if ((i & 16) != 0) {
                bool3 = viewEventSession.sampledForReplay;
            }
            Boolean bool4 = bool3;
            Boolean bool5 = bool;
            return viewEventSession.copy(str, viewEventSessionType, bool5, bool2, bool4);
        }

        @JvmStatic
        public static final ViewEventSession fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final ViewEventSession fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ViewEventSessionType getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Boolean getHasReplay() {
            return this.hasReplay;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Boolean getIsActive() {
            return this.isActive;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Boolean getSampledForReplay() {
            return this.sampledForReplay;
        }

        public final ViewEventSession copy(String id, ViewEventSessionType type, Boolean hasReplay, Boolean isActive, Boolean sampledForReplay) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            return new ViewEventSession(id, type, hasReplay, isActive, sampledForReplay);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewEventSession)) {
                return false;
            }
            ViewEventSession viewEventSession = (ViewEventSession) other;
            return Intrinsics.areEqual(this.id, viewEventSession.id) && this.type == viewEventSession.type && Intrinsics.areEqual(this.hasReplay, viewEventSession.hasReplay) && Intrinsics.areEqual(this.isActive, viewEventSession.isActive) && Intrinsics.areEqual(this.sampledForReplay, viewEventSession.sampledForReplay);
        }

        public int hashCode() {
            int iHashCode = ((this.id.hashCode() * 31) + this.type.hashCode()) * 31;
            Boolean bool = this.hasReplay;
            int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.isActive;
            int iHashCode3 = (iHashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.sampledForReplay;
            return iHashCode3 + (bool3 != null ? bool3.hashCode() : 0);
        }

        public String toString() {
            return "ViewEventSession(id=" + this.id + ", type=" + this.type + ", hasReplay=" + this.hasReplay + ", isActive=" + this.isActive + ", sampledForReplay=" + this.sampledForReplay + ")";
        }

        public ViewEventSession(String id, ViewEventSessionType type, Boolean bool, Boolean bool2, Boolean bool3) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            this.id = id;
            this.type = type;
            this.hasReplay = bool;
            this.isActive = bool2;
            this.sampledForReplay = bool3;
        }

        public final String getId() {
            return this.id;
        }

        public final ViewEventSessionType getType() {
            return this.type;
        }

        public final Boolean getHasReplay() {
            return this.hasReplay;
        }

        public /* synthetic */ ViewEventSession(String str, ViewEventSessionType viewEventSessionType, Boolean bool, Boolean bool2, Boolean bool3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, viewEventSessionType, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? true : bool2, (i & 16) != 0 ? null : bool3);
        }

        public final Boolean isActive() {
            return this.isActive;
        }

        public final Boolean getSampledForReplay() {
            return this.sampledForReplay;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id", this.id);
            jsonObject.add("type", this.type.toJson());
            Boolean bool = this.hasReplay;
            if (bool != null) {
                bool.booleanValue();
                jsonObject.addProperty("has_replay", bool);
            }
            Boolean bool2 = this.isActive;
            if (bool2 != null) {
                bool2.booleanValue();
                jsonObject.addProperty("is_active", bool2);
            }
            Boolean bool3 = this.sampledForReplay;
            if (bool3 != null) {
                bool3.booleanValue();
                jsonObject.addProperty("sampled_for_replay", bool3);
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$ViewEventSession$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$ViewEventSession;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final ViewEventSession fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type ViewEventSession", e);
                }
            }

            @JvmStatic
            public final ViewEventSession fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String id = jsonObject.get("id").getAsString();
                    ViewEventSessionType.Companion companion = ViewEventSessionType.INSTANCE;
                    String asString = jsonObject.get("type").getAsString();
                    Intrinsics.checkNotNullExpressionValue(asString, "jsonObject.get(\"type\").asString");
                    ViewEventSessionType viewEventSessionTypeFromJson = companion.fromJson(asString);
                    JsonElement jsonElement = jsonObject.get("has_replay");
                    Boolean boolValueOf = jsonElement != null ? Boolean.valueOf(jsonElement.getAsBoolean()) : null;
                    JsonElement jsonElement2 = jsonObject.get("is_active");
                    Boolean boolValueOf2 = jsonElement2 != null ? Boolean.valueOf(jsonElement2.getAsBoolean()) : null;
                    JsonElement jsonElement3 = jsonObject.get("sampled_for_replay");
                    Boolean boolValueOf3 = jsonElement3 != null ? Boolean.valueOf(jsonElement3.getAsBoolean()) : null;
                    Intrinsics.checkNotNullExpressionValue(id, "id");
                    return new ViewEventSession(id, viewEventSessionTypeFromJson, boolValueOf, boolValueOf2, boolValueOf3);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type ViewEventSession", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type ViewEventSession", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type ViewEventSession", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000\u0099\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0004\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0003\b\u0082\u0001\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 Î\u00012\u00020\u0001:\u0002Î\u0001BÝ\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\u0006\u0010%\u001a\u00020&\u0012\u0006\u0010'\u001a\u00020(\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.\u0012\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u000201\u0018\u000100\u0012\u0006\u00102\u001a\u000203\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000105\u0012\u0010\b\u0002\u00106\u001a\n\u0012\u0004\u0012\u000207\u0018\u000100\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010A\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010A\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010A\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010E\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010G¢\u0006\u0002\u0010HJ\n\u0010\u0092\u0001\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0093\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010VJ\u0011\u0010\u0094\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010VJ\f\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0096\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010VJ\u0011\u0010\u0097\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010VJ\f\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0099\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010VJ\u0011\u0010\u009a\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010VJ\f\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\f\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u009e\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010VJ\f\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010 \u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010VJ\u0011\u0010¡\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010VJ\u0011\u0010¢\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010VJ\u0011\u0010£\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010VJ\u0011\u0010¤\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010VJ\f\u0010¥\u0001\u001a\u0004\u0018\u00010!HÆ\u0003J\u0011\u0010¦\u0001\u001a\u0004\u0018\u00010#HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010§\u0001\u001a\u0004\u0018\u00010#HÆ\u0003¢\u0006\u0002\u0010sJ\n\u0010¨\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010©\u0001\u001a\u00020&HÆ\u0003J\n\u0010ª\u0001\u001a\u00020(HÆ\u0003J\f\u0010«\u0001\u001a\u0004\u0018\u00010*HÆ\u0003J\f\u0010¬\u0001\u001a\u0004\u0018\u00010,HÆ\u0003J\f\u0010\u00ad\u0001\u001a\u0004\u0018\u00010.HÆ\u0003J\u0012\u0010®\u0001\u001a\n\u0012\u0004\u0012\u000201\u0018\u000100HÆ\u0003J\n\u0010¯\u0001\u001a\u000203HÆ\u0003J\f\u0010°\u0001\u001a\u0004\u0018\u000105HÆ\u0003J\u0012\u0010±\u0001\u001a\n\u0012\u0004\u0012\u000207\u0018\u000100HÆ\u0003J\f\u0010²\u0001\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\f\u0010³\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010´\u0001\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\f\u0010µ\u0001\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\f\u0010¶\u0001\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\f\u0010·\u0001\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\f\u0010¸\u0001\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\f\u0010¹\u0001\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\f\u0010º\u0001\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\f\u0010»\u0001\u001a\u0004\u0018\u00010AHÆ\u0003J\f\u0010¼\u0001\u001a\u0004\u0018\u00010AHÆ\u0003J\f\u0010½\u0001\u001a\u0004\u0018\u00010AHÆ\u0003J\u0011\u0010¾\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010VJ\f\u0010¿\u0001\u001a\u0004\u0018\u00010EHÆ\u0003J\f\u0010À\u0001\u001a\u0004\u0018\u00010GHÆ\u0003J\u0011\u0010Á\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010VJ\u0011\u0010Â\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010VJ\f\u0010Ã\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003J\n\u0010Ä\u0001\u001a\u00020\bHÆ\u0003Jô\u0004\u0010Å\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001002\b\b\u0002\u00102\u001a\u0002032\n\b\u0002\u00104\u001a\u0004\u0018\u0001052\u0010\b\u0002\u00106\u001a\n\u0012\u0004\u0012\u000207\u0018\u0001002\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010@\u001a\u0004\u0018\u00010A2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010A2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010A2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010E2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010GHÆ\u0001¢\u0006\u0003\u0010Æ\u0001J\u0015\u0010Ç\u0001\u001a\u00020#2\t\u0010È\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000b\u0010É\u0001\u001a\u00030Ê\u0001HÖ\u0001J\b\u0010Ë\u0001\u001a\u00030Ì\u0001J\n\u0010Í\u0001\u001a\u00020\u0003HÖ\u0001R\u0013\u0010F\u001a\u0004\u0018\u00010G¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0011\u0010%\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0013\u0010:\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0013\u0010;\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\bO\u0010NR\u0013\u0010)\u001a\u0004\u0018\u00010*¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\bR\u0010NR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u0015\u0010\u0019\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010W\u001a\u0004\bU\u0010VR\u0013\u0010 \u001a\u0004\u0018\u00010!¢\u0006\b\n\u0000\u001a\u0004\bX\u0010YR\u0015\u0010\u001b\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010W\u001a\u0004\bZ\u0010VR\u0015\u0010\u001c\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010W\u001a\u0004\b[\u0010VR\u0015\u0010\u001d\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010W\u001a\u0004\b\\\u0010VR\u0011\u0010'\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^R\u0015\u0010\u001f\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010W\u001a\u0004\b_\u0010VR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010W\u001a\u0004\b`\u0010VR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010W\u001a\u0004\ba\u0010VR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bb\u0010TR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010W\u001a\u0004\bc\u0010VR\u0013\u0010@\u001a\u0004\u0018\u00010A¢\u0006\b\n\u0000\u001a\u0004\bd\u0010eR\u0013\u0010B\u001a\u0004\u0018\u00010A¢\u0006\b\n\u0000\u001a\u0004\bf\u0010eR\u0013\u0010?\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\bg\u0010NR\u0013\u0010-\u001a\u0004\u0018\u00010.¢\u0006\b\n\u0000\u001a\u0004\bh\u0010iR\u0013\u00104\u001a\u0004\u0018\u000105¢\u0006\b\n\u0000\u001a\u0004\bj\u0010kR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bl\u0010TR\u0019\u00106\u001a\n\u0012\u0004\u0012\u000207\u0018\u000100¢\u0006\b\n\u0000\u001a\u0004\bm\u0010nR\u0015\u0010\u0014\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010W\u001a\u0004\bo\u0010VR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bp\u0010TR\u0015\u0010\u0015\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010W\u001a\u0004\bq\u0010VR\u0015\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010W\u001a\u0004\br\u0010VR\u0015\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\n\n\u0002\u0010t\u001a\u0004\b\"\u0010sR\u0015\u0010$\u001a\u0004\u0018\u00010#¢\u0006\n\n\u0002\u0010t\u001a\u0004\b$\u0010sR\u0013\u0010C\u001a\u0004\u0018\u00010A¢\u0006\b\n\u0000\u001a\u0004\bu\u0010eR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010W\u001a\u0004\bv\u0010VR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bw\u0010TR\u0015\u0010\u001e\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010W\u001a\u0004\bx\u0010VR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010W\u001a\u0004\by\u0010VR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\bz\u0010{R\u0013\u0010+\u001a\u0004\u0018\u00010,¢\u0006\b\n\u0000\u001a\u0004\b|\u0010}R\u0013\u00108\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b~\u0010NR\u0013\u00109\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010NR\u001f\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0080\u0001\u0010T\"\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0016\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u000b\n\u0002\u0010W\u001a\u0005\b\u0083\u0001\u0010VR\u0015\u0010D\u001a\u0004\u0018\u00010E¢\u0006\n\n\u0000\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001f\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0086\u0001\u0010T\"\u0006\b\u0087\u0001\u0010\u0082\u0001R\u0014\u0010<\u001a\u0004\u0018\u00010\u0018¢\u0006\t\n\u0000\u001a\u0005\b\u0088\u0001\u0010NR\u0014\u0010=\u001a\u0004\u0018\u00010\u0018¢\u0006\t\n\u0000\u001a\u0005\b\u0089\u0001\u0010NR\u0013\u00102\u001a\u000203¢\u0006\n\n\u0000\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001a\u0010/\u001a\n\u0012\u0004\u0012\u000201\u0018\u000100¢\u0006\t\n\u0000\u001a\u0005\b\u008c\u0001\u0010nR\u0014\u0010>\u001a\u0004\u0018\u00010\u0018¢\u0006\t\n\u0000\u001a\u0005\b\u008d\u0001\u0010NR\u0013\u0010\r\u001a\u00020\b¢\u0006\n\n\u0000\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001d\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0090\u0001\u0010T\"\u0006\b\u0091\u0001\u0010\u0082\u0001¨\u0006Ï\u0001"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$ViewEventView;", "", "id", "", "referrer", ImagesContract.URL, "name", "loadingTime", "", "networkSettledTime", "interactionToNextViewTime", "loadingType", "Lcom/datadog/android/rum/model/ViewEvent$LoadingType;", "timeSpent", "firstContentfulPaint", "largestContentfulPaint", "largestContentfulPaintTargetSelector", "firstInputDelay", "firstInputTime", "firstInputTargetSelector", "interactionToNextPaint", "interactionToNextPaintTime", "interactionToNextPaintTargetSelector", "cumulativeLayoutShift", "", "cumulativeLayoutShiftTime", "cumulativeLayoutShiftTargetSelector", "domComplete", "domContentLoaded", "domInteractive", "loadEvent", "firstByte", "customTimings", "Lcom/datadog/android/rum/model/ViewEvent$CustomTimings;", "isActive", "", "isSlowRendered", "action", "Lcom/datadog/android/rum/model/ViewEvent$Action;", "error", "Lcom/datadog/android/rum/model/ViewEvent$Error;", "crash", "Lcom/datadog/android/rum/model/ViewEvent$Crash;", "longTask", "Lcom/datadog/android/rum/model/ViewEvent$LongTask;", "frozenFrame", "Lcom/datadog/android/rum/model/ViewEvent$FrozenFrame;", "slowFrames", "", "Lcom/datadog/android/rum/model/ViewEvent$SlowFrame;", "resource", "Lcom/datadog/android/rum/model/ViewEvent$Resource;", "frustration", "Lcom/datadog/android/rum/model/ViewEvent$Frustration;", "inForegroundPeriods", "Lcom/datadog/android/rum/model/ViewEvent$InForegroundPeriod;", "memoryAverage", "memoryMax", "cpuTicksCount", "cpuTicksPerSecond", "refreshRateAverage", "refreshRateMin", "slowFramesRate", "freezeRate", "flutterBuildTime", "Lcom/datadog/android/rum/model/ViewEvent$FlutterBuildTime;", "flutterRasterTime", "jsRefreshRate", "performance", "Lcom/datadog/android/rum/model/ViewEvent$Performance;", "accessibility", "Lcom/datadog/android/rum/model/ViewEvent$Accessibility;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lcom/datadog/android/rum/model/ViewEvent$LoadingType;JLjava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lcom/datadog/android/rum/model/ViewEvent$CustomTimings;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/datadog/android/rum/model/ViewEvent$Action;Lcom/datadog/android/rum/model/ViewEvent$Error;Lcom/datadog/android/rum/model/ViewEvent$Crash;Lcom/datadog/android/rum/model/ViewEvent$LongTask;Lcom/datadog/android/rum/model/ViewEvent$FrozenFrame;Ljava/util/List;Lcom/datadog/android/rum/model/ViewEvent$Resource;Lcom/datadog/android/rum/model/ViewEvent$Frustration;Ljava/util/List;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Lcom/datadog/android/rum/model/ViewEvent$FlutterBuildTime;Lcom/datadog/android/rum/model/ViewEvent$FlutterBuildTime;Lcom/datadog/android/rum/model/ViewEvent$FlutterBuildTime;Lcom/datadog/android/rum/model/ViewEvent$Performance;Lcom/datadog/android/rum/model/ViewEvent$Accessibility;)V", "getAccessibility", "()Lcom/datadog/android/rum/model/ViewEvent$Accessibility;", "getAction", "()Lcom/datadog/android/rum/model/ViewEvent$Action;", "getCpuTicksCount", "()Ljava/lang/Number;", "getCpuTicksPerSecond", "getCrash", "()Lcom/datadog/android/rum/model/ViewEvent$Crash;", "getCumulativeLayoutShift", "getCumulativeLayoutShiftTargetSelector", "()Ljava/lang/String;", "getCumulativeLayoutShiftTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCustomTimings", "()Lcom/datadog/android/rum/model/ViewEvent$CustomTimings;", "getDomComplete", "getDomContentLoaded", "getDomInteractive", "getError", "()Lcom/datadog/android/rum/model/ViewEvent$Error;", "getFirstByte", "getFirstContentfulPaint", "getFirstInputDelay", "getFirstInputTargetSelector", "getFirstInputTime", "getFlutterBuildTime", "()Lcom/datadog/android/rum/model/ViewEvent$FlutterBuildTime;", "getFlutterRasterTime", "getFreezeRate", "getFrozenFrame", "()Lcom/datadog/android/rum/model/ViewEvent$FrozenFrame;", "getFrustration", "()Lcom/datadog/android/rum/model/ViewEvent$Frustration;", "getId", "getInForegroundPeriods", "()Ljava/util/List;", "getInteractionToNextPaint", "getInteractionToNextPaintTargetSelector", "getInteractionToNextPaintTime", "getInteractionToNextViewTime", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getJsRefreshRate", "getLargestContentfulPaint", "getLargestContentfulPaintTargetSelector", "getLoadEvent", "getLoadingTime", "getLoadingType", "()Lcom/datadog/android/rum/model/ViewEvent$LoadingType;", "getLongTask", "()Lcom/datadog/android/rum/model/ViewEvent$LongTask;", "getMemoryAverage", "getMemoryMax", "getName", InsiderHybridMethods.SET_NAME, "(Ljava/lang/String;)V", "getNetworkSettledTime", "getPerformance", "()Lcom/datadog/android/rum/model/ViewEvent$Performance;", "getReferrer", "setReferrer", "getRefreshRateAverage", "getRefreshRateMin", "getResource", "()Lcom/datadog/android/rum/model/ViewEvent$Resource;", "getSlowFrames", "getSlowFramesRate", "getTimeSpent", "()J", "getUrl", "setUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component50", "component51", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lcom/datadog/android/rum/model/ViewEvent$LoadingType;JLjava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lcom/datadog/android/rum/model/ViewEvent$CustomTimings;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/datadog/android/rum/model/ViewEvent$Action;Lcom/datadog/android/rum/model/ViewEvent$Error;Lcom/datadog/android/rum/model/ViewEvent$Crash;Lcom/datadog/android/rum/model/ViewEvent$LongTask;Lcom/datadog/android/rum/model/ViewEvent$FrozenFrame;Ljava/util/List;Lcom/datadog/android/rum/model/ViewEvent$Resource;Lcom/datadog/android/rum/model/ViewEvent$Frustration;Ljava/util/List;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Lcom/datadog/android/rum/model/ViewEvent$FlutterBuildTime;Lcom/datadog/android/rum/model/ViewEvent$FlutterBuildTime;Lcom/datadog/android/rum/model/ViewEvent$FlutterBuildTime;Lcom/datadog/android/rum/model/ViewEvent$Performance;Lcom/datadog/android/rum/model/ViewEvent$Accessibility;)Lcom/datadog/android/rum/model/ViewEvent$ViewEventView;", "equals", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class ViewEventView {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Accessibility accessibility;
        private final Action action;
        private final Number cpuTicksCount;
        private final Number cpuTicksPerSecond;
        private final Crash crash;
        private final Number cumulativeLayoutShift;
        private final String cumulativeLayoutShiftTargetSelector;
        private final Long cumulativeLayoutShiftTime;
        private final CustomTimings customTimings;
        private final Long domComplete;
        private final Long domContentLoaded;
        private final Long domInteractive;
        private final Error error;
        private final Long firstByte;
        private final Long firstContentfulPaint;
        private final Long firstInputDelay;
        private final String firstInputTargetSelector;
        private final Long firstInputTime;
        private final FlutterBuildTime flutterBuildTime;
        private final FlutterBuildTime flutterRasterTime;
        private final Number freezeRate;
        private final FrozenFrame frozenFrame;
        private final Frustration frustration;
        private final String id;
        private final List<InForegroundPeriod> inForegroundPeriods;
        private final Long interactionToNextPaint;
        private final String interactionToNextPaintTargetSelector;
        private final Long interactionToNextPaintTime;
        private final Long interactionToNextViewTime;
        private final Boolean isActive;
        private final Boolean isSlowRendered;
        private final FlutterBuildTime jsRefreshRate;
        private final Long largestContentfulPaint;
        private final String largestContentfulPaintTargetSelector;
        private final Long loadEvent;
        private final Long loadingTime;
        private final LoadingType loadingType;
        private final LongTask longTask;
        private final Number memoryAverage;
        private final Number memoryMax;
        private String name;
        private final Long networkSettledTime;
        private final Performance performance;
        private String referrer;
        private final Number refreshRateAverage;
        private final Number refreshRateMin;
        private final Resource resource;
        private final List<SlowFrame> slowFrames;
        private final Number slowFramesRate;
        private final long timeSpent;
        private String url;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewEventView copy$default(ViewEventView viewEventView, String str, String str2, String str3, String str4, Long l, Long l2, Long l3, LoadingType loadingType, long j, Long l4, Long l5, String str5, Long l6, Long l7, String str6, Long l8, Long l9, String str7, Number number, Long l10, String str8, Long l11, Long l12, Long l13, Long l14, Long l15, CustomTimings customTimings, Boolean bool, Boolean bool2, Action action, Error error, Crash crash, LongTask longTask, FrozenFrame frozenFrame, List list, Resource resource, Frustration frustration, List list2, Number number2, Number number3, Number number4, Number number5, Number number6, Number number7, Number number8, Number number9, FlutterBuildTime flutterBuildTime, FlutterBuildTime flutterBuildTime2, FlutterBuildTime flutterBuildTime3, Performance performance, Accessibility accessibility, int i, int i2, Object obj) {
            String str9 = (i & 1) != 0 ? viewEventView.id : str;
            return viewEventView.copy(str9, (i & 2) != 0 ? viewEventView.referrer : str2, (i & 4) != 0 ? viewEventView.url : str3, (i & 8) != 0 ? viewEventView.name : str4, (i & 16) != 0 ? viewEventView.loadingTime : l, (i & 32) != 0 ? viewEventView.networkSettledTime : l2, (i & 64) != 0 ? viewEventView.interactionToNextViewTime : l3, (i & 128) != 0 ? viewEventView.loadingType : loadingType, (i & 256) != 0 ? viewEventView.timeSpent : j, (i & 512) != 0 ? viewEventView.firstContentfulPaint : l4, (i & 1024) != 0 ? viewEventView.largestContentfulPaint : l5, (i & 2048) != 0 ? viewEventView.largestContentfulPaintTargetSelector : str5, (i & 4096) != 0 ? viewEventView.firstInputDelay : l6, (i & 8192) != 0 ? viewEventView.firstInputTime : l7, (i & 16384) != 0 ? viewEventView.firstInputTargetSelector : str6, (i & 32768) != 0 ? viewEventView.interactionToNextPaint : l8, (i & 65536) != 0 ? viewEventView.interactionToNextPaintTime : l9, (i & 131072) != 0 ? viewEventView.interactionToNextPaintTargetSelector : str7, (i & 262144) != 0 ? viewEventView.cumulativeLayoutShift : number, (i & 524288) != 0 ? viewEventView.cumulativeLayoutShiftTime : l10, (i & 1048576) != 0 ? viewEventView.cumulativeLayoutShiftTargetSelector : str8, (i & 2097152) != 0 ? viewEventView.domComplete : l11, (i & 4194304) != 0 ? viewEventView.domContentLoaded : l12, (i & 8388608) != 0 ? viewEventView.domInteractive : l13, (i & 16777216) != 0 ? viewEventView.loadEvent : l14, (i & GroupFlagsKt.HasAuxSlotFlag) != 0 ? viewEventView.firstByte : l15, (i & 67108864) != 0 ? viewEventView.customTimings : customTimings, (i & 134217728) != 0 ? viewEventView.isActive : bool, (i & 268435456) != 0 ? viewEventView.isSlowRendered : bool2, (i & 536870912) != 0 ? viewEventView.action : action, (i & 1073741824) != 0 ? viewEventView.error : error, (i & Integer.MIN_VALUE) != 0 ? viewEventView.crash : crash, (i2 & 1) != 0 ? viewEventView.longTask : longTask, (i2 & 2) != 0 ? viewEventView.frozenFrame : frozenFrame, (i2 & 4) != 0 ? viewEventView.slowFrames : list, (i2 & 8) != 0 ? viewEventView.resource : resource, (i2 & 16) != 0 ? viewEventView.frustration : frustration, (i2 & 32) != 0 ? viewEventView.inForegroundPeriods : list2, (i2 & 64) != 0 ? viewEventView.memoryAverage : number2, (i2 & 128) != 0 ? viewEventView.memoryMax : number3, (i2 & 256) != 0 ? viewEventView.cpuTicksCount : number4, (i2 & 512) != 0 ? viewEventView.cpuTicksPerSecond : number5, (i2 & 1024) != 0 ? viewEventView.refreshRateAverage : number6, (i2 & 2048) != 0 ? viewEventView.refreshRateMin : number7, (i2 & 4096) != 0 ? viewEventView.slowFramesRate : number8, (i2 & 8192) != 0 ? viewEventView.freezeRate : number9, (i2 & 16384) != 0 ? viewEventView.flutterBuildTime : flutterBuildTime, (i2 & 32768) != 0 ? viewEventView.flutterRasterTime : flutterBuildTime2, (i2 & 65536) != 0 ? viewEventView.jsRefreshRate : flutterBuildTime3, (i2 & 131072) != 0 ? viewEventView.performance : performance, (i2 & 262144) != 0 ? viewEventView.accessibility : accessibility);
        }

        @JvmStatic
        public static final ViewEventView fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final ViewEventView fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Long getFirstContentfulPaint() {
            return this.firstContentfulPaint;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Long getLargestContentfulPaint() {
            return this.largestContentfulPaint;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getLargestContentfulPaintTargetSelector() {
            return this.largestContentfulPaintTargetSelector;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final Long getFirstInputDelay() {
            return this.firstInputDelay;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final Long getFirstInputTime() {
            return this.firstInputTime;
        }

        /* JADX INFO: renamed from: component15, reason: from getter */
        public final String getFirstInputTargetSelector() {
            return this.firstInputTargetSelector;
        }

        /* JADX INFO: renamed from: component16, reason: from getter */
        public final Long getInteractionToNextPaint() {
            return this.interactionToNextPaint;
        }

        /* JADX INFO: renamed from: component17, reason: from getter */
        public final Long getInteractionToNextPaintTime() {
            return this.interactionToNextPaintTime;
        }

        /* JADX INFO: renamed from: component18, reason: from getter */
        public final String getInteractionToNextPaintTargetSelector() {
            return this.interactionToNextPaintTargetSelector;
        }

        /* JADX INFO: renamed from: component19, reason: from getter */
        public final Number getCumulativeLayoutShift() {
            return this.cumulativeLayoutShift;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getReferrer() {
            return this.referrer;
        }

        /* JADX INFO: renamed from: component20, reason: from getter */
        public final Long getCumulativeLayoutShiftTime() {
            return this.cumulativeLayoutShiftTime;
        }

        /* JADX INFO: renamed from: component21, reason: from getter */
        public final String getCumulativeLayoutShiftTargetSelector() {
            return this.cumulativeLayoutShiftTargetSelector;
        }

        /* JADX INFO: renamed from: component22, reason: from getter */
        public final Long getDomComplete() {
            return this.domComplete;
        }

        /* JADX INFO: renamed from: component23, reason: from getter */
        public final Long getDomContentLoaded() {
            return this.domContentLoaded;
        }

        /* JADX INFO: renamed from: component24, reason: from getter */
        public final Long getDomInteractive() {
            return this.domInteractive;
        }

        /* JADX INFO: renamed from: component25, reason: from getter */
        public final Long getLoadEvent() {
            return this.loadEvent;
        }

        /* JADX INFO: renamed from: component26, reason: from getter */
        public final Long getFirstByte() {
            return this.firstByte;
        }

        /* JADX INFO: renamed from: component27, reason: from getter */
        public final CustomTimings getCustomTimings() {
            return this.customTimings;
        }

        /* JADX INFO: renamed from: component28, reason: from getter */
        public final Boolean getIsActive() {
            return this.isActive;
        }

        /* JADX INFO: renamed from: component29, reason: from getter */
        public final Boolean getIsSlowRendered() {
            return this.isSlowRendered;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* JADX INFO: renamed from: component30, reason: from getter */
        public final Action getAction() {
            return this.action;
        }

        /* JADX INFO: renamed from: component31, reason: from getter */
        public final Error getError() {
            return this.error;
        }

        /* JADX INFO: renamed from: component32, reason: from getter */
        public final Crash getCrash() {
            return this.crash;
        }

        /* JADX INFO: renamed from: component33, reason: from getter */
        public final LongTask getLongTask() {
            return this.longTask;
        }

        /* JADX INFO: renamed from: component34, reason: from getter */
        public final FrozenFrame getFrozenFrame() {
            return this.frozenFrame;
        }

        public final List<SlowFrame> component35() {
            return this.slowFrames;
        }

        /* JADX INFO: renamed from: component36, reason: from getter */
        public final Resource getResource() {
            return this.resource;
        }

        /* JADX INFO: renamed from: component37, reason: from getter */
        public final Frustration getFrustration() {
            return this.frustration;
        }

        public final List<InForegroundPeriod> component38() {
            return this.inForegroundPeriods;
        }

        /* JADX INFO: renamed from: component39, reason: from getter */
        public final Number getMemoryAverage() {
            return this.memoryAverage;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component40, reason: from getter */
        public final Number getMemoryMax() {
            return this.memoryMax;
        }

        /* JADX INFO: renamed from: component41, reason: from getter */
        public final Number getCpuTicksCount() {
            return this.cpuTicksCount;
        }

        /* JADX INFO: renamed from: component42, reason: from getter */
        public final Number getCpuTicksPerSecond() {
            return this.cpuTicksPerSecond;
        }

        /* JADX INFO: renamed from: component43, reason: from getter */
        public final Number getRefreshRateAverage() {
            return this.refreshRateAverage;
        }

        /* JADX INFO: renamed from: component44, reason: from getter */
        public final Number getRefreshRateMin() {
            return this.refreshRateMin;
        }

        /* JADX INFO: renamed from: component45, reason: from getter */
        public final Number getSlowFramesRate() {
            return this.slowFramesRate;
        }

        /* JADX INFO: renamed from: component46, reason: from getter */
        public final Number getFreezeRate() {
            return this.freezeRate;
        }

        /* JADX INFO: renamed from: component47, reason: from getter */
        public final FlutterBuildTime getFlutterBuildTime() {
            return this.flutterBuildTime;
        }

        /* JADX INFO: renamed from: component48, reason: from getter */
        public final FlutterBuildTime getFlutterRasterTime() {
            return this.flutterRasterTime;
        }

        /* JADX INFO: renamed from: component49, reason: from getter */
        public final FlutterBuildTime getJsRefreshRate() {
            return this.jsRefreshRate;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Long getLoadingTime() {
            return this.loadingTime;
        }

        /* JADX INFO: renamed from: component50, reason: from getter */
        public final Performance getPerformance() {
            return this.performance;
        }

        /* JADX INFO: renamed from: component51, reason: from getter */
        public final Accessibility getAccessibility() {
            return this.accessibility;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Long getNetworkSettledTime() {
            return this.networkSettledTime;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Long getInteractionToNextViewTime() {
            return this.interactionToNextViewTime;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final LoadingType getLoadingType() {
            return this.loadingType;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final long getTimeSpent() {
            return this.timeSpent;
        }

        public final ViewEventView copy(String id, String referrer, String url, String name, Long loadingTime, Long networkSettledTime, Long interactionToNextViewTime, LoadingType loadingType, long timeSpent, Long firstContentfulPaint, Long largestContentfulPaint, String largestContentfulPaintTargetSelector, Long firstInputDelay, Long firstInputTime, String firstInputTargetSelector, Long interactionToNextPaint, Long interactionToNextPaintTime, String interactionToNextPaintTargetSelector, Number cumulativeLayoutShift, Long cumulativeLayoutShiftTime, String cumulativeLayoutShiftTargetSelector, Long domComplete, Long domContentLoaded, Long domInteractive, Long loadEvent, Long firstByte, CustomTimings customTimings, Boolean isActive, Boolean isSlowRendered, Action action, Error error, Crash crash, LongTask longTask, FrozenFrame frozenFrame, List<SlowFrame> slowFrames, Resource resource, Frustration frustration, List<InForegroundPeriod> inForegroundPeriods, Number memoryAverage, Number memoryMax, Number cpuTicksCount, Number cpuTicksPerSecond, Number refreshRateAverage, Number refreshRateMin, Number slowFramesRate, Number freezeRate, FlutterBuildTime flutterBuildTime, FlutterBuildTime flutterRasterTime, FlutterBuildTime jsRefreshRate, Performance performance, Accessibility accessibility) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(resource, "resource");
            return new ViewEventView(id, referrer, url, name, loadingTime, networkSettledTime, interactionToNextViewTime, loadingType, timeSpent, firstContentfulPaint, largestContentfulPaint, largestContentfulPaintTargetSelector, firstInputDelay, firstInputTime, firstInputTargetSelector, interactionToNextPaint, interactionToNextPaintTime, interactionToNextPaintTargetSelector, cumulativeLayoutShift, cumulativeLayoutShiftTime, cumulativeLayoutShiftTargetSelector, domComplete, domContentLoaded, domInteractive, loadEvent, firstByte, customTimings, isActive, isSlowRendered, action, error, crash, longTask, frozenFrame, slowFrames, resource, frustration, inForegroundPeriods, memoryAverage, memoryMax, cpuTicksCount, cpuTicksPerSecond, refreshRateAverage, refreshRateMin, slowFramesRate, freezeRate, flutterBuildTime, flutterRasterTime, jsRefreshRate, performance, accessibility);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewEventView)) {
                return false;
            }
            ViewEventView viewEventView = (ViewEventView) other;
            return Intrinsics.areEqual(this.id, viewEventView.id) && Intrinsics.areEqual(this.referrer, viewEventView.referrer) && Intrinsics.areEqual(this.url, viewEventView.url) && Intrinsics.areEqual(this.name, viewEventView.name) && Intrinsics.areEqual(this.loadingTime, viewEventView.loadingTime) && Intrinsics.areEqual(this.networkSettledTime, viewEventView.networkSettledTime) && Intrinsics.areEqual(this.interactionToNextViewTime, viewEventView.interactionToNextViewTime) && this.loadingType == viewEventView.loadingType && this.timeSpent == viewEventView.timeSpent && Intrinsics.areEqual(this.firstContentfulPaint, viewEventView.firstContentfulPaint) && Intrinsics.areEqual(this.largestContentfulPaint, viewEventView.largestContentfulPaint) && Intrinsics.areEqual(this.largestContentfulPaintTargetSelector, viewEventView.largestContentfulPaintTargetSelector) && Intrinsics.areEqual(this.firstInputDelay, viewEventView.firstInputDelay) && Intrinsics.areEqual(this.firstInputTime, viewEventView.firstInputTime) && Intrinsics.areEqual(this.firstInputTargetSelector, viewEventView.firstInputTargetSelector) && Intrinsics.areEqual(this.interactionToNextPaint, viewEventView.interactionToNextPaint) && Intrinsics.areEqual(this.interactionToNextPaintTime, viewEventView.interactionToNextPaintTime) && Intrinsics.areEqual(this.interactionToNextPaintTargetSelector, viewEventView.interactionToNextPaintTargetSelector) && Intrinsics.areEqual(this.cumulativeLayoutShift, viewEventView.cumulativeLayoutShift) && Intrinsics.areEqual(this.cumulativeLayoutShiftTime, viewEventView.cumulativeLayoutShiftTime) && Intrinsics.areEqual(this.cumulativeLayoutShiftTargetSelector, viewEventView.cumulativeLayoutShiftTargetSelector) && Intrinsics.areEqual(this.domComplete, viewEventView.domComplete) && Intrinsics.areEqual(this.domContentLoaded, viewEventView.domContentLoaded) && Intrinsics.areEqual(this.domInteractive, viewEventView.domInteractive) && Intrinsics.areEqual(this.loadEvent, viewEventView.loadEvent) && Intrinsics.areEqual(this.firstByte, viewEventView.firstByte) && Intrinsics.areEqual(this.customTimings, viewEventView.customTimings) && Intrinsics.areEqual(this.isActive, viewEventView.isActive) && Intrinsics.areEqual(this.isSlowRendered, viewEventView.isSlowRendered) && Intrinsics.areEqual(this.action, viewEventView.action) && Intrinsics.areEqual(this.error, viewEventView.error) && Intrinsics.areEqual(this.crash, viewEventView.crash) && Intrinsics.areEqual(this.longTask, viewEventView.longTask) && Intrinsics.areEqual(this.frozenFrame, viewEventView.frozenFrame) && Intrinsics.areEqual(this.slowFrames, viewEventView.slowFrames) && Intrinsics.areEqual(this.resource, viewEventView.resource) && Intrinsics.areEqual(this.frustration, viewEventView.frustration) && Intrinsics.areEqual(this.inForegroundPeriods, viewEventView.inForegroundPeriods) && Intrinsics.areEqual(this.memoryAverage, viewEventView.memoryAverage) && Intrinsics.areEqual(this.memoryMax, viewEventView.memoryMax) && Intrinsics.areEqual(this.cpuTicksCount, viewEventView.cpuTicksCount) && Intrinsics.areEqual(this.cpuTicksPerSecond, viewEventView.cpuTicksPerSecond) && Intrinsics.areEqual(this.refreshRateAverage, viewEventView.refreshRateAverage) && Intrinsics.areEqual(this.refreshRateMin, viewEventView.refreshRateMin) && Intrinsics.areEqual(this.slowFramesRate, viewEventView.slowFramesRate) && Intrinsics.areEqual(this.freezeRate, viewEventView.freezeRate) && Intrinsics.areEqual(this.flutterBuildTime, viewEventView.flutterBuildTime) && Intrinsics.areEqual(this.flutterRasterTime, viewEventView.flutterRasterTime) && Intrinsics.areEqual(this.jsRefreshRate, viewEventView.jsRefreshRate) && Intrinsics.areEqual(this.performance, viewEventView.performance) && Intrinsics.areEqual(this.accessibility, viewEventView.accessibility);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.referrer;
            int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.url.hashCode()) * 31;
            String str2 = this.name;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Long l = this.loadingTime;
            int iHashCode4 = (iHashCode3 + (l == null ? 0 : l.hashCode())) * 31;
            Long l2 = this.networkSettledTime;
            int iHashCode5 = (iHashCode4 + (l2 == null ? 0 : l2.hashCode())) * 31;
            Long l3 = this.interactionToNextViewTime;
            int iHashCode6 = (iHashCode5 + (l3 == null ? 0 : l3.hashCode())) * 31;
            LoadingType loadingType = this.loadingType;
            int iHashCode7 = (((iHashCode6 + (loadingType == null ? 0 : loadingType.hashCode())) * 31) + Long.hashCode(this.timeSpent)) * 31;
            Long l4 = this.firstContentfulPaint;
            int iHashCode8 = (iHashCode7 + (l4 == null ? 0 : l4.hashCode())) * 31;
            Long l5 = this.largestContentfulPaint;
            int iHashCode9 = (iHashCode8 + (l5 == null ? 0 : l5.hashCode())) * 31;
            String str3 = this.largestContentfulPaintTargetSelector;
            int iHashCode10 = (iHashCode9 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Long l6 = this.firstInputDelay;
            int iHashCode11 = (iHashCode10 + (l6 == null ? 0 : l6.hashCode())) * 31;
            Long l7 = this.firstInputTime;
            int iHashCode12 = (iHashCode11 + (l7 == null ? 0 : l7.hashCode())) * 31;
            String str4 = this.firstInputTargetSelector;
            int iHashCode13 = (iHashCode12 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Long l8 = this.interactionToNextPaint;
            int iHashCode14 = (iHashCode13 + (l8 == null ? 0 : l8.hashCode())) * 31;
            Long l9 = this.interactionToNextPaintTime;
            int iHashCode15 = (iHashCode14 + (l9 == null ? 0 : l9.hashCode())) * 31;
            String str5 = this.interactionToNextPaintTargetSelector;
            int iHashCode16 = (iHashCode15 + (str5 == null ? 0 : str5.hashCode())) * 31;
            Number number = this.cumulativeLayoutShift;
            int iHashCode17 = (iHashCode16 + (number == null ? 0 : number.hashCode())) * 31;
            Long l10 = this.cumulativeLayoutShiftTime;
            int iHashCode18 = (iHashCode17 + (l10 == null ? 0 : l10.hashCode())) * 31;
            String str6 = this.cumulativeLayoutShiftTargetSelector;
            int iHashCode19 = (iHashCode18 + (str6 == null ? 0 : str6.hashCode())) * 31;
            Long l11 = this.domComplete;
            int iHashCode20 = (iHashCode19 + (l11 == null ? 0 : l11.hashCode())) * 31;
            Long l12 = this.domContentLoaded;
            int iHashCode21 = (iHashCode20 + (l12 == null ? 0 : l12.hashCode())) * 31;
            Long l13 = this.domInteractive;
            int iHashCode22 = (iHashCode21 + (l13 == null ? 0 : l13.hashCode())) * 31;
            Long l14 = this.loadEvent;
            int iHashCode23 = (iHashCode22 + (l14 == null ? 0 : l14.hashCode())) * 31;
            Long l15 = this.firstByte;
            int iHashCode24 = (iHashCode23 + (l15 == null ? 0 : l15.hashCode())) * 31;
            CustomTimings customTimings = this.customTimings;
            int iHashCode25 = (iHashCode24 + (customTimings == null ? 0 : customTimings.hashCode())) * 31;
            Boolean bool = this.isActive;
            int iHashCode26 = (iHashCode25 + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.isSlowRendered;
            int iHashCode27 = (((((iHashCode26 + (bool2 == null ? 0 : bool2.hashCode())) * 31) + this.action.hashCode()) * 31) + this.error.hashCode()) * 31;
            Crash crash = this.crash;
            int iHashCode28 = (iHashCode27 + (crash == null ? 0 : crash.hashCode())) * 31;
            LongTask longTask = this.longTask;
            int iHashCode29 = (iHashCode28 + (longTask == null ? 0 : longTask.hashCode())) * 31;
            FrozenFrame frozenFrame = this.frozenFrame;
            int iHashCode30 = (iHashCode29 + (frozenFrame == null ? 0 : frozenFrame.hashCode())) * 31;
            List<SlowFrame> list = this.slowFrames;
            int iHashCode31 = (((iHashCode30 + (list == null ? 0 : list.hashCode())) * 31) + this.resource.hashCode()) * 31;
            Frustration frustration = this.frustration;
            int iHashCode32 = (iHashCode31 + (frustration == null ? 0 : frustration.hashCode())) * 31;
            List<InForegroundPeriod> list2 = this.inForegroundPeriods;
            int iHashCode33 = (iHashCode32 + (list2 == null ? 0 : list2.hashCode())) * 31;
            Number number2 = this.memoryAverage;
            int iHashCode34 = (iHashCode33 + (number2 == null ? 0 : number2.hashCode())) * 31;
            Number number3 = this.memoryMax;
            int iHashCode35 = (iHashCode34 + (number3 == null ? 0 : number3.hashCode())) * 31;
            Number number4 = this.cpuTicksCount;
            int iHashCode36 = (iHashCode35 + (number4 == null ? 0 : number4.hashCode())) * 31;
            Number number5 = this.cpuTicksPerSecond;
            int iHashCode37 = (iHashCode36 + (number5 == null ? 0 : number5.hashCode())) * 31;
            Number number6 = this.refreshRateAverage;
            int iHashCode38 = (iHashCode37 + (number6 == null ? 0 : number6.hashCode())) * 31;
            Number number7 = this.refreshRateMin;
            int iHashCode39 = (iHashCode38 + (number7 == null ? 0 : number7.hashCode())) * 31;
            Number number8 = this.slowFramesRate;
            int iHashCode40 = (iHashCode39 + (number8 == null ? 0 : number8.hashCode())) * 31;
            Number number9 = this.freezeRate;
            int iHashCode41 = (iHashCode40 + (number9 == null ? 0 : number9.hashCode())) * 31;
            FlutterBuildTime flutterBuildTime = this.flutterBuildTime;
            int iHashCode42 = (iHashCode41 + (flutterBuildTime == null ? 0 : flutterBuildTime.hashCode())) * 31;
            FlutterBuildTime flutterBuildTime2 = this.flutterRasterTime;
            int iHashCode43 = (iHashCode42 + (flutterBuildTime2 == null ? 0 : flutterBuildTime2.hashCode())) * 31;
            FlutterBuildTime flutterBuildTime3 = this.jsRefreshRate;
            int iHashCode44 = (iHashCode43 + (flutterBuildTime3 == null ? 0 : flutterBuildTime3.hashCode())) * 31;
            Performance performance = this.performance;
            int iHashCode45 = (iHashCode44 + (performance == null ? 0 : performance.hashCode())) * 31;
            Accessibility accessibility = this.accessibility;
            return iHashCode45 + (accessibility != null ? accessibility.hashCode() : 0);
        }

        public String toString() {
            return "ViewEventView(id=" + this.id + ", referrer=" + this.referrer + ", url=" + this.url + ", name=" + this.name + ", loadingTime=" + this.loadingTime + ", networkSettledTime=" + this.networkSettledTime + ", interactionToNextViewTime=" + this.interactionToNextViewTime + ", loadingType=" + this.loadingType + ", timeSpent=" + this.timeSpent + ", firstContentfulPaint=" + this.firstContentfulPaint + ", largestContentfulPaint=" + this.largestContentfulPaint + ", largestContentfulPaintTargetSelector=" + this.largestContentfulPaintTargetSelector + ", firstInputDelay=" + this.firstInputDelay + ", firstInputTime=" + this.firstInputTime + ", firstInputTargetSelector=" + this.firstInputTargetSelector + ", interactionToNextPaint=" + this.interactionToNextPaint + ", interactionToNextPaintTime=" + this.interactionToNextPaintTime + ", interactionToNextPaintTargetSelector=" + this.interactionToNextPaintTargetSelector + ", cumulativeLayoutShift=" + this.cumulativeLayoutShift + ", cumulativeLayoutShiftTime=" + this.cumulativeLayoutShiftTime + ", cumulativeLayoutShiftTargetSelector=" + this.cumulativeLayoutShiftTargetSelector + ", domComplete=" + this.domComplete + ", domContentLoaded=" + this.domContentLoaded + ", domInteractive=" + this.domInteractive + ", loadEvent=" + this.loadEvent + ", firstByte=" + this.firstByte + ", customTimings=" + this.customTimings + ", isActive=" + this.isActive + ", isSlowRendered=" + this.isSlowRendered + ", action=" + this.action + ", error=" + this.error + ", crash=" + this.crash + ", longTask=" + this.longTask + ", frozenFrame=" + this.frozenFrame + ", slowFrames=" + this.slowFrames + ", resource=" + this.resource + ", frustration=" + this.frustration + ", inForegroundPeriods=" + this.inForegroundPeriods + ", memoryAverage=" + this.memoryAverage + ", memoryMax=" + this.memoryMax + ", cpuTicksCount=" + this.cpuTicksCount + ", cpuTicksPerSecond=" + this.cpuTicksPerSecond + ", refreshRateAverage=" + this.refreshRateAverage + ", refreshRateMin=" + this.refreshRateMin + ", slowFramesRate=" + this.slowFramesRate + ", freezeRate=" + this.freezeRate + ", flutterBuildTime=" + this.flutterBuildTime + ", flutterRasterTime=" + this.flutterRasterTime + ", jsRefreshRate=" + this.jsRefreshRate + ", performance=" + this.performance + ", accessibility=" + this.accessibility + ")";
        }

        public ViewEventView(String id, String str, String url, String str2, Long l, Long l2, Long l3, LoadingType loadingType, long j, Long l4, Long l5, String str3, Long l6, Long l7, String str4, Long l8, Long l9, String str5, Number number, Long l10, String str6, Long l11, Long l12, Long l13, Long l14, Long l15, CustomTimings customTimings, Boolean bool, Boolean bool2, Action action, Error error, Crash crash, LongTask longTask, FrozenFrame frozenFrame, List<SlowFrame> list, Resource resource, Frustration frustration, List<InForegroundPeriod> list2, Number number2, Number number3, Number number4, Number number5, Number number6, Number number7, Number number8, Number number9, FlutterBuildTime flutterBuildTime, FlutterBuildTime flutterBuildTime2, FlutterBuildTime flutterBuildTime3, Performance performance, Accessibility accessibility) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(resource, "resource");
            this.id = id;
            this.referrer = str;
            this.url = url;
            this.name = str2;
            this.loadingTime = l;
            this.networkSettledTime = l2;
            this.interactionToNextViewTime = l3;
            this.loadingType = loadingType;
            this.timeSpent = j;
            this.firstContentfulPaint = l4;
            this.largestContentfulPaint = l5;
            this.largestContentfulPaintTargetSelector = str3;
            this.firstInputDelay = l6;
            this.firstInputTime = l7;
            this.firstInputTargetSelector = str4;
            this.interactionToNextPaint = l8;
            this.interactionToNextPaintTime = l9;
            this.interactionToNextPaintTargetSelector = str5;
            this.cumulativeLayoutShift = number;
            this.cumulativeLayoutShiftTime = l10;
            this.cumulativeLayoutShiftTargetSelector = str6;
            this.domComplete = l11;
            this.domContentLoaded = l12;
            this.domInteractive = l13;
            this.loadEvent = l14;
            this.firstByte = l15;
            this.customTimings = customTimings;
            this.isActive = bool;
            this.isSlowRendered = bool2;
            this.action = action;
            this.error = error;
            this.crash = crash;
            this.longTask = longTask;
            this.frozenFrame = frozenFrame;
            this.slowFrames = list;
            this.resource = resource;
            this.frustration = frustration;
            this.inForegroundPeriods = list2;
            this.memoryAverage = number2;
            this.memoryMax = number3;
            this.cpuTicksCount = number4;
            this.cpuTicksPerSecond = number5;
            this.refreshRateAverage = number6;
            this.refreshRateMin = number7;
            this.slowFramesRate = number8;
            this.freezeRate = number9;
            this.flutterBuildTime = flutterBuildTime;
            this.flutterRasterTime = flutterBuildTime2;
            this.jsRefreshRate = flutterBuildTime3;
            this.performance = performance;
            this.accessibility = accessibility;
        }

        public /* synthetic */ ViewEventView(String str, String str2, String str3, String str4, Long l, Long l2, Long l3, LoadingType loadingType, long j, Long l4, Long l5, String str5, Long l6, Long l7, String str6, Long l8, Long l9, String str7, Number number, Long l10, String str8, Long l11, Long l12, Long l13, Long l14, Long l15, CustomTimings customTimings, Boolean bool, Boolean bool2, Action action, Error error, Crash crash, LongTask longTask, FrozenFrame frozenFrame, List list, Resource resource, Frustration frustration, List list2, Number number2, Number number3, Number number4, Number number5, Number number6, Number number7, Number number8, Number number9, FlutterBuildTime flutterBuildTime, FlutterBuildTime flutterBuildTime2, FlutterBuildTime flutterBuildTime3, Performance performance, Accessibility accessibility, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : l, (i & 32) != 0 ? null : l2, (i & 64) != 0 ? null : l3, (i & 128) != 0 ? null : loadingType, j, (i & 512) != 0 ? null : l4, (i & 1024) != 0 ? null : l5, (i & 2048) != 0 ? null : str5, (i & 4096) != 0 ? null : l6, (i & 8192) != 0 ? null : l7, (i & 16384) != 0 ? null : str6, (i & 32768) != 0 ? null : l8, (i & 65536) != 0 ? null : l9, (i & 131072) != 0 ? null : str7, (i & 262144) != 0 ? null : number, (524288 & i) != 0 ? null : l10, (1048576 & i) != 0 ? null : str8, (2097152 & i) != 0 ? null : l11, (4194304 & i) != 0 ? null : l12, (8388608 & i) != 0 ? null : l13, (16777216 & i) != 0 ? null : l14, (33554432 & i) != 0 ? null : l15, (67108864 & i) != 0 ? null : customTimings, (134217728 & i) != 0 ? null : bool, (268435456 & i) != 0 ? null : bool2, action, error, (i & Integer.MIN_VALUE) != 0 ? null : crash, (i2 & 1) != 0 ? null : longTask, (i2 & 2) != 0 ? null : frozenFrame, (i2 & 4) != 0 ? null : list, resource, (i2 & 16) != 0 ? null : frustration, (i2 & 32) != 0 ? null : list2, (i2 & 64) != 0 ? null : number2, (i2 & 128) != 0 ? null : number3, (i2 & 256) != 0 ? null : number4, (i2 & 512) != 0 ? null : number5, (i2 & 1024) != 0 ? null : number6, (i2 & 2048) != 0 ? null : number7, (i2 & 4096) != 0 ? null : number8, (i2 & 8192) != 0 ? null : number9, (i2 & 16384) != 0 ? null : flutterBuildTime, (i2 & 32768) != 0 ? null : flutterBuildTime2, (i2 & 65536) != 0 ? null : flutterBuildTime3, (i2 & 131072) != 0 ? null : performance, (i2 & 262144) != 0 ? null : accessibility);
        }

        public final String getId() {
            return this.id;
        }

        public final String getReferrer() {
            return this.referrer;
        }

        public final void setReferrer(String str) {
            this.referrer = str;
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.url = str;
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            this.name = str;
        }

        public final Long getLoadingTime() {
            return this.loadingTime;
        }

        public final Long getNetworkSettledTime() {
            return this.networkSettledTime;
        }

        public final Long getInteractionToNextViewTime() {
            return this.interactionToNextViewTime;
        }

        public final LoadingType getLoadingType() {
            return this.loadingType;
        }

        public final long getTimeSpent() {
            return this.timeSpent;
        }

        public final Long getFirstContentfulPaint() {
            return this.firstContentfulPaint;
        }

        public final Long getLargestContentfulPaint() {
            return this.largestContentfulPaint;
        }

        public final String getLargestContentfulPaintTargetSelector() {
            return this.largestContentfulPaintTargetSelector;
        }

        public final Long getFirstInputDelay() {
            return this.firstInputDelay;
        }

        public final Long getFirstInputTime() {
            return this.firstInputTime;
        }

        public final String getFirstInputTargetSelector() {
            return this.firstInputTargetSelector;
        }

        public final Long getInteractionToNextPaint() {
            return this.interactionToNextPaint;
        }

        public final Long getInteractionToNextPaintTime() {
            return this.interactionToNextPaintTime;
        }

        public final String getInteractionToNextPaintTargetSelector() {
            return this.interactionToNextPaintTargetSelector;
        }

        public final Number getCumulativeLayoutShift() {
            return this.cumulativeLayoutShift;
        }

        public final Long getCumulativeLayoutShiftTime() {
            return this.cumulativeLayoutShiftTime;
        }

        public final String getCumulativeLayoutShiftTargetSelector() {
            return this.cumulativeLayoutShiftTargetSelector;
        }

        public final Long getDomComplete() {
            return this.domComplete;
        }

        public final Long getDomContentLoaded() {
            return this.domContentLoaded;
        }

        public final Long getDomInteractive() {
            return this.domInteractive;
        }

        public final Long getLoadEvent() {
            return this.loadEvent;
        }

        public final Long getFirstByte() {
            return this.firstByte;
        }

        public final CustomTimings getCustomTimings() {
            return this.customTimings;
        }

        public final Boolean isActive() {
            return this.isActive;
        }

        public final Boolean isSlowRendered() {
            return this.isSlowRendered;
        }

        public final Action getAction() {
            return this.action;
        }

        public final Error getError() {
            return this.error;
        }

        public final Crash getCrash() {
            return this.crash;
        }

        public final LongTask getLongTask() {
            return this.longTask;
        }

        public final FrozenFrame getFrozenFrame() {
            return this.frozenFrame;
        }

        public final List<SlowFrame> getSlowFrames() {
            return this.slowFrames;
        }

        public final Resource getResource() {
            return this.resource;
        }

        public final Frustration getFrustration() {
            return this.frustration;
        }

        public final List<InForegroundPeriod> getInForegroundPeriods() {
            return this.inForegroundPeriods;
        }

        public final Number getMemoryAverage() {
            return this.memoryAverage;
        }

        public final Number getMemoryMax() {
            return this.memoryMax;
        }

        public final Number getCpuTicksCount() {
            return this.cpuTicksCount;
        }

        public final Number getCpuTicksPerSecond() {
            return this.cpuTicksPerSecond;
        }

        public final Number getRefreshRateAverage() {
            return this.refreshRateAverage;
        }

        public final Number getRefreshRateMin() {
            return this.refreshRateMin;
        }

        public final Number getSlowFramesRate() {
            return this.slowFramesRate;
        }

        public final Number getFreezeRate() {
            return this.freezeRate;
        }

        public final FlutterBuildTime getFlutterBuildTime() {
            return this.flutterBuildTime;
        }

        public final FlutterBuildTime getFlutterRasterTime() {
            return this.flutterRasterTime;
        }

        public final FlutterBuildTime getJsRefreshRate() {
            return this.jsRefreshRate;
        }

        public final Performance getPerformance() {
            return this.performance;
        }

        public final Accessibility getAccessibility() {
            return this.accessibility;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id", this.id);
            String str = this.referrer;
            if (str != null) {
                jsonObject.addProperty("referrer", str);
            }
            jsonObject.addProperty(ImagesContract.URL, this.url);
            String str2 = this.name;
            if (str2 != null) {
                jsonObject.addProperty("name", str2);
            }
            Long l = this.loadingTime;
            if (l != null) {
                jsonObject.addProperty(ViewEndedMetricDispatcher.KEY_LOADING_TIME, Long.valueOf(l.longValue()));
            }
            Long l2 = this.networkSettledTime;
            if (l2 != null) {
                jsonObject.addProperty("network_settled_time", Long.valueOf(l2.longValue()));
            }
            Long l3 = this.interactionToNextViewTime;
            if (l3 != null) {
                jsonObject.addProperty("interaction_to_next_view_time", Long.valueOf(l3.longValue()));
            }
            LoadingType loadingType = this.loadingType;
            if (loadingType != null) {
                jsonObject.add("loading_type", loadingType.toJson());
            }
            jsonObject.addProperty("time_spent", Long.valueOf(this.timeSpent));
            Long l4 = this.firstContentfulPaint;
            if (l4 != null) {
                jsonObject.addProperty("first_contentful_paint", Long.valueOf(l4.longValue()));
            }
            Long l5 = this.largestContentfulPaint;
            if (l5 != null) {
                jsonObject.addProperty("largest_contentful_paint", Long.valueOf(l5.longValue()));
            }
            String str3 = this.largestContentfulPaintTargetSelector;
            if (str3 != null) {
                jsonObject.addProperty("largest_contentful_paint_target_selector", str3);
            }
            Long l6 = this.firstInputDelay;
            if (l6 != null) {
                jsonObject.addProperty("first_input_delay", Long.valueOf(l6.longValue()));
            }
            Long l7 = this.firstInputTime;
            if (l7 != null) {
                jsonObject.addProperty("first_input_time", Long.valueOf(l7.longValue()));
            }
            String str4 = this.firstInputTargetSelector;
            if (str4 != null) {
                jsonObject.addProperty("first_input_target_selector", str4);
            }
            Long l8 = this.interactionToNextPaint;
            if (l8 != null) {
                jsonObject.addProperty("interaction_to_next_paint", Long.valueOf(l8.longValue()));
            }
            Long l9 = this.interactionToNextPaintTime;
            if (l9 != null) {
                jsonObject.addProperty("interaction_to_next_paint_time", Long.valueOf(l9.longValue()));
            }
            String str5 = this.interactionToNextPaintTargetSelector;
            if (str5 != null) {
                jsonObject.addProperty("interaction_to_next_paint_target_selector", str5);
            }
            Number number = this.cumulativeLayoutShift;
            if (number != null) {
                jsonObject.addProperty("cumulative_layout_shift", number);
            }
            Long l10 = this.cumulativeLayoutShiftTime;
            if (l10 != null) {
                jsonObject.addProperty("cumulative_layout_shift_time", Long.valueOf(l10.longValue()));
            }
            String str6 = this.cumulativeLayoutShiftTargetSelector;
            if (str6 != null) {
                jsonObject.addProperty("cumulative_layout_shift_target_selector", str6);
            }
            Long l11 = this.domComplete;
            if (l11 != null) {
                jsonObject.addProperty("dom_complete", Long.valueOf(l11.longValue()));
            }
            Long l12 = this.domContentLoaded;
            if (l12 != null) {
                jsonObject.addProperty("dom_content_loaded", Long.valueOf(l12.longValue()));
            }
            Long l13 = this.domInteractive;
            if (l13 != null) {
                jsonObject.addProperty("dom_interactive", Long.valueOf(l13.longValue()));
            }
            Long l14 = this.loadEvent;
            if (l14 != null) {
                jsonObject.addProperty("load_event", Long.valueOf(l14.longValue()));
            }
            Long l15 = this.firstByte;
            if (l15 != null) {
                jsonObject.addProperty("first_byte", Long.valueOf(l15.longValue()));
            }
            CustomTimings customTimings = this.customTimings;
            if (customTimings != null) {
                jsonObject.add("custom_timings", customTimings.toJson());
            }
            Boolean bool = this.isActive;
            if (bool != null) {
                bool.booleanValue();
                jsonObject.addProperty("is_active", bool);
            }
            Boolean bool2 = this.isSlowRendered;
            if (bool2 != null) {
                bool2.booleanValue();
                jsonObject.addProperty("is_slow_rendered", bool2);
            }
            jsonObject.add("action", this.action.toJson());
            jsonObject.add("error", this.error.toJson());
            Crash crash = this.crash;
            if (crash != null) {
                jsonObject.add("crash", crash.toJson());
            }
            LongTask longTask = this.longTask;
            if (longTask != null) {
                jsonObject.add("long_task", longTask.toJson());
            }
            FrozenFrame frozenFrame = this.frozenFrame;
            if (frozenFrame != null) {
                jsonObject.add("frozen_frame", frozenFrame.toJson());
            }
            List<SlowFrame> list = this.slowFrames;
            if (list != null) {
                JsonArray jsonArray = new JsonArray(list.size());
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    jsonArray.add(((SlowFrame) it.next()).toJson());
                }
                jsonObject.add(DefaultUISlownessMetricDispatcher.KEY_SLOW_FRAMES, jsonArray);
            }
            jsonObject.add("resource", this.resource.toJson());
            Frustration frustration = this.frustration;
            if (frustration != null) {
                jsonObject.add("frustration", frustration.toJson());
            }
            List<InForegroundPeriod> list2 = this.inForegroundPeriods;
            if (list2 != null) {
                JsonArray jsonArray2 = new JsonArray(list2.size());
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    jsonArray2.add(((InForegroundPeriod) it2.next()).toJson());
                }
                jsonObject.add("in_foreground_periods", jsonArray2);
            }
            Number number2 = this.memoryAverage;
            if (number2 != null) {
                jsonObject.addProperty("memory_average", number2);
            }
            Number number3 = this.memoryMax;
            if (number3 != null) {
                jsonObject.addProperty("memory_max", number3);
            }
            Number number4 = this.cpuTicksCount;
            if (number4 != null) {
                jsonObject.addProperty("cpu_ticks_count", number4);
            }
            Number number5 = this.cpuTicksPerSecond;
            if (number5 != null) {
                jsonObject.addProperty("cpu_ticks_per_second", number5);
            }
            Number number6 = this.refreshRateAverage;
            if (number6 != null) {
                jsonObject.addProperty("refresh_rate_average", number6);
            }
            Number number7 = this.refreshRateMin;
            if (number7 != null) {
                jsonObject.addProperty("refresh_rate_min", number7);
            }
            Number number8 = this.slowFramesRate;
            if (number8 != null) {
                jsonObject.addProperty("slow_frames_rate", number8);
            }
            Number number9 = this.freezeRate;
            if (number9 != null) {
                jsonObject.addProperty("freeze_rate", number9);
            }
            FlutterBuildTime flutterBuildTime = this.flutterBuildTime;
            if (flutterBuildTime != null) {
                jsonObject.add("flutter_build_time", flutterBuildTime.toJson());
            }
            FlutterBuildTime flutterBuildTime2 = this.flutterRasterTime;
            if (flutterBuildTime2 != null) {
                jsonObject.add("flutter_raster_time", flutterBuildTime2.toJson());
            }
            FlutterBuildTime flutterBuildTime3 = this.jsRefreshRate;
            if (flutterBuildTime3 != null) {
                jsonObject.add("js_refresh_rate", flutterBuildTime3.toJson());
            }
            Performance performance = this.performance;
            if (performance != null) {
                jsonObject.add("performance", performance.toJson());
            }
            Accessibility accessibility = this.accessibility;
            if (accessibility != null) {
                jsonObject.add("accessibility", accessibility.toJson());
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$ViewEventView$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$ViewEventView;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final ViewEventView fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type ViewEventView", e);
                }
            }

            @JvmStatic
            public final ViewEventView fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                String str;
                ArrayList arrayList;
                ArrayList arrayList2;
                JsonObject asJsonObject;
                JsonObject asJsonObject2;
                JsonObject asJsonObject3;
                JsonObject asJsonObject4;
                JsonObject asJsonObject5;
                JsonArray asJsonArray;
                JsonObject asJsonObject6;
                JsonArray asJsonArray2;
                JsonObject asJsonObject7;
                JsonObject asJsonObject8;
                JsonObject asJsonObject9;
                JsonObject asJsonObject10;
                String asString;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String id = jsonObject.get("id").getAsString();
                    JsonElement jsonElement = jsonObject.get("referrer");
                    String asString2 = jsonElement != null ? jsonElement.getAsString() : null;
                    String url = jsonObject.get(ImagesContract.URL).getAsString();
                    JsonElement jsonElement2 = jsonObject.get("name");
                    String asString3 = jsonElement2 != null ? jsonElement2.getAsString() : null;
                    JsonElement jsonElement3 = jsonObject.get(ViewEndedMetricDispatcher.KEY_LOADING_TIME);
                    Long lValueOf = jsonElement3 != null ? Long.valueOf(jsonElement3.getAsLong()) : null;
                    JsonElement jsonElement4 = jsonObject.get("network_settled_time");
                    Long lValueOf2 = jsonElement4 != null ? Long.valueOf(jsonElement4.getAsLong()) : null;
                    JsonElement jsonElement5 = jsonObject.get("interaction_to_next_view_time");
                    Long lValueOf3 = jsonElement5 != null ? Long.valueOf(jsonElement5.getAsLong()) : null;
                    JsonElement jsonElement6 = jsonObject.get("loading_type");
                    LoadingType loadingTypeFromJson = (jsonElement6 == null || (asString = jsonElement6.getAsString()) == null) ? null : LoadingType.INSTANCE.fromJson(asString);
                    long asLong = jsonObject.get("time_spent").getAsLong();
                    JsonElement jsonElement7 = jsonObject.get("first_contentful_paint");
                    Long lValueOf4 = jsonElement7 != null ? Long.valueOf(jsonElement7.getAsLong()) : null;
                    JsonElement jsonElement8 = jsonObject.get("largest_contentful_paint");
                    Long lValueOf5 = jsonElement8 != null ? Long.valueOf(jsonElement8.getAsLong()) : null;
                    JsonElement jsonElement9 = jsonObject.get("largest_contentful_paint_target_selector");
                    String asString4 = jsonElement9 != null ? jsonElement9.getAsString() : null;
                    JsonElement jsonElement10 = jsonObject.get("first_input_delay");
                    Long lValueOf6 = jsonElement10 != null ? Long.valueOf(jsonElement10.getAsLong()) : null;
                    JsonElement jsonElement11 = jsonObject.get("first_input_time");
                    Long lValueOf7 = jsonElement11 != null ? Long.valueOf(jsonElement11.getAsLong()) : null;
                    JsonElement jsonElement12 = jsonObject.get("first_input_target_selector");
                    String asString5 = jsonElement12 != null ? jsonElement12.getAsString() : null;
                    JsonElement jsonElement13 = jsonObject.get("interaction_to_next_paint");
                    Long lValueOf8 = jsonElement13 != null ? Long.valueOf(jsonElement13.getAsLong()) : null;
                    JsonElement jsonElement14 = jsonObject.get("interaction_to_next_paint_time");
                    Long lValueOf9 = jsonElement14 != null ? Long.valueOf(jsonElement14.getAsLong()) : null;
                    JsonElement jsonElement15 = jsonObject.get("interaction_to_next_paint_target_selector");
                    String asString6 = jsonElement15 != null ? jsonElement15.getAsString() : null;
                    JsonElement jsonElement16 = jsonObject.get("cumulative_layout_shift");
                    Number asNumber = jsonElement16 != null ? jsonElement16.getAsNumber() : null;
                    JsonElement jsonElement17 = jsonObject.get("cumulative_layout_shift_time");
                    Long lValueOf10 = jsonElement17 != null ? Long.valueOf(jsonElement17.getAsLong()) : null;
                    JsonElement jsonElement18 = jsonObject.get("cumulative_layout_shift_target_selector");
                    String asString7 = jsonElement18 != null ? jsonElement18.getAsString() : null;
                    JsonElement jsonElement19 = jsonObject.get("dom_complete");
                    Long lValueOf11 = jsonElement19 != null ? Long.valueOf(jsonElement19.getAsLong()) : null;
                    JsonElement jsonElement20 = jsonObject.get("dom_content_loaded");
                    Long lValueOf12 = jsonElement20 != null ? Long.valueOf(jsonElement20.getAsLong()) : null;
                    JsonElement jsonElement21 = jsonObject.get("dom_interactive");
                    Long lValueOf13 = jsonElement21 != null ? Long.valueOf(jsonElement21.getAsLong()) : null;
                    JsonElement jsonElement22 = jsonObject.get("load_event");
                    Long lValueOf14 = jsonElement22 != null ? Long.valueOf(jsonElement22.getAsLong()) : null;
                    JsonElement jsonElement23 = jsonObject.get("first_byte");
                    Long lValueOf15 = jsonElement23 != null ? Long.valueOf(jsonElement23.getAsLong()) : null;
                    JsonElement jsonElement24 = jsonObject.get("custom_timings");
                    CustomTimings customTimingsFromJsonObject = (jsonElement24 == null || (asJsonObject10 = jsonElement24.getAsJsonObject()) == null) ? null : CustomTimings.INSTANCE.fromJsonObject(asJsonObject10);
                    JsonElement jsonElement25 = jsonObject.get("is_active");
                    Boolean boolValueOf = jsonElement25 != null ? Boolean.valueOf(jsonElement25.getAsBoolean()) : null;
                    JsonElement jsonElement26 = jsonObject.get("is_slow_rendered");
                    Boolean boolValueOf2 = jsonElement26 != null ? Boolean.valueOf(jsonElement26.getAsBoolean()) : null;
                    JsonObject it = jsonObject.get("action").getAsJsonObject();
                    Action.Companion companion = Action.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    Action actionFromJsonObject = companion.fromJsonObject(it);
                    JsonObject it2 = jsonObject.get("error").getAsJsonObject();
                    Error.Companion companion2 = Error.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(it2, "it");
                    Error errorFromJsonObject = companion2.fromJsonObject(it2);
                    JsonElement jsonElement27 = jsonObject.get("crash");
                    Crash crashFromJsonObject = (jsonElement27 == null || (asJsonObject9 = jsonElement27.getAsJsonObject()) == null) ? null : Crash.INSTANCE.fromJsonObject(asJsonObject9);
                    JsonElement jsonElement28 = jsonObject.get("long_task");
                    LongTask longTaskFromJsonObject = (jsonElement28 == null || (asJsonObject8 = jsonElement28.getAsJsonObject()) == null) ? null : LongTask.INSTANCE.fromJsonObject(asJsonObject8);
                    JsonElement jsonElement29 = jsonObject.get("frozen_frame");
                    FrozenFrame frozenFrameFromJsonObject = (jsonElement29 == null || (asJsonObject7 = jsonElement29.getAsJsonObject()) == null) ? null : FrozenFrame.INSTANCE.fromJsonObject(asJsonObject7);
                    JsonElement jsonElement30 = jsonObject.get(DefaultUISlownessMetricDispatcher.KEY_SLOW_FRAMES);
                    if (jsonElement30 == null || (asJsonArray2 = jsonElement30.getAsJsonArray()) == null) {
                        str = asString3;
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(asJsonArray2.size());
                        Iterator<JsonElement> it3 = asJsonArray2.iterator();
                        while (it3.hasNext()) {
                            JsonElement next = it3.next();
                            Iterator<JsonElement> it4 = it3;
                            SlowFrame.Companion companion3 = SlowFrame.INSTANCE;
                            String str2 = asString3;
                            JsonObject asJsonObject11 = next.getAsJsonObject();
                            Intrinsics.checkNotNullExpressionValue(asJsonObject11, "it.asJsonObject");
                            arrayList.add(companion3.fromJsonObject(asJsonObject11));
                            it3 = it4;
                            asString3 = str2;
                        }
                        str = asString3;
                    }
                    JsonObject it5 = jsonObject.get("resource").getAsJsonObject();
                    Resource.Companion companion4 = Resource.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(it5, "it");
                    Resource resourceFromJsonObject = companion4.fromJsonObject(it5);
                    JsonElement jsonElement31 = jsonObject.get("frustration");
                    Frustration frustrationFromJsonObject = (jsonElement31 == null || (asJsonObject6 = jsonElement31.getAsJsonObject()) == null) ? null : Frustration.INSTANCE.fromJsonObject(asJsonObject6);
                    JsonElement jsonElement32 = jsonObject.get("in_foreground_periods");
                    if (jsonElement32 == null || (asJsonArray = jsonElement32.getAsJsonArray()) == null) {
                        arrayList2 = null;
                    } else {
                        arrayList2 = new ArrayList(asJsonArray.size());
                        Iterator<JsonElement> it6 = asJsonArray.iterator();
                        while (it6.hasNext()) {
                            JsonElement next2 = it6.next();
                            Iterator<JsonElement> it7 = it6;
                            InForegroundPeriod.Companion companion5 = InForegroundPeriod.INSTANCE;
                            JsonObject asJsonObject12 = next2.getAsJsonObject();
                            Intrinsics.checkNotNullExpressionValue(asJsonObject12, "it.asJsonObject");
                            arrayList2.add(companion5.fromJsonObject(asJsonObject12));
                            it6 = it7;
                        }
                    }
                    JsonElement jsonElement33 = jsonObject.get("memory_average");
                    Number asNumber2 = jsonElement33 != null ? jsonElement33.getAsNumber() : null;
                    JsonElement jsonElement34 = jsonObject.get("memory_max");
                    Number asNumber3 = jsonElement34 != null ? jsonElement34.getAsNumber() : null;
                    JsonElement jsonElement35 = jsonObject.get("cpu_ticks_count");
                    Number asNumber4 = jsonElement35 != null ? jsonElement35.getAsNumber() : null;
                    JsonElement jsonElement36 = jsonObject.get("cpu_ticks_per_second");
                    Number asNumber5 = jsonElement36 != null ? jsonElement36.getAsNumber() : null;
                    JsonElement jsonElement37 = jsonObject.get("refresh_rate_average");
                    Number asNumber6 = jsonElement37 != null ? jsonElement37.getAsNumber() : null;
                    JsonElement jsonElement38 = jsonObject.get("refresh_rate_min");
                    Number asNumber7 = jsonElement38 != null ? jsonElement38.getAsNumber() : null;
                    JsonElement jsonElement39 = jsonObject.get("slow_frames_rate");
                    Number asNumber8 = jsonElement39 != null ? jsonElement39.getAsNumber() : null;
                    JsonElement jsonElement40 = jsonObject.get("freeze_rate");
                    Number asNumber9 = jsonElement40 != null ? jsonElement40.getAsNumber() : null;
                    JsonElement jsonElement41 = jsonObject.get("flutter_build_time");
                    FlutterBuildTime flutterBuildTimeFromJsonObject = (jsonElement41 == null || (asJsonObject5 = jsonElement41.getAsJsonObject()) == null) ? null : FlutterBuildTime.INSTANCE.fromJsonObject(asJsonObject5);
                    JsonElement jsonElement42 = jsonObject.get("flutter_raster_time");
                    FlutterBuildTime flutterBuildTimeFromJsonObject2 = (jsonElement42 == null || (asJsonObject4 = jsonElement42.getAsJsonObject()) == null) ? null : FlutterBuildTime.INSTANCE.fromJsonObject(asJsonObject4);
                    JsonElement jsonElement43 = jsonObject.get("js_refresh_rate");
                    FlutterBuildTime flutterBuildTimeFromJsonObject3 = (jsonElement43 == null || (asJsonObject3 = jsonElement43.getAsJsonObject()) == null) ? null : FlutterBuildTime.INSTANCE.fromJsonObject(asJsonObject3);
                    JsonElement jsonElement44 = jsonObject.get("performance");
                    Performance performanceFromJsonObject = (jsonElement44 == null || (asJsonObject2 = jsonElement44.getAsJsonObject()) == null) ? null : Performance.INSTANCE.fromJsonObject(asJsonObject2);
                    JsonElement jsonElement45 = jsonObject.get("accessibility");
                    Accessibility accessibilityFromJsonObject = (jsonElement45 == null || (asJsonObject = jsonElement45.getAsJsonObject()) == null) ? null : Accessibility.INSTANCE.fromJsonObject(asJsonObject);
                    Intrinsics.checkNotNullExpressionValue(id, "id");
                    Intrinsics.checkNotNullExpressionValue(url, "url");
                    return new ViewEventView(id, asString2, url, str, lValueOf, lValueOf2, lValueOf3, loadingTypeFromJson, asLong, lValueOf4, lValueOf5, asString4, lValueOf6, lValueOf7, asString5, lValueOf8, lValueOf9, asString6, asNumber, lValueOf10, asString7, lValueOf11, lValueOf12, lValueOf13, lValueOf14, lValueOf15, customTimingsFromJsonObject, boolValueOf, boolValueOf2, actionFromJsonObject, errorFromJsonObject, crashFromJsonObject, longTaskFromJsonObject, frozenFrameFromJsonObject, arrayList, resourceFromJsonObject, frustrationFromJsonObject, arrayList2, asNumber2, asNumber3, asNumber4, asNumber5, asNumber6, asNumber7, asNumber8, asNumber9, flutterBuildTimeFromJsonObject, flutterBuildTimeFromJsonObject2, flutterBuildTimeFromJsonObject3, performanceFromJsonObject, accessibilityFromJsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type ViewEventView", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type ViewEventView", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type ViewEventView", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fBM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bHÆ\u0003JQ\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0006\u0010\u001c\u001a\u00020\u001dJ\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006 "}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Usr;", "", "id", "", "name", "email", "anonymousId", "additionalProperties", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getAdditionalProperties", "()Ljava/util/Map;", "getAnonymousId", "()Ljava/lang/String;", "getEmail", "getId", "getName", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Usr {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final String[] RESERVED_PROPERTIES = {"id", "name", "email", "anonymous_id"};
        private final Map<String, Object> additionalProperties;
        private final String anonymousId;
        private final String email;
        private final String id;
        private final String name;

        public Usr() {
            this(null, null, null, null, null, 31, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Usr copy$default(Usr usr, String str, String str2, String str3, String str4, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = usr.id;
            }
            if ((i & 2) != 0) {
                str2 = usr.name;
            }
            if ((i & 4) != 0) {
                str3 = usr.email;
            }
            if ((i & 8) != 0) {
                str4 = usr.anonymousId;
            }
            if ((i & 16) != 0) {
                map = usr.additionalProperties;
            }
            Map map2 = map;
            String str5 = str3;
            return usr.copy(str, str2, str5, str4, map2);
        }

        @JvmStatic
        public static final Usr fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Usr fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getEmail() {
            return this.email;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getAnonymousId() {
            return this.anonymousId;
        }

        public final Map<String, Object> component5() {
            return this.additionalProperties;
        }

        public final Usr copy(String id, String name, String email, String anonymousId, Map<String, Object> additionalProperties) {
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            return new Usr(id, name, email, anonymousId, additionalProperties);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Usr)) {
                return false;
            }
            Usr usr = (Usr) other;
            return Intrinsics.areEqual(this.id, usr.id) && Intrinsics.areEqual(this.name, usr.name) && Intrinsics.areEqual(this.email, usr.email) && Intrinsics.areEqual(this.anonymousId, usr.anonymousId) && Intrinsics.areEqual(this.additionalProperties, usr.additionalProperties);
        }

        public int hashCode() {
            String str = this.id;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.name;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.email;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.anonymousId;
            return ((iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.additionalProperties.hashCode();
        }

        public String toString() {
            return "Usr(id=" + this.id + ", name=" + this.name + ", email=" + this.email + ", anonymousId=" + this.anonymousId + ", additionalProperties=" + this.additionalProperties + ")";
        }

        public Usr(String str, String str2, String str3, String str4, Map<String, Object> additionalProperties) {
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            this.id = str;
            this.name = str2;
            this.email = str3;
            this.anonymousId = str4;
            this.additionalProperties = additionalProperties;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public final String getEmail() {
            return this.email;
        }

        public final String getAnonymousId() {
            return this.anonymousId;
        }

        public /* synthetic */ Usr(String str, String str2, String str3, String str4, LinkedHashMap linkedHashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? new LinkedHashMap() : linkedHashMap);
        }

        public final Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            String str = this.id;
            if (str != null) {
                jsonObject.addProperty("id", str);
            }
            String str2 = this.name;
            if (str2 != null) {
                jsonObject.addProperty("name", str2);
            }
            String str3 = this.email;
            if (str3 != null) {
                jsonObject.addProperty("email", str3);
            }
            String str4 = this.anonymousId;
            if (str4 != null) {
                jsonObject.addProperty("anonymous_id", str4);
            }
            for (Map.Entry<String, Object> entry : this.additionalProperties.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (!ArraysKt.contains(RESERVED_PROPERTIES, key)) {
                    jsonObject.add(key, JsonSerializer.INSTANCE.toJsonElement(value));
                }
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0007J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Usr$Companion;", "", "()V", "RESERVED_PROPERTIES", "", "", "getRESERVED_PROPERTIES$dd_sdk_android_rum_release", "()[Ljava/lang/String;", "[Ljava/lang/String;", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$Usr;", "jsonString", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final String[] getRESERVED_PROPERTIES$dd_sdk_android_rum_release() {
                return Usr.RESERVED_PROPERTIES;
            }

            @JvmStatic
            public final Usr fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Usr", e);
                }
            }

            @JvmStatic
            public final Usr fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get("id");
                    String asString = jsonElement != null ? jsonElement.getAsString() : null;
                    JsonElement jsonElement2 = jsonObject.get("name");
                    String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
                    JsonElement jsonElement3 = jsonObject.get("email");
                    String asString3 = jsonElement3 != null ? jsonElement3.getAsString() : null;
                    JsonElement jsonElement4 = jsonObject.get("anonymous_id");
                    String asString4 = jsonElement4 != null ? jsonElement4.getAsString() : null;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                        if (!ArraysKt.contains(getRESERVED_PROPERTIES$dd_sdk_android_rum_release(), entry.getKey())) {
                            String key = entry.getKey();
                            Intrinsics.checkNotNullExpressionValue(key, "entry.key");
                            linkedHashMap.put(key, entry.getValue());
                        }
                    }
                    return new Usr(asString, asString2, asString3, asString4, linkedHashMap);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Usr", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Usr", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Usr", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006HÆ\u0003J7\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0006\u0010\u0016\u001a\u00020\u0017J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Account;", "", "id", "", "name", "additionalProperties", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getAdditionalProperties", "()Ljava/util/Map;", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Account {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final String[] RESERVED_PROPERTIES = {"id", "name"};
        private final Map<String, Object> additionalProperties;
        private final String id;
        private final String name;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Account copy$default(Account account, String str, String str2, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = account.id;
            }
            if ((i & 2) != 0) {
                str2 = account.name;
            }
            if ((i & 4) != 0) {
                map = account.additionalProperties;
            }
            return account.copy(str, str2, map);
        }

        @JvmStatic
        public static final Account fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Account fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final Map<String, Object> component3() {
            return this.additionalProperties;
        }

        public final Account copy(String id, String name, Map<String, Object> additionalProperties) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            return new Account(id, name, additionalProperties);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Account)) {
                return false;
            }
            Account account = (Account) other;
            return Intrinsics.areEqual(this.id, account.id) && Intrinsics.areEqual(this.name, account.name) && Intrinsics.areEqual(this.additionalProperties, account.additionalProperties);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.name;
            return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.additionalProperties.hashCode();
        }

        public String toString() {
            return "Account(id=" + this.id + ", name=" + this.name + ", additionalProperties=" + this.additionalProperties + ")";
        }

        public Account(String id, String str, Map<String, Object> additionalProperties) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            this.id = id;
            this.name = str;
            this.additionalProperties = additionalProperties;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public /* synthetic */ Account(String str, String str2, LinkedHashMap linkedHashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? new LinkedHashMap() : linkedHashMap);
        }

        public final Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id", this.id);
            String str = this.name;
            if (str != null) {
                jsonObject.addProperty("name", str);
            }
            for (Map.Entry<String, Object> entry : this.additionalProperties.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (!ArraysKt.contains(RESERVED_PROPERTIES, key)) {
                    jsonObject.add(key, JsonSerializer.INSTANCE.toJsonElement(value));
                }
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0007J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Account$Companion;", "", "()V", "RESERVED_PROPERTIES", "", "", "getRESERVED_PROPERTIES$dd_sdk_android_rum_release", "()[Ljava/lang/String;", "[Ljava/lang/String;", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$Account;", "jsonString", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final String[] getRESERVED_PROPERTIES$dd_sdk_android_rum_release() {
                return Account.RESERVED_PROPERTIES;
            }

            @JvmStatic
            public final Account fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Account", e);
                }
            }

            @JvmStatic
            public final Account fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String id = jsonObject.get("id").getAsString();
                    JsonElement jsonElement = jsonObject.get("name");
                    String asString = jsonElement != null ? jsonElement.getAsString() : null;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                        if (!ArraysKt.contains(getRESERVED_PROPERTIES$dd_sdk_android_rum_release(), entry.getKey())) {
                            String key = entry.getKey();
                            Intrinsics.checkNotNullExpressionValue(key, "entry.key");
                            linkedHashMap.put(key, entry.getValue());
                        }
                    }
                    Intrinsics.checkNotNullExpressionValue(id, "id");
                    return new Account(id, asString, linkedHashMap);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Account", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Account", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Account", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Tab;", "", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Tab {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String id;

        public static /* synthetic */ Tab copy$default(Tab tab, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = tab.id;
            }
            return tab.copy(str);
        }

        @JvmStatic
        public static final Tab fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Tab fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        public final Tab copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Tab(id);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Tab) && Intrinsics.areEqual(this.id, ((Tab) other).id);
        }

        public int hashCode() {
            return this.id.hashCode();
        }

        public String toString() {
            return "Tab(id=" + this.id + ")";
        }

        public Tab(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public final String getId() {
            return this.id;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id", this.id);
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Tab$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$Tab;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Tab fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Tab", e);
                }
            }

            @JvmStatic
            public final Tab fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String id = jsonObject.get("id").getAsString();
                    Intrinsics.checkNotNullExpressionValue(id, "id");
                    return new Tab(id);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Tab", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Tab", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Tab", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\nHÆ\u0003J=\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0006\u0010\u001e\u001a\u00020\u001fJ\t\u0010 \u001a\u00020!HÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006#"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Connectivity;", "", "status", "Lcom/datadog/android/rum/model/ViewEvent$ConnectivityStatus;", "interfaces", "", "Lcom/datadog/android/rum/model/ViewEvent$Interface;", "effectiveType", "Lcom/datadog/android/rum/model/ViewEvent$EffectiveType;", "cellular", "Lcom/datadog/android/rum/model/ViewEvent$Cellular;", "(Lcom/datadog/android/rum/model/ViewEvent$ConnectivityStatus;Ljava/util/List;Lcom/datadog/android/rum/model/ViewEvent$EffectiveType;Lcom/datadog/android/rum/model/ViewEvent$Cellular;)V", "getCellular", "()Lcom/datadog/android/rum/model/ViewEvent$Cellular;", "getEffectiveType", "()Lcom/datadog/android/rum/model/ViewEvent$EffectiveType;", "getInterfaces", "()Ljava/util/List;", "getStatus", "()Lcom/datadog/android/rum/model/ViewEvent$ConnectivityStatus;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Connectivity {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Cellular cellular;
        private final EffectiveType effectiveType;
        private final List<Interface> interfaces;
        private final ConnectivityStatus status;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Connectivity copy$default(Connectivity connectivity, ConnectivityStatus connectivityStatus, List list, EffectiveType effectiveType, Cellular cellular, int i, Object obj) {
            if ((i & 1) != 0) {
                connectivityStatus = connectivity.status;
            }
            if ((i & 2) != 0) {
                list = connectivity.interfaces;
            }
            if ((i & 4) != 0) {
                effectiveType = connectivity.effectiveType;
            }
            if ((i & 8) != 0) {
                cellular = connectivity.cellular;
            }
            return connectivity.copy(connectivityStatus, list, effectiveType, cellular);
        }

        @JvmStatic
        public static final Connectivity fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Connectivity fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ConnectivityStatus getStatus() {
            return this.status;
        }

        public final List<Interface> component2() {
            return this.interfaces;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final EffectiveType getEffectiveType() {
            return this.effectiveType;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Cellular getCellular() {
            return this.cellular;
        }

        public final Connectivity copy(ConnectivityStatus status, List<? extends Interface> interfaces, EffectiveType effectiveType, Cellular cellular) {
            Intrinsics.checkNotNullParameter(status, "status");
            return new Connectivity(status, interfaces, effectiveType, cellular);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Connectivity)) {
                return false;
            }
            Connectivity connectivity = (Connectivity) other;
            return this.status == connectivity.status && Intrinsics.areEqual(this.interfaces, connectivity.interfaces) && this.effectiveType == connectivity.effectiveType && Intrinsics.areEqual(this.cellular, connectivity.cellular);
        }

        public int hashCode() {
            int iHashCode = this.status.hashCode() * 31;
            List<Interface> list = this.interfaces;
            int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
            EffectiveType effectiveType = this.effectiveType;
            int iHashCode3 = (iHashCode2 + (effectiveType == null ? 0 : effectiveType.hashCode())) * 31;
            Cellular cellular = this.cellular;
            return iHashCode3 + (cellular != null ? cellular.hashCode() : 0);
        }

        public String toString() {
            return "Connectivity(status=" + this.status + ", interfaces=" + this.interfaces + ", effectiveType=" + this.effectiveType + ", cellular=" + this.cellular + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Connectivity(ConnectivityStatus status, List<? extends Interface> list, EffectiveType effectiveType, Cellular cellular) {
            Intrinsics.checkNotNullParameter(status, "status");
            this.status = status;
            this.interfaces = list;
            this.effectiveType = effectiveType;
            this.cellular = cellular;
        }

        public /* synthetic */ Connectivity(ConnectivityStatus connectivityStatus, List list, EffectiveType effectiveType, Cellular cellular, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(connectivityStatus, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : effectiveType, (i & 8) != 0 ? null : cellular);
        }

        public final ConnectivityStatus getStatus() {
            return this.status;
        }

        public final List<Interface> getInterfaces() {
            return this.interfaces;
        }

        public final EffectiveType getEffectiveType() {
            return this.effectiveType;
        }

        public final Cellular getCellular() {
            return this.cellular;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("status", this.status.toJson());
            List<Interface> list = this.interfaces;
            if (list != null) {
                JsonArray jsonArray = new JsonArray(list.size());
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    jsonArray.add(((Interface) it.next()).toJson());
                }
                jsonObject.add("interfaces", jsonArray);
            }
            EffectiveType effectiveType = this.effectiveType;
            if (effectiveType != null) {
                jsonObject.add("effective_type", effectiveType.toJson());
            }
            Cellular cellular = this.cellular;
            if (cellular != null) {
                jsonObject.add("cellular", cellular.toJson());
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Connectivity$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$Connectivity;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Connectivity fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Connectivity", e);
                }
            }

            @JvmStatic
            public final Connectivity fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                ArrayList arrayList;
                JsonObject asJsonObject;
                String asString;
                JsonArray asJsonArray;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    ConnectivityStatus.Companion companion = ConnectivityStatus.INSTANCE;
                    String asString2 = jsonObject.get("status").getAsString();
                    Intrinsics.checkNotNullExpressionValue(asString2, "jsonObject.get(\"status\").asString");
                    ConnectivityStatus connectivityStatusFromJson = companion.fromJson(asString2);
                    JsonElement jsonElement = jsonObject.get("interfaces");
                    Cellular cellularFromJsonObject = null;
                    if (jsonElement == null || (asJsonArray = jsonElement.getAsJsonArray()) == null) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(asJsonArray.size());
                        for (JsonElement jsonElement2 : asJsonArray) {
                            Interface.Companion companion2 = Interface.INSTANCE;
                            String asString3 = jsonElement2.getAsString();
                            Intrinsics.checkNotNullExpressionValue(asString3, "it.asString");
                            arrayList.add(companion2.fromJson(asString3));
                        }
                    }
                    JsonElement jsonElement3 = jsonObject.get("effective_type");
                    EffectiveType effectiveTypeFromJson = (jsonElement3 == null || (asString = jsonElement3.getAsString()) == null) ? null : EffectiveType.INSTANCE.fromJson(asString);
                    JsonElement jsonElement4 = jsonObject.get("cellular");
                    if (jsonElement4 != null && (asJsonObject = jsonElement4.getAsJsonObject()) != null) {
                        cellularFromJsonObject = Cellular.INSTANCE.fromJsonObject(asJsonObject);
                    }
                    return new Connectivity(connectivityStatusFromJson, arrayList, effectiveTypeFromJson, cellularFromJsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Connectivity", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Connectivity", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Connectivity", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Display;", "", "viewport", "Lcom/datadog/android/rum/model/ViewEvent$Viewport;", ViewProps.SCROLL, "Lcom/datadog/android/rum/model/ViewEvent$Scroll;", "(Lcom/datadog/android/rum/model/ViewEvent$Viewport;Lcom/datadog/android/rum/model/ViewEvent$Scroll;)V", "getScroll", "()Lcom/datadog/android/rum/model/ViewEvent$Scroll;", "getViewport", "()Lcom/datadog/android/rum/model/ViewEvent$Viewport;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Display {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Scroll scroll;
        private final Viewport viewport;

        /* JADX WARN: Multi-variable type inference failed */
        public Display() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Display copy$default(Display display, Viewport viewport, Scroll scroll, int i, Object obj) {
            if ((i & 1) != 0) {
                viewport = display.viewport;
            }
            if ((i & 2) != 0) {
                scroll = display.scroll;
            }
            return display.copy(viewport, scroll);
        }

        @JvmStatic
        public static final Display fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Display fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Viewport getViewport() {
            return this.viewport;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Scroll getScroll() {
            return this.scroll;
        }

        public final Display copy(Viewport viewport, Scroll scroll) {
            return new Display(viewport, scroll);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Display)) {
                return false;
            }
            Display display = (Display) other;
            return Intrinsics.areEqual(this.viewport, display.viewport) && Intrinsics.areEqual(this.scroll, display.scroll);
        }

        public int hashCode() {
            Viewport viewport = this.viewport;
            int iHashCode = (viewport == null ? 0 : viewport.hashCode()) * 31;
            Scroll scroll = this.scroll;
            return iHashCode + (scroll != null ? scroll.hashCode() : 0);
        }

        public String toString() {
            return "Display(viewport=" + this.viewport + ", scroll=" + this.scroll + ")";
        }

        public Display(Viewport viewport, Scroll scroll) {
            this.viewport = viewport;
            this.scroll = scroll;
        }

        public /* synthetic */ Display(Viewport viewport, Scroll scroll, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : viewport, (i & 2) != 0 ? null : scroll);
        }

        public final Viewport getViewport() {
            return this.viewport;
        }

        public final Scroll getScroll() {
            return this.scroll;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            Viewport viewport = this.viewport;
            if (viewport != null) {
                jsonObject.add("viewport", viewport.toJson());
            }
            Scroll scroll = this.scroll;
            if (scroll != null) {
                jsonObject.add(ViewProps.SCROLL, scroll.toJson());
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Display$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$Display;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Display fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Display", e);
                }
            }

            @JvmStatic
            public final Display fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                JsonObject asJsonObject;
                JsonObject asJsonObject2;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get("viewport");
                    Scroll scrollFromJsonObject = null;
                    Viewport viewportFromJsonObject = (jsonElement == null || (asJsonObject2 = jsonElement.getAsJsonObject()) == null) ? null : Viewport.INSTANCE.fromJsonObject(asJsonObject2);
                    JsonElement jsonElement2 = jsonObject.get(ViewProps.SCROLL);
                    if (jsonElement2 != null && (asJsonObject = jsonElement2.getAsJsonObject()) != null) {
                        scrollFromJsonObject = Scroll.INSTANCE.fromJsonObject(asJsonObject);
                    }
                    return new Display(viewportFromJsonObject, scrollFromJsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Display", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Display", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Display", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\u0017\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bHÆ\u0003JF\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0006\u0010\u001c\u001a\u00020\u001dJ\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006 "}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Synthetics;", "", "testId", "", "resultId", "injected", "", "additionalProperties", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Map;)V", "getAdditionalProperties", "()Ljava/util/Map;", "getInjected", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getResultId", "()Ljava/lang/String;", "getTestId", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Map;)Lcom/datadog/android/rum/model/ViewEvent$Synthetics;", "equals", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Synthetics {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final String[] RESERVED_PROPERTIES = {"test_id", "result_id", "injected"};
        private final Map<String, Object> additionalProperties;
        private final Boolean injected;
        private final String resultId;
        private final String testId;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Synthetics copy$default(Synthetics synthetics, String str, String str2, Boolean bool, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = synthetics.testId;
            }
            if ((i & 2) != 0) {
                str2 = synthetics.resultId;
            }
            if ((i & 4) != 0) {
                bool = synthetics.injected;
            }
            if ((i & 8) != 0) {
                map = synthetics.additionalProperties;
            }
            return synthetics.copy(str, str2, bool, map);
        }

        @JvmStatic
        public static final Synthetics fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Synthetics fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTestId() {
            return this.testId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getResultId() {
            return this.resultId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Boolean getInjected() {
            return this.injected;
        }

        public final Map<String, Object> component4() {
            return this.additionalProperties;
        }

        public final Synthetics copy(String testId, String resultId, Boolean injected, Map<String, Object> additionalProperties) {
            Intrinsics.checkNotNullParameter(testId, "testId");
            Intrinsics.checkNotNullParameter(resultId, "resultId");
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            return new Synthetics(testId, resultId, injected, additionalProperties);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Synthetics)) {
                return false;
            }
            Synthetics synthetics = (Synthetics) other;
            return Intrinsics.areEqual(this.testId, synthetics.testId) && Intrinsics.areEqual(this.resultId, synthetics.resultId) && Intrinsics.areEqual(this.injected, synthetics.injected) && Intrinsics.areEqual(this.additionalProperties, synthetics.additionalProperties);
        }

        public int hashCode() {
            int iHashCode = ((this.testId.hashCode() * 31) + this.resultId.hashCode()) * 31;
            Boolean bool = this.injected;
            return ((iHashCode + (bool == null ? 0 : bool.hashCode())) * 31) + this.additionalProperties.hashCode();
        }

        public String toString() {
            return "Synthetics(testId=" + this.testId + ", resultId=" + this.resultId + ", injected=" + this.injected + ", additionalProperties=" + this.additionalProperties + ")";
        }

        public Synthetics(String testId, String resultId, Boolean bool, Map<String, Object> additionalProperties) {
            Intrinsics.checkNotNullParameter(testId, "testId");
            Intrinsics.checkNotNullParameter(resultId, "resultId");
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            this.testId = testId;
            this.resultId = resultId;
            this.injected = bool;
            this.additionalProperties = additionalProperties;
        }

        public final String getTestId() {
            return this.testId;
        }

        public final String getResultId() {
            return this.resultId;
        }

        public final Boolean getInjected() {
            return this.injected;
        }

        public /* synthetic */ Synthetics(String str, String str2, Boolean bool, LinkedHashMap linkedHashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? new LinkedHashMap() : linkedHashMap);
        }

        public final Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("test_id", this.testId);
            jsonObject.addProperty("result_id", this.resultId);
            Boolean bool = this.injected;
            if (bool != null) {
                bool.booleanValue();
                jsonObject.addProperty("injected", bool);
            }
            for (Map.Entry<String, Object> entry : this.additionalProperties.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (!ArraysKt.contains(RESERVED_PROPERTIES, key)) {
                    jsonObject.add(key, JsonSerializer.INSTANCE.toJsonElement(value));
                }
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0007J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Synthetics$Companion;", "", "()V", "RESERVED_PROPERTIES", "", "", "getRESERVED_PROPERTIES$dd_sdk_android_rum_release", "()[Ljava/lang/String;", "[Ljava/lang/String;", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$Synthetics;", "jsonString", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final String[] getRESERVED_PROPERTIES$dd_sdk_android_rum_release() {
                return Synthetics.RESERVED_PROPERTIES;
            }

            @JvmStatic
            public final Synthetics fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Synthetics", e);
                }
            }

            @JvmStatic
            public final Synthetics fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String testId = jsonObject.get("test_id").getAsString();
                    String resultId = jsonObject.get("result_id").getAsString();
                    JsonElement jsonElement = jsonObject.get("injected");
                    Boolean boolValueOf = jsonElement != null ? Boolean.valueOf(jsonElement.getAsBoolean()) : null;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                        if (!ArraysKt.contains(getRESERVED_PROPERTIES$dd_sdk_android_rum_release(), entry.getKey())) {
                            String key = entry.getKey();
                            Intrinsics.checkNotNullExpressionValue(key, "entry.key");
                            linkedHashMap.put(key, entry.getValue());
                        }
                    }
                    Intrinsics.checkNotNullExpressionValue(testId, "testId");
                    Intrinsics.checkNotNullExpressionValue(resultId, "resultId");
                    return new Synthetics(testId, resultId, boolValueOf, linkedHashMap);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Synthetics", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Synthetics", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Synthetics", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$CiTest;", "", "testExecutionId", "", "(Ljava/lang/String;)V", "getTestExecutionId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class CiTest {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String testExecutionId;

        public static /* synthetic */ CiTest copy$default(CiTest ciTest, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = ciTest.testExecutionId;
            }
            return ciTest.copy(str);
        }

        @JvmStatic
        public static final CiTest fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final CiTest fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTestExecutionId() {
            return this.testExecutionId;
        }

        public final CiTest copy(String testExecutionId) {
            Intrinsics.checkNotNullParameter(testExecutionId, "testExecutionId");
            return new CiTest(testExecutionId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CiTest) && Intrinsics.areEqual(this.testExecutionId, ((CiTest) other).testExecutionId);
        }

        public int hashCode() {
            return this.testExecutionId.hashCode();
        }

        public String toString() {
            return "CiTest(testExecutionId=" + this.testExecutionId + ")";
        }

        public CiTest(String testExecutionId) {
            Intrinsics.checkNotNullParameter(testExecutionId, "testExecutionId");
            this.testExecutionId = testExecutionId;
        }

        public final String getTestExecutionId() {
            return this.testExecutionId;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("test_execution_id", this.testExecutionId);
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$CiTest$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$CiTest;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final CiTest fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type CiTest", e);
                }
            }

            @JvmStatic
            public final CiTest fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String testExecutionId = jsonObject.get("test_execution_id").getAsString();
                    Intrinsics.checkNotNullExpressionValue(testExecutionId, "testExecutionId");
                    return new CiTest(testExecutionId);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type CiTest", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type CiTest", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type CiTest", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0006\u0010\u0017\u001a\u00020\u0018J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Os;", "", "name", "", "version", "build", "versionMajor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBuild", "()Ljava/lang/String;", "getName", "getVersion", "getVersionMajor", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Os {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String build;
        private final String name;
        private final String version;
        private final String versionMajor;

        public static /* synthetic */ Os copy$default(Os os, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = os.name;
            }
            if ((i & 2) != 0) {
                str2 = os.version;
            }
            if ((i & 4) != 0) {
                str3 = os.build;
            }
            if ((i & 8) != 0) {
                str4 = os.versionMajor;
            }
            return os.copy(str, str2, str3, str4);
        }

        @JvmStatic
        public static final Os fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Os fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getVersion() {
            return this.version;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getBuild() {
            return this.build;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getVersionMajor() {
            return this.versionMajor;
        }

        public final Os copy(String name, String version, String build, String versionMajor) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(version, "version");
            Intrinsics.checkNotNullParameter(versionMajor, "versionMajor");
            return new Os(name, version, build, versionMajor);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Os)) {
                return false;
            }
            Os os = (Os) other;
            return Intrinsics.areEqual(this.name, os.name) && Intrinsics.areEqual(this.version, os.version) && Intrinsics.areEqual(this.build, os.build) && Intrinsics.areEqual(this.versionMajor, os.versionMajor);
        }

        public int hashCode() {
            int iHashCode = ((this.name.hashCode() * 31) + this.version.hashCode()) * 31;
            String str = this.build;
            return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.versionMajor.hashCode();
        }

        public String toString() {
            return "Os(name=" + this.name + ", version=" + this.version + ", build=" + this.build + ", versionMajor=" + this.versionMajor + ")";
        }

        public Os(String name, String version, String str, String versionMajor) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(version, "version");
            Intrinsics.checkNotNullParameter(versionMajor, "versionMajor");
            this.name = name;
            this.version = version;
            this.build = str;
            this.versionMajor = versionMajor;
        }

        public /* synthetic */ Os(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? null : str3, str4);
        }

        public final String getName() {
            return this.name;
        }

        public final String getVersion() {
            return this.version;
        }

        public final String getBuild() {
            return this.build;
        }

        public final String getVersionMajor() {
            return this.versionMajor;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("name", this.name);
            jsonObject.addProperty("version", this.version);
            String str = this.build;
            if (str != null) {
                jsonObject.addProperty("build", str);
            }
            jsonObject.addProperty("version_major", this.versionMajor);
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Os$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$Os;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Os fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Os", e);
                }
            }

            @JvmStatic
            public final Os fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String name = jsonObject.get("name").getAsString();
                    String version = jsonObject.get("version").getAsString();
                    JsonElement jsonElement = jsonObject.get("build");
                    String asString = jsonElement != null ? jsonElement.getAsString() : null;
                    String versionMajor = jsonObject.get("version_major").getAsString();
                    Intrinsics.checkNotNullExpressionValue(name, "name");
                    Intrinsics.checkNotNullExpressionValue(version, "version");
                    Intrinsics.checkNotNullExpressionValue(versionMajor, "versionMajor");
                    return new Os(name, version, asString, versionMajor);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Os", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Os", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Os", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u000b\n\u0002\b+\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 @2\u00020\u0001:\u0001@B³\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0015J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010+\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u000eHÆ\u0003J¼\u0001\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u00108J\u0013\u00109\u001a\u00020\u00102\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020<HÖ\u0001J\u0006\u0010=\u001a\u00020>J\t\u0010?\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u0014\u0010\u001cR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b$\u0010\u001cR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u0006A"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Device;", "", "type", "Lcom/datadog/android/rum/model/ViewEvent$DeviceType;", "name", "", "model", "brand", "architecture", Constants.LOCALE, "locales", "", "timeZone", "batteryLevel", "", "powerSavingMode", "", "brightnessLevel", "logicalCpuCount", "totalRam", "isLowRam", "(Lcom/datadog/android/rum/model/ViewEvent$DeviceType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Boolean;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Boolean;)V", "getArchitecture", "()Ljava/lang/String;", "getBatteryLevel", "()Ljava/lang/Number;", "getBrand", "getBrightnessLevel", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLocale", "getLocales", "()Ljava/util/List;", "getLogicalCpuCount", "getModel", "getName", "getPowerSavingMode", "getTimeZone", "getTotalRam", "getType", "()Lcom/datadog/android/rum/model/ViewEvent$DeviceType;", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/datadog/android/rum/model/ViewEvent$DeviceType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Boolean;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Boolean;)Lcom/datadog/android/rum/model/ViewEvent$Device;", "equals", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Device {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String architecture;
        private final Number batteryLevel;
        private final String brand;
        private final Number brightnessLevel;
        private final Boolean isLowRam;
        private final String locale;
        private final List<String> locales;
        private final Number logicalCpuCount;
        private final String model;
        private final String name;
        private final Boolean powerSavingMode;
        private final String timeZone;
        private final Number totalRam;
        private final DeviceType type;

        public Device() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
        }

        @JvmStatic
        public static final Device fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Device fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DeviceType getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Boolean getPowerSavingMode() {
            return this.powerSavingMode;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Number getBrightnessLevel() {
            return this.brightnessLevel;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final Number getLogicalCpuCount() {
            return this.logicalCpuCount;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final Number getTotalRam() {
            return this.totalRam;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final Boolean getIsLowRam() {
            return this.isLowRam;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getModel() {
            return this.model;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getBrand() {
            return this.brand;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getArchitecture() {
            return this.architecture;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getLocale() {
            return this.locale;
        }

        public final List<String> component7() {
            return this.locales;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getTimeZone() {
            return this.timeZone;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Number getBatteryLevel() {
            return this.batteryLevel;
        }

        public final Device copy(DeviceType type, String name, String model, String brand, String architecture, String locale, List<String> locales, String timeZone, Number batteryLevel, Boolean powerSavingMode, Number brightnessLevel, Number logicalCpuCount, Number totalRam, Boolean isLowRam) {
            return new Device(type, name, model, brand, architecture, locale, locales, timeZone, batteryLevel, powerSavingMode, brightnessLevel, logicalCpuCount, totalRam, isLowRam);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Device)) {
                return false;
            }
            Device device = (Device) other;
            return this.type == device.type && Intrinsics.areEqual(this.name, device.name) && Intrinsics.areEqual(this.model, device.model) && Intrinsics.areEqual(this.brand, device.brand) && Intrinsics.areEqual(this.architecture, device.architecture) && Intrinsics.areEqual(this.locale, device.locale) && Intrinsics.areEqual(this.locales, device.locales) && Intrinsics.areEqual(this.timeZone, device.timeZone) && Intrinsics.areEqual(this.batteryLevel, device.batteryLevel) && Intrinsics.areEqual(this.powerSavingMode, device.powerSavingMode) && Intrinsics.areEqual(this.brightnessLevel, device.brightnessLevel) && Intrinsics.areEqual(this.logicalCpuCount, device.logicalCpuCount) && Intrinsics.areEqual(this.totalRam, device.totalRam) && Intrinsics.areEqual(this.isLowRam, device.isLowRam);
        }

        public int hashCode() {
            DeviceType deviceType = this.type;
            int iHashCode = (deviceType == null ? 0 : deviceType.hashCode()) * 31;
            String str = this.name;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.model;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.brand;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.architecture;
            int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.locale;
            int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            List<String> list = this.locales;
            int iHashCode7 = (iHashCode6 + (list == null ? 0 : list.hashCode())) * 31;
            String str6 = this.timeZone;
            int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
            Number number = this.batteryLevel;
            int iHashCode9 = (iHashCode8 + (number == null ? 0 : number.hashCode())) * 31;
            Boolean bool = this.powerSavingMode;
            int iHashCode10 = (iHashCode9 + (bool == null ? 0 : bool.hashCode())) * 31;
            Number number2 = this.brightnessLevel;
            int iHashCode11 = (iHashCode10 + (number2 == null ? 0 : number2.hashCode())) * 31;
            Number number3 = this.logicalCpuCount;
            int iHashCode12 = (iHashCode11 + (number3 == null ? 0 : number3.hashCode())) * 31;
            Number number4 = this.totalRam;
            int iHashCode13 = (iHashCode12 + (number4 == null ? 0 : number4.hashCode())) * 31;
            Boolean bool2 = this.isLowRam;
            return iHashCode13 + (bool2 != null ? bool2.hashCode() : 0);
        }

        public String toString() {
            return "Device(type=" + this.type + ", name=" + this.name + ", model=" + this.model + ", brand=" + this.brand + ", architecture=" + this.architecture + ", locale=" + this.locale + ", locales=" + this.locales + ", timeZone=" + this.timeZone + ", batteryLevel=" + this.batteryLevel + ", powerSavingMode=" + this.powerSavingMode + ", brightnessLevel=" + this.brightnessLevel + ", logicalCpuCount=" + this.logicalCpuCount + ", totalRam=" + this.totalRam + ", isLowRam=" + this.isLowRam + ")";
        }

        public Device(DeviceType deviceType, String str, String str2, String str3, String str4, String str5, List<String> list, String str6, Number number, Boolean bool, Number number2, Number number3, Number number4, Boolean bool2) {
            this.type = deviceType;
            this.name = str;
            this.model = str2;
            this.brand = str3;
            this.architecture = str4;
            this.locale = str5;
            this.locales = list;
            this.timeZone = str6;
            this.batteryLevel = number;
            this.powerSavingMode = bool;
            this.brightnessLevel = number2;
            this.logicalCpuCount = number3;
            this.totalRam = number4;
            this.isLowRam = bool2;
        }

        public /* synthetic */ Device(DeviceType deviceType, String str, String str2, String str3, String str4, String str5, List list, String str6, Number number, Boolean bool, Number number2, Number number3, Number number4, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : deviceType, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : list, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : number, (i & 512) != 0 ? null : bool, (i & 1024) != 0 ? null : number2, (i & 2048) != 0 ? null : number3, (i & 4096) != 0 ? null : number4, (i & 8192) != 0 ? null : bool2);
        }

        public final DeviceType getType() {
            return this.type;
        }

        public final String getName() {
            return this.name;
        }

        public final String getModel() {
            return this.model;
        }

        public final String getBrand() {
            return this.brand;
        }

        public final String getArchitecture() {
            return this.architecture;
        }

        public final String getLocale() {
            return this.locale;
        }

        public final List<String> getLocales() {
            return this.locales;
        }

        public final String getTimeZone() {
            return this.timeZone;
        }

        public final Number getBatteryLevel() {
            return this.batteryLevel;
        }

        public final Boolean getPowerSavingMode() {
            return this.powerSavingMode;
        }

        public final Number getBrightnessLevel() {
            return this.brightnessLevel;
        }

        public final Number getLogicalCpuCount() {
            return this.logicalCpuCount;
        }

        public final Number getTotalRam() {
            return this.totalRam;
        }

        public final Boolean isLowRam() {
            return this.isLowRam;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            DeviceType deviceType = this.type;
            if (deviceType != null) {
                jsonObject.add("type", deviceType.toJson());
            }
            String str = this.name;
            if (str != null) {
                jsonObject.addProperty("name", str);
            }
            String str2 = this.model;
            if (str2 != null) {
                jsonObject.addProperty("model", str2);
            }
            String str3 = this.brand;
            if (str3 != null) {
                jsonObject.addProperty("brand", str3);
            }
            String str4 = this.architecture;
            if (str4 != null) {
                jsonObject.addProperty("architecture", str4);
            }
            String str5 = this.locale;
            if (str5 != null) {
                jsonObject.addProperty(Constants.LOCALE, str5);
            }
            List<String> list = this.locales;
            if (list != null) {
                JsonArray jsonArray = new JsonArray(list.size());
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    jsonArray.add((String) it.next());
                }
                jsonObject.add("locales", jsonArray);
            }
            String str6 = this.timeZone;
            if (str6 != null) {
                jsonObject.addProperty("time_zone", str6);
            }
            Number number = this.batteryLevel;
            if (number != null) {
                jsonObject.addProperty("battery_level", number);
            }
            Boolean bool = this.powerSavingMode;
            if (bool != null) {
                bool.booleanValue();
                jsonObject.addProperty("power_saving_mode", bool);
            }
            Number number2 = this.brightnessLevel;
            if (number2 != null) {
                jsonObject.addProperty("brightness_level", number2);
            }
            Number number3 = this.logicalCpuCount;
            if (number3 != null) {
                jsonObject.addProperty("logical_cpu_count", number3);
            }
            Number number4 = this.totalRam;
            if (number4 != null) {
                jsonObject.addProperty("total_ram", number4);
            }
            Boolean bool2 = this.isLowRam;
            if (bool2 != null) {
                bool2.booleanValue();
                jsonObject.addProperty("is_low_ram", bool2);
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Device$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$Device;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Device fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Device", e);
                }
            }

            @JvmStatic
            public final Device fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                ArrayList arrayList;
                JsonArray asJsonArray;
                String asString;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get("type");
                    DeviceType deviceTypeFromJson = (jsonElement == null || (asString = jsonElement.getAsString()) == null) ? null : DeviceType.INSTANCE.fromJson(asString);
                    JsonElement jsonElement2 = jsonObject.get("name");
                    String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
                    JsonElement jsonElement3 = jsonObject.get("model");
                    String asString3 = jsonElement3 != null ? jsonElement3.getAsString() : null;
                    JsonElement jsonElement4 = jsonObject.get("brand");
                    String asString4 = jsonElement4 != null ? jsonElement4.getAsString() : null;
                    JsonElement jsonElement5 = jsonObject.get("architecture");
                    String asString5 = jsonElement5 != null ? jsonElement5.getAsString() : null;
                    JsonElement jsonElement6 = jsonObject.get(Constants.LOCALE);
                    String asString6 = jsonElement6 != null ? jsonElement6.getAsString() : null;
                    JsonElement jsonElement7 = jsonObject.get("locales");
                    if (jsonElement7 == null || (asJsonArray = jsonElement7.getAsJsonArray()) == null) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(asJsonArray.size());
                        Iterator<JsonElement> it = asJsonArray.iterator();
                        while (it.hasNext()) {
                            arrayList.add(it.next().getAsString());
                        }
                    }
                    JsonElement jsonElement8 = jsonObject.get("time_zone");
                    String asString7 = jsonElement8 != null ? jsonElement8.getAsString() : null;
                    JsonElement jsonElement9 = jsonObject.get("battery_level");
                    Number asNumber = jsonElement9 != null ? jsonElement9.getAsNumber() : null;
                    JsonElement jsonElement10 = jsonObject.get("power_saving_mode");
                    Boolean boolValueOf = jsonElement10 != null ? Boolean.valueOf(jsonElement10.getAsBoolean()) : null;
                    JsonElement jsonElement11 = jsonObject.get("brightness_level");
                    Number asNumber2 = jsonElement11 != null ? jsonElement11.getAsNumber() : null;
                    JsonElement jsonElement12 = jsonObject.get("logical_cpu_count");
                    Number asNumber3 = jsonElement12 != null ? jsonElement12.getAsNumber() : null;
                    JsonElement jsonElement13 = jsonObject.get("total_ram");
                    Number asNumber4 = jsonElement13 != null ? jsonElement13.getAsNumber() : null;
                    JsonElement jsonElement14 = jsonObject.get("is_low_ram");
                    return new Device(deviceTypeFromJson, asString2, asString3, asString4, asString5, asString6, arrayList, asString7, asNumber, boolValueOf, asNumber2, asNumber3, asNumber4, jsonElement14 != null ? Boolean.valueOf(jsonElement14.getAsBoolean()) : null);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Device", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Device", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Device", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 :2\u00020\u0001:\u0001:Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010,\u001a\u00020\nHÆ\u0003J\u0011\u0010-\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0013HÆ\u0003Jy\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u000206HÖ\u0001J\u0006\u00107\u001a\u000208J\t\u00109\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\nX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u0006;"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Dd;", "", "session", "Lcom/datadog/android/rum/model/ViewEvent$DdSession;", "configuration", "Lcom/datadog/android/rum/model/ViewEvent$Configuration;", "browserSdkVersion", "", "sdkName", RumEventMeta.DOCUMENT_VERSION_KEY, "", "pageStates", "", "Lcom/datadog/android/rum/model/ViewEvent$PageState;", "replayStats", "Lcom/datadog/android/rum/model/ViewEvent$ReplayStats;", "cls", "Lcom/datadog/android/rum/model/ViewEvent$DdCls;", "profiling", "Lcom/datadog/android/rum/model/ViewEvent$Profiling;", "(Lcom/datadog/android/rum/model/ViewEvent$DdSession;Lcom/datadog/android/rum/model/ViewEvent$Configuration;Ljava/lang/String;Ljava/lang/String;JLjava/util/List;Lcom/datadog/android/rum/model/ViewEvent$ReplayStats;Lcom/datadog/android/rum/model/ViewEvent$DdCls;Lcom/datadog/android/rum/model/ViewEvent$Profiling;)V", "getBrowserSdkVersion", "()Ljava/lang/String;", "getCls", "()Lcom/datadog/android/rum/model/ViewEvent$DdCls;", "getConfiguration", "()Lcom/datadog/android/rum/model/ViewEvent$Configuration;", "getDocumentVersion", "()J", "formatVersion", "getFormatVersion", "getPageStates", "()Ljava/util/List;", "getProfiling", "()Lcom/datadog/android/rum/model/ViewEvent$Profiling;", "getReplayStats", "()Lcom/datadog/android/rum/model/ViewEvent$ReplayStats;", "getSdkName", "getSession", "()Lcom/datadog/android/rum/model/ViewEvent$DdSession;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Dd {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String browserSdkVersion;
        private final DdCls cls;
        private final Configuration configuration;
        private final long documentVersion;
        private final long formatVersion;
        private final List<PageState> pageStates;
        private final Profiling profiling;
        private final ReplayStats replayStats;
        private final String sdkName;
        private final DdSession session;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Dd copy$default(Dd dd, DdSession ddSession, Configuration configuration, String str, String str2, long j, List list, ReplayStats replayStats, DdCls ddCls, Profiling profiling, int i, Object obj) {
            if ((i & 1) != 0) {
                ddSession = dd.session;
            }
            if ((i & 2) != 0) {
                configuration = dd.configuration;
            }
            if ((i & 4) != 0) {
                str = dd.browserSdkVersion;
            }
            if ((i & 8) != 0) {
                str2 = dd.sdkName;
            }
            if ((i & 16) != 0) {
                j = dd.documentVersion;
            }
            if ((i & 32) != 0) {
                list = dd.pageStates;
            }
            if ((i & 64) != 0) {
                replayStats = dd.replayStats;
            }
            if ((i & 128) != 0) {
                ddCls = dd.cls;
            }
            if ((i & 256) != 0) {
                profiling = dd.profiling;
            }
            long j2 = j;
            String str3 = str;
            String str4 = str2;
            return dd.copy(ddSession, configuration, str3, str4, j2, list, replayStats, ddCls, profiling);
        }

        @JvmStatic
        public static final Dd fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Dd fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DdSession getSession() {
            return this.session;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Configuration getConfiguration() {
            return this.configuration;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getBrowserSdkVersion() {
            return this.browserSdkVersion;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getSdkName() {
            return this.sdkName;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final long getDocumentVersion() {
            return this.documentVersion;
        }

        public final List<PageState> component6() {
            return this.pageStates;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final ReplayStats getReplayStats() {
            return this.replayStats;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final DdCls getCls() {
            return this.cls;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Profiling getProfiling() {
            return this.profiling;
        }

        public final Dd copy(DdSession session, Configuration configuration, String browserSdkVersion, String sdkName, long documentVersion, List<PageState> pageStates, ReplayStats replayStats, DdCls cls, Profiling profiling) {
            return new Dd(session, configuration, browserSdkVersion, sdkName, documentVersion, pageStates, replayStats, cls, profiling);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Dd)) {
                return false;
            }
            Dd dd = (Dd) other;
            return Intrinsics.areEqual(this.session, dd.session) && Intrinsics.areEqual(this.configuration, dd.configuration) && Intrinsics.areEqual(this.browserSdkVersion, dd.browserSdkVersion) && Intrinsics.areEqual(this.sdkName, dd.sdkName) && this.documentVersion == dd.documentVersion && Intrinsics.areEqual(this.pageStates, dd.pageStates) && Intrinsics.areEqual(this.replayStats, dd.replayStats) && Intrinsics.areEqual(this.cls, dd.cls) && Intrinsics.areEqual(this.profiling, dd.profiling);
        }

        public int hashCode() {
            DdSession ddSession = this.session;
            int iHashCode = (ddSession == null ? 0 : ddSession.hashCode()) * 31;
            Configuration configuration = this.configuration;
            int iHashCode2 = (iHashCode + (configuration == null ? 0 : configuration.hashCode())) * 31;
            String str = this.browserSdkVersion;
            int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.sdkName;
            int iHashCode4 = (((iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + Long.hashCode(this.documentVersion)) * 31;
            List<PageState> list = this.pageStates;
            int iHashCode5 = (iHashCode4 + (list == null ? 0 : list.hashCode())) * 31;
            ReplayStats replayStats = this.replayStats;
            int iHashCode6 = (iHashCode5 + (replayStats == null ? 0 : replayStats.hashCode())) * 31;
            DdCls ddCls = this.cls;
            int iHashCode7 = (iHashCode6 + (ddCls == null ? 0 : ddCls.hashCode())) * 31;
            Profiling profiling = this.profiling;
            return iHashCode7 + (profiling != null ? profiling.hashCode() : 0);
        }

        public String toString() {
            return "Dd(session=" + this.session + ", configuration=" + this.configuration + ", browserSdkVersion=" + this.browserSdkVersion + ", sdkName=" + this.sdkName + ", documentVersion=" + this.documentVersion + ", pageStates=" + this.pageStates + ", replayStats=" + this.replayStats + ", cls=" + this.cls + ", profiling=" + this.profiling + ")";
        }

        public Dd(DdSession ddSession, Configuration configuration, String str, String str2, long j, List<PageState> list, ReplayStats replayStats, DdCls ddCls, Profiling profiling) {
            this.session = ddSession;
            this.configuration = configuration;
            this.browserSdkVersion = str;
            this.sdkName = str2;
            this.documentVersion = j;
            this.pageStates = list;
            this.replayStats = replayStats;
            this.cls = ddCls;
            this.profiling = profiling;
            this.formatVersion = 2L;
        }

        public /* synthetic */ Dd(DdSession ddSession, Configuration configuration, String str, String str2, long j, List list, ReplayStats replayStats, DdCls ddCls, Profiling profiling, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : ddSession, (i & 2) != 0 ? null : configuration, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, j, (i & 32) != 0 ? null : list, (i & 64) != 0 ? null : replayStats, (i & 128) != 0 ? null : ddCls, (i & 256) != 0 ? null : profiling);
        }

        public final DdSession getSession() {
            return this.session;
        }

        public final Configuration getConfiguration() {
            return this.configuration;
        }

        public final String getBrowserSdkVersion() {
            return this.browserSdkVersion;
        }

        public final String getSdkName() {
            return this.sdkName;
        }

        public final long getDocumentVersion() {
            return this.documentVersion;
        }

        public final List<PageState> getPageStates() {
            return this.pageStates;
        }

        public final ReplayStats getReplayStats() {
            return this.replayStats;
        }

        public final DdCls getCls() {
            return this.cls;
        }

        public final Profiling getProfiling() {
            return this.profiling;
        }

        public final long getFormatVersion() {
            return this.formatVersion;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("format_version", Long.valueOf(this.formatVersion));
            DdSession ddSession = this.session;
            if (ddSession != null) {
                jsonObject.add("session", ddSession.toJson());
            }
            Configuration configuration = this.configuration;
            if (configuration != null) {
                jsonObject.add("configuration", configuration.toJson());
            }
            String str = this.browserSdkVersion;
            if (str != null) {
                jsonObject.addProperty("browser_sdk_version", str);
            }
            String str2 = this.sdkName;
            if (str2 != null) {
                jsonObject.addProperty("sdk_name", str2);
            }
            jsonObject.addProperty("document_version", Long.valueOf(this.documentVersion));
            List<PageState> list = this.pageStates;
            if (list != null) {
                JsonArray jsonArray = new JsonArray(list.size());
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    jsonArray.add(((PageState) it.next()).toJson());
                }
                jsonObject.add("page_states", jsonArray);
            }
            ReplayStats replayStats = this.replayStats;
            if (replayStats != null) {
                jsonObject.add(WebViewRumEventMapper.DD_REPLAY_STATS, replayStats.toJson());
            }
            DdCls ddCls = this.cls;
            if (ddCls != null) {
                jsonObject.add("cls", ddCls.toJson());
            }
            Profiling profiling = this.profiling;
            if (profiling != null) {
                jsonObject.add("profiling", profiling.toJson());
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Dd$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$Dd;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Dd fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Dd", e);
                }
            }

            @JvmStatic
            public final Dd fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                ArrayList arrayList;
                JsonObject asJsonObject;
                JsonObject asJsonObject2;
                JsonObject asJsonObject3;
                JsonArray asJsonArray;
                JsonObject asJsonObject4;
                JsonObject asJsonObject5;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    long asLong = jsonObject.get("format_version").getAsLong();
                    JsonElement jsonElement = jsonObject.get("session");
                    Profiling profilingFromJsonObject = null;
                    DdSession ddSessionFromJsonObject = (jsonElement == null || (asJsonObject5 = jsonElement.getAsJsonObject()) == null) ? null : DdSession.INSTANCE.fromJsonObject(asJsonObject5);
                    JsonElement jsonElement2 = jsonObject.get("configuration");
                    Configuration configurationFromJsonObject = (jsonElement2 == null || (asJsonObject4 = jsonElement2.getAsJsonObject()) == null) ? null : Configuration.INSTANCE.fromJsonObject(asJsonObject4);
                    JsonElement jsonElement3 = jsonObject.get("browser_sdk_version");
                    String asString = jsonElement3 != null ? jsonElement3.getAsString() : null;
                    JsonElement jsonElement4 = jsonObject.get("sdk_name");
                    String asString2 = jsonElement4 != null ? jsonElement4.getAsString() : null;
                    long asLong2 = jsonObject.get("document_version").getAsLong();
                    JsonElement jsonElement5 = jsonObject.get("page_states");
                    if (jsonElement5 == null || (asJsonArray = jsonElement5.getAsJsonArray()) == null) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(asJsonArray.size());
                        for (JsonElement jsonElement6 : asJsonArray) {
                            PageState.Companion companion = PageState.INSTANCE;
                            JsonObject asJsonObject6 = jsonElement6.getAsJsonObject();
                            Intrinsics.checkNotNullExpressionValue(asJsonObject6, "it.asJsonObject");
                            arrayList.add(companion.fromJsonObject(asJsonObject6));
                        }
                    }
                    JsonElement jsonElement7 = jsonObject.get(WebViewRumEventMapper.DD_REPLAY_STATS);
                    ReplayStats replayStatsFromJsonObject = (jsonElement7 == null || (asJsonObject3 = jsonElement7.getAsJsonObject()) == null) ? null : ReplayStats.INSTANCE.fromJsonObject(asJsonObject3);
                    JsonElement jsonElement8 = jsonObject.get("cls");
                    DdCls ddClsFromJsonObject = (jsonElement8 == null || (asJsonObject2 = jsonElement8.getAsJsonObject()) == null) ? null : DdCls.INSTANCE.fromJsonObject(asJsonObject2);
                    JsonElement jsonElement9 = jsonObject.get("profiling");
                    if (jsonElement9 != null && (asJsonObject = jsonElement9.getAsJsonObject()) != null) {
                        profilingFromJsonObject = Profiling.INSTANCE.fromJsonObject(asJsonObject);
                    }
                    if (asLong != 2) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    return new Dd(ddSessionFromJsonObject, configurationFromJsonObject, asString, asString2, asLong2, arrayList, replayStatsFromJsonObject, ddClsFromJsonObject, profilingFromJsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Dd", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Dd", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Dd", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001d\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0017\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003HÆ\u0003J!\u0010\t\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Context;", "", "additionalProperties", "", "", "(Ljava/util/Map;)V", "getAdditionalProperties", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Context {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Map<String, Object> additionalProperties;

        /* JADX WARN: Multi-variable type inference failed */
        public Context() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Context copy$default(Context context, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                map = context.additionalProperties;
            }
            return context.copy(map);
        }

        @JvmStatic
        public static final Context fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Context fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        public final Map<String, Object> component1() {
            return this.additionalProperties;
        }

        public final Context copy(Map<String, Object> additionalProperties) {
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            return new Context(additionalProperties);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Context) && Intrinsics.areEqual(this.additionalProperties, ((Context) other).additionalProperties);
        }

        public int hashCode() {
            return this.additionalProperties.hashCode();
        }

        public String toString() {
            return "Context(additionalProperties=" + this.additionalProperties + ")";
        }

        public Context(Map<String, Object> additionalProperties) {
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            this.additionalProperties = additionalProperties;
        }

        public /* synthetic */ Context(LinkedHashMap linkedHashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new LinkedHashMap() : linkedHashMap);
        }

        public final Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            for (Map.Entry<String, Object> entry : this.additionalProperties.entrySet()) {
                jsonObject.add(entry.getKey(), JsonSerializer.INSTANCE.toJsonElement(entry.getValue()));
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Context$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$Context;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Context fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Context", e);
                }
            }

            @JvmStatic
            public final Context fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                        String key = entry.getKey();
                        Intrinsics.checkNotNullExpressionValue(key, "entry.key");
                        linkedHashMap.put(key, entry.getValue());
                    }
                    return new Context(linkedHashMap);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Context", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Context", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Context", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Stream;", "", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Stream {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String id;

        public static /* synthetic */ Stream copy$default(Stream stream, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = stream.id;
            }
            return stream.copy(str);
        }

        @JvmStatic
        public static final Stream fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Stream fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        public final Stream copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Stream(id);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Stream) && Intrinsics.areEqual(this.id, ((Stream) other).id);
        }

        public int hashCode() {
            return this.id.hashCode();
        }

        public String toString() {
            return "Stream(id=" + this.id + ")";
        }

        public Stream(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public final String getId() {
            return this.id;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id", this.id);
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Stream$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$Stream;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Stream fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Stream", e);
                }
            }

            @JvmStatic
            public final Stream fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String id = jsonObject.get("id").getAsString();
                    Intrinsics.checkNotNullExpressionValue(id, "id");
                    return new Stream(id);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Stream", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Stream", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Stream", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Container;", "", "view", "Lcom/datadog/android/rum/model/ViewEvent$ContainerView;", "source", "Lcom/datadog/android/rum/model/ViewEvent$ViewEventSource;", "(Lcom/datadog/android/rum/model/ViewEvent$ContainerView;Lcom/datadog/android/rum/model/ViewEvent$ViewEventSource;)V", "getSource", "()Lcom/datadog/android/rum/model/ViewEvent$ViewEventSource;", "getView", "()Lcom/datadog/android/rum/model/ViewEvent$ContainerView;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Container {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final ViewEventSource source;
        private final ContainerView view;

        public static /* synthetic */ Container copy$default(Container container, ContainerView containerView, ViewEventSource viewEventSource, int i, Object obj) {
            if ((i & 1) != 0) {
                containerView = container.view;
            }
            if ((i & 2) != 0) {
                viewEventSource = container.source;
            }
            return container.copy(containerView, viewEventSource);
        }

        @JvmStatic
        public static final Container fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Container fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ContainerView getView() {
            return this.view;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ViewEventSource getSource() {
            return this.source;
        }

        public final Container copy(ContainerView view, ViewEventSource source) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(source, "source");
            return new Container(view, source);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Container)) {
                return false;
            }
            Container container = (Container) other;
            return Intrinsics.areEqual(this.view, container.view) && this.source == container.source;
        }

        public int hashCode() {
            return (this.view.hashCode() * 31) + this.source.hashCode();
        }

        public String toString() {
            return "Container(view=" + this.view + ", source=" + this.source + ")";
        }

        public Container(ContainerView view, ViewEventSource source) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(source, "source");
            this.view = view;
            this.source = source;
        }

        public final ContainerView getView() {
            return this.view;
        }

        public final ViewEventSource getSource() {
            return this.source;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("view", this.view.toJson());
            jsonObject.add("source", this.source.toJson());
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Container$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$Container;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Container fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Container", e);
                }
            }

            @JvmStatic
            public final Container fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonObject it = jsonObject.get("view").getAsJsonObject();
                    ContainerView.Companion companion = ContainerView.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    ContainerView containerViewFromJsonObject = companion.fromJsonObject(it);
                    ViewEventSource.Companion companion2 = ViewEventSource.INSTANCE;
                    String asString = jsonObject.get("source").getAsString();
                    Intrinsics.checkNotNullExpressionValue(asString, "jsonObject.get(\"source\").asString");
                    return new Container(containerViewFromJsonObject, companion2.fromJson(asString));
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Container", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Container", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Container", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Privacy;", "", "replayLevel", "Lcom/datadog/android/rum/model/ViewEvent$ReplayLevel;", "(Lcom/datadog/android/rum/model/ViewEvent$ReplayLevel;)V", "getReplayLevel", "()Lcom/datadog/android/rum/model/ViewEvent$ReplayLevel;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Privacy {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final ReplayLevel replayLevel;

        public static /* synthetic */ Privacy copy$default(Privacy privacy, ReplayLevel replayLevel, int i, Object obj) {
            if ((i & 1) != 0) {
                replayLevel = privacy.replayLevel;
            }
            return privacy.copy(replayLevel);
        }

        @JvmStatic
        public static final Privacy fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Privacy fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ReplayLevel getReplayLevel() {
            return this.replayLevel;
        }

        public final Privacy copy(ReplayLevel replayLevel) {
            Intrinsics.checkNotNullParameter(replayLevel, "replayLevel");
            return new Privacy(replayLevel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Privacy) && this.replayLevel == ((Privacy) other).replayLevel;
        }

        public int hashCode() {
            return this.replayLevel.hashCode();
        }

        public String toString() {
            return "Privacy(replayLevel=" + this.replayLevel + ")";
        }

        public Privacy(ReplayLevel replayLevel) {
            Intrinsics.checkNotNullParameter(replayLevel, "replayLevel");
            this.replayLevel = replayLevel;
        }

        public final ReplayLevel getReplayLevel() {
            return this.replayLevel;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("replay_level", this.replayLevel.toJson());
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Privacy$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$Privacy;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Privacy fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Privacy", e);
                }
            }

            @JvmStatic
            public final Privacy fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    ReplayLevel.Companion companion = ReplayLevel.INSTANCE;
                    String asString = jsonObject.get("replay_level").getAsString();
                    Intrinsics.checkNotNullExpressionValue(asString, "jsonObject.get(\"replay_level\").asString");
                    return new Privacy(companion.fromJson(asString));
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Privacy", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Privacy", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Privacy", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001b\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\n\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0006\u0010\u0010\u001a\u00020\u0011J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$CustomTimings;", "", "additionalProperties", "", "", "", "(Ljava/util/Map;)V", "getAdditionalProperties", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class CustomTimings {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Map<String, Long> additionalProperties;

        /* JADX WARN: Multi-variable type inference failed */
        public CustomTimings() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CustomTimings copy$default(CustomTimings customTimings, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                map = customTimings.additionalProperties;
            }
            return customTimings.copy(map);
        }

        @JvmStatic
        public static final CustomTimings fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final CustomTimings fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        public final Map<String, Long> component1() {
            return this.additionalProperties;
        }

        public final CustomTimings copy(Map<String, Long> additionalProperties) {
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            return new CustomTimings(additionalProperties);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CustomTimings) && Intrinsics.areEqual(this.additionalProperties, ((CustomTimings) other).additionalProperties);
        }

        public int hashCode() {
            return this.additionalProperties.hashCode();
        }

        public String toString() {
            return "CustomTimings(additionalProperties=" + this.additionalProperties + ")";
        }

        public CustomTimings(Map<String, Long> additionalProperties) {
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            this.additionalProperties = additionalProperties;
        }

        public /* synthetic */ CustomTimings(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? MapsKt.emptyMap() : map);
        }

        public final Map<String, Long> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            for (Map.Entry<String, Long> entry : this.additionalProperties.entrySet()) {
                jsonObject.addProperty(entry.getKey(), Long.valueOf(entry.getValue().longValue()));
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$CustomTimings$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$CustomTimings;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final CustomTimings fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type CustomTimings", e);
                }
            }

            @JvmStatic
            public final CustomTimings fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                        String key = entry.getKey();
                        Intrinsics.checkNotNullExpressionValue(key, "entry.key");
                        linkedHashMap.put(key, Long.valueOf(entry.getValue().getAsLong()));
                    }
                    return new CustomTimings(linkedHashMap);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type CustomTimings", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type CustomTimings", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type CustomTimings", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Action;", "", "count", "", "(J)V", "getCount", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Action {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long count;

        public static /* synthetic */ Action copy$default(Action action, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = action.count;
            }
            return action.copy(j);
        }

        @JvmStatic
        public static final Action fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Action fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getCount() {
            return this.count;
        }

        public final Action copy(long count) {
            return new Action(count);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Action) && this.count == ((Action) other).count;
        }

        public int hashCode() {
            return Long.hashCode(this.count);
        }

        public String toString() {
            return "Action(count=" + this.count + ")";
        }

        public Action(long j) {
            this.count = j;
        }

        public final long getCount() {
            return this.count;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("count", Long.valueOf(this.count));
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Action$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$Action;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Action fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Action", e);
                }
            }

            @JvmStatic
            public final Action fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    return new Action(jsonObject.get("count").getAsLong());
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Action", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Action", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Action", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Error;", "", "count", "", "(J)V", "getCount", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Error {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long count;

        public static /* synthetic */ Error copy$default(Error error, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = error.count;
            }
            return error.copy(j);
        }

        @JvmStatic
        public static final Error fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Error fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getCount() {
            return this.count;
        }

        public final Error copy(long count) {
            return new Error(count);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Error) && this.count == ((Error) other).count;
        }

        public int hashCode() {
            return Long.hashCode(this.count);
        }

        public String toString() {
            return "Error(count=" + this.count + ")";
        }

        public Error(long j) {
            this.count = j;
        }

        public final long getCount() {
            return this.count;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("count", Long.valueOf(this.count));
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Error$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$Error;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Error fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Error", e);
                }
            }

            @JvmStatic
            public final Error fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    return new Error(jsonObject.get("count").getAsLong());
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Error", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Error", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Error", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Crash;", "", "count", "", "(J)V", "getCount", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Crash {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long count;

        public static /* synthetic */ Crash copy$default(Crash crash, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = crash.count;
            }
            return crash.copy(j);
        }

        @JvmStatic
        public static final Crash fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Crash fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getCount() {
            return this.count;
        }

        public final Crash copy(long count) {
            return new Crash(count);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Crash) && this.count == ((Crash) other).count;
        }

        public int hashCode() {
            return Long.hashCode(this.count);
        }

        public String toString() {
            return "Crash(count=" + this.count + ")";
        }

        public Crash(long j) {
            this.count = j;
        }

        public final long getCount() {
            return this.count;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("count", Long.valueOf(this.count));
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Crash$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$Crash;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Crash fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Crash", e);
                }
            }

            @JvmStatic
            public final Crash fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    return new Crash(jsonObject.get("count").getAsLong());
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Crash", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Crash", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Crash", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$LongTask;", "", "count", "", "(J)V", "getCount", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class LongTask {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long count;

        public static /* synthetic */ LongTask copy$default(LongTask longTask, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = longTask.count;
            }
            return longTask.copy(j);
        }

        @JvmStatic
        public static final LongTask fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final LongTask fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getCount() {
            return this.count;
        }

        public final LongTask copy(long count) {
            return new LongTask(count);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof LongTask) && this.count == ((LongTask) other).count;
        }

        public int hashCode() {
            return Long.hashCode(this.count);
        }

        public String toString() {
            return "LongTask(count=" + this.count + ")";
        }

        public LongTask(long j) {
            this.count = j;
        }

        public final long getCount() {
            return this.count;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("count", Long.valueOf(this.count));
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$LongTask$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$LongTask;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final LongTask fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type LongTask", e);
                }
            }

            @JvmStatic
            public final LongTask fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    return new LongTask(jsonObject.get("count").getAsLong());
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type LongTask", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type LongTask", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type LongTask", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$FrozenFrame;", "", "count", "", "(J)V", "getCount", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class FrozenFrame {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long count;

        public static /* synthetic */ FrozenFrame copy$default(FrozenFrame frozenFrame, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = frozenFrame.count;
            }
            return frozenFrame.copy(j);
        }

        @JvmStatic
        public static final FrozenFrame fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final FrozenFrame fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getCount() {
            return this.count;
        }

        public final FrozenFrame copy(long count) {
            return new FrozenFrame(count);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof FrozenFrame) && this.count == ((FrozenFrame) other).count;
        }

        public int hashCode() {
            return Long.hashCode(this.count);
        }

        public String toString() {
            return "FrozenFrame(count=" + this.count + ")";
        }

        public FrozenFrame(long j) {
            this.count = j;
        }

        public final long getCount() {
            return this.count;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("count", Long.valueOf(this.count));
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$FrozenFrame$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$FrozenFrame;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final FrozenFrame fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type FrozenFrame", e);
                }
            }

            @JvmStatic
            public final FrozenFrame fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    return new FrozenFrame(jsonObject.get("count").getAsLong());
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type FrozenFrame", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type FrozenFrame", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type FrozenFrame", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$SlowFrame;", "", ViewProps.START, "", "duration", "(JJ)V", "getDuration", "()J", "getStart", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class SlowFrame {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long duration;
        private final long start;

        public static /* synthetic */ SlowFrame copy$default(SlowFrame slowFrame, long j, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = slowFrame.start;
            }
            if ((i & 2) != 0) {
                j2 = slowFrame.duration;
            }
            return slowFrame.copy(j, j2);
        }

        @JvmStatic
        public static final SlowFrame fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final SlowFrame fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getStart() {
            return this.start;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getDuration() {
            return this.duration;
        }

        public final SlowFrame copy(long start, long duration) {
            return new SlowFrame(start, duration);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SlowFrame)) {
                return false;
            }
            SlowFrame slowFrame = (SlowFrame) other;
            return this.start == slowFrame.start && this.duration == slowFrame.duration;
        }

        public int hashCode() {
            return (Long.hashCode(this.start) * 31) + Long.hashCode(this.duration);
        }

        public String toString() {
            return "SlowFrame(start=" + this.start + ", duration=" + this.duration + ")";
        }

        public SlowFrame(long j, long j2) {
            this.start = j;
            this.duration = j2;
        }

        public final long getStart() {
            return this.start;
        }

        public final long getDuration() {
            return this.duration;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(ViewProps.START, Long.valueOf(this.start));
            jsonObject.addProperty("duration", Long.valueOf(this.duration));
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$SlowFrame$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$SlowFrame;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final SlowFrame fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type SlowFrame", e);
                }
            }

            @JvmStatic
            public final SlowFrame fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    return new SlowFrame(jsonObject.get(ViewProps.START).getAsLong(), jsonObject.get("duration").getAsLong());
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type SlowFrame", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type SlowFrame", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type SlowFrame", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Resource;", "", "count", "", "(J)V", "getCount", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Resource {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long count;

        public static /* synthetic */ Resource copy$default(Resource resource, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = resource.count;
            }
            return resource.copy(j);
        }

        @JvmStatic
        public static final Resource fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Resource fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getCount() {
            return this.count;
        }

        public final Resource copy(long count) {
            return new Resource(count);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Resource) && this.count == ((Resource) other).count;
        }

        public int hashCode() {
            return Long.hashCode(this.count);
        }

        public String toString() {
            return "Resource(count=" + this.count + ")";
        }

        public Resource(long j) {
            this.count = j;
        }

        public final long getCount() {
            return this.count;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("count", Long.valueOf(this.count));
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Resource$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$Resource;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Resource fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Resource", e);
                }
            }

            @JvmStatic
            public final Resource fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    return new Resource(jsonObject.get("count").getAsLong());
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Resource", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Resource", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Resource", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Frustration;", "", "count", "", "(J)V", "getCount", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Frustration {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long count;

        public static /* synthetic */ Frustration copy$default(Frustration frustration, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = frustration.count;
            }
            return frustration.copy(j);
        }

        @JvmStatic
        public static final Frustration fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Frustration fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getCount() {
            return this.count;
        }

        public final Frustration copy(long count) {
            return new Frustration(count);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Frustration) && this.count == ((Frustration) other).count;
        }

        public int hashCode() {
            return Long.hashCode(this.count);
        }

        public String toString() {
            return "Frustration(count=" + this.count + ")";
        }

        public Frustration(long j) {
            this.count = j;
        }

        public final long getCount() {
            return this.count;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("count", Long.valueOf(this.count));
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Frustration$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$Frustration;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Frustration fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Frustration", e);
                }
            }

            @JvmStatic
            public final Frustration fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    return new Frustration(jsonObject.get("count").getAsLong());
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Frustration", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Frustration", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Frustration", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$InForegroundPeriod;", "", ViewProps.START, "", "duration", "(JJ)V", "getDuration", "()J", "getStart", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class InForegroundPeriod {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long duration;
        private final long start;

        public static /* synthetic */ InForegroundPeriod copy$default(InForegroundPeriod inForegroundPeriod, long j, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = inForegroundPeriod.start;
            }
            if ((i & 2) != 0) {
                j2 = inForegroundPeriod.duration;
            }
            return inForegroundPeriod.copy(j, j2);
        }

        @JvmStatic
        public static final InForegroundPeriod fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final InForegroundPeriod fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getStart() {
            return this.start;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getDuration() {
            return this.duration;
        }

        public final InForegroundPeriod copy(long start, long duration) {
            return new InForegroundPeriod(start, duration);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InForegroundPeriod)) {
                return false;
            }
            InForegroundPeriod inForegroundPeriod = (InForegroundPeriod) other;
            return this.start == inForegroundPeriod.start && this.duration == inForegroundPeriod.duration;
        }

        public int hashCode() {
            return (Long.hashCode(this.start) * 31) + Long.hashCode(this.duration);
        }

        public String toString() {
            return "InForegroundPeriod(start=" + this.start + ", duration=" + this.duration + ")";
        }

        public InForegroundPeriod(long j, long j2) {
            this.start = j;
            this.duration = j2;
        }

        public final long getStart() {
            return this.start;
        }

        public final long getDuration() {
            return this.duration;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(ViewProps.START, Long.valueOf(this.start));
            jsonObject.addProperty("duration", Long.valueOf(this.duration));
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$InForegroundPeriod$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$InForegroundPeriod;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final InForegroundPeriod fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type InForegroundPeriod", e);
                }
            }

            @JvmStatic
            public final InForegroundPeriod fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    return new InForegroundPeriod(jsonObject.get(ViewProps.START).getAsLong(), jsonObject.get("duration").getAsLong());
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type InForegroundPeriod", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type InForegroundPeriod", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type InForegroundPeriod", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0006\u0010\u0017\u001a\u00020\u0018J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$FlutterBuildTime;", "", BatchMetricsDispatcher.UPLOADER_DELAY_MIN_KEY, "", BatchMetricsDispatcher.UPLOADER_DELAY_MAX_KEY, "average", "metricMax", "(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)V", "getAverage", "()Ljava/lang/Number;", "getMax", "getMetricMax", "getMin", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class FlutterBuildTime {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Number average;
        private final Number max;
        private final Number metricMax;
        private final Number min;

        public static /* synthetic */ FlutterBuildTime copy$default(FlutterBuildTime flutterBuildTime, Number number, Number number2, Number number3, Number number4, int i, Object obj) {
            if ((i & 1) != 0) {
                number = flutterBuildTime.min;
            }
            if ((i & 2) != 0) {
                number2 = flutterBuildTime.max;
            }
            if ((i & 4) != 0) {
                number3 = flutterBuildTime.average;
            }
            if ((i & 8) != 0) {
                number4 = flutterBuildTime.metricMax;
            }
            return flutterBuildTime.copy(number, number2, number3, number4);
        }

        @JvmStatic
        public static final FlutterBuildTime fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final FlutterBuildTime fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Number getMin() {
            return this.min;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Number getMax() {
            return this.max;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Number getAverage() {
            return this.average;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Number getMetricMax() {
            return this.metricMax;
        }

        public final FlutterBuildTime copy(Number min, Number max, Number average, Number metricMax) {
            Intrinsics.checkNotNullParameter(min, "min");
            Intrinsics.checkNotNullParameter(max, "max");
            Intrinsics.checkNotNullParameter(average, "average");
            return new FlutterBuildTime(min, max, average, metricMax);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FlutterBuildTime)) {
                return false;
            }
            FlutterBuildTime flutterBuildTime = (FlutterBuildTime) other;
            return Intrinsics.areEqual(this.min, flutterBuildTime.min) && Intrinsics.areEqual(this.max, flutterBuildTime.max) && Intrinsics.areEqual(this.average, flutterBuildTime.average) && Intrinsics.areEqual(this.metricMax, flutterBuildTime.metricMax);
        }

        public int hashCode() {
            int iHashCode = ((((this.min.hashCode() * 31) + this.max.hashCode()) * 31) + this.average.hashCode()) * 31;
            Number number = this.metricMax;
            return iHashCode + (number == null ? 0 : number.hashCode());
        }

        public String toString() {
            return "FlutterBuildTime(min=" + this.min + ", max=" + this.max + ", average=" + this.average + ", metricMax=" + this.metricMax + ")";
        }

        public FlutterBuildTime(Number min, Number max, Number average, Number number) {
            Intrinsics.checkNotNullParameter(min, "min");
            Intrinsics.checkNotNullParameter(max, "max");
            Intrinsics.checkNotNullParameter(average, "average");
            this.min = min;
            this.max = max;
            this.average = average;
            this.metricMax = number;
        }

        public /* synthetic */ FlutterBuildTime(Number number, Number number2, Number number3, Number number4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(number, number2, number3, (i & 8) != 0 ? null : number4);
        }

        public final Number getMin() {
            return this.min;
        }

        public final Number getMax() {
            return this.max;
        }

        public final Number getAverage() {
            return this.average;
        }

        public final Number getMetricMax() {
            return this.metricMax;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(BatchMetricsDispatcher.UPLOADER_DELAY_MIN_KEY, this.min);
            jsonObject.addProperty(BatchMetricsDispatcher.UPLOADER_DELAY_MAX_KEY, this.max);
            jsonObject.addProperty("average", this.average);
            Number number = this.metricMax;
            if (number != null) {
                jsonObject.addProperty("metric_max", number);
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$FlutterBuildTime$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$FlutterBuildTime;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final FlutterBuildTime fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type FlutterBuildTime", e);
                }
            }

            @JvmStatic
            public final FlutterBuildTime fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    Number min = jsonObject.get(BatchMetricsDispatcher.UPLOADER_DELAY_MIN_KEY).getAsNumber();
                    Number max = jsonObject.get(BatchMetricsDispatcher.UPLOADER_DELAY_MAX_KEY).getAsNumber();
                    Number average = jsonObject.get("average").getAsNumber();
                    JsonElement jsonElement = jsonObject.get("metric_max");
                    Number asNumber = jsonElement != null ? jsonElement.getAsNumber() : null;
                    Intrinsics.checkNotNullExpressionValue(min, "min");
                    Intrinsics.checkNotNullExpressionValue(max, "max");
                    Intrinsics.checkNotNullExpressionValue(average, "average");
                    return new FlutterBuildTime(min, max, average, asNumber);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type FlutterBuildTime", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type FlutterBuildTime", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type FlutterBuildTime", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 +2\u00020\u0001:\u0001+BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\rHÆ\u0003JQ\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\u0006\u0010'\u001a\u00020(J\t\u0010)\u001a\u00020*HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006,"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Performance;", "", "cls", "Lcom/datadog/android/rum/model/ViewEvent$PerformanceCls;", "fcp", "Lcom/datadog/android/rum/model/ViewEvent$Fcp;", "fid", "Lcom/datadog/android/rum/model/ViewEvent$Fid;", "inp", "Lcom/datadog/android/rum/model/ViewEvent$Inp;", "lcp", "Lcom/datadog/android/rum/model/ViewEvent$Lcp;", "fbc", "Lcom/datadog/android/rum/model/ViewEvent$Fbc;", "(Lcom/datadog/android/rum/model/ViewEvent$PerformanceCls;Lcom/datadog/android/rum/model/ViewEvent$Fcp;Lcom/datadog/android/rum/model/ViewEvent$Fid;Lcom/datadog/android/rum/model/ViewEvent$Inp;Lcom/datadog/android/rum/model/ViewEvent$Lcp;Lcom/datadog/android/rum/model/ViewEvent$Fbc;)V", "getCls", "()Lcom/datadog/android/rum/model/ViewEvent$PerformanceCls;", "getFbc", "()Lcom/datadog/android/rum/model/ViewEvent$Fbc;", "getFcp", "()Lcom/datadog/android/rum/model/ViewEvent$Fcp;", "getFid", "()Lcom/datadog/android/rum/model/ViewEvent$Fid;", "getInp", "()Lcom/datadog/android/rum/model/ViewEvent$Inp;", "getLcp", "()Lcom/datadog/android/rum/model/ViewEvent$Lcp;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Performance {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final PerformanceCls cls;
        private final Fbc fbc;
        private final Fcp fcp;
        private final Fid fid;
        private final Inp inp;
        private final Lcp lcp;

        public Performance() {
            this(null, null, null, null, null, null, 63, null);
        }

        public static /* synthetic */ Performance copy$default(Performance performance, PerformanceCls performanceCls, Fcp fcp, Fid fid, Inp inp, Lcp lcp, Fbc fbc, int i, Object obj) {
            if ((i & 1) != 0) {
                performanceCls = performance.cls;
            }
            if ((i & 2) != 0) {
                fcp = performance.fcp;
            }
            if ((i & 4) != 0) {
                fid = performance.fid;
            }
            if ((i & 8) != 0) {
                inp = performance.inp;
            }
            if ((i & 16) != 0) {
                lcp = performance.lcp;
            }
            if ((i & 32) != 0) {
                fbc = performance.fbc;
            }
            Lcp lcp2 = lcp;
            Fbc fbc2 = fbc;
            return performance.copy(performanceCls, fcp, fid, inp, lcp2, fbc2);
        }

        @JvmStatic
        public static final Performance fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Performance fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final PerformanceCls getCls() {
            return this.cls;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Fcp getFcp() {
            return this.fcp;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Fid getFid() {
            return this.fid;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Inp getInp() {
            return this.inp;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Lcp getLcp() {
            return this.lcp;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Fbc getFbc() {
            return this.fbc;
        }

        public final Performance copy(PerformanceCls cls, Fcp fcp, Fid fid, Inp inp, Lcp lcp, Fbc fbc) {
            return new Performance(cls, fcp, fid, inp, lcp, fbc);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Performance)) {
                return false;
            }
            Performance performance = (Performance) other;
            return Intrinsics.areEqual(this.cls, performance.cls) && Intrinsics.areEqual(this.fcp, performance.fcp) && Intrinsics.areEqual(this.fid, performance.fid) && Intrinsics.areEqual(this.inp, performance.inp) && Intrinsics.areEqual(this.lcp, performance.lcp) && Intrinsics.areEqual(this.fbc, performance.fbc);
        }

        public int hashCode() {
            PerformanceCls performanceCls = this.cls;
            int iHashCode = (performanceCls == null ? 0 : performanceCls.hashCode()) * 31;
            Fcp fcp = this.fcp;
            int iHashCode2 = (iHashCode + (fcp == null ? 0 : fcp.hashCode())) * 31;
            Fid fid = this.fid;
            int iHashCode3 = (iHashCode2 + (fid == null ? 0 : fid.hashCode())) * 31;
            Inp inp = this.inp;
            int iHashCode4 = (iHashCode3 + (inp == null ? 0 : inp.hashCode())) * 31;
            Lcp lcp = this.lcp;
            int iHashCode5 = (iHashCode4 + (lcp == null ? 0 : lcp.hashCode())) * 31;
            Fbc fbc = this.fbc;
            return iHashCode5 + (fbc != null ? fbc.hashCode() : 0);
        }

        public String toString() {
            return "Performance(cls=" + this.cls + ", fcp=" + this.fcp + ", fid=" + this.fid + ", inp=" + this.inp + ", lcp=" + this.lcp + ", fbc=" + this.fbc + ")";
        }

        public Performance(PerformanceCls performanceCls, Fcp fcp, Fid fid, Inp inp, Lcp lcp, Fbc fbc) {
            this.cls = performanceCls;
            this.fcp = fcp;
            this.fid = fid;
            this.inp = inp;
            this.lcp = lcp;
            this.fbc = fbc;
        }

        public /* synthetic */ Performance(PerformanceCls performanceCls, Fcp fcp, Fid fid, Inp inp, Lcp lcp, Fbc fbc, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : performanceCls, (i & 2) != 0 ? null : fcp, (i & 4) != 0 ? null : fid, (i & 8) != 0 ? null : inp, (i & 16) != 0 ? null : lcp, (i & 32) != 0 ? null : fbc);
        }

        public final PerformanceCls getCls() {
            return this.cls;
        }

        public final Fcp getFcp() {
            return this.fcp;
        }

        public final Fid getFid() {
            return this.fid;
        }

        public final Inp getInp() {
            return this.inp;
        }

        public final Lcp getLcp() {
            return this.lcp;
        }

        public final Fbc getFbc() {
            return this.fbc;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            PerformanceCls performanceCls = this.cls;
            if (performanceCls != null) {
                jsonObject.add("cls", performanceCls.toJson());
            }
            Fcp fcp = this.fcp;
            if (fcp != null) {
                jsonObject.add("fcp", fcp.toJson());
            }
            Fid fid = this.fid;
            if (fid != null) {
                jsonObject.add("fid", fid.toJson());
            }
            Inp inp = this.inp;
            if (inp != null) {
                jsonObject.add("inp", inp.toJson());
            }
            Lcp lcp = this.lcp;
            if (lcp != null) {
                jsonObject.add("lcp", lcp.toJson());
            }
            Fbc fbc = this.fbc;
            if (fbc != null) {
                jsonObject.add("fbc", fbc.toJson());
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Performance$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$Performance;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Performance fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Performance", e);
                }
            }

            @JvmStatic
            public final Performance fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                JsonObject asJsonObject;
                JsonObject asJsonObject2;
                JsonObject asJsonObject3;
                JsonObject asJsonObject4;
                JsonObject asJsonObject5;
                JsonObject asJsonObject6;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get("cls");
                    Fbc fbcFromJsonObject = null;
                    PerformanceCls performanceClsFromJsonObject = (jsonElement == null || (asJsonObject6 = jsonElement.getAsJsonObject()) == null) ? null : PerformanceCls.INSTANCE.fromJsonObject(asJsonObject6);
                    JsonElement jsonElement2 = jsonObject.get("fcp");
                    Fcp fcpFromJsonObject = (jsonElement2 == null || (asJsonObject5 = jsonElement2.getAsJsonObject()) == null) ? null : Fcp.INSTANCE.fromJsonObject(asJsonObject5);
                    JsonElement jsonElement3 = jsonObject.get("fid");
                    Fid fidFromJsonObject = (jsonElement3 == null || (asJsonObject4 = jsonElement3.getAsJsonObject()) == null) ? null : Fid.INSTANCE.fromJsonObject(asJsonObject4);
                    JsonElement jsonElement4 = jsonObject.get("inp");
                    Inp inpFromJsonObject = (jsonElement4 == null || (asJsonObject3 = jsonElement4.getAsJsonObject()) == null) ? null : Inp.INSTANCE.fromJsonObject(asJsonObject3);
                    JsonElement jsonElement5 = jsonObject.get("lcp");
                    Lcp lcpFromJsonObject = (jsonElement5 == null || (asJsonObject2 = jsonElement5.getAsJsonObject()) == null) ? null : Lcp.INSTANCE.fromJsonObject(asJsonObject2);
                    JsonElement jsonElement6 = jsonObject.get("fbc");
                    if (jsonElement6 != null && (asJsonObject = jsonElement6.getAsJsonObject()) != null) {
                        fbcFromJsonObject = Fbc.INSTANCE.fromJsonObject(asJsonObject);
                    }
                    return new Performance(performanceClsFromJsonObject, fcpFromJsonObject, fidFromJsonObject, inpFromJsonObject, lcpFromJsonObject, fbcFromJsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Performance", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Performance", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Performance", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\bI\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 S2\u00020\u0001:\u0001SB\u008d\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u001aJ\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010@\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010A\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010C\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010G\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010H\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0096\u0002\u0010J\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010KJ\u0013\u0010L\u001a\u00020\u00052\b\u0010M\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010N\u001a\u00020OHÖ\u0001J\u0006\u0010P\u001a\u00020QJ\t\u0010R\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001cR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001f\u0010\u001cR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b \u0010\u001cR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b!\u0010\u001cR\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\"\u0010\u001cR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b#\u0010\u001cR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b$\u0010\u001cR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b%\u0010\u001cR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b&\u0010\u001cR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b'\u0010\u001cR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b(\u0010\u001cR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b)\u0010\u001cR\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b*\u0010\u001cR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b+\u0010\u001cR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b,\u0010\u001cR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b-\u0010\u001cR\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b.\u0010\u001cR\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b/\u0010\u001cR\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b0\u0010\u001cR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b3\u0010\u001c¨\u0006T"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Accessibility;", "", "textSize", "", "screenReaderEnabled", "", "boldTextEnabled", "reduceTransparencyEnabled", "reduceMotionEnabled", "buttonShapesEnabled", "invertColorsEnabled", "increaseContrastEnabled", "assistiveSwitchEnabled", "assistiveTouchEnabled", "videoAutoplayEnabled", "closedCaptioningEnabled", "monoAudioEnabled", "shakeToUndoEnabled", "reducedAnimationsEnabled", "shouldDifferentiateWithoutColor", "grayscaleEnabled", "singleAppModeEnabled", "onOffSwitchLabelsEnabled", "speakScreenEnabled", "speakSelectionEnabled", "rtlEnabled", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getAssistiveSwitchEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAssistiveTouchEnabled", "getBoldTextEnabled", "getButtonShapesEnabled", "getClosedCaptioningEnabled", "getGrayscaleEnabled", "getIncreaseContrastEnabled", "getInvertColorsEnabled", "getMonoAudioEnabled", "getOnOffSwitchLabelsEnabled", "getReduceMotionEnabled", "getReduceTransparencyEnabled", "getReducedAnimationsEnabled", "getRtlEnabled", "getScreenReaderEnabled", "getShakeToUndoEnabled", "getShouldDifferentiateWithoutColor", "getSingleAppModeEnabled", "getSpeakScreenEnabled", "getSpeakSelectionEnabled", "getTextSize", "()Ljava/lang/String;", "getVideoAutoplayEnabled", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/datadog/android/rum/model/ViewEvent$Accessibility;", "equals", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Accessibility {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Boolean assistiveSwitchEnabled;
        private final Boolean assistiveTouchEnabled;
        private final Boolean boldTextEnabled;
        private final Boolean buttonShapesEnabled;
        private final Boolean closedCaptioningEnabled;
        private final Boolean grayscaleEnabled;
        private final Boolean increaseContrastEnabled;
        private final Boolean invertColorsEnabled;
        private final Boolean monoAudioEnabled;
        private final Boolean onOffSwitchLabelsEnabled;
        private final Boolean reduceMotionEnabled;
        private final Boolean reduceTransparencyEnabled;
        private final Boolean reducedAnimationsEnabled;
        private final Boolean rtlEnabled;
        private final Boolean screenReaderEnabled;
        private final Boolean shakeToUndoEnabled;
        private final Boolean shouldDifferentiateWithoutColor;
        private final Boolean singleAppModeEnabled;
        private final Boolean speakScreenEnabled;
        private final Boolean speakSelectionEnabled;
        private final String textSize;
        private final Boolean videoAutoplayEnabled;

        public Accessibility() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null);
        }

        public static /* synthetic */ Accessibility copy$default(Accessibility accessibility, String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, Boolean bool12, Boolean bool13, Boolean bool14, Boolean bool15, Boolean bool16, Boolean bool17, Boolean bool18, Boolean bool19, Boolean bool20, Boolean bool21, int i, Object obj) {
            Boolean bool22;
            Boolean bool23;
            String str2 = (i & 1) != 0 ? accessibility.textSize : str;
            Boolean bool24 = (i & 2) != 0 ? accessibility.screenReaderEnabled : bool;
            Boolean bool25 = (i & 4) != 0 ? accessibility.boldTextEnabled : bool2;
            Boolean bool26 = (i & 8) != 0 ? accessibility.reduceTransparencyEnabled : bool3;
            Boolean bool27 = (i & 16) != 0 ? accessibility.reduceMotionEnabled : bool4;
            Boolean bool28 = (i & 32) != 0 ? accessibility.buttonShapesEnabled : bool5;
            Boolean bool29 = (i & 64) != 0 ? accessibility.invertColorsEnabled : bool6;
            Boolean bool30 = (i & 128) != 0 ? accessibility.increaseContrastEnabled : bool7;
            Boolean bool31 = (i & 256) != 0 ? accessibility.assistiveSwitchEnabled : bool8;
            Boolean bool32 = (i & 512) != 0 ? accessibility.assistiveTouchEnabled : bool9;
            Boolean bool33 = (i & 1024) != 0 ? accessibility.videoAutoplayEnabled : bool10;
            Boolean bool34 = (i & 2048) != 0 ? accessibility.closedCaptioningEnabled : bool11;
            Boolean bool35 = (i & 4096) != 0 ? accessibility.monoAudioEnabled : bool12;
            Boolean bool36 = (i & 8192) != 0 ? accessibility.shakeToUndoEnabled : bool13;
            String str3 = str2;
            Boolean bool37 = (i & 16384) != 0 ? accessibility.reducedAnimationsEnabled : bool14;
            Boolean bool38 = (i & 32768) != 0 ? accessibility.shouldDifferentiateWithoutColor : bool15;
            Boolean bool39 = (i & 65536) != 0 ? accessibility.grayscaleEnabled : bool16;
            Boolean bool40 = (i & 131072) != 0 ? accessibility.singleAppModeEnabled : bool17;
            Boolean bool41 = (i & 262144) != 0 ? accessibility.onOffSwitchLabelsEnabled : bool18;
            Boolean bool42 = (i & 524288) != 0 ? accessibility.speakScreenEnabled : bool19;
            Boolean bool43 = (i & 1048576) != 0 ? accessibility.speakSelectionEnabled : bool20;
            if ((i & 2097152) != 0) {
                bool23 = bool43;
                bool22 = accessibility.rtlEnabled;
            } else {
                bool22 = bool21;
                bool23 = bool43;
            }
            return accessibility.copy(str3, bool24, bool25, bool26, bool27, bool28, bool29, bool30, bool31, bool32, bool33, bool34, bool35, bool36, bool37, bool38, bool39, bool40, bool41, bool42, bool23, bool22);
        }

        @JvmStatic
        public static final Accessibility fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Accessibility fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTextSize() {
            return this.textSize;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Boolean getAssistiveTouchEnabled() {
            return this.assistiveTouchEnabled;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Boolean getVideoAutoplayEnabled() {
            return this.videoAutoplayEnabled;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final Boolean getClosedCaptioningEnabled() {
            return this.closedCaptioningEnabled;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final Boolean getMonoAudioEnabled() {
            return this.monoAudioEnabled;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final Boolean getShakeToUndoEnabled() {
            return this.shakeToUndoEnabled;
        }

        /* JADX INFO: renamed from: component15, reason: from getter */
        public final Boolean getReducedAnimationsEnabled() {
            return this.reducedAnimationsEnabled;
        }

        /* JADX INFO: renamed from: component16, reason: from getter */
        public final Boolean getShouldDifferentiateWithoutColor() {
            return this.shouldDifferentiateWithoutColor;
        }

        /* JADX INFO: renamed from: component17, reason: from getter */
        public final Boolean getGrayscaleEnabled() {
            return this.grayscaleEnabled;
        }

        /* JADX INFO: renamed from: component18, reason: from getter */
        public final Boolean getSingleAppModeEnabled() {
            return this.singleAppModeEnabled;
        }

        /* JADX INFO: renamed from: component19, reason: from getter */
        public final Boolean getOnOffSwitchLabelsEnabled() {
            return this.onOffSwitchLabelsEnabled;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Boolean getScreenReaderEnabled() {
            return this.screenReaderEnabled;
        }

        /* JADX INFO: renamed from: component20, reason: from getter */
        public final Boolean getSpeakScreenEnabled() {
            return this.speakScreenEnabled;
        }

        /* JADX INFO: renamed from: component21, reason: from getter */
        public final Boolean getSpeakSelectionEnabled() {
            return this.speakSelectionEnabled;
        }

        /* JADX INFO: renamed from: component22, reason: from getter */
        public final Boolean getRtlEnabled() {
            return this.rtlEnabled;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Boolean getBoldTextEnabled() {
            return this.boldTextEnabled;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Boolean getReduceTransparencyEnabled() {
            return this.reduceTransparencyEnabled;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Boolean getReduceMotionEnabled() {
            return this.reduceMotionEnabled;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Boolean getButtonShapesEnabled() {
            return this.buttonShapesEnabled;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Boolean getInvertColorsEnabled() {
            return this.invertColorsEnabled;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Boolean getIncreaseContrastEnabled() {
            return this.increaseContrastEnabled;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Boolean getAssistiveSwitchEnabled() {
            return this.assistiveSwitchEnabled;
        }

        public final Accessibility copy(String textSize, Boolean screenReaderEnabled, Boolean boldTextEnabled, Boolean reduceTransparencyEnabled, Boolean reduceMotionEnabled, Boolean buttonShapesEnabled, Boolean invertColorsEnabled, Boolean increaseContrastEnabled, Boolean assistiveSwitchEnabled, Boolean assistiveTouchEnabled, Boolean videoAutoplayEnabled, Boolean closedCaptioningEnabled, Boolean monoAudioEnabled, Boolean shakeToUndoEnabled, Boolean reducedAnimationsEnabled, Boolean shouldDifferentiateWithoutColor, Boolean grayscaleEnabled, Boolean singleAppModeEnabled, Boolean onOffSwitchLabelsEnabled, Boolean speakScreenEnabled, Boolean speakSelectionEnabled, Boolean rtlEnabled) {
            return new Accessibility(textSize, screenReaderEnabled, boldTextEnabled, reduceTransparencyEnabled, reduceMotionEnabled, buttonShapesEnabled, invertColorsEnabled, increaseContrastEnabled, assistiveSwitchEnabled, assistiveTouchEnabled, videoAutoplayEnabled, closedCaptioningEnabled, monoAudioEnabled, shakeToUndoEnabled, reducedAnimationsEnabled, shouldDifferentiateWithoutColor, grayscaleEnabled, singleAppModeEnabled, onOffSwitchLabelsEnabled, speakScreenEnabled, speakSelectionEnabled, rtlEnabled);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Accessibility)) {
                return false;
            }
            Accessibility accessibility = (Accessibility) other;
            return Intrinsics.areEqual(this.textSize, accessibility.textSize) && Intrinsics.areEqual(this.screenReaderEnabled, accessibility.screenReaderEnabled) && Intrinsics.areEqual(this.boldTextEnabled, accessibility.boldTextEnabled) && Intrinsics.areEqual(this.reduceTransparencyEnabled, accessibility.reduceTransparencyEnabled) && Intrinsics.areEqual(this.reduceMotionEnabled, accessibility.reduceMotionEnabled) && Intrinsics.areEqual(this.buttonShapesEnabled, accessibility.buttonShapesEnabled) && Intrinsics.areEqual(this.invertColorsEnabled, accessibility.invertColorsEnabled) && Intrinsics.areEqual(this.increaseContrastEnabled, accessibility.increaseContrastEnabled) && Intrinsics.areEqual(this.assistiveSwitchEnabled, accessibility.assistiveSwitchEnabled) && Intrinsics.areEqual(this.assistiveTouchEnabled, accessibility.assistiveTouchEnabled) && Intrinsics.areEqual(this.videoAutoplayEnabled, accessibility.videoAutoplayEnabled) && Intrinsics.areEqual(this.closedCaptioningEnabled, accessibility.closedCaptioningEnabled) && Intrinsics.areEqual(this.monoAudioEnabled, accessibility.monoAudioEnabled) && Intrinsics.areEqual(this.shakeToUndoEnabled, accessibility.shakeToUndoEnabled) && Intrinsics.areEqual(this.reducedAnimationsEnabled, accessibility.reducedAnimationsEnabled) && Intrinsics.areEqual(this.shouldDifferentiateWithoutColor, accessibility.shouldDifferentiateWithoutColor) && Intrinsics.areEqual(this.grayscaleEnabled, accessibility.grayscaleEnabled) && Intrinsics.areEqual(this.singleAppModeEnabled, accessibility.singleAppModeEnabled) && Intrinsics.areEqual(this.onOffSwitchLabelsEnabled, accessibility.onOffSwitchLabelsEnabled) && Intrinsics.areEqual(this.speakScreenEnabled, accessibility.speakScreenEnabled) && Intrinsics.areEqual(this.speakSelectionEnabled, accessibility.speakSelectionEnabled) && Intrinsics.areEqual(this.rtlEnabled, accessibility.rtlEnabled);
        }

        public int hashCode() {
            String str = this.textSize;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            Boolean bool = this.screenReaderEnabled;
            int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.boldTextEnabled;
            int iHashCode3 = (iHashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.reduceTransparencyEnabled;
            int iHashCode4 = (iHashCode3 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
            Boolean bool4 = this.reduceMotionEnabled;
            int iHashCode5 = (iHashCode4 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
            Boolean bool5 = this.buttonShapesEnabled;
            int iHashCode6 = (iHashCode5 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
            Boolean bool6 = this.invertColorsEnabled;
            int iHashCode7 = (iHashCode6 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
            Boolean bool7 = this.increaseContrastEnabled;
            int iHashCode8 = (iHashCode7 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
            Boolean bool8 = this.assistiveSwitchEnabled;
            int iHashCode9 = (iHashCode8 + (bool8 == null ? 0 : bool8.hashCode())) * 31;
            Boolean bool9 = this.assistiveTouchEnabled;
            int iHashCode10 = (iHashCode9 + (bool9 == null ? 0 : bool9.hashCode())) * 31;
            Boolean bool10 = this.videoAutoplayEnabled;
            int iHashCode11 = (iHashCode10 + (bool10 == null ? 0 : bool10.hashCode())) * 31;
            Boolean bool11 = this.closedCaptioningEnabled;
            int iHashCode12 = (iHashCode11 + (bool11 == null ? 0 : bool11.hashCode())) * 31;
            Boolean bool12 = this.monoAudioEnabled;
            int iHashCode13 = (iHashCode12 + (bool12 == null ? 0 : bool12.hashCode())) * 31;
            Boolean bool13 = this.shakeToUndoEnabled;
            int iHashCode14 = (iHashCode13 + (bool13 == null ? 0 : bool13.hashCode())) * 31;
            Boolean bool14 = this.reducedAnimationsEnabled;
            int iHashCode15 = (iHashCode14 + (bool14 == null ? 0 : bool14.hashCode())) * 31;
            Boolean bool15 = this.shouldDifferentiateWithoutColor;
            int iHashCode16 = (iHashCode15 + (bool15 == null ? 0 : bool15.hashCode())) * 31;
            Boolean bool16 = this.grayscaleEnabled;
            int iHashCode17 = (iHashCode16 + (bool16 == null ? 0 : bool16.hashCode())) * 31;
            Boolean bool17 = this.singleAppModeEnabled;
            int iHashCode18 = (iHashCode17 + (bool17 == null ? 0 : bool17.hashCode())) * 31;
            Boolean bool18 = this.onOffSwitchLabelsEnabled;
            int iHashCode19 = (iHashCode18 + (bool18 == null ? 0 : bool18.hashCode())) * 31;
            Boolean bool19 = this.speakScreenEnabled;
            int iHashCode20 = (iHashCode19 + (bool19 == null ? 0 : bool19.hashCode())) * 31;
            Boolean bool20 = this.speakSelectionEnabled;
            int iHashCode21 = (iHashCode20 + (bool20 == null ? 0 : bool20.hashCode())) * 31;
            Boolean bool21 = this.rtlEnabled;
            return iHashCode21 + (bool21 != null ? bool21.hashCode() : 0);
        }

        public String toString() {
            return "Accessibility(textSize=" + this.textSize + ", screenReaderEnabled=" + this.screenReaderEnabled + ", boldTextEnabled=" + this.boldTextEnabled + ", reduceTransparencyEnabled=" + this.reduceTransparencyEnabled + ", reduceMotionEnabled=" + this.reduceMotionEnabled + ", buttonShapesEnabled=" + this.buttonShapesEnabled + ", invertColorsEnabled=" + this.invertColorsEnabled + ", increaseContrastEnabled=" + this.increaseContrastEnabled + ", assistiveSwitchEnabled=" + this.assistiveSwitchEnabled + ", assistiveTouchEnabled=" + this.assistiveTouchEnabled + ", videoAutoplayEnabled=" + this.videoAutoplayEnabled + ", closedCaptioningEnabled=" + this.closedCaptioningEnabled + ", monoAudioEnabled=" + this.monoAudioEnabled + ", shakeToUndoEnabled=" + this.shakeToUndoEnabled + ", reducedAnimationsEnabled=" + this.reducedAnimationsEnabled + ", shouldDifferentiateWithoutColor=" + this.shouldDifferentiateWithoutColor + ", grayscaleEnabled=" + this.grayscaleEnabled + ", singleAppModeEnabled=" + this.singleAppModeEnabled + ", onOffSwitchLabelsEnabled=" + this.onOffSwitchLabelsEnabled + ", speakScreenEnabled=" + this.speakScreenEnabled + ", speakSelectionEnabled=" + this.speakSelectionEnabled + ", rtlEnabled=" + this.rtlEnabled + ")";
        }

        public Accessibility(String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, Boolean bool12, Boolean bool13, Boolean bool14, Boolean bool15, Boolean bool16, Boolean bool17, Boolean bool18, Boolean bool19, Boolean bool20, Boolean bool21) {
            this.textSize = str;
            this.screenReaderEnabled = bool;
            this.boldTextEnabled = bool2;
            this.reduceTransparencyEnabled = bool3;
            this.reduceMotionEnabled = bool4;
            this.buttonShapesEnabled = bool5;
            this.invertColorsEnabled = bool6;
            this.increaseContrastEnabled = bool7;
            this.assistiveSwitchEnabled = bool8;
            this.assistiveTouchEnabled = bool9;
            this.videoAutoplayEnabled = bool10;
            this.closedCaptioningEnabled = bool11;
            this.monoAudioEnabled = bool12;
            this.shakeToUndoEnabled = bool13;
            this.reducedAnimationsEnabled = bool14;
            this.shouldDifferentiateWithoutColor = bool15;
            this.grayscaleEnabled = bool16;
            this.singleAppModeEnabled = bool17;
            this.onOffSwitchLabelsEnabled = bool18;
            this.speakScreenEnabled = bool19;
            this.speakSelectionEnabled = bool20;
            this.rtlEnabled = bool21;
        }

        public /* synthetic */ Accessibility(String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, Boolean bool12, Boolean bool13, Boolean bool14, Boolean bool15, Boolean bool16, Boolean bool17, Boolean bool18, Boolean bool19, Boolean bool20, Boolean bool21, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : bool2, (i & 8) != 0 ? null : bool3, (i & 16) != 0 ? null : bool4, (i & 32) != 0 ? null : bool5, (i & 64) != 0 ? null : bool6, (i & 128) != 0 ? null : bool7, (i & 256) != 0 ? null : bool8, (i & 512) != 0 ? null : bool9, (i & 1024) != 0 ? null : bool10, (i & 2048) != 0 ? null : bool11, (i & 4096) != 0 ? null : bool12, (i & 8192) != 0 ? null : bool13, (i & 16384) != 0 ? null : bool14, (i & 32768) != 0 ? null : bool15, (i & 65536) != 0 ? null : bool16, (i & 131072) != 0 ? null : bool17, (i & 262144) != 0 ? null : bool18, (i & 524288) != 0 ? null : bool19, (i & 1048576) != 0 ? null : bool20, (i & 2097152) != 0 ? null : bool21);
        }

        public final String getTextSize() {
            return this.textSize;
        }

        public final Boolean getScreenReaderEnabled() {
            return this.screenReaderEnabled;
        }

        public final Boolean getBoldTextEnabled() {
            return this.boldTextEnabled;
        }

        public final Boolean getReduceTransparencyEnabled() {
            return this.reduceTransparencyEnabled;
        }

        public final Boolean getReduceMotionEnabled() {
            return this.reduceMotionEnabled;
        }

        public final Boolean getButtonShapesEnabled() {
            return this.buttonShapesEnabled;
        }

        public final Boolean getInvertColorsEnabled() {
            return this.invertColorsEnabled;
        }

        public final Boolean getIncreaseContrastEnabled() {
            return this.increaseContrastEnabled;
        }

        public final Boolean getAssistiveSwitchEnabled() {
            return this.assistiveSwitchEnabled;
        }

        public final Boolean getAssistiveTouchEnabled() {
            return this.assistiveTouchEnabled;
        }

        public final Boolean getVideoAutoplayEnabled() {
            return this.videoAutoplayEnabled;
        }

        public final Boolean getClosedCaptioningEnabled() {
            return this.closedCaptioningEnabled;
        }

        public final Boolean getMonoAudioEnabled() {
            return this.monoAudioEnabled;
        }

        public final Boolean getShakeToUndoEnabled() {
            return this.shakeToUndoEnabled;
        }

        public final Boolean getReducedAnimationsEnabled() {
            return this.reducedAnimationsEnabled;
        }

        public final Boolean getShouldDifferentiateWithoutColor() {
            return this.shouldDifferentiateWithoutColor;
        }

        public final Boolean getGrayscaleEnabled() {
            return this.grayscaleEnabled;
        }

        public final Boolean getSingleAppModeEnabled() {
            return this.singleAppModeEnabled;
        }

        public final Boolean getOnOffSwitchLabelsEnabled() {
            return this.onOffSwitchLabelsEnabled;
        }

        public final Boolean getSpeakScreenEnabled() {
            return this.speakScreenEnabled;
        }

        public final Boolean getSpeakSelectionEnabled() {
            return this.speakSelectionEnabled;
        }

        public final Boolean getRtlEnabled() {
            return this.rtlEnabled;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            String str = this.textSize;
            if (str != null) {
                jsonObject.addProperty("text_size", str);
            }
            Boolean bool = this.screenReaderEnabled;
            if (bool != null) {
                bool.booleanValue();
                jsonObject.addProperty("screen_reader_enabled", bool);
            }
            Boolean bool2 = this.boldTextEnabled;
            if (bool2 != null) {
                bool2.booleanValue();
                jsonObject.addProperty("bold_text_enabled", bool2);
            }
            Boolean bool3 = this.reduceTransparencyEnabled;
            if (bool3 != null) {
                bool3.booleanValue();
                jsonObject.addProperty("reduce_transparency_enabled", bool3);
            }
            Boolean bool4 = this.reduceMotionEnabled;
            if (bool4 != null) {
                bool4.booleanValue();
                jsonObject.addProperty("reduce_motion_enabled", bool4);
            }
            Boolean bool5 = this.buttonShapesEnabled;
            if (bool5 != null) {
                bool5.booleanValue();
                jsonObject.addProperty("button_shapes_enabled", bool5);
            }
            Boolean bool6 = this.invertColorsEnabled;
            if (bool6 != null) {
                bool6.booleanValue();
                jsonObject.addProperty("invert_colors_enabled", bool6);
            }
            Boolean bool7 = this.increaseContrastEnabled;
            if (bool7 != null) {
                bool7.booleanValue();
                jsonObject.addProperty("increase_contrast_enabled", bool7);
            }
            Boolean bool8 = this.assistiveSwitchEnabled;
            if (bool8 != null) {
                bool8.booleanValue();
                jsonObject.addProperty("assistive_switch_enabled", bool8);
            }
            Boolean bool9 = this.assistiveTouchEnabled;
            if (bool9 != null) {
                bool9.booleanValue();
                jsonObject.addProperty("assistive_touch_enabled", bool9);
            }
            Boolean bool10 = this.videoAutoplayEnabled;
            if (bool10 != null) {
                bool10.booleanValue();
                jsonObject.addProperty("video_autoplay_enabled", bool10);
            }
            Boolean bool11 = this.closedCaptioningEnabled;
            if (bool11 != null) {
                bool11.booleanValue();
                jsonObject.addProperty("closed_captioning_enabled", bool11);
            }
            Boolean bool12 = this.monoAudioEnabled;
            if (bool12 != null) {
                bool12.booleanValue();
                jsonObject.addProperty("mono_audio_enabled", bool12);
            }
            Boolean bool13 = this.shakeToUndoEnabled;
            if (bool13 != null) {
                bool13.booleanValue();
                jsonObject.addProperty("shake_to_undo_enabled", bool13);
            }
            Boolean bool14 = this.reducedAnimationsEnabled;
            if (bool14 != null) {
                bool14.booleanValue();
                jsonObject.addProperty("reduced_animations_enabled", bool14);
            }
            Boolean bool15 = this.shouldDifferentiateWithoutColor;
            if (bool15 != null) {
                bool15.booleanValue();
                jsonObject.addProperty("should_differentiate_without_color", bool15);
            }
            Boolean bool16 = this.grayscaleEnabled;
            if (bool16 != null) {
                bool16.booleanValue();
                jsonObject.addProperty("grayscale_enabled", bool16);
            }
            Boolean bool17 = this.singleAppModeEnabled;
            if (bool17 != null) {
                bool17.booleanValue();
                jsonObject.addProperty("single_app_mode_enabled", bool17);
            }
            Boolean bool18 = this.onOffSwitchLabelsEnabled;
            if (bool18 != null) {
                bool18.booleanValue();
                jsonObject.addProperty("on_off_switch_labels_enabled", bool18);
            }
            Boolean bool19 = this.speakScreenEnabled;
            if (bool19 != null) {
                bool19.booleanValue();
                jsonObject.addProperty("speak_screen_enabled", bool19);
            }
            Boolean bool20 = this.speakSelectionEnabled;
            if (bool20 != null) {
                bool20.booleanValue();
                jsonObject.addProperty("speak_selection_enabled", bool20);
            }
            Boolean bool21 = this.rtlEnabled;
            if (bool21 != null) {
                bool21.booleanValue();
                jsonObject.addProperty("rtl_enabled", bool21);
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Accessibility$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$Accessibility;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Accessibility fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Accessibility", e);
                }
            }

            @JvmStatic
            public final Accessibility fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get("text_size");
                    String asString = jsonElement != null ? jsonElement.getAsString() : null;
                    JsonElement jsonElement2 = jsonObject.get("screen_reader_enabled");
                    Boolean boolValueOf = jsonElement2 != null ? Boolean.valueOf(jsonElement2.getAsBoolean()) : null;
                    JsonElement jsonElement3 = jsonObject.get("bold_text_enabled");
                    Boolean boolValueOf2 = jsonElement3 != null ? Boolean.valueOf(jsonElement3.getAsBoolean()) : null;
                    JsonElement jsonElement4 = jsonObject.get("reduce_transparency_enabled");
                    Boolean boolValueOf3 = jsonElement4 != null ? Boolean.valueOf(jsonElement4.getAsBoolean()) : null;
                    JsonElement jsonElement5 = jsonObject.get("reduce_motion_enabled");
                    Boolean boolValueOf4 = jsonElement5 != null ? Boolean.valueOf(jsonElement5.getAsBoolean()) : null;
                    JsonElement jsonElement6 = jsonObject.get("button_shapes_enabled");
                    Boolean boolValueOf5 = jsonElement6 != null ? Boolean.valueOf(jsonElement6.getAsBoolean()) : null;
                    JsonElement jsonElement7 = jsonObject.get("invert_colors_enabled");
                    Boolean boolValueOf6 = jsonElement7 != null ? Boolean.valueOf(jsonElement7.getAsBoolean()) : null;
                    JsonElement jsonElement8 = jsonObject.get("increase_contrast_enabled");
                    Boolean boolValueOf7 = jsonElement8 != null ? Boolean.valueOf(jsonElement8.getAsBoolean()) : null;
                    JsonElement jsonElement9 = jsonObject.get("assistive_switch_enabled");
                    Boolean boolValueOf8 = jsonElement9 != null ? Boolean.valueOf(jsonElement9.getAsBoolean()) : null;
                    JsonElement jsonElement10 = jsonObject.get("assistive_touch_enabled");
                    Boolean boolValueOf9 = jsonElement10 != null ? Boolean.valueOf(jsonElement10.getAsBoolean()) : null;
                    JsonElement jsonElement11 = jsonObject.get("video_autoplay_enabled");
                    Boolean boolValueOf10 = jsonElement11 != null ? Boolean.valueOf(jsonElement11.getAsBoolean()) : null;
                    JsonElement jsonElement12 = jsonObject.get("closed_captioning_enabled");
                    Boolean boolValueOf11 = jsonElement12 != null ? Boolean.valueOf(jsonElement12.getAsBoolean()) : null;
                    JsonElement jsonElement13 = jsonObject.get("mono_audio_enabled");
                    Boolean boolValueOf12 = jsonElement13 != null ? Boolean.valueOf(jsonElement13.getAsBoolean()) : null;
                    JsonElement jsonElement14 = jsonObject.get("shake_to_undo_enabled");
                    Boolean boolValueOf13 = jsonElement14 != null ? Boolean.valueOf(jsonElement14.getAsBoolean()) : null;
                    JsonElement jsonElement15 = jsonObject.get("reduced_animations_enabled");
                    Boolean boolValueOf14 = jsonElement15 != null ? Boolean.valueOf(jsonElement15.getAsBoolean()) : null;
                    JsonElement jsonElement16 = jsonObject.get("should_differentiate_without_color");
                    Boolean boolValueOf15 = jsonElement16 != null ? Boolean.valueOf(jsonElement16.getAsBoolean()) : null;
                    JsonElement jsonElement17 = jsonObject.get("grayscale_enabled");
                    Boolean boolValueOf16 = jsonElement17 != null ? Boolean.valueOf(jsonElement17.getAsBoolean()) : null;
                    JsonElement jsonElement18 = jsonObject.get("single_app_mode_enabled");
                    Boolean boolValueOf17 = jsonElement18 != null ? Boolean.valueOf(jsonElement18.getAsBoolean()) : null;
                    JsonElement jsonElement19 = jsonObject.get("on_off_switch_labels_enabled");
                    Boolean boolValueOf18 = jsonElement19 != null ? Boolean.valueOf(jsonElement19.getAsBoolean()) : null;
                    JsonElement jsonElement20 = jsonObject.get("speak_screen_enabled");
                    Boolean boolValueOf19 = jsonElement20 != null ? Boolean.valueOf(jsonElement20.getAsBoolean()) : null;
                    JsonElement jsonElement21 = jsonObject.get("speak_selection_enabled");
                    Boolean boolValueOf20 = jsonElement21 != null ? Boolean.valueOf(jsonElement21.getAsBoolean()) : null;
                    JsonElement jsonElement22 = jsonObject.get("rtl_enabled");
                    return new Accessibility(asString, boolValueOf, boolValueOf2, boolValueOf3, boolValueOf4, boolValueOf5, boolValueOf6, boolValueOf7, boolValueOf8, boolValueOf9, boolValueOf10, boolValueOf11, boolValueOf12, boolValueOf13, boolValueOf14, boolValueOf15, boolValueOf16, boolValueOf17, boolValueOf18, boolValueOf19, boolValueOf20, jsonElement22 != null ? Boolean.valueOf(jsonElement22.getAsBoolean()) : null);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Accessibility", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Accessibility", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Accessibility", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Cellular;", "", "technology", "", "carrierName", "(Ljava/lang/String;Ljava/lang/String;)V", "getCarrierName", "()Ljava/lang/String;", "getTechnology", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Cellular {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String carrierName;
        private final String technology;

        /* JADX WARN: Multi-variable type inference failed */
        public Cellular() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Cellular copy$default(Cellular cellular, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cellular.technology;
            }
            if ((i & 2) != 0) {
                str2 = cellular.carrierName;
            }
            return cellular.copy(str, str2);
        }

        @JvmStatic
        public static final Cellular fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Cellular fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTechnology() {
            return this.technology;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getCarrierName() {
            return this.carrierName;
        }

        public final Cellular copy(String technology, String carrierName) {
            return new Cellular(technology, carrierName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Cellular)) {
                return false;
            }
            Cellular cellular = (Cellular) other;
            return Intrinsics.areEqual(this.technology, cellular.technology) && Intrinsics.areEqual(this.carrierName, cellular.carrierName);
        }

        public int hashCode() {
            String str = this.technology;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.carrierName;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Cellular(technology=" + this.technology + ", carrierName=" + this.carrierName + ")";
        }

        public Cellular(String str, String str2) {
            this.technology = str;
            this.carrierName = str2;
        }

        public /* synthetic */ Cellular(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        public final String getTechnology() {
            return this.technology;
        }

        public final String getCarrierName() {
            return this.carrierName;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            String str = this.technology;
            if (str != null) {
                jsonObject.addProperty("technology", str);
            }
            String str2 = this.carrierName;
            if (str2 != null) {
                jsonObject.addProperty("carrier_name", str2);
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Cellular$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$Cellular;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Cellular fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Cellular", e);
                }
            }

            @JvmStatic
            public final Cellular fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get("technology");
                    String asString = jsonElement != null ? jsonElement.getAsString() : null;
                    JsonElement jsonElement2 = jsonObject.get("carrier_name");
                    return new Cellular(asString, jsonElement2 != null ? jsonElement2.getAsString() : null);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Cellular", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Cellular", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Cellular", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0004\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Viewport;", "", ViewProps.WIDTH, "", ViewProps.HEIGHT, "(Ljava/lang/Number;Ljava/lang/Number;)V", "getHeight", "()Ljava/lang/Number;", "getWidth", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Viewport {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Number height;
        private final Number width;

        public static /* synthetic */ Viewport copy$default(Viewport viewport, Number number, Number number2, int i, Object obj) {
            if ((i & 1) != 0) {
                number = viewport.width;
            }
            if ((i & 2) != 0) {
                number2 = viewport.height;
            }
            return viewport.copy(number, number2);
        }

        @JvmStatic
        public static final Viewport fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Viewport fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Number getWidth() {
            return this.width;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Number getHeight() {
            return this.height;
        }

        public final Viewport copy(Number width, Number height) {
            Intrinsics.checkNotNullParameter(width, "width");
            Intrinsics.checkNotNullParameter(height, "height");
            return new Viewport(width, height);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Viewport)) {
                return false;
            }
            Viewport viewport = (Viewport) other;
            return Intrinsics.areEqual(this.width, viewport.width) && Intrinsics.areEqual(this.height, viewport.height);
        }

        public int hashCode() {
            return (this.width.hashCode() * 31) + this.height.hashCode();
        }

        public String toString() {
            return "Viewport(width=" + this.width + ", height=" + this.height + ")";
        }

        public Viewport(Number width, Number height) {
            Intrinsics.checkNotNullParameter(width, "width");
            Intrinsics.checkNotNullParameter(height, "height");
            this.width = width;
            this.height = height;
        }

        public final Number getWidth() {
            return this.width;
        }

        public final Number getHeight() {
            return this.height;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(ViewProps.WIDTH, this.width);
            jsonObject.addProperty(ViewProps.HEIGHT, this.height);
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Viewport$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$Viewport;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Viewport fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Viewport", e);
                }
            }

            @JvmStatic
            public final Viewport fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    Number width = jsonObject.get(ViewProps.WIDTH).getAsNumber();
                    Number height = jsonObject.get(ViewProps.HEIGHT).getAsNumber();
                    Intrinsics.checkNotNullExpressionValue(width, "width");
                    Intrinsics.checkNotNullExpressionValue(height, "height");
                    return new Viewport(width, height);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Viewport", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Viewport", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Viewport", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0006\u0010\u0017\u001a\u00020\u0018J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Scroll;", "", "maxDepth", "", "maxDepthScrollTop", "maxScrollHeight", "maxScrollHeightTime", "(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)V", "getMaxDepth", "()Ljava/lang/Number;", "getMaxDepthScrollTop", "getMaxScrollHeight", "getMaxScrollHeightTime", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Scroll {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Number maxDepth;
        private final Number maxDepthScrollTop;
        private final Number maxScrollHeight;
        private final Number maxScrollHeightTime;

        public static /* synthetic */ Scroll copy$default(Scroll scroll, Number number, Number number2, Number number3, Number number4, int i, Object obj) {
            if ((i & 1) != 0) {
                number = scroll.maxDepth;
            }
            if ((i & 2) != 0) {
                number2 = scroll.maxDepthScrollTop;
            }
            if ((i & 4) != 0) {
                number3 = scroll.maxScrollHeight;
            }
            if ((i & 8) != 0) {
                number4 = scroll.maxScrollHeightTime;
            }
            return scroll.copy(number, number2, number3, number4);
        }

        @JvmStatic
        public static final Scroll fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Scroll fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Number getMaxDepth() {
            return this.maxDepth;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Number getMaxDepthScrollTop() {
            return this.maxDepthScrollTop;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Number getMaxScrollHeight() {
            return this.maxScrollHeight;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Number getMaxScrollHeightTime() {
            return this.maxScrollHeightTime;
        }

        public final Scroll copy(Number maxDepth, Number maxDepthScrollTop, Number maxScrollHeight, Number maxScrollHeightTime) {
            Intrinsics.checkNotNullParameter(maxDepth, "maxDepth");
            Intrinsics.checkNotNullParameter(maxDepthScrollTop, "maxDepthScrollTop");
            Intrinsics.checkNotNullParameter(maxScrollHeight, "maxScrollHeight");
            Intrinsics.checkNotNullParameter(maxScrollHeightTime, "maxScrollHeightTime");
            return new Scroll(maxDepth, maxDepthScrollTop, maxScrollHeight, maxScrollHeightTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Scroll)) {
                return false;
            }
            Scroll scroll = (Scroll) other;
            return Intrinsics.areEqual(this.maxDepth, scroll.maxDepth) && Intrinsics.areEqual(this.maxDepthScrollTop, scroll.maxDepthScrollTop) && Intrinsics.areEqual(this.maxScrollHeight, scroll.maxScrollHeight) && Intrinsics.areEqual(this.maxScrollHeightTime, scroll.maxScrollHeightTime);
        }

        public int hashCode() {
            return (((((this.maxDepth.hashCode() * 31) + this.maxDepthScrollTop.hashCode()) * 31) + this.maxScrollHeight.hashCode()) * 31) + this.maxScrollHeightTime.hashCode();
        }

        public String toString() {
            return "Scroll(maxDepth=" + this.maxDepth + ", maxDepthScrollTop=" + this.maxDepthScrollTop + ", maxScrollHeight=" + this.maxScrollHeight + ", maxScrollHeightTime=" + this.maxScrollHeightTime + ")";
        }

        public Scroll(Number maxDepth, Number maxDepthScrollTop, Number maxScrollHeight, Number maxScrollHeightTime) {
            Intrinsics.checkNotNullParameter(maxDepth, "maxDepth");
            Intrinsics.checkNotNullParameter(maxDepthScrollTop, "maxDepthScrollTop");
            Intrinsics.checkNotNullParameter(maxScrollHeight, "maxScrollHeight");
            Intrinsics.checkNotNullParameter(maxScrollHeightTime, "maxScrollHeightTime");
            this.maxDepth = maxDepth;
            this.maxDepthScrollTop = maxDepthScrollTop;
            this.maxScrollHeight = maxScrollHeight;
            this.maxScrollHeightTime = maxScrollHeightTime;
        }

        public final Number getMaxDepth() {
            return this.maxDepth;
        }

        public final Number getMaxDepthScrollTop() {
            return this.maxDepthScrollTop;
        }

        public final Number getMaxScrollHeight() {
            return this.maxScrollHeight;
        }

        public final Number getMaxScrollHeightTime() {
            return this.maxScrollHeightTime;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("max_depth", this.maxDepth);
            jsonObject.addProperty("max_depth_scroll_top", this.maxDepthScrollTop);
            jsonObject.addProperty("max_scroll_height", this.maxScrollHeight);
            jsonObject.addProperty("max_scroll_height_time", this.maxScrollHeightTime);
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Scroll$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$Scroll;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Scroll fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Scroll", e);
                }
            }

            @JvmStatic
            public final Scroll fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    Number maxDepth = jsonObject.get("max_depth").getAsNumber();
                    Number maxDepthScrollTop = jsonObject.get("max_depth_scroll_top").getAsNumber();
                    Number maxScrollHeight = jsonObject.get("max_scroll_height").getAsNumber();
                    Number maxScrollHeightTime = jsonObject.get("max_scroll_height_time").getAsNumber();
                    Intrinsics.checkNotNullExpressionValue(maxDepth, "maxDepth");
                    Intrinsics.checkNotNullExpressionValue(maxDepthScrollTop, "maxDepthScrollTop");
                    Intrinsics.checkNotNullExpressionValue(maxScrollHeight, "maxScrollHeight");
                    Intrinsics.checkNotNullExpressionValue(maxScrollHeightTime, "maxScrollHeightTime");
                    return new Scroll(maxDepth, maxDepthScrollTop, maxScrollHeight, maxScrollHeightTime);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Scroll", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Scroll", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Scroll", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$DdSession;", "", "plan", "Lcom/datadog/android/rum/model/ViewEvent$Plan;", "sessionPrecondition", "Lcom/datadog/android/rum/model/ViewEvent$SessionPrecondition;", "(Lcom/datadog/android/rum/model/ViewEvent$Plan;Lcom/datadog/android/rum/model/ViewEvent$SessionPrecondition;)V", "getPlan", "()Lcom/datadog/android/rum/model/ViewEvent$Plan;", "getSessionPrecondition", "()Lcom/datadog/android/rum/model/ViewEvent$SessionPrecondition;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class DdSession {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Plan plan;
        private final SessionPrecondition sessionPrecondition;

        /* JADX WARN: Multi-variable type inference failed */
        public DdSession() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ DdSession copy$default(DdSession ddSession, Plan plan, SessionPrecondition sessionPrecondition, int i, Object obj) {
            if ((i & 1) != 0) {
                plan = ddSession.plan;
            }
            if ((i & 2) != 0) {
                sessionPrecondition = ddSession.sessionPrecondition;
            }
            return ddSession.copy(plan, sessionPrecondition);
        }

        @JvmStatic
        public static final DdSession fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final DdSession fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Plan getPlan() {
            return this.plan;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final SessionPrecondition getSessionPrecondition() {
            return this.sessionPrecondition;
        }

        public final DdSession copy(Plan plan, SessionPrecondition sessionPrecondition) {
            return new DdSession(plan, sessionPrecondition);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DdSession)) {
                return false;
            }
            DdSession ddSession = (DdSession) other;
            return this.plan == ddSession.plan && this.sessionPrecondition == ddSession.sessionPrecondition;
        }

        public int hashCode() {
            Plan plan = this.plan;
            int iHashCode = (plan == null ? 0 : plan.hashCode()) * 31;
            SessionPrecondition sessionPrecondition = this.sessionPrecondition;
            return iHashCode + (sessionPrecondition != null ? sessionPrecondition.hashCode() : 0);
        }

        public String toString() {
            return "DdSession(plan=" + this.plan + ", sessionPrecondition=" + this.sessionPrecondition + ")";
        }

        public DdSession(Plan plan, SessionPrecondition sessionPrecondition) {
            this.plan = plan;
            this.sessionPrecondition = sessionPrecondition;
        }

        public /* synthetic */ DdSession(Plan plan, SessionPrecondition sessionPrecondition, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : plan, (i & 2) != 0 ? null : sessionPrecondition);
        }

        public final Plan getPlan() {
            return this.plan;
        }

        public final SessionPrecondition getSessionPrecondition() {
            return this.sessionPrecondition;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            Plan plan = this.plan;
            if (plan != null) {
                jsonObject.add("plan", plan.toJson());
            }
            SessionPrecondition sessionPrecondition = this.sessionPrecondition;
            if (sessionPrecondition != null) {
                jsonObject.add("session_precondition", sessionPrecondition.toJson());
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$DdSession$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$DdSession;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final DdSession fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type DdSession", e);
                }
            }

            @JvmStatic
            public final DdSession fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                String asString;
                String asString2;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get("plan");
                    SessionPrecondition sessionPreconditionFromJson = null;
                    Plan planFromJson = (jsonElement == null || (asString2 = jsonElement.getAsString()) == null) ? null : Plan.INSTANCE.fromJson(asString2);
                    JsonElement jsonElement2 = jsonObject.get("session_precondition");
                    if (jsonElement2 != null && (asString = jsonElement2.getAsString()) != null) {
                        sessionPreconditionFromJson = SessionPrecondition.INSTANCE.fromJson(asString);
                    }
                    return new DdSession(planFromJson, sessionPreconditionFromJson);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type DdSession", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type DdSession", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type DdSession", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001&BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0014JZ\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\u0006\u0010#\u001a\u00020$J\t\u0010%\u001a\u00020\tHÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006'"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Configuration;", "", RumSessionScope.RUM_SESSION_SAMPLE_RATE_BUS_MESSAGE_KEY, "", "sessionReplaySampleRate", "profilingSampleRate", "traceSampleRate", "sessionReplayExperimentalFeatures", "", "", "startSessionReplayRecordingManually", "", "(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/util/List;Ljava/lang/Boolean;)V", "getProfilingSampleRate", "()Ljava/lang/Number;", "getSessionReplayExperimentalFeatures", "()Ljava/util/List;", "getSessionReplaySampleRate", "getSessionSampleRate", "getStartSessionReplayRecordingManually", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTraceSampleRate", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/util/List;Ljava/lang/Boolean;)Lcom/datadog/android/rum/model/ViewEvent$Configuration;", "equals", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Configuration {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Number profilingSampleRate;
        private final List<String> sessionReplayExperimentalFeatures;
        private final Number sessionReplaySampleRate;
        private final Number sessionSampleRate;
        private final Boolean startSessionReplayRecordingManually;
        private final Number traceSampleRate;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Configuration copy$default(Configuration configuration, Number number, Number number2, Number number3, Number number4, List list, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                number = configuration.sessionSampleRate;
            }
            if ((i & 2) != 0) {
                number2 = configuration.sessionReplaySampleRate;
            }
            if ((i & 4) != 0) {
                number3 = configuration.profilingSampleRate;
            }
            if ((i & 8) != 0) {
                number4 = configuration.traceSampleRate;
            }
            if ((i & 16) != 0) {
                list = configuration.sessionReplayExperimentalFeatures;
            }
            if ((i & 32) != 0) {
                bool = configuration.startSessionReplayRecordingManually;
            }
            List list2 = list;
            Boolean bool2 = bool;
            return configuration.copy(number, number2, number3, number4, list2, bool2);
        }

        @JvmStatic
        public static final Configuration fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Configuration fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Number getSessionSampleRate() {
            return this.sessionSampleRate;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Number getSessionReplaySampleRate() {
            return this.sessionReplaySampleRate;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Number getProfilingSampleRate() {
            return this.profilingSampleRate;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Number getTraceSampleRate() {
            return this.traceSampleRate;
        }

        public final List<String> component5() {
            return this.sessionReplayExperimentalFeatures;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Boolean getStartSessionReplayRecordingManually() {
            return this.startSessionReplayRecordingManually;
        }

        public final Configuration copy(Number sessionSampleRate, Number sessionReplaySampleRate, Number profilingSampleRate, Number traceSampleRate, List<String> sessionReplayExperimentalFeatures, Boolean startSessionReplayRecordingManually) {
            Intrinsics.checkNotNullParameter(sessionSampleRate, "sessionSampleRate");
            return new Configuration(sessionSampleRate, sessionReplaySampleRate, profilingSampleRate, traceSampleRate, sessionReplayExperimentalFeatures, startSessionReplayRecordingManually);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Configuration)) {
                return false;
            }
            Configuration configuration = (Configuration) other;
            return Intrinsics.areEqual(this.sessionSampleRate, configuration.sessionSampleRate) && Intrinsics.areEqual(this.sessionReplaySampleRate, configuration.sessionReplaySampleRate) && Intrinsics.areEqual(this.profilingSampleRate, configuration.profilingSampleRate) && Intrinsics.areEqual(this.traceSampleRate, configuration.traceSampleRate) && Intrinsics.areEqual(this.sessionReplayExperimentalFeatures, configuration.sessionReplayExperimentalFeatures) && Intrinsics.areEqual(this.startSessionReplayRecordingManually, configuration.startSessionReplayRecordingManually);
        }

        public int hashCode() {
            int iHashCode = this.sessionSampleRate.hashCode() * 31;
            Number number = this.sessionReplaySampleRate;
            int iHashCode2 = (iHashCode + (number == null ? 0 : number.hashCode())) * 31;
            Number number2 = this.profilingSampleRate;
            int iHashCode3 = (iHashCode2 + (number2 == null ? 0 : number2.hashCode())) * 31;
            Number number3 = this.traceSampleRate;
            int iHashCode4 = (iHashCode3 + (number3 == null ? 0 : number3.hashCode())) * 31;
            List<String> list = this.sessionReplayExperimentalFeatures;
            int iHashCode5 = (iHashCode4 + (list == null ? 0 : list.hashCode())) * 31;
            Boolean bool = this.startSessionReplayRecordingManually;
            return iHashCode5 + (bool != null ? bool.hashCode() : 0);
        }

        public String toString() {
            return "Configuration(sessionSampleRate=" + this.sessionSampleRate + ", sessionReplaySampleRate=" + this.sessionReplaySampleRate + ", profilingSampleRate=" + this.profilingSampleRate + ", traceSampleRate=" + this.traceSampleRate + ", sessionReplayExperimentalFeatures=" + this.sessionReplayExperimentalFeatures + ", startSessionReplayRecordingManually=" + this.startSessionReplayRecordingManually + ")";
        }

        public Configuration(Number sessionSampleRate, Number number, Number number2, Number number3, List<String> list, Boolean bool) {
            Intrinsics.checkNotNullParameter(sessionSampleRate, "sessionSampleRate");
            this.sessionSampleRate = sessionSampleRate;
            this.sessionReplaySampleRate = number;
            this.profilingSampleRate = number2;
            this.traceSampleRate = number3;
            this.sessionReplayExperimentalFeatures = list;
            this.startSessionReplayRecordingManually = bool;
        }

        public /* synthetic */ Configuration(Number number, Number number2, Number number3, Number number4, List list, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(number, (i & 2) != 0 ? null : number2, (i & 4) != 0 ? null : number3, (i & 8) != 0 ? null : number4, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : bool);
        }

        public final Number getSessionSampleRate() {
            return this.sessionSampleRate;
        }

        public final Number getSessionReplaySampleRate() {
            return this.sessionReplaySampleRate;
        }

        public final Number getProfilingSampleRate() {
            return this.profilingSampleRate;
        }

        public final Number getTraceSampleRate() {
            return this.traceSampleRate;
        }

        public final List<String> getSessionReplayExperimentalFeatures() {
            return this.sessionReplayExperimentalFeatures;
        }

        public final Boolean getStartSessionReplayRecordingManually() {
            return this.startSessionReplayRecordingManually;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("session_sample_rate", this.sessionSampleRate);
            Number number = this.sessionReplaySampleRate;
            if (number != null) {
                jsonObject.addProperty("session_replay_sample_rate", number);
            }
            Number number2 = this.profilingSampleRate;
            if (number2 != null) {
                jsonObject.addProperty("profiling_sample_rate", number2);
            }
            Number number3 = this.traceSampleRate;
            if (number3 != null) {
                jsonObject.addProperty("trace_sample_rate", number3);
            }
            List<String> list = this.sessionReplayExperimentalFeatures;
            if (list != null) {
                JsonArray jsonArray = new JsonArray(list.size());
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    jsonArray.add((String) it.next());
                }
                jsonObject.add("session_replay_experimental_features", jsonArray);
            }
            Boolean bool = this.startSessionReplayRecordingManually;
            if (bool != null) {
                bool.booleanValue();
                jsonObject.addProperty("start_session_replay_recording_manually", bool);
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Configuration$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$Configuration;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Configuration fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Configuration", e);
                }
            }

            @JvmStatic
            public final Configuration fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                ArrayList arrayList;
                JsonArray asJsonArray;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    Number sessionSampleRate = jsonObject.get("session_sample_rate").getAsNumber();
                    JsonElement jsonElement = jsonObject.get("session_replay_sample_rate");
                    Number asNumber = jsonElement != null ? jsonElement.getAsNumber() : null;
                    JsonElement jsonElement2 = jsonObject.get("profiling_sample_rate");
                    Number asNumber2 = jsonElement2 != null ? jsonElement2.getAsNumber() : null;
                    JsonElement jsonElement3 = jsonObject.get("trace_sample_rate");
                    Number asNumber3 = jsonElement3 != null ? jsonElement3.getAsNumber() : null;
                    JsonElement jsonElement4 = jsonObject.get("session_replay_experimental_features");
                    if (jsonElement4 == null || (asJsonArray = jsonElement4.getAsJsonArray()) == null) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(asJsonArray.size());
                        Iterator<JsonElement> it = asJsonArray.iterator();
                        while (it.hasNext()) {
                            arrayList.add(it.next().getAsString());
                        }
                    }
                    JsonElement jsonElement5 = jsonObject.get("start_session_replay_recording_manually");
                    Boolean boolValueOf = jsonElement5 != null ? Boolean.valueOf(jsonElement5.getAsBoolean()) : null;
                    Intrinsics.checkNotNullExpressionValue(sessionSampleRate, "sessionSampleRate");
                    return new Configuration(sessionSampleRate, asNumber, asNumber2, asNumber3, arrayList, boolValueOf);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Configuration", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Configuration", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Configuration", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$PageState;", "", "state", "Lcom/datadog/android/rum/model/ViewEvent$State;", ViewProps.START, "", "(Lcom/datadog/android/rum/model/ViewEvent$State;J)V", "getStart", "()J", "getState", "()Lcom/datadog/android/rum/model/ViewEvent$State;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class PageState {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long start;
        private final State state;

        public static /* synthetic */ PageState copy$default(PageState pageState, State state, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                state = pageState.state;
            }
            if ((i & 2) != 0) {
                j = pageState.start;
            }
            return pageState.copy(state, j);
        }

        @JvmStatic
        public static final PageState fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final PageState fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final State getState() {
            return this.state;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getStart() {
            return this.start;
        }

        public final PageState copy(State state, long start) {
            Intrinsics.checkNotNullParameter(state, "state");
            return new PageState(state, start);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PageState)) {
                return false;
            }
            PageState pageState = (PageState) other;
            return this.state == pageState.state && this.start == pageState.start;
        }

        public int hashCode() {
            return (this.state.hashCode() * 31) + Long.hashCode(this.start);
        }

        public String toString() {
            return "PageState(state=" + this.state + ", start=" + this.start + ")";
        }

        public PageState(State state, long j) {
            Intrinsics.checkNotNullParameter(state, "state");
            this.state = state;
            this.start = j;
        }

        public final State getState() {
            return this.state;
        }

        public final long getStart() {
            return this.start;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("state", this.state.toJson());
            jsonObject.addProperty(ViewProps.START, Long.valueOf(this.start));
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$PageState$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$PageState;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final PageState fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type PageState", e);
                }
            }

            @JvmStatic
            public final PageState fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    State.Companion companion = State.INSTANCE;
                    String asString = jsonObject.get("state").getAsString();
                    Intrinsics.checkNotNullExpressionValue(asString, "jsonObject.get(\"state\").asString");
                    return new PageState(companion.fromJson(asString), jsonObject.get(ViewProps.START).getAsLong());
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type PageState", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type PageState", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type PageState", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ2\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0006\u0010\u0016\u001a\u00020\u0017J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$ReplayStats;", "", "recordsCount", "", "segmentsCount", "segmentsTotalRawSize", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getRecordsCount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSegmentsCount", "getSegmentsTotalRawSize", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lcom/datadog/android/rum/model/ViewEvent$ReplayStats;", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class ReplayStats {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Long recordsCount;
        private final Long segmentsCount;
        private final Long segmentsTotalRawSize;

        public ReplayStats() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ ReplayStats copy$default(ReplayStats replayStats, Long l, Long l2, Long l3, int i, Object obj) {
            if ((i & 1) != 0) {
                l = replayStats.recordsCount;
            }
            if ((i & 2) != 0) {
                l2 = replayStats.segmentsCount;
            }
            if ((i & 4) != 0) {
                l3 = replayStats.segmentsTotalRawSize;
            }
            return replayStats.copy(l, l2, l3);
        }

        @JvmStatic
        public static final ReplayStats fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final ReplayStats fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Long getRecordsCount() {
            return this.recordsCount;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Long getSegmentsCount() {
            return this.segmentsCount;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Long getSegmentsTotalRawSize() {
            return this.segmentsTotalRawSize;
        }

        public final ReplayStats copy(Long recordsCount, Long segmentsCount, Long segmentsTotalRawSize) {
            return new ReplayStats(recordsCount, segmentsCount, segmentsTotalRawSize);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReplayStats)) {
                return false;
            }
            ReplayStats replayStats = (ReplayStats) other;
            return Intrinsics.areEqual(this.recordsCount, replayStats.recordsCount) && Intrinsics.areEqual(this.segmentsCount, replayStats.segmentsCount) && Intrinsics.areEqual(this.segmentsTotalRawSize, replayStats.segmentsTotalRawSize);
        }

        public int hashCode() {
            Long l = this.recordsCount;
            int iHashCode = (l == null ? 0 : l.hashCode()) * 31;
            Long l2 = this.segmentsCount;
            int iHashCode2 = (iHashCode + (l2 == null ? 0 : l2.hashCode())) * 31;
            Long l3 = this.segmentsTotalRawSize;
            return iHashCode2 + (l3 != null ? l3.hashCode() : 0);
        }

        public String toString() {
            return "ReplayStats(recordsCount=" + this.recordsCount + ", segmentsCount=" + this.segmentsCount + ", segmentsTotalRawSize=" + this.segmentsTotalRawSize + ")";
        }

        public ReplayStats(Long l, Long l2, Long l3) {
            this.recordsCount = l;
            this.segmentsCount = l2;
            this.segmentsTotalRawSize = l3;
        }

        public /* synthetic */ ReplayStats(Long l, Long l2, Long l3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 0L : l, (i & 2) != 0 ? 0L : l2, (i & 4) != 0 ? 0L : l3);
        }

        public final Long getRecordsCount() {
            return this.recordsCount;
        }

        public final Long getSegmentsCount() {
            return this.segmentsCount;
        }

        public final Long getSegmentsTotalRawSize() {
            return this.segmentsTotalRawSize;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            Long l = this.recordsCount;
            if (l != null) {
                jsonObject.addProperty(FeaturesContextResolver.VIEW_RECORDS_COUNT_KEY, Long.valueOf(l.longValue()));
            }
            Long l2 = this.segmentsCount;
            if (l2 != null) {
                jsonObject.addProperty("segments_count", Long.valueOf(l2.longValue()));
            }
            Long l3 = this.segmentsTotalRawSize;
            if (l3 != null) {
                jsonObject.addProperty("segments_total_raw_size", Long.valueOf(l3.longValue()));
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$ReplayStats$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$ReplayStats;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final ReplayStats fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type ReplayStats", e);
                }
            }

            @JvmStatic
            public final ReplayStats fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get(FeaturesContextResolver.VIEW_RECORDS_COUNT_KEY);
                    Long lValueOf = jsonElement != null ? Long.valueOf(jsonElement.getAsLong()) : null;
                    JsonElement jsonElement2 = jsonObject.get("segments_count");
                    Long lValueOf2 = jsonElement2 != null ? Long.valueOf(jsonElement2.getAsLong()) : null;
                    JsonElement jsonElement3 = jsonObject.get("segments_total_raw_size");
                    return new ReplayStats(lValueOf, lValueOf2, jsonElement3 != null ? Long.valueOf(jsonElement3.getAsLong()) : null);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type ReplayStats", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type ReplayStats", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type ReplayStats", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$DdCls;", "", "devicePixelRatio", "", "(Ljava/lang/Number;)V", "getDevicePixelRatio", "()Ljava/lang/Number;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class DdCls {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Number devicePixelRatio;

        /* JADX WARN: Multi-variable type inference failed */
        public DdCls() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ DdCls copy$default(DdCls ddCls, Number number, int i, Object obj) {
            if ((i & 1) != 0) {
                number = ddCls.devicePixelRatio;
            }
            return ddCls.copy(number);
        }

        @JvmStatic
        public static final DdCls fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final DdCls fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Number getDevicePixelRatio() {
            return this.devicePixelRatio;
        }

        public final DdCls copy(Number devicePixelRatio) {
            return new DdCls(devicePixelRatio);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DdCls) && Intrinsics.areEqual(this.devicePixelRatio, ((DdCls) other).devicePixelRatio);
        }

        public int hashCode() {
            Number number = this.devicePixelRatio;
            if (number == null) {
                return 0;
            }
            return number.hashCode();
        }

        public String toString() {
            return "DdCls(devicePixelRatio=" + this.devicePixelRatio + ")";
        }

        public DdCls(Number number) {
            this.devicePixelRatio = number;
        }

        public /* synthetic */ DdCls(Number number, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : number);
        }

        public final Number getDevicePixelRatio() {
            return this.devicePixelRatio;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            Number number = this.devicePixelRatio;
            if (number != null) {
                jsonObject.addProperty("device_pixel_ratio", number);
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$DdCls$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$DdCls;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final DdCls fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type DdCls", e);
                }
            }

            @JvmStatic
            public final DdCls fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get("device_pixel_ratio");
                    return new DdCls(jsonElement != null ? jsonElement.getAsNumber() : null);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type DdCls", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type DdCls", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type DdCls", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001 B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0006\u0010\u001d\u001a\u00020\u001eJ\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Profiling;", "", "status", "Lcom/datadog/android/rum/model/ViewEvent$ProfilingStatus;", "errorReason", "Lcom/datadog/android/rum/model/ViewEvent$ErrorReason;", "quotaReason", "", "clockDrift", "", "(Lcom/datadog/android/rum/model/ViewEvent$ProfilingStatus;Lcom/datadog/android/rum/model/ViewEvent$ErrorReason;Ljava/lang/String;Ljava/lang/Number;)V", "getClockDrift", "()Ljava/lang/Number;", "getErrorReason", "()Lcom/datadog/android/rum/model/ViewEvent$ErrorReason;", "getQuotaReason", "()Ljava/lang/String;", "getStatus", "()Lcom/datadog/android/rum/model/ViewEvent$ProfilingStatus;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Profiling {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Number clockDrift;
        private final ErrorReason errorReason;
        private final String quotaReason;
        private final ProfilingStatus status;

        public Profiling() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ Profiling copy$default(Profiling profiling, ProfilingStatus profilingStatus, ErrorReason errorReason, String str, Number number, int i, Object obj) {
            if ((i & 1) != 0) {
                profilingStatus = profiling.status;
            }
            if ((i & 2) != 0) {
                errorReason = profiling.errorReason;
            }
            if ((i & 4) != 0) {
                str = profiling.quotaReason;
            }
            if ((i & 8) != 0) {
                number = profiling.clockDrift;
            }
            return profiling.copy(profilingStatus, errorReason, str, number);
        }

        @JvmStatic
        public static final Profiling fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Profiling fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ProfilingStatus getStatus() {
            return this.status;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ErrorReason getErrorReason() {
            return this.errorReason;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getQuotaReason() {
            return this.quotaReason;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Number getClockDrift() {
            return this.clockDrift;
        }

        public final Profiling copy(ProfilingStatus status, ErrorReason errorReason, String quotaReason, Number clockDrift) {
            return new Profiling(status, errorReason, quotaReason, clockDrift);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Profiling)) {
                return false;
            }
            Profiling profiling = (Profiling) other;
            return this.status == profiling.status && this.errorReason == profiling.errorReason && Intrinsics.areEqual(this.quotaReason, profiling.quotaReason) && Intrinsics.areEqual(this.clockDrift, profiling.clockDrift);
        }

        public int hashCode() {
            ProfilingStatus profilingStatus = this.status;
            int iHashCode = (profilingStatus == null ? 0 : profilingStatus.hashCode()) * 31;
            ErrorReason errorReason = this.errorReason;
            int iHashCode2 = (iHashCode + (errorReason == null ? 0 : errorReason.hashCode())) * 31;
            String str = this.quotaReason;
            int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            Number number = this.clockDrift;
            return iHashCode3 + (number != null ? number.hashCode() : 0);
        }

        public String toString() {
            return "Profiling(status=" + this.status + ", errorReason=" + this.errorReason + ", quotaReason=" + this.quotaReason + ", clockDrift=" + this.clockDrift + ")";
        }

        public Profiling(ProfilingStatus profilingStatus, ErrorReason errorReason, String str, Number number) {
            this.status = profilingStatus;
            this.errorReason = errorReason;
            this.quotaReason = str;
            this.clockDrift = number;
        }

        public /* synthetic */ Profiling(ProfilingStatus profilingStatus, ErrorReason errorReason, String str, Number number, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : profilingStatus, (i & 2) != 0 ? null : errorReason, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : number);
        }

        public final ProfilingStatus getStatus() {
            return this.status;
        }

        public final ErrorReason getErrorReason() {
            return this.errorReason;
        }

        public final String getQuotaReason() {
            return this.quotaReason;
        }

        public final Number getClockDrift() {
            return this.clockDrift;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            ProfilingStatus profilingStatus = this.status;
            if (profilingStatus != null) {
                jsonObject.add("status", profilingStatus.toJson());
            }
            ErrorReason errorReason = this.errorReason;
            if (errorReason != null) {
                jsonObject.add("error_reason", errorReason.toJson());
            }
            String str = this.quotaReason;
            if (str != null) {
                jsonObject.addProperty("quota_reason", str);
            }
            Number number = this.clockDrift;
            if (number != null) {
                jsonObject.addProperty("clock_drift", number);
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Profiling$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$Profiling;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Profiling fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Profiling", e);
                }
            }

            @JvmStatic
            public final Profiling fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                String asString;
                String asString2;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get("status");
                    ProfilingStatus profilingStatusFromJson = (jsonElement == null || (asString2 = jsonElement.getAsString()) == null) ? null : ProfilingStatus.INSTANCE.fromJson(asString2);
                    JsonElement jsonElement2 = jsonObject.get("error_reason");
                    ErrorReason errorReasonFromJson = (jsonElement2 == null || (asString = jsonElement2.getAsString()) == null) ? null : ErrorReason.INSTANCE.fromJson(asString);
                    JsonElement jsonElement3 = jsonObject.get("quota_reason");
                    String asString3 = jsonElement3 != null ? jsonElement3.getAsString() : null;
                    JsonElement jsonElement4 = jsonObject.get("clock_drift");
                    return new Profiling(profilingStatusFromJson, errorReasonFromJson, asString3, jsonElement4 != null ? jsonElement4.getAsNumber() : null);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Profiling", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Profiling", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Profiling", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$ContainerView;", "", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class ContainerView {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String id;

        public static /* synthetic */ ContainerView copy$default(ContainerView containerView, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = containerView.id;
            }
            return containerView.copy(str);
        }

        @JvmStatic
        public static final ContainerView fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final ContainerView fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        public final ContainerView copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new ContainerView(id);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ContainerView) && Intrinsics.areEqual(this.id, ((ContainerView) other).id);
        }

        public int hashCode() {
            return this.id.hashCode();
        }

        public String toString() {
            return "ContainerView(id=" + this.id + ")";
        }

        public ContainerView(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public final String getId() {
            return this.id;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id", this.id);
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$ContainerView$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$ContainerView;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final ContainerView fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type ContainerView", e);
                }
            }

            @JvmStatic
            public final ContainerView fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String id = jsonObject.get("id").getAsString();
                    Intrinsics.checkNotNullExpressionValue(id, "id");
                    return new ContainerView(id);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type ContainerView", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type ContainerView", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type ContainerView", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 %2\u00020\u0001:\u0001%B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003JH\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\u0006\u0010\"\u001a\u00020#J\t\u0010$\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006&"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$PerformanceCls;", "", FirebaseAnalytics.Param.SCORE, "", "timestamp", "", "targetSelector", "", "previousRect", "Lcom/datadog/android/rum/model/ViewEvent$PreviousRect;", "currentRect", "(Ljava/lang/Number;Ljava/lang/Long;Ljava/lang/String;Lcom/datadog/android/rum/model/ViewEvent$PreviousRect;Lcom/datadog/android/rum/model/ViewEvent$PreviousRect;)V", "getCurrentRect", "()Lcom/datadog/android/rum/model/ViewEvent$PreviousRect;", "getPreviousRect", "getScore", "()Ljava/lang/Number;", "getTargetSelector", "()Ljava/lang/String;", "getTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Number;Ljava/lang/Long;Ljava/lang/String;Lcom/datadog/android/rum/model/ViewEvent$PreviousRect;Lcom/datadog/android/rum/model/ViewEvent$PreviousRect;)Lcom/datadog/android/rum/model/ViewEvent$PerformanceCls;", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class PerformanceCls {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final PreviousRect currentRect;
        private final PreviousRect previousRect;
        private final Number score;
        private final String targetSelector;
        private final Long timestamp;

        public static /* synthetic */ PerformanceCls copy$default(PerformanceCls performanceCls, Number number, Long l, String str, PreviousRect previousRect, PreviousRect previousRect2, int i, Object obj) {
            if ((i & 1) != 0) {
                number = performanceCls.score;
            }
            if ((i & 2) != 0) {
                l = performanceCls.timestamp;
            }
            if ((i & 4) != 0) {
                str = performanceCls.targetSelector;
            }
            if ((i & 8) != 0) {
                previousRect = performanceCls.previousRect;
            }
            if ((i & 16) != 0) {
                previousRect2 = performanceCls.currentRect;
            }
            PreviousRect previousRect3 = previousRect2;
            String str2 = str;
            return performanceCls.copy(number, l, str2, previousRect, previousRect3);
        }

        @JvmStatic
        public static final PerformanceCls fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final PerformanceCls fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Number getScore() {
            return this.score;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Long getTimestamp() {
            return this.timestamp;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getTargetSelector() {
            return this.targetSelector;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final PreviousRect getPreviousRect() {
            return this.previousRect;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final PreviousRect getCurrentRect() {
            return this.currentRect;
        }

        public final PerformanceCls copy(Number score, Long timestamp, String targetSelector, PreviousRect previousRect, PreviousRect currentRect) {
            Intrinsics.checkNotNullParameter(score, "score");
            return new PerformanceCls(score, timestamp, targetSelector, previousRect, currentRect);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PerformanceCls)) {
                return false;
            }
            PerformanceCls performanceCls = (PerformanceCls) other;
            return Intrinsics.areEqual(this.score, performanceCls.score) && Intrinsics.areEqual(this.timestamp, performanceCls.timestamp) && Intrinsics.areEqual(this.targetSelector, performanceCls.targetSelector) && Intrinsics.areEqual(this.previousRect, performanceCls.previousRect) && Intrinsics.areEqual(this.currentRect, performanceCls.currentRect);
        }

        public int hashCode() {
            int iHashCode = this.score.hashCode() * 31;
            Long l = this.timestamp;
            int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
            String str = this.targetSelector;
            int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            PreviousRect previousRect = this.previousRect;
            int iHashCode4 = (iHashCode3 + (previousRect == null ? 0 : previousRect.hashCode())) * 31;
            PreviousRect previousRect2 = this.currentRect;
            return iHashCode4 + (previousRect2 != null ? previousRect2.hashCode() : 0);
        }

        public String toString() {
            return "PerformanceCls(score=" + this.score + ", timestamp=" + this.timestamp + ", targetSelector=" + this.targetSelector + ", previousRect=" + this.previousRect + ", currentRect=" + this.currentRect + ")";
        }

        public PerformanceCls(Number score, Long l, String str, PreviousRect previousRect, PreviousRect previousRect2) {
            Intrinsics.checkNotNullParameter(score, "score");
            this.score = score;
            this.timestamp = l;
            this.targetSelector = str;
            this.previousRect = previousRect;
            this.currentRect = previousRect2;
        }

        public /* synthetic */ PerformanceCls(Number number, Long l, String str, PreviousRect previousRect, PreviousRect previousRect2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(number, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : previousRect, (i & 16) != 0 ? null : previousRect2);
        }

        public final Number getScore() {
            return this.score;
        }

        public final Long getTimestamp() {
            return this.timestamp;
        }

        public final String getTargetSelector() {
            return this.targetSelector;
        }

        public final PreviousRect getPreviousRect() {
            return this.previousRect;
        }

        public final PreviousRect getCurrentRect() {
            return this.currentRect;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(FirebaseAnalytics.Param.SCORE, this.score);
            Long l = this.timestamp;
            if (l != null) {
                jsonObject.addProperty("timestamp", Long.valueOf(l.longValue()));
            }
            String str = this.targetSelector;
            if (str != null) {
                jsonObject.addProperty("target_selector", str);
            }
            PreviousRect previousRect = this.previousRect;
            if (previousRect != null) {
                jsonObject.add("previous_rect", previousRect.toJson());
            }
            PreviousRect previousRect2 = this.currentRect;
            if (previousRect2 != null) {
                jsonObject.add("current_rect", previousRect2.toJson());
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$PerformanceCls$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$PerformanceCls;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final PerformanceCls fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type PerformanceCls", e);
                }
            }

            @JvmStatic
            public final PerformanceCls fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                JsonObject asJsonObject;
                JsonObject asJsonObject2;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    Number score = jsonObject.get(FirebaseAnalytics.Param.SCORE).getAsNumber();
                    JsonElement jsonElement = jsonObject.get("timestamp");
                    PreviousRect previousRectFromJsonObject = null;
                    Long lValueOf = jsonElement != null ? Long.valueOf(jsonElement.getAsLong()) : null;
                    JsonElement jsonElement2 = jsonObject.get("target_selector");
                    String asString = jsonElement2 != null ? jsonElement2.getAsString() : null;
                    JsonElement jsonElement3 = jsonObject.get("previous_rect");
                    PreviousRect previousRectFromJsonObject2 = (jsonElement3 == null || (asJsonObject2 = jsonElement3.getAsJsonObject()) == null) ? null : PreviousRect.INSTANCE.fromJsonObject(asJsonObject2);
                    JsonElement jsonElement4 = jsonObject.get("current_rect");
                    if (jsonElement4 != null && (asJsonObject = jsonElement4.getAsJsonObject()) != null) {
                        previousRectFromJsonObject = PreviousRect.INSTANCE.fromJsonObject(asJsonObject);
                    }
                    Intrinsics.checkNotNullExpressionValue(score, "score");
                    return new PerformanceCls(score, lValueOf, asString, previousRectFromJsonObject2, previousRectFromJsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type PerformanceCls", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type PerformanceCls", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type PerformanceCls", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Fcp;", "", "timestamp", "", "(J)V", "getTimestamp", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Fcp {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long timestamp;

        public static /* synthetic */ Fcp copy$default(Fcp fcp, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = fcp.timestamp;
            }
            return fcp.copy(j);
        }

        @JvmStatic
        public static final Fcp fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Fcp fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        public final Fcp copy(long timestamp) {
            return new Fcp(timestamp);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Fcp) && this.timestamp == ((Fcp) other).timestamp;
        }

        public int hashCode() {
            return Long.hashCode(this.timestamp);
        }

        public String toString() {
            return "Fcp(timestamp=" + this.timestamp + ")";
        }

        public Fcp(long j) {
            this.timestamp = j;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("timestamp", Long.valueOf(this.timestamp));
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Fcp$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$Fcp;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Fcp fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Fcp", e);
                }
            }

            @JvmStatic
            public final Fcp fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    return new Fcp(jsonObject.get("timestamp").getAsLong());
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Fcp", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Fcp", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Fcp", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0006\u0010\u0016\u001a\u00020\u0017J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Fid;", "", "duration", "", "timestamp", "targetSelector", "", "(JJLjava/lang/String;)V", "getDuration", "()J", "getTargetSelector", "()Ljava/lang/String;", "getTimestamp", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Fid {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long duration;
        private final String targetSelector;
        private final long timestamp;

        public static /* synthetic */ Fid copy$default(Fid fid, long j, long j2, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                j = fid.duration;
            }
            long j3 = j;
            if ((i & 2) != 0) {
                j2 = fid.timestamp;
            }
            long j4 = j2;
            if ((i & 4) != 0) {
                str = fid.targetSelector;
            }
            return fid.copy(j3, j4, str);
        }

        @JvmStatic
        public static final Fid fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Fid fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getDuration() {
            return this.duration;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getTargetSelector() {
            return this.targetSelector;
        }

        public final Fid copy(long duration, long timestamp, String targetSelector) {
            return new Fid(duration, timestamp, targetSelector);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Fid)) {
                return false;
            }
            Fid fid = (Fid) other;
            return this.duration == fid.duration && this.timestamp == fid.timestamp && Intrinsics.areEqual(this.targetSelector, fid.targetSelector);
        }

        public int hashCode() {
            int iHashCode = ((Long.hashCode(this.duration) * 31) + Long.hashCode(this.timestamp)) * 31;
            String str = this.targetSelector;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Fid(duration=" + this.duration + ", timestamp=" + this.timestamp + ", targetSelector=" + this.targetSelector + ")";
        }

        public Fid(long j, long j2, String str) {
            this.duration = j;
            this.timestamp = j2;
            this.targetSelector = str;
        }

        public /* synthetic */ Fid(long j, long j2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, j2, (i & 4) != 0 ? null : str);
        }

        public final long getDuration() {
            return this.duration;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public final String getTargetSelector() {
            return this.targetSelector;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("duration", Long.valueOf(this.duration));
            jsonObject.addProperty("timestamp", Long.valueOf(this.timestamp));
            String str = this.targetSelector;
            if (str != null) {
                jsonObject.addProperty("target_selector", str);
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Fid$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$Fid;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Fid fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Fid", e);
                }
            }

            @JvmStatic
            public final Fid fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    long asLong = jsonObject.get("duration").getAsLong();
                    long asLong2 = jsonObject.get("timestamp").getAsLong();
                    JsonElement jsonElement = jsonObject.get("target_selector");
                    return new Fid(asLong, asLong2, jsonElement != null ? jsonElement.getAsString() : null);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Fid", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Fid", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Fid", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001!B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J<\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0006\u0010\u001e\u001a\u00020\u001fJ\t\u0010 \u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\""}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Inp;", "", "duration", "", "timestamp", "targetSelector", "", "subParts", "Lcom/datadog/android/rum/model/ViewEvent$InpSubParts;", "(JLjava/lang/Long;Ljava/lang/String;Lcom/datadog/android/rum/model/ViewEvent$InpSubParts;)V", "getDuration", "()J", "getSubParts", "()Lcom/datadog/android/rum/model/ViewEvent$InpSubParts;", "getTargetSelector", "()Ljava/lang/String;", "getTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "copy", "(JLjava/lang/Long;Ljava/lang/String;Lcom/datadog/android/rum/model/ViewEvent$InpSubParts;)Lcom/datadog/android/rum/model/ViewEvent$Inp;", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Inp {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long duration;
        private final InpSubParts subParts;
        private final String targetSelector;
        private final Long timestamp;

        public static /* synthetic */ Inp copy$default(Inp inp, long j, Long l, String str, InpSubParts inpSubParts, int i, Object obj) {
            if ((i & 1) != 0) {
                j = inp.duration;
            }
            long j2 = j;
            if ((i & 2) != 0) {
                l = inp.timestamp;
            }
            Long l2 = l;
            if ((i & 4) != 0) {
                str = inp.targetSelector;
            }
            String str2 = str;
            if ((i & 8) != 0) {
                inpSubParts = inp.subParts;
            }
            return inp.copy(j2, l2, str2, inpSubParts);
        }

        @JvmStatic
        public static final Inp fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Inp fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getDuration() {
            return this.duration;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Long getTimestamp() {
            return this.timestamp;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getTargetSelector() {
            return this.targetSelector;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final InpSubParts getSubParts() {
            return this.subParts;
        }

        public final Inp copy(long duration, Long timestamp, String targetSelector, InpSubParts subParts) {
            return new Inp(duration, timestamp, targetSelector, subParts);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Inp)) {
                return false;
            }
            Inp inp = (Inp) other;
            return this.duration == inp.duration && Intrinsics.areEqual(this.timestamp, inp.timestamp) && Intrinsics.areEqual(this.targetSelector, inp.targetSelector) && Intrinsics.areEqual(this.subParts, inp.subParts);
        }

        public int hashCode() {
            int iHashCode = Long.hashCode(this.duration) * 31;
            Long l = this.timestamp;
            int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
            String str = this.targetSelector;
            int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            InpSubParts inpSubParts = this.subParts;
            return iHashCode3 + (inpSubParts != null ? inpSubParts.hashCode() : 0);
        }

        public String toString() {
            return "Inp(duration=" + this.duration + ", timestamp=" + this.timestamp + ", targetSelector=" + this.targetSelector + ", subParts=" + this.subParts + ")";
        }

        public Inp(long j, Long l, String str, InpSubParts inpSubParts) {
            this.duration = j;
            this.timestamp = l;
            this.targetSelector = str;
            this.subParts = inpSubParts;
        }

        public /* synthetic */ Inp(long j, Long l, String str, InpSubParts inpSubParts, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : inpSubParts);
        }

        public final long getDuration() {
            return this.duration;
        }

        public final Long getTimestamp() {
            return this.timestamp;
        }

        public final String getTargetSelector() {
            return this.targetSelector;
        }

        public final InpSubParts getSubParts() {
            return this.subParts;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("duration", Long.valueOf(this.duration));
            Long l = this.timestamp;
            if (l != null) {
                jsonObject.addProperty("timestamp", Long.valueOf(l.longValue()));
            }
            String str = this.targetSelector;
            if (str != null) {
                jsonObject.addProperty("target_selector", str);
            }
            InpSubParts inpSubParts = this.subParts;
            if (inpSubParts != null) {
                jsonObject.add("sub_parts", inpSubParts.toJson());
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Inp$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$Inp;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Inp fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Inp", e);
                }
            }

            @JvmStatic
            public final Inp fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                JsonObject asJsonObject;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    long asLong = jsonObject.get("duration").getAsLong();
                    JsonElement jsonElement = jsonObject.get("timestamp");
                    InpSubParts inpSubPartsFromJsonObject = null;
                    Long lValueOf = jsonElement != null ? Long.valueOf(jsonElement.getAsLong()) : null;
                    JsonElement jsonElement2 = jsonObject.get("target_selector");
                    String asString = jsonElement2 != null ? jsonElement2.getAsString() : null;
                    JsonElement jsonElement3 = jsonObject.get("sub_parts");
                    if (jsonElement3 != null && (asJsonObject = jsonElement3.getAsJsonObject()) != null) {
                        inpSubPartsFromJsonObject = InpSubParts.INSTANCE.fromJsonObject(asJsonObject);
                    }
                    return new Inp(asLong, lValueOf, asString, inpSubPartsFromJsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Inp", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Inp", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Inp", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001 B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0006\u0010\u001d\u001a\u00020\u001eJ\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Lcp;", "", "timestamp", "", "targetSelector", "", "resourceUrl", "subParts", "Lcom/datadog/android/rum/model/ViewEvent$LcpSubParts;", "(JLjava/lang/String;Ljava/lang/String;Lcom/datadog/android/rum/model/ViewEvent$LcpSubParts;)V", "getResourceUrl", "()Ljava/lang/String;", "setResourceUrl", "(Ljava/lang/String;)V", "getSubParts", "()Lcom/datadog/android/rum/model/ViewEvent$LcpSubParts;", "getTargetSelector", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Lcp {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private String resourceUrl;
        private final LcpSubParts subParts;
        private final String targetSelector;
        private final long timestamp;

        public static /* synthetic */ Lcp copy$default(Lcp lcp, long j, String str, String str2, LcpSubParts lcpSubParts, int i, Object obj) {
            if ((i & 1) != 0) {
                j = lcp.timestamp;
            }
            long j2 = j;
            if ((i & 2) != 0) {
                str = lcp.targetSelector;
            }
            String str3 = str;
            if ((i & 4) != 0) {
                str2 = lcp.resourceUrl;
            }
            String str4 = str2;
            if ((i & 8) != 0) {
                lcpSubParts = lcp.subParts;
            }
            return lcp.copy(j2, str3, str4, lcpSubParts);
        }

        @JvmStatic
        public static final Lcp fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Lcp fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTargetSelector() {
            return this.targetSelector;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getResourceUrl() {
            return this.resourceUrl;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final LcpSubParts getSubParts() {
            return this.subParts;
        }

        public final Lcp copy(long timestamp, String targetSelector, String resourceUrl, LcpSubParts subParts) {
            return new Lcp(timestamp, targetSelector, resourceUrl, subParts);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Lcp)) {
                return false;
            }
            Lcp lcp = (Lcp) other;
            return this.timestamp == lcp.timestamp && Intrinsics.areEqual(this.targetSelector, lcp.targetSelector) && Intrinsics.areEqual(this.resourceUrl, lcp.resourceUrl) && Intrinsics.areEqual(this.subParts, lcp.subParts);
        }

        public int hashCode() {
            int iHashCode = Long.hashCode(this.timestamp) * 31;
            String str = this.targetSelector;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.resourceUrl;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            LcpSubParts lcpSubParts = this.subParts;
            return iHashCode3 + (lcpSubParts != null ? lcpSubParts.hashCode() : 0);
        }

        public String toString() {
            return "Lcp(timestamp=" + this.timestamp + ", targetSelector=" + this.targetSelector + ", resourceUrl=" + this.resourceUrl + ", subParts=" + this.subParts + ")";
        }

        public Lcp(long j, String str, String str2, LcpSubParts lcpSubParts) {
            this.timestamp = j;
            this.targetSelector = str;
            this.resourceUrl = str2;
            this.subParts = lcpSubParts;
        }

        public /* synthetic */ Lcp(long j, String str, String str2, LcpSubParts lcpSubParts, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : lcpSubParts);
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public final String getTargetSelector() {
            return this.targetSelector;
        }

        public final String getResourceUrl() {
            return this.resourceUrl;
        }

        public final void setResourceUrl(String str) {
            this.resourceUrl = str;
        }

        public final LcpSubParts getSubParts() {
            return this.subParts;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("timestamp", Long.valueOf(this.timestamp));
            String str = this.targetSelector;
            if (str != null) {
                jsonObject.addProperty("target_selector", str);
            }
            String str2 = this.resourceUrl;
            if (str2 != null) {
                jsonObject.addProperty("resource_url", str2);
            }
            LcpSubParts lcpSubParts = this.subParts;
            if (lcpSubParts != null) {
                jsonObject.add("sub_parts", lcpSubParts.toJson());
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Lcp$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$Lcp;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Lcp fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Lcp", e);
                }
            }

            @JvmStatic
            public final Lcp fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                JsonObject asJsonObject;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    long asLong = jsonObject.get("timestamp").getAsLong();
                    JsonElement jsonElement = jsonObject.get("target_selector");
                    LcpSubParts lcpSubPartsFromJsonObject = null;
                    String asString = jsonElement != null ? jsonElement.getAsString() : null;
                    JsonElement jsonElement2 = jsonObject.get("resource_url");
                    String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
                    JsonElement jsonElement3 = jsonObject.get("sub_parts");
                    if (jsonElement3 != null && (asJsonObject = jsonElement3.getAsJsonObject()) != null) {
                        lcpSubPartsFromJsonObject = LcpSubParts.INSTANCE.fromJsonObject(asJsonObject);
                    }
                    return new Lcp(asLong, asString, asString2, lcpSubPartsFromJsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Lcp", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Lcp", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Lcp", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Fbc;", "", "timestamp", "", "(J)V", "getTimestamp", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Fbc {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long timestamp;

        public static /* synthetic */ Fbc copy$default(Fbc fbc, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = fbc.timestamp;
            }
            return fbc.copy(j);
        }

        @JvmStatic
        public static final Fbc fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Fbc fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        public final Fbc copy(long timestamp) {
            return new Fbc(timestamp);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Fbc) && this.timestamp == ((Fbc) other).timestamp;
        }

        public int hashCode() {
            return Long.hashCode(this.timestamp);
        }

        public String toString() {
            return "Fbc(timestamp=" + this.timestamp + ")";
        }

        public Fbc(long j) {
            this.timestamp = j;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("timestamp", Long.valueOf(this.timestamp));
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Fbc$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$Fbc;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Fbc fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Fbc", e);
                }
            }

            @JvmStatic
            public final Fbc fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    return new Fbc(jsonObject.get("timestamp").getAsLong());
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Fbc", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Fbc", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Fbc", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0006\u0010\u0017\u001a\u00020\u0018J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$PreviousRect;", "", ViewDeviceOrientationData.DEVICE_ORIENTATION_X, "", ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, ViewProps.WIDTH, ViewProps.HEIGHT, "(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)V", "getHeight", "()Ljava/lang/Number;", "getWidth", "getX", "getY", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class PreviousRect {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Number height;
        private final Number width;
        private final Number x;
        private final Number y;

        public static /* synthetic */ PreviousRect copy$default(PreviousRect previousRect, Number number, Number number2, Number number3, Number number4, int i, Object obj) {
            if ((i & 1) != 0) {
                number = previousRect.x;
            }
            if ((i & 2) != 0) {
                number2 = previousRect.y;
            }
            if ((i & 4) != 0) {
                number3 = previousRect.width;
            }
            if ((i & 8) != 0) {
                number4 = previousRect.height;
            }
            return previousRect.copy(number, number2, number3, number4);
        }

        @JvmStatic
        public static final PreviousRect fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final PreviousRect fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Number getX() {
            return this.x;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Number getY() {
            return this.y;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Number getWidth() {
            return this.width;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Number getHeight() {
            return this.height;
        }

        public final PreviousRect copy(Number x, Number y, Number width, Number height) {
            Intrinsics.checkNotNullParameter(x, "x");
            Intrinsics.checkNotNullParameter(y, "y");
            Intrinsics.checkNotNullParameter(width, "width");
            Intrinsics.checkNotNullParameter(height, "height");
            return new PreviousRect(x, y, width, height);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PreviousRect)) {
                return false;
            }
            PreviousRect previousRect = (PreviousRect) other;
            return Intrinsics.areEqual(this.x, previousRect.x) && Intrinsics.areEqual(this.y, previousRect.y) && Intrinsics.areEqual(this.width, previousRect.width) && Intrinsics.areEqual(this.height, previousRect.height);
        }

        public int hashCode() {
            return (((((this.x.hashCode() * 31) + this.y.hashCode()) * 31) + this.width.hashCode()) * 31) + this.height.hashCode();
        }

        public String toString() {
            return "PreviousRect(x=" + this.x + ", y=" + this.y + ", width=" + this.width + ", height=" + this.height + ")";
        }

        public PreviousRect(Number x, Number y, Number width, Number height) {
            Intrinsics.checkNotNullParameter(x, "x");
            Intrinsics.checkNotNullParameter(y, "y");
            Intrinsics.checkNotNullParameter(width, "width");
            Intrinsics.checkNotNullParameter(height, "height");
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public final Number getX() {
            return this.x;
        }

        public final Number getY() {
            return this.y;
        }

        public final Number getWidth() {
            return this.width;
        }

        public final Number getHeight() {
            return this.height;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(ViewDeviceOrientationData.DEVICE_ORIENTATION_X, this.x);
            jsonObject.addProperty(ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, this.y);
            jsonObject.addProperty(ViewProps.WIDTH, this.width);
            jsonObject.addProperty(ViewProps.HEIGHT, this.height);
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$PreviousRect$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$PreviousRect;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final PreviousRect fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type PreviousRect", e);
                }
            }

            @JvmStatic
            public final PreviousRect fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    Number x = jsonObject.get(ViewDeviceOrientationData.DEVICE_ORIENTATION_X).getAsNumber();
                    Number y = jsonObject.get(ViewDeviceOrientationData.DEVICE_ORIENTATION_Y).getAsNumber();
                    Number width = jsonObject.get(ViewProps.WIDTH).getAsNumber();
                    Number height = jsonObject.get(ViewProps.HEIGHT).getAsNumber();
                    Intrinsics.checkNotNullExpressionValue(x, "x");
                    Intrinsics.checkNotNullExpressionValue(y, "y");
                    Intrinsics.checkNotNullExpressionValue(width, "width");
                    Intrinsics.checkNotNullExpressionValue(height, "height");
                    return new PreviousRect(x, y, width, height);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type PreviousRect", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type PreviousRect", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type PreviousRect", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$InpSubParts;", "", "inputDelay", "", "processingTime", "presentationDelay", "(JJJ)V", "getInputDelay", "()J", "getPresentationDelay", "getProcessingTime", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class InpSubParts {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long inputDelay;
        private final long presentationDelay;
        private final long processingTime;

        public static /* synthetic */ InpSubParts copy$default(InpSubParts inpSubParts, long j, long j2, long j3, int i, Object obj) {
            if ((i & 1) != 0) {
                j = inpSubParts.inputDelay;
            }
            long j4 = j;
            if ((i & 2) != 0) {
                j2 = inpSubParts.processingTime;
            }
            long j5 = j2;
            if ((i & 4) != 0) {
                j3 = inpSubParts.presentationDelay;
            }
            return inpSubParts.copy(j4, j5, j3);
        }

        @JvmStatic
        public static final InpSubParts fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final InpSubParts fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getInputDelay() {
            return this.inputDelay;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getProcessingTime() {
            return this.processingTime;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getPresentationDelay() {
            return this.presentationDelay;
        }

        public final InpSubParts copy(long inputDelay, long processingTime, long presentationDelay) {
            return new InpSubParts(inputDelay, processingTime, presentationDelay);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InpSubParts)) {
                return false;
            }
            InpSubParts inpSubParts = (InpSubParts) other;
            return this.inputDelay == inpSubParts.inputDelay && this.processingTime == inpSubParts.processingTime && this.presentationDelay == inpSubParts.presentationDelay;
        }

        public int hashCode() {
            return (((Long.hashCode(this.inputDelay) * 31) + Long.hashCode(this.processingTime)) * 31) + Long.hashCode(this.presentationDelay);
        }

        public String toString() {
            return "InpSubParts(inputDelay=" + this.inputDelay + ", processingTime=" + this.processingTime + ", presentationDelay=" + this.presentationDelay + ")";
        }

        public InpSubParts(long j, long j2, long j3) {
            this.inputDelay = j;
            this.processingTime = j2;
            this.presentationDelay = j3;
        }

        public final long getInputDelay() {
            return this.inputDelay;
        }

        public final long getProcessingTime() {
            return this.processingTime;
        }

        public final long getPresentationDelay() {
            return this.presentationDelay;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("input_delay", Long.valueOf(this.inputDelay));
            jsonObject.addProperty("processing_time", Long.valueOf(this.processingTime));
            jsonObject.addProperty("presentation_delay", Long.valueOf(this.presentationDelay));
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$InpSubParts$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$InpSubParts;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final InpSubParts fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type InpSubParts", e);
                }
            }

            @JvmStatic
            public final InpSubParts fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    return new InpSubParts(jsonObject.get("input_delay").getAsLong(), jsonObject.get("processing_time").getAsLong(), jsonObject.get("presentation_delay").getAsLong());
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type InpSubParts", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type InpSubParts", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type InpSubParts", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$LcpSubParts;", "", "loadDelay", "", "loadTime", "renderDelay", "(JJJ)V", "getLoadDelay", "()J", "getLoadTime", "getRenderDelay", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class LcpSubParts {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long loadDelay;
        private final long loadTime;
        private final long renderDelay;

        public static /* synthetic */ LcpSubParts copy$default(LcpSubParts lcpSubParts, long j, long j2, long j3, int i, Object obj) {
            if ((i & 1) != 0) {
                j = lcpSubParts.loadDelay;
            }
            long j4 = j;
            if ((i & 2) != 0) {
                j2 = lcpSubParts.loadTime;
            }
            long j5 = j2;
            if ((i & 4) != 0) {
                j3 = lcpSubParts.renderDelay;
            }
            return lcpSubParts.copy(j4, j5, j3);
        }

        @JvmStatic
        public static final LcpSubParts fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final LcpSubParts fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getLoadDelay() {
            return this.loadDelay;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getLoadTime() {
            return this.loadTime;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getRenderDelay() {
            return this.renderDelay;
        }

        public final LcpSubParts copy(long loadDelay, long loadTime, long renderDelay) {
            return new LcpSubParts(loadDelay, loadTime, renderDelay);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LcpSubParts)) {
                return false;
            }
            LcpSubParts lcpSubParts = (LcpSubParts) other;
            return this.loadDelay == lcpSubParts.loadDelay && this.loadTime == lcpSubParts.loadTime && this.renderDelay == lcpSubParts.renderDelay;
        }

        public int hashCode() {
            return (((Long.hashCode(this.loadDelay) * 31) + Long.hashCode(this.loadTime)) * 31) + Long.hashCode(this.renderDelay);
        }

        public String toString() {
            return "LcpSubParts(loadDelay=" + this.loadDelay + ", loadTime=" + this.loadTime + ", renderDelay=" + this.renderDelay + ")";
        }

        public LcpSubParts(long j, long j2, long j3) {
            this.loadDelay = j;
            this.loadTime = j2;
            this.renderDelay = j3;
        }

        public final long getLoadDelay() {
            return this.loadDelay;
        }

        public final long getLoadTime() {
            return this.loadTime;
        }

        public final long getRenderDelay() {
            return this.renderDelay;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("load_delay", Long.valueOf(this.loadDelay));
            jsonObject.addProperty("load_time", Long.valueOf(this.loadTime));
            jsonObject.addProperty("render_delay", Long.valueOf(this.renderDelay));
            return jsonObject;
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$LcpSubParts$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$LcpSubParts;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final LcpSubParts fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type LcpSubParts", e);
                }
            }

            @JvmStatic
            public final LcpSubParts fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    return new LcpSubParts(jsonObject.get("load_delay").getAsLong(), jsonObject.get("load_time").getAsLong(), jsonObject.get("render_delay").getAsLong());
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type LcpSubParts", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type LcpSubParts", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type LcpSubParts", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$ViewEventSource;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "ANDROID", "IOS", "BROWSER", "FLUTTER", "REACT_NATIVE", "ROKU", "UNITY", "KOTLIN_MULTIPLATFORM", "ELECTRON", "CPP", "MAUI", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum ViewEventSource {
        ANDROID("android"),
        IOS(CredentialsData.CREDENTIALS_TYPE_IOS),
        BROWSER("browser"),
        FLUTTER("flutter"),
        REACT_NATIVE("react-native"),
        ROKU("roku"),
        UNITY("unity"),
        KOTLIN_MULTIPLATFORM("kotlin-multiplatform"),
        ELECTRON("electron"),
        CPP("cpp"),
        MAUI("maui");


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String jsonValue;

        @JvmStatic
        public static final ViewEventSource fromJson(String str) {
            return INSTANCE.fromJson(str);
        }

        ViewEventSource(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$ViewEventSource$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$ViewEventSource;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final ViewEventSource fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (ViewEventSource viewEventSource : ViewEventSource.values()) {
                    if (Intrinsics.areEqual(viewEventSource.jsonValue, jsonString)) {
                        return viewEventSource;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$ViewEventSessionType;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "USER", "SYNTHETICS", "CI_TEST", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum ViewEventSessionType {
        USER("user"),
        SYNTHETICS("synthetics"),
        CI_TEST("ci_test");


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String jsonValue;

        @JvmStatic
        public static final ViewEventSessionType fromJson(String str) {
            return INSTANCE.fromJson(str);
        }

        ViewEventSessionType(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$ViewEventSessionType$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$ViewEventSessionType;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final ViewEventSessionType fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (ViewEventSessionType viewEventSessionType : ViewEventSessionType.values()) {
                    if (Intrinsics.areEqual(viewEventSessionType.jsonValue, jsonString)) {
                        return viewEventSessionType;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$LoadingType;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "INITIAL_LOAD", "ROUTE_CHANGE", "ACTIVITY_DISPLAY", "ACTIVITY_REDISPLAY", "FRAGMENT_DISPLAY", "FRAGMENT_REDISPLAY", "VIEW_CONTROLLER_DISPLAY", "VIEW_CONTROLLER_REDISPLAY", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum LoadingType {
        INITIAL_LOAD("initial_load"),
        ROUTE_CHANGE("route_change"),
        ACTIVITY_DISPLAY("activity_display"),
        ACTIVITY_REDISPLAY("activity_redisplay"),
        FRAGMENT_DISPLAY("fragment_display"),
        FRAGMENT_REDISPLAY("fragment_redisplay"),
        VIEW_CONTROLLER_DISPLAY("view_controller_display"),
        VIEW_CONTROLLER_REDISPLAY("view_controller_redisplay");


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String jsonValue;

        @JvmStatic
        public static final LoadingType fromJson(String str) {
            return INSTANCE.fromJson(str);
        }

        LoadingType(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$LoadingType$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$LoadingType;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final LoadingType fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (LoadingType loadingType : LoadingType.values()) {
                    if (Intrinsics.areEqual(loadingType.jsonValue, jsonString)) {
                        return loadingType;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$ConnectivityStatus;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "CONNECTED", "NOT_CONNECTED", "MAYBE", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum ConnectivityStatus {
        CONNECTED("connected"),
        NOT_CONNECTED("not_connected"),
        MAYBE("maybe");


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String jsonValue;

        @JvmStatic
        public static final ConnectivityStatus fromJson(String str) {
            return INSTANCE.fromJson(str);
        }

        ConnectivityStatus(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$ConnectivityStatus$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$ConnectivityStatus;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final ConnectivityStatus fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (ConnectivityStatus connectivityStatus : ConnectivityStatus.values()) {
                    if (Intrinsics.areEqual(connectivityStatus.jsonValue, jsonString)) {
                        return connectivityStatus;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Interface;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "BLUETOOTH", "CELLULAR", "ETHERNET", "WIFI", "WIMAX", "MIXED", "OTHER", "UNKNOWN", ProfilingConfig.PROFILING_DATADOG_PROFILER_LOG_LEVEL_DEFAULT, "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum Interface {
        BLUETOOTH("bluetooth"),
        CELLULAR("cellular"),
        ETHERNET("ethernet"),
        WIFI("wifi"),
        WIMAX("wimax"),
        MIXED("mixed"),
        OTHER("other"),
        UNKNOWN("unknown"),
        NONE("none");


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String jsonValue;

        @JvmStatic
        public static final Interface fromJson(String str) {
            return INSTANCE.fromJson(str);
        }

        Interface(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Interface$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$Interface;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Interface fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (Interface r2 : Interface.values()) {
                    if (Intrinsics.areEqual(r2.jsonValue, jsonString)) {
                        return r2;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$EffectiveType;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "SLOW_2G", "2G", "3G", "4G", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum EffectiveType {
        SLOW_2G("slow-2g"),
        f592G("2g"),
        f603G("3g"),
        f614G("4g");


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String jsonValue;

        @JvmStatic
        public static final EffectiveType fromJson(String str) {
            return INSTANCE.fromJson(str);
        }

        EffectiveType(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$EffectiveType$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$EffectiveType;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final EffectiveType fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (EffectiveType effectiveType : EffectiveType.values()) {
                    if (Intrinsics.areEqual(effectiveType.jsonValue, jsonString)) {
                        return effectiveType;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$DeviceType;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "MOBILE", "DESKTOP", "TABLET", "TV", "GAMING_CONSOLE", "BOT", "OTHER", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum DeviceType {
        MOBILE("mobile"),
        DESKTOP("desktop"),
        TABLET("tablet"),
        TV("tv"),
        GAMING_CONSOLE("gaming_console"),
        BOT("bot"),
        OTHER("other");


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String jsonValue;

        @JvmStatic
        public static final DeviceType fromJson(String str) {
            return INSTANCE.fromJson(str);
        }

        DeviceType(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$DeviceType$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$DeviceType;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final DeviceType fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (DeviceType deviceType : DeviceType.values()) {
                    if (Intrinsics.areEqual(deviceType.jsonValue, jsonString)) {
                        return deviceType;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$ReplayLevel;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "ALLOW", "MASK", "MASK_USER_INPUT", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum ReplayLevel {
        ALLOW(WebViewTracking.SESSION_REPLAY_MASK_NONE_PRIVACY),
        MASK(WebViewTracking.SESSION_REPLAY_MASK_ALL_PRIVACY),
        MASK_USER_INPUT("mask-user-input");


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String jsonValue;

        @JvmStatic
        public static final ReplayLevel fromJson(String str) {
            return INSTANCE.fromJson(str);
        }

        ReplayLevel(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$ReplayLevel$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$ReplayLevel;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final ReplayLevel fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (ReplayLevel replayLevel : ReplayLevel.values()) {
                    if (Intrinsics.areEqual(replayLevel.jsonValue, jsonString)) {
                        return replayLevel;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Plan;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/Number;)V", "toJson", "Lcom/google/gson/JsonElement;", "PLAN_1", "PLAN_2", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum Plan {
        PLAN_1((Number) 1),
        PLAN_2((Number) 2);


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Number jsonValue;

        @JvmStatic
        public static final Plan fromJson(String str) {
            return INSTANCE.fromJson(str);
        }

        Plan(Number number) {
            this.jsonValue = number;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$Plan$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$Plan;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Plan fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (Plan plan : Plan.values()) {
                    if (Intrinsics.areEqual(plan.jsonValue.toString(), jsonString)) {
                        return plan;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$SessionPrecondition;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "USER_APP_LAUNCH", "INACTIVITY_TIMEOUT", "MAX_DURATION", "BACKGROUND_LAUNCH", "PREWARM", "FROM_NON_INTERACTIVE_SESSION", "EXPLICIT_STOP", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum SessionPrecondition {
        USER_APP_LAUNCH("user_app_launch"),
        INACTIVITY_TIMEOUT("inactivity_timeout"),
        MAX_DURATION(DefaultUISlownessMetricDispatcher.KEY_MAX_DURATION),
        BACKGROUND_LAUNCH("background_launch"),
        PREWARM("prewarm"),
        FROM_NON_INTERACTIVE_SESSION("from_non_interactive_session"),
        EXPLICIT_STOP("explicit_stop");


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String jsonValue;

        @JvmStatic
        public static final SessionPrecondition fromJson(String str) {
            return INSTANCE.fromJson(str);
        }

        SessionPrecondition(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$SessionPrecondition$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$SessionPrecondition;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final SessionPrecondition fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (SessionPrecondition sessionPrecondition : SessionPrecondition.values()) {
                    if (Intrinsics.areEqual(sessionPrecondition.jsonValue, jsonString)) {
                        return sessionPrecondition;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$State;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "ACTIVE", "PASSIVE", "HIDDEN", "FROZEN", "TERMINATED", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum State {
        ACTIVE("active"),
        PASSIVE("passive"),
        HIDDEN(ViewProps.HIDDEN),
        FROZEN("frozen"),
        TERMINATED("terminated");


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String jsonValue;

        @JvmStatic
        public static final State fromJson(String str) {
            return INSTANCE.fromJson(str);
        }

        State(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$State$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$State;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final State fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (State state : State.values()) {
                    if (Intrinsics.areEqual(state.jsonValue, jsonString)) {
                        return state;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$ProfilingStatus;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "STARTING", DebugCoroutineInfoImplKt.RUNNING, "STOPPED", MediaError.ERROR_TYPE_ERROR, "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum ProfilingStatus {
        STARTING("starting"),
        RUNNING("running"),
        STOPPED("stopped"),
        ERROR("error");


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String jsonValue;

        @JvmStatic
        public static final ProfilingStatus fromJson(String str) {
            return INSTANCE.fromJson(str);
        }

        ProfilingStatus(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$ProfilingStatus$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$ProfilingStatus;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final ProfilingStatus fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (ProfilingStatus profilingStatus : ProfilingStatus.values()) {
                    if (Intrinsics.areEqual(profilingStatus.jsonValue, jsonString)) {
                        return profilingStatus;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    /* JADX INFO: compiled from: ViewEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$ErrorReason;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "NOT_SUPPORTED_BY_BROWSER", "FAILED_TO_LAZY_LOAD", "MISSING_DOCUMENT_POLICY_HEADER", "UNEXPECTED_EXCEPTION", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum ErrorReason {
        NOT_SUPPORTED_BY_BROWSER("not-supported-by-browser"),
        FAILED_TO_LAZY_LOAD("failed-to-lazy-load"),
        MISSING_DOCUMENT_POLICY_HEADER("missing-document-policy-header"),
        UNEXPECTED_EXCEPTION("unexpected-exception");


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String jsonValue;

        @JvmStatic
        public static final ErrorReason fromJson(String str) {
            return INSTANCE.fromJson(str);
        }

        ErrorReason(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        /* JADX INFO: compiled from: ViewEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/model/ViewEvent$ErrorReason$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/ViewEvent$ErrorReason;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final ErrorReason fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (ErrorReason errorReason : ErrorReason.values()) {
                    if (Intrinsics.areEqual(errorReason.jsonValue, jsonString)) {
                        return errorReason;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }
}

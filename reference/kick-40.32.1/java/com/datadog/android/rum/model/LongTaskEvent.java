package com.datadog.android.rum.model;

import androidx.compose.material3.internal.TextFieldImplKt;
import com.datadog.android.core.internal.utils.JsonSerializer;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.rum.internal.domain.scope.RumSessionScope;
import com.datadog.android.rum.internal.metric.slowframes.DefaultUISlownessMetricDispatcher;
import com.datadog.android.webview.internal.rum.WebViewRumEventMapper;
import com.datadog.trace.api.config.ProfilingConfig;
import com.facebook.hermes.intl.Constants;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.cast.CredentialsData;
import com.google.android.gms.cast.MediaError;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.useinsider.insiderhybrid.constants.InsiderHybridMethods;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;

/* JADX INFO: compiled from: LongTaskEvent.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bL\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b(\b\u0086\b\u0018\u0000 \u0088\u00012\u00020\u0001:L\u0083\u0001\u0084\u0001\u0085\u0001\u0086\u0001\u0087\u0001\u0088\u0001\u0089\u0001\u008a\u0001\u008b\u0001\u008c\u0001\u008d\u0001\u008e\u0001\u008f\u0001\u0090\u0001\u0091\u0001\u0092\u0001\u0093\u0001\u0094\u0001\u0095\u0001\u0096\u0001\u0097\u0001\u0098\u0001\u0099\u0001\u009a\u0001\u009b\u0001\u009c\u0001\u009d\u0001\u009e\u0001\u009f\u0001 \u0001¡\u0001¢\u0001£\u0001¤\u0001¥\u0001¦\u0001§\u0001¨\u0001B\u0099\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#\u0012\u0006\u0010$\u001a\u00020%\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-\u0012\u0006\u0010.\u001a\u00020/¢\u0006\u0002\u00100J\t\u0010a\u001a\u00020\u0003HÆ\u0003J\t\u0010b\u001a\u00020\u0011HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010!HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010#HÆ\u0003J\t\u0010l\u001a\u00020\u0005HÆ\u0003J\t\u0010m\u001a\u00020%HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010'HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010)HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010+HÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010-HÆ\u0003J\t\u0010r\u001a\u00020/HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010u\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010x\u001a\u00020\rHÆ\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\u000fHÆ\u0003J©\u0002\u0010z\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010$\u001a\u00020%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-2\b\b\u0002\u0010.\u001a\u00020/HÆ\u0001J\u0013\u0010{\u001a\u00020|2\b\u0010}\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010~\u001a\u00020\u007fHÖ\u0001J\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001J\n\u0010\u0082\u0001\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010*\u001a\u0004\u0018\u00010+¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b9\u00108R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0013\u0010,\u001a\u0004\u0018\u00010-¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0013\u0010&\u001a\u0004\u0018\u00010'¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0011\u0010$\u001a\u00020%¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bF\u00108R\u0013\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0011\u0010.\u001a\u00020/¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0013\u0010 \u001a\u0004\u0018\u00010!¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bO\u00108R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u0013\u0010(\u001a\u0004\u0018\u00010)¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\bX\u0010YR\u0014\u0010Z\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b[\u00108R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b^\u00108R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b_\u0010`¨\u0006©\u0001"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent;", "", "date", "", "application", "Lcom/datadog/android/rum/model/LongTaskEvent$Application;", "service", "", "version", "buildVersion", "buildId", "ddtags", "session", "Lcom/datadog/android/rum/model/LongTaskEvent$LongTaskEventSession;", "source", "Lcom/datadog/android/rum/model/LongTaskEvent$LongTaskEventSource;", "view", "Lcom/datadog/android/rum/model/LongTaskEvent$LongTaskEventView;", "usr", "Lcom/datadog/android/rum/model/LongTaskEvent$Usr;", "account", "Lcom/datadog/android/rum/model/LongTaskEvent$Account;", "tab", "Lcom/datadog/android/rum/model/LongTaskEvent$Tab;", "connectivity", "Lcom/datadog/android/rum/model/LongTaskEvent$Connectivity;", "display", "Lcom/datadog/android/rum/model/LongTaskEvent$Display;", "synthetics", "Lcom/datadog/android/rum/model/LongTaskEvent$Synthetics;", "ciTest", "Lcom/datadog/android/rum/model/LongTaskEvent$CiTest;", "os", "Lcom/datadog/android/rum/model/LongTaskEvent$Os;", "device", "Lcom/datadog/android/rum/model/LongTaskEvent$Device;", "dd", "Lcom/datadog/android/rum/model/LongTaskEvent$Dd;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/rum/model/LongTaskEvent$Context;", "stream", "Lcom/datadog/android/rum/model/LongTaskEvent$Stream;", "action", "Lcom/datadog/android/rum/model/LongTaskEvent$Action;", WebViewRumEventMapper.CONTAINER_KEY_NAME, "Lcom/datadog/android/rum/model/LongTaskEvent$Container;", "longTask", "Lcom/datadog/android/rum/model/LongTaskEvent$LongTask;", "(JLcom/datadog/android/rum/model/LongTaskEvent$Application;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/datadog/android/rum/model/LongTaskEvent$LongTaskEventSession;Lcom/datadog/android/rum/model/LongTaskEvent$LongTaskEventSource;Lcom/datadog/android/rum/model/LongTaskEvent$LongTaskEventView;Lcom/datadog/android/rum/model/LongTaskEvent$Usr;Lcom/datadog/android/rum/model/LongTaskEvent$Account;Lcom/datadog/android/rum/model/LongTaskEvent$Tab;Lcom/datadog/android/rum/model/LongTaskEvent$Connectivity;Lcom/datadog/android/rum/model/LongTaskEvent$Display;Lcom/datadog/android/rum/model/LongTaskEvent$Synthetics;Lcom/datadog/android/rum/model/LongTaskEvent$CiTest;Lcom/datadog/android/rum/model/LongTaskEvent$Os;Lcom/datadog/android/rum/model/LongTaskEvent$Device;Lcom/datadog/android/rum/model/LongTaskEvent$Dd;Lcom/datadog/android/rum/model/LongTaskEvent$Context;Lcom/datadog/android/rum/model/LongTaskEvent$Stream;Lcom/datadog/android/rum/model/LongTaskEvent$Action;Lcom/datadog/android/rum/model/LongTaskEvent$Container;Lcom/datadog/android/rum/model/LongTaskEvent$LongTask;)V", "getAccount", "()Lcom/datadog/android/rum/model/LongTaskEvent$Account;", "getAction", "()Lcom/datadog/android/rum/model/LongTaskEvent$Action;", "getApplication", "()Lcom/datadog/android/rum/model/LongTaskEvent$Application;", "getBuildId", "()Ljava/lang/String;", "getBuildVersion", "getCiTest", "()Lcom/datadog/android/rum/model/LongTaskEvent$CiTest;", "getConnectivity", "()Lcom/datadog/android/rum/model/LongTaskEvent$Connectivity;", "getContainer", "()Lcom/datadog/android/rum/model/LongTaskEvent$Container;", "getContext", "()Lcom/datadog/android/rum/model/LongTaskEvent$Context;", "getDate", "()J", "getDd", "()Lcom/datadog/android/rum/model/LongTaskEvent$Dd;", "getDdtags", "getDevice", "()Lcom/datadog/android/rum/model/LongTaskEvent$Device;", "getDisplay", "()Lcom/datadog/android/rum/model/LongTaskEvent$Display;", "getLongTask", "()Lcom/datadog/android/rum/model/LongTaskEvent$LongTask;", "getOs", "()Lcom/datadog/android/rum/model/LongTaskEvent$Os;", "getService", "getSession", "()Lcom/datadog/android/rum/model/LongTaskEvent$LongTaskEventSession;", "getSource", "()Lcom/datadog/android/rum/model/LongTaskEvent$LongTaskEventSource;", "getStream", "()Lcom/datadog/android/rum/model/LongTaskEvent$Stream;", "getSynthetics", "()Lcom/datadog/android/rum/model/LongTaskEvent$Synthetics;", "getTab", "()Lcom/datadog/android/rum/model/LongTaskEvent$Tab;", "type", "getType", "getUsr", "()Lcom/datadog/android/rum/model/LongTaskEvent$Usr;", "getVersion", "getView", "()Lcom/datadog/android/rum/model/LongTaskEvent$LongTaskEventView;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Account", "Action", "Application", "Cellular", "CiTest", "Companion", "Configuration", "Connectivity", "ConnectivityStatus", TextFieldImplKt.ContainerId, "ContainerView", "Context", "Dd", "DdSession", "Device", "DeviceType", "Display", "EffectiveType", "EntryType", "ErrorReason", "Interface", "InvokerType", "LongTask", "LongTaskEventSession", "LongTaskEventSessionType", "LongTaskEventSource", "LongTaskEventView", "Os", "Plan", "Profiling", "ProfilingStatus", "Script", "SessionPrecondition", "Stream", "Synthetics", "Tab", "Usr", "Viewport", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class LongTaskEvent {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Account account;
    private final Action action;
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
    private final LongTask longTask;
    private final Os os;
    private final String service;
    private final LongTaskEventSession session;
    private final LongTaskEventSource source;
    private final Stream stream;
    private final Synthetics synthetics;
    private final Tab tab;
    private final String type;
    private final Usr usr;
    private final String version;
    private final LongTaskEventView view;

    public static /* synthetic */ LongTaskEvent copy$default(LongTaskEvent longTaskEvent, long j, Application application, String str, String str2, String str3, String str4, String str5, LongTaskEventSession longTaskEventSession, LongTaskEventSource longTaskEventSource, LongTaskEventView longTaskEventView, Usr usr, Account account, Tab tab, Connectivity connectivity, Display display, Synthetics synthetics, CiTest ciTest, Os os, Device device, Dd dd, Context context, Stream stream, Action action, Container container, LongTask longTask, int i, Object obj) {
        LongTask longTask2;
        Container container2;
        long j2 = (i & 1) != 0 ? longTaskEvent.date : j;
        Application application2 = (i & 2) != 0 ? longTaskEvent.application : application;
        String str6 = (i & 4) != 0 ? longTaskEvent.service : str;
        String str7 = (i & 8) != 0 ? longTaskEvent.version : str2;
        String str8 = (i & 16) != 0 ? longTaskEvent.buildVersion : str3;
        String str9 = (i & 32) != 0 ? longTaskEvent.buildId : str4;
        String str10 = (i & 64) != 0 ? longTaskEvent.ddtags : str5;
        LongTaskEventSession longTaskEventSession2 = (i & 128) != 0 ? longTaskEvent.session : longTaskEventSession;
        LongTaskEventSource longTaskEventSource2 = (i & 256) != 0 ? longTaskEvent.source : longTaskEventSource;
        LongTaskEventView longTaskEventView2 = (i & 512) != 0 ? longTaskEvent.view : longTaskEventView;
        Usr usr2 = (i & 1024) != 0 ? longTaskEvent.usr : usr;
        Account account2 = (i & 2048) != 0 ? longTaskEvent.account : account;
        Tab tab2 = (i & 4096) != 0 ? longTaskEvent.tab : tab;
        long j3 = j2;
        Connectivity connectivity2 = (i & 8192) != 0 ? longTaskEvent.connectivity : connectivity;
        Display display2 = (i & 16384) != 0 ? longTaskEvent.display : display;
        Synthetics synthetics2 = (i & 32768) != 0 ? longTaskEvent.synthetics : synthetics;
        CiTest ciTest2 = (i & 65536) != 0 ? longTaskEvent.ciTest : ciTest;
        Os os2 = (i & 131072) != 0 ? longTaskEvent.os : os;
        Device device2 = (i & 262144) != 0 ? longTaskEvent.device : device;
        Dd dd2 = (i & 524288) != 0 ? longTaskEvent.dd : dd;
        Context context2 = (i & 1048576) != 0 ? longTaskEvent.context : context;
        Stream stream2 = (i & 2097152) != 0 ? longTaskEvent.stream : stream;
        Action action2 = (i & 4194304) != 0 ? longTaskEvent.action : action;
        Container container3 = (i & 8388608) != 0 ? longTaskEvent.container : container;
        if ((i & 16777216) != 0) {
            container2 = container3;
            longTask2 = longTaskEvent.longTask;
        } else {
            longTask2 = longTask;
            container2 = container3;
        }
        return longTaskEvent.copy(j3, application2, str6, str7, str8, str9, str10, longTaskEventSession2, longTaskEventSource2, longTaskEventView2, usr2, account2, tab2, connectivity2, display2, synthetics2, ciTest2, os2, device2, dd2, context2, stream2, action2, container2, longTask2);
    }

    @JvmStatic
    public static final LongTaskEvent fromJson(String str) throws JsonParseException {
        return INSTANCE.fromJson(str);
    }

    @JvmStatic
    public static final LongTaskEvent fromJsonObject(JsonObject jsonObject) throws JsonParseException {
        return INSTANCE.fromJsonObject(jsonObject);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final LongTaskEventView getView() {
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
    public final Action getAction() {
        return this.action;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final Container getContainer() {
        return this.container;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final LongTask getLongTask() {
        return this.longTask;
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
    public final LongTaskEventSession getSession() {
        return this.session;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final LongTaskEventSource getSource() {
        return this.source;
    }

    public final LongTaskEvent copy(long date, Application application, String service, String version, String buildVersion, String buildId, String ddtags, LongTaskEventSession session, LongTaskEventSource source, LongTaskEventView view, Usr usr, Account account, Tab tab, Connectivity connectivity, Display display, Synthetics synthetics, CiTest ciTest, Os os, Device device, Dd dd, Context context, Stream stream, Action action, Container container, LongTask longTask) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dd, "dd");
        Intrinsics.checkNotNullParameter(longTask, "longTask");
        return new LongTaskEvent(date, application, service, version, buildVersion, buildId, ddtags, session, source, view, usr, account, tab, connectivity, display, synthetics, ciTest, os, device, dd, context, stream, action, container, longTask);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LongTaskEvent)) {
            return false;
        }
        LongTaskEvent longTaskEvent = (LongTaskEvent) other;
        return this.date == longTaskEvent.date && Intrinsics.areEqual(this.application, longTaskEvent.application) && Intrinsics.areEqual(this.service, longTaskEvent.service) && Intrinsics.areEqual(this.version, longTaskEvent.version) && Intrinsics.areEqual(this.buildVersion, longTaskEvent.buildVersion) && Intrinsics.areEqual(this.buildId, longTaskEvent.buildId) && Intrinsics.areEqual(this.ddtags, longTaskEvent.ddtags) && Intrinsics.areEqual(this.session, longTaskEvent.session) && this.source == longTaskEvent.source && Intrinsics.areEqual(this.view, longTaskEvent.view) && Intrinsics.areEqual(this.usr, longTaskEvent.usr) && Intrinsics.areEqual(this.account, longTaskEvent.account) && Intrinsics.areEqual(this.tab, longTaskEvent.tab) && Intrinsics.areEqual(this.connectivity, longTaskEvent.connectivity) && Intrinsics.areEqual(this.display, longTaskEvent.display) && Intrinsics.areEqual(this.synthetics, longTaskEvent.synthetics) && Intrinsics.areEqual(this.ciTest, longTaskEvent.ciTest) && Intrinsics.areEqual(this.os, longTaskEvent.os) && Intrinsics.areEqual(this.device, longTaskEvent.device) && Intrinsics.areEqual(this.dd, longTaskEvent.dd) && Intrinsics.areEqual(this.context, longTaskEvent.context) && Intrinsics.areEqual(this.stream, longTaskEvent.stream) && Intrinsics.areEqual(this.action, longTaskEvent.action) && Intrinsics.areEqual(this.container, longTaskEvent.container) && Intrinsics.areEqual(this.longTask, longTaskEvent.longTask);
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
        LongTaskEventSource longTaskEventSource = this.source;
        int iHashCode7 = (((iHashCode6 + (longTaskEventSource == null ? 0 : longTaskEventSource.hashCode())) * 31) + this.view.hashCode()) * 31;
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
        Action action = this.action;
        int iHashCode19 = (iHashCode18 + (action == null ? 0 : action.hashCode())) * 31;
        Container container = this.container;
        return ((iHashCode19 + (container != null ? container.hashCode() : 0)) * 31) + this.longTask.hashCode();
    }

    public String toString() {
        return "LongTaskEvent(date=" + this.date + ", application=" + this.application + ", service=" + this.service + ", version=" + this.version + ", buildVersion=" + this.buildVersion + ", buildId=" + this.buildId + ", ddtags=" + this.ddtags + ", session=" + this.session + ", source=" + this.source + ", view=" + this.view + ", usr=" + this.usr + ", account=" + this.account + ", tab=" + this.tab + ", connectivity=" + this.connectivity + ", display=" + this.display + ", synthetics=" + this.synthetics + ", ciTest=" + this.ciTest + ", os=" + this.os + ", device=" + this.device + ", dd=" + this.dd + ", context=" + this.context + ", stream=" + this.stream + ", action=" + this.action + ", container=" + this.container + ", longTask=" + this.longTask + ")";
    }

    public LongTaskEvent(long j, Application application, String str, String str2, String str3, String str4, String str5, LongTaskEventSession session, LongTaskEventSource longTaskEventSource, LongTaskEventView view, Usr usr, Account account, Tab tab, Connectivity connectivity, Display display, Synthetics synthetics, CiTest ciTest, Os os, Device device, Dd dd, Context context, Stream stream, Action action, Container container, LongTask longTask) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dd, "dd");
        Intrinsics.checkNotNullParameter(longTask, "longTask");
        this.date = j;
        this.application = application;
        this.service = str;
        this.version = str2;
        this.buildVersion = str3;
        this.buildId = str4;
        this.ddtags = str5;
        this.session = session;
        this.source = longTaskEventSource;
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
        this.action = action;
        this.container = container;
        this.longTask = longTask;
        this.type = "long_task";
    }

    public /* synthetic */ LongTaskEvent(long j, Application application, String str, String str2, String str3, String str4, String str5, LongTaskEventSession longTaskEventSession, LongTaskEventSource longTaskEventSource, LongTaskEventView longTaskEventView, Usr usr, Account account, Tab tab, Connectivity connectivity, Display display, Synthetics synthetics, CiTest ciTest, Os os, Device device, Dd dd, Context context, Stream stream, Action action, Container container, LongTask longTask, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, application, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, longTaskEventSession, (i & 256) != 0 ? null : longTaskEventSource, longTaskEventView, (i & 1024) != 0 ? null : usr, (i & 2048) != 0 ? null : account, (i & 4096) != 0 ? null : tab, (i & 8192) != 0 ? null : connectivity, (i & 16384) != 0 ? null : display, (32768 & i) != 0 ? null : synthetics, (65536 & i) != 0 ? null : ciTest, (131072 & i) != 0 ? null : os, (262144 & i) != 0 ? null : device, dd, (1048576 & i) != 0 ? null : context, (2097152 & i) != 0 ? null : stream, (4194304 & i) != 0 ? null : action, (i & 8388608) != 0 ? null : container, longTask);
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

    public final LongTaskEventSession getSession() {
        return this.session;
    }

    public final LongTaskEventSource getSource() {
        return this.source;
    }

    public final LongTaskEventView getView() {
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

    public final Action getAction() {
        return this.action;
    }

    public final Container getContainer() {
        return this.container;
    }

    public final LongTask getLongTask() {
        return this.longTask;
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
        LongTaskEventSource longTaskEventSource = this.source;
        if (longTaskEventSource != null) {
            jsonObject.add("source", longTaskEventSource.toJson());
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
        Action action = this.action;
        if (action != null) {
            jsonObject.add("action", action.toJson());
        }
        Container container = this.container;
        if (container != null) {
            jsonObject.add(WebViewRumEventMapper.CONTAINER_KEY_NAME, container.toJson());
        }
        jsonObject.addProperty("type", this.type);
        jsonObject.add("long_task", this.longTask.toJson());
        return jsonObject;
    }

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final LongTaskEvent fromJson(String jsonString) throws JsonParseException {
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            try {
                JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                return fromJsonObject(jsonObject);
            } catch (IllegalStateException e) {
                throw new JsonParseException("Unable to parse json into type LongTaskEvent", e);
            }
        }

        @JvmStatic
        public final LongTaskEvent fromJsonObject(JsonObject jsonObject) throws JsonParseException {
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
                LongTaskEventSession.Companion companion2 = LongTaskEventSession.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                LongTaskEventSession longTaskEventSessionFromJsonObject = companion2.fromJsonObject(it2);
                JsonElement jsonElement6 = jsonObject.get("source");
                LongTaskEventSource longTaskEventSourceFromJson = (jsonElement6 == null || (asString = jsonElement6.getAsString()) == null) ? null : LongTaskEventSource.INSTANCE.fromJson(asString);
                JsonObject it3 = jsonObject.get("view").getAsJsonObject();
                LongTaskEventView.Companion companion3 = LongTaskEventView.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it3, "it");
                LongTaskEventView longTaskEventViewFromJsonObject = companion3.fromJsonObject(it3);
                JsonElement jsonElement7 = jsonObject.get("usr");
                Usr usrFromJsonObject = (jsonElement7 == null || (asJsonObject13 = jsonElement7.getAsJsonObject()) == null) ? null : Usr.INSTANCE.fromJsonObject(asJsonObject13);
                JsonElement jsonElement8 = jsonObject.get("account");
                Account accountFromJsonObject = (jsonElement8 == null || (asJsonObject12 = jsonElement8.getAsJsonObject()) == null) ? null : Account.INSTANCE.fromJsonObject(asJsonObject12);
                JsonElement jsonElement9 = jsonObject.get("tab");
                Tab tabFromJsonObject = (jsonElement9 == null || (asJsonObject11 = jsonElement9.getAsJsonObject()) == null) ? null : Tab.INSTANCE.fromJsonObject(asJsonObject11);
                JsonElement jsonElement10 = jsonObject.get("connectivity");
                Connectivity connectivityFromJsonObject = (jsonElement10 == null || (asJsonObject10 = jsonElement10.getAsJsonObject()) == null) ? null : Connectivity.INSTANCE.fromJsonObject(asJsonObject10);
                JsonElement jsonElement11 = jsonObject.get("display");
                Display displayFromJsonObject = (jsonElement11 == null || (asJsonObject9 = jsonElement11.getAsJsonObject()) == null) ? null : Display.INSTANCE.fromJsonObject(asJsonObject9);
                JsonElement jsonElement12 = jsonObject.get("synthetics");
                Synthetics syntheticsFromJsonObject = (jsonElement12 == null || (asJsonObject8 = jsonElement12.getAsJsonObject()) == null) ? null : Synthetics.INSTANCE.fromJsonObject(asJsonObject8);
                JsonElement jsonElement13 = jsonObject.get("ci_test");
                CiTest ciTestFromJsonObject = (jsonElement13 == null || (asJsonObject7 = jsonElement13.getAsJsonObject()) == null) ? null : CiTest.INSTANCE.fromJsonObject(asJsonObject7);
                JsonElement jsonElement14 = jsonObject.get("os");
                Os osFromJsonObject = (jsonElement14 == null || (asJsonObject6 = jsonElement14.getAsJsonObject()) == null) ? null : Os.INSTANCE.fromJsonObject(asJsonObject6);
                JsonElement jsonElement15 = jsonObject.get("device");
                Device deviceFromJsonObject = (jsonElement15 == null || (asJsonObject5 = jsonElement15.getAsJsonObject()) == null) ? null : Device.INSTANCE.fromJsonObject(asJsonObject5);
                JsonObject it4 = jsonObject.get(WebViewRumEventMapper.DD_KEY_NAME).getAsJsonObject();
                Dd.Companion companion4 = Dd.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it4, "it");
                Dd ddFromJsonObject = companion4.fromJsonObject(it4);
                JsonElement jsonElement16 = jsonObject.get(RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX);
                Context contextFromJsonObject = (jsonElement16 == null || (asJsonObject4 = jsonElement16.getAsJsonObject()) == null) ? null : Context.INSTANCE.fromJsonObject(asJsonObject4);
                JsonElement jsonElement17 = jsonObject.get("stream");
                Stream streamFromJsonObject = (jsonElement17 == null || (asJsonObject3 = jsonElement17.getAsJsonObject()) == null) ? null : Stream.INSTANCE.fromJsonObject(asJsonObject3);
                JsonElement jsonElement18 = jsonObject.get("action");
                Action actionFromJsonObject = (jsonElement18 == null || (asJsonObject2 = jsonElement18.getAsJsonObject()) == null) ? null : Action.INSTANCE.fromJsonObject(asJsonObject2);
                JsonElement jsonElement19 = jsonObject.get(WebViewRumEventMapper.CONTAINER_KEY_NAME);
                Container containerFromJsonObject = (jsonElement19 == null || (asJsonObject = jsonElement19.getAsJsonObject()) == null) ? null : Container.INSTANCE.fromJsonObject(asJsonObject);
                String asString7 = jsonObject.get("type").getAsString();
                JsonObject it5 = jsonObject.get("long_task").getAsJsonObject();
                LongTask.Companion companion5 = LongTask.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                LongTask longTaskFromJsonObject = companion5.fromJsonObject(it5);
                if (!Intrinsics.areEqual(asString7, "long_task")) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                return new LongTaskEvent(asLong, applicationFromJsonObject, asString2, asString3, asString4, asString5, asString6, longTaskEventSessionFromJsonObject, longTaskEventSourceFromJson, longTaskEventViewFromJsonObject, usrFromJsonObject, accountFromJsonObject, tabFromJsonObject, connectivityFromJsonObject, displayFromJsonObject, syntheticsFromJsonObject, ciTestFromJsonObject, osFromJsonObject, deviceFromJsonObject, ddFromJsonObject, contextFromJsonObject, streamFromJsonObject, actionFromJsonObject, containerFromJsonObject, longTaskFromJsonObject);
            } catch (IllegalStateException e) {
                throw new JsonParseException("Unable to parse json into type LongTaskEvent", e);
            } catch (NullPointerException e2) {
                throw new JsonParseException("Unable to parse json into type LongTaskEvent", e2);
            } catch (NumberFormatException e3) {
                throw new JsonParseException("Unable to parse json into type LongTaskEvent", e3);
            }
        }
    }

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Application;", "", "id", "", "currentLocale", "(Ljava/lang/String;Ljava/lang/String;)V", "getCurrentLocale", "()Ljava/lang/String;", "getId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: LongTaskEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Application$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent$Application;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\nJ.\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0006\u0010\u0019\u001a\u00020\u001aJ\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$LongTaskEventSession;", "", "id", "", "type", "Lcom/datadog/android/rum/model/LongTaskEvent$LongTaskEventSessionType;", "hasReplay", "", "(Ljava/lang/String;Lcom/datadog/android/rum/model/LongTaskEvent$LongTaskEventSessionType;Ljava/lang/Boolean;)V", "getHasReplay", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getId", "()Ljava/lang/String;", "getType", "()Lcom/datadog/android/rum/model/LongTaskEvent$LongTaskEventSessionType;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Lcom/datadog/android/rum/model/LongTaskEvent$LongTaskEventSessionType;Ljava/lang/Boolean;)Lcom/datadog/android/rum/model/LongTaskEvent$LongTaskEventSession;", "equals", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class LongTaskEventSession {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Boolean hasReplay;
        private final String id;
        private final LongTaskEventSessionType type;

        public static /* synthetic */ LongTaskEventSession copy$default(LongTaskEventSession longTaskEventSession, String str, LongTaskEventSessionType longTaskEventSessionType, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                str = longTaskEventSession.id;
            }
            if ((i & 2) != 0) {
                longTaskEventSessionType = longTaskEventSession.type;
            }
            if ((i & 4) != 0) {
                bool = longTaskEventSession.hasReplay;
            }
            return longTaskEventSession.copy(str, longTaskEventSessionType, bool);
        }

        @JvmStatic
        public static final LongTaskEventSession fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final LongTaskEventSession fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final LongTaskEventSessionType getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Boolean getHasReplay() {
            return this.hasReplay;
        }

        public final LongTaskEventSession copy(String id, LongTaskEventSessionType type, Boolean hasReplay) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            return new LongTaskEventSession(id, type, hasReplay);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LongTaskEventSession)) {
                return false;
            }
            LongTaskEventSession longTaskEventSession = (LongTaskEventSession) other;
            return Intrinsics.areEqual(this.id, longTaskEventSession.id) && this.type == longTaskEventSession.type && Intrinsics.areEqual(this.hasReplay, longTaskEventSession.hasReplay);
        }

        public int hashCode() {
            int iHashCode = ((this.id.hashCode() * 31) + this.type.hashCode()) * 31;
            Boolean bool = this.hasReplay;
            return iHashCode + (bool == null ? 0 : bool.hashCode());
        }

        public String toString() {
            return "LongTaskEventSession(id=" + this.id + ", type=" + this.type + ", hasReplay=" + this.hasReplay + ")";
        }

        public LongTaskEventSession(String id, LongTaskEventSessionType type, Boolean bool) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            this.id = id;
            this.type = type;
            this.hasReplay = bool;
        }

        public /* synthetic */ LongTaskEventSession(String str, LongTaskEventSessionType longTaskEventSessionType, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, longTaskEventSessionType, (i & 4) != 0 ? null : bool);
        }

        public final String getId() {
            return this.id;
        }

        public final LongTaskEventSessionType getType() {
            return this.type;
        }

        public final Boolean getHasReplay() {
            return this.hasReplay;
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
            return jsonObject;
        }

        /* JADX INFO: compiled from: LongTaskEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$LongTaskEventSession$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent$LongTaskEventSession;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final LongTaskEventSession fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type LongTaskEventSession", e);
                }
            }

            @JvmStatic
            public final LongTaskEventSession fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String id = jsonObject.get("id").getAsString();
                    LongTaskEventSessionType.Companion companion = LongTaskEventSessionType.INSTANCE;
                    String asString = jsonObject.get("type").getAsString();
                    Intrinsics.checkNotNullExpressionValue(asString, "jsonObject.get(\"type\").asString");
                    LongTaskEventSessionType longTaskEventSessionTypeFromJson = companion.fromJson(asString);
                    JsonElement jsonElement = jsonObject.get("has_replay");
                    Boolean boolValueOf = jsonElement != null ? Boolean.valueOf(jsonElement.getAsBoolean()) : null;
                    Intrinsics.checkNotNullExpressionValue(id, "id");
                    return new LongTaskEventSession(id, longTaskEventSessionTypeFromJson, boolValueOf);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type LongTaskEventSession", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type LongTaskEventSession", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type LongTaskEventSession", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J5\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0006\u0010\u001b\u001a\u00020\u001cJ\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\t\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$LongTaskEventView;", "", "id", "", "referrer", ImagesContract.URL, "name", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", InsiderHybridMethods.SET_NAME, "(Ljava/lang/String;)V", "getReferrer", "setReferrer", "getUrl", "setUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class LongTaskEventView {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String id;
        private String name;
        private String referrer;
        private String url;

        public static /* synthetic */ LongTaskEventView copy$default(LongTaskEventView longTaskEventView, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = longTaskEventView.id;
            }
            if ((i & 2) != 0) {
                str2 = longTaskEventView.referrer;
            }
            if ((i & 4) != 0) {
                str3 = longTaskEventView.url;
            }
            if ((i & 8) != 0) {
                str4 = longTaskEventView.name;
            }
            return longTaskEventView.copy(str, str2, str3, str4);
        }

        @JvmStatic
        public static final LongTaskEventView fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final LongTaskEventView fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getReferrer() {
            return this.referrer;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final LongTaskEventView copy(String id, String referrer, String url, String name) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(url, "url");
            return new LongTaskEventView(id, referrer, url, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LongTaskEventView)) {
                return false;
            }
            LongTaskEventView longTaskEventView = (LongTaskEventView) other;
            return Intrinsics.areEqual(this.id, longTaskEventView.id) && Intrinsics.areEqual(this.referrer, longTaskEventView.referrer) && Intrinsics.areEqual(this.url, longTaskEventView.url) && Intrinsics.areEqual(this.name, longTaskEventView.name);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.referrer;
            int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.url.hashCode()) * 31;
            String str2 = this.name;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "LongTaskEventView(id=" + this.id + ", referrer=" + this.referrer + ", url=" + this.url + ", name=" + this.name + ")";
        }

        public LongTaskEventView(String id, String str, String url, String str2) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(url, "url");
            this.id = id;
            this.referrer = str;
            this.url = url;
            this.name = str2;
        }

        public /* synthetic */ LongTaskEventView(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, str3, (i & 8) != 0 ? null : str4);
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
            return jsonObject;
        }

        /* JADX INFO: compiled from: LongTaskEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$LongTaskEventView$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent$LongTaskEventView;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final LongTaskEventView fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type LongTaskEventView", e);
                }
            }

            @JvmStatic
            public final LongTaskEventView fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String id = jsonObject.get("id").getAsString();
                    JsonElement jsonElement = jsonObject.get("referrer");
                    String asString = jsonElement != null ? jsonElement.getAsString() : null;
                    String url = jsonObject.get(ImagesContract.URL).getAsString();
                    JsonElement jsonElement2 = jsonObject.get("name");
                    String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
                    Intrinsics.checkNotNullExpressionValue(id, "id");
                    Intrinsics.checkNotNullExpressionValue(url, "url");
                    return new LongTaskEventView(id, asString, url, asString2);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type LongTaskEventView", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type LongTaskEventView", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type LongTaskEventView", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fBM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bHÆ\u0003JQ\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0006\u0010\u001c\u001a\u00020\u001dJ\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006 "}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Usr;", "", "id", "", "name", "email", "anonymousId", "additionalProperties", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getAdditionalProperties", "()Ljava/util/Map;", "getAnonymousId", "()Ljava/lang/String;", "getEmail", "getId", "getName", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: LongTaskEvent.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0007J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Usr$Companion;", "", "()V", "RESERVED_PROPERTIES", "", "", "getRESERVED_PROPERTIES$dd_sdk_android_rum_release", "()[Ljava/lang/String;", "[Ljava/lang/String;", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent$Usr;", "jsonString", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006HÆ\u0003J7\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0006\u0010\u0016\u001a\u00020\u0017J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Account;", "", "id", "", "name", "additionalProperties", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getAdditionalProperties", "()Ljava/util/Map;", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: LongTaskEvent.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0007J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Account$Companion;", "", "()V", "RESERVED_PROPERTIES", "", "", "getRESERVED_PROPERTIES$dd_sdk_android_rum_release", "()[Ljava/lang/String;", "[Ljava/lang/String;", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent$Account;", "jsonString", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Tab;", "", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: LongTaskEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Tab$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent$Tab;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\nHÆ\u0003J=\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0006\u0010\u001e\u001a\u00020\u001fJ\t\u0010 \u001a\u00020!HÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006#"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Connectivity;", "", "status", "Lcom/datadog/android/rum/model/LongTaskEvent$ConnectivityStatus;", "interfaces", "", "Lcom/datadog/android/rum/model/LongTaskEvent$Interface;", "effectiveType", "Lcom/datadog/android/rum/model/LongTaskEvent$EffectiveType;", "cellular", "Lcom/datadog/android/rum/model/LongTaskEvent$Cellular;", "(Lcom/datadog/android/rum/model/LongTaskEvent$ConnectivityStatus;Ljava/util/List;Lcom/datadog/android/rum/model/LongTaskEvent$EffectiveType;Lcom/datadog/android/rum/model/LongTaskEvent$Cellular;)V", "getCellular", "()Lcom/datadog/android/rum/model/LongTaskEvent$Cellular;", "getEffectiveType", "()Lcom/datadog/android/rum/model/LongTaskEvent$EffectiveType;", "getInterfaces", "()Ljava/util/List;", "getStatus", "()Lcom/datadog/android/rum/model/LongTaskEvent$ConnectivityStatus;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: LongTaskEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Connectivity$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent$Connectivity;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Display;", "", "viewport", "Lcom/datadog/android/rum/model/LongTaskEvent$Viewport;", "(Lcom/datadog/android/rum/model/LongTaskEvent$Viewport;)V", "getViewport", "()Lcom/datadog/android/rum/model/LongTaskEvent$Viewport;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Display {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Viewport viewport;

        /* JADX WARN: Multi-variable type inference failed */
        public Display() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Display copy$default(Display display, Viewport viewport, int i, Object obj) {
            if ((i & 1) != 0) {
                viewport = display.viewport;
            }
            return display.copy(viewport);
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

        public final Display copy(Viewport viewport) {
            return new Display(viewport);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Display) && Intrinsics.areEqual(this.viewport, ((Display) other).viewport);
        }

        public int hashCode() {
            Viewport viewport = this.viewport;
            if (viewport == null) {
                return 0;
            }
            return viewport.hashCode();
        }

        public String toString() {
            return "Display(viewport=" + this.viewport + ")";
        }

        public Display(Viewport viewport) {
            this.viewport = viewport;
        }

        public /* synthetic */ Display(Viewport viewport, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : viewport);
        }

        public final Viewport getViewport() {
            return this.viewport;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            Viewport viewport = this.viewport;
            if (viewport != null) {
                jsonObject.add("viewport", viewport.toJson());
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: LongTaskEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Display$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent$Display;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get("viewport");
                    return new Display((jsonElement == null || (asJsonObject = jsonElement.getAsJsonObject()) == null) ? null : Viewport.INSTANCE.fromJsonObject(asJsonObject));
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

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\u0017\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bHÆ\u0003JF\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0006\u0010\u001c\u001a\u00020\u001dJ\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006 "}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Synthetics;", "", "testId", "", "resultId", "injected", "", "additionalProperties", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Map;)V", "getAdditionalProperties", "()Ljava/util/Map;", "getInjected", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getResultId", "()Ljava/lang/String;", "getTestId", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Map;)Lcom/datadog/android/rum/model/LongTaskEvent$Synthetics;", "equals", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: LongTaskEvent.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0007J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Synthetics$Companion;", "", "()V", "RESERVED_PROPERTIES", "", "", "getRESERVED_PROPERTIES$dd_sdk_android_rum_release", "()[Ljava/lang/String;", "[Ljava/lang/String;", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent$Synthetics;", "jsonString", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$CiTest;", "", "testExecutionId", "", "(Ljava/lang/String;)V", "getTestExecutionId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: LongTaskEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$CiTest$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent$CiTest;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0006\u0010\u0017\u001a\u00020\u0018J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Os;", "", "name", "", "version", "build", "versionMajor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBuild", "()Ljava/lang/String;", "getName", "getVersion", "getVersionMajor", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: LongTaskEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Os$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent$Os;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u000b\n\u0002\b+\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 @2\u00020\u0001:\u0001@B³\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0015J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010+\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u000eHÆ\u0003J¼\u0001\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u00108J\u0013\u00109\u001a\u00020\u00102\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020<HÖ\u0001J\u0006\u0010=\u001a\u00020>J\t\u0010?\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u0014\u0010\u001cR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b$\u0010\u001cR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u0006A"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Device;", "", "type", "Lcom/datadog/android/rum/model/LongTaskEvent$DeviceType;", "name", "", "model", "brand", "architecture", Constants.LOCALE, "locales", "", "timeZone", "batteryLevel", "", "powerSavingMode", "", "brightnessLevel", "logicalCpuCount", "totalRam", "isLowRam", "(Lcom/datadog/android/rum/model/LongTaskEvent$DeviceType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Boolean;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Boolean;)V", "getArchitecture", "()Ljava/lang/String;", "getBatteryLevel", "()Ljava/lang/Number;", "getBrand", "getBrightnessLevel", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLocale", "getLocales", "()Ljava/util/List;", "getLogicalCpuCount", "getModel", "getName", "getPowerSavingMode", "getTimeZone", "getTotalRam", "getType", "()Lcom/datadog/android/rum/model/LongTaskEvent$DeviceType;", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/datadog/android/rum/model/LongTaskEvent$DeviceType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Boolean;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Boolean;)Lcom/datadog/android/rum/model/LongTaskEvent$Device;", "equals", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: LongTaskEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Device$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent$Device;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 -2\u00020\u0001:\u0001-BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010#\u001a\u0004\u0018\u00010\fHÆ\u0003JV\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020\n2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\u0006\u0010*\u001a\u00020+J\t\u0010,\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u0016X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006."}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Dd;", "", "session", "Lcom/datadog/android/rum/model/LongTaskEvent$DdSession;", "configuration", "Lcom/datadog/android/rum/model/LongTaskEvent$Configuration;", "browserSdkVersion", "", "sdkName", "discarded", "", "profiling", "Lcom/datadog/android/rum/model/LongTaskEvent$Profiling;", "(Lcom/datadog/android/rum/model/LongTaskEvent$DdSession;Lcom/datadog/android/rum/model/LongTaskEvent$Configuration;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/datadog/android/rum/model/LongTaskEvent$Profiling;)V", "getBrowserSdkVersion", "()Ljava/lang/String;", "getConfiguration", "()Lcom/datadog/android/rum/model/LongTaskEvent$Configuration;", "getDiscarded", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "formatVersion", "", "getFormatVersion", "()J", "getProfiling", "()Lcom/datadog/android/rum/model/LongTaskEvent$Profiling;", "getSdkName", "getSession", "()Lcom/datadog/android/rum/model/LongTaskEvent$DdSession;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lcom/datadog/android/rum/model/LongTaskEvent$DdSession;Lcom/datadog/android/rum/model/LongTaskEvent$Configuration;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/datadog/android/rum/model/LongTaskEvent$Profiling;)Lcom/datadog/android/rum/model/LongTaskEvent$Dd;", "equals", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Dd {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String browserSdkVersion;
        private final Configuration configuration;
        private final Boolean discarded;
        private final long formatVersion;
        private final Profiling profiling;
        private final String sdkName;
        private final DdSession session;

        public Dd() {
            this(null, null, null, null, null, null, 63, null);
        }

        public static /* synthetic */ Dd copy$default(Dd dd, DdSession ddSession, Configuration configuration, String str, String str2, Boolean bool, Profiling profiling, int i, Object obj) {
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
                bool = dd.discarded;
            }
            if ((i & 32) != 0) {
                profiling = dd.profiling;
            }
            Boolean bool2 = bool;
            Profiling profiling2 = profiling;
            return dd.copy(ddSession, configuration, str, str2, bool2, profiling2);
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
        public final Boolean getDiscarded() {
            return this.discarded;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Profiling getProfiling() {
            return this.profiling;
        }

        public final Dd copy(DdSession session, Configuration configuration, String browserSdkVersion, String sdkName, Boolean discarded, Profiling profiling) {
            return new Dd(session, configuration, browserSdkVersion, sdkName, discarded, profiling);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Dd)) {
                return false;
            }
            Dd dd = (Dd) other;
            return Intrinsics.areEqual(this.session, dd.session) && Intrinsics.areEqual(this.configuration, dd.configuration) && Intrinsics.areEqual(this.browserSdkVersion, dd.browserSdkVersion) && Intrinsics.areEqual(this.sdkName, dd.sdkName) && Intrinsics.areEqual(this.discarded, dd.discarded) && Intrinsics.areEqual(this.profiling, dd.profiling);
        }

        public int hashCode() {
            DdSession ddSession = this.session;
            int iHashCode = (ddSession == null ? 0 : ddSession.hashCode()) * 31;
            Configuration configuration = this.configuration;
            int iHashCode2 = (iHashCode + (configuration == null ? 0 : configuration.hashCode())) * 31;
            String str = this.browserSdkVersion;
            int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.sdkName;
            int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Boolean bool = this.discarded;
            int iHashCode5 = (iHashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
            Profiling profiling = this.profiling;
            return iHashCode5 + (profiling != null ? profiling.hashCode() : 0);
        }

        public String toString() {
            return "Dd(session=" + this.session + ", configuration=" + this.configuration + ", browserSdkVersion=" + this.browserSdkVersion + ", sdkName=" + this.sdkName + ", discarded=" + this.discarded + ", profiling=" + this.profiling + ")";
        }

        public Dd(DdSession ddSession, Configuration configuration, String str, String str2, Boolean bool, Profiling profiling) {
            this.session = ddSession;
            this.configuration = configuration;
            this.browserSdkVersion = str;
            this.sdkName = str2;
            this.discarded = bool;
            this.profiling = profiling;
            this.formatVersion = 2L;
        }

        public /* synthetic */ Dd(DdSession ddSession, Configuration configuration, String str, String str2, Boolean bool, Profiling profiling, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : ddSession, (i & 2) != 0 ? null : configuration, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : profiling);
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

        public final Boolean getDiscarded() {
            return this.discarded;
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
            Boolean bool = this.discarded;
            if (bool != null) {
                bool.booleanValue();
                jsonObject.addProperty("discarded", bool);
            }
            Profiling profiling = this.profiling;
            if (profiling != null) {
                jsonObject.add("profiling", profiling.toJson());
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: LongTaskEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Dd$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent$Dd;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
                JsonObject asJsonObject;
                JsonObject asJsonObject2;
                JsonObject asJsonObject3;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    long asLong = jsonObject.get("format_version").getAsLong();
                    JsonElement jsonElement = jsonObject.get("session");
                    Profiling profilingFromJsonObject = null;
                    DdSession ddSessionFromJsonObject = (jsonElement == null || (asJsonObject3 = jsonElement.getAsJsonObject()) == null) ? null : DdSession.INSTANCE.fromJsonObject(asJsonObject3);
                    JsonElement jsonElement2 = jsonObject.get("configuration");
                    Configuration configurationFromJsonObject = (jsonElement2 == null || (asJsonObject2 = jsonElement2.getAsJsonObject()) == null) ? null : Configuration.INSTANCE.fromJsonObject(asJsonObject2);
                    JsonElement jsonElement3 = jsonObject.get("browser_sdk_version");
                    String asString = jsonElement3 != null ? jsonElement3.getAsString() : null;
                    JsonElement jsonElement4 = jsonObject.get("sdk_name");
                    String asString2 = jsonElement4 != null ? jsonElement4.getAsString() : null;
                    JsonElement jsonElement5 = jsonObject.get("discarded");
                    Boolean boolValueOf = jsonElement5 != null ? Boolean.valueOf(jsonElement5.getAsBoolean()) : null;
                    JsonElement jsonElement6 = jsonObject.get("profiling");
                    if (jsonElement6 != null && (asJsonObject = jsonElement6.getAsJsonObject()) != null) {
                        profilingFromJsonObject = Profiling.INSTANCE.fromJsonObject(asJsonObject);
                    }
                    if (asLong != 2) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    return new Dd(ddSessionFromJsonObject, configurationFromJsonObject, asString, asString2, boolValueOf, profilingFromJsonObject);
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

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001d\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0017\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003HÆ\u0003J!\u0010\t\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Context;", "", "additionalProperties", "", "", "(Ljava/util/Map;)V", "getAdditionalProperties", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: LongTaskEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Context$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent$Context;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Stream;", "", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: LongTaskEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Stream$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent$Stream;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Action;", "", "id", "", "", "(Ljava/util/List;)V", "getId", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Action {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final List<String> id;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Action copy$default(Action action, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = action.id;
            }
            return action.copy(list);
        }

        @JvmStatic
        public static final Action fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Action fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        public final List<String> component1() {
            return this.id;
        }

        public final Action copy(List<String> id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Action(id);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Action) && Intrinsics.areEqual(this.id, ((Action) other).id);
        }

        public int hashCode() {
            return this.id.hashCode();
        }

        public String toString() {
            return "Action(id=" + this.id + ")";
        }

        public Action(List<String> id) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public final List<String> getId() {
            return this.id;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            JsonArray jsonArray = new JsonArray(this.id.size());
            Iterator<T> it = this.id.iterator();
            while (it.hasNext()) {
                jsonArray.add((String) it.next());
            }
            jsonObject.add("id", jsonArray);
            return jsonObject;
        }

        /* JADX INFO: compiled from: LongTaskEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Action$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent$Action;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
                    JsonArray jsonArray = jsonObject.get("id").getAsJsonArray();
                    ArrayList arrayList = new ArrayList(jsonArray.size());
                    Intrinsics.checkNotNullExpressionValue(jsonArray, "jsonArray");
                    Iterator<JsonElement> it = jsonArray.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().getAsString());
                    }
                    return new Action(arrayList);
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

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Container;", "", "view", "Lcom/datadog/android/rum/model/LongTaskEvent$ContainerView;", "source", "Lcom/datadog/android/rum/model/LongTaskEvent$LongTaskEventSource;", "(Lcom/datadog/android/rum/model/LongTaskEvent$ContainerView;Lcom/datadog/android/rum/model/LongTaskEvent$LongTaskEventSource;)V", "getSource", "()Lcom/datadog/android/rum/model/LongTaskEvent$LongTaskEventSource;", "getView", "()Lcom/datadog/android/rum/model/LongTaskEvent$ContainerView;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Container {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final LongTaskEventSource source;
        private final ContainerView view;

        public static /* synthetic */ Container copy$default(Container container, ContainerView containerView, LongTaskEventSource longTaskEventSource, int i, Object obj) {
            if ((i & 1) != 0) {
                containerView = container.view;
            }
            if ((i & 2) != 0) {
                longTaskEventSource = container.source;
            }
            return container.copy(containerView, longTaskEventSource);
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
        public final LongTaskEventSource getSource() {
            return this.source;
        }

        public final Container copy(ContainerView view, LongTaskEventSource source) {
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

        public Container(ContainerView view, LongTaskEventSource source) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(source, "source");
            this.view = view;
            this.source = source;
        }

        public final ContainerView getView() {
            return this.view;
        }

        public final LongTaskEventSource getSource() {
            return this.source;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("view", this.view.toJson());
            jsonObject.add("source", this.source.toJson());
            return jsonObject;
        }

        /* JADX INFO: compiled from: LongTaskEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Container$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent$Container;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
                    LongTaskEventSource.Companion companion2 = LongTaskEventSource.INSTANCE;
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

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 92\u00020\u0001:\u00019B\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011¢\u0006\u0002\u0010\u0013J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u008a\u0001\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u00101J\u0013\u00102\u001a\u00020\u000f2\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001J\u0006\u00106\u001a\u000207J\t\u00108\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u000e\u0010\u001fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001c¨\u0006:"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$LongTask;", "", "id", "", "startTime", "", "entryType", "Lcom/datadog/android/rum/model/LongTaskEvent$EntryType;", "duration", "", "blockingDuration", "renderStart", "styleAndLayoutStart", "firstUiEventTimestamp", "isFrozenFrame", "", "scripts", "", "Lcom/datadog/android/rum/model/LongTaskEvent$Script;", "(Ljava/lang/String;Ljava/lang/Number;Lcom/datadog/android/rum/model/LongTaskEvent$EntryType;JLjava/lang/Long;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Boolean;Ljava/util/List;)V", "getBlockingDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDuration", "()J", "getEntryType", "()Lcom/datadog/android/rum/model/LongTaskEvent$EntryType;", "getFirstUiEventTimestamp", "()Ljava/lang/Number;", "getId", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getRenderStart", "getScripts", "()Ljava/util/List;", "getStartTime", "getStyleAndLayoutStart", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Number;Lcom/datadog/android/rum/model/LongTaskEvent$EntryType;JLjava/lang/Long;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Boolean;Ljava/util/List;)Lcom/datadog/android/rum/model/LongTaskEvent$LongTask;", "equals", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class LongTask {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Long blockingDuration;
        private final long duration;
        private final EntryType entryType;
        private final Number firstUiEventTimestamp;
        private final String id;
        private final Boolean isFrozenFrame;
        private final Number renderStart;
        private final List<Script> scripts;
        private final Number startTime;
        private final Number styleAndLayoutStart;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LongTask copy$default(LongTask longTask, String str, Number number, EntryType entryType, long j, Long l, Number number2, Number number3, Number number4, Boolean bool, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = longTask.id;
            }
            if ((i & 2) != 0) {
                number = longTask.startTime;
            }
            if ((i & 4) != 0) {
                entryType = longTask.entryType;
            }
            if ((i & 8) != 0) {
                j = longTask.duration;
            }
            if ((i & 16) != 0) {
                l = longTask.blockingDuration;
            }
            if ((i & 32) != 0) {
                number2 = longTask.renderStart;
            }
            if ((i & 64) != 0) {
                number3 = longTask.styleAndLayoutStart;
            }
            if ((i & 128) != 0) {
                number4 = longTask.firstUiEventTimestamp;
            }
            if ((i & 256) != 0) {
                bool = longTask.isFrozenFrame;
            }
            if ((i & 512) != 0) {
                list = longTask.scripts;
            }
            Boolean bool2 = bool;
            List list2 = list;
            long j2 = j;
            EntryType entryType2 = entryType;
            return longTask.copy(str, number, entryType2, j2, l, number2, number3, number4, bool2, list2);
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
        public final String getId() {
            return this.id;
        }

        public final List<Script> component10() {
            return this.scripts;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Number getStartTime() {
            return this.startTime;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final EntryType getEntryType() {
            return this.entryType;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final long getDuration() {
            return this.duration;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Long getBlockingDuration() {
            return this.blockingDuration;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Number getRenderStart() {
            return this.renderStart;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Number getStyleAndLayoutStart() {
            return this.styleAndLayoutStart;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Number getFirstUiEventTimestamp() {
            return this.firstUiEventTimestamp;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Boolean getIsFrozenFrame() {
            return this.isFrozenFrame;
        }

        public final LongTask copy(String id, Number startTime, EntryType entryType, long duration, Long blockingDuration, Number renderStart, Number styleAndLayoutStart, Number firstUiEventTimestamp, Boolean isFrozenFrame, List<Script> scripts) {
            return new LongTask(id, startTime, entryType, duration, blockingDuration, renderStart, styleAndLayoutStart, firstUiEventTimestamp, isFrozenFrame, scripts);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LongTask)) {
                return false;
            }
            LongTask longTask = (LongTask) other;
            return Intrinsics.areEqual(this.id, longTask.id) && Intrinsics.areEqual(this.startTime, longTask.startTime) && this.entryType == longTask.entryType && this.duration == longTask.duration && Intrinsics.areEqual(this.blockingDuration, longTask.blockingDuration) && Intrinsics.areEqual(this.renderStart, longTask.renderStart) && Intrinsics.areEqual(this.styleAndLayoutStart, longTask.styleAndLayoutStart) && Intrinsics.areEqual(this.firstUiEventTimestamp, longTask.firstUiEventTimestamp) && Intrinsics.areEqual(this.isFrozenFrame, longTask.isFrozenFrame) && Intrinsics.areEqual(this.scripts, longTask.scripts);
        }

        public int hashCode() {
            String str = this.id;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            Number number = this.startTime;
            int iHashCode2 = (iHashCode + (number == null ? 0 : number.hashCode())) * 31;
            EntryType entryType = this.entryType;
            int iHashCode3 = (((iHashCode2 + (entryType == null ? 0 : entryType.hashCode())) * 31) + Long.hashCode(this.duration)) * 31;
            Long l = this.blockingDuration;
            int iHashCode4 = (iHashCode3 + (l == null ? 0 : l.hashCode())) * 31;
            Number number2 = this.renderStart;
            int iHashCode5 = (iHashCode4 + (number2 == null ? 0 : number2.hashCode())) * 31;
            Number number3 = this.styleAndLayoutStart;
            int iHashCode6 = (iHashCode5 + (number3 == null ? 0 : number3.hashCode())) * 31;
            Number number4 = this.firstUiEventTimestamp;
            int iHashCode7 = (iHashCode6 + (number4 == null ? 0 : number4.hashCode())) * 31;
            Boolean bool = this.isFrozenFrame;
            int iHashCode8 = (iHashCode7 + (bool == null ? 0 : bool.hashCode())) * 31;
            List<Script> list = this.scripts;
            return iHashCode8 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "LongTask(id=" + this.id + ", startTime=" + this.startTime + ", entryType=" + this.entryType + ", duration=" + this.duration + ", blockingDuration=" + this.blockingDuration + ", renderStart=" + this.renderStart + ", styleAndLayoutStart=" + this.styleAndLayoutStart + ", firstUiEventTimestamp=" + this.firstUiEventTimestamp + ", isFrozenFrame=" + this.isFrozenFrame + ", scripts=" + this.scripts + ")";
        }

        public LongTask(String str, Number number, EntryType entryType, long j, Long l, Number number2, Number number3, Number number4, Boolean bool, List<Script> list) {
            this.id = str;
            this.startTime = number;
            this.entryType = entryType;
            this.duration = j;
            this.blockingDuration = l;
            this.renderStart = number2;
            this.styleAndLayoutStart = number3;
            this.firstUiEventTimestamp = number4;
            this.isFrozenFrame = bool;
            this.scripts = list;
        }

        public /* synthetic */ LongTask(String str, Number number, EntryType entryType, long j, Long l, Number number2, Number number3, Number number4, Boolean bool, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : number, (i & 4) != 0 ? null : entryType, j, (i & 16) != 0 ? null : l, (i & 32) != 0 ? null : number2, (i & 64) != 0 ? null : number3, (i & 128) != 0 ? null : number4, (i & 256) != 0 ? null : bool, (i & 512) != 0 ? null : list);
        }

        public final String getId() {
            return this.id;
        }

        public final Number getStartTime() {
            return this.startTime;
        }

        public final EntryType getEntryType() {
            return this.entryType;
        }

        public final long getDuration() {
            return this.duration;
        }

        public final Long getBlockingDuration() {
            return this.blockingDuration;
        }

        public final Number getRenderStart() {
            return this.renderStart;
        }

        public final Number getStyleAndLayoutStart() {
            return this.styleAndLayoutStart;
        }

        public final Number getFirstUiEventTimestamp() {
            return this.firstUiEventTimestamp;
        }

        public final Boolean isFrozenFrame() {
            return this.isFrozenFrame;
        }

        public final List<Script> getScripts() {
            return this.scripts;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            String str = this.id;
            if (str != null) {
                jsonObject.addProperty("id", str);
            }
            Number number = this.startTime;
            if (number != null) {
                jsonObject.addProperty("start_time", number);
            }
            EntryType entryType = this.entryType;
            if (entryType != null) {
                jsonObject.add("entry_type", entryType.toJson());
            }
            jsonObject.addProperty("duration", Long.valueOf(this.duration));
            Long l = this.blockingDuration;
            if (l != null) {
                jsonObject.addProperty("blocking_duration", Long.valueOf(l.longValue()));
            }
            Number number2 = this.renderStart;
            if (number2 != null) {
                jsonObject.addProperty("render_start", number2);
            }
            Number number3 = this.styleAndLayoutStart;
            if (number3 != null) {
                jsonObject.addProperty("style_and_layout_start", number3);
            }
            Number number4 = this.firstUiEventTimestamp;
            if (number4 != null) {
                jsonObject.addProperty("first_ui_event_timestamp", number4);
            }
            Boolean bool = this.isFrozenFrame;
            if (bool != null) {
                bool.booleanValue();
                jsonObject.addProperty("is_frozen_frame", bool);
            }
            List<Script> list = this.scripts;
            if (list != null) {
                JsonArray jsonArray = new JsonArray(list.size());
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    jsonArray.add(((Script) it.next()).toJson());
                }
                jsonObject.add("scripts", jsonArray);
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: LongTaskEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$LongTask$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent$LongTask;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
                JsonArray asJsonArray;
                String asString;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get("id");
                    ArrayList arrayList = null;
                    String asString2 = jsonElement != null ? jsonElement.getAsString() : null;
                    JsonElement jsonElement2 = jsonObject.get("start_time");
                    Number asNumber = jsonElement2 != null ? jsonElement2.getAsNumber() : null;
                    JsonElement jsonElement3 = jsonObject.get("entry_type");
                    EntryType entryTypeFromJson = (jsonElement3 == null || (asString = jsonElement3.getAsString()) == null) ? null : EntryType.INSTANCE.fromJson(asString);
                    long asLong = jsonObject.get("duration").getAsLong();
                    JsonElement jsonElement4 = jsonObject.get("blocking_duration");
                    Long lValueOf = jsonElement4 != null ? Long.valueOf(jsonElement4.getAsLong()) : null;
                    JsonElement jsonElement5 = jsonObject.get("render_start");
                    Number asNumber2 = jsonElement5 != null ? jsonElement5.getAsNumber() : null;
                    JsonElement jsonElement6 = jsonObject.get("style_and_layout_start");
                    Number asNumber3 = jsonElement6 != null ? jsonElement6.getAsNumber() : null;
                    JsonElement jsonElement7 = jsonObject.get("first_ui_event_timestamp");
                    Number asNumber4 = jsonElement7 != null ? jsonElement7.getAsNumber() : null;
                    JsonElement jsonElement8 = jsonObject.get("is_frozen_frame");
                    Boolean boolValueOf = jsonElement8 != null ? Boolean.valueOf(jsonElement8.getAsBoolean()) : null;
                    JsonElement jsonElement9 = jsonObject.get("scripts");
                    if (jsonElement9 != null && (asJsonArray = jsonElement9.getAsJsonArray()) != null) {
                        arrayList = new ArrayList(asJsonArray.size());
                        for (JsonElement jsonElement10 : asJsonArray) {
                            Script.Companion companion = Script.INSTANCE;
                            JsonObject asJsonObject = jsonElement10.getAsJsonObject();
                            Intrinsics.checkNotNullExpressionValue(asJsonObject, "it.asJsonObject");
                            arrayList.add(companion.fromJsonObject(asJsonObject));
                        }
                    }
                    return new LongTask(asString2, asNumber, entryTypeFromJson, asLong, lValueOf, asNumber2, asNumber3, asNumber4, boolValueOf, arrayList);
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

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Cellular;", "", "technology", "", "carrierName", "(Ljava/lang/String;Ljava/lang/String;)V", "getCarrierName", "()Ljava/lang/String;", "getTechnology", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: LongTaskEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Cellular$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent$Cellular;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0004\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Viewport;", "", ViewProps.WIDTH, "", ViewProps.HEIGHT, "(Ljava/lang/Number;Ljava/lang/Number;)V", "getHeight", "()Ljava/lang/Number;", "getWidth", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: LongTaskEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Viewport$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent$Viewport;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$DdSession;", "", "plan", "Lcom/datadog/android/rum/model/LongTaskEvent$Plan;", "sessionPrecondition", "Lcom/datadog/android/rum/model/LongTaskEvent$SessionPrecondition;", "(Lcom/datadog/android/rum/model/LongTaskEvent$Plan;Lcom/datadog/android/rum/model/LongTaskEvent$SessionPrecondition;)V", "getPlan", "()Lcom/datadog/android/rum/model/LongTaskEvent$Plan;", "getSessionPrecondition", "()Lcom/datadog/android/rum/model/LongTaskEvent$SessionPrecondition;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: LongTaskEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$DdSession$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent$DdSession;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001 BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003JI\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0006\u0010\u001d\u001a\u00020\u001eJ\t\u0010\u001f\u001a\u00020\tHÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006!"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Configuration;", "", RumSessionScope.RUM_SESSION_SAMPLE_RATE_BUS_MESSAGE_KEY, "", "sessionReplaySampleRate", "profilingSampleRate", "traceSampleRate", "sessionReplayExperimentalFeatures", "", "", "(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/util/List;)V", "getProfilingSampleRate", "()Ljava/lang/Number;", "getSessionReplayExperimentalFeatures", "()Ljava/util/List;", "getSessionReplaySampleRate", "getSessionSampleRate", "getTraceSampleRate", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Configuration {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Number profilingSampleRate;
        private final List<String> sessionReplayExperimentalFeatures;
        private final Number sessionReplaySampleRate;
        private final Number sessionSampleRate;
        private final Number traceSampleRate;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Configuration copy$default(Configuration configuration, Number number, Number number2, Number number3, Number number4, List list, int i, Object obj) {
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
            List list2 = list;
            Number number5 = number3;
            return configuration.copy(number, number2, number5, number4, list2);
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

        public final Configuration copy(Number sessionSampleRate, Number sessionReplaySampleRate, Number profilingSampleRate, Number traceSampleRate, List<String> sessionReplayExperimentalFeatures) {
            Intrinsics.checkNotNullParameter(sessionSampleRate, "sessionSampleRate");
            return new Configuration(sessionSampleRate, sessionReplaySampleRate, profilingSampleRate, traceSampleRate, sessionReplayExperimentalFeatures);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Configuration)) {
                return false;
            }
            Configuration configuration = (Configuration) other;
            return Intrinsics.areEqual(this.sessionSampleRate, configuration.sessionSampleRate) && Intrinsics.areEqual(this.sessionReplaySampleRate, configuration.sessionReplaySampleRate) && Intrinsics.areEqual(this.profilingSampleRate, configuration.profilingSampleRate) && Intrinsics.areEqual(this.traceSampleRate, configuration.traceSampleRate) && Intrinsics.areEqual(this.sessionReplayExperimentalFeatures, configuration.sessionReplayExperimentalFeatures);
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
            return iHashCode4 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "Configuration(sessionSampleRate=" + this.sessionSampleRate + ", sessionReplaySampleRate=" + this.sessionReplaySampleRate + ", profilingSampleRate=" + this.profilingSampleRate + ", traceSampleRate=" + this.traceSampleRate + ", sessionReplayExperimentalFeatures=" + this.sessionReplayExperimentalFeatures + ")";
        }

        public Configuration(Number sessionSampleRate, Number number, Number number2, Number number3, List<String> list) {
            Intrinsics.checkNotNullParameter(sessionSampleRate, "sessionSampleRate");
            this.sessionSampleRate = sessionSampleRate;
            this.sessionReplaySampleRate = number;
            this.profilingSampleRate = number2;
            this.traceSampleRate = number3;
            this.sessionReplayExperimentalFeatures = list;
        }

        public /* synthetic */ Configuration(Number number, Number number2, Number number3, Number number4, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(number, (i & 2) != 0 ? null : number2, (i & 4) != 0 ? null : number3, (i & 8) != 0 ? null : number4, (i & 16) != 0 ? null : list);
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
            return jsonObject;
        }

        /* JADX INFO: compiled from: LongTaskEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Configuration$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent$Configuration;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
                JsonArray asJsonArray;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    Number sessionSampleRate = jsonObject.get("session_sample_rate").getAsNumber();
                    JsonElement jsonElement = jsonObject.get("session_replay_sample_rate");
                    ArrayList arrayList = null;
                    Number asNumber = jsonElement != null ? jsonElement.getAsNumber() : null;
                    JsonElement jsonElement2 = jsonObject.get("profiling_sample_rate");
                    Number asNumber2 = jsonElement2 != null ? jsonElement2.getAsNumber() : null;
                    JsonElement jsonElement3 = jsonObject.get("trace_sample_rate");
                    Number asNumber3 = jsonElement3 != null ? jsonElement3.getAsNumber() : null;
                    JsonElement jsonElement4 = jsonObject.get("session_replay_experimental_features");
                    if (jsonElement4 != null && (asJsonArray = jsonElement4.getAsJsonArray()) != null) {
                        arrayList = new ArrayList(asJsonArray.size());
                        Iterator<JsonElement> it = asJsonArray.iterator();
                        while (it.hasNext()) {
                            arrayList.add(it.next().getAsString());
                        }
                    }
                    Intrinsics.checkNotNullExpressionValue(sessionSampleRate, "sessionSampleRate");
                    return new Configuration(sessionSampleRate, asNumber, asNumber2, asNumber3, arrayList);
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

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001 B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0006\u0010\u001d\u001a\u00020\u001eJ\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Profiling;", "", "status", "Lcom/datadog/android/rum/model/LongTaskEvent$ProfilingStatus;", "errorReason", "Lcom/datadog/android/rum/model/LongTaskEvent$ErrorReason;", "quotaReason", "", "clockDrift", "", "(Lcom/datadog/android/rum/model/LongTaskEvent$ProfilingStatus;Lcom/datadog/android/rum/model/LongTaskEvent$ErrorReason;Ljava/lang/String;Ljava/lang/Number;)V", "getClockDrift", "()Ljava/lang/Number;", "getErrorReason", "()Lcom/datadog/android/rum/model/LongTaskEvent$ErrorReason;", "getQuotaReason", "()Ljava/lang/String;", "getStatus", "()Lcom/datadog/android/rum/model/LongTaskEvent$ProfilingStatus;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: LongTaskEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Profiling$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent$Profiling;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$ContainerView;", "", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: LongTaskEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$ContainerView$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent$ContainerView;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 72\u00020\u0001:\u00017B\u0089\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0011J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010#\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010,\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0092\u0001\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\u0006\u00104\u001a\u000205J\t\u00106\u001a\u00020\nHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0017\u0010\u0013R\u0013\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001c\u0010\u0013R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001d\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019¨\u00068"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Script;", "", "duration", "", "pauseDuration", "forcedStyleAndLayoutDuration", "startTime", "", "executionStart", "sourceUrl", "", "sourceFunctionName", "sourceCharPosition", "invoker", "invokerType", "Lcom/datadog/android/rum/model/LongTaskEvent$InvokerType;", "windowAttribution", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lcom/datadog/android/rum/model/LongTaskEvent$InvokerType;Ljava/lang/String;)V", "getDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getExecutionStart", "()Ljava/lang/Number;", "getForcedStyleAndLayoutDuration", "getInvoker", "()Ljava/lang/String;", "getInvokerType", "()Lcom/datadog/android/rum/model/LongTaskEvent$InvokerType;", "getPauseDuration", "getSourceCharPosition", "getSourceFunctionName", "getSourceUrl", "getStartTime", "getWindowAttribution", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lcom/datadog/android/rum/model/LongTaskEvent$InvokerType;Ljava/lang/String;)Lcom/datadog/android/rum/model/LongTaskEvent$Script;", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Script {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Long duration;
        private final Number executionStart;
        private final Long forcedStyleAndLayoutDuration;
        private final String invoker;
        private final InvokerType invokerType;
        private final Long pauseDuration;
        private final Long sourceCharPosition;
        private final String sourceFunctionName;
        private final String sourceUrl;
        private final Number startTime;
        private final String windowAttribution;

        public Script() {
            this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
        }

        public static /* synthetic */ Script copy$default(Script script, Long l, Long l2, Long l3, Number number, Number number2, String str, String str2, Long l4, String str3, InvokerType invokerType, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                l = script.duration;
            }
            if ((i & 2) != 0) {
                l2 = script.pauseDuration;
            }
            if ((i & 4) != 0) {
                l3 = script.forcedStyleAndLayoutDuration;
            }
            if ((i & 8) != 0) {
                number = script.startTime;
            }
            if ((i & 16) != 0) {
                number2 = script.executionStart;
            }
            if ((i & 32) != 0) {
                str = script.sourceUrl;
            }
            if ((i & 64) != 0) {
                str2 = script.sourceFunctionName;
            }
            if ((i & 128) != 0) {
                l4 = script.sourceCharPosition;
            }
            if ((i & 256) != 0) {
                str3 = script.invoker;
            }
            if ((i & 512) != 0) {
                invokerType = script.invokerType;
            }
            if ((i & 1024) != 0) {
                str4 = script.windowAttribution;
            }
            InvokerType invokerType2 = invokerType;
            String str5 = str4;
            Long l5 = l4;
            String str6 = str3;
            String str7 = str;
            String str8 = str2;
            Number number3 = number2;
            Long l6 = l3;
            return script.copy(l, l2, l6, number, number3, str7, str8, l5, str6, invokerType2, str5);
        }

        @JvmStatic
        public static final Script fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Script fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Long getDuration() {
            return this.duration;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final InvokerType getInvokerType() {
            return this.invokerType;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getWindowAttribution() {
            return this.windowAttribution;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Long getPauseDuration() {
            return this.pauseDuration;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Long getForcedStyleAndLayoutDuration() {
            return this.forcedStyleAndLayoutDuration;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Number getStartTime() {
            return this.startTime;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Number getExecutionStart() {
            return this.executionStart;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getSourceUrl() {
            return this.sourceUrl;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getSourceFunctionName() {
            return this.sourceFunctionName;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Long getSourceCharPosition() {
            return this.sourceCharPosition;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getInvoker() {
            return this.invoker;
        }

        public final Script copy(Long duration, Long pauseDuration, Long forcedStyleAndLayoutDuration, Number startTime, Number executionStart, String sourceUrl, String sourceFunctionName, Long sourceCharPosition, String invoker, InvokerType invokerType, String windowAttribution) {
            return new Script(duration, pauseDuration, forcedStyleAndLayoutDuration, startTime, executionStart, sourceUrl, sourceFunctionName, sourceCharPosition, invoker, invokerType, windowAttribution);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Script)) {
                return false;
            }
            Script script = (Script) other;
            return Intrinsics.areEqual(this.duration, script.duration) && Intrinsics.areEqual(this.pauseDuration, script.pauseDuration) && Intrinsics.areEqual(this.forcedStyleAndLayoutDuration, script.forcedStyleAndLayoutDuration) && Intrinsics.areEqual(this.startTime, script.startTime) && Intrinsics.areEqual(this.executionStart, script.executionStart) && Intrinsics.areEqual(this.sourceUrl, script.sourceUrl) && Intrinsics.areEqual(this.sourceFunctionName, script.sourceFunctionName) && Intrinsics.areEqual(this.sourceCharPosition, script.sourceCharPosition) && Intrinsics.areEqual(this.invoker, script.invoker) && this.invokerType == script.invokerType && Intrinsics.areEqual(this.windowAttribution, script.windowAttribution);
        }

        public int hashCode() {
            Long l = this.duration;
            int iHashCode = (l == null ? 0 : l.hashCode()) * 31;
            Long l2 = this.pauseDuration;
            int iHashCode2 = (iHashCode + (l2 == null ? 0 : l2.hashCode())) * 31;
            Long l3 = this.forcedStyleAndLayoutDuration;
            int iHashCode3 = (iHashCode2 + (l3 == null ? 0 : l3.hashCode())) * 31;
            Number number = this.startTime;
            int iHashCode4 = (iHashCode3 + (number == null ? 0 : number.hashCode())) * 31;
            Number number2 = this.executionStart;
            int iHashCode5 = (iHashCode4 + (number2 == null ? 0 : number2.hashCode())) * 31;
            String str = this.sourceUrl;
            int iHashCode6 = (iHashCode5 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.sourceFunctionName;
            int iHashCode7 = (iHashCode6 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Long l4 = this.sourceCharPosition;
            int iHashCode8 = (iHashCode7 + (l4 == null ? 0 : l4.hashCode())) * 31;
            String str3 = this.invoker;
            int iHashCode9 = (iHashCode8 + (str3 == null ? 0 : str3.hashCode())) * 31;
            InvokerType invokerType = this.invokerType;
            int iHashCode10 = (iHashCode9 + (invokerType == null ? 0 : invokerType.hashCode())) * 31;
            String str4 = this.windowAttribution;
            return iHashCode10 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            return "Script(duration=" + this.duration + ", pauseDuration=" + this.pauseDuration + ", forcedStyleAndLayoutDuration=" + this.forcedStyleAndLayoutDuration + ", startTime=" + this.startTime + ", executionStart=" + this.executionStart + ", sourceUrl=" + this.sourceUrl + ", sourceFunctionName=" + this.sourceFunctionName + ", sourceCharPosition=" + this.sourceCharPosition + ", invoker=" + this.invoker + ", invokerType=" + this.invokerType + ", windowAttribution=" + this.windowAttribution + ")";
        }

        public Script(Long l, Long l2, Long l3, Number number, Number number2, String str, String str2, Long l4, String str3, InvokerType invokerType, String str4) {
            this.duration = l;
            this.pauseDuration = l2;
            this.forcedStyleAndLayoutDuration = l3;
            this.startTime = number;
            this.executionStart = number2;
            this.sourceUrl = str;
            this.sourceFunctionName = str2;
            this.sourceCharPosition = l4;
            this.invoker = str3;
            this.invokerType = invokerType;
            this.windowAttribution = str4;
        }

        public /* synthetic */ Script(Long l, Long l2, Long l3, Number number, Number number2, String str, String str2, Long l4, String str3, InvokerType invokerType, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : l2, (i & 4) != 0 ? null : l3, (i & 8) != 0 ? null : number, (i & 16) != 0 ? null : number2, (i & 32) != 0 ? null : str, (i & 64) != 0 ? null : str2, (i & 128) != 0 ? null : l4, (i & 256) != 0 ? null : str3, (i & 512) != 0 ? null : invokerType, (i & 1024) != 0 ? null : str4);
        }

        public final Long getDuration() {
            return this.duration;
        }

        public final Long getPauseDuration() {
            return this.pauseDuration;
        }

        public final Long getForcedStyleAndLayoutDuration() {
            return this.forcedStyleAndLayoutDuration;
        }

        public final Number getStartTime() {
            return this.startTime;
        }

        public final Number getExecutionStart() {
            return this.executionStart;
        }

        public final String getSourceUrl() {
            return this.sourceUrl;
        }

        public final String getSourceFunctionName() {
            return this.sourceFunctionName;
        }

        public final Long getSourceCharPosition() {
            return this.sourceCharPosition;
        }

        public final String getInvoker() {
            return this.invoker;
        }

        public final InvokerType getInvokerType() {
            return this.invokerType;
        }

        public final String getWindowAttribution() {
            return this.windowAttribution;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            Long l = this.duration;
            if (l != null) {
                jsonObject.addProperty("duration", Long.valueOf(l.longValue()));
            }
            Long l2 = this.pauseDuration;
            if (l2 != null) {
                jsonObject.addProperty("pause_duration", Long.valueOf(l2.longValue()));
            }
            Long l3 = this.forcedStyleAndLayoutDuration;
            if (l3 != null) {
                jsonObject.addProperty("forced_style_and_layout_duration", Long.valueOf(l3.longValue()));
            }
            Number number = this.startTime;
            if (number != null) {
                jsonObject.addProperty("start_time", number);
            }
            Number number2 = this.executionStart;
            if (number2 != null) {
                jsonObject.addProperty("execution_start", number2);
            }
            String str = this.sourceUrl;
            if (str != null) {
                jsonObject.addProperty("source_url", str);
            }
            String str2 = this.sourceFunctionName;
            if (str2 != null) {
                jsonObject.addProperty("source_function_name", str2);
            }
            Long l4 = this.sourceCharPosition;
            if (l4 != null) {
                jsonObject.addProperty("source_char_position", Long.valueOf(l4.longValue()));
            }
            String str3 = this.invoker;
            if (str3 != null) {
                jsonObject.addProperty("invoker", str3);
            }
            InvokerType invokerType = this.invokerType;
            if (invokerType != null) {
                jsonObject.add("invoker_type", invokerType.toJson());
            }
            String str4 = this.windowAttribution;
            if (str4 != null) {
                jsonObject.addProperty("window_attribution", str4);
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: LongTaskEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Script$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent$Script;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Script fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Script", e);
                }
            }

            @JvmStatic
            public final Script fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                String asString;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get("duration");
                    Long lValueOf = jsonElement != null ? Long.valueOf(jsonElement.getAsLong()) : null;
                    JsonElement jsonElement2 = jsonObject.get("pause_duration");
                    Long lValueOf2 = jsonElement2 != null ? Long.valueOf(jsonElement2.getAsLong()) : null;
                    JsonElement jsonElement3 = jsonObject.get("forced_style_and_layout_duration");
                    Long lValueOf3 = jsonElement3 != null ? Long.valueOf(jsonElement3.getAsLong()) : null;
                    JsonElement jsonElement4 = jsonObject.get("start_time");
                    Number asNumber = jsonElement4 != null ? jsonElement4.getAsNumber() : null;
                    JsonElement jsonElement5 = jsonObject.get("execution_start");
                    Number asNumber2 = jsonElement5 != null ? jsonElement5.getAsNumber() : null;
                    JsonElement jsonElement6 = jsonObject.get("source_url");
                    String asString2 = jsonElement6 != null ? jsonElement6.getAsString() : null;
                    JsonElement jsonElement7 = jsonObject.get("source_function_name");
                    String asString3 = jsonElement7 != null ? jsonElement7.getAsString() : null;
                    JsonElement jsonElement8 = jsonObject.get("source_char_position");
                    Long lValueOf4 = jsonElement8 != null ? Long.valueOf(jsonElement8.getAsLong()) : null;
                    JsonElement jsonElement9 = jsonObject.get("invoker");
                    String asString4 = jsonElement9 != null ? jsonElement9.getAsString() : null;
                    JsonElement jsonElement10 = jsonObject.get("invoker_type");
                    InvokerType invokerTypeFromJson = (jsonElement10 == null || (asString = jsonElement10.getAsString()) == null) ? null : InvokerType.INSTANCE.fromJson(asString);
                    JsonElement jsonElement11 = jsonObject.get("window_attribution");
                    return new Script(lValueOf, lValueOf2, lValueOf3, asNumber, asNumber2, asString2, asString3, lValueOf4, asString4, invokerTypeFromJson, jsonElement11 != null ? jsonElement11.getAsString() : null);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Script", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Script", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Script", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$LongTaskEventSource;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "ANDROID", "IOS", "BROWSER", "FLUTTER", "REACT_NATIVE", "ROKU", "UNITY", "KOTLIN_MULTIPLATFORM", "ELECTRON", "CPP", "MAUI", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum LongTaskEventSource {
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
        public static final LongTaskEventSource fromJson(String str) {
            return INSTANCE.fromJson(str);
        }

        LongTaskEventSource(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        /* JADX INFO: compiled from: LongTaskEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$LongTaskEventSource$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent$LongTaskEventSource;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final LongTaskEventSource fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (LongTaskEventSource longTaskEventSource : LongTaskEventSource.values()) {
                    if (Intrinsics.areEqual(longTaskEventSource.jsonValue, jsonString)) {
                        return longTaskEventSource;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$LongTaskEventSessionType;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "USER", "SYNTHETICS", "CI_TEST", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum LongTaskEventSessionType {
        USER("user"),
        SYNTHETICS("synthetics"),
        CI_TEST("ci_test");


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String jsonValue;

        @JvmStatic
        public static final LongTaskEventSessionType fromJson(String str) {
            return INSTANCE.fromJson(str);
        }

        LongTaskEventSessionType(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        /* JADX INFO: compiled from: LongTaskEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$LongTaskEventSessionType$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent$LongTaskEventSessionType;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final LongTaskEventSessionType fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (LongTaskEventSessionType longTaskEventSessionType : LongTaskEventSessionType.values()) {
                    if (Intrinsics.areEqual(longTaskEventSessionType.jsonValue, jsonString)) {
                        return longTaskEventSessionType;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$ConnectivityStatus;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "CONNECTED", "NOT_CONNECTED", "MAYBE", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: LongTaskEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$ConnectivityStatus$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent$ConnectivityStatus;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Interface;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "BLUETOOTH", "CELLULAR", "ETHERNET", "WIFI", "WIMAX", "MIXED", "OTHER", "UNKNOWN", ProfilingConfig.PROFILING_DATADOG_PROFILER_LOG_LEVEL_DEFAULT, "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: LongTaskEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Interface$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent$Interface;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$EffectiveType;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "SLOW_2G", "2G", "3G", "4G", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum EffectiveType {
        SLOW_2G("slow-2g"),
        f472G("2g"),
        f483G("3g"),
        f494G("4g");


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

        /* JADX INFO: compiled from: LongTaskEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$EffectiveType$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent$EffectiveType;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$DeviceType;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "MOBILE", "DESKTOP", "TABLET", "TV", "GAMING_CONSOLE", "BOT", "OTHER", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: LongTaskEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$DeviceType$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent$DeviceType;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$EntryType;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "LONG_TASK", "LONG_ANIMATION_FRAME", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum EntryType {
        LONG_TASK("long-task"),
        LONG_ANIMATION_FRAME("long-animation-frame");


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String jsonValue;

        @JvmStatic
        public static final EntryType fromJson(String str) {
            return INSTANCE.fromJson(str);
        }

        EntryType(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        /* JADX INFO: compiled from: LongTaskEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$EntryType$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent$EntryType;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final EntryType fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (EntryType entryType : EntryType.values()) {
                    if (Intrinsics.areEqual(entryType.jsonValue, jsonString)) {
                        return entryType;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Plan;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/Number;)V", "toJson", "Lcom/google/gson/JsonElement;", "PLAN_1", "PLAN_2", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: LongTaskEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$Plan$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent$Plan;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$SessionPrecondition;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "USER_APP_LAUNCH", "INACTIVITY_TIMEOUT", "MAX_DURATION", "BACKGROUND_LAUNCH", "PREWARM", "FROM_NON_INTERACTIVE_SESSION", "EXPLICIT_STOP", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: LongTaskEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$SessionPrecondition$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent$SessionPrecondition;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$ProfilingStatus;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "STARTING", DebugCoroutineInfoImplKt.RUNNING, "STOPPED", MediaError.ERROR_TYPE_ERROR, "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: LongTaskEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$ProfilingStatus$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent$ProfilingStatus;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$ErrorReason;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "NOT_SUPPORTED_BY_BROWSER", "FAILED_TO_LAZY_LOAD", "MISSING_DOCUMENT_POLICY_HEADER", "UNEXPECTED_EXCEPTION", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: LongTaskEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$ErrorReason$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent$ErrorReason;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: LongTaskEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$InvokerType;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "USER_CALLBACK", "EVENT_LISTENER", "RESOLVE_PROMISE", "REJECT_PROMISE", "CLASSIC_SCRIPT", "MODULE_SCRIPT", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum InvokerType {
        USER_CALLBACK("user-callback"),
        EVENT_LISTENER("event-listener"),
        RESOLVE_PROMISE("resolve-promise"),
        REJECT_PROMISE("reject-promise"),
        CLASSIC_SCRIPT("classic-script"),
        MODULE_SCRIPT("module-script");


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String jsonValue;

        @JvmStatic
        public static final InvokerType fromJson(String str) {
            return INSTANCE.fromJson(str);
        }

        InvokerType(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        /* JADX INFO: compiled from: LongTaskEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/model/LongTaskEvent$InvokerType$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/LongTaskEvent$InvokerType;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final InvokerType fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (InvokerType invokerType : InvokerType.values()) {
                    if (Intrinsics.areEqual(invokerType.jsonValue, jsonString)) {
                        return invokerType;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }
}

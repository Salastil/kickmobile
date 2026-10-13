package com.datadog.android.rum.model;

import androidx.compose.material3.internal.TextFieldImplKt;
import com.datadog.android.core.internal.utils.JsonSerializer;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.rum.internal.domain.scope.RumSessionScope;
import com.datadog.android.rum.internal.metric.SessionEndedMetric;
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

/* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bI\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b&\b\u0086\b\u0018\u0000 \u0083\u00012\u00020\u0001:F~\u007f\u0080\u0001\u0081\u0001\u0082\u0001\u0083\u0001\u0084\u0001\u0085\u0001\u0086\u0001\u0087\u0001\u0088\u0001\u0089\u0001\u008a\u0001\u008b\u0001\u008c\u0001\u008d\u0001\u008e\u0001\u008f\u0001\u0090\u0001\u0091\u0001\u0092\u0001\u0093\u0001\u0094\u0001\u0095\u0001\u0096\u0001\u0097\u0001\u0098\u0001\u0099\u0001\u009a\u0001\u009b\u0001\u009c\u0001\u009d\u0001\u009e\u0001\u009f\u0001 \u0001¡\u0001B\u008d\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#\u0012\u0006\u0010$\u001a\u00020%\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+\u0012\u0006\u0010,\u001a\u00020-¢\u0006\u0002\u0010.J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\t\u0010^\u001a\u00020\u0011HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010!HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010#HÆ\u0003J\t\u0010h\u001a\u00020\u0005HÆ\u0003J\t\u0010i\u001a\u00020%HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010'HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010)HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010+HÆ\u0003J\t\u0010m\u001a\u00020-HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010s\u001a\u00020\rHÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u009d\u0002\u0010u\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010$\u001a\u00020%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\b\b\u0002\u0010,\u001a\u00020-HÆ\u0001J\u0013\u0010v\u001a\u00020w2\b\u0010x\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010y\u001a\u00020zHÖ\u0001J\u0006\u0010{\u001a\u00020|J\t\u0010}\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b5\u00104R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0013\u0010*\u001a\u0004\u0018\u00010+¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0013\u0010&\u001a\u0004\u0018\u00010'¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0011\u0010$\u001a\u00020%¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bB\u00104R\u0013\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0013\u0010 \u001a\u0004\u0018\u00010!¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bI\u00104R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0013\u0010(\u001a\u0004\u0018\u00010)¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u0014\u0010T\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bU\u00104R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bX\u00104R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR\u0011\u0010,\u001a\u00020-¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\\¨\u0006¢\u0001"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent;", "", "date", "", "application", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Application;", "service", "", "version", "buildVersion", "buildId", "ddtags", "session", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$VitalAppLaunchEventSession;", "source", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$VitalAppLaunchEventSource;", "view", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$VitalAppLaunchEventView;", "usr", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Usr;", "account", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Account;", "tab", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Tab;", "connectivity", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Connectivity;", "display", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Display;", "synthetics", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Synthetics;", "ciTest", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$CiTest;", "os", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Os;", "device", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Device;", "dd", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Dd;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Context;", "stream", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Stream;", WebViewRumEventMapper.CONTAINER_KEY_NAME, "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Container;", "vital", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Vital;", "(JLcom/datadog/android/rum/model/VitalAppLaunchEvent$Application;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/datadog/android/rum/model/VitalAppLaunchEvent$VitalAppLaunchEventSession;Lcom/datadog/android/rum/model/VitalAppLaunchEvent$VitalAppLaunchEventSource;Lcom/datadog/android/rum/model/VitalAppLaunchEvent$VitalAppLaunchEventView;Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Usr;Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Account;Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Tab;Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Connectivity;Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Display;Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Synthetics;Lcom/datadog/android/rum/model/VitalAppLaunchEvent$CiTest;Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Os;Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Device;Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Dd;Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Context;Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Stream;Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Container;Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Vital;)V", "getAccount", "()Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Account;", "getApplication", "()Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Application;", "getBuildId", "()Ljava/lang/String;", "getBuildVersion", "getCiTest", "()Lcom/datadog/android/rum/model/VitalAppLaunchEvent$CiTest;", "getConnectivity", "()Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Connectivity;", "getContainer", "()Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Container;", "getContext", "()Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Context;", "getDate", "()J", "getDd", "()Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Dd;", "getDdtags", "getDevice", "()Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Device;", "getDisplay", "()Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Display;", "getOs", "()Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Os;", "getService", "getSession", "()Lcom/datadog/android/rum/model/VitalAppLaunchEvent$VitalAppLaunchEventSession;", "getSource", "()Lcom/datadog/android/rum/model/VitalAppLaunchEvent$VitalAppLaunchEventSource;", "getStream", "()Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Stream;", "getSynthetics", "()Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Synthetics;", "getTab", "()Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Tab;", "type", "getType", "getUsr", "()Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Usr;", "getVersion", "getView", "()Lcom/datadog/android/rum/model/VitalAppLaunchEvent$VitalAppLaunchEventView;", "getVital", "()Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Vital;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Account", "AppLaunchMetric", "Application", "Cellular", "CiTest", "Companion", "Configuration", "Connectivity", "ConnectivityStatus", TextFieldImplKt.ContainerId, "ContainerView", "Context", "Dd", "DdSession", "Device", "DeviceType", "Display", "EffectiveType", "ErrorReason", "Interface", "Os", "Plan", "Profiling", "ProfilingStatus", "SessionPrecondition", "StartupType", "Stream", "Synthetics", "Tab", "Usr", "Viewport", "Vital", "VitalAppLaunchEventSession", "VitalAppLaunchEventSessionType", "VitalAppLaunchEventSource", "VitalAppLaunchEventView", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class VitalAppLaunchEvent {

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
    private final Os os;
    private final String service;
    private final VitalAppLaunchEventSession session;
    private final VitalAppLaunchEventSource source;
    private final Stream stream;
    private final Synthetics synthetics;
    private final Tab tab;
    private final String type;
    private final Usr usr;
    private final String version;
    private final VitalAppLaunchEventView view;
    private final Vital vital;

    public static /* synthetic */ VitalAppLaunchEvent copy$default(VitalAppLaunchEvent vitalAppLaunchEvent, long j, Application application, String str, String str2, String str3, String str4, String str5, VitalAppLaunchEventSession vitalAppLaunchEventSession, VitalAppLaunchEventSource vitalAppLaunchEventSource, VitalAppLaunchEventView vitalAppLaunchEventView, Usr usr, Account account, Tab tab, Connectivity connectivity, Display display, Synthetics synthetics, CiTest ciTest, Os os, Device device, Dd dd, Context context, Stream stream, Container container, Vital vital, int i, Object obj) {
        Vital vital2;
        Container container2;
        long j2 = (i & 1) != 0 ? vitalAppLaunchEvent.date : j;
        Application application2 = (i & 2) != 0 ? vitalAppLaunchEvent.application : application;
        String str6 = (i & 4) != 0 ? vitalAppLaunchEvent.service : str;
        String str7 = (i & 8) != 0 ? vitalAppLaunchEvent.version : str2;
        String str8 = (i & 16) != 0 ? vitalAppLaunchEvent.buildVersion : str3;
        String str9 = (i & 32) != 0 ? vitalAppLaunchEvent.buildId : str4;
        String str10 = (i & 64) != 0 ? vitalAppLaunchEvent.ddtags : str5;
        VitalAppLaunchEventSession vitalAppLaunchEventSession2 = (i & 128) != 0 ? vitalAppLaunchEvent.session : vitalAppLaunchEventSession;
        VitalAppLaunchEventSource vitalAppLaunchEventSource2 = (i & 256) != 0 ? vitalAppLaunchEvent.source : vitalAppLaunchEventSource;
        VitalAppLaunchEventView vitalAppLaunchEventView2 = (i & 512) != 0 ? vitalAppLaunchEvent.view : vitalAppLaunchEventView;
        Usr usr2 = (i & 1024) != 0 ? vitalAppLaunchEvent.usr : usr;
        Account account2 = (i & 2048) != 0 ? vitalAppLaunchEvent.account : account;
        Tab tab2 = (i & 4096) != 0 ? vitalAppLaunchEvent.tab : tab;
        long j3 = j2;
        Connectivity connectivity2 = (i & 8192) != 0 ? vitalAppLaunchEvent.connectivity : connectivity;
        Display display2 = (i & 16384) != 0 ? vitalAppLaunchEvent.display : display;
        Synthetics synthetics2 = (i & 32768) != 0 ? vitalAppLaunchEvent.synthetics : synthetics;
        CiTest ciTest2 = (i & 65536) != 0 ? vitalAppLaunchEvent.ciTest : ciTest;
        Os os2 = (i & 131072) != 0 ? vitalAppLaunchEvent.os : os;
        Device device2 = (i & 262144) != 0 ? vitalAppLaunchEvent.device : device;
        Dd dd2 = (i & 524288) != 0 ? vitalAppLaunchEvent.dd : dd;
        Context context2 = (i & 1048576) != 0 ? vitalAppLaunchEvent.context : context;
        Stream stream2 = (i & 2097152) != 0 ? vitalAppLaunchEvent.stream : stream;
        Container container3 = (i & 4194304) != 0 ? vitalAppLaunchEvent.container : container;
        if ((i & 8388608) != 0) {
            container2 = container3;
            vital2 = vitalAppLaunchEvent.vital;
        } else {
            vital2 = vital;
            container2 = container3;
        }
        return vitalAppLaunchEvent.copy(j3, application2, str6, str7, str8, str9, str10, vitalAppLaunchEventSession2, vitalAppLaunchEventSource2, vitalAppLaunchEventView2, usr2, account2, tab2, connectivity2, display2, synthetics2, ciTest2, os2, device2, dd2, context2, stream2, container2, vital2);
    }

    @JvmStatic
    public static final VitalAppLaunchEvent fromJson(String str) throws JsonParseException {
        return INSTANCE.fromJson(str);
    }

    @JvmStatic
    public static final VitalAppLaunchEvent fromJsonObject(JsonObject jsonObject) throws JsonParseException {
        return INSTANCE.fromJsonObject(jsonObject);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final VitalAppLaunchEventView getView() {
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
    public final Vital getVital() {
        return this.vital;
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
    public final VitalAppLaunchEventSession getSession() {
        return this.session;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final VitalAppLaunchEventSource getSource() {
        return this.source;
    }

    public final VitalAppLaunchEvent copy(long date, Application application, String service, String version, String buildVersion, String buildId, String ddtags, VitalAppLaunchEventSession session, VitalAppLaunchEventSource source, VitalAppLaunchEventView view, Usr usr, Account account, Tab tab, Connectivity connectivity, Display display, Synthetics synthetics, CiTest ciTest, Os os, Device device, Dd dd, Context context, Stream stream, Container container, Vital vital) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dd, "dd");
        Intrinsics.checkNotNullParameter(vital, "vital");
        return new VitalAppLaunchEvent(date, application, service, version, buildVersion, buildId, ddtags, session, source, view, usr, account, tab, connectivity, display, synthetics, ciTest, os, device, dd, context, stream, container, vital);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VitalAppLaunchEvent)) {
            return false;
        }
        VitalAppLaunchEvent vitalAppLaunchEvent = (VitalAppLaunchEvent) other;
        return this.date == vitalAppLaunchEvent.date && Intrinsics.areEqual(this.application, vitalAppLaunchEvent.application) && Intrinsics.areEqual(this.service, vitalAppLaunchEvent.service) && Intrinsics.areEqual(this.version, vitalAppLaunchEvent.version) && Intrinsics.areEqual(this.buildVersion, vitalAppLaunchEvent.buildVersion) && Intrinsics.areEqual(this.buildId, vitalAppLaunchEvent.buildId) && Intrinsics.areEqual(this.ddtags, vitalAppLaunchEvent.ddtags) && Intrinsics.areEqual(this.session, vitalAppLaunchEvent.session) && this.source == vitalAppLaunchEvent.source && Intrinsics.areEqual(this.view, vitalAppLaunchEvent.view) && Intrinsics.areEqual(this.usr, vitalAppLaunchEvent.usr) && Intrinsics.areEqual(this.account, vitalAppLaunchEvent.account) && Intrinsics.areEqual(this.tab, vitalAppLaunchEvent.tab) && Intrinsics.areEqual(this.connectivity, vitalAppLaunchEvent.connectivity) && Intrinsics.areEqual(this.display, vitalAppLaunchEvent.display) && Intrinsics.areEqual(this.synthetics, vitalAppLaunchEvent.synthetics) && Intrinsics.areEqual(this.ciTest, vitalAppLaunchEvent.ciTest) && Intrinsics.areEqual(this.os, vitalAppLaunchEvent.os) && Intrinsics.areEqual(this.device, vitalAppLaunchEvent.device) && Intrinsics.areEqual(this.dd, vitalAppLaunchEvent.dd) && Intrinsics.areEqual(this.context, vitalAppLaunchEvent.context) && Intrinsics.areEqual(this.stream, vitalAppLaunchEvent.stream) && Intrinsics.areEqual(this.container, vitalAppLaunchEvent.container) && Intrinsics.areEqual(this.vital, vitalAppLaunchEvent.vital);
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
        VitalAppLaunchEventSource vitalAppLaunchEventSource = this.source;
        int iHashCode7 = (((iHashCode6 + (vitalAppLaunchEventSource == null ? 0 : vitalAppLaunchEventSource.hashCode())) * 31) + this.view.hashCode()) * 31;
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
        return ((iHashCode18 + (container != null ? container.hashCode() : 0)) * 31) + this.vital.hashCode();
    }

    public String toString() {
        return "VitalAppLaunchEvent(date=" + this.date + ", application=" + this.application + ", service=" + this.service + ", version=" + this.version + ", buildVersion=" + this.buildVersion + ", buildId=" + this.buildId + ", ddtags=" + this.ddtags + ", session=" + this.session + ", source=" + this.source + ", view=" + this.view + ", usr=" + this.usr + ", account=" + this.account + ", tab=" + this.tab + ", connectivity=" + this.connectivity + ", display=" + this.display + ", synthetics=" + this.synthetics + ", ciTest=" + this.ciTest + ", os=" + this.os + ", device=" + this.device + ", dd=" + this.dd + ", context=" + this.context + ", stream=" + this.stream + ", container=" + this.container + ", vital=" + this.vital + ")";
    }

    public VitalAppLaunchEvent(long j, Application application, String str, String str2, String str3, String str4, String str5, VitalAppLaunchEventSession session, VitalAppLaunchEventSource vitalAppLaunchEventSource, VitalAppLaunchEventView view, Usr usr, Account account, Tab tab, Connectivity connectivity, Display display, Synthetics synthetics, CiTest ciTest, Os os, Device device, Dd dd, Context context, Stream stream, Container container, Vital vital) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dd, "dd");
        Intrinsics.checkNotNullParameter(vital, "vital");
        this.date = j;
        this.application = application;
        this.service = str;
        this.version = str2;
        this.buildVersion = str3;
        this.buildId = str4;
        this.ddtags = str5;
        this.session = session;
        this.source = vitalAppLaunchEventSource;
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
        this.vital = vital;
        this.type = "vital";
    }

    public /* synthetic */ VitalAppLaunchEvent(long j, Application application, String str, String str2, String str3, String str4, String str5, VitalAppLaunchEventSession vitalAppLaunchEventSession, VitalAppLaunchEventSource vitalAppLaunchEventSource, VitalAppLaunchEventView vitalAppLaunchEventView, Usr usr, Account account, Tab tab, Connectivity connectivity, Display display, Synthetics synthetics, CiTest ciTest, Os os, Device device, Dd dd, Context context, Stream stream, Container container, Vital vital, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, application, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, vitalAppLaunchEventSession, (i & 256) != 0 ? null : vitalAppLaunchEventSource, vitalAppLaunchEventView, (i & 1024) != 0 ? null : usr, (i & 2048) != 0 ? null : account, (i & 4096) != 0 ? null : tab, (i & 8192) != 0 ? null : connectivity, (i & 16384) != 0 ? null : display, (32768 & i) != 0 ? null : synthetics, (65536 & i) != 0 ? null : ciTest, (131072 & i) != 0 ? null : os, (262144 & i) != 0 ? null : device, dd, (1048576 & i) != 0 ? null : context, (2097152 & i) != 0 ? null : stream, (i & 4194304) != 0 ? null : container, vital);
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

    public final VitalAppLaunchEventSession getSession() {
        return this.session;
    }

    public final VitalAppLaunchEventSource getSource() {
        return this.source;
    }

    public final VitalAppLaunchEventView getView() {
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

    public final Vital getVital() {
        return this.vital;
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
        VitalAppLaunchEventSource vitalAppLaunchEventSource = this.source;
        if (vitalAppLaunchEventSource != null) {
            jsonObject.add("source", vitalAppLaunchEventSource.toJson());
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
        jsonObject.addProperty("type", this.type);
        jsonObject.add("vital", this.vital.toJson());
        return jsonObject;
    }

    /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final VitalAppLaunchEvent fromJson(String jsonString) throws JsonParseException {
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            try {
                JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                return fromJsonObject(jsonObject);
            } catch (IllegalStateException e) {
                throw new JsonParseException("Unable to parse json into type VitalAppLaunchEvent", e);
            }
        }

        @JvmStatic
        public final VitalAppLaunchEvent fromJsonObject(JsonObject jsonObject) throws JsonParseException {
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
                VitalAppLaunchEventSession.Companion companion2 = VitalAppLaunchEventSession.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                VitalAppLaunchEventSession vitalAppLaunchEventSessionFromJsonObject = companion2.fromJsonObject(it2);
                JsonElement jsonElement6 = jsonObject.get("source");
                VitalAppLaunchEventSource vitalAppLaunchEventSourceFromJson = (jsonElement6 == null || (asString = jsonElement6.getAsString()) == null) ? null : VitalAppLaunchEventSource.INSTANCE.fromJson(asString);
                JsonObject it3 = jsonObject.get("view").getAsJsonObject();
                VitalAppLaunchEventView.Companion companion3 = VitalAppLaunchEventView.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it3, "it");
                VitalAppLaunchEventView vitalAppLaunchEventViewFromJsonObject = companion3.fromJsonObject(it3);
                JsonElement jsonElement7 = jsonObject.get("usr");
                Usr usrFromJsonObject = (jsonElement7 == null || (asJsonObject12 = jsonElement7.getAsJsonObject()) == null) ? null : Usr.INSTANCE.fromJsonObject(asJsonObject12);
                JsonElement jsonElement8 = jsonObject.get("account");
                Account accountFromJsonObject = (jsonElement8 == null || (asJsonObject11 = jsonElement8.getAsJsonObject()) == null) ? null : Account.INSTANCE.fromJsonObject(asJsonObject11);
                JsonElement jsonElement9 = jsonObject.get("tab");
                Tab tabFromJsonObject = (jsonElement9 == null || (asJsonObject10 = jsonElement9.getAsJsonObject()) == null) ? null : Tab.INSTANCE.fromJsonObject(asJsonObject10);
                JsonElement jsonElement10 = jsonObject.get("connectivity");
                Connectivity connectivityFromJsonObject = (jsonElement10 == null || (asJsonObject9 = jsonElement10.getAsJsonObject()) == null) ? null : Connectivity.INSTANCE.fromJsonObject(asJsonObject9);
                JsonElement jsonElement11 = jsonObject.get("display");
                Display displayFromJsonObject = (jsonElement11 == null || (asJsonObject8 = jsonElement11.getAsJsonObject()) == null) ? null : Display.INSTANCE.fromJsonObject(asJsonObject8);
                JsonElement jsonElement12 = jsonObject.get("synthetics");
                Synthetics syntheticsFromJsonObject = (jsonElement12 == null || (asJsonObject7 = jsonElement12.getAsJsonObject()) == null) ? null : Synthetics.INSTANCE.fromJsonObject(asJsonObject7);
                JsonElement jsonElement13 = jsonObject.get("ci_test");
                CiTest ciTestFromJsonObject = (jsonElement13 == null || (asJsonObject6 = jsonElement13.getAsJsonObject()) == null) ? null : CiTest.INSTANCE.fromJsonObject(asJsonObject6);
                JsonElement jsonElement14 = jsonObject.get("os");
                Os osFromJsonObject = (jsonElement14 == null || (asJsonObject5 = jsonElement14.getAsJsonObject()) == null) ? null : Os.INSTANCE.fromJsonObject(asJsonObject5);
                JsonElement jsonElement15 = jsonObject.get("device");
                Device deviceFromJsonObject = (jsonElement15 == null || (asJsonObject4 = jsonElement15.getAsJsonObject()) == null) ? null : Device.INSTANCE.fromJsonObject(asJsonObject4);
                JsonObject it4 = jsonObject.get(WebViewRumEventMapper.DD_KEY_NAME).getAsJsonObject();
                Dd.Companion companion4 = Dd.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it4, "it");
                Dd ddFromJsonObject = companion4.fromJsonObject(it4);
                JsonElement jsonElement16 = jsonObject.get(RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX);
                Context contextFromJsonObject = (jsonElement16 == null || (asJsonObject3 = jsonElement16.getAsJsonObject()) == null) ? null : Context.INSTANCE.fromJsonObject(asJsonObject3);
                JsonElement jsonElement17 = jsonObject.get("stream");
                Stream streamFromJsonObject = (jsonElement17 == null || (asJsonObject2 = jsonElement17.getAsJsonObject()) == null) ? null : Stream.INSTANCE.fromJsonObject(asJsonObject2);
                JsonElement jsonElement18 = jsonObject.get(WebViewRumEventMapper.CONTAINER_KEY_NAME);
                Container containerFromJsonObject = (jsonElement18 == null || (asJsonObject = jsonElement18.getAsJsonObject()) == null) ? null : Container.INSTANCE.fromJsonObject(asJsonObject);
                String asString7 = jsonObject.get("type").getAsString();
                JsonObject it5 = jsonObject.get("vital").getAsJsonObject();
                Vital.Companion companion5 = Vital.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                Vital vitalFromJsonObject = companion5.fromJsonObject(it5);
                if (!Intrinsics.areEqual(asString7, "vital")) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                return new VitalAppLaunchEvent(asLong, applicationFromJsonObject, asString2, asString3, asString4, asString5, asString6, vitalAppLaunchEventSessionFromJsonObject, vitalAppLaunchEventSourceFromJson, vitalAppLaunchEventViewFromJsonObject, usrFromJsonObject, accountFromJsonObject, tabFromJsonObject, connectivityFromJsonObject, displayFromJsonObject, syntheticsFromJsonObject, ciTestFromJsonObject, osFromJsonObject, deviceFromJsonObject, ddFromJsonObject, contextFromJsonObject, streamFromJsonObject, containerFromJsonObject, vitalFromJsonObject);
            } catch (IllegalStateException e) {
                throw new JsonParseException("Unable to parse json into type VitalAppLaunchEvent", e);
            } catch (NullPointerException e2) {
                throw new JsonParseException("Unable to parse json into type VitalAppLaunchEvent", e2);
            } catch (NumberFormatException e3) {
                throw new JsonParseException("Unable to parse json into type VitalAppLaunchEvent", e3);
            }
        }
    }

    /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Application;", "", "id", "", "currentLocale", "(Ljava/lang/String;Ljava/lang/String;)V", "getCurrentLocale", "()Ljava/lang/String;", "getId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Application$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Application;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\nJ.\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0006\u0010\u0019\u001a\u00020\u001aJ\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$VitalAppLaunchEventSession;", "", "id", "", "type", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$VitalAppLaunchEventSessionType;", "hasReplay", "", "(Ljava/lang/String;Lcom/datadog/android/rum/model/VitalAppLaunchEvent$VitalAppLaunchEventSessionType;Ljava/lang/Boolean;)V", "getHasReplay", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getId", "()Ljava/lang/String;", "getType", "()Lcom/datadog/android/rum/model/VitalAppLaunchEvent$VitalAppLaunchEventSessionType;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Lcom/datadog/android/rum/model/VitalAppLaunchEvent$VitalAppLaunchEventSessionType;Ljava/lang/Boolean;)Lcom/datadog/android/rum/model/VitalAppLaunchEvent$VitalAppLaunchEventSession;", "equals", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class VitalAppLaunchEventSession {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Boolean hasReplay;
        private final String id;
        private final VitalAppLaunchEventSessionType type;

        public static /* synthetic */ VitalAppLaunchEventSession copy$default(VitalAppLaunchEventSession vitalAppLaunchEventSession, String str, VitalAppLaunchEventSessionType vitalAppLaunchEventSessionType, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                str = vitalAppLaunchEventSession.id;
            }
            if ((i & 2) != 0) {
                vitalAppLaunchEventSessionType = vitalAppLaunchEventSession.type;
            }
            if ((i & 4) != 0) {
                bool = vitalAppLaunchEventSession.hasReplay;
            }
            return vitalAppLaunchEventSession.copy(str, vitalAppLaunchEventSessionType, bool);
        }

        @JvmStatic
        public static final VitalAppLaunchEventSession fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final VitalAppLaunchEventSession fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final VitalAppLaunchEventSessionType getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Boolean getHasReplay() {
            return this.hasReplay;
        }

        public final VitalAppLaunchEventSession copy(String id, VitalAppLaunchEventSessionType type, Boolean hasReplay) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            return new VitalAppLaunchEventSession(id, type, hasReplay);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VitalAppLaunchEventSession)) {
                return false;
            }
            VitalAppLaunchEventSession vitalAppLaunchEventSession = (VitalAppLaunchEventSession) other;
            return Intrinsics.areEqual(this.id, vitalAppLaunchEventSession.id) && this.type == vitalAppLaunchEventSession.type && Intrinsics.areEqual(this.hasReplay, vitalAppLaunchEventSession.hasReplay);
        }

        public int hashCode() {
            int iHashCode = ((this.id.hashCode() * 31) + this.type.hashCode()) * 31;
            Boolean bool = this.hasReplay;
            return iHashCode + (bool == null ? 0 : bool.hashCode());
        }

        public String toString() {
            return "VitalAppLaunchEventSession(id=" + this.id + ", type=" + this.type + ", hasReplay=" + this.hasReplay + ")";
        }

        public VitalAppLaunchEventSession(String id, VitalAppLaunchEventSessionType type, Boolean bool) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            this.id = id;
            this.type = type;
            this.hasReplay = bool;
        }

        public /* synthetic */ VitalAppLaunchEventSession(String str, VitalAppLaunchEventSessionType vitalAppLaunchEventSessionType, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, vitalAppLaunchEventSessionType, (i & 4) != 0 ? null : bool);
        }

        public final String getId() {
            return this.id;
        }

        public final VitalAppLaunchEventSessionType getType() {
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

        /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$VitalAppLaunchEventSession$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$VitalAppLaunchEventSession;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final VitalAppLaunchEventSession fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type VitalAppLaunchEventSession", e);
                }
            }

            @JvmStatic
            public final VitalAppLaunchEventSession fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String id = jsonObject.get("id").getAsString();
                    VitalAppLaunchEventSessionType.Companion companion = VitalAppLaunchEventSessionType.INSTANCE;
                    String asString = jsonObject.get("type").getAsString();
                    Intrinsics.checkNotNullExpressionValue(asString, "jsonObject.get(\"type\").asString");
                    VitalAppLaunchEventSessionType vitalAppLaunchEventSessionTypeFromJson = companion.fromJson(asString);
                    JsonElement jsonElement = jsonObject.get("has_replay");
                    Boolean boolValueOf = jsonElement != null ? Boolean.valueOf(jsonElement.getAsBoolean()) : null;
                    Intrinsics.checkNotNullExpressionValue(id, "id");
                    return new VitalAppLaunchEventSession(id, vitalAppLaunchEventSessionTypeFromJson, boolValueOf);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type VitalAppLaunchEventSession", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type VitalAppLaunchEventSession", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type VitalAppLaunchEventSession", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J5\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0006\u0010\u001b\u001a\u00020\u001cJ\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\t\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$VitalAppLaunchEventView;", "", "id", "", "referrer", ImagesContract.URL, "name", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", InsiderHybridMethods.SET_NAME, "(Ljava/lang/String;)V", "getReferrer", "setReferrer", "getUrl", "setUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class VitalAppLaunchEventView {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String id;
        private String name;
        private String referrer;
        private String url;

        public static /* synthetic */ VitalAppLaunchEventView copy$default(VitalAppLaunchEventView vitalAppLaunchEventView, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = vitalAppLaunchEventView.id;
            }
            if ((i & 2) != 0) {
                str2 = vitalAppLaunchEventView.referrer;
            }
            if ((i & 4) != 0) {
                str3 = vitalAppLaunchEventView.url;
            }
            if ((i & 8) != 0) {
                str4 = vitalAppLaunchEventView.name;
            }
            return vitalAppLaunchEventView.copy(str, str2, str3, str4);
        }

        @JvmStatic
        public static final VitalAppLaunchEventView fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final VitalAppLaunchEventView fromJsonObject(JsonObject jsonObject) throws JsonParseException {
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

        public final VitalAppLaunchEventView copy(String id, String referrer, String url, String name) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(url, "url");
            return new VitalAppLaunchEventView(id, referrer, url, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VitalAppLaunchEventView)) {
                return false;
            }
            VitalAppLaunchEventView vitalAppLaunchEventView = (VitalAppLaunchEventView) other;
            return Intrinsics.areEqual(this.id, vitalAppLaunchEventView.id) && Intrinsics.areEqual(this.referrer, vitalAppLaunchEventView.referrer) && Intrinsics.areEqual(this.url, vitalAppLaunchEventView.url) && Intrinsics.areEqual(this.name, vitalAppLaunchEventView.name);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.referrer;
            int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.url.hashCode()) * 31;
            String str2 = this.name;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "VitalAppLaunchEventView(id=" + this.id + ", referrer=" + this.referrer + ", url=" + this.url + ", name=" + this.name + ")";
        }

        public VitalAppLaunchEventView(String id, String str, String url, String str2) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(url, "url");
            this.id = id;
            this.referrer = str;
            this.url = url;
            this.name = str2;
        }

        public /* synthetic */ VitalAppLaunchEventView(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
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

        /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$VitalAppLaunchEventView$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$VitalAppLaunchEventView;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final VitalAppLaunchEventView fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type VitalAppLaunchEventView", e);
                }
            }

            @JvmStatic
            public final VitalAppLaunchEventView fromJsonObject(JsonObject jsonObject) throws JsonParseException {
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
                    return new VitalAppLaunchEventView(id, asString, url, asString2);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type VitalAppLaunchEventView", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type VitalAppLaunchEventView", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type VitalAppLaunchEventView", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fBM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bHÆ\u0003JQ\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0006\u0010\u001c\u001a\u00020\u001dJ\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006 "}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Usr;", "", "id", "", "name", "email", "anonymousId", "additionalProperties", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getAdditionalProperties", "()Ljava/util/Map;", "getAnonymousId", "()Ljava/lang/String;", "getEmail", "getId", "getName", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0007J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Usr$Companion;", "", "()V", "RESERVED_PROPERTIES", "", "", "getRESERVED_PROPERTIES$dd_sdk_android_rum_release", "()[Ljava/lang/String;", "[Ljava/lang/String;", "fromJson", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Usr;", "jsonString", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006HÆ\u0003J7\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0006\u0010\u0016\u001a\u00020\u0017J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Account;", "", "id", "", "name", "additionalProperties", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getAdditionalProperties", "()Ljava/util/Map;", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0007J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Account$Companion;", "", "()V", "RESERVED_PROPERTIES", "", "", "getRESERVED_PROPERTIES$dd_sdk_android_rum_release", "()[Ljava/lang/String;", "[Ljava/lang/String;", "fromJson", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Account;", "jsonString", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Tab;", "", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Tab$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Tab;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\nHÆ\u0003J=\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0006\u0010\u001e\u001a\u00020\u001fJ\t\u0010 \u001a\u00020!HÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006#"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Connectivity;", "", "status", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$ConnectivityStatus;", "interfaces", "", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Interface;", "effectiveType", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$EffectiveType;", "cellular", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Cellular;", "(Lcom/datadog/android/rum/model/VitalAppLaunchEvent$ConnectivityStatus;Ljava/util/List;Lcom/datadog/android/rum/model/VitalAppLaunchEvent$EffectiveType;Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Cellular;)V", "getCellular", "()Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Cellular;", "getEffectiveType", "()Lcom/datadog/android/rum/model/VitalAppLaunchEvent$EffectiveType;", "getInterfaces", "()Ljava/util/List;", "getStatus", "()Lcom/datadog/android/rum/model/VitalAppLaunchEvent$ConnectivityStatus;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Connectivity$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Connectivity;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Display;", "", "viewport", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Viewport;", "(Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Viewport;)V", "getViewport", "()Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Viewport;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Display$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Display;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\u0017\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bHÆ\u0003JF\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0006\u0010\u001c\u001a\u00020\u001dJ\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006 "}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Synthetics;", "", "testId", "", "resultId", "injected", "", "additionalProperties", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Map;)V", "getAdditionalProperties", "()Ljava/util/Map;", "getInjected", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getResultId", "()Ljava/lang/String;", "getTestId", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Map;)Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Synthetics;", "equals", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0007J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Synthetics$Companion;", "", "()V", "RESERVED_PROPERTIES", "", "", "getRESERVED_PROPERTIES$dd_sdk_android_rum_release", "()[Ljava/lang/String;", "[Ljava/lang/String;", "fromJson", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Synthetics;", "jsonString", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$CiTest;", "", "testExecutionId", "", "(Ljava/lang/String;)V", "getTestExecutionId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$CiTest$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$CiTest;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0006\u0010\u0017\u001a\u00020\u0018J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Os;", "", "name", "", "version", "build", "versionMajor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBuild", "()Ljava/lang/String;", "getName", "getVersion", "getVersionMajor", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Os$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Os;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u000b\n\u0002\b+\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 @2\u00020\u0001:\u0001@B³\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0015J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010+\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u000eHÆ\u0003J¼\u0001\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u00108J\u0013\u00109\u001a\u00020\u00102\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020<HÖ\u0001J\u0006\u0010=\u001a\u00020>J\t\u0010?\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u0014\u0010\u001cR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b$\u0010\u001cR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u0006A"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Device;", "", "type", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$DeviceType;", "name", "", "model", "brand", "architecture", Constants.LOCALE, "locales", "", "timeZone", "batteryLevel", "", "powerSavingMode", "", "brightnessLevel", "logicalCpuCount", "totalRam", "isLowRam", "(Lcom/datadog/android/rum/model/VitalAppLaunchEvent$DeviceType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Boolean;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Boolean;)V", "getArchitecture", "()Ljava/lang/String;", "getBatteryLevel", "()Ljava/lang/Number;", "getBrand", "getBrightnessLevel", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLocale", "getLocales", "()Ljava/util/List;", "getLogicalCpuCount", "getModel", "getName", "getPowerSavingMode", "getTimeZone", "getTotalRam", "getType", "()Lcom/datadog/android/rum/model/VitalAppLaunchEvent$DeviceType;", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/datadog/android/rum/model/VitalAppLaunchEvent$DeviceType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Boolean;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Boolean;)Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Device;", "equals", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Device$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Device;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0001'BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0006\u0010$\u001a\u00020%J\t\u0010&\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006("}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Dd;", "", "session", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$DdSession;", "configuration", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Configuration;", "browserSdkVersion", "", "sdkName", "profiling", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Profiling;", "(Lcom/datadog/android/rum/model/VitalAppLaunchEvent$DdSession;Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Configuration;Ljava/lang/String;Ljava/lang/String;Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Profiling;)V", "getBrowserSdkVersion", "()Ljava/lang/String;", "getConfiguration", "()Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Configuration;", "formatVersion", "", "getFormatVersion", "()J", "getProfiling", "()Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Profiling;", "getSdkName", "getSession", "()Lcom/datadog/android/rum/model/VitalAppLaunchEvent$DdSession;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Dd {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String browserSdkVersion;
        private final Configuration configuration;
        private final long formatVersion;
        private final Profiling profiling;
        private final String sdkName;
        private final DdSession session;

        public Dd() {
            this(null, null, null, null, null, 31, null);
        }

        public static /* synthetic */ Dd copy$default(Dd dd, DdSession ddSession, Configuration configuration, String str, String str2, Profiling profiling, int i, Object obj) {
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
                profiling = dd.profiling;
            }
            Profiling profiling2 = profiling;
            String str3 = str;
            return dd.copy(ddSession, configuration, str3, str2, profiling2);
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
        public final Profiling getProfiling() {
            return this.profiling;
        }

        public final Dd copy(DdSession session, Configuration configuration, String browserSdkVersion, String sdkName, Profiling profiling) {
            return new Dd(session, configuration, browserSdkVersion, sdkName, profiling);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Dd)) {
                return false;
            }
            Dd dd = (Dd) other;
            return Intrinsics.areEqual(this.session, dd.session) && Intrinsics.areEqual(this.configuration, dd.configuration) && Intrinsics.areEqual(this.browserSdkVersion, dd.browserSdkVersion) && Intrinsics.areEqual(this.sdkName, dd.sdkName) && Intrinsics.areEqual(this.profiling, dd.profiling);
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
            Profiling profiling = this.profiling;
            return iHashCode4 + (profiling != null ? profiling.hashCode() : 0);
        }

        public String toString() {
            return "Dd(session=" + this.session + ", configuration=" + this.configuration + ", browserSdkVersion=" + this.browserSdkVersion + ", sdkName=" + this.sdkName + ", profiling=" + this.profiling + ")";
        }

        public Dd(DdSession ddSession, Configuration configuration, String str, String str2, Profiling profiling) {
            this.session = ddSession;
            this.configuration = configuration;
            this.browserSdkVersion = str;
            this.sdkName = str2;
            this.profiling = profiling;
            this.formatVersion = 2L;
        }

        public /* synthetic */ Dd(DdSession ddSession, Configuration configuration, String str, String str2, Profiling profiling, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : ddSession, (i & 2) != 0 ? null : configuration, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : profiling);
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
            Profiling profiling = this.profiling;
            if (profiling != null) {
                jsonObject.add("profiling", profiling.toJson());
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Dd$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Dd;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
                    JsonElement jsonElement5 = jsonObject.get("profiling");
                    if (jsonElement5 != null && (asJsonObject = jsonElement5.getAsJsonObject()) != null) {
                        profilingFromJsonObject = Profiling.INSTANCE.fromJsonObject(asJsonObject);
                    }
                    if (asLong != 2) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    return new Dd(ddSessionFromJsonObject, configurationFromJsonObject, asString, asString2, profilingFromJsonObject);
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

    /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001d\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0017\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003HÆ\u0003J!\u0010\t\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Context;", "", "additionalProperties", "", "", "(Ljava/util/Map;)V", "getAdditionalProperties", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Context$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Context;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Stream;", "", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Stream$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Stream;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Container;", "", "view", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$ContainerView;", "source", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$VitalAppLaunchEventSource;", "(Lcom/datadog/android/rum/model/VitalAppLaunchEvent$ContainerView;Lcom/datadog/android/rum/model/VitalAppLaunchEvent$VitalAppLaunchEventSource;)V", "getSource", "()Lcom/datadog/android/rum/model/VitalAppLaunchEvent$VitalAppLaunchEventSource;", "getView", "()Lcom/datadog/android/rum/model/VitalAppLaunchEvent$ContainerView;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Container {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final VitalAppLaunchEventSource source;
        private final ContainerView view;

        public static /* synthetic */ Container copy$default(Container container, ContainerView containerView, VitalAppLaunchEventSource vitalAppLaunchEventSource, int i, Object obj) {
            if ((i & 1) != 0) {
                containerView = container.view;
            }
            if ((i & 2) != 0) {
                vitalAppLaunchEventSource = container.source;
            }
            return container.copy(containerView, vitalAppLaunchEventSource);
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
        public final VitalAppLaunchEventSource getSource() {
            return this.source;
        }

        public final Container copy(ContainerView view, VitalAppLaunchEventSource source) {
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

        public Container(ContainerView view, VitalAppLaunchEventSource source) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(source, "source");
            this.view = view;
            this.source = source;
        }

        public final ContainerView getView() {
            return this.view;
        }

        public final VitalAppLaunchEventSource getSource() {
            return this.source;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("view", this.view.toJson());
            jsonObject.add("source", this.source.toJson());
            return jsonObject;
        }

        /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Container$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Container;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
                    VitalAppLaunchEventSource.Companion companion2 = VitalAppLaunchEventSource.INSTANCE;
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

    /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 02\u00020\u0001:\u00010BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000fJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010&\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0017Jh\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020\r2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\u0006\u0010-\u001a\u00020.J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\f\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u0003X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013¨\u00061"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Vital;", "", "id", "", "name", "description", "appLaunchMetric", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$AppLaunchMetric;", "duration", "", "startupType", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$StartupType;", "isPrewarmed", "", "hasSavedInstanceStateBundle", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/datadog/android/rum/model/VitalAppLaunchEvent$AppLaunchMetric;Ljava/lang/Number;Lcom/datadog/android/rum/model/VitalAppLaunchEvent$StartupType;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getAppLaunchMetric", "()Lcom/datadog/android/rum/model/VitalAppLaunchEvent$AppLaunchMetric;", "getDescription", "()Ljava/lang/String;", "getDuration", "()Ljava/lang/Number;", "getHasSavedInstanceStateBundle", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getId", "getName", "getStartupType", "()Lcom/datadog/android/rum/model/VitalAppLaunchEvent$StartupType;", "type", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/datadog/android/rum/model/VitalAppLaunchEvent$AppLaunchMetric;Ljava/lang/Number;Lcom/datadog/android/rum/model/VitalAppLaunchEvent$StartupType;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Vital;", "equals", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Vital {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final AppLaunchMetric appLaunchMetric;
        private final String description;
        private final Number duration;
        private final Boolean hasSavedInstanceStateBundle;
        private final String id;
        private final Boolean isPrewarmed;
        private final String name;
        private final StartupType startupType;
        private final String type;

        public static /* synthetic */ Vital copy$default(Vital vital, String str, String str2, String str3, AppLaunchMetric appLaunchMetric, Number number, StartupType startupType, Boolean bool, Boolean bool2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = vital.id;
            }
            if ((i & 2) != 0) {
                str2 = vital.name;
            }
            if ((i & 4) != 0) {
                str3 = vital.description;
            }
            if ((i & 8) != 0) {
                appLaunchMetric = vital.appLaunchMetric;
            }
            if ((i & 16) != 0) {
                number = vital.duration;
            }
            if ((i & 32) != 0) {
                startupType = vital.startupType;
            }
            if ((i & 64) != 0) {
                bool = vital.isPrewarmed;
            }
            if ((i & 128) != 0) {
                bool2 = vital.hasSavedInstanceStateBundle;
            }
            Boolean bool3 = bool;
            Boolean bool4 = bool2;
            Number number2 = number;
            StartupType startupType2 = startupType;
            return vital.copy(str, str2, str3, appLaunchMetric, number2, startupType2, bool3, bool4);
        }

        @JvmStatic
        public static final Vital fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Vital fromJsonObject(JsonObject jsonObject) throws JsonParseException {
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
        public final String getDescription() {
            return this.description;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final AppLaunchMetric getAppLaunchMetric() {
            return this.appLaunchMetric;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Number getDuration() {
            return this.duration;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final StartupType getStartupType() {
            return this.startupType;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Boolean getIsPrewarmed() {
            return this.isPrewarmed;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Boolean getHasSavedInstanceStateBundle() {
            return this.hasSavedInstanceStateBundle;
        }

        public final Vital copy(String id, String name, String description, AppLaunchMetric appLaunchMetric, Number duration, StartupType startupType, Boolean isPrewarmed, Boolean hasSavedInstanceStateBundle) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(appLaunchMetric, "appLaunchMetric");
            Intrinsics.checkNotNullParameter(duration, "duration");
            return new Vital(id, name, description, appLaunchMetric, duration, startupType, isPrewarmed, hasSavedInstanceStateBundle);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Vital)) {
                return false;
            }
            Vital vital = (Vital) other;
            return Intrinsics.areEqual(this.id, vital.id) && Intrinsics.areEqual(this.name, vital.name) && Intrinsics.areEqual(this.description, vital.description) && this.appLaunchMetric == vital.appLaunchMetric && Intrinsics.areEqual(this.duration, vital.duration) && this.startupType == vital.startupType && Intrinsics.areEqual(this.isPrewarmed, vital.isPrewarmed) && Intrinsics.areEqual(this.hasSavedInstanceStateBundle, vital.hasSavedInstanceStateBundle);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.name;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.description;
            int iHashCode3 = (((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.appLaunchMetric.hashCode()) * 31) + this.duration.hashCode()) * 31;
            StartupType startupType = this.startupType;
            int iHashCode4 = (iHashCode3 + (startupType == null ? 0 : startupType.hashCode())) * 31;
            Boolean bool = this.isPrewarmed;
            int iHashCode5 = (iHashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.hasSavedInstanceStateBundle;
            return iHashCode5 + (bool2 != null ? bool2.hashCode() : 0);
        }

        public String toString() {
            return "Vital(id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", appLaunchMetric=" + this.appLaunchMetric + ", duration=" + this.duration + ", startupType=" + this.startupType + ", isPrewarmed=" + this.isPrewarmed + ", hasSavedInstanceStateBundle=" + this.hasSavedInstanceStateBundle + ")";
        }

        public Vital(String id, String str, String str2, AppLaunchMetric appLaunchMetric, Number duration, StartupType startupType, Boolean bool, Boolean bool2) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(appLaunchMetric, "appLaunchMetric");
            Intrinsics.checkNotNullParameter(duration, "duration");
            this.id = id;
            this.name = str;
            this.description = str2;
            this.appLaunchMetric = appLaunchMetric;
            this.duration = duration;
            this.startupType = startupType;
            this.isPrewarmed = bool;
            this.hasSavedInstanceStateBundle = bool2;
            this.type = SessionEndedMetric.VIEW_COUNTS_APP_LAUNCH_KEY;
        }

        public /* synthetic */ Vital(String str, String str2, String str3, AppLaunchMetric appLaunchMetric, Number number, StartupType startupType, Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, appLaunchMetric, number, (i & 32) != 0 ? null : startupType, (i & 64) != 0 ? null : bool, (i & 128) != 0 ? null : bool2);
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public final String getDescription() {
            return this.description;
        }

        public final AppLaunchMetric getAppLaunchMetric() {
            return this.appLaunchMetric;
        }

        public final Number getDuration() {
            return this.duration;
        }

        public final StartupType getStartupType() {
            return this.startupType;
        }

        public final Boolean isPrewarmed() {
            return this.isPrewarmed;
        }

        public final Boolean getHasSavedInstanceStateBundle() {
            return this.hasSavedInstanceStateBundle;
        }

        public final String getType() {
            return this.type;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id", this.id);
            String str = this.name;
            if (str != null) {
                jsonObject.addProperty("name", str);
            }
            String str2 = this.description;
            if (str2 != null) {
                jsonObject.addProperty("description", str2);
            }
            jsonObject.addProperty("type", this.type);
            jsonObject.add("app_launch_metric", this.appLaunchMetric.toJson());
            jsonObject.addProperty("duration", this.duration);
            StartupType startupType = this.startupType;
            if (startupType != null) {
                jsonObject.add("startup_type", startupType.toJson());
            }
            Boolean bool = this.isPrewarmed;
            if (bool != null) {
                bool.booleanValue();
                jsonObject.addProperty("is_prewarmed", bool);
            }
            Boolean bool2 = this.hasSavedInstanceStateBundle;
            if (bool2 != null) {
                bool2.booleanValue();
                jsonObject.addProperty("has_saved_instance_state_bundle", bool2);
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Vital$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Vital;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Vital fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Vital", e);
                }
            }

            @JvmStatic
            public final Vital fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                String asString;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String id = jsonObject.get("id").getAsString();
                    JsonElement jsonElement = jsonObject.get("name");
                    String asString2 = jsonElement != null ? jsonElement.getAsString() : null;
                    JsonElement jsonElement2 = jsonObject.get("description");
                    String asString3 = jsonElement2 != null ? jsonElement2.getAsString() : null;
                    String asString4 = jsonObject.get("type").getAsString();
                    AppLaunchMetric.Companion companion = AppLaunchMetric.INSTANCE;
                    String asString5 = jsonObject.get("app_launch_metric").getAsString();
                    Intrinsics.checkNotNullExpressionValue(asString5, "jsonObject.get(\"app_launch_metric\").asString");
                    AppLaunchMetric appLaunchMetricFromJson = companion.fromJson(asString5);
                    Number duration = jsonObject.get("duration").getAsNumber();
                    JsonElement jsonElement3 = jsonObject.get("startup_type");
                    StartupType startupTypeFromJson = (jsonElement3 == null || (asString = jsonElement3.getAsString()) == null) ? null : StartupType.INSTANCE.fromJson(asString);
                    JsonElement jsonElement4 = jsonObject.get("is_prewarmed");
                    Boolean boolValueOf = jsonElement4 != null ? Boolean.valueOf(jsonElement4.getAsBoolean()) : null;
                    JsonElement jsonElement5 = jsonObject.get("has_saved_instance_state_bundle");
                    Boolean boolValueOf2 = jsonElement5 != null ? Boolean.valueOf(jsonElement5.getAsBoolean()) : null;
                    if (!Intrinsics.areEqual(asString4, SessionEndedMetric.VIEW_COUNTS_APP_LAUNCH_KEY)) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    Intrinsics.checkNotNullExpressionValue(id, "id");
                    Intrinsics.checkNotNullExpressionValue(duration, "duration");
                    return new Vital(id, asString2, asString3, appLaunchMetricFromJson, duration, startupTypeFromJson, boolValueOf, boolValueOf2);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Vital", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Vital", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Vital", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Cellular;", "", "technology", "", "carrierName", "(Ljava/lang/String;Ljava/lang/String;)V", "getCarrierName", "()Ljava/lang/String;", "getTechnology", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Cellular$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Cellular;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0004\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Viewport;", "", ViewProps.WIDTH, "", ViewProps.HEIGHT, "(Ljava/lang/Number;Ljava/lang/Number;)V", "getHeight", "()Ljava/lang/Number;", "getWidth", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Viewport$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Viewport;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$DdSession;", "", "plan", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Plan;", "sessionPrecondition", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$SessionPrecondition;", "(Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Plan;Lcom/datadog/android/rum/model/VitalAppLaunchEvent$SessionPrecondition;)V", "getPlan", "()Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Plan;", "getSessionPrecondition", "()Lcom/datadog/android/rum/model/VitalAppLaunchEvent$SessionPrecondition;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$DdSession$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$DdSession;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001 BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003JI\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0006\u0010\u001d\u001a\u00020\u001eJ\t\u0010\u001f\u001a\u00020\tHÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006!"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Configuration;", "", RumSessionScope.RUM_SESSION_SAMPLE_RATE_BUS_MESSAGE_KEY, "", "sessionReplaySampleRate", "profilingSampleRate", "traceSampleRate", "sessionReplayExperimentalFeatures", "", "", "(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/util/List;)V", "getProfilingSampleRate", "()Ljava/lang/Number;", "getSessionReplayExperimentalFeatures", "()Ljava/util/List;", "getSessionReplaySampleRate", "getSessionSampleRate", "getTraceSampleRate", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Configuration$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Configuration;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001 B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0006\u0010\u001d\u001a\u00020\u001eJ\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Profiling;", "", "status", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$ProfilingStatus;", "errorReason", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$ErrorReason;", "quotaReason", "", "clockDrift", "", "(Lcom/datadog/android/rum/model/VitalAppLaunchEvent$ProfilingStatus;Lcom/datadog/android/rum/model/VitalAppLaunchEvent$ErrorReason;Ljava/lang/String;Ljava/lang/Number;)V", "getClockDrift", "()Ljava/lang/Number;", "getErrorReason", "()Lcom/datadog/android/rum/model/VitalAppLaunchEvent$ErrorReason;", "getQuotaReason", "()Ljava/lang/String;", "getStatus", "()Lcom/datadog/android/rum/model/VitalAppLaunchEvent$ProfilingStatus;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Profiling$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Profiling;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$ContainerView;", "", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$ContainerView$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$ContainerView;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$VitalAppLaunchEventSource;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "ANDROID", "IOS", "BROWSER", "FLUTTER", "REACT_NATIVE", "ROKU", "UNITY", "KOTLIN_MULTIPLATFORM", "ELECTRON", "CPP", "MAUI", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum VitalAppLaunchEventSource {
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
        public static final VitalAppLaunchEventSource fromJson(String str) {
            return INSTANCE.fromJson(str);
        }

        VitalAppLaunchEventSource(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$VitalAppLaunchEventSource$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$VitalAppLaunchEventSource;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final VitalAppLaunchEventSource fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (VitalAppLaunchEventSource vitalAppLaunchEventSource : VitalAppLaunchEventSource.values()) {
                    if (Intrinsics.areEqual(vitalAppLaunchEventSource.jsonValue, jsonString)) {
                        return vitalAppLaunchEventSource;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$VitalAppLaunchEventSessionType;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "USER", "SYNTHETICS", "CI_TEST", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum VitalAppLaunchEventSessionType {
        USER("user"),
        SYNTHETICS("synthetics"),
        CI_TEST("ci_test");


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String jsonValue;

        @JvmStatic
        public static final VitalAppLaunchEventSessionType fromJson(String str) {
            return INSTANCE.fromJson(str);
        }

        VitalAppLaunchEventSessionType(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$VitalAppLaunchEventSessionType$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$VitalAppLaunchEventSessionType;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final VitalAppLaunchEventSessionType fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (VitalAppLaunchEventSessionType vitalAppLaunchEventSessionType : VitalAppLaunchEventSessionType.values()) {
                    if (Intrinsics.areEqual(vitalAppLaunchEventSessionType.jsonValue, jsonString)) {
                        return vitalAppLaunchEventSessionType;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$ConnectivityStatus;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "CONNECTED", "NOT_CONNECTED", "MAYBE", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$ConnectivityStatus$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$ConnectivityStatus;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Interface;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "BLUETOOTH", "CELLULAR", "ETHERNET", "WIFI", "WIMAX", "MIXED", "OTHER", "UNKNOWN", ProfilingConfig.PROFILING_DATADOG_PROFILER_LOG_LEVEL_DEFAULT, "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Interface$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Interface;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$EffectiveType;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "SLOW_2G", "2G", "3G", "4G", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum EffectiveType {
        SLOW_2G("slow-2g"),
        f622G("2g"),
        f633G("3g"),
        f644G("4g");


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

        /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$EffectiveType$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$EffectiveType;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$DeviceType;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "MOBILE", "DESKTOP", "TABLET", "TV", "GAMING_CONSOLE", "BOT", "OTHER", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$DeviceType$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$DeviceType;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$AppLaunchMetric;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "TTID", "TTFD", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum AppLaunchMetric {
        TTID("ttid"),
        TTFD("ttfd");


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String jsonValue;

        @JvmStatic
        public static final AppLaunchMetric fromJson(String str) {
            return INSTANCE.fromJson(str);
        }

        AppLaunchMetric(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$AppLaunchMetric$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$AppLaunchMetric;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final AppLaunchMetric fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (AppLaunchMetric appLaunchMetric : AppLaunchMetric.values()) {
                    if (Intrinsics.areEqual(appLaunchMetric.jsonValue, jsonString)) {
                        return appLaunchMetric;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$StartupType;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "COLD_START", "WARM_START", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum StartupType {
        COLD_START("cold_start"),
        WARM_START("warm_start");


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String jsonValue;

        @JvmStatic
        public static final StartupType fromJson(String str) {
            return INSTANCE.fromJson(str);
        }

        StartupType(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$StartupType$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$StartupType;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final StartupType fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (StartupType startupType : StartupType.values()) {
                    if (Intrinsics.areEqual(startupType.jsonValue, jsonString)) {
                        return startupType;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Plan;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/Number;)V", "toJson", "Lcom/google/gson/JsonElement;", "PLAN_1", "PLAN_2", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Plan$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Plan;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$SessionPrecondition;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "USER_APP_LAUNCH", "INACTIVITY_TIMEOUT", "MAX_DURATION", "BACKGROUND_LAUNCH", "PREWARM", "FROM_NON_INTERACTIVE_SESSION", "EXPLICIT_STOP", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$SessionPrecondition$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$SessionPrecondition;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$ProfilingStatus;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "STARTING", DebugCoroutineInfoImplKt.RUNNING, "STOPPED", MediaError.ERROR_TYPE_ERROR, "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$ProfilingStatus$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$ProfilingStatus;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$ErrorReason;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "NOT_SUPPORTED_BY_BROWSER", "FAILED_TO_LAZY_LOAD", "MISSING_DOCUMENT_POLICY_HEADER", "UNEXPECTED_EXCEPTION", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: VitalAppLaunchEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/model/VitalAppLaunchEvent$ErrorReason$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$ErrorReason;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

package com.datadog.android.telemetry.model;

import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import com.datadog.android.core.internal.metrics.BatchMetricsDispatcher;
import com.datadog.android.core.internal.utils.JsonSerializer;
import com.datadog.android.rum.internal.domain.scope.RumSessionScope;
import com.datadog.android.webview.internal.rum.WebViewRumEventMapper;
import com.datadog.reactnative.DefaultConfiguration;
import com.datadog.trace.core.propagation.B3HttpCodec;
import com.google.android.gms.cast.CredentialsData;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import expo.modules.interfaces.permissions.PermissionsResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.language.bm.Rule;

/* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0086\b\u0018\u0000 J2\u00020\u0001:\u0013HIJKLMNOPQRSTUVWXYZB\u0083\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018¢\u0006\u0002\u0010\u0019J\t\u00103\u001a\u00020\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u0011\u00105\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0016HÆ\u0003J\t\u00106\u001a\u00020\u0018HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0007HÆ\u0003J\t\u00109\u001a\u00020\tHÆ\u0003J\t\u0010:\u001a\u00020\u0007HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0093\u0001\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018HÆ\u0001J\u0013\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010C\u001a\u00020DHÖ\u0001J\u0006\u0010E\u001a\u00020FJ\t\u0010G\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0019\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b/\u0010'R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b0\u0010'R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b1\u00102¨\u0006["}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent;", "", "dd", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Dd;", "date", "", "service", "", "source", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Source;", "version", "application", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Application;", "session", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Session;", "view", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$View;", "action", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Action;", "effectiveSampleRate", "", "experimentalFeatures", "", "telemetry", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Telemetry;", "(Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Dd;JLjava/lang/String;Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Source;Ljava/lang/String;Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Application;Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Session;Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$View;Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Action;Ljava/lang/Number;Ljava/util/List;Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Telemetry;)V", "getAction", "()Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Action;", "getApplication", "()Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Application;", "getDate", "()J", "getDd", "()Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Dd;", "getEffectiveSampleRate", "()Ljava/lang/Number;", "getExperimentalFeatures", "()Ljava/util/List;", "getService", "()Ljava/lang/String;", "getSession", "()Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Session;", "getSource", "()Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Source;", "getTelemetry", "()Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Telemetry;", "type", "getType", "getVersion", "getView", "()Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$View;", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Action", "Application", "Companion", "Configuration", "Dd", "Device", "Os", "Plugin", "SelectedTracingPropagator", "Session", "SessionPersistence", "Source", "Telemetry", "TraceContextInjection", "TrackFeatureFlagsForEvent", "TrackResourceHeaders", "TrackingConsent", "View", "ViewTrackingStrategy", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class TelemetryConfigurationEvent {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Action action;
    private final Application application;
    private final long date;
    private final Dd dd;
    private final Number effectiveSampleRate;
    private final List<String> experimentalFeatures;
    private final String service;
    private final Session session;
    private final Source source;
    private final Telemetry telemetry;
    private final String type;
    private final String version;
    private final View view;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TelemetryConfigurationEvent copy$default(TelemetryConfigurationEvent telemetryConfigurationEvent, Dd dd, long j, String str, Source source, String str2, Application application, Session session, View view, Action action, Number number, List list, Telemetry telemetry, int i, Object obj) {
        if ((i & 1) != 0) {
            dd = telemetryConfigurationEvent.dd;
        }
        return telemetryConfigurationEvent.copy(dd, (i & 2) != 0 ? telemetryConfigurationEvent.date : j, (i & 4) != 0 ? telemetryConfigurationEvent.service : str, (i & 8) != 0 ? telemetryConfigurationEvent.source : source, (i & 16) != 0 ? telemetryConfigurationEvent.version : str2, (i & 32) != 0 ? telemetryConfigurationEvent.application : application, (i & 64) != 0 ? telemetryConfigurationEvent.session : session, (i & 128) != 0 ? telemetryConfigurationEvent.view : view, (i & 256) != 0 ? telemetryConfigurationEvent.action : action, (i & 512) != 0 ? telemetryConfigurationEvent.effectiveSampleRate : number, (i & 1024) != 0 ? telemetryConfigurationEvent.experimentalFeatures : list, (i & 2048) != 0 ? telemetryConfigurationEvent.telemetry : telemetry);
    }

    @JvmStatic
    public static final TelemetryConfigurationEvent fromJson(String str) throws JsonParseException {
        return INSTANCE.fromJson(str);
    }

    @JvmStatic
    public static final TelemetryConfigurationEvent fromJsonObject(JsonObject jsonObject) throws JsonParseException {
        return INSTANCE.fromJsonObject(jsonObject);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Dd getDd() {
        return this.dd;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Number getEffectiveSampleRate() {
        return this.effectiveSampleRate;
    }

    public final List<String> component11() {
        return this.experimentalFeatures;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Telemetry getTelemetry() {
        return this.telemetry;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getService() {
        return this.service;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Source getSource() {
        return this.source;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Session getSession() {
        return this.session;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final View getView() {
        return this.view;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Action getAction() {
        return this.action;
    }

    public final TelemetryConfigurationEvent copy(Dd dd, long date, String service, Source source, String version, Application application, Session session, View view, Action action, Number effectiveSampleRate, List<String> experimentalFeatures, Telemetry telemetry) {
        Intrinsics.checkNotNullParameter(dd, "dd");
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(telemetry, "telemetry");
        return new TelemetryConfigurationEvent(dd, date, service, source, version, application, session, view, action, effectiveSampleRate, experimentalFeatures, telemetry);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TelemetryConfigurationEvent)) {
            return false;
        }
        TelemetryConfigurationEvent telemetryConfigurationEvent = (TelemetryConfigurationEvent) other;
        return Intrinsics.areEqual(this.dd, telemetryConfigurationEvent.dd) && this.date == telemetryConfigurationEvent.date && Intrinsics.areEqual(this.service, telemetryConfigurationEvent.service) && this.source == telemetryConfigurationEvent.source && Intrinsics.areEqual(this.version, telemetryConfigurationEvent.version) && Intrinsics.areEqual(this.application, telemetryConfigurationEvent.application) && Intrinsics.areEqual(this.session, telemetryConfigurationEvent.session) && Intrinsics.areEqual(this.view, telemetryConfigurationEvent.view) && Intrinsics.areEqual(this.action, telemetryConfigurationEvent.action) && Intrinsics.areEqual(this.effectiveSampleRate, telemetryConfigurationEvent.effectiveSampleRate) && Intrinsics.areEqual(this.experimentalFeatures, telemetryConfigurationEvent.experimentalFeatures) && Intrinsics.areEqual(this.telemetry, telemetryConfigurationEvent.telemetry);
    }

    public int hashCode() {
        int iHashCode = ((((((((this.dd.hashCode() * 31) + Long.hashCode(this.date)) * 31) + this.service.hashCode()) * 31) + this.source.hashCode()) * 31) + this.version.hashCode()) * 31;
        Application application = this.application;
        int iHashCode2 = (iHashCode + (application == null ? 0 : application.hashCode())) * 31;
        Session session = this.session;
        int iHashCode3 = (iHashCode2 + (session == null ? 0 : session.hashCode())) * 31;
        View view = this.view;
        int iHashCode4 = (iHashCode3 + (view == null ? 0 : view.hashCode())) * 31;
        Action action = this.action;
        int iHashCode5 = (iHashCode4 + (action == null ? 0 : action.hashCode())) * 31;
        Number number = this.effectiveSampleRate;
        int iHashCode6 = (iHashCode5 + (number == null ? 0 : number.hashCode())) * 31;
        List<String> list = this.experimentalFeatures;
        return ((iHashCode6 + (list != null ? list.hashCode() : 0)) * 31) + this.telemetry.hashCode();
    }

    public String toString() {
        return "TelemetryConfigurationEvent(dd=" + this.dd + ", date=" + this.date + ", service=" + this.service + ", source=" + this.source + ", version=" + this.version + ", application=" + this.application + ", session=" + this.session + ", view=" + this.view + ", action=" + this.action + ", effectiveSampleRate=" + this.effectiveSampleRate + ", experimentalFeatures=" + this.experimentalFeatures + ", telemetry=" + this.telemetry + ")";
    }

    public TelemetryConfigurationEvent(Dd dd, long j, String service, Source source, String version, Application application, Session session, View view, Action action, Number number, List<String> list, Telemetry telemetry) {
        Intrinsics.checkNotNullParameter(dd, "dd");
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(telemetry, "telemetry");
        this.dd = dd;
        this.date = j;
        this.service = service;
        this.source = source;
        this.version = version;
        this.application = application;
        this.session = session;
        this.view = view;
        this.action = action;
        this.effectiveSampleRate = number;
        this.experimentalFeatures = list;
        this.telemetry = telemetry;
        this.type = "telemetry";
    }

    public /* synthetic */ TelemetryConfigurationEvent(Dd dd, long j, String str, Source source, String str2, Application application, Session session, View view, Action action, Number number, List list, Telemetry telemetry, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dd, j, str, source, str2, (i & 32) != 0 ? null : application, (i & 64) != 0 ? null : session, (i & 128) != 0 ? null : view, (i & 256) != 0 ? null : action, (i & 512) != 0 ? null : number, (i & 1024) != 0 ? null : list, telemetry);
    }

    public final Dd getDd() {
        return this.dd;
    }

    public final long getDate() {
        return this.date;
    }

    public final String getService() {
        return this.service;
    }

    public final Source getSource() {
        return this.source;
    }

    public final String getVersion() {
        return this.version;
    }

    public final Application getApplication() {
        return this.application;
    }

    public final Session getSession() {
        return this.session;
    }

    public final View getView() {
        return this.view;
    }

    public final Action getAction() {
        return this.action;
    }

    public final Number getEffectiveSampleRate() {
        return this.effectiveSampleRate;
    }

    public final List<String> getExperimentalFeatures() {
        return this.experimentalFeatures;
    }

    public final Telemetry getTelemetry() {
        return this.telemetry;
    }

    public final String getType() {
        return this.type;
    }

    public final JsonElement toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add(WebViewRumEventMapper.DD_KEY_NAME, this.dd.toJson());
        jsonObject.addProperty("type", this.type);
        jsonObject.addProperty("date", Long.valueOf(this.date));
        jsonObject.addProperty("service", this.service);
        jsonObject.add("source", this.source.toJson());
        jsonObject.addProperty("version", this.version);
        Application application = this.application;
        if (application != null) {
            jsonObject.add("application", application.toJson());
        }
        Session session = this.session;
        if (session != null) {
            jsonObject.add("session", session.toJson());
        }
        View view = this.view;
        if (view != null) {
            jsonObject.add("view", view.toJson());
        }
        Action action = this.action;
        if (action != null) {
            jsonObject.add("action", action.toJson());
        }
        Number number = this.effectiveSampleRate;
        if (number != null) {
            jsonObject.addProperty("effective_sample_rate", number);
        }
        List<String> list = this.experimentalFeatures;
        if (list != null) {
            JsonArray jsonArray = new JsonArray(list.size());
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                jsonArray.add((String) it.next());
            }
            jsonObject.add("experimental_features", jsonArray);
        }
        jsonObject.add("telemetry", this.telemetry.toJson());
        return jsonObject;
    }

    /* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TelemetryConfigurationEvent fromJson(String jsonString) throws JsonParseException {
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            try {
                JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                return fromJsonObject(jsonObject);
            } catch (IllegalStateException e) {
                throw new JsonParseException("Unable to parse json into type TelemetryConfigurationEvent", e);
            }
        }

        @JvmStatic
        public final TelemetryConfigurationEvent fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            ArrayList arrayList;
            JsonArray asJsonArray;
            JsonObject asJsonObject;
            JsonObject asJsonObject2;
            JsonObject asJsonObject3;
            JsonObject asJsonObject4;
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            try {
                JsonObject it = jsonObject.get(WebViewRumEventMapper.DD_KEY_NAME).getAsJsonObject();
                Dd.Companion companion = Dd.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                Dd ddFromJsonObject = companion.fromJsonObject(it);
                String asString = jsonObject.get("type").getAsString();
                long asLong = jsonObject.get("date").getAsLong();
                String service = jsonObject.get("service").getAsString();
                Source.Companion companion2 = Source.INSTANCE;
                String asString2 = jsonObject.get("source").getAsString();
                Intrinsics.checkNotNullExpressionValue(asString2, "jsonObject.get(\"source\").asString");
                Source sourceFromJson = companion2.fromJson(asString2);
                String version = jsonObject.get("version").getAsString();
                JsonElement jsonElement = jsonObject.get("application");
                Application applicationFromJsonObject = (jsonElement == null || (asJsonObject4 = jsonElement.getAsJsonObject()) == null) ? null : Application.INSTANCE.fromJsonObject(asJsonObject4);
                JsonElement jsonElement2 = jsonObject.get("session");
                Session sessionFromJsonObject = (jsonElement2 == null || (asJsonObject3 = jsonElement2.getAsJsonObject()) == null) ? null : Session.INSTANCE.fromJsonObject(asJsonObject3);
                JsonElement jsonElement3 = jsonObject.get("view");
                View viewFromJsonObject = (jsonElement3 == null || (asJsonObject2 = jsonElement3.getAsJsonObject()) == null) ? null : View.INSTANCE.fromJsonObject(asJsonObject2);
                JsonElement jsonElement4 = jsonObject.get("action");
                Action actionFromJsonObject = (jsonElement4 == null || (asJsonObject = jsonElement4.getAsJsonObject()) == null) ? null : Action.INSTANCE.fromJsonObject(asJsonObject);
                JsonElement jsonElement5 = jsonObject.get("effective_sample_rate");
                Number asNumber = jsonElement5 != null ? jsonElement5.getAsNumber() : null;
                JsonElement jsonElement6 = jsonObject.get("experimental_features");
                if (jsonElement6 == null || (asJsonArray = jsonElement6.getAsJsonArray()) == null) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList(asJsonArray.size());
                    for (Iterator<JsonElement> it2 = asJsonArray.iterator(); it2.hasNext(); it2 = it2) {
                        arrayList.add(it2.next().getAsString());
                    }
                }
                JsonObject it3 = jsonObject.get("telemetry").getAsJsonObject();
                Telemetry.Companion companion3 = Telemetry.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it3, "it");
                Telemetry telemetryFromJsonObject = companion3.fromJsonObject(it3);
                if (!Intrinsics.areEqual(asString, "telemetry")) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                Intrinsics.checkNotNullExpressionValue(service, "service");
                Intrinsics.checkNotNullExpressionValue(version, "version");
                return new TelemetryConfigurationEvent(ddFromJsonObject, asLong, service, sourceFromJson, version, applicationFromJsonObject, sessionFromJsonObject, viewFromJsonObject, actionFromJsonObject, asNumber, arrayList, telemetryFromJsonObject);
            } catch (IllegalStateException e) {
                throw new JsonParseException("Unable to parse json into type TelemetryConfigurationEvent", e);
            } catch (NullPointerException e2) {
                throw new JsonParseException("Unable to parse json into type TelemetryConfigurationEvent", e2);
            } catch (NumberFormatException e3) {
                throw new JsonParseException("Unable to parse json into type TelemetryConfigurationEvent", e3);
            }
        }
    }

    /* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Dd;", "", "()V", "formatVersion", "", "getFormatVersion", "()J", "toJson", "Lcom/google/gson/JsonElement;", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Dd {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long formatVersion = 2;

        @JvmStatic
        public static final Dd fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Dd fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        public final long getFormatVersion() {
            return this.formatVersion;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("format_version", Long.valueOf(this.formatVersion));
            return jsonObject;
        }

        /* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Dd$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Dd;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    if (jsonObject.get("format_version").getAsLong() != 2) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    return new Dd();
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

    /* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Application;", "", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Application {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String id;

        public static /* synthetic */ Application copy$default(Application application, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = application.id;
            }
            return application.copy(str);
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

        public final Application copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Application(id);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Application) && Intrinsics.areEqual(this.id, ((Application) other).id);
        }

        public int hashCode() {
            return this.id.hashCode();
        }

        public String toString() {
            return "Application(id=" + this.id + ")";
        }

        public Application(String id) {
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

        /* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Application$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Application;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
                    Intrinsics.checkNotNullExpressionValue(id, "id");
                    return new Application(id);
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

    /* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Session;", "", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Session {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String id;

        public static /* synthetic */ Session copy$default(Session session, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = session.id;
            }
            return session.copy(str);
        }

        @JvmStatic
        public static final Session fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Session fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        public final Session copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Session(id);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Session) && Intrinsics.areEqual(this.id, ((Session) other).id);
        }

        public int hashCode() {
            return this.id.hashCode();
        }

        public String toString() {
            return "Session(id=" + this.id + ")";
        }

        public Session(String id) {
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

        /* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Session$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Session;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Session fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Session", e);
                }
            }

            @JvmStatic
            public final Session fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String id = jsonObject.get("id").getAsString();
                    Intrinsics.checkNotNullExpressionValue(id, "id");
                    return new Session(id);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Session", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Session", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Session", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$View;", "", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class View {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String id;

        public static /* synthetic */ View copy$default(View view, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = view.id;
            }
            return view.copy(str);
        }

        @JvmStatic
        public static final View fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final View fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        public final View copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new View(id);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof View) && Intrinsics.areEqual(this.id, ((View) other).id);
        }

        public int hashCode() {
            return this.id.hashCode();
        }

        public String toString() {
            return "View(id=" + this.id + ")";
        }

        public View(String id) {
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

        /* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$View$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$View;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final View fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type View", e);
                }
            }

            @JvmStatic
            public final View fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String id = jsonObject.get("id").getAsString();
                    Intrinsics.checkNotNullExpressionValue(id, "id");
                    return new View(id);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type View", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type View", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type View", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Action;", "", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Action {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String id;

        public static /* synthetic */ Action copy$default(Action action, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = action.id;
            }
            return action.copy(str);
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
        public final String getId() {
            return this.id;
        }

        public final Action copy(String id) {
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

        public Action(String id) {
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

        /* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Action$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Action;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
                    String id = jsonObject.get("id").getAsString();
                    Intrinsics.checkNotNullExpressionValue(id, "id");
                    return new Action(id);
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

    /* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u0017\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tHÆ\u0003JC\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0006\u0010!\u001a\u00020\"J\t\u0010#\u001a\u00020\nHÖ\u0001R\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\nX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006%"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Telemetry;", "", "device", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Device;", "os", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Os;", "configuration", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Configuration;", "additionalProperties", "", "", "(Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Device;Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Os;Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Configuration;Ljava/util/Map;)V", "getAdditionalProperties", "()Ljava/util/Map;", "getConfiguration", "()Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Configuration;", "getDevice", "()Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Device;", "getOs", "()Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Os;", "type", "getType", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Telemetry {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final String[] RESERVED_PROPERTIES = {"device", "os", "type", "configuration"};
        private final Map<String, Object> additionalProperties;
        private final Configuration configuration;
        private final Device device;
        private final Os os;
        private final String type;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Telemetry copy$default(Telemetry telemetry, Device device, Os os, Configuration configuration, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                device = telemetry.device;
            }
            if ((i & 2) != 0) {
                os = telemetry.os;
            }
            if ((i & 4) != 0) {
                configuration = telemetry.configuration;
            }
            if ((i & 8) != 0) {
                map = telemetry.additionalProperties;
            }
            return telemetry.copy(device, os, configuration, map);
        }

        @JvmStatic
        public static final Telemetry fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Telemetry fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Device getDevice() {
            return this.device;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Os getOs() {
            return this.os;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Configuration getConfiguration() {
            return this.configuration;
        }

        public final Map<String, Object> component4() {
            return this.additionalProperties;
        }

        public final Telemetry copy(Device device, Os os, Configuration configuration, Map<String, Object> additionalProperties) {
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            return new Telemetry(device, os, configuration, additionalProperties);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Telemetry)) {
                return false;
            }
            Telemetry telemetry = (Telemetry) other;
            return Intrinsics.areEqual(this.device, telemetry.device) && Intrinsics.areEqual(this.os, telemetry.os) && Intrinsics.areEqual(this.configuration, telemetry.configuration) && Intrinsics.areEqual(this.additionalProperties, telemetry.additionalProperties);
        }

        public int hashCode() {
            Device device = this.device;
            int iHashCode = (device == null ? 0 : device.hashCode()) * 31;
            Os os = this.os;
            return ((((iHashCode + (os != null ? os.hashCode() : 0)) * 31) + this.configuration.hashCode()) * 31) + this.additionalProperties.hashCode();
        }

        public String toString() {
            return "Telemetry(device=" + this.device + ", os=" + this.os + ", configuration=" + this.configuration + ", additionalProperties=" + this.additionalProperties + ")";
        }

        public Telemetry(Device device, Os os, Configuration configuration, Map<String, Object> additionalProperties) {
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            this.device = device;
            this.os = os;
            this.configuration = configuration;
            this.additionalProperties = additionalProperties;
            this.type = "configuration";
        }

        public final Device getDevice() {
            return this.device;
        }

        public final Os getOs() {
            return this.os;
        }

        public final Configuration getConfiguration() {
            return this.configuration;
        }

        public /* synthetic */ Telemetry(Device device, Os os, Configuration configuration, LinkedHashMap linkedHashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : device, (i & 2) != 0 ? null : os, configuration, (i & 8) != 0 ? new LinkedHashMap() : linkedHashMap);
        }

        public final Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public final String getType() {
            return this.type;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            Device device = this.device;
            if (device != null) {
                jsonObject.add("device", device.toJson());
            }
            Os os = this.os;
            if (os != null) {
                jsonObject.add("os", os.toJson());
            }
            jsonObject.addProperty("type", this.type);
            jsonObject.add("configuration", this.configuration.toJson());
            for (Map.Entry<String, Object> entry : this.additionalProperties.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (!ArraysKt.contains(RESERVED_PROPERTIES, key)) {
                    jsonObject.add(key, JsonSerializer.INSTANCE.toJsonElement(value));
                }
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0007J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Telemetry$Companion;", "", "()V", "RESERVED_PROPERTIES", "", "", "getRESERVED_PROPERTIES$dd_sdk_android_rum_release", "()[Ljava/lang/String;", "[Ljava/lang/String;", "fromJson", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Telemetry;", "jsonString", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final String[] getRESERVED_PROPERTIES$dd_sdk_android_rum_release() {
                return Telemetry.RESERVED_PROPERTIES;
            }

            @JvmStatic
            public final Telemetry fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Telemetry", e);
                }
            }

            @JvmStatic
            public final Telemetry fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                JsonObject asJsonObject;
                JsonObject asJsonObject2;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get("device");
                    Os osFromJsonObject = null;
                    Device deviceFromJsonObject = (jsonElement == null || (asJsonObject2 = jsonElement.getAsJsonObject()) == null) ? null : Device.INSTANCE.fromJsonObject(asJsonObject2);
                    JsonElement jsonElement2 = jsonObject.get("os");
                    if (jsonElement2 != null && (asJsonObject = jsonElement2.getAsJsonObject()) != null) {
                        osFromJsonObject = Os.INSTANCE.fromJsonObject(asJsonObject);
                    }
                    String asString = jsonObject.get("type").getAsString();
                    JsonObject it = jsonObject.get("configuration").getAsJsonObject();
                    Configuration.Companion companion = Configuration.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    Configuration configurationFromJsonObject = companion.fromJsonObject(it);
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                        if (!ArraysKt.contains(getRESERVED_PROPERTIES$dd_sdk_android_rum_release(), entry.getKey())) {
                            String key = entry.getKey();
                            Intrinsics.checkNotNullExpressionValue(key, "entry.key");
                            linkedHashMap.put(key, entry.getValue());
                        }
                    }
                    if (!Intrinsics.areEqual(asString, "configuration")) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    return new Telemetry(deviceFromJsonObject, osFromJsonObject, configurationFromJsonObject, linkedHashMap);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Telemetry", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Telemetry", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Telemetry", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u000fJV\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0006\u0010!\u001a\u00020\"J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\t\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006%"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Device;", "", "architecture", "", "brand", "model", "logicalCpuCount", "", "totalRam", "isLowRam", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Boolean;)V", "getArchitecture", "()Ljava/lang/String;", "getBrand", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLogicalCpuCount", "()Ljava/lang/Number;", "getModel", "getTotalRam", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Boolean;)Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Device;", "equals", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Device {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String architecture;
        private final String brand;
        private final Boolean isLowRam;
        private final Number logicalCpuCount;
        private final String model;
        private final Number totalRam;

        public Device() {
            this(null, null, null, null, null, null, 63, null);
        }

        public static /* synthetic */ Device copy$default(Device device, String str, String str2, String str3, Number number, Number number2, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                str = device.architecture;
            }
            if ((i & 2) != 0) {
                str2 = device.brand;
            }
            if ((i & 4) != 0) {
                str3 = device.model;
            }
            if ((i & 8) != 0) {
                number = device.logicalCpuCount;
            }
            if ((i & 16) != 0) {
                number2 = device.totalRam;
            }
            if ((i & 32) != 0) {
                bool = device.isLowRam;
            }
            Number number3 = number2;
            Boolean bool2 = bool;
            return device.copy(str, str2, str3, number, number3, bool2);
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
        public final String getArchitecture() {
            return this.architecture;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getBrand() {
            return this.brand;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getModel() {
            return this.model;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Number getLogicalCpuCount() {
            return this.logicalCpuCount;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Number getTotalRam() {
            return this.totalRam;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Boolean getIsLowRam() {
            return this.isLowRam;
        }

        public final Device copy(String architecture, String brand, String model, Number logicalCpuCount, Number totalRam, Boolean isLowRam) {
            return new Device(architecture, brand, model, logicalCpuCount, totalRam, isLowRam);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Device)) {
                return false;
            }
            Device device = (Device) other;
            return Intrinsics.areEqual(this.architecture, device.architecture) && Intrinsics.areEqual(this.brand, device.brand) && Intrinsics.areEqual(this.model, device.model) && Intrinsics.areEqual(this.logicalCpuCount, device.logicalCpuCount) && Intrinsics.areEqual(this.totalRam, device.totalRam) && Intrinsics.areEqual(this.isLowRam, device.isLowRam);
        }

        public int hashCode() {
            String str = this.architecture;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.brand;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.model;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Number number = this.logicalCpuCount;
            int iHashCode4 = (iHashCode3 + (number == null ? 0 : number.hashCode())) * 31;
            Number number2 = this.totalRam;
            int iHashCode5 = (iHashCode4 + (number2 == null ? 0 : number2.hashCode())) * 31;
            Boolean bool = this.isLowRam;
            return iHashCode5 + (bool != null ? bool.hashCode() : 0);
        }

        public String toString() {
            return "Device(architecture=" + this.architecture + ", brand=" + this.brand + ", model=" + this.model + ", logicalCpuCount=" + this.logicalCpuCount + ", totalRam=" + this.totalRam + ", isLowRam=" + this.isLowRam + ")";
        }

        public Device(String str, String str2, String str3, Number number, Number number2, Boolean bool) {
            this.architecture = str;
            this.brand = str2;
            this.model = str3;
            this.logicalCpuCount = number;
            this.totalRam = number2;
            this.isLowRam = bool;
        }

        public /* synthetic */ Device(String str, String str2, String str3, Number number, Number number2, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : number, (i & 16) != 0 ? null : number2, (i & 32) != 0 ? null : bool);
        }

        public final String getArchitecture() {
            return this.architecture;
        }

        public final String getBrand() {
            return this.brand;
        }

        public final String getModel() {
            return this.model;
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
            String str = this.architecture;
            if (str != null) {
                jsonObject.addProperty("architecture", str);
            }
            String str2 = this.brand;
            if (str2 != null) {
                jsonObject.addProperty("brand", str2);
            }
            String str3 = this.model;
            if (str3 != null) {
                jsonObject.addProperty("model", str3);
            }
            Number number = this.logicalCpuCount;
            if (number != null) {
                jsonObject.addProperty("logical_cpu_count", number);
            }
            Number number2 = this.totalRam;
            if (number2 != null) {
                jsonObject.addProperty("total_ram", number2);
            }
            Boolean bool = this.isLowRam;
            if (bool != null) {
                bool.booleanValue();
                jsonObject.addProperty("is_low_ram", bool);
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Device$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Device;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get("architecture");
                    String asString = jsonElement != null ? jsonElement.getAsString() : null;
                    JsonElement jsonElement2 = jsonObject.get("brand");
                    String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
                    JsonElement jsonElement3 = jsonObject.get("model");
                    String asString3 = jsonElement3 != null ? jsonElement3.getAsString() : null;
                    JsonElement jsonElement4 = jsonObject.get("logical_cpu_count");
                    Number asNumber = jsonElement4 != null ? jsonElement4.getAsNumber() : null;
                    JsonElement jsonElement5 = jsonObject.get("total_ram");
                    Number asNumber2 = jsonElement5 != null ? jsonElement5.getAsNumber() : null;
                    JsonElement jsonElement6 = jsonObject.get("is_low_ram");
                    return new Device(asString, asString2, asString3, asNumber, asNumber2, jsonElement6 != null ? Boolean.valueOf(jsonElement6.getAsBoolean()) : null);
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

    /* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Os;", "", "build", "", "name", "version", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBuild", "()Ljava/lang/String;", "getName", "getVersion", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Os {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String build;
        private final String name;
        private final String version;

        public Os() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ Os copy$default(Os os, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = os.build;
            }
            if ((i & 2) != 0) {
                str2 = os.name;
            }
            if ((i & 4) != 0) {
                str3 = os.version;
            }
            return os.copy(str, str2, str3);
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
        public final String getBuild() {
            return this.build;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getVersion() {
            return this.version;
        }

        public final Os copy(String build, String name, String version) {
            return new Os(build, name, version);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Os)) {
                return false;
            }
            Os os = (Os) other;
            return Intrinsics.areEqual(this.build, os.build) && Intrinsics.areEqual(this.name, os.name) && Intrinsics.areEqual(this.version, os.version);
        }

        public int hashCode() {
            String str = this.build;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.name;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.version;
            return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "Os(build=" + this.build + ", name=" + this.name + ", version=" + this.version + ")";
        }

        public Os(String str, String str2, String str3) {
            this.build = str;
            this.name = str2;
            this.version = str3;
        }

        public /* synthetic */ Os(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }

        public final String getBuild() {
            return this.build;
        }

        public final String getName() {
            return this.name;
        }

        public final String getVersion() {
            return this.version;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            String str = this.build;
            if (str != null) {
                jsonObject.addProperty("build", str);
            }
            String str2 = this.name;
            if (str2 != null) {
                jsonObject.addProperty("name", str2);
            }
            String str3 = this.version;
            if (str3 != null) {
                jsonObject.addProperty("version", str3);
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Os$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Os;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
                    JsonElement jsonElement = jsonObject.get("build");
                    String asString = jsonElement != null ? jsonElement.getAsString() : null;
                    JsonElement jsonElement2 = jsonObject.get("name");
                    String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
                    JsonElement jsonElement3 = jsonObject.get("version");
                    return new Os(asString, asString2, jsonElement3 != null ? jsonElement3.getAsString() : null);
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

    /* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
    @Metadata(d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0003\b\u008b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 ý\u00022\u00020\u0001:\u0002ý\u0002B£\t\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010:\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010*\u0012\u0010\b\u0002\u0010;\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010*\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010>\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010X\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010[\u001a\n\u0012\u0004\u0012\u00020\\\u0018\u00010*\u0012\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010`\u001a\n\u0012\u0004\u0012\u00020a\u0018\u00010*\u0012\n\b\u0002\u0010b\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010c\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010d\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010e\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010f\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010g\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010h\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010i\u001a\u0004\u0018\u00010j\u0012\n\b\u0002\u0010k\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010l\u001a\u0004\u0018\u00010m\u0012\n\b\u0002\u0010n\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010oJ\u0011\u0010\u0094\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010wJ\f\u0010\u0095\u0002\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0011\u0010\u0096\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010\u0097\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010\u0098\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010\u0099\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010\u009a\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010\u009b\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010\u009c\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010\u009d\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010\u009e\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010\u009f\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010 \u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010¡\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010¢\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010£\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010¤\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\f\u0010¥\u0002\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\u0011\u0010¦\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010§\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\f\u0010¨\u0002\u001a\u0004\u0018\u00010#HÆ\u0003J\u0011\u0010©\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010ª\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010«\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010¬\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010\u00ad\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010®\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0012\u0010¯\u0002\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*HÆ\u0003J\f\u0010°\u0002\u001a\u0004\u0018\u00010#HÆ\u0003J\f\u0010±\u0002\u001a\u0004\u0018\u00010#HÆ\u0003J\f\u0010²\u0002\u001a\u0004\u0018\u00010#HÆ\u0003J\f\u0010³\u0002\u001a\u0004\u0018\u00010#HÆ\u0003J\u0011\u0010´\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010µ\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010¶\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010·\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010¸\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010¹\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010º\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010»\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010¼\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010½\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010¾\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010wJ\u0012\u0010¿\u0002\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010*HÆ\u0003J\u0011\u0010À\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010wJ\u0012\u0010Á\u0002\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010*HÆ\u0003J\u0011\u0010Â\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\f\u0010Ã\u0002\u001a\u0004\u0018\u00010>HÆ\u0003J\u0011\u0010Ä\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010Å\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010Æ\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010Ç\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010È\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010É\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010Ê\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\f\u0010Ë\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010Ì\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010Í\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010Î\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010Ï\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010Ð\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\f\u0010Ñ\u0002\u001a\u0004\u0018\u00010#HÆ\u0003J\u0011\u0010Ò\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010Ó\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010Ô\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010Õ\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010Ö\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010×\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\f\u0010Ø\u0002\u001a\u0004\u0018\u00010#HÆ\u0003J\f\u0010Ù\u0002\u001a\u0004\u0018\u00010#HÆ\u0003J\f\u0010Ú\u0002\u001a\u0004\u0018\u00010#HÆ\u0003J\f\u0010Û\u0002\u001a\u0004\u0018\u00010#HÆ\u0003J\f\u0010Ü\u0002\u001a\u0004\u0018\u00010#HÆ\u0003J\u0011\u0010Ý\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010Þ\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\f\u0010ß\u0002\u001a\u0004\u0018\u00010#HÆ\u0003J\f\u0010à\u0002\u001a\u0004\u0018\u00010#HÆ\u0003J\u0011\u0010á\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010â\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0012\u0010ã\u0002\u001a\n\u0012\u0004\u0012\u00020\\\u0018\u00010*HÆ\u0003J\u0011\u0010ä\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010å\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010æ\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010wJ\u0012\u0010ç\u0002\u001a\n\u0012\u0004\u0012\u00020a\u0018\u00010*HÆ\u0003J\u0011\u0010è\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010é\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\f\u0010ê\u0002\u001a\u0004\u0018\u00010#HÆ\u0003J\f\u0010ë\u0002\u001a\u0004\u0018\u00010#HÆ\u0003J\u0011\u0010ì\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010wJ\f\u0010í\u0002\u001a\u0004\u0018\u00010#HÆ\u0003J\f\u0010î\u0002\u001a\u0004\u0018\u00010#HÆ\u0003J\u0011\u0010ï\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\f\u0010ð\u0002\u001a\u0004\u0018\u00010jHÆ\u0003J\u0011\u0010ñ\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ\f\u0010ò\u0002\u001a\u0004\u0018\u00010mHÆ\u0003J\u0011\u0010ó\u0002\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010sJ®\t\u0010ô\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00102\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010#2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010:\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010*2\u0010\b\u0002\u0010;\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010*2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010=\u001a\u0004\u0018\u00010>2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010K\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010R\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010T\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010X\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u00102\u0010\b\u0002\u0010[\u001a\n\u0012\u0004\u0012\u00020\\\u0018\u00010*2\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010`\u001a\n\u0012\u0004\u0012\u00020a\u0018\u00010*2\n\b\u0002\u0010b\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010c\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010d\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010e\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010f\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010g\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010h\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010i\u001a\u0004\u0018\u00010j2\n\b\u0002\u0010k\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010l\u001a\u0004\u0018\u00010m2\n\b\u0002\u0010n\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0003\u0010õ\u0002J\u0015\u0010ö\u0002\u001a\u00020\u00102\t\u0010÷\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000b\u0010ø\u0002\u001a\u00030ù\u0002HÖ\u0001J\b\u0010ú\u0002\u001a\u00030û\u0002J\n\u0010ü\u0002\u001a\u00020#HÖ\u0001R\u0013\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\b\n\u0000\u001a\u0004\bp\u0010qR\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010t\u001a\u0004\br\u0010sR\u0015\u0010!\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010t\u001a\u0004\bu\u0010sR\u0015\u0010V\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010x\u001a\u0004\bv\u0010wR\u0015\u0010P\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010t\u001a\u0004\by\u0010sR\u0015\u0010O\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010x\u001a\u0004\bz\u0010wR\u0015\u0010M\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010x\u001a\u0004\b{\u0010wR\u0015\u0010N\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010x\u001a\u0004\b|\u0010wR\u001e\u0010n\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010t\u001a\u0004\b}\u0010s\"\u0004\b~\u0010\u007fR\u0016\u00103\u001a\u0004\u0018\u00010\u0010¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\b\u0080\u0001\u0010sR\u001f\u0010S\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0081\u0001\u0010q\"\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001f\u0010,\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0084\u0001\u0010q\"\u0006\b\u0085\u0001\u0010\u0083\u0001R \u00100\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0002\u0010t\u001a\u0005\b\u0086\u0001\u0010s\"\u0005\b\u0087\u0001\u0010\u007fR\u001b\u0010:\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010*¢\u0006\n\n\u0000\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0016\u00108\u001a\u0004\u0018\u00010\u0010¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\b\u008a\u0001\u0010sR\u001b\u0010;\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010*¢\u0006\n\n\u0000\u001a\u0006\b\u008b\u0001\u0010\u0089\u0001R\u001f\u0010.\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u008c\u0001\u0010q\"\u0006\b\u008d\u0001\u0010\u0083\u0001R\u001f\u0010K\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u008e\u0001\u0010q\"\u0006\b\u008f\u0001\u0010\u0083\u0001R\u0016\u0010^\u001a\u0004\u0018\u00010\u0003¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b\u0090\u0001\u0010wR\u0015\u0010]\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010t\u001a\u0004\b]\u0010sR\u001f\u0010U\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0091\u0001\u0010q\"\u0006\b\u0092\u0001\u0010\u0083\u0001R!\u0010B\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0013\n\u0002\u0010x\u001a\u0005\b\u0093\u0001\u0010w\"\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0016\u00109\u001a\u0004\u0018\u00010\u0003¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b\u0096\u0001\u0010wR\u001b\u0010[\u001a\n\u0012\u0004\u0012\u00020\\\u0018\u00010*¢\u0006\n\n\u0000\u001a\u0006\b\u0097\u0001\u0010\u0089\u0001R\u0016\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b\u0098\u0001\u0010wR \u0010i\u001a\u0004\u0018\u00010jX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001\"\u0006\b\u009b\u0001\u0010\u009c\u0001R \u0010k\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0002\u0010t\u001a\u0005\b\u009d\u0001\u0010s\"\u0005\b\u009e\u0001\u0010\u007fR\u001f\u0010R\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u009f\u0001\u0010q\"\u0006\b \u0001\u0010\u0083\u0001R\u001f\u0010Q\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b¡\u0001\u0010q\"\u0006\b¢\u0001\u0010\u0083\u0001R\u001f\u0010g\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b£\u0001\u0010q\"\u0006\b¤\u0001\u0010\u0083\u0001R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b¥\u0001\u0010wR\u001f\u0010d\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b¦\u0001\u0010q\"\u0006\b§\u0001\u0010\u0083\u0001R\u001b\u0010)\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*¢\u0006\n\n\u0000\u001a\u0006\b¨\u0001\u0010\u0089\u0001R \u0010Z\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0002\u0010t\u001a\u0005\b©\u0001\u0010s\"\u0005\bª\u0001\u0010\u007fR\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\n\n\u0000\u001a\u0006\b«\u0001\u0010¬\u0001R!\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0013\n\u0002\u0010x\u001a\u0005\b\u00ad\u0001\u0010w\"\u0006\b®\u0001\u0010\u0095\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b¯\u0001\u0010wR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0010¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\b°\u0001\u0010sR\u001f\u0010e\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b±\u0001\u0010q\"\u0006\b²\u0001\u0010\u0083\u0001R \u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0002\u0010t\u001a\u0005\b³\u0001\u0010s\"\u0005\b´\u0001\u0010\u007fR \u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0002\u0010t\u001a\u0005\bµ\u0001\u0010s\"\u0005\b¶\u0001\u0010\u007fR\u0016\u0010 \u001a\u0004\u0018\u00010\u0010¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\b·\u0001\u0010sR \u0010@\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0002\u0010t\u001a\u0005\b¸\u0001\u0010s\"\u0005\b¹\u0001\u0010\u007fR \u0010?\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0002\u0010t\u001a\u0005\bº\u0001\u0010s\"\u0005\b»\u0001\u0010\u007fR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b¼\u0001\u0010wR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b½\u0001\u0010wR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b¾\u0001\u0010wR\u001f\u0010-\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b¿\u0001\u0010q\"\u0006\bÀ\u0001\u0010\u0083\u0001R\u0016\u0010_\u001a\u0004\u0018\u00010\u0003¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\bÁ\u0001\u0010wR\u001f\u0010/\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\bÂ\u0001\u0010q\"\u0006\bÃ\u0001\u0010\u0083\u0001R \u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÄ\u0001\u0010Å\u0001\"\u0006\bÆ\u0001\u0010Ç\u0001R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\bÈ\u0001\u0010wR\u001f\u0010X\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\bÉ\u0001\u0010q\"\u0006\bÊ\u0001\u0010\u0083\u0001R\u001f\u0010Y\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\bË\u0001\u0010q\"\u0006\bÌ\u0001\u0010\u0083\u0001R \u0010b\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0002\u0010t\u001a\u0005\bÍ\u0001\u0010s\"\u0005\bÎ\u0001\u0010\u007fR \u0010A\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0002\u0010t\u001a\u0005\bÏ\u0001\u0010s\"\u0005\bÐ\u0001\u0010\u007fR \u0010\u0019\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0002\u0010t\u001a\u0005\bÑ\u0001\u0010s\"\u0005\bÒ\u0001\u0010\u007fR \u0010I\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0002\u0010t\u001a\u0005\bÓ\u0001\u0010s\"\u0005\bÔ\u0001\u0010\u007fR \u0010\u0017\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0002\u0010t\u001a\u0005\bÕ\u0001\u0010s\"\u0005\bÖ\u0001\u0010\u007fR \u0010C\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0002\u0010t\u001a\u0005\b×\u0001\u0010s\"\u0005\bØ\u0001\u0010\u007fR\u001b\u0010`\u001a\n\u0012\u0004\u0012\u00020a\u0018\u00010*¢\u0006\n\n\u0000\u001a\u0006\bÙ\u0001\u0010\u0089\u0001R \u0010L\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0002\u0010t\u001a\u0005\bÚ\u0001\u0010s\"\u0005\bÛ\u0001\u0010\u007fR \u00104\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0002\u0010t\u001a\u0005\bÜ\u0001\u0010s\"\u0005\bÝ\u0001\u0010\u007fR \u00106\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0002\u0010t\u001a\u0005\bÞ\u0001\u0010s\"\u0005\bß\u0001\u0010\u007fR \u0010\u0018\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0002\u0010t\u001a\u0005\bà\u0001\u0010s\"\u0005\bá\u0001\u0010\u007fR \u0010G\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0002\u0010t\u001a\u0005\bâ\u0001\u0010s\"\u0005\bã\u0001\u0010\u007fR \u0010H\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0002\u0010t\u001a\u0005\bä\u0001\u0010s\"\u0005\bå\u0001\u0010\u007fR \u0010F\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0002\u0010t\u001a\u0005\bæ\u0001\u0010s\"\u0005\bç\u0001\u0010\u007fR \u0010D\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0002\u0010t\u001a\u0005\bè\u0001\u0010s\"\u0005\bé\u0001\u0010\u007fR \u0010l\u001a\u0004\u0018\u00010mX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bê\u0001\u0010ë\u0001\"\u0006\bì\u0001\u0010í\u0001R \u0010\u0016\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0002\u0010t\u001a\u0005\bî\u0001\u0010s\"\u0005\bï\u0001\u0010\u007fR\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u0010¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\bð\u0001\u0010sR \u00107\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0002\u0010t\u001a\u0005\bñ\u0001\u0010s\"\u0005\bò\u0001\u0010\u007fR \u00105\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0002\u0010t\u001a\u0005\bó\u0001\u0010s\"\u0005\bô\u0001\u0010\u007fR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0000\u001a\u0006\bõ\u0001\u0010ö\u0001R\u001f\u0010T\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b÷\u0001\u0010q\"\u0006\bø\u0001\u0010\u0083\u0001R\u0016\u0010&\u001a\u0004\u0018\u00010\u0010¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\bù\u0001\u0010sR\u0016\u0010$\u001a\u0004\u0018\u00010\u0010¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\bú\u0001\u0010sR\u0016\u0010%\u001a\u0004\u0018\u00010\u0010¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\bû\u0001\u0010sR \u0010c\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0002\u0010t\u001a\u0005\bü\u0001\u0010s\"\u0005\bý\u0001\u0010\u007fR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u0010¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\bþ\u0001\u0010sR\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u0010¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\bÿ\u0001\u0010sR\u0016\u00101\u001a\u0004\u0018\u00010\u0010¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\b\u0080\u0002\u0010sR \u0010J\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0002\u0010t\u001a\u0005\b\u0081\u0002\u0010s\"\u0005\b\u0082\u0002\u0010\u007fR\u0016\u0010<\u001a\u0004\u0018\u00010\u0010¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\b\u0083\u0002\u0010sR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u0010¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\b\u0084\u0002\u0010sR \u0010W\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0002\u0010t\u001a\u0005\b\u0085\u0002\u0010s\"\u0005\b\u0086\u0002\u0010\u007fR \u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0002\u0010t\u001a\u0005\b\u0087\u0002\u0010s\"\u0005\b\u0088\u0002\u0010\u007fR \u0010h\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0002\u0010t\u001a\u0005\b\u0089\u0002\u0010s\"\u0005\b\u008a\u0002\u0010\u007fR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u0010¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\b\u008b\u0002\u0010sR\u0016\u0010E\u001a\u0004\u0018\u00010\u0010¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\b\u008c\u0002\u0010sR\u0016\u0010'\u001a\u0004\u0018\u00010\u0010¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\b\u008d\u0002\u0010sR\u0016\u0010(\u001a\u0004\u0018\u00010\u0010¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\b\u008e\u0002\u0010sR\u0016\u00102\u001a\u0004\u0018\u00010\u0010¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\b\u008f\u0002\u0010sR\u001f\u0010f\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0090\u0002\u0010q\"\u0006\b\u0091\u0002\u0010\u0083\u0001R\u0015\u0010=\u001a\u0004\u0018\u00010>¢\u0006\n\n\u0000\u001a\u0006\b\u0092\u0002\u0010\u0093\u0002¨\u0006þ\u0002"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Configuration;", "", RumSessionScope.RUM_SESSION_SAMPLE_RATE_BUS_MESSAGE_KEY, "", "telemetrySampleRate", "telemetryConfigurationSampleRate", "telemetryUsageSampleRate", "traceSampleRate", "traceContextInjection", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$TraceContextInjection;", "premiumSampleRate", "replaySampleRate", "sessionReplaySampleRate", "trackingConsent", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$TrackingConsent;", "startSessionReplayRecordingManually", "", "startRecordingImmediately", "useProxy", "useBeforeSend", "silentMultipleInit", "trackSessionAcrossSubdomains", "trackResources", "trackEarlyRequests", "trackLongTask", "trackBfcacheViews", "useCrossSiteSessionCookie", "usePartitionedCrossSiteSessionCookie", "useSecureSessionCookie", "allowFallbackToLocalStorage", "sessionPersistence", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$SessionPersistence;", "storeContextsAcrossPages", "allowUntrustedEvents", "actionNameAttribute", "", "useAllowedTracingOrigins", "useAllowedTracingUrls", "useAllowedGraphQlUrls", "useTrackGraphQlPayload", "useTrackGraphQlResponseErrors", "selectedTracingPropagators", "", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$SelectedTracingPropagator;", "defaultPrivacyLevel", "textAndInputPrivacyLevel", "imagePrivacyLevel", "touchPrivacyLevel", "enablePrivacyForActionName", "useExcludedActivityUrls", "useWorkerUrl", "compressIntakeRequests", "trackFrustrations", "trackViewsManually", "trackInteractions", "trackUserInteractions", "forwardErrorsToLogs", "numberOfDisplays", "forwardConsoleLogs", "forwardReports", "useLocalEncryption", "viewTrackingStrategy", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$ViewTrackingStrategy;", "swiftuiViewTrackingEnabled", "swiftuiActionTrackingEnabled", "trackBackgroundEvents", "mobileVitalsUpdatePeriod", "trackErrors", "trackNetworkRequests", "useTracing", "trackNativeViews", "trackNativeErrors", "trackNativeLongTasks", "trackCrossPlatformLongTasks", "useFirstPartyHosts", "initializationType", "trackFlutterPerformance", "batchSize", "batchUploadFrequency", "batchProcessingLevel", "backgroundTasksEnabled", "reactVersion", "reactNativeVersion", "dartVersion", "unityVersion", "mauiVersion", "appHangThreshold", "usePciIntake", "tracerApi", "tracerApiVersion", "sendLogsAfterSessionExpiration", "plugins", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Plugin;", "isMainProcess", "invTimeThresholdMs", "tnsTimeThresholdMs", "trackFeatureFlagsForEvents", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$TrackFeatureFlagsForEvent;", "trackAnonymousUser", "useAllowedTrackingOrigins", "sdkVersion", "source", "variant", "remoteConfigurationId", "useRemoteConfigurationProxy", "profilingSampleRate", "", "propagateTraceBaggage", "trackResourceHeaders", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$TrackResourceHeaders;", "betaEncodeCookieOptions", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$TraceContextInjection;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$TrackingConsent;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$SessionPersistence;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$ViewTrackingStrategy;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Number;Ljava/lang/Boolean;Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$TrackResourceHeaders;Ljava/lang/Boolean;)V", "getActionNameAttribute", "()Ljava/lang/String;", "getAllowFallbackToLocalStorage", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAllowUntrustedEvents", "getAppHangThreshold", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getBackgroundTasksEnabled", "getBatchProcessingLevel", "getBatchSize", "getBatchUploadFrequency", "getBetaEncodeCookieOptions", "setBetaEncodeCookieOptions", "(Ljava/lang/Boolean;)V", "getCompressIntakeRequests", "getDartVersion", "setDartVersion", "(Ljava/lang/String;)V", "getDefaultPrivacyLevel", "setDefaultPrivacyLevel", "getEnablePrivacyForActionName", "setEnablePrivacyForActionName", "getForwardConsoleLogs", "()Ljava/util/List;", "getForwardErrorsToLogs", "getForwardReports", "getImagePrivacyLevel", "setImagePrivacyLevel", "getInitializationType", "setInitializationType", "getInvTimeThresholdMs", "getMauiVersion", "setMauiVersion", "getMobileVitalsUpdatePeriod", "setMobileVitalsUpdatePeriod", "(Ljava/lang/Long;)V", "getNumberOfDisplays", "getPlugins", "getPremiumSampleRate", "getProfilingSampleRate", "()Ljava/lang/Number;", "setProfilingSampleRate", "(Ljava/lang/Number;)V", "getPropagateTraceBaggage", "setPropagateTraceBaggage", "getReactNativeVersion", "setReactNativeVersion", "getReactVersion", "setReactVersion", "getRemoteConfigurationId", "setRemoteConfigurationId", "getReplaySampleRate", "getSdkVersion", "setSdkVersion", "getSelectedTracingPropagators", "getSendLogsAfterSessionExpiration", "setSendLogsAfterSessionExpiration", "getSessionPersistence", "()Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$SessionPersistence;", "getSessionReplaySampleRate", "setSessionReplaySampleRate", "getSessionSampleRate", "getSilentMultipleInit", "getSource", "setSource", "getStartRecordingImmediately", "setStartRecordingImmediately", "getStartSessionReplayRecordingManually", "setStartSessionReplayRecordingManually", "getStoreContextsAcrossPages", "getSwiftuiActionTrackingEnabled", "setSwiftuiActionTrackingEnabled", "getSwiftuiViewTrackingEnabled", "setSwiftuiViewTrackingEnabled", "getTelemetryConfigurationSampleRate", "getTelemetrySampleRate", "getTelemetryUsageSampleRate", "getTextAndInputPrivacyLevel", "setTextAndInputPrivacyLevel", "getTnsTimeThresholdMs", "getTouchPrivacyLevel", "setTouchPrivacyLevel", "getTraceContextInjection", "()Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$TraceContextInjection;", "setTraceContextInjection", "(Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$TraceContextInjection;)V", "getTraceSampleRate", "getTracerApi", "setTracerApi", "getTracerApiVersion", "setTracerApiVersion", "getTrackAnonymousUser", "setTrackAnonymousUser", "getTrackBackgroundEvents", "setTrackBackgroundEvents", "getTrackBfcacheViews", "setTrackBfcacheViews", "getTrackCrossPlatformLongTasks", "setTrackCrossPlatformLongTasks", "getTrackEarlyRequests", "setTrackEarlyRequests", "getTrackErrors", "setTrackErrors", "getTrackFeatureFlagsForEvents", "getTrackFlutterPerformance", "setTrackFlutterPerformance", "getTrackFrustrations", "setTrackFrustrations", "getTrackInteractions", "setTrackInteractions", "getTrackLongTask", "setTrackLongTask", "getTrackNativeErrors", "setTrackNativeErrors", "getTrackNativeLongTasks", "setTrackNativeLongTasks", "getTrackNativeViews", "setTrackNativeViews", "getTrackNetworkRequests", "setTrackNetworkRequests", "getTrackResourceHeaders", "()Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$TrackResourceHeaders;", "setTrackResourceHeaders", "(Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$TrackResourceHeaders;)V", "getTrackResources", "setTrackResources", "getTrackSessionAcrossSubdomains", "getTrackUserInteractions", "setTrackUserInteractions", "getTrackViewsManually", "setTrackViewsManually", "getTrackingConsent", "()Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$TrackingConsent;", "getUnityVersion", "setUnityVersion", "getUseAllowedGraphQlUrls", "getUseAllowedTracingOrigins", "getUseAllowedTracingUrls", "getUseAllowedTrackingOrigins", "setUseAllowedTrackingOrigins", "getUseBeforeSend", "getUseCrossSiteSessionCookie", "getUseExcludedActivityUrls", "getUseFirstPartyHosts", "setUseFirstPartyHosts", "getUseLocalEncryption", "getUsePartitionedCrossSiteSessionCookie", "getUsePciIntake", "setUsePciIntake", "getUseProxy", "setUseProxy", "getUseRemoteConfigurationProxy", "setUseRemoteConfigurationProxy", "getUseSecureSessionCookie", "getUseTracing", "getUseTrackGraphQlPayload", "getUseTrackGraphQlResponseErrors", "getUseWorkerUrl", "getVariant", "setVariant", "getViewTrackingStrategy", "()Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$ViewTrackingStrategy;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component6", "component60", "component61", "component62", "component63", "component64", "component65", "component66", "component67", "component68", "component69", "component7", "component70", "component71", "component72", "component73", "component74", "component75", "component76", "component77", "component78", "component79", "component8", "component80", "component81", "component82", "component83", "component84", "component85", "component86", "component87", "component88", "component89", "component9", "component90", "component91", "component92", "component93", "component94", "component95", "component96", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$TraceContextInjection;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$TrackingConsent;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$SessionPersistence;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$ViewTrackingStrategy;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Number;Ljava/lang/Boolean;Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$TrackResourceHeaders;Ljava/lang/Boolean;)Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Configuration;", "equals", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Configuration {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String actionNameAttribute;
        private final Boolean allowFallbackToLocalStorage;
        private final Boolean allowUntrustedEvents;
        private final Long appHangThreshold;
        private final Boolean backgroundTasksEnabled;
        private final Long batchProcessingLevel;
        private final Long batchSize;
        private final Long batchUploadFrequency;
        private Boolean betaEncodeCookieOptions;
        private final Boolean compressIntakeRequests;
        private String dartVersion;
        private String defaultPrivacyLevel;
        private Boolean enablePrivacyForActionName;
        private final List<String> forwardConsoleLogs;
        private final Boolean forwardErrorsToLogs;
        private final List<String> forwardReports;
        private String imagePrivacyLevel;
        private String initializationType;
        private final Long invTimeThresholdMs;
        private final Boolean isMainProcess;
        private String mauiVersion;
        private Long mobileVitalsUpdatePeriod;
        private final Long numberOfDisplays;
        private final List<Plugin> plugins;
        private final Long premiumSampleRate;
        private Number profilingSampleRate;
        private Boolean propagateTraceBaggage;
        private String reactNativeVersion;
        private String reactVersion;
        private String remoteConfigurationId;
        private final Long replaySampleRate;
        private String sdkVersion;
        private final List<SelectedTracingPropagator> selectedTracingPropagators;
        private Boolean sendLogsAfterSessionExpiration;
        private final SessionPersistence sessionPersistence;
        private Long sessionReplaySampleRate;
        private final Long sessionSampleRate;
        private final Boolean silentMultipleInit;
        private String source;
        private Boolean startRecordingImmediately;
        private Boolean startSessionReplayRecordingManually;
        private final Boolean storeContextsAcrossPages;
        private Boolean swiftuiActionTrackingEnabled;
        private Boolean swiftuiViewTrackingEnabled;
        private final Long telemetryConfigurationSampleRate;
        private final Long telemetrySampleRate;
        private final Long telemetryUsageSampleRate;
        private String textAndInputPrivacyLevel;
        private final Long tnsTimeThresholdMs;
        private String touchPrivacyLevel;
        private TraceContextInjection traceContextInjection;
        private final Long traceSampleRate;
        private String tracerApi;
        private String tracerApiVersion;
        private Boolean trackAnonymousUser;
        private Boolean trackBackgroundEvents;
        private Boolean trackBfcacheViews;
        private Boolean trackCrossPlatformLongTasks;
        private Boolean trackEarlyRequests;
        private Boolean trackErrors;
        private final List<TrackFeatureFlagsForEvent> trackFeatureFlagsForEvents;
        private Boolean trackFlutterPerformance;
        private Boolean trackFrustrations;
        private Boolean trackInteractions;
        private Boolean trackLongTask;
        private Boolean trackNativeErrors;
        private Boolean trackNativeLongTasks;
        private Boolean trackNativeViews;
        private Boolean trackNetworkRequests;
        private TrackResourceHeaders trackResourceHeaders;
        private Boolean trackResources;
        private final Boolean trackSessionAcrossSubdomains;
        private Boolean trackUserInteractions;
        private Boolean trackViewsManually;
        private final TrackingConsent trackingConsent;
        private String unityVersion;
        private final Boolean useAllowedGraphQlUrls;
        private final Boolean useAllowedTracingOrigins;
        private final Boolean useAllowedTracingUrls;
        private Boolean useAllowedTrackingOrigins;
        private final Boolean useBeforeSend;
        private final Boolean useCrossSiteSessionCookie;
        private final Boolean useExcludedActivityUrls;
        private Boolean useFirstPartyHosts;
        private final Boolean useLocalEncryption;
        private final Boolean usePartitionedCrossSiteSessionCookie;
        private Boolean usePciIntake;
        private Boolean useProxy;
        private Boolean useRemoteConfigurationProxy;
        private final Boolean useSecureSessionCookie;
        private final Boolean useTracing;
        private final Boolean useTrackGraphQlPayload;
        private final Boolean useTrackGraphQlResponseErrors;
        private final Boolean useWorkerUrl;
        private String variant;
        private final ViewTrackingStrategy viewTrackingStrategy;

        public Configuration() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, -1, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Configuration copy$default(Configuration configuration, Long l, Long l2, Long l3, Long l4, Long l5, TraceContextInjection traceContextInjection, Long l6, Long l7, Long l8, TrackingConsent trackingConsent, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, Boolean bool12, Boolean bool13, Boolean bool14, SessionPersistence sessionPersistence, Boolean bool15, Boolean bool16, String str, Boolean bool17, Boolean bool18, Boolean bool19, Boolean bool20, Boolean bool21, List list, String str2, String str3, String str4, String str5, Boolean bool22, Boolean bool23, Boolean bool24, Boolean bool25, Boolean bool26, Boolean bool27, Boolean bool28, Boolean bool29, Boolean bool30, Long l9, List list2, List list3, Boolean bool31, ViewTrackingStrategy viewTrackingStrategy, Boolean bool32, Boolean bool33, Boolean bool34, Long l10, Boolean bool35, Boolean bool36, Boolean bool37, Boolean bool38, Boolean bool39, Boolean bool40, Boolean bool41, Boolean bool42, String str6, Boolean bool43, Long l11, Long l12, Long l13, Boolean bool44, String str7, String str8, String str9, String str10, String str11, Long l14, Boolean bool45, String str12, String str13, Boolean bool46, List list4, Boolean bool47, Long l15, Long l16, List list5, Boolean bool48, Boolean bool49, String str14, String str15, String str16, String str17, Boolean bool50, Number number, Boolean bool51, TrackResourceHeaders trackResourceHeaders, Boolean bool52, int i, int i2, int i3, Object obj) {
            Long l17 = (i & 1) != 0 ? configuration.sessionSampleRate : l;
            Long l18 = (i & 2) != 0 ? configuration.telemetrySampleRate : l2;
            Long l19 = (i & 4) != 0 ? configuration.telemetryConfigurationSampleRate : l3;
            Long l20 = (i & 8) != 0 ? configuration.telemetryUsageSampleRate : l4;
            Long l21 = (i & 16) != 0 ? configuration.traceSampleRate : l5;
            TraceContextInjection traceContextInjection2 = (i & 32) != 0 ? configuration.traceContextInjection : traceContextInjection;
            Long l22 = (i & 64) != 0 ? configuration.premiumSampleRate : l6;
            Long l23 = (i & 128) != 0 ? configuration.replaySampleRate : l7;
            Long l24 = (i & 256) != 0 ? configuration.sessionReplaySampleRate : l8;
            TrackingConsent trackingConsent2 = (i & 512) != 0 ? configuration.trackingConsent : trackingConsent;
            Boolean bool53 = (i & 1024) != 0 ? configuration.startSessionReplayRecordingManually : bool;
            Boolean bool54 = (i & 2048) != 0 ? configuration.startRecordingImmediately : bool2;
            Long l25 = l17;
            Boolean bool55 = (i & 4096) != 0 ? configuration.useProxy : bool3;
            Boolean bool56 = (i & 8192) != 0 ? configuration.useBeforeSend : bool4;
            Boolean bool57 = (i & 16384) != 0 ? configuration.silentMultipleInit : bool5;
            Boolean bool58 = (i & 32768) != 0 ? configuration.trackSessionAcrossSubdomains : bool6;
            Boolean bool59 = (i & 65536) != 0 ? configuration.trackResources : bool7;
            Boolean bool60 = (i & 131072) != 0 ? configuration.trackEarlyRequests : bool8;
            Boolean bool61 = (i & 262144) != 0 ? configuration.trackLongTask : bool9;
            Boolean bool62 = (i & 524288) != 0 ? configuration.trackBfcacheViews : bool10;
            Boolean bool63 = (i & 1048576) != 0 ? configuration.useCrossSiteSessionCookie : bool11;
            Boolean bool64 = (i & 2097152) != 0 ? configuration.usePartitionedCrossSiteSessionCookie : bool12;
            Boolean bool65 = (i & 4194304) != 0 ? configuration.useSecureSessionCookie : bool13;
            Boolean bool66 = (i & 8388608) != 0 ? configuration.allowFallbackToLocalStorage : bool14;
            SessionPersistence sessionPersistence2 = (i & 16777216) != 0 ? configuration.sessionPersistence : sessionPersistence;
            Boolean bool67 = (i & GroupFlagsKt.HasAuxSlotFlag) != 0 ? configuration.storeContextsAcrossPages : bool15;
            Boolean bool68 = (i & 67108864) != 0 ? configuration.allowUntrustedEvents : bool16;
            String str18 = (i & 134217728) != 0 ? configuration.actionNameAttribute : str;
            Boolean bool69 = (i & 268435456) != 0 ? configuration.useAllowedTracingOrigins : bool17;
            Boolean bool70 = (i & 536870912) != 0 ? configuration.useAllowedTracingUrls : bool18;
            Boolean bool71 = (i & 1073741824) != 0 ? configuration.useAllowedGraphQlUrls : bool19;
            Boolean bool72 = (i & Integer.MIN_VALUE) != 0 ? configuration.useTrackGraphQlPayload : bool20;
            Boolean bool73 = (i2 & 1) != 0 ? configuration.useTrackGraphQlResponseErrors : bool21;
            List list6 = (i2 & 2) != 0 ? configuration.selectedTracingPropagators : list;
            String str19 = (i2 & 4) != 0 ? configuration.defaultPrivacyLevel : str2;
            String str20 = (i2 & 8) != 0 ? configuration.textAndInputPrivacyLevel : str3;
            String str21 = (i2 & 16) != 0 ? configuration.imagePrivacyLevel : str4;
            String str22 = (i2 & 32) != 0 ? configuration.touchPrivacyLevel : str5;
            Boolean bool74 = (i2 & 64) != 0 ? configuration.enablePrivacyForActionName : bool22;
            Boolean bool75 = (i2 & 128) != 0 ? configuration.useExcludedActivityUrls : bool23;
            Boolean bool76 = (i2 & 256) != 0 ? configuration.useWorkerUrl : bool24;
            Boolean bool77 = (i2 & 512) != 0 ? configuration.compressIntakeRequests : bool25;
            Boolean bool78 = (i2 & 1024) != 0 ? configuration.trackFrustrations : bool26;
            Boolean bool79 = (i2 & 2048) != 0 ? configuration.trackViewsManually : bool27;
            Boolean bool80 = (i2 & 4096) != 0 ? configuration.trackInteractions : bool28;
            Boolean bool81 = (i2 & 8192) != 0 ? configuration.trackUserInteractions : bool29;
            Boolean bool82 = (i2 & 16384) != 0 ? configuration.forwardErrorsToLogs : bool30;
            Long l26 = (i2 & 32768) != 0 ? configuration.numberOfDisplays : l9;
            List list7 = (i2 & 65536) != 0 ? configuration.forwardConsoleLogs : list2;
            List list8 = (i2 & 131072) != 0 ? configuration.forwardReports : list3;
            Boolean bool83 = (i2 & 262144) != 0 ? configuration.useLocalEncryption : bool31;
            ViewTrackingStrategy viewTrackingStrategy2 = (i2 & 524288) != 0 ? configuration.viewTrackingStrategy : viewTrackingStrategy;
            Boolean bool84 = (i2 & 1048576) != 0 ? configuration.swiftuiViewTrackingEnabled : bool32;
            Boolean bool85 = (i2 & 2097152) != 0 ? configuration.swiftuiActionTrackingEnabled : bool33;
            Boolean bool86 = (i2 & 4194304) != 0 ? configuration.trackBackgroundEvents : bool34;
            Long l27 = (i2 & 8388608) != 0 ? configuration.mobileVitalsUpdatePeriod : l10;
            Boolean bool87 = (i2 & 16777216) != 0 ? configuration.trackErrors : bool35;
            Boolean bool88 = (i2 & GroupFlagsKt.HasAuxSlotFlag) != 0 ? configuration.trackNetworkRequests : bool36;
            Boolean bool89 = (i2 & 67108864) != 0 ? configuration.useTracing : bool37;
            Boolean bool90 = (i2 & 134217728) != 0 ? configuration.trackNativeViews : bool38;
            Boolean bool91 = (i2 & 268435456) != 0 ? configuration.trackNativeErrors : bool39;
            Boolean bool92 = (i2 & 536870912) != 0 ? configuration.trackNativeLongTasks : bool40;
            Boolean bool93 = (i2 & 1073741824) != 0 ? configuration.trackCrossPlatformLongTasks : bool41;
            return configuration.copy(l25, l18, l19, l20, l21, traceContextInjection2, l22, l23, l24, trackingConsent2, bool53, bool54, bool55, bool56, bool57, bool58, bool59, bool60, bool61, bool62, bool63, bool64, bool65, bool66, sessionPersistence2, bool67, bool68, str18, bool69, bool70, bool71, bool72, bool73, list6, str19, str20, str21, str22, bool74, bool75, bool76, bool77, bool78, bool79, bool80, bool81, bool82, l26, list7, list8, bool83, viewTrackingStrategy2, bool84, bool85, bool86, l27, bool87, bool88, bool89, bool90, bool91, bool92, bool93, (i2 & Integer.MIN_VALUE) != 0 ? configuration.useFirstPartyHosts : bool42, (i3 & 1) != 0 ? configuration.initializationType : str6, (i3 & 2) != 0 ? configuration.trackFlutterPerformance : bool43, (i3 & 4) != 0 ? configuration.batchSize : l11, (i3 & 8) != 0 ? configuration.batchUploadFrequency : l12, (i3 & 16) != 0 ? configuration.batchProcessingLevel : l13, (i3 & 32) != 0 ? configuration.backgroundTasksEnabled : bool44, (i3 & 64) != 0 ? configuration.reactVersion : str7, (i3 & 128) != 0 ? configuration.reactNativeVersion : str8, (i3 & 256) != 0 ? configuration.dartVersion : str9, (i3 & 512) != 0 ? configuration.unityVersion : str10, (i3 & 1024) != 0 ? configuration.mauiVersion : str11, (i3 & 2048) != 0 ? configuration.appHangThreshold : l14, (i3 & 4096) != 0 ? configuration.usePciIntake : bool45, (i3 & 8192) != 0 ? configuration.tracerApi : str12, (i3 & 16384) != 0 ? configuration.tracerApiVersion : str13, (i3 & 32768) != 0 ? configuration.sendLogsAfterSessionExpiration : bool46, (i3 & 65536) != 0 ? configuration.plugins : list4, (i3 & 131072) != 0 ? configuration.isMainProcess : bool47, (i3 & 262144) != 0 ? configuration.invTimeThresholdMs : l15, (i3 & 524288) != 0 ? configuration.tnsTimeThresholdMs : l16, (i3 & 1048576) != 0 ? configuration.trackFeatureFlagsForEvents : list5, (i3 & 2097152) != 0 ? configuration.trackAnonymousUser : bool48, (i3 & 4194304) != 0 ? configuration.useAllowedTrackingOrigins : bool49, (i3 & 8388608) != 0 ? configuration.sdkVersion : str14, (i3 & 16777216) != 0 ? configuration.source : str15, (i3 & GroupFlagsKt.HasAuxSlotFlag) != 0 ? configuration.variant : str16, (i3 & 67108864) != 0 ? configuration.remoteConfigurationId : str17, (i3 & 134217728) != 0 ? configuration.useRemoteConfigurationProxy : bool50, (i3 & 268435456) != 0 ? configuration.profilingSampleRate : number, (i3 & 536870912) != 0 ? configuration.propagateTraceBaggage : bool51, (i3 & 1073741824) != 0 ? configuration.trackResourceHeaders : trackResourceHeaders, (i3 & Integer.MIN_VALUE) != 0 ? configuration.betaEncodeCookieOptions : bool52);
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
        public final Long getSessionSampleRate() {
            return this.sessionSampleRate;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final TrackingConsent getTrackingConsent() {
            return this.trackingConsent;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Boolean getStartSessionReplayRecordingManually() {
            return this.startSessionReplayRecordingManually;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final Boolean getStartRecordingImmediately() {
            return this.startRecordingImmediately;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final Boolean getUseProxy() {
            return this.useProxy;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final Boolean getUseBeforeSend() {
            return this.useBeforeSend;
        }

        /* JADX INFO: renamed from: component15, reason: from getter */
        public final Boolean getSilentMultipleInit() {
            return this.silentMultipleInit;
        }

        /* JADX INFO: renamed from: component16, reason: from getter */
        public final Boolean getTrackSessionAcrossSubdomains() {
            return this.trackSessionAcrossSubdomains;
        }

        /* JADX INFO: renamed from: component17, reason: from getter */
        public final Boolean getTrackResources() {
            return this.trackResources;
        }

        /* JADX INFO: renamed from: component18, reason: from getter */
        public final Boolean getTrackEarlyRequests() {
            return this.trackEarlyRequests;
        }

        /* JADX INFO: renamed from: component19, reason: from getter */
        public final Boolean getTrackLongTask() {
            return this.trackLongTask;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Long getTelemetrySampleRate() {
            return this.telemetrySampleRate;
        }

        /* JADX INFO: renamed from: component20, reason: from getter */
        public final Boolean getTrackBfcacheViews() {
            return this.trackBfcacheViews;
        }

        /* JADX INFO: renamed from: component21, reason: from getter */
        public final Boolean getUseCrossSiteSessionCookie() {
            return this.useCrossSiteSessionCookie;
        }

        /* JADX INFO: renamed from: component22, reason: from getter */
        public final Boolean getUsePartitionedCrossSiteSessionCookie() {
            return this.usePartitionedCrossSiteSessionCookie;
        }

        /* JADX INFO: renamed from: component23, reason: from getter */
        public final Boolean getUseSecureSessionCookie() {
            return this.useSecureSessionCookie;
        }

        /* JADX INFO: renamed from: component24, reason: from getter */
        public final Boolean getAllowFallbackToLocalStorage() {
            return this.allowFallbackToLocalStorage;
        }

        /* JADX INFO: renamed from: component25, reason: from getter */
        public final SessionPersistence getSessionPersistence() {
            return this.sessionPersistence;
        }

        /* JADX INFO: renamed from: component26, reason: from getter */
        public final Boolean getStoreContextsAcrossPages() {
            return this.storeContextsAcrossPages;
        }

        /* JADX INFO: renamed from: component27, reason: from getter */
        public final Boolean getAllowUntrustedEvents() {
            return this.allowUntrustedEvents;
        }

        /* JADX INFO: renamed from: component28, reason: from getter */
        public final String getActionNameAttribute() {
            return this.actionNameAttribute;
        }

        /* JADX INFO: renamed from: component29, reason: from getter */
        public final Boolean getUseAllowedTracingOrigins() {
            return this.useAllowedTracingOrigins;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Long getTelemetryConfigurationSampleRate() {
            return this.telemetryConfigurationSampleRate;
        }

        /* JADX INFO: renamed from: component30, reason: from getter */
        public final Boolean getUseAllowedTracingUrls() {
            return this.useAllowedTracingUrls;
        }

        /* JADX INFO: renamed from: component31, reason: from getter */
        public final Boolean getUseAllowedGraphQlUrls() {
            return this.useAllowedGraphQlUrls;
        }

        /* JADX INFO: renamed from: component32, reason: from getter */
        public final Boolean getUseTrackGraphQlPayload() {
            return this.useTrackGraphQlPayload;
        }

        /* JADX INFO: renamed from: component33, reason: from getter */
        public final Boolean getUseTrackGraphQlResponseErrors() {
            return this.useTrackGraphQlResponseErrors;
        }

        public final List<SelectedTracingPropagator> component34() {
            return this.selectedTracingPropagators;
        }

        /* JADX INFO: renamed from: component35, reason: from getter */
        public final String getDefaultPrivacyLevel() {
            return this.defaultPrivacyLevel;
        }

        /* JADX INFO: renamed from: component36, reason: from getter */
        public final String getTextAndInputPrivacyLevel() {
            return this.textAndInputPrivacyLevel;
        }

        /* JADX INFO: renamed from: component37, reason: from getter */
        public final String getImagePrivacyLevel() {
            return this.imagePrivacyLevel;
        }

        /* JADX INFO: renamed from: component38, reason: from getter */
        public final String getTouchPrivacyLevel() {
            return this.touchPrivacyLevel;
        }

        /* JADX INFO: renamed from: component39, reason: from getter */
        public final Boolean getEnablePrivacyForActionName() {
            return this.enablePrivacyForActionName;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Long getTelemetryUsageSampleRate() {
            return this.telemetryUsageSampleRate;
        }

        /* JADX INFO: renamed from: component40, reason: from getter */
        public final Boolean getUseExcludedActivityUrls() {
            return this.useExcludedActivityUrls;
        }

        /* JADX INFO: renamed from: component41, reason: from getter */
        public final Boolean getUseWorkerUrl() {
            return this.useWorkerUrl;
        }

        /* JADX INFO: renamed from: component42, reason: from getter */
        public final Boolean getCompressIntakeRequests() {
            return this.compressIntakeRequests;
        }

        /* JADX INFO: renamed from: component43, reason: from getter */
        public final Boolean getTrackFrustrations() {
            return this.trackFrustrations;
        }

        /* JADX INFO: renamed from: component44, reason: from getter */
        public final Boolean getTrackViewsManually() {
            return this.trackViewsManually;
        }

        /* JADX INFO: renamed from: component45, reason: from getter */
        public final Boolean getTrackInteractions() {
            return this.trackInteractions;
        }

        /* JADX INFO: renamed from: component46, reason: from getter */
        public final Boolean getTrackUserInteractions() {
            return this.trackUserInteractions;
        }

        /* JADX INFO: renamed from: component47, reason: from getter */
        public final Boolean getForwardErrorsToLogs() {
            return this.forwardErrorsToLogs;
        }

        /* JADX INFO: renamed from: component48, reason: from getter */
        public final Long getNumberOfDisplays() {
            return this.numberOfDisplays;
        }

        public final List<String> component49() {
            return this.forwardConsoleLogs;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Long getTraceSampleRate() {
            return this.traceSampleRate;
        }

        public final List<String> component50() {
            return this.forwardReports;
        }

        /* JADX INFO: renamed from: component51, reason: from getter */
        public final Boolean getUseLocalEncryption() {
            return this.useLocalEncryption;
        }

        /* JADX INFO: renamed from: component52, reason: from getter */
        public final ViewTrackingStrategy getViewTrackingStrategy() {
            return this.viewTrackingStrategy;
        }

        /* JADX INFO: renamed from: component53, reason: from getter */
        public final Boolean getSwiftuiViewTrackingEnabled() {
            return this.swiftuiViewTrackingEnabled;
        }

        /* JADX INFO: renamed from: component54, reason: from getter */
        public final Boolean getSwiftuiActionTrackingEnabled() {
            return this.swiftuiActionTrackingEnabled;
        }

        /* JADX INFO: renamed from: component55, reason: from getter */
        public final Boolean getTrackBackgroundEvents() {
            return this.trackBackgroundEvents;
        }

        /* JADX INFO: renamed from: component56, reason: from getter */
        public final Long getMobileVitalsUpdatePeriod() {
            return this.mobileVitalsUpdatePeriod;
        }

        /* JADX INFO: renamed from: component57, reason: from getter */
        public final Boolean getTrackErrors() {
            return this.trackErrors;
        }

        /* JADX INFO: renamed from: component58, reason: from getter */
        public final Boolean getTrackNetworkRequests() {
            return this.trackNetworkRequests;
        }

        /* JADX INFO: renamed from: component59, reason: from getter */
        public final Boolean getUseTracing() {
            return this.useTracing;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final TraceContextInjection getTraceContextInjection() {
            return this.traceContextInjection;
        }

        /* JADX INFO: renamed from: component60, reason: from getter */
        public final Boolean getTrackNativeViews() {
            return this.trackNativeViews;
        }

        /* JADX INFO: renamed from: component61, reason: from getter */
        public final Boolean getTrackNativeErrors() {
            return this.trackNativeErrors;
        }

        /* JADX INFO: renamed from: component62, reason: from getter */
        public final Boolean getTrackNativeLongTasks() {
            return this.trackNativeLongTasks;
        }

        /* JADX INFO: renamed from: component63, reason: from getter */
        public final Boolean getTrackCrossPlatformLongTasks() {
            return this.trackCrossPlatformLongTasks;
        }

        /* JADX INFO: renamed from: component64, reason: from getter */
        public final Boolean getUseFirstPartyHosts() {
            return this.useFirstPartyHosts;
        }

        /* JADX INFO: renamed from: component65, reason: from getter */
        public final String getInitializationType() {
            return this.initializationType;
        }

        /* JADX INFO: renamed from: component66, reason: from getter */
        public final Boolean getTrackFlutterPerformance() {
            return this.trackFlutterPerformance;
        }

        /* JADX INFO: renamed from: component67, reason: from getter */
        public final Long getBatchSize() {
            return this.batchSize;
        }

        /* JADX INFO: renamed from: component68, reason: from getter */
        public final Long getBatchUploadFrequency() {
            return this.batchUploadFrequency;
        }

        /* JADX INFO: renamed from: component69, reason: from getter */
        public final Long getBatchProcessingLevel() {
            return this.batchProcessingLevel;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Long getPremiumSampleRate() {
            return this.premiumSampleRate;
        }

        /* JADX INFO: renamed from: component70, reason: from getter */
        public final Boolean getBackgroundTasksEnabled() {
            return this.backgroundTasksEnabled;
        }

        /* JADX INFO: renamed from: component71, reason: from getter */
        public final String getReactVersion() {
            return this.reactVersion;
        }

        /* JADX INFO: renamed from: component72, reason: from getter */
        public final String getReactNativeVersion() {
            return this.reactNativeVersion;
        }

        /* JADX INFO: renamed from: component73, reason: from getter */
        public final String getDartVersion() {
            return this.dartVersion;
        }

        /* JADX INFO: renamed from: component74, reason: from getter */
        public final String getUnityVersion() {
            return this.unityVersion;
        }

        /* JADX INFO: renamed from: component75, reason: from getter */
        public final String getMauiVersion() {
            return this.mauiVersion;
        }

        /* JADX INFO: renamed from: component76, reason: from getter */
        public final Long getAppHangThreshold() {
            return this.appHangThreshold;
        }

        /* JADX INFO: renamed from: component77, reason: from getter */
        public final Boolean getUsePciIntake() {
            return this.usePciIntake;
        }

        /* JADX INFO: renamed from: component78, reason: from getter */
        public final String getTracerApi() {
            return this.tracerApi;
        }

        /* JADX INFO: renamed from: component79, reason: from getter */
        public final String getTracerApiVersion() {
            return this.tracerApiVersion;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Long getReplaySampleRate() {
            return this.replaySampleRate;
        }

        /* JADX INFO: renamed from: component80, reason: from getter */
        public final Boolean getSendLogsAfterSessionExpiration() {
            return this.sendLogsAfterSessionExpiration;
        }

        public final List<Plugin> component81() {
            return this.plugins;
        }

        /* JADX INFO: renamed from: component82, reason: from getter */
        public final Boolean getIsMainProcess() {
            return this.isMainProcess;
        }

        /* JADX INFO: renamed from: component83, reason: from getter */
        public final Long getInvTimeThresholdMs() {
            return this.invTimeThresholdMs;
        }

        /* JADX INFO: renamed from: component84, reason: from getter */
        public final Long getTnsTimeThresholdMs() {
            return this.tnsTimeThresholdMs;
        }

        public final List<TrackFeatureFlagsForEvent> component85() {
            return this.trackFeatureFlagsForEvents;
        }

        /* JADX INFO: renamed from: component86, reason: from getter */
        public final Boolean getTrackAnonymousUser() {
            return this.trackAnonymousUser;
        }

        /* JADX INFO: renamed from: component87, reason: from getter */
        public final Boolean getUseAllowedTrackingOrigins() {
            return this.useAllowedTrackingOrigins;
        }

        /* JADX INFO: renamed from: component88, reason: from getter */
        public final String getSdkVersion() {
            return this.sdkVersion;
        }

        /* JADX INFO: renamed from: component89, reason: from getter */
        public final String getSource() {
            return this.source;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Long getSessionReplaySampleRate() {
            return this.sessionReplaySampleRate;
        }

        /* JADX INFO: renamed from: component90, reason: from getter */
        public final String getVariant() {
            return this.variant;
        }

        /* JADX INFO: renamed from: component91, reason: from getter */
        public final String getRemoteConfigurationId() {
            return this.remoteConfigurationId;
        }

        /* JADX INFO: renamed from: component92, reason: from getter */
        public final Boolean getUseRemoteConfigurationProxy() {
            return this.useRemoteConfigurationProxy;
        }

        /* JADX INFO: renamed from: component93, reason: from getter */
        public final Number getProfilingSampleRate() {
            return this.profilingSampleRate;
        }

        /* JADX INFO: renamed from: component94, reason: from getter */
        public final Boolean getPropagateTraceBaggage() {
            return this.propagateTraceBaggage;
        }

        /* JADX INFO: renamed from: component95, reason: from getter */
        public final TrackResourceHeaders getTrackResourceHeaders() {
            return this.trackResourceHeaders;
        }

        /* JADX INFO: renamed from: component96, reason: from getter */
        public final Boolean getBetaEncodeCookieOptions() {
            return this.betaEncodeCookieOptions;
        }

        public final Configuration copy(Long sessionSampleRate, Long telemetrySampleRate, Long telemetryConfigurationSampleRate, Long telemetryUsageSampleRate, Long traceSampleRate, TraceContextInjection traceContextInjection, Long premiumSampleRate, Long replaySampleRate, Long sessionReplaySampleRate, TrackingConsent trackingConsent, Boolean startSessionReplayRecordingManually, Boolean startRecordingImmediately, Boolean useProxy, Boolean useBeforeSend, Boolean silentMultipleInit, Boolean trackSessionAcrossSubdomains, Boolean trackResources, Boolean trackEarlyRequests, Boolean trackLongTask, Boolean trackBfcacheViews, Boolean useCrossSiteSessionCookie, Boolean usePartitionedCrossSiteSessionCookie, Boolean useSecureSessionCookie, Boolean allowFallbackToLocalStorage, SessionPersistence sessionPersistence, Boolean storeContextsAcrossPages, Boolean allowUntrustedEvents, String actionNameAttribute, Boolean useAllowedTracingOrigins, Boolean useAllowedTracingUrls, Boolean useAllowedGraphQlUrls, Boolean useTrackGraphQlPayload, Boolean useTrackGraphQlResponseErrors, List<? extends SelectedTracingPropagator> selectedTracingPropagators, String defaultPrivacyLevel, String textAndInputPrivacyLevel, String imagePrivacyLevel, String touchPrivacyLevel, Boolean enablePrivacyForActionName, Boolean useExcludedActivityUrls, Boolean useWorkerUrl, Boolean compressIntakeRequests, Boolean trackFrustrations, Boolean trackViewsManually, Boolean trackInteractions, Boolean trackUserInteractions, Boolean forwardErrorsToLogs, Long numberOfDisplays, List<String> forwardConsoleLogs, List<String> forwardReports, Boolean useLocalEncryption, ViewTrackingStrategy viewTrackingStrategy, Boolean swiftuiViewTrackingEnabled, Boolean swiftuiActionTrackingEnabled, Boolean trackBackgroundEvents, Long mobileVitalsUpdatePeriod, Boolean trackErrors, Boolean trackNetworkRequests, Boolean useTracing, Boolean trackNativeViews, Boolean trackNativeErrors, Boolean trackNativeLongTasks, Boolean trackCrossPlatformLongTasks, Boolean useFirstPartyHosts, String initializationType, Boolean trackFlutterPerformance, Long batchSize, Long batchUploadFrequency, Long batchProcessingLevel, Boolean backgroundTasksEnabled, String reactVersion, String reactNativeVersion, String dartVersion, String unityVersion, String mauiVersion, Long appHangThreshold, Boolean usePciIntake, String tracerApi, String tracerApiVersion, Boolean sendLogsAfterSessionExpiration, List<Plugin> plugins, Boolean isMainProcess, Long invTimeThresholdMs, Long tnsTimeThresholdMs, List<? extends TrackFeatureFlagsForEvent> trackFeatureFlagsForEvents, Boolean trackAnonymousUser, Boolean useAllowedTrackingOrigins, String sdkVersion, String source, String variant, String remoteConfigurationId, Boolean useRemoteConfigurationProxy, Number profilingSampleRate, Boolean propagateTraceBaggage, TrackResourceHeaders trackResourceHeaders, Boolean betaEncodeCookieOptions) {
            return new Configuration(sessionSampleRate, telemetrySampleRate, telemetryConfigurationSampleRate, telemetryUsageSampleRate, traceSampleRate, traceContextInjection, premiumSampleRate, replaySampleRate, sessionReplaySampleRate, trackingConsent, startSessionReplayRecordingManually, startRecordingImmediately, useProxy, useBeforeSend, silentMultipleInit, trackSessionAcrossSubdomains, trackResources, trackEarlyRequests, trackLongTask, trackBfcacheViews, useCrossSiteSessionCookie, usePartitionedCrossSiteSessionCookie, useSecureSessionCookie, allowFallbackToLocalStorage, sessionPersistence, storeContextsAcrossPages, allowUntrustedEvents, actionNameAttribute, useAllowedTracingOrigins, useAllowedTracingUrls, useAllowedGraphQlUrls, useTrackGraphQlPayload, useTrackGraphQlResponseErrors, selectedTracingPropagators, defaultPrivacyLevel, textAndInputPrivacyLevel, imagePrivacyLevel, touchPrivacyLevel, enablePrivacyForActionName, useExcludedActivityUrls, useWorkerUrl, compressIntakeRequests, trackFrustrations, trackViewsManually, trackInteractions, trackUserInteractions, forwardErrorsToLogs, numberOfDisplays, forwardConsoleLogs, forwardReports, useLocalEncryption, viewTrackingStrategy, swiftuiViewTrackingEnabled, swiftuiActionTrackingEnabled, trackBackgroundEvents, mobileVitalsUpdatePeriod, trackErrors, trackNetworkRequests, useTracing, trackNativeViews, trackNativeErrors, trackNativeLongTasks, trackCrossPlatformLongTasks, useFirstPartyHosts, initializationType, trackFlutterPerformance, batchSize, batchUploadFrequency, batchProcessingLevel, backgroundTasksEnabled, reactVersion, reactNativeVersion, dartVersion, unityVersion, mauiVersion, appHangThreshold, usePciIntake, tracerApi, tracerApiVersion, sendLogsAfterSessionExpiration, plugins, isMainProcess, invTimeThresholdMs, tnsTimeThresholdMs, trackFeatureFlagsForEvents, trackAnonymousUser, useAllowedTrackingOrigins, sdkVersion, source, variant, remoteConfigurationId, useRemoteConfigurationProxy, profilingSampleRate, propagateTraceBaggage, trackResourceHeaders, betaEncodeCookieOptions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Configuration)) {
                return false;
            }
            Configuration configuration = (Configuration) other;
            return Intrinsics.areEqual(this.sessionSampleRate, configuration.sessionSampleRate) && Intrinsics.areEqual(this.telemetrySampleRate, configuration.telemetrySampleRate) && Intrinsics.areEqual(this.telemetryConfigurationSampleRate, configuration.telemetryConfigurationSampleRate) && Intrinsics.areEqual(this.telemetryUsageSampleRate, configuration.telemetryUsageSampleRate) && Intrinsics.areEqual(this.traceSampleRate, configuration.traceSampleRate) && this.traceContextInjection == configuration.traceContextInjection && Intrinsics.areEqual(this.premiumSampleRate, configuration.premiumSampleRate) && Intrinsics.areEqual(this.replaySampleRate, configuration.replaySampleRate) && Intrinsics.areEqual(this.sessionReplaySampleRate, configuration.sessionReplaySampleRate) && this.trackingConsent == configuration.trackingConsent && Intrinsics.areEqual(this.startSessionReplayRecordingManually, configuration.startSessionReplayRecordingManually) && Intrinsics.areEqual(this.startRecordingImmediately, configuration.startRecordingImmediately) && Intrinsics.areEqual(this.useProxy, configuration.useProxy) && Intrinsics.areEqual(this.useBeforeSend, configuration.useBeforeSend) && Intrinsics.areEqual(this.silentMultipleInit, configuration.silentMultipleInit) && Intrinsics.areEqual(this.trackSessionAcrossSubdomains, configuration.trackSessionAcrossSubdomains) && Intrinsics.areEqual(this.trackResources, configuration.trackResources) && Intrinsics.areEqual(this.trackEarlyRequests, configuration.trackEarlyRequests) && Intrinsics.areEqual(this.trackLongTask, configuration.trackLongTask) && Intrinsics.areEqual(this.trackBfcacheViews, configuration.trackBfcacheViews) && Intrinsics.areEqual(this.useCrossSiteSessionCookie, configuration.useCrossSiteSessionCookie) && Intrinsics.areEqual(this.usePartitionedCrossSiteSessionCookie, configuration.usePartitionedCrossSiteSessionCookie) && Intrinsics.areEqual(this.useSecureSessionCookie, configuration.useSecureSessionCookie) && Intrinsics.areEqual(this.allowFallbackToLocalStorage, configuration.allowFallbackToLocalStorage) && this.sessionPersistence == configuration.sessionPersistence && Intrinsics.areEqual(this.storeContextsAcrossPages, configuration.storeContextsAcrossPages) && Intrinsics.areEqual(this.allowUntrustedEvents, configuration.allowUntrustedEvents) && Intrinsics.areEqual(this.actionNameAttribute, configuration.actionNameAttribute) && Intrinsics.areEqual(this.useAllowedTracingOrigins, configuration.useAllowedTracingOrigins) && Intrinsics.areEqual(this.useAllowedTracingUrls, configuration.useAllowedTracingUrls) && Intrinsics.areEqual(this.useAllowedGraphQlUrls, configuration.useAllowedGraphQlUrls) && Intrinsics.areEqual(this.useTrackGraphQlPayload, configuration.useTrackGraphQlPayload) && Intrinsics.areEqual(this.useTrackGraphQlResponseErrors, configuration.useTrackGraphQlResponseErrors) && Intrinsics.areEqual(this.selectedTracingPropagators, configuration.selectedTracingPropagators) && Intrinsics.areEqual(this.defaultPrivacyLevel, configuration.defaultPrivacyLevel) && Intrinsics.areEqual(this.textAndInputPrivacyLevel, configuration.textAndInputPrivacyLevel) && Intrinsics.areEqual(this.imagePrivacyLevel, configuration.imagePrivacyLevel) && Intrinsics.areEqual(this.touchPrivacyLevel, configuration.touchPrivacyLevel) && Intrinsics.areEqual(this.enablePrivacyForActionName, configuration.enablePrivacyForActionName) && Intrinsics.areEqual(this.useExcludedActivityUrls, configuration.useExcludedActivityUrls) && Intrinsics.areEqual(this.useWorkerUrl, configuration.useWorkerUrl) && Intrinsics.areEqual(this.compressIntakeRequests, configuration.compressIntakeRequests) && Intrinsics.areEqual(this.trackFrustrations, configuration.trackFrustrations) && Intrinsics.areEqual(this.trackViewsManually, configuration.trackViewsManually) && Intrinsics.areEqual(this.trackInteractions, configuration.trackInteractions) && Intrinsics.areEqual(this.trackUserInteractions, configuration.trackUserInteractions) && Intrinsics.areEqual(this.forwardErrorsToLogs, configuration.forwardErrorsToLogs) && Intrinsics.areEqual(this.numberOfDisplays, configuration.numberOfDisplays) && Intrinsics.areEqual(this.forwardConsoleLogs, configuration.forwardConsoleLogs) && Intrinsics.areEqual(this.forwardReports, configuration.forwardReports) && Intrinsics.areEqual(this.useLocalEncryption, configuration.useLocalEncryption) && this.viewTrackingStrategy == configuration.viewTrackingStrategy && Intrinsics.areEqual(this.swiftuiViewTrackingEnabled, configuration.swiftuiViewTrackingEnabled) && Intrinsics.areEqual(this.swiftuiActionTrackingEnabled, configuration.swiftuiActionTrackingEnabled) && Intrinsics.areEqual(this.trackBackgroundEvents, configuration.trackBackgroundEvents) && Intrinsics.areEqual(this.mobileVitalsUpdatePeriod, configuration.mobileVitalsUpdatePeriod) && Intrinsics.areEqual(this.trackErrors, configuration.trackErrors) && Intrinsics.areEqual(this.trackNetworkRequests, configuration.trackNetworkRequests) && Intrinsics.areEqual(this.useTracing, configuration.useTracing) && Intrinsics.areEqual(this.trackNativeViews, configuration.trackNativeViews) && Intrinsics.areEqual(this.trackNativeErrors, configuration.trackNativeErrors) && Intrinsics.areEqual(this.trackNativeLongTasks, configuration.trackNativeLongTasks) && Intrinsics.areEqual(this.trackCrossPlatformLongTasks, configuration.trackCrossPlatformLongTasks) && Intrinsics.areEqual(this.useFirstPartyHosts, configuration.useFirstPartyHosts) && Intrinsics.areEqual(this.initializationType, configuration.initializationType) && Intrinsics.areEqual(this.trackFlutterPerformance, configuration.trackFlutterPerformance) && Intrinsics.areEqual(this.batchSize, configuration.batchSize) && Intrinsics.areEqual(this.batchUploadFrequency, configuration.batchUploadFrequency) && Intrinsics.areEqual(this.batchProcessingLevel, configuration.batchProcessingLevel) && Intrinsics.areEqual(this.backgroundTasksEnabled, configuration.backgroundTasksEnabled) && Intrinsics.areEqual(this.reactVersion, configuration.reactVersion) && Intrinsics.areEqual(this.reactNativeVersion, configuration.reactNativeVersion) && Intrinsics.areEqual(this.dartVersion, configuration.dartVersion) && Intrinsics.areEqual(this.unityVersion, configuration.unityVersion) && Intrinsics.areEqual(this.mauiVersion, configuration.mauiVersion) && Intrinsics.areEqual(this.appHangThreshold, configuration.appHangThreshold) && Intrinsics.areEqual(this.usePciIntake, configuration.usePciIntake) && Intrinsics.areEqual(this.tracerApi, configuration.tracerApi) && Intrinsics.areEqual(this.tracerApiVersion, configuration.tracerApiVersion) && Intrinsics.areEqual(this.sendLogsAfterSessionExpiration, configuration.sendLogsAfterSessionExpiration) && Intrinsics.areEqual(this.plugins, configuration.plugins) && Intrinsics.areEqual(this.isMainProcess, configuration.isMainProcess) && Intrinsics.areEqual(this.invTimeThresholdMs, configuration.invTimeThresholdMs) && Intrinsics.areEqual(this.tnsTimeThresholdMs, configuration.tnsTimeThresholdMs) && Intrinsics.areEqual(this.trackFeatureFlagsForEvents, configuration.trackFeatureFlagsForEvents) && Intrinsics.areEqual(this.trackAnonymousUser, configuration.trackAnonymousUser) && Intrinsics.areEqual(this.useAllowedTrackingOrigins, configuration.useAllowedTrackingOrigins) && Intrinsics.areEqual(this.sdkVersion, configuration.sdkVersion) && Intrinsics.areEqual(this.source, configuration.source) && Intrinsics.areEqual(this.variant, configuration.variant) && Intrinsics.areEqual(this.remoteConfigurationId, configuration.remoteConfigurationId) && Intrinsics.areEqual(this.useRemoteConfigurationProxy, configuration.useRemoteConfigurationProxy) && Intrinsics.areEqual(this.profilingSampleRate, configuration.profilingSampleRate) && Intrinsics.areEqual(this.propagateTraceBaggage, configuration.propagateTraceBaggage) && this.trackResourceHeaders == configuration.trackResourceHeaders && Intrinsics.areEqual(this.betaEncodeCookieOptions, configuration.betaEncodeCookieOptions);
        }

        public int hashCode() {
            Long l = this.sessionSampleRate;
            int iHashCode = (l == null ? 0 : l.hashCode()) * 31;
            Long l2 = this.telemetrySampleRate;
            int iHashCode2 = (iHashCode + (l2 == null ? 0 : l2.hashCode())) * 31;
            Long l3 = this.telemetryConfigurationSampleRate;
            int iHashCode3 = (iHashCode2 + (l3 == null ? 0 : l3.hashCode())) * 31;
            Long l4 = this.telemetryUsageSampleRate;
            int iHashCode4 = (iHashCode3 + (l4 == null ? 0 : l4.hashCode())) * 31;
            Long l5 = this.traceSampleRate;
            int iHashCode5 = (iHashCode4 + (l5 == null ? 0 : l5.hashCode())) * 31;
            TraceContextInjection traceContextInjection = this.traceContextInjection;
            int iHashCode6 = (iHashCode5 + (traceContextInjection == null ? 0 : traceContextInjection.hashCode())) * 31;
            Long l6 = this.premiumSampleRate;
            int iHashCode7 = (iHashCode6 + (l6 == null ? 0 : l6.hashCode())) * 31;
            Long l7 = this.replaySampleRate;
            int iHashCode8 = (iHashCode7 + (l7 == null ? 0 : l7.hashCode())) * 31;
            Long l8 = this.sessionReplaySampleRate;
            int iHashCode9 = (iHashCode8 + (l8 == null ? 0 : l8.hashCode())) * 31;
            TrackingConsent trackingConsent = this.trackingConsent;
            int iHashCode10 = (iHashCode9 + (trackingConsent == null ? 0 : trackingConsent.hashCode())) * 31;
            Boolean bool = this.startSessionReplayRecordingManually;
            int iHashCode11 = (iHashCode10 + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.startRecordingImmediately;
            int iHashCode12 = (iHashCode11 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.useProxy;
            int iHashCode13 = (iHashCode12 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
            Boolean bool4 = this.useBeforeSend;
            int iHashCode14 = (iHashCode13 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
            Boolean bool5 = this.silentMultipleInit;
            int iHashCode15 = (iHashCode14 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
            Boolean bool6 = this.trackSessionAcrossSubdomains;
            int iHashCode16 = (iHashCode15 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
            Boolean bool7 = this.trackResources;
            int iHashCode17 = (iHashCode16 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
            Boolean bool8 = this.trackEarlyRequests;
            int iHashCode18 = (iHashCode17 + (bool8 == null ? 0 : bool8.hashCode())) * 31;
            Boolean bool9 = this.trackLongTask;
            int iHashCode19 = (iHashCode18 + (bool9 == null ? 0 : bool9.hashCode())) * 31;
            Boolean bool10 = this.trackBfcacheViews;
            int iHashCode20 = (iHashCode19 + (bool10 == null ? 0 : bool10.hashCode())) * 31;
            Boolean bool11 = this.useCrossSiteSessionCookie;
            int iHashCode21 = (iHashCode20 + (bool11 == null ? 0 : bool11.hashCode())) * 31;
            Boolean bool12 = this.usePartitionedCrossSiteSessionCookie;
            int iHashCode22 = (iHashCode21 + (bool12 == null ? 0 : bool12.hashCode())) * 31;
            Boolean bool13 = this.useSecureSessionCookie;
            int iHashCode23 = (iHashCode22 + (bool13 == null ? 0 : bool13.hashCode())) * 31;
            Boolean bool14 = this.allowFallbackToLocalStorage;
            int iHashCode24 = (iHashCode23 + (bool14 == null ? 0 : bool14.hashCode())) * 31;
            SessionPersistence sessionPersistence = this.sessionPersistence;
            int iHashCode25 = (iHashCode24 + (sessionPersistence == null ? 0 : sessionPersistence.hashCode())) * 31;
            Boolean bool15 = this.storeContextsAcrossPages;
            int iHashCode26 = (iHashCode25 + (bool15 == null ? 0 : bool15.hashCode())) * 31;
            Boolean bool16 = this.allowUntrustedEvents;
            int iHashCode27 = (iHashCode26 + (bool16 == null ? 0 : bool16.hashCode())) * 31;
            String str = this.actionNameAttribute;
            int iHashCode28 = (iHashCode27 + (str == null ? 0 : str.hashCode())) * 31;
            Boolean bool17 = this.useAllowedTracingOrigins;
            int iHashCode29 = (iHashCode28 + (bool17 == null ? 0 : bool17.hashCode())) * 31;
            Boolean bool18 = this.useAllowedTracingUrls;
            int iHashCode30 = (iHashCode29 + (bool18 == null ? 0 : bool18.hashCode())) * 31;
            Boolean bool19 = this.useAllowedGraphQlUrls;
            int iHashCode31 = (iHashCode30 + (bool19 == null ? 0 : bool19.hashCode())) * 31;
            Boolean bool20 = this.useTrackGraphQlPayload;
            int iHashCode32 = (iHashCode31 + (bool20 == null ? 0 : bool20.hashCode())) * 31;
            Boolean bool21 = this.useTrackGraphQlResponseErrors;
            int iHashCode33 = (iHashCode32 + (bool21 == null ? 0 : bool21.hashCode())) * 31;
            List<SelectedTracingPropagator> list = this.selectedTracingPropagators;
            int iHashCode34 = (iHashCode33 + (list == null ? 0 : list.hashCode())) * 31;
            String str2 = this.defaultPrivacyLevel;
            int iHashCode35 = (iHashCode34 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.textAndInputPrivacyLevel;
            int iHashCode36 = (iHashCode35 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.imagePrivacyLevel;
            int iHashCode37 = (iHashCode36 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.touchPrivacyLevel;
            int iHashCode38 = (iHashCode37 + (str5 == null ? 0 : str5.hashCode())) * 31;
            Boolean bool22 = this.enablePrivacyForActionName;
            int iHashCode39 = (iHashCode38 + (bool22 == null ? 0 : bool22.hashCode())) * 31;
            Boolean bool23 = this.useExcludedActivityUrls;
            int iHashCode40 = (iHashCode39 + (bool23 == null ? 0 : bool23.hashCode())) * 31;
            Boolean bool24 = this.useWorkerUrl;
            int iHashCode41 = (iHashCode40 + (bool24 == null ? 0 : bool24.hashCode())) * 31;
            Boolean bool25 = this.compressIntakeRequests;
            int iHashCode42 = (iHashCode41 + (bool25 == null ? 0 : bool25.hashCode())) * 31;
            Boolean bool26 = this.trackFrustrations;
            int iHashCode43 = (iHashCode42 + (bool26 == null ? 0 : bool26.hashCode())) * 31;
            Boolean bool27 = this.trackViewsManually;
            int iHashCode44 = (iHashCode43 + (bool27 == null ? 0 : bool27.hashCode())) * 31;
            Boolean bool28 = this.trackInteractions;
            int iHashCode45 = (iHashCode44 + (bool28 == null ? 0 : bool28.hashCode())) * 31;
            Boolean bool29 = this.trackUserInteractions;
            int iHashCode46 = (iHashCode45 + (bool29 == null ? 0 : bool29.hashCode())) * 31;
            Boolean bool30 = this.forwardErrorsToLogs;
            int iHashCode47 = (iHashCode46 + (bool30 == null ? 0 : bool30.hashCode())) * 31;
            Long l9 = this.numberOfDisplays;
            int iHashCode48 = (iHashCode47 + (l9 == null ? 0 : l9.hashCode())) * 31;
            List<String> list2 = this.forwardConsoleLogs;
            int iHashCode49 = (iHashCode48 + (list2 == null ? 0 : list2.hashCode())) * 31;
            List<String> list3 = this.forwardReports;
            int iHashCode50 = (iHashCode49 + (list3 == null ? 0 : list3.hashCode())) * 31;
            Boolean bool31 = this.useLocalEncryption;
            int iHashCode51 = (iHashCode50 + (bool31 == null ? 0 : bool31.hashCode())) * 31;
            ViewTrackingStrategy viewTrackingStrategy = this.viewTrackingStrategy;
            int iHashCode52 = (iHashCode51 + (viewTrackingStrategy == null ? 0 : viewTrackingStrategy.hashCode())) * 31;
            Boolean bool32 = this.swiftuiViewTrackingEnabled;
            int iHashCode53 = (iHashCode52 + (bool32 == null ? 0 : bool32.hashCode())) * 31;
            Boolean bool33 = this.swiftuiActionTrackingEnabled;
            int iHashCode54 = (iHashCode53 + (bool33 == null ? 0 : bool33.hashCode())) * 31;
            Boolean bool34 = this.trackBackgroundEvents;
            int iHashCode55 = (iHashCode54 + (bool34 == null ? 0 : bool34.hashCode())) * 31;
            Long l10 = this.mobileVitalsUpdatePeriod;
            int iHashCode56 = (iHashCode55 + (l10 == null ? 0 : l10.hashCode())) * 31;
            Boolean bool35 = this.trackErrors;
            int iHashCode57 = (iHashCode56 + (bool35 == null ? 0 : bool35.hashCode())) * 31;
            Boolean bool36 = this.trackNetworkRequests;
            int iHashCode58 = (iHashCode57 + (bool36 == null ? 0 : bool36.hashCode())) * 31;
            Boolean bool37 = this.useTracing;
            int iHashCode59 = (iHashCode58 + (bool37 == null ? 0 : bool37.hashCode())) * 31;
            Boolean bool38 = this.trackNativeViews;
            int iHashCode60 = (iHashCode59 + (bool38 == null ? 0 : bool38.hashCode())) * 31;
            Boolean bool39 = this.trackNativeErrors;
            int iHashCode61 = (iHashCode60 + (bool39 == null ? 0 : bool39.hashCode())) * 31;
            Boolean bool40 = this.trackNativeLongTasks;
            int iHashCode62 = (iHashCode61 + (bool40 == null ? 0 : bool40.hashCode())) * 31;
            Boolean bool41 = this.trackCrossPlatformLongTasks;
            int iHashCode63 = (iHashCode62 + (bool41 == null ? 0 : bool41.hashCode())) * 31;
            Boolean bool42 = this.useFirstPartyHosts;
            int iHashCode64 = (iHashCode63 + (bool42 == null ? 0 : bool42.hashCode())) * 31;
            String str6 = this.initializationType;
            int iHashCode65 = (iHashCode64 + (str6 == null ? 0 : str6.hashCode())) * 31;
            Boolean bool43 = this.trackFlutterPerformance;
            int iHashCode66 = (iHashCode65 + (bool43 == null ? 0 : bool43.hashCode())) * 31;
            Long l11 = this.batchSize;
            int iHashCode67 = (iHashCode66 + (l11 == null ? 0 : l11.hashCode())) * 31;
            Long l12 = this.batchUploadFrequency;
            int iHashCode68 = (iHashCode67 + (l12 == null ? 0 : l12.hashCode())) * 31;
            Long l13 = this.batchProcessingLevel;
            int iHashCode69 = (iHashCode68 + (l13 == null ? 0 : l13.hashCode())) * 31;
            Boolean bool44 = this.backgroundTasksEnabled;
            int iHashCode70 = (iHashCode69 + (bool44 == null ? 0 : bool44.hashCode())) * 31;
            String str7 = this.reactVersion;
            int iHashCode71 = (iHashCode70 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.reactNativeVersion;
            int iHashCode72 = (iHashCode71 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.dartVersion;
            int iHashCode73 = (iHashCode72 + (str9 == null ? 0 : str9.hashCode())) * 31;
            String str10 = this.unityVersion;
            int iHashCode74 = (iHashCode73 + (str10 == null ? 0 : str10.hashCode())) * 31;
            String str11 = this.mauiVersion;
            int iHashCode75 = (iHashCode74 + (str11 == null ? 0 : str11.hashCode())) * 31;
            Long l14 = this.appHangThreshold;
            int iHashCode76 = (iHashCode75 + (l14 == null ? 0 : l14.hashCode())) * 31;
            Boolean bool45 = this.usePciIntake;
            int iHashCode77 = (iHashCode76 + (bool45 == null ? 0 : bool45.hashCode())) * 31;
            String str12 = this.tracerApi;
            int iHashCode78 = (iHashCode77 + (str12 == null ? 0 : str12.hashCode())) * 31;
            String str13 = this.tracerApiVersion;
            int iHashCode79 = (iHashCode78 + (str13 == null ? 0 : str13.hashCode())) * 31;
            Boolean bool46 = this.sendLogsAfterSessionExpiration;
            int iHashCode80 = (iHashCode79 + (bool46 == null ? 0 : bool46.hashCode())) * 31;
            List<Plugin> list4 = this.plugins;
            int iHashCode81 = (iHashCode80 + (list4 == null ? 0 : list4.hashCode())) * 31;
            Boolean bool47 = this.isMainProcess;
            int iHashCode82 = (iHashCode81 + (bool47 == null ? 0 : bool47.hashCode())) * 31;
            Long l15 = this.invTimeThresholdMs;
            int iHashCode83 = (iHashCode82 + (l15 == null ? 0 : l15.hashCode())) * 31;
            Long l16 = this.tnsTimeThresholdMs;
            int iHashCode84 = (iHashCode83 + (l16 == null ? 0 : l16.hashCode())) * 31;
            List<TrackFeatureFlagsForEvent> list5 = this.trackFeatureFlagsForEvents;
            int iHashCode85 = (iHashCode84 + (list5 == null ? 0 : list5.hashCode())) * 31;
            Boolean bool48 = this.trackAnonymousUser;
            int iHashCode86 = (iHashCode85 + (bool48 == null ? 0 : bool48.hashCode())) * 31;
            Boolean bool49 = this.useAllowedTrackingOrigins;
            int iHashCode87 = (iHashCode86 + (bool49 == null ? 0 : bool49.hashCode())) * 31;
            String str14 = this.sdkVersion;
            int iHashCode88 = (iHashCode87 + (str14 == null ? 0 : str14.hashCode())) * 31;
            String str15 = this.source;
            int iHashCode89 = (iHashCode88 + (str15 == null ? 0 : str15.hashCode())) * 31;
            String str16 = this.variant;
            int iHashCode90 = (iHashCode89 + (str16 == null ? 0 : str16.hashCode())) * 31;
            String str17 = this.remoteConfigurationId;
            int iHashCode91 = (iHashCode90 + (str17 == null ? 0 : str17.hashCode())) * 31;
            Boolean bool50 = this.useRemoteConfigurationProxy;
            int iHashCode92 = (iHashCode91 + (bool50 == null ? 0 : bool50.hashCode())) * 31;
            Number number = this.profilingSampleRate;
            int iHashCode93 = (iHashCode92 + (number == null ? 0 : number.hashCode())) * 31;
            Boolean bool51 = this.propagateTraceBaggage;
            int iHashCode94 = (iHashCode93 + (bool51 == null ? 0 : bool51.hashCode())) * 31;
            TrackResourceHeaders trackResourceHeaders = this.trackResourceHeaders;
            int iHashCode95 = (iHashCode94 + (trackResourceHeaders == null ? 0 : trackResourceHeaders.hashCode())) * 31;
            Boolean bool52 = this.betaEncodeCookieOptions;
            return iHashCode95 + (bool52 != null ? bool52.hashCode() : 0);
        }

        public String toString() {
            return "Configuration(sessionSampleRate=" + this.sessionSampleRate + ", telemetrySampleRate=" + this.telemetrySampleRate + ", telemetryConfigurationSampleRate=" + this.telemetryConfigurationSampleRate + ", telemetryUsageSampleRate=" + this.telemetryUsageSampleRate + ", traceSampleRate=" + this.traceSampleRate + ", traceContextInjection=" + this.traceContextInjection + ", premiumSampleRate=" + this.premiumSampleRate + ", replaySampleRate=" + this.replaySampleRate + ", sessionReplaySampleRate=" + this.sessionReplaySampleRate + ", trackingConsent=" + this.trackingConsent + ", startSessionReplayRecordingManually=" + this.startSessionReplayRecordingManually + ", startRecordingImmediately=" + this.startRecordingImmediately + ", useProxy=" + this.useProxy + ", useBeforeSend=" + this.useBeforeSend + ", silentMultipleInit=" + this.silentMultipleInit + ", trackSessionAcrossSubdomains=" + this.trackSessionAcrossSubdomains + ", trackResources=" + this.trackResources + ", trackEarlyRequests=" + this.trackEarlyRequests + ", trackLongTask=" + this.trackLongTask + ", trackBfcacheViews=" + this.trackBfcacheViews + ", useCrossSiteSessionCookie=" + this.useCrossSiteSessionCookie + ", usePartitionedCrossSiteSessionCookie=" + this.usePartitionedCrossSiteSessionCookie + ", useSecureSessionCookie=" + this.useSecureSessionCookie + ", allowFallbackToLocalStorage=" + this.allowFallbackToLocalStorage + ", sessionPersistence=" + this.sessionPersistence + ", storeContextsAcrossPages=" + this.storeContextsAcrossPages + ", allowUntrustedEvents=" + this.allowUntrustedEvents + ", actionNameAttribute=" + this.actionNameAttribute + ", useAllowedTracingOrigins=" + this.useAllowedTracingOrigins + ", useAllowedTracingUrls=" + this.useAllowedTracingUrls + ", useAllowedGraphQlUrls=" + this.useAllowedGraphQlUrls + ", useTrackGraphQlPayload=" + this.useTrackGraphQlPayload + ", useTrackGraphQlResponseErrors=" + this.useTrackGraphQlResponseErrors + ", selectedTracingPropagators=" + this.selectedTracingPropagators + ", defaultPrivacyLevel=" + this.defaultPrivacyLevel + ", textAndInputPrivacyLevel=" + this.textAndInputPrivacyLevel + ", imagePrivacyLevel=" + this.imagePrivacyLevel + ", touchPrivacyLevel=" + this.touchPrivacyLevel + ", enablePrivacyForActionName=" + this.enablePrivacyForActionName + ", useExcludedActivityUrls=" + this.useExcludedActivityUrls + ", useWorkerUrl=" + this.useWorkerUrl + ", compressIntakeRequests=" + this.compressIntakeRequests + ", trackFrustrations=" + this.trackFrustrations + ", trackViewsManually=" + this.trackViewsManually + ", trackInteractions=" + this.trackInteractions + ", trackUserInteractions=" + this.trackUserInteractions + ", forwardErrorsToLogs=" + this.forwardErrorsToLogs + ", numberOfDisplays=" + this.numberOfDisplays + ", forwardConsoleLogs=" + this.forwardConsoleLogs + ", forwardReports=" + this.forwardReports + ", useLocalEncryption=" + this.useLocalEncryption + ", viewTrackingStrategy=" + this.viewTrackingStrategy + ", swiftuiViewTrackingEnabled=" + this.swiftuiViewTrackingEnabled + ", swiftuiActionTrackingEnabled=" + this.swiftuiActionTrackingEnabled + ", trackBackgroundEvents=" + this.trackBackgroundEvents + ", mobileVitalsUpdatePeriod=" + this.mobileVitalsUpdatePeriod + ", trackErrors=" + this.trackErrors + ", trackNetworkRequests=" + this.trackNetworkRequests + ", useTracing=" + this.useTracing + ", trackNativeViews=" + this.trackNativeViews + ", trackNativeErrors=" + this.trackNativeErrors + ", trackNativeLongTasks=" + this.trackNativeLongTasks + ", trackCrossPlatformLongTasks=" + this.trackCrossPlatformLongTasks + ", useFirstPartyHosts=" + this.useFirstPartyHosts + ", initializationType=" + this.initializationType + ", trackFlutterPerformance=" + this.trackFlutterPerformance + ", batchSize=" + this.batchSize + ", batchUploadFrequency=" + this.batchUploadFrequency + ", batchProcessingLevel=" + this.batchProcessingLevel + ", backgroundTasksEnabled=" + this.backgroundTasksEnabled + ", reactVersion=" + this.reactVersion + ", reactNativeVersion=" + this.reactNativeVersion + ", dartVersion=" + this.dartVersion + ", unityVersion=" + this.unityVersion + ", mauiVersion=" + this.mauiVersion + ", appHangThreshold=" + this.appHangThreshold + ", usePciIntake=" + this.usePciIntake + ", tracerApi=" + this.tracerApi + ", tracerApiVersion=" + this.tracerApiVersion + ", sendLogsAfterSessionExpiration=" + this.sendLogsAfterSessionExpiration + ", plugins=" + this.plugins + ", isMainProcess=" + this.isMainProcess + ", invTimeThresholdMs=" + this.invTimeThresholdMs + ", tnsTimeThresholdMs=" + this.tnsTimeThresholdMs + ", trackFeatureFlagsForEvents=" + this.trackFeatureFlagsForEvents + ", trackAnonymousUser=" + this.trackAnonymousUser + ", useAllowedTrackingOrigins=" + this.useAllowedTrackingOrigins + ", sdkVersion=" + this.sdkVersion + ", source=" + this.source + ", variant=" + this.variant + ", remoteConfigurationId=" + this.remoteConfigurationId + ", useRemoteConfigurationProxy=" + this.useRemoteConfigurationProxy + ", profilingSampleRate=" + this.profilingSampleRate + ", propagateTraceBaggage=" + this.propagateTraceBaggage + ", trackResourceHeaders=" + this.trackResourceHeaders + ", betaEncodeCookieOptions=" + this.betaEncodeCookieOptions + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Configuration(Long l, Long l2, Long l3, Long l4, Long l5, TraceContextInjection traceContextInjection, Long l6, Long l7, Long l8, TrackingConsent trackingConsent, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, Boolean bool12, Boolean bool13, Boolean bool14, SessionPersistence sessionPersistence, Boolean bool15, Boolean bool16, String str, Boolean bool17, Boolean bool18, Boolean bool19, Boolean bool20, Boolean bool21, List<? extends SelectedTracingPropagator> list, String str2, String str3, String str4, String str5, Boolean bool22, Boolean bool23, Boolean bool24, Boolean bool25, Boolean bool26, Boolean bool27, Boolean bool28, Boolean bool29, Boolean bool30, Long l9, List<String> list2, List<String> list3, Boolean bool31, ViewTrackingStrategy viewTrackingStrategy, Boolean bool32, Boolean bool33, Boolean bool34, Long l10, Boolean bool35, Boolean bool36, Boolean bool37, Boolean bool38, Boolean bool39, Boolean bool40, Boolean bool41, Boolean bool42, String str6, Boolean bool43, Long l11, Long l12, Long l13, Boolean bool44, String str7, String str8, String str9, String str10, String str11, Long l14, Boolean bool45, String str12, String str13, Boolean bool46, List<Plugin> list4, Boolean bool47, Long l15, Long l16, List<? extends TrackFeatureFlagsForEvent> list5, Boolean bool48, Boolean bool49, String str14, String str15, String str16, String str17, Boolean bool50, Number number, Boolean bool51, TrackResourceHeaders trackResourceHeaders, Boolean bool52) {
            this.sessionSampleRate = l;
            this.telemetrySampleRate = l2;
            this.telemetryConfigurationSampleRate = l3;
            this.telemetryUsageSampleRate = l4;
            this.traceSampleRate = l5;
            this.traceContextInjection = traceContextInjection;
            this.premiumSampleRate = l6;
            this.replaySampleRate = l7;
            this.sessionReplaySampleRate = l8;
            this.trackingConsent = trackingConsent;
            this.startSessionReplayRecordingManually = bool;
            this.startRecordingImmediately = bool2;
            this.useProxy = bool3;
            this.useBeforeSend = bool4;
            this.silentMultipleInit = bool5;
            this.trackSessionAcrossSubdomains = bool6;
            this.trackResources = bool7;
            this.trackEarlyRequests = bool8;
            this.trackLongTask = bool9;
            this.trackBfcacheViews = bool10;
            this.useCrossSiteSessionCookie = bool11;
            this.usePartitionedCrossSiteSessionCookie = bool12;
            this.useSecureSessionCookie = bool13;
            this.allowFallbackToLocalStorage = bool14;
            this.sessionPersistence = sessionPersistence;
            this.storeContextsAcrossPages = bool15;
            this.allowUntrustedEvents = bool16;
            this.actionNameAttribute = str;
            this.useAllowedTracingOrigins = bool17;
            this.useAllowedTracingUrls = bool18;
            this.useAllowedGraphQlUrls = bool19;
            this.useTrackGraphQlPayload = bool20;
            this.useTrackGraphQlResponseErrors = bool21;
            this.selectedTracingPropagators = list;
            this.defaultPrivacyLevel = str2;
            this.textAndInputPrivacyLevel = str3;
            this.imagePrivacyLevel = str4;
            this.touchPrivacyLevel = str5;
            this.enablePrivacyForActionName = bool22;
            this.useExcludedActivityUrls = bool23;
            this.useWorkerUrl = bool24;
            this.compressIntakeRequests = bool25;
            this.trackFrustrations = bool26;
            this.trackViewsManually = bool27;
            this.trackInteractions = bool28;
            this.trackUserInteractions = bool29;
            this.forwardErrorsToLogs = bool30;
            this.numberOfDisplays = l9;
            this.forwardConsoleLogs = list2;
            this.forwardReports = list3;
            this.useLocalEncryption = bool31;
            this.viewTrackingStrategy = viewTrackingStrategy;
            this.swiftuiViewTrackingEnabled = bool32;
            this.swiftuiActionTrackingEnabled = bool33;
            this.trackBackgroundEvents = bool34;
            this.mobileVitalsUpdatePeriod = l10;
            this.trackErrors = bool35;
            this.trackNetworkRequests = bool36;
            this.useTracing = bool37;
            this.trackNativeViews = bool38;
            this.trackNativeErrors = bool39;
            this.trackNativeLongTasks = bool40;
            this.trackCrossPlatformLongTasks = bool41;
            this.useFirstPartyHosts = bool42;
            this.initializationType = str6;
            this.trackFlutterPerformance = bool43;
            this.batchSize = l11;
            this.batchUploadFrequency = l12;
            this.batchProcessingLevel = l13;
            this.backgroundTasksEnabled = bool44;
            this.reactVersion = str7;
            this.reactNativeVersion = str8;
            this.dartVersion = str9;
            this.unityVersion = str10;
            this.mauiVersion = str11;
            this.appHangThreshold = l14;
            this.usePciIntake = bool45;
            this.tracerApi = str12;
            this.tracerApiVersion = str13;
            this.sendLogsAfterSessionExpiration = bool46;
            this.plugins = list4;
            this.isMainProcess = bool47;
            this.invTimeThresholdMs = l15;
            this.tnsTimeThresholdMs = l16;
            this.trackFeatureFlagsForEvents = list5;
            this.trackAnonymousUser = bool48;
            this.useAllowedTrackingOrigins = bool49;
            this.sdkVersion = str14;
            this.source = str15;
            this.variant = str16;
            this.remoteConfigurationId = str17;
            this.useRemoteConfigurationProxy = bool50;
            this.profilingSampleRate = number;
            this.propagateTraceBaggage = bool51;
            this.trackResourceHeaders = trackResourceHeaders;
            this.betaEncodeCookieOptions = bool52;
        }

        public final Long getSessionSampleRate() {
            return this.sessionSampleRate;
        }

        public final Long getTelemetrySampleRate() {
            return this.telemetrySampleRate;
        }

        public final Long getTelemetryConfigurationSampleRate() {
            return this.telemetryConfigurationSampleRate;
        }

        public final Long getTelemetryUsageSampleRate() {
            return this.telemetryUsageSampleRate;
        }

        public final Long getTraceSampleRate() {
            return this.traceSampleRate;
        }

        public final TraceContextInjection getTraceContextInjection() {
            return this.traceContextInjection;
        }

        public final void setTraceContextInjection(TraceContextInjection traceContextInjection) {
            this.traceContextInjection = traceContextInjection;
        }

        public final Long getPremiumSampleRate() {
            return this.premiumSampleRate;
        }

        public final Long getReplaySampleRate() {
            return this.replaySampleRate;
        }

        public final Long getSessionReplaySampleRate() {
            return this.sessionReplaySampleRate;
        }

        public final void setSessionReplaySampleRate(Long l) {
            this.sessionReplaySampleRate = l;
        }

        public final TrackingConsent getTrackingConsent() {
            return this.trackingConsent;
        }

        public final Boolean getStartSessionReplayRecordingManually() {
            return this.startSessionReplayRecordingManually;
        }

        public final void setStartSessionReplayRecordingManually(Boolean bool) {
            this.startSessionReplayRecordingManually = bool;
        }

        public final Boolean getStartRecordingImmediately() {
            return this.startRecordingImmediately;
        }

        public final void setStartRecordingImmediately(Boolean bool) {
            this.startRecordingImmediately = bool;
        }

        public final Boolean getUseProxy() {
            return this.useProxy;
        }

        public final void setUseProxy(Boolean bool) {
            this.useProxy = bool;
        }

        public final Boolean getUseBeforeSend() {
            return this.useBeforeSend;
        }

        public final Boolean getSilentMultipleInit() {
            return this.silentMultipleInit;
        }

        public final Boolean getTrackSessionAcrossSubdomains() {
            return this.trackSessionAcrossSubdomains;
        }

        public final Boolean getTrackResources() {
            return this.trackResources;
        }

        public final void setTrackResources(Boolean bool) {
            this.trackResources = bool;
        }

        public final Boolean getTrackEarlyRequests() {
            return this.trackEarlyRequests;
        }

        public final void setTrackEarlyRequests(Boolean bool) {
            this.trackEarlyRequests = bool;
        }

        public final Boolean getTrackLongTask() {
            return this.trackLongTask;
        }

        public final void setTrackLongTask(Boolean bool) {
            this.trackLongTask = bool;
        }

        public final Boolean getTrackBfcacheViews() {
            return this.trackBfcacheViews;
        }

        public final void setTrackBfcacheViews(Boolean bool) {
            this.trackBfcacheViews = bool;
        }

        public final Boolean getUseCrossSiteSessionCookie() {
            return this.useCrossSiteSessionCookie;
        }

        public final Boolean getUsePartitionedCrossSiteSessionCookie() {
            return this.usePartitionedCrossSiteSessionCookie;
        }

        public final Boolean getUseSecureSessionCookie() {
            return this.useSecureSessionCookie;
        }

        public final Boolean getAllowFallbackToLocalStorage() {
            return this.allowFallbackToLocalStorage;
        }

        public final SessionPersistence getSessionPersistence() {
            return this.sessionPersistence;
        }

        public final Boolean getStoreContextsAcrossPages() {
            return this.storeContextsAcrossPages;
        }

        public final Boolean getAllowUntrustedEvents() {
            return this.allowUntrustedEvents;
        }

        public final String getActionNameAttribute() {
            return this.actionNameAttribute;
        }

        public final Boolean getUseAllowedTracingOrigins() {
            return this.useAllowedTracingOrigins;
        }

        public final Boolean getUseAllowedTracingUrls() {
            return this.useAllowedTracingUrls;
        }

        public final Boolean getUseAllowedGraphQlUrls() {
            return this.useAllowedGraphQlUrls;
        }

        public final Boolean getUseTrackGraphQlPayload() {
            return this.useTrackGraphQlPayload;
        }

        public final Boolean getUseTrackGraphQlResponseErrors() {
            return this.useTrackGraphQlResponseErrors;
        }

        public final List<SelectedTracingPropagator> getSelectedTracingPropagators() {
            return this.selectedTracingPropagators;
        }

        public final String getDefaultPrivacyLevel() {
            return this.defaultPrivacyLevel;
        }

        public final void setDefaultPrivacyLevel(String str) {
            this.defaultPrivacyLevel = str;
        }

        public final String getTextAndInputPrivacyLevel() {
            return this.textAndInputPrivacyLevel;
        }

        public final void setTextAndInputPrivacyLevel(String str) {
            this.textAndInputPrivacyLevel = str;
        }

        public final String getImagePrivacyLevel() {
            return this.imagePrivacyLevel;
        }

        public final void setImagePrivacyLevel(String str) {
            this.imagePrivacyLevel = str;
        }

        public final String getTouchPrivacyLevel() {
            return this.touchPrivacyLevel;
        }

        public final void setTouchPrivacyLevel(String str) {
            this.touchPrivacyLevel = str;
        }

        public final Boolean getEnablePrivacyForActionName() {
            return this.enablePrivacyForActionName;
        }

        public final void setEnablePrivacyForActionName(Boolean bool) {
            this.enablePrivacyForActionName = bool;
        }

        public final Boolean getUseExcludedActivityUrls() {
            return this.useExcludedActivityUrls;
        }

        public final Boolean getUseWorkerUrl() {
            return this.useWorkerUrl;
        }

        public final Boolean getCompressIntakeRequests() {
            return this.compressIntakeRequests;
        }

        public final Boolean getTrackFrustrations() {
            return this.trackFrustrations;
        }

        public final void setTrackFrustrations(Boolean bool) {
            this.trackFrustrations = bool;
        }

        public final Boolean getTrackViewsManually() {
            return this.trackViewsManually;
        }

        public final void setTrackViewsManually(Boolean bool) {
            this.trackViewsManually = bool;
        }

        public final Boolean getTrackInteractions() {
            return this.trackInteractions;
        }

        public final void setTrackInteractions(Boolean bool) {
            this.trackInteractions = bool;
        }

        public final Boolean getTrackUserInteractions() {
            return this.trackUserInteractions;
        }

        public final void setTrackUserInteractions(Boolean bool) {
            this.trackUserInteractions = bool;
        }

        public final Boolean getForwardErrorsToLogs() {
            return this.forwardErrorsToLogs;
        }

        public final Long getNumberOfDisplays() {
            return this.numberOfDisplays;
        }

        public final List<String> getForwardConsoleLogs() {
            return this.forwardConsoleLogs;
        }

        public final List<String> getForwardReports() {
            return this.forwardReports;
        }

        public final Boolean getUseLocalEncryption() {
            return this.useLocalEncryption;
        }

        public final ViewTrackingStrategy getViewTrackingStrategy() {
            return this.viewTrackingStrategy;
        }

        public final Boolean getSwiftuiViewTrackingEnabled() {
            return this.swiftuiViewTrackingEnabled;
        }

        public final void setSwiftuiViewTrackingEnabled(Boolean bool) {
            this.swiftuiViewTrackingEnabled = bool;
        }

        public final Boolean getSwiftuiActionTrackingEnabled() {
            return this.swiftuiActionTrackingEnabled;
        }

        public final void setSwiftuiActionTrackingEnabled(Boolean bool) {
            this.swiftuiActionTrackingEnabled = bool;
        }

        public final Boolean getTrackBackgroundEvents() {
            return this.trackBackgroundEvents;
        }

        public final void setTrackBackgroundEvents(Boolean bool) {
            this.trackBackgroundEvents = bool;
        }

        public final Long getMobileVitalsUpdatePeriod() {
            return this.mobileVitalsUpdatePeriod;
        }

        public final void setMobileVitalsUpdatePeriod(Long l) {
            this.mobileVitalsUpdatePeriod = l;
        }

        public final Boolean getTrackErrors() {
            return this.trackErrors;
        }

        public final void setTrackErrors(Boolean bool) {
            this.trackErrors = bool;
        }

        public final Boolean getTrackNetworkRequests() {
            return this.trackNetworkRequests;
        }

        public final void setTrackNetworkRequests(Boolean bool) {
            this.trackNetworkRequests = bool;
        }

        public final Boolean getUseTracing() {
            return this.useTracing;
        }

        public final Boolean getTrackNativeViews() {
            return this.trackNativeViews;
        }

        public final void setTrackNativeViews(Boolean bool) {
            this.trackNativeViews = bool;
        }

        public final Boolean getTrackNativeErrors() {
            return this.trackNativeErrors;
        }

        public final void setTrackNativeErrors(Boolean bool) {
            this.trackNativeErrors = bool;
        }

        public final Boolean getTrackNativeLongTasks() {
            return this.trackNativeLongTasks;
        }

        public final void setTrackNativeLongTasks(Boolean bool) {
            this.trackNativeLongTasks = bool;
        }

        public final Boolean getTrackCrossPlatformLongTasks() {
            return this.trackCrossPlatformLongTasks;
        }

        public final void setTrackCrossPlatformLongTasks(Boolean bool) {
            this.trackCrossPlatformLongTasks = bool;
        }

        public final Boolean getUseFirstPartyHosts() {
            return this.useFirstPartyHosts;
        }

        public final void setUseFirstPartyHosts(Boolean bool) {
            this.useFirstPartyHosts = bool;
        }

        public final String getInitializationType() {
            return this.initializationType;
        }

        public final void setInitializationType(String str) {
            this.initializationType = str;
        }

        public final Boolean getTrackFlutterPerformance() {
            return this.trackFlutterPerformance;
        }

        public final void setTrackFlutterPerformance(Boolean bool) {
            this.trackFlutterPerformance = bool;
        }

        public final Long getBatchSize() {
            return this.batchSize;
        }

        public final Long getBatchUploadFrequency() {
            return this.batchUploadFrequency;
        }

        public final Long getBatchProcessingLevel() {
            return this.batchProcessingLevel;
        }

        public final Boolean getBackgroundTasksEnabled() {
            return this.backgroundTasksEnabled;
        }

        public final String getReactVersion() {
            return this.reactVersion;
        }

        public final void setReactVersion(String str) {
            this.reactVersion = str;
        }

        public final String getReactNativeVersion() {
            return this.reactNativeVersion;
        }

        public final void setReactNativeVersion(String str) {
            this.reactNativeVersion = str;
        }

        public final String getDartVersion() {
            return this.dartVersion;
        }

        public final void setDartVersion(String str) {
            this.dartVersion = str;
        }

        public final String getUnityVersion() {
            return this.unityVersion;
        }

        public final void setUnityVersion(String str) {
            this.unityVersion = str;
        }

        public final String getMauiVersion() {
            return this.mauiVersion;
        }

        public final void setMauiVersion(String str) {
            this.mauiVersion = str;
        }

        public final Long getAppHangThreshold() {
            return this.appHangThreshold;
        }

        public final Boolean getUsePciIntake() {
            return this.usePciIntake;
        }

        public final void setUsePciIntake(Boolean bool) {
            this.usePciIntake = bool;
        }

        public final String getTracerApi() {
            return this.tracerApi;
        }

        public final void setTracerApi(String str) {
            this.tracerApi = str;
        }

        public final String getTracerApiVersion() {
            return this.tracerApiVersion;
        }

        public final void setTracerApiVersion(String str) {
            this.tracerApiVersion = str;
        }

        public final Boolean getSendLogsAfterSessionExpiration() {
            return this.sendLogsAfterSessionExpiration;
        }

        public final void setSendLogsAfterSessionExpiration(Boolean bool) {
            this.sendLogsAfterSessionExpiration = bool;
        }

        public final List<Plugin> getPlugins() {
            return this.plugins;
        }

        public final Boolean isMainProcess() {
            return this.isMainProcess;
        }

        public final Long getInvTimeThresholdMs() {
            return this.invTimeThresholdMs;
        }

        public final Long getTnsTimeThresholdMs() {
            return this.tnsTimeThresholdMs;
        }

        public final List<TrackFeatureFlagsForEvent> getTrackFeatureFlagsForEvents() {
            return this.trackFeatureFlagsForEvents;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Configuration(Long l, Long l2, Long l3, Long l4, Long l5, TraceContextInjection traceContextInjection, Long l6, Long l7, Long l8, TrackingConsent trackingConsent, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, Boolean bool12, Boolean bool13, Boolean bool14, SessionPersistence sessionPersistence, Boolean bool15, Boolean bool16, String str, Boolean bool17, Boolean bool18, Boolean bool19, Boolean bool20, Boolean bool21, List list, String str2, String str3, String str4, String str5, Boolean bool22, Boolean bool23, Boolean bool24, Boolean bool25, Boolean bool26, Boolean bool27, Boolean bool28, Boolean bool29, Boolean bool30, Long l9, List list2, List list3, Boolean bool31, ViewTrackingStrategy viewTrackingStrategy, Boolean bool32, Boolean bool33, Boolean bool34, Long l10, Boolean bool35, Boolean bool36, Boolean bool37, Boolean bool38, Boolean bool39, Boolean bool40, Boolean bool41, Boolean bool42, String str6, Boolean bool43, Long l11, Long l12, Long l13, Boolean bool44, String str7, String str8, String str9, String str10, String str11, Long l14, Boolean bool45, String str12, String str13, Boolean bool46, List list4, Boolean bool47, Long l15, Long l16, List list5, Boolean bool48, Boolean bool49, String str14, String str15, String str16, String str17, Boolean bool50, Number number, Boolean bool51, TrackResourceHeaders trackResourceHeaders, Boolean bool52, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            Long l17 = (i & 1) != 0 ? null : l;
            Long l18 = (i & 2) != 0 ? null : l2;
            Long l19 = (i & 4) != 0 ? null : l3;
            Long l20 = (i & 8) != 0 ? null : l4;
            Long l21 = (i & 16) != 0 ? null : l5;
            TraceContextInjection traceContextInjection2 = (i & 32) != 0 ? null : traceContextInjection;
            Long l22 = (i & 64) != 0 ? null : l6;
            Long l23 = (i & 128) != 0 ? null : l7;
            Long l24 = (i & 256) != 0 ? null : l8;
            TrackingConsent trackingConsent2 = (i & 512) != 0 ? null : trackingConsent;
            Boolean bool53 = (i & 1024) != 0 ? null : bool;
            Boolean bool54 = (i & 2048) != 0 ? null : bool2;
            Boolean bool55 = (i & 4096) != 0 ? null : bool3;
            Long l25 = l17;
            Boolean bool56 = (i & 8192) != 0 ? null : bool4;
            Boolean bool57 = (i & 16384) != 0 ? null : bool5;
            Boolean bool58 = (i & 32768) != 0 ? null : bool6;
            Boolean bool59 = (i & 65536) != 0 ? null : bool7;
            Boolean bool60 = (i & 131072) != 0 ? null : bool8;
            Boolean bool61 = (i & 262144) != 0 ? null : bool9;
            Boolean bool62 = (i & 524288) != 0 ? null : bool10;
            Boolean bool63 = (i & 1048576) != 0 ? null : bool11;
            Boolean bool64 = (i & 2097152) != 0 ? null : bool12;
            Boolean bool65 = (i & 4194304) != 0 ? null : bool13;
            Boolean bool66 = (i & 8388608) != 0 ? null : bool14;
            SessionPersistence sessionPersistence2 = (i & 16777216) != 0 ? null : sessionPersistence;
            Boolean bool67 = (i & GroupFlagsKt.HasAuxSlotFlag) != 0 ? null : bool15;
            Boolean bool68 = (i & 67108864) != 0 ? null : bool16;
            String str18 = (i & 134217728) != 0 ? null : str;
            Boolean bool69 = (i & 268435456) != 0 ? null : bool17;
            Boolean bool70 = (i & 536870912) != 0 ? null : bool18;
            Boolean bool71 = (i & 1073741824) != 0 ? null : bool19;
            Boolean bool72 = (i & Integer.MIN_VALUE) != 0 ? null : bool20;
            Boolean bool73 = (i2 & 1) != 0 ? null : bool21;
            List list6 = (i2 & 2) != 0 ? null : list;
            String str19 = (i2 & 4) != 0 ? null : str2;
            String str20 = (i2 & 8) != 0 ? null : str3;
            String str21 = (i2 & 16) != 0 ? null : str4;
            String str22 = (i2 & 32) != 0 ? null : str5;
            Boolean bool74 = (i2 & 64) != 0 ? null : bool22;
            Boolean bool75 = bool72;
            Boolean bool76 = (i2 & 128) != 0 ? null : bool23;
            Boolean bool77 = (i2 & 256) != 0 ? null : bool24;
            Boolean bool78 = (i2 & 512) != 0 ? null : bool25;
            Boolean bool79 = (i2 & 1024) != 0 ? null : bool26;
            Boolean bool80 = (i2 & 2048) != 0 ? null : bool27;
            Boolean bool81 = (i2 & 4096) != 0 ? null : bool28;
            Boolean bool82 = (i2 & 8192) != 0 ? null : bool29;
            Boolean bool83 = (i2 & 16384) != 0 ? null : bool30;
            Long l26 = (i2 & 32768) != 0 ? null : l9;
            List list7 = (i2 & 65536) != 0 ? null : list2;
            List list8 = (i2 & 131072) != 0 ? null : list3;
            Boolean bool84 = (i2 & 262144) != 0 ? null : bool31;
            ViewTrackingStrategy viewTrackingStrategy2 = (i2 & 524288) != 0 ? null : viewTrackingStrategy;
            Boolean bool85 = (i2 & 1048576) != 0 ? null : bool32;
            Boolean bool86 = (i2 & 2097152) != 0 ? null : bool33;
            Boolean bool87 = (i2 & 4194304) != 0 ? null : bool34;
            Long l27 = (i2 & 8388608) != 0 ? null : l10;
            Boolean bool88 = (i2 & 16777216) != 0 ? null : bool35;
            Boolean bool89 = (i2 & GroupFlagsKt.HasAuxSlotFlag) != 0 ? null : bool36;
            Boolean bool90 = (i2 & 67108864) != 0 ? null : bool37;
            Boolean bool91 = (i2 & 134217728) != 0 ? null : bool38;
            Boolean bool92 = (i2 & 268435456) != 0 ? null : bool39;
            Boolean bool93 = (i2 & 536870912) != 0 ? null : bool40;
            Boolean bool94 = (i2 & 1073741824) != 0 ? null : bool41;
            Boolean bool95 = (i2 & Integer.MIN_VALUE) != 0 ? null : bool42;
            Boolean bool96 = bool55;
            Long l28 = l18;
            Long l29 = l19;
            Long l30 = l20;
            Long l31 = l21;
            TraceContextInjection traceContextInjection3 = traceContextInjection2;
            Long l32 = l22;
            Long l33 = l23;
            Long l34 = l24;
            TrackingConsent trackingConsent3 = trackingConsent2;
            Boolean bool97 = bool53;
            Boolean bool98 = bool54;
            this(l25, l28, l29, l30, l31, traceContextInjection3, l32, l33, l34, trackingConsent3, bool97, bool98, bool96, bool56, bool57, bool58, bool59, bool60, bool61, bool62, bool63, bool64, bool65, bool66, sessionPersistence2, bool67, bool68, str18, bool69, bool70, bool71, bool75, bool73, list6, str19, str20, str21, str22, bool74, bool76, bool77, bool78, bool79, bool80, bool81, bool82, bool83, l26, list7, list8, bool84, viewTrackingStrategy2, bool85, bool86, bool87, l27, bool88, bool89, bool90, bool91, bool92, bool93, bool94, bool95, (i3 & 1) != 0 ? null : str6, (i3 & 2) != 0 ? null : bool43, (i3 & 4) != 0 ? null : l11, (i3 & 8) != 0 ? null : l12, (i3 & 16) != 0 ? null : l13, (i3 & 32) != 0 ? null : bool44, (i3 & 64) != 0 ? null : str7, (i3 & 128) != 0 ? null : str8, (i3 & 256) != 0 ? null : str9, (i3 & 512) != 0 ? null : str10, (i3 & 1024) != 0 ? null : str11, (i3 & 2048) != 0 ? null : l14, (i3 & 4096) != 0 ? null : bool45, (i3 & 8192) != 0 ? null : str12, (i3 & 16384) != 0 ? null : str13, (i3 & 32768) != 0 ? null : bool46, (i3 & 65536) != 0 ? null : list4, (i3 & 131072) != 0 ? null : bool47, (i3 & 262144) != 0 ? null : l15, (i3 & 524288) != 0 ? null : l16, (i3 & 1048576) != 0 ? null : list5, (i3 & 2097152) != 0 ? true : bool48, (i3 & 4194304) != 0 ? false : bool49, (i3 & 8388608) != 0 ? null : str14, (i3 & 16777216) != 0 ? null : str15, (i3 & GroupFlagsKt.HasAuxSlotFlag) != 0 ? null : str16, (i3 & 67108864) != 0 ? null : str17, (i3 & 134217728) != 0 ? null : bool50, (i3 & 268435456) != 0 ? null : number, (i3 & 536870912) != 0 ? null : bool51, (i3 & 1073741824) != 0 ? null : trackResourceHeaders, (i3 & Integer.MIN_VALUE) != 0 ? null : bool52);
        }

        public final Boolean getTrackAnonymousUser() {
            return this.trackAnonymousUser;
        }

        public final void setTrackAnonymousUser(Boolean bool) {
            this.trackAnonymousUser = bool;
        }

        public final Boolean getUseAllowedTrackingOrigins() {
            return this.useAllowedTrackingOrigins;
        }

        public final void setUseAllowedTrackingOrigins(Boolean bool) {
            this.useAllowedTrackingOrigins = bool;
        }

        public final String getSdkVersion() {
            return this.sdkVersion;
        }

        public final void setSdkVersion(String str) {
            this.sdkVersion = str;
        }

        public final String getSource() {
            return this.source;
        }

        public final void setSource(String str) {
            this.source = str;
        }

        public final String getVariant() {
            return this.variant;
        }

        public final void setVariant(String str) {
            this.variant = str;
        }

        public final String getRemoteConfigurationId() {
            return this.remoteConfigurationId;
        }

        public final void setRemoteConfigurationId(String str) {
            this.remoteConfigurationId = str;
        }

        public final Boolean getUseRemoteConfigurationProxy() {
            return this.useRemoteConfigurationProxy;
        }

        public final void setUseRemoteConfigurationProxy(Boolean bool) {
            this.useRemoteConfigurationProxy = bool;
        }

        public final Number getProfilingSampleRate() {
            return this.profilingSampleRate;
        }

        public final void setProfilingSampleRate(Number number) {
            this.profilingSampleRate = number;
        }

        public final Boolean getPropagateTraceBaggage() {
            return this.propagateTraceBaggage;
        }

        public final void setPropagateTraceBaggage(Boolean bool) {
            this.propagateTraceBaggage = bool;
        }

        public final TrackResourceHeaders getTrackResourceHeaders() {
            return this.trackResourceHeaders;
        }

        public final void setTrackResourceHeaders(TrackResourceHeaders trackResourceHeaders) {
            this.trackResourceHeaders = trackResourceHeaders;
        }

        public final Boolean getBetaEncodeCookieOptions() {
            return this.betaEncodeCookieOptions;
        }

        public final void setBetaEncodeCookieOptions(Boolean bool) {
            this.betaEncodeCookieOptions = bool;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            Long l = this.sessionSampleRate;
            if (l != null) {
                jsonObject.addProperty("session_sample_rate", Long.valueOf(l.longValue()));
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            }
            Long l2 = this.telemetrySampleRate;
            if (l2 != null) {
                jsonObject.addProperty("telemetry_sample_rate", Long.valueOf(l2.longValue()));
                Unit unit3 = Unit.INSTANCE;
                Unit unit4 = Unit.INSTANCE;
            }
            Long l3 = this.telemetryConfigurationSampleRate;
            if (l3 != null) {
                jsonObject.addProperty("telemetry_configuration_sample_rate", Long.valueOf(l3.longValue()));
                Unit unit5 = Unit.INSTANCE;
                Unit unit6 = Unit.INSTANCE;
            }
            Long l4 = this.telemetryUsageSampleRate;
            if (l4 != null) {
                jsonObject.addProperty("telemetry_usage_sample_rate", Long.valueOf(l4.longValue()));
                Unit unit7 = Unit.INSTANCE;
                Unit unit8 = Unit.INSTANCE;
            }
            Long l5 = this.traceSampleRate;
            if (l5 != null) {
                jsonObject.addProperty("trace_sample_rate", Long.valueOf(l5.longValue()));
                Unit unit9 = Unit.INSTANCE;
                Unit unit10 = Unit.INSTANCE;
            }
            TraceContextInjection traceContextInjection = this.traceContextInjection;
            if (traceContextInjection != null) {
                jsonObject.add("trace_context_injection", traceContextInjection.toJson());
                Unit unit11 = Unit.INSTANCE;
                Unit unit12 = Unit.INSTANCE;
            }
            Long l6 = this.premiumSampleRate;
            if (l6 != null) {
                jsonObject.addProperty("premium_sample_rate", Long.valueOf(l6.longValue()));
                Unit unit13 = Unit.INSTANCE;
                Unit unit14 = Unit.INSTANCE;
            }
            Long l7 = this.replaySampleRate;
            if (l7 != null) {
                jsonObject.addProperty("replay_sample_rate", Long.valueOf(l7.longValue()));
                Unit unit15 = Unit.INSTANCE;
                Unit unit16 = Unit.INSTANCE;
            }
            Long l8 = this.sessionReplaySampleRate;
            if (l8 != null) {
                jsonObject.addProperty("session_replay_sample_rate", Long.valueOf(l8.longValue()));
                Unit unit17 = Unit.INSTANCE;
                Unit unit18 = Unit.INSTANCE;
            }
            TrackingConsent trackingConsent = this.trackingConsent;
            if (trackingConsent != null) {
                jsonObject.add("tracking_consent", trackingConsent.toJson());
                Unit unit19 = Unit.INSTANCE;
                Unit unit20 = Unit.INSTANCE;
            }
            Boolean bool = this.startSessionReplayRecordingManually;
            if (bool != null) {
                bool.booleanValue();
                jsonObject.addProperty("start_session_replay_recording_manually", bool);
                Unit unit21 = Unit.INSTANCE;
                Unit unit22 = Unit.INSTANCE;
            }
            Boolean bool2 = this.startRecordingImmediately;
            if (bool2 != null) {
                bool2.booleanValue();
                jsonObject.addProperty("start_recording_immediately", bool2);
                Unit unit23 = Unit.INSTANCE;
                Unit unit24 = Unit.INSTANCE;
            }
            Boolean bool3 = this.useProxy;
            if (bool3 != null) {
                bool3.booleanValue();
                jsonObject.addProperty("use_proxy", bool3);
                Unit unit25 = Unit.INSTANCE;
                Unit unit26 = Unit.INSTANCE;
            }
            Boolean bool4 = this.useBeforeSend;
            if (bool4 != null) {
                bool4.booleanValue();
                jsonObject.addProperty("use_before_send", bool4);
                Unit unit27 = Unit.INSTANCE;
                Unit unit28 = Unit.INSTANCE;
            }
            Boolean bool5 = this.silentMultipleInit;
            if (bool5 != null) {
                bool5.booleanValue();
                jsonObject.addProperty("silent_multiple_init", bool5);
                Unit unit29 = Unit.INSTANCE;
                Unit unit30 = Unit.INSTANCE;
            }
            Boolean bool6 = this.trackSessionAcrossSubdomains;
            if (bool6 != null) {
                bool6.booleanValue();
                jsonObject.addProperty("track_session_across_subdomains", bool6);
                Unit unit31 = Unit.INSTANCE;
                Unit unit32 = Unit.INSTANCE;
            }
            Boolean bool7 = this.trackResources;
            if (bool7 != null) {
                bool7.booleanValue();
                jsonObject.addProperty("track_resources", bool7);
                Unit unit33 = Unit.INSTANCE;
                Unit unit34 = Unit.INSTANCE;
            }
            Boolean bool8 = this.trackEarlyRequests;
            if (bool8 != null) {
                bool8.booleanValue();
                jsonObject.addProperty("track_early_requests", bool8);
                Unit unit35 = Unit.INSTANCE;
                Unit unit36 = Unit.INSTANCE;
            }
            Boolean bool9 = this.trackLongTask;
            if (bool9 != null) {
                bool9.booleanValue();
                jsonObject.addProperty("track_long_task", bool9);
                Unit unit37 = Unit.INSTANCE;
                Unit unit38 = Unit.INSTANCE;
            }
            Boolean bool10 = this.trackBfcacheViews;
            if (bool10 != null) {
                bool10.booleanValue();
                jsonObject.addProperty("track_bfcache_views", bool10);
                Unit unit39 = Unit.INSTANCE;
                Unit unit40 = Unit.INSTANCE;
            }
            Boolean bool11 = this.useCrossSiteSessionCookie;
            if (bool11 != null) {
                bool11.booleanValue();
                jsonObject.addProperty("use_cross_site_session_cookie", bool11);
                Unit unit41 = Unit.INSTANCE;
                Unit unit42 = Unit.INSTANCE;
            }
            Boolean bool12 = this.usePartitionedCrossSiteSessionCookie;
            if (bool12 != null) {
                bool12.booleanValue();
                jsonObject.addProperty("use_partitioned_cross_site_session_cookie", bool12);
                Unit unit43 = Unit.INSTANCE;
                Unit unit44 = Unit.INSTANCE;
            }
            Boolean bool13 = this.useSecureSessionCookie;
            if (bool13 != null) {
                bool13.booleanValue();
                jsonObject.addProperty("use_secure_session_cookie", bool13);
                Unit unit45 = Unit.INSTANCE;
                Unit unit46 = Unit.INSTANCE;
            }
            Boolean bool14 = this.allowFallbackToLocalStorage;
            if (bool14 != null) {
                bool14.booleanValue();
                jsonObject.addProperty("allow_fallback_to_local_storage", bool14);
                Unit unit47 = Unit.INSTANCE;
                Unit unit48 = Unit.INSTANCE;
            }
            SessionPersistence sessionPersistence = this.sessionPersistence;
            if (sessionPersistence != null) {
                jsonObject.add("session_persistence", sessionPersistence.toJson());
                Unit unit49 = Unit.INSTANCE;
                Unit unit50 = Unit.INSTANCE;
            }
            Boolean bool15 = this.storeContextsAcrossPages;
            if (bool15 != null) {
                bool15.booleanValue();
                jsonObject.addProperty("store_contexts_across_pages", bool15);
                Unit unit51 = Unit.INSTANCE;
                Unit unit52 = Unit.INSTANCE;
            }
            Boolean bool16 = this.allowUntrustedEvents;
            if (bool16 != null) {
                bool16.booleanValue();
                jsonObject.addProperty("allow_untrusted_events", bool16);
                Unit unit53 = Unit.INSTANCE;
                Unit unit54 = Unit.INSTANCE;
            }
            String str = this.actionNameAttribute;
            if (str != null) {
                jsonObject.addProperty("action_name_attribute", str);
                Unit unit55 = Unit.INSTANCE;
                Unit unit56 = Unit.INSTANCE;
            }
            Boolean bool17 = this.useAllowedTracingOrigins;
            if (bool17 != null) {
                bool17.booleanValue();
                jsonObject.addProperty("use_allowed_tracing_origins", bool17);
                Unit unit57 = Unit.INSTANCE;
                Unit unit58 = Unit.INSTANCE;
            }
            Boolean bool18 = this.useAllowedTracingUrls;
            if (bool18 != null) {
                bool18.booleanValue();
                jsonObject.addProperty("use_allowed_tracing_urls", bool18);
                Unit unit59 = Unit.INSTANCE;
                Unit unit60 = Unit.INSTANCE;
            }
            Boolean bool19 = this.useAllowedGraphQlUrls;
            if (bool19 != null) {
                bool19.booleanValue();
                jsonObject.addProperty("use_allowed_graph_ql_urls", bool19);
                Unit unit61 = Unit.INSTANCE;
                Unit unit62 = Unit.INSTANCE;
            }
            Boolean bool20 = this.useTrackGraphQlPayload;
            if (bool20 != null) {
                bool20.booleanValue();
                jsonObject.addProperty("use_track_graph_ql_payload", bool20);
                Unit unit63 = Unit.INSTANCE;
                Unit unit64 = Unit.INSTANCE;
            }
            Boolean bool21 = this.useTrackGraphQlResponseErrors;
            if (bool21 != null) {
                bool21.booleanValue();
                jsonObject.addProperty("use_track_graph_ql_response_errors", bool21);
                Unit unit65 = Unit.INSTANCE;
                Unit unit66 = Unit.INSTANCE;
            }
            List<SelectedTracingPropagator> list = this.selectedTracingPropagators;
            if (list != null) {
                JsonArray jsonArray = new JsonArray(list.size());
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    jsonArray.add(((SelectedTracingPropagator) it.next()).toJson());
                }
                jsonObject.add("selected_tracing_propagators", jsonArray);
                Unit unit67 = Unit.INSTANCE;
                Unit unit68 = Unit.INSTANCE;
            }
            String str2 = this.defaultPrivacyLevel;
            if (str2 != null) {
                jsonObject.addProperty("default_privacy_level", str2);
                Unit unit69 = Unit.INSTANCE;
                Unit unit70 = Unit.INSTANCE;
            }
            String str3 = this.textAndInputPrivacyLevel;
            if (str3 != null) {
                jsonObject.addProperty("text_and_input_privacy_level", str3);
                Unit unit71 = Unit.INSTANCE;
                Unit unit72 = Unit.INSTANCE;
            }
            String str4 = this.imagePrivacyLevel;
            if (str4 != null) {
                jsonObject.addProperty("image_privacy_level", str4);
                Unit unit73 = Unit.INSTANCE;
                Unit unit74 = Unit.INSTANCE;
            }
            String str5 = this.touchPrivacyLevel;
            if (str5 != null) {
                jsonObject.addProperty("touch_privacy_level", str5);
                Unit unit75 = Unit.INSTANCE;
                Unit unit76 = Unit.INSTANCE;
            }
            Boolean bool22 = this.enablePrivacyForActionName;
            if (bool22 != null) {
                bool22.booleanValue();
                jsonObject.addProperty("enable_privacy_for_action_name", bool22);
                Unit unit77 = Unit.INSTANCE;
                Unit unit78 = Unit.INSTANCE;
            }
            Boolean bool23 = this.useExcludedActivityUrls;
            if (bool23 != null) {
                bool23.booleanValue();
                jsonObject.addProperty("use_excluded_activity_urls", bool23);
                Unit unit79 = Unit.INSTANCE;
                Unit unit80 = Unit.INSTANCE;
            }
            Boolean bool24 = this.useWorkerUrl;
            if (bool24 != null) {
                bool24.booleanValue();
                jsonObject.addProperty("use_worker_url", bool24);
                Unit unit81 = Unit.INSTANCE;
                Unit unit82 = Unit.INSTANCE;
            }
            Boolean bool25 = this.compressIntakeRequests;
            if (bool25 != null) {
                bool25.booleanValue();
                jsonObject.addProperty("compress_intake_requests", bool25);
                Unit unit83 = Unit.INSTANCE;
                Unit unit84 = Unit.INSTANCE;
            }
            Boolean bool26 = this.trackFrustrations;
            if (bool26 != null) {
                bool26.booleanValue();
                jsonObject.addProperty("track_frustrations", bool26);
                Unit unit85 = Unit.INSTANCE;
                Unit unit86 = Unit.INSTANCE;
            }
            Boolean bool27 = this.trackViewsManually;
            if (bool27 != null) {
                bool27.booleanValue();
                jsonObject.addProperty("track_views_manually", bool27);
                Unit unit87 = Unit.INSTANCE;
                Unit unit88 = Unit.INSTANCE;
            }
            Boolean bool28 = this.trackInteractions;
            if (bool28 != null) {
                bool28.booleanValue();
                jsonObject.addProperty("track_interactions", bool28);
                Unit unit89 = Unit.INSTANCE;
                Unit unit90 = Unit.INSTANCE;
            }
            Boolean bool29 = this.trackUserInteractions;
            if (bool29 != null) {
                bool29.booleanValue();
                jsonObject.addProperty("track_user_interactions", bool29);
                Unit unit91 = Unit.INSTANCE;
                Unit unit92 = Unit.INSTANCE;
            }
            Boolean bool30 = this.forwardErrorsToLogs;
            if (bool30 != null) {
                bool30.booleanValue();
                jsonObject.addProperty("forward_errors_to_logs", bool30);
                Unit unit93 = Unit.INSTANCE;
                Unit unit94 = Unit.INSTANCE;
            }
            Long l9 = this.numberOfDisplays;
            if (l9 != null) {
                jsonObject.addProperty("number_of_displays", Long.valueOf(l9.longValue()));
                Unit unit95 = Unit.INSTANCE;
                Unit unit96 = Unit.INSTANCE;
            }
            List<String> list2 = this.forwardConsoleLogs;
            if (list2 != null) {
                JsonArray jsonArray2 = new JsonArray(list2.size());
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    jsonArray2.add((String) it2.next());
                }
                jsonObject.add("forward_console_logs", jsonArray2);
                Unit unit97 = Unit.INSTANCE;
                Unit unit98 = Unit.INSTANCE;
            }
            List<String> list3 = this.forwardReports;
            if (list3 != null) {
                JsonArray jsonArray3 = new JsonArray(list3.size());
                Iterator<T> it3 = list3.iterator();
                while (it3.hasNext()) {
                    jsonArray3.add((String) it3.next());
                }
                jsonObject.add("forward_reports", jsonArray3);
                Unit unit99 = Unit.INSTANCE;
                Unit unit100 = Unit.INSTANCE;
            }
            Boolean bool31 = this.useLocalEncryption;
            if (bool31 != null) {
                bool31.booleanValue();
                jsonObject.addProperty("use_local_encryption", bool31);
                Unit unit101 = Unit.INSTANCE;
                Unit unit102 = Unit.INSTANCE;
            }
            ViewTrackingStrategy viewTrackingStrategy = this.viewTrackingStrategy;
            if (viewTrackingStrategy != null) {
                jsonObject.add("view_tracking_strategy", viewTrackingStrategy.toJson());
                Unit unit103 = Unit.INSTANCE;
                Unit unit104 = Unit.INSTANCE;
            }
            Boolean bool32 = this.swiftuiViewTrackingEnabled;
            if (bool32 != null) {
                bool32.booleanValue();
                jsonObject.addProperty("swiftui_view_tracking_enabled", bool32);
                Unit unit105 = Unit.INSTANCE;
                Unit unit106 = Unit.INSTANCE;
            }
            Boolean bool33 = this.swiftuiActionTrackingEnabled;
            if (bool33 != null) {
                bool33.booleanValue();
                jsonObject.addProperty("swiftui_action_tracking_enabled", bool33);
                Unit unit107 = Unit.INSTANCE;
                Unit unit108 = Unit.INSTANCE;
            }
            Boolean bool34 = this.trackBackgroundEvents;
            if (bool34 != null) {
                bool34.booleanValue();
                jsonObject.addProperty("track_background_events", bool34);
                Unit unit109 = Unit.INSTANCE;
                Unit unit110 = Unit.INSTANCE;
            }
            Long l10 = this.mobileVitalsUpdatePeriod;
            if (l10 != null) {
                jsonObject.addProperty("mobile_vitals_update_period", Long.valueOf(l10.longValue()));
                Unit unit111 = Unit.INSTANCE;
                Unit unit112 = Unit.INSTANCE;
            }
            Boolean bool35 = this.trackErrors;
            if (bool35 != null) {
                bool35.booleanValue();
                jsonObject.addProperty("track_errors", bool35);
                Unit unit113 = Unit.INSTANCE;
                Unit unit114 = Unit.INSTANCE;
            }
            Boolean bool36 = this.trackNetworkRequests;
            if (bool36 != null) {
                bool36.booleanValue();
                jsonObject.addProperty("track_network_requests", bool36);
                Unit unit115 = Unit.INSTANCE;
                Unit unit116 = Unit.INSTANCE;
            }
            Boolean bool37 = this.useTracing;
            if (bool37 != null) {
                bool37.booleanValue();
                jsonObject.addProperty("use_tracing", bool37);
                Unit unit117 = Unit.INSTANCE;
                Unit unit118 = Unit.INSTANCE;
            }
            Boolean bool38 = this.trackNativeViews;
            if (bool38 != null) {
                bool38.booleanValue();
                jsonObject.addProperty("track_native_views", bool38);
                Unit unit119 = Unit.INSTANCE;
                Unit unit120 = Unit.INSTANCE;
            }
            Boolean bool39 = this.trackNativeErrors;
            if (bool39 != null) {
                bool39.booleanValue();
                jsonObject.addProperty("track_native_errors", bool39);
                Unit unit121 = Unit.INSTANCE;
                Unit unit122 = Unit.INSTANCE;
            }
            Boolean bool40 = this.trackNativeLongTasks;
            if (bool40 != null) {
                bool40.booleanValue();
                jsonObject.addProperty("track_native_long_tasks", bool40);
                Unit unit123 = Unit.INSTANCE;
                Unit unit124 = Unit.INSTANCE;
            }
            Boolean bool41 = this.trackCrossPlatformLongTasks;
            if (bool41 != null) {
                bool41.booleanValue();
                jsonObject.addProperty("track_cross_platform_long_tasks", bool41);
                Unit unit125 = Unit.INSTANCE;
                Unit unit126 = Unit.INSTANCE;
            }
            Boolean bool42 = this.useFirstPartyHosts;
            if (bool42 != null) {
                bool42.booleanValue();
                jsonObject.addProperty("use_first_party_hosts", bool42);
                Unit unit127 = Unit.INSTANCE;
                Unit unit128 = Unit.INSTANCE;
            }
            String str6 = this.initializationType;
            if (str6 != null) {
                jsonObject.addProperty("initialization_type", str6);
                Unit unit129 = Unit.INSTANCE;
                Unit unit130 = Unit.INSTANCE;
            }
            Boolean bool43 = this.trackFlutterPerformance;
            if (bool43 != null) {
                bool43.booleanValue();
                jsonObject.addProperty("track_flutter_performance", bool43);
                Unit unit131 = Unit.INSTANCE;
                Unit unit132 = Unit.INSTANCE;
            }
            Long l11 = this.batchSize;
            if (l11 != null) {
                jsonObject.addProperty(BatchMetricsDispatcher.BATCH_SIZE_KEY, Long.valueOf(l11.longValue()));
                Unit unit133 = Unit.INSTANCE;
                Unit unit134 = Unit.INSTANCE;
            }
            Long l12 = this.batchUploadFrequency;
            if (l12 != null) {
                jsonObject.addProperty("batch_upload_frequency", Long.valueOf(l12.longValue()));
                Unit unit135 = Unit.INSTANCE;
                Unit unit136 = Unit.INSTANCE;
            }
            Long l13 = this.batchProcessingLevel;
            if (l13 != null) {
                jsonObject.addProperty("batch_processing_level", Long.valueOf(l13.longValue()));
                Unit unit137 = Unit.INSTANCE;
                Unit unit138 = Unit.INSTANCE;
            }
            Boolean bool44 = this.backgroundTasksEnabled;
            if (bool44 != null) {
                bool44.booleanValue();
                jsonObject.addProperty("background_tasks_enabled", bool44);
                Unit unit139 = Unit.INSTANCE;
                Unit unit140 = Unit.INSTANCE;
            }
            String str7 = this.reactVersion;
            if (str7 != null) {
                jsonObject.addProperty("react_version", str7);
                Unit unit141 = Unit.INSTANCE;
                Unit unit142 = Unit.INSTANCE;
            }
            String str8 = this.reactNativeVersion;
            if (str8 != null) {
                jsonObject.addProperty("react_native_version", str8);
                Unit unit143 = Unit.INSTANCE;
                Unit unit144 = Unit.INSTANCE;
            }
            String str9 = this.dartVersion;
            if (str9 != null) {
                jsonObject.addProperty("dart_version", str9);
                Unit unit145 = Unit.INSTANCE;
                Unit unit146 = Unit.INSTANCE;
            }
            String str10 = this.unityVersion;
            if (str10 != null) {
                jsonObject.addProperty("unity_version", str10);
                Unit unit147 = Unit.INSTANCE;
                Unit unit148 = Unit.INSTANCE;
            }
            String str11 = this.mauiVersion;
            if (str11 != null) {
                jsonObject.addProperty("maui_version", str11);
                Unit unit149 = Unit.INSTANCE;
                Unit unit150 = Unit.INSTANCE;
            }
            Long l14 = this.appHangThreshold;
            if (l14 != null) {
                jsonObject.addProperty("app_hang_threshold", Long.valueOf(l14.longValue()));
                Unit unit151 = Unit.INSTANCE;
                Unit unit152 = Unit.INSTANCE;
            }
            Boolean bool45 = this.usePciIntake;
            if (bool45 != null) {
                bool45.booleanValue();
                jsonObject.addProperty("use_pci_intake", bool45);
                Unit unit153 = Unit.INSTANCE;
                Unit unit154 = Unit.INSTANCE;
            }
            String str12 = this.tracerApi;
            if (str12 != null) {
                jsonObject.addProperty("tracer_api", str12);
                Unit unit155 = Unit.INSTANCE;
                Unit unit156 = Unit.INSTANCE;
            }
            String str13 = this.tracerApiVersion;
            if (str13 != null) {
                jsonObject.addProperty("tracer_api_version", str13);
                Unit unit157 = Unit.INSTANCE;
                Unit unit158 = Unit.INSTANCE;
            }
            Boolean bool46 = this.sendLogsAfterSessionExpiration;
            if (bool46 != null) {
                bool46.booleanValue();
                jsonObject.addProperty("send_logs_after_session_expiration", bool46);
                Unit unit159 = Unit.INSTANCE;
                Unit unit160 = Unit.INSTANCE;
            }
            List<Plugin> list4 = this.plugins;
            if (list4 != null) {
                JsonArray jsonArray4 = new JsonArray(list4.size());
                Iterator<T> it4 = list4.iterator();
                while (it4.hasNext()) {
                    jsonArray4.add(((Plugin) it4.next()).toJson());
                }
                jsonObject.add("plugins", jsonArray4);
                Unit unit161 = Unit.INSTANCE;
                Unit unit162 = Unit.INSTANCE;
            }
            Boolean bool47 = this.isMainProcess;
            if (bool47 != null) {
                bool47.booleanValue();
                jsonObject.addProperty("is_main_process", bool47);
                Unit unit163 = Unit.INSTANCE;
                Unit unit164 = Unit.INSTANCE;
            }
            Long l15 = this.invTimeThresholdMs;
            if (l15 != null) {
                jsonObject.addProperty("inv_time_threshold_ms", Long.valueOf(l15.longValue()));
                Unit unit165 = Unit.INSTANCE;
                Unit unit166 = Unit.INSTANCE;
            }
            Long l16 = this.tnsTimeThresholdMs;
            if (l16 != null) {
                jsonObject.addProperty("tns_time_threshold_ms", Long.valueOf(l16.longValue()));
                Unit unit167 = Unit.INSTANCE;
                Unit unit168 = Unit.INSTANCE;
            }
            List<TrackFeatureFlagsForEvent> list5 = this.trackFeatureFlagsForEvents;
            if (list5 != null) {
                JsonArray jsonArray5 = new JsonArray(list5.size());
                Iterator<T> it5 = list5.iterator();
                while (it5.hasNext()) {
                    jsonArray5.add(((TrackFeatureFlagsForEvent) it5.next()).toJson());
                }
                jsonObject.add("track_feature_flags_for_events", jsonArray5);
                Unit unit169 = Unit.INSTANCE;
                Unit unit170 = Unit.INSTANCE;
            }
            Boolean bool48 = this.trackAnonymousUser;
            if (bool48 != null) {
                bool48.booleanValue();
                jsonObject.addProperty("track_anonymous_user", bool48);
                Unit unit171 = Unit.INSTANCE;
                Unit unit172 = Unit.INSTANCE;
            }
            Boolean bool49 = this.useAllowedTrackingOrigins;
            if (bool49 != null) {
                bool49.booleanValue();
                jsonObject.addProperty("use_allowed_tracking_origins", bool49);
                Unit unit173 = Unit.INSTANCE;
                Unit unit174 = Unit.INSTANCE;
            }
            String str14 = this.sdkVersion;
            if (str14 != null) {
                jsonObject.addProperty("sdk_version", str14);
                Unit unit175 = Unit.INSTANCE;
                Unit unit176 = Unit.INSTANCE;
            }
            String str15 = this.source;
            if (str15 != null) {
                jsonObject.addProperty("source", str15);
                Unit unit177 = Unit.INSTANCE;
                Unit unit178 = Unit.INSTANCE;
            }
            String str16 = this.variant;
            if (str16 != null) {
                jsonObject.addProperty("variant", str16);
                Unit unit179 = Unit.INSTANCE;
                Unit unit180 = Unit.INSTANCE;
            }
            String str17 = this.remoteConfigurationId;
            if (str17 != null) {
                jsonObject.addProperty("remote_configuration_id", str17);
                Unit unit181 = Unit.INSTANCE;
                Unit unit182 = Unit.INSTANCE;
            }
            Boolean bool50 = this.useRemoteConfigurationProxy;
            if (bool50 != null) {
                bool50.booleanValue();
                jsonObject.addProperty("use_remote_configuration_proxy", bool50);
                Unit unit183 = Unit.INSTANCE;
                Unit unit184 = Unit.INSTANCE;
            }
            Number number = this.profilingSampleRate;
            if (number != null) {
                jsonObject.addProperty("profiling_sample_rate", number);
                Unit unit185 = Unit.INSTANCE;
                Unit unit186 = Unit.INSTANCE;
            }
            Boolean bool51 = this.propagateTraceBaggage;
            if (bool51 != null) {
                bool51.booleanValue();
                jsonObject.addProperty("propagate_trace_baggage", bool51);
                Unit unit187 = Unit.INSTANCE;
                Unit unit188 = Unit.INSTANCE;
            }
            TrackResourceHeaders trackResourceHeaders = this.trackResourceHeaders;
            if (trackResourceHeaders != null) {
                jsonObject.add("track_resource_headers", trackResourceHeaders.toJson());
                Unit unit189 = Unit.INSTANCE;
                Unit unit190 = Unit.INSTANCE;
            }
            Boolean bool52 = this.betaEncodeCookieOptions;
            if (bool52 != null) {
                bool52.booleanValue();
                jsonObject.addProperty("beta_encode_cookie_options", bool52);
                Unit unit191 = Unit.INSTANCE;
                Unit unit192 = Unit.INSTANCE;
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Configuration$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Configuration;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
                Long l;
                ArrayList arrayList;
                ArrayList arrayList2;
                ArrayList arrayList3;
                String str;
                Long l2;
                ArrayList arrayList4;
                ArrayList arrayList5;
                String asString;
                JsonArray asJsonArray;
                JsonArray asJsonArray2;
                String asString2;
                JsonArray asJsonArray3;
                JsonArray asJsonArray4;
                JsonArray asJsonArray5;
                String asString3;
                String asString4;
                String asString5;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get("session_sample_rate");
                    Long lValueOf = jsonElement != null ? Long.valueOf(jsonElement.getAsLong()) : null;
                    JsonElement jsonElement2 = jsonObject.get("telemetry_sample_rate");
                    Long lValueOf2 = jsonElement2 != null ? Long.valueOf(jsonElement2.getAsLong()) : null;
                    JsonElement jsonElement3 = jsonObject.get("telemetry_configuration_sample_rate");
                    Long lValueOf3 = jsonElement3 != null ? Long.valueOf(jsonElement3.getAsLong()) : null;
                    JsonElement jsonElement4 = jsonObject.get("telemetry_usage_sample_rate");
                    Long lValueOf4 = jsonElement4 != null ? Long.valueOf(jsonElement4.getAsLong()) : null;
                    JsonElement jsonElement5 = jsonObject.get("trace_sample_rate");
                    Long lValueOf5 = jsonElement5 != null ? Long.valueOf(jsonElement5.getAsLong()) : null;
                    JsonElement jsonElement6 = jsonObject.get("trace_context_injection");
                    TraceContextInjection traceContextInjectionFromJson = (jsonElement6 == null || (asString5 = jsonElement6.getAsString()) == null) ? null : TraceContextInjection.INSTANCE.fromJson(asString5);
                    JsonElement jsonElement7 = jsonObject.get("premium_sample_rate");
                    Long lValueOf6 = jsonElement7 != null ? Long.valueOf(jsonElement7.getAsLong()) : null;
                    JsonElement jsonElement8 = jsonObject.get("replay_sample_rate");
                    Long lValueOf7 = jsonElement8 != null ? Long.valueOf(jsonElement8.getAsLong()) : null;
                    JsonElement jsonElement9 = jsonObject.get("session_replay_sample_rate");
                    Long lValueOf8 = jsonElement9 != null ? Long.valueOf(jsonElement9.getAsLong()) : null;
                    JsonElement jsonElement10 = jsonObject.get("tracking_consent");
                    TrackingConsent trackingConsentFromJson = (jsonElement10 == null || (asString4 = jsonElement10.getAsString()) == null) ? null : TrackingConsent.INSTANCE.fromJson(asString4);
                    JsonElement jsonElement11 = jsonObject.get("start_session_replay_recording_manually");
                    Boolean boolValueOf = jsonElement11 != null ? Boolean.valueOf(jsonElement11.getAsBoolean()) : null;
                    JsonElement jsonElement12 = jsonObject.get("start_recording_immediately");
                    Boolean boolValueOf2 = jsonElement12 != null ? Boolean.valueOf(jsonElement12.getAsBoolean()) : null;
                    JsonElement jsonElement13 = jsonObject.get("use_proxy");
                    Boolean boolValueOf3 = jsonElement13 != null ? Boolean.valueOf(jsonElement13.getAsBoolean()) : null;
                    JsonElement jsonElement14 = jsonObject.get("use_before_send");
                    Boolean boolValueOf4 = jsonElement14 != null ? Boolean.valueOf(jsonElement14.getAsBoolean()) : null;
                    JsonElement jsonElement15 = jsonObject.get("silent_multiple_init");
                    Boolean boolValueOf5 = jsonElement15 != null ? Boolean.valueOf(jsonElement15.getAsBoolean()) : null;
                    JsonElement jsonElement16 = jsonObject.get("track_session_across_subdomains");
                    Boolean boolValueOf6 = jsonElement16 != null ? Boolean.valueOf(jsonElement16.getAsBoolean()) : null;
                    JsonElement jsonElement17 = jsonObject.get("track_resources");
                    Boolean boolValueOf7 = jsonElement17 != null ? Boolean.valueOf(jsonElement17.getAsBoolean()) : null;
                    JsonElement jsonElement18 = jsonObject.get("track_early_requests");
                    Boolean boolValueOf8 = jsonElement18 != null ? Boolean.valueOf(jsonElement18.getAsBoolean()) : null;
                    JsonElement jsonElement19 = jsonObject.get("track_long_task");
                    Boolean boolValueOf9 = jsonElement19 != null ? Boolean.valueOf(jsonElement19.getAsBoolean()) : null;
                    JsonElement jsonElement20 = jsonObject.get("track_bfcache_views");
                    Boolean boolValueOf10 = jsonElement20 != null ? Boolean.valueOf(jsonElement20.getAsBoolean()) : null;
                    JsonElement jsonElement21 = jsonObject.get("use_cross_site_session_cookie");
                    Boolean boolValueOf11 = jsonElement21 != null ? Boolean.valueOf(jsonElement21.getAsBoolean()) : null;
                    JsonElement jsonElement22 = jsonObject.get("use_partitioned_cross_site_session_cookie");
                    Boolean boolValueOf12 = jsonElement22 != null ? Boolean.valueOf(jsonElement22.getAsBoolean()) : null;
                    JsonElement jsonElement23 = jsonObject.get("use_secure_session_cookie");
                    Boolean boolValueOf13 = jsonElement23 != null ? Boolean.valueOf(jsonElement23.getAsBoolean()) : null;
                    JsonElement jsonElement24 = jsonObject.get("allow_fallback_to_local_storage");
                    Boolean boolValueOf14 = jsonElement24 != null ? Boolean.valueOf(jsonElement24.getAsBoolean()) : null;
                    JsonElement jsonElement25 = jsonObject.get("session_persistence");
                    SessionPersistence sessionPersistenceFromJson = (jsonElement25 == null || (asString3 = jsonElement25.getAsString()) == null) ? null : SessionPersistence.INSTANCE.fromJson(asString3);
                    JsonElement jsonElement26 = jsonObject.get("store_contexts_across_pages");
                    Boolean boolValueOf15 = jsonElement26 != null ? Boolean.valueOf(jsonElement26.getAsBoolean()) : null;
                    JsonElement jsonElement27 = jsonObject.get("allow_untrusted_events");
                    Boolean boolValueOf16 = jsonElement27 != null ? Boolean.valueOf(jsonElement27.getAsBoolean()) : null;
                    JsonElement jsonElement28 = jsonObject.get("action_name_attribute");
                    String asString6 = jsonElement28 != null ? jsonElement28.getAsString() : null;
                    JsonElement jsonElement29 = jsonObject.get("use_allowed_tracing_origins");
                    Boolean boolValueOf17 = jsonElement29 != null ? Boolean.valueOf(jsonElement29.getAsBoolean()) : null;
                    JsonElement jsonElement30 = jsonObject.get("use_allowed_tracing_urls");
                    Boolean boolValueOf18 = jsonElement30 != null ? Boolean.valueOf(jsonElement30.getAsBoolean()) : null;
                    JsonElement jsonElement31 = jsonObject.get("use_allowed_graph_ql_urls");
                    Boolean boolValueOf19 = jsonElement31 != null ? Boolean.valueOf(jsonElement31.getAsBoolean()) : null;
                    JsonElement jsonElement32 = jsonObject.get("use_track_graph_ql_payload");
                    Boolean boolValueOf20 = jsonElement32 != null ? Boolean.valueOf(jsonElement32.getAsBoolean()) : null;
                    JsonElement jsonElement33 = jsonObject.get("use_track_graph_ql_response_errors");
                    Boolean boolValueOf21 = jsonElement33 != null ? Boolean.valueOf(jsonElement33.getAsBoolean()) : null;
                    JsonElement jsonElement34 = jsonObject.get("selected_tracing_propagators");
                    SessionPersistence sessionPersistence = sessionPersistenceFromJson;
                    if (jsonElement34 == null || (asJsonArray5 = jsonElement34.getAsJsonArray()) == null) {
                        l = lValueOf3;
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(asJsonArray5.size());
                        Iterator<JsonElement> it = asJsonArray5.iterator();
                        while (it.hasNext()) {
                            JsonElement next = it.next();
                            Iterator<JsonElement> it2 = it;
                            SelectedTracingPropagator.Companion companion = SelectedTracingPropagator.INSTANCE;
                            Long l3 = lValueOf3;
                            String asString7 = next.getAsString();
                            Intrinsics.checkNotNullExpressionValue(asString7, "it.asString");
                            arrayList.add(companion.fromJson(asString7));
                            it = it2;
                            lValueOf3 = l3;
                        }
                        l = lValueOf3;
                    }
                    JsonElement jsonElement35 = jsonObject.get("default_privacy_level");
                    String asString8 = jsonElement35 != null ? jsonElement35.getAsString() : null;
                    JsonElement jsonElement36 = jsonObject.get("text_and_input_privacy_level");
                    String asString9 = jsonElement36 != null ? jsonElement36.getAsString() : null;
                    JsonElement jsonElement37 = jsonObject.get("image_privacy_level");
                    String asString10 = jsonElement37 != null ? jsonElement37.getAsString() : null;
                    JsonElement jsonElement38 = jsonObject.get("touch_privacy_level");
                    String asString11 = jsonElement38 != null ? jsonElement38.getAsString() : null;
                    ArrayList arrayList6 = arrayList;
                    JsonElement jsonElement39 = jsonObject.get("enable_privacy_for_action_name");
                    Boolean boolValueOf22 = jsonElement39 != null ? Boolean.valueOf(jsonElement39.getAsBoolean()) : null;
                    JsonElement jsonElement40 = jsonObject.get("use_excluded_activity_urls");
                    Boolean boolValueOf23 = jsonElement40 != null ? Boolean.valueOf(jsonElement40.getAsBoolean()) : null;
                    JsonElement jsonElement41 = jsonObject.get("use_worker_url");
                    Boolean boolValueOf24 = jsonElement41 != null ? Boolean.valueOf(jsonElement41.getAsBoolean()) : null;
                    JsonElement jsonElement42 = jsonObject.get("compress_intake_requests");
                    Boolean boolValueOf25 = jsonElement42 != null ? Boolean.valueOf(jsonElement42.getAsBoolean()) : null;
                    JsonElement jsonElement43 = jsonObject.get("track_frustrations");
                    Boolean boolValueOf26 = jsonElement43 != null ? Boolean.valueOf(jsonElement43.getAsBoolean()) : null;
                    JsonElement jsonElement44 = jsonObject.get("track_views_manually");
                    Boolean boolValueOf27 = jsonElement44 != null ? Boolean.valueOf(jsonElement44.getAsBoolean()) : null;
                    JsonElement jsonElement45 = jsonObject.get("track_interactions");
                    Boolean boolValueOf28 = jsonElement45 != null ? Boolean.valueOf(jsonElement45.getAsBoolean()) : null;
                    JsonElement jsonElement46 = jsonObject.get("track_user_interactions");
                    Boolean boolValueOf29 = jsonElement46 != null ? Boolean.valueOf(jsonElement46.getAsBoolean()) : null;
                    JsonElement jsonElement47 = jsonObject.get("forward_errors_to_logs");
                    Boolean boolValueOf30 = jsonElement47 != null ? Boolean.valueOf(jsonElement47.getAsBoolean()) : null;
                    JsonElement jsonElement48 = jsonObject.get("number_of_displays");
                    Long lValueOf9 = jsonElement48 != null ? Long.valueOf(jsonElement48.getAsLong()) : null;
                    JsonElement jsonElement49 = jsonObject.get("forward_console_logs");
                    if (jsonElement49 == null || (asJsonArray4 = jsonElement49.getAsJsonArray()) == null) {
                        arrayList2 = null;
                    } else {
                        arrayList2 = new ArrayList(asJsonArray4.size());
                        for (Iterator<JsonElement> it3 = asJsonArray4.iterator(); it3.hasNext(); it3 = it3) {
                            arrayList2.add(it3.next().getAsString());
                        }
                    }
                    JsonElement jsonElement50 = jsonObject.get("forward_reports");
                    if (jsonElement50 == null || (asJsonArray3 = jsonElement50.getAsJsonArray()) == null) {
                        arrayList3 = null;
                    } else {
                        arrayList3 = new ArrayList(asJsonArray3.size());
                        for (Iterator<JsonElement> it4 = asJsonArray3.iterator(); it4.hasNext(); it4 = it4) {
                            arrayList3.add(it4.next().getAsString());
                        }
                    }
                    JsonElement jsonElement51 = jsonObject.get("use_local_encryption");
                    Boolean boolValueOf31 = jsonElement51 != null ? Boolean.valueOf(jsonElement51.getAsBoolean()) : null;
                    ArrayList arrayList7 = arrayList3;
                    JsonElement jsonElement52 = jsonObject.get("view_tracking_strategy");
                    ViewTrackingStrategy viewTrackingStrategyFromJson = (jsonElement52 == null || (asString2 = jsonElement52.getAsString()) == null) ? null : ViewTrackingStrategy.INSTANCE.fromJson(asString2);
                    JsonElement jsonElement53 = jsonObject.get("swiftui_view_tracking_enabled");
                    Boolean boolValueOf32 = jsonElement53 != null ? Boolean.valueOf(jsonElement53.getAsBoolean()) : null;
                    ViewTrackingStrategy viewTrackingStrategy = viewTrackingStrategyFromJson;
                    JsonElement jsonElement54 = jsonObject.get("swiftui_action_tracking_enabled");
                    Boolean boolValueOf33 = jsonElement54 != null ? Boolean.valueOf(jsonElement54.getAsBoolean()) : null;
                    JsonElement jsonElement55 = jsonObject.get("track_background_events");
                    Boolean boolValueOf34 = jsonElement55 != null ? Boolean.valueOf(jsonElement55.getAsBoolean()) : null;
                    JsonElement jsonElement56 = jsonObject.get("mobile_vitals_update_period");
                    Long lValueOf10 = jsonElement56 != null ? Long.valueOf(jsonElement56.getAsLong()) : null;
                    JsonElement jsonElement57 = jsonObject.get("track_errors");
                    Boolean boolValueOf35 = jsonElement57 != null ? Boolean.valueOf(jsonElement57.getAsBoolean()) : null;
                    JsonElement jsonElement58 = jsonObject.get("track_network_requests");
                    Boolean boolValueOf36 = jsonElement58 != null ? Boolean.valueOf(jsonElement58.getAsBoolean()) : null;
                    JsonElement jsonElement59 = jsonObject.get("use_tracing");
                    Boolean boolValueOf37 = jsonElement59 != null ? Boolean.valueOf(jsonElement59.getAsBoolean()) : null;
                    JsonElement jsonElement60 = jsonObject.get("track_native_views");
                    Boolean boolValueOf38 = jsonElement60 != null ? Boolean.valueOf(jsonElement60.getAsBoolean()) : null;
                    JsonElement jsonElement61 = jsonObject.get("track_native_errors");
                    Boolean boolValueOf39 = jsonElement61 != null ? Boolean.valueOf(jsonElement61.getAsBoolean()) : null;
                    JsonElement jsonElement62 = jsonObject.get("track_native_long_tasks");
                    Boolean boolValueOf40 = jsonElement62 != null ? Boolean.valueOf(jsonElement62.getAsBoolean()) : null;
                    JsonElement jsonElement63 = jsonObject.get("track_cross_platform_long_tasks");
                    Boolean boolValueOf41 = jsonElement63 != null ? Boolean.valueOf(jsonElement63.getAsBoolean()) : null;
                    JsonElement jsonElement64 = jsonObject.get("use_first_party_hosts");
                    Boolean boolValueOf42 = jsonElement64 != null ? Boolean.valueOf(jsonElement64.getAsBoolean()) : null;
                    JsonElement jsonElement65 = jsonObject.get("initialization_type");
                    String asString12 = jsonElement65 != null ? jsonElement65.getAsString() : null;
                    JsonElement jsonElement66 = jsonObject.get("track_flutter_performance");
                    Boolean boolValueOf43 = jsonElement66 != null ? Boolean.valueOf(jsonElement66.getAsBoolean()) : null;
                    JsonElement jsonElement67 = jsonObject.get(BatchMetricsDispatcher.BATCH_SIZE_KEY);
                    Long lValueOf11 = jsonElement67 != null ? Long.valueOf(jsonElement67.getAsLong()) : null;
                    JsonElement jsonElement68 = jsonObject.get("batch_upload_frequency");
                    Long lValueOf12 = jsonElement68 != null ? Long.valueOf(jsonElement68.getAsLong()) : null;
                    JsonElement jsonElement69 = jsonObject.get("batch_processing_level");
                    Long lValueOf13 = jsonElement69 != null ? Long.valueOf(jsonElement69.getAsLong()) : null;
                    JsonElement jsonElement70 = jsonObject.get("background_tasks_enabled");
                    Boolean boolValueOf44 = jsonElement70 != null ? Boolean.valueOf(jsonElement70.getAsBoolean()) : null;
                    JsonElement jsonElement71 = jsonObject.get("react_version");
                    String asString13 = jsonElement71 != null ? jsonElement71.getAsString() : null;
                    JsonElement jsonElement72 = jsonObject.get("react_native_version");
                    String asString14 = jsonElement72 != null ? jsonElement72.getAsString() : null;
                    JsonElement jsonElement73 = jsonObject.get("dart_version");
                    String asString15 = jsonElement73 != null ? jsonElement73.getAsString() : null;
                    JsonElement jsonElement74 = jsonObject.get("unity_version");
                    String asString16 = jsonElement74 != null ? jsonElement74.getAsString() : null;
                    JsonElement jsonElement75 = jsonObject.get("maui_version");
                    String asString17 = jsonElement75 != null ? jsonElement75.getAsString() : null;
                    JsonElement jsonElement76 = jsonObject.get("app_hang_threshold");
                    Long lValueOf14 = jsonElement76 != null ? Long.valueOf(jsonElement76.getAsLong()) : null;
                    JsonElement jsonElement77 = jsonObject.get("use_pci_intake");
                    Boolean boolValueOf45 = jsonElement77 != null ? Boolean.valueOf(jsonElement77.getAsBoolean()) : null;
                    JsonElement jsonElement78 = jsonObject.get("tracer_api");
                    String asString18 = jsonElement78 != null ? jsonElement78.getAsString() : null;
                    JsonElement jsonElement79 = jsonObject.get("tracer_api_version");
                    String asString19 = jsonElement79 != null ? jsonElement79.getAsString() : null;
                    JsonElement jsonElement80 = jsonObject.get("send_logs_after_session_expiration");
                    Boolean boolValueOf46 = jsonElement80 != null ? Boolean.valueOf(jsonElement80.getAsBoolean()) : null;
                    JsonElement jsonElement81 = jsonObject.get("plugins");
                    if (jsonElement81 == null || (asJsonArray2 = jsonElement81.getAsJsonArray()) == null) {
                        str = asString11;
                        l2 = lValueOf4;
                        arrayList4 = null;
                    } else {
                        arrayList4 = new ArrayList(asJsonArray2.size());
                        Iterator<JsonElement> it5 = asJsonArray2.iterator();
                        while (it5.hasNext()) {
                            JsonElement next2 = it5.next();
                            Iterator<JsonElement> it6 = it5;
                            Plugin.Companion companion2 = Plugin.INSTANCE;
                            String str2 = asString11;
                            JsonObject asJsonObject = next2.getAsJsonObject();
                            Intrinsics.checkNotNullExpressionValue(asJsonObject, "it.asJsonObject");
                            arrayList4.add(companion2.fromJsonObject(asJsonObject));
                            lValueOf4 = lValueOf4;
                            it5 = it6;
                            asString11 = str2;
                        }
                        str = asString11;
                        l2 = lValueOf4;
                    }
                    JsonElement jsonElement82 = jsonObject.get("is_main_process");
                    Boolean boolValueOf47 = jsonElement82 != null ? Boolean.valueOf(jsonElement82.getAsBoolean()) : null;
                    JsonElement jsonElement83 = jsonObject.get("inv_time_threshold_ms");
                    Long lValueOf15 = jsonElement83 != null ? Long.valueOf(jsonElement83.getAsLong()) : null;
                    JsonElement jsonElement84 = jsonObject.get("tns_time_threshold_ms");
                    Long lValueOf16 = jsonElement84 != null ? Long.valueOf(jsonElement84.getAsLong()) : null;
                    JsonElement jsonElement85 = jsonObject.get("track_feature_flags_for_events");
                    if (jsonElement85 == null || (asJsonArray = jsonElement85.getAsJsonArray()) == null) {
                        arrayList5 = null;
                    } else {
                        arrayList5 = new ArrayList(asJsonArray.size());
                        Iterator<JsonElement> it7 = asJsonArray.iterator();
                        while (it7.hasNext()) {
                            JsonElement next3 = it7.next();
                            Iterator<JsonElement> it8 = it7;
                            TrackFeatureFlagsForEvent.Companion companion3 = TrackFeatureFlagsForEvent.INSTANCE;
                            String asString20 = next3.getAsString();
                            Intrinsics.checkNotNullExpressionValue(asString20, "it.asString");
                            arrayList5.add(companion3.fromJson(asString20));
                            it7 = it8;
                        }
                    }
                    JsonElement jsonElement86 = jsonObject.get("track_anonymous_user");
                    Boolean boolValueOf48 = jsonElement86 != null ? Boolean.valueOf(jsonElement86.getAsBoolean()) : null;
                    JsonElement jsonElement87 = jsonObject.get("use_allowed_tracking_origins");
                    Boolean boolValueOf49 = jsonElement87 != null ? Boolean.valueOf(jsonElement87.getAsBoolean()) : null;
                    JsonElement jsonElement88 = jsonObject.get("sdk_version");
                    String asString21 = jsonElement88 != null ? jsonElement88.getAsString() : null;
                    JsonElement jsonElement89 = jsonObject.get("source");
                    String asString22 = jsonElement89 != null ? jsonElement89.getAsString() : null;
                    JsonElement jsonElement90 = jsonObject.get("variant");
                    String asString23 = jsonElement90 != null ? jsonElement90.getAsString() : null;
                    JsonElement jsonElement91 = jsonObject.get("remote_configuration_id");
                    String asString24 = jsonElement91 != null ? jsonElement91.getAsString() : null;
                    JsonElement jsonElement92 = jsonObject.get("use_remote_configuration_proxy");
                    Boolean boolValueOf50 = jsonElement92 != null ? Boolean.valueOf(jsonElement92.getAsBoolean()) : null;
                    JsonElement jsonElement93 = jsonObject.get("profiling_sample_rate");
                    Number asNumber = jsonElement93 != null ? jsonElement93.getAsNumber() : null;
                    JsonElement jsonElement94 = jsonObject.get("propagate_trace_baggage");
                    Boolean boolValueOf51 = jsonElement94 != null ? Boolean.valueOf(jsonElement94.getAsBoolean()) : null;
                    JsonElement jsonElement95 = jsonObject.get("track_resource_headers");
                    TrackResourceHeaders trackResourceHeadersFromJson = (jsonElement95 == null || (asString = jsonElement95.getAsString()) == null) ? null : TrackResourceHeaders.INSTANCE.fromJson(asString);
                    JsonElement jsonElement96 = jsonObject.get("beta_encode_cookie_options");
                    return new Configuration(lValueOf, lValueOf2, l, l2, lValueOf5, traceContextInjectionFromJson, lValueOf6, lValueOf7, lValueOf8, trackingConsentFromJson, boolValueOf, boolValueOf2, boolValueOf3, boolValueOf4, boolValueOf5, boolValueOf6, boolValueOf7, boolValueOf8, boolValueOf9, boolValueOf10, boolValueOf11, boolValueOf12, boolValueOf13, boolValueOf14, sessionPersistence, boolValueOf15, boolValueOf16, asString6, boolValueOf17, boolValueOf18, boolValueOf19, boolValueOf20, boolValueOf21, arrayList6, asString8, asString9, asString10, str, boolValueOf22, boolValueOf23, boolValueOf24, boolValueOf25, boolValueOf26, boolValueOf27, boolValueOf28, boolValueOf29, boolValueOf30, lValueOf9, arrayList2, arrayList7, boolValueOf31, viewTrackingStrategy, boolValueOf32, boolValueOf33, boolValueOf34, lValueOf10, boolValueOf35, boolValueOf36, boolValueOf37, boolValueOf38, boolValueOf39, boolValueOf40, boolValueOf41, boolValueOf42, asString12, boolValueOf43, lValueOf11, lValueOf12, lValueOf13, boolValueOf44, asString13, asString14, asString15, asString16, asString17, lValueOf14, boolValueOf45, asString18, asString19, boolValueOf46, arrayList4, boolValueOf47, lValueOf15, lValueOf16, arrayList5, boolValueOf48, boolValueOf49, asString21, asString22, asString23, asString24, boolValueOf50, asNumber, boolValueOf51, trackResourceHeadersFromJson, jsonElement96 != null ? Boolean.valueOf(jsonElement96.getAsBoolean()) : null);
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

    /* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005HÆ\u0003J+\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Plugin;", "", "name", "", "additionalProperties", "", "(Ljava/lang/String;Ljava/util/Map;)V", "getAdditionalProperties", "()Ljava/util/Map;", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Plugin {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final String[] RESERVED_PROPERTIES = {"name"};
        private final Map<String, Object> additionalProperties;
        private final String name;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Plugin copy$default(Plugin plugin, String str, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = plugin.name;
            }
            if ((i & 2) != 0) {
                map = plugin.additionalProperties;
            }
            return plugin.copy(str, map);
        }

        @JvmStatic
        public static final Plugin fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Plugin fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final Map<String, Object> component2() {
            return this.additionalProperties;
        }

        public final Plugin copy(String name, Map<String, Object> additionalProperties) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            return new Plugin(name, additionalProperties);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Plugin)) {
                return false;
            }
            Plugin plugin = (Plugin) other;
            return Intrinsics.areEqual(this.name, plugin.name) && Intrinsics.areEqual(this.additionalProperties, plugin.additionalProperties);
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.additionalProperties.hashCode();
        }

        public String toString() {
            return "Plugin(name=" + this.name + ", additionalProperties=" + this.additionalProperties + ")";
        }

        public Plugin(String name, Map<String, Object> additionalProperties) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            this.name = name;
            this.additionalProperties = additionalProperties;
        }

        public final String getName() {
            return this.name;
        }

        public /* synthetic */ Plugin(String str, LinkedHashMap linkedHashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? new LinkedHashMap() : linkedHashMap);
        }

        public final Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("name", this.name);
            for (Map.Entry<String, Object> entry : this.additionalProperties.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (!ArraysKt.contains(RESERVED_PROPERTIES, key)) {
                    jsonObject.add(key, JsonSerializer.INSTANCE.toJsonElement(value));
                }
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0007J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Plugin$Companion;", "", "()V", "RESERVED_PROPERTIES", "", "", "getRESERVED_PROPERTIES$dd_sdk_android_rum_release", "()[Ljava/lang/String;", "[Ljava/lang/String;", "fromJson", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Plugin;", "jsonString", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final String[] getRESERVED_PROPERTIES$dd_sdk_android_rum_release() {
                return Plugin.RESERVED_PROPERTIES;
            }

            @JvmStatic
            public final Plugin fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Plugin", e);
                }
            }

            @JvmStatic
            public final Plugin fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String name = jsonObject.get("name").getAsString();
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                        if (!ArraysKt.contains(getRESERVED_PROPERTIES$dd_sdk_android_rum_release(), entry.getKey())) {
                            String key = entry.getKey();
                            Intrinsics.checkNotNullExpressionValue(key, "entry.key");
                            linkedHashMap.put(key, entry.getValue());
                        }
                    }
                    Intrinsics.checkNotNullExpressionValue(name, "name");
                    return new Plugin(name, linkedHashMap);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Plugin", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Plugin", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Plugin", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Source;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "ANDROID", "IOS", "BROWSER", "FLUTTER", "REACT_NATIVE", "UNITY", "KOTLIN_MULTIPLATFORM", "ELECTRON", "RUM_CPP", "MAUI", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum Source {
        ANDROID("android"),
        IOS(CredentialsData.CREDENTIALS_TYPE_IOS),
        BROWSER("browser"),
        FLUTTER("flutter"),
        REACT_NATIVE("react-native"),
        UNITY("unity"),
        KOTLIN_MULTIPLATFORM("kotlin-multiplatform"),
        ELECTRON("electron"),
        RUM_CPP("rum-cpp"),
        MAUI("maui");


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String jsonValue;

        @JvmStatic
        public static final Source fromJson(String str) {
            return INSTANCE.fromJson(str);
        }

        Source(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        /* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Source$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$Source;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Source fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (Source source : Source.values()) {
                    if (Intrinsics.areEqual(source.jsonValue, jsonString)) {
                        return source;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    /* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$TraceContextInjection;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", Rule.ALL, "SAMPLED", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum TraceContextInjection {
        ALL("all"),
        SAMPLED("sampled");


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String jsonValue;

        @JvmStatic
        public static final TraceContextInjection fromJson(String str) {
            return INSTANCE.fromJson(str);
        }

        TraceContextInjection(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        /* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$TraceContextInjection$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$TraceContextInjection;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final TraceContextInjection fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (TraceContextInjection traceContextInjection : TraceContextInjection.values()) {
                    if (Intrinsics.areEqual(traceContextInjection.jsonValue, jsonString)) {
                        return traceContextInjection;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    /* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$TrackingConsent;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", DefaultConfiguration.trackingConsent, "NOT_GRANTED", "PENDING", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum TrackingConsent {
        GRANTED(PermissionsResponse.GRANTED_KEY),
        NOT_GRANTED("not-granted"),
        PENDING("pending");


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String jsonValue;

        @JvmStatic
        public static final TrackingConsent fromJson(String str) {
            return INSTANCE.fromJson(str);
        }

        TrackingConsent(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        /* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$TrackingConsent$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$TrackingConsent;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final TrackingConsent fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (TrackingConsent trackingConsent : TrackingConsent.values()) {
                    if (Intrinsics.areEqual(trackingConsent.jsonValue, jsonString)) {
                        return trackingConsent;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    /* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$SessionPersistence;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "LOCAL_STORAGE", "COOKIE", "MEMORY", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum SessionPersistence {
        LOCAL_STORAGE("local-storage"),
        COOKIE("cookie"),
        MEMORY("memory");


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String jsonValue;

        @JvmStatic
        public static final SessionPersistence fromJson(String str) {
            return INSTANCE.fromJson(str);
        }

        SessionPersistence(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        /* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$SessionPersistence$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$SessionPersistence;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final SessionPersistence fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (SessionPersistence sessionPersistence : SessionPersistence.values()) {
                    if (Intrinsics.areEqual(sessionPersistence.jsonValue, jsonString)) {
                        return sessionPersistence;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    /* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$SelectedTracingPropagator;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "DATADOG", "B3", "B3MULTI", "TRACECONTEXT", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum SelectedTracingPropagator {
        DATADOG("datadog"),
        B3(B3HttpCodec.B3_KEY),
        B3MULTI("b3multi"),
        TRACECONTEXT("tracecontext");


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String jsonValue;

        @JvmStatic
        public static final SelectedTracingPropagator fromJson(String str) {
            return INSTANCE.fromJson(str);
        }

        SelectedTracingPropagator(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        /* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$SelectedTracingPropagator$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$SelectedTracingPropagator;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final SelectedTracingPropagator fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (SelectedTracingPropagator selectedTracingPropagator : SelectedTracingPropagator.values()) {
                    if (Intrinsics.areEqual(selectedTracingPropagator.jsonValue, jsonString)) {
                        return selectedTracingPropagator;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    /* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$ViewTrackingStrategy;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "ACTIVITYVIEWTRACKINGSTRATEGY", "FRAGMENTVIEWTRACKINGSTRATEGY", "MIXEDVIEWTRACKINGSTRATEGY", "NAVIGATIONVIEWTRACKINGSTRATEGY", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum ViewTrackingStrategy {
        ACTIVITYVIEWTRACKINGSTRATEGY("ActivityViewTrackingStrategy"),
        FRAGMENTVIEWTRACKINGSTRATEGY("FragmentViewTrackingStrategy"),
        MIXEDVIEWTRACKINGSTRATEGY("MixedViewTrackingStrategy"),
        NAVIGATIONVIEWTRACKINGSTRATEGY("NavigationViewTrackingStrategy");


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String jsonValue;

        @JvmStatic
        public static final ViewTrackingStrategy fromJson(String str) {
            return INSTANCE.fromJson(str);
        }

        ViewTrackingStrategy(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        /* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$ViewTrackingStrategy$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$ViewTrackingStrategy;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final ViewTrackingStrategy fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (ViewTrackingStrategy viewTrackingStrategy : ViewTrackingStrategy.values()) {
                    if (Intrinsics.areEqual(viewTrackingStrategy.jsonValue, jsonString)) {
                        return viewTrackingStrategy;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    /* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$TrackFeatureFlagsForEvent;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "VITAL", "RESOURCE", "ACTION", "LONG_TASK", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum TrackFeatureFlagsForEvent {
        VITAL("vital"),
        RESOURCE("resource"),
        ACTION("action"),
        LONG_TASK("long_task");


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String jsonValue;

        @JvmStatic
        public static final TrackFeatureFlagsForEvent fromJson(String str) {
            return INSTANCE.fromJson(str);
        }

        TrackFeatureFlagsForEvent(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        /* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$TrackFeatureFlagsForEvent$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$TrackFeatureFlagsForEvent;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final TrackFeatureFlagsForEvent fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (TrackFeatureFlagsForEvent trackFeatureFlagsForEvent : TrackFeatureFlagsForEvent.values()) {
                    if (Intrinsics.areEqual(trackFeatureFlagsForEvent.jsonValue, jsonString)) {
                        return trackFeatureFlagsForEvent;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }

    /* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$TrackResourceHeaders;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "DEFAULT_HEADERS", "CUSTOM", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum TrackResourceHeaders {
        DEFAULT_HEADERS("default_headers"),
        CUSTOM("custom");


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String jsonValue;

        @JvmStatic
        public static final TrackResourceHeaders fromJson(String str) {
            return INSTANCE.fromJson(str);
        }

        TrackResourceHeaders(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        /* JADX INFO: compiled from: TelemetryConfigurationEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$TrackResourceHeaders$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$TrackResourceHeaders;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final TrackResourceHeaders fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                for (TrackResourceHeaders trackResourceHeaders : TrackResourceHeaders.values()) {
                    if (Intrinsics.areEqual(trackResourceHeaders.jsonValue, jsonString)) {
                        return trackResourceHeaders;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }
}

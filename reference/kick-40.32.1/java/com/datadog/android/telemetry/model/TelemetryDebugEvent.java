package com.datadog.android.telemetry.model;

import com.datadog.android.core.internal.utils.JsonSerializer;
import com.datadog.android.webview.internal.rum.WebViewRumEventMapper;
import com.google.android.gms.cast.CredentialsData;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
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

/* JADX INFO: compiled from: TelemetryDebugEvent.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u0000 J2\u00020\u0001:\nHIJKLMNOPQB\u0083\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018¢\u0006\u0002\u0010\u0019J\t\u00103\u001a\u00020\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u0011\u00105\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0016HÆ\u0003J\t\u00106\u001a\u00020\u0018HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0007HÆ\u0003J\t\u00109\u001a\u00020\tHÆ\u0003J\t\u0010:\u001a\u00020\u0007HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0093\u0001\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018HÆ\u0001J\u0013\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010C\u001a\u00020DHÖ\u0001J\u0006\u0010E\u001a\u00020FJ\t\u0010G\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0019\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b/\u0010'R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b0\u0010'R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b1\u00102¨\u0006R"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryDebugEvent;", "", "dd", "Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Dd;", "date", "", "service", "", "source", "Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Source;", "version", "application", "Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Application;", "session", "Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Session;", "view", "Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$View;", "action", "Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Action;", "effectiveSampleRate", "", "experimentalFeatures", "", "telemetry", "Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Telemetry;", "(Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Dd;JLjava/lang/String;Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Source;Ljava/lang/String;Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Application;Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Session;Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$View;Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Action;Ljava/lang/Number;Ljava/util/List;Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Telemetry;)V", "getAction", "()Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Action;", "getApplication", "()Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Application;", "getDate", "()J", "getDd", "()Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Dd;", "getEffectiveSampleRate", "()Ljava/lang/Number;", "getExperimentalFeatures", "()Ljava/util/List;", "getService", "()Ljava/lang/String;", "getSession", "()Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Session;", "getSource", "()Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Source;", "getTelemetry", "()Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Telemetry;", "type", "getType", "getVersion", "getView", "()Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$View;", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Action", "Application", "Companion", "Dd", "Device", "Os", "Session", "Source", "Telemetry", "View", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class TelemetryDebugEvent {

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
    public static /* synthetic */ TelemetryDebugEvent copy$default(TelemetryDebugEvent telemetryDebugEvent, Dd dd, long j, String str, Source source, String str2, Application application, Session session, View view, Action action, Number number, List list, Telemetry telemetry, int i, Object obj) {
        if ((i & 1) != 0) {
            dd = telemetryDebugEvent.dd;
        }
        return telemetryDebugEvent.copy(dd, (i & 2) != 0 ? telemetryDebugEvent.date : j, (i & 4) != 0 ? telemetryDebugEvent.service : str, (i & 8) != 0 ? telemetryDebugEvent.source : source, (i & 16) != 0 ? telemetryDebugEvent.version : str2, (i & 32) != 0 ? telemetryDebugEvent.application : application, (i & 64) != 0 ? telemetryDebugEvent.session : session, (i & 128) != 0 ? telemetryDebugEvent.view : view, (i & 256) != 0 ? telemetryDebugEvent.action : action, (i & 512) != 0 ? telemetryDebugEvent.effectiveSampleRate : number, (i & 1024) != 0 ? telemetryDebugEvent.experimentalFeatures : list, (i & 2048) != 0 ? telemetryDebugEvent.telemetry : telemetry);
    }

    @JvmStatic
    public static final TelemetryDebugEvent fromJson(String str) throws JsonParseException {
        return INSTANCE.fromJson(str);
    }

    @JvmStatic
    public static final TelemetryDebugEvent fromJsonObject(JsonObject jsonObject) throws JsonParseException {
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

    public final TelemetryDebugEvent copy(Dd dd, long date, String service, Source source, String version, Application application, Session session, View view, Action action, Number effectiveSampleRate, List<String> experimentalFeatures, Telemetry telemetry) {
        Intrinsics.checkNotNullParameter(dd, "dd");
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(telemetry, "telemetry");
        return new TelemetryDebugEvent(dd, date, service, source, version, application, session, view, action, effectiveSampleRate, experimentalFeatures, telemetry);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TelemetryDebugEvent)) {
            return false;
        }
        TelemetryDebugEvent telemetryDebugEvent = (TelemetryDebugEvent) other;
        return Intrinsics.areEqual(this.dd, telemetryDebugEvent.dd) && this.date == telemetryDebugEvent.date && Intrinsics.areEqual(this.service, telemetryDebugEvent.service) && this.source == telemetryDebugEvent.source && Intrinsics.areEqual(this.version, telemetryDebugEvent.version) && Intrinsics.areEqual(this.application, telemetryDebugEvent.application) && Intrinsics.areEqual(this.session, telemetryDebugEvent.session) && Intrinsics.areEqual(this.view, telemetryDebugEvent.view) && Intrinsics.areEqual(this.action, telemetryDebugEvent.action) && Intrinsics.areEqual(this.effectiveSampleRate, telemetryDebugEvent.effectiveSampleRate) && Intrinsics.areEqual(this.experimentalFeatures, telemetryDebugEvent.experimentalFeatures) && Intrinsics.areEqual(this.telemetry, telemetryDebugEvent.telemetry);
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
        return "TelemetryDebugEvent(dd=" + this.dd + ", date=" + this.date + ", service=" + this.service + ", source=" + this.source + ", version=" + this.version + ", application=" + this.application + ", session=" + this.session + ", view=" + this.view + ", action=" + this.action + ", effectiveSampleRate=" + this.effectiveSampleRate + ", experimentalFeatures=" + this.experimentalFeatures + ", telemetry=" + this.telemetry + ")";
    }

    public TelemetryDebugEvent(Dd dd, long j, String service, Source source, String version, Application application, Session session, View view, Action action, Number number, List<String> list, Telemetry telemetry) {
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

    public /* synthetic */ TelemetryDebugEvent(Dd dd, long j, String str, Source source, String str2, Application application, Session session, View view, Action action, Number number, List list, Telemetry telemetry, int i, DefaultConstructorMarker defaultConstructorMarker) {
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

    /* JADX INFO: compiled from: TelemetryDebugEvent.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/telemetry/model/TelemetryDebugEvent;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TelemetryDebugEvent fromJson(String jsonString) throws JsonParseException {
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            try {
                JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                return fromJsonObject(jsonObject);
            } catch (IllegalStateException e) {
                throw new JsonParseException("Unable to parse json into type TelemetryDebugEvent", e);
            }
        }

        @JvmStatic
        public final TelemetryDebugEvent fromJsonObject(JsonObject jsonObject) throws JsonParseException {
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
                return new TelemetryDebugEvent(ddFromJsonObject, asLong, service, sourceFromJson, version, applicationFromJsonObject, sessionFromJsonObject, viewFromJsonObject, actionFromJsonObject, asNumber, arrayList, telemetryFromJsonObject);
            } catch (IllegalStateException e) {
                throw new JsonParseException("Unable to parse json into type TelemetryDebugEvent", e);
            } catch (NullPointerException e2) {
                throw new JsonParseException("Unable to parse json into type TelemetryDebugEvent", e2);
            } catch (NumberFormatException e3) {
                throw new JsonParseException("Unable to parse json into type TelemetryDebugEvent", e3);
            }
        }
    }

    /* JADX INFO: compiled from: TelemetryDebugEvent.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Dd;", "", "()V", "formatVersion", "", "getFormatVersion", "()J", "toJson", "Lcom/google/gson/JsonElement;", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: TelemetryDebugEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Dd$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Dd;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: TelemetryDebugEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Application;", "", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: TelemetryDebugEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Application$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Application;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: TelemetryDebugEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Session;", "", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: TelemetryDebugEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Session$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Session;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: TelemetryDebugEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$View;", "", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: TelemetryDebugEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$View$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$View;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: TelemetryDebugEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Action;", "", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: TelemetryDebugEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Action$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Action;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: TelemetryDebugEvent.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u0017\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tHÆ\u0003JC\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0006\u0010!\u001a\u00020\"J\t\u0010#\u001a\u00020\u0007HÖ\u0001R\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006%"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Telemetry;", "", "device", "Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Device;", "os", "Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Os;", "message", "", "additionalProperties", "", "(Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Device;Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Os;Ljava/lang/String;Ljava/util/Map;)V", "getAdditionalProperties", "()Ljava/util/Map;", "getDevice", "()Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Device;", "getMessage", "()Ljava/lang/String;", "getOs", "()Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Os;", "status", "getStatus", "type", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Telemetry {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final String[] RESERVED_PROPERTIES = {"device", "os", "type", "status", "message"};
        private final Map<String, Object> additionalProperties;
        private final Device device;
        private final String message;
        private final Os os;
        private final String status;
        private final String type;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Telemetry copy$default(Telemetry telemetry, Device device, Os os, String str, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                device = telemetry.device;
            }
            if ((i & 2) != 0) {
                os = telemetry.os;
            }
            if ((i & 4) != 0) {
                str = telemetry.message;
            }
            if ((i & 8) != 0) {
                map = telemetry.additionalProperties;
            }
            return telemetry.copy(device, os, str, map);
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
        public final String getMessage() {
            return this.message;
        }

        public final Map<String, Object> component4() {
            return this.additionalProperties;
        }

        public final Telemetry copy(Device device, Os os, String message, Map<String, Object> additionalProperties) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            return new Telemetry(device, os, message, additionalProperties);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Telemetry)) {
                return false;
            }
            Telemetry telemetry = (Telemetry) other;
            return Intrinsics.areEqual(this.device, telemetry.device) && Intrinsics.areEqual(this.os, telemetry.os) && Intrinsics.areEqual(this.message, telemetry.message) && Intrinsics.areEqual(this.additionalProperties, telemetry.additionalProperties);
        }

        public int hashCode() {
            Device device = this.device;
            int iHashCode = (device == null ? 0 : device.hashCode()) * 31;
            Os os = this.os;
            return ((((iHashCode + (os != null ? os.hashCode() : 0)) * 31) + this.message.hashCode()) * 31) + this.additionalProperties.hashCode();
        }

        public String toString() {
            return "Telemetry(device=" + this.device + ", os=" + this.os + ", message=" + this.message + ", additionalProperties=" + this.additionalProperties + ")";
        }

        public Telemetry(Device device, Os os, String message, Map<String, Object> additionalProperties) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            this.device = device;
            this.os = os;
            this.message = message;
            this.additionalProperties = additionalProperties;
            this.type = "log";
            this.status = "debug";
        }

        public final Device getDevice() {
            return this.device;
        }

        public final Os getOs() {
            return this.os;
        }

        public final String getMessage() {
            return this.message;
        }

        public /* synthetic */ Telemetry(Device device, Os os, String str, LinkedHashMap linkedHashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : device, (i & 2) != 0 ? null : os, str, (i & 8) != 0 ? new LinkedHashMap() : linkedHashMap);
        }

        public final Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public final String getType() {
            return this.type;
        }

        public final String getStatus() {
            return this.status;
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
            jsonObject.addProperty("status", this.status);
            jsonObject.addProperty("message", this.message);
            for (Map.Entry<String, Object> entry : this.additionalProperties.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (!ArraysKt.contains(RESERVED_PROPERTIES, key)) {
                    jsonObject.add(key, JsonSerializer.INSTANCE.toJsonElement(value));
                }
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: TelemetryDebugEvent.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0007J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Telemetry$Companion;", "", "()V", "RESERVED_PROPERTIES", "", "", "getRESERVED_PROPERTIES$dd_sdk_android_rum_release", "()[Ljava/lang/String;", "[Ljava/lang/String;", "fromJson", "Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Telemetry;", "jsonString", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
                    Device deviceFromJsonObject = (jsonElement == null || (asJsonObject2 = jsonElement.getAsJsonObject()) == null) ? null : Device.INSTANCE.fromJsonObject(asJsonObject2);
                    JsonElement jsonElement2 = jsonObject.get("os");
                    Os osFromJsonObject = (jsonElement2 == null || (asJsonObject = jsonElement2.getAsJsonObject()) == null) ? null : Os.INSTANCE.fromJsonObject(asJsonObject);
                    JsonElement jsonElement3 = jsonObject.get("type");
                    String asString = jsonElement3 != null ? jsonElement3.getAsString() : null;
                    String asString2 = jsonObject.get("status").getAsString();
                    String message = jsonObject.get("message").getAsString();
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                        if (!ArraysKt.contains(getRESERVED_PROPERTIES$dd_sdk_android_rum_release(), entry.getKey())) {
                            String key = entry.getKey();
                            Intrinsics.checkNotNullExpressionValue(key, "entry.key");
                            linkedHashMap.put(key, entry.getValue());
                        }
                    }
                    if (asString != null && !Intrinsics.areEqual(asString, "log")) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    if (!Intrinsics.areEqual(asString2, "debug")) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    Intrinsics.checkNotNullExpressionValue(message, "message");
                    return new Telemetry(deviceFromJsonObject, osFromJsonObject, message, linkedHashMap);
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

    /* JADX INFO: compiled from: TelemetryDebugEvent.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u000fJV\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0006\u0010!\u001a\u00020\"J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\t\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006%"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Device;", "", "architecture", "", "brand", "model", "logicalCpuCount", "", "totalRam", "isLowRam", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Boolean;)V", "getArchitecture", "()Ljava/lang/String;", "getBrand", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLogicalCpuCount", "()Ljava/lang/Number;", "getModel", "getTotalRam", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Boolean;)Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Device;", "equals", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: TelemetryDebugEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Device$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Device;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: TelemetryDebugEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Os;", "", "build", "", "name", "version", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBuild", "()Ljava/lang/String;", "getName", "getVersion", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: TelemetryDebugEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Os$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Os;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: TelemetryDebugEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Source;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "ANDROID", "IOS", "BROWSER", "FLUTTER", "REACT_NATIVE", "UNITY", "KOTLIN_MULTIPLATFORM", "ELECTRON", "RUM_CPP", "MAUI", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: TelemetryDebugEvent.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Source$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/telemetry/model/TelemetryDebugEvent$Source;", "jsonString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
}

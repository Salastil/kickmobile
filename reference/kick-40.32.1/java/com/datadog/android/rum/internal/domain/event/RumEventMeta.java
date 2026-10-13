package com.datadog.android.rum.internal.domain.event;

import com.datadog.android.api.InternalLogger;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RumEventMeta.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \t2\u00020\u0001:\u0002\t\nB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0001\u000b¨\u0006\f"}, d2 = {"Lcom/datadog/android/rum/internal/domain/event/RumEventMeta;", "", "()V", "type", "", "getType", "()Ljava/lang/String;", "toJson", "Lcom/google/gson/JsonObject;", "Companion", "View", "Lcom/datadog/android/rum/internal/domain/event/RumEventMeta$View;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class RumEventMeta {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String DOCUMENT_VERSION_KEY = "documentVersion";
    public static final String HAS_ACCESSIBILITY_KEY = "hasAccessibility";
    public static final String TYPE_KEY = "type";
    private static final String UNABLE_TO_PARSE_JSON_INTO_META = "Unable to parse json into RUM event meta";
    private static final String UNKNOWN_RUM_EVENT_META_TYPE_ERROR = "Unknown RUM event meta type value [%s]";
    public static final String VIEW_ID_KEY = "viewId";
    public static final String VIEW_TYPE_VALUE = "view";

    public /* synthetic */ RumEventMeta(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getType();

    private RumEventMeta() {
    }

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", getType());
        return jsonObject;
    }

    /* JADX INFO: compiled from: RumEventMeta.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\fJ.\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/datadog/android/rum/internal/domain/event/RumEventMeta$View;", "Lcom/datadog/android/rum/internal/domain/event/RumEventMeta;", RumEventMeta.VIEW_ID_KEY, "", RumEventMeta.DOCUMENT_VERSION_KEY, "", RumEventMeta.HAS_ACCESSIBILITY_KEY, "", "(Ljava/lang/String;JLjava/lang/Boolean;)V", "getDocumentVersion", "()J", "getHasAccessibility", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "type", "getType", "()Ljava/lang/String;", "getViewId", "component1", "component2", "component3", "copy", "(Ljava/lang/String;JLjava/lang/Boolean;)Lcom/datadog/android/rum/internal/domain/event/RumEventMeta$View;", "equals", "other", "", "hashCode", "", "toJson", "Lcom/google/gson/JsonObject;", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class View extends RumEventMeta {
        private final long documentVersion;
        private final Boolean hasAccessibility;
        private final String type;
        private final String viewId;

        public static /* synthetic */ View copy$default(View view, String str, long j, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                str = view.viewId;
            }
            if ((i & 2) != 0) {
                j = view.documentVersion;
            }
            if ((i & 4) != 0) {
                bool = view.hasAccessibility;
            }
            return view.copy(str, j, bool);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getViewId() {
            return this.viewId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getDocumentVersion() {
            return this.documentVersion;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Boolean getHasAccessibility() {
            return this.hasAccessibility;
        }

        public final View copy(String viewId, long documentVersion, Boolean hasAccessibility) {
            Intrinsics.checkNotNullParameter(viewId, "viewId");
            return new View(viewId, documentVersion, hasAccessibility);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof View)) {
                return false;
            }
            View view = (View) other;
            return Intrinsics.areEqual(this.viewId, view.viewId) && this.documentVersion == view.documentVersion && Intrinsics.areEqual(this.hasAccessibility, view.hasAccessibility);
        }

        public int hashCode() {
            int iHashCode = ((this.viewId.hashCode() * 31) + Long.hashCode(this.documentVersion)) * 31;
            Boolean bool = this.hasAccessibility;
            return iHashCode + (bool == null ? 0 : bool.hashCode());
        }

        public String toString() {
            return "View(viewId=" + this.viewId + ", documentVersion=" + this.documentVersion + ", hasAccessibility=" + this.hasAccessibility + ")";
        }

        public final String getViewId() {
            return this.viewId;
        }

        public final long getDocumentVersion() {
            return this.documentVersion;
        }

        public /* synthetic */ View(String str, long j, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, j, (i & 4) != 0 ? false : bool);
        }

        public final Boolean getHasAccessibility() {
            return this.hasAccessibility;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public View(String viewId, long j, Boolean bool) {
            super(null);
            Intrinsics.checkNotNullParameter(viewId, "viewId");
            this.viewId = viewId;
            this.documentVersion = j;
            this.hasAccessibility = bool;
            this.type = "view";
        }

        @Override // com.datadog.android.rum.internal.domain.event.RumEventMeta
        public String getType() {
            return this.type;
        }

        @Override // com.datadog.android.rum.internal.domain.event.RumEventMeta
        public JsonObject toJson() {
            JsonObject json = super.toJson();
            json.addProperty(RumEventMeta.VIEW_ID_KEY, this.viewId);
            json.addProperty(RumEventMeta.DOCUMENT_VERSION_KEY, Long.valueOf(this.documentVersion));
            json.addProperty(RumEventMeta.HAS_ACCESSIBILITY_KEY, this.hasAccessibility);
            return json;
        }
    }

    /* JADX INFO: compiled from: RumEventMeta.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/datadog/android/rum/internal/domain/event/RumEventMeta$Companion;", "", "()V", "DOCUMENT_VERSION_KEY", "", "HAS_ACCESSIBILITY_KEY", "TYPE_KEY", "UNABLE_TO_PARSE_JSON_INTO_META", "UNKNOWN_RUM_EVENT_META_TYPE_ERROR", "VIEW_ID_KEY", "VIEW_TYPE_VALUE", "fromJson", "Lcom/datadog/android/rum/internal/domain/event/RumEventMeta;", "jsonString", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RumEventMeta fromJson(String jsonString, InternalLogger internalLogger) throws JsonParseException {
            View view;
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
            try {
                JsonObject asJsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                final String asString = asJsonObject.get("type").getAsString();
                if (Intrinsics.areEqual(asString, "view")) {
                    String viewId = asJsonObject.get(RumEventMeta.VIEW_ID_KEY).getAsString();
                    long asLong = asJsonObject.get(RumEventMeta.DOCUMENT_VERSION_KEY).getAsLong();
                    JsonElement jsonElement = asJsonObject.get(RumEventMeta.HAS_ACCESSIBILITY_KEY);
                    boolean asBoolean = jsonElement == null ? false : jsonElement.getAsBoolean();
                    Intrinsics.checkNotNullExpressionValue(viewId, "viewId");
                    view = new View(viewId, asLong, Boolean.valueOf(asBoolean));
                } else {
                    InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.event.RumEventMeta$Companion$fromJson$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            String str = String.format(Locale.US, "Unknown RUM event meta type value [%s]", Arrays.copyOf(new Object[]{asString}, 1));
                            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                            return str;
                        }
                    }, (Throwable) null, false, (Map) null, 56, (Object) null);
                    view = null;
                }
                return view;
            } catch (ClassCastException e) {
                throw new JsonParseException(RumEventMeta.UNABLE_TO_PARSE_JSON_INTO_META, e);
            } catch (IllegalStateException e2) {
                throw new JsonParseException(RumEventMeta.UNABLE_TO_PARSE_JSON_INTO_META, e2);
            } catch (NullPointerException e3) {
                throw new JsonParseException(RumEventMeta.UNABLE_TO_PARSE_JSON_INTO_META, e3);
            } catch (NumberFormatException e4) {
                throw new JsonParseException(RumEventMeta.UNABLE_TO_PARSE_JSON_INTO_META, e4);
            }
        }
    }
}

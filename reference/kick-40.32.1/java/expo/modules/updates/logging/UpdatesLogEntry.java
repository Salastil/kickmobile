package expo.modules.updates.logging;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: UpdatesLogEntry.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 -2\u00020\u0001:\u0001-BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u001c\u001a\u00020\u0005J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fHÆ\u0003Jl\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010&J\u0014\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010*\u001a\u00020+HÖ\u0081\u0004J\n\u0010,\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006."}, d2 = {"Lexpo/modules/updates/logging/UpdatesLogEntry;", "", "timestamp", "", "message", "", "code", FirebaseAnalytics.Param.LEVEL, "duration", "updateId", "assetId", "stacktrace", "", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getTimestamp", "()J", "getMessage", "()Ljava/lang/String;", "getCode", "getLevel", "getDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getUpdateId", "getAssetId", "getStacktrace", "()Ljava/util/List;", "asString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lexpo/modules/updates/logging/UpdatesLogEntry;", "equals", "", "other", "hashCode", "", "toString", "Companion", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class UpdatesLogEntry {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String assetId;
    private final String code;
    private final Long duration;
    private final String level;
    private final String message;
    private final List<String> stacktrace;
    private final long timestamp;
    private final String updateId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UpdatesLogEntry copy$default(UpdatesLogEntry updatesLogEntry, long j, String str, String str2, String str3, Long l, String str4, String str5, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            j = updatesLogEntry.timestamp;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = updatesLogEntry.message;
        }
        String str6 = str;
        if ((i & 4) != 0) {
            str2 = updatesLogEntry.code;
        }
        String str7 = str2;
        if ((i & 8) != 0) {
            str3 = updatesLogEntry.level;
        }
        return updatesLogEntry.copy(j2, str6, str7, str3, (i & 16) != 0 ? updatesLogEntry.duration : l, (i & 32) != 0 ? updatesLogEntry.updateId : str4, (i & 64) != 0 ? updatesLogEntry.assetId : str5, (i & 128) != 0 ? updatesLogEntry.stacktrace : list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLevel() {
        return this.level;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Long getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getUpdateId() {
        return this.updateId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getAssetId() {
        return this.assetId;
    }

    public final List<String> component8() {
        return this.stacktrace;
    }

    public final UpdatesLogEntry copy(long timestamp, String message, String code, String level, Long duration, String updateId, String assetId, List<String> stacktrace) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(level, "level");
        return new UpdatesLogEntry(timestamp, message, code, level, duration, updateId, assetId, stacktrace);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UpdatesLogEntry)) {
            return false;
        }
        UpdatesLogEntry updatesLogEntry = (UpdatesLogEntry) other;
        return this.timestamp == updatesLogEntry.timestamp && Intrinsics.areEqual(this.message, updatesLogEntry.message) && Intrinsics.areEqual(this.code, updatesLogEntry.code) && Intrinsics.areEqual(this.level, updatesLogEntry.level) && Intrinsics.areEqual(this.duration, updatesLogEntry.duration) && Intrinsics.areEqual(this.updateId, updatesLogEntry.updateId) && Intrinsics.areEqual(this.assetId, updatesLogEntry.assetId) && Intrinsics.areEqual(this.stacktrace, updatesLogEntry.stacktrace);
    }

    public int hashCode() {
        int iHashCode = ((((((Long.hashCode(this.timestamp) * 31) + this.message.hashCode()) * 31) + this.code.hashCode()) * 31) + this.level.hashCode()) * 31;
        Long l = this.duration;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.updateId;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.assetId;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<String> list = this.stacktrace;
        return iHashCode4 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "UpdatesLogEntry(timestamp=" + this.timestamp + ", message=" + this.message + ", code=" + this.code + ", level=" + this.level + ", duration=" + this.duration + ", updateId=" + this.updateId + ", assetId=" + this.assetId + ", stacktrace=" + this.stacktrace + ")";
    }

    public UpdatesLogEntry(long j, String message, String code, String level, Long l, String str, String str2, List<String> list) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(level, "level");
        this.timestamp = j;
        this.message = message;
        this.code = code;
        this.level = level;
        this.duration = l;
        this.updateId = str;
        this.assetId = str2;
        this.stacktrace = list;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getLevel() {
        return this.level;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final String getUpdateId() {
        return this.updateId;
    }

    public final String getAssetId() {
        return this.assetId;
    }

    public final List<String> getStacktrace() {
        return this.stacktrace;
    }

    public final String asString() throws JSONException {
        JSONObject jSONObject = new JSONObject(MapsKt.mapOf(TuplesKt.to("timestamp", Long.valueOf(this.timestamp)), TuplesKt.to("message", this.message), TuplesKt.to("code", this.code), TuplesKt.to(FirebaseAnalytics.Param.LEVEL, this.level)));
        Long l = this.duration;
        if (l != null) {
            jSONObject.put("duration", l.longValue());
        }
        String str = this.updateId;
        if (str != null) {
            jSONObject.put("updateId", str);
        }
        String str2 = this.assetId;
        if (str2 != null) {
            jSONObject.put("assetId", str2);
        }
        List<String> list = this.stacktrace;
        if (list != null && !list.isEmpty()) {
            jSONObject.put("stacktrace", new JSONArray((Collection) this.stacktrace));
        }
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX INFO: compiled from: UpdatesLogEntry.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0015\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lexpo/modules/updates/logging/UpdatesLogEntry$Companion;", "", "<init>", "()V", "create", "Lexpo/modules/updates/logging/UpdatesLogEntry;", "json", "", "getTimestamp", "", "(Ljava/lang/String;)Ljava/lang/Long;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UpdatesLogEntry create(String json) {
            Long lValueOf;
            String string;
            String string2;
            String string3;
            Long lValueOf2;
            Long l;
            String string4;
            String str;
            String string5;
            String str2;
            JSONArray jSONArray;
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(json, "json");
            try {
                JSONObject jSONObject = new JSONObject(json);
                if (Intrinsics.areEqual(Long.class, String.class)) {
                    Object string6 = jSONObject.getString("timestamp");
                    if (string6 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    lValueOf = (Long) string6;
                } else if (Intrinsics.areEqual(Long.class, Double.class)) {
                    lValueOf = (Long) Double.valueOf(jSONObject.getDouble("timestamp"));
                } else if (Intrinsics.areEqual(Long.class, Integer.class)) {
                    lValueOf = (Long) Integer.valueOf(jSONObject.getInt("timestamp"));
                } else if (Intrinsics.areEqual(Long.class, Long.class)) {
                    lValueOf = Long.valueOf(jSONObject.getLong("timestamp"));
                } else if (Intrinsics.areEqual(Long.class, Boolean.class)) {
                    lValueOf = (Long) Boolean.valueOf(jSONObject.getBoolean("timestamp"));
                } else if (Intrinsics.areEqual(Long.class, JSONArray.class)) {
                    Object jSONArray2 = jSONObject.getJSONArray("timestamp");
                    if (jSONArray2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    lValueOf = (Long) jSONArray2;
                } else if (Intrinsics.areEqual(Long.class, JSONObject.class)) {
                    Object jSONObject2 = jSONObject.getJSONObject("timestamp");
                    if (jSONObject2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    lValueOf = (Long) jSONObject2;
                } else {
                    Object obj = jSONObject.get("timestamp");
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    lValueOf = (Long) obj;
                }
                long jLongValue = lValueOf.longValue();
                if (Intrinsics.areEqual(String.class, String.class)) {
                    string = jSONObject.getString("message");
                    if (string == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(String.class, Double.class)) {
                    string = (String) Double.valueOf(jSONObject.getDouble("message"));
                } else if (Intrinsics.areEqual(String.class, Integer.class)) {
                    string = (String) Integer.valueOf(jSONObject.getInt("message"));
                } else if (Intrinsics.areEqual(String.class, Long.class)) {
                    string = (String) Long.valueOf(jSONObject.getLong("message"));
                } else if (Intrinsics.areEqual(String.class, Boolean.class)) {
                    string = (String) Boolean.valueOf(jSONObject.getBoolean("message"));
                } else if (Intrinsics.areEqual(String.class, JSONArray.class)) {
                    Object jSONArray3 = jSONObject.getJSONArray("message");
                    if (jSONArray3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    string = (String) jSONArray3;
                } else if (Intrinsics.areEqual(String.class, JSONObject.class)) {
                    Object jSONObject3 = jSONObject.getJSONObject("message");
                    if (jSONObject3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    string = (String) jSONObject3;
                } else {
                    Object obj2 = jSONObject.get("message");
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    string = (String) obj2;
                }
                String str3 = string;
                if (Intrinsics.areEqual(String.class, String.class)) {
                    string2 = jSONObject.getString("code");
                    if (string2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(String.class, Double.class)) {
                    string2 = (String) Double.valueOf(jSONObject.getDouble("code"));
                } else if (Intrinsics.areEqual(String.class, Integer.class)) {
                    string2 = (String) Integer.valueOf(jSONObject.getInt("code"));
                } else if (Intrinsics.areEqual(String.class, Long.class)) {
                    string2 = (String) Long.valueOf(jSONObject.getLong("code"));
                } else if (Intrinsics.areEqual(String.class, Boolean.class)) {
                    string2 = (String) Boolean.valueOf(jSONObject.getBoolean("code"));
                } else if (Intrinsics.areEqual(String.class, JSONArray.class)) {
                    Object jSONArray4 = jSONObject.getJSONArray("code");
                    if (jSONArray4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    string2 = (String) jSONArray4;
                } else if (Intrinsics.areEqual(String.class, JSONObject.class)) {
                    Object jSONObject4 = jSONObject.getJSONObject("code");
                    if (jSONObject4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    string2 = (String) jSONObject4;
                } else {
                    Object obj3 = jSONObject.get("code");
                    if (obj3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    string2 = (String) obj3;
                }
                String str4 = string2;
                if (Intrinsics.areEqual(String.class, String.class)) {
                    string3 = jSONObject.getString(FirebaseAnalytics.Param.LEVEL);
                    if (string3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(String.class, Double.class)) {
                    string3 = (String) Double.valueOf(jSONObject.getDouble(FirebaseAnalytics.Param.LEVEL));
                } else if (Intrinsics.areEqual(String.class, Integer.class)) {
                    string3 = (String) Integer.valueOf(jSONObject.getInt(FirebaseAnalytics.Param.LEVEL));
                } else if (Intrinsics.areEqual(String.class, Long.class)) {
                    string3 = (String) Long.valueOf(jSONObject.getLong(FirebaseAnalytics.Param.LEVEL));
                } else if (Intrinsics.areEqual(String.class, Boolean.class)) {
                    string3 = (String) Boolean.valueOf(jSONObject.getBoolean(FirebaseAnalytics.Param.LEVEL));
                } else if (Intrinsics.areEqual(String.class, JSONArray.class)) {
                    Object jSONArray5 = jSONObject.getJSONArray(FirebaseAnalytics.Param.LEVEL);
                    if (jSONArray5 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    string3 = (String) jSONArray5;
                } else if (Intrinsics.areEqual(String.class, JSONObject.class)) {
                    Object jSONObject5 = jSONObject.getJSONObject(FirebaseAnalytics.Param.LEVEL);
                    if (jSONObject5 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    string3 = (String) jSONObject5;
                } else {
                    Object obj4 = jSONObject.get(FirebaseAnalytics.Param.LEVEL);
                    if (obj4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    string3 = (String) obj4;
                }
                String str5 = string3;
                if (jSONObject.has("duration")) {
                    if (Intrinsics.areEqual(Long.class, String.class)) {
                        Object string7 = jSONObject.getString("duration");
                        if (string7 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        lValueOf2 = (Long) string7;
                    } else if (Intrinsics.areEqual(Long.class, Double.class)) {
                        lValueOf2 = (Long) Double.valueOf(jSONObject.getDouble("duration"));
                    } else if (Intrinsics.areEqual(Long.class, Integer.class)) {
                        lValueOf2 = (Long) Integer.valueOf(jSONObject.getInt("duration"));
                    } else if (Intrinsics.areEqual(Long.class, Long.class)) {
                        lValueOf2 = Long.valueOf(jSONObject.getLong("duration"));
                    } else if (Intrinsics.areEqual(Long.class, Boolean.class)) {
                        lValueOf2 = (Long) Boolean.valueOf(jSONObject.getBoolean("duration"));
                    } else if (Intrinsics.areEqual(Long.class, JSONArray.class)) {
                        Object jSONArray6 = jSONObject.getJSONArray("duration");
                        if (jSONArray6 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        lValueOf2 = (Long) jSONArray6;
                    } else if (Intrinsics.areEqual(Long.class, JSONObject.class)) {
                        Object jSONObject6 = jSONObject.getJSONObject("duration");
                        if (jSONObject6 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        lValueOf2 = (Long) jSONObject6;
                    } else {
                        Object obj5 = jSONObject.get("duration");
                        if (obj5 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        lValueOf2 = (Long) obj5;
                    }
                    l = lValueOf2;
                } else {
                    l = null;
                }
                if (jSONObject.has("updateId")) {
                    if (Intrinsics.areEqual(String.class, String.class)) {
                        string4 = jSONObject.getString("updateId");
                        if (string4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(String.class, Double.class)) {
                        string4 = (String) Double.valueOf(jSONObject.getDouble("updateId"));
                    } else if (Intrinsics.areEqual(String.class, Integer.class)) {
                        string4 = (String) Integer.valueOf(jSONObject.getInt("updateId"));
                    } else if (Intrinsics.areEqual(String.class, Long.class)) {
                        string4 = (String) Long.valueOf(jSONObject.getLong("updateId"));
                    } else if (Intrinsics.areEqual(String.class, Boolean.class)) {
                        string4 = (String) Boolean.valueOf(jSONObject.getBoolean("updateId"));
                    } else if (Intrinsics.areEqual(String.class, JSONArray.class)) {
                        Object jSONArray7 = jSONObject.getJSONArray("updateId");
                        if (jSONArray7 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        string4 = (String) jSONArray7;
                    } else if (Intrinsics.areEqual(String.class, JSONObject.class)) {
                        Object jSONObject7 = jSONObject.getJSONObject("updateId");
                        if (jSONObject7 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        string4 = (String) jSONObject7;
                    } else {
                        Object obj6 = jSONObject.get("updateId");
                        if (obj6 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        string4 = (String) obj6;
                    }
                    str = string4;
                } else {
                    str = null;
                }
                if (jSONObject.has("assetId")) {
                    if (Intrinsics.areEqual(String.class, String.class)) {
                        string5 = jSONObject.getString("assetId");
                        if (string5 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(String.class, Double.class)) {
                        string5 = (String) Double.valueOf(jSONObject.getDouble("assetId"));
                    } else if (Intrinsics.areEqual(String.class, Integer.class)) {
                        string5 = (String) Integer.valueOf(jSONObject.getInt("assetId"));
                    } else if (Intrinsics.areEqual(String.class, Long.class)) {
                        string5 = (String) Long.valueOf(jSONObject.getLong("assetId"));
                    } else if (Intrinsics.areEqual(String.class, Boolean.class)) {
                        string5 = (String) Boolean.valueOf(jSONObject.getBoolean("assetId"));
                    } else if (Intrinsics.areEqual(String.class, JSONArray.class)) {
                        Object jSONArray8 = jSONObject.getJSONArray("assetId");
                        if (jSONArray8 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        string5 = (String) jSONArray8;
                    } else if (Intrinsics.areEqual(String.class, JSONObject.class)) {
                        Object jSONObject8 = jSONObject.getJSONObject("assetId");
                        if (jSONObject8 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        string5 = (String) jSONObject8;
                    } else {
                        Object obj7 = jSONObject.get("assetId");
                        if (obj7 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        string5 = (String) obj7;
                    }
                    str2 = string5;
                } else {
                    str2 = null;
                }
                if (!jSONObject.has("stacktrace")) {
                    jSONArray = null;
                } else if (Intrinsics.areEqual(JSONArray.class, String.class)) {
                    Object string8 = jSONObject.getString("stacktrace");
                    if (string8 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
                    }
                    jSONArray = (JSONArray) string8;
                } else if (Intrinsics.areEqual(JSONArray.class, Double.class)) {
                    jSONArray = (JSONArray) Double.valueOf(jSONObject.getDouble("stacktrace"));
                } else if (Intrinsics.areEqual(JSONArray.class, Integer.class)) {
                    jSONArray = (JSONArray) Integer.valueOf(jSONObject.getInt("stacktrace"));
                } else if (Intrinsics.areEqual(JSONArray.class, Long.class)) {
                    jSONArray = (JSONArray) Long.valueOf(jSONObject.getLong("stacktrace"));
                } else if (Intrinsics.areEqual(JSONArray.class, Boolean.class)) {
                    jSONArray = (JSONArray) Boolean.valueOf(jSONObject.getBoolean("stacktrace"));
                } else if (Intrinsics.areEqual(JSONArray.class, JSONArray.class)) {
                    jSONArray = jSONObject.getJSONArray("stacktrace");
                    if (jSONArray == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
                    }
                } else if (Intrinsics.areEqual(JSONArray.class, JSONObject.class)) {
                    Object jSONObject9 = jSONObject.getJSONObject("stacktrace");
                    if (jSONObject9 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
                    }
                    jSONArray = (JSONArray) jSONObject9;
                } else {
                    Object obj8 = jSONObject.get("stacktrace");
                    if (obj8 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
                    }
                    jSONArray = (JSONArray) obj8;
                }
                if (jSONArray != null) {
                    int length = jSONArray.length();
                    ArrayList arrayList2 = new ArrayList(length);
                    for (int i = 0; i < length; i++) {
                        arrayList2.add(jSONArray.getString(i));
                    }
                    arrayList = arrayList2;
                } else {
                    arrayList = null;
                }
                return new UpdatesLogEntry(jLongValue, str3, str4, str5, l, str, str2, arrayList);
            } catch (Exception unused) {
                return null;
            }
        }

        public final Long getTimestamp(String json) {
            Object objM12684constructorimpl;
            Intrinsics.checkNotNullParameter(json, "json");
            try {
                Result.Companion companion = Result.INSTANCE;
                Companion companion2 = this;
                objM12684constructorimpl = Result.m12684constructorimpl(Long.valueOf(new JSONObject(json).getLong("timestamp")));
            } catch (Throwable th) {
                Result.Companion companion3 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                objM12684constructorimpl = null;
            }
            return (Long) objM12684constructorimpl;
        }
    }
}

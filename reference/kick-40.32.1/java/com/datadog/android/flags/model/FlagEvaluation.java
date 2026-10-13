package com.datadog.android.flags.model;

import com.datadog.android.core.internal.utils.JsonSerializer;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FlagEvaluation.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u0000 >2\u00020\u0001:\t=>?@ABCDEB\u0081\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010!J\u000b\u00101\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0094\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u00020\n2\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u000209HÖ\u0001J\u0006\u0010:\u001a\u00020;J\t\u0010<\u001a\u00020\fHÖ\u0001R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0016¨\u0006F"}, d2 = {"Lcom/datadog/android/flags/model/FlagEvaluation;", "", "timestamp", "", "flag", "Lcom/datadog/android/flags/model/FlagEvaluation$Identifier;", "firstEvaluation", "lastEvaluation", "evaluationCount", "runtimeDefaultUsed", "", "targetingKey", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/flags/model/FlagEvaluation$Context;", "variant", "allocation", "targetingRule", "error", "Lcom/datadog/android/flags/model/FlagEvaluation$Error;", "(JLcom/datadog/android/flags/model/FlagEvaluation$Identifier;JJJLjava/lang/Boolean;Ljava/lang/String;Lcom/datadog/android/flags/model/FlagEvaluation$Context;Lcom/datadog/android/flags/model/FlagEvaluation$Identifier;Lcom/datadog/android/flags/model/FlagEvaluation$Identifier;Lcom/datadog/android/flags/model/FlagEvaluation$Identifier;Lcom/datadog/android/flags/model/FlagEvaluation$Error;)V", "getAllocation", "()Lcom/datadog/android/flags/model/FlagEvaluation$Identifier;", "getContext", "()Lcom/datadog/android/flags/model/FlagEvaluation$Context;", "getError", "()Lcom/datadog/android/flags/model/FlagEvaluation$Error;", "getEvaluationCount", "()J", "getFirstEvaluation", "getFlag", "getLastEvaluation", "getRuntimeDefaultUsed", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTargetingKey", "()Ljava/lang/String;", "getTargetingRule", "getTimestamp", "getVariant", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLcom/datadog/android/flags/model/FlagEvaluation$Identifier;JJJLjava/lang/Boolean;Ljava/lang/String;Lcom/datadog/android/flags/model/FlagEvaluation$Context;Lcom/datadog/android/flags/model/FlagEvaluation$Identifier;Lcom/datadog/android/flags/model/FlagEvaluation$Identifier;Lcom/datadog/android/flags/model/FlagEvaluation$Identifier;Lcom/datadog/android/flags/model/FlagEvaluation$Error;)Lcom/datadog/android/flags/model/FlagEvaluation;", "equals", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Application", "Companion", "Context", "Dd", "Error", "Evaluation", "Identifier", "Rum", "View", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class FlagEvaluation {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Identifier allocation;
    private final Context context;
    private final Error error;
    private final long evaluationCount;
    private final long firstEvaluation;
    private final Identifier flag;
    private final long lastEvaluation;
    private final Boolean runtimeDefaultUsed;
    private final String targetingKey;
    private final Identifier targetingRule;
    private final long timestamp;
    private final Identifier variant;

    public static /* synthetic */ FlagEvaluation copy$default(FlagEvaluation flagEvaluation, long j, Identifier identifier, long j2, long j3, long j4, Boolean bool, String str, Context context, Identifier identifier2, Identifier identifier3, Identifier identifier4, Error error, int i, Object obj) {
        long j5 = (i & 1) != 0 ? flagEvaluation.timestamp : j;
        return flagEvaluation.copy(j5, (i & 2) != 0 ? flagEvaluation.flag : identifier, (i & 4) != 0 ? flagEvaluation.firstEvaluation : j2, (i & 8) != 0 ? flagEvaluation.lastEvaluation : j3, (i & 16) != 0 ? flagEvaluation.evaluationCount : j4, (i & 32) != 0 ? flagEvaluation.runtimeDefaultUsed : bool, (i & 64) != 0 ? flagEvaluation.targetingKey : str, (i & 128) != 0 ? flagEvaluation.context : context, (i & 256) != 0 ? flagEvaluation.variant : identifier2, (i & 512) != 0 ? flagEvaluation.allocation : identifier3, (i & 1024) != 0 ? flagEvaluation.targetingRule : identifier4, (i & 2048) != 0 ? flagEvaluation.error : error);
    }

    @JvmStatic
    public static final FlagEvaluation fromJson(String str) throws JsonParseException {
        return INSTANCE.fromJson(str);
    }

    @JvmStatic
    public static final FlagEvaluation fromJsonObject(JsonObject jsonObject) throws JsonParseException {
        return INSTANCE.fromJsonObject(jsonObject);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Identifier getAllocation() {
        return this.allocation;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Identifier getTargetingRule() {
        return this.targetingRule;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Error getError() {
        return this.error;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Identifier getFlag() {
        return this.flag;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getFirstEvaluation() {
        return this.firstEvaluation;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getLastEvaluation() {
        return this.lastEvaluation;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getEvaluationCount() {
        return this.evaluationCount;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Boolean getRuntimeDefaultUsed() {
        return this.runtimeDefaultUsed;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getTargetingKey() {
        return this.targetingKey;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Identifier getVariant() {
        return this.variant;
    }

    public final FlagEvaluation copy(long timestamp, Identifier flag, long firstEvaluation, long lastEvaluation, long evaluationCount, Boolean runtimeDefaultUsed, String targetingKey, Context context, Identifier variant, Identifier allocation, Identifier targetingRule, Error error) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        return new FlagEvaluation(timestamp, flag, firstEvaluation, lastEvaluation, evaluationCount, runtimeDefaultUsed, targetingKey, context, variant, allocation, targetingRule, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FlagEvaluation)) {
            return false;
        }
        FlagEvaluation flagEvaluation = (FlagEvaluation) other;
        return this.timestamp == flagEvaluation.timestamp && Intrinsics.areEqual(this.flag, flagEvaluation.flag) && this.firstEvaluation == flagEvaluation.firstEvaluation && this.lastEvaluation == flagEvaluation.lastEvaluation && this.evaluationCount == flagEvaluation.evaluationCount && Intrinsics.areEqual(this.runtimeDefaultUsed, flagEvaluation.runtimeDefaultUsed) && Intrinsics.areEqual(this.targetingKey, flagEvaluation.targetingKey) && Intrinsics.areEqual(this.context, flagEvaluation.context) && Intrinsics.areEqual(this.variant, flagEvaluation.variant) && Intrinsics.areEqual(this.allocation, flagEvaluation.allocation) && Intrinsics.areEqual(this.targetingRule, flagEvaluation.targetingRule) && Intrinsics.areEqual(this.error, flagEvaluation.error);
    }

    public int hashCode() {
        int iHashCode = ((((((((Long.hashCode(this.timestamp) * 31) + this.flag.hashCode()) * 31) + Long.hashCode(this.firstEvaluation)) * 31) + Long.hashCode(this.lastEvaluation)) * 31) + Long.hashCode(this.evaluationCount)) * 31;
        Boolean bool = this.runtimeDefaultUsed;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.targetingKey;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Context context = this.context;
        int iHashCode4 = (iHashCode3 + (context == null ? 0 : context.hashCode())) * 31;
        Identifier identifier = this.variant;
        int iHashCode5 = (iHashCode4 + (identifier == null ? 0 : identifier.hashCode())) * 31;
        Identifier identifier2 = this.allocation;
        int iHashCode6 = (iHashCode5 + (identifier2 == null ? 0 : identifier2.hashCode())) * 31;
        Identifier identifier3 = this.targetingRule;
        int iHashCode7 = (iHashCode6 + (identifier3 == null ? 0 : identifier3.hashCode())) * 31;
        Error error = this.error;
        return iHashCode7 + (error != null ? error.hashCode() : 0);
    }

    public String toString() {
        return "FlagEvaluation(timestamp=" + this.timestamp + ", flag=" + this.flag + ", firstEvaluation=" + this.firstEvaluation + ", lastEvaluation=" + this.lastEvaluation + ", evaluationCount=" + this.evaluationCount + ", runtimeDefaultUsed=" + this.runtimeDefaultUsed + ", targetingKey=" + this.targetingKey + ", context=" + this.context + ", variant=" + this.variant + ", allocation=" + this.allocation + ", targetingRule=" + this.targetingRule + ", error=" + this.error + ")";
    }

    public FlagEvaluation(long j, Identifier flag, long j2, long j3, long j4, Boolean bool, String str, Context context, Identifier identifier, Identifier identifier2, Identifier identifier3, Error error) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        this.timestamp = j;
        this.flag = flag;
        this.firstEvaluation = j2;
        this.lastEvaluation = j3;
        this.evaluationCount = j4;
        this.runtimeDefaultUsed = bool;
        this.targetingKey = str;
        this.context = context;
        this.variant = identifier;
        this.allocation = identifier2;
        this.targetingRule = identifier3;
        this.error = error;
    }

    public /* synthetic */ FlagEvaluation(long j, Identifier identifier, long j2, long j3, long j4, Boolean bool, String str, Context context, Identifier identifier2, Identifier identifier3, Identifier identifier4, Error error, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, identifier, j2, j3, j4, (i & 32) != 0 ? null : bool, (i & 64) != 0 ? null : str, (i & 128) != 0 ? null : context, (i & 256) != 0 ? null : identifier2, (i & 512) != 0 ? null : identifier3, (i & 1024) != 0 ? null : identifier4, (i & 2048) != 0 ? null : error);
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final Identifier getFlag() {
        return this.flag;
    }

    public final long getFirstEvaluation() {
        return this.firstEvaluation;
    }

    public final long getLastEvaluation() {
        return this.lastEvaluation;
    }

    public final long getEvaluationCount() {
        return this.evaluationCount;
    }

    public final Boolean getRuntimeDefaultUsed() {
        return this.runtimeDefaultUsed;
    }

    public final String getTargetingKey() {
        return this.targetingKey;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Identifier getVariant() {
        return this.variant;
    }

    public final Identifier getAllocation() {
        return this.allocation;
    }

    public final Identifier getTargetingRule() {
        return this.targetingRule;
    }

    public final Error getError() {
        return this.error;
    }

    public final JsonElement toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("timestamp", Long.valueOf(this.timestamp));
        jsonObject.add("flag", this.flag.toJson());
        jsonObject.addProperty("first_evaluation", Long.valueOf(this.firstEvaluation));
        jsonObject.addProperty("last_evaluation", Long.valueOf(this.lastEvaluation));
        jsonObject.addProperty("evaluation_count", Long.valueOf(this.evaluationCount));
        Boolean bool = this.runtimeDefaultUsed;
        if (bool != null) {
            bool.booleanValue();
            jsonObject.addProperty("runtime_default_used", bool);
        }
        String str = this.targetingKey;
        if (str != null) {
            jsonObject.addProperty("targeting_key", str);
        }
        Context context = this.context;
        if (context != null) {
            jsonObject.add(RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, context.toJson());
        }
        Identifier identifier = this.variant;
        if (identifier != null) {
            jsonObject.add("variant", identifier.toJson());
        }
        Identifier identifier2 = this.allocation;
        if (identifier2 != null) {
            jsonObject.add("allocation", identifier2.toJson());
        }
        Identifier identifier3 = this.targetingRule;
        if (identifier3 != null) {
            jsonObject.add("targeting_rule", identifier3.toJson());
        }
        Error error = this.error;
        if (error != null) {
            jsonObject.add("error", error.toJson());
        }
        return jsonObject;
    }

    /* JADX INFO: compiled from: FlagEvaluation.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/flags/model/FlagEvaluation$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/flags/model/FlagEvaluation;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FlagEvaluation fromJson(String jsonString) throws JsonParseException {
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            try {
                JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                return fromJsonObject(jsonObject);
            } catch (IllegalStateException e) {
                throw new JsonParseException("Unable to parse json into type FlagEvaluation", e);
            }
        }

        @JvmStatic
        public final FlagEvaluation fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            JsonObject asJsonObject;
            JsonObject asJsonObject2;
            JsonObject asJsonObject3;
            JsonObject asJsonObject4;
            JsonObject asJsonObject5;
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            try {
                long asLong = jsonObject.get("timestamp").getAsLong();
                JsonObject it = jsonObject.get("flag").getAsJsonObject();
                Identifier.Companion companion = Identifier.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                Identifier identifierFromJsonObject = companion.fromJsonObject(it);
                long asLong2 = jsonObject.get("first_evaluation").getAsLong();
                long asLong3 = jsonObject.get("last_evaluation").getAsLong();
                long asLong4 = jsonObject.get("evaluation_count").getAsLong();
                JsonElement jsonElement = jsonObject.get("runtime_default_used");
                Boolean boolValueOf = jsonElement != null ? Boolean.valueOf(jsonElement.getAsBoolean()) : null;
                JsonElement jsonElement2 = jsonObject.get("targeting_key");
                String asString = jsonElement2 != null ? jsonElement2.getAsString() : null;
                JsonElement jsonElement3 = jsonObject.get(RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX);
                Context contextFromJsonObject = (jsonElement3 == null || (asJsonObject5 = jsonElement3.getAsJsonObject()) == null) ? null : Context.INSTANCE.fromJsonObject(asJsonObject5);
                JsonElement jsonElement4 = jsonObject.get("variant");
                Identifier identifierFromJsonObject2 = (jsonElement4 == null || (asJsonObject4 = jsonElement4.getAsJsonObject()) == null) ? null : Identifier.INSTANCE.fromJsonObject(asJsonObject4);
                JsonElement jsonElement5 = jsonObject.get("allocation");
                Identifier identifierFromJsonObject3 = (jsonElement5 == null || (asJsonObject3 = jsonElement5.getAsJsonObject()) == null) ? null : Identifier.INSTANCE.fromJsonObject(asJsonObject3);
                JsonElement jsonElement6 = jsonObject.get("targeting_rule");
                Identifier identifierFromJsonObject4 = (jsonElement6 == null || (asJsonObject2 = jsonElement6.getAsJsonObject()) == null) ? null : Identifier.INSTANCE.fromJsonObject(asJsonObject2);
                JsonElement jsonElement7 = jsonObject.get("error");
                return new FlagEvaluation(asLong, identifierFromJsonObject, asLong2, asLong3, asLong4, boolValueOf, asString, contextFromJsonObject, identifierFromJsonObject2, identifierFromJsonObject3, identifierFromJsonObject4, (jsonElement7 == null || (asJsonObject = jsonElement7.getAsJsonObject()) == null) ? null : Error.INSTANCE.fromJsonObject(asJsonObject));
            } catch (IllegalStateException e) {
                throw new JsonParseException("Unable to parse json into type FlagEvaluation", e);
            } catch (NullPointerException e2) {
                throw new JsonParseException("Unable to parse json into type FlagEvaluation", e2);
            } catch (NumberFormatException e3) {
                throw new JsonParseException("Unable to parse json into type FlagEvaluation", e3);
            }
        }
    }

    /* JADX INFO: compiled from: FlagEvaluation.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/flags/model/FlagEvaluation$Identifier;", "", "key", "", "(Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Identifier {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String key;

        public static /* synthetic */ Identifier copy$default(Identifier identifier, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = identifier.key;
            }
            return identifier.copy(str);
        }

        @JvmStatic
        public static final Identifier fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Identifier fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        public final Identifier copy(String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return new Identifier(key);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Identifier) && Intrinsics.areEqual(this.key, ((Identifier) other).key);
        }

        public int hashCode() {
            return this.key.hashCode();
        }

        public String toString() {
            return "Identifier(key=" + this.key + ")";
        }

        public Identifier(String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.key = key;
        }

        public final String getKey() {
            return this.key;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("key", this.key);
            return jsonObject;
        }

        /* JADX INFO: compiled from: FlagEvaluation.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/flags/model/FlagEvaluation$Identifier$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/flags/model/FlagEvaluation$Identifier;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Identifier fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Identifier", e);
                }
            }

            @JvmStatic
            public final Identifier fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String key = jsonObject.get("key").getAsString();
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    return new Identifier(key);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Identifier", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Identifier", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Identifier", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: FlagEvaluation.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/datadog/android/flags/model/FlagEvaluation$Context;", "", "evaluation", "Lcom/datadog/android/flags/model/FlagEvaluation$Evaluation;", "dd", "Lcom/datadog/android/flags/model/FlagEvaluation$Dd;", "(Lcom/datadog/android/flags/model/FlagEvaluation$Evaluation;Lcom/datadog/android/flags/model/FlagEvaluation$Dd;)V", "getDd", "()Lcom/datadog/android/flags/model/FlagEvaluation$Dd;", "getEvaluation", "()Lcom/datadog/android/flags/model/FlagEvaluation$Evaluation;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Context {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Dd dd;
        private final Evaluation evaluation;

        /* JADX WARN: Multi-variable type inference failed */
        public Context() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Context copy$default(Context context, Evaluation evaluation, Dd dd, int i, Object obj) {
            if ((i & 1) != 0) {
                evaluation = context.evaluation;
            }
            if ((i & 2) != 0) {
                dd = context.dd;
            }
            return context.copy(evaluation, dd);
        }

        @JvmStatic
        public static final Context fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Context fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Evaluation getEvaluation() {
            return this.evaluation;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Dd getDd() {
            return this.dd;
        }

        public final Context copy(Evaluation evaluation, Dd dd) {
            return new Context(evaluation, dd);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Context)) {
                return false;
            }
            Context context = (Context) other;
            return Intrinsics.areEqual(this.evaluation, context.evaluation) && Intrinsics.areEqual(this.dd, context.dd);
        }

        public int hashCode() {
            Evaluation evaluation = this.evaluation;
            int iHashCode = (evaluation == null ? 0 : evaluation.hashCode()) * 31;
            Dd dd = this.dd;
            return iHashCode + (dd != null ? dd.hashCode() : 0);
        }

        public String toString() {
            return "Context(evaluation=" + this.evaluation + ", dd=" + this.dd + ")";
        }

        public Context(Evaluation evaluation, Dd dd) {
            this.evaluation = evaluation;
            this.dd = dd;
        }

        public /* synthetic */ Context(Evaluation evaluation, Dd dd, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : evaluation, (i & 2) != 0 ? null : dd);
        }

        public final Evaluation getEvaluation() {
            return this.evaluation;
        }

        public final Dd getDd() {
            return this.dd;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            Evaluation evaluation = this.evaluation;
            if (evaluation != null) {
                jsonObject.add("evaluation", evaluation.toJson());
            }
            Dd dd = this.dd;
            if (dd != null) {
                jsonObject.add("dd", dd.toJson());
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: FlagEvaluation.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/flags/model/FlagEvaluation$Context$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/flags/model/FlagEvaluation$Context;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
                JsonObject asJsonObject;
                JsonObject asJsonObject2;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get("evaluation");
                    Dd ddFromJsonObject = null;
                    Evaluation evaluationFromJsonObject = (jsonElement == null || (asJsonObject2 = jsonElement.getAsJsonObject()) == null) ? null : Evaluation.INSTANCE.fromJsonObject(asJsonObject2);
                    JsonElement jsonElement2 = jsonObject.get("dd");
                    if (jsonElement2 != null && (asJsonObject = jsonElement2.getAsJsonObject()) != null) {
                        ddFromJsonObject = Dd.INSTANCE.fromJsonObject(asJsonObject);
                    }
                    return new Context(evaluationFromJsonObject, ddFromJsonObject);
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

    /* JADX INFO: compiled from: FlagEvaluation.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/flags/model/FlagEvaluation$Error;", "", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Error {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String message;

        public static /* synthetic */ Error copy$default(Error error, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = error.message;
            }
            return error.copy(str);
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
        public final String getMessage() {
            return this.message;
        }

        public final Error copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new Error(message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Error) && Intrinsics.areEqual(this.message, ((Error) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "Error(message=" + this.message + ")";
        }

        public Error(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public final String getMessage() {
            return this.message;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("message", this.message);
            return jsonObject;
        }

        /* JADX INFO: compiled from: FlagEvaluation.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/flags/model/FlagEvaluation$Error$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/flags/model/FlagEvaluation$Error;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
                    String message = jsonObject.get("message").getAsString();
                    Intrinsics.checkNotNullExpressionValue(message, "message");
                    return new Error(message);
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

    /* JADX INFO: compiled from: FlagEvaluation.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001d\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0017\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003HÆ\u0003J!\u0010\t\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/datadog/android/flags/model/FlagEvaluation$Evaluation;", "", "additionalProperties", "", "", "(Ljava/util/Map;)V", "getAdditionalProperties", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Evaluation {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Map<String, Object> additionalProperties;

        /* JADX WARN: Multi-variable type inference failed */
        public Evaluation() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Evaluation copy$default(Evaluation evaluation, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                map = evaluation.additionalProperties;
            }
            return evaluation.copy(map);
        }

        @JvmStatic
        public static final Evaluation fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Evaluation fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        public final Map<String, Object> component1() {
            return this.additionalProperties;
        }

        public final Evaluation copy(Map<String, Object> additionalProperties) {
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            return new Evaluation(additionalProperties);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Evaluation) && Intrinsics.areEqual(this.additionalProperties, ((Evaluation) other).additionalProperties);
        }

        public int hashCode() {
            return this.additionalProperties.hashCode();
        }

        public String toString() {
            return "Evaluation(additionalProperties=" + this.additionalProperties + ")";
        }

        public Evaluation(Map<String, Object> additionalProperties) {
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            this.additionalProperties = additionalProperties;
        }

        public /* synthetic */ Evaluation(LinkedHashMap linkedHashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
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

        /* JADX INFO: compiled from: FlagEvaluation.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/flags/model/FlagEvaluation$Evaluation$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/flags/model/FlagEvaluation$Evaluation;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Evaluation fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Evaluation", e);
                }
            }

            @JvmStatic
            public final Evaluation fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                        String key = entry.getKey();
                        Intrinsics.checkNotNullExpressionValue(key, "entry.key");
                        linkedHashMap.put(key, entry.getValue());
                    }
                    return new Evaluation(linkedHashMap);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Evaluation", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Evaluation", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Evaluation", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: FlagEvaluation.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0017\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0006\u0010\u0018\u001a\u00020\u0019J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/datadog/android/flags/model/FlagEvaluation$Dd;", "", "service", "", "rum", "Lcom/datadog/android/flags/model/FlagEvaluation$Rum;", "additionalProperties", "", "(Ljava/lang/String;Lcom/datadog/android/flags/model/FlagEvaluation$Rum;Ljava/util/Map;)V", "getAdditionalProperties", "()Ljava/util/Map;", "getRum", "()Lcom/datadog/android/flags/model/FlagEvaluation$Rum;", "getService", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Dd {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final String[] RESERVED_PROPERTIES = {"service", "rum"};
        private final Map<String, Object> additionalProperties;
        private final Rum rum;
        private final String service;

        public Dd() {
            this(null, null, null, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Dd copy$default(Dd dd, String str, Rum rum, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = dd.service;
            }
            if ((i & 2) != 0) {
                rum = dd.rum;
            }
            if ((i & 4) != 0) {
                map = dd.additionalProperties;
            }
            return dd.copy(str, rum, map);
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
        public final String getService() {
            return this.service;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Rum getRum() {
            return this.rum;
        }

        public final Map<String, Object> component3() {
            return this.additionalProperties;
        }

        public final Dd copy(String service, Rum rum, Map<String, Object> additionalProperties) {
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            return new Dd(service, rum, additionalProperties);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Dd)) {
                return false;
            }
            Dd dd = (Dd) other;
            return Intrinsics.areEqual(this.service, dd.service) && Intrinsics.areEqual(this.rum, dd.rum) && Intrinsics.areEqual(this.additionalProperties, dd.additionalProperties);
        }

        public int hashCode() {
            String str = this.service;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            Rum rum = this.rum;
            return ((iHashCode + (rum != null ? rum.hashCode() : 0)) * 31) + this.additionalProperties.hashCode();
        }

        public String toString() {
            return "Dd(service=" + this.service + ", rum=" + this.rum + ", additionalProperties=" + this.additionalProperties + ")";
        }

        public Dd(String str, Rum rum, Map<String, Object> additionalProperties) {
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            this.service = str;
            this.rum = rum;
            this.additionalProperties = additionalProperties;
        }

        public final String getService() {
            return this.service;
        }

        public final Rum getRum() {
            return this.rum;
        }

        public /* synthetic */ Dd(String str, Rum rum, LinkedHashMap linkedHashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : rum, (i & 4) != 0 ? new LinkedHashMap() : linkedHashMap);
        }

        public final Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            String str = this.service;
            if (str != null) {
                jsonObject.addProperty("service", str);
            }
            Rum rum = this.rum;
            if (rum != null) {
                jsonObject.add("rum", rum.toJson());
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

        /* JADX INFO: compiled from: FlagEvaluation.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0007J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/flags/model/FlagEvaluation$Dd$Companion;", "", "()V", "RESERVED_PROPERTIES", "", "", "getRESERVED_PROPERTIES$dd_sdk_android_flags_release", "()[Ljava/lang/String;", "[Ljava/lang/String;", "fromJson", "Lcom/datadog/android/flags/model/FlagEvaluation$Dd;", "jsonString", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final String[] getRESERVED_PROPERTIES$dd_sdk_android_flags_release() {
                return Dd.RESERVED_PROPERTIES;
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
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get("service");
                    Rum rumFromJsonObject = null;
                    String asString = jsonElement != null ? jsonElement.getAsString() : null;
                    JsonElement jsonElement2 = jsonObject.get("rum");
                    if (jsonElement2 != null && (asJsonObject = jsonElement2.getAsJsonObject()) != null) {
                        rumFromJsonObject = Rum.INSTANCE.fromJsonObject(asJsonObject);
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                        if (!ArraysKt.contains(getRESERVED_PROPERTIES$dd_sdk_android_flags_release(), entry.getKey())) {
                            String key = entry.getKey();
                            Intrinsics.checkNotNullExpressionValue(key, "entry.key");
                            linkedHashMap.put(key, entry.getValue());
                        }
                    }
                    return new Dd(asString, rumFromJsonObject, linkedHashMap);
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

    /* JADX INFO: compiled from: FlagEvaluation.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/datadog/android/flags/model/FlagEvaluation$Rum;", "", "application", "Lcom/datadog/android/flags/model/FlagEvaluation$Application;", "view", "Lcom/datadog/android/flags/model/FlagEvaluation$View;", "(Lcom/datadog/android/flags/model/FlagEvaluation$Application;Lcom/datadog/android/flags/model/FlagEvaluation$View;)V", "getApplication", "()Lcom/datadog/android/flags/model/FlagEvaluation$Application;", "getView", "()Lcom/datadog/android/flags/model/FlagEvaluation$View;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Rum {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Application application;
        private final View view;

        /* JADX WARN: Multi-variable type inference failed */
        public Rum() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Rum copy$default(Rum rum, Application application, View view, int i, Object obj) {
            if ((i & 1) != 0) {
                application = rum.application;
            }
            if ((i & 2) != 0) {
                view = rum.view;
            }
            return rum.copy(application, view);
        }

        @JvmStatic
        public static final Rum fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Rum fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Application getApplication() {
            return this.application;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final View getView() {
            return this.view;
        }

        public final Rum copy(Application application, View view) {
            return new Rum(application, view);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Rum)) {
                return false;
            }
            Rum rum = (Rum) other;
            return Intrinsics.areEqual(this.application, rum.application) && Intrinsics.areEqual(this.view, rum.view);
        }

        public int hashCode() {
            Application application = this.application;
            int iHashCode = (application == null ? 0 : application.hashCode()) * 31;
            View view = this.view;
            return iHashCode + (view != null ? view.hashCode() : 0);
        }

        public String toString() {
            return "Rum(application=" + this.application + ", view=" + this.view + ")";
        }

        public Rum(Application application, View view) {
            this.application = application;
            this.view = view;
        }

        public /* synthetic */ Rum(Application application, View view, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : application, (i & 2) != 0 ? null : view);
        }

        public final Application getApplication() {
            return this.application;
        }

        public final View getView() {
            return this.view;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            Application application = this.application;
            if (application != null) {
                jsonObject.add("application", application.toJson());
            }
            View view = this.view;
            if (view != null) {
                jsonObject.add("view", view.toJson());
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: FlagEvaluation.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/flags/model/FlagEvaluation$Rum$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/flags/model/FlagEvaluation$Rum;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Rum fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Rum", e);
                }
            }

            @JvmStatic
            public final Rum fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                JsonObject asJsonObject;
                JsonObject asJsonObject2;
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    JsonElement jsonElement = jsonObject.get("application");
                    View viewFromJsonObject = null;
                    Application applicationFromJsonObject = (jsonElement == null || (asJsonObject2 = jsonElement.getAsJsonObject()) == null) ? null : Application.INSTANCE.fromJsonObject(asJsonObject2);
                    JsonElement jsonElement2 = jsonObject.get("view");
                    if (jsonElement2 != null && (asJsonObject = jsonElement2.getAsJsonObject()) != null) {
                        viewFromJsonObject = View.INSTANCE.fromJsonObject(asJsonObject);
                    }
                    return new Rum(applicationFromJsonObject, viewFromJsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Rum", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Rum", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Rum", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: FlagEvaluation.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/flags/model/FlagEvaluation$Application;", "", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Application {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String id;

        /* JADX WARN: Multi-variable type inference failed */
        public Application() {
            this(null, 1, 0 == true ? 1 : 0);
        }

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
            return new Application(id);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Application) && Intrinsics.areEqual(this.id, ((Application) other).id);
        }

        public int hashCode() {
            String str = this.id;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "Application(id=" + this.id + ")";
        }

        public Application(String str) {
            this.id = str;
        }

        public /* synthetic */ Application(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        public final String getId() {
            return this.id;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            String str = this.id;
            if (str != null) {
                jsonObject.addProperty("id", str);
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: FlagEvaluation.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/flags/model/FlagEvaluation$Application$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/flags/model/FlagEvaluation$Application;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
                    JsonElement jsonElement = jsonObject.get("id");
                    return new Application(jsonElement != null ? jsonElement.getAsString() : null);
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

    /* JADX INFO: compiled from: FlagEvaluation.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/flags/model/FlagEvaluation$View;", "", ImagesContract.URL, "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class View {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String url;

        /* JADX WARN: Multi-variable type inference failed */
        public View() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ View copy$default(View view, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = view.url;
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
        public final String getUrl() {
            return this.url;
        }

        public final View copy(String url) {
            return new View(url);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof View) && Intrinsics.areEqual(this.url, ((View) other).url);
        }

        public int hashCode() {
            String str = this.url;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "View(url=" + this.url + ")";
        }

        public View(String str) {
            this.url = str;
        }

        public /* synthetic */ View(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        public final String getUrl() {
            return this.url;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            String str = this.url;
            if (str != null) {
                jsonObject.addProperty(ImagesContract.URL, str);
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: FlagEvaluation.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/flags/model/FlagEvaluation$View$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/flags/model/FlagEvaluation$View;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
                    JsonElement jsonElement = jsonObject.get(ImagesContract.URL);
                    return new View(jsonElement != null ? jsonElement.getAsString() : null);
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
}

package com.datadog.android.flags.model;

import com.datadog.android.rum.internal.RumFeature;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExposureEvent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u0000 )2\u00020\u0001:\u0004()*+B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010JL\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0006\u0010$\u001a\u00020%J\t\u0010&\u001a\u00020'HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\r¨\u0006,"}, d2 = {"Lcom/datadog/android/flags/model/ExposureEvent;", "", "timestamp", "", "allocation", "Lcom/datadog/android/flags/model/ExposureEvent$Identifier;", "flag", "variant", "subject", "Lcom/datadog/android/flags/model/ExposureEvent$Subject;", "serialId", "(JLcom/datadog/android/flags/model/ExposureEvent$Identifier;Lcom/datadog/android/flags/model/ExposureEvent$Identifier;Lcom/datadog/android/flags/model/ExposureEvent$Identifier;Lcom/datadog/android/flags/model/ExposureEvent$Subject;Ljava/lang/Long;)V", "getAllocation", "()Lcom/datadog/android/flags/model/ExposureEvent$Identifier;", "getFlag", "getSerialId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSubject", "()Lcom/datadog/android/flags/model/ExposureEvent$Subject;", "getTimestamp", "()J", "getVariant", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(JLcom/datadog/android/flags/model/ExposureEvent$Identifier;Lcom/datadog/android/flags/model/ExposureEvent$Identifier;Lcom/datadog/android/flags/model/ExposureEvent$Identifier;Lcom/datadog/android/flags/model/ExposureEvent$Subject;Ljava/lang/Long;)Lcom/datadog/android/flags/model/ExposureEvent;", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Attributes", "Companion", "Identifier", "Subject", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ExposureEvent {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Identifier allocation;
    private final Identifier flag;
    private final Long serialId;
    private final Subject subject;
    private final long timestamp;
    private final Identifier variant;

    public static /* synthetic */ ExposureEvent copy$default(ExposureEvent exposureEvent, long j, Identifier identifier, Identifier identifier2, Identifier identifier3, Subject subject, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            j = exposureEvent.timestamp;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            identifier = exposureEvent.allocation;
        }
        Identifier identifier4 = identifier;
        if ((i & 4) != 0) {
            identifier2 = exposureEvent.flag;
        }
        Identifier identifier5 = identifier2;
        if ((i & 8) != 0) {
            identifier3 = exposureEvent.variant;
        }
        Identifier identifier6 = identifier3;
        if ((i & 16) != 0) {
            subject = exposureEvent.subject;
        }
        Subject subject2 = subject;
        if ((i & 32) != 0) {
            l = exposureEvent.serialId;
        }
        return exposureEvent.copy(j2, identifier4, identifier5, identifier6, subject2, l);
    }

    @JvmStatic
    public static final ExposureEvent fromJson(String str) throws JsonParseException {
        return INSTANCE.fromJson(str);
    }

    @JvmStatic
    public static final ExposureEvent fromJsonObject(JsonObject jsonObject) throws JsonParseException {
        return INSTANCE.fromJsonObject(jsonObject);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Identifier getAllocation() {
        return this.allocation;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Identifier getFlag() {
        return this.flag;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Identifier getVariant() {
        return this.variant;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Subject getSubject() {
        return this.subject;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Long getSerialId() {
        return this.serialId;
    }

    public final ExposureEvent copy(long timestamp, Identifier allocation, Identifier flag, Identifier variant, Subject subject, Long serialId) {
        Intrinsics.checkNotNullParameter(allocation, "allocation");
        Intrinsics.checkNotNullParameter(flag, "flag");
        Intrinsics.checkNotNullParameter(variant, "variant");
        Intrinsics.checkNotNullParameter(subject, "subject");
        return new ExposureEvent(timestamp, allocation, flag, variant, subject, serialId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExposureEvent)) {
            return false;
        }
        ExposureEvent exposureEvent = (ExposureEvent) other;
        return this.timestamp == exposureEvent.timestamp && Intrinsics.areEqual(this.allocation, exposureEvent.allocation) && Intrinsics.areEqual(this.flag, exposureEvent.flag) && Intrinsics.areEqual(this.variant, exposureEvent.variant) && Intrinsics.areEqual(this.subject, exposureEvent.subject) && Intrinsics.areEqual(this.serialId, exposureEvent.serialId);
    }

    public int hashCode() {
        int iHashCode = ((((((((Long.hashCode(this.timestamp) * 31) + this.allocation.hashCode()) * 31) + this.flag.hashCode()) * 31) + this.variant.hashCode()) * 31) + this.subject.hashCode()) * 31;
        Long l = this.serialId;
        return iHashCode + (l == null ? 0 : l.hashCode());
    }

    public String toString() {
        return "ExposureEvent(timestamp=" + this.timestamp + ", allocation=" + this.allocation + ", flag=" + this.flag + ", variant=" + this.variant + ", subject=" + this.subject + ", serialId=" + this.serialId + ")";
    }

    public ExposureEvent(long j, Identifier allocation, Identifier flag, Identifier variant, Subject subject, Long l) {
        Intrinsics.checkNotNullParameter(allocation, "allocation");
        Intrinsics.checkNotNullParameter(flag, "flag");
        Intrinsics.checkNotNullParameter(variant, "variant");
        Intrinsics.checkNotNullParameter(subject, "subject");
        this.timestamp = j;
        this.allocation = allocation;
        this.flag = flag;
        this.variant = variant;
        this.subject = subject;
        this.serialId = l;
    }

    public /* synthetic */ ExposureEvent(long j, Identifier identifier, Identifier identifier2, Identifier identifier3, Subject subject, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, identifier, identifier2, identifier3, subject, (i & 32) != 0 ? null : l);
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final Identifier getAllocation() {
        return this.allocation;
    }

    public final Identifier getFlag() {
        return this.flag;
    }

    public final Identifier getVariant() {
        return this.variant;
    }

    public final Subject getSubject() {
        return this.subject;
    }

    public final Long getSerialId() {
        return this.serialId;
    }

    public final JsonElement toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("timestamp", Long.valueOf(this.timestamp));
        jsonObject.add("allocation", this.allocation.toJson());
        jsonObject.add("flag", this.flag.toJson());
        jsonObject.add("variant", this.variant.toJson());
        jsonObject.add("subject", this.subject.toJson());
        Long l = this.serialId;
        if (l != null) {
            jsonObject.addProperty("serial_id", Long.valueOf(l.longValue()));
        }
        return jsonObject;
    }

    /* JADX INFO: compiled from: ExposureEvent.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/flags/model/ExposureEvent$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/flags/model/ExposureEvent;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ExposureEvent fromJson(String jsonString) throws JsonParseException {
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            try {
                JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                return fromJsonObject(jsonObject);
            } catch (IllegalStateException e) {
                throw new JsonParseException("Unable to parse json into type ExposureEvent", e);
            }
        }

        @JvmStatic
        public final ExposureEvent fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            try {
                long asLong = jsonObject.get("timestamp").getAsLong();
                JsonObject it = jsonObject.get("allocation").getAsJsonObject();
                Identifier.Companion companion = Identifier.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                Identifier identifierFromJsonObject = companion.fromJsonObject(it);
                JsonObject it2 = jsonObject.get("flag").getAsJsonObject();
                Identifier.Companion companion2 = Identifier.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Identifier identifierFromJsonObject2 = companion2.fromJsonObject(it2);
                JsonObject it3 = jsonObject.get("variant").getAsJsonObject();
                Identifier.Companion companion3 = Identifier.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it3, "it");
                Identifier identifierFromJsonObject3 = companion3.fromJsonObject(it3);
                JsonObject it4 = jsonObject.get("subject").getAsJsonObject();
                Subject.Companion companion4 = Subject.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it4, "it");
                Subject subjectFromJsonObject = companion4.fromJsonObject(it4);
                JsonElement jsonElement = jsonObject.get("serial_id");
                return new ExposureEvent(asLong, identifierFromJsonObject, identifierFromJsonObject2, identifierFromJsonObject3, subjectFromJsonObject, jsonElement != null ? Long.valueOf(jsonElement.getAsLong()) : null);
            } catch (IllegalStateException e) {
                throw new JsonParseException("Unable to parse json into type ExposureEvent", e);
            } catch (NullPointerException e2) {
                throw new JsonParseException("Unable to parse json into type ExposureEvent", e2);
            } catch (NumberFormatException e3) {
                throw new JsonParseException("Unable to parse json into type ExposureEvent", e3);
            }
        }
    }

    /* JADX INFO: compiled from: ExposureEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/flags/model/ExposureEvent$Identifier;", "", "key", "", "(Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

        /* JADX INFO: compiled from: ExposureEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/flags/model/ExposureEvent$Identifier$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/flags/model/ExposureEvent$Identifier;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX INFO: compiled from: ExposureEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/datadog/android/flags/model/ExposureEvent$Subject;", "", "id", "", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "Lcom/datadog/android/flags/model/ExposureEvent$Attributes;", "(Ljava/lang/String;Lcom/datadog/android/flags/model/ExposureEvent$Attributes;)V", "getAttributes", "()Lcom/datadog/android/flags/model/ExposureEvent$Attributes;", "getId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Subject {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Attributes attributes;
        private final String id;

        public static /* synthetic */ Subject copy$default(Subject subject, String str, Attributes attributes, int i, Object obj) {
            if ((i & 1) != 0) {
                str = subject.id;
            }
            if ((i & 2) != 0) {
                attributes = subject.attributes;
            }
            return subject.copy(str, attributes);
        }

        @JvmStatic
        public static final Subject fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Subject fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Attributes getAttributes() {
            return this.attributes;
        }

        public final Subject copy(String id, Attributes attributes) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            return new Subject(id, attributes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Subject)) {
                return false;
            }
            Subject subject = (Subject) other;
            return Intrinsics.areEqual(this.id, subject.id) && Intrinsics.areEqual(this.attributes, subject.attributes);
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.attributes.hashCode();
        }

        public String toString() {
            return "Subject(id=" + this.id + ", attributes=" + this.attributes + ")";
        }

        public Subject(String id, Attributes attributes) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            this.id = id;
            this.attributes = attributes;
        }

        public final String getId() {
            return this.id;
        }

        public final Attributes getAttributes() {
            return this.attributes;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id", this.id);
            jsonObject.add(RumFeature.EVENT_ATTRIBUTES_PROPERTY, this.attributes.toJson());
            return jsonObject;
        }

        /* JADX INFO: compiled from: ExposureEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/flags/model/ExposureEvent$Subject$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/flags/model/ExposureEvent$Subject;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Subject fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Subject", e);
                }
            }

            @JvmStatic
            public final Subject fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    String id = jsonObject.get("id").getAsString();
                    JsonObject it = jsonObject.get(RumFeature.EVENT_ATTRIBUTES_PROPERTY).getAsJsonObject();
                    Attributes.Companion companion = Attributes.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    Attributes attributesFromJsonObject = companion.fromJsonObject(it);
                    Intrinsics.checkNotNullExpressionValue(id, "id");
                    return new Subject(id, attributesFromJsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Subject", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Subject", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Subject", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ExposureEvent.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001b\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0015\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u001f\u0010\t\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/datadog/android/flags/model/ExposureEvent$Attributes;", "", "additionalProperties", "", "", "(Ljava/util/Map;)V", "getAdditionalProperties", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Attributes {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Map<String, String> additionalProperties;

        /* JADX WARN: Multi-variable type inference failed */
        public Attributes() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Attributes copy$default(Attributes attributes, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                map = attributes.additionalProperties;
            }
            return attributes.copy(map);
        }

        @JvmStatic
        public static final Attributes fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        @JvmStatic
        public static final Attributes fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            return INSTANCE.fromJsonObject(jsonObject);
        }

        public final Map<String, String> component1() {
            return this.additionalProperties;
        }

        public final Attributes copy(Map<String, String> additionalProperties) {
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            return new Attributes(additionalProperties);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Attributes) && Intrinsics.areEqual(this.additionalProperties, ((Attributes) other).additionalProperties);
        }

        public int hashCode() {
            return this.additionalProperties.hashCode();
        }

        public String toString() {
            return "Attributes(additionalProperties=" + this.additionalProperties + ")";
        }

        public Attributes(Map<String, String> additionalProperties) {
            Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
            this.additionalProperties = additionalProperties;
        }

        public /* synthetic */ Attributes(LinkedHashMap linkedHashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new LinkedHashMap() : linkedHashMap);
        }

        public final Map<String, String> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            for (Map.Entry<String, String> entry : this.additionalProperties.entrySet()) {
                jsonObject.addProperty(entry.getKey(), entry.getValue());
            }
            return jsonObject;
        }

        /* JADX INFO: compiled from: ExposureEvent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/flags/model/ExposureEvent$Attributes$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/flags/model/ExposureEvent$Attributes;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Attributes fromJson(String jsonString) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                    Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                    return fromJsonObject(jsonObject);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Attributes", e);
                }
            }

            @JvmStatic
            public final Attributes fromJsonObject(JsonObject jsonObject) throws JsonParseException {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                try {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                        String key = entry.getKey();
                        Intrinsics.checkNotNullExpressionValue(key, "entry.key");
                        String asString = entry.getValue().getAsString();
                        Intrinsics.checkNotNullExpressionValue(asString, "entry.value.asString");
                        linkedHashMap.put(key, asString);
                    }
                    return new Attributes(linkedHashMap);
                } catch (IllegalStateException e) {
                    throw new JsonParseException("Unable to parse json into type Attributes", e);
                } catch (NullPointerException e2) {
                    throw new JsonParseException("Unable to parse json into type Attributes", e2);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Unable to parse json into type Attributes", e3);
                }
            }
        }
    }
}

package com.datadog.android.api.context;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkInfo.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u0000 *2\u00020\u0001:\u0002*+BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J`\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\r\u0010&\u001a\u00020'H\u0000¢\u0006\u0002\b(J\t\u0010)\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0015\u0010\u000eR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0016\u0010\u000eR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0017\u0010\u000e¨\u0006,"}, d2 = {"Lcom/datadog/android/api/context/NetworkInfo;", "", "connectivity", "Lcom/datadog/android/api/context/NetworkInfo$Connectivity;", "carrierName", "", "carrierId", "", "upKbps", "downKbps", "strength", "cellularTechnology", "(Lcom/datadog/android/api/context/NetworkInfo$Connectivity;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "getCarrierId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCarrierName", "()Ljava/lang/String;", "getCellularTechnology", "getConnectivity", "()Lcom/datadog/android/api/context/NetworkInfo$Connectivity;", "getDownKbps", "getStrength", "getUpKbps", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Lcom/datadog/android/api/context/NetworkInfo$Connectivity;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)Lcom/datadog/android/api/context/NetworkInfo;", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toJson$dd_sdk_android_core_release", "toString", "Companion", "Connectivity", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class NetworkInfo {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Long carrierId;
    private final String carrierName;
    private final String cellularTechnology;
    private final Connectivity connectivity;
    private final Long downKbps;
    private final Long strength;
    private final Long upKbps;

    public NetworkInfo() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ NetworkInfo copy$default(NetworkInfo networkInfo, Connectivity connectivity, String str, Long l, Long l2, Long l3, Long l4, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            connectivity = networkInfo.connectivity;
        }
        if ((i & 2) != 0) {
            str = networkInfo.carrierName;
        }
        if ((i & 4) != 0) {
            l = networkInfo.carrierId;
        }
        if ((i & 8) != 0) {
            l2 = networkInfo.upKbps;
        }
        if ((i & 16) != 0) {
            l3 = networkInfo.downKbps;
        }
        if ((i & 32) != 0) {
            l4 = networkInfo.strength;
        }
        if ((i & 64) != 0) {
            str2 = networkInfo.cellularTechnology;
        }
        Long l5 = l4;
        String str3 = str2;
        Long l6 = l3;
        Long l7 = l;
        return networkInfo.copy(connectivity, str, l7, l2, l6, l5, str3);
    }

    @JvmStatic
    public static final NetworkInfo fromJson(String str) throws JsonParseException {
        return INSTANCE.fromJson(str);
    }

    @JvmStatic
    public static final NetworkInfo fromJsonObject(JsonObject jsonObject) throws JsonParseException {
        return INSTANCE.fromJsonObject(jsonObject);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Connectivity getConnectivity() {
        return this.connectivity;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCarrierName() {
        return this.carrierName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getCarrierId() {
        return this.carrierId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Long getUpKbps() {
        return this.upKbps;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Long getDownKbps() {
        return this.downKbps;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Long getStrength() {
        return this.strength;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getCellularTechnology() {
        return this.cellularTechnology;
    }

    public final NetworkInfo copy(Connectivity connectivity, String carrierName, Long carrierId, Long upKbps, Long downKbps, Long strength, String cellularTechnology) {
        Intrinsics.checkNotNullParameter(connectivity, "connectivity");
        return new NetworkInfo(connectivity, carrierName, carrierId, upKbps, downKbps, strength, cellularTechnology);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NetworkInfo)) {
            return false;
        }
        NetworkInfo networkInfo = (NetworkInfo) other;
        return this.connectivity == networkInfo.connectivity && Intrinsics.areEqual(this.carrierName, networkInfo.carrierName) && Intrinsics.areEqual(this.carrierId, networkInfo.carrierId) && Intrinsics.areEqual(this.upKbps, networkInfo.upKbps) && Intrinsics.areEqual(this.downKbps, networkInfo.downKbps) && Intrinsics.areEqual(this.strength, networkInfo.strength) && Intrinsics.areEqual(this.cellularTechnology, networkInfo.cellularTechnology);
    }

    public int hashCode() {
        int iHashCode = this.connectivity.hashCode() * 31;
        String str = this.carrierName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l = this.carrierId;
        int iHashCode3 = (iHashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.upKbps;
        int iHashCode4 = (iHashCode3 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.downKbps;
        int iHashCode5 = (iHashCode4 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Long l4 = this.strength;
        int iHashCode6 = (iHashCode5 + (l4 == null ? 0 : l4.hashCode())) * 31;
        String str2 = this.cellularTechnology;
        return iHashCode6 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "NetworkInfo(connectivity=" + this.connectivity + ", carrierName=" + this.carrierName + ", carrierId=" + this.carrierId + ", upKbps=" + this.upKbps + ", downKbps=" + this.downKbps + ", strength=" + this.strength + ", cellularTechnology=" + this.cellularTechnology + ")";
    }

    public NetworkInfo(Connectivity connectivity, String str, Long l, Long l2, Long l3, Long l4, String str2) {
        Intrinsics.checkNotNullParameter(connectivity, "connectivity");
        this.connectivity = connectivity;
        this.carrierName = str;
        this.carrierId = l;
        this.upKbps = l2;
        this.downKbps = l3;
        this.strength = l4;
        this.cellularTechnology = str2;
    }

    public /* synthetic */ NetworkInfo(Connectivity connectivity, String str, Long l, Long l2, Long l3, Long l4, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Connectivity.NETWORK_NOT_CONNECTED : connectivity, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : l2, (i & 16) != 0 ? null : l3, (i & 32) != 0 ? null : l4, (i & 64) != 0 ? null : str2);
    }

    public final Connectivity getConnectivity() {
        return this.connectivity;
    }

    public final String getCarrierName() {
        return this.carrierName;
    }

    public final Long getCarrierId() {
        return this.carrierId;
    }

    public final Long getUpKbps() {
        return this.upKbps;
    }

    public final Long getDownKbps() {
        return this.downKbps;
    }

    public final Long getStrength() {
        return this.strength;
    }

    public final String getCellularTechnology() {
        return this.cellularTechnology;
    }

    public final JsonElement toJson$dd_sdk_android_core_release() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("connectivity", this.connectivity.toJson$dd_sdk_android_core_release());
        String str = this.carrierName;
        if (str != null) {
            jsonObject.addProperty("carrier_name", str);
        }
        Long l = this.carrierId;
        if (l != null) {
            jsonObject.addProperty("carrier_id", Long.valueOf(l.longValue()));
        }
        Long l2 = this.upKbps;
        if (l2 != null) {
            jsonObject.addProperty("up_kbps", Long.valueOf(l2.longValue()));
        }
        Long l3 = this.downKbps;
        if (l3 != null) {
            jsonObject.addProperty("down_kbps", Long.valueOf(l3.longValue()));
        }
        Long l4 = this.strength;
        if (l4 != null) {
            jsonObject.addProperty("strength", Long.valueOf(l4.longValue()));
        }
        String str2 = this.cellularTechnology;
        if (str2 != null) {
            jsonObject.addProperty("cellular_technology", str2);
        }
        return jsonObject;
    }

    /* JADX INFO: compiled from: NetworkInfo.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/datadog/android/api/context/NetworkInfo$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/api/context/NetworkInfo;", "jsonString", "", "fromJsonObject", "jsonObject", "Lcom/google/gson/JsonObject;", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final NetworkInfo fromJson(String jsonString) throws JsonParseException {
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            try {
                JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                return fromJsonObject(jsonObject);
            } catch (IllegalStateException e) {
                throw new JsonParseException("Unable to parse json into type NetworkInfo", e);
            }
        }

        @JvmStatic
        public final NetworkInfo fromJsonObject(JsonObject jsonObject) throws JsonParseException {
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            try {
                Connectivity.Companion companion = Connectivity.INSTANCE;
                String asString = jsonObject.get("connectivity").getAsString();
                Intrinsics.checkNotNullExpressionValue(asString, "jsonObject.get(\"connectivity\").asString");
                Connectivity connectivityFromJson = companion.fromJson(asString);
                JsonElement jsonElement = jsonObject.get("carrier_name");
                String asString2 = jsonElement != null ? jsonElement.getAsString() : null;
                JsonElement jsonElement2 = jsonObject.get("carrier_id");
                Long lValueOf = jsonElement2 != null ? Long.valueOf(jsonElement2.getAsLong()) : null;
                JsonElement jsonElement3 = jsonObject.get("up_kbps");
                Long lValueOf2 = jsonElement3 != null ? Long.valueOf(jsonElement3.getAsLong()) : null;
                JsonElement jsonElement4 = jsonObject.get("down_kbps");
                Long lValueOf3 = jsonElement4 != null ? Long.valueOf(jsonElement4.getAsLong()) : null;
                JsonElement jsonElement5 = jsonObject.get("strength");
                Long lValueOf4 = jsonElement5 != null ? Long.valueOf(jsonElement5.getAsLong()) : null;
                JsonElement jsonElement6 = jsonObject.get("cellular_technology");
                return new NetworkInfo(connectivityFromJson, asString2, lValueOf, lValueOf2, lValueOf3, lValueOf4, jsonElement6 != null ? jsonElement6.getAsString() : null);
            } catch (IllegalStateException e) {
                throw new JsonParseException("Unable to parse json into type NetworkInfo", e);
            } catch (NullPointerException e2) {
                throw new JsonParseException("Unable to parse json into type NetworkInfo", e2);
            } catch (NumberFormatException e3) {
                throw new JsonParseException("Unable to parse json into type NetworkInfo", e3);
            }
        }
    }

    /* JADX INFO: compiled from: NetworkInfo.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/datadog/android/api/context/NetworkInfo$Connectivity;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "toJson$dd_sdk_android_core_release", "NETWORK_NOT_CONNECTED", "NETWORK_ETHERNET", "NETWORK_WIFI", "NETWORK_WIMAX", "NETWORK_BLUETOOTH", "NETWORK_2G", "NETWORK_3G", "NETWORK_4G", "NETWORK_5G", "NETWORK_MOBILE_OTHER", "NETWORK_CELLULAR", "NETWORK_OTHER", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum Connectivity {
        NETWORK_NOT_CONNECTED("network_not_connected"),
        NETWORK_ETHERNET("network_ethernet"),
        NETWORK_WIFI("network_wifi"),
        NETWORK_WIMAX("network_wimax"),
        NETWORK_BLUETOOTH("network_bluetooth"),
        NETWORK_2G("network_2G"),
        NETWORK_3G("network_3G"),
        NETWORK_4G("network_4G"),
        NETWORK_5G("network_5G"),
        NETWORK_MOBILE_OTHER("network_mobile_other"),
        NETWORK_CELLULAR("network_cellular"),
        NETWORK_OTHER("network_other");


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String jsonValue;

        @JvmStatic
        public static final Connectivity fromJson(String str) throws JsonParseException {
            return INSTANCE.fromJson(str);
        }

        Connectivity(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson$dd_sdk_android_core_release() {
            return new JsonPrimitive(this.jsonValue);
        }

        /* JADX INFO: compiled from: NetworkInfo.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/api/context/NetworkInfo$Connectivity$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/api/context/NetworkInfo$Connectivity;", "jsonString", "", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
                    for (Connectivity connectivity : Connectivity.values()) {
                        if (Intrinsics.areEqual(connectivity.jsonValue, jsonString)) {
                            return connectivity;
                        }
                    }
                    throw new NoSuchElementException("Array contains no element matching the predicate.");
                } catch (NoSuchElementException e) {
                    throw new JsonParseException("Unable to parse json into type NetworkInfo.Connectivity", e);
                }
            }
        }
    }
}

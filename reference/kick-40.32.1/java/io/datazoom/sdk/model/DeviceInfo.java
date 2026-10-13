package io.datazoom.sdk.model;

import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: DeviceInfo.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 :2\u00020\u0001:\u00029:BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rBi\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u000bHÆ\u0003JY\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0014\u0010-\u001a\u00020\u000b2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010/\u001a\u00020\u000fHÖ\u0081\u0004J\n\u00100\u001a\u00020\u0003HÖ\u0081\u0004J%\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0001¢\u0006\u0002\b8R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016R\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u0016R\u001c\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001e\u0010\u0016R\u001c\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010\u0016R\u001c\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0014\u001a\u0004\b\"\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010#¨\u0006;"}, d2 = {"Lio/datazoom/sdk/model/DeviceInfo;", "", "manufacturer", "", "orientation", "name", "id", "osVersion", "osName", "type", "isFullScreen", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getManufacturer$annotations", "()V", "getManufacturer", "()Ljava/lang/String;", "getOrientation$annotations", "getOrientation", "getName$annotations", "getName", "getId$annotations", "getId", "getOsVersion$annotations", "getOsVersion", "getOsName$annotations", "getOsName", "getType$annotations", "getType", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$base", "$serializer", "Companion", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable
public final /* data */ class DeviceInfo {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String id;
    private final boolean isFullScreen;
    private final String manufacturer;
    private final String name;
    private final String orientation;
    private final String osName;
    private final String osVersion;
    private final String type;

    public static /* synthetic */ DeviceInfo copy$default(DeviceInfo deviceInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceInfo.manufacturer;
        }
        if ((i & 2) != 0) {
            str2 = deviceInfo.orientation;
        }
        if ((i & 4) != 0) {
            str3 = deviceInfo.name;
        }
        if ((i & 8) != 0) {
            str4 = deviceInfo.id;
        }
        if ((i & 16) != 0) {
            str5 = deviceInfo.osVersion;
        }
        if ((i & 32) != 0) {
            str6 = deviceInfo.osName;
        }
        if ((i & 64) != 0) {
            str7 = deviceInfo.type;
        }
        if ((i & 128) != 0) {
            z = deviceInfo.isFullScreen;
        }
        String str8 = str7;
        boolean z2 = z;
        String str9 = str5;
        String str10 = str6;
        return deviceInfo.copy(str, str2, str3, str4, str9, str10, str8, z2);
    }

    @SerialName("device_id")
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("device_mfg")
    public static /* synthetic */ void getManufacturer$annotations() {
    }

    @SerialName("device_name")
    public static /* synthetic */ void getName$annotations() {
    }

    @SerialName("orientation")
    public static /* synthetic */ void getOrientation$annotations() {
    }

    @SerialName("os_name")
    public static /* synthetic */ void getOsName$annotations() {
    }

    @SerialName("os_version")
    public static /* synthetic */ void getOsVersion$annotations() {
    }

    @SerialName("device_type")
    public static /* synthetic */ void getType$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getManufacturer() {
        return this.manufacturer;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getOrientation() {
        return this.orientation;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getOsVersion() {
        return this.osVersion;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getOsName() {
        return this.osName;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsFullScreen() {
        return this.isFullScreen;
    }

    public final DeviceInfo copy(String manufacturer, String orientation, String name, String id, String osVersion, String osName, String type, boolean isFullScreen) {
        Intrinsics.checkNotNullParameter(manufacturer, "manufacturer");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(osVersion, "osVersion");
        Intrinsics.checkNotNullParameter(osName, "osName");
        Intrinsics.checkNotNullParameter(type, "type");
        return new DeviceInfo(manufacturer, orientation, name, id, osVersion, osName, type, isFullScreen);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceInfo)) {
            return false;
        }
        DeviceInfo deviceInfo = (DeviceInfo) other;
        return Intrinsics.areEqual(this.manufacturer, deviceInfo.manufacturer) && Intrinsics.areEqual(this.orientation, deviceInfo.orientation) && Intrinsics.areEqual(this.name, deviceInfo.name) && Intrinsics.areEqual(this.id, deviceInfo.id) && Intrinsics.areEqual(this.osVersion, deviceInfo.osVersion) && Intrinsics.areEqual(this.osName, deviceInfo.osName) && Intrinsics.areEqual(this.type, deviceInfo.type) && this.isFullScreen == deviceInfo.isFullScreen;
    }

    public int hashCode() {
        return (((((((((((((this.manufacturer.hashCode() * 31) + this.orientation.hashCode()) * 31) + this.name.hashCode()) * 31) + this.id.hashCode()) * 31) + this.osVersion.hashCode()) * 31) + this.osName.hashCode()) * 31) + this.type.hashCode()) * 31) + Boolean.hashCode(this.isFullScreen);
    }

    public String toString() {
        return "DeviceInfo(manufacturer=" + this.manufacturer + ", orientation=" + this.orientation + ", name=" + this.name + ", id=" + this.id + ", osVersion=" + this.osVersion + ", osName=" + this.osName + ", type=" + this.type + ", isFullScreen=" + this.isFullScreen + ")";
    }

    /* JADX INFO: compiled from: DeviceInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lio/datazoom/sdk/model/DeviceInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/datazoom/sdk/model/DeviceInfo;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DeviceInfo> serializer() {
            return DeviceInfo$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ DeviceInfo(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, SerializationConstructorMarker serializationConstructorMarker) {
        if (255 != (i & 255)) {
            PluginExceptionsKt.throwMissingFieldException(i, 255, DeviceInfo$$serializer.INSTANCE.getDescriptor());
        }
        this.manufacturer = str;
        this.orientation = str2;
        this.name = str3;
        this.id = str4;
        this.osVersion = str5;
        this.osName = str6;
        this.type = str7;
        this.isFullScreen = z;
    }

    public DeviceInfo(String manufacturer, String orientation, String name, String id, String osVersion, String osName, String type, boolean z) {
        Intrinsics.checkNotNullParameter(manufacturer, "manufacturer");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(osVersion, "osVersion");
        Intrinsics.checkNotNullParameter(osName, "osName");
        Intrinsics.checkNotNullParameter(type, "type");
        this.manufacturer = manufacturer;
        this.orientation = orientation;
        this.name = name;
        this.id = id;
        this.osVersion = osVersion;
        this.osName = osName;
        this.type = type;
        this.isFullScreen = z;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$base(DeviceInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.manufacturer);
        output.encodeStringElement(serialDesc, 1, self.orientation);
        output.encodeStringElement(serialDesc, 2, self.name);
        output.encodeStringElement(serialDesc, 3, self.id);
        output.encodeStringElement(serialDesc, 4, self.osVersion);
        output.encodeStringElement(serialDesc, 5, self.osName);
        output.encodeStringElement(serialDesc, 6, self.type);
        output.encodeBooleanElement(serialDesc, 7, self.isFullScreen);
    }

    public final String getManufacturer() {
        return this.manufacturer;
    }

    public final String getOrientation() {
        return this.orientation;
    }

    public final String getName() {
        return this.name;
    }

    public final String getId() {
        return this.id;
    }

    public final String getOsVersion() {
        return this.osVersion;
    }

    public final String getOsName() {
        return this.osName;
    }

    public final String getType() {
        return this.type;
    }

    public final boolean isFullScreen() {
        return this.isFullScreen;
    }
}

package io.datazoom.sdk.network.config.model;

import androidx.autofill.HintConstants;
import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.network.geo.model.GeoResponse;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: ConfigExtraDto.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 i2\u00020\u0001:\u0002hiBÓ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0016\u0010\u0017BÅ\u0001\b\u0010\u0012\u0006\u0010\u0018\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u0016\u0010\u001bJ\u0006\u0010D\u001a\u00020EJ\r\u0010F\u001a\u0004\u0018\u00010G¢\u0006\u0002\u0010HJ\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010O\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010T\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u00108J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÚ\u0001\u0010Z\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010[J\u0014\u0010\\\u001a\u00020\u00102\b\u0010]\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010^\u001a\u00020\nHÖ\u0081\u0004J\n\u0010_\u001a\u00020\u0003HÖ\u0081\u0004J%\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020\u00002\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020fH\u0001¢\u0006\u0002\bgR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u001d\u001a\u0004\b!\u0010\u001fR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001fR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u001d\u001a\u0004\b%\u0010\u001fR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u001d\u001a\u0004\b'\u0010\u001fR\u001e\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u001d\u001a\u0004\b)\u0010\u001fR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010-\u0012\u0004\b*\u0010\u001d\u001a\u0004\b+\u0010,R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u001d\u001a\u0004\b/\u0010\u001fR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u001d\u001a\u0004\b1\u0010\u001fR\u001e\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010\u001d\u001a\u0004\b3\u0010\u001fR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010\u001d\u001a\u0004\b5\u0010\u001fR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00109\u0012\u0004\b6\u0010\u001d\u001a\u0004\b7\u00108R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b:\u0010\u001d\u001a\u0004\b;\u0010\u001fR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b<\u0010\u001d\u001a\u0004\b=\u0010\u001fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b>\u0010\u001d\u001a\u0004\b?\u0010\u001fR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b@\u0010\u001d\u001a\u0004\bA\u0010\u001fR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bB\u0010\u001d\u001a\u0004\bC\u0010\u001f¨\u0006j"}, d2 = {"Lio/datazoom/sdk/network/config/model/ConfigExtraDto;", "", "timeSync", "", "city", HintConstants.AUTOFILL_HINT_POSTAL_CODE, "latitude", "longitude", "timezoneName", "timezoneOffset", "", "asn", "continentCode", "clientIp", "continent", "mobileConnection", "", "geoVersion", "region", "country", "regionCode", "countryCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTimeSync$annotations", "()V", "getTimeSync", "()Ljava/lang/String;", "getCity$annotations", "getCity", "getPostalCode$annotations", "getPostalCode", "getLatitude$annotations", "getLatitude", "getLongitude$annotations", "getLongitude", "getTimezoneName$annotations", "getTimezoneName", "getTimezoneOffset$annotations", "getTimezoneOffset", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAsn$annotations", "getAsn", "getContinentCode$annotations", "getContinentCode", "getClientIp$annotations", "getClientIp", "getContinent$annotations", "getContinent", "getMobileConnection$annotations", "getMobileConnection", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getGeoVersion$annotations", "getGeoVersion", "getRegion$annotations", "getRegion", "getCountry$annotations", "getCountry", "getRegionCode$annotations", "getRegionCode", "getCountryCode$annotations", "getCountryCode", "toGeoResponse", "Lio/datazoom/sdk/network/geo/model/GeoResponse;", "serverTimeMillis", "", "()Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/datazoom/sdk/network/config/model/ConfigExtraDto;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$base", "$serializer", "Companion", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable
public final /* data */ class ConfigExtraDto {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String asn;
    private final String city;
    private final String clientIp;
    private final String continent;
    private final String continentCode;
    private final String country;
    private final String countryCode;
    private final String geoVersion;
    private final String latitude;
    private final String longitude;
    private final Boolean mobileConnection;
    private final String postalCode;
    private final String region;
    private final String regionCode;
    private final String timeSync;
    private final String timezoneName;
    private final Integer timezoneOffset;

    public ConfigExtraDto() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, (String) null, 131071, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ConfigExtraDto copy$default(ConfigExtraDto configExtraDto, String str, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, String str8, String str9, String str10, Boolean bool, String str11, String str12, String str13, String str14, String str15, int i, Object obj) {
        String str16;
        String str17;
        String str18 = (i & 1) != 0 ? configExtraDto.timeSync : str;
        String str19 = (i & 2) != 0 ? configExtraDto.city : str2;
        String str20 = (i & 4) != 0 ? configExtraDto.postalCode : str3;
        String str21 = (i & 8) != 0 ? configExtraDto.latitude : str4;
        String str22 = (i & 16) != 0 ? configExtraDto.longitude : str5;
        String str23 = (i & 32) != 0 ? configExtraDto.timezoneName : str6;
        Integer num2 = (i & 64) != 0 ? configExtraDto.timezoneOffset : num;
        String str24 = (i & 128) != 0 ? configExtraDto.asn : str7;
        String str25 = (i & 256) != 0 ? configExtraDto.continentCode : str8;
        String str26 = (i & 512) != 0 ? configExtraDto.clientIp : str9;
        String str27 = (i & 1024) != 0 ? configExtraDto.continent : str10;
        Boolean bool2 = (i & 2048) != 0 ? configExtraDto.mobileConnection : bool;
        String str28 = (i & 4096) != 0 ? configExtraDto.geoVersion : str11;
        String str29 = (i & 8192) != 0 ? configExtraDto.region : str12;
        String str30 = str18;
        String str31 = (i & 16384) != 0 ? configExtraDto.country : str13;
        String str32 = (i & 32768) != 0 ? configExtraDto.regionCode : str14;
        if ((i & 65536) != 0) {
            str17 = str32;
            str16 = configExtraDto.countryCode;
        } else {
            str16 = str15;
            str17 = str32;
        }
        return configExtraDto.copy(str30, str19, str20, str21, str22, str23, num2, str24, str25, str26, str27, bool2, str28, str29, str31, str17, str16);
    }

    @SerialName("asn")
    public static /* synthetic */ void getAsn$annotations() {
    }

    @SerialName("city")
    public static /* synthetic */ void getCity$annotations() {
    }

    @SerialName("client_ip")
    public static /* synthetic */ void getClientIp$annotations() {
    }

    @SerialName("continent")
    public static /* synthetic */ void getContinent$annotations() {
    }

    @SerialName("continent_code")
    public static /* synthetic */ void getContinentCode$annotations() {
    }

    @SerialName("country")
    public static /* synthetic */ void getCountry$annotations() {
    }

    @SerialName("country_code")
    public static /* synthetic */ void getCountryCode$annotations() {
    }

    @SerialName("geo_version")
    public static /* synthetic */ void getGeoVersion$annotations() {
    }

    @SerialName("latitude")
    public static /* synthetic */ void getLatitude$annotations() {
    }

    @SerialName("longitude")
    public static /* synthetic */ void getLongitude$annotations() {
    }

    @SerialName("mobile_connection")
    public static /* synthetic */ void getMobileConnection$annotations() {
    }

    @SerialName("postal_code")
    public static /* synthetic */ void getPostalCode$annotations() {
    }

    @SerialName("region")
    public static /* synthetic */ void getRegion$annotations() {
    }

    @SerialName("region_code")
    public static /* synthetic */ void getRegionCode$annotations() {
    }

    @SerialName("time_sync")
    public static /* synthetic */ void getTimeSync$annotations() {
    }

    @SerialName("timezone_name")
    public static /* synthetic */ void getTimezoneName$annotations() {
    }

    @SerialName("timezone_offset")
    public static /* synthetic */ void getTimezoneOffset$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTimeSync() {
        return this.timeSync;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getClientIp() {
        return this.clientIp;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getContinent() {
        return this.continent;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Boolean getMobileConnection() {
        return this.mobileConnection;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getGeoVersion() {
        return this.geoVersion;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getRegion() {
        return this.region;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getCountry() {
        return this.country;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getRegionCode() {
        return this.regionCode;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getCountryCode() {
        return this.countryCode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCity() {
        return this.city;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPostalCode() {
        return this.postalCode;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLatitude() {
        return this.latitude;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLongitude() {
        return this.longitude;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getTimezoneName() {
        return this.timezoneName;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getTimezoneOffset() {
        return this.timezoneOffset;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getAsn() {
        return this.asn;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getContinentCode() {
        return this.continentCode;
    }

    public final ConfigExtraDto copy(String timeSync, String city, String postalCode, String latitude, String longitude, String timezoneName, Integer timezoneOffset, String asn, String continentCode, String clientIp, String continent, Boolean mobileConnection, String geoVersion, String region, String country, String regionCode, String countryCode) {
        return new ConfigExtraDto(timeSync, city, postalCode, latitude, longitude, timezoneName, timezoneOffset, asn, continentCode, clientIp, continent, mobileConnection, geoVersion, region, country, regionCode, countryCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConfigExtraDto)) {
            return false;
        }
        ConfigExtraDto configExtraDto = (ConfigExtraDto) other;
        return Intrinsics.areEqual(this.timeSync, configExtraDto.timeSync) && Intrinsics.areEqual(this.city, configExtraDto.city) && Intrinsics.areEqual(this.postalCode, configExtraDto.postalCode) && Intrinsics.areEqual(this.latitude, configExtraDto.latitude) && Intrinsics.areEqual(this.longitude, configExtraDto.longitude) && Intrinsics.areEqual(this.timezoneName, configExtraDto.timezoneName) && Intrinsics.areEqual(this.timezoneOffset, configExtraDto.timezoneOffset) && Intrinsics.areEqual(this.asn, configExtraDto.asn) && Intrinsics.areEqual(this.continentCode, configExtraDto.continentCode) && Intrinsics.areEqual(this.clientIp, configExtraDto.clientIp) && Intrinsics.areEqual(this.continent, configExtraDto.continent) && Intrinsics.areEqual(this.mobileConnection, configExtraDto.mobileConnection) && Intrinsics.areEqual(this.geoVersion, configExtraDto.geoVersion) && Intrinsics.areEqual(this.region, configExtraDto.region) && Intrinsics.areEqual(this.country, configExtraDto.country) && Intrinsics.areEqual(this.regionCode, configExtraDto.regionCode) && Intrinsics.areEqual(this.countryCode, configExtraDto.countryCode);
    }

    public int hashCode() {
        String str = this.timeSync;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.city;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.postalCode;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.latitude;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.longitude;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.timezoneName;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num = this.timezoneOffset;
        int iHashCode7 = (iHashCode6 + (num == null ? 0 : num.hashCode())) * 31;
        String str7 = this.asn;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.continentCode;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.clientIp;
        int iHashCode10 = (iHashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.continent;
        int iHashCode11 = (iHashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        Boolean bool = this.mobileConnection;
        int iHashCode12 = (iHashCode11 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str11 = this.geoVersion;
        int iHashCode13 = (iHashCode12 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.region;
        int iHashCode14 = (iHashCode13 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.country;
        int iHashCode15 = (iHashCode14 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.regionCode;
        int iHashCode16 = (iHashCode15 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.countryCode;
        return iHashCode16 + (str15 != null ? str15.hashCode() : 0);
    }

    public String toString() {
        return "ConfigExtraDto(timeSync=" + this.timeSync + ", city=" + this.city + ", postalCode=" + this.postalCode + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", timezoneName=" + this.timezoneName + ", timezoneOffset=" + this.timezoneOffset + ", asn=" + this.asn + ", continentCode=" + this.continentCode + ", clientIp=" + this.clientIp + ", continent=" + this.continent + ", mobileConnection=" + this.mobileConnection + ", geoVersion=" + this.geoVersion + ", region=" + this.region + ", country=" + this.country + ", regionCode=" + this.regionCode + ", countryCode=" + this.countryCode + ")";
    }

    /* JADX INFO: compiled from: ConfigExtraDto.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lio/datazoom/sdk/network/config/model/ConfigExtraDto$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/datazoom/sdk/network/config/model/ConfigExtraDto;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ConfigExtraDto> serializer() {
            return ConfigExtraDto$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ConfigExtraDto(int i, String str, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, String str8, String str9, String str10, Boolean bool, String str11, String str12, String str13, String str14, String str15, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.timeSync = null;
        } else {
            this.timeSync = str;
        }
        if ((i & 2) == 0) {
            this.city = null;
        } else {
            this.city = str2;
        }
        if ((i & 4) == 0) {
            this.postalCode = null;
        } else {
            this.postalCode = str3;
        }
        if ((i & 8) == 0) {
            this.latitude = null;
        } else {
            this.latitude = str4;
        }
        if ((i & 16) == 0) {
            this.longitude = null;
        } else {
            this.longitude = str5;
        }
        if ((i & 32) == 0) {
            this.timezoneName = null;
        } else {
            this.timezoneName = str6;
        }
        if ((i & 64) == 0) {
            this.timezoneOffset = null;
        } else {
            this.timezoneOffset = num;
        }
        if ((i & 128) == 0) {
            this.asn = null;
        } else {
            this.asn = str7;
        }
        if ((i & 256) == 0) {
            this.continentCode = null;
        } else {
            this.continentCode = str8;
        }
        if ((i & 512) == 0) {
            this.clientIp = null;
        } else {
            this.clientIp = str9;
        }
        if ((i & 1024) == 0) {
            this.continent = null;
        } else {
            this.continent = str10;
        }
        if ((i & 2048) == 0) {
            this.mobileConnection = null;
        } else {
            this.mobileConnection = bool;
        }
        if ((i & 4096) == 0) {
            this.geoVersion = null;
        } else {
            this.geoVersion = str11;
        }
        if ((i & 8192) == 0) {
            this.region = null;
        } else {
            this.region = str12;
        }
        if ((i & 16384) == 0) {
            this.country = null;
        } else {
            this.country = str13;
        }
        if ((32768 & i) == 0) {
            this.regionCode = null;
        } else {
            this.regionCode = str14;
        }
        if ((i & 65536) == 0) {
            this.countryCode = null;
        } else {
            this.countryCode = str15;
        }
    }

    public ConfigExtraDto(String str, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, String str8, String str9, String str10, Boolean bool, String str11, String str12, String str13, String str14, String str15) {
        this.timeSync = str;
        this.city = str2;
        this.postalCode = str3;
        this.latitude = str4;
        this.longitude = str5;
        this.timezoneName = str6;
        this.timezoneOffset = num;
        this.asn = str7;
        this.continentCode = str8;
        this.clientIp = str9;
        this.continent = str10;
        this.mobileConnection = bool;
        this.geoVersion = str11;
        this.region = str12;
        this.country = str13;
        this.regionCode = str14;
        this.countryCode = str15;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$base(ConfigExtraDto self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.timeSync != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.timeSync);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.city != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.city);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.postalCode != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.postalCode);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.latitude != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.latitude);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.longitude != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.longitude);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.timezoneName != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.timezoneName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.timezoneOffset != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, IntSerializer.INSTANCE, self.timezoneOffset);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.asn != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.asn);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.continentCode != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.continentCode);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.clientIp != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.clientIp);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.continent != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.continent);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.mobileConnection != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, BooleanSerializer.INSTANCE, self.mobileConnection);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.geoVersion != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.geoVersion);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.region != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.region);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.country != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.country);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.regionCode != null) {
            output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.regionCode);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 16) && self.countryCode == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.countryCode);
    }

    public /* synthetic */ ConfigExtraDto(String str, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, String str8, String str9, String str10, Boolean bool, String str11, String str12, String str13, String str14, String str15, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : num, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : str9, (i & 1024) != 0 ? null : str10, (i & 2048) != 0 ? null : bool, (i & 4096) != 0 ? null : str11, (i & 8192) != 0 ? null : str12, (i & 16384) != 0 ? null : str13, (i & 32768) != 0 ? null : str14, (i & 65536) != 0 ? null : str15);
    }

    public final String getTimeSync() {
        return this.timeSync;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getPostalCode() {
        return this.postalCode;
    }

    public final String getLatitude() {
        return this.latitude;
    }

    public final String getLongitude() {
        return this.longitude;
    }

    public final String getTimezoneName() {
        return this.timezoneName;
    }

    public final Integer getTimezoneOffset() {
        return this.timezoneOffset;
    }

    public final String getAsn() {
        return this.asn;
    }

    public final String getContinentCode() {
        return this.continentCode;
    }

    public final String getClientIp() {
        return this.clientIp;
    }

    public final String getContinent() {
        return this.continent;
    }

    public final Boolean getMobileConnection() {
        return this.mobileConnection;
    }

    public final String getGeoVersion() {
        return this.geoVersion;
    }

    public final String getRegion() {
        return this.region;
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getRegionCode() {
        return this.regionCode;
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    public final GeoResponse toGeoResponse() {
        String str = this.asn;
        String str2 = this.city;
        String str3 = this.continent;
        String str4 = this.continentCode;
        String str5 = this.country;
        String str6 = this.countryCode;
        Boolean bool = this.mobileConnection;
        String str7 = this.latitude;
        Double doubleOrNull = str7 != null ? StringsKt.toDoubleOrNull(str7) : null;
        String str8 = this.longitude;
        return new GeoResponse(str, (String) null, str2, str3, str4, str5, str6, (String) null, (String) null, bool, doubleOrNull, str8 != null ? StringsKt.toDoubleOrNull(str8) : null, this.timezoneOffset, (String) null, this.clientIp, this.regionCode, this.region, (String) null, this.timezoneName, this.postalCode, 139650, (DefaultConstructorMarker) null);
    }

    public final Long serverTimeMillis() {
        String str = this.timeSync;
        if (str != null) {
            return StringsKt.toLongOrNull(str);
        }
        return null;
    }
}

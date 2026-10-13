package io.datazoom.sdk.network.geo.model;

import com.facebook.hermes.intl.Constants;
import com.google.android.gms.actions.SearchIntents;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: GeoResponse.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\bd\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u008b\u00012\u00020\u0001:\u0004\u008a\u0001\u008b\u0001B÷\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001a\u0010\u001bBã\u0001\b\u0010\u0012\u0006\u0010\u001c\u001a\u00020\u0012\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u001a\u0010\u001fJ\u000b\u0010h\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010q\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010@J\u0010\u0010r\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010FJ\u0010\u0010s\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010FJ\u0010\u0010t\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010OJ\u000b\u0010u\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010{\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jþ\u0001\u0010|\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010}J\u0014\u0010~\u001a\u00020\r2\b\u0010\u007f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\u000b\u0010\u0080\u0001\u001a\u00020\u0012HÖ\u0081\u0004J\u000b\u0010\u0081\u0001\u001a\u00020\u0003HÖ\u0081\u0004J-\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u0084\u0001\u001a\u00020\u00002\b\u0010\u0085\u0001\u001a\u00030\u0086\u00012\b\u0010\u0087\u0001\u001a\u00030\u0088\u0001H\u0001¢\u0006\u0003\b\u0089\u0001R&\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R&\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b&\u0010!\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R&\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b)\u0010!\u001a\u0004\b*\u0010#\"\u0004\b+\u0010%R&\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b,\u0010!\u001a\u0004\b-\u0010#\"\u0004\b.\u0010%R&\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b/\u0010!\u001a\u0004\b0\u0010#\"\u0004\b1\u0010%R&\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b2\u0010!\u001a\u0004\b3\u0010#\"\u0004\b4\u0010%R&\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b5\u0010!\u001a\u0004\b6\u0010#\"\u0004\b7\u0010%R&\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b8\u0010!\u001a\u0004\b9\u0010#\"\u0004\b:\u0010%R&\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b;\u0010!\u001a\u0004\b<\u0010#\"\u0004\b=\u0010%R(\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010C\u0012\u0004\b>\u0010!\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR(\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010I\u0012\u0004\bD\u0010!\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR(\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010I\u0012\u0004\bJ\u0010!\u001a\u0004\bK\u0010F\"\u0004\bL\u0010HR(\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010R\u0012\u0004\bM\u0010!\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR&\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bS\u0010!\u001a\u0004\bT\u0010#\"\u0004\bU\u0010%R&\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bV\u0010!\u001a\u0004\bW\u0010#\"\u0004\bX\u0010%R&\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bY\u0010!\u001a\u0004\bZ\u0010#\"\u0004\b[\u0010%R&\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\\\u0010!\u001a\u0004\b]\u0010#\"\u0004\b^\u0010%R&\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b_\u0010!\u001a\u0004\b`\u0010#\"\u0004\ba\u0010%R&\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bb\u0010!\u001a\u0004\bc\u0010#\"\u0004\bd\u0010%R&\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\be\u0010!\u001a\u0004\bf\u0010#\"\u0004\bg\u0010%¨\u0006\u008c\u0001"}, d2 = {"Lio/datazoom/sdk/network/geo/model/GeoResponse;", "", "asn", "", "asname", "city", "continent", "continentCode", "country", "countryCode", "district", "isp", "mobile", "", "lat", "", "lon", "offset", "", "org", SearchIntents.EXTRA_QUERY, "region", "regionName", "status", "timezone", "zip", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAsn$annotations", "()V", "getAsn", "()Ljava/lang/String;", "setAsn", "(Ljava/lang/String;)V", "getAsname$annotations", "getAsname", "setAsname", "getCity$annotations", "getCity", "setCity", "getContinent$annotations", "getContinent", "setContinent", "getContinentCode$annotations", "getContinentCode", "setContinentCode", "getCountry$annotations", "getCountry", "setCountry", "getCountryCode$annotations", "getCountryCode", "setCountryCode", "getDistrict$annotations", "getDistrict", "setDistrict", "getIsp$annotations", "getIsp", "setIsp", "getMobile$annotations", "getMobile", "()Ljava/lang/Boolean;", "setMobile", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getLat$annotations", "getLat", "()Ljava/lang/Double;", "setLat", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getLon$annotations", "getLon", "setLon", "getOffset$annotations", "getOffset", "()Ljava/lang/Integer;", "setOffset", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getOrg$annotations", "getOrg", "setOrg", "getQuery$annotations", "getQuery", "setQuery", "getRegion$annotations", "getRegion", "setRegion", "getRegionName$annotations", "getRegionName", "setRegionName", "getStatus$annotations", "getStatus", "setStatus", "getTimezone$annotations", "getTimezone", "setTimezone", "getZip$annotations", "getZip", "setZip", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/datazoom/sdk/network/geo/model/GeoResponse;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$base", "$serializer", "Companion", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable
public final /* data */ class GeoResponse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String asn;
    private String asname;
    private String city;
    private String continent;
    private String continentCode;
    private String country;
    private String countryCode;
    private String district;
    private String isp;
    private Double lat;
    private Double lon;
    private Boolean mobile;
    private Integer offset;
    private String org;
    private String query;
    private String region;
    private String regionName;
    private String status;
    private String timezone;
    private String zip;

    public GeoResponse() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (Double) null, (Double) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 1048575, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GeoResponse copy$default(GeoResponse geoResponse, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Boolean bool, Double d, Double d2, Integer num, String str10, String str11, String str12, String str13, String str14, String str15, String str16, int i, Object obj) {
        String str17;
        String str18;
        String str19 = (i & 1) != 0 ? geoResponse.asn : str;
        String str20 = (i & 2) != 0 ? geoResponse.asname : str2;
        String str21 = (i & 4) != 0 ? geoResponse.city : str3;
        String str22 = (i & 8) != 0 ? geoResponse.continent : str4;
        String str23 = (i & 16) != 0 ? geoResponse.continentCode : str5;
        String str24 = (i & 32) != 0 ? geoResponse.country : str6;
        String str25 = (i & 64) != 0 ? geoResponse.countryCode : str7;
        String str26 = (i & 128) != 0 ? geoResponse.district : str8;
        String str27 = (i & 256) != 0 ? geoResponse.isp : str9;
        Boolean bool2 = (i & 512) != 0 ? geoResponse.mobile : bool;
        Double d3 = (i & 1024) != 0 ? geoResponse.lat : d;
        Double d4 = (i & 2048) != 0 ? geoResponse.lon : d2;
        Integer num2 = (i & 4096) != 0 ? geoResponse.offset : num;
        String str28 = (i & 8192) != 0 ? geoResponse.org : str10;
        String str29 = str19;
        String str30 = (i & 16384) != 0 ? geoResponse.query : str11;
        String str31 = (i & 32768) != 0 ? geoResponse.region : str12;
        String str32 = (i & 65536) != 0 ? geoResponse.regionName : str13;
        String str33 = (i & 131072) != 0 ? geoResponse.status : str14;
        String str34 = (i & 262144) != 0 ? geoResponse.timezone : str15;
        if ((i & 524288) != 0) {
            str18 = str34;
            str17 = geoResponse.zip;
        } else {
            str17 = str16;
            str18 = str34;
        }
        return geoResponse.copy(str29, str20, str21, str22, str23, str24, str25, str26, str27, bool2, d3, d4, num2, str28, str30, str31, str32, str33, str18, str17);
    }

    @SerialName("as")
    public static /* synthetic */ void getAsn$annotations() {
    }

    @SerialName("asname")
    public static /* synthetic */ void getAsname$annotations() {
    }

    @SerialName("city")
    public static /* synthetic */ void getCity$annotations() {
    }

    @SerialName("continent")
    public static /* synthetic */ void getContinent$annotations() {
    }

    @SerialName("continentCode")
    public static /* synthetic */ void getContinentCode$annotations() {
    }

    @SerialName("country")
    public static /* synthetic */ void getCountry$annotations() {
    }

    @SerialName("countryCode")
    public static /* synthetic */ void getCountryCode$annotations() {
    }

    @SerialName("district")
    public static /* synthetic */ void getDistrict$annotations() {
    }

    @SerialName("isp")
    public static /* synthetic */ void getIsp$annotations() {
    }

    @SerialName("lat")
    public static /* synthetic */ void getLat$annotations() {
    }

    @SerialName("lon")
    public static /* synthetic */ void getLon$annotations() {
    }

    @SerialName("mobile")
    public static /* synthetic */ void getMobile$annotations() {
    }

    @SerialName("offset")
    public static /* synthetic */ void getOffset$annotations() {
    }

    @SerialName("org")
    public static /* synthetic */ void getOrg$annotations() {
    }

    @SerialName(SearchIntents.EXTRA_QUERY)
    public static /* synthetic */ void getQuery$annotations() {
    }

    @SerialName("region")
    public static /* synthetic */ void getRegion$annotations() {
    }

    @SerialName("regionName")
    public static /* synthetic */ void getRegionName$annotations() {
    }

    @SerialName("status")
    public static /* synthetic */ void getStatus$annotations() {
    }

    @SerialName("timezone")
    public static /* synthetic */ void getTimezone$annotations() {
    }

    @SerialName("zip")
    public static /* synthetic */ void getZip$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAsn() {
        return this.asn;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Boolean getMobile() {
        return this.mobile;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Double getLat() {
        return this.lat;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Double getLon() {
        return this.lon;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Integer getOffset() {
        return this.offset;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getOrg() {
        return this.org;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getQuery() {
        return this.query;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getRegion() {
        return this.region;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getRegionName() {
        return this.regionName;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getTimezone() {
        return this.timezone;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAsname() {
        return this.asname;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getZip() {
        return this.zip;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCity() {
        return this.city;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getContinent() {
        return this.continent;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getContinentCode() {
        return this.continentCode;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCountry() {
        return this.country;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getCountryCode() {
        return this.countryCode;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getDistrict() {
        return this.district;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getIsp() {
        return this.isp;
    }

    public final GeoResponse copy(String asn, String asname, String city, String continent, String continentCode, String country, String countryCode, String district, String isp, Boolean mobile, Double lat, Double lon, Integer offset, String org2, String query, String region, String regionName, String status, String timezone, String zip) {
        return new GeoResponse(asn, asname, city, continent, continentCode, country, countryCode, district, isp, mobile, lat, lon, offset, org2, query, region, regionName, status, timezone, zip);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GeoResponse)) {
            return false;
        }
        GeoResponse geoResponse = (GeoResponse) other;
        return Intrinsics.areEqual(this.asn, geoResponse.asn) && Intrinsics.areEqual(this.asname, geoResponse.asname) && Intrinsics.areEqual(this.city, geoResponse.city) && Intrinsics.areEqual(this.continent, geoResponse.continent) && Intrinsics.areEqual(this.continentCode, geoResponse.continentCode) && Intrinsics.areEqual(this.country, geoResponse.country) && Intrinsics.areEqual(this.countryCode, geoResponse.countryCode) && Intrinsics.areEqual(this.district, geoResponse.district) && Intrinsics.areEqual(this.isp, geoResponse.isp) && Intrinsics.areEqual(this.mobile, geoResponse.mobile) && Intrinsics.areEqual((Object) this.lat, (Object) geoResponse.lat) && Intrinsics.areEqual((Object) this.lon, (Object) geoResponse.lon) && Intrinsics.areEqual(this.offset, geoResponse.offset) && Intrinsics.areEqual(this.org, geoResponse.org) && Intrinsics.areEqual(this.query, geoResponse.query) && Intrinsics.areEqual(this.region, geoResponse.region) && Intrinsics.areEqual(this.regionName, geoResponse.regionName) && Intrinsics.areEqual(this.status, geoResponse.status) && Intrinsics.areEqual(this.timezone, geoResponse.timezone) && Intrinsics.areEqual(this.zip, geoResponse.zip);
    }

    public int hashCode() {
        String str = this.asn;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.asname;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.city;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.continent;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.continentCode;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.country;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.countryCode;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.district;
        int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.isp;
        int iHashCode9 = (iHashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Boolean bool = this.mobile;
        int iHashCode10 = (iHashCode9 + (bool == null ? 0 : bool.hashCode())) * 31;
        Double d = this.lat;
        int iHashCode11 = (iHashCode10 + (d == null ? 0 : d.hashCode())) * 31;
        Double d2 = this.lon;
        int iHashCode12 = (iHashCode11 + (d2 == null ? 0 : d2.hashCode())) * 31;
        Integer num = this.offset;
        int iHashCode13 = (iHashCode12 + (num == null ? 0 : num.hashCode())) * 31;
        String str10 = this.org;
        int iHashCode14 = (iHashCode13 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.query;
        int iHashCode15 = (iHashCode14 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.region;
        int iHashCode16 = (iHashCode15 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.regionName;
        int iHashCode17 = (iHashCode16 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.status;
        int iHashCode18 = (iHashCode17 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.timezone;
        int iHashCode19 = (iHashCode18 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.zip;
        return iHashCode19 + (str16 != null ? str16.hashCode() : 0);
    }

    public String toString() {
        return "GeoResponse(asn=" + this.asn + ", asname=" + this.asname + ", city=" + this.city + ", continent=" + this.continent + ", continentCode=" + this.continentCode + ", country=" + this.country + ", countryCode=" + this.countryCode + ", district=" + this.district + ", isp=" + this.isp + ", mobile=" + this.mobile + ", lat=" + this.lat + ", lon=" + this.lon + ", offset=" + this.offset + ", org=" + this.org + ", query=" + this.query + ", region=" + this.region + ", regionName=" + this.regionName + ", status=" + this.status + ", timezone=" + this.timezone + ", zip=" + this.zip + ")";
    }

    /* JADX INFO: compiled from: GeoResponse.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lio/datazoom/sdk/network/geo/model/GeoResponse$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/datazoom/sdk/network/geo/model/GeoResponse;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<GeoResponse> serializer() {
            return GeoResponse$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ GeoResponse(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Boolean bool, Double d, Double d2, Integer num, String str10, String str11, String str12, String str13, String str14, String str15, String str16, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.asn = null;
        } else {
            this.asn = str;
        }
        if ((i & 2) == 0) {
            this.asname = null;
        } else {
            this.asname = str2;
        }
        if ((i & 4) == 0) {
            this.city = null;
        } else {
            this.city = str3;
        }
        if ((i & 8) == 0) {
            this.continent = null;
        } else {
            this.continent = str4;
        }
        if ((i & 16) == 0) {
            this.continentCode = null;
        } else {
            this.continentCode = str5;
        }
        if ((i & 32) == 0) {
            this.country = null;
        } else {
            this.country = str6;
        }
        if ((i & 64) == 0) {
            this.countryCode = null;
        } else {
            this.countryCode = str7;
        }
        if ((i & 128) == 0) {
            this.district = null;
        } else {
            this.district = str8;
        }
        if ((i & 256) == 0) {
            this.isp = null;
        } else {
            this.isp = str9;
        }
        if ((i & 512) == 0) {
            this.mobile = null;
        } else {
            this.mobile = bool;
        }
        if ((i & 1024) == 0) {
            this.lat = null;
        } else {
            this.lat = d;
        }
        if ((i & 2048) == 0) {
            this.lon = null;
        } else {
            this.lon = d2;
        }
        if ((i & 4096) == 0) {
            this.offset = null;
        } else {
            this.offset = num;
        }
        if ((i & 8192) == 0) {
            this.org = null;
        } else {
            this.org = str10;
        }
        if ((i & 16384) == 0) {
            this.query = null;
        } else {
            this.query = str11;
        }
        if ((32768 & i) == 0) {
            this.region = null;
        } else {
            this.region = str12;
        }
        if ((65536 & i) == 0) {
            this.regionName = null;
        } else {
            this.regionName = str13;
        }
        if ((131072 & i) == 0) {
            this.status = null;
        } else {
            this.status = str14;
        }
        if ((262144 & i) == 0) {
            this.timezone = null;
        } else {
            this.timezone = str15;
        }
        if ((i & 524288) == 0) {
            this.zip = null;
        } else {
            this.zip = str16;
        }
    }

    public GeoResponse(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Boolean bool, Double d, Double d2, Integer num, String str10, String str11, String str12, String str13, String str14, String str15, String str16) {
        this.asn = str;
        this.asname = str2;
        this.city = str3;
        this.continent = str4;
        this.continentCode = str5;
        this.country = str6;
        this.countryCode = str7;
        this.district = str8;
        this.isp = str9;
        this.mobile = bool;
        this.lat = d;
        this.lon = d2;
        this.offset = num;
        this.org = str10;
        this.query = str11;
        this.region = str12;
        this.regionName = str13;
        this.status = str14;
        this.timezone = str15;
        this.zip = str16;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$base(GeoResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.asn != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.asn);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.asname != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.asname);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.city != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.city);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.continent != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.continent);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.continentCode != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.continentCode);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.country != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.country);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.countryCode != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.countryCode);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.district != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.district);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.isp != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.isp);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.mobile != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, BooleanSerializer.INSTANCE, self.mobile);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.lat != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, DoubleSerializer.INSTANCE, self.lat);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.lon != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, DoubleSerializer.INSTANCE, self.lon);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.offset != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, IntSerializer.INSTANCE, self.offset);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.org != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.org);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.query != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.query);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.region != null) {
            output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.region);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.regionName != null) {
            output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.regionName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.status != null) {
            output.encodeNullableSerializableElement(serialDesc, 17, StringSerializer.INSTANCE, self.status);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 18) || self.timezone != null) {
            output.encodeNullableSerializableElement(serialDesc, 18, StringSerializer.INSTANCE, self.timezone);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 19) && self.zip == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 19, StringSerializer.INSTANCE, self.zip);
    }

    public /* synthetic */ GeoResponse(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Boolean bool, Double d, Double d2, Integer num, String str10, String str11, String str12, String str13, String str14, String str15, String str16, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? null : bool, (i & 1024) != 0 ? null : d, (i & 2048) != 0 ? null : d2, (i & 4096) != 0 ? null : num, (i & 8192) != 0 ? null : str10, (i & 16384) != 0 ? null : str11, (i & 32768) != 0 ? null : str12, (i & 65536) != 0 ? null : str13, (i & 131072) != 0 ? null : str14, (i & 262144) != 0 ? null : str15, (i & 524288) != 0 ? null : str16);
    }

    public final String getAsn() {
        return this.asn;
    }

    public final void setAsn(String str) {
        this.asn = str;
    }

    public final String getAsname() {
        return this.asname;
    }

    public final void setAsname(String str) {
        this.asname = str;
    }

    public final String getCity() {
        return this.city;
    }

    public final void setCity(String str) {
        this.city = str;
    }

    public final String getContinent() {
        return this.continent;
    }

    public final void setContinent(String str) {
        this.continent = str;
    }

    public final String getContinentCode() {
        return this.continentCode;
    }

    public final void setContinentCode(String str) {
        this.continentCode = str;
    }

    public final String getCountry() {
        return this.country;
    }

    public final void setCountry(String str) {
        this.country = str;
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    public final void setCountryCode(String str) {
        this.countryCode = str;
    }

    public final String getDistrict() {
        return this.district;
    }

    public final void setDistrict(String str) {
        this.district = str;
    }

    public final String getIsp() {
        return this.isp;
    }

    public final void setIsp(String str) {
        this.isp = str;
    }

    public final Boolean getMobile() {
        return this.mobile;
    }

    public final void setMobile(Boolean bool) {
        this.mobile = bool;
    }

    public final Double getLat() {
        return this.lat;
    }

    public final void setLat(Double d) {
        this.lat = d;
    }

    public final Double getLon() {
        return this.lon;
    }

    public final void setLon(Double d) {
        this.lon = d;
    }

    public final Integer getOffset() {
        return this.offset;
    }

    public final void setOffset(Integer num) {
        this.offset = num;
    }

    public final String getOrg() {
        return this.org;
    }

    public final void setOrg(String str) {
        this.org = str;
    }

    public final String getQuery() {
        return this.query;
    }

    public final void setQuery(String str) {
        this.query = str;
    }

    public final String getRegion() {
        return this.region;
    }

    public final void setRegion(String str) {
        this.region = str;
    }

    public final String getRegionName() {
        return this.regionName;
    }

    public final void setRegionName(String str) {
        this.regionName = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getTimezone() {
        return this.timezone;
    }

    public final void setTimezone(String str) {
        this.timezone = str;
    }

    public final String getZip() {
        return this.zip;
    }

    public final void setZip(String str) {
        this.zip = str;
    }
}

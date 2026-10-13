package io.datazoom.sdk.data.memory;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.domain.SessionManager;
import io.datazoom.sdk.model.DeviceInfo;
import io.datazoom.sdk.model.MetaData;
import io.datazoom.sdk.network.geo.model.GeoResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MetaDataStoreExtensions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a)\u0010\u0000\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\t0\n0\u0005j\u0002`\u000b*\u00020\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a)\u0010\u0003\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\t0\n0\u0005j\u0002`\u000b*\u00020\u0002\u001a\u0012\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e\u001a)\u0010\f\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\t0\n0\u0005j\u0002`\u000b*\u00020\u0002\u001a)\u0010\u000f\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\t0\n0\u0005j\u0002`\u000b*\u00020\u0002\u001a)\u0010\u0010\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\t0\n0\u0005j\u0002`\u000b*\u00020\u0002\u001a)\u0010\u0011\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\t0\n0\u0005j\u0002`\u000b*\u00020\u0002\u001a)\u0010\u0012\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\t0\n0\u0005j\u0002`\u000b*\u00020\u0002\u001aI\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014*!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\t0\n0\u0005j\u0002`\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u001a \u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016\u001a\u009f\u0001\u0010\u0019\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\t0\n0\u0005j\u0002`\u000b*!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\t0\n0\u0005j\u0002`\u000b2P\u0010\u001a\u001a)\u0012%\b\u0001\u0012!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\t0\n0\u0005j\u0002`\u000b0\u001b\"!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\t0\n0\u0005j\u0002`\u000b¢\u0006\u0002\u0010\u001c\u001a1\u0010\u001d\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\t0\n0\u0005j\u0002`\u000b*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f\u001a1\u0010 \u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\t0\n0\u0005j\u0002`\u000b*\u00020\u00022\u0006\u0010!\u001a\u00020\u001f\u001a\u0015\u0010\"\u001a\u00020#*\u00020\u00162\u0006\u0010$\u001a\u00020\u0007H\u0086\u0004¨\u0006%"}, d2 = {"network", "", "Lio/datazoom/sdk/data/memory/MetaDataStore;", "geo", "Lio/datazoom/sdk/network/geo/model/GeoResponse;", "Ljava/util/HashMap;", "", "", "Lkotlinx/serialization/Serializable;", "with", "Lio/datazoom/sdk/utils/AnySerializer;", "Lio/datazoom/sdk/utils/DataMap;", "device", "info", "Lio/datazoom/sdk/model/DeviceInfo;", "video", "ad", "player", "page", "getEntryPair", "Lkotlin/Pair;", "type", "Lio/datazoom/sdk/model/MetaData$Type;", "removeFromParent", "", "exclude", "data", "", "(Ljava/util/HashMap;[Ljava/util/HashMap;)Ljava/util/HashMap;", "all", "appSession", "Lio/datazoom/sdk/domain/SessionManager;", "user", "sessionManager", "to", "Lio/datazoom/sdk/model/MetaData;", "that", Constants.SENSITIVITY_BASE}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class MetaDataStoreExtensionsKt {
    public static final void network(MetaDataStore metaDataStore, GeoResponse geo) {
        Intrinsics.checkNotNullParameter(metaDataStore, "<this>");
        Intrinsics.checkNotNullParameter(geo, "geo");
        String asn = geo.getAsn();
        if (asn != null) {
            metaDataStore.put(MetaData.Type.ASN, asn);
        }
        String org2 = geo.getOrg();
        if (org2 != null) {
            metaDataStore.put(MetaData.Type.ASN_ORGANIZATION, org2);
        }
        String isp = geo.getIsp();
        if (isp != null) {
            metaDataStore.put(MetaData.Type.ISP, isp);
        }
        Boolean mobile = geo.getMobile();
        if (mobile != null) {
            mobile.booleanValue();
            metaDataStore.put(MetaData.Type.MOBILE_CONNECTION, mobile);
        }
    }

    public static final HashMap<String, Object> network(MetaDataStore metaDataStore) {
        Intrinsics.checkNotNullParameter(metaDataStore, "<this>");
        HashMap<String, Object> map = new HashMap<>();
        Pair<String, Object> entryPair = getEntryPair(metaDataStore, MetaData.Type.MOBILE_CONNECTION);
        if (entryPair != null) {
            map.put(entryPair.getFirst(), entryPair.getSecond());
        }
        Pair<String, Object> entryPair2 = getEntryPair(metaDataStore, MetaData.Type.ASN);
        if (entryPair2 != null) {
            map.put(entryPair2.getFirst(), entryPair2.getSecond());
        }
        Pair<String, Object> entryPair3 = getEntryPair(metaDataStore, MetaData.Type.ASN_ORGANIZATION);
        if (entryPair3 != null) {
            map.put(entryPair3.getFirst(), entryPair3.getSecond());
        }
        Pair<String, Object> entryPair4 = getEntryPair(metaDataStore, MetaData.Type.ISP);
        if (entryPair4 != null) {
            map.put(entryPair4.getFirst(), entryPair4.getSecond());
        }
        return map;
    }

    public static final void geo(MetaDataStore metaDataStore, GeoResponse geo) {
        Intrinsics.checkNotNullParameter(metaDataStore, "<this>");
        Intrinsics.checkNotNullParameter(geo, "geo");
        String continent = geo.getContinent();
        if (continent != null) {
            metaDataStore.put(MetaData.Type.CONTINENT, continent);
        }
        String country = geo.getCountry();
        if (country != null) {
            metaDataStore.put(MetaData.Type.COUNTRY, country);
        }
        String city = geo.getCity();
        if (city != null) {
            metaDataStore.put(MetaData.Type.CITY, city);
        }
        Integer offset = geo.getOffset();
        if (offset != null) {
            metaDataStore.put(MetaData.Type.TIMEZONE_OFFSET, Float.valueOf(offset.intValue() / 3600.0f));
        }
        Double lat = geo.getLat();
        if (lat != null) {
            metaDataStore.put(MetaData.Type.LATITUDE, Double.valueOf(lat.doubleValue()));
        }
        Double lon = geo.getLon();
        if (lon != null) {
            metaDataStore.put(MetaData.Type.LONGITUDE, Double.valueOf(lon.doubleValue()));
        }
        String continentCode = geo.getContinentCode();
        if (continentCode != null) {
            metaDataStore.put(MetaData.Type.CONTINENT_CODE, continentCode);
        }
        String countryCode = geo.getCountryCode();
        if (countryCode != null) {
            metaDataStore.put(MetaData.Type.COUNTRY_CODE, countryCode);
        }
        String district = geo.getDistrict();
        if (district != null) {
            metaDataStore.put(MetaData.Type.DISTRICT, district);
        }
        String timezone = geo.getTimezone();
        if (timezone != null) {
            metaDataStore.put(MetaData.Type.TIMEZONE_NAME, timezone);
        }
        String zip = geo.getZip();
        if (zip != null) {
            metaDataStore.put(MetaData.Type.POSTAL_CODE, zip);
        }
        String regionName = geo.getRegionName();
        if (regionName != null) {
            metaDataStore.put(MetaData.Type.REGION, regionName);
        }
        String region = geo.getRegion();
        if (region != null) {
            metaDataStore.put(MetaData.Type.REGION_CODE, region);
        }
    }

    public static final HashMap<String, Object> geo(MetaDataStore metaDataStore) {
        Intrinsics.checkNotNullParameter(metaDataStore, "<this>");
        HashMap<String, Object> map = new HashMap<>();
        Pair<String, Object> entryPair = getEntryPair(metaDataStore, MetaData.Type.CONTINENT);
        if (entryPair != null) {
            map.put(entryPair.getFirst(), entryPair.getSecond());
        }
        Pair<String, Object> entryPair2 = getEntryPair(metaDataStore, MetaData.Type.COUNTRY);
        if (entryPair2 != null) {
            map.put(entryPair2.getFirst(), entryPair2.getSecond());
        }
        Pair<String, Object> entryPair3 = getEntryPair(metaDataStore, MetaData.Type.CITY);
        if (entryPair3 != null) {
            map.put(entryPair3.getFirst(), entryPair3.getSecond());
        }
        Pair<String, Object> entryPair4 = getEntryPair(metaDataStore, MetaData.Type.TIMEZONE_OFFSET);
        if (entryPair4 != null) {
            map.put(entryPair4.getFirst(), entryPair4.getSecond());
        }
        Pair<String, Object> entryPair5 = getEntryPair(metaDataStore, MetaData.Type.LATITUDE);
        if (entryPair5 != null) {
            map.put(entryPair5.getFirst(), entryPair5.getSecond());
        }
        Pair<String, Object> entryPair6 = getEntryPair(metaDataStore, MetaData.Type.LONGITUDE);
        if (entryPair6 != null) {
            map.put(entryPair6.getFirst(), entryPair6.getSecond());
        }
        Pair<String, Object> entryPair7 = getEntryPair(metaDataStore, MetaData.Type.CONTINENT_CODE);
        if (entryPair7 != null) {
            map.put(entryPair7.getFirst(), entryPair7.getSecond());
        }
        Pair<String, Object> entryPair8 = getEntryPair(metaDataStore, MetaData.Type.COUNTRY_CODE);
        if (entryPair8 != null) {
            map.put(entryPair8.getFirst(), entryPair8.getSecond());
        }
        Pair<String, Object> entryPair9 = getEntryPair(metaDataStore, MetaData.Type.TIMEZONE_NAME);
        if (entryPair9 != null) {
            map.put(entryPair9.getFirst(), entryPair9.getSecond());
        }
        Pair<String, Object> entryPair10 = getEntryPair(metaDataStore, MetaData.Type.POSTAL_CODE);
        if (entryPair10 != null) {
            map.put(entryPair10.getFirst(), entryPair10.getSecond());
        }
        Pair<String, Object> entryPair11 = getEntryPair(metaDataStore, MetaData.Type.REGION);
        if (entryPair11 != null) {
            map.put(entryPair11.getFirst(), entryPair11.getSecond());
        }
        Pair<String, Object> entryPair12 = getEntryPair(metaDataStore, MetaData.Type.REGION_CODE);
        if (entryPair12 != null) {
            map.put(entryPair12.getFirst(), entryPair12.getSecond());
        }
        Pair<String, Object> entryPair13 = getEntryPair(metaDataStore, MetaData.Type.DISTRICT);
        if (entryPair13 != null) {
            map.put(entryPair13.getFirst(), entryPair13.getSecond());
        }
        return map;
    }

    public static final void device(MetaDataStore metaDataStore, DeviceInfo info) {
        Intrinsics.checkNotNullParameter(metaDataStore, "<this>");
        Intrinsics.checkNotNullParameter(info, "info");
        metaDataStore.put(to(MetaData.Type.DEVICE_MFG, info.getManufacturer()));
        metaDataStore.put(to(MetaData.Type.ORIENTATION, info.getOrientation()));
        metaDataStore.put(to(MetaData.Type.DEVICE_NAME, info.getName()));
        metaDataStore.put(to(MetaData.Type.DEVICE_ID, info.getId()));
        metaDataStore.put(to(MetaData.Type.OS_VERSION, info.getOsVersion()));
        metaDataStore.put(to(MetaData.Type.OS_NAME, info.getOsName()));
        metaDataStore.put(to(MetaData.Type.DEVICE_TYPE, info.getType()));
        metaDataStore.put(to(MetaData.Type.FULLSCREEN, Boolean.valueOf(info.isFullScreen())));
    }

    public static final HashMap<String, Object> device(MetaDataStore metaDataStore) {
        Intrinsics.checkNotNullParameter(metaDataStore, "<this>");
        HashMap<String, Object> map = new HashMap<>();
        Pair<String, Object> entryPair = getEntryPair(metaDataStore, MetaData.Type.DEVICE_MFG);
        if (entryPair != null) {
            map.put(entryPair.getFirst(), entryPair.getSecond());
        }
        Pair<String, Object> entryPair2 = getEntryPair(metaDataStore, MetaData.Type.ORIENTATION);
        if (entryPair2 != null) {
            map.put(entryPair2.getFirst(), entryPair2.getSecond());
        }
        Pair<String, Object> entryPair3 = getEntryPair(metaDataStore, MetaData.Type.DEVICE_NAME);
        if (entryPair3 != null) {
            map.put(entryPair3.getFirst(), entryPair3.getSecond());
        }
        Pair<String, Object> entryPair4 = getEntryPair(metaDataStore, MetaData.Type.DEVICE_ID);
        if (entryPair4 != null) {
            map.put(entryPair4.getFirst(), entryPair4.getSecond());
        }
        Pair<String, Object> entryPair5 = getEntryPair(metaDataStore, MetaData.Type.OS_VERSION);
        if (entryPair5 != null) {
            map.put(entryPair5.getFirst(), entryPair5.getSecond());
        }
        Pair<String, Object> entryPair6 = getEntryPair(metaDataStore, MetaData.Type.ADVERTISING_ID);
        if (entryPair6 != null) {
            map.put(entryPair6.getFirst(), entryPair6.getSecond());
        }
        Pair<String, Object> entryPair7 = getEntryPair(metaDataStore, MetaData.Type.AD_TRACKING_OPT_OUT);
        if (entryPair7 != null) {
            map.put(entryPair7.getFirst(), entryPair7.getSecond());
        }
        Pair<String, Object> entryPair8 = getEntryPair(metaDataStore, MetaData.Type.OS_NAME);
        if (entryPair8 != null) {
            map.put(entryPair8.getFirst(), entryPair8.getSecond());
        }
        Pair<String, Object> entryPair9 = getEntryPair(metaDataStore, MetaData.Type.DEVICE_TYPE);
        if (entryPair9 != null) {
            map.put(entryPair9.getFirst(), entryPair9.getSecond());
        }
        return map;
    }

    public static final HashMap<String, Object> video(MetaDataStore metaDataStore) {
        Intrinsics.checkNotNullParameter(metaDataStore, "<this>");
        HashMap<String, Object> map = new HashMap<>();
        Pair<String, Object> entryPair = getEntryPair(metaDataStore, MetaData.Type.ASSET_ID);
        if (entryPair != null) {
            map.put(entryPair.getFirst(), entryPair.getSecond());
        }
        Pair<String, Object> entryPair2 = getEntryPair(metaDataStore, MetaData.Type.DESCRIPTION);
        if (entryPair2 != null) {
            map.put(entryPair2.getFirst(), entryPair2.getSecond());
        }
        Pair<String, Object> entryPair3 = getEntryPair(metaDataStore, MetaData.Type.DURATION);
        if (entryPair3 != null) {
            map.put(entryPair3.getFirst(), entryPair3.getSecond());
        }
        Pair<String, Object> entryPair4 = getEntryPair(metaDataStore, MetaData.Type.FRAME_RATE);
        if (entryPair4 != null) {
            map.put(entryPair4.getFirst(), entryPair4.getSecond());
        }
        Pair<String, Object> entryPair5 = getEntryPair(metaDataStore, MetaData.Type.MEDIA_TYPE);
        if (entryPair5 != null) {
            map.put(entryPair5.getFirst(), entryPair5.getSecond());
        }
        Pair<String, Object> entryPair6 = getEntryPair(metaDataStore, MetaData.Type.PLAYER_HEIGHT);
        if (entryPair6 != null) {
            map.put(entryPair6.getFirst(), entryPair6.getSecond());
        }
        Pair<String, Object> entryPair7 = getEntryPair(metaDataStore, MetaData.Type.PLAYER_WIDTH);
        if (entryPair7 != null) {
            map.put(entryPair7.getFirst(), entryPair7.getSecond());
        }
        Pair<String, Object> entryPair8 = getEntryPair(metaDataStore, MetaData.Type.SOURCE);
        if (entryPair8 != null) {
            map.put(entryPair8.getFirst(), entryPair8.getSecond());
        }
        Pair<String, Object> entryPair9 = getEntryPair(metaDataStore, MetaData.Type.TITLE);
        if (entryPair9 != null) {
            map.put(entryPair9.getFirst(), entryPair9.getSecond());
        }
        return map;
    }

    public static final HashMap<String, Object> ad(MetaDataStore metaDataStore) {
        Intrinsics.checkNotNullParameter(metaDataStore, "<this>");
        HashMap<String, Object> map = new HashMap<>();
        Pair<String, Object> entryPair = getEntryPair(metaDataStore, MetaData.Type.AD_ID);
        if (entryPair != null) {
            map.put(entryPair.getFirst(), entryPair.getSecond());
        }
        Pair<String, Object> entryPair2 = getEntryPair(metaDataStore, MetaData.Type.AD_POSITION);
        if (entryPair2 != null) {
            map.put(entryPair2.getFirst(), entryPair2.getSecond());
        }
        Pair<String, Object> entryPair3 = getEntryPair(metaDataStore, MetaData.Type.AD_TIME_OFFSET);
        if (entryPair3 != null) {
            map.put(entryPair3.getFirst(), entryPair3.getSecond());
        }
        Pair<String, Object> entryPair4 = getEntryPair(metaDataStore, MetaData.Type.AD_SYSTEM);
        if (entryPair4 != null) {
            map.put(entryPair4.getFirst(), entryPair4.getSecond());
        }
        Pair<String, Object> entryPair5 = getEntryPair(metaDataStore, MetaData.Type.AD_CLICK_URL);
        if (entryPair5 != null) {
            map.put(entryPair5.getFirst(), entryPair5.getSecond());
        }
        Pair<String, Object> entryPair6 = getEntryPair(metaDataStore, MetaData.Type.AD_DURATION_SEC);
        if (entryPair6 != null) {
            map.put(entryPair6.getFirst(), entryPair6.getSecond());
        }
        Pair<String, Object> entryPair7 = getEntryPair(metaDataStore, MetaData.Type.AD_BREAK_ID);
        if (entryPair7 != null) {
            map.put(entryPair7.getFirst(), entryPair7.getSecond());
        }
        Pair<String, Object> entryPair8 = getEntryPair(metaDataStore, MetaData.Type.AD_SESSION_ID);
        if (entryPair8 != null) {
            map.put(entryPair8.getFirst(), entryPair8.getSecond());
        }
        Pair<String, Object> entryPair9 = getEntryPair(metaDataStore, MetaData.Type.AD_CREATIVE_ID);
        if (entryPair9 != null) {
            map.put(entryPair9.getFirst(), entryPair9.getSecond());
        }
        Pair<String, Object> entryPair10 = getEntryPair(metaDataStore, MetaData.Type.AD_PARTNER);
        if (entryPair10 != null) {
            map.put(entryPair10.getFirst(), entryPair10.getSecond());
        }
        Pair<String, Object> entryPair11 = getEntryPair(metaDataStore, MetaData.Type.AD_SKIPPED);
        if (entryPair11 != null) {
            map.put(entryPair11.getFirst(), entryPair11.getSecond());
        }
        return map;
    }

    public static final HashMap<String, Object> player(MetaDataStore metaDataStore) {
        Intrinsics.checkNotNullParameter(metaDataStore, "<this>");
        HashMap<String, Object> map = new HashMap<>();
        Pair<String, Object> entryPair = getEntryPair(metaDataStore, MetaData.Type.SUBTITLES);
        if (entryPair != null) {
            map.put(entryPair.getFirst(), entryPair.getSecond());
        }
        Pair<String, Object> entryPair2 = getEntryPair(metaDataStore, MetaData.Type.AUTOSTART);
        if (entryPair2 != null) {
            map.put(entryPair2.getFirst(), entryPair2.getSecond());
        }
        Pair<String, Object> entryPair3 = getEntryPair(metaDataStore, MetaData.Type.PLAYBACK_RATE_DEFAULT);
        if (entryPair3 != null) {
            map.put(entryPair3.getFirst(), entryPair3.getSecond());
        }
        Pair<String, Object> entryPair4 = getEntryPair(metaDataStore, MetaData.Type.DEFAULT_MUTED);
        if (entryPair4 != null) {
            map.put(entryPair4.getFirst(), entryPair4.getSecond());
        }
        Pair<String, Object> entryPair5 = getEntryPair(metaDataStore, MetaData.Type.MUTED);
        if (entryPair5 != null) {
            map.put(entryPair5.getFirst(), entryPair5.getSecond());
        }
        Pair<String, Object> entryPair6 = getEntryPair(metaDataStore, MetaData.Type.FULLSCREEN);
        if (entryPair6 != null) {
            map.put(entryPair6.getFirst(), entryPair6.getSecond());
        }
        Pair<String, Object> entryPair7 = getEntryPair(metaDataStore, MetaData.Type.PLAYER_VERSION);
        if (entryPair7 != null) {
            map.put(entryPair7.getFirst(), entryPair7.getSecond());
        }
        Pair<String, Object> entryPair8 = getEntryPair(metaDataStore, MetaData.Type.CASTING);
        if (entryPair8 != null) {
            map.put(entryPair8.getFirst(), entryPair8.getSecond());
        }
        Pair<String, Object> entryPair9 = getEntryPair(metaDataStore, MetaData.Type.PLAYER_NAME);
        if (entryPair9 != null) {
            map.put(entryPair9.getFirst(), entryPair9.getSecond());
        }
        Pair<String, Object> entryPair10 = getEntryPair(metaDataStore, MetaData.Type.STREAMING_TYPE);
        if (entryPair10 != null) {
            map.put(entryPair10.getFirst(), entryPair10.getSecond());
        }
        Pair<String, Object> entryPair11 = getEntryPair(metaDataStore, MetaData.Type.READY_STATE);
        if (entryPair11 != null) {
            map.put(entryPair11.getFirst(), Integer.valueOf(Intrinsics.areEqual(entryPair11.getSecond(), (Object) true) ? 1 : 0));
        }
        Pair<String, Object> entryPair12 = getEntryPair(metaDataStore, MetaData.Type.CONTROLS);
        if (entryPair12 != null) {
            map.put(entryPair12.getFirst(), entryPair12.getSecond());
        }
        Pair<String, Object> entryPair13 = getEntryPair(metaDataStore, MetaData.Type.LOOP);
        if (entryPair13 != null) {
            map.put(entryPair13.getFirst(), entryPair13.getSecond());
        }
        Pair<String, Object> entryPair14 = getEntryPair(metaDataStore, MetaData.Type.STREAMING_PROTOCOL);
        if (entryPair14 != null) {
            map.put(entryPair14.getFirst(), entryPair14.getSecond());
        }
        return map;
    }

    public static final HashMap<String, Object> page(MetaDataStore metaDataStore) {
        Intrinsics.checkNotNullParameter(metaDataStore, "<this>");
        HashMap<String, Object> map = new HashMap<>();
        Pair<String, Object> entryPair = getEntryPair(metaDataStore, MetaData.Type.DZ_SDK_VERSION);
        if (entryPair != null) {
            map.put(entryPair.getFirst(), entryPair.getSecond());
        }
        return map;
    }

    public static /* synthetic */ Pair getEntryPair$default(HashMap map, MetaData.Type type, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return getEntryPair(map, type, z);
    }

    public static final Pair<String, Object> getEntryPair(HashMap<String, Object> map, MetaData.Type type, boolean z) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        Object obj = map.get(type.getValue());
        Pair<String, Object> pair = obj != null ? TuplesKt.to(type.getValue(), obj) : null;
        if (z) {
            map.remove(type.getValue());
        }
        return pair;
    }

    public static final Pair<String, Object> getEntryPair(MetaDataStore metaDataStore, MetaData.Type type) {
        Intrinsics.checkNotNullParameter(metaDataStore, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        Object obj = metaDataStore.get(type);
        if (obj != null) {
            return TuplesKt.to(type.getValue(), obj);
        }
        return null;
    }

    public static final HashMap<String, Object> exclude(HashMap<String, Object> map, HashMap<String, Object>... data) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        HashMap<String, Object> map2 = new HashMap<>(map);
        for (HashMap<String, Object> map3 : data) {
            Iterator<Map.Entry<String, Object>> it = map3.entrySet().iterator();
            while (it.hasNext()) {
                map2.remove(it.next().getKey());
            }
        }
        return map2;
    }

    public static final HashMap<String, Object> all(MetaDataStore metaDataStore, SessionManager appSession) {
        Intrinsics.checkNotNullParameter(metaDataStore, "<this>");
        Intrinsics.checkNotNullParameter(appSession, "appSession");
        return exclude(metaDataStore.getAll(), device(metaDataStore), geo(metaDataStore), network(metaDataStore), page(metaDataStore), user(metaDataStore, appSession));
    }

    public static final HashMap<String, Object> user(MetaDataStore metaDataStore, SessionManager sessionManager) {
        Intrinsics.checkNotNullParameter(metaDataStore, "<this>");
        Intrinsics.checkNotNullParameter(sessionManager, "sessionManager");
        HashMap<String, Object> map = new HashMap<>();
        SessionManager.Session sessionCurrentSession = sessionManager.currentSession();
        HashMap<String, Object> map2 = map;
        map2.put(MetaData.Type.APP_SESSION_ID.getValue(), sessionCurrentSession.getId());
        map2.put(MetaData.Type.APP_SESSION_START_TS_MS.getValue(), Long.valueOf(sessionCurrentSession.getTime()));
        Pair<String, Object> entryPair = getEntryPair(metaDataStore, MetaData.Type.USER_AGENT);
        if (entryPair != null) {
            map.put(entryPair.getFirst(), entryPair.getSecond());
        }
        Pair<String, Object> entryPair2 = getEntryPair(metaDataStore, MetaData.Type.CLIENT_IP);
        if (entryPair2 != null) {
            map.put(entryPair2.getFirst(), entryPair2.getSecond());
        }
        return map;
    }

    public static final MetaData to(MetaData.Type type, Object that) {
        Intrinsics.checkNotNullParameter(type, "<this>");
        Intrinsics.checkNotNullParameter(that, "that");
        return new MetaData(type, that);
    }
}

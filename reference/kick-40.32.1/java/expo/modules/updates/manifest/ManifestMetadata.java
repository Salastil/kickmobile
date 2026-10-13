package expo.modules.updates.manifest;

import android.util.Log;
import expo.modules.structuredheaders.Dictionary;
import expo.modules.structuredheaders.StringItem;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.db.UpdatesDatabase;
import expo.modules.updates.db.dao.JSONDataDao;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ManifestMetadata.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0018\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ$\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ(\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005J\u001e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0012*\u00020\bH\u0002R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lexpo/modules/updates/manifest/ManifestMetadata;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getJSONObject", "Lorg/json/JSONObject;", "key", "Lexpo/modules/updates/db/dao/JSONDataDao$JSONDataKey;", "database", "Lexpo/modules/updates/db/UpdatesDatabase;", "configuration", "Lexpo/modules/updates/UpdatesConfiguration;", "getServerDefinedHeaders", "getManifestFilters", "getExtraParams", "", "setExtraParam", "", "value", "saveMetadata", "responseHeaderData", "Lexpo/modules/updates/manifest/ResponseHeaderData;", "clearMetadataForBuildDataClearOperation", "asStringStringMap", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ManifestMetadata {
    public static final ManifestMetadata INSTANCE = new ManifestMetadata();
    private static final String TAG = "ManifestMetadata";

    private ManifestMetadata() {
    }

    private final JSONObject getJSONObject(JSONDataDao.JSONDataKey key, UpdatesDatabase database, UpdatesConfiguration configuration) {
        try {
            JSONDataDao jsonDataDao = database.jsonDataDao();
            Intrinsics.checkNotNull(jsonDataDao);
            String strLoadJSONStringForKey = jsonDataDao.loadJSONStringForKey(key, configuration.getScopeKey());
            if (strLoadJSONStringForKey != null) {
                return new JSONObject(strLoadJSONStringForKey);
            }
            return null;
        } catch (Exception e) {
            Log.e(TAG, "Error retrieving " + key + " from database", e);
            return null;
        }
    }

    @JvmStatic
    public static final JSONObject getServerDefinedHeaders(UpdatesDatabase database, UpdatesConfiguration configuration) {
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        return INSTANCE.getJSONObject(JSONDataDao.JSONDataKey.MANIFEST_SERVER_DEFINED_HEADERS, database, configuration);
    }

    public final JSONObject getManifestFilters(UpdatesDatabase database, UpdatesConfiguration configuration) {
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        return getJSONObject(JSONDataDao.JSONDataKey.MANIFEST_FILTERS, database, configuration);
    }

    public final Map<String, String> getExtraParams(UpdatesDatabase database, UpdatesConfiguration configuration) {
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        JSONObject jSONObject = getJSONObject(JSONDataDao.JSONDataKey.EXTRA_PARAMS, database, configuration);
        if (jSONObject != null) {
            return asStringStringMap(jSONObject);
        }
        return null;
    }

    public final void setExtraParam(UpdatesDatabase database, UpdatesConfiguration configuration, final String key, final String value) {
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(key, "key");
        JSONDataDao jsonDataDao = database.jsonDataDao();
        Intrinsics.checkNotNull(jsonDataDao);
        jsonDataDao.updateJSONStringForKey(JSONDataDao.JSONDataKey.EXTRA_PARAMS, configuration.getScopeKey(), new Function1() { // from class: expo.modules.updates.manifest.ManifestMetadata$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ManifestMetadata.setExtraParam$lambda$0(value, key, (String) obj);
            }
        });
    }

    static final String setExtraParam$lambda$0(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap;
        Map<String, String> mapAsStringStringMap;
        JSONObject jSONObject = str3 != null ? new JSONObject(str3) : null;
        if (jSONObject == null || (mapAsStringStringMap = INSTANCE.asStringStringMap(jSONObject)) == null || (linkedHashMap = MapsKt.toMutableMap(mapAsStringStringMap)) == null) {
            linkedHashMap = new LinkedHashMap();
        }
        if (str != null) {
            linkedHashMap.put(str2, str);
        } else {
            linkedHashMap.remove(str2);
        }
        Map map = MapsKt.toMap(linkedHashMap);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap2.put(entry.getKey(), StringItem.valueOf((String) entry.getValue()));
        }
        Dictionary.valueOf(linkedHashMap2).serialize();
        String string = new JSONObject(map).toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final void saveMetadata(ResponseHeaderData responseHeaderData, UpdatesDatabase database, UpdatesConfiguration configuration) {
        Intrinsics.checkNotNullParameter(responseHeaderData, "responseHeaderData");
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (responseHeaderData.getServerDefinedHeaders() != null) {
            linkedHashMap.put(JSONDataDao.JSONDataKey.MANIFEST_SERVER_DEFINED_HEADERS, String.valueOf(responseHeaderData.getServerDefinedHeaders()));
        }
        if (responseHeaderData.getManifestFilters() != null) {
            linkedHashMap.put(JSONDataDao.JSONDataKey.MANIFEST_FILTERS, String.valueOf(responseHeaderData.getManifestFilters()));
        }
        if (linkedHashMap.isEmpty()) {
            return;
        }
        JSONDataDao jsonDataDao = database.jsonDataDao();
        Intrinsics.checkNotNull(jsonDataDao);
        jsonDataDao.setMultipleFields(linkedHashMap, configuration.getScopeKey());
    }

    public final void clearMetadataForBuildDataClearOperation(UpdatesDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        JSONDataDao jsonDataDao = database.jsonDataDao();
        Intrinsics.checkNotNull(jsonDataDao);
        jsonDataDao.deleteJSONDataForKeysForAllScopeKeys(CollectionsKt.listOf((Object[]) new JSONDataDao.JSONDataKey[]{JSONDataDao.JSONDataKey.EXTRA_PARAMS, JSONDataDao.JSONDataKey.MANIFEST_SERVER_DEFINED_HEADERS, JSONDataDao.JSONDataKey.MANIFEST_FILTERS}));
    }

    private final Map<String, String> asStringStringMap(JSONObject jSONObject) throws JSONException {
        String string;
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        Iterator<String> itKeys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(itKeys, "keys(...)");
        for (String str : SequencesKt.asSequence(itKeys)) {
            Intrinsics.checkNotNull(str);
            if (Intrinsics.areEqual(String.class, String.class)) {
                string = jSONObject.getString(str);
                if (string == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(String.class, Double.class)) {
                string = (String) Double.valueOf(jSONObject.getDouble(str));
            } else if (Intrinsics.areEqual(String.class, Integer.class)) {
                string = (String) Integer.valueOf(jSONObject.getInt(str));
            } else if (Intrinsics.areEqual(String.class, Long.class)) {
                string = (String) Long.valueOf(jSONObject.getLong(str));
            } else if (Intrinsics.areEqual(String.class, Boolean.class)) {
                string = (String) Boolean.valueOf(jSONObject.getBoolean(str));
            } else if (Intrinsics.areEqual(String.class, JSONArray.class)) {
                Object jSONArray = jSONObject.getJSONArray(str);
                if (jSONArray == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                string = (String) jSONArray;
            } else if (Intrinsics.areEqual(String.class, JSONObject.class)) {
                Object jSONObject2 = jSONObject.getJSONObject(str);
                if (jSONObject2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                string = (String) jSONObject2;
            } else {
                Object obj = jSONObject.get(str);
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                string = (String) obj;
            }
            mapCreateMapBuilder.put(str, string);
        }
        return MapsKt.build(mapCreateMapBuilder);
    }
}

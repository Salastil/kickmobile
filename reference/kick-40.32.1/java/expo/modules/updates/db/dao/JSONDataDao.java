package expo.modules.updates.db.dao;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.db.entity.JSONDataEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JSONDataDao.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH%J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H%J\u0018\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH%J\u0016\u0010\u000e\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H%J\u0018\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\bJ \u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0017J$\u0010\u0014\u001a\u00020\u000b2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\b0\u00162\u0006\u0010\t\u001a\u00020\bH\u0017J=\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2#\u0010\u0018\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\b0\u0019H\u0017J\u0016\u0010\u001d\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0005H\u0017¨\u0006\u001f"}, d2 = {"Lexpo/modules/updates/db/dao/JSONDataDao;", "", "<init>", "()V", "loadJSONDataForKeyInternal", "", "Lexpo/modules/updates/db/entity/JSONDataEntity;", "key", "", UpdatesConfiguration.UPDATES_CONFIGURATION_SCOPE_KEY_KEY, "insertJSONDataInternal", "", "jsonDataEntity", "deleteJSONDataForKeyInternal", "deleteJSONDataForKeysForAllScopeKeysInternal", UserMetadata.KEYDATA_FILENAME, "loadJSONStringForKey", "Lexpo/modules/updates/db/dao/JSONDataDao$JSONDataKey;", "setJSONStringForKey", "value", "setMultipleFields", "fields", "", "updateJSONStringForKey", "updater", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "previousValue", "deleteJSONDataForKeysForAllScopeKeys", "JSONDataKey", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class JSONDataDao {
    protected abstract void deleteJSONDataForKeyInternal(String key, String scopeKey);

    protected abstract void deleteJSONDataForKeysForAllScopeKeysInternal(List<String> keys);

    protected abstract void insertJSONDataInternal(JSONDataEntity jsonDataEntity);

    protected abstract List<JSONDataEntity> loadJSONDataForKeyInternal(String key, String scopeKey);

    /* JADX INFO: compiled from: JSONDataDao.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/updates/db/dao/JSONDataDao$JSONDataKey;", "", "key", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "STATIC_BUILD_DATA", "EXTRA_PARAMS", "MANIFEST_SERVER_DEFINED_HEADERS", "MANIFEST_FILTERS", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum JSONDataKey {
        STATIC_BUILD_DATA("staticBuildData"),
        EXTRA_PARAMS("extraParams"),
        MANIFEST_SERVER_DEFINED_HEADERS("serverDefinedHeaders"),
        MANIFEST_FILTERS("manifestFilters");

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        private final String key;

        public static EnumEntries<JSONDataKey> getEntries() {
            return $ENTRIES;
        }

        JSONDataKey(String str) {
            this.key = str;
        }

        public final String getKey() {
            return this.key;
        }
    }

    public final String loadJSONStringForKey(JSONDataKey key, String scopeKey) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(scopeKey, "scopeKey");
        List<JSONDataEntity> listLoadJSONDataForKeyInternal = loadJSONDataForKeyInternal(key.getKey(), scopeKey);
        if (listLoadJSONDataForKeyInternal.isEmpty()) {
            return null;
        }
        return listLoadJSONDataForKeyInternal.get(0).getValue();
    }

    public void setJSONStringForKey(JSONDataKey key, String value, String scopeKey) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(scopeKey, "scopeKey");
        deleteJSONDataForKeyInternal(key.getKey(), scopeKey);
        insertJSONDataInternal(new JSONDataEntity(key.getKey(), value, new Date(), scopeKey));
    }

    public void setMultipleFields(Map<JSONDataKey, String> fields, String scopeKey) {
        Intrinsics.checkNotNullParameter(fields, "fields");
        Intrinsics.checkNotNullParameter(scopeKey, "scopeKey");
        for (Map.Entry<JSONDataKey, String> entry : fields.entrySet()) {
            deleteJSONDataForKeyInternal(entry.getKey().getKey(), scopeKey);
            insertJSONDataInternal(new JSONDataEntity(entry.getKey().getKey(), entry.getValue(), new Date(), scopeKey));
        }
    }

    public void updateJSONStringForKey(JSONDataKey key, String scopeKey, Function1<? super String, String> updater) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(scopeKey, "scopeKey");
        Intrinsics.checkNotNullParameter(updater, "updater");
        String strLoadJSONStringForKey = loadJSONStringForKey(key, scopeKey);
        deleteJSONDataForKeyInternal(key.getKey(), scopeKey);
        insertJSONDataInternal(new JSONDataEntity(key.getKey(), updater.invoke(strLoadJSONStringForKey), new Date(), scopeKey));
    }

    public void deleteJSONDataForKeysForAllScopeKeys(List<? extends JSONDataKey> keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        List<? extends JSONDataKey> list = keys;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((JSONDataKey) it.next()).getKey());
        }
        deleteJSONDataForKeysForAllScopeKeysInternal(arrayList);
    }
}

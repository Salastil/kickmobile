package expo.modules.updates.db;

import expo.modules.manifests.core.JSONObjectExtensionKt;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.db.dao.JSONDataDao;
import expo.modules.updates.manifest.ManifestMetadata;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: BuildData.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\r0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lexpo/modules/updates/db/BuildData;", "", "<init>", "()V", "ensureBuildDataIsConsistent", "", "updatesConfiguration", "Lexpo/modules/updates/UpdatesConfiguration;", "database", "Lexpo/modules/updates/db/UpdatesDatabase;", "clearAllUpdatesFromDatabase", "clearManifestMetadataFromDatabase", "isBuildDataConsistent", "", "databaseBuildData", "Lorg/json/JSONObject;", "setBuildDataInDatabase", "getBuildDataFromDatabase", UpdatesConfiguration.UPDATES_CONFIGURATION_SCOPE_KEY_KEY, "", "getBuildDataFromConfig", "defaultBuildData", "", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class BuildData {
    public static final BuildData INSTANCE = new BuildData();
    private static final Map<String, Boolean> defaultBuildData = MapsKt.mapOf(TuplesKt.to(UpdatesConfiguration.UPDATES_CONFIGURATION_HAS_EMBEDDED_UPDATE_KEY, true));

    private BuildData() {
    }

    public final void ensureBuildDataIsConsistent(UpdatesConfiguration updatesConfiguration, UpdatesDatabase database) throws JSONException {
        Intrinsics.checkNotNullParameter(updatesConfiguration, "updatesConfiguration");
        Intrinsics.checkNotNullParameter(database, "database");
        JSONObject buildDataFromDatabase = getBuildDataFromDatabase(database, updatesConfiguration.getScopeKey());
        if (buildDataFromDatabase == null) {
            setBuildDataInDatabase(database, updatesConfiguration);
        } else {
            if (isBuildDataConsistent(updatesConfiguration, buildDataFromDatabase)) {
                return;
            }
            clearAllUpdatesFromDatabase(database);
            clearManifestMetadataFromDatabase(database);
            setBuildDataInDatabase(database, updatesConfiguration);
        }
    }

    public final void clearAllUpdatesFromDatabase(UpdatesDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        database.updateDao().deleteUpdates(database.updateDao().loadAllUpdates());
    }

    public final void clearManifestMetadataFromDatabase(UpdatesDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        ManifestMetadata.INSTANCE.clearMetadataForBuildDataClearOperation(database);
    }

    public final boolean isBuildDataConsistent(UpdatesConfiguration updatesConfiguration, JSONObject databaseBuildData) {
        Intrinsics.checkNotNullParameter(updatesConfiguration, "updatesConfiguration");
        Intrinsics.checkNotNullParameter(databaseBuildData, "databaseBuildData");
        Map<String, Boolean> map = defaultBuildData;
        return Intrinsics.areEqual(MapsKt.plus(map, JSONObjectExtensionKt.toMap(getBuildDataFromConfig(updatesConfiguration))), MapsKt.plus(map, JSONObjectExtensionKt.toMap(databaseBuildData)));
    }

    public final void setBuildDataInDatabase(UpdatesDatabase database, UpdatesConfiguration updatesConfiguration) throws JSONException {
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(updatesConfiguration, "updatesConfiguration");
        JSONObject buildDataFromConfig = getBuildDataFromConfig(updatesConfiguration);
        JSONDataDao jsonDataDao = database.jsonDataDao();
        if (jsonDataDao != null) {
            JSONDataDao.JSONDataKey jSONDataKey = JSONDataDao.JSONDataKey.STATIC_BUILD_DATA;
            String string = buildDataFromConfig.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            jsonDataDao.setJSONStringForKey(jSONDataKey, string, updatesConfiguration.getScopeKey());
        }
    }

    public final JSONObject getBuildDataFromDatabase(UpdatesDatabase database, String scopeKey) {
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(scopeKey, "scopeKey");
        JSONDataDao jsonDataDao = database.jsonDataDao();
        String strLoadJSONStringForKey = jsonDataDao != null ? jsonDataDao.loadJSONStringForKey(JSONDataDao.JSONDataKey.STATIC_BUILD_DATA, scopeKey) : null;
        if (strLoadJSONStringForKey == null) {
            return null;
        }
        return new JSONObject(strLoadJSONStringForKey);
    }

    private final JSONObject getBuildDataFromConfig(UpdatesConfiguration updatesConfiguration) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : updatesConfiguration.getRequestHeaders().entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(UpdatesConfiguration.UPDATES_CONFIGURATION_UPDATE_URL_KEY, updatesConfiguration.getUpdateUrl().toString());
        jSONObject2.put(UpdatesConfiguration.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY, jSONObject);
        jSONObject2.put(UpdatesConfiguration.UPDATES_CONFIGURATION_HAS_EMBEDDED_UPDATE_KEY, updatesConfiguration.getHasEmbeddedUpdate());
        return jSONObject2;
    }
}

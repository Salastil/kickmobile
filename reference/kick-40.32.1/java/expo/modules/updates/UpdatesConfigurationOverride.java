package expo.modules.updates;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.manifests.core.JSONObjectExtensionKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: UpdatesConfigurationOverride.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u000fJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0006HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lexpo/modules/updates/UpdatesConfigurationOverride;", "", UpdatesConfiguration.UPDATES_CONFIGURATION_UPDATE_URL_KEY, "Landroid/net/Uri;", UpdatesConfiguration.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY, "", "", "<init>", "(Landroid/net/Uri;Ljava/util/Map;)V", "getUpdateUrl", "()Landroid/net/Uri;", "getRequestHeaders", "()Ljava/util/Map;", "toJSONObject", "Lorg/json/JSONObject;", "toJSONObject$expo_updates_release", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class UpdatesConfigurationOverride {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String UPDATES_PREFS_FILE = "dev.expo.updates.prefs";
    private static final String UPDATES_PREFS_KEY_UPDATES_CONFIGURATION_OVERRIDE = "updatesConfigOverride";
    private final Map<String, String> requestHeaders;
    private final Uri updateUrl;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UpdatesConfigurationOverride copy$default(UpdatesConfigurationOverride updatesConfigurationOverride, Uri uri, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = updatesConfigurationOverride.updateUrl;
        }
        if ((i & 2) != 0) {
            map = updatesConfigurationOverride.requestHeaders;
        }
        return updatesConfigurationOverride.copy(uri, map);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Uri getUpdateUrl() {
        return this.updateUrl;
    }

    public final Map<String, String> component2() {
        return this.requestHeaders;
    }

    public final UpdatesConfigurationOverride copy(Uri updateUrl, Map<String, String> requestHeaders) {
        return new UpdatesConfigurationOverride(updateUrl, requestHeaders);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UpdatesConfigurationOverride)) {
            return false;
        }
        UpdatesConfigurationOverride updatesConfigurationOverride = (UpdatesConfigurationOverride) other;
        return Intrinsics.areEqual(this.updateUrl, updatesConfigurationOverride.updateUrl) && Intrinsics.areEqual(this.requestHeaders, updatesConfigurationOverride.requestHeaders);
    }

    public int hashCode() {
        Uri uri = this.updateUrl;
        int iHashCode = (uri == null ? 0 : uri.hashCode()) * 31;
        Map<String, String> map = this.requestHeaders;
        return iHashCode + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "UpdatesConfigurationOverride(updateUrl=" + this.updateUrl + ", requestHeaders=" + this.requestHeaders + ")";
    }

    public UpdatesConfigurationOverride(Uri uri, Map<String, String> map) {
        this.updateUrl = uri;
        this.requestHeaders = map;
    }

    public final Uri getUpdateUrl() {
        return this.updateUrl;
    }

    public final Map<String, String> getRequestHeaders() {
        return this.requestHeaders;
    }

    public final JSONObject toJSONObject$expo_updates_release() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Uri uri = this.updateUrl;
        if (uri != null) {
            jSONObject.put(UpdatesConfiguration.UPDATES_CONFIGURATION_UPDATE_URL_KEY, uri.toString());
        }
        Map<String, String> map = this.requestHeaders;
        if (map != null) {
            jSONObject.put(UpdatesConfiguration.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY, new JSONObject(map));
        }
        return jSONObject;
    }

    /* JADX INFO: compiled from: UpdatesConfigurationOverride.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000bJ\u001f\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0002\b\u000fJ-\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0012H\u0000¢\u0006\u0002\b\u0013J\u0015\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0000¢\u0006\u0002\b\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lexpo/modules/updates/UpdatesConfigurationOverride$Companion;", "", "<init>", "()V", "UPDATES_PREFS_FILE", "", "UPDATES_PREFS_KEY_UPDATES_CONFIGURATION_OVERRIDE", "load", "Lexpo/modules/updates/UpdatesConfigurationOverride;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "load$expo_updates_release", "save", "", "configOverride", "save$expo_updates_release", "saveRequestHeaders", UpdatesConfiguration.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY, "", "saveRequestHeaders$expo_updates_release", "fromJSONObject", "json", "Lorg/json/JSONObject;", "fromJSONObject$expo_updates_release", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UpdatesConfigurationOverride load$expo_updates_release(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences(UpdatesConfigurationOverride.UPDATES_PREFS_FILE, 0);
            String string = sharedPreferences != null ? sharedPreferences.getString(UpdatesConfigurationOverride.UPDATES_PREFS_KEY_UPDATES_CONFIGURATION_OVERRIDE, null) : null;
            if (string != null) {
                return UpdatesConfigurationOverride.INSTANCE.fromJSONObject$expo_updates_release(new JSONObject(string));
            }
            return null;
        }

        public final void save$expo_updates_release(Context context, UpdatesConfigurationOverride configOverride) {
            Intrinsics.checkNotNullParameter(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences(UpdatesConfigurationOverride.UPDATES_PREFS_FILE, 0);
            Intrinsics.checkNotNull(sharedPreferences);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (configOverride != null) {
                editorEdit.putString(UpdatesConfigurationOverride.UPDATES_PREFS_KEY_UPDATES_CONFIGURATION_OVERRIDE, configOverride.toJSONObject$expo_updates_release().toString());
            } else {
                editorEdit.remove(UpdatesConfigurationOverride.UPDATES_PREFS_KEY_UPDATES_CONFIGURATION_OVERRIDE);
            }
            editorEdit.apply();
        }

        public final UpdatesConfigurationOverride saveRequestHeaders$expo_updates_release(Context context, Map<String, String> requestHeaders) {
            Intrinsics.checkNotNullParameter(context, "context");
            UpdatesConfigurationOverride updatesConfigurationOverrideLoad$expo_updates_release = load$expo_updates_release(context);
            if (updatesConfigurationOverrideLoad$expo_updates_release == null) {
                updatesConfigurationOverrideLoad$expo_updates_release = new UpdatesConfigurationOverride(null, null);
            }
            UpdatesConfigurationOverride updatesConfigurationOverrideCopy$default = UpdatesConfigurationOverride.copy$default(updatesConfigurationOverrideLoad$expo_updates_release, null, requestHeaders, 1, null);
            UpdatesConfigurationOverride updatesConfigurationOverride = (updatesConfigurationOverrideCopy$default.getUpdateUrl() == null && updatesConfigurationOverrideCopy$default.getRequestHeaders() == null) ? null : updatesConfigurationOverrideCopy$default;
            save$expo_updates_release(context, updatesConfigurationOverride);
            return updatesConfigurationOverride;
        }

        public final UpdatesConfigurationOverride fromJSONObject$expo_updates_release(JSONObject json) throws JSONException {
            String string;
            JSONObject jSONObject;
            Map<String, Object> map;
            Intrinsics.checkNotNullParameter(json, "json");
            LinkedHashMap linkedHashMap = null;
            if (!json.has(UpdatesConfiguration.UPDATES_CONFIGURATION_UPDATE_URL_KEY)) {
                string = null;
            } else if (Intrinsics.areEqual(String.class, String.class)) {
                string = json.getString(UpdatesConfiguration.UPDATES_CONFIGURATION_UPDATE_URL_KEY);
                if (string == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(String.class, Double.class)) {
                string = (String) Double.valueOf(json.getDouble(UpdatesConfiguration.UPDATES_CONFIGURATION_UPDATE_URL_KEY));
            } else if (Intrinsics.areEqual(String.class, Integer.class)) {
                string = (String) Integer.valueOf(json.getInt(UpdatesConfiguration.UPDATES_CONFIGURATION_UPDATE_URL_KEY));
            } else if (Intrinsics.areEqual(String.class, Long.class)) {
                string = (String) Long.valueOf(json.getLong(UpdatesConfiguration.UPDATES_CONFIGURATION_UPDATE_URL_KEY));
            } else if (Intrinsics.areEqual(String.class, Boolean.class)) {
                string = (String) Boolean.valueOf(json.getBoolean(UpdatesConfiguration.UPDATES_CONFIGURATION_UPDATE_URL_KEY));
            } else if (Intrinsics.areEqual(String.class, JSONArray.class)) {
                Object jSONArray = json.getJSONArray(UpdatesConfiguration.UPDATES_CONFIGURATION_UPDATE_URL_KEY);
                if (jSONArray == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                string = (String) jSONArray;
            } else if (Intrinsics.areEqual(String.class, JSONObject.class)) {
                Object jSONObject2 = json.getJSONObject(UpdatesConfiguration.UPDATES_CONFIGURATION_UPDATE_URL_KEY);
                if (jSONObject2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                string = (String) jSONObject2;
            } else {
                Object obj = json.get(UpdatesConfiguration.UPDATES_CONFIGURATION_UPDATE_URL_KEY);
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                string = (String) obj;
            }
            Uri uri = string != null ? Uri.parse(string) : null;
            if (!json.has(UpdatesConfiguration.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY)) {
                jSONObject = null;
            } else if (Intrinsics.areEqual(JSONObject.class, String.class)) {
                Object string2 = json.getString(UpdatesConfiguration.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY);
                if (string2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
                jSONObject = (JSONObject) string2;
            } else if (Intrinsics.areEqual(JSONObject.class, Double.class)) {
                jSONObject = (JSONObject) Double.valueOf(json.getDouble(UpdatesConfiguration.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY));
            } else if (Intrinsics.areEqual(JSONObject.class, Integer.class)) {
                jSONObject = (JSONObject) Integer.valueOf(json.getInt(UpdatesConfiguration.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY));
            } else if (Intrinsics.areEqual(JSONObject.class, Long.class)) {
                jSONObject = (JSONObject) Long.valueOf(json.getLong(UpdatesConfiguration.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY));
            } else if (Intrinsics.areEqual(JSONObject.class, Boolean.class)) {
                jSONObject = (JSONObject) Boolean.valueOf(json.getBoolean(UpdatesConfiguration.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY));
            } else if (Intrinsics.areEqual(JSONObject.class, JSONArray.class)) {
                Object jSONArray2 = json.getJSONArray(UpdatesConfiguration.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY);
                if (jSONArray2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
                jSONObject = (JSONObject) jSONArray2;
            } else if (Intrinsics.areEqual(JSONObject.class, JSONObject.class)) {
                jSONObject = json.getJSONObject(UpdatesConfiguration.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY);
                if (jSONObject == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
            } else {
                Object obj2 = json.get(UpdatesConfiguration.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY);
                if (obj2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
                jSONObject = (JSONObject) obj2;
            }
            if (jSONObject != null && (map = JSONObjectExtensionKt.toMap(jSONObject)) != null) {
                linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
                Iterator<T> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    linkedHashMap.put(entry.getKey(), entry.getValue().toString());
                }
            }
            return new UpdatesConfigurationOverride(uri, linkedHashMap);
        }
    }
}

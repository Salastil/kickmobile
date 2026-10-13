package expo.modules.manifests.core;

import com.google.android.gms.common.internal.ImagesContract;
import expo.modules.updates.UpdatesConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ExpoUpdatesManifest.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016J\u0006\u0010\u000b\u001a\u00020\u0007J\b\u0010\f\u001a\u00020\u0007H\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0016J\u0006\u0010\u000e\u001a\u00020\u0003J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0006\u0010\u0011\u001a\u00020\u0007J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u0002¨\u0006\u0017"}, d2 = {"Lexpo/modules/manifests/core/ExpoUpdatesManifest;", "Lexpo/modules/manifests/core/Manifest;", "json", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "getID", "", "getStableLegacyID", "getScopeKey", "getEASProjectID", "getRuntimeVersion", "getBundleURL", "getExpoGoSDKVersion", "getLaunchAsset", "getAssets", "Lorg/json/JSONArray;", "getCreatedAt", "getExpoGoConfigRootObject", "getExpoClientConfigRootObject", "getSlug", "getAppKey", "getExtra", "expo-manifests_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ExpoUpdatesManifest extends Manifest {
    @Override // expo.modules.manifests.core.Manifest
    public String getAppKey() {
        return null;
    }

    @Override // expo.modules.manifests.core.Manifest
    public String getSlug() {
        return null;
    }

    @Override // expo.modules.manifests.core.Manifest
    public String getStableLegacyID() {
        return null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpoUpdatesManifest(JSONObject json) {
        super(json);
        Intrinsics.checkNotNullParameter(json, "json");
    }

    public final String getID() throws JSONException {
        JSONObject json = getJson();
        if (Intrinsics.areEqual(String.class, String.class)) {
            String string = json.getString("id");
            if (string != null) {
                return string;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, Double.class)) {
            return (String) Double.valueOf(json.getDouble("id"));
        }
        if (Intrinsics.areEqual(String.class, Integer.class)) {
            return (String) Integer.valueOf(json.getInt("id"));
        }
        if (Intrinsics.areEqual(String.class, Long.class)) {
            return (String) Long.valueOf(json.getLong("id"));
        }
        if (Intrinsics.areEqual(String.class, Boolean.class)) {
            return (String) Boolean.valueOf(json.getBoolean("id"));
        }
        if (Intrinsics.areEqual(String.class, JSONArray.class)) {
            Object jSONArray = json.getJSONArray("id");
            if (jSONArray != null) {
                return (String) jSONArray;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, JSONObject.class)) {
            Object jSONObject = json.getJSONObject("id");
            if (jSONObject != null) {
                return (String) jSONObject;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        Object obj = json.get("id");
        if (obj != null) {
            return (String) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    @Override // expo.modules.manifests.core.Manifest
    public String getScopeKey() throws JSONException {
        JSONObject jSONObject;
        JSONObject json = getJson();
        if (Intrinsics.areEqual(JSONObject.class, String.class)) {
            Object string = json.getString("extra");
            if (string == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
            jSONObject = (JSONObject) string;
        } else if (Intrinsics.areEqual(JSONObject.class, Double.class)) {
            jSONObject = (JSONObject) Double.valueOf(json.getDouble("extra"));
        } else if (Intrinsics.areEqual(JSONObject.class, Integer.class)) {
            jSONObject = (JSONObject) Integer.valueOf(json.getInt("extra"));
        } else if (Intrinsics.areEqual(JSONObject.class, Long.class)) {
            jSONObject = (JSONObject) Long.valueOf(json.getLong("extra"));
        } else if (Intrinsics.areEqual(JSONObject.class, Boolean.class)) {
            jSONObject = (JSONObject) Boolean.valueOf(json.getBoolean("extra"));
        } else if (Intrinsics.areEqual(JSONObject.class, JSONArray.class)) {
            Object jSONArray = json.getJSONArray("extra");
            if (jSONArray == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
            jSONObject = (JSONObject) jSONArray;
        } else if (Intrinsics.areEqual(JSONObject.class, JSONObject.class)) {
            jSONObject = json.getJSONObject("extra");
            if (jSONObject == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
        } else {
            Object obj = json.get("extra");
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
            jSONObject = (JSONObject) obj;
        }
        if (Intrinsics.areEqual(String.class, String.class)) {
            String string2 = jSONObject.getString(UpdatesConfiguration.UPDATES_CONFIGURATION_SCOPE_KEY_KEY);
            if (string2 != null) {
                return string2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, Double.class)) {
            return (String) Double.valueOf(jSONObject.getDouble(UpdatesConfiguration.UPDATES_CONFIGURATION_SCOPE_KEY_KEY));
        }
        if (Intrinsics.areEqual(String.class, Integer.class)) {
            return (String) Integer.valueOf(jSONObject.getInt(UpdatesConfiguration.UPDATES_CONFIGURATION_SCOPE_KEY_KEY));
        }
        if (Intrinsics.areEqual(String.class, Long.class)) {
            return (String) Long.valueOf(jSONObject.getLong(UpdatesConfiguration.UPDATES_CONFIGURATION_SCOPE_KEY_KEY));
        }
        if (Intrinsics.areEqual(String.class, Boolean.class)) {
            return (String) Boolean.valueOf(jSONObject.getBoolean(UpdatesConfiguration.UPDATES_CONFIGURATION_SCOPE_KEY_KEY));
        }
        if (Intrinsics.areEqual(String.class, JSONArray.class)) {
            Object jSONArray2 = jSONObject.getJSONArray(UpdatesConfiguration.UPDATES_CONFIGURATION_SCOPE_KEY_KEY);
            if (jSONArray2 != null) {
                return (String) jSONArray2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, JSONObject.class)) {
            Object jSONObject2 = jSONObject.getJSONObject(UpdatesConfiguration.UPDATES_CONFIGURATION_SCOPE_KEY_KEY);
            if (jSONObject2 != null) {
                return (String) jSONObject2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        Object obj2 = jSONObject.get(UpdatesConfiguration.UPDATES_CONFIGURATION_SCOPE_KEY_KEY);
        if (obj2 != null) {
            return (String) obj2;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    @Override // expo.modules.manifests.core.Manifest
    public String getEASProjectID() throws JSONException {
        JSONObject jSONObject;
        JSONObject extra = getExtra();
        if (extra != null) {
            if (!extra.has("eas")) {
                jSONObject = null;
            } else if (Intrinsics.areEqual(JSONObject.class, String.class)) {
                Object string = extra.getString("eas");
                if (string == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
                jSONObject = (JSONObject) string;
            } else if (Intrinsics.areEqual(JSONObject.class, Double.class)) {
                jSONObject = (JSONObject) Double.valueOf(extra.getDouble("eas"));
            } else if (Intrinsics.areEqual(JSONObject.class, Integer.class)) {
                jSONObject = (JSONObject) Integer.valueOf(extra.getInt("eas"));
            } else if (Intrinsics.areEqual(JSONObject.class, Long.class)) {
                jSONObject = (JSONObject) Long.valueOf(extra.getLong("eas"));
            } else if (Intrinsics.areEqual(JSONObject.class, Boolean.class)) {
                jSONObject = (JSONObject) Boolean.valueOf(extra.getBoolean("eas"));
            } else if (Intrinsics.areEqual(JSONObject.class, JSONArray.class)) {
                Object jSONArray = extra.getJSONArray("eas");
                if (jSONArray == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
                jSONObject = (JSONObject) jSONArray;
            } else if (Intrinsics.areEqual(JSONObject.class, JSONObject.class)) {
                jSONObject = extra.getJSONObject("eas");
                if (jSONObject == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
            } else {
                Object obj = extra.get("eas");
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
                jSONObject = (JSONObject) obj;
            }
            if (jSONObject == null || !jSONObject.has("projectId")) {
                return null;
            }
            if (Intrinsics.areEqual(String.class, String.class)) {
                String string2 = jSONObject.getString("projectId");
                if (string2 != null) {
                    return string2;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            if (Intrinsics.areEqual(String.class, Double.class)) {
                return (String) Double.valueOf(jSONObject.getDouble("projectId"));
            }
            if (Intrinsics.areEqual(String.class, Integer.class)) {
                return (String) Integer.valueOf(jSONObject.getInt("projectId"));
            }
            if (Intrinsics.areEqual(String.class, Long.class)) {
                return (String) Long.valueOf(jSONObject.getLong("projectId"));
            }
            if (Intrinsics.areEqual(String.class, Boolean.class)) {
                return (String) Boolean.valueOf(jSONObject.getBoolean("projectId"));
            }
            if (Intrinsics.areEqual(String.class, JSONArray.class)) {
                Object jSONArray2 = jSONObject.getJSONArray("projectId");
                if (jSONArray2 != null) {
                    return (String) jSONArray2;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            if (Intrinsics.areEqual(String.class, JSONObject.class)) {
                Object jSONObject2 = jSONObject.getJSONObject("projectId");
                if (jSONObject2 != null) {
                    return (String) jSONObject2;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            Object obj2 = jSONObject.get("projectId");
            if (obj2 != null) {
                return (String) obj2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        return null;
    }

    public final String getRuntimeVersion() throws JSONException {
        JSONObject json = getJson();
        if (Intrinsics.areEqual(String.class, String.class)) {
            String string = json.getString(UpdatesConfiguration.UPDATES_CONFIGURATION_RUNTIME_VERSION_KEY);
            if (string != null) {
                return string;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, Double.class)) {
            return (String) Double.valueOf(json.getDouble(UpdatesConfiguration.UPDATES_CONFIGURATION_RUNTIME_VERSION_KEY));
        }
        if (Intrinsics.areEqual(String.class, Integer.class)) {
            return (String) Integer.valueOf(json.getInt(UpdatesConfiguration.UPDATES_CONFIGURATION_RUNTIME_VERSION_KEY));
        }
        if (Intrinsics.areEqual(String.class, Long.class)) {
            return (String) Long.valueOf(json.getLong(UpdatesConfiguration.UPDATES_CONFIGURATION_RUNTIME_VERSION_KEY));
        }
        if (Intrinsics.areEqual(String.class, Boolean.class)) {
            return (String) Boolean.valueOf(json.getBoolean(UpdatesConfiguration.UPDATES_CONFIGURATION_RUNTIME_VERSION_KEY));
        }
        if (Intrinsics.areEqual(String.class, JSONArray.class)) {
            Object jSONArray = json.getJSONArray(UpdatesConfiguration.UPDATES_CONFIGURATION_RUNTIME_VERSION_KEY);
            if (jSONArray != null) {
                return (String) jSONArray;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, JSONObject.class)) {
            Object jSONObject = json.getJSONObject(UpdatesConfiguration.UPDATES_CONFIGURATION_RUNTIME_VERSION_KEY);
            if (jSONObject != null) {
                return (String) jSONObject;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        Object obj = json.get(UpdatesConfiguration.UPDATES_CONFIGURATION_RUNTIME_VERSION_KEY);
        if (obj != null) {
            return (String) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    @Override // expo.modules.manifests.core.Manifest
    public String getBundleURL() throws JSONException {
        JSONObject launchAsset = getLaunchAsset();
        if (Intrinsics.areEqual(String.class, String.class)) {
            String string = launchAsset.getString(ImagesContract.URL);
            if (string != null) {
                return string;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, Double.class)) {
            return (String) Double.valueOf(launchAsset.getDouble(ImagesContract.URL));
        }
        if (Intrinsics.areEqual(String.class, Integer.class)) {
            return (String) Integer.valueOf(launchAsset.getInt(ImagesContract.URL));
        }
        if (Intrinsics.areEqual(String.class, Long.class)) {
            return (String) Long.valueOf(launchAsset.getLong(ImagesContract.URL));
        }
        if (Intrinsics.areEqual(String.class, Boolean.class)) {
            return (String) Boolean.valueOf(launchAsset.getBoolean(ImagesContract.URL));
        }
        if (Intrinsics.areEqual(String.class, JSONArray.class)) {
            Object jSONArray = launchAsset.getJSONArray(ImagesContract.URL);
            if (jSONArray != null) {
                return (String) jSONArray;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, JSONObject.class)) {
            Object jSONObject = launchAsset.getJSONObject(ImagesContract.URL);
            if (jSONObject != null) {
                return (String) jSONObject;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        Object obj = launchAsset.get(ImagesContract.URL);
        if (obj != null) {
            return (String) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    @Override // expo.modules.manifests.core.Manifest
    public String getExpoGoSDKVersion() throws JSONException {
        JSONObject expoClientConfigRootObject = getExpoClientConfigRootObject();
        if (expoClientConfigRootObject != null) {
            return expoClientConfigRootObject.getString("sdkVersion");
        }
        return null;
    }

    public final JSONObject getLaunchAsset() throws JSONException {
        JSONObject json = getJson();
        if (Intrinsics.areEqual(JSONObject.class, String.class)) {
            Object string = json.getString("launchAsset");
            if (string != null) {
                return (JSONObject) string;
            }
            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
        }
        if (Intrinsics.areEqual(JSONObject.class, Double.class)) {
            return (JSONObject) Double.valueOf(json.getDouble("launchAsset"));
        }
        if (Intrinsics.areEqual(JSONObject.class, Integer.class)) {
            return (JSONObject) Integer.valueOf(json.getInt("launchAsset"));
        }
        if (Intrinsics.areEqual(JSONObject.class, Long.class)) {
            return (JSONObject) Long.valueOf(json.getLong("launchAsset"));
        }
        if (Intrinsics.areEqual(JSONObject.class, Boolean.class)) {
            return (JSONObject) Boolean.valueOf(json.getBoolean("launchAsset"));
        }
        if (Intrinsics.areEqual(JSONObject.class, JSONArray.class)) {
            Object jSONArray = json.getJSONArray("launchAsset");
            if (jSONArray != null) {
                return (JSONObject) jSONArray;
            }
            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
        }
        if (Intrinsics.areEqual(JSONObject.class, JSONObject.class)) {
            JSONObject jSONObject = json.getJSONObject("launchAsset");
            if (jSONObject != null) {
                return jSONObject;
            }
            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
        }
        Object obj = json.get("launchAsset");
        if (obj != null) {
            return (JSONObject) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
    }

    @Override // expo.modules.manifests.core.Manifest
    public JSONArray getAssets() throws JSONException {
        JSONObject json = getJson();
        if (!json.has("assets")) {
            return null;
        }
        if (Intrinsics.areEqual(JSONArray.class, String.class)) {
            Object string = json.getString("assets");
            if (string != null) {
                return (JSONArray) string;
            }
            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
        }
        if (Intrinsics.areEqual(JSONArray.class, Double.class)) {
            return (JSONArray) Double.valueOf(json.getDouble("assets"));
        }
        if (Intrinsics.areEqual(JSONArray.class, Integer.class)) {
            return (JSONArray) Integer.valueOf(json.getInt("assets"));
        }
        if (Intrinsics.areEqual(JSONArray.class, Long.class)) {
            return (JSONArray) Long.valueOf(json.getLong("assets"));
        }
        if (Intrinsics.areEqual(JSONArray.class, Boolean.class)) {
            return (JSONArray) Boolean.valueOf(json.getBoolean("assets"));
        }
        if (Intrinsics.areEqual(JSONArray.class, JSONArray.class)) {
            JSONArray jSONArray = json.getJSONArray("assets");
            if (jSONArray != null) {
                return jSONArray;
            }
            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
        }
        if (Intrinsics.areEqual(JSONArray.class, JSONObject.class)) {
            Object jSONObject = json.getJSONObject("assets");
            if (jSONObject != null) {
                return (JSONArray) jSONObject;
            }
            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
        }
        Object obj = json.get("assets");
        if (obj != null) {
            return (JSONArray) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
    }

    public final String getCreatedAt() throws JSONException {
        JSONObject json = getJson();
        if (Intrinsics.areEqual(String.class, String.class)) {
            String string = json.getString("createdAt");
            if (string != null) {
                return string;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, Double.class)) {
            return (String) Double.valueOf(json.getDouble("createdAt"));
        }
        if (Intrinsics.areEqual(String.class, Integer.class)) {
            return (String) Integer.valueOf(json.getInt("createdAt"));
        }
        if (Intrinsics.areEqual(String.class, Long.class)) {
            return (String) Long.valueOf(json.getLong("createdAt"));
        }
        if (Intrinsics.areEqual(String.class, Boolean.class)) {
            return (String) Boolean.valueOf(json.getBoolean("createdAt"));
        }
        if (Intrinsics.areEqual(String.class, JSONArray.class)) {
            Object jSONArray = json.getJSONArray("createdAt");
            if (jSONArray != null) {
                return (String) jSONArray;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, JSONObject.class)) {
            Object jSONObject = json.getJSONObject("createdAt");
            if (jSONObject != null) {
                return (String) jSONObject;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        Object obj = json.get("createdAt");
        if (obj != null) {
            return (String) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    @Override // expo.modules.manifests.core.Manifest
    public JSONObject getExpoGoConfigRootObject() throws JSONException {
        JSONObject extra = getExtra();
        if (extra == null || !extra.has("expoGo")) {
            return null;
        }
        if (Intrinsics.areEqual(JSONObject.class, String.class)) {
            Object string = extra.getString("expoGo");
            if (string != null) {
                return (JSONObject) string;
            }
            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
        }
        if (Intrinsics.areEqual(JSONObject.class, Double.class)) {
            return (JSONObject) Double.valueOf(extra.getDouble("expoGo"));
        }
        if (Intrinsics.areEqual(JSONObject.class, Integer.class)) {
            return (JSONObject) Integer.valueOf(extra.getInt("expoGo"));
        }
        if (Intrinsics.areEqual(JSONObject.class, Long.class)) {
            return (JSONObject) Long.valueOf(extra.getLong("expoGo"));
        }
        if (Intrinsics.areEqual(JSONObject.class, Boolean.class)) {
            return (JSONObject) Boolean.valueOf(extra.getBoolean("expoGo"));
        }
        if (Intrinsics.areEqual(JSONObject.class, JSONArray.class)) {
            Object jSONArray = extra.getJSONArray("expoGo");
            if (jSONArray != null) {
                return (JSONObject) jSONArray;
            }
            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
        }
        if (Intrinsics.areEqual(JSONObject.class, JSONObject.class)) {
            JSONObject jSONObject = extra.getJSONObject("expoGo");
            if (jSONObject != null) {
                return jSONObject;
            }
            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
        }
        Object obj = extra.get("expoGo");
        if (obj != null) {
            return (JSONObject) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
    }

    @Override // expo.modules.manifests.core.Manifest
    public JSONObject getExpoClientConfigRootObject() throws JSONException {
        JSONObject extra = getExtra();
        if (extra == null || !extra.has("expoClient")) {
            return null;
        }
        if (Intrinsics.areEqual(JSONObject.class, String.class)) {
            Object string = extra.getString("expoClient");
            if (string != null) {
                return (JSONObject) string;
            }
            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
        }
        if (Intrinsics.areEqual(JSONObject.class, Double.class)) {
            return (JSONObject) Double.valueOf(extra.getDouble("expoClient"));
        }
        if (Intrinsics.areEqual(JSONObject.class, Integer.class)) {
            return (JSONObject) Integer.valueOf(extra.getInt("expoClient"));
        }
        if (Intrinsics.areEqual(JSONObject.class, Long.class)) {
            return (JSONObject) Long.valueOf(extra.getLong("expoClient"));
        }
        if (Intrinsics.areEqual(JSONObject.class, Boolean.class)) {
            return (JSONObject) Boolean.valueOf(extra.getBoolean("expoClient"));
        }
        if (Intrinsics.areEqual(JSONObject.class, JSONArray.class)) {
            Object jSONArray = extra.getJSONArray("expoClient");
            if (jSONArray != null) {
                return (JSONObject) jSONArray;
            }
            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
        }
        if (Intrinsics.areEqual(JSONObject.class, JSONObject.class)) {
            JSONObject jSONObject = extra.getJSONObject("expoClient");
            if (jSONObject != null) {
                return jSONObject;
            }
            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
        }
        Object obj = extra.get("expoClient");
        if (obj != null) {
            return (JSONObject) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
    }

    private final JSONObject getExtra() throws JSONException {
        JSONObject json = getJson();
        if (!json.has("extra")) {
            return null;
        }
        if (Intrinsics.areEqual(JSONObject.class, String.class)) {
            Object string = json.getString("extra");
            if (string != null) {
                return (JSONObject) string;
            }
            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
        }
        if (Intrinsics.areEqual(JSONObject.class, Double.class)) {
            return (JSONObject) Double.valueOf(json.getDouble("extra"));
        }
        if (Intrinsics.areEqual(JSONObject.class, Integer.class)) {
            return (JSONObject) Integer.valueOf(json.getInt("extra"));
        }
        if (Intrinsics.areEqual(JSONObject.class, Long.class)) {
            return (JSONObject) Long.valueOf(json.getLong("extra"));
        }
        if (Intrinsics.areEqual(JSONObject.class, Boolean.class)) {
            return (JSONObject) Boolean.valueOf(json.getBoolean("extra"));
        }
        if (Intrinsics.areEqual(JSONObject.class, JSONArray.class)) {
            Object jSONArray = json.getJSONArray("extra");
            if (jSONArray != null) {
                return (JSONObject) jSONArray;
            }
            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
        }
        if (Intrinsics.areEqual(JSONObject.class, JSONObject.class)) {
            JSONObject jSONObject = json.getJSONObject("extra");
            if (jSONObject != null) {
                return jSONObject;
            }
            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
        }
        Object obj = json.get("extra");
        if (obj != null) {
            return (JSONObject) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
    }
}

package expo.modules.manifests.core;

import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.cast.MediaTrack;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Manifest.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010$\n\u0002\b\u0003\b&\u0018\u0000 52\u00020\u0001:\u00015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\u0003H\u0007J\n\u0010\t\u001a\u00020\nH\u0097\u0080\u0004J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH'J\b\u0010\f\u001a\u00020\nH&J\n\u0010\r\u001a\u0004\u0018\u00010\nH&J\b\u0010\u000e\u001a\u00020\nH\u0007J\b\u0010\u000f\u001a\u00020\nH&J\u0006\u0010\u0010\u001a\u00020\nJ\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003J\n\u0010\u0012\u001a\u0004\u0018\u00010\nH&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0003H&J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001a\u001a\u00020\u0018J\n\u0010\u001b\u001a\u0004\u0018\u00010\nH&J\u0006\u0010\u001c\u001a\u00020\nJ\u0006\u0010\u001d\u001a\u00020\nJ\b\u0010\u001e\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u001f\u001a\u00020\u0018J\n\u0010 \u001a\u0004\u0018\u00010\nH&J\b\u0010!\u001a\u0004\u0018\u00010\nJ\b\u0010\"\u001a\u0004\u0018\u00010\nJ\b\u0010#\u001a\u0004\u0018\u00010\u0003J\b\u0010$\u001a\u0004\u0018\u00010\nJ\b\u0010%\u001a\u0004\u0018\u00010\nJ\b\u0010&\u001a\u0004\u0018\u00010\nJ\b\u0010'\u001a\u0004\u0018\u00010\nJ\b\u0010(\u001a\u0004\u0018\u00010\u0003J\b\u0010)\u001a\u0004\u0018\u00010\nJ\b\u0010*\u001a\u0004\u0018\u00010\u0003J\b\u0010+\u001a\u0004\u0018\u00010\nJ\b\u0010,\u001a\u0004\u0018\u00010\nJ\b\u0010-\u001a\u0004\u0018\u00010\nJ\u0006\u0010.\u001a\u00020\u0018J\u0006\u0010/\u001a\u00020\nJ\u0006\u00100\u001a\u00020\nJ\u0006\u00101\u001a\u00020\u0018J\u001c\u00102\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001032\u0006\u00104\u001a\u00020\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u00066"}, d2 = {"Lexpo/modules/manifests/core/Manifest;", "", "json", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "getJson", "()Lorg/json/JSONObject;", "getRawJson", "toString", "", "getStableLegacyID", "getScopeKey", "getEASProjectID", "getLegacyID", "getBundleURL", "getRevisionId", "getMetadata", "getExpoGoSDKVersion", "getAssets", "Lorg/json/JSONArray;", "getExpoGoConfigRootObject", "getExpoClientConfigRootObject", "isDevelopmentMode", "", "isDevelopmentSilentLaunch", "isUsingDeveloperTool", "getSlug", "getDebuggerHost", "getMainModuleName", "getHostUri", "isVerified", "getAppKey", "getName", "getVersion", "getUpdatesInfo", "getPrimaryColor", "getOrientation", "getAndroidKeyboardLayoutMode", "getAndroidUserInterfaceStyle", "getAndroidStatusBarOptions", "getAndroidBackgroundColor", "getAndroidNavigationBarOptions", "getIconUrl", "getAndroidGoogleServicesFile", "getAndroidPackageName", "shouldUseNextNotificationsApi", "getFacebookAppId", "getFacebookApplicationName", "getFacebookAutoInitEnabled", "getPluginProperties", "", "packageName", "Companion", "expo-manifests_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class Manifest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final JSONObject json;

    @JvmStatic
    public static final Manifest fromManifestJson(JSONObject jSONObject) {
        return INSTANCE.fromManifestJson(jSONObject);
    }

    public abstract String getAppKey();

    public abstract JSONArray getAssets();

    public abstract String getBundleURL() throws JSONException;

    public abstract String getEASProjectID();

    public abstract JSONObject getExpoClientConfigRootObject();

    public abstract JSONObject getExpoGoConfigRootObject();

    public abstract String getExpoGoSDKVersion();

    public abstract String getScopeKey() throws JSONException;

    public abstract String getSlug();

    @Deprecated(message = "Prefer scopeKey or projectId depending on use case")
    public abstract String getStableLegacyID();

    public Manifest(JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        this.json = json;
    }

    protected final JSONObject getJson() {
        return this.json;
    }

    @Deprecated(message = "Prefer to use specific field getters")
    public final JSONObject getRawJson() {
        return this.json;
    }

    @Deprecated(message = "Prefer to use specific field getters")
    public String toString() {
        String string = getRawJson().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @Deprecated(message = "Prefer scopeKey or projectId depending on use case")
    public final String getLegacyID() throws JSONException {
        JSONObject jSONObject = this.json;
        if (Intrinsics.areEqual(String.class, String.class)) {
            String string = jSONObject.getString("id");
            if (string != null) {
                return string;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, Double.class)) {
            return (String) Double.valueOf(jSONObject.getDouble("id"));
        }
        if (Intrinsics.areEqual(String.class, Integer.class)) {
            return (String) Integer.valueOf(jSONObject.getInt("id"));
        }
        if (Intrinsics.areEqual(String.class, Long.class)) {
            return (String) Long.valueOf(jSONObject.getLong("id"));
        }
        if (Intrinsics.areEqual(String.class, Boolean.class)) {
            return (String) Boolean.valueOf(jSONObject.getBoolean("id"));
        }
        if (Intrinsics.areEqual(String.class, JSONArray.class)) {
            Object jSONArray = jSONObject.getJSONArray("id");
            if (jSONArray != null) {
                return (String) jSONArray;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, JSONObject.class)) {
            Object jSONObject2 = jSONObject.getJSONObject("id");
            if (jSONObject2 != null) {
                return (String) jSONObject2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        Object obj = jSONObject.get("id");
        if (obj != null) {
            return (String) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public final String getRevisionId() throws JSONException {
        JSONObject expoClientConfigRootObject = getExpoClientConfigRootObject();
        Intrinsics.checkNotNull(expoClientConfigRootObject);
        if (Intrinsics.areEqual(String.class, String.class)) {
            String string = expoClientConfigRootObject.getString("revisionId");
            if (string != null) {
                return string;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, Double.class)) {
            return (String) Double.valueOf(expoClientConfigRootObject.getDouble("revisionId"));
        }
        if (Intrinsics.areEqual(String.class, Integer.class)) {
            return (String) Integer.valueOf(expoClientConfigRootObject.getInt("revisionId"));
        }
        if (Intrinsics.areEqual(String.class, Long.class)) {
            return (String) Long.valueOf(expoClientConfigRootObject.getLong("revisionId"));
        }
        if (Intrinsics.areEqual(String.class, Boolean.class)) {
            return (String) Boolean.valueOf(expoClientConfigRootObject.getBoolean("revisionId"));
        }
        if (Intrinsics.areEqual(String.class, JSONArray.class)) {
            Object jSONArray = expoClientConfigRootObject.getJSONArray("revisionId");
            if (jSONArray != null) {
                return (String) jSONArray;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, JSONObject.class)) {
            Object jSONObject = expoClientConfigRootObject.getJSONObject("revisionId");
            if (jSONObject != null) {
                return (String) jSONObject;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        Object obj = expoClientConfigRootObject.get("revisionId");
        if (obj != null) {
            return (String) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public final JSONObject getMetadata() throws JSONException {
        JSONObject jSONObject = this.json;
        if (!jSONObject.has("metadata")) {
            return null;
        }
        if (Intrinsics.areEqual(JSONObject.class, String.class)) {
            Object string = jSONObject.getString("metadata");
            if (string != null) {
                return (JSONObject) string;
            }
            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
        }
        if (Intrinsics.areEqual(JSONObject.class, Double.class)) {
            return (JSONObject) Double.valueOf(jSONObject.getDouble("metadata"));
        }
        if (Intrinsics.areEqual(JSONObject.class, Integer.class)) {
            return (JSONObject) Integer.valueOf(jSONObject.getInt("metadata"));
        }
        if (Intrinsics.areEqual(JSONObject.class, Long.class)) {
            return (JSONObject) Long.valueOf(jSONObject.getLong("metadata"));
        }
        if (Intrinsics.areEqual(JSONObject.class, Boolean.class)) {
            return (JSONObject) Boolean.valueOf(jSONObject.getBoolean("metadata"));
        }
        if (Intrinsics.areEqual(JSONObject.class, JSONArray.class)) {
            Object jSONArray = jSONObject.getJSONArray("metadata");
            if (jSONArray != null) {
                return (JSONObject) jSONArray;
            }
            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
        }
        if (Intrinsics.areEqual(JSONObject.class, JSONObject.class)) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("metadata");
            if (jSONObject2 != null) {
                return jSONObject2;
            }
            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
        }
        Object obj = jSONObject.get("metadata");
        if (obj != null) {
            return (JSONObject) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
    }

    /* JADX WARN: Code duplicated, block: B:93:0x0171  */
    public final boolean isDevelopmentMode() {
        JSONObject jSONObject;
        boolean zBooleanValue;
        Boolean boolValueOf;
        JSONObject expoGoConfigRootObject = getExpoGoConfigRootObject();
        if (expoGoConfigRootObject == null) {
            return false;
        }
        try {
            if (expoGoConfigRootObject.has("developer")) {
                Boolean bool = null;
                if (!expoGoConfigRootObject.has("packagerOpts")) {
                    jSONObject = null;
                } else if (Intrinsics.areEqual(JSONObject.class, String.class)) {
                    Object string = expoGoConfigRootObject.getString("packagerOpts");
                    if (string == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                    jSONObject = (JSONObject) string;
                } else if (Intrinsics.areEqual(JSONObject.class, Double.class)) {
                    jSONObject = (JSONObject) Double.valueOf(expoGoConfigRootObject.getDouble("packagerOpts"));
                } else if (Intrinsics.areEqual(JSONObject.class, Integer.class)) {
                    jSONObject = (JSONObject) Integer.valueOf(expoGoConfigRootObject.getInt("packagerOpts"));
                } else if (Intrinsics.areEqual(JSONObject.class, Long.class)) {
                    jSONObject = (JSONObject) Long.valueOf(expoGoConfigRootObject.getLong("packagerOpts"));
                } else if (Intrinsics.areEqual(JSONObject.class, Boolean.class)) {
                    jSONObject = (JSONObject) Boolean.valueOf(expoGoConfigRootObject.getBoolean("packagerOpts"));
                } else if (Intrinsics.areEqual(JSONObject.class, JSONArray.class)) {
                    Object jSONArray = expoGoConfigRootObject.getJSONArray("packagerOpts");
                    if (jSONArray == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                    jSONObject = (JSONObject) jSONArray;
                } else if (Intrinsics.areEqual(JSONObject.class, JSONObject.class)) {
                    jSONObject = expoGoConfigRootObject.getJSONObject("packagerOpts");
                    if (jSONObject == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                } else {
                    Object obj = expoGoConfigRootObject.get("packagerOpts");
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                    jSONObject = (JSONObject) obj;
                }
                if (jSONObject == null) {
                    zBooleanValue = false;
                } else {
                    if (jSONObject.has("dev")) {
                        if (Intrinsics.areEqual(Boolean.class, String.class)) {
                            Object string2 = jSONObject.getString("dev");
                            if (string2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                            }
                            boolValueOf = (Boolean) string2;
                        } else if (Intrinsics.areEqual(Boolean.class, Double.class)) {
                            boolValueOf = (Boolean) Double.valueOf(jSONObject.getDouble("dev"));
                        } else if (Intrinsics.areEqual(Boolean.class, Integer.class)) {
                            boolValueOf = (Boolean) Integer.valueOf(jSONObject.getInt("dev"));
                        } else if (Intrinsics.areEqual(Boolean.class, Long.class)) {
                            boolValueOf = (Boolean) Long.valueOf(jSONObject.getLong("dev"));
                        } else if (Intrinsics.areEqual(Boolean.class, Boolean.class)) {
                            boolValueOf = Boolean.valueOf(jSONObject.getBoolean("dev"));
                        } else if (Intrinsics.areEqual(Boolean.class, JSONArray.class)) {
                            Object jSONArray2 = jSONObject.getJSONArray("dev");
                            if (jSONArray2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                            }
                            boolValueOf = (Boolean) jSONArray2;
                        } else if (Intrinsics.areEqual(Boolean.class, JSONObject.class)) {
                            Object jSONObject2 = jSONObject.getJSONObject("dev");
                            if (jSONObject2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                            }
                            boolValueOf = (Boolean) jSONObject2;
                        } else {
                            Object obj2 = jSONObject.get("dev");
                            if (obj2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                            }
                            boolValueOf = (Boolean) obj2;
                        }
                        bool = boolValueOf;
                    }
                    if (bool != null) {
                        zBooleanValue = bool.booleanValue();
                    } else {
                        zBooleanValue = false;
                    }
                }
                if (zBooleanValue) {
                    return true;
                }
            }
        } catch (JSONException unused) {
        }
        return false;
    }

    public final boolean isDevelopmentSilentLaunch() throws JSONException {
        JSONObject jSONObject;
        Boolean boolValueOf;
        JSONObject expoGoConfigRootObject = getExpoGoConfigRootObject();
        if (expoGoConfigRootObject == null) {
            return false;
        }
        Boolean bool = null;
        if (!expoGoConfigRootObject.has("developmentClient")) {
            jSONObject = null;
        } else if (Intrinsics.areEqual(JSONObject.class, String.class)) {
            Object string = expoGoConfigRootObject.getString("developmentClient");
            if (string == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
            jSONObject = (JSONObject) string;
        } else if (Intrinsics.areEqual(JSONObject.class, Double.class)) {
            jSONObject = (JSONObject) Double.valueOf(expoGoConfigRootObject.getDouble("developmentClient"));
        } else if (Intrinsics.areEqual(JSONObject.class, Integer.class)) {
            jSONObject = (JSONObject) Integer.valueOf(expoGoConfigRootObject.getInt("developmentClient"));
        } else if (Intrinsics.areEqual(JSONObject.class, Long.class)) {
            jSONObject = (JSONObject) Long.valueOf(expoGoConfigRootObject.getLong("developmentClient"));
        } else if (Intrinsics.areEqual(JSONObject.class, Boolean.class)) {
            jSONObject = (JSONObject) Boolean.valueOf(expoGoConfigRootObject.getBoolean("developmentClient"));
        } else if (Intrinsics.areEqual(JSONObject.class, JSONArray.class)) {
            Object jSONArray = expoGoConfigRootObject.getJSONArray("developmentClient");
            if (jSONArray == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
            jSONObject = (JSONObject) jSONArray;
        } else if (Intrinsics.areEqual(JSONObject.class, JSONObject.class)) {
            jSONObject = expoGoConfigRootObject.getJSONObject("developmentClient");
            if (jSONObject == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
        } else {
            Object obj = expoGoConfigRootObject.get("developmentClient");
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
            jSONObject = (JSONObject) obj;
        }
        if (jSONObject != null) {
            if (jSONObject.has("silentLaunch")) {
                if (!Intrinsics.areEqual(Boolean.class, String.class)) {
                    if (!Intrinsics.areEqual(Boolean.class, Double.class)) {
                        if (!Intrinsics.areEqual(Boolean.class, Integer.class)) {
                            if (!Intrinsics.areEqual(Boolean.class, Long.class)) {
                                if (!Intrinsics.areEqual(Boolean.class, Boolean.class)) {
                                    if (!Intrinsics.areEqual(Boolean.class, JSONArray.class)) {
                                        if (!Intrinsics.areEqual(Boolean.class, JSONObject.class)) {
                                            Object obj2 = jSONObject.get("silentLaunch");
                                            if (obj2 == null) {
                                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                            }
                                            boolValueOf = (Boolean) obj2;
                                        } else {
                                            Object jSONObject2 = jSONObject.getJSONObject("silentLaunch");
                                            if (jSONObject2 == null) {
                                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                            }
                                            boolValueOf = (Boolean) jSONObject2;
                                        }
                                    } else {
                                        Object jSONArray2 = jSONObject.getJSONArray("silentLaunch");
                                        if (jSONArray2 == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                        }
                                        boolValueOf = (Boolean) jSONArray2;
                                    }
                                } else {
                                    boolValueOf = Boolean.valueOf(jSONObject.getBoolean("silentLaunch"));
                                }
                            } else {
                                boolValueOf = (Boolean) Long.valueOf(jSONObject.getLong("silentLaunch"));
                            }
                        } else {
                            boolValueOf = (Boolean) Integer.valueOf(jSONObject.getInt("silentLaunch"));
                        }
                    } else {
                        boolValueOf = (Boolean) Double.valueOf(jSONObject.getDouble("silentLaunch"));
                    }
                } else {
                    Object string2 = jSONObject.getString("silentLaunch");
                    if (string2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                    boolValueOf = (Boolean) string2;
                }
                bool = boolValueOf;
            }
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        return false;
    }

    public final boolean isUsingDeveloperTool() throws JSONException {
        JSONObject jSONObject;
        JSONObject expoGoConfigRootObject = getExpoGoConfigRootObject();
        if (expoGoConfigRootObject == null) {
            return false;
        }
        if (!expoGoConfigRootObject.has("developer")) {
            jSONObject = null;
        } else if (Intrinsics.areEqual(JSONObject.class, String.class)) {
            Object string = expoGoConfigRootObject.getString("developer");
            if (string == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
            jSONObject = (JSONObject) string;
        } else if (Intrinsics.areEqual(JSONObject.class, Double.class)) {
            jSONObject = (JSONObject) Double.valueOf(expoGoConfigRootObject.getDouble("developer"));
        } else if (Intrinsics.areEqual(JSONObject.class, Integer.class)) {
            jSONObject = (JSONObject) Integer.valueOf(expoGoConfigRootObject.getInt("developer"));
        } else if (Intrinsics.areEqual(JSONObject.class, Long.class)) {
            jSONObject = (JSONObject) Long.valueOf(expoGoConfigRootObject.getLong("developer"));
        } else if (Intrinsics.areEqual(JSONObject.class, Boolean.class)) {
            jSONObject = (JSONObject) Boolean.valueOf(expoGoConfigRootObject.getBoolean("developer"));
        } else if (Intrinsics.areEqual(JSONObject.class, JSONArray.class)) {
            Object jSONArray = expoGoConfigRootObject.getJSONArray("developer");
            if (jSONArray == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
            jSONObject = (JSONObject) jSONArray;
        } else if (Intrinsics.areEqual(JSONObject.class, JSONObject.class)) {
            jSONObject = expoGoConfigRootObject.getJSONObject("developer");
            if (jSONObject == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
        } else {
            Object obj = expoGoConfigRootObject.get("developer");
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
            jSONObject = (JSONObject) obj;
        }
        if (jSONObject != null) {
            return jSONObject.has("tool");
        }
        return false;
    }

    public final String getDebuggerHost() throws JSONException {
        JSONObject expoGoConfigRootObject = getExpoGoConfigRootObject();
        Intrinsics.checkNotNull(expoGoConfigRootObject);
        if (Intrinsics.areEqual(String.class, String.class)) {
            String string = expoGoConfigRootObject.getString("debuggerHost");
            if (string != null) {
                return string;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, Double.class)) {
            return (String) Double.valueOf(expoGoConfigRootObject.getDouble("debuggerHost"));
        }
        if (Intrinsics.areEqual(String.class, Integer.class)) {
            return (String) Integer.valueOf(expoGoConfigRootObject.getInt("debuggerHost"));
        }
        if (Intrinsics.areEqual(String.class, Long.class)) {
            return (String) Long.valueOf(expoGoConfigRootObject.getLong("debuggerHost"));
        }
        if (Intrinsics.areEqual(String.class, Boolean.class)) {
            return (String) Boolean.valueOf(expoGoConfigRootObject.getBoolean("debuggerHost"));
        }
        if (Intrinsics.areEqual(String.class, JSONArray.class)) {
            Object jSONArray = expoGoConfigRootObject.getJSONArray("debuggerHost");
            if (jSONArray != null) {
                return (String) jSONArray;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, JSONObject.class)) {
            Object jSONObject = expoGoConfigRootObject.getJSONObject("debuggerHost");
            if (jSONObject != null) {
                return (String) jSONObject;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        Object obj = expoGoConfigRootObject.get("debuggerHost");
        if (obj != null) {
            return (String) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public final String getMainModuleName() throws JSONException {
        String string;
        JSONObject expoGoConfigRootObject = getExpoGoConfigRootObject();
        if (expoGoConfigRootObject == null) {
            return MediaTrack.ROLE_MAIN;
        }
        if (Intrinsics.areEqual(String.class, String.class)) {
            string = expoGoConfigRootObject.getString("mainModuleName");
            if (string == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        } else if (Intrinsics.areEqual(String.class, Double.class)) {
            string = (String) Double.valueOf(expoGoConfigRootObject.getDouble("mainModuleName"));
        } else if (Intrinsics.areEqual(String.class, Integer.class)) {
            string = (String) Integer.valueOf(expoGoConfigRootObject.getInt("mainModuleName"));
        } else if (Intrinsics.areEqual(String.class, Long.class)) {
            string = (String) Long.valueOf(expoGoConfigRootObject.getLong("mainModuleName"));
        } else if (Intrinsics.areEqual(String.class, Boolean.class)) {
            string = (String) Boolean.valueOf(expoGoConfigRootObject.getBoolean("mainModuleName"));
        } else if (Intrinsics.areEqual(String.class, JSONArray.class)) {
            Object jSONArray = expoGoConfigRootObject.getJSONArray("mainModuleName");
            if (jSONArray == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            string = (String) jSONArray;
        } else if (Intrinsics.areEqual(String.class, JSONObject.class)) {
            Object jSONObject = expoGoConfigRootObject.getJSONObject("mainModuleName");
            if (jSONObject == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            string = (String) jSONObject;
        } else {
            Object obj = expoGoConfigRootObject.get("mainModuleName");
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            string = (String) obj;
        }
        return string == null ? MediaTrack.ROLE_MAIN : string;
    }

    public final String getHostUri() throws JSONException {
        JSONObject expoClientConfigRootObject = getExpoClientConfigRootObject();
        if (expoClientConfigRootObject == null || !expoClientConfigRootObject.has("hostUri")) {
            return null;
        }
        if (Intrinsics.areEqual(String.class, String.class)) {
            String string = expoClientConfigRootObject.getString("hostUri");
            if (string != null) {
                return string;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, Double.class)) {
            return (String) Double.valueOf(expoClientConfigRootObject.getDouble("hostUri"));
        }
        if (Intrinsics.areEqual(String.class, Integer.class)) {
            return (String) Integer.valueOf(expoClientConfigRootObject.getInt("hostUri"));
        }
        if (Intrinsics.areEqual(String.class, Long.class)) {
            return (String) Long.valueOf(expoClientConfigRootObject.getLong("hostUri"));
        }
        if (Intrinsics.areEqual(String.class, Boolean.class)) {
            return (String) Boolean.valueOf(expoClientConfigRootObject.getBoolean("hostUri"));
        }
        if (Intrinsics.areEqual(String.class, JSONArray.class)) {
            Object jSONArray = expoClientConfigRootObject.getJSONArray("hostUri");
            if (jSONArray != null) {
                return (String) jSONArray;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, JSONObject.class)) {
            Object jSONObject = expoClientConfigRootObject.getJSONObject("hostUri");
            if (jSONObject != null) {
                return (String) jSONObject;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        Object obj = expoClientConfigRootObject.get("hostUri");
        if (obj != null) {
            return (String) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public final boolean isVerified() throws JSONException {
        Boolean boolValueOf;
        JSONObject jSONObject = this.json;
        if (!jSONObject.has("isVerified")) {
            boolValueOf = null;
        } else if (Intrinsics.areEqual(Boolean.class, String.class)) {
            Object string = jSONObject.getString("isVerified");
            if (string == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
            boolValueOf = (Boolean) string;
        } else if (Intrinsics.areEqual(Boolean.class, Double.class)) {
            boolValueOf = (Boolean) Double.valueOf(jSONObject.getDouble("isVerified"));
        } else if (Intrinsics.areEqual(Boolean.class, Integer.class)) {
            boolValueOf = (Boolean) Integer.valueOf(jSONObject.getInt("isVerified"));
        } else if (Intrinsics.areEqual(Boolean.class, Long.class)) {
            boolValueOf = (Boolean) Long.valueOf(jSONObject.getLong("isVerified"));
        } else if (Intrinsics.areEqual(Boolean.class, Boolean.class)) {
            boolValueOf = Boolean.valueOf(jSONObject.getBoolean("isVerified"));
        } else if (Intrinsics.areEqual(Boolean.class, JSONArray.class)) {
            Object jSONArray = jSONObject.getJSONArray("isVerified");
            if (jSONArray == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
            boolValueOf = (Boolean) jSONArray;
        } else if (Intrinsics.areEqual(Boolean.class, JSONObject.class)) {
            Object jSONObject2 = jSONObject.getJSONObject("isVerified");
            if (jSONObject2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
            boolValueOf = (Boolean) jSONObject2;
        } else {
            Object obj = jSONObject.get("isVerified");
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
            boolValueOf = (Boolean) obj;
        }
        if (boolValueOf != null) {
            return boolValueOf.booleanValue();
        }
        return false;
    }

    public final String getName() throws JSONException {
        JSONObject expoClientConfigRootObject = getExpoClientConfigRootObject();
        if (expoClientConfigRootObject == null || !expoClientConfigRootObject.has("name")) {
            return null;
        }
        if (Intrinsics.areEqual(String.class, String.class)) {
            String string = expoClientConfigRootObject.getString("name");
            if (string != null) {
                return string;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, Double.class)) {
            return (String) Double.valueOf(expoClientConfigRootObject.getDouble("name"));
        }
        if (Intrinsics.areEqual(String.class, Integer.class)) {
            return (String) Integer.valueOf(expoClientConfigRootObject.getInt("name"));
        }
        if (Intrinsics.areEqual(String.class, Long.class)) {
            return (String) Long.valueOf(expoClientConfigRootObject.getLong("name"));
        }
        if (Intrinsics.areEqual(String.class, Boolean.class)) {
            return (String) Boolean.valueOf(expoClientConfigRootObject.getBoolean("name"));
        }
        if (Intrinsics.areEqual(String.class, JSONArray.class)) {
            Object jSONArray = expoClientConfigRootObject.getJSONArray("name");
            if (jSONArray != null) {
                return (String) jSONArray;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, JSONObject.class)) {
            Object jSONObject = expoClientConfigRootObject.getJSONObject("name");
            if (jSONObject != null) {
                return (String) jSONObject;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        Object obj = expoClientConfigRootObject.get("name");
        if (obj != null) {
            return (String) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public final String getVersion() throws JSONException {
        JSONObject expoClientConfigRootObject = getExpoClientConfigRootObject();
        if (expoClientConfigRootObject == null || !expoClientConfigRootObject.has("version")) {
            return null;
        }
        if (Intrinsics.areEqual(String.class, String.class)) {
            String string = expoClientConfigRootObject.getString("version");
            if (string != null) {
                return string;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, Double.class)) {
            return (String) Double.valueOf(expoClientConfigRootObject.getDouble("version"));
        }
        if (Intrinsics.areEqual(String.class, Integer.class)) {
            return (String) Integer.valueOf(expoClientConfigRootObject.getInt("version"));
        }
        if (Intrinsics.areEqual(String.class, Long.class)) {
            return (String) Long.valueOf(expoClientConfigRootObject.getLong("version"));
        }
        if (Intrinsics.areEqual(String.class, Boolean.class)) {
            return (String) Boolean.valueOf(expoClientConfigRootObject.getBoolean("version"));
        }
        if (Intrinsics.areEqual(String.class, JSONArray.class)) {
            Object jSONArray = expoClientConfigRootObject.getJSONArray("version");
            if (jSONArray != null) {
                return (String) jSONArray;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, JSONObject.class)) {
            Object jSONObject = expoClientConfigRootObject.getJSONObject("version");
            if (jSONObject != null) {
                return (String) jSONObject;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        Object obj = expoClientConfigRootObject.get("version");
        if (obj != null) {
            return (String) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public final JSONObject getUpdatesInfo() throws JSONException {
        JSONObject expoClientConfigRootObject = getExpoClientConfigRootObject();
        if (expoClientConfigRootObject == null || !expoClientConfigRootObject.has("updates")) {
            return null;
        }
        if (Intrinsics.areEqual(JSONObject.class, String.class)) {
            Object string = expoClientConfigRootObject.getString("updates");
            if (string != null) {
                return (JSONObject) string;
            }
            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
        }
        if (Intrinsics.areEqual(JSONObject.class, Double.class)) {
            return (JSONObject) Double.valueOf(expoClientConfigRootObject.getDouble("updates"));
        }
        if (Intrinsics.areEqual(JSONObject.class, Integer.class)) {
            return (JSONObject) Integer.valueOf(expoClientConfigRootObject.getInt("updates"));
        }
        if (Intrinsics.areEqual(JSONObject.class, Long.class)) {
            return (JSONObject) Long.valueOf(expoClientConfigRootObject.getLong("updates"));
        }
        if (Intrinsics.areEqual(JSONObject.class, Boolean.class)) {
            return (JSONObject) Boolean.valueOf(expoClientConfigRootObject.getBoolean("updates"));
        }
        if (Intrinsics.areEqual(JSONObject.class, JSONArray.class)) {
            Object jSONArray = expoClientConfigRootObject.getJSONArray("updates");
            if (jSONArray != null) {
                return (JSONObject) jSONArray;
            }
            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
        }
        if (Intrinsics.areEqual(JSONObject.class, JSONObject.class)) {
            JSONObject jSONObject = expoClientConfigRootObject.getJSONObject("updates");
            if (jSONObject != null) {
                return jSONObject;
            }
            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
        }
        Object obj = expoClientConfigRootObject.get("updates");
        if (obj != null) {
            return (JSONObject) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
    }

    public final String getPrimaryColor() throws JSONException {
        JSONObject expoClientConfigRootObject = getExpoClientConfigRootObject();
        if (expoClientConfigRootObject == null || !expoClientConfigRootObject.has("primaryColor")) {
            return null;
        }
        if (Intrinsics.areEqual(String.class, String.class)) {
            String string = expoClientConfigRootObject.getString("primaryColor");
            if (string != null) {
                return string;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, Double.class)) {
            return (String) Double.valueOf(expoClientConfigRootObject.getDouble("primaryColor"));
        }
        if (Intrinsics.areEqual(String.class, Integer.class)) {
            return (String) Integer.valueOf(expoClientConfigRootObject.getInt("primaryColor"));
        }
        if (Intrinsics.areEqual(String.class, Long.class)) {
            return (String) Long.valueOf(expoClientConfigRootObject.getLong("primaryColor"));
        }
        if (Intrinsics.areEqual(String.class, Boolean.class)) {
            return (String) Boolean.valueOf(expoClientConfigRootObject.getBoolean("primaryColor"));
        }
        if (Intrinsics.areEqual(String.class, JSONArray.class)) {
            Object jSONArray = expoClientConfigRootObject.getJSONArray("primaryColor");
            if (jSONArray != null) {
                return (String) jSONArray;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, JSONObject.class)) {
            Object jSONObject = expoClientConfigRootObject.getJSONObject("primaryColor");
            if (jSONObject != null) {
                return (String) jSONObject;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        Object obj = expoClientConfigRootObject.get("primaryColor");
        if (obj != null) {
            return (String) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public final String getOrientation() throws JSONException {
        JSONObject expoClientConfigRootObject = getExpoClientConfigRootObject();
        if (expoClientConfigRootObject == null || !expoClientConfigRootObject.has("orientation")) {
            return null;
        }
        if (Intrinsics.areEqual(String.class, String.class)) {
            String string = expoClientConfigRootObject.getString("orientation");
            if (string != null) {
                return string;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, Double.class)) {
            return (String) Double.valueOf(expoClientConfigRootObject.getDouble("orientation"));
        }
        if (Intrinsics.areEqual(String.class, Integer.class)) {
            return (String) Integer.valueOf(expoClientConfigRootObject.getInt("orientation"));
        }
        if (Intrinsics.areEqual(String.class, Long.class)) {
            return (String) Long.valueOf(expoClientConfigRootObject.getLong("orientation"));
        }
        if (Intrinsics.areEqual(String.class, Boolean.class)) {
            return (String) Boolean.valueOf(expoClientConfigRootObject.getBoolean("orientation"));
        }
        if (Intrinsics.areEqual(String.class, JSONArray.class)) {
            Object jSONArray = expoClientConfigRootObject.getJSONArray("orientation");
            if (jSONArray != null) {
                return (String) jSONArray;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, JSONObject.class)) {
            Object jSONObject = expoClientConfigRootObject.getJSONObject("orientation");
            if (jSONObject != null) {
                return (String) jSONObject;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        Object obj = expoClientConfigRootObject.get("orientation");
        if (obj != null) {
            return (String) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public final String getAndroidKeyboardLayoutMode() throws JSONException {
        JSONObject jSONObject;
        JSONObject expoClientConfigRootObject = getExpoClientConfigRootObject();
        if (expoClientConfigRootObject == null) {
            return null;
        }
        if (!expoClientConfigRootObject.has("android")) {
            jSONObject = null;
        } else if (Intrinsics.areEqual(JSONObject.class, String.class)) {
            Object string = expoClientConfigRootObject.getString("android");
            if (string == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
            jSONObject = (JSONObject) string;
        } else if (Intrinsics.areEqual(JSONObject.class, Double.class)) {
            jSONObject = (JSONObject) Double.valueOf(expoClientConfigRootObject.getDouble("android"));
        } else if (Intrinsics.areEqual(JSONObject.class, Integer.class)) {
            jSONObject = (JSONObject) Integer.valueOf(expoClientConfigRootObject.getInt("android"));
        } else if (Intrinsics.areEqual(JSONObject.class, Long.class)) {
            jSONObject = (JSONObject) Long.valueOf(expoClientConfigRootObject.getLong("android"));
        } else if (Intrinsics.areEqual(JSONObject.class, Boolean.class)) {
            jSONObject = (JSONObject) Boolean.valueOf(expoClientConfigRootObject.getBoolean("android"));
        } else if (Intrinsics.areEqual(JSONObject.class, JSONArray.class)) {
            Object jSONArray = expoClientConfigRootObject.getJSONArray("android");
            if (jSONArray == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
            jSONObject = (JSONObject) jSONArray;
        } else if (Intrinsics.areEqual(JSONObject.class, JSONObject.class)) {
            jSONObject = expoClientConfigRootObject.getJSONObject("android");
            if (jSONObject == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
        } else {
            Object obj = expoClientConfigRootObject.get("android");
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
            jSONObject = (JSONObject) obj;
        }
        if (jSONObject == null || !jSONObject.has("softwareKeyboardLayoutMode")) {
            return null;
        }
        if (Intrinsics.areEqual(String.class, String.class)) {
            String string2 = jSONObject.getString("softwareKeyboardLayoutMode");
            if (string2 != null) {
                return string2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, Double.class)) {
            return (String) Double.valueOf(jSONObject.getDouble("softwareKeyboardLayoutMode"));
        }
        if (Intrinsics.areEqual(String.class, Integer.class)) {
            return (String) Integer.valueOf(jSONObject.getInt("softwareKeyboardLayoutMode"));
        }
        if (Intrinsics.areEqual(String.class, Long.class)) {
            return (String) Long.valueOf(jSONObject.getLong("softwareKeyboardLayoutMode"));
        }
        if (Intrinsics.areEqual(String.class, Boolean.class)) {
            return (String) Boolean.valueOf(jSONObject.getBoolean("softwareKeyboardLayoutMode"));
        }
        if (Intrinsics.areEqual(String.class, JSONArray.class)) {
            Object jSONArray2 = jSONObject.getJSONArray("softwareKeyboardLayoutMode");
            if (jSONArray2 != null) {
                return (String) jSONArray2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, JSONObject.class)) {
            Object jSONObject2 = jSONObject.getJSONObject("softwareKeyboardLayoutMode");
            if (jSONObject2 != null) {
                return (String) jSONObject2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        Object obj2 = jSONObject.get("softwareKeyboardLayoutMode");
        if (obj2 != null) {
            return (String) obj2;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public final String getAndroidUserInterfaceStyle() throws JSONException {
        String string;
        JSONObject jSONObject;
        JSONObject expoClientConfigRootObject = getExpoClientConfigRootObject();
        if (expoClientConfigRootObject == null) {
            return null;
        }
        try {
            if (Intrinsics.areEqual(JSONObject.class, String.class)) {
                Object string2 = expoClientConfigRootObject.getString("android");
                if (string2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
                jSONObject = (JSONObject) string2;
            } else if (Intrinsics.areEqual(JSONObject.class, Double.class)) {
                jSONObject = (JSONObject) Double.valueOf(expoClientConfigRootObject.getDouble("android"));
            } else if (Intrinsics.areEqual(JSONObject.class, Integer.class)) {
                jSONObject = (JSONObject) Integer.valueOf(expoClientConfigRootObject.getInt("android"));
            } else if (Intrinsics.areEqual(JSONObject.class, Long.class)) {
                jSONObject = (JSONObject) Long.valueOf(expoClientConfigRootObject.getLong("android"));
            } else if (Intrinsics.areEqual(JSONObject.class, Boolean.class)) {
                jSONObject = (JSONObject) Boolean.valueOf(expoClientConfigRootObject.getBoolean("android"));
            } else if (Intrinsics.areEqual(JSONObject.class, JSONArray.class)) {
                Object jSONArray = expoClientConfigRootObject.getJSONArray("android");
                if (jSONArray == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
                jSONObject = (JSONObject) jSONArray;
            } else if (Intrinsics.areEqual(JSONObject.class, JSONObject.class)) {
                jSONObject = expoClientConfigRootObject.getJSONObject("android");
                if (jSONObject == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
            } else {
                Object obj = expoClientConfigRootObject.get("android");
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
                jSONObject = (JSONObject) obj;
            }
            if (Intrinsics.areEqual(String.class, String.class)) {
                String string3 = jSONObject.getString("userInterfaceStyle");
                if (string3 != null) {
                    return string3;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            if (Intrinsics.areEqual(String.class, Double.class)) {
                return (String) Double.valueOf(jSONObject.getDouble("userInterfaceStyle"));
            }
            if (Intrinsics.areEqual(String.class, Integer.class)) {
                return (String) Integer.valueOf(jSONObject.getInt("userInterfaceStyle"));
            }
            if (Intrinsics.areEqual(String.class, Long.class)) {
                return (String) Long.valueOf(jSONObject.getLong("userInterfaceStyle"));
            }
            if (Intrinsics.areEqual(String.class, Boolean.class)) {
                return (String) Boolean.valueOf(jSONObject.getBoolean("userInterfaceStyle"));
            }
            if (Intrinsics.areEqual(String.class, JSONArray.class)) {
                Object jSONArray2 = jSONObject.getJSONArray("userInterfaceStyle");
                if (jSONArray2 != null) {
                    return (String) jSONArray2;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            if (Intrinsics.areEqual(String.class, JSONObject.class)) {
                Object jSONObject2 = jSONObject.getJSONObject("userInterfaceStyle");
                if (jSONObject2 != null) {
                    return (String) jSONObject2;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            Object obj2 = jSONObject.get("userInterfaceStyle");
            if (obj2 != null) {
                return (String) obj2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (JSONException unused) {
            if (!expoClientConfigRootObject.has("userInterfaceStyle")) {
                return null;
            }
            if (Intrinsics.areEqual(String.class, String.class)) {
                string = expoClientConfigRootObject.getString("userInterfaceStyle");
                if (string == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(String.class, Double.class)) {
                string = (String) Double.valueOf(expoClientConfigRootObject.getDouble("userInterfaceStyle"));
            } else if (Intrinsics.areEqual(String.class, Integer.class)) {
                string = (String) Integer.valueOf(expoClientConfigRootObject.getInt("userInterfaceStyle"));
            } else if (Intrinsics.areEqual(String.class, Long.class)) {
                string = (String) Long.valueOf(expoClientConfigRootObject.getLong("userInterfaceStyle"));
            } else if (Intrinsics.areEqual(String.class, Boolean.class)) {
                string = (String) Boolean.valueOf(expoClientConfigRootObject.getBoolean("userInterfaceStyle"));
            } else if (Intrinsics.areEqual(String.class, JSONArray.class)) {
                Object jSONArray3 = expoClientConfigRootObject.getJSONArray("userInterfaceStyle");
                if (jSONArray3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                string = (String) jSONArray3;
            } else if (Intrinsics.areEqual(String.class, JSONObject.class)) {
                Object jSONObject3 = expoClientConfigRootObject.getJSONObject("userInterfaceStyle");
                if (jSONObject3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                string = (String) jSONObject3;
            } else {
                Object obj3 = expoClientConfigRootObject.get("userInterfaceStyle");
                if (obj3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                string = (String) obj3;
            }
            return string;
        }
    }

    public final JSONObject getAndroidStatusBarOptions() throws JSONException {
        JSONObject jSONObject;
        JSONObject expoClientConfigRootObject = getExpoClientConfigRootObject();
        if (expoClientConfigRootObject == null) {
            return null;
        }
        if (!expoClientConfigRootObject.has("extra")) {
            jSONObject = null;
        } else if (Intrinsics.areEqual(JSONObject.class, String.class)) {
            Object string = expoClientConfigRootObject.getString("extra");
            if (string == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
            jSONObject = (JSONObject) string;
        } else if (Intrinsics.areEqual(JSONObject.class, Double.class)) {
            jSONObject = (JSONObject) Double.valueOf(expoClientConfigRootObject.getDouble("extra"));
        } else if (Intrinsics.areEqual(JSONObject.class, Integer.class)) {
            jSONObject = (JSONObject) Integer.valueOf(expoClientConfigRootObject.getInt("extra"));
        } else if (Intrinsics.areEqual(JSONObject.class, Long.class)) {
            jSONObject = (JSONObject) Long.valueOf(expoClientConfigRootObject.getLong("extra"));
        } else if (Intrinsics.areEqual(JSONObject.class, Boolean.class)) {
            jSONObject = (JSONObject) Boolean.valueOf(expoClientConfigRootObject.getBoolean("extra"));
        } else if (Intrinsics.areEqual(JSONObject.class, JSONArray.class)) {
            Object jSONArray = expoClientConfigRootObject.getJSONArray("extra");
            if (jSONArray == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
            jSONObject = (JSONObject) jSONArray;
        } else if (Intrinsics.areEqual(JSONObject.class, JSONObject.class)) {
            jSONObject = expoClientConfigRootObject.getJSONObject("extra");
            if (jSONObject == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
        } else {
            Object obj = expoClientConfigRootObject.get("extra");
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
            jSONObject = (JSONObject) obj;
        }
        if (jSONObject == null || !jSONObject.has("expo-status-bar")) {
            return null;
        }
        if (!Intrinsics.areEqual(JSONObject.class, String.class)) {
            if (!Intrinsics.areEqual(JSONObject.class, Double.class)) {
                if (!Intrinsics.areEqual(JSONObject.class, Integer.class)) {
                    if (!Intrinsics.areEqual(JSONObject.class, Long.class)) {
                        if (!Intrinsics.areEqual(JSONObject.class, Boolean.class)) {
                            if (!Intrinsics.areEqual(JSONObject.class, JSONArray.class)) {
                                if (!Intrinsics.areEqual(JSONObject.class, JSONObject.class)) {
                                    Object obj2 = jSONObject.get("expo-status-bar");
                                    if (obj2 != null) {
                                        return (JSONObject) obj2;
                                    }
                                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                                }
                                JSONObject jSONObject2 = jSONObject.getJSONObject("expo-status-bar");
                                if (jSONObject2 != null) {
                                    return jSONObject2;
                                }
                                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                            }
                            Object jSONArray2 = jSONObject.getJSONArray("expo-status-bar");
                            if (jSONArray2 != null) {
                                return (JSONObject) jSONArray2;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                        }
                        return (JSONObject) Boolean.valueOf(jSONObject.getBoolean("expo-status-bar"));
                    }
                    return (JSONObject) Long.valueOf(jSONObject.getLong("expo-status-bar"));
                }
                return (JSONObject) Integer.valueOf(jSONObject.getInt("expo-status-bar"));
            }
            return (JSONObject) Double.valueOf(jSONObject.getDouble("expo-status-bar"));
        }
        Object string2 = jSONObject.getString("expo-status-bar");
        if (string2 != null) {
            return (JSONObject) string2;
        }
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
    }

    public final String getAndroidBackgroundColor() throws JSONException {
        String string;
        JSONObject jSONObject;
        JSONObject expoClientConfigRootObject = getExpoClientConfigRootObject();
        if (expoClientConfigRootObject == null) {
            return null;
        }
        try {
            if (Intrinsics.areEqual(JSONObject.class, String.class)) {
                Object string2 = expoClientConfigRootObject.getString("android");
                if (string2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
                jSONObject = (JSONObject) string2;
            } else if (Intrinsics.areEqual(JSONObject.class, Double.class)) {
                jSONObject = (JSONObject) Double.valueOf(expoClientConfigRootObject.getDouble("android"));
            } else if (Intrinsics.areEqual(JSONObject.class, Integer.class)) {
                jSONObject = (JSONObject) Integer.valueOf(expoClientConfigRootObject.getInt("android"));
            } else if (Intrinsics.areEqual(JSONObject.class, Long.class)) {
                jSONObject = (JSONObject) Long.valueOf(expoClientConfigRootObject.getLong("android"));
            } else if (Intrinsics.areEqual(JSONObject.class, Boolean.class)) {
                jSONObject = (JSONObject) Boolean.valueOf(expoClientConfigRootObject.getBoolean("android"));
            } else if (Intrinsics.areEqual(JSONObject.class, JSONArray.class)) {
                Object jSONArray = expoClientConfigRootObject.getJSONArray("android");
                if (jSONArray == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
                jSONObject = (JSONObject) jSONArray;
            } else if (Intrinsics.areEqual(JSONObject.class, JSONObject.class)) {
                jSONObject = expoClientConfigRootObject.getJSONObject("android");
                if (jSONObject == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
            } else {
                Object obj = expoClientConfigRootObject.get("android");
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
                jSONObject = (JSONObject) obj;
            }
            if (Intrinsics.areEqual(String.class, String.class)) {
                String string3 = jSONObject.getString(ViewProps.BACKGROUND_COLOR);
                if (string3 != null) {
                    return string3;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            if (Intrinsics.areEqual(String.class, Double.class)) {
                return (String) Double.valueOf(jSONObject.getDouble(ViewProps.BACKGROUND_COLOR));
            }
            if (Intrinsics.areEqual(String.class, Integer.class)) {
                return (String) Integer.valueOf(jSONObject.getInt(ViewProps.BACKGROUND_COLOR));
            }
            if (Intrinsics.areEqual(String.class, Long.class)) {
                return (String) Long.valueOf(jSONObject.getLong(ViewProps.BACKGROUND_COLOR));
            }
            if (Intrinsics.areEqual(String.class, Boolean.class)) {
                return (String) Boolean.valueOf(jSONObject.getBoolean(ViewProps.BACKGROUND_COLOR));
            }
            if (Intrinsics.areEqual(String.class, JSONArray.class)) {
                Object jSONArray2 = jSONObject.getJSONArray(ViewProps.BACKGROUND_COLOR);
                if (jSONArray2 != null) {
                    return (String) jSONArray2;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            if (Intrinsics.areEqual(String.class, JSONObject.class)) {
                Object jSONObject2 = jSONObject.getJSONObject(ViewProps.BACKGROUND_COLOR);
                if (jSONObject2 != null) {
                    return (String) jSONObject2;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            Object obj2 = jSONObject.get(ViewProps.BACKGROUND_COLOR);
            if (obj2 != null) {
                return (String) obj2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (JSONException unused) {
            if (!expoClientConfigRootObject.has(ViewProps.BACKGROUND_COLOR)) {
                return null;
            }
            if (Intrinsics.areEqual(String.class, String.class)) {
                string = expoClientConfigRootObject.getString(ViewProps.BACKGROUND_COLOR);
                if (string == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(String.class, Double.class)) {
                string = (String) Double.valueOf(expoClientConfigRootObject.getDouble(ViewProps.BACKGROUND_COLOR));
            } else if (Intrinsics.areEqual(String.class, Integer.class)) {
                string = (String) Integer.valueOf(expoClientConfigRootObject.getInt(ViewProps.BACKGROUND_COLOR));
            } else if (Intrinsics.areEqual(String.class, Long.class)) {
                string = (String) Long.valueOf(expoClientConfigRootObject.getLong(ViewProps.BACKGROUND_COLOR));
            } else if (Intrinsics.areEqual(String.class, Boolean.class)) {
                string = (String) Boolean.valueOf(expoClientConfigRootObject.getBoolean(ViewProps.BACKGROUND_COLOR));
            } else if (Intrinsics.areEqual(String.class, JSONArray.class)) {
                Object jSONArray3 = expoClientConfigRootObject.getJSONArray(ViewProps.BACKGROUND_COLOR);
                if (jSONArray3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                string = (String) jSONArray3;
            } else if (Intrinsics.areEqual(String.class, JSONObject.class)) {
                Object jSONObject3 = expoClientConfigRootObject.getJSONObject(ViewProps.BACKGROUND_COLOR);
                if (jSONObject3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                string = (String) jSONObject3;
            } else {
                Object obj3 = expoClientConfigRootObject.get(ViewProps.BACKGROUND_COLOR);
                if (obj3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                string = (String) obj3;
            }
            return string;
        }
    }

    public final JSONObject getAndroidNavigationBarOptions() throws JSONException {
        JSONObject jSONObject;
        JSONObject expoClientConfigRootObject = getExpoClientConfigRootObject();
        if (expoClientConfigRootObject == null) {
            return null;
        }
        if (!expoClientConfigRootObject.has("extra")) {
            jSONObject = null;
        } else if (Intrinsics.areEqual(JSONObject.class, String.class)) {
            Object string = expoClientConfigRootObject.getString("extra");
            if (string == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
            jSONObject = (JSONObject) string;
        } else if (Intrinsics.areEqual(JSONObject.class, Double.class)) {
            jSONObject = (JSONObject) Double.valueOf(expoClientConfigRootObject.getDouble("extra"));
        } else if (Intrinsics.areEqual(JSONObject.class, Integer.class)) {
            jSONObject = (JSONObject) Integer.valueOf(expoClientConfigRootObject.getInt("extra"));
        } else if (Intrinsics.areEqual(JSONObject.class, Long.class)) {
            jSONObject = (JSONObject) Long.valueOf(expoClientConfigRootObject.getLong("extra"));
        } else if (Intrinsics.areEqual(JSONObject.class, Boolean.class)) {
            jSONObject = (JSONObject) Boolean.valueOf(expoClientConfigRootObject.getBoolean("extra"));
        } else if (Intrinsics.areEqual(JSONObject.class, JSONArray.class)) {
            Object jSONArray = expoClientConfigRootObject.getJSONArray("extra");
            if (jSONArray == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
            jSONObject = (JSONObject) jSONArray;
        } else if (Intrinsics.areEqual(JSONObject.class, JSONObject.class)) {
            jSONObject = expoClientConfigRootObject.getJSONObject("extra");
            if (jSONObject == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
        } else {
            Object obj = expoClientConfigRootObject.get("extra");
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
            jSONObject = (JSONObject) obj;
        }
        if (jSONObject == null || !jSONObject.has("expo-navigation-bar")) {
            return null;
        }
        if (!Intrinsics.areEqual(JSONObject.class, String.class)) {
            if (!Intrinsics.areEqual(JSONObject.class, Double.class)) {
                if (!Intrinsics.areEqual(JSONObject.class, Integer.class)) {
                    if (!Intrinsics.areEqual(JSONObject.class, Long.class)) {
                        if (!Intrinsics.areEqual(JSONObject.class, Boolean.class)) {
                            if (!Intrinsics.areEqual(JSONObject.class, JSONArray.class)) {
                                if (!Intrinsics.areEqual(JSONObject.class, JSONObject.class)) {
                                    Object obj2 = jSONObject.get("expo-navigation-bar");
                                    if (obj2 != null) {
                                        return (JSONObject) obj2;
                                    }
                                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                                }
                                JSONObject jSONObject2 = jSONObject.getJSONObject("expo-navigation-bar");
                                if (jSONObject2 != null) {
                                    return jSONObject2;
                                }
                                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                            }
                            Object jSONArray2 = jSONObject.getJSONArray("expo-navigation-bar");
                            if (jSONArray2 != null) {
                                return (JSONObject) jSONArray2;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                        }
                        return (JSONObject) Boolean.valueOf(jSONObject.getBoolean("expo-navigation-bar"));
                    }
                    return (JSONObject) Long.valueOf(jSONObject.getLong("expo-navigation-bar"));
                }
                return (JSONObject) Integer.valueOf(jSONObject.getInt("expo-navigation-bar"));
            }
            return (JSONObject) Double.valueOf(jSONObject.getDouble("expo-navigation-bar"));
        }
        Object string2 = jSONObject.getString("expo-navigation-bar");
        if (string2 != null) {
            return (JSONObject) string2;
        }
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
    }

    public final String getIconUrl() throws JSONException {
        JSONObject expoClientConfigRootObject = getExpoClientConfigRootObject();
        if (expoClientConfigRootObject == null || !expoClientConfigRootObject.has("iconUrl")) {
            return null;
        }
        if (Intrinsics.areEqual(String.class, String.class)) {
            String string = expoClientConfigRootObject.getString("iconUrl");
            if (string != null) {
                return string;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, Double.class)) {
            return (String) Double.valueOf(expoClientConfigRootObject.getDouble("iconUrl"));
        }
        if (Intrinsics.areEqual(String.class, Integer.class)) {
            return (String) Integer.valueOf(expoClientConfigRootObject.getInt("iconUrl"));
        }
        if (Intrinsics.areEqual(String.class, Long.class)) {
            return (String) Long.valueOf(expoClientConfigRootObject.getLong("iconUrl"));
        }
        if (Intrinsics.areEqual(String.class, Boolean.class)) {
            return (String) Boolean.valueOf(expoClientConfigRootObject.getBoolean("iconUrl"));
        }
        if (Intrinsics.areEqual(String.class, JSONArray.class)) {
            Object jSONArray = expoClientConfigRootObject.getJSONArray("iconUrl");
            if (jSONArray != null) {
                return (String) jSONArray;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, JSONObject.class)) {
            Object jSONObject = expoClientConfigRootObject.getJSONObject("iconUrl");
            if (jSONObject != null) {
                return (String) jSONObject;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        Object obj = expoClientConfigRootObject.get("iconUrl");
        if (obj != null) {
            return (String) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public final String getAndroidGoogleServicesFile() throws JSONException {
        JSONObject jSONObject;
        JSONObject expoClientConfigRootObject = getExpoClientConfigRootObject();
        if (expoClientConfigRootObject == null) {
            return null;
        }
        if (!expoClientConfigRootObject.has("android")) {
            jSONObject = null;
        } else if (Intrinsics.areEqual(JSONObject.class, String.class)) {
            Object string = expoClientConfigRootObject.getString("android");
            if (string == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
            jSONObject = (JSONObject) string;
        } else if (Intrinsics.areEqual(JSONObject.class, Double.class)) {
            jSONObject = (JSONObject) Double.valueOf(expoClientConfigRootObject.getDouble("android"));
        } else if (Intrinsics.areEqual(JSONObject.class, Integer.class)) {
            jSONObject = (JSONObject) Integer.valueOf(expoClientConfigRootObject.getInt("android"));
        } else if (Intrinsics.areEqual(JSONObject.class, Long.class)) {
            jSONObject = (JSONObject) Long.valueOf(expoClientConfigRootObject.getLong("android"));
        } else if (Intrinsics.areEqual(JSONObject.class, Boolean.class)) {
            jSONObject = (JSONObject) Boolean.valueOf(expoClientConfigRootObject.getBoolean("android"));
        } else if (Intrinsics.areEqual(JSONObject.class, JSONArray.class)) {
            Object jSONArray = expoClientConfigRootObject.getJSONArray("android");
            if (jSONArray == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
            jSONObject = (JSONObject) jSONArray;
        } else if (Intrinsics.areEqual(JSONObject.class, JSONObject.class)) {
            jSONObject = expoClientConfigRootObject.getJSONObject("android");
            if (jSONObject == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
        } else {
            Object obj = expoClientConfigRootObject.get("android");
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
            jSONObject = (JSONObject) obj;
        }
        if (jSONObject == null || !jSONObject.has("googleServicesFile")) {
            return null;
        }
        if (Intrinsics.areEqual(String.class, String.class)) {
            String string2 = jSONObject.getString("googleServicesFile");
            if (string2 != null) {
                return string2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, Double.class)) {
            return (String) Double.valueOf(jSONObject.getDouble("googleServicesFile"));
        }
        if (Intrinsics.areEqual(String.class, Integer.class)) {
            return (String) Integer.valueOf(jSONObject.getInt("googleServicesFile"));
        }
        if (Intrinsics.areEqual(String.class, Long.class)) {
            return (String) Long.valueOf(jSONObject.getLong("googleServicesFile"));
        }
        if (Intrinsics.areEqual(String.class, Boolean.class)) {
            return (String) Boolean.valueOf(jSONObject.getBoolean("googleServicesFile"));
        }
        if (Intrinsics.areEqual(String.class, JSONArray.class)) {
            Object jSONArray2 = jSONObject.getJSONArray("googleServicesFile");
            if (jSONArray2 != null) {
                return (String) jSONArray2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, JSONObject.class)) {
            Object jSONObject2 = jSONObject.getJSONObject("googleServicesFile");
            if (jSONObject2 != null) {
                return (String) jSONObject2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        Object obj2 = jSONObject.get("googleServicesFile");
        if (obj2 != null) {
            return (String) obj2;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public final String getAndroidPackageName() throws JSONException {
        JSONObject jSONObject;
        JSONObject expoClientConfigRootObject = getExpoClientConfigRootObject();
        if (expoClientConfigRootObject == null) {
            return null;
        }
        if (!expoClientConfigRootObject.has("android")) {
            jSONObject = null;
        } else if (Intrinsics.areEqual(JSONObject.class, String.class)) {
            Object string = expoClientConfigRootObject.getString("android");
            if (string == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
            jSONObject = (JSONObject) string;
        } else if (Intrinsics.areEqual(JSONObject.class, Double.class)) {
            jSONObject = (JSONObject) Double.valueOf(expoClientConfigRootObject.getDouble("android"));
        } else if (Intrinsics.areEqual(JSONObject.class, Integer.class)) {
            jSONObject = (JSONObject) Integer.valueOf(expoClientConfigRootObject.getInt("android"));
        } else if (Intrinsics.areEqual(JSONObject.class, Long.class)) {
            jSONObject = (JSONObject) Long.valueOf(expoClientConfigRootObject.getLong("android"));
        } else if (Intrinsics.areEqual(JSONObject.class, Boolean.class)) {
            jSONObject = (JSONObject) Boolean.valueOf(expoClientConfigRootObject.getBoolean("android"));
        } else if (Intrinsics.areEqual(JSONObject.class, JSONArray.class)) {
            Object jSONArray = expoClientConfigRootObject.getJSONArray("android");
            if (jSONArray == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
            jSONObject = (JSONObject) jSONArray;
        } else if (Intrinsics.areEqual(JSONObject.class, JSONObject.class)) {
            jSONObject = expoClientConfigRootObject.getJSONObject("android");
            if (jSONObject == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
        } else {
            Object obj = expoClientConfigRootObject.get("android");
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
            jSONObject = (JSONObject) obj;
        }
        if (jSONObject == null || !jSONObject.has("packageName")) {
            return null;
        }
        if (Intrinsics.areEqual(String.class, String.class)) {
            String string2 = jSONObject.getString("packageName");
            if (string2 != null) {
                return string2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, Double.class)) {
            return (String) Double.valueOf(jSONObject.getDouble("packageName"));
        }
        if (Intrinsics.areEqual(String.class, Integer.class)) {
            return (String) Integer.valueOf(jSONObject.getInt("packageName"));
        }
        if (Intrinsics.areEqual(String.class, Long.class)) {
            return (String) Long.valueOf(jSONObject.getLong("packageName"));
        }
        if (Intrinsics.areEqual(String.class, Boolean.class)) {
            return (String) Boolean.valueOf(jSONObject.getBoolean("packageName"));
        }
        if (Intrinsics.areEqual(String.class, JSONArray.class)) {
            Object jSONArray2 = jSONObject.getJSONArray("packageName");
            if (jSONArray2 != null) {
                return (String) jSONArray2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, JSONObject.class)) {
            Object jSONObject2 = jSONObject.getJSONObject("packageName");
            if (jSONObject2 != null) {
                return (String) jSONObject2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        Object obj2 = jSONObject.get("packageName");
        if (obj2 != null) {
            return (String) obj2;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public final boolean shouldUseNextNotificationsApi() throws JSONException {
        JSONObject jSONObject;
        Boolean boolValueOf;
        JSONObject expoClientConfigRootObject = getExpoClientConfigRootObject();
        if (expoClientConfigRootObject == null) {
            return false;
        }
        Boolean bool = null;
        if (!expoClientConfigRootObject.has("android")) {
            jSONObject = null;
        } else if (Intrinsics.areEqual(JSONObject.class, String.class)) {
            Object string = expoClientConfigRootObject.getString("android");
            if (string == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
            jSONObject = (JSONObject) string;
        } else if (Intrinsics.areEqual(JSONObject.class, Double.class)) {
            jSONObject = (JSONObject) Double.valueOf(expoClientConfigRootObject.getDouble("android"));
        } else if (Intrinsics.areEqual(JSONObject.class, Integer.class)) {
            jSONObject = (JSONObject) Integer.valueOf(expoClientConfigRootObject.getInt("android"));
        } else if (Intrinsics.areEqual(JSONObject.class, Long.class)) {
            jSONObject = (JSONObject) Long.valueOf(expoClientConfigRootObject.getLong("android"));
        } else if (Intrinsics.areEqual(JSONObject.class, Boolean.class)) {
            jSONObject = (JSONObject) Boolean.valueOf(expoClientConfigRootObject.getBoolean("android"));
        } else if (Intrinsics.areEqual(JSONObject.class, JSONArray.class)) {
            Object jSONArray = expoClientConfigRootObject.getJSONArray("android");
            if (jSONArray == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
            jSONObject = (JSONObject) jSONArray;
        } else if (Intrinsics.areEqual(JSONObject.class, JSONObject.class)) {
            jSONObject = expoClientConfigRootObject.getJSONObject("android");
            if (jSONObject == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
        } else {
            Object obj = expoClientConfigRootObject.get("android");
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
            jSONObject = (JSONObject) obj;
        }
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has("useNextNotificationsApi")) {
            if (Intrinsics.areEqual(Boolean.class, String.class)) {
                Object string2 = jSONObject.getString("useNextNotificationsApi");
                if (string2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                boolValueOf = (Boolean) string2;
            } else if (Intrinsics.areEqual(Boolean.class, Double.class)) {
                boolValueOf = (Boolean) Double.valueOf(jSONObject.getDouble("useNextNotificationsApi"));
            } else if (Intrinsics.areEqual(Boolean.class, Integer.class)) {
                boolValueOf = (Boolean) Integer.valueOf(jSONObject.getInt("useNextNotificationsApi"));
            } else if (Intrinsics.areEqual(Boolean.class, Long.class)) {
                boolValueOf = (Boolean) Long.valueOf(jSONObject.getLong("useNextNotificationsApi"));
            } else if (Intrinsics.areEqual(Boolean.class, Boolean.class)) {
                boolValueOf = Boolean.valueOf(jSONObject.getBoolean("useNextNotificationsApi"));
            } else if (Intrinsics.areEqual(Boolean.class, JSONArray.class)) {
                Object jSONArray2 = jSONObject.getJSONArray("useNextNotificationsApi");
                if (jSONArray2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                boolValueOf = (Boolean) jSONArray2;
            } else if (Intrinsics.areEqual(Boolean.class, JSONObject.class)) {
                Object jSONObject2 = jSONObject.getJSONObject("useNextNotificationsApi");
                if (jSONObject2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                boolValueOf = (Boolean) jSONObject2;
            } else {
                Object obj2 = jSONObject.get("useNextNotificationsApi");
                if (obj2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                boolValueOf = (Boolean) obj2;
            }
            bool = boolValueOf;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final String getFacebookAppId() throws JSONException {
        JSONObject expoClientConfigRootObject = getExpoClientConfigRootObject();
        Intrinsics.checkNotNull(expoClientConfigRootObject);
        if (Intrinsics.areEqual(String.class, String.class)) {
            String string = expoClientConfigRootObject.getString("facebookAppId");
            if (string != null) {
                return string;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, Double.class)) {
            return (String) Double.valueOf(expoClientConfigRootObject.getDouble("facebookAppId"));
        }
        if (Intrinsics.areEqual(String.class, Integer.class)) {
            return (String) Integer.valueOf(expoClientConfigRootObject.getInt("facebookAppId"));
        }
        if (Intrinsics.areEqual(String.class, Long.class)) {
            return (String) Long.valueOf(expoClientConfigRootObject.getLong("facebookAppId"));
        }
        if (Intrinsics.areEqual(String.class, Boolean.class)) {
            return (String) Boolean.valueOf(expoClientConfigRootObject.getBoolean("facebookAppId"));
        }
        if (Intrinsics.areEqual(String.class, JSONArray.class)) {
            Object jSONArray = expoClientConfigRootObject.getJSONArray("facebookAppId");
            if (jSONArray != null) {
                return (String) jSONArray;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, JSONObject.class)) {
            Object jSONObject = expoClientConfigRootObject.getJSONObject("facebookAppId");
            if (jSONObject != null) {
                return (String) jSONObject;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        Object obj = expoClientConfigRootObject.get("facebookAppId");
        if (obj != null) {
            return (String) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public final String getFacebookApplicationName() throws JSONException {
        JSONObject expoClientConfigRootObject = getExpoClientConfigRootObject();
        Intrinsics.checkNotNull(expoClientConfigRootObject);
        if (Intrinsics.areEqual(String.class, String.class)) {
            String string = expoClientConfigRootObject.getString("facebookDisplayName");
            if (string != null) {
                return string;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, Double.class)) {
            return (String) Double.valueOf(expoClientConfigRootObject.getDouble("facebookDisplayName"));
        }
        if (Intrinsics.areEqual(String.class, Integer.class)) {
            return (String) Integer.valueOf(expoClientConfigRootObject.getInt("facebookDisplayName"));
        }
        if (Intrinsics.areEqual(String.class, Long.class)) {
            return (String) Long.valueOf(expoClientConfigRootObject.getLong("facebookDisplayName"));
        }
        if (Intrinsics.areEqual(String.class, Boolean.class)) {
            return (String) Boolean.valueOf(expoClientConfigRootObject.getBoolean("facebookDisplayName"));
        }
        if (Intrinsics.areEqual(String.class, JSONArray.class)) {
            Object jSONArray = expoClientConfigRootObject.getJSONArray("facebookDisplayName");
            if (jSONArray != null) {
                return (String) jSONArray;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(String.class, JSONObject.class)) {
            Object jSONObject = expoClientConfigRootObject.getJSONObject("facebookDisplayName");
            if (jSONObject != null) {
                return (String) jSONObject;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        Object obj = expoClientConfigRootObject.get("facebookDisplayName");
        if (obj != null) {
            return (String) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public final boolean getFacebookAutoInitEnabled() throws JSONException {
        Boolean boolValueOf;
        JSONObject expoClientConfigRootObject = getExpoClientConfigRootObject();
        Intrinsics.checkNotNull(expoClientConfigRootObject);
        if (Intrinsics.areEqual(Boolean.class, String.class)) {
            Object string = expoClientConfigRootObject.getString("facebookAutoInitEnabled");
            if (string == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
            boolValueOf = (Boolean) string;
        } else if (Intrinsics.areEqual(Boolean.class, Double.class)) {
            boolValueOf = (Boolean) Double.valueOf(expoClientConfigRootObject.getDouble("facebookAutoInitEnabled"));
        } else if (Intrinsics.areEqual(Boolean.class, Integer.class)) {
            boolValueOf = (Boolean) Integer.valueOf(expoClientConfigRootObject.getInt("facebookAutoInitEnabled"));
        } else if (Intrinsics.areEqual(Boolean.class, Long.class)) {
            boolValueOf = (Boolean) Long.valueOf(expoClientConfigRootObject.getLong("facebookAutoInitEnabled"));
        } else if (Intrinsics.areEqual(Boolean.class, Boolean.class)) {
            boolValueOf = Boolean.valueOf(expoClientConfigRootObject.getBoolean("facebookAutoInitEnabled"));
        } else if (Intrinsics.areEqual(Boolean.class, JSONArray.class)) {
            Object jSONArray = expoClientConfigRootObject.getJSONArray("facebookAutoInitEnabled");
            if (jSONArray == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
            boolValueOf = (Boolean) jSONArray;
        } else if (Intrinsics.areEqual(Boolean.class, JSONObject.class)) {
            Object jSONObject = expoClientConfigRootObject.getJSONObject("facebookAutoInitEnabled");
            if (jSONObject == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
            boolValueOf = (Boolean) jSONObject;
        } else {
            Object obj = expoClientConfigRootObject.get("facebookAutoInitEnabled");
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
            boolValueOf = (Boolean) obj;
        }
        return boolValueOf.booleanValue();
    }

    public final Map<String, Object> getPluginProperties(String packageName) throws JSONException, IllegalArgumentException {
        JSONArray jSONArray;
        Object next;
        Pair<String, Map<String, Object>> plugin;
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        JSONObject expoClientConfigRootObject = getExpoClientConfigRootObject();
        if (expoClientConfigRootObject != null) {
            if (!expoClientConfigRootObject.has("plugins")) {
                jSONArray = null;
            } else if (Intrinsics.areEqual(JSONArray.class, String.class)) {
                Object string = expoClientConfigRootObject.getString("plugins");
                if (string == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
                }
                jSONArray = (JSONArray) string;
            } else if (Intrinsics.areEqual(JSONArray.class, Double.class)) {
                jSONArray = (JSONArray) Double.valueOf(expoClientConfigRootObject.getDouble("plugins"));
            } else if (Intrinsics.areEqual(JSONArray.class, Integer.class)) {
                jSONArray = (JSONArray) Integer.valueOf(expoClientConfigRootObject.getInt("plugins"));
            } else if (Intrinsics.areEqual(JSONArray.class, Long.class)) {
                jSONArray = (JSONArray) Long.valueOf(expoClientConfigRootObject.getLong("plugins"));
            } else if (Intrinsics.areEqual(JSONArray.class, Boolean.class)) {
                jSONArray = (JSONArray) Boolean.valueOf(expoClientConfigRootObject.getBoolean("plugins"));
            } else if (Intrinsics.areEqual(JSONArray.class, JSONArray.class)) {
                jSONArray = expoClientConfigRootObject.getJSONArray("plugins");
                if (jSONArray == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
                }
            } else if (Intrinsics.areEqual(JSONArray.class, JSONObject.class)) {
                Object jSONObject = expoClientConfigRootObject.getJSONObject("plugins");
                if (jSONObject == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
                }
                jSONArray = (JSONArray) jSONObject;
            } else {
                Object obj = expoClientConfigRootObject.get("plugins");
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
                }
                jSONArray = (JSONArray) obj;
            }
            if (jSONArray != null) {
                List<PluginType> listFromRawArrayValue = PluginType.INSTANCE.fromRawArrayValue(jSONArray);
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : listFromRawArrayValue) {
                    if (obj2 instanceof PluginType.WithProps) {
                        arrayList.add(obj2);
                    }
                }
                Iterator it = arrayList.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(((PluginType.WithProps) next).getPlugin().getFirst(), packageName));
                PluginType.WithProps withProps = (PluginType.WithProps) next;
                if (withProps == null || (plugin = withProps.getPlugin()) == null) {
                    return null;
                }
                return plugin.getSecond();
            }
        }
        return null;
    }

    /* JADX INFO: compiled from: Manifest.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/manifests/core/Manifest$Companion;", "", "<init>", "()V", "fromManifestJson", "Lexpo/modules/manifests/core/Manifest;", "manifestJson", "Lorg/json/JSONObject;", "expo-manifests_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Manifest fromManifestJson(JSONObject manifestJson) throws Exception {
            Intrinsics.checkNotNullParameter(manifestJson, "manifestJson");
            if (manifestJson.has("releaseId")) {
                throw new Exception("Legacy manifests are no longer supported");
            }
            if (manifestJson.has("metadata")) {
                return new ExpoUpdatesManifest(manifestJson);
            }
            return new EmbeddedManifest(manifestJson);
        }
    }
}

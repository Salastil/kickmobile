package expo.modules.updates.manifest;

import android.net.Uri;
import android.util.Log;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.google.android.gms.common.internal.ImagesContract;
import expo.modules.manifests.core.ExpoUpdatesManifest;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.UpdatesUtils;
import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.db.enums.UpdateStatus;
import expo.modules.updates.loader.EmbeddedLoader;
import java.io.IOException;
import java.net.URI;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ExpoUpdatesUpdate.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 ,2\u00020\u0001:\u0001,Bi\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR'\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\u001f\u0010 R!\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u001d\u001a\u0004\b%\u0010&R\u001b\u0010(\u001a\u00020)8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u001d\u001a\u0004\b(\u0010*¨\u0006-"}, d2 = {"Lexpo/modules/updates/manifest/ExpoUpdatesUpdate;", "Lexpo/modules/updates/manifest/Update;", "manifest", "Lexpo/modules/manifests/core/ExpoUpdatesManifest;", "id", "Ljava/util/UUID;", UpdatesConfiguration.UPDATES_CONFIGURATION_SCOPE_KEY_KEY, "", "commitTime", "Ljava/util/Date;", UpdatesConfiguration.UPDATES_CONFIGURATION_RUNTIME_VERSION_KEY, "launchAsset", "Lorg/json/JSONObject;", "assets", "Lorg/json/JSONArray;", "extensions", ImagesContract.URL, "Landroid/net/Uri;", UpdatesConfiguration.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY, "", "<init>", "(Lexpo/modules/manifests/core/ExpoUpdatesManifest;Ljava/util/UUID;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONArray;Lorg/json/JSONObject;Landroid/net/Uri;Ljava/util/Map;)V", "getManifest", "()Lexpo/modules/manifests/core/ExpoUpdatesManifest;", "updateEntity", "Lexpo/modules/updates/db/entity/UpdateEntity;", "getUpdateEntity", "()Lexpo/modules/updates/db/entity/UpdateEntity;", "updateEntity$delegate", "Lkotlin/Lazy;", "assetHeaders", "getAssetHeaders", "()Ljava/util/Map;", "assetHeaders$delegate", "assetEntityList", "", "Lexpo/modules/updates/db/entity/AssetEntity;", "getAssetEntityList", "()Ljava/util/List;", "assetEntityList$delegate", "isDevelopmentMode", "", "()Z", "isDevelopmentMode$delegate", "Companion", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ExpoUpdatesUpdate implements Update {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "Update";

    /* JADX INFO: renamed from: assetEntityList$delegate, reason: from kotlin metadata */
    private final Lazy assetEntityList;

    /* JADX INFO: renamed from: assetHeaders$delegate, reason: from kotlin metadata */
    private final Lazy assetHeaders;
    private final JSONArray assets;
    private final Date commitTime;
    private final JSONObject extensions;
    private final UUID id;

    /* JADX INFO: renamed from: isDevelopmentMode$delegate, reason: from kotlin metadata */
    private final Lazy isDevelopmentMode;
    private final JSONObject launchAsset;
    private final ExpoUpdatesManifest manifest;
    private final Map<String, String> requestHeaders;
    private final String runtimeVersion;
    private final String scopeKey;

    /* JADX INFO: renamed from: updateEntity$delegate, reason: from kotlin metadata */
    private final Lazy updateEntity;
    private final Uri url;

    public /* synthetic */ ExpoUpdatesUpdate(ExpoUpdatesManifest expoUpdatesManifest, UUID uuid, String str, Date date, String str2, JSONObject jSONObject, JSONArray jSONArray, JSONObject jSONObject2, Uri uri, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(expoUpdatesManifest, uuid, str, date, str2, jSONObject, jSONArray, jSONObject2, uri, map);
    }

    private ExpoUpdatesUpdate(ExpoUpdatesManifest expoUpdatesManifest, UUID uuid, String str, Date date, String str2, JSONObject jSONObject, JSONArray jSONArray, JSONObject jSONObject2, Uri uri, Map<String, String> map) {
        this.manifest = expoUpdatesManifest;
        this.id = uuid;
        this.scopeKey = str;
        this.commitTime = date;
        this.runtimeVersion = str2;
        this.launchAsset = jSONObject;
        this.assets = jSONArray;
        this.extensions = jSONObject2;
        this.url = uri;
        this.requestHeaders = map;
        this.updateEntity = LazyKt.lazy(new Function0() { // from class: expo.modules.updates.manifest.ExpoUpdatesUpdate$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ExpoUpdatesUpdate.updateEntity_delegate$lambda$0(this.f$0);
            }
        });
        this.assetHeaders = LazyKt.lazy(new Function0() { // from class: expo.modules.updates.manifest.ExpoUpdatesUpdate$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ExpoUpdatesUpdate.assetHeaders_delegate$lambda$0(this.f$0);
            }
        });
        this.assetEntityList = LazyKt.lazy(new Function0() { // from class: expo.modules.updates.manifest.ExpoUpdatesUpdate$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ExpoUpdatesUpdate.assetEntityList_delegate$lambda$0(this.f$0);
            }
        });
        this.isDevelopmentMode = LazyKt.lazy(new Function0() { // from class: expo.modules.updates.manifest.ExpoUpdatesUpdate$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(this.f$0.getManifest().isDevelopmentMode());
            }
        });
    }

    @Override // expo.modules.updates.manifest.Update
    public ExpoUpdatesManifest getManifest() {
        return this.manifest;
    }

    @Override // expo.modules.updates.manifest.Update
    public UpdateEntity getUpdateEntity() {
        return (UpdateEntity) this.updateEntity.getValue();
    }

    static final UpdateEntity updateEntity_delegate$lambda$0(ExpoUpdatesUpdate expoUpdatesUpdate) {
        UpdateEntity updateEntity = new UpdateEntity(expoUpdatesUpdate.id, expoUpdatesUpdate.commitTime, expoUpdatesUpdate.runtimeVersion, expoUpdatesUpdate.scopeKey, expoUpdatesUpdate.getManifest().getRawJson(), expoUpdatesUpdate.url, expoUpdatesUpdate.requestHeaders);
        if (expoUpdatesUpdate.getIsDevelopmentMode()) {
            updateEntity.setStatus(UpdateStatus.DEVELOPMENT);
        }
        return updateEntity;
    }

    private final Map<String, JSONObject> getAssetHeaders() {
        return (Map) this.assetHeaders.getValue();
    }

    static final Map assetHeaders_delegate$lambda$0(ExpoUpdatesUpdate expoUpdatesUpdate) throws JSONException {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3 = expoUpdatesUpdate.extensions;
        if (jSONObject3 == null) {
            jSONObject3 = new JSONObject();
        }
        if (!jSONObject3.has("assetRequestHeaders")) {
            jSONObject = null;
        } else if (Intrinsics.areEqual(JSONObject.class, String.class)) {
            Object string = jSONObject3.getString("assetRequestHeaders");
            if (string == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
            jSONObject = (JSONObject) string;
        } else if (Intrinsics.areEqual(JSONObject.class, Double.class)) {
            jSONObject = (JSONObject) Double.valueOf(jSONObject3.getDouble("assetRequestHeaders"));
        } else if (Intrinsics.areEqual(JSONObject.class, Integer.class)) {
            jSONObject = (JSONObject) Integer.valueOf(jSONObject3.getInt("assetRequestHeaders"));
        } else if (Intrinsics.areEqual(JSONObject.class, Long.class)) {
            jSONObject = (JSONObject) Long.valueOf(jSONObject3.getLong("assetRequestHeaders"));
        } else if (Intrinsics.areEqual(JSONObject.class, Boolean.class)) {
            jSONObject = (JSONObject) Boolean.valueOf(jSONObject3.getBoolean("assetRequestHeaders"));
        } else if (Intrinsics.areEqual(JSONObject.class, JSONArray.class)) {
            Object jSONArray = jSONObject3.getJSONArray("assetRequestHeaders");
            if (jSONArray == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
            jSONObject = (JSONObject) jSONArray;
        } else if (Intrinsics.areEqual(JSONObject.class, JSONObject.class)) {
            jSONObject = jSONObject3.getJSONObject("assetRequestHeaders");
            if (jSONObject == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
        } else {
            Object obj = jSONObject3.get("assetRequestHeaders");
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
            jSONObject = (JSONObject) obj;
        }
        if (jSONObject != null) {
            Iterator<String> itKeys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(itKeys, "keys(...)");
            Sequence sequenceAsSequence = SequencesKt.asSequence(itKeys);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj2 : sequenceAsSequence) {
                String str = (String) obj2;
                if (Intrinsics.areEqual(JSONObject.class, String.class)) {
                    Object string2 = jSONObject.getString(str);
                    if (string2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                    jSONObject2 = (JSONObject) string2;
                } else if (Intrinsics.areEqual(JSONObject.class, Double.class)) {
                    jSONObject2 = (JSONObject) Double.valueOf(jSONObject.getDouble(str));
                } else if (Intrinsics.areEqual(JSONObject.class, Integer.class)) {
                    jSONObject2 = (JSONObject) Integer.valueOf(jSONObject.getInt(str));
                } else if (Intrinsics.areEqual(JSONObject.class, Long.class)) {
                    jSONObject2 = (JSONObject) Long.valueOf(jSONObject.getLong(str));
                } else if (Intrinsics.areEqual(JSONObject.class, Boolean.class)) {
                    jSONObject2 = (JSONObject) Boolean.valueOf(jSONObject.getBoolean(str));
                } else if (Intrinsics.areEqual(JSONObject.class, JSONArray.class)) {
                    Object jSONArray2 = jSONObject.getJSONArray(str);
                    if (jSONArray2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                    jSONObject2 = (JSONObject) jSONArray2;
                } else if (Intrinsics.areEqual(JSONObject.class, JSONObject.class)) {
                    jSONObject2 = jSONObject.getJSONObject(str);
                    if (jSONObject2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                } else {
                    Object obj3 = jSONObject.get(str);
                    if (obj3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                    jSONObject2 = (JSONObject) obj3;
                }
                linkedHashMap.put(obj2, jSONObject2);
            }
            return linkedHashMap;
        }
        return MapsKt.emptyMap();
    }

    @Override // expo.modules.updates.manifest.Update
    public List<AssetEntity> getAssetEntityList() {
        return (List) this.assetEntityList.getValue();
    }

    static final List assetEntityList_delegate$lambda$0(ExpoUpdatesUpdate expoUpdatesUpdate) {
        String string;
        String string2;
        String string3;
        String string4;
        ArrayList arrayList = new ArrayList();
        try {
            String string5 = expoUpdatesUpdate.launchAsset.getString("key");
            JSONObject jSONObject = expoUpdatesUpdate.launchAsset;
            if (!jSONObject.has("fileExtension")) {
                string3 = null;
            } else if (Intrinsics.areEqual(String.class, String.class)) {
                string3 = jSONObject.getString("fileExtension");
                if (string3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(String.class, Double.class)) {
                string3 = (String) Double.valueOf(jSONObject.getDouble("fileExtension"));
            } else if (Intrinsics.areEqual(String.class, Integer.class)) {
                string3 = (String) Integer.valueOf(jSONObject.getInt("fileExtension"));
            } else if (Intrinsics.areEqual(String.class, Long.class)) {
                string3 = (String) Long.valueOf(jSONObject.getLong("fileExtension"));
            } else if (Intrinsics.areEqual(String.class, Boolean.class)) {
                string3 = (String) Boolean.valueOf(jSONObject.getBoolean("fileExtension"));
            } else if (Intrinsics.areEqual(String.class, JSONArray.class)) {
                Object jSONArray = jSONObject.getJSONArray("fileExtension");
                if (jSONArray == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                string3 = (String) jSONArray;
            } else if (Intrinsics.areEqual(String.class, JSONObject.class)) {
                Object jSONObject2 = jSONObject.getJSONObject("fileExtension");
                if (jSONObject2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                string3 = (String) jSONObject2;
            } else {
                Object obj = jSONObject.get("fileExtension");
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                string3 = (String) obj;
            }
            AssetEntity assetEntity = new AssetEntity(string5, string3);
            assetEntity.setUrl(Uri.parse(expoUpdatesUpdate.launchAsset.getString(ImagesContract.URL)));
            assetEntity.setExtraRequestHeaders(expoUpdatesUpdate.getAssetHeaders().get(expoUpdatesUpdate.launchAsset.getString("key")));
            assetEntity.setLaunchAsset(true);
            assetEntity.setEmbeddedAssetFilename(EmbeddedLoader.BUNDLE_FILENAME);
            JSONObject jSONObject3 = expoUpdatesUpdate.launchAsset;
            if (!jSONObject3.has("hash")) {
                string4 = null;
            } else if (Intrinsics.areEqual(String.class, String.class)) {
                string4 = jSONObject3.getString("hash");
                if (string4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(String.class, Double.class)) {
                string4 = (String) Double.valueOf(jSONObject3.getDouble("hash"));
            } else if (Intrinsics.areEqual(String.class, Integer.class)) {
                string4 = (String) Integer.valueOf(jSONObject3.getInt("hash"));
            } else if (Intrinsics.areEqual(String.class, Long.class)) {
                string4 = (String) Long.valueOf(jSONObject3.getLong("hash"));
            } else if (Intrinsics.areEqual(String.class, Boolean.class)) {
                string4 = (String) Boolean.valueOf(jSONObject3.getBoolean("hash"));
            } else if (Intrinsics.areEqual(String.class, JSONArray.class)) {
                Object jSONArray2 = jSONObject3.getJSONArray("hash");
                if (jSONArray2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                string4 = (String) jSONArray2;
            } else if (Intrinsics.areEqual(String.class, JSONObject.class)) {
                Object jSONObject4 = jSONObject3.getJSONObject("hash");
                if (jSONObject4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                string4 = (String) jSONObject4;
            } else {
                Object obj2 = jSONObject3.get("hash");
                if (obj2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                string4 = (String) obj2;
            }
            assetEntity.setExpectedHash(string4);
            arrayList.add(assetEntity);
        } catch (JSONException e) {
            Log.e(TAG, "Could not read launch asset from manifest", e);
        }
        JSONArray jSONArray3 = expoUpdatesUpdate.assets;
        if (jSONArray3 != null && jSONArray3.length() > 0) {
            int length = expoUpdatesUpdate.assets.length();
            for (int i = 0; i < length; i++) {
                try {
                    JSONObject jSONObject5 = expoUpdatesUpdate.assets.getJSONObject(i);
                    AssetEntity assetEntity2 = new AssetEntity(jSONObject5.getString("key"), jSONObject5.getString("fileExtension"));
                    assetEntity2.setUrl(Uri.parse(jSONObject5.getString(ImagesContract.URL)));
                    assetEntity2.setExtraRequestHeaders(expoUpdatesUpdate.getAssetHeaders().get(jSONObject5.getString("key")));
                    Intrinsics.checkNotNull(jSONObject5);
                    if (!jSONObject5.has("embeddedAssetFilename")) {
                        string = null;
                    } else if (Intrinsics.areEqual(String.class, String.class)) {
                        string = jSONObject5.getString("embeddedAssetFilename");
                        if (string == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(String.class, Double.class)) {
                        string = (String) Double.valueOf(jSONObject5.getDouble("embeddedAssetFilename"));
                    } else if (Intrinsics.areEqual(String.class, Integer.class)) {
                        string = (String) Integer.valueOf(jSONObject5.getInt("embeddedAssetFilename"));
                    } else if (Intrinsics.areEqual(String.class, Long.class)) {
                        string = (String) Long.valueOf(jSONObject5.getLong("embeddedAssetFilename"));
                    } else if (Intrinsics.areEqual(String.class, Boolean.class)) {
                        string = (String) Boolean.valueOf(jSONObject5.getBoolean("embeddedAssetFilename"));
                    } else if (Intrinsics.areEqual(String.class, JSONArray.class)) {
                        Object jSONArray4 = jSONObject5.getJSONArray("embeddedAssetFilename");
                        if (jSONArray4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        string = (String) jSONArray4;
                    } else if (Intrinsics.areEqual(String.class, JSONObject.class)) {
                        Object jSONObject6 = jSONObject5.getJSONObject("embeddedAssetFilename");
                        if (jSONObject6 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        string = (String) jSONObject6;
                    } else {
                        Object obj3 = jSONObject5.get("embeddedAssetFilename");
                        if (obj3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        string = (String) obj3;
                    }
                    assetEntity2.setEmbeddedAssetFilename(string);
                    if (!jSONObject5.has("hash")) {
                        string2 = null;
                    } else if (Intrinsics.areEqual(String.class, String.class)) {
                        string2 = jSONObject5.getString("hash");
                        if (string2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(String.class, Double.class)) {
                        string2 = (String) Double.valueOf(jSONObject5.getDouble("hash"));
                    } else if (Intrinsics.areEqual(String.class, Integer.class)) {
                        string2 = (String) Integer.valueOf(jSONObject5.getInt("hash"));
                    } else if (Intrinsics.areEqual(String.class, Long.class)) {
                        string2 = (String) Long.valueOf(jSONObject5.getLong("hash"));
                    } else if (Intrinsics.areEqual(String.class, Boolean.class)) {
                        string2 = (String) Boolean.valueOf(jSONObject5.getBoolean("hash"));
                    } else if (Intrinsics.areEqual(String.class, JSONArray.class)) {
                        Object jSONArray5 = jSONObject5.getJSONArray("hash");
                        if (jSONArray5 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        string2 = (String) jSONArray5;
                    } else if (Intrinsics.areEqual(String.class, JSONObject.class)) {
                        Object jSONObject7 = jSONObject5.getJSONObject("hash");
                        if (jSONObject7 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        string2 = (String) jSONObject7;
                    } else {
                        Object obj4 = jSONObject5.get("hash");
                        if (obj4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        string2 = (String) obj4;
                    }
                    assetEntity2.setExpectedHash(string2);
                    arrayList.add(assetEntity2);
                } catch (JSONException e2) {
                    Log.e(TAG, "Could not read asset from manifest", e2);
                }
            }
        }
        return arrayList;
    }

    @Override // expo.modules.updates.manifest.Update
    /* JADX INFO: renamed from: isDevelopmentMode */
    public boolean getIsDevelopmentMode() {
        return ((Boolean) this.isDevelopmentMode.getValue()).booleanValue();
    }

    /* JADX INFO: compiled from: ExpoUpdatesUpdate.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\f\u0010\u0015\u001a\u00020\u0016*\u00020\u0016H\u0002R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lexpo/modules/updates/manifest/ExpoUpdatesUpdate$Companion;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "fromExpoUpdatesManifest", "Lexpo/modules/updates/manifest/ExpoUpdatesUpdate;", "manifest", "Lexpo/modules/manifests/core/ExpoUpdatesManifest;", "extensions", "Lorg/json/JSONObject;", "configuration", "Lexpo/modules/updates/UpdatesConfiguration;", "resolveManifestAssetUrls", "manifestJson", "baseUrl", "Landroid/net/Uri;", "resolveUrl", ImagesContract.URL, "withRootPath", "Ljava/net/URI;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ExpoUpdatesUpdate fromExpoUpdatesManifest(ExpoUpdatesManifest manifest, JSONObject extensions, UpdatesConfiguration configuration) throws Exception {
            Date date;
            Intrinsics.checkNotNullParameter(manifest, "manifest");
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            ExpoUpdatesManifest expoUpdatesManifest = new ExpoUpdatesManifest(resolveManifestAssetUrls(manifest.getRawJson(), configuration.getUpdateUrl()));
            UUID uuidFromString = UUID.fromString(expoUpdatesManifest.getID());
            Intrinsics.checkNotNullExpressionValue(uuidFromString, "fromString(...)");
            String scopeKey = configuration.getScopeKey();
            try {
                date = UpdatesUtils.INSTANCE.parseDateString(expoUpdatesManifest.getCreatedAt());
            } catch (ParseException e) {
                Log.e(ExpoUpdatesUpdate.TAG, "Could not parse manifest createdAt string; falling back to current time", e);
                date = new Date();
            }
            ExpoUpdatesUpdate expoUpdatesUpdate = new ExpoUpdatesUpdate(expoUpdatesManifest, uuidFromString, scopeKey, date, expoUpdatesManifest.getRuntimeVersion(), expoUpdatesManifest.getLaunchAsset(), expoUpdatesManifest.getAssets(), extensions, configuration.getUpdateUrl(), configuration.getRequestHeaders(), null);
            Iterator<T> it = expoUpdatesUpdate.getAssetEntityList().iterator();
            while (it.hasNext()) {
                String strCreateFilenameForAsset = UpdatesUtils.INSTANCE.createFilenameForAsset((AssetEntity) it.next());
                if (!UpdatesUtils.INSTANCE.isSafeFilename(strCreateFilenameForAsset)) {
                    throw new IOException("Update " + expoUpdatesManifest.getID() + " could not be loaded because the asset filename \"" + strCreateFilenameForAsset + "\" is not a valid filename. Assets are stored under their key and file extension, so neither may contain a path separator. Check the server that produced this manifest.");
                }
            }
            return expoUpdatesUpdate;
        }

        private final JSONObject resolveManifestAssetUrls(JSONObject manifestJson, Uri baseUrl) throws JSONException {
            JSONArray jSONArray;
            JSONObject jSONObject = new JSONObject(manifestJson.toString());
            JSONObject jSONObject2 = jSONObject.getJSONObject("launchAsset");
            String string = jSONObject2.getString(ImagesContract.URL);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            jSONObject2.put(ImagesContract.URL, resolveUrl(string, baseUrl));
            if (!jSONObject.has("assets")) {
                jSONArray = null;
            } else if (Intrinsics.areEqual(JSONArray.class, String.class)) {
                Object string2 = jSONObject.getString("assets");
                if (string2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
                }
                jSONArray = (JSONArray) string2;
            } else if (Intrinsics.areEqual(JSONArray.class, Double.class)) {
                jSONArray = (JSONArray) Double.valueOf(jSONObject.getDouble("assets"));
            } else if (Intrinsics.areEqual(JSONArray.class, Integer.class)) {
                jSONArray = (JSONArray) Integer.valueOf(jSONObject.getInt("assets"));
            } else if (Intrinsics.areEqual(JSONArray.class, Long.class)) {
                jSONArray = (JSONArray) Long.valueOf(jSONObject.getLong("assets"));
            } else if (Intrinsics.areEqual(JSONArray.class, Boolean.class)) {
                jSONArray = (JSONArray) Boolean.valueOf(jSONObject.getBoolean("assets"));
            } else if (Intrinsics.areEqual(JSONArray.class, JSONArray.class)) {
                jSONArray = jSONObject.getJSONArray("assets");
                if (jSONArray == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
                }
            } else if (Intrinsics.areEqual(JSONArray.class, JSONObject.class)) {
                Object jSONObject3 = jSONObject.getJSONObject("assets");
                if (jSONObject3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
                }
                jSONArray = (JSONArray) jSONObject3;
            } else {
                Object obj = jSONObject.get("assets");
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
                }
                jSONArray = (JSONArray) obj;
            }
            if (jSONArray != null) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject4 = jSONArray.getJSONObject(i);
                    String string3 = jSONObject4.getString(ImagesContract.URL);
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    jSONObject4.put(ImagesContract.URL, resolveUrl(string3, baseUrl));
                }
            }
            return jSONObject;
        }

        private final String resolveUrl(String url, Uri baseUrl) {
            try {
                String string = withRootPath(new URI(baseUrl.toString())).resolve(url).toString();
                Intrinsics.checkNotNull(string);
                return string;
            } catch (Exception unused) {
                return url;
            }
        }

        private final URI withRootPath(URI uri) {
            if (uri.getRawAuthority() == null) {
                return uri;
            }
            String rawPath = uri.getRawPath();
            if (rawPath != null && rawPath.length() != 0) {
                return uri;
            }
            return new URI(uri.getScheme() + "://" + uri.getRawAuthority() + DomExceptionUtils.SEPARATOR);
        }
    }
}

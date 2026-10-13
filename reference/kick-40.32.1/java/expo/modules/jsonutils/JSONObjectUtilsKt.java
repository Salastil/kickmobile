package expo.modules.jsonutils;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: JSONObjectUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a&\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0086\b¢\u0006\u0002\u0010\u0006\u001a(\u0010\u0007\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0086\b¢\u0006\u0002\u0010\u0006¨\u0006\b"}, d2 = {"require", ExifInterface.GPS_DIRECTION_TRUE, "", "Lorg/json/JSONObject;", "key", "", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Object;", "getNullable", "expo-json-utils_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class JSONObjectUtilsKt {
    public static final /* synthetic */ <T> T require(JSONObject jSONObject, String key) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        if (Intrinsics.areEqual(Object.class, String.class)) {
            CharSequence string = jSONObject.getString(key);
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return (T) string;
        }
        if (Intrinsics.areEqual(Object.class, Double.class)) {
            Object objValueOf = Double.valueOf(jSONObject.getDouble(key));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return (T) objValueOf;
        }
        if (Intrinsics.areEqual(Object.class, Integer.class)) {
            Object objValueOf2 = Integer.valueOf(jSONObject.getInt(key));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return (T) objValueOf2;
        }
        if (Intrinsics.areEqual(Object.class, Long.class)) {
            Object objValueOf3 = Long.valueOf(jSONObject.getLong(key));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return (T) objValueOf3;
        }
        if (Intrinsics.areEqual(Object.class, Boolean.class)) {
            Object objValueOf4 = Boolean.valueOf(jSONObject.getBoolean(key));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return (T) objValueOf4;
        }
        if (Intrinsics.areEqual(Object.class, JSONArray.class)) {
            Object jSONArray = jSONObject.getJSONArray(key);
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return (T) jSONArray;
        }
        if (Intrinsics.areEqual(Object.class, JSONObject.class)) {
            Object jSONObject2 = jSONObject.getJSONObject(key);
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return (T) jSONObject2;
        }
        T t = (T) jSONObject.get(key);
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
        return t;
    }

    public static final /* synthetic */ <T> T getNullable(JSONObject jSONObject, String key) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (!jSONObject.has(key)) {
            return null;
        }
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        if (Intrinsics.areEqual(Object.class, String.class)) {
            CharSequence string = jSONObject.getString(key);
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return (T) string;
        }
        if (Intrinsics.areEqual(Object.class, Double.class)) {
            Object objValueOf = Double.valueOf(jSONObject.getDouble(key));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return (T) objValueOf;
        }
        if (Intrinsics.areEqual(Object.class, Integer.class)) {
            Object objValueOf2 = Integer.valueOf(jSONObject.getInt(key));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return (T) objValueOf2;
        }
        if (Intrinsics.areEqual(Object.class, Long.class)) {
            Object objValueOf3 = Long.valueOf(jSONObject.getLong(key));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return (T) objValueOf3;
        }
        if (Intrinsics.areEqual(Object.class, Boolean.class)) {
            Object objValueOf4 = Boolean.valueOf(jSONObject.getBoolean(key));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return (T) objValueOf4;
        }
        if (Intrinsics.areEqual(Object.class, JSONArray.class)) {
            Object jSONArray = jSONObject.getJSONArray(key);
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return (T) jSONArray;
        }
        if (Intrinsics.areEqual(Object.class, JSONObject.class)) {
            Object jSONObject2 = jSONObject.getJSONObject(key);
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return (T) jSONObject2;
        }
        T t = (T) jSONObject.get(key);
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
        return t;
    }
}

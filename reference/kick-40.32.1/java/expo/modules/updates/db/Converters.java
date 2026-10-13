package expo.modules.updates.db;

import android.net.Uri;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import expo.modules.notifications.serverregistration.InstallationId;
import expo.modules.updates.db.enums.HashType;
import expo.modules.updates.db.enums.UpdateStatus;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Converters.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0007J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0007J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0007J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0015H\u0007J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0019H\u0007J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020 H\u0007J\u0012\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010\u001fH\u0007J\u0010\u0010#\u001a\u00020$2\u0006\u0010\t\u001a\u00020 H\u0007J\u0012\u0010%\u001a\u00020 2\b\u0010&\u001a\u0004\u0018\u00010$H\u0007J \u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010(2\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0007J \u0010)\u001a\u0004\u0018\u00010\u00052\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010(H\u0007R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lexpo/modules/updates/db/Converters;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "longToDate", "Ljava/util/Date;", "value", "", "(Ljava/lang/Long;)Ljava/util/Date;", "dateToLong", "date", "(Ljava/util/Date;)Ljava/lang/Long;", "stringToUri", "Landroid/net/Uri;", TypedValues.Custom.S_STRING, "uriToString", "uri", "stringToJsonObject", "Lorg/json/JSONObject;", "jsonObjectToString", "jsonObject", "bytesToUuid", "Ljava/util/UUID;", "bytes", "", "uuidToBytes", InstallationId.LEGACY_PREFERENCES_UUID_KEY, "intToStatus", "Lexpo/modules/updates/db/enums/UpdateStatus;", "", "statusToInt", "status", "intToHashType", "Lexpo/modules/updates/db/enums/HashType;", "hashTypeToInt", "hashType", "stringToStringStringMap", "", "stringStringMapToString", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Converters {
    private final String TAG = "Converters";

    /* JADX INFO: compiled from: Converters.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UpdateStatus.values().length];
            try {
                iArr[UpdateStatus.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UpdateStatus.PENDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[UpdateStatus.EMBEDDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[UpdateStatus.DEVELOPMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final int hashTypeToInt(HashType hashType) {
        return 0;
    }

    public final Date longToDate(Long value) {
        if (value == null) {
            return null;
        }
        return new Date(value.longValue());
    }

    public final Long dateToLong(Date date) {
        if (date != null) {
            return Long.valueOf(date.getTime());
        }
        return null;
    }

    public final Uri stringToUri(String string) {
        if (string == null) {
            return null;
        }
        return Uri.parse(string);
    }

    public final String uriToString(Uri uri) {
        if (uri != null) {
            return uri.toString();
        }
        return null;
    }

    public final JSONObject stringToJsonObject(String string) {
        if (string == null) {
            return null;
        }
        try {
            return new JSONObject(string);
        } catch (JSONException e) {
            Log.e(this.TAG, "Could not convert string to JSONObject", e);
            return new JSONObject();
        }
    }

    public final String jsonObjectToString(JSONObject jsonObject) {
        if (jsonObject != null) {
            return jsonObject.toString();
        }
        return null;
    }

    public final UUID bytesToUuid(byte[] bytes) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bytes);
        return new UUID(byteBufferWrap.getLong(), byteBufferWrap.getLong());
    }

    public final byte[] uuidToBytes(UUID uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[16]);
        byteBufferWrap.putLong(uuid.getMostSignificantBits());
        byteBufferWrap.putLong(uuid.getLeastSignificantBits());
        byte[] bArrArray = byteBufferWrap.array();
        Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
        return bArrArray;
    }

    public final UpdateStatus intToStatus(int value) {
        if (value == 1) {
            return UpdateStatus.READY;
        }
        if (value == 3) {
            return UpdateStatus.PENDING;
        }
        if (value == 5) {
            return UpdateStatus.EMBEDDED;
        }
        if (value == 6) {
            return UpdateStatus.DEVELOPMENT;
        }
        throw new AssertionError("Invalid UpdateStatus value in database: " + value);
    }

    public final int statusToInt(UpdateStatus status) {
        int i = status == null ? -1 : WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 3;
        }
        if (i == 3) {
            return 5;
        }
        if (i == 4) {
            return 6;
        }
        throw new AssertionError("Invalid UpdateStatus value: " + status);
    }

    public final HashType intToHashType(int value) {
        return HashType.SHA256;
    }

    public final Map<String, String> stringToStringStringMap(String value) {
        if (value == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(value);
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Intrinsics.checkNotNull(next);
            String strOptString = jSONObject.optString(next);
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            mapCreateMapBuilder.put(next, strOptString);
        }
        return MapsKt.build(mapCreateMapBuilder);
    }

    public final String stringStringMapToString(Map<String, String> value) throws JSONException {
        if (value == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : value.entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        return jSONObject.toString();
    }
}

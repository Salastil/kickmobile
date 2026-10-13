package com.swmansion.rnscreens.gamma.helpers;

import android.content.Context;
import android.util.Log;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.hermes.intl.Constants;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReadableMapExt.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0007\u001a\u001b\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\n\u001a#\u0010\u000b\u001a\u0004\u0018\u00010\f*\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u000f\u001a\u001c\u0010\u0010\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\u0012\u001a\u00020\u0006*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0006H\u0000\u001a-\u0010\u0013\u001a\u0004\u0018\u00010\f*\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0002\u0010\u0014\u001a \u0010\u0015\u001a\u0004\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u0014\u0010\u0016\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a#\u0010\u0017\u001a\u0004\u0018\u00010\f*\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u000f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"TAG", "", "readOptionalString", "Lcom/facebook/react/bridge/ReadableMap;", "key", "readOptionalBoolean", "", "(Lcom/facebook/react/bridge/ReadableMap;Ljava/lang/String;)Ljava/lang/Boolean;", "readOptionalFloat", "", "(Lcom/facebook/react/bridge/ReadableMap;Ljava/lang/String;)Ljava/lang/Float;", "readOptionalColor", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "(Lcom/facebook/react/bridge/ReadableMap;Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Integer;", "readString", Constants.COLLATION_DEFAULT, "readBoolean", "readColor", "(Lcom/facebook/react/bridge/ReadableMap;Landroid/content/Context;Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/Integer;", "readImageUri", "requireNotNullString", "parseColor", "react-native-screens_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ReadableMapExtKt {
    private static final String TAG = "ReadableMapExt";

    /* JADX INFO: compiled from: ReadableMapExt.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReadableType.values().length];
            try {
                iArr[ReadableType.Map.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReadableType.Number.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final String readOptionalString(ReadableMap readableMap, String key) {
        Intrinsics.checkNotNullParameter(readableMap, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (readableMap.hasKey(key) && !readableMap.isNull(key) && readableMap.getType(key) == ReadableType.String) {
            return readableMap.getString(key);
        }
        return null;
    }

    public static final Boolean readOptionalBoolean(ReadableMap readableMap, String key) {
        Intrinsics.checkNotNullParameter(readableMap, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (readableMap.hasKey(key) && !readableMap.isNull(key) && readableMap.getType(key) == ReadableType.Boolean) {
            return Boolean.valueOf(readableMap.getBoolean(key));
        }
        return null;
    }

    public static final Float readOptionalFloat(ReadableMap readableMap, String key) {
        Intrinsics.checkNotNullParameter(readableMap, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (readableMap.hasKey(key) && !readableMap.isNull(key) && readableMap.getType(key) == ReadableType.Number) {
            return Float.valueOf((float) readableMap.getDouble(key));
        }
        return null;
    }

    public static final Integer readOptionalColor(ReadableMap readableMap, Context context, String key) {
        Intrinsics.checkNotNullParameter(readableMap, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        if (!readableMap.hasKey(key) || readableMap.isNull(key)) {
            return null;
        }
        return parseColor(readableMap, context, key);
    }

    public static final String readString(ReadableMap readableMap, String key, String str) {
        Intrinsics.checkNotNullParameter(readableMap, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(str, "default");
        String optionalString = readOptionalString(readableMap, key);
        return optionalString == null ? str : optionalString;
    }

    public static final boolean readBoolean(ReadableMap readableMap, String key, boolean z) {
        Intrinsics.checkNotNullParameter(readableMap, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Boolean optionalBoolean = readOptionalBoolean(readableMap, key);
        return optionalBoolean != null ? optionalBoolean.booleanValue() : z;
    }

    public static final Integer readColor(ReadableMap readableMap, Context context, String key, Integer num) {
        Intrinsics.checkNotNullParameter(readableMap, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        return (!readableMap.hasKey(key) || readableMap.isNull(key)) ? num : parseColor(readableMap, context, key);
    }

    public static final String readImageUri(ReadableMap readableMap, String key, String str) {
        ReadableMap map;
        String string;
        Intrinsics.checkNotNullParameter(readableMap, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return (!readableMap.hasKey(key) || readableMap.getType(key) != ReadableType.Map || (map = readableMap.getMap(key)) == null || (string = map.getString("uri")) == null) ? str : string;
    }

    public static final String requireNotNullString(ReadableMap readableMap, String key) {
        Intrinsics.checkNotNullParameter(readableMap, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        String string = readableMap.getString(key);
        if (string != null) {
            return string;
        }
        throw new IllegalArgumentException(("[RNScreens] " + key + " property must not be null.").toString());
    }

    public static final Integer parseColor(ReadableMap readableMap, Context context, String key) {
        Intrinsics.checkNotNullParameter(readableMap, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            int i = WhenMappings.$EnumSwitchMapping$0[readableMap.getType(key).ordinal()];
            if (i == 1) {
                return ColorPropConverter.getColor(readableMap.getMap(key), context);
            }
            if (i != 2) {
                return null;
            }
            return Integer.valueOf(readableMap.getInt(key));
        } catch (Exception e) {
            Log.w(TAG, "[RNScreens] Could not parse color for key '" + key + "': " + e.getMessage());
            return null;
        }
    }
}

package com.swmansion.reanimated;

import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.NoSuchKeyException;
import com.facebook.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MapUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0007J\"\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0007¨\u0006\f"}, d2 = {"Lcom/swmansion/reanimated/MapUtils;", "", "<init>", "()V", "getInt", "", "map", "Lcom/facebook/react/bridge/ReadableMap;", "name", "", "errorMsg", "getString", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MapUtils {
    public static final MapUtils INSTANCE = new MapUtils();

    private MapUtils() {
    }

    @JvmStatic
    public static final int getInt(ReadableMap map, String name, String errorMsg) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        try {
            return map.getInt(name);
        } catch (NoSuchKeyException unused) {
            throw new JSApplicationCausedNativeException(errorMsg);
        }
    }

    @JvmStatic
    public static final String getString(ReadableMap map, String name, String errorMsg) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        try {
            return map.getString(name);
        } catch (NoSuchKeyException unused) {
            throw new JSApplicationCausedNativeException(errorMsg);
        }
    }
}

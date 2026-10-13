package com.datadog.reactnative;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GlobalState.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0007J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0007R\"\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/datadog/reactnative/GlobalState;", "", "<init>", "()V", "globalAttributes", "", "", "getGlobalAttributes$datadog_mobile_react_native_release", "()Ljava/util/Map;", "addAttribute", "", "key", "value", "removeAttribute", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GlobalState {
    public static final GlobalState INSTANCE = new GlobalState();
    private static final Map<String, Object> globalAttributes = new ConcurrentHashMap();

    private GlobalState() {
    }

    public final Map<String, Object> getGlobalAttributes$datadog_mobile_react_native_release() {
        return globalAttributes;
    }

    @JvmStatic
    public static final void addAttribute(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (value == null) {
            globalAttributes.remove(key);
        } else {
            globalAttributes.put(key, value);
        }
    }

    @JvmStatic
    public static final void removeAttribute(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        globalAttributes.remove(key);
    }
}

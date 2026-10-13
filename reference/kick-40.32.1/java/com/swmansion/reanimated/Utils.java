package com.swmansion.reanimated;

import com.datadog.android.webview.internal.log.WebViewLogEventConsumer;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0001H\u0007J!\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0016\"\u00020\u0014H\u0007¢\u0006\u0002\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/swmansion/reanimated/Utils;", "", "<init>", "()V", "processMapping", "", "", "", "style", "Lcom/facebook/react/bridge/ReadableMap;", "processIntArray", "", "ary", "Lcom/facebook/react/bridge/ReadableArray;", "simplifyStringNumbersList", "list", "convertToFloat", "", "value", "combineRunnables", "Ljava/lang/Runnable;", "runnables", "", "([Ljava/lang/Runnable;)Ljava/lang/Runnable;", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Utils {
    public static final Utils INSTANCE = new Utils();

    private Utils() {
    }

    @JvmStatic
    public static final Map<String, Integer> processMapping(ReadableMap style) {
        Intrinsics.checkNotNullParameter(style, "style");
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = style.keySetIterator();
        HashMap map = new HashMap();
        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            map.put(strNextKey, Integer.valueOf(style.getInt(strNextKey)));
        }
        return map;
    }

    @JvmStatic
    public static final int[] processIntArray(ReadableArray ary) {
        Intrinsics.checkNotNullParameter(ary, "ary");
        int size = ary.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = ary.getInt(i);
        }
        return iArr;
    }

    @JvmStatic
    public static final String simplifyStringNumbersList(String list) {
        Intrinsics.checkNotNullParameter(list, "list");
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(list, WebViewLogEventConsumer.DDTAGS_SEPARATOR, "", false, 4, (Object) null), "[", "", false, 4, (Object) null), "]", "", false, 4, (Object) null);
    }

    @JvmStatic
    public static final float convertToFloat(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value instanceof Integer) {
            return ((Number) value).intValue();
        }
        if (value instanceof Float) {
            return ((Number) value).floatValue();
        }
        if (value instanceof Double) {
            return (float) ((Number) value).doubleValue();
        }
        return 0.0f;
    }

    @JvmStatic
    public static final Runnable combineRunnables(final Runnable... runnables) {
        Intrinsics.checkNotNullParameter(runnables, "runnables");
        return new Runnable() { // from class: com.swmansion.reanimated.Utils$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Utils.combineRunnables$lambda$0(runnables);
            }
        };
    }

    static final void combineRunnables$lambda$0(Runnable[] runnableArr) {
        for (Runnable runnable : runnableArr) {
            runnable.run();
        }
    }
}

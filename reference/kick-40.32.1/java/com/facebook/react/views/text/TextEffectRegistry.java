package com.facebook.react.views.text;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.annotations.UnstableReactNativeAPI;
import com.facebook.react.views.text.internal.span.TextEffectSpan;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextEffectRegistry.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006J!\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0002\b\u0011R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/facebook/react/views/text/TextEffectRegistry;", "", "<init>", "()V", "factories", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/facebook/react/views/text/TextEffectSpanFactory;", "register", "", "name", "factory", "unregister", "createSpan", "Lcom/facebook/react/views/text/internal/span/TextEffectSpan;", "props", "Lcom/facebook/react/bridge/ReadableMap;", "createSpan$ReactAndroid", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
@UnstableReactNativeAPI
public final class TextEffectRegistry {
    private static final String TAG = "TextEffectRegistry";
    public static volatile TextEffectRegistry current;
    private final ConcurrentHashMap<String, TextEffectSpanFactory> factories = new ConcurrentHashMap<>();

    public final void register(String name, TextEffectSpanFactory factory) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.factories.put(name, factory);
        current = this;
    }

    public final void unregister(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.factories.remove(name);
    }

    public final TextEffectSpan createSpan$ReactAndroid(String name, ReadableMap props) {
        Intrinsics.checkNotNullParameter(name, "name");
        TextEffectSpanFactory textEffectSpanFactory = this.factories.get(name);
        if (textEffectSpanFactory == null) {
            return null;
        }
        try {
            return textEffectSpanFactory.createSpan(props);
        } catch (Throwable th) {
            FLog.e(TAG, "TextEffectSpanFactory '" + name + "' threw — skipping span", th);
            return null;
        }
    }
}

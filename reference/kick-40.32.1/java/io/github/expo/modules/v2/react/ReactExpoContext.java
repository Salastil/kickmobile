package io.github.expo.modules.v2.react;

import com.facebook.react.bridge.ReactApplicationContext;
import io.github.expo.modules.v2.ExpoContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactExpoContext.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/github/expo/modules/v2/react/ReactExpoContext;", "Lio/github/expo/modules/v2/ExpoContext;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "getReactContext", "()Lcom/facebook/react/bridge/ReactApplicationContext;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ReactExpoContext extends ExpoContext {
    private final ReactApplicationContext reactContext;

    public ReactExpoContext(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
    }

    public final ReactApplicationContext getReactContext() {
        return this.reactContext;
    }
}

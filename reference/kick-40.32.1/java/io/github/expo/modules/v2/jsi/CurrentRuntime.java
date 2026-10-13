package io.github.expo.modules.v2.jsi;

import java.lang.ref.WeakReference;
import kotlin.Metadata;

/* JADX INFO: compiled from: CurrentRuntime.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\u0016\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006R\u001c\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lio/github/expo/modules/v2/jsi/CurrentRuntime;", "", "<init>", "()V", "slot", "Ljava/lang/ThreadLocal;", "Ljava/lang/ref/WeakReference;", "Lio/github/expo/modules/v2/jsi/JavaScriptRuntime;", "get", "raw", "set", "", "runtime", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CurrentRuntime {
    public static final CurrentRuntime INSTANCE = new CurrentRuntime();
    private static final ThreadLocal<WeakReference<JavaScriptRuntime>> slot = new ThreadLocal<>();

    private CurrentRuntime() {
    }

    public final JavaScriptRuntime get() {
        JavaScriptRuntime javaScriptRuntime;
        WeakReference<JavaScriptRuntime> weakReference = slot.get();
        if (weakReference == null || (javaScriptRuntime = weakReference.get()) == null || javaScriptRuntime.getIsClosed()) {
            return null;
        }
        return javaScriptRuntime;
    }

    public final WeakReference<JavaScriptRuntime> raw() {
        return slot.get();
    }

    public final void set(WeakReference<JavaScriptRuntime> runtime) {
        slot.set(runtime);
    }
}

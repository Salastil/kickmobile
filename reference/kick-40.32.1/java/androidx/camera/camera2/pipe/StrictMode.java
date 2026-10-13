package androidx.camera.camera2.pipe;

import androidx.camera.camera2.pipe.core.Log;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StrictMode.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u000e\b\u0004\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0086\bø\u0001\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000e"}, d2 = {"Landroidx/camera/camera2/pipe/StrictMode;", "", "enabled", "", "<init>", "(Z)V", "getEnabled", "()Z", "check", "", "value", "message", "Lkotlin/Function0;", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StrictMode {
    private final boolean enabled;

    public StrictMode(boolean z) {
        this.enabled = z;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final void check(boolean value, Function0<String> message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (value) {
            return;
        }
        String strInvoke = message.invoke();
        if (getEnabled()) {
            throw new IllegalStateException(strInvoke);
        }
        if (Log.INSTANCE.getWARN_LOGGABLE()) {
            android.util.Log.w(Log.TAG, strInvoke);
        }
    }
}

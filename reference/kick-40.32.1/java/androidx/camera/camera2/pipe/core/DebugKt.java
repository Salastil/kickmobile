package androidx.camera.camera2.pipe.core;

import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Debug.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0086\b\u001a\u0011\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0086\b\u001a\u0011\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0086\b\u001a\u0011\u0010\b\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0086\b\u001a\u0011\u0010\t\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0086\b\u001a\u0011\u0010\n\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0086\b\u001a\u0011\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0086\b¨\u0006\f"}, d2 = {"checkApi", "", "requiredApi", "", "methodName", "", "checkLOrHigher", "checkMOrHigher", "checkNOrHigher", "checkOOrHigher", "checkPOrHigher", "checkQOrHigher", "camera-camera2-pipe"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class DebugKt {
    public static final void checkLOrHigher(String methodName) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
    }

    public static final void checkMOrHigher(String methodName) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
    }

    public static final void checkNOrHigher(String methodName) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
    }

    public static final void checkApi(int i, String methodName) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        if (Build.VERSION.SDK_INT >= i) {
            return;
        }
        throw new IllegalStateException((methodName + " is not supported on API " + Build.VERSION.SDK_INT + " (requires API " + i + ')').toString());
    }

    public static final void checkOOrHigher(String methodName) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        if (Build.VERSION.SDK_INT >= 26) {
            return;
        }
        throw new IllegalStateException((methodName + " is not supported on API " + Build.VERSION.SDK_INT + " (requires API 26)").toString());
    }

    public static final void checkPOrHigher(String methodName) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        if (Build.VERSION.SDK_INT >= 28) {
            return;
        }
        throw new IllegalStateException((methodName + " is not supported on API " + Build.VERSION.SDK_INT + " (requires API 28)").toString());
    }

    public static final void checkQOrHigher(String methodName) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        if (Build.VERSION.SDK_INT >= 29) {
            return;
        }
        throw new IllegalStateException((methodName + " is not supported on API " + Build.VERSION.SDK_INT + " (requires API 29)").toString());
    }
}

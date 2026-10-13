package io.github.expo.kolibri;

import java.lang.ref.Reference;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: compiled from: NativeObject.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"nativePointerOf", "", "obj", "Lio/github/expo/kolibri/NativeObject;", "hasJvmReachabilityFence", "", "reachabilityFenceOf", "", "runtime"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NativeObjectKt {
    private static final boolean hasJvmReachabilityFence;

    public static final long nativePointerOf(NativeObject nativeObject) {
        if (nativeObject != null) {
            return nativeObject.nativePointer;
        }
        return 0L;
    }

    static {
        boolean z;
        try {
            Reference.class.getDeclaredMethod("reachabilityFence", Object.class);
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        hasJvmReachabilityFence = z;
    }

    public static final void reachabilityFenceOf(NativeObject nativeObject) {
        if (hasJvmReachabilityFence) {
            JvmReachabilityFence.INSTANCE.fence(nativeObject);
        } else if (nativeObject != null) {
            synchronized (nativeObject) {
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}

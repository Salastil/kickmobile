package expo.modules.kotlin.jni.fabric;

import com.facebook.jni.HybridData;
import com.facebook.react.uimanager.ViewProps;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NativeStatePropsGetter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0001H\u0086 J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u001e\u0010\r\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bJ\u001e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bJ\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\tJ!\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0082 J\u0011\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0082 J\t\u0010\u0019\u001a\u00020\tH\u0082 J!\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0082 J!\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0082 J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0007\u001a\u00020\u0001H\u0002¨\u0006\u001e"}, d2 = {"Lexpo/modules/kotlin/jni/fabric/NativeStatePropsGetter;", "", "<init>", "()V", "getStateProps", "", "", "stateWrapper", "updateStyleSizeImmediate", "", "styleWidth", "", "styleHeight", "updateViewSizeImmediate", ViewProps.WIDTH, ViewProps.HEIGHT, "setContentOrigin", "tag", "", ViewDeviceOrientationData.DEVICE_ORIENTATION_X, ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, "clearContentOrigin", "clearAllContentOrigins", "setContentOriginImpl", "clearContentOriginImpl", "clearAllContentOriginsImpl", "updateStyleSizeImmediateImpl", "updateViewSizeImmediateImpl", "isStateValid", "", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NativeStatePropsGetter {
    public static final int $stable = 0;

    private final native void clearAllContentOriginsImpl();

    private final native void clearContentOriginImpl(int tag);

    private final native void setContentOriginImpl(int tag, double x, double y);

    private final native void updateStyleSizeImmediateImpl(Object stateWrapper, double styleWidth, double styleHeight);

    private final native void updateViewSizeImmediateImpl(Object stateWrapper, double width, double height);

    public final native Map<String, Object> getStateProps(Object stateWrapper);

    public final void updateStyleSizeImmediate(Object stateWrapper, double styleWidth, double styleHeight) {
        Intrinsics.checkNotNullParameter(stateWrapper, "stateWrapper");
        if (isStateValid(stateWrapper)) {
            updateStyleSizeImmediateImpl(stateWrapper, styleWidth, styleHeight);
        }
    }

    public final void updateViewSizeImmediate(Object stateWrapper, double width, double height) {
        Intrinsics.checkNotNullParameter(stateWrapper, "stateWrapper");
        if (isStateValid(stateWrapper)) {
            updateViewSizeImmediateImpl(stateWrapper, width, height);
        }
    }

    public final void setContentOrigin(int tag, double x, double y) {
        setContentOriginImpl(tag, x, y);
    }

    public final void clearContentOrigin(int tag) {
        clearContentOriginImpl(tag);
    }

    public final void clearAllContentOrigins() {
        clearAllContentOriginsImpl();
    }

    private final boolean isStateValid(Object stateWrapper) {
        HybridData hybridData = stateWrapper instanceof HybridData ? (HybridData) stateWrapper : null;
        return hybridData != null && hybridData.isValid();
    }
}

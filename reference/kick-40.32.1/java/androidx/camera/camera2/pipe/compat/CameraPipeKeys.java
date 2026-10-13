package androidx.camera.camera2.pipe.compat;

import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: CameraPipeKeys.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\bR\u000e\u0010\u000e\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/camera/camera2/pipe/compat/CameraPipeKeys;", "", "<init>", "()V", "camera2ExtensionMode", "Landroidx/camera/camera2/pipe/Metadata$Key;", "", "getCamera2ExtensionMode", "()Landroidx/camera/camera2/pipe/Metadata$Key;", "camera2CaptureRequestTag", "getCamera2CaptureRequestTag", "ignore3ARequiredParameters", "", "getIgnore3ARequiredParameters", "CAMERA2_EXTENSION_MODE_AUTOMATIC", "CAMERA2_EXTENSION_MODE_FACE_RETOUCH", "CAMERA2_EXTENSION_MODE_BOKEH", "CAMERA2_EXTENSION_MODE_HDR", "CAMERA2_EXTENSION_MODE_NIGHT", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraPipeKeys {
    public static final int CAMERA2_EXTENSION_MODE_AUTOMATIC = 0;
    public static final int CAMERA2_EXTENSION_MODE_BOKEH = 2;
    public static final int CAMERA2_EXTENSION_MODE_FACE_RETOUCH = 1;
    public static final int CAMERA2_EXTENSION_MODE_HDR = 3;
    public static final int CAMERA2_EXTENSION_MODE_NIGHT = 4;
    public static final CameraPipeKeys INSTANCE = new CameraPipeKeys();
    private static final androidx.camera.camera2.pipe.Metadata.Key<Integer> camera2ExtensionMode = androidx.camera.camera2.pipe.Metadata.Key.INSTANCE.create("androidx.camera.camera2.pipe.extensionMode", Reflection.getOrCreateKotlinClass(Integer.class));
    private static final androidx.camera.camera2.pipe.Metadata.Key<Object> camera2CaptureRequestTag = androidx.camera.camera2.pipe.Metadata.Key.INSTANCE.create("androidx.camera.camera2.pipe.captureRequestTag", Reflection.getOrCreateKotlinClass(Object.class));
    private static final androidx.camera.camera2.pipe.Metadata.Key<Boolean> ignore3ARequiredParameters = androidx.camera.camera2.pipe.Metadata.Key.INSTANCE.create("androidx.camera.camera2.pipe.ignore3ARequiredParameters", Reflection.getOrCreateKotlinClass(Boolean.class));

    private CameraPipeKeys() {
    }

    public final androidx.camera.camera2.pipe.Metadata.Key<Integer> getCamera2ExtensionMode() {
        return camera2ExtensionMode;
    }

    public final androidx.camera.camera2.pipe.Metadata.Key<Object> getCamera2CaptureRequestTag() {
        return camera2CaptureRequestTag;
    }

    public final androidx.camera.camera2.pipe.Metadata.Key<Boolean> getIgnore3ARequiredParameters() {
        return ignore3ARequiredParameters;
    }
}

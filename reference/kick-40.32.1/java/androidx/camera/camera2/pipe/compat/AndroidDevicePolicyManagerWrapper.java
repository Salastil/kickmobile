package androidx.camera.camera2.pipe.compat;

import android.app.admin.DevicePolicyManager;
import android.os.Trace;
import androidx.camera.camera2.pipe.core.Debug;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RetryingCameraStateOpener.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/camera/camera2/pipe/compat/AndroidDevicePolicyManagerWrapper;", "Landroidx/camera/camera2/pipe/compat/DevicePolicyManagerWrapper;", "devicePolicyManager", "Landroid/app/admin/DevicePolicyManager;", "<init>", "(Landroid/app/admin/DevicePolicyManager;)V", "camerasDisabled", "", "getCamerasDisabled", "()Z", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AndroidDevicePolicyManagerWrapper implements DevicePolicyManagerWrapper {
    private final DevicePolicyManager devicePolicyManager;

    @Inject
    public AndroidDevicePolicyManagerWrapper(DevicePolicyManager devicePolicyManager) {
        Intrinsics.checkNotNullParameter(devicePolicyManager, "devicePolicyManager");
        this.devicePolicyManager = devicePolicyManager;
    }

    @Override // androidx.camera.camera2.pipe.compat.DevicePolicyManagerWrapper
    public boolean getCamerasDisabled() {
        Debug debug = Debug.INSTANCE;
        try {
            Trace.beginSection("DevicePolicyManager#getCameraDisabled");
            return this.devicePolicyManager.getCameraDisabled(null);
        } finally {
            Trace.endSection();
        }
    }
}

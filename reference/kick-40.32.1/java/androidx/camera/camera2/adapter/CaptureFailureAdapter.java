package androidx.camera.camera2.adapter;

import android.hardware.camera2.CaptureFailure;
import androidx.camera.camera2.pipe.RequestFailure;
import androidx.camera.camera2.pipe.compat.AndroidCaptureFailure;
import androidx.camera.core.impl.CameraCaptureFailure;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: CaptureFailureAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/camera/camera2/adapter/CaptureFailureAdapter;", "Landroidx/camera/core/impl/CameraCaptureFailure;", "requestFailure", "Landroidx/camera/camera2/pipe/RequestFailure;", "<init>", "(Landroidx/camera/camera2/pipe/RequestFailure;)V", "getCaptureFailure", "Landroid/hardware/camera2/CaptureFailure;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CaptureFailureAdapter extends CameraCaptureFailure {
    private final RequestFailure requestFailure;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CaptureFailureAdapter(RequestFailure requestFailure) {
        super(CameraCaptureFailure.Reason.ERROR);
        Intrinsics.checkNotNullParameter(requestFailure, "requestFailure");
        this.requestFailure = requestFailure;
    }

    @Override // androidx.camera.core.impl.CameraCaptureFailure
    public CaptureFailure getCaptureFailure() {
        RequestFailure requestFailure = this.requestFailure;
        Intrinsics.checkNotNull(requestFailure, "null cannot be cast to non-null type androidx.camera.camera2.pipe.compat.AndroidCaptureFailure");
        Object objUnwrapAs = ((AndroidCaptureFailure) requestFailure).unwrapAs(Reflection.getOrCreateKotlinClass(CaptureFailure.class));
        Intrinsics.checkNotNull(objUnwrapAs);
        return (CaptureFailure) objUnwrapAs;
    }
}

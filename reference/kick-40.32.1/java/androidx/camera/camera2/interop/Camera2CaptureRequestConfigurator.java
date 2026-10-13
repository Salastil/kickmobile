package androidx.camera.camera2.interop;

import android.hardware.camera2.CaptureRequest;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: Camera2CaptureRequestConfigurator.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\bç\u0080\u0001\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00010\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/interop/Camera2CaptureRequestConfigurator;", "", "configureWith", "", "parameters", "", "Landroid/hardware/camera2/CaptureRequest$Key;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface Camera2CaptureRequestConfigurator {
    void configureWith(Map<CaptureRequest.Key<?>, ? extends Object> parameters);
}

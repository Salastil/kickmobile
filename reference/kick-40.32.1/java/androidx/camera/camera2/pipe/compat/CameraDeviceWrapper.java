package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.InputConfiguration;
import android.view.Surface;
import androidx.camera.camera2.pipe.UnsafeWrapper;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: CameraDeviceWrapper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u00012\u00020\u0002J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u001e\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u0016H&J&\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u0016H&J\u001e\u0010\u001a\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u0016H&J\u001e\u0010\u001b\u001a\u00020\u00112\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00132\u0006\u0010\u0015\u001a\u00020\u0016H'J&\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00132\u0006\u0010\u0015\u001a\u00020\u0016H'J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"H'J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010!\u001a\u00020$H'J\b\u0010%\u001a\u00020&H&J\b\u0010'\u001a\u00020&H&J\u000f\u0010(\u001a\u00020)H'¢\u0006\u0004\b*\u0010+R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006,À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/compat/CameraDeviceWrapper;", "Landroidx/camera/camera2/pipe/UnsafeWrapper;", "Landroidx/camera/camera2/pipe/compat/AudioRestrictionController$Listener;", "cameraId", "Landroidx/camera/camera2/pipe/CameraId;", "getCameraId-Dz_R5H8", "()Ljava/lang/String;", "createCaptureRequest", "Landroid/hardware/camera2/CaptureRequest$Builder;", "template", "Landroidx/camera/camera2/pipe/RequestTemplate;", "createCaptureRequest-2PPcXtw", "(I)Landroid/hardware/camera2/CaptureRequest$Builder;", "createReprocessCaptureRequest", "inputResult", "Landroid/hardware/camera2/TotalCaptureResult;", "createCaptureSession", "", "outputs", "", "Landroid/view/Surface;", "stateCallback", "Landroidx/camera/camera2/pipe/compat/CameraCaptureSessionWrapper$StateCallback;", "createReprocessableCaptureSession", "input", "Landroid/hardware/camera2/params/InputConfiguration;", "createConstrainedHighSpeedCaptureSession", "createCaptureSessionByOutputConfigurations", "outputConfigurations", "Landroidx/camera/camera2/pipe/compat/OutputConfigurationWrapper;", "createReprocessableCaptureSessionByConfigurations", "inputConfig", "Landroidx/camera/camera2/pipe/compat/InputConfigData;", "config", "Landroidx/camera/camera2/pipe/compat/SessionConfigData;", "createExtensionSession", "Landroidx/camera/camera2/pipe/compat/ExtensionSessionConfigData;", "onDeviceClosing", "", "onDeviceClosed", "getCameraAudioRestriction", "Landroidx/camera/camera2/pipe/AudioRestrictionMode;", "getCameraAudioRestriction-_b5Q8KE", "()I", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CameraDeviceWrapper extends UnsafeWrapper, AudioRestrictionController.Listener {
    /* JADX INFO: renamed from: createCaptureRequest-2PPcXtw */
    CaptureRequest.Builder mo800createCaptureRequest2PPcXtw(int template);

    boolean createCaptureSession(SessionConfigData config);

    boolean createCaptureSession(List<? extends Surface> outputs, CameraCaptureSessionWrapper.StateCallback stateCallback);

    boolean createCaptureSessionByOutputConfigurations(List<? extends OutputConfigurationWrapper> outputConfigurations, CameraCaptureSessionWrapper.StateCallback stateCallback);

    boolean createConstrainedHighSpeedCaptureSession(List<? extends Surface> outputs, CameraCaptureSessionWrapper.StateCallback stateCallback);

    boolean createExtensionSession(ExtensionSessionConfigData config);

    CaptureRequest.Builder createReprocessCaptureRequest(TotalCaptureResult inputResult);

    boolean createReprocessableCaptureSession(InputConfiguration input, List<? extends Surface> outputs, CameraCaptureSessionWrapper.StateCallback stateCallback);

    boolean createReprocessableCaptureSessionByConfigurations(InputConfigData inputConfig, List<? extends OutputConfigurationWrapper> outputs, CameraCaptureSessionWrapper.StateCallback stateCallback);

    /* JADX INFO: renamed from: getCameraAudioRestriction-_b5Q8KE */
    int mo801getCameraAudioRestriction_b5Q8KE();

    /* JADX INFO: renamed from: getCameraId-Dz_R5H8 */
    String mo802getCameraIdDz_R5H8();

    void onDeviceClosed();

    void onDeviceClosing();
}

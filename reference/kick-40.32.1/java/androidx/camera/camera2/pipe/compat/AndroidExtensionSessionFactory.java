package androidx.camera.camera2.pipe.compat;

import android.view.Surface;
import androidx.camera.camera2.pipe.CameraExtensionMetadata;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.StreamId;
import androidx.camera.camera2.pipe.StrictMode;
import androidx.camera.camera2.pipe.core.HandlerExecutor;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.graph.StreamGraphImpl;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CaptureSessionFactory.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ,\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/camera/camera2/pipe/compat/AndroidExtensionSessionFactory;", "Landroidx/camera/camera2/pipe/compat/CaptureSessionFactory;", "threads", "Landroidx/camera/camera2/pipe/core/Threads;", "graphConfig", "Landroidx/camera/camera2/pipe/CameraGraph$Config;", "streamGraph", "Landroidx/camera/camera2/pipe/graph/StreamGraphImpl;", "camera2MetadataProvider", "Landroidx/camera/camera2/pipe/compat/Camera2MetadataProvider;", "strictMode", "Landroidx/camera/camera2/pipe/StrictMode;", "<init>", "(Landroidx/camera/camera2/pipe/core/Threads;Landroidx/camera/camera2/pipe/CameraGraph$Config;Landroidx/camera/camera2/pipe/graph/StreamGraphImpl;Landroidx/camera/camera2/pipe/compat/Camera2MetadataProvider;Landroidx/camera/camera2/pipe/StrictMode;)V", "create", "Landroidx/camera/camera2/pipe/compat/CaptureSessionFactory$Result;", "cameraDevice", "Landroidx/camera/camera2/pipe/compat/CameraDeviceWrapper;", "surfaces", "", "Landroidx/camera/camera2/pipe/StreamId;", "Landroid/view/Surface;", "captureSessionState", "Landroidx/camera/camera2/pipe/compat/CaptureSessionState;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AndroidExtensionSessionFactory implements CaptureSessionFactory {
    private final Camera2MetadataProvider camera2MetadataProvider;
    private final CameraGraph.Config graphConfig;
    private final StreamGraphImpl streamGraph;
    private final StrictMode strictMode;
    private final Threads threads;

    @Inject
    public AndroidExtensionSessionFactory(Threads threads, CameraGraph.Config graphConfig, StreamGraphImpl streamGraph, Camera2MetadataProvider camera2MetadataProvider, StrictMode strictMode) {
        Intrinsics.checkNotNullParameter(threads, "threads");
        Intrinsics.checkNotNullParameter(graphConfig, "graphConfig");
        Intrinsics.checkNotNullParameter(streamGraph, "streamGraph");
        Intrinsics.checkNotNullParameter(camera2MetadataProvider, "camera2MetadataProvider");
        Intrinsics.checkNotNullParameter(strictMode, "strictMode");
        this.threads = threads;
        this.graphConfig = graphConfig;
        this.streamGraph = streamGraph;
        this.camera2MetadataProvider = camera2MetadataProvider;
        this.strictMode = strictMode;
    }

    @Override // androidx.camera.camera2.pipe.compat.CaptureSessionFactory
    public CaptureSessionFactory.Result create(CameraDeviceWrapper cameraDevice, Map<StreamId, ? extends Surface> surfaces, CaptureSessionState captureSessionState) {
        Intrinsics.checkNotNullParameter(cameraDevice, "cameraDevice");
        Intrinsics.checkNotNullParameter(surfaces, "surfaces");
        Intrinsics.checkNotNullParameter(captureSessionState, "captureSessionState");
        boolean zM410equalsimpl0 = CameraGraph.OperatingMode.m410equalsimpl0(this.graphConfig.m389getSessionMode2uNL3no(), CameraGraph.OperatingMode.INSTANCE.m415getEXTENSION2uNL3no());
        CameraGraph.Config config = this.graphConfig;
        if (!zM410equalsimpl0) {
            throw new IllegalArgumentException("Unsupported session mode: " + ((Object) CameraGraph.OperatingMode.m412toStringimpl(config.m389getSessionMode2uNL3no())) + " for Extension CameraGraph");
        }
        Object obj = config.getSessionParameters().get(CameraPipeKeys.INSTANCE.getCamera2ExtensionMode());
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        if (num != null) {
            int iIntValue = num.intValue();
            if (this.graphConfig.getInput() != null) {
                throw new IllegalStateException("Reprocessing is not supported for Extensions".toString());
            }
            CameraMetadata cameraMetadataMo846awaitCameraMetadataEfqyGwQ = this.camera2MetadataProvider.mo846awaitCameraMetadataEfqyGwQ(cameraDevice.getCameraId());
            Set<Integer> supportedExtensions = cameraMetadataMo846awaitCameraMetadataEfqyGwQ.getSupportedExtensions();
            StrictMode strictMode = this.strictMode;
            if (!supportedExtensions.contains(Integer.valueOf(iIntValue))) {
                String str = cameraDevice + " does not support extension mode " + iIntValue + ". Supported extensions are " + supportedExtensions;
                if (!strictMode.getEnabled()) {
                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                        android.util.Log.w(Log.TAG, str);
                    }
                } else {
                    throw new IllegalStateException(str);
                }
            }
            if (this.graphConfig.getPostviewStream() != null) {
                CameraExtensionMetadata cameraExtensionMetadataAwaitExtensionMetadata = cameraMetadataMo846awaitCameraMetadataEfqyGwQ.awaitExtensionMetadata(iIntValue);
                StrictMode strictMode2 = this.strictMode;
                if (!cameraExtensionMetadataAwaitExtensionMetadata.isPostviewSupported()) {
                    String str2 = cameraDevice + " does not support Postview streams";
                    if (!strictMode2.getEnabled()) {
                        if (Log.INSTANCE.getWARN_LOGGABLE()) {
                            android.util.Log.w(Log.TAG, str2);
                        }
                    } else {
                        throw new IllegalStateException(str2);
                    }
                }
                if (this.graphConfig.getPostviewStream().getOutputs().size() != 1) {
                    throw new IllegalStateException("Postview streams can only have one OutputStream.config object".toString());
                }
            }
            OutputConfigurations outputConfigurationsBuildOutputConfigurations = CaptureSessionFactoryKt.buildOutputConfigurations(this.graphConfig, this.streamGraph, surfaces);
            if (!outputConfigurationsBuildOutputConfigurations.getAll().isEmpty()) {
                if (!outputConfigurationsBuildOutputConfigurations.getDeferred().isEmpty()) {
                    throw new IllegalStateException("Deferred output is not supported for Extensions".toString());
                }
                if (cameraDevice.createExtensionSession(new ExtensionSessionConfigData(2, outputConfigurationsBuildOutputConfigurations.getAll(), new HandlerExecutor(this.threads.getCamera2Handler()), captureSessionState, this.graphConfig.m390getSessionTemplatefGx8uWA(), this.graphConfig.getSessionParameters(), Integer.valueOf(iIntValue), new ExtensionSessionState(captureSessionState), outputConfigurationsBuildOutputConfigurations.getPostviewOutput()))) {
                    return new CaptureSessionFactory.Result.Success(outputConfigurationsBuildOutputConfigurations.getDeferred(), outputConfigurationsBuildOutputConfigurations.getOutputSurfaceMap());
                }
                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                    android.util.Log.w(Log.TAG, "Failed to create ExtensionCaptureSession from " + cameraDevice + " for " + captureSessionState + '!');
                }
                captureSessionState.onSessionFinalized();
                return CaptureSessionFactory.Result.Failed.INSTANCE;
            }
            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Failed to create OutputConfigurations for " + this.graphConfig);
            }
            captureSessionState.onSessionFinalized();
            return CaptureSessionFactory.Result.Failed.INSTANCE;
        }
        throw new IllegalStateException("The CameraPipeKeys.camera2ExtensionMode must be set in the sessionParameters of the CameraGraph.Config when creating an Extension CameraGraph.".toString());
    }
}

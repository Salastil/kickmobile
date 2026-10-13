package androidx.camera.camera2.pipe.compat;

import android.view.Surface;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.InputStream;
import androidx.camera.camera2.pipe.OutputStream;
import androidx.camera.camera2.pipe.StreamId;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.graph.StreamGraphImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CaptureSessionFactory.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ,\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/camera/camera2/pipe/compat/AndroidPSessionFactory;", "Landroidx/camera/camera2/pipe/compat/CaptureSessionFactory;", "threads", "Landroidx/camera/camera2/pipe/core/Threads;", "graphConfig", "Landroidx/camera/camera2/pipe/CameraGraph$Config;", "streamGraph", "Landroidx/camera/camera2/pipe/graph/StreamGraphImpl;", "<init>", "(Landroidx/camera/camera2/pipe/core/Threads;Landroidx/camera/camera2/pipe/CameraGraph$Config;Landroidx/camera/camera2/pipe/graph/StreamGraphImpl;)V", "create", "Landroidx/camera/camera2/pipe/compat/CaptureSessionFactory$Result;", "cameraDevice", "Landroidx/camera/camera2/pipe/compat/CameraDeviceWrapper;", "surfaces", "", "Landroidx/camera/camera2/pipe/StreamId;", "Landroid/view/Surface;", "captureSessionState", "Landroidx/camera/camera2/pipe/compat/CaptureSessionState;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AndroidPSessionFactory implements CaptureSessionFactory {
    private final CameraGraph.Config graphConfig;
    private final StreamGraphImpl streamGraph;
    private final Threads threads;

    @Inject
    public AndroidPSessionFactory(Threads threads, CameraGraph.Config graphConfig, StreamGraphImpl streamGraph) {
        Intrinsics.checkNotNullParameter(threads, "threads");
        Intrinsics.checkNotNullParameter(graphConfig, "graphConfig");
        Intrinsics.checkNotNullParameter(streamGraph, "streamGraph");
        this.threads = threads;
        this.graphConfig = graphConfig;
        this.streamGraph = streamGraph;
    }

    @Override // androidx.camera.camera2.pipe.compat.CaptureSessionFactory
    public CaptureSessionFactory.Result create(CameraDeviceWrapper cameraDevice, Map<StreamId, ? extends Surface> surfaces, CaptureSessionState captureSessionState) {
        int iM389getSessionMode2uNL3no;
        int i;
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(cameraDevice, "cameraDevice");
        Intrinsics.checkNotNullParameter(surfaces, "surfaces");
        Intrinsics.checkNotNullParameter(captureSessionState, "captureSessionState");
        int iM389getSessionMode2uNL3no2 = this.graphConfig.m389getSessionMode2uNL3no();
        if (CameraGraph.OperatingMode.m410equalsimpl0(iM389getSessionMode2uNL3no2, CameraGraph.OperatingMode.INSTANCE.m417getNORMAL2uNL3no())) {
            i = 0;
        } else {
            if (CameraGraph.OperatingMode.m410equalsimpl0(iM389getSessionMode2uNL3no2, CameraGraph.OperatingMode.INSTANCE.m416getHIGH_SPEED2uNL3no())) {
                iM389getSessionMode2uNL3no = 1;
            } else {
                boolean zM410equalsimpl0 = CameraGraph.OperatingMode.m410equalsimpl0(iM389getSessionMode2uNL3no2, CameraGraph.OperatingMode.INSTANCE.m415getEXTENSION2uNL3no());
                CameraGraph.Config config = this.graphConfig;
                if (zM410equalsimpl0) {
                    throw new IllegalArgumentException("Unsupported session mode: " + ((Object) CameraGraph.OperatingMode.m412toStringimpl(config.m389getSessionMode2uNL3no())));
                }
                iM389getSessionMode2uNL3no = config.m389getSessionMode2uNL3no();
            }
            i = iM389getSessionMode2uNL3no;
        }
        OutputConfigurations outputConfigurationsBuildOutputConfigurations = CaptureSessionFactoryKt.buildOutputConfigurations(this.graphConfig, this.streamGraph, surfaces);
        if (!outputConfigurationsBuildOutputConfigurations.getAll().isEmpty()) {
            List<InputStream.Config> input = this.graphConfig.getInput();
            if (input != null) {
                List<InputStream.Config> list = input;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    OutputStream.Config config2 = (OutputStream.Config) CollectionsKt.single((List) ((InputStream.Config) it.next()).getStream().getOutputs());
                    arrayList2.add(new InputConfigData(config2.getSize().getWidth(), config2.getSize().getHeight(), config2.getFormat()));
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            ArrayList arrayList3 = arrayList;
            if (arrayList3 != null) {
                ArrayList arrayList4 = arrayList3;
                if (!(arrayList4 instanceof Collection) || !arrayList4.isEmpty()) {
                    Iterator it2 = arrayList4.iterator();
                    while (it2.hasNext()) {
                        if (((InputConfigData) it2.next()).getFormat() != ((InputConfigData) arrayList3.get(0)).getFormat()) {
                            throw new IllegalStateException("All InputStream.Config objects must have the same format for multi resolution".toString());
                        }
                    }
                }
            }
            if (cameraDevice.createCaptureSession(new SessionConfigData(i, arrayList3, outputConfigurationsBuildOutputConfigurations.getAll(), this.threads.getCamera2Executor(), captureSessionState, this.graphConfig.m390getSessionTemplatefGx8uWA(), this.graphConfig.getSessionParameters(), this.graphConfig.m388getSessionColorSpacedxVZaPA(), null))) {
                return new CaptureSessionFactory.Result.Success(outputConfigurationsBuildOutputConfigurations.getDeferred(), outputConfigurationsBuildOutputConfigurations.getOutputSurfaceMap());
            }
            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Failed to create capture session from " + cameraDevice + " for " + captureSessionState + '!');
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
}

package androidx.camera.camera2.pipe;

import android.os.Trace;
import androidx.camera.camera2.pipe.config.CameraGraphConfigModule;
import androidx.camera.camera2.pipe.config.CameraPipeComponent;
import androidx.camera.camera2.pipe.config.FrameGraphConfigModule;
import androidx.camera.camera2.pipe.core.Debug;
import androidx.camera.camera2.pipe.core.Log;
import com.datadog.trace.bootstrap.instrumentation.api.Tags;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CameraPipe.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u00122\u0006\u0010\u000e\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0003J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00122\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0016H\u0003J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u000fH\u0002J\u0018\u0010&\u001a\u00020'2\u0006\u0010%\u001a\u00020\u000fH\u0096@¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020+2\u0006\u0010%\u001a\u00020\u000fH\u0016J\b\u0010\n\u001a\u00020+H\u0016J\b\u00103\u001a\u000204H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R$\u0010.\u001a\u00020-2\u0006\u0010,\u001a\u00020-8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u00065"}, d2 = {"Landroidx/camera/camera2/pipe/CameraPipeImpl;", "Landroidx/camera/camera2/pipe/CameraPipe;", Tags.COMPONENT, "Landroidx/camera/camera2/pipe/config/CameraPipeComponent;", "<init>", "(Landroidx/camera/camera2/pipe/config/CameraPipeComponent;)V", "debugId", "", "lock", "", "shutdown", "", "create", "Landroidx/camera/camera2/pipe/CameraGraph;", "config", "Landroidx/camera/camera2/pipe/CameraGraph$Config;", "createCameraGraph", "createCameraGraphs", "", "Landroidx/camera/camera2/pipe/CameraGraph$ConcurrentConfig;", "createCameraGraphLocked", "cameraGraphId", "Landroidx/camera/camera2/pipe/CameraGraphId;", "createFrameGraph", "Landroidx/camera/camera2/pipe/FrameGraph;", "frameGraphConfig", "Landroidx/camera/camera2/pipe/FrameGraph$Config;", "createFrameGraphs", "frameGraphConfigs", "Landroidx/camera/camera2/pipe/FrameGraph$ConcurrentConfig;", "createFrameGraphLocked", "cameras", "Landroidx/camera/camera2/pipe/CameraDevices;", "cameraSurfaceManager", "Landroidx/camera/camera2/pipe/CameraSurfaceManager;", "getBackend", "Landroidx/camera/camera2/pipe/CameraBackend;", "graphConfig", "isConfigSupported", "Landroidx/camera/camera2/pipe/ConfigQueryResult;", "isConfigSupported-NpXggIU", "(Landroidx/camera/camera2/pipe/CameraGraph$Config;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prewarmIsConfigSupported", "", "value", "Landroidx/camera/camera2/pipe/AudioRestrictionMode;", "globalAudioRestrictionMode", "getGlobalAudioRestrictionMode-_b5Q8KE", "()I", "setGlobalAudioRestrictionMode-LwUUkyU", "(I)V", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraPipeImpl implements CameraPipe {
    private final CameraPipeComponent component;
    private final int debugId;
    private final Object lock;
    private boolean shutdown;

    public CameraPipeImpl(CameraPipeComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
        this.debugId = CameraPipeKt.getCameraPipeIds().incrementAndGet();
        this.lock = new Object();
    }

    @Override // androidx.camera.camera2.pipe.CameraPipe
    @Deprecated(message = "Use createCameraGraph instead.", replaceWith = @ReplaceWith(expression = "createCameraGraph(config)", imports = {}))
    public CameraGraph create(CameraGraph.Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        return createCameraGraph(config);
    }

    @Override // androidx.camera.camera2.pipe.CameraPipe
    public CameraGraph createCameraGraph(CameraGraph.Config config) {
        CameraGraph cameraGraphCreateCameraGraphLocked;
        Intrinsics.checkNotNullParameter(config, "config");
        synchronized (this.lock) {
            if (this.shutdown) {
                throw new IllegalStateException("Check failed.");
            }
            cameraGraphCreateCameraGraphLocked = createCameraGraphLocked(config, CameraGraphId.INSTANCE.nextId());
        }
        return cameraGraphCreateCameraGraphLocked;
    }

    @Override // androidx.camera.camera2.pipe.CameraPipe
    public List<CameraGraph> createCameraGraphs(CameraGraph.ConcurrentConfig config) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(config, "config");
        synchronized (this.lock) {
            if (this.shutdown) {
                throw new IllegalStateException("Check failed.");
            }
            Map mapCreateMapBuilder = MapsKt.createMapBuilder();
            Iterator<CameraGraph.Config> it = config.getGraphConfigs().iterator();
            while (it.hasNext()) {
                mapCreateMapBuilder.put(it.next(), CameraGraphId.INSTANCE.nextId());
            }
            Map mapBuild = MapsKt.build(mapCreateMapBuilder);
            List<CameraGraph.Config> graphConfigs = config.getGraphConfigs();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(graphConfigs, 10));
            Iterator<T> it2 = graphConfigs.iterator();
            while (it2.hasNext()) {
                arrayList2.add(CameraId.m426boximpl(((CameraGraph.Config) it2.next()).m385getCameraDz_R5H8()));
            }
            ConcurrentCameraGraphs concurrentCameraGraphs = new ConcurrentCameraGraphs(CollectionsKt.toSet(mapBuild.values()), CollectionsKt.toSet(arrayList2));
            List<CameraGraph.Config> graphConfigs2 = config.getGraphConfigs();
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(graphConfigs2, 10));
            for (CameraGraph.Config config2 : graphConfigs2) {
                config2.setConcurrentCameraGraphs$camera_camera2_pipe(concurrentCameraGraphs);
                Object obj = mapBuild.get(config2);
                if (obj == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                arrayList3.add(createCameraGraphLocked(config2, (CameraGraphId) obj));
            }
            arrayList = arrayList3;
        }
        return arrayList;
    }

    private final CameraGraph createCameraGraphLocked(CameraGraph.Config config, CameraGraphId cameraGraphId) {
        Debug debug = Debug.INSTANCE;
        try {
            Trace.beginSection("CXCP#CameraGraph-" + ((Object) CameraId.m432toStringimpl(config.m385getCameraDz_R5H8())));
            return this.component.cameraGraphComponentBuilder().cameraGraphConfigModule(new CameraGraphConfigModule(config, cameraGraphId)).build().cameraGraph();
        } finally {
            Trace.endSection();
        }
    }

    @Override // androidx.camera.camera2.pipe.CameraPipe
    public FrameGraph createFrameGraph(FrameGraph.Config frameGraphConfig) {
        FrameGraph frameGraphCreateFrameGraphLocked;
        Intrinsics.checkNotNullParameter(frameGraphConfig, "frameGraphConfig");
        synchronized (this.lock) {
            if (this.shutdown) {
                throw new IllegalStateException("Check failed.");
            }
            frameGraphCreateFrameGraphLocked = createFrameGraphLocked(frameGraphConfig, CameraGraphId.INSTANCE.nextId());
        }
        return frameGraphCreateFrameGraphLocked;
    }

    @Override // androidx.camera.camera2.pipe.CameraPipe
    public List<FrameGraph> createFrameGraphs(FrameGraph.ConcurrentConfig frameGraphConfigs) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(frameGraphConfigs, "frameGraphConfigs");
        synchronized (this.lock) {
            if (this.shutdown) {
                throw new IllegalStateException("Check failed.");
            }
            Map mapCreateMapBuilder = MapsKt.createMapBuilder();
            Iterator<FrameGraph.Config> it = frameGraphConfigs.getFrameGraphConfigs().iterator();
            while (it.hasNext()) {
                mapCreateMapBuilder.put(it.next(), CameraGraphId.INSTANCE.nextId());
            }
            Map mapBuild = MapsKt.build(mapCreateMapBuilder);
            List<FrameGraph.Config> frameGraphConfigs2 = frameGraphConfigs.getFrameGraphConfigs();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(frameGraphConfigs2, 10));
            Iterator<T> it2 = frameGraphConfigs2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(CameraId.m426boximpl(((FrameGraph.Config) it2.next()).getCameraGraphConfig().m385getCameraDz_R5H8()));
            }
            ConcurrentCameraGraphs concurrentCameraGraphs = new ConcurrentCameraGraphs(CollectionsKt.toSet(mapBuild.values()), CollectionsKt.toSet(arrayList2));
            List<FrameGraph.Config> frameGraphConfigs3 = frameGraphConfigs.getFrameGraphConfigs();
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(frameGraphConfigs3, 10));
            for (FrameGraph.Config config : frameGraphConfigs3) {
                config.getCameraGraphConfig().setConcurrentCameraGraphs$camera_camera2_pipe(concurrentCameraGraphs);
                Object obj = mapBuild.get(config);
                if (obj == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                arrayList3.add(createFrameGraphLocked(config, (CameraGraphId) obj));
            }
            arrayList = arrayList3;
        }
        return arrayList;
    }

    private final FrameGraph createFrameGraphLocked(FrameGraph.Config frameGraphConfig, CameraGraphId cameraGraphId) {
        Debug debug = Debug.INSTANCE;
        try {
            Trace.beginSection("CXCP#CreateFrameGraph-" + ((Object) CameraId.m432toStringimpl(frameGraphConfig.getCameraGraphConfig().m385getCameraDz_R5H8())));
            return this.component.frameGraphComponentBuilder().frameGraphConfigModule(new FrameGraphConfigModule(this.component.cameraGraphComponentBuilder().cameraGraphConfigModule(new CameraGraphConfigModule(frameGraphConfig.getCameraGraphConfig(), cameraGraphId)).build(), frameGraphConfig)).build().frameGraph();
        } finally {
            Trace.endSection();
        }
    }

    @Override // androidx.camera.camera2.pipe.CameraPipe
    public CameraDevices cameras() {
        CameraDevices cameraDevicesCameras;
        synchronized (this.lock) {
            if (this.shutdown) {
                throw new IllegalStateException("Check failed.");
            }
            cameraDevicesCameras = this.component.cameras();
        }
        return cameraDevicesCameras;
    }

    @Override // androidx.camera.camera2.pipe.CameraPipe
    public CameraSurfaceManager cameraSurfaceManager() {
        CameraSurfaceManager cameraSurfaceManager;
        synchronized (this.lock) {
            if (this.shutdown) {
                throw new IllegalStateException("Check failed.");
            }
            cameraSurfaceManager = this.component.cameraSurfaceManager();
        }
        return cameraSurfaceManager;
    }

    private final CameraBackend getBackend(CameraGraph.Config graphConfig) {
        CameraBackend cameraBackendMo242getSG3A4s8;
        synchronized (this.lock) {
            if (this.shutdown) {
                throw new IllegalStateException("Check failed.");
            }
            CameraBackendFactory customCameraBackend = graphConfig.getCustomCameraBackend();
            if (customCameraBackend != null) {
                cameraBackendMo242getSG3A4s8 = customCameraBackend.create(this.component.cameraContext());
            } else {
                String strM386getCameraBackendIdAKmI2lo = graphConfig.m386getCameraBackendIdAKmI2lo();
                CameraPipeComponent cameraPipeComponent = this.component;
                if (strM386getCameraBackendIdAKmI2lo != null) {
                    cameraBackendMo242getSG3A4s8 = cameraPipeComponent.cameraBackends().mo242getSG3A4s8(strM386getCameraBackendIdAKmI2lo);
                    if (cameraBackendMo242getSG3A4s8 == null) {
                        throw new IllegalStateException(("Failed to initialize " + ((Object) CameraBackendId.m240toStringimpl(strM386getCameraBackendIdAKmI2lo)) + " from " + graphConfig).toString());
                    }
                } else {
                    cameraBackendMo242getSG3A4s8 = cameraPipeComponent.cameraBackends().getDefault();
                }
            }
        }
        return cameraBackendMo242getSG3A4s8;
    }

    @Override // androidx.camera.camera2.pipe.CameraPipe
    /* JADX INFO: renamed from: isConfigSupported-NpXggIU */
    public Object mo451isConfigSupportedNpXggIU(CameraGraph.Config config, Continuation<? super ConfigQueryResult> continuation) {
        CameraBackend backend = getBackend(config);
        if (backend == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        return backend.mo227isConfigSupportedNpXggIU(config, continuation);
    }

    @Override // androidx.camera.camera2.pipe.CameraPipe
    public void prewarmIsConfigSupported(CameraGraph.Config graphConfig) {
        Intrinsics.checkNotNullParameter(graphConfig, "graphConfig");
        CameraBackend backend = getBackend(graphConfig);
        if (backend == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        backend.mo230prewarmIsConfigSupportedEfqyGwQ(graphConfig.m385getCameraDz_R5H8());
    }

    @Override // androidx.camera.camera2.pipe.CameraPipe
    /* JADX INFO: renamed from: getGlobalAudioRestrictionMode-_b5Q8KE */
    public int mo450getGlobalAudioRestrictionMode_b5Q8KE() {
        synchronized (this.lock) {
            if (!this.shutdown) {
                AudioRestrictionMode audioRestrictionModeMo818getGlobalAudioRestrictionMode4o0Og1A = this.component.cameraAudioRestrictionController().mo818getGlobalAudioRestrictionMode4o0Og1A();
                return audioRestrictionModeMo818getGlobalAudioRestrictionMode4o0Og1A != null ? audioRestrictionModeMo818getGlobalAudioRestrictionMode4o0Og1A.m193unboximpl() : AudioRestrictionMode.INSTANCE.m194getAUDIO_RESTRICTION_NONE_b5Q8KE();
            }
            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Trying to get audio restriction after shutdown! Returning NONE");
            }
            return AudioRestrictionMode.INSTANCE.m194getAUDIO_RESTRICTION_NONE_b5Q8KE();
        }
    }

    @Override // androidx.camera.camera2.pipe.CameraPipe
    /* JADX INFO: renamed from: setGlobalAudioRestrictionMode-LwUUkyU */
    public void mo452setGlobalAudioRestrictionModeLwUUkyU(int i) {
        synchronized (this.lock) {
            if (!this.shutdown) {
                this.component.cameraAudioRestrictionController().mo819setGlobalAudioRestrictionMode3NUV5dA(AudioRestrictionMode.m187boximpl(i));
                Unit unit = Unit.INSTANCE;
            } else {
                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                    android.util.Log.w(Log.TAG, "Trying to set audio restriction after shutdown!");
                }
            }
        }
    }

    @Override // androidx.camera.camera2.pipe.CameraPipe
    public void shutdown() {
        synchronized (this.lock) {
            if (this.shutdown) {
                throw new IllegalStateException("Check failed.");
            }
            this.component.cameraPipeLifetime().shutdown();
            this.shutdown = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    public String toString() {
        return "CameraPipe-" + this.debugId;
    }
}

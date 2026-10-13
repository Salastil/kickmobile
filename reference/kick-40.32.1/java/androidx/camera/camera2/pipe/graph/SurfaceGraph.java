package androidx.camera.camera2.pipe.graph;

import android.view.Surface;
import androidx.camera.camera2.pipe.CameraController;
import androidx.camera.camera2.pipe.CameraStream;
import androidx.camera.camera2.pipe.CameraSurfaceManager;
import androidx.camera.camera2.pipe.StreamId;
import androidx.camera.camera2.pipe.SurfaceTracker;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.media.ImageSource;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: SurfaceGraph.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B9\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0015H\u0086\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010 \u001a\u00020\u001bH\u0016J\b\u0010!\u001a\u00020\u001bH\u0016J\b\u0010\"\u001a\u00020\u001bH\u0016J\r\u0010#\u001a\u00020\u001bH\u0000¢\u0006\u0002\b$J\u0014\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00150\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R \u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0015\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00148\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00188\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Landroidx/camera/camera2/pipe/graph/SurfaceGraph;", "Landroidx/camera/camera2/pipe/SurfaceTracker;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "streamGraphImpl", "Landroidx/camera/camera2/pipe/graph/StreamGraphImpl;", "cameraController", "Ljavax/inject/Provider;", "Landroidx/camera/camera2/pipe/CameraController;", "surfaceManager", "Landroidx/camera/camera2/pipe/CameraSurfaceManager;", "imageSources", "", "Landroidx/camera/camera2/pipe/StreamId;", "Landroidx/camera/camera2/pipe/media/ImageSource;", "<init>", "(Landroidx/camera/camera2/pipe/graph/StreamGraphImpl;Ljavax/inject/Provider;Landroidx/camera/camera2/pipe/CameraSurfaceManager;Ljava/util/Map;)V", "lock", "", "surfaceMap", "", "Landroid/view/Surface;", "surfaceUsageMap", "shouldRegisterSurfaces", "", "closed", "set", "", "streamId", "surface", "set-NYG5g8E", "(ILandroid/view/Surface;)V", "unregisterAllSurfaces", "registerAllSurfaces", "close", "maybeUpdateSurfaces", "maybeUpdateSurfaces$camera_camera2_pipe", "buildSurfaceMap", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SurfaceGraph implements SurfaceTracker, AutoCloseable {
    private final Provider<CameraController> cameraController;
    private boolean closed;
    private final Map<StreamId, ImageSource> imageSources;
    private final Object lock;
    private boolean shouldRegisterSurfaces;
    private final StreamGraphImpl streamGraphImpl;
    private final CameraSurfaceManager surfaceManager;
    private final Map<StreamId, Surface> surfaceMap;
    private final Map<Surface, AutoCloseable> surfaceUsageMap;

    /* JADX WARN: Multi-variable type inference failed */
    public SurfaceGraph(StreamGraphImpl streamGraphImpl, Provider<CameraController> cameraController, CameraSurfaceManager surfaceManager, Map<StreamId, ? extends ImageSource> imageSources) {
        Intrinsics.checkNotNullParameter(streamGraphImpl, "streamGraphImpl");
        Intrinsics.checkNotNullParameter(cameraController, "cameraController");
        Intrinsics.checkNotNullParameter(surfaceManager, "surfaceManager");
        Intrinsics.checkNotNullParameter(imageSources, "imageSources");
        this.streamGraphImpl = streamGraphImpl;
        this.cameraController = cameraController;
        this.surfaceManager = surfaceManager;
        this.imageSources = imageSources;
        this.lock = new Object();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : imageSources.entrySet()) {
            linkedHashMap.put(entry.getKey(), ((ImageSource) entry.getValue()).getSurface());
        }
        this.surfaceMap = linkedHashMap;
        this.surfaceUsageMap = new LinkedHashMap();
        this.shouldRegisterSurfaces = true;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00fa  */
    /* JADX INFO: renamed from: set-NYG5g8E, reason: not valid java name */
    public final void m998setNYG5g8E(int streamId, Surface surface) {
        AutoCloseable autoCloseableRemove;
        String str;
        if (this.imageSources.keySet().contains(StreamId.m791boximpl(streamId))) {
            throw new IllegalStateException(("Cannot configure surface for " + ((Object) StreamId.m796toStringimpl(streamId)) + ", it is permanently assigned to " + this.imageSources.get(StreamId.m791boximpl(streamId))).toString());
        }
        synchronized (this.lock) {
            if (this.closed) {
                if (surface != null && Log.INSTANCE.getWARN_LOGGABLE()) {
                    android.util.Log.w(Log.TAG, "Refusing to configure " + ((Object) StreamId.m796toStringimpl(streamId)) + " with " + surface + " after close!");
                }
                return;
            }
            if (Log.INSTANCE.getINFO_LOGGABLE()) {
                if (surface != null) {
                    str = "Configured " + ((Object) StreamId.m796toStringimpl(streamId)) + " with " + surface;
                } else {
                    str = "Removed surface for " + ((Object) StreamId.m796toStringimpl(streamId));
                }
                android.util.Log.i(Log.TAG, str);
            }
            Map<StreamId, Surface> map = this.surfaceMap;
            if (surface == null) {
                Surface surfaceRemove = map.remove(StreamId.m791boximpl(streamId));
                if (!this.shouldRegisterSurfaces || surfaceRemove == null) {
                    autoCloseableRemove = null;
                } else {
                    autoCloseableRemove = this.surfaceUsageMap.remove(surfaceRemove);
                }
            } else {
                Surface surface2 = map.get(StreamId.m791boximpl(streamId));
                this.surfaceMap.put(StreamId.m791boximpl(streamId), surface);
                if (!this.shouldRegisterSurfaces || Intrinsics.areEqual(surface2, surface)) {
                    autoCloseableRemove = null;
                } else {
                    if (this.surfaceUsageMap.containsKey(surface)) {
                        throw new IllegalStateException(("Surface (" + surface + ") is already in use!").toString());
                    }
                    autoCloseableRemove = (AutoCloseable) TypeIntrinsics.asMutableMap(this.surfaceUsageMap).remove(surface2);
                    this.surfaceUsageMap.put(surface, this.surfaceManager.registerSurface$camera_camera2_pipe(surface));
                }
            }
            maybeUpdateSurfaces$camera_camera2_pipe();
            if (autoCloseableRemove != null) {
                UByte$$ExternalSyntheticBackport0.m12761m((Object) autoCloseableRemove);
            }
        }
    }

    @Override // androidx.camera.camera2.pipe.SurfaceTracker
    public void unregisterAllSurfaces() throws Exception {
        List list;
        synchronized (this.lock) {
            this.shouldRegisterSurfaces = false;
            list = CollectionsKt.toList(this.surfaceUsageMap.values());
            this.surfaceUsageMap.clear();
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            UByte$$ExternalSyntheticBackport0.m12761m(it.next());
        }
    }

    @Override // androidx.camera.camera2.pipe.SurfaceTracker
    public void registerAllSurfaces() {
        synchronized (this.lock) {
            if (this.closed) {
                throw new IllegalStateException("Check failed.");
            }
            for (Surface surface : this.surfaceMap.values()) {
                this.surfaceUsageMap.put(surface, this.surfaceManager.registerSurface$camera_camera2_pipe(surface));
            }
            this.shouldRegisterSurfaces = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            if (this.closed) {
                return;
            }
            this.closed = true;
            this.surfaceMap.clear();
            List list = CollectionsKt.toList(this.surfaceUsageMap.values());
            this.surfaceUsageMap.clear();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                UByte$$ExternalSyntheticBackport0.m12761m(it.next());
            }
        }
    }

    public final void maybeUpdateSurfaces$camera_camera2_pipe() {
        Map<StreamId, Surface> mapBuildSurfaceMap = buildSurfaceMap();
        if (mapBuildSurfaceMap.isEmpty()) {
            return;
        }
        this.cameraController.get().updateSurfaceMap(mapBuildSurfaceMap);
    }

    private final Map<StreamId, Surface> buildSurfaceMap() {
        synchronized (this.lock) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (StreamGraphImpl.OutputConfig outputConfig : this.streamGraphImpl.getOutputConfigs$camera_camera2_pipe()) {
                for (CameraStream cameraStream : outputConfig.getStreamBuilder$camera_camera2_pipe()) {
                    Surface surface = this.surfaceMap.get(StreamId.m791boximpl(cameraStream.getId()));
                    if (surface == null) {
                        if (!outputConfig.getDeferrable()) {
                            return MapsKt.emptyMap();
                        }
                    } else {
                        linkedHashMap.put(StreamId.m791boximpl(cameraStream.getId()), surface);
                    }
                }
            }
            return linkedHashMap;
        }
    }
}

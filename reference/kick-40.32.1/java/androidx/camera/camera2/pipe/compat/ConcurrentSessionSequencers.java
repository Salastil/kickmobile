package androidx.camera.camera2.pipe.compat;

import androidx.camera.camera2.pipe.CameraGraphId;
import androidx.camera.camera2.pipe.ConcurrentCameraGraphs;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConcurrentSessionSequencers.kt */
/* JADX INFO: loaded from: classes.dex */
@Singleton
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/camera/camera2/pipe/compat/ConcurrentSessionSequencers;", "", "<init>", "()V", "lock", "sequencers", "", "Landroidx/camera/camera2/pipe/ConcurrentCameraGraphs;", "Landroidx/camera/camera2/pipe/compat/ConcurrentSessionSequencer;", "pending", "", "Landroidx/camera/camera2/pipe/CameraGraphId;", "getSequencer", "cameraGraphId", "concurrentCameraGraphs", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConcurrentSessionSequencers {
    private final Object lock = new Object();
    private final Map<ConcurrentCameraGraphs, ConcurrentSessionSequencer> sequencers = new LinkedHashMap();
    private final Set<CameraGraphId> pending = new LinkedHashSet();

    @Inject
    public ConcurrentSessionSequencers() {
    }

    public final ConcurrentSessionSequencer getSequencer(CameraGraphId cameraGraphId, ConcurrentCameraGraphs concurrentCameraGraphs) {
        ConcurrentSessionSequencer concurrentSessionSequencer;
        Intrinsics.checkNotNullParameter(cameraGraphId, "cameraGraphId");
        Intrinsics.checkNotNullParameter(concurrentCameraGraphs, "concurrentCameraGraphs");
        synchronized (this.lock) {
            if (this.sequencers.containsKey(concurrentCameraGraphs)) {
                this.pending.remove(cameraGraphId);
                Set<CameraGraphId> cameraGraphIds = concurrentCameraGraphs.getCameraGraphIds();
                if (!(cameraGraphIds instanceof Collection) || !cameraGraphIds.isEmpty()) {
                    Iterator<T> it = cameraGraphIds.iterator();
                    while (it.hasNext()) {
                        if (this.pending.contains((CameraGraphId) it.next())) {
                            ConcurrentSessionSequencer concurrentSessionSequencer2 = this.sequencers.get(concurrentCameraGraphs);
                            if (concurrentSessionSequencer2 == null) {
                                throw new IllegalStateException("Required value was null.".toString());
                            }
                            concurrentSessionSequencer = concurrentSessionSequencer2;
                            return concurrentSessionSequencer;
                        }
                    }
                }
                ConcurrentSessionSequencer concurrentSessionSequencerRemove = this.sequencers.remove(concurrentCameraGraphs);
                if (concurrentSessionSequencerRemove == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                concurrentSessionSequencer = concurrentSessionSequencerRemove;
                return concurrentSessionSequencer;
            }
            ConcurrentSessionSequencer concurrentSessionSequencer3 = new ConcurrentSessionSequencer();
            this.sequencers.put(concurrentCameraGraphs, concurrentSessionSequencer3);
            this.pending.addAll(SetsKt.minus(concurrentCameraGraphs.getCameraGraphIds(), cameraGraphId));
            return concurrentSessionSequencer3;
        }
    }
}

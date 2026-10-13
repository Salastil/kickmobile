package androidx.camera.camera2.pipe;

import androidx.camera.camera2.pipe.graph.GraphListener;
import androidx.camera.featurecombinationquery.CameraDeviceSetupCompat;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: CameraBackend.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0096@¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH&J\u001c\u0010\u000e\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000f\u0018\u00010\u000fH\u0096@¢\u0006\u0002\u0010\fJ\u0016\u0010\u0010\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000f\u0018\u00010\u000fH&J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\tH\u0096@¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\tH&¢\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH&J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH&J8\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H&J\u0017\u0010+\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\tH&¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\tH&¢\u0006\u0004\b/\u0010-J\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u0013\u001a\u00020\tH&¢\u0006\u0004\b1\u00102J\b\u00103\u001a\u00020\u001bH&J\u0017\u00104\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\tH\u0016¢\u0006\u0004\b5\u0010-J\u001a\u00106\u001a\u0004\u0018\u0001072\u0006\u0010\u0013\u001a\u00020\tH\u0097@¢\u0006\u0004\b8\u0010\u0015J\u0018\u00109\u001a\u00020:2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0004\b;\u0010<R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R \u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006=À\u0006\u0003"}, d2 = {"Landroidx/camera/camera2/pipe/CameraBackend;", "", "id", "Landroidx/camera/camera2/pipe/CameraBackendId;", "getId-QwmhuAM", "()Ljava/lang/String;", "cameraIds", "Lkotlinx/coroutines/flow/Flow;", "", "Landroidx/camera/camera2/pipe/CameraId;", "getCameraIds", "()Lkotlinx/coroutines/flow/Flow;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitCameraIds", "getConcurrentCameraIds", "", "awaitConcurrentCameraIds", "getCameraMetadata", "Landroidx/camera/camera2/pipe/CameraMetadata;", "cameraId", "getCameraMetadata-0r8Bogc", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitCameraMetadata", "awaitCameraMetadata-EfqyGwQ", "(Ljava/lang/String;)Landroidx/camera/camera2/pipe/CameraMetadata;", "disconnectAllAsync", "Lkotlinx/coroutines/Deferred;", "", "shutdownAsync", "createCameraController", "Landroidx/camera/camera2/pipe/CameraController;", "cameraContext", "Landroidx/camera/camera2/pipe/CameraContext;", "graphId", "Landroidx/camera/camera2/pipe/CameraGraphId;", "graphConfig", "Landroidx/camera/camera2/pipe/CameraGraph$Config;", "graphListener", "Landroidx/camera/camera2/pipe/graph/GraphListener;", "streamGraph", "Landroidx/camera/camera2/pipe/StreamGraph;", "surfaceTracker", "Landroidx/camera/camera2/pipe/SurfaceTracker;", "prewarm", "prewarm-EfqyGwQ", "(Ljava/lang/String;)V", "disconnect", "disconnect-EfqyGwQ", "disconnectAsync", "disconnectAsync-EfqyGwQ", "(Ljava/lang/String;)Lkotlinx/coroutines/Deferred;", "disconnectAll", "prewarmIsConfigSupported", "prewarmIsConfigSupported-EfqyGwQ", "prewarmGraphConfigQuery", "Landroidx/camera/featurecombinationquery/CameraDeviceSetupCompat;", "prewarmGraphConfigQuery-0r8Bogc", "isConfigSupported", "Landroidx/camera/camera2/pipe/ConfigQueryResult;", "isConfigSupported-NpXggIU", "(Landroidx/camera/camera2/pipe/CameraGraph$Config;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CameraBackend {
    @Deprecated(message = "Use prewarmIsConfigSupported instead")
    /* JADX INFO: renamed from: prewarmGraphConfigQuery-0r8Bogc$suspendImpl, reason: not valid java name */
    static /* synthetic */ Object m221prewarmGraphConfigQuery0r8Bogc$suspendImpl(CameraBackend cameraBackend, String str, Continuation<? super CameraDeviceSetupCompat> continuation) {
        return null;
    }

    List<CameraId> awaitCameraIds();

    /* JADX INFO: renamed from: awaitCameraMetadata-EfqyGwQ, reason: not valid java name */
    CameraMetadata mo222awaitCameraMetadataEfqyGwQ(String cameraId);

    Set<Set<CameraId>> awaitConcurrentCameraIds();

    CameraController createCameraController(CameraContext cameraContext, CameraGraphId graphId, CameraGraph.Config graphConfig, GraphListener graphListener, StreamGraph streamGraph, SurfaceTracker surfaceTracker);

    /* JADX INFO: renamed from: disconnect-EfqyGwQ, reason: not valid java name */
    void mo223disconnectEfqyGwQ(String cameraId);

    void disconnectAll();

    Deferred<Unit> disconnectAllAsync();

    /* JADX INFO: renamed from: disconnectAsync-EfqyGwQ, reason: not valid java name */
    Deferred<Unit> mo224disconnectAsyncEfqyGwQ(String cameraId);

    default Object getCameraIds(Continuation<? super List<CameraId>> continuation) {
        return getCameraIds$suspendImpl(this, continuation);
    }

    /* JADX INFO: renamed from: getCameraMetadata-0r8Bogc, reason: not valid java name */
    default Object mo225getCameraMetadata0r8Bogc(String str, Continuation<? super CameraMetadata> continuation) {
        return m219getCameraMetadata0r8Bogc$suspendImpl(this, str, continuation);
    }

    default Object getConcurrentCameraIds(Continuation<? super Set<? extends Set<CameraId>>> continuation) {
        return getConcurrentCameraIds$suspendImpl(this, continuation);
    }

    /* JADX INFO: renamed from: getId-QwmhuAM, reason: not valid java name */
    String mo226getIdQwmhuAM();

    /* JADX INFO: renamed from: isConfigSupported-NpXggIU, reason: not valid java name */
    default Object mo227isConfigSupportedNpXggIU(CameraGraph.Config config, Continuation<? super ConfigQueryResult> continuation) {
        return m220isConfigSupportedNpXggIU$suspendImpl(this, config, continuation);
    }

    /* JADX INFO: renamed from: prewarm-EfqyGwQ, reason: not valid java name */
    void mo228prewarmEfqyGwQ(String cameraId);

    @Deprecated(message = "Use prewarmIsConfigSupported instead")
    /* JADX INFO: renamed from: prewarmGraphConfigQuery-0r8Bogc, reason: not valid java name */
    default Object m229prewarmGraphConfigQuery0r8Bogc(String str, Continuation<? super CameraDeviceSetupCompat> continuation) {
        return m221prewarmGraphConfigQuery0r8Bogc$suspendImpl(this, str, continuation);
    }

    /* JADX INFO: renamed from: prewarmIsConfigSupported-EfqyGwQ, reason: not valid java name */
    default void mo230prewarmIsConfigSupportedEfqyGwQ(String cameraId) {
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
    }

    Deferred<Unit> shutdownAsync();

    /* JADX INFO: compiled from: CameraBackend.kt */
    @kotlin.Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Flow<List<CameraId>> getCameraIds(CameraBackend cameraBackend) {
            return CameraBackend.super.getCameraIds();
        }

        @Deprecated
        public static Object getCameraIds(CameraBackend cameraBackend, Continuation<? super List<CameraId>> continuation) {
            return CameraBackend.super.getCameraIds(continuation);
        }

        @Deprecated
        public static Object getConcurrentCameraIds(CameraBackend cameraBackend, Continuation<? super Set<? extends Set<CameraId>>> continuation) {
            return CameraBackend.super.getConcurrentCameraIds(continuation);
        }

        @Deprecated
        /* JADX INFO: renamed from: getCameraMetadata-0r8Bogc, reason: not valid java name */
        public static Object m231getCameraMetadata0r8Bogc(CameraBackend cameraBackend, String str, Continuation<? super CameraMetadata> continuation) {
            return CameraBackend.super.mo225getCameraMetadata0r8Bogc(str, continuation);
        }

        @Deprecated
        /* JADX INFO: renamed from: prewarmIsConfigSupported-EfqyGwQ, reason: not valid java name */
        public static void m234prewarmIsConfigSupportedEfqyGwQ(CameraBackend cameraBackend, String cameraId) {
            Intrinsics.checkNotNullParameter(cameraId, "cameraId");
            CameraBackend.super.mo230prewarmIsConfigSupportedEfqyGwQ(cameraId);
        }

        @Deprecated(message = "Use prewarmIsConfigSupported instead")
        @Deprecated
        /* JADX INFO: renamed from: prewarmGraphConfigQuery-0r8Bogc, reason: not valid java name */
        public static Object m233prewarmGraphConfigQuery0r8Bogc(CameraBackend cameraBackend, String str, Continuation<? super CameraDeviceSetupCompat> continuation) {
            return CameraBackend.super.m229prewarmGraphConfigQuery0r8Bogc(str, continuation);
        }

        @Deprecated
        /* JADX INFO: renamed from: isConfigSupported-NpXggIU, reason: not valid java name */
        public static Object m232isConfigSupportedNpXggIU(CameraBackend cameraBackend, CameraGraph.Config config, Continuation<? super ConfigQueryResult> continuation) {
            return CameraBackend.super.mo227isConfigSupportedNpXggIU(config, continuation);
        }
    }

    default Flow<List<CameraId>> getCameraIds() {
        List<CameraId> listAwaitCameraIds = awaitCameraIds();
        if (listAwaitCameraIds == null) {
            listAwaitCameraIds = CollectionsKt.emptyList();
        }
        return FlowKt.flowOf(listAwaitCameraIds);
    }

    static /* synthetic */ Object getCameraIds$suspendImpl(CameraBackend cameraBackend, Continuation<? super List<CameraId>> continuation) {
        return cameraBackend.awaitCameraIds();
    }

    static /* synthetic */ Object getConcurrentCameraIds$suspendImpl(CameraBackend cameraBackend, Continuation<? super Set<? extends Set<CameraId>>> continuation) {
        return cameraBackend.awaitConcurrentCameraIds();
    }

    /* JADX INFO: renamed from: getCameraMetadata-0r8Bogc$suspendImpl, reason: not valid java name */
    static /* synthetic */ Object m219getCameraMetadata0r8Bogc$suspendImpl(CameraBackend cameraBackend, String str, Continuation<? super CameraMetadata> continuation) {
        return cameraBackend.mo222awaitCameraMetadataEfqyGwQ(str);
    }

    /* JADX INFO: renamed from: isConfigSupported-NpXggIU$suspendImpl, reason: not valid java name */
    static /* synthetic */ Object m220isConfigSupportedNpXggIU$suspendImpl(CameraBackend cameraBackend, CameraGraph.Config config, Continuation<? super ConfigQueryResult> continuation) {
        return ConfigQueryResult.m469boximpl(ConfigQueryResult.INSTANCE.m477getUNKNOWNXp6DSB4());
    }
}

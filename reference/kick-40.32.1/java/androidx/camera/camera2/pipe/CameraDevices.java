package androidx.camera.camera2.pipe;

import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: CameraDevices.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\bg\u0018\u00002\u00020\u0001J'\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\b\u0010\tJ$\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H¦@¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u000e\u0010\u000fJ*\u0010\u0010\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0011\u0018\u00010\u00112\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H¦@¢\u0006\u0004\b\u0012\u0010\fJ)\u0010\u0013\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0011\u0018\u00010\u00112\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u0014\u0010\u0015J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H¦@¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u001b\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b \u0010!J#\u0010\"\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b#\u0010!J)\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0%2\u0006\u0010\u0018\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b&\u0010'J\u001b\u0010(\u001a\u00020\u001f2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b)\u0010*J!\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001f0%2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b,\u0010-J\u000e\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H'J\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H§@¢\u0006\u0002\u00100J\u0018\u00101\u001a\u00020\u00172\u0006\u00102\u001a\u00020\u0005H§@¢\u0006\u0004\b3\u0010\fJ\u0017\u00104\u001a\u00020\u00172\u0006\u00102\u001a\u00020\u0005H'¢\u0006\u0004\b5\u00106ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00067À\u0006\u0003"}, d2 = {"Landroidx/camera/camera2/pipe/CameraDevices;", "", "cameraIdsFlow", "Lkotlinx/coroutines/flow/Flow;", "", "Landroidx/camera/camera2/pipe/CameraId;", "cameraBackendId", "Landroidx/camera/camera2/pipe/CameraBackendId;", "cameraIdsFlow-SeavPBo", "(Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "getCameraIds", "getCameraIds-iAq86To", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitCameraIds", "awaitCameraIds-SeavPBo", "(Ljava/lang/String;)Ljava/util/List;", "getConcurrentCameraIds", "", "getConcurrentCameraIds-iAq86To", "awaitConcurrentCameraIds", "awaitConcurrentCameraIds-SeavPBo", "(Ljava/lang/String;)Ljava/util/Set;", "getCameraMetadata", "Landroidx/camera/camera2/pipe/CameraMetadata;", "cameraId", "getCameraMetadata-_mltaTw", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitCameraMetadata", "awaitCameraMetadata-FpsL5FU", "(Ljava/lang/String;Ljava/lang/String;)Landroidx/camera/camera2/pipe/CameraMetadata;", "prewarm", "", "prewarm-FpsL5FU", "(Ljava/lang/String;Ljava/lang/String;)V", "disconnect", "disconnect-FpsL5FU", "disconnectAsync", "Lkotlinx/coroutines/Deferred;", "disconnectAsync-FpsL5FU", "(Ljava/lang/String;Ljava/lang/String;)Lkotlinx/coroutines/Deferred;", "disconnectAll", "disconnectAll-SeavPBo", "(Ljava/lang/String;)V", "disconnectAllAsync", "disconnectAllAsync-SeavPBo", "(Ljava/lang/String;)Lkotlinx/coroutines/Deferred;", "findAll", "ids", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMetadata", "camera", "getMetadata-0r8Bogc", "awaitMetadata", "awaitMetadata-EfqyGwQ", "(Ljava/lang/String;)Landroidx/camera/camera2/pipe/CameraMetadata;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CameraDevices {
    /* JADX INFO: renamed from: awaitCameraIds-SeavPBo, reason: not valid java name */
    List<CameraId> mo323awaitCameraIdsSeavPBo(String cameraBackendId);

    /* JADX INFO: renamed from: awaitCameraMetadata-FpsL5FU, reason: not valid java name */
    CameraMetadata mo324awaitCameraMetadataFpsL5FU(String cameraId, String cameraBackendId);

    /* JADX INFO: renamed from: awaitConcurrentCameraIds-SeavPBo, reason: not valid java name */
    Set<Set<CameraId>> mo325awaitConcurrentCameraIdsSeavPBo(String cameraBackendId);

    @Deprecated(level = DeprecationLevel.WARNING, message = "awaitMetadata() is not able to specify a specific CameraBackendId to query.", replaceWith = @ReplaceWith(expression = "awaitCameraMetadata", imports = {}))
    /* JADX INFO: renamed from: awaitMetadata-EfqyGwQ, reason: not valid java name */
    CameraMetadata mo326awaitMetadataEfqyGwQ(String camera);

    /* JADX INFO: renamed from: cameraIdsFlow-SeavPBo, reason: not valid java name */
    Flow<List<CameraId>> mo327cameraIdsFlowSeavPBo(String cameraBackendId);

    /* JADX INFO: renamed from: disconnect-FpsL5FU, reason: not valid java name */
    void mo328disconnectFpsL5FU(String cameraId, String cameraBackendId);

    /* JADX INFO: renamed from: disconnectAll-SeavPBo, reason: not valid java name */
    void mo329disconnectAllSeavPBo(String cameraBackendId);

    /* JADX INFO: renamed from: disconnectAllAsync-SeavPBo, reason: not valid java name */
    Deferred<Unit> mo330disconnectAllAsyncSeavPBo(String cameraBackendId);

    /* JADX INFO: renamed from: disconnectAsync-FpsL5FU, reason: not valid java name */
    Deferred<Unit> mo331disconnectAsyncFpsL5FU(String cameraId, String cameraBackendId);

    @Deprecated(level = DeprecationLevel.WARNING, message = "findAll() is not able to specify a specific CameraBackendId to query.", replaceWith = @ReplaceWith(expression = "awaitCameraIds", imports = {}))
    List<CameraId> findAll();

    /* JADX INFO: renamed from: getCameraIds-iAq86To, reason: not valid java name */
    Object mo332getCameraIdsiAq86To(String str, Continuation<? super List<CameraId>> continuation);

    /* JADX INFO: renamed from: getCameraMetadata-_mltaTw, reason: not valid java name */
    Object mo333getCameraMetadata_mltaTw(String str, String str2, Continuation<? super CameraMetadata> continuation);

    /* JADX INFO: renamed from: getConcurrentCameraIds-iAq86To, reason: not valid java name */
    Object mo334getConcurrentCameraIdsiAq86To(String str, Continuation<? super Set<? extends Set<CameraId>>> continuation);

    @Deprecated(level = DeprecationLevel.WARNING, message = "getMetadata() is not able to specify a specific CameraBackendId to query.", replaceWith = @ReplaceWith(expression = "getCameraMetadata", imports = {}))
    /* JADX INFO: renamed from: getMetadata-0r8Bogc, reason: not valid java name */
    Object mo335getMetadata0r8Bogc(String str, Continuation<? super CameraMetadata> continuation);

    @Deprecated(level = DeprecationLevel.WARNING, message = "ids() is not able to specify a specific CameraBackendId to query.", replaceWith = @ReplaceWith(expression = "getCameraIds", imports = {}))
    Object ids(Continuation<? super List<CameraId>> continuation);

    /* JADX INFO: renamed from: prewarm-FpsL5FU, reason: not valid java name */
    void mo336prewarmFpsL5FU(String cameraId, String cameraBackendId);

    /* JADX INFO: compiled from: CameraDevices.kt */
    @kotlin.Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    /* JADX INFO: renamed from: cameraIdsFlow-SeavPBo$default, reason: not valid java name */
    static /* synthetic */ Flow m314cameraIdsFlowSeavPBo$default(CameraDevices cameraDevices, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cameraIdsFlow-SeavPBo");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        return cameraDevices.mo327cameraIdsFlowSeavPBo(str);
    }

    /* JADX INFO: renamed from: getCameraIds-iAq86To$default, reason: not valid java name */
    static /* synthetic */ Object m319getCameraIdsiAq86To$default(CameraDevices cameraDevices, String str, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCameraIds-iAq86To");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        return cameraDevices.mo332getCameraIdsiAq86To(str, continuation);
    }

    /* JADX INFO: renamed from: awaitCameraIds-SeavPBo$default, reason: not valid java name */
    static /* synthetic */ List m311awaitCameraIdsSeavPBo$default(CameraDevices cameraDevices, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: awaitCameraIds-SeavPBo");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        return cameraDevices.mo323awaitCameraIdsSeavPBo(str);
    }

    /* JADX INFO: renamed from: getConcurrentCameraIds-iAq86To$default, reason: not valid java name */
    static /* synthetic */ Object m321getConcurrentCameraIdsiAq86To$default(CameraDevices cameraDevices, String str, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getConcurrentCameraIds-iAq86To");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        return cameraDevices.mo334getConcurrentCameraIdsiAq86To(str, continuation);
    }

    /* JADX INFO: renamed from: awaitConcurrentCameraIds-SeavPBo$default, reason: not valid java name */
    static /* synthetic */ Set m313awaitConcurrentCameraIdsSeavPBo$default(CameraDevices cameraDevices, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: awaitConcurrentCameraIds-SeavPBo");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        return cameraDevices.mo325awaitConcurrentCameraIdsSeavPBo(str);
    }

    /* JADX INFO: renamed from: getCameraMetadata-_mltaTw$default, reason: not valid java name */
    static /* synthetic */ Object m320getCameraMetadata_mltaTw$default(CameraDevices cameraDevices, String str, String str2, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCameraMetadata-_mltaTw");
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        return cameraDevices.mo333getCameraMetadata_mltaTw(str, str2, continuation);
    }

    /* JADX INFO: renamed from: awaitCameraMetadata-FpsL5FU$default, reason: not valid java name */
    static /* synthetic */ CameraMetadata m312awaitCameraMetadataFpsL5FU$default(CameraDevices cameraDevices, String str, String str2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: awaitCameraMetadata-FpsL5FU");
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        return cameraDevices.mo324awaitCameraMetadataFpsL5FU(str, str2);
    }

    /* JADX INFO: renamed from: prewarm-FpsL5FU$default, reason: not valid java name */
    static /* synthetic */ void m322prewarmFpsL5FU$default(CameraDevices cameraDevices, String str, String str2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: prewarm-FpsL5FU");
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        cameraDevices.mo336prewarmFpsL5FU(str, str2);
    }

    /* JADX INFO: renamed from: disconnect-FpsL5FU$default, reason: not valid java name */
    static /* synthetic */ void m315disconnectFpsL5FU$default(CameraDevices cameraDevices, String str, String str2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: disconnect-FpsL5FU");
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        cameraDevices.mo328disconnectFpsL5FU(str, str2);
    }

    /* JADX INFO: renamed from: disconnectAsync-FpsL5FU$default, reason: not valid java name */
    static /* synthetic */ Deferred m318disconnectAsyncFpsL5FU$default(CameraDevices cameraDevices, String str, String str2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: disconnectAsync-FpsL5FU");
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        return cameraDevices.mo331disconnectAsyncFpsL5FU(str, str2);
    }

    /* JADX INFO: renamed from: disconnectAll-SeavPBo$default, reason: not valid java name */
    static /* synthetic */ void m316disconnectAllSeavPBo$default(CameraDevices cameraDevices, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: disconnectAll-SeavPBo");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        cameraDevices.mo329disconnectAllSeavPBo(str);
    }

    /* JADX INFO: renamed from: disconnectAllAsync-SeavPBo$default, reason: not valid java name */
    static /* synthetic */ Deferred m317disconnectAllAsyncSeavPBo$default(CameraDevices cameraDevices, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: disconnectAllAsync-SeavPBo");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        return cameraDevices.mo330disconnectAllAsyncSeavPBo(str);
    }
}

package androidx.camera.camera2.adapter;

import android.content.Context;
import android.os.Trace;
import androidx.camera.camera2.config.CameraAppComponent;
import androidx.camera.camera2.config.CameraAppConfig;
import androidx.camera.camera2.config.CameraConfig;
import androidx.camera.camera2.config.DaggerCameraAppComponent;
import androidx.camera.camera2.impl.Camera2Logger;
import androidx.camera.camera2.impl.CameraInteropStateCallbackRepository;
import androidx.camera.camera2.internal.CameraCompatibilityFilter;
import androidx.camera.camera2.internal.CameraSelectionOptimizer;
import androidx.camera.camera2.pipe.CameraDevices;
import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.CameraPipe;
import androidx.camera.camera2.pipe.core.Debug;
import androidx.camera.camera2.pipe.core.DurationNs;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.core.SystemTimeSource;
import androidx.camera.camera2.pipe.core.Timestamps;
import androidx.camera.core.CameraIdentifier;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.Logger;
import androidx.camera.core.concurrent.CameraCoordinator;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraThreadConfig;
import androidx.camera.core.impl.CameraUpdateException;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.internal.StreamSpecsCalculator;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: CameraFactoryAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002BG\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020 0(H\u0016J\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020 0(2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020 0(H\u0016J\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020 0(H\u0002J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020 H\u0016J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016J\b\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020\"H\u0016J\u0014\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030(02H\u0016J\b\u00104\u001a\u00020&H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Landroidx/camera/camera2/adapter/CameraFactoryAdapter;", "Landroidx/camera/core/impl/CameraFactory;", "Landroidx/camera/core/impl/CameraFactory$Interrogator;", "lazyCameraPipe", "Lkotlin/Lazy;", "Landroidx/camera/camera2/pipe/CameraPipe;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "threadConfig", "Landroidx/camera/core/impl/CameraThreadConfig;", "camera2InteropCallbacks", "Landroidx/camera/camera2/impl/CameraInteropStateCallbackRepository;", "availableCamerasSelector", "Landroidx/camera/core/CameraSelector;", "streamSpecsCalculator", "Landroidx/camera/core/internal/StreamSpecsCalculator;", "cameraXConfig", "Landroidx/camera/core/CameraXConfig;", "<init>", "(Lkotlin/Lazy;Landroid/content/Context;Landroidx/camera/core/impl/CameraThreadConfig;Landroidx/camera/camera2/impl/CameraInteropStateCallbackRepository;Landroidx/camera/core/CameraSelector;Landroidx/camera/core/internal/StreamSpecsCalculator;Landroidx/camera/core/CameraXConfig;)V", "cameraCoordinator", "Landroidx/camera/camera2/adapter/CameraCoordinatorAdapter;", "pipeCameraPresenceObservable", "Landroidx/camera/camera2/adapter/PipeCameraPresenceSource;", "appComponent", "Landroidx/camera/camera2/config/CameraAppComponent;", "getAppComponent", "()Landroidx/camera/camera2/config/CameraAppComponent;", "appComponent$delegate", "Lkotlin/Lazy;", "availableCameraIds", "", "", "lock", "", "isShutdown", "Ljava/util/concurrent/atomic/AtomicBoolean;", "onCameraIdsUpdated", "", "cameraIds", "", "getAvailableCameraIds", "calculateAvailableCameraIds", "getCamera", "Landroidx/camera/core/impl/CameraInternal;", "cameraId", "getCameraCoordinator", "Landroidx/camera/core/concurrent/CameraCoordinator;", "getCameraManager", "getCameraPresenceSource", "Landroidx/camera/core/impl/Observable;", "Landroidx/camera/core/CameraIdentifier;", "shutdown", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraFactoryAdapter implements CameraFactory, CameraFactory.Interrogator {

    /* JADX INFO: renamed from: appComponent$delegate, reason: from kotlin metadata */
    private final Lazy appComponent;
    private Set<String> availableCameraIds;
    private final CameraSelector availableCamerasSelector;
    private final CameraCoordinatorAdapter cameraCoordinator;
    private final CameraXConfig cameraXConfig;
    private final AtomicBoolean isShutdown;
    private final Lazy<CameraPipe> lazyCameraPipe;
    private final Object lock;
    private final PipeCameraPresenceSource pipeCameraPresenceObservable;
    private final StreamSpecsCalculator streamSpecsCalculator;

    /* JADX WARN: Multi-variable type inference failed */
    public CameraFactoryAdapter(Lazy<? extends CameraPipe> lazyCameraPipe, final Context context, final CameraThreadConfig threadConfig, final CameraInteropStateCallbackRepository camera2InteropCallbacks, CameraSelector cameraSelector, StreamSpecsCalculator streamSpecsCalculator, CameraXConfig cameraXConfig) {
        ArrayList arrayListEmptyList;
        Intrinsics.checkNotNullParameter(lazyCameraPipe, "lazyCameraPipe");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(threadConfig, "threadConfig");
        Intrinsics.checkNotNullParameter(camera2InteropCallbacks, "camera2InteropCallbacks");
        Intrinsics.checkNotNullParameter(streamSpecsCalculator, "streamSpecsCalculator");
        Intrinsics.checkNotNullParameter(cameraXConfig, "cameraXConfig");
        this.lazyCameraPipe = lazyCameraPipe;
        this.availableCamerasSelector = cameraSelector;
        this.streamSpecsCalculator = streamSpecsCalculator;
        this.cameraXConfig = cameraXConfig;
        this.cameraCoordinator = new CameraCoordinatorAdapter((CameraPipe) lazyCameraPipe.getValue(), ((CameraPipe) lazyCameraPipe.getValue()).cameras());
        this.appComponent = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.adapter.CameraFactoryAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CameraFactoryAdapter.appComponent_delegate$lambda$0(context, threadConfig, this, camera2InteropCallbacks);
            }
        });
        this.availableCameraIds = SetsKt.emptySet();
        this.lock = new Object();
        this.isShutdown = new AtomicBoolean(false);
        List listM311awaitCameraIdsSeavPBo$default = CameraDevices.m311awaitCameraIdsSeavPBo$default(getAppComponent().getCameraDevices(), null, 1, null);
        if (listM311awaitCameraIdsSeavPBo$default == null) {
            arrayListEmptyList = CollectionsKt.emptyList();
        } else {
            List list = listM311awaitCameraIdsSeavPBo$default;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((CameraId) it.next()).m433unboximpl());
            }
            arrayListEmptyList = arrayList;
        }
        Flow flowM314cameraIdsFlowSeavPBo$default = CameraDevices.m314cameraIdsFlowSeavPBo$default(this.lazyCameraPipe.getValue().cameras(), null, 1, null);
        Executor cameraExecutor = threadConfig.getCameraExecutor();
        Intrinsics.checkNotNullExpressionValue(cameraExecutor, "getCameraExecutor(...)");
        this.pipeCameraPresenceObservable = new PipeCameraPresenceSource(flowM314cameraIdsFlowSeavPBo$default, CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(cameraExecutor)), arrayListEmptyList, context);
        onCameraIdsUpdated(arrayListEmptyList);
    }

    private final CameraAppComponent getAppComponent() {
        return (CameraAppComponent) this.appComponent.getValue();
    }

    static final CameraAppComponent appComponent_delegate$lambda$0(Context context, CameraThreadConfig cameraThreadConfig, CameraFactoryAdapter cameraFactoryAdapter, CameraInteropStateCallbackRepository cameraInteropStateCallbackRepository) {
        Debug debug = Debug.INSTANCE;
        Trace.beginSection("CameraFactoryAdapter#appComponent");
        SystemTimeSource systemTimeSource = new SystemTimeSource();
        Timestamps timestamps = Timestamps.INSTANCE;
        SystemTimeSource systemTimeSource2 = systemTimeSource;
        long jMo927nowvQl9yQU = systemTimeSource2.mo927nowvQl9yQU();
        CameraAppComponent cameraAppComponentBuild = DaggerCameraAppComponent.builder().config(new CameraAppConfig(context, cameraThreadConfig, cameraFactoryAdapter.lazyCameraPipe.getValue(), cameraInteropStateCallbackRepository, cameraFactoryAdapter.cameraCoordinator, cameraFactoryAdapter.cameraXConfig)).build();
        Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            String str = Camera2Logger.TRUNCATED_TAG;
            StringBuilder sb = new StringBuilder("Created CameraFactoryAdapter in ");
            Timestamps timestamps2 = Timestamps.INSTANCE;
            Timestamps timestamps3 = Timestamps.INSTANCE;
            String str2 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(DurationNs.m917constructorimpl(systemTimeSource2.mo927nowvQl9yQU() - jMo927nowvQl9yQU) / 1000000.0d)}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            sb.append(str2);
            android.util.Log.d(str, sb.toString());
        }
        Debug debug2 = Debug.INSTANCE;
        Trace.endSection();
        return cameraAppComponentBuild;
    }

    @Override // androidx.camera.core.impl.CameraPresenceMonitor
    public void onCameraIdsUpdated(List<String> cameraIds) {
        Intrinsics.checkNotNullParameter(cameraIds, "cameraIds");
        if (this.isShutdown.get()) {
            return;
        }
        Set<String> setCalculateAvailableCameraIds = calculateAvailableCameraIds(cameraIds);
        synchronized (this.lock) {
            if (this.isShutdown.get()) {
                return;
            }
            if (Intrinsics.areEqual(this.availableCameraIds, setCalculateAvailableCameraIds)) {
                return;
            }
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "Updated available camera list: " + this.availableCameraIds + " -> " + setCalculateAvailableCameraIds);
            }
            this.availableCameraIds = setCalculateAvailableCameraIds;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.camera.core.impl.CameraFactory.Interrogator
    public List<String> getAvailableCameraIds(List<String> cameraIds) {
        Intrinsics.checkNotNullParameter(cameraIds, "cameraIds");
        if (this.isShutdown.get()) {
            return CollectionsKt.emptyList();
        }
        return CollectionsKt.toList(calculateAvailableCameraIds(cameraIds));
    }

    private final Set<String> calculateAvailableCameraIds(List<String> cameraIds) {
        return new LinkedHashSet(CameraCompatibilityFilter.getBackwardCompatibleCameraIds(getAppComponent().getCameraDevices(), CameraSelectionOptimizer.INSTANCE.getSelectedAvailableCameraIds(getAppComponent(), this.availableCamerasSelector, CollectionsKt.toList(cameraIds), this.streamSpecsCalculator)));
    }

    @Override // androidx.camera.core.impl.CameraFactory
    public CameraInternal getCamera(String cameraId) throws CameraUpdateException {
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        if (this.isShutdown.get()) {
            throw new CameraUpdateException("CameraFactory has been shut down.");
        }
        return getAppComponent().cameraBuilder().config(new CameraConfig(CameraId.m427constructorimpl(cameraId), null)).streamSpecsCalculator(this.streamSpecsCalculator).build().getCameraInternal();
    }

    @Override // androidx.camera.core.impl.CameraFactory
    public Set<String> getAvailableCameraIds() {
        synchronized (this.lock) {
            if (this.isShutdown.get()) {
                return SetsKt.emptySet();
            }
            return new LinkedHashSet(this.availableCameraIds);
        }
    }

    @Override // androidx.camera.core.impl.CameraFactory
    public CameraCoordinator getCameraCoordinator() {
        return this.cameraCoordinator;
    }

    @Override // androidx.camera.core.impl.CameraFactory
    public Object getCameraManager() {
        return getAppComponent();
    }

    @Override // androidx.camera.core.impl.CameraFactory
    public Observable<List<CameraIdentifier>> getCameraPresenceSource() {
        return this.pipeCameraPresenceObservable;
    }

    @Override // androidx.camera.core.impl.CameraFactory
    public void shutdown() {
        if (this.isShutdown.getAndSet(true)) {
            return;
        }
        this.cameraCoordinator.shutdown();
        this.pipeCameraPresenceObservable.stopMonitoring();
        if (this.lazyCameraPipe.isInitialized()) {
            this.lazyCameraPipe.getValue().shutdown();
        }
    }
}

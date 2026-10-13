package androidx.camera.camera2.pipe.compat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Trace;
import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.config.CameraPipeContext;
import androidx.camera.camera2.pipe.config.CameraPipeJob;
import androidx.camera.camera2.pipe.core.Debug;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.internal.CameraErrorListener;
import androidx.camera.camera2.pipe.internal.CameraPipeLifetime;
import androidx.camera.featurecombinationquery.CameraDeviceSetupCompat;
import androidx.camera.featurecombinationquery.CameraDeviceSetupCompatFactory;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.interfaces.permissions.PermissionsResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: Camera2DeviceCache.kt */
/* JADX INFO: loaded from: classes.dex */
@Singleton
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0001\u0018\u00002\u00020\u0001BY\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010/\u001a\u0004\u0018\u00010 2\u0006\u00100\u001a\u00020\u001aH\u0086@¢\u0006\u0004\b1\u00102J\u001a\u00103\u001a\u0004\u0018\u00010\"2\u0006\u00100\u001a\u00020\u001aH\u0087@¢\u0006\u0004\b4\u00102J\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0086@¢\u0006\u0002\u00105J\u000e\u00106\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019J\u0014\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190&H\u0002J(\u00108\u001a\u000209*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190:2\u0006\u00100\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0002J0\u0010>\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0002J&\u0010A\u001a\u000209*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190:2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u0010\u0010B\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0002J\u0010\u0010C\u001a\u00020$2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0016\u0010D\u001a\u00020=2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u001a\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u001c0\u001cH\u0086@¢\u0006\u0002\u00105J\u0014\u0010F\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u001c\u0018\u00010\u001cJ\u0006\u0010G\u001a\u000209R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R \u0010\u001b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u001c\u0018\u00010\u001c8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R$\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u001f0\u001e8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R$\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\"0\u001f0\u001e8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R#\u0010)\u001a\n **\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b+\u0010,¨\u0006H"}, d2 = {"Landroidx/camera/camera2/pipe/compat/Camera2DeviceCache;", "", "cameraManager", "Ljavax/inject/Provider;", "Landroid/hardware/camera2/CameraManager;", "threads", "Landroidx/camera/camera2/pipe/core/Threads;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "packageManager", "Landroid/content/pm/PackageManager;", "cameraErrorListener", "Landroidx/camera/camera2/pipe/internal/CameraErrorListener;", "cameraDeviceSetupCompatFactoryProvider", "Landroidx/camera/featurecombinationquery/CameraDeviceSetupCompatFactory;", "cameraPipeLifetime", "Landroidx/camera/camera2/pipe/internal/CameraPipeLifetime;", "cameraPipeJob", "Lkotlinx/coroutines/Job;", "<init>", "(Ljavax/inject/Provider;Landroidx/camera/camera2/pipe/core/Threads;Landroid/content/Context;Landroid/content/pm/PackageManager;Landroidx/camera/camera2/pipe/internal/CameraErrorListener;Ljavax/inject/Provider;Landroidx/camera/camera2/pipe/internal/CameraPipeLifetime;Lkotlinx/coroutines/Job;)V", PermissionsResponse.SCOPE_KEY, "Lkotlinx/coroutines/CoroutineScope;", "lock", "openableCameras", "", "Landroidx/camera/camera2/pipe/CameraId;", "concurrentCameras", "", "cameraDeviceSetupCache", "", "Lkotlinx/coroutines/Deferred;", "Landroidx/camera/featurecombinationquery/CameraDeviceSetupCompat;", "camera2DeviceSetupWrapperCache", "Landroidx/camera/camera2/pipe/compat/Camera2DeviceSetupWrapper;", "minimumCameraCount", "", "cameraIds", "Lkotlinx/coroutines/flow/Flow;", "getCameraIds", "()Lkotlinx/coroutines/flow/Flow;", "cameraDeviceSetupCompatFactory", "kotlin.jvm.PlatformType", "getCameraDeviceSetupCompatFactory", "()Landroidx/camera/featurecombinationquery/CameraDeviceSetupCompatFactory;", "cameraDeviceSetupCompatFactory$delegate", "Lkotlin/Lazy;", "getOrInitializeDeviceSetupCompat", "cameraId", "getOrInitializeDeviceSetupCompat-0r8Bogc", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOrInitializeDeviceSetupWrapper", "getOrInitializeDeviceSetupWrapper-0r8Bogc", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitCameraIds", "createCameraIdListFlow", "onCameraAvailabilityChanged", "", "Lkotlinx/coroutines/channels/ProducerScope;", "", "isAvailable", "", "getUpdatedCameraIds", "cachedCameraIds", "cameraIdsRead", "sendCameraIdList", "readCameraIds", "estimateMinInternalCameraCount", "isValidCameraIds", "getConcurrentCameraIds", "awaitConcurrentCameraIds", "shutdown", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Camera2DeviceCache {
    private final Map<CameraId, Deferred<Camera2DeviceSetupWrapper>> camera2DeviceSetupWrapperCache;
    private final Map<CameraId, Deferred<CameraDeviceSetupCompat>> cameraDeviceSetupCache;

    /* JADX INFO: renamed from: cameraDeviceSetupCompatFactory$delegate, reason: from kotlin metadata */
    private final Lazy cameraDeviceSetupCompatFactory;
    private final Provider<CameraDeviceSetupCompatFactory> cameraDeviceSetupCompatFactoryProvider;
    private final CameraErrorListener cameraErrorListener;
    private final Flow<List<CameraId>> cameraIds;
    private final Provider<CameraManager> cameraManager;
    private Set<? extends Set<CameraId>> concurrentCameras;
    private final Context context;
    private final Object lock;
    private final int minimumCameraCount;
    private List<CameraId> openableCameras;
    private final CoroutineScope scope;
    private final Threads threads;

    @Inject
    public Camera2DeviceCache(Provider<CameraManager> cameraManager, Threads threads, @CameraPipeContext Context context, PackageManager packageManager, CameraErrorListener cameraErrorListener, Provider<CameraDeviceSetupCompatFactory> cameraDeviceSetupCompatFactoryProvider, CameraPipeLifetime cameraPipeLifetime, @CameraPipeJob Job cameraPipeJob) {
        Intrinsics.checkNotNullParameter(cameraManager, "cameraManager");
        Intrinsics.checkNotNullParameter(threads, "threads");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(packageManager, "packageManager");
        Intrinsics.checkNotNullParameter(cameraErrorListener, "cameraErrorListener");
        Intrinsics.checkNotNullParameter(cameraDeviceSetupCompatFactoryProvider, "cameraDeviceSetupCompatFactoryProvider");
        Intrinsics.checkNotNullParameter(cameraPipeLifetime, "cameraPipeLifetime");
        Intrinsics.checkNotNullParameter(cameraPipeJob, "cameraPipeJob");
        this.cameraManager = cameraManager;
        this.threads = threads;
        this.context = context;
        this.cameraErrorListener = cameraErrorListener;
        this.cameraDeviceSetupCompatFactoryProvider = cameraDeviceSetupCompatFactoryProvider;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob(cameraPipeJob).plus(threads.getLightweightDispatcher()).plus(new CoroutineName("Camera2DeviceCache")));
        this.scope = CoroutineScope;
        this.lock = new Object();
        this.cameraDeviceSetupCache = new LinkedHashMap();
        this.camera2DeviceSetupWrapperCache = new LinkedHashMap();
        this.minimumCameraCount = estimateMinInternalCameraCount(packageManager);
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            android.util.Log.d(Log.TAG, "Camera2DeviceCache: Expected minimum camera count = " + this.minimumCameraCount);
        }
        cameraPipeLifetime.addShutdownAction(CameraPipeLifetime.ShutdownType.SCOPE, new Runnable() { // from class: androidx.camera.camera2.pipe.compat.Camera2DeviceCache$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                CoroutineScopeKt.cancel$default(this.f$0.scope, null, 1, null);
            }
        });
        this.cameraIds = FlowKt.shareIn(FlowKt.distinctUntilChanged(createCameraIdListFlow()), CoroutineScope, SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 0L, 0L, 3, null), 1);
        this.cameraDeviceSetupCompatFactory = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.pipe.compat.Camera2DeviceCache$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.cameraDeviceSetupCompatFactoryProvider.get();
            }
        });
    }

    public final Flow<List<CameraId>> getCameraIds() {
        return this.cameraIds;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CameraDeviceSetupCompatFactory getCameraDeviceSetupCompatFactory() {
        return (CameraDeviceSetupCompatFactory) this.cameraDeviceSetupCompatFactory.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getOrInitializeDeviceSetupCompat-0r8Bogc, reason: not valid java name */
    public final Object m832getOrInitializeDeviceSetupCompat0r8Bogc(String str, Continuation<? super CameraDeviceSetupCompat> continuation) {
        Camera2DeviceCache$getOrInitializeDeviceSetupCompat$1 camera2DeviceCache$getOrInitializeDeviceSetupCompat$1;
        Deferred<CameraDeviceSetupCompat> deferred;
        if (continuation instanceof Camera2DeviceCache$getOrInitializeDeviceSetupCompat$1) {
            camera2DeviceCache$getOrInitializeDeviceSetupCompat$1 = (Camera2DeviceCache$getOrInitializeDeviceSetupCompat$1) continuation;
            if ((camera2DeviceCache$getOrInitializeDeviceSetupCompat$1.label & Integer.MIN_VALUE) != 0) {
                camera2DeviceCache$getOrInitializeDeviceSetupCompat$1.label -= Integer.MIN_VALUE;
            } else {
                camera2DeviceCache$getOrInitializeDeviceSetupCompat$1 = new Camera2DeviceCache$getOrInitializeDeviceSetupCompat$1(this, continuation);
            }
        } else {
            camera2DeviceCache$getOrInitializeDeviceSetupCompat$1 = new Camera2DeviceCache$getOrInitializeDeviceSetupCompat$1(this, continuation);
        }
        Object objAwait = camera2DeviceCache$getOrInitializeDeviceSetupCompat$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = camera2DeviceCache$getOrInitializeDeviceSetupCompat$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwait);
            if (Build.VERSION.SDK_INT < 35) {
                return null;
            }
            synchronized (this.lock) {
                Map<CameraId, Deferred<CameraDeviceSetupCompat>> map = this.cameraDeviceSetupCache;
                CameraId cameraIdM426boximpl = CameraId.m426boximpl(str);
                Deferred<CameraDeviceSetupCompat> deferredAsync$default = map.get(cameraIdM426boximpl);
                if (deferredAsync$default == null) {
                    deferredAsync$default = BuildersKt__Builders_commonKt.async$default(this.scope, this.threads.getBackgroundDispatcher(), null, new Camera2DeviceCache$getOrInitializeDeviceSetupCompat$deferred$1$1$1(str, this, null), 2, null);
                    map.put(cameraIdM426boximpl, deferredAsync$default);
                }
                deferred = deferredAsync$default;
            }
            camera2DeviceCache$getOrInitializeDeviceSetupCompat$1.L$0 = str;
            camera2DeviceCache$getOrInitializeDeviceSetupCompat$1.L$1 = deferred;
            camera2DeviceCache$getOrInitializeDeviceSetupCompat$1.label = 1;
            objAwait = deferred.await(camera2DeviceCache$getOrInitializeDeviceSetupCompat$1);
            if (objAwait == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Deferred<CameraDeviceSetupCompat> deferred2 = (Deferred) camera2DeviceCache$getOrInitializeDeviceSetupCompat$1.L$1;
            String str2 = (String) camera2DeviceCache$getOrInitializeDeviceSetupCompat$1.L$0;
            ResultKt.throwOnFailure(objAwait);
            deferred = deferred2;
            str = str2;
        }
        CameraDeviceSetupCompat cameraDeviceSetupCompat = (CameraDeviceSetupCompat) objAwait;
        if (cameraDeviceSetupCompat != null) {
            return cameraDeviceSetupCompat;
        }
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            android.util.Log.d(Log.TAG, "Removing null CameraDeviceSetupCompat from cache for " + ((Object) CameraId.m432toStringimpl(str)));
        }
        synchronized (this.lock) {
            this.cameraDeviceSetupCache.remove(CameraId.m426boximpl(str), deferred);
        }
        return cameraDeviceSetupCompat;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getOrInitializeDeviceSetupWrapper-0r8Bogc, reason: not valid java name */
    public final Object m833getOrInitializeDeviceSetupWrapper0r8Bogc(String str, Continuation<? super Camera2DeviceSetupWrapper> continuation) {
        Camera2DeviceCache$getOrInitializeDeviceSetupWrapper$1 camera2DeviceCache$getOrInitializeDeviceSetupWrapper$1;
        Deferred<Camera2DeviceSetupWrapper> deferred;
        if (continuation instanceof Camera2DeviceCache$getOrInitializeDeviceSetupWrapper$1) {
            camera2DeviceCache$getOrInitializeDeviceSetupWrapper$1 = (Camera2DeviceCache$getOrInitializeDeviceSetupWrapper$1) continuation;
            if ((camera2DeviceCache$getOrInitializeDeviceSetupWrapper$1.label & Integer.MIN_VALUE) != 0) {
                camera2DeviceCache$getOrInitializeDeviceSetupWrapper$1.label -= Integer.MIN_VALUE;
            } else {
                camera2DeviceCache$getOrInitializeDeviceSetupWrapper$1 = new Camera2DeviceCache$getOrInitializeDeviceSetupWrapper$1(this, continuation);
            }
        } else {
            camera2DeviceCache$getOrInitializeDeviceSetupWrapper$1 = new Camera2DeviceCache$getOrInitializeDeviceSetupWrapper$1(this, continuation);
        }
        Object objAwait = camera2DeviceCache$getOrInitializeDeviceSetupWrapper$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = camera2DeviceCache$getOrInitializeDeviceSetupWrapper$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwait);
            synchronized (this.lock) {
                Map<CameraId, Deferred<Camera2DeviceSetupWrapper>> map = this.camera2DeviceSetupWrapperCache;
                CameraId cameraIdM426boximpl = CameraId.m426boximpl(str);
                Deferred<Camera2DeviceSetupWrapper> deferredAsync$default = map.get(cameraIdM426boximpl);
                if (deferredAsync$default == null) {
                    deferredAsync$default = BuildersKt__Builders_commonKt.async$default(this.scope, this.threads.getBackgroundDispatcher(), null, new Camera2DeviceCache$getOrInitializeDeviceSetupWrapper$deferred$1$1$1(str, this, null), 2, null);
                    map.put(cameraIdM426boximpl, deferredAsync$default);
                }
                deferred = deferredAsync$default;
            }
            camera2DeviceCache$getOrInitializeDeviceSetupWrapper$1.L$0 = str;
            camera2DeviceCache$getOrInitializeDeviceSetupWrapper$1.L$1 = deferred;
            camera2DeviceCache$getOrInitializeDeviceSetupWrapper$1.label = 1;
            objAwait = deferred.await(camera2DeviceCache$getOrInitializeDeviceSetupWrapper$1);
            if (objAwait == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Deferred<Camera2DeviceSetupWrapper> deferred2 = (Deferred) camera2DeviceCache$getOrInitializeDeviceSetupWrapper$1.L$1;
            String str2 = (String) camera2DeviceCache$getOrInitializeDeviceSetupWrapper$1.L$0;
            ResultKt.throwOnFailure(objAwait);
            deferred = deferred2;
            str = str2;
        }
        Camera2DeviceSetupWrapper camera2DeviceSetupWrapper = (Camera2DeviceSetupWrapper) objAwait;
        if (camera2DeviceSetupWrapper != null) {
            return camera2DeviceSetupWrapper;
        }
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            android.util.Log.d(Log.TAG, "Removing null camera2DeviceSetupWrapper from cache for " + ((Object) CameraId.m432toStringimpl(str)));
        }
        synchronized (this.lock) {
            this.camera2DeviceSetupWrapperCache.remove(CameraId.m426boximpl(str), deferred);
        }
        return camera2DeviceSetupWrapper;
    }

    public final Object getCameraIds(Continuation<? super List<CameraId>> continuation) {
        List<CameraId> list;
        synchronized (this.lock) {
            list = this.openableCameras;
        }
        return list != null ? list : BuildersKt.withContext(this.threads.getBackgroundDispatcher(), new AnonymousClass2(null), continuation);
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.compat.Camera2DeviceCache$getCameraIds$2, reason: invalid class name */
    /* JADX INFO: compiled from: Camera2DeviceCache.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Landroidx/camera/camera2/pipe/CameraId;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.compat.Camera2DeviceCache$getCameraIds$2", f = "Camera2DeviceCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends CameraId>>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Camera2DeviceCache.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends CameraId>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<CameraId>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<CameraId>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Debug debug = Debug.INSTANCE;
            Camera2DeviceCache camera2DeviceCache = Camera2DeviceCache.this;
            try {
                Trace.beginSection("readCameraIds");
                List cameraIds = camera2DeviceCache.readCameraIds();
                if (cameraIds == null) {
                    cameraIds = CollectionsKt.emptyList();
                }
                return cameraIds;
            } finally {
                Trace.endSection();
            }
        }
    }

    public final List<CameraId> awaitCameraIds() {
        List<CameraId> list;
        synchronized (this.lock) {
            list = this.openableCameras;
        }
        return list != null ? list : readCameraIds();
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.compat.Camera2DeviceCache$createCameraIdListFlow$1, reason: invalid class name */
    /* JADX INFO: compiled from: Camera2DeviceCache.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "", "Landroidx/camera/camera2/pipe/CameraId;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.compat.Camera2DeviceCache$createCameraIdListFlow$1", f = "Camera2DeviceCache.kt", i = {}, l = {235}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<ProducerScope<? super List<? extends CameraId>>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = Camera2DeviceCache.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(ProducerScope<? super List<? extends CameraId>> producerScope, Continuation<? super Unit> continuation) {
            return invoke2((ProducerScope<? super List<CameraId>>) producerScope, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(ProducerScope<? super List<CameraId>> producerScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [androidx.camera.camera2.pipe.compat.Camera2DeviceCache$createCameraIdListFlow$1$callback$1] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            List list;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final ProducerScope producerScope = (ProducerScope) this.L$0;
                final Camera2DeviceCache camera2DeviceCache = Camera2DeviceCache.this;
                final ?? r1 = new CameraManager.AvailabilityCallback() { // from class: androidx.camera.camera2.pipe.compat.Camera2DeviceCache$createCameraIdListFlow$1$callback$1
                    @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
                    public void onCameraAvailable(String cameraId) {
                        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
                        camera2DeviceCache.onCameraAvailabilityChanged(producerScope, cameraId, true);
                    }

                    @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
                    public void onCameraUnavailable(String cameraId) {
                        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
                        camera2DeviceCache.onCameraAvailabilityChanged(producerScope, cameraId, false);
                    }
                };
                final CameraManager cameraManager = (CameraManager) Camera2DeviceCache.this.cameraManager.get();
                cameraManager.registerAvailabilityCallback((CameraManager.AvailabilityCallback) r1, Camera2DeviceCache.this.threads.getCamera2Handler());
                Object obj2 = Camera2DeviceCache.this.lock;
                Camera2DeviceCache camera2DeviceCache2 = Camera2DeviceCache.this;
                synchronized (obj2) {
                    list = camera2DeviceCache2.openableCameras;
                }
                Camera2DeviceCache camera2DeviceCache3 = Camera2DeviceCache.this;
                if (list != null) {
                    camera2DeviceCache3.sendCameraIdList(producerScope, list);
                } else {
                    List cameraIds = camera2DeviceCache3.readCameraIds();
                    if (cameraIds != null) {
                        Camera2DeviceCache.this.sendCameraIdList(producerScope, cameraIds);
                    }
                }
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, new Function0() { // from class: androidx.camera.camera2.pipe.compat.Camera2DeviceCache$createCameraIdListFlow$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Camera2DeviceCache.AnonymousClass1.invokeSuspend$lambda$1(cameraManager, r1);
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        static final Unit invokeSuspend$lambda$1(CameraManager cameraManager, Camera2DeviceCache$createCameraIdListFlow$1$callback$1 camera2DeviceCache$createCameraIdListFlow$1$callback$1) {
            cameraManager.unregisterAvailabilityCallback(camera2DeviceCache$createCameraIdListFlow$1$callback$1);
            return Unit.INSTANCE;
        }
    }

    private final Flow<List<CameraId>> createCameraIdListFlow() {
        return FlowKt.callbackFlow(new AnonymousClass1(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:20:0x0039  */
    /* JADX WARN: Code duplicated, block: B:22:0x0041  */
    /* JADX WARN: Code duplicated, block: B:38:0x0095  */
    /* JADX WARN: Instruction removed from duplicated block: B:22:0x0041, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:38:0x0095, please report this as an issue */
    public final void onCameraAvailabilityChanged(ProducerScope<? super List<CameraId>> producerScope, String str, boolean z) {
        List<CameraId> list;
        synchronized (this.lock) {
            list = this.openableCameras;
        }
        List<CameraId> cameraIds = null;
        if (z) {
            if (list != null) {
                List<CameraId> list2 = list;
                if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                    Iterator<T> it = list2.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (Intrinsics.areEqual(((CameraId) it.next()).m433unboximpl(), str)) {
                            }
                        } else {
                            if (Log.INSTANCE.getINFO_LOGGABLE()) {
                                android.util.Log.i(Log.TAG, "New camera " + str + " detected");
                            }
                            cameraIds = readCameraIds();
                        }
                    }
                } else {
                    if (Log.INSTANCE.getINFO_LOGGABLE()) {
                        android.util.Log.i(Log.TAG, "New camera " + str + " detected");
                    }
                    cameraIds = readCameraIds();
                }
            } else {
                if (Log.INSTANCE.getINFO_LOGGABLE()) {
                    android.util.Log.i(Log.TAG, "New camera " + str + " detected");
                }
                cameraIds = readCameraIds();
            }
        } else {
            if (z) {
                throw new NoWhenBranchMatchedException();
            }
            if (list != null) {
                List<CameraId> list3 = list;
                if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                    Iterator<T> it2 = list3.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (Intrinsics.areEqual(((CameraId) it2.next()).m433unboximpl(), str)) {
                                if (Log.INSTANCE.getINFO_LOGGABLE()) {
                                    android.util.Log.i(Log.TAG, "Unavailable camera " + str + " detected");
                                }
                                cameraIds = readCameraIds();
                            }
                        }
                    }
                }
            } else {
                if (Log.INSTANCE.getINFO_LOGGABLE()) {
                    android.util.Log.i(Log.TAG, "Unavailable camera " + str + " detected");
                }
                cameraIds = readCameraIds();
            }
        }
        List<CameraId> updatedCameraIds = getUpdatedCameraIds(list, cameraIds);
        if (updatedCameraIds != null) {
            sendCameraIdList(producerScope, updatedCameraIds);
        }
    }

    private final List<CameraId> getUpdatedCameraIds(List<CameraId> cachedCameraIds, List<CameraId> cameraIdsRead) {
        return (cameraIdsRead == null || !(isValidCameraIds(cameraIdsRead) || cachedCameraIds == null)) ? cachedCameraIds : cameraIdsRead;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendCameraIdList(ProducerScope<? super List<CameraId>> producerScope, List<CameraId> list) {
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            android.util.Log.d(Log.TAG, "Emitting camera ID list: " + list);
        }
        Object objTrySendBlocking = ChannelsKt.trySendBlocking(producerScope, list);
        if (objTrySendBlocking instanceof ChannelResult.Failed) {
            ChannelResult.m14239exceptionOrNullimpl(objTrySendBlocking);
            if (Log.INSTANCE.getERROR_LOGGABLE()) {
                android.util.Log.e(Log.TAG, "Failed to send camera ID list: " + list + '!');
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<CameraId> readCameraIds() {
        try {
            String[] cameraIdList = this.cameraManager.get().getCameraIdList();
            Intrinsics.checkNotNullExpressionValue(cameraIdList, "getCameraIdList(...)");
            ArrayList arrayList = new ArrayList();
            for (String str : cameraIdList) {
                Intrinsics.checkNotNull(str);
                String strM427constructorimpl = CameraId.m427constructorimpl(str);
                CameraId cameraIdM426boximpl = strM427constructorimpl != null ? CameraId.m426boximpl(strM427constructorimpl) : null;
                if (cameraIdM426boximpl != null) {
                    arrayList.add(cameraIdM426boximpl);
                }
            }
            ArrayList arrayList2 = arrayList;
            if (isValidCameraIds(arrayList2)) {
                synchronized (this.lock) {
                    this.openableCameras = arrayList2;
                    Unit unit = Unit.INSTANCE;
                }
                if (Log.INSTANCE.getINFO_LOGGABLE()) {
                    android.util.Log.i(Log.TAG, "Loaded CameraIdList " + arrayList2);
                    return arrayList2;
                }
            } else if (Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Failed to query camera ID list: Invalid list returned: " + arrayList2 + FilenameUtils.EXTENSION_SEPARATOR);
            }
            return arrayList2;
        } catch (CameraAccessException e) {
            CameraAccessException cameraAccessException = e;
            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Failed to query CameraManager#getCameraIdList!", cameraAccessException);
            }
            return null;
        } catch (ArrayIndexOutOfBoundsException e2) {
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = e2;
            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Failed to query CameraManager#getCameraIdList!Unexpected ArrayIndexOutOfBoundsException thrown by framework.", arrayIndexOutOfBoundsException);
            }
            return null;
        } catch (NullPointerException e3) {
            NullPointerException nullPointerException = e3;
            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Failed to query CameraManager#getCameraIdList!Null was returned by framework.", nullPointerException);
            }
            return null;
        }
    }

    private final int estimateMinInternalCameraCount(PackageManager packageManager) {
        boolean zHasSystemFeature = packageManager.hasSystemFeature("android.hardware.camera");
        return packageManager.hasSystemFeature("android.hardware.camera.front") ? (zHasSystemFeature ? 1 : 0) + 1 : zHasSystemFeature ? 1 : 0;
    }

    private final boolean isValidCameraIds(List<CameraId> cameraIds) {
        return cameraIds.size() >= this.minimumCameraCount;
    }

    public final Object getConcurrentCameraIds(Continuation<? super Set<? extends Set<CameraId>>> continuation) {
        Set<? extends Set<CameraId>> set;
        synchronized (this.lock) {
            set = this.concurrentCameras;
        }
        Set<? extends Set<CameraId>> set2 = set;
        return (set2 == null || set2.isEmpty()) ? BuildersKt.withContext(this.threads.getBackgroundDispatcher(), new C02022(null), continuation) : set;
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.compat.Camera2DeviceCache$getConcurrentCameraIds$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Camera2DeviceCache.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Landroidx/camera/camera2/pipe/CameraId;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.compat.Camera2DeviceCache$getConcurrentCameraIds$2", f = "Camera2DeviceCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C02022 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Set<? extends Set<? extends CameraId>>>, Object> {
        int label;

        C02022(Continuation<? super C02022> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Camera2DeviceCache.this.new C02022(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Set<? extends Set<? extends CameraId>>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Set<? extends Set<CameraId>>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Set<? extends Set<CameraId>>> continuation) {
            return ((C02022) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Debug debug = Debug.INSTANCE;
            Camera2DeviceCache camera2DeviceCache = Camera2DeviceCache.this;
            try {
                Trace.beginSection("readConcurrentCameraIds");
                Set<Set<CameraId>> setAwaitConcurrentCameraIds = camera2DeviceCache.awaitConcurrentCameraIds();
                Set<Set<CameraId>> set = setAwaitConcurrentCameraIds;
                if (set != null && !set.isEmpty()) {
                    synchronized (camera2DeviceCache.lock) {
                        camera2DeviceCache.concurrentCameras = setAwaitConcurrentCameraIds;
                        Unit unit = Unit.INSTANCE;
                    }
                } else {
                    setAwaitConcurrentCameraIds = SetsKt.emptySet();
                }
                Trace.endSection();
                return setAwaitConcurrentCameraIds;
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
    }

    public final Set<Set<CameraId>> awaitConcurrentCameraIds() {
        Set set;
        if (Build.VERSION.SDK_INT < 30) {
            return SetsKt.emptySet();
        }
        synchronized (this.lock) {
            set = this.concurrentCameras;
        }
        Set set2 = set;
        if (set2 != null && !set2.isEmpty()) {
            return set;
        }
        CameraManager cameraManager = this.cameraManager.get();
        try {
            Intrinsics.checkNotNull(cameraManager);
            Set<Set<String>> concurrentCameraIds = Api30Compat.getConcurrentCameraIds(cameraManager);
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                android.util.Log.d(Log.TAG, "Loaded ConcurrentCameraIdsSet " + concurrentCameraIds);
            }
            Set<Set<String>> set3 = concurrentCameraIds;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set3, 10));
            Iterator<T> it = set3.iterator();
            while (it.hasNext()) {
                Set set4 = (Set) it.next();
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(set4, 10));
                Iterator it2 = set4.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(CameraId.m426boximpl(CameraId.m427constructorimpl((String) it2.next())));
                }
                arrayList.add(CollectionsKt.toSet(arrayList2));
            }
            return CollectionsKt.toSet(arrayList);
        } catch (CameraAccessException e) {
            CameraAccessException cameraAccessException = e;
            if (!Log.INSTANCE.getWARN_LOGGABLE()) {
                return null;
            }
            android.util.Log.w(Log.TAG, "Failed to query CameraManager#getConcurrentStreamingCameraIds", cameraAccessException);
            return null;
        }
    }

    public final void shutdown() {
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
    }
}

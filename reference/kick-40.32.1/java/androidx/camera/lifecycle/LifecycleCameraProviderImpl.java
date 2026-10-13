package androidx.camera.lifecycle;

import android.content.Context;
import androidx.arch.core.util.Function;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraEffect;
import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraIdentifier;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraPresenceListener;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraX;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.CompositionSettings;
import androidx.camera.core.ConcurrentCamera;
import androidx.camera.core.LegacySessionConfig;
import androidx.camera.core.Preview;
import androidx.camera.core.SessionConfig;
import androidx.camera.core.UseCase;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.ViewPort;
import androidx.camera.core.impl.AdapterCameraInfo;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigProvider;
import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraPresenceProvider;
import androidx.camera.core.impl.ExtendedCameraConfigProviderStore;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.ContextUtil;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LifecycleOwner;
import androidx.tracing.Trace;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: LifecycleCameraProviderImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,H\u0000¢\u0006\u0002\b-J\b\u0010.\u001a\u00020/H\u0003J\u001c\u00100\u001a\u00020/2\b\u00101\u001a\u0004\u0018\u00010\u00152\b\u00102\u001a\u0004\u0018\u00010\u001cH\u0003J\u0015\u00103\u001a\u00020/2\u0006\u0010+\u001a\u00020,H\u0000¢\u0006\u0002\b4J\u001d\u00105\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u00106\u001a\u00020\u0017H\u0000¢\u0006\u0002\b7J\u0010\u00108\u001a\u00020\u00172\u0006\u00109\u001a\u00020:H\u0016J\u0010\u00108\u001a\u00020\u00172\u0006\u0010;\u001a\u00020<H\u0016J%\u0010=\u001a\u00020/2\u0016\u0010>\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010:0?\"\u0004\u0018\u00010:H\u0017¢\u0006\u0002\u0010@J\u0010\u0010=\u001a\u00020/2\u0006\u0010;\u001a\u00020<H\u0017J\b\u0010A\u001a\u00020/H\u0017J\u0010\u0010B\u001a\u00020\u00172\u0006\u0010C\u001a\u00020DH\u0016J5\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010C\u001a\u00020D2\u0016\u0010>\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010:0?\"\u0004\u0018\u00010:H\u0017¢\u0006\u0002\u0010IJ \u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010C\u001a\u00020D2\u0006\u0010J\u001a\u00020KH\u0017J \u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010C\u001a\u00020D2\u0006\u0010;\u001a\u00020<H\u0017J\u0018\u0010E\u001a\u00020L2\u000e\u0010M\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010O0NH\u0017J@\u0010W\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010X\u001a\u00020D2\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010D2\b\b\u0002\u0010Z\u001a\u00020[2\b\b\u0002\u0010\\\u001a\u00020[2\u0006\u0010;\u001a\u00020<H\u0002J0\u0010]\u001a\u0010\u0012\u0004\u0012\u00020D\u0012\u0006\u0012\u0004\u0018\u00010D0^2\u0006\u0010;\u001a\u00020<2\u0006\u0010X\u001a\u00020D2\b\u0010Y\u001a\u0004\u0018\u00010DH\u0002J\u0010\u0010_\u001a\u00020Q2\u0006\u0010C\u001a\u00020DH\u0016J\u0018\u0010_\u001a\u00020Q2\u0006\u0010C\u001a\u00020D2\u0006\u0010;\u001a\u00020<H\u0016J\u0018\u0010`\u001a\u00020/2\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020\u0002H\u0016J\u0010\u0010d\u001a\u00020/2\u0006\u0010c\u001a\u00020\u0002H\u0016J\u0016\u0010e\u001a\u00020/2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020$0gH\u0017J\u0016\u0010h\u001a\u00020/2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020$0gH\u0017J\u0010\u0010j\u001a\u00020\u00172\u0006\u00109\u001a\u00020:H\u0002J\u0010\u0010k\u001a\u00020\u00172\u0006\u00109\u001a\u00020:H\u0002J\u0018\u0010l\u001a\u00020m2\u0006\u0010C\u001a\u00020D2\u0006\u0010n\u001a\u00020QH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R%\u0010\u0011\u001a\u0015\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00100\u00100\u000f¢\u0006\u0002\b\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0#8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u0012\u0012\u0004\u0012\u00020(0'j\b\u0012\u0004\u0012\u00020(`)X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00020Q0N8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR \u0010T\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Q0N0N8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bU\u0010SR\u0014\u0010V\u001a\u00020\u00178WX\u0096\u0004¢\u0006\u0006\u001a\u0004\bV\u0010\u0018R$\u0010o\u001a\u00020p2\u0006\u0010o\u001a\u00020p8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR0\u0010v\u001a\b\u0012\u0004\u0012\u00020Q0N2\f\u0010u\u001a\b\u0012\u0004\u0012\u00020Q0N8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bw\u0010S\"\u0004\bx\u0010y¨\u0006z"}, d2 = {"Landroidx/camera/lifecycle/LifecycleCameraProviderImpl;", "Landroidx/camera/lifecycle/LifecycleCameraProvider;", "Landroidx/camera/core/CameraPresenceListener;", "<init>", "()V", "lock", "", "cameraXConfigProvider", "Landroidx/camera/core/CameraXConfig$Provider;", "getCameraXConfigProvider$camera_lifecycle$annotations", "getCameraXConfigProvider$camera_lifecycle", "()Landroidx/camera/core/CameraXConfig$Provider;", "setCameraXConfigProvider$camera_lifecycle", "(Landroidx/camera/core/CameraXConfig$Provider;)V", "cameraXInitializeFuture", "Lcom/google/common/util/concurrent/ListenableFuture;", "Ljava/lang/Void;", "cameraXShutdownFuture", "kotlin.jvm.PlatformType", "Lorg/jspecify/annotations/NonNull;", "cameraX", "Landroidx/camera/core/CameraX;", "isInitialized", "", "()Z", "lifecycleCameraRepository", "Landroidx/camera/lifecycle/LifecycleCameraRepository;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "getContext$camera_lifecycle$annotations", "getContext$camera_lifecycle", "()Landroid/content/Context;", "setContext$camera_lifecycle", "(Landroid/content/Context;)V", "cameraInfoMap", "", "Landroidx/camera/core/CameraIdentifier;", "Landroidx/camera/core/impl/AdapterCameraInfo;", "lifecycleCameraKeys", "Ljava/util/HashSet;", "Landroidx/camera/lifecycle/LifecycleCameraRepository$Key;", "Lkotlin/collections/HashSet;", "initAsync", "cameraXConfig", "Landroidx/camera/core/CameraXConfig;", "initAsync$camera_lifecycle", "shutdownInternal", "", "initInternal", "newCameraX", "newContext", "configure", "configure$camera_lifecycle", "shutdownAsync", "clearConfigProvider", "shutdownAsync$camera_lifecycle", "isBound", "useCase", "Landroidx/camera/core/UseCase;", "sessionConfig", "Landroidx/camera/core/SessionConfig;", "unbind", "useCases", "", "([Landroidx/camera/core/UseCase;)V", "unbindAll", "hasCamera", "cameraSelector", "Landroidx/camera/core/CameraSelector;", "bindToLifecycle", "Landroidx/camera/core/Camera;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/camera/core/CameraSelector;[Landroidx/camera/core/UseCase;)Landroidx/camera/core/Camera;", "useCaseGroup", "Landroidx/camera/core/UseCaseGroup;", "Landroidx/camera/core/ConcurrentCamera;", "singleCameraConfigs", "", "Landroidx/camera/core/ConcurrentCamera$SingleCameraConfig;", "availableCameraInfos", "Landroidx/camera/core/CameraInfo;", "getAvailableCameraInfos", "()Ljava/util/List;", "availableConcurrentCameraInfos", "getAvailableConcurrentCameraInfos", "isConcurrentCameraModeOn", "bindToLifecycleInternal", "primaryCameraSelector", "secondaryCameraSelector", "primaryCompositionSettings", "Landroidx/camera/core/CompositionSettings;", "secondaryCompositionSettings", "getSelectorsWithSessionFilter", "Lkotlin/Pair;", "getCameraInfo", "addCameraPresenceListener", "executor", "Ljava/util/concurrent/Executor;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeCameraPresenceListener", "onCamerasAdded", "addedCameraIds", "", "onCamerasRemoved", "removedCameraIds", "isVideoCapture", "isPreview", "getCameraConfig", "Landroidx/camera/core/impl/CameraConfig;", "cameraInfo", "cameraOperatingMode", "", "getCameraOperatingMode", "()I", "setCameraOperatingMode", "(I)V", "cameraInfos", "activeConcurrentCameraInfos", "getActiveConcurrentCameraInfos", "setActiveConcurrentCameraInfos", "(Ljava/util/List;)V", "camera-lifecycle"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LifecycleCameraProviderImpl implements LifecycleCameraProvider, CameraPresenceListener {
    private final Map<CameraIdentifier, AdapterCameraInfo> cameraInfoMap;
    private CameraX cameraX;
    private CameraXConfig.Provider cameraXConfigProvider;
    private ListenableFuture<Void> cameraXInitializeFuture;
    private ListenableFuture<Void> cameraXShutdownFuture;
    private Context context;
    private final HashSet<LifecycleCameraRepository.Key> lifecycleCameraKeys;
    private LifecycleCameraRepository lifecycleCameraRepository;
    private final Object lock = new Object();

    public static /* synthetic */ void getCameraXConfigProvider$camera_lifecycle$annotations() {
    }

    public static /* synthetic */ void getContext$camera_lifecycle$annotations() {
    }

    @Override // androidx.camera.core.CameraPresenceListener
    public void onCamerasAdded(Set<CameraIdentifier> addedCameraIds) {
        Intrinsics.checkNotNullParameter(addedCameraIds, "addedCameraIds");
    }

    public LifecycleCameraProviderImpl() {
        ListenableFuture<Void> listenableFutureImmediateFuture = Futures.immediateFuture(null);
        Intrinsics.checkNotNullExpressionValue(listenableFutureImmediateFuture, "immediateFuture(...)");
        this.cameraXShutdownFuture = listenableFutureImmediateFuture;
        this.cameraInfoMap = new HashMap();
        this.lifecycleCameraKeys = new HashSet<>();
    }

    /* JADX INFO: renamed from: getCameraXConfigProvider$camera_lifecycle, reason: from getter */
    public final CameraXConfig.Provider getCameraXConfigProvider() {
        return this.cameraXConfigProvider;
    }

    public final void setCameraXConfigProvider$camera_lifecycle(CameraXConfig.Provider provider) {
        this.cameraXConfigProvider = provider;
    }

    private final boolean isInitialized() {
        return this.cameraX != null;
    }

    /* JADX INFO: renamed from: getContext$camera_lifecycle, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    public final void setContext$camera_lifecycle(Context context) {
        this.context = context;
    }

    public static /* synthetic */ ListenableFuture initAsync$camera_lifecycle$default(LifecycleCameraProviderImpl lifecycleCameraProviderImpl, Context context, CameraXConfig cameraXConfig, int i, Object obj) {
        if ((i & 2) != 0) {
            cameraXConfig = null;
        }
        return lifecycleCameraProviderImpl.initAsync$camera_lifecycle(context, cameraXConfig);
    }

    public final ListenableFuture<Void> initAsync$camera_lifecycle(final Context context, CameraXConfig cameraXConfig) {
        Intrinsics.checkNotNullParameter(context, "context");
        synchronized (this.lock) {
            this.lifecycleCameraRepository = LifecycleCameraRepositories.getInstance$camera_lifecycle(ContextUtil.getDeviceId(context));
            ListenableFuture<Void> listenableFuture = this.cameraXInitializeFuture;
            if (listenableFuture != null) {
                Intrinsics.checkNotNull(listenableFuture, "null cannot be cast to non-null type com.google.common.util.concurrent.ListenableFuture<java.lang.Void>");
                return listenableFuture;
            }
            if (cameraXConfig != null) {
                configure$camera_lifecycle(cameraXConfig);
            }
            final CameraX cameraX = new CameraX(context, this.cameraXConfigProvider);
            FutureChain futureChainFrom = FutureChain.from(this.cameraXShutdownFuture);
            final Function1 function1 = new Function1() { // from class: androidx.camera.lifecycle.LifecycleCameraProviderImpl$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LifecycleCameraProviderImpl.initAsync$lambda$0$1(cameraX, (Void) obj);
                }
            };
            FutureChain futureChainTransformAsync = futureChainFrom.transformAsync(new AsyncFunction() { // from class: androidx.camera.lifecycle.LifecycleCameraProviderImpl$$ExternalSyntheticLambda1
                @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
                public final ListenableFuture apply(Object obj) {
                    return LifecycleCameraProviderImpl.initAsync$lambda$0$2(function1, obj);
                }
            }, CameraXExecutors.directExecutor());
            final Function1 function2 = new Function1() { // from class: androidx.camera.lifecycle.LifecycleCameraProviderImpl$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LifecycleCameraProviderImpl.initAsync$lambda$0$3(this.f$0, cameraX, context, (Void) obj);
                }
            };
            FutureChain futureChainTransform = futureChainTransformAsync.transform(new Function() { // from class: androidx.camera.lifecycle.LifecycleCameraProviderImpl$$ExternalSyntheticLambda3
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return LifecycleCameraProviderImpl.initAsync$lambda$0$4(function2, obj);
                }
            }, CameraXExecutors.directExecutor());
            Intrinsics.checkNotNullExpressionValue(futureChainTransform, "transform(...)");
            FutureChain futureChain = futureChainTransform;
            this.cameraXInitializeFuture = futureChain;
            Futures.addCallback(futureChain, new FutureCallback<Void>() { // from class: androidx.camera.lifecycle.LifecycleCameraProviderImpl$initAsync$1$2
                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onSuccess(Void r1) {
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onFailure(Throwable t) {
                    Intrinsics.checkNotNullParameter(t, "t");
                    this.this$0.shutdownAsync$camera_lifecycle(false);
                }
            }, CameraXExecutors.directExecutor());
            ListenableFuture<Void> listenableFutureNonCancellationPropagating = Futures.nonCancellationPropagating(futureChain);
            Intrinsics.checkNotNullExpressionValue(listenableFutureNonCancellationPropagating, "nonCancellationPropagating(...)");
            return listenableFutureNonCancellationPropagating;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ListenableFuture initAsync$lambda$0$1(CameraX cameraX, Void r1) {
        return cameraX.getInitializeFuture();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ListenableFuture initAsync$lambda$0$2(Function1 function1, Object obj) {
        return (ListenableFuture) function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void initAsync$lambda$0$4(Function1 function1, Object obj) {
        return (Void) function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void initAsync$lambda$0$3(LifecycleCameraProviderImpl lifecycleCameraProviderImpl, CameraX cameraX, Context context, Void r3) {
        lifecycleCameraProviderImpl.initInternal(cameraX, ContextUtil.getPersistentApplicationContext(context));
        return r3;
    }

    private final void shutdownInternal() {
        initInternal(null, null);
    }

    private final void initInternal(CameraX newCameraX, Context newContext) {
        CameraPresenceProvider cameraAvailabilityProvider;
        synchronized (this.lock) {
            this.cameraX = newCameraX;
            this.context = newContext;
            if (newCameraX != null && (cameraAvailabilityProvider = newCameraX.getCameraAvailabilityProvider()) != null) {
                ScheduledExecutorService scheduledExecutorServiceMainThreadExecutor = CameraXExecutors.mainThreadExecutor();
                Intrinsics.checkNotNullExpressionValue(scheduledExecutorServiceMainThreadExecutor, "mainThreadExecutor(...)");
                cameraAvailabilityProvider.addCameraPresenceListener(this, scheduledExecutorServiceMainThreadExecutor);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void configure$camera_lifecycle(final CameraXConfig cameraXConfig) {
        Intrinsics.checkNotNullParameter(cameraXConfig, "cameraXConfig");
        Trace.beginSection("CX:configureInstanceInternal");
        try {
            synchronized (this.lock) {
                Preconditions.checkNotNull(cameraXConfig);
                Preconditions.checkState(getCameraXConfigProvider() == null, "CameraX has already been configured. To use a different configuration, shutdown() must be called.");
                setCameraXConfigProvider$camera_lifecycle(new CameraXConfig.Provider() { // from class: androidx.camera.lifecycle.LifecycleCameraProviderImpl$configure$1$1$1
                    @Override // androidx.camera.core.CameraXConfig.Provider
                    public final CameraXConfig getCameraXConfig() {
                        return cameraXConfig;
                    }
                });
                Unit unit = Unit.INSTANCE;
            }
            Unit unit2 = Unit.INSTANCE;
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public static /* synthetic */ ListenableFuture shutdownAsync$camera_lifecycle$default(LifecycleCameraProviderImpl lifecycleCameraProviderImpl, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return lifecycleCameraProviderImpl.shutdownAsync$camera_lifecycle(z);
    }

    public final ListenableFuture<Void> shutdownAsync$camera_lifecycle(boolean clearConfigProvider) {
        ListenableFuture<Void> listenableFutureImmediateFuture;
        Threads.runOnMainSync(new Runnable() { // from class: androidx.camera.lifecycle.LifecycleCameraProviderImpl$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                LifecycleCameraProviderImpl.shutdownAsync$lambda$0(this.f$0);
            }
        });
        if (isInitialized()) {
            CameraX cameraX = this.cameraX;
            Intrinsics.checkNotNull(cameraX);
            cameraX.getCameraAvailabilityProvider().removeCameraPresenceListener(this);
            CameraX cameraX2 = this.cameraX;
            Intrinsics.checkNotNull(cameraX2);
            listenableFutureImmediateFuture = cameraX2.shutdown();
        } else {
            listenableFutureImmediateFuture = Futures.immediateFuture(null);
        }
        Intrinsics.checkNotNull(listenableFutureImmediateFuture);
        synchronized (this.lock) {
            if (clearConfigProvider) {
                this.cameraXConfigProvider = null;
            }
            this.cameraXInitializeFuture = null;
            this.cameraXShutdownFuture = listenableFutureImmediateFuture;
            this.cameraInfoMap.clear();
            this.lifecycleCameraKeys.clear();
            Unit unit = Unit.INSTANCE;
        }
        shutdownInternal();
        return listenableFutureImmediateFuture;
    }

    static final void shutdownAsync$lambda$0(LifecycleCameraProviderImpl lifecycleCameraProviderImpl) {
        if (lifecycleCameraProviderImpl.isInitialized()) {
            lifecycleCameraProviderImpl.unbindAll();
            LifecycleCameraRepository lifecycleCameraRepository = lifecycleCameraProviderImpl.lifecycleCameraRepository;
            Intrinsics.checkNotNull(lifecycleCameraRepository);
            lifecycleCameraRepository.removeLifecycleCameras(lifecycleCameraProviderImpl.lifecycleCameraKeys);
        }
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    public boolean isBound(UseCase useCase) {
        Intrinsics.checkNotNullParameter(useCase, "useCase");
        LifecycleCameraRepository lifecycleCameraRepository = this.lifecycleCameraRepository;
        Intrinsics.checkNotNull(lifecycleCameraRepository);
        for (LifecycleCamera lifecycleCamera : lifecycleCameraRepository.getLifecycleCameras()) {
            Intrinsics.checkNotNullExpressionValue(lifecycleCamera, "next(...)");
            if (lifecycleCamera.isBound(useCase)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    public boolean isBound(SessionConfig sessionConfig) {
        Intrinsics.checkNotNullParameter(sessionConfig, "sessionConfig");
        LifecycleCameraRepository lifecycleCameraRepository = this.lifecycleCameraRepository;
        Intrinsics.checkNotNull(lifecycleCameraRepository);
        for (LifecycleCamera lifecycleCamera : lifecycleCameraRepository.getLifecycleCameras()) {
            Intrinsics.checkNotNullExpressionValue(lifecycleCamera, "next(...)");
            if (lifecycleCamera.isBound(sessionConfig)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    public void unbind(UseCase... useCases) {
        Intrinsics.checkNotNullParameter(useCases, "useCases");
        Trace.beginSection("CX:unbind");
        try {
            Threads.checkMainThread();
            if (getCameraOperatingMode() != 2) {
                LifecycleCameraRepository lifecycleCameraRepository = this.lifecycleCameraRepository;
                Intrinsics.checkNotNull(lifecycleCameraRepository);
                lifecycleCameraRepository.unbind(new LegacySessionConfig(ArraysKt.filterNotNull(useCases), null, null, 6, null), this.lifecycleCameraKeys);
                Unit unit = Unit.INSTANCE;
                Trace.endSection();
                return;
            }
            throw new UnsupportedOperationException("Unbind UseCase is not supported in concurrent camera mode, call unbindAll() first.");
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    public void unbind(SessionConfig sessionConfig) {
        Intrinsics.checkNotNullParameter(sessionConfig, "sessionConfig");
        Trace.beginSection("CX:unbind-sessionConfig");
        try {
            Threads.checkMainThread();
            if (getCameraOperatingMode() != 2) {
                LifecycleCameraRepository lifecycleCameraRepository = this.lifecycleCameraRepository;
                Intrinsics.checkNotNull(lifecycleCameraRepository);
                lifecycleCameraRepository.unbind(sessionConfig, this.lifecycleCameraKeys);
                Unit unit = Unit.INSTANCE;
                Trace.endSection();
                return;
            }
            throw new UnsupportedOperationException("Unbind SessionConfig is not supported in concurrent camera mode call unbindAll() first.");
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    public void unbindAll() {
        Trace.beginSection("CX:unbindAll");
        try {
            Threads.checkMainThread();
            setCameraOperatingMode(0);
            LifecycleCameraRepository lifecycleCameraRepository = this.lifecycleCameraRepository;
            Intrinsics.checkNotNull(lifecycleCameraRepository);
            lifecycleCameraRepository.unbindAll(this.lifecycleCameraKeys);
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    @Override // androidx.camera.core.CameraProvider
    public boolean hasCamera(CameraSelector cameraSelector) throws CameraInfoUnavailableException {
        boolean z;
        Intrinsics.checkNotNullParameter(cameraSelector, "cameraSelector");
        Trace.beginSection("CX:hasCamera");
        try {
            CameraX cameraX = this.cameraX;
            Intrinsics.checkNotNull(cameraX);
            cameraSelector.select(cameraX.getCameraRepository().getCameras());
            z = true;
        } catch (IllegalArgumentException unused) {
            z = false;
        } finally {
            Trace.endSection();
        }
        return z;
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    public Camera bindToLifecycle(LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, UseCase... useCases) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(cameraSelector, "cameraSelector");
        Intrinsics.checkNotNullParameter(useCases, "useCases");
        Trace.beginSection("CX:bindToLifecycle");
        try {
            if (getCameraOperatingMode() != 2) {
                setCameraOperatingMode(1);
                Camera cameraBindToLifecycleInternal$default = bindToLifecycleInternal$default(this, lifecycleOwner, cameraSelector, null, null, null, new LegacySessionConfig(ArraysKt.filterNotNull(useCases), null, null, 6, null), 28, null);
                Trace.endSection();
                return cameraBindToLifecycleInternal$default;
            }
            throw new UnsupportedOperationException("bindToLifecycle for single camera is not supported in concurrent camera mode, call unbindAll() first");
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    public Camera bindToLifecycle(LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, UseCaseGroup useCaseGroup) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(cameraSelector, "cameraSelector");
        Intrinsics.checkNotNullParameter(useCaseGroup, "useCaseGroup");
        Trace.beginSection("CX:bindToLifecycle-UseCaseGroup");
        try {
            if (getCameraOperatingMode() != 2) {
                setCameraOperatingMode(1);
                Camera cameraBindToLifecycleInternal$default = bindToLifecycleInternal$default(this, lifecycleOwner, cameraSelector, null, null, null, new LegacySessionConfig(useCaseGroup), 28, null);
                Trace.endSection();
                return cameraBindToLifecycleInternal$default;
            }
            throw new UnsupportedOperationException("bindToLifecycle for single camera is not supported in concurrent camera mode, call unbindAll() first.");
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    public Camera bindToLifecycle(LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, SessionConfig sessionConfig) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(cameraSelector, "cameraSelector");
        Intrinsics.checkNotNullParameter(sessionConfig, "sessionConfig");
        Trace.beginSection("CX:bindToLifecycle-SessionConfig");
        try {
            if (getCameraOperatingMode() != 2) {
                setCameraOperatingMode(1);
                Camera cameraBindToLifecycleInternal$default = bindToLifecycleInternal$default(this, lifecycleOwner, cameraSelector, null, null, null, sessionConfig, 28, null);
                Trace.endSection();
                return cameraBindToLifecycleInternal$default;
            }
            throw new UnsupportedOperationException("bindToLifecycle for single camera is not supported in concurrent camera mode, call unbindAll() first.");
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:55:0x01e9 A[Catch: all -> 0x02a6, TryCatch #1 {all -> 0x02a6, blocks: (B:3:0x000e, B:5:0x0015, B:7:0x001b, B:10:0x0053, B:12:0x0059, B:14:0x0067, B:16:0x007d, B:18:0x0093, B:19:0x00c1, B:21:0x00c7, B:22:0x00dc, B:24:0x00e2, B:26:0x00f7, B:27:0x00fb, B:28:0x010e, B:65:0x0277, B:29:0x0128, B:30:0x012f, B:31:0x0130, B:32:0x0135, B:33:0x0136, B:35:0x0149, B:37:0x014f, B:38:0x0157, B:39:0x016d, B:41:0x017f, B:44:0x018a, B:45:0x0191, B:46:0x0192, B:49:0x01ad, B:51:0x01bb, B:53:0x01e0, B:59:0x01f8, B:64:0x0274, B:55:0x01e9, B:57:0x01ef, B:60:0x0235, B:61:0x0239, B:63:0x023f, B:68:0x0280, B:69:0x0287, B:70:0x0288, B:71:0x028d, B:72:0x028e, B:73:0x0295, B:74:0x0296, B:75:0x029d, B:76:0x029e, B:77:0x02a5), top: B:83:0x000e, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x01ef A[Catch: all -> 0x02a6, TryCatch #1 {all -> 0x02a6, blocks: (B:3:0x000e, B:5:0x0015, B:7:0x001b, B:10:0x0053, B:12:0x0059, B:14:0x0067, B:16:0x007d, B:18:0x0093, B:19:0x00c1, B:21:0x00c7, B:22:0x00dc, B:24:0x00e2, B:26:0x00f7, B:27:0x00fb, B:28:0x010e, B:65:0x0277, B:29:0x0128, B:30:0x012f, B:31:0x0130, B:32:0x0135, B:33:0x0136, B:35:0x0149, B:37:0x014f, B:38:0x0157, B:39:0x016d, B:41:0x017f, B:44:0x018a, B:45:0x0191, B:46:0x0192, B:49:0x01ad, B:51:0x01bb, B:53:0x01e0, B:59:0x01f8, B:64:0x0274, B:55:0x01e9, B:57:0x01ef, B:60:0x0235, B:61:0x0239, B:63:0x023f, B:68:0x0280, B:69:0x0287, B:70:0x0288, B:71:0x028d, B:72:0x028e, B:73:0x0295, B:74:0x0296, B:75:0x029d, B:76:0x029e, B:77:0x02a5), top: B:83:0x000e, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x023f A[Catch: all -> 0x02a6, LOOP:2: B:61:0x0239->B:63:0x023f, LOOP_END, TryCatch #1 {all -> 0x02a6, blocks: (B:3:0x000e, B:5:0x0015, B:7:0x001b, B:10:0x0053, B:12:0x0059, B:14:0x0067, B:16:0x007d, B:18:0x0093, B:19:0x00c1, B:21:0x00c7, B:22:0x00dc, B:24:0x00e2, B:26:0x00f7, B:27:0x00fb, B:28:0x010e, B:65:0x0277, B:29:0x0128, B:30:0x012f, B:31:0x0130, B:32:0x0135, B:33:0x0136, B:35:0x0149, B:37:0x014f, B:38:0x0157, B:39:0x016d, B:41:0x017f, B:44:0x018a, B:45:0x0191, B:46:0x0192, B:49:0x01ad, B:51:0x01bb, B:53:0x01e0, B:59:0x01f8, B:64:0x0274, B:55:0x01e9, B:57:0x01ef, B:60:0x0235, B:61:0x0239, B:63:0x023f, B:68:0x0280, B:69:0x0287, B:70:0x0288, B:71:0x028d, B:72:0x028e, B:73:0x0295, B:74:0x0296, B:75:0x029d, B:76:0x029e, B:77:0x02a5), top: B:83:0x000e, inners: #0 }] */
    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    public ConcurrentCamera bindToLifecycle(List<ConcurrentCamera.SingleCameraConfig> singleCameraConfigs) {
        Intrinsics.checkNotNullParameter(singleCameraConfigs, "singleCameraConfigs");
        Trace.beginSection("CX:bindToLifecycle-Concurrent");
        try {
            if (singleCameraConfigs.size() < 2) {
                throw new IllegalArgumentException("Concurrent camera needs two camera configs.");
            }
            if (singleCameraConfigs.size() > 2) {
                throw new IllegalArgumentException("Concurrent camera is only supporting two cameras at maximum.");
            }
            ConcurrentCamera.SingleCameraConfig singleCameraConfig = singleCameraConfigs.get(0);
            Intrinsics.checkNotNull(singleCameraConfig);
            ConcurrentCamera.SingleCameraConfig singleCameraConfig2 = singleCameraConfig;
            ConcurrentCamera.SingleCameraConfig singleCameraConfig3 = singleCameraConfigs.get(1);
            Intrinsics.checkNotNull(singleCameraConfig3);
            ConcurrentCamera.SingleCameraConfig singleCameraConfig4 = singleCameraConfig3;
            ArrayList arrayList = new ArrayList();
            if (Intrinsics.areEqual(singleCameraConfig2.getCameraSelector().getLensFacing(), singleCameraConfig4.getCameraSelector().getLensFacing())) {
                if (getCameraOperatingMode() == 2) {
                    throw new UnsupportedOperationException("Camera is already running, call unbindAll() before binding more cameras.");
                }
                if (!Intrinsics.areEqual(singleCameraConfig2.getLifecycleOwner(), singleCameraConfig4.getLifecycleOwner()) || !Intrinsics.areEqual(singleCameraConfig2.getUseCaseGroup().getViewPort(), singleCameraConfig4.getUseCaseGroup().getViewPort()) || !Intrinsics.areEqual(singleCameraConfig2.getUseCaseGroup().getEffects(), singleCameraConfig4.getUseCaseGroup().getEffects())) {
                    throw new IllegalArgumentException("Two camera configs need to have the same lifecycle owner, view port and effects.");
                }
                LifecycleOwner lifecycleOwner = singleCameraConfig2.getLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "getLifecycleOwner(...)");
                CameraSelector cameraSelector = singleCameraConfig2.getCameraSelector();
                Intrinsics.checkNotNullExpressionValue(cameraSelector, "getCameraSelector(...)");
                ViewPort viewPort = singleCameraConfig2.getUseCaseGroup().getViewPort();
                List<CameraEffect> effects = singleCameraConfig2.getUseCaseGroup().getEffects();
                Intrinsics.checkNotNullExpressionValue(effects, "getEffects(...)");
                ArrayList arrayList2 = new ArrayList();
                for (ConcurrentCamera.SingleCameraConfig singleCameraConfig5 : singleCameraConfigs) {
                    Intrinsics.checkNotNull(singleCameraConfig5);
                    for (UseCase useCase : singleCameraConfig5.getUseCaseGroup().getUseCases()) {
                        Intrinsics.checkNotNullExpressionValue(useCase, "next(...)");
                        UseCase useCase2 = useCase;
                        String physicalCameraId = singleCameraConfig5.getCameraSelector().getPhysicalCameraId();
                        if (physicalCameraId != null) {
                            useCase2.setPhysicalCameraId(physicalCameraId);
                        }
                    }
                    List<UseCase> useCases = singleCameraConfig5.getUseCaseGroup().getUseCases();
                    Intrinsics.checkNotNullExpressionValue(useCases, "getUseCases(...)");
                    arrayList2.addAll(useCases);
                }
                setCameraOperatingMode(1);
                arrayList.add(bindToLifecycleInternal$default(this, lifecycleOwner, cameraSelector, null, null, null, new LegacySessionConfig(arrayList2, viewPort, effects), 28, null));
            } else {
                Context context = getContext();
                Intrinsics.checkNotNull(context);
                if (context.getPackageManager().hasSystemFeature("android.hardware.camera.concurrent")) {
                    if (getCameraOperatingMode() == 1) {
                        throw new UnsupportedOperationException("Camera is already running, call unbindAll() before binding more cameras.");
                    }
                    ArrayList arrayList3 = new ArrayList();
                    try {
                        CameraSelector cameraSelector2 = singleCameraConfig2.getCameraSelector();
                        Intrinsics.checkNotNullExpressionValue(cameraSelector2, "getCameraSelector(...)");
                        CameraInfo cameraInfo = getCameraInfo(cameraSelector2);
                        CameraSelector cameraSelector3 = singleCameraConfig4.getCameraSelector();
                        Intrinsics.checkNotNullExpressionValue(cameraSelector3, "getCameraSelector(...)");
                        CameraInfo cameraInfo2 = getCameraInfo(cameraSelector3);
                        arrayList3.add(cameraInfo);
                        arrayList3.add(cameraInfo2);
                        if (!getActiveConcurrentCameraInfos().isEmpty() && !Intrinsics.areEqual(arrayList3, getActiveConcurrentCameraInfos())) {
                            throw new UnsupportedOperationException("Cameras are already running, call unbindAll() before binding more cameras.");
                        }
                        setCameraOperatingMode(2);
                        if (Objects.equals(singleCameraConfig2.getUseCaseGroup().getUseCases(), singleCameraConfig4.getUseCaseGroup().getUseCases()) && singleCameraConfig2.getUseCaseGroup().getUseCases().size() == 2) {
                            UseCase useCase3 = singleCameraConfig2.getUseCaseGroup().getUseCases().get(0);
                            UseCase useCase4 = singleCameraConfig2.getUseCaseGroup().getUseCases().get(1);
                            Intrinsics.checkNotNull(useCase3);
                            if (isVideoCapture(useCase3)) {
                                Intrinsics.checkNotNull(useCase4);
                                if (!isPreview(useCase4)) {
                                    if (isPreview(useCase3)) {
                                        Intrinsics.checkNotNull(useCase4);
                                        if (isVideoCapture(useCase4)) {
                                        }
                                    }
                                    for (ConcurrentCamera.SingleCameraConfig singleCameraConfig6 : singleCameraConfigs) {
                                        Intrinsics.checkNotNull(singleCameraConfig6);
                                        LifecycleOwner lifecycleOwner2 = singleCameraConfig6.getLifecycleOwner();
                                        Intrinsics.checkNotNullExpressionValue(lifecycleOwner2, "getLifecycleOwner(...)");
                                        CameraSelector cameraSelector4 = singleCameraConfig6.getCameraSelector();
                                        Intrinsics.checkNotNullExpressionValue(cameraSelector4, "getCameraSelector(...)");
                                        UseCaseGroup useCaseGroup = singleCameraConfig6.getUseCaseGroup();
                                        Intrinsics.checkNotNullExpressionValue(useCaseGroup, "getUseCaseGroup(...)");
                                        arrayList.add(bindToLifecycleInternal$default(this, lifecycleOwner2, cameraSelector4, null, null, null, new LegacySessionConfig(useCaseGroup), 28, null));
                                    }
                                }
                                LifecycleOwner lifecycleOwner3 = singleCameraConfig2.getLifecycleOwner();
                                Intrinsics.checkNotNullExpressionValue(lifecycleOwner3, "getLifecycleOwner(...)");
                                CameraSelector cameraSelector5 = singleCameraConfig2.getCameraSelector();
                                Intrinsics.checkNotNullExpressionValue(cameraSelector5, "getCameraSelector(...)");
                                CameraSelector cameraSelector6 = singleCameraConfig4.getCameraSelector();
                                CompositionSettings compositionSettings = singleCameraConfig2.getCompositionSettings();
                                Intrinsics.checkNotNullExpressionValue(compositionSettings, "getCompositionSettings(...)");
                                CompositionSettings compositionSettings2 = singleCameraConfig4.getCompositionSettings();
                                Intrinsics.checkNotNullExpressionValue(compositionSettings2, "getCompositionSettings(...)");
                                UseCaseGroup useCaseGroup2 = singleCameraConfig2.getUseCaseGroup();
                                Intrinsics.checkNotNullExpressionValue(useCaseGroup2, "getUseCaseGroup(...)");
                                arrayList.add(bindToLifecycleInternal(lifecycleOwner3, cameraSelector5, cameraSelector6, compositionSettings, compositionSettings2, new LegacySessionConfig(useCaseGroup2)));
                            } else {
                                if (isPreview(useCase3)) {
                                    Intrinsics.checkNotNull(useCase4);
                                    if (isVideoCapture(useCase4)) {
                                        LifecycleOwner lifecycleOwner4 = singleCameraConfig2.getLifecycleOwner();
                                        Intrinsics.checkNotNullExpressionValue(lifecycleOwner4, "getLifecycleOwner(...)");
                                        CameraSelector cameraSelector7 = singleCameraConfig2.getCameraSelector();
                                        Intrinsics.checkNotNullExpressionValue(cameraSelector7, "getCameraSelector(...)");
                                        CameraSelector cameraSelector8 = singleCameraConfig4.getCameraSelector();
                                        CompositionSettings compositionSettings3 = singleCameraConfig2.getCompositionSettings();
                                        Intrinsics.checkNotNullExpressionValue(compositionSettings3, "getCompositionSettings(...)");
                                        CompositionSettings compositionSettings4 = singleCameraConfig4.getCompositionSettings();
                                        Intrinsics.checkNotNullExpressionValue(compositionSettings4, "getCompositionSettings(...)");
                                        UseCaseGroup useCaseGroup3 = singleCameraConfig2.getUseCaseGroup();
                                        Intrinsics.checkNotNullExpressionValue(useCaseGroup3, "getUseCaseGroup(...)");
                                        arrayList.add(bindToLifecycleInternal(lifecycleOwner4, cameraSelector7, cameraSelector8, compositionSettings3, compositionSettings4, new LegacySessionConfig(useCaseGroup3)));
                                    }
                                }
                                while (r14.hasNext()) {
                                    Intrinsics.checkNotNull(singleCameraConfig6);
                                    LifecycleOwner lifecycleOwner5 = singleCameraConfig6.getLifecycleOwner();
                                    Intrinsics.checkNotNullExpressionValue(lifecycleOwner5, "getLifecycleOwner(...)");
                                    CameraSelector cameraSelector9 = singleCameraConfig6.getCameraSelector();
                                    Intrinsics.checkNotNullExpressionValue(cameraSelector9, "getCameraSelector(...)");
                                    UseCaseGroup useCaseGroup4 = singleCameraConfig6.getUseCaseGroup();
                                    Intrinsics.checkNotNullExpressionValue(useCaseGroup4, "getUseCaseGroup(...)");
                                    arrayList.add(bindToLifecycleInternal$default(this, lifecycleOwner5, cameraSelector9, null, null, null, new LegacySessionConfig(useCaseGroup4), 28, null));
                                }
                            }
                        } else {
                            while (r14.hasNext()) {
                                Intrinsics.checkNotNull(singleCameraConfig6);
                                LifecycleOwner lifecycleOwner6 = singleCameraConfig6.getLifecycleOwner();
                                Intrinsics.checkNotNullExpressionValue(lifecycleOwner6, "getLifecycleOwner(...)");
                                CameraSelector cameraSelector10 = singleCameraConfig6.getCameraSelector();
                                Intrinsics.checkNotNullExpressionValue(cameraSelector10, "getCameraSelector(...)");
                                UseCaseGroup useCaseGroup5 = singleCameraConfig6.getUseCaseGroup();
                                Intrinsics.checkNotNullExpressionValue(useCaseGroup5, "getUseCaseGroup(...)");
                                arrayList.add(bindToLifecycleInternal$default(this, lifecycleOwner6, cameraSelector10, null, null, null, new LegacySessionConfig(useCaseGroup5), 28, null));
                            }
                        }
                        setActiveConcurrentCameraInfos(arrayList3);
                    } catch (IllegalArgumentException unused) {
                        throw new IllegalArgumentException("Invalid camera selectors in camera configs.");
                    }
                } else {
                    throw new UnsupportedOperationException("Concurrent camera is not supported on the device.");
                }
            }
            ConcurrentCamera concurrentCamera = new ConcurrentCamera(arrayList);
            Trace.endSection();
            return concurrentCamera;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // androidx.camera.core.CameraProvider
    public List<CameraInfo> getAvailableCameraInfos() {
        Trace.beginSection("CX:getAvailableCameraInfos");
        try {
            ArrayList arrayList = new ArrayList();
            CameraX cameraX = this.cameraX;
            Intrinsics.checkNotNull(cameraX);
            LinkedHashSet<CameraInternal> cameras = cameraX.getCameraRepository().getCameras();
            Intrinsics.checkNotNullExpressionValue(cameras, "getCameras(...)");
            Iterator<CameraInternal> it = cameras.iterator();
            while (it.hasNext()) {
                CameraInfo cameraInfo = it.next().getCameraInfo();
                Intrinsics.checkNotNullExpressionValue(cameraInfo, "getCameraInfo(...)");
                arrayList.add(cameraInfo);
            }
            Trace.endSection();
            return arrayList;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // androidx.camera.core.CameraProvider
    public List<List<CameraInfo>> getAvailableConcurrentCameraInfos() {
        Trace.beginSection("CX:getAvailableConcurrentCameraInfos");
        try {
            Objects.requireNonNull(this.cameraX);
            CameraX cameraX = this.cameraX;
            Intrinsics.checkNotNull(cameraX);
            Objects.requireNonNull(cameraX.getCameraFactory().getCameraCoordinator());
            CameraX cameraX2 = this.cameraX;
            Intrinsics.checkNotNull(cameraX2);
            List<List<CameraSelector>> concurrentCameraSelectors = cameraX2.getCameraFactory().getCameraCoordinator().getConcurrentCameraSelectors();
            Intrinsics.checkNotNullExpressionValue(concurrentCameraSelectors, "getConcurrentCameraSelectors(...)");
            ArrayList arrayList = new ArrayList();
            for (List<CameraSelector> list : concurrentCameraSelectors) {
                ArrayList arrayList2 = new ArrayList();
                for (CameraSelector cameraSelector : list) {
                    try {
                        Intrinsics.checkNotNull(cameraSelector);
                        arrayList2.add(getCameraInfo(cameraSelector));
                    } catch (IllegalArgumentException unused) {
                    }
                }
                arrayList.add(arrayList2);
            }
            return arrayList;
        } finally {
            Trace.endSection();
        }
    }

    @Override // androidx.camera.core.CameraProvider
    public boolean isConcurrentCameraModeOn() {
        return getCameraOperatingMode() == 2;
    }

    static /* synthetic */ Camera bindToLifecycleInternal$default(LifecycleCameraProviderImpl lifecycleCameraProviderImpl, LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, CameraSelector cameraSelector2, CompositionSettings DEFAULT, CompositionSettings DEFAULT2, SessionConfig sessionConfig, int i, Object obj) {
        if ((i & 4) != 0) {
            cameraSelector2 = null;
        }
        CameraSelector cameraSelector3 = cameraSelector2;
        if ((i & 8) != 0) {
            DEFAULT = CompositionSettings.DEFAULT;
            Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
        }
        CompositionSettings compositionSettings = DEFAULT;
        if ((i & 16) != 0) {
            DEFAULT2 = CompositionSettings.DEFAULT;
            Intrinsics.checkNotNullExpressionValue(DEFAULT2, "DEFAULT");
        }
        return lifecycleCameraProviderImpl.bindToLifecycleInternal(lifecycleOwner, cameraSelector, cameraSelector3, compositionSettings, DEFAULT2, sessionConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Camera bindToLifecycleInternal(LifecycleOwner lifecycleOwner, CameraSelector primaryCameraSelector, CameraSelector secondaryCameraSelector, CompositionSettings primaryCompositionSettings, CompositionSettings secondaryCompositionSettings, SessionConfig sessionConfig) {
        CameraInternal cameraInternal;
        AdapterCameraInfo adapterCameraInfo;
        Trace.beginSection("CX:bindToLifecycle-internal");
        try {
            Threads.checkMainThread();
            Pair selectorsWithSessionFilter = getSelectorsWithSessionFilter(sessionConfig, primaryCameraSelector, secondaryCameraSelector);
            CameraSelector cameraSelector = (CameraSelector) selectorsWithSessionFilter.component1();
            CameraSelector cameraSelector2 = (CameraSelector) selectorsWithSessionFilter.component2();
            CameraX cameraX = this.cameraX;
            Intrinsics.checkNotNull(cameraX);
            CameraInternal cameraInternalSelect = cameraSelector.select(cameraX.getCameraRepository().getCameras());
            Intrinsics.checkNotNullExpressionValue(cameraInternalSelect, "select(...)");
            cameraInternalSelect.setPrimary(true);
            CameraInfo cameraInfo = getCameraInfo(cameraSelector);
            Intrinsics.checkNotNull(cameraInfo, "null cannot be cast to non-null type androidx.camera.core.impl.AdapterCameraInfo");
            AdapterCameraInfo adapterCameraInfo2 = (AdapterCameraInfo) cameraInfo;
            if (cameraSelector2 != null) {
                CameraX cameraX2 = this.cameraX;
                Intrinsics.checkNotNull(cameraX2);
                CameraInternal cameraInternalSelect2 = cameraSelector2.select(cameraX2.getCameraRepository().getCameras());
                cameraInternalSelect2.setPrimary(false);
                CameraInfo cameraInfo2 = getCameraInfo(cameraSelector2);
                Intrinsics.checkNotNull(cameraInfo2, "null cannot be cast to non-null type androidx.camera.core.impl.AdapterCameraInfo");
                adapterCameraInfo = (AdapterCameraInfo) cameraInfo2;
                cameraInternal = cameraInternalSelect2;
            } else {
                cameraInternal = null;
                adapterCameraInfo = null;
            }
            CameraIdentifier cameraIdentifierFromAdapterInfos = CameraIdentifier.Factory.fromAdapterInfos(adapterCameraInfo2, adapterCameraInfo);
            LifecycleCameraRepository lifecycleCameraRepository = this.lifecycleCameraRepository;
            Intrinsics.checkNotNull(lifecycleCameraRepository);
            LifecycleCamera lifecycleCamera = lifecycleCameraRepository.getLifecycleCamera(lifecycleOwner, cameraIdentifierFromAdapterInfos);
            LifecycleCameraRepository lifecycleCameraRepository2 = this.lifecycleCameraRepository;
            Intrinsics.checkNotNull(lifecycleCameraRepository2);
            Collection<LifecycleCamera> lifecycleCameras = lifecycleCameraRepository2.getLifecycleCameras();
            for (UseCase useCase : sessionConfig.getUseCases()) {
                for (LifecycleCamera lifecycleCamera2 : lifecycleCameras) {
                    Intrinsics.checkNotNullExpressionValue(lifecycleCamera2, "next(...)");
                    LifecycleCamera lifecycleCamera3 = lifecycleCamera2;
                    if (lifecycleCamera3.isBound(useCase) && !Intrinsics.areEqual(lifecycleCamera3.getLifecycleOwner(), lifecycleOwner)) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String str = String.format("Use case %s already bound to a different lifecycle.", Arrays.copyOf(new Object[]{useCase}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        throw new IllegalStateException(str);
                    }
                }
            }
            if (lifecycleCamera == null) {
                LifecycleCameraRepository lifecycleCameraRepository3 = this.lifecycleCameraRepository;
                Intrinsics.checkNotNull(lifecycleCameraRepository3);
                CameraX cameraX3 = this.cameraX;
                Intrinsics.checkNotNull(cameraX3);
                CameraUseCaseAdapter cameraUseCaseAdapterProvide = cameraX3.getCameraUseCaseAdapterProvider().provide(cameraInternalSelect, cameraInternal, adapterCameraInfo2, adapterCameraInfo, primaryCompositionSettings, secondaryCompositionSettings);
                CameraX cameraX4 = this.cameraX;
                Intrinsics.checkNotNull(cameraX4);
                lifecycleCamera = lifecycleCameraRepository3.createLifecycleCamera(lifecycleOwner, cameraUseCaseAdapterProvide, cameraX4.getRotationProvider());
            }
            if (!sessionConfig.getUseCases().isEmpty()) {
                LifecycleCameraRepository lifecycleCameraRepository4 = this.lifecycleCameraRepository;
                Intrinsics.checkNotNull(lifecycleCameraRepository4);
                Intrinsics.checkNotNull(lifecycleCamera);
                CameraX cameraX5 = this.cameraX;
                Intrinsics.checkNotNull(cameraX5);
                lifecycleCameraRepository4.bindToLifecycleCamera(lifecycleCamera, sessionConfig, cameraX5.getCameraFactory().getCameraCoordinator());
                this.lifecycleCameraKeys.add(LifecycleCameraRepository.Key.create(lifecycleOwner, cameraIdentifierFromAdapterInfos));
            } else {
                Intrinsics.checkNotNull(lifecycleCamera);
            }
            Trace.endSection();
            return lifecycleCamera;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<CameraSelector, CameraSelector> getSelectorsWithSessionFilter(SessionConfig sessionConfig, CameraSelector primaryCameraSelector, CameraSelector secondaryCameraSelector) {
        CameraFilter cameraFilter = sessionConfig.get_cameraFilter();
        if (cameraFilter == null) {
            return TuplesKt.to(primaryCameraSelector, secondaryCameraSelector);
        }
        CameraSelector cameraSelectorBuild = CameraSelector.Builder.fromSelector(primaryCameraSelector).addCameraFilter(cameraFilter).build();
        Intrinsics.checkNotNullExpressionValue(cameraSelectorBuild, "build(...)");
        return TuplesKt.to(cameraSelectorBuild, secondaryCameraSelector != null ? CameraSelector.Builder.fromSelector(secondaryCameraSelector).addCameraFilter(cameraFilter).build() : null);
    }

    @Override // androidx.camera.core.CameraProvider
    public CameraInfo getCameraInfo(CameraSelector cameraSelector) {
        Object adapterCameraInfo;
        Intrinsics.checkNotNullParameter(cameraSelector, "cameraSelector");
        Trace.beginSection("CX:getCameraInfo");
        try {
            CameraX cameraX = this.cameraX;
            Intrinsics.checkNotNull(cameraX);
            CameraInfoInternal cameraInfoInternal = cameraSelector.select(cameraX.getCameraRepository().getCameras()).getCameraInfo();
            Intrinsics.checkNotNullExpressionValue(cameraInfoInternal, "getCameraInfoInternal(...)");
            CameraConfig cameraConfig = getCameraConfig(cameraSelector, cameraInfoInternal);
            String cameraId = cameraInfoInternal.getCameraId();
            Intrinsics.checkNotNullExpressionValue(cameraId, "getCameraId(...)");
            CameraIdentifier cameraIdentifierCreate = CameraIdentifier.Factory.create(cameraId, null, cameraConfig.getCompatibilityId());
            synchronized (this.lock) {
                adapterCameraInfo = this.cameraInfoMap.get(cameraIdentifierCreate);
                if (adapterCameraInfo == null) {
                    adapterCameraInfo = new AdapterCameraInfo(cameraInfoInternal, cameraConfig);
                    this.cameraInfoMap.put(cameraIdentifierCreate, adapterCameraInfo);
                }
                Unit unit = Unit.INSTANCE;
            }
            AdapterCameraInfo adapterCameraInfo2 = (AdapterCameraInfo) adapterCameraInfo;
            Trace.endSection();
            return adapterCameraInfo2;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // androidx.camera.core.CameraProvider
    public CameraInfo getCameraInfo(CameraSelector cameraSelector, SessionConfig sessionConfig) {
        Intrinsics.checkNotNullParameter(cameraSelector, "cameraSelector");
        Intrinsics.checkNotNullParameter(sessionConfig, "sessionConfig");
        CameraFilter cameraFilter = sessionConfig.get_cameraFilter();
        if (cameraFilter != null) {
            CameraSelector cameraSelectorBuild = CameraSelector.Builder.fromSelector(cameraSelector).addCameraFilter(cameraFilter).build();
            Intrinsics.checkNotNullExpressionValue(cameraSelectorBuild, "build(...)");
            CameraInfo cameraInfo = getCameraInfo(cameraSelectorBuild);
            if (cameraInfo != null) {
                return cameraInfo;
            }
        }
        return getCameraInfo(cameraSelector);
    }

    @Override // androidx.camera.core.CameraProvider
    public void addCameraPresenceListener(Executor executor, CameraPresenceListener listener) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(listener, "listener");
        CameraX cameraX = this.cameraX;
        Intrinsics.checkNotNull(cameraX);
        cameraX.getCameraAvailabilityProvider().addCameraPresenceListener(listener, executor);
    }

    @Override // androidx.camera.core.CameraProvider
    public void removeCameraPresenceListener(CameraPresenceListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        CameraX cameraX = this.cameraX;
        Intrinsics.checkNotNull(cameraX);
        cameraX.getCameraAvailabilityProvider().removeCameraPresenceListener(listener);
    }

    @Override // androidx.camera.core.CameraPresenceListener
    public void onCamerasRemoved(Set<CameraIdentifier> removedCameraIds) {
        Intrinsics.checkNotNullParameter(removedCameraIds, "removedCameraIds");
        Threads.checkMainThread();
        synchronized (this.lock) {
            for (CameraIdentifier cameraIdentifier : removedCameraIds) {
                Set<CameraIdentifier> setKeySet = this.cameraInfoMap.keySet();
                ArrayList arrayList = new ArrayList();
                for (Object obj : setKeySet) {
                    if (Intrinsics.areEqual(((CameraIdentifier) obj).getCameraIds(), cameraIdentifier.getCameraIds())) {
                        arrayList.add(obj);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    this.cameraInfoMap.remove((CameraIdentifier) it.next());
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isVideoCapture(UseCase useCase) {
        return useCase.getCurrentConfig().containsOption(UseCaseConfig.OPTION_CAPTURE_TYPE) && useCase.getCurrentConfig().getCaptureType() == UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isPreview(UseCase useCase) {
        return useCase instanceof Preview;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CameraConfig getCameraConfig(CameraSelector cameraSelector, CameraInfo cameraInfo) {
        Iterator<CameraFilter> it = cameraSelector.getCameraFilterSet().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        CameraConfig cameraConfig = null;
        while (it.hasNext()) {
            CameraFilter next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            CameraFilter cameraFilter = next;
            if (!Intrinsics.areEqual(cameraFilter.getIdentifier(), CameraFilter.DEFAULT_ID)) {
                CameraConfigProvider configProvider = ExtendedCameraConfigProviderStore.getConfigProvider(cameraFilter.getIdentifier());
                Context context = this.context;
                Intrinsics.checkNotNull(context);
                CameraConfig config = configProvider.getConfig(cameraInfo, context);
                if (config == null) {
                    continue;
                } else {
                    if (cameraConfig != null) {
                        throw new IllegalArgumentException("Cannot apply multiple extended camera configs at the same time.");
                    }
                    cameraConfig = config;
                }
            }
        }
        return cameraConfig == null ? CameraConfigs.defaultConfig() : cameraConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getCameraOperatingMode() {
        if (!isInitialized()) {
            return 0;
        }
        CameraX cameraX = this.cameraX;
        Intrinsics.checkNotNull(cameraX);
        return cameraX.getCameraFactory().getCameraCoordinator().getCameraOperatingMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCameraOperatingMode(int i) {
        if (isInitialized()) {
            CameraX cameraX = this.cameraX;
            Intrinsics.checkNotNull(cameraX);
            cameraX.getCameraFactory().getCameraCoordinator().setCameraOperatingMode(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<CameraInfo> getActiveConcurrentCameraInfos() {
        if (!isInitialized()) {
            return CollectionsKt.emptyList();
        }
        CameraX cameraX = this.cameraX;
        Intrinsics.checkNotNull(cameraX);
        List<CameraInfo> activeConcurrentCameraInfos = cameraX.getCameraFactory().getCameraCoordinator().getActiveConcurrentCameraInfos();
        Intrinsics.checkNotNullExpressionValue(activeConcurrentCameraInfos, "getActiveConcurrentCameraInfos(...)");
        return activeConcurrentCameraInfos;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setActiveConcurrentCameraInfos(List<? extends CameraInfo> list) {
        if (isInitialized()) {
            CameraX cameraX = this.cameraX;
            Intrinsics.checkNotNull(cameraX);
            cameraX.getCameraFactory().getCameraCoordinator().setActiveConcurrentCameraInfos(list);
        }
    }
}

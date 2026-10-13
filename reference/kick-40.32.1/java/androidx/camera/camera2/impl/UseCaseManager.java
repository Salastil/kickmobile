package androidx.camera.camera2.impl;

import android.content.Context;
import android.media.MediaCodec;
import android.util.Pair;
import android.util.Size;
import androidx.camera.camera2.adapter.CameraStateAdapter;
import androidx.camera.camera2.adapter.GraphStateToCameraStateAdapter;
import androidx.camera.camera2.adapter.SessionConfigAdapter;
import androidx.camera.camera2.adapter.SupportedSurfaceCombination;
import androidx.camera.camera2.adapter.ZslControl;
import androidx.camera.camera2.config.CameraScope;
import androidx.camera.camera2.config.UseCaseCameraComponent;
import androidx.camera.camera2.config.UseCaseCameraConfig;
import androidx.camera.camera2.config.UseCaseGraphContext;
import androidx.camera.camera2.internal.DynamicRangeResolver;
import androidx.camera.camera2.interop.Camera2CameraControl;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.CameraPipe;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.camera.core.UseCase;
import androidx.camera.core.concurrent.CameraCoordinator;
import androidx.camera.core.featuregroup.impl.FeatureCombinationQuery;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.StreamUseCase;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.UseCaseUtil;
import androidx.camera.core.streamsharing.StreamSharing;
import androidx.camera.core.streamsharing.StreamSharingConfig;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: UseCaseManager.kt */
/* JADX INFO: loaded from: classes.dex */
@CameraScope
@Metadata(d1 = {"\u0000¶\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0097\u0001B©\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0014\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0014\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!\u0012\u0006\u0010\"\u001a\u00020#\u0012\u0006\u0010$\u001a\u00020%¢\u0006\u0004\b&\u0010'J\u0015\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u000205H\u0000¢\u0006\u0002\bWJ\u000f\u0010X\u001a\u0004\u0018\u00010CH\u0000¢\u0006\u0002\bYJ\u0014\u0010Z\u001a\u00020U2\f\u0010[\u001a\b\u0012\u0004\u0012\u0002020\\J\u0014\u0010]\u001a\u00020U2\f\u0010[\u001a\b\u0012\u0004\u0012\u0002020\\J\u000e\u0010^\u001a\u00020U2\u0006\u0010_\u001a\u000202J\u000e\u0010`\u001a\u00020U2\u0006\u0010_\u001a\u000202J\u000e\u0010a\u001a\u00020U2\u0006\u0010_\u001a\u000202J\u000e\u0010b\u001a\u00020U2\u0006\u0010_\u001a\u000202J\u000e\u0010c\u001a\u00020U2\u0006\u00109\u001a\u000205J\u0015\u0010d\u001a\u0004\u0018\u00010U2\u0006\u0010e\u001a\u000205¢\u0006\u0002\u0010fJ\u000e\u0010g\u001a\u00020UH\u0086@¢\u0006\u0002\u0010hJ\b\u0010i\u001a\u00020jH\u0016J\b\u0010k\u001a\u00020UH\u0003J\u0016\u0010l\u001a\u00020U2\f\u0010m\u001a\b\u0012\u0004\u0012\u0002020nH\u0002J\u0016\u0010o\u001a\u00020U2\f\u0010p\u001a\b\u0012\u0004\u0012\u0002020nH\u0003J'\u0010q\u001a\u0002082\u0006\u0010r\u001a\u00020s2\u0006\u0010t\u001a\u00020u2\b\b\u0002\u0010v\u001a\u000205H\u0001¢\u0006\u0002\bwJ\b\u0010x\u001a\u00020UH\u0003J\u0010\u0010y\u001a\u00020U2\u0006\u0010z\u001a\u000208H\u0003J\u0015\u0010{\u001a\u00020U2\u0006\u0010|\u001a\u00020DH\u0000¢\u0006\u0002\b}J\u0010\u0010~\u001a\u00020U2\u0006\u0010z\u001a\u000208H\u0003J\u000e\u0010\u007f\u001a\b\u0012\u0004\u0012\u0002020nH\u0003J\u000f\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u0002020nH\u0007J\u0017\u0010\u0081\u0001\u001a\u0002052\f\u0010m\u001a\b\u0012\u0004\u0012\u0002020nH\u0003J\u0017\u0010\u0082\u0001\u001a\u0002052\f\u0010m\u001a\b\u0012\u0004\u0012\u0002020nH\u0003J\u0014\u0010\u0083\u0001\u001a\u000205*\t\u0012\u0004\u0012\u0002020\u0084\u0001H\u0002J\u0017\u0010\u0085\u0001\u001a\u0002052\f\u0010m\u001a\b\u0012\u0004\u0012\u0002020nH\u0003J\u0017\u0010\u0086\u0001\u001a\u0002052\f\u0010m\u001a\b\u0012\u0004\u0012\u0002020nH\u0003J\t\u0010\u0087\u0001\u001a\u00020UH\u0003J\t\u0010\u0088\u0001\u001a\u00020UH\u0003J\u0014\u0010\u0089\u0001\u001a\u000205*\t\u0012\u0004\u0012\u0002020\u0084\u0001H\u0002J\n\u0010\u008a\u0001\u001a\u00030\u008b\u0001H\u0002J\u001a\u0010\u008c\u0001\u001a\u00030\u008b\u00012\u000e\u0010\u008d\u0001\u001a\t\u0012\u0005\u0012\u00030\u008e\u00010\\H\u0002J\u001b\u0010\u008f\u0001\u001a\t\u0012\u0005\u0012\u00030\u008e\u00010\\*\t\u0012\u0004\u0012\u0002020\u0084\u0001H\u0002J\u001d\u0010\u0090\u0001\u001a\u0012\u0012\u000e\u0012\f S*\u0005\u0018\u00010\u0091\u00010\u0091\u00010\\*\u000202H\u0002J\u0014\u0010\u0092\u0001\u001a\u000205*\t\u0012\u0004\u0012\u0002020\u0084\u0001H\u0002J\u001b\u0010\u0093\u0001\u001a\t\u0012\u0005\u0012\u00030\u0094\u00010\\*\t\u0012\u0004\u0012\u0002020\u0084\u0001H\u0002J\n\u0010\u0095\u0001\u001a\u00030\u0094\u0001H\u0002J\t\u0010\u0096\u0001\u001a\u00020UH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010+\u001a\u0004\u0018\u00010*2\b\u0010)\u001a\u0004\u0018\u00010*8@@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0016\u00100\u001a\b\u0012\u0004\u0012\u000202018\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0016\u00103\u001a\b\u0012\u0004\u0012\u000202018\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u00104\u001a\u0002058\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u00106\u001a\u0002058\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u00107\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u00109\u001a\u0002058\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0016\u0010:\u001a\b\u0012\u0004\u0012\u000202018\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010A\u001a\u000e\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020D0BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010G\u001a\u0004\u0018\u00010H8F¢\u0006\u0006\u001a\u0004\bI\u0010JR\u0013\u0010K\u001a\u0004\u0018\u00010L8F¢\u0006\u0006\u001a\u0004\bM\u0010NR\u0014\u0010O\u001a\b\u0012\u0004\u0012\u00020Q0PX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010R\u001a\u0010\u0012\f\u0012\n S*\u0004\u0018\u00010\u000e0\u000e01X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0098\u0001"}, d2 = {"Landroidx/camera/camera2/impl/UseCaseManager;", "", "cameraPipe", "Landroidx/camera/camera2/pipe/CameraPipe;", "cameraCoordinator", "Landroidx/camera/core/concurrent/CameraCoordinator;", "builder", "Landroidx/camera/camera2/config/UseCaseCameraComponent$Builder;", "zslControl", "Landroidx/camera/camera2/adapter/ZslControl;", "lowLightBoostControl", "Landroidx/camera/camera2/impl/LowLightBoostControl;", "controls", "Ljava/util/Set;", "Landroidx/camera/camera2/impl/UseCaseCameraControl;", "camera2CameraControl", "Landroidx/camera/camera2/interop/Camera2CameraControl;", "cameraStateAdapter", "Landroidx/camera/camera2/adapter/CameraStateAdapter;", "cameraInternal", "Ljavax/inject/Provider;", "Landroidx/camera/core/impl/CameraInternal;", "useCaseThreads", "Landroidx/camera/camera2/impl/UseCaseThreads;", "cameraInfoInternal", "Landroidx/camera/core/impl/CameraInfoInternal;", "encoderProfilesProvider", "Landroidx/camera/core/impl/EncoderProfilesProvider;", "cameraProperties", "Landroidx/camera/camera2/impl/CameraProperties;", "cameraXConfig", "Landroidx/camera/core/CameraXConfig;", "cameraGraphConfigProvider", "Landroidx/camera/camera2/impl/CameraGraphConfigProvider;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "displayInfoManager", "Landroidx/camera/camera2/impl/DisplayInfoManager;", "<init>", "(Landroidx/camera/camera2/pipe/CameraPipe;Landroidx/camera/core/concurrent/CameraCoordinator;Landroidx/camera/camera2/config/UseCaseCameraComponent$Builder;Landroidx/camera/camera2/adapter/ZslControl;Landroidx/camera/camera2/impl/LowLightBoostControl;Ljava/util/Set;Landroidx/camera/camera2/interop/Camera2CameraControl;Landroidx/camera/camera2/adapter/CameraStateAdapter;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Landroidx/camera/core/impl/EncoderProfilesProvider;Landroidx/camera/camera2/impl/CameraProperties;Landroidx/camera/core/CameraXConfig;Landroidx/camera/camera2/impl/CameraGraphConfigProvider;Landroid/content/Context;Landroidx/camera/camera2/impl/DisplayInfoManager;)V", "lock", "value", "Landroidx/camera/core/impl/SessionProcessor;", "sessionProcessor", "getSessionProcessor$camera_camera2", "()Landroidx/camera/core/impl/SessionProcessor;", "setSessionProcessor$camera_camera2", "(Landroidx/camera/core/impl/SessionProcessor;)V", "attachedUseCases", "", "Landroidx/camera/core/UseCase;", "activeUseCases", "activeResumeEnabled", "", "shouldCreateCameraGraphImmediately", "deferredUseCaseCameraConfig", "Landroidx/camera/camera2/config/UseCaseCameraConfig;", "isPrimary", "pendingUseCasesToNotifyCameraControlReady", "meteringRepeating", "Landroidx/camera/camera2/impl/MeteringRepeating;", "supportedSurfaceCombination", "Landroidx/camera/camera2/adapter/SupportedSurfaceCombination;", "dynamicRangeResolver", "Landroidx/camera/camera2/internal/DynamicRangeResolver;", "defaultCameraGraphFactory", "Lkotlin/Function1;", "Landroidx/camera/camera2/pipe/CameraGraph$Config;", "Landroidx/camera/camera2/pipe/CameraGraph;", "_activeComponent", "Landroidx/camera/camera2/config/UseCaseCameraComponent;", "camera", "Landroidx/camera/camera2/impl/UseCaseCamera;", "getCamera", "()Landroidx/camera/camera2/impl/UseCaseCamera;", "useCaseGraphContext", "Landroidx/camera/camera2/config/UseCaseGraphContext;", "getUseCaseGraphContext", "()Landroidx/camera/camera2/config/UseCaseGraphContext;", "closingCameraJobs", "", "Lkotlinx/coroutines/Job;", "allControls", "kotlin.jvm.PlatformType", "setCameraGraphCreationMode", "", "createImmediately", "setCameraGraphCreationMode$camera_camera2", "getDeferredCameraGraphConfig", "getDeferredCameraGraphConfig$camera_camera2", "attach", "useCases", "", "detach", "activate", "useCase", "deactivate", "update", "reset", "setPrimary", "setActiveResumeMode", "enabled", "(Z)Lkotlin/Unit;", "close", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toString", "", "refreshRunningUseCases", "updateRunningUseCases", "runningUseCases", "", "refreshAttachedUseCases", "newUseCases", "createUseCaseCameraConfig", "sessionConfigAdapter", "Landroidx/camera/camera2/adapter/SessionConfigAdapter;", "graphStateToCameraStateAdapter", "Landroidx/camera/camera2/adapter/GraphStateToCameraStateAdapter;", "isExtensions", "createUseCaseCameraConfig$camera_camera2", "closeCurrentUseCases", "tryResumeUseCaseManager", "useCaseCameraConfig", "resumeDeferredComponentCreation", "cameraGraph", "resumeDeferredComponentCreation$camera_camera2", "beginComponentCreation", "getRunningUseCases", "getRunningUseCasesForTest", "addOrRemoveRepeatingUseCase", "isMeteringRepeatingRequired", "shouldForceRepeatingStream", "", "shouldAddRepeatingUseCase", "shouldRemoveRepeatingUseCase", "addRepeatingUseCase", "removeRepeatingUseCase", "isMeteringCombinationSupported", "getCameraMode", "", "getRequiredMaxBitDepth", "attachedSurfaceInfoList", "Landroidx/camera/core/impl/AttachedSurfaceInfo;", "getAttachedSurfaceInfoList", "getCaptureTypes", "Landroidx/camera/core/impl/UseCaseConfigFactory$CaptureType;", "isUltraHdrOn", "getSessionSurfacesConfigs", "Landroidx/camera/core/impl/SurfaceConfig;", "createMeteringRepeatingSurfaceConfig", "updateZslDisabledByUseCaseConfigStatus", "RunningUseCasesChangeListener", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UseCaseManager {
    private volatile UseCaseCameraComponent _activeComponent;
    private boolean activeResumeEnabled;
    private final Set<UseCase> activeUseCases;
    private final Set<UseCaseCameraControl> allControls;
    private final Set<UseCase> attachedUseCases;
    private final UseCaseCameraComponent.Builder builder;
    private final Camera2CameraControl camera2CameraControl;
    private final CameraCoordinator cameraCoordinator;
    private final CameraGraphConfigProvider cameraGraphConfigProvider;
    private final Provider<CameraInfoInternal> cameraInfoInternal;
    private final Provider<CameraInternal> cameraInternal;
    private final CameraPipe cameraPipe;
    private final CameraProperties cameraProperties;
    private final CameraStateAdapter cameraStateAdapter;
    private final CameraXConfig cameraXConfig;
    private final List<Job> closingCameraJobs;
    private final Set<UseCaseCameraControl> controls;
    private final Function1<CameraGraph.Config, CameraGraph> defaultCameraGraphFactory;
    private UseCaseCameraConfig deferredUseCaseCameraConfig;
    private final DynamicRangeResolver dynamicRangeResolver;
    private final EncoderProfilesProvider encoderProfilesProvider;
    private boolean isPrimary;
    private final Object lock;
    private final LowLightBoostControl lowLightBoostControl;
    private final MeteringRepeating meteringRepeating;
    private final Set<UseCase> pendingUseCasesToNotifyCameraControlReady;
    private SessionProcessor sessionProcessor;
    private boolean shouldCreateCameraGraphImmediately;
    private final SupportedSurfaceCombination supportedSurfaceCombination;
    private final Provider<UseCaseThreads> useCaseThreads;
    private final ZslControl zslControl;

    /* JADX INFO: compiled from: UseCaseManager.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/impl/UseCaseManager$RunningUseCasesChangeListener;", "", "onRunningUseCasesChanged", "", "runningUseCases", "", "Landroidx/camera/core/UseCase;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface RunningUseCasesChangeListener {
        void onRunningUseCasesChanged(Set<? extends UseCase> runningUseCases);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CameraGraph resumeDeferredComponentCreation$lambda$0$0(CameraGraph cameraGraph, CameraGraph.Config config) {
        Intrinsics.checkNotNullParameter(config, "<unused var>");
        return cameraGraph;
    }

    @Inject
    public UseCaseManager(CameraPipe cameraPipe, CameraCoordinator cameraCoordinator, UseCaseCameraComponent.Builder builder, ZslControl zslControl, LowLightBoostControl lowLightBoostControl, Set<UseCaseCameraControl> controls, Camera2CameraControl camera2CameraControl, CameraStateAdapter cameraStateAdapter, Provider<CameraInternal> cameraInternal, Provider<UseCaseThreads> useCaseThreads, Provider<CameraInfoInternal> cameraInfoInternal, EncoderProfilesProvider encoderProfilesProvider, CameraProperties cameraProperties, CameraXConfig cameraXConfig, CameraGraphConfigProvider cameraGraphConfigProvider, Context context, DisplayInfoManager displayInfoManager) {
        Intrinsics.checkNotNullParameter(cameraPipe, "cameraPipe");
        Intrinsics.checkNotNullParameter(cameraCoordinator, "cameraCoordinator");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(zslControl, "zslControl");
        Intrinsics.checkNotNullParameter(lowLightBoostControl, "lowLightBoostControl");
        Intrinsics.checkNotNullParameter(controls, "controls");
        Intrinsics.checkNotNullParameter(camera2CameraControl, "camera2CameraControl");
        Intrinsics.checkNotNullParameter(cameraStateAdapter, "cameraStateAdapter");
        Intrinsics.checkNotNullParameter(cameraInternal, "cameraInternal");
        Intrinsics.checkNotNullParameter(useCaseThreads, "useCaseThreads");
        Intrinsics.checkNotNullParameter(cameraInfoInternal, "cameraInfoInternal");
        Intrinsics.checkNotNullParameter(encoderProfilesProvider, "encoderProfilesProvider");
        Intrinsics.checkNotNullParameter(cameraProperties, "cameraProperties");
        Intrinsics.checkNotNullParameter(cameraXConfig, "cameraXConfig");
        Intrinsics.checkNotNullParameter(cameraGraphConfigProvider, "cameraGraphConfigProvider");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(displayInfoManager, "displayInfoManager");
        this.cameraPipe = cameraPipe;
        this.cameraCoordinator = cameraCoordinator;
        this.builder = builder;
        this.zslControl = zslControl;
        this.lowLightBoostControl = lowLightBoostControl;
        this.controls = controls;
        this.camera2CameraControl = camera2CameraControl;
        this.cameraStateAdapter = cameraStateAdapter;
        this.cameraInternal = cameraInternal;
        this.useCaseThreads = useCaseThreads;
        this.cameraInfoInternal = cameraInfoInternal;
        this.encoderProfilesProvider = encoderProfilesProvider;
        this.cameraProperties = cameraProperties;
        this.cameraXConfig = cameraXConfig;
        this.cameraGraphConfigProvider = cameraGraphConfigProvider;
        this.lock = new Object();
        this.attachedUseCases = new LinkedHashSet();
        this.activeUseCases = new LinkedHashSet();
        this.shouldCreateCameraGraphImmediately = true;
        this.isPrimary = true;
        this.pendingUseCasesToNotifyCameraControlReady = new LinkedHashSet();
        this.meteringRepeating = new MeteringRepeating.Builder(cameraProperties, displayInfoManager).build();
        this.supportedSurfaceCombination = new SupportedSurfaceCombination(context, cameraProperties.getMetadata(), encoderProfilesProvider, FeatureCombinationQuery.NO_OP_FEATURE_COMBINATION_QUERY);
        this.dynamicRangeResolver = new DynamicRangeResolver(cameraProperties.getMetadata());
        this.defaultCameraGraphFactory = new Function1() { // from class: androidx.camera.camera2.impl.UseCaseManager$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UseCaseManager.defaultCameraGraphFactory$lambda$0(this.f$0, (CameraGraph.Config) obj);
            }
        };
        this.closingCameraJobs = new ArrayList();
        Set<UseCaseCameraControl> mutableSet = CollectionsKt.toMutableSet(controls);
        mutableSet.add(camera2CameraControl);
        this.allControls = mutableSet;
    }

    public final SessionProcessor getSessionProcessor$camera_camera2() {
        SessionProcessor sessionProcessor;
        synchronized (this.lock) {
            sessionProcessor = this.sessionProcessor;
        }
        return sessionProcessor;
    }

    public final void setSessionProcessor$camera_camera2(SessionProcessor sessionProcessor) {
        synchronized (this.lock) {
            this.sessionProcessor = sessionProcessor;
            Unit unit = Unit.INSTANCE;
        }
    }

    static final CameraGraph defaultCameraGraphFactory$lambda$0(UseCaseManager useCaseManager, CameraGraph.Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        return useCaseManager.cameraPipe.createCameraGraph(config);
    }

    public final UseCaseCamera getCamera() {
        UseCaseCameraComponent useCaseCameraComponent = this._activeComponent;
        if (useCaseCameraComponent != null) {
            return useCaseCameraComponent.getUseCaseCamera();
        }
        return null;
    }

    public final UseCaseGraphContext getUseCaseGraphContext() {
        UseCaseCameraComponent useCaseCameraComponent = this._activeComponent;
        if (useCaseCameraComponent != null) {
            return useCaseCameraComponent.getUseCaseGraphContext();
        }
        return null;
    }

    public final void setCameraGraphCreationMode$camera_camera2(boolean createImmediately) {
        synchronized (this.lock) {
            this.shouldCreateCameraGraphImmediately = createImmediately;
            if (createImmediately) {
                this.deferredUseCaseCameraConfig = null;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final CameraGraph.Config getDeferredCameraGraphConfig$camera_camera2() {
        CameraGraph.Config cameraGraphConfig;
        synchronized (this.lock) {
            UseCaseCameraConfig useCaseCameraConfig = this.deferredUseCaseCameraConfig;
            cameraGraphConfig = useCaseCameraConfig != null ? useCaseCameraConfig.getCameraGraphConfig() : null;
        }
        return cameraGraphConfig;
    }

    public final void attach(List<? extends UseCase> useCases) {
        Intrinsics.checkNotNullParameter(useCases, "useCases");
        synchronized (this.lock) {
            if (useCases.isEmpty()) {
                Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                if (Logger.isWarnEnabled(Log.TAG)) {
                    android.util.Log.w(Camera2Logger.TRUNCATED_TAG, "Attach [] from " + this + " (Ignored)");
                }
                return;
            }
            Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "Attaching " + useCases + " from " + this);
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : useCases) {
                if (!this.attachedUseCases.contains((UseCase) obj)) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                ((UseCase) it.next()).onSessionStart();
            }
            if (this.attachedUseCases.addAll(useCases) && !addOrRemoveRepeatingUseCase(getRunningUseCases())) {
                updateZslDisabledByUseCaseConfigStatus();
                this.lowLightBoostControl.onSessionConfigChanged(CollectionsKt.toList(this.attachedUseCases));
                refreshAttachedUseCases(this.attachedUseCases);
            }
            if (!this.shouldCreateCameraGraphImmediately) {
                this.pendingUseCasesToNotifyCameraControlReady.addAll(arrayList2);
            } else {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ((UseCase) it2.next()).onCameraControlReady();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void detach(List<? extends UseCase> useCases) {
        Intrinsics.checkNotNullParameter(useCases, "useCases");
        synchronized (this.lock) {
            if (useCases.isEmpty()) {
                Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                if (Logger.isWarnEnabled(Log.TAG)) {
                    android.util.Log.w(Camera2Logger.TRUNCATED_TAG, "Detaching [] from " + this + " (Ignored)");
                }
                return;
            }
            Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "Detaching " + useCases + " from " + this);
            }
            this.activeUseCases.removeAll(useCases);
            for (UseCase useCase : useCases) {
                if (this.attachedUseCases.contains(useCase)) {
                    useCase.onSessionStop();
                }
            }
            if (this.attachedUseCases.removeAll(useCases)) {
                if (addOrRemoveRepeatingUseCase(getRunningUseCases())) {
                    return;
                }
                if (this.attachedUseCases.isEmpty()) {
                    this.zslControl.setZslDisabledByUserCaseConfig(false);
                    this.lowLightBoostControl.onSessionConfigChanged(CollectionsKt.emptyList());
                } else {
                    updateZslDisabledByUseCaseConfigStatus();
                    this.lowLightBoostControl.onSessionConfigChanged(CollectionsKt.toList(this.attachedUseCases));
                }
                refreshAttachedUseCases(this.attachedUseCases);
            }
            this.pendingUseCasesToNotifyCameraControlReady.removeAll(useCases);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void activate(UseCase useCase) {
        Intrinsics.checkNotNullParameter(useCase, "useCase");
        synchronized (this.lock) {
            if (this.activeUseCases.add(useCase)) {
                refreshRunningUseCases();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void deactivate(UseCase useCase) {
        Intrinsics.checkNotNullParameter(useCase, "useCase");
        synchronized (this.lock) {
            if (this.activeUseCases.remove(useCase)) {
                refreshRunningUseCases();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void update(UseCase useCase) {
        Intrinsics.checkNotNullParameter(useCase, "useCase");
        synchronized (this.lock) {
            if (this.attachedUseCases.contains(useCase)) {
                refreshRunningUseCases();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void reset(UseCase useCase) {
        Intrinsics.checkNotNullParameter(useCase, "useCase");
        synchronized (this.lock) {
            if (this.attachedUseCases.contains(useCase)) {
                refreshAttachedUseCases(this.attachedUseCases);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void setPrimary(boolean isPrimary) {
        synchronized (this.lock) {
            this.isPrimary = isPrimary;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final Unit setActiveResumeMode(boolean enabled) {
        Unit unit;
        synchronized (this.lock) {
            this.activeResumeEnabled = enabled;
            UseCaseCamera camera = getCamera();
            if (camera != null) {
                camera.setActiveResumeMode(enabled);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
        }
        return unit;
    }

    public final Object close(Continuation<? super Unit> continuation) {
        List list;
        synchronized (this.lock) {
            closeCurrentUseCases();
            this.meteringRepeating.onUnbind();
            list = CollectionsKt.toList(this.closingCameraJobs);
        }
        Object objJoinAll = AwaitKt.joinAll(list, continuation);
        return objJoinAll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objJoinAll : Unit.INSTANCE;
    }

    public String toString() {
        return "UseCaseManager<" + this.cameraGraphConfigProvider + Typography.greater;
    }

    private final void refreshRunningUseCases() {
        if (this.attachedUseCases.isEmpty()) {
            return;
        }
        Set<UseCase> runningUseCases = getRunningUseCases();
        if (shouldAddRepeatingUseCase(runningUseCases)) {
            addRepeatingUseCase();
        } else if (shouldRemoveRepeatingUseCase(runningUseCases)) {
            removeRepeatingUseCase();
        } else {
            updateRunningUseCases(runningUseCases);
        }
    }

    private final void updateRunningUseCases(Set<? extends UseCase> runningUseCases) {
        UseCaseCamera camera = getCamera();
        if (camera != null) {
            camera.updateRepeatingRequestAsync(this.isPrimary, runningUseCases);
            for (UseCaseCameraControl useCaseCameraControl : this.allControls) {
                if (useCaseCameraControl instanceof RunningUseCasesChangeListener) {
                    ((RunningUseCasesChangeListener) useCaseCameraControl).onRunningUseCasesChanged(runningUseCases);
                }
            }
        }
    }

    private final void refreshAttachedUseCases(Set<? extends UseCase> newUseCases) {
        Pair<Integer, Integer> implementationType;
        Integer num;
        closeCurrentUseCases();
        List list = CollectionsKt.toList(newUseCases);
        if (list.isEmpty()) {
            for (UseCaseCameraControl useCaseCameraControl : this.allControls) {
                useCaseCameraControl.setRequestControl(null);
                useCaseCameraControl.reset();
            }
            return;
        }
        if (!this.shouldCreateCameraGraphImmediately) {
            Iterator<UseCaseCameraControl> it = this.allControls.iterator();
            while (it.hasNext()) {
                it.next().setRequestControl(null);
            }
        }
        GraphStateToCameraStateAdapter graphStateToCameraStateAdapter = new GraphStateToCameraStateAdapter(this.cameraStateAdapter);
        SessionProcessor sessionProcessor$camera_camera2 = getSessionProcessor$camera_camera2();
        boolean z = false;
        if (sessionProcessor$camera_camera2 != null && (implementationType = sessionProcessor$camera_camera2.getImplementationType()) != null && (num = (Integer) implementationType.first) != null && num.intValue() == 1) {
            z = true;
        }
        SessionConfigAdapter sessionConfigAdapter = new SessionConfigAdapter(list, this.isPrimary);
        if (z) {
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "Setting up UseCaseManager with OperatingMode.EXTENSION");
            }
            SessionProcessor sessionProcessor$camera_camera3 = getSessionProcessor$camera_camera2();
            Intrinsics.checkNotNull(sessionProcessor$camera_camera3);
            sessionProcessor$camera_camera3.initSession(this.cameraInfoInternal.get(), null);
        }
        tryResumeUseCaseManager(createUseCaseCameraConfig$camera_camera2(sessionConfigAdapter, graphStateToCameraStateAdapter, z));
    }

    public static /* synthetic */ UseCaseCameraConfig createUseCaseCameraConfig$camera_camera2$default(UseCaseManager useCaseManager, SessionConfigAdapter sessionConfigAdapter, GraphStateToCameraStateAdapter graphStateToCameraStateAdapter, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return useCaseManager.createUseCaseCameraConfig$camera_camera2(sessionConfigAdapter, graphStateToCameraStateAdapter, z);
    }

    public final UseCaseCameraConfig createUseCaseCameraConfig$camera_camera2(SessionConfigAdapter sessionConfigAdapter, GraphStateToCameraStateAdapter graphStateToCameraStateAdapter, boolean isExtensions) {
        Intrinsics.checkNotNullParameter(sessionConfigAdapter, "sessionConfigAdapter");
        Intrinsics.checkNotNullParameter(graphStateToCameraStateAdapter, "graphStateToCameraStateAdapter");
        return UseCaseCameraConfig.INSTANCE.create(sessionConfigAdapter, this.cameraGraphConfigProvider, this.defaultCameraGraphFactory, graphStateToCameraStateAdapter, getSessionProcessor$camera_camera2(), isExtensions);
    }

    private final void closeCurrentUseCases() {
        final Job jobClose;
        UseCaseCamera camera = getCamera();
        this._activeComponent = null;
        this.cameraCoordinator.removePendingCameraInfo(this.cameraInfoInternal.get());
        if (camera != null && (jobClose = camera.close()) != null) {
            this.closingCameraJobs.add(jobClose);
            jobClose.invokeOnCompletion(new Function1() { // from class: androidx.camera.camera2.impl.UseCaseManager$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return UseCaseManager.closeCurrentUseCases$lambda$0$0$0(this.f$0, jobClose, (Throwable) obj);
                }
            });
        }
        SessionProcessor sessionProcessor$camera_camera2 = getSessionProcessor$camera_camera2();
        if (sessionProcessor$camera_camera2 != null) {
            sessionProcessor$camera_camera2.deInitSession();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit closeCurrentUseCases$lambda$0$0$0(UseCaseManager useCaseManager, Job job, Throwable th) {
        synchronized (useCaseManager.lock) {
            useCaseManager.closingCameraJobs.remove(job);
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    private final void tryResumeUseCaseManager(UseCaseCameraConfig useCaseCameraConfig) {
        if (!this.shouldCreateCameraGraphImmediately) {
            this.deferredUseCaseCameraConfig = useCaseCameraConfig;
            this.cameraCoordinator.addPendingCameraInfo(this.cameraInfoInternal.get());
        } else {
            beginComponentCreation(useCaseCameraConfig);
        }
    }

    public final void resumeDeferredComponentCreation$camera_camera2(final CameraGraph cameraGraph) {
        Intrinsics.checkNotNullParameter(cameraGraph, "cameraGraph");
        synchronized (this.lock) {
            UseCaseCameraConfig useCaseCameraConfig = this.deferredUseCaseCameraConfig;
            if (useCaseCameraConfig == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            beginComponentCreation(UseCaseCameraConfig.copy$default(useCaseCameraConfig, new Function1() { // from class: androidx.camera.camera2.impl.UseCaseManager$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return UseCaseManager.resumeDeferredComponentCreation$lambda$0$0(cameraGraph, (CameraGraph.Config) obj);
                }
            }, null, null, null, null, 30, null));
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void beginComponentCreation(UseCaseCameraConfig useCaseCameraConfig) {
        this._activeComponent = this.builder.config(useCaseCameraConfig).build();
        UseCaseCamera camera = getCamera();
        if (camera == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        camera.start();
        Iterator<UseCaseCameraControl> it = this.allControls.iterator();
        while (it.hasNext()) {
            it.next().setRequestControl(camera.getRequestControl());
        }
        camera.setActiveResumeMode(this.activeResumeEnabled);
        updateRunningUseCases(getRunningUseCases());
        Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "Notifying " + this.pendingUseCasesToNotifyCameraControlReady + " camera control ready");
        }
        Iterator<UseCase> it2 = this.pendingUseCasesToNotifyCameraControlReady.iterator();
        while (it2.hasNext()) {
            it2.next().onCameraControlReady();
        }
        this.pendingUseCasesToNotifyCameraControlReady.clear();
    }

    private final Set<UseCase> getRunningUseCases() {
        return CollectionsKt.intersect(this.attachedUseCases, this.activeUseCases);
    }

    public final Set<UseCase> getRunningUseCasesForTest() {
        Set<UseCase> runningUseCases;
        synchronized (this.lock) {
            runningUseCases = getRunningUseCases();
        }
        return runningUseCases;
    }

    private final boolean addOrRemoveRepeatingUseCase(Set<? extends UseCase> runningUseCases) {
        if (shouldAddRepeatingUseCase(runningUseCases)) {
            addRepeatingUseCase();
            return true;
        }
        if (!shouldRemoveRepeatingUseCase(runningUseCases)) {
            return false;
        }
        removeRepeatingUseCase();
        return true;
    }

    private final boolean isMeteringRepeatingRequired(Set<? extends UseCase> runningUseCases) {
        if (!this.cameraXConfig.isRepeatingStreamForced()) {
            return false;
        }
        Set<? extends UseCase> set = runningUseCases;
        if (!(set instanceof Collection) || !set.isEmpty()) {
            for (UseCase useCase : set) {
                if (!Intrinsics.areEqual(useCase, this.meteringRepeating)) {
                    List<DeferrableSurface> surfaces = useCase.getSessionConfig().getSurfaces();
                    Intrinsics.checkNotNullExpressionValue(surfaces, "getSurfaces(...)");
                    if (!surfaces.isEmpty()) {
                        Set<UseCase> set2 = this.attachedUseCases;
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : set2) {
                            if (!Intrinsics.areEqual((UseCase) obj, this.meteringRepeating)) {
                                arrayList.add(obj);
                            }
                        }
                        ArrayList arrayList2 = arrayList;
                        if (arrayList2.isEmpty()) {
                            return false;
                        }
                        ArrayList arrayList3 = arrayList2;
                        if (!shouldForceRepeatingStream(arrayList3) || !isMeteringCombinationSupported(arrayList3)) {
                            break;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private final boolean shouldForceRepeatingStream(Collection<? extends UseCase> collection) {
        boolean z;
        if (collection.isEmpty()) {
            return false;
        }
        SessionConfig.ValidatingBuilder validatingBuilder = new SessionConfig.ValidatingBuilder();
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            validatingBuilder.add(((UseCase) it.next()).getSessionConfig());
        }
        SessionConfig sessionConfigBuild = validatingBuilder.build();
        Intrinsics.checkNotNullExpressionValue(sessionConfigBuild, "build(...)");
        List<DeferrableSurface> surfaces = sessionConfigBuild.getRepeatingCaptureConfig().getSurfaces();
        Intrinsics.checkNotNullExpressionValue(surfaces, "getSurfaces(...)");
        List<DeferrableSurface> surfaces2 = sessionConfigBuild.getSurfaces();
        Intrinsics.checkNotNullExpressionValue(surfaces2, "getSurfaces(...)");
        if (surfaces2.isEmpty()) {
            return false;
        }
        List<DeferrableSurface> list = surfaces2;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = true;
                    break;
                }
                if (!Intrinsics.areEqual(((DeferrableSurface) it2.next()).getContainerClass(), MediaCodec.class)) {
                    z = false;
                    break;
                }
            }
        } else {
            z = true;
            break;
        }
        return z || surfaces.isEmpty();
    }

    private final boolean shouldAddRepeatingUseCase(Set<? extends UseCase> runningUseCases) {
        return this.cameraXConfig.isRepeatingStreamForced() && !this.attachedUseCases.contains(this.meteringRepeating) && isMeteringRepeatingRequired(runningUseCases);
    }

    private final boolean shouldRemoveRepeatingUseCase(Set<? extends UseCase> runningUseCases) {
        return runningUseCases.contains(this.meteringRepeating) && !isMeteringRepeatingRequired(runningUseCases);
    }

    private final void addRepeatingUseCase() {
        this.meteringRepeating.bindToCamera(this.cameraInternal.get(), null, null, null);
        this.meteringRepeating.setupSession();
        attach(CollectionsKt.listOf(this.meteringRepeating));
        activate(this.meteringRepeating);
    }

    private final void removeRepeatingUseCase() {
        deactivate(this.meteringRepeating);
        detach(CollectionsKt.listOf(this.meteringRepeating));
        this.meteringRepeating.unbindFromCamera(this.cameraInternal.get());
    }

    private final boolean isMeteringCombinationSupported(Collection<? extends UseCase> collection) {
        if (this.meteringRepeating.getAttachedSurfaceResolution() == null) {
            this.meteringRepeating.setupSession();
        }
        List<AttachedSurfaceInfo> attachedSurfaceInfoList = getAttachedSurfaceInfoList(collection);
        if (attachedSurfaceInfoList.isEmpty()) {
            return false;
        }
        List<SurfaceConfig> sessionSurfacesConfigs = getSessionSurfacesConfigs(collection);
        SupportedSurfaceCombination supportedSurfaceCombination = this.supportedSurfaceCombination;
        SupportedSurfaceCombination.FeatureSettings featureSettings = new SupportedSurfaceCombination.FeatureSettings(getCameraMode(), getRequiredMaxBitDepth(attachedSurfaceInfoList), UseCaseUtil.containsVideoCapture(collection), UseCaseUtil.getVideoStabilization$default(collection, null, 1, null), isUltraHdrOn(collection), false, false, false, null, false, 992, null);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(sessionSurfacesConfigs);
        arrayList.add(createMeteringRepeatingSurfaceConfig());
        Unit unit = Unit.INSTANCE;
        boolean zCheckSupported$default = SupportedSurfaceCombination.checkSupported$default(supportedSurfaceCombination, featureSettings, arrayList, null, null, null, 28, null);
        Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "Combination of " + sessionSurfacesConfigs + " + " + this.meteringRepeating + " is supported: " + zCheckSupported$default);
        }
        return zCheckSupported$default;
    }

    private final int getCameraMode() {
        synchronized (this.lock) {
            if (this.cameraCoordinator.getCameraOperatingMode() == 2) {
                return 1;
            }
            Unit unit = Unit.INSTANCE;
            return 0;
        }
    }

    private final int getRequiredMaxBitDepth(List<? extends AttachedSurfaceInfo> attachedSurfaceInfoList) {
        Iterator<Map.Entry<UseCaseConfig<?>, DynamicRange>> it = this.dynamicRangeResolver.resolveAndValidateDynamicRanges(attachedSurfaceInfoList, CollectionsKt.listOf(this.meteringRepeating.getCurrentConfig()), CollectionsKt.listOf(0)).entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().getBitDepth() == 10) {
                return 10;
            }
        }
        return 8;
    }

    private final List<AttachedSurfaceInfo> getAttachedSurfaceInfoList(Collection<? extends UseCase> collection) {
        ArrayList arrayList = new ArrayList();
        for (UseCase useCase : collection) {
            Size attachedSurfaceResolution = useCase.getAttachedSurfaceResolution();
            StreamSpec attachedStreamSpec = useCase.getAttachedStreamSpec();
            if (attachedSurfaceResolution == null || attachedStreamSpec == null) {
                Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                if (Logger.isWarnEnabled(Log.TAG)) {
                    android.util.Log.w(Camera2Logger.TRUNCATED_TAG, "Invalid surface resolution or stream spec is found.");
                }
                arrayList.clear();
                break;
            }
            SupportedSurfaceCombination supportedSurfaceCombination = this.supportedSurfaceCombination;
            int cameraMode = getCameraMode();
            int inputFormat = useCase.getCurrentConfig().getInputFormat();
            StreamUseCase streamUseCase = useCase.getCurrentConfig().getStreamUseCase();
            Intrinsics.checkNotNullExpressionValue(streamUseCase, "getStreamUseCase(...)");
            SurfaceConfig surfaceConfigTransformSurfaceConfig = supportedSurfaceCombination.transformSurfaceConfig(cameraMode, inputFormat, attachedSurfaceResolution, streamUseCase);
            int inputFormat2 = useCase.getCurrentConfig().getInputFormat();
            DynamicRange dynamicRange = attachedStreamSpec.getDynamicRange();
            List<UseCaseConfigFactory.CaptureType> captureTypes = getCaptureTypes(useCase);
            MutableOptionsBundle implementationOptions = attachedStreamSpec.getImplementationOptions();
            if (implementationOptions == null) {
                MutableOptionsBundle mutableOptionsBundleCreate = MutableOptionsBundle.create();
                Intrinsics.checkNotNullExpressionValue(mutableOptionsBundleCreate, "create(...)");
                implementationOptions = mutableOptionsBundleCreate;
            }
            AttachedSurfaceInfo attachedSurfaceInfoCreate = AttachedSurfaceInfo.create(surfaceConfigTransformSurfaceConfig, inputFormat2, attachedSurfaceResolution, dynamicRange, captureTypes, implementationOptions, attachedStreamSpec.getSessionType(), attachedStreamSpec.getExpectedFrameRateRange(), useCase.getCurrentConfig().isStrictFrameRateRequired(), useCase.getCurrentConfig().getCustomMaxFrameRate(attachedSurfaceResolution));
            Intrinsics.checkNotNullExpressionValue(attachedSurfaceInfoCreate, "create(...)");
            arrayList.add(attachedSurfaceInfoCreate);
        }
        return arrayList;
    }

    private final List<UseCaseConfigFactory.CaptureType> getCaptureTypes(UseCase useCase) {
        if (useCase instanceof StreamSharing) {
            UseCaseConfig<?> currentConfig = ((StreamSharing) useCase).getCurrentConfig();
            Intrinsics.checkNotNull(currentConfig, "null cannot be cast to non-null type androidx.camera.core.streamsharing.StreamSharingConfig");
            List<UseCaseConfigFactory.CaptureType> captureTypes = ((StreamSharingConfig) currentConfig).getCaptureTypes();
            Intrinsics.checkNotNull(captureTypes);
            return captureTypes;
        }
        return CollectionsKt.listOf(useCase.getCurrentConfig().getCaptureType());
    }

    private final boolean isUltraHdrOn(Collection<? extends UseCase> collection) {
        UseCaseConfig<?> currentConfig;
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (obj instanceof ImageCapture) {
                arrayList.add(obj);
            }
        }
        ImageCapture imageCapture = (ImageCapture) CollectionsKt.firstOrNull((List) arrayList);
        return (imageCapture == null || (currentConfig = imageCapture.getCurrentConfig()) == null || currentConfig.getInputFormat() != 4101) ? false : true;
    }

    private final List<SurfaceConfig> getSessionSurfacesConfigs(Collection<? extends UseCase> collection) {
        ArrayList arrayList = new ArrayList();
        for (UseCase useCase : collection) {
            List<DeferrableSurface> surfaces = useCase.getSessionConfig().getSurfaces();
            Intrinsics.checkNotNullExpressionValue(surfaces, "getSurfaces(...)");
            for (DeferrableSurface deferrableSurface : surfaces) {
                SupportedSurfaceCombination supportedSurfaceCombination = this.supportedSurfaceCombination;
                int cameraMode = getCameraMode();
                int inputFormat = useCase.getCurrentConfig().getInputFormat();
                Size prescribedSize = deferrableSurface.getPrescribedSize();
                Intrinsics.checkNotNullExpressionValue(prescribedSize, "getPrescribedSize(...)");
                StreamUseCase streamUseCase = useCase.getCurrentConfig().getStreamUseCase();
                Intrinsics.checkNotNullExpressionValue(streamUseCase, "getStreamUseCase(...)");
                arrayList.add(supportedSurfaceCombination.transformSurfaceConfig(cameraMode, inputFormat, prescribedSize, streamUseCase));
            }
        }
        return arrayList;
    }

    private final SurfaceConfig createMeteringRepeatingSurfaceConfig() {
        SupportedSurfaceCombination supportedSurfaceCombination = this.supportedSurfaceCombination;
        int cameraMode = getCameraMode();
        int imageFormat = this.meteringRepeating.getImageFormat();
        Size attachedSurfaceResolution = this.meteringRepeating.getAttachedSurfaceResolution();
        Intrinsics.checkNotNull(attachedSurfaceResolution);
        StreamUseCase streamUseCase = this.meteringRepeating.getCurrentConfig().getStreamUseCase();
        Intrinsics.checkNotNullExpressionValue(streamUseCase, "getStreamUseCase(...)");
        return supportedSurfaceCombination.transformSurfaceConfig(cameraMode, imageFormat, attachedSurfaceResolution, streamUseCase);
    }

    private final void updateZslDisabledByUseCaseConfigStatus() {
        Set<UseCase> set = this.attachedUseCases;
        boolean z = false;
        if (!(set instanceof Collection) || !set.isEmpty()) {
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                if (((UseCase) it.next()).getCurrentConfig().isZslDisabled(false)) {
                    z = true;
                    break;
                }
            }
        }
        this.zslControl.setZslDisabledByUserCaseConfig(z);
    }
}

package androidx.camera.camera2.impl;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.camera.camera2.config.UseCaseCameraScope;
import androidx.camera.camera2.config.UseCaseGraphContext;
import androidx.camera.camera2.interop.Camera2CaptureRequestConfigurator;
import androidx.camera.camera2.interop.Camera2CaptureRequestConfiguratorKt;
import androidx.camera.camera2.pipe.AeMode;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.Lock3ABehavior;
import androidx.camera.camera2.pipe.Request;
import androidx.camera.camera2.pipe.RequestTemplate;
import androidx.camera.camera2.pipe.Result3A;
import androidx.camera.camera2.pipe.StreamId;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.Logger;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.MutableTagBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.TagBundle;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import dagger.Binds;
import dagger.Module;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: UseCaseCameraRequestControl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0084\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u0084\u00012\u00020\u0001:\u0006\u0082\u0001\u0083\u0001\u0084\u0001BO\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J,\u0010!\u001a\u00020\"*\u00020\"2\u0016\u0010#\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030%\u0012\u0004\u0012\u00020&0$2\u0006\u0010'\u001a\u00020(H\u0002J\u001e\u0010)\u001a\u00020\"*\u00020\"2\u0010\u0010*\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030%0+H\u0002J6\u0010/\u001a\b\u0012\u0004\u0012\u000201002\u0016\u0010#\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030%\u0012\u0004\u0012\u00020&0$2\u0006\u00102\u001a\u00020.2\u0006\u0010'\u001a\u00020(H\u0016J6\u00103\u001a\b\u0012\u0004\u0012\u000201002\u0016\u0010#\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030%\u0012\u0004\u0012\u00020&0$2\u0006\u00102\u001a\u00020.2\u0006\u0010'\u001a\u00020(H\u0016J<\u00104\u001a\b\u0012\u0004\u0012\u000201002\u0006\u00102\u001a\u00020.2\u0016\u0010#\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030%\u0012\u0004\u0012\u00020&0$2\u0006\u0010'\u001a\u00020(H\u0082@¢\u0006\u0002\u00105J(\u00106\u001a\b\u0012\u0004\u0012\u000201002\u0010\u0010*\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030%0+2\u0006\u00102\u001a\u00020.H\u0016J$\u00107\u001a\b\u0012\u0004\u0012\u000201002\u0006\u00108\u001a\u00020\u00122\f\u00109\u001a\b\u0012\u0004\u0012\u00020;0:H\u0016J*\u0010<\u001a\b\u0012\u0004\u0012\u000201002\u0006\u0010=\u001a\u00020>2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020&0$H\u0016J\u000e\u0010A\u001a\b\u0012\u0004\u0012\u00020B00H\u0016J\u001d\u0010C\u001a\b\u0012\u0004\u0012\u00020B002\u0006\u0010D\u001a\u00020EH\u0016¢\u0006\u0004\bF\u0010GJs\u0010H\u001a\b\u0012\u0004\u0012\u00020B002\u000e\u0010I\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010+2\u000e\u0010K\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010+2\u000e\u0010L\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010+2\b\u0010M\u001a\u0004\u0018\u00010N2\b\u0010O\u001a\u0004\u0018\u00010N2\b\u0010P\u001a\u0004\u0018\u00010N2\b\u0010Q\u001a\u0004\u0018\u00010E2\u0006\u0010R\u001a\u00020SH\u0016¢\u0006\u0002\bTJ\u000e\u0010U\u001a\b\u0012\u0004\u0012\u00020B00H\u0016J<\u0010V\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010W000+2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020Y0+2\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020[2\u0006\u0010]\u001a\u00020[H\u0016J>\u0010^\u001a\b\u0012\u0004\u0012\u00020B002\u000e\u0010I\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010+2\u000e\u0010K\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010+2\u000e\u0010L\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010+H\u0016J\u000e\u0010_\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010`J\b\u0010a\u001a\u000201H\u0016J&\u0010b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010W000+2\u0006\u0010c\u001a\u00020[2\u0006\u0010d\u001a\u00020@H\u0002J\u0012\u0010e\u001a\u00020\u0012*\b\u0012\u0004\u0012\u00020Y0+H\u0002J\u0018\u0010f\u001a\u00020\"*\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\"0$H\u0002J\f\u0010g\u001a\u00020h*\u00020\"H\u0002J*\u0010i\u001a\b\u0012\u0004\u0012\u00020100*\u00020\"2\u0010\b\u0002\u0010j\u001a\n\u0012\u0004\u0012\u00020l\u0018\u00010kH\u0082@¢\u0006\u0002\u0010mJ$\u0010n\u001a\u0004\u0018\u0001Ho\"\u0004\b\u0000\u0010o2\f\u0010p\u001a\b\u0012\u0004\u0012\u0002Ho0qH\u0082\b¢\u0006\u0002\u0010rJ@\u0010s\u001a\b\u0012\u0004\u0012\u00020B002*\b\u0004\u0010p\u001a$\b\u0001\u0012\u0004\u0012\u00020u\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020B000v\u0012\u0006\u0012\u0004\u0018\u00010&0tH\u0082H¢\u0006\u0002\u0010wJ=\u0010x\u001a\b\u0012\u0004\u0012\u0002Hy00\"\u0004\b\u0000\u0010y2\"\u0010p\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002Hy000v\u0012\u0006\u0012\u0004\u0018\u00010&0zH\u0002¢\u0006\u0002\u0010{JQ\u0010|\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002Hy000+\"\u0004\b\u0000\u0010y2\u0006\u0010}\u001a\u00020[2(\u0010p\u001a$\b\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002Hy000+0v\u0012\u0006\u0012\u0004\u0018\u00010&0zH\u0002¢\u0006\u0002\u0010~J\u0013\u0010\u007f\u001a\u00030\u0080\u0001*\u00020\fH\u0000¢\u0006\u0003\b\u0081\u0001R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\u0013\u001a\n \u0014*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R#\u0010\u0019\u001a\n \u0014*\u0004\u0018\u00010\n0\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001a\u0010\u001bR#\u0010\u001d\u001a\n \u0014*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0018\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\"0-X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0085\u0001"}, d2 = {"Landroidx/camera/camera2/impl/UseCaseCameraRequestControlImpl;", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "capturePipelineProvider", "Ljavax/inject/Provider;", "Landroidx/camera/camera2/impl/CapturePipeline;", "useCaseCameraStateProvider", "Landroidx/camera/camera2/impl/UseCaseCameraState;", "useCaseGraphContext", "Landroidx/camera/camera2/config/UseCaseGraphContext;", "useCaseSurfaceManagerProvider", "Landroidx/camera/camera2/impl/UseCaseSurfaceManager;", "threads", "Landroidx/camera/camera2/impl/UseCaseThreads;", "cameraXConfig", "Landroidx/camera/core/CameraXConfig;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Landroidx/camera/camera2/config/UseCaseGraphContext;Ljavax/inject/Provider;Landroidx/camera/camera2/impl/UseCaseThreads;Landroidx/camera/core/CameraXConfig;)V", "closed", "", "capturePipeline", "kotlin.jvm.PlatformType", "getCapturePipeline", "()Landroidx/camera/camera2/impl/CapturePipeline;", "capturePipeline$delegate", "Lkotlin/Lazy;", "useCaseSurfaceManager", "getUseCaseSurfaceManager", "()Landroidx/camera/camera2/impl/UseCaseSurfaceManager;", "useCaseSurfaceManager$delegate", "useCaseCameraState", "getUseCaseCameraState", "()Landroidx/camera/camera2/impl/UseCaseCameraState;", "useCaseCameraState$delegate", "withParameters", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControlImpl$InfoBundle;", "values", "", "Landroid/hardware/camera2/CaptureRequest$Key;", "", "optionPriority", "Landroidx/camera/core/impl/Config$OptionPriority;", "withoutParameters", UserMetadata.KEYDATA_FILENAME, "", "infoBundleMap", "", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl$Type;", "setParametersAsync", "Lkotlinx/coroutines/Deferred;", "", "type", "submitParameters", "setParametersInternal", "(Landroidx/camera/camera2/impl/UseCaseCameraRequestControl$Type;Ljava/util/Map;Landroidx/camera/core/impl/Config$OptionPriority;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeParametersAsync", "updateRepeatingRequestAsync", "isPrimary", "runningUseCases", "", "Landroidx/camera/core/UseCase;", "updateCamera2ConfigAsync", "config", "Landroidx/camera/core/impl/Config;", "tags", "", "setTorchOnAsync", "Landroidx/camera/camera2/pipe/Result3A;", "setTorchOffAsync", "aeMode", "Landroidx/camera/camera2/pipe/AeMode;", "setTorchOffAsync-MtizInI", "(I)Lkotlinx/coroutines/Deferred;", "startFocusAndMeteringAsync", "aeRegions", "Landroid/hardware/camera2/params/MeteringRectangle;", "afRegions", "awbRegions", "aeLockBehavior", "Landroidx/camera/camera2/pipe/Lock3ABehavior;", "afLockBehavior", "awbLockBehavior", "afTriggerStartAeMode", "timeLimitNs", "", "startFocusAndMeteringAsync-NxRnBj4", "cancelFocusAndMeteringAsync", "issueSingleCaptureAsync", "Ljava/lang/Void;", "captureSequence", "Landroidx/camera/core/impl/CaptureConfig;", "captureMode", "", "flashType", "flashMode", "update3aRegions", "awaitSurfaceSetup", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "failedResults", "count", "message", "hasInvalidSurface", "merge", "toTagBundle", "Landroidx/camera/core/impl/TagBundle;", "updateCameraStateAsync", "streams", "", "Landroidx/camera/camera2/pipe/StreamId;", "(Landroidx/camera/camera2/impl/UseCaseCameraRequestControlImpl$InfoBundle;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runIfNotClosed", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "useGraphSessionOrFailed", "Lkotlin/Function2;", "Landroidx/camera/camera2/pipe/CameraGraph$Session;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runOnSequential", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Deferred;", "runOnSequentialList", ContentDisposition.Parameters.Size, "(ILkotlin/jvm/functions/Function1;)Ljava/util/List;", "determineStartStrategy", "Lkotlinx/coroutines/CoroutineStart;", "determineStartStrategy$camera_camera2", "InfoBundle", "Bindings", "Companion", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
@UseCaseCameraScope
public final class UseCaseCameraRequestControlImpl implements UseCaseCameraRequestControl {
    private static final CompletableDeferred<Unit> canceledResult;
    private final CameraXConfig cameraXConfig;

    /* JADX INFO: renamed from: capturePipeline$delegate, reason: from kotlin metadata */
    private final Lazy capturePipeline;
    private final Provider<CapturePipeline> capturePipelineProvider;
    private volatile boolean closed;
    private final Map<UseCaseCameraRequestControl.Type, InfoBundle> infoBundleMap;
    private final UseCaseThreads threads;

    /* JADX INFO: renamed from: useCaseCameraState$delegate, reason: from kotlin metadata */
    private final Lazy useCaseCameraState;
    private final Provider<UseCaseCameraState> useCaseCameraStateProvider;
    private final UseCaseGraphContext useCaseGraphContext;

    /* JADX INFO: renamed from: useCaseSurfaceManager$delegate, reason: from kotlin metadata */
    private final Lazy useCaseSurfaceManager;
    private final Provider<UseCaseSurfaceManager> useCaseSurfaceManagerProvider;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final CompletableDeferred<Result3A> submitFailedResult = CompletableDeferredKt.CompletableDeferred(new Result3A(Result3A.Status.INSTANCE.m736getSUBMIT_FAILEDJvTi9ms(), null, 2, null));

    /* JADX INFO: compiled from: UseCaseCameraRequestControl.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, d2 = {"Landroidx/camera/camera2/impl/UseCaseCameraRequestControlImpl$Bindings;", "", "<init>", "()V", "bindRequestControl", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "requestControl", "Landroidx/camera/camera2/impl/DeferredUseCaseCameraRequestControl;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Module
    public static abstract class Bindings {
        @Binds
        @UseCaseCameraScope
        public abstract UseCaseCameraRequestControl bindRequestControl(DeferredUseCaseCameraRequestControl requestControl);
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl$updateCameraStateAsync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UseCaseCameraRequestControl.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl", f = "UseCaseCameraRequestControl.kt", i = {}, l = {638}, m = "updateCameraStateAsync", n = {}, s = {}, v = 1)
    static final class C01941 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C01941(Continuation<? super C01941> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UseCaseCameraRequestControlImpl.this.updateCameraStateAsync(null, null, this);
        }
    }

    @Inject
    public UseCaseCameraRequestControlImpl(Provider<CapturePipeline> capturePipelineProvider, Provider<UseCaseCameraState> useCaseCameraStateProvider, UseCaseGraphContext useCaseGraphContext, Provider<UseCaseSurfaceManager> useCaseSurfaceManagerProvider, UseCaseThreads threads, CameraXConfig cameraXConfig) {
        Intrinsics.checkNotNullParameter(capturePipelineProvider, "capturePipelineProvider");
        Intrinsics.checkNotNullParameter(useCaseCameraStateProvider, "useCaseCameraStateProvider");
        Intrinsics.checkNotNullParameter(useCaseGraphContext, "useCaseGraphContext");
        Intrinsics.checkNotNullParameter(useCaseSurfaceManagerProvider, "useCaseSurfaceManagerProvider");
        Intrinsics.checkNotNullParameter(threads, "threads");
        this.capturePipelineProvider = capturePipelineProvider;
        this.useCaseCameraStateProvider = useCaseCameraStateProvider;
        this.useCaseGraphContext = useCaseGraphContext;
        this.useCaseSurfaceManagerProvider = useCaseSurfaceManagerProvider;
        this.threads = threads;
        this.cameraXConfig = cameraXConfig;
        Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "Configured " + this);
        }
        this.capturePipeline = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.capturePipelineProvider.get();
            }
        });
        this.useCaseSurfaceManager = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.useCaseSurfaceManagerProvider.get();
            }
        });
        this.useCaseCameraState = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.useCaseCameraStateProvider.get();
            }
        });
        this.infoBundleMap = new LinkedHashMap();
    }

    public /* synthetic */ UseCaseCameraRequestControlImpl(Provider provider, Provider provider2, UseCaseGraphContext useCaseGraphContext, Provider provider3, UseCaseThreads useCaseThreads, CameraXConfig cameraXConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(provider, provider2, useCaseGraphContext, provider3, useCaseThreads, (i & 32) != 0 ? null : cameraXConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CapturePipeline getCapturePipeline() {
        return (CapturePipeline) this.capturePipeline.getValue();
    }

    private final UseCaseSurfaceManager getUseCaseSurfaceManager() {
        return (UseCaseSurfaceManager) this.useCaseSurfaceManager.getValue();
    }

    private final UseCaseCameraState getUseCaseCameraState() {
        return (UseCaseCameraState) this.useCaseCameraState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: UseCaseCameraRequestControl.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\b\u001cJJ\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\b\u001eJ\u0014\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0006HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Landroidx/camera/camera2/impl/UseCaseCameraRequestControlImpl$InfoBundle;", "", "options", "Landroidx/camera/camera2/impl/Camera2ImplConfig$Builder;", "tags", "", "", "listeners", "", "Landroidx/camera/camera2/pipe/Request$Listener;", "template", "Landroidx/camera/camera2/pipe/RequestTemplate;", "<init>", "(Landroidx/camera/camera2/impl/Camera2ImplConfig$Builder;Ljava/util/Map;Ljava/util/Set;Landroidx/camera/camera2/pipe/RequestTemplate;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getOptions", "()Landroidx/camera/camera2/impl/Camera2ImplConfig$Builder;", "getTags", "()Ljava/util/Map;", "getListeners", "()Ljava/util/Set;", "getTemplate-ejQnlcg", "()Landroidx/camera/camera2/pipe/RequestTemplate;", "setTemplate-xlOpshk", "(Landroidx/camera/camera2/pipe/RequestTemplate;)V", "component1", "component2", "component3", "component4", "component4-ejQnlcg", "copy", "copy-0am55g4", "equals", "", "other", "hashCode", "", "toString", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    static final /* data */ class InfoBundle {
        private final Set<Request.Listener> listeners;
        private final Camera2ImplConfig.Builder options;
        private final Map<String, Object> tags;
        private RequestTemplate template;

        public /* synthetic */ InfoBundle(Camera2ImplConfig.Builder builder, Map map, Set set, RequestTemplate requestTemplate, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder, map, set, requestTemplate);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: copy-0am55g4$default, reason: not valid java name */
        public static /* synthetic */ InfoBundle m142copy0am55g4$default(InfoBundle infoBundle, Camera2ImplConfig.Builder builder, Map map, Set set, RequestTemplate requestTemplate, int i, Object obj) {
            if ((i & 1) != 0) {
                builder = infoBundle.options;
            }
            if ((i & 2) != 0) {
                map = infoBundle.tags;
            }
            if ((i & 4) != 0) {
                set = infoBundle.listeners;
            }
            if ((i & 8) != 0) {
                requestTemplate = infoBundle.template;
            }
            return infoBundle.m144copy0am55g4(builder, map, set, requestTemplate);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Camera2ImplConfig.Builder getOptions() {
            return this.options;
        }

        public final Map<String, Object> component2() {
            return this.tags;
        }

        public final Set<Request.Listener> component3() {
            return this.listeners;
        }

        /* JADX INFO: renamed from: component4-ejQnlcg, reason: not valid java name and from getter */
        public final RequestTemplate getTemplate() {
            return this.template;
        }

        /* JADX INFO: renamed from: copy-0am55g4, reason: not valid java name */
        public final InfoBundle m144copy0am55g4(Camera2ImplConfig.Builder options, Map<String, Object> tags, Set<Request.Listener> listeners, RequestTemplate template) {
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(tags, "tags");
            Intrinsics.checkNotNullParameter(listeners, "listeners");
            return new InfoBundle(options, tags, listeners, template, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InfoBundle)) {
                return false;
            }
            InfoBundle infoBundle = (InfoBundle) other;
            return Intrinsics.areEqual(this.options, infoBundle.options) && Intrinsics.areEqual(this.tags, infoBundle.tags) && Intrinsics.areEqual(this.listeners, infoBundle.listeners) && Intrinsics.areEqual(this.template, infoBundle.template);
        }

        public int hashCode() {
            int iHashCode = ((((this.options.hashCode() * 31) + this.tags.hashCode()) * 31) + this.listeners.hashCode()) * 31;
            RequestTemplate requestTemplate = this.template;
            return iHashCode + (requestTemplate == null ? 0 : RequestTemplate.m719hashCodeimpl(requestTemplate.m721unboximpl()));
        }

        public String toString() {
            return "InfoBundle(options=" + this.options + ", tags=" + this.tags + ", listeners=" + this.listeners + ", template=" + this.template + ')';
        }

        private InfoBundle(Camera2ImplConfig.Builder options, Map<String, Object> tags, Set<Request.Listener> listeners, RequestTemplate requestTemplate) {
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(tags, "tags");
            Intrinsics.checkNotNullParameter(listeners, "listeners");
            this.options = options;
            this.tags = tags;
            this.listeners = listeners;
            this.template = requestTemplate;
        }

        public /* synthetic */ InfoBundle(Camera2ImplConfig.Builder builder, LinkedHashMap linkedHashMap, LinkedHashSet linkedHashSet, RequestTemplate requestTemplate, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new Camera2ImplConfig.Builder() : builder, (i & 2) != 0 ? new LinkedHashMap() : linkedHashMap, (i & 4) != 0 ? new LinkedHashSet() : linkedHashSet, (i & 8) != 0 ? null : requestTemplate, null);
        }

        public final Camera2ImplConfig.Builder getOptions() {
            return this.options;
        }

        public final Map<String, Object> getTags() {
            return this.tags;
        }

        public final Set<Request.Listener> getListeners() {
            return this.listeners;
        }

        /* JADX INFO: renamed from: getTemplate-ejQnlcg, reason: not valid java name */
        public final RequestTemplate m145getTemplateejQnlcg() {
            return this.template;
        }

        /* JADX INFO: renamed from: setTemplate-xlOpshk, reason: not valid java name */
        public final void m146setTemplatexlOpshk(RequestTemplate requestTemplate) {
            this.template = requestTemplate;
        }
    }

    private final InfoBundle withParameters(InfoBundle infoBundle, Map<CaptureRequest.Key<?>, ? extends Object> map, Config.OptionPriority optionPriority) {
        Camera2ImplConfig.Builder builder = new Camera2ImplConfig.Builder();
        builder.insertAllOptions(infoBundle.getOptions().getMutableConfig());
        builder.addAllCaptureRequestOptionsWithPriority(map, optionPriority);
        return InfoBundle.m142copy0am55g4$default(infoBundle, builder, MapsKt.toMutableMap(infoBundle.getTags()), CollectionsKt.toMutableSet(infoBundle.getListeners()), null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InfoBundle withoutParameters(InfoBundle infoBundle, List<? extends CaptureRequest.Key<?>> list) {
        Camera2ImplConfig.Builder builder = new Camera2ImplConfig.Builder();
        builder.insertAllOptions(infoBundle.getOptions().getMutableConfig());
        builder.removeCaptureRequestOptions(list);
        return InfoBundle.m142copy0am55g4$default(infoBundle, builder, MapsKt.toMutableMap(infoBundle.getTags()), CollectionsKt.toMutableSet(infoBundle.getListeners()), null, 8, null);
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public Deferred<Unit> submitParameters(Map<CaptureRequest.Key<?>, ? extends Object> values, UseCaseCameraRequestControl.Type type, Config.OptionPriority optionPriority) {
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(optionPriority, "optionPriority");
        if (this.closed) {
            return canceledResult;
        }
        this.threads.checkOnSequentialThread();
        return BuildersKt__Builders_commonKt.async$default(this.threads.getSequentialScope(), null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(type, values, optionPriority, null), 1, null);
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl$submitParameters$1, reason: invalid class name */
    /* JADX INFO: compiled from: UseCaseCameraRequestControl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl$submitParameters$1", f = "UseCaseCameraRequestControl.kt", i = {}, l = {365, 365}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Config.OptionPriority $optionPriority;
        final /* synthetic */ UseCaseCameraRequestControl.Type $type;
        final /* synthetic */ Map<CaptureRequest.Key<?>, Object> $values;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(UseCaseCameraRequestControl.Type type, Map<CaptureRequest.Key<?>, ? extends Object> map, Config.OptionPriority optionPriority, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$type = type;
            this.$values = map;
            this.$optionPriority = optionPriority;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return UseCaseCameraRequestControlImpl.this.new AnonymousClass1(this.$type, this.$values, this.$optionPriority, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0040, code lost:
        
            if (((kotlinx.coroutines.Deferred) r8).await(r7) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.throwOnFailure(r8)
                goto L43
            L12:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L1a:
                kotlin.ResultKt.throwOnFailure(r8)
                goto L35
            L1e:
                kotlin.ResultKt.throwOnFailure(r8)
                androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl r8 = androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl.this
                androidx.camera.camera2.impl.UseCaseCameraRequestControl$Type r1 = r7.$type
                java.util.Map<android.hardware.camera2.CaptureRequest$Key<?>, java.lang.Object> r4 = r7.$values
                androidx.camera.core.impl.Config$OptionPriority r5 = r7.$optionPriority
                r6 = r7
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r7.label = r3
                java.lang.Object r8 = androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl.access$setParametersInternal(r8, r1, r4, r5, r6)
                if (r8 != r0) goto L35
                goto L42
            L35:
                kotlinx.coroutines.Deferred r8 = (kotlinx.coroutines.Deferred) r8
                r1 = r7
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r7.label = r2
                java.lang.Object r7 = r8.await(r1)
                if (r7 != r0) goto L43
            L42:
                return r0
            L43:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object setParametersInternal(UseCaseCameraRequestControl.Type type, Map<CaptureRequest.Key<?>, ? extends Object> map, Config.OptionPriority optionPriority, Continuation<? super Deferred<Unit>> continuation) {
        Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "UseCaseCameraRequestControlImpl#setParametersAsync: [" + type + "] values = " + map + ", optionPriority = " + optionPriority);
        }
        Map<UseCaseCameraRequestControl.Type, InfoBundle> map2 = this.infoBundleMap;
        InfoBundle infoBundle = map2.get(type);
        if (infoBundle == null) {
            InfoBundle infoBundle2 = new InfoBundle(null, null, null, null, 15, null);
            map2.put(type, infoBundle2);
            infoBundle = infoBundle2;
        }
        this.infoBundleMap.put(type, withParameters(infoBundle, map, optionPriority));
        return updateCameraStateAsync$default(this, merge(this.infoBundleMap), null, continuation, 1, null);
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public Object awaitSurfaceSetup(Continuation<? super Boolean> continuation) {
        return getUseCaseSurfaceManager().awaitSetupCompletion(continuation);
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public void close() {
        this.closed = true;
        Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "UseCaseCameraRequestControl: closed");
        }
        getUseCaseCameraState().close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Deferred<Void>> failedResults(int count, String message) {
        ArrayList arrayList = new ArrayList(count);
        for (int i = 0; i < count; i++) {
            CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            completableDeferredCompletableDeferred$default.completeExceptionally(new ImageCaptureException(2, message, null));
            arrayList.add(completableDeferredCompletableDeferred$default);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean hasInvalidSurface(List<CaptureConfig> list) {
        for (CaptureConfig captureConfig : list) {
            if (captureConfig.getSurfaces().isEmpty()) {
                return true;
            }
            List<DeferrableSurface> surfaces = captureConfig.getSurfaces();
            Intrinsics.checkNotNullExpressionValue(surfaces, "getSurfaces(...)");
            Iterator<T> it = surfaces.iterator();
            while (it.hasNext()) {
                if (this.useCaseGraphContext.getSurfaceToStreamMap().get((DeferrableSurface) it.next()) == null) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InfoBundle merge(Map<UseCaseCameraRequestControl.Type, InfoBundle> map) {
        InfoBundle infoBundle = new InfoBundle(null, null, null, RequestTemplate.m714boximpl(RequestTemplate.m715constructorimpl(1)), 7, null);
        Iterator<UseCaseCameraRequestControl.Type> it = UseCaseCameraRequestControl.Type.getEntries().iterator();
        while (it.hasNext()) {
            InfoBundle infoBundle2 = map.get(it.next());
            if (infoBundle2 != null) {
                infoBundle.getOptions().insertAllOptions(infoBundle2.getOptions().getMutableConfig());
                infoBundle.getTags().putAll(infoBundle2.getTags());
                infoBundle.getListeners().addAll(infoBundle2.getListeners());
                RequestTemplate requestTemplateM145getTemplateejQnlcg = infoBundle2.m145getTemplateejQnlcg();
                if (requestTemplateM145getTemplateejQnlcg != null) {
                    infoBundle.m146setTemplatexlOpshk(RequestTemplate.m714boximpl(requestTemplateM145getTemplateejQnlcg.m721unboximpl()));
                }
            }
        }
        return infoBundle;
    }

    private final TagBundle toTagBundle(InfoBundle infoBundle) {
        MutableTagBundle mutableTagBundleCreate = MutableTagBundle.create();
        for (Map.Entry<String, Object> entry : infoBundle.getTags().entrySet()) {
            mutableTagBundleCreate.putTag(entry.getKey(), entry.getValue());
        }
        Intrinsics.checkNotNullExpressionValue(mutableTagBundleCreate, "also(...)");
        return mutableTagBundleCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:31:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:33:0x00be A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object updateCameraStateAsync(InfoBundle infoBundle, Set<StreamId> set, Continuation<? super Deferred<Unit>> continuation) {
        C01941 c01941;
        Deferred deferred;
        int iM721unboximpl;
        Camera2CaptureRequestConfigurator camera2CaptureRequestConfigurator;
        if (continuation instanceof C01941) {
            c01941 = (C01941) continuation;
            if ((c01941.label & Integer.MIN_VALUE) != 0) {
                c01941.label -= Integer.MIN_VALUE;
            } else {
                c01941 = new C01941(continuation);
            }
        } else {
            c01941 = new C01941(continuation);
        }
        C01941 c01942 = c01941;
        Object objM149updateAsyncTp9XwKQ = c01942.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c01942.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objM149updateAsyncTp9XwKQ);
            if (this.closed) {
                deferred = null;
            } else {
                CameraXConfig cameraXConfig = this.cameraXConfig;
                if (cameraXConfig != null && (camera2CaptureRequestConfigurator = Camera2CaptureRequestConfiguratorKt.getCamera2CaptureRequestConfigurator(cameraXConfig)) != null) {
                    Camera2CaptureRequestConfiguratorKt.configureWithUnchecked(camera2CaptureRequestConfigurator, MapsKt.toMap(Camera2ImplConfigKt.toParameters(infoBundle.getOptions().build())));
                }
                CapturePipeline capturePipeline = getCapturePipeline();
                RequestTemplate requestTemplateM145getTemplateejQnlcg = infoBundle.m145getTemplateejQnlcg();
                Intrinsics.checkNotNull(requestTemplateM145getTemplateejQnlcg);
                if (requestTemplateM145getTemplateejQnlcg.m721unboximpl() != -1) {
                    RequestTemplate requestTemplateM145getTemplateejQnlcg2 = infoBundle.m145getTemplateejQnlcg();
                    Intrinsics.checkNotNull(requestTemplateM145getTemplateejQnlcg2);
                    iM721unboximpl = requestTemplateM145getTemplateejQnlcg2.m721unboximpl();
                } else {
                    iM721unboximpl = 1;
                }
                capturePipeline.setTemplate(iM721unboximpl);
                UseCaseCameraState useCaseCameraState = getUseCaseCameraState();
                Map<CaptureRequest.Key<?>, ? extends Object> parameters = Camera2ImplConfigKt.toParameters(infoBundle.getOptions().build());
                Map<androidx.camera.camera2.pipe.Metadata.Key<?>, ? extends Object> mapMapOf = MapsKt.mapOf(TuplesKt.to(TagsKt.getCAMERAX_TAG_BUNDLE(), toTagBundle(infoBundle)));
                RequestTemplate requestTemplateM145getTemplateejQnlcg3 = infoBundle.m145getTemplateejQnlcg();
                Set<Request.Listener> listeners = infoBundle.getListeners();
                c01942.label = 1;
                objM149updateAsyncTp9XwKQ = useCaseCameraState.m149updateAsyncTp9XwKQ(parameters, false, mapMapOf, false, set, requestTemplateM145getTemplateejQnlcg3, listeners, c01942);
                if (objM149updateAsyncTp9XwKQ == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            if (deferred == null) {
                return canceledResult;
            }
            return deferred;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(objM149updateAsyncTp9XwKQ);
        deferred = (Deferred) objM149updateAsyncTp9XwKQ;
        if (deferred == null) {
            return canceledResult;
        }
        return deferred;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object updateCameraStateAsync$default(UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl, InfoBundle infoBundle, Set set, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            set = null;
        }
        return useCaseCameraRequestControlImpl.updateCameraStateAsync(infoBundle, set, continuation);
    }

    private final <R> R runIfNotClosed(Function0<? extends R> block) {
        if (this.closed) {
            return null;
        }
        return block.invoke();
    }

    private final Object useGraphSessionOrFailed(Function2<? super CameraGraph.Session, ? super Continuation<? super Deferred<Result3A>>, ? extends Object> function2, Continuation<? super Deferred<Result3A>> continuation) {
        try {
            AutoCloseable autoCloseable = (AutoCloseable) this.useCaseGraphContext.getGraph().acquireSession(continuation);
            try {
                CameraGraph.Session session = (CameraGraph.Session) autoCloseable;
                Deferred deferred = (Deferred) function2.invoke(session, null);
                AutoCloseableKt.closeFinally(autoCloseable, null);
                return deferred;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    AutoCloseableKt.closeFinally(autoCloseable, th);
                    throw th2;
                }
            }
        } catch (CancellationException e) {
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            CancellationException cancellationException = e;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "Cannot acquire the CameraGraph.Session", cancellationException);
            }
            return submitFailedResult;
        }
    }

    private final <T> Deferred<T> runOnSequential(Function1<? super Continuation<? super Deferred<? extends T>>, ? extends Object> block) {
        CoroutineStart coroutineStartDetermineStartStrategy$camera_camera2 = determineStartStrategy$camera_camera2(this.threads);
        UseCaseThreads useCaseThreads = this.threads;
        CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        BuildersKt__Builders_commonKt.launch$default(useCaseThreads.getSequentialScope(), null, coroutineStartDetermineStartStrategy$camera_camera2, new UseCaseCameraRequestControlImpl$runOnSequential$$inlined$confineDeferredSuspend$1(block, completableDeferredCompletableDeferred$default, null), 1, null);
        return completableDeferredCompletableDeferred$default;
    }

    private final <T> List<Deferred<T>> runOnSequentialList(int size, Function1<? super Continuation<? super List<? extends Deferred<? extends T>>>, ? extends Object> block) {
        CoroutineStart coroutineStartDetermineStartStrategy$camera_camera2 = determineStartStrategy$camera_camera2(this.threads);
        UseCaseThreads useCaseThreads = this.threads;
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(CompletableDeferredKt.CompletableDeferred$default(null, 1, null));
        }
        ArrayList arrayList2 = arrayList;
        BuildersKt__Builders_commonKt.launch$default(useCaseThreads.getSequentialScope(), null, coroutineStartDetermineStartStrategy$camera_camera2, new UseCaseCameraRequestControlImpl$runOnSequentialList$$inlined$confineDeferredListSuspend$1(block, arrayList2, null), 1, null);
        return arrayList2;
    }

    public final CoroutineStart determineStartStrategy$camera_camera2(UseCaseThreads useCaseThreads) {
        Intrinsics.checkNotNullParameter(useCaseThreads, "<this>");
        return useCaseThreads.isOnSequentialThread() ? CoroutineStart.UNDISPATCHED : CoroutineStart.DEFAULT;
    }

    /* JADX INFO: compiled from: UseCaseCameraRequestControl.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\t\u001a\u00020\n*\u00020\u000bJ\u0016\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r*\u00020\u000bJ\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010*\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013J\u0011\u0010\u0014\u001a\u00020\u0015*\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0018\u001a\u00020\u0019*\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\f\u0010\t\u001a\u00020\n*\u00020\u001aH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/camera/camera2/impl/UseCaseCameraRequestControlImpl$Companion;", "", "<init>", "()V", "submitFailedResult", "Lkotlinx/coroutines/CompletableDeferred;", "Landroidx/camera/camera2/pipe/Result3A;", "canceledResult", "", "extractCamera2ImplConfigBuilder", "Landroidx/camera/camera2/impl/Camera2ImplConfig$Builder;", "Landroidx/camera/core/impl/SessionConfig;", "extractTags", "", "", "extractListeners", "", "Landroidx/camera/camera2/pipe/Request$Listener;", "callbackExecutor", "Ljava/util/concurrent/Executor;", "extractTemplate", "Landroidx/camera/camera2/pipe/RequestTemplate;", "extractTemplate-ARED-Gk", "(Landroidx/camera/core/impl/SessionConfig;)I", "toInfoBundle", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControlImpl$InfoBundle;", "Landroidx/camera/core/impl/Config;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Camera2ImplConfig.Builder extractCamera2ImplConfigBuilder(SessionConfig sessionConfig) {
            Intrinsics.checkNotNullParameter(sessionConfig, "<this>");
            Camera2ImplConfig.Builder builder = new Camera2ImplConfig.Builder();
            if (!Intrinsics.areEqual(sessionConfig.getExpectedFrameRateRange(), StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED)) {
                CaptureRequest.Key CONTROL_AE_TARGET_FPS_RANGE = CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE;
                Intrinsics.checkNotNullExpressionValue(CONTROL_AE_TARGET_FPS_RANGE, "CONTROL_AE_TARGET_FPS_RANGE");
                builder.setCaptureRequestOption(CONTROL_AE_TARGET_FPS_RANGE, sessionConfig.getExpectedFrameRateRange());
            }
            Config implementationOptions = sessionConfig.getImplementationOptions();
            Intrinsics.checkNotNullExpressionValue(implementationOptions, "getImplementationOptions(...)");
            builder.insertAllOptions(implementationOptions);
            return builder;
        }

        public final Map<String, Object> extractTags(SessionConfig sessionConfig) {
            Intrinsics.checkNotNullParameter(sessionConfig, "<this>");
            TagBundle tagBundle = sessionConfig.getRepeatingCaptureConfig().getTagBundle();
            Intrinsics.checkNotNullExpressionValue(tagBundle, "getTagBundle(...)");
            return MapsKt.toMutableMap(UseCaseCameraRequestControlKt.toMap(tagBundle));
        }

        public final Set<Request.Listener> extractListeners(SessionConfig sessionConfig, Executor callbackExecutor) {
            Intrinsics.checkNotNullParameter(sessionConfig, "<this>");
            Intrinsics.checkNotNullParameter(callbackExecutor, "callbackExecutor");
            CameraCallbackMap.Companion companion = CameraCallbackMap.INSTANCE;
            List<CameraCaptureCallback> repeatingCameraCaptureCallbacks = sessionConfig.getRepeatingCameraCaptureCallbacks();
            Intrinsics.checkNotNullExpressionValue(repeatingCameraCaptureCallbacks, "getRepeatingCameraCaptureCallbacks(...)");
            return SetsKt.mutableSetOf(companion.createFor(repeatingCameraCaptureCallbacks, callbackExecutor));
        }

        /* JADX INFO: renamed from: extractTemplate-ARED-Gk, reason: not valid java name */
        public final int m141extractTemplateAREDGk(SessionConfig extractTemplate) {
            Intrinsics.checkNotNullParameter(extractTemplate, "$this$extractTemplate");
            return RequestTemplate.m715constructorimpl(extractTemplate.getTemplateType());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final InfoBundle toInfoBundle(SessionConfig sessionConfig, Executor executor) {
            return new InfoBundle(extractCamera2ImplConfigBuilder(sessionConfig), extractTags(sessionConfig), extractListeners(sessionConfig, executor), RequestTemplate.m714boximpl(m141extractTemplateAREDGk(sessionConfig)), null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Camera2ImplConfig.Builder extractCamera2ImplConfigBuilder(Config config) {
            Camera2ImplConfig.Builder builder = new Camera2ImplConfig.Builder();
            builder.insertAllOptions(config);
            return builder;
        }
    }

    static {
        CompletableDeferred<Unit> completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        Job.DefaultImpls.cancel$default((Job) completableDeferredCompletableDeferred$default, (CancellationException) null, 1, (Object) null);
        canceledResult = completableDeferredCompletableDeferred$default;
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public Deferred<Unit> setParametersAsync(Map<CaptureRequest.Key<?>, ? extends Object> values, UseCaseCameraRequestControl.Type type, Config.OptionPriority optionPriority) {
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(optionPriority, "optionPriority");
        Deferred<Unit> deferredRunOnSequential = !this.closed ? runOnSequential(new UseCaseCameraRequestControlImpl$setParametersAsync$1$1(this, type, values, optionPriority, null)) : null;
        return deferredRunOnSequential == null ? canceledResult : deferredRunOnSequential;
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public Deferred<Unit> removeParametersAsync(List<? extends CaptureRequest.Key<?>> keys, UseCaseCameraRequestControl.Type type) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Intrinsics.checkNotNullParameter(type, "type");
        Deferred<Unit> deferredRunOnSequential = this.closed ? null : runOnSequential(new UseCaseCameraRequestControlImpl$removeParametersAsync$1$1(this, type, keys, null));
        return deferredRunOnSequential == null ? canceledResult : deferredRunOnSequential;
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public Deferred<Unit> updateRepeatingRequestAsync(boolean isPrimary, Collection<? extends UseCase> runningUseCases) {
        Intrinsics.checkNotNullParameter(runningUseCases, "runningUseCases");
        Deferred<Unit> deferredRunOnSequential = this.closed ? null : runOnSequential(new UseCaseCameraRequestControlImpl$updateRepeatingRequestAsync$1$1(runningUseCases, isPrimary, this, null));
        return deferredRunOnSequential == null ? canceledResult : deferredRunOnSequential;
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public Deferred<Unit> updateCamera2ConfigAsync(Config config, Map<String, ? extends Object> tags) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Deferred<Unit> deferredRunOnSequential = this.closed ? null : runOnSequential(new UseCaseCameraRequestControlImpl$updateCamera2ConfigAsync$1$1(this, config, tags, null));
        return deferredRunOnSequential == null ? canceledResult : deferredRunOnSequential;
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public Deferred<Result3A> setTorchOnAsync() {
        Deferred<Result3A> deferredRunOnSequential = this.closed ? null : runOnSequential(new UseCaseCameraRequestControlImpl$setTorchOnAsync$1$1(this, null));
        return deferredRunOnSequential == null ? submitFailedResult : deferredRunOnSequential;
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    /* JADX INFO: renamed from: setTorchOffAsync-MtizInI */
    public Deferred<Result3A> mo111setTorchOffAsyncMtizInI(int aeMode) {
        Deferred<Result3A> deferredRunOnSequential = this.closed ? null : runOnSequential(new UseCaseCameraRequestControlImpl$setTorchOffAsync$1$1(this, aeMode, null));
        return deferredRunOnSequential == null ? submitFailedResult : deferredRunOnSequential;
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    /* JADX INFO: renamed from: startFocusAndMeteringAsync-NxRnBj4 */
    public Deferred<Result3A> mo112startFocusAndMeteringAsyncNxRnBj4(List<MeteringRectangle> aeRegions, List<MeteringRectangle> afRegions, List<MeteringRectangle> awbRegions, Lock3ABehavior aeLockBehavior, Lock3ABehavior afLockBehavior, Lock3ABehavior awbLockBehavior, AeMode afTriggerStartAeMode, long timeLimitNs) {
        Deferred<Result3A> deferredRunOnSequential = !this.closed ? runOnSequential(new UseCaseCameraRequestControlImpl$startFocusAndMeteringAsync$1$1(this, aeRegions, afRegions, awbRegions, aeLockBehavior, afLockBehavior, awbLockBehavior, afTriggerStartAeMode, timeLimitNs, null)) : null;
        return deferredRunOnSequential == null ? submitFailedResult : deferredRunOnSequential;
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public Deferred<Result3A> cancelFocusAndMeteringAsync() {
        Deferred<Result3A> deferredRunOnSequential = this.closed ? null : runOnSequential(new UseCaseCameraRequestControlImpl$cancelFocusAndMeteringAsync$1$1(this, null));
        return deferredRunOnSequential == null ? submitFailedResult : deferredRunOnSequential;
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public List<Deferred<Void>> issueSingleCaptureAsync(List<CaptureConfig> captureSequence, int captureMode, int flashType, int flashMode) {
        UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl;
        List<CaptureConfig> list;
        List<Deferred<Void>> listRunOnSequentialList;
        Intrinsics.checkNotNullParameter(captureSequence, "captureSequence");
        if (this.closed) {
            useCaseCameraRequestControlImpl = this;
            list = captureSequence;
            listRunOnSequentialList = null;
        } else {
            useCaseCameraRequestControlImpl = this;
            list = captureSequence;
            listRunOnSequentialList = useCaseCameraRequestControlImpl.runOnSequentialList(captureSequence.size(), new UseCaseCameraRequestControlImpl$issueSingleCaptureAsync$1$1(useCaseCameraRequestControlImpl, list, captureMode, flashType, flashMode, null));
        }
        return listRunOnSequentialList == null ? useCaseCameraRequestControlImpl.failedResults(list.size(), "Capture request is cancelled on closed CameraGraph") : listRunOnSequentialList;
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraRequestControl
    public Deferred<Result3A> update3aRegions(List<MeteringRectangle> aeRegions, List<MeteringRectangle> afRegions, List<MeteringRectangle> awbRegions) {
        Deferred<Result3A> deferredRunOnSequential = !this.closed ? runOnSequential(new UseCaseCameraRequestControlImpl$update3aRegions$1$1(this, aeRegions, afRegions, awbRegions, null)) : null;
        return deferredRunOnSequential == null ? submitFailedResult : deferredRunOnSequential;
    }
}

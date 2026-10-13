package androidx.camera.camera2.compat.workaround;

import androidx.camera.camera2.adapter.CaptureConfigAdapter;
import androidx.camera.camera2.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.compat.quirk.TorchIsClosedAfterImageCapturingQuirk;
import androidx.camera.camera2.config.UseCaseCameraScope;
import androidx.camera.camera2.impl.CameraProperties;
import androidx.camera.camera2.impl.CapturePipeline;
import androidx.camera.camera2.impl.CapturePipelineImpl;
import androidx.camera.camera2.impl.TorchControl;
import androidx.camera.camera2.impl.UseCaseThreads;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.core.imagecapture.CameraCapturePipeline;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: CapturePipelineTorchCorrection.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 52\u00020\u0001:\u00015B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJT\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00190\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H\u0096@¢\u0006\u0004\b%\u0010&J&\u0010'\u001a\u00020(2\u0006\u0010!\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010)J%\u00100\u001a\u00020\u000e2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0002¢\u0006\u0004\b2\u00103J\b\u00104\u001a\u00020\u000eH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\r\u0010\u000fR#\u0010\u0012\u001a\n \u0013*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R$\u0010+\u001a\u00020\"2\u0006\u0010*\u001a\u00020\"@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00066"}, d2 = {"Landroidx/camera/camera2/compat/workaround/CapturePipelineTorchCorrection;", "Landroidx/camera/camera2/impl/CapturePipeline;", "cameraProperties", "Landroidx/camera/camera2/impl/CameraProperties;", "capturePipelineImplProvider", "Ljavax/inject/Provider;", "Landroidx/camera/camera2/impl/CapturePipelineImpl;", "threads", "Landroidx/camera/camera2/impl/UseCaseThreads;", "torchControl", "Landroidx/camera/camera2/impl/TorchControl;", "<init>", "(Landroidx/camera/camera2/impl/CameraProperties;Ljavax/inject/Provider;Landroidx/camera/camera2/impl/UseCaseThreads;Landroidx/camera/camera2/impl/TorchControl;)V", "isLegacyDevice", "", "()Z", "isLegacyDevice$delegate", "Lkotlin/Lazy;", "capturePipelineImpl", "kotlin.jvm.PlatformType", "getCapturePipelineImpl", "()Landroidx/camera/camera2/impl/CapturePipelineImpl;", "capturePipelineImpl$delegate", "submitStillCaptures", "", "Lkotlinx/coroutines/Deferred;", "Ljava/lang/Void;", "configs", "Landroidx/camera/core/impl/CaptureConfig;", "requestTemplate", "Landroidx/camera/camera2/pipe/RequestTemplate;", "sessionConfigOptions", "Landroidx/camera/core/impl/Config;", "captureMode", "", "flashType", "flashMode", "submitStillCaptures-BvXKQx0", "(Ljava/util/List;ILandroidx/camera/core/impl/Config;IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCameraCapturePipeline", "Landroidx/camera/core/imagecapture/CameraCapturePipeline;", "(IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "value", "template", "getTemplate", "()I", "setTemplate", "(I)V", "isCorrectionRequired", "captureConfigs", "isCorrectionRequired-0UCm73U", "(Ljava/util/List;I)Z", "isTorchOn", "Companion", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
@UseCaseCameraScope
public final class CapturePipelineTorchCorrection implements CapturePipeline {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final boolean isEnabled;

    /* JADX INFO: renamed from: capturePipelineImpl$delegate, reason: from kotlin metadata */
    private final Lazy capturePipelineImpl;
    private final Provider<CapturePipelineImpl> capturePipelineImplProvider;

    /* JADX INFO: renamed from: isLegacyDevice$delegate, reason: from kotlin metadata */
    private final Lazy isLegacyDevice;
    private int template;
    private final UseCaseThreads threads;
    private final TorchControl torchControl;

    @Inject
    public CapturePipelineTorchCorrection(final CameraProperties cameraProperties, Provider<CapturePipelineImpl> capturePipelineImplProvider, UseCaseThreads threads, TorchControl torchControl) {
        Intrinsics.checkNotNullParameter(cameraProperties, "cameraProperties");
        Intrinsics.checkNotNullParameter(capturePipelineImplProvider, "capturePipelineImplProvider");
        Intrinsics.checkNotNullParameter(threads, "threads");
        Intrinsics.checkNotNullParameter(torchControl, "torchControl");
        this.capturePipelineImplProvider = capturePipelineImplProvider;
        this.threads = threads;
        this.torchControl = torchControl;
        this.isLegacyDevice = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.compat.workaround.CapturePipelineTorchCorrection$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CameraMetadata.INSTANCE.isHardwareLevelLegacy(cameraProperties.getMetadata()));
            }
        });
        this.capturePipelineImpl = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.compat.workaround.CapturePipelineTorchCorrection$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.capturePipelineImplProvider.get();
            }
        });
        this.template = 1;
    }

    private final boolean isLegacyDevice() {
        return ((Boolean) this.isLegacyDevice.getValue()).booleanValue();
    }

    private final CapturePipelineImpl getCapturePipelineImpl() {
        return (CapturePipelineImpl) this.capturePipelineImpl.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    @Override // androidx.camera.camera2.impl.CapturePipeline
    /* JADX INFO: renamed from: submitStillCaptures-BvXKQx0, reason: not valid java name */
    public Object mo75submitStillCapturesBvXKQx0(List<CaptureConfig> list, int i, Config config, int i2, int i3, int i4, Continuation<? super List<? extends Deferred<Void>>> continuation) {
        CapturePipelineTorchCorrection$submitStillCaptures$1 capturePipelineTorchCorrection$submitStillCaptures$1;
        boolean z;
        if (continuation instanceof CapturePipelineTorchCorrection$submitStillCaptures$1) {
            capturePipelineTorchCorrection$submitStillCaptures$1 = (CapturePipelineTorchCorrection$submitStillCaptures$1) continuation;
            if ((capturePipelineTorchCorrection$submitStillCaptures$1.label & Integer.MIN_VALUE) != 0) {
                capturePipelineTorchCorrection$submitStillCaptures$1.label -= Integer.MIN_VALUE;
            } else {
                capturePipelineTorchCorrection$submitStillCaptures$1 = new CapturePipelineTorchCorrection$submitStillCaptures$1(this, continuation);
            }
        } else {
            capturePipelineTorchCorrection$submitStillCaptures$1 = new CapturePipelineTorchCorrection$submitStillCaptures$1(this, continuation);
        }
        CapturePipelineTorchCorrection$submitStillCaptures$1 capturePipelineTorchCorrection$submitStillCaptures$2 = capturePipelineTorchCorrection$submitStillCaptures$1;
        Object obj = capturePipelineTorchCorrection$submitStillCaptures$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = capturePipelineTorchCorrection$submitStillCaptures$2.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            boolean zM74isCorrectionRequired0UCm73U = m74isCorrectionRequired0UCm73U(list, i);
            CapturePipelineImpl capturePipelineImpl = getCapturePipelineImpl();
            capturePipelineTorchCorrection$submitStillCaptures$2.Z$0 = zM74isCorrectionRequired0UCm73U;
            capturePipelineTorchCorrection$submitStillCaptures$2.label = 1;
            Object objMo75submitStillCapturesBvXKQx0 = capturePipelineImpl.mo75submitStillCapturesBvXKQx0(list, i, config, i2, i3, i4, capturePipelineTorchCorrection$submitStillCaptures$2);
            if (objMo75submitStillCapturesBvXKQx0 == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = objMo75submitStillCapturesBvXKQx0;
            z = zM74isCorrectionRequired0UCm73U;
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z = capturePipelineTorchCorrection$submitStillCaptures$2.Z$0;
            ResultKt.throwOnFailure(obj);
        }
        List list2 = (List) obj;
        if (z) {
            BuildersKt__Builders_commonKt.launch$default(this.threads.getSequentialScope(), null, null, new CapturePipelineTorchCorrection$submitStillCaptures$2(list2, this, null), 3, null);
        }
        return list2;
    }

    @Override // androidx.camera.camera2.impl.CapturePipeline
    public Object getCameraCapturePipeline(int i, int i2, int i3, Continuation<? super CameraCapturePipeline> continuation) {
        return getCapturePipelineImpl().getCameraCapturePipeline(i, i2, i3, continuation);
    }

    @Override // androidx.camera.camera2.impl.CapturePipeline
    public int getTemplate() {
        return this.template;
    }

    @Override // androidx.camera.camera2.impl.CapturePipeline
    public void setTemplate(int i) {
        getCapturePipelineImpl().setTemplate(i);
        this.template = i;
    }

    /* JADX INFO: renamed from: isCorrectionRequired-0UCm73U, reason: not valid java name */
    private final boolean m74isCorrectionRequired0UCm73U(List<CaptureConfig> captureConfigs, int requestTemplate) {
        List<CaptureConfig> list = captureConfigs;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (CaptureConfigAdapter.INSTANCE.m48getStillCaptureTemplateCMLptTo$camera_camera2((CaptureConfig) it.next(), requestTemplate, isLegacyDevice()) == 2) {
                return isTorchOn();
            }
        }
        return false;
    }

    private final boolean isTorchOn() {
        Integer value = this.torchControl.getTorchStateLiveData().getValue();
        return value != null && value.intValue() == 1;
    }

    /* JADX INFO: compiled from: CapturePipelineTorchCorrection.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/camera/camera2/compat/workaround/CapturePipelineTorchCorrection$Companion;", "", "<init>", "()V", "isEnabled", "", "()Z", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isEnabled() {
            return CapturePipelineTorchCorrection.isEnabled;
        }
    }

    static {
        isEnabled = DeviceQuirks.INSTANCE.get(TorchIsClosedAfterImageCapturingQuirk.class) != null;
    }
}

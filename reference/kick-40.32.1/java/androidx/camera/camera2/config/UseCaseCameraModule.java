package androidx.camera.camera2.config;

import androidx.camera.camera2.compat.workaround.CapturePipelineTorchCorrection;
import androidx.camera.camera2.impl.CapturePipeline;
import androidx.camera.camera2.impl.CapturePipelineImpl;
import androidx.camera.camera2.impl.UseCaseCameraImpl;
import androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl;
import dagger.Module;
import dagger.Provides;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UseCaseCameraConfig.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b'\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/camera/camera2/config/UseCaseCameraModule;", "", "<init>", "()V", "Companion", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Module(includes = {UseCaseCameraImpl.Bindings.class, UseCaseCameraRequestControlImpl.Bindings.class})
public abstract class UseCaseCameraModule {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: UseCaseCameraConfig.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0007¨\u0006\u000b"}, d2 = {"Landroidx/camera/camera2/config/UseCaseCameraModule$Companion;", "", "<init>", "()V", "provideCapturePipeline", "Landroidx/camera/camera2/impl/CapturePipeline;", "capturePipelineImplProvider", "Ljavax/inject/Provider;", "Landroidx/camera/camera2/impl/CapturePipelineImpl;", "capturePipelineTorchCorrectionProvider", "Landroidx/camera/camera2/compat/workaround/CapturePipelineTorchCorrection;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Provides
        @UseCaseCameraScope
        public final CapturePipeline provideCapturePipeline(Provider<CapturePipelineImpl> capturePipelineImplProvider, Provider<CapturePipelineTorchCorrection> capturePipelineTorchCorrectionProvider) {
            Intrinsics.checkNotNullParameter(capturePipelineImplProvider, "capturePipelineImplProvider");
            Intrinsics.checkNotNullParameter(capturePipelineTorchCorrectionProvider, "capturePipelineTorchCorrectionProvider");
            if (CapturePipelineTorchCorrection.INSTANCE.isEnabled()) {
                CapturePipelineTorchCorrection capturePipelineTorchCorrection = capturePipelineTorchCorrectionProvider.get();
                Intrinsics.checkNotNullExpressionValue(capturePipelineTorchCorrection, "get(...)");
                return capturePipelineTorchCorrection;
            }
            CapturePipelineImpl capturePipelineImpl = capturePipelineImplProvider.get();
            Intrinsics.checkNotNullExpressionValue(capturePipelineImpl, "get(...)");
            return capturePipelineImpl;
        }
    }
}

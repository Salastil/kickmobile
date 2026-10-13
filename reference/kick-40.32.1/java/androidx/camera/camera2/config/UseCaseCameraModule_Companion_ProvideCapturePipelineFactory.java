package androidx.camera.camera2.config;

import androidx.camera.camera2.compat.workaround.CapturePipelineTorchCorrection;
import androidx.camera.camera2.impl.CapturePipeline;
import androidx.camera.camera2.impl.CapturePipelineImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class UseCaseCameraModule_Companion_ProvideCapturePipelineFactory implements Factory<CapturePipeline> {
    private final Provider<CapturePipelineImpl> capturePipelineImplProvider;
    private final Provider<CapturePipelineTorchCorrection> capturePipelineTorchCorrectionProvider;

    private UseCaseCameraModule_Companion_ProvideCapturePipelineFactory(Provider<CapturePipelineImpl> provider, Provider<CapturePipelineTorchCorrection> provider2) {
        this.capturePipelineImplProvider = provider;
        this.capturePipelineTorchCorrectionProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CapturePipeline get() {
        return provideCapturePipeline(this.capturePipelineImplProvider, this.capturePipelineTorchCorrectionProvider);
    }

    public static UseCaseCameraModule_Companion_ProvideCapturePipelineFactory create(Provider<CapturePipelineImpl> provider, Provider<CapturePipelineTorchCorrection> provider2) {
        return new UseCaseCameraModule_Companion_ProvideCapturePipelineFactory(provider, provider2);
    }

    public static CapturePipeline provideCapturePipeline(javax.inject.Provider<CapturePipelineImpl> provider, javax.inject.Provider<CapturePipelineTorchCorrection> provider2) {
        return (CapturePipeline) Preconditions.checkNotNullFromProvides(UseCaseCameraModule.INSTANCE.provideCapturePipeline(provider, provider2));
    }
}

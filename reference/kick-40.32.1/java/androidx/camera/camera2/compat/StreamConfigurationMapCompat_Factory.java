package androidx.camera.camera2.compat;

import android.hardware.camera2.params.StreamConfigurationMap;
import androidx.camera.camera2.compat.workaround.OutputSizesCorrector;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class StreamConfigurationMapCompat_Factory implements Factory<StreamConfigurationMapCompat> {
    private final Provider<StreamConfigurationMap> mapProvider;
    private final Provider<OutputSizesCorrector> outputSizesCorrectorProvider;

    private StreamConfigurationMapCompat_Factory(Provider<StreamConfigurationMap> provider, Provider<OutputSizesCorrector> provider2) {
        this.mapProvider = provider;
        this.outputSizesCorrectorProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public StreamConfigurationMapCompat get() {
        return newInstance(this.mapProvider.get(), this.outputSizesCorrectorProvider.get());
    }

    public static StreamConfigurationMapCompat_Factory create(Provider<StreamConfigurationMap> provider, Provider<OutputSizesCorrector> provider2) {
        return new StreamConfigurationMapCompat_Factory(provider, provider2);
    }

    public static StreamConfigurationMapCompat newInstance(StreamConfigurationMap streamConfigurationMap, OutputSizesCorrector outputSizesCorrector) {
        return new StreamConfigurationMapCompat(streamConfigurationMap, outputSizesCorrector);
    }
}

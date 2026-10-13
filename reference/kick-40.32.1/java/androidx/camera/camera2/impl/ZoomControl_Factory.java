package androidx.camera.camera2.impl;

import androidx.camera.camera2.compat.ZoomCompat;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ZoomControl_Factory implements Factory<ZoomControl> {
    private final Provider<ZoomCompat> zoomCompatProvider;

    private ZoomControl_Factory(Provider<ZoomCompat> provider) {
        this.zoomCompatProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ZoomControl get() {
        return newInstance(this.zoomCompatProvider.get());
    }

    public static ZoomControl_Factory create(Provider<ZoomCompat> provider) {
        return new ZoomControl_Factory(provider);
    }

    public static ZoomControl newInstance(ZoomCompat zoomCompat) {
        return new ZoomControl(zoomCompat);
    }
}

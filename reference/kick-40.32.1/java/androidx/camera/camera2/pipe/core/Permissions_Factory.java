package androidx.camera.camera2.pipe.core;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class Permissions_Factory implements Factory<Permissions> {
    private final Provider<Context> cameraPipeContextProvider;

    private Permissions_Factory(Provider<Context> provider) {
        this.cameraPipeContextProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Permissions get() {
        return newInstance(this.cameraPipeContextProvider.get());
    }

    public static Permissions_Factory create(Provider<Context> provider) {
        return new Permissions_Factory(provider);
    }

    public static Permissions newInstance(Context context) {
        return new Permissions(context);
    }
}

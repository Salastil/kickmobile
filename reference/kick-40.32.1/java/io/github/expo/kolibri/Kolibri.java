package io.github.expo.kolibri;

import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: compiled from: Kolibri.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lio/github/expo/kolibri/Kolibri;", "", "<init>", "()V", "loaded", "", "isLoaded", "()Z", "load", "", "runtime"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Kolibri {
    public static final Kolibri INSTANCE = new Kolibri();
    private static volatile boolean loaded;

    private Kolibri() {
    }

    public final boolean isLoaded() {
        return loaded;
    }

    public final void load() {
        synchronized (this) {
            if (loaded) {
                return;
            }
            try {
                System.loadLibrary("expo-kolibri");
                loaded = true;
                Unit unit = Unit.INSTANCE;
            } catch (UnsatisfiedLinkError e) {
                throw new IllegalStateException("Kolibri's native library (expo-kolibri) could not be loaded.", e);
            }
        }
    }
}

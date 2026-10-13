package io.github.expo.kolibri;

import kotlin.Metadata;

/* JADX INFO: compiled from: NativeCleaner.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/github/expo/kolibri/NativeCleaner;", "", "<init>", "()V", "cleaner", "Lio/github/expo/kolibri/Cleaner;", "getCleaner", "()Lio/github/expo/kolibri/Cleaner;", "runtime"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NativeCleaner {
    public static final NativeCleaner INSTANCE = new NativeCleaner();
    private static final Cleaner cleaner = Cleaner.INSTANCE.create();

    private NativeCleaner() {
    }

    public final Cleaner getCleaner() {
        return cleaner;
    }
}

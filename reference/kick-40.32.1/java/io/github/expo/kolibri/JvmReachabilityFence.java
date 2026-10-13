package io.github.expo.kolibri;

import java.lang.ref.Reference;
import kotlin.Metadata;

/* JADX INFO: compiled from: NativeObject.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¨\u0006\u0007"}, d2 = {"Lio/github/expo/kolibri/JvmReachabilityFence;", "", "<init>", "()V", "fence", "", "obj", "runtime"}, k = 1, mv = {2, 2, 0}, xi = 48)
final class JvmReachabilityFence {
    public static final JvmReachabilityFence INSTANCE = new JvmReachabilityFence();

    private JvmReachabilityFence() {
    }

    public final void fence(Object obj) {
        Reference.reachabilityFence(obj);
    }
}

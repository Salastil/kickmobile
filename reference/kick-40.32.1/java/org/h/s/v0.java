package org.h.s;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.ProcessLifecycleOwner;
import io.mobileshield.sdk.internal.lifecycle.ProcessObserver;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f580a;
    public final ProcessObserver b;

    public v0(Handler mainLoopHandler, ProcessObserver processObserver) {
        Intrinsics.checkNotNullParameter(mainLoopHandler, "mainLoopHandler");
        Intrinsics.checkNotNullParameter(processObserver, "processObserver");
        this.f580a = mainLoopHandler;
        this.b = processObserver;
        a();
    }

    public final void a() {
        this.f580a.post(new Runnable() { // from class: org.h.s.v0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                v0.a(this.f$0);
            }
        });
    }

    public final void b() {
        this.f580a.post(new Runnable() { // from class: org.h.s.v0$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                v0.b(this.f$0);
            }
        });
    }

    public static final void a(v0 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ProcessLifecycleOwner.get().getLifecycleRegistry().addObserver(this$0.b);
    }

    public static final void b(v0 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ProcessLifecycleOwner.get().getLifecycleRegistry().removeObserver(this$0.b);
    }

    public /* synthetic */ v0() {
        this(new Handler(Looper.getMainLooper()), new ProcessObserver());
    }
}

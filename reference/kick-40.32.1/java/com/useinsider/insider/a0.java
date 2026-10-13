package com.useinsider.insider;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class a0 extends k3 implements z, LifecycleEventObserver {

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f310a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            f310a = iArr;
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f310a[Lifecycle.Event.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    a0() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ProcessLifecycleOwner.get().getLifecycleRegistry().addObserver(this);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.useinsider.insider.a0$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.f();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        ProcessLifecycleOwner.get().getLifecycleRegistry().addObserver(this);
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        int i = a.f310a[event.ordinal()];
        if (i == 1) {
            a(new Consumer() { // from class: com.useinsider.insider.a0$$ExternalSyntheticLambda1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((b0) obj).a();
                }
            });
        } else {
            if (i != 2) {
                return;
            }
            a(new Consumer() { // from class: com.useinsider.insider.a0$$ExternalSyntheticLambda0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((b0) obj).c();
                }
            });
        }
    }

    @Override // com.useinsider.insider.k3, com.useinsider.insider.j3
    public synchronized void a(b0 b0Var) {
        super.a((Object) b0Var);
        if (a()) {
            return;
        }
        b0Var.a();
    }

    @Override // com.useinsider.insider.z
    public boolean a() {
        return !ProcessLifecycleOwner.get().getLifecycleRegistry().getState().isAtLeast(Lifecycle.State.STARTED);
    }
}

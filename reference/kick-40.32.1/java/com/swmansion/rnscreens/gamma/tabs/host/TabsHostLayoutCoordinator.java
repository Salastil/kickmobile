package com.swmansion.rnscreens.gamma.tabs.host;

import android.view.Choreographer;
import com.facebook.react.modules.core.ReactChoreographer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TabsHostLayoutCoordinator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\f\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\rJ\r\u0010\u000e\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/host/TabsHostLayoutCoordinator;", "", "hostView", "Lcom/swmansion/rnscreens/gamma/tabs/host/TabsHost;", "layoutCallback", "Lkotlin/Function0;", "", "<init>", "(Lcom/swmansion/rnscreens/gamma/tabs/host/TabsHost;Lkotlin/jvm/functions/Function0;)V", "hasPostLayoutPending", "", "hasChoreographerLayoutPending", "postLayoutToMessageQueue", "postLayoutToMessageQueue$react_native_screens_release", "postLayoutToReactChoreographer", "postLayoutToReactChoreographer$react_native_screens_release", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TabsHostLayoutCoordinator {
    private boolean hasChoreographerLayoutPending;
    private boolean hasPostLayoutPending;
    private final TabsHost hostView;
    private final Function0<Unit> layoutCallback;

    public TabsHostLayoutCoordinator(TabsHost hostView, Function0<Unit> layoutCallback) {
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        Intrinsics.checkNotNullParameter(layoutCallback, "layoutCallback");
        this.hostView = hostView;
        this.layoutCallback = layoutCallback;
    }

    public final void postLayoutToMessageQueue$react_native_screens_release() {
        if (this.hasPostLayoutPending) {
            return;
        }
        this.hasPostLayoutPending = true;
        this.hostView.post(new Runnable() { // from class: com.swmansion.rnscreens.gamma.tabs.host.TabsHostLayoutCoordinator$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                TabsHostLayoutCoordinator.postLayoutToMessageQueue$lambda$0(this.f$0);
            }
        });
    }

    static final void postLayoutToMessageQueue$lambda$0(TabsHostLayoutCoordinator tabsHostLayoutCoordinator) {
        tabsHostLayoutCoordinator.hasPostLayoutPending = false;
        tabsHostLayoutCoordinator.layoutCallback.invoke();
    }

    public final void postLayoutToReactChoreographer$react_native_screens_release() {
        if (this.hasChoreographerLayoutPending) {
            return;
        }
        this.hasChoreographerLayoutPending = true;
        ReactChoreographer.INSTANCE.getInstance().postFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, new Choreographer.FrameCallback() { // from class: com.swmansion.rnscreens.gamma.tabs.host.TabsHostLayoutCoordinator$$ExternalSyntheticLambda1
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                TabsHostLayoutCoordinator.postLayoutToReactChoreographer$lambda$0(this.f$0, j);
            }
        });
    }

    static final void postLayoutToReactChoreographer$lambda$0(TabsHostLayoutCoordinator tabsHostLayoutCoordinator, long j) {
        tabsHostLayoutCoordinator.hasChoreographerLayoutPending = false;
        tabsHostLayoutCoordinator.layoutCallback.invoke();
    }
}

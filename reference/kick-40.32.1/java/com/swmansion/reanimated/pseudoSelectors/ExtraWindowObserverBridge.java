package com.swmansion.reanimated.pseudoSelectors;

import android.util.Log;
import android.view.Window;
import com.facebook.react.bridge.ReactContext;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExtraWindowObserverBridge.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/swmansion/reanimated/pseudoSelectors/ExtraWindowObserverBridge;", "", "reactContext", "Lcom/facebook/react/bridge/ReactContext;", "hover", "Lcom/swmansion/reanimated/pseudoSelectors/TouchHoverCoordinator;", "<init>", "(Lcom/facebook/react/bridge/ReactContext;Lcom/swmansion/reanimated/pseudoSelectors/TouchHoverCoordinator;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "install", "", "uninstall", "Companion", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ExtraWindowObserverBridge {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String LISTENER_CLASS = "com.facebook.react.interfaces.ExtraWindowEventListener";

    @Deprecated
    public static final String TAG = "Reanimated";
    private final TouchHoverCoordinator hover;
    private Object listener;
    private final ReactContext reactContext;

    public ExtraWindowObserverBridge(ReactContext reactContext, TouchHoverCoordinator hover) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(hover, "hover");
        this.reactContext = reactContext;
        this.hover = hover;
    }

    public final void install() {
        if (this.listener != null) {
            return;
        }
        try {
            Class<?> cls = Class.forName(LISTENER_CLASS);
            Object objNewProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: com.swmansion.reanimated.pseudoSelectors.ExtraWindowObserverBridge$$ExternalSyntheticLambda0
                @Override // java.lang.reflect.InvocationHandler
                public final Object invoke(Object obj, Method method, Object[] objArr) {
                    return ExtraWindowObserverBridge.install$lambda$0(this.f$0, obj, method, objArr);
                }
            });
            this.reactContext.getClass().getMethod("addExtraWindowEventListener", cls).invoke(this.reactContext, objNewProxyInstance);
            this.listener = objNewProxyInstance;
        } catch (Throwable th) {
            Log.w(TAG, "ExtraWindowEventListener unavailable; modal :hover uses the per-view fallback", th);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    static final Object install$lambda$0(ExtraWindowObserverBridge extraWindowObserverBridge, Object obj, Method method, Object[] objArr) {
        String name = method.getName();
        if (name == null) {
            return null;
        }
        switch (name.hashCode()) {
            case -1776922004:
                if (!name.equals("toString")) {
                    return null;
                }
                return "ReanimatedExtraWindowListener@" + Integer.toHexString(System.identityHashCode(obj));
            case -1295482945:
                if (!name.equals("equals")) {
                    return null;
                }
                Intrinsics.checkNotNull(objArr);
                return Boolean.valueOf(obj == objArr[0]);
            case 147696667:
                if (name.equals("hashCode")) {
                    return Integer.valueOf(System.identityHashCode(obj));
                }
                return null;
            case 1491629049:
                if (!name.equals("onExtraWindowDestroy")) {
                    return null;
                }
                TouchHoverCoordinator touchHoverCoordinator = extraWindowObserverBridge.hover;
                Intrinsics.checkNotNull(objArr);
                Object obj2 = objArr[0];
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.view.Window");
                touchHoverCoordinator.stopObservingExtraWindow((Window) obj2);
                return null;
            case 1970721053:
                if (!name.equals("onExtraWindowCreate")) {
                    return null;
                }
                TouchHoverCoordinator touchHoverCoordinator2 = extraWindowObserverBridge.hover;
                Intrinsics.checkNotNull(objArr);
                Object obj3 = objArr[0];
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type android.view.Window");
                touchHoverCoordinator2.observeExtraWindow((Window) obj3);
                return null;
            default:
                return null;
        }
    }

    public final void uninstall() {
        Object obj = this.listener;
        if (obj == null) {
            return;
        }
        this.listener = null;
        try {
            this.reactContext.getClass().getMethod("removeExtraWindowEventListener", Class.forName(LISTENER_CLASS)).invoke(this.reactContext, obj);
        } catch (Throwable th) {
            Log.w(TAG, "Failed to remove ExtraWindowEventListener", th);
        }
    }

    /* JADX INFO: compiled from: ExtraWindowObserverBridge.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/swmansion/reanimated/pseudoSelectors/ExtraWindowObserverBridge$Companion;", "", "<init>", "()V", "LISTENER_CLASS", "", "TAG", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

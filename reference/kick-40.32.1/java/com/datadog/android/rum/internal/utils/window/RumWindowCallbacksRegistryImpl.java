package com.datadog.android.rum.internal.utils.window;

import android.app.Activity;
import android.view.Window;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RumWindowCallbacksRegistry.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J\f\u0010\r\u001a\u00020\b*\u00020\u000eH\u0002J\f\u0010\u000f\u001a\u00020\u0006*\u00020\u000eH\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/datadog/android/rum/internal/utils/window/RumWindowCallbacksRegistryImpl;", "Lcom/datadog/android/rum/internal/utils/window/RumWindowCallbacksRegistry;", "()V", "callbacks", "Ljava/util/WeakHashMap;", "Landroid/app/Activity;", "Lcom/datadog/android/rum/internal/utils/window/RumWindowCallback;", "addListener", "", "activity", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/datadog/android/rum/internal/utils/window/RumWindowCallbackListener;", "removeListener", "tryToRemoveCallback", "Landroid/view/Window;", "wrapCallback", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RumWindowCallbacksRegistryImpl implements RumWindowCallbacksRegistry {
    private final WeakHashMap<Activity, RumWindowCallback> callbacks = new WeakHashMap<>();

    @Override // com.datadog.android.rum.internal.utils.window.RumWindowCallbacksRegistry
    public void addListener(Activity activity, RumWindowCallbackListener listener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(listener, "listener");
        WeakHashMap<Activity, RumWindowCallback> weakHashMap = this.callbacks;
        RumWindowCallback rumWindowCallbackWrapCallback = weakHashMap.get(activity);
        if (rumWindowCallbackWrapCallback == null) {
            Window window = activity.getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "activity.window");
            rumWindowCallbackWrapCallback = wrapCallback(window);
            weakHashMap.put(activity, rumWindowCallbackWrapCallback);
        }
        rumWindowCallbackWrapCallback.addListener(listener);
    }

    @Override // com.datadog.android.rum.internal.utils.window.RumWindowCallbacksRegistry
    public void removeListener(Activity activity, RumWindowCallbackListener listener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(listener, "listener");
        RumWindowCallback rumWindowCallback = this.callbacks.get(activity);
        if (rumWindowCallback != null) {
            rumWindowCallback.removeListener(listener);
            if (rumWindowCallback.getSubscription().getListenersCount() == 0) {
                Window window = activity.getWindow();
                Intrinsics.checkNotNullExpressionValue(window, "activity.window");
                tryToRemoveCallback(window);
                this.callbacks.remove(activity);
            }
        }
    }

    private final RumWindowCallback wrapCallback(Window window) {
        Window.Callback currentCallback = window.getCallback();
        Intrinsics.checkNotNullExpressionValue(currentCallback, "currentCallback");
        RumWindowCallback rumWindowCallback = new RumWindowCallback(currentCallback);
        window.setCallback(rumWindowCallback);
        return rumWindowCallback;
    }

    private final void tryToRemoveCallback(Window window) {
        Window.Callback callback = window.getCallback();
        if ((callback instanceof RumWindowCallback) && this.callbacks.values().contains(callback)) {
            window.setCallback(((RumWindowCallback) callback).getWrapped());
        }
    }
}

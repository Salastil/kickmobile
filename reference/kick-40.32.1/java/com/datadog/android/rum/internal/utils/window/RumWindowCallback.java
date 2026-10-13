package com.datadog.android.rum.internal.utils.window;

import android.view.Window;
import com.datadog.android.internal.utils.DDCoreSubscription;
import com.datadog.android.internal.utils.FixedWindowCallback;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RumWindowCallbacksRegistry.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007J\b\u0010\u000f\u001a\u00020\rH\u0016J\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/rum/internal/utils/window/RumWindowCallback;", "Lcom/datadog/android/internal/utils/FixedWindowCallback;", "wrapped", "Landroid/view/Window$Callback;", "(Landroid/view/Window$Callback;)V", FirebaseAnalytics.Param.SUBSCRIPTION, "Lcom/datadog/android/internal/utils/DDCoreSubscription;", "Lcom/datadog/android/rum/internal/utils/window/RumWindowCallbackListener;", "getSubscription", "()Lcom/datadog/android/internal/utils/DDCoreSubscription;", "getWrapped", "()Landroid/view/Window$Callback;", "addListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onContentChanged", "removeListener", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class RumWindowCallback extends FixedWindowCallback {
    private final DDCoreSubscription<RumWindowCallbackListener> subscription;
    private final Window.Callback wrapped;

    public final Window.Callback getWrapped() {
        return this.wrapped;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RumWindowCallback(Window.Callback wrapped) {
        super(wrapped);
        Intrinsics.checkNotNullParameter(wrapped, "wrapped");
        this.wrapped = wrapped;
        this.subscription = DDCoreSubscription.INSTANCE.create();
    }

    public final DDCoreSubscription<RumWindowCallbackListener> getSubscription() {
        return this.subscription;
    }

    public final void addListener(RumWindowCallbackListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.subscription.addListener(listener);
    }

    public final void removeListener(RumWindowCallbackListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.subscription.removeListener(listener);
    }

    @Override // com.datadog.android.internal.utils.FixedWindowCallback, android.view.Window.Callback
    public void onContentChanged() {
        super.onContentChanged();
        this.subscription.notifyListeners(new Function1<RumWindowCallbackListener, Unit>() { // from class: com.datadog.android.rum.internal.utils.window.RumWindowCallback.onContentChanged.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RumWindowCallbackListener rumWindowCallbackListener) {
                invoke2(rumWindowCallbackListener);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RumWindowCallbackListener notifyListeners) {
                Intrinsics.checkNotNullParameter(notifyListeners, "$this$notifyListeners");
                notifyListeners.onContentChanged();
            }
        });
    }
}

package com.datadog.android.rum.internal.instrumentation.gestures;

import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.SdkCore;
import com.datadog.android.internal.utils.FixedWindowCallback;
import com.datadog.android.rum.GlobalRumMonitor;
import com.datadog.android.rum.RumActionType;
import com.datadog.android.rum.RumAttributes;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.internal.tracking.NoOpInteractionPredicate;
import com.datadog.android.rum.tracking.InteractionPredicate;
import com.datadog.android.rum.tracking.ViewAttributesProvider;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: WindowCallbackWrapper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 82\u00020\u0001:\u00018B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u0012\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0012\u0010+\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010,\u001a\u00020-2\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010.\u001a\u00020-H\u0002J\u0014\u0010/\u001a\u00020-2\n\u00100\u001a\u000601j\u0002`2H\u0002J\u0018\u00103\u001a\u00020(2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0016R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u0010\u0012\f\u0012\n \"*\u0004\u0018\u00010\u00030\u00030!X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u00069"}, d2 = {"Lcom/datadog/android/rum/internal/instrumentation/gestures/WindowCallbackWrapper;", "Lcom/datadog/android/internal/utils/FixedWindowCallback;", "window", "Landroid/view/Window;", "sdkCore", "Lcom/datadog/android/api/SdkCore;", "wrappedCallback", "Landroid/view/Window$Callback;", "gesturesDetector", "Lcom/datadog/android/rum/internal/instrumentation/gestures/GesturesDetectorWrapper;", "interactionPredicate", "Lcom/datadog/android/rum/tracking/InteractionPredicate;", "copyEvent", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "targetAttributesProviders", "", "Lcom/datadog/android/rum/tracking/ViewAttributesProvider;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Landroid/view/Window;Lcom/datadog/android/api/SdkCore;Landroid/view/Window$Callback;Lcom/datadog/android/rum/internal/instrumentation/gestures/GesturesDetectorWrapper;Lcom/datadog/android/rum/tracking/InteractionPredicate;Lkotlin/jvm/functions/Function1;[Lcom/datadog/android/rum/tracking/ViewAttributesProvider;Lcom/datadog/android/api/InternalLogger;)V", "getCopyEvent", "()Lkotlin/jvm/functions/Function1;", "getInteractionPredicate", "()Lcom/datadog/android/rum/tracking/InteractionPredicate;", "getInternalLogger", "()Lcom/datadog/android/api/InternalLogger;", "getSdkCore", "()Lcom/datadog/android/api/SdkCore;", "getTargetAttributesProviders", "()[Lcom/datadog/android/rum/tracking/ViewAttributesProvider;", "[Lcom/datadog/android/rum/tracking/ViewAttributesProvider;", "windowReference", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getWindowReference$dd_sdk_android_rum_release", "()Ljava/lang/ref/WeakReference;", "getWrappedCallback", "()Landroid/view/Window$Callback;", "dispatchKeyEvent", "", "event", "Landroid/view/KeyEvent;", "dispatchTouchEvent", "handleBackEvent", "", "handleRemoteControlActionEvent", "logOrRethrowWrappedCallbackException", "e", "Ljava/lang/NullPointerException;", "Lkotlin/NullPointerException;", "onMenuItemSelected", "featureId", "", "item", "Landroid/view/MenuItem;", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WindowCallbackWrapper extends FixedWindowCallback {
    public static final String BACK_DEFAULT_TARGET_NAME = "back";
    public static final boolean EVENT_CONSUMED = true;
    private final Function1<MotionEvent, MotionEvent> copyEvent;
    private final GesturesDetectorWrapper gesturesDetector;
    private final InteractionPredicate interactionPredicate;
    private final InternalLogger internalLogger;
    private final SdkCore sdkCore;
    private final ViewAttributesProvider[] targetAttributesProviders;
    private final WeakReference<Window> windowReference;
    private final Window.Callback wrappedCallback;

    public final SdkCore getSdkCore() {
        return this.sdkCore;
    }

    public final Window.Callback getWrappedCallback() {
        return this.wrappedCallback;
    }

    public /* synthetic */ WindowCallbackWrapper(Window window, SdkCore sdkCore, Window.Callback callback, GesturesDetectorWrapper gesturesDetectorWrapper, NoOpInteractionPredicate noOpInteractionPredicate, Function1 function1, ViewAttributesProvider[] viewAttributesProviderArr, InternalLogger internalLogger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(window, sdkCore, callback, gesturesDetectorWrapper, (i & 16) != 0 ? new NoOpInteractionPredicate() : noOpInteractionPredicate, (i & 32) != 0 ? new Function1<MotionEvent, MotionEvent>() { // from class: com.datadog.android.rum.internal.instrumentation.gestures.WindowCallbackWrapper.1
            @Override // kotlin.jvm.functions.Function1
            public final MotionEvent invoke(MotionEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                MotionEvent motionEventObtain = MotionEvent.obtain(it);
                Intrinsics.checkNotNullExpressionValue(motionEventObtain, "obtain(it)");
                return motionEventObtain;
            }
        } : function1, (i & 64) != 0 ? new ViewAttributesProvider[0] : viewAttributesProviderArr, internalLogger);
    }

    public final InteractionPredicate getInteractionPredicate() {
        return this.interactionPredicate;
    }

    public final Function1<MotionEvent, MotionEvent> getCopyEvent() {
        return this.copyEvent;
    }

    public final ViewAttributesProvider[] getTargetAttributesProviders() {
        return this.targetAttributesProviders;
    }

    public final InternalLogger getInternalLogger() {
        return this.internalLogger;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WindowCallbackWrapper(Window window, SdkCore sdkCore, Window.Callback wrappedCallback, GesturesDetectorWrapper gesturesDetector, InteractionPredicate interactionPredicate, Function1<? super MotionEvent, MotionEvent> copyEvent, ViewAttributesProvider[] targetAttributesProviders, InternalLogger internalLogger) {
        super(wrappedCallback);
        Intrinsics.checkNotNullParameter(window, "window");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(wrappedCallback, "wrappedCallback");
        Intrinsics.checkNotNullParameter(gesturesDetector, "gesturesDetector");
        Intrinsics.checkNotNullParameter(interactionPredicate, "interactionPredicate");
        Intrinsics.checkNotNullParameter(copyEvent, "copyEvent");
        Intrinsics.checkNotNullParameter(targetAttributesProviders, "targetAttributesProviders");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.sdkCore = sdkCore;
        this.wrappedCallback = wrappedCallback;
        this.gesturesDetector = gesturesDetector;
        this.interactionPredicate = interactionPredicate;
        this.copyEvent = copyEvent;
        this.targetAttributesProviders = targetAttributesProviders;
        this.internalLogger = internalLogger;
        this.windowReference = new WeakReference<>(window);
    }

    public final WeakReference<Window> getWindowReference$dd_sdk_android_rum_release() {
        return this.windowReference;
    }

    @Override // com.datadog.android.internal.utils.FixedWindowCallback, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event != null) {
            MotionEvent motionEventInvoke = this.copyEvent.invoke(event);
            try {
                try {
                    this.gesturesDetector.onTouchEvent(motionEventInvoke);
                } catch (Exception e) {
                    InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.instrumentation.gestures.WindowCallbackWrapper.dispatchTouchEvent.1
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Error processing MotionEvent";
                        }
                    }, (Throwable) e, false, (Map) null, 48, (Object) null);
                }
                motionEventInvoke.recycle();
            } catch (Throwable th) {
                motionEventInvoke.recycle();
                throw th;
            }
        } else {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.instrumentation.gestures.WindowCallbackWrapper.dispatchTouchEvent.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Received null MotionEvent";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
        try {
            return this.wrappedCallback.dispatchTouchEvent(event);
        } catch (NullPointerException e2) {
            logOrRethrowWrappedCallbackException(e2);
            return true;
        }
    }

    @Override // com.datadog.android.internal.utils.FixedWindowCallback, android.view.Window.Callback
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        Window window = this.windowReference.get();
        GlobalRumMonitor.get(this.sdkCore).addAction(RumActionType.TAP, GesturesUtilsKt.resolveTargetName(this.interactionPredicate, item), MapsKt.mutableMapOf(TuplesKt.to(RumAttributes.ACTION_TARGET_CLASS_NAME, item.getClass().getCanonicalName()), TuplesKt.to(RumAttributes.ACTION_TARGET_RESOURCE_ID, GesturesUtilsKt.resourceIdName(window != null ? window.getContext() : null, item.getItemId())), TuplesKt.to(RumAttributes.ACTION_TARGET_TITLE, item.getTitle())));
        try {
            return this.wrappedCallback.onMenuItemSelected(featureId, item);
        } catch (NullPointerException e) {
            logOrRethrowWrappedCallbackException(e);
            return true;
        }
    }

    @Override // com.datadog.android.internal.utils.FixedWindowCallback, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event == null) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.instrumentation.gestures.WindowCallbackWrapper.dispatchKeyEvent.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Received null KeyEvent";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        } else if (event.getKeyCode() == 4 && event.getAction() == 1) {
            handleBackEvent(event);
        } else if (event.getKeyCode() == 23 && event.getAction() == 1) {
            handleRemoteControlActionEvent();
        }
        try {
            return this.wrappedCallback.dispatchKeyEvent(event);
        } catch (NullPointerException e) {
            logOrRethrowWrappedCallbackException(e);
            return true;
        }
    }

    private final void handleRemoteControlActionEvent() {
        View currentFocus;
        Window window = this.windowReference.get();
        if (window == null || (currentFocus = window.getCurrentFocus()) == null) {
            return;
        }
        Map<String, ? extends Object> mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(RumAttributes.ACTION_TARGET_CLASS_NAME, GesturesUtilsKt.targetClassName(currentFocus)), TuplesKt.to(RumAttributes.ACTION_TARGET_RESOURCE_ID, GesturesUtilsKt.resourceIdName(window.getContext(), currentFocus.getId())));
        for (ViewAttributesProvider viewAttributesProvider : this.targetAttributesProviders) {
            viewAttributesProvider.extractAttributes(currentFocus, mapMutableMapOf);
        }
        GlobalRumMonitor.get(this.sdkCore).addAction(RumActionType.CLICK, GesturesUtilsKt.resolveTargetName(this.interactionPredicate, currentFocus), mapMutableMapOf);
    }

    private final void handleBackEvent(KeyEvent event) {
        String targetName = this.interactionPredicate.getTargetName(event);
        String str = targetName;
        if (str == null || str.length() == 0) {
            targetName = BACK_DEFAULT_TARGET_NAME;
        }
        RumMonitor.DefaultImpls.addAction$default(GlobalRumMonitor.get(this.sdkCore), RumActionType.BACK, targetName, null, 4, null);
    }

    private final void logOrRethrowWrappedCallbackException(NullPointerException e) {
        String message = e.getMessage();
        if (message != null && StringsKt.contains$default((CharSequence) message, (CharSequence) "Parameter specified as non-null is null", false, 2, (Object) null)) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.instrumentation.gestures.WindowCallbackWrapper.logOrRethrowWrappedCallbackException.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Wrapped Window.Callback failed processing event";
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return;
        }
        throw e;
    }
}

package com.datadog.android.rum.internal.instrumentation.gestures;

import android.content.Context;
import android.view.Window;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.SdkCore;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.rum.tracking.ActionTrackingStrategy;
import com.datadog.android.rum.tracking.InteractionPredicate;
import com.datadog.android.rum.tracking.ViewAttributesProvider;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DatadogGesturesTracker.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J%\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0002\b\u001dJ\b\u0010\u001e\u001a\u00020\u001fH\u0016J\"\u0010 \u001a\u00020!2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001a\u0010\"\u001a\u00020!2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010#\u001a\u00020$H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006%"}, d2 = {"Lcom/datadog/android/rum/internal/instrumentation/gestures/DatadogGesturesTracker;", "Lcom/datadog/android/rum/internal/instrumentation/gestures/GesturesTracker;", "targetAttributesProviders", "", "Lcom/datadog/android/rum/tracking/ViewAttributesProvider;", "interactionPredicate", "Lcom/datadog/android/rum/tracking/InteractionPredicate;", "composeActionsTrackingStrategy", "Lcom/datadog/android/rum/tracking/ActionTrackingStrategy;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "([Lcom/datadog/android/rum/tracking/ViewAttributesProvider;Lcom/datadog/android/rum/tracking/InteractionPredicate;Lcom/datadog/android/rum/tracking/ActionTrackingStrategy;Lcom/datadog/android/api/InternalLogger;)V", "getInteractionPredicate$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/tracking/InteractionPredicate;", "getTargetAttributesProviders$dd_sdk_android_rum_release", "()[Lcom/datadog/android/rum/tracking/ViewAttributesProvider;", "[Lcom/datadog/android/rum/tracking/ViewAttributesProvider;", "equals", "", "other", "", "generateGestureDetector", "Lcom/datadog/android/rum/internal/instrumentation/gestures/GesturesDetectorWrapper;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "window", "Landroid/view/Window;", "sdkCore", "Lcom/datadog/android/api/SdkCore;", "generateGestureDetector$dd_sdk_android_rum_release", "hashCode", "", "startTracking", "", "stopTracking", "toString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DatadogGesturesTracker implements GesturesTracker {
    private final ActionTrackingStrategy composeActionsTrackingStrategy;
    private final InteractionPredicate interactionPredicate;
    private final InternalLogger internalLogger;
    private final ViewAttributesProvider[] targetAttributesProviders;

    public DatadogGesturesTracker(ViewAttributesProvider[] targetAttributesProviders, InteractionPredicate interactionPredicate, ActionTrackingStrategy composeActionsTrackingStrategy, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(targetAttributesProviders, "targetAttributesProviders");
        Intrinsics.checkNotNullParameter(interactionPredicate, "interactionPredicate");
        Intrinsics.checkNotNullParameter(composeActionsTrackingStrategy, "composeActionsTrackingStrategy");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.targetAttributesProviders = targetAttributesProviders;
        this.interactionPredicate = interactionPredicate;
        this.composeActionsTrackingStrategy = composeActionsTrackingStrategy;
        this.internalLogger = internalLogger;
    }

    /* JADX INFO: renamed from: getTargetAttributesProviders$dd_sdk_android_rum_release, reason: from getter */
    public final ViewAttributesProvider[] getTargetAttributesProviders() {
        return this.targetAttributesProviders;
    }

    /* JADX INFO: renamed from: getInteractionPredicate$dd_sdk_android_rum_release, reason: from getter */
    public final InteractionPredicate getInteractionPredicate() {
        return this.interactionPredicate;
    }

    @Override // com.datadog.android.rum.internal.instrumentation.gestures.GesturesTracker
    public void startTracking(Window window, Context context, SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        if (window == null) {
            return;
        }
        NoOpWindowCallback callback = window.getCallback();
        if (callback == null) {
            callback = new NoOpWindowCallback();
        }
        window.setCallback(new WindowCallbackWrapper(window, sdkCore, callback, generateGestureDetector$dd_sdk_android_rum_release(context, window, sdkCore), this.interactionPredicate, null, this.targetAttributesProviders, this.internalLogger, 32, null));
    }

    @Override // com.datadog.android.rum.internal.instrumentation.gestures.GesturesTracker
    public void stopTracking(Window window, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (window == null) {
            return;
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof WindowCallbackWrapper) {
            WindowCallbackWrapper windowCallbackWrapper = (WindowCallbackWrapper) callback;
            if (!(windowCallbackWrapper.getWrappedCallback() instanceof NoOpWindowCallback)) {
                window.setCallback(windowCallbackWrapper.getWrappedCallback());
            } else {
                window.setCallback(null);
            }
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.datadog.android.rum.internal.instrumentation.gestures.DatadogGesturesTracker");
        DatadogGesturesTracker datadogGesturesTracker = (DatadogGesturesTracker) other;
        return Arrays.equals(this.targetAttributesProviders, datadogGesturesTracker.targetAttributesProviders) && Intrinsics.areEqual(this.interactionPredicate.getClass(), datadogGesturesTracker.interactionPredicate.getClass());
    }

    public int hashCode() {
        int iHashCode = Arrays.hashCode(this.targetAttributesProviders) + 544;
        return iHashCode + (iHashCode * 31) + this.interactionPredicate.getClass().hashCode();
    }

    public String toString() {
        return "DatadogGesturesTracker(" + ArraysKt.joinToString$default(this.targetAttributesProviders, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null) + ")";
    }

    public final GesturesDetectorWrapper generateGestureDetector$dd_sdk_android_rum_release(Context context, Window window, SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(window, "window");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        WeakReference weakReference = new WeakReference(window);
        ViewAttributesProvider[] viewAttributesProviderArr = this.targetAttributesProviders;
        InteractionPredicate interactionPredicate = this.interactionPredicate;
        WeakReference weakReference2 = new WeakReference(context);
        return new GesturesDetectorWrapper(context, new GesturesListener((FeatureSdkCore) sdkCore, weakReference, viewAttributesProviderArr, interactionPredicate, weakReference2, this.internalLogger, this.composeActionsTrackingStrategy, null, 128, null));
    }
}

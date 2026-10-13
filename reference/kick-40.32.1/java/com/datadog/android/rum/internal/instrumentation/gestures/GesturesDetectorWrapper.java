package com.datadog.android.rum.internal.instrumentation.gestures;

import android.content.Context;
import android.view.MotionEvent;
import androidx.core.view.GestureDetectorCompat;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GesturesDetectorWrapper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/datadog/android/rum/internal/instrumentation/gestures/GesturesDetectorWrapper;", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "gestureListener", "Lcom/datadog/android/rum/internal/instrumentation/gestures/GesturesListener;", "(Landroid/content/Context;Lcom/datadog/android/rum/internal/instrumentation/gestures/GesturesListener;)V", "defaultGesturesDetector", "Landroidx/core/view/GestureDetectorCompat;", "(Lcom/datadog/android/rum/internal/instrumentation/gestures/GesturesListener;Landroidx/core/view/GestureDetectorCompat;)V", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GesturesDetectorWrapper {
    private final GestureDetectorCompat defaultGesturesDetector;
    private final GesturesListener gestureListener;

    public GesturesDetectorWrapper(GesturesListener gestureListener, GestureDetectorCompat defaultGesturesDetector) {
        Intrinsics.checkNotNullParameter(gestureListener, "gestureListener");
        Intrinsics.checkNotNullParameter(defaultGesturesDetector, "defaultGesturesDetector");
        this.gestureListener = gestureListener;
        this.defaultGesturesDetector = defaultGesturesDetector;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GesturesDetectorWrapper(Context context, GesturesListener gestureListener) {
        this(gestureListener, new GestureDetectorCompat(context, gestureListener));
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gestureListener, "gestureListener");
    }

    public final void onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!this.defaultGesturesDetector.onTouchEvent(event) && event.getActionMasked() == 1) {
            this.gestureListener.onUp(event);
        }
    }
}

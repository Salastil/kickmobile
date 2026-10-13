package com.datadog.android.rum.internal.instrumentation.gestures;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.core.view.ScrollingView;
import com.datadog.android.api.SdkCore;
import com.datadog.android.internal.utils.TapTargetUtilsKt;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.rum.tracking.ActionTrackingStrategy;
import com.datadog.android.rum.tracking.ViewTarget;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidActionTrackingStrategy.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\"\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/datadog/android/rum/internal/instrumentation/gestures/AndroidActionTrackingStrategy;", "Lcom/datadog/android/rum/tracking/ActionTrackingStrategy;", "()V", "visibleRect", "Landroid/graphics/Rect;", "findTargetForScroll", "Lcom/datadog/android/rum/tracking/ViewTarget;", "view", "Landroid/view/View;", ViewDeviceOrientationData.DEVICE_ORIENTATION_X, "", ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, "findTargetForTap", "hitTest", "", "outRect", "isScrollableView", "isValidScrollableTarget", "register", "", "sdkCore", "Lcom/datadog/android/api/SdkCore;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "unregister", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidActionTrackingStrategy implements ActionTrackingStrategy {
    private final Rect visibleRect = new Rect();

    @Override // com.datadog.android.rum.tracking.TrackingStrategy
    public void register(SdkCore sdkCore, Context context) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.datadog.android.rum.tracking.TrackingStrategy
    public void unregister(Context context) {
    }

    @Override // com.datadog.android.rum.tracking.ActionTrackingStrategy
    public ViewTarget findTargetForTap(View view, float x, float y) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (hitTest(view, x, y, this.visibleRect) && TapTargetUtilsKt.isValidTapTarget(view)) {
            return new ViewTarget(new WeakReference(view), null, 2, null);
        }
        return null;
    }

    @Override // com.datadog.android.rum.tracking.ActionTrackingStrategy
    public ViewTarget findTargetForScroll(View view, float x, float y) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (hitTest(view, x, y, this.visibleRect) && isValidScrollableTarget(view)) {
            return new ViewTarget(new WeakReference(view), null, 2, null);
        }
        return null;
    }

    private final boolean hitTest(View view, float x, float y, Rect outRect) {
        return view.getGlobalVisibleRect(outRect) && x >= ((float) outRect.left) && x <= ((float) outRect.right) && y >= ((float) outRect.top) && y <= ((float) outRect.bottom);
    }

    private final boolean isValidScrollableTarget(View view) {
        return view.getVisibility() == 0 && isScrollableView(view);
    }

    private final boolean isScrollableView(View view) {
        return ScrollingView.class.isAssignableFrom(view.getClass()) || AbsListView.class.isAssignableFrom(view.getClass()) || ScrollView.class.isAssignableFrom(view.getClass());
    }
}

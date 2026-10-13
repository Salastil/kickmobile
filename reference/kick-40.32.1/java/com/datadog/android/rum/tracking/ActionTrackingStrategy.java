package com.datadog.android.rum.tracking;

import android.view.View;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import kotlin.Metadata;

/* JADX INFO: compiled from: ActionTrackingStrategy.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\"\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/tracking/ActionTrackingStrategy;", "Lcom/datadog/android/rum/tracking/TrackingStrategy;", "findTargetForScroll", "Lcom/datadog/android/rum/tracking/ViewTarget;", "view", "Landroid/view/View;", ViewDeviceOrientationData.DEVICE_ORIENTATION_X, "", ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, "findTargetForTap", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ActionTrackingStrategy extends TrackingStrategy {
    ViewTarget findTargetForScroll(View view, float x, float y);

    ViewTarget findTargetForTap(View view, float x, float y);
}

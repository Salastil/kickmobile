package com.datadog.android.heatmaps;

import android.view.View;
import android.view.ViewParent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HeatmapViewKey.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"HEATMAP_VIEW_KEY_COEFFICIENT", "", "heatmapViewKey", "view", "Landroid/view/View;", "dd-sdk-android-internal_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class HeatmapViewKeyKt {
    public static final long HEATMAP_VIEW_KEY_COEFFICIENT = 31;

    public static final long heatmapViewKey(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewParent parent = view.getParent();
        return (((long) System.identityHashCode(view)) * 31) + ((long) (parent != null ? System.identityHashCode(parent) : 0));
    }
}

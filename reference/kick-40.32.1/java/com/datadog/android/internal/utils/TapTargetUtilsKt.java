package com.datadog.android.internal.utils;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TapTargetUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"isValidTapTarget", "", "Landroid/view/View;", "dd-sdk-android-internal_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TapTargetUtilsKt {
    public static final boolean isValidTapTarget(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return view.isClickable() && view.getVisibility() == 0;
    }
}

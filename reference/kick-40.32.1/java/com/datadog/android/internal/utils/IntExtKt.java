package com.datadog.android.internal.utils;

import kotlin.Metadata;

/* JADX INFO: compiled from: IntExt.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"densityNormalized", "", "density", "", "dd-sdk-android-internal_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class IntExtKt {
    public static final int densityNormalized(int i, float f) {
        return f == 0.0f ? i : (int) (i / f);
    }
}

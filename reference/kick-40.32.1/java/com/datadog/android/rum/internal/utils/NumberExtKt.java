package com.datadog.android.rum.internal.utils;

import kotlin.Metadata;

/* JADX INFO: compiled from: NumberExt.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0003H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0004"}, d2 = {"HUNDRED", "", "percent", "", "dd-sdk-android-rum_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class NumberExtKt {
    public static final double HUNDRED = 100.0d;

    public static final double percent(float f) {
        return ((double) f) / 100.0d;
    }
}

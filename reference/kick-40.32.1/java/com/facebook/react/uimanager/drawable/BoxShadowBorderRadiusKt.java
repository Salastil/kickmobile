package com.facebook.react.uimanager.drawable;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: BoxShadowBorderRadius.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¨\u0006\u0004"}, d2 = {"adjustRadiusForSpread", "", "radius", "spread", "ReactAndroid"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxShadowBorderRadiusKt {
    public static final float adjustRadiusForSpread(float f, float f2) {
        return RangesKt.coerceAtLeast(f + (f2 * (f < Math.abs(f2) ? 1.0f + ((float) Math.pow((f / Math.abs(f2)) - 1.0f, 3.0d)) : 1.0f)), 0.0f);
    }
}

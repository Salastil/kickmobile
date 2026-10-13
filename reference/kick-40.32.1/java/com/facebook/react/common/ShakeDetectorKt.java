package com.facebook.react.common;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* JADX INFO: compiled from: ShakeDetector.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"MIN_TIME_BETWEEN_SAMPLES_NS", "", "SHAKING_WINDOW_NS", "", "REQUIRED_FORCE", "ReactAndroid"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ShakeDetectorKt {
    private static final long MIN_TIME_BETWEEN_SAMPLES_NS;
    private static final float REQUIRED_FORCE = 13.042845f;
    private static final float SHAKING_WINDOW_NS;

    static {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
        MIN_TIME_BETWEEN_SAMPLES_NS = 20000000L;
        TimeUnit timeUnit3 = TimeUnit.NANOSECONDS;
        TimeUnit timeUnit4 = TimeUnit.SECONDS;
        SHAKING_WINDOW_NS = 3.0E9f;
    }
}

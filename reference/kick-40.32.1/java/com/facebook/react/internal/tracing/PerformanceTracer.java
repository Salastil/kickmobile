package com.facebook.react.internal.tracing;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.soloader.SoLoader;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PerformanceTracer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001&B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\t¢\u0006\u0002\u0010\nJ/\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\t¢\u0006\u0002\u0010\fJ7\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\t¢\u0006\u0002\u0010\u000eJE\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\t¢\u0006\u0002\u0010\u0010J#\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0087 J+\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0087 J?\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0087 J\t\u0010\u001e\u001a\u00020\u001fH\u0087 J\u0011\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0087 J\u0011\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020!H\u0087 ¨\u0006'"}, d2 = {"Lcom/facebook/react/internal/tracing/PerformanceTracer;", "", "<init>", "()V", "trace", ExifInterface.GPS_DIRECTION_TRUE, "name", "", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "track", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "trackGroup", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "color", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "reportMark", "", "timestampNanos", "", "detail", "Lcom/facebook/react/bridge/ReadableNativeMap;", "reportMeasure", "startTimestampNanos", "durationNanos", "reportTimeStamp", "startTimeNanos", "endTimeNanos", "trackName", "isTracing", "", "subscribeToTracingStateChanges", "", "callback", "Lcom/facebook/react/internal/tracing/PerformanceTracer$TracingStateCallback;", "unsubscribeFromTracingStateChanges", "subscriptionId", "TracingStateCallback", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PerformanceTracer {
    public static final PerformanceTracer INSTANCE = new PerformanceTracer();

    /* JADX INFO: compiled from: PerformanceTracer.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lcom/facebook/react/internal/tracing/PerformanceTracer$TracingStateCallback;", "", "onTracingStateChanged", "", "isTracing", "", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface TracingStateCallback {
        void onTracingStateChanged(boolean isTracing);
    }

    @JvmStatic
    public static final native boolean isTracing();

    @JvmStatic
    public static final native void reportMark(String name, long timestampNanos, ReadableNativeMap detail);

    @JvmStatic
    public static final native void reportMeasure(String name, long startTimestampNanos, long durationNanos, ReadableNativeMap detail);

    @JvmStatic
    public static final native void reportTimeStamp(String name, long startTimeNanos, long endTimeNanos, String trackName, String trackGroup, String color);

    @JvmStatic
    public static final native int subscribeToTracingStateChanges(TracingStateCallback callback);

    @JvmStatic
    public static final native void unsubscribeFromTracingStateChanges(int subscriptionId);

    private PerformanceTracer() {
    }

    static {
        SoLoader.loadLibrary("react_tracingjni");
    }

    public final <T> T trace(String name, Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(block, "block");
        return (T) trace(name, null, null, null, block);
    }

    public final <T> T trace(String name, String track, Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(track, "track");
        Intrinsics.checkNotNullParameter(block, "block");
        return (T) trace(name, track, null, null, block);
    }

    public final <T> T trace(String name, String track, String trackGroup, Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(track, "track");
        Intrinsics.checkNotNullParameter(trackGroup, "trackGroup");
        Intrinsics.checkNotNullParameter(block, "block");
        return (T) trace(name, track, trackGroup, null, block);
    }

    public final <T> T trace(String name, String track, String trackGroup, String color, Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(block, "block");
        if (!isTracing()) {
            return block.invoke();
        }
        long jNanoTime = System.nanoTime();
        try {
            return block.invoke();
        } finally {
            reportTimeStamp(name, jNanoTime, System.nanoTime(), track, trackGroup, color);
        }
    }
}

package com.datadog.android.core.internal.time;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.internal.time.BaseTimeProvider;
import com.lyft.kronos.Clock;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KronosTimeProvider.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f*\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0010"}, d2 = {"Lcom/datadog/android/core/internal/time/KronosTimeProvider;", "Lcom/datadog/android/internal/time/BaseTimeProvider;", "clock", "Lcom/lyft/kronos/Clock;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Lcom/lyft/kronos/Clock;Lcom/datadog/android/api/InternalLogger;)V", "getServerOffsetMillis", "", "getServerOffsetNanos", "getServerTimestampMillis", "safeGetCurrentTimeMs", "Lkotlin/Result;", "safeGetCurrentTimeMs-IoAF18A", "(Lcom/lyft/kronos/Clock;)Ljava/lang/Object;", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class KronosTimeProvider extends BaseTimeProvider {
    public static final String FAIL_MESSAGE = "KronosClock.getCurrentTimeMs failed with an exception";
    private final Clock clock;
    private final InternalLogger internalLogger;

    public KronosTimeProvider(Clock clock, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(clock, "clock");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.clock = clock;
        this.internalLogger = internalLogger;
    }

    @Override // com.datadog.android.internal.time.TimeProvider
    public long getServerTimestampMillis() {
        Object objM11149safeGetCurrentTimeMsIoAF18A = m11149safeGetCurrentTimeMsIoAF18A(this.clock);
        if (Result.m12687exceptionOrNullimpl(objM11149safeGetCurrentTimeMsIoAF18A) != null) {
            objM11149safeGetCurrentTimeMsIoAF18A = Long.valueOf(getDeviceTimestampMillis());
        }
        return ((Number) objM11149safeGetCurrentTimeMsIoAF18A).longValue();
    }

    @Override // com.datadog.android.internal.time.TimeProvider
    public long getServerOffsetMillis() {
        Object objM12684constructorimpl;
        Object objM11149safeGetCurrentTimeMsIoAF18A = m11149safeGetCurrentTimeMsIoAF18A(this.clock);
        if (Result.m12691isSuccessimpl(objM11149safeGetCurrentTimeMsIoAF18A)) {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(Long.valueOf(((Number) objM11149safeGetCurrentTimeMsIoAF18A).longValue() - getDeviceTimestampMillis()));
        } else {
            objM12684constructorimpl = Result.m12684constructorimpl(objM11149safeGetCurrentTimeMsIoAF18A);
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = 0L;
        }
        return ((Number) objM12684constructorimpl).longValue();
    }

    @Override // com.datadog.android.internal.time.TimeProvider
    public long getServerOffsetNanos() {
        return TimeUnit.MILLISECONDS.toNanos(getServerOffsetMillis());
    }

    /* JADX INFO: renamed from: safeGetCurrentTimeMs-IoAF18A, reason: not valid java name */
    private final Object m11149safeGetCurrentTimeMsIoAF18A(Clock clock) {
        Object objM12684constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(Long.valueOf(clock.getCurrentTimeMs()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM12687exceptionOrNullimpl = Result.m12687exceptionOrNullimpl(objM12684constructorimpl);
        if (thM12687exceptionOrNullimpl != null) {
            this.internalLogger.log(InternalLogger.Level.WARN, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0<String>) new Function0<String>() { // from class: com.datadog.android.core.internal.time.KronosTimeProvider$safeGetCurrentTimeMs$2$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return KronosTimeProvider.FAIL_MESSAGE;
                }
            }, thM12687exceptionOrNullimpl, true, MapsKt.emptyMap());
        }
        return objM12684constructorimpl;
    }
}

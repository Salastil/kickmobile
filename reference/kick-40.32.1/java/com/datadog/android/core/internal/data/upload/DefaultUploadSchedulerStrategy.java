package com.datadog.android.core.internal.data.upload;

import com.datadog.android.core.configuration.UploadSchedulerStrategy;
import com.datadog.android.core.internal.configuration.DataUploadConfiguration;
import com.datadog.android.rum.internal.RumFeature;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.time.DurationKt;

/* JADX INFO: compiled from: DefaultUploadSchedulerStrategy.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J1\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u0012J\u001a\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/datadog/android/core/internal/data/upload/DefaultUploadSchedulerStrategy;", "Lcom/datadog/android/core/configuration/UploadSchedulerStrategy;", "uploadConfiguration", "Lcom/datadog/android/core/internal/configuration/DataUploadConfiguration;", "(Lcom/datadog/android/core/internal/configuration/DataUploadConfiguration;)V", "currentDelays", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "getUploadConfiguration$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/configuration/DataUploadConfiguration;", "getMsDelayUntilNextUpload", "featureName", "uploadAttempts", "", "lastStatusCode", RumFeature.EVENT_THROWABLE_PROPERTY, "", "(Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Throwable;)J", "increaseInterval", "previousDelay", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultUploadSchedulerStrategy implements UploadSchedulerStrategy {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final double INCREASE_PERCENT = 1.1d;
    private static final long NETWORK_ERROR_DELAY_MS;
    private final ConcurrentHashMap<String, Long> currentDelays;
    private final DataUploadConfiguration uploadConfiguration;

    public DefaultUploadSchedulerStrategy(DataUploadConfiguration uploadConfiguration) {
        Intrinsics.checkNotNullParameter(uploadConfiguration, "uploadConfiguration");
        this.uploadConfiguration = uploadConfiguration;
        this.currentDelays = new ConcurrentHashMap<>();
    }

    /* JADX INFO: renamed from: getUploadConfiguration$dd_sdk_android_core_release, reason: from getter */
    public final DataUploadConfiguration getUploadConfiguration() {
        return this.uploadConfiguration;
    }

    @Override // com.datadog.android.core.configuration.UploadSchedulerStrategy
    public long getMsDelayUntilNextUpload(String featureName, int uploadAttempts, Integer lastStatusCode, Throwable throwable) {
        long jIncreaseInterval;
        Long lPutIfAbsent;
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        ConcurrentHashMap<String, Long> concurrentHashMap = this.currentDelays;
        Long lValueOf = concurrentHashMap.get(featureName);
        if (lValueOf == null && (lPutIfAbsent = concurrentHashMap.putIfAbsent(featureName, (lValueOf = Long.valueOf(this.uploadConfiguration.getDefaultDelayMs())))) != null) {
            lValueOf = lPutIfAbsent;
        }
        Long previousDelay = lValueOf;
        if (uploadAttempts > 0 && throwable == null && lastStatusCode != null && lastStatusCode.intValue() == 202) {
            jIncreaseInterval = this.uploadConfiguration.getMinDelayMs();
        } else {
            Intrinsics.checkNotNullExpressionValue(previousDelay, "previousDelay");
            jIncreaseInterval = increaseInterval(previousDelay.longValue(), throwable);
        }
        this.currentDelays.put(featureName, Long.valueOf(jIncreaseInterval));
        return jIncreaseInterval;
    }

    private final long increaseInterval(long previousDelay, Throwable throwable) {
        long jRoundToLong = MathKt.roundToLong(previousDelay * 1.1d);
        if (throwable instanceof IOException) {
            return NETWORK_ERROR_DELAY_MS;
        }
        return Math.min(this.uploadConfiguration.getMaxDelayMs(), jRoundToLong);
    }

    /* JADX INFO: compiled from: DefaultUploadSchedulerStrategy.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/datadog/android/core/internal/data/upload/DefaultUploadSchedulerStrategy$Companion;", "", "()V", "INCREASE_PERCENT", "", "NETWORK_ERROR_DELAY_MS", "", "getNETWORK_ERROR_DELAY_MS$dd_sdk_android_core_release", "()J", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long getNETWORK_ERROR_DELAY_MS$dd_sdk_android_core_release() {
            return DefaultUploadSchedulerStrategy.NETWORK_ERROR_DELAY_MS;
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        NETWORK_ERROR_DELAY_MS = DurationKt.MILLIS_IN_MINUTE;
    }
}

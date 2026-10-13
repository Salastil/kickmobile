package com.datadog.reactnative;

import com.datadog.trace.api.config.GeneralConfig;
import kotlin.Metadata;

/* JADX INFO: compiled from: DdSdkConfigurationExt.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/datadog/reactnative/DefaultConfiguration;", "", "<init>", "()V", "nativeCrashReportEnabled", "", "sessionSamplingRate", "", GeneralConfig.SITE, "", "longTaskThresholdMs", "nativeLongTaskThresholdMs", "nativeViewTracking", "nativeInteractionTracking", "trackingConsent", "telemetrySampleRate", "vitalsUpdateFrequency", "trackFrustrations", "uploadFrequency", "batchSize", "trackBackgroundEvents", "bundleLogsWithRum", "bundleLogsWithTraces", "initialResourceThreshold", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DefaultConfiguration {
    public static final DefaultConfiguration INSTANCE = new DefaultConfiguration();
    public static final String batchSize = "MEDIUM";
    public static final boolean bundleLogsWithRum = true;
    public static final boolean bundleLogsWithTraces = true;
    public static final double initialResourceThreshold = 0.1d;
    public static final double longTaskThresholdMs = 0.0d;
    public static final boolean nativeCrashReportEnabled = false;
    public static final boolean nativeInteractionTracking = false;
    public static final double nativeLongTaskThresholdMs = 200.0d;
    public static final boolean nativeViewTracking = false;
    public static final double sessionSamplingRate = 100.0d;
    public static final String site = "US1";
    public static final double telemetrySampleRate = 20.0d;
    public static final boolean trackBackgroundEvents = false;
    public static final boolean trackFrustrations = true;
    public static final String trackingConsent = "GRANTED";
    public static final String uploadFrequency = "AVERAGE";
    public static final String vitalsUpdateFrequency = "AVERAGE";

    private DefaultConfiguration() {
    }
}

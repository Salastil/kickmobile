package com.datadog.android.rum.internal.timeseries;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.rum.RumSessionType;
import com.datadog.android.rum.internal.domain.InfoProvider;
import com.datadog.android.rum.internal.domain.RumContext;
import com.datadog.android.rum.internal.domain.battery.BatteryInfo;
import com.datadog.android.rum.internal.domain.display.DisplayInfo;
import com.datadog.android.rum.internal.instrumentation.insights.InsightsCollector;
import com.datadog.android.rum.internal.timeseries.factory.CpuEventFactory;
import com.datadog.android.rum.internal.timeseries.factory.MemoryEventFactory;
import com.datadog.android.rum.internal.timeseries.provider.CpuDatapointReader;
import com.datadog.android.rum.internal.timeseries.provider.VitalReaderWrapper;
import com.datadog.android.rum.internal.vitals.CpuStatReader;
import com.datadog.android.rum.internal.vitals.MemoryVitalReader;
import com.datadog.android.rum.timeseries.TimeseriesConfiguration;
import com.datadog.android.rum.timeseries.TimeseriesType;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultTimeseriesCollectorFactory.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fBW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/datadog/android/rum/internal/timeseries/DefaultTimeseriesCollectorFactory;", "Lcom/datadog/android/rum/internal/timeseries/TimeseriesCollector$Factory;", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "configuration", "Lcom/datadog/android/rum/timeseries/TimeseriesConfiguration;", "scheduledExecutorService", "Ljava/util/concurrent/ScheduledExecutorService;", "insightsCollector", "Lcom/datadog/android/rum/internal/instrumentation/insights/InsightsCollector;", "totalRamBytes", "", "dataWriter", "Lcom/datadog/android/api/storage/DataWriter;", "", "batteryInfoProvider", "Lcom/datadog/android/rum/internal/domain/InfoProvider;", "Lcom/datadog/android/rum/internal/domain/battery/BatteryInfo;", "displayInfoProvider", "Lcom/datadog/android/rum/internal/domain/display/DisplayInfo;", "(Lcom/datadog/android/api/feature/FeatureSdkCore;Lcom/datadog/android/rum/timeseries/TimeseriesConfiguration;Ljava/util/concurrent/ScheduledExecutorService;Lcom/datadog/android/rum/internal/instrumentation/insights/InsightsCollector;JLcom/datadog/android/api/storage/DataWriter;Lcom/datadog/android/rum/internal/domain/InfoProvider;Lcom/datadog/android/rum/internal/domain/InfoProvider;)V", "create", "Lcom/datadog/android/rum/internal/timeseries/TimeseriesCollector;", "sessionType", "Lcom/datadog/android/rum/RumSessionType;", "rumContext", "Lcom/datadog/android/rum/internal/domain/RumContext;", "createCpuPipeline", "Lcom/datadog/android/rum/internal/timeseries/Pipeline;", "", "createMemoryPipeline", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultTimeseriesCollectorFactory implements TimeseriesCollector.Factory {
    public static final String MEMORY_TIMESERIES_DISABLED_MESSAGE = "Unable to read total device memory; memory timeseries collection is disabled.";
    private final InfoProvider<BatteryInfo> batteryInfoProvider;
    private final TimeseriesConfiguration configuration;
    private final DataWriter<Object> dataWriter;
    private final InfoProvider<DisplayInfo> displayInfoProvider;
    private final InsightsCollector insightsCollector;
    private final ScheduledExecutorService scheduledExecutorService;
    private final FeatureSdkCore sdkCore;
    private final long totalRamBytes;

    public DefaultTimeseriesCollectorFactory(FeatureSdkCore sdkCore, TimeseriesConfiguration configuration, ScheduledExecutorService scheduledExecutorService, InsightsCollector insightsCollector, long j, DataWriter<Object> dataWriter, InfoProvider<BatteryInfo> batteryInfoProvider, InfoProvider<DisplayInfo> displayInfoProvider) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(scheduledExecutorService, "scheduledExecutorService");
        Intrinsics.checkNotNullParameter(insightsCollector, "insightsCollector");
        Intrinsics.checkNotNullParameter(dataWriter, "dataWriter");
        Intrinsics.checkNotNullParameter(batteryInfoProvider, "batteryInfoProvider");
        Intrinsics.checkNotNullParameter(displayInfoProvider, "displayInfoProvider");
        this.sdkCore = sdkCore;
        this.configuration = configuration;
        this.scheduledExecutorService = scheduledExecutorService;
        this.insightsCollector = insightsCollector;
        this.totalRamBytes = j;
        this.dataWriter = dataWriter;
        this.batteryInfoProvider = batteryInfoProvider;
        this.displayInfoProvider = displayInfoProvider;
    }

    @Override // com.datadog.android.rum.internal.timeseries.TimeseriesCollector.Factory
    public TimeseriesCollector create(RumSessionType sessionType, RumContext rumContext) {
        Intrinsics.checkNotNullParameter(sessionType, "sessionType");
        Intrinsics.checkNotNullParameter(rumContext, "rumContext");
        ArrayList arrayList = new ArrayList();
        if (this.configuration.getEnabledTypes$dd_sdk_android_rum_release().contains(TimeseriesType.CPU)) {
            arrayList.add(createCpuPipeline(sessionType));
        }
        if (this.configuration.getEnabledTypes$dd_sdk_android_rum_release().contains(TimeseriesType.MEMORY)) {
            if (this.totalRamBytes > 0) {
                arrayList.add(createMemoryPipeline(sessionType));
            } else {
                InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.timeseries.DefaultTimeseriesCollectorFactory.create.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return DefaultTimeseriesCollectorFactory.MEMORY_TIMESERIES_DISABLED_MESSAGE;
                    }
                }, (Throwable) null, true, (Map) null, 40, (Object) null);
            }
        }
        return new DefaultTimeseriesCollector(this.sdkCore.getInternalLogger(), arrayList, this.scheduledExecutorService, rumContext);
    }

    private final Pipeline<Double> createMemoryPipeline(RumSessionType sessionType) {
        return new Pipeline<>(this.sdkCore, new VitalReaderWrapper(new MemoryVitalReader(null, this.sdkCore.getInternalLogger(), 1, null), this.sdkCore.getTimeProvider(), 1000L), new Buffer(TimeseriesConfiguration.DEFAULT_BUFFER_SIZE), new MemoryEventFactory(sessionType, this.totalRamBytes, this.sdkCore.getTimeProvider(), this.batteryInfoProvider, this.displayInfoProvider, this.sdkCore.getInternalLogger(), null, 64, null), this.dataWriter, this.insightsCollector);
    }

    private final Pipeline<Double> createCpuPipeline(RumSessionType sessionType) {
        return new Pipeline<>(this.sdkCore, new CpuDatapointReader(new CpuStatReader(null, this.sdkCore.getInternalLogger(), 1, null), this.sdkCore.getTimeProvider(), 1000L, 0, 8, null), new Buffer(TimeseriesConfiguration.DEFAULT_BUFFER_SIZE), new CpuEventFactory(sessionType, this.sdkCore.getTimeProvider(), this.batteryInfoProvider, this.displayInfoProvider, this.sdkCore.getInternalLogger(), null, 32, null), this.dataWriter, this.insightsCollector);
    }
}

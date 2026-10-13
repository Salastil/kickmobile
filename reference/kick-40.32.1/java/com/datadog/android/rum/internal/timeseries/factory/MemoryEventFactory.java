package com.datadog.android.rum.internal.timeseries.factory;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.context.DeviceInfo;
import com.datadog.android.core.internal.utils.DdTagsUtils;
import com.datadog.android.internal.time.TimeProvider;
import com.datadog.android.rum.RumSessionType;
import com.datadog.android.rum.internal.FeaturesContextResolver;
import com.datadog.android.rum.internal.RumSessionTypeExtKt;
import com.datadog.android.rum.internal.domain.InfoProvider;
import com.datadog.android.rum.internal.domain.RumContext;
import com.datadog.android.rum.internal.domain.battery.BatteryInfo;
import com.datadog.android.rum.internal.domain.display.DisplayInfo;
import com.datadog.android.rum.internal.domain.scope.RumEventExtKt;
import com.datadog.android.rum.internal.timeseries.DataPoint;
import com.datadog.android.rum.model.TimeseriesMemoryEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MemoryEventFactory.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001 BK\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J.\u0010\u0018\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u001f0\u001eH\u0016R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u0015X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/datadog/android/rum/internal/timeseries/factory/MemoryEventFactory;", "Lcom/datadog/android/rum/internal/timeseries/factory/EventFactory;", "", "Lcom/datadog/android/rum/model/TimeseriesMemoryEvent;", "sessionType", "Lcom/datadog/android/rum/RumSessionType;", "totalRamBytes", "", "timeProvider", "Lcom/datadog/android/internal/time/TimeProvider;", "batteryInfoProvider", "Lcom/datadog/android/rum/internal/domain/InfoProvider;", "Lcom/datadog/android/rum/internal/domain/battery/BatteryInfo;", "displayInfoProvider", "Lcom/datadog/android/rum/internal/domain/display/DisplayInfo;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "featuresContextResolver", "Lcom/datadog/android/rum/internal/FeaturesContextResolver;", "(Lcom/datadog/android/rum/RumSessionType;JLcom/datadog/android/internal/time/TimeProvider;Lcom/datadog/android/rum/internal/domain/InfoProvider;Lcom/datadog/android/rum/internal/domain/InfoProvider;Lcom/datadog/android/api/InternalLogger;Lcom/datadog/android/rum/internal/FeaturesContextResolver;)V", "eventName", "", "getEventName", "()Ljava/lang/String;", "create", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "rumContext", "Lcom/datadog/android/rum/internal/domain/RumContext;", "dataPoints", "", "Lcom/datadog/android/rum/internal/timeseries/DataPoint;", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MemoryEventFactory implements EventFactory<Double, TimeseriesMemoryEvent> {

    @Deprecated
    public static final int BYTES_IN_KB = 1000;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final double PERCENT_FACTOR = 100.0d;
    private final InfoProvider<BatteryInfo> batteryInfoProvider;
    private final InfoProvider<DisplayInfo> displayInfoProvider;
    private final String eventName;
    private final FeaturesContextResolver featuresContextResolver;
    private final InternalLogger internalLogger;
    private final RumSessionType sessionType;
    private final TimeProvider timeProvider;
    private final long totalRamBytes;

    public MemoryEventFactory(RumSessionType sessionType, long j, TimeProvider timeProvider, InfoProvider<BatteryInfo> batteryInfoProvider, InfoProvider<DisplayInfo> displayInfoProvider, InternalLogger internalLogger, FeaturesContextResolver featuresContextResolver) {
        Intrinsics.checkNotNullParameter(sessionType, "sessionType");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        Intrinsics.checkNotNullParameter(batteryInfoProvider, "batteryInfoProvider");
        Intrinsics.checkNotNullParameter(displayInfoProvider, "displayInfoProvider");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(featuresContextResolver, "featuresContextResolver");
        this.sessionType = sessionType;
        this.totalRamBytes = j;
        this.timeProvider = timeProvider;
        this.batteryInfoProvider = batteryInfoProvider;
        this.displayInfoProvider = displayInfoProvider;
        this.internalLogger = internalLogger;
        this.featuresContextResolver = featuresContextResolver;
        this.eventName = "memory";
    }

    public /* synthetic */ MemoryEventFactory(RumSessionType rumSessionType, long j, TimeProvider timeProvider, InfoProvider infoProvider, InfoProvider infoProvider2, InternalLogger internalLogger, FeaturesContextResolver featuresContextResolver, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(rumSessionType, j, timeProvider, infoProvider, infoProvider2, internalLogger, (i & 64) != 0 ? new FeaturesContextResolver() : featuresContextResolver);
    }

    @Override // com.datadog.android.rum.internal.timeseries.factory.EventFactory
    public String getEventName() {
        return this.eventName;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.datadog.android.rum.internal.timeseries.factory.EventFactory
    public TimeseriesMemoryEvent create(DatadogContext datadogContext, RumContext rumContext, List<DataPoint<Double>> dataPoints) {
        String syntheticsResultId;
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        Intrinsics.checkNotNullParameter(rumContext, "rumContext");
        Intrinsics.checkNotNullParameter(dataPoints, "dataPoints");
        if (this.totalRamBytes <= 0 || dataPoints.isEmpty()) {
            return null;
        }
        DeviceInfo deviceInfo = datadogContext.getDeviceInfo();
        String syntheticsTestId = rumContext.getSyntheticsTestId();
        TimeseriesMemoryEvent.Synthetics synthetics = (syntheticsTestId == null || StringsKt.isBlank(syntheticsTestId) || (syntheticsResultId = rumContext.getSyntheticsResultId()) == null || StringsKt.isBlank(syntheticsResultId)) ? null : new TimeseriesMemoryEvent.Synthetics(rumContext.getSyntheticsTestId(), rumContext.getSyntheticsResultId(), null, null, 12, null);
        TimeseriesMemoryEvent.Dd dd = new TimeseriesMemoryEvent.Dd(new TimeseriesMemoryEvent.DdSession(null, RumEventExtKt.toTimeseriesMemorySessionPrecondition(rumContext.getSessionStartReason()), 1, null), new TimeseriesMemoryEvent.Configuration(Float.valueOf(rumContext.getSessionSampleRate()), RumEventExtKt.resolveSessionReplaySampleRate(datadogContext), null, RumEventExtKt.resolveTraceSampleRate(datadogContext), null, 20, null), null, null, 12, null);
        TimeseriesMemoryEvent.Application application = new TimeseriesMemoryEvent.Application(rumContext.getApplicationId(), deviceInfo.getLocaleInfo().getCurrentLocale());
        String sessionId = rumContext.getSessionId();
        TimeseriesMemoryEvent.TimeseriesMemoryEventSessionType timeseriesMemorySessionType = RumSessionTypeExtKt.toTimeseriesMemorySessionType(this.sessionType);
        FeaturesContextResolver featuresContextResolver = this.featuresContextResolver;
        String viewId = rumContext.getViewId();
        if (viewId == null) {
            viewId = "";
        }
        TimeseriesMemoryEvent.TimeseriesMemoryEventSession timeseriesMemoryEventSession = new TimeseriesMemoryEvent.TimeseriesMemoryEventSession(sessionId, timeseriesMemorySessionType, Boolean.valueOf(featuresContextResolver.resolveViewHasReplay(datadogContext, viewId)));
        TimeseriesMemoryEvent.Source sourceTryFromSource = RumEventExtKt.tryFromSource(TimeseriesMemoryEvent.Source.INSTANCE, datadogContext.getSource(), this.internalLogger);
        long serverTimestampMillis = this.timeProvider.getServerTimestampMillis();
        String version = datadogContext.getVersion();
        String service = datadogContext.getService();
        String strValueOf = String.valueOf(datadogContext.getVersionCode());
        String appBuildId = datadogContext.getAppBuildId();
        String ddTagsString = DdTagsUtils.INSTANCE.toDdTagsString(datadogContext);
        TimeseriesMemoryEvent.Os timeseriesMemoryOs = RumEventExtKt.toTimeseriesMemoryOs(deviceInfo);
        TimeseriesMemoryEvent.Device timeseriesMemoryDevice = RumEventExtKt.toTimeseriesMemoryDevice(deviceInfo, (BatteryInfo) this.batteryInfoProvider.getCurrentState(), (DisplayInfo) this.displayInfoProvider.getCurrentState());
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        DataPoint dataPoint = (DataPoint) CollectionsKt.firstOrNull((List) dataPoints);
        long timestampNs = dataPoint != null ? dataPoint.getTimestampNs() : 0L;
        DataPoint dataPoint2 = (DataPoint) CollectionsKt.lastOrNull((List) dataPoints);
        long timestampNs2 = dataPoint2 != null ? dataPoint2.getTimestampNs() : 0L;
        List<DataPoint<Double>> list = dataPoints;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((DataPoint) it.next()).getTimestampNs()));
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList3.add(Double.valueOf((((Number) ((DataPoint) it2.next()).getValue()).doubleValue() / this.totalRamBytes) * 100.0d));
            timeseriesMemoryEventSession = timeseriesMemoryEventSession;
        }
        TimeseriesMemoryEvent.TimeseriesMemoryEventSession timeseriesMemoryEventSession2 = timeseriesMemoryEventSession;
        ArrayList arrayList4 = arrayList3;
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it3 = list.iterator();
        while (it3.hasNext()) {
            arrayList5.add(Double.valueOf(((Number) ((DataPoint) it3.next()).getValue()).doubleValue() / 1000.0d));
        }
        return new TimeseriesMemoryEvent(serverTimestampMillis, application, service, version, strValueOf, appBuildId, ddTagsString, timeseriesMemoryEventSession2, sourceTryFromSource, null, null, null, null, null, null, synthetics, null, timeseriesMemoryOs, timeseriesMemoryDevice, dd, null, null, new TimeseriesMemoryEvent.Timeseries(string, timestampNs, timestampNs2, new TimeseriesMemoryEvent.Data(arrayList2, new TimeseriesMemoryEvent.Values(arrayList5, arrayList4))), 3243520, null);
    }

    /* JADX INFO: compiled from: MemoryEventFactory.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/internal/timeseries/factory/MemoryEventFactory$Companion;", "", "()V", "BYTES_IN_KB", "", "PERCENT_FACTOR", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

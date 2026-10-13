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
import com.datadog.android.rum.model.TimeseriesCpuEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CpuEventFactory.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001BC\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J.\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u001d0\u001cH\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/datadog/android/rum/internal/timeseries/factory/CpuEventFactory;", "Lcom/datadog/android/rum/internal/timeseries/factory/EventFactory;", "", "Lcom/datadog/android/rum/model/TimeseriesCpuEvent;", "sessionType", "Lcom/datadog/android/rum/RumSessionType;", "timeProvider", "Lcom/datadog/android/internal/time/TimeProvider;", "batteryInfoProvider", "Lcom/datadog/android/rum/internal/domain/InfoProvider;", "Lcom/datadog/android/rum/internal/domain/battery/BatteryInfo;", "displayInfoProvider", "Lcom/datadog/android/rum/internal/domain/display/DisplayInfo;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "featuresContextResolver", "Lcom/datadog/android/rum/internal/FeaturesContextResolver;", "(Lcom/datadog/android/rum/RumSessionType;Lcom/datadog/android/internal/time/TimeProvider;Lcom/datadog/android/rum/internal/domain/InfoProvider;Lcom/datadog/android/rum/internal/domain/InfoProvider;Lcom/datadog/android/api/InternalLogger;Lcom/datadog/android/rum/internal/FeaturesContextResolver;)V", "eventName", "", "getEventName", "()Ljava/lang/String;", "create", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "rumContext", "Lcom/datadog/android/rum/internal/domain/RumContext;", "dataPoints", "", "Lcom/datadog/android/rum/internal/timeseries/DataPoint;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CpuEventFactory implements EventFactory<Double, TimeseriesCpuEvent> {
    private final InfoProvider<BatteryInfo> batteryInfoProvider;
    private final InfoProvider<DisplayInfo> displayInfoProvider;
    private final String eventName;
    private final FeaturesContextResolver featuresContextResolver;
    private final InternalLogger internalLogger;
    private final RumSessionType sessionType;
    private final TimeProvider timeProvider;

    public CpuEventFactory(RumSessionType sessionType, TimeProvider timeProvider, InfoProvider<BatteryInfo> batteryInfoProvider, InfoProvider<DisplayInfo> displayInfoProvider, InternalLogger internalLogger, FeaturesContextResolver featuresContextResolver) {
        Intrinsics.checkNotNullParameter(sessionType, "sessionType");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        Intrinsics.checkNotNullParameter(batteryInfoProvider, "batteryInfoProvider");
        Intrinsics.checkNotNullParameter(displayInfoProvider, "displayInfoProvider");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(featuresContextResolver, "featuresContextResolver");
        this.sessionType = sessionType;
        this.timeProvider = timeProvider;
        this.batteryInfoProvider = batteryInfoProvider;
        this.displayInfoProvider = displayInfoProvider;
        this.internalLogger = internalLogger;
        this.featuresContextResolver = featuresContextResolver;
        this.eventName = "cpu";
    }

    public /* synthetic */ CpuEventFactory(RumSessionType rumSessionType, TimeProvider timeProvider, InfoProvider infoProvider, InfoProvider infoProvider2, InternalLogger internalLogger, FeaturesContextResolver featuresContextResolver, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(rumSessionType, timeProvider, infoProvider, infoProvider2, internalLogger, (i & 32) != 0 ? new FeaturesContextResolver() : featuresContextResolver);
    }

    @Override // com.datadog.android.rum.internal.timeseries.factory.EventFactory
    public String getEventName() {
        return this.eventName;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.datadog.android.rum.internal.timeseries.factory.EventFactory
    public TimeseriesCpuEvent create(DatadogContext datadogContext, RumContext rumContext, List<DataPoint<Double>> dataPoints) {
        String syntheticsResultId;
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        Intrinsics.checkNotNullParameter(rumContext, "rumContext");
        Intrinsics.checkNotNullParameter(dataPoints, "dataPoints");
        if (dataPoints.isEmpty()) {
            return null;
        }
        DeviceInfo deviceInfo = datadogContext.getDeviceInfo();
        String syntheticsTestId = rumContext.getSyntheticsTestId();
        TimeseriesCpuEvent.Synthetics synthetics = (syntheticsTestId == null || StringsKt.isBlank(syntheticsTestId) || (syntheticsResultId = rumContext.getSyntheticsResultId()) == null || StringsKt.isBlank(syntheticsResultId)) ? null : new TimeseriesCpuEvent.Synthetics(rumContext.getSyntheticsTestId(), rumContext.getSyntheticsResultId(), null, null, 12, null);
        TimeseriesCpuEvent.Dd dd = new TimeseriesCpuEvent.Dd(new TimeseriesCpuEvent.DdSession(null, RumEventExtKt.toTimeseriesCpuSessionPrecondition(rumContext.getSessionStartReason()), 1, null), new TimeseriesCpuEvent.Configuration(Float.valueOf(rumContext.getSessionSampleRate()), RumEventExtKt.resolveSessionReplaySampleRate(datadogContext), null, RumEventExtKt.resolveTraceSampleRate(datadogContext), null, 20, null), null, null, 12, null);
        TimeseriesCpuEvent.Application application = new TimeseriesCpuEvent.Application(rumContext.getApplicationId(), deviceInfo.getLocaleInfo().getCurrentLocale());
        String sessionId = rumContext.getSessionId();
        TimeseriesCpuEvent.TimeseriesCpuEventSessionType timeseriesCpuSessionType = RumSessionTypeExtKt.toTimeseriesCpuSessionType(this.sessionType);
        FeaturesContextResolver featuresContextResolver = this.featuresContextResolver;
        String viewId = rumContext.getViewId();
        if (viewId == null) {
            viewId = "";
        }
        TimeseriesCpuEvent.TimeseriesCpuEventSession timeseriesCpuEventSession = new TimeseriesCpuEvent.TimeseriesCpuEventSession(sessionId, timeseriesCpuSessionType, Boolean.valueOf(featuresContextResolver.resolveViewHasReplay(datadogContext, viewId)));
        TimeseriesCpuEvent.Source sourceTryFromSource = RumEventExtKt.tryFromSource(TimeseriesCpuEvent.Source.INSTANCE, datadogContext.getSource(), this.internalLogger);
        long serverTimestampMillis = this.timeProvider.getServerTimestampMillis();
        String version = datadogContext.getVersion();
        String service = datadogContext.getService();
        String strValueOf = String.valueOf(datadogContext.getVersionCode());
        String appBuildId = datadogContext.getAppBuildId();
        String ddTagsString = DdTagsUtils.INSTANCE.toDdTagsString(datadogContext);
        TimeseriesCpuEvent.Os timeseriesCpuOs = RumEventExtKt.toTimeseriesCpuOs(deviceInfo);
        TimeseriesCpuEvent.Device timeseriesCpuDevice = RumEventExtKt.toTimeseriesCpuDevice(deviceInfo, (BatteryInfo) this.batteryInfoProvider.getCurrentState(), (DisplayInfo) this.displayInfoProvider.getCurrentState());
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
            arrayList3.add(Double.valueOf(((Number) ((DataPoint) it2.next()).getValue()).doubleValue()));
        }
        return new TimeseriesCpuEvent(serverTimestampMillis, application, service, version, strValueOf, appBuildId, ddTagsString, timeseriesCpuEventSession, sourceTryFromSource, null, null, null, null, null, null, synthetics, null, timeseriesCpuOs, timeseriesCpuDevice, dd, null, null, new TimeseriesCpuEvent.Timeseries(string, timestampNs, timestampNs2, new TimeseriesCpuEvent.Data(arrayList2, new TimeseriesCpuEvent.Values(arrayList3))), 3243520, null);
    }
}

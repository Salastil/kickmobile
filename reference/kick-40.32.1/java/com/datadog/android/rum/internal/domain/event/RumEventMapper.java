package com.datadog.android.rum.internal.domain.event;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.event.EventMapper;
import com.datadog.android.event.NoOpEventMapper;
import com.datadog.android.rum.model.ActionEvent;
import com.datadog.android.rum.model.ErrorEvent;
import com.datadog.android.rum.model.LongTaskEvent;
import com.datadog.android.rum.model.ResourceEvent;
import com.datadog.android.rum.model.TimeseriesCpuEvent;
import com.datadog.android.rum.model.TimeseriesMemoryEvent;
import com.datadog.android.rum.model.ViewEvent;
import com.datadog.android.rum.model.VitalAppLaunchEvent;
import com.datadog.android.rum.model.VitalOperationStepEvent;
import com.datadog.android.telemetry.model.TelemetryConfigurationEvent;
import com.datadog.android.telemetry.model.TelemetryDebugEvent;
import com.datadog.android.telemetry.model.TelemetryErrorEvent;
import com.datadog.android.telemetry.model.TelemetryUsageEvent;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RumEventMapper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00014B\u008d\u0001\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0001\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0001\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0001\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0001\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0001\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u0001HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u0001HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\u0001HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0\u0001HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001HÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00100\u0001HÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00120\u0001HÆ\u0003J\t\u0010'\u001a\u00020\u0014HÂ\u0003J\u0093\u0001\u0010(\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u0014HÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\u0012\u0010.\u001a\u0004\u0018\u00010\u00022\u0006\u0010/\u001a\u00020\u0002H\u0016J\u0012\u00100\u001a\u0004\u0018\u00010\u00022\u0006\u0010/\u001a\u00020\u0002H\u0002J\u0012\u00101\u001a\u0004\u0018\u00010\u00022\u0006\u0010/\u001a\u00020\u0002H\u0002J\t\u00102\u001a\u000203HÖ\u0001R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017¨\u00065"}, d2 = {"Lcom/datadog/android/rum/internal/domain/event/RumEventMapper;", "Lcom/datadog/android/event/EventMapper;", "", "viewEventMapper", "Lcom/datadog/android/rum/model/ViewEvent;", "errorEventMapper", "Lcom/datadog/android/rum/model/ErrorEvent;", "resourceEventMapper", "Lcom/datadog/android/rum/model/ResourceEvent;", "actionEventMapper", "Lcom/datadog/android/rum/model/ActionEvent;", "longTaskEventMapper", "Lcom/datadog/android/rum/model/LongTaskEvent;", "vitalOperationStepEventMapper", "Lcom/datadog/android/rum/model/VitalOperationStepEvent;", "vitalAppLaunchEventMapper", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent;", "telemetryConfigurationMapper", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Lcom/datadog/android/event/EventMapper;Lcom/datadog/android/event/EventMapper;Lcom/datadog/android/event/EventMapper;Lcom/datadog/android/event/EventMapper;Lcom/datadog/android/event/EventMapper;Lcom/datadog/android/event/EventMapper;Lcom/datadog/android/event/EventMapper;Lcom/datadog/android/event/EventMapper;Lcom/datadog/android/api/InternalLogger;)V", "getActionEventMapper", "()Lcom/datadog/android/event/EventMapper;", "getErrorEventMapper", "getLongTaskEventMapper", "getResourceEventMapper", "getTelemetryConfigurationMapper", "getViewEventMapper", "getVitalAppLaunchEventMapper", "getVitalOperationStepEventMapper", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "map", "event", "mapRumEvent", "resolveEvent", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RumEventMapper implements EventMapper<Object> {
    public static final String EVENT_NULL_WARNING_MESSAGE = "RumEventMapper: the returned mapped object was null. This event will be dropped: %s";
    public static final String NOT_SAME_EVENT_INSTANCE_WARNING_MESSAGE = "RumEventMapper: the returned mapped object was not the same instance as the original object. This event will be dropped: %s";
    public static final String NO_DROPPING_FATAL_ERRORS_WARNING_MESSAGE = "RumEventMapper: the return from the ErrorEvent mapper was null for a crash. Dropping crashes in from the event mapper is not supported. The original event object will be used instead.";
    public static final String NO_EVENT_MAPPER_ASSIGNED_WARNING_MESSAGE = "RumEventMapper: there was no EventMapper assigned for RUM event type: %s";
    public static final String VIEW_EVENT_NULL_WARNING_MESSAGE = "RumEventMapper: the returned mapped ViewEvent was null. The original event object will be used instead: %s";
    private final EventMapper<ActionEvent> actionEventMapper;
    private final EventMapper<ErrorEvent> errorEventMapper;
    private final InternalLogger internalLogger;
    private final EventMapper<LongTaskEvent> longTaskEventMapper;
    private final EventMapper<ResourceEvent> resourceEventMapper;
    private final EventMapper<TelemetryConfigurationEvent> telemetryConfigurationMapper;
    private final EventMapper<ViewEvent> viewEventMapper;
    private final EventMapper<VitalAppLaunchEvent> vitalAppLaunchEventMapper;
    private final EventMapper<VitalOperationStepEvent> vitalOperationStepEventMapper;

    /* JADX INFO: renamed from: component9, reason: from getter */
    private final InternalLogger getInternalLogger() {
        return this.internalLogger;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RumEventMapper copy$default(RumEventMapper rumEventMapper, EventMapper eventMapper, EventMapper eventMapper2, EventMapper eventMapper3, EventMapper eventMapper4, EventMapper eventMapper5, EventMapper eventMapper6, EventMapper eventMapper7, EventMapper eventMapper8, InternalLogger internalLogger, int i, Object obj) {
        if ((i & 1) != 0) {
            eventMapper = rumEventMapper.viewEventMapper;
        }
        if ((i & 2) != 0) {
            eventMapper2 = rumEventMapper.errorEventMapper;
        }
        if ((i & 4) != 0) {
            eventMapper3 = rumEventMapper.resourceEventMapper;
        }
        if ((i & 8) != 0) {
            eventMapper4 = rumEventMapper.actionEventMapper;
        }
        if ((i & 16) != 0) {
            eventMapper5 = rumEventMapper.longTaskEventMapper;
        }
        if ((i & 32) != 0) {
            eventMapper6 = rumEventMapper.vitalOperationStepEventMapper;
        }
        if ((i & 64) != 0) {
            eventMapper7 = rumEventMapper.vitalAppLaunchEventMapper;
        }
        if ((i & 128) != 0) {
            eventMapper8 = rumEventMapper.telemetryConfigurationMapper;
        }
        if ((i & 256) != 0) {
            internalLogger = rumEventMapper.internalLogger;
        }
        EventMapper eventMapper9 = eventMapper8;
        InternalLogger internalLogger2 = internalLogger;
        EventMapper eventMapper10 = eventMapper6;
        EventMapper eventMapper11 = eventMapper7;
        EventMapper eventMapper12 = eventMapper5;
        EventMapper eventMapper13 = eventMapper3;
        return rumEventMapper.copy(eventMapper, eventMapper2, eventMapper13, eventMapper4, eventMapper12, eventMapper10, eventMapper11, eventMapper9, internalLogger2);
    }

    public final EventMapper<ViewEvent> component1() {
        return this.viewEventMapper;
    }

    public final EventMapper<ErrorEvent> component2() {
        return this.errorEventMapper;
    }

    public final EventMapper<ResourceEvent> component3() {
        return this.resourceEventMapper;
    }

    public final EventMapper<ActionEvent> component4() {
        return this.actionEventMapper;
    }

    public final EventMapper<LongTaskEvent> component5() {
        return this.longTaskEventMapper;
    }

    public final EventMapper<VitalOperationStepEvent> component6() {
        return this.vitalOperationStepEventMapper;
    }

    public final EventMapper<VitalAppLaunchEvent> component7() {
        return this.vitalAppLaunchEventMapper;
    }

    public final EventMapper<TelemetryConfigurationEvent> component8() {
        return this.telemetryConfigurationMapper;
    }

    public final RumEventMapper copy(EventMapper<ViewEvent> viewEventMapper, EventMapper<ErrorEvent> errorEventMapper, EventMapper<ResourceEvent> resourceEventMapper, EventMapper<ActionEvent> actionEventMapper, EventMapper<LongTaskEvent> longTaskEventMapper, EventMapper<VitalOperationStepEvent> vitalOperationStepEventMapper, EventMapper<VitalAppLaunchEvent> vitalAppLaunchEventMapper, EventMapper<TelemetryConfigurationEvent> telemetryConfigurationMapper, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(viewEventMapper, "viewEventMapper");
        Intrinsics.checkNotNullParameter(errorEventMapper, "errorEventMapper");
        Intrinsics.checkNotNullParameter(resourceEventMapper, "resourceEventMapper");
        Intrinsics.checkNotNullParameter(actionEventMapper, "actionEventMapper");
        Intrinsics.checkNotNullParameter(longTaskEventMapper, "longTaskEventMapper");
        Intrinsics.checkNotNullParameter(vitalOperationStepEventMapper, "vitalOperationStepEventMapper");
        Intrinsics.checkNotNullParameter(vitalAppLaunchEventMapper, "vitalAppLaunchEventMapper");
        Intrinsics.checkNotNullParameter(telemetryConfigurationMapper, "telemetryConfigurationMapper");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        return new RumEventMapper(viewEventMapper, errorEventMapper, resourceEventMapper, actionEventMapper, longTaskEventMapper, vitalOperationStepEventMapper, vitalAppLaunchEventMapper, telemetryConfigurationMapper, internalLogger);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RumEventMapper)) {
            return false;
        }
        RumEventMapper rumEventMapper = (RumEventMapper) other;
        return Intrinsics.areEqual(this.viewEventMapper, rumEventMapper.viewEventMapper) && Intrinsics.areEqual(this.errorEventMapper, rumEventMapper.errorEventMapper) && Intrinsics.areEqual(this.resourceEventMapper, rumEventMapper.resourceEventMapper) && Intrinsics.areEqual(this.actionEventMapper, rumEventMapper.actionEventMapper) && Intrinsics.areEqual(this.longTaskEventMapper, rumEventMapper.longTaskEventMapper) && Intrinsics.areEqual(this.vitalOperationStepEventMapper, rumEventMapper.vitalOperationStepEventMapper) && Intrinsics.areEqual(this.vitalAppLaunchEventMapper, rumEventMapper.vitalAppLaunchEventMapper) && Intrinsics.areEqual(this.telemetryConfigurationMapper, rumEventMapper.telemetryConfigurationMapper) && Intrinsics.areEqual(this.internalLogger, rumEventMapper.internalLogger);
    }

    public int hashCode() {
        return (((((((((((((((this.viewEventMapper.hashCode() * 31) + this.errorEventMapper.hashCode()) * 31) + this.resourceEventMapper.hashCode()) * 31) + this.actionEventMapper.hashCode()) * 31) + this.longTaskEventMapper.hashCode()) * 31) + this.vitalOperationStepEventMapper.hashCode()) * 31) + this.vitalAppLaunchEventMapper.hashCode()) * 31) + this.telemetryConfigurationMapper.hashCode()) * 31) + this.internalLogger.hashCode();
    }

    public String toString() {
        return "RumEventMapper(viewEventMapper=" + this.viewEventMapper + ", errorEventMapper=" + this.errorEventMapper + ", resourceEventMapper=" + this.resourceEventMapper + ", actionEventMapper=" + this.actionEventMapper + ", longTaskEventMapper=" + this.longTaskEventMapper + ", vitalOperationStepEventMapper=" + this.vitalOperationStepEventMapper + ", vitalAppLaunchEventMapper=" + this.vitalAppLaunchEventMapper + ", telemetryConfigurationMapper=" + this.telemetryConfigurationMapper + ", internalLogger=" + this.internalLogger + ")";
    }

    public RumEventMapper(EventMapper<ViewEvent> viewEventMapper, EventMapper<ErrorEvent> errorEventMapper, EventMapper<ResourceEvent> resourceEventMapper, EventMapper<ActionEvent> actionEventMapper, EventMapper<LongTaskEvent> longTaskEventMapper, EventMapper<VitalOperationStepEvent> vitalOperationStepEventMapper, EventMapper<VitalAppLaunchEvent> vitalAppLaunchEventMapper, EventMapper<TelemetryConfigurationEvent> telemetryConfigurationMapper, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(viewEventMapper, "viewEventMapper");
        Intrinsics.checkNotNullParameter(errorEventMapper, "errorEventMapper");
        Intrinsics.checkNotNullParameter(resourceEventMapper, "resourceEventMapper");
        Intrinsics.checkNotNullParameter(actionEventMapper, "actionEventMapper");
        Intrinsics.checkNotNullParameter(longTaskEventMapper, "longTaskEventMapper");
        Intrinsics.checkNotNullParameter(vitalOperationStepEventMapper, "vitalOperationStepEventMapper");
        Intrinsics.checkNotNullParameter(vitalAppLaunchEventMapper, "vitalAppLaunchEventMapper");
        Intrinsics.checkNotNullParameter(telemetryConfigurationMapper, "telemetryConfigurationMapper");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.viewEventMapper = viewEventMapper;
        this.errorEventMapper = errorEventMapper;
        this.resourceEventMapper = resourceEventMapper;
        this.actionEventMapper = actionEventMapper;
        this.longTaskEventMapper = longTaskEventMapper;
        this.vitalOperationStepEventMapper = vitalOperationStepEventMapper;
        this.vitalAppLaunchEventMapper = vitalAppLaunchEventMapper;
        this.telemetryConfigurationMapper = telemetryConfigurationMapper;
        this.internalLogger = internalLogger;
    }

    public /* synthetic */ RumEventMapper(NoOpEventMapper noOpEventMapper, NoOpEventMapper noOpEventMapper2, NoOpEventMapper noOpEventMapper3, NoOpEventMapper noOpEventMapper4, NoOpEventMapper noOpEventMapper5, NoOpEventMapper noOpEventMapper6, NoOpEventMapper noOpEventMapper7, NoOpEventMapper noOpEventMapper8, InternalLogger internalLogger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new NoOpEventMapper() : noOpEventMapper, (i & 2) != 0 ? new NoOpEventMapper() : noOpEventMapper2, (i & 4) != 0 ? new NoOpEventMapper() : noOpEventMapper3, (i & 8) != 0 ? new NoOpEventMapper() : noOpEventMapper4, (i & 16) != 0 ? new NoOpEventMapper() : noOpEventMapper5, (i & 32) != 0 ? new NoOpEventMapper() : noOpEventMapper6, (i & 64) != 0 ? new NoOpEventMapper() : noOpEventMapper7, (i & 128) != 0 ? new NoOpEventMapper() : noOpEventMapper8, internalLogger);
    }

    public final EventMapper<ViewEvent> getViewEventMapper() {
        return this.viewEventMapper;
    }

    public final EventMapper<ErrorEvent> getErrorEventMapper() {
        return this.errorEventMapper;
    }

    public final EventMapper<ResourceEvent> getResourceEventMapper() {
        return this.resourceEventMapper;
    }

    public final EventMapper<ActionEvent> getActionEventMapper() {
        return this.actionEventMapper;
    }

    public final EventMapper<LongTaskEvent> getLongTaskEventMapper() {
        return this.longTaskEventMapper;
    }

    public final EventMapper<VitalOperationStepEvent> getVitalOperationStepEventMapper() {
        return this.vitalOperationStepEventMapper;
    }

    public final EventMapper<VitalAppLaunchEvent> getVitalAppLaunchEventMapper() {
        return this.vitalAppLaunchEventMapper;
    }

    public final EventMapper<TelemetryConfigurationEvent> getTelemetryConfigurationMapper() {
        return this.telemetryConfigurationMapper;
    }

    @Override // com.datadog.android.event.EventMapper
    public Object map(Object event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return resolveEvent(event);
    }

    private final Object mapRumEvent(final Object event) {
        if (event instanceof ViewEvent) {
            return this.viewEventMapper.map(event);
        }
        if (event instanceof ActionEvent) {
            return this.actionEventMapper.map(event);
        }
        if (event instanceof ErrorEvent) {
            ErrorEvent errorEvent = (ErrorEvent) event;
            boolean zAreEqual = Intrinsics.areEqual((Object) errorEvent.getError().isCrash(), (Object) true);
            EventMapper<ErrorEvent> eventMapper = this.errorEventMapper;
            if (zAreEqual) {
                ErrorEvent map = eventMapper.map(event);
                if (map != null) {
                    return map;
                }
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.event.RumEventMapper.mapRumEvent.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return RumEventMapper.NO_DROPPING_FATAL_ERRORS_WARNING_MESSAGE;
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
                return errorEvent;
            }
            return eventMapper.map(event);
        }
        if (event instanceof ResourceEvent) {
            return this.resourceEventMapper.map(event);
        }
        if (event instanceof LongTaskEvent) {
            return this.longTaskEventMapper.map(event);
        }
        if (event instanceof VitalOperationStepEvent) {
            return this.vitalOperationStepEventMapper.map(event);
        }
        if (event instanceof VitalAppLaunchEvent) {
            return this.vitalAppLaunchEventMapper.map(event);
        }
        if (event instanceof TelemetryConfigurationEvent) {
            return this.telemetryConfigurationMapper.map(event);
        }
        if (event instanceof TimeseriesCpuEvent ? true : event instanceof TimeseriesMemoryEvent ? true : event instanceof TelemetryDebugEvent ? true : event instanceof TelemetryUsageEvent ? true : event instanceof TelemetryErrorEvent) {
            return event;
        }
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.event.RumEventMapper.mapRumEvent.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str = String.format(Locale.US, RumEventMapper.NO_EVENT_MAPPER_ASSIGNED_WARNING_MESSAGE, Arrays.copyOf(new Object[]{event.getClass().getSimpleName()}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return str;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
        return event;
    }

    private final Object resolveEvent(final Object event) {
        Object objMapRumEvent = mapRumEvent(event);
        if ((event instanceof ViewEvent) && (objMapRumEvent == null || objMapRumEvent != event)) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.event.RumEventMapper.resolveEvent.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, RumEventMapper.VIEW_EVENT_NULL_WARNING_MESSAGE, Arrays.copyOf(new Object[]{event}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return event;
        }
        if (objMapRumEvent == null) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.INFO, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.event.RumEventMapper.resolveEvent.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, RumEventMapper.EVENT_NULL_WARNING_MESSAGE, Arrays.copyOf(new Object[]{event}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return null;
        }
        if (objMapRumEvent == event) {
            return event;
        }
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.event.RumEventMapper.resolveEvent.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str = String.format(Locale.US, RumEventMapper.NOT_SAME_EVENT_INSTANCE_WARNING_MESSAGE, Arrays.copyOf(new Object[]{event}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return str;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
        return null;
    }
}

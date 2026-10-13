package com.datadog.android.rum.internal;

import android.app.ApplicationExitInfo;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.context.DeviceInfo;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.api.storage.EventType;
import com.datadog.android.core.InternalSdkCore;
import com.datadog.android.core.feature.event.ThreadDump;
import com.datadog.android.core.internal.persistence.Deserializer;
import com.datadog.android.core.internal.utils.DdTagsUtils;
import com.datadog.android.rum.internal.anr.ANRDetectorRunnable;
import com.datadog.android.rum.internal.anr.ANRException;
import com.datadog.android.rum.internal.anr.AndroidTraceParser;
import com.datadog.android.rum.internal.domain.event.RumEventDeserializer;
import com.datadog.android.rum.internal.domain.scope.RumEventExtKt;
import com.datadog.android.rum.model.ErrorEvent;
import com.datadog.android.rum.model.ViewEvent;
import com.google.android.gms.cast.MediaTrack;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DatadogLateCrashReporter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 <2\u00020\u0001:\u0001<B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ&\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00062\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070#H\u0017J&\u0010$\u001a\u00020\u001e2\u000e\u0010%\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030&2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070#H\u0016J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00100\u00112\u0006\u0010\u001f\u001a\u00020 H\u0003Jg\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001012\u0006\u00103\u001a\u00020\u00152\u0006\u00104\u001a\u00020\u00152\u000e\u00105\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00112\u0006\u00106\u001a\u00020\rH\u0002¢\u0006\u0002\u00107J\u0010\u00108\u001a\u00020\r2\u0006\u00109\u001a\u00020\rH\u0002J\u0016\u0010:\u001a\u00020,*\u00020;2\b\u0010+\u001a\u0004\u0018\u00010\u0015H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\u00020\f*\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u0010*\b\u0012\u0004\u0012\u00020\u00100\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u0015*\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\u00020\u001a*\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006="}, d2 = {"Lcom/datadog/android/rum/internal/DatadogLateCrashReporter;", "Lcom/datadog/android/rum/internal/LateCrashReporter;", "sdkCore", "Lcom/datadog/android/core/InternalSdkCore;", "rumEventDeserializer", "Lcom/datadog/android/core/internal/persistence/Deserializer;", "Lcom/google/gson/JsonObject;", "", "androidTraceParser", "Lcom/datadog/android/rum/internal/anr/AndroidTraceParser;", "(Lcom/datadog/android/core/InternalSdkCore;Lcom/datadog/android/core/internal/persistence/Deserializer;Lcom/datadog/android/rum/internal/anr/AndroidTraceParser;)V", "isWithinSessionAvailability", "", "Lcom/datadog/android/rum/model/ViewEvent;", "(Lcom/datadog/android/rum/model/ViewEvent;)Z", "mainThread", "Lcom/datadog/android/core/feature/event/ThreadDump;", "", "getMainThread", "(Ljava/util/List;)Lcom/datadog/android/core/feature/event/ThreadDump;", "rumSessionId", "", "Lcom/datadog/android/api/context/DatadogContext;", "getRumSessionId", "(Lcom/datadog/android/api/context/DatadogContext;)Ljava/lang/String;", "sampleRate", "", "getSampleRate", "(Lcom/datadog/android/rum/model/ViewEvent;)F", "handleAnrCrash", "", "anrExitInfo", "Landroid/app/ApplicationExitInfo;", "lastRumViewEventJson", "rumWriter", "Lcom/datadog/android/api/storage/DataWriter;", "handleNdkCrashEvent", "event", "", "readThreadsDump", "resolveErrorEventFromViewEvent", "Lcom/datadog/android/rum/model/ErrorEvent;", "datadogContext", "sourceType", "Lcom/datadog/android/rum/model/ErrorEvent$SourceType;", "category", "Lcom/datadog/android/rum/model/ErrorEvent$Category;", "errorLogMessage", "timestamp", "", "timeSinceAppStartMs", "stacktrace", "errorType", "threadDumps", "viewEvent", "(Lcom/datadog/android/api/context/DatadogContext;Lcom/datadog/android/rum/model/ErrorEvent$SourceType;Lcom/datadog/android/rum/model/ErrorEvent$Category;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/datadog/android/rum/model/ViewEvent;)Lcom/datadog/android/rum/model/ErrorEvent;", "updateViewEvent", "lastViewEvent", "tryFromSource", "Lcom/datadog/android/rum/model/ErrorEvent$SourceType$Companion;", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DatadogLateCrashReporter implements LateCrashReporter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final long FATAL_ANR_DEDUP_TOLERANCE_MS = 10000;
    public static final String INFO_RUM_FEATURE_NOT_REGISTERED = "RUM feature is not registered, won't report NDK crash info as RUM error.";
    public static final String MISSING_ANR_TRACE = "Last known exit reason has no trace information attached, cannot report fatal ANR.";
    public static final String NDK_CRASH_EVENT_MISSING_MANDATORY_FIELDS = "RUM feature received a NDK crash event where one or more mandatory (timestamp, signalName, stacktrace, message, lastViewEvent) fields are either missing or have wrong type.";
    public static final String OPEN_ANR_TRACE_ERROR = "Cannot open trace for the last known exit reason.";
    private static final long VIEW_EVENT_AVAILABILITY_TIME_THRESHOLD;
    private final AndroidTraceParser androidTraceParser;
    private final Deserializer<JsonObject, Object> rumEventDeserializer;
    private final InternalSdkCore sdkCore;

    public DatadogLateCrashReporter(InternalSdkCore sdkCore, Deserializer<JsonObject, Object> rumEventDeserializer, AndroidTraceParser androidTraceParser) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(rumEventDeserializer, "rumEventDeserializer");
        Intrinsics.checkNotNullParameter(androidTraceParser, "androidTraceParser");
        this.sdkCore = sdkCore;
        this.rumEventDeserializer = rumEventDeserializer;
        this.androidTraceParser = androidTraceParser;
    }

    public /* synthetic */ DatadogLateCrashReporter(InternalSdkCore internalSdkCore, RumEventDeserializer rumEventDeserializer, AndroidTraceParser androidTraceParser, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(internalSdkCore, (i & 2) != 0 ? new RumEventDeserializer(internalSdkCore.getInternalLogger()) : rumEventDeserializer, (i & 4) != 0 ? new AndroidTraceParser(internalSdkCore.getInternalLogger()) : androidTraceParser);
    }

    @Override // com.datadog.android.rum.internal.LateCrashReporter
    public void handleNdkCrashEvent(Map<?, ?> event, final DataWriter<Object> rumWriter) {
        final ViewEvent viewEvent;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(rumWriter, "rumWriter");
        FeatureScope feature = this.sdkCore.getFeature("rum");
        if (feature == null) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.INFO, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.DatadogLateCrashReporter.handleNdkCrashEvent.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "RUM feature is not registered, won't report NDK crash info as RUM error.";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return;
        }
        Object obj = event.get("sourceType");
        final String str = obj instanceof String ? (String) obj : null;
        Object obj2 = event.get("timestamp");
        final Long l = obj2 instanceof Long ? (Long) obj2 : null;
        Object obj3 = event.get("timeSinceAppStartMs");
        final Long l2 = obj3 instanceof Long ? (Long) obj3 : null;
        Object obj4 = event.get("signalName");
        final String str2 = obj4 instanceof String ? (String) obj4 : null;
        Object obj5 = event.get("stacktrace");
        final String str3 = obj5 instanceof String ? (String) obj5 : null;
        Object obj6 = event.get("message");
        final String str4 = obj6 instanceof String ? (String) obj6 : null;
        Object obj7 = event.get("lastViewEvent");
        JsonObject jsonObject = obj7 instanceof JsonObject ? (JsonObject) obj7 : null;
        if (jsonObject != null) {
            Object objDeserialize = this.rumEventDeserializer.deserialize(jsonObject);
            viewEvent = objDeserialize instanceof ViewEvent ? (ViewEvent) objDeserialize : null;
        } else {
            viewEvent = null;
        }
        if (l == null || str2 == null || str3 == null || str4 == null || viewEvent == null) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.DatadogLateCrashReporter.handleNdkCrashEvent.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return DatadogLateCrashReporter.NDK_CRASH_EVENT_MISSING_MANDATORY_FIELDS;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        } else {
            FeatureScope.DefaultImpls.withWriteContext$default(feature, null, new Function2<DatadogContext, Function1<? super Function1<? super EventBatchWriter, ? extends Unit>, ? extends Unit>, Unit>() { // from class: com.datadog.android.rum.internal.DatadogLateCrashReporter.handleNdkCrashEvent.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, ? extends Unit>, ? extends Unit> function1) {
                    invoke2(datadogContext, (Function1<? super Function1<? super EventBatchWriter, Unit>, Unit>) function1);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope) {
                    Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
                    Intrinsics.checkNotNullParameter(writeScope, "writeScope");
                    DatadogLateCrashReporter datadogLateCrashReporter = DatadogLateCrashReporter.this;
                    final ErrorEvent errorEventResolveErrorEventFromViewEvent = datadogLateCrashReporter.resolveErrorEventFromViewEvent(datadogContext, datadogLateCrashReporter.tryFromSource(ErrorEvent.SourceType.INSTANCE, str), ErrorEvent.Category.EXCEPTION, str4, l.longValue(), l2, str3, str2, null, viewEvent);
                    final DataWriter<Object> dataWriter = rumWriter;
                    final DatadogLateCrashReporter datadogLateCrashReporter2 = DatadogLateCrashReporter.this;
                    final ViewEvent viewEvent2 = viewEvent;
                    writeScope.invoke(new Function1<EventBatchWriter, Unit>() { // from class: com.datadog.android.rum.internal.DatadogLateCrashReporter.handleNdkCrashEvent.3.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(EventBatchWriter eventBatchWriter) {
                            invoke2(eventBatchWriter);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(EventBatchWriter it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            dataWriter.write(it, errorEventResolveErrorEventFromViewEvent, EventType.CRASH);
                            if (datadogLateCrashReporter2.isWithinSessionAvailability(viewEvent2)) {
                                dataWriter.write(it, datadogLateCrashReporter2.updateViewEvent(viewEvent2), EventType.CRASH);
                            }
                        }
                    });
                }
            }, 1, null);
        }
    }

    @Override // com.datadog.android.rum.internal.LateCrashReporter
    public void handleAnrCrash(final ApplicationExitInfo anrExitInfo, JsonObject lastRumViewEventJson, final DataWriter<Object> rumWriter) {
        Intrinsics.checkNotNullParameter(anrExitInfo, "anrExitInfo");
        Intrinsics.checkNotNullParameter(lastRumViewEventJson, "lastRumViewEventJson");
        Intrinsics.checkNotNullParameter(rumWriter, "rumWriter");
        Object objDeserialize = this.rumEventDeserializer.deserialize(lastRumViewEventJson);
        final ViewEvent viewEvent = objDeserialize instanceof ViewEvent ? (ViewEvent) objDeserialize : null;
        if (viewEvent == null) {
            return;
        }
        if (anrExitInfo.getTimestamp() > viewEvent.getDate()) {
            FeatureScope feature = this.sdkCore.getFeature("rum");
            if (feature == null) {
                InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.DatadogLateCrashReporter.handleAnrCrash.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "RUM feature is not registered, won't report NDK crash info as RUM error.";
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
            } else {
                feature.withWriteContext(SetsKt.setOf("rum"), new Function2<DatadogContext, Function1<? super Function1<? super EventBatchWriter, ? extends Unit>, ? extends Unit>, Unit>() { // from class: com.datadog.android.rum.internal.DatadogLateCrashReporter.handleAnrCrash.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, ? extends Unit>, ? extends Unit> function1) {
                        invoke2(datadogContext, (Function1<? super Function1<? super EventBatchWriter, Unit>, Unit>) function1);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope) {
                        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
                        Intrinsics.checkNotNullParameter(writeScope, "writeScope");
                        if (Intrinsics.areEqual(viewEvent.getSession().getId(), this.getRumSessionId(datadogContext))) {
                            return;
                        }
                        Long lastFatalAnrSent = this.sdkCore.getLastFatalAnrSent();
                        if (lastFatalAnrSent == null || Math.abs(anrExitInfo.getTimestamp() - lastFatalAnrSent.longValue()) > 10000) {
                            List threadsDump = this.readThreadsDump(anrExitInfo);
                            if (threadsDump.isEmpty()) {
                                return;
                            }
                            DatadogLateCrashReporter datadogLateCrashReporter = this;
                            ErrorEvent.SourceType sourceType = ErrorEvent.SourceType.ANDROID;
                            ErrorEvent.Category category = ErrorEvent.Category.ANR;
                            long timestamp = anrExitInfo.getTimestamp();
                            ThreadDump mainThread = this.getMainThread(threadsDump);
                            String stack = mainThread != null ? mainThread.getStack() : null;
                            String str = stack == null ? "" : stack;
                            String canonicalName = ANRException.class.getCanonicalName();
                            final ErrorEvent errorEventResolveErrorEventFromViewEvent = datadogLateCrashReporter.resolveErrorEventFromViewEvent(datadogContext, sourceType, category, ANRDetectorRunnable.ANR_MESSAGE, timestamp, null, str, canonicalName == null ? "" : canonicalName, threadsDump, viewEvent);
                            final DatadogLateCrashReporter datadogLateCrashReporter2 = this;
                            final ApplicationExitInfo applicationExitInfo = anrExitInfo;
                            final DataWriter<Object> dataWriter = rumWriter;
                            final ViewEvent viewEvent2 = viewEvent;
                            writeScope.invoke(new Function1<EventBatchWriter, Unit>() { // from class: com.datadog.android.rum.internal.DatadogLateCrashReporter.handleAnrCrash.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(EventBatchWriter eventBatchWriter) {
                                    invoke2(eventBatchWriter);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(EventBatchWriter it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    datadogLateCrashReporter2.sdkCore.writeLastFatalAnrSent(applicationExitInfo.getTimestamp());
                                    dataWriter.write(it, errorEventResolveErrorEventFromViewEvent, EventType.CRASH);
                                    if (datadogLateCrashReporter2.isWithinSessionAvailability(viewEvent2)) {
                                        dataWriter.write(it, datadogLateCrashReporter2.updateViewEvent(viewEvent2), EventType.CRASH);
                                    }
                                }
                            });
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:54:0x00d2  */
    public final ErrorEvent resolveErrorEventFromViewEvent(DatadogContext datadogContext, ErrorEvent.SourceType sourceType, ErrorEvent.Category category, String errorLogMessage, long timestamp, Long timeSinceAppStartMs, String stacktrace, String errorType, List<ThreadDump> threadDumps, ViewEvent viewEvent) {
        ErrorEvent.Connectivity connectivity;
        LinkedHashMap linkedHashMap;
        LinkedHashMap linkedHashMap2;
        boolean z;
        ErrorEvent.Usr usr;
        String str;
        String anonymousId;
        ArrayList arrayList;
        JsonElement json;
        String asString;
        ArrayList arrayList2;
        ViewEvent.Connectivity connectivity2 = viewEvent.getConnectivity();
        if (connectivity2 != null) {
            ErrorEvent.ConnectivityStatus connectivityStatusValueOf = ErrorEvent.ConnectivityStatus.valueOf(connectivity2.getStatus().name());
            List<ViewEvent.Interface> interfaces = connectivity2.getInterfaces();
            if (interfaces != null) {
                List<ViewEvent.Interface> list = interfaces;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList3.add(ErrorEvent.Interface.valueOf(((ViewEvent.Interface) it.next()).name()));
                }
                arrayList2 = arrayList3;
            } else {
                arrayList2 = null;
            }
            ViewEvent.Cellular cellular = connectivity2.getCellular();
            String technology = cellular != null ? cellular.getTechnology() : null;
            ViewEvent.Cellular cellular2 = connectivity2.getCellular();
            connectivity = new ErrorEvent.Connectivity(connectivityStatusValueOf, arrayList2, null, new ErrorEvent.Cellular(technology, cellular2 != null ? cellular2.getCarrierName() : null), 4, null);
        } else {
            connectivity = null;
        }
        ViewEvent.Context context = viewEvent.getContext();
        if (context == null || (linkedHashMap = context.getAdditionalProperties()) == null) {
            linkedHashMap = new LinkedHashMap();
        }
        ViewEvent.Usr usr2 = viewEvent.getUsr();
        if (usr2 == null || (linkedHashMap2 = usr2.getAdditionalProperties()) == null) {
            linkedHashMap2 = new LinkedHashMap();
        }
        Map<String, Object> map = linkedHashMap2;
        ViewEvent.Usr usr3 = viewEvent.getUsr();
        if ((usr3 != null ? usr3.getId() : null) != null) {
            z = true;
        } else if ((usr3 != null ? usr3.getAnonymousId() : null) != null) {
            z = true;
        } else if ((usr3 != null ? usr3.getName() : null) != null) {
            z = true;
        } else if ((usr3 != null ? usr3.getEmail() : null) == null && map.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        ViewEvent.Account account = viewEvent.getAccount();
        DeviceInfo deviceInfo = datadogContext.getDeviceInfo();
        long serverTimeOffsetMs = timestamp + datadogContext.getTime().getServerTimeOffsetMs();
        String appBuildId = datadogContext.getAppBuildId();
        ErrorEvent.Application application = new ErrorEvent.Application(viewEvent.getApplication().getId(), null, 2, null);
        String service = viewEvent.getService();
        ErrorEvent.ErrorEventSession errorEventSession = new ErrorEvent.ErrorEventSession(viewEvent.getSession().getId(), ErrorEvent.ErrorEventSessionType.USER, null, 4, null);
        ViewEvent.ViewEventSource source = viewEvent.getSource();
        ErrorEvent.ErrorEventSource errorEventSourceTryFromSource = (source == null || (json = source.toJson()) == null || (asString = json.getAsString()) == null) ? null : RumEventExtKt.tryFromSource(ErrorEvent.ErrorEventSource.INSTANCE, asString, this.sdkCore.getInternalLogger());
        ErrorEvent.ErrorEventView errorEventView = new ErrorEvent.ErrorEventView(viewEvent.getView().getId(), viewEvent.getView().getReferrer(), viewEvent.getView().getUrl(), viewEvent.getView().getName(), null, 16, null);
        if (z) {
            String id = usr3 != null ? usr3.getId() : null;
            String name = usr3 != null ? usr3.getName() : null;
            String email = usr3 != null ? usr3.getEmail() : null;
            if (usr3 != null) {
                String str2 = email;
                anonymousId = usr3.getAnonymousId();
                str = str2;
            } else {
                str = email;
                anonymousId = null;
            }
            usr = new ErrorEvent.Usr(id, name, str, anonymousId, map);
        } else {
            usr = null;
            application = application;
        }
        ErrorEvent.Account account2 = account != null ? new ErrorEvent.Account(account.getId(), account.getName(), account.getAdditionalProperties()) : null;
        ErrorEvent.Os os = new ErrorEvent.Os(r16.getOsName(), r16.getOsVersion(), null, r16.getOsMajorVersion(), 4, null);
        ErrorEvent.Device device = new ErrorEvent.Device(RumEventExtKt.toErrorSchemaType(r16.getDeviceType()), r16.getDeviceName(), r16.getDeviceModel(), r16.getDeviceBrand(), r16.getArchitecture(), null, null, null, null, null, null, Integer.valueOf(r16.getLogicalCpuCount()), r16.getTotalRam(), deviceInfo.isLowRam(), 2016, null);
        ErrorEvent.Dd dd = new ErrorEvent.Dd(new ErrorEvent.DdSession(null, null, 3, null), new ErrorEvent.Configuration(Float.valueOf(getSampleRate(viewEvent)), null, null, null, null, 30, null), null, null, null, 28, null);
        ErrorEvent.Context context2 = new ErrorEvent.Context(linkedHashMap);
        String string = UUID.randomUUID().toString();
        ErrorEvent.ErrorSource errorSource = ErrorEvent.ErrorSource.SOURCE;
        if (threadDumps != null) {
            List<ThreadDump> list2 = threadDumps;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (ThreadDump threadDump : list2) {
                arrayList4.add(new ErrorEvent.Thread(threadDump.getName(), threadDump.getCrashed(), threadDump.getStack(), threadDump.getState()));
            }
            arrayList = arrayList4;
        } else {
            arrayList = null;
        }
        ErrorEvent.Error error = new ErrorEvent.Error(string, errorLogMessage, errorSource, stacktrace, null, true, null, errorType, category, null, null, sourceType, null, arrayList, null, null, null, null, timeSinceAppStartMs, 251472, null);
        String version = viewEvent.getVersion();
        ViewEvent.Context featureFlags = viewEvent.getFeatureFlags();
        return new ErrorEvent(serverTimeOffsetMs, application, service, version, null, appBuildId, DdTagsUtils.INSTANCE.toDdTagsString(datadogContext), errorEventSession, errorEventSourceTryFromSource, errorEventView, usr, account2, null, connectivity, null, null, null, os, device, dd, context2, null, null, null, error, null, featureFlags != null ? new ErrorEvent.Context(featureFlags.getAdditionalProperties()) : null, 48353296, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ThreadDump> readThreadsDump(ApplicationExitInfo anrExitInfo) {
        try {
            InputStream traceInputStream = anrExitInfo.getTraceInputStream();
            if (traceInputStream == null) {
                InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.DatadogLateCrashReporter.readThreadsDump.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return DatadogLateCrashReporter.MISSING_ANR_TRACE;
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
                return CollectionsKt.emptyList();
            }
            return this.androidTraceParser.parse$dd_sdk_android_rum_release(traceInputStream);
        } catch (IOException e) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.DatadogLateCrashReporter$readThreadsDump$traceInputStream$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return DatadogLateCrashReporter.OPEN_ANR_TRACE_ERROR;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return CollectionsKt.emptyList();
        } catch (IllegalArgumentException e2) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.DatadogLateCrashReporter$readThreadsDump$traceInputStream$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return DatadogLateCrashReporter.OPEN_ANR_TRACE_ERROR;
                }
            }, (Throwable) e2, false, (Map) null, 48, (Object) null);
            return CollectionsKt.emptyList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewEvent updateViewEvent(ViewEvent lastViewEvent) {
        ViewEvent.Crash crash;
        ViewEvent.Crash crash2 = lastViewEvent.getView().getCrash();
        if (crash2 == null || (crash = crash2.copy(crash2.getCount() + 1)) == null) {
            crash = new ViewEvent.Crash(1L);
        }
        return ViewEvent.copy$default(lastViewEvent, 0L, null, null, null, null, null, null, null, null, ViewEvent.ViewEventView.copy$default(lastViewEvent.getView(), null, null, null, null, null, null, null, null, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, crash, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2013265919, 524287, null), null, null, null, null, null, null, null, null, null, ViewEvent.Dd.copy$default(lastViewEvent.getDd(), null, null, null, null, lastViewEvent.getDd().getDocumentVersion() + 1, null, null, null, null, 495, null), null, null, null, null, null, 33029631, null);
    }

    private final float getSampleRate(ViewEvent viewEvent) {
        Number sessionSampleRate;
        ViewEvent.Configuration configuration = viewEvent.getDd().getConfiguration();
        if (configuration == null || (sessionSampleRate = configuration.getSessionSampleRate()) == null) {
            return 0.0f;
        }
        return sessionSampleRate.floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isWithinSessionAvailability(ViewEvent viewEvent) {
        return this.sdkCore.getTimeProvider().getDeviceTimestampMillis() - viewEvent.getDate() < VIEW_EVENT_AVAILABILITY_TIME_THRESHOLD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ThreadDump getMainThread(List<ThreadDump> list) {
        Object next;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (Intrinsics.areEqual(((ThreadDump) next).getName(), MediaTrack.ROLE_MAIN)) {
                return (ThreadDump) next;
            }
        }
        next = null;
        return (ThreadDump) next;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ErrorEvent.SourceType tryFromSource(ErrorEvent.SourceType.Companion companion, final String str) {
        if (str != null) {
            try {
                return ErrorEvent.SourceType.INSTANCE.fromJson(str);
            } catch (NoSuchElementException e) {
                InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.TELEMETRY, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.DatadogLateCrashReporter.tryFromSource.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Error parsing source type from NDK crash event: " + str;
                    }
                }, (Throwable) e, false, (Map) null, 48, (Object) null);
                return ErrorEvent.SourceType.NDK;
            }
        }
        return ErrorEvent.SourceType.NDK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getRumSessionId(DatadogContext datadogContext) {
        Map<String, Object> mapEmptyMap = datadogContext.getFeaturesContext().get("rum");
        if (mapEmptyMap == null) {
            mapEmptyMap = MapsKt.emptyMap();
        }
        Object obj = mapEmptyMap.get("session_id");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    /* JADX INFO: compiled from: DatadogLateCrashReporter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/datadog/android/rum/internal/DatadogLateCrashReporter$Companion;", "", "()V", "FATAL_ANR_DEDUP_TOLERANCE_MS", "", "INFO_RUM_FEATURE_NOT_REGISTERED", "", "MISSING_ANR_TRACE", "NDK_CRASH_EVENT_MISSING_MANDATORY_FIELDS", "OPEN_ANR_TRACE_ERROR", "VIEW_EVENT_AVAILABILITY_TIME_THRESHOLD", "getVIEW_EVENT_AVAILABILITY_TIME_THRESHOLD$dd_sdk_android_rum_release", "()J", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long getVIEW_EVENT_AVAILABILITY_TIME_THRESHOLD$dd_sdk_android_rum_release() {
            return DatadogLateCrashReporter.VIEW_EVENT_AVAILABILITY_TIME_THRESHOLD;
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.HOURS;
        VIEW_EVENT_AVAILABILITY_TIME_THRESHOLD = 14400000L;
    }
}

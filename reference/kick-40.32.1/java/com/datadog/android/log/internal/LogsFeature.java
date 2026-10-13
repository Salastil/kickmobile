package com.datadog.android.log.internal;

import android.content.Context;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.feature.FeatureEventReceiver;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.feature.StorageBackedFeature;
import com.datadog.android.api.net.RequestFactory;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.api.storage.EventType;
import com.datadog.android.api.storage.FeatureStorageConfiguration;
import com.datadog.android.api.storage.NoOpDataWriter;
import com.datadog.android.event.EventMapper;
import com.datadog.android.event.MapperSerializer;
import com.datadog.android.internal.utils.MapUtilsKt;
import com.datadog.android.log.internal.domain.DatadogLogGenerator;
import com.datadog.android.log.internal.domain.LogGenerator;
import com.datadog.android.log.internal.domain.event.LogEventMapperWrapper;
import com.datadog.android.log.internal.domain.event.LogEventSerializer;
import com.datadog.android.log.internal.net.LogsRequestFactory;
import com.datadog.android.log.internal.storage.LogsDataWriter;
import com.datadog.android.log.model.LogEvent;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LogsFeature.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0001>B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\u001f\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00062\b\u0010.\u001a\u0004\u0018\u00010\rH\u0000¢\u0006\u0002\b/J\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020\t0\u000f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u001b\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\r02H\u0000¢\u0006\u0002\b3J\u0010\u00104\u001a\u00020,2\u0006\u00105\u001a\u000206H\u0016J\u0010\u00107\u001a\u00020,2\u0006\u00108\u001a\u00020\rH\u0017J\b\u00109\u001a\u00020,H\u0016J\u0015\u0010:\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0006H\u0000¢\u0006\u0002\b;J\u0018\u0010<\u001a\u00020,2\u000e\u0010=\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u000302H\u0002R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001c\"\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u00020\"8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020(X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006?"}, d2 = {"Lcom/datadog/android/log/internal/LogsFeature;", "Lcom/datadog/android/api/feature/StorageBackedFeature;", "Lcom/datadog/android/api/feature/FeatureEventReceiver;", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "customEndpointUrl", "", "eventMapper", "Lcom/datadog/android/event/EventMapper;", "Lcom/datadog/android/log/model/LogEvent;", "(Lcom/datadog/android/api/feature/FeatureSdkCore;Ljava/lang/String;Lcom/datadog/android/event/EventMapper;)V", "attributes", "Ljava/util/concurrent/ConcurrentHashMap;", "", "dataWriter", "Lcom/datadog/android/api/storage/DataWriter;", "getDataWriter$dd_sdk_android_logs_release", "()Lcom/datadog/android/api/storage/DataWriter;", "setDataWriter$dd_sdk_android_logs_release", "(Lcom/datadog/android/api/storage/DataWriter;)V", "getEventMapper$dd_sdk_android_logs_release", "()Lcom/datadog/android/event/EventMapper;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "logGenerator", "Lcom/datadog/android/log/internal/domain/DatadogLogGenerator;", "name", "getName", "()Ljava/lang/String;", "packageName", "getPackageName$dd_sdk_android_logs_release", "setPackageName$dd_sdk_android_logs_release", "(Ljava/lang/String;)V", "requestFactory", "Lcom/datadog/android/api/net/RequestFactory;", "getRequestFactory", "()Lcom/datadog/android/api/net/RequestFactory;", "requestFactory$delegate", "Lkotlin/Lazy;", "storageConfiguration", "Lcom/datadog/android/api/storage/FeatureStorageConfiguration;", "getStorageConfiguration", "()Lcom/datadog/android/api/storage/FeatureStorageConfiguration;", "addAttribute", "", "key", "value", "addAttribute$dd_sdk_android_logs_release", "createDataWriter", "getAttributes", "", "getAttributes$dd_sdk_android_logs_release", "onInitialize", "appContext", "Landroid/content/Context;", "onReceive", "event", "onStop", "removeAttribute", "removeAttribute$dd_sdk_android_logs_release", "sendSpanLog", "data", "Companion", "dd-sdk-android-logs_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LogsFeature implements StorageBackedFeature, FeatureEventReceiver {
    private static final String ATTRIBUTES_EVENT_KEY = "attributes";
    private static final String LOGGER_NAME_EVENT_KEY = "loggerName";
    private static final String LOG_STATUS_EVENT_KEY = "logStatus";
    private static final String MESSAGE_EVENT_KEY = "message";
    public static final String SPAN_LOG_EVENT_MISSING_MANDATORY_FIELDS_WARNING = "Logs feature received a Span log event where one or more mandatory (loggerName, message, timestamp, attributes) fields are either missing or have wrong type.";
    private static final String TIMESTAMP_EVENT_KEY = "timestamp";
    private static final String TYPE_EVENT_KEY = "type";
    public static final String UNKNOWN_EVENT_TYPE_PROPERTY_VALUE = "Logs feature received an event with unknown value of \"type\" property=%s.";
    public static final String UNSUPPORTED_EVENT_TYPE = "Logs feature receive an event of unsupported type=%s.";
    private final ConcurrentHashMap<String, Object> attributes;
    private DataWriter<LogEvent> dataWriter;
    private final EventMapper<LogEvent> eventMapper;
    private final AtomicBoolean initialized;
    private final DatadogLogGenerator logGenerator;
    private final String name;
    private String packageName;

    /* JADX INFO: renamed from: requestFactory$delegate, reason: from kotlin metadata */
    private final Lazy requestFactory;
    private final FeatureSdkCore sdkCore;
    private final FeatureStorageConfiguration storageConfiguration;

    /* JADX WARN: Multi-variable type inference failed */
    public LogsFeature(FeatureSdkCore sdkCore, final String str, EventMapper<LogEvent> eventMapper) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(eventMapper, "eventMapper");
        this.sdkCore = sdkCore;
        this.eventMapper = eventMapper;
        this.dataWriter = new NoOpDataWriter();
        this.initialized = new AtomicBoolean(false);
        this.packageName = "";
        this.logGenerator = new DatadogLogGenerator(null, sdkCore.getInternalLogger(), 1, 0 == true ? 1 : 0);
        this.attributes = new ConcurrentHashMap<>();
        this.name = "logs";
        this.requestFactory = LazyKt.lazy(new Function0<LogsRequestFactory>() { // from class: com.datadog.android.log.internal.LogsFeature$requestFactory$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LogsRequestFactory invoke() {
                return new LogsRequestFactory(str, this.sdkCore.getInternalLogger());
            }
        });
        this.storageConfiguration = FeatureStorageConfiguration.INSTANCE.getDEFAULT();
    }

    public final EventMapper<LogEvent> getEventMapper$dd_sdk_android_logs_release() {
        return this.eventMapper;
    }

    public final DataWriter<LogEvent> getDataWriter$dd_sdk_android_logs_release() {
        return this.dataWriter;
    }

    public final void setDataWriter$dd_sdk_android_logs_release(DataWriter<LogEvent> dataWriter) {
        Intrinsics.checkNotNullParameter(dataWriter, "<set-?>");
        this.dataWriter = dataWriter;
    }

    /* JADX INFO: renamed from: getPackageName$dd_sdk_android_logs_release, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    public final void setPackageName$dd_sdk_android_logs_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.packageName = str;
    }

    public final void addAttribute$dd_sdk_android_logs_release(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        ConcurrentHashMap<String, Object> concurrentHashMap = this.attributes;
        if (value == null) {
            concurrentHashMap.put(key, MapUtilsKt.getNULL_MAP_VALUE());
        } else {
            concurrentHashMap.put(key, value);
        }
    }

    public final void removeAttribute$dd_sdk_android_logs_release(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.attributes.remove(key);
    }

    public final Map<String, Object> getAttributes$dd_sdk_android_logs_release() {
        return MapsKt.toMap(this.attributes);
    }

    @Override // com.datadog.android.api.feature.Feature
    public String getName() {
        return this.name;
    }

    @Override // com.datadog.android.api.feature.Feature
    public void onInitialize(Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.sdkCore.setEventReceiver(getName(), this);
        String packageName = appContext.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "appContext.packageName");
        this.packageName = packageName;
        this.dataWriter = createDataWriter(this.eventMapper);
        this.initialized.set(true);
    }

    @Override // com.datadog.android.api.feature.StorageBackedFeature
    public RequestFactory getRequestFactory() {
        return (RequestFactory) this.requestFactory.getValue();
    }

    @Override // com.datadog.android.api.feature.StorageBackedFeature
    public FeatureStorageConfiguration getStorageConfiguration() {
        return this.storageConfiguration;
    }

    @Override // com.datadog.android.api.feature.Feature
    public void onStop() {
        this.sdkCore.removeEventReceiver(getName());
        this.dataWriter = new NoOpDataWriter();
        this.packageName = "";
        this.initialized.set(false);
        this.attributes.clear();
    }

    @Override // com.datadog.android.api.feature.FeatureEventReceiver
    public void onReceive(final Object event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!(event instanceof Map)) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.log.internal.LogsFeature.onReceive.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, LogsFeature.UNSUPPORTED_EVENT_TYPE, Arrays.copyOf(new Object[]{event.getClass().getCanonicalName()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return;
        }
        Map<?, ?> map = (Map) event;
        if (Intrinsics.areEqual(map.get("type"), "span_log")) {
            sendSpanLog(map);
        } else {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.log.internal.LogsFeature.onReceive.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, LogsFeature.UNKNOWN_EVENT_TYPE_PROPERTY_VALUE, Arrays.copyOf(new Object[]{((Map) event).get("type")}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final DataWriter<LogEvent> createDataWriter(EventMapper<LogEvent> eventMapper) {
        return new LogsDataWriter(new MapperSerializer(new LogEventMapperWrapper(eventMapper, this.sdkCore.getInternalLogger()), new LogEventSerializer(this.sdkCore.getInternalLogger(), null, 2, 0 == true ? 1 : 0)), this.sdkCore.getInternalLogger());
    }

    private final void sendSpanLog(Map<?, ?> data) {
        final LinkedHashMap linkedHashMap;
        Object obj = data.get("timestamp");
        final Long l = obj instanceof Long ? (Long) obj : null;
        Object obj2 = data.get("message");
        final String str = obj2 instanceof String ? (String) obj2 : null;
        Object obj3 = data.get(LOGGER_NAME_EVENT_KEY);
        final String str2 = obj3 instanceof String ? (String) obj3 : null;
        Object obj4 = data.get("attributes");
        Map map = obj4 instanceof Map ? (Map) obj4 : null;
        if (map != null) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                if (entry.getKey() instanceof String) {
                    linkedHashMap2.put(entry.getKey(), entry.getValue());
                }
            }
            LinkedHashMap linkedHashMap3 = linkedHashMap2;
            LinkedHashMap linkedHashMap4 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap3.size()));
            for (Map.Entry entry2 : linkedHashMap3.entrySet()) {
                Object key = entry2.getKey();
                Intrinsics.checkNotNull(key, "null cannot be cast to non-null type kotlin.String");
                linkedHashMap4.put((String) key, entry2.getValue());
            }
            linkedHashMap = linkedHashMap4;
        } else {
            linkedHashMap = null;
        }
        Object obj5 = data.get(LOG_STATUS_EVENT_KEY);
        Integer num = obj5 instanceof Integer ? (Integer) obj5 : null;
        final int iIntValue = num != null ? num.intValue() : 2;
        if (str2 == null || str == null || linkedHashMap == null || l == null) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.log.internal.LogsFeature.sendSpanLog.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return LogsFeature.SPAN_LOG_EVENT_MISSING_MANDATORY_FIELDS_WARNING;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return;
        }
        FeatureScope feature = this.sdkCore.getFeature(getName());
        if (feature != null) {
            feature.withWriteContext(SetsKt.setOf("rum"), new Function2<DatadogContext, Function1<? super Function1<? super EventBatchWriter, ? extends Unit>, ? extends Unit>, Unit>() { // from class: com.datadog.android.log.internal.LogsFeature.sendSpanLog.2
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
                    DatadogLogGenerator datadogLogGenerator = LogsFeature.this.logGenerator;
                    String name = Thread.currentThread().getName();
                    Set setEmptySet = SetsKt.emptySet();
                    int i = iIntValue;
                    String str3 = str;
                    Map<String, Object> map2 = linkedHashMap;
                    long jLongValue = l.longValue();
                    Intrinsics.checkNotNullExpressionValue(name, "name");
                    final LogEvent logEventGenerateLog$default = LogGenerator.DefaultImpls.generateLog$default(datadogLogGenerator, i, str3, null, map2, setEmptySet, jLongValue, name, datadogContext, true, str2, false, true, null, null, null, null, 61440, null);
                    final LogsFeature logsFeature = LogsFeature.this;
                    writeScope.invoke(new Function1<EventBatchWriter, Unit>() { // from class: com.datadog.android.log.internal.LogsFeature.sendSpanLog.2.1
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
                            logsFeature.getDataWriter$dd_sdk_android_logs_release().write(it, logEventGenerateLog$default, EventType.DEFAULT);
                        }
                    });
                }
            });
        }
    }
}

package io.datazoom.sdk.domain;

import com.datadog.android.rum.internal.domain.scope.RumSessionScope;
import com.facebook.hermes.intl.Constants;
import com.facebook.imageutils.JfifUtil;
import io.datazoom.sdk.data.memory.ConfigId;
import io.datazoom.sdk.data.memory.ConfigStore;
import io.datazoom.sdk.data.memory.ConfigStoreExtensionsKt;
import io.datazoom.sdk.data.memory.FlagsPersistence;
import io.datazoom.sdk.data.memory.FluxDataStore;
import io.datazoom.sdk.data.memory.MetaDataStore;
import io.datazoom.sdk.data.memory.MetaDataStoreExtensionsKt;
import io.datazoom.sdk.logs.Logger;
import io.datazoom.sdk.logs.Logger_androidKt;
import io.datazoom.sdk.model.AppConfig;
import io.datazoom.sdk.model.Event;
import io.datazoom.sdk.model.EventKt;
import io.datazoom.sdk.model.FluxData;
import io.datazoom.sdk.model.MetaData;
import io.datazoom.sdk.model.PendingFlag;
import io.datazoom.sdk.network.Resource;
import io.datazoom.sdk.network.events.SendEventUseCase;
import io.datazoom.sdk.network.events.model.EventDto;
import io.datazoom.sdk.threading.ThreadingScope;
import io.datazoom.sdk.utils.SafeList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: EventManager.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019J\u001a\u0010\u001f\u001a\u00020\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019J\u000e\u0010 \u001a\u00020\u001dH\u0086@¢\u0006\u0002\u0010!J\u000e\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020\u001aH\u0002J\u0012\u0010)\u001a\u0004\u0018\u00010\u00102\u0006\u0010*\u001a\u00020\u0010H\u0002J\u000e\u0010+\u001a\u00020\u001dH\u0082@¢\u0006\u0002\u0010!J\u000e\u0010,\u001a\u00020\u001dH\u0082@¢\u0006\u0002\u0010!J\u001c\u0010-\u001a\u00020\u001d2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0082@¢\u0006\u0002\u0010/J\u000e\u00100\u001a\u00020\u001dH\u0086@¢\u0006\u0002\u0010!J\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u001002J\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u00104\u001a\u000205X\u0096\u0005¢\u0006\u0006\u001a\u0004\b6\u00107R\u0012\u00108\u001a\u000209X\u0096\u0005¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0018\u0010<\u001a\b\u0012\u0004\u0012\u00020>0=X\u0096\u0005¢\u0006\u0006\u001a\u0004\b?\u0010@¨\u0006A"}, d2 = {"Lio/datazoom/sdk/domain/EventManager;", "Lio/datazoom/sdk/threading/ThreadingScope;", "flagManager", "Lio/datazoom/sdk/data/memory/FlagsPersistence;", "eventSenderUseCase", "Lio/datazoom/sdk/network/events/SendEventUseCase;", "metadataStore", "Lio/datazoom/sdk/data/memory/MetaDataStore;", "fluxDataStore", "Lio/datazoom/sdk/data/memory/FluxDataStore;", "configStore", "Lio/datazoom/sdk/data/memory/ConfigStore;", "sessionManager", "Lio/datazoom/sdk/domain/SessionManager;", "messageQueue", "Lio/datazoom/sdk/utils/SafeList;", "Lio/datazoom/sdk/network/events/model/EventDto;", "pendingMessageQueue", "threading", "<init>", "(Lio/datazoom/sdk/data/memory/FlagsPersistence;Lio/datazoom/sdk/network/events/SendEventUseCase;Lio/datazoom/sdk/data/memory/MetaDataStore;Lio/datazoom/sdk/data/memory/FluxDataStore;Lio/datazoom/sdk/data/memory/ConfigStore;Lio/datazoom/sdk/domain/SessionManager;Lio/datazoom/sdk/utils/SafeList;Lio/datazoom/sdk/utils/SafeList;Lio/datazoom/sdk/threading/ThreadingScope;)V", "dispatchLock", "Lkotlinx/coroutines/sync/Mutex;", "_customMetadata", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "", "", "setGlobalCustomMetadata", "", "metadata", "removeGlobalCustomMetadata", "configArrived", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addAndDispatch", "message", "Lio/datazoom/sdk/model/Event;", "templatedId", "count", "", RumSessionScope.RUM_SESSION_ID_BUS_MESSAGE_KEY, "addMetaDataIfAllowed", "eventDto", "processQueues", "validatePendingQueue", "dispatchEvents", "eventsList", "(Lio/datazoom/sdk/utils/SafeList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clear", "getMessageQueue", "", "getPendingQueue", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "errorsState", "Lkotlinx/coroutines/flow/SharedFlow;", "", "getErrorsState", "()Lkotlinx/coroutines/flow/SharedFlow;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class EventManager implements ThreadingScope {
    private final /* synthetic */ ThreadingScope $$delegate_0;
    private final MutableStateFlow<Map<String, Object>> _customMetadata;
    private final ConfigStore configStore;
    private final Mutex dispatchLock;
    private final SendEventUseCase eventSenderUseCase;
    private final FlagsPersistence flagManager;
    private final FluxDataStore fluxDataStore;
    private final SafeList<EventDto> messageQueue;
    private final MetaDataStore metadataStore;
    private final SafeList<EventDto> pendingMessageQueue;
    private final SessionManager sessionManager;

    /* JADX INFO: renamed from: io.datazoom.sdk.domain.EventManager$clear$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EventManager.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.datazoom.sdk.domain.EventManager", f = "EventManager.kt", i = {0, 0}, l = {253}, m = "clear", n = {"$this$withLock_u24default$iv", "$i$f$withLock"}, nl = {254}, s = {"L$0", "I$0"}, v = 2)
    static final class C09461 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C09461(Continuation<? super C09461> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EventManager.this.clear(this);
        }
    }

    /* JADX INFO: renamed from: io.datazoom.sdk.domain.EventManager$dispatchEvents$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EventManager.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.datazoom.sdk.domain.EventManager", f = "EventManager.kt", i = {0, 0, 0}, l = {JfifUtil.MARKER_SOS}, m = "dispatchEvents", n = {"eventsList", "drainedEvents", "allowedEvents"}, nl = {225}, s = {"L$0", "L$1", "L$2"}, v = 2)
    static final class C09471 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C09471(Continuation<? super C09471> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EventManager.this.dispatchEvents(null, this);
        }
    }

    /* JADX INFO: renamed from: io.datazoom.sdk.domain.EventManager$processQueues$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EventManager.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.datazoom.sdk.domain.EventManager", f = "EventManager.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {253, 168, 169}, m = "processQueues", n = {"$this$withLock_u24default$iv", "$i$f$withLock", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-EventManager$processQueues$2", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-EventManager$processQueues$2"}, nl = {254, 169, 170}, s = {"L$0", "I$0", "L$0", "I$0", "I$1", "L$0", "I$0", "I$1"}, v = 2)
    static final class C09481 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C09481(Continuation<? super C09481> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EventManager.this.processQueues(this);
        }
    }

    @Override // io.datazoom.sdk.threading.ThreadingScope
    public CoroutineScope getCoroutineScope() {
        return this.$$delegate_0.getCoroutineScope();
    }

    @Override // io.datazoom.sdk.threading.ThreadingScope
    public CoroutineDispatcher getDispatcher() {
        return this.$$delegate_0.getDispatcher();
    }

    @Override // io.datazoom.sdk.threading.ThreadingScope
    public SharedFlow<Throwable> getErrorsState() {
        return this.$$delegate_0.getErrorsState();
    }

    public EventManager(FlagsPersistence flagManager, SendEventUseCase eventSenderUseCase, MetaDataStore metadataStore, FluxDataStore fluxDataStore, ConfigStore configStore, SessionManager sessionManager, SafeList<EventDto> messageQueue, SafeList<EventDto> pendingMessageQueue, ThreadingScope threading) {
        Intrinsics.checkNotNullParameter(flagManager, "flagManager");
        Intrinsics.checkNotNullParameter(eventSenderUseCase, "eventSenderUseCase");
        Intrinsics.checkNotNullParameter(metadataStore, "metadataStore");
        Intrinsics.checkNotNullParameter(fluxDataStore, "fluxDataStore");
        Intrinsics.checkNotNullParameter(configStore, "configStore");
        Intrinsics.checkNotNullParameter(sessionManager, "sessionManager");
        Intrinsics.checkNotNullParameter(messageQueue, "messageQueue");
        Intrinsics.checkNotNullParameter(pendingMessageQueue, "pendingMessageQueue");
        Intrinsics.checkNotNullParameter(threading, "threading");
        this.$$delegate_0 = threading;
        this.flagManager = flagManager;
        this.eventSenderUseCase = eventSenderUseCase;
        this.metadataStore = metadataStore;
        this.fluxDataStore = fluxDataStore;
        this.configStore = configStore;
        this.sessionManager = sessionManager;
        this.messageQueue = messageQueue;
        this.pendingMessageQueue = pendingMessageQueue;
        this.dispatchLock = MutexKt.Mutex$default(false, 1, null);
        this._customMetadata = StateFlowKt.MutableStateFlow(MapsKt.emptyMap());
    }

    public /* synthetic */ EventManager(FlagsPersistence flagsPersistence, SendEventUseCase sendEventUseCase, MetaDataStore metaDataStore, FluxDataStore fluxDataStore, ConfigStore configStore, SessionManager sessionManager, SafeList safeList, SafeList safeList2, ThreadingScope threadingScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(flagsPersistence, sendEventUseCase, metaDataStore, fluxDataStore, configStore, sessionManager, (i & 64) != 0 ? new SafeList() : safeList, (i & 128) != 0 ? new SafeList() : safeList2, threadingScope);
    }

    public final void setGlobalCustomMetadata(Map<String, ? extends Object> metadata) {
        Map<String, Object> value;
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        MutableStateFlow<Map<String, Object>> mutableStateFlow = this._customMetadata;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, MapsKt.plus(value, metadata)));
    }

    public final void removeGlobalCustomMetadata(Map<String, ? extends Object> metadata) {
        Map<String, Object> value;
        Map<String, Object> mutableMap;
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        MutableStateFlow<Map<String, Object>> mutableStateFlow = this._customMetadata;
        do {
            value = mutableStateFlow.getValue();
            mutableMap = MapsKt.toMutableMap(value);
            Iterator<T> it = metadata.keySet().iterator();
            while (it.hasNext()) {
                mutableMap.remove((String) it.next());
            }
        } while (!mutableStateFlow.compareAndSet(value, mutableMap));
    }

    public final Object configArrived(Continuation<? super Unit> continuation) throws Throwable {
        Object objProcessQueues = processQueues(continuation);
        return objProcessQueues == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objProcessQueues : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: io.datazoom.sdk.domain.EventManager$addAndDispatch$1, reason: invalid class name */
    /* JADX INFO: compiled from: EventManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.datazoom.sdk.domain.EventManager$addAndDispatch$1", f = "EventManager.kt", i = {0, 0}, l = {97}, m = "invokeSuspend", n = {"id", "count"}, nl = {98}, s = {"L$0", "I$0"}, v = 2)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Event $message;
        int I$0;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Event event, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$message = event;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EventManager.this.new AnonymousClass1(this.$message, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                int iIncrementAndGet = EventManager.this.fluxDataStore.incrementAndGet(FluxData.Type.EVENT_COUNT);
                String strTemplatedId = EventManager.this.templatedId(iIncrementAndGet);
                boolean zIsFlagApplied = EventManager.this.flagManager.isFlagApplied(PendingFlag.CONFIG.INSTANCE);
                EventManager eventManager = EventManager.this;
                if (zIsFlagApplied) {
                    eventManager.pendingMessageQueue.add(EventKt.toEventDto(this.$message, strTemplatedId, iIncrementAndGet));
                    Logger_androidKt.getLogger().e("Event: " + this.$message.getType() + " added to pending queue as config is not available");
                } else {
                    eventManager.messageQueue.add(EventKt.toEventDto(this.$message, strTemplatedId, iIncrementAndGet));
                    Logger_androidKt.getLogger().d("Event: " + this.$message.getType() + " added to message queue");
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(strTemplatedId);
                this.I$0 = iIncrementAndGet;
                this.label = 1;
                if (EventManager.this.processQueues(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void addAndDispatch(Event message) {
        Intrinsics.checkNotNullParameter(message, "message");
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), getDispatcher(), null, new AnonymousClass1(message, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String templatedId(int count) {
        return "{event_session_id}" + StringsKt.padStart(String.valueOf(count), 5, '0');
    }

    private final String sessionId() {
        return this.sessionManager.currentSession().getId() + "_00.";
    }

    private final EventDto addMetaDataIfAllowed(EventDto eventDto) {
        HashMap map;
        Object second;
        Pair entryPair$default = MetaDataStoreExtensionsKt.getEntryPair$default(eventDto.getVideo(), MetaData.Type.MEDIA_TYPE, false, 2, null);
        String string = (entryPair$default == null || (second = entryPair$default.getSecond()) == null) ? null : second.toString();
        AppConfig appConfig = this.configStore.get(ConfigId.Main.INSTANCE);
        if (appConfig == null) {
            return null;
        }
        HashMap<String, Object> userDetails = eventDto.getUserDetails();
        if (userDetails == null) {
            userDetails = new HashMap<>();
        }
        HashMap map2 = new HashMap(userDetails);
        SessionManager.currentSessionForEvent$default(this.sessionManager, appConfig.getAppSessionInactivityMs(), 0L, 2, null);
        for (Map.Entry<String, Object> entry : MetaDataStoreExtensionsKt.user(this.metadataStore, this.sessionManager).entrySet()) {
            map2.put(entry.getKey(), entry.getValue());
        }
        if (appConfig.isMetadataEnabled(MetaData.Type.CUSTOM_METADATA_ALL.getValue())) {
            map = new HashMap(eventDto.getCustom());
            map.putAll(this._customMetadata.getValue());
        } else {
            map = new HashMap();
        }
        HashMap map3 = map;
        if (StringsKt.startsWith$default(eventDto.getEvent().getType(), "custom_", false, 2, (Object) null)) {
            if (!appConfig.isMetadataEnabled(MetaData.Type.CUSTOM_EVENTS_ALL.getValue())) {
                return null;
            }
        } else if (!appConfig.isEventEnabled(eventDto.getEvent().getType(), string)) {
            return null;
        }
        String eventId = eventDto.getEventId();
        String strReplace$default = eventId != null ? StringsKt.replace$default(eventId, "{event_session_id}", sessionId(), false, 4, (Object) null) : null;
        EventDto.Event eventCopy$default = EventDto.Event.copy$default(eventDto.getEvent(), null, 0L, ConfigStoreExtensionsKt.allowedFD(appConfig, new HashMap(eventDto.getEvent().getFluxData())), ConfigStoreExtensionsKt.allowedMD(appConfig, new HashMap(eventDto.getEvent().getMetaData())), 3, null);
        HashMap mapAllowedMD = ConfigStoreExtensionsKt.allowedMD(appConfig, map2);
        HashMap map4 = !mapAllowedMD.isEmpty() ? mapAllowedMD : null;
        HashMap<String, Object> device = eventDto.getDevice();
        if (device == null) {
            device = MetaDataStoreExtensionsKt.device(this.metadataStore);
        }
        HashMap mapAllowedMD2 = ConfigStoreExtensionsKt.allowedMD(appConfig, new HashMap(device));
        HashMap map5 = !mapAllowedMD2.isEmpty() ? mapAllowedMD2 : null;
        HashMap mapAllowedMD3 = ConfigStoreExtensionsKt.allowedMD(appConfig, MetaDataStoreExtensionsKt.geo(this.metadataStore));
        HashMap mapAllowedMD4 = ConfigStoreExtensionsKt.allowedMD(appConfig, MetaDataStoreExtensionsKt.network(this.metadataStore));
        HashMap mapAllowedMD5 = ConfigStoreExtensionsKt.allowedMD(appConfig, new HashMap(eventDto.getVideo()));
        HashMap mapAllowedMD6 = ConfigStoreExtensionsKt.allowedMD(appConfig, new HashMap(eventDto.getAd()));
        HashMap mapAllowedMD7 = ConfigStoreExtensionsKt.allowedMD(appConfig, MetaDataStoreExtensionsKt.page(this.metadataStore));
        HashMap mapAllowedMD8 = ConfigStoreExtensionsKt.allowedMD(appConfig, new HashMap(eventDto.getPlayer()));
        String customerCode = appConfig.getCustomerCode();
        String str = customerCode == null ? "" : customerCode;
        String configurationId = appConfig.getConfigurationId();
        String str2 = configurationId == null ? "" : configurationId;
        String connectorList = appConfig.getConnectorList();
        return EventDto.copy$default(eventDto, str, str2, strReplace$default, connectorList == null ? "" : connectorList, eventCopy$default, map4, map5, mapAllowedMD3, mapAllowedMD4, mapAllowedMD5, mapAllowedMD6, mapAllowedMD7, null, null, mapAllowedMD8, map3, null, 77824, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:36:0x0093  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object processQueues(Continuation<? super Unit> continuation) throws Throwable {
        C09481 c09481;
        Mutex mutex;
        int i;
        Throwable th;
        Mutex mutex2;
        SafeList<EventDto> safeList;
        if (continuation instanceof C09481) {
            c09481 = (C09481) continuation;
            if ((c09481.label & Integer.MIN_VALUE) != 0) {
                c09481.label -= Integer.MIN_VALUE;
            } else {
                c09481 = new C09481(continuation);
            }
        } else {
            c09481 = new C09481(continuation);
        }
        Object obj = c09481.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c09481.label;
        int i3 = 0;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.dispatchLock;
                c09481.L$0 = mutex;
                c09481.I$0 = 0;
                c09481.label = 1;
                if (mutex.lock(null, c09481) != coroutine_suspended) {
                    i = 0;
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i4 = c09481.I$1;
                    int i5 = c09481.I$0;
                    mutex2 = (Mutex) c09481.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        Unit unit = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                        mutex2.unlock(null);
                        throw th;
                    }
                }
                i3 = c09481.I$1;
                i = c09481.I$0;
                Mutex mutex3 = (Mutex) c09481.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    mutex = mutex3;
                    safeList = this.messageQueue;
                    c09481.L$0 = mutex;
                    c09481.I$0 = i;
                    c09481.I$1 = i3;
                    c09481.label = 3;
                    if (dispatchEvents(safeList, c09481) != coroutine_suspended) {
                        mutex2 = mutex;
                        Unit unit2 = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return Unit.INSTANCE;
                    }
                    return coroutine_suspended;
                } catch (Throwable th3) {
                    th = th3;
                    mutex2 = mutex3;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            i = c09481.I$0;
            Mutex mutex4 = (Mutex) c09481.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex4;
            c09481.L$0 = mutex;
            c09481.I$0 = i;
            c09481.I$1 = 0;
            c09481.label = 2;
            if (validatePendingQueue(c09481) != coroutine_suspended) {
                safeList = this.messageQueue;
                c09481.L$0 = mutex;
                c09481.I$0 = i;
                c09481.I$1 = i3;
                c09481.label = 3;
                if (dispatchEvents(safeList, c09481) != coroutine_suspended) {
                    mutex2 = mutex;
                    Unit unit3 = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                }
            }
            return coroutine_suspended;
        } catch (Throwable th4) {
            Mutex mutex5 = mutex;
            th = th4;
            mutex2 = mutex5;
            mutex2.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object validatePendingQueue(Continuation<? super Unit> continuation) {
        if (this.flagManager.flagApplied()) {
            return Unit.INSTANCE;
        }
        List<EventDto> listPooledList = this.pendingMessageQueue.pooledList();
        if (listPooledList.isEmpty()) {
            return Unit.INSTANCE;
        }
        this.messageQueue.addAll(listPooledList);
        Logger_androidKt.getLogger().d("Pending queue merged into message queue, total events");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object dispatchEvents(SafeList<EventDto> safeList, Continuation<? super Unit> continuation) {
        C09471 c09471;
        int i;
        boolean z;
        Object second;
        if (continuation instanceof C09471) {
            c09471 = (C09471) continuation;
            if ((c09471.label & Integer.MIN_VALUE) != 0) {
                c09471.label -= Integer.MIN_VALUE;
            } else {
                c09471 = new C09471(continuation);
            }
        } else {
            c09471 = new C09471(continuation);
        }
        Object objInvoke = c09471.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c09471.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objInvoke);
                if (this.flagManager.isFlagApplied(PendingFlag.CONFIG.INSTANCE)) {
                    return Unit.INSTANCE;
                }
                List<EventDto> listPooledList = safeList.pooledList();
                if (listPooledList.isEmpty()) {
                    return Unit.INSTANCE;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = listPooledList.iterator();
                while (true) {
                    i = 2;
                    z = false;
                    if (!it.hasNext()) {
                        break;
                    }
                    EventDto eventDto = (EventDto) it.next();
                    EventDto eventDtoAddMetaDataIfAllowed = addMetaDataIfAllowed(eventDto);
                    if (eventDtoAddMetaDataIfAllowed != null) {
                        Boxing.boxBoolean(arrayList.add(eventDtoAddMetaDataIfAllowed));
                    } else {
                        EventManager eventManager = this;
                        Logger logger = Logger_androidKt.getLogger();
                        String type = eventDto.getEvent().getType();
                        Pair entryPair$default = MetaDataStoreExtensionsKt.getEntryPair$default(eventDto.getVideo(), MetaData.Type.MEDIA_TYPE, false, 2, null);
                        logger.v("Event: Disabled " + type + ", mediaType: " + (entryPair$default != null ? entryPair$default.getSecond() : null));
                    }
                }
                if (arrayList.isEmpty()) {
                    return Unit.INSTANCE;
                }
                SendEventUseCase sendEventUseCase = this.eventSenderUseCase;
                ArrayList<EventDto> arrayList2 = arrayList;
                for (EventDto eventDto2 : arrayList2) {
                    Object obj = eventDto2.getEvent().getFluxData().get("event_count");
                    String string = obj != null ? obj.toString() : null;
                    String str = "";
                    if (string == null) {
                        string = "";
                    }
                    Pair entryPair$default2 = MetaDataStoreExtensionsKt.getEntryPair$default(eventDto2.getVideo(), MetaData.Type.MEDIA_TYPE, z, i, null);
                    String str2 = (entryPair$default2 == null || (second = entryPair$default2.getSecond()) == null) ? null : "-" + second;
                    Logger logger2 = Logger_androidKt.getLogger();
                    String type2 = eventDto2.getEvent().getType();
                    if (str2 != null) {
                        str = str2;
                    }
                    logger2.v("Event >> [" + string + "] " + type2 + str + " :: " + eventDto2.getEventId());
                    i = 2;
                    z = false;
                }
                c09471.L$0 = SpillingKt.nullOutSpilledVariable(safeList);
                c09471.L$1 = SpillingKt.nullOutSpilledVariable(listPooledList);
                c09471.L$2 = SpillingKt.nullOutSpilledVariable(arrayList);
                c09471.label = 1;
                objInvoke = sendEventUseCase.invoke(arrayList2, c09471);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objInvoke);
            }
            Resource resource = (Resource) objInvoke;
            if (!resource.isSuccess()) {
                Logger_androidKt.getLogger().v("Error while sending events: " + resource.getError());
            }
        } catch (Exception e) {
            Logger_androidKt.getLogger().v("Error while sending events: " + e.getMessage());
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object clear(Continuation<? super Unit> continuation) {
        C09461 c09461;
        Mutex mutex;
        if (continuation instanceof C09461) {
            c09461 = (C09461) continuation;
            if ((c09461.label & Integer.MIN_VALUE) != 0) {
                c09461.label -= Integer.MIN_VALUE;
            } else {
                c09461 = new C09461(continuation);
            }
        } else {
            c09461 = new C09461(continuation);
        }
        Object obj = c09461.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09461.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex mutex2 = this.dispatchLock;
            c09461.L$0 = mutex2;
            c09461.I$0 = 0;
            c09461.label = 1;
            if (mutex2.lock(null, c09461) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex = mutex2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c09461.I$0;
            mutex = (Mutex) c09461.L$0;
            ResultKt.throwOnFailure(obj);
        }
        try {
            this.messageQueue.clear();
            this.pendingMessageQueue.clear();
            Unit unit = Unit.INSTANCE;
            return Unit.INSTANCE;
        } finally {
            mutex.unlock(null);
        }
    }

    public final List<EventDto> getMessageQueue() {
        return CollectionsKt.toMutableList((Collection) this.messageQueue.getItems());
    }

    public final List<EventDto> getPendingQueue() {
        return CollectionsKt.toMutableList((Collection) this.pendingMessageQueue.getItems());
    }
}

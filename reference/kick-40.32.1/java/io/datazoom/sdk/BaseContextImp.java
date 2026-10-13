package io.datazoom.sdk;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.custom.CustomMetadata;
import io.datazoom.sdk.custom.CustomMetadataImp;
import io.datazoom.sdk.data.memory.FluxDataStore;
import io.datazoom.sdk.data.memory.MetaDataStore;
import io.datazoom.sdk.di.ExtensionsKt;
import io.datazoom.sdk.domain.EventManager;
import io.datazoom.sdk.domain.TakeCareJob;
import io.datazoom.sdk.domain.TakeCareJobImp;
import io.datazoom.sdk.domain.TimeStampsStore;
import io.datazoom.sdk.domain.TimeStampsStoreKt;
import io.datazoom.sdk.domain.TimerState;
import io.datazoom.sdk.model.Event;
import io.datazoom.sdk.model.EventKt;
import io.datazoom.sdk.model.MetaData;
import io.datazoom.sdk.model.OpsMetaData;
import io.datazoom.sdk.stateMachine.StateMachine;
import io.datazoom.sdk.stateMachine.StateMachineImp;
import io.datazoom.sdk.threading.ThreadingScope;
import io.datazoom.sdk.utils.IdentityGen;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.SharedFlow;
import org.koin.core.Koin;
import org.koin.core.qualifier.QualifierKt;
import org.koin.core.qualifier.StringQualifier;
import org.koin.mp.KoinPlatformTools;

/* JADX INFO: compiled from: BaseContext.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010I\u001a\u00020JH\u0016J\u0015\u0010K\u001a\u00020J2\u0006\u0010L\u001a\u00020MH\u0000¢\u0006\u0002\bNJ\u000e\u0010O\u001a\u00020J2\u0006\u0010P\u001a\u00020QJ\u001c\u0010R\u001a\u00020J2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020T0SH\u0016J\u0014\u0010;\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020T0SH\u0016J\b\u0010U\u001a\u00020JH\u0016J$\u0010V\u001a\u00020J2\u0006\u0010W\u001a\u00020E2\u0012\u0010X\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020T0SH\u0016J\u000e\u0010Y\u001a\u00020Q2\u0006\u0010L\u001a\u00020ZR\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\t\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\t\u001a\u0004\b%\u0010&R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010,\u001a\u00020-8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\t\u001a\u0004\b.\u0010/R\u001b\u00101\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\t\u001a\u0004\b3\u00104R\u0011\u00106\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b7\u0010\u0007R\u0011\u00108\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b9\u0010\u0007R\u0011\u0010:\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b;\u0010\u0010R\u0014\u0010<\u001a\u00020\"8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020A0@8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u001b\u0010D\u001a\u00020E8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\t\u001a\u0004\bF\u0010G¨\u0006["}, d2 = {"Lio/datazoom/sdk/BaseContextImp;", "Lio/datazoom/sdk/BaseContext;", "<init>", "()V", "fluxStore", "Lio/datazoom/sdk/data/memory/FluxDataStore;", "getFluxStore", "()Lio/datazoom/sdk/data/memory/FluxDataStore;", "fluxStore$delegate", "Lkotlin/Lazy;", "globalFluxStore", "getGlobalFluxStore", "globalFluxStore$delegate", "metaDataStore", "Lio/datazoom/sdk/data/memory/MetaDataStore;", "getMetaDataStore", "()Lio/datazoom/sdk/data/memory/MetaDataStore;", "metaDataStore$delegate", "timeStampsStore", "Lio/datazoom/sdk/domain/TimeStampsStore;", "getTimeStampsStore", "()Lio/datazoom/sdk/domain/TimeStampsStore;", "timeStampsStore$delegate", "customMetadata", "Lio/datazoom/sdk/custom/CustomMetadata;", "getCustomMetadata", "()Lio/datazoom/sdk/custom/CustomMetadata;", "customMetadata$delegate", "eventManager", "Lio/datazoom/sdk/domain/EventManager;", "getEventManager", "()Lio/datazoom/sdk/domain/EventManager;", "eventManager$delegate", "_stateMachine", "Lio/datazoom/sdk/stateMachine/StateMachine;", "threading", "Lio/datazoom/sdk/threading/ThreadingScope;", "getThreading", "()Lio/datazoom/sdk/threading/ThreadingScope;", "threading$delegate", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "parentJob", "Lkotlinx/coroutines/CompletableJob;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "coroutineScope$delegate", "takeCareJob", "Lio/datazoom/sdk/domain/TakeCareJob;", "getTakeCareJob", "()Lio/datazoom/sdk/domain/TakeCareJob;", "takeCareJob$delegate", "fluxData", "getFluxData", "globalFluxData", "getGlobalFluxData", "metadata", "getMetadata", "stateMachine", "getStateMachine$base", "()Lio/datazoom/sdk/stateMachine/StateMachine;", "timerTick", "Lkotlinx/coroutines/flow/SharedFlow;", "Lio/datazoom/sdk/domain/TimerState;", "getTimerTick$base", "()Lkotlinx/coroutines/flow/SharedFlow;", "id", "", "getId", "()Ljava/lang/String;", "id$delegate", "onDestroy", "", "sendEvent", "event", "Lio/datazoom/sdk/model/Event;", "sendEvent$base", "startTimer", "intervalMs", "", "setMetadata", "", "", "clearMetadata", "generateEvent", "name", "payload", "getEventTimeSince", "Lio/datazoom/sdk/model/Event$Type;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class BaseContextImp implements BaseContext {
    private final StateMachine _stateMachine;

    /* JADX INFO: renamed from: coroutineScope$delegate, reason: from kotlin metadata */
    private final Lazy coroutineScope;

    /* JADX INFO: renamed from: customMetadata$delegate, reason: from kotlin metadata */
    private final Lazy customMetadata;

    /* JADX INFO: renamed from: eventManager$delegate, reason: from kotlin metadata */
    private final Lazy eventManager;
    private final CoroutineExceptionHandler exceptionHandler;

    /* JADX INFO: renamed from: fluxStore$delegate, reason: from kotlin metadata */
    private final Lazy fluxStore = LazyKt.lazy(new Function0() { // from class: io.datazoom.sdk.BaseContextImp$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BaseContextImp.fluxStore_delegate$lambda$0();
        }
    });

    /* JADX INFO: renamed from: globalFluxStore$delegate, reason: from kotlin metadata */
    private final Lazy globalFluxStore;

    /* JADX INFO: renamed from: id$delegate, reason: from kotlin metadata */
    private final Lazy id;

    /* JADX INFO: renamed from: metaDataStore$delegate, reason: from kotlin metadata */
    private final Lazy metaDataStore;
    private final CompletableJob parentJob;

    /* JADX INFO: renamed from: takeCareJob$delegate, reason: from kotlin metadata */
    private final Lazy takeCareJob;

    /* JADX INFO: renamed from: threading$delegate, reason: from kotlin metadata */
    private final Lazy threading;

    /* JADX INFO: renamed from: timeStampsStore$delegate, reason: from kotlin metadata */
    private final Lazy timeStampsStore;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseContextImp() {
        final StringQualifier stringQualifierNamed = QualifierKt.named("GLOBAL_FLUX_STORE");
        final Function0 function0 = null;
        this.globalFluxStore = LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), (Function0) new Function0<FluxDataStore>() { // from class: io.datazoom.sdk.BaseContextImp$special$$inlined$inject$default$1
            /* JADX WARN: Type inference failed for: r3v2, types: [io.datazoom.sdk.data.memory.FluxDataStore, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final FluxDataStore invoke() {
                Koin koinRequireSdkKoin = ExtensionsKt.requireSdkKoin();
                return koinRequireSdkKoin.getScopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(FluxDataStore.class), stringQualifierNamed, function0);
            }
        });
        this.metaDataStore = LazyKt.lazy(new Function0() { // from class: io.datazoom.sdk.BaseContextImp$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BaseContextImp.metaDataStore_delegate$lambda$0();
            }
        });
        this.timeStampsStore = LazyKt.lazy(new Function0() { // from class: io.datazoom.sdk.BaseContextImp$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BaseContextImp.timeStampsStore_delegate$lambda$0();
            }
        });
        this.customMetadata = LazyKt.lazy(new Function0() { // from class: io.datazoom.sdk.BaseContextImp$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BaseContextImp.customMetadata_delegate$lambda$0();
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeDefaultLazyMode = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Object[] objArr = 0 == true ? 1 : 0;
        final Object[] objArr2 = 0 == true ? 1 : 0;
        this.eventManager = LazyKt.lazy(lazyThreadSafetyModeDefaultLazyMode, (Function0) new Function0<EventManager>() { // from class: io.datazoom.sdk.BaseContextImp$special$$inlined$inject$default$2
            /* JADX WARN: Type inference failed for: r3v2, types: [io.datazoom.sdk.domain.EventManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final EventManager invoke() {
                Koin koinRequireSdkKoin = ExtensionsKt.requireSdkKoin();
                return koinRequireSdkKoin.getScopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(EventManager.class), objArr, objArr2);
            }
        });
        this._stateMachine = new StateMachineImp();
        LazyThreadSafetyMode lazyThreadSafetyModeDefaultLazyMode2 = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Object[] objArr3 = 0 == true ? 1 : 0;
        final Object[] objArr4 = 0 == true ? 1 : 0;
        this.threading = LazyKt.lazy(lazyThreadSafetyModeDefaultLazyMode2, (Function0) new Function0<ThreadingScope>() { // from class: io.datazoom.sdk.BaseContextImp$special$$inlined$inject$default$3
            /* JADX WARN: Type inference failed for: r3v2, types: [io.datazoom.sdk.threading.ThreadingScope, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ThreadingScope invoke() {
                Koin koinRequireSdkKoin = ExtensionsKt.requireSdkKoin();
                return koinRequireSdkKoin.getScopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(ThreadingScope.class), objArr3, objArr4);
            }
        });
        this.exceptionHandler = new BaseContextImp$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE);
        this.parentJob = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.coroutineScope = LazyKt.lazy(new Function0() { // from class: io.datazoom.sdk.BaseContextImp$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                BaseContextImp baseContextImp = this.f$0;
                return CoroutineScopeKt.CoroutineScope(baseContextImp.getThreading().getCoroutineScope().getCoroutineContext().plus(baseContextImp.parentJob).plus(baseContextImp.exceptionHandler));
            }
        });
        this.takeCareJob = LazyKt.lazy(new Function0() { // from class: io.datazoom.sdk.BaseContextImp$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BaseContextImp.takeCareJob_delegate$lambda$0(this.f$0);
            }
        });
        this.id = LazyKt.lazy(new Function0() { // from class: io.datazoom.sdk.BaseContextImp$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return IdentityGen.INSTANCE.genId();
            }
        });
    }

    static final FluxDataStore fluxStore_delegate$lambda$0() {
        return new FluxDataStore();
    }

    private final FluxDataStore getFluxStore() {
        return (FluxDataStore) this.fluxStore.getValue();
    }

    private final FluxDataStore getGlobalFluxStore() {
        return (FluxDataStore) this.globalFluxStore.getValue();
    }

    private final MetaDataStore getMetaDataStore() {
        return (MetaDataStore) this.metaDataStore.getValue();
    }

    static final MetaDataStore metaDataStore_delegate$lambda$0() {
        return new MetaDataStore();
    }

    private final TimeStampsStore getTimeStampsStore() {
        return (TimeStampsStore) this.timeStampsStore.getValue();
    }

    static final TimeStampsStore timeStampsStore_delegate$lambda$0() {
        return new TimeStampsStore();
    }

    static final CustomMetadataImp customMetadata_delegate$lambda$0() {
        return new CustomMetadataImp();
    }

    private final CustomMetadata getCustomMetadata() {
        return (CustomMetadata) this.customMetadata.getValue();
    }

    private final EventManager getEventManager() {
        return (EventManager) this.eventManager.getValue();
    }

    private final ThreadingScope getThreading() {
        return (ThreadingScope) this.threading.getValue();
    }

    public final CoroutineScope getCoroutineScope() {
        return (CoroutineScope) this.coroutineScope.getValue();
    }

    private final TakeCareJob getTakeCareJob() {
        return (TakeCareJob) this.takeCareJob.getValue();
    }

    static final TakeCareJobImp takeCareJob_delegate$lambda$0(BaseContextImp baseContextImp) {
        return new TakeCareJobImp(baseContextImp.getCoroutineScope());
    }

    public final FluxDataStore getFluxData() {
        return getFluxStore();
    }

    public final FluxDataStore getGlobalFluxData() {
        return getGlobalFluxStore();
    }

    public final MetaDataStore getMetadata() {
        return getMetaDataStore();
    }

    /* JADX INFO: renamed from: getStateMachine$base, reason: from getter */
    public final StateMachine get_stateMachine() {
        return this._stateMachine;
    }

    public final SharedFlow<TimerState> getTimerTick$base() {
        return getTakeCareJob().getTimerTick();
    }

    @Override // io.datazoom.sdk.BaseContext
    public String getId() {
        return (String) this.id.getValue();
    }

    @Override // io.datazoom.sdk.BaseContext
    public void onDestroy() {
        getTakeCareJob().stop();
        getFluxData().clear();
        getMetadata().clear();
        getTimeStampsStore().clear();
        getCustomMetadata().clearCustomMetadata();
        this._stateMachine.finish();
        Job.DefaultImpls.cancel$default((Job) this.parentJob, (CancellationException) null, 1, (Object) null);
        CoroutineScopeKt.cancel$default(getCoroutineScope(), null, 1, null);
    }

    public final void sendEvent$base(Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        HashMap<String, Object> mapCopy = BaseContextKt.copy(event.getFluxData());
        event.getOpsMetadata().put(OpsMetaData.Type.PLAYER_CONTEXT_ID.getValue(), getId());
        String str = (String) getMetaDataStore().get(MetaData.Type.CONTENT_SESSION_ID);
        if (str != null) {
            event.getUserDetails().put(MetaData.Type.CONTENT_SESSION_ID.getValue(), str);
        }
        for (Map.Entry<String, Object> entry : getFluxStore().getAll().entrySet()) {
            event.getFluxData().put(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, Object> entry2 : getGlobalFluxData().getAll().entrySet()) {
            event.getFluxData().put(entry2.getKey(), entry2.getValue());
        }
        for (Map.Entry<String, Object> entry3 : getCustomMetadata().getCustomMetadata().entrySet()) {
            event.getCustom().put(entry3.getKey(), entry3.getValue());
        }
        getTimeStampsStore().addEvent(TimeStampsStoreKt.toEntry(event));
        getEventManager().addAndDispatch(event);
        getGlobalFluxData().merge(mapCopy);
    }

    public final void startTimer(long intervalMs) {
        getTakeCareJob().start(intervalMs);
    }

    @Override // io.datazoom.sdk.BaseContext
    public void setMetadata(Map<String, ? extends Object> metadata) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        getCustomMetadata().setCustomMetadata(metadata);
    }

    @Override // io.datazoom.sdk.BaseContext
    /* JADX INFO: renamed from: getMetadata, reason: collision with other method in class */
    public Map<String, Object> mo12145getMetadata() {
        return getCustomMetadata().getCustomMetadata();
    }

    @Override // io.datazoom.sdk.BaseContext
    public void clearMetadata() {
        getCustomMetadata().clearCustomMetadata();
    }

    @Override // io.datazoom.sdk.BaseContext
    public void generateEvent(String name, Map<String, ? extends Object> payload) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(payload, "payload");
        sendEvent$base(getCustomMetadata().customEvent(name, payload));
    }

    public final long getEventTimeSince(Event.Type event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Long lTimeSince$default = TimeStampsStore.timeSince$default(getTimeStampsStore(), EventKt.uniqueName(event), 0L, 2, null);
        if (lTimeSince$default != null) {
            return lTimeSince$default.longValue();
        }
        return 0L;
    }
}

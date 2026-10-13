package io.datazoom.sdk;

import androidx.appcompat.app.AppCompatDelegate;
import com.amazon.mediatailorsdk.ConstantsKt;
import com.facebook.hermes.intl.Constants;
import com.facebook.imagepipeline.common.RotationOptions;
import io.datazoom.sdk.custom.CustomMetadata;
import io.datazoom.sdk.custom.CustomMetadataImp;
import io.datazoom.sdk.data.memory.MetaDataStore;
import io.datazoom.sdk.di.DatazoomModuleKt;
import io.datazoom.sdk.di.DiName;
import io.datazoom.sdk.di.ExtensionsKt;
import io.datazoom.sdk.di.SdkKoin;
import io.datazoom.sdk.domain.EventManager;
import io.datazoom.sdk.domain.SessionManager;
import io.datazoom.sdk.domain.usecases.AppInfoUseCase;
import io.datazoom.sdk.domain.usecases.GetDeviceInfoUseCase;
import io.datazoom.sdk.domain.usecases.GetNetworkInfoUseCase;
import io.datazoom.sdk.logs.Logger;
import io.datazoom.sdk.logs.Logger_androidKt;
import io.datazoom.sdk.model.Event;
import io.datazoom.sdk.model.EventKt;
import io.datazoom.sdk.model.MetaData;
import io.datazoom.sdk.network.config.GetConfigUseCase;
import io.datazoom.sdk.threading.SdkDispatcher;
import io.datazoom.sdk.threading.ThreadingScope;
import io.datazoom.sdk.time.Time;
import io.datazoom.sdk.utils.DurationsManager;
import io.ktor.sse.ServerSentEventKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowKt;
import org.bouncycastle.asn1.eac.EACTags;
import org.koin.core.Koin;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.qualifier.QualifierKt;
import org.koin.mp.KoinPlatformTools;

/* JADX INFO: compiled from: Datazoom.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020IH\u0016J\b\u0010J\u001a\u00020\nH\u0016J\u0010\u0010K\u001a\u00020\b2\u0006\u0010L\u001a\u00020\bH\u0016J\u0010\u0010M\u001a\u00020G2\u0006\u0010L\u001a\u00020\bH\u0016J\u0010\u0010M\u001a\u00020G2\u0006\u0010N\u001a\u00020\u0007H\u0016J\u0010\u0010O\u001a\u00020G2\u0006\u0010N\u001a\u00020\u0007H\u0016J\u000e\u0010P\u001a\b\u0012\u0004\u0012\u00020\b0QH\u0016J\u000e\u0010R\u001a\b\u0012\u0004\u0012\u00020\n0QH\u0016J\b\u0010S\u001a\u00020\u0007H\u0016J$\u0010T\u001a\u00020G2\u0006\u0010U\u001a\u00020\u00072\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020W0\u0006H\u0016J\u001c\u0010X\u001a\u00020G2\u0012\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020W0\u0006H\u0016J\u0014\u0010Z\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020W0\u0006H\u0016J\b\u0010[\u001a\u00020GH\u0016J\b\u0010\\\u001a\u00020\fH\u0016J\b\u0010]\u001a\u00020GH\u0016J\u0010\u0010e\u001a\u00020G2\u0006\u0010f\u001a\u00020gH\u0002R \u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0012\u001a\u0004\b\u001f\u0010 R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0012\u001a\u0004\b$\u0010%R\u001b\u0010'\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0012\u001a\u0004\b)\u0010*R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u0012\u001a\u0004\b.\u0010/R\u001b\u00101\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u0012\u001a\u0004\b3\u00104R\u0018\u00106\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030807X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u00109\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u0012\u001a\u0004\b;\u0010<R\u001b\u0010>\u001a\u00020?8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\u0012\u001a\u0004\b@\u0010AR\u0010\u0010C\u001a\u00020DX\u0082\u000e¢\u0006\u0004\n\u0002\u0010ER\u0014\u0010^\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b_\u0010`R\u001e\u0010a\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003080b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bc\u0010d¨\u0006h"}, d2 = {"Lio/datazoom/sdk/Datazoom;", "Lio/datazoom/sdk/Sdk;", "<init>", "()V", "adaptersMap", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "", "Lio/datazoom/sdk/DzAdapter;", "baseContexts", "Lio/datazoom/sdk/BaseContext;", "_isInitialized", "", "metaDataStore", "Lio/datazoom/sdk/data/memory/MetaDataStore;", "getMetaDataStore", "()Lio/datazoom/sdk/data/memory/MetaDataStore;", "metaDataStore$delegate", "Lkotlin/Lazy;", "threading", "Lio/datazoom/sdk/threading/ThreadingScope;", "getThreading", "()Lio/datazoom/sdk/threading/ThreadingScope;", "threading$delegate", "deviceInfoUseCase", "Lio/datazoom/sdk/domain/usecases/GetDeviceInfoUseCase;", "getDeviceInfoUseCase", "()Lio/datazoom/sdk/domain/usecases/GetDeviceInfoUseCase;", "deviceInfoUseCase$delegate", "networkInfoUseCase", "Lio/datazoom/sdk/domain/usecases/GetNetworkInfoUseCase;", "getNetworkInfoUseCase", "()Lio/datazoom/sdk/domain/usecases/GetNetworkInfoUseCase;", "networkInfoUseCase$delegate", "appInfoUseCase", "Lio/datazoom/sdk/domain/usecases/AppInfoUseCase;", "getAppInfoUseCase", "()Lio/datazoom/sdk/domain/usecases/AppInfoUseCase;", "appInfoUseCase$delegate", "eventManager", "Lio/datazoom/sdk/domain/EventManager;", "getEventManager", "()Lio/datazoom/sdk/domain/EventManager;", "eventManager$delegate", "configUseCase", "Lio/datazoom/sdk/network/config/GetConfigUseCase;", "getConfigUseCase", "()Lio/datazoom/sdk/network/config/GetConfigUseCase;", "configUseCase$delegate", "sessionManager", "Lio/datazoom/sdk/domain/SessionManager;", "getSessionManager", "()Lio/datazoom/sdk/domain/SessionManager;", "sessionManager$delegate", "clientEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lio/datazoom/sdk/SdkEvent;", "customMetadata", "Lio/datazoom/sdk/custom/CustomMetadata;", "getCustomMetadata", "()Lio/datazoom/sdk/custom/CustomMetadata;", "customMetadata$delegate", "cs", "Lkotlinx/coroutines/CoroutineScope;", "getCs", "()Lkotlinx/coroutines/CoroutineScope;", "cs$delegate", "initGuard", "Lkotlin/concurrent/atomics/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "init", "", "config", "Lio/datazoom/sdk/Config;", "createBaseContext", "createContext", "adapter", "removeContext", "id", "removeBaseContext", "playerContexts", "", "getBaseContexts", "getSessionId", "generateEvent", "name", "payload", "", "setMetadata", "metadata", "getMetadata", "clearMetadata", "isInitialized", "clear", "version", "getVersion", "()Ljava/lang/String;", "sdkEvents", "Lio/datazoom/sdk/CSharedFlow;", "getSdkEvents", "()Lio/datazoom/sdk/CSharedFlow;", "sendMessage", "event", "Lio/datazoom/sdk/model/Event;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Datazoom implements Sdk {
    public static final Datazoom INSTANCE = new Datazoom();
    private static final MutableStateFlow<Boolean> _isInitialized;
    private static final MutableStateFlow<Map<String, DzAdapter>> adaptersMap;

    /* JADX INFO: renamed from: appInfoUseCase$delegate, reason: from kotlin metadata */
    private static final Lazy appInfoUseCase;
    private static final MutableStateFlow<Map<String, BaseContext>> baseContexts;
    private static final MutableSharedFlow<SdkEvent<?>> clientEvent;

    /* JADX INFO: renamed from: configUseCase$delegate, reason: from kotlin metadata */
    private static final Lazy configUseCase;

    /* JADX INFO: renamed from: cs$delegate, reason: from kotlin metadata */
    private static final Lazy cs;

    /* JADX INFO: renamed from: customMetadata$delegate, reason: from kotlin metadata */
    private static final Lazy customMetadata;

    /* JADX INFO: renamed from: deviceInfoUseCase$delegate, reason: from kotlin metadata */
    private static final Lazy deviceInfoUseCase;

    /* JADX INFO: renamed from: eventManager$delegate, reason: from kotlin metadata */
    private static final Lazy eventManager;
    private static AtomicBoolean initGuard;

    /* JADX INFO: renamed from: metaDataStore$delegate, reason: from kotlin metadata */
    private static final Lazy metaDataStore;

    /* JADX INFO: renamed from: networkInfoUseCase$delegate, reason: from kotlin metadata */
    private static final Lazy networkInfoUseCase;

    /* JADX INFO: renamed from: sessionManager$delegate, reason: from kotlin metadata */
    private static final Lazy sessionManager;

    /* JADX INFO: renamed from: threading$delegate, reason: from kotlin metadata */
    private static final Lazy threading;

    private Datazoom() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        SdkKoin.INSTANCE.init(DatazoomModuleKt.getAppModule(), DatazoomModuleKt.getShortLiveScope());
        adaptersMap = StateFlowKt.MutableStateFlow(MapsKt.emptyMap());
        baseContexts = StateFlowKt.MutableStateFlow(MapsKt.emptyMap());
        _isInitialized = StateFlowKt.MutableStateFlow(false);
        LazyThreadSafetyMode lazyThreadSafetyModeDefaultLazyMode = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Qualifier qualifier = null;
        final Object[] objArr = null == true ? 1 : 0;
        metaDataStore = LazyKt.lazy(lazyThreadSafetyModeDefaultLazyMode, (Function0) new Function0<MetaDataStore>() { // from class: io.datazoom.sdk.Datazoom$special$$inlined$inject$default$1
            /* JADX WARN: Type inference failed for: r3v2, types: [io.datazoom.sdk.data.memory.MetaDataStore, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final MetaDataStore invoke() {
                Koin koinRequireSdkKoin = ExtensionsKt.requireSdkKoin();
                return koinRequireSdkKoin.getScopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(MetaDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeDefaultLazyMode2 = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Object[] objArr2 = null == true ? 1 : 0;
        final Object[] objArr3 = null == true ? 1 : 0;
        threading = LazyKt.lazy(lazyThreadSafetyModeDefaultLazyMode2, (Function0) new Function0<ThreadingScope>() { // from class: io.datazoom.sdk.Datazoom$special$$inlined$inject$default$2
            /* JADX WARN: Type inference failed for: r3v2, types: [io.datazoom.sdk.threading.ThreadingScope, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ThreadingScope invoke() {
                Koin koinRequireSdkKoin = ExtensionsKt.requireSdkKoin();
                return koinRequireSdkKoin.getScopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(ThreadingScope.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeDefaultLazyMode3 = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Object[] objArr4 = null == true ? 1 : 0;
        final Object[] objArr5 = null == true ? 1 : 0;
        deviceInfoUseCase = LazyKt.lazy(lazyThreadSafetyModeDefaultLazyMode3, (Function0) new Function0<GetDeviceInfoUseCase>() { // from class: io.datazoom.sdk.Datazoom$special$$inlined$inject$default$3
            /* JADX WARN: Type inference failed for: r3v2, types: [io.datazoom.sdk.domain.usecases.GetDeviceInfoUseCase, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final GetDeviceInfoUseCase invoke() {
                Koin koinRequireSdkKoin = ExtensionsKt.requireSdkKoin();
                return koinRequireSdkKoin.getScopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(GetDeviceInfoUseCase.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeDefaultLazyMode4 = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Object[] objArr6 = null == true ? 1 : 0;
        final Object[] objArr7 = null == true ? 1 : 0;
        networkInfoUseCase = LazyKt.lazy(lazyThreadSafetyModeDefaultLazyMode4, (Function0) new Function0<GetNetworkInfoUseCase>() { // from class: io.datazoom.sdk.Datazoom$special$$inlined$inject$default$4
            /* JADX WARN: Type inference failed for: r3v2, types: [io.datazoom.sdk.domain.usecases.GetNetworkInfoUseCase, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final GetNetworkInfoUseCase invoke() {
                Koin koinRequireSdkKoin = ExtensionsKt.requireSdkKoin();
                return koinRequireSdkKoin.getScopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(GetNetworkInfoUseCase.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeDefaultLazyMode5 = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Object[] objArr8 = null == true ? 1 : 0;
        final Object[] objArr9 = null == true ? 1 : 0;
        appInfoUseCase = LazyKt.lazy(lazyThreadSafetyModeDefaultLazyMode5, (Function0) new Function0<AppInfoUseCase>() { // from class: io.datazoom.sdk.Datazoom$special$$inlined$inject$default$5
            /* JADX WARN: Type inference failed for: r3v2, types: [io.datazoom.sdk.domain.usecases.AppInfoUseCase, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final AppInfoUseCase invoke() {
                Koin koinRequireSdkKoin = ExtensionsKt.requireSdkKoin();
                return koinRequireSdkKoin.getScopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(AppInfoUseCase.class), objArr8, objArr9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeDefaultLazyMode6 = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Object[] objArr10 = null == true ? 1 : 0;
        final Object[] objArr11 = null == true ? 1 : 0;
        eventManager = LazyKt.lazy(lazyThreadSafetyModeDefaultLazyMode6, (Function0) new Function0<EventManager>() { // from class: io.datazoom.sdk.Datazoom$special$$inlined$inject$default$6
            /* JADX WARN: Type inference failed for: r3v2, types: [io.datazoom.sdk.domain.EventManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final EventManager invoke() {
                Koin koinRequireSdkKoin = ExtensionsKt.requireSdkKoin();
                return koinRequireSdkKoin.getScopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(EventManager.class), objArr10, objArr11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeDefaultLazyMode7 = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Object[] objArr12 = null == true ? 1 : 0;
        final Object[] objArr13 = null == true ? 1 : 0;
        configUseCase = LazyKt.lazy(lazyThreadSafetyModeDefaultLazyMode7, (Function0) new Function0<GetConfigUseCase>() { // from class: io.datazoom.sdk.Datazoom$special$$inlined$inject$default$7
            /* JADX WARN: Type inference failed for: r3v2, types: [io.datazoom.sdk.network.config.GetConfigUseCase, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final GetConfigUseCase invoke() {
                Koin koinRequireSdkKoin = ExtensionsKt.requireSdkKoin();
                return koinRequireSdkKoin.getScopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(GetConfigUseCase.class), objArr12, objArr13);
            }
        });
        final Qualifier qualifierNamed = QualifierKt.named(DiName.APP_SESSION_MANAGER);
        LazyThreadSafetyMode lazyThreadSafetyModeDefaultLazyMode8 = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Object[] objArr14 = null == true ? 1 : 0;
        sessionManager = LazyKt.lazy(lazyThreadSafetyModeDefaultLazyMode8, (Function0) new Function0<SessionManager>() { // from class: io.datazoom.sdk.Datazoom$special$$inlined$inject$default$8
            /* JADX WARN: Type inference failed for: r3v2, types: [io.datazoom.sdk.domain.SessionManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SessionManager invoke() {
                Koin koinRequireSdkKoin = ExtensionsKt.requireSdkKoin();
                return koinRequireSdkKoin.getScopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(SessionManager.class), qualifierNamed, objArr14);
            }
        });
        clientEvent = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        customMetadata = LazyKt.lazy(new Function0() { // from class: io.datazoom.sdk.Datazoom$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Datazoom.customMetadata_delegate$lambda$0();
            }
        });
        cs = LazyKt.lazy(new Function0() { // from class: io.datazoom.sdk.Datazoom$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Datazoom.INSTANCE.getThreading().getCoroutineScope();
            }
        });
        initGuard = new AtomicBoolean(false);
    }

    private final MetaDataStore getMetaDataStore() {
        return (MetaDataStore) metaDataStore.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ThreadingScope getThreading() {
        return (ThreadingScope) threading.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GetDeviceInfoUseCase getDeviceInfoUseCase() {
        return (GetDeviceInfoUseCase) deviceInfoUseCase.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GetNetworkInfoUseCase getNetworkInfoUseCase() {
        return (GetNetworkInfoUseCase) networkInfoUseCase.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppInfoUseCase getAppInfoUseCase() {
        return (AppInfoUseCase) appInfoUseCase.getValue();
    }

    private final EventManager getEventManager() {
        return (EventManager) eventManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GetConfigUseCase getConfigUseCase() {
        return (GetConfigUseCase) configUseCase.getValue();
    }

    private final SessionManager getSessionManager() {
        return (SessionManager) sessionManager.getValue();
    }

    static final CustomMetadataImp customMetadata_delegate$lambda$0() {
        return new CustomMetadataImp();
    }

    private final CustomMetadata getCustomMetadata() {
        return (CustomMetadata) customMetadata.getValue();
    }

    private final CoroutineScope getCs() {
        return (CoroutineScope) cs.getValue();
    }

    @Override // io.datazoom.sdk.Sdk
    public void init(Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (initGuard.get()) {
            Logger_androidKt.getLogger().e("Datazoom SDK is already initialized. Multiple initialization is not allowed.");
            return;
        }
        initGuard.set(true);
        DurationsManager.INSTANCE.setEngagementDuration(Long.valueOf(Time.INSTANCE.now()));
        Logger_androidKt.getLogger().setLevel(config.getLogLevel());
        Logger_androidKt.getLogger().v("Datazoom init called with config ID = " + config.getConfigurationId());
        BuildersKt__Builders_commonKt.launch$default(getCs(), SdkDispatcher.INSTANCE.getDispatcher(), null, new AnonymousClass1(config, null), 2, null);
        BuildersKt__Builders_commonKt.launch$default(getCs(), null, null, new AnonymousClass2(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(getCs(), null, null, new AnonymousClass3(null), 3, null);
    }

    /* JADX INFO: renamed from: io.datazoom.sdk.Datazoom$init$1, reason: invalid class name */
    /* JADX INFO: compiled from: Datazoom.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.datazoom.sdk.Datazoom$init$1", f = "Datazoom.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Config $config;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Config config, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$config = config;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$config, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            long jNow = Time.INSTANCE.now();
            Datazoom.INSTANCE.sendMessage(EventKt.toEvent$default(Event.Type.DatazoomLoaded, 0L, null, null, null, null, 31, null));
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C01611(null), 3, null);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass2(null), 3, null);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass3(null), 3, null);
            long jNow2 = Time.INSTANCE.now() - jNow;
            Logger_androidKt.getLogger().v("Time taken to load the SDK = " + jNow2 + "ms");
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass4(this.$config, null), 3, null);
            Logger_androidKt.getLogger().v("Time taken to load the SDK after Config = " + (Time.INSTANCE.now() - jNow) + "ms");
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: io.datazoom.sdk.Datazoom$init$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: Datazoom.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "io.datazoom.sdk.Datazoom$init$1$1", f = "Datazoom.kt", i = {}, l = {EACTags.HISTORICAL_BYTES}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
        static final class C01611 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;

            C01611(Continuation<? super C01611> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01611(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01611) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (Datazoom.INSTANCE.getDeviceInfoUseCase().invoke(this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: io.datazoom.sdk.Datazoom$init$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: Datazoom.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "io.datazoom.sdk.Datazoom$init$1$2", f = "Datazoom.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;

            AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Datazoom.INSTANCE.getNetworkInfoUseCase().invoke();
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: io.datazoom.sdk.Datazoom$init$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: Datazoom.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "io.datazoom.sdk.Datazoom$init$1$3", f = "Datazoom.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;

            AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass3(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Datazoom.INSTANCE.getAppInfoUseCase().invoke();
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: io.datazoom.sdk.Datazoom$init$1$4, reason: invalid class name */
        /* JADX INFO: compiled from: Datazoom.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "io.datazoom.sdk.Datazoom$init$1$4", f = "Datazoom.kt", i = {1}, l = {RotationOptions.ROTATE_90, 91}, m = "invokeSuspend", n = {"result"}, nl = {91, 99}, s = {"L$0"}, v = 2)
        static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Config $config;
            Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass4(Config config, Continuation<? super AnonymousClass4> continuation) {
                super(2, continuation);
                this.$config = config;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass4(this.$config, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code restructure failed: missing block: B:21:0x008a, code lost:
            
                if (r1.emit(r3, r6) == r0) goto L22;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                /*
                    r6 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r6.label
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L23
                    if (r1 == r3) goto L1f
                    if (r1 != r2) goto L17
                    java.lang.Object r6 = r6.L$0
                    io.datazoom.sdk.network.Resource r6 = (io.datazoom.sdk.network.Resource) r6
                    kotlin.ResultKt.throwOnFailure(r7)
                    goto L8d
                L17:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L1f:
                    kotlin.ResultKt.throwOnFailure(r7)
                    goto L44
                L23:
                    kotlin.ResultKt.throwOnFailure(r7)
                    io.datazoom.sdk.Datazoom r7 = io.datazoom.sdk.Datazoom.INSTANCE
                    io.datazoom.sdk.network.config.GetConfigUseCase r7 = io.datazoom.sdk.Datazoom.access$getConfigUseCase(r7)
                    io.datazoom.sdk.Config r1 = r6.$config
                    java.lang.String r1 = r1.getConfigurationId()
                    io.datazoom.sdk.Config r4 = r6.$config
                    java.lang.String r4 = r4.getApiUrl()
                    r5 = r6
                    kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                    r6.label = r3
                    java.lang.Object r7 = r7.invoke(r1, r4, r5)
                    if (r7 != r0) goto L44
                    goto L8c
                L44:
                    io.datazoom.sdk.network.Resource r7 = (io.datazoom.sdk.network.Resource) r7
                    kotlinx.coroutines.flow.MutableSharedFlow r1 = io.datazoom.sdk.Datazoom.access$getClientEvent$p()
                    boolean r4 = r7.isSuccess()
                    if (r4 == 0) goto L65
                    kotlinx.coroutines.flow.MutableStateFlow r4 = io.datazoom.sdk.Datazoom.access$get_isInitialized$p()
                    java.lang.Boolean r3 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
                    r4.setValue(r3)
                    io.datazoom.sdk.SdkEvent$SdkInit r3 = new io.datazoom.sdk.SdkEvent$SdkInit
                    java.lang.String r4 = "SDK initialised successfully"
                    r3.<init>(r4)
                    io.datazoom.sdk.SdkEvent r3 = (io.datazoom.sdk.SdkEvent) r3
                    goto L7b
                L65:
                    io.datazoom.sdk.SdkEvent$SdkError r3 = new io.datazoom.sdk.SdkEvent$SdkError
                    java.lang.Throwable r4 = r7.getError()
                    if (r4 != 0) goto L76
                    java.lang.Exception r4 = new java.lang.Exception
                    java.lang.String r5 = "Unknown error"
                    r4.<init>(r5)
                    java.lang.Throwable r4 = (java.lang.Throwable) r4
                L76:
                    r3.<init>(r4)
                    io.datazoom.sdk.SdkEvent r3 = (io.datazoom.sdk.SdkEvent) r3
                L7b:
                    r4 = r6
                    kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                    java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
                    r6.L$0 = r7
                    r6.label = r2
                    java.lang.Object r6 = r1.emit(r3, r4)
                    if (r6 != r0) goto L8d
                L8c:
                    return r0
                L8d:
                    kotlin.Unit r6 = kotlin.Unit.INSTANCE
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: io.datazoom.sdk.Datazoom.AnonymousClass1.AnonymousClass4.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }
    }

    /* JADX INFO: renamed from: io.datazoom.sdk.Datazoom$init$2, reason: invalid class name */
    /* JADX INFO: compiled from: Datazoom.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.datazoom.sdk.Datazoom$init$2", f = "Datazoom.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (Datazoom.INSTANCE.getThreading().getErrorsState().collect(new FlowCollector() { // from class: io.datazoom.sdk.Datazoom.init.2.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((Throwable) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(Throwable th, Continuation<? super Unit> continuation) {
                        Object objEmit = Datazoom.clientEvent.emit(new SdkEvent.SdkError(th), continuation);
                        return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: renamed from: io.datazoom.sdk.Datazoom$init$3, reason: invalid class name */
    /* JADX INFO: compiled from: Datazoom.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.datazoom.sdk.Datazoom$init$3", f = "Datazoom.kt", i = {}, l = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (Datazoom.clientEvent.collect(new FlowCollector() { // from class: io.datazoom.sdk.Datazoom.init.3.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((SdkEvent<?>) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(SdkEvent<?> sdkEvent, Continuation<? super Unit> continuation) {
                        if (sdkEvent instanceof SdkEvent.SdkError) {
                            Logger_androidKt.getLogger().e("SDK Error: " + sdkEvent);
                        } else {
                            Logger_androidKt.getLogger().v("SDK Event: " + sdkEvent);
                        }
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    @Override // io.datazoom.sdk.Sdk
    public BaseContext createBaseContext() {
        Map<String, BaseContext> value;
        BaseContext baseContextCreate = BaseContextFactory.INSTANCE.create();
        MutableStateFlow<Map<String, BaseContext>> mutableStateFlow = baseContexts;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, MapsKt.plus(value, TuplesKt.to(baseContextCreate.getId(), baseContextCreate))));
        return baseContextCreate;
    }

    @Override // io.datazoom.sdk.Sdk
    public DzAdapter createContext(DzAdapter adapter) {
        String str;
        Map<String, BaseContext> value;
        Map<String, DzAdapter> value2;
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Map<String, DzAdapter> value3 = adaptersMap.getValue();
        if (value3.containsKey(adapter.getId())) {
            Logger_androidKt.getLogger().e("You are trying to create a context with same id as of existing context.");
            DzAdapter dzAdapter = value3.get(adapter.getId());
            Intrinsics.checkNotNull(dzAdapter);
            return dzAdapter;
        }
        Set<Map.Entry<String, DzAdapter>> setEntrySet = value3.entrySet();
        if (setEntrySet.isEmpty()) {
            setEntrySet = null;
        }
        String strJoinToString$default = setEntrySet != null ? CollectionsKt.joinToString$default(setEntrySet, null, null, null, 0, null, new Function1() { // from class: io.datazoom.sdk.Datazoom$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Datazoom.createContext$lambda$1((Map.Entry) obj);
            }
        }, 31, null) : null;
        Logger logger = Logger_androidKt.getLogger();
        String id = adapter.getId();
        String playerId = adapter.getPlayerId();
        if (strJoinToString$default != null) {
            str = "with adapters already in memory " + strJoinToString$default;
        } else {
            str = " No other adapters in memory";
        }
        logger.v("New context created with context ID = " + id + " Player type = " + playerId + ServerSentEventKt.SPACE + str);
        clientEvent.tryEmit(new SdkEvent.ContextCreated(adapter.getId()));
        MutableStateFlow<Map<String, BaseContext>> mutableStateFlow = baseContexts;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, MapsKt.minus(value, adapter.getId())));
        MutableStateFlow<Map<String, DzAdapter>> mutableStateFlow2 = adaptersMap;
        do {
            value2 = mutableStateFlow2.getValue();
        } while (!mutableStateFlow2.compareAndSet(value2, MapsKt.plus(value2, TuplesKt.to(adapter.getId(), adapter))));
        return adapter;
    }

    static final CharSequence createContext$lambda$1(Map.Entry it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (CharSequence) it.getKey();
    }

    @Override // io.datazoom.sdk.Sdk
    public void removeContext(DzAdapter adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        removeContext(adapter.getId());
    }

    @Override // io.datazoom.sdk.Sdk
    public void removeContext(String id) {
        Map<String, DzAdapter> value;
        Intrinsics.checkNotNullParameter(id, "id");
        Logger_androidKt.getLogger().v("Removing context created with context ID = " + id);
        MutableStateFlow<Map<String, DzAdapter>> mutableStateFlow = adaptersMap;
        DzAdapter dzAdapter = mutableStateFlow.getValue().get(id);
        if (dzAdapter != null) {
            dzAdapter.onDestroy();
        }
        clientEvent.tryEmit(new SdkEvent.ContextDestroyed(id));
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, MapsKt.minus(value, id)));
    }

    @Override // io.datazoom.sdk.Sdk
    public void removeBaseContext(String id) {
        Map<String, BaseContext> value;
        Intrinsics.checkNotNullParameter(id, "id");
        Logger_androidKt.getLogger().v("Removing base context with context ID = " + id);
        MutableStateFlow<Map<String, BaseContext>> mutableStateFlow = baseContexts;
        BaseContext baseContext = mutableStateFlow.getValue().get(id);
        if (baseContext != null) {
            baseContext.onDestroy();
        }
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, MapsKt.minus(value, id)));
        clientEvent.tryEmit(new SdkEvent.ContextDestroyed(id));
    }

    @Override // io.datazoom.sdk.Sdk
    public List<DzAdapter> playerContexts() {
        return CollectionsKt.toList(adaptersMap.getValue().values());
    }

    @Override // io.datazoom.sdk.Sdk
    public List<BaseContext> getBaseContexts() {
        return CollectionsKt.toList(baseContexts.getValue().values());
    }

    @Override // io.datazoom.sdk.Sdk
    public String getSessionId() {
        return getSessionManager().currentSession().getId();
    }

    @Override // io.datazoom.sdk.Sdk
    public void generateEvent(String name, Map<String, ? extends Object> payload) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(payload, "payload");
        sendMessage(getCustomMetadata().customEvent(name, payload));
    }

    @Override // io.datazoom.sdk.Sdk
    public void setMetadata(Map<String, ? extends Object> metadata) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        getCustomMetadata().setCustomMetadata(metadata);
        getEventManager().setGlobalCustomMetadata(metadata);
    }

    @Override // io.datazoom.sdk.Sdk
    public Map<String, Object> getMetadata() {
        return getCustomMetadata().getCustomMetadata();
    }

    @Override // io.datazoom.sdk.Sdk
    public void clearMetadata() {
        Map<String, Object> customMetadata2 = getCustomMetadata().getCustomMetadata();
        getCustomMetadata().clearCustomMetadata();
        getEventManager().removeGlobalCustomMetadata(customMetadata2);
    }

    @Override // io.datazoom.sdk.Sdk
    public boolean isInitialized() {
        return _isInitialized.getValue().booleanValue();
    }

    @Override // io.datazoom.sdk.Sdk
    public void clear() {
        Logger_androidKt.getLogger().v("Clear all contexts");
        for (DzAdapter dzAdapter : adaptersMap.getValue().values()) {
            dzAdapter.onDestroy();
            clientEvent.tryEmit(new SdkEvent.ContextDestroyed(dzAdapter.getId()));
        }
        Iterator<T> it = baseContexts.getValue().values().iterator();
        while (it.hasNext()) {
            ((BaseContext) it.next()).onDestroy();
        }
        MutableStateFlow<Map<String, DzAdapter>> mutableStateFlow = adaptersMap;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), MapsKt.emptyMap())) {
        }
        MutableStateFlow<Map<String, BaseContext>> mutableStateFlow2 = baseContexts;
        while (!mutableStateFlow2.compareAndSet(mutableStateFlow2.getValue(), MapsKt.emptyMap())) {
        }
    }

    @Override // io.datazoom.sdk.Sdk
    public String getVersion() {
        String str = (String) getMetaDataStore().get(MetaData.Type.DZ_SDK_VERSION);
        return str == null ? ConstantsKt.DEFAULT_OMID_PARTNER_VERSION : str;
    }

    @Override // io.datazoom.sdk.Sdk
    public CSharedFlow<SdkEvent<?>> getSdkEvents() {
        return FlowExtKt.wrap(clientEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendMessage(Event event) {
        getEventManager().addAndDispatch(event);
    }
}

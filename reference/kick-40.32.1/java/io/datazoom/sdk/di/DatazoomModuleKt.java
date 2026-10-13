package io.datazoom.sdk.di;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.data.memory.ConfigStore;
import io.datazoom.sdk.data.memory.ConfigStoreImp;
import io.datazoom.sdk.data.memory.FlagsPersistence;
import io.datazoom.sdk.data.memory.FlagsPersistenceImp;
import io.datazoom.sdk.data.memory.FluxDataStore;
import io.datazoom.sdk.data.memory.MetaDataStore;
import io.datazoom.sdk.data.memory.PreferenceStore;
import io.datazoom.sdk.domain.EventManager;
import io.datazoom.sdk.domain.SessionManager;
import io.datazoom.sdk.domain.usecases.AppInfoUseCase;
import io.datazoom.sdk.domain.usecases.GetDeviceInfoUseCase;
import io.datazoom.sdk.domain.usecases.GetNetworkInfoUseCase;
import io.datazoom.sdk.network.NetworkClient;
import io.datazoom.sdk.network.config.GetConfigUseCase;
import io.datazoom.sdk.network.events.SendEventUseCase;
import io.datazoom.sdk.network.events.SendEventUseCaseImp;
import io.datazoom.sdk.threading.ThreadingScope;
import io.datazoom.sdk.threading.ThreadingScopeImp;
import io.datazoom.sdk.utils.SafeList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.definition.KoinDefinition;
import org.koin.core.instance.FactoryInstanceFactory;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.module.Module;
import org.koin.core.module.dsl.OptionDSLKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.QualifierKt;
import org.koin.core.registry.ScopeRegistry;
import org.koin.core.scope.Scope;
import org.koin.dsl.ModuleDSLKt;

/* JADX INFO: compiled from: DatazoomModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003¨\u0006\u0006"}, d2 = {"appModule", "Lorg/koin/core/module/Module;", "getAppModule", "()Lorg/koin/core/module/Module;", "shortLiveScope", "getShortLiveScope", Constants.SENSITIVITY_BASE}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DatazoomModuleKt {
    private static final Module appModule = ModuleDSLKt.module$default(false, new Function1() { // from class: io.datazoom.sdk.di.DatazoomModuleKt$$ExternalSyntheticLambda11
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return DatazoomModuleKt.appModule$lambda$0((Module) obj);
        }
    }, 1, null);
    private static final Module shortLiveScope = ModuleDSLKt.module$default(false, new Function1() { // from class: io.datazoom.sdk.di.DatazoomModuleKt$$ExternalSyntheticLambda12
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return DatazoomModuleKt.shortLiveScope$lambda$0((Module) obj);
        }
    }, 1, null);

    public static final Module getAppModule() {
        return appModule;
    }

    static final Unit appModule$lambda$0(Module module) {
        Intrinsics.checkNotNullParameter(module, "$this$module");
        Function2 function2 = new Function2() { // from class: io.datazoom.sdk.di.DatazoomModuleKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return DatazoomModuleKt.appModule$lambda$0$0((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ConfigStore.class), null, function2, Kind.Singleton, CollectionsKt.emptyList()));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        new KoinDefinition(module, singleInstanceFactory2);
        Function2 function3 = new Function2() { // from class: io.datazoom.sdk.di.DatazoomModuleKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return DatazoomModuleKt.appModule$lambda$0$1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory<?> singleInstanceFactory3 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(FlagsPersistence.class), null, function3, Kind.Singleton, CollectionsKt.emptyList()));
        SingleInstanceFactory<?> singleInstanceFactory4 = singleInstanceFactory3;
        module.indexPrimaryType(singleInstanceFactory4);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory3);
        }
        new KoinDefinition(module, singleInstanceFactory4);
        Function1 function1 = new Function1() { // from class: io.datazoom.sdk.di.DatazoomModuleKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DatazoomModuleKt.appModule$lambda$0$2((BeanDefinition) obj);
            }
        };
        Function2<Scope, ParametersHolder, FluxDataStore> function4 = new Function2<Scope, ParametersHolder, FluxDataStore>() { // from class: io.datazoom.sdk.di.DatazoomModuleKt$appModule$lambda$0$$inlined$singleOf$1
            @Override // kotlin.jvm.functions.Function2
            public final FluxDataStore invoke(Scope single, ParametersHolder it) {
                Intrinsics.checkNotNullParameter(single, "$this$single");
                Intrinsics.checkNotNullParameter(it, "it");
                return new FluxDataStore();
            }
        };
        SingleInstanceFactory<?> singleInstanceFactory5 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(FluxDataStore.class), null, function4, Kind.Singleton, CollectionsKt.emptyList()));
        SingleInstanceFactory<?> singleInstanceFactory6 = singleInstanceFactory5;
        module.indexPrimaryType(singleInstanceFactory6);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory5);
        }
        OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory6), function1);
        Function1 function5 = new Function1() { // from class: io.datazoom.sdk.di.DatazoomModuleKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DatazoomModuleKt.appModule$lambda$0$4((BeanDefinition) obj);
            }
        };
        Function2<Scope, ParametersHolder, PreferenceStore> function6 = new Function2<Scope, ParametersHolder, PreferenceStore>() { // from class: io.datazoom.sdk.di.DatazoomModuleKt$appModule$lambda$0$$inlined$singleOf$2
            @Override // kotlin.jvm.functions.Function2
            public final PreferenceStore invoke(Scope single, ParametersHolder it) {
                Intrinsics.checkNotNullParameter(single, "$this$single");
                Intrinsics.checkNotNullParameter(it, "it");
                return new PreferenceStore();
            }
        };
        SingleInstanceFactory<?> singleInstanceFactory7 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(PreferenceStore.class), null, function6, Kind.Singleton, CollectionsKt.emptyList()));
        SingleInstanceFactory<?> singleInstanceFactory8 = singleInstanceFactory7;
        module.indexPrimaryType(singleInstanceFactory8);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory7);
        }
        OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory8), function5);
        Function1 function7 = new Function1() { // from class: io.datazoom.sdk.di.DatazoomModuleKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DatazoomModuleKt.appModule$lambda$0$6((BeanDefinition) obj);
            }
        };
        Function2<Scope, ParametersHolder, SessionManager> function8 = new Function2<Scope, ParametersHolder, SessionManager>() { // from class: io.datazoom.sdk.di.DatazoomModuleKt$appModule$lambda$0$$inlined$singleOf$3
            @Override // kotlin.jvm.functions.Function2
            public final SessionManager invoke(Scope single, ParametersHolder it) {
                Intrinsics.checkNotNullParameter(single, "$this$single");
                Intrinsics.checkNotNullParameter(it, "it");
                return new SessionManager();
            }
        };
        SingleInstanceFactory<?> singleInstanceFactory9 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SessionManager.class), null, function8, Kind.Singleton, CollectionsKt.emptyList()));
        SingleInstanceFactory<?> singleInstanceFactory10 = singleInstanceFactory9;
        module.indexPrimaryType(singleInstanceFactory10);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory9);
        }
        OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory10), function7);
        Function2<Scope, ParametersHolder, MetaDataStore> function9 = new Function2<Scope, ParametersHolder, MetaDataStore>() { // from class: io.datazoom.sdk.di.DatazoomModuleKt$appModule$lambda$0$$inlined$singleOf$default$1
            @Override // kotlin.jvm.functions.Function2
            public final MetaDataStore invoke(Scope single, ParametersHolder it) {
                Intrinsics.checkNotNullParameter(single, "$this$single");
                Intrinsics.checkNotNullParameter(it, "it");
                return new MetaDataStore();
            }
        };
        SingleInstanceFactory<?> singleInstanceFactory11 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(MetaDataStore.class), null, function9, Kind.Singleton, CollectionsKt.emptyList()));
        SingleInstanceFactory<?> singleInstanceFactory12 = singleInstanceFactory11;
        module.indexPrimaryType(singleInstanceFactory12);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory11);
        }
        OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory12), null);
        Function2 function10 = new Function2() { // from class: io.datazoom.sdk.di.DatazoomModuleKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return DatazoomModuleKt.appModule$lambda$0$8((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory<?> singleInstanceFactory13 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(EventManager.class), null, function10, Kind.Singleton, CollectionsKt.emptyList()));
        SingleInstanceFactory<?> singleInstanceFactory14 = singleInstanceFactory13;
        module.indexPrimaryType(singleInstanceFactory14);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory13);
        }
        new KoinDefinition(module, singleInstanceFactory14);
        Function2 function11 = new Function2() { // from class: io.datazoom.sdk.di.DatazoomModuleKt$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return DatazoomModuleKt.appModule$lambda$0$9((Scope) obj, (ParametersHolder) obj2);
            }
        };
        SingleInstanceFactory<?> singleInstanceFactory15 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ThreadingScope.class), null, function11, Kind.Singleton, CollectionsKt.emptyList()));
        SingleInstanceFactory<?> singleInstanceFactory16 = singleInstanceFactory15;
        module.indexPrimaryType(singleInstanceFactory16);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory15);
        }
        new KoinDefinition(module, singleInstanceFactory16);
        Function2<Scope, ParametersHolder, NetworkClient> function12 = new Function2<Scope, ParametersHolder, NetworkClient>() { // from class: io.datazoom.sdk.di.DatazoomModuleKt$appModule$lambda$0$$inlined$singleOf$default$2
            @Override // kotlin.jvm.functions.Function2
            public final NetworkClient invoke(Scope single, ParametersHolder it) {
                Intrinsics.checkNotNullParameter(single, "$this$single");
                Intrinsics.checkNotNullParameter(it, "it");
                return new NetworkClient();
            }
        };
        SingleInstanceFactory<?> singleInstanceFactory17 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(NetworkClient.class), null, function12, Kind.Singleton, CollectionsKt.emptyList()));
        SingleInstanceFactory<?> singleInstanceFactory18 = singleInstanceFactory17;
        module.indexPrimaryType(singleInstanceFactory18);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory17);
        }
        OptionDSLKt.onOptions(new KoinDefinition(module, singleInstanceFactory18), null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConfigStore appModule$lambda$0$0(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new ConfigStoreImp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FlagsPersistence appModule$lambda$0$1(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new FlagsPersistenceImp(((ThreadingScope) single.get(Reflection.getOrCreateKotlinClass(ThreadingScope.class), null, null)).getDispatcher());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit appModule$lambda$0$2(BeanDefinition singleOf) {
        Intrinsics.checkNotNullParameter(singleOf, "$this$singleOf");
        OptionDSLKt.named(singleOf, "GLOBAL_FLUX_STORE");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit appModule$lambda$0$4(BeanDefinition singleOf) {
        Intrinsics.checkNotNullParameter(singleOf, "$this$singleOf");
        OptionDSLKt.named(singleOf, "GLOBAL_PREF_MANAGER");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit appModule$lambda$0$6(BeanDefinition singleOf) {
        Intrinsics.checkNotNullParameter(singleOf, "$this$singleOf");
        OptionDSLKt.named(singleOf, "APP_SESSION_MANAGER");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventManager appModule$lambda$0$8(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new EventManager((FlagsPersistence) single.get(Reflection.getOrCreateKotlinClass(FlagsPersistence.class), null, null), (SendEventUseCase) single.get(Reflection.getOrCreateKotlinClass(SendEventUseCase.class), null, null), (MetaDataStore) single.get(Reflection.getOrCreateKotlinClass(MetaDataStore.class), null, null), (FluxDataStore) single.get(Reflection.getOrCreateKotlinClass(FluxDataStore.class), QualifierKt.named("GLOBAL_FLUX_STORE"), null), (ConfigStore) single.get(Reflection.getOrCreateKotlinClass(ConfigStore.class), null, null), (SessionManager) single.get(Reflection.getOrCreateKotlinClass(SessionManager.class), QualifierKt.named("APP_SESSION_MANAGER"), null), new SafeList(), new SafeList(), (ThreadingScope) single.get(Reflection.getOrCreateKotlinClass(ThreadingScope.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ThreadingScope appModule$lambda$0$9(Scope single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(single, "$this$single");
        Intrinsics.checkNotNullParameter(it, "it");
        return new ThreadingScopeImp();
    }

    public static final Module getShortLiveScope() {
        return shortLiveScope;
    }

    static final Unit shortLiveScope$lambda$0(Module module) {
        Intrinsics.checkNotNullParameter(module, "$this$module");
        Function2 function2 = new Function2() { // from class: io.datazoom.sdk.di.DatazoomModuleKt$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return DatazoomModuleKt.shortLiveScope$lambda$0$0((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SendEventUseCase.class), null, function2, Kind.Factory, CollectionsKt.emptyList()));
        module.indexPrimaryType(factoryInstanceFactory);
        new KoinDefinition(module, factoryInstanceFactory);
        Function2 function3 = new Function2() { // from class: io.datazoom.sdk.di.DatazoomModuleKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return DatazoomModuleKt.shortLiveScope$lambda$0$1((Scope) obj, (ParametersHolder) obj2);
            }
        };
        FactoryInstanceFactory factoryInstanceFactory2 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(GetConfigUseCase.class), null, function3, Kind.Factory, CollectionsKt.emptyList()));
        module.indexPrimaryType(factoryInstanceFactory2);
        new KoinDefinition(module, factoryInstanceFactory2);
        Function1 function1 = new Function1() { // from class: io.datazoom.sdk.di.DatazoomModuleKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DatazoomModuleKt.shortLiveScope$lambda$0$2((BeanDefinition) obj);
            }
        };
        Function2<Scope, ParametersHolder, PreferenceStore> function4 = new Function2<Scope, ParametersHolder, PreferenceStore>() { // from class: io.datazoom.sdk.di.DatazoomModuleKt$shortLiveScope$lambda$0$$inlined$factoryOf$1
            @Override // kotlin.jvm.functions.Function2
            public final PreferenceStore invoke(Scope factory, ParametersHolder it) {
                Intrinsics.checkNotNullParameter(factory, "$this$factory");
                Intrinsics.checkNotNullParameter(it, "it");
                return new PreferenceStore();
            }
        };
        FactoryInstanceFactory factoryInstanceFactory3 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(PreferenceStore.class), null, function4, Kind.Factory, CollectionsKt.emptyList()));
        module.indexPrimaryType(factoryInstanceFactory3);
        OptionDSLKt.onOptions(new KoinDefinition(module, factoryInstanceFactory3), function1);
        Function2<Scope, ParametersHolder, GetDeviceInfoUseCase> function5 = new Function2<Scope, ParametersHolder, GetDeviceInfoUseCase>() { // from class: io.datazoom.sdk.di.DatazoomModuleKt$shortLiveScope$lambda$0$$inlined$factoryOf$default$1
            @Override // kotlin.jvm.functions.Function2
            public final GetDeviceInfoUseCase invoke(Scope factory, ParametersHolder it) {
                Intrinsics.checkNotNullParameter(factory, "$this$factory");
                Intrinsics.checkNotNullParameter(it, "it");
                return new GetDeviceInfoUseCase((MetaDataStore) factory.get(Reflection.getOrCreateKotlinClass(MetaDataStore.class), null, null));
            }
        };
        FactoryInstanceFactory factoryInstanceFactory4 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(GetDeviceInfoUseCase.class), null, function5, Kind.Factory, CollectionsKt.emptyList()));
        module.indexPrimaryType(factoryInstanceFactory4);
        OptionDSLKt.onOptions(new KoinDefinition(module, factoryInstanceFactory4), null);
        Function2<Scope, ParametersHolder, GetNetworkInfoUseCase> function6 = new Function2<Scope, ParametersHolder, GetNetworkInfoUseCase>() { // from class: io.datazoom.sdk.di.DatazoomModuleKt$shortLiveScope$lambda$0$$inlined$factoryOf$default$2
            @Override // kotlin.jvm.functions.Function2
            public final GetNetworkInfoUseCase invoke(Scope factory, ParametersHolder it) {
                Intrinsics.checkNotNullParameter(factory, "$this$factory");
                Intrinsics.checkNotNullParameter(it, "it");
                return new GetNetworkInfoUseCase((MetaDataStore) factory.get(Reflection.getOrCreateKotlinClass(MetaDataStore.class), null, null));
            }
        };
        FactoryInstanceFactory factoryInstanceFactory5 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(GetNetworkInfoUseCase.class), null, function6, Kind.Factory, CollectionsKt.emptyList()));
        module.indexPrimaryType(factoryInstanceFactory5);
        OptionDSLKt.onOptions(new KoinDefinition(module, factoryInstanceFactory5), null);
        Function2<Scope, ParametersHolder, AppInfoUseCase> function7 = new Function2<Scope, ParametersHolder, AppInfoUseCase>() { // from class: io.datazoom.sdk.di.DatazoomModuleKt$shortLiveScope$lambda$0$$inlined$factoryOf$default$3
            @Override // kotlin.jvm.functions.Function2
            public final AppInfoUseCase invoke(Scope factory, ParametersHolder it) {
                Intrinsics.checkNotNullParameter(factory, "$this$factory");
                Intrinsics.checkNotNullParameter(it, "it");
                return new AppInfoUseCase((MetaDataStore) factory.get(Reflection.getOrCreateKotlinClass(MetaDataStore.class), null, null));
            }
        };
        FactoryInstanceFactory factoryInstanceFactory6 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(AppInfoUseCase.class), null, function7, Kind.Factory, CollectionsKt.emptyList()));
        module.indexPrimaryType(factoryInstanceFactory6);
        OptionDSLKt.onOptions(new KoinDefinition(module, factoryInstanceFactory6), null);
        Function1 function8 = new Function1() { // from class: io.datazoom.sdk.di.DatazoomModuleKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DatazoomModuleKt.shortLiveScope$lambda$0$7((BeanDefinition) obj);
            }
        };
        Function2<Scope, ParametersHolder, SessionManager> function9 = new Function2<Scope, ParametersHolder, SessionManager>() { // from class: io.datazoom.sdk.di.DatazoomModuleKt$shortLiveScope$lambda$0$$inlined$factoryOf$2
            @Override // kotlin.jvm.functions.Function2
            public final SessionManager invoke(Scope factory, ParametersHolder it) {
                Intrinsics.checkNotNullParameter(factory, "$this$factory");
                Intrinsics.checkNotNullParameter(it, "it");
                return new SessionManager();
            }
        };
        FactoryInstanceFactory factoryInstanceFactory7 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SessionManager.class), null, function9, Kind.Factory, CollectionsKt.emptyList()));
        module.indexPrimaryType(factoryInstanceFactory7);
        OptionDSLKt.onOptions(new KoinDefinition(module, factoryInstanceFactory7), function8);
        Function1 function10 = new Function1() { // from class: io.datazoom.sdk.di.DatazoomModuleKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DatazoomModuleKt.shortLiveScope$lambda$0$9((BeanDefinition) obj);
            }
        };
        Function2<Scope, ParametersHolder, SessionManager> function11 = new Function2<Scope, ParametersHolder, SessionManager>() { // from class: io.datazoom.sdk.di.DatazoomModuleKt$shortLiveScope$lambda$0$$inlined$factoryOf$3
            @Override // kotlin.jvm.functions.Function2
            public final SessionManager invoke(Scope factory, ParametersHolder it) {
                Intrinsics.checkNotNullParameter(factory, "$this$factory");
                Intrinsics.checkNotNullParameter(it, "it");
                return new SessionManager();
            }
        };
        FactoryInstanceFactory factoryInstanceFactory8 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SessionManager.class), null, function11, Kind.Factory, CollectionsKt.emptyList()));
        module.indexPrimaryType(factoryInstanceFactory8);
        OptionDSLKt.onOptions(new KoinDefinition(module, factoryInstanceFactory8), function10);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SendEventUseCase shortLiveScope$lambda$0$0(Scope factory, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(factory, "$this$factory");
        Intrinsics.checkNotNullParameter(it, "it");
        return new SendEventUseCaseImp((NetworkClient) factory.get(Reflection.getOrCreateKotlinClass(NetworkClient.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GetConfigUseCase shortLiveScope$lambda$0$1(Scope factory, ParametersHolder it) {
        Intrinsics.checkNotNullParameter(factory, "$this$factory");
        Intrinsics.checkNotNullParameter(it, "it");
        return new GetConfigUseCase((NetworkClient) factory.get(Reflection.getOrCreateKotlinClass(NetworkClient.class), null, null), (EventManager) factory.get(Reflection.getOrCreateKotlinClass(EventManager.class), null, null), (ConfigStore) factory.get(Reflection.getOrCreateKotlinClass(ConfigStore.class), null, null), (FlagsPersistence) factory.get(Reflection.getOrCreateKotlinClass(FlagsPersistence.class), null, null), (MetaDataStore) factory.get(Reflection.getOrCreateKotlinClass(MetaDataStore.class), null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit shortLiveScope$lambda$0$2(BeanDefinition factoryOf) {
        Intrinsics.checkNotNullParameter(factoryOf, "$this$factoryOf");
        OptionDSLKt.named(factoryOf, "ADAPTER_PREF_MANAGER");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit shortLiveScope$lambda$0$7(BeanDefinition factoryOf) {
        Intrinsics.checkNotNullParameter(factoryOf, "$this$factoryOf");
        OptionDSLKt.named(factoryOf, "PLAYER_SESSION_MANAGER");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit shortLiveScope$lambda$0$9(BeanDefinition factoryOf) {
        Intrinsics.checkNotNullParameter(factoryOf, "$this$factoryOf");
        OptionDSLKt.named(factoryOf, "PLAYER_AD_SESSION_MANAGER");
        return Unit.INSTANCE;
    }
}

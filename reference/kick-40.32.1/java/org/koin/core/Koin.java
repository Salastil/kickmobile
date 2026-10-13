package org.koin.core;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.time.TimeSource;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.component.KoinScopeComponentKt;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.error.ScopeNotCreatedException;
import org.koin.core.extension.ExtensionManager;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.logger.EmptyLogger;
import org.koin.core.logger.Logger;
import org.koin.core.module.Module;
import org.koin.core.module.ModuleKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.qualifier.TypeQualifier;
import org.koin.core.registry.InstanceRegistry;
import org.koin.core.registry.OptionRegistry;
import org.koin.core.registry.PropertyRegistry;
import org.koin.core.registry.ScopeRegistry;
import org.koin.core.resolution.CoreResolver;
import org.koin.core.scope.Scope;
import org.koin.core.time.DurationExtKt;
import org.koin.ext.KClassExtKt;
import org.koin.mp.KoinPlatformTools;
import org.koin.mp.KoinPlatformTools_jvmKt;

/* JADX INFO: compiled from: Koin.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010(\u001a\u00020)2\u0006\u0010\u0006\u001a\u00020\u0005H\u0007JL\u0010*\u001a\b\u0012\u0004\u0012\u0002H,0+\"\n\b\u0000\u0010,\u0018\u0001*\u00020\u00012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\b\b\u0002\u0010/\u001a\u0002002\u0016\b\n\u00101\u001a\u0010\u0012\u0004\u0012\u000203\u0018\u000102j\u0004\u0018\u0001`4H\u0086\bø\u0001\u0000JN\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H,0+\"\n\b\u0000\u0010,\u0018\u0001*\u00020\u00012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\b\b\u0002\u0010/\u001a\u0002002\u0016\b\n\u00101\u001a\u0010\u0012\u0004\u0012\u000203\u0018\u000102j\u0004\u0018\u0001`4H\u0086\bø\u0001\u0000JA\u00106\u001a\u0002H,\"\n\b\u0000\u0010,\u0018\u0001*\u00020\u00012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\u0016\b\n\u00101\u001a\u0010\u0012\u0004\u0012\u000203\u0018\u000102j\u0004\u0018\u0001`4H\u0086\bø\u0001\u0000¢\u0006\u0002\u00107JC\u00108\u001a\u0004\u0018\u0001H,\"\n\b\u0000\u0010,\u0018\u0001*\u00020\u00012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\u0016\b\n\u00101\u001a\u0010\u0012\u0004\u0012\u000203\u0018\u000102j\u0004\u0018\u0001`4H\u0086\bø\u0001\u0000¢\u0006\u0002\u00107JA\u00106\u001a\u0002H,\"\u0004\b\u0000\u0010,2\n\u00109\u001a\u0006\u0012\u0002\b\u00030:2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\u0016\b\u0002\u00101\u001a\u0010\u0012\u0004\u0012\u000203\u0018\u000102j\u0004\u0018\u0001`4¢\u0006\u0002\u0010;JC\u00108\u001a\u0004\u0018\u0001H,\"\u0004\b\u0000\u0010,2\n\u00109\u001a\u0006\u0012\u0002\b\u00030:2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\u0016\b\u0002\u00101\u001a\u0010\u0012\u0004\u0012\u000203\u0018\u000102j\u0004\u0018\u0001`4¢\u0006\u0002\u0010;JH\u0010<\u001a\u00020)\"\u0006\b\u0000\u0010,\u0018\u00012\u0006\u0010=\u001a\u0002H,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\u0012\b\u0002\u0010>\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030:0?2\b\b\u0002\u0010@\u001a\u00020AH\u0086\b¢\u0006\u0002\u0010BJ\u0017\u0010C\u001a\b\u0012\u0004\u0012\u0002H,0?\"\u0006\b\u0000\u0010,\u0018\u0001H\u0086\bJ2\u0010D\u001a\u00020E2\n\u0010F\u001a\u00060Gj\u0002`H2\u0006\u0010-\u001a\u00020.2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010KJ9\u0010D\u001a\u00020E\"\n\b\u0000\u0010,\u0018\u0001*\u00020\u00012\n\u0010F\u001a\u00060Gj\u0002`H2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010KH\u0086\bJ#\u0010D\u001a\u00020E\"\n\b\u0000\u0010,\u0018\u0001*\u00020\u00012\f\b\u0002\u0010F\u001a\u00060Gj\u0002`HH\u0086\bJ\u001d\u0010D\u001a\u00020E\"\b\b\u0000\u0010,*\u00020L2\u0006\u0010M\u001a\u0002H,¢\u0006\u0002\u0010NJ&\u0010O\u001a\u00020E2\n\u0010F\u001a\u00060Gj\u0002`H2\u0006\u0010-\u001a\u00020.2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u0001J!\u0010O\u001a\u00020E\"\n\b\u0000\u0010,\u0018\u0001*\u00020\u00012\n\u0010F\u001a\u00060Gj\u0002`HH\u0086\bJ\u0012\u0010P\u001a\u00020E2\n\u0010F\u001a\u00060Gj\u0002`HJ\u0014\u0010Q\u001a\u0004\u0018\u00010E2\n\u0010F\u001a\u00060Gj\u0002`HJ\u0012\u0010R\u001a\u00020)2\n\u0010F\u001a\u00060Gj\u0002`HJ%\u0010S\u001a\u0002H,\"\b\b\u0000\u0010,*\u00020\u00012\u0006\u0010T\u001a\u00020G2\u0006\u0010U\u001a\u0002H,¢\u0006\u0002\u0010VJ\u001f\u0010S\u001a\u0004\u0018\u0001H,\"\b\b\u0000\u0010,*\u00020\u00012\u0006\u0010T\u001a\u00020G¢\u0006\u0002\u0010WJ\u0016\u0010X\u001a\u00020)2\u0006\u0010T\u001a\u00020G2\u0006\u0010\u0004\u001a\u00020\u0001J\u000e\u0010Y\u001a\u00020)2\u0006\u0010T\u001a\u00020GJ\u0006\u0010Z\u001a\u00020)J(\u0010[\u001a\u00020)2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020]0?2\b\b\u0002\u0010@\u001a\u00020A2\b\b\u0002\u0010^\u001a\u00020AJ\u0014\u0010_\u001a\u00020)2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020]0?J\u0006\u0010^\u001a\u00020)R&\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058\u0006@BX\u0087\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0003\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u00020\u001a8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0003\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u00020\u001f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0003\u001a\u0004\b!\u0010\"R\u001c\u0010#\u001a\u00020$8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0003\u001a\u0004\b&\u0010'\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006`"}, d2 = {"Lorg/koin/core/Koin;", "", "<init>", "()V", "value", "Lorg/koin/core/logger/Logger;", "logger", "getLogger$annotations", "getLogger", "()Lorg/koin/core/logger/Logger;", "resolver", "Lorg/koin/core/resolution/CoreResolver;", "getResolver$annotations", "getResolver", "()Lorg/koin/core/resolution/CoreResolver;", "scopeRegistry", "Lorg/koin/core/registry/ScopeRegistry;", "getScopeRegistry$annotations", "getScopeRegistry", "()Lorg/koin/core/registry/ScopeRegistry;", "instanceRegistry", "Lorg/koin/core/registry/InstanceRegistry;", "getInstanceRegistry$annotations", "getInstanceRegistry", "()Lorg/koin/core/registry/InstanceRegistry;", "propertyRegistry", "Lorg/koin/core/registry/PropertyRegistry;", "getPropertyRegistry$annotations", "getPropertyRegistry", "()Lorg/koin/core/registry/PropertyRegistry;", "extensionManager", "Lorg/koin/core/extension/ExtensionManager;", "getExtensionManager$annotations", "getExtensionManager", "()Lorg/koin/core/extension/ExtensionManager;", "optionRegistry", "Lorg/koin/core/registry/OptionRegistry;", "getOptionRegistry$annotations", "getOptionRegistry", "()Lorg/koin/core/registry/OptionRegistry;", "setupLogger", "", "inject", "Lkotlin/Lazy;", ExifInterface.GPS_DIRECTION_TRUE, "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "mode", "Lkotlin/LazyThreadSafetyMode;", "parameters", "Lkotlin/Function0;", "Lorg/koin/core/parameter/ParametersHolder;", "Lorg/koin/core/parameter/ParametersDefinition;", "injectOrNull", "get", "(Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getOrNull", "clazz", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "declare", "instance", "secondaryTypes", "", "allowOverride", "", "(Ljava/lang/Object;Lorg/koin/core/qualifier/Qualifier;Ljava/util/List;Z)V", "getAll", "createScope", "Lorg/koin/core/scope/Scope;", "scopeId", "", "Lorg/koin/core/scope/ScopeID;", "source", "scopeArchetype", "Lorg/koin/core/qualifier/TypeQualifier;", "Lorg/koin/core/component/KoinScopeComponent;", "t", "(Lorg/koin/core/component/KoinScopeComponent;)Lorg/koin/core/scope/Scope;", "getOrCreateScope", "getScope", "getScopeOrNull", "deleteScope", "getProperty", "key", "defaultValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/String;)Ljava/lang/Object;", "setProperty", "deleteProperty", "close", "loadModules", "modules", "Lorg/koin/core/module/Module;", "createEagerInstances", "unloadModules", "koin-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Koin {
    private Logger logger = new EmptyLogger();
    private final CoreResolver resolver = new CoreResolver(this);
    private final ScopeRegistry scopeRegistry = new ScopeRegistry(this);
    private final InstanceRegistry instanceRegistry = new InstanceRegistry(this);
    private final PropertyRegistry propertyRegistry = new PropertyRegistry(this);
    private final ExtensionManager extensionManager = new ExtensionManager(this);
    private final OptionRegistry optionRegistry = new OptionRegistry();

    public static /* synthetic */ void getExtensionManager$annotations() {
    }

    public static /* synthetic */ void getInstanceRegistry$annotations() {
    }

    public static /* synthetic */ void getLogger$annotations() {
    }

    public static /* synthetic */ void getOptionRegistry$annotations() {
    }

    public static /* synthetic */ void getPropertyRegistry$annotations() {
    }

    public static /* synthetic */ void getResolver$annotations() {
    }

    public static /* synthetic */ void getScopeRegistry$annotations() {
    }

    public final Logger getLogger() {
        return this.logger;
    }

    public final CoreResolver getResolver() {
        return this.resolver;
    }

    public final ScopeRegistry getScopeRegistry() {
        return this.scopeRegistry;
    }

    public final InstanceRegistry getInstanceRegistry() {
        return this.instanceRegistry;
    }

    public final PropertyRegistry getPropertyRegistry() {
        return this.propertyRegistry;
    }

    public final ExtensionManager getExtensionManager() {
        return this.extensionManager;
    }

    public final OptionRegistry getOptionRegistry() {
        return this.optionRegistry;
    }

    public final void setupLogger(Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.logger = logger;
    }

    public static /* synthetic */ Lazy inject$default(Koin koin, Qualifier qualifier, LazyThreadSafetyMode mode, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            mode = KoinPlatformTools.INSTANCE.defaultLazyMode();
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        Intrinsics.checkNotNullParameter(mode, "mode");
        Scope rootScope = koin.getScopeRegistry().getRootScope();
        Intrinsics.needClassReification();
        return LazyKt.lazy(mode, (Function0) new Koin$inject$$inlined$inject$1(rootScope, qualifier, function0));
    }

    public final /* synthetic */ <T> Lazy<T> inject(Qualifier qualifier, LazyThreadSafetyMode mode, Function0<? extends ParametersHolder> parameters) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Scope rootScope = getScopeRegistry().getRootScope();
        Intrinsics.needClassReification();
        return LazyKt.lazy(mode, (Function0) new Koin$inject$$inlined$inject$1(rootScope, qualifier, parameters));
    }

    public static /* synthetic */ Lazy injectOrNull$default(Koin koin, Qualifier qualifier, LazyThreadSafetyMode mode, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            mode = KoinPlatformTools.INSTANCE.defaultLazyMode();
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        Intrinsics.checkNotNullParameter(mode, "mode");
        Scope rootScope = koin.getScopeRegistry().getRootScope();
        Intrinsics.needClassReification();
        return LazyKt.lazy(mode, (Function0) new Koin$injectOrNull$$inlined$injectOrNull$1(rootScope, qualifier, function0));
    }

    public final /* synthetic */ <T> Lazy<T> injectOrNull(Qualifier qualifier, LazyThreadSafetyMode mode, Function0<? extends ParametersHolder> parameters) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Scope rootScope = getScopeRegistry().getRootScope();
        Intrinsics.needClassReification();
        return LazyKt.lazy(mode, (Function0) new Koin$injectOrNull$$inlined$injectOrNull$1(rootScope, qualifier, parameters));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object get$default(Koin koin, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        Scope rootScope = koin.getScopeRegistry().getRootScope();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return rootScope.get(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
    }

    public final /* synthetic */ <T> T get(Qualifier qualifier, Function0<? extends ParametersHolder> parameters) {
        Scope rootScope = getScopeRegistry().getRootScope();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) rootScope.get(Reflection.getOrCreateKotlinClass(Object.class), qualifier, parameters);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object getOrNull$default(Koin koin, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        Scope rootScope = koin.getScopeRegistry().getRootScope();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return rootScope.getOrNull(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
    }

    public final /* synthetic */ <T> T getOrNull(Qualifier qualifier, Function0<? extends ParametersHolder> parameters) {
        Scope rootScope = getScopeRegistry().getRootScope();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) rootScope.getOrNull(Reflection.getOrCreateKotlinClass(Object.class), qualifier, parameters);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object get$default(Koin koin, KClass kClass, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            qualifier = null;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        return koin.get(kClass, qualifier, function0);
    }

    public final <T> T get(KClass<?> clazz, Qualifier qualifier, Function0<? extends ParametersHolder> parameters) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return (T) this.scopeRegistry.getRootScope().get(clazz, qualifier, parameters);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object getOrNull$default(Koin koin, KClass kClass, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            qualifier = null;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        return koin.getOrNull(kClass, qualifier, function0);
    }

    public final <T> T getOrNull(KClass<?> clazz, Qualifier qualifier, Function0<? extends ParametersHolder> parameters) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return (T) this.scopeRegistry.getRootScope().getOrNull(clazz, qualifier, parameters);
    }

    public static /* synthetic */ void declare$default(Koin koin, Object obj, Qualifier qualifier, List list, boolean z, int i, Object obj2) {
        String value;
        String value2;
        Qualifier qualifier2 = (i & 2) != 0 ? null : qualifier;
        List secondaryTypes = (i & 4) != 0 ? CollectionsKt.emptyList() : list;
        boolean z2 = (i & 8) != 0 ? true : z;
        Intrinsics.checkNotNullParameter(secondaryTypes, "secondaryTypes");
        InstanceRegistry instanceRegistry = koin.getInstanceRegistry();
        Qualifier scopeQualifier = instanceRegistry.get_koin().getScopeRegistry().getRootScope().getScopeQualifier();
        Kind kind = Kind.Scoped;
        Intrinsics.needClassReification();
        Koin$declare$$inlined$declareRootInstance$1 koin$declare$$inlined$declareRootInstance$1 = new Koin$declare$$inlined$declareRootInstance$1(obj);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        BeanDefinition beanDefinition = new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier2, koin$declare$$inlined$declareRootInstance$1, kind, secondaryTypes);
        SingleInstanceFactory singleInstanceFactory = new SingleInstanceFactory(beanDefinition);
        KClass<?> primaryType = beanDefinition.getPrimaryType();
        Qualifier qualifier3 = beanDefinition.getQualifier();
        Qualifier scopeQualifier2 = beanDefinition.getScopeQualifier();
        StringBuilder sb = new StringBuilder();
        sb.append(KClassExtKt.getFullName(primaryType));
        sb.append(AbstractJsonLexerKt.COLON);
        if (qualifier3 == null || (value = qualifier3.getValue()) == null) {
            value = "";
        }
        sb.append(value);
        sb.append(AbstractJsonLexerKt.COLON);
        sb.append(scopeQualifier2);
        SingleInstanceFactory singleInstanceFactory2 = singleInstanceFactory;
        boolean z3 = z2;
        InstanceRegistry.saveMapping$default(instanceRegistry, z3, sb.toString(), singleInstanceFactory2, false, 8, null);
        Iterator<T> it = beanDefinition.getSecondaryTypes().iterator();
        while (it.hasNext()) {
            KClass kClass = (KClass) it.next();
            Qualifier qualifier4 = beanDefinition.getQualifier();
            Qualifier scopeQualifier3 = beanDefinition.getScopeQualifier();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(KClassExtKt.getFullName(kClass));
            sb2.append(AbstractJsonLexerKt.COLON);
            if (qualifier4 == null || (value2 = qualifier4.getValue()) == null) {
                value2 = "";
            }
            sb2.append(value2);
            sb2.append(AbstractJsonLexerKt.COLON);
            sb2.append(scopeQualifier3);
            InstanceRegistry.saveMapping$default(instanceRegistry, z3, sb2.toString(), singleInstanceFactory2, false, 8, null);
        }
    }

    public final /* synthetic */ <T> void declare(T instance, Qualifier qualifier, List<? extends KClass<?>> secondaryTypes, boolean allowOverride) {
        String value;
        String value2;
        Intrinsics.checkNotNullParameter(secondaryTypes, "secondaryTypes");
        InstanceRegistry instanceRegistry = getInstanceRegistry();
        Qualifier scopeQualifier = instanceRegistry.get_koin().getScopeRegistry().getRootScope().getScopeQualifier();
        Kind kind = Kind.Scoped;
        Intrinsics.needClassReification();
        Koin$declare$$inlined$declareRootInstance$1 koin$declare$$inlined$declareRootInstance$1 = new Koin$declare$$inlined$declareRootInstance$1(instance);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        BeanDefinition beanDefinition = new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, koin$declare$$inlined$declareRootInstance$1, kind, secondaryTypes);
        SingleInstanceFactory singleInstanceFactory = new SingleInstanceFactory(beanDefinition);
        KClass<?> primaryType = beanDefinition.getPrimaryType();
        Qualifier qualifier2 = beanDefinition.getQualifier();
        Qualifier scopeQualifier2 = beanDefinition.getScopeQualifier();
        StringBuilder sb = new StringBuilder();
        sb.append(KClassExtKt.getFullName(primaryType));
        sb.append(AbstractJsonLexerKt.COLON);
        if (qualifier2 == null || (value = qualifier2.getValue()) == null) {
            value = "";
        }
        sb.append(value);
        sb.append(AbstractJsonLexerKt.COLON);
        sb.append(scopeQualifier2);
        SingleInstanceFactory singleInstanceFactory2 = singleInstanceFactory;
        InstanceRegistry.saveMapping$default(instanceRegistry, allowOverride, sb.toString(), singleInstanceFactory2, false, 8, null);
        Iterator<T> it = beanDefinition.getSecondaryTypes().iterator();
        while (it.hasNext()) {
            KClass kClass = (KClass) it.next();
            Qualifier qualifier3 = beanDefinition.getQualifier();
            Qualifier scopeQualifier3 = beanDefinition.getScopeQualifier();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(KClassExtKt.getFullName(kClass));
            sb2.append(AbstractJsonLexerKt.COLON);
            if (qualifier3 == null || (value2 = qualifier3.getValue()) == null) {
                value2 = "";
            }
            sb2.append(value2);
            sb2.append(AbstractJsonLexerKt.COLON);
            sb2.append(scopeQualifier3);
            InstanceRegistry.saveMapping$default(instanceRegistry, allowOverride, sb2.toString(), singleInstanceFactory2, false, 8, null);
        }
    }

    public final /* synthetic */ <T> List<T> getAll() {
        Scope rootScope = getScopeRegistry().getRootScope();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return rootScope.getAll(Reflection.getOrCreateKotlinClass(Object.class));
    }

    public static /* synthetic */ Scope createScope$default(Koin koin, String str, Qualifier qualifier, Object obj, TypeQualifier typeQualifier, int i, Object obj2) {
        if ((i & 4) != 0) {
            obj = null;
        }
        if ((i & 8) != 0) {
            typeQualifier = null;
        }
        return koin.createScope(str, qualifier, obj, typeQualifier);
    }

    public final Scope createScope(String scopeId, Qualifier qualifier, Object source, TypeQualifier scopeArchetype) {
        Intrinsics.checkNotNullParameter(scopeId, "scopeId");
        Intrinsics.checkNotNullParameter(qualifier, "qualifier");
        return this.scopeRegistry.createScope(scopeId, qualifier, source, scopeArchetype);
    }

    public static /* synthetic */ Scope createScope$default(Koin koin, String scopeId, Object obj, TypeQualifier typeQualifier, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        if ((i & 4) != 0) {
            typeQualifier = null;
        }
        Intrinsics.checkNotNullParameter(scopeId, "scopeId");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return koin.getScopeRegistry().createScope(scopeId, new TypeQualifier(Reflection.getOrCreateKotlinClass(Object.class)), obj, typeQualifier);
    }

    public final /* synthetic */ <T> Scope createScope(String scopeId, Object source, TypeQualifier scopeArchetype) {
        Intrinsics.checkNotNullParameter(scopeId, "scopeId");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return getScopeRegistry().createScope(scopeId, new TypeQualifier(Reflection.getOrCreateKotlinClass(Object.class)), source, scopeArchetype);
    }

    public static /* synthetic */ Scope createScope$default(Koin koin, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = KoinPlatformTools_jvmKt.generateId(KoinPlatformTools.INSTANCE);
        }
        String scopeId = str;
        Intrinsics.checkNotNullParameter(scopeId, "scopeId");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return ScopeRegistry.createScope$default(koin.getScopeRegistry(), scopeId, new TypeQualifier(Reflection.getOrCreateKotlinClass(Object.class)), null, null, 8, null);
    }

    public final /* synthetic */ <T> Scope createScope(String scopeId) {
        Intrinsics.checkNotNullParameter(scopeId, "scopeId");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return ScopeRegistry.createScope$default(getScopeRegistry(), scopeId, new TypeQualifier(Reflection.getOrCreateKotlinClass(Object.class)), null, null, 8, null);
    }

    public final <T extends KoinScopeComponent> Scope createScope(T t) {
        Intrinsics.checkNotNullParameter(t, "t");
        return ScopeRegistry.createScope$default(this.scopeRegistry, KoinScopeComponentKt.getScopeId(t), KoinScopeComponentKt.getScopeName(t), null, null, 8, null);
    }

    public static /* synthetic */ Scope getOrCreateScope$default(Koin koin, String str, Qualifier qualifier, Object obj, int i, Object obj2) {
        if ((i & 4) != 0) {
            obj = null;
        }
        return koin.getOrCreateScope(str, qualifier, obj);
    }

    public final Scope getOrCreateScope(String scopeId, Qualifier qualifier, Object source) {
        Intrinsics.checkNotNullParameter(scopeId, "scopeId");
        Intrinsics.checkNotNullParameter(qualifier, "qualifier");
        Scope scopeOrNull = this.scopeRegistry.getScopeOrNull(scopeId);
        return scopeOrNull == null ? createScope$default(this, scopeId, qualifier, source, null, 8, null) : scopeOrNull;
    }

    public final /* synthetic */ <T> Scope getOrCreateScope(String scopeId) {
        Intrinsics.checkNotNullParameter(scopeId, "scopeId");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        TypeQualifier typeQualifier = new TypeQualifier(Reflection.getOrCreateKotlinClass(Object.class));
        Scope scopeOrNull = getScopeRegistry().getScopeOrNull(scopeId);
        return scopeOrNull == null ? createScope$default(this, scopeId, typeQualifier, null, null, 12, null) : scopeOrNull;
    }

    public final Scope getScope(String scopeId) throws ScopeNotCreatedException {
        Intrinsics.checkNotNullParameter(scopeId, "scopeId");
        Scope scopeOrNull = this.scopeRegistry.getScopeOrNull(scopeId);
        if (scopeOrNull != null) {
            return scopeOrNull;
        }
        throw new ScopeNotCreatedException("No scope found for id '" + scopeId + '\'');
    }

    public final Scope getScopeOrNull(String scopeId) {
        Intrinsics.checkNotNullParameter(scopeId, "scopeId");
        return this.scopeRegistry.getScopeOrNull(scopeId);
    }

    public final void deleteScope(String scopeId) {
        Intrinsics.checkNotNullParameter(scopeId, "scopeId");
        this.scopeRegistry.deleteScope$koin_core(scopeId);
    }

    public final <T> T getProperty(String key, T defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        T t = (T) this.propertyRegistry.getProperty(key);
        return t == null ? defaultValue : t;
    }

    public final <T> T getProperty(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (T) this.propertyRegistry.getProperty(key);
    }

    public final void setProperty(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.propertyRegistry.saveProperty$koin_core(key, value);
    }

    public final void deleteProperty(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.propertyRegistry.deleteProperty(key);
    }

    public final void close() {
        this.scopeRegistry.close$koin_core();
        this.instanceRegistry.close$koin_core();
        this.propertyRegistry.close();
        this.extensionManager.close();
    }

    public static /* synthetic */ void loadModules$default(Koin koin, List list, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        koin.loadModules(list, z, z2);
    }

    public final void loadModules(List<Module> modules, boolean allowOverride, boolean createEagerInstances) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        Set<Module> setFlatten = ModuleKt.flatten(modules);
        this.instanceRegistry.loadModules$koin_core(setFlatten, allowOverride);
        this.scopeRegistry.loadScopes(setFlatten);
        if (createEagerInstances) {
            createEagerInstances();
        }
    }

    public final void unloadModules(List<Module> modules) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        this.instanceRegistry.unloadModules$koin_core(ModuleKt.flatten(modules));
    }

    public final void createEagerInstances() {
        this.logger.debug("Create eager instances ...");
        long jM14181markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m14181markNowz9LOYto();
        this.instanceRegistry.createAllEagerInstances$koin_core();
        long jM14186elapsedNowUwyO8pc = TimeSource.Monotonic.ValueTimeMark.m14186elapsedNowUwyO8pc(jM14181markNowz9LOYto);
        this.logger.debug("Created eager instances in " + DurationExtKt.m14540getInMsLRDsOJo(jM14186elapsedNowUwyO8pc) + " ms");
    }
}

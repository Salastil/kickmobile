package org.koin.core.registry;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.interfaces.permissions.PermissionsResponse;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.koin.core.Koin;
import org.koin.core.annotation.KoinExperimentalAPI;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.instance.NoClass;
import org.koin.core.instance.ResolutionContext;
import org.koin.core.instance.ScopedInstanceFactory;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.module.Module;
import org.koin.core.module.ModuleKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.qualifier.TypeQualifier;
import org.koin.core.scope.Scope;
import org.koin.ext.KClassExtKt;
import org.koin.mp.KoinPlatformTools;

/* JADX INFO: compiled from: InstanceRegistry.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\b\u001bJ\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0018H\u0002J\r\u0010\u001e\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u001fJ\u0018\u0010 \u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J2\u0010!\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\n\u0010\"\u001a\u00060\nj\u0002`\u000b2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030\f2\b\b\u0002\u0010$\u001a\u00020\u001aH\u0007J\u001a\u0010%\u001a\u00020\u00152\u0010\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130&H\u0002J1\u0010'\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\n\u0010(\u001a\u0006\u0012\u0002\b\u00030)2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020+H\u0000¢\u0006\u0002\b-J5\u0010.\u001a\u0004\u0018\u0001H/\"\u0004\b\u0000\u0010/2\b\u0010*\u001a\u0004\u0018\u00010+2\n\u00100\u001a\u0006\u0012\u0002\b\u00030)2\u0006\u00101\u001a\u000202H\u0001¢\u0006\u0004\b3\u00104J=\u00105\u001a\u0004\u0018\u0001H/\"\u0004\b\u0000\u0010/2\b\u0010*\u001a\u0004\u0018\u00010+2\n\u0010(\u001a\u0006\u0012\u0002\b\u00030)2\u0006\u0010,\u001a\u00020+2\u0006\u00106\u001a\u000202H\u0000¢\u0006\u0004\b7\u00108Jd\u00109\u001a\u00020\u0015\"\u0006\b\u0000\u0010/\u0018\u00012\u0006\u0010:\u001a\u0002H/2\u0006\u0010,\u001a\u00020+2\n\u0010;\u001a\u00060\nj\u0002`<2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\u0012\b\u0002\u0010=\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030)0>2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\u001aH\u0081\b¢\u0006\u0002\u0010@JH\u0010A\u001a\u00020\u0015\"\u0006\b\u0000\u0010/\u0018\u00012\u0006\u0010:\u001a\u0002H/2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\u0012\b\u0002\u0010=\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030)0>2\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0081\b¢\u0006\u0002\u0010BJ\u0015\u0010C\u001a\u00020\u00152\u0006\u0010D\u001a\u00020EH\u0000¢\u0006\u0002\bFJ\r\u0010G\u001a\u00020\u0015H\u0000¢\u0006\u0002\bHJ-\u0010I\u001a\b\u0012\u0004\u0012\u0002H/0>\"\u0004\b\u0000\u0010/2\n\u0010(\u001a\u0006\u0012\u0002\b\u00030)2\u0006\u00106\u001a\u000202H\u0000¢\u0006\u0002\bJJ\u001b\u0010K\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0000¢\u0006\u0002\bLJ\u0010\u0010M\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0018H\u0002J\u0006\u0010N\u001a\u00020\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\u0016\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R%\u0010\r\u001a\u0016\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lorg/koin/core/registry/InstanceRegistry;", "", "_koin", "Lorg/koin/core/Koin;", "<init>", "(Lorg/koin/core/Koin;)V", "get_koin", "()Lorg/koin/core/Koin;", "_instances", "", "", "Lorg/koin/core/definition/IndexKey;", "Lorg/koin/core/instance/InstanceFactory;", "instances", "", "getInstances", "()Ljava/util/Map;", "eagerInstances", "", "Lorg/koin/core/instance/SingleInstanceFactory;", "loadModules", "", "modules", "", "Lorg/koin/core/module/Module;", "allowOverride", "", "loadModules$koin_core", "addAllEagerInstances", "module", "createAllEagerInstances", "createAllEagerInstances$koin_core", "loadModule", "saveMapping", "mapping", "factory", "logWarning", "createEagerInstances", "", "resolveDefinition", "clazz", "Lkotlin/reflect/KClass;", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "scopeQualifier", "resolveDefinition$koin_core", "resolveScopeArchetypeInstance", ExifInterface.GPS_DIRECTION_TRUE, "klass", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lorg/koin/core/instance/ResolutionContext;", "resolveScopeArchetypeInstance$koin_core", "(Lorg/koin/core/qualifier/Qualifier;Lkotlin/reflect/KClass;Lorg/koin/core/instance/ResolutionContext;)Ljava/lang/Object;", "resolveInstance", "instanceContext", "resolveInstance$koin_core", "(Lorg/koin/core/qualifier/Qualifier;Lkotlin/reflect/KClass;Lorg/koin/core/qualifier/Qualifier;Lorg/koin/core/instance/ResolutionContext;)Ljava/lang/Object;", "scopeDeclaredInstance", "instance", "scopeID", "Lorg/koin/core/scope/ScopeID;", "secondaryTypes", "", "holdInstance", "(Ljava/lang/Object;Lorg/koin/core/qualifier/Qualifier;Ljava/lang/String;Lorg/koin/core/qualifier/Qualifier;Ljava/util/List;ZZ)V", "declareRootInstance", "(Ljava/lang/Object;Lorg/koin/core/qualifier/Qualifier;Ljava/util/List;Z)V", "dropScopeInstances", PermissionsResponse.SCOPE_KEY, "Lorg/koin/core/scope/Scope;", "dropScopeInstances$koin_core", "close", "close$koin_core", "getAll", "getAll$koin_core", "unloadModules", "unloadModules$koin_core", "unloadModule", ContentDisposition.Parameters.Size, "koin-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InstanceRegistry {
    private final Map<String, InstanceFactory<?>> _instances;
    private final Koin _koin;
    private final Map<Integer, SingleInstanceFactory<?>> eagerInstances;

    public InstanceRegistry(Koin _koin) {
        Intrinsics.checkNotNullParameter(_koin, "_koin");
        this._koin = _koin;
        this._instances = KoinPlatformTools.INSTANCE.safeHashMap();
        this.eagerInstances = KoinPlatformTools.INSTANCE.safeHashMap();
    }

    public final Koin get_koin() {
        return this._koin;
    }

    public final Map<String, InstanceFactory<?>> getInstances() {
        return this._instances;
    }

    public final void loadModules$koin_core(Set<Module> modules, boolean allowOverride) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        for (Module module : modules) {
            loadModule(module, allowOverride);
            addAllEagerInstances(module);
        }
    }

    private final void addAllEagerInstances(Module module) {
        for (SingleInstanceFactory<?> singleInstanceFactory : module.getEagerInstances()) {
            this.eagerInstances.put(Integer.valueOf(singleInstanceFactory.getBeanDefinition().hashCode()), singleInstanceFactory);
        }
    }

    public final void createAllEagerInstances$koin_core() {
        SingleInstanceFactory[] singleInstanceFactoryArr = (SingleInstanceFactory[]) this.eagerInstances.values().toArray(new SingleInstanceFactory[0]);
        ArrayList arrayListArrayListOf = CollectionsKt.arrayListOf(Arrays.copyOf(singleInstanceFactoryArr, singleInstanceFactoryArr.length));
        this.eagerInstances.clear();
        createEagerInstances(arrayListArrayListOf);
    }

    private final void loadModule(Module module, boolean allowOverride) {
        for (Map.Entry<String, InstanceFactory<?>> entry : module.getMappings().entrySet()) {
            saveMapping$default(this, allowOverride, entry.getKey(), entry.getValue(), false, 8, null);
        }
    }

    public static /* synthetic */ void saveMapping$default(InstanceRegistry instanceRegistry, boolean z, String str, InstanceFactory instanceFactory, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = true;
        }
        instanceRegistry.saveMapping(z, str, instanceFactory, z2);
    }

    public final void saveMapping(boolean allowOverride, String mapping, InstanceFactory<?> factory, boolean logWarning) {
        Object next;
        Intrinsics.checkNotNullParameter(mapping, "mapping");
        Intrinsics.checkNotNullParameter(factory, "factory");
        if (this._instances.get(mapping) != null) {
            if (!allowOverride) {
                ModuleKt.overrideError(factory, mapping);
            } else if (logWarning) {
                this._koin.getLogger().warn("(+) override index '" + mapping + "' -> '" + factory.getBeanDefinition() + '\'');
                Iterator<T> it = this.eagerInstances.values().iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(((SingleInstanceFactory) next).getBeanDefinition(), factory.getBeanDefinition()));
                if (((SingleInstanceFactory) next) != null) {
                    this.eagerInstances.remove(Integer.valueOf(factory.getBeanDefinition().hashCode()));
                }
            }
        }
        this._koin.getLogger().debug("(+) index '" + mapping + "' -> '" + factory.getBeanDefinition() + '\'');
        this._instances.put(mapping, factory);
    }

    private final void createEagerInstances(Collection<? extends SingleInstanceFactory<?>> instances) {
        ResolutionContext resolutionContext = new ResolutionContext(this._koin.getLogger(), this._koin.getScopeRegistry().getRootScope(), Reflection.getOrCreateKotlinClass(NoClass.class), null, null, 24, null);
        Iterator<T> it = instances.iterator();
        while (it.hasNext()) {
            ((SingleInstanceFactory) it.next()).get(resolutionContext);
        }
    }

    @KoinExperimentalAPI
    public final <T> T resolveScopeArchetypeInstance$koin_core(Qualifier qualifier, KClass<?> klass, ResolutionContext context) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        Intrinsics.checkNotNullParameter(context, "context");
        TypeQualifier scopeArchetype = context.getScope().getScopeArchetype();
        if (scopeArchetype == null) {
            return null;
        }
        context.setScopeArchetype(scopeArchetype);
        return (T) resolveInstance$koin_core(qualifier, klass, scopeArchetype, context);
    }

    public final <T> T resolveInstance$koin_core(Qualifier qualifier, KClass<?> clazz, Qualifier scopeQualifier, ResolutionContext instanceContext) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Intrinsics.checkNotNullParameter(instanceContext, "instanceContext");
        InstanceFactory<?> instanceFactoryResolveDefinition$koin_core = resolveDefinition$koin_core(clazz, qualifier, scopeQualifier);
        T t = instanceFactoryResolveDefinition$koin_core != null ? (T) instanceFactoryResolveDefinition$koin_core.get(instanceContext) : null;
        if (t == null) {
            return null;
        }
        return t;
    }

    public static /* synthetic */ void scopeDeclaredInstance$default(InstanceRegistry instanceRegistry, Object obj, Qualifier scopeQualifier, String scopeID, Qualifier qualifier, List list, boolean z, boolean z2, int i, Object obj2) {
        String value;
        Function2 instanceRegistry$scopeDeclaredInstance$definitionFunction$2;
        String value2;
        Qualifier qualifier2 = (i & 8) != 0 ? null : qualifier;
        List secondaryTypes = (i & 16) != 0 ? CollectionsKt.emptyList() : list;
        boolean z3 = (i & 32) != 0 ? true : z;
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Intrinsics.checkNotNullParameter(scopeID, "scopeID");
        Intrinsics.checkNotNullParameter(secondaryTypes, "secondaryTypes");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        StringBuilder sb = new StringBuilder();
        sb.append(KClassExtKt.getFullName(orCreateKotlinClass));
        sb.append(AbstractJsonLexerKt.COLON);
        if (qualifier2 == null || (value = qualifier2.getValue()) == null) {
            value = "";
        }
        sb.append(value);
        sb.append(AbstractJsonLexerKt.COLON);
        sb.append(scopeQualifier);
        String string = sb.toString();
        InstanceFactory<?> instanceFactory = instanceRegistry.getInstances().get(string);
        ScopedInstanceFactory scopedInstanceFactory = instanceFactory instanceof ScopedInstanceFactory ? (ScopedInstanceFactory) instanceFactory : null;
        if (scopedInstanceFactory != null) {
            scopedInstanceFactory.saveValue(scopeID, obj);
            return;
        }
        if (z2) {
            Intrinsics.needClassReification();
            instanceRegistry$scopeDeclaredInstance$definitionFunction$2 = new InstanceRegistry$scopeDeclaredInstance$definitionFunction$2(obj);
        } else {
            instanceRegistry$scopeDeclaredInstance$definitionFunction$2 = new InstanceRegistry$scopeDeclaredInstance$definitionFunction$1(orCreateKotlinClass);
        }
        Kind kind = Kind.Scoped;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        BeanDefinition beanDefinition = new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier2, instanceRegistry$scopeDeclaredInstance$definitionFunction$2, kind, secondaryTypes);
        ScopedInstanceFactory scopedInstanceFactory2 = new ScopedInstanceFactory(beanDefinition, z2);
        ScopedInstanceFactory scopedInstanceFactory3 = scopedInstanceFactory2;
        saveMapping$default(instanceRegistry, z3, string, scopedInstanceFactory3, false, 8, null);
        Iterator<T> it = beanDefinition.getSecondaryTypes().iterator();
        while (it.hasNext()) {
            KClass kClass = (KClass) it.next();
            Qualifier qualifier3 = beanDefinition.getQualifier();
            Qualifier scopeQualifier2 = beanDefinition.getScopeQualifier();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(KClassExtKt.getFullName(kClass));
            sb2.append(AbstractJsonLexerKt.COLON);
            if (qualifier3 == null || (value2 = qualifier3.getValue()) == null) {
                value2 = "";
            }
            sb2.append(value2);
            sb2.append(AbstractJsonLexerKt.COLON);
            sb2.append(scopeQualifier2);
            saveMapping$default(instanceRegistry, z3, sb2.toString(), scopedInstanceFactory3, false, 8, null);
        }
        scopedInstanceFactory2.saveValue(scopeID, obj);
    }

    public static /* synthetic */ void declareRootInstance$default(InstanceRegistry instanceRegistry, Object obj, Qualifier qualifier, List list, boolean z, int i, Object obj2) {
        String value;
        String value2;
        Qualifier qualifier2 = (i & 2) != 0 ? null : qualifier;
        List secondaryTypes = (i & 4) != 0 ? CollectionsKt.emptyList() : list;
        boolean z2 = (i & 8) != 0 ? true : z;
        Intrinsics.checkNotNullParameter(secondaryTypes, "secondaryTypes");
        Qualifier scopeQualifier = instanceRegistry.get_koin().getScopeRegistry().getRootScope().getScopeQualifier();
        Kind kind = Kind.Scoped;
        Intrinsics.needClassReification();
        InstanceRegistry$declareRootInstance$def$1 instanceRegistry$declareRootInstance$def$1 = new InstanceRegistry$declareRootInstance$def$1(obj);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        BeanDefinition beanDefinition = new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier2, instanceRegistry$declareRootInstance$def$1, kind, secondaryTypes);
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
        saveMapping$default(instanceRegistry, z2, sb.toString(), singleInstanceFactory2, false, 8, null);
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
            saveMapping$default(instanceRegistry, z2, sb2.toString(), singleInstanceFactory2, false, 8, null);
        }
    }

    public final /* synthetic */ <T> void declareRootInstance(T instance, Qualifier qualifier, List<? extends KClass<?>> secondaryTypes, boolean allowOverride) {
        String value;
        String value2;
        Intrinsics.checkNotNullParameter(secondaryTypes, "secondaryTypes");
        Qualifier scopeQualifier = get_koin().getScopeRegistry().getRootScope().getScopeQualifier();
        Kind kind = Kind.Scoped;
        Intrinsics.needClassReification();
        InstanceRegistry$declareRootInstance$def$1 instanceRegistry$declareRootInstance$def$1 = new InstanceRegistry$declareRootInstance$def$1(instance);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        BeanDefinition beanDefinition = new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, instanceRegistry$declareRootInstance$def$1, kind, secondaryTypes);
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
        saveMapping$default(this, allowOverride, sb.toString(), singleInstanceFactory2, false, 8, null);
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
            SingleInstanceFactory singleInstanceFactory3 = singleInstanceFactory2;
            saveMapping$default(this, allowOverride, sb2.toString(), singleInstanceFactory3, false, 8, null);
            singleInstanceFactory2 = singleInstanceFactory3;
        }
    }

    public final void dropScopeInstances$koin_core(Scope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        InstanceFactory[] instanceFactoryArr = (InstanceFactory[]) this._instances.values().toArray(new InstanceFactory[0]);
        ArrayList arrayList = new ArrayList();
        for (InstanceFactory instanceFactory : instanceFactoryArr) {
            if (instanceFactory instanceof ScopedInstanceFactory) {
                arrayList.add(instanceFactory);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((ScopedInstanceFactory) it.next()).drop(scope);
        }
    }

    public final void close$koin_core() {
        for (InstanceFactory instanceFactory : (InstanceFactory[]) this._instances.values().toArray(new InstanceFactory[0])) {
            instanceFactory.dropAll();
        }
        this._instances.clear();
    }

    public final <T> List<T> getAll$koin_core(KClass<?> clazz, ResolutionContext instanceContext) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(instanceContext, "instanceContext");
        Collection<InstanceFactory<?>> collectionValues = this._instances.values();
        ArrayList arrayList = new ArrayList();
        for (T t : collectionValues) {
            InstanceFactory instanceFactory = (InstanceFactory) t;
            if (Intrinsics.areEqual(instanceFactory.getBeanDefinition().getScopeQualifier(), instanceContext.getScope().getScopeQualifier()) && (Intrinsics.areEqual(instanceFactory.getBeanDefinition().getPrimaryType(), clazz) || instanceFactory.getBeanDefinition().getSecondaryTypes().contains(clazz))) {
                arrayList.add(t);
            }
        }
        List listDistinct = CollectionsKt.distinct(arrayList);
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = listDistinct.iterator();
        while (it.hasNext()) {
            Object obj = ((InstanceFactory) it.next()).get(instanceContext);
            if (obj == null) {
                obj = null;
            }
            if (obj != null) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    public final void unloadModules$koin_core(Set<Module> modules) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        Iterator<T> it = modules.iterator();
        while (it.hasNext()) {
            unloadModule((Module) it.next());
        }
    }

    private final void unloadModule(Module module) {
        Set<String> setKeySet = module.getMappings().keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
        for (String str : setKeySet) {
            InstanceFactory<?> instanceFactory = this._instances.get(str);
            if (instanceFactory != null) {
                instanceFactory.dropAll();
            }
            this._instances.remove(str);
        }
    }

    public final int size() {
        return this._instances.size();
    }

    public final InstanceFactory<?> resolveDefinition$koin_core(KClass<?> clazz, Qualifier qualifier, Qualifier scopeQualifier) {
        String value;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        StringBuilder sb = new StringBuilder();
        sb.append(KClassExtKt.getFullName(clazz));
        sb.append(AbstractJsonLexerKt.COLON);
        if (qualifier == null || (value = qualifier.getValue()) == null) {
            value = "";
        }
        sb.append(value);
        sb.append(AbstractJsonLexerKt.COLON);
        sb.append(scopeQualifier);
        return this._instances.get(sb.toString());
    }

    public final /* synthetic */ <T> void scopeDeclaredInstance(T instance, Qualifier scopeQualifier, String scopeID, Qualifier qualifier, List<? extends KClass<?>> secondaryTypes, boolean allowOverride, boolean holdInstance) {
        String value;
        InstanceRegistry$scopeDeclaredInstance$definitionFunction$2 instanceRegistry$scopeDeclaredInstance$definitionFunction$2;
        String value2;
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Intrinsics.checkNotNullParameter(scopeID, "scopeID");
        Intrinsics.checkNotNullParameter(secondaryTypes, "secondaryTypes");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        StringBuilder sb = new StringBuilder();
        sb.append(KClassExtKt.getFullName(orCreateKotlinClass));
        sb.append(AbstractJsonLexerKt.COLON);
        if (qualifier == null || (value = qualifier.getValue()) == null) {
            value = "";
        }
        sb.append(value);
        sb.append(AbstractJsonLexerKt.COLON);
        sb.append(scopeQualifier);
        String string = sb.toString();
        InstanceFactory<?> instanceFactory = getInstances().get(string);
        ScopedInstanceFactory scopedInstanceFactory = instanceFactory instanceof ScopedInstanceFactory ? (ScopedInstanceFactory) instanceFactory : null;
        if (scopedInstanceFactory != null) {
            scopedInstanceFactory.saveValue(scopeID, instance);
            return;
        }
        if (holdInstance) {
            Intrinsics.needClassReification();
            instanceRegistry$scopeDeclaredInstance$definitionFunction$2 = new InstanceRegistry$scopeDeclaredInstance$definitionFunction$2(instance);
        } else {
            instanceRegistry$scopeDeclaredInstance$definitionFunction$2 = new InstanceRegistry$scopeDeclaredInstance$definitionFunction$1(orCreateKotlinClass);
        }
        Kind kind = Kind.Scoped;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        BeanDefinition beanDefinition = new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, instanceRegistry$scopeDeclaredInstance$definitionFunction$2, kind, secondaryTypes);
        ScopedInstanceFactory scopedInstanceFactory2 = new ScopedInstanceFactory(beanDefinition, holdInstance);
        ScopedInstanceFactory scopedInstanceFactory3 = scopedInstanceFactory2;
        saveMapping$default(this, allowOverride, string, scopedInstanceFactory3, false, 8, null);
        Iterator<T> it = beanDefinition.getSecondaryTypes().iterator();
        while (it.hasNext()) {
            KClass kClass = (KClass) it.next();
            Qualifier qualifier2 = beanDefinition.getQualifier();
            Qualifier scopeQualifier2 = beanDefinition.getScopeQualifier();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(KClassExtKt.getFullName(kClass));
            sb2.append(AbstractJsonLexerKt.COLON);
            if (qualifier2 == null || (value2 = qualifier2.getValue()) == null) {
                value2 = "";
            }
            sb2.append(value2);
            sb2.append(AbstractJsonLexerKt.COLON);
            sb2.append(scopeQualifier2);
            ScopedInstanceFactory scopedInstanceFactory4 = scopedInstanceFactory3;
            saveMapping$default(this, allowOverride, sb2.toString(), scopedInstanceFactory4, false, 8, null);
            scopedInstanceFactory3 = scopedInstanceFactory4;
        }
        scopedInstanceFactory2.saveValue(scopeID, instance);
    }
}

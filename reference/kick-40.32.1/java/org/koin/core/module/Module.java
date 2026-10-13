package org.koin.core.module;

import androidx.exifinterface.media.ExifInterface;
import expo.modules.interfaces.permissions.PermissionsResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.definition.KoinDefinition;
import org.koin.core.instance.FactoryInstanceFactory;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.qualifier.StringQualifier;
import org.koin.core.qualifier.TypeQualifier;
import org.koin.core.registry.ScopeRegistry;
import org.koin.core.scope.Scope;
import org.koin.dsl.ScopeDSL;
import org.koin.ext.KClassExtKt;
import org.koin.mp.KoinPlatformTools;
import org.koin.mp.KoinPlatformTools_jvmKt;

/* JADX INFO: compiled from: Module.kt */
/* JADX INFO: loaded from: classes11.dex */
@KoinDslMarker
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010)\u001a\u00020*2\u0012\u0010+\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000,\"\u00020\u0000¢\u0006\u0002\u0010-J\u0014\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00000.J)\u0010/\u001a\u00020*2\u0006\u00100\u001a\u00020!2\u0017\u00101\u001a\u0013\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020*02¢\u0006\u0002\b4H\u0007J-\u0010/\u001a\u00020*\"\u0006\b\u0000\u00105\u0018\u00012\u0017\u00101\u001a\u0013\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020*02¢\u0006\u0002\b4H\u0087\bø\u0001\u0000J[\u00106\u001a\b\u0012\u0004\u0012\u0002H507\"\u0006\b\u0000\u00105\u0018\u00012\n\b\u0002\u00100\u001a\u0004\u0018\u00010!2\b\b\u0002\u00108\u001a\u00020\u00032)\b\b\u00109\u001a#\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002H50:j\b\u0012\u0004\u0012\u0002H5`=¢\u0006\u0002\b4H\u0086\bø\u0001\u0000J\u0014\u0010>\u001a\u00020*2\n\u0010?\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0007J\u0014\u0010@\u001a\u00020*2\n\u0010?\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0007J\u0014\u0010A\u001a\u00020*2\n\u0010?\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0007J \u0010B\u001a\u00020*2\n\u0010C\u001a\u00060\u000bj\u0002`\u00192\n\u0010D\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0001JQ\u0010D\u001a\b\u0012\u0004\u0012\u0002H507\"\u0006\b\u0000\u00105\u0018\u00012\n\b\u0002\u00100\u001a\u0004\u0018\u00010!2)\b\b\u00109\u001a#\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002H50:j\b\u0012\u0004\u0012\u0002H5`=¢\u0006\u0002\b4H\u0086\bø\u0001\u0000JY\u0010D\u001a\b\u0012\u0004\u0012\u0002H507\"\u0006\b\u0000\u00105\u0018\u00012\n\b\u0002\u00100\u001a\u0004\u0018\u00010!2)\b\b\u00109\u001a#\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002H50:j\b\u0012\u0004\u0012\u0002H5`=¢\u0006\u0002\b42\u0006\u0010E\u001a\u00020!H\u0081\bø\u0001\u0000J\u0017\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00000G2\u0006\u0010+\u001a\u00020\u0000H\u0086\u0002J\u001d\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00000G2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00000GH\u0086\u0002J\u0013\u0010I\u001a\u00020\u00032\b\u0010J\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010K\u001a\u00020LH\u0016R\u001c\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rRT\u0010\u0012\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000fj\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0010`\u00112\u001e\u0010\u000e\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000fj\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0010`\u0011@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016RH\u0010\u0017\u001a.\u0012\b\u0012\u00060\u000bj\u0002`\u0019\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001a0\u0018j\u0016\u0012\b\u0012\u00060\u000bj\u0002`\u0019\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001a`\u001b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0007\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\tR,\u0010 \u001a\u0012\u0012\u0004\u0012\u00020!0\u000fj\b\u0012\u0004\u0012\u00020!`\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0007\u001a\u0004\b#\u0010\u0014R\"\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00000%8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0007\u001a\u0004\b'\u0010(\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006M"}, d2 = {"Lorg/koin/core/module/Module;", "", "_createdAtStart", "", "<init>", "(Z)V", "get_createdAtStart$annotations", "()V", "get_createdAtStart", "()Z", "id", "", "getId", "()Ljava/lang/String;", "value", "Ljava/util/LinkedHashSet;", "Lorg/koin/core/instance/SingleInstanceFactory;", "Lkotlin/collections/LinkedHashSet;", "eagerInstances", "getEagerInstances", "()Ljava/util/LinkedHashSet;", "setEagerInstances$koin_core", "(Ljava/util/LinkedHashSet;)V", "mappings", "Ljava/util/LinkedHashMap;", "Lorg/koin/core/definition/IndexKey;", "Lorg/koin/core/instance/InstanceFactory;", "Lkotlin/collections/LinkedHashMap;", "getMappings$annotations", "getMappings", "()Ljava/util/LinkedHashMap;", "isLoaded", "scopes", "Lorg/koin/core/qualifier/Qualifier;", "getScopes$annotations", "getScopes", "includedModules", "", "getIncludedModules$annotations", "getIncludedModules", "()Ljava/util/List;", "includes", "", "module", "", "([Lorg/koin/core/module/Module;)V", "", PermissionsResponse.SCOPE_KEY, "qualifier", "scopeSet", "Lkotlin/Function1;", "Lorg/koin/dsl/ScopeDSL;", "Lkotlin/ExtensionFunctionType;", ExifInterface.GPS_DIRECTION_TRUE, "single", "Lorg/koin/core/definition/KoinDefinition;", "createdAtStart", "definition", "Lkotlin/Function2;", "Lorg/koin/core/scope/Scope;", "Lorg/koin/core/parameter/ParametersHolder;", "Lorg/koin/core/definition/Definition;", "indexPrimaryType", "instanceFactory", "indexSecondaryTypes", "prepareForCreationAtStart", "saveMapping", "mapping", "factory", "scopeQualifier", "plus", "", "modules", "equals", "other", "hashCode", "", "koin-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Module {
    private final boolean _createdAtStart;
    private LinkedHashSet<SingleInstanceFactory<?>> eagerInstances;
    private final String id;
    private final List<Module> includedModules;
    private final LinkedHashMap<String, InstanceFactory<?>> mappings;
    private final LinkedHashSet<Qualifier> scopes;

    public Module() {
        this(false, 1, null);
    }

    public static /* synthetic */ void getIncludedModules$annotations() {
    }

    public static /* synthetic */ void getMappings$annotations() {
    }

    public static /* synthetic */ void getScopes$annotations() {
    }

    public static /* synthetic */ void get_createdAtStart$annotations() {
    }

    public Module(boolean z) {
        this._createdAtStart = z;
        this.id = KoinPlatformTools_jvmKt.generateId(KoinPlatformTools.INSTANCE);
        this.eagerInstances = new LinkedHashSet<>();
        this.mappings = new LinkedHashMap<>();
        this.scopes = new LinkedHashSet<>();
        this.includedModules = new ArrayList();
    }

    public /* synthetic */ Module(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public final boolean get_createdAtStart() {
        return this._createdAtStart;
    }

    public final String getId() {
        return this.id;
    }

    public final LinkedHashSet<SingleInstanceFactory<?>> getEagerInstances() {
        return this.eagerInstances;
    }

    public final void setEagerInstances$koin_core(LinkedHashSet<SingleInstanceFactory<?>> linkedHashSet) {
        Intrinsics.checkNotNullParameter(linkedHashSet, "<set-?>");
        this.eagerInstances = linkedHashSet;
    }

    public final LinkedHashMap<String, InstanceFactory<?>> getMappings() {
        return this.mappings;
    }

    public final boolean isLoaded() {
        return !this.mappings.isEmpty();
    }

    public final LinkedHashSet<Qualifier> getScopes() {
        return this.scopes;
    }

    public final List<Module> getIncludedModules() {
        return this.includedModules;
    }

    public final void includes(Module... module) {
        Intrinsics.checkNotNullParameter(module, "module");
        CollectionsKt.addAll(this.includedModules, module);
    }

    public final void includes(Collection<Module> module) {
        Intrinsics.checkNotNullParameter(module, "module");
        this.includedModules.addAll(module);
    }

    @KoinDslMarker
    public final void scope(Qualifier qualifier, Function1<? super ScopeDSL, Unit> scopeSet) {
        Intrinsics.checkNotNullParameter(qualifier, "qualifier");
        Intrinsics.checkNotNullParameter(scopeSet, "scopeSet");
        scopeSet.invoke(new ScopeDSL(qualifier, this));
        this.scopes.add(qualifier);
    }

    @KoinDslMarker
    public final /* synthetic */ <T> void scope(Function1<? super ScopeDSL, Unit> scopeSet) {
        Intrinsics.checkNotNullParameter(scopeSet, "scopeSet");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        TypeQualifier typeQualifier = new TypeQualifier(Reflection.getOrCreateKotlinClass(Object.class));
        scopeSet.invoke(new ScopeDSL(typeQualifier, this));
        getScopes().add(typeQualifier);
    }

    public static /* synthetic */ KoinDefinition single$default(Module module, Qualifier qualifier, boolean z, Function2 definition, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        Qualifier qualifier2 = qualifier;
        if ((i & 2) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(definition, "definition");
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier2, definition, kind, listEmptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (z || module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return new KoinDefinition(module, singleInstanceFactory2);
    }

    public final void indexPrimaryType(InstanceFactory<?> instanceFactory) {
        String value;
        Intrinsics.checkNotNullParameter(instanceFactory, "instanceFactory");
        BeanDefinition<?> beanDefinition = instanceFactory.getBeanDefinition();
        KClass<?> primaryType = beanDefinition.getPrimaryType();
        Qualifier qualifier = beanDefinition.getQualifier();
        Qualifier scopeQualifier = beanDefinition.getScopeQualifier();
        StringBuilder sb = new StringBuilder();
        sb.append(KClassExtKt.getFullName(primaryType));
        sb.append(AbstractJsonLexerKt.COLON);
        if (qualifier == null || (value = qualifier.getValue()) == null) {
            value = "";
        }
        sb.append(value);
        sb.append(AbstractJsonLexerKt.COLON);
        sb.append(scopeQualifier);
        saveMapping(sb.toString(), instanceFactory);
    }

    public final void indexSecondaryTypes(InstanceFactory<?> instanceFactory) {
        String value;
        Intrinsics.checkNotNullParameter(instanceFactory, "instanceFactory");
        BeanDefinition<?> beanDefinition = instanceFactory.getBeanDefinition();
        Iterator<T> it = beanDefinition.getSecondaryTypes().iterator();
        while (it.hasNext()) {
            KClass kClass = (KClass) it.next();
            Qualifier qualifier = beanDefinition.getQualifier();
            Qualifier scopeQualifier = beanDefinition.getScopeQualifier();
            StringBuilder sb = new StringBuilder();
            sb.append(KClassExtKt.getFullName(kClass));
            sb.append(AbstractJsonLexerKt.COLON);
            if (qualifier == null || (value = qualifier.getValue()) == null) {
                value = "";
            }
            sb.append(value);
            sb.append(AbstractJsonLexerKt.COLON);
            sb.append(scopeQualifier);
            saveMapping(sb.toString(), instanceFactory);
        }
    }

    public final void prepareForCreationAtStart(SingleInstanceFactory<?> instanceFactory) {
        Intrinsics.checkNotNullParameter(instanceFactory, "instanceFactory");
        this.eagerInstances.add(instanceFactory);
    }

    public final void saveMapping(String mapping, InstanceFactory<?> factory) {
        Intrinsics.checkNotNullParameter(mapping, "mapping");
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.mappings.put(mapping, factory);
    }

    public static /* synthetic */ KoinDefinition factory$default(Module module, Qualifier qualifier, Function2 definition, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        Intrinsics.checkNotNullParameter(definition, "definition");
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, definition, kind, listEmptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new KoinDefinition(module, factoryInstanceFactory);
    }

    public final /* synthetic */ <T> KoinDefinition<T> factory(Qualifier qualifier, Function2<? super Scope, ? super ParametersHolder, ? extends T> definition) {
        Intrinsics.checkNotNullParameter(definition, "definition");
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, definition, kind, listEmptyList));
        indexPrimaryType(factoryInstanceFactory);
        return new KoinDefinition<>(this, factoryInstanceFactory);
    }

    public static /* synthetic */ KoinDefinition factory$default(Module module, Qualifier qualifier, Function2 definition, Qualifier scopeQualifier, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        Intrinsics.checkNotNullParameter(definition, "definition");
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Kind kind = Kind.Factory;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, definition, kind, listEmptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new KoinDefinition(module, factoryInstanceFactory);
    }

    public final List<Module> plus(Module module) {
        Intrinsics.checkNotNullParameter(module, "module");
        return CollectionsKt.listOf((Object[]) new Module[]{this, module});
    }

    public final List<Module> plus(List<Module> modules) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        return CollectionsKt.plus((Collection) CollectionsKt.listOf(this), (Iterable) modules);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Module) {
            return Intrinsics.areEqual(this.id, ((Module) other).id);
        }
        return false;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public final /* synthetic */ <T> KoinDefinition<T> single(Qualifier qualifier, boolean createdAtStart, Function2<? super Scope, ? super ParametersHolder, ? extends T> definition) {
        Intrinsics.checkNotNullParameter(definition, "definition");
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, definition, kind, listEmptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        indexPrimaryType(singleInstanceFactory2);
        if (createdAtStart || get_createdAtStart()) {
            prepareForCreationAtStart(singleInstanceFactory);
        }
        return new KoinDefinition<>(this, singleInstanceFactory2);
    }

    public final /* synthetic */ <T> KoinDefinition<T> factory(Qualifier qualifier, Function2<? super Scope, ? super ParametersHolder, ? extends T> definition, Qualifier scopeQualifier) {
        Intrinsics.checkNotNullParameter(definition, "definition");
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Kind kind = Kind.Factory;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, definition, kind, listEmptyList));
        indexPrimaryType(factoryInstanceFactory);
        return new KoinDefinition<>(this, factoryInstanceFactory);
    }
}

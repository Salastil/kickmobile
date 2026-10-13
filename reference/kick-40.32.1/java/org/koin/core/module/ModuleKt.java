package org.koin.core.module;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.error.DefinitionOverrideException;
import org.koin.core.instance.FactoryInstanceFactory;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.instance.ScopedInstanceFactory;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.registry.ScopeRegistry;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: Module.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0001\u001a[\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\u0006\b\u0000\u0010\t\u0018\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2)\b\b\u0010\f\u001a#\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u0002H\t0\rj\b\u0012\u0004\u0012\u0002H\t`\u0011¢\u0006\u0002\b\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u000bH\u0087\bø\u0001\u0000\u001a[\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\t0\u0014\"\u0006\b\u0000\u0010\t\u0018\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2)\b\b\u0010\f\u001a#\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u0002H\t0\rj\b\u0012\u0004\u0012\u0002H\t`\u0011¢\u0006\u0002\b\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u000bH\u0087\bø\u0001\u0000\u001aY\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\t0\u0016\"\u0006\b\u0000\u0010\t\u0018\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2)\b\b\u0010\f\u001a#\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u0002H\t0\rj\b\u0012\u0004\u0012\u0002H\t`\u0011¢\u0006\u0002\b\u00102\u0006\u0010\u0012\u001a\u00020\u000bH\u0087\bø\u0001\u0000\u001a!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018*\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u0019H\u0086\u0002\u001a\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0007\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001e"}, d2 = {"overrideError", "", "factory", "Lorg/koin/core/instance/InstanceFactory;", "mapping", "", "Lorg/koin/core/definition/IndexKey;", "_singleInstanceFactory", "Lorg/koin/core/instance/SingleInstanceFactory;", ExifInterface.GPS_DIRECTION_TRUE, "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "definition", "Lkotlin/Function2;", "Lorg/koin/core/scope/Scope;", "Lorg/koin/core/parameter/ParametersHolder;", "Lkotlin/ExtensionFunctionType;", "Lorg/koin/core/definition/Definition;", "scopeQualifier", "_factoryInstanceFactory", "Lorg/koin/core/instance/FactoryInstanceFactory;", "_scopedInstanceFactory", "Lorg/koin/core/instance/ScopedInstanceFactory;", "plus", "", "Lorg/koin/core/module/Module;", "module", "flatten", "", "modules", "koin-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ModuleKt {
    public static final void overrideError(InstanceFactory<?> factory, String mapping) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(mapping, "mapping");
        throw new DefinitionOverrideException("Already existing definition for " + factory.getBeanDefinition() + " at " + mapping);
    }

    public static /* synthetic */ SingleInstanceFactory _singleInstanceFactory$default(Qualifier qualifier, Function2 definition, Qualifier qualifier2, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        Qualifier qualifier3 = qualifier;
        if ((i & 4) != 0) {
            qualifier2 = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        }
        Qualifier scopeQualifier = qualifier2;
        Intrinsics.checkNotNullParameter(definition, "definition");
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Kind kind = Kind.Singleton;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new SingleInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier3, definition, kind, listEmptyList));
    }

    public static final /* synthetic */ <T> SingleInstanceFactory<T> _singleInstanceFactory(Qualifier qualifier, Function2<? super Scope, ? super ParametersHolder, ? extends T> definition, Qualifier scopeQualifier) {
        Intrinsics.checkNotNullParameter(definition, "definition");
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Kind kind = Kind.Singleton;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new SingleInstanceFactory<>(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, definition, kind, listEmptyList));
    }

    public static /* synthetic */ FactoryInstanceFactory _factoryInstanceFactory$default(Qualifier qualifier, Function2 definition, Qualifier qualifier2, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        Qualifier qualifier3 = qualifier;
        if ((i & 4) != 0) {
            qualifier2 = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        }
        Qualifier scopeQualifier = qualifier2;
        Intrinsics.checkNotNullParameter(definition, "definition");
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Kind kind = Kind.Factory;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier3, definition, kind, listEmptyList));
    }

    public static final /* synthetic */ <T> FactoryInstanceFactory<T> _factoryInstanceFactory(Qualifier qualifier, Function2<? super Scope, ? super ParametersHolder, ? extends T> definition, Qualifier scopeQualifier) {
        Intrinsics.checkNotNullParameter(definition, "definition");
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Kind kind = Kind.Factory;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new FactoryInstanceFactory<>(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, definition, kind, listEmptyList));
    }

    public static /* synthetic */ ScopedInstanceFactory _scopedInstanceFactory$default(Qualifier qualifier, Function2 definition, Qualifier scopeQualifier, int i, Object obj) {
        DefaultConstructorMarker defaultConstructorMarker = null;
        Qualifier qualifier2 = (i & 1) != 0 ? null : qualifier;
        Intrinsics.checkNotNullParameter(definition, "definition");
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier2, definition, kind, listEmptyList), false, 2, defaultConstructorMarker);
    }

    public static final /* synthetic */ <T> ScopedInstanceFactory<T> _scopedInstanceFactory(Qualifier qualifier, Function2<? super Scope, ? super ParametersHolder, ? extends T> definition, Qualifier scopeQualifier) {
        Intrinsics.checkNotNullParameter(definition, "definition");
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new ScopedInstanceFactory<>(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, definition, kind, listEmptyList), false, 2, null);
    }

    public static final List<Module> plus(List<Module> list, Module module) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(module, "module");
        return CollectionsKt.plus((Collection) list, (Iterable) CollectionsKt.listOf(module));
    }

    public static final Set<Module> flatten(List<Module> modules) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayDeque arrayDeque = new ArrayDeque(CollectionsKt.asReversed(modules));
        while (true) {
            ArrayDeque arrayDeque2 = arrayDeque;
            if (!arrayDeque2.isEmpty()) {
                Module module = (Module) arrayDeque.removeLast();
                if (linkedHashSet.add(module)) {
                    for (Module module2 : module.getIncludedModules()) {
                        if (!linkedHashSet.contains(module2)) {
                            arrayDeque2.add(module2);
                        }
                    }
                }
            } else {
                return linkedHashSet;
            }
        }
    }
}

package org.koin.core.definition;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.module.KoinDslMarker;
import org.koin.core.module.Module;

/* JADX INFO: compiled from: KoinDefinition.kt */
/* JADX INFO: loaded from: classes11.dex */
@KoinDslMarker
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006HÆ\u0003J)\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lorg/koin/core/definition/KoinDefinition;", "R", "", "module", "Lorg/koin/core/module/Module;", "factory", "Lorg/koin/core/instance/InstanceFactory;", "<init>", "(Lorg/koin/core/module/Module;Lorg/koin/core/instance/InstanceFactory;)V", "getModule", "()Lorg/koin/core/module/Module;", "getFactory", "()Lorg/koin/core/instance/InstanceFactory;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "koin-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class KoinDefinition<R> {
    private final InstanceFactory<R> factory;
    private final Module module;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ KoinDefinition copy$default(KoinDefinition koinDefinition, Module module, InstanceFactory instanceFactory, int i, Object obj) {
        if ((i & 1) != 0) {
            module = koinDefinition.module;
        }
        if ((i & 2) != 0) {
            instanceFactory = koinDefinition.factory;
        }
        return koinDefinition.copy(module, instanceFactory);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Module getModule() {
        return this.module;
    }

    public final InstanceFactory<R> component2() {
        return this.factory;
    }

    public final KoinDefinition<R> copy(Module module, InstanceFactory<R> factory) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(factory, "factory");
        return new KoinDefinition<>(module, factory);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KoinDefinition)) {
            return false;
        }
        KoinDefinition koinDefinition = (KoinDefinition) other;
        return Intrinsics.areEqual(this.module, koinDefinition.module) && Intrinsics.areEqual(this.factory, koinDefinition.factory);
    }

    public int hashCode() {
        return (this.module.hashCode() * 31) + this.factory.hashCode();
    }

    public String toString() {
        return "KoinDefinition(module=" + this.module + ", factory=" + this.factory + ')';
    }

    public KoinDefinition(Module module, InstanceFactory<R> factory) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.module = module;
        this.factory = factory;
    }

    public final InstanceFactory<R> getFactory() {
        return this.factory;
    }

    public final Module getModule() {
        return this.module;
    }
}

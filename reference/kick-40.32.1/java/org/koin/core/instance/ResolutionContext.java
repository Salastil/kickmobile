package org.koin.core.instance;

import expo.modules.interfaces.permissions.PermissionsResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.koin.core.logger.Logger;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.qualifier.TypeQualifier;
import org.koin.core.scope.Scope;
import org.koin.ext.KClassExtKt;

/* JADX INFO: compiled from: ResolutionContext.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006$"}, d2 = {"Lorg/koin/core/instance/ResolutionContext;", "", "logger", "Lorg/koin/core/logger/Logger;", PermissionsResponse.SCOPE_KEY, "Lorg/koin/core/scope/Scope;", "clazz", "Lkotlin/reflect/KClass;", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "parameters", "Lorg/koin/core/parameter/ParametersHolder;", "<init>", "(Lorg/koin/core/logger/Logger;Lorg/koin/core/scope/Scope;Lkotlin/reflect/KClass;Lorg/koin/core/qualifier/Qualifier;Lorg/koin/core/parameter/ParametersHolder;)V", "getLogger", "()Lorg/koin/core/logger/Logger;", "getScope", "()Lorg/koin/core/scope/Scope;", "getClazz", "()Lkotlin/reflect/KClass;", "getQualifier", "()Lorg/koin/core/qualifier/Qualifier;", "getParameters", "()Lorg/koin/core/parameter/ParametersHolder;", "debugTag", "", "getDebugTag", "()Ljava/lang/String;", "scopeArchetype", "Lorg/koin/core/qualifier/TypeQualifier;", "getScopeArchetype", "()Lorg/koin/core/qualifier/TypeQualifier;", "setScopeArchetype", "(Lorg/koin/core/qualifier/TypeQualifier;)V", "newContextForScope", "s", "koin-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResolutionContext {
    private final KClass<?> clazz;
    private final String debugTag;
    private final Logger logger;
    private final ParametersHolder parameters;
    private final Qualifier qualifier;
    private final Scope scope;
    private TypeQualifier scopeArchetype;

    public ResolutionContext(Logger logger, Scope scope, KClass<?> clazz, Qualifier qualifier, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        this.logger = logger;
        this.scope = scope;
        this.clazz = clazz;
        this.qualifier = qualifier;
        this.parameters = parametersHolder;
        this.debugTag = "t:'" + KClassExtKt.getFullName(clazz) + "' - q:'" + qualifier + '\'';
    }

    public /* synthetic */ ResolutionContext(Logger logger, Scope scope, KClass kClass, Qualifier qualifier, ParametersHolder parametersHolder, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(logger, scope, kClass, (i & 8) != 0 ? null : qualifier, (i & 16) != 0 ? null : parametersHolder);
    }

    public final Logger getLogger() {
        return this.logger;
    }

    public final Scope getScope() {
        return this.scope;
    }

    public final KClass<?> getClazz() {
        return this.clazz;
    }

    public final Qualifier getQualifier() {
        return this.qualifier;
    }

    public final ParametersHolder getParameters() {
        return this.parameters;
    }

    public final String getDebugTag() {
        return this.debugTag;
    }

    public final TypeQualifier getScopeArchetype() {
        return this.scopeArchetype;
    }

    public final void setScopeArchetype(TypeQualifier typeQualifier) {
        this.scopeArchetype = typeQualifier;
    }

    public final ResolutionContext newContextForScope(Scope s) {
        Intrinsics.checkNotNullParameter(s, "s");
        ResolutionContext resolutionContext = new ResolutionContext(this.logger, s, this.clazz, this.qualifier, this.parameters);
        resolutionContext.scopeArchetype = s.getScopeArchetype();
        return resolutionContext;
    }
}

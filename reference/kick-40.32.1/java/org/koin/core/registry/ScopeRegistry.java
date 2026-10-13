package org.koin.core.registry;

import expo.modules.interfaces.permissions.PermissionsResponse;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.Koin;
import org.koin.core.error.ScopeAlreadyCreatedException;
import org.koin.core.module.Module;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.qualifier.QualifierKt;
import org.koin.core.qualifier.StringQualifier;
import org.koin.core.qualifier.TypeQualifier;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTools;

/* JADX INFO: compiled from: ScopeRegistry.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 *2\u00020\u0001:\u0001*B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00112\n\u0010\u0018\u001a\u00060\u000fj\u0002`\u0010H\u0001J4\u0010\u0019\u001a\u00020\u00112\n\u0010\u0018\u001a\u00060\u000fj\u0002`\u00102\u0006\u0010\u001a\u001a\u00020\b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\n\u0010\u0018\u001a\u00060\u000fj\u0002`\u0010H\u0000¢\u0006\u0002\b J\u0015\u0010\u001e\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0011H\u0000¢\u0006\u0002\b J\r\u0010\"\u001a\u00020\u001fH\u0000¢\u0006\u0002\b#J\b\u0010$\u001a\u00020\u001fH\u0002J\u0014\u0010%\u001a\u00020\u001f2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\nJ\u0010\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020'H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u0012\u0012\b\u0012\u00060\u000fj\u0002`\u0010\u0012\u0004\u0012\u00020\u00110\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006+"}, d2 = {"Lorg/koin/core/registry/ScopeRegistry;", "", "_koin", "Lorg/koin/core/Koin;", "<init>", "(Lorg/koin/core/Koin;)V", "_scopeDefinitions", "", "Lorg/koin/core/qualifier/Qualifier;", "scopeDefinitions", "", "getScopeDefinitions", "()Ljava/util/Set;", "_scopes", "", "", "Lorg/koin/core/scope/ScopeID;", "Lorg/koin/core/scope/Scope;", "rootScope", "getRootScope$annotations", "()V", "getRootScope", "()Lorg/koin/core/scope/Scope;", "getScopeOrNull", "scopeId", "createScope", "qualifier", "source", "scopeArchetype", "Lorg/koin/core/qualifier/TypeQualifier;", "deleteScope", "", "deleteScope$koin_core", PermissionsResponse.SCOPE_KEY, "close", "close$koin_core", "closeAllScopes", "loadScopes", "modules", "Lorg/koin/core/module/Module;", "loadModule", "module", "Companion", "koin-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScopeRegistry {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String ROOT_SCOPE_ID = "_root_";
    private static final StringQualifier rootScopeQualifier = QualifierKt._q(ROOT_SCOPE_ID);
    private final Koin _koin;
    private final Set<Qualifier> _scopeDefinitions;
    private final Map<String, Scope> _scopes;
    private final Scope rootScope;

    public static /* synthetic */ void getRootScope$annotations() {
    }

    public ScopeRegistry(Koin _koin) {
        Intrinsics.checkNotNullParameter(_koin, "_koin");
        this._koin = _koin;
        Set<Qualifier> setSafeSet = KoinPlatformTools.INSTANCE.safeSet();
        this._scopeDefinitions = setSafeSet;
        Map<String, Scope> mapSafeHashMap = KoinPlatformTools.INSTANCE.safeHashMap();
        this._scopes = mapSafeHashMap;
        Scope scope = new Scope(rootScopeQualifier, ROOT_SCOPE_ID, true, null, _koin, 8, null);
        this.rootScope = scope;
        setSafeSet.add(scope.getScopeQualifier());
        mapSafeHashMap.put(scope.getId(), scope);
    }

    public final Set<Qualifier> getScopeDefinitions() {
        return this._scopeDefinitions;
    }

    public final Scope getRootScope() {
        return this.rootScope;
    }

    public final Scope getScopeOrNull(String scopeId) {
        Intrinsics.checkNotNullParameter(scopeId, "scopeId");
        return this._scopes.get(scopeId);
    }

    public static /* synthetic */ Scope createScope$default(ScopeRegistry scopeRegistry, String str, Qualifier qualifier, Object obj, TypeQualifier typeQualifier, int i, Object obj2) {
        if ((i & 4) != 0) {
            obj = null;
        }
        if ((i & 8) != 0) {
            typeQualifier = null;
        }
        return scopeRegistry.createScope(str, qualifier, obj, typeQualifier);
    }

    public final Scope createScope(String scopeId, Qualifier qualifier, Object source, TypeQualifier scopeArchetype) throws ScopeAlreadyCreatedException {
        Intrinsics.checkNotNullParameter(scopeId, "scopeId");
        Intrinsics.checkNotNullParameter(qualifier, "qualifier");
        this._koin.getLogger().debug("| (+) Scope - id:'" + scopeId + "' q:'" + qualifier + '\'');
        if (!this._scopeDefinitions.contains(qualifier)) {
            this._koin.getLogger().debug("| Scope '" + qualifier + "' not defined. Creating it ...");
            this._scopeDefinitions.add(qualifier);
        }
        if (this._scopes.containsKey(scopeId)) {
            throw new ScopeAlreadyCreatedException("Scope with id '" + scopeId + "' is already created");
        }
        Scope scope = new Scope(qualifier, scopeId, false, scopeArchetype, this._koin, 4, null);
        if (source != null) {
            this._koin.getLogger().debug("|- Scope source set id:'" + scopeId + "' -> " + source);
            scope.setSourceValue(source);
        }
        scope.linkTo(this.rootScope);
        this._scopes.put(scopeId, scope);
        return scope;
    }

    public final void deleteScope$koin_core(String scopeId) {
        Intrinsics.checkNotNullParameter(scopeId, "scopeId");
        Scope scope = this._scopes.get(scopeId);
        if (scope != null) {
            deleteScope$koin_core(scope);
        }
    }

    public final void deleteScope$koin_core(Scope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this._koin.getInstanceRegistry().dropScopeInstances$koin_core(scope);
        this._scopes.remove(scope.getId());
    }

    public final void close$koin_core() {
        closeAllScopes();
        this._scopes.clear();
        this._scopeDefinitions.clear();
    }

    private final void closeAllScopes() {
        for (Object obj : this._scopes.values().toArray(new Scope[0])) {
            ((Scope) obj).close();
        }
    }

    public final void loadScopes(Set<Module> modules) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        Iterator<T> it = modules.iterator();
        while (it.hasNext()) {
            loadModule((Module) it.next());
        }
    }

    private final void loadModule(Module module) {
        this._scopeDefinitions.addAll(module.getScopes());
    }

    /* JADX INFO: compiled from: ScopeRegistry.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lorg/koin/core/registry/ScopeRegistry$Companion;", "", "<init>", "()V", "ROOT_SCOPE_ID", "", "rootScopeQualifier", "Lorg/koin/core/qualifier/StringQualifier;", "getRootScopeQualifier$annotations", "getRootScopeQualifier", "()Lorg/koin/core/qualifier/StringQualifier;", "koin-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getRootScopeQualifier$annotations() {
        }

        private Companion() {
        }

        public final StringQualifier getRootScopeQualifier() {
            return ScopeRegistry.rootScopeQualifier;
        }
    }
}

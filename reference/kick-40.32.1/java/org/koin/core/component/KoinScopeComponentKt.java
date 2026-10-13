package org.koin.core.component;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.Koin;
import org.koin.core.qualifier.TypeQualifier;
import org.koin.core.scope.Scope;
import org.koin.ext.KClassExtKt;

/* JADX INFO: compiled from: KoinScopeComponent.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u0002¢\u0006\u0002\u0010\u0004\u001a\u0019\u0010\u0005\u001a\u00020\u0006\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u0002¢\u0006\u0002\u0010\u0007\u001a?\u0010\b\u001a\u00020\t\"\b\b\u0000\u0010\u0002*\u00020\n*\u0002H\u00022\f\b\u0002\u0010\u000b\u001a\u00060\u0001j\u0002`\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000f\u001a%\u0010\b\u001a\u00020\t\"\b\b\u0000\u0010\u0002*\u00020\n*\u0002H\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0010\u001a\u001b\u0010\u0011\u001a\u0004\u0018\u00010\t\"\b\b\u0000\u0010\u0002*\u00020\n*\u0002H\u0002¢\u0006\u0002\u0010\u0012\u001a\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0014\"\b\b\u0000\u0010\u0002*\u00020\n*\u0002H\u0002¢\u0006\u0002\u0010\u0015\u001a\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u0014\"\b\b\u0000\u0010\u0002*\u00020\n*\u0002H\u0002¢\u0006\u0002\u0010\u0015¨\u0006\u0017"}, d2 = {"getScopeId", "", ExifInterface.GPS_DIRECTION_TRUE, "", "(Ljava/lang/Object;)Ljava/lang/String;", "getScopeName", "Lorg/koin/core/qualifier/TypeQualifier;", "(Ljava/lang/Object;)Lorg/koin/core/qualifier/TypeQualifier;", "createScope", "Lorg/koin/core/scope/Scope;", "Lorg/koin/core/component/KoinScopeComponent;", "scopeId", "Lorg/koin/core/scope/ScopeID;", "source", "scopeArchetype", "(Lorg/koin/core/component/KoinScopeComponent;Ljava/lang/String;Ljava/lang/Object;Lorg/koin/core/qualifier/TypeQualifier;)Lorg/koin/core/scope/Scope;", "(Lorg/koin/core/component/KoinScopeComponent;Ljava/lang/Object;)Lorg/koin/core/scope/Scope;", "getScopeOrNull", "(Lorg/koin/core/component/KoinScopeComponent;)Lorg/koin/core/scope/Scope;", "newScope", "Lkotlin/Lazy;", "(Lorg/koin/core/component/KoinScopeComponent;)Lkotlin/Lazy;", "getOrCreateScope", "koin-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class KoinScopeComponentKt {
    public static final <T> String getScopeId(T t) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        return KClassExtKt.getFullName(Reflection.getOrCreateKotlinClass(t.getClass())) + '@' + t.hashCode();
    }

    public static final <T> TypeQualifier getScopeName(T t) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        return new TypeQualifier(Reflection.getOrCreateKotlinClass(t.getClass()));
    }

    public static /* synthetic */ Scope createScope$default(KoinScopeComponent koinScopeComponent, String str, Object obj, TypeQualifier typeQualifier, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = getScopeId(koinScopeComponent);
        }
        if ((i & 2) != 0) {
            obj = null;
        }
        if ((i & 4) != 0) {
            typeQualifier = null;
        }
        return createScope(koinScopeComponent, str, obj, typeQualifier);
    }

    public static final <T extends KoinScopeComponent> Scope createScope(T t, String scopeId, Object obj, TypeQualifier typeQualifier) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(scopeId, "scopeId");
        return t.getKoin().createScope(scopeId, getScopeName(t), obj, typeQualifier);
    }

    public static /* synthetic */ Scope createScope$default(KoinScopeComponent koinScopeComponent, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return createScope(koinScopeComponent, obj);
    }

    public static final <T extends KoinScopeComponent> Scope createScope(T t, Object obj) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        return Koin.createScope$default(t.getKoin(), getScopeId(t), getScopeName(t), obj, null, 8, null);
    }

    public static final <T extends KoinScopeComponent> Scope getScopeOrNull(T t) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        return t.getKoin().getScopeOrNull(getScopeId(t));
    }

    public static final <T extends KoinScopeComponent> Lazy<Scope> newScope(final T t) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        return LazyKt.lazy(new Function0() { // from class: org.koin.core.component.KoinScopeComponentKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return KoinScopeComponentKt.createScope$default(t, null, 1, null);
            }
        });
    }

    public static final <T extends KoinScopeComponent> Lazy<Scope> getOrCreateScope(final T t) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        return LazyKt.lazy(new Function0() { // from class: org.koin.core.component.KoinScopeComponentKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return KoinScopeComponentKt.getOrCreateScope$lambda$1(t);
            }
        });
    }

    static final Scope getOrCreateScope$lambda$1(KoinScopeComponent koinScopeComponent) {
        Scope scopeOrNull = getScopeOrNull(koinScopeComponent);
        return scopeOrNull == null ? createScope$default(koinScopeComponent, null, 1, null) : scopeOrNull;
    }
}

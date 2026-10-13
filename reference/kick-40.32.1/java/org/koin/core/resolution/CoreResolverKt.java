package org.koin.core.resolution;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: CoreResolver.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"flatten", "", "Lorg/koin/core/scope/Scope;", "scopes", "", "koin-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CoreResolverKt {
    public static final Set<Scope> flatten(List<Scope> scopes) {
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayDeque arrayDeque = new ArrayDeque(CollectionsKt.asReversed(scopes));
        while (true) {
            ArrayDeque arrayDeque2 = arrayDeque;
            if (!arrayDeque2.isEmpty()) {
                Scope scope = (Scope) arrayDeque.removeLast();
                if (linkedHashSet.add(scope)) {
                    Iterator<Scope> it = scope.getLinkedScopes$koin_core().iterator();
                    Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                    while (it.hasNext()) {
                        Scope next = it.next();
                        Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                        Scope scope2 = next;
                        if (!linkedHashSet.contains(scope2)) {
                            arrayDeque2.add(scope2);
                        }
                    }
                }
            } else {
                return linkedHashSet;
            }
        }
    }
}

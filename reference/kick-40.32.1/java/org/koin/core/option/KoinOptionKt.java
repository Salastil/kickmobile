package org.koin.core.option;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.registry.OptionRegistry;

/* JADX INFO: compiled from: KoinOption.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u001a\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"viewModelScopeFactory", "Lkotlin/Pair;", "Lorg/koin/core/option/KoinOption;", "", "hasViewModelScopeFactory", "Lorg/koin/core/registry/OptionRegistry;", "koin-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class KoinOptionKt {
    public static final Pair<KoinOption, Boolean> viewModelScopeFactory() {
        return TuplesKt.to(KoinOption.VIEWMODEL_SCOPE_FACTORY, true);
    }

    public static final boolean hasViewModelScopeFactory(OptionRegistry optionRegistry) {
        Intrinsics.checkNotNullParameter(optionRegistry, "<this>");
        return Intrinsics.areEqual(optionRegistry.getOrNull$koin_core(KoinOption.VIEWMODEL_SCOPE_FACTORY), (Object) true);
    }
}

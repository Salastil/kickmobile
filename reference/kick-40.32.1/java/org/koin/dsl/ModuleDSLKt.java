package org.koin.dsl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.module.KoinDslMarker;
import org.koin.core.module.Module;

/* JADX INFO: compiled from: ModuleDSL.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a/\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u001b\u0010\b\u001a\u0017\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\t¢\u0006\u0002\b\u0004H\u0007*,\u0010\u0000\"\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¨\u0006\n"}, d2 = {"ModuleDeclaration", "Lkotlin/Function1;", "Lorg/koin/core/module/Module;", "", "Lkotlin/ExtensionFunctionType;", "module", "createdAtStart", "", "moduleDeclaration", "Lorg/koin/dsl/ModuleDeclaration;", "koin-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ModuleDSLKt {
    public static /* synthetic */ Module module$default(boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return module(z, function1);
    }

    @KoinDslMarker
    public static final Module module(boolean z, Function1<? super Module, Unit> moduleDeclaration) {
        Intrinsics.checkNotNullParameter(moduleDeclaration, "moduleDeclaration");
        Module module = new Module(z);
        moduleDeclaration.invoke(module);
        return module;
    }
}

package org.koin.dsl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.koin.core.KoinApplication;
import org.koin.core.module.KoinApplicationDslMarker;

/* JADX INFO: compiled from: KoinApplication.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a5\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00072!\b\u0002\u0010\b\u001a\u001b\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001j\u0004\u0018\u0001`\t¢\u0006\u0002\b\u0004H\u0007\u001a)\u0010\u0005\u001a\u00020\u00022\u001f\u0010\b\u001a\u001b\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001j\u0004\u0018\u0001`\t¢\u0006\u0002\b\u0004H\u0007\u001a\u0012\u0010\u0005\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007\u001a\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0007*,\u0010\u0000\"\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¨\u0006\f"}, d2 = {"KoinAppDeclaration", "Lkotlin/Function1;", "Lorg/koin/core/KoinApplication;", "", "Lkotlin/ExtensionFunctionType;", "koinApplication", "createEagerInstances", "", "appDeclaration", "Lorg/koin/dsl/KoinAppDeclaration;", "configuration", "Lorg/koin/dsl/KoinConfiguration;", "koin-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class KoinApplicationKt {
    public static /* synthetic */ KoinApplication koinApplication$default(boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            function1 = null;
        }
        return koinApplication(z, function1);
    }

    @KoinApplicationDslMarker
    public static final KoinApplication koinApplication(boolean z, Function1<? super KoinApplication, Unit> function1) {
        KoinApplication koinApplicationInit = KoinApplication.INSTANCE.init();
        if (function1 != null) {
            function1.invoke(koinApplicationInit);
        }
        if (z) {
            koinApplicationInit.createEagerInstances();
        }
        return koinApplicationInit;
    }

    @KoinApplicationDslMarker
    public static final KoinApplication koinApplication(Function1<? super KoinApplication, Unit> function1) {
        return koinApplication(true, function1);
    }

    @KoinApplicationDslMarker
    public static final KoinApplication koinApplication(KoinConfiguration koinConfiguration) {
        return koinApplication(true, koinConfiguration != null ? koinConfiguration.invoke() : null);
    }

    @KoinApplicationDslMarker
    public static final KoinApplication koinApplication(boolean z) {
        return koinApplication(z, null);
    }
}

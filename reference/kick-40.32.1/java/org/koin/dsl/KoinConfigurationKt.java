package org.koin.dsl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.KoinApplication;
import org.koin.core.module.KoinApplicationDslMarker;

/* JADX INFO: compiled from: KoinConfiguration.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a%\u0010\u0000\u001a\u00020\u00012\u001b\u0010\u0002\u001a\u0017\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u0002`\u0007¢\u0006\u0002\b\u0006H\u0007\u001aU\u0010\b\u001a\u00020\u0004*\u00020\u00042D\u0010\t\u001a#\u0012\u001f\b\u0001\u0012\u001b\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003j\u0004\u0018\u0001`\u0007¢\u0006\u0002\b\u00060\n\"\u001b\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003j\u0004\u0018\u0001`\u0007¢\u0006\u0002\b\u0006¢\u0006\u0002\u0010\u000b\u001a'\u0010\b\u001a\u00020\u0004*\u00020\u00042\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\n\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"koinConfiguration", "Lorg/koin/dsl/KoinConfiguration;", "declaration", "Lkotlin/Function1;", "Lorg/koin/core/KoinApplication;", "", "Lkotlin/ExtensionFunctionType;", "Lorg/koin/dsl/KoinAppDeclaration;", "includes", "configurations", "", "(Lorg/koin/core/KoinApplication;[Lkotlin/jvm/functions/Function1;)Lorg/koin/core/KoinApplication;", "(Lorg/koin/core/KoinApplication;[Lorg/koin/dsl/KoinConfiguration;)Lorg/koin/core/KoinApplication;", "koin-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class KoinConfigurationKt {
    @KoinApplicationDslMarker
    public static final KoinConfiguration koinConfiguration(Function1<? super KoinApplication, Unit> declaration) {
        Intrinsics.checkNotNullParameter(declaration, "declaration");
        return new KoinConfiguration(declaration);
    }

    public static final KoinApplication includes(KoinApplication koinApplication, Function1<? super KoinApplication, Unit>... configurations) {
        Intrinsics.checkNotNullParameter(koinApplication, "<this>");
        Intrinsics.checkNotNullParameter(configurations, "configurations");
        for (Function1<? super KoinApplication, Unit> function1 : configurations) {
            if (function1 != null) {
                function1.invoke(koinApplication);
            }
        }
        return koinApplication;
    }

    public static final KoinApplication includes(KoinApplication koinApplication, KoinConfiguration... configurations) {
        Function1<KoinApplication, Unit> config;
        Intrinsics.checkNotNullParameter(koinApplication, "<this>");
        Intrinsics.checkNotNullParameter(configurations, "configurations");
        for (KoinConfiguration koinConfiguration : configurations) {
            if (koinConfiguration != null && (config = koinConfiguration.getConfig()) != null) {
                config.invoke(koinApplication);
            }
        }
        return koinApplication;
    }
}

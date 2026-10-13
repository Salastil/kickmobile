package org.koin.dsl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.KoinApplication;
import org.koin.core.module.KoinApplicationDslMarker;

/* JADX INFO: compiled from: KoinConfiguration.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B \u0012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\u0002R\"\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\"\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lorg/koin/dsl/KoinConfiguration;", "", "config", "Lkotlin/Function1;", "Lorg/koin/core/KoinApplication;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getConfig", "()Lkotlin/jvm/functions/Function1;", "invoke", "appDeclaration", "getAppDeclaration", "koin-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
@KoinApplicationDslMarker
public final class KoinConfiguration {
    private final Function1<KoinApplication, Unit> appDeclaration;
    private final Function1<KoinApplication, Unit> config;

    /* JADX WARN: Multi-variable type inference failed */
    public KoinConfiguration(Function1<? super KoinApplication, Unit> config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        this.appDeclaration = invoke();
    }

    public final Function1<KoinApplication, Unit> getConfig() {
        return this.config;
    }

    public final Function1<KoinApplication, Unit> invoke() {
        return this.config;
    }

    public final Function1<KoinApplication, Unit> getAppDeclaration() {
        return this.appDeclaration;
    }
}

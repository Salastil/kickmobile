package org.koin.core.context;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.KoinApplication;
import org.koin.core.module.KoinApplicationDslMarker;
import org.koin.core.module.Module;
import org.koin.dsl.KoinConfiguration;
import org.koin.mp.KoinPlatformTools;

/* JADX INFO: compiled from: DefaultContextExt.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u001a%\u0010\u0000\u001a\u00020\u00012\u001b\u0010\u0003\u001a\u0017\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0007¢\u0006\u0002\b\u0006H\u0007\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0007\u001a\u0006\u0010\n\u001a\u00020\u0005\u001a\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r\u001a\u0014\u0010\u000b\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f\u001a\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r\u001a\u0014\u0010\u0010\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f¨\u0006\u0011"}, d2 = {"startKoin", "Lorg/koin/core/KoinApplication;", "koinApplication", "appDeclaration", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Lorg/koin/dsl/KoinAppDeclaration;", "appConfiguration", "Lorg/koin/dsl/KoinConfiguration;", "stopKoin", "loadKoinModules", "module", "Lorg/koin/core/module/Module;", "modules", "", "unloadKoinModules", "koin-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class DefaultContextExtKt {
    @KoinApplicationDslMarker
    public static final KoinApplication startKoin(KoinApplication koinApplication) {
        Intrinsics.checkNotNullParameter(koinApplication, "koinApplication");
        return KoinPlatformTools.INSTANCE.defaultContext().startKoin(koinApplication);
    }

    @KoinApplicationDslMarker
    public static final KoinApplication startKoin(Function1<? super KoinApplication, Unit> appDeclaration) {
        Intrinsics.checkNotNullParameter(appDeclaration, "appDeclaration");
        return KoinPlatformTools.INSTANCE.defaultContext().startKoin(appDeclaration);
    }

    @KoinApplicationDslMarker
    public static final KoinApplication startKoin(KoinConfiguration appConfiguration) {
        Intrinsics.checkNotNullParameter(appConfiguration, "appConfiguration");
        return KoinPlatformTools.INSTANCE.defaultContext().startKoin(appConfiguration.getConfig());
    }

    public static final void stopKoin() {
        KoinPlatformTools.INSTANCE.defaultContext().stopKoin();
    }

    public static final void loadKoinModules(Module module) {
        Intrinsics.checkNotNullParameter(module, "module");
        KoinContext.DefaultImpls.loadKoinModules$default(KoinPlatformTools.INSTANCE.defaultContext(), module, false, 2, (Object) null);
    }

    public static final void loadKoinModules(List<Module> modules) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        KoinContext.DefaultImpls.loadKoinModules$default(KoinPlatformTools.INSTANCE.defaultContext(), (List) modules, false, 2, (Object) null);
    }

    public static final void unloadKoinModules(Module module) {
        Intrinsics.checkNotNullParameter(module, "module");
        KoinPlatformTools.INSTANCE.defaultContext().unloadKoinModules(module);
    }

    public static final void unloadKoinModules(List<Module> modules) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        KoinPlatformTools.INSTANCE.defaultContext().unloadKoinModules(modules);
    }
}

package org.koin.core.context;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.koin.core.Koin;
import org.koin.core.KoinApplication;
import org.koin.core.module.Module;

/* JADX INFO: compiled from: KoinContext.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J%\u0010\u0007\u001a\u00020\b2\u001b\u0010\n\u001a\u0017\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u000bj\u0002`\r¢\u0006\u0002\b\fH&J\u001a\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H&J \u0010\u000e\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\b\b\u0002\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0016\u0010\u0015\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014H&¨\u0006\u0016"}, d2 = {"Lorg/koin/core/context/KoinContext;", "", "get", "Lorg/koin/core/Koin;", "getOrNull", "stopKoin", "", "startKoin", "Lorg/koin/core/KoinApplication;", "koinApplication", "appDeclaration", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "Lorg/koin/dsl/KoinAppDeclaration;", "loadKoinModules", "module", "Lorg/koin/core/module/Module;", "createEagerInstances", "", "modules", "", "unloadKoinModules", "koin-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface KoinContext {
    Koin get();

    Koin getOrNull();

    void loadKoinModules(List<Module> modules, boolean createEagerInstances);

    void loadKoinModules(Module module, boolean createEagerInstances);

    KoinApplication startKoin(Function1<? super KoinApplication, Unit> appDeclaration);

    KoinApplication startKoin(KoinApplication koinApplication);

    void stopKoin();

    void unloadKoinModules(List<Module> modules);

    void unloadKoinModules(Module module);

    /* JADX INFO: compiled from: KoinContext.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void loadKoinModules$default(KoinContext koinContext, Module module, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadKoinModules");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            koinContext.loadKoinModules(module, z);
        }

        public static /* synthetic */ void loadKoinModules$default(KoinContext koinContext, List list, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadKoinModules");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            koinContext.loadKoinModules((List<Module>) list, z);
        }
    }
}

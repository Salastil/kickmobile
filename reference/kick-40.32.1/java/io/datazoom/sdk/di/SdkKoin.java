package io.datazoom.sdk.di;

import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.Koin;
import org.koin.core.KoinApplication;
import org.koin.core.module.Module;
import org.koin.dsl.KoinApplicationKt;

/* JADX INFO: compiled from: SdkKoin.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\"\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\u000bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lio/datazoom/sdk/di/SdkKoin;", "", "<init>", "()V", "_app", "Lorg/koin/core/KoinApplication;", "koin", "Lorg/koin/core/Koin;", "getKoin", "()Lorg/koin/core/Koin;", "init", "", "modules", "", "Lorg/koin/core/module/Module;", "([Lorg/koin/core/module/Module;)V", "shutdown", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SdkKoin {
    public static final SdkKoin INSTANCE = new SdkKoin();
    private static volatile KoinApplication _app;

    private SdkKoin() {
    }

    public final Koin getKoin() {
        KoinApplication koinApplication = _app;
        Koin koin = koinApplication != null ? koinApplication.getKoin() : null;
        if (koin != null) {
            return koin;
        }
        throw new IllegalStateException("SDK Koin not initialized".toString());
    }

    public final synchronized void init(final Module... modules) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        KoinApplication koinApplication = _app;
        if (koinApplication != null) {
            koinApplication.close();
        }
        _app = KoinApplicationKt.koinApplication((Function1<? super KoinApplication, Unit>) new Function1() { // from class: io.datazoom.sdk.di.SdkKoin$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SdkKoin.init$lambda$0(modules, (KoinApplication) obj);
            }
        });
    }

    static final Unit init$lambda$0(Module[] moduleArr, KoinApplication koinApplication) {
        Intrinsics.checkNotNullParameter(koinApplication, "$this$koinApplication");
        koinApplication.modules(ArraysKt.toList(moduleArr));
        return Unit.INSTANCE;
    }

    public final synchronized void shutdown() {
        KoinApplication koinApplication = _app;
        if (koinApplication != null) {
            koinApplication.close();
        }
        _app = null;
    }
}

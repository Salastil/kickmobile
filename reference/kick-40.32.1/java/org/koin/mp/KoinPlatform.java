package org.koin.mp;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.Koin;
import org.koin.core.KoinApplication;
import org.koin.core.context.DefaultContextExtKt;
import org.koin.core.logger.Level;
import org.koin.core.module.Module;

/* JADX INFO: compiled from: KoinPlatform.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u0004\u0018\u00010\r¨\u0006\u000f"}, d2 = {"Lorg/koin/mp/KoinPlatform;", "", "<init>", "()V", "startKoin", "", "modules", "", "Lorg/koin/core/module/Module;", FirebaseAnalytics.Param.LEVEL, "Lorg/koin/core/logger/Level;", "stopKoin", "getKoin", "Lorg/koin/core/Koin;", "getKoinOrNull", "koin-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KoinPlatform {
    public static final KoinPlatform INSTANCE = new KoinPlatform();

    private KoinPlatform() {
    }

    public final void startKoin(final List<Module> modules, final Level level) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        Intrinsics.checkNotNullParameter(level, "level");
        DefaultContextExtKt.startKoin((Function1<? super KoinApplication, Unit>) new Function1() { // from class: org.koin.mp.KoinPlatform$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return KoinPlatform.startKoin$lambda$0(level, modules, (KoinApplication) obj);
            }
        });
    }

    static final Unit startKoin$lambda$0(Level level, List list, KoinApplication startKoin) {
        Intrinsics.checkNotNullParameter(startKoin, "$this$startKoin");
        startKoin.logger(KoinPlatformTools.INSTANCE.defaultLogger(level));
        startKoin.modules((List<Module>) list);
        return Unit.INSTANCE;
    }

    public final void stopKoin() {
        DefaultContextExtKt.stopKoin();
    }

    public final Koin getKoin() {
        return KoinPlatformTools.INSTANCE.defaultContext().get();
    }

    public final Koin getKoinOrNull() {
        return KoinPlatformTools.INSTANCE.defaultContext().getOrNull();
    }
}

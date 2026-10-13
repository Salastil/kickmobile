package io.datazoom.sdk.di;

import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.Koin;
import org.koin.core.KoinApplication;
import org.koin.dsl.KoinApplicationKt;

/* JADX INFO: compiled from: DiCustomContext.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lio/datazoom/sdk/di/DiCustomContext;", "", "<init>", "()V", "koinApp", "Lorg/koin/core/KoinApplication;", "koin", "Lorg/koin/core/Koin;", "getKoin", "()Lorg/koin/core/Koin;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DiCustomContext {
    public static final DiCustomContext INSTANCE = new DiCustomContext();
    private static final Koin koin;
    private static final KoinApplication koinApp;

    private DiCustomContext() {
    }

    static {
        KoinApplication koinApplication = KoinApplicationKt.koinApplication((Function1<? super KoinApplication, Unit>) new Function1() { // from class: io.datazoom.sdk.di.DiCustomContext$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DiCustomContext.koinApp$lambda$0((KoinApplication) obj);
            }
        });
        koinApp = koinApplication;
        koin = koinApplication.getKoin();
    }

    static final Unit koinApp$lambda$0(KoinApplication koinApplication) {
        Intrinsics.checkNotNullParameter(koinApplication, "$this$koinApplication");
        koinApplication.modules(DatazoomModuleKt.getAppModule(), DatazoomModuleKt.getShortLiveScope());
        return Unit.INSTANCE;
    }

    public final Koin getKoin() {
        return koin;
    }
}

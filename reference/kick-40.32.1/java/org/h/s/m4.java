package org.h.s;

import android.content.Context;
import io.mobileshield.sdk.config.Config;
import io.mobileshield.sdk.logger.LocalLogger;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes11.dex */
public final class m4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q1 f542a;

    public m4(p1 longTermStorage) {
        Intrinsics.checkNotNullParameter(longTermStorage, "longTermStorage");
        this.f542a = longTermStorage;
    }

    public static boolean a(u domainData) {
        Intrinsics.checkNotNullParameter(domainData, "domainData");
        m clientToken = domainData.c;
        if (clientToken != null) {
            long j = clientToken.d;
            long timeInMillis = Calendar.getInstance().getTimeInMillis();
            TimeUnit timeUnit = k4.f532a;
            Intrinsics.checkNotNullParameter(clientToken, "clientToken");
            long timeInMillis2 = clientToken.d - Calendar.getInstance().getTimeInMillis();
            boolean z = timeInMillis2 >= k4.a(domainData) || timeInMillis2 < 0;
            if (timeInMillis <= j && !z) {
                return false;
            }
        }
        return true;
    }

    public final u a(Context context, Config[] configs, u newDomainData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configs, "configs");
        u uVarA = this.f542a.a();
        if (uVarA != null && !a(uVarA)) {
            Config config = configs[0];
            if (!StringsKt.equals(config.getDomain(), uVarA.f576a, true)) {
                uVarA.a(config);
                Intrinsics.checkNotNullParameter(context, "context");
                if (newDomainData != null) {
                    p1 p1Var = (p1) this.f542a;
                    p1Var.getClass();
                    Intrinsics.checkNotNullParameter(context, "context");
                    Intrinsics.checkNotNullParameter(newDomainData, "newDomainData");
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(p1Var.c), null, null, new o1(p1Var, context, newDomainData, null), 3, null);
                }
            }
            return uVarA;
        }
        LocalLogger.log(16, 22305L, String.valueOf(uVarA));
        return null;
    }
}

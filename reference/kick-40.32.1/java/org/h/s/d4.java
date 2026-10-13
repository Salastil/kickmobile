package org.h.s;

import io.mobileshield.sdk.Priority;
import io.mobileshield.sdk.config.Config;
import io.mobileshield.sdk.logger.LocalLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes11.dex */
public final class d4 extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i4 f497a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d4(i4 i4Var) {
        super(0);
        this.f497a = i4Var;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        i4 tokenTimer = this.f497a;
        u uVarH = tokenTimer.h();
        Config[] configArr = null;
        tokenTimer.a((u) null);
        LocalLogger.log(8, 22300L, uVarH != null ? uVarH.f576a : null);
        u3 currentState = tokenTimer.l;
        Priority priority = tokenTimer.m;
        Intrinsics.checkNotNullParameter(currentState, "currentState");
        Intrinsics.checkNotNullParameter(priority, "priority");
        a4 a4Var = currentState.f579a;
        a4 a4Var2 = a4.DONE;
        if (a4Var == a4Var2 && priority == Priority.LAZY) {
            tokenTimer.a(new u3(a4.INIT, 0));
        } else {
            c0 c0Var = tokenTimer.k;
            if (c0Var.f485a > c0Var.d) {
                Intrinsics.checkNotNullParameter(c0Var, "<this>");
                Intrinsics.checkNotNullParameter(tokenTimer, "tokenTimer");
                LocalLogger.log(16, 22901L, "");
                tokenTimer.i.a();
                tokenTimer.a((u) null);
                c0Var.b();
                tokenTimer.a(new u3(a4.PAUSE, 0));
            } else {
                h4 reset = new h4(tokenTimer);
                Intrinsics.checkNotNullParameter(tokenTimer, "tokenTimer");
                Intrinsics.checkNotNullParameter(reset, "reset");
                if (uVarH == null) {
                    LocalLogger.log(16, 22318L, "Resetting process");
                    tokenTimer.i.a();
                    tokenTimer.a((u) null);
                    reset.invoke();
                } else {
                    u3 currentState2 = tokenTimer.l;
                    l2 networkChecker = tokenTimer.f;
                    Intrinsics.checkNotNullParameter(currentState2, "currentState");
                    Intrinsics.checkNotNullParameter(networkChecker, "networkChecker");
                    if (!a0.j.c || (currentState2.f579a != a4Var2 && networkChecker.b.get())) {
                        if (y1.i == null) {
                            y1.i = new y1(Dispatchers.getIO(), new t1());
                        }
                        y1 y1Var = y1.i;
                        Intrinsics.checkNotNull(y1Var);
                        y1.a(y1Var, r4.INTERROGATION);
                        c0 retry = tokenTimer.k;
                        Intrinsics.checkNotNullParameter(retry, "retry");
                        tokenTimer.a(retry.f485a == 0 ? new u3(a4.START, 0) : new u3(a4.RETRY, 0));
                        tokenTimer.d();
                        uVarH.e = false;
                        t3 t3VarA = tokenTimer.k.a();
                        tokenTimer.g = t3VarA;
                        tokenTimer.b(uVarH, t3VarA.b, k4.f532a);
                        String str = uVarH.f576a;
                        Config[] configArr2 = tokenTimer.c;
                        if (configArr2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("localConfig");
                        } else {
                            configArr = configArr2;
                        }
                        tokenTimer.a(k4.a(str, configArr));
                    } else {
                        if (y1.i == null) {
                            y1.i = new y1(Dispatchers.getIO(), new t1());
                        }
                        y1 y1Var2 = y1.i;
                        Intrinsics.checkNotNull(y1Var2);
                        y1.a(y1Var2, r4.INTERROGATION);
                        tokenTimer.f.a(tokenTimer.f523a);
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }
}

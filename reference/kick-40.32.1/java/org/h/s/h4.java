package org.h.s;

import io.mobileshield.sdk.config.Config;
import io.mobileshield.sdk.logger.LocalLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes11.dex */
public final class h4 extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i4 f519a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h4(i4 i4Var) {
        super(0);
        this.f519a = i4Var;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        i4 i4Var = this.f519a;
        Config[] configArr = i4Var.c;
        if (configArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localConfig");
            configArr = null;
        }
        i4Var.a(configArr, i4Var.h.a(i4Var.f523a, configArr, i4Var.h()));
        i4 i4Var2 = this.f519a;
        u uVarH = i4Var2.h();
        if (uVarH != null) {
            if (uVarH.e) {
                LocalLogger.log(16, 22314L, uVarH.f576a);
            } else {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(i4Var2.d), null, null, new g4(i4Var2, uVarH, null), 3, null);
            }
        }
        return Unit.INSTANCE;
    }
}

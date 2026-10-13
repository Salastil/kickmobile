package org.h.s;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
public final class e2 extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r0 f501a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e2(r0 r0Var) {
        super(0);
        this.f501a = r0Var;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        if (a0.l.c && g2.h.get() > 0) {
            try {
                this.f501a.b();
            } catch (Exception e) {
                s3 s3Var = f1.f506a;
                f1.a(w0.d, y.a(e));
            }
        }
        return Unit.INSTANCE;
    }
}

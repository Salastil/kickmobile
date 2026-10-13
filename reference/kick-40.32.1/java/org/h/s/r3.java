package org.h.s;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import okhttp3.Response;

/* JADX INFO: loaded from: classes11.dex */
public final class r3 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s3 f566a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r3(s3 s3Var) {
        super(1);
        this.f566a = s3Var;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Response it = (Response) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        String str = it.headers().get("x-kpsdk-lg");
        if (str == null || s3.g || Intrinsics.areEqual(str, this.f566a.c.f)) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.f566a.b), null, null, new q3(this.f566a, null), 3, null);
        } else {
            s3.g = true;
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.f566a.b), null, null, new p3(this.f566a, str, null), 3, null);
        }
        return Unit.INSTANCE;
    }
}

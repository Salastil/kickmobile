package io.ktor.client.plugins.cookies;

import com.google.android.gms.common.internal.ImagesContract;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: HttpCookies.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cookies.HttpCookies", f = "HttpCookies.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {60}, m = "captureHeaderCookies$ktor_client_core", n = {"builder", "$this$captureHeaderCookies_u24lambda_u240", ImagesContract.URL, "$this$forEach$iv", "element$iv", "it", "cookies", "$i$a$-with-HttpCookies$captureHeaderCookies$2", "$i$f$forEach", "$i$a$-forEach-HttpCookies$captureHeaderCookies$2$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "I$0", "I$1", "I$2"}, v = 1)
final class HttpCookies$captureHeaderCookies$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HttpCookies this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HttpCookies$captureHeaderCookies$1(HttpCookies httpCookies, Continuation<? super HttpCookies$captureHeaderCookies$1> continuation) {
        super(continuation);
        this.this$0 = httpCookies;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.captureHeaderCookies$ktor_client_core(null, this);
    }
}

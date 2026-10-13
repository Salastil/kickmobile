package com.amazon.mediatailorsdk.network.session;

import com.datadog.trace.bootstrap.instrumentation.api.InstrumentationTags;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.bouncycastle.asn1.eac.EACTags;

/* JADX INFO: compiled from: SessionInitUseCase.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.amazon.mediatailorsdk.network.session.SessionInitUseCase", f = "SessionInitUseCase.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {67, EACTags.MESSAGE_REFERENCE}, m = "invoke-bPJOTnY", n = {"sessionInitUrl", "data", "extraHeaders", "$this$safePost_u2dQEa2snw_u24default$iv", "url$iv", "data$iv", "extraHeaders$iv", "userAgent$iv", "$this$post$iv$iv", "urlString$iv$iv", "$this$post$iv$iv$iv", "builder$iv$iv$iv", "$this$request$iv$iv$iv$iv", "builder$iv$iv$iv$iv", InstrumentationTags.TIMEOUT, "maxRetry", "timeout$iv", "maxRetry$iv", "$i$f$safePost-QEa2snw", "$i$f$post", "$i$f$post", "$i$f$request", "sessionInitUrl", "data", "extraHeaders", "$this$safePost_u2dQEa2snw_u24default$iv", "url$iv", "data$iv", "extraHeaders$iv", "userAgent$iv", "$this$toResponse$iv$iv", "$this$body$iv$iv$iv", InstrumentationTags.TIMEOUT, "maxRetry", "timeout$iv", "maxRetry$iv", "$i$f$safePost-QEa2snw", "$i$f$toResponse", "$i$f$body"}, nl = {66, 72}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "J$0", "I$0", "J$1", "I$1", "I$2", "I$3", "I$4", "I$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "J$0", "I$0", "J$1", "I$1", "I$2", "I$3", "I$4"}, v = 2)
final class SessionInitUseCase$invoke$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int I$4;
    int I$5;
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$12;
    Object L$13;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SessionInitUseCase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SessionInitUseCase$invoke$1(SessionInitUseCase sessionInitUseCase, Continuation<? super SessionInitUseCase$invoke$1> continuation) {
        super(continuation);
        this.this$0 = sessionInitUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m10987invokebPJOTnY(null, null, null, 0L, 0, this);
    }
}

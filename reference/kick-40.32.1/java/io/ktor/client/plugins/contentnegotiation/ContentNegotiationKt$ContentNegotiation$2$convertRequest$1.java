package io.ktor.client.plugins.contentnegotiation;

import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: ContentNegotiation.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.contentnegotiation.ContentNegotiationKt", f = "ContentNegotiation.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {234}, m = "ContentNegotiation$lambda$0$convertRequest", n = {"registrations", "ignoredTypes", "$this_createClientPlugin", "request", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "requestRegistrations", "acceptHeaders", "contentType", "matchingRegistrations", "registration", "$i$a$-firstNotNullOfOrNull-ContentNegotiationKt$ContentNegotiation$2$convertRequest$serializedContent$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10", "I$0"}, v = 1)
final class ContentNegotiationKt$ContentNegotiation$2$convertRequest$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$10;
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

    ContentNegotiationKt$ContentNegotiation$2$convertRequest$1(Continuation<? super ContentNegotiationKt$ContentNegotiation$2$convertRequest$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ContentNegotiationKt.ContentNegotiation$lambda$0$convertRequest(null, null, null, null, null, this);
    }
}

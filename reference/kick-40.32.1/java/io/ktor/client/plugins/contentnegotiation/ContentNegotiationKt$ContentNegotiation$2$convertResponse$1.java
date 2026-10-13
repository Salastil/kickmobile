package io.ktor.client.plugins.contentnegotiation;

import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import io.ktor.http.auth.HttpAuthHeader;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: ContentNegotiation.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.contentnegotiation.ContentNegotiationKt", f = "ContentNegotiation.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {284}, m = "ContentNegotiation$lambda$0$convertResponse", n = {"ignoredTypes", "registrations", "$this_createClientPlugin", "requestUrl", "info", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "responseContentType", HttpAuthHeader.Parameters.Charset, "suitableConverters"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"}, v = 1)
final class ContentNegotiationKt$ContentNegotiation$2$convertResponse$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    /* synthetic */ Object result;

    ContentNegotiationKt$ContentNegotiation$2$convertResponse$1(Continuation<? super ContentNegotiationKt$ContentNegotiation$2$convertResponse$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ContentNegotiationKt.ContentNegotiation$lambda$0$convertResponse(null, null, null, null, null, null, null, null, this);
    }
}

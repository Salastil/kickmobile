package io.ktor.client.plugins.contentnegotiation;

import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.TransformRequestBodyContext;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.reflect.TypeInfo;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function5;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: ContentNegotiation.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\n"}, d2 = {"<anonymous>", "Lio/ktor/http/content/OutgoingContent;", "Lio/ktor/client/plugins/api/TransformRequestBodyContext;", "request", "Lio/ktor/client/request/HttpRequestBuilder;", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "", "<unused var>", "Lio/ktor/util/reflect/TypeInfo;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.contentnegotiation.ContentNegotiationKt$ContentNegotiation$2$1", f = "ContentNegotiation.kt", i = {0, 0}, l = {292}, m = "invokeSuspend", n = {"request", ExpoNotificationBuilder.EXTRAS_BODY_KEY}, s = {"L$0", "L$1"}, v = 1)
final class ContentNegotiationKt$ContentNegotiation$2$1 extends SuspendLambda implements Function5<TransformRequestBodyContext, HttpRequestBuilder, Object, TypeInfo, Continuation<? super OutgoingContent>, Object> {
    final /* synthetic */ Set<KClass<?>> $ignoredTypes;
    final /* synthetic */ List<ContentNegotiationConfig.ConverterRegistration> $registrations;
    final /* synthetic */ ClientPluginBuilder<ContentNegotiationConfig> $this_createClientPlugin;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ContentNegotiationKt$ContentNegotiation$2$1(List<ContentNegotiationConfig.ConverterRegistration> list, Set<? extends KClass<?>> set, ClientPluginBuilder<ContentNegotiationConfig> clientPluginBuilder, Continuation<? super ContentNegotiationKt$ContentNegotiation$2$1> continuation) {
        super(5, continuation);
        this.$registrations = list;
        this.$ignoredTypes = set;
        this.$this_createClientPlugin = clientPluginBuilder;
    }

    @Override // kotlin.jvm.functions.Function5
    public final Object invoke(TransformRequestBodyContext transformRequestBodyContext, HttpRequestBuilder httpRequestBuilder, Object obj, TypeInfo typeInfo, Continuation<? super OutgoingContent> continuation) {
        ContentNegotiationKt$ContentNegotiation$2$1 contentNegotiationKt$ContentNegotiation$2$1 = new ContentNegotiationKt$ContentNegotiation$2$1(this.$registrations, this.$ignoredTypes, this.$this_createClientPlugin, continuation);
        contentNegotiationKt$ContentNegotiation$2$1.L$0 = httpRequestBuilder;
        contentNegotiationKt$ContentNegotiation$2$1.L$1 = obj;
        return contentNegotiationKt$ContentNegotiation$2$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws ContentConverterException {
        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) this.L$0;
        Object obj2 = this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        this.L$0 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
        this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
        this.label = 1;
        Object objContentNegotiation$lambda$0$convertRequest = ContentNegotiationKt.ContentNegotiation$lambda$0$convertRequest(this.$registrations, this.$ignoredTypes, this.$this_createClientPlugin, httpRequestBuilder, obj2, this);
        return objContentNegotiation$lambda$0$convertRequest == coroutine_suspended ? coroutine_suspended : objContentNegotiation$lambda$0$convertRequest;
    }
}

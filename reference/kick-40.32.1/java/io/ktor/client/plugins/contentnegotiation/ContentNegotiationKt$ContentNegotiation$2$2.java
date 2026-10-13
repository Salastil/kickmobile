package io.ktor.client.plugins.contentnegotiation;

import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.TransformResponseBodyContext;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.serialization.ContentConverterKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import java.nio.charset.Charset;
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
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n"}, d2 = {"<anonymous>", "", "Lio/ktor/client/plugins/api/TransformResponseBodyContext;", "response", "Lio/ktor/client/statement/HttpResponse;", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "Lio/ktor/utils/io/ByteReadChannel;", "info", "Lio/ktor/util/reflect/TypeInfo;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.contentnegotiation.ContentNegotiationKt$ContentNegotiation$2$2", f = "ContentNegotiation.kt", i = {0, 0, 0, 0, 0}, l = {299}, m = "invokeSuspend", n = {"response", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "info", "contentType", HttpAuthHeader.Parameters.Charset}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"}, v = 1)
final class ContentNegotiationKt$ContentNegotiation$2$2 extends SuspendLambda implements Function5<TransformResponseBodyContext, HttpResponse, ByteReadChannel, TypeInfo, Continuation<? super Object>, Object> {
    final /* synthetic */ Set<KClass<?>> $ignoredTypes;
    final /* synthetic */ List<ContentNegotiationConfig.ConverterRegistration> $registrations;
    final /* synthetic */ ClientPluginBuilder<ContentNegotiationConfig> $this_createClientPlugin;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ContentNegotiationKt$ContentNegotiation$2$2(Set<? extends KClass<?>> set, List<ContentNegotiationConfig.ConverterRegistration> list, ClientPluginBuilder<ContentNegotiationConfig> clientPluginBuilder, Continuation<? super ContentNegotiationKt$ContentNegotiation$2$2> continuation) {
        super(5, continuation);
        this.$ignoredTypes = set;
        this.$registrations = list;
        this.$this_createClientPlugin = clientPluginBuilder;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(TransformResponseBodyContext transformResponseBodyContext, HttpResponse httpResponse, ByteReadChannel byteReadChannel, TypeInfo typeInfo, Continuation<Object> continuation) {
        ContentNegotiationKt$ContentNegotiation$2$2 contentNegotiationKt$ContentNegotiation$2$2 = new ContentNegotiationKt$ContentNegotiation$2$2(this.$ignoredTypes, this.$registrations, this.$this_createClientPlugin, continuation);
        contentNegotiationKt$ContentNegotiation$2$2.L$0 = httpResponse;
        contentNegotiationKt$ContentNegotiation$2$2.L$1 = byteReadChannel;
        contentNegotiationKt$ContentNegotiation$2$2.L$2 = typeInfo;
        return contentNegotiationKt$ContentNegotiation$2$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function5
    public /* bridge */ /* synthetic */ Object invoke(TransformResponseBodyContext transformResponseBodyContext, HttpResponse httpResponse, ByteReadChannel byteReadChannel, TypeInfo typeInfo, Continuation<? super Object> continuation) {
        return invoke2(transformResponseBodyContext, httpResponse, byteReadChannel, typeInfo, (Continuation<Object>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        HttpResponse httpResponse = (HttpResponse) this.L$0;
        ByteReadChannel byteReadChannel = (ByteReadChannel) this.L$1;
        TypeInfo typeInfo = (TypeInfo) this.L$2;
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
        ContentType contentType = HttpMessagePropertiesKt.contentType(httpResponse);
        if (contentType == null) {
            return null;
        }
        Charset charsetSuitableCharset$default = ContentConverterKt.suitableCharset$default(HttpResponseKt.getRequest(httpResponse).getHeaders(), null, 1, null);
        this.L$0 = SpillingKt.nullOutSpilledVariable(httpResponse);
        this.L$1 = SpillingKt.nullOutSpilledVariable(byteReadChannel);
        this.L$2 = SpillingKt.nullOutSpilledVariable(typeInfo);
        this.L$3 = SpillingKt.nullOutSpilledVariable(contentType);
        this.L$4 = SpillingKt.nullOutSpilledVariable(charsetSuitableCharset$default);
        this.label = 1;
        Object objContentNegotiation$lambda$0$convertResponse = ContentNegotiationKt.ContentNegotiation$lambda$0$convertResponse(this.$ignoredTypes, this.$registrations, this.$this_createClientPlugin, HttpResponseKt.getRequest(httpResponse).getUrl(), typeInfo, byteReadChannel, contentType, charsetSuitableCharset$default, this);
        return objContentNegotiation$lambda$0$convertResponse == coroutine_suspended ? coroutine_suspended : objContentNegotiation$lambda$0$convertResponse;
    }
}

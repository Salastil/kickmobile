package io.ktor.client.plugins.contentnegotiation;

import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.plugins.sse.ClientSSESession;
import io.ktor.client.plugins.sse.ClientSSESessionWithDeserialization;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.ContentType;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.serialization.ContentConverterKt;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;

/* JADX INFO: compiled from: ContentNegotiation.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a%\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0001\"\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\"\u0018\u0010\t\u001a\u00060\u0007j\u0002`\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n\"$\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"&\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00120\u00118\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"#\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lio/ktor/client/request/HttpRequestBuilder;", "", "Lio/ktor/http/ContentType;", "contentType", "", "exclude", "(Lio/ktor/client/request/HttpRequestBuilder;[Lio/ktor/http/ContentType;)V", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "", "Lkotlin/reflect/KClass;", "DefaultCommonIgnoredTypes", "Ljava/util/Set;", "getDefaultCommonIgnoredTypes", "()Ljava/util/Set;", "Lio/ktor/util/AttributeKey;", "", "ExcludedContentTypes", "Lio/ktor/util/AttributeKey;", "getExcludedContentTypes", "()Lio/ktor/util/AttributeKey;", "Lio/ktor/client/plugins/api/ClientPlugin;", "Lio/ktor/client/plugins/contentnegotiation/ContentNegotiationConfig;", "ContentNegotiation", "Lio/ktor/client/plugins/api/ClientPlugin;", "getContentNegotiation", "()Lio/ktor/client/plugins/api/ClientPlugin;", "getContentNegotiation$annotations", "()V", "ktor-client-content-negotiation"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ContentNegotiationKt {
    private static final ClientPlugin<ContentNegotiationConfig> ContentNegotiation;
    private static final AttributeKey<List<ContentType>> ExcludedContentTypes;
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.contentnegotiation.ContentNegotiation");
    private static final Set<KClass<?>> DefaultCommonIgnoredTypes = SetsKt.setOf((Object[]) new KClass[]{Reflection.getOrCreateKotlinClass(byte[].class), Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(HttpStatusCode.class), Reflection.getOrCreateKotlinClass(ByteReadChannel.class), Reflection.getOrCreateKotlinClass(OutgoingContent.class), Reflection.getOrCreateKotlinClass(ClientSSESession.class), Reflection.getOrCreateKotlinClass(ClientSSESessionWithDeserialization.class)});

    public static /* synthetic */ void getContentNegotiation$annotations() {
    }

    static {
        KType kTypeTypeOf;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(List.class);
        try {
            kTypeTypeOf = Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(ContentType.class)));
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        ExcludedContentTypes = new AttributeKey<>("ExcludedContentTypesAttr", new TypeInfo(orCreateKotlinClass, kTypeTypeOf));
        ContentNegotiation = CreatePluginUtilsKt.createClientPlugin("ContentNegotiation", ContentNegotiationKt$ContentNegotiation$1.INSTANCE, new Function1() { // from class: io.ktor.client.plugins.contentnegotiation.ContentNegotiationKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ContentNegotiationKt.ContentNegotiation$lambda$0((ClientPluginBuilder) obj);
            }
        });
    }

    public static final Set<KClass<?>> getDefaultCommonIgnoredTypes() {
        return DefaultCommonIgnoredTypes;
    }

    public static final AttributeKey<List<ContentType>> getExcludedContentTypes() {
        return ExcludedContentTypes;
    }

    public static final ClientPlugin<ContentNegotiationConfig> getContentNegotiation() {
        return ContentNegotiation;
    }

    static final Unit ContentNegotiation$lambda$0(ClientPluginBuilder createClientPlugin) {
        Intrinsics.checkNotNullParameter(createClientPlugin, "$this$createClientPlugin");
        List<ContentNegotiationConfig.ConverterRegistration> registrations$ktor_client_content_negotiation = ((ContentNegotiationConfig) createClientPlugin.getPluginConfig()).getRegistrations$ktor_client_content_negotiation();
        Set<KClass<?>> ignoredTypes$ktor_client_content_negotiation = ((ContentNegotiationConfig) createClientPlugin.getPluginConfig()).getIgnoredTypes$ktor_client_content_negotiation();
        createClientPlugin.transformRequestBody(new ContentNegotiationKt$ContentNegotiation$2$1(registrations$ktor_client_content_negotiation, ignoredTypes$ktor_client_content_negotiation, createClientPlugin, null));
        createClientPlugin.transformResponseBody(new ContentNegotiationKt$ContentNegotiation$2$2(ignoredTypes$ktor_client_content_negotiation, registrations$ktor_client_content_negotiation, createClientPlugin, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:101:0x02c4  */
    /* JADX WARN: Code duplicated, block: B:102:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:105:0x030a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:106:0x030b  */
    /* JADX WARN: Code duplicated, block: B:109:0x0313  */
    /* JADX WARN: Code duplicated, block: B:111:0x033a  */
    /* JADX WARN: Code duplicated, block: B:112:0x033c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:96:0x029d  */
    /* JADX WARN: Code duplicated, block: B:98:0x02b1  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x030b -> B:107:0x030f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object ContentNegotiation$lambda$0$convertRequest(java.util.List<io.ktor.client.plugins.contentnegotiation.ContentNegotiationConfig.ConverterRegistration> r21, java.util.Set<? extends kotlin.reflect.KClass<?>> r22, io.ktor.client.plugins.api.ClientPluginBuilder<io.ktor.client.plugins.contentnegotiation.ContentNegotiationConfig> r23, io.ktor.client.request.HttpRequestBuilder r24, java.lang.Object r25, kotlin.coroutines.Continuation<? super io.ktor.http.content.OutgoingContent> r26) {
        /*
            Method dump skipped, instruction units count: 944
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.contentnegotiation.ContentNegotiationKt.ContentNegotiation$lambda$0$convertRequest(java.util.List, java.util.Set, io.ktor.client.plugins.api.ClientPluginBuilder, io.ktor.client.request.HttpRequestBuilder, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence ContentNegotiation$lambda$0$convertRequest$8(ContentNegotiationConfig.ConverterRegistration it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getConverter().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public static final Object ContentNegotiation$lambda$0$convertResponse(Set<? extends KClass<?>> set, List<ContentNegotiationConfig.ConverterRegistration> list, ClientPluginBuilder<ContentNegotiationConfig> clientPluginBuilder, Url url, TypeInfo typeInfo, Object obj, ContentType contentType, Charset charset, Continuation<Object> continuation) {
        ContentNegotiationKt$ContentNegotiation$2$convertResponse$1 contentNegotiationKt$ContentNegotiation$2$convertResponse$1;
        Url url2;
        if (continuation instanceof ContentNegotiationKt$ContentNegotiation$2$convertResponse$1) {
            contentNegotiationKt$ContentNegotiation$2$convertResponse$1 = (ContentNegotiationKt$ContentNegotiation$2$convertResponse$1) continuation;
            if ((contentNegotiationKt$ContentNegotiation$2$convertResponse$1.label & Integer.MIN_VALUE) != 0) {
                contentNegotiationKt$ContentNegotiation$2$convertResponse$1.label -= Integer.MIN_VALUE;
            } else {
                contentNegotiationKt$ContentNegotiation$2$convertResponse$1 = new ContentNegotiationKt$ContentNegotiation$2$convertResponse$1(continuation);
            }
        } else {
            contentNegotiationKt$ContentNegotiation$2$convertResponse$1 = new ContentNegotiationKt$ContentNegotiation$2$convertResponse$1(continuation);
        }
        Object objDeserialize = contentNegotiationKt$ContentNegotiation$2$convertResponse$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = contentNegotiationKt$ContentNegotiation$2$convertResponse$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objDeserialize);
            if (!(obj instanceof ByteReadChannel)) {
                LOGGER.trace("Response body is already transformed. Skipping ContentNegotiation for " + url + FilenameUtils.EXTENSION_SEPARATOR);
                return null;
            }
            if (set.contains(typeInfo.getType())) {
                LOGGER.trace("Response body type " + typeInfo.getType() + " is in ignored types. Skipping ContentNegotiation for " + url + FilenameUtils.EXTENSION_SEPARATOR);
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list) {
                if (((ContentNegotiationConfig.ConverterRegistration) obj2).getContentTypeMatcher().contains(contentType)) {
                    arrayList.add(obj2);
                }
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList3.add(((ContentNegotiationConfig.ConverterRegistration) it.next()).getConverter());
            }
            ArrayList arrayList4 = arrayList3;
            if (arrayList4.isEmpty()) {
                arrayList4 = null;
            }
            if (arrayList4 == null) {
                LOGGER.trace("None of the registered converters match response with Content-Type=" + contentType + ". Skipping ContentNegotiation for " + url + FilenameUtils.EXTENSION_SEPARATOR);
                return null;
            }
            contentNegotiationKt$ContentNegotiation$2$convertResponse$1.L$0 = SpillingKt.nullOutSpilledVariable(set);
            contentNegotiationKt$ContentNegotiation$2$convertResponse$1.L$1 = SpillingKt.nullOutSpilledVariable(list);
            contentNegotiationKt$ContentNegotiation$2$convertResponse$1.L$2 = SpillingKt.nullOutSpilledVariable(clientPluginBuilder);
            contentNegotiationKt$ContentNegotiation$2$convertResponse$1.L$3 = url;
            contentNegotiationKt$ContentNegotiation$2$convertResponse$1.L$4 = SpillingKt.nullOutSpilledVariable(typeInfo);
            contentNegotiationKt$ContentNegotiation$2$convertResponse$1.L$5 = SpillingKt.nullOutSpilledVariable(obj);
            contentNegotiationKt$ContentNegotiation$2$convertResponse$1.L$6 = SpillingKt.nullOutSpilledVariable(contentType);
            contentNegotiationKt$ContentNegotiation$2$convertResponse$1.L$7 = SpillingKt.nullOutSpilledVariable(charset);
            contentNegotiationKt$ContentNegotiation$2$convertResponse$1.L$8 = SpillingKt.nullOutSpilledVariable(arrayList4);
            contentNegotiationKt$ContentNegotiation$2$convertResponse$1.label = 1;
            objDeserialize = ContentConverterKt.deserialize(arrayList4, (ByteReadChannel) obj, typeInfo, charset, contentNegotiationKt$ContentNegotiation$2$convertResponse$1);
            if (objDeserialize == coroutine_suspended) {
                return coroutine_suspended;
            }
            url2 = url;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Object obj3 = contentNegotiationKt$ContentNegotiation$2$convertResponse$1.L$5;
            url2 = (Url) contentNegotiationKt$ContentNegotiation$2$convertResponse$1.L$3;
            ResultKt.throwOnFailure(objDeserialize);
        }
        if (!(objDeserialize instanceof ByteReadChannel)) {
            LOGGER.trace("Response body was converted to " + Reflection.getOrCreateKotlinClass(objDeserialize.getClass()) + " for " + url2 + FilenameUtils.EXTENSION_SEPARATOR);
        }
        return objDeserialize;
    }

    public static final void exclude(HttpRequestBuilder httpRequestBuilder, ContentType... contentType) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Attributes attributes = httpRequestBuilder.getAttributes();
        AttributeKey<List<ContentType>> attributeKey = ExcludedContentTypes;
        List listEmptyList = (List) attributes.getOrNull(attributeKey);
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        httpRequestBuilder.getAttributes().put(attributeKey, CollectionsKt.plus((Collection) listEmptyList, (Object[]) contentType));
    }
}

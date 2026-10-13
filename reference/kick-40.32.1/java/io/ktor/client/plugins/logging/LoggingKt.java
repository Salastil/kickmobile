package io.ktor.client.plugins.logging;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.call.DelegatedCallKt;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.content.ObservableContent;
import io.ktor.client.plugins.DoubleReceivePluginKt;
import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.plugins.observer.ResponseObserverConfig;
import io.ktor.client.plugins.observer.ResponseObserverKt;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.forms.MultiPartFormDataContent;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.Headers;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.PartData;
import io.ktor.util.AttributeKey;
import io.ktor.util.ByteChannelsKt;
import io.ktor.util.Encoder;
import io.ktor.util.GZipEncoder;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteChannelCtorKt;
import io.ktor.utils.io.ByteReadChannel;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: compiled from: Logging.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a0\u0010\u000f\u001a\u00020\f*\u0006\u0012\u0002\b\u00030\t2\u0019\b\u0002\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\r¢\u0006\u0004\b\u000f\u0010\u0010\"\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014\"\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014\"#\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00168\u0006¢\u0006\u0012\n\u0004\b\u000f\u0010\u0017\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lio/ktor/http/Url;", "", "pathQuery", "(Lio/ktor/http/Url;)Ljava/lang/String;", "", "content", "", "computeRequestBodySize", "(Ljava/lang/Object;)J", "Lio/ktor/client/HttpClientConfig;", "Lkotlin/Function1;", "Lio/ktor/client/plugins/logging/LoggingConfig;", "", "Lkotlin/ExtensionFunctionType;", "block", "Logging", "(Lio/ktor/client/HttpClientConfig;Lkotlin/jvm/functions/Function1;)V", "Lio/ktor/util/AttributeKey;", "Lio/ktor/client/plugins/logging/HttpClientCallLogger;", "ClientCallLogger", "Lio/ktor/util/AttributeKey;", "DisableLogging", "Lio/ktor/client/plugins/api/ClientPlugin;", "Lio/ktor/client/plugins/api/ClientPlugin;", "getLogging", "()Lio/ktor/client/plugins/api/ClientPlugin;", "getLogging$annotations", "()V", "ktor-client-logging"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class LoggingKt {
    private static final AttributeKey<HttpClientCallLogger> ClientCallLogger;
    private static final AttributeKey<Unit> DisableLogging;
    private static final ClientPlugin<LoggingConfig> Logging;

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel Logging$lambda$0$logOutgoingContent$2(ByteReadChannel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel Logging$lambda$0$logResponseOkHttpFormat$8(ByteReadChannel byteReadChannel, HttpResponse replaceResponse) {
        Intrinsics.checkNotNullParameter(replaceResponse, "$this$replaceResponse");
        return byteReadChannel;
    }

    public static /* synthetic */ void getLogging$annotations() {
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.logging.LoggingKt$Logging$1, reason: invalid class name */
    /* JADX INFO: compiled from: Logging.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<LoggingConfig> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0, LoggingConfig.class, "<init>", "<init>()V", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LoggingConfig invoke() {
            return new LoggingConfig();
        }
    }

    public static final ClientPlugin<LoggingConfig> getLogging() {
        return Logging;
    }

    static final Unit Logging$lambda$0(ClientPluginBuilder createClientPlugin) {
        Intrinsics.checkNotNullParameter(createClientPlugin, "$this$createClientPlugin");
        Logger logger = ((LoggingConfig) createClientPlugin.getPluginConfig()).getLogger();
        final LogLevel level = ((LoggingConfig) createClientPlugin.getPluginConfig()).getLevel();
        List<Function1<HttpRequestBuilder, Boolean>> filters$ktor_client_logging = ((LoggingConfig) createClientPlugin.getPluginConfig()).getFilters$ktor_client_logging();
        List<SanitizedHeader> sanitizedHeaders$ktor_client_logging = ((LoggingConfig) createClientPlugin.getPluginConfig()).getSanitizedHeaders$ktor_client_logging();
        boolean z = ((LoggingConfig) createClientPlugin.getPluginConfig()).getFormat() == LoggingFormat.OkHttp;
        LogBodyFilter bodyFilter = ((LoggingConfig) createClientPlugin.getPluginConfig()).getBodyFilter();
        createClientPlugin.on(SendHook.INSTANCE, new LoggingKt$Logging$2$1(z, logger, filters$ktor_client_logging, sanitizedHeaders$ktor_client_logging, level, createClientPlugin, bodyFilter, null));
        createClientPlugin.on(ResponseAfterEncodingHook.INSTANCE, new LoggingKt$Logging$2$2(z, logger, sanitizedHeaders$ktor_client_logging, level, bodyFilter, null));
        createClientPlugin.on(ResponseHook.INSTANCE, new LoggingKt$Logging$2$3(z, level, sanitizedHeaders$ktor_client_logging, null));
        createClientPlugin.on(ReceiveHook.INSTANCE, new LoggingKt$Logging$2$4(z, level, null));
        if (z) {
            return Unit.INSTANCE;
        }
        if (!level.getBody()) {
            return Unit.INSTANCE;
        }
        ResponseObserverKt.getResponseObserver().install(ResponseObserverKt.getResponseObserver().prepare(new Function1() { // from class: io.ktor.client.plugins.logging.LoggingKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LoggingKt.Logging$lambda$0$11(level, (ResponseObserverConfig) obj);
            }
        }), createClientPlugin.getClient());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Logging$lambda$0$shouldBeLogged(List<? extends Function1<? super HttpRequestBuilder, Boolean>> list, HttpRequestBuilder httpRequestBuilder) {
        if (list.isEmpty()) {
            return true;
        }
        List<? extends Function1<? super HttpRequestBuilder, Boolean>> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return false;
        }
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            if (((Boolean) ((Function1) it.next()).invoke(httpRequestBuilder)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    private static final boolean Logging$lambda$0$isNone(LogLevel logLevel) {
        return logLevel == LogLevel.NONE;
    }

    private static final boolean Logging$lambda$0$isInfo(LogLevel logLevel) {
        return logLevel == LogLevel.INFO;
    }

    private static final boolean Logging$lambda$0$isHeaders(LogLevel logLevel) {
        return logLevel == LogLevel.HEADERS;
    }

    private static final boolean Logging$lambda$0$isBody(LogLevel logLevel) {
        return logLevel == LogLevel.BODY || logLevel == LogLevel.ALL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public static final Object Logging$lambda$0$logRequestBody(LogBodyFilter logBodyFilter, Url url, OutgoingContent outgoingContent, Long l, Headers headers, HttpMethod httpMethod, List<String> list, ByteReadChannel byteReadChannel, Continuation<? super Unit> continuation) {
        LoggingKt$Logging$2$logRequestBody$1 loggingKt$Logging$2$logRequestBody$1;
        List<String> list2;
        if (continuation instanceof LoggingKt$Logging$2$logRequestBody$1) {
            loggingKt$Logging$2$logRequestBody$1 = (LoggingKt$Logging$2$logRequestBody$1) continuation;
            if ((loggingKt$Logging$2$logRequestBody$1.label & Integer.MIN_VALUE) != 0) {
                loggingKt$Logging$2$logRequestBody$1.label -= Integer.MIN_VALUE;
            } else {
                loggingKt$Logging$2$logRequestBody$1 = new LoggingKt$Logging$2$logRequestBody$1(continuation);
            }
        } else {
            loggingKt$Logging$2$logRequestBody$1 = new LoggingKt$Logging$2$logRequestBody$1(continuation);
        }
        LoggingKt$Logging$2$logRequestBody$1 loggingKt$Logging$2$logRequestBody$2 = loggingKt$Logging$2$logRequestBody$1;
        Object objFilterRequest = loggingKt$Logging$2$logRequestBody$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = loggingKt$Logging$2$logRequestBody$2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objFilterRequest);
            ContentType contentType = outgoingContent.getContentType();
            loggingKt$Logging$2$logRequestBody$2.L$0 = SpillingKt.nullOutSpilledVariable(logBodyFilter);
            loggingKt$Logging$2$logRequestBody$2.L$1 = SpillingKt.nullOutSpilledVariable(url);
            loggingKt$Logging$2$logRequestBody$2.L$2 = SpillingKt.nullOutSpilledVariable(outgoingContent);
            loggingKt$Logging$2$logRequestBody$2.L$3 = SpillingKt.nullOutSpilledVariable(l);
            loggingKt$Logging$2$logRequestBody$2.L$4 = SpillingKt.nullOutSpilledVariable(headers);
            loggingKt$Logging$2$logRequestBody$2.L$5 = httpMethod;
            loggingKt$Logging$2$logRequestBody$2.L$6 = list;
            loggingKt$Logging$2$logRequestBody$2.L$7 = SpillingKt.nullOutSpilledVariable(byteReadChannel);
            loggingKt$Logging$2$logRequestBody$2.label = 1;
            objFilterRequest = logBodyFilter.filterRequest(url, l, contentType, headers, byteReadChannel, loggingKt$Logging$2$logRequestBody$2);
            if (objFilterRequest == coroutine_suspended) {
                return coroutine_suspended;
            }
            list2 = list;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            list2 = (List) loggingKt$Logging$2$logRequestBody$2.L$6;
            httpMethod = (HttpMethod) loggingKt$Logging$2$logRequestBody$2.L$5;
            ResultKt.throwOnFailure(objFilterRequest);
        }
        BodyFilterResult bodyFilterResult = (BodyFilterResult) objFilterRequest;
        if (bodyFilterResult instanceof BodyFilterResult.Empty) {
            list2.add("--> END " + httpMethod.getValue() + " (0-byte body)");
        } else if (bodyFilterResult instanceof BodyFilterResult.Skip) {
            StringBuilder sb = new StringBuilder();
            sb.append("--> END " + httpMethod.getValue() + " (");
            BodyFilterResult.Skip skip = (BodyFilterResult.Skip) bodyFilterResult;
            String reason = skip.getReason();
            if (reason != null) {
                sb.append(reason + ' ');
            }
            Long byteSize = skip.getByteSize();
            if (byteSize != null) {
                sb.append(byteSize.longValue() + "-byte ");
            }
            sb.append("body omitted)");
            list2.add(sb.toString());
        } else {
            if (!(bodyFilterResult instanceof BodyFilterResult.Content)) {
                throw new NoWhenBranchMatchedException();
            }
            list2.add(((BodyFilterResult.Content) bodyFilterResult).read());
            list2.add("--> END " + httpMethod.getValue() + " (" + bodyFilterResult.getByteSize() + "-byte body)");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public static final Object Logging$lambda$0$logOutgoingContent(ClientPluginBuilder<LoggingConfig> clientPluginBuilder, LogBodyFilter logBodyFilter, Url url, OutgoingContent outgoingContent, HttpMethod httpMethod, Headers headers, List<String> list, Function1<? super ByteReadChannel, ? extends ByteReadChannel> function1, Continuation<? super OutgoingContent> continuation) {
        LoggingKt$Logging$2$logOutgoingContent$1 loggingKt$Logging$2$logOutgoingContent$1;
        OutgoingContent outgoingContent2;
        ByteReadChannel byteReadChannel;
        ByteReadChannel byteReadChannel2;
        OutgoingContent outgoingContent3 = outgoingContent;
        if (continuation instanceof LoggingKt$Logging$2$logOutgoingContent$1) {
            loggingKt$Logging$2$logOutgoingContent$1 = (LoggingKt$Logging$2$logOutgoingContent$1) continuation;
            if ((loggingKt$Logging$2$logOutgoingContent$1.label & Integer.MIN_VALUE) != 0) {
                loggingKt$Logging$2$logOutgoingContent$1.label -= Integer.MIN_VALUE;
            } else {
                loggingKt$Logging$2$logOutgoingContent$1 = new LoggingKt$Logging$2$logOutgoingContent$1(continuation);
            }
        } else {
            loggingKt$Logging$2$logOutgoingContent$1 = new LoggingKt$Logging$2$logOutgoingContent$1(continuation);
        }
        LoggingKt$Logging$2$logOutgoingContent$1 loggingKt$Logging$2$logOutgoingContent$2 = loggingKt$Logging$2$logOutgoingContent$1;
        Object obj = loggingKt$Logging$2$logOutgoingContent$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = loggingKt$Logging$2$logOutgoingContent$2.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return null;
            }
            if (i == 3) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            if (i == 4) {
                byteReadChannel2 = (ByteReadChannel) loggingKt$Logging$2$logOutgoingContent$2.L$8;
                outgoingContent3 = (OutgoingContent) loggingKt$Logging$2$logOutgoingContent$2.L$3;
                ResultKt.throwOnFailure(obj);
                return new LoggedContent(outgoingContent3, byteReadChannel2);
            }
            if (i != 5) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            byteReadChannel = (ByteReadChannel) loggingKt$Logging$2$logOutgoingContent$2.L$9;
            outgoingContent2 = (OutgoingContent) loggingKt$Logging$2$logOutgoingContent$2.L$3;
            ResultKt.throwOnFailure(obj);
            return new LoggedContent(outgoingContent2, byteReadChannel);
        }
        ResultKt.throwOnFailure(obj);
        if (outgoingContent3 instanceof ObservableContent) {
            OutgoingContent delegate = ((ObservableContent) outgoingContent3).getDelegate();
            loggingKt$Logging$2$logOutgoingContent$2.L$0 = SpillingKt.nullOutSpilledVariable(clientPluginBuilder);
            loggingKt$Logging$2$logOutgoingContent$2.L$1 = SpillingKt.nullOutSpilledVariable(logBodyFilter);
            loggingKt$Logging$2$logOutgoingContent$2.L$2 = SpillingKt.nullOutSpilledVariable(url);
            loggingKt$Logging$2$logOutgoingContent$2.L$3 = SpillingKt.nullOutSpilledVariable(outgoingContent3);
            loggingKt$Logging$2$logOutgoingContent$2.L$4 = SpillingKt.nullOutSpilledVariable(httpMethod);
            loggingKt$Logging$2$logOutgoingContent$2.L$5 = SpillingKt.nullOutSpilledVariable(headers);
            loggingKt$Logging$2$logOutgoingContent$2.L$6 = SpillingKt.nullOutSpilledVariable(list);
            loggingKt$Logging$2$logOutgoingContent$2.L$7 = SpillingKt.nullOutSpilledVariable(function1);
            loggingKt$Logging$2$logOutgoingContent$2.label = 1;
            Object objLogging$lambda$0$logOutgoingContent = Logging$lambda$0$logOutgoingContent(clientPluginBuilder, logBodyFilter, url, delegate, httpMethod, headers, list, function1, loggingKt$Logging$2$logOutgoingContent$2);
            if (objLogging$lambda$0$logOutgoingContent != coroutine_suspended) {
                return objLogging$lambda$0$logOutgoingContent;
            }
        } else {
            if (outgoingContent3 instanceof MultiPartFormDataContent) {
                MultiPartFormDataContent multiPartFormDataContent = (MultiPartFormDataContent) outgoingContent3;
                for (PartData partData : multiPartFormDataContent.getParts()) {
                    list.add("--" + multiPartFormDataContent.getBoundary());
                    for (Map.Entry<String, List<String>> entry : partData.getHeaders().entries()) {
                        list.add(entry.getKey() + ": " + CollectionsKt.joinToString$default(entry.getValue(), "; ", null, null, 0, null, null, 62, null));
                    }
                    if (partData instanceof PartData.FormItem) {
                        StringBuilder sb = new StringBuilder("Content-Length: ");
                        PartData.FormItem formItem = (PartData.FormItem) partData;
                        sb.append(formItem.getValue().length());
                        list.add(sb.toString());
                        list.add("");
                        list.add(formItem.getValue());
                    } else {
                        list.add("");
                        String str = partData.getHeaders().get("Content-Length");
                        if (str != null) {
                            list.add("binary " + str + "-byte body omitted");
                        } else {
                            list.add("binary body omitted");
                        }
                    }
                }
                list.add("--" + multiPartFormDataContent.getBoundary() + "--");
                StringBuilder sb2 = new StringBuilder("--> END ");
                sb2.append(httpMethod.getValue());
                list.add(sb2.toString());
                return null;
            }
            if (outgoingContent3 instanceof OutgoingContent.ByteArrayContent) {
                byte[] content = ((OutgoingContent.ByteArrayContent) outgoingContent3).getContent();
                Long lBoxLong = Boxing.boxLong(content.length);
                ByteReadChannel byteReadChannelByteReadChannel$default = ByteChannelCtorKt.ByteReadChannel$default(content, 0, 0, 6, null);
                loggingKt$Logging$2$logOutgoingContent$2.L$0 = SpillingKt.nullOutSpilledVariable(clientPluginBuilder);
                loggingKt$Logging$2$logOutgoingContent$2.L$1 = SpillingKt.nullOutSpilledVariable(logBodyFilter);
                loggingKt$Logging$2$logOutgoingContent$2.L$2 = SpillingKt.nullOutSpilledVariable(url);
                loggingKt$Logging$2$logOutgoingContent$2.L$3 = SpillingKt.nullOutSpilledVariable(outgoingContent3);
                loggingKt$Logging$2$logOutgoingContent$2.L$4 = SpillingKt.nullOutSpilledVariable(httpMethod);
                loggingKt$Logging$2$logOutgoingContent$2.L$5 = SpillingKt.nullOutSpilledVariable(headers);
                loggingKt$Logging$2$logOutgoingContent$2.L$6 = SpillingKt.nullOutSpilledVariable(list);
                loggingKt$Logging$2$logOutgoingContent$2.L$7 = SpillingKt.nullOutSpilledVariable(function1);
                loggingKt$Logging$2$logOutgoingContent$2.L$8 = SpillingKt.nullOutSpilledVariable(content);
                loggingKt$Logging$2$logOutgoingContent$2.label = 2;
                if (Logging$lambda$0$logRequestBody(logBodyFilter, url, outgoingContent3, lBoxLong, headers, httpMethod, list, byteReadChannelByteReadChannel$default, loggingKt$Logging$2$logOutgoingContent$2) != coroutine_suspended) {
                    return null;
                }
            } else if (outgoingContent3 instanceof OutgoingContent.ContentWrapper) {
                OutgoingContent delegate2 = ((OutgoingContent.ContentWrapper) outgoingContent3).getDelegate();
                loggingKt$Logging$2$logOutgoingContent$2.L$0 = SpillingKt.nullOutSpilledVariable(clientPluginBuilder);
                loggingKt$Logging$2$logOutgoingContent$2.L$1 = SpillingKt.nullOutSpilledVariable(logBodyFilter);
                loggingKt$Logging$2$logOutgoingContent$2.L$2 = SpillingKt.nullOutSpilledVariable(url);
                loggingKt$Logging$2$logOutgoingContent$2.L$3 = SpillingKt.nullOutSpilledVariable(outgoingContent3);
                loggingKt$Logging$2$logOutgoingContent$2.L$4 = SpillingKt.nullOutSpilledVariable(httpMethod);
                loggingKt$Logging$2$logOutgoingContent$2.L$5 = SpillingKt.nullOutSpilledVariable(headers);
                loggingKt$Logging$2$logOutgoingContent$2.L$6 = SpillingKt.nullOutSpilledVariable(list);
                loggingKt$Logging$2$logOutgoingContent$2.L$7 = SpillingKt.nullOutSpilledVariable(function1);
                loggingKt$Logging$2$logOutgoingContent$2.label = 3;
                Object objLogging$lambda$0$logOutgoingContent2 = Logging$lambda$0$logOutgoingContent(clientPluginBuilder, logBodyFilter, url, delegate2, httpMethod, headers, list, function1, loggingKt$Logging$2$logOutgoingContent$2);
                if (objLogging$lambda$0$logOutgoingContent2 != coroutine_suspended) {
                    return objLogging$lambda$0$logOutgoingContent2;
                }
            } else {
                if (outgoingContent3 instanceof OutgoingContent.NoContent) {
                    list.add("--> END " + httpMethod.getValue());
                    return null;
                }
                if (outgoingContent3 instanceof OutgoingContent.ProtocolUpgrade) {
                    list.add("--> END " + httpMethod.getValue());
                    return null;
                }
                if (outgoingContent3 instanceof OutgoingContent.ReadChannelContent) {
                    Pair<ByteReadChannel, ByteReadChannel> pairSplit = ByteChannelsKt.split(((OutgoingContent.ReadChannelContent) outgoingContent3).getChannel(), clientPluginBuilder.getClient());
                    ByteReadChannel byteReadChannelComponent1 = pairSplit.component1();
                    ByteReadChannel byteReadChannelComponent2 = pairSplit.component2();
                    Long contentLength = outgoingContent3.getContentLength();
                    loggingKt$Logging$2$logOutgoingContent$2.L$0 = SpillingKt.nullOutSpilledVariable(clientPluginBuilder);
                    loggingKt$Logging$2$logOutgoingContent$2.L$1 = SpillingKt.nullOutSpilledVariable(logBodyFilter);
                    loggingKt$Logging$2$logOutgoingContent$2.L$2 = SpillingKt.nullOutSpilledVariable(url);
                    loggingKt$Logging$2$logOutgoingContent$2.L$3 = outgoingContent3;
                    loggingKt$Logging$2$logOutgoingContent$2.L$4 = SpillingKt.nullOutSpilledVariable(httpMethod);
                    loggingKt$Logging$2$logOutgoingContent$2.L$5 = SpillingKt.nullOutSpilledVariable(headers);
                    loggingKt$Logging$2$logOutgoingContent$2.L$6 = SpillingKt.nullOutSpilledVariable(list);
                    loggingKt$Logging$2$logOutgoingContent$2.L$7 = SpillingKt.nullOutSpilledVariable(function1);
                    loggingKt$Logging$2$logOutgoingContent$2.L$8 = byteReadChannelComponent1;
                    loggingKt$Logging$2$logOutgoingContent$2.L$9 = SpillingKt.nullOutSpilledVariable(byteReadChannelComponent2);
                    loggingKt$Logging$2$logOutgoingContent$2.label = 4;
                    if (Logging$lambda$0$logRequestBody(logBodyFilter, url, outgoingContent3, contentLength, headers, httpMethod, list, byteReadChannelComponent2, loggingKt$Logging$2$logOutgoingContent$2) != coroutine_suspended) {
                        byteReadChannel2 = byteReadChannelComponent1;
                        return new LoggedContent(outgoingContent3, byteReadChannel2);
                    }
                } else {
                    if (!(outgoingContent3 instanceof OutgoingContent.WriteChannelContent)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    ByteChannel byteChannel = new ByteChannel(false, 1, null);
                    BuildersKt__Builders_commonKt.launch$default(clientPluginBuilder.getClient(), null, null, new LoggingKt$Logging$2$logOutgoingContent$3(outgoingContent3, byteChannel, null), 3, null);
                    Pair<ByteReadChannel, ByteReadChannel> pairSplit2 = ByteChannelsKt.split(byteChannel, clientPluginBuilder.getClient());
                    ByteReadChannel byteReadChannelComponent3 = pairSplit2.component1();
                    ByteReadChannel byteReadChannelComponent4 = pairSplit2.component2();
                    Long contentLength2 = outgoingContent3.getContentLength();
                    loggingKt$Logging$2$logOutgoingContent$2.L$0 = SpillingKt.nullOutSpilledVariable(clientPluginBuilder);
                    loggingKt$Logging$2$logOutgoingContent$2.L$1 = SpillingKt.nullOutSpilledVariable(logBodyFilter);
                    loggingKt$Logging$2$logOutgoingContent$2.L$2 = SpillingKt.nullOutSpilledVariable(url);
                    loggingKt$Logging$2$logOutgoingContent$2.L$3 = outgoingContent3;
                    loggingKt$Logging$2$logOutgoingContent$2.L$4 = SpillingKt.nullOutSpilledVariable(httpMethod);
                    loggingKt$Logging$2$logOutgoingContent$2.L$5 = SpillingKt.nullOutSpilledVariable(headers);
                    loggingKt$Logging$2$logOutgoingContent$2.L$6 = SpillingKt.nullOutSpilledVariable(list);
                    loggingKt$Logging$2$logOutgoingContent$2.L$7 = SpillingKt.nullOutSpilledVariable(function1);
                    loggingKt$Logging$2$logOutgoingContent$2.L$8 = SpillingKt.nullOutSpilledVariable(byteChannel);
                    loggingKt$Logging$2$logOutgoingContent$2.L$9 = byteReadChannelComponent3;
                    loggingKt$Logging$2$logOutgoingContent$2.L$10 = SpillingKt.nullOutSpilledVariable(byteReadChannelComponent4);
                    loggingKt$Logging$2$logOutgoingContent$2.label = 5;
                    if (Logging$lambda$0$logRequestBody(logBodyFilter, url, outgoingContent3, contentLength2, headers, httpMethod, list, byteReadChannelComponent4, loggingKt$Logging$2$logOutgoingContent$2) != coroutine_suspended) {
                        outgoingContent2 = outgoingContent;
                        byteReadChannel = byteReadChannelComponent3;
                        return new LoggedContent(outgoingContent2, byteReadChannel);
                    }
                }
            }
        }
        return coroutine_suspended;
    }

    static /* synthetic */ Object Logging$lambda$0$logOutgoingContent$default(ClientPluginBuilder clientPluginBuilder, LogBodyFilter logBodyFilter, Url url, OutgoingContent outgoingContent, HttpMethod httpMethod, Headers headers, List list, Function1 function1, Continuation continuation, int i, Object obj) {
        return Logging$lambda$0$logOutgoingContent(clientPluginBuilder, logBodyFilter, url, outgoingContent, httpMethod, headers, list, (i & 128) != 0 ? new Function1() { // from class: io.ktor.client.plugins.logging.LoggingKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return LoggingKt.Logging$lambda$0$logOutgoingContent$2((ByteReadChannel) obj2);
            }
        } : function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x03de, code lost:
    
        if (r0 == r11) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0375, code lost:
    
        if (r0 == r11) goto L102;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object Logging$lambda$0$logRequestOkHttpFormat(java.util.List<io.ktor.client.plugins.logging.SanitizedHeader> r27, io.ktor.client.plugins.logging.LogLevel r28, io.ktor.client.plugins.api.ClientPluginBuilder<io.ktor.client.plugins.logging.LoggingConfig> r29, io.ktor.client.plugins.logging.LogBodyFilter r30, io.ktor.client.request.HttpRequestBuilder r31, java.util.List<java.lang.String> r32, kotlin.coroutines.Continuation<? super io.ktor.http.content.OutgoingContent> r33) {
        /*
            Method dump skipped, instruction units count: 1020
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.logging.LoggingKt.Logging$lambda$0$logRequestOkHttpFormat(java.util.List, io.ktor.client.plugins.logging.LogLevel, io.ktor.client.plugins.api.ClientPluginBuilder, io.ktor.client.plugins.logging.LogBodyFilter, io.ktor.client.request.HttpRequestBuilder, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel Logging$lambda$0$logRequestOkHttpFormat$5(ByteReadChannel channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        return Encoder.decode$default(GZipEncoder.INSTANCE, channel, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object Logging$lambda$0$logResponseBody(LogBodyFilter logBodyFilter, HttpResponse httpResponse, ByteReadChannel byteReadChannel, List<String> list, Continuation<? super Unit> continuation) {
        LoggingKt$Logging$2$logResponseBody$1 loggingKt$Logging$2$logResponseBody$1;
        if (continuation instanceof LoggingKt$Logging$2$logResponseBody$1) {
            loggingKt$Logging$2$logResponseBody$1 = (LoggingKt$Logging$2$logResponseBody$1) continuation;
            if ((loggingKt$Logging$2$logResponseBody$1.label & Integer.MIN_VALUE) != 0) {
                loggingKt$Logging$2$logResponseBody$1.label -= Integer.MIN_VALUE;
            } else {
                loggingKt$Logging$2$logResponseBody$1 = new LoggingKt$Logging$2$logResponseBody$1(continuation);
            }
        } else {
            loggingKt$Logging$2$logResponseBody$1 = new LoggingKt$Logging$2$logResponseBody$1(continuation);
        }
        LoggingKt$Logging$2$logResponseBody$1 loggingKt$Logging$2$logResponseBody$2 = loggingKt$Logging$2$logResponseBody$1;
        Object objFilterResponse = loggingKt$Logging$2$logResponseBody$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = loggingKt$Logging$2$logResponseBody$2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objFilterResponse);
            list.add("");
            Url url = httpResponse.getCall().getRequest().getUrl();
            HttpResponse httpResponse2 = httpResponse;
            Long lContentLength = HttpMessagePropertiesKt.contentLength(httpResponse2);
            ContentType contentType = HttpMessagePropertiesKt.contentType(httpResponse2);
            Headers headers = httpResponse.getHeaders();
            loggingKt$Logging$2$logResponseBody$2.L$0 = SpillingKt.nullOutSpilledVariable(logBodyFilter);
            loggingKt$Logging$2$logResponseBody$2.L$1 = httpResponse;
            loggingKt$Logging$2$logResponseBody$2.L$2 = SpillingKt.nullOutSpilledVariable(byteReadChannel);
            loggingKt$Logging$2$logResponseBody$2.L$3 = list;
            loggingKt$Logging$2$logResponseBody$2.label = 1;
            objFilterResponse = logBodyFilter.filterResponse(url, lContentLength, contentType, headers, byteReadChannel, loggingKt$Logging$2$logResponseBody$2);
            if (objFilterResponse == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            list = (List) loggingKt$Logging$2$logResponseBody$2.L$3;
            httpResponse = (HttpResponse) loggingKt$Logging$2$logResponseBody$2.L$1;
            ResultKt.throwOnFailure(objFilterResponse);
        }
        BodyFilterResult bodyFilterResult = (BodyFilterResult) objFilterResponse;
        long timestamp = httpResponse.getResponseTime().getTimestamp() - httpResponse.getRequestTime().getTimestamp();
        if (bodyFilterResult instanceof BodyFilterResult.Empty) {
            list.add("<-- END HTTP (" + timestamp + "ms, 0-byte body)");
        } else if (bodyFilterResult instanceof BodyFilterResult.Skip) {
            StringBuilder sb = new StringBuilder("<-- END HTTP (");
            sb.append(timestamp);
            sb.append("ms, ");
            BodyFilterResult.Skip skip = (BodyFilterResult.Skip) bodyFilterResult;
            String reason = skip.getReason();
            if (reason != null) {
                sb.append(reason + ' ');
            }
            Long byteSize = skip.getByteSize();
            if (byteSize != null) {
                sb.append(byteSize.longValue() + "-byte ");
            }
            sb.append("body omitted)");
            list.add(sb.toString());
        } else {
            if (!(bodyFilterResult instanceof BodyFilterResult.Content)) {
                throw new NoWhenBranchMatchedException();
            }
            list.add(((BodyFilterResult.Content) bodyFilterResult).read());
            list.add("<-- END HTTP (" + timestamp + "ms, " + bodyFilterResult.getByteSize() + "-byte body)");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    public static final Object Logging$lambda$0$logResponseOkHttpFormat(List<SanitizedHeader> list, LogLevel logLevel, LogBodyFilter logBodyFilter, HttpResponse httpResponse, List<String> list2, Continuation<? super HttpResponse> continuation) {
        LoggingKt$Logging$2$logResponseOkHttpFormat$1 loggingKt$Logging$2$logResponseOkHttpFormat$1;
        String str;
        final ByteReadChannel byteReadChannel;
        Long l;
        Object next;
        HttpResponse httpResponse2 = httpResponse;
        if (continuation instanceof LoggingKt$Logging$2$logResponseOkHttpFormat$1) {
            loggingKt$Logging$2$logResponseOkHttpFormat$1 = (LoggingKt$Logging$2$logResponseOkHttpFormat$1) continuation;
            if ((loggingKt$Logging$2$logResponseOkHttpFormat$1.label & Integer.MIN_VALUE) != 0) {
                loggingKt$Logging$2$logResponseOkHttpFormat$1.label -= Integer.MIN_VALUE;
            } else {
                loggingKt$Logging$2$logResponseOkHttpFormat$1 = new LoggingKt$Logging$2$logResponseOkHttpFormat$1(continuation);
            }
        } else {
            loggingKt$Logging$2$logResponseOkHttpFormat$1 = new LoggingKt$Logging$2$logResponseOkHttpFormat$1(continuation);
        }
        Object obj = loggingKt$Logging$2$logResponseOkHttpFormat$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = loggingKt$Logging$2$logResponseOkHttpFormat$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!Logging$lambda$0$isNone(logLevel)) {
                String str2 = httpResponse2.getHeaders().get("Content-Length");
                Long longOrNull = str2 != null ? StringsKt.toLongOrNull(str2) : null;
                HttpRequest request = HttpResponseKt.getRequest(httpResponse2);
                long timestamp = httpResponse2.getResponseTime().getTimestamp() - httpResponse2.getRequestTime().getTimestamp();
                if (Intrinsics.areEqual(httpResponse2.getHeaders().get("Transfer-Encoding"), "chunked") && (Logging$lambda$0$isInfo(logLevel) || Logging$lambda$0$isHeaders(logLevel))) {
                    str = "<-- " + httpResponse2.getStatus() + ' ' + pathQuery(request.getUrl()) + " (" + timestamp + "ms, unknown-byte body)";
                } else if (Logging$lambda$0$isInfo(logLevel) && longOrNull != null) {
                    str = "<-- " + httpResponse2.getStatus() + ' ' + pathQuery(request.getUrl()) + " (" + timestamp + "ms, " + longOrNull.longValue() + "-byte body)";
                } else if (Logging$lambda$0$isBody(logLevel) || ((Logging$lambda$0$isInfo(logLevel) && longOrNull == null) || ((Logging$lambda$0$isHeaders(logLevel) && longOrNull != null) || Intrinsics.areEqual(httpResponse2.getHeaders().get("Content-Encoding"), "gzip")))) {
                    str = "<-- " + httpResponse2.getStatus() + ' ' + pathQuery(request.getUrl()) + " (" + timestamp + "ms)";
                } else {
                    str = "<-- " + httpResponse2.getStatus() + ' ' + pathQuery(request.getUrl()) + " (" + timestamp + "ms, unknown-byte body)";
                }
                list2.add(str);
                if (Logging$lambda$0$isHeaders(logLevel) || Logging$lambda$0$isBody(logLevel)) {
                    for (Map.Entry<String, List<String>> entry : httpResponse2.getHeaders().entries()) {
                        String key = entry.getKey();
                        List<String> value = entry.getValue();
                        Iterator<T> it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                l = longOrNull;
                                next = null;
                                break;
                            }
                            next = it.next();
                            l = longOrNull;
                            if (((SanitizedHeader) next).getPredicate().invoke(key).booleanValue()) {
                                break;
                            }
                            longOrNull = l;
                        }
                        if (next == null) {
                            list2.add(key + ": " + CollectionsKt.joinToString$default(value, ", ", null, null, 0, null, null, 62, null));
                        } else {
                            list2.add(key + ": ██");
                        }
                        longOrNull = l;
                    }
                    Long l2 = longOrNull;
                    if (!Logging$lambda$0$isBody(logLevel)) {
                        list2.add("<-- END HTTP");
                        return httpResponse2;
                    }
                    if (l2 != null && l2.longValue() == 0) {
                        list2.add("<-- END HTTP (" + timestamp + "ms, " + l2.longValue() + "-byte body)");
                        return httpResponse2;
                    }
                    if (Intrinsics.areEqual(HttpMessagePropertiesKt.contentType(httpResponse2), ContentType.Text.INSTANCE.getEventStream())) {
                        list2.add("<-- END HTTP (streaming)");
                        return httpResponse2;
                    }
                    if (DoubleReceivePluginKt.isSaved(httpResponse2)) {
                        ByteReadChannel rawContent = httpResponse2.getRawContent();
                        loggingKt$Logging$2$logResponseOkHttpFormat$1.L$0 = SpillingKt.nullOutSpilledVariable(list);
                        loggingKt$Logging$2$logResponseOkHttpFormat$1.L$1 = SpillingKt.nullOutSpilledVariable(logLevel);
                        loggingKt$Logging$2$logResponseOkHttpFormat$1.L$2 = SpillingKt.nullOutSpilledVariable(logBodyFilter);
                        loggingKt$Logging$2$logResponseOkHttpFormat$1.L$3 = httpResponse2;
                        loggingKt$Logging$2$logResponseOkHttpFormat$1.L$4 = SpillingKt.nullOutSpilledVariable(list2);
                        loggingKt$Logging$2$logResponseOkHttpFormat$1.L$5 = SpillingKt.nullOutSpilledVariable(l2);
                        loggingKt$Logging$2$logResponseOkHttpFormat$1.L$6 = SpillingKt.nullOutSpilledVariable(request);
                        loggingKt$Logging$2$logResponseOkHttpFormat$1.L$7 = SpillingKt.nullOutSpilledVariable(str);
                        loggingKt$Logging$2$logResponseOkHttpFormat$1.J$0 = timestamp;
                        loggingKt$Logging$2$logResponseOkHttpFormat$1.label = 1;
                        if (Logging$lambda$0$logResponseBody(logBodyFilter, httpResponse2, rawContent, list2, loggingKt$Logging$2$logResponseOkHttpFormat$1) == coroutine_suspended) {
                        }
                    } else {
                        Pair<ByteReadChannel, ByteReadChannel> pairSplit = ByteChannelsKt.split(httpResponse2.getRawContent(), httpResponse2);
                        ByteReadChannel byteReadChannelComponent1 = pairSplit.component1();
                        ByteReadChannel byteReadChannelComponent2 = pairSplit.component2();
                        loggingKt$Logging$2$logResponseOkHttpFormat$1.L$0 = SpillingKt.nullOutSpilledVariable(list);
                        loggingKt$Logging$2$logResponseOkHttpFormat$1.L$1 = SpillingKt.nullOutSpilledVariable(logLevel);
                        loggingKt$Logging$2$logResponseOkHttpFormat$1.L$2 = SpillingKt.nullOutSpilledVariable(logBodyFilter);
                        loggingKt$Logging$2$logResponseOkHttpFormat$1.L$3 = httpResponse2;
                        loggingKt$Logging$2$logResponseOkHttpFormat$1.L$4 = SpillingKt.nullOutSpilledVariable(list2);
                        loggingKt$Logging$2$logResponseOkHttpFormat$1.L$5 = SpillingKt.nullOutSpilledVariable(l2);
                        loggingKt$Logging$2$logResponseOkHttpFormat$1.L$6 = SpillingKt.nullOutSpilledVariable(request);
                        loggingKt$Logging$2$logResponseOkHttpFormat$1.L$7 = SpillingKt.nullOutSpilledVariable(str);
                        loggingKt$Logging$2$logResponseOkHttpFormat$1.L$8 = byteReadChannelComponent1;
                        loggingKt$Logging$2$logResponseOkHttpFormat$1.L$9 = SpillingKt.nullOutSpilledVariable(byteReadChannelComponent2);
                        loggingKt$Logging$2$logResponseOkHttpFormat$1.J$0 = timestamp;
                        loggingKt$Logging$2$logResponseOkHttpFormat$1.label = 2;
                        if (Logging$lambda$0$logResponseBody(logBodyFilter, httpResponse2, byteReadChannelComponent2, list2, loggingKt$Logging$2$logResponseOkHttpFormat$1) != coroutine_suspended) {
                            byteReadChannel = byteReadChannelComponent1;
                        }
                    }
                    return coroutine_suspended;
                }
            }
            return httpResponse2;
        }
        if (i == 1) {
            long j = loggingKt$Logging$2$logResponseOkHttpFormat$1.J$0;
            HttpResponse httpResponse3 = (HttpResponse) loggingKt$Logging$2$logResponseOkHttpFormat$1.L$3;
            ResultKt.throwOnFailure(obj);
            return httpResponse3;
        }
        if (i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        long j2 = loggingKt$Logging$2$logResponseOkHttpFormat$1.J$0;
        byteReadChannel = (ByteReadChannel) loggingKt$Logging$2$logResponseOkHttpFormat$1.L$8;
        httpResponse2 = (HttpResponse) loggingKt$Logging$2$logResponseOkHttpFormat$1.L$3;
        ResultKt.throwOnFailure(obj);
        return DelegatedCallKt.replaceResponse$default(httpResponse2.getCall(), null, new Function1() { // from class: io.ktor.client.plugins.logging.LoggingKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return LoggingKt.Logging$lambda$0$logResponseOkHttpFormat$8(byteReadChannel, (HttpResponse) obj2);
            }
        }, 1, null).getResponse();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object Logging$lambda$0$logRequestBody$9(OutgoingContent outgoingContent, HttpClientCallLogger httpClientCallLogger, Continuation<? super OutgoingContent> continuation) {
        Charset charset;
        StringBuilder sb = new StringBuilder();
        sb.append("BODY Content-Type: " + outgoingContent.getContentType());
        sb.append('\n');
        ContentType contentType = outgoingContent.getContentType();
        if (contentType == null || (charset = ContentTypesKt.charset(contentType)) == null) {
            charset = Charsets.UTF_8;
        }
        ByteChannel byteChannel = new ByteChannel(false, 1, null);
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getDefault().plus(KtorMDCContext_jvmKt.MDCContext()), null, new LoggingKt$Logging$2$logRequestBody$4(byteChannel, charset, sb, httpClientCallLogger, null), 2, null);
        return ObservingUtilsKt.observe(outgoingContent, byteChannel, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Logging$lambda$0$logRequestException(LogLevel logLevel, Logger logger, HttpRequestBuilder httpRequestBuilder, Throwable th) {
        if (logLevel.getInfo()) {
            logger.log("REQUEST " + URLUtilsKt.Url(httpRequestBuilder.getUrl()) + " failed with exception: " + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object Logging$lambda$0$logRequest(Logger logger, LogLevel logLevel, List<SanitizedHeader> list, HttpRequestBuilder httpRequestBuilder, Continuation<? super OutgoingContent> continuation) throws IOException {
        Object next;
        Object next2;
        Object body = httpRequestBuilder.getBody();
        Intrinsics.checkNotNull(body, "null cannot be cast to non-null type io.ktor.http.content.OutgoingContent");
        OutgoingContent outgoingContent = (OutgoingContent) body;
        HttpClientCallLogger httpClientCallLogger = new HttpClientCallLogger(logger);
        httpRequestBuilder.getAttributes().put(ClientCallLogger, httpClientCallLogger);
        StringBuilder sb = new StringBuilder();
        if (logLevel.getInfo()) {
            sb.append("REQUEST: " + URLUtilsKt.Url(httpRequestBuilder.getUrl()));
            sb.append('\n');
            sb.append("METHOD: " + httpRequestBuilder.getMethod());
            sb.append('\n');
        }
        if (logLevel.getHeaders()) {
            sb.append("COMMON HEADERS\n");
            StringBuilder sb2 = sb;
            LoggingUtilsKt.logHeaders(sb2, httpRequestBuilder.getHeaders().entries(), list);
            sb.append("CONTENT HEADERS\n");
            List<SanitizedHeader> list2 = list;
            Iterator<T> it = list2.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!((SanitizedHeader) next).getPredicate().invoke("Content-Length").booleanValue());
            SanitizedHeader sanitizedHeader = (SanitizedHeader) next;
            String placeholder = sanitizedHeader != null ? sanitizedHeader.getPlaceholder() : null;
            Iterator<T> it2 = list2.iterator();
            do {
                if (!it2.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it2.next();
            } while (!((SanitizedHeader) next2).getPredicate().invoke("Content-Type").booleanValue());
            SanitizedHeader sanitizedHeader2 = (SanitizedHeader) next2;
            String placeholder2 = sanitizedHeader2 != null ? sanitizedHeader2.getPlaceholder() : null;
            Long contentLength = outgoingContent.getContentLength();
            if (contentLength != null) {
                long jLongValue = contentLength.longValue();
                if (placeholder == null) {
                    placeholder = String.valueOf(jLongValue);
                }
                LoggingUtilsKt.logHeader(sb2, "Content-Length", placeholder);
            }
            ContentType contentType = outgoingContent.getContentType();
            if (contentType != null) {
                if (placeholder2 == null) {
                    placeholder2 = contentType.toString();
                }
                LoggingUtilsKt.logHeader(sb2, "Content-Type", placeholder2);
            }
            LoggingUtilsKt.logHeaders(sb2, outgoingContent.getHeaders().entries(), list);
        }
        String string = sb.toString();
        String str = string;
        if (str.length() > 0) {
            httpClientCallLogger.logRequest(string);
        }
        if (str.length() == 0 || !logLevel.getBody()) {
            httpClientCallLogger.closeRequestLog();
            return null;
        }
        return Logging$lambda$0$logRequestBody$9(outgoingContent, httpClientCallLogger, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Logging$lambda$0$logResponseException(LogLevel logLevel, StringBuilder sb, HttpRequest httpRequest, Throwable th) {
        if (logLevel.getInfo()) {
            sb.append("RESPONSE " + httpRequest.getUrl() + " failed with exception: " + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Logging$lambda$0$11(LogLevel logLevel, ResponseObserverConfig prepare) {
        Intrinsics.checkNotNullParameter(prepare, "$this$prepare");
        prepare.filter(new Function1() { // from class: io.ktor.client.plugins.logging.LoggingKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(LoggingKt.Logging$lambda$0$11$0((HttpClientCall) obj));
            }
        });
        prepare.onResponse(new LoggingKt$Logging$2$responseObserver$1$2(logLevel, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Logging$lambda$0$11$0(HttpClientCall it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !DoubleReceivePluginKt.isSaved(it.getResponse());
    }

    private static final String pathQuery(Url url) {
        StringBuilder sb = new StringBuilder();
        if (url.getEncodedPath().length() == 0) {
            sb.append(DomExceptionUtils.SEPARATOR);
        } else {
            sb.append(url.getEncodedPath());
        }
        if (url.getEncodedQuery().length() != 0) {
            sb.append("?");
            sb.append(url.getEncodedQuery());
        }
        return sb.toString();
    }

    private static final long computeRequestBodySize(Object obj) {
        if (!(obj instanceof OutgoingContent)) {
            throw new IllegalStateException("Check failed.");
        }
        OutgoingContent outgoingContent = (OutgoingContent) obj;
        if (outgoingContent instanceof OutgoingContent.ByteArrayContent) {
            return ((OutgoingContent.ByteArrayContent) obj).getContent().length;
        }
        if (outgoingContent instanceof OutgoingContent.ContentWrapper) {
            return computeRequestBodySize(((OutgoingContent.ContentWrapper) obj).getDelegate());
        }
        if ((outgoingContent instanceof OutgoingContent.NoContent) || (outgoingContent instanceof OutgoingContent.ProtocolUpgrade)) {
            return 0L;
        }
        throw new IllegalStateException(("Unable to calculate the size for type " + Reflection.getOrCreateKotlinClass(obj.getClass()).getSimpleName()).toString());
    }

    public static /* synthetic */ void Logging$default(HttpClientConfig httpClientConfig, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.plugins.logging.LoggingKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return LoggingKt.Logging$lambda$1((LoggingConfig) obj2);
                }
            };
        }
        Logging(httpClientConfig, function1);
    }

    static final Unit Logging$lambda$1(LoggingConfig loggingConfig) {
        Intrinsics.checkNotNullParameter(loggingConfig, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void Logging(HttpClientConfig<?> httpClientConfig, Function1<? super LoggingConfig, Unit> block) {
        Intrinsics.checkNotNullParameter(httpClientConfig, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        httpClientConfig.install(Logging, block);
    }

    static {
        KType kTypeTypeOf;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(HttpClientCallLogger.class);
        KType kTypeTypeOf2 = null;
        try {
            kTypeTypeOf = Reflection.typeOf(HttpClientCallLogger.class);
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        ClientCallLogger = new AttributeKey<>("CallLogger", new TypeInfo(orCreateKotlinClass, kTypeTypeOf));
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Unit.class);
        try {
            kTypeTypeOf2 = Reflection.typeOf(Unit.class);
        } catch (Throwable unused2) {
        }
        DisableLogging = new AttributeKey<>("DisableLogging", new TypeInfo(orCreateKotlinClass2, kTypeTypeOf2));
        Logging = CreatePluginUtilsKt.createClientPlugin("Logging", AnonymousClass1.INSTANCE, new Function1() { // from class: io.ktor.client.plugins.logging.LoggingKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LoggingKt.Logging$lambda$0((ClientPluginBuilder) obj);
            }
        });
    }
}

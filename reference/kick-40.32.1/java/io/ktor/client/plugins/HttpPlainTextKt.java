package io.ktor.client.plugins;

import com.datadog.android.webview.internal.log.WebViewLogEventConsumer;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.TextContent;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import io.ktor.utils.io.core.StringsKt;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.Charsets;
import kotlinx.io.Source;
import org.slf4j.Logger;

/* JADX INFO: compiled from: HttpPlainText.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a.\u0010\u0006\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\u0004\b\u0006\u0010\u0007\"\u0018\u0010\n\u001a\u00060\bj\u0002`\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b\"\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/client/HttpClientConfig;", "Lkotlin/Function1;", "Lio/ktor/client/plugins/HttpPlainTextConfig;", "", "Lkotlin/ExtensionFunctionType;", "block", "Charsets", "(Lio/ktor/client/HttpClientConfig;Lkotlin/jvm/functions/Function1;)V", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "Lio/ktor/client/plugins/api/ClientPlugin;", "HttpPlainText", "Lio/ktor/client/plugins/api/ClientPlugin;", "getHttpPlainText", "()Lio/ktor/client/plugins/api/ClientPlugin;", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class HttpPlainTextKt {
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.HttpPlainText");
    private static final ClientPlugin<HttpPlainTextConfig> HttpPlainText = CreatePluginUtilsKt.createClientPlugin("HttpPlainText", HttpPlainTextKt$HttpPlainText$1.INSTANCE, new Function1() { // from class: io.ktor.client.plugins.HttpPlainTextKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return HttpPlainTextKt.HttpPlainText$lambda$0((ClientPluginBuilder) obj);
        }
    });

    public static final ClientPlugin<HttpPlainTextConfig> getHttpPlainText() {
        return HttpPlainText;
    }

    static final Unit HttpPlainText$lambda$0(ClientPluginBuilder createClientPlugin) {
        Intrinsics.checkNotNullParameter(createClientPlugin, "$this$createClientPlugin");
        List<Pair> listSortedWith = CollectionsKt.sortedWith(MapsKt.toList(((HttpPlainTextConfig) createClientPlugin.getPluginConfig()).getCharsetQuality$ktor_client_core()), new Comparator() { // from class: io.ktor.client.plugins.HttpPlainTextKt$HttpPlainText$lambda$0$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues((Float) ((Pair) t2).getSecond(), (Float) ((Pair) t).getSecond());
            }
        });
        Charset responseCharsetFallback = ((HttpPlainTextConfig) createClientPlugin.getPluginConfig()).getResponseCharsetFallback();
        Set<Charset> charsets$ktor_client_core = ((HttpPlainTextConfig) createClientPlugin.getPluginConfig()).getCharsets$ktor_client_core();
        ArrayList arrayList = new ArrayList();
        for (Object obj : charsets$ktor_client_core) {
            if (!((HttpPlainTextConfig) createClientPlugin.getPluginConfig()).getCharsetQuality$ktor_client_core().containsKey((Charset) obj)) {
                arrayList.add(obj);
            }
        }
        List<Charset> listSortedWith2 = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: io.ktor.client.plugins.HttpPlainTextKt$HttpPlainText$lambda$0$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(CharsetJVMKt.getName((Charset) t), CharsetJVMKt.getName((Charset) t2));
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Charset charset : listSortedWith2) {
            if (sb.length() > 0) {
                sb.append(WebViewLogEventConsumer.DDTAGS_SEPARATOR);
            }
            sb.append(CharsetJVMKt.getName(charset));
        }
        for (Pair pair : listSortedWith) {
            Charset charset2 = (Charset) pair.component1();
            float fFloatValue = ((Number) pair.component2()).floatValue();
            if (sb.length() > 0) {
                sb.append(WebViewLogEventConsumer.DDTAGS_SEPARATOR);
            }
            double d = fFloatValue;
            if (0.0d > d || d > 1.0d) {
                throw new IllegalStateException("Check failed.");
            }
            sb.append(CharsetJVMKt.getName(charset2) + ";q=" + (((double) MathKt.roundToInt(100.0f * fFloatValue)) / 100.0d));
        }
        if (sb.length() == 0) {
            sb.append(CharsetJVMKt.getName(responseCharsetFallback));
        }
        String string = sb.toString();
        Charset sendCharset = ((HttpPlainTextConfig) createClientPlugin.getPluginConfig()).getSendCharset();
        if (sendCharset == null && (sendCharset = (Charset) CollectionsKt.firstOrNull(listSortedWith2)) == null) {
            Pair pair2 = (Pair) CollectionsKt.firstOrNull(listSortedWith);
            sendCharset = pair2 != null ? (Charset) pair2.getFirst() : null;
            if (sendCharset == null) {
                sendCharset = Charsets.UTF_8;
            }
        }
        createClientPlugin.on(RenderRequestHook.INSTANCE, new HttpPlainTextKt$HttpPlainText$2$1(string, sendCharset, null));
        createClientPlugin.transformResponseBody(new HttpPlainTextKt$HttpPlainText$2$2(responseCharsetFallback, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OutgoingContent HttpPlainText$lambda$0$wrapContent(Charset charset, HttpRequestBuilder httpRequestBuilder, String str, ContentType contentType) {
        Charset charset2;
        ContentType plain = contentType == null ? ContentType.Text.INSTANCE.getPlain() : contentType;
        if (contentType != null && (charset2 = ContentTypesKt.charset(contentType)) != null) {
            charset = charset2;
        }
        LOGGER.trace("Sending request body to " + httpRequestBuilder.getUrl() + " as text/plain with charset " + charset);
        return new TextContent(str, ContentTypesKt.withCharset(plain, charset), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String HttpPlainText$lambda$0$read(Charset charset, HttpClientCall httpClientCall, Source source) {
        Charset charset2 = HttpMessagePropertiesKt.charset(httpClientCall.getResponse());
        if (charset2 != null) {
            charset = charset2;
        }
        LOGGER.trace("Reading response body for " + httpClientCall.getRequest().getUrl() + " as String with charset " + charset);
        return StringsKt.readText$default(source, charset, 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HttpPlainText$lambda$0$addCharsetHeaders(String str, HttpRequestBuilder httpRequestBuilder) {
        if (httpRequestBuilder.getHeaders().get("Accept-Charset") != null) {
            return;
        }
        LOGGER.trace("Adding Accept-Charset=" + str + " to " + httpRequestBuilder.getUrl());
        httpRequestBuilder.getHeaders().set("Accept-Charset", str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void Charsets(HttpClientConfig<?> httpClientConfig, Function1<? super HttpPlainTextConfig, Unit> block) {
        Intrinsics.checkNotNullParameter(httpClientConfig, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        httpClientConfig.install(HttpPlainText, block);
    }
}

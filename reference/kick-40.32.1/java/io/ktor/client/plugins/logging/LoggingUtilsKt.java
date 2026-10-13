package io.ktor.client.plugins.logging;

import androidx.media3.muxer.WebmConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.core.StringsKt;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.io.Source;
import org.bouncycastle.asn1.eac.EACTags;

/* JADX INFO: compiled from: LoggingUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aE\u0010\n\u001a\u00020\t*\u00060\u0000j\u0002`\u00012\u001e\u0010\u0006\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u00030\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a'\u0010\u000e\u001a\u00020\t*\u00060\u0000j\u0002`\u00012\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a9\u0010\u0017\u001a\u00020\t2\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005H\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\"\u0010\u001d\u001a\u0004\u0018\u00010\u0004*\u00020\u00192\n\u0010\u001c\u001a\u00060\u001aj\u0002`\u001bH\u0080H¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001c\u0010 \u001a\u00020\t*\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0080@¢\u0006\u0004\b \u0010!\u001a*\u0010%\u001a\u00020\t*\u00060\u0010j\u0002`\u00112\b\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010$\u001a\u00020\u0019H\u0080@¢\u0006\u0004\b%\u0010&¨\u0006'"}, d2 = {"Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "", "", "", "", "headers", "Lio/ktor/client/plugins/logging/SanitizedHeader;", "sanitizedHeaders", "", "logHeaders", "(Ljava/lang/Appendable;Ljava/util/Set;Ljava/util/List;)V", "key", "value", "logHeader", "(Ljava/lang/Appendable;Ljava/lang/String;Ljava/lang/String;)V", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "log", "Lio/ktor/client/statement/HttpResponse;", "response", "Lio/ktor/client/plugins/logging/LogLevel;", FirebaseAnalytics.Param.LEVEL, "logResponseHeader", "(Ljava/lang/StringBuilder;Lio/ktor/client/statement/HttpResponse;Lio/ktor/client/plugins/logging/LogLevel;Ljava/util/List;)V", "Lio/ktor/utils/io/ByteReadChannel;", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", HttpAuthHeader.Parameters.Charset, "tryReadText", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/plugins/logging/HttpClientCallLogger;", "logResponseBody", "(Lio/ktor/client/plugins/logging/HttpClientCallLogger;Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/http/ContentType;", "contentType", "content", "appendResponseBody", "(Ljava/lang/StringBuilder;Lio/ktor/http/ContentType;Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-logging"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class LoggingUtilsKt {

    /* JADX INFO: renamed from: io.ktor.client.plugins.logging.LoggingUtilsKt$appendResponseBody$1, reason: invalid class name */
    /* JADX INFO: compiled from: LoggingUtils.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.logging.LoggingUtilsKt", f = "LoggingUtils.kt", i = {0, 0, 0, 0, 0, 0}, l = {79}, m = "appendResponseBody", n = {"$this$appendResponseBody", "contentType", "content", "$this$tryReadText$iv", "charset$iv", "$i$f$tryReadText"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LoggingUtilsKt.appendResponseBody(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.logging.LoggingUtilsKt$logResponseBody$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LoggingUtils.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.logging.LoggingUtilsKt", f = "LoggingUtils.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3}, l = {EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION, 62, 62, 62}, m = "logResponseBody", n = {"$this$logResponseBody", "response", "log", "$this$logResponseBody", "response", "log", "$this$logResponseBody", "response", "log", "$this$logResponseBody", "response", "log"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 1)
    static final class C09771 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C09771(Continuation<? super C09771> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LoggingUtilsKt.logResponseBody(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.logging.LoggingUtilsKt$tryReadText$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LoggingUtils.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    @DebugMetadata(c = "io.ktor.client.plugins.logging.LoggingUtilsKt", f = "LoggingUtils.kt", i = {0, 0, 0}, l = {50}, m = "tryReadText", n = {"$this$tryReadText", HttpAuthHeader.Parameters.Charset, "$i$f$tryReadText"}, s = {"L$0", "L$1", "I$0"}, v = 1)
    static final class C09781 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C09781(Continuation<? super C09781> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LoggingUtilsKt.tryReadText(null, null, this);
        }
    }

    public static final void logHeaders(Appendable appendable, Set<? extends Map.Entry<String, ? extends List<String>>> headers, List<SanitizedHeader> sanitizedHeaders) throws IOException {
        Object next;
        Intrinsics.checkNotNullParameter(appendable, "<this>");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(sanitizedHeaders, "sanitizedHeaders");
        for (Map.Entry entry : CollectionsKt.sortedWith(CollectionsKt.toList(headers), new Comparator() { // from class: io.ktor.client.plugins.logging.LoggingUtilsKt$logHeaders$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues((String) ((Map.Entry) t).getKey(), (String) ((Map.Entry) t2).getKey());
            }
        })) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            Iterator<T> it = sanitizedHeaders.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!((SanitizedHeader) next).getPredicate().invoke(str).booleanValue());
            SanitizedHeader sanitizedHeader = (SanitizedHeader) next;
            String placeholder = sanitizedHeader != null ? sanitizedHeader.getPlaceholder() : null;
            if (placeholder == null) {
                placeholder = CollectionsKt.joinToString$default(list, "; ", null, null, 0, null, null, 62, null);
            }
            logHeader(appendable, str, placeholder);
        }
    }

    public static final void logHeader(Appendable appendable, String key, String value) throws IOException {
        Intrinsics.checkNotNullParameter(appendable, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        appendable.append("-> " + key + ": " + value).append('\n');
    }

    public static final void logResponseHeader(StringBuilder log, HttpResponse response, LogLevel level, List<SanitizedHeader> sanitizedHeaders) throws IOException {
        Intrinsics.checkNotNullParameter(log, "log");
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(sanitizedHeaders, "sanitizedHeaders");
        if (level.getInfo()) {
            log.append("RESPONSE: " + response.getStatus());
            log.append('\n');
            log.append("METHOD: " + response.getCall().getRequest().getMethod());
            log.append('\n');
            log.append("FROM: " + response.getCall().getRequest().getUrl());
            log.append('\n');
        }
        if (level.getHeaders()) {
            log.append("COMMON HEADERS");
            log.append('\n');
            logHeaders(log, response.getHeaders().entries(), sanitizedHeaders);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object tryReadText(ByteReadChannel byteReadChannel, Charset charset, Continuation<? super String> continuation) {
        C09781 c09781;
        if (continuation instanceof C09781) {
            c09781 = (C09781) continuation;
            if ((c09781.label & Integer.MIN_VALUE) != 0) {
                c09781.label -= Integer.MIN_VALUE;
            } else {
                c09781 = new C09781(continuation);
            }
        } else {
            c09781 = new C09781(continuation);
        }
        Object remaining = c09781.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09781.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(remaining);
                c09781.L$0 = SpillingKt.nullOutSpilledVariable(byteReadChannel);
                c09781.L$1 = charset;
                c09781.I$0 = 0;
                c09781.label = 1;
                remaining = ByteReadChannelOperationsKt.readRemaining(byteReadChannel, c09781);
                if (remaining == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c09781.I$0;
                charset = (Charset) c09781.L$1;
                ResultKt.throwOnFailure(remaining);
            }
            return StringsKt.readText$default((Source) remaining, charset, 0, 2, null);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static final Object tryReadText$$forInline(ByteReadChannel byteReadChannel, Charset charset, Continuation<? super String> continuation) {
        try {
            return StringsKt.readText$default((Source) ByteReadChannelOperationsKt.readRemaining(byteReadChannel, continuation), charset, 0, 2, null);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c2, code lost:
    
        if (r9.logResponseBody(r2, r0) == r1) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ee, code lost:
    
        if (r9.logResponseBody(r2, r0) == r1) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object logResponseBody(io.ktor.client.plugins.logging.HttpClientCallLogger r9, io.ktor.client.statement.HttpResponse r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.logging.LoggingUtilsKt.logResponseBody(io.ktor.client.plugins.logging.HttpClientCallLogger, io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object appendResponseBody(StringBuilder sb, ContentType contentType, ByteReadChannel byteReadChannel, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Charset charset;
        StringBuilder sb2;
        Charset charset2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        String text$default = null;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            sb.append("BODY Content-Type: " + contentType);
            sb.append('\n');
            sb.append("BODY START");
            sb.append('\n');
            if (contentType == null || (charset = ContentTypesKt.charset(contentType)) == null) {
                charset = Charsets.UTF_8;
            }
            try {
                anonymousClass1.L$0 = sb;
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(contentType);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(byteReadChannel);
                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(byteReadChannel);
                anonymousClass1.L$4 = charset;
                anonymousClass1.I$0 = 0;
                anonymousClass1.label = 1;
                Object remaining = ByteReadChannelOperationsKt.readRemaining(byteReadChannel, anonymousClass1);
                if (remaining == coroutine_suspended) {
                    return coroutine_suspended;
                }
                sb2 = sb;
                charset2 = charset;
                obj = remaining;
            } catch (Throwable unused) {
                sb2 = sb;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = anonymousClass1.I$0;
            charset2 = (Charset) anonymousClass1.L$4;
            sb2 = (StringBuilder) anonymousClass1.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable unused2) {
                sb = sb2;
                sb2 = sb;
            }
        }
        text$default = StringsKt.readText$default((Source) obj, charset2, 0, 2, null);
        if (text$default == null) {
            text$default = "[response body omitted]";
        }
        sb2.append(text$default);
        sb2.append("\nBODY END");
        return Unit.INSTANCE;
    }
}

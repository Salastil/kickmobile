package io.ktor.http.cio;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.datadog.android.log.LogAttributes;
import com.datadog.android.trace.internal.ApmNetworkInstrumentation;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.http.HttpMethod;
import io.ktor.http.cio.internals.AsciiCharTree;
import io.ktor.http.cio.internals.CharArrayBuilder;
import io.ktor.http.cio.internals.CharsKt;
import io.ktor.http.cio.internals.MutableRange;
import io.ktor.http.cio.internals.TokenizerKt;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.LineEndingMode;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.FilenameUtils;
import org.bouncycastle.asn1.eac.EACTags;

/* JADX INFO: compiled from: HttpParser.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0011\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0086@¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001a\u00020\u0000H\u0086@¢\u0006\u0004\b\u0006\u0010\u0004\u001a\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u0000H\u0086@¢\u0006\u0004\b\b\u0010\u0004\u001a,\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0080@¢\u0006\u0004\b\b\u0010\r\u001a\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001f\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\u0016\u001a\u001f\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001f\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001a\u0010\u0019\u001a\u001f\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001bH\u0002¢\u0006\u0004\b \u0010!\u001a\u001f\u0010\"\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\"\u0010#\u001a/\u0010)\u001a\u00020(2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b)\u0010*\u001a\u001f\u0010+\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b+\u0010,\u001a\u001f\u0010-\u001a\u00020(2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b-\u0010.\u001a\u001f\u0010/\u001a\u00020(2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b/\u00100\u001a\u0017\u00101\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b1\u00102\u001a\u0017\u00104\u001a\u00020(2\u0006\u00103\u001a\u00020\u000eH\u0002¢\u0006\u0004\b4\u00105\"\u0014\u00106\u001a\u00020\u001b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u00107\"\u0014\u00108\u001a\u00020\u001b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b8\u00107\"\u0014\u00109\u001a\u00020\u001b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b9\u00107\"\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020&0:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<\" \u0010>\u001a\u00020=8\u0000X\u0080\u0004¢\u0006\u0012\n\u0004\b>\u00107\u0012\u0004\bA\u0010B\u001a\u0004\b?\u0010@\"\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020D0C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010F¨\u0006G"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "input", "Lio/ktor/http/cio/Request;", "parseRequest", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/http/cio/Response;", "parseResponse", "Lio/ktor/http/cio/HttpHeadersMap;", "parseHeaders", "Lio/ktor/http/cio/internals/CharArrayBuilder;", "builder", "Lio/ktor/http/cio/internals/MutableRange;", "range", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/http/cio/internals/CharArrayBuilder;Lio/ktor/http/cio/internals/MutableRange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", LogAttributes.HOST, "", "validateHostHeader", "(Ljava/lang/CharSequence;)V", "text", "Lio/ktor/http/HttpMethod;", "parseHttpMethod", "(Ljava/lang/CharSequence;Lio/ktor/http/cio/internals/MutableRange;)Lio/ktor/http/HttpMethod;", "parseHttpMethodFull", "parseUri", "(Ljava/lang/CharSequence;Lio/ktor/http/cio/internals/MutableRange;)Ljava/lang/CharSequence;", "parseVersion", "", "parseStatusCode", "(Ljava/lang/CharSequence;Lio/ktor/http/cio/internals/MutableRange;)I", "code", "", "statusOutOfRange", "(I)Z", "parseHeaderName", "(Lio/ktor/http/cio/internals/CharArrayBuilder;Lio/ktor/http/cio/internals/MutableRange;)I", FirebaseAnalytics.Param.INDEX, ViewProps.START, "", "ch", "", "parseHeaderNameFailed", "(Lio/ktor/http/cio/internals/CharArrayBuilder;IIC)Ljava/lang/Void;", "parseHeaderValue", "(Lio/ktor/http/cio/internals/CharArrayBuilder;Lio/ktor/http/cio/internals/MutableRange;)V", "noColonFound", "(Ljava/lang/CharSequence;Lio/ktor/http/cio/internals/MutableRange;)Ljava/lang/Void;", "characterIsNotAllowed", "(Ljava/lang/CharSequence;C)Ljava/lang/Void;", "isDelimiter", "(C)Z", "result", "unsupportedHttpVersion", "(Ljava/lang/CharSequence;)Ljava/lang/Void;", "HTTP_LINE_LIMIT", "I", "HTTP_STATUS_CODE_MIN_RANGE", "HTTP_STATUS_CODE_MAX_RANGE", "", "hostForbiddenSymbols", "Ljava/util/Set;", "Lio/ktor/utils/io/LineEndingMode;", "httpLineEndings", "getHttpLineEndings", "()I", "getHttpLineEndings$annotations", "()V", "Lio/ktor/http/cio/internals/AsciiCharTree;", "", "versions", "Lio/ktor/http/cio/internals/AsciiCharTree;", "ktor-http-cio"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class HttpParserKt {
    private static final int HTTP_LINE_LIMIT = 8192;
    private static final int HTTP_STATUS_CODE_MAX_RANGE = 999;
    private static final int HTTP_STATUS_CODE_MIN_RANGE = 100;
    private static final Set<Character> hostForbiddenSymbols = SetsKt.setOf((Object[]) new Character[]{'/', Character.valueOf(ApmNetworkInstrumentation.URL_QUERY_PARAMS_BLOCK_SEPARATOR), '#', '@'});
    private static final int httpLineEndings = LineEndingMode.m12652plus1TerO4(LineEndingMode.INSTANCE.m12657getCRLFf0jXZW8(), LineEndingMode.INSTANCE.m12658getLFf0jXZW8());
    private static final AsciiCharTree<String> versions = AsciiCharTree.INSTANCE.build(CollectionsKt.listOf((Object[]) new String[]{"HTTP/1.0", "HTTP/1.1"}));

    /* JADX INFO: renamed from: io.ktor.http.cio.HttpParserKt$parseHeaders$1, reason: invalid class name */
    /* JADX INFO: compiled from: HttpParser.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.HttpParserKt", f = "HttpParser.kt", i = {0, 0}, l = {106}, m = "parseHeaders", n = {"input", "builder"}, s = {"L$0", "L$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpParserKt.parseHeaders(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.HttpParserKt$parseHeaders$2, reason: invalid class name */
    /* JADX INFO: compiled from: HttpParser.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.HttpParserKt", f = "HttpParser.kt", i = {0, 0, 0, 0}, l = {122}, m = "parseHeaders", n = {"input", "builder", "range", "headers"}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class AnonymousClass2 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpParserKt.parseHeaders(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.HttpParserKt$parseRequest$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HttpParser.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.HttpParserKt", f = "HttpParser.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {45, 60}, m = "parseRequest", n = {"input", "builder", "range", "input", "builder", "range", FirebaseAnalytics.Param.METHOD, "uri", "version"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 1)
    static final class C10331 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C10331(Continuation<? super C10331> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpParserKt.parseRequest(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.HttpParserKt$parseResponse$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HttpParser.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.HttpParserKt", f = "HttpParser.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {EACTags.ANSWER_TO_RESET, RotationOptions.ROTATE_90}, m = "parseResponse", n = {"input", "builder", "range", "input", "builder", "range", "version", "statusText", "statusCode"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
    static final class C10341 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C10341(Continuation<? super C10341> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpParserKt.parseResponse(null, this);
        }
    }

    public static /* synthetic */ void getHttpLineEndings$annotations() {
    }

    static final boolean parseHttpMethod$lambda$0(char c, int i) {
        return c == ' ';
    }

    static final boolean parseVersion$lambda$1(char c, int i) {
        return c == ' ';
    }

    private static final boolean statusOutOfRange(int i) {
        return i < 100 || i > 999;
    }

    public static final int getHttpLineEndings() {
        return httpLineEndings;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0080 A[Catch: all -> 0x0151, PHI: r1 r3 r8 r13
      0x0080: PHI (r1v4 io.ktor.http.cio.internals.CharArrayBuilder) = (r1v3 io.ktor.http.cio.internals.CharArrayBuilder), (r1v5 io.ktor.http.cio.internals.CharArrayBuilder) binds: [B:24:0x006e, B:32:0x00b3] A[DONT_GENERATE, DONT_INLINE]
      0x0080: PHI (r3v2 io.ktor.http.cio.internals.MutableRange) = (r3v1 io.ktor.http.cio.internals.MutableRange), (r3v3 io.ktor.http.cio.internals.MutableRange) binds: [B:24:0x006e, B:32:0x00b3] A[DONT_GENERATE, DONT_INLINE]
      0x0080: PHI (r8v1 io.ktor.utils.io.ByteReadChannel) = (r8v0 io.ktor.utils.io.ByteReadChannel), (r8v2 io.ktor.utils.io.ByteReadChannel) binds: [B:24:0x006e, B:32:0x00b3] A[DONT_GENERATE, DONT_INLINE]
      0x0080: PHI (r13v1 io.ktor.http.cio.HttpParserKt$parseRequest$1) = (r13v0 io.ktor.http.cio.HttpParserKt$parseRequest$1), (r13v2 io.ktor.http.cio.HttpParserKt$parseRequest$1) binds: [B:24:0x006e, B:32:0x00b3] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #0 {all -> 0x0151, blocks: (B:28:0x0097, B:31:0x00a4, B:25:0x0080, B:33:0x00b5, B:35:0x00da, B:37:0x00e0, B:39:0x00e6, B:50:0x0117, B:51:0x011e, B:52:0x011f, B:53:0x0126, B:54:0x0127, B:55:0x0150), top: B:60:0x0097 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0096  */
    /* JADX WARN: Code duplicated, block: B:30:0x00a3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x00a4 A[Catch: all -> 0x0151, TryCatch #0 {all -> 0x0151, blocks: (B:28:0x0097, B:31:0x00a4, B:25:0x0080, B:33:0x00b5, B:35:0x00da, B:37:0x00e0, B:39:0x00e6, B:50:0x0117, B:51:0x011e, B:52:0x011f, B:53:0x0126, B:54:0x0127, B:55:0x0150), top: B:60:0x0097 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x00b5 A[Catch: all -> 0x0151, TryCatch #0 {all -> 0x0151, blocks: (B:28:0x0097, B:31:0x00a4, B:25:0x0080, B:33:0x00b5, B:35:0x00da, B:37:0x00e0, B:39:0x00e6, B:50:0x0117, B:51:0x011e, B:52:0x011f, B:53:0x0126, B:54:0x0127, B:55:0x0150), top: B:60:0x0097 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00da A[Catch: all -> 0x0151, TryCatch #0 {all -> 0x0151, blocks: (B:28:0x0097, B:31:0x00a4, B:25:0x0080, B:33:0x00b5, B:35:0x00da, B:37:0x00e0, B:39:0x00e6, B:50:0x0117, B:51:0x011e, B:52:0x011f, B:53:0x0126, B:54:0x0127, B:55:0x0150), top: B:60:0x0097 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00e0 A[Catch: all -> 0x0151, TryCatch #0 {all -> 0x0151, blocks: (B:28:0x0097, B:31:0x00a4, B:25:0x0080, B:33:0x00b5, B:35:0x00da, B:37:0x00e0, B:39:0x00e6, B:50:0x0117, B:51:0x011e, B:52:0x011f, B:53:0x0126, B:54:0x0127, B:55:0x0150), top: B:60:0x0097 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00e6 A[Catch: all -> 0x0151, TRY_LEAVE, TryCatch #0 {all -> 0x0151, blocks: (B:28:0x0097, B:31:0x00a4, B:25:0x0080, B:33:0x00b5, B:35:0x00da, B:37:0x00e0, B:39:0x00e6, B:50:0x0117, B:51:0x011e, B:52:0x011f, B:53:0x0126, B:54:0x0127, B:55:0x0150), top: B:60:0x0097 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0103  */
    /* JADX WARN: Code duplicated, block: B:45:0x010d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x010e A[Catch: all -> 0x0114, TRY_LEAVE, TryCatch #1 {all -> 0x0114, blocks: (B:43:0x0108, B:46:0x010e), top: B:61:0x0108 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0117 A[Catch: all -> 0x0151, TRY_ENTER, TryCatch #0 {all -> 0x0151, blocks: (B:28:0x0097, B:31:0x00a4, B:25:0x0080, B:33:0x00b5, B:35:0x00da, B:37:0x00e0, B:39:0x00e6, B:50:0x0117, B:51:0x011e, B:52:0x011f, B:53:0x0126, B:54:0x0127, B:55:0x0150), top: B:60:0x0097 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x011f A[Catch: all -> 0x0151, TryCatch #0 {all -> 0x0151, blocks: (B:28:0x0097, B:31:0x00a4, B:25:0x0080, B:33:0x00b5, B:35:0x00da, B:37:0x00e0, B:39:0x00e6, B:50:0x0117, B:51:0x011e, B:52:0x011f, B:53:0x0126, B:54:0x0127, B:55:0x0150), top: B:60:0x0097 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0127 A[Catch: all -> 0x0151, TryCatch #0 {all -> 0x0151, blocks: (B:28:0x0097, B:31:0x00a4, B:25:0x0080, B:33:0x00b5, B:35:0x00da, B:37:0x00e0, B:39:0x00e6, B:50:0x0117, B:51:0x011e, B:52:0x011f, B:53:0x0126, B:54:0x0127, B:55:0x0150), top: B:60:0x0097 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0097 A[EXC_TOP_SPLITTER, PHI: r0 r1 r3 r8 r13
      0x0097: PHI (r0v4 java.lang.Object) = (r0v3 java.lang.Object), (r0v1 java.lang.Object) binds: [B:26:0x0094, B:21:0x0067] A[DONT_GENERATE, DONT_INLINE]
      0x0097: PHI (r1v5 io.ktor.http.cio.internals.CharArrayBuilder) = (r1v4 io.ktor.http.cio.internals.CharArrayBuilder), (r1v6 io.ktor.http.cio.internals.CharArrayBuilder) binds: [B:26:0x0094, B:21:0x0067] A[DONT_GENERATE, DONT_INLINE]
      0x0097: PHI (r3v3 io.ktor.http.cio.internals.MutableRange) = (r3v2 io.ktor.http.cio.internals.MutableRange), (r3v9 io.ktor.http.cio.internals.MutableRange) binds: [B:26:0x0094, B:21:0x0067] A[DONT_GENERATE, DONT_INLINE]
      0x0097: PHI (r8v2 io.ktor.utils.io.ByteReadChannel) = (r8v1 io.ktor.utils.io.ByteReadChannel), (r8v6 io.ktor.utils.io.ByteReadChannel) binds: [B:26:0x0094, B:21:0x0067] A[DONT_GENERATE, DONT_INLINE]
      0x0097: PHI (r13v2 io.ktor.http.cio.HttpParserKt$parseRequest$1) = (r13v1 io.ktor.http.cio.HttpParserKt$parseRequest$1), (r13v3 io.ktor.http.cio.HttpParserKt$parseRequest$1) binds: [B:26:0x0094, B:21:0x0067] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0094 -> B:60:0x0097). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object parseRequest(io.ktor.utils.io.ByteReadChannel r16, kotlin.coroutines.Continuation<? super io.ktor.http.cio.Request> r17) {
        /*
            Method dump skipped, instruction units count: 343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.HttpParserKt.parseRequest(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00f3 A[Catch: all -> 0x00ff, TryCatch #2 {all -> 0x00ff, blocks: (B:35:0x00ef, B:37:0x00f3, B:38:0x00f8), top: B:49:0x00ef }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public static final Object parseResponse(ByteReadChannel byteReadChannel, Continuation<? super Response> continuation) throws Throwable {
        C10341 c10341;
        Throwable th;
        ByteReadChannel byteReadChannel2;
        CharArrayBuilder charArrayBuilder;
        MutableRange mutableRange;
        CharSequence charSequence;
        int i;
        CharSequence charSequence2;
        CharArrayBuilder charArrayBuilder2;
        HttpHeadersMap httpHeadersMap;
        if (continuation instanceof C10341) {
            c10341 = (C10341) continuation;
            if ((c10341.label & Integer.MIN_VALUE) != 0) {
                c10341.label -= Integer.MIN_VALUE;
            } else {
                c10341 = new C10341(continuation);
            }
        } else {
            c10341 = new C10341(continuation);
        }
        C10341 c10342 = c10341;
        Object obj = c10342.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c10342.label;
        CharArrayBuilder charArrayBuilder3 = 1;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                CharArrayBuilder charArrayBuilder4 = new CharArrayBuilder(null, 1, null);
                MutableRange mutableRange2 = new MutableRange(0, 0);
                try {
                    c10342.L$0 = byteReadChannel;
                    c10342.L$1 = charArrayBuilder4;
                    c10342.L$2 = mutableRange2;
                    c10342.label = 1;
                    byteReadChannel2 = byteReadChannel;
                    Object lineStrictTo$default = ByteReadChannelOperationsKt.readLineStrictTo$default(byteReadChannel2, charArrayBuilder4, 8192L, null, c10342, 4, null);
                    if (lineStrictTo$default != coroutine_suspended) {
                        charArrayBuilder = charArrayBuilder4;
                        obj = lineStrictTo$default;
                        mutableRange = mutableRange2;
                    }
                    return coroutine_suspended;
                } catch (Throwable th2) {
                    th = th2;
                    charArrayBuilder3 = charArrayBuilder4;
                    charArrayBuilder3.release();
                    throw th;
                }
            }
            if (i2 == 1) {
                mutableRange = (MutableRange) c10342.L$2;
                charArrayBuilder = (CharArrayBuilder) c10342.L$1;
                byteReadChannel2 = (ByteReadChannel) c10342.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i3 = c10342.I$0;
                CharSequence charSequence3 = (CharSequence) c10342.L$4;
                CharSequence charSequence4 = (CharSequence) c10342.L$3;
                charArrayBuilder = (CharArrayBuilder) c10342.L$1;
                ResultKt.throwOnFailure(obj);
                i = i3;
                charSequence2 = charSequence3;
                charSequence = charSequence4;
            }
            charArrayBuilder2 = charArrayBuilder;
            try {
                httpHeadersMap = (HttpHeadersMap) obj;
                if (httpHeadersMap == null) {
                    httpHeadersMap = new HttpHeadersMap(charArrayBuilder2);
                }
                return new Response(charSequence, i, charSequence2, httpHeadersMap, charArrayBuilder2);
            } catch (Throwable th3) {
                th = th3;
                charArrayBuilder3 = charArrayBuilder2;
                charArrayBuilder3.release();
                throw th;
            }
            if (((Number) obj).longValue() == -1) {
                return null;
            }
            mutableRange.setEnd(charArrayBuilder.length());
            CharSequence version = parseVersion(charArrayBuilder, mutableRange);
            int statusCode = parseStatusCode(charArrayBuilder, mutableRange);
            TokenizerKt.skipSpaces(charArrayBuilder, mutableRange);
            CharSequence charSequenceSubSequence = charArrayBuilder.subSequence(mutableRange.getStart(), mutableRange.getEnd());
            mutableRange.setStart(mutableRange.getEnd());
            c10342.L$0 = SpillingKt.nullOutSpilledVariable(byteReadChannel2);
            c10342.L$1 = charArrayBuilder;
            c10342.L$2 = SpillingKt.nullOutSpilledVariable(mutableRange);
            c10342.L$3 = version;
            c10342.L$4 = charSequenceSubSequence;
            c10342.I$0 = statusCode;
            c10342.label = 2;
            Object headers = parseHeaders(byteReadChannel2, charArrayBuilder, mutableRange, c10342);
            if (headers != coroutine_suspended) {
                charSequence = version;
                i = statusCode;
                charSequence2 = charSequenceSubSequence;
                obj = headers;
                charArrayBuilder2 = charArrayBuilder;
                httpHeadersMap = (HttpHeadersMap) obj;
                if (httpHeadersMap == null) {
                    httpHeadersMap = new HttpHeadersMap(charArrayBuilder2);
                }
                return new Response(charSequence, i, charSequence2, httpHeadersMap, charArrayBuilder2);
            }
            return coroutine_suspended;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object parseHeaders(ByteReadChannel byteReadChannel, Continuation<? super HttpHeadersMap> continuation) {
        AnonymousClass1 anonymousClass1;
        CharArrayBuilder charArrayBuilder;
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
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object headers$default = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(headers$default);
            CharArrayBuilder charArrayBuilder2 = new CharArrayBuilder(null, 1, null);
            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(byteReadChannel);
            anonymousClass2.L$1 = charArrayBuilder2;
            anonymousClass2.label = 1;
            headers$default = parseHeaders$default(byteReadChannel, charArrayBuilder2, null, anonymousClass2, 4, null);
            if (headers$default == coroutine_suspended) {
                return coroutine_suspended;
            }
            charArrayBuilder = charArrayBuilder2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            charArrayBuilder = (CharArrayBuilder) anonymousClass2.L$1;
            ResultKt.throwOnFailure(headers$default);
        }
        HttpHeadersMap httpHeadersMap = (HttpHeadersMap) headers$default;
        return httpHeadersMap == null ? new HttpHeadersMap(charArrayBuilder) : httpHeadersMap;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x006e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x007b A[Catch: all -> 0x003f, TryCatch #0 {all -> 0x003f, blocks: (B:12:0x0036, B:22:0x006f, B:24:0x007b, B:26:0x0080, B:30:0x0096, B:19:0x0056, B:31:0x00b4, B:32:0x00bf, B:33:0x00c0, B:35:0x00c8), top: B:39:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x0080 A[Catch: all -> 0x003f, TryCatch #0 {all -> 0x003f, blocks: (B:12:0x0036, B:22:0x006f, B:24:0x007b, B:26:0x0080, B:30:0x0096, B:19:0x0056, B:31:0x00b4, B:32:0x00bf, B:33:0x00c0, B:35:0x00c8), top: B:39:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0092  */
    /* JADX WARN: Code duplicated, block: B:30:0x0096 A[Catch: all -> 0x003f, TryCatch #0 {all -> 0x003f, blocks: (B:12:0x0036, B:22:0x006f, B:24:0x007b, B:26:0x0080, B:30:0x0096, B:19:0x0056, B:31:0x00b4, B:32:0x00bf, B:33:0x00c0, B:35:0x00c8), top: B:39:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x006c -> B:22:0x006f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object parseHeaders(io.ktor.utils.io.ByteReadChannel r12, io.ktor.http.cio.internals.CharArrayBuilder r13, io.ktor.http.cio.internals.MutableRange r14, kotlin.coroutines.Continuation<? super io.ktor.http.cio.HttpHeadersMap> r15) {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.HttpParserKt.parseHeaders(io.ktor.utils.io.ByteReadChannel, io.ktor.http.cio.internals.CharArrayBuilder, io.ktor.http.cio.internals.MutableRange, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object parseHeaders$default(ByteReadChannel byteReadChannel, CharArrayBuilder charArrayBuilder, MutableRange mutableRange, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            mutableRange = new MutableRange(0, 0);
        }
        return parseHeaders(byteReadChannel, charArrayBuilder, mutableRange, continuation);
    }

    private static final void validateHostHeader(CharSequence charSequence) {
        if (StringsKt.endsWith$default(charSequence, (CharSequence) ServerSentEventKt.COLON, false, 2, (Object) null)) {
            throw new ParserException("Host header with ':' should contains port: " + ((Object) charSequence));
        }
        for (int i = 0; i < charSequence.length(); i++) {
            char cCharAt = charSequence.charAt(i);
            Set<Character> set = hostForbiddenSymbols;
            if (set.contains(Character.valueOf(cCharAt))) {
                throw new ParserException("Host cannot contain any of the following symbols: " + set);
            }
        }
    }

    private static final HttpMethod parseHttpMethod(CharSequence charSequence, MutableRange mutableRange) {
        TokenizerKt.skipSpaces(charSequence, mutableRange);
        HttpMethod httpMethod = (HttpMethod) CollectionsKt.singleOrNull(AsciiCharTree.search$default(CharsKt.getDefaultHttpMethods(), charSequence, mutableRange.getStart(), mutableRange.getEnd(), false, new Function2() { // from class: io.ktor.http.cio.HttpParserKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(HttpParserKt.parseHttpMethod$lambda$0(((Character) obj).charValue(), ((Integer) obj2).intValue()));
            }
        }, 8, null));
        if (httpMethod != null) {
            mutableRange.setStart(mutableRange.getStart() + httpMethod.getValue().length());
            return httpMethod;
        }
        return parseHttpMethodFull(charSequence, mutableRange);
    }

    private static final HttpMethod parseHttpMethodFull(CharSequence charSequence, MutableRange mutableRange) {
        return new HttpMethod(TokenizerKt.nextToken(charSequence, mutableRange).toString());
    }

    private static final CharSequence parseUri(CharSequence charSequence, MutableRange mutableRange) {
        TokenizerKt.skipSpaces(charSequence, mutableRange);
        int start = mutableRange.getStart();
        int iFindSpaceOrEnd = TokenizerKt.findSpaceOrEnd(charSequence, mutableRange);
        int i = iFindSpaceOrEnd - start;
        if (i <= 0) {
            return "";
        }
        if (i == 1 && charSequence.charAt(start) == '/') {
            mutableRange.setStart(iFindSpaceOrEnd);
            return DomExceptionUtils.SEPARATOR;
        }
        CharSequence charSequenceSubSequence = charSequence.subSequence(start, iFindSpaceOrEnd);
        mutableRange.setStart(iFindSpaceOrEnd);
        return charSequenceSubSequence;
    }

    private static final CharSequence parseVersion(CharSequence charSequence, MutableRange mutableRange) {
        TokenizerKt.skipSpaces(charSequence, mutableRange);
        if (mutableRange.getStart() >= mutableRange.getEnd()) {
            throw new IllegalStateException(("Failed to parse version: " + ((Object) charSequence)).toString());
        }
        String str = (String) CollectionsKt.singleOrNull(AsciiCharTree.search$default(versions, charSequence, mutableRange.getStart(), mutableRange.getEnd(), false, new Function2() { // from class: io.ktor.http.cio.HttpParserKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(HttpParserKt.parseVersion$lambda$1(((Character) obj).charValue(), ((Integer) obj2).intValue()));
            }
        }, 8, null));
        if (str != null) {
            mutableRange.setStart(mutableRange.getStart() + str.length());
            return str;
        }
        unsupportedHttpVersion(TokenizerKt.nextToken(charSequence, mutableRange));
        throw new KotlinNothingValueException();
    }

    private static final int parseStatusCode(CharSequence charSequence, MutableRange mutableRange) {
        TokenizerKt.skipSpaces(charSequence, mutableRange);
        int end = mutableRange.getEnd();
        int end2 = mutableRange.getEnd();
        int i = 0;
        for (int start = mutableRange.getStart(); start < end2; start++) {
            char cCharAt = charSequence.charAt(start);
            if (cCharAt == ' ') {
                if (!statusOutOfRange(i)) {
                    end = start;
                    break;
                }
                throw new ParserException("Status-code must be 3-digit. Status received: " + i + FilenameUtils.EXTENSION_SEPARATOR);
            }
            if ('0' > cCharAt || cCharAt >= ':') {
                throw new NumberFormatException("Illegal digit " + cCharAt + " in status code " + charSequence.subSequence(mutableRange.getStart(), TokenizerKt.findSpaceOrEnd(charSequence, mutableRange)).toString());
            }
            i = (i * 10) + (cCharAt - '0');
        }
        mutableRange.setStart(end);
        return i;
    }

    public static final int parseHeaderName(CharArrayBuilder text, MutableRange range) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(range, "range");
        int end = range.getEnd();
        for (int start = range.getStart(); start < end; start++) {
            char cCharAt = text.charAt(start);
            if (cCharAt == ':' && start != range.getStart()) {
                range.setStart(start + 1);
                return start;
            }
            if (isDelimiter(cCharAt)) {
                parseHeaderNameFailed(text, start, range.getStart(), cCharAt);
                throw new KotlinNothingValueException();
            }
        }
        noColonFound(text, range);
        throw new KotlinNothingValueException();
    }

    private static final Void parseHeaderNameFailed(CharArrayBuilder charArrayBuilder, int i, int i2, char c) {
        if (c == ':') {
            throw new ParserException("Empty header names are not allowed as per RFC7230.");
        }
        if (i == i2) {
            throw new ParserException("Multiline headers via line folding is not supported since it is deprecated as per RFC7230.");
        }
        characterIsNotAllowed(charArrayBuilder, c);
        throw new KotlinNothingValueException();
    }

    public static final void parseHeaderValue(CharArrayBuilder text, MutableRange range) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(range, "range");
        int start = range.getStart();
        int end = range.getEnd();
        int iSkipSpacesAndHorizontalTabs = TokenizerKt.skipSpacesAndHorizontalTabs(text, start, end);
        if (iSkipSpacesAndHorizontalTabs >= end) {
            range.setStart(end);
            return;
        }
        int i = iSkipSpacesAndHorizontalTabs;
        int i2 = i;
        while (i < end) {
            char cCharAt = text.charAt(i);
            if (cCharAt != '\t') {
                if (cCharAt == '\n' || cCharAt == '\r') {
                    characterIsNotAllowed(text, cCharAt);
                    throw new KotlinNothingValueException();
                }
                if (cCharAt != ' ') {
                    i2 = i;
                }
            }
            i++;
        }
        range.setStart(iSkipSpacesAndHorizontalTabs);
        range.setEnd(i2 + 1);
    }

    private static final Void noColonFound(CharSequence charSequence, MutableRange mutableRange) {
        throw new ParserException("No colon in HTTP header in " + charSequence.subSequence(mutableRange.getStart(), mutableRange.getEnd()).toString() + " in builder: \n" + ((Object) charSequence));
    }

    private static final Void characterIsNotAllowed(CharSequence charSequence, char c) {
        throw new ParserException("Character with code " + (c & 255) + " is not allowed in header names, \n" + ((Object) charSequence));
    }

    private static final boolean isDelimiter(char c) {
        return Intrinsics.compare((int) c, 32) <= 0 || StringsKt.contains$default((CharSequence) "\"(),/:;<=>?@[\\]{}", c, false, 2, (Object) null);
    }

    private static final Void unsupportedHttpVersion(CharSequence charSequence) {
        throw new ParserException("Unsupported HTTP version: " + ((Object) charSequence));
    }
}

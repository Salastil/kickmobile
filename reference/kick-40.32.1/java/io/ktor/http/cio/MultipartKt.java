package io.ktor.http.cio;

import androidx.media3.muxer.WebmConstants;
import androidx.mediarouter.media.GlobalMediaRouter;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import io.ktor.http.ContentDisposition;
import io.ktor.http.ContentType;
import io.ktor.http.cio.internals.CharArrayBuilder;
import io.ktor.http.cio.internals.CharsKt;
import io.ktor.http.cio.internals.UnsupportedMediaTypeExceptionCIO;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.core.StringsKt;
import java.io.EOFException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.io.bytestring.ByteString;
import kotlinx.io.bytestring.ByteStringKt;
import org.bouncycastle.math.Primes;

/* JADX INFO: compiled from: Multipart.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0004\u001a2\u0010\b\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\b\u0010\t\u001a\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@¢\u0006\u0004\b\u000b\u0010\f\u001a8\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001c\u0010\u0012\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0000H\u0082@¢\u0006\u0004\b\u0012\u0010\u0013\u001a1\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016*\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0019\u001a;\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016*\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u001d\u001a;\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016*\u00020\u00142\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u001f\u001a\u0017\u0010!\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b!\u0010\"\u001a\u0017\u0010$\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\u001aH\u0000¢\u0006\u0004\b$\u0010%\u001a\u001f\u0010(\u001a\u00020'2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b(\u0010)\"\u0014\u0010*\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+\"\u0014\u0010-\u001a\u00020,8\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010.\"\u0014\u0010/\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010+¨\u00060"}, d2 = {"Lkotlinx/io/bytestring/ByteString;", "boundary", "Lio/ktor/utils/io/ByteReadChannel;", "input", "Lio/ktor/utils/io/ByteWriteChannel;", "output", "", "limit", "parsePreambleImpl", "(Lkotlinx/io/bytestring/ByteString;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/http/cio/HttpHeadersMap;", "parsePartHeadersImpl", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "boundaryPrefixed", "headers", "parsePartBodyImpl", "(Lkotlinx/io/bytestring/ByteString;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;Lio/ktor/http/cio/HttpHeadersMap;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prefix", "skipIfFoundReadCount", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlinx/io/bytestring/ByteString;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineScope;", "maxPartSize", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lio/ktor/http/cio/MultipartEvent;", "parseMultipart", "(Lkotlinx/coroutines/CoroutineScope;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/http/cio/HttpHeadersMap;J)Lkotlinx/coroutines/channels/ReceiveChannel;", "", "contentType", "contentLength", "(Lkotlinx/coroutines/CoroutineScope;Lio/ktor/utils/io/ByteReadChannel;Ljava/lang/CharSequence;Ljava/lang/Long;J)Lkotlinx/coroutines/channels/ReceiveChannel;", "totalLength", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/io/bytestring/ByteString;Lio/ktor/utils/io/ByteReadChannel;Ljava/lang/Long;J)Lkotlinx/coroutines/channels/ReceiveChannel;", "", "findBoundary", "(Ljava/lang/CharSequence;)I", "", "parseBoundaryInternal", "(Ljava/lang/CharSequence;)[B", "actual", "", "throwLimitExceeded", "(JJ)Ljava/lang/Void;", "CrLf", "Lkotlinx/io/bytestring/ByteString;", "", "PrefixChar", "B", "PrefixString", "ktor-http-cio"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class MultipartKt {
    private static final ByteString CrLf = new ByteString(StringsKt.toByteArray$default("\r\n", null, 1, null), 0, 0, 6, null);
    private static final byte PrefixChar = 45;
    private static final ByteString PrefixString = ByteStringKt.ByteString(PrefixChar, PrefixChar);

    /* JADX INFO: renamed from: io.ktor.http.cio.MultipartKt$parsePartBodyImpl$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Multipart.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.MultipartKt", f = "Multipart.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3}, l = {132, 133, 133, WebmConstants.MkvEbmlElement.FLAG_DEFAULT}, m = "parsePartBodyImpl", n = {"boundaryPrefixed", "input", "output", "headers", "contentLength", "limit", "boundaryPrefixed", "input", "output", "headers", "contentLength", "limit", "boundaryPrefixed", "input", "output", "headers", "contentLength", "limit", "boundaryPrefixed", "input", "output", "headers", "limit", "byteCount"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0", "J$1"}, v = 1)
    static final class C10351 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C10351(Continuation<? super C10351> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MultipartKt.parsePartBodyImpl(null, null, null, null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.MultipartKt$parsePartHeadersImpl$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Multipart.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.MultipartKt", f = "Multipart.kt", i = {0, 0}, l = {113}, m = "parsePartHeadersImpl", n = {"input", "builder"}, s = {"L$0", "L$1"}, v = 1)
    static final class C10361 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10361(Continuation<? super C10361> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MultipartKt.parsePartHeadersImpl(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.MultipartKt$skipIfFoundReadCount$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Multipart.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.MultipartKt", f = "Multipart.kt", i = {0, 0}, l = {143}, m = "skipIfFoundReadCount", n = {"$this$skipIfFoundReadCount", "prefix"}, s = {"L$0", "L$1"}, v = 1)
    static final class C10371 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10371(Continuation<? super C10371> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MultipartKt.skipIfFoundReadCount(null, null, this);
        }
    }

    static /* synthetic */ Object parsePreambleImpl$default(ByteString byteString, ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, Continuation continuation, int i, Object obj) {
        if ((i & 8) != 0) {
            j = Long.MAX_VALUE;
        }
        return parsePreambleImpl(byteString, byteReadChannel, byteWriteChannel, j, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object parsePreambleImpl(ByteString byteString, ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, Continuation<? super Long> continuation) {
        return ByteReadChannelOperationsKt.readUntil(byteReadChannel, byteString, byteWriteChannel, j, true, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object parsePartHeadersImpl(ByteReadChannel byteReadChannel, Continuation<? super HttpHeadersMap> continuation) throws Throwable {
        C10361 c10361;
        Throwable th;
        CharArrayBuilder charArrayBuilder;
        if (continuation instanceof C10361) {
            c10361 = (C10361) continuation;
            if ((c10361.label & Integer.MIN_VALUE) != 0) {
                c10361.label -= Integer.MIN_VALUE;
            } else {
                c10361 = new C10361(continuation);
            }
        } else {
            c10361 = new C10361(continuation);
        }
        C10361 c10362 = c10361;
        Object headers$default = c10362.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10362.label;
        if (i == 0) {
            ResultKt.throwOnFailure(headers$default);
            CharArrayBuilder charArrayBuilder2 = new CharArrayBuilder(null, 1, null);
            try {
                c10362.L$0 = SpillingKt.nullOutSpilledVariable(byteReadChannel);
                c10362.L$1 = charArrayBuilder2;
                c10362.label = 1;
                headers$default = HttpParserKt.parseHeaders$default(byteReadChannel, charArrayBuilder2, null, c10362, 4, null);
                if (headers$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                charArrayBuilder = charArrayBuilder2;
            } catch (Throwable th2) {
                th = th2;
                charArrayBuilder = charArrayBuilder2;
                charArrayBuilder.release();
                throw th;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            charArrayBuilder = (CharArrayBuilder) c10362.L$1;
            try {
                ResultKt.throwOnFailure(headers$default);
            } catch (Throwable th3) {
                th = th3;
                charArrayBuilder.release();
                throw th;
            }
        }
        HttpHeadersMap httpHeadersMap = (HttpHeadersMap) headers$default;
        if (httpHeadersMap != null) {
            return httpHeadersMap;
        }
        throw new EOFException("Failed to parse multipart headers: unexpected end of stream");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:41:0x0174  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x01a3, code lost:
    
        if (r10.flush(r6) == r7) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object parsePartBodyImpl(kotlinx.io.bytestring.ByteString r19, io.ktor.utils.io.ByteReadChannel r20, io.ktor.utils.io.ByteWriteChannel r21, io.ktor.http.cio.HttpHeadersMap r22, long r23, kotlin.coroutines.Continuation<? super java.lang.Long> r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 440
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.MultipartKt.parsePartBodyImpl(kotlinx.io.bytestring.ByteString, io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel, io.ktor.http.cio.HttpHeadersMap, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object skipIfFoundReadCount(ByteReadChannel byteReadChannel, ByteString byteString, Continuation<? super Long> continuation) {
        C10371 c10371;
        if (continuation instanceof C10371) {
            c10371 = (C10371) continuation;
            if ((c10371.label & Integer.MIN_VALUE) != 0) {
                c10371.label -= Integer.MIN_VALUE;
            } else {
                c10371 = new C10371(continuation);
            }
        } else {
            c10371 = new C10371(continuation);
        }
        Object objSkipIfFound = c10371.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10371.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objSkipIfFound);
            c10371.L$0 = SpillingKt.nullOutSpilledVariable(byteReadChannel);
            c10371.L$1 = byteString;
            c10371.label = 1;
            objSkipIfFound = ByteReadChannelOperationsKt.skipIfFound(byteReadChannel, byteString, c10371);
            if (objSkipIfFound == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            byteString = (ByteString) c10371.L$1;
            ResultKt.throwOnFailure(objSkipIfFound);
        }
        return Boxing.boxLong(((Boolean) objSkipIfFound).booleanValue() ? byteString.getSize() : 0L);
    }

    public static /* synthetic */ ReceiveChannel parseMultipart$default(CoroutineScope coroutineScope, ByteReadChannel byteReadChannel, HttpHeadersMap httpHeadersMap, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            j = Long.MAX_VALUE;
        }
        return parseMultipart(coroutineScope, byteReadChannel, httpHeadersMap, j);
    }

    public static final ReceiveChannel<MultipartEvent> parseMultipart(CoroutineScope coroutineScope, ByteReadChannel input, HttpHeadersMap headers, long j) throws UnsupportedMediaTypeExceptionCIO {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(headers, "headers");
        CharSequence charSequence = headers.get("Content-Type");
        if (charSequence == null) {
            throw new UnsupportedMediaTypeExceptionCIO("Failed to parse multipart: no Content-Type header");
        }
        CharSequence charSequence2 = headers.get("Content-Length");
        return parseMultipart(coroutineScope, input, charSequence, charSequence2 != null ? Long.valueOf(CharsKt.parseDecLong(charSequence2)) : null, j);
    }

    public static /* synthetic */ ReceiveChannel parseMultipart$default(CoroutineScope coroutineScope, ByteReadChannel byteReadChannel, CharSequence charSequence, Long l, long j, int i, Object obj) {
        if ((i & 8) != 0) {
            j = Long.MAX_VALUE;
        }
        return parseMultipart(coroutineScope, byteReadChannel, charSequence, l, j);
    }

    public static final ReceiveChannel<MultipartEvent> parseMultipart(CoroutineScope coroutineScope, ByteReadChannel input, CharSequence contentType, Long l, long j) throws UnsupportedMediaTypeExceptionCIO {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        if (!ContentType.MultiPart.INSTANCE.contains(contentType)) {
            throw new UnsupportedMediaTypeExceptionCIO("Failed to parse multipart: Content-Type should be multipart/* but it is " + ((Object) contentType));
        }
        return parseMultipart(coroutineScope, new ByteString(parseBoundaryInternal(contentType), 0, 0, 6, null), input, l, j);
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.MultipartKt$parseMultipart$1, reason: invalid class name */
    /* JADX INFO: compiled from: Multipart.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lio/ktor/http/cio/MultipartEvent;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.MultipartKt$parseMultipart$1", f = "Multipart.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13}, l = {JfifUtil.MARKER_RST0, Primes.SMALL_FACTOR_LIMIT, 214, 215, JfifUtil.MARKER_SOS, 225, 229, WebmConstants.MkvEbmlElement.VOID, 248, 249, 256, 256, GlobalMediaRouter.CallbackHandler.MSG_ROUTE_CHANGED, GlobalMediaRouter.CallbackHandler.MSG_ROUTE_PRESENTATION_DISPLAY_CHANGED}, m = "invokeSuspend", n = {"$this$produce", "countedInput", "firstBoundary", "readBeforeParse", "$this$produce", "countedInput", "firstBoundary", "preambleData", "readBeforeParse", "$this$produce", "countedInput", "firstBoundary", "preambleData", "readBeforeParse", "$this$produce", "countedInput", "firstBoundary", "preambleData", "readBeforeParse", "$this$produce", "countedInput", "firstBoundary", "preambleData", "readBeforeParse", "$this$produce", "countedInput", "firstBoundary", "preambleData", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "headers", "part", "readBeforeParse", "$this$produce", "countedInput", "firstBoundary", "preambleData", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "headers", "part", "readBeforeParse", "$this$produce", "countedInput", "firstBoundary", "preambleData", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "headers", "part", "headersMap", "readBeforeParse", "$this$produce", "countedInput", "firstBoundary", "preambleData", "readBeforeParse", "$this$produce", "countedInput", "firstBoundary", "preambleData", "readBeforeParse", "$this$produce", "countedInput", "firstBoundary", "preambleData", "readBeforeParse", "consumedExceptEpilogue", ContentDisposition.Parameters.Size, "$this$produce", "countedInput", "firstBoundary", "preambleData", "readBeforeParse", "consumedExceptEpilogue", ContentDisposition.Parameters.Size, "$this$produce", "countedInput", "firstBoundary", "preambleData", "readBeforeParse", "$this$produce", "countedInput", "firstBoundary", "preambleData", "epilogueContent", "readBeforeParse"}, s = {"L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0", "J$1", "J$2", "L$0", "L$1", "L$2", "L$3", "J$0", "J$1", "J$2", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<ProducerScope<? super MultipartEvent>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ByteString $boundaryPrefixed;
        final /* synthetic */ ByteReadChannel $input;
        final /* synthetic */ long $maxPartSize;
        final /* synthetic */ Long $totalLength;
        long J$0;
        long J$1;
        long J$2;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ByteReadChannel byteReadChannel, ByteString byteString, long j, Long l, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$input = byteReadChannel;
            this.$boundaryPrefixed = byteString;
            this.$maxPartSize = j;
            this.$totalLength = l;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$input, this.$boundaryPrefixed, this.$maxPartSize, this.$totalLength, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super MultipartEvent> producerScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:26:0x011e A[PHI: r3 r4 r6 r7 r8 r9 r10 r12 r16
          0x011e: PHI (r3v28 kotlinx.io.Source) = (r3v17 kotlinx.io.Source), (r3v31 kotlinx.io.Source) binds: [B:25:0x0109, B:55:0x026e] A[DONT_GENERATE, DONT_INLINE]
          0x011e: PHI (r4v14 java.lang.Object) = (r4v4 java.lang.Object), (r4v20 java.lang.Object) binds: [B:25:0x0109, B:55:0x026e] A[DONT_GENERATE, DONT_INLINE]
          0x011e: PHI (r6v22 kotlinx.io.bytestring.ByteString) = (r6v10 kotlinx.io.bytestring.ByteString), (r6v25 kotlinx.io.bytestring.ByteString) binds: [B:25:0x0109, B:55:0x026e] A[DONT_GENERATE, DONT_INLINE]
          0x011e: PHI (r7v8 boolean) = (r7v0 boolean), (r7v9 boolean) binds: [B:25:0x0109, B:55:0x026e] A[DONT_GENERATE, DONT_INLINE]
          0x011e: PHI (r8v3 int) = (r8v0 int), (r8v4 int) binds: [B:25:0x0109, B:55:0x026e] A[DONT_GENERATE, DONT_INLINE]
          0x011e: PHI (r9v5 ??) = (r9v23 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), (r9v28 ??) binds: [B:25:0x0109, B:55:0x026e] A[DONT_GENERATE, DONT_INLINE]
          0x011e: PHI (r10v13 long) = (r10v7 long), (r10v14 long) binds: [B:25:0x0109, B:55:0x026e] A[DONT_GENERATE, DONT_INLINE]
          0x011e: PHI (r12v26 io.ktor.utils.io.CountedByteReadChannel) = (r12v14 io.ktor.utils.io.CountedByteReadChannel), (r12v28 io.ktor.utils.io.CountedByteReadChannel) binds: [B:25:0x0109, B:55:0x026e] A[DONT_GENERATE, DONT_INLINE]
          0x011e: PHI (r16v14 long) = (r16v8 long), (r16v15 long) binds: [B:25:0x0109, B:55:0x026e] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:43:0x01f5 A[PHI: r3 r7 r8 r9 r10 r12 r13 r16
          0x01f5: PHI (r3v33 kotlinx.io.bytestring.ByteString) = 
          (r3v4 kotlinx.io.bytestring.ByteString)
          (r3v9 kotlinx.io.bytestring.ByteString)
          (r3v29 kotlinx.io.bytestring.ByteString)
          (r3v36 kotlinx.io.bytestring.ByteString)
         binds: [B:42:0x01f3, B:41:0x01f0, B:58:0x0278, B:75:0x0328] A[DONT_GENERATE, DONT_INLINE]
          0x01f5: PHI (r7v11 boolean) = (r7v0 boolean), (r7v0 boolean), (r7v8 boolean), (r7v12 boolean) binds: [B:42:0x01f3, B:41:0x01f0, B:58:0x0278, B:75:0x0328] A[DONT_GENERATE, DONT_INLINE]
          0x01f5: PHI (r8v7 int) = (r8v0 int), (r8v0 int), (r8v3 int), (r8v9 int) binds: [B:42:0x01f3, B:41:0x01f0, B:58:0x0278, B:75:0x0328] A[DONT_GENERATE, DONT_INLINE]
          0x01f5: PHI (r9v8 ??) = (r9v20 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), (r9v0 ??), (r9v25 ??), (r9v9 ??) binds: [B:42:0x01f3, B:41:0x01f0, B:58:0x0278, B:75:0x0328] A[DONT_GENERATE, DONT_INLINE]
          0x01f5: PHI (r10v16 long) = (r10v1 long), (r10v3 long), (r10v13 long), (r10v17 long) binds: [B:42:0x01f3, B:41:0x01f0, B:58:0x0278, B:75:0x0328] A[DONT_GENERATE, DONT_INLINE]
          0x01f5: PHI (r12v30 io.ktor.utils.io.CountedByteReadChannel) = 
          (r12v3 io.ktor.utils.io.CountedByteReadChannel)
          (r12v6 io.ktor.utils.io.CountedByteReadChannel)
          (r12v26 io.ktor.utils.io.CountedByteReadChannel)
          (r12v32 io.ktor.utils.io.CountedByteReadChannel)
         binds: [B:42:0x01f3, B:41:0x01f0, B:58:0x0278, B:75:0x0328] A[DONT_GENERATE, DONT_INLINE]
          0x01f5: PHI (r13v22 kotlinx.io.Source) = (r13v8 kotlinx.io.Source), (r13v10 kotlinx.io.Source), (r13v17 kotlinx.io.Source), (r13v23 kotlinx.io.Source) binds: [B:42:0x01f3, B:41:0x01f0, B:58:0x0278, B:75:0x0328] A[DONT_GENERATE, DONT_INLINE]
          0x01f5: PHI (r16v17 long) = (r16v2 long), (r4v0 long), (r16v14 long), (r16v18 long) binds: [B:42:0x01f3, B:41:0x01f0, B:58:0x0278, B:75:0x0328] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:45:0x01fb  */
        /* JADX WARN: Code duplicated, block: B:48:0x0226  */
        /* JADX WARN: Code duplicated, block: B:51:0x0230  */
        /* JADX WARN: Code duplicated, block: B:54:0x0253 A[PHI: r3 r6 r7 r8 r9 r10 r12 r16
          0x0253: PHI (r3v31 kotlinx.io.Source) = (r3v15 kotlinx.io.Source), (r3v32 kotlinx.io.Source) binds: [B:27:0x0122, B:52:0x024f] A[DONT_GENERATE, DONT_INLINE]
          0x0253: PHI (r6v25 kotlinx.io.bytestring.ByteString) = (r6v8 kotlinx.io.bytestring.ByteString), (r6v26 kotlinx.io.bytestring.ByteString) binds: [B:27:0x0122, B:52:0x024f] A[DONT_GENERATE, DONT_INLINE]
          0x0253: PHI (r7v9 boolean) = (r7v0 boolean), (r7v10 boolean) binds: [B:27:0x0122, B:52:0x024f] A[DONT_GENERATE, DONT_INLINE]
          0x0253: PHI (r8v4 int) = (r8v0 int), (r8v5 int) binds: [B:27:0x0122, B:52:0x024f] A[DONT_GENERATE, DONT_INLINE]
          0x0253: PHI (r9v6 ??) = (r9v22 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), (r9v27 ??) binds: [B:27:0x0122, B:52:0x024f] A[DONT_GENERATE, DONT_INLINE]
          0x0253: PHI (r10v14 long) = (r10v6 long), (r10v15 long) binds: [B:27:0x0122, B:52:0x024f] A[DONT_GENERATE, DONT_INLINE]
          0x0253: PHI (r12v28 io.ktor.utils.io.CountedByteReadChannel) = (r12v12 io.ktor.utils.io.CountedByteReadChannel), (r12v29 io.ktor.utils.io.CountedByteReadChannel) binds: [B:27:0x0122, B:52:0x024f] A[DONT_GENERATE, DONT_INLINE]
          0x0253: PHI (r16v15 long) = (r16v7 long), (r16v16 long) binds: [B:27:0x0122, B:52:0x024f] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r9v0 */
        /* JADX WARN: Type inference failed for: r9v20 */
        /* JADX WARN: Type inference failed for: r9v21 */
        /* JADX WARN: Type inference failed for: r9v22 */
        /* JADX WARN: Type inference failed for: r9v23 */
        /* JADX WARN: Type inference failed for: r9v25 */
        /* JADX WARN: Type inference failed for: r9v26 */
        /* JADX WARN: Type inference failed for: r9v27 */
        /* JADX WARN: Type inference failed for: r9v28 */
        /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.Object, kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.Job] */
        /* JADX WARN: Type inference failed for: r9v6 */
        /* JADX WARN: Type inference failed for: r9v7 */
        /* JADX WARN: Type inference failed for: r9v8, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r9v9 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x0278 -> B:43:0x01f5). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x0324 -> B:16:0x00bb). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r29) {
            /*
                Method dump skipped, instruction units count: 1240
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.MultipartKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private static final ReceiveChannel<MultipartEvent> parseMultipart(CoroutineScope coroutineScope, ByteString byteString, ByteReadChannel byteReadChannel, Long l, long j) {
        return ProduceKt.produce$default(coroutineScope, null, 0, new AnonymousClass1(byteReadChannel, byteString, j, l, null), 3, null);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0023  */
    /* JADX WARN: Code duplicated, block: B:24:0x0035  */
    /* JADX WARN: Code duplicated, block: B:40:0x005a  */
    private static final int findBoundary(CharSequence charSequence) {
        int length = charSequence.length();
        char c = 0;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = charSequence.charAt(i2);
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        if (c != 3) {
                            if (c == 4) {
                                c = 3;
                            }
                        } else if (cCharAt == '\"') {
                            i = 0;
                            c = 1;
                        } else if (cCharAt == '\\') {
                            c = 4;
                        }
                    } else if (cCharAt == '\"') {
                        c = 3;
                    } else if (cCharAt == ',') {
                        c = 0;
                    } else if (cCharAt == ';') {
                        i = 0;
                        c = 1;
                    }
                } else if (cCharAt == '=') {
                    c = 2;
                } else if (cCharAt == ';') {
                    i = 0;
                } else if (cCharAt == ',') {
                    c = 0;
                } else if (cCharAt == ' ') {
                    continue;
                } else {
                    if (i == 0 && kotlin.text.StringsKt.startsWith(charSequence, (CharSequence) "boundary=", i2, true)) {
                        return i2;
                    }
                    i++;
                }
            } else if (cCharAt == ';') {
                i = 0;
                c = 1;
            }
        }
        return -1;
    }

    public static final byte[] parseBoundaryInternal(CharSequence contentType) throws IOException {
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        int iFindBoundary = findBoundary(contentType);
        if (iFindBoundary == -1) {
            throw new IOException("Failed to parse multipart: Content-Type's boundary parameter is missing");
        }
        byte[] bArr = new byte[74];
        Ref.IntRef intRef = new Ref.IntRef();
        parseBoundaryInternal$put(intRef, bArr, Ascii.CR);
        parseBoundaryInternal$put(intRef, bArr, (byte) 10);
        parseBoundaryInternal$put(intRef, bArr, PrefixChar);
        parseBoundaryInternal$put(intRef, bArr, PrefixChar);
        int length = contentType.length();
        char c = 0;
        for (int i = iFindBoundary + 9; i < length; i++) {
            char cCharAt = contentType.charAt(i);
            int i2 = cCharAt & CharCompanionObject.MAX_VALUE;
            if ((65535 & cCharAt) > 127) {
                StringBuilder sb = new StringBuilder("Failed to parse multipart: wrong boundary byte 0x");
                String string = Integer.toString(i2, kotlin.text.CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                sb.append(string);
                sb.append(" - should be 7bit character");
                throw new IOException(sb.toString());
            }
            if (c != 0) {
                if (c == 1) {
                    if (cCharAt == ' ' || cCharAt == ',' || cCharAt == ';') {
                        break;
                    }
                    parseBoundaryInternal$put(intRef, bArr, (byte) i2);
                } else if (c == 2) {
                    if (cCharAt == '\"') {
                        break;
                    }
                    if (cCharAt != '\\') {
                        parseBoundaryInternal$put(intRef, bArr, (byte) i2);
                    } else {
                        c = 3;
                    }
                } else if (c == 3) {
                    parseBoundaryInternal$put(intRef, bArr, (byte) i2);
                    c = 2;
                }
            } else if (cCharAt == ' ') {
                continue;
            } else if (cCharAt == '\"') {
                c = 2;
            } else {
                if (cCharAt == ',' || cCharAt == ';') {
                    break;
                }
                parseBoundaryInternal$put(intRef, bArr, (byte) i2);
                c = 1;
            }
        }
        if (intRef.element == 4) {
            throw new IOException("Empty multipart boundary is not allowed");
        }
        return ArraysKt.copyOfRange(bArr, 0, intRef.element);
    }

    private static final void parseBoundaryInternal$put(Ref.IntRef intRef, byte[] bArr, byte b) throws IOException {
        if (intRef.element >= bArr.length) {
            throw new IOException("Failed to parse multipart: boundary shouldn't be longer than 70 characters");
        }
        int i = intRef.element;
        intRef.element = i + 1;
        bArr[i] = b;
    }

    private static final Void throwLimitExceeded(long j, long j2) throws IOException {
        throw new IOException("Multipart content length exceeds limit " + j + " > " + j2 + "; limit is defined using 'formFieldLimit' argument");
    }
}

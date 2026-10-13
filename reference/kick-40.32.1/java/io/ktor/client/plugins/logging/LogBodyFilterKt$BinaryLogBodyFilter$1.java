package io.ktor.client.plugins.logging;

import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.Headers;
import io.ktor.http.Url;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.charsets.EncodingKt;
import io.ktor.utils.io.charsets.MalformedInputException;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.io.Buffer;
import kotlinx.io.RawSource;

/* JADX INFO: compiled from: LogBodyFilter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J4\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"io/ktor/client/plugins/logging/LogBodyFilterKt$BinaryLogBodyFilter$1", "Lio/ktor/client/plugins/logging/CommonLogBodyFilter;", "", "contentLength", "Lio/ktor/http/ContentType;", "contentType", "Lio/ktor/http/Headers;", "headers", "Lio/ktor/utils/io/ByteReadChannel;", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "Lio/ktor/client/plugins/logging/BodyFilterResult;", "filterAll", "(Ljava/lang/Long;Lio/ktor/http/ContentType;Lio/ktor/http/Headers;Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-logging"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LogBodyFilterKt$BinaryLogBodyFilter$1 implements CommonLogBodyFilter {
    LogBodyFilterKt$BinaryLogBodyFilter$1() {
    }

    @Override // io.ktor.client.plugins.logging.CommonLogBodyFilter, io.ktor.client.plugins.logging.LogBodyFilter
    public /* bridge */ Object filterRequest(Url url, Long l, ContentType contentType, Headers headers, ByteReadChannel byteReadChannel, Continuation<? super BodyFilterResult> continuation) {
        return super.filterRequest(url, l, contentType, headers, byteReadChannel, continuation);
    }

    @Override // io.ktor.client.plugins.logging.CommonLogBodyFilter, io.ktor.client.plugins.logging.LogBodyFilter
    public /* bridge */ Object filterResponse(Url url, Long l, ContentType contentType, Headers headers, ByteReadChannel byteReadChannel, Continuation<? super BodyFilterResult> continuation) {
        return super.filterResponse(url, l, contentType, headers, byteReadChannel, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:45:0x014b  */
    /* JADX WARN: Code duplicated, block: B:47:0x014e  */
    /* JADX WARN: Code duplicated, block: B:52:0x0170  */
    /* JADX WARN: Code duplicated, block: B:54:0x0178 A[LOOP:0: B:53:0x0176->B:54:0x0178, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:57:0x0187  */
    /* JADX WARN: Code duplicated, block: B:62:0x019c A[EDGE_INSN: B:62:0x019c->B:63:0x01a0 BREAK  A[LOOP:1: B:56:0x0185->B:61:0x0196], PHI: r2
      0x019c: PHI (r2v6 int) = (r2v5 int), (r2v9 int) binds: [B:51:0x016e, B:79:0x019c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:64:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:65:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:68:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:73:0x020f  */
    /* JADX WARN: Code duplicated, block: B:79:0x019c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    @Override // io.ktor.client.plugins.logging.CommonLogBodyFilter
    public Object filterAll(Long l, ContentType contentType, Headers headers, ByteReadChannel byteReadChannel, Continuation<? super BodyFilterResult> continuation) throws Throwable {
        LogBodyFilterKt$BinaryLogBodyFilter$1$filterAll$1 logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$1;
        Headers headers2;
        Charset charset;
        Charset charset2;
        byte[] bArr;
        Object obj;
        int i;
        ByteReadChannel byteReadChannel2;
        ContentType contentType2;
        Charset charset3;
        int iIntValue;
        Buffer buffer;
        String strDecode$default;
        int i2;
        Buffer buffer2;
        Buffer buffer3;
        int length;
        int i3;
        int i4;
        int length2;
        int i5;
        Charset charset4;
        Long l2 = l;
        ContentType contentType3 = contentType;
        if (continuation instanceof LogBodyFilterKt$BinaryLogBodyFilter$1$filterAll$1) {
            logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$1 = (LogBodyFilterKt$BinaryLogBodyFilter$1$filterAll$1) continuation;
            if ((logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$1.label & Integer.MIN_VALUE) != 0) {
                logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$1.label -= Integer.MIN_VALUE;
            } else {
                logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$1 = new LogBodyFilterKt$BinaryLogBodyFilter$1$filterAll$1(this, continuation);
            }
        } else {
            logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$1 = new LogBodyFilterKt$BinaryLogBodyFilter$1$filterAll$1(this, continuation);
        }
        LogBodyFilterKt$BinaryLogBodyFilter$1$filterAll$1 logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2 = logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$1;
        Object buffer4 = logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i6 = logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.label;
        if (i6 == 0) {
            ResultKt.throwOnFailure(buffer4);
            headers2 = headers;
            if (headers2.contains("Content-Encoding")) {
                return new BodyFilterResult.Skip("encoded", l2);
            }
            if (contentType3 != null && ContentTypesKt.isTextType(contentType3)) {
                logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$0 = SpillingKt.nullOutSpilledVariable(l2);
                logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$1 = contentType3;
                logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$2 = SpillingKt.nullOutSpilledVariable(headers2);
                logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$3 = SpillingKt.nullOutSpilledVariable(byteReadChannel);
                logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.label = 1;
                buffer4 = ByteReadChannelOperationsKt.readBuffer(byteReadChannel, logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2);
                if (buffer4 != coroutine_suspended) {
                    contentType2 = contentType3;
                    Buffer buffer5 = (Buffer) buffer4;
                    charset3 = ContentTypesKt.charset(contentType2);
                    if (charset3 == null) {
                        charset3 = Charsets.UTF_8;
                    }
                    return new BodyFilterResult.BufferContent(buffer5, charset3, 0L, 4, null);
                }
            } else {
                if (contentType3 == null || (charset = ContentTypesKt.charset(contentType3)) == null) {
                    charset = Charsets.UTF_8;
                }
                charset2 = charset;
                bArr = new byte[1024];
                logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$0 = l2;
                logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$1 = contentType3;
                logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$2 = SpillingKt.nullOutSpilledVariable(headers2);
                logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$3 = byteReadChannel;
                logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$4 = charset2;
                logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$5 = bArr;
                logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.I$0 = 0;
                logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.label = 2;
                Object available$default = ByteReadChannelOperationsKt.readAvailable$default(byteReadChannel, bArr, 0, 0, logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2, 6, null);
                if (available$default != coroutine_suspended) {
                    obj = available$default;
                    i = 0;
                    byteReadChannel2 = byteReadChannel;
                    iIntValue = ((Number) obj).intValue();
                    if (iIntValue < 1) {
                        return BodyFilterResult.Empty.INSTANCE;
                    }
                    buffer = new Buffer();
                    BytePacketBuilderKt.writeFully(buffer, bArr, 0, iIntValue);
                    CharsetDecoder charsetDecoderNewDecoder = charset2.newDecoder();
                    Intrinsics.checkNotNullExpressionValue(charsetDecoderNewDecoder, "newDecoder(...)");
                    strDecode$default = EncodingKt.decode$default(charsetDecoderNewDecoder, buffer, 0, 2, null);
                    if (i == 0) {
                        i2 = i;
                        break;
                    }
                    length = strDecode$default.length();
                    i3 = -1;
                    for (i4 = 0; i4 < length; i4++) {
                        strDecode$default.charAt(i4);
                        i3++;
                    }
                    length2 = strDecode$default.length();
                    i5 = 0;
                    while (true) {
                        if (i5 < length2) {
                            i2 = i;
                            break;
                        }
                        int i7 = i;
                        if (strDecode$default.charAt(i5) != 65533) {
                        }
                        i5++;
                        i = i7;
                    }
                    if (i2 != 0) {
                        return new BodyFilterResult.Skip("binary", l2);
                    }
                    buffer2 = new Buffer();
                    BytePacketBuilderKt.writeFully(buffer2, bArr, 0, iIntValue);
                    logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$0 = SpillingKt.nullOutSpilledVariable(l2);
                    logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$1 = contentType3;
                    logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$2 = SpillingKt.nullOutSpilledVariable(headers2);
                    logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$3 = SpillingKt.nullOutSpilledVariable(byteReadChannel2);
                    logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$4 = SpillingKt.nullOutSpilledVariable(charset2);
                    logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$5 = SpillingKt.nullOutSpilledVariable(bArr);
                    logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$6 = SpillingKt.nullOutSpilledVariable(buffer);
                    logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$7 = SpillingKt.nullOutSpilledVariable(strDecode$default);
                    logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$8 = buffer2;
                    logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$9 = SpillingKt.nullOutSpilledVariable(buffer2);
                    logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$10 = buffer2;
                    logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.I$0 = i2;
                    logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.I$1 = iIntValue;
                    logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.I$2 = 0;
                    logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.label = 3;
                    buffer4 = ByteReadChannelOperationsKt.readBuffer(byteReadChannel2, logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2);
                    if (buffer4 != coroutine_suspended) {
                        buffer3 = buffer2;
                        buffer3.transferFrom((RawSource) buffer4);
                        if (contentType3 != null) {
                            charset4 = Charsets.UTF_8;
                        } else {
                            charset4 = Charsets.UTF_8;
                        }
                        return new BodyFilterResult.BufferContent(buffer2, charset4, 0L, 4, null);
                    }
                }
            }
            return coroutine_suspended;
        }
        if (i6 == 1) {
            contentType2 = (ContentType) logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$1;
            ResultKt.throwOnFailure(buffer4);
            Buffer buffer6 = (Buffer) buffer4;
            charset3 = ContentTypesKt.charset(contentType2);
            if (charset3 == null) {
                charset3 = Charsets.UTF_8;
            }
            return new BodyFilterResult.BufferContent(buffer6, charset3, 0L, 4, null);
        }
        if (i6 == 2) {
            int i8 = logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.I$0;
            byte[] bArr2 = (byte[]) logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$5;
            Charset charset5 = (Charset) logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$4;
            byteReadChannel2 = (ByteReadChannel) logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$3;
            Headers headers3 = (Headers) logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$2;
            ContentType contentType4 = (ContentType) logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$1;
            Long l3 = (Long) logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$0;
            ResultKt.throwOnFailure(buffer4);
            charset2 = charset5;
            headers2 = headers3;
            i = i8;
            obj = buffer4;
            l2 = l3;
            bArr = bArr2;
            contentType3 = contentType4;
            iIntValue = ((Number) obj).intValue();
            if (iIntValue < 1) {
                return BodyFilterResult.Empty.INSTANCE;
            }
            buffer = new Buffer();
            BytePacketBuilderKt.writeFully(buffer, bArr, 0, iIntValue);
            try {
                CharsetDecoder charsetDecoderNewDecoder2 = charset2.newDecoder();
                Intrinsics.checkNotNullExpressionValue(charsetDecoderNewDecoder2, "newDecoder(...)");
                strDecode$default = EncodingKt.decode$default(charsetDecoderNewDecoder2, buffer, 0, 2, null);
            } catch (MalformedInputException unused) {
                strDecode$default = "";
                i = 1;
            }
            if (i == 0) {
                i2 = i;
                break;
            }
            length = strDecode$default.length();
            i3 = -1;
            while (i4 < length) {
                strDecode$default.charAt(i4);
                i3++;
            }
            length2 = strDecode$default.length();
            i5 = 0;
            while (true) {
                if (i5 < length2) {
                    i2 = i;
                    break;
                }
                int i9 = i;
                if (strDecode$default.charAt(i5) != 65533 && i5 != i3) {
                    i2 = 1;
                    break;
                }
                i5++;
                i = i9;
            }
            if (i2 != 0) {
                return new BodyFilterResult.Skip("binary", l2);
            }
            buffer2 = new Buffer();
            BytePacketBuilderKt.writeFully(buffer2, bArr, 0, iIntValue);
            logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$0 = SpillingKt.nullOutSpilledVariable(l2);
            logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$1 = contentType3;
            logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$2 = SpillingKt.nullOutSpilledVariable(headers2);
            logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$3 = SpillingKt.nullOutSpilledVariable(byteReadChannel2);
            logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$4 = SpillingKt.nullOutSpilledVariable(charset2);
            logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$5 = SpillingKt.nullOutSpilledVariable(bArr);
            logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$6 = SpillingKt.nullOutSpilledVariable(buffer);
            logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$7 = SpillingKt.nullOutSpilledVariable(strDecode$default);
            logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$8 = buffer2;
            logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$9 = SpillingKt.nullOutSpilledVariable(buffer2);
            logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$10 = buffer2;
            logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.I$0 = i2;
            logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.I$1 = iIntValue;
            logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.I$2 = 0;
            logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.label = 3;
            buffer4 = ByteReadChannelOperationsKt.readBuffer(byteReadChannel2, logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2);
            if (buffer4 != coroutine_suspended) {
                buffer3 = buffer2;
            }
            return coroutine_suspended;
        }
        if (i6 != 3) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i10 = logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.I$2;
        int i11 = logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.I$1;
        int i12 = logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.I$0;
        buffer3 = (Buffer) logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$10;
        Buffer buffer7 = (Buffer) logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$8;
        ContentType contentType5 = (ContentType) logBodyFilterKt$BinaryLogBodyFilter$1$filterAll$2.L$1;
        ResultKt.throwOnFailure(buffer4);
        buffer2 = buffer7;
        contentType3 = contentType5;
        buffer3.transferFrom((RawSource) buffer4);
        if (contentType3 != null || (charset4 = ContentTypesKt.charset(contentType3)) == null) {
            charset4 = Charsets.UTF_8;
        }
        return new BodyFilterResult.BufferContent(buffer2, charset4, 0L, 4, null);
    }
}

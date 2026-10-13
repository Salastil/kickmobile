package io.ktor.utils.io;

import androidx.media3.muxer.WebmConstants;
import androidx.window.core.layout.WindowSizeClass;
import com.datadog.android.core.internal.metrics.BatchMetricsDispatcher;
import com.facebook.imageutils.JfifUtil;
import com.facebook.imageutils.TiffUtil;
import com.facebook.react.uimanager.ViewProps;
import com.google.mlkit.common.MlKitException;
import io.ktor.utils.io.charsets.TooLongLineException;
import io.ktor.utils.io.core.BuffersKt;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import io.ktor.utils.io.core.ByteReadPacketKt;
import io.ktor.utils.io.core.InputKt;
import java.io.EOFException;
import java.io.IOException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.io.Buffer;
import kotlinx.io.ByteStringsKt;
import kotlinx.io.RawSink;
import kotlinx.io.Segment;
import kotlinx.io.Sink;
import kotlinx.io.Source;
import kotlinx.io.SourcesKt;
import kotlinx.io.Utf8Kt;
import kotlinx.io.bytestring.ByteString;
import kotlinx.io.unsafe.UnsafeBufferOperations;
import org.bouncycastle.asn1.eac.EACTags;

/* JADX INFO: compiled from: ByteReadChannelOperations.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0015\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0005\u001a\u00020\u0004*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0014\u0010\u0007\u001a\u00020\u0006*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0007\u0010\u0003\u001a\u0014\u0010\t\u001a\u00020\b*\u00020\u0000H\u0086@¢\u0006\u0004\b\t\u0010\u0003\u001a\u0014\u0010\u000b\u001a\u00020\n*\u00020\u0000H\u0086@¢\u0006\u0004\b\u000b\u0010\u0003\u001a\u0014\u0010\r\u001a\u00020\f*\u00020\u0000H\u0086@¢\u0006\u0004\b\r\u0010\u0003\u001a\u0014\u0010\u000f\u001a\u00020\u000e*\u00020\u0000H\u0086@¢\u0006\u0004\b\u000f\u0010\u0003\u001a\u0014\u0010\u0011\u001a\u00020\u0010*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0011\u0010\u0003\u001a\u001c\u0010\u0014\u001a\u00020\u0013*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\nH\u0082@¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0014\u0010\u0017\u001a\u00020\u0016*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0017\u0010\u0003\u001a\u001c\u0010\u0017\u001a\u00020\u0016*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\nH\u0086@¢\u0006\u0004\b\u0017\u0010\u0015\u001a\u001c\u0010\u001b\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019H\u0086@¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001c\u0010\u001d\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019H\u0086@¢\u0006\u0004\b\u001d\u0010\u001c\u001a&\u0010!\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020\u000eH\u0086@¢\u0006\u0004\b!\u0010\"\u001a$\u0010\u001d\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u001d\u0010#\u001a\u001c\u0010%\u001a\u00020\u0004*\u00020\u00002\u0006\u0010$\u001a\u00020\nH\u0086@¢\u0006\u0004\b%\u0010\u0015\u001a\u0014\u0010'\u001a\u00020&*\u00020\u0000H\u0086@¢\u0006\u0004\b'\u0010\u0003\u001a\u001c\u0010'\u001a\u00020&*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b'\u0010(\u001a0\u0010,\u001a\u00020\n*\u00020\u00002\u0006\u0010)\u001a\u00020\u00042\b\b\u0002\u0010*\u001a\u00020\n2\b\b\u0002\u0010+\u001a\u00020\nH\u0086@¢\u0006\u0004\b,\u0010-\u001a-\u0010,\u001a\u00020\n*\u00020\u00002\u0006\u0010.\u001a\u00020\n2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\n0/¢\u0006\u0004\b,\u00101\u001aN\u0010<\u001a\u00020;*\u0002022\b\b\u0002\u00104\u001a\u0002032\b\b\u0002\u00105\u001a\u00020\u00012'\u00100\u001a#\b\u0001\u0012\u0004\u0012\u000207\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001308\u0012\u0006\u0012\u0004\u0018\u00010906¢\u0006\u0002\b:¢\u0006\u0004\b<\u0010=\u001aJ\u0010<\u001a\u00020;*\u0002022\u0006\u00104\u001a\u0002032\u0006\u0010\u001a\u001a\u00020>2'\u00100\u001a#\b\u0001\u0012\u0004\u0012\u000207\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001308\u0012\u0006\u0012\u0004\u0018\u00010906¢\u0006\u0002\b:¢\u0006\u0004\b<\u0010?\u001a\u001c\u0010A\u001a\u00020&*\u00020\u00002\u0006\u0010@\u001a\u00020\nH\u0086@¢\u0006\u0004\bA\u0010\u0015\u001a\u001c\u0010C\u001a\u00020\u0013*\u00020\u00002\u0006\u0010B\u001a\u00020\u000eH\u0086@¢\u0006\u0004\bC\u0010(\u001a\u001e\u0010D\u001a\u00020\u000e*\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u000eH\u0086@¢\u0006\u0004\bD\u0010(\u001a \u0010F\u001a\u0004\u0018\u00010E*\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\nH\u0087@¢\u0006\u0004\bF\u0010\u0015\u001a*\u0010J\u001a\u00020\u0001*\u00020\u00002\n\u0010I\u001a\u00060Gj\u0002`H2\b\b\u0002\u0010\u0018\u001a\u00020\nH\u0087@¢\u0006\u0004\bJ\u0010K\u001a4\u0010J\u001a\u00020\u0001*\u00020\u00002\n\u0010I\u001a\u00060Gj\u0002`H2\b\b\u0002\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010M\u001a\u00020LH\u0087@¢\u0006\u0004\bN\u0010O\u001a \u0010Q\u001a\u0004\u0018\u00010E*\u00020\u00002\b\b\u0002\u0010M\u001a\u00020PH\u0086@¢\u0006\u0004\bQ\u0010R\u001a*\u0010S\u001a\u00020\u000e*\u00020\u00002\n\u0010I\u001a\u00060Gj\u0002`H2\b\b\u0002\u0010M\u001a\u00020PH\u0086@¢\u0006\u0004\bS\u0010T\u001a*\u0010U\u001a\u0004\u0018\u00010E*\u00020\u00002\b\b\u0002\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010M\u001a\u00020PH\u0086@¢\u0006\u0004\bU\u0010V\u001a4\u0010W\u001a\u00020\u000e*\u00020\u00002\n\u0010I\u001a\u00060Gj\u0002`H2\b\b\u0002\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010M\u001a\u00020PH\u0086@¢\u0006\u0004\bW\u0010X\u001a8\u0010[\u001a\u00020\u000e*\u00020\u00002\n\u0010I\u001a\u00060Gj\u0002`H2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010Y\u001a\u00020\u00012\u0006\u0010Z\u001a\u00020\u0001H\u0082@¢\u0006\u0004\b[\u0010\\\u001a\u0017\u0010^\u001a\u00020]2\u0006\u0010 \u001a\u00020\u000eH\u0002¢\u0006\u0004\b^\u0010_\u001a\u0017\u0010a\u001a\u00020]2\u0006\u0010`\u001a\u00020\u000eH\u0002¢\u0006\u0004\ba\u0010_\u001aF\u0010c\u001a\u00020\n*\u00020\u000020\b\u0004\u00100\u001a*\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n08\u0012\u0006\u0012\u0004\u0018\u0001090bH\u0086H¢\u0006\u0004\bc\u0010d\u001a0\u0010g\u001a\u00020\u0013*\u00020\u00002\u0006\u0010I\u001a\u00020\u00042\b\b\u0002\u0010e\u001a\u00020\n2\b\b\u0002\u0010f\u001a\u00020\nH\u0086@¢\u0006\u0004\bg\u0010-\u001a\u0013\u0010h\u001a\u00020\u0013*\u00020\u0000H\u0007¢\u0006\u0004\bh\u0010i\u001a\u0013\u0010h\u001a\u00020\u0013*\u00020\u0019H\u0007¢\u0006\u0004\bh\u0010j\u001a\u0013\u0010h\u001a\u00020\u0013*\u00020>H\u0007¢\u0006\u0004\bh\u0010k\u001a8\u0010p\u001a\u00020\u000e*\u00020\u00002\u0006\u0010m\u001a\u00020l2\u0006\u0010n\u001a\u00020\u00192\b\b\u0002\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010o\u001a\u00020\u0001H\u0086@¢\u0006\u0004\bp\u0010q\u001a\u001c\u0010s\u001a\u00020\u0001*\u00020\u00002\u0006\u0010r\u001a\u00020lH\u0086@¢\u0006\u0004\bs\u0010t\u001a\u001e\u0010u\u001a\u0004\u0018\u00010l*\u00020\u00002\u0006\u0010$\u001a\u00020\nH\u0086@¢\u0006\u0004\bu\u0010\u0015\"\u001b\u0010y\u001a\u00020\n*\u00020\u00198F¢\u0006\f\u0012\u0004\bx\u0010j\u001a\u0004\bv\u0010w\"\u0014\u0010z\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bz\u0010{\"\u0014\u0010|\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b|\u0010{\"\u001c\u0010\u0080\u0001\u001a\u00020\n*\u00020\u00008F¢\u0006\f\u0012\u0004\b\u007f\u0010i\u001a\u0004\b}\u0010~¨\u0006\u0081\u0001"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "", "exhausted", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "toByteArray", "", "readByte", "", "readShort", "", "readInt", "", "readFloat", "", "readLong", "", "readDouble", "numberOfBytes", "", "awaitUntilReadable", "(Lio/ktor/utils/io/ByteReadChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/io/Buffer;", "readBuffer", BatchMetricsDispatcher.UPLOADER_DELAY_MAX_KEY, "Lio/ktor/utils/io/ByteWriteChannel;", "channel", "copyAndClose", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copyTo", "Lkotlinx/io/RawSink;", "sink", "limit", "readTo", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlinx/io/RawSink;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "count", "readByteArray", "Lkotlinx/io/Source;", "readRemaining", "(Lio/ktor/utils/io/ByteReadChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buffer", "offset", "length", "readAvailable", "(Lio/ktor/utils/io/ByteReadChannel;[BIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", BatchMetricsDispatcher.UPLOADER_DELAY_MIN_KEY, "Lkotlin/Function1;", "block", "(Lio/ktor/utils/io/ByteReadChannel;ILkotlin/jvm/functions/Function1;)I", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "autoFlush", "Lkotlin/Function2;", "Lio/ktor/utils/io/ReaderScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "Lio/ktor/utils/io/ReaderJob;", "reader", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ZLkotlin/jvm/functions/Function2;)Lio/ktor/utils/io/ReaderJob;", "Lio/ktor/utils/io/ByteChannel;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lio/ktor/utils/io/ByteChannel;Lkotlin/jvm/functions/Function2;)Lio/ktor/utils/io/ReaderJob;", "packet", "readPacket", "value", "discardExact", "discard", "", "readUTF8Line", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "out", "readUTF8LineTo", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/lang/Appendable;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/LineEndingMode;", "lineEnding", "readUTF8LineTo-RRvyBJ8", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/lang/Appendable;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/LineEnding;", "readLine", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/LineEnding;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readLineTo", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/lang/Appendable;Lio/ktor/utils/io/LineEnding;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readLineStrict", "(Lio/ktor/utils/io/ByteReadChannel;JLio/ktor/utils/io/LineEnding;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readLineStrictTo", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/lang/Appendable;JLio/ktor/utils/io/LineEnding;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lenientLineEnding", "throwOnIncompleteLine", "internalReadLineTo", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/lang/Appendable;JZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "throwTooLongLineException", "(J)Ljava/lang/Void;", "consumed", "throwEndOfStreamException", "Lkotlin/Function4;", "read", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ViewProps.START, ViewProps.END, "readFully", "rethrowCloseCauseIfNeeded", "(Lio/ktor/utils/io/ByteReadChannel;)V", "(Lio/ktor/utils/io/ByteWriteChannel;)V", "(Lio/ktor/utils/io/ByteChannel;)V", "Lkotlinx/io/bytestring/ByteString;", "matchString", "writeChannel", "ignoreMissing", "readUntil", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlinx/io/bytestring/ByteString;Lio/ktor/utils/io/ByteWriteChannel;JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "byteString", "skipIfFound", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlinx/io/bytestring/ByteString;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "peek", "getAvailableForWrite", "(Lio/ktor/utils/io/ByteWriteChannel;)I", "getAvailableForWrite$annotations", "availableForWrite", "CR", "B", "LF", "getAvailableForRead", "(Lio/ktor/utils/io/ByteReadChannel;)I", "getAvailableForRead$annotations", "availableForRead", "ktor-io"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ByteReadChannelOperationsKt {
    private static final byte CR = 13;
    private static final byte LF = 10;

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$awaitUntilReadable$1, reason: invalid class name */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0}, l = {92}, m = "awaitUntilReadable", n = {"$this$awaitUntilReadable", "numberOfBytes"}, s = {"L$0", "I$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.awaitUntilReadable(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$copyAndClose$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3}, l = {132, 133, 142, 142}, m = "copyAndClose", n = {"$this$copyAndClose", "channel", "result", "$this$copyAndClose", "channel", "result", "$this$copyAndClose", "channel", "result", "$this$copyAndClose", "channel", "result"}, s = {"L$0", "L$1", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1", "J$0"}, v = 1)
    static final class C10581 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C10581(Continuation<? super C10581> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.copyAndClose(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$copyTo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3}, l = {WebmConstants.MkvEbmlElement.FLAG_INTERLACED, WebmConstants.MkvEbmlElement.BLOCK_DURATION, 162, 162}, m = "copyTo", n = {"$this$copyTo", "channel", "result", "$this$copyTo", "channel", "result", "$this$copyTo", "channel", "result", "$this$copyTo", "channel", "result"}, s = {"L$0", "L$1", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1", "J$0"}, v = 1)
    static final class C10591 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C10591(Continuation<? super C10591> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.copyTo(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$copyTo$2, reason: invalid class name */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3}, l = {MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR, 209, JfifUtil.MARKER_SOI, JfifUtil.MARKER_SOI}, m = "copyTo", n = {"$this$copyTo", "channel", "limit", "remaining", "$this$copyTo", "channel", "limit", "remaining", "count", "$this$copyTo", "channel", "limit", "remaining", "$this$copyTo", "channel", "limit", "remaining"}, s = {"L$0", "L$1", "J$0", "J$1", "L$0", "L$1", "J$0", "J$1", "J$2", "L$0", "L$1", "J$0", "J$1", "L$0", "L$1", "J$0", "J$1"}, v = 1)
    static final class AnonymousClass2 extends ContinuationImpl {
        long J$0;
        long J$1;
        long J$2;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.copyTo(null, null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$discard$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0, 0}, l = {408}, m = "discard", n = {"$this$discard", BatchMetricsDispatcher.UPLOADER_DELAY_MAX_KEY, "remaining"}, s = {"L$0", "J$0", "J$1"}, v = 1)
    static final class C10601 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10601(Continuation<? super C10601> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.discard(null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$discardExact$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0}, l = {400}, m = "discardExact", n = {"$this$discardExact", "value"}, s = {"L$0", "J$0"}, v = 1)
    static final class C10611 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10611(Continuation<? super C10611> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.discardExact(null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$exhausted$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0}, l = {34}, m = "exhausted", n = {"$this$exhausted"}, s = {"L$0"}, v = 1)
    static final class C10621 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10621(Continuation<? super C10621> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.exhausted(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$internalReadLineTo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4}, l = {686, 757, 764, 776, 785}, m = "internalReadLineTo", n = {"$this$internalReadLineTo", "out", "readBuffer", "limit", "lenientLineEnding", "throwOnIncompleteLine", "$this$internalReadLineTo", "out", "readBuffer", "consumed", "limit", "lenientLineEnding", "throwOnIncompleteLine", "limitLeft", "lfIndex", "crIndex", "count", "$this$internalReadLineTo", "out", "readBuffer", "consumed", "limit", "lenientLineEnding", "throwOnIncompleteLine", "limitLeft", "lfIndex", "crIndex", "count", "$this$internalReadLineTo", "out", "readBuffer", "consumed", "limit", "lenientLineEnding", "throwOnIncompleteLine", "$this$internalReadLineTo", "out", "readBuffer", "consumed", "limit", "lenientLineEnding", "throwOnIncompleteLine"}, s = {"L$0", "L$1", "L$2", "J$0", "Z$0", "Z$1", "L$0", "L$1", "L$2", "L$3", "J$0", "Z$0", "Z$1", "J$1", "J$2", "J$3", "J$4", "L$0", "L$1", "L$2", "L$3", "J$0", "Z$0", "Z$1", "J$1", "J$2", "J$3", "J$4", "L$0", "L$1", "L$2", "L$3", "J$0", "Z$0", "Z$1", "L$0", "L$1", "L$2", "L$3", "J$0", "Z$0", "Z$1"}, v = 1)
    static final class C10631 extends ContinuationImpl {
        long J$0;
        long J$1;
        long J$2;
        long J$3;
        long J$4;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;

        C10631(Continuation<? super C10631> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.internalReadLineTo(null, null, 0L, false, false, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$peek$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0}, l = {925}, m = "peek", n = {"$this$peek", "count"}, s = {"L$0", "I$0"}, v = 1)
    static final class C10641 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10641(Continuation<? super C10641> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.peek(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$read$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {806, 811}, m = "read", n = {"$this$read", "block", "$i$f$read", "$this$read", "block", "result", "this_$iv", "buffer$iv", "head$iv", "array", "$i$f$read", "$i$f$readFromHead", "endExclusive", ViewProps.START, "$i$a$-readFromHead-ByteReadChannelOperationsKt$read$2"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2", "I$3", "I$4"}, v = 1)
    static final class C10651 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C10651(Continuation<? super C10651> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.read(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readAvailable$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0, 0, 0}, l = {TiffUtil.TIFF_TAG_ORIENTATION}, m = "readAvailable", n = {"$this$readAvailable", "buffer", "offset", "length"}, s = {"L$0", "L$1", "I$0", "I$1"}, v = 1)
    static final class C10661 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10661(Continuation<? super C10661> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readAvailable(null, null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readBuffer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0}, l = {102}, m = "readBuffer", n = {"$this$readBuffer", "result"}, s = {"L$0", "L$1"}, v = 1)
    static final class C10671 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10671(Continuation<? super C10671> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readBuffer(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readBuffer$3, reason: invalid class name */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0, 0, 0}, l = {116}, m = "readBuffer", n = {"$this$readBuffer", "result", BatchMetricsDispatcher.UPLOADER_DELAY_MAX_KEY, "remaining"}, s = {"L$0", "L$1", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass3 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readBuffer(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readByte$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0}, l = {45}, m = "readByte", n = {"$this$readByte", "currentBuffer"}, s = {"L$0", "L$1"}, v = 1)
    static final class C10681 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10681(Continuation<? super C10681> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readByte(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readByteArray$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0, 0, 0, 0, 0}, l = {224}, m = "readByteArray", n = {"$this$readByteArray", "builder$iv", "$this$readByteArray_u24lambda_u240", "count", "$i$f$buildPacket", "$i$a$-buildPacket-ByteReadChannelOperationsKt$readByteArray$2"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "I$2"}, v = 1)
    static final class C10691 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C10691(Continuation<? super C10691> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readByteArray(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readDouble$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0}, l = {87}, m = "readDouble", n = {"$this$readDouble"}, s = {"L$0"}, v = 1)
    static final class C10701 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10701(Continuation<? super C10701> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readDouble(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readFloat$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0}, l = {70}, m = "readFloat", n = {"$this$readFloat"}, s = {"L$0"}, v = 1)
    static final class C10711 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10711(Continuation<? super C10711> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readFloat(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readFully$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0, 0, 0, 0}, l = {WindowSizeClass.WIDTH_DP_EXPANDED_LOWER_BOUND}, m = "readFully", n = {"$this$readFully", "out", ViewProps.START, ViewProps.END, "offset"}, s = {"L$0", "L$1", "I$0", "I$1", "I$2"}, v = 1)
    static final class C10721 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10721(Continuation<? super C10721> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readFully(null, null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readInt$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0}, l = {EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION}, m = "readInt", n = {"$this$readInt"}, s = {"L$0"}, v = 1)
    static final class C10731 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10731(Continuation<? super C10731> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readInt(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readLine$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0, 0}, l = {586}, m = "readLine", n = {"$this$readLine", "lineEnding", "result"}, s = {"L$0", "L$1", "L$2"}, v = 1)
    static final class C10741 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C10741(Continuation<? super C10741> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readLine(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readLineStrict$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0, 0, 0}, l = {638}, m = "readLineStrict", n = {"$this$readLineStrict", "lineEnding", "result", "limit"}, s = {"L$0", "L$1", "L$2", "J$0"}, v = 1)
    static final class C10751 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C10751(Continuation<? super C10751> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readLineStrict(null, 0L, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readLong$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0}, l = {76}, m = "readLong", n = {"$this$readLong"}, s = {"L$0"}, v = 1)
    static final class C10761 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10761(Continuation<? super C10761> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readLong(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readPacket$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0, 0}, l = {383}, m = "readPacket", n = {"$this$readPacket", "result", "packet"}, s = {"L$0", "L$1", "I$0"}, v = 1)
    static final class C10771 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10771(Continuation<? super C10771> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readPacket(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readRemaining$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0}, l = {234}, m = "readRemaining", n = {"$this$readRemaining", "result"}, s = {"L$0", "L$1"}, v = 1)
    static final class C10781 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10781(Continuation<? super C10781> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readRemaining(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readRemaining$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0, 0, 0}, l = {254}, m = "readRemaining", n = {"$this$readRemaining", "result", BatchMetricsDispatcher.UPLOADER_DELAY_MAX_KEY, "remaining"}, s = {"L$0", "L$1", "J$0", "J$1"}, v = 1)
    static final class C10792 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10792(Continuation<? super C10792> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readRemaining(null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readShort$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0}, l = {53}, m = "readShort", n = {"$this$readShort"}, s = {"L$0"}, v = 1)
    static final class C10801 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10801(Continuation<? super C10801> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readShort(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readTo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0, 0, 0}, l = {184}, m = "readTo", n = {"$this$readTo", "sink", "limit", "remaining"}, s = {"L$0", "L$1", "J$0", "J$1"}, v = 1)
    static final class C10811 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10811(Continuation<? super C10811> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readTo(null, null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readUTF8Line$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0, 0}, l = {474}, m = "readUTF8Line", n = {"$this$readUTF8Line", "result", BatchMetricsDispatcher.UPLOADER_DELAY_MAX_KEY}, s = {"L$0", "L$1", "I$0"}, v = 1)
    static final class C10821 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10821(Continuation<? super C10821> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readUTF8Line(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readUTF8LineTo$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0, 0, 0}, l = {559}, m = "readUTF8LineTo-RRvyBJ8", n = {"$this$readUTF8LineTo_u2dRRvyBJ8", "out", BatchMetricsDispatcher.UPLOADER_DELAY_MAX_KEY, "lineEnding"}, s = {"L$0", "L$1", "I$0", "I$1"}, v = 1)
    static final class C10832 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10832(Continuation<? super C10832> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.m12644readUTF8LineToRRvyBJ8(null, null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$skipIfFound$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0, 1, 1}, l = {905, 906}, m = "skipIfFound", n = {"$this$skipIfFound", "byteString", "$this$skipIfFound", "byteString"}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class C10851 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10851(Continuation<? super C10851> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.skipIfFound(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$toByteArray$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0}, l = {39}, m = "toByteArray", n = {"$this$toByteArray"}, s = {"L$0"}, v = 1)
    static final class C10861 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10861(Continuation<? super C10861> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.toByteArray(null, this);
        }
    }

    public static /* synthetic */ void getAvailableForRead$annotations(ByteReadChannel byteReadChannel) {
    }

    public static /* synthetic */ void getAvailableForWrite$annotations(ByteWriteChannel byteWriteChannel) {
    }

    public static final int getAvailableForWrite(ByteWriteChannel byteWriteChannel) {
        Intrinsics.checkNotNullParameter(byteWriteChannel, "<this>");
        return 1048576 - BytePacketBuilderKt.getSize(byteWriteChannel.getWriteBuffer());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object exhausted(ByteReadChannel byteReadChannel, Continuation<? super Boolean> continuation) {
        C10621 c10621;
        if (continuation instanceof C10621) {
            c10621 = (C10621) continuation;
            if ((c10621.label & Integer.MIN_VALUE) != 0) {
                c10621.label -= Integer.MIN_VALUE;
            } else {
                c10621 = new C10621(continuation);
            }
        } else {
            c10621 = new C10621(continuation);
        }
        Object obj = c10621.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10621.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (byteReadChannel.getReadBuffer().exhausted()) {
                c10621.L$0 = byteReadChannel;
                c10621.label = 1;
                if (ByteReadChannel.awaitContent$default(byteReadChannel, 0, c10621, 1, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            byteReadChannel = (ByteReadChannel) c10621.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxBoolean(byteReadChannel.getReadBuffer().exhausted());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object toByteArray(ByteReadChannel byteReadChannel, Continuation<? super byte[]> continuation) throws Throwable {
        C10861 c10861;
        if (continuation instanceof C10861) {
            c10861 = (C10861) continuation;
            if ((c10861.label & Integer.MIN_VALUE) != 0) {
                c10861.label -= Integer.MIN_VALUE;
            } else {
                c10861 = new C10861(continuation);
            }
        } else {
            c10861 = new C10861(continuation);
        }
        Object buffer = c10861.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10861.label;
        if (i == 0) {
            ResultKt.throwOnFailure(buffer);
            c10861.L$0 = SpillingKt.nullOutSpilledVariable(byteReadChannel);
            c10861.label = 1;
            buffer = readBuffer(byteReadChannel, c10861);
            if (buffer == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(buffer);
        }
        return BuffersKt.readBytes$default((Buffer) buffer, 0, 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object readByte(ByteReadChannel byteReadChannel, Continuation<? super Byte> continuation) throws EOFException {
        C10681 c10681;
        Source readBuffer;
        Source source;
        if (continuation instanceof C10681) {
            c10681 = (C10681) continuation;
            if ((c10681.label & Integer.MIN_VALUE) != 0) {
                c10681.label -= Integer.MIN_VALUE;
            } else {
                c10681 = new C10681(continuation);
            }
        } else {
            c10681 = new C10681(continuation);
        }
        Object obj = c10681.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10681.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            readBuffer = byteReadChannel.getReadBuffer();
            if (readBuffer.exhausted()) {
                c10681.L$0 = SpillingKt.nullOutSpilledVariable(byteReadChannel);
                c10681.L$1 = readBuffer;
                c10681.label = 1;
                Object objAwaitContent$default = ByteReadChannel.awaitContent$default(byteReadChannel, 0, c10681, 1, null);
                if (objAwaitContent$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = objAwaitContent$default;
                source = readBuffer;
            }
            return Boxing.boxByte(readBuffer.readByte());
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        source = (Source) c10681.L$1;
        ResultKt.throwOnFailure(obj);
        if (!((Boolean) obj).booleanValue()) {
            throw new EOFException("Not enough data available");
        }
        readBuffer = source;
        return Boxing.boxByte(readBuffer.readByte());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object readShort(ByteReadChannel byteReadChannel, Continuation<? super Short> continuation) {
        C10801 c10801;
        if (continuation instanceof C10801) {
            c10801 = (C10801) continuation;
            if ((c10801.label & Integer.MIN_VALUE) != 0) {
                c10801.label -= Integer.MIN_VALUE;
            } else {
                c10801 = new C10801(continuation);
            }
        } else {
            c10801 = new C10801(continuation);
        }
        Object obj = c10801.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10801.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            c10801.L$0 = byteReadChannel;
            c10801.label = 1;
            if (awaitUntilReadable(byteReadChannel, 2, c10801) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            byteReadChannel = (ByteReadChannel) c10801.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxShort(byteReadChannel.getReadBuffer().readShort());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object readInt(ByteReadChannel byteReadChannel, Continuation<? super Integer> continuation) {
        C10731 c10731;
        if (continuation instanceof C10731) {
            c10731 = (C10731) continuation;
            if ((c10731.label & Integer.MIN_VALUE) != 0) {
                c10731.label -= Integer.MIN_VALUE;
            } else {
                c10731 = new C10731(continuation);
            }
        } else {
            c10731 = new C10731(continuation);
        }
        Object obj = c10731.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10731.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            c10731.L$0 = byteReadChannel;
            c10731.label = 1;
            if (awaitUntilReadable(byteReadChannel, 4, c10731) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            byteReadChannel = (ByteReadChannel) c10731.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxInt(byteReadChannel.getReadBuffer().readInt());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object readFloat(ByteReadChannel byteReadChannel, Continuation<? super Float> continuation) {
        C10711 c10711;
        if (continuation instanceof C10711) {
            c10711 = (C10711) continuation;
            if ((c10711.label & Integer.MIN_VALUE) != 0) {
                c10711.label -= Integer.MIN_VALUE;
            } else {
                c10711 = new C10711(continuation);
            }
        } else {
            c10711 = new C10711(continuation);
        }
        Object obj = c10711.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10711.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            c10711.L$0 = byteReadChannel;
            c10711.label = 1;
            if (awaitUntilReadable(byteReadChannel, 4, c10711) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            byteReadChannel = (ByteReadChannel) c10711.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxFloat(SourcesKt.readFloat(byteReadChannel.getReadBuffer()));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object readLong(ByteReadChannel byteReadChannel, Continuation<? super Long> continuation) {
        C10761 c10761;
        if (continuation instanceof C10761) {
            c10761 = (C10761) continuation;
            if ((c10761.label & Integer.MIN_VALUE) != 0) {
                c10761.label -= Integer.MIN_VALUE;
            } else {
                c10761 = new C10761(continuation);
            }
        } else {
            c10761 = new C10761(continuation);
        }
        Object obj = c10761.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10761.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            c10761.L$0 = byteReadChannel;
            c10761.label = 1;
            if (awaitUntilReadable(byteReadChannel, 8, c10761) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            byteReadChannel = (ByteReadChannel) c10761.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxLong(byteReadChannel.getReadBuffer().readLong());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object readDouble(ByteReadChannel byteReadChannel, Continuation<? super Double> continuation) {
        C10701 c10701;
        if (continuation instanceof C10701) {
            c10701 = (C10701) continuation;
            if ((c10701.label & Integer.MIN_VALUE) != 0) {
                c10701.label -= Integer.MIN_VALUE;
            } else {
                c10701 = new C10701(continuation);
            }
        } else {
            c10701 = new C10701(continuation);
        }
        Object obj = c10701.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10701.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            c10701.L$0 = byteReadChannel;
            c10701.label = 1;
            if (awaitUntilReadable(byteReadChannel, 8, c10701) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            byteReadChannel = (ByteReadChannel) c10701.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxDouble(SourcesKt.readDouble(byteReadChannel.getReadBuffer()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object awaitUntilReadable(ByteReadChannel byteReadChannel, int i, Continuation<? super Unit> continuation) throws EOFException {
        AnonymousClass1 anonymousClass1;
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
        Object objAwaitContent = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objAwaitContent);
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(byteReadChannel);
            anonymousClass1.I$0 = i;
            anonymousClass1.label = 1;
            objAwaitContent = byteReadChannel.awaitContent(i, anonymousClass1);
            if (objAwaitContent == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i3 = anonymousClass1.I$0;
            ResultKt.throwOnFailure(objAwaitContent);
        }
        if (!((Boolean) objAwaitContent).booleanValue()) {
            throw new EOFException("Not enough data available");
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object readBuffer(ByteReadChannel byteReadChannel, Continuation<? super Buffer> continuation) throws Throwable {
        C10671 c10671;
        Buffer buffer;
        if (continuation instanceof C10671) {
            c10671 = (C10671) continuation;
            if ((c10671.label & Integer.MIN_VALUE) != 0) {
                c10671.label -= Integer.MIN_VALUE;
            } else {
                c10671 = new C10671(continuation);
            }
        } else {
            c10671 = new C10671(continuation);
        }
        Object obj = c10671.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10671.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            buffer = new Buffer();
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Buffer buffer2 = (Buffer) c10671.L$1;
            ByteReadChannel byteReadChannel2 = (ByteReadChannel) c10671.L$0;
            ResultKt.throwOnFailure(obj);
            buffer = buffer2;
            byteReadChannel = byteReadChannel2;
        }
        while (!byteReadChannel.isClosedForRead()) {
            buffer.transferFrom(byteReadChannel.getReadBuffer());
            c10671.L$0 = byteReadChannel;
            c10671.L$1 = buffer;
            c10671.label = 1;
            if (ByteReadChannel.awaitContent$default(byteReadChannel, 0, c10671, 1, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        Throwable closedCause = byteReadChannel.getClosedCause();
        if (closedCause == null) {
            return buffer;
        }
        throw closedCause;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x004a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0058 -> B:25:0x0073). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x006d -> B:24:0x0070). Please report as a decompilation issue!!! */
    public static final Object readBuffer(ByteReadChannel byteReadChannel, int i, Continuation<? super Buffer> continuation) {
        AnonymousClass3 anonymousClass3;
        Buffer buffer;
        int i2;
        ByteReadChannel byteReadChannel2;
        int i3;
        int i4;
        if (continuation instanceof AnonymousClass3) {
            anonymousClass3 = (AnonymousClass3) continuation;
            if ((anonymousClass3.label & Integer.MIN_VALUE) != 0) {
                anonymousClass3.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass3 = new AnonymousClass3(continuation);
            }
        } else {
            anonymousClass3 = new AnonymousClass3(continuation);
        }
        Object obj = anonymousClass3.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = anonymousClass3.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            buffer = new Buffer();
            i2 = i;
            if (i > 0 || byteReadChannel.isClosedForRead()) {
                return buffer;
            }
            if (byteReadChannel.getReadBuffer().exhausted()) {
                anonymousClass3.L$0 = byteReadChannel;
                anonymousClass3.L$1 = buffer;
                anonymousClass3.I$0 = i2;
                anonymousClass3.I$1 = i;
                anonymousClass3.label = 1;
                if (ByteReadChannel.awaitContent$default(byteReadChannel, 0, anonymousClass3, 1, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                byteReadChannel2 = byteReadChannel;
                i3 = i;
                i4 = i2;
            }
            long jMin = Math.min(i, ByteReadPacketKt.getRemaining(byteReadChannel.getReadBuffer()));
            byteReadChannel.getReadBuffer().readTo(buffer, jMin);
            i -= (int) jMin;
            if (i > 0) {
            }
            return buffer;
        }
        if (i5 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        i3 = anonymousClass3.I$1;
        i4 = anonymousClass3.I$0;
        buffer = (Buffer) anonymousClass3.L$1;
        byteReadChannel2 = (ByteReadChannel) anonymousClass3.L$0;
        ResultKt.throwOnFailure(obj);
        i2 = i4;
        i = i3;
        byteReadChannel = byteReadChannel2;
        long jMin2 = Math.min(i, ByteReadPacketKt.getRemaining(byteReadChannel.getReadBuffer()));
        byteReadChannel.getReadBuffer().readTo(buffer, jMin2);
        i -= (int) jMin2;
        if (i > 0) {
        }
        return buffer;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0087 A[Catch: all -> 0x00de, TRY_LEAVE, TryCatch #2 {all -> 0x00de, blocks: (B:27:0x0081, B:29:0x0087, B:36:0x00ba, B:44:0x00dd), top: B:59:0x0081 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:36:0x00ba A[Catch: all -> 0x00de, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x00de, blocks: (B:27:0x0081, B:29:0x0087, B:36:0x00ba, B:44:0x00dd), top: B:59:0x0081 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:41:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:44:0x00dd A[Catch: all -> 0x00de, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x00de, blocks: (B:27:0x0081, B:29:0x0087, B:36:0x00ba, B:44:0x00dd), top: B:59:0x0081 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b7, code lost:
    
        if (r15 == r1) goto L52;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r13v0, types: [io.ktor.utils.io.ByteReadChannel] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v15, types: [long] */
    /* JADX WARN: Type inference failed for: r13v2, types: [long] */
    /* JADX WARN: Type inference failed for: r13v24 */
    /* JADX WARN: Type inference failed for: r13v25 */
    /* JADX WARN: Type inference failed for: r13v26 */
    /* JADX WARN: Type inference failed for: r13v27 */
    /* JADX WARN: Type inference failed for: r13v28 */
    /* JADX WARN: Type inference failed for: r13v5, types: [long] */
    /* JADX WARN: Type inference failed for: r13v6, types: [io.ktor.utils.io.ByteReadChannel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r14v1, types: [io.ktor.utils.io.ByteWriteChannel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v2, types: [io.ktor.utils.io.ByteWriteChannel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r7v1, types: [io.ktor.utils.io.ByteReadChannel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [io.ktor.utils.io.ByteReadChannel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v4, types: [long] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00b7 -> B:20:0x0066). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object copyAndClose(io.ktor.utils.io.ByteReadChannel r13, io.ktor.utils.io.ByteWriteChannel r14, kotlin.coroutines.Continuation<? super java.lang.Long> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.copyAndClose(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0086 A[Catch: all -> 0x00d6, TRY_LEAVE, TryCatch #1 {all -> 0x00d6, blocks: (B:27:0x0080, B:29:0x0086), top: B:54:0x0080 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:36:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:39:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b6, code lost:
    
        if (r15 == r1) goto L49;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r13v0, types: [io.ktor.utils.io.ByteReadChannel] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v15, types: [long] */
    /* JADX WARN: Type inference failed for: r13v2, types: [long] */
    /* JADX WARN: Type inference failed for: r13v24 */
    /* JADX WARN: Type inference failed for: r13v25 */
    /* JADX WARN: Type inference failed for: r13v26 */
    /* JADX WARN: Type inference failed for: r13v27 */
    /* JADX WARN: Type inference failed for: r13v28 */
    /* JADX WARN: Type inference failed for: r13v5, types: [long] */
    /* JADX WARN: Type inference failed for: r13v6, types: [io.ktor.utils.io.ByteReadChannel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r14v1, types: [io.ktor.utils.io.ByteWriteChannel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v2, types: [io.ktor.utils.io.ByteWriteChannel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r7v1, types: [io.ktor.utils.io.ByteReadChannel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [io.ktor.utils.io.ByteReadChannel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v4, types: [long] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7, types: [long] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00b6 -> B:20:0x0066). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object copyTo(io.ktor.utils.io.ByteReadChannel r13, io.ktor.utils.io.ByteWriteChannel r14, kotlin.coroutines.Continuation<? super java.lang.Long> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.copyTo(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0059 -> B:40:0x0078). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x006e -> B:29:0x0073). Please report as a decompilation issue!!! */
    public static final Object readTo(ByteReadChannel byteReadChannel, RawSink rawSink, long j, Continuation<? super Long> continuation) throws Throwable {
        C10811 c10811;
        long j2;
        Throwable th;
        if (continuation instanceof C10811) {
            c10811 = (C10811) continuation;
            if ((c10811.label & Integer.MIN_VALUE) != 0) {
                c10811.label -= Integer.MIN_VALUE;
            } else {
                c10811 = new C10811(continuation);
            }
        } else {
            c10811 = new C10811(continuation);
        }
        Object obj = c10811.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10811.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            j2 = j;
            if (byteReadChannel.isClosedForRead()) {
            }
            rethrowCloseCauseIfNeeded(byteReadChannel);
            return Boxing.boxLong(j2 - j);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        long j3 = c10811.J$1;
        long j4 = c10811.J$0;
        RawSink rawSink2 = (RawSink) c10811.L$1;
        ByteReadChannel byteReadChannel2 = (ByteReadChannel) c10811.L$0;
        try {
            ResultKt.throwOnFailure(obj);
            try {
                long j5 = j3;
                byteReadChannel = byteReadChannel2;
                j2 = j4;
                j = j5;
                rawSink = rawSink2;
                long jMin = Math.min(j, ByteReadPacketKt.getRemaining(byteReadChannel.getReadBuffer()));
                byteReadChannel.getReadBuffer().readTo(rawSink, jMin);
                j -= jMin;
                rawSink.flush();
                if (byteReadChannel.isClosedForRead() && j > 0) {
                    if (byteReadChannel.getReadBuffer().exhausted()) {
                        c10811.L$0 = byteReadChannel;
                        c10811.L$1 = rawSink;
                        c10811.J$0 = j2;
                        c10811.J$1 = j;
                        c10811.label = 1;
                        if (ByteReadChannel.awaitContent$default(byteReadChannel, 0, c10811, 1, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        rawSink2 = rawSink;
                        long j6 = j2;
                        byteReadChannel2 = byteReadChannel;
                        j3 = j;
                        j4 = j6;
                        long j7 = j3;
                        byteReadChannel = byteReadChannel2;
                        j2 = j4;
                        j = j7;
                        rawSink = rawSink2;
                    }
                    long jMin2 = Math.min(j, ByteReadPacketKt.getRemaining(byteReadChannel.getReadBuffer()));
                    byteReadChannel.getReadBuffer().readTo(rawSink, jMin2);
                    j -= jMin2;
                    rawSink.flush();
                    if (byteReadChannel.isClosedForRead()) {
                    }
                    rethrowCloseCauseIfNeeded(byteReadChannel);
                    return Boxing.boxLong(j2 - j);
                }
                rethrowCloseCauseIfNeeded(byteReadChannel);
                return Boxing.boxLong(j2 - j);
            } catch (Throwable th2) {
                byteReadChannel2 = byteReadChannel;
                rawSink2 = rawSink;
                th = th2;
                byteReadChannel2.cancel(th);
                rawSink2.close();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            byteReadChannel2.cancel(th);
            rawSink2.close();
            throw th;
        }
    }

    public static /* synthetic */ Object readTo$default(ByteReadChannel byteReadChannel, RawSink rawSink, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Long.MAX_VALUE;
        }
        return readTo(byteReadChannel, rawSink, j, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:43:0x0109  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ba, code lost:
    
        if (io.ktor.utils.io.ByteReadChannel.awaitContent$default(r1, 0, r12, 1, null) == r2) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ed, code lost:
    
        if (r0 == r2) goto L53;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v2, types: [io.ktor.utils.io.ByteWriteChannel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [io.ktor.utils.io.ByteWriteChannel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v5, types: [io.ktor.utils.io.ByteWriteChannel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00ed -> B:20:0x0070). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object copyTo(io.ktor.utils.io.ByteReadChannel r17, io.ktor.utils.io.ByteWriteChannel r18, long r19, kotlin.coroutines.Continuation<? super java.lang.Long> r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.copyTo(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0060  */
    /* JADX WARN: Code duplicated, block: B:20:0x007a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x007b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x007b -> B:12:0x0042). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object readByteArray(io.ktor.utils.io.ByteReadChannel r8, int r9, kotlin.coroutines.Continuation<? super byte[]> r10) {
        /*
            boolean r0 = r10 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C10691
            if (r0 == 0) goto L14
            r0 = r10
            io.ktor.utils.io.ByteReadChannelOperationsKt$readByteArray$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C10691) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            io.ktor.utils.io.ByteReadChannelOperationsKt$readByteArray$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$readByteArray$1
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L4c
            if (r2 != r3) goto L44
            int r8 = r0.I$2
            int r9 = r0.I$1
            int r2 = r0.I$0
            java.lang.Object r4 = r0.L$2
            kotlinx.io.Sink r4 = (kotlinx.io.Sink) r4
            java.lang.Object r5 = r0.L$1
            kotlinx.io.Buffer r5 = (kotlinx.io.Buffer) r5
            java.lang.Object r6 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r6 = (io.ktor.utils.io.ByteReadChannel) r6
            kotlin.ResultKt.throwOnFailure(r10)
            r7 = r5
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r0
            r0 = r9
            r9 = r2
        L42:
            r2 = r7
            goto L82
        L44:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L4c:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlinx.io.Buffer r10 = new kotlinx.io.Buffer
            r10.<init>()
            r2 = r10
            kotlinx.io.Sink r2 = (kotlinx.io.Sink) r2
            r4 = 0
            r5 = r10
            r10 = r4
        L5a:
            int r6 = io.ktor.utils.io.core.BytePacketBuilderKt.getSize(r2)
            if (r6 >= r9) goto L8d
            int r6 = io.ktor.utils.io.core.BytePacketBuilderKt.getSize(r2)
            int r6 = r9 - r6
            r0.L$0 = r8
            r0.L$1 = r5
            r0.L$2 = r2
            r0.I$0 = r9
            r0.I$1 = r10
            r0.I$2 = r4
            r0.label = r3
            java.lang.Object r6 = readPacket(r8, r6, r0)
            if (r6 != r1) goto L7b
            return r1
        L7b:
            r7 = r0
            r0 = r10
            r10 = r6
            r6 = r5
            r5 = r4
            r4 = r2
            goto L42
        L82:
            kotlinx.io.Source r10 = (kotlinx.io.Source) r10
            io.ktor.utils.io.core.BytePacketBuilderKt.writePacket(r4, r10)
            r10 = r0
            r0 = r2
            r2 = r4
            r4 = r5
            r5 = r6
            goto L5a
        L8d:
            kotlinx.io.Source r5 = (kotlinx.io.Source) r5
            byte[] r8 = kotlinx.io.SourcesKt.readByteArray(r5)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.readByteArray(io.ktor.utils.io.ByteReadChannel, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object readRemaining(ByteReadChannel byteReadChannel, Continuation<? super Source> continuation) throws Throwable {
        C10781 c10781;
        Sink sinkBytePacketBuilder;
        if (continuation instanceof C10781) {
            c10781 = (C10781) continuation;
            if ((c10781.label & Integer.MIN_VALUE) != 0) {
                c10781.label -= Integer.MIN_VALUE;
            } else {
                c10781 = new C10781(continuation);
            }
        } else {
            c10781 = new C10781(continuation);
        }
        Object obj = c10781.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10781.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            sinkBytePacketBuilder = BytePacketBuilderKt.BytePacketBuilder();
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Sink sink = (Sink) c10781.L$1;
            ByteReadChannel byteReadChannel2 = (ByteReadChannel) c10781.L$0;
            ResultKt.throwOnFailure(obj);
            sinkBytePacketBuilder = sink;
            byteReadChannel = byteReadChannel2;
        }
        while (!byteReadChannel.isClosedForRead()) {
            sinkBytePacketBuilder.transferFrom(byteReadChannel.getReadBuffer());
            c10781.L$0 = byteReadChannel;
            c10781.L$1 = sinkBytePacketBuilder;
            c10781.label = 1;
            if (ByteReadChannel.awaitContent$default(byteReadChannel, 0, c10781, 1, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        rethrowCloseCauseIfNeeded(byteReadChannel);
        return sinkBytePacketBuilder.getBufferField();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object readRemaining(ByteReadChannel byteReadChannel, long j, Continuation<? super Source> continuation) {
        C10792 c10792;
        Sink sinkBytePacketBuilder;
        long j2;
        if (continuation instanceof C10792) {
            c10792 = (C10792) continuation;
            if ((c10792.label & Integer.MIN_VALUE) != 0) {
                c10792.label -= Integer.MIN_VALUE;
            } else {
                c10792 = new C10792(continuation);
            }
        } else {
            c10792 = new C10792(continuation);
        }
        Object obj = c10792.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10792.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            sinkBytePacketBuilder = BytePacketBuilderKt.BytePacketBuilder();
            j2 = j;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j3 = c10792.J$1;
            j2 = c10792.J$0;
            Sink sink = (Sink) c10792.L$1;
            ByteReadChannel byteReadChannel2 = (ByteReadChannel) c10792.L$0;
            ResultKt.throwOnFailure(obj);
            sinkBytePacketBuilder = sink;
            j = j3;
            byteReadChannel = byteReadChannel2;
        }
        while (!byteReadChannel.isClosedForRead()) {
            long remaining = 0;
            if (j <= 0) {
                break;
            }
            if (j >= ByteReadPacketKt.getRemaining(byteReadChannel.getReadBuffer())) {
                remaining = j - ByteReadPacketKt.getRemaining(byteReadChannel.getReadBuffer());
                Boxing.boxLong(byteReadChannel.getReadBuffer().transferTo(sinkBytePacketBuilder));
            } else {
                byteReadChannel.getReadBuffer().readTo(sinkBytePacketBuilder, j);
            }
            c10792.L$0 = byteReadChannel;
            c10792.L$1 = sinkBytePacketBuilder;
            c10792.J$0 = j2;
            c10792.J$1 = remaining;
            c10792.label = 1;
            if (ByteReadChannel.awaitContent$default(byteReadChannel, 0, c10792, 1, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
            j = remaining;
        }
        return sinkBytePacketBuilder.getBufferField();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object readAvailable(ByteReadChannel byteReadChannel, byte[] bArr, int i, int i2, Continuation<? super Integer> continuation) {
        C10661 c10661;
        if (continuation instanceof C10661) {
            c10661 = (C10661) continuation;
            if ((c10661.label & Integer.MIN_VALUE) != 0) {
                c10661.label -= Integer.MIN_VALUE;
            } else {
                c10661 = new C10661(continuation);
            }
        } else {
            c10661 = new C10661(continuation);
        }
        Object obj = c10661.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c10661.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            if (byteReadChannel.isClosedForRead()) {
                return Boxing.boxInt(-1);
            }
            if (byteReadChannel.getReadBuffer().exhausted()) {
                c10661.L$0 = byteReadChannel;
                c10661.L$1 = bArr;
                c10661.I$0 = i;
                c10661.I$1 = i2;
                c10661.label = 1;
                if (ByteReadChannel.awaitContent$default(byteReadChannel, 0, c10661, 1, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i4 = c10661.I$1;
            int i5 = c10661.I$0;
            byte[] bArr2 = (byte[]) c10661.L$1;
            ByteReadChannel byteReadChannel2 = (ByteReadChannel) c10661.L$0;
            ResultKt.throwOnFailure(obj);
            i2 = i4;
            byteReadChannel = byteReadChannel2;
            i = i5;
            bArr = bArr2;
        }
        return byteReadChannel.isClosedForRead() ? Boxing.boxInt(-1) : Boxing.boxInt(InputKt.readAvailable(byteReadChannel.getReadBuffer(), bArr, i, i2));
    }

    public static /* synthetic */ Object readAvailable$default(ByteReadChannel byteReadChannel, byte[] bArr, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length - i;
        }
        return readAvailable(byteReadChannel, bArr, i, i2, continuation);
    }

    public static final int readAvailable(ByteReadChannel byteReadChannel, int i, Function1<? super Buffer, Integer> block) {
        Intrinsics.checkNotNullParameter(byteReadChannel, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if (i <= 0) {
            throw new IllegalArgumentException("min should be positive".toString());
        }
        if (i > 1048576) {
            throw new IllegalArgumentException(("Min(" + i + ") shouldn't be greater than 1048576").toString());
        }
        if (getAvailableForRead(byteReadChannel) < i) {
            return -1;
        }
        return block.invoke(byteReadChannel.getReadBuffer().getBufferField()).intValue();
    }

    public static /* synthetic */ ReaderJob reader$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return reader(coroutineScope, coroutineContext, z, (Function2<? super ReaderScope, ? super Continuation<? super Unit>, ? extends Object>) function2);
    }

    public static final ReaderJob reader(CoroutineScope coroutineScope, CoroutineContext coroutineContext, boolean z, Function2<? super ReaderScope, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(block, "block");
        return reader(coroutineScope, coroutineContext, new ByteChannel(false, 1, null), block);
    }

    public static final ReaderJob reader(CoroutineScope coroutineScope, CoroutineContext coroutineContext, final ByteChannel channel, Function2<? super ReaderScope, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(block, "block");
        Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, coroutineContext, null, new ByteReadChannelOperationsKt$reader$job$1(block, channel, null), 2, null);
        jobLaunch$default.invokeOnCompletion(new Function1() { // from class: io.ktor.utils.io.ByteReadChannelOperationsKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ByteReadChannelOperationsKt.reader$lambda$0$0(channel, (Throwable) obj);
            }
        });
        return new ReaderJob(CloseHookByteWriteChannelKt.onClose(channel, new C10841(jobLaunch$default, null)), jobLaunch$default);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reader$lambda$0$0(ByteChannel byteChannel, Throwable th) {
        if (th != null && !byteChannel.isClosedForRead()) {
            byteChannel.cancel(th);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$reader$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt$reader$1", f = "ByteReadChannelOperations.kt", i = {}, l = {368}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C10841 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Job $job;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10841(Job job, Continuation<? super C10841> continuation) {
            super(1, continuation);
            this.$job = job;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C10841(this.$job, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C10841) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.$job.join(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0050  */
    /* JADX WARN: Code duplicated, block: B:19:0x005a  */
    /* JADX WARN: Code duplicated, block: B:21:0x006a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x006b  */
    /* JADX WARN: Code duplicated, block: B:24:0x006f A[PHI: r11 r12 r13
      0x006f: PHI (r11v5 io.ktor.utils.io.ByteReadChannel) = (r11v3 io.ktor.utils.io.ByteReadChannel), (r11v7 io.ktor.utils.io.ByteReadChannel) binds: [B:18:0x0058, B:23:0x006d] A[DONT_GENERATE, DONT_INLINE]
      0x006f: PHI (r12v7 kotlinx.io.Buffer) = (r12v6 kotlinx.io.Buffer), (r12v8 kotlinx.io.Buffer) binds: [B:18:0x0058, B:23:0x006d] A[DONT_GENERATE, DONT_INLINE]
      0x006f: PHI (r13v7 int) = (r13v6 int), (r13v8 int) binds: [B:18:0x0058, B:23:0x006d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:26:0x0075  */
    /* JADX WARN: Code duplicated, block: B:28:0x0088  */
    /* JADX WARN: Code duplicated, block: B:29:0x0098  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0058 -> B:24:0x006f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x006b -> B:23:0x006d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object readPacket(io.ktor.utils.io.ByteReadChannel r11, int r12, kotlin.coroutines.Continuation<? super kotlinx.io.Source> r13) {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.readPacket(io.ktor.utils.io.ByteReadChannel, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object discardExact(ByteReadChannel byteReadChannel, long j, Continuation<? super Unit> continuation) throws EOFException {
        C10611 c10611;
        if (continuation instanceof C10611) {
            c10611 = (C10611) continuation;
            if ((c10611.label & Integer.MIN_VALUE) != 0) {
                c10611.label -= Integer.MIN_VALUE;
            } else {
                c10611 = new C10611(continuation);
            }
        } else {
            c10611 = new C10611(continuation);
        }
        Object objDiscard = c10611.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10611.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objDiscard);
            c10611.L$0 = SpillingKt.nullOutSpilledVariable(byteReadChannel);
            c10611.J$0 = j;
            c10611.label = 1;
            objDiscard = discard(byteReadChannel, j, c10611);
            if (objDiscard == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = c10611.J$0;
            ResultKt.throwOnFailure(objDiscard);
        }
        if (((Number) objDiscard).longValue() < j) {
            throw new EOFException("Unable to discard " + j + " bytes");
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0044  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x004e -> B:26:0x0067). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0061 -> B:25:0x0064). Please report as a decompilation issue!!! */
    public static final Object discard(ByteReadChannel byteReadChannel, long j, Continuation<? super Long> continuation) throws EOFException {
        C10601 c10601;
        long j2;
        ByteReadChannel byteReadChannel2;
        long j3;
        if (continuation instanceof C10601) {
            c10601 = (C10601) continuation;
            if ((c10601.label & Integer.MIN_VALUE) != 0) {
                c10601.label -= Integer.MIN_VALUE;
            } else {
                c10601 = new C10601(continuation);
            }
        } else {
            c10601 = new C10601(continuation);
        }
        Object obj = c10601.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10601.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            j2 = j;
            if (j <= 0 && !byteReadChannel.isClosedForRead()) {
                if (getAvailableForRead(byteReadChannel) == 0) {
                    c10601.L$0 = byteReadChannel;
                    c10601.J$0 = j2;
                    c10601.J$1 = j;
                    c10601.label = 1;
                    if (ByteReadChannel.awaitContent$default(byteReadChannel, 0, c10601, 1, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    byteReadChannel2 = byteReadChannel;
                    j3 = j;
                }
                long jMin = Math.min(j, ByteReadPacketKt.getRemaining(byteReadChannel.getReadBuffer()));
                ByteReadPacketKt.discard(byteReadChannel.getReadBuffer(), jMin);
                j -= jMin;
                if (j <= 0) {
                }
                return Boxing.boxLong(j2 - j);
            }
            return Boxing.boxLong(j2 - j);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        j3 = c10601.J$1;
        j2 = c10601.J$0;
        byteReadChannel2 = (ByteReadChannel) c10601.L$0;
        ResultKt.throwOnFailure(obj);
        long j4 = j3;
        byteReadChannel = byteReadChannel2;
        j = j4;
        long jMin2 = Math.min(j, ByteReadPacketKt.getRemaining(byteReadChannel.getReadBuffer()));
        ByteReadPacketKt.discard(byteReadChannel.getReadBuffer(), jMin2);
        j -= jMin2;
        if (j <= 0) {
        }
        return Boxing.boxLong(j2 - j);
    }

    public static /* synthetic */ Object discard$default(ByteReadChannel byteReadChannel, long j, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Long.MAX_VALUE;
        }
        return discard(byteReadChannel, j, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Deprecated(message = "Use readLineStrict or readLine instead. See deprecation notes for more details.")
    public static final Object readUTF8Line(ByteReadChannel byteReadChannel, int i, Continuation<? super String> continuation) {
        C10821 c10821;
        StringBuilder sb;
        if (continuation instanceof C10821) {
            c10821 = (C10821) continuation;
            if ((c10821.label & Integer.MIN_VALUE) != 0) {
                c10821.label -= Integer.MIN_VALUE;
            } else {
                c10821 = new C10821(continuation);
            }
        } else {
            c10821 = new C10821(continuation);
        }
        Object obj = c10821.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c10821.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            StringBuilder sb2 = new StringBuilder();
            c10821.L$0 = SpillingKt.nullOutSpilledVariable(byteReadChannel);
            c10821.L$1 = sb2;
            c10821.I$0 = i;
            c10821.label = 1;
            Object uTF8LineTo = readUTF8LineTo(byteReadChannel, sb2, i, c10821);
            if (uTF8LineTo == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = uTF8LineTo;
            sb = sb2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i3 = c10821.I$0;
            sb = (StringBuilder) c10821.L$1;
            ResultKt.throwOnFailure(obj);
        }
        if (((Boolean) obj).booleanValue()) {
            return sb.toString();
        }
        return null;
    }

    public static /* synthetic */ Object readUTF8Line$default(ByteReadChannel byteReadChannel, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readUTF8Line(byteReadChannel, i, continuation);
    }

    public static /* synthetic */ Object readUTF8LineTo$default(ByteReadChannel byteReadChannel, Appendable appendable, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readUTF8LineTo(byteReadChannel, appendable, i, continuation);
    }

    @Deprecated(message = "Use readLineStrictTo or readLineTo instead. See deprecation notes for more details.")
    public static final Object readUTF8LineTo(ByteReadChannel byteReadChannel, Appendable appendable, int i, Continuation<? super Boolean> continuation) {
        return m12644readUTF8LineToRRvyBJ8(byteReadChannel, appendable, i, LineEndingMode.INSTANCE.m12655getAnyf0jXZW8(), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Deprecated(message = "Use readLineStrictTo instead.")
    /* JADX INFO: renamed from: readUTF8LineTo-RRvyBJ8, reason: not valid java name */
    public static final Object m12644readUTF8LineToRRvyBJ8(ByteReadChannel byteReadChannel, Appendable appendable, int i, int i2, Continuation<? super Boolean> continuation) throws EOFException {
        C10832 c10832;
        if (continuation instanceof C10832) {
            c10832 = (C10832) continuation;
            if ((c10832.label & Integer.MIN_VALUE) != 0) {
                c10832.label -= Integer.MIN_VALUE;
            } else {
                c10832 = new C10832(continuation);
            }
        } else {
            c10832 = new C10832(continuation);
        }
        C10832 c10833 = c10832;
        Object lineStrictTo = c10833.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c10833.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(lineStrictTo);
                long j = i;
                LineEnding lineEnding = LineEndingMode.m12648containslTjpP64(i2, LineEndingMode.INSTANCE.m12656getCRf0jXZW8()) ? LineEnding.Lenient : LineEnding.Default;
                c10833.L$0 = SpillingKt.nullOutSpilledVariable(byteReadChannel);
                c10833.L$1 = SpillingKt.nullOutSpilledVariable(appendable);
                c10833.I$0 = i;
                c10833.I$1 = i2;
                c10833.label = 1;
                lineStrictTo = readLineStrictTo(byteReadChannel, appendable, j, lineEnding, c10833);
                if (lineStrictTo == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i4 = c10833.I$1;
                int i5 = c10833.I$0;
                ResultKt.throwOnFailure(lineStrictTo);
            }
            return Boxing.boxBoolean(((Number) lineStrictTo).longValue() >= 0);
        } catch (EOFException e) {
            String message = e.getMessage();
            if (message == null || !StringsKt.startsWith$default(message, "Unexpected end of stream after reading", false, 2, (Object) null)) {
                throw e;
            }
            return Boxing.boxBoolean(true);
        }
    }

    /* JADX INFO: renamed from: readUTF8LineTo-RRvyBJ8$default, reason: not valid java name */
    public static /* synthetic */ Object m12645readUTF8LineToRRvyBJ8$default(ByteReadChannel byteReadChannel, Appendable appendable, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        if ((i3 & 4) != 0) {
            i2 = LineEndingMode.INSTANCE.m12655getAnyf0jXZW8();
        }
        return m12644readUTF8LineToRRvyBJ8(byteReadChannel, appendable, i, i2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object readLine(ByteReadChannel byteReadChannel, LineEnding lineEnding, Continuation<? super String> continuation) {
        C10741 c10741;
        StringBuilder sb;
        if (continuation instanceof C10741) {
            c10741 = (C10741) continuation;
            if ((c10741.label & Integer.MIN_VALUE) != 0) {
                c10741.label -= Integer.MIN_VALUE;
            } else {
                c10741 = new C10741(continuation);
            }
        } else {
            c10741 = new C10741(continuation);
        }
        Object obj = c10741.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10741.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StringBuilder sb2 = new StringBuilder();
            c10741.L$0 = SpillingKt.nullOutSpilledVariable(byteReadChannel);
            c10741.L$1 = SpillingKt.nullOutSpilledVariable(lineEnding);
            c10741.L$2 = sb2;
            c10741.label = 1;
            Object lineTo = readLineTo(byteReadChannel, sb2, lineEnding, c10741);
            if (lineTo == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = lineTo;
            sb = sb2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            sb = (StringBuilder) c10741.L$2;
            ResultKt.throwOnFailure(obj);
        }
        if (((Number) obj).longValue() >= 0) {
            return sb.toString();
        }
        return null;
    }

    public static /* synthetic */ Object readLine$default(ByteReadChannel byteReadChannel, LineEnding lineEnding, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            lineEnding = LineEnding.Default;
        }
        return readLine(byteReadChannel, lineEnding, continuation);
    }

    public static /* synthetic */ Object readLineTo$default(ByteReadChannel byteReadChannel, Appendable appendable, LineEnding lineEnding, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            lineEnding = LineEnding.Default;
        }
        return readLineTo(byteReadChannel, appendable, lineEnding, continuation);
    }

    public static final Object readLineTo(ByteReadChannel byteReadChannel, Appendable appendable, LineEnding lineEnding, Continuation<? super Long> continuation) {
        return internalReadLineTo(byteReadChannel, appendable, Long.MAX_VALUE, lineEnding == LineEnding.Lenient, false, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object readLineStrict(ByteReadChannel byteReadChannel, long j, LineEnding lineEnding, Continuation<? super String> continuation) {
        C10751 c10751;
        StringBuilder sb;
        if (continuation instanceof C10751) {
            c10751 = (C10751) continuation;
            if ((c10751.label & Integer.MIN_VALUE) != 0) {
                c10751.label -= Integer.MIN_VALUE;
            } else {
                c10751 = new C10751(continuation);
            }
        } else {
            c10751 = new C10751(continuation);
        }
        C10751 c10752 = c10751;
        Object obj = c10752.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10752.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StringBuilder sb2 = new StringBuilder();
            c10752.L$0 = SpillingKt.nullOutSpilledVariable(byteReadChannel);
            c10752.L$1 = SpillingKt.nullOutSpilledVariable(lineEnding);
            c10752.L$2 = sb2;
            c10752.J$0 = j;
            c10752.label = 1;
            Object lineStrictTo = readLineStrictTo(byteReadChannel, sb2, j, lineEnding, c10752);
            if (lineStrictTo == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = lineStrictTo;
            sb = sb2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j2 = c10752.J$0;
            sb = (StringBuilder) c10752.L$2;
            ResultKt.throwOnFailure(obj);
        }
        if (((Number) obj).longValue() >= 0) {
            return sb.toString();
        }
        return null;
    }

    public static /* synthetic */ Object readLineStrict$default(ByteReadChannel byteReadChannel, long j, LineEnding lineEnding, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Long.MAX_VALUE;
        }
        if ((i & 2) != 0) {
            lineEnding = LineEnding.Default;
        }
        return readLineStrict(byteReadChannel, j, lineEnding, continuation);
    }

    public static /* synthetic */ Object readLineStrictTo$default(ByteReadChannel byteReadChannel, Appendable appendable, long j, LineEnding lineEnding, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Long.MAX_VALUE;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            lineEnding = LineEnding.Default;
        }
        return readLineStrictTo(byteReadChannel, appendable, j2, lineEnding, continuation);
    }

    public static final Object readLineStrictTo(ByteReadChannel byteReadChannel, Appendable appendable, long j, LineEnding lineEnding, Continuation<? super Long> continuation) {
        if (j < 0) {
            throw new IllegalArgumentException(("Limit (" + j + ") should be non-negative").toString());
        }
        return internalReadLineTo(byteReadChannel, appendable, j, lineEnding == LineEnding.Lenient, true, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to calculate best type for var: r19v10 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r19v10 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r19v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r19v4 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r19v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r19v5 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r19v6 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r19v6 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r19v7 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r19v7 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r19v9 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r19v9 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x029b -> B:72:0x02a3). Please report as a decompilation issue!!! */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r19v2 ??, new type: long
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException
        */
    public static final java.lang.Object internalReadLineTo(io.ktor.utils.io.ByteReadChannel r35, java.lang.Appendable r36, long r37, boolean r39, boolean r40, kotlin.coroutines.Continuation<? super java.lang.Long> r41) {
        /*
            Method dump skipped, instruction units count: 977
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.internalReadLineTo(io.ktor.utils.io.ByteReadChannel, java.lang.Appendable, long, boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final void internalReadLineTo$transferString(Source source, Appendable appendable, Ref.LongRef longRef, long j) throws IOException {
        if (j > 0) {
            String string = Utf8Kt.readString(source, j);
            appendable.append(string);
            longRef.element += (long) string.length();
        }
    }

    private static final long internalReadLineTo$scanForSoleCr(Source source, boolean z, long j, long j2) {
        long jMin;
        long j3;
        if (!z) {
            return -1L;
        }
        if (j == -1) {
            jMin = Math.min(j2, ByteReadPacketKt.getRemaining(source) - 1);
        } else {
            if (j == 0) {
                j3 = 0;
            } else {
                jMin = j - 1;
            }
            return SourcesKt.indexOf$default(source, (byte) 13, 0L, j3, 2, null);
        }
        j3 = jMin;
        return SourcesKt.indexOf$default(source, (byte) 13, 0L, j3, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:21:0x0067 A[PHI: r10 r12
      0x0067: PHI (r10v5 kotlinx.io.Source) = (r10v0 kotlinx.io.Source), (r10v7 kotlinx.io.Source) binds: [B:15:0x0049, B:20:0x0065] A[DONT_GENERATE, DONT_INLINE]
      0x0067: PHI (r12v2 boolean) = (r12v0 boolean), (r12v3 boolean) binds: [B:15:0x0049, B:20:0x0065] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:23:0x0073  */
    /* JADX WARN: Code duplicated, block: B:26:0x007d  */
    /* JADX WARN: Code duplicated, block: B:28:0x0085  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object internalReadLineTo$discardCrlfOrCr(Source source, ByteReadChannel byteReadChannel, boolean z, Continuation<? super Boolean> continuation) throws EOFException {
        ByteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1 byteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1;
        if (continuation instanceof ByteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1) {
            byteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1 = (ByteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1) continuation;
            if ((byteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1.label & Integer.MIN_VALUE) != 0) {
                byteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1.label -= Integer.MIN_VALUE;
            } else {
                byteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1 = new ByteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1(continuation);
            }
        } else {
            byteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1 = new ByteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1(continuation);
        }
        Object objAwaitContent = byteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = byteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwaitContent);
            if (ByteReadPacketKt.getRemaining(source) < 2) {
                byteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1.L$0 = source;
                byteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1.L$1 = SpillingKt.nullOutSpilledVariable(byteReadChannel);
                byteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1.Z$0 = z;
                byteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1.label = 1;
                objAwaitContent = byteReadChannel.awaitContent(2, byteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1);
                if (objAwaitContent == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (source.getBufferField().get(1L) == 10) {
                ByteReadPacketKt.discard(source, 2L);
                return Boxing.boxBoolean(true);
            }
            if (z) {
                ByteReadPacketKt.discard(source, 1L);
                return Boxing.boxBoolean(true);
            }
            return Boxing.boxBoolean(false);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        z = byteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1.Z$0;
        source = (Source) byteReadChannelOperationsKt$internalReadLineTo$discardCrlfOrCr$1.L$0;
        ResultKt.throwOnFailure(objAwaitContent);
        if (((Boolean) objAwaitContent).booleanValue()) {
            if (source.getBufferField().get(1L) == 10) {
                ByteReadPacketKt.discard(source, 2L);
                return Boxing.boxBoolean(true);
            }
        }
        if (z) {
            ByteReadPacketKt.discard(source, 1L);
            return Boxing.boxBoolean(true);
        }
        return Boxing.boxBoolean(false);
    }

    private static final Void throwTooLongLineException(long j) throws TooLongLineException {
        throw new TooLongLineException("Line exceeds limit of " + j + " characters");
    }

    private static final Void throwEndOfStreamException(long j) throws EOFException {
        throw new EOFException("Unexpected end of stream after reading " + j + " characters");
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0121 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:40:0x0123  */
    /* JADX WARN: Code duplicated, block: B:42:0x0129  */
    /* JADX WARN: Code duplicated, block: B:43:0x012e  */
    /* JADX WARN: Code duplicated, block: B:45:0x0136  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x009e, code lost:
    
        if (io.ktor.utils.io.ByteReadChannel.awaitContent$default(r0, 0, r2, 1, null) == r3) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object read(io.ktor.utils.io.ByteReadChannel r16, kotlin.jvm.functions.Function4<? super byte[], ? super java.lang.Integer, ? super java.lang.Integer, ? super kotlin.coroutines.Continuation<? super java.lang.Integer>, ? extends java.lang.Object> r17, kotlin.coroutines.Continuation<? super java.lang.Integer> r18) throws java.io.EOFException {
        /*
            Method dump skipped, instruction units count: 337
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.read(io.ktor.utils.io.ByteReadChannel, kotlin.jvm.functions.Function4, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object read$$forInline(ByteReadChannel byteReadChannel, Function4<? super byte[], ? super Integer, ? super Integer, ? super Continuation<? super Integer>, ? extends Object> function4, Continuation<? super Integer> continuation) throws EOFException {
        if (byteReadChannel.isClosedForRead()) {
            return -1;
        }
        if (byteReadChannel.getReadBuffer().exhausted()) {
            ByteReadChannel.awaitContent$default(byteReadChannel, 0, continuation, 1, null);
        }
        if (byteReadChannel.isClosedForRead()) {
            return -1;
        }
        Ref.IntRef intRef = new Ref.IntRef();
        UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
        Buffer bufferField = byteReadChannel.getReadBuffer().getBufferField();
        if (bufferField.exhausted()) {
            throw new IllegalArgumentException("Buffer is empty".toString());
        }
        Segment head = bufferField.getHead();
        Intrinsics.checkNotNull(head);
        intRef.element = ((Number) function4.invoke(head.dataAsByteArray(true), Integer.valueOf(Integer.valueOf(head.getPos()).intValue()), Integer.valueOf(Integer.valueOf(head.getLimit()).intValue()), null)).intValue();
        int iIntValue = Integer.valueOf(intRef.element).intValue();
        if (iIntValue != 0) {
            if (iIntValue < 0) {
                throw new IllegalStateException("Returned negative read bytes count");
            }
            if (iIntValue > head.getSize()) {
                throw new IllegalStateException("Returned too many bytes");
            }
            bufferField.skip(iIntValue);
        }
        return Integer.valueOf(intRef.element);
    }

    public static final int getAvailableForRead(ByteReadChannel byteReadChannel) {
        Intrinsics.checkNotNullParameter(byteReadChannel, "<this>");
        return (int) byteReadChannel.getReadBuffer().getBufferField().getSizeMut();
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0058  */
    /* JADX WARN: Code duplicated, block: B:25:0x0062  */
    /* JADX WARN: Code duplicated, block: B:27:0x0076 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x0077  */
    /* JADX WARN: Code duplicated, block: B:32:0x0087  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0060 -> B:30:0x0081). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0077 -> B:29:0x007c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object readFully(io.ktor.utils.io.ByteReadChannel r7, byte[] r8, int r9, int r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            boolean r0 = r11 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C10721
            if (r0 == 0) goto L14
            r0 = r11
            io.ktor.utils.io.ByteReadChannelOperationsKt$readFully$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C10721) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            io.ktor.utils.io.ByteReadChannelOperationsKt$readFully$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$readFully$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "Channel is already closed"
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 != r4) goto L3a
            int r7 = r0.I$2
            int r8 = r0.I$1
            int r9 = r0.I$0
            java.lang.Object r10 = r0.L$1
            byte[] r10 = (byte[]) r10
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r2 = (io.ktor.utils.io.ByteReadChannel) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L7c
        L3a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L42:
            kotlin.ResultKt.throwOnFailure(r11)
            if (r10 <= r9) goto L54
            boolean r11 = r7.isClosedForRead()
            if (r11 != 0) goto L4e
            goto L54
        L4e:
            java.io.EOFException r7 = new java.io.EOFException
            r7.<init>(r3)
            throw r7
        L54:
            r11 = r10
            r10 = r9
        L56:
            if (r9 >= r11) goto La6
            kotlinx.io.Source r2 = r7.getReadBuffer()
            boolean r2 = r2.exhausted()
            if (r2 == 0) goto L81
            r0.L$0 = r7
            r0.L$1 = r8
            r0.I$0 = r10
            r0.I$1 = r11
            r0.I$2 = r9
            r0.label = r4
            r2 = 0
            r5 = 0
            java.lang.Object r2 = io.ktor.utils.io.ByteReadChannel.awaitContent$default(r7, r2, r0, r4, r5)
            if (r2 != r1) goto L77
            return r1
        L77:
            r2 = r7
            r7 = r9
            r9 = r10
            r10 = r8
            r8 = r11
        L7c:
            r11 = r8
            r8 = r10
            r10 = r9
            r9 = r7
            r7 = r2
        L81:
            boolean r2 = r7.isClosedForRead()
            if (r2 != 0) goto La0
            int r2 = r11 - r9
            kotlinx.io.Source r5 = r7.getReadBuffer()
            long r5 = io.ktor.utils.io.core.ByteReadPacketKt.getRemaining(r5)
            int r5 = (int) r5
            int r2 = java.lang.Math.min(r2, r5)
            kotlinx.io.Source r5 = r7.getReadBuffer()
            int r2 = r2 + r9
            kotlinx.io.SourcesKt.readTo(r5, r8, r9, r2)
            r9 = r2
            goto L56
        La0:
            java.io.EOFException r7 = new java.io.EOFException
            r7.<init>(r3)
            throw r7
        La6:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.readFully(io.ktor.utils.io.ByteReadChannel, byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object readFully$default(ByteReadChannel byteReadChannel, byte[] bArr, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return readFully(byteReadChannel, bArr, i, i2, continuation);
    }

    public static final void rethrowCloseCauseIfNeeded(ByteReadChannel byteReadChannel) throws Throwable {
        Intrinsics.checkNotNullParameter(byteReadChannel, "<this>");
        Throwable closedCause = byteReadChannel.getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
    }

    public static final void rethrowCloseCauseIfNeeded(ByteWriteChannel byteWriteChannel) throws Throwable {
        Intrinsics.checkNotNullParameter(byteWriteChannel, "<this>");
        Throwable closedCause = byteWriteChannel.getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
    }

    public static final void rethrowCloseCauseIfNeeded(ByteChannel byteChannel) {
        Intrinsics.checkNotNullParameter(byteChannel, "<this>");
        Throwable closedCause = byteChannel.getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
    }

    public static /* synthetic */ Object readUntil$default(ByteReadChannel byteReadChannel, ByteString byteString, ByteWriteChannel byteWriteChannel, long j, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            j = Long.MAX_VALUE;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            z = false;
        }
        return readUntil(byteReadChannel, byteString, byteWriteChannel, j2, z, continuation);
    }

    public static final Object readUntil(ByteReadChannel byteReadChannel, ByteString byteString, ByteWriteChannel byteWriteChannel, long j, boolean z, Continuation<? super Long> continuation) {
        return new ByteChannelScanner(byteReadChannel, byteString, byteWriteChannel, j).findNext$ktor_io(z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007b, code lost:
    
        if (discard(r7, r5, r0) == r1) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object skipIfFound(io.ktor.utils.io.ByteReadChannel r7, kotlinx.io.bytestring.ByteString r8, kotlin.coroutines.Continuation<? super java.lang.Boolean> r9) {
        /*
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C10851
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.utils.io.ByteReadChannelOperationsKt$skipIfFound$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C10851) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            io.ktor.utils.io.ByteReadChannelOperationsKt$skipIfFound$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$skipIfFound$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4a
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r7 = r0.L$1
            kotlinx.io.bytestring.ByteString r7 = (kotlinx.io.bytestring.ByteString) r7
            java.lang.Object r7 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r7 = (io.ktor.utils.io.ByteReadChannel) r7
            kotlin.ResultKt.throwOnFailure(r9)
            goto L7e
        L35:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3d:
            java.lang.Object r7 = r0.L$1
            r8 = r7
            kotlinx.io.bytestring.ByteString r8 = (kotlinx.io.bytestring.ByteString) r8
            java.lang.Object r7 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r7 = (io.ktor.utils.io.ByteReadChannel) r7
            kotlin.ResultKt.throwOnFailure(r9)
            goto L5e
        L4a:
            kotlin.ResultKt.throwOnFailure(r9)
            int r9 = r8.getSize()
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r9 = peek(r7, r9, r0)
            if (r9 != r1) goto L5e
            goto L7d
        L5e:
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r8)
            if (r9 == 0) goto L83
            int r9 = r8.getSize()
            long r5 = (long) r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$0 = r9
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r7 = discard(r7, r5, r0)
            if (r7 != r1) goto L7e
        L7d:
            return r1
        L7e:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r7
        L83:
            r7 = 0
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.skipIfFound(io.ktor.utils.io.ByteReadChannel, kotlinx.io.bytestring.ByteString, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object peek(ByteReadChannel byteReadChannel, int i, Continuation<? super ByteString> continuation) {
        C10641 c10641;
        if (continuation instanceof C10641) {
            c10641 = (C10641) continuation;
            if ((c10641.label & Integer.MIN_VALUE) != 0) {
                c10641.label -= Integer.MIN_VALUE;
            } else {
                c10641 = new C10641(continuation);
            }
        } else {
            c10641 = new C10641(continuation);
        }
        Object objAwaitContent = c10641.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c10641.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objAwaitContent);
            if (byteReadChannel.isClosedForRead()) {
                return null;
            }
            c10641.L$0 = byteReadChannel;
            c10641.I$0 = i;
            c10641.label = 1;
            objAwaitContent = byteReadChannel.awaitContent(i, c10641);
            if (objAwaitContent == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = c10641.I$0;
            byteReadChannel = (ByteReadChannel) c10641.L$0;
            ResultKt.throwOnFailure(objAwaitContent);
        }
        if (((Boolean) objAwaitContent).booleanValue()) {
            return ByteStringsKt.readByteString(byteReadChannel.getReadBuffer().peek(), i);
        }
        return null;
    }
}

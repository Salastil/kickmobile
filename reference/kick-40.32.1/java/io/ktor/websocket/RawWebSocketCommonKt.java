package io.ktor.websocket;

import androidx.collection.SieveCacheKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.muxer.WebmConstants;
import com.datadog.android.webview.WebViewTracking;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.core.ByteReadPacketKt;
import io.ktor.utils.io.core.MemoryKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Buffer;
import kotlinx.io.Source;

/* JADX INFO: compiled from: RawWebSocketCommon.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a;\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u001b\u0010\u0010\u001a\u00020\r*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a$\u0010\u0015\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u0006H\u0087@¢\u0006\u0004\b\u0015\u0010\u0016\u001a$\u0010\u0018\u001a\u00020\u0012*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000eH\u0087@¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "input", "Lio/ktor/utils/io/ByteWriteChannel;", "output", "", "maxFrameSize", "", "masking", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lio/ktor/websocket/WebSocketSession;", "RawWebSocket", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;JZLkotlin/coroutines/CoroutineContext;)Lio/ktor/websocket/WebSocketSession;", "Lkotlinx/io/Source;", "", "maskKey", WebViewTracking.SESSION_REPLAY_MASK_ALL_PRIVACY, "(Lkotlinx/io/Source;I)Lkotlinx/io/Source;", "Lio/ktor/websocket/Frame;", TypedValues.Attributes.S_FRAME, "", "writeFrame", "(Lio/ktor/utils/io/ByteWriteChannel;Lio/ktor/websocket/Frame;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lastOpcode", "readFrame", "(Lio/ktor/utils/io/ByteReadChannel;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-websockets"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class RawWebSocketCommonKt {

    /* JADX INFO: renamed from: io.ktor.websocket.RawWebSocketCommonKt$readFrame$1, reason: invalid class name */
    /* JADX INFO: compiled from: RawWebSocketCommon.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.RawWebSocketCommonKt", f = "RawWebSocketCommon.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, l = {252, 253, 272, 273, 281, 289}, m = "readFrame", n = {"$this$readFrame", "maxFrameSize", "lastOpcode", "$this$readFrame", "maxFrameSize", "lastOpcode", "flagsAndOpcode", "$this$readFrame", "frameType", "maxFrameSize", "lastOpcode", "flagsAndOpcode", "maskAndLength", "rawOpcode", "opcode", "fin", "length", "$this$readFrame", "frameType", "maxFrameSize", "lastOpcode", "flagsAndOpcode", "maskAndLength", "rawOpcode", "opcode", "fin", "length", "$this$readFrame", "frameType", "maxFrameSize", "lastOpcode", "flagsAndOpcode", "maskAndLength", "rawOpcode", "opcode", "fin", "length", "$this$readFrame", "frameType", "maxFrameSize", "lastOpcode", "flagsAndOpcode", "maskAndLength", "rawOpcode", "opcode", "fin", "length", "maskKey"}, s = {"L$0", "J$0", "I$0", "L$0", "J$0", "I$0", "B$0", "L$0", "L$1", "J$0", "I$0", "B$0", "B$1", "I$1", "I$2", "I$3", "I$4", "L$0", "L$1", "J$0", "I$0", "B$0", "B$1", "I$1", "I$2", "I$3", "I$4", "L$0", "L$1", "J$0", "I$0", "B$0", "B$1", "I$1", "I$2", "I$3", "J$1", "L$0", "L$1", "J$0", "I$0", "B$0", "B$1", "I$1", "I$2", "I$3", "J$1", "I$4"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        byte B$0;
        byte B$1;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        long J$0;
        long J$1;
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
            return RawWebSocketCommonKt.readFrame(null, 0L, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.websocket.RawWebSocketCommonKt$writeFrame$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RawWebSocketCommon.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.RawWebSocketCommonKt", f = "RawWebSocketCommon.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5}, l = {209, 219, 222, 223, WebmConstants.MkvEbmlElement.TIMESTAMP, 237}, m = "writeFrame", n = {"$this$writeFrame", TypedValues.Attributes.S_FRAME, "masking", "length", "flagsAndOpcode", "$this$writeFrame", TypedValues.Attributes.S_FRAME, "masking", "length", "flagsAndOpcode", "formattedLength", "maskAndLength", "$this$writeFrame", TypedValues.Attributes.S_FRAME, "masking", "length", "flagsAndOpcode", "formattedLength", "maskAndLength", "$this$writeFrame", TypedValues.Attributes.S_FRAME, "masking", "length", "flagsAndOpcode", "formattedLength", "maskAndLength", "$this$writeFrame", TypedValues.Attributes.S_FRAME, "data", "masking", "length", "flagsAndOpcode", "formattedLength", "maskAndLength", "maskKey", "$this$writeFrame", TypedValues.Attributes.S_FRAME, "data", "maskedData", "masking", "length", "flagsAndOpcode", "formattedLength", "maskAndLength"}, s = {"L$0", "L$1", "Z$0", "I$0", "I$1", "L$0", "L$1", "Z$0", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "Z$0", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "Z$0", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "Z$0", "I$0", "I$1", "I$2", "I$3", "I$4", "L$0", "L$1", "L$2", "L$3", "Z$0", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C11011 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C11011(Continuation<? super C11011> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RawWebSocketCommonKt.writeFrame(null, null, false, this);
        }
    }

    public static /* synthetic */ WebSocketSession RawWebSocket$default(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, boolean z, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 4) != 0) {
            j = SieveCacheKt.NodeLinkMask;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            z = false;
        }
        return RawWebSocket(byteReadChannel, byteWriteChannel, j2, z, coroutineContext);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final /* synthetic */ WebSocketSession RawWebSocket(ByteReadChannel input, ByteWriteChannel output, long j, boolean z, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        return RawWebSocketJvmKt.RawWebSocket(input, output, j, z, coroutineContext, WebSocketChannelsConfig.INSTANCE.getUNLIMITED());
    }

    private static final Source mask(final Source source, final int i) {
        return (Source) MemoryKt.withMemory(4, new Function1() { // from class: io.ktor.websocket.RawWebSocketCommonKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RawWebSocketCommonKt.mask$lambda$0(i, source, (byte[]) obj);
            }
        });
    }

    static final Source mask$lambda$0(int i, Source source, byte[] maskMemory) {
        Intrinsics.checkNotNullParameter(maskMemory, "maskMemory");
        MemoryKt.storeIntAt(maskMemory, 0, i);
        Buffer buffer = new Buffer();
        Buffer buffer2 = buffer;
        int remaining = (int) ByteReadPacketKt.getRemaining(source);
        for (int i2 = 0; i2 < remaining; i2++) {
            buffer2.writeByte((byte) (source.readByte() ^ maskMemory[i2 % 4]));
        }
        return buffer;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x010d  */
    /* JADX WARN: Code duplicated, block: B:39:0x010f  */
    /* JADX WARN: Code duplicated, block: B:41:0x0114  */
    /* JADX WARN: Code duplicated, block: B:42:0x0116  */
    /* JADX WARN: Code duplicated, block: B:45:0x011a  */
    /* JADX WARN: Code duplicated, block: B:49:0x0136  */
    /* JADX WARN: Code duplicated, block: B:51:0x0140 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x0142  */
    /* JADX WARN: Code duplicated, block: B:54:0x014a  */
    /* JADX WARN: Code duplicated, block: B:57:0x0164  */
    /* JADX WARN: Code duplicated, block: B:64:0x0192  */
    /* JADX WARN: Code duplicated, block: B:68:0x01c2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:69:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:75:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0160, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelOperationsKt.writeLong(r14, r11, r2) == r3) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x017a, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelOperationsKt.writeShort(r14, (short) r11, r2) == r3) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x017e, code lost:
    
        r7 = r8;
        r8 = r11;
        r9 = r12;
        r11 = r13;
        r12 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01b5, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelOperationsKt.writeInt(r12, r0, r2) == r3) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01ee, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelOperationsKt.writePacket(r12, r10, r2) == r3) goto L72;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object writeFrame(io.ktor.utils.io.ByteWriteChannel r17, io.ktor.websocket.Frame r18, boolean r19, kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
        /*
            Method dump skipped, instruction units count: 524
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.RawWebSocketCommonKt.writeFrame(io.ktor.utils.io.ByteWriteChannel, io.ktor.websocket.Frame, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0262  */
    /* JADX WARN: Code duplicated, block: B:103:0x0264  */
    /* JADX WARN: Code duplicated, block: B:106:0x0269  */
    /* JADX WARN: Code duplicated, block: B:107:0x026b  */
    /* JADX WARN: Code duplicated, block: B:110:0x0270  */
    /* JADX WARN: Code duplicated, block: B:111:0x0272  */
    /* JADX WARN: Code duplicated, block: B:116:0x027e  */
    /* JADX WARN: Code duplicated, block: B:118:0x0284  */
    /* JADX WARN: Code duplicated, block: B:24:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:27:0x010b A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:32:0x0118  */
    /* JADX WARN: Code duplicated, block: B:33:0x011a  */
    /* JADX WARN: Code duplicated, block: B:36:0x0123  */
    /* JADX WARN: Code duplicated, block: B:37:0x0125 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:45:0x013a  */
    /* JADX WARN: Code duplicated, block: B:46:0x013c  */
    /* JADX WARN: Code duplicated, block: B:49:0x0143 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:55:0x0154  */
    /* JADX WARN: Code duplicated, block: B:57:0x0158  */
    /* JADX WARN: Code duplicated, block: B:58:0x015a  */
    /* JADX WARN: Code duplicated, block: B:62:0x0180  */
    /* JADX WARN: Code duplicated, block: B:68:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:75:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:76:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:78:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:82:0x0207 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:83:0x0209  */
    /* JADX WARN: Code duplicated, block: B:86:0x0219  */
    /* JADX WARN: Code duplicated, block: B:95:0x024f  */
    /* JADX WARN: Code duplicated, block: B:98:0x0257  */
    /* JADX WARN: Code duplicated, block: B:99:0x0259  */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0175, code lost:
    
        if (r1 == r3) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x019b, code lost:
    
        if (r1 == r3) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01ef, code lost:
    
        if (r1 == r3) goto L90;
     */
    /* JADX WARN: Instruction removed from duplicated block: B:118:0x0284, please report this as an issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readFrame(io.ktor.utils.io.ByteReadChannel r20, long r21, int r23, kotlin.coroutines.Continuation<? super io.ktor.websocket.Frame> r24) throws io.ktor.websocket.FrameTooBigException, io.ktor.websocket.ProtocolViolationException, java.io.EOFException {
        /*
            Method dump skipped, instruction units count: 682
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.RawWebSocketCommonKt.readFrame(io.ktor.utils.io.ByteReadChannel, long, int, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

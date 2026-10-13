package io.ktor.network.sockets;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: DatagramSendChannel.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.network.sockets.DatagramSendChannel$send$2$1", f = "DatagramSendChannel.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {113, WebSocketProtocol.PAYLOAD_SHORT}, m = "invokeSuspend", n = {"writeWithPool", "$this$readFromHead$iv", "buffer$iv", "this_$iv$iv", "buffer$iv$iv", "head$iv$iv", "rawData$iv", "bb$iv", "buffer", "packetSize", "$i$f$readFromHead", "$i$f$readFromHead", "limit$iv", "pos$iv", "$i$a$-readFromHead-UnsafeBufferOperationsJvmKt$readFromHead$1$iv", "$i$a$-readFromHead-DatagramSendChannel$send$2$1$1", "length", "rc", "writeWithPool", "$this$useInstance$iv", "instance$iv", "buffer", "packetSize", "$i$f$useInstance", "$i$a$-useInstance-DatagramSendChannel$send$2$1$2", "rc"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "J$0", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5", "I$6", "I$7", "L$0", "L$1", "L$2", "L$3", "J$0", "I$0", "I$1", "I$2"}, v = 1)
final class DatagramSendChannel$send$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Datagram $element;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int I$4;
    int I$5;
    int I$6;
    int I$7;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    final /* synthetic */ DatagramSendChannel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DatagramSendChannel$send$2$1(Datagram datagram, DatagramSendChannel datagramSendChannel, Continuation<? super DatagramSendChannel$send$2$1> continuation) {
        super(2, continuation);
        this.$element = datagram;
        this.this$0 = datagramSendChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DatagramSendChannel$send$2$1(this.$element, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DatagramSendChannel$send$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0133 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:31:0x0135  */
    /* JADX WARN: Code duplicated, block: B:33:0x013b  */
    /* JADX WARN: Code duplicated, block: B:34:0x0140  */
    /* JADX WARN: Code duplicated, block: B:36:0x0148  */
    /* JADX WARN: Code duplicated, block: B:40:0x0154  */
    /* JADX WARN: Code duplicated, block: B:43:0x017c A[Catch: all -> 0x01c1, TryCatch #0 {all -> 0x01c1, blocks: (B:41:0x0160, B:43:0x017c, B:45:0x0189), top: B:58:0x0160 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0189 A[Catch: all -> 0x01c1, TRY_LEAVE, TryCatch #0 {all -> 0x01c1, blocks: (B:41:0x0160, B:43:0x017c, B:45:0x0189), top: B:58:0x0160 }] */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x01b8, code lost:
    
        if (r4.sendSuspend(r8, r3, r17) == r2) goto L47;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 471
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.sockets.DatagramSendChannel$send$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

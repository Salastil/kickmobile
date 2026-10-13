package io.ktor.network.sockets;

import io.ktor.utils.io.core.ByteReadPacketExtensions_jvmKt;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.io.Source;

/* JADX INFO: compiled from: DatagramSendChannel.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a6\u0010\u0007\u001a\u00020\u00052%\u0010\u0006\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0000H\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\f\u001a\u00020\u0005*\u00020\t2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\r\"\"\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00050\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f\"\"\u0010\u0010\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00050\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "handler", "failInvokeOnClose", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/io/Source;", "Ljava/nio/ByteBuffer;", "buffer", "writeMessageTo", "(Lkotlinx/io/Source;Ljava/nio/ByteBuffer;)V", "CLOSED", "Lkotlin/jvm/functions/Function1;", "CLOSED_INVOKED", "ktor-network"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DatagramSendChannelKt {
    private static final Function1<Throwable, Unit> CLOSED = new Function1() { // from class: io.ktor.network.sockets.DatagramSendChannelKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return Unit.INSTANCE;
        }
    };
    private static final Function1<Throwable, Unit> CLOSED_INVOKED = new Function1() { // from class: io.ktor.network.sockets.DatagramSendChannelKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return Unit.INSTANCE;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final void failInvokeOnClose(Function1<? super Throwable, Unit> function1) {
        String str;
        if (function1 == CLOSED_INVOKED) {
            str = "Another handler was already registered and successfully invoked";
        } else {
            str = "Another handler was already registered: " + function1;
        }
        throw new IllegalStateException(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void writeMessageTo(Source source, ByteBuffer byteBuffer) {
        ByteReadPacketExtensions_jvmKt.readFully(source, byteBuffer);
        byteBuffer.flip();
    }
}

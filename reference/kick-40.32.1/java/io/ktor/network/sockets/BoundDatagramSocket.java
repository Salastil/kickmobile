package io.ktor.network.sockets;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: Datagram.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lio/ktor/network/sockets/BoundDatagramSocket;", "Lio/ktor/network/sockets/ASocket;", "Lio/ktor/network/sockets/ABoundSocket;", "Lio/ktor/network/sockets/DatagramReadWriteChannel;", "ktor-network"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface BoundDatagramSocket extends ASocket, ABoundSocket, DatagramReadWriteChannel {

    /* JADX INFO: compiled from: Datagram.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void dispose(BoundDatagramSocket boundDatagramSocket) {
            BoundDatagramSocket.super.dispose();
        }

        @Deprecated
        public static Object receive(BoundDatagramSocket boundDatagramSocket, Continuation<? super Datagram> continuation) {
            return BoundDatagramSocket.super.receive(continuation);
        }

        @Deprecated
        public static Object send(BoundDatagramSocket boundDatagramSocket, Datagram datagram, Continuation<? super Unit> continuation) {
            return BoundDatagramSocket.super.send(datagram, continuation);
        }
    }
}

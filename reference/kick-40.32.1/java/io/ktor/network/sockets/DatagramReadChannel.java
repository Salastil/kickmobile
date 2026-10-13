package io.ktor.network.sockets;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.ReceiveChannel;

/* JADX INFO: compiled from: Datagram.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096@¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lio/ktor/network/sockets/DatagramReadChannel;", "", "Lio/ktor/network/sockets/Datagram;", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "getIncoming", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "incoming", "ktor-network"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface DatagramReadChannel {
    ReceiveChannel<Datagram> getIncoming();

    default Object receive(Continuation<? super Datagram> continuation) {
        return receive$suspendImpl(this, continuation);
    }

    /* JADX INFO: compiled from: Datagram.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Object receive(DatagramReadChannel datagramReadChannel, Continuation<? super Datagram> continuation) {
            return DatagramReadChannel.super.receive(continuation);
        }
    }

    static /* synthetic */ Object receive$suspendImpl(DatagramReadChannel datagramReadChannel, Continuation<? super Datagram> continuation) {
        return datagramReadChannel.getIncoming().receive(continuation);
    }
}

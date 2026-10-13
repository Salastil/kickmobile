package io.ktor.network.sockets;

import io.ktor.utils.io.core.ByteReadPacketKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Source;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: Datagram.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/network/sockets/Datagram;", "", "Lkotlinx/io/Source;", "packet", "Lio/ktor/network/sockets/SocketAddress;", "address", "<init>", "(Lkotlinx/io/Source;Lio/ktor/network/sockets/SocketAddress;)V", "Lkotlinx/io/Source;", "getPacket", "()Lkotlinx/io/Source;", "Lio/ktor/network/sockets/SocketAddress;", "getAddress", "()Lio/ktor/network/sockets/SocketAddress;", "ktor-network"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Datagram {
    private final SocketAddress address;
    private final Source packet;

    public Datagram(Source packet, SocketAddress address) {
        Intrinsics.checkNotNullParameter(packet, "packet");
        Intrinsics.checkNotNullParameter(address, "address");
        this.packet = packet;
        this.address = address;
        if (ByteReadPacketKt.getRemaining(packet) <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            return;
        }
        throw new IllegalArgumentException(("Datagram size limit exceeded: " + ByteReadPacketKt.getRemaining(packet) + " of possible 65535").toString());
    }

    public final Source getPacket() {
        return this.packet;
    }

    public final SocketAddress getAddress() {
        return this.address;
    }
}

package io.ktor.network.sockets;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SocketAddress.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/network/sockets/SocketAddress;", "", "port", "(Lio/ktor/network/sockets/SocketAddress;)I", "ktor-network"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class SocketAddressKt {
    public static final int port(SocketAddress socketAddress) {
        Intrinsics.checkNotNullParameter(socketAddress, "<this>");
        if (socketAddress instanceof InetSocketAddress) {
            return ((InetSocketAddress) socketAddress).getPort();
        }
        throw new UnsupportedOperationException("SocketAddress " + socketAddress + " does not have a port");
    }
}

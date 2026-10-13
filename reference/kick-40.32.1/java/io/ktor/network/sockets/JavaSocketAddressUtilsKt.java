package io.ktor.network.sockets;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JavaSocketAddressUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0000*\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lio/ktor/network/sockets/SocketAddress;", "Ljava/net/SocketAddress;", "toJavaAddress", "(Lio/ktor/network/sockets/SocketAddress;)Ljava/net/SocketAddress;", "toSocketAddress", "(Ljava/net/SocketAddress;)Lio/ktor/network/sockets/SocketAddress;", "ktor-network"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class JavaSocketAddressUtilsKt {
    public static final java.net.SocketAddress toJavaAddress(SocketAddress socketAddress) {
        Intrinsics.checkNotNullParameter(socketAddress, "<this>");
        return socketAddress.getAddress();
    }

    public static final SocketAddress toSocketAddress(java.net.SocketAddress socketAddress) {
        Intrinsics.checkNotNullParameter(socketAddress, "<this>");
        if (socketAddress instanceof java.net.InetSocketAddress) {
            return new InetSocketAddress((java.net.InetSocketAddress) socketAddress);
        }
        if (Intrinsics.areEqual(socketAddress.getClass().getName(), SocketAddressJvmKt.UNIX_DOMAIN_SOCKET_ADDRESS_CLASS)) {
            return new UnixSocketAddress(socketAddress);
        }
        throw new IllegalStateException("Unknown socket address type".toString());
    }
}

package io.ktor.network.sockets;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SocketAddressJvm.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u00048 X \u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\b\t¨\u0006\n"}, d2 = {"Lio/ktor/network/sockets/SocketAddress;", "", "<init>", "()V", "Ljava/net/SocketAddress;", "getAddress$ktor_network", "()Ljava/net/SocketAddress;", "address", "Lio/ktor/network/sockets/InetSocketAddress;", "Lio/ktor/network/sockets/UnixSocketAddress;", "ktor-network"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class SocketAddress {
    public /* synthetic */ SocketAddress(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract java.net.SocketAddress getAddress$ktor_network();

    private SocketAddress() {
    }
}

package com.lyft.kronos.internal.ntp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DatagramFactory.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/lyft/kronos/internal/ntp/DatagramFactoryImpl;", "Lcom/lyft/kronos/internal/ntp/DatagramFactory;", "()V", "createPacket", "Ljava/net/DatagramPacket;", "buffer", "", "address", "Ljava/net/InetAddress;", "port", "", "createSocket", "Ljava/net/DatagramSocket;", "kronos-java"}, k = 1, mv = {1, 4, 0})
public final class DatagramFactoryImpl implements DatagramFactory {
    @Override // com.lyft.kronos.internal.ntp.DatagramFactory
    public DatagramSocket createSocket() throws SocketException {
        return new DatagramSocket();
    }

    @Override // com.lyft.kronos.internal.ntp.DatagramFactory
    public DatagramPacket createPacket(byte[] buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        return new DatagramPacket(buffer, buffer.length);
    }

    @Override // com.lyft.kronos.internal.ntp.DatagramFactory
    public DatagramPacket createPacket(byte[] buffer, InetAddress address, int port) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(address, "address");
        return new DatagramPacket(buffer, buffer.length, address, port);
    }
}

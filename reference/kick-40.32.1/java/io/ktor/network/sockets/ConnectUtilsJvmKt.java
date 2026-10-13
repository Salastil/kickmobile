package io.ktor.network.sockets;

import io.ktor.network.selector.SelectorManager;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.ProtocolFamily;
import java.net.StandardProtocolFamily;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConnectUtilsJvm.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a(\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0080@¢\u0006\u0004\b\u0007\u0010\b\u001a*\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\nH\u0080@¢\u0006\u0004\b\f\u0010\r\u001a#\u0010\u0012\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a%\u0010\u0015\u001a\n \u0011*\u0004\u0018\u00010\u00140\u0014*\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lio/ktor/network/selector/SelectorManager;", "selector", "Lio/ktor/network/sockets/SocketAddress;", "remoteAddress", "Lio/ktor/network/sockets/SocketOptions$TCPClientSocketOptions;", "socketOptions", "Lio/ktor/network/sockets/Socket;", "tcpConnect", "(Lio/ktor/network/selector/SelectorManager;Lio/ktor/network/sockets/SocketAddress;Lio/ktor/network/sockets/SocketOptions$TCPClientSocketOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "localAddress", "Lio/ktor/network/sockets/SocketOptions$AcceptorOptions;", "Lio/ktor/network/sockets/ServerSocket;", "tcpBind", "(Lio/ktor/network/selector/SelectorManager;Lio/ktor/network/sockets/SocketAddress;Lio/ktor/network/sockets/SocketOptions$AcceptorOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/nio/channels/spi/SelectorProvider;", "address", "Ljava/nio/channels/SocketChannel;", "kotlin.jvm.PlatformType", "openSocketChannelFor", "(Ljava/nio/channels/spi/SelectorProvider;Lio/ktor/network/sockets/SocketAddress;)Ljava/nio/channels/SocketChannel;", "Ljava/nio/channels/ServerSocketChannel;", "openServerSocketChannelFor", "(Ljava/nio/channels/spi/SelectorProvider;Lio/ktor/network/sockets/SocketAddress;)Ljava/nio/channels/ServerSocketChannel;", "ktor-network"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ConnectUtilsJvmKt {

    /* JADX INFO: renamed from: io.ktor.network.sockets.ConnectUtilsJvmKt$tcpConnect$1, reason: invalid class name */
    /* JADX INFO: compiled from: ConnectUtilsJvm.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.network.sockets.ConnectUtilsJvmKt", f = "ConnectUtilsJvm.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {21}, m = "tcpConnect", n = {"selector", "remoteAddress", "socketOptions", "$this$buildOrClose$iv", "$this$tcpConnect_u24lambda_u241", "result$iv", "$this$tcpConnect_u24lambda_u241_u240", "$i$f$buildOrClose", "$i$a$-buildOrClose-ConnectUtilsJvmKt$tcpConnect$3", "$i$a$-apply-ConnectUtilsJvmKt$tcpConnect$3$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "I$0", "I$1", "I$2"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ConnectUtilsJvmKt.tcpConnect(null, null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object tcpConnect(SelectorManager selectorManager, SocketAddress socketAddress, SocketOptions.TCPClientSocketOptions tCPClientSocketOptions, Continuation<? super Socket> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Closeable closeable;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SocketChannel socketChannelOpenSocketChannelFor = openSocketChannelFor(selectorManager.getProvider(), socketAddress);
            try {
                SocketChannel socketChannel = socketChannelOpenSocketChannelFor;
                if (socketAddress instanceof InetSocketAddress) {
                    Intrinsics.checkNotNull(socketChannel);
                    JavaSocketOptionsKt.assignOptions(socketChannel, tCPClientSocketOptions);
                }
                Intrinsics.checkNotNull(socketChannel);
                JavaSocketOptionsKt.nonBlocking(socketChannel);
                SocketImpl socketImpl = new SocketImpl(socketChannel, selectorManager, tCPClientSocketOptions);
                java.net.SocketAddress javaAddress = JavaSocketAddressUtilsKt.toJavaAddress(socketAddress);
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(selectorManager);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(socketAddress);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(tCPClientSocketOptions);
                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(selectorManager);
                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(socketChannel);
                anonymousClass1.L$5 = socketChannelOpenSocketChannelFor;
                anonymousClass1.L$6 = socketImpl;
                anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(socketImpl);
                anonymousClass1.I$0 = 0;
                anonymousClass1.I$1 = 0;
                anonymousClass1.I$2 = 0;
                anonymousClass1.label = 1;
                return socketImpl.connect$ktor_network(javaAddress, anonymousClass1) == coroutine_suspended ? coroutine_suspended : socketImpl;
            } catch (Throwable th) {
                th = th;
                closeable = socketChannelOpenSocketChannelFor;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = anonymousClass1.I$2;
            int i3 = anonymousClass1.I$1;
            int i4 = anonymousClass1.I$0;
            SocketImpl socketImpl2 = (SocketImpl) anonymousClass1.L$6;
            closeable = (Closeable) anonymousClass1.L$5;
            try {
                ResultKt.throwOnFailure(obj);
                return socketImpl2;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        closeable.close();
        throw th;
    }

    public static final SocketChannel openSocketChannelFor(SelectorProvider selectorProvider, SocketAddress address) throws IllegalAccessException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(selectorProvider, "<this>");
        Intrinsics.checkNotNullParameter(address, "address");
        if (address instanceof InetSocketAddress) {
            return selectorProvider.openSocketChannel();
        }
        if (!(address instanceof UnixSocketAddress)) {
            throw new NoWhenBranchMatchedException();
        }
        Object objInvoke = SelectorProvider.class.getMethod("openSocketChannel", ProtocolFamily.class).invoke(selectorProvider, StandardProtocolFamily.valueOf("UNIX"));
        Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type java.nio.channels.SocketChannel");
        return (SocketChannel) objInvoke;
    }

    public static final ServerSocketChannel openServerSocketChannelFor(SelectorProvider selectorProvider, SocketAddress socketAddress) throws IllegalAccessException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(selectorProvider, "<this>");
        if (socketAddress == null) {
            return selectorProvider.openServerSocketChannel();
        }
        if (socketAddress instanceof InetSocketAddress) {
            return selectorProvider.openServerSocketChannel();
        }
        if (!(socketAddress instanceof UnixSocketAddress)) {
            throw new NoWhenBranchMatchedException();
        }
        Object objInvoke = SelectorProvider.class.getMethod("openServerSocketChannel", ProtocolFamily.class).invoke(selectorProvider, StandardProtocolFamily.valueOf("UNIX"));
        Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type java.nio.channels.ServerSocketChannel");
        return (ServerSocketChannel) objInvoke;
    }

    public static final Object tcpBind(SelectorManager selectorManager, SocketAddress socketAddress, SocketOptions.AcceptorOptions acceptorOptions, Continuation<? super ServerSocket> continuation) throws IllegalAccessException, IOException, InvocationTargetException {
        ServerSocketChannel serverSocketChannelOpenServerSocketChannelFor = openServerSocketChannelFor(selectorManager.getProvider(), socketAddress);
        try {
            ServerSocketChannel serverSocketChannel = serverSocketChannelOpenServerSocketChannelFor;
            if (socketAddress instanceof InetSocketAddress) {
                Intrinsics.checkNotNull(serverSocketChannel);
                JavaSocketOptionsKt.assignOptions(serverSocketChannel, acceptorOptions);
            }
            Intrinsics.checkNotNull(serverSocketChannel);
            JavaSocketOptionsKt.nonBlocking(serverSocketChannel);
            ServerSocketImpl serverSocketImpl = new ServerSocketImpl(serverSocketChannel, selectorManager);
            if (JavaSocketOptionsKt.getJava7NetworkApisAvailable()) {
                serverSocketImpl.getChannel().bind(socketAddress != null ? JavaSocketAddressUtilsKt.toJavaAddress(socketAddress) : null, acceptorOptions.getBacklogSize());
                return serverSocketImpl;
            }
            serverSocketImpl.getChannel().socket().bind(socketAddress != null ? JavaSocketAddressUtilsKt.toJavaAddress(socketAddress) : null, acceptorOptions.getBacklogSize());
            return serverSocketImpl;
        } catch (Throwable th) {
            serverSocketChannelOpenServerSocketChannelFor.close();
            throw th;
        }
    }
}

package io.ktor.network.sockets;

import io.ktor.network.selector.SelectInterest;
import io.ktor.network.selector.SelectableBase;
import io.ktor.network.selector.SelectorManager;
import java.io.IOException;
import java.net.SocketOption;
import java.net.StandardSocketOptions;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;

/* JADX INFO: compiled from: ServerSocketImpl.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tH\u0096@¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tH\u0082@¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\u00020\u001a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lio/ktor/network/sockets/ServerSocketImpl;", "Lio/ktor/network/selector/SelectableBase;", "Lio/ktor/network/sockets/ServerSocket;", "Ljava/nio/channels/ServerSocketChannel;", "channel", "Lio/ktor/network/selector/SelectorManager;", "selector", "<init>", "(Ljava/nio/channels/ServerSocketChannel;Lio/ktor/network/selector/SelectorManager;)V", "Lio/ktor/network/sockets/Socket;", "accept", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acceptSuspend", "Ljava/nio/channels/SocketChannel;", "nioChannel", "accepted", "(Ljava/nio/channels/SocketChannel;)Lio/ktor/network/sockets/Socket;", "", "close", "()V", "Ljava/nio/channels/ServerSocketChannel;", "getChannel", "()Ljava/nio/channels/ServerSocketChannel;", "Lio/ktor/network/selector/SelectorManager;", "getSelector", "()Lio/ktor/network/selector/SelectorManager;", "Lkotlinx/coroutines/CompletableJob;", "socketContext", "Lkotlinx/coroutines/CompletableJob;", "getSocketContext", "()Lkotlinx/coroutines/CompletableJob;", "Lio/ktor/network/sockets/SocketAddress;", "getLocalAddress", "()Lio/ktor/network/sockets/SocketAddress;", "localAddress", "ktor-network"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ServerSocketImpl extends SelectableBase implements ServerSocket {
    private final ServerSocketChannel channel;
    private final SelectorManager selector;
    private final CompletableJob socketContext;

    /* JADX INFO: renamed from: io.ktor.network.sockets.ServerSocketImpl$acceptSuspend$1, reason: invalid class name */
    /* JADX INFO: compiled from: ServerSocketImpl.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.network.sockets.ServerSocketImpl", f = "ServerSocketImpl.kt", i = {}, l = {41}, m = "acceptSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ServerSocketImpl.this.acceptSuspend(this);
        }
    }

    public ServerSocketImpl(ServerSocketChannel channel, SelectorManager selector) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(selector, "selector");
        this.channel = channel;
        this.selector = selector;
        if (!getChannel().isBlocking()) {
            this.socketContext = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
            return;
        }
        throw new IllegalArgumentException("Channel need to be configured as non-blocking.".toString());
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public /* bridge */ void dispose() {
        super.dispose();
    }

    @Override // io.ktor.network.selector.Selectable
    public ServerSocketChannel getChannel() {
        return this.channel;
    }

    public final SelectorManager getSelector() {
        return this.selector;
    }

    @Override // io.ktor.network.sockets.ASocket
    public CompletableJob getSocketContext() {
        return this.socketContext;
    }

    @Override // io.ktor.network.sockets.ABoundSocket
    public SocketAddress getLocalAddress() throws IOException {
        java.net.SocketAddress localSocketAddress;
        if (JavaSocketOptionsKt.getJava7NetworkApisAvailable()) {
            localSocketAddress = getChannel().getLocalAddress();
        } else {
            localSocketAddress = getChannel().socket().getLocalSocketAddress();
        }
        Intrinsics.checkNotNull(localSocketAddress);
        return JavaSocketAddressUtilsKt.toSocketAddress(localSocketAddress);
    }

    @Override // io.ktor.network.sockets.Acceptable
    public Object accept(Continuation<? super Socket> continuation) throws IOException {
        SocketChannel socketChannelAccept = getChannel().accept();
        return socketChannelAccept != null ? accepted(socketChannelAccept) : acceptSuspend(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:17:0x0049 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x0054  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0047 -> B:18:0x004a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:0:?
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object acceptSuspend(kotlin.coroutines.Continuation<? super io.ktor.network.sockets.Socket> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof io.ktor.network.sockets.ServerSocketImpl.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.network.sockets.ServerSocketImpl$acceptSuspend$1 r0 = (io.ktor.network.sockets.ServerSocketImpl.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.network.sockets.ServerSocketImpl$acceptSuspend$1 r0 = new io.ktor.network.sockets.ServerSocketImpl$acceptSuspend$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4a
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
        L35:
            io.ktor.network.selector.SelectInterest r6 = io.ktor.network.selector.SelectInterest.ACCEPT
            r5.interestOp(r6, r3)
            io.ktor.network.selector.SelectorManager r6 = r5.selector
            r2 = r5
            io.ktor.network.selector.Selectable r2 = (io.ktor.network.selector.Selectable) r2
            io.ktor.network.selector.SelectInterest r4 = io.ktor.network.selector.SelectInterest.ACCEPT
            r0.label = r3
            java.lang.Object r6 = r6.select(r2, r4, r0)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            java.nio.channels.ServerSocketChannel r6 = r5.getChannel()
            java.nio.channels.SocketChannel r6 = r6.accept()
            if (r6 == 0) goto L35
            io.ktor.network.sockets.Socket r5 = r5.accepted(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.sockets.ServerSocketImpl.acceptSuspend(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Socket accepted(SocketChannel nioChannel) throws IOException {
        interestOp(SelectInterest.ACCEPT, false);
        nioChannel.configureBlocking(false);
        if (getLocalAddress() instanceof InetSocketAddress) {
            if (JavaSocketOptionsKt.getJava7NetworkApisAvailable()) {
                nioChannel.setOption((SocketOption<boolean>) StandardSocketOptions.TCP_NODELAY, true);
            } else {
                nioChannel.socket().setTcpNoDelay(true);
            }
        }
        return new SocketImpl(nioChannel, this.selector, null, 4, null);
    }

    @Override // io.ktor.network.selector.SelectableBase, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            try {
                getChannel().close();
                this.selector.notifyClosed(this);
                getSocketContext().complete();
            } catch (Throwable th) {
                this.selector.notifyClosed(this);
                throw th;
            }
        } catch (Throwable th2) {
            getSocketContext().completeExceptionally(th2);
        }
    }
}

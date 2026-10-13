package io.ktor.network.sockets;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: compiled from: DatagramSocketImpl.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lio/ktor/network/sockets/Datagram;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.network.sockets.DatagramSocketImpl$receiver$1", f = "DatagramSocketImpl.kt", i = {0, 1}, l = {52, 52}, m = "invokeSuspend", n = {"$this$produce", "$this$produce"}, s = {"L$0", "L$0"}, v = 1)
final class DatagramSocketImpl$receiver$1 extends SuspendLambda implements Function2<ProducerScope<? super Datagram>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DatagramSocketImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DatagramSocketImpl$receiver$1(DatagramSocketImpl datagramSocketImpl, Continuation<? super DatagramSocketImpl$receiver$1> continuation) {
        super(2, continuation);
        this.this$0 = datagramSocketImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DatagramSocketImpl$receiver$1 datagramSocketImpl$receiver$1 = new DatagramSocketImpl$receiver$1(this.this$0, continuation);
        datagramSocketImpl$receiver$1.L$0 = obj;
        return datagramSocketImpl$receiver$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super Datagram> producerScope, Continuation<? super Unit> continuation) {
        return ((DatagramSocketImpl$receiver$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0029 A[Catch: ClosedChannelException | IOException -> 0x0050, ClosedChannelException | IOException -> 0x0050, TRY_ENTER, TryCatch #0 {ClosedChannelException | IOException -> 0x0050, blocks: (B:6:0x0012, B:14:0x0029, B:14:0x0029, B:17:0x003f, B:17:0x003f, B:11:0x0022, B:11:0x0022), top: B:22:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:16:0x003e  */
    /* JADX WARN: Code duplicated, block: B:17:0x003f A[Catch: ClosedChannelException | IOException -> 0x0050, ClosedChannelException | IOException -> 0x0050, PHI: r2 r8
      0x003f: PHI (r2v1 kotlinx.coroutines.channels.SendChannel) = (r2v2 kotlinx.coroutines.channels.SendChannel), (r2v4 kotlinx.coroutines.channels.SendChannel) binds: [B:15:0x003c, B:11:0x0022] A[DONT_GENERATE, DONT_INLINE]
      0x003f: PHI (r8v1 java.lang.Object) = (r8v4 java.lang.Object), (r8v0 java.lang.Object) binds: [B:15:0x003c, B:11:0x0022] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {ClosedChannelException | IOException -> 0x0050, blocks: (B:6:0x0012, B:14:0x0029, B:14:0x0029, B:17:0x003f, B:17:0x003f, B:11:0x0022, B:11:0x0022), top: B:22:0x000c }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x004d -> B:14:0x0029). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.L$0
            kotlinx.coroutines.channels.ProducerScope r0 = (kotlinx.coroutines.channels.ProducerScope) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r7.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L26
            if (r2 == r4) goto L1e
            if (r2 != r3) goto L16
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L50
            goto L29
        L16:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L1e:
            java.lang.Object r2 = r7.L$1
            kotlinx.coroutines.channels.SendChannel r2 = (kotlinx.coroutines.channels.SendChannel) r2
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L50 java.lang.Throwable -> L50
            goto L3f
        L26:
            kotlin.ResultKt.throwOnFailure(r8)
        L29:
            kotlinx.coroutines.channels.SendChannel r2 = r0.getChannel()     // Catch: java.lang.Throwable -> L50 java.lang.Throwable -> L50
            io.ktor.network.sockets.DatagramSocketImpl r8 = r7.this$0     // Catch: java.lang.Throwable -> L50 java.lang.Throwable -> L50
            r5 = r7
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch: java.lang.Throwable -> L50 java.lang.Throwable -> L50
            r7.L$0 = r0     // Catch: java.lang.Throwable -> L50 java.lang.Throwable -> L50
            r7.L$1 = r2     // Catch: java.lang.Throwable -> L50 java.lang.Throwable -> L50
            r7.label = r4     // Catch: java.lang.Throwable -> L50 java.lang.Throwable -> L50
            java.lang.Object r8 = io.ktor.network.sockets.DatagramSocketImpl.access$receiveImpl(r8, r5)     // Catch: java.lang.Throwable -> L50 java.lang.Throwable -> L50
            if (r8 != r1) goto L3f
            goto L4f
        L3f:
            r5 = r7
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch: java.lang.Throwable -> L50 java.lang.Throwable -> L50
            r7.L$0 = r0     // Catch: java.lang.Throwable -> L50 java.lang.Throwable -> L50
            r6 = 0
            r7.L$1 = r6     // Catch: java.lang.Throwable -> L50 java.lang.Throwable -> L50
            r7.label = r3     // Catch: java.lang.Throwable -> L50 java.lang.Throwable -> L50
            java.lang.Object r8 = r2.send(r8, r5)     // Catch: java.lang.Throwable -> L50 java.lang.Throwable -> L50
            if (r8 != r1) goto L29
        L4f:
            return r1
        L50:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.sockets.DatagramSocketImpl$receiver$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

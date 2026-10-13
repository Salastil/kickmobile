package io.ktor.websocket;

import androidx.collection.SieveCacheKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.muxer.WebmConstants;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: compiled from: RawWebSocketCommon.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001@B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010H\u0096@¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0017¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\"\u0010\u0007\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\t\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010$\u001a\u0004\b%\u0010&R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020+0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010*R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020(008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020(048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u001e\u0010<\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u000309088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0014\u0010>\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006A"}, d2 = {"Lio/ktor/websocket/RawWebSocketCommon;", "Lio/ktor/websocket/WebSocketSession;", "Lio/ktor/utils/io/ByteReadChannel;", "input", "Lio/ktor/utils/io/ByteWriteChannel;", "output", "", "maxFrameSize", "", "masking", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lio/ktor/websocket/WebSocketChannelsConfig;", "channelsConfig", "<init>", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;JZLkotlin/coroutines/CoroutineContext;Lio/ktor/websocket/WebSocketChannelsConfig;)V", "", "flush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "terminate", "()V", "Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/utils/io/ByteWriteChannel;", "J", "getMaxFrameSize", "()J", "setMaxFrameSize", "(J)V", "Z", "getMasking", "()Z", "setMasking", "(Z)V", "Lkotlinx/coroutines/CompletableJob;", "socketJob", "Lkotlinx/coroutines/CompletableJob;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlinx/coroutines/channels/Channel;", "Lio/ktor/websocket/Frame;", "_incoming", "Lkotlinx/coroutines/channels/Channel;", "", "_outgoing", "", "lastOpcode", "I", "Lkotlinx/coroutines/channels/ReceiveChannel;", "getIncoming", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "incoming", "Lkotlinx/coroutines/channels/SendChannel;", "getOutgoing", "()Lkotlinx/coroutines/channels/SendChannel;", "outgoing", "", "Lio/ktor/websocket/WebSocketExtension;", "getExtensions", "()Ljava/util/List;", "extensions", "Lkotlinx/coroutines/Job;", "writerJob", "Lkotlinx/coroutines/Job;", "FlushRequest", "ktor-websockets"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RawWebSocketCommon implements WebSocketSession {
    private final Channel<Frame> _incoming;
    private final Channel<Object> _outgoing;
    private final CoroutineContext coroutineContext;
    private final ByteReadChannel input;
    private int lastOpcode;
    private boolean masking;
    private long maxFrameSize;
    private final ByteWriteChannel output;
    private final CompletableJob socketJob;
    private final Job writerJob;

    /* JADX INFO: renamed from: io.ktor.websocket.RawWebSocketCommon$flush$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RawWebSocketCommon.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.RawWebSocketCommon", f = "RawWebSocketCommon.kt", i = {0, 0, 1, 1, 1}, l = {157, WebmConstants.MkvEbmlElement.BLOCK_GROUP, WebmConstants.MkvEbmlElement.BLOCK_ADDITIONAL}, m = "flush", n = {"it", "$i$a$-also-RawWebSocketCommon$flush$2", "it", "<unused var>", "$i$a$-also-RawWebSocketCommon$flush$2"}, s = {"L$1", "I$0", "L$1", "L$2", "I$0"}, v = 1)
    static final class C11001 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11001(Continuation<? super C11001> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RawWebSocketCommon.this.flush(this);
        }
    }

    public RawWebSocketCommon(ByteReadChannel input, ByteWriteChannel output, long j, boolean z, CoroutineContext coroutineContext, WebSocketChannelsConfig channelsConfig) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(channelsConfig, "channelsConfig");
        this.input = input;
        this.output = output;
        this.maxFrameSize = j;
        this.masking = z;
        CompletableJob completableJobJob = JobKt.Job((Job) coroutineContext.get(Job.INSTANCE));
        this.socketJob = completableJobJob;
        this.coroutineContext = coroutineContext.plus(completableJobJob).plus(new CoroutineName("raw-ws"));
        this._incoming = WebSocketChannelsConfigKt.from(Channel.INSTANCE, channelsConfig.getIncoming());
        this._outgoing = WebSocketChannelsConfigKt.from(Channel.INSTANCE, channelsConfig.getOutgoing());
        RawWebSocketCommon rawWebSocketCommon = this;
        this.writerJob = BuildersKt.launch(rawWebSocketCommon, new CoroutineName("ws-writer"), CoroutineStart.ATOMIC, new RawWebSocketCommon$writerJob$1(this, null));
        BuildersKt.launch(rawWebSocketCommon, new CoroutineName("ws-reader"), CoroutineStart.ATOMIC, new AnonymousClass1(null));
        completableJobJob.complete();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public /* bridge */ Object send(Frame frame, Continuation<? super Unit> continuation) {
        return super.send(frame, continuation);
    }

    public /* synthetic */ RawWebSocketCommon(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, boolean z, CoroutineContext coroutineContext, WebSocketChannelsConfig webSocketChannelsConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteReadChannel, byteWriteChannel, (i & 4) != 0 ? SieveCacheKt.NodeLinkMask : j, (i & 8) != 0 ? false : z, coroutineContext, webSocketChannelsConfig);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public long getMaxFrameSize() {
        return this.maxFrameSize;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMaxFrameSize(long j) {
        this.maxFrameSize = j;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public boolean getMasking() {
        return this.masking;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMasking(boolean z) {
        this.masking = z;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public ReceiveChannel<Frame> getIncoming() {
        return this._incoming;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public SendChannel<Frame> getOutgoing() {
        return this._outgoing;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public List<WebSocketExtension<?>> getExtensions() {
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: renamed from: io.ktor.websocket.RawWebSocketCommon$1, reason: invalid class name */
    /* JADX INFO: compiled from: RawWebSocketCommon.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.RawWebSocketCommon$1", f = "RawWebSocketCommon.kt", i = {1, 2, 3}, l = {123, 127, WebmConstants.MkvEbmlElement.TRACK_TYPE, 135}, m = "invokeSuspend", n = {TypedValues.Attributes.S_FRAME, "cause", "cause"}, s = {"L$0", "L$0", "L$0"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RawWebSocketCommon.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:27:0x0045 A[Catch: all -> 0x003a, ProtocolViolationException -> 0x003c, FrameTooBigException -> 0x003f, EOFException | ClosedReceiveChannelException -> 0x00aa, EOFException | ClosedReceiveChannelException -> 0x00aa, CancellationException -> 0x00b6, TRY_ENTER, TryCatch #2 {EOFException | ClosedReceiveChannelException -> 0x00aa, blocks: (B:17:0x0032, B:27:0x0045, B:27:0x0045, B:30:0x0066, B:30:0x0066, B:32:0x0072, B:32:0x0072, B:36:0x0084, B:36:0x0084, B:35:0x007c, B:35:0x007c, B:37:0x0087, B:37:0x0087, B:18:0x0036), top: B:55:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:29:0x0064  */
        /* JADX WARN: Code duplicated, block: B:30:0x0066 A[Catch: all -> 0x003a, ProtocolViolationException -> 0x003c, FrameTooBigException -> 0x003f, EOFException | ClosedReceiveChannelException -> 0x00aa, EOFException | ClosedReceiveChannelException -> 0x00aa, CancellationException -> 0x00b6, PHI: r11
          0x0066: PHI (r11v12 java.lang.Object) = (r11v17 java.lang.Object), (r11v0 java.lang.Object) binds: [B:28:0x0062, B:18:0x0036] A[DONT_GENERATE, DONT_INLINE], TryCatch #2 {EOFException | ClosedReceiveChannelException -> 0x00aa, blocks: (B:17:0x0032, B:27:0x0045, B:27:0x0045, B:30:0x0066, B:30:0x0066, B:32:0x0072, B:32:0x0072, B:36:0x0084, B:36:0x0084, B:35:0x007c, B:35:0x007c, B:37:0x0087, B:37:0x0087, B:18:0x0036), top: B:55:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:32:0x0072 A[Catch: all -> 0x003a, ProtocolViolationException -> 0x003c, FrameTooBigException -> 0x003f, EOFException | ClosedReceiveChannelException -> 0x00aa, EOFException | ClosedReceiveChannelException -> 0x00aa, CancellationException -> 0x00b6, TryCatch #2 {EOFException | ClosedReceiveChannelException -> 0x00aa, blocks: (B:17:0x0032, B:27:0x0045, B:27:0x0045, B:30:0x0066, B:30:0x0066, B:32:0x0072, B:32:0x0072, B:36:0x0084, B:36:0x0084, B:35:0x007c, B:35:0x007c, B:37:0x0087, B:37:0x0087, B:18:0x0036), top: B:55:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:34:0x007a  */
        /* JADX WARN: Code duplicated, block: B:35:0x007c A[Catch: all -> 0x003a, ProtocolViolationException -> 0x003c, FrameTooBigException -> 0x003f, EOFException | ClosedReceiveChannelException -> 0x00aa, EOFException | ClosedReceiveChannelException -> 0x00aa, CancellationException -> 0x00b6, TryCatch #2 {EOFException | ClosedReceiveChannelException -> 0x00aa, blocks: (B:17:0x0032, B:27:0x0045, B:27:0x0045, B:30:0x0066, B:30:0x0066, B:32:0x0072, B:32:0x0072, B:36:0x0084, B:36:0x0084, B:35:0x007c, B:35:0x007c, B:37:0x0087, B:37:0x0087, B:18:0x0036), top: B:55:0x000b }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x009c -> B:27:0x0045). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                Method dump skipped, instruction units count: 313
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.RawWebSocketCommon.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c1, code lost:
    
        if (r6.await(r0) == r1) goto L42;
     */
    @Override // io.ktor.websocket.WebSocketSession
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object flush(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof io.ktor.websocket.RawWebSocketCommon.C11001
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.websocket.RawWebSocketCommon$flush$1 r0 = (io.ktor.websocket.RawWebSocketCommon.C11001) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            io.ktor.websocket.RawWebSocketCommon$flush$1 r0 = new io.ktor.websocket.RawWebSocketCommon$flush$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L62
            if (r2 == r5) goto L4c
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            kotlin.ResultKt.throwOnFailure(r9)
            goto Lc4
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L39:
            int r8 = r0.I$0
            java.lang.Object r8 = r0.L$2
            kotlinx.coroutines.channels.ClosedSendChannelException r8 = (kotlinx.coroutines.channels.ClosedSendChannelException) r8
            java.lang.Object r8 = r0.L$1
            io.ktor.websocket.RawWebSocketCommon$FlushRequest r8 = (io.ktor.websocket.RawWebSocketCommon.FlushRequest) r8
            java.lang.Object r8 = r0.L$0
            io.ktor.websocket.RawWebSocketCommon$FlushRequest r8 = (io.ktor.websocket.RawWebSocketCommon.FlushRequest) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto Lb3
        L4c:
            int r2 = r0.I$0
            java.lang.Object r5 = r0.L$1
            io.ktor.websocket.RawWebSocketCommon$FlushRequest r5 = (io.ktor.websocket.RawWebSocketCommon.FlushRequest) r5
            java.lang.Object r6 = r0.L$0
            io.ktor.websocket.RawWebSocketCommon$FlushRequest r6 = (io.ktor.websocket.RawWebSocketCommon.FlushRequest) r6
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L5a kotlinx.coroutines.channels.ClosedSendChannelException -> L5c
            goto Lb4
        L5a:
            r8 = move-exception
            goto L8e
        L5c:
            r9 = move-exception
            r7 = r5
            r5 = r9
            r9 = r6
            r6 = r7
            goto L94
        L62:
            kotlin.ResultKt.throwOnFailure(r9)
            io.ktor.websocket.RawWebSocketCommon$FlushRequest r9 = new io.ktor.websocket.RawWebSocketCommon$FlushRequest
            kotlin.coroutines.CoroutineContext r2 = r8.getCoroutineContext()
            kotlinx.coroutines.Job$Key r6 = kotlinx.coroutines.Job.INSTANCE
            kotlin.coroutines.CoroutineContext$Key r6 = (kotlin.coroutines.CoroutineContext.Key) r6
            kotlin.coroutines.CoroutineContext$Element r2 = r2.get(r6)
            kotlinx.coroutines.Job r2 = (kotlinx.coroutines.Job) r2
            r9.<init>(r2)
            r2 = 0
            kotlinx.coroutines.channels.Channel<java.lang.Object> r6 = r8._outgoing     // Catch: java.lang.Throwable -> L8c kotlinx.coroutines.channels.ClosedSendChannelException -> L92
            r0.L$0 = r9     // Catch: java.lang.Throwable -> L8c kotlinx.coroutines.channels.ClosedSendChannelException -> L92
            r0.L$1 = r9     // Catch: java.lang.Throwable -> L8c kotlinx.coroutines.channels.ClosedSendChannelException -> L92
            r0.I$0 = r2     // Catch: java.lang.Throwable -> L8c kotlinx.coroutines.channels.ClosedSendChannelException -> L92
            r0.label = r5     // Catch: java.lang.Throwable -> L8c kotlinx.coroutines.channels.ClosedSendChannelException -> L92
            java.lang.Object r8 = r6.send(r9, r0)     // Catch: java.lang.Throwable -> L8c kotlinx.coroutines.channels.ClosedSendChannelException -> L92
            if (r8 != r1) goto L8a
            goto Lc3
        L8a:
            r6 = r9
            goto Lb4
        L8c:
            r8 = move-exception
            r5 = r9
        L8e:
            r5.complete()
            throw r8
        L92:
            r5 = move-exception
            r6 = r9
        L94:
            r6.complete()
            kotlinx.coroutines.Job r8 = r8.writerJob
            r0.L$0 = r9
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$1 = r6
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r0.L$2 = r5
            r0.I$0 = r2
            r0.label = r4
            java.lang.Object r8 = r8.join(r0)
            if (r8 != r1) goto Lb2
            goto Lc3
        Lb2:
            r8 = r9
        Lb3:
            r6 = r8
        Lb4:
            r8 = 0
            r0.L$0 = r8
            r0.L$1 = r8
            r0.L$2 = r8
            r0.label = r3
            java.lang.Object r8 = r6.await(r0)
            if (r8 != r1) goto Lc4
        Lc3:
            return r1
        Lc4:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.RawWebSocketCommon.flush(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.websocket.WebSocketSession
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use cancel() instead.", replaceWith = @ReplaceWith(expression = "cancel()", imports = {"kotlinx.coroutines.cancel"}))
    public void terminate() {
        SendChannel.DefaultImpls.close$default(getOutgoing(), null, 1, null);
        this.socketJob.complete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: RawWebSocketCommon.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tH\u0086@¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/websocket/RawWebSocketCommon$FlushRequest;", "", "Lkotlinx/coroutines/Job;", "parent", "<init>", "(Lkotlinx/coroutines/Job;)V", "", "complete", "()Z", "", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CompletableJob;", "done", "Lkotlinx/coroutines/CompletableJob;", "ktor-websockets"}, k = 1, mv = {2, 3, 0}, xi = 48)
    static final class FlushRequest {
        private final CompletableJob done;

        public FlushRequest(Job job) {
            this.done = JobKt.Job(job);
        }

        public final boolean complete() {
            return this.done.complete();
        }

        public final Object await(Continuation<? super Unit> continuation) {
            Object objJoin = this.done.join(continuation);
            return objJoin == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objJoin : Unit.INSTANCE;
        }
    }
}

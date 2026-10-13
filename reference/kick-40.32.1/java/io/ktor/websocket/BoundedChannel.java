package io.ktor.websocket;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause2;

/* JADX INFO: compiled from: WebSocketChannelsConfig.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 @*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001@B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0097\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0011\u001a\u00020\nH\u0097\u0001¢\u0006\u0004\b\u0011\u0010\u0013J \u0010\u0011\u001a\u00020\n2\u000e\u0010\u000f\u001a\n\u0018\u00010\u0014j\u0004\u0018\u0001`\u0015H\u0096\u0001¢\u0006\u0004\b\u0011\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0096\u0001¢\u0006\u0004\b\u0017\u0010\u0012J5\u0010\u001c\u001a\u00020\n2#\u0010\u001b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\n0\u0018H\u0096\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0096\u0003¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010!\u001a\u00020\u00102\u0006\u0010\b\u001a\u00028\u0000H\u0097\u0001¢\u0006\u0004\b!\u0010\"J\u0012\u0010#\u001a\u0004\u0018\u00018\u0000H\u0097\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00028\u0000H\u0096A¢\u0006\u0004\b%\u0010&J\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0096A¢\u0006\u0004\b'\u0010&J\u0012\u0010)\u001a\u0004\u0018\u00018\u0000H\u0097A¢\u0006\u0004\b)\u0010&J\u0018\u0010*\u001a\u00020\n2\u0006\u0010\b\u001a\u00028\u0000H\u0096A¢\u0006\u0004\b*\u0010+J\u0016\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0096\u0001¢\u0006\u0004\b,\u0010$R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010.R\u0014\u0010/\u001a\u00020\u00108\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u00101\u001a\u00020\u00108\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b1\u00100R\u0014\u00102\u001a\u00020\u00108\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b2\u00100R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00028\u0000038\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b4\u00105R \u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t038\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b7\u00105R\u001c\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u0000038VX\u0097\u0005¢\u0006\u0006\u001a\u0004\b9\u00105R&\u0010?\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000<0;8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b=\u0010>¨\u0006A"}, d2 = {"Lio/ktor/websocket/BoundedChannel;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/Channel;", "", "capacity", "delegate", "<init>", "(ILkotlinx/coroutines/channels/Channel;)V", "element", "Lkotlinx/coroutines/channels/ChannelResult;", "", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "()V", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "close", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "handler", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/channels/ChannelIterator;", "iterator", "()Lkotlinx/coroutines/channels/ChannelIterator;", "offer", "(Ljava/lang/Object;)Z", "poll", "()Ljava/lang/Object;", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveCatching-JP2dKIU", "receiveCatching", "receiveOrNull", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryReceive-PtdJZtk", "tryReceive", "Lkotlinx/coroutines/channels/Channel;", "isClosedForReceive", "()Z", "isClosedForSend", "isEmpty", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceive", "getOnReceiveCatching", "onReceiveCatching", "getOnReceiveOrNull", "onReceiveOrNull", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "Companion", "ktor-websockets"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class BoundedChannel<T> implements Channel<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Channel<T> delegate;

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        this.delegate.cancel();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public void cancel(CancellationException cause) {
        this.delegate.cancel(cause);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean cancel(Throwable cause) {
        return this.delegate.cancel(cause);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable cause) {
        return this.delegate.close(cause);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<T> getOnReceive() {
        return this.delegate.getOnReceive();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<ChannelResult<T>> getOnReceiveCatching() {
        return this.delegate.getOnReceiveCatching();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<T> getOnReceiveOrNull() {
        return this.delegate.getOnReceiveOrNull();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public SelectClause2<T, SendChannel<T>> getOnSend() {
        return this.delegate.getOnSend();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(Function1<? super Throwable, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.delegate.invokeOnClose(handler);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        return this.delegate.isClosedForReceive();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return this.delegate.isClosedForSend();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public ChannelIterator<T> iterator() {
        return this.delegate.iterator();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(T element) {
        return this.delegate.offer(element);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
    public T poll() {
        return this.delegate.poll();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object receive(Continuation<? super T> continuation) {
        return this.delegate.receive(continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* JADX INFO: renamed from: receiveCatching-JP2dKIU, reason: not valid java name */
    public Object mo12663receiveCatchingJP2dKIU(Continuation<? super ChannelResult<? extends T>> continuation) {
        Object obj = this.delegate.mo12663receiveCatchingJP2dKIU(continuation);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return obj;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    public Object receiveOrNull(Continuation<? super T> continuation) {
        return this.delegate.receiveOrNull(continuation);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object send(T t, Continuation<? super Unit> continuation) {
        return this.delegate.send(t, continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* JADX INFO: renamed from: tryReceive-PtdJZtk, reason: not valid java name */
    public Object mo12664tryReceivePtdJZtk() {
        return this.delegate.mo12664tryReceivePtdJZtk();
    }

    public BoundedChannel(int i, Channel<T> delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    public /* synthetic */ BoundedChannel(int i, Channel channel, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? INSTANCE.createDelegate(i) : channel);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public Object mo12563trySendJP2dKIU(T element) {
        Object obj = this.delegate.mo12563trySendJP2dKIU(element);
        if (!ChannelResult.m14245isSuccessimpl(obj) && !ChannelResult.m14243isClosedimpl(obj)) {
            close(new ChannelOverflowException("Channel overflowed"));
        }
        return obj;
    }

    /* JADX INFO: compiled from: WebSocketChannelsConfig.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007\"\u0004\b\u0001\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lio/ktor/websocket/BoundedChannel$Companion;", "", "<init>", "()V", ExifInterface.GPS_DIRECTION_TRUE, "", "capacity", "Lkotlinx/coroutines/channels/Channel;", "createDelegate", "(I)Lkotlinx/coroutines/channels/Channel;", "ktor-websockets"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Type inference failed for: r3v1, types: [T, kotlinx.coroutines.channels.Channel, kotlinx.coroutines.channels.Channel<T>] */
        public final <T> Channel<T> createDelegate(int capacity) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ?? r3 = (T) ChannelKt.Channel(capacity, BufferOverflow.DROP_OLDEST, new Function1() { // from class: io.ktor.websocket.BoundedChannel$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BoundedChannel.Companion.createDelegate$lambda$0(objectRef, obj);
                }
            });
            objectRef.element = r3;
            return r3;
        }

        static final Unit createDelegate$lambda$0(Ref.ObjectRef objectRef, Object obj) {
            Channel channel;
            Channel channel2 = null;
            if (objectRef.element == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channel");
                channel = null;
            } else {
                channel = (Channel) objectRef.element;
            }
            if (!channel.isClosedForSend()) {
                if (objectRef.element == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("channel");
                } else {
                    channel2 = (Channel) objectRef.element;
                }
                channel2.close(new ChannelOverflowException("Channel overflowed"));
            }
            return Unit.INSTANCE;
        }
    }
}

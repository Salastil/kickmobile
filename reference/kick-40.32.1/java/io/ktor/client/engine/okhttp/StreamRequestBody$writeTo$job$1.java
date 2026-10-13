package io.ktor.client.engine.okhttp;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.streams.StreamsKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okio.BufferedSink;

/* JADX INFO: compiled from: StreamRequestBody.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.engine.okhttp.StreamRequestBody$writeTo$job$1", f = "StreamRequestBody.kt", i = {0}, l = {32}, m = "invokeSuspend", n = {"channel"}, s = {"L$0"}, v = 1)
final class StreamRequestBody$writeTo$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BufferedSink $sink;
    Object L$0;
    int label;
    final /* synthetic */ StreamRequestBody this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreamRequestBody$writeTo$job$1(StreamRequestBody streamRequestBody, BufferedSink bufferedSink, Continuation<? super StreamRequestBody$writeTo$job$1> continuation) {
        super(2, continuation);
        this.this$0 = streamRequestBody;
        this.$sink = bufferedSink;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StreamRequestBody$writeTo$job$1(this.this$0, this.$sink, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StreamRequestBody$writeTo$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws IOException {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ByteReadChannel byteReadChannel = (ByteReadChannel) this.this$0.block.invoke();
                this.L$0 = SpillingKt.nullOutSpilledVariable(byteReadChannel);
                this.label = 1;
                obj = ByteReadChannelOperationsKt.copyTo(byteReadChannel, StreamsKt.asByteWriteChannel(this.$sink.outputStream()), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ((Number) obj).longValue();
            return Unit.INSTANCE;
        } catch (IOException e) {
            throw e;
        } catch (Throwable th) {
            throw new StreamAdapterIOException(th);
        }
    }
}

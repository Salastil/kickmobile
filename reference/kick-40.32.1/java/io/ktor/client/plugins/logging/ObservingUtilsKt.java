package io.ktor.client.plugins.logging;

import io.ktor.http.content.OutgoingContent;
import io.ktor.util.ByteChannelsKt;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.WriterScope;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: compiled from: ObservingUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0080@¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0013\u0010\u0007\u001a\u00020\u0006*\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/http/content/OutgoingContent;", "Lio/ktor/utils/io/ByteWriteChannel;", "log", "observe", "(Lio/ktor/http/content/OutgoingContent;Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/http/content/OutgoingContent$WriteChannelContent;", "Lio/ktor/utils/io/ByteReadChannel;", "toReadChannel", "(Lio/ktor/http/content/OutgoingContent$WriteChannelContent;)Lio/ktor/utils/io/ByteReadChannel;", "ktor-client-logging"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ObservingUtilsKt {

    /* JADX INFO: renamed from: io.ktor.client.plugins.logging.ObservingUtilsKt$observe$1, reason: invalid class name */
    /* JADX INFO: compiled from: ObservingUtils.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.logging.ObservingUtilsKt", f = "ObservingUtils.kt", i = {0, 0, 1, 1, 2, 2, 3, 3}, l = {14, 15, 31, 33}, m = "observe", n = {"$this$observe", "log", "$this$observe", "log", "$this$observe", "log", "$this$observe", "log"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ObservingUtilsKt.observe(null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00a2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object observe(OutgoingContent outgoingContent, ByteWriteChannel byteWriteChannel, Continuation<? super OutgoingContent> continuation) {
        AnonymousClass1 anonymousClass1;
        OutgoingContent.ContentWrapper contentWrapper;
        ByteWriteChannel byteWriteChannel2;
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
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object objObserve = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objObserve);
            if (outgoingContent instanceof OutgoingContent.ByteArrayContent) {
                byte[] content = ((OutgoingContent.ByteArrayContent) outgoingContent).getBytes();
                anonymousClass2.L$0 = outgoingContent;
                anonymousClass2.L$1 = byteWriteChannel;
                anonymousClass2.label = 1;
                if (ByteWriteChannelOperationsKt.writeFully$default(byteWriteChannel, content, 0, 0, anonymousClass2, 6, null) != coroutine_suspended) {
                    byteWriteChannel2 = byteWriteChannel;
                    anonymousClass2.L$0 = outgoingContent;
                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(byteWriteChannel2);
                    anonymousClass2.label = 2;
                    if (byteWriteChannel2.flushAndClose(anonymousClass2) == coroutine_suspended) {
                        return outgoingContent;
                    }
                }
            } else {
                if (outgoingContent instanceof OutgoingContent.ReadChannelContent) {
                    ByteChannel byteChannel = new ByteChannel(false, 1, null);
                    ByteChannelsKt.copyToBoth(((OutgoingContent.ReadChannelContent) outgoingContent).getChannel(), byteWriteChannel, byteChannel);
                    return new LoggedContent(outgoingContent, byteChannel);
                }
                if (outgoingContent instanceof OutgoingContent.WriteChannelContent) {
                    ByteChannel byteChannel2 = new ByteChannel(false, 1, null);
                    ByteChannelsKt.copyToBoth(toReadChannel((OutgoingContent.WriteChannelContent) outgoingContent), byteWriteChannel, byteChannel2);
                    return new LoggedContent(outgoingContent, byteChannel2);
                }
                if (outgoingContent instanceof OutgoingContent.ContentWrapper) {
                    OutgoingContent.ContentWrapper contentWrapper2 = (OutgoingContent.ContentWrapper) outgoingContent;
                    OutgoingContent delegate = contentWrapper2.getDelegate();
                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(outgoingContent);
                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(byteWriteChannel);
                    anonymousClass2.L$2 = contentWrapper2;
                    anonymousClass2.label = 3;
                    objObserve = observe(delegate, byteWriteChannel, anonymousClass2);
                    if (objObserve != coroutine_suspended) {
                        contentWrapper = contentWrapper2;
                        return contentWrapper.copy((OutgoingContent) objObserve);
                    }
                } else {
                    if (!(outgoingContent instanceof OutgoingContent.NoContent) && !(outgoingContent instanceof OutgoingContent.ProtocolUpgrade)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    anonymousClass2.L$0 = outgoingContent;
                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(byteWriteChannel);
                    anonymousClass2.label = 4;
                    if (byteWriteChannel.flushAndClose(anonymousClass2) != coroutine_suspended) {
                        return outgoingContent;
                    }
                }
            }
        } else {
            if (i != 1) {
                if (i == 2) {
                    OutgoingContent outgoingContent2 = (OutgoingContent) anonymousClass2.L$0;
                    ResultKt.throwOnFailure(objObserve);
                    return outgoingContent2;
                }
                if (i == 3) {
                    contentWrapper = (OutgoingContent.ContentWrapper) anonymousClass2.L$2;
                    ResultKt.throwOnFailure(objObserve);
                    return contentWrapper.copy((OutgoingContent) objObserve);
                }
                if (i != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                OutgoingContent outgoingContent3 = (OutgoingContent) anonymousClass2.L$0;
                ResultKt.throwOnFailure(objObserve);
                return outgoingContent3;
            }
            byteWriteChannel2 = (ByteWriteChannel) anonymousClass2.L$1;
            outgoingContent = (OutgoingContent) anonymousClass2.L$0;
            ResultKt.throwOnFailure(objObserve);
            anonymousClass2.L$0 = outgoingContent;
            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(byteWriteChannel2);
            anonymousClass2.label = 2;
            if (byteWriteChannel2.flushAndClose(anonymousClass2) == coroutine_suspended) {
                return outgoingContent;
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.logging.ObservingUtilsKt$toReadChannel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ObservingUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.logging.ObservingUtilsKt$toReadChannel$1", f = "ObservingUtils.kt", i = {0}, l = {41}, m = "invokeSuspend", n = {"$this$writer"}, s = {"L$0"}, v = 1)
    static final class C09791 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ OutgoingContent.WriteChannelContent $this_toReadChannel;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09791(OutgoingContent.WriteChannelContent writeChannelContent, Continuation<? super C09791> continuation) {
            super(2, continuation);
            this.$this_toReadChannel = writeChannelContent;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C09791 c09791 = new C09791(this.$this_toReadChannel, continuation);
            c09791.L$0 = obj;
            return c09791;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
            return ((C09791) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            WriterScope writerScope = (WriterScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.L$0 = SpillingKt.nullOutSpilledVariable(writerScope);
                this.label = 1;
                if (this.$this_toReadChannel.writeTo(writerScope.getChannel(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    private static final ByteReadChannel toReadChannel(OutgoingContent.WriteChannelContent writeChannelContent) {
        return ByteWriteChannelOperationsKt.writer$default((CoroutineScope) GlobalScope.INSTANCE, (CoroutineContext) Dispatchers.getDefault(), false, (Function2) new C09791(writeChannelContent, null), 2, (Object) null).getChannel();
    }
}

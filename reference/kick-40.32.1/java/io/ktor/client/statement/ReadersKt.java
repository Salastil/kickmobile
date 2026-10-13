package io.ktor.client.statement;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlinx.io.Source;
import kotlinx.io.SourcesKt;

/* JADX INFO: compiled from: Readers.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0014\u0010\u0006\u001a\u00020\u0003*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u0000H\u0087@¢\u0006\u0004\b\u0004\u0010\u0007\u001a\u0014\u0010\t\u001a\u00020\b*\u00020\u0000H\u0086@¢\u0006\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lio/ktor/client/statement/HttpResponse;", "", "count", "", "readBytes", "(Lio/ktor/client/statement/HttpResponse;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readRawBytes", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "discardRemaining", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ReadersKt {

    /* JADX INFO: renamed from: io.ktor.client.statement.ReadersKt$readBytes$1, reason: invalid class name */
    /* JADX INFO: compiled from: Readers.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.ReadersKt", f = "Readers.kt", i = {0, 0, 0, 0}, l = {17}, m = "readBytes", n = {"$this$readBytes", "it", "count", "$i$a$-also-ReadersKt$readBytes$2"}, s = {"L$0", "L$2", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
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
            return ReadersKt.readBytes(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.statement.ReadersKt$readBytes$3, reason: invalid class name */
    /* JADX INFO: compiled from: Readers.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.ReadersKt", f = "Readers.kt", i = {0}, l = {53}, m = "readBytes", n = {"$this$readBytes"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass3 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReadersKt.readBytes(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.statement.ReadersKt$readRawBytes$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Readers.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.ReadersKt", f = "Readers.kt", i = {0}, l = {35}, m = "readRawBytes", n = {"$this$readRawBytes"}, s = {"L$0"}, v = 1)
    static final class C10231 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10231(Continuation<? super C10231> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReadersKt.readRawBytes(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object readBytes(HttpResponse httpResponse, int i, Continuation<? super byte[]> continuation) {
        AnonymousClass1 anonymousClass1;
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
        Object obj = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass2.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i3 = anonymousClass2.I$1;
            int i4 = anonymousClass2.I$0;
            byte[] bArr = (byte[]) anonymousClass2.L$1;
            ResultKt.throwOnFailure(obj);
            return bArr;
        }
        ResultKt.throwOnFailure(obj);
        byte[] bArr2 = new byte[i];
        ByteReadChannel rawContent = httpResponse.getRawContent();
        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(httpResponse);
        anonymousClass2.L$1 = bArr2;
        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(bArr2);
        anonymousClass2.I$0 = i;
        anonymousClass2.I$1 = 0;
        anonymousClass2.label = 1;
        return ByteReadChannelOperationsKt.readFully$default(rawContent, bArr2, 0, 0, anonymousClass2, 6, null) == coroutine_suspended ? coroutine_suspended : bArr2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object readRawBytes(HttpResponse httpResponse, Continuation<? super byte[]> continuation) throws Throwable {
        C10231 c10231;
        if (continuation instanceof C10231) {
            c10231 = (C10231) continuation;
            if ((c10231.label & Integer.MIN_VALUE) != 0) {
                c10231.label -= Integer.MIN_VALUE;
            } else {
                c10231 = new C10231(continuation);
            }
        } else {
            c10231 = new C10231(continuation);
        }
        Object remaining = c10231.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10231.label;
        if (i == 0) {
            ResultKt.throwOnFailure(remaining);
            ByteReadChannel rawContent = httpResponse.getRawContent();
            c10231.L$0 = SpillingKt.nullOutSpilledVariable(httpResponse);
            c10231.label = 1;
            remaining = ByteReadChannelOperationsKt.readRemaining(rawContent, c10231);
            if (remaining == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(remaining);
        }
        return SourcesKt.readByteArray((Source) remaining);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Deprecated(message = "This method was renamed to readRawBytes() to reflect what it does.", replaceWith = @ReplaceWith(expression = "readRawBytes()", imports = {}))
    public static final Object readBytes(HttpResponse httpResponse, Continuation<? super byte[]> continuation) throws Throwable {
        AnonymousClass3 anonymousClass3;
        if (continuation instanceof AnonymousClass3) {
            anonymousClass3 = (AnonymousClass3) continuation;
            if ((anonymousClass3.label & Integer.MIN_VALUE) != 0) {
                anonymousClass3.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass3 = new AnonymousClass3(continuation);
            }
        } else {
            anonymousClass3 = new AnonymousClass3(continuation);
        }
        Object remaining = anonymousClass3.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass3.label;
        if (i == 0) {
            ResultKt.throwOnFailure(remaining);
            ByteReadChannel rawContent = httpResponse.getRawContent();
            anonymousClass3.L$0 = SpillingKt.nullOutSpilledVariable(httpResponse);
            anonymousClass3.label = 1;
            remaining = ByteReadChannelOperationsKt.readRemaining(rawContent, anonymousClass3);
            if (remaining == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(remaining);
        }
        return SourcesKt.readByteArray((Source) remaining);
    }

    public static final Object discardRemaining(HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        Object objDiscard$default = ByteReadChannelOperationsKt.discard$default(httpResponse.getRawContent(), 0L, continuation, 1, null);
        return objDiscard$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDiscard$default : Unit.INSTANCE;
    }
}

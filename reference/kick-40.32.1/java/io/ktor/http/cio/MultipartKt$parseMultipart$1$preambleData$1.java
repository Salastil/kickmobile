package io.ktor.http.cio;

import io.ktor.utils.io.CountedByteReadChannel;
import io.ktor.utils.io.WriterScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.io.bytestring.ByteString;

/* JADX INFO: compiled from: Multipart.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.http.cio.MultipartKt$parseMultipart$1$preambleData$1", f = "Multipart.kt", i = {0, 1}, l = {206, 207}, m = "invokeSuspend", n = {"$this$writer", "$this$writer"}, s = {"L$0", "L$0"}, v = 1)
final class MultipartKt$parseMultipart$1$preambleData$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CountedByteReadChannel $countedInput;
    final /* synthetic */ ByteString $firstBoundary;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MultipartKt$parseMultipart$1$preambleData$1(ByteString byteString, CountedByteReadChannel countedByteReadChannel, Continuation<? super MultipartKt$parseMultipart$1$preambleData$1> continuation) {
        super(2, continuation);
        this.$firstBoundary = byteString;
        this.$countedInput = countedByteReadChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MultipartKt$parseMultipart$1$preambleData$1 multipartKt$parseMultipart$1$preambleData$1 = new MultipartKt$parseMultipart$1$preambleData$1(this.$firstBoundary, this.$countedInput, continuation);
        multipartKt$parseMultipart$1$preambleData$1.L$0 = obj;
        return multipartKt$parseMultipart$1$preambleData$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
        return ((MultipartKt$parseMultipart$1$preambleData$1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0054, code lost:
    
        if (r0.getChannel().flushAndClose(r10) == r1) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = r10.L$0
            io.ktor.utils.io.WriterScope r0 = (io.ktor.utils.io.WriterScope) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r10.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L22
            if (r2 == r4) goto L1e
            if (r2 != r3) goto L16
            kotlin.ResultKt.throwOnFailure(r11)
            goto L57
        L16:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L1e:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L41
        L22:
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = r4
            kotlinx.io.bytestring.ByteString r4 = r10.$firstBoundary
            io.ktor.utils.io.CountedByteReadChannel r2 = r10.$countedInput
            r5 = r2
            io.ktor.utils.io.ByteReadChannel r5 = (io.ktor.utils.io.ByteReadChannel) r5
            io.ktor.utils.io.ByteWriteChannel r6 = r0.getChannel()
            r9 = r10
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r10.L$0 = r0
            r10.label = r11
            r7 = 8193(0x2001, double:4.048E-320)
            java.lang.Object r11 = io.ktor.http.cio.MultipartKt.access$parsePreambleImpl(r4, r5, r6, r7, r9)
            if (r11 != r1) goto L41
            goto L56
        L41:
            io.ktor.utils.io.ByteWriteChannel r11 = r0.getChannel()
            r2 = r10
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r10.L$0 = r0
            r10.label = r3
            java.lang.Object r10 = r11.flushAndClose(r2)
            if (r10 != r1) goto L57
        L56:
            return r1
        L57:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.MultipartKt$parseMultipart$1$preambleData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

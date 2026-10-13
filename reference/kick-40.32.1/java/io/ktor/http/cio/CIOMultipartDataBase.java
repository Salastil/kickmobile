package io.ktor.http.cio;

import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import io.ktor.http.ContentDisposition;
import io.ktor.http.content.MultiPartData;
import io.ktor.http.content.PartData;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.DeprecationKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.io.Source;
import org.bouncycastle.asn1.eac.EACTags;

/* JADX INFO: compiled from: CIOMultipartDataBase.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0082@¢\u0006\u0004\b\u0011\u0010\u0010J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0013\u001a\u00020\u0012H\u0082@¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0016H\u0082@¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00120\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006\""}, d2 = {"Lio/ktor/http/cio/CIOMultipartDataBase;", "Lio/ktor/http/content/MultiPartData;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lio/ktor/utils/io/ByteReadChannel;", "channel", "", "contentType", "", "contentLength", "formFieldLimit", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lio/ktor/utils/io/ByteReadChannel;Ljava/lang/CharSequence;Ljava/lang/Long;J)V", "Lio/ktor/http/content/PartData;", "readPart", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readPartSuspend", "Lio/ktor/http/cio/MultipartEvent;", "event", "eventToData", "(Lio/ktor/http/cio/MultipartEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/http/cio/MultipartEvent$MultipartPart;", "part", "partToData", "(Lio/ktor/http/cio/MultipartEvent$MultipartPart;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "previousPart", "Lio/ktor/http/content/PartData;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "events", "Lkotlinx/coroutines/channels/ReceiveChannel;", "ktor-http-cio"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CIOMultipartDataBase implements MultiPartData, CoroutineScope {
    private final CoroutineContext coroutineContext;
    private final ReceiveChannel<MultipartEvent> events;
    private PartData previousPart;

    /* JADX INFO: renamed from: io.ktor.http.cio.CIOMultipartDataBase$eventToData$1, reason: invalid class name */
    /* JADX INFO: compiled from: CIOMultipartDataBase.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.CIOMultipartDataBase", f = "CIOMultipartDataBase.kt", i = {0}, l = {62}, m = "eventToData", n = {"event"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CIOMultipartDataBase.this.eventToData(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.CIOMultipartDataBase$partToData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CIOMultipartDataBase.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.CIOMultipartDataBase", f = "CIOMultipartDataBase.kt", i = {0, 1, 1, 1, 1, 1}, l = {75, EACTags.HISTORICAL_BYTES}, m = "partToData", n = {"part", "part", "headers", "contentDisposition", "filename", ExpoNotificationBuilder.EXTRAS_BODY_KEY}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 1)
    static final class C10271 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C10271(Continuation<? super C10271> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CIOMultipartDataBase.this.partToData(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.CIOMultipartDataBase$readPart$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CIOMultipartDataBase.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.CIOMultipartDataBase", f = "CIOMultipartDataBase.kt", i = {0}, l = {39, 45}, m = "readPart", n = {"event"}, s = {"L$0"}, v = 1)
    static final class C10281 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10281(Continuation<? super C10281> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CIOMultipartDataBase.this.readPart(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.CIOMultipartDataBase$readPartSuspend$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CIOMultipartDataBase.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.CIOMultipartDataBase", f = "CIOMultipartDataBase.kt", i = {1}, l = {51, 52}, m = "readPartSuspend", n = {"event"}, s = {"L$0"}, v = 1)
    static final class C10291 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10291(Continuation<? super C10291> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CIOMultipartDataBase.this.readPartSuspend(this);
        }
    }

    public CIOMultipartDataBase(CoroutineContext coroutineContext, ByteReadChannel channel, CharSequence contentType, Long l, long j) {
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        this.coroutineContext = coroutineContext;
        this.events = MultipartKt.parseMultipart(this, channel, contentType, l, j);
    }

    public /* synthetic */ CIOMultipartDataBase(CoroutineContext coroutineContext, ByteReadChannel byteReadChannel, CharSequence charSequence, Long l, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineContext, byteReadChannel, charSequence, l, (i & 16) != 0 ? 65536L : j);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x005b  */
    /* JADX WARN: Code duplicated, block: B:27:0x0067 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x0068  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:
    
        if (r6 == r1) goto L30;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0074 -> B:31:0x0077). Please report as a decompilation issue!!! */
    @Override // io.ktor.http.content.MultiPartData
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object readPart(kotlin.coroutines.Continuation<? super io.ktor.http.content.PartData> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof io.ktor.http.cio.CIOMultipartDataBase.C10281
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.http.cio.CIOMultipartDataBase$readPart$1 r0 = (io.ktor.http.cio.CIOMultipartDataBase.C10281) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.http.cio.CIOMultipartDataBase$readPart$1 r0 = new io.ktor.http.cio.CIOMultipartDataBase$readPart$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r6)
            return r6
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            java.lang.Object r2 = r0.L$0
            io.ktor.http.cio.MultipartEvent r2 = (io.ktor.http.cio.MultipartEvent) r2
            kotlin.ResultKt.throwOnFailure(r6)
            goto L77
        L3d:
            kotlin.ResultKt.throwOnFailure(r6)
            io.ktor.http.content.PartData r6 = r5.previousPart
            if (r6 == 0) goto L4d
            kotlin.jvm.functions.Function0 r6 = r6.getDispose()
            if (r6 == 0) goto L4d
            r6.invoke()
        L4d:
            kotlinx.coroutines.channels.ReceiveChannel<io.ktor.http.cio.MultipartEvent> r6 = r5.events
            java.lang.Object r6 = r6.mo12664tryReceivePtdJZtk()
            java.lang.Object r6 = kotlinx.coroutines.channels.ChannelResult.m14240getOrNullimpl(r6)
            io.ktor.http.cio.MultipartEvent r6 = (io.ktor.http.cio.MultipartEvent) r6
            if (r6 != 0) goto L68
            r6 = 0
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r5 = r5.readPartSuspend(r0)
            if (r5 != r1) goto L67
            goto L76
        L67:
            return r5
        L68:
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r6 = r5.eventToData(r6, r0)
            if (r6 != r1) goto L77
        L76:
            return r1
        L77:
            io.ktor.http.content.PartData r6 = (io.ktor.http.content.PartData) r6
            if (r6 == 0) goto L4d
            r5.previousPart = r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.CIOMultipartDataBase.readPart(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:22:0x004d  */
    /* JADX WARN: Code duplicated, block: B:23:0x004e A[Catch: ClosedReceiveChannelException -> 0x0064, PHI: r7
      0x004e: PHI (r7v2 java.lang.Object) = (r7v6 java.lang.Object), (r7v1 java.lang.Object) binds: [B:21:0x004b, B:17:0x003a] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {ClosedReceiveChannelException -> 0x0064, blocks: (B:13:0x002e, B:26:0x005f, B:20:0x0041, B:23:0x004e, B:17:0x003a), top: B:30:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005c, code lost:
    
        if (r7 == r1) goto L25;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005c -> B:26:0x005f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readPartSuspend(kotlin.coroutines.Continuation<? super io.ktor.http.content.PartData> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof io.ktor.http.cio.CIOMultipartDataBase.C10291
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.http.cio.CIOMultipartDataBase$readPartSuspend$1 r0 = (io.ktor.http.cio.CIOMultipartDataBase.C10291) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.http.cio.CIOMultipartDataBase$readPartSuspend$1 r0 = new io.ktor.http.cio.CIOMultipartDataBase$readPartSuspend$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L3e
            if (r2 == r5) goto L3a
            if (r2 != r4) goto L32
            java.lang.Object r2 = r0.L$0
            io.ktor.http.cio.MultipartEvent r2 = (io.ktor.http.cio.MultipartEvent) r2
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L64
            goto L5f
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L64
            goto L4e
        L3e:
            kotlin.ResultKt.throwOnFailure(r7)
        L41:
            kotlinx.coroutines.channels.ReceiveChannel<io.ktor.http.cio.MultipartEvent> r7 = r6.events     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L64
            r0.L$0 = r3     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L64
            r0.label = r5     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L64
            java.lang.Object r7 = r7.receive(r0)     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L64
            if (r7 != r1) goto L4e
            goto L5e
        L4e:
            io.ktor.http.cio.MultipartEvent r7 = (io.ktor.http.cio.MultipartEvent) r7     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L64
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L64
            r0.L$0 = r2     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L64
            r0.label = r4     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L64
            java.lang.Object r7 = r6.eventToData(r7, r0)     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L64
            if (r7 != r1) goto L5f
        L5e:
            return r1
        L5f:
            io.ktor.http.content.PartData r7 = (io.ktor.http.content.PartData) r7     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L64
            if (r7 == 0) goto L41
            return r7
        L64:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.CIOMultipartDataBase.readPartSuspend(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object eventToData(MultipartEvent multipartEvent, Continuation<? super PartData> continuation) {
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
        Object objPartToData = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objPartToData);
                if (!(multipartEvent instanceof MultipartEvent.MultipartPart)) {
                    multipartEvent.release();
                    return null;
                }
                anonymousClass1.L$0 = multipartEvent;
                anonymousClass1.label = 1;
                objPartToData = partToData((MultipartEvent.MultipartPart) multipartEvent, anonymousClass1);
                if (objPartToData == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objPartToData);
            }
            return (PartData) objPartToData;
        } catch (Throwable th) {
            multipartEvent.release();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object partToData(final MultipartEvent.MultipartPart multipartPart, Continuation<? super PartData> continuation) throws Throwable {
        C10271 c10271;
        final MultipartEvent.MultipartPart multipartPart2;
        HttpHeadersMap httpHeadersMap;
        Source source;
        if (continuation instanceof C10271) {
            c10271 = (C10271) continuation;
            if ((c10271.label & Integer.MIN_VALUE) != 0) {
                c10271.label -= Integer.MIN_VALUE;
            } else {
                c10271 = new C10271(continuation);
            }
        } else {
            c10271 = new C10271(continuation);
        }
        Object objAwait = c10271.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10271.label;
        if (i != 0) {
            if (i == 1) {
                multipartPart = (MultipartEvent.MultipartPart) c10271.L$0;
                ResultKt.throwOnFailure(objAwait);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                httpHeadersMap = (HttpHeadersMap) c10271.L$1;
                multipartPart2 = (MultipartEvent.MultipartPart) c10271.L$0;
                ResultKt.throwOnFailure(objAwait);
            }
            source = (Source) objAwait;
            try {
                PartData.FormItem formItem = new PartData.FormItem(DeprecationKt.readText(source), new Function0() { // from class: io.ktor.http.cio.CIOMultipartDataBase$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CIOMultipartDataBase.partToData$lambda$1$0(multipartPart2);
                    }
                }, new CIOHeaders(httpHeadersMap));
                AutoCloseableKt.closeFinally(source, null);
                return formItem;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    AutoCloseableKt.closeFinally(source, th);
                    throw th2;
                }
            }
        }
        ResultKt.throwOnFailure(objAwait);
        Deferred<HttpHeadersMap> headers = multipartPart.getHeaders();
        c10271.L$0 = multipartPart;
        c10271.label = 1;
        objAwait = headers.await(c10271);
        if (objAwait != coroutine_suspended) {
        }
        return coroutine_suspended;
        HttpHeadersMap httpHeadersMap2 = (HttpHeadersMap) objAwait;
        CharSequence charSequence = httpHeadersMap2.get("Content-Disposition");
        ContentDisposition contentDisposition = charSequence != null ? ContentDisposition.INSTANCE.parse(charSequence.toString()) : null;
        String strParameter = contentDisposition != null ? contentDisposition.parameter("filename") : null;
        ByteReadChannel body = multipartPart.getBody();
        if (strParameter == null) {
            c10271.L$0 = multipartPart;
            c10271.L$1 = httpHeadersMap2;
            c10271.L$2 = SpillingKt.nullOutSpilledVariable(contentDisposition);
            c10271.L$3 = SpillingKt.nullOutSpilledVariable(strParameter);
            c10271.L$4 = SpillingKt.nullOutSpilledVariable(body);
            c10271.label = 2;
            Object remaining = ByteReadChannelOperationsKt.readRemaining(body, c10271);
            if (remaining != coroutine_suspended) {
                multipartPart2 = multipartPart;
                httpHeadersMap = httpHeadersMap2;
                objAwait = remaining;
                source = (Source) objAwait;
                PartData.FormItem formItem2 = new PartData.FormItem(DeprecationKt.readText(source), new Function0() { // from class: io.ktor.http.cio.CIOMultipartDataBase$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CIOMultipartDataBase.partToData$lambda$1$0(multipartPart2);
                    }
                }, new CIOHeaders(httpHeadersMap));
                AutoCloseableKt.closeFinally(source, null);
                return formItem2;
            }
            return coroutine_suspended;
        }
        return new PartData.FileItem(new Function0() { // from class: io.ktor.http.cio.CIOMultipartDataBase$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return multipartPart.getBody();
            }
        }, new Function0() { // from class: io.ktor.http.cio.CIOMultipartDataBase$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CIOMultipartDataBase.partToData$lambda$3(multipartPart);
            }
        }, new CIOHeaders(httpHeadersMap2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit partToData$lambda$1$0(MultipartEvent.MultipartPart multipartPart) throws InterruptedException {
        multipartPart.release();
        return Unit.INSTANCE;
    }

    static final Unit partToData$lambda$3(MultipartEvent.MultipartPart multipartPart) throws InterruptedException {
        multipartPart.release();
        return Unit.INSTANCE;
    }
}

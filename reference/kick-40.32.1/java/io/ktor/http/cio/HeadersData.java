package io.ktor.http.cio;

import androidx.mediarouter.media.GlobalMediaRouter;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: HttpHeadersMap.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0015\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0003R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lio/ktor/http/cio/HeadersData;", "", "<init>", "()V", "", "arraysCount", "()I", "subArraysCount", "", "prepare", "(I)V", FirebaseAnalytics.Param.INDEX, "at", "(I)I", "value", "set", "(II)V", "Lkotlin/sequences/Sequence;", "headersStarts", "()Lkotlin/sequences/Sequence;", "release", "", "", "arrays", "Ljava/util/List;", "ktor-http-cio"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class HeadersData {
    private List<int[]> arrays = new ArrayList();

    public final int arraysCount() {
        return this.arrays.size();
    }

    public final void prepare(int subArraysCount) {
        for (int i = 0; i < subArraysCount; i++) {
            this.arrays.add((int[]) HttpHeadersMapKt.IntArrayPool.borrow());
        }
    }

    public final int at(int index) {
        return this.arrays.get(index / 768)[index % 768];
    }

    public final void set(int index, int value) {
        this.arrays.get(index / 768)[index % 768] = value;
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.HeadersData$headersStarts$1, reason: invalid class name */
    /* JADX INFO: compiled from: HttpHeadersMap.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.HeadersData$headersStarts$1", f = "HttpHeadersMap.kt", i = {0, 0, 0, 0}, l = {GlobalMediaRouter.CallbackHandler.MSG_ROUTE_ANOTHER_SELECTED}, m = "invokeSuspend", n = {"$this$sequence", "arr", "joinedIndex", "localIndex"}, s = {"L$0", "L$2", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Integer>, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = HeadersData.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceScope<? super Integer> sequenceScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x003c  */
        /* JADX WARN: Code duplicated, block: B:22:0x0072  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x003c -> B:12:0x0045). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x004f -> B:21:0x006d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x006b -> B:20:0x006c). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = r9.L$0
                kotlin.sequences.SequenceScope r0 = (kotlin.sequences.SequenceScope) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r9.label
                r3 = 0
                r4 = 1
                if (r2 == 0) goto L28
                if (r2 != r4) goto L20
                int r2 = r9.I$1
                int r5 = r9.I$0
                java.lang.Object r6 = r9.L$2
                int[] r6 = (int[]) r6
                java.lang.Object r7 = r9.L$1
                java.util.Iterator r7 = (java.util.Iterator) r7
                kotlin.ResultKt.throwOnFailure(r10)
                goto L6c
            L20:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L28:
                kotlin.ResultKt.throwOnFailure(r10)
                io.ktor.http.cio.HeadersData r10 = io.ktor.http.cio.HeadersData.this
                java.util.List r10 = io.ktor.http.cio.HeadersData.access$getArrays$p(r10)
                java.util.Iterator r10 = r10.iterator()
                r2 = r3
            L36:
                boolean r5 = r10.hasNext()
                if (r5 == 0) goto L74
                java.lang.Object r5 = r10.next()
                int[] r5 = (int[]) r5
                r6 = r5
                r5 = r2
                r2 = r3
            L45:
                int r7 = r6.length
                if (r2 >= r7) goto L72
                io.ktor.http.cio.HeadersData r7 = io.ktor.http.cio.HeadersData.this
                int r7 = r7.at(r5)
                r8 = -1
                if (r7 == r8) goto L6d
                java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)
                r8 = r9
                kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
                r9.L$0 = r0
                r9.L$1 = r10
                r9.L$2 = r6
                r9.I$0 = r5
                r9.I$1 = r2
                r9.label = r4
                java.lang.Object r7 = r0.yield(r7, r8)
                if (r7 != r1) goto L6b
                return r1
            L6b:
                r7 = r10
            L6c:
                r10 = r7
            L6d:
                int r2 = r2 + 6
                int r5 = r5 + 6
                goto L45
            L72:
                r2 = r5
                goto L36
            L74:
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.HeadersData.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Sequence<Integer> headersStarts() {
        return SequencesKt.sequence(new AnonymousClass1(null));
    }

    public final void release() {
        Iterator<int[]> it = this.arrays.iterator();
        while (it.hasNext()) {
            HttpHeadersMapKt.IntArrayPool.recycle(it.next());
        }
        this.arrays.clear();
    }
}

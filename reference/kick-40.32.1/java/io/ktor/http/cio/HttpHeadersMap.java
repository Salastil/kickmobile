package io.ktor.http.cio;

import com.facebook.imagepipeline.common.RotationOptions;
import io.ktor.http.ContentDisposition;
import io.ktor.http.cio.internals.CharArrayBuilder;
import io.ktor.http.cio.internals.CharsKt;
import java.io.IOException;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: HttpHeadersMap.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00122\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012¢\u0006\u0004\b\u0015\u0010\u0016J?\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ-\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b¢\u0006\u0004\b\u001e\u0010 J\u0017\u0010\"\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000bH\u0007¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000bH\u0007¢\u0006\u0004\b&\u0010%J\u000f\u0010'\u001a\u00020\u001dH\u0002¢\u0006\u0004\b'\u0010(J\u001f\u0010*\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u000bH\u0002¢\u0006\u0004\b*\u0010+J\u0015\u0010,\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u000b¢\u0006\u0004\b,\u0010%J\u0015\u0010-\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u000b¢\u0006\u0004\b-\u0010%J\r\u0010.\u001a\u00020\u001d¢\u0006\u0004\b.\u0010(J\u0011\u0010/\u001a\u00020\tH\u0096\u0080\u0004¢\u0006\u0004\b/\u00100R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00101R$\u00103\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0016\u00107\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00104R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006;"}, d2 = {"Lio/ktor/http/cio/HttpHeadersMap;", "", "Lio/ktor/http/cio/internals/CharArrayBuilder;", "builder", "<init>", "(Lio/ktor/http/cio/internals/CharArrayBuilder;)V", "", "thresholdReached", "()Z", "", "name", "", "fromIndex", "find", "(Ljava/lang/String;I)I", "", "get", "(Ljava/lang/String;)Ljava/lang/CharSequence;", "Lkotlin/sequences/Sequence;", "getAll", "(Ljava/lang/String;)Lkotlin/sequences/Sequence;", "offsets", "()Lkotlin/sequences/Sequence;", "nameHash", "valueHash", "nameStartIndex", "nameEndIndex", "valueStartIndex", "valueEndIndex", "", "put", "(IIIIII)V", "(IIII)V", "idx", "idxToOffset", "(I)I", "nameAt", "(I)Ljava/lang/CharSequence;", "valueAt", "resize", "()V", "headerOffset", "headerHasName", "(Ljava/lang/CharSequence;I)Z", "nameAtOffset", "valueAtOffset", "release", "toString", "()Ljava/lang/String;", "Lio/ktor/http/cio/internals/CharArrayBuilder;", "value", ContentDisposition.Parameters.Size, "I", "getSize", "()I", "headerCapacity", "Lio/ktor/http/cio/HeadersData;", "headersData", "Lio/ktor/http/cio/HeadersData;", "ktor-http-cio"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HttpHeadersMap {
    private final CharArrayBuilder builder;
    private int headerCapacity;
    private HeadersData headersData;
    private int size;

    public HttpHeadersMap(CharArrayBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
        this.headersData = (HeadersData) HttpHeadersMapKt.HeadersDataPool.borrow();
    }

    public final int getSize() {
        return this.size;
    }

    private final boolean thresholdReached() {
        return ((double) this.size) >= ((double) this.headerCapacity) * 0.75d;
    }

    public static /* synthetic */ int find$default(HttpHeadersMap httpHeadersMap, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return httpHeadersMap.find(str, i);
    }

    @Deprecated(message = "Use getAll instead", replaceWith = @ReplaceWith(expression = "getAll(name)", imports = {}))
    public final int find(String name, int fromIndex) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (this.size == 0) {
            return -1;
        }
        int iIdxToOffset = idxToOffset(fromIndex);
        while (this.headersData.at(iIdxToOffset) != -1) {
            if (headerHasName(name, iIdxToOffset)) {
                return fromIndex;
            }
            fromIndex++;
            iIdxToOffset = (iIdxToOffset / 6) % this.headerCapacity;
        }
        return -1;
    }

    public final CharSequence get(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (this.size == 0) {
            return null;
        }
        String str = name;
        int iAbs = Math.abs(CharsKt.hashCodeLowerCase$default(str, 0, 0, 3, null));
        int i = this.headerCapacity;
        while (true) {
            int i2 = iAbs % i;
            int i3 = i2 * 6;
            if (this.headersData.at(i3) == -1) {
                return null;
            }
            if (headerHasName(str, i3)) {
                return valueAtOffset(i3);
            }
            iAbs = i2 + 1;
            i = this.headerCapacity;
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.HttpHeadersMap$getAll$1, reason: invalid class name */
    /* JADX INFO: compiled from: HttpHeadersMap.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.HttpHeadersMap$getAll$1", f = "HttpHeadersMap.kt", i = {0, 0, 0}, l = {RotationOptions.ROTATE_90}, m = "invokeSuspend", n = {"$this$sequence", "hash", "headerIndex"}, s = {"L$0", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super CharSequence>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $name;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$name = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = HttpHeadersMap.this.new AnonymousClass1(this.$name, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceScope<? super CharSequence> sequenceScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0054  */
        /* JADX WARN: Code duplicated, block: B:19:0x0077 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:23:0x0089 A[LOOP:0: B:13:0x0046->B:23:0x0089, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:26:0x0062 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0075 -> B:20:0x0078). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = r8.L$0
                kotlin.sequences.SequenceScope r0 = (kotlin.sequences.SequenceScope) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r8.label
                r3 = -1
                r4 = 1
                if (r2 == 0) goto L20
                if (r2 != r4) goto L18
                int r2 = r8.I$1
                int r5 = r8.I$0
                kotlin.ResultKt.throwOnFailure(r9)
                goto L78
            L18:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L20:
                kotlin.ResultKt.throwOnFailure(r9)
                io.ktor.http.cio.HttpHeadersMap r9 = io.ktor.http.cio.HttpHeadersMap.this
                int r9 = r9.getSize()
                if (r9 != 0) goto L2e
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            L2e:
                java.lang.String r9 = r8.$name
                java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                r2 = 3
                r5 = 0
                r6 = 0
                int r9 = io.ktor.http.cio.internals.CharsKt.hashCodeLowerCase$default(r9, r6, r6, r2, r5)
                int r9 = java.lang.Math.abs(r9)
                io.ktor.http.cio.HttpHeadersMap r2 = io.ktor.http.cio.HttpHeadersMap.this
                int r2 = io.ktor.http.cio.HttpHeadersMap.access$getHeaderCapacity$p(r2)
                int r2 = r9 % r2
                r5 = r9
            L46:
                io.ktor.http.cio.HttpHeadersMap r9 = io.ktor.http.cio.HttpHeadersMap.this
                io.ktor.http.cio.HeadersData r9 = io.ktor.http.cio.HttpHeadersMap.access$getHeadersData$p(r9)
                int r6 = r2 * 6
                int r9 = r9.at(r6)
                if (r9 == r3) goto L91
                io.ktor.http.cio.HttpHeadersMap r9 = io.ktor.http.cio.HttpHeadersMap.this
                java.lang.String r7 = r8.$name
                java.lang.CharSequence r7 = (java.lang.CharSequence) r7
                boolean r9 = io.ktor.http.cio.HttpHeadersMap.access$headerHasName(r9, r7, r6)
                io.ktor.http.cio.HttpHeadersMap r7 = io.ktor.http.cio.HttpHeadersMap.this
                if (r9 == 0) goto L89
                java.lang.CharSequence r9 = r7.valueAtOffset(r6)
                r6 = r8
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r8.L$0 = r0
                r8.I$0 = r5
                r8.I$1 = r2
                r8.label = r4
                java.lang.Object r9 = r0.yield(r9, r6)
                if (r9 != r1) goto L78
                return r1
            L78:
                io.ktor.http.cio.HttpHeadersMap r9 = io.ktor.http.cio.HttpHeadersMap.this
                io.ktor.http.cio.HeadersData r9 = io.ktor.http.cio.HttpHeadersMap.access$getHeadersData$p(r9)
                int r2 = r2 * 6
                int r2 = r2 + 5
                int r2 = r9.at(r2)
                if (r2 == r3) goto L91
                goto L46
            L89:
                int r2 = r2 + 1
                int r9 = io.ktor.http.cio.HttpHeadersMap.access$getHeaderCapacity$p(r7)
                int r2 = r2 % r9
                goto L46
            L91:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.HttpHeadersMap.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Sequence<CharSequence> getAll(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return SequencesKt.sequence(new AnonymousClass1(name, null));
    }

    public final Sequence<Integer> offsets() {
        return this.headersData.headersStarts();
    }

    @Deprecated(message = "Use put without `nameHash` and `valueHash` instead", replaceWith = @ReplaceWith(expression = "put(nameStartIndex, nameEndIndex, valueStartIndex, valueEndIndex)", imports = {}))
    public final void put(int nameHash, int valueHash, int nameStartIndex, int nameEndIndex, int valueStartIndex, int valueEndIndex) {
        put(nameStartIndex, nameEndIndex, valueStartIndex, valueEndIndex);
    }

    public final void put(int nameStartIndex, int nameEndIndex, int valueStartIndex, int valueEndIndex) {
        int i;
        if (thresholdReached()) {
            resize();
        }
        int iAbs = Math.abs(CharsKt.hashCodeLowerCase(this.builder, nameStartIndex, nameEndIndex));
        CharSequence charSequenceSubSequence = this.builder.subSequence(nameStartIndex, nameEndIndex);
        int i2 = iAbs % this.headerCapacity;
        int i3 = -1;
        while (true) {
            i = i2 * 6;
            if (this.headersData.at(i) == -1) {
                break;
            }
            if (headerHasName(charSequenceSubSequence, i)) {
                i3 = i2;
            }
            i2 = (i2 + 1) % this.headerCapacity;
        }
        this.headersData.set(i, iAbs);
        this.headersData.set(i + 1, nameStartIndex);
        this.headersData.set(i + 2, nameEndIndex);
        this.headersData.set(i + 3, valueStartIndex);
        this.headersData.set(i + 4, valueEndIndex);
        this.headersData.set(i + 5, -1);
        if (i3 != -1) {
            this.headersData.set((i3 * 6) + 5, i2);
        }
        this.size++;
    }

    private final int idxToOffset(int idx) {
        if (idx < 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (idx >= this.size) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        return ((Number) SequencesKt.last(SequencesKt.take(offsets(), idx + 1))).intValue();
    }

    @Deprecated(message = "Use nameAtOffset instead", replaceWith = @ReplaceWith(expression = "nameAtOffset", imports = {}))
    public final CharSequence nameAt(int idx) {
        return nameAtOffset(idxToOffset(idx));
    }

    @Deprecated(message = "Use valueAtOffset instead", replaceWith = @ReplaceWith(expression = "valueAtOffset", imports = {}))
    public final CharSequence valueAt(int idx) {
        return valueAtOffset(idxToOffset(idx));
    }

    private final void resize() {
        int i = this.size;
        HeadersData headersData = this.headersData;
        this.size = 0;
        this.headerCapacity = (this.headerCapacity * 2) | 128;
        HeadersData headersData2 = (HeadersData) HttpHeadersMapKt.HeadersDataPool.borrow();
        headersData2.prepare((headersData.arraysCount() * 2) | 1);
        this.headersData = headersData2;
        Iterator<Integer> it = headersData.headersStarts().iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            put(headersData.at(iIntValue + 1), headersData.at(iIntValue + 2), headersData.at(iIntValue + 3), headersData.at(iIntValue + 4));
        }
        HttpHeadersMapKt.HeadersDataPool.recycle(headersData);
        if (i != this.size) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean headerHasName(CharSequence name, int headerOffset) {
        return CharsKt.equalsLowerCase(this.builder, this.headersData.at(headerOffset + 1), this.headersData.at(headerOffset + 2), name);
    }

    public final CharSequence nameAtOffset(int headerOffset) {
        return this.builder.subSequence(this.headersData.at(headerOffset + 1), this.headersData.at(headerOffset + 2));
    }

    public final CharSequence valueAtOffset(int headerOffset) {
        return this.builder.subSequence(this.headersData.at(headerOffset + 3), this.headersData.at(headerOffset + 4));
    }

    public final void release() {
        this.size = 0;
        this.headerCapacity = 0;
        HttpHeadersMapKt.HeadersDataPool.recycle(this.headersData);
        this.headersData = (HeadersData) HttpHeadersMapKt.HeadersDataPool.borrow();
    }

    public String toString() throws IOException {
        StringBuilder sb = new StringBuilder();
        HttpHeadersMapKt.dumpTo(this, "", sb);
        return sb.toString();
    }
}

package io.ktor.http.cio;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.muxer.WebmConstants;
import io.ktor.http.ContentDisposition;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.ReaderJob;
import io.ktor.utils.io.ReaderScope;
import io.ktor.utils.io.WriterJob;
import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.pool.DefaultPool;
import io.ktor.utils.io.pool.ObjectPool;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import org.bouncycastle.asn1.eac.EACTags;

/* JADX INFO: compiled from: ChunkedTransferEncoding.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\b\u001a\u001f\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\t\u001a \u0010\u0005\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\nH\u0086@¢\u0006\u0004\b\u0005\u0010\r\u001a!\u0010\u0013\u001a\u00060\u0011j\u0002`\u00122\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014\u001a \u0010\u0013\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0013\u0010\u0015\u001a\u0013\u0010\u0016\u001a\u00020\f*\u00020\u0001H\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001a,\u0010\u001d\u001a\u00020\u001a*\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0082@¢\u0006\u0004\b\u001d\u0010\u001e\"\u0014\u0010\u001f\u001a\u00020\u001a8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010 \"\u0014\u0010!\u001a\u00020\u001a8\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010 \"\u001e\u0010%\u001a\f\u0012\b\u0012\u00060#j\u0002`$0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&\"\u0014\u0010(\u001a\u00020'8\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010)\"\u0014\u0010*\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+\"\u0014\u0010,\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010+*\n\u0010-\"\u00020\u00032\u00020\u0003*\n\u0010.\"\u00020\u00112\u00020\u0011¨\u0006/"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lio/ktor/utils/io/ByteReadChannel;", "input", "Lio/ktor/utils/io/WriterJob;", "Lio/ktor/http/cio/DecoderJob;", "decodeChunked", "(Lkotlinx/coroutines/CoroutineScope;Lio/ktor/utils/io/ByteReadChannel;)Lio/ktor/utils/io/WriterJob;", "", "contentLength", "(Lkotlinx/coroutines/CoroutineScope;Lio/ktor/utils/io/ByteReadChannel;J)Lio/ktor/utils/io/WriterJob;", "Lio/ktor/utils/io/ByteWriteChannel;", "out", "", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "output", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lio/ktor/utils/io/ReaderJob;", "Lio/ktor/http/cio/EncoderJob;", "encodeChunked", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/CoroutineContext;)Lio/ktor/utils/io/ReaderJob;", "(Lio/ktor/utils/io/ByteWriteChannel;Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rethrowCloseCause", "(Lio/ktor/utils/io/ByteReadChannel;)V", "", "memory", "", "startIndex", "endIndex", "writeChunk", "(Lio/ktor/utils/io/ByteWriteChannel;[BIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "MAX_CHUNK_SIZE_LENGTH", "I", "CHUNK_BUFFER_POOL_SIZE", "Lio/ktor/utils/io/pool/ObjectPool;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "ChunkSizeBufferPool", "Lio/ktor/utils/io/pool/ObjectPool;", "", "CrLfShort", ExifInterface.LATITUDE_SOUTH, "CrLf", "[B", "LastChunkBytes", "DecoderJob", "EncoderJob", "ktor-http-cio"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ChunkedTransferEncodingKt {
    private static final int CHUNK_BUFFER_POOL_SIZE = 2048;
    private static final short CrLfShort = 3338;
    private static final int MAX_CHUNK_SIZE_LENGTH = 128;
    private static final ObjectPool<StringBuilder> ChunkSizeBufferPool = new DefaultPool<StringBuilder>() { // from class: io.ktor.http.cio.ChunkedTransferEncodingKt$ChunkSizeBufferPool$1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.ktor.utils.io.pool.DefaultPool
        public StringBuilder produceInstance() {
            return new StringBuilder(128);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.ktor.utils.io.pool.DefaultPool
        public StringBuilder clearInstance(StringBuilder instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            StringsKt.clear(instance);
            return instance;
        }
    };
    private static final byte[] CrLf = io.ktor.utils.io.core.StringsKt.toByteArray$default("\r\n", null, 1, null);
    private static final byte[] LastChunkBytes = io.ktor.utils.io.core.StringsKt.toByteArray$default("0\r\n\r\n", null, 1, null);

    /* JADX INFO: renamed from: io.ktor.http.cio.ChunkedTransferEncodingKt$decodeChunked$2, reason: invalid class name */
    /* JADX INFO: compiled from: ChunkedTransferEncoding.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.ChunkedTransferEncodingKt", f = "ChunkedTransferEncoding.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5}, l = {72, EACTags.ANSWER_TO_RESET, EACTags.HISTORICAL_BYTES, 87, 98, 98}, m = "decodeChunked", n = {"input", "out", "chunkSizeBuffer", "totalBytesCopied", "input", "out", "chunkSizeBuffer", "totalBytesCopied", "chunkSize", "input", "out", "chunkSizeBuffer", "totalBytesCopied", "chunkSize", "input", "out", "chunkSizeBuffer", "totalBytesCopied", "chunkSize", "input", "out", "chunkSizeBuffer", "totalBytesCopied", "input", "out", "chunkSizeBuffer", "totalBytesCopied"}, s = {"L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "J$0", "J$1", "L$0", "L$1", "L$2", "J$0", "J$1", "L$0", "L$1", "L$2", "J$0", "J$1", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "J$0"}, v = 1)
    static final class AnonymousClass2 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChunkedTransferEncodingKt.decodeChunked((ByteReadChannel) null, (ByteWriteChannel) null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.ChunkedTransferEncodingKt$encodeChunked$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ChunkedTransferEncoding.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.ChunkedTransferEncodingKt", f = "ChunkedTransferEncoding.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 3, 3, 4, 4}, l = {172, 132, 137, 143, 143}, m = "encodeChunked", n = {"output", "input", "$this$read$iv", "$i$f$read", "output", "input", "$this$read$iv", "result$iv", "this_$iv$iv", "buffer$iv$iv", "head$iv$iv", "array$iv", "$completion", "source", "$i$f$read", "$i$f$readFromHead", "endExclusive$iv", "start$iv", "$i$a$-readFromHead-ByteReadChannelOperationsKt$read$2$iv", "endIndex", "startIndex", "$i$a$-read-ChunkedTransferEncodingKt$encodeChunked$3", "output", "input", "output", "input", "output", "input"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "L$10", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5", "I$6", "I$7", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class C10312 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        int I$5;
        int I$6;
        int I$7;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C10312(Continuation<? super C10312> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChunkedTransferEncodingKt.encodeChunked(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.ChunkedTransferEncodingKt$writeChunk$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ChunkedTransferEncoding.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.ChunkedTransferEncodingKt", f = "ChunkedTransferEncoding.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4}, l = {WebmConstants.MkvEbmlElement.BLOCK, 162, 164, WebmConstants.MkvEbmlElement.BLOCK_ADDITIONAL, WebmConstants.MkvEbmlElement.BLOCK_MORE}, m = "writeChunk", n = {"$this$writeChunk", "memory", "startIndex", "endIndex", ContentDisposition.Parameters.Size, "$this$writeChunk", "memory", "startIndex", "endIndex", ContentDisposition.Parameters.Size, "$this$writeChunk", "memory", "startIndex", "endIndex", ContentDisposition.Parameters.Size, "$this$writeChunk", "memory", "startIndex", "endIndex", ContentDisposition.Parameters.Size, "$this$writeChunk", "memory", "startIndex", "endIndex", ContentDisposition.Parameters.Size}, s = {"L$0", "L$1", "I$0", "I$1", "I$2", "L$0", "L$1", "I$0", "I$1", "I$2", "L$0", "L$1", "I$0", "I$1", "I$2", "L$0", "L$1", "I$0", "I$1", "I$2", "L$0", "L$1", "I$0", "I$1", "I$2"}, v = 1)
    static final class C10321 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10321(Continuation<? super C10321> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChunkedTransferEncodingKt.writeChunk(null, null, 0, 0, this);
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Specify content length if known or pass -1L", replaceWith = @ReplaceWith(expression = "decodeChunked(input, -1L)", imports = {}))
    public static final WriterJob decodeChunked(CoroutineScope coroutineScope, ByteReadChannel input) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        return decodeChunked(coroutineScope, input, -1L);
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.ChunkedTransferEncodingKt$decodeChunked$1, reason: invalid class name */
    /* JADX INFO: compiled from: ChunkedTransferEncoding.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.ChunkedTransferEncodingKt$decodeChunked$1", f = "ChunkedTransferEncoding.kt", i = {0}, l = {54}, m = "invokeSuspend", n = {"$this$writer"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ByteReadChannel $input;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ByteReadChannel byteReadChannel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$input = byteReadChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$input, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                if (ChunkedTransferEncodingKt.decodeChunked(this.$input, writerScope.getChannel(), this) == coroutine_suspended) {
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

    public static final WriterJob decodeChunked(CoroutineScope coroutineScope, ByteReadChannel input, long j) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        return ByteWriteChannelOperationsKt.writer$default(coroutineScope, coroutineScope.getCoroutineContext(), false, (Function2) new AnonymousClass1(input, null), 2, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:38:0x00f2 A[Catch: all -> 0x00b1, TryCatch #1 {all -> 0x00b1, blocks: (B:15:0x006b, B:36:0x00e8, B:38:0x00f2, B:40:0x00fb, B:42:0x0101, B:48:0x0117, B:51:0x012c, B:45:0x010c, B:77:0x01ae, B:78:0x01b5, B:19:0x0083, B:22:0x0098, B:25:0x00ad), top: B:99:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00fb A[Catch: all -> 0x00b1, TryCatch #1 {all -> 0x00b1, blocks: (B:15:0x006b, B:36:0x00e8, B:38:0x00f2, B:40:0x00fb, B:42:0x0101, B:48:0x0117, B:51:0x012c, B:45:0x010c, B:77:0x01ae, B:78:0x01b5, B:19:0x0083, B:22:0x0098, B:25:0x00ad), top: B:99:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0101 A[Catch: all -> 0x00b1, TryCatch #1 {all -> 0x00b1, blocks: (B:15:0x006b, B:36:0x00e8, B:38:0x00f2, B:40:0x00fb, B:42:0x0101, B:48:0x0117, B:51:0x012c, B:45:0x010c, B:77:0x01ae, B:78:0x01b5, B:19:0x0083, B:22:0x0098, B:25:0x00ad), top: B:99:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x010c A[Catch: all -> 0x00b1, TryCatch #1 {all -> 0x00b1, blocks: (B:15:0x006b, B:36:0x00e8, B:38:0x00f2, B:40:0x00fb, B:42:0x0101, B:48:0x0117, B:51:0x012c, B:45:0x010c, B:77:0x01ae, B:78:0x01b5, B:19:0x0083, B:22:0x0098, B:25:0x00ad), top: B:99:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x0117 A[Catch: all -> 0x00b1, TryCatch #1 {all -> 0x00b1, blocks: (B:15:0x006b, B:36:0x00e8, B:38:0x00f2, B:40:0x00fb, B:42:0x0101, B:48:0x0117, B:51:0x012c, B:45:0x010c, B:77:0x01ae, B:78:0x01b5, B:19:0x0083, B:22:0x0098, B:25:0x00ad), top: B:99:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x012a  */
    /* JADX WARN: Code duplicated, block: B:51:0x012c A[Catch: all -> 0x00b1, PHI: r1 r3 r7 r9 r11 r12
      0x012c: PHI (r1v11 io.ktor.http.cio.ChunkedTransferEncodingKt$decodeChunked$2) = 
      (r1v2 io.ktor.http.cio.ChunkedTransferEncodingKt$decodeChunked$2)
      (r1v12 io.ktor.http.cio.ChunkedTransferEncodingKt$decodeChunked$2)
     binds: [B:22:0x0098, B:49:0x0128] A[DONT_GENERATE, DONT_INLINE]
      0x012c: PHI (r3v15 ??) = (r3v33 ??), (r3v34 ??) binds: [B:22:0x0098, B:49:0x0128] A[DONT_GENERATE, DONT_INLINE]
      0x012c: PHI (r7v7 long) = (r7v3 long), (r7v10 long) binds: [B:22:0x0098, B:49:0x0128] A[DONT_GENERATE, DONT_INLINE]
      0x012c: PHI (r9v9 long) = (r9v3 long), (r9v10 long) binds: [B:22:0x0098, B:49:0x0128] A[DONT_GENERATE, DONT_INLINE]
      0x012c: PHI (r11v11 io.ktor.utils.io.ByteWriteChannel) = (r11v5 io.ktor.utils.io.ByteWriteChannel), (r11v12 io.ktor.utils.io.ByteWriteChannel) binds: [B:22:0x0098, B:49:0x0128] A[DONT_GENERATE, DONT_INLINE]
      0x012c: PHI (r12v14 io.ktor.utils.io.ByteReadChannel) = (r12v6 io.ktor.utils.io.ByteReadChannel), (r12v15 io.ktor.utils.io.ByteReadChannel) binds: [B:22:0x0098, B:49:0x0128] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #1 {all -> 0x00b1, blocks: (B:15:0x006b, B:36:0x00e8, B:38:0x00f2, B:40:0x00fb, B:42:0x0101, B:48:0x0117, B:51:0x012c, B:45:0x010c, B:77:0x01ae, B:78:0x01b5, B:19:0x0083, B:22:0x0098, B:25:0x00ad), top: B:99:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x0142 A[PHI: r1 r3 r7 r9 r11 r12
      0x0142: PHI (r1v8 io.ktor.http.cio.ChunkedTransferEncodingKt$decodeChunked$2) = 
      (r1v10 io.ktor.http.cio.ChunkedTransferEncodingKt$decodeChunked$2)
      (r1v12 io.ktor.http.cio.ChunkedTransferEncodingKt$decodeChunked$2)
     binds: [B:54:0x0141, B:47:0x0115] A[DONT_GENERATE, DONT_INLINE]
      0x0142: PHI (r3v13 ??) = (r3v37 ??), (r3v38 ??) binds: [B:54:0x0141, B:47:0x0115] A[DONT_GENERATE, DONT_INLINE]
      0x0142: PHI (r7v5 long) = (r7v6 long), (r7v10 long) binds: [B:54:0x0141, B:47:0x0115] A[DONT_GENERATE, DONT_INLINE]
      0x0142: PHI (r9v6 long) = (r9v8 long), (r9v10 long) binds: [B:54:0x0141, B:47:0x0115] A[DONT_GENERATE, DONT_INLINE]
      0x0142: PHI (r11v9 io.ktor.utils.io.ByteWriteChannel) = (r11v10 io.ktor.utils.io.ByteWriteChannel), (r11v12 io.ktor.utils.io.ByteWriteChannel) binds: [B:54:0x0141, B:47:0x0115] A[DONT_GENERATE, DONT_INLINE]
      0x0142: PHI (r12v10 io.ktor.utils.io.ByteReadChannel) = (r12v13 io.ktor.utils.io.ByteReadChannel), (r12v15 io.ktor.utils.io.ByteReadChannel) binds: [B:54:0x0141, B:47:0x0115] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:61:0x0168  */
    /* JADX WARN: Code duplicated, block: B:64:0x0178  */
    /* JADX WARN: Code duplicated, block: B:66:0x017c  */
    /* JADX WARN: Code duplicated, block: B:67:0x0180  */
    /* JADX WARN: Code duplicated, block: B:68:0x0184 A[Catch: all -> 0x01a0, TryCatch #0 {all -> 0x01a0, blocks: (B:62:0x016c, B:68:0x0184, B:69:0x019f), top: B:97:0x016c }] */
    /* JADX WARN: Code duplicated, block: B:77:0x01ae A[Catch: all -> 0x00b1, TRY_ENTER, TryCatch #1 {all -> 0x00b1, blocks: (B:15:0x006b, B:36:0x00e8, B:38:0x00f2, B:40:0x00fb, B:42:0x0101, B:48:0x0117, B:51:0x012c, B:45:0x010c, B:77:0x01ae, B:78:0x01b5, B:19:0x0083, B:22:0x0098, B:25:0x00ad), top: B:99:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13, types: [java.lang.Object, java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v16, types: [java.lang.Object, java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v18, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v37 */
    /* JADX WARN: Type inference failed for: r3v38 */
    /* JADX WARN: Type inference failed for: r3v39 */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0168 -> B:17:0x0070). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object decodeChunked(io.ktor.utils.io.ByteReadChannel r21, io.ktor.utils.io.ByteWriteChannel r22, kotlin.coroutines.Continuation<? super kotlin.Unit> r23) {
        /*
            Method dump skipped, instruction units count: 546
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.ChunkedTransferEncodingKt.decodeChunked(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.ChunkedTransferEncodingKt$encodeChunked$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ChunkedTransferEncoding.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/ReaderScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.ChunkedTransferEncodingKt$encodeChunked$1", f = "ChunkedTransferEncoding.kt", i = {0}, l = {119}, m = "invokeSuspend", n = {"$this$reader"}, s = {"L$0"}, v = 1)
    static final class C10301 extends SuspendLambda implements Function2<ReaderScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ByteWriteChannel $output;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10301(ByteWriteChannel byteWriteChannel, Continuation<? super C10301> continuation) {
            super(2, continuation);
            this.$output = byteWriteChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C10301 c10301 = new C10301(this.$output, continuation);
            c10301.L$0 = obj;
            return c10301;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ReaderScope readerScope, Continuation<? super Unit> continuation) {
            return ((C10301) create(readerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ReaderScope readerScope = (ReaderScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.L$0 = SpillingKt.nullOutSpilledVariable(readerScope);
                this.label = 1;
                if (ChunkedTransferEncodingKt.encodeChunked(this.$output, readerScope.getChannel(), this) == coroutine_suspended) {
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

    public static final ReaderJob encodeChunked(ByteWriteChannel output, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        return ByteReadChannelOperationsKt.reader((CoroutineScope) GlobalScope.INSTANCE, coroutineContext, false, (Function2<? super ReaderScope, ? super Continuation<? super Unit>, ? extends Object>) new C10301(output, null));
    }

    /* JADX WARN: Code duplicated, block: B:118:0x01ec A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:119:0x00dd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:121:? A[LOOP:0: B:114:0x00d1->B:121:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x00d7 A[Catch: all -> 0x01e6, TRY_ENTER, TryCatch #2 {all -> 0x01e6, blocks: (B:59:0x01a2, B:62:0x01b0, B:64:0x01b6, B:65:0x01bb, B:66:0x01c2, B:67:0x01c3, B:68:0x01ca, B:69:0x01cb, B:37:0x00d7, B:39:0x00dd, B:41:0x00e7), top: B:107:0x01a2 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00e7 A[Catch: all -> 0x01e6, TRY_LEAVE, TryCatch #2 {all -> 0x01e6, blocks: (B:59:0x01a2, B:62:0x01b0, B:64:0x01b6, B:65:0x01bb, B:66:0x01c2, B:67:0x01c3, B:68:0x01ca, B:69:0x01cb, B:37:0x00d7, B:39:0x00dd, B:41:0x00e7), top: B:107:0x01a2 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x0109  */
    /* JADX WARN: Code duplicated, block: B:46:0x0113  */
    /* JADX WARN: Code duplicated, block: B:49:0x011b A[Catch: all -> 0x01e2, TryCatch #0 {all -> 0x01e2, blocks: (B:47:0x0115, B:49:0x011b, B:51:0x0130, B:53:0x0149, B:54:0x0150, B:71:0x01d3, B:72:0x01de), top: B:103:0x0115 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x0130 A[Catch: all -> 0x01e2, TryCatch #0 {all -> 0x01e2, blocks: (B:47:0x0115, B:49:0x011b, B:51:0x0130, B:53:0x0149, B:54:0x0150, B:71:0x01d3, B:72:0x01de), top: B:103:0x0115 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x0149 A[Catch: all -> 0x01e2, TryCatch #0 {all -> 0x01e2, blocks: (B:47:0x0115, B:49:0x011b, B:51:0x0130, B:53:0x0149, B:54:0x0150, B:71:0x01d3, B:72:0x01de), top: B:103:0x0115 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0150 A[Catch: all -> 0x01e2, TRY_LEAVE, TryCatch #0 {all -> 0x01e2, blocks: (B:47:0x0115, B:49:0x011b, B:51:0x0130, B:53:0x0149, B:54:0x0150, B:71:0x01d3, B:72:0x01de), top: B:103:0x0115 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0194  */
    /* JADX WARN: Code duplicated, block: B:61:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:62:0x01b0 A[Catch: all -> 0x01e6, TryCatch #2 {all -> 0x01e6, blocks: (B:59:0x01a2, B:62:0x01b0, B:64:0x01b6, B:65:0x01bb, B:66:0x01c2, B:67:0x01c3, B:68:0x01ca, B:69:0x01cb, B:37:0x00d7, B:39:0x00dd, B:41:0x00e7), top: B:107:0x01a2 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x01b6 A[Catch: all -> 0x01e6, TryCatch #2 {all -> 0x01e6, blocks: (B:59:0x01a2, B:62:0x01b0, B:64:0x01b6, B:65:0x01bb, B:66:0x01c2, B:67:0x01c3, B:68:0x01ca, B:69:0x01cb, B:37:0x00d7, B:39:0x00dd, B:41:0x00e7), top: B:107:0x01a2 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x01bb A[Catch: all -> 0x01e6, TryCatch #2 {all -> 0x01e6, blocks: (B:59:0x01a2, B:62:0x01b0, B:64:0x01b6, B:65:0x01bb, B:66:0x01c2, B:67:0x01c3, B:68:0x01ca, B:69:0x01cb, B:37:0x00d7, B:39:0x00dd, B:41:0x00e7), top: B:107:0x01a2 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x01c3 A[Catch: all -> 0x01e6, TryCatch #2 {all -> 0x01e6, blocks: (B:59:0x01a2, B:62:0x01b0, B:64:0x01b6, B:65:0x01bb, B:66:0x01c2, B:67:0x01c3, B:68:0x01ca, B:69:0x01cb, B:37:0x00d7, B:39:0x00dd, B:41:0x00e7), top: B:107:0x01a2 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x01d3 A[Catch: all -> 0x01e2, TRY_ENTER, TryCatch #0 {all -> 0x01e2, blocks: (B:47:0x0115, B:49:0x011b, B:51:0x0130, B:53:0x0149, B:54:0x0150, B:71:0x01d3, B:72:0x01de), top: B:103:0x0115 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x01df  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Code duplicated, block: B:84:0x021b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0149 -> B:107:0x01a2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0194 -> B:58:0x019c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x01df -> B:114:0x00d1). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:67:0x01c3
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object encodeChunked(io.ktor.utils.io.ByteWriteChannel r21, io.ktor.utils.io.ByteReadChannel r22, kotlin.coroutines.Continuation<? super kotlin.Unit> r23) {
        /*
            Method dump skipped, instruction units count: 627
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.ChunkedTransferEncodingKt.encodeChunked(io.ktor.utils.io.ByteWriteChannel, io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final void rethrowCloseCause(ByteReadChannel byteReadChannel) throws Throwable {
        Throwable closedCause = byteReadChannel instanceof ByteChannel ? ((ByteChannel) byteReadChannel).getClosedCause() : null;
        if (closedCause != null) {
            throw closedCause;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:20:0x0072 A[PHI: r1 r9 r10 r11 r12
      0x0072: PHI (r1v7 io.ktor.utils.io.ByteWriteChannel) = (r1v6 io.ktor.utils.io.ByteWriteChannel), (r1v14 io.ktor.utils.io.ByteWriteChannel) binds: [B:31:0x00e1, B:19:0x0061] A[DONT_GENERATE, DONT_INLINE]
      0x0072: PHI (r9v4 int) = (r9v3 int), (r9v11 int) binds: [B:31:0x00e1, B:19:0x0061] A[DONT_GENERATE, DONT_INLINE]
      0x0072: PHI (r10v4 int) = (r10v3 int), (r10v10 int) binds: [B:31:0x00e1, B:19:0x0061] A[DONT_GENERATE, DONT_INLINE]
      0x0072: PHI (r11v3 int) = (r11v2 int), (r11v7 int) binds: [B:31:0x00e1, B:19:0x0061] A[DONT_GENERATE, DONT_INLINE]
      0x0072: PHI (r12v4 byte[]) = (r12v3 byte[]), (r12v11 byte[]) binds: [B:31:0x00e1, B:19:0x0061] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:36:0x0101 A[PHI: r1 r9 r10 r11 r12
      0x0101: PHI (r1v8 io.ktor.utils.io.ByteWriteChannel) = (r1v7 io.ktor.utils.io.ByteWriteChannel), (r1v16 io.ktor.utils.io.ByteWriteChannel) binds: [B:34:0x00fe, B:18:0x004e] A[DONT_GENERATE, DONT_INLINE]
      0x0101: PHI (r9v5 int) = (r9v4 int), (r9v12 int) binds: [B:34:0x00fe, B:18:0x004e] A[DONT_GENERATE, DONT_INLINE]
      0x0101: PHI (r10v5 int) = (r10v4 int), (r10v11 int) binds: [B:34:0x00fe, B:18:0x004e] A[DONT_GENERATE, DONT_INLINE]
      0x0101: PHI (r11v4 int) = (r11v3 int), (r11v8 int) binds: [B:34:0x00fe, B:18:0x004e] A[DONT_GENERATE, DONT_INLINE]
      0x0101: PHI (r12v5 byte[]) = (r12v4 byte[]), (r12v13 byte[]) binds: [B:34:0x00fe, B:18:0x004e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0119, code lost:
    
        if (r1.flush(r5) == r0) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object writeChunk(io.ktor.utils.io.ByteWriteChannel r9, byte[] r10, int r11, int r12, kotlin.coroutines.Continuation<? super java.lang.Integer> r13) {
        /*
            Method dump skipped, instruction units count: 289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.ChunkedTransferEncodingKt.writeChunk(io.ktor.utils.io.ByteWriteChannel, byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

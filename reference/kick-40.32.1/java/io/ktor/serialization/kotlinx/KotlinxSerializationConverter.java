package io.ktor.serialization.kotlinx;

import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.http.content.ByteArrayContent;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.TextContent;
import io.ktor.serialization.ContentConverter;
import io.ktor.serialization.JsonConvertException;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.core.ByteReadPacketKt;
import io.ktor.utils.io.core.StringsKt;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.io.Source;
import kotlinx.io.SourcesKt;
import kotlinx.serialization.BinaryFormat;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialFormat;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.StringFormat;

/* JADX INFO: compiled from: KotlinxSerializationConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J6\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096@¢\u0006\u0004\b\u0010\u0010\u0011J.\u0010\u0014\u001a\u0004\u0018\u00010\r2\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0096@¢\u0006\u0004\b\u0014\u0010\u0015JA\u0010\u0019\u001a\u00020\u00182\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00162\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\n\u001a\u00060\bj\u0002`\tH\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001bR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lio/ktor/serialization/kotlinx/KotlinxSerializationConverter;", "Lio/ktor/serialization/ContentConverter;", "Lkotlinx/serialization/SerialFormat;", "format", "<init>", "(Lkotlinx/serialization/SerialFormat;)V", "Lio/ktor/http/ContentType;", "contentType", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", HttpAuthHeader.Parameters.Charset, "Lio/ktor/util/reflect/TypeInfo;", "typeInfo", "", "value", "Lio/ktor/http/content/OutgoingContent;", "serialize", "(Lio/ktor/http/ContentType;Ljava/nio/charset/Charset;Lio/ktor/util/reflect/TypeInfo;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteReadChannel;", "content", "deserialize", "(Ljava/nio/charset/Charset;Lio/ktor/util/reflect/TypeInfo;Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/serialization/KSerializer;", "serializer", "Lio/ktor/http/content/OutgoingContent$ByteArrayContent;", "serializeContent", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/SerialFormat;Ljava/lang/Object;Lio/ktor/http/ContentType;Ljava/nio/charset/Charset;)Lio/ktor/http/content/OutgoingContent$ByteArrayContent;", "Lkotlinx/serialization/SerialFormat;", "", "Lio/ktor/serialization/kotlinx/KotlinxSerializationExtension;", "extensions", "Ljava/util/List;", "ktor-serialization-kotlinx"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KotlinxSerializationConverter implements ContentConverter {
    private final List<KotlinxSerializationExtension> extensions;
    private final SerialFormat format;

    /* JADX INFO: renamed from: io.ktor.serialization.kotlinx.KotlinxSerializationConverter$deserialize$1, reason: invalid class name */
    /* JADX INFO: compiled from: KotlinxSerializationConverter.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.serialization.kotlinx.KotlinxSerializationConverter", f = "KotlinxSerializationConverter.kt", i = {0, 0, 0, 1, 1, 1, 1, 1}, l = {63, 67}, m = "deserialize", n = {HttpAuthHeader.Parameters.Charset, "typeInfo", "content", HttpAuthHeader.Parameters.Charset, "typeInfo", "content", "fromExtension", "serializer"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KotlinxSerializationConverter.this.deserialize(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serialize$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: KotlinxSerializationConverter.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.serialization.kotlinx.KotlinxSerializationConverter", f = "KotlinxSerializationConverter.kt", i = {0, 0, 0, 0}, l = {48}, m = "serialize", n = {"contentType", HttpAuthHeader.Parameters.Charset, "typeInfo", "value"}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class C10451 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C10451(Continuation<? super C10451> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KotlinxSerializationConverter.this.serialize(null, null, null, null, this);
        }
    }

    public KotlinxSerializationConverter(SerialFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        this.format = format;
        this.extensions = ExtensionsKt.extensions(format);
        if ((format instanceof BinaryFormat) || (format instanceof StringFormat)) {
            return;
        }
        throw new IllegalArgumentException(("Only binary and string formats are supported, " + format + " is not supported.").toString());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // io.ktor.serialization.ContentConverter
    public Object serialize(ContentType contentType, Charset charset, final TypeInfo typeInfo, final Object obj, Continuation<? super OutgoingContent> continuation) {
        C10451 c10451;
        final ContentType contentType2;
        final Charset charset2;
        TypeInfo typeInfo2;
        Object obj2;
        KSerializer<?> kSerializerGuessSerializer;
        if (continuation instanceof C10451) {
            c10451 = (C10451) continuation;
            if ((c10451.label & Integer.MIN_VALUE) != 0) {
                c10451.label -= Integer.MIN_VALUE;
            } else {
                c10451 = new C10451(continuation);
            }
        } else {
            c10451 = new C10451(continuation);
        }
        Object objFirstOrNull = c10451.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10451.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objFirstOrNull);
            final Flow flowAsFlow = FlowKt.asFlow(this.extensions);
            contentType2 = contentType;
            charset2 = charset;
            Flow<OutgoingContent> flow = new Flow<OutgoingContent>() { // from class: io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serialize$$inlined$map$1

                /* JADX INFO: renamed from: io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serialize$$inlined$map$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ Charset $charset$inlined;
                    final /* synthetic */ ContentType $contentType$inlined;
                    final /* synthetic */ FlowCollector $this_unsafeFlow;
                    final /* synthetic */ TypeInfo $typeInfo$inlined;
                    final /* synthetic */ Object $value$inlined;

                    /* JADX INFO: renamed from: io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serialize$$inlined$map$1$2$1, reason: invalid class name */
                    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                    @DebugMetadata(c = "io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serialize$$inlined$map$1$2", f = "KotlinxSerializationConverter.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {51, 50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$completion", "it", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1", "$i$a$-map-KotlinxSerializationConverter$serialize$fromExtension$1", "value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        int I$0;
                        int I$1;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        Object L$4;
                        Object L$5;
                        Object L$6;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector, ContentType contentType, Charset charset, TypeInfo typeInfo, Object obj) {
                        this.$this_unsafeFlow = flowCollector;
                        this.$contentType$inlined = contentType;
                        this.$charset$inlined = charset;
                        this.$typeInfo$inlined = typeInfo;
                        this.$value$inlined = obj;
                    }

                    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                    /* JADX WARN: Code restructure failed: missing block: B:21:0x00df, code lost:
                    
                        if (r11.emit(r12, r6) == r0) goto L22;
                     */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object emit(java.lang.Object r11, kotlin.coroutines.Continuation r12) {
                        /*
                            Method dump skipped, instruction units count: 229
                            To view this dump add '--comments-level debug' option
                        */
                        throw new UnsupportedOperationException("Method not decompiled: io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serialize$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super OutgoingContent> flowCollector, Continuation continuation2) {
                    Object objCollect = flowAsFlow.collect(new AnonymousClass2(flowCollector, contentType2, charset2, typeInfo, obj), continuation2);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }
            };
            KotlinxSerializationConverter$serialize$fromExtension$2 kotlinxSerializationConverter$serialize$fromExtension$2 = new KotlinxSerializationConverter$serialize$fromExtension$2(null);
            c10451.L$0 = contentType2;
            c10451.L$1 = charset2;
            c10451.L$2 = typeInfo;
            c10451.L$3 = obj;
            c10451.label = 1;
            objFirstOrNull = FlowKt.firstOrNull(flow, kotlinxSerializationConverter$serialize$fromExtension$2, c10451);
            if (objFirstOrNull == coroutine_suspended) {
                return coroutine_suspended;
            }
            typeInfo2 = typeInfo;
            obj2 = obj;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Object obj3 = c10451.L$3;
            typeInfo2 = (TypeInfo) c10451.L$2;
            Charset charset3 = (Charset) c10451.L$1;
            ContentType contentType3 = (ContentType) c10451.L$0;
            ResultKt.throwOnFailure(objFirstOrNull);
            contentType2 = contentType3;
            charset2 = charset3;
            obj2 = obj3;
        }
        OutgoingContent outgoingContent = (OutgoingContent) objFirstOrNull;
        if (outgoingContent != null) {
            return outgoingContent;
        }
        try {
            kSerializerGuessSerializer = SerializerLookupKt.serializerForTypeInfo(this.format.getSerializersModule(), typeInfo2);
        } catch (SerializationException unused) {
            kSerializerGuessSerializer = SerializerLookupKt.guessSerializer(obj2, this.format.getSerializersModule());
        }
        return serializeContent(kSerializerGuessSerializer, this.format, obj2, contentType2, charset2);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00cb A[Catch: all -> 0x0107, TryCatch #0 {all -> 0x0107, blocks: (B:30:0x00c5, B:32:0x00cb, B:34:0x00d9, B:36:0x00dd, B:38:0x00ea, B:39:0x0106), top: B:43:0x00c5 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00d9 A[Catch: all -> 0x0107, TryCatch #0 {all -> 0x0107, blocks: (B:30:0x00c5, B:32:0x00cb, B:34:0x00d9, B:36:0x00dd, B:38:0x00ea, B:39:0x0106), top: B:43:0x00c5 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00dd A[Catch: all -> 0x0107, TryCatch #0 {all -> 0x0107, blocks: (B:30:0x00c5, B:32:0x00cb, B:34:0x00d9, B:36:0x00dd, B:38:0x00ea, B:39:0x0106), top: B:43:0x00c5 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00ea A[Catch: all -> 0x0107, TryCatch #0 {all -> 0x0107, blocks: (B:30:0x00c5, B:32:0x00cb, B:34:0x00d9, B:36:0x00dd, B:38:0x00ea, B:39:0x0106), top: B:43:0x00c5 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Instruction removed from duplicated block: B:38:0x00ea, please report this as an issue */
    @Override // io.ktor.serialization.ContentConverter
    public Object deserialize(final Charset charset, final TypeInfo typeInfo, final ByteReadChannel byteReadChannel, Continuation<Object> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Charset charset2;
        KSerializer<?> kSerializer;
        Source source;
        SerialFormat serialFormat;
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
        Object objFirstOrNull = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i != 0) {
            if (i == 1) {
                byteReadChannel = (ByteReadChannel) anonymousClass1.L$2;
                typeInfo = (TypeInfo) anonymousClass1.L$1;
                charset = (Charset) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objFirstOrNull);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kSerializer = (KSerializer) anonymousClass1.L$4;
                Object obj = anonymousClass1.L$3;
                charset2 = (Charset) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objFirstOrNull);
            }
            source = (Source) objFirstOrNull;
            try {
                serialFormat = this.format;
                if (serialFormat instanceof StringFormat) {
                    return ((StringFormat) serialFormat).decodeFromString(kSerializer, StringsKt.readText$default(source, charset2, 0, 2, null));
                }
                if (serialFormat instanceof BinaryFormat) {
                    return ((BinaryFormat) serialFormat).decodeFromByteArray(kSerializer, SourcesKt.readByteArray(source));
                }
                ByteReadPacketKt.discard$default(source, 0L, 1, null);
                throw new IllegalStateException(("Unsupported format " + this.format).toString());
            } catch (Throwable th) {
                throw new JsonConvertException("Illegal input: " + th.getMessage(), th);
            }
        }
        ResultKt.throwOnFailure(objFirstOrNull);
        final Flow flowAsFlow = FlowKt.asFlow(this.extensions);
        Flow<Object> flow = new Flow<Object>() { // from class: io.ktor.serialization.kotlinx.KotlinxSerializationConverter$deserialize$$inlined$map$1

            /* JADX INFO: renamed from: io.ktor.serialization.kotlinx.KotlinxSerializationConverter$deserialize$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ Charset $charset$inlined;
                final /* synthetic */ ByteReadChannel $content$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ TypeInfo $typeInfo$inlined;

                /* JADX INFO: renamed from: io.ktor.serialization.kotlinx.KotlinxSerializationConverter$deserialize$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                @DebugMetadata(c = "io.ktor.serialization.kotlinx.KotlinxSerializationConverter$deserialize$$inlined$map$1$2", f = "KotlinxSerializationConverter.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {51, 50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$completion", "it", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1", "$i$a$-map-KotlinxSerializationConverter$deserialize$fromExtension$1", "value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    int I$1;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, Charset charset, TypeInfo typeInfo, ByteReadChannel byteReadChannel) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$charset$inlined = charset;
                    this.$typeInfo$inlined = typeInfo;
                    this.$content$inlined = byteReadChannel;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                /* JADX WARN: Code restructure failed: missing block: B:21:0x00d7, code lost:
                
                    if (r10.emit(r11, r0) == r1) goto L22;
                 */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r10, kotlin.coroutines.Continuation r11) {
                    /*
                        Method dump skipped, instruction units count: 221
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.ktor.serialization.kotlinx.KotlinxSerializationConverter$deserialize$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Object> flowCollector, Continuation continuation2) {
                Object objCollect = flowAsFlow.collect(new AnonymousClass2(flowCollector, charset, typeInfo, byteReadChannel), continuation2);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
        KotlinxSerializationConverter$deserialize$fromExtension$2 kotlinxSerializationConverter$deserialize$fromExtension$2 = new KotlinxSerializationConverter$deserialize$fromExtension$2(byteReadChannel, null);
        anonymousClass1.L$0 = charset;
        anonymousClass1.L$1 = typeInfo;
        anonymousClass1.L$2 = byteReadChannel;
        anonymousClass1.label = 1;
        objFirstOrNull = FlowKt.firstOrNull(flow, kotlinxSerializationConverter$deserialize$fromExtension$2, anonymousClass1);
        if (objFirstOrNull != coroutine_suspended) {
        }
        return coroutine_suspended;
        if (!this.extensions.isEmpty() && (objFirstOrNull != null || byteReadChannel.isClosedForRead())) {
            return objFirstOrNull;
        }
        KSerializer<?> kSerializerSerializerForTypeInfo = SerializerLookupKt.serializerForTypeInfo(this.format.getSerializersModule(), typeInfo);
        anonymousClass1.L$0 = charset;
        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(typeInfo);
        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(byteReadChannel);
        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(objFirstOrNull);
        anonymousClass1.L$4 = kSerializerSerializerForTypeInfo;
        anonymousClass1.label = 2;
        objFirstOrNull = ByteReadChannelOperationsKt.readRemaining(byteReadChannel, anonymousClass1);
        if (objFirstOrNull != coroutine_suspended) {
            charset2 = charset;
            kSerializer = kSerializerSerializerForTypeInfo;
            source = (Source) objFirstOrNull;
            serialFormat = this.format;
            if (serialFormat instanceof StringFormat) {
                return ((StringFormat) serialFormat).decodeFromString(kSerializer, StringsKt.readText$default(source, charset2, 0, 2, null));
            }
            if (serialFormat instanceof BinaryFormat) {
                return ((BinaryFormat) serialFormat).decodeFromByteArray(kSerializer, SourcesKt.readByteArray(source));
            }
            ByteReadPacketKt.discard$default(source, 0L, 1, null);
            throw new IllegalStateException(("Unsupported format " + this.format).toString());
        }
        return coroutine_suspended;
    }

    private final OutgoingContent.ByteArrayContent serializeContent(KSerializer<?> serializer, SerialFormat format, Object value, ContentType contentType, Charset charset) {
        if (format instanceof StringFormat) {
            Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any?>");
            return new TextContent(((StringFormat) format).encodeToString(serializer, value), ContentTypesKt.withCharsetIfNeeded(contentType, charset), null, 4, null);
        }
        if (format instanceof BinaryFormat) {
            Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any?>");
            return new ByteArrayContent(((BinaryFormat) format).encodeToByteArray(serializer, value), contentType, null, 4, null);
        }
        throw new IllegalStateException(("Unsupported format " + format).toString());
    }
}

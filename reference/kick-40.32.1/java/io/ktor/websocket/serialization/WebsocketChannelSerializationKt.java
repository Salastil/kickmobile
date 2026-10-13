package io.ktor.websocket.serialization;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.serialization.WebsocketContentConverter;
import io.ktor.serialization.WebsocketDeserializeException;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.websocket.Frame;
import io.ktor.websocket.WebSocketSession;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.coroutines.channels.ReceiveChannel;

/* JADX INFO: compiled from: WebsocketChannelSerialization.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a:\u0010\n\u001a\u00020\t\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0087H¢\u0006\u0004\b\n\u0010\u000b\u001a:\u0010\n\u001a\u00020\t*\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0087@¢\u0006\u0004\b\n\u0010\u000e\u001a2\u0010\u000f\u001a\u0004\u0018\u00010\u0002\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0087H¢\u0006\u0004\b\u000f\u0010\u0010\u001a2\u0010\u000f\u001a\u0004\u0018\u00010\u0002*\u00020\u00012\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0087@¢\u0006\u0004\b\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/websocket/WebSocketSession;", "", "data", "Lio/ktor/serialization/WebsocketContentConverter;", "converter", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", HttpAuthHeader.Parameters.Charset, "", "sendSerializedBase", "(Lio/ktor/websocket/WebSocketSession;Ljava/lang/Object;Lio/ktor/serialization/WebsocketContentConverter;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/util/reflect/TypeInfo;", "typeInfo", "(Lio/ktor/websocket/WebSocketSession;Ljava/lang/Object;Lio/ktor/util/reflect/TypeInfo;Lio/ktor/serialization/WebsocketContentConverter;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveDeserializedBase", "(Lio/ktor/websocket/WebSocketSession;Lio/ktor/serialization/WebsocketContentConverter;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lio/ktor/websocket/WebSocketSession;Lio/ktor/util/reflect/TypeInfo;Lio/ktor/serialization/WebsocketContentConverter;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-websocket-serialization"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class WebsocketChannelSerializationKt {

    /* JADX INFO: renamed from: io.ktor.websocket.serialization.WebsocketChannelSerializationKt$receiveDeserializedBase$2, reason: invalid class name */
    /* JADX INFO: compiled from: WebsocketChannelSerialization.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.serialization.WebsocketChannelSerializationKt", f = "WebsocketChannelSerialization.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, 117}, m = "receiveDeserializedBase", n = {"$this$receiveDeserializedBase", "typeInfo", "converter", HttpAuthHeader.Parameters.Charset, "$this$receiveDeserializedBase", "typeInfo", "converter", HttpAuthHeader.Parameters.Charset, TypedValues.Attributes.S_FRAME}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 1)
    static final class AnonymousClass2 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebsocketChannelSerializationKt.receiveDeserializedBase(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.websocket.serialization.WebsocketChannelSerializationKt$sendSerializedBase$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WebsocketChannelSerialization.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.serialization.WebsocketChannelSerializationKt", f = "WebsocketChannelSerialization.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {57, 62}, m = "sendSerializedBase", n = {"$this$sendSerializedBase", "data", "typeInfo", "converter", HttpAuthHeader.Parameters.Charset, "$this$sendSerializedBase", "data", "typeInfo", "converter", HttpAuthHeader.Parameters.Charset, "serializedData"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 1)
    static final class C11072 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C11072(Continuation<? super C11072> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebsocketChannelSerializationKt.sendSerializedBase(null, null, null, null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00bb, code lost:
    
        if (r2.send(r10, r0) == r1) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object sendSerializedBase(io.ktor.websocket.WebSocketSession r5, java.lang.Object r6, io.ktor.util.reflect.TypeInfo r7, io.ktor.serialization.WebsocketContentConverter r8, java.nio.charset.Charset r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            boolean r0 = r10 instanceof io.ktor.websocket.serialization.WebsocketChannelSerializationKt.C11072
            if (r0 == 0) goto L14
            r0 = r10
            io.ktor.websocket.serialization.WebsocketChannelSerializationKt$sendSerializedBase$2 r0 = (io.ktor.websocket.serialization.WebsocketChannelSerializationKt.C11072) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            io.ktor.websocket.serialization.WebsocketChannelSerializationKt$sendSerializedBase$2 r0 = new io.ktor.websocket.serialization.WebsocketChannelSerializationKt$sendSerializedBase$2
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L65
            if (r2 == r4) goto L4c
            if (r2 != r3) goto L44
            java.lang.Object r5 = r0.L$5
            io.ktor.websocket.Frame r5 = (io.ktor.websocket.Frame) r5
            java.lang.Object r5 = r0.L$4
            java.nio.charset.Charset r5 = (java.nio.charset.Charset) r5
            java.lang.Object r5 = r0.L$3
            io.ktor.serialization.WebsocketContentConverter r5 = (io.ktor.serialization.WebsocketContentConverter) r5
            java.lang.Object r5 = r0.L$2
            io.ktor.util.reflect.TypeInfo r5 = (io.ktor.util.reflect.TypeInfo) r5
            java.lang.Object r5 = r0.L$1
            java.lang.Object r5 = r0.L$0
            io.ktor.websocket.WebSocketSession r5 = (io.ktor.websocket.WebSocketSession) r5
            kotlin.ResultKt.throwOnFailure(r10)
            goto Lbe
        L44:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L4c:
            java.lang.Object r5 = r0.L$4
            r9 = r5
            java.nio.charset.Charset r9 = (java.nio.charset.Charset) r9
            java.lang.Object r5 = r0.L$3
            r8 = r5
            io.ktor.serialization.WebsocketContentConverter r8 = (io.ktor.serialization.WebsocketContentConverter) r8
            java.lang.Object r5 = r0.L$2
            r7 = r5
            io.ktor.util.reflect.TypeInfo r7 = (io.ktor.util.reflect.TypeInfo) r7
            java.lang.Object r6 = r0.L$1
            java.lang.Object r5 = r0.L$0
            io.ktor.websocket.WebSocketSession r5 = (io.ktor.websocket.WebSocketSession) r5
            kotlin.ResultKt.throwOnFailure(r10)
            goto L8b
        L65:
            kotlin.ResultKt.throwOnFailure(r10)
            r0.L$0 = r5
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$1 = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$2 = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$3 = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$4 = r10
            r0.label = r4
            java.lang.Object r10 = r8.serialize(r9, r7, r6, r0)
            if (r10 != r1) goto L8b
            goto Lbd
        L8b:
            io.ktor.websocket.Frame r10 = (io.ktor.websocket.Frame) r10
            kotlinx.coroutines.channels.SendChannel r2 = r5.getOutgoing()
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r0.L$0 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$1 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$2 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$3 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$4 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r0.L$5 = r5
            r0.label = r3
            java.lang.Object r5 = r2.send(r10, r0)
            if (r5 != r1) goto Lbe
        Lbd:
            return r1
        Lbe:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.serialization.WebsocketChannelSerializationKt.sendSerializedBase(io.ktor.websocket.WebSocketSession, java.lang.Object, io.ktor.util.reflect.TypeInfo, io.ktor.serialization.WebsocketContentConverter, java.nio.charset.Charset, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00bb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x00bc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x00be  */
    /* JADX WARN: Code duplicated, block: B:38:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Instruction removed from duplicated block: B:38:0x00d7, please report this as an issue */
    public static final Object receiveDeserializedBase(WebSocketSession webSocketSession, TypeInfo typeInfo, WebsocketContentConverter websocketContentConverter, Charset charset, Continuation<Object> continuation) throws WebsocketDeserializeException {
        AnonymousClass2 anonymousClass2;
        TypeInfo typeInfo2;
        WebsocketContentConverter websocketContentConverter2;
        Charset charset2;
        WebSocketSession webSocketSession2;
        Frame frame;
        KType kotlinType;
        if (continuation instanceof AnonymousClass2) {
            anonymousClass2 = (AnonymousClass2) continuation;
            if ((anonymousClass2.label & Integer.MIN_VALUE) != 0) {
                anonymousClass2.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass2 = new AnonymousClass2(continuation);
            }
        } else {
            anonymousClass2 = new AnonymousClass2(continuation);
        }
        Object objReceive = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objReceive);
            ReceiveChannel<Frame> incoming = webSocketSession.getIncoming();
            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(webSocketSession);
            typeInfo2 = typeInfo;
            anonymousClass2.L$1 = typeInfo2;
            websocketContentConverter2 = websocketContentConverter;
            anonymousClass2.L$2 = websocketContentConverter2;
            charset2 = charset;
            anonymousClass2.L$3 = charset2;
            anonymousClass2.label = 1;
            objReceive = incoming.receive(anonymousClass2);
            if (objReceive != coroutine_suspended) {
                webSocketSession2 = webSocketSession;
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            Charset charset3 = (Charset) anonymousClass2.L$3;
            websocketContentConverter2 = (WebsocketContentConverter) anonymousClass2.L$2;
            TypeInfo typeInfo3 = (TypeInfo) anonymousClass2.L$1;
            webSocketSession2 = (WebSocketSession) anonymousClass2.L$0;
            ResultKt.throwOnFailure(objReceive);
            charset2 = charset3;
            typeInfo2 = typeInfo3;
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Frame frame2 = (Frame) anonymousClass2.L$4;
            typeInfo2 = (TypeInfo) anonymousClass2.L$1;
            ResultKt.throwOnFailure(objReceive);
            frame = frame2;
        }
        if (typeInfo2.getType().isInstance(objReceive)) {
            return objReceive;
        }
        if (objReceive == null) {
            kotlinType = typeInfo2.getKotlinType();
            if (kotlinType == null && kotlinType.getIsMarkedNullable()) {
                return null;
            }
            throw new WebsocketDeserializeException("Frame has null content", null, frame, 2, null);
        }
        throw new WebsocketDeserializeException("Can't deserialize value: expected value of type " + typeInfo2.getType().getSimpleName() + ", got " + Reflection.getOrCreateKotlinClass(objReceive.getClass()).getSimpleName(), null, frame, 2, null);
        Frame frame3 = (Frame) objReceive;
        if (!websocketContentConverter2.isApplicable(frame3)) {
            throw new WebsocketDeserializeException("Converter doesn't support frame type " + frame3.getFrameType().name(), null, frame3, 2, null);
        }
        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(webSocketSession2);
        anonymousClass2.L$1 = typeInfo2;
        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(websocketContentConverter2);
        anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(charset2);
        anonymousClass2.L$4 = frame3;
        anonymousClass2.label = 2;
        objReceive = websocketContentConverter2.deserialize(charset2, typeInfo2, frame3, anonymousClass2);
        if (objReceive != coroutine_suspended) {
            frame = frame3;
            if (typeInfo2.getType().isInstance(objReceive)) {
                return objReceive;
            }
            if (objReceive == null) {
                kotlinType = typeInfo2.getKotlinType();
                if (kotlinType == null) {
                }
                throw new WebsocketDeserializeException("Frame has null content", null, frame, 2, null);
            }
            throw new WebsocketDeserializeException("Can't deserialize value: expected value of type " + typeInfo2.getType().getSimpleName() + ", got " + Reflection.getOrCreateKotlinClass(objReceive.getClass()).getSimpleName(), null, frame, 2, null);
        }
        return coroutine_suspended;
    }

    public static final /* synthetic */ <T> Object sendSerializedBase(WebSocketSession webSocketSession, Object obj, WebsocketContentConverter websocketContentConverter, Charset charset, Continuation<? super Unit> continuation) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        try {
            Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        } catch (Throwable unused) {
        }
        sendSerializedBase(webSocketSession, obj, new TypeInfo(orCreateKotlinClass, null), websocketContentConverter, charset, continuation);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ <T> Object receiveDeserializedBase(WebSocketSession webSocketSession, WebsocketContentConverter websocketContentConverter, Charset charset, Continuation<Object> continuation) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        try {
            Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        } catch (Throwable unused) {
        }
        return receiveDeserializedBase(webSocketSession, new TypeInfo(orCreateKotlinClass, null), websocketContentConverter, charset, continuation);
    }
}

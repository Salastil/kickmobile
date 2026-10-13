package io.ktor.client.plugins.websocket;

import com.facebook.imageutils.JfifUtil;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.websocket.WebSocketSessionKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ReceiveChannel;

/* JADX INFO: compiled from: HttpStatement.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;", "io/ktor/client/statement/HttpStatement$body$4$1"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.websocket.BuildersKt$webSocket$$inlined$body$1", f = "builders.kt", i = {0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3}, l = {207, JfifUtil.MARKER_SOS, 220, 220}, m = "invokeSuspend", n = {"$this$body$iv", "$i$f$body", "result", "$completion", "it", "$i$a$-body-BuildersKt$webSocket$2", "result", "$completion", "it", "$i$a$-body-BuildersKt$webSocket$2", "result", "$completion", "it", "$i$a$-body-BuildersKt$webSocket$2"}, s = {"L$0", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0"}, v = 1)
public final class BuildersKt$webSocket$$inlined$body$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2 $block$inlined;
    final /* synthetic */ HttpResponse $response;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BuildersKt$webSocket$$inlined$body$1(HttpResponse httpResponse, Continuation continuation, Function2 function2) {
        super(2, continuation);
        this.$response = httpResponse;
        this.$block$inlined = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BuildersKt$webSocket$$inlined$body$1(this.$response, continuation, this.$block$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BuildersKt$webSocket$$inlined$body$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:42:0x0104  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        KType kTypeTypeOf;
        DefaultClientWebSocketSession defaultClientWebSocketSession;
        Continuation continuation;
        DefaultClientWebSocketSession defaultClientWebSocketSession2;
        DefaultClientWebSocketSession defaultClientWebSocketSession3;
        Throwable th;
        DefaultClientWebSocketSession defaultClientWebSocketSession4;
        DefaultClientWebSocketSession defaultClientWebSocketSession5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        int i2 = 0;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            HttpResponse httpResponse = this.$response;
            HttpClientCall call = httpResponse.getCall();
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(DefaultClientWebSocketSession.class);
            try {
                kTypeTypeOf = Reflection.typeOf(DefaultClientWebSocketSession.class);
            } catch (Throwable unused) {
                kTypeTypeOf = null;
            }
            this.L$0 = SpillingKt.nullOutSpilledVariable(httpResponse);
            this.I$0 = 0;
            this.label = 1;
            obj = call.bodyNullable(new TypeInfo(orCreateKotlinClass, kTypeTypeOf), this);
            if (obj != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i == 2) {
                i2 = this.I$0;
                defaultClientWebSocketSession3 = (DefaultClientWebSocketSession) this.L$2;
                continuation = (Continuation) this.L$1;
                defaultClientWebSocketSession = (DefaultClientWebSocketSession) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(defaultClientWebSocketSession);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(continuation);
                    this.L$2 = defaultClientWebSocketSession3;
                    this.I$0 = i2;
                    this.label = 3;
                    if (WebSocketSessionKt.close$default(defaultClientWebSocketSession3, null, this, 1, null) != coroutine_suspended) {
                        defaultClientWebSocketSession5 = defaultClientWebSocketSession3;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    defaultClientWebSocketSession2 = defaultClientWebSocketSession;
                    defaultClientWebSocketSession = defaultClientWebSocketSession3;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(defaultClientWebSocketSession2);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(continuation);
                    this.L$2 = defaultClientWebSocketSession;
                    this.L$3 = th;
                    this.I$0 = i2;
                    this.label = 4;
                    if (WebSocketSessionKt.close$default(defaultClientWebSocketSession, null, this, 1, null) != coroutine_suspended) {
                        th = th;
                        defaultClientWebSocketSession4 = defaultClientWebSocketSession;
                        ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) defaultClientWebSocketSession4.getIncoming(), (CancellationException) null, 1, (Object) null);
                        throw th;
                    }
                }
                return coroutine_suspended;
            }
            if (i != 3) {
                if (i != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                th = (Throwable) this.L$3;
                defaultClientWebSocketSession4 = (DefaultClientWebSocketSession) this.L$2;
                ResultKt.throwOnFailure(obj);
                ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) defaultClientWebSocketSession4.getIncoming(), (CancellationException) null, 1, (Object) null);
                throw th;
            }
            defaultClientWebSocketSession5 = (DefaultClientWebSocketSession) this.L$2;
            ResultKt.throwOnFailure(obj);
            ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) defaultClientWebSocketSession5.getIncoming(), (CancellationException) null, 1, (Object) null);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        if (obj != null) {
            defaultClientWebSocketSession = (DefaultClientWebSocketSession) obj;
            BuildersKt$webSocket$$inlined$body$1 buildersKt$webSocket$$inlined$body$1 = this;
            try {
                Function2 function2 = this.$block$inlined;
                this.L$0 = SpillingKt.nullOutSpilledVariable(defaultClientWebSocketSession);
                this.L$1 = SpillingKt.nullOutSpilledVariable(buildersKt$webSocket$$inlined$body$1);
                this.L$2 = defaultClientWebSocketSession;
                this.I$0 = 0;
                this.label = 2;
                if (function2.invoke(defaultClientWebSocketSession, this) != coroutine_suspended) {
                    continuation = buildersKt$webSocket$$inlined$body$1;
                    defaultClientWebSocketSession3 = defaultClientWebSocketSession;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(defaultClientWebSocketSession);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(continuation);
                    this.L$2 = defaultClientWebSocketSession3;
                    this.I$0 = i2;
                    this.label = 3;
                    if (WebSocketSessionKt.close$default(defaultClientWebSocketSession3, null, this, 1, null) != coroutine_suspended) {
                        defaultClientWebSocketSession5 = defaultClientWebSocketSession3;
                        ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) defaultClientWebSocketSession5.getIncoming(), (CancellationException) null, 1, (Object) null);
                        return Unit.INSTANCE;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                continuation = buildersKt$webSocket$$inlined$body$1;
                defaultClientWebSocketSession2 = defaultClientWebSocketSession;
                this.L$0 = SpillingKt.nullOutSpilledVariable(defaultClientWebSocketSession2);
                this.L$1 = SpillingKt.nullOutSpilledVariable(continuation);
                this.L$2 = defaultClientWebSocketSession;
                this.L$3 = th;
                this.I$0 = i2;
                this.label = 4;
                if (WebSocketSessionKt.close$default(defaultClientWebSocketSession, null, this, 1, null) != coroutine_suspended) {
                    th = th;
                    defaultClientWebSocketSession4 = defaultClientWebSocketSession;
                    ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) defaultClientWebSocketSession4.getIncoming(), (CancellationException) null, 1, (Object) null);
                    throw th;
                }
            }
            return coroutine_suspended;
        }
        throw new NullPointerException("null cannot be cast to non-null type io.ktor.client.plugins.websocket.DefaultClientWebSocketSession");
    }
}

package io.ktor.client.plugins.sse;

import io.ktor.sse.TypedServerSentEvent;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: ClientSSESession.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004R \u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR(\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lio/ktor/client/plugins/sse/SSESessionWithDeserialization;", "Lkotlinx/coroutines/CoroutineScope;", "", "bodyBuffer", "()[B", "Lkotlinx/coroutines/flow/Flow;", "Lio/ktor/sse/TypedServerSentEvent;", "", "getIncoming", "()Lkotlinx/coroutines/flow/Flow;", "incoming", "Lkotlin/Function2;", "Lio/ktor/util/reflect/TypeInfo;", "", "getDeserializer", "()Lkotlin/jvm/functions/Function2;", "deserializer", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface SSESessionWithDeserialization extends CoroutineScope {
    Function2<TypeInfo, String, Object> getDeserializer();

    Flow<TypedServerSentEvent<String>> getIncoming();

    /* JADX INFO: compiled from: ClientSSESession.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static byte[] bodyBuffer(SSESessionWithDeserialization sSESessionWithDeserialization) {
            return SSESessionWithDeserialization.super.bodyBuffer();
        }
    }

    default byte[] bodyBuffer() {
        return SSEBufferPolicyKt.getEMPTY();
    }
}

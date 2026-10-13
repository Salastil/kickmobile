package io.ktor.client.plugins.sse;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SSEBufferPolicy.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001b\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\b\"\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b\"\u001a\u0010\f\u001a\u00020\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/ktor/client/plugins/sse/SSEBufferPolicy;", "Lio/ktor/client/plugins/sse/BodyBuffer;", "toBodyBuffer", "(Lio/ktor/client/plugins/sse/SSEBufferPolicy;)Lio/ktor/client/plugins/sse/BodyBuffer;", "Lkotlin/collections/ArrayDeque;", "array", "", "toByteArray", "(Lkotlin/collections/ArrayDeque;)[B", "", "NEWLINE", "Ljava/lang/String;", "EMPTY", "[B", "getEMPTY", "()[B", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class SSEBufferPolicyKt {
    private static final byte[] EMPTY = new byte[0];
    private static final String NEWLINE = "\r\n";

    public static final BodyBuffer toBodyBuffer(SSEBufferPolicy sSEBufferPolicy) {
        Intrinsics.checkNotNullParameter(sSEBufferPolicy, "<this>");
        if (sSEBufferPolicy instanceof SSEBufferPolicy.Off) {
            return BodyBuffer.Empty.INSTANCE;
        }
        if (sSEBufferPolicy instanceof SSEBufferPolicy.LastEvent) {
            return new BodyBuffer.Events(1);
        }
        if (sSEBufferPolicy instanceof SSEBufferPolicy.LastEvents) {
            return new BodyBuffer.Events(((SSEBufferPolicy.LastEvents) sSEBufferPolicy).getCount());
        }
        if (sSEBufferPolicy instanceof SSEBufferPolicy.LastLines) {
            return new BodyBuffer.Lines(((SSEBufferPolicy.LastLines) sSEBufferPolicy).getCount());
        }
        if (sSEBufferPolicy instanceof SSEBufferPolicy.All) {
            return new BodyBuffer.Lines(Integer.MAX_VALUE);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] toByteArray(ArrayDeque<?> arrayDeque) {
        return StringsKt.encodeToByteArray(CollectionsKt.joinToString$default(arrayDeque, "\r\n", null, null, 0, null, null, 62, null));
    }

    public static final byte[] getEMPTY() {
        return EMPTY;
    }
}

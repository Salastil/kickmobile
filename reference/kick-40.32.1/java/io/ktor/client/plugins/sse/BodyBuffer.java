package io.ktor.client.plugins.sse;

import io.ktor.sse.ServerSentEvent;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SSEBufferPolicy.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0003\u000e\u000f\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\r\u0082\u0001\u0003\u0011\u0012\u0013¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lio/ktor/client/plugins/sse/BodyBuffer;", "", "", "line", "", "appendLine", "(Ljava/lang/String;)V", "Lio/ktor/sse/ServerSentEvent;", "event", "appendEvent", "(Lio/ktor/sse/ServerSentEvent;)V", "", "toByteArray", "()[B", "Events", "Lines", "Empty", "Lio/ktor/client/plugins/sse/BodyBuffer$Empty;", "Lio/ktor/client/plugins/sse/BodyBuffer$Events;", "Lio/ktor/client/plugins/sse/BodyBuffer$Lines;", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface BodyBuffer {
    default void appendEvent(ServerSentEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    default void appendLine(String line) {
        Intrinsics.checkNotNullParameter(line, "line");
    }

    /* JADX INFO: compiled from: SSEBufferPolicy.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void appendLine(BodyBuffer bodyBuffer, String line) {
            Intrinsics.checkNotNullParameter(line, "line");
            BodyBuffer.super.appendLine(line);
        }

        @Deprecated
        public static void appendEvent(BodyBuffer bodyBuffer, ServerSentEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            BodyBuffer.super.appendEvent(event);
        }

        @Deprecated
        public static byte[] toByteArray(BodyBuffer bodyBuffer) {
            return BodyBuffer.super.toByteArray();
        }
    }

    default byte[] toByteArray() {
        return SSEBufferPolicyKt.getEMPTY();
    }

    /* JADX INFO: compiled from: SSEBufferPolicy.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/ktor/client/plugins/sse/BodyBuffer$Events;", "Lio/ktor/client/plugins/sse/BodyBuffer;", "", "capacity", "<init>", "(I)V", "Lio/ktor/sse/ServerSentEvent;", "event", "", "appendEvent", "(Lio/ktor/sse/ServerSentEvent;)V", "", "toByteArray", "()[B", "I", "Lkotlin/collections/ArrayDeque;", "events", "Lkotlin/collections/ArrayDeque;", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Events implements BodyBuffer {
        private final int capacity;
        private final ArrayDeque<ServerSentEvent> events = new ArrayDeque<>();

        public Events(int i) {
            this.capacity = i;
        }

        @Override // io.ktor.client.plugins.sse.BodyBuffer
        public /* bridge */ void appendLine(String str) {
            super.appendLine(str);
        }

        @Override // io.ktor.client.plugins.sse.BodyBuffer
        public void appendEvent(ServerSentEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (this.events.size() == this.capacity) {
                this.events.removeFirst();
            }
            this.events.addLast(event);
        }

        @Override // io.ktor.client.plugins.sse.BodyBuffer
        public byte[] toByteArray() {
            return SSEBufferPolicyKt.toByteArray(this.events);
        }
    }

    /* JADX INFO: compiled from: SSEBufferPolicy.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/ktor/client/plugins/sse/BodyBuffer$Lines;", "Lio/ktor/client/plugins/sse/BodyBuffer;", "", "capacity", "<init>", "(I)V", "", "line", "", "appendLine", "(Ljava/lang/String;)V", "", "toByteArray", "()[B", "I", "Lkotlin/collections/ArrayDeque;", "lines", "Lkotlin/collections/ArrayDeque;", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Lines implements BodyBuffer {
        private final int capacity;
        private final ArrayDeque<String> lines = new ArrayDeque<>();

        public Lines(int i) {
            this.capacity = i;
        }

        @Override // io.ktor.client.plugins.sse.BodyBuffer
        public /* bridge */ void appendEvent(ServerSentEvent serverSentEvent) {
            super.appendEvent(serverSentEvent);
        }

        @Override // io.ktor.client.plugins.sse.BodyBuffer
        public void appendLine(String line) {
            Intrinsics.checkNotNullParameter(line, "line");
            if (this.lines.size() == this.capacity) {
                this.lines.removeFirst();
            }
            this.lines.addLast(line);
        }

        @Override // io.ktor.client.plugins.sse.BodyBuffer
        public byte[] toByteArray() {
            return SSEBufferPolicyKt.toByteArray(this.lines);
        }
    }

    /* JADX INFO: compiled from: SSEBufferPolicy.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/client/plugins/sse/BodyBuffer$Empty;", "Lio/ktor/client/plugins/sse/BodyBuffer;", "<init>", "()V", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Empty implements BodyBuffer {
        public static final Empty INSTANCE = new Empty();

        private Empty() {
        }

        @Override // io.ktor.client.plugins.sse.BodyBuffer
        public /* bridge */ void appendEvent(ServerSentEvent serverSentEvent) {
            super.appendEvent(serverSentEvent);
        }

        @Override // io.ktor.client.plugins.sse.BodyBuffer
        public /* bridge */ void appendLine(String str) {
            super.appendLine(str);
        }

        @Override // io.ktor.client.plugins.sse.BodyBuffer
        public /* bridge */ byte[] toByteArray() {
            return super.toByteArray();
        }
    }
}

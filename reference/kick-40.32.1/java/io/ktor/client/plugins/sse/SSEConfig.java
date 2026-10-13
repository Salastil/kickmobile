package io.ktor.client.plugins.sse;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: SSEConfig.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0006\u001a\u00020\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\b\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lio/ktor/client/plugins/sse/SSEConfig;", "", "<init>", "()V", "", "showCommentEvents", "showRetryEvents", "", "Z", "getShowCommentEvents$ktor_client_core", "()Z", "setShowCommentEvents$ktor_client_core", "(Z)V", "getShowRetryEvents$ktor_client_core", "setShowRetryEvents$ktor_client_core", "Lkotlin/time/Duration;", "reconnectionTime", "J", "getReconnectionTime-UwyO8pc", "()J", "setReconnectionTime-LRDsOJo", "(J)V", "", "maxReconnectionAttempts", "I", "getMaxReconnectionAttempts", "()I", "setMaxReconnectionAttempts", "(I)V", "Lio/ktor/client/plugins/sse/SSEBufferPolicy;", "bufferPolicy", "Lio/ktor/client/plugins/sse/SSEBufferPolicy;", "getBufferPolicy", "()Lio/ktor/client/plugins/sse/SSEBufferPolicy;", "setBufferPolicy", "(Lio/ktor/client/plugins/sse/SSEBufferPolicy;)V", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SSEConfig {
    private SSEBufferPolicy bufferPolicy;
    private int maxReconnectionAttempts;
    private long reconnectionTime;
    private boolean showCommentEvents;
    private boolean showRetryEvents;

    public SSEConfig() {
        Duration.Companion companion = Duration.INSTANCE;
        this.reconnectionTime = DurationKt.toDuration(3000, DurationUnit.MILLISECONDS);
        this.bufferPolicy = SSEBufferPolicy.Off.INSTANCE;
    }

    /* JADX INFO: renamed from: getShowCommentEvents$ktor_client_core, reason: from getter */
    public final boolean getShowCommentEvents() {
        return this.showCommentEvents;
    }

    public final void setShowCommentEvents$ktor_client_core(boolean z) {
        this.showCommentEvents = z;
    }

    /* JADX INFO: renamed from: getShowRetryEvents$ktor_client_core, reason: from getter */
    public final boolean getShowRetryEvents() {
        return this.showRetryEvents;
    }

    public final void setShowRetryEvents$ktor_client_core(boolean z) {
        this.showRetryEvents = z;
    }

    /* JADX INFO: renamed from: getReconnectionTime-UwyO8pc, reason: not valid java name and from getter */
    public final long getReconnectionTime() {
        return this.reconnectionTime;
    }

    /* JADX INFO: renamed from: setReconnectionTime-LRDsOJo, reason: not valid java name */
    public final void m12551setReconnectionTimeLRDsOJo(long j) {
        this.reconnectionTime = j;
    }

    public final int getMaxReconnectionAttempts() {
        return this.maxReconnectionAttempts;
    }

    public final void setMaxReconnectionAttempts(int i) {
        this.maxReconnectionAttempts = i;
    }

    public final void showCommentEvents() {
        this.showCommentEvents = true;
    }

    public final void showRetryEvents() {
        this.showRetryEvents = true;
    }

    public final SSEBufferPolicy getBufferPolicy() {
        return this.bufferPolicy;
    }

    public final void setBufferPolicy(SSEBufferPolicy sSEBufferPolicy) {
        Intrinsics.checkNotNullParameter(sSEBufferPolicy, "<set-?>");
        this.bufferPolicy = sSEBufferPolicy;
    }
}

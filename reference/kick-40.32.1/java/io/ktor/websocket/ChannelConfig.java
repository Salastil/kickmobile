package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebSocketChannelsConfig.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0011\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lio/ktor/websocket/ChannelConfig;", "", "", "capacity", "Lio/ktor/websocket/ChannelOverflow;", "onOverflow", "<init>", "(ILio/ktor/websocket/ChannelOverflow;)V", "I", "getCapacity", "()I", "Lio/ktor/websocket/ChannelOverflow;", "getOnOverflow", "()Lio/ktor/websocket/ChannelOverflow;", "", "getCanSuspend", "()Z", "canSuspend", "Companion", "ktor-websockets"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ChannelConfig {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ChannelConfig UNLIMITED = new ChannelConfig(Integer.MAX_VALUE, ChannelOverflow.SUSPEND);
    private final int capacity;
    private final ChannelOverflow onOverflow;

    public ChannelConfig(int i, ChannelOverflow onOverflow) {
        Intrinsics.checkNotNullParameter(onOverflow, "onOverflow");
        this.capacity = i;
        this.onOverflow = onOverflow;
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public final ChannelOverflow getOnOverflow() {
        return this.onOverflow;
    }

    public final boolean getCanSuspend() {
        return this.onOverflow == ChannelOverflow.SUSPEND && this.capacity != Integer.MAX_VALUE;
    }

    /* JADX INFO: compiled from: WebSocketChannelsConfig.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/websocket/ChannelConfig$Companion;", "", "<init>", "()V", "Lio/ktor/websocket/ChannelConfig;", "UNLIMITED", "Lio/ktor/websocket/ChannelConfig;", "getUNLIMITED", "()Lio/ktor/websocket/ChannelConfig;", "ktor-websockets"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ChannelConfig getUNLIMITED() {
            return ChannelConfig.UNLIMITED;
        }
    }
}

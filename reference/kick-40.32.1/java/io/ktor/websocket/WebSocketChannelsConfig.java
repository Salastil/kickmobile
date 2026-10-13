package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebSocketChannelsConfig.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\u0011¨\u0006\u0016"}, d2 = {"Lio/ktor/websocket/WebSocketChannelsConfig;", "", "<init>", "()V", "Lio/ktor/websocket/ChannelConfig;", "unlimited", "()Lio/ktor/websocket/ChannelConfig;", "", "capacity", "Lio/ktor/websocket/ChannelOverflow;", "onOverflow", "bounded", "(ILio/ktor/websocket/ChannelOverflow;)Lio/ktor/websocket/ChannelConfig;", "incoming", "Lio/ktor/websocket/ChannelConfig;", "getIncoming", "setIncoming", "(Lio/ktor/websocket/ChannelConfig;)V", "outgoing", "getOutgoing", "setOutgoing", "Companion", "ktor-websockets"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class WebSocketChannelsConfig {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final WebSocketChannelsConfig UNLIMITED;
    private ChannelConfig incoming = ChannelConfig.INSTANCE.getUNLIMITED();
    private ChannelConfig outgoing = ChannelConfig.INSTANCE.getUNLIMITED();

    public final ChannelConfig getIncoming() {
        return this.incoming;
    }

    public final void setIncoming(ChannelConfig channelConfig) {
        Intrinsics.checkNotNullParameter(channelConfig, "<set-?>");
        this.incoming = channelConfig;
    }

    public final ChannelConfig getOutgoing() {
        return this.outgoing;
    }

    public final void setOutgoing(ChannelConfig channelConfig) {
        Intrinsics.checkNotNullParameter(channelConfig, "<set-?>");
        this.outgoing = channelConfig;
    }

    public final ChannelConfig unlimited() {
        return ChannelConfig.INSTANCE.getUNLIMITED();
    }

    public static /* synthetic */ ChannelConfig bounded$default(WebSocketChannelsConfig webSocketChannelsConfig, int i, ChannelOverflow channelOverflow, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            channelOverflow = ChannelOverflow.SUSPEND;
        }
        return webSocketChannelsConfig.bounded(i, channelOverflow);
    }

    public final ChannelConfig bounded(int capacity, ChannelOverflow onOverflow) {
        Intrinsics.checkNotNullParameter(onOverflow, "onOverflow");
        return new ChannelConfig(capacity, onOverflow);
    }

    /* JADX INFO: compiled from: WebSocketChannelsConfig.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lio/ktor/websocket/WebSocketChannelsConfig$Companion;", "", "<init>", "()V", "Lio/ktor/websocket/WebSocketChannelsConfig;", "UNLIMITED", "Lio/ktor/websocket/WebSocketChannelsConfig;", "getUNLIMITED", "()Lio/ktor/websocket/WebSocketChannelsConfig;", "getUNLIMITED$annotations", "ktor-websockets"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getUNLIMITED$annotations() {
        }

        private Companion() {
        }

        public final WebSocketChannelsConfig getUNLIMITED() {
            return WebSocketChannelsConfig.UNLIMITED;
        }
    }

    static {
        WebSocketChannelsConfig webSocketChannelsConfig = new WebSocketChannelsConfig();
        webSocketChannelsConfig.incoming = webSocketChannelsConfig.unlimited();
        webSocketChannelsConfig.outgoing = webSocketChannelsConfig.unlimited();
        UNLIMITED = webSocketChannelsConfig;
    }
}

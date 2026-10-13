package io.ktor.websocket;

import com.datadog.trace.bootstrap.instrumentation.api.InstrumentationTags;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineName;
import org.slf4j.Logger;

/* JADX INFO: compiled from: DefaultWebSocketSession.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u001a)\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a3\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\n\"\u001e\u0010\r\u001a\u00060\u000bj\u0002`\f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012\"\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015\"\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015\"\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019\"\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c\".\u0010#\u001a\u0004\u0018\u00010\u001d*\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d8Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\"*\u0010(\u001a\u00020\u001d*\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001d8Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006)"}, d2 = {"Lio/ktor/websocket/WebSocketSession;", "session", "", "pingIntervalMillis", "timeoutMillis", "Lio/ktor/websocket/DefaultWebSocketSession;", "DefaultWebSocketSession", "(Lio/ktor/websocket/WebSocketSession;JJ)Lio/ktor/websocket/DefaultWebSocketSession;", "Lio/ktor/websocket/WebSocketChannelsConfig;", "channelsConfig", "(Lio/ktor/websocket/WebSocketSession;JJLio/ktor/websocket/WebSocketChannelsConfig;)Lio/ktor/websocket/DefaultWebSocketSession;", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "getLOGGER", "()Lorg/slf4j/Logger;", "PINGER_DISABLED", "J", "Lkotlinx/coroutines/CoroutineName;", "IncomingProcessorCoroutineName", "Lkotlinx/coroutines/CoroutineName;", "OutgoingProcessorCoroutineName", "Lio/ktor/websocket/CloseReason;", "NORMAL_CLOSE", "Lio/ktor/websocket/CloseReason;", "Lio/ktor/websocket/ChannelConfig;", "OUTGOING_CHANNEL_CONFIG", "Lio/ktor/websocket/ChannelConfig;", "Lkotlin/time/Duration;", "newDuration", "getPingInterval", "(Lio/ktor/websocket/DefaultWebSocketSession;)Lkotlin/time/Duration;", "setPingInterval-6Au4x4Y", "(Lio/ktor/websocket/DefaultWebSocketSession;Lkotlin/time/Duration;)V", "pingInterval", "getTimeout", "(Lio/ktor/websocket/DefaultWebSocketSession;)J", "setTimeout-HG0u8IE", "(Lio/ktor/websocket/DefaultWebSocketSession;J)V", InstrumentationTags.TIMEOUT, "ktor-websockets"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DefaultWebSocketSessionKt {
    private static final ChannelConfig OUTGOING_CHANNEL_CONFIG;
    public static final long PINGER_DISABLED = 0;
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.websocket.WebSocket");
    private static final CoroutineName IncomingProcessorCoroutineName = new CoroutineName("ws-incoming-processor");
    private static final CoroutineName OutgoingProcessorCoroutineName = new CoroutineName("ws-outgoing-processor");
    private static final CloseReason NORMAL_CLOSE = new CloseReason(CloseReason.Codes.NORMAL, "OK");

    static {
        Integer outgoing_channel_capacity = UtilsKt.getOUTGOING_CHANNEL_CAPACITY();
        OUTGOING_CHANNEL_CONFIG = outgoing_channel_capacity != null ? new ChannelConfig(outgoing_channel_capacity.intValue(), ChannelOverflow.SUSPEND) : null;
    }

    public static final Logger getLOGGER() {
        return LOGGER;
    }

    public static /* synthetic */ DefaultWebSocketSession DefaultWebSocketSession$default(WebSocketSession webSocketSession, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        if ((i & 4) != 0) {
            j2 = 15000;
        }
        return DefaultWebSocketSession(webSocketSession, j, j2);
    }

    public static final DefaultWebSocketSession DefaultWebSocketSession(WebSocketSession session, long j, long j2) {
        Intrinsics.checkNotNullParameter(session, "session");
        if (session instanceof DefaultWebSocketSession) {
            throw new IllegalArgumentException("Cannot wrap other DefaultWebSocketSession".toString());
        }
        ChannelConfig unlimited = ChannelConfig.INSTANCE.getUNLIMITED();
        ChannelConfig unlimited2 = OUTGOING_CHANNEL_CONFIG;
        if (unlimited2 == null) {
            unlimited2 = ChannelConfig.INSTANCE.getUNLIMITED();
        }
        return new DefaultWebSocketSessionImpl(session, j, j2, unlimited, unlimited2);
    }

    public static /* synthetic */ DefaultWebSocketSession DefaultWebSocketSession$default(WebSocketSession webSocketSession, long j, long j2, WebSocketChannelsConfig webSocketChannelsConfig, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = 15000;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            webSocketChannelsConfig = WebSocketChannelsConfig.INSTANCE.getUNLIMITED();
        }
        return DefaultWebSocketSession(webSocketSession, j3, j4, webSocketChannelsConfig);
    }

    public static final DefaultWebSocketSession DefaultWebSocketSession(WebSocketSession session, long j, long j2, WebSocketChannelsConfig channelsConfig) {
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(channelsConfig, "channelsConfig");
        if (session instanceof DefaultWebSocketSession) {
            throw new IllegalArgumentException("Cannot wrap other DefaultWebSocketSession".toString());
        }
        return new DefaultWebSocketSessionImpl(session, j, j2, channelsConfig.getIncoming(), channelsConfig.getOutgoing());
    }

    public static final Duration getPingInterval(DefaultWebSocketSession defaultWebSocketSession) {
        Intrinsics.checkNotNullParameter(defaultWebSocketSession, "<this>");
        Long lValueOf = Long.valueOf(defaultWebSocketSession.getPingIntervalMillis());
        if (lValueOf.longValue() <= 0) {
            lValueOf = null;
        }
        if (lValueOf == null) {
            return null;
        }
        Duration.Companion companion = Duration.INSTANCE;
        return Duration.m14062boximpl(DurationKt.toDuration(lValueOf.longValue(), DurationUnit.MILLISECONDS));
    }

    /* JADX INFO: renamed from: setPingInterval-6Au4x4Y, reason: not valid java name */
    public static final void m12665setPingInterval6Au4x4Y(DefaultWebSocketSession pingInterval, Duration duration) {
        Intrinsics.checkNotNullParameter(pingInterval, "$this$pingInterval");
        pingInterval.setPingIntervalMillis(duration != null ? Duration.m14075getInWholeMillisecondsimpl(duration.getRawValue()) : 0L);
    }

    public static final long getTimeout(DefaultWebSocketSession defaultWebSocketSession) {
        Intrinsics.checkNotNullParameter(defaultWebSocketSession, "<this>");
        Duration.Companion companion = Duration.INSTANCE;
        return DurationKt.toDuration(defaultWebSocketSession.getTimeoutMillis(), DurationUnit.MILLISECONDS);
    }

    /* JADX INFO: renamed from: setTimeout-HG0u8IE, reason: not valid java name */
    public static final void m12666setTimeoutHG0u8IE(DefaultWebSocketSession timeout, long j) {
        Intrinsics.checkNotNullParameter(timeout, "$this$timeout");
        timeout.setTimeoutMillis(Duration.m14075getInWholeMillisecondsimpl(j));
    }
}

package io.ktor.client.plugins.websocket;

import androidx.collection.SieveCacheKt;
import io.ktor.websocket.WebSocketExtensionsConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: Durations.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a!\u0010\u0007\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\"\u0018\u0010\u0001\u001a\u0004\u0018\u00010\u0000*\u00020\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\t\".\u0010\u0001\u001a\u0004\u0018\u00010\u0000*\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00008Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lkotlin/time/Duration;", "pingInterval", "", "maxFrameSize", "Lio/ktor/client/plugins/websocket/WebSockets;", "WebSockets-dnQKTGw", "(Lkotlin/time/Duration;J)Lio/ktor/client/plugins/websocket/WebSockets;", "WebSockets", "getPingInterval", "(Lio/ktor/client/plugins/websocket/WebSockets;)Lkotlin/time/Duration;", "Lio/ktor/client/plugins/websocket/WebSockets$Config;", "new", "(Lio/ktor/client/plugins/websocket/WebSockets$Config;)Lkotlin/time/Duration;", "setPingInterval-6Au4x4Y", "(Lio/ktor/client/plugins/websocket/WebSockets$Config;Lkotlin/time/Duration;)V", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DurationsKt {
    /* JADX INFO: renamed from: WebSockets-dnQKTGw$default, reason: not valid java name */
    public static /* synthetic */ WebSockets m12553WebSocketsdnQKTGw$default(Duration duration, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = SieveCacheKt.NodeLinkMask;
        }
        return m12552WebSocketsdnQKTGw(duration, j);
    }

    /* JADX INFO: renamed from: WebSockets-dnQKTGw, reason: not valid java name */
    public static final WebSockets m12552WebSocketsdnQKTGw(Duration duration, long j) {
        return new WebSockets(duration != null ? Duration.m14075getInWholeMillisecondsimpl(duration.getRawValue()) : 0L, j, new WebSocketExtensionsConfig(), null, null, 24, null);
    }

    public static final Duration getPingInterval(WebSockets webSockets) {
        Intrinsics.checkNotNullParameter(webSockets, "<this>");
        Long lValueOf = Long.valueOf(webSockets.getPingIntervalMillis());
        if (lValueOf.longValue() <= 0) {
            lValueOf = null;
        }
        if (lValueOf == null) {
            return null;
        }
        Duration.Companion companion = Duration.INSTANCE;
        return Duration.m14062boximpl(DurationKt.toDuration(lValueOf.longValue(), DurationUnit.MILLISECONDS));
    }

    public static final Duration getPingInterval(WebSockets.Config config) {
        Intrinsics.checkNotNullParameter(config, "<this>");
        Long lValueOf = Long.valueOf(config.getPingIntervalMillis());
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
    public static final void m12554setPingInterval6Au4x4Y(WebSockets.Config pingInterval, Duration duration) {
        Intrinsics.checkNotNullParameter(pingInterval, "$this$pingInterval");
        pingInterval.setPingIntervalMillis(duration != null ? Duration.m14075getInWholeMillisecondsimpl(duration.getRawValue()) : 0L);
    }
}

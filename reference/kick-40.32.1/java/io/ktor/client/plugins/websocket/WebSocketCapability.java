package io.ktor.client.plugins.websocket;

import io.ktor.client.engine.HttpClientEngineCapability;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: compiled from: WebSockets.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0083\u0004¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000b\u001a\u00020\nHÖ\u0081\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u000e\u001a\u00020\rHÖ\u0081\u0004¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/ktor/client/plugins/websocket/WebSocketCapability;", "Lio/ktor/client/engine/HttpClientEngineCapability;", "", "<init>", "()V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class WebSocketCapability implements HttpClientEngineCapability<Unit> {
    public static final WebSocketCapability INSTANCE = new WebSocketCapability();

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WebSocketCapability)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return -1146563391;
    }

    public String toString() {
        return "WebSocketCapability";
    }

    private WebSocketCapability() {
    }
}

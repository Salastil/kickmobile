package io.github.centrifugal.centrifuge;

/* JADX INFO: loaded from: classes9.dex */
public class DisconnectedEvent {
    private final int code;
    private final String reason;

    public DisconnectedEvent(int i, String str) {
        this.code = i;
        this.reason = str;
    }

    public String getReason() {
        return this.reason;
    }

    public int getCode() {
        return this.code;
    }
}

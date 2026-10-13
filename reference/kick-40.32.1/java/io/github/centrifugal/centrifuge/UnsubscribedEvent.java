package io.github.centrifugal.centrifuge;

/* JADX INFO: loaded from: classes9.dex */
public class UnsubscribedEvent {
    private final int code;
    private final String reason;

    public UnsubscribedEvent(int i, String str) {
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

package io.github.centrifugal.centrifuge;

/* JADX INFO: loaded from: classes9.dex */
class ServerSubscription {
    private String epoch;
    private long offset;
    private boolean recoverable;

    long getOffset() {
        return this.offset;
    }

    String getEpoch() {
        return this.epoch;
    }

    boolean getRecoverable() {
        return this.recoverable;
    }

    ServerSubscription(Boolean bool, long j, String str) {
        this.recoverable = bool.booleanValue();
        this.offset = j;
        this.epoch = str;
    }

    void setLastOffset(long j) {
        this.offset = j;
    }

    void setLastEpoch(String str) {
        this.epoch = str;
    }

    void setRecoverable(Boolean bool) {
        this.recoverable = bool.booleanValue();
    }
}

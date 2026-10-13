package io.github.centrifugal.centrifuge;

import io.github.centrifugal.centrifuge.internal.protocol.Protocol;

/* JADX INFO: loaded from: classes9.dex */
public class StreamPosition {
    private String epoch;
    private long offset;

    public StreamPosition() {
    }

    public StreamPosition(long j, String str) {
        this.offset = j;
        this.epoch = str;
    }

    long getOffset() {
        return this.offset;
    }

    void setOffset(long j) {
        this.offset = j;
    }

    String getEpoch() {
        return this.epoch;
    }

    void setEpoch(String str) {
        this.epoch = str;
    }

    Protocol.StreamPosition toProto() {
        return Protocol.StreamPosition.newBuilder().setEpoch(this.epoch).setOffset(this.offset).build();
    }
}

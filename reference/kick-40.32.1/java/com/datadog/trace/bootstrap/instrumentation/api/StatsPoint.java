package com.datadog.trace.bootstrap.instrumentation.api;

import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes6.dex */
public class StatsPoint implements InboxItem {
    private final long edgeLatencyNano;
    private final List<String> edgeTags;
    private final long hash;
    private final long parentHash;
    private final long pathwayLatencyNano;
    private final long payloadSizeBytes;
    private final long timestampNanos;

    public StatsPoint(List<String> list, long j, long j2, long j3, long j4, long j5, long j6) {
        this.edgeTags = list;
        this.hash = j;
        this.parentHash = j2;
        this.timestampNanos = j3;
        this.pathwayLatencyNano = j4;
        this.edgeLatencyNano = j5;
        this.payloadSizeBytes = j6;
    }

    public List<String> getEdgeTags() {
        return this.edgeTags;
    }

    public long getHash() {
        return this.hash;
    }

    public long getParentHash() {
        return this.parentHash;
    }

    public long getTimestampNanos() {
        return this.timestampNanos;
    }

    public long getPathwayLatencyNano() {
        return this.pathwayLatencyNano;
    }

    public long getEdgeLatencyNano() {
        return this.edgeLatencyNano;
    }

    public long getPayloadSizeBytes() {
        return this.payloadSizeBytes;
    }

    public String toString() {
        return "StatsPoint{tags='" + this.edgeTags + "', hash=" + this.hash + ", parentHash=" + this.parentHash + ", timestampNanos=" + this.timestampNanos + ", pathwayLatencyNano=" + this.pathwayLatencyNano + ", edgeLatencyNano=" + this.edgeLatencyNano + ", payloadSizeBytes=" + this.payloadSizeBytes + AbstractJsonLexerKt.END_OBJ;
    }
}

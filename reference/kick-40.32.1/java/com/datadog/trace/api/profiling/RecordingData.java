package com.datadog.trace.api.profiling;

import j$.time.Instant;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public abstract class RecordingData implements ProfilingSnapshot {
    protected final Instant end;
    protected final ProfilingSnapshot.Kind kind;
    protected final Instant start;

    public abstract String getName();

    public abstract RecordingInputStream getStream() throws IOException;

    public abstract void release();

    public RecordingData(Instant instant, Instant instant2, ProfilingSnapshot.Kind kind) {
        this.start = instant;
        this.end = instant2;
        this.kind = kind;
    }

    public final Instant getStart() {
        return this.start;
    }

    public final Instant getEnd() {
        return this.end;
    }

    public final ProfilingSnapshot.Kind getKind() {
        return this.kind;
    }

    public final String toString() {
        return "name=" + getName() + ", kind=" + getKind();
    }
}

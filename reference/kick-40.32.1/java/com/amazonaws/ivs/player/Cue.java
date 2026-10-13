package com.amazonaws.ivs.player;

import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Cue {
    public final long endTime;
    public final long startTime;

    public Cue(long j, long j2) {
        this.startTime = j;
        this.endTime = j2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cue)) {
            return false;
        }
        Cue cue = (Cue) obj;
        return this.startTime == cue.startTime && this.endTime == cue.endTime;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.startTime), Long.valueOf(this.endTime));
    }
}

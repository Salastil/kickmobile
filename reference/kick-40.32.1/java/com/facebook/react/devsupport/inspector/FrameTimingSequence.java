package com.facebook.react.devsupport.inspector;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FrameTimingSequence.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003JG\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011¨\u0006#"}, d2 = {"Lcom/facebook/react/devsupport/inspector/FrameTimingSequence;", "", "id", "", "threadId", "beginTimestamp", "", "endTimestamp", "screenshot", "", "vsyncIntervalNanos", "<init>", "(IIJJ[BJ)V", "getId", "()I", "getThreadId", "getBeginTimestamp", "()J", "getEndTimestamp", "getScreenshot", "()[B", "getVsyncIntervalNanos", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FrameTimingSequence {
    private final long beginTimestamp;
    private final long endTimestamp;
    private final int id;
    private final byte[] screenshot;
    private final int threadId;
    private final long vsyncIntervalNanos;

    public static /* synthetic */ FrameTimingSequence copy$default(FrameTimingSequence frameTimingSequence, int i, int i2, long j, long j2, byte[] bArr, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = frameTimingSequence.id;
        }
        if ((i3 & 2) != 0) {
            i2 = frameTimingSequence.threadId;
        }
        if ((i3 & 4) != 0) {
            j = frameTimingSequence.beginTimestamp;
        }
        if ((i3 & 8) != 0) {
            j2 = frameTimingSequence.endTimestamp;
        }
        if ((i3 & 16) != 0) {
            bArr = frameTimingSequence.screenshot;
        }
        if ((i3 & 32) != 0) {
            j3 = frameTimingSequence.vsyncIntervalNanos;
        }
        byte[] bArr2 = bArr;
        long j4 = j2;
        long j5 = j;
        return frameTimingSequence.copy(i, i2, j5, j4, bArr2, j3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getThreadId() {
        return this.threadId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getBeginTimestamp() {
        return this.beginTimestamp;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getEndTimestamp() {
        return this.endTimestamp;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final byte[] getScreenshot() {
        return this.screenshot;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getVsyncIntervalNanos() {
        return this.vsyncIntervalNanos;
    }

    public final FrameTimingSequence copy(int id, int threadId, long beginTimestamp, long endTimestamp, byte[] screenshot, long vsyncIntervalNanos) {
        return new FrameTimingSequence(id, threadId, beginTimestamp, endTimestamp, screenshot, vsyncIntervalNanos);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FrameTimingSequence)) {
            return false;
        }
        FrameTimingSequence frameTimingSequence = (FrameTimingSequence) other;
        return this.id == frameTimingSequence.id && this.threadId == frameTimingSequence.threadId && this.beginTimestamp == frameTimingSequence.beginTimestamp && this.endTimestamp == frameTimingSequence.endTimestamp && Intrinsics.areEqual(this.screenshot, frameTimingSequence.screenshot) && this.vsyncIntervalNanos == frameTimingSequence.vsyncIntervalNanos;
    }

    public int hashCode() {
        int iHashCode = ((((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.threadId)) * 31) + Long.hashCode(this.beginTimestamp)) * 31) + Long.hashCode(this.endTimestamp)) * 31;
        byte[] bArr = this.screenshot;
        return ((iHashCode + (bArr == null ? 0 : Arrays.hashCode(bArr))) * 31) + Long.hashCode(this.vsyncIntervalNanos);
    }

    public String toString() {
        return "FrameTimingSequence(id=" + this.id + ", threadId=" + this.threadId + ", beginTimestamp=" + this.beginTimestamp + ", endTimestamp=" + this.endTimestamp + ", screenshot=" + Arrays.toString(this.screenshot) + ", vsyncIntervalNanos=" + this.vsyncIntervalNanos + ")";
    }

    public FrameTimingSequence(int i, int i2, long j, long j2, byte[] bArr, long j3) {
        this.id = i;
        this.threadId = i2;
        this.beginTimestamp = j;
        this.endTimestamp = j2;
        this.screenshot = bArr;
        this.vsyncIntervalNanos = j3;
    }

    public /* synthetic */ FrameTimingSequence(int i, int i2, long j, long j2, byte[] bArr, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, j, j2, (i3 & 16) != 0 ? null : bArr, (i3 & 32) != 0 ? 0L : j3);
    }

    public final int getId() {
        return this.id;
    }

    public final int getThreadId() {
        return this.threadId;
    }

    public final long getBeginTimestamp() {
        return this.beginTimestamp;
    }

    public final long getEndTimestamp() {
        return this.endTimestamp;
    }

    public final byte[] getScreenshot() {
        return this.screenshot;
    }

    public final long getVsyncIntervalNanos() {
        return this.vsyncIntervalNanos;
    }
}

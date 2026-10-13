package com.datadog.android.rum.internal.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FrameMetricsData.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b>\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 U2\u00020\u0001:\u0001UB¥\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\t\u0010A\u001a\u00020\u000fHÆ\u0003J\t\u0010B\u001a\u00020\u0005HÆ\u0003J\t\u0010C\u001a\u00020\u0005HÆ\u0003J\t\u0010D\u001a\u00020\u0005HÆ\u0003J\t\u0010E\u001a\u00020\u0005HÆ\u0003J\t\u0010F\u001a\u00020\u0015HÆ\u0003J\t\u0010G\u001a\u00020\u0005HÆ\u0003J\t\u0010H\u001a\u00020\u0005HÆ\u0003J\t\u0010I\u001a\u00020\u0005HÆ\u0003J\t\u0010J\u001a\u00020\u0005HÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\t\u0010L\u001a\u00020\u0005HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\t\u0010N\u001a\u00020\u0005HÆ\u0003J©\u0001\u0010O\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u0015HÆ\u0001J\u0013\u0010P\u001a\u00020\u000f2\b\u0010Q\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010R\u001a\u00020\u0003HÖ\u0001J\t\u0010S\u001a\u00020THÖ\u0001R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001e\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010\u001aR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001e\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0018\"\u0004\b.\u0010\u001aR\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0018\"\u0004\b0\u0010\u001aR\u001e\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0018\"\u0004\b2\u0010\u001aR\u001e\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0018\"\u0004\b4\u0010\u001aR\u001e\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0018\"\u0004\b6\u0010\u001aR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0018\"\u0004\b8\u0010\u001aR\u001e\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0018\"\u0004\b:\u0010\u001aR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0018\"\u0004\b<\u0010\u001aR\u001e\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0018\"\u0004\b>\u0010\u001a¨\u0006V"}, d2 = {"Lcom/datadog/android/rum/internal/domain/FrameMetricsData;", "", "droppedFrames", "", "unknownDelayDuration", "", "inputHandlingDuration", "animationDuration", "layoutMeasureDuration", "drawDuration", "syncDuration", "commandIssueDuration", "swapBuffersDuration", "totalDuration", "firstDrawFrame", "", "intendedVsyncTimestamp", "vsyncTimestamp", "gpuDuration", "deadline", "displayRefreshRate", "", "(IJJJJJJJJJZJJJJD)V", "getAnimationDuration", "()J", "setAnimationDuration", "(J)V", "getCommandIssueDuration", "setCommandIssueDuration", "getDeadline", "setDeadline", "getDisplayRefreshRate", "()D", "setDisplayRefreshRate", "(D)V", "getDrawDuration", "setDrawDuration", "getDroppedFrames", "()I", "setDroppedFrames", "(I)V", "getFirstDrawFrame", "()Z", "setFirstDrawFrame", "(Z)V", "getGpuDuration", "setGpuDuration", "getInputHandlingDuration", "setInputHandlingDuration", "getIntendedVsyncTimestamp", "setIntendedVsyncTimestamp", "getLayoutMeasureDuration", "setLayoutMeasureDuration", "getSwapBuffersDuration", "setSwapBuffersDuration", "getSyncDuration", "setSyncDuration", "getTotalDuration", "setTotalDuration", "getUnknownDelayDuration", "setUnknownDelayDuration", "getVsyncTimestamp", "setVsyncTimestamp", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class FrameMetricsData {
    private static final double SIXTY_FPS = 60.0d;
    private long animationDuration;
    private long commandIssueDuration;
    private long deadline;
    private double displayRefreshRate;
    private long drawDuration;
    private int droppedFrames;
    private boolean firstDrawFrame;
    private long gpuDuration;
    private long inputHandlingDuration;
    private long intendedVsyncTimestamp;
    private long layoutMeasureDuration;
    private long swapBuffersDuration;
    private long syncDuration;
    private long totalDuration;
    private long unknownDelayDuration;
    private long vsyncTimestamp;

    public FrameMetricsData() {
        this(0, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, false, 0L, 0L, 0L, 0L, 0.0d, 65535, null);
    }

    public static /* synthetic */ FrameMetricsData copy$default(FrameMetricsData frameMetricsData, int i, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, boolean z, long j10, long j11, long j12, long j13, double d, int i2, Object obj) {
        double d2;
        long j14;
        int i3 = (i2 & 1) != 0 ? frameMetricsData.droppedFrames : i;
        long j15 = (i2 & 2) != 0 ? frameMetricsData.unknownDelayDuration : j;
        long j16 = (i2 & 4) != 0 ? frameMetricsData.inputHandlingDuration : j2;
        long j17 = (i2 & 8) != 0 ? frameMetricsData.animationDuration : j3;
        long j18 = (i2 & 16) != 0 ? frameMetricsData.layoutMeasureDuration : j4;
        long j19 = (i2 & 32) != 0 ? frameMetricsData.drawDuration : j5;
        long j20 = (i2 & 64) != 0 ? frameMetricsData.syncDuration : j6;
        int i4 = i3;
        long j21 = (i2 & 128) != 0 ? frameMetricsData.commandIssueDuration : j7;
        long j22 = (i2 & 256) != 0 ? frameMetricsData.swapBuffersDuration : j8;
        long j23 = (i2 & 512) != 0 ? frameMetricsData.totalDuration : j9;
        boolean z2 = (i2 & 1024) != 0 ? frameMetricsData.firstDrawFrame : z;
        long j24 = j23;
        long j25 = (i2 & 2048) != 0 ? frameMetricsData.intendedVsyncTimestamp : j10;
        long j26 = (i2 & 4096) != 0 ? frameMetricsData.vsyncTimestamp : j11;
        long j27 = (i2 & 8192) != 0 ? frameMetricsData.gpuDuration : j12;
        long j28 = (i2 & 16384) != 0 ? frameMetricsData.deadline : j13;
        if ((i2 & 32768) != 0) {
            j14 = j28;
            d2 = frameMetricsData.displayRefreshRate;
        } else {
            d2 = d;
            j14 = j28;
        }
        return frameMetricsData.copy(i4, j15, j16, j17, j18, j19, j20, j21, j22, j24, z2, j25, j26, j27, j14, d2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getDroppedFrames() {
        return this.droppedFrames;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final long getTotalDuration() {
        return this.totalDuration;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getFirstDrawFrame() {
        return this.firstDrawFrame;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final long getIntendedVsyncTimestamp() {
        return this.intendedVsyncTimestamp;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final long getVsyncTimestamp() {
        return this.vsyncTimestamp;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final long getGpuDuration() {
        return this.gpuDuration;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final long getDeadline() {
        return this.deadline;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final double getDisplayRefreshRate() {
        return this.displayRefreshRate;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getUnknownDelayDuration() {
        return this.unknownDelayDuration;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getInputHandlingDuration() {
        return this.inputHandlingDuration;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getAnimationDuration() {
        return this.animationDuration;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getLayoutMeasureDuration() {
        return this.layoutMeasureDuration;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getDrawDuration() {
        return this.drawDuration;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getSyncDuration() {
        return this.syncDuration;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final long getCommandIssueDuration() {
        return this.commandIssueDuration;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final long getSwapBuffersDuration() {
        return this.swapBuffersDuration;
    }

    public final FrameMetricsData copy(int droppedFrames, long unknownDelayDuration, long inputHandlingDuration, long animationDuration, long layoutMeasureDuration, long drawDuration, long syncDuration, long commandIssueDuration, long swapBuffersDuration, long totalDuration, boolean firstDrawFrame, long intendedVsyncTimestamp, long vsyncTimestamp, long gpuDuration, long deadline, double displayRefreshRate) {
        return new FrameMetricsData(droppedFrames, unknownDelayDuration, inputHandlingDuration, animationDuration, layoutMeasureDuration, drawDuration, syncDuration, commandIssueDuration, swapBuffersDuration, totalDuration, firstDrawFrame, intendedVsyncTimestamp, vsyncTimestamp, gpuDuration, deadline, displayRefreshRate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FrameMetricsData)) {
            return false;
        }
        FrameMetricsData frameMetricsData = (FrameMetricsData) other;
        return this.droppedFrames == frameMetricsData.droppedFrames && this.unknownDelayDuration == frameMetricsData.unknownDelayDuration && this.inputHandlingDuration == frameMetricsData.inputHandlingDuration && this.animationDuration == frameMetricsData.animationDuration && this.layoutMeasureDuration == frameMetricsData.layoutMeasureDuration && this.drawDuration == frameMetricsData.drawDuration && this.syncDuration == frameMetricsData.syncDuration && this.commandIssueDuration == frameMetricsData.commandIssueDuration && this.swapBuffersDuration == frameMetricsData.swapBuffersDuration && this.totalDuration == frameMetricsData.totalDuration && this.firstDrawFrame == frameMetricsData.firstDrawFrame && this.intendedVsyncTimestamp == frameMetricsData.intendedVsyncTimestamp && this.vsyncTimestamp == frameMetricsData.vsyncTimestamp && this.gpuDuration == frameMetricsData.gpuDuration && this.deadline == frameMetricsData.deadline && Double.compare(this.displayRefreshRate, frameMetricsData.displayRefreshRate) == 0;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((Integer.hashCode(this.droppedFrames) * 31) + Long.hashCode(this.unknownDelayDuration)) * 31) + Long.hashCode(this.inputHandlingDuration)) * 31) + Long.hashCode(this.animationDuration)) * 31) + Long.hashCode(this.layoutMeasureDuration)) * 31) + Long.hashCode(this.drawDuration)) * 31) + Long.hashCode(this.syncDuration)) * 31) + Long.hashCode(this.commandIssueDuration)) * 31) + Long.hashCode(this.swapBuffersDuration)) * 31) + Long.hashCode(this.totalDuration)) * 31) + Boolean.hashCode(this.firstDrawFrame)) * 31) + Long.hashCode(this.intendedVsyncTimestamp)) * 31) + Long.hashCode(this.vsyncTimestamp)) * 31) + Long.hashCode(this.gpuDuration)) * 31) + Long.hashCode(this.deadline)) * 31) + Double.hashCode(this.displayRefreshRate);
    }

    public String toString() {
        return "FrameMetricsData(droppedFrames=" + this.droppedFrames + ", unknownDelayDuration=" + this.unknownDelayDuration + ", inputHandlingDuration=" + this.inputHandlingDuration + ", animationDuration=" + this.animationDuration + ", layoutMeasureDuration=" + this.layoutMeasureDuration + ", drawDuration=" + this.drawDuration + ", syncDuration=" + this.syncDuration + ", commandIssueDuration=" + this.commandIssueDuration + ", swapBuffersDuration=" + this.swapBuffersDuration + ", totalDuration=" + this.totalDuration + ", firstDrawFrame=" + this.firstDrawFrame + ", intendedVsyncTimestamp=" + this.intendedVsyncTimestamp + ", vsyncTimestamp=" + this.vsyncTimestamp + ", gpuDuration=" + this.gpuDuration + ", deadline=" + this.deadline + ", displayRefreshRate=" + this.displayRefreshRate + ")";
    }

    public FrameMetricsData(int i, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, boolean z, long j10, long j11, long j12, long j13, double d) {
        this.droppedFrames = i;
        this.unknownDelayDuration = j;
        this.inputHandlingDuration = j2;
        this.animationDuration = j3;
        this.layoutMeasureDuration = j4;
        this.drawDuration = j5;
        this.syncDuration = j6;
        this.commandIssueDuration = j7;
        this.swapBuffersDuration = j8;
        this.totalDuration = j9;
        this.firstDrawFrame = z;
        this.intendedVsyncTimestamp = j10;
        this.vsyncTimestamp = j11;
        this.gpuDuration = j12;
        this.deadline = j13;
        this.displayRefreshRate = d;
    }

    public /* synthetic */ FrameMetricsData(int i, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, boolean z, long j10, long j11, long j12, long j13, double d, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? 0L : j, (i2 & 4) != 0 ? 0L : j2, (i2 & 8) != 0 ? 0L : j3, (i2 & 16) != 0 ? 0L : j4, (i2 & 32) != 0 ? 0L : j5, (i2 & 64) != 0 ? 0L : j6, (i2 & 128) != 0 ? 0L : j7, (i2 & 256) != 0 ? 0L : j8, (i2 & 512) != 0 ? 0L : j9, (i2 & 1024) == 0 ? z : false, (i2 & 2048) != 0 ? 0L : j10, (i2 & 4096) != 0 ? 0L : j11, (i2 & 8192) != 0 ? 0L : j12, (i2 & 16384) == 0 ? j13 : 0L, (i2 & 32768) != 0 ? 60.0d : d);
    }

    public final int getDroppedFrames() {
        return this.droppedFrames;
    }

    public final void setDroppedFrames(int i) {
        this.droppedFrames = i;
    }

    public final long getUnknownDelayDuration() {
        return this.unknownDelayDuration;
    }

    public final void setUnknownDelayDuration(long j) {
        this.unknownDelayDuration = j;
    }

    public final long getInputHandlingDuration() {
        return this.inputHandlingDuration;
    }

    public final void setInputHandlingDuration(long j) {
        this.inputHandlingDuration = j;
    }

    public final long getAnimationDuration() {
        return this.animationDuration;
    }

    public final void setAnimationDuration(long j) {
        this.animationDuration = j;
    }

    public final long getLayoutMeasureDuration() {
        return this.layoutMeasureDuration;
    }

    public final void setLayoutMeasureDuration(long j) {
        this.layoutMeasureDuration = j;
    }

    public final long getDrawDuration() {
        return this.drawDuration;
    }

    public final void setDrawDuration(long j) {
        this.drawDuration = j;
    }

    public final long getSyncDuration() {
        return this.syncDuration;
    }

    public final void setSyncDuration(long j) {
        this.syncDuration = j;
    }

    public final long getCommandIssueDuration() {
        return this.commandIssueDuration;
    }

    public final void setCommandIssueDuration(long j) {
        this.commandIssueDuration = j;
    }

    public final long getSwapBuffersDuration() {
        return this.swapBuffersDuration;
    }

    public final void setSwapBuffersDuration(long j) {
        this.swapBuffersDuration = j;
    }

    public final long getTotalDuration() {
        return this.totalDuration;
    }

    public final void setTotalDuration(long j) {
        this.totalDuration = j;
    }

    public final boolean getFirstDrawFrame() {
        return this.firstDrawFrame;
    }

    public final void setFirstDrawFrame(boolean z) {
        this.firstDrawFrame = z;
    }

    public final long getIntendedVsyncTimestamp() {
        return this.intendedVsyncTimestamp;
    }

    public final void setIntendedVsyncTimestamp(long j) {
        this.intendedVsyncTimestamp = j;
    }

    public final long getVsyncTimestamp() {
        return this.vsyncTimestamp;
    }

    public final void setVsyncTimestamp(long j) {
        this.vsyncTimestamp = j;
    }

    public final long getGpuDuration() {
        return this.gpuDuration;
    }

    public final void setGpuDuration(long j) {
        this.gpuDuration = j;
    }

    public final long getDeadline() {
        return this.deadline;
    }

    public final void setDeadline(long j) {
        this.deadline = j;
    }

    public final double getDisplayRefreshRate() {
        return this.displayRefreshRate;
    }

    public final void setDisplayRefreshRate(double d) {
        this.displayRefreshRate = d;
    }
}

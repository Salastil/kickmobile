package io.datazoom.sdk.player;

import com.facebook.hermes.intl.Constants;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* JADX INFO: compiled from: DzPlayer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lio/datazoom/sdk/player/TrackInfo;", "", "bitrate", "", ViewProps.HEIGHT, ViewProps.WIDTH, "<init>", "(III)V", "getBitrate", "()I", "getHeight", "getWidth", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class TrackInfo {
    private final int bitrate;
    private final int height;
    private final int width;

    public static /* synthetic */ TrackInfo copy$default(TrackInfo trackInfo, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = trackInfo.bitrate;
        }
        if ((i4 & 2) != 0) {
            i2 = trackInfo.height;
        }
        if ((i4 & 4) != 0) {
            i3 = trackInfo.width;
        }
        return trackInfo.copy(i, i2, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getBitrate() {
        return this.bitrate;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    public final TrackInfo copy(int bitrate, int height, int width) {
        return new TrackInfo(bitrate, height, width);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackInfo)) {
            return false;
        }
        TrackInfo trackInfo = (TrackInfo) other;
        return this.bitrate == trackInfo.bitrate && this.height == trackInfo.height && this.width == trackInfo.width;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.bitrate) * 31) + Integer.hashCode(this.height)) * 31) + Integer.hashCode(this.width);
    }

    public String toString() {
        return "TrackInfo(bitrate=" + this.bitrate + ", height=" + this.height + ", width=" + this.width + ")";
    }

    public TrackInfo(int i, int i2, int i3) {
        this.bitrate = i;
        this.height = i2;
        this.width = i3;
    }

    public final int getBitrate() {
        return this.bitrate;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }
}

package androidx.camera.video.internal.config;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MediaInfo.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Landroidx/camera/video/internal/config/MediaInfo;", "", "containerInfo", "Landroidx/camera/video/internal/config/ContainerInfo;", "videoMimeInfo", "Landroidx/camera/video/internal/config/VideoMimeInfo;", "audioMimeInfo", "Landroidx/camera/video/internal/config/AudioMimeInfo;", "<init>", "(Landroidx/camera/video/internal/config/ContainerInfo;Landroidx/camera/video/internal/config/VideoMimeInfo;Landroidx/camera/video/internal/config/AudioMimeInfo;)V", "getContainerInfo", "()Landroidx/camera/video/internal/config/ContainerInfo;", "getVideoMimeInfo", "()Landroidx/camera/video/internal/config/VideoMimeInfo;", "getAudioMimeInfo", "()Landroidx/camera/video/internal/config/AudioMimeInfo;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class MediaInfo {
    private final AudioMimeInfo audioMimeInfo;
    private final ContainerInfo containerInfo;
    private final VideoMimeInfo videoMimeInfo;

    public static /* synthetic */ MediaInfo copy$default(MediaInfo mediaInfo, ContainerInfo containerInfo, VideoMimeInfo videoMimeInfo, AudioMimeInfo audioMimeInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            containerInfo = mediaInfo.containerInfo;
        }
        if ((i & 2) != 0) {
            videoMimeInfo = mediaInfo.videoMimeInfo;
        }
        if ((i & 4) != 0) {
            audioMimeInfo = mediaInfo.audioMimeInfo;
        }
        return mediaInfo.copy(containerInfo, videoMimeInfo, audioMimeInfo);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ContainerInfo getContainerInfo() {
        return this.containerInfo;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final VideoMimeInfo getVideoMimeInfo() {
        return this.videoMimeInfo;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final AudioMimeInfo getAudioMimeInfo() {
        return this.audioMimeInfo;
    }

    public final MediaInfo copy(ContainerInfo containerInfo, VideoMimeInfo videoMimeInfo, AudioMimeInfo audioMimeInfo) {
        Intrinsics.checkNotNullParameter(containerInfo, "containerInfo");
        Intrinsics.checkNotNullParameter(videoMimeInfo, "videoMimeInfo");
        return new MediaInfo(containerInfo, videoMimeInfo, audioMimeInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaInfo)) {
            return false;
        }
        MediaInfo mediaInfo = (MediaInfo) other;
        return Intrinsics.areEqual(this.containerInfo, mediaInfo.containerInfo) && Intrinsics.areEqual(this.videoMimeInfo, mediaInfo.videoMimeInfo) && Intrinsics.areEqual(this.audioMimeInfo, mediaInfo.audioMimeInfo);
    }

    public int hashCode() {
        int iHashCode = ((this.containerInfo.hashCode() * 31) + this.videoMimeInfo.hashCode()) * 31;
        AudioMimeInfo audioMimeInfo = this.audioMimeInfo;
        return iHashCode + (audioMimeInfo == null ? 0 : audioMimeInfo.hashCode());
    }

    public String toString() {
        return "MediaInfo(containerInfo=" + this.containerInfo + ", videoMimeInfo=" + this.videoMimeInfo + ", audioMimeInfo=" + this.audioMimeInfo + ')';
    }

    public MediaInfo(ContainerInfo containerInfo, VideoMimeInfo videoMimeInfo, AudioMimeInfo audioMimeInfo) {
        Intrinsics.checkNotNullParameter(containerInfo, "containerInfo");
        Intrinsics.checkNotNullParameter(videoMimeInfo, "videoMimeInfo");
        this.containerInfo = containerInfo;
        this.videoMimeInfo = videoMimeInfo;
        this.audioMimeInfo = audioMimeInfo;
    }

    public final ContainerInfo getContainerInfo() {
        return this.containerInfo;
    }

    public final VideoMimeInfo getVideoMimeInfo() {
        return this.videoMimeInfo;
    }

    public final AudioMimeInfo getAudioMimeInfo() {
        return this.audioMimeInfo;
    }
}

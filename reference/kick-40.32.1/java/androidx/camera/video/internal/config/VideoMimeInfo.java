package androidx.camera.video.internal.config;

import androidx.camera.core.impl.EncoderProfilesProxy;
import com.google.android.gms.common.Scopes;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VideoMimeInfo.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Landroidx/camera/video/internal/config/VideoMimeInfo;", "Landroidx/camera/video/internal/config/MimeInfo;", "mimeType", "", Scopes.PROFILE, "", "compatibleVideoProfile", "Landroidx/camera/core/impl/EncoderProfilesProxy$VideoProfileProxy;", "<init>", "(Ljava/lang/String;ILandroidx/camera/core/impl/EncoderProfilesProxy$VideoProfileProxy;)V", "getMimeType", "()Ljava/lang/String;", "getProfile", "()I", "getCompatibleVideoProfile", "()Landroidx/camera/core/impl/EncoderProfilesProxy$VideoProfileProxy;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class VideoMimeInfo implements MimeInfo {
    private final EncoderProfilesProxy.VideoProfileProxy compatibleVideoProfile;
    private final String mimeType;
    private final int profile;

    public static /* synthetic */ VideoMimeInfo copy$default(VideoMimeInfo videoMimeInfo, String str, int i, EncoderProfilesProxy.VideoProfileProxy videoProfileProxy, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = videoMimeInfo.mimeType;
        }
        if ((i2 & 2) != 0) {
            i = videoMimeInfo.profile;
        }
        if ((i2 & 4) != 0) {
            videoProfileProxy = videoMimeInfo.compatibleVideoProfile;
        }
        return videoMimeInfo.copy(str, i, videoProfileProxy);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getProfile() {
        return this.profile;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final EncoderProfilesProxy.VideoProfileProxy getCompatibleVideoProfile() {
        return this.compatibleVideoProfile;
    }

    public final VideoMimeInfo copy(String mimeType, int profile, EncoderProfilesProxy.VideoProfileProxy compatibleVideoProfile) {
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        return new VideoMimeInfo(mimeType, profile, compatibleVideoProfile);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoMimeInfo)) {
            return false;
        }
        VideoMimeInfo videoMimeInfo = (VideoMimeInfo) other;
        return Intrinsics.areEqual(this.mimeType, videoMimeInfo.mimeType) && this.profile == videoMimeInfo.profile && Intrinsics.areEqual(this.compatibleVideoProfile, videoMimeInfo.compatibleVideoProfile);
    }

    public int hashCode() {
        int iHashCode = ((this.mimeType.hashCode() * 31) + Integer.hashCode(this.profile)) * 31;
        EncoderProfilesProxy.VideoProfileProxy videoProfileProxy = this.compatibleVideoProfile;
        return iHashCode + (videoProfileProxy == null ? 0 : videoProfileProxy.hashCode());
    }

    public String toString() {
        return "VideoMimeInfo(mimeType=" + this.mimeType + ", profile=" + this.profile + ", compatibleVideoProfile=" + this.compatibleVideoProfile + ')';
    }

    public VideoMimeInfo(String mimeType, int i, EncoderProfilesProxy.VideoProfileProxy videoProfileProxy) {
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        this.mimeType = mimeType;
        this.profile = i;
        this.compatibleVideoProfile = videoProfileProxy;
    }

    public /* synthetic */ VideoMimeInfo(String str, int i, EncoderProfilesProxy.VideoProfileProxy videoProfileProxy, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? -1 : i, (i2 & 4) != 0 ? null : videoProfileProxy);
    }

    @Override // androidx.camera.video.internal.config.MimeInfo
    public String getMimeType() {
        return this.mimeType;
    }

    @Override // androidx.camera.video.internal.config.MimeInfo
    public int getProfile() {
        return this.profile;
    }

    public final EncoderProfilesProxy.VideoProfileProxy getCompatibleVideoProfile() {
        return this.compatibleVideoProfile;
    }
}

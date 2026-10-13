package androidx.camera.video.internal.config;

import com.datadog.android.webview.internal.rum.WebViewRumEventMapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FormatCombo.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0005HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\u00020\u0003¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u0019"}, d2 = {"Landroidx/camera/video/internal/config/FormatCombo;", "", WebViewRumEventMapper.CONTAINER_KEY_NAME, "", "videoMime", "", "audioMime", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getContainer$annotations", "()V", "getContainer", "()I", "getVideoMime", "()Ljava/lang/String;", "getAudioMime", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class FormatCombo {
    private final String audioMime;
    private final int container;
    private final String videoMime;

    public static /* synthetic */ FormatCombo copy$default(FormatCombo formatCombo, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = formatCombo.container;
        }
        if ((i2 & 2) != 0) {
            str = formatCombo.videoMime;
        }
        if ((i2 & 4) != 0) {
            str2 = formatCombo.audioMime;
        }
        return formatCombo.copy(i, str, str2);
    }

    public static /* synthetic */ void getContainer$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getContainer() {
        return this.container;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getVideoMime() {
        return this.videoMime;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAudioMime() {
        return this.audioMime;
    }

    public final FormatCombo copy(int container, String videoMime, String audioMime) {
        return new FormatCombo(container, videoMime, audioMime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FormatCombo)) {
            return false;
        }
        FormatCombo formatCombo = (FormatCombo) other;
        return this.container == formatCombo.container && Intrinsics.areEqual(this.videoMime, formatCombo.videoMime) && Intrinsics.areEqual(this.audioMime, formatCombo.audioMime);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.container) * 31;
        String str = this.videoMime;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.audioMime;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "FormatCombo(container=" + this.container + ", videoMime=" + this.videoMime + ", audioMime=" + this.audioMime + ')';
    }

    public FormatCombo(int i, String str, String str2) {
        this.container = i;
        this.videoMime = str;
        this.audioMime = str2;
        if (str == null && str2 == null) {
            throw new IllegalArgumentException("FormatCombo must have at least one valid track. Both videoMime and audioMime cannot be null.".toString());
        }
    }

    public final int getContainer() {
        return this.container;
    }

    public final String getVideoMime() {
        return this.videoMime;
    }

    public final String getAudioMime() {
        return this.audioMime;
    }
}

package androidx.camera.video;

import com.facebook.react.uimanager.ViewProps;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: VideoSpec.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB;\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\tH\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Landroidx/camera/video/VideoSpec;", "", "qualitySelector", "Landroidx/camera/video/QualitySelector;", "encodeFrameRate", "", "bitrate", ViewProps.ASPECT_RATIO, "mimeType", "", "<init>", "(Landroidx/camera/video/QualitySelector;IIILjava/lang/String;)V", "getQualitySelector", "()Landroidx/camera/video/QualitySelector;", "getEncodeFrameRate", "()I", "getBitrate", "getAspectRatio", "getMimeType", "()Ljava/lang/String;", "toBuilder", "Landroidx/camera/video/VideoSpec$Builder;", "toString", "equals", "", "other", "hashCode", "Builder", "Companion", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoSpec {
    public static final int BITRATE_UNSPECIFIED = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final VideoSpec DEFAULT;
    public static final int ENCODE_FRAME_RATE_UNSPECIFIED = 0;
    public static final String MIME_TYPE_UNSPECIFIED = "video/*";
    private static final QualitySelector QUALITY_SELECTOR_UNSPECIFIED;
    private final int aspectRatio;
    private final int bitrate;
    private final int encodeFrameRate;
    private final String mimeType;
    private final QualitySelector qualitySelector;

    public VideoSpec() {
        this(null, 0, 0, 0, null, 31, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoSpec(QualitySelector qualitySelector) {
        this(qualitySelector, 0, 0, 0, null, 30, null);
        Intrinsics.checkNotNullParameter(qualitySelector, "qualitySelector");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoSpec(QualitySelector qualitySelector, int i) {
        this(qualitySelector, i, 0, 0, null, 28, null);
        Intrinsics.checkNotNullParameter(qualitySelector, "qualitySelector");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoSpec(QualitySelector qualitySelector, int i, int i2) {
        this(qualitySelector, i, i2, 0, null, 24, null);
        Intrinsics.checkNotNullParameter(qualitySelector, "qualitySelector");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoSpec(QualitySelector qualitySelector, int i, int i2, int i3) {
        this(qualitySelector, i, i2, i3, null, 16, null);
        Intrinsics.checkNotNullParameter(qualitySelector, "qualitySelector");
    }

    @JvmStatic
    public static final Builder builder() {
        return INSTANCE.builder();
    }

    public VideoSpec(QualitySelector qualitySelector, int i, int i2, int i3, String mimeType) {
        Intrinsics.checkNotNullParameter(qualitySelector, "qualitySelector");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        this.qualitySelector = qualitySelector;
        this.encodeFrameRate = i;
        this.bitrate = i2;
        this.aspectRatio = i3;
        this.mimeType = mimeType;
    }

    public /* synthetic */ VideoSpec(QualitySelector qualitySelector, int i, int i2, int i3, String str, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? QUALITY_SELECTOR_UNSPECIFIED : qualitySelector, (i4 & 2) != 0 ? 0 : i, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? -1 : i3, (i4 & 16) != 0 ? MIME_TYPE_UNSPECIFIED : str);
    }

    public final QualitySelector getQualitySelector() {
        return this.qualitySelector;
    }

    public final int getEncodeFrameRate() {
        return this.encodeFrameRate;
    }

    public final int getBitrate() {
        return this.bitrate;
    }

    public final int getAspectRatio() {
        return this.aspectRatio;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final Builder toBuilder() {
        return new Builder().setQualitySelector(this.qualitySelector).setEncodeFrameRate(this.encodeFrameRate).setBitrate(this.bitrate).setAspectRatio(this.aspectRatio).setMimeType(this.mimeType);
    }

    public String toString() {
        return "VideoSpec{qualitySelector=" + this.qualitySelector + ", encodeFrameRate=" + this.encodeFrameRate + ", bitrate=" + this.bitrate + ", aspectRatio=" + this.aspectRatio + ", mimeType=" + this.mimeType + AbstractJsonLexerKt.END_OBJ;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoSpec)) {
            return false;
        }
        VideoSpec videoSpec = (VideoSpec) other;
        return Intrinsics.areEqual(this.qualitySelector, videoSpec.qualitySelector) && this.encodeFrameRate == videoSpec.encodeFrameRate && this.bitrate == videoSpec.bitrate && this.aspectRatio == videoSpec.aspectRatio && Intrinsics.areEqual(this.mimeType, videoSpec.mimeType);
    }

    public int hashCode() {
        return Objects.hash(this.qualitySelector, Integer.valueOf(this.encodeFrameRate), Integer.valueOf(this.bitrate), Integer.valueOf(this.aspectRatio), this.mimeType);
    }

    /* JADX INFO: compiled from: VideoSpec.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0007J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0007J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/camera/video/VideoSpec$Builder;", "", "<init>", "()V", "qualitySelector", "Landroidx/camera/video/QualitySelector;", "encodeFrameRate", "", "bitrate", ViewProps.ASPECT_RATIO, "mimeType", "", "setQualitySelector", "setEncodeFrameRate", "frameRate", "setBitrate", "setAspectRatio", "setMimeType", "build", "Landroidx/camera/video/VideoSpec;", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Builder {
        private int bitrate;
        private int encodeFrameRate;
        private QualitySelector qualitySelector = VideoSpec.INSTANCE.getQUALITY_SELECTOR_UNSPECIFIED();
        private int aspectRatio = -1;
        private String mimeType = VideoSpec.MIME_TYPE_UNSPECIFIED;

        public final Builder setQualitySelector(QualitySelector qualitySelector) {
            Intrinsics.checkNotNullParameter(qualitySelector, "qualitySelector");
            this.qualitySelector = qualitySelector;
            return this;
        }

        public final Builder setEncodeFrameRate(int frameRate) {
            this.encodeFrameRate = frameRate;
            return this;
        }

        public final Builder setBitrate(int bitrate) {
            this.bitrate = bitrate;
            return this;
        }

        public final Builder setAspectRatio(int aspectRatio) {
            this.aspectRatio = aspectRatio;
            return this;
        }

        public final Builder setMimeType(String mimeType) {
            Intrinsics.checkNotNullParameter(mimeType, "mimeType");
            this.mimeType = mimeType;
            return this;
        }

        public final VideoSpec build() {
            return new VideoSpec(this.qualitySelector, this.encodeFrameRate, this.bitrate, this.aspectRatio, this.mimeType);
        }
    }

    /* JADX INFO: compiled from: VideoSpec.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Landroidx/camera/video/VideoSpec$Companion;", "", "<init>", "()V", "ENCODE_FRAME_RATE_UNSPECIFIED", "", "BITRATE_UNSPECIFIED", "MIME_TYPE_UNSPECIFIED", "", "QUALITY_SELECTOR_UNSPECIFIED", "Landroidx/camera/video/QualitySelector;", "getQUALITY_SELECTOR_UNSPECIFIED", "()Landroidx/camera/video/QualitySelector;", "DEFAULT", "Landroidx/camera/video/VideoSpec;", "getDEFAULT", "()Landroidx/camera/video/VideoSpec;", "builder", "Landroidx/camera/video/VideoSpec$Builder;", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final QualitySelector getQUALITY_SELECTOR_UNSPECIFIED() {
            return VideoSpec.QUALITY_SELECTOR_UNSPECIFIED;
        }

        public final VideoSpec getDEFAULT() {
            return VideoSpec.DEFAULT;
        }

        @JvmStatic
        public final Builder builder() {
            return new Builder();
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        QualitySelector NONE = QualitySelector.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        QUALITY_SELECTOR_UNSPECIFIED = NONE;
        DEFAULT = companion.builder().build();
    }
}

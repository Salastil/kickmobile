package androidx.camera.video;

import androidx.core.util.Consumer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: MediaSpec.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0003\u0018\u0019\u001aB'\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Landroidx/camera/video/MediaSpec;", "", "videoSpec", "Landroidx/camera/video/VideoSpec;", "audioSpec", "Landroidx/camera/video/AudioSpec;", "outputFormat", "", "<init>", "(Landroidx/camera/video/VideoSpec;Landroidx/camera/video/AudioSpec;I)V", "getVideoSpec", "()Landroidx/camera/video/VideoSpec;", "getAudioSpec", "()Landroidx/camera/video/AudioSpec;", "getOutputFormat", "()I", "toBuilder", "Landroidx/camera/video/MediaSpec$Builder;", "equals", "", "other", "hashCode", "toString", "", "Builder", "OutputFormat", "Companion", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MediaSpec {
    private static final int AAC_DEFAULT_PROFILE = 2;
    private static final String AUDIO_ENCODER_MIME_MPEG4_DEFAULT = "audio/mp4a-latm";
    private static final String AUDIO_ENCODER_MIME_WEBM_DEFAULT = "audio/vorbis";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int OUTPUT_FORMAT_MPEG_4 = 0;
    public static final int OUTPUT_FORMAT_UNSPECIFIED = -1;
    public static final int OUTPUT_FORMAT_WEBM = 1;
    private static final String VIDEO_ENCODER_MIME_MPEG4_DEFAULT = "video/avc";
    private static final String VIDEO_ENCODER_MIME_WEBM_DEFAULT = "video/x-vnd.on2.vp8";
    private final AudioSpec audioSpec;
    private final int outputFormat;
    private final VideoSpec videoSpec;

    /* JADX INFO: compiled from: MediaSpec.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/camera/video/MediaSpec$OutputFormat;", "", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface OutputFormat {
    }

    public MediaSpec() {
        this(null, null, 0, 7, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MediaSpec(VideoSpec videoSpec) {
        this(videoSpec, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(videoSpec, "videoSpec");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MediaSpec(VideoSpec videoSpec, AudioSpec audioSpec) {
        this(videoSpec, audioSpec, 0, 4, null);
        Intrinsics.checkNotNullParameter(videoSpec, "videoSpec");
        Intrinsics.checkNotNullParameter(audioSpec, "audioSpec");
    }

    @JvmStatic
    public static final Builder builder() {
        return INSTANCE.builder();
    }

    @JvmStatic
    public static final String outputFormatToAudioMime(int i) {
        return INSTANCE.outputFormatToAudioMime(i);
    }

    @JvmStatic
    public static final int outputFormatToAudioProfile(int i) {
        return INSTANCE.outputFormatToAudioProfile(i);
    }

    @JvmStatic
    public static final int outputFormatToMuxerFormat(int i) {
        return INSTANCE.outputFormatToMuxerFormat(i);
    }

    @JvmStatic
    public static final String outputFormatToVideoMime(int i) {
        return INSTANCE.outputFormatToVideoMime(i);
    }

    public MediaSpec(VideoSpec videoSpec, AudioSpec audioSpec, int i) {
        Intrinsics.checkNotNullParameter(videoSpec, "videoSpec");
        Intrinsics.checkNotNullParameter(audioSpec, "audioSpec");
        this.videoSpec = videoSpec;
        this.audioSpec = audioSpec;
        this.outputFormat = i;
    }

    public /* synthetic */ MediaSpec(VideoSpec videoSpec, AudioSpec audioSpec, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? VideoSpec.INSTANCE.getDEFAULT() : videoSpec, (i2 & 2) != 0 ? AudioSpec.INSTANCE.getDEFAULT() : audioSpec, (i2 & 4) != 0 ? -1 : i);
    }

    public final VideoSpec getVideoSpec() {
        return this.videoSpec;
    }

    public final AudioSpec getAudioSpec() {
        return this.audioSpec;
    }

    public final int getOutputFormat() {
        return this.outputFormat;
    }

    public final Builder toBuilder() {
        return new Builder().setVideoSpec(this.videoSpec).setAudioSpec(this.audioSpec).setOutputFormat(this.outputFormat);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaSpec)) {
            return false;
        }
        MediaSpec mediaSpec = (MediaSpec) other;
        return Intrinsics.areEqual(this.videoSpec, mediaSpec.videoSpec) && Intrinsics.areEqual(this.audioSpec, mediaSpec.audioSpec) && this.outputFormat == mediaSpec.outputFormat;
    }

    public int hashCode() {
        return Objects.hash(this.videoSpec, this.audioSpec, Integer.valueOf(this.outputFormat));
    }

    public String toString() {
        return "MediaSpec{videoSpec=" + this.videoSpec + ", audioSpec=" + this.audioSpec + ", outputFormat=" + this.outputFormat + AbstractJsonLexerKt.END_OBJ;
    }

    /* JADX INFO: compiled from: MediaSpec.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\tJ\u0016\u0010\u000f\u001a\u00020\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0007J\u0016\u0010\u0013\u001a\u00020\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011H\u0007J\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0003¨\u0006\u0017"}, d2 = {"Landroidx/camera/video/MediaSpec$Builder;", "", "<init>", "()V", "audioSpec", "Landroidx/camera/video/AudioSpec;", "videoSpec", "Landroidx/camera/video/VideoSpec;", "outputFormat", "", "getOutputFormat$annotations", "setAudioSpec", "setVideoSpec", "setOutputFormat", "format", "configureAudio", "configBlock", "Landroidx/core/util/Consumer;", "Landroidx/camera/video/AudioSpec$Builder;", "configureVideo", "Landroidx/camera/video/VideoSpec$Builder;", "build", "Landroidx/camera/video/MediaSpec;", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Builder {
        private AudioSpec audioSpec = AudioSpec.INSTANCE.getDEFAULT();
        private VideoSpec videoSpec = VideoSpec.INSTANCE.getDEFAULT();
        private int outputFormat = -1;

        private static /* synthetic */ void getOutputFormat$annotations() {
        }

        public final Builder setAudioSpec(AudioSpec audioSpec) {
            Intrinsics.checkNotNullParameter(audioSpec, "audioSpec");
            this.audioSpec = audioSpec;
            return this;
        }

        public final Builder setVideoSpec(VideoSpec videoSpec) {
            Intrinsics.checkNotNullParameter(videoSpec, "videoSpec");
            this.videoSpec = videoSpec;
            return this;
        }

        public final Builder setOutputFormat(int format) {
            this.outputFormat = format;
            return this;
        }

        public final Builder configureAudio(Consumer<AudioSpec.Builder> configBlock) {
            Intrinsics.checkNotNullParameter(configBlock, "configBlock");
            AudioSpec.Builder builder = this.audioSpec.toBuilder();
            configBlock.accept(builder);
            this.audioSpec = builder.build();
            return this;
        }

        public final Builder configureVideo(Consumer<VideoSpec.Builder> configBlock) {
            Intrinsics.checkNotNullParameter(configBlock, "configBlock");
            VideoSpec.Builder builder = this.videoSpec.toBuilder();
            configBlock.accept(builder);
            this.videoSpec = builder.build();
            return this;
        }

        public final MediaSpec build() {
            return new MediaSpec(this.videoSpec, this.audioSpec, this.outputFormat);
        }
    }

    /* JADX INFO: compiled from: MediaSpec.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\nH\u0001J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0001J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\nH\u0001J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0001J\b\u0010\u0013\u001a\u00020\u0014H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/camera/video/MediaSpec$Companion;", "", "<init>", "()V", "AUDIO_ENCODER_MIME_MPEG4_DEFAULT", "", "AUDIO_ENCODER_MIME_WEBM_DEFAULT", "VIDEO_ENCODER_MIME_MPEG4_DEFAULT", "VIDEO_ENCODER_MIME_WEBM_DEFAULT", "AAC_DEFAULT_PROFILE", "", "OUTPUT_FORMAT_UNSPECIFIED", "OUTPUT_FORMAT_MPEG_4", "OUTPUT_FORMAT_WEBM", "outputFormatToAudioMime", "outputFormat", "outputFormatToAudioProfile", "outputFormatToVideoMime", "outputFormatToMuxerFormat", "builder", "Landroidx/camera/video/MediaSpec$Builder;", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final int outputFormatToMuxerFormat(int outputFormat) {
            return outputFormat == 1 ? 1 : 0;
        }

        private Companion() {
        }

        @JvmStatic
        public final String outputFormatToAudioMime(int outputFormat) {
            if (outputFormat == 1) {
                return "audio/vorbis";
            }
            return "audio/mp4a-latm";
        }

        @JvmStatic
        public final int outputFormatToAudioProfile(int outputFormat) {
            return Intrinsics.areEqual(outputFormatToAudioMime(outputFormat), "audio/mp4a-latm") ? 2 : -1;
        }

        @JvmStatic
        public final String outputFormatToVideoMime(int outputFormat) {
            if (outputFormat == 1) {
                return "video/x-vnd.on2.vp8";
            }
            return "video/avc";
        }

        @JvmStatic
        public final Builder builder() {
            return new Builder();
        }
    }
}

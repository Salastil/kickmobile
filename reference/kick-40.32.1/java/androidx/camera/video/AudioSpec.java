package androidx.camera.video;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: AudioSpec.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0005\u001b\u001c\u001d\u001e\u001fBE\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0014\u001a\u00020\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\b\u0010\u001a\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Landroidx/camera/video/AudioSpec;", "", "bitrate", "", "sourceFormat", "source", "sampleRate", "channelCount", "mimeType", "", "<init>", "(IIIIILjava/lang/String;)V", "getBitrate", "()I", "getSourceFormat", "getSource", "getSampleRate", "getChannelCount", "getMimeType", "()Ljava/lang/String;", "toBuilder", "Landroidx/camera/video/AudioSpec$Builder;", "equals", "", "other", "hashCode", "toString", "Builder", "SourceFormat", "ChannelCount", "Source", "Companion", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioSpec {
    public static final int BITRATE_UNSPECIFIED = 0;
    public static final int CHANNEL_COUNT_MONO = 1;
    public static final int CHANNEL_COUNT_NONE = 0;
    public static final int CHANNEL_COUNT_STEREO = 2;
    public static final int CHANNEL_COUNT_UNSPECIFIED = -1;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final AudioSpec DEFAULT;
    public static final String MIME_TYPE_UNSPECIFIED = "audio/*";
    public static final int SAMPLE_RATE_UNSPECIFIED = 0;
    public static final int SOURCE_CAMCORDER = 5;
    public static final int SOURCE_DEFAULT = 0;
    public static final int SOURCE_FORMAT_PCM_16BIT = 2;
    public static final int SOURCE_FORMAT_UNSPECIFIED = -1;
    public static final int SOURCE_MIC = 1;
    public static final int SOURCE_UNPROCESSED = 9;
    public static final int SOURCE_UNSPECIFIED = -1;
    public static final int SOURCE_VOICE_COMMUNICATION = 7;
    public static final int SOURCE_VOICE_PERFORMANCE = 10;
    public static final int SOURCE_VOICE_RECOGNITION = 6;
    private final int bitrate;
    private final int channelCount;
    private final String mimeType;
    private final int sampleRate;
    private final int source;
    private final int sourceFormat;

    /* JADX INFO: compiled from: AudioSpec.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/camera/video/AudioSpec$ChannelCount;", "", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ChannelCount {
    }

    /* JADX INFO: compiled from: AudioSpec.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/camera/video/AudioSpec$Source;", "", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Source {
    }

    /* JADX INFO: compiled from: AudioSpec.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/camera/video/AudioSpec$SourceFormat;", "", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface SourceFormat {
    }

    public AudioSpec() {
        this(0, 0, 0, 0, 0, null, 63, null);
    }

    public AudioSpec(int i) {
        this(i, 0, 0, 0, 0, null, 62, null);
    }

    public AudioSpec(int i, int i2) {
        this(i, i2, 0, 0, 0, null, 60, null);
    }

    public AudioSpec(int i, int i2, int i3) {
        this(i, i2, i3, 0, 0, null, 56, null);
    }

    public AudioSpec(int i, int i2, int i3, int i4) {
        this(i, i2, i3, i4, 0, null, 48, null);
    }

    public AudioSpec(int i, int i2, int i3, int i4, int i5) {
        this(i, i2, i3, i4, i5, null, 32, null);
    }

    @JvmStatic
    public static final Builder builder() {
        return INSTANCE.builder();
    }

    public AudioSpec(int i, int i2, int i3, int i4, int i5, String mimeType) {
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        this.bitrate = i;
        this.sourceFormat = i2;
        this.source = i3;
        this.sampleRate = i4;
        this.channelCount = i5;
        this.mimeType = mimeType;
    }

    public final int getBitrate() {
        return this.bitrate;
    }

    public final int getSourceFormat() {
        return this.sourceFormat;
    }

    public final int getSource() {
        return this.source;
    }

    public final int getSampleRate() {
        return this.sampleRate;
    }

    public final int getChannelCount() {
        return this.channelCount;
    }

    public /* synthetic */ AudioSpec(int i, int i2, int i3, int i4, int i5, String str, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 0 : i, (i6 & 2) != 0 ? -1 : i2, (i6 & 4) != 0 ? -1 : i3, (i6 & 8) != 0 ? 0 : i4, (i6 & 16) != 0 ? -1 : i5, (i6 & 32) != 0 ? MIME_TYPE_UNSPECIFIED : str);
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final Builder toBuilder() {
        return new Builder().setSampleRate(this.sampleRate).setBitrate(this.bitrate).setChannelCount(this.channelCount).setSource(this.source).setSourceFormat(this.sourceFormat).setMimeType(this.mimeType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AudioSpec)) {
            return false;
        }
        AudioSpec audioSpec = (AudioSpec) other;
        return this.sourceFormat == audioSpec.sourceFormat && this.source == audioSpec.source && this.channelCount == audioSpec.channelCount && this.bitrate == audioSpec.bitrate && this.sampleRate == audioSpec.sampleRate && Intrinsics.areEqual(this.mimeType, audioSpec.mimeType);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.bitrate), Integer.valueOf(this.sourceFormat), Integer.valueOf(this.source), Integer.valueOf(this.sampleRate), Integer.valueOf(this.channelCount));
    }

    public String toString() {
        return "AudioSpec{bitrate=" + this.bitrate + ", sourceFormat=" + this.sourceFormat + ", source=" + this.source + ", sampleRate=" + this.sampleRate + ", channelCount=" + this.channelCount + ", mimeType=" + this.mimeType + AbstractJsonLexerKt.END_OBJ;
    }

    /* JADX INFO: compiled from: AudioSpec.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/camera/video/AudioSpec$Builder;", "", "<init>", "()V", "bitrate", "", "sourceFormat", "source", "sampleRate", "channelCount", "mimeType", "", "setBitrate", "setSourceFormat", "audioFormat", "setSource", "setSampleRate", "setChannelCount", "setMimeType", "build", "Landroidx/camera/video/AudioSpec;", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Builder {
        private int bitrate;
        private int sampleRate;
        private int sourceFormat = -1;
        private int source = -1;
        private int channelCount = -1;
        private String mimeType = AudioSpec.MIME_TYPE_UNSPECIFIED;

        public final Builder setBitrate(int bitrate) {
            this.bitrate = bitrate;
            return this;
        }

        public final Builder setSourceFormat(int audioFormat) {
            this.sourceFormat = audioFormat;
            return this;
        }

        public final Builder setSource(int source) {
            this.source = source;
            return this;
        }

        public final Builder setSampleRate(int sampleRate) {
            this.sampleRate = sampleRate;
            return this;
        }

        public final Builder setChannelCount(int channelCount) {
            this.channelCount = channelCount;
            return this;
        }

        public final Builder setMimeType(String mimeType) {
            Intrinsics.checkNotNullParameter(mimeType, "mimeType");
            this.mimeType = mimeType;
            return this;
        }

        public final AudioSpec build() {
            return new AudioSpec(this.bitrate, this.sourceFormat, this.source, this.sampleRate, this.channelCount, this.mimeType);
        }
    }

    /* JADX INFO: compiled from: AudioSpec.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u001cH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00058\u0006X\u0087T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00058\u0006X\u0087T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Landroidx/camera/video/AudioSpec$Companion;", "", "<init>", "()V", "SOURCE_FORMAT_UNSPECIFIED", "", "SOURCE_FORMAT_PCM_16BIT", "CHANNEL_COUNT_UNSPECIFIED", "CHANNEL_COUNT_NONE", "CHANNEL_COUNT_MONO", "CHANNEL_COUNT_STEREO", "SOURCE_UNSPECIFIED", "SOURCE_CAMCORDER", "SOURCE_DEFAULT", "SOURCE_MIC", "SOURCE_UNPROCESSED", "SOURCE_VOICE_COMMUNICATION", "SOURCE_VOICE_RECOGNITION", "SOURCE_VOICE_PERFORMANCE", "BITRATE_UNSPECIFIED", "SAMPLE_RATE_UNSPECIFIED", "MIME_TYPE_UNSPECIFIED", "", "DEFAULT", "Landroidx/camera/video/AudioSpec;", "getDEFAULT", "()Landroidx/camera/video/AudioSpec;", "builder", "Landroidx/camera/video/AudioSpec$Builder;", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AudioSpec getDEFAULT() {
            return AudioSpec.DEFAULT;
        }

        @JvmStatic
        public final Builder builder() {
            return new Builder();
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        DEFAULT = companion.builder().build();
    }
}

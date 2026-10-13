package androidx.camera.video.internal.encoder;

import android.media.MediaCodecInfo;
import android.util.Range;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AudioEncoderInfoImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/camera/video/internal/encoder/AudioEncoderInfoImpl;", "Landroidx/camera/video/internal/encoder/EncoderInfoImpl;", "Landroidx/camera/video/internal/encoder/AudioEncoderInfo;", "codecInfo", "Landroid/media/MediaCodecInfo;", "mime", "", "<init>", "(Landroid/media/MediaCodecInfo;Ljava/lang/String;)V", "audioCapabilities", "Landroid/media/MediaCodecInfo$AudioCapabilities;", "bitrateRange", "Landroid/util/Range;", "", "getBitrateRange", "()Landroid/util/Range;", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioEncoderInfoImpl extends EncoderInfoImpl implements AudioEncoderInfo {
    private final MediaCodecInfo.AudioCapabilities audioCapabilities;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioEncoderInfoImpl(MediaCodecInfo codecInfo, String mime) throws InvalidConfigException {
        super(codecInfo, mime);
        Intrinsics.checkNotNullParameter(codecInfo, "codecInfo");
        Intrinsics.checkNotNullParameter(mime, "mime");
        MediaCodecInfo.AudioCapabilities audioCapabilities = getCodecCapabilities().getAudioCapabilities();
        Intrinsics.checkNotNull(audioCapabilities);
        this.audioCapabilities = audioCapabilities;
    }

    @Override // androidx.camera.video.internal.encoder.AudioEncoderInfo
    public Range<Integer> getBitrateRange() {
        Range<Integer> bitrateRange = this.audioCapabilities.getBitrateRange();
        Intrinsics.checkNotNullExpressionValue(bitrateRange, "getBitrateRange(...)");
        return bitrateRange;
    }
}

package androidx.camera.video.internal.encoder;

import android.media.MediaCodecInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EncoderInfoImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Landroidx/camera/video/internal/encoder/EncoderInfoImpl;", "Landroidx/camera/video/internal/encoder/EncoderInfo;", "mediaCodecInfo", "Landroid/media/MediaCodecInfo;", "mime", "", "<init>", "(Landroid/media/MediaCodecInfo;Ljava/lang/String;)V", "codecCapabilities", "Landroid/media/MediaCodecInfo$CodecCapabilities;", "getCodecCapabilities", "()Landroid/media/MediaCodecInfo$CodecCapabilities;", "getName", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class EncoderInfoImpl implements EncoderInfo {
    private final MediaCodecInfo.CodecCapabilities codecCapabilities;
    private final MediaCodecInfo mediaCodecInfo;

    public EncoderInfoImpl(MediaCodecInfo mediaCodecInfo, String mime) throws InvalidConfigException {
        Intrinsics.checkNotNullParameter(mediaCodecInfo, "mediaCodecInfo");
        Intrinsics.checkNotNullParameter(mime, "mime");
        this.mediaCodecInfo = mediaCodecInfo;
        try {
            MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(mime);
            Intrinsics.checkNotNullExpressionValue(capabilitiesForType, "getCapabilitiesForType(...)");
            this.codecCapabilities = capabilitiesForType;
        } catch (RuntimeException e) {
            throw new InvalidConfigException("Unable to get CodecCapabilities for mime: " + mime, e);
        }
    }

    protected final MediaCodecInfo.CodecCapabilities getCodecCapabilities() {
        return this.codecCapabilities;
    }

    @Override // androidx.camera.video.internal.encoder.EncoderInfo
    public String getName() {
        String name = this.mediaCodecInfo.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return name;
    }
}

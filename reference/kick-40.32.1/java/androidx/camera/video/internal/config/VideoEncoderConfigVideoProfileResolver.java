package androidx.camera.video.internal.config;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.VideoSpec;
import androidx.camera.video.internal.encoder.VideoEncoderConfig;
import androidx.core.util.Supplier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VideoEncoderConfigVideoProfileResolver.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015BE\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/camera/video/internal/config/VideoEncoderConfigVideoProfileResolver;", "Landroidx/core/util/Supplier;", "Landroidx/camera/video/internal/encoder/VideoEncoderConfig;", "mimeType", "", "inputTimebase", "Landroidx/camera/core/impl/Timebase;", "videoSpec", "Landroidx/camera/video/VideoSpec;", "surfaceSize", "Landroid/util/Size;", "videoProfile", "Landroidx/camera/core/impl/EncoderProfilesProxy$VideoProfileProxy;", "dynamicRange", "Landroidx/camera/core/DynamicRange;", "expectedFrameRateRange", "Landroid/util/Range;", "", "<init>", "(Ljava/lang/String;Landroidx/camera/core/impl/Timebase;Landroidx/camera/video/VideoSpec;Landroid/util/Size;Landroidx/camera/core/impl/EncoderProfilesProxy$VideoProfileProxy;Landroidx/camera/core/DynamicRange;Landroid/util/Range;)V", "get", "Companion", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoEncoderConfigVideoProfileResolver implements Supplier<VideoEncoderConfig> {
    private static final String TAG = "VidEncVdPrflRslvr";
    private final DynamicRange dynamicRange;
    private final Range<Integer> expectedFrameRateRange;
    private final Timebase inputTimebase;
    private final String mimeType;
    private final Size surfaceSize;
    private final EncoderProfilesProxy.VideoProfileProxy videoProfile;
    private final VideoSpec videoSpec;

    public VideoEncoderConfigVideoProfileResolver(String mimeType, Timebase inputTimebase, VideoSpec videoSpec, Size surfaceSize, EncoderProfilesProxy.VideoProfileProxy videoProfile, DynamicRange dynamicRange, Range<Integer> expectedFrameRateRange) {
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        Intrinsics.checkNotNullParameter(inputTimebase, "inputTimebase");
        Intrinsics.checkNotNullParameter(videoSpec, "videoSpec");
        Intrinsics.checkNotNullParameter(surfaceSize, "surfaceSize");
        Intrinsics.checkNotNullParameter(videoProfile, "videoProfile");
        Intrinsics.checkNotNullParameter(dynamicRange, "dynamicRange");
        Intrinsics.checkNotNullParameter(expectedFrameRateRange, "expectedFrameRateRange");
        this.mimeType = mimeType;
        this.inputTimebase = inputTimebase;
        this.videoSpec = videoSpec;
        this.surfaceSize = surfaceSize;
        this.videoProfile = videoProfile;
        this.dynamicRange = dynamicRange;
        this.expectedFrameRateRange = expectedFrameRateRange;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.core.util.Supplier
    public VideoEncoderConfig get() {
        CaptureEncodeRates captureEncodeRatesResolveFrameRates$camera_video = VideoConfigUtil.INSTANCE.resolveFrameRates$camera_video(this.videoSpec, this.expectedFrameRateRange);
        Logger.d(TAG, "Resolved VIDEO frame rates: Capture frame rate = " + captureEncodeRatesResolveFrameRates$camera_video.getCaptureRate() + "fps. Encode frame rate = " + captureEncodeRatesResolveFrameRates$camera_video.getEncodeRate() + "fps.");
        int bitrate = this.videoSpec.getBitrate();
        if (bitrate == 0) {
            Logger.d(TAG, "Using resolved VIDEO bitrate from EncoderProfiles");
            bitrate = VideoConfigUtil.scaleBitrate(this.videoProfile.getBitrate(), this.dynamicRange.getBitDepth(), this.videoProfile.getBitDepth(), captureEncodeRatesResolveFrameRates$camera_video.getEncodeRate(), this.videoProfile.getFrameRate(), this.surfaceSize.getWidth(), this.videoProfile.getWidth(), this.surfaceSize.getHeight(), this.videoProfile.getHeight());
        }
        int profile = this.videoProfile.getProfile();
        VideoEncoderConfig videoEncoderConfigBuild = VideoEncoderConfig.builder().setMimeType(this.mimeType).setInputTimebase(this.inputTimebase).setResolution(this.surfaceSize).setBitrate(bitrate).setCaptureFrameRate(captureEncodeRatesResolveFrameRates$camera_video.getCaptureRate()).setEncodeFrameRate(captureEncodeRatesResolveFrameRates$camera_video.getEncodeRate()).setProfile(profile).setDataSpace(VideoConfigUtil.INSTANCE.mimeAndProfileToEncoderDataSpace(this.mimeType, profile)).build();
        Intrinsics.checkNotNullExpressionValue(videoEncoderConfigBuild, "build(...)");
        return videoEncoderConfigBuild;
    }
}

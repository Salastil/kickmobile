package androidx.camera.video.internal.encoder;

import android.media.MediaCodecInfo;
import android.util.Range;
import androidx.camera.core.Logger;
import androidx.camera.video.internal.utils.CodecUtil;
import androidx.camera.video.internal.workaround.VideoEncoderInfoWrapper;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VideoEncoderInfoImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012H\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012H\u0016J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00122\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Landroidx/camera/video/internal/encoder/VideoEncoderInfoImpl;", "Landroidx/camera/video/internal/encoder/EncoderInfoImpl;", "Landroidx/camera/video/internal/encoder/VideoEncoderInfo;", "codecInfo", "Landroid/media/MediaCodecInfo;", "mime", "", "<init>", "(Landroid/media/MediaCodecInfo;Ljava/lang/String;)V", "videoCapabilities", "Landroid/media/MediaCodecInfo$VideoCapabilities;", "canSwapWidthHeight", "", "isSizeSupported", ViewProps.WIDTH, "", ViewProps.HEIGHT, "getSupportedWidths", "Landroid/util/Range;", "getSupportedHeights", "getSupportedWidthsFor", "getSupportedHeightsFor", "widthAlignment", "getWidthAlignment", "()I", "heightAlignment", "getHeightAlignment", "supportedBitrateRange", "getSupportedBitrateRange", "()Landroid/util/Range;", "Companion", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoEncoderInfoImpl extends EncoderInfoImpl implements VideoEncoderInfo {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final VideoEncoderInfo.Finder FINDER = new VideoEncoderInfo.Finder() { // from class: androidx.camera.video.internal.encoder.VideoEncoderInfoImpl$$ExternalSyntheticLambda0
        @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo.Finder
        public final VideoEncoderInfo find(String str) {
            return VideoEncoderInfoImpl.FINDER$lambda$0(str);
        }
    };
    private static final String TAG = "VideoEncoderInfoImpl";
    private final MediaCodecInfo.VideoCapabilities videoCapabilities;

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public boolean canSwapWidthHeight() {
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoEncoderInfoImpl(MediaCodecInfo codecInfo, String mime) throws InvalidConfigException {
        super(codecInfo, mime);
        Intrinsics.checkNotNullParameter(codecInfo, "codecInfo");
        Intrinsics.checkNotNullParameter(mime, "mime");
        MediaCodecInfo.VideoCapabilities videoCapabilities = getCodecCapabilities().getVideoCapabilities();
        Intrinsics.checkNotNull(videoCapabilities);
        this.videoCapabilities = videoCapabilities;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public boolean isSizeSupported(int width, int height) {
        return this.videoCapabilities.isSizeSupported(width, height);
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedWidths() {
        Range<Integer> supportedWidths = this.videoCapabilities.getSupportedWidths();
        Intrinsics.checkNotNullExpressionValue(supportedWidths, "getSupportedWidths(...)");
        return supportedWidths;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedHeights() {
        Range<Integer> supportedHeights = this.videoCapabilities.getSupportedHeights();
        Intrinsics.checkNotNullExpressionValue(supportedHeights, "getSupportedHeights(...)");
        return supportedHeights;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedWidthsFor(int height) {
        try {
            Range<Integer> supportedWidthsFor = this.videoCapabilities.getSupportedWidthsFor(height);
            Intrinsics.checkNotNull(supportedWidthsFor);
            return supportedWidthsFor;
        } catch (Throwable th) {
            throw INSTANCE.toIllegalArgumentException(th);
        }
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedHeightsFor(int width) {
        try {
            Range<Integer> supportedHeightsFor = this.videoCapabilities.getSupportedHeightsFor(width);
            Intrinsics.checkNotNull(supportedHeightsFor);
            return supportedHeightsFor;
        } catch (Throwable th) {
            throw INSTANCE.toIllegalArgumentException(th);
        }
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public int getWidthAlignment() {
        return this.videoCapabilities.getWidthAlignment();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public int getHeightAlignment() {
        return this.videoCapabilities.getHeightAlignment();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedBitrateRange() {
        Range<Integer> bitrateRange = this.videoCapabilities.getBitrateRange();
        Intrinsics.checkNotNullExpressionValue(bitrateRange, "getBitrateRange(...)");
        return bitrateRange;
    }

    /* JADX INFO: compiled from: VideoEncoderInfoImpl.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\b\u001a\u00060\tj\u0002`\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/camera/video/internal/encoder/VideoEncoderInfoImpl$Companion;", "", "<init>", "()V", "TAG", "", "FINDER", "Landroidx/camera/video/internal/encoder/VideoEncoderInfo$Finder;", "toIllegalArgumentException", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "t", "", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final IllegalArgumentException toIllegalArgumentException(Throwable t) {
            IllegalArgumentException illegalArgumentException = t instanceof IllegalArgumentException ? (IllegalArgumentException) t : null;
            return illegalArgumentException == null ? new IllegalArgumentException(t) : illegalArgumentException;
        }
    }

    static final VideoEncoderInfo FINDER$lambda$0(String mimeType) {
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        try {
            return VideoEncoderInfoWrapper.INSTANCE.from(new VideoEncoderInfoImpl(CodecUtil.findCodecAndGetCodecInfo(mimeType), mimeType), null);
        } catch (InvalidConfigException e) {
            Logger.w(TAG, "Unable to find a VideoEncoderInfoImpl", e);
            return null;
        }
    }
}

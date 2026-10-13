package androidx.camera.video.internal.encoder;

import android.util.Range;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SwappedVideoEncoderInfo.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\fH\u0016J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\f2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\f2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\t\u0010\u0015\u001a\u00020\u0006H\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u0096\u0001R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0018\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Landroidx/camera/video/internal/encoder/SwappedVideoEncoderInfo;", "Landroidx/camera/video/internal/encoder/VideoEncoderInfo;", "videoEncoderInfo", "<init>", "(Landroidx/camera/video/internal/encoder/VideoEncoderInfo;)V", "isSizeSupported", "", ViewProps.WIDTH, "", ViewProps.HEIGHT, "isSizeSupportedAllowSwapping", "getSupportedWidths", "Landroid/util/Range;", "getSupportedHeights", "getSupportedWidthsFor", "getSupportedHeightsFor", "widthAlignment", "getWidthAlignment", "()I", "heightAlignment", "getHeightAlignment", "canSwapWidthHeight", "getName", "", "supportedBitrateRange", "getSupportedBitrateRange", "()Landroid/util/Range;", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SwappedVideoEncoderInfo implements VideoEncoderInfo {
    private final VideoEncoderInfo videoEncoderInfo;

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public boolean canSwapWidthHeight() {
        return this.videoEncoderInfo.canSwapWidthHeight();
    }

    @Override // androidx.camera.video.internal.encoder.EncoderInfo
    public String getName() {
        return this.videoEncoderInfo.getName();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedBitrateRange() {
        return this.videoEncoderInfo.getSupportedBitrateRange();
    }

    public SwappedVideoEncoderInfo(VideoEncoderInfo videoEncoderInfo) {
        Intrinsics.checkNotNullParameter(videoEncoderInfo, "videoEncoderInfo");
        this.videoEncoderInfo = videoEncoderInfo;
        if (!videoEncoderInfo.canSwapWidthHeight()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public boolean isSizeSupported(int width, int height) {
        return this.videoEncoderInfo.isSizeSupported(height, width);
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public boolean isSizeSupportedAllowSwapping(int width, int height) {
        return this.videoEncoderInfo.isSizeSupportedAllowSwapping(height, width);
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedWidths() {
        return this.videoEncoderInfo.getSupportedHeights();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedHeights() {
        return this.videoEncoderInfo.getSupportedWidths();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedWidthsFor(int height) {
        return this.videoEncoderInfo.getSupportedHeightsFor(height);
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedHeightsFor(int width) {
        return this.videoEncoderInfo.getSupportedWidthsFor(width);
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public int getWidthAlignment() {
        return this.videoEncoderInfo.getHeightAlignment();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public int getHeightAlignment() {
        return this.videoEncoderInfo.getWidthAlignment();
    }
}

package androidx.camera.video.internal.workaround;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.Logger;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.camera.video.internal.compat.quirk.MediaCodecInfoReportIncorrectInfoQuirk;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.messaging.Constants;
import io.ktor.http.ContentDisposition;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VideoEncoderInfoWrapper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Landroidx/camera/video/internal/workaround/VideoEncoderInfoWrapper;", "Landroidx/camera/video/internal/encoder/VideoEncoderInfo;", "videoEncoderInfo", "<init>", "(Landroidx/camera/video/internal/encoder/VideoEncoderInfo;)V", "_supportedWidths", "Landroid/util/Range;", "", "_supportedHeights", "extraSupportedSizes", "", "Landroid/util/Size;", "getName", "", "canSwapWidthHeight", "", "isSizeSupported", ViewProps.WIDTH, ViewProps.HEIGHT, "getSupportedWidths", "getSupportedHeights", "getSupportedWidthsFor", "getSupportedHeightsFor", "widthAlignment", "getWidthAlignment", "()I", "heightAlignment", "getHeightAlignment", "supportedBitrateRange", "getSupportedBitrateRange", "()Landroid/util/Range;", "addExtraSupportedSize", "", ContentDisposition.Parameters.Size, "Companion", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoEncoderInfoWrapper implements VideoEncoderInfo {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int HEIGHT_4KDCI = 2160;
    private static final String TAG = "VideoEncoderInfoWrapper";
    private static final int WIDTH_4KDCI = 4096;
    private final Range<Integer> _supportedHeights;
    private final Range<Integer> _supportedWidths;
    private final Set<Size> extraSupportedSizes;
    private final VideoEncoderInfo videoEncoderInfo;

    public /* synthetic */ VideoEncoderInfoWrapper(VideoEncoderInfo videoEncoderInfo, DefaultConstructorMarker defaultConstructorMarker) {
        this(videoEncoderInfo);
    }

    @JvmStatic
    public static final VideoEncoderInfo from(VideoEncoderInfo videoEncoderInfo, Size size) {
        return INSTANCE.from(videoEncoderInfo, size);
    }

    private VideoEncoderInfoWrapper(VideoEncoderInfo videoEncoderInfo) {
        this.videoEncoderInfo = videoEncoderInfo;
        HashSet hashSet = new HashSet();
        this.extraSupportedSizes = hashSet;
        int widthAlignment = videoEncoderInfo.getWidthAlignment();
        Range<Integer> rangeCreate = Range.create(Integer.valueOf(widthAlignment), Integer.valueOf(((int) Math.ceil(4096.0d / ((double) widthAlignment))) * widthAlignment));
        Intrinsics.checkNotNullExpressionValue(rangeCreate, "create(...)");
        this._supportedWidths = rangeCreate;
        int heightAlignment = videoEncoderInfo.getHeightAlignment();
        Range<Integer> rangeCreate2 = Range.create(Integer.valueOf(heightAlignment), Integer.valueOf(((int) Math.ceil(2160.0d / ((double) heightAlignment))) * heightAlignment));
        Intrinsics.checkNotNullExpressionValue(rangeCreate2, "create(...)");
        this._supportedHeights = rangeCreate2;
        Set<Size> extraSupportedSizes = MediaCodecInfoReportIncorrectInfoQuirk.getExtraSupportedSizes();
        Intrinsics.checkNotNullExpressionValue(extraSupportedSizes, "getExtraSupportedSizes(...)");
        hashSet.addAll(extraSupportedSizes);
    }

    @Override // androidx.camera.video.internal.encoder.EncoderInfo
    public String getName() {
        return this.videoEncoderInfo.getName();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public boolean canSwapWidthHeight() {
        return this.videoEncoderInfo.canSwapWidthHeight();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public boolean isSizeSupported(int width, int height) {
        if (this.videoEncoderInfo.isSizeSupported(width, height)) {
            return true;
        }
        Set<Size> set = this.extraSupportedSizes;
        if (!(set instanceof Collection) || !set.isEmpty()) {
            for (Size size : set) {
                if (size.getWidth() == width && size.getHeight() == height) {
                    return true;
                }
            }
        }
        return this._supportedWidths.contains(Integer.valueOf(width)) && this._supportedHeights.contains(Integer.valueOf(height)) && width % this.videoEncoderInfo.getWidthAlignment() == 0 && height % this.videoEncoderInfo.getHeightAlignment() == 0;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedWidths() {
        return this._supportedWidths;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedHeights() {
        return this._supportedHeights;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedWidthsFor(int height) {
        if (!this._supportedHeights.contains(Integer.valueOf(height)) || height % this.videoEncoderInfo.getHeightAlignment() != 0) {
            throw new IllegalArgumentException(("Not supported height: " + height + " which is not in " + this._supportedHeights + " or can not be divided by alignment " + this.videoEncoderInfo.getHeightAlignment()).toString());
        }
        return this._supportedWidths;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedHeightsFor(int width) {
        if (!this._supportedWidths.contains(Integer.valueOf(width)) || width % this.videoEncoderInfo.getWidthAlignment() != 0) {
            throw new IllegalArgumentException(("Not supported width: " + width + " which is not in " + this._supportedWidths + " or can not be divided by alignment " + this.videoEncoderInfo.getWidthAlignment()).toString());
        }
        return this._supportedHeights;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public int getWidthAlignment() {
        return this.videoEncoderInfo.getWidthAlignment();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public int getHeightAlignment() {
        return this.videoEncoderInfo.getHeightAlignment();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedBitrateRange() {
        return this.videoEncoderInfo.getSupportedBitrateRange();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addExtraSupportedSize(Size size) {
        this.extraSupportedSizes.add(size);
    }

    /* JADX INFO: compiled from: VideoEncoderInfoWrapper.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/camera/video/internal/workaround/VideoEncoderInfoWrapper$Companion;", "", "<init>", "()V", "TAG", "", "WIDTH_4KDCI", "", "HEIGHT_4KDCI", Constants.MessagePayloadKeys.FROM, "Landroidx/camera/video/internal/encoder/VideoEncoderInfo;", "videoEncoderInfo", "validSizeToCheck", "Landroid/util/Size;", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final VideoEncoderInfo from(VideoEncoderInfo videoEncoderInfo, Size validSizeToCheck) {
            Intrinsics.checkNotNullParameter(videoEncoderInfo, "videoEncoderInfo");
            if (!(videoEncoderInfo instanceof VideoEncoderInfoWrapper)) {
                if (DeviceQuirks.get(MediaCodecInfoReportIncorrectInfoQuirk.class) == null) {
                    if (validSizeToCheck != null && !videoEncoderInfo.isSizeSupportedAllowSwapping(validSizeToCheck.getWidth(), validSizeToCheck.getHeight())) {
                        Logger.w(VideoEncoderInfoWrapper.TAG, "Detected that the device does not support a size " + validSizeToCheck + " that should be valid in widths/heights = " + videoEncoderInfo.getSupportedWidths() + '/' + videoEncoderInfo.getSupportedHeights());
                        videoEncoderInfo = new VideoEncoderInfoWrapper(videoEncoderInfo, null);
                    }
                } else {
                    videoEncoderInfo = new VideoEncoderInfoWrapper(videoEncoderInfo, null);
                }
            }
            if (validSizeToCheck != null && (videoEncoderInfo instanceof VideoEncoderInfoWrapper)) {
                ((VideoEncoderInfoWrapper) videoEncoderInfo).addExtraSupportedSize(validSizeToCheck);
            }
            return videoEncoderInfo;
        }
    }
}

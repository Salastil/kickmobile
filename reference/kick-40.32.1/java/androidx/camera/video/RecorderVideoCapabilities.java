package androidx.camera.video;

import android.util.Size;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.CameraInfoInternal;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class RecorderVideoCapabilities implements VideoCapabilities {
    private final EncoderProfilesResolver mEncoderProfilesResolver;
    private final boolean mIsStabilizationSupported;

    RecorderVideoCapabilities(EncoderProfilesResolver encoderProfilesResolver, CameraInfoInternal cameraInfoInternal) {
        this.mEncoderProfilesResolver = encoderProfilesResolver;
        this.mIsStabilizationSupported = cameraInfoInternal.isVideoStabilizationSupported();
    }

    @Override // androidx.camera.video.VideoCapabilities
    public Set<DynamicRange> getSupportedDynamicRanges() {
        return this.mEncoderProfilesResolver.getSupportedDynamicRanges();
    }

    @Override // androidx.camera.video.VideoCapabilities
    public List<Quality> getSupportedQualities(DynamicRange dynamicRange) {
        return this.mEncoderProfilesResolver.getSupportedQualities(dynamicRange);
    }

    @Override // androidx.camera.video.VideoCapabilities
    public boolean isQualitySupported(Quality quality, DynamicRange dynamicRange) {
        return this.mEncoderProfilesResolver.isQualitySupported(quality, dynamicRange);
    }

    @Override // androidx.camera.video.VideoCapabilities
    public boolean isStabilizationSupported() {
        return this.mIsStabilizationSupported;
    }

    @Override // androidx.camera.video.VideoCapabilities
    public Size getResolution(Quality quality, DynamicRange dynamicRange) {
        return this.mEncoderProfilesResolver.getResolution(quality, dynamicRange);
    }
}

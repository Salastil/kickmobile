package androidx.camera.video;

import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.Quirks;
import androidx.camera.video.internal.BackupHdrProfileEncoderProfilesProvider;
import androidx.camera.video.internal.QualityExploredEncoderProfilesProvider;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import androidx.camera.video.internal.workaround.DefaultEncoderProfilesProvider;
import androidx.camera.video.internal.workaround.QualityAddedEncoderProfilesProvider;
import androidx.camera.video.internal.workaround.QualityResolutionModifiedEncoderProfilesProvider;
import androidx.camera.video.internal.workaround.QualityValidatedEncoderProfilesProvider;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EncoderProfilesProviderResolver.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\u000f\u001a\u00020\u0010*\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/camera/video/EncoderProfilesProviderResolver;", "", "<init>", "()V", "TAG", "", "resolve", "Landroidx/camera/core/impl/EncoderProfilesProvider;", "cameraInfo", "Landroidx/camera/core/impl/CameraInfoInternal;", "videoCapabilitiesSource", "", "qualitySource", "videoEncoderInfoFinder", "Landroidx/camera/video/internal/encoder/VideoEncoderInfo$Finder;", "isHlg10Supported", "", "(Landroidx/camera/core/impl/CameraInfoInternal;)Z", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EncoderProfilesProviderResolver {
    public static final EncoderProfilesProviderResolver INSTANCE = new EncoderProfilesProviderResolver();
    private static final String TAG = "EncoderProfilesResolver";

    private EncoderProfilesProviderResolver() {
    }

    public final EncoderProfilesProvider resolve(CameraInfoInternal cameraInfo, int videoCapabilitiesSource, int qualitySource, VideoEncoderInfo.Finder videoEncoderInfoFinder) {
        VideoEncoderInfo.Finder finder;
        Intrinsics.checkNotNullParameter(cameraInfo, "cameraInfo");
        Intrinsics.checkNotNullParameter(videoEncoderInfoFinder, "videoEncoderInfoFinder");
        if (videoCapabilitiesSource != 0 && videoCapabilitiesSource != 1) {
            throw new IllegalArgumentException(("Not a supported video capabilities source: " + videoCapabilitiesSource).toString());
        }
        DefaultEncoderProfilesProvider encoderProfilesProvider = cameraInfo.getEncoderProfilesProvider();
        Intrinsics.checkNotNullExpressionValue(encoderProfilesProvider, "getEncoderProfilesProvider(...)");
        if (qualitySource == 2) {
            if (cameraInfo.isHighSpeedSupported()) {
                return encoderProfilesProvider;
            }
            EncoderProfilesProvider EMPTY = EncoderProfilesProvider.EMPTY;
            Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
            return EMPTY;
        }
        if (!CapabilitiesByQuality.containsSupportedQuality(encoderProfilesProvider, qualitySource)) {
            Logger.w(TAG, "Camera EncoderProfilesProvider doesn't contain any supported Quality.");
            encoderProfilesProvider = new DefaultEncoderProfilesProvider(cameraInfo, CollectionsKt.listOf((Object[]) new Quality[]{Quality.FHD, Quality.HD, Quality.SD}), videoEncoderInfoFinder);
        }
        Quirks all = DeviceQuirks.getAll();
        Intrinsics.checkNotNullExpressionValue(all, "getAll(...)");
        QualityExploredEncoderProfilesProvider qualityAddedEncoderProfilesProvider = new QualityAddedEncoderProfilesProvider(encoderProfilesProvider, all, cameraInfo, videoEncoderInfoFinder);
        if (videoCapabilitiesSource == 1) {
            finder = videoEncoderInfoFinder;
            qualityAddedEncoderProfilesProvider = new QualityExploredEncoderProfilesProvider(qualityAddedEncoderProfilesProvider, Quality.getSortedQualities(), Collections.singleton(DynamicRange.SDR), cameraInfo.getSupportedResolutions(34), finder);
        } else {
            finder = videoEncoderInfoFinder;
        }
        BackupHdrProfileEncoderProfilesProvider qualityResolutionModifiedEncoderProfilesProvider = new QualityResolutionModifiedEncoderProfilesProvider(qualityAddedEncoderProfilesProvider, all);
        if (isHlg10Supported(cameraInfo)) {
            qualityResolutionModifiedEncoderProfilesProvider = new BackupHdrProfileEncoderProfilesProvider(qualityResolutionModifiedEncoderProfilesProvider, finder);
        }
        return new QualityValidatedEncoderProfilesProvider(qualityResolutionModifiedEncoderProfilesProvider, cameraInfo, all);
    }

    private final boolean isHlg10Supported(CameraInfoInternal cameraInfoInternal) {
        Set<DynamicRange> supportedDynamicRanges = cameraInfoInternal.getSupportedDynamicRanges();
        Intrinsics.checkNotNullExpressionValue(supportedDynamicRanges, "getSupportedDynamicRanges(...)");
        Set<DynamicRange> set = supportedDynamicRanges;
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        for (DynamicRange dynamicRange : set) {
            if (dynamicRange.getEncoding() == 3 && dynamicRange.getBitDepth() == 10) {
                return true;
            }
        }
        return false;
    }
}

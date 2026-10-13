package androidx.camera.camera2.pipe;

import java.util.Set;

/* JADX INFO: compiled from: CameraColorSpaceProfiles.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\n\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000eH&¢\u0006\u0004\b\u0013\u0010\u0014ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/CameraColorSpaceProfiles;", "Landroidx/camera/camera2/pipe/UnsafeWrapper;", "getSupportedColorSpaces", "", "Landroidx/camera/camera2/pipe/CameraColorSpace;", "imageFormat", "Landroidx/camera/camera2/pipe/StreamFormat;", "getSupportedColorSpaces-hNQ4ISI", "(I)Ljava/util/Set;", "getSupportedImageFormatsForColorSpace", "cameraColorSpace", "getSupportedImageFormatsForColorSpace-jRxjvBE", "(Ljava/lang/String;)Ljava/util/Set;", "getSupportedDynamicRangeProfiles", "Landroidx/camera/camera2/pipe/OutputStream$DynamicRangeProfile;", "getSupportedDynamicRangeProfiles-6Yu6yh8", "(Ljava/lang/String;I)Ljava/util/Set;", "getSupportedColorSpacesForDynamicRange", "dynamicRangeProfile", "getSupportedColorSpacesForDynamicRange-sNWL0t8", "(IJ)Ljava/util/Set;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CameraColorSpaceProfiles extends UnsafeWrapper {
    /* JADX INFO: renamed from: getSupportedColorSpaces-hNQ4ISI, reason: not valid java name */
    Set<CameraColorSpace> mo299getSupportedColorSpaceshNQ4ISI(int imageFormat);

    /* JADX INFO: renamed from: getSupportedColorSpacesForDynamicRange-sNWL0t8, reason: not valid java name */
    Set<CameraColorSpace> mo300getSupportedColorSpacesForDynamicRangesNWL0t8(int imageFormat, long dynamicRangeProfile);

    /* JADX INFO: renamed from: getSupportedDynamicRangeProfiles-6Yu6yh8, reason: not valid java name */
    Set<OutputStream.DynamicRangeProfile> mo301getSupportedDynamicRangeProfiles6Yu6yh8(String cameraColorSpace, int imageFormat);

    /* JADX INFO: renamed from: getSupportedImageFormatsForColorSpace-jRxjvBE, reason: not valid java name */
    Set<StreamFormat> mo302getSupportedImageFormatsForColorSpacejRxjvBE(String cameraColorSpace);
}

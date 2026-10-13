package androidx.camera.camera2.pipe;

import androidx.exifinterface.media.ExifInterface;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: CameraColorSpaceProfiles.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u0006\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00052\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0017\u001a\u0004\u0018\u0001H\u0018\"\b\b\u0000\u0010\u0018*\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001bH\u0016¢\u0006\u0002\u0010\u001c¨\u0006\u001d"}, d2 = {"Landroidx/camera/camera2/pipe/UnsupportedCameraColorSpaceProfiles;", "Landroidx/camera/camera2/pipe/CameraColorSpaceProfiles;", "<init>", "()V", "getSupportedColorSpaces", "", "Landroidx/camera/camera2/pipe/CameraColorSpace;", "imageFormat", "Landroidx/camera/camera2/pipe/StreamFormat;", "getSupportedColorSpaces-hNQ4ISI", "(I)Ljava/util/Set;", "getSupportedImageFormatsForColorSpace", "cameraColorSpace", "getSupportedImageFormatsForColorSpace-jRxjvBE", "(Ljava/lang/String;)Ljava/util/Set;", "getSupportedDynamicRangeProfiles", "Landroidx/camera/camera2/pipe/OutputStream$DynamicRangeProfile;", "getSupportedDynamicRangeProfiles-6Yu6yh8", "(Ljava/lang/String;I)Ljava/util/Set;", "getSupportedColorSpacesForDynamicRange", "dynamicRangeProfile", "getSupportedColorSpacesForDynamicRange-sNWL0t8", "(IJ)Ljava/util/Set;", "unwrapAs", ExifInterface.GPS_DIRECTION_TRUE, "", "type", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UnsupportedCameraColorSpaceProfiles implements CameraColorSpaceProfiles {
    public static final UnsupportedCameraColorSpaceProfiles INSTANCE = new UnsupportedCameraColorSpaceProfiles();

    @Override // androidx.camera.camera2.pipe.UnsafeWrapper
    public <T> T unwrapAs(KClass<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return null;
    }

    private UnsupportedCameraColorSpaceProfiles() {
    }

    @Override // androidx.camera.camera2.pipe.CameraColorSpaceProfiles
    /* JADX INFO: renamed from: getSupportedColorSpaces-hNQ4ISI */
    public Set<CameraColorSpace> mo299getSupportedColorSpaceshNQ4ISI(int imageFormat) {
        return SetsKt.emptySet();
    }

    @Override // androidx.camera.camera2.pipe.CameraColorSpaceProfiles
    /* JADX INFO: renamed from: getSupportedImageFormatsForColorSpace-jRxjvBE */
    public Set<StreamFormat> mo302getSupportedImageFormatsForColorSpacejRxjvBE(String cameraColorSpace) {
        Intrinsics.checkNotNullParameter(cameraColorSpace, "cameraColorSpace");
        return SetsKt.emptySet();
    }

    @Override // androidx.camera.camera2.pipe.CameraColorSpaceProfiles
    /* JADX INFO: renamed from: getSupportedDynamicRangeProfiles-6Yu6yh8 */
    public Set<OutputStream.DynamicRangeProfile> mo301getSupportedDynamicRangeProfiles6Yu6yh8(String cameraColorSpace, int imageFormat) {
        Intrinsics.checkNotNullParameter(cameraColorSpace, "cameraColorSpace");
        return SetsKt.emptySet();
    }

    @Override // androidx.camera.camera2.pipe.CameraColorSpaceProfiles
    /* JADX INFO: renamed from: getSupportedColorSpacesForDynamicRange-sNWL0t8 */
    public Set<CameraColorSpace> mo300getSupportedColorSpacesForDynamicRangesNWL0t8(int imageFormat, long dynamicRangeProfile) {
        return SetsKt.emptySet();
    }
}

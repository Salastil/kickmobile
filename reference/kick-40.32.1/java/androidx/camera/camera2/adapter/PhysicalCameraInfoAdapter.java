package androidx.camera.camera2.adapter;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Range;
import androidx.camera.camera2.impl.CameraProperties;
import androidx.camera.camera2.interop.Camera2CameraInfo;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.UnsafeWrapper;
import androidx.camera.core.CameraIdentifier;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraState;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ExposureState;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.ZoomState;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: PhysicalCameraInfoAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015H\u0016J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0015H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u0010H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u0013H\u0017J\u0014\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100)0(H\u0016J\b\u0010*\u001a\u00020\u0013H\u0016J\b\u0010+\u001a\u00020\u0013H\u0016J\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020-0(2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0(H\u0016J\u000e\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00010(H\u0016J\b\u00100\u001a\u000201H\u0016J'\u00102\u001a\u0004\u0018\u0001H3\"\b\b\u0000\u00103*\u0002042\f\u00105\u001a\b\u0012\u0004\u0012\u0002H306H\u0017¢\u0006\u0002\u00107J\u0010\u00108\u001a\u00020\u00102\u0006\u00109\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0007\u001a\u00020\b8@X\u0081\u0084\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006:"}, d2 = {"Landroidx/camera/camera2/adapter/PhysicalCameraInfoAdapter;", "Landroidx/camera/core/CameraInfo;", "Landroidx/camera/camera2/pipe/UnsafeWrapper;", "cameraProperties", "Landroidx/camera/camera2/impl/CameraProperties;", "<init>", "(Landroidx/camera/camera2/impl/CameraProperties;)V", "camera2CameraInfo", "Landroidx/camera/camera2/interop/Camera2CameraInfo;", "getCamera2CameraInfo$camera_camera2$annotations", "()V", "getCamera2CameraInfo$camera_camera2", "()Landroidx/camera/camera2/interop/Camera2CameraInfo;", "camera2CameraInfo$delegate", "Lkotlin/Lazy;", "getSensorRotationDegrees", "", "relativeRotation", "hasFlashUnit", "", "getTorchState", "Landroidx/lifecycle/LiveData;", "getZoomState", "Landroidx/camera/core/ZoomState;", "getExposureState", "Landroidx/camera/core/ExposureState;", "getCameraState", "Landroidx/camera/core/CameraState;", "getImplementationType", "", "getCameraSelector", "Landroidx/camera/core/CameraSelector;", "getLensFacing", "getIntrinsicZoomRatio", "", "isFocusMeteringSupported", "action", "Landroidx/camera/core/FocusMeteringAction;", "isZslSupported", "getSupportedFrameRateRanges", "", "Landroid/util/Range;", "isLogicalMultiCameraSupported", "isPrivateReprocessingSupported", "querySupportedDynamicRanges", "Landroidx/camera/core/DynamicRange;", "candidateDynamicRanges", "getPhysicalCameraInfos", "getCameraIdentifier", "Landroidx/camera/core/CameraIdentifier;", "unwrapAs", ExifInterface.GPS_DIRECTION_TRUE, "", "type", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "getCameraSelectorLensFacing", "lensFacingInt", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PhysicalCameraInfoAdapter implements CameraInfo, UnsafeWrapper {

    /* JADX INFO: renamed from: camera2CameraInfo$delegate, reason: from kotlin metadata */
    private final Lazy camera2CameraInfo;
    private final CameraProperties cameraProperties;

    public static /* synthetic */ void getCamera2CameraInfo$camera_camera2$annotations() {
    }

    public PhysicalCameraInfoAdapter(CameraProperties cameraProperties) {
        Intrinsics.checkNotNullParameter(cameraProperties, "cameraProperties");
        this.cameraProperties = cameraProperties;
        this.camera2CameraInfo = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.adapter.PhysicalCameraInfoAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Camera2CameraInfo.INSTANCE.create(this.f$0.cameraProperties);
            }
        });
    }

    public final Camera2CameraInfo getCamera2CameraInfo$camera_camera2() {
        return (Camera2CameraInfo) this.camera2CameraInfo.getValue();
    }

    @Override // androidx.camera.core.CameraInfo
    public int getSensorRotationDegrees() {
        return getSensorRotationDegrees(0);
    }

    @Override // androidx.camera.core.CameraInfo
    public int getSensorRotationDegrees(int relativeRotation) {
        CameraMetadata metadata = this.cameraProperties.getMetadata();
        CameraCharacteristics.Key SENSOR_ORIENTATION = CameraCharacteristics.SENSOR_ORIENTATION;
        Intrinsics.checkNotNullExpressionValue(SENSOR_ORIENTATION, "SENSOR_ORIENTATION");
        Object obj = metadata.get((CameraCharacteristics.Key<Object>) SENSOR_ORIENTATION);
        Intrinsics.checkNotNull(obj);
        return CameraOrientationUtil.getRelativeImageRotation(CameraOrientationUtil.surfaceRotationToDegrees(relativeRotation), ((Number) obj).intValue(), 1 == getLensFacing());
    }

    @Override // androidx.camera.core.CameraInfo
    public boolean hasFlashUnit() {
        throw new UnsupportedOperationException("Physical camera doesn't support this function");
    }

    @Override // androidx.camera.core.CameraInfo
    public LiveData<Integer> getTorchState() {
        throw new UnsupportedOperationException("Physical camera doesn't support this function");
    }

    @Override // androidx.camera.core.CameraInfo
    public LiveData<ZoomState> getZoomState() {
        throw new UnsupportedOperationException("Physical camera doesn't support this function");
    }

    @Override // androidx.camera.core.CameraInfo
    public ExposureState getExposureState() {
        throw new UnsupportedOperationException("Physical camera doesn't support this function");
    }

    @Override // androidx.camera.core.CameraInfo
    public LiveData<CameraState> getCameraState() {
        throw new UnsupportedOperationException("Physical camera doesn't support this function");
    }

    @Override // androidx.camera.core.CameraInfo
    public String getImplementationType() {
        throw new UnsupportedOperationException("Physical camera doesn't support this function");
    }

    @Override // androidx.camera.core.CameraInfo
    public CameraSelector getCameraSelector() {
        throw new UnsupportedOperationException("Physical camera doesn't support this function");
    }

    @Override // androidx.camera.core.CameraInfo
    public int getLensFacing() {
        CameraMetadata metadata = this.cameraProperties.getMetadata();
        CameraCharacteristics.Key LENS_FACING = CameraCharacteristics.LENS_FACING;
        Intrinsics.checkNotNullExpressionValue(LENS_FACING, "LENS_FACING");
        Object obj = metadata.get((CameraCharacteristics.Key<Object>) LENS_FACING);
        Intrinsics.checkNotNull(obj);
        return getCameraSelectorLensFacing(((Number) obj).intValue());
    }

    @Override // androidx.camera.core.CameraInfo
    public float getIntrinsicZoomRatio() {
        throw new UnsupportedOperationException("Physical camera doesn't support this function");
    }

    @Override // androidx.camera.core.CameraInfo
    public boolean isFocusMeteringSupported(FocusMeteringAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        throw new UnsupportedOperationException("Physical camera doesn't support this function");
    }

    @Override // androidx.camera.core.CameraInfo
    public boolean isZslSupported() {
        throw new UnsupportedOperationException("Physical camera doesn't support this function");
    }

    @Override // androidx.camera.core.CameraInfo
    public Set<Range<Integer>> getSupportedFrameRateRanges() {
        throw new UnsupportedOperationException("Physical camera doesn't support this function");
    }

    @Override // androidx.camera.core.CameraInfo
    public boolean isLogicalMultiCameraSupported() {
        throw new UnsupportedOperationException("Physical camera doesn't support this function");
    }

    @Override // androidx.camera.core.CameraInfo
    public boolean isPrivateReprocessingSupported() {
        throw new UnsupportedOperationException("Physical camera doesn't support this function");
    }

    @Override // androidx.camera.core.CameraInfo
    public Set<DynamicRange> querySupportedDynamicRanges(Set<DynamicRange> candidateDynamicRanges) {
        Intrinsics.checkNotNullParameter(candidateDynamicRanges, "candidateDynamicRanges");
        throw new UnsupportedOperationException("Physical camera doesn't support this function");
    }

    @Override // androidx.camera.core.CameraInfo
    public Set<CameraInfo> getPhysicalCameraInfos() {
        throw new UnsupportedOperationException("Physical camera doesn't support this function");
    }

    @Override // androidx.camera.core.CameraInfo
    public CameraIdentifier getCameraIdentifier() {
        throw new UnsupportedOperationException("Physical camera doesn't support this function");
    }

    @Override // androidx.camera.camera2.pipe.UnsafeWrapper
    public <T> T unwrapAs(KClass<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(Camera2CameraInfo.class))) {
            Object camera2CameraInfo$camera_camera2 = getCamera2CameraInfo$camera_camera2();
            Intrinsics.checkNotNull(camera2CameraInfo$camera_camera2, "null cannot be cast to non-null type T of androidx.camera.camera2.adapter.PhysicalCameraInfoAdapter.unwrapAs");
            return (T) camera2CameraInfo$camera_camera2;
        }
        if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(CameraProperties.class))) {
            CameraProperties cameraProperties = this.cameraProperties;
            Intrinsics.checkNotNull(cameraProperties, "null cannot be cast to non-null type T of androidx.camera.camera2.adapter.PhysicalCameraInfoAdapter.unwrapAs");
            return (T) cameraProperties;
        }
        boolean zAreEqual = Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(android.hardware.camera2.CameraMetadata.class));
        CameraProperties cameraProperties2 = this.cameraProperties;
        if (zAreEqual) {
            CameraMetadata metadata = cameraProperties2.getMetadata();
            Intrinsics.checkNotNull(metadata, "null cannot be cast to non-null type T of androidx.camera.camera2.adapter.PhysicalCameraInfoAdapter.unwrapAs");
            return (T) metadata;
        }
        return (T) cameraProperties2.getMetadata().unwrapAs(type);
    }

    private final int getCameraSelectorLensFacing(int lensFacingInt) {
        if (lensFacingInt == 0) {
            return 0;
        }
        if (lensFacingInt == 1) {
            return 1;
        }
        if (lensFacingInt == 2) {
            return 2;
        }
        throw new IllegalArgumentException("The specified lens facing integer " + lensFacingInt + " can not be recognized.");
    }
}

package androidx.camera.camera2.adapter;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Range;
import android.util.Rational;
import androidx.camera.camera2.impl.CameraProperties;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.core.ExposureState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExposureStateAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/camera/camera2/adapter/ExposureStateAdapter;", "Landroidx/camera/core/ExposureState;", "cameraProperties", "Landroidx/camera/camera2/impl/CameraProperties;", "exposureCompensation", "", "<init>", "(Landroidx/camera/camera2/impl/CameraProperties;I)V", "isExposureCompensationSupported", "", "getExposureCompensationIndex", "getExposureCompensationStep", "Landroid/util/Rational;", "getExposureCompensationRange", "Landroid/util/Range;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExposureStateAdapter implements ExposureState {
    private final CameraProperties cameraProperties;
    private final int exposureCompensation;

    public ExposureStateAdapter(CameraProperties cameraProperties, int i) {
        Intrinsics.checkNotNullParameter(cameraProperties, "cameraProperties");
        this.cameraProperties = cameraProperties;
        this.exposureCompensation = i;
    }

    @Override // androidx.camera.core.ExposureState
    public boolean isExposureCompensationSupported() {
        Range<Integer> exposureCompensationRange = getExposureCompensationRange();
        Integer num = (Integer) exposureCompensationRange.getLower();
        if (num != null && num.intValue() == 0) {
            return false;
        }
        Integer num2 = (Integer) exposureCompensationRange.getUpper();
        return num2 == null || num2.intValue() != 0;
    }

    @Override // androidx.camera.core.ExposureState
    /* JADX INFO: renamed from: getExposureCompensationIndex, reason: from getter */
    public int getExposureCompensation() {
        return this.exposureCompensation;
    }

    @Override // androidx.camera.core.ExposureState
    public Rational getExposureCompensationStep() {
        if (!isExposureCompensationSupported()) {
            Rational ZERO = Rational.ZERO;
            Intrinsics.checkNotNullExpressionValue(ZERO, "ZERO");
            return ZERO;
        }
        CameraMetadata metadata = this.cameraProperties.getMetadata();
        CameraCharacteristics.Key CONTROL_AE_COMPENSATION_STEP = CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP;
        Intrinsics.checkNotNullExpressionValue(CONTROL_AE_COMPENSATION_STEP, "CONTROL_AE_COMPENSATION_STEP");
        Object obj = metadata.get((CameraCharacteristics.Key<Object>) CONTROL_AE_COMPENSATION_STEP);
        Intrinsics.checkNotNull(obj);
        return (Rational) obj;
    }

    @Override // androidx.camera.core.ExposureState
    public Range<Integer> getExposureCompensationRange() {
        CameraMetadata metadata = this.cameraProperties.getMetadata();
        CameraCharacteristics.Key CONTROL_AE_COMPENSATION_RANGE = CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE;
        Intrinsics.checkNotNullExpressionValue(CONTROL_AE_COMPENSATION_RANGE, "CONTROL_AE_COMPENSATION_RANGE");
        Range<Integer> range = (Range) metadata.get(CONTROL_AE_COMPENSATION_RANGE);
        return range == null ? ExposureStateAdapterKt.getEMPTY_RANGE() : range;
    }
}

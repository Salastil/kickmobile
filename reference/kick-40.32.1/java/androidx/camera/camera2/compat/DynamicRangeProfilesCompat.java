package androidx.camera.camera2.compat;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.DynamicRangeProfiles;
import android.os.Build;
import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.core.DynamicRange;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DynamicRangeProfilesCompat.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0002\u0011\u0012B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\bJ\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Landroidx/camera/camera2/compat/DynamicRangeProfilesCompat;", "", "impl", "Landroidx/camera/camera2/compat/DynamicRangeProfilesCompat$DynamicRangeProfilesCompatImpl;", "<init>", "(Landroidx/camera/camera2/compat/DynamicRangeProfilesCompat$DynamicRangeProfilesCompatImpl;)V", "supportedDynamicRanges", "", "Landroidx/camera/core/DynamicRange;", "getSupportedDynamicRanges", "()Ljava/util/Set;", "getDynamicRangeCaptureRequestConstraints", "dynamicRange", "isExtraLatencyPresent", "", "toDynamicRangeProfiles", "Landroid/hardware/camera2/params/DynamicRangeProfiles;", "DynamicRangeProfilesCompatImpl", "Companion", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DynamicRangeProfilesCompat {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DynamicRangeProfilesCompatImpl impl;

    /* JADX INFO: compiled from: DynamicRangeProfilesCompat.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\b\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0004H&J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/compat/DynamicRangeProfilesCompat$DynamicRangeProfilesCompatImpl;", "", "supportedDynamicRanges", "", "Landroidx/camera/core/DynamicRange;", "getSupportedDynamicRanges", "()Ljava/util/Set;", "getDynamicRangeCaptureRequestConstraints", "dynamicRange", "isExtraLatencyPresent", "", "unwrap", "Landroid/hardware/camera2/params/DynamicRangeProfiles;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface DynamicRangeProfilesCompatImpl {
        Set<DynamicRange> getDynamicRangeCaptureRequestConstraints(DynamicRange dynamicRange);

        Set<DynamicRange> getSupportedDynamicRanges();

        boolean isExtraLatencyPresent(DynamicRange dynamicRange);

        /* JADX INFO: renamed from: unwrap */
        DynamicRangeProfiles getDynamicRangeProfiles();
    }

    public DynamicRangeProfilesCompat(DynamicRangeProfilesCompatImpl impl) {
        Intrinsics.checkNotNullParameter(impl, "impl");
        this.impl = impl;
    }

    public final Set<DynamicRange> getSupportedDynamicRanges() {
        return this.impl.getSupportedDynamicRanges();
    }

    public final Set<DynamicRange> getDynamicRangeCaptureRequestConstraints(DynamicRange dynamicRange) {
        Intrinsics.checkNotNullParameter(dynamicRange, "dynamicRange");
        return this.impl.getDynamicRangeCaptureRequestConstraints(dynamicRange);
    }

    public final boolean isExtraLatencyPresent(DynamicRange dynamicRange) {
        Intrinsics.checkNotNullParameter(dynamicRange, "dynamicRange");
        return this.impl.isExtraLatencyPresent(dynamicRange);
    }

    /* JADX INFO: compiled from: DynamicRangeProfilesCompat.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007¨\u0006\u000b"}, d2 = {"Landroidx/camera/camera2/compat/DynamicRangeProfilesCompat$Companion;", "", "<init>", "()V", "fromCameraMetaData", "Landroidx/camera/camera2/compat/DynamicRangeProfilesCompat;", "cameraMetadata", "Landroidx/camera/camera2/pipe/CameraMetadata;", "toDynamicRangesCompat", "dynamicRangeProfiles", "Landroid/hardware/camera2/params/DynamicRangeProfiles;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DynamicRangeProfilesCompat fromCameraMetaData(CameraMetadata cameraMetadata) {
            DynamicRangeProfilesCompat dynamicRangesCompat;
            Intrinsics.checkNotNullParameter(cameraMetadata, "cameraMetadata");
            if (Build.VERSION.SDK_INT >= 33) {
                CameraCharacteristics.Key REQUEST_AVAILABLE_DYNAMIC_RANGE_PROFILES = CameraCharacteristics.REQUEST_AVAILABLE_DYNAMIC_RANGE_PROFILES;
                Intrinsics.checkNotNullExpressionValue(REQUEST_AVAILABLE_DYNAMIC_RANGE_PROFILES, "REQUEST_AVAILABLE_DYNAMIC_RANGE_PROFILES");
                dynamicRangesCompat = toDynamicRangesCompat(ComponentDialog$$ExternalSyntheticApiModelOutline0.m14m(cameraMetadata.get(REQUEST_AVAILABLE_DYNAMIC_RANGE_PROFILES)));
            } else {
                dynamicRangesCompat = null;
            }
            return dynamicRangesCompat == null ? DynamicRangeProfilesCompatBaseImpl.INSTANCE.getCOMPAT_INSTANCE() : dynamicRangesCompat;
        }

        public final DynamicRangeProfilesCompat toDynamicRangesCompat(DynamicRangeProfiles dynamicRangeProfiles) {
            if (dynamicRangeProfiles == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                return new DynamicRangeProfilesCompat(new DynamicRangeProfilesCompatApi33Impl(dynamicRangeProfiles));
            }
            throw new IllegalStateException(("DynamicRangeProfiles can only be converted to DynamicRangesCompat on API 33 or higher. is not supported on API " + Build.VERSION.SDK_INT + " (requires API 33)").toString());
        }
    }

    public final DynamicRangeProfiles toDynamicRangeProfiles() {
        if (Build.VERSION.SDK_INT >= 33) {
            return this.impl.getDynamicRangeProfiles();
        }
        throw new IllegalStateException(("DynamicRangesCompat can only be converted to DynamicRangeProfiles on API 33 or higher. is not supported on API " + Build.VERSION.SDK_INT + " (requires API 33)").toString());
    }
}

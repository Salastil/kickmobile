package androidx.camera.camera2.compat;

import android.hardware.camera2.params.DynamicRangeProfiles;
import androidx.camera.core.DynamicRange;
import androidx.core.util.Preconditions;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DynamicRangeProfilesCompatBaseImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0006H\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Landroidx/camera/camera2/compat/DynamicRangeProfilesCompatBaseImpl;", "Landroidx/camera/camera2/compat/DynamicRangeProfilesCompat$DynamicRangeProfilesCompatImpl;", "<init>", "()V", "supportedDynamicRanges", "", "Landroidx/camera/core/DynamicRange;", "getSupportedDynamicRanges", "()Ljava/util/Set;", "getDynamicRangeCaptureRequestConstraints", "dynamicRange", "isExtraLatencyPresent", "", "unwrap", "Landroid/hardware/camera2/params/DynamicRangeProfiles;", "Companion", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DynamicRangeProfilesCompatBaseImpl implements DynamicRangeProfilesCompat.DynamicRangeProfilesCompatImpl {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final DynamicRangeProfilesCompat COMPAT_INSTANCE = new DynamicRangeProfilesCompat(new DynamicRangeProfilesCompatBaseImpl());
    private static final Set<DynamicRange> SDR_ONLY = SetsKt.setOf(DynamicRange.SDR);

    @Override // androidx.camera.camera2.compat.DynamicRangeProfilesCompat.DynamicRangeProfilesCompatImpl
    /* JADX INFO: renamed from: unwrap */
    public DynamicRangeProfiles getDynamicRangeProfiles() {
        return null;
    }

    @Override // androidx.camera.camera2.compat.DynamicRangeProfilesCompat.DynamicRangeProfilesCompatImpl
    public Set<DynamicRange> getSupportedDynamicRanges() {
        return SDR_ONLY;
    }

    @Override // androidx.camera.camera2.compat.DynamicRangeProfilesCompat.DynamicRangeProfilesCompatImpl
    public Set<DynamicRange> getDynamicRangeCaptureRequestConstraints(DynamicRange dynamicRange) {
        Intrinsics.checkNotNullParameter(dynamicRange, "dynamicRange");
        Preconditions.checkArgument(Intrinsics.areEqual(DynamicRange.SDR, dynamicRange), "DynamicRange is not supported: " + dynamicRange);
        return SDR_ONLY;
    }

    @Override // androidx.camera.camera2.compat.DynamicRangeProfilesCompat.DynamicRangeProfilesCompatImpl
    public boolean isExtraLatencyPresent(DynamicRange dynamicRange) {
        Intrinsics.checkNotNullParameter(dynamicRange, "dynamicRange");
        Preconditions.checkArgument(Intrinsics.areEqual(DynamicRange.SDR, dynamicRange), "DynamicRange is not supported: " + dynamicRange);
        return false;
    }

    /* JADX INFO: compiled from: DynamicRangeProfilesCompatBaseImpl.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u0012\u0012\u000e\u0012\f0\n¢\u0006\u0002\b\u000b¢\u0006\u0002\b\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/camera/camera2/compat/DynamicRangeProfilesCompatBaseImpl$Companion;", "", "<init>", "()V", "COMPAT_INSTANCE", "Landroidx/camera/camera2/compat/DynamicRangeProfilesCompat;", "getCOMPAT_INSTANCE", "()Landroidx/camera/camera2/compat/DynamicRangeProfilesCompat;", "SDR_ONLY", "", "Landroidx/camera/core/DynamicRange;", "Lorg/jspecify/annotations/NonNull;", "Lkotlin/jvm/internal/EnhancedNullability;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DynamicRangeProfilesCompat getCOMPAT_INSTANCE() {
            return DynamicRangeProfilesCompatBaseImpl.COMPAT_INSTANCE;
        }
    }
}

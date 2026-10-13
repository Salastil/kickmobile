package androidx.camera.camera2.adapter;

import android.util.Range;
import android.util.Rational;
import androidx.camera.core.ExposureState;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EvCompValue.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0005H\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\u0015\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0012J\t\u0010\u0013\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÂ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÂ\u0003J\t\u0010\u0016\u001a\u00020\tHÂ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/camera/camera2/adapter/EvCompValue;", "Landroidx/camera/core/ExposureState;", "supported", "", FirebaseAnalytics.Param.INDEX, "", "range", "Landroid/util/Range;", "step", "Landroid/util/Rational;", "<init>", "(ZILandroid/util/Range;Landroid/util/Rational;)V", "getExposureCompensationIndex", "getExposureCompensationRange", "getExposureCompensationStep", "isExposureCompensationSupported", "updateIndex", "newIndex", "updateIndex$camera_camera2", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class EvCompValue implements ExposureState {
    private final int index;
    private final Range<Integer> range;
    private final Rational step;
    private final boolean supported;

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final boolean getSupported() {
        return this.supported;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final int getIndex() {
        return this.index;
    }

    private final Range<Integer> component3() {
        return this.range;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    private final Rational getStep() {
        return this.step;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EvCompValue copy$default(EvCompValue evCompValue, boolean z, int i, Range range, Rational rational, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = evCompValue.supported;
        }
        if ((i2 & 2) != 0) {
            i = evCompValue.index;
        }
        if ((i2 & 4) != 0) {
            range = evCompValue.range;
        }
        if ((i2 & 8) != 0) {
            rational = evCompValue.step;
        }
        return evCompValue.copy(z, i, range, rational);
    }

    public final EvCompValue copy(boolean supported, int index, Range<Integer> range, Rational step) {
        Intrinsics.checkNotNullParameter(range, "range");
        Intrinsics.checkNotNullParameter(step, "step");
        return new EvCompValue(supported, index, range, step);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EvCompValue)) {
            return false;
        }
        EvCompValue evCompValue = (EvCompValue) other;
        return this.supported == evCompValue.supported && this.index == evCompValue.index && Intrinsics.areEqual(this.range, evCompValue.range) && Intrinsics.areEqual(this.step, evCompValue.step);
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.supported) * 31) + Integer.hashCode(this.index)) * 31) + this.range.hashCode()) * 31) + this.step.hashCode();
    }

    public String toString() {
        return "EvCompValue(supported=" + this.supported + ", index=" + this.index + ", range=" + this.range + ", step=" + this.step + ')';
    }

    public EvCompValue(boolean z, int i, Range<Integer> range, Rational step) {
        Intrinsics.checkNotNullParameter(range, "range");
        Intrinsics.checkNotNullParameter(step, "step");
        this.supported = z;
        this.index = i;
        this.range = range;
        this.step = step;
    }

    @Override // androidx.camera.core.ExposureState
    public int getExposureCompensationIndex() {
        return this.index;
    }

    @Override // androidx.camera.core.ExposureState
    public Range<Integer> getExposureCompensationRange() {
        return this.range;
    }

    @Override // androidx.camera.core.ExposureState
    public Rational getExposureCompensationStep() {
        return this.step;
    }

    @Override // androidx.camera.core.ExposureState
    public boolean isExposureCompensationSupported() {
        return this.supported;
    }

    public final EvCompValue updateIndex$camera_camera2(int newIndex) {
        return copy$default(this, false, newIndex, null, null, 13, null);
    }
}

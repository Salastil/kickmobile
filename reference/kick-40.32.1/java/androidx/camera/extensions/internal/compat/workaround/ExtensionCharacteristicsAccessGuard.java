package androidx.camera.extensions.internal.compat.workaround;

import androidx.camera.extensions.internal.compat.quirk.AvoidCaptureProcessProgressAvailabilityCheckQuirk;
import androidx.camera.extensions.internal.compat.quirk.AvoidPostviewAvailabilityCheckQuirk;
import androidx.camera.extensions.internal.compat.quirk.DeviceQuirks;
import kotlin.Metadata;

/* JADX INFO: compiled from: ExtensionCharacteristicsAccessGuard.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/camera/extensions/internal/compat/workaround/ExtensionCharacteristicsAccessGuard;", "", "<init>", "()V", "avoidPostviewAvailabilityCheckQuirk", "Landroidx/camera/extensions/internal/compat/quirk/AvoidPostviewAvailabilityCheckQuirk;", "avoidCaptureProcessProgressAvailabilityCheckQuirk", "Landroidx/camera/extensions/internal/compat/quirk/AvoidCaptureProcessProgressAvailabilityCheckQuirk;", "allowPostviewAvailabilityCheck", "", "allowCaptureProcessProgressAvailabilityCheck", "camera-extensions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExtensionCharacteristicsAccessGuard {
    private final AvoidPostviewAvailabilityCheckQuirk avoidPostviewAvailabilityCheckQuirk = (AvoidPostviewAvailabilityCheckQuirk) DeviceQuirks.get(AvoidPostviewAvailabilityCheckQuirk.class);
    private final AvoidCaptureProcessProgressAvailabilityCheckQuirk avoidCaptureProcessProgressAvailabilityCheckQuirk = (AvoidCaptureProcessProgressAvailabilityCheckQuirk) DeviceQuirks.get(AvoidCaptureProcessProgressAvailabilityCheckQuirk.class);

    public final boolean allowPostviewAvailabilityCheck() {
        return this.avoidPostviewAvailabilityCheckQuirk == null;
    }

    public final boolean allowCaptureProcessProgressAvailabilityCheck() {
        return this.avoidCaptureProcessProgressAvailabilityCheckQuirk == null;
    }
}

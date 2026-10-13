package androidx.camera.extensions.internal.compat.quirk;

import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.QuirkSettings;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DeviceQuirksLoader {
    private DeviceQuirksLoader() {
    }

    static List<Quirk> loadQuirks(QuirkSettings quirkSettings) {
        ArrayList arrayList = new ArrayList();
        if (quirkSettings.shouldEnableQuirk(EnsurePostviewFormatEquivalenceQuirk.class, EnsurePostviewFormatEquivalenceQuirk.load())) {
            arrayList.add(new EnsurePostviewFormatEquivalenceQuirk());
        }
        if (quirkSettings.shouldEnableQuirk(AvoidPostviewAvailabilityCheckQuirk.class, AvoidPostviewAvailabilityCheckQuirk.load())) {
            arrayList.add(new AvoidPostviewAvailabilityCheckQuirk());
        }
        if (quirkSettings.shouldEnableQuirk(AvoidCaptureProcessProgressAvailabilityCheckQuirk.class, AvoidCaptureProcessProgressAvailabilityCheckQuirk.load())) {
            arrayList.add(new AvoidCaptureProcessProgressAvailabilityCheckQuirk());
        }
        return arrayList;
    }
}

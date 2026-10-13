package androidx.camera.viewfinder.core.impl;

import android.os.Build;
import androidx.camera.viewfinder.core.ImplementationMode;
import androidx.camera.viewfinder.core.impl.quirk.DeviceQuirks;
import androidx.camera.viewfinder.core.impl.quirk.Quirk;
import androidx.camera.viewfinder.core.impl.quirk.SurfaceViewNotCroppedByParentQuirk;
import androidx.camera.viewfinder.core.impl.quirk.SurfaceViewStretchedQuirk;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ImplementationModeCompat.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/camera/viewfinder/core/impl/ImplementationModeCompat;", "", "<init>", "()V", "Companion", "viewfinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImplementationModeCompat {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmStatic
    public static final ImplementationMode chooseCompatibleMode() {
        return INSTANCE.chooseCompatibleMode();
    }

    /* JADX INFO: compiled from: ImplementationModeCompat.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Landroidx/camera/viewfinder/core/impl/ImplementationModeCompat$Companion;", "", "<init>", "()V", "chooseCompatibleMode", "Landroidx/camera/viewfinder/core/ImplementationMode;", "viewfinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:20:0x004f  */
        /* JADX WARN: Code duplicated, block: B:23:0x0059  */
        /* JADX WARN: Code duplicated, block: B:31:0x0067 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:32:? A[LOOP:0: B:21:0x0053->B:32:?, LOOP_END, SYNTHETIC] */
        @JvmStatic
        public final ImplementationMode chooseCompatibleMode() {
            List list;
            Iterator it;
            if (Build.VERSION.SDK_INT > 24) {
                DeviceQuirks deviceQuirks = DeviceQuirks.INSTANCE;
                List list2 = DeviceQuirks.QUIRKS.quirks;
                if ((list2 instanceof Collection) && list2.isEmpty()) {
                    DeviceQuirks deviceQuirks2 = DeviceQuirks.INSTANCE;
                    list = DeviceQuirks.QUIRKS.quirks;
                    if (list instanceof Collection) {
                        it = list.iterator();
                        while (it.hasNext()) {
                            if (((Quirk) it.next()) instanceof SurfaceViewNotCroppedByParentQuirk) {
                            }
                        }
                    } else {
                        it = list.iterator();
                        while (it.hasNext()) {
                            if (((Quirk) it.next()) instanceof SurfaceViewNotCroppedByParentQuirk) {
                            }
                        }
                    }
                    return ImplementationMode.EXTERNAL;
                }
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    if (((Quirk) it2.next()) instanceof SurfaceViewStretchedQuirk) {
                    }
                }
                DeviceQuirks deviceQuirks3 = DeviceQuirks.INSTANCE;
                list = DeviceQuirks.QUIRKS.quirks;
                if ((list instanceof Collection) || !list.isEmpty()) {
                    it = list.iterator();
                    while (it.hasNext()) {
                        if (((Quirk) it.next()) instanceof SurfaceViewNotCroppedByParentQuirk) {
                        }
                    }
                }
                return ImplementationMode.EXTERNAL;
            }
            return ImplementationMode.EMBEDDED;
        }
    }
}

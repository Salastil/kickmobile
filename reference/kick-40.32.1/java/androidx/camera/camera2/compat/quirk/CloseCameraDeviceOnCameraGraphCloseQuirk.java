package androidx.camera.camera2.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CloseCameraDeviceOnCameraGraphCloseQuirk.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\b"}, d2 = {"Landroidx/camera/camera2/compat/quirk/CloseCameraDeviceOnCameraGraphCloseQuirk;", "Landroidx/camera/core/impl/Quirk;", "<init>", "()V", "shouldCloseCameraDevice", "", "isExtensions", "Companion", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CloseCameraDeviceOnCameraGraphCloseQuirk implements Quirk {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final boolean isSamsungExynos7570Device = Intrinsics.areEqual(Build.HARDWARE, "samsungexynos7570");
    private static final boolean isSamsungExynos7870Device = Intrinsics.areEqual(Build.HARDWARE, "samsungexynos7870");
    private static final boolean isSamsungProblematicDevice;
    private static final boolean isSonyProblematicDevice;
    private static final boolean isXiaomiProblematicDevice;

    @JvmStatic
    public static final boolean isEnabled() {
        return INSTANCE.isEnabled();
    }

    public final boolean shouldCloseCameraDevice(boolean isExtensions) {
        if (isXiaomiProblematicDevice || !(!isSamsungProblematicDevice || isSamsungExynos7570Device || isSamsungExynos7870Device)) {
            return isExtensions;
        }
        return true;
    }

    /* JADX INFO: compiled from: CloseCameraDeviceOnCameraGraphCloseQuirk.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/camera/camera2/compat/quirk/CloseCameraDeviceOnCameraGraphCloseQuirk$Companion;", "", "<init>", "()V", "isEnabled", "", "isSamsungExynos7570Device", "isSamsungExynos7870Device", "isXiaomiProblematicDevice", "isSonyProblematicDevice", "isSamsungProblematicDevice", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final boolean isEnabled() {
            if (CloseCameraDeviceOnCameraGraphCloseQuirk.isSamsungExynos7570Device || CloseCameraDeviceOnCameraGraphCloseQuirk.isSamsungExynos7870Device) {
                return true;
            }
            int i = Build.VERSION.SDK_INT;
            return (30 <= i && i < 34 && (Device.INSTANCE.isOppoDevice() || Device.INSTANCE.isOnePlusDevice() || Device.INSTANCE.isRealmeDevice())) || Device.INSTANCE.isVivoDevice() || CloseCameraDeviceOnCameraGraphCloseQuirk.isXiaomiProblematicDevice || CloseCameraDeviceOnCameraGraphCloseQuirk.isSamsungProblematicDevice || CloseCameraDeviceOnCameraGraphCloseQuirk.isSonyProblematicDevice;
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x008f A[EDGE_INSN: B:21:0x008f->B:22:0x0090 BREAK  A[LOOP:0: B:16:0x0076->B:33:?]] */
    /* JADX WARN: Code duplicated, block: B:7:0x0049  */
    static {
        boolean z;
        boolean z2;
        boolean z3 = false;
        if (Device.INSTANCE.isXiaomiDevice()) {
            String DEVICE = Build.DEVICE;
            Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
            String lowerCase = DEVICE.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (ArraysKt.contains(new String[]{"aurora", "houji"}, lowerCase)) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        isXiaomiProblematicDevice = z;
        if (!Device.INSTANCE.isSonyDevice()) {
            z2 = false;
            break;
        }
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{"XQ-DQ", "SO", "A301SO"});
        if (!(listListOf instanceof Collection) || !listListOf.isEmpty()) {
            Iterator it = listListOf.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                String str = (String) it.next();
                String DEVICE2 = Build.DEVICE;
                Intrinsics.checkNotNullExpressionValue(DEVICE2, "DEVICE");
                if (StringsKt.startsWith(DEVICE2, str, true)) {
                    z2 = true;
                    break;
                }
            }
        } else {
            z2 = false;
            break;
        }
        isSonyProblematicDevice = z2;
        if (Device.INSTANCE.isSamsungDevice() && Build.VERSION.SDK_INT >= 31 && Build.VERSION.SDK_INT <= 34) {
            z3 = true;
        }
        isSamsungProblematicDevice = z3;
    }
}

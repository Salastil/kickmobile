package androidx.camera.camera2.compat.workaround;

import android.util.Size;
import androidx.camera.camera2.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.compat.quirk.RepeatingStreamConstraintForVideoRecordingQuirk;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import java.util.ArrayList;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SupportedRepeatingSurfaceSize.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a\u001b\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006*\b\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\u0010\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001e\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0003j\b\u0012\u0004\u0012\u00020\u0001`\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"MINI_PREVIEW_SIZE_HUAWEI_MATE_9", "Landroid/util/Size;", "SIZE_COMPARATOR", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "getSupportedRepeatingSurfaceSizes", "", "([Landroid/util/Size;)[Landroid/util/Size;", "camera-camera2"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SupportedRepeatingSurfaceSizeKt {
    private static final Size MINI_PREVIEW_SIZE_HUAWEI_MATE_9 = new Size(320, 240);
    private static final Comparator<Size> SIZE_COMPARATOR = new CompareSizesByArea();

    public static final Size[] getSupportedRepeatingSurfaceSizes(Size[] sizeArr) {
        Intrinsics.checkNotNullParameter(sizeArr, "<this>");
        if (((RepeatingStreamConstraintForVideoRecordingQuirk) DeviceQuirks.INSTANCE.get(RepeatingStreamConstraintForVideoRecordingQuirk.class)) == null) {
            return sizeArr;
        }
        ArrayList arrayList = new ArrayList();
        for (Size size : sizeArr) {
            if (SIZE_COMPARATOR.compare(size, MINI_PREVIEW_SIZE_HUAWEI_MATE_9) >= 0) {
                arrayList.add(size);
            }
        }
        return (Size[]) arrayList.toArray(new Size[0]);
    }
}

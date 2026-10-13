package androidx.camera.camera2.compat.quirk;

import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.util.Size;
import androidx.camera.core.impl.Quirk;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ExtraSupportedOutputSizeQuirk.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ%\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\"\u0004\b\u0000\u0010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\f¢\u0006\u0002\u0010\rR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Landroidx/camera/camera2/compat/quirk/ExtraSupportedOutputSizeQuirk;", "Landroidx/camera/core/impl/Quirk;", "<init>", "()V", "getExtraSupportedResolutions", "", "Landroid/util/Size;", "format", "", "(I)[Landroid/util/Size;", ExifInterface.GPS_DIRECTION_TRUE, "klass", "Ljava/lang/Class;", "(Ljava/lang/Class;)[Landroid/util/Size;", "motoE5PlayExtraSupportedResolutions", "getMotoE5PlayExtraSupportedResolutions", "()[Landroid/util/Size;", "Companion", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExtraSupportedOutputSizeQuirk implements Quirk {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public final Size[] getExtraSupportedResolutions(int format) {
        return (format == 34 && INSTANCE.isMotoE5Play$camera_camera2()) ? getMotoE5PlayExtraSupportedResolutions() : new Size[0];
    }

    public final <T> Size[] getExtraSupportedResolutions(Class<T> klass) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        return (StreamConfigurationMap.isOutputSupportedFor(klass) && INSTANCE.isMotoE5Play$camera_camera2()) ? getMotoE5PlayExtraSupportedResolutions() : new Size[0];
    }

    private final Size[] getMotoE5PlayExtraSupportedResolutions() {
        return new Size[]{new Size(1440, 1080), new Size(960, 720)};
    }

    /* JADX INFO: compiled from: ExtraSupportedOutputSizeQuirk.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005R\u0014\u0010\u0006\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/camera/camera2/compat/quirk/ExtraSupportedOutputSizeQuirk$Companion;", "", "<init>", "()V", "isEnabled", "", "isMotoE5Play", "isMotoE5Play$camera_camera2", "()Z", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isEnabled() {
            return isMotoE5Play$camera_camera2();
        }

        public final boolean isMotoE5Play$camera_camera2() {
            return Device.INSTANCE.isMotorolaDevice() && StringsKt.equals("moto e5 play", Build.MODEL, true);
        }
    }
}

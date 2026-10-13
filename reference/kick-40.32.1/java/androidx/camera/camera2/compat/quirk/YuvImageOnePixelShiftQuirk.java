package androidx.camera.camera2.compat.quirk;

import android.os.Build;
import androidx.camera.core.internal.compat.quirk.OnePixelShiftQuirk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: YuvImageOnePixelShiftQuirk.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/camera/camera2/compat/quirk/YuvImageOnePixelShiftQuirk;", "Landroidx/camera/core/internal/compat/quirk/OnePixelShiftQuirk;", "<init>", "()V", "Companion", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class YuvImageOnePixelShiftQuirk implements OnePixelShiftQuirk {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: YuvImageOnePixelShiftQuirk.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002¨\u0006\f"}, d2 = {"Landroidx/camera/camera2/compat/quirk/YuvImageOnePixelShiftQuirk$Companion;", "", "<init>", "()V", "isEnabled", "", "isMotorolaMotoG3", "isSamsungSMG532F", "isSamsungSMJ700F", "isSamsungSMJ415F", "isSamsungSMA920F", "isXiaomiMiA1", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isEnabled() {
            return isMotorolaMotoG3() || isSamsungSMG532F() || isSamsungSMJ700F() || isSamsungSMA920F() || isSamsungSMJ415F() || isXiaomiMiA1();
        }

        private final boolean isMotorolaMotoG3() {
            return Device.INSTANCE.isMotorolaDevice() && StringsKt.equals("MotoG3", Build.MODEL, true);
        }

        private final boolean isSamsungSMG532F() {
            return Device.INSTANCE.isSamsungDevice() && StringsKt.equals("SM-G532F", Build.MODEL, true);
        }

        private final boolean isSamsungSMJ700F() {
            return Device.INSTANCE.isSamsungDevice() && StringsKt.equals("SM-J700F", Build.MODEL, true);
        }

        private final boolean isSamsungSMJ415F() {
            return Device.INSTANCE.isSamsungDevice() && StringsKt.equals("SM-J415F", Build.MODEL, true);
        }

        private final boolean isSamsungSMA920F() {
            return Device.INSTANCE.isSamsungDevice() && StringsKt.equals("SM-A920F", Build.MODEL, true);
        }

        private final boolean isXiaomiMiA1() {
            return Device.INSTANCE.isXiaomiDevice() && StringsKt.equals("Mi A1", Build.MODEL, true);
        }
    }
}

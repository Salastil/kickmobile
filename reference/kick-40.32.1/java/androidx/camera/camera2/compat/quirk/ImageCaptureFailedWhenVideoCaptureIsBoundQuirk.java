package androidx.camera.camera2.compat.quirk;

import android.os.Build;
import androidx.camera.core.internal.compat.quirk.SurfaceProcessingQuirk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ImageCaptureFailedWhenVideoCaptureIsBoundQuirk.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \b2\u00020\u00012\u00020\u0002:\u0001\bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"Landroidx/camera/camera2/compat/quirk/ImageCaptureFailedWhenVideoCaptureIsBoundQuirk;", "Landroidx/camera/camera2/compat/quirk/CaptureIntentPreviewQuirk;", "Landroidx/camera/core/internal/compat/quirk/SurfaceProcessingQuirk;", "<init>", "()V", "workaroundByCaptureIntentPreview", "", "workaroundBySurfaceProcessing", "Companion", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageCaptureFailedWhenVideoCaptureIsBoundQuirk implements CaptureIntentPreviewQuirk, SurfaceProcessingQuirk {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: ImageCaptureFailedWhenVideoCaptureIsBoundQuirk.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u000f"}, d2 = {"Landroidx/camera/camera2/compat/quirk/ImageCaptureFailedWhenVideoCaptureIsBoundQuirk$Companion;", "", "<init>", "()V", "isEnabled", "", "isBluStudioX10", "()Z", "isItelW6004", "isVivo1805", "isPositivoTwist2Pro", "isPixel4XLApi29", "isMotoE13", "isSamsungTabA8", "isSamsungA53", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isEnabled() {
            return isBluStudioX10() || isItelW6004() || isVivo1805() || isPositivoTwist2Pro() || isPixel4XLApi29() || isMotoE13() || isSamsungTabA8() || isSamsungA53() || Device.INSTANCE.isUniSocChipsetDevice();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isBluStudioX10() {
            return Device.INSTANCE.isBluDevice() && StringsKt.equals("studio x10", Build.MODEL, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isItelW6004() {
            return Device.INSTANCE.isItelDevice() && StringsKt.equals("itel w6004", Build.MODEL, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isVivo1805() {
            return Device.INSTANCE.isVivoDevice() && StringsKt.equals("vivo 1805", Build.MODEL, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isPositivoTwist2Pro() {
            return Device.INSTANCE.isPositivoDevice() && StringsKt.equals("twist 2 pro", Build.MODEL, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isPixel4XLApi29() {
            return StringsKt.equals("pixel 4 xl", Build.MODEL, true) && Build.VERSION.SDK_INT == 29;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isMotoE13() {
            return Device.INSTANCE.isMotorolaDevice() && StringsKt.equals("moto e13", Build.MODEL, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isSamsungTabA8() {
            if (Device.INSTANCE.isSamsungDevice()) {
                return StringsKt.equals("gta8", Build.DEVICE, true) || StringsKt.equals("gta8wifi", Build.DEVICE, true);
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isSamsungA53() {
            if (Device.INSTANCE.isSamsungDevice()) {
                String MODEL = Build.MODEL;
                Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                if (StringsKt.startsWith$default(MODEL, "SM-A536", false, 2, (Object) null)) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override // androidx.camera.camera2.compat.quirk.CaptureIntentPreviewQuirk
    public boolean workaroundByCaptureIntentPreview() {
        Companion companion = INSTANCE;
        return companion.isBluStudioX10() || companion.isItelW6004() || companion.isVivo1805() || companion.isPositivoTwist2Pro();
    }

    @Override // androidx.camera.core.internal.compat.quirk.SurfaceProcessingQuirk
    public boolean workaroundBySurfaceProcessing() {
        Companion companion = INSTANCE;
        return companion.isBluStudioX10() || companion.isItelW6004() || companion.isVivo1805() || companion.isPositivoTwist2Pro() || companion.isPixel4XLApi29() || companion.isMotoE13() || companion.isSamsungTabA8() || companion.isSamsungA53() || Device.INSTANCE.isUniSocChipsetDevice();
    }
}

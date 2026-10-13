package androidx.camera.camera2.compat.workaround;

import android.hardware.camera2.CaptureRequest;
import android.util.Rational;
import android.util.Size;
import androidx.camera.camera2.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.compat.quirk.PreviewPixelHDRnetQuirk;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.core.impl.SessionConfig;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewPixelHDRnet.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"ASPECT_RATIO_16_9", "Landroid/util/Rational;", "setupHDRnet", "", "Landroidx/camera/core/impl/SessionConfig$Builder;", "resolution", "Landroid/util/Size;", "isAspectRatioMatch", "", ViewProps.ASPECT_RATIO, "camera-camera2"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class PreviewPixelHDRnetKt {
    private static final Rational ASPECT_RATIO_16_9 = new Rational(16, 9);

    public static final void setupHDRnet(SessionConfig.Builder builder, Size resolution) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(resolution, "resolution");
        if (((PreviewPixelHDRnetQuirk) DeviceQuirks.INSTANCE.get(PreviewPixelHDRnetQuirk.class)) == null || isAspectRatioMatch(resolution, ASPECT_RATIO_16_9)) {
            return;
        }
        Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
        CaptureRequest.Key TONEMAP_MODE = CaptureRequest.TONEMAP_MODE;
        Intrinsics.checkNotNullExpressionValue(TONEMAP_MODE, "TONEMAP_MODE");
        builder2.setCaptureRequestOption(TONEMAP_MODE, 2);
        builder.addImplementationOptions(builder2.build());
    }

    private static final boolean isAspectRatioMatch(Size size, Rational rational) {
        return Intrinsics.areEqual(rational, new Rational(size.getWidth(), size.getHeight()));
    }
}
